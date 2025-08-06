package zendesk.support.request;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import zendesk.support.suas.Action;
import zendesk.support.suas.Reducer;

class ReducerProgress extends Reducer<StateProgress> {
    private static final Collection<String> DECREMENT_ACTION = new HashSet(Arrays.asList(new String[]{ActionFactory.CREATE_COMMENT_ERROR, ActionFactory.CREATE_COMMENT_SUCCESS, ActionFactory.LOAD_SETTINGS_ERROR, ActionFactory.LOAD_SETTINGS_SUCCESS, ActionFactory.CREATE_REQUEST_ERROR, ActionFactory.CREATE_REQUEST_SUCCESS, ActionFactory.LOAD_COMMENTS_INITIAL_ERROR, ActionFactory.LOAD_COMMENTS_INITIAL_SUCCESS, ActionFactory.LOAD_COMMENTS_FROM_CACHE_SUCCESS, ActionFactory.LOAD_COMMENTS_FROM_CACHE_ERROR, ActionFactory.LOAD_REQUEST_ERROR, ActionFactory.LOAD_REQUEST_SUCCESS, ActionFactory.SKIP_ACTION}));
    private static final Collection<String> INCREMENT_ACTIONS = new HashSet(Arrays.asList(new String[]{ActionFactory.CREATE_COMMENT, ActionFactory.LOAD_SETTINGS, ActionFactory.LOAD_COMMENTS_FROM_CACHE, ActionFactory.LOAD_COMMENTS_INITIAL, ActionFactory.LOAD_REQUEST}));

    public StateProgress getInitialState() {
        return new StateProgress();
    }

    public StateProgress reduce(StateProgress stateProgress, Action<?> action) {
        if (INCREMENT_ACTIONS.contains(action.getActionType())) {
            return stateProgress.increment();
        }
        if (DECREMENT_ACTION.contains(action.getActionType())) {
            return stateProgress.decrement();
        }
        return null;
    }
}
