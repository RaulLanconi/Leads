package com.raullanconi.leads.validator.validators;

public class ValidacaoQuantidadeMaximaDigitos extends AbstractValidator {
	
    public ValidacaoQuantidadeMaximaDigitos(String pMensagem, int pTamanho) {
    	
        super(pMensagem + " deve ter no máximo " + pTamanho + " dígitos",
        		pObjeto -> {return String.format("%d", pObjeto).length() <= pTamanho;});
        
    }

}