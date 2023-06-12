package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
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

    @GetMapping(value = "/")
    public ModelAndView allUsers() {
        List<User> users = userService.getAllUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        modelAndView.addObject("usersList", users);
        return modelAndView;
    }
    @GetMapping(value = "/add")
    public String addUser() {
        return "addUser";
    }

    @PostMapping(value = "/add")
    public String addUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "/update/{id}")
    public ModelAndView updatePage(@PathVariable("id") long id) {
        User user = userService.getByIdUser(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("сhangeUser");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @PostMapping(value = "/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.upDateUser(user);
        return "redirect:/";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
