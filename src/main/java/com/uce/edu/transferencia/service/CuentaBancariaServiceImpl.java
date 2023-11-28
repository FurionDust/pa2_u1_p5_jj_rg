package com.uce.edu.transferencia.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.transferencia.repository.ICuentaBancariaRepository;
import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
import com.uce.edu.transferencia.repository.modelo.Transferencia;

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
		// TODO Auto-generated method stub
		// 1. Buscar cuenta por numero
		CuentaBancaria cta = this.bancariaRepository.seleccionar(numero);
		// 2. Consultar el saldo
		BigDecimal saldoOrigen = cta.getSaldo();
		// 3. Validar el saldo
		if(saldoOrigen.compareTo(monto)>=0) {
		// 4. Aumentar el monto del deposito
		BigDecimal nuevoSaldoOrigen = saldoOrigen.add(monto);
		//5. Restar el 10% al nuevo saldo
		BigDecimal interes =new BigDecimal(0.1);
		BigDecimal saldoInteres = nuevoSaldoOrigen.subtract(interes);
		//6. Actualizar el monto
		cta.setSaldo(saldoInteres);
		this.bancariaRepository.actualizar(cta);
		CuentaBancaria deposito = new CuentaBancaria();
		deposito.setMonto(monto);
		deposito.setNumero("1231");
		
		this.bancariaRepository.insertar(deposito);
		System.out.println("Deposito realizado con Exito!");
					
	}
	}

}
