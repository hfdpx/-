package system.view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import system.view.listener.LoginViewListener;

/**
 * 
 * ��¼����
 * 
 * @author yb 2018-1-16
 */
public class LoginView extends JFrame {
	private JTextField usernameField;
	private JLabel usernameLabel;
	private JPasswordField pwdField;
	private JLabel pwdLabel;
	private JButton loginBtn, registerBtn;
	private JComboBox loginComBox;

	public LoginView() {
		this.setSize(500, 350);
		this.setTitle("����Һ�ϵͳ");
		usernameLabel = new JLabel("�û���:");

		usernameField = new JTextField();
		pwdField = new JPasswordField();
		pwdLabel = new JLabel("�� ��:");

		loginBtn = new JButton("��¼");
		registerBtn = new JButton("ע��");

		loginComBox = new JComboBox();
		loginComBox.addItem("�û�");
		loginComBox.addItem("ҽ��");
		loginComBox.addItem("����Ա");

		initLayout();

		// ���þ��е�Ч��
		system.utils.GUIUtils.setCenterInWindow(this);
		// ���ô��ڴ�С���ܵ���
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private JPanel titlePanel() {
		JLabel title = new JLabel("����Һ�ϵͳ");
		title.setFont(new Font("����", Font.BOLD, 30));
		JPanel panel = new JPanel();
		panel.add(title);
		return panel;
	}

	private JPanel centerPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(null);

		usernameLabel.setBounds(30, 20, 80, 25);
		usernameField.setBounds(130, 20, 150, 25);
		loginComBox.setBounds(320, 20, 90, 25);

		pwdLabel.setBounds(30, 70, 80, 25);
		pwdField.setBounds(130, 70, 150, 25);

		loginBtn.setBounds(130, 130, 50, 30);
		registerBtn.setBounds(240, 130, 50, 30);

		/*** Ϊ��¼��ť���¼� **/
		loginBtn.addActionListener(new LoginViewListener(this));
		registerBtn.addActionListener(new LoginViewListener(this));

		panel.add(usernameLabel);
		panel.add(usernameField);
		panel.add(pwdField);
		panel.add(pwdLabel);
		panel.add(loginBtn);
		panel.add(registerBtn);
		panel.add(loginComBox);

		return panel;
	}

	private void initLayout() {
		this.add(titlePanel(), BorderLayout.NORTH);
		this.add(centerPanel(), BorderLayout.CENTER);

	}

	public JTextField getUsernameField() {
		return usernameField;
	}

	public JPasswordField getPwdField() {
		return pwdField;
	}

	public JComboBox getloginComBox() {
		return loginComBox;
	}

	public JButton getLoginBtn() {
		return loginBtn;
	}

	public void setLoginBtn(JButton loginBtn) {
		this.loginBtn = loginBtn;
	}

	public JButton getRegisterBtn() {
		return registerBtn;
	}

	public void setRegisterBtn(JButton registerBtn) {
		this.registerBtn = registerBtn;
	}

	// public static void main(String[] args) {
	// try
	// {
	// org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
	//
	// // //���ñ����Խ��ı䴰�ڱ߿���ʽ����
	// // BeautyEyeLNFHelper.frameBorderStyle =
	// BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
	// // org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
	// //
	// }
	// catch(Exception e)
	// {
	// //TODO exception
	// }
	// LoginView loginview=new LoginView();
	// loginview.setVisible(true);
	//
	// }
}
