package com.raullanconi.leads.validator.validators;

public class ValidacaoTamanhoMaximo extends AbstractValidator {
	
    public ValidacaoTamanhoMaximo(String pMensagem, int pTamanho) {
    	
        super(pMensagem + " deve ter no máximo " + pTamanho + " caracteres",
        		pObjeto -> {return pObjeto != null && ((String) pObjeto).trim().length() <= pTamanho;});
        
    }

}