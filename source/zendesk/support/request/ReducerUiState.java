package zendesk.support.request;

import java.util.List;
import zendesk.support.request.StateUi;
import zendesk.support.suas.Action;
import zendesk.support.suas.Reducer;

class ReducerUiState extends Reducer<StateUi> {
    public StateUi getInitialState() {
        return new StateUi();
    }

    public StateUi reduce(StateUi stateUi, Action<?> action) {
        String actionType = action.getActionType();
        actionType.hashCode();
        if (actionType.equals(ActionFactory.DIALOG_DISMISSED)) {
            return stateUi.setDialogState((StateUi.DialogState) null);
        }
        if (!actionType.equals(ActionFactory.SHOW_RETRY_DIALOG)) {
            return null;
        }
        return stateUi.setDialogState(new StateRetryDialog((List) action.getData()));
    }
}
