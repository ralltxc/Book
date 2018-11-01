package test;

import java.util.List;

import dao.UserDao;
import entity.Users;

public class testDao {
	public static void main(String[] args) {
		
		List<Users> users = UserDao.selectUser();
		if(users!=null){
			for (Users users2 : users) {
				System.out.println(users2);
			}
		}
		
		System.out.println(UserDao.updateUserPWD(2, "111"));
		
		Users users2 = UserDao.check("user02", "111");
		if (users2==null) {
			System.out.println("null");
		}else {
			System.out.println(users2);
		}
	}
}
