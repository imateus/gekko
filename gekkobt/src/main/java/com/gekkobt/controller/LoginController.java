package com.gekkobt.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gekkobt.bean.UserBean;
import com.gekkobt.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController extends GenericController implements
ControllerInterface {
	
	private static final String REDIRECT = "redirect:";
	private static final String LOGIN = "/login";

	@Autowired
	private LoginService userService;
	
	@Autowired
	private UserBean user;
	
	@RequestMapping("")
	public String login() {
		return "loginForm";
	}

	@RequestMapping("/loginForm")
	public String loginForm(UserBean userLogin, HttpServletRequest req,
			RedirectAttributes redirectAttributes) {
		
		UserBean userBean = new UserBean();
		userBean = userService.searchUser(userLogin);
		
 		if (userBean != null) {
			getUser().setId(userBean.getId());
			req.getSession().setAttribute("userLogged", userBean);

			return "redirect:../occurrence";
		} else {
			redirectAttributes.addFlashAttribute("mensagem",
					"Usuário e(ou) senha inválidos!");
		}
		return "redirect:../login";
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest req) {
		req.getSession().setAttribute("userLogged", new UserBean());
		user.setSessionSpec(null);
		user.setUserId(null);
		user.setUserIp(null);
		user.setId(null);
		return "redirect:../login";
	}

	@RequestMapping("/email")
	public ModelAndView email(String password, UserBean userEmail,
			RedirectAttributes redirectAttributes, Model model)
			throws EmailException {
		ModelAndView mav = new ModelAndView(REDIRECT + LOGIN);
		if (userService.sendEmail(userEmail)) {
			redirectAttributes.addFlashAttribute("mensagem",
					"Senha enviada com sucesso, Verifique seu email.");
		} else {
			redirectAttributes.addFlashAttribute("mensagem",
					"E-mail não cadastrado, favor informar um email válido!");
		}
		return mav;
	}

	@Override
	public String index(ModelMap modelMap, HttpServletRequest req) {
		return null;
	}
}
