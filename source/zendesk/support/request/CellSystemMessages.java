package zendesk.support.request;

import android.widget.TextView;
import com.zendesk.sdk.R$id;
import com.zendesk.sdk.R$layout;
import com.zendesk.sdk.R$string;
import java.util.Date;
import zendesk.support.RequestStatus;
import zendesk.support.request.CellType;
import zendesk.support.request.ComponentRequestAdapter;

class CellSystemMessages {

    public static class CellDateMessage extends CellBase {
        public CellDateMessage(CellBindHelper cellBindHelper, long j11, Date date) {
            super(cellBindHelper, R$layout.zs_request_date_message, j11, -2147483648L, date);
        }

        public boolean areContentsTheSame(CellType.Base base) {
            return getTimeStamp().equals(base.getTimeStamp());
        }

        public void bind(ComponentRequestAdapter.RequestViewHolder requestViewHolder) {
            this.utils.bindDate((TextView) requestViewHolder.findCachedView(R$id.request_date_message_text), getTimeStamp());
        }
    }

    public static class CellRequestStatus extends CellBase {
        private final RequestStatus requestStatus;

        public CellRequestStatus(CellBindHelper cellBindHelper, RequestStatus requestStatus2) {
            super(cellBindHelper, R$layout.zs_request_system_message, -9223372036854775807L, -2147483648L, new Date());
            this.requestStatus = requestStatus2;
        }

        public boolean areContentsTheSame(CellType.Base base) {
            return base instanceof CellRequestStatus;
        }

        public void bind(ComponentRequestAdapter.RequestViewHolder requestViewHolder) {
            TextView textView = (TextView) requestViewHolder.findCachedView(R$id.request_system_message_text);
            if (this.requestStatus == RequestStatus.Closed) {
                textView.setText(R$string.request_system_message_closed_ticket);
            }
        }
    }

    public static class CellSystemMessage extends CellBase {
        private final String message;

        public CellSystemMessage(Date date, String str) {
            super((CellBindHelper) null, R$layout.zs_request_system_message, Long.MIN_VALUE, -2147483648L, date);
            this.message = str;
        }

        public boolean areContentsTheSame(CellType.Base base) {
            return base instanceof CellSystemMessage;
        }

        public void bind(ComponentRequestAdapter.RequestViewHolder requestViewHolder) {
            ((TextView) requestViewHolder.findCachedView(R$id.request_system_message_text)).setText(this.message);
        }
    }
}
