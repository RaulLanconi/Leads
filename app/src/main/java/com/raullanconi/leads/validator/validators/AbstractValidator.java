package com.raullanconi.leads.validator.validators;

public abstract class AbstractValidator {
	
    private String    mensagem;
    private Validacao validacao;

    public AbstractValidator(String pMensagem, Validacao pValidacao) {
        this.mensagem = pMensagem;
        this.validacao = pValidacao;
    }

    public void validar(Object pObjeto) throws IllegalArgumentException {
        if (!validacao.isOk(pObjeto))
            throw new IllegalArgumentException(mensagem);
    }

    public String consistir(Object pObjeto) {
        return validacao.isOk(pObjeto) ? "" : mensagem;
    }
    
}