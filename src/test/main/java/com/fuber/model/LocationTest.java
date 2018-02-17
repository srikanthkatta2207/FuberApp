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
public class LocationTest
{
    @InjectMocks
    Location location;

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks( this );
    }

    @Test
    public void shouldGetLongitudeAndLatitude() throws Exception
    {
        location.setLatitude( 100.00 );
        location.setLongitude( 200.00 );

        assertEquals( location.getLatitude(), 100.00, .2 );
        assertEquals( location.getLongitude(), 200.00, .2 );
    }

}
