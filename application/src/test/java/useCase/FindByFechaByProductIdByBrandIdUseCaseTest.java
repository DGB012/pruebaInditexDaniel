package useCase;

import com.neoris.pruebaDaniel.entities.Prices;
import com.neoris.pruebaDaniel.repository.PricesRepository;
import com.neoris.pruebaDaniel.useCase.FindByFechaByProductIdByBrandIdUseCaseImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@Component
public class FindByFechaByProductIdByBrandIdUseCaseTest {

    @Mock
    PricesRepository pricesRepository;

    Prices price;

    @InjectMocks
    FindByFechaByProductIdByBrandIdUseCaseImpl findByFechaByProductIdByBrandIdUseCaseImpl;

    AutoCloseable closeable;

    @BeforeEach
    void setup() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @Test
    void test1() {
        LocalDateTime date = LocalDateTime.parse("2020-06-14 10:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        when(pricesRepository.findByFechaByProductIdByBrandId(date, 35455, 1)).thenReturn(price);
        Prices result = findByFechaByProductIdByBrandIdUseCaseImpl.findByFechaByProductIdByBrandId(date, 35455, 1);
        assertEquals(price, result);
    }

    @Test
    void test2() {
        LocalDateTime date = LocalDateTime.parse("2020-06-14 16:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        when(pricesRepository.findByFechaByProductIdByBrandId(date, 35455, 1)).thenReturn(price);
        Prices result = findByFechaByProductIdByBrandIdUseCaseImpl.findByFechaByProductIdByBrandId(date, 35455, 1);
        assertEquals(price, result);
    }

    @Test
    void test3() {
        LocalDateTime date = LocalDateTime.parse("2020-06-14 21:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        when(pricesRepository.findByFechaByProductIdByBrandId(date, 35455, 1)).thenReturn(price);
        Prices result = findByFechaByProductIdByBrandIdUseCaseImpl.findByFechaByProductIdByBrandId(date, 35455, 1);
        assertEquals(price, result);
    }

    @Test
    void test4() {
        LocalDateTime date = LocalDateTime.parse("2020-06-15 10:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        when(pricesRepository.findByFechaByProductIdByBrandId(date, 35455, 1)).thenReturn(price);
        Prices result = findByFechaByProductIdByBrandIdUseCaseImpl.findByFechaByProductIdByBrandId(date, 35455, 1);
        assertEquals(price, result);
    }

    @Test
    void test5() {
        LocalDateTime date = LocalDateTime.parse("2020-06-16 21:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        when(pricesRepository.findByFechaByProductIdByBrandId(date, 35455, 1)).thenReturn(price);
        Prices result = findByFechaByProductIdByBrandIdUseCaseImpl.findByFechaByProductIdByBrandId(date, 35455, 1);
        assertEquals(price, result);
    }
}
