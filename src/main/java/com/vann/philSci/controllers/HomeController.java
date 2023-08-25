package com.vann.philSci.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vann.philSci.models.LoginUser;
import com.vann.philSci.models.Post;
import com.vann.philSci.models.User;
import com.vann.philSci.services.PostService;
import com.vann.philSci.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	@Autowired
	private PostService postService;

//ALL GET METHODS

	@GetMapping("/")
	public String index() {
		return "home.jsp";
	}

	@GetMapping("/register")
	public String register(@ModelAttribute("newUser") User user) {
		return "register.jsp";
	}

	@GetMapping("/login")
	public String login(@ModelAttribute("newLogin") LoginUser newLogin) {
		return "login.jsp";
	}

	@GetMapping("/activity")
	public String pastActitvity(Model model, HttpSession session, @ModelAttribute("updatePost") Post updatedPost) {

		if (session.getAttribute("success") == null) {
			return "login.jsp";
		}

		User u = userService.findById((Long) session.getAttribute("success"));

		model.addAttribute("user", u);

		return "activity.jsp";
	}

	@GetMapping("/dashboard")
	public String dashBoard(Model model, HttpSession session, @ModelAttribute("newPost") Post newpost) {

		Long userId = (Long) session.getAttribute("success");

		if (userId == null) {
			return "redirect:/login";
		}
		User loggedInUser = userService.findById(userId);
		model.addAttribute("user", loggedInUser);
		model.addAttribute("userId", userId);

		model.addAttribute("posts", postService.getAllPost());

		return "dashboard.jsp";
	}

	@GetMapping("/profile")
	public String profile(Model model, HttpSession session, @ModelAttribute("updateUser") User updatedUser) {

		if (session.getAttribute("success") == null) {
			return "redirect:/login";
		}

		User u = userService.findById((Long) session.getAttribute("success"));

		model.addAttribute("user", u);

		return "profile.jsp";
	}

	@GetMapping("/edit/{postId}")
	public String edit(@ModelAttribute("editPost") Post editPost, HttpSession session, @PathVariable("postId") Long id,
			Model model) {

		if (session.getAttribute("success") == null) {
			return "redirect:/login";

		}

		model.addAttribute("post", postService.getPostById(id));
		model.addAttribute("userId", (Long) session.getAttribute("success"));

		return "edit.jsp";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("success", null);
		return "redirect:/";
	}

//ALL POST METHODS

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, HttpSession session,
			Model model) {

		if (result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			userService.register(newUser, result);
			return "register.jsp";
		} else {

			userService.register(newUser, result);
			Long userId = newUser.getId();
			session.setAttribute("success", userId);
			return "redirect:/dashboard";
		}

	}

	@PostMapping("/login")

	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result,
			HttpSession session, Model model) {
		
		User user = userService.login(newLogin, result);
		
		if(user == null) {
			userService.login(newLogin, result);
			model.addAttribute("newUser", new User());
			return "login.jsp";
		}
		
		if (result.hasErrors()) {
			userService.login(newLogin, result);
			model.addAttribute("newUser", new User());
			return "login.jsp";
		} else {
			Long userId = user.getId();
			session.setAttribute("success", userId);
			return "redirect:/dashboard";
		}
		

	}


	@PostMapping("/createpost")

	public String createPost(Model model, HttpSession session, @Valid @ModelAttribute("newPost") Post newPost,
			BindingResult result) {

		if (session.getAttribute("success") == null) {
			return "login.jsp";
		}
		
		if(result.hasErrors()) {
			model.addAttribute("posts", postService.getAllPost());
			model.addAttribute("user", userService.findById((Long) session.getAttribute("success")));
	
			return "dashboard.jsp";
		}

		postService.addPost(newPost, result);

		return "redirect:/dashboard";
	}

	@PostMapping("/editpost/{postId}")
	public String editPost(@Valid @ModelAttribute("editPost") Post editPost, BindingResult result, HttpSession session,
			@PathVariable("postId") Long id, Model model) {

//		String s = String.format("redirect:/edit/%s", id);

		if (session.getAttribute("success") == null) {

			return "redirect:/login";

		}

		if (result.hasErrors()) {
			
			model.addAttribute("post", postService.getPostById(id));
			model.addAttribute("userId", (Long) session.getAttribute("success"));

			return "edit.jsp";
		}

		postService.updatePost(editPost);
		return "redirect:/dashboard";
	}

	@RequestMapping("/deletepost/{postId}")
	public String deletePost(@Valid @ModelAttribute("editPost") Post editPost, BindingResult result,
			HttpSession session, @PathVariable("postId") Long id) {
		
		
		if(session.getAttribute("success") == null) {
			return "redirect:/login";
		}
		
		if(result.hasErrors()) {
			return "redirect:/dashboard";
		}
		
		postService.deletePost(id);

		return "redirect:/dashboard";
	}

}
