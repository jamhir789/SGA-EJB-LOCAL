/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.servicio.PersonaService;
import org.junit.Before;
/**
 *
 * @author erick.medina
 */
public class PersonaServiceTest {
  
    private PersonaService personaService;
    
    @Before
    public void setUp() throws Exception {
        EJBContainer contenedor = EJBContainer.createEJBContainer(); //creamos una instancia de contenedor buscando la clase por medio de la interface y se la asiganamos a la variabale
        personaService = (PersonaService) contenedor.getContext().lookup("java:global/classes/PersonaServiceImpl!mx.com.gm.sga.servicio.PersonaService");
    }

    @Test
    public void testEJBPersonaService() {
        System.out.println("Iniciando test EJB PersonaService");
        assertTrue(personaService != null); //hacemos una comparacion para que nuest

        assertEquals(2, personaService.listarPersonas().size());//los datos solicitados llamamos a 2

        System.out.println("El no. de personas es igual a:" + personaService.listarPersonas().size());//de ser correcto imprimimos

        this.desplegarPersonas(personaService.listarPersonas());//mandamos a llmar al metodo listar personas para pasarlos al metodo desplegarPersonas
        System.out.println("Fin test EJB PersonaService");
    }

    private void desplegarPersonas(List<Persona> personas) {
        for (Persona persona : personas) {
            System.out.println(persona);
        }
    }
    
}
