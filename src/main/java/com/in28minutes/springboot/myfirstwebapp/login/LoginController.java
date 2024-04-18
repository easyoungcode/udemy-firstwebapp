package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    // src/main/resources/META-INF/resources/WEB-INF/jsp/login.jsp
    // Model
    // Get에 param 형태로 parameter를 넘겨주는 중
    @RequestMapping("login")
    public String gotoLogin(@RequestParam String name) {
        System.out.println("name " + name);
        return "login";
    }
}
