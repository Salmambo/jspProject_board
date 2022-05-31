package article;

import java.util.Date;

import auth.User;

public class Article {
	private Integer number;
	private String title;
	private User writer;
	private Date regdate;
	private String content;

	public Article(Integer number, String title, User writer, Date regdate, String content) {
		this.number = number;
		this.title = title;
		this.writer = writer;
		this.regdate = regdate;
		this.content = content;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getWriter() {
		return writer;
	}

	public void setWriter(User writer) {
		this.writer = writer;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
