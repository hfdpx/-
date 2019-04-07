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
import system.view.DoctorDoMessageJPanel;

public class DoctorDoMessageViewListener implements ActionListener {
    private String doctorName;
    private DoctorDoMessageJPanel doctorDoMessageJPanel;
    private JTable tb;
    
    public  DoctorDoMessageViewListener(DoctorDoMessageJPanel doctorDoMessageJPanel,String doctorName){
    	this.doctorDoMessageJPanel=doctorDoMessageJPanel;
    	this.doctorName=doctorName;
    	System.out.println(doctorName);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(" ��ɿ��� ")){
		tb=doctorDoMessageJPanel.getQueryTable();
		if(tb.getSelectedRow()!=-1){
			String username=tb.getValueAt(tb.getSelectedRow(), 0).toString();
			//System.out.print(username);
			DoService doService=new DoServiceImpl();
			//System.out.println(username);
			
			doService.deleteDoByID(username, doctorName);
			
			Vector<String> colNames = new Vector<String>();
			Collections.addAll(colNames,  "�û�����", "ҽ������", "����", "�ص�", "ԤԼʱ��");
			
			Vector<Vector<String>>  vectorDo=new Vector<Vector<String>>();
			DoService doservice=new DoServiceImpl();
			vectorDo=doservice.getDoByDoctorName(doctorName);
			DefaultTableModel dtm = doctorDoMessageJPanel.getQueryTableModel();
			dtm.setDataVector(vectorDo, colNames);
			JOptionPane.showMessageDialog(doctorDoMessageJPanel, "��¼��ɾ��!");
	    }
	  }
		if(e.getActionCommand().equals(" ˢ�¼�¼ ")){
			Vector<String> colNames = new Vector<String>();
			Collections.addAll(colNames,  "�û�����", "ҽ������", "����", "�ص�", "ԤԼʱ��");
			
			Vector<Vector<String>>  vectorDo=new Vector<Vector<String>>();
			DoService doservice=new DoServiceImpl();
			vectorDo=doservice.getDoByDoctorName(doctorName);
			DefaultTableModel dtm = doctorDoMessageJPanel.getQueryTableModel();
			dtm.setDataVector(vectorDo, colNames);

		}
		
	}
}
