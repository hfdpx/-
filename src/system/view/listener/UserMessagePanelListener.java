package system.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import system.entity.User;
import system.service.UserService;
import system.service.impl.UserServiceImpl;
import system.view.UserMessagePanel;

/*
*@author:yb
*@version ����ʱ�䣺2018��1��17�� ����9:11:03
*/
public class UserMessagePanelListener implements ActionListener{
	private UserMessagePanel userMessagePanel;
	private String buttonMessage;
	private User user;
	private UserService userService;
	public UserMessagePanelListener (UserMessagePanel userMessagePanel,String buttonMessage) {
		this.userMessagePanel=userMessagePanel;
		this.buttonMessage=buttonMessage;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(buttonMessage.equals("�޸�")){
//			userMessagePanel.getJtfuserid().setEnabled(true);
//			userMessagePanel.getJtfuloginname().setEnabled(true);
			userMessagePanel.getJtfrepassword().setEnabled(true);
			userMessagePanel.getJtfpassword().setEnabled(true);
//			userMessagePanel.getJtfIDcardnum().setEnabled(true);
			userMessagePanel.getJtfphone().setEnabled(true);
			userMessagePanel.getJtfadress().setEnabled(true);
		}
		if(buttonMessage.equals("���")){
//			String str1=userMessagePanel.getJtfadress().getText();
//			String str2=userMessagePanel.getJtfIDcardnum().getText();
//			System.out.print(str1);
			user=new User();
			if(String.valueOf(userMessagePanel.getJtfpassword().getPassword()).equals
					(String.valueOf(userMessagePanel.getJtfrepassword().getPassword()))){//�������������ٴ����������һ��ʱ
			    userMessagePanel.getJtfrepassword().setEnabled(false);
			    userMessagePanel.getJtfpassword().setEnabled(false);
			    userMessagePanel.getJtfIDcardnum().setEnabled(false);
			    userMessagePanel.getJtfphone().setEnabled(false);
			    userMessagePanel.getJtfadress().setEnabled(false);
			    user.setAdress(userMessagePanel.getJtfadress().getText());
			    user.setId(Integer.parseInt(userMessagePanel.getJtfuserid().getText()));
			    user.setIdCardName(userMessagePanel.getJtfIDcardnum().getText());
			    user.setLoginName(userMessagePanel.getJtfuloginname().getText());
			    user.setPassWord(String.valueOf(userMessagePanel.getJtfpassword().getPassword()));
			    user.setTelNumber(userMessagePanel.getJtfphone().getText());
			    userService=new UserServiceImpl();
			    userService.updateUserByLoginName(user);
			    
			}else{
				JOptionPane.showMessageDialog(userMessagePanel, "����ȷ�ϴ�����������������!");
			}
		}

	}

}
