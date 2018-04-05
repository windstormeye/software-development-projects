package com.pjhubs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/hello", method = RequestMethod.GET)

public class thingsController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String printHello() {
        
    }

}
