
package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persistencia.ControladoraPersistencia;
import java.util.List;


public class Controladora {
     ControladoraPersistencia cp = new ControladoraPersistencia();

    public void guardar(String nombreMasco, String raza, String color, String observacion,
            String alergia, String AtenEsp, String nombreDuenio, String celDuenio) {
           Duenio duenio = new  Duenio();
           duenio.setNombre(nombreDuenio);
           duenio.setCelDuenioString(celDuenio);
           Mascota mascota= new Mascota();
           mascota.setNombre(nombreMasco);
           mascota.setRaza(raza);
           mascota.setColor(color);
           mascota.setAlergico(alergia);
           mascota.setAtencion_especial(AtenEsp);
           mascota.setObservaciones(observacion);
           mascota.setDuenio(duenio);
           cp.guardar(duenio,mascota);
           
    }

    public List<Mascota> traerMascotas() {
        
        return cp.traerMascotas()  ;
         }

    public void borrarMascota(int num_cliente) {
        cp.borrarMascota(num_cliente);
    }

  

    public Mascota traerMascota(int num_cliente) {
       return cp.traerMascota(num_cliente); }

    public void modificarMascota(Mascota masco, String nombreMasco, String raza, String color, String observacion, String alergia, String AtenEsp, String nombreDuenio, String celDuenio) {
    //agregar los nuevos valores de mascota
    masco.setNombre(nombreMasco);
    masco.setRaza(raza);
    masco.setColor(color);
    masco.setObservaciones(observacion);
    masco.setAlergico(alergia);
    masco.setAtencion_especial(AtenEsp);
    
    //modifico mascota
    cp.modificarMascota(masco);
    //seteo valores del duenio
    Duenio dueno = this.buscarDuenio(masco.getDuenio().getId_duenio());
    dueno.setNombre(nombreDuenio);
    dueno.setCelDuenioString(celDuenio);
    //llamar al modificar Duenio
    this.modificarDuenio(dueno);
    }

    private Duenio buscarDuenio(int id_duenio) {
        return cp.traerDuenio(id_duenio);}

    private void modificarDuenio(Duenio dueno) {
        cp.modificarDuenio(dueno);   }
     
}
