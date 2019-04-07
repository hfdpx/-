package system.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import system.dao.RoomDao;
import system.entity.Doctor;
import system.entity.Room;
import system.exception.DaoException;
import system.utils.DBUtils;

/*
*@author:yb
*@version ����ʱ�䣺2018��1��16�� ����11:10:25
*/
/*
 * �����ǹ���Room��������ʵ�ַ���
 */
public class RoomDaoImpl implements RoomDao {

	@Override
	public List<Room> listRoom() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<Room> rooms = new ArrayList<Room>();
		Room room;
		
		try {
			//������ݿ�����
			conn = (Connection) DBUtils.newConnection();
			//sql���
			final String sql = "select * from Room";
			//���PreparedStatement��ʵ��
			psmt = conn.prepareStatement(sql);
			//ִ��sql����ý����
			rs = psmt.executeQuery();
			while(rs.next()) {
				room = new Room();
				room.setId(rs.getInt(1));
				room.setName(rs.getString(2));
				room.setNum(rs.getInt(3));
				room.setWhere(rs.getString(4));
				room.setD_o(rs.getString(5));
				rooms.add(room);
			}
			
		}catch(Exception e){
			throw new DaoException(e);
		}finally {//finally �еĴ���һ���ᱻִ��
			DBUtils.close(conn, psmt, rs);//�ֶ��ͷ�������Դ
		}
		
		return rooms;
	}

	@Override
	public Room getRoomByRoomName(String name) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		Room room = null;
		try {
			//������ݿ�����
			conn = (Connection) DBUtils.newConnection();
			//sql���
			final String sql = "select * from Room where R_Name=?";
			//���PreparedStatement��ʵ��
			psmt = conn.prepareStatement(sql);
			//�󶨲���
			psmt.setString(1,name);
			//ִ��sql����ý����
			rs = psmt.executeQuery();
			if(rs.next()) {
				room = new Room();
				room.setId(rs.getInt(1));
				room.setName(rs.getString(2));
				room.setNum(rs.getInt(3));
				room.setWhere(rs.getString(4));
				room.setD_o(rs.getString(5));
			}
		}catch(Exception e2) {
			throw new DaoException(e2);
		}finally {
			// �����ֶ��ͷ�������Դ
			DBUtils.close(conn, psmt, rs);
		}
		return room;
	}

	@Override
	public void deleteRoomByRoomName(String name) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			//������ݿ�����
			conn = (Connection) DBUtils.newConnection();
			//sql���
			final String sql = "CALL delete_Room_By_Room_Name(?)";
			//���PreparedStatement��ʵ��
			psmt = conn.prepareStatement(sql);
			//�󶨲���
			psmt.setString(1,name);
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
	public void updateRoomByRoomName(String name, Room r) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			//������ݿ�����
			conn = (Connection) DBUtils.newConnection();
			//sql���
			final String sql = "update Room set R_Name=?,R_Where=?,R_DO=? where R_Name=?";
			//���PreparedStatement��ʵ��
			psmt = conn.prepareStatement(sql);
			//�󶨲���
			psmt.setString(1, r.getName());
			psmt.setString(2, r.getWhere());
			psmt.setString(3, r.getD_o());
			psmt.setString(4, name);
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
	public void insertRoom(Room r) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			//������ݿ�����
			conn = (Connection) DBUtils.newConnection();
			//sql���
			final String sql = "insert into Room values(?,?,?,?,?)";
			//���PreparedStatement��ʵ��
			psmt = conn.prepareStatement(sql);
			//�󶨲���
			psmt.setInt(1, r.getId());
			psmt.setString(2, r.getName());
			psmt.setInt(3,0);
			psmt.setString(4, r.getWhere());
			psmt.setString(5, r.getD_o());
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
	public Room getRoomByID(int id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		Room room = null;
		try {
			//������ݿ�����
			conn = (Connection) DBUtils.newConnection();
			//sql���
			final String sql = "select * from Room where R_Id=?";
			//���PreparedStatement��ʵ��
			psmt = conn.prepareStatement(sql);
			//�󶨲���
			psmt.setInt(1, id);
			//ִ��sql����ý����
			rs = psmt.executeQuery();
			if(rs.next()) {
				room = new Room();
				room.setId(rs.getInt(1));
				room.setName(rs.getString(2));
				room.setNum(rs.getInt(3));
				room.setWhere(rs.getString(4));
				room.setD_o(rs.getString(5));
			}
		}catch(Exception e2) {
			throw new DaoException(e2);
		}finally {
			// �����ֶ��ͷ�������Դ
			DBUtils.close(conn, psmt, rs);
		}
		return room;
	}
	public static void main(String[] args){
		RoomDaoImpl r=new RoomDaoImpl();
		Room room=r.getRoomByRoomName("����");
		System.out.print(room.getId());
	}
	

}
