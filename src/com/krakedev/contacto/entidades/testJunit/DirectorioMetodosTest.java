package com.krakedev.contacto.entidades.testJunit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.krakedev.contacto.entidades.Contacto;
import com.krakedev.contacto.entidades.Directorio;

public class DirectorioMetodosTest {

    @Test
    public void buscarContactoExistente() {

        // Se prueba buscar un contacto que existe por su número celular.
        // Resultado esperado: se encuentra el contacto y sus datos son correctos.

        Directorio directorio = new Directorio();

        Contacto contacto = new Contacto();
        contacto.setNombre("Juan");
        contacto.setApellido("Perez");
        contacto.setEdad(25);
        contacto.setCelular("0991111111");
        contacto.setPeso(70.5);

        directorio.agregarContacto(contacto);

        Contacto encontrado = directorio.buscarContacto("0991111111");

        assertEquals("Juan", encontrado.getNombre());
        assertEquals("0991111111", encontrado.getCelular());
    }

    @Test
    public void buscarContactoInexistente() {

        // Se prueba buscar un número celular que no existe.
        // Resultado esperado: el método retorna null.

        Directorio directorio = new Directorio();

        Contacto contacto = new Contacto();
        contacto.setNombre("Maria");
        contacto.setCelular("0982222222");

        directorio.agregarContacto(contacto);

        Contacto encontrado = directorio.buscarContacto("0979999999");

        assertNull(encontrado);
    }

    @Test
    public void eliminarContactoExistente() {

        // Se prueba eliminar un contacto que existe.
        // Resultado esperado: retorna true y el contacto es eliminado.

        Directorio directorio = new Directorio();

        Contacto contacto = new Contacto();
        contacto.setNombre("Carlos");
        contacto.setCelular("0973333333");

        directorio.agregarContacto(contacto);

        boolean resultado = directorio.eliminarContacto("0973333333");

        assertTrue(resultado);
        assertEquals(0, directorio.obtenerCantidadContactos());
        assertNull(directorio.buscarContacto("0973333333"));
    }

    @Test
    public void eliminarContactoInexistente() {

        // Se prueba eliminar un número celular que no existe.
        // Resultado esperado: retorna false y la lista no cambia.

        Directorio directorio = new Directorio();

        Contacto contacto = new Contacto();
        contacto.setNombre("Pedro");
        contacto.setCelular("0964444444");

        directorio.agregarContacto(contacto);

        boolean resultado = directorio.eliminarContacto("0959999999");

        assertFalse(resultado);
        assertEquals(1, directorio.obtenerCantidadContactos());
    }

    @Test
    public void buscarContactosConCoincidencias() {

        // Se prueba buscar contactos cuyos nombres empiezan con "Mar".
        // Resultado esperado: se encuentran exactamente 2 contactos.

        Directorio directorio = new Directorio();

        Contacto contacto1 = new Contacto();
        contacto1.setNombre("Maria");
        contacto1.setCelular("0991111111");

        Contacto contacto2 = new Contacto();
        contacto2.setNombre("Mario");
        contacto2.setCelular("0982222222");

        Contacto contacto3 = new Contacto();
        contacto3.setNombre("Pedro");
        contacto3.setCelular("0973333333");

        directorio.agregarContacto(contacto1);
        directorio.agregarContacto(contacto2);
        directorio.agregarContacto(contacto3);

        ArrayList<Contacto> encontrados =
                directorio.buscarContactosCoincidencias("Mar");

        assertEquals(2, encontrados.size());

        assertEquals("Maria", encontrados.get(0).getNombre());
        assertEquals("Mario", encontrados.get(1).getNombre());
    }

    @Test
    public void buscarContactosSinCoincidencias() {

        // Se prueba buscar una subcadena que no coincide con ningún nombre.
        // Resultado esperado: la lista obtenida tiene 0 elementos.

        Directorio directorio = new Directorio();

        Contacto contacto1 = new Contacto();
        contacto1.setNombre("Juan");
        contacto1.setCelular("0991111111");

        Contacto contacto2 = new Contacto();
        contacto2.setNombre("Pedro");
        contacto2.setCelular("0982222222");

        directorio.agregarContacto(contacto1);
        directorio.agregarContacto(contacto2);

        ArrayList<Contacto> encontrados =
                directorio.buscarContactosCoincidencias("Mar");

        assertEquals(0, encontrados.size());
    }
}