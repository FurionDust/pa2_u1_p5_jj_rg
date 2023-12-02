package com.uce.edu.inventario.service;

import com.uce.edu.inventario.repository.modelo.Producto;

public interface IProductoService {
	// CRUD
		public Producto buscar(String codigoBarras);

		public void guardar(Producto producto);

		public void actualizar(Producto producto);

		public void eliminar(String codigoBarras);
		
	}