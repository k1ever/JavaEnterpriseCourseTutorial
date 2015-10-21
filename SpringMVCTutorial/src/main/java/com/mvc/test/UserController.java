package com.mvc.test;

import com.mvc.test.dao.UserRepository;
import com.mvc.test.model.UserEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public String getUsersList(Model model) throws JSONException {
        JSONArray jsonArray = new JSONArray();
        List<UserEntity> usersList = userRepository.getUsersList();
        for (UserEntity userEntity : usersList) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", userEntity.getName());
            jsonArray.put(jsonObject);
        }
        model.addAttribute("message", jsonArray.toString());
        return "userPage";
    }
}
