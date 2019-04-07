package system.service;

import system.entity.User;
import system.exception.DaoException;
import system.exception.UsernameOrPwdErrorException;

/*
*@author:yb
*@version ����ʱ�䣺2018��1��17�� ����10:35:43
*/
/*
 * �����û�����ҵ�����
 */
public interface UserService {
	/*
	 * �����������û���Ϣ��ҵ���߼�,Ҫ�󷵻�"�û����", "�û�����", "�û��绰", "�û���ַ", "�û����֤��"��Щ�ض���Ϣ,����һ����ά�ַ������鷵��
	 */
	public String[][] getUserMessage() throws DaoException,UsernameOrPwdErrorException;
	
	/*
	 * ����ͨ���û��ĵ�¼������û���Ϣ,Ҫ�󷵻�"�û����", "�û�����", "�û��绰", "�û���ַ", "�û����֤��"��Щ�ض���Ϣ,����һ����ά�ַ������鷵��
	 */
	public String[][] getOneUserMessageByName(String name) throws DaoException,UsernameOrPwdErrorException;

	/*
	 * ����ͨ���û������֤�������û���Ϣ
	 */
	public String[][] getOneMessageByCardNumber(String cardNumber) throws DaoException,UsernameOrPwdErrorException;


	//
	public void updateUserByLoginName(User user) 
			throws DaoException,UsernameOrPwdErrorException;
    public int  getUserIdByName(String username)
    		throws DaoException,UsernameOrPwdErrorException;
    
}
