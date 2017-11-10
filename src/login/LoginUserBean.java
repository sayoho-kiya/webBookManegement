package login;
import java.io.Serializable;

public class LoginUserBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	// ID
	private String name;
	// 名前
	private String mailaddres;

	/**
	 * コンストラクタ.<br>
	 * メンバ変数の値を初期化します.
	 */

	public LoginUserBean() {

		this.id = "";

		this.name = "";

		this.mailaddres = "";
	}

	/**
	 * IDを返却します.
	 *
	 * @return ID
	 */

	public String getId() {
		return this.id;
	}

	/**
	 * IDを設定します.
	 *
	 * @param id
	 */

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 名前を返却します.
	 *
	 * @return 名前
	 */

	public String getName() {
		return this.name;
	}

	/**
	 * 名前を設定します.
	 *
	 * @param name
	 *            名前
	 */

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 年齢を返却します.
	 *
	 * @return 年齢
	 */
	public String getAddres() {
		return this.mailaddres;
	}

	/**
	 * 年齢を設定します.
	 *
	 * @param age
	 *            年齢
	 */
	public void setAddres(String mailaddres) {
		this.mailaddres = mailaddres;
	}
}
