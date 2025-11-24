package FirstProject.BankingApp.dto;

import jakarta.persistence.Column;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccountDto {


    private Long id;
    private String Name;
    private double balance;
}
