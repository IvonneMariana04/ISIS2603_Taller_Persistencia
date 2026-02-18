import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import co.edu.uniandes.dse.TallerPersistencia.entities.PeliculaEntity;
import co.edu.uniandes.dse.TallerPersistencia.services.PeliculaService;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
@Import(PeliculaService.class)


public class PeliculaServiceTest {
    
    @Autowired
    private PeliculaService peliculaService;

    @Autowired
    private TestEntityManager entityManager;

    private PodamFactory factory = new PodamFactoryImpl();

    @Test
    void testCrearPelicula(){
        PeliculaEntity newEntity = factory.manufacturePojo(PeliculaEntity.class);
        PeliculaEntity result = peliculaService.crearPelicula(newEntity);

        PeliculaEntity entity = entityManager.find(PeliculaEntity.class, result.getId());

        assertNotNull(result);
        assertNotNull(result.getId());

        assertEquals(newEntity, result);
        assertEquals(newEntity.getTitulo(), entity.getTitulo);
        assertEquals(newEntity.getAnioLanzamiento, entity.getAnioLanzamiento);
    }

    @Test
    void testAnioLanzamientoIncorrecto(){
        PeliculaEntity newEntity = factory.manufacturePojo(PeliculaEntity.class);
        
        newEntity.setAnioLanzamiento(1900);

        assertThrows(IllegalStateException.class, () -> {peliculaService.crearPelicula(newEntity);
        });
    }
}
