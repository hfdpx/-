package system.service;

import system.exception.DaoException;
import system.exception.UsernameOrPwdErrorException;

/*
*@author:yb
*@version ����ʱ�䣺2018��1��18�� ����9:51:56
*/
/*
 * ������Ҷ���ҵ�����
 */
public interface RoomService {
	/*
	 * ���������п�����Ϣ��ҵ�����,Ҫ�󷵻�"��������", "��������", "���ҵص�", "������������"
	 */
	public String[][] getRoomMessage() throws DaoException,UsernameOrPwdErrorException;

}
