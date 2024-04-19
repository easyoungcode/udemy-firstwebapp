package com.in28minutes.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")  // SessionAttributes를 넣을 땐 해당 Session 값을 사용하는 모든 컨트롤러에 넣기
public class WelcomeController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    // src/main/resources/META-INF/resources/WEB-INF/jsp/login.jsp
    // Model
    // Get에 param 형태로 parameter를 넘겨주는 중
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String gotoWelcome(ModelMap model) {
        model.put("name", getLoggedInUser());
        return "welcome";
    }

    private String getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
