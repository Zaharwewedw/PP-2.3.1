package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.Model.User;
import web.service.UserService;

import java.util.List;


@Controller
@RequestMapping("/")
public class UserController {
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/test")
    public String getTest() {
        return "test";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allUsers() {
        List<User> users = userService.getAllUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        modelAndView.addObject("usersList", users);
        return modelAndView;
    }
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPage() {
        return "addUser";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") long id) {
        User user = userService.getByIdUser(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("сhangeUser");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") long id) {
        User user = userService.getByIdUser(id);
        userService.deleteUser(user);
        return "redirect:/";
    }
}
