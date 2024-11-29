package activite2.bankaccount2service.entities;

import activite2.bankaccount2service.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types=BankAccount.class, name="p1")
public interface AccountProjection {
    public String getId();
    public AccountType getType();
    public Double getBalance();
}
