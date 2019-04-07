package system.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import system.exception.DaoException;

/*
*@author:yb
*@version ����ʱ�䣺2018��1��16�� ����10:33:45
*/
public class DBUtils {
	private static String username;
	private static String pwd;
	private static String url;
	private static String className;
	
	static {
		try {

			// ��ȡ�����ļ� db.properties�ļ�
			Properties prop = new Properties();
			// �ƶ������ļ���λ��:ͨ�������ȡ�����ļ�
			InputStream in = DBUtils.class.getClassLoader()
					.getResourceAsStream("db.properties");
			prop.load(in);
			username = prop.getProperty("jdbc.username");
			pwd = prop.getProperty("jdbc.pwd");
			url = prop.getProperty("jdbc.url");
			className = prop.getProperty("jdbc.className");

			// ��������
			Class.forName(className);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/*
	 * ���Connection����Ĺ��߷��� newConnection
	 */
	public static Connection newConnection() throws DaoException {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url, username, pwd);
		} catch (SQLException e) {
			throw new DaoException(e);
		}

		return conn;
	}

	/*
	 * �����ͷ���Դ�Ĺ��߷���close
	 */
	public static void close(Connection conn, Statement pstm, ResultSet rs)
			throws DaoException {
		try {

			if (rs != null) {
				rs.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public static void close(Connection conn, Statement pstm)
			throws DaoException {
		close(conn, pstm, null);
	}

	public static void close(Connection conn) throws DaoException {
		close(conn, null, null);
	}

}
