package member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.User;
import command.CommandHandler;

public class ChangeHandler implements CommandHandler {
	private static final String view = "/WEB-INF/view/changeForm.jsp";
	private ChangeService changeService = new ChangeService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		User authUser = (User) req.getSession().getAttribute("authUser");
		req.setAttribute("authUser", authUser);
		return view;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
		User user = (User) req.getSession().getAttribute("authUser");
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		String nickname = req.getParameter("nickname");
		String curPwd = req.getParameter("curPwd");
		String newPwd = req.getParameter("newPwd");
		String confirmPassword = req.getParameter("confirmPassword");
		if (nickname == null || nickname.isEmpty()) {
			errors.put("nickname", Boolean.TRUE);
		}
		if (curPwd == null || curPwd.isEmpty()) {
			errors.put("curPwd", Boolean.TRUE);
		}
		if (newPwd == null || newPwd.isEmpty()) {
			errors.put("newPwd", Boolean.TRUE);
		} else if (curPwd.equals(newPwd)) {
			errors.put("samePassword", Boolean.TRUE);
		}
		if (!newPwd.equals(confirmPassword)) {
			errors.put("notMatch", Boolean.TRUE);
		}
		if (!errors.isEmpty()) {
			return view;
		}
		try {
			changeService.change(user.getId(), nickname, curPwd, newPwd);
			user.setNickname(nickname);
			req.setAttribute("authUser", user);
			return "/WEB-INF/view/changeSuccess.jsp";
		} catch (RuntimeException e) {
			errors.put("badCurPwd", Boolean.TRUE);
			return view;
		}
	}
}
