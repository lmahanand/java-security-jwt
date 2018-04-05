package io.gopulu.javasecurityjwt;

import io.gopulu.javasecurityjwt.model.JWTUser;
import io.gopulu.javasecurityjwt.security.JWTGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@WebMvcTest(TestTokenController.class)
public class TestTokenController {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private JWTGenerator jwtGenerator;

    JWTUser jwtUser = new JWTUser();

    String jwtUserJson = "{" +
                            "\"username\" : \"admin\"," +
                            "\"password\" : \"123\""+
                        "}";
    /*{
        "username" : "admin",
            "password" : "123"
    }*/
    @Test
    public void generateToken() throws Exception{

        Mockito.when(jwtGenerator.generate(jwtUser)).thenReturn("");
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/token")
                .accept(MediaType.APPLICATION_JSON).content(jwtUserJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        assertEquals(403,response.getStatus());

    }
}
