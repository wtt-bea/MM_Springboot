package com.example.mm_springboot.dao;

import com.example.mm_springboot.model.TodoList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TodoListDao {
    int insertTodo(TodoList todoList);
    int deleteTodo(@Param("list_id") int list_id);
    List<TodoList> queryTodo(@Param("account") String account);
    int updateTodo(@Param("list_id") int list_id);
}
