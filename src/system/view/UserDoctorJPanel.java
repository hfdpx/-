package system.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import system.service.DoctorService;
import system.service.impl.DoctorServiceImpl;
import system.view.listener.UserDoJPanelDoButtonListener;
import system.view.listener.UserDoJPanelListener;

/**
 * �û�����ԤԼ�Һ����
 * 
 * 
 * @author yb
 * @date 2018-1-17 ����2:58:14
 */
public class UserDoctorJPanel extends JPanel {
	private JLabel keshiLabel, zhuanjiaLabel;
	private JTextField zhuanjiaTextField;
	private UserDoctorJPanel panel;
	private JPanel northPanel;
	private JTextField keshiTextField;
	private JButton queryKeshiBtn1, queryDoctorBtn3, yuyueBtn, refreshBtn;
	private DefaultTableModel queryTableModel;
	private JTable queryTable;
	private DoctorService doctorservice;
	private String name;

	public UserDoctorJPanel(String str) {
		this.setLayout(null);
		name = str;
		init();
	}

	private void init() {
		northPanel = new JPanel();
		northPanel.setLayout(null);
		northPanel.setBounds(0, 0, 800, 100);
		// ���Ҳ�ѯ�����б�
		keshiTextField = new JTextField();

		// ������ѯ�ĸ����
		queryKeshiBtn1 = new JButton("��ѯ");// ���Ҳ�ѯ
		queryDoctorBtn3 = new JButton("��ѯ");// ҽ����ѯ

		yuyueBtn = new JButton("ԤԼ");
		keshiLabel = new JLabel("���Ҳ�ѯ");
		zhuanjiaLabel = new JLabel("ҽ����ѯ");
		refreshBtn = new JButton("ˢ��");
		zhuanjiaTextField = new JTextField();

		queryKeshiBtn1
				.addActionListener(new UserDoJPanelListener(this, "���Ҳ�ѯ"));
		// queryBingzhengBtn2.addActionListener(new
		// UserDoJPanelListener(this,"��֢��ѯ"));
		queryDoctorBtn3
				.addActionListener(new UserDoJPanelListener(this, "ҽ����ѯ"));
		// queryTimeBtn4.addActionListener(new
		// UserDoJPanelListener(this,"����ʱ���ѯ"));
		yuyueBtn.addActionListener(new UserDoJPanelDoButtonListener(this, "ԤԼ"));
		refreshBtn.addActionListener(new UserDoJPanelListener(this, "ˢ��"));

		keshiLabel.setBounds(140, 15, 60, 30);
		keshiTextField.setBounds(220, 15, 140, 30);
		queryKeshiBtn1.setBounds(440, 15, 50, 30);

		zhuanjiaLabel.setBounds(140, 55, 60, 30);
		zhuanjiaTextField.setBounds(220, 55, 140, 30);
		queryDoctorBtn3.setBounds(440, 55, 50, 30);

		refreshBtn.setBounds(600, 15, 100, 30);
		yuyueBtn.setBounds(600, 55, 100, 30);

		northPanel.add(keshiLabel);
		northPanel.add(keshiTextField);

		northPanel.add(zhuanjiaLabel);
		northPanel.add(zhuanjiaTextField);

		northPanel.add(queryKeshiBtn1);
		northPanel.add(queryDoctorBtn3);
		northPanel.add(yuyueBtn);
		northPanel.add(refreshBtn);
		northPanel.setVisible(true);
		this.add(northPanel, BorderLayout.NORTH);

		this.add(tablePanel());

	}

	// ���ر�����(������)
	private JScrollPane tablePanel() {

		doctorservice = new DoctorServiceImpl();
		// ԤԼ����еı��
		String[][] domessage = doctorservice.getDoctorMessage();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(new JLabel("ԤԼ�Һ�"));
		scrollPane.setBounds(0, 100, 820, 390);
		String[] colNames1 = { "ҽ�����", "ҽ������", "�Ա�", "����", "��������", "�ó�����",
				"�칫�ص�" };

		queryTableModel = new DefaultTableModel(domessage, colNames1);

		queryTable = new JTable(queryTableModel);

		scrollPane.setViewportView(queryTable);

		return scrollPane;
	}

	public JTextField getZhuanjiaTextField() {
		return zhuanjiaTextField;
	}

	public void setZhuanjiaTextField(JTextField zhuanjiaTextField) {
		this.zhuanjiaTextField = zhuanjiaTextField;
	}

	public JTextField getKeshiTextField() {
		return keshiTextField;
	}

	public void setKeshiTextField(JTextField keshiTextField) {
		this.keshiTextField = keshiTextField;
	}

	public DefaultTableModel getQueryTableModel() {
		return queryTableModel;
	}

	public void setQueryTableModel(DefaultTableModel queryTableModel) {
		this.queryTableModel = queryTableModel;
	}

	public JTable getQueryTable() {
		return queryTable;
	}

	public void setQueryTable(JTable queryTable) {
		this.queryTable = queryTable;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
