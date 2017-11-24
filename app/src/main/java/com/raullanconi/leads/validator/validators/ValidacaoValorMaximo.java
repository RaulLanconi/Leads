package com.raullanconi.leads.validator.validators;

import java.math.BigDecimal;

public class ValidacaoValorMaximo extends AbstractValidator {
	
    public ValidacaoValorMaximo(String pMensagem, long pValor) {
    	
        super(pMensagem + " deve ser menor que " + pValor,
        		pObjeto -> ((Long)pObjeto) <= pValor);
        
    }

    public ValidacaoValorMaximo(String pMensagem, int pValor) {
    	
        super(pMensagem + " deve ser menor que " + pValor,
        		pObjeto -> ((Integer)pObjeto) <= pValor);
        
    }

    public ValidacaoValorMaximo(String pMensagem, BigDecimal pValor) {
    	
        super(pMensagem + " deve ser maior que " + pValor,
        		pObjeto -> pObjeto != null && ((BigDecimal)pObjeto).compareTo(pValor) <= 0);
        
    }
    
}