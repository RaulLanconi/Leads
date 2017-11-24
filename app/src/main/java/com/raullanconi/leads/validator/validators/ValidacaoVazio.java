package com.raullanconi.leads.validator.validators;

public class ValidacaoVazio extends AbstractValidator {
	
    public ValidacaoVazio(String pMensagem) {
    	
        super(pMensagem + " não pode ter conteúdo vazio",
        		pObjeto -> pObjeto != null && !((String)pObjeto).trim().isEmpty());
        
    }
    
}