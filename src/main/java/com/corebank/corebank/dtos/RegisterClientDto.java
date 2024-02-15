package com.corebank.corebank.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // permet de generer les getter et setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterClientDto {
    @NotBlank(message = "Le nom du client ne peut pas être vide")
    private String name;

    @NotBlank(message = "L'adresse email du client ne peut pas être vide")
    @Email(message = "Veuillez entrer une adresse email valide")
    private String email;

    @NotBlank(message = "Le type de count ne peut pas etre vide")
    private String account_type;
}
