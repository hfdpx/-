package system.exception;
/*
*@author:yb
*@version ����ʱ�䣺2018��1��16�� ����10:35:40
*/

/*
 * �Զ���ĵ��쳣,����Dao��
 * ���´���Ϊ�Զ�����
 */
public class DaoException extends RuntimeException{//�̳�����ʱ�쳣
	/**
	 * 
	 */
	public DaoException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public DaoException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public DaoException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public DaoException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
