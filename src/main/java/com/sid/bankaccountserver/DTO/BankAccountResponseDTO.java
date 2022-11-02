package com.sid.bankaccountserver.DTO;

import com.sid.bankaccountserver.enums.AccountType;
import lombok.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class BankAccountResponseDTO {
    private String id;
    private Date creationDate;
    private Double balance;
    private String currency;
    private AccountType type;
}
