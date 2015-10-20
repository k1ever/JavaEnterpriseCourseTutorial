package com.mvc.test;

import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public String getUsersList(Model model) throws JSONException {
        model.addAttribute("message","Hello from controller!");
        return "userPage";
    }
}
