package com.uce.edu.transferencia.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
import com.uce.edu.transferencia.repository.modelo.NumeracionTransferencia;

@Repository
public class NumeracionTransferenciaRepositoryImpl implements INumeracionTransferenciaRepository{


	private static List<NumeracionTransferencia> base = new ArrayList<NumeracionTransferencia>();

	@Override
	public NumeracionTransferencia seleccionar(long numero) {
		// TODO Auto-generated method stub
		for(NumeracionTransferencia contador:base) {
			if(contador.getContador()==numero) {
				return contador;
			}
		}

		return null;
	}

	@Override
	public void insertar(NumeracionTransferencia numeracionTransferencia) {
		// TODO Auto-generated method stub
		base.add(numeracionTransferencia);
	}

	@Override
	public void actualizar(NumeracionTransferencia numeracionTransferencia) {
		// TODO Auto-generated method stub
		this.eliminar(numeracionTransferencia.getContador());
		this.insertar(numeracionTransferencia);

	}

	@Override
	public void eliminar(long numero) {
		// TODO Auto-generated method stub
		NumeracionTransferencia contador = this.seleccionar(numero);
		base.remove(contador);
	}

	@Override
	public List<NumeracionTransferencia> seleccionarTodo() {
		// TODO Auto-generated method stub
		return base;
	}

}