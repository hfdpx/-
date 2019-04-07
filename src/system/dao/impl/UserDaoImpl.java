package system.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import system.dao.UserDao;
import system.entity.User;
import system.exception.DaoException;
import system.utils.DBUtils;

/*
*@author:yb
*@version ����ʱ�䣺2018��1��16�� ����11:24:06
*/

/*
 * ���ǽӿڷ����ľ���ʵ��
 * @Override������֤����ķ����ǲ��Ǹ����о��е�,����,��Ϊ���������û����������Ļ�����Ҳ�ܹ�ͨ��,��������Ϊ�������Լ�����д���ӷ���
 * // TODO Auto-generated method stub ��ʾ��˵����������Զ����ɵ�
 */
public class UserDaoImpl implements UserDao {

	@Override
	public List<User> listUser() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<User> users = new ArrayList<User>();
		User u;
		try {
			//������ݿ�����
			conn = (Connection) DBUtils.newConnection();
			//sql���
			final String sql = "select U_Id,U_Login_Name,U_Id_Card_Number,U_PassWord,U_Tel_Number,U_Adress from Users";
			//���PreparedStatement��ʵ��
			psmt = conn.prepareStatement(sql);
			//ִ��sql����ý����
			rs = psmt.executeQuery();
			while(rs.next()) {
				u=new User();
				u.setId(rs.getInt(1));
				u.setLoginName(rs.getString(2));
				u.setIdCardName(rs.getString(3));
				u.setPassWord(rs.getString(4));
				u.setTelNumber(rs.getString(5));
				u.setAdress(rs.getString(6));
				users.add(u);
			}
			
		}catch(Exception e){
			throw new DaoException(e);
		}finally {//finally �еĴ���һ���ᱻִ��
			DBUtils.close(conn, psmt, rs);//�ֶ��ͷ�������Դ
		}
		return users;
	}

	@Override
	public User getUserByLoginName(String loginName) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		User u=null;
		try {
			//������ݿ�����
			conn = (Connection) DBUtils.newConnection();
			//sql���
			final String sql = "select U_Id,U_Login_Name,U_Id_Card_Number,U_PassWord,U_Tel_Number,U_Adress from Users where U_Login_Name=?";
			//���PreparedStatement��ʵ��
			psmt = conn.prepareStatement(sql);
			//�󶨲���
			psmt.setString(1,loginName);
			//ִ��sql����ý����
			rs = psmt.executeQuery();
			if(rs.next()) {
				u=new User();
				u.setId(rs.getInt(1));
				u.setLoginName(rs.getString(2));
				u.setIdCardName(rs.getString(3));
				u.setPassWord(rs.getString(4));
				u.setTelNumber(rs.getString(5));
				u.setAdress(rs.getString(6));
			}
		}catch(Exception e2) {
			throw new DaoException(e2);
		}finally {
			// �����ֶ��ͷ�������Դ
			DBUtils.close(conn, psmt, rs);
		}
		return u;
	}

	@Override
	public void deleteUserByLoginName(String loginName) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			//������ݿ�����
			conn = (Connection) DBUtils.newConnection();
			//sql���
			final String sql = "CALL delete_user_By_U_Login_Name(?)";
			//���PreparedStatement��ʵ��
			psmt = conn.prepareStatement(sql);
			//�󶨲���
			psmt.setString(1,loginName);
			//ִ��sql����ý����
			rs = psmt.executeQuery();
		}catch(Exception e3) {
			throw new DaoException(e3);
		}finally {
			// �����ֶ��ͷ�������Դ
			DBUtils.close(conn, psmt, rs);
		}

	}

	@Override
	public void updateUserByLoginName(String loginName, User user) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			//������ݿ�����
			conn = (Connection) DBUtils.newConnection();
			//sql���
			final String sql = "update Users set U_PassWord=?,U_Tel_Number=?,U_Adress=? where U_Login_Name = ?";
			//���PreparedStatement��ʵ��
			psmt = conn.prepareStatement(sql);
			//�󶨲���
			psmt.setString(1, user.getPassWord());
			psmt.setString(2, user.getTelNumber());
			psmt.setString(3, user.getAdress());
			psmt.setString(4,loginName);
			//ִ��sql����ý����
			psmt.execute();
		}catch(Exception e4) {
			throw new DaoException(e4);
		}finally {
			// �����ֶ��ͷ�������Դ
			DBUtils.close(conn, psmt, rs);
		}
	}

	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			//������ݿ�����
			conn = (Connection) DBUtils.newConnection();
			//sql���
			final String sql = "insert into Users values(?,?,?,?,?,?)";
			//���PreparedStatement��ʵ��
			psmt = conn.prepareStatement(sql);
			//�󶨲���
			psmt.setInt(1, user.getId());
			psmt.setString(2, user.getLoginName());
			psmt.setString(3, user.getIdCardName());
			psmt.setString(4, user.getPassWord());
			psmt.setString(5, user.getTelNumber());
			psmt.setString(6, user.getAdress());
			//ִ��sql����ý����
			psmt.execute();
		}catch(Exception e4) {
			throw new DaoException(e4);
		}finally {
			// �����ֶ��ͷ�������Դ
			DBUtils.close(conn, psmt, rs);
		}
		
	}

	@Override
	public User getUserByCardNumber(String cardNumber) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		User u=null;
		try {
			//������ݿ�����
			conn = (Connection) DBUtils.newConnection();
			//sql���
			final String sql = "select U_Id,U_Login_Name,U_Id_Card_Number,U_PassWord,U_Tel_Number,U_Adress from Users where U_Id_Card_Number=?";
			//���PreparedStatement��ʵ��
			psmt = conn.prepareStatement(sql);
			//�󶨲���
			psmt.setString(1,cardNumber);
			//ִ��sql����ý����
			rs = psmt.executeQuery();
			if(rs.next()) {
				u=new User();
				u.setId(rs.getInt(1));
				u.setLoginName(rs.getString(2));
				u.setIdCardName(rs.getString(3));
				u.setPassWord(rs.getString(4));
				u.setTelNumber(rs.getString(5));
				u.setAdress(rs.getString(6));
			}
		}catch(Exception e2) {
			throw new DaoException(e2);
		}finally {
			// �����ֶ��ͷ�������Դ
			DBUtils.close(conn, psmt, rs);
		}
		return u;
	}

	@Override
	public User getUserByID(int userID) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		User u=null;
		try {
			//������ݿ�����
			conn = (Connection) DBUtils.newConnection();
			//sql���
			final String sql = "select U_Id,U_Login_Name,U_Id_Card_Number,U_PassWord,U_Tel_Number,U_Adress from Users where U_Id=?";
			//���PreparedStatement��ʵ��
			psmt = conn.prepareStatement(sql);
			//�󶨲���
			psmt.setInt(1,userID);
			//ִ��sql����ý����
			rs = psmt.executeQuery();
			if(rs.next()) {
				u=new User();
				u.setId(rs.getInt(1));
				u.setLoginName(rs.getString(2));
				u.setIdCardName(rs.getString(3));
				u.setPassWord(rs.getString(4));
				u.setTelNumber(rs.getString(5));
				u.setAdress(rs.getString(6));
			}
		}catch(Exception e2) {
			throw new DaoException(e2);
		}finally {
			// �����ֶ��ͷ�������Դ
			DBUtils.close(conn, psmt, rs);
		}
		return u;
	}
	
	
}
