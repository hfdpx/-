package system.test;

import org.junit.Test;

import system.service.UserService;
import system.service.impl.UserServiceImpl;

/*
*@author:yb
*@version ����ʱ�䣺2018��1��17�� ����10:58:57
*/
public class UserServiceTest {
	UserService userService = new UserServiceImpl();
	
	
	@Test
	public void test1() {
		String[][] dates = userService.getUserMessage();
		for(int i=0;i<5;i++) {
			System.out.println(dates[i][0]);
		}
	}
}
