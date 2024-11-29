package activite2.bankaccount2service.dto;

import activite2.bankaccount2service.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @Builder @NoArgsConstructor
public class BankAccountResponseDTO {
    private String id;
    private Double balance;
    private String currency;
    private AccountType type;
}
