package com.raullanconi.leads.validator.validators;

public class ValidacaoQuantidadeMinimaDigitos extends AbstractValidator {
	
    public ValidacaoQuantidadeMinimaDigitos(String pMensagem, int pTamanho) {
    	
        super(pMensagem + " deve ter no mínimo " + pTamanho + " dígitos",
        		pObjeto -> {return String.format("%d", pObjeto).length() >= pTamanho;});
        
    }
    
}