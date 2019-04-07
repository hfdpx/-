package system.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import system.dao.UserDao;
import system.dao.impl.UserDaoImpl;
import system.entity.User;
import system.view.RigisterView;

/*
*@author:yb
*@version ����ʱ�䣺2018��1��18�� ����2:41:31
*/
public class UserRigisterViewListener implements ActionListener{

	private RigisterView rigisterView;
	private UserDao userDao;
	public UserRigisterViewListener(RigisterView rigisterView) {
		this.rigisterView=rigisterView;
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		userDao = new UserDaoImpl();
		User u = new User();
		
		
		u.setLoginName(rigisterView.getUsmField().getText());
		u.setPassWord(rigisterView.getResField().getText());
		u.setTelNumber(rigisterView.getSkeyField().getText());
	    u.setAdress(rigisterView.getAddressField().getText());
	    u.setIdCardName(rigisterView.getIdcardField().getText());
		u.setId(userDao.listUser().size()+1);
	    
	    String a=rigisterView.getResField().getText();
	    String b=rigisterView.getPsdField().getText();
	    System.out.println(a+"*"+b);
		if(e.getSource()==rigisterView.getRegisterBtn()) {
			
			if(!(a.equals(b))) {
		    	JOptionPane.showMessageDialog(rigisterView,"�������벻��ͬ");
		    }else {
		    	userDao.insertUser(u);
				JOptionPane.showMessageDialog(rigisterView,"ע��ɹ�");
				
		    }
		
		}
		else if(e.getSource()==rigisterView.getCancelBtn()) {
			rigisterView.dispose();
		}
	}

}
