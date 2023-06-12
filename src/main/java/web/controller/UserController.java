package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.UserService;

import javax.validation.Valid;
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
    public String addUser(@ModelAttribute User user) {
        return "addUser";
    }

    @PostMapping(value = "/add")
    public String addUser(@ModelAttribute @Valid User user,
                          BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "addUser";

        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "/update/{id}")
    public ModelAndView updatePage(@PathVariable long id) {
        User user = userService.getByIdUser(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("сhangeUser");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @PatchMapping(value = "/update")
    public String updateUser(@ModelAttribute @Valid User user,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "сhangeUser";

        userService.upDateUser(user);
        return "redirect:/";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
