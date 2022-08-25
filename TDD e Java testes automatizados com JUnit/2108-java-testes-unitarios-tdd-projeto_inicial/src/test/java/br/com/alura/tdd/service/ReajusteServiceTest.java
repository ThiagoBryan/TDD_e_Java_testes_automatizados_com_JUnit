package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceTest {

	private ReajusteService service;
	private Funcionario funcionario;

	@BeforeEach // antes de rodar cada Teste chama esse primeiro
	public void incializar() {
		System.out.println("Inicializar");
		this.service = new ReajusteService();
		this.funcionario = new Funcionario("Thiago", LocalDate.now(), new BigDecimal("1000.00"));

	}
	
	@AfterEach // vai chamr esse metodo depois do fim de cada teste
	public void finalizar() { 
		System.out.println("FIM");
	}
	
	@BeforeAll // vai rodar antes de todos os Testes
	public static void AntesDeTodos() { // métodos que rodam antes ou depois de todos precisa ser static
		System.out.println("ANTES DE TODOS");
	}
	
	@AfterAll // vai rodar depois de todos os Testes
	public static void depoisDeTodos() { // métodos que rodam antes ou depois de todos precisa ser static
		System.out.println("DEPOIS DE TODOS");
	}

	@Test
	public void reajusteDeveriaSerTresPorcentoQuandoDesemprenhoForADesejar() {
		service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}

	@Test
	public void reajusteDeveriaSerQuinzePorcentoQuandoDesemprenhoForBom() {
		service.concederReajuste(funcionario, Desempenho.BOM);
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}

	@Test
	public void reajusteDeveriaSerVintePorcentoQuandoDesemprenhoForOtimo() {
		service.concederReajuste(funcionario, Desempenho.OTIMO);
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}
}
