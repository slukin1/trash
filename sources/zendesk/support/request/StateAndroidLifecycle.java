package zendesk.support.request;

import java.io.Serializable;
import zendesk.support.suas.State;

class StateAndroidLifecycle implements Serializable {
    public static final int STARTED = 1;
    public static final int STOPPED = 2;
    private final int state;

    public StateAndroidLifecycle() {
        this.state = 1;
    }

    public static StateAndroidLifecycle fromState(State state2) {
        StateAndroidLifecycle stateAndroidLifecycle = (StateAndroidLifecycle) state2.getState(StateAndroidLifecycle.class);
        if (stateAndroidLifecycle != null) {
            return stateAndroidLifecycle;
        }
        return new StateAndroidLifecycle();
    }

    public int getState() {
        return this.state;
    }

    public String toString() {
        return "AndroidLifeCycle{state=" + this.state + '}';
    }

    public StateAndroidLifecycle(int i11) {
        this.state = i11;
    }
}
