package com.uce.edu.transferencia.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
import com.uce.edu.transferencia.repository.modelo.Transferencia;

@Repository
public class TransferenciaRepositoryImpl implements ITransferenciaRepository {

	private static List<Transferencia> base = new ArrayList<Transferencia>();
	
	@Override
	public Transferencia seleccionar(String numero) {
		// TODO Auto-generated method stub
		for(Transferencia trans:base) {
			if(trans.getNumero().equals(numero)) {
				return trans;
			}
		}
		
		return null;
	}

	@Override
	public void insertar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		base.add(transferencia);
	}

	@Override
	public void actualizar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.eliminar(transferencia.getNumero());
		this.insertar(transferencia);
	}

	@Override
	public void eliminar(String numero) {
		// TODO Auto-generated method stub
		Transferencia trans = this.seleccionar(numero);
		base.remove(trans);

	}

	@Override
	public List<Transferencia> seleccionarTodos() {
		// TODO Auto-generated method stub
		return base;
	}

}
