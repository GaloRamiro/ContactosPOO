package com.krakedev.contacto.entidades.test;

import com.krakedev.contacto.entidades.Contacto;
import com.krakedev.contacto.entidades.Directorio;

public class TestSinBrake {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		Contacto c4 = new Contacto();
		c3.setNombre("Marcela");
		c3.setCelular("0901819715");

		dir.agregarContacto(c1);
		dir.agregarContacto(c2);
		dir.agregarContacto(c3);
		dir.agregarContacto(c4);
		Contacto contactoEncontrad = dir.buscarContacto("0910187915");
		System.out.println("Nombre: " + contactoEncontrad.getNombre());
	}

}
