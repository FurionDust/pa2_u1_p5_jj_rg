package com.uce.edu.transferencia.service;

import java.util.List;

import com.uce.edu.transferencia.repository.modelo.NumeracionTransferencia;

public interface INumeracionTransferenciaService {
	// CRUD
	public NumeracionTransferencia seleccionar(long numero);

	public void insertar(NumeracionTransferencia numeracionTransferencia);

	public void actualizar(NumeracionTransferencia numeracionTransferencia);

	public void eliminar(long numero);

	public String contar();

	public List<NumeracionTransferencia> seleccionarTodo();

}