package fuber.model;

import fuber.Dao.CarStoreDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith( MockitoJUnitRunner.class )
@SpringBootTest( classes = Location.class )
@AutoConfigureMockMvc
public class CarStoreDaoTest
{
    @InjectMocks
    CarStoreDao carStoreDao;

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks( this );
    }

    @Test
    public void shouldGetAllAvailableCarsFromStore() throws Exception
    {
        ArrayList<Car> availableCars = carStoreDao.getAllAvailableCars();

        Car expectedCar = new NormalCar( new Location( 1.0, 5.0 ), 1 );

        assertEquals(availableCars.get( 0 ).getLocation().getLatitude(),expectedCar.getLocation().getLatitude(),.2);
        assertEquals(availableCars.get( 0 ).getLocation().getLongitude(),expectedCar.getLocation().getLongitude(),.2);
        assertEquals(availableCars.get( 0 ).getNumber(),expectedCar.getNumber());
    }

}
