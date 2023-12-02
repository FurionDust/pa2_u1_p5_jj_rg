package com.uce.edu.inventario.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.inventario.repository.modelo.Inventario;
import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
@Repository
public class InventarioRepositoryImpl implements IInventarioRepository {

	private static List<Inventario> base = new ArrayList<Inventario>();

	@Override
	public Inventario seleccionar(String codigo) {
		// TODO Auto-generated method stub

		for (Inventario inventario : base) {
			if (inventario.getCodigo().equals(codigo)) {
				Inventario inv = new Inventario();
				inv.setCodigo(inventario.getCodigo());
				inv.setBodega(inventario.getBodega());
				inv.setFechaIngreso(inventario.getFechaIngreso());
				inv.setProducto(inventario.getProducto());
				return inv;
			}
		}
		return null;
	}

	@Override
	public Inventario seleccionarEliminar(String codigo) {
		// TODO Auto-generated method stub
		for (Inventario cuenta : base) {
			if (cuenta.getCodigo().equals(codigo)) {
				return cuenta;
			}
		}

		return null;
	}
	@Override
	public void insertar(Inventario inventario) {
		// TODO Auto-generated method stub
		base.add(inventario);
	}

	@Override
	public void actualizar(Inventario inventario) {
		// TODO Auto-generated method stub
		this.eliminar(inventario.getCodigo());
		this.insertar(inventario);
	}

	@Override
	public void eliminar(String codigo) {
		// TODO Auto-generated method stub
		Inventario cuenta = this.seleccionarEliminar(codigo);
		base.remove(cuenta);
	}
}