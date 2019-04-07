package system.service.impl;

import system.dao.DoctorDao;
import system.dao.UserDao;
import system.dao.impl.DoctorDaoImpl;
import system.dao.impl.UserDaoImpl;
import system.entity.Doctor;
import system.entity.User;
import system.exception.DaoException;
import system.exception.UsernameOrPwdErrorException;
import system.service.AllShareService;

/*
*@author:yb
*@version ����ʱ�䣺2018��1��17�� ����3:55:26
*/
public class AllShareServiceImpl implements AllShareService{

	private UserDao userDao = new UserDaoImpl();
	private DoctorDao doctorDao = new DoctorDaoImpl();
	@Override
	public User userLogin(String name, String password) throws DaoException, UsernameOrPwdErrorException {
		// TODO Auto-generated method stub
		// 1.���⹦�ܣ�У�����ݸ�ʽ "" "  " "        "
		String reg = "\\s*";// ��ʾ������߶���ո�
		if (name == null || name.matches(reg)) {
			throw new RuntimeException("��ʽ����ȷ");
		}
		if (password == null || password.matches(reg)) {
			throw new RuntimeException("��ʽ����ȷ");
		}
		
		User u = null;
		u = userDao.getUserByLoginName(name);
		if(u==null) {
			throw new UsernameOrPwdErrorException("�û��������������");
		}else if(!password.equals(u.getPassWord())) {
			throw new UsernameOrPwdErrorException("�û��������������");
		}
					
		return u;
	}

	@Override
	public Doctor doctorLogin(String name, String password) throws DaoException, UsernameOrPwdErrorException {
		// TODO Auto-generated method stub
		String reg = "\\s*";// ��ʾ������߶���ո�
		if (name == null || name.matches(reg)) {
			throw new RuntimeException("��ʽ����ȷ");
		}
		if (password == null || password.matches(reg)) {
			throw new RuntimeException("��ʽ����ȷ");
		}
		
		Doctor d = null;
		d = doctorDao.getDoctorByLoginName(name);
		if(d==null) {
			throw new UsernameOrPwdErrorException("�û��������������");
		}else if(!password.equals(d.getLoginPassWord())) {
			throw new UsernameOrPwdErrorException("�û��������������");
		}
		
		return d;
	}
	
}
