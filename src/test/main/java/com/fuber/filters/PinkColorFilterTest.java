package fuber.filters;

import fuber.model.Car;
import fuber.model.Location;
import fuber.model.NormalCar;
import fuber.model.PinkCar;
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
@SpringBootTest( classes = PinkColorFilter.class )
@AutoConfigureMockMvc
public class PinkColorFilterTest
{
    @InjectMocks
    PinkColorFilter pinkColorFilter;

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks( this );
    }

    @Test
    public void shouldGetOnlyPinkCarsFromListOfAvailableCars() throws Exception
    {
        ArrayList<Car> availableCars = new ArrayList<>();
        availableCars.add( 0, new PinkCar( new Location( 1.0, 2.0 ), 1 ) );
        availableCars.add( 0, new PinkCar( new Location( 1.0, 2.0 ), 1 ) );
        availableCars.add( 0, new NormalCar( new Location( 1.0, 2.0 ), 1 ) );

        ArrayList<Car> actualCars = pinkColorFilter.applyOn( availableCars );
        assertEquals( actualCars.size(), 2 );
    }

    @Test
    public void shouldReturnZeroIfNumberOfNormalCarsAvailableAreZero() throws Exception
    {
        ArrayList<Car> availableCars = new ArrayList<>();
        availableCars.add( 0, new NormalCar( new Location( 1.0, 2.0 ), 1 ) );
        availableCars.add( 0, new NormalCar( new Location( 1.0, 2.0 ), 1 ) );

        ArrayList<Car> actualCars = pinkColorFilter.applyOn( availableCars );
        assertEquals( actualCars.size(), 0 );
    }
}


