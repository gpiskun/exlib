package su.piskun.exlib.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import su.piskun.exlib.core.Ex;
import su.piskun.exlib.core.HttpEx;

@ControllerAdvice
public class ExHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ExHandler.class);

    private final ExMapper mapper;

    public ExHandler(final ExMapper mapper) {
        this.mapper = mapper;
    }

    @ResponseBody
    @ExceptionHandler(Ex.class)
    public <E extends Ex> ResponseEntity<ExDto> handle(E e) {
        ExDto exDto = this.mapper.map(e);
        int status = e instanceof HttpEx http ? http.getStatusCode() : HttpEx.INTERNAL_SERVER_ERROR;

        log(e);

        return ResponseEntity.status(status).body(exDto);
    }

    private static void log(Ex e) {
        if (LOG.isTraceEnabled()) {
            e.printStackTrace();
        } else {
            LOG.error(e.toString());
        }
    }
}
