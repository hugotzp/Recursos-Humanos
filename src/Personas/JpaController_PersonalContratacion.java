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
public class JpaController_PersonalContratacion extends JpaController_Personal implements AdaptadorContratacion{

    public JpaController_PersonalContratacion(EntityManagerFactory emf) {
        super(emf);
    }

    @Override
    public Persona getPersona(Integer idAspirante) {
        return this.findPersonal(idAspirante.longValue());
    }

    @Override
    public void guardarPersona(Persona persona) {
        this.create((Personal) persona);
    }
    
}
