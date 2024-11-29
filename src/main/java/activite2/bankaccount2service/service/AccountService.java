package activite2.bankaccount2service.service;


import activite2.bankaccount2service.dto.BankAccountRequestDTO;
import activite2.bankaccount2service.dto.BankAccountResponseDTO;
import org.springframework.stereotype.Service;


public interface AccountService {
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);
}
