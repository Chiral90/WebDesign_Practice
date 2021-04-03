package board;

public class boardDataBean {
	private int no;
	private String title;
	private String Content;
	private String id;
	private int view;
	private int like;
	
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
}
