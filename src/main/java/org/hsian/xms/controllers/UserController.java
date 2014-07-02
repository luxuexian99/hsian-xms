package org.hsian.xms.controllers;

import org.hsian.xms.model.User;
import org.hsian.xms.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by Hsian on 14-6-21.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/getUser", method = GET)
    public ModelAndView getUser() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/user");
        mav.addObject("user", new User("hsian"));
        return mav;
    }

    @RequestMapping(value = "/helloUser", method = GET)
    public ModelAndView helloUser() {
        ModelAndView mav = new ModelAndView();
        // 对应的视图名称
        mav.setViewName("/user");
        // 返回到视图的信息（包括：各种类型的VO）。
        User user = new User();
        user.setUserName("WaWa");
        mav.addObject("user", user);

        return mav;
    }

    @RequestMapping(value = "/addUser", method = POST)
    public ModelAndView addUser(@ModelAttribute("user") User user) {
        ModelAndView mav = new ModelAndView();
        userService.addUser(user);
        mav.addObject("user", user);
        mav.setViewName("/user");
        return mav;
    }
}
