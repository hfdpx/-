package system.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
*@author:yb
*@version ����ʱ�䣺2018��1��18�� ����4:05:36
*/
public class ManagerViewDoctorAddListener implements ActionListener{

	private ManagerMainView managerMainView;
	
	public ManagerViewDoctorAddListener(ManagerMainView managerMainView) {
		this.managerMainView=managerMainView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try
	    {
		  org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		    
	    }
	    catch(Exception e3)
	    {
	        //TODO exception
	    }
		DoctorAddView ai = new DoctorAddView();
		ai.init();
		
	}

}
