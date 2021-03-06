package com.wrox.site;

import java.util.Map;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.wrox.config.annotation.WebController;
import com.wrox.site.entities.UserPrincipal;
import com.wrox.site.util.RegistrationUtil;
import com.wrox.site.util.SecurityUtil;

@WebController()
@SessionAttributes("signUpForm")
public class SignUpController {
	
	private static final Logger log = LogManager.getLogger(SignUpController.class);
	
	UserService userService;
	
	@Autowired
	public SignUpController(UserService userService) {
		super();
		this.userService = userService;
	}


	@RequestMapping(value = {"/signup", "/user/register" }, method = RequestMethod.GET)
	public ModelAndView showSignUpForm(WebRequest request, Map<String, Object> model){
		
		log.info("GET /signup ----------- Placing new SignUpForm Object in model");
		
		SignUpForm signUpForm = new SignUpForm();
		
		model.put("signUpForm", signUpForm);
		
		return new ModelAndView("/user/signUpForm", model);
	}
	
	
	@RequestMapping(value = {"/signup", "/user/register"}, method = RequestMethod.POST)
	public ModelAndView registerUser(@Valid @ModelAttribute("signUpForm") SignUpForm signUpForm,
									BindingResult result,
									WebRequest request){
		
		
		if (result.hasErrors()) return new ModelAndView("/user/register", null);
		
		UserPrincipal user = RegistrationUtil.createUser(signUpForm);
		
		log.info("POST /signup --------- processing user: " + user);
		if (user == null) return new ModelAndView("/signup");
		
		userService.saveUser(user, signUpForm.getPassword());
		
		log.info("Saving User: " + user);
		log.info("Current Authentication: " + SecurityContextHolder.getContext().getAuthentication());
		log.info("Authenticating newly created user: " + user);
		SecurityUtil.logInUser(user);
		
		log.info("Current Authentication: " + SecurityContextHolder.getContext().getAuthentication());
		
		return new ModelAndView("/ticket/list", null);
		
	}
	
	
	
	
}
