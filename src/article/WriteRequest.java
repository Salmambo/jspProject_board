package article;

import java.util.Map;

import auth.User;

public class WriteRequest {
	private User writer;
	private String title;
	private String content;

	public WriteRequest(User writer, String title, String content) {
		this.writer = writer;
		this.title = title;
		this.content = content;
	}

	public User getWriter() {
		return writer;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public void validate(Map<String, Boolean> errors) {
		if (title == null || title.trim().isEmpty()) {
			errors.put("title", Boolean.TRUE);
		}
	}
}
