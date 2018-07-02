/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personas;

import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Hugo
 */
public class JpaController_PersonalEstructura extends JpaController_Personal implements AdaptadorEstructura {

    public JpaController_PersonalEstructura(EntityManagerFactory emf) {
        super(emf);
    }

    @Override
    public Persona getPersona(Integer idEmpleado) {
        return this.findPersonal(idEmpleado.longValue());
    }
    
}
