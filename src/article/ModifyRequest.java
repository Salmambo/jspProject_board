package article;

import java.util.Map;

public class ModifyRequest {
	private String id;
	private int number;
	private String title;
	private String content;

	public ModifyRequest(String id, int number, String title, String content) {
		this.id = id;
		this.number = number;
		this.title = title;
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public int getNumber() {
		return number;
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
