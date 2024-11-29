package activite2.bankaccount2service.web;

import activite2.bankaccount2service.dto.BankAccountRequestDTO;
import activite2.bankaccount2service.dto.BankAccountResponseDTO;
import activite2.bankaccount2service.entities.BankAccount;
import activite2.bankaccount2service.repositories.BankAccountRepository;
import activite2.bankaccount2service.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphQLController {

    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountService accountService;

    @QueryMapping
    public List<BankAccount> accountsList() {
        return bankAccountRepository.findAll();
    }

    @QueryMapping
    public BankAccount bankAccountById(@Argument String id) {
        return bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException("Account not found"));
    }

    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount) {
        return accountService.addAccount(bankAccount);
    }
}



