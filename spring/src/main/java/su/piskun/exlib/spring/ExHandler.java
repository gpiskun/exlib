package su.piskun.exlib.spring;

import com.fasterxml.jackson.core.JsonParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import su.piskun.exlib.core.HttpEx;

import javax.validation.ValidationException;
import java.util.Set;

@ControllerAdvice
public class ExHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ExHandler.class);

    private static final Set<Class<?>> BAD_REQUEST_EXCEPTIONS = Set.of(
        ValidationException.class,
        JsonParseException.class,
        HttpMessageNotReadableException.class,
        MethodArgumentNotValidException.class);

    private final ExMapper mapper;

    public ExHandler(final ExMapper mapper) {
        this.mapper = mapper;
    }

    @ResponseBody
    @ExceptionHandler
    public ResponseEntity<ExDto> handle(Exception e) {
        ExDto exDto = this.mapper.map(e);

        log(e);

        return ResponseEntity.status(getStatusCode(e)).body(exDto);
    }

    private int getStatusCode(Exception e) {
        if (e instanceof HttpEx ex) {
            return ex.getStatusCode();
        }
        if (BAD_REQUEST_EXCEPTIONS.contains(e.getClass())) {
            return HttpEx.BAD_REQUEST;
        }
        return HttpEx.INTERNAL_SERVER_ERROR;
    }

    private static void log(Exception e) {
        if (LOG.isTraceEnabled()) {
            e.printStackTrace();
        } else {
            LOG.error(e.toString());
        }
    }
}
