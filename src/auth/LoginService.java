package auth;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import member.Member;
import member.MemberDao;

public class LoginService {
	private MemberDao memberDao = new MemberDao();

	public User login(String id, String password) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			Member member = memberDao.selectById(conn, id);
			if (member == null) {
				throw new RuntimeException();
			}
			if (!member.matchPassword(password)) {
				throw new RuntimeException();
			}
			return new User(member.getId(), member.getNickname());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
