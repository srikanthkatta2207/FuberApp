package fuber.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@RunWith( MockitoJUnitRunner.class )
@SpringBootTest( classes = Location.class )
@AutoConfigureMockMvc
public class NormalCarTest
{
    @InjectMocks
    NormalCar normalCar;

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks( this );
    }

    @Test
    public void shouldGetLongitudeAndLatitude() throws Exception
    {
        Location location = new Location( 100.00, 200.00 );
        normalCar = new NormalCar( location, 123 );

        assertEquals( normalCar.getNumber(), 123 );
        assertEquals( normalCar.getLocation().getLongitude(), 100.00, .2 );
        assertEquals( normalCar.getLocation().getLatitude(), 200.00, .2 );
    }


    @Test
    public void shouldTestExtraPriceShouldEqualsToZero() {
        Location location = new Location( 100.00, 200.00 );
        normalCar = new NormalCar( location, 123 );
        assertEquals( normalCar.extraPrice, 0 );
    }
}


