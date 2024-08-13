
package com.mycompany.peluqueriacanina.persistencia;

import com.mycompany.peluqueriacanina.logica.Duenio;
import com.mycompany.peluqueriacanina.logica.Mascota;
import com.mycompany.peluqueriacanina.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
    DuenioJpaController djc = new DuenioJpaController();
    MascotaJpaController mjc = new MascotaJpaController();

    public void guardar(Duenio duenio, Mascota mascota) {
       djc.create(duenio);
       mjc.create(mascota);
        }

    public List<Mascota> traerMascotas() {
        
      return mjc.findMascotaEntities();   }

    public void borrarMascota(int num_cliente) {
        try {
            mjc.destroy(num_cliente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
 }

    public Mascota traerMascota(int num_cliente) {
        
       return mjc.findMascota(num_cliente); 
     }

    public void modificarMascota(Mascota masco) {
        try {
            mjc.edit(masco);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
 }

    public Duenio traerDuenio(int id_duenio) {
       return djc.findDuenio(id_duenio);   }

    public void modificarDuenio(Duenio dueno) {
        try {
            djc.edit(dueno);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
    
}
