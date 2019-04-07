package system.test;

import java.util.List;

import org.junit.Test;

import system.dao.DoctorDao;
import system.dao.impl.DoctorDaoImpl;
import system.entity.Doctor;
import system.exception.DaoException;

/*
*@author:yb
*@version ����ʱ�䣺2018��1��16�� ����6:59:13
*/
/*
 * doctor��dao�������
 * ˵��:���Ե����д�������yb�Ѿ�����,����Ҫ���²���,�Ѵ���⿪ע�ͼ���
 */
public class DoctorDaoTest {
	private DoctorDao doctorDao = new DoctorDaoImpl();
	@Test
	public void listDoctor() {
		List<Doctor> doctors = doctorDao.listDoctor();
		System.out.println(doctors.size());
		for(Doctor doctor:doctors) {
			System.out.println(doctor.getLoginName());
		}
	}
	
//	@Test
//	public void getDoctorByLoginName() {
//		String loginName="��";
//		Doctor d = null;
//		d=doctorDao.getDoctorByLoginName(loginName);
//		System.out.println(d.getLoginName()+" "+d.getLevel());
//		
//	}
	
//	@Test
//	public void deleteDoctorByLoginName() {
//		doctorDao.deleteDoctorByLoginName("��С��");
//	}
	
//	@Test
//	public void updateDoctorByLoginName() {
//		Doctor d = null;
//		String loginName="��";
//		d = doctorDao.getDoctorByLoginName(loginName);
//		d.setLevel("����ҽʦ");
//		d.setBelongRoom(2);
//		d.setWorkWhere("www");
//		d.setLoginPassWord("ssss");
//		d.setGoodAt("dsdasd");
//		doctorDao.updateDoctorByLoginName(loginName, d);
//	}
	
//	@Test
//	public void insertDoctor() {
//		Doctor d = new Doctor();
//		d.setId(11);
//		d.setLevel("xxx");
//		d.setLoginName("sb");
//		d.setLoginPassWord("123");
//		d.setName("sb");
//		d.setSex("��");
//		d.setWorkWhere("sssss");
//		d.setBelongRoom(1);
//		d.setGoodAt("asdasdas");
//		doctorDao.insertDoctor(d);
//	
//	}
	
}
