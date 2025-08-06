package zendesk.support.suas;

public interface Middleware {
    void onAction(Action<?> action, GetState getState, Dispatcher dispatcher, Continuation continuation);
}
