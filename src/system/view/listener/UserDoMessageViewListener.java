package system.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import system.service.DoService;
import system.service.impl.DoServiceImpl;
import system.view.UserDoMessageJpanel;

public class UserDoMessageViewListener implements ActionListener {
    private String username;
    private UserDoMessageJpanel userDoMessageJPanel;
    private JTable tb;
   
	public UserDoMessageViewListener(UserDoMessageJpanel  userDoMessageJPanel,String username){
		this.userDoMessageJPanel=userDoMessageJPanel;
		this.username=username;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("�h��ԤԼ�Һ�")){
		  tb=userDoMessageJPanel.getQueryTable();
		  if(tb.getSelectedRow()!=-1){//�������е�����
			  String doctorname=tb.getValueAt(tb.getSelectedRow(), 1).toString();
			  DoService doService=new DoServiceImpl();
			  doService.deleteDoByID(username, doctorname);
			
			  Vector<String> colNames = new Vector<String>();
			  Collections.addAll(colNames,  "�û�����", "ҽ������", "����", "�ص�", "ԤԼʱ��");
			
			  Vector<Vector<String>>  vectorDo=new Vector<Vector<String>>();
			  DoService doservice=new DoServiceImpl();
			  vectorDo=doservice.getDoByUserName(username);
			  DefaultTableModel dtm = userDoMessageJPanel.getQueryTableModel();
			  dtm.setDataVector(vectorDo, colNames);
			  JOptionPane.showMessageDialog(userDoMessageJPanel, "ɾ���ɹ�");
		}
	}
		if(e.getActionCommand().equals("ˢ�¹Һż�¼")){
			Vector<String> colNames = new Vector<String>();
			  Collections.addAll(colNames,  "�û�����", "ҽ������", "����", "�ص�", "ԤԼʱ��");
			Vector<Vector<String>>  vectorDo=new Vector<Vector<String>>();
			  DoService doservice=new DoServiceImpl();
			  vectorDo=doservice.getDoByUserName(username);
			  DefaultTableModel dtm = userDoMessageJPanel.getQueryTableModel();
			  dtm.setDataVector(vectorDo, colNames);
		}

	}

}
