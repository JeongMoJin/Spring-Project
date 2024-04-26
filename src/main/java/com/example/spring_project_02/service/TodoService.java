package com.example.spring_project_02.service;

import com.example.spring_project_02.dto.PageRequestDTO;
import com.example.spring_project_02.dto.PageResponseDTO;
import com.example.spring_project_02.dto.TodoDTO;

import java.util.List;

public interface TodoService {
    void register(TodoDTO todoDTO);

//    List<TodoDTO> getAll();

    PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO);

    TodoDTO getOne(Long tno);

    void remove(Long tno);

    void modify(TodoDTO todoDTO);
}



















