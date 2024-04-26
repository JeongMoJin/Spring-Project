package com.example.spring_project_02.mapper;

import com.example.spring_project_02.domain.TodoVO;
import com.example.spring_project_02.dto.PageRequestDTO;
import com.example.spring_project_02.dto.PageResponseDTO;
import com.example.spring_project_02.dto.TodoDTO;
import com.example.spring_project_02.service.TodoService;
import jdk.jpackage.internal.Log;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoMapperTest {
    @Autowired(required = false)
    private TodoMapper todoMapper;

    @Test
    public void testGetTimer() {
        log.info(todoMapper.getTime());
    }

    @Test
    public void testInsert() {
        TodoVO todoVO = TodoVO.builder()
                .title("행복하세요 :)")
                .dueDate(LocalDate.of(2023, 12, 25))
                .writer("user04")
                .build();
        todoMapper.insert(todoVO);
    }

    @Test
    public void testSelectAll() {
        List<TodoVO> todoVOs = todoMapper.selectAll();
        for(TodoVO todoVO : todoVOs) {
            log.info(todoVO);
        }
    }

    @Test
    public void testSelectOne() {
        TodoVO todoVO = todoMapper.selectOne(3L);
        log.info(todoVO);
    }

    @Test
    public void testDelete() {
        // 1) tno로 데이터를 변환해서 정상 출력 확인 2) 삭제 3) 다시 tno로 데이터를 변환해서 삭제 확인
        Long tno = 2L;
        TodoVO todoVO = todoMapper.selectOne(tno);
        log.info(todoVO);

        todoMapper.delete(tno);

        todoVO = todoMapper.selectOne(tno);
        log.info(todoVO);
    }

    @Test
    public void testUpdate() {
        Long tno = 12L;
        log.info(todoMapper.selectOne(tno));
        TodoVO todoVO = TodoVO.builder()
                .tno(tno)
                .title("update test")
                .dueDate(LocalDate.parse("2030-12-12"))
                .finished(true)
                .build();
        todoMapper.update(todoVO);
        log.info(todoMapper.selectOne(tno));
    }

    @Test
    public void testSelectList() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(5)
                .size(20)
                .build();
        List<TodoVO> todoVOList = todoMapper.selectList(pageRequestDTO);
        for(TodoVO todoVO : todoVOList) {
            log.info(todoVO);
        }
        todoVOList.forEach(item -> log.info(item));
    }

    @Test
    public void testGetCount() {
        log.info(todoMapper.getCount(PageRequestDTO.builder().build()));
    }

//    @Test
//    public void TestPaging() {
//        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();
//        PageResponseDTO<TodoDTO> pageResponseDTO = todoService.
//        log.info(pageResponseDTO);
//        pageResponseDTO.getDtoList().stream().forEach(todoDTO -> log.info(todoDTO));
//    }
}



















