package com.uce.edu.inventario.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.inventario.repository.IBodegaRepository;
import com.uce.edu.inventario.repository.IInventarioRepository;
import com.uce.edu.inventario.repository.IProductoRepository;
import com.uce.edu.inventario.repository.modelo.Bodega;
import com.uce.edu.inventario.repository.modelo.Inventario;
import com.uce.edu.inventario.repository.modelo.Producto;

@Service
public class InventarioServiceImpl implements IInventarioService {

	@Autowired
	private IProductoRepository productoRepository;
	
	@Autowired
	private IBodegaRepository bodegaRepository;

	@Autowired
	private IInventarioRepository inventarioRepository;

	@Override
	public Inventario buscar(String codigo) {
		// TODO Auto-generated method stub
		return this.inventarioRepository.seleccionar(codigo);
	}

	@Override
	public void guardar(Inventario inventario) {
		// TODO Auto-generated method stub
		this.inventarioRepository.insertar(inventario);
	}

	@Override
	public void actualizar(Inventario inventario) {
		// TODO Auto-generated method stub
		this.inventarioRepository.actualizar(inventario);
	}

	@Override
	public void eliminar(String codigo) {
		// TODO Auto-generated method stub
		this.inventarioRepository.eliminar(codigo);
	}

	@Override
	public void registrar(String codigoBodega, String codigoBarras, Integer stock) {
		// TODO Auto-generated method stub
		//1. Obtenemos la bodega
		Bodega bodega = this.bodegaRepository.seleccionar(codigoBodega);
		//2. Obtenemos el producto
		Producto producto = this.productoRepository.seleccionar(codigoBarras);
		//3. obtenemos el stock y lo actualizamos
		Integer stockActual = producto.getStock();
		Integer stockFinal = stockActual+stock;
		producto.setStock(stockFinal);
		this.productoRepository.actualizar(producto);
		//4. creamos el inventario y seteamos
		Inventario inv = new Inventario();
		inv.setCodigo("23423");
		inv.setFechaIngreso(LocalDateTime.now());
		inv.setBodega(bodega);
		inv.setProducto(producto);
		//5. creamos el inventario en la base
		this.inventarioRepository.insertar(inv);
		System.out.println("Registro con exito!");
	}
}