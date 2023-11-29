package com.uce.edu;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
import com.uce.edu.transferencia.repository.modelo.Transferencia;
import com.uce.edu.transferencia.service.ICuentaBancariaService;
import com.uce.edu.transferencia.service.ITransferenciaService;

@SpringBootApplication
public class Pa2U1P5JjRgApplication implements CommandLineRunner {
	
	@Autowired //inyeccion por atributo
	private ITransferenciaService iTransferenciaService;
	
	/* Inyeccion por constructor
	private ITransferenciaService iTransferenciaService;
	
	@Autowired
	public Pa2U1P5JjRgApplication(ITransferenciaService iTransServi) {
		this.iTransferenciaService=iTransServi;
	} 
	*/
	/* Inyeccion por método
	private ITransferenciaService iTransferenciaService;
	
	@Autowired 
	public void setiTransferenciaService(ITransferenciaService iTransferenciaService) {
		this.iTransferenciaService = iTransferenciaService;
	}
	 */
	@Autowired
	private ICuentaBancariaService iCuentaBancariaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5JjRgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// 1.Crear las cuentas
		CuentaBancaria ctaOrigen = new CuentaBancaria();
		ctaOrigen.setCedulaPropietario("1750888404");
		ctaOrigen.setNumero("1234");
		ctaOrigen.setSaldo(new BigDecimal(100));
		this.iCuentaBancariaService.guardar(ctaOrigen);

		
		CuentaBancaria ctaDestino = new CuentaBancaria();
		ctaDestino.setCedulaPropietario("1719608729");
		ctaDestino.setNumero("1235");
		ctaDestino.setSaldo(new BigDecimal(200));
		this.iCuentaBancariaService.guardar(ctaDestino);

		this.iTransferenciaService.realizar("1234", "1235", new BigDecimal(10));

		this.iTransferenciaService.realizar("1234","1235", new BigDecimal(10));
		this.iTransferenciaService.realizar("1235","1234", new BigDecimal(10));


		List<Transferencia> lista = this.iTransferenciaService.buscarTodos();
		int indice=0;
		for(Transferencia trans:lista) {
			indice++;
			System.out.println(trans+" : "+trans.getNumero());
		}
		CuentaBancaria ctaOrigen1 = this.iCuentaBancariaService.buscar("1234");
		System.out.println(ctaOrigen1);
		 
		CuentaBancaria ctaDestino1 = this.iCuentaBancariaService.buscar("1235");
		System.out.println(ctaDestino1);
		
		this.iCuentaBancariaService.depositar("1234", new BigDecimal(100));
		
		CuentaBancaria ctaOrigen2 = this.iCuentaBancariaService.buscar("1234");
		System.out.println(ctaOrigen2);
	}
}
