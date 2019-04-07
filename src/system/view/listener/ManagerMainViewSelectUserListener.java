package system.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import system.dao.UserDao;
import system.dao.impl.UserDaoImpl;
import system.exception.DaoException;
import system.service.UserService;
import system.service.impl.UserServiceImpl;
import system.view.ManagerMainView;

/*
*@author:yb
*@version ����ʱ�䣺2018��1��18�� ����1:19:18
*/
public class ManagerMainViewSelectUserListener implements ActionListener{

	private ManagerMainView managerMainView;
	private UserDao userDao = new UserDaoImpl();
	
	public  ManagerMainViewSelectUserListener(ManagerMainView managerMainView) {
		this.managerMainView=managerMainView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String[] colNames1 = { "�û����", "�û�����", "�û��绰", "�û���ַ", "�û����֤��" };
		
		JTextField jtf;
		jtf=managerMainView.getJtf1();
		
		
//		loginComBox1.addItem("�û�����ѯ");
//		loginComBox1.addItem("���֤�Ų�ѯ");
		
		UserService userService = new UserServiceImpl();
		
		
		
		if(managerMainView.getLoginComBox1().getSelectedIndex()==0) {
			
			
			try {
				String[][] dates = userService.getOneUserMessageByName(jtf.getText());

				
				DefaultTableModel dtm = managerMainView.getQueryTableModel1();

				dtm.setDataVector(dates, colNames1);
			} catch (DaoException e5) {
				throw e5;
			}
		}else if(managerMainView.getLoginComBox1().getSelectedIndex()==1) {
			
            try {
            	 String[][] dates = userService.getOneMessageByCardNumber(jtf.getText());
     			
                 DefaultTableModel dtm = managerMainView.getQueryTableModel1();
     			
     			dtm.setDataVector(dates, colNames1);
			}catch (DaoException e5){
				throw e5;
			}
		}
	}

}
