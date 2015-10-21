package com.mvc.test;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by svoitenko on 21 Oct 2015.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public String getUsersList(Model model) throws JSONException {
        model.addAttribute("message", "Hello from controller!");
        return "userPage";
    }
}
