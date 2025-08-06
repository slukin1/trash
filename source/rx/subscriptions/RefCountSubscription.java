package rx.subscriptions;

import e7.s;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.Subscription;

public final class RefCountSubscription implements Subscription {
    public static final State EMPTY_STATE = new State(false, 0);
    private final Subscription actual;
    public final AtomicReference<State> state = new AtomicReference<>(EMPTY_STATE);

    public static final class InnerSubscription extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 7005765588239987643L;
        public final RefCountSubscription parent;

        public InnerSubscription(RefCountSubscription refCountSubscription) {
            this.parent = refCountSubscription;
        }

        public boolean isUnsubscribed() {
            return get() != 0;
        }

        public void unsubscribe() {
            if (compareAndSet(0, 1)) {
                this.parent.unsubscribeAChild();
            }
        }
    }

    public static final class State {
        public final int children;
        public final boolean isUnsubscribed;

        public State(boolean z11, int i11) {
            this.isUnsubscribed = z11;
            this.children = i11;
        }

        public State addChild() {
            return new State(this.isUnsubscribed, this.children + 1);
        }

        public State removeChild() {
            return new State(this.isUnsubscribed, this.children - 1);
        }

        public State unsubscribe() {
            return new State(true, this.children);
        }
    }

    public RefCountSubscription(Subscription subscription) {
        if (subscription != null) {
            this.actual = subscription;
            return;
        }
        throw new IllegalArgumentException(s.f70071a);
    }

    private void unsubscribeActualIfApplicable(State state2) {
        if (state2.isUnsubscribed && state2.children == 0) {
            this.actual.unsubscribe();
        }
    }

    public Subscription get() {
        State state2;
        AtomicReference<State> atomicReference = this.state;
        do {
            state2 = atomicReference.get();
            if (state2.isUnsubscribed) {
                return Subscriptions.unsubscribed();
            }
        } while (!atomicReference.compareAndSet(state2, state2.addChild()));
        return new InnerSubscription(this);
    }

    public boolean isUnsubscribed() {
        return this.state.get().isUnsubscribed;
    }

    public void unsubscribe() {
        State state2;
        State unsubscribe;
        AtomicReference<State> atomicReference = this.state;
        do {
            state2 = atomicReference.get();
            if (!state2.isUnsubscribed) {
                unsubscribe = state2.unsubscribe();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(state2, unsubscribe));
        unsubscribeActualIfApplicable(unsubscribe);
    }

    public void unsubscribeAChild() {
        State state2;
        State removeChild;
        AtomicReference<State> atomicReference = this.state;
        do {
            state2 = atomicReference.get();
            removeChild = state2.removeChild();
        } while (!atomicReference.compareAndSet(state2, removeChild));
        unsubscribeActualIfApplicable(removeChild);
    }
}
