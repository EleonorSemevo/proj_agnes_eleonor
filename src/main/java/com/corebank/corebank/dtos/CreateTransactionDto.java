
package com.corebank.corebank.dtos;

        import jakarta.validation.constraints.Email;
        import jakarta.validation.constraints.NotBlank;
        import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;
        import lombok.NonNull;

        import java.time.LocalDateTime;

@Data // permet de generer les getter et setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateTransactionDto {

    @NonNull
    private double amount;

    @NotBlank(message = "Le type de transaction  ne peut pas etre vide")
    private String transaction_type;



}

