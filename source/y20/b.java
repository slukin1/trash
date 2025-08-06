package y20;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.junit.validator.AnnotationValidator;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface b {
    Class<? extends AnnotationValidator> value();
}
