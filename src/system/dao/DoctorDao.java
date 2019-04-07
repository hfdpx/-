package system.dao;

import java.util.List;

import system.entity.Doctor;

/*
*@author:yb
*@version ����ʱ�䣺2018��1��16�� ����6:31:29
*/

/*
 * �ýӿڶ������ҽ����Ϣ������й���
 */
public interface DoctorDao {
	/*
	 * �����ѯ����ҽ����Ϣ�ķ���
	 */
	public List<Doctor> listDoctor();
	
	/*
	 * ����ͨ��ְ���ѯһЩҽ����Ϣ�ķ���
	 */
	
	public List<Doctor> listSomeDoctorByLevel(String level);
	
	/*
	 * ����ͨ�����Ҳ�ѯһЩҽ����Ϣ�ķ���
	 */
	public List<Doctor> listSomeDoctorByRoom(String rName);
	
	
	/*
	 * ����ͨ��ҽ����¼����ѯҽ����Ϣ�ķ���
	 */
	
	public Doctor getDoctorByLoginName(String loginName);
	
	/*
	 * ����ͨ��ҽ����¼��ɾ��ҽ���ķ���
	 */
	public void deleteDoctorByLoginName(String loginName);
	
	/*
	 * ����ͨ��ҽ����¼���޸�ҽ����Ϣ�ķ���
	 */
	public void updateDoctorByLoginName(String loginName,Doctor doctor);
	
	/*
	 * �������ҽ����Ϣ�ķ���
	 */
	public void insertDoctor(Doctor doctor);
	
	//
	public Doctor getDoctorByID(int doctorID);
	
}
