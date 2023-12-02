package com.uce.edu.inventario.repository;

import com.uce.edu.inventario.repository.modelo.Inventario;
import com.uce.edu.inventario.repository.modelo.Producto;

public interface IInventarioRepository {

	// CRUD
	public Inventario seleccionar(String codigo);
	
	public Inventario seleccionarEliminar(String codigo);

	public void insertar(Inventario inventario);

	public void actualizar(Inventario inventario);

	public void eliminar(String codigo);
}
