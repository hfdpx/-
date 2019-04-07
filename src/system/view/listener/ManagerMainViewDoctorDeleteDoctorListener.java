package system.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import system.dao.DoctorDao;
import system.dao.impl.DoctorDaoImpl;
import system.service.DoctorService;
import system.service.UserService;
import system.service.impl.DoctorServiceImpl;
import system.service.impl.UserServiceImpl;
import system.view.ManagerMainView;

/*
*@author:yb
*@version ����ʱ�䣺2018��1��18�� ����10:46:50
*/
public class ManagerMainViewDoctorDeleteDoctorListener implements ActionListener{
	
	private ManagerMainView managerMainView;
	private DoctorDao doctorDao = new DoctorDaoImpl();
	private String name="";
	private JTable tb;

	public  ManagerMainViewDoctorDeleteDoctorListener(ManagerMainView managerMainView) {
		this.managerMainView=managerMainView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		tb=managerMainView.getQueryTable();
		
		if(tb.getSelectedRow()!=-1) {
			String name = tb.getValueAt(tb.getSelectedRow(), 1).toString();
			System.out.println(name);
			doctorDao.deleteDoctorByLoginName(name);
			DefaultTableModel dtm = managerMainView.getQueryTableModel();
			
			DoctorService doctorService = new DoctorServiceImpl();
			
			String[][] dates = doctorService.getDoctorMessage();
			
			String[] colNames = { "ҽ�����", "ҽ������", "�Ա�", "����", "��������","�ó�����","�칫�ص�" };

			dtm.setDataVector(dates, colNames);
		}
		
	}
	
}
