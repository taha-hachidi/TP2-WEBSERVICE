package activite2.bankaccount2service.repositories;

import activite2.bankaccount2service.entities.BankAccount;
import activite2.bankaccount2service.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface BankAccountRepository extends JpaRepository<BankAccount, String>
{
    @RestResource(path= "/byType")
    List<BankAccount> findByType(@Param("t") AccountType type);
}
