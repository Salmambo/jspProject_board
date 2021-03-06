package article;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.User;
import command.CommandHandler;

public class WriteHandler implements CommandHandler {

	private static final String view = "/WEB-INF/view/writeForm.jsp";
	private WriteService writeService = new WriteService();

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
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		User user = (User) req.getSession(false).getAttribute("authUser");
		WriteRequest writeRequest = createWriteRequest(user, req);
		writeRequest.validate(errors);
		if (!errors.isEmpty()) {
			return view;
		}
		int newArticleNo = writeService.write(writeRequest);
		req.setAttribute("newArticleNo", newArticleNo);
		return "/WEB-INF/view/writeSuccess.jsp";
	}

	private WriteRequest createWriteRequest(User user, HttpServletRequest req) {
		return new WriteRequest(user, req.getParameter("title"), req.getParameter("content"));
	}
}
