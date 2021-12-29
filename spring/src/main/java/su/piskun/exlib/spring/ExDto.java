package su.piskun.exlib.spring;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.Instant;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@JsonDeserialize(builder = ExDto.Builder.class)
public class ExDto {

    @JsonProperty
    private final UUID id;

    @JsonProperty
    private final Instant timestamp;

    @JsonProperty
    private final String code;

    @JsonProperty
    private final Map<String, Object> context;

    @JsonProperty
    private final String message;

    public static Builder builder() {
        return new Builder();
    }

    public UUID getId() {
        return id;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public String getCode() {
        return code;
    }

    public Map<String, Object> getContext() {
        return context;
    }

    public String getMessage() {
        return message;
    }

    public ExDto(Builder builder) {
        this.id = builder.id;
        this.timestamp = builder.timestamp;
        this.code = builder.code;
        this.context = Optional.ofNullable(builder.context).map(Map::copyOf).orElse(null);
        this.message = builder.message;
    }

    public static final class Builder {
        @JsonProperty
        private UUID id;

        @JsonProperty
        private Instant timestamp;

        @JsonProperty
        private String code;

        @JsonProperty
        private Map<String, Object> context;

        @JsonProperty
        private String message;

        private Builder() {}

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder timestamp(Instant timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder context(Map<String, Object> context) {
            this.context = context;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public ExDto build() {
            return new ExDto(this);
        }
    }
}
