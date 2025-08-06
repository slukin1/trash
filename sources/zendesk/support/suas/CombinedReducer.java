package zendesk.support.suas;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

class CombinedReducer {
    private final Collection<String> keys;
    private final Collection<Reducer> reducers;

    public static class ReduceResult {
        private final State newState;
        private final Collection<String> updatedKeys;

        public ReduceResult(Collection<String> collection, State state) {
            this.updatedKeys = collection;
            this.newState = state;
        }

        public State getNewState() {
            return this.newState;
        }

        public Collection<String> getUpdatedKeys() {
            return this.updatedKeys;
        }
    }

    public CombinedReducer(Collection<Reducer> collection) {
        assertReducers(collection);
        this.reducers = collection;
        this.keys = getKeys(collection);
    }

    private void assertReducers(Collection<Reducer> collection) {
        if (collection == null || collection.size() == 0) {
            throw new IllegalArgumentException("No reducers provided");
        }
        HashSet hashSet = new HashSet();
        for (Reducer stateKey : collection) {
            hashSet.add(stateKey.getStateKey());
        }
        if (hashSet.size() != collection.size()) {
            throw new IllegalArgumentException("Two or more reducers are tied to the same key");
        }
    }

    private Collection<String> getKeys(Collection<Reducer> collection) {
        HashSet hashSet = new HashSet();
        for (Reducer stateKey : collection) {
            hashSet.add(stateKey.getStateKey());
        }
        return hashSet;
    }

    public Collection<String> getAllKeys() {
        return this.keys;
    }

    public State getEmptyState() {
        HashMap hashMap = new HashMap(this.reducers.size());
        for (Reducer next : this.reducers) {
            hashMap.put(next.getStateKey(), next.getInitialState());
        }
        return new State(hashMap);
    }

    public ReduceResult reduce(State state, Action<?> action) {
        State state2 = new State();
        HashSet hashSet = new HashSet();
        for (Reducer next : this.reducers) {
            Object state3 = state.getState(next.getStateKey());
            Object reduce = next.reduce(state3, action);
            if (reduce != null) {
                state2.updateKey(next.getStateKey(), (Object) reduce);
                if (reduce != state3) {
                    hashSet.add(next.getStateKey());
                }
            } else {
                state2.updateKey(next.getStateKey(), (Object) state3);
            }
        }
        return new ReduceResult(hashSet, state2);
    }
}
