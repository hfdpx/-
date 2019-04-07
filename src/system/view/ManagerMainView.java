package system.view;



import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

import system.dao.RoomDao;
import system.dao.impl.RoomDaoImpl;
import system.entity.Room;
import system.service.DoctorService;
import system.service.RoomService;
import system.service.UserService;
import system.service.impl.DoctorServiceImpl;
import system.service.impl.RoomServiceImpl;
import system.service.impl.UserServiceImpl;
import system.view.listener.ManagerMainViewDeleteRoomListener;
import system.view.listener.ManagerMainViewDeleteUserListener;
import system.view.listener.ManagerMainViewDoctorDeleteDoctorListener;
import system.view.listener.ManagerMainViewSelectDoctorListener;
import system.view.listener.ManagerMainViewSelectRoomListener;
import system.view.listener.ManagerMainViewSelectUserListener;
import system.view.utils.GUIUtils;

public class ManagerMainView extends JFrame {
	
	        
	        String str="";
	
	        private JComboBox loginComBox;
	        
			private JComboBox loginComBox1;
	        
			private JButton jbRefresh;
		// ������ģ��
			private JTree tree;
			// ����˵���
			private JMenuBar menuBar;
			// �˵�
//			private JMenu noteMenu;

			// �������Ľڵ�
			private DefaultMutableTreeNode rootNode;
			private DefaultMutableTreeNode userEmpNode;
			private DefaultMutableTreeNode docteroNode;
			private DefaultMutableTreeNode roomEmpNode;
			private DefaultMutableTreeNode aboutUsEmpNode;
			// ѡ�
			private JTabbedPane tabbedPane;

			private JTable queryTable;
			private JTable queryTable1;
			private JTable queryTable2;
			private DefaultTableModel queryTableModel;
			private DefaultTableModel queryTableModel1;
			private DefaultTableModel queryTableModel2;
			
			private JButton queryBtn;
			private JButton queryBtn1;
			private JButton queryBtn2;
			private JButton deleteBtn;
			private JButton deleteBtn1;
			private JButton deleteBtn2;
			private JButton addBtn;
			private JButton addBtn2;
			private JButton changeBtn;
			private JButton changeBtn2;
			//�û������Ϣ����
			private JTextField jtf1;
			private JLabel jbusername,jbtel,jbaddress,jbidcard;
			private JTextField jtusername,jttel,jtaddress,jtidcard;
			//ҽ�������Ϣ����
			private JTextField jtf2;
			private JLabel jbdcname,jbdcrank,jbdcroom,jbdcgood;
			private JTextField jtdcname,jtdcrank,jtdcroom,jtdcgood;
			//���ұ����Ϣ����
			private JTextField jtf3;
			private JLabel jbksname,jbksgood;
			private JTextField jtksname,jtksgood;


			public void init() {
				this.setSize(1050, 650);
				this.setTitle("����Һ�ϵͳ");
				// ��ʼ��һ���˵���
				menuBar = new JMenuBar();
				this.setJMenuBar(menuBar);
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
			}

			// ���������ұߵ���ͼЧ��
			private JScrollPane initRight() {
				JScrollPane scrollPane = new JScrollPane();
				// ��ʼ��ѡ� JTabbedPane.TOP ָ��ѡ���ǩ��λ��.
				tabbedPane = new JTabbedPane(JTabbedPane.TOP);
				// ѡ�������������ӵ����������Զ�����
				tabbedPane.add(aboutUsEmpPanel());
				tabbedPane.add(userEmpPanel());
				tabbedPane.add(docterPanel());
				tabbedPane.add( roomEmpPanel());
				// ����ÿ��ѡ��ı���
				tabbedPane.setTitleAt(0, "��������");
				tabbedPane.setTitleAt(1, "�û���Ϣ����");
				tabbedPane.setTitleAt(2, "ҽ����Ϣ����");
				tabbedPane.setTitleAt(3, "������Ϣ����");
				// ���ڹ�����������Ԫ�ر��������ӿ������
				scrollPane.setViewportView(tabbedPane);

				return scrollPane;
			}
	
			private JPanel aboutUsEmpPanel() {
			JPanel panel = new JPanel();
			JLabel jbltp=new JLabel();
			jbltp.setIcon(new ImageIcon(this.getClass().getResource("/images/3p.png")));
			jbltp.setBounds(0, 0, 300, 275);
			panel.add(jbltp);
			return panel;
		}

			/**
			 * ҽ����Ϣ��������
			 * 
			 * @return
			 */
			private JPanel docterPanel() {
				JPanel panel = new JPanel();
				panel.setLayout(null);
				JPanel northPanel = new JPanel();
				panel.add(northPanel);
				northPanel.add(new JLabel("�û���Ϣ����"));	
				northPanel.setLayout(null);
				northPanel.setBounds(0, 0, 800, 100);
			    
				loginComBox=new  JComboBox();
				loginComBox.addItem("ҽ��������ѯ");
				loginComBox.addItem("ҽ�������ѯ");
				loginComBox.addItem("�������Ҳ�ѯ");

				loginComBox.setBounds(30, 20, 150, 30);
				
				northPanel.add(loginComBox);
				
				jtf2 = new JTextField();
				jtf2.setBounds(200, 20, 100, 30);
				northPanel.add(jtf2);
				
				queryBtn = new JButton("��ѯ");
				northPanel.add(queryBtn);
				queryBtn.setBounds(320, 20, 100, 30);
				deleteBtn = new JButton("ɾ��");
				northPanel.add(deleteBtn);
				deleteBtn.setBounds(540, 45, 100, 25);
				
				jbRefresh = new JButton("ˢ��");
				jbRefresh.setBounds(670, 15, 100, 25);
				northPanel.add(jbRefresh);
				
				
				addBtn = new JButton("���");
				northPanel.add(addBtn);
				addBtn.setBounds(670, 45, 100, 25);
				
				
				addBtn.addActionListener(new ManagerViewDoctorAddListener(this));
				
		
				
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setColumnHeaderView(new JLabel("                                                                                                  ҽ����Ϣ����          "));

				String[] colNames = { "ҽ�����", "ҽ������", "�Ա�", "����", "��������","�ó�����","�칫�ص�" };

//				String[][] datas = {
//						{ "1001", "������", "��", "����","����", "�ۿ�","112" },
//						{ "1002", "�¶���", "��", "����","����", "�ۿ�" ,"113" },
//						{ "1003", "����", "��", "����","����", "Ƥ����" ,"114" },
//						{ "1004", "������", "Ů", "����","�Կ�", "�Կ�" ,"115"}
//
//				};
//				queryTableModel = new DefaultTableModel(datas, colNames);

				DoctorService doctorService = new DoctorServiceImpl();
				
				String[][] dates = doctorService.getDoctorMessage();
				
				queryTableModel = new DefaultTableModel(dates, colNames);
				
				queryTable = new JTable(queryTableModel);
				scrollPane.setViewportView(queryTable);
				
				deleteBtn.addActionListener(new ManagerMainViewDoctorDeleteDoctorListener(this));
				
				queryBtn.addActionListener(new ManagerMainViewSelectDoctorListener(this));
				
				jbRefresh.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String[] colNames = { "ҽ�����", "ҽ������", "�Ա�", "����", "��������","�ó�����","�칫�ص�" };
						
						DoctorService doctorService = new DoctorServiceImpl();
						String[][] dates = doctorService.getDoctorMessage();

						DefaultTableModel dtm =queryTableModel;
						
						dtm.setDataVector(dates, colNames);					
					
						
					}
				});
				
				scrollPane.setBounds(0, 100, 823, 390);
				panel.add(scrollPane);

				return panel;
			}

			

			/**
			 *�û���Ϣ��������
			 * 
			 * @return
			 */
			private JPanel userEmpPanel() {			
				JPanel panel = new JPanel();
				panel.setLayout(null);
				JPanel northPanel1 = new JPanel();
				
				northPanel1.add(new JLabel("�û���Ϣ����"));	
				northPanel1.setLayout(null);
				northPanel1.setBounds(0, 0, 800, 100);

				loginComBox1=new  JComboBox();
				loginComBox1.addItem("�û�����ѯ");
				loginComBox1.addItem("���֤�Ų�ѯ");
				
				loginComBox1.setBounds(30, 20, 150, 30);
				
				northPanel1.add(loginComBox1);
				
				jtf1 = new JTextField();
				jtf1.setBounds(200, 20, 100, 30);
				
				queryBtn1 = new JButton("��ѯ");
				deleteBtn1 = new JButton("ɾ��");
				jbRefresh = new JButton("ˢ��");
				
				
				
				
				
				
				
				
				jbRefresh.setBounds(540, 20, 100, 30);
				queryBtn1.setBounds(330, 20, 100, 30);
				deleteBtn1.setBounds(540, 55, 100, 35);
				
				northPanel1.add(jbRefresh);
				northPanel1.add(deleteBtn1);
				northPanel1.add(queryBtn1);
				northPanel1.add(jtf1);
				panel.add(northPanel1);
				//�û���Ϣ��
				JScrollPane scrollPane1 = new JScrollPane();
				scrollPane1.setViewportView(new JLabel("�û���Ϣ����"));
				scrollPane1.setBounds(0, 100, 823, 390);
				String[] colNames1 = { "�û����", "�û�����", "�û��绰", "�û���ַ", "�û����֤��" };

				
				UserService userService = new UserServiceImpl();
				String[][] dates = userService.getUserMessage();

				queryTableModel1 = new DefaultTableModel(dates, colNames1);
				
				queryTable1 = new JTable(queryTableModel1);

				
				queryBtn1.addActionListener(new ManagerMainViewSelectUserListener(this));
		     
				
			    deleteBtn1.addActionListener(new ManagerMainViewDeleteUserListener(this));

			    jbRefresh.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String[] colNames1 = { "�û����", "�û�����", "�û��绰", "�û���ַ", "�û����֤��" };

						
						UserService userService = new UserServiceImpl();
						String[][] dates = userService.getUserMessage();

						DefaultTableModel dtm = queryTableModel1;
							
						dtm.setDataVector(dates, colNames1);						
					
						
					}
				});
			    

		        scrollPane1.setViewportView(queryTable1);
	
		panel.add(scrollPane1);
		return panel;
}
			
			/**
			 *������Ϣ��������
			 * 
			 * @return
			 */
			
			private JPanel roomEmpPanel() {
				JPanel panel = new JPanel();
				panel.setLayout(null);
				JPanel northPanel2 = new JPanel();
				panel.add(northPanel2);
				northPanel2.setLayout(null);
				northPanel2.setBounds(0, 0, 800, 100);

				//������ɾ�Ĳ���
				jbksname = new JLabel("��������ѯ");
				jbksgood = new JLabel("���������ѯ");
				jtksname = new JTextField();
				
				jtksgood = new JTextField();
				
				jbksname.setBounds(20, 15, 100, 30);
				jtksname.setBounds(100, 15, 100, 30);
				jbksgood.setBounds(270,15, 100, 30);
				jtksgood.setBounds(355, 15, 100, 30);
				northPanel2.add(jbksname);
				northPanel2.add(jtksname);
				//northPanel2.add(jbksgood);
				//northPanel2.add(jtksgood);
				
				queryBtn2 = new JButton("��ѯ");
				northPanel2.add(queryBtn2);
				queryBtn2.setBounds(250, 15, 100, 25);
				deleteBtn2 = new JButton("ɾ��");
				deleteBtn2.setBounds(540, 60, 100, 25);
				northPanel2.add(deleteBtn2);
				changeBtn2 = new JButton("�޸�");
				
				jbRefresh = new JButton("ˢ��");
				jbRefresh.setBounds(540, 15, 100, 25);
				northPanel2.add(jbRefresh);
				
				changeBtn2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						try
					    {
						  org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
						    
					    }
					    catch(Exception e3)
					    {
					        //TODO exception
					    }
						RoomUpdateView window = new RoomUpdateView();
		
					}
				});
				
				northPanel2.add(changeBtn2);
				changeBtn2.setBounds(670, 15, 100, 25);
				addBtn2 = new JButton("���");
				northPanel2.add(addBtn2);
				addBtn2.setBounds(670, 60, 100, 25);
				
				addBtn2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try
					    {
						  org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
						    
					    }
					    catch(Exception e3)
					    {
					        //TODO exception
					    }
						
						RoomAddView window = new RoomAddView();
		
					}
				});
				
//				addBtn2.addActionListener(l);
				
//                ������Ϣ��
				JScrollPane scrollPane2 = new JScrollPane();
				scrollPane2.setViewportView(new JLabel("������Ϣ����"));
				String[] colNames2 = { "��������", "��������", "���ҵص�", "������������"};
//
//				String[][] datas = {
//						{  "������", "��һ", "��īҽ��", "�ۿ�" },
//						{  "�¶���", "�ܶ�", "��īҽ��", "�ۿ�" },
//						{  "����", "����", "��īҽ��", "Ƥ����" },
//						{  "������", "����", "��īҽ��", "�Կ�" }
//
//				};
//				queryTableModel = new DefaultTableModel(datas, colNames);
				
				RoomService roomService = new RoomServiceImpl();
				
				String[][] dates = roomService.getRoomMessage();

				queryTableModel2 = new DefaultTableModel(dates, colNames2);
				
				queryTable2 = new JTable(queryTableModel2);

				deleteBtn2.addActionListener(new ManagerMainViewDeleteRoomListener(this));
				
				queryBtn2.addActionListener(new ManagerMainViewSelectRoomListener(this));
				
				
				jbRefresh.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String[] colNames2 = { "��������", "��������", "���ҵص�", "������������"};

						
						RoomService roomService = new RoomServiceImpl();
						String[][] dates = roomService.getRoomMessage();

						DefaultTableModel dtm = queryTableModel2;
							
						dtm.setDataVector(dates, colNames2);						
					
						
					}
				});
				
				
				
				scrollPane2.setViewportView(queryTable2);
				scrollPane2.setBounds(0, 100, 823, 390);
				panel.add(scrollPane2);

				return panel;
			}

			

			public JTextField getJtksname() {
				return jtksname;
			}

			public void setJtksname(JTextField jtksname) {
				this.jtksname = jtksname;
			}

			// ���������󲿵���ͼЧ��
			private JScrollPane initLeft() {//�����˵������ص�Ч��(δ��)
				// ��ʾ�������,JTree,JTable��������ڹ��������.
				JScrollPane scrollPane = new JScrollPane();
				// ʵ�������Ľڵ�
				rootNode = new DefaultMutableTreeNode("����Һ�ϵͳ");
				userEmpNode = new DefaultMutableTreeNode("�û���Ϣ����");
				roomEmpNode = new DefaultMutableTreeNode("ҽ����Ϣ����");
				docteroNode = new DefaultMutableTreeNode("������Ϣ����");

				aboutUsEmpNode=new DefaultMutableTreeNode("��������");
				rootNode.add(aboutUsEmpNode);
				rootNode.add(userEmpNode);
				rootNode.add(roomEmpNode);
				rootNode.add(docteroNode);
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
						System.out.println(nodeName);
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

			
			public JTable getQueryTable() {
				return queryTable;
			}
			public JTable getQueryTable1() {
				return queryTable1;
			}
			public JTable getQueryTable2() {
				return queryTable2;
			}
			
			public static void main(String[] args) {
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
			}

			public DefaultTableModel getQueryTableModel() {
				return queryTableModel;
			}

			public void setQueryTableModel(DefaultTableModel queryTableModel) {
				this.queryTableModel = queryTableModel;
			}

			public DefaultTableModel getQueryTableModel1() {
				return queryTableModel1;
			}

			public void setQueryTableModel1(DefaultTableModel queryTableModel1) {
				this.queryTableModel1 = queryTableModel1;
			}

			public DefaultTableModel getQueryTableModel2() {
				return queryTableModel2;
			}

			public void setQueryTableModel2(DefaultTableModel queryTableModel2) {
				this.queryTableModel2 = queryTableModel2;
			}

			public JTextField getJtf2() {
				return jtf2;
			}

			public void setJtf2(JTextField jtf2) {
				this.jtf2 = jtf2;
			}

			public JComboBox getLoginComBox() {
				return loginComBox;
			}

			public void setLoginComBox(JComboBox loginComBox) {
				this.loginComBox = loginComBox;
			}

			public JComboBox getLoginComBox1() {
				return loginComBox1;
			}

			public void setLoginComBox1(JComboBox loginComBox1) {
				this.loginComBox1 = loginComBox1;
			}


			public JTextField getJtf1() {
				return jtf1;
			}

			public void setJtf1(JTextField jtf1) {
				this.jtf1 = jtf1;
			}

			
			
			

	}
	