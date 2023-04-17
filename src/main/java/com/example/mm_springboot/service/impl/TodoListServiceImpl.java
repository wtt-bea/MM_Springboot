package com.example.mm_springboot.service.impl;

import com.example.mm_springboot.dao.TodoListDao;
import com.example.mm_springboot.model.TodoList;
import com.example.mm_springboot.service.TodoListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TodoListServiceImpl implements TodoListService {
    @Resource
    private TodoListDao todoListDao;

    @Override
    public int insertTodo(TodoList todoList) {
        return todoListDao.insertTodo(todoList);
    }

    @Override
    public int deleteTodo(int list_id) {
        return todoListDao.deleteTodo(list_id);
    }

    @Override
    public List<TodoList> queryTodo(String account) {
        return todoListDao.queryTodo(account);
    }

    @Override
    public int updateTodo(int list_id) {
        return todoListDao.updateTodo(list_id);
    }
}
