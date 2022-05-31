package article;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;

public class WriteService {
	private ArticleDao articleDao = new ArticleDao();

	public Integer write(WriteRequest req) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			Article article = toArticle(req);
			int result = articleDao.insert(conn, article);
			if (result == 0) {
				throw new RuntimeException("fail to insert article");
			}
			conn.commit();
			return result;
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} catch (RuntimeException e) {
			JdbcUtil.rollback(conn);
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}
	}

	private Article toArticle(WriteRequest req) {
		Date now = new Date();
		return new Article(null, req.getTitle(), req.getWriter(), now, req.getContent());
	}
}
