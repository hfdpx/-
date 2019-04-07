package system.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import system.view.listener.DoctorRigisterViewListener;
import system.view.utils.GUIUtils;

public class DoctorAddView extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel jl1 ;
	private JLabel jl2 ;
	private JLabel jl3 ; 
	private JLabel jl4;
	private JLabel jl5;
	private JLabel jl6;
	private JLabel jl7;
	
	private JTextField jtf1 ; 
	private JTextField jtf2;
	private JTextField jtf3;
	private JTextField jtf4;
	private JTextField jtf5;
	private JTextField jtf6;
	private JTextField jtf7;
	
	private JButton registerBtn;
	private JButton cancelBtn;
	private JPanel jpl;
 /**
 * ��ʼ������
 */
public void init(){
//	JPanel jp = new JPanel();
	
	//���ñ���
	this.setTitle("���ҽ����Ϣ");
	//���ô��ڴ�С
	this.setSize(370, 550);
	//���ô���λ�þ���
	GUIUtils.setCenterInWindow(this);

	jpl = new JPanel();
	jpl.setSize(370,500);
	this.add(jpl);
//	//���ô��ڼ����¼�
//	this.addWindowListener(new WindowAdapter() {	
//		public void windowClosed(WindowEvent e) {
//			System.exit(0);
//		}
//	});
	//���ÿղ���
	jpl.setLayout(null);
	//���������ʵ����
	
	jl1 = new JLabel("ҽ������");
	jl2 = new JLabel("�Ա�");
	jl3 = new JLabel("����");
	jl4 = new JLabel("�칫�ص�");
	jl5 = new JLabel("�ó�����");
	jl6 = new JLabel("��������");
	jl7 = new JLabel("��½����");
	
	
	jtf1 = new JTextField("");
	jtf2 = new JTextField("");
	jtf3 = new JTextField("");
	jtf4 = new JTextField("");
	jtf5 = new JTextField("");
	jtf6 = new JTextField("");
	jtf7 = new JTextField("");
	
	registerBtn = new JButton ("���");
	cancelBtn = new JButton("ȡ��");
	
	//��������
	Font font = new Font("����",0,14);
	//���ø����λ��
	
	
	
	jl1.setBounds(65, 50, 70, 30);
	jl1.setFont(font);
	jpl.add(jl1);
	jtf1.setBounds(155, 50, 120, 30);
	jtf1.setFont(font);
	jpl.add(jtf1);
	
	jl2 .setBounds(65, 100, 70, 30);
	jl2.setFont(font);
	jpl.add(jl2);	
	jtf2.setBounds(155, 100, 120, 30);
	jtf2.setFont(font);
	jpl.add(jtf2);
	
	jl3.setBounds(65, 150, 70, 30);
	jl3.setFont(font);
	jpl.add(jl3);
	jtf3.setBounds(155, 150, 120, 30);
	jtf3.setFont(font);
	jpl.add(jtf3);
	
	
	jl4.setBounds(65, 200, 70, 30);
	jl4.setFont(font);
	jpl.add(jl4);
	jtf4.setBounds(155, 200, 120, 30);
	jtf4.setFont(font);
	jpl.add(jtf4);
	
	jl5.setBounds(65, 250, 70, 30);
	jl5.setFont(font);
	jpl.add(jl5);
	jtf5.setBounds(155, 250, 120, 30);
	jtf5.setFont(font);
	jpl.add(jtf5);
	

	jl6.setBounds(65, 300, 70, 30);
	jl6.setFont(font);
	jpl.add(jl6);
	jtf6.setBounds(155, 300, 120, 30);
	jtf6.setFont(font);
	jpl.add(jtf6);
	
	
	jl7.setBounds(65, 350, 70, 30);
	jl7.setFont(font);
	jpl.add(jl7);
	jtf7.setBounds(155, 350, 120, 30);
	jtf7.setFont(font);
	jpl.add(jtf7);
	
	
	
	
	registerBtn.setBounds(85, 420, 70, 30);
	registerBtn.setFont(font);
	jpl.add(registerBtn);
	
	cancelBtn.setBounds(185, 420, 70, 30);
	cancelBtn.setFont(font);
	jpl.add(cancelBtn);
	
//	//ע�ᰴť�󶨼����¼�
	registerBtn.addActionListener(new DoctorRigisterViewListener(this));
	cancelBtn.addActionListener(new DoctorRigisterViewListener(this));
//     //���ô��ڿɼ�
	this.setVisible(true);
	
	}

public JTextField getJtf1() {
	return jtf1;
}

public void setJtf1(JTextField jtf1) {
	this.jtf1 = jtf1;
}

public JTextField getJtf2() {
	return jtf2;
}

public void setJtf2(JTextField jtf2) {
	this.jtf2 = jtf2;
}

public JTextField getJtf3() {
	return jtf3;
}

public void setJtf3(JTextField jtf3) {
	this.jtf3 = jtf3;
}

public JTextField getJtf4() {
	return jtf4;
}

public void setJtf4(JTextField jtf4) {
	this.jtf4 = jtf4;
}

public JTextField getJtf5() {
	return jtf5;
}

public void setJtf5(JTextField jtf5) {
	this.jtf5 = jtf5;
}

public JTextField getJtf6() {
	return jtf6;
}

public void setJtf6(JTextField jtf6) {
	this.jtf6 = jtf6;
}

public JTextField getJtf7() {
	return jtf7;
}

public void setJtf7(JTextField jtf7) {
	this.jtf7 = jtf7;
}

public JButton getRegisterBtn() {
	return registerBtn;
}

public void setRegisterBtn(JButton registerBtn) {
	this.registerBtn = registerBtn;
}

public JButton getCancelBtn() {
	return cancelBtn;
}

public void setCancelBtn(JButton cancelBtn) {
	this.cancelBtn = cancelBtn;
}


//public static void main(String[] args) {
//	try
//    {
//	  org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
//	    
//    }
//    catch(Exception e3)
//    {
//        //TODO exception
//    }
//	DoctorAddView ai = new DoctorAddView();
//	ai.init();
//}

}
