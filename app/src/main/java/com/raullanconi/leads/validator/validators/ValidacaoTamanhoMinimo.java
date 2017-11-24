package com.raullanconi.leads.validator.validators;

public class ValidacaoTamanhoMinimo extends AbstractValidator {
	
    public ValidacaoTamanhoMinimo(String pMensagem, int pTamanho) {
    	
        super(pMensagem + " deve ter no mínimo " + pTamanho + " caracteres",
        		pObjeto -> {return pObjeto != null && ((String) pObjeto).trim().length() >= pTamanho;});
        
    }
    
}