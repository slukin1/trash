package zendesk.support.suas;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import zendesk.support.suas.CombinedReducer;
import zendesk.support.suas.Listeners;

class SuasStore implements Store {
    /* access modifiers changed from: private */
    public final Set<Listener<Action<?>>> actionListener;
    private final Filter defaultFilter;
    private final Executor executor;
    /* access modifiers changed from: private */
    public final AtomicBoolean isReducing = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public final Map<Listener, Listeners.StateListener> listenerStateListenerMap;
    /* access modifiers changed from: private */
    public final CombinedMiddleware middleware;
    /* access modifiers changed from: private */
    public final CombinedReducer reducer;
    /* access modifiers changed from: private */
    public State state;

    public class ActionListenerSubscription implements Subscription {
        private final Listener<Action<?>> listener;

        public void addListener() {
            SuasStore.this.actionListener.add(this.listener);
        }

        public void informWithCurrentState() {
        }

        public void removeListener() {
            SuasStore.this.removeListener(this.listener);
        }

        private ActionListenerSubscription(Listener<Action<?>> listener2) {
            this.listener = listener2;
        }
    }

    public class DefaultSubscription implements Subscription {
        private final Listener listener;
        private final Listeners.StateListener stateListener;

        public DefaultSubscription(Listeners.StateListener stateListener2, Listener listener2) {
            this.stateListener = stateListener2;
            this.listener = listener2;
        }

        public void addListener() {
            SuasStore.this.listenerStateListenerMap.put(this.listener, this.stateListener);
        }

        public void informWithCurrentState() {
            this.stateListener.update((State) null, SuasStore.this.getState(), true);
        }

        public void removeListener() {
            SuasStore.this.removeListener(this.listener);
        }
    }

    public SuasStore(State state2, CombinedReducer combinedReducer, CombinedMiddleware combinedMiddleware, Filter<Object> filter, Executor executor2) {
        this.state = state2;
        this.reducer = combinedReducer;
        this.middleware = combinedMiddleware;
        this.defaultFilter = filter;
        this.executor = executor2;
        this.actionListener = Collections.synchronizedSet(new HashSet());
        this.listenerStateListenerMap = new ConcurrentHashMap();
    }

    /* access modifiers changed from: private */
    public void notifyActionListener(Action<?> action) {
        for (Listener<Action<?>> update : this.actionListener) {
            update.update(action);
        }
    }

    /* access modifiers changed from: private */
    public void notifyListener(State state2, State state3, Collection<String> collection) {
        for (Listeners.StateListener next : this.listenerStateListenerMap.values()) {
            if (next.getStateKey() == null || collection.contains(next.getStateKey())) {
                next.update(state2, state3, false);
            }
        }
    }

    private Subscription registerListener(Listener listener, Listeners.StateListener stateListener) {
        DefaultSubscription defaultSubscription = new DefaultSubscription(stateListener, listener);
        defaultSubscription.addListener();
        return defaultSubscription;
    }

    public Subscription addActionListener(Listener<Action<?>> listener) {
        ActionListenerSubscription actionListenerSubscription = new ActionListenerSubscription(listener);
        actionListenerSubscription.addListener();
        return actionListenerSubscription;
    }

    public <E> Subscription addListener(String str, Listener<E> listener) {
        return registerListener(listener, Listeners.create(str, this.defaultFilter, listener));
    }

    public synchronized void dispatch(final Action action) {
        this.executor.execute(new Runnable() {
            public void run() {
                SuasStore.this.notifyActionListener(action);
                CombinedMiddleware access$500 = SuasStore.this.middleware;
                Action action = action;
                SuasStore suasStore = SuasStore.this;
                access$500.onAction(action, suasStore, suasStore, new Continuation() {
                    public void next(Action<?> action) {
                        if (SuasStore.this.isReducing.compareAndSet(false, true)) {
                            State state = SuasStore.this.getState();
                            CombinedReducer.ReduceResult reduce = SuasStore.this.reducer.reduce(SuasStore.this.getState(), action);
                            State unused = SuasStore.this.state = reduce.getNewState();
                            SuasStore.this.isReducing.set(false);
                            SuasStore suasStore = SuasStore.this;
                            suasStore.notifyListener(state, suasStore.getState(), reduce.getUpdatedKeys());
                            return;
                        }
                        throw new RuntimeException("You must not dispatch actions in your reducer. Seriously. (╯°□°）╯︵ ┻━┻");
                    }
                });
            }
        });
    }

    public State getState() {
        return this.state.copy();
    }

    public void removeListener(Listener listener) {
        this.listenerStateListenerMap.remove(listener);
        this.actionListener.remove(listener);
    }

    public void reset(State state2) {
        State state3 = getState();
        State mergeStates = State.mergeStates(this.reducer.getEmptyState(), state2);
        this.state = mergeStates;
        notifyListener(state3, mergeStates, this.reducer.getAllKeys());
    }

    public <E> Subscription addListener(String str, Filter<E> filter, Listener<E> listener) {
        return registerListener(listener, Listeners.create(str, filter, listener));
    }

    public <E> Subscription addListener(StateSelector<E> stateSelector, Listener<E> listener) {
        return registerListener(listener, Listeners.create(stateSelector, (Filter<State>) this.defaultFilter, listener));
    }

    public <E> Subscription addListener(Filter<State> filter, StateSelector<E> stateSelector, Listener<E> listener) {
        return registerListener(listener, Listeners.create(stateSelector, filter, listener));
    }

    public <E> Subscription addListener(Class<E> cls, Listener<E> listener) {
        return registerListener(listener, Listeners.create(cls, this.defaultFilter, listener));
    }

    public <E> Subscription addListener(Class<E> cls, Filter<E> filter, Listener<E> listener) {
        return registerListener(listener, Listeners.create(cls, filter, listener));
    }

    public <E> Subscription addListener(String str, Class<E> cls, Listener<E> listener) {
        return registerListener(listener, Listeners.create(str, cls, this.defaultFilter, listener));
    }

    public <E> Subscription addListener(String str, Class<E> cls, Filter<E> filter, Listener<E> listener) {
        return registerListener(listener, Listeners.create(str, cls, filter, listener));
    }

    public Subscription addListener(Listener<State> listener) {
        return registerListener(listener, Listeners.create(this.defaultFilter, listener));
    }

    public Subscription addListener(Filter<State> filter, Listener<State> listener) {
        return registerListener(listener, Listeners.create(filter, listener));
    }
}
