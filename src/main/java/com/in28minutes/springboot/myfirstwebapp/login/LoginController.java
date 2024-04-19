package com.in28minutes.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")  // SessionAttributes를 넣을 땐 해당 Session 값을 사용하는 모든 컨트롤러에 넣기
public class LoginController {

    private AuthenticationService authenticationService;
    private Logger logger = LoggerFactory.getLogger(getClass());

    public LoginController(AuthenticationService authenticationService) {
        super();
        this.authenticationService = authenticationService;
    }

    // src/main/resources/META-INF/resources/WEB-INF/jsp/login.jsp
    // Model
    // Get에 param 형태로 parameter를 넘겨주는 중
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String gotoLogin() {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String gotoWelcome(@RequestParam String name,
        @RequestParam String password,
        ModelMap model) {
        if (authenticationService.authenticate(name, password)) {
            model.put("name", name);

            return "welcome";
        }
        model.put("errorMessage", "Invalid username or password. Please try again.");
        return "login";
    }
}
