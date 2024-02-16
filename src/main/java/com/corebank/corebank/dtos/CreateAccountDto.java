package com.corebank.corebank.dtos;

        import jakarta.validation.constraints.Email;
        import jakarta.validation.constraints.NotBlank;
        import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;

@Data // permet de generer les getter et setter
@AllArgsConstructor
//@NoArgsConstructor
public class CreateAccountDto {

    @NotBlank(message = "Le type de count ne peut pas etre vide")
    private String account_type;
}

