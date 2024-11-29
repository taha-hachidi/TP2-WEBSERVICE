package activite2.bankaccount2service.web;

import activite2.bankaccount2service.entities.BankAccount;
import activite2.bankaccount2service.repositories.BankAccountRepository;

import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountRestController {


    private BankAccountRepository bankAccountRepository;

    //Injection des dep
    public AccountRestController(BankAccountRepository br){
        this.bankAccountRepository=br;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccountList(){
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccountList(@PathVariable String id){
        return bankAccountRepository.findById(id).orElseThrow(
                ()-> new RuntimeException(String.format("Account %s not found", id))
        );
    }

    @PostMapping("/bankAccounts")
    public BankAccount save(@RequestBody BankAccount bankAccount){
        return bankAccountRepository.save(bankAccount);
    }

    //maj d'un comte qui existe deja
    @PutMapping("/bankAccounts")
    public BankAccount update(@PathVariable String id,@RequestBody BankAccount bankAccount){
        BankAccount compte=bankAccountRepository.findById(id).orElseThrow();

        if(bankAccount.getBalance()!=null) compte.setBalance(bankAccount.getBalance());
        if(bankAccount.getCreatedate()!=null) compte.setCreatedate(new Date());
        if(bankAccount.getType()!=null) compte.setType(bankAccount.getType());
        if(bankAccount.getCurrency()!=null) compte.setCurrency(bankAccount.getCurrency());
        return bankAccountRepository.save(compte);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void deleteByid(@PathVariable String id)
    {
        bankAccountRepository.deleteById(id);

    }

}

