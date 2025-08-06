package zendesk.support.suas;

import java.util.Arrays;
import java.util.Collection;

public class CombinedSubscription implements Subscription {
    private final Collection<Subscription> subscriptions;

    private CombinedSubscription(Collection<Subscription> collection) {
        this.subscriptions = collection;
    }

    public static Subscription from(Subscription... subscriptionArr) {
        return new CombinedSubscription(Arrays.asList(subscriptionArr));
    }

    public void addListener() {
        for (Subscription addListener : this.subscriptions) {
            addListener.addListener();
        }
    }

    public void informWithCurrentState() {
        for (Subscription informWithCurrentState : this.subscriptions) {
            informWithCurrentState.informWithCurrentState();
        }
    }

    public void removeListener() {
        for (Subscription removeListener : this.subscriptions) {
            removeListener.removeListener();
        }
    }

    public static Subscription from(Collection<Subscription> collection) {
        return new CombinedSubscription(collection);
    }
}
