package com.sid.bankaccountserver.service;

import com.sid.bankaccountserver.DTO.BankAccountRequestDTO;
import com.sid.bankaccountserver.DTO.BankAccountResponseDTO;

public interface BankAccountService {
    BankAccountResponseDTO addBankAccount(BankAccountRequestDTO bankAccountDTO);
}
