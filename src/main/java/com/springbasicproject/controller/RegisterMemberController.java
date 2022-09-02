package com.springbasicproject.controller;

import com.springbasicproject.DTO.RegisterRequest;
import com.springbasicproject.service.MemberRegisterService;
import org.apache.ibatis.javassist.bytecode.DuplicateMemberException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
public class RegisterMemberController {

    private final MemberRegisterService memberRegisterService;

    public RegisterMemberController(MemberRegisterService memberRegisterService) {
        this.memberRegisterService = memberRegisterService;
    }

    @GetMapping("/terms")
    public String registerStep1(){
        return "register/terms";
    }

    //URL 주소에서 create 를 직접입력 하였을 경우 약관 페이지로 redirect
    @GetMapping("/create")
    public String returnStep1(){
        return "redirect:/register/terms";
    }

    @PostMapping("/create")
    public String registerStep2(@RequestParam(value = "agree",defaultValue = "false")Boolean agree, Model model){
        if(!agree){
            return "register/terms";
        }else{
            model.addAttribute("registerRequest", new RegisterRequest());
            return "register/create";
        }

    }
    @PostMapping("/register/step3")
    public String registerStep3(@ModelAttribute RegisterRequest regReq) {
        try {
            memberRegisterService.regist(regReq);
            return "register/success";
        } catch (Exception e) {
            return "register/create";
        }
    }
}
