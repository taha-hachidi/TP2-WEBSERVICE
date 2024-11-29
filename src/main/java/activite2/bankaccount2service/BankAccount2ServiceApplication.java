package activite2.bankaccount2service;

import activite2.bankaccount2service.entities.BankAccount;
import activite2.bankaccount2service.enums.AccountType;
import activite2.bankaccount2service.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class BankAccount2ServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccount2ServiceApplication.class, args);
	}


	@Bean
	CommandLineRunner start(BankAccountRepository bankRepo){
		return args -> {
			for(int i=0;i<10;i++){
				BankAccount b= BankAccount.builder()
						.id(UUID.randomUUID().toString())
						.type(Math.random()>0.5? AccountType.Current_Account:AccountType.Saving_Account)
						.balance(1000+Math.random()*9000)
						.createdate(new Date())
						.currency("MAD")
						.build();
				bankRepo.save(b);
			}




		};
	}
}
