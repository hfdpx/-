package system.entity;
/*
*@author:yb
*@version ����ʱ�䣺2018��1��16�� ����10:29:46
*/

/*
 * ���Ҷ���
 * id ���ұ��
 * name ��������
 * where ���ҵص�
 * d_o ������������
 */
public class Room {
	private int id;
	private String name;
	private int num;
	private String where;
	private String d_o;
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
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWhere() {
		return where;
	}
	public void setWhere(String where) {
		this.where = where;
	}
	public String getD_o() {
		return d_o;
	}
	public void setD_o(String d_o) {
		this.d_o = d_o;
	}
	
}
