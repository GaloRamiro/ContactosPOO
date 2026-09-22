package com.krakedev.contacto.entidades.testJunit;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.krakedev.contacto.entidades.Contacto;
import com.krakedev.contacto.entidades.Directorio;

public class DirectorioTest {

    @Test
    public void testAgregarContactoNuevo() {

        // Se prueba que un contacto nuevo pueda ser agregado.
        // Resultado esperado: agregarContacto() retorna true.

        Directorio directorio = new Directorio();

        Contacto contacto = new Contacto();
        contacto.setNombre("Juan");
        contacto.setCelular("0991111111");

        boolean resultado = directorio.agregarContacto(contacto);

        assertTrue(resultado);
    }

    @Test
    public void testAgregarContactoDuplicado() {

        // Se prueba agregar dos contactos con el mismo número celular.
        // Resultado esperado: el segundo contacto no se agrega
        // y agregarContacto() retorna false.

        Directorio directorio = new Directorio();

        Contacto contacto1 = new Contacto();
        contacto1.setNombre("Juan");
        contacto1.setCelular("0991111111");

        Contacto contacto2 = new Contacto();
        contacto2.setNombre("Pedro");
        contacto2.setCelular("0991111111");

        directorio.agregarContacto(contacto1);

        boolean resultado = directorio.agregarContacto(contacto2);

        assertFalse(resultado);
    }

    @Test
    public void testCantidadContactosDespuesDeAgregar() {

        // Se prueba que el tamaño de la lista aumente
        // después de agregar contactos diferentes.
        // Resultado esperado: la lista contiene 2 contactos.

        Directorio directorio = new Directorio();

        Contacto contacto1 = new Contacto();
        contacto1.setNombre("Juan");
        contacto1.setCelular("0991111111");

        Contacto contacto2 = new Contacto();
        contacto2.setNombre("Maria");
        contacto2.setCelular("0982222222");

        directorio.agregarContacto(contacto1);
        directorio.agregarContacto(contacto2);

        assertEquals(2, directorio.obtenerCantidadContactos());
    }

    @Test
    public void testNoAgregarContactoDuplicado() {

        // Se prueba que un contacto duplicado no aumente
        // el tamaño de la lista.
        // Resultado esperado: la lista mantiene 1 contacto.

        Directorio directorio = new Directorio();

        Contacto contacto1 = new Contacto();
        contacto1.setNombre("Juan");
        contacto1.setCelular("0991111111");

        Contacto contacto2 = new Contacto();
        contacto2.setNombre("Carlos");
        contacto2.setCelular("0991111111");

        directorio.agregarContacto(contacto1);
        directorio.agregarContacto(contacto2);

        assertEquals(1, directorio.obtenerCantidadContactos());
    }
    @Test
    public void testBuscarContactoExistente() {

        // Se prueba buscar un contacto que sí existe.
        // Resultado esperado: se recupera el contacto correcto.

        Directorio directorio = new Directorio();

        Contacto contacto = new Contacto();
        contacto.setNombre("Juan");
        contacto.setCelular("0991111111");

        directorio.agregarContacto(contacto);

        Contacto encontrado = directorio.buscarContacto("0991111111");

        assertEquals("Juan", encontrado.getNombre());
        assertEquals("0991111111", encontrado.getCelular());
    }

    @Test
    public void testBuscarContactoInexistente() {

        // Se prueba buscar un número que no existe.
        // Resultado esperado: buscarContacto() retorna null.

        Directorio directorio = new Directorio();

        Contacto contacto = new Contacto();
        contacto.setNombre("Juan");
        contacto.setCelular("0991111111");

        directorio.agregarContacto(contacto);

        Contacto encontrado = directorio.buscarContacto("0989999999");

        assertNull(encontrado);
    }

    @Test
    public void testEliminarContactoExistente() {

        // Se prueba eliminar un contacto que existe.
        // Resultado esperado: retorna true y la lista queda vacía.

        Directorio directorio = new Directorio();

        Contacto contacto = new Contacto();
        contacto.setNombre("Maria");
        contacto.setCelular("0982222222");

        directorio.agregarContacto(contacto);

        boolean resultado = directorio.eliminarContacto("0982222222");

        assertTrue(resultado);
        assertEquals(0, directorio.obtenerCantidadContactos());
    }

    @Test
    public void testEliminarContactoInexistente() {

        // Se prueba eliminar un contacto que no existe.
        // Resultado esperado: retorna false y no modifica la lista.

        Directorio directorio = new Directorio();

        Contacto contacto = new Contacto();
        contacto.setNombre("Carlos");
        contacto.setCelular("0973333333");

        directorio.agregarContacto(contacto);

        boolean resultado = directorio.eliminarContacto("0999999999");

        assertFalse(resultado);
        assertEquals(1, directorio.obtenerCantidadContactos());
    }

    @Test
    public void testBuscarContactosConCoincidencias() {

        // Se prueba buscar contactos cuyos nombres empiezan con "Mar".
        // Resultado esperado: se encuentran 2 contactos.

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
    public void testBuscarContactosSinCoincidencias() {

        // Se prueba buscar una subcadena que no coincide con ningún nombre.
        // Resultado esperado: la lista de resultados está vacía.

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