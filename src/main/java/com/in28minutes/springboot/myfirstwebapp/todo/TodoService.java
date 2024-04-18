package com.in28minutes.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    private static int todosCount = 0;
    
    // 정적변수 초기화
    static {
        todos.add(new Todo(++todosCount, "ecode", "Learn AWS"
                , LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todosCount, "ecode", "Learn DevOps"
                , LocalDate.now().plusYears(2), false));
        todos.add(new Todo(++todosCount, "ecode", "Learn Spring"
                , LocalDate.now().plusYears(3), false));

    }

    public List<Todo> findByUserName(String userName) {
        return todos;
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
        Todo todo = new Todo(++todosCount, username, description, targetDate, done);
        todos.add(todo);
    }
}
