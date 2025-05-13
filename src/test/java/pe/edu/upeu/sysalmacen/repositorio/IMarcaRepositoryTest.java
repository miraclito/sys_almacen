package pe.edu.upeu.sysalmacen.repositorio;


import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import pe.edu.upeu.sysalmacen.modelo.Marca;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
//@Rollback(false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@ActiveProfiles("test") //Para base de datos real de pruebas
public class IMarcaRepositoryTest {

    @Autowired
    private IMarcaRepository marcaRepository;
    private static Long marcaId;

    @BeforeEach
    public void setUp() {
        Marca marca = new Marca();
        marca.setNombre("Samsung");
        Marca guardada = marcaRepository.save(marca);
        marcaId = guardada.getIdMarca(); // Guardamos el ID para pruebas

    }
    @Test
    @Order(1)
    public void testGuardarMarca() {
        Marca nuevaMarca = new Marca();
        nuevaMarca.setNombre("LG");
        Marca guardada = marcaRepository.save(nuevaMarca);

        Assertions.assertNotNull(guardada.getIdMarca());
        Assertions.assertNotNull("LG", guardada.getNombre());
    }
}

