package com.sid.bankaccountserver.service;

import com.sid.bankaccountserver.DTO.BankAccountRequestDTO;
import com.sid.bankaccountserver.DTO.BankAccountResponseDTO;
import com.sid.bankaccountserver.entities.BankAccount;
import com.sid.bankaccountserver.mappers.AccountMapper;
import com.sid.bankaccountserver.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;


@Service
@Transactional
public class BankAccountServiceImpl implements BankAccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountMapper accountMapper;


    @Override
    public BankAccountResponseDTO addBankAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .creationDate(new Date())
                .balance(bankAccountDTO.getBalance())
                .currency(bankAccountDTO.getCurrency())
                .type(bankAccountDTO.getType())
                .build();
        BankAccount sevedBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(sevedBankAccount);
        accountMapper.fromBankAccount(sevedBankAccount);
        return bankAccountResponseDTO;
    }
}
