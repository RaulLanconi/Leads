package com.raullanconi.leads.validator.validations;

import com.raullanconi.leads.validator.validators.AbstractValidator;
import com.raullanconi.leads.validator.validators.ValidacaoNulo;

public class ObjectValidator {

    private static final String nomeInformacao = "Objeto";

    public static final AbstractValidator[] validacoes = {
    		new ValidacaoNulo(nomeInformacao)
    		};

}