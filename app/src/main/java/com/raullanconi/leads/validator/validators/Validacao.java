package com.raullanconi.leads.validator.validators;

@FunctionalInterface
public interface Validacao {
	
    public abstract boolean isOk(Object pObjeto);
    
}