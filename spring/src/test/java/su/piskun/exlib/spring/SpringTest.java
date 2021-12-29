package su.piskun.exlib.spring;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.GetMapping;
import su.piskun.exlib.core.HttpEx;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootApplication
@ComponentScan("su.piskun.exceptions.spring")
class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

@Controller
class TestController {

    @GetMapping("/test")
    void test() {
        throw HttpEx.teapot()
            .message("testing")
            .context("integration", "spring")
            .cause(new RuntimeException("a potential cause"))
            .build();
    }
}

@WebMvcTest(controllers = TestController.class)
public class SpringTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testSpringIntegration() throws Exception {
        // Given.
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/test");

        // When.
        ResultActions resultActions = this.mockMvc.perform(requestBuilder);

        // Then.
        MvcResult result = resultActions.andExpect(status().is(HttpEx.TEAPOT))
            .andDo(print())
            .andReturn();

        ObjectMapper mapper = createObjectMapper();
        ExDto actualExDto = mapper.readValue(result.getResponse().getContentAsByteArray(), ExDto.class);

        assertThat(actualExDto.getId()).isNotNull();
        assertThat(actualExDto.getTimestamp()).isBeforeOrEqualTo(Instant.now());
        assertThat(actualExDto.getCode()).isEqualTo(HttpEx.CLIENT_ERROR);
        assertThat(actualExDto.getContext()).isNotNull();
        assertThat(actualExDto.getContext().get("integration")).isEqualTo("spring");
        assertThat(actualExDto.getMessage()).isEqualTo("testing");
    }

    private static ObjectMapper createObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        return mapper;
    }
}
