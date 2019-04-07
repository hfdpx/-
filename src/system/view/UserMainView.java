package system.view;

import java.awt.BorderLayout;
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
 * �û�������
 * 
 * @author yb 2018-1-16
 */
public class UserMainView extends JFrame {
	// ������ģ��
	private JTree tree;

	// �������Ľڵ�
	private DefaultMutableTreeNode rootNode;
	private DefaultMutableTreeNode userEmpNode;
	private DefaultMutableTreeNode guahaoNode;
	private DefaultMutableTreeNode historyEmpNode;
	private DefaultMutableTreeNode aboutUsEmpNode;
	// ѡ�
	private JTabbedPane tabbedPane;

	private String name;

	private JTable queryTable;
	private JLabel lblshowtime;
	private DefaultTableModel queryTableModel;
	private JPanel timeJPanel, topetitleJPanel;
	private JLabel toptitlejlb;

	public UserMainView(String str) {
		this.setSize(1080, 750);
		this.setTitle("����Һ�ϵͳ--�û���");

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
		// ��ʼ��ѡ� JTabbedPane.TOP ָ��ѡ���ǩ��λ��.
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		// ѡ�������������ӵ����������Զ�����
		tabbedPane.add(aboutUsEmpPanel());
		tabbedPane.add(new UserMessagePanel(name));
		tabbedPane.add(new UserDoMessageJpanel(name));
		tabbedPane.add(new UserDoctorJPanel(name));
		// ����ÿ��ѡ��ı���
		tabbedPane.setTitleAt(0, "��������");
		tabbedPane.setTitleAt(1, "������Ϣ");
		tabbedPane.setTitleAt(2, "�Һż�¼");
		tabbedPane.setTitleAt(3, "ԤԼ�Һ�");
		// ���ڹ�����������Ԫ�ر��������ӿ������
		scrollPane.setViewportView(tabbedPane);
		// tabbedPane.addChangeListener(new UserViewChangeListener(this,name));

		return scrollPane;
	}

	private JPanel aboutUsEmpPanel() {
		JPanel panel = new JPanel();
		JLabel jbltp = new JLabel();
		jbltp.setIcon(new ImageIcon(this.getClass().getResource(
				"/images/1p.png")));
		jbltp.setBounds(0, 0, 300, 275);
		panel.add(jbltp);
		return panel;
	}

	// ���������󲿵���ͼЧ��
	private JScrollPane initLeft() {// �����˵������ص�Ч��(δ��)
		// ��ʾ�������,JTree,JTable��������ڹ��������.
		JScrollPane scrollPane = new JScrollPane();
		// ʵ�������Ľڵ�
		rootNode = new DefaultMutableTreeNode("����Һ�ϵͳ");
		userEmpNode = new DefaultMutableTreeNode("������Ϣ");
		historyEmpNode = new DefaultMutableTreeNode("�Һż�¼");
		guahaoNode = new DefaultMutableTreeNode("ԤԼ�Һ�");
		aboutUsEmpNode = new DefaultMutableTreeNode("��������");
		rootNode.add(aboutUsEmpNode);
		rootNode.add(userEmpNode);
		rootNode.add(historyEmpNode);
		rootNode.add(guahaoNode);
		tree = new JTree(rootNode);

		/*** ���¼�:�������Ľڵ�ѡ���Ӧ��ѡ� ***/
		tree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// ��õ�ǰ��ѡ������Ľڵ�
				Object node = tree.getLastSelectedPathComponent();
				if (node == null) {
					return;
				}
				// ��ýڵ������
				String nodeName = node.toString();
				// System.out.println(nodeName);
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

	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public static void main(String[] args) {
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		} catch (Exception e) {
			// TODO exception
		}

		UserMainView main = new UserMainView("��С��");
		main.setVisible(true);
	}

}
