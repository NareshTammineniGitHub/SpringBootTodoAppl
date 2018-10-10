package com.naresh.springboot.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.naresh.springboot.web.model.Todo;
import com.naresh.springboot.web.service.TodoService;


@Controller
@SessionAttributes("name")
public class TodoController {
	
	@Autowired
	TodoService service;
	
	@InitBinder
	
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	 public String showListTodos( ModelMap model) {
		String name = getLoggedInUserName(model);	
		model.put("todos", service.retrieveTodos(name));
		 return "list-todos";
	 }
	
	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showAddTodoPage(ModelMap model) {
		model.addAttribute("todo", new Todo(0, getLoggedInUserName(model), "", new Date(), false));
		return "todo";
	}
	
//	@RequestMapping(value = "/todo", method = RequestMethod.POST)
//	public String addTodos(ModelMap model, @RequestParam String desc) {
//		service.addTodo("naresh", desc, new Date(), true);
//		return "redirect:/list-todos";
//	} 

	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodos(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		service.addTodo("naresh", todo.getDesc(), todo.getTargetDate(), true);
		showListTodos(model);
		return "list-todos";
	} 

	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		Todo todo =  service.retrieveTodo(id);
		model.put("todo", todo);
		return "todo";
	} 
	
	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodo(@Valid Todo todo, BindingResult result, ModelMap model) {
		
		if(result.hasErrors()) {
			return "todo";
		}
		todo.setUser(getLoggedInUserName(model));
		service.updateTodo(todo);
		return "redirect:/list-todos";
	} 

	
	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		service.deleteTodo(id);
		return "redirect:/list-todos";
	} 
	
	private String getLoggedInUserName(ModelMap model) {
//		return model.get("name").toString();
		return WelcomeController.getLoggedInUserName();
	}
	
}
