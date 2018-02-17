package fuber.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = FuberClientController.class)
@AutoConfigureMockMvc
public class FuberClientControllerTest
{
    @Autowired
    private MockMvc mvc;

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
            .andExpect( view().name("index") );
    }

    @Test
    public void shouldGetBookCarWhenEverUserClickOnBookButton() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders.post( "/book_car" )
                    .param( "name","srikanth" ))
                     .andExpect( status().isOk() )
                     .andExpect( view().name("book_car"));
    }


}
