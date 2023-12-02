package com.uce.edu.inventario.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.inventario.repository.modelo.Bodega;
import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
@Repository
public class BodegaRepositoryImpl implements IBodegaRepository {

	private static List<Bodega> base = new ArrayList<Bodega>();

	@Override
	public Bodega seleccionar(String codigo) {
		// TODO Auto-generated method stub

		for (Bodega bodega : base) {
			if (bodega.getCodigo().equals(codigo)) {
				Bodega bga = new Bodega();
				bga.setCapacidad(bodega.getCapacidad());
				bga.setCodigo(bodega.getCodigo());
				bga.setDireccion(bodega.getDireccion());
				bga.setNombre(bodega.getNombre());
				return bga;
			}
		}
		return null;
	}
	@Override
	public Bodega seleccionarEliminar(String codigo) {
		// TODO Auto-generated method stub
		for (Bodega cuenta : base) {
			if (cuenta.getCodigo().equals(codigo)) {
				return cuenta;
			}
		}

		return null;
	}
	@Override
	public void insertar(Bodega bodega) {
		// TODO Auto-generated method stub
		base.add(bodega);
	}

	@Override
	public void actualizar(Bodega bodega) {
		// TODO Auto-generated method stub
		this.eliminar(bodega.getCodigo());
		this.insertar(bodega);
	}

	@Override
	public void eliminar(String codigo) {
		// TODO Auto-generated method stub
		Bodega bodega = this.seleccionarEliminar(codigo);
		base.remove(bodega);
	}
}