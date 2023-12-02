package com.uce.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.inventario.repository.modelo.Bodega;
import com.uce.edu.inventario.repository.modelo.Producto;
import com.uce.edu.inventario.service.IBodegaService;
import com.uce.edu.inventario.service.IInventarioService;
import com.uce.edu.inventario.service.IProductoService;

@SpringBootApplication
public class Pa2U1P5JjRgApplication implements CommandLineRunner {
	
	@Autowired
	private IInventarioService iInventarioService;
	
	@Autowired
	private IProductoService iProductoService;
	@Autowired
	private IBodegaService iBodegaService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5JjRgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Producto p1 = new Producto();
		p1.setCodigoBarras("123456");
		p1.setNombre("HP 15 laptop");
		p1.setStock(0);
		
		this.iProductoService.guardar(p1);
		
		Producto p2 = new Producto();
		p2.setCodigoBarras("123457");
		p2.setNombre("teclado HP");
		p2.setStock(0);
		this.iProductoService.guardar(p2);
		
		Bodega bodega1 = new Bodega();
		bodega1.setCapacidad(500);
		bodega1.setCodigo("1234");
		bodega1.setNombre("El bodegon");
		bodega1.setDireccion("Av 6 de diciembre y Eloy Alfaro");
		this.iBodegaService.guardar(bodega1);
		
		
		this.iInventarioService.registrar("1234","123456", 50);
		
		this.iInventarioService.registrar("1234", "123457", 100);
		
		this.iInventarioService.registrar("1234", "123456", 20);
	
		
		System.out.println(this.iProductoService.buscar("123456"));
		System.out.println(this.iProductoService.buscar("123457"));
		
		
	}
}
