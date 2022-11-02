package com.sid.bankaccountserver.mappers;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.sid.bankaccountserver.DTO.BankAccountResponseDTO;
import com.sid.bankaccountserver.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount) {
        BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount, bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }
}
