package fuber.service;

import fuber.model.Car;
import fuber.model.Customer;
import fuber.model.Location;
import fuber.model.NormalCar;
import fuber.services.PaymentService;
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

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith( MockitoJUnitRunner.class )
@SpringBootTest( classes = PaymentService.class )
@AutoConfigureMockMvc
public class PaymentServiceTest
{
    @InjectMocks
    PaymentService paymentService;

    @Mock
    HttpSession httpSession;

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks( this );
    }

    @Test
    public void shouldGetThePaymentBeZeroWhenCurrentLocationAnDestinationAreSame() {

        Customer customer = new Customer();
        customer.setLocation(new Location( 1,1 ));

        Car car = new NormalCar();
        car.setLocation( new Location( 1,1 ) );

        when(httpSession.getAttribute( "customer" )).thenReturn( customer );
        when(httpSession.getAttribute( "car" )).thenReturn( car );

        double actualPrice = paymentService.getPayment();

        assertEquals(0.0,actualPrice,0.2);

    }

    @Test
    public void shouldGetThePaymentMoreThanZeroWhenCurrentLocationAnDestinationAreDifferent() {

        Customer customer = new Customer();
        customer.setLocation(new Location( 1,1 ));

        Car car = new NormalCar();
        car.setLocation( new Location( 1,5 ) );

        when(httpSession.getAttribute( "customer" )).thenReturn( customer );
        when(httpSession.getAttribute( "car" )).thenReturn( car );

        double actualPrice = paymentService.getPayment();

        assertEquals(14.55,actualPrice,0.2);

    }
}

