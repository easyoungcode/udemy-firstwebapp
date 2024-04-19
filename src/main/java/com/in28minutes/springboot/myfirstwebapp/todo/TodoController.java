package com.in28minutes.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // /list-todos
    @RequestMapping("/list-todos")
    public String listAllTodos(ModelMap model) {
        List<Todo> todos = todoService.findByUserName("ecode");
        model.put("todos", todos);
        return "listTodos";
    }

    // /add-todos
    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model) {
        String username = (String) model.get("name");
        Todo todo = new Todo(0, username, "Default Desc", LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "todo";
    }

    // /add-todos
    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        // 만약 Binding Error가 하나라도 있으면 다시 todo return
        if (result.hasErrors()) {
            return "todo";
        }
        String username = (String) model.get("name");
        todoService.addTodo(username, todo.getDescription(), LocalDate.now().plusYears(1), false);
        return "redirect:list-todos";
    }

    // /delete-todos
    @RequestMapping(value = "/delete-todo")
    public String deleteTodo(@RequestParam long id) {
        // Delete Todo
        todoService.deleteByID(id);
        return "redirect:list-todos";
    }

    // /update-todos
    @RequestMapping(value = "/update-todo")
    public String showUpdateTodoPage(@RequestParam long id, ModelMap model) {
        // update Todo
        Todo todo = todoService.findById(id);
        model.addAttribute("todo", todo);
        return "todo";
    }

    // /update-todos
    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }

        String username = (String) model.get("name");
        todo.setUsername(username);
        todoService.updateTodo(todo);
        return "redirect:list-todos";
    }
}
