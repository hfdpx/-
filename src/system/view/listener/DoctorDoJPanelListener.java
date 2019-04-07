package system.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import system.service.DoctorService;
import system.service.impl.DoctorServiceImpl;
import system.view.DoctorHospitalMessageJpanel;

public class DoctorDoJPanelListener implements ActionListener {
	private String buttonMessage; 
	private   DoctorHospitalMessageJpanel  doctorHospitalMessage;
	private DoctorService doctorservice;
	private String[] colNames = { "ҽ�����", "ҽ������", "�Ա�", "����", "��������","�ó�����","�칫�ص�" };
	public DoctorDoJPanelListener(DoctorHospitalMessageJpanel  doctorHospitalMessage,String buttonMessage){
		this.doctorHospitalMessage=doctorHospitalMessage;
		this.buttonMessage=buttonMessage;
		doctorservice=new DoctorServiceImpl();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(buttonMessage.equals("���Ҳ�ѯ")){
			

			String roomnumber= doctorHospitalMessage.getKeshiTextField().getText();
			String[][] dates =doctorservice.getSomeDoctorMessageByRoom(roomnumber) ;
			DefaultTableModel dtm = doctorHospitalMessage.getQueryTableModel();
			dtm.setDataVector(dates, colNames);
		}
        
        if(buttonMessage.equals("ҽ����ѯ")){
        	
        	String doctorname=doctorHospitalMessage.getZhuanjiaTextField().getText();
        	String[][] dates =doctorservice.getOneDoctorMessage(doctorname);
        	DefaultTableModel dtm = doctorHospitalMessage.getQueryTableModel();
			dtm.setDataVector(dates, colNames);
		}
        if(buttonMessage.equals("ˢ��")){
        	String[][] dates =doctorservice.getDoctorMessage();
        	DefaultTableModel dtm = doctorHospitalMessage.getQueryTableModel();
			dtm.setDataVector(dates, colNames);
        }
  }

}
