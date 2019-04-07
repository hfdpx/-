package system.dao;
import java.util.List;

import system.entity.User;
/*
*@author:yb
*@version ����ʱ�䣺2018��1��16�� ����11:02:19
*/

/*
 * �ýӿڶ�������û���ķ��ʹ���
 */
public interface UserDao {
	/*
	 * �����ѯ�����û���Ϣ�ķ���
	 */
	public List<User> listUser();
	
	/*
	 * ��������û���½����ѯ�û���Ϣ�ķ���
	 */
	public User getUserByLoginName(String loginName);
	
	/*
	 * ����ɾ���û��ķ���,ͨ���û���¼��
	 */
	public void deleteUserByLoginName(String loginName);
	
	/*
	 * �����޸��û��ķ���,ͨ���û���¼��
	 */
	public void updateUserByLoginName(String loginName,User user);
	
	/*
	 * ��������û��ķ���
	 */
	public void insertUser(User user);
	
	/*
	 * ��������û����֤�����ѯ�û���Ϣ�ķ���
	 */
	public User getUserByCardNumber(String cardNumber);
	
	/*
	 * ��������û�ID��ѯ�û���Ϣ�ķ���
	 */
	public User getUserByID(int  userID);
	
}
