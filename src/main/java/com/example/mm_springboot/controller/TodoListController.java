package com.example.mm_springboot.controller;

import com.example.mm_springboot.model.CommonResult;
import com.example.mm_springboot.model.TodoList;
import com.example.mm_springboot.service.TodoListService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TodoListController {
    @Resource
    public TodoListService todoListService ;

    /**
     * 新增todolist
     * @param account
     * @param context
     * @return
     */
    @RequestMapping("/todolist/insertTodo")
    public CommonResult insertTodo(@RequestParam("account") String account, @RequestParam("context") String context) {
        TodoList todoList = new TodoList();
        todoList.setAccount(account);
        todoList.setContext(context);
        todoList.setFinish(0);
        int res = 0;
        try {
            res = todoListService.insertTodo(todoList);
        } catch (Exception e) {
            System.out.println(e);
        }
        if(res == 1) {
            return new CommonResult(200, "true");
        } else {
            System.out.println("jiqa"+res);
            return new CommonResult(401, "false");
        }
    }

    /**
     * 获取所有todolist
     * @param account
     * @return 所有帖子
     */
    @RequestMapping("/todolist/queryTodo")
    public CommonResult queryTodo(@RequestParam("account") String account) {
        List<TodoList> res = null;
        try {
            res = todoListService.queryTodo(account);
        } catch (Exception e) {
            System.out.println(e);
        }
        if (res != null) {
            return new CommonResult(200, "true", res);
        }else{
            return new CommonResult(401, "false");
        }
    }

    /**
     * 删除todolist
     * @param list_id
     * @return
     */
    @RequestMapping("/todolist/deleteTodo")
    public CommonResult deleteTodo(@RequestParam("list_id") int list_id) {
        int res = 0;
        try {
            res = todoListService.deleteTodo(list_id);
        } catch (Exception e) {
            System.out.println(e);
        }
        if(res == 1) {
            return new CommonResult(200, "true");
        } else {
            return new CommonResult(401, "false");
        }
    }

    /**
     * 修改完成状态
     * @param list_id
     * @return
     */
    @RequestMapping("/todolist/updateTodo")
    public CommonResult updateTodo(@RequestParam("list_id") int list_id) {
        int res = 0;
        try {
            res = todoListService.updateTodo(list_id);
        } catch (Exception e) {
            System.out.println(e);
        }
        if(res == 1) {
            return new CommonResult(200, "true");
        } else {
            return new CommonResult(401, "false");
        }
    }


}

