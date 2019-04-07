package system.service;

import java.util.Vector;

import system.exception.DaoException;
import system.exception.UsernameOrPwdErrorException;

public interface DoService {
	//ͨ���û����õ��û�ԤԼ��Ϣ
	public Vector<Vector<String>> getDoByUserName(String name)
			throws DaoException,UsernameOrPwdErrorException;
    //ͨ���û���ɾ��ԤԼ��Ϣ
	public void deleteDoByID(String  userName,String doctorName)
    		throws DaoException,UsernameOrPwdErrorException;
	//ͨ��ҽ�����õ�ԤԼ��Ϣ
	public Vector<Vector<String>> getDoByDoctorName(String name)
			throws DaoException,UsernameOrPwdErrorException;

}
