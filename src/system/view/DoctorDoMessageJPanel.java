package system.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import system.service.DoService;
import system.service.impl.DoServiceImpl;
import system.view.listener.DoctorDoMessageViewListener;

/**
 * ҽ����������ҽ���Һ���Ϣ���
 * 
 * 
 * @author yb
 * @date 2018-1-17 ����4:32:07
 */
public class DoctorDoMessageJPanel extends JPanel {
	private DefaultTableModel queryTableModel;
	private JTable queryTable;
	private String doctorname;

	public DoctorDoMessageJPanel(String doctorname) {
		this.setLayout(new BorderLayout());
		this.doctorname = doctorname;
		init();
	}

	// ����init����������
	private void init() {
		JPanel northPanel = new JPanel();
		JLabel jlbtitle = new JLabel("�û��Һ���Ϣ");
		jlbtitle.setFont(new Font("����", Font.BOLD, 30));
		JButton deleteBtn = new JButton(" ��ɿ��� ");
		JButton refreshBtn = new JButton(" ˢ�¼�¼ ");
		northPanel.add(jlbtitle);
		northPanel.add(deleteBtn);
		northPanel.add(refreshBtn);
		// ��Ӽ�����
		deleteBtn.addActionListener(new DoctorDoMessageViewListener(this,
				doctorname));
		refreshBtn.addActionListener(new DoctorDoMessageViewListener(this,
				doctorname));

		this.add(northPanel, BorderLayout.NORTH);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(new JLabel("���ڲ�ѯ"));
		// ��ͷ
		Vector<String> colNames = new Vector<String>();
		Collections.addAll(colNames, "�û�����", "ҽ������", "����", "�ص�", "ԤԼʱ��");
		// ����е�ԤԼ��Ϣ
		Vector<Vector<String>> vectorDo = new Vector<Vector<String>>();
		DoService doservice = new DoServiceImpl();
		vectorDo = doservice.getDoByDoctorName(doctorname);
		// ����������Ϣ
		queryTableModel = new DefaultTableModel(vectorDo, colNames);

		queryTable = new JTable(queryTableModel);

		scrollPane.setViewportView(queryTable);
		this.add(scrollPane, BorderLayout.CENTER);

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
