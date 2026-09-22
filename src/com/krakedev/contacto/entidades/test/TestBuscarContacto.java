package com.krakedev.contacto.entidades.test;

import com.krakedev.contacto.entidades.Contacto;
import com.krakedev.contacto.entidades.Directorio;

public class TestBuscarContacto {

	public static void main(String[] args) {

		Directorio dir = new Directorio();
		Contacto c1 = new Contacto();
		c1.setNombre("Galo");
		c1.setCelular("0979101815");
		Contacto c2 = new Contacto();
		c2.setNombre("Juan");
		c2.setCelular("0910187915");
		Contacto c3 = new Contacto();
		c3.setNombre("Carlos");
		c3.setCelular("0970181915");

		dir.agregarContacto(c1);
		dir.agregarContacto(c2);
		dir.agregarContacto(c3);

		Contacto encontrado = dir.buscarContacto("0979101815");
		if (encontrado != null) {
			System.out.println("Nombre: " + encontrado.getNombre());
		} else {
			System.out.println("No existe ese contacto");
		}

		Contacto noEncontrado = dir.buscarContacto("097111111");
		if (noEncontrado != null) {
			System.out.println("Nombre: " + noEncontrado.getNombre());
		} else {
			System.out.println("No existe ese contacto");
		}
	}

}
