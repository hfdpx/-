package system.test;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import system.utils.DBUtils;

/*
 *@author:yb
 *@version ����ʱ�䣺2018��1��16�� ����10:34:43
 */
/*
 * ��ȡ�����ݿ����ӵĹ�����
 */
/*
 * ���ݿ�����:
 * hospital_reservation_registration_system
 */
public class JDBCTest {
	@Test
	public void testConnection() throws Exception {
		String username = "root";
		String pwd = "";
		String url = "jdbc:mysql://localhost:3306/hospital_reservation_registration_system?useUnicode=true& characterEncoding=utf8";

		// 1. �������ݿ�������
		Class.forName("com.mysql.jdbc.Driver");
		// 2. ͨ�^DirverManager�@��Connection�Č���
		Connection conn = DriverManager.getConnection(url, username, pwd);
		System.out.println(conn);
	}

	@Test
	public void testNewConnection() {
		Connection conn = DBUtils.newConnection();
		System.out.println(conn);

	}

}
