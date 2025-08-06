package zendesk.support.request;

import zendesk.support.suas.Action;
import zendesk.support.suas.Reducer;

class ReducerConfiguration extends Reducer<StateConfig> {
    public StateConfig getInitialState() {
        return new StateConfig();
    }

    public StateConfig reduce(StateConfig stateConfig, Action<?> action) {
        String actionType = action.getActionType();
        actionType.hashCode();
        if (actionType.equals(ActionFactory.LOAD_SETTINGS_SUCCESS)) {
            return stateConfig.newBuilder().setSettings((StateSettings) action.getData()).build();
        } else if (!actionType.equals(ActionFactory.START_CONFIG)) {
            return null;
        } else {
            RequestConfiguration requestConfiguration = (RequestConfiguration) action.getData();
            return stateConfig.newBuilder().setTags(requestConfiguration.getTags()).setTicketForm(requestConfiguration.getTicketForm()).setSubject(requestConfiguration.getRequestSubject()).build();
        }
    }
}
