package su.piskun.exlib.spring;

import org.springframework.stereotype.Component;
import su.piskun.exlib.core.Ex;
import su.piskun.exlib.core.HttpEx;

import java.time.Instant;
import java.util.UUID;

import static su.piskun.exlib.spring.Constant.BAD_REQUEST_EXCEPTIONS;

@Component
class ExMapper {

    ExDto map(Exception source) {
        return source instanceof Ex ex ? map(ex) : mapDefault(source);
    }

    ExDto map(Ex source) {
        return ExDto.builder()
            .id(source.getId())
            .timestamp(source.getTimestamp())
            .message(source.getMessage())
            .code(source.getCode())
            .context(source.getContext())
            .build();
    }

    ExDto mapDefault(Exception source) {
        return ExDto.builder()
            .id(UUID.randomUUID())
            .timestamp(Instant.now())
            .message(source.getMessage())
            .code(mapCode(source))
            .build();
    }

    private String mapCode(Exception e) {
        if (BAD_REQUEST_EXCEPTIONS.contains(e.getClass())) {
            return HttpEx.CLIENT_ERROR;
        }

        return HttpEx.SERVER_ERROR;
    }
}
