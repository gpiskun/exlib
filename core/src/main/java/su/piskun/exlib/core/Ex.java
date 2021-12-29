package su.piskun.exlib.core;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * The basic exception class that can be used in any context.
 */
public class Ex extends RuntimeException {

    public static final String DEFAULT_CODE = "ERROR";

    private final UUID id;
    private final Instant timestamp;
    private final String code;
    private final Map<String, Object> context;

    protected <T extends Builder<T>> Ex(final Builder<T> builder) {
        super(builder.message, builder.cause);

        this.id = UUID.randomUUID();
        this.timestamp = Instant.now();
        this.code = Optional.ofNullable(builder.code).orElse(DEFAULT_CODE);
        this.context = Optional.ofNullable(builder.context).map(HashMap::new).orElse(null);
    }

    /**
     * Factory method to instantiate the class {@link Builder}.
     * @return an instance of {@link Builder}
     * @param <T> Generic parameter that is used for the builder inheritance.
     */
    public static <T extends Builder<T>> Builder<T> builder() {
        return new Builder<>();
    }

    /**
     * Factory method to quickly instantiate an exception for a given message.
     * @param message An error message.
     * @return An instance of {@link Ex} class.
     */
    public static Ex as(String message) {
        return Ex.builder()
            .message(message)
            .build();
    }

    /**
     * Factory method to quickly instantiate an exception for a given <i>formatted</i> message.
     * @param message A formatted error message.
     * @param args A list of arguments to be used when formatting an error message.
     * @return An instance of {@link Ex} class.
     */
    public static Ex as(String message, Object... args) {
        return Ex.builder()
            .message(message, args)
            .build();
    }

    /**
     * Returns an <i>automatically generated</i> {@link UUID} identifier.
     * @return Exception's unique ID.
     */
    public UUID getId() {
        return id;
    }

    /**
     * Returns an <i>automatically generated</i> creation timestamp.
     * @return Creation timestamp as {@link Instant}
     */
    public Instant getTimestamp() {
        return timestamp;
    }

    /**
     * Immutable, machine-readable error code.
     * <p>
     *     It can be used to group multiple exception under the same error code.
     *     For example, the code <b>VALIDATION_ERROR</b> can be used for multiple validation errors
     *     (e.g. email is invalid, request does not provide a required phone number, etc.)
     *     Clients can rely on this immutable code to recover from the error.
     *     Clients should never rely on the {@link #getMessage()} value since it's mutable and can change frequently.
     *     Normally, all possible values of the {@link #code} field should be part of the API specification.
     * </p>
     * @return an immutable, machine-readable error code.
     */
    public String getCode() {
        return code;
    }

    /**
     * The exception's context.
     * <p>
     *     Contains the information that could be used for troubleshooting purposes.
     *     Also, it can be part of the API contract, so that a client can rely on the context to recover from an error.
     * </p>
     * @return Exception context {@link Map}
     */
    public Map<String, Object> getContext() {
        return context;
    }

    /**
     * Implementation of the builder pattern that provides flexible exception creation API.
     * @param <T> Generic type to support subclasses that is also based on the Builder pattern.
     */
    public static class Builder<T extends Builder<T>> {
        private String code;
        private String message;
        private Throwable cause;
        private Map<String, Object> context;

        protected Builder() { }

        /**
         * Accepts the exception code.
         * @param code an exception error code.
         * @return this builder instance.
         */
        public T code(final String code) {
            this.code = code;
            return (T) this;
        }

        /**
         * Accepts the exception message.
         * @param message an exception error message.
         * @return this builder instance.
         */
        public T message(final String message) {
            this.message = message;
            return (T) this;
        }

        /**
         * Accepts a format message string with an array of arguments.
         * The formatting is performed by the {@link String#format(String, Object...)} method.
         * @param message a format message string.
         * @param args an array of arguments to replace the placeholders in the format message string.
         * @return this builder instance.
         */
        public T message(final String message, final Object... args) {
            this.message = args != null ? String.format(message, args) : message;
            return (T) this;
        }

        /**
         * Accepts the cause of this exception. It could be a root cause sometimes.
         * <p>
         *     <b>Note:</b> it's useful only in the {@code catch} blocks when you catch checked exceptions (e.g. {@link java.io.IOException}).
         * </p>
         * @param cause an exception that caused the current one.
         * @return this builder instance.
         */
        public T cause(final Throwable cause) {
            this.cause = cause;
            return (T) this;
        }

        /**
         * Accepts an exception's context.
         * @param context a standard {@link Map} that should contain anything that's required to debug/recover from exceptions.
         * @return this builder instance.
         */
        public T context(final Map<String, Object> context) {
            this.context = context;
            return (T) this;
        }

        /**
         * Accepts a key-value pair to be included into the exception's context.
         * New context will be created if it does not exist yet.
         * @param key {@link String} key.
         * @param value {@link Object} value.
         * @return this builder instance.
         */
        public T context(final String key, final Object value) {
            if (this.context == null) {
                this.context = new HashMap<>();
            }
            this.context.put(key, value);

            return (T) this;
        }

        /**
         * Build a new instance of the {@link Ex} class.
         * @return an instance of {@link Ex}.
         */
        public Ex build() {
            return new Ex(this);
        }
    }

    @Override
    public String toString() {
        return "BaseException{" +
            "id=" + id +
            ", timestamp=" + timestamp +
            ", code='" + code + '\'' +
            ", context=" + context +
            "} " + super.toString();
    }
}
