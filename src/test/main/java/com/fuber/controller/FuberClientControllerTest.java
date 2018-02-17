package fuber.controller;

import fuber.Dao.CarStoreDao;
import fuber.model.Car;
import fuber.model.Customer;
import fuber.model.Location;
import fuber.model.NormalCar;
import fuber.services.CarPoolService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.http.HttpSession;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith( MockitoJUnitRunner.class )
@SpringBootTest( classes = FuberClientController.class )
@AutoConfigureMockMvc
public class FuberClientControllerTest
{
    @Autowired
    private MockMvc mvc;

    @Mock
    Location location;

    @Mock
    Customer customer;

    @Mock
    HttpSession httpSession;

    @Mock
    CarStoreDao carStoreDao;

    @Mock
    CarPoolService carPoolService;

    @InjectMocks
    FuberClientController fuberClientController;

    @Before
    public void setup()
    {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix( "/WEB-INF/views/" );
        viewResolver.setSuffix( ".jsp" );

        mvc = MockMvcBuilders.standaloneSetup( fuberClientController )
            .setViewResolvers( viewResolver )
            .build();

        MockitoAnnotations.initMocks( this );
    }

    @Test
    public void shouldGetIndexPage() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders.post( "/" ) )
            .andExpect( status().isOk() )
            .andExpect( view().name( "index" ) );
    }

    @Test
    public void shouldGetNearByCarWhenEverUserClickOnBookButton() throws Exception
    {
        Car expectedCar = new NormalCar( new Location( 100.00, 200.00 ), 3 );

        when( carPoolService.getCarNearBy("normal") ).thenReturn( expectedCar );

        mvc.perform( MockMvcRequestBuilders.post( "/book_car" )
            .param( "name", "srikanth" )
            .param( "cur_longitude", "200.00" )
            .param( "cur_latitude", "100.00" )
            .param( "des_longitude", "200.00" )
            .param( "des_latitude", "100.00" )
            .param("filter","normal")
        ).andExpect( status().isOk() )
            .andExpect( view().name( "book_car" ) )
            .andExpect( model().attribute( "customerName", "srikanth" ) )
            .andExpect( model().attribute( "car", expectedCar ) );
    }

    @Test
    public void shouldRedirectDifferentViewIfNoCarsAvailable() throws Exception
    {
        when( carPoolService.getCarNearBy("normal") ).thenReturn( null );

        mvc.perform( MockMvcRequestBuilders.post( "/book_car" )
            .param( "name", "srikanth" )
            .param( "cur_longitude", "200.00" )
            .param( "cur_latitude", "100.00" )
            .param( "des_longitude", "200.00" )
            .param( "des_latitude", "100.00" )
            .param( "filter","normal" )
        ).andExpect( status().isOk() )
            .andExpect( view().name( "reject_page" ) );

    }

    @Test
    public void shouldReturnListOfAvailableCars() throws Exception
    {
        when( carPoolService.getAllAvailableCars() ).thenReturn( null );

        mvc.perform( MockMvcRequestBuilders.get( "/cars" )
        ).andExpect( status().isOk() )
            .andExpect( content().string(""));
    }

}
