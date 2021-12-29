package su.piskun.exlib.core;

import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

public class ExTest {

    @Test
    void create() {
        // Given.
        Ex ex = Ex.builder()
            .code("code")
            .message("message")
            .context("key", "value")
            .cause(new RuntimeException())
            .build();

        // Then.
        assertThat(ex.getId()).isNotNull();
        assertThat(ex.getTimestamp()).isBeforeOrEqualTo(Instant.now());
        assertThat(ex.getMessage()).isEqualTo("message");
        assertThat(ex.getCode()).isEqualTo("code");
        assertThat(ex.getContext()).hasSize(1);
        assertThat(ex.getContext().get("key")).isEqualTo("value");
        assertThat(ex.getCause()).isInstanceOf(RuntimeException.class);
    }

    @Test
    void as() {
        // Given.
        Ex ex = Ex.as("message");

        // Then.
        assertThat(ex.getId()).isNotNull();
        assertThat(ex.getTimestamp()).isBeforeOrEqualTo(Instant.now());
        assertThat(ex.getMessage()).isEqualTo("message");
        assertThat(ex.getCode()).isEqualTo(Ex.DEFAULT_CODE);
        assertThat(ex.getContext()).isNull();
        assertThat(ex.getCause()).isNull();
    }

    @Test
    void asMessageArgs() {
        // Given.
        String message = "message";
        Ex ex = Ex.as("This is my %s.", message);

        // Then.
        assertThat(ex.getId()).isNotNull();
        assertThat(ex.getTimestamp()).isBeforeOrEqualTo(Instant.now());
        assertThat(ex.getMessage()).isEqualTo("This is my message.");
        assertThat(ex.getCode()).isEqualTo(Ex.DEFAULT_CODE);
        assertThat(ex.getContext()).isNull();
        assertThat(ex.getCause()).isNull();
    }
}
