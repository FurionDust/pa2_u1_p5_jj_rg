package com.uce.edu.inventario.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.inventario.repository.modelo.Inventario;
import com.uce.edu.inventario.repository.modelo.Producto;
@Repository
public class ProductoRepositoryImpl implements IProductoRepository {

	private static List<Producto> base = new ArrayList<Producto>();

	@Override
	public Producto seleccionar(String codigoBarras) {
		// TODO Auto-generated method stub
		for (Producto producto : base) {
			if (producto.getCodigoBarras().equals(codigoBarras)) {
				Producto prod = new Producto();
				prod.setCodigoBarras(producto.getCodigoBarras());
				prod.setNombre(producto.getNombre());
				prod.setStock(producto.getStock());
				return prod;
			}
		}
		return null;
	}
	@Override
	public Producto seleccionarEliminar(String codigoBarras) {
		// TODO Auto-generated method stub
		for (Producto cuenta : base) {
			if (cuenta.getCodigoBarras().equals(codigoBarras)) {
				return cuenta;
			}
		}

		return null;
	}
	@Override
	public void insertar(Producto producto) {
		// TODO Auto-generated method stub
		base.add(producto);
	}

	@Override
	public void actualizar(Producto producto) {
		// TODO Auto-generated method stub
		this.eliminar(producto.getCodigoBarras());
		this.insertar(producto);
	}

	@Override
	public void eliminar(String codigoBarras) {
		// TODO Auto-generated method stub
		Producto producto = this.seleccionarEliminar(codigoBarras);
		base.remove(producto);
	}
}