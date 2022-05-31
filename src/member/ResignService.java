package member;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;

public class ResignService {
	private MemberDao memberDao = new MemberDao();

	public void deleteMember(String id, String password) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			Member member = memberDao.selectById(conn, id);
			if (member == null || (!member.getPassword().equals(password))) {
				JdbcUtil.rollback(conn);
				throw new RuntimeException();
			}
			memberDao.delete(conn, member);
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
}
