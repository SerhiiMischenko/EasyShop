package com.shop.controllers;

import com.shop.models.User;
import com.shop.repositories.UserRepository;
import com.shop.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @PostMapping("/login")
    public String loginPost(@RequestParam String email, @RequestParam String password, RedirectAttributes redirectAttributes) {
        User user = userRepository.findByEmail(email);

        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            redirectAttributes.addFlashAttribute("username", email);
            return "redirect:/hello";
        } else {
            redirectAttributes.addFlashAttribute("error", "Неверные учетные данные");
            return "redirect:/login?error";
        }
    }

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }
    @PostMapping("/registration")
    public String createUser(User user, Model model) {
        if(!userService.createUser(user)) {
            model.addAttribute("errorMessage",
                    "Пользователь с email: " + user.getEmail() + "уже существует");
            return "registration";
        }
        userService.createUser((user));
        return "redirect:/login";
    }
    @GetMapping("/hello")
    public String securityUrl() {
        return "hello";
    }
}
