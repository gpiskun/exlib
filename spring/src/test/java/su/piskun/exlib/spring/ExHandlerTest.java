package su.piskun.exlib.spring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import su.piskun.exlib.core.HttpEx;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
public class ExHandlerTest {

    private ExHandler sut;

    @Mock
    private ExMapper mapper;

    @BeforeEach
    public void init() {
        this.sut = new ExHandler(this.mapper);
    }

    @ParameterizedTest
    @MethodSource({"clientErrors", "serverErrors"})
    public void handle(HttpEx exception) {
        // Given.
        final ExDto expectedExDto = ExDto.builder().build();
        given(this.mapper.map(exception)).willReturn(expectedExDto);

        // When.
        ResponseEntity<ExDto> responseEntity = sut.handle(exception);

        // Then.
        assertThat(responseEntity.getBody()).isEqualTo(expectedExDto);
        assertThat(responseEntity.getStatusCode().value()).isEqualTo(exception.getStatusCode());

        verify(this.mapper).map(exception);
        verifyNoMoreInteractions(this.mapper);
    }

    @Test
    public void handle() {
        // Given.
        Exception exception = new RuntimeException();

        final ExDto expectedExDto = ExDto.builder().build();
        given(this.mapper.map(exception)).willReturn(expectedExDto);

        // When.
        ResponseEntity<ExDto> responseEntity = sut.handle(exception);

        // Then.
        assertThat(responseEntity.getBody()).isEqualTo(expectedExDto);
        assertThat(responseEntity.getStatusCode().value()).isEqualTo(HttpEx.INTERNAL_SERVER_ERROR);

        verify(this.mapper).map(exception);
        verifyNoMoreInteractions(this.mapper);
    }

    private static Stream<HttpEx> clientErrors() {
        return Stream.of(
            HttpEx.badRequest().build(),
            HttpEx.unauthorized().build(),
            HttpEx.paymentRequired().build(),
            HttpEx.forbidden().build(),
            HttpEx.notFound().build(),
            HttpEx.methodNotAllowed().build(),
            HttpEx.notAcceptable().build(),
            HttpEx.proxyAuthenticationRequired().build(),
            HttpEx.requestTimeout().build(),
            HttpEx.conflict().build(),
            HttpEx.gone().build(),
            HttpEx.lengthRequired().build(),
            HttpEx.preconditionFailed().build(),
            HttpEx.payloadTooLarge().build(),
            HttpEx.uriTooLong().build(),
            HttpEx.unsupportedMediaType().build(),
            HttpEx.rangeNotSatisfiable().build(),
            HttpEx.expectationFailed().build(),
            HttpEx.teapot().build(),
            HttpEx.misdirectedRequest().build(),
            HttpEx.unprocessableEntity().build(),
            HttpEx.locked().build(),
            HttpEx.failedDependency().build(),
            HttpEx.tooEarly().build(),
            HttpEx.upgradeRequired().build(),
            HttpEx.preconditionRequired().build(),
            HttpEx.tooManyRequests().build(),
            HttpEx.requestHeaderFieldTooLarge().build(),
            HttpEx.unavailableForLegalReasons().build()
        );
    }

    private static Stream<HttpEx> serverErrors() {
        return Stream.of(
            HttpEx.internalServerError().build(),
            HttpEx.notImplemented().build(),
            HttpEx.badRequest().build(),
            HttpEx.serviceUnavailable().build(),
            HttpEx.gatewayTimeout().build(),
            HttpEx.httpVersionNotSupported().build(),
            HttpEx.variantAlsoNegotiates().build(),
            HttpEx.insufficientStorage().build(),
            HttpEx.loopDetected().build(),
            HttpEx.notExtended().build(),
            HttpEx.networkAuthenticationRequired().build()
        );
    }
}
