package zendesk.support.suas;

public interface Continuation {
    void next(Action<?> action);
}
