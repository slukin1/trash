package zendesk.support.request;

import android.graphics.Rect;
import java.util.Date;
import java.util.List;
import zendesk.support.request.ComponentRequestAdapter;

interface CellType {

    public interface Agent extends Base {
        StateRequestUser getAgent();

        boolean isAgentNameVisible();

        void showAgentName(boolean z11);
    }

    public interface Attachment extends Base {
        StateRequestAttachment getAttachment();
    }

    public interface Base {
        boolean areContentsTheSame(Base base);

        void bind(ComponentRequestAdapter.RequestViewHolder requestViewHolder);

        long getGroupId();

        Rect getInsets();

        int getLayoutId();

        int getPositionType();

        Date getTimeStamp();

        long getUniqueId();

        void setPositionType(int i11);
    }

    public interface Message extends Base {
        CharSequence getMessage();
    }

    public interface Stateful extends Base {
        List<StateMessage> getErrorGroupMessages();

        StateMessage getStateMessage();

        boolean isErrorShown();

        boolean isLastErrorCellOfBlock();

        boolean isMarkedAsDelivered();

        Stateful markAsDelivered();

        Stateful markAsErrored(List<StateMessage> list, boolean z11);
    }
}
