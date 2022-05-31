package member;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;

public class ChangeService {

	private MemberDao memberDao = new MemberDao();

	public void change(String userId, String nickname, String curPwd, String newPwd) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			Member member = memberDao.selectById(conn, userId);
			if (member == null) {
				throw new RuntimeException();
			}
			if (!member.matchPassword(curPwd)) {
				throw new RuntimeException();
			}
			member.changePassword(newPwd);
			member.changeNickname(nickname);
			memberDao.update(conn, member);
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
}
