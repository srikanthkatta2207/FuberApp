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
@SpringBootTest( classes = Money.class )
@AutoConfigureMockMvc
public class MoneyTest
{
    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks( this );
    }

    @Test
    public void shouldBeEqalWhenBothAreHavingSameCurrenciesAndAmount() throws Exception
    {
        Money money = new Money( 100, Currency.dogeCoin() );

        Money money2 = new Money( 100, Currency.dogeCoin() );

        assertTrue(money.equals( money2 ));
    }

    @Test
    public void shoudlNotBeEqualIfAmountIsDifferent() throws Exception {

        Money money = new Money( 100, Currency.dogeCoin() );

        Money money2 = new Money( 400, Currency.dogeCoin() );

        assertFalse(money.equals( money2 ));
    }

}
