package article;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandHandler;

public class ReadHandler implements CommandHandler {
	private ReadService readService = new ReadService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String noVal = req.getParameter("no");
		int articleNum = Integer.parseInt(noVal);
		try {
			Article article = readService.getArticle(articleNum);
			req.setAttribute("articleData", article);
			return "/WEB-INF/view/readArticle.jsp";
		} catch (RuntimeException e) {
			req.getServletContext().log("no article", e);
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}
}
