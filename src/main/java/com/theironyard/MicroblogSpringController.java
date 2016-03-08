package com.theironyard;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by noellemachin on 3/7/16.
 */
public class MicroblogSpringController {
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
        model.addAttribute("name", session.getAttribute("userName"));
        return "home";
    }
}

//    In your controller, create a route for /
//        It should take the model and the request as arguments
//        It should read the username from the session and add it to the model
//        It should return the home template