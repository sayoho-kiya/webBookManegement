package book;

import java.io.Serializable;

public class ItemBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String pid;
	private String title;
	private String publisher;
	private String author;
	private String genre;
	private String eval;
	private String area;
	private String price;
	private int state;

	/**
	 * コンストラクタ.<br>
	 * メンバ変数の値を初期化します.
	 */
	public ItemBean() {
		pid = "";
		title = "";
		publisher = "";
		author = "";
		genre = "";
		eval = "";
		area = "";
		price = "";
		state = 0;

	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getEval() {
		return eval;
	}

	public void setEval(String eval) {
		this.eval = eval;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

}