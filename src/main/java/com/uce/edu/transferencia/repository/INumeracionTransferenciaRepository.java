package com.uce.edu.transferencia.repository;

import java.util.List;

import com.uce.edu.transferencia.repository.modelo.NumeracionTransferencia;

public interface INumeracionTransferenciaRepository {

	// CRUD
	public NumeracionTransferencia seleccionar(long numero);

	public void insertar(NumeracionTransferencia numeracionTransferencia);

	public void actualizar(NumeracionTransferencia numeracionTransferencia);

	public void eliminar(long numero);

	public List<NumeracionTransferencia> seleccionarTodo();

}