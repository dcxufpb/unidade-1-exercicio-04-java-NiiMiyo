package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestCupomFiscal {

	private String BREAK = System.lineSeparator();

	@Test
	public void lojaCompleta() {
		rodarTestarRetorno("Arcos Dourados Com. de Alimentos LTDA" + BREAK + 
				"Av. Projetada Leste, 500 EUC F32/33/34" + BREAK + 
				"Br. Sta Genebra - Campinas - SP" + BREAK + 
				"CEP:13080-395 Tel (19) 3756-7408" + BREAK + 
				"Loja 1317 (PDP)" + BREAK + 
				"CNPJ: 42.591.651/0797-34" + BREAK + 
				"IE: 244.898.500.113" + BREAK);
	}

	@Test
	public void nomeVazio() {
		CupomFiscal.NOME_LOJA = "";
		try {
			CupomFiscal.dadosLoja();
		} catch (RuntimeException e) {
			assertEquals("O campo nome da loja é obrigatório", e.getMessage());
		}
		CupomFiscal.NOME_LOJA = "Arcos Dourados Com. de Alimentos LTDA";
	}
	
	@Test
	public void logradouroVazio() {
		CupomFiscal.LOGRADOURO = "";
		try {
			CupomFiscal.dadosLoja();
		} catch (RuntimeException e) {
			assertEquals("O campo logradouro do endereço é obrigatório", e.getMessage());
		}
		CupomFiscal.LOGRADOURO = "Av. Projetada Leste";
	}

	@Test
	public void numeroZero() {
		CupomFiscal.NUMERO = 0;
		rodarTestarRetorno("Arcos Dourados Com. de Alimentos LTDA" + BREAK +
				"Av. Projetada Leste, s/n EUC F32/33/34" + BREAK +
				"Br. Sta Genebra - Campinas - SP" + BREAK +
				"CEP:13080-395 Tel (19) 3756-7408" + BREAK +
				"Loja 1317 (PDP)" + BREAK +
				"CNPJ: 42.591.651/0797-34" + BREAK +
				"IE: 244.898.500.113" + BREAK);

		CupomFiscal.NUMERO = 500;
	}
	
	@Test
	public void municipioVazio() {
		CupomFiscal.MUNICIPIO = "";
		try {
			CupomFiscal.dadosLoja();
		} catch (RuntimeException e) {
			assertEquals("O campo município do endereço é obrigatório", e.getMessage());
		}
		CupomFiscal.MUNICIPIO = "Campinas";
	}

	@Test
	public void estadoVazio() {
		CupomFiscal.ESTADO = "";
		try {
			CupomFiscal.dadosLoja();
		} catch (RuntimeException e) {
			assertEquals("O campo estado do endereço é obrigatório", e.getMessage());
		}
	    CupomFiscal.ESTADO = "SP";
	}
	
	@Test
	public void cnpjVazio() {
		CupomFiscal.CNPJ = "";
		try {
			CupomFiscal.dadosLoja();
		} catch (RuntimeException e) {
			assertEquals("O campo CNPJ da loja é obrigatório", e.getMessage());
		}
	    CupomFiscal.CNPJ = "42.591.651/0797-34";
	}

	@Test
	public void inscricaoEstadualVazia() {
		CupomFiscal.INSCRICAO_ESTADUAL = "";
		try {
			CupomFiscal.dadosLoja();
		} catch (RuntimeException e) {
			assertEquals("O campo inscrição estadual da loja é obrigatório", e.getMessage());
		}
		CupomFiscal.INSCRICAO_ESTADUAL = "244.898.500.113";
	}
	
	@Test
	public void exercicio02_Customizado() {
		//Defina seus próprios valores para as variáveis a seguir 
		CupomFiscal.NOME_LOJA = "Top 10 nomes de lojas";
		CupomFiscal.LOGRADOURO = "Rua Tchurusbango Tchurusmago";
		CupomFiscal.NUMERO = 13;
		CupomFiscal.COMPLEMENTO = "Do lado da casa vizinha";
		CupomFiscal.BAIRRO = "Bairro do Limoeiro";
		CupomFiscal.MUNICIPIO = "São Paulo";
		CupomFiscal.ESTADO = "SP";
		CupomFiscal.CEP = "08090-284";
		CupomFiscal.TELEFONE = "(11) 4002-8922";
		CupomFiscal.OBSERVACAO = "Entre o Campinho e a Lua de Baixo";
		CupomFiscal.CNPJ = "43.745.249/0001-39";
		CupomFiscal.INSCRICAO_ESTADUAL = "564.213.199.866";

		String expected = "Top 10 nomes de lojas" + BREAK;
		expected += "Rua Tchurusbango Tchurusmago, 13 Do lado da casa vizinha" + BREAK;
		expected += "Bairro do Limoeiro - São Paulo - SP" + BREAK;
		expected += "CEP:08090-284 Tel (11) 4002-8922" + BREAK;
		expected += "Entre o Campinho e a Lua de Baixo" + BREAK;
		expected += "CNPJ: 43.745.249/0001-39" + BREAK;
		expected += "IE: 564.213.199.866";
		
		//E atualize o texto esperado abaixo
		rodarTestarRetorno(expected + BREAK);
	}

	private void rodarTestarRetorno(String expected) {

		// action
		String retorno = CupomFiscal.dadosLoja();

		// assertion
		assertEquals(expected, retorno);
	}
}
