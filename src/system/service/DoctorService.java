package system.service;

import system.entity.Doctor;
import system.exception.DaoException;
import system.exception.UsernameOrPwdErrorException;

/*
*@author:yb
*@version ����ʱ�䣺2018��1��18�� ����8:47:42
*/
/*
 * ����ҽ�������ҵ�����
 */
public interface DoctorService {
	/*
	 * ����������ҽ����Ϣ��ҵ�����,Ҫ�󷵻� "ҽ�����", "ҽ������", "�Ա�", "����", "��������","�ó�����","�칫�ص�" ��ɵĶ�ά�ַ������� 
	 */
	public String[][] getDoctorMessage() throws DaoException,UsernameOrPwdErrorException;

	/*
	 * ���������˼���ֻ��ĳ��ҽ����Ϣ��ҵ�����,Ҫ�󷵻� "ҽ�����", "ҽ������", "�Ա�", "����", "��������","�ó�����","�칫�ص�" ��ɵĶ�ά�ַ������� 
	 */
	public String[][] getOneDoctorMessage(String name) throws DaoException,UsernameOrPwdErrorException;

 
	/*
	 * �������ҽ����ְ�񷵻����е�ҽ��,,Ҫ�󷵻� "ҽ�����", "ҽ������", "�Ա�", "����", "��������","�ó�����","�칫�ص�" ��ɵĶ�ά�ַ������� 
	 */
	public String[][] getSomeDoctorMessageByLevel(String level) throws DaoException,UsernameOrPwdErrorException;

	/*
	 * ����ҽ���Ŀ��ҷ������е�ҽ��Ҫ�󷵻� "ҽ�����", "ҽ������", "�Ա�", "����", "��������","�ó�����","�칫�ص�" ��ɵĶ�ά�ַ������� 
	 */
	public String[][] getSomeDoctorMessageByRoom(String rName) throws DaoException,UsernameOrPwdErrorException;

	//
	public void updateDoctorByLoginName(Doctor doctor)
			throws DaoException;
	
}
