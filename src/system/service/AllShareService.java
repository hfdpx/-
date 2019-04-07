package system.service;

import system.entity.Doctor;
import system.entity.User;
import system.exception.DaoException;
import system.exception.UsernameOrPwdErrorException;

/*
*@author:yb
*@version ����ʱ�䣺2018��1��17�� ����3:39:33
*/
/*
 * �������ж������ҵ�����
 */
public interface AllShareService {
	/*
	 * �����û���½��ҵ���߼�
	 */
	public User userLogin(String name,String password)
	       throws DaoException,UsernameOrPwdErrorException;
	
	/*
	 * ����ҽ����½��ҵ���߼�
	 */
	public Doctor doctorLogin(String name,String password)
			throws DaoException,UsernameOrPwdErrorException;
	
}
