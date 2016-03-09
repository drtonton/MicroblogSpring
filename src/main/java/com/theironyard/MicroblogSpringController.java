package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    MessageRepository messages;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
        model.addAttribute("name", session.getAttribute("userName"));
        model.addAttribute("messages", messages.findAll());
        return "home";
    }
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName) {
        session.setAttribute("userName", userName);
        return "redirect:/";
    }
    @RequestMapping(path = "/createMessage", method = RequestMethod.POST)
    public String createMessage(HttpSession session, String message) {
        session.getAttribute("userName");
        Message m = new Message(message, String.valueOf(session.getAttribute("userName")));
        messages.save(m);
        return "redirect:/";
    }
    @RequestMapping(path = "/delete", method = RequestMethod.POST)
    public String delete(Integer id) {
        messages.delete(id);
        return "redirect:/";
    }
    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
    @RequestMapping(path = "/edit", method = RequestMethod.POST)
    public String edit(Integer id, String text) {
        Message m = messages.findOne(id);
        m.text = text;
        messages.save(m);
        return "redirect:/";
    }
}

