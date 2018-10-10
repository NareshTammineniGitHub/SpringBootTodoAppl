package com.naresh.springboot.web.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.naresh.springboot.web.model.Todo;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<Todo>();
	private static int todoCount = 3;
	
	static {
		todos.add(new Todo(1, "naresh", "Learn Spring MVC", new Date(), false));
		todos.add(new Todo(2, "naresh", "Learn Spring", new Date(), false));
		todos.add(new Todo(3, "naresh", "Learn Struts", new Date(), false));
	}
	
	public void addTodo(String name, String desc, Date targetDate, boolean isDone) {
		todos.add(new Todo(todoCount++, name, desc, targetDate, isDone));
	}
	
	public void updateTodo(Todo todo) {
		todos.remove(todo);
		todos.add(todo);
	}

	
	public Todo retrieveTodo(int id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }

	
	public void deleteTodo(int id) {
		Iterator<Todo> iter = todos.iterator();
		while(iter.hasNext()) {
			Todo todo = iter.next();
			if(todo.getId() == id) {
				iter.remove();
			}
		}
	}
	
	public List<Todo> retrieveTodos(String user) {
        List<Todo> filteredTodos = new ArrayList<Todo>();
        for (Todo todo : todos) {
            if (todo.getUser().equals(user)) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }
}
