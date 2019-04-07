package system.service.impl;

import java.util.List;
import java.util.Vector;

import system.dao.DoDao;
import system.dao.DoctorDao;
import system.dao.RoomDao;
import system.dao.UserDao;
import system.dao.impl.DoDaoImpl;
import system.dao.impl.DoctorDaoImpl;
import system.dao.impl.RoomDaoImpl;
import system.dao.impl.UserDaoImpl;
import system.entity.DO;
import system.entity.Doctor;
import system.entity.Room;
import system.entity.User;
import system.exception.DaoException;
import system.exception.UsernameOrPwdErrorException;
import system.service.DoService;
import system.service.UserService;

public class DoServiceImpl implements DoService {
	private UserDao userDao;
    private int userID;
    private int doctorID;
    private DoDao doDao;
    private List<DO> listdo;
    private DoctorDao doctorDao=new DoctorDaoImpl();
    
	@Override
	public Vector<Vector<String>> getDoByUserName(String username)
			throws DaoException, UsernameOrPwdErrorException {
		userDao=new UserDaoImpl();
		userID=userDao.getUserByLoginName(username).getId();
		//System.out.println(userID);
		doDao=new DoDaoImpl();
		listdo=doDao.getListDoByUserId(userID);//ͨ��userid����û�ԤԼ��Ϣ
		//System.out.println(listdo);
		Vector<Vector<String>> vectors = new Vector<Vector<String>>();
		for (DO doentity : listdo){
			Vector<String> vertorDO=new Vector<String>();
			Doctor doctor=doctorDao.getDoctorByID(doentity.getdId());//���ԤԼ��ID�Ŷ�Ӧ��doctorʵ��
			
			//��ROom���Ӳ����Ӧ�Ŀ�����
			RoomDao  roomDao=new RoomDaoImpl();
			Room room=roomDao.getRoomByID(doctor.getBelongRoom());
			vertorDO.add(username);
			vertorDO.add(doctor.getName());
			vertorDO.add(String.valueOf(room.getName()));
			//System.out.println(String.valueOf(room.getName()));
			vertorDO.add(doctor.getWorkWhere());
			vertorDO.add(doctor.getTime());
			vectors.add(vertorDO);
		}
		return vectors;
	}
	@Override
	public void deleteDoByID(String  userName,String doctorName) throws DaoException,
		UsernameOrPwdErrorException {
		Doctor doctor=new Doctor();
		User user=new User();
		UserDao userDao=new UserDaoImpl();
		user=userDao.getUserByLoginName(userName);
		DoctorDao doctorDao=new DoctorDaoImpl();
		doctor=doctorDao.getDoctorByLoginName(doctorName);
		doDao=new DoDaoImpl();
		doDao.deleteDo(user.getId(), doctor.getId());
	}
	
	@Override
	public Vector<Vector<String>> getDoByDoctorName(String doctorname)
			throws DaoException, UsernameOrPwdErrorException {
		
		DoctorDao doctorDao=new DoctorDaoImpl();
		int doctorId=doctorDao.getDoctorByLoginName(doctorname).getId();//�õ�DoctorID
		//System.out.print(doctorId);
		doDao=new DoDaoImpl();
		listdo=doDao.getListDoByDoctorId(doctorId);//����ԤԼ��Ϣ��List�б�
		//System.out.print(listdo);
		Vector<Vector<String>> vectors = new Vector<Vector<String>>();
		
		
		for (DO doentity : listdo){
			Vector<String> vertorDO=new Vector<String>();
			//ͨ��ҽ����ID�õ�ҽ��ʵ��
			Doctor doctor=doctorDao.getDoctorByID(doentity.getdId());
			
			//System.out.println(doctor.getLevel());
			
			//ͨ���û�ID�õ��û�ʵ��
			UserDao userDao=new UserDaoImpl();
			User user=userDao.getUserByID(doctorId);
			//��ROom���Ӳ����Ӧ�Ŀ�����
			RoomDao  roomDao=new RoomDaoImpl();
			Room room=roomDao.getRoomByID(doctor.getBelongRoom());
			vertorDO.add( user.getLoginName());
			vertorDO.add(doctor.getName());
			vertorDO.add(room.getName());
			vertorDO.add(room.getWhere());
			vertorDO.add(doctor.getTime());
			vectors.add(vertorDO);
		}
		return vectors;
	}
	
	public static void main(String[] args){
		DoServiceImpl s=new DoServiceImpl();
		s.getDoByDoctorName("�Է���");
	}
	
	
	
	
}
