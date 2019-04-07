package system.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import system.entity.Doctor;
import system.entity.User;
import system.service.AllShareService;
import system.service.impl.AllShareServiceImpl;
import system.view.DoctorMainView;
import system.view.LoginView;
import system.view.ManagerMainView;
import system.view.RigisterView;
import system.view.UserMainView;


/*
*@author:yb
*@version ����ʱ�䣺2018��1��17�� ����3:11:05
*/
public class LoginViewListener implements ActionListener {
	private LoginView loginView;
	private AllShareService allShareService = new AllShareServiceImpl();
	
	public LoginViewListener(LoginView loginView) {
		this.loginView = loginView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==loginView.getLoginBtn()) {
			String username = loginView.getUsernameField().getText();
			char[] arrays = loginView.getPwdField().getPassword();
			String password = new String(arrays);
			System.out.println(username + "  " + password);
			
			if (loginView.getloginComBox().getSelectedIndex() == 0) {
				try {
					User u = allShareService.userLogin(username, password);
					// ��ʾ��¼�ɹ�
					// ���ص�¼����
					loginView.dispose();
					// ����������
					// MainView main = new MainView();
					// main.init();
					try
				    {
					  org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
				    }
				    catch(Exception e2)
				    {
				        //TODO exception
				    }

				UserMainView main = new UserMainView(username);
				main.setVisible(true);
					
					// main.init(emp.getUsername(), datas);
				} catch (Exception er) {
					// ����һ����ʾ��,չʾ������Ϣ���û�
					JOptionPane.showMessageDialog(loginView, er.getMessage());
				}
			} else if (loginView.getloginComBox().getSelectedIndex() == 1) {
				try {
					Doctor d = allShareService.doctorLogin(username, password);
					loginView.dispose();
					
					try
				    {
					  org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
					    
				    }
				    catch(Exception e3)
				    {
				        //TODO exception
				    }
					
					DoctorMainView doctormain=new DoctorMainView(username);
					doctormain.setVisible(true);
					
				} catch (Exception er) {
					JOptionPane.showMessageDialog(loginView, er.getMessage());
				}
				
				
			}else if(loginView.getloginComBox().getSelectedIndex() == 2) {
				if(username.equals("root")&&password.equals("123")) {
					JOptionPane.showMessageDialog(loginView, "��¼�ɹ�");
					
					try
				    {
					  org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
					    
				    }
				    catch(Exception e3)
				    {
				        //TODO exception
				    }
					
					ManagerMainView mmv = new ManagerMainView();
					mmv.init();
					
				}else {
					JOptionPane.showMessageDialog(loginView, "����Ա�������������");
				}
			}
		}else if(e.getSource()==loginView.getRegisterBtn()) {
			try
		    {
			  org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			    
		    }
		    catch(Exception e3)
		    {
		        //TODO exception
		    }
			
			RigisterView rgisterview = new RigisterView();
			rgisterview.init();
		}
		
	}

}
