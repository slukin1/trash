package zendesk.support.request;

import com.facebook.internal.AnalyticsEvents;
import java.io.Serializable;

class StateMessageStatus implements Serializable {
    public static final int DELIVERED = 2;
    public static final int ERROR = 1;
    public static final int PENDING = 3;
    private final String errorResponse;
    private final int status;

    private StateMessageStatus(int i11, String str) {
        this.status = i11;
        this.errorResponse = str;
    }

    public static StateMessageStatus delivered() {
        return new StateMessageStatus(2, (String) null);
    }

    public static StateMessageStatus error(String str) {
        return new StateMessageStatus(1, str);
    }

    public static StateMessageStatus pending() {
        return new StateMessageStatus(3, (String) null);
    }

    public String getErrorResponse() {
        return this.errorResponse;
    }

    public int getStatus() {
        return this.status;
    }

    public String toString() {
        int i11 = this.status;
        String str = i11 != 1 ? i11 != 2 ? i11 != 3 ? AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN : "Pending" : "Delivered" : "Error";
        return "MessageState{status=" + str + ", errorResponse=" + this.errorResponse + '}';
    }
}
