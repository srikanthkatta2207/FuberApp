package fuber.service;

import fuber.Dao.CarStoreDao;
import fuber.model.Car;
import fuber.model.Customer;
import fuber.model.Location;
import fuber.model.NormalCar;
import fuber.model.PinkCar;
import fuber.services.CarPoolService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith( MockitoJUnitRunner.class )
@SpringBootTest( classes = CarPoolService.class )
@AutoConfigureMockMvc
public class CarPoolServiceTest
{
    @InjectMocks
    CarPoolService carPoolService;

    @Mock
    CarStoreDao carStoreDao;

    @Mock
    HttpSession httpSession;

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks( this );
    }

    @Test
    public void shouldGetAllAvailableCarsFromDaoStore() throws Exception
    {
        ArrayList<Car> expectedCars = new ArrayList<Car>()
        {{
            new NormalCar( new Location( 1.0, 5.0 ), 1 );
            new NormalCar( new Location( 1.0, 5.0 ), 1 );
        }};

        when( carStoreDao.getAllAvailableCars() ).thenReturn( expectedCars );
        ArrayList<Car> actualCars = carPoolService.getAllAvailableCars();

        assertEquals( actualCars.size(), expectedCars.size() );
    }

    @Test
    public void shouldGetNearByCar() throws Exception {

        ArrayList<Car> expectedCars = new ArrayList<Car>();
        expectedCars.add(0,new NormalCar( new Location( 1.0, 5.0 ), 1 ));
        expectedCars.add(1,new NormalCar( new Location( 15.0, 25.0 ), 2));
        Customer customer = new Customer();
        customer.setLocation( new Location( 2.0,3.0 ) );
        customer.setName( "srikanth" );

        when( carStoreDao.getAllAvailableCars() ).thenReturn( expectedCars );
        when(httpSession.getAttribute( "customer" )).thenReturn( customer);
        Car car = carPoolService.getCarNearBy("normal");

        assertEquals( car.getNumber(),expectedCars.get( 0).getNumber() );
    }

    @Test
    public void shouldGetUserSelectedCarByColor() {
        ArrayList<Car> expectedCars = new ArrayList<Car>();
        expectedCars.add(0,new NormalCar( new Location( 1.0, 5.0 ), 1 ));
        expectedCars.add(1,new PinkCar( new Location( 15.0, 25.0 ), 2));
        Customer customer = new Customer();
        customer.setLocation( new Location( 2.0,3.0 ) );
        customer.setName( "srikanth" );

        when( carStoreDao.getAllAvailableCars() ).thenReturn( expectedCars );
        when(httpSession.getAttribute( "customer" )).thenReturn( customer);
        Car car = carPoolService.getCarNearBy( "pink" );

        assertEquals( car.getNumber(),expectedCars.get( 1).getNumber() );
    }

}
