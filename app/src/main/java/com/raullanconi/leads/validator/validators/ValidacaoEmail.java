package com.raullanconi.leads.validator.validators;

public class ValidacaoEmail extends AbstractValidator {
	
    private static final String REGEXP_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public ValidacaoEmail(String pMensagem) {
    	
        super(pMensagem + " não está de acordo com as regras",
        		pObjeto -> pObjeto != null && ((String)pObjeto).matches(REGEXP_EMAIL));
        
    }
    
}