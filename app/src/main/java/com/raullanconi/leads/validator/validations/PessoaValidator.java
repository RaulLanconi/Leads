package com.raullanconi.leads.validator.validations;

import com.raullanconi.leads.validator.validators.*;

public class PessoaValidator {

	public static final AbstractValidator[] validacaoId = {
			new ValidacaoValorMinimo("Id de Pessoa", 1),
			new ValidacaoValorMaximo("Id de Pessoa", 9999999)
	};

	public static final AbstractValidator[] validacaoNome = {
			new ValidacaoNulo("Nome da Pessoa"),
			new ValidacaoVazio("Nome da Pessoa"),
			new ValidacaoTamanhoMinimo("Nome da Pessoa", 1),
			new ValidacaoTamanhoMaximo("Nome da Pessoa", 80)
	};

	public static final AbstractValidator[] validacaoTelefone = {
			new ValidacaoNulo("Telefone da Pessoa"),
			new ValidacaoVazio("Telefone da Pessoa"),
			new ValidacaoTamanhoMinimo("Telefone da Pessoa", 1),
			new ValidacaoTamanhoMaximo("Telefone da Pessoa", 11)
	};

}