package book;

import java.io.Serializable;

public class ItemBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String pid;
	private String title;

	/**
	 * コンストラクタ.<br>
	 * メンバ変数の値を初期化します.
	 */
	public ItemBean() {
		pid = "";
		title = "";

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

}