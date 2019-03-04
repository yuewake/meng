package com.meng.anjia;

import com.meng.anjia.dao.UserDao;
import com.meng.anjia.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnjiaApplicationTests {

	@Autowired
	UserDao userDao;

	@Test
	public void contextLoads() {
		User user = userDao.selectById(9);
		System.out.println(user);
	}

}
