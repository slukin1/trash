package zendesk.support.request;

import android.content.Context;
import android.graphics.Rect;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.zendesk.sdk.R$dimen;
import com.zendesk.sdk.R$id;
import com.zendesk.sdk.R$layout;
import com.zendesk.sdk.R$string;
import java.util.Date;
import zendesk.support.request.CellType;
import zendesk.support.request.ComponentRequestAdapter;

class CellAgentAttachmentImage extends CellBase implements CellType.Attachment, CellType.Agent {
    private final StateRequestAttachment attachment;
    private final Rect insets;
    private boolean isAgentNameVisible = false;
    private final StateRequestUser user;

    public CellAgentAttachmentImage(CellBindHelper cellBindHelper, StateRequestAttachment stateRequestAttachment, StateRequestUser stateRequestUser, Date date) {
        super(cellBindHelper, R$layout.zs_request_agent_attachment_image, stateRequestAttachment.getId(), stateRequestUser.getId(), date);
        this.user = stateRequestUser;
        this.attachment = stateRequestAttachment;
        this.insets = cellBindHelper.getInsets(0, 0, 0, R$dimen.zs_request_message_inset_agent_attachment_bottom);
    }

    private String buildTalkBackString(Context context) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(context.getString(R$string.zs_request_message_agent_image_accessibility, new Object[]{this.attachment.getName()}));
        sb2.append(" ");
        CharSequence relativeTimeSpanString = DateUtils.getRelativeTimeSpanString(context, getTimeStamp().getTime(), true);
        sb2.append(context.getString(R$string.zs_request_message_agent_sent_accessibility, new Object[]{relativeTimeSpanString, this.user.getName()}));
        return sb2.toString();
    }

    public boolean areContentsTheSame(CellType.Base base) {
        return this.utils.areAttachmentCellContentsTheSame(this, base) && this.utils.areAgentCellContentsTheSame(this, base);
    }

    public void bind(ComponentRequestAdapter.RequestViewHolder requestViewHolder) {
        ImageView imageView = (ImageView) requestViewHolder.findCachedView(R$id.request_agent_message_attachment_image);
        this.utils.bindImage(imageView, this.attachment);
        this.utils.addOnClickListenerForImageAttachment(imageView, this.attachment);
        this.utils.bindAgentName((TextView) requestViewHolder.findCachedView(R$id.request_agent_attachment_name), this.isAgentNameVisible, this.user);
        View findCachedView = requestViewHolder.findCachedView(R$id.request_agent_attachment_card);
        findCachedView.setContentDescription(buildTalkBackString(findCachedView.getContext()));
    }

    public StateRequestUser getAgent() {
        return this.user;
    }

    public StateRequestAttachment getAttachment() {
        return this.attachment;
    }

    public Rect getInsets() {
        return this.insets;
    }

    public boolean isAgentNameVisible() {
        return this.isAgentNameVisible;
    }

    public void showAgentName(boolean z11) {
        this.isAgentNameVisible = z11;
    }
}
