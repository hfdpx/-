package system.test;

import java.util.List;

import org.junit.Test;

import system.dao.UserDao;
import system.dao.impl.UserDaoImpl;
import system.entity.User;

/*
*@author:yb
*@version ����ʱ�䣺2018��1��16�� ����2:05:07
*/
/*
 * ���������:���ж��û����dao����в���,�������Ҫ�ٴν��в���,���Կ���ע�͵��Ĵ������½��в���,����ע�ⲻҪ�����д���ȫ���⿪ע�������в���,�����ᵼ�����ݻ���
 * 
 */
public class UserDaoTest {
	private UserDao userdao = new UserDaoImpl();
	
//	@Test//���е�Ԫ����,�ܷ����һ������,������void �޲������͵�
//	public void listUser() {
//		List<User> users = userdao.listUser();
//		
//		for(User user:users) {
//			System.out.println(user.getLoginName());
//		}
//	}
	
	/*
	@Test
	public void getUserByLoginName() {
		String loginName="������";
		User u = null;
		u=userdao.getUserByLoginName(loginName);
		System.out.println(u.getLoginName()+" "+u.getIdCardName());
	}
	*/
	
	@Test
	public void deleteUserByLoginName() {
		userdao.deleteUserByLoginName("���");
	}
	
	/*
	@Test
	public void updateUserByLoginName() {
		User user=null;
		String loginName="���";
		user=userdao.getUserByLoginName(loginName);
		user.setAdress("������ҽҩ��ѧ034300");
		user.setPassWord("123456");
		user.setTelNumber("11111");
		userdao.updateUserByLoginName(loginName, user);
	}
	*/
	/*
	@Test
	public void insertUser() {
		User u = new User();
		u.setId(11);
		u.setLoginName("���");
		u.setIdCardName("xxxxx");
		u.setPassWord("321");
		u.setTelNumber("963852");
		u.setAdress("adasdasda");
		userdao.insertUser(u);
	}
	*/
}
