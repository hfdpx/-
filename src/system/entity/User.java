package system.entity;
/*
*@author:yb
*@version ����ʱ�䣺2018��1��16�� ����10:29:13
*/

/*
 * �û�����
 * id �û�id
 * loginName �û���¼��
 * idCardNumber �û����֤����
 * password �û���½����
 * telNumber �û��绰
 * adress �û�סַ
 */
public class User {
	private int id;
	private String loginName;
	private String idCardName;
	private String passWord;
	private String telNumber;
	private String adress;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getIdCardName() {
		return idCardName;
	}
	public void setIdCardName(String idCardName) {
		this.idCardName = idCardName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getTelNumber() {
		return telNumber;
	}
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
}
