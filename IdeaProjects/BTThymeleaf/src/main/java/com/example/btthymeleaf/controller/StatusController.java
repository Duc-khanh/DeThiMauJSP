package com.example.btthymeleaf.controller;

import com.example.btthymeleaf.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class Status {
    @RequestMapping("/status")
    public String checkStatus(Model model){
        Boolean status = false;
        model.addAttribute("status", status);
        return "/status";
    }
    @GetMapping("checkNumber")
    public String checkNumber(Model model){
        int number = 10 ;
        model.addAttribute("number", number);
        return "/checkNumber";
    }
    @GetMapping("checkString")
    public String checkString(Model model){
        User user = null;
        model.addAttribute("user",user );
        return "/checkString";
    }
    @GetMapping("checkList")
    public String checkList(Model model){
        List<User> users = new ArrayList<>();
        users.add(new User("Duc Khanh", 20));
        users.add(new User("Huyen Trang", 20));
        users.add(new User("Chi Anh", 20));
        model.addAttribute("users", users);
        return "/checkList";
    }
    @GetMapping("codeStatus")
    public String codeStatus(Model model){
        String statusCode = "A001";
        model.addAttribute("statusCode", statusCode);
        return "/codeStatus";
    }


}
