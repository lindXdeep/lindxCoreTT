package io.lindx.task.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.lindx.task.model.User;
import io.lindx.task.service.UserService;

@Controller
public class AuthController {

	@Autowired
	private UserService userService;

	@GetMapping("/users/sign_up")
	public String sign_up(ModelMap model) {

		model.addAttribute("user", new User());

		return "auth/sign_up";
	}

	@PostMapping("/users/sign_up")
	public String newUser(@ModelAttribute User user, RedirectAttributes redirectAttributes) {

		userService.add(user);

		redirectAttributes.addAttribute("id", user.getId()).addFlashAttribute("msg",
				"User: " + user.getId() + " Created!");

		return "redirect:/pages/user/{id}";
	}

	@GetMapping("/login")
	public String sign_in(ModelMap model) {

		model.addAttribute("user", new User());
		return "/auth/sign_in.html";
	}

	@PostMapping("/login")
	public String sign_in(@ModelAttribute User user) {
		return "/auth/sign_in.html";
	}

  @GetMapping("/logout")
  public String logout(HttpServletRequest request){

    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    
    if(auth != null){
      request.getSession().invalidate();
    }
    
    return "redirect:/login";
  }
}