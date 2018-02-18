package fuber.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

@RunWith( MockitoJUnitRunner.class )
@SpringBootTest( classes = Currency.class )
@AutoConfigureMockMvc
public class CurrencyTest
{
    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks( this );
    }

    @Test
    public void shouldBeEqalWhenBothAreHavingSameCentFactorAndsameStrinRepresentation() throws Exception
    {
        Currency currency = new Currency( 100,"dogecoin");

        Currency currency1 = new Currency( 100, "dogecoin" );

        assertTrue(currency.equals( currency1 ));
    }

    @Test
    public void shoudlNotBeEqualIfStringRepresentationIsDifferent() throws Exception {

        Currency currency = new Currency( 100,"dogecoin");

        Currency currency1 = new Currency( 100, "inr" );

        assertFalse(currency.equals( currency1 ));
    }

}
