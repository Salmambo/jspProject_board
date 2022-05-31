package article;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandHandler;

public class DeleteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		DeleteService das = new DeleteService();
		int articleNo = Integer.parseInt(req.getParameter("no"));
		das.delete(articleNo);
		return "/WEB-INF/view/deleteSuccess.jsp";
	}
}
