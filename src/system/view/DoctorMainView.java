package system.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

import system.view.utils.GUIUtils;
import system.view.utils.TimeThread;

/**
 * ҽ��������
 * 
 * 
 * @author yb
 * @date 2018-1-17 ����12:47:52
 */
public class DoctorMainView extends JFrame {
	// ������ģ��
	private JTree tree;

	// �������Ľڵ�
	private DefaultMutableTreeNode rootNode;
	private DefaultMutableTreeNode docterMessageNode;
	private DefaultMutableTreeNode doctoeyuyueNode;
	private DefaultMutableTreeNode hospitaldoctorNode;
	private DefaultMutableTreeNode aboutUsEmpNode;
	// ѡ�
	private JTabbedPane tabbedPane;
	private JTable yuyueTable;
	private DefaultTableModel yuyueTableModel;
	private JLabel lblshowtime;
	private JPanel timeJPanel;
	private String name;

	public DoctorMainView(String str) {
		this.setSize(1080, 750);
		this.setTitle("����Һ�ϵͳ--ҽ����");
		name = str;

		// ����һ���ָ����:JSplitPane.HORIZONTAL_SPLITˮƽ�ָ�
		JSplitPane splitPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		// ���÷ָ��ߵĴ�С
		splitPanel.setDividerSize(1);
		// ���÷ָ��ߵ�Ĭ�ϵ�λ��
		splitPanel.setDividerLocation(150);
		// ���÷ָ��߲����ƶ�
		splitPanel.setEnabled(false);

		// Ϊ�ָ�������������
		splitPanel.setLeftComponent(initLeft());
		// Ϊ�ָ������Ҳ�������
		splitPanel.setRightComponent(initRight());
		this.add(splitPanel);
		GUIUtils.setCenterInWindow(this);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ������ʾ��ǰʱ��
		timeJPanel = new JPanel();
		lblshowtime = new JLabel();
		TimeThread tt = new TimeThread(this.lblshowtime);
		Thread th = new Thread(tt);
		th.start();
		timeJPanel.add(lblshowtime);
		this.add(timeJPanel, BorderLayout.SOUTH);

	}

	// ���������ұߵ���ͼЧ��
	private JScrollPane initRight() {
		JScrollPane scrollPane = new JScrollPane();
		// ��ʼ��ѡ�JTabbedPAne.Top�ƶ�ѡ���λ��,
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		// ѡ�������������ӵ����������Զ�����
		tabbedPane.add(aboutUsEmpPanel());
		tabbedPane.add(new DoctorMessageJPanel(name));
		tabbedPane.add(new DoctorDoMessageJPanel(name));
		tabbedPane.add(new DoctorHospitalMessageJpanel(name));
		// ����ÿ��ѡ��ı���
		tabbedPane.setTitleAt(0, "��������");
		tabbedPane.setTitleAt(1, "������Ϣ");
		tabbedPane.setTitleAt(2, "ԤԼ��Ϣ��ѯ");
		tabbedPane.setTitleAt(3, "ҽ����Ϣ��ѯ");
		// ���ڹ�����������Ԫ�ر��������ӿ������
		scrollPane.setViewportView(tabbedPane);

		return scrollPane;
	}

	private JPanel aboutUsEmpPanel() {
		// TODO Auto-generated method stub
		JPanel panel = new JPanel();
		JLabel jbltp = new JLabel();
		jbltp.setIcon(new ImageIcon(this.getClass().getResource(
				"/images/2p.png")));
		jbltp.setBounds(0, 0, 300, 275);
		panel.add(jbltp);
		return panel;
	}

	// ����������������ͼЧ��
	private Component initLeft() {
		// ��ʾ�������,JTree,JTable��������ڹ��������
		JScrollPane scrollPane = new JScrollPane();
		// ʵ������Ľڵ�
		rootNode = new DefaultMutableTreeNode("����Һ�ϵͳ");
		docterMessageNode = new DefaultMutableTreeNode("������Ϣ");
		doctoeyuyueNode = new DefaultMutableTreeNode("ԤԼ��Ϣ��ѯ");
		hospitaldoctorNode = new DefaultMutableTreeNode("ҽ����Ϣ��ѯ");
		aboutUsEmpNode = new DefaultMutableTreeNode("��������");
		rootNode.add(aboutUsEmpNode);
		rootNode.add(docterMessageNode);
		rootNode.add(doctoeyuyueNode);
		rootNode.add(hospitaldoctorNode);
		tree = new JTree(rootNode);

		/** ���¼�:�������Ľڵ�ѡ���Ӧ��ѡ� **/
		tree.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// ��õ�ǰѡ������Ľڵ�
				Object node = tree.getLastSelectedPathComponent();
				if (node == null) {
					return;
				}
				// ��ýڵ������
				String nodeName = node.toString();
				// ���ѡ�������
				int tabCount = tabbedPane.getTabCount();
				for (int i = 0; i < tabCount; i++) {
					String title = tabbedPane.getTitleAt(i);
					if (nodeName.equals(title)) {
						// ѡ��ָ��λ�õ�ѡ�
						tabbedPane.setSelectedIndex(i);
					}

				}
			}
		});
		scrollPane.setViewportView(tree);
		return scrollPane;
	}

	public static void main(String[] args) {
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();

			// //���ñ����Խ��ı䴰�ڱ߿���ʽ����
			// BeautyEyeLNFHelper.frameBorderStyle =
			// BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
			// org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			//
		} catch (Exception e) {
			// TODO exception
		}

		DoctorMainView doctormain = new DoctorMainView("��С��");
		doctormain.setVisible(true);
	}

}
