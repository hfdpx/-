package system.test;

import org.junit.Test;

import system.dao.DoDao;
import system.dao.impl.DoDaoImpl;
import system.entity.DO;

/*
*@author:yb
*@version ����ʱ�䣺2018��1��17�� ����12:14:27
*/
/*
 * DO�����
 */
public class DoDaoTest {
	private DoDao doDao = new DoDaoImpl();
	
//	@Test
//	public void listDo(){
//		List<DO> d_o_s = doDao.listDo();
//		System.out.println(d_o_s.size());
//		for(DO d_o:d_o_s) {
//			System.out.println(d_o.getuId());
//		}
//	}
	
//	@Test
//	public void insertDo(){
//		DO d_o = new DO();
//		d_o.setuId(1);
//		d_o.setDoTime("����һ");
//		d_o.setdId(1);
//		d_o.setDoIllness("asdasda");
//		doDao.insertDo(d_o);
//	}
	
//	@Test
//	public void deleteDo() {
//		int i=1;
//		doDao.deleteDo(i);
//	}
	
//	@Test
//	public void updateDo() {
//		DO d_o = new DO();
//		d_o = doDao.getDo(1);
//		d_o.setDoTime("���ڶ�");
//		d_o.setdId(3);
//		d_o.setDoIllness("sdfsdfsd");
//		doDao.updateDo(1, d_o);
//	}
	
//	@Test
//	public void getDo() {
//		int i=1;
//		DO d_o = doDao.getDo(i);
//		System.out.println(d_o.getuId());
//	}
	
}
