package com.dc.sec_kill.controller;


import com.dc.sec_kill.entity.Person;
import com.dc.sec_kill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/app")
public class HelloWorldController {

    @Autowired
    private UserService userService;

    @Autowired
    private Person person;

    @RequestMapping("/test")
    @ResponseBody
    public String testDemo() {

        return "Hello World!";
    }

    @RequestMapping("/person")
    @ResponseBody
    public String personDemo() {

        return person.toString();
    }

    @RequestMapping("/user")
    @ResponseBody
    public String userDemo() {

        return "age:"+userService.list().getId()+" name:"+userService.list().getName()+" age:"+userService.list().getAge();
    }

    @RequestMapping("/kill")
    @ResponseBody
    public String killDemo() {

        return userService.getbyid().toString();
    }
}
