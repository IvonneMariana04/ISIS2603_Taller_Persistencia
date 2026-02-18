package co.edu.uniandes.dse.TallerPersistencia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.TallerPersistencia.entities.PeliculaEntity;
import co.edu.uniandes.dse.TallerPersistencia.repositories.PeliculaRepository;
import jakarta.transaction.Transactional;

@Service
public class PeliculaService {
    
    @Autowired
    private PeliculaRepository peliculaRepository;


    private void validarTituloNoVacio(PeliculaEntity peliculaEntity){
        if (peliculaEntity.getTitulo().trim().isEmpty()){
            throw new IllegalStateException("El titulo no puede ser vacio");
        }
    }

    private void validarTituloNoRepetido(PeliculaEntity peliculaEntity){
        if (peliculaRepository.existsByTitulo(peliculaEntity.getTitulo().trim())){
            throw new IllegalStateException("Ya existe una pelicula con ese titulo");
        }
    }

    private void validarAnioLanzamiento(PeliculaEntity peliculaEntity){
        if (peliculaEntity.getAnioLanzamiento() < 1930){
            throw new IllegalStateException("No puede ser anterior a 1930");
        }
    }

    @Transactional
    public void crearPelicula(PeliculaEntity peliculaEntity){
        
        validarTituloNoVacio(peliculaEntity);
        validarTituloNoRepetido(peliculaEntity);
        validarAnioLanzamiento(peliculaEntity);

        peliculaRepository.save(peliculaEntity);
    }

}
