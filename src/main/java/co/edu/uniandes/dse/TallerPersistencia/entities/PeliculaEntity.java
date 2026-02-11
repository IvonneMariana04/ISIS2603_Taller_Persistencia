package co.edu.uniandes.dse.TallerPersistencia.entities;
import java.util.ArrayList;

import jakarta.persistence.Entity;
import lombok.Data;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Data
@Entity

public class PeliculaEntity extends BaseEntity{
    //ID lo heredan de BaseEntity
    private String titulo;
    private Integer anioLanzamiento;

    @ManyToMany
    private ArrayList<ActorEntity> actores;
    
    @ManyToOne
    private DirectorEntity director;

}
