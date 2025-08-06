package zendesk.support.suas;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class State implements Serializable {
    private final Map<String, Object> state;

    public State(Map<String, Object> map) {
        this.state = new HashMap(map);
    }

    private Collection<String> getStateKeys() {
        return this.state.keySet();
    }

    public static String keyForClass(Class cls) {
        return cls.getSimpleName();
    }

    public static State mergeStates(State state2, State state3) {
        if (state3 == null) {
            return state2;
        }
        State copy = state3.copy();
        for (String next : state2.getStateKeys()) {
            if (copy.getState(next) == null) {
                copy.updateKey(next, state2.getState(next));
            }
        }
        return copy;
    }

    public State copy() {
        return new State(new HashMap(this.state));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.state.equals(((State) obj).state);
    }

    public Object getState(String str) {
        return this.state.get(str);
    }

    public int hashCode() {
        return this.state.hashCode();
    }

    public String toString() {
        return this.state.toString();
    }

    public void updateKey(String str, Object obj) {
        this.state.put(str, obj);
    }

    public <E> E getState(Class<E> cls) {
        E e11 = this.state.get(keyForClass(cls));
        if (cls.isInstance(e11)) {
            return e11;
        }
        return null;
    }

    public <E> void updateKey(Class<E> cls, E e11) {
        this.state.put(keyForClass(cls), e11);
    }

    public State() {
        this.state = new HashMap();
    }

    public <E> E getState(String str, Class<E> cls) {
        E e11 = this.state.get(str);
        if (cls.isInstance(e11)) {
            return e11;
        }
        return null;
    }

    public Map<String, Object> getState() {
        return this.state;
    }
}
