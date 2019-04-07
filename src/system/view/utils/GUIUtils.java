package system.view.utils;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;

/**
 * 
 * ���ھ�����ʾ
 * 
 * @author yb 2018-1-16
 */
public class GUIUtils {
	/**
	 * ��һ����������Ļ�о�����ʾ
	 * 
	 * @param jf
	 */
	public static void setCenterInWindow(Window jf) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		// �����Ļ��Ϣ
		Dimension screenSize = toolkit.getScreenSize();
		int x = (screenSize.width - jf.getWidth()) / 2;
		int y = (screenSize.height - jf.getHeight()) / 2;

		jf.setLocation(x, y);
	}

}
