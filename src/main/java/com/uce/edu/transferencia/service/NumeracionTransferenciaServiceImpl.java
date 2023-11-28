package com.uce.edu.transferencia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.transferencia.repository.INumeracionTransferenciaRepository;
import com.uce.edu.transferencia.repository.modelo.NumeracionTransferencia;

@Service
public class NumeracionTransferenciaServiceImpl implements INumeracionTransferenciaService{

	@Autowired
	private INumeracionTransferenciaRepository numeracionRepository;


	@Override
	public NumeracionTransferencia seleccionar(long numero) {
		// TODO Auto-generated method stub
		return this.numeracionRepository.seleccionar(numero);
	}

	@Override
	public void insertar(NumeracionTransferencia numeracionTransferencia) {
		// TODO Auto-generated method stub
		this.numeracionRepository.insertar(numeracionTransferencia);
	}

	@Override
	public void actualizar(NumeracionTransferencia numeracionTransferencia) {
		// TODO Auto-generated method stub
		this.numeracionRepository.actualizar(numeracionTransferencia);
	}

	@Override
	public void eliminar(long numero) {
		// TODO Auto-generated method stub
		this.numeracionRepository.eliminar(numero);
	}

	@Override
	public String contar() {
		long temp =0;
		List<NumeracionTransferencia> listtemp = this.seleccionarTodo();
		if(listtemp.isEmpty()) {
			NumeracionTransferencia contadortemp = new NumeracionTransferencia();
			contadortemp.setContador(1);
			this.numeracionRepository.insertar(contadortemp);
			return String.valueOf(1);
		}else {
			NumeracionTransferencia numa = listtemp.get(listtemp.size()-1);
			temp = numa.getContador();
			NumeracionTransferencia num = new NumeracionTransferencia();
			num.setContador(temp+1);
			this.numeracionRepository.insertar(num);
			return String.valueOf(temp+1);
		}

	}

	@Override
	public List<NumeracionTransferencia> seleccionarTodo() {
		// TODO Auto-generated method stub
		return numeracionRepository.seleccionarTodo();
	}

}