package zendesk.support.request;

import java.io.Serializable;
import zendesk.support.suas.State;

class StateUi implements Serializable {
    private final DialogState dialogState;

    public interface DialogState {
        boolean isVisible();

        DialogState setVisible(boolean z11);
    }

    public StateUi(DialogState dialogState2) {
        this.dialogState = dialogState2;
    }

    public static StateUi fromState(State state) {
        StateUi stateUi = (StateUi) state.getState(StateUi.class);
        if (stateUi != null) {
            return stateUi;
        }
        return new StateUi();
    }

    public DialogState getDialogState() {
        return this.dialogState;
    }

    public StateUi setDialogState(DialogState dialogState2) {
        return new StateUi(dialogState2);
    }

    public String toString() {
        return "UiState{dialogState=" + this.dialogState + '}';
    }

    public StateUi() {
        this.dialogState = null;
    }
}
