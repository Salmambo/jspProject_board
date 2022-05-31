package member;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.ConnectionProvider;

public class JoinService {
	private MemberDao memberDao = new MemberDao();

	public void join(JoinRequest joinRequest) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			Member member = memberDao.selectById(conn, joinRequest.getId());
			if (member != null) {
				JdbcUtil.rollback(conn);
				throw new RuntimeException();
			}
			memberDao.insert(conn,
					new Member(joinRequest.getId(), joinRequest.getPassword(), joinRequest.getNickname()));
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
}
