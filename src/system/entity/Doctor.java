package system.entity;
/*
*@author:yb
*@version ����ʱ�䣺2018��1��16�� ����10:30:01
*/

/*
 * ҽ������
 * id ҽ�����
 * name ҽ������
 * sex ҽ���Ա�
 * level ҽ��ְ�񼶱�
 * belongRoom ҽ����������
 * workWhere ҽ�����ҵص�
 * loginName ҽ����¼��
 * loginPassWord ҽ������
 */
public class Doctor {
	private int id;
	private String name;
	private String sex;
	private String level;
	private int belongRoom;
	private String workWhere;
	private String loginName;
	private String loginPassWord;
	private String goodAt;
	private String time;
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getGoodAt() {
		return goodAt;
	}
	public void setGoodAt(String goodAt) {
		this.goodAt = goodAt;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int getBelongRoom() {
		return belongRoom;
	}
	public void setBelongRoom(int belongRoom) {
		this.belongRoom = belongRoom;
	}
	public String getWorkWhere() {
		return workWhere;
	}
	public void setWorkWhere(String workWhere) {
		this.workWhere = workWhere;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPassWord() {
		return loginPassWord;
	}
	public void setLoginPassWord(String loginPassWord) {
		this.loginPassWord = loginPassWord;
	}
	
}
