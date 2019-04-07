package system.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import system.dao.DoctorDao;
import system.dao.RoomDao;
import system.dao.impl.DoctorDaoImpl;
import system.dao.impl.RoomDaoImpl;
import system.entity.Doctor;
import system.view.DoctorAddView;

/*
*@author:yb
*@version ����ʱ�䣺2018��1��18�� ����3:27:02
*/
public class DoctorRigisterViewListener implements ActionListener{

	private DoctorAddView doctorAddView;
	private DoctorDao doctorDao;
	
	public DoctorRigisterViewListener(DoctorAddView doctorAddView) {
		this.doctorAddView=doctorAddView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		RoomDao roomDao = new RoomDaoImpl();
		doctorDao = new DoctorDaoImpl();
		Doctor d = new Doctor();
		
		d.setName(doctorAddView.getJtf1().getText());
		d.setSex(doctorAddView.getJtf2().getText());
		d.setLevel(doctorAddView.getJtf3().getText());
		d.setWorkWhere(doctorAddView.getJtf4().getText());
		d.setGoodAt(doctorAddView.getJtf5().getText());
		//d.setBelongRoom(1);
		
		d.setBelongRoom(roomDao.getRoomByRoomName(doctorAddView.getJtf6().getText()).getId());
		
		d.setLoginPassWord(doctorAddView.getJtf7().getText());
		
		d.setId(doctorDao.listDoctor().size()+1);
		d.setLoginName(doctorAddView.getJtf1().getText());
		d.setTime("��һ������");
		
		if(e.getSource()==doctorAddView.getRegisterBtn()) {
			doctorDao.insertDoctor(d);
			JOptionPane.showMessageDialog(doctorAddView,"���ҽ����Ϣ�ɹ�");
		}else if(e.getSource()==doctorAddView.getCancelBtn()) {
			doctorAddView.dispose();
		}
		
		
	}

}
