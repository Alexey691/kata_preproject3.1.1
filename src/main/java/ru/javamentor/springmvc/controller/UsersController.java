package ru.javamentor.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.javamentor.springmvc.models.User;
import ru.javamentor.springmvc.service.UserService;

@Controller
public class UsersController {


    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public String getListUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "/users";
    }

    @GetMapping("add")
    public String createAddUserForm(User user, Model model) {
        model.addAttribute("user", user);
        return "/adduser";
    }

    @PostMapping("add")
    public String addUser(User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @DeleteMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.delUser(id);
        return "redirect:/";
    }

    @GetMapping("update{id}")
    public String createUpdUserForm(@PathVariable("id") long id, Model model) {
        User user = userService.getUser(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute(user);
        return "/update";
    }

    @PutMapping("update")
    public String updateUser(User user) {
        userService.updUser(user);
        return "redirect:/";
    }


}

