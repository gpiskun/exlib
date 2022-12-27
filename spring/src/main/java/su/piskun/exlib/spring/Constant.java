package su.piskun.exlib.spring;

import com.fasterxml.jackson.core.JsonParseException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.ValidationException;
import java.util.Set;

public final class Constant {

    public static final Set<Class<?>> BAD_REQUEST_EXCEPTIONS = Set.of(
        ValidationException.class,
        JsonParseException.class,
        HttpMessageNotReadableException.class,
        MethodArgumentNotValidException.class);

    private Constant() {}
}
