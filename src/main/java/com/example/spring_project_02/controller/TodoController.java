package com.example.spring_project_02.controller;

import com.example.spring_project_02.dto.PageRequestDTO;
import com.example.spring_project_02.dto.PageResponseDTO;
import com.example.spring_project_02.dto.TodoDTO;
import com.example.spring_project_02.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/todo")
@Log4j2
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

//    @RequestMapping("/list")
//    public void list(Model model) {
//        log.info("todo list...");
////        model.addAttribute("dtoList", todoService.getAll());
//    }
    @GetMapping("/list")
    public void list(@Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model) {
        log.info(pageRequestDTO);

        if(bindingResult.hasErrors()) {
            pageRequestDTO = PageRequestDTO.builder().build();
        }
        model.addAttribute("responseDTO", todoService.getList(pageRequestDTO));
    }

//    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @GetMapping("/register")
    public void registerGET() {
        log.info("GET todo register...");
    }

    @PostMapping("/register")
    public String registerPOST(@Valid TodoDTO todoDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        log.info("POST todo register...");

        if (bindingResult.hasErrors()) {
            log.info("has error ...");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/todo/register";
        }
        log.info(todoDTO);

        todoService.register(todoDTO);

        return "redirect:/todo/list";
    }

    @GetMapping({"/read", "/modify"})
    public void read (Long tno, PageRequestDTO pageRequestDTO ,Model model) {
        // 1) request로 전달 받은 tno를 서비스에 전달해서 2) TodoDTO를 반환받아서 3) View에 전달
        TodoDTO todoDTO = todoService.getOne(tno);
        log.info(todoDTO);
        model.addAttribute("dto", todoDTO);
    }

    @PostMapping("/remove")
    public String remove(Long tno, PageRequestDTO pageRequestDTO ,RedirectAttributes redirectAttributes) {
        log.info("remove()....");
        log.info("tno: " + tno);

        todoService.remove(tno);

        redirectAttributes.addAttribute("page", 1);
        redirectAttributes.addAttribute("size", pageRequestDTO.getSize());
        return "redirect:/todo/list";
    }

    @PostMapping("/modify")
    public String modify(PageRequestDTO pageRequestDTO,
                         @Valid TodoDTO todoDTO,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("page", pageRequestDTO.getPage());
        redirectAttributes.addAttribute("size", pageRequestDTO.getSize());

        if (bindingResult.hasErrors()) { // 유효성 검사 결과 에러가 있으면 수정페이지로 되돌아감
            log.info(("has error..."));
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("tno", todoDTO.getTno()); // tno가 쿼리스트링으로 전달
            return "redirect:/todo/modify";
        }
        log.info(todoDTO);
        todoService.modify(todoDTO);

        return "redirect:/todo/list";
    }

    @Controller
    public class TestController {
        @GetMapping("/test01")
        public void test1() {
            log.info("test01");
        }
    }

    @PostMapping("/test02")
    public void test02(String title) {
        log.info("test02");
        log.info(title);
    }


}















