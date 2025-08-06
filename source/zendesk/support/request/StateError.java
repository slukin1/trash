package zendesk.support.request;

import java.io.Serializable;
import zendesk.support.suas.State;

class StateError implements Serializable {
    private final String message;
    private final ErrorType state;

    public enum ErrorType {
        InitialGetComments,
        InputFormSubmission,
        NoAccess,
        NoError
    }

    public StateError() {
        this(ErrorType.NoError, "=)");
    }

    public static StateError fromState(State state2) {
        StateError stateError = (StateError) state2.getState(StateError.class);
        if (stateError != null) {
            return stateError;
        }
        return new StateError();
    }

    public String getMessage() {
        return this.message;
    }

    public ErrorType getState() {
        return this.state;
    }

    public StateError(ErrorType errorType, String str) {
        this.state = errorType;
        this.message = str;
    }
}
