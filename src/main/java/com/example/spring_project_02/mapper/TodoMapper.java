package com.example.spring_project_02.mapper;

import com.example.spring_project_02.domain.TodoVO;

import java.util.List;

public interface TodoMapper {
    String getTime();

    void insert(TodoVO todoVO);

    List<TodoVO> selectAll();
}
