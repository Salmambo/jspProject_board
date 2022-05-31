package article;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider;

public class ReadService {
	private ArticleDao articleDao = new ArticleDao();

	public Article getArticle(int articleNum) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			Article article = articleDao.selectById(conn, articleNum);
			if (article == null) {
				throw new RuntimeException();
			}
			return article;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
