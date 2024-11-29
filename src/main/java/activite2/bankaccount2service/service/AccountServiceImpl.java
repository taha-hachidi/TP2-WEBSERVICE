package activite2.bankaccount2service.service;

import activite2.bankaccount2service.dto.BankAccountRequestDTO;
import activite2.bankaccount2service.dto.BankAccountResponseDTO;
import activite2.bankaccount2service.entities.BankAccount;
import activite2.bankaccount2service.repositories.BankAccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBalance(bankAccountRequestDTO.getBalance());
        bankAccount.setCurrency(bankAccountRequestDTO.getCurrency());
        bankAccount.setType(bankAccountRequestDTO.getType());
        bankAccountRepository.save(bankAccount);
        return new BankAccountResponseDTO(bankAccount.getId(), bankAccount.getBalance(), bankAccount.getCurrency(), bankAccount.getType());
    }

}
