package com.raullanconi.leads.validator.validators;

public abstract class Validador {
	
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public static void validar(Object pObjeto, AbstractValidator... pValidacoesLista) {
    	
        for(AbstractValidator abstractValidator : pValidacoesLista) {
        	
            abstractValidator.validar(pObjeto);
            
        }
        
    }

    public static String consistir(Object pObjeto, AbstractValidator... pValidacoesLista) {
    	
        StringBuilder mensagens = new StringBuilder();

        for(AbstractValidator abstractValidator : pValidacoesLista) {
        	
            String mensagem = abstractValidator.consistir(pObjeto);
            if (!mensagem.isEmpty())
                mensagens.append(mensagem + LINE_SEPARATOR);
            
        }

        return mensagens.toString();
        
    }

    public static ErroVerificacao verificar(String... pErros) {
    	
        ErroVerificacao resultado = new ErroVerificacao();

        for(String erro : pErros) {
        	
           resultado.setOk(erro.isEmpty());
           resultado.addMensagem(erro);
           
        }

        return resultado;

    }
}
