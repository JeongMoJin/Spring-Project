package com.example.spring_project_02.service;

import com.example.spring_project_02.dto.TodoDTO;

import java.util.List;

public interface TodoService {
    void register(TodoDTO todoDTO);

    List<TodoDTO> getAll();
}



















