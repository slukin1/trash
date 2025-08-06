package zendesk.support.request;

import zendesk.support.suas.Action;
import zendesk.support.suas.Reducer;

class ReducerAndroidLifecycle extends Reducer<StateAndroidLifecycle> {
    public StateAndroidLifecycle getInitialState() {
        return new StateAndroidLifecycle();
    }

    public StateAndroidLifecycle reduce(StateAndroidLifecycle stateAndroidLifecycle, Action<?> action) {
        String actionType = action.getActionType();
        actionType.hashCode();
        if (actionType.equals(ActionFactory.ANDROID_ON_PAUSE)) {
            return new StateAndroidLifecycle(2);
        }
        if (!actionType.equals(ActionFactory.ANDROID_ON_RESUME)) {
            return null;
        }
        return new StateAndroidLifecycle(1);
    }
}
