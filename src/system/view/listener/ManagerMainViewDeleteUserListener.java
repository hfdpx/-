package system.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import system.dao.UserDao;
import system.dao.impl.UserDaoImpl;
import system.service.DoctorService;
import system.service.UserService;
import system.service.impl.DoctorServiceImpl;
import system.service.impl.UserServiceImpl;
import system.view.ManagerMainView;

/*
*@author:yb
*@version ����ʱ�䣺2018��1��17�� ����11:17:26
*/
public class ManagerMainViewDeleteUserListener implements ActionListener{

	private ManagerMainView managerMainView;
	private UserDao userDao = new UserDaoImpl();
	private String name="";
	private JTable tb;
	
	public  ManagerMainViewDeleteUserListener(ManagerMainView managerMainView) {
		this.managerMainView=managerMainView;
		//this.name=str;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		tb=managerMainView.getQueryTable1();
	 
 
		if(tb.getSelectedRow()!=-1) {
			String name = tb.getValueAt(tb.getSelectedRow(), 1).toString();
			System.out.println(name);
			userDao.deleteUserByLoginName(name);
			DefaultTableModel dtm = managerMainView.getQueryTableModel1();
			
			UserService userService = new UserServiceImpl();
			String[][] dates = userService.getUserMessage();
			
			String[] colNames1 = { "�û����", "�û�����", "�û��绰", "�û���ַ", "�û����֤��" };
			
			dtm.setDataVector(dates, colNames1);
		}
	}

}
