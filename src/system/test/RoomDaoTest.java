package system.test;

import org.junit.Test;

import system.dao.RoomDao;
import system.dao.impl.RoomDaoImpl;
import system.entity.Room;

/*
*@author:yb
*@version ����ʱ�䣺2018��1��16�� ����11:16:47
* ˵��:���Ե����д�������yb�Ѿ�����,����Ҫ���²���,�ɴ���⿪ע�ͼ���
*/
/*
 * Room��Dao�����
 */
public class RoomDaoTest {
	private RoomDao roomDao = new  RoomDaoImpl();
	
//	@Test
//	public void listRoom() {
//		List<Room> rooms = roomDao.listRoom();
//		System.out.println(rooms.size());
//		for(Room room:rooms) {
//			System.out.println(room.getD_o());
//		}
//	}
	
//	@Test
//	public void getRoomByRoomName() {
//		String name = "�������";
//		Room room = roomDao.getRoomByRoomName(name);
//		System.out.println(room.getD_o());
//	}
	
//	@Test
//	public void deleteRoomByRoomName() {
//		String name = "�������";
//		roomDao.deleteRoomByRoomName(name);
//	}
	
//	@Test
//	public void updateRoomByRoomName() {
//		String name = "���ڿ�";
//		Room r = new Room();
//		r = roomDao.getRoomByRoomName(name);
//		r.setD_o("xxx");
//		r.setName("ssssssss");
//		r.setWhere("asdasdas");
//		roomDao.updateRoomByRoomName(name, r);
//	}
//	
//	@Test
//	public void insertRoom() {
//		Room r = new Room();
//		r.setId(2);
//		r.setName("xxxxxxss");
//		r.setNum(0);
//		r.setWhere("ssssssssdfgsfs");
//		r.setD_o("asdasdasdasddddsss");
//		roomDao.insertRoom(r);
//	}
}
