package co.edu.uniandes.dse.TallerPersistencia.entities;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class ActorEntity extends BaseEntity{
    
    //ID lo heredan de BaseEntity
    private String nombre;
    private String nacionalidad;

    @ManyToMany
    private ArrayList<PeliculaEntity> peliculas;
    
}
