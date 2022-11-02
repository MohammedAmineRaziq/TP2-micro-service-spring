package com.sid.bankaccountserver.web;

import com.sid.bankaccountserver.DTO.BankAccountRequestDTO;
import com.sid.bankaccountserver.DTO.BankAccountResponseDTO;
import com.sid.bankaccountserver.entities.BankAccount;
import com.sid.bankaccountserver.mappers.AccountMapper;
import com.sid.bankaccountserver.repositories.BankAccountRepository;
import com.sid.bankaccountserver.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AccountRestController {

    private BankAccountRepository bankAccountRepository;
    @Autowired
    private BankAccountService bankAccountService;
    @Autowired
    private AccountMapper accountMapper;

    public AccountRestController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @GetMapping("/BankAccounts")
    public List<BankAccount> getBankAccounts(){
        return bankAccountRepository.findAll();
    }

    @GetMapping("/BankAccounts/{id}")
    public BankAccount getBankAccount(@PathVariable String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Bank Account with id %s not found", id)));
    }

    @PostMapping("/BankAccounts")
    public BankAccountResponseDTO saveBankAccount(@RequestBody BankAccountRequestDTO requestDTO){
        return bankAccountService.addBankAccount(requestDTO);
    }

    @PutMapping("/BankAccounts/{id}")
    public BankAccount updateBankAccount(@PathVariable String id, @RequestBody BankAccount bankAccount){
        BankAccount newBankAccount = bankAccountRepository.findById(id).orElseThrow();
        if (bankAccount.getBalance()!=null) newBankAccount.setBalance(bankAccount.getBalance());
        if (bankAccount.getCreationDate()!=null) newBankAccount.setCreationDate(new Date());
        if (bankAccount.getCurrency()!=null) newBankAccount.setCurrency(bankAccount.getCurrency());
        if (bankAccount.getType()!=null) newBankAccount.setType(bankAccount.getType());
        return bankAccountRepository.save(newBankAccount);
    }

    @DeleteMapping("/BankAccounts/{id}")
    public void deleteBankAccount(@PathVariable String id){
        bankAccountRepository.deleteById(id);
    }

}
