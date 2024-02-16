package com.corebank.corebank.constraints.validators;
import com.corebank.corebank.constraints.IsEmailExists;
import com.corebank.corebank.entities.Client;
import com.corebank.corebank.repositories.ClientRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.web.servlet.HandlerMapping;

import java.util.Map;
import java.util.Optional;

public class IsEmailExistsValidator implements
        ConstraintValidator<IsEmailExists, String> {
    private final ClientRepository clientRepository;
    private final HttpServletRequest request;
    private boolean creating;

    public IsEmailExistsValidator(ClientRepository clientRepository, HttpServletRequest request) {
        this.clientRepository = clientRepository;
        this.request = request;
    }

    @Override
    public void initialize(IsEmailExists constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.creating = constraintAnnotation.creating();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Optional<Client> client = clientRepository.findByEmail(value);

        /*if (creating) {
            return client.isEmpty();
        }*/

       /* if (client.isEmpty()) {
            return true;
        }*/
        return  client.isEmpty();

       /* Map<String, String> pathVariables = (Map) request
                .getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);

        Long id = Long.parseLong(pathVariables.get("id"));

        return id == client.get().getId();*/
    }
}
