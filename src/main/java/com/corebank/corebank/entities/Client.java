package com.corebank.corebank.entities;

import com.corebank.corebank.constraints.IsEmailExists;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "clients")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Client extends  BaseEntity{
    //id, name, email,
    //many_account
    @NotBlank(message = "Vous devez saisir un nom")
    @Column(nullable = false)
    private String name;

   // @IsEmailExists(message = "some error")
    @Email(message = "saisir un mail valid")
    @Column(unique = true, nullable = false)
    private String email;

    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<Account> accounts;


}
