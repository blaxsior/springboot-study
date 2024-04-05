package com.example.demo;

import com.example.demo.TrafficFortune.service.TrafficFortuneService;
import com.example.demo.account.dao.AccountDao;
import com.example.demo.account.entity.Account;
import com.example.demo.membership.dao.MembershipDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(AccountDao accountDao, MembershipDao membershipDao, TrafficFortuneService service) {
		return args -> {
//			accountDao.addAccount(new Account("hello", "world"));
//			accountDao.addAccount2(new Account("hello", "world"), true);
//			membershipDao.addMembership();
//			membershipDao.addSillyFunc();
			// 여기 영역에 대해서는 출력 안됨
//			accountDao.setName("hello");
//			accountDao.getName();
//			accountDao.setServiceCode("code");
//			accountDao.getServiceCode();
//			findAccounts(accountDao);
//			afterAdviceException(accountDao);
			fortuneServiceAround(service);
		};
	}

//	private void demoBeforeAdvice(AccountDao dao) {
//		System.out.println("Logging: before addAccount");
//		dao.addAccount();
//	}

	private void findAccounts(AccountDao accountDao) {
		var accounts = accountDao.findAccounts();
		System.out.println("[returned accounts: ]");
		accounts.forEach(it->System.out.println(it));
	}

	private void afterAdviceException(AccountDao accountDao) {
		Account account = null;
		try {
			account = accountDao.findById(1);
		}catch(Exception e) {
			System.out.println("[Main: afterThrowingAdvice]");
			System.out.println("Exception: " + e);
		}
		System.out.println("returned account: " + account);
	}

	public void fortuneServiceAround(TrafficFortuneService service) {
		var fortune = service.getFortune();
		System.out.println("returned fortune is " + fortune);
	}
}
