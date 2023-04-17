package com.example.mm_springboot.service;

import com.example.mm_springboot.model.TodoList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TodoListService {
    int insertTodo(TodoList todoList);

    int deleteTodo(int list_id);

    List<TodoList> queryTodo(String account);

    int updateTodo(int list_id);
}
