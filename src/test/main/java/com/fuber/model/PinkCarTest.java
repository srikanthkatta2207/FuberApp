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
@SpringBootTest( classes = PinkCar.class )
@AutoConfigureMockMvc
public class PinkCarTest
{
    @InjectMocks
    PinkCar pinkCar;

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks( this );
    }

    @Test
    public void shouldGetLongitudeAndLatitude() throws Exception
    {
        Location location = new Location( 100.00, 200.00 );
        pinkCar = new PinkCar( location, 123 );

        assertEquals( pinkCar.getNumber(), 123 );
        assertEquals( pinkCar.getLocation().getLongitude(), 100.00, .2 );
        assertEquals( pinkCar.getLocation().getLatitude(), 200.00, .2 );
    }


    @Test
    public void shouldTestExtraPriceShouldEqualsToFive() throws Exception
    {
        Location location = new Location( 100.00, 200.00 );
        pinkCar = new PinkCar( location, 123 );
        assertEquals( pinkCar.extraPrice, 5 );
    }
}


