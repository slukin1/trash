package zendesk.support.suas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.Executor;

public class Suas {
    /* access modifiers changed from: private */
    public static boolean isAndroid = true;

    static {
        try {
            Class.forName("android.os.Build");
        } catch (Exception unused) {
        }
    }

    private Suas() {
    }

    public static Builder createStore(Collection<Reducer> collection) {
        if (collection != null && !collection.isEmpty()) {
            return new Builder(collection);
        }
        throw new IllegalArgumentException("Reducer must not be null or empty");
    }

    public static class Builder {
        private Executor executor;
        private Collection<Middleware> middleware = new ArrayList();
        private Filter<Object> notifier = Filters.DEFAULT;
        private final Collection<Reducer> reducers;
        private State state;

        public Builder(Collection<Reducer> collection) {
            this.reducers = collection;
        }

        private void assertArgumentsNotNull(Object obj, String str) {
            if (obj == null) {
                throw new IllegalArgumentException(str);
            }
        }

        private Executor getExecutor() {
            Executor executor2 = this.executor;
            if (executor2 != null) {
                return executor2;
            }
            if (Suas.isAndroid) {
                return Executors.getAndroidExecutor();
            }
            return Executors.getDefaultExecutor();
        }

        public Store build() {
            CombinedReducer combinedReducer = new CombinedReducer(this.reducers);
            CombinedMiddleware combinedMiddleware = new CombinedMiddleware(this.middleware);
            return new SuasStore(State.mergeStates(combinedReducer.getEmptyState(), this.state), combinedReducer, combinedMiddleware, this.notifier, getExecutor());
        }

        public Builder withDefaultFilter(Filter<Object> filter) {
            assertArgumentsNotNull(filter, "Notifier must not be null");
            this.notifier = filter;
            return this;
        }

        public Builder withExecutor(Executor executor2) {
            this.executor = executor2;
            return this;
        }

        public Builder withInitialState(State state2) {
            assertArgumentsNotNull(state2, "Initial state must not be null");
            this.state = state2;
            return this;
        }

        public Builder withMiddleware(Collection<Middleware> collection) {
            assertArgumentsNotNull(collection, "Middleware must not be null");
            this.middleware = collection;
            return this;
        }

        public Builder withMiddleware(Middleware... middlewareArr) {
            assertArgumentsNotNull(middlewareArr, "Middleware must not be null");
            this.middleware = Arrays.asList(middlewareArr);
            return this;
        }
    }

    public static Builder createStore(Reducer... reducerArr) {
        if (reducerArr != null && reducerArr.length != 0) {
            return new Builder(Arrays.asList(reducerArr));
        }
        throw new IllegalArgumentException("Reducer must not be null or empty");
    }
}
