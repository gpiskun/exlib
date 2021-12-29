package su.piskun.exlib.spring;

import org.springframework.stereotype.Component;
import su.piskun.exlib.core.Ex;

@Component
class ExMapper {

    ExDto map(Ex source) {
        return ExDto.builder()
            .id(source.getId())
            .timestamp(source.getTimestamp())
            .message(source.getMessage())
            .code(source.getCode())
            .context(source.getContext())
            .build();
    }
}
