package ia;

import java.lang.reflect.InvocationTargetException;

public interface b<T> {
    T make() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException;
}
