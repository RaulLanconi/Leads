package com.raullanconi.leads.validator.validators;

import java.math.BigDecimal;

public class ValidacaoValorMinimo extends AbstractValidator {
	
    public ValidacaoValorMinimo(String pMensagem, long pValor) {
    	
        super(pMensagem + " deve ser maior que " + pValor,
        		pObjeto -> ((Long)pObjeto) >= pValor);
        
    }

    public ValidacaoValorMinimo(String pMensagem, int pValor) {
    	
        super(pMensagem + " deve ser maior que " + pValor,
        		pObjeto -> ((Integer)pObjeto) >= pValor);
        
    }

    public ValidacaoValorMinimo(String pMensagem, BigDecimal pValor) {
    	
        super(pMensagem + " deve ser maior que " + pValor,
        		pObjeto -> pObjeto != null && ((BigDecimal)pObjeto).compareTo(pValor) >= 0);
        
    }
    
}