package su.piskun.exlib.core;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Instant;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class HttpExTest {

    private static final String MESSAGE = "error";
    private static final String MESSAGE_FORMATTED = "This is an %s.";
    private static final String ERROR = "error";

    private static final Map<String, Object> CONTEXT = Map.of("key", "value");
    private static final Exception CAUSE = new RuntimeException();

    @ParameterizedTest
    @MethodSource("source")
    void testCreation(HttpEx exception, String code, int httpStatus) {
        assertThat(exception.getId()).isNotNull();
        assertThat(exception.getTimestamp()).isBeforeOrEqualTo(Instant.now());
        assertThat(exception.getMessage()).isEqualTo(MESSAGE);
        assertThat(exception.getStatusCode()).isEqualTo(httpStatus);
        assertThat(exception.getCode()).isEqualTo(code);
        assertThat(exception.getContext()).isEqualTo(CONTEXT);
        assertThat(exception.getCause()).isEqualTo(CAUSE);
    }

    @ParameterizedTest
    @MethodSource("sourceMessageFormatted")
    void testCreationFormattedMessage(HttpEx exception, String code, int httpStatus) {
        assertThat(exception.getId()).isNotNull();
        assertThat(exception.getTimestamp()).isBeforeOrEqualTo(Instant.now());
        assertThat(exception.getMessage()).isEqualTo("This is an error.");
        assertThat(exception.getStatusCode()).isEqualTo(httpStatus);
        assertThat(exception.getCode()).isEqualTo(code);
        assertThat(exception.getContext()).isNull();
        assertThat(exception.getCause()).isNull();
    }

    private static Stream<Arguments> source() {
        return Stream.of(
            arguments(
                of(HttpEx::badRequest),
                HttpEx.CLIENT_ERROR,
                HttpEx.BAD_REQUEST),
            arguments(
                of(HttpEx::unauthorized),
                HttpEx.CLIENT_ERROR,
                HttpEx.UNAUTHORIZED),
            arguments(
                of(HttpEx::paymentRequired),
                HttpEx.CLIENT_ERROR,
                HttpEx.PAYMENT_REQUIRED),
            arguments(
                of(HttpEx::forbidden),
                HttpEx.CLIENT_ERROR,
                HttpEx.FORBIDDEN),
            arguments(
                of(HttpEx::notFound),
                HttpEx.CLIENT_ERROR,
                HttpEx.NOT_FOUND),
            arguments(
                of(HttpEx::methodNotAllowed),
                HttpEx.CLIENT_ERROR,
                HttpEx.METHOD_NOT_ALLOWED),
            arguments(
                of(HttpEx::notAcceptable),
                HttpEx.CLIENT_ERROR,
                HttpEx.NOT_ACCEPTABLE),
            arguments(
                of(HttpEx::proxyAuthenticationRequired),
                HttpEx.CLIENT_ERROR,
                HttpEx.PROXY_AUTHENTICATION_REQUIRED),
            arguments(
                of(HttpEx::requestTimeout),
                HttpEx.CLIENT_ERROR,
                HttpEx.REQUEST_TIMEOUT),
            arguments(
                of(HttpEx::conflict),
                HttpEx.CLIENT_ERROR,
                HttpEx.CONFLICT),
            arguments(
                of(HttpEx::gone),
                HttpEx.CLIENT_ERROR,
                HttpEx.GONE),
            arguments(
                of(HttpEx::lengthRequired),
                HttpEx.CLIENT_ERROR,
                HttpEx.LENGTH_REQUIRED),
            arguments(
                of(HttpEx::preconditionFailed),
                HttpEx.CLIENT_ERROR,
                HttpEx.PRECONDITION_FAILED),
            arguments(
                of(HttpEx::payloadTooLarge),
                HttpEx.CLIENT_ERROR,
                HttpEx.PAYLOAD_TOO_LARGE),
            arguments(
                of(HttpEx::uriTooLong),
                HttpEx.CLIENT_ERROR,
                HttpEx.URI_TOO_LONG),
            arguments(
                of(HttpEx::unsupportedMediaType),
                HttpEx.CLIENT_ERROR,
                HttpEx.UNSUPPORTED_MEDIA_TYPE),
            arguments(
                of(HttpEx::rangeNotSatisfiable),
                HttpEx.CLIENT_ERROR,
                HttpEx.RANGE_NOT_SATISFIABLE),
            arguments(
                of(HttpEx::expectationFailed),
                HttpEx.CLIENT_ERROR,
                HttpEx.EXPECTATION_FAILED),
            arguments(
                of(HttpEx::teapot),
                HttpEx.CLIENT_ERROR,
                HttpEx.TEAPOT),
            arguments(
                of(HttpEx::misdirectedRequest),
                HttpEx.CLIENT_ERROR,
                HttpEx.MISDIRECTED_REQUEST),
            arguments(
                of(HttpEx::locked),
                HttpEx.CLIENT_ERROR,
                HttpEx.LOCKED),
            arguments(
                of(HttpEx::failedDependency),
                HttpEx.CLIENT_ERROR,
                HttpEx.FAILED_DEPENDENCY),
            arguments(
                of(HttpEx::tooEarly),
                HttpEx.CLIENT_ERROR,
                HttpEx.TOO_EARLY),
            arguments(
                of(HttpEx::upgradeRequired),
                HttpEx.CLIENT_ERROR,
                HttpEx.UPGRADE_REQUIRED),
            arguments(
                of(HttpEx::preconditionRequired),
                HttpEx.CLIENT_ERROR,
                HttpEx.PRECONDITION_REQUIRED),
            arguments(
                of(HttpEx::tooManyRequests),
                HttpEx.CLIENT_ERROR,
                HttpEx.TOO_MANY_REQUESTS),
            arguments(
                of(HttpEx::requestHeaderFieldTooLarge),
                HttpEx.CLIENT_ERROR,
                HttpEx.REQUEST_HEADER_FIELDS_TOO_LARGE),
            arguments(
                of(HttpEx::unavailableForLegalReasons),
                HttpEx.CLIENT_ERROR,
                HttpEx.UNAVAILABLE_FOR_LEGAL_REASONS),
            arguments(
                of(HttpEx::internalServerError),
                HttpEx.SERVER_ERROR,
                HttpEx.INTERNAL_SERVER_ERROR),
            arguments(
                of(HttpEx::notImplemented),
                HttpEx.SERVER_ERROR,
                HttpEx.NOT_IMPLEMENTED),
            arguments(
                of(HttpEx::badGateway),
                HttpEx.SERVER_ERROR,
                HttpEx.BAD_GATEWAY),
            arguments(
                of(HttpEx::serviceUnavailable),
                HttpEx.SERVER_ERROR,
                HttpEx.SERVICE_UNAVAILABLE),
            arguments(
                of(HttpEx::gatewayTimeout),
                HttpEx.SERVER_ERROR,
                HttpEx.GATEWAY_TIMEOUT),
            arguments(
                of(HttpEx::httpVersionNotSupported),
                HttpEx.SERVER_ERROR,
                HttpEx.HTTP_VERSION_NOT_SUPPORTED),
            arguments(
                of(HttpEx::variantAlsoNegotiates),
                HttpEx.SERVER_ERROR,
                HttpEx.VARIANT_ALSO_NEGOTIATES),
            arguments(
                of(HttpEx::insufficientStorage),
                HttpEx.SERVER_ERROR,
                HttpEx.INSUFFICIENT_STORAGE),
            arguments(
                of(HttpEx::loopDetected),
                HttpEx.SERVER_ERROR,
                HttpEx.LOOP_DETECTED),
            arguments(
                of(HttpEx::notExtended),
                HttpEx.SERVER_ERROR,
                HttpEx.NOT_EXTENDED),
            arguments(
                of(HttpEx::networkAuthenticationRequired),
                HttpEx.SERVER_ERROR,
                HttpEx.NETWORK_AUTHENTICATION_REQUIRED)
        );
    }

    private static Stream<Arguments> sourceMessageFormatted() {
        return Stream.of(
            arguments(
                formatted(HttpEx::badRequest),
                HttpEx.CLIENT_ERROR,
                HttpEx.BAD_REQUEST),
            arguments(
                formatted(HttpEx::unauthorized),
                HttpEx.CLIENT_ERROR,
                HttpEx.UNAUTHORIZED),
            arguments(
                formatted(HttpEx::paymentRequired),
                HttpEx.CLIENT_ERROR,
                HttpEx.PAYMENT_REQUIRED),
            arguments(
                formatted(HttpEx::forbidden),
                HttpEx.CLIENT_ERROR,
                HttpEx.FORBIDDEN),
            arguments(
                formatted(HttpEx::notFound),
                HttpEx.CLIENT_ERROR,
                HttpEx.NOT_FOUND),
            arguments(
                formatted(HttpEx::methodNotAllowed),
                HttpEx.CLIENT_ERROR,
                HttpEx.METHOD_NOT_ALLOWED),
            arguments(
                formatted(HttpEx::notAcceptable),
                HttpEx.CLIENT_ERROR,
                HttpEx.NOT_ACCEPTABLE),
            arguments(
                formatted(HttpEx::proxyAuthenticationRequired),
                HttpEx.CLIENT_ERROR,
                HttpEx.PROXY_AUTHENTICATION_REQUIRED),
            arguments(
                formatted(HttpEx::requestTimeout),
                HttpEx.CLIENT_ERROR,
                HttpEx.REQUEST_TIMEOUT),
            arguments(
                formatted(HttpEx::conflict),
                HttpEx.CLIENT_ERROR,
                HttpEx.CONFLICT),
            arguments(
                formatted(HttpEx::gone),
                HttpEx.CLIENT_ERROR,
                HttpEx.GONE),
            arguments(
                formatted(HttpEx::lengthRequired),
                HttpEx.CLIENT_ERROR,
                HttpEx.LENGTH_REQUIRED),
            arguments(
                formatted(HttpEx::preconditionFailed),
                HttpEx.CLIENT_ERROR,
                HttpEx.PRECONDITION_FAILED),
            arguments(
                formatted(HttpEx::payloadTooLarge),
                HttpEx.CLIENT_ERROR,
                HttpEx.PAYLOAD_TOO_LARGE),
            arguments(
                formatted(HttpEx::uriTooLong),
                HttpEx.CLIENT_ERROR,
                HttpEx.URI_TOO_LONG),
            arguments(
                formatted(HttpEx::unsupportedMediaType),
                HttpEx.CLIENT_ERROR,
                HttpEx.UNSUPPORTED_MEDIA_TYPE),
            arguments(
                formatted(HttpEx::rangeNotSatisfiable),
                HttpEx.CLIENT_ERROR,
                HttpEx.RANGE_NOT_SATISFIABLE),
            arguments(
                formatted(HttpEx::expectationFailed),
                HttpEx.CLIENT_ERROR,
                HttpEx.EXPECTATION_FAILED),
            arguments(
                formatted(HttpEx::teapot),
                HttpEx.CLIENT_ERROR,
                HttpEx.TEAPOT),
            arguments(
                formatted(HttpEx::misdirectedRequest),
                HttpEx.CLIENT_ERROR,
                HttpEx.MISDIRECTED_REQUEST),
            arguments(
                formatted(HttpEx::unprocessableEntity),
                HttpEx.CLIENT_ERROR,
                HttpEx.UNPROCESSABLE_ENTITY
            ),
            arguments(
                formatted(HttpEx::locked),
                HttpEx.CLIENT_ERROR,
                HttpEx.LOCKED),
            arguments(
                formatted(HttpEx::failedDependency),
                HttpEx.CLIENT_ERROR,
                HttpEx.FAILED_DEPENDENCY),
            arguments(
                formatted(HttpEx::tooEarly),
                HttpEx.CLIENT_ERROR,
                HttpEx.TOO_EARLY),
            arguments(
                formatted(HttpEx::upgradeRequired),
                HttpEx.CLIENT_ERROR,
                HttpEx.UPGRADE_REQUIRED),
            arguments(
                formatted(HttpEx::preconditionRequired),
                HttpEx.CLIENT_ERROR,
                HttpEx.PRECONDITION_REQUIRED),
            arguments(
                formatted(HttpEx::tooManyRequests),
                HttpEx.CLIENT_ERROR,
                HttpEx.TOO_MANY_REQUESTS),
            arguments(
                formatted(HttpEx::requestHeaderFieldTooLarge),
                HttpEx.CLIENT_ERROR,
                HttpEx.REQUEST_HEADER_FIELDS_TOO_LARGE),
            arguments(
                formatted(HttpEx::unavailableForLegalReasons),
                HttpEx.CLIENT_ERROR,
                HttpEx.UNAVAILABLE_FOR_LEGAL_REASONS),
            arguments(
                formatted(HttpEx::internalServerError),
                HttpEx.SERVER_ERROR,
                HttpEx.INTERNAL_SERVER_ERROR),
            arguments(
                formatted(HttpEx::notImplemented),
                HttpEx.SERVER_ERROR,
                HttpEx.NOT_IMPLEMENTED),
            arguments(
                formatted(HttpEx::badGateway),
                HttpEx.SERVER_ERROR,
                HttpEx.BAD_GATEWAY),
            arguments(
                formatted(HttpEx::serviceUnavailable),
                HttpEx.SERVER_ERROR,
                HttpEx.SERVICE_UNAVAILABLE),
            arguments(
                formatted(HttpEx::gatewayTimeout),
                HttpEx.SERVER_ERROR,
                HttpEx.GATEWAY_TIMEOUT),
            arguments(
                formatted(HttpEx::httpVersionNotSupported),
                HttpEx.SERVER_ERROR,
                HttpEx.HTTP_VERSION_NOT_SUPPORTED),
            arguments(
                formatted(HttpEx::variantAlsoNegotiates),
                HttpEx.SERVER_ERROR,
                HttpEx.VARIANT_ALSO_NEGOTIATES),
            arguments(
                formatted(HttpEx::insufficientStorage),
                HttpEx.SERVER_ERROR,
                HttpEx.INSUFFICIENT_STORAGE),
            arguments(
                formatted(HttpEx::loopDetected),
                HttpEx.SERVER_ERROR,
                HttpEx.LOOP_DETECTED),
            arguments(
                formatted(HttpEx::notExtended),
                HttpEx.SERVER_ERROR,
                HttpEx.NOT_EXTENDED),
            arguments(
                formatted(HttpEx::networkAuthenticationRequired),
                HttpEx.SERVER_ERROR,
                HttpEx.NETWORK_AUTHENTICATION_REQUIRED)
        );
    }

    private static HttpEx of(Supplier<HttpEx.Builder> supplier) {
        return supplier.get()
            .message(MESSAGE)
            .context(CONTEXT)
            .cause(CAUSE)
            .build();
    }

    private static HttpEx formatted(BiFunction<String, Object[], HttpEx> function) {
        return function.apply(MESSAGE_FORMATTED, new String[] {ERROR});
    }
}