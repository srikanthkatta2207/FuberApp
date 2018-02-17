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
public class CustomerTest
{
    @InjectMocks
    Customer customer;

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks( this );
    }

    @Test
    public void shouldGetLongitudeAndLatitude() throws Exception
    {
        Location location = new Location( 100.00,200.00 );

        customer.setName( "test" );
        customer.setLocation( location );

        assertEquals( customer.getName(), "test");
        assertEquals( customer.getLocation().getLatitude(),200.00,0.2);
        assertEquals( customer.getLocation().getLongitude(),100.00,0.2);
    }

}
