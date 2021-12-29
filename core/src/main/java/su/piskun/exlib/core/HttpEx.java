package su.piskun.exlib.core;

/**
 * Exceptions for the HTTP context. Useful when building REST APIs.
 */
public final class HttpEx extends Ex {

    // Client error responses.
    public static final int BAD_REQUEST = 400;
    public static final int UNAUTHORIZED = 401;
    public static final int PAYMENT_REQUIRED = 402;
    public static final int FORBIDDEN = 403;
    public static final int NOT_FOUND = 404;
    public static final int METHOD_NOT_ALLOWED = 405;
    public static final int NOT_ACCEPTABLE = 406;
    public static final int PROXY_AUTHENTICATION_REQUIRED = 407;
    public static final int REQUEST_TIMEOUT = 408;
    public static final int CONFLICT = 409;
    public static final int GONE = 410;
    public static final int LENGTH_REQUIRED = 411;
    public static final int PRECONDITION_FAILED = 412;
    public static final int PAYLOAD_TOO_LARGE = 413;
    public static final int URI_TOO_LONG = 414;
    public static final int UNSUPPORTED_MEDIA_TYPE = 415;
    public static final int RANGE_NOT_SATISFIABLE = 416;
    public static final int EXPECTATION_FAILED = 417;
    public static final int TEAPOT = 418;
    public static final int MISDIRECTED_REQUEST = 421;
    public static final int UNPROCESSABLE_ENTITY = 422;
    public static final int LOCKED = 423;
    public static final int FAILED_DEPENDENCY = 424;
    public static final int TOO_EARLY = 425;
    public static final int UPGRADE_REQUIRED = 426;
    public static final int PRECONDITION_REQUIRED = 428;
    public static final int TOO_MANY_REQUESTS = 429;
    public static final int REQUEST_HEADER_FIELDS_TOO_LARGE = 431;
    public static final int UNAVAILABLE_FOR_LEGAL_REASONS = 451;

    // Server error responses.
    public static final int INTERNAL_SERVER_ERROR = 500;
    public static final int NOT_IMPLEMENTED = 501;
    public static final int BAD_GATEWAY = 502;
    public static final int SERVICE_UNAVAILABLE = 503;
    public static final int GATEWAY_TIMEOUT = 504;
    public static final int HTTP_VERSION_NOT_SUPPORTED = 505;
    public static final int VARIANT_ALSO_NEGOTIATES = 506;
    public static final int INSUFFICIENT_STORAGE = 507;
    public static final int LOOP_DETECTED = 508;
    public static final int NOT_EXTENDED = 510;
    public static final int NETWORK_AUTHENTICATION_REQUIRED = 511;

    // Default error codes.
    public static final String CLIENT_ERROR = "CLIENT_ERROR";
    public static final String SERVER_ERROR = "SERVER_ERROR";

    private final int statusCode;

    private HttpEx(Builder builder) {
        super(builder);
        this.statusCode = builder.statusCode;
    }

    // Factory methods for the client errors.

    /**
     * Creates a {@link Builder} instance for the 400 HTTP status response code.
     * @return An instance of the {@link Builder} class.
     */
    public static Builder badRequest() {
        return new Builder().statusCode(BAD_REQUEST).code(CLIENT_ERROR);
    }

    /**
     * Creates a {@link Builder} instance for the 400 HTTP status response code.
     * @param message an error message
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx badRequest(String message) {
        return badRequest().message(message).build();
    }

    /**
     * Creates a {@link Builder} instance for the 400 HTTP status response code.
     * @param message a format error message
     * @param args formatting arguments
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx badRequest(String message, Object... args) {
        return badRequest().message(message, args).build();
    }

    /**
     * Creates a {@link Builder} instance for the 401 HTTP status response code.
     * @return An instance of the {@link Builder} class.
     */
    public static Builder unauthorized() {
        return new Builder().statusCode(UNAUTHORIZED).code(CLIENT_ERROR);
    }

    /**
     * Creates a {@link Builder} instance for the 401 HTTP status response code.
     * @param message an error message
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx unauthorized(String message) {
        return unauthorized().message(message).build();
    }

    /**
     * Creates a {@link Builder} instance for the 401 HTTP status response code.
     * @param message a format error message
     * @param args formatting arguments
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx unauthorized(String message, Object... args) {
        return unauthorized().message(message, args).build();
    }

    /**
     * Creates a {@link Builder} instance for the 402 HTTP status response code.
     * @return An instance of the {@link Builder} class.
     */
    public static Builder paymentRequired() {
        return new Builder().statusCode(PAYMENT_REQUIRED).code(CLIENT_ERROR);
    }

    /**
     * Creates a {@link Builder} instance for the 402 HTTP status response code.
     * @param message an error message
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx paymentRequired(String message) {
        return paymentRequired().message(message).build();
    }

    /**
     * Creates a {@link Builder} instance for the 402 HTTP status response code.
     * @param message a format error message
     * @param args formatting arguments
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx paymentRequired(String message, Object... args) {
        return paymentRequired().message(message, args).build();
    }

    /**
     * Creates a {@link Builder} instance for the 403 HTTP status response code.
     * @return An instance of the {@link Builder} class.
     */
    public static Builder forbidden() {
        return new Builder().statusCode(FORBIDDEN).code(CLIENT_ERROR);
    }

    /**
     * Creates a {@link Builder} instance for the 403 HTTP status response code.
     * @param message an error message
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx forbidden(String message) {
        return forbidden().message(message).build();
    }

    /**
     * Creates a {@link Builder} instance for the 403 HTTP status response code.
     * @param message a format error message
     * @param args formatting arguments
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx forbidden(String message, Object... args) {
        return forbidden().message(message, args).build();
    }

    /**
     * Creates a {@link Builder} instance for the 404 HTTP status response code.
     * @return An instance of the {@link Builder} class.
     */
    public static Builder notFound() {
        return new Builder().statusCode(NOT_FOUND).code(CLIENT_ERROR);
    }

    /**
     * Creates a {@link Builder} instance for the 404 HTTP status response code.
     * @param message an error message
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx notFound(String message) {
        return notFound().message(message).build();
    }

    /**
     * Creates a {@link Builder} instance for the 404 HTTP status response code.
     * @param message a format error message
     * @param args formatting arguments
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx notFound(String message, Object... args) {
        return notFound().message(message, args).build();
    }

    /**
     * Creates a {@link Builder} instance for the 405 HTTP status response code.
     * @return An instance of the {@link Builder} class.
     */
    public static Builder methodNotAllowed() {
        return new Builder().statusCode(METHOD_NOT_ALLOWED).code(CLIENT_ERROR);
    }

    /**
     * Creates a {@link Builder} instance for the 405 HTTP status response code.
     * @param message an error message
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx methodNotAllowed(String message) {
        return methodNotAllowed().message(message).build();
    }

    /**
     * Creates a {@link Builder} instance for the 405 HTTP status response code.
     * @param message a format error message
     * @param args formatting arguments
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx methodNotAllowed(String message, Object... args) {
        return methodNotAllowed().message(message, args).build();
    }

    /**
     * Creates a {@link Builder} instance for the 406 HTTP status response code.
     * @return An instance of the {@link Builder} class.
     */
    public static Builder notAcceptable() {
        return new Builder().statusCode(NOT_ACCEPTABLE).code(CLIENT_ERROR);
    }

    /**
     * Creates a {@link Builder} instance for the 406 HTTP status response code.
     * @param message an error message
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx notAcceptable(String message) {
        return notAcceptable().message(message).build();
    }

    /**
     * Creates a {@link Builder} instance for the 406 HTTP status response code.
     * @param message a format error message
     * @param args formatting arguments
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx notAcceptable(String message, Object... args) {
        return notAcceptable().message(message, args).build();
    }

    /**
     * Creates a {@link Builder} instance for the 407 HTTP status response code.
     * @return An instance of the {@link Builder} class.
     */
    public static Builder proxyAuthenticationRequired() {
        return new Builder().statusCode(PROXY_AUTHENTICATION_REQUIRED).code(CLIENT_ERROR);
    }

    /**
     * Creates a {@link Builder} instance for the 407 HTTP status response code.
     * @param message an error message
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx proxyAuthenticationRequired(String message) {
        return proxyAuthenticationRequired().message(message).build();
    }

    /**
     * Creates a {@link Builder} instance for the 407 HTTP status response code.
     * @param message a format error message
     * @param args formatting arguments
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx proxyAuthenticationRequired(String message, Object... args) {
        return proxyAuthenticationRequired().message(message, args).build();
    }

    /**
     * Creates a {@link Builder} instance for the 408 HTTP status response code.
     * @return An instance of the {@link Builder} class.
     */
    public static Builder requestTimeout() {
        return new Builder().statusCode(REQUEST_TIMEOUT).code(CLIENT_ERROR);
    }

    /**
     * Creates a {@link Builder} instance for the 408 HTTP status response code.
     * @param message an error message
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx requestTimeout(String message) {
        return requestTimeout().message(message).build();
    }

    /**
     * Creates a {@link Builder} instance for the 408 HTTP status response code.
     * @param message a format error message
     * @param args formatting arguments
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx requestTimeout(String message, Object... args) {
        return requestTimeout().message(message, args).build();
    }

    /**
     * Creates a {@link Builder} instance for the 409 HTTP status response code.
     * @return An instance of the {@link Builder} class.
     */
    public static Builder conflict() {
        return new Builder().statusCode(CONFLICT).code(CLIENT_ERROR);
    }

    /**
     * Creates a {@link Builder} instance for the 409 HTTP status response code.
     * @param message an error message
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx conflict(String message) {
        return conflict().message(message).build();
    }

    /**
     * Creates a {@link Builder} instance for the 409 HTTP status response code.
     * @param message a format error message
     * @param args formatting arguments
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx conflict(String message, Object... args) {
        return conflict().message(message, args).build();
    }

    /**
     * Creates a {@link Builder} instance for the 410 HTTP status response code.
     * @return An instance of the {@link Builder} class.
     */
    public static Builder gone() {
        return new Builder().statusCode(GONE).code(CLIENT_ERROR);
    }

    /**
     * Creates a {@link Builder} instance for the 410 HTTP status response code.
     * @param message an error message
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx gone(String message) {
        return gone().message(message).build();
    }

    /**
     * Creates a {@link Builder} instance for the 410 HTTP status response code.
     * @param message a format error message
     * @param args formatting arguments
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx gone(String message, Object... args) {
        return gone().message(message, args).build();
    }

    /**
     * Creates a {@link Builder} instance for the 411 HTTP status response code.
     * @return An instance of the {@link Builder} class.
     */
    public static Builder lengthRequired() {
        return new Builder().statusCode(LENGTH_REQUIRED).code(CLIENT_ERROR);
    }

    /**
     * Creates a {@link Builder} instance for the 411 HTTP status response code.
     * @param message an error message
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx lengthRequired(String message) {
        return lengthRequired().message(message).build();
    }

    /**
     * Creates a {@link Builder} instance for the 411 HTTP status response code.
     * @param message a format error message
     * @param args formatting arguments
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx lengthRequired(String message, Object... args) {
        return lengthRequired().message(message, args).build();
    }

    /**
     * Creates a {@link Builder} instance for the 412 HTTP status response code.
     * @return An instance of the {@link Builder} class.
     */
    public static Builder preconditionFailed() {
        return new Builder().statusCode(PRECONDITION_FAILED).code(CLIENT_ERROR);
    }

    /**
     * Creates a {@link Builder} instance for the 412 HTTP status response code.
     * @param message an error message
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx preconditionFailed(String message) {
        return preconditionFailed().message(message).build();
    }

    /**
     * Creates a {@link Builder} instance for the 412 HTTP status response code.
     * @param message a format error message
     * @param args formatting arguments
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx preconditionFailed(String message, Object... args) {
        return preconditionFailed().message(message, args).build();
    }

    /**
     * Creates a {@link Builder} instance for the 413 HTTP status response code.
     * @return An instance of the {@link Builder} class.
     */
    public static Builder payloadTooLarge() {
        return new Builder().statusCode(PAYLOAD_TOO_LARGE).code(CLIENT_ERROR);
    }

    /**
     * Creates a {@link Builder} instance for the 413 HTTP status response code.
     * @param message an error message
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx payloadTooLarge(String message) {
        return payloadTooLarge().message(message).build();
    }

    /**
     * Creates a {@link Builder} instance for the 413 HTTP status response code.
     * @param message a format error message
     * @param args formatting arguments
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx payloadTooLarge(String message, Object... args) {
        return payloadTooLarge().message(message, args).build();
    }

    /**
     * Creates a {@link Builder} instance for the 414 HTTP status response code.
     * @return An instance of the {@link Builder} class.
     */
    public static Builder uriTooLong() {
        return new Builder().statusCode(URI_TOO_LONG).code(CLIENT_ERROR);
    }

    /**
     * Creates a {@link Builder} instance for the 414 HTTP status response code.
     * @param message an error message
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx uriTooLong(String message) {
        return uriTooLong().message(message).build();
    }

    /**
     * Creates a {@link Builder} instance for the 414 HTTP status response code.
     * @param message a format error message
     * @param args formatting arguments
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx uriTooLong(String message, Object... args) {
        return uriTooLong().message(message, args).build();
    }

    /**
     * Creates a {@link Builder} instance for the 415 HTTP status response code.
     * @return An instance of the {@link Builder} class.
     */
    public static Builder unsupportedMediaType() {
        return new Builder().statusCode(UNSUPPORTED_MEDIA_TYPE).code(CLIENT_ERROR);
    }

    /**
     * Creates a {@link Builder} instance for the 415 HTTP status response code.
     * @param message an error message
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx unsupportedMediaType(String message) {
        return unsupportedMediaType().message(message).build();
    }

    /**
     * Creates a {@link Builder} instance for the 415 HTTP status response code.
     * @param message a format error message
     * @param args formatting arguments
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx unsupportedMediaType(String message, Object... args) {
        return unsupportedMediaType().message(message, args).build();
    }

    /**
     * Creates a {@link Builder} instance for the 416 HTTP status response code.
     * @return An instance of the {@link Builder} class.
     */
    public static Builder rangeNotSatisfiable() {
        return new Builder().statusCode(RANGE_NOT_SATISFIABLE).code(CLIENT_ERROR);
    }

    /**
     * Creates a {@link Builder} instance for the 416 HTTP status response code.
     * @param message an error message
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx rangeNotSatisfiable(String message) {
        return rangeNotSatisfiable().message(message).build();
    }

    /**
     * Creates a {@link Builder} instance for the 416 HTTP status response code.
     * @param message a format error message
     * @param args formatting arguments
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx rangeNotSatisfiable(String message, Object... args) {
        return rangeNotSatisfiable().message(message, args).build();
    }

    /**
     * Creates a {@link Builder} instance for the 417 HTTP status response code.
     * @return An instance of the {@link Builder} class.
     */
    public static Builder expectationFailed() {
        return new Builder().statusCode(EXPECTATION_FAILED).code(CLIENT_ERROR);
    }

    /**
     * Creates a {@link Builder} instance for the 417 HTTP status response code.
     * @param message an error message
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx expectationFailed(String message) {
        return expectationFailed().message(message).build();
    }

    /**
     * Creates a {@link Builder} instance for the 417 HTTP status response code.
     * @param message a format error message
     * @param args formatting arguments
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx expectationFailed(String message, Object... args) {
        return expectationFailed().message(message, args).build();
    }

    /**
     * Creates a {@link Builder} instance for the 418 HTTP status response code.
     * @return An instance of the {@link Builder} class.
     */
    public static Builder teapot() {
        return new Builder().statusCode(TEAPOT).code(CLIENT_ERROR);
    }

    /**
     * Creates a {@link Builder} instance for the 418 HTTP status response code.
     * @param message an error message
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx teapot(String message) {
        return teapot().message(message).build();
    }

    /**
     * Creates a {@link Builder} instance for the 418 HTTP status response code.
     * @param message a format error message
     * @param args formatting arguments
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx teapot(String message, Object... args) {
        return teapot().message(message, args).build();
    }

    /**
     * Creates a {@link Builder} instance for the 421 HTTP status response code.
     * @return An instance of the {@link Builder} class.
     */
    public static Builder misdirectedRequest() {
        return new Builder().statusCode(MISDIRECTED_REQUEST).code(CLIENT_ERROR);
    }

    /**
     * Creates a {@link Builder} instance for the 421 HTTP status response code.
     * @param message an error message
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx misdirectedRequest(String message) {
        return misdirectedRequest().message(message).build();
    }

    /**
     * Creates a {@link Builder} instance for the 421 HTTP status response code.
     * @param message a format error message
     * @param args formatting arguments
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx misdirectedRequest(String message, Object... args) {
        return misdirectedRequest().message(message, args).build();
    }

    /**
     * Creates a {@link Builder} instance for the 422 HTTP status response code.
     * @return An instance of the {@link Builder} class.
     */
    public static Builder unprocessableEntity() {
        return new Builder().statusCode(UNPROCESSABLE_ENTITY).code(CLIENT_ERROR);
    }

    /**
     * Creates a {@link Builder} instance for the 422 HTTP status response code.
     * @param message an error message
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx unprocessableEntity(String message) {
        return unprocessableEntity().message(message).build();
    }

    /**
     * Creates a {@link Builder} instance for the 422 HTTP status response code.
     * @param message a format error message
     * @param args formatting arguments
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx unprocessableEntity(String message, Object... args) {
        return unprocessableEntity().message(message, args).build();
    }

    /**
     * Creates a {@link Builder} instance for the 423 HTTP status response code.
     * @return An instance of the {@link Builder} class.
     */
    public static Builder locked() {
        return new Builder().statusCode(LOCKED).code(CLIENT_ERROR);
    }

    /**
     * Creates a {@link Builder} instance for the 423 HTTP status response code.
     * @param message an error message
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx locked(String message) {
        return locked().message(message).build();
    }

    /**
     * Creates a {@link Builder} instance for the 423 HTTP status response code.
     * @param message a format error message
     * @param args formatting arguments
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx locked(String message, Object... args) {
        return locked().message(message, args).build();
    }

    /**
     * Creates a {@link Builder} instance for the 424 HTTP status response code.
     * @return An instance of the {@link Builder} class.
     */
    public static Builder failedDependency() {
        return new Builder().statusCode(FAILED_DEPENDENCY).code(CLIENT_ERROR);
    }

    /**
     * Creates a {@link Builder} instance for the 424 HTTP status response code.
     * @param message an error message
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx failedDependency(String message) {
        return failedDependency().message(message).build();
    }

    /**
     * Creates a {@link Builder} instance for the 424 HTTP status response code.
     * @param message a format error message
     * @param args formatting arguments
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx failedDependency(String message, Object... args) {
        return failedDependency().message(message, args).build();
    }

    /**
     * Creates a {@link Builder} instance for the 425 HTTP status response code.
     * @return An instance of the {@link Builder} class.
     */
    public static Builder tooEarly() {
        return new Builder().statusCode(TOO_EARLY).code(CLIENT_ERROR);
    }

    /**
     * Creates a {@link Builder} instance for the 425 HTTP status response code.
     * @param message an error message
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx tooEarly(String message) {
        return tooEarly().message(message).build();
    }

    /**
     * Creates a {@link Builder} instance for the 425 HTTP status response code.
     * @param message a format error message
     * @param args formatting arguments
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx tooEarly(String message, Object... args) {
        return tooEarly().message(message, args).build();
    }

    /**
     * Creates a {@link Builder} instance for the 426 HTTP status response code.
     * @return An instance of the {@link Builder} class.
     */
    public static Builder upgradeRequired() {
        return new Builder().statusCode(UPGRADE_REQUIRED).code(CLIENT_ERROR);
    }

    /**
     * Creates a {@link Builder} instance for the 426 HTTP status response code.
     * @param message an error message
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx upgradeRequired(String message) {
        return upgradeRequired().message(message).build();
    }

    /**
     * Creates a {@link Builder} instance for the 426 HTTP status response code.
     * @param message a format error message
     * @param args formatting arguments
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx upgradeRequired(String message, Object... args) {
        return upgradeRequired().message(message, args).build();
    }

    /**
     * Creates a {@link Builder} instance for the 428 HTTP status response code.
     * @return An instance of the {@link Builder} class.
     */
    public static Builder preconditionRequired() {
        return new Builder().statusCode(PRECONDITION_REQUIRED).code(CLIENT_ERROR);
    }

    /**
     * Creates a {@link Builder} instance for the 428 HTTP status response code.
     * @param message an error message
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx preconditionRequired(String message) {
        return preconditionRequired().message(message).build();
    }

    /**
     * Creates a {@link Builder} instance for the 428 HTTP status response code.
     * @param message a format error message
     * @param args formatting arguments
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx preconditionRequired(String message, Object... args) {
        return preconditionRequired().message(message, args).build();
    }

    /**
     * Creates a {@link Builder} instance for the 429 HTTP status response code.
     * @return An instance of the {@link Builder} class.
     */
    public static Builder tooManyRequests() {
        return new Builder().statusCode(TOO_MANY_REQUESTS).code(CLIENT_ERROR);
    }

    /**
     * Creates a {@link Builder} instance for the 429 HTTP status response code.
     * @param message an error message
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx tooManyRequests(String message) {
        return tooManyRequests().message(message).build();
    }

    /**
     * Creates a {@link Builder} instance for the 429 HTTP status response code.
     * @param message a format error message
     * @param args formatting arguments
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx tooManyRequests(String message, Object... args) {
        return tooManyRequests().message(message, args).build();
    }

    /**
     * Creates a {@link Builder} instance for the 431 HTTP status response code.
     * @return An instance of the {@link Builder} class.
     */
    public static Builder requestHeaderFieldTooLarge() {
        return new Builder().statusCode(REQUEST_HEADER_FIELDS_TOO_LARGE).code(CLIENT_ERROR);
    }

    /**
     * Creates a {@link Builder} instance for the 431 HTTP status response code.
     * @param message an error message
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx requestHeaderFieldTooLarge(String message) {
        return requestHeaderFieldTooLarge().message(message).build();
    }

    /**
     * Creates a {@link Builder} instance for the 431 HTTP status response code.
     * @param message a format error message
     * @param args formatting arguments
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx requestHeaderFieldTooLarge(String message, Object... args) {
        return requestHeaderFieldTooLarge().message(message, args).build();
    }

    /**
     * Creates a {@link Builder} instance for the 451 HTTP status response code.
     * @return An instance of the {@link Builder} class.
     */
    public static Builder unavailableForLegalReasons() {
        return new Builder().statusCode(UNAVAILABLE_FOR_LEGAL_REASONS).code(CLIENT_ERROR);
    }

    /**
     * Creates a {@link Builder} instance for the 451 HTTP status response code.
     * @param message an error message
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx unavailableForLegalReasons(String message) {
        return unavailableForLegalReasons().message(message).build();
    }

    /**
     * Creates a {@link Builder} instance for the 451 HTTP status response code.
     * @param message a format error message
     * @param args formatting arguments
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx unavailableForLegalReasons(String message, Object... args) {
        return unavailableForLegalReasons().message(message, args).build();
    }

    // Factory methods for the server errors.

    /**
     * Creates a {@link Builder} instance for the 500 HTTP status response code.
     * @return An instance of the {@link Builder} class.
     */
    public static Builder internalServerError() {
        return new Builder().statusCode(INTERNAL_SERVER_ERROR).code(SERVER_ERROR);
    }

    /**
     * Creates a {@link Builder} instance for the 500 HTTP status response code.
     * @param message an error message
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx internalServerError(String message) {
        return internalServerError().message(message).build();
    }

    /**
     * Creates a {@link Builder} instance for the 500 HTTP status response code.
     * @param message a format error message
     * @param args formatting arguments
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx internalServerError(String message, Object... args) {
        return internalServerError().message(message, args).build();
    }

    /**
     * Creates a {@link Builder} instance for the 501 HTTP status response code.
     * @return An instance of the {@link Builder} class.
     */
    public static Builder notImplemented() {
        return new Builder().statusCode(NOT_IMPLEMENTED).code(SERVER_ERROR);
    }

    /**
     * Creates a {@link Builder} instance for the 501 HTTP status response code.
     * @param message an error message
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx notImplemented(String message) {
        return notImplemented().message(message).build();
    }

    /**
     * Creates a {@link Builder} instance for the 501 HTTP status response code.
     * @param message a format error message
     * @param args formatting arguments
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx notImplemented(String message, Object... args) {
        return notImplemented().message(message, args).build();
    }

    /**
     * Creates a {@link Builder} instance for the 502 HTTP status response code.
     * @return An instance of the {@link Builder} class.
     */
    public static Builder badGateway() {
        return new Builder().statusCode(BAD_GATEWAY).code(SERVER_ERROR);
    }

    /**
     * Creates a {@link Builder} instance for the 502 HTTP status response code.
     * @param message an error message
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx badGateway(String message) {
        return badGateway().message(message).build();
    }

    /**
     * Creates a {@link Builder} instance for the 502 HTTP status response code.
     * @param message a format error message
     * @param args formatting arguments
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx badGateway(String message, Object... args) {
        return badGateway().message(message, args).build();
    }

    /**
     * Creates a {@link Builder} instance for the 503 HTTP status response code.
     * @return An instance of the {@link Builder} class.
     */
    public static Builder serviceUnavailable() {
        return new Builder().statusCode(SERVICE_UNAVAILABLE).code(SERVER_ERROR);
    }

    /**
     * Creates a {@link Builder} instance for the 503 HTTP status response code.
     * @param message an error message
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx serviceUnavailable(String message) {
        return serviceUnavailable().message(message).build();
    }

    /**
     * Creates a {@link Builder} instance for the 503 HTTP status response code.
     * @param message a format error message
     * @param args formatting arguments
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx serviceUnavailable(String message, Object... args) {
        return serviceUnavailable().message(message, args).build();
    }

    /**
     * Creates a {@link Builder} instance for the 503 HTTP status response code.
     * @return An instance of the {@link Builder} class.
     */
    public static Builder gatewayTimeout() {
        return new Builder().statusCode(GATEWAY_TIMEOUT).code(SERVER_ERROR);
    }

    /**
     * Creates a {@link Builder} instance for the 503 HTTP status response code.
     * @param message an error message
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx gatewayTimeout(String message) {
        return gatewayTimeout().message(message).build();
    }

    /**
     * Creates a {@link Builder} instance for the 503 HTTP status response code.
     * @param message a format error message
     * @param args formatting arguments
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx gatewayTimeout(String message, Object... args) {
        return gatewayTimeout().message(message, args).build();
    }

    /**
     * Creates a {@link Builder} instance for the 505 HTTP status response code.
     * @return An instance of the {@link Builder} class.
     */
    public static Builder httpVersionNotSupported() {
        return new Builder().statusCode(HTTP_VERSION_NOT_SUPPORTED).code(SERVER_ERROR);
    }

    /**
     * Creates a {@link Builder} instance for the 505 HTTP status response code.
     * @param message an error message
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx httpVersionNotSupported(String message) {
        return httpVersionNotSupported().message(message).build();
    }

    /**
     * Creates a {@link Builder} instance for the 505 HTTP status response code.
     * @param message a format error message
     * @param args formatting arguments
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx httpVersionNotSupported(String message, Object...args) {
        return httpVersionNotSupported().message(message, args).build();
    }

    /**
     * Creates a {@link Builder} instance for the 506 HTTP status response code.
     * @return An instance of the {@link Builder} class.
     */
    public static Builder variantAlsoNegotiates() {
        return new Builder().statusCode(VARIANT_ALSO_NEGOTIATES).code(SERVER_ERROR);
    }

    /**
     * Creates a {@link Builder} instance for the 506 HTTP status response code.
     * @param message an error message
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx variantAlsoNegotiates(String message) {
        return variantAlsoNegotiates().message(message).build();
    }

    /**
     * Creates a {@link Builder} instance for the 506 HTTP status response code.
     * @param message a format error message
     * @param args formatting arguments
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx variantAlsoNegotiates(String message, Object... args) {
        return variantAlsoNegotiates().message(message, args).build();
    }

    /**
     * Creates a {@link Builder} instance for the 507 HTTP status response code.
     * @return An instance of the {@link Builder} class.
     */
    public static Builder insufficientStorage() {
        return new Builder().statusCode(INSUFFICIENT_STORAGE).code(SERVER_ERROR);
    }

    /**
     * Creates a {@link Builder} instance for the 507 HTTP status response code.
     * @param message an error message
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx insufficientStorage(String message) {
        return insufficientStorage().message(message).build();
    }

    /**
     * Creates a {@link Builder} instance for the 507 HTTP status response code.
     * @param message a format error message
     * @param args formatting arguments
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx insufficientStorage(String message, Object... args) {
        return insufficientStorage().message(message, args).build();
    }

    /**
     * Creates a {@link Builder} instance for the 508 HTTP status response code.
     * @return An instance of the {@link Builder} class.
     */
    public static Builder loopDetected() {
        return new Builder().statusCode(LOOP_DETECTED).code(SERVER_ERROR);
    }

    /**
     * Creates a {@link Builder} instance for the 508 HTTP status response code.
     * @param message an error message
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx loopDetected(String message) {
        return loopDetected().message(message).build();
    }

    /**
     * Creates a {@link Builder} instance for the 508 HTTP status response code.
     * @param message a format error message
     * @param args formatting arguments
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx loopDetected(String message, Object... args) {
        return loopDetected().message(message, args).build();
    }

    /**
     * Creates a {@link Builder} instance for the 510 HTTP status response code.
     * @return An instance of the {@link Builder} class.
     */
    public static Builder notExtended() {
        return new Builder().statusCode(NOT_EXTENDED).code(SERVER_ERROR);
    }

    /**
     * Creates a {@link Builder} instance for the 510 HTTP status response code.
     * @param message an error message
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx notExtended(String message) {
        return notExtended().message(message).build();
    }

    /**
     * Creates a {@link Builder} instance for the 510 HTTP status response code.
     * @param message a format error message
     * @param args formatting arguments
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx notExtended(String message, Object... args) {
        return notExtended().message(message, args).build();
    }

    /**
     * Creates a {@link Builder} instance for the 511 HTTP status response code.
     * @return An instance of the {@link Builder} class.
     */
    public static Builder networkAuthenticationRequired() {
        return new Builder().statusCode(NETWORK_AUTHENTICATION_REQUIRED).code(SERVER_ERROR);
    }

    /**
     * Creates a {@link Builder} instance for the 511 HTTP status response code.
     * @param message an error message
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx networkAuthenticationRequired(String message) {
        return networkAuthenticationRequired().message(message).build();
    }

    /**
     * Creates a {@link Builder} instance for the 511 HTTP status response code.
     * @param message a format error message
     * @param args formatting arguments
     * @return An instance of the {@link HttpEx} class.
     */
    public static HttpEx networkAuthenticationRequired(String message, Object... args) {
        return networkAuthenticationRequired().message(message, args).build();
    }

    /**
     * Returns an HTTP status code.
     * @return HTTP status code (e.g. 400).
     */
    public int getStatusCode() {
        return statusCode;
    }

    public static final class Builder extends Ex.Builder<Builder> {
        private int statusCode;

        private Builder statusCode(int statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        public HttpEx build() {
            return new HttpEx(this);
        }
    }

    @Override
    public String toString() {
        return "HttpException{" +
            "statusCode=" + statusCode +
            "} " + super.toString();
    }
}
