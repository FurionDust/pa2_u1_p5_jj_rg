package com.uce.edu.transferencia.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.transferencia.repository.ICuentaBancariaRepository;
import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;


@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService {

	@Autowired
	private ICuentaBancariaRepository bancariaRepository;
	
	@Override
	public CuentaBancaria buscar(String numero) {
		// TODO Auto-generated method stub
		return this.bancariaRepository.seleccionar(numero);
	}

	@Override
	public void guardar(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.bancariaRepository.actualizar(cuentaBancaria);
	}

	@Override
	public void actualizar(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.bancariaRepository.actualizar(cuentaBancaria);
	}

	@Override
	public void eliminar(String numero) {
		// TODO Auto-generated method stub
		this.bancariaRepository.eliminar(numero);
	}

	@Override
	public void depositar(String numero, BigDecimal monto) {
		//1. Buscar la cuenta a la que se hará el deposito
		CuentaBancaria ctaDeposito = this.bancariaRepository.seleccionar(numero);
		//2. Consultar el saldo
		BigDecimal saldoAnterior = ctaDeposito.getSaldo();
		//3. Restar el interes del monto
		BigDecimal interes = new BigDecimal(0.9); //es 0.9 porque para obtener el 0.1 es (1-0.1)
		BigDecimal nuevoMonto = monto.multiply(interes).setScale(2, RoundingMode.HALF_EVEN);
		//4. Se añade el nuevo monto al saldo
		BigDecimal nuevoSaldo = saldoAnterior.add(nuevoMonto);
		//5. se actualiza el saldo
		ctaDeposito.setSaldo(nuevoSaldo);
		this.bancariaRepository.actualizar(ctaDeposito);
	
		System.out.println("Deposito realizado con exito!");
		
		//BigDecimal nuevoSaldoActualizado = ctaDeposito.getSaldo().setScale(3, RoundingMode.HALF_EVEN);
		//System.out.println("Nuevo saldo: " + nuevoSaldoActualizado);
		
	}

}
