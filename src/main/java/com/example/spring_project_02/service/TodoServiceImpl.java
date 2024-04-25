package com.example.spring_project_02.service;

import com.example.spring_project_02.domain.TodoVO;
import com.example.spring_project_02.dto.TodoDTO;
import com.example.spring_project_02.mapper.TodoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor // 생성자 객체 주입. private final로 선언된 참조변수에 객체를 저장하는 생성자 작성.
public class TodoServiceImpl implements TodoService {
    private final TodoMapper todoMapper;
    private final ModelMapper modelMapper;

    @Override
    public void register(TodoDTO todoDTO) {
        // 1) todoDTO를 전달 받아 2) todoDTO를 todoVO로 변환 후 3) dao의 insert() 호출
        log.info(todoDTO);
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        log.info(todoVO);
        todoMapper.insert(todoVO);
    }

    @Override
    public List<TodoDTO> getAll() {
        List<TodoVO> voList = todoMapper.selectAll(); // dto에서 데이터베이스에서 들고온 VO리스트를 리턴
        List<TodoDTO> dtoList = new ArrayList<>();
        for (TodoVO todoVO : voList) {
            // 개별 VO를 DTO로 변환.
            TodoDTO todoDTO = modelMapper.map(todoVO, TodoDTO.class);
            dtoList.add(todoDTO); // DTO리스트에 저장.
        }
        return dtoList;
    }
}


















