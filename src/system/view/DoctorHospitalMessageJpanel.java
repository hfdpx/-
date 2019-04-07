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
import system.view.listener.DoctorDoJPanelListener;

/**
 * ҽ���������в鿴����ҽ����Ϣ����
 * 
 * 
 * @author yb
 * @date 2018-1-17 ����4:10:28
 */
public class DoctorHospitalMessageJpanel extends JPanel {
	private JLabel keshiLabel, zhuanjiaLabel;
	private JTextField zhuanjiaTextField;
	private UserDoctorJPanel panel;
	private JPanel northPanel;
	private DoctorService doctorservice;
	private JTextField keshiTextField;
	private JButton queryKeshiBtn1, queryDoctorBtn3, refreshBtn;
	private DefaultTableModel queryTableModel;
	private JTable queryTable;
	private String doctorname;

	public DoctorHospitalMessageJpanel(String doctorname) {
		this.setLayout(null);
		this.doctorname = doctorname;
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
		refreshBtn = new JButton("ˢ��");
		queryKeshiBtn1.addActionListener(new DoctorDoJPanelListener(this,
				"���Ҳ�ѯ"));
		// queryBingzhengBtn2.addActionListener(new
		// UserDoJPanelListener(this,"��֢��ѯ"));
		queryDoctorBtn3.addActionListener(new DoctorDoJPanelListener(this,
				"ҽ����ѯ"));
		refreshBtn.addActionListener(new DoctorDoJPanelListener(this, "ˢ��"));

		keshiLabel = new JLabel("���Ҳ�ѯ");
		zhuanjiaLabel = new JLabel("ҽ����ѯ");

		zhuanjiaTextField = new JTextField();
		keshiLabel.setBounds(140, 15, 60, 30);
		keshiTextField.setBounds(220, 15, 140, 30);
		queryKeshiBtn1.setBounds(440, 15, 50, 30);

		zhuanjiaLabel.setBounds(140, 55, 60, 30);
		zhuanjiaTextField.setBounds(220, 55, 140, 30);
		queryDoctorBtn3.setBounds(440, 55, 50, 30);
		refreshBtn.setBounds(600, 30, 100, 30);

		northPanel.add(keshiLabel);
		northPanel.add(keshiTextField);

		northPanel.add(zhuanjiaLabel);
		northPanel.add(zhuanjiaTextField);

		northPanel.add(queryKeshiBtn1);

		northPanel.add(queryDoctorBtn3);
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

	public JButton getQueryKeshiBtn1() {
		return queryKeshiBtn1;
	}

	public void setQueryKeshiBtn1(JButton queryKeshiBtn1) {
		this.queryKeshiBtn1 = queryKeshiBtn1;
	}

	public JButton getQueryDoctorBtn3() {
		return queryDoctorBtn3;
	}

	public void setQueryDoctorBtn3(JButton queryDoctorBtn3) {
		this.queryDoctorBtn3 = queryDoctorBtn3;
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

}
