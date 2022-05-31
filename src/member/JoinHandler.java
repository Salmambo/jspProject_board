package member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandHandler;

public class JoinHandler implements CommandHandler {

	private static final String view = "/WEB-INF/view/joinForm.jsp";
	private JoinService joinService = new JoinService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return view;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		JoinRequest joinRequest = new JoinRequest();
		joinRequest.setId(req.getParameter("id"));
		joinRequest.setPassword(req.getParameter("password"));
		joinRequest.setConfirmPassword(req.getParameter("confirmPassword"));
		joinRequest.setNickname(req.getParameter("nickname"));
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		joinRequest.validate(errors);
		if (!errors.isEmpty()) {
			return view;
		}
		try {
			joinService.join(joinRequest);
			return "/WEB-INF/view/joinSuccess.jsp";
		} catch (RuntimeException e) {
			errors.put("duplicateId", Boolean.TRUE);
			return view;
		}
	}

}
