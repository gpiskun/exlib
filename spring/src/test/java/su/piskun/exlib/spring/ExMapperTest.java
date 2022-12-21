package su.piskun.exlib.spring;

import org.junit.jupiter.api.Test;
import su.piskun.exlib.core.Ex;
import su.piskun.exlib.core.HttpEx;

import static org.assertj.core.api.Assertions.assertThat;

class ExMapperTest {

    private final ExMapper sut = new ExMapper();

    @Test
    void map() {
        // Given.
        HttpEx source = HttpEx.internalServerError()
            .message("test")
            .context("key", "value")
            .build();

        // When.
        ExDto target = sut.map(source);

        // Then.
        assertThat(target.getId()).isEqualTo(source.getId());
        assertThat(target.getMessage()).isEqualTo(source.getMessage());
        assertThat(target.getCode()).isEqualTo(source.getCode());
        assertThat(target.getTimestamp()).isEqualTo(source.getTimestamp());
        assertThat(target.getContext()).isEqualTo(source.getContext());
    }

    @Test
    void mapDefault() {
        // Given.
        Exception source = new RuntimeException("message");

        // When.
        ExDto target = sut.map(source);

        // Then.
        assertThat(target.getId()).isNotNull();
        assertThat(target.getMessage()).isEqualTo(source.getMessage());
        assertThat(target.getCode()).isEqualTo(Ex.DEFAULT_CODE);
        assertThat(target.getTimestamp()).isNotNull();
        assertThat(target.getContext()).isNull();
    }

    @Test
    void mapWithoutContext() {
        // Given.
        HttpEx source = HttpEx.teapot("test");

        // When.
        ExDto target = sut.map(source);

        // Then.
        assertThat(target.getContext()).isNull();
    }
}