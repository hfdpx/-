package system.view;

import javax.swing.SwingUtilities;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;



/*
*@author:yb
*@version ����ʱ�䣺2018��1��17�� ����2:50:54
*/
public class MainStart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// �ṩJDK�ṩ�Ĺ���������Swing�ĳ���,��֤���̵߳İ�ȫ.
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						try
					    {
						org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();					    
					    }
					    catch(Exception e)
					    {
					        //TODO exception
					    }
						LoginView loginView = new LoginView();
						loginView.setVisible(true);
					}
				});
	}

}
