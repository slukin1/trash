package zendesk.support.suas;

public interface Subscription {
    void addListener();

    void informWithCurrentState();

    void removeListener();
}
