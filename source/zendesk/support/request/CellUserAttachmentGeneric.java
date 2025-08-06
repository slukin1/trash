package zendesk.support.request;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.zendesk.sdk.R$dimen;
import com.zendesk.sdk.R$id;
import com.zendesk.sdk.R$layout;
import com.zendesk.sdk.R$string;
import java.util.Date;
import java.util.List;
import zendesk.support.request.CellType;
import zendesk.support.request.ComponentRequestAdapter;

class CellUserAttachmentGeneric extends CellBase implements CellType.Attachment, CellType.Stateful {
    private final ResolveInfo appInfo;
    private final List<StateMessage> erroredMessages;
    private final Rect insets;
    private final boolean lastErrorCellOfBlock;
    private final boolean markAsDelivered;
    private final StateMessage message;
    private final StateRequestAttachment requestAttachment;
    private final boolean showError;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CellUserAttachmentGeneric(CellBindHelper cellBindHelper, StateMessage stateMessage, StateRequestAttachment stateRequestAttachment, Date date, boolean z11, boolean z12, List<StateMessage> list, boolean z13) {
        super(cellBindHelper, R$layout.zs_request_user_attachment_generic, stateRequestAttachment.getId(), -2147483647L, date);
        CellBindHelper cellBindHelper2 = cellBindHelper;
        this.requestAttachment = stateRequestAttachment;
        this.markAsDelivered = z11;
        this.message = stateMessage;
        this.showError = z12;
        this.erroredMessages = list;
        this.lastErrorCellOfBlock = z13;
        this.appInfo = cellBindHelper.getAppInfo(stateRequestAttachment.getName());
        this.insets = cellBindHelper.getInsets(0, 0, 0, R$dimen.zs_request_message_inset_user_bottom);
    }

    private String buildTalkBackString(Context context) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(context.getString(R$string.zs_request_message_user_file_accessibility, new Object[]{this.requestAttachment.getName()}));
        sb2.append(" ");
        if (!this.showError) {
            CharSequence relativeTimeSpanString = DateUtils.getRelativeTimeSpanString(context, this.message.getDate().getTime(), true);
            sb2.append(context.getString(R$string.zs_request_message_user_sent_accessibility, new Object[]{relativeTimeSpanString}));
        } else {
            sb2.append(context.getString(R$string.zs_request_message_user_error_accessibility));
        }
        return sb2.toString();
    }

    public boolean areContentsTheSame(CellType.Base base) {
        return this.utils.areAttachmentCellContentsTheSame(this, base) && this.utils.areStatefulCellContentsTheSame(this, base);
    }

    public void bind(ComponentRequestAdapter.RequestViewHolder requestViewHolder) {
        ((TextView) requestViewHolder.findCachedView(R$id.request_user_attachment_generic_name)).setText(this.requestAttachment.getName());
        this.utils.bindAppInfo(this.appInfo, (TextView) requestViewHolder.findCachedView(R$id.request_user_attachment_generic_type), (ImageView) requestViewHolder.findCachedView(R$id.request_user_attachment_generic_icon));
        CardView cardView = (CardView) requestViewHolder.findCachedView(R$id.request_user_attachment_generic_container);
        this.utils.addOnClickListenerForFileAttachment(cardView, this.requestAttachment);
        this.utils.bindStatusLabel((TextView) requestViewHolder.findCachedView(R$id.request_user_attachment_generic_status), this.lastErrorCellOfBlock, this.markAsDelivered);
        View.OnClickListener errorClickListener = this.utils.errorClickListener(this.showError, this.erroredMessages);
        requestViewHolder.itemView.setOnClickListener(errorClickListener);
        cardView.setCardBackgroundColor(this.utils.colorForError(this.showError));
        if (errorClickListener != null) {
            cardView.setOnClickListener(errorClickListener);
        }
        cardView.setContentDescription(buildTalkBackString(cardView.getContext()));
    }

    public StateRequestAttachment getAttachment() {
        return this.requestAttachment;
    }

    public List<StateMessage> getErrorGroupMessages() {
        return this.erroredMessages;
    }

    public Rect getInsets() {
        return this.insets;
    }

    public StateMessage getStateMessage() {
        return this.message;
    }

    public boolean isErrorShown() {
        return this.showError;
    }

    public boolean isLastErrorCellOfBlock() {
        return this.lastErrorCellOfBlock;
    }

    public boolean isMarkedAsDelivered() {
        return this.markAsDelivered;
    }

    public CellType.Stateful markAsDelivered() {
        return new CellUserAttachmentGeneric(this.utils, this.message, this.requestAttachment, getTimeStamp(), true, this.showError, this.erroredMessages, this.lastErrorCellOfBlock);
    }

    public CellType.Stateful markAsErrored(List<StateMessage> list, boolean z11) {
        return new CellUserAttachmentGeneric(this.utils, this.message, this.requestAttachment, getTimeStamp(), this.markAsDelivered, true, list, z11);
    }
}
