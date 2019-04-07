package system.dao;

import java.util.List;

import system.entity.DO;

/*
*@author:yb
*@version ����ʱ�䣺2018��1��16�� ����11:53:45
*/
/*
 * �ýӿڶ����˷���DO������й���
 */
public interface DoDao {
	/*
	 * �����ѯ����ԤԼ�ķ���
	 */
	public List<DO> listDo();
	
	/*
	 * ����ͨ���û�id���DO����ķ���
	 */
	public DO getDo(int uId);
	
	/*
	 * ��������ԤԼ�ķ���
	 */
	public void insertDo(DO d_o);
	
	/*
	 * ����ɾ��ԤԼ�ķ���
	 */
	public void deleteDo(int uId,int doctorId);
	
	/*
	 * �����޸�ԤԼ�ķ���
	 */
	public void updateDo(int uId,DO d_o);
	
	//
	public DO getDoByUserId(int uId);
	
	public List<DO> getListDoByUserId(int uId);
	
	public DO getDoByDoctorId(int docId);
	
	public List<DO> getListDoByDoctorId(int docId);
	
}
