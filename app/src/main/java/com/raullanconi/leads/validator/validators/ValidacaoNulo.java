package com.raullanconi.leads.validator.validators;

public class ValidacaoNulo extends AbstractValidator {
	
    public ValidacaoNulo(String pMensagem) {
    	
        super(pMensagem + " não pode ser uma referência nula",
        		pObjeto -> pObjeto != null);
        
    }

}