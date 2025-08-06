package zendesk.support.suas;

import java.util.logging.Level;
import java.util.logging.Logger;

class Listeners {
    private static final String KEY_NOT_FOUND = "Requested stateKey not found in store";
    /* access modifiers changed from: private */
    public static final Logger L = Logger.getLogger("Suas");
    private static final String WRONG_TYPE = "Either new value or old value cannot be converted to type expected type.";

    public static class ClassKeyedListener<E> implements StateListener {
        private final Class<E> clazz;
        private final Filter<E> filter;
        private final Listener<E> listener;

        public String getStateKey() {
            return State.keyForClass(this.clazz);
        }

        public void update(State state, State state2, boolean z11) {
            Object obj = null;
            Object state3 = state != null ? state.getState(this.clazz) : null;
            if (state2 != null) {
                obj = state2.getState(this.clazz);
            }
            Listeners.update(obj, state3, this.filter, this.listener, z11);
        }

        private ClassKeyedListener(Class<E> cls, Listener<E> listener2, Filter<E> filter2) {
            this.clazz = cls;
            this.listener = listener2;
            this.filter = filter2;
        }
    }

    public static class ClassStringKeyedListener<E> implements StateListener {
        private final Class<E> clazz;
        private final Filter<E> filter;
        private final Listener<E> listener;
        private final String stateKey;

        public String getStateKey() {
            return this.stateKey;
        }

        public void update(State state, State state2, boolean z11) {
            Object obj = null;
            Object state3 = state != null ? state.getState(this.stateKey, this.clazz) : null;
            if (state2 != null) {
                obj = state2.getState(this.stateKey, this.clazz);
            }
            Listeners.update(obj, state3, this.filter, this.listener, z11);
        }

        private ClassStringKeyedListener(String str, Class<E> cls, Listener<E> listener2, Filter<E> filter2) {
            this.clazz = cls;
            this.listener = listener2;
            this.stateKey = str;
            this.filter = filter2;
        }
    }

    public static class Default implements StateListener {
        private final Filter<State> filter;
        private final Listener<State> listener;

        public String getStateKey() {
            return null;
        }

        public void update(State state, State state2, boolean z11) {
            if ((z11 && state2 != null) || (state != null && state2 != null && this.filter.filter(state, state2))) {
                this.listener.update(state2);
            }
        }

        private Default(Listener<State> listener2, Filter<State> filter2) {
            this.listener = listener2;
            this.filter = filter2;
        }
    }

    public interface StateListener {
        String getStateKey();

        void update(State state, State state2, boolean z11);
    }

    public static class StateSelectorListener<E> implements StateListener {
        private final Filter<State> filter;
        private final Listener<E> listener;
        private final StateSelector<E> stateSelector;

        public String getStateKey() {
            return null;
        }

        public void update(State state, State state2, boolean z11) {
            E selectData;
            if (((z11 && state2 != null) || (state != null && state2 != null && this.filter.filter(state, state2))) && (selectData = this.stateSelector.selectData(state2)) != null) {
                this.listener.update(selectData);
            }
        }

        private StateSelectorListener(Listener<E> listener2, StateSelector<E> stateSelector2, Filter<State> filter2) {
            this.listener = listener2;
            this.stateSelector = stateSelector2;
            this.filter = filter2;
        }
    }

    public static class StringKeyedListener<E> implements StateListener {
        private final Filter<E> filter;
        private final Listener<E> listener;
        private final String stateKey;

        public String getStateKey() {
            return this.stateKey;
        }

        public void update(State state, State state2, boolean z11) {
            Object obj;
            Object obj2 = null;
            if (state != null) {
                try {
                    obj = state.getState(this.stateKey);
                } catch (ClassCastException unused) {
                    Listeners.L.log(Level.WARNING, Listeners.WRONG_TYPE);
                    return;
                }
            } else {
                obj = null;
            }
            if (state2 != null) {
                obj2 = state2.getState(this.stateKey);
            }
            Listeners.update(obj2, obj, this.filter, this.listener, z11);
        }

        private StringKeyedListener(String str, Listener<E> listener2, Filter<E> filter2) {
            this.stateKey = str;
            this.listener = listener2;
            this.filter = filter2;
        }
    }

    private Listeners() {
    }

    public static <E> StateListener create(String str, Filter<E> filter, Listener<E> listener) {
        return new StringKeyedListener(str, listener, filter);
    }

    /* access modifiers changed from: private */
    public static <E> void update(E e11, E e12, Filter<E> filter, Listener<E> listener, boolean z11) {
        if (e11 != null && z11) {
            listener.update(e11);
        } else if (e11 == null || e12 == null) {
            L.log(Level.WARNING, KEY_NOT_FOUND);
        } else if (filter.filter(e12, e11)) {
            listener.update(e11);
        }
    }

    public static <E> StateListener create(Class<E> cls, Filter<E> filter, Listener<E> listener) {
        return new ClassKeyedListener(cls, listener, filter);
    }

    public static <E> StateListener create(String str, Class<E> cls, Filter<E> filter, Listener<E> listener) {
        return new ClassStringKeyedListener(str, cls, listener, filter);
    }

    public static StateListener create(Filter<State> filter, Listener<State> listener) {
        return new Default(listener, filter);
    }

    public static <E> StateListener create(StateSelector<E> stateSelector, Filter<State> filter, Listener<E> listener) {
        return new StateSelectorListener(listener, stateSelector, filter);
    }
}
