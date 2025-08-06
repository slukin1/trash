package zendesk.support.request;

import java.io.Serializable;
import java.util.List;
import zendesk.support.request.StateUi;

class StateRetryDialog implements StateUi.DialogState, Serializable {
    private final List<StateMessage> message;
    private final boolean visible;

    public StateRetryDialog(List<StateMessage> list) {
        this(list, false);
    }

    public List<StateMessage> getMessage() {
        return this.message;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public StateUi.DialogState setVisible(boolean z11) {
        return new StateRetryDialog(this.message, z11);
    }

    private StateRetryDialog(List<StateMessage> list, boolean z11) {
        this.message = list;
        this.visible = z11;
    }
}
