package com.raullanconi.leads.validator.validators;

public class ErroVerificacao {
	
    private boolean ok = true;
    private StringBuffer  mensagem = new StringBuffer();

    public boolean isOk() {
        return ok;
    }
    public boolean isNotOk() {
        return !ok;
    }
    public void setOk(boolean pOk) {
        ok = pOk;
    }

    public String getMensagem() {
        return mensagem.toString();
    }
    public void addMensagem(String pMensagem) {
        mensagem.append(pMensagem);
    }
    
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ErroVerificacao [ok=");
		builder.append(this.ok);
		builder.append(", mensagem=");
		builder.append(this.mensagem);
		builder.append("]");
		return builder.toString();
	}

}