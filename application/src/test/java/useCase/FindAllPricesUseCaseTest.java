package useCase;

import com.neoris.pruebaDaniel.entities.Prices;
import com.neoris.pruebaDaniel.repository.PricesRepository;
import com.neoris.pruebaDaniel.useCase.FindAllPricesUseCaseImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@Component
public class FindAllPricesUseCaseTest {

    @Mock
    PricesRepository pricesRepository;

    List<Prices> pricesList;

    @InjectMocks
    FindAllPricesUseCaseImpl findAllPricesUseCaseImpl;

    AutoCloseable closeable;

    @BeforeEach
    void setup() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllIdiomas() {
        when(pricesRepository.findAll()).thenReturn(pricesList);
        List<Prices> result = findAllPricesUseCaseImpl.findAll();
        assertEquals(pricesList, result);
    }
}
