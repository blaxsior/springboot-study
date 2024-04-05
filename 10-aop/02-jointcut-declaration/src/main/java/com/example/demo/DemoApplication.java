package com.example.demo;

import com.example.demo.account.dao.AccountDao;
import com.example.demo.account.entity.Account;
import com.example.demo.membership.dao.MembershipDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(AccountDao accountDao, MembershipDao membershipDao) {
		return args -> {
			accountDao.addAccount(new Account("hello", "world"));
			accountDao.addAccount2(new Account("hello", "world"), true);
			membershipDao.addMembership();
			membershipDao.addSillyFunc();
			// 여기 영역에 대해서는 출력 안됨
			accountDao.setName("hello");
			accountDao.getName();
			accountDao.setServiceCode("code");
			accountDao.getServiceCode();
		};
	}

//	private void demoBeforeAdvice(AccountDao dao) {
//		System.out.println("Logging: before addAccount");
//		dao.addAccount();
//	}
}
