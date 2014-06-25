package org.hsian.xms.controllers;

import org.hsian.xms.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by Hsian on 14-6-21.
 */
@Controller
@RequestMapping("/user")
public class UserController {

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
        user.setName("WaWa");
        mav.addObject("user", user);

        return mav;
    }
}
