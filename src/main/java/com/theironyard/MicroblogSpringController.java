package com.theironyard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by noellemachin on 3/7/16.
 */
@Controller
public class MicroblogSpringController {
    ArrayList<String> messages = new ArrayList<>();

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) { // httpsession wants a GD object for some reason.
        model.addAttribute("name", session.getAttribute("userName"));
        model.addAttribute("messages", messages);
        return "home";
    }
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName) {
        session.setAttribute("userName", new User(userName));
        return "redirect:/";
    }
    @RequestMapping(path = "/createMessage", method = RequestMethod.POST)
    public String createMessage(HttpSession session, String message) {
        session.getAttribute("userName");
        messages.add(message);
        return "redirect:/";
    }
    @RequestMapping(path = "/delete", method = RequestMethod.POST)
    public String delete(HttpSession session, String message) {
        session.getAttribute("username");
        String messageToRemove = message;
        messages.remove(messageToRemove);
        return "redirect:/";
    }
}

