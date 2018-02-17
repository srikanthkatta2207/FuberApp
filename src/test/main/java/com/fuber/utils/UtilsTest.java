package fuber.utils;

import fuber.Utils.Utils;
import fuber.model.Location;
import fuber.model.PinkCar;
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
public class UtilsTest
{
    @InjectMocks
    Utils utils;

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks( this );
    }

   @Test
    public void shouldCalculateDistanceBetweenTwoLocations() {
       Location locaiton1 = new Location( 2.0,3.0 );
       Location location2 = new Location( 5.0,6.0 );

       double actualDistance = Utils.calculateDistanceBetween(locaiton1,location2);

       assertEquals(actualDistance,2.850,.2);
   }
}


