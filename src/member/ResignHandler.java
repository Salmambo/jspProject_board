package member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.User;
import command.CommandHandler;

public class ResignHandler implements CommandHandler {
	private static final String view = "/WEB-INF/view/resignForm.jsp";
	private ResignService resignService = new ResignService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
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
		User user = (User) req.getSession().getAttribute("authUser");
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		if (id == null || id.isEmpty())
			errors.put("id", Boolean.TRUE);
		else if (!id.equals(user.getId()))
			errors.put("idOrPwNotMatch", Boolean.TRUE);
		if (password == null || password.isEmpty())
			errors.put("password", Boolean.TRUE);
		if (!errors.isEmpty()) {
			return view;
		}
		try {
			resignService.deleteMember(id, password);
			return "/WEB-INF/view/resignSuccess.jsp";
		} catch (RuntimeException e) {
			errors.put("idOrPwNotMatch", Boolean.TRUE);
			return view;
		}
	}
}
