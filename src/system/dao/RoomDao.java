package system.dao;

import java.util.List;

import system.entity.Room;

/*
*@author:yb
*@version ����ʱ�䣺2018��1��16�� ����10:45:18
*/
/*
 * �ýӿڶ�����ʿ��ұ�����й���
 */
public interface RoomDao {
	/*
	 * �����ѯ���п��ҵķ���
	 */
	public List<Room> listRoom();
	
	/*
	 * ������ݿ�������ѯ���ҵķ���
	 */
	public Room getRoomByRoomName(String name);
	
	/*
	 * ������ݿ�������ɾ�����ҵķ���
	 */
	public void deleteRoomByRoomName(String name);
	
	/*
	 * ������ݿ��������޸Ŀ�����Ϣ�ķ���
	 */
	public void updateRoomByRoomName(String name,Room r);
	
	/*
	 * �������ӿ��ҵķ���
	 */
	public void insertRoom(Room r);
	
	/*
	 * ������ݿ���ID��ѯ���ҵķ���
	 */
	public Room getRoomByID(int id);
	
}
