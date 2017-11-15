package book;

import java.io.Serializable;

public class HistoryBean implements Serializable {

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
	private String out_date;
	private String sche_date;
	private String in_date;
	private int evaluation;
	private String impressions;

	/**
	 * コンストラクタ.<br>
	 * メンバ変数の値を初期化します.
	 */
	public HistoryBean() {
		pid = "";
		title = "";
		publisher = "";
		author = "";
		genre = "";
		eval = "";
		area = "";
		price = "";
		state = 0;
		out_date = "";
		sche_date = "";
		in_date = "";
		evaluation = 0;
		impressions = "";

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

	public String getOutdate() {
		return out_date;
	}

	public void setOutdate(String out_date) {
		this.out_date = out_date;
	}

	public String getSchedate() {
		return sche_date;
	}

	public void setSchedate(String sche_date) {
		this.sche_date = sche_date;
	}

	public String getIndate() {
		return in_date;
	}

	public void setIndate(String in_date) {
		this.in_date = in_date;
	}

	public int getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(int evaluation) {
		this.evaluation = evaluation;
	}

	public String getImpressions() {
		return impressions;
	}

	public void setImpressions(String impressions) {
		this.impressions = impressions;
	}

}
