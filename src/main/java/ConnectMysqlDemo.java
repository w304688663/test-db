



import java.util.ArrayList;
import java.util.List;

import com.homvee.db.MessageUtil;
import com.homvee.db.dao.impl.MySqlBaseDaoImpl;
import com.homvee.grpc.GRPCMsg;

public class ConnectMysqlDemo {
	MySqlBaseDaoImpl mySqlBaseDaoImpl  = new MySqlBaseDaoImpl();
	public static void main(String[] args) {
		ConnectMysqlDemo mySqlBaseDaoImpl  = new ConnectMysqlDemo();
		mySqlBaseDaoImpl.testGetPrimaryKeyName();
	}

	public void testGetDataSource() {
		try {
			mySqlBaseDaoImpl.getDataSource();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testGetPrimaryKeyName() {
		System.out.println(mySqlBaseDaoImpl.getPrimaryKeyName("dbuser"));
	}

	public void testUpdateMessage() {
		GRPCMsg.Teacher.Builder teacher = GRPCMsg.Teacher.newBuilder();
		teacher.setId(1);
		teacher.setAge(15);
		teacher.setName("THWqs");
		mySqlBaseDaoImpl.update(teacher.build());
	}

	public void testSaveMessage() {
		GRPCMsg.Teacher.Builder teacher = GRPCMsg.Teacher.newBuilder();
		teacher.setAge(30);
		teacher.setName("THW");
		teacher.setSalary(50);
		mySqlBaseDaoImpl.save(teacher.build());
	}


	public void testQueryStringListOfQClassOfQextendsMessage() {
		GRPCMsg.Teacher.Builder teacher = GRPCMsg.Teacher.newBuilder();
		teacher.setAge(30);
		teacher.setName("THW");
		GRPCMsg.Teacher.Builder teacher1 = GRPCMsg.Teacher.newBuilder();
		System.out.println(mySqlBaseDaoImpl.query(teacher.build(), teacher1));
	}

	public void testGetTableName() {
		GRPCMsg.Teacher.Builder teacher = GRPCMsg.Teacher.newBuilder();
		System.out.println(MessageUtil.getTableName(teacher.build()));
	}
	
	public void testGetByPrimaryKey() {
		GRPCMsg.Teacher.Builder teacher = GRPCMsg.Teacher.newBuilder();
		teacher.setId(1);
		System.out.println(mySqlBaseDaoImpl.getByPrimaryKey(teacher.build()));
	}
	
	public void testDelete() {
		GRPCMsg.Teacher.Builder teacher = GRPCMsg.Teacher.newBuilder();
		teacher.setId(2);
		System.out.println(mySqlBaseDaoImpl.delete(teacher.build()));
	}

	public void testCountStringListOfQ() {
		String sql = "select count(*) from teacher where age = ?";
		List<Object> parm  = new ArrayList<Object>();
		parm.add(15);
		System.out.println(mySqlBaseDaoImpl.count(sql,parm));
	}

	public void testQueryStringListOfQ() {
		GRPCMsg.Teacher.Builder teacher = GRPCMsg.Teacher.newBuilder();
		String sql = "select * from teacher where age = ?";
		List<Object> parm  = new ArrayList<Object>();
		parm.add(15);
		System.out.println(mySqlBaseDaoImpl.query(sql,parm, teacher));
	}

}