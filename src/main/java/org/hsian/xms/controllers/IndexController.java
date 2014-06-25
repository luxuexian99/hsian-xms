package org.hsian.xms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Hsian on 14-6-21.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping(value = "index")
    public String index() {
        return "index";
    }

}
