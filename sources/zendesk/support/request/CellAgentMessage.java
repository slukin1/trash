package zendesk.support.request;

import android.content.Context;
import android.graphics.Rect;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.TextView;
import com.zendesk.sdk.R$dimen;
import com.zendesk.sdk.R$id;
import com.zendesk.sdk.R$layout;
import com.zendesk.sdk.R$string;
import zendesk.support.request.CellType;
import zendesk.support.request.ComponentRequestAdapter;

class CellAgentMessage extends CellBase implements CellType.Message, CellType.Agent {
    private final Rect insets;
    private final StateMessage message;
    private boolean showAgentName = false;
    private final CharSequence textMessage;
    private final StateRequestUser user;

    public CellAgentMessage(CellBindHelper cellBindHelper, StateMessage stateMessage, CharSequence charSequence, StateRequestUser stateRequestUser) {
        super(cellBindHelper, R$layout.zs_request_agent_message, stateMessage.getId(), stateMessage.getUserId(), stateMessage.getDate());
        this.textMessage = charSequence;
        this.message = stateMessage;
        this.user = stateRequestUser;
        this.insets = cellBindHelper.getInsets(0, R$dimen.zs_request_message_inset_agent_top, 0, R$dimen.zs_request_message_inset_agent_bottom);
    }

    private String buildTalkBackString(Context context) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(context.getString(R$string.zs_request_message_agent_text_accessibility, new Object[]{this.textMessage}));
        sb2.append(" ");
        CharSequence relativeTimeSpanString = DateUtils.getRelativeTimeSpanString(context, this.message.getDate().getTime(), true);
        sb2.append(context.getString(R$string.zs_request_message_agent_sent_accessibility, new Object[]{relativeTimeSpanString, this.user.getName()}));
        return sb2.toString();
    }

    public boolean areContentsTheSame(CellType.Base base) {
        return this.utils.areMessageContentsTheSame(this, base) && this.utils.areAgentCellContentsTheSame(this, base);
    }

    public void bind(ComponentRequestAdapter.RequestViewHolder requestViewHolder) {
        ViewRequestText viewRequestText = (ViewRequestText) requestViewHolder.findCachedView(R$id.request_agent_message_text);
        viewRequestText.setText(this.textMessage);
        this.utils.bindAgentName((TextView) requestViewHolder.findCachedView(R$id.request_agent_name), this.showAgentName, this.user);
        View findCachedView = requestViewHolder.findCachedView(R$id.request_agent_message_bubble);
        findCachedView.setContentDescription(buildTalkBackString(findCachedView.getContext()));
        viewRequestText.requestLayout();
    }

    public StateRequestUser getAgent() {
        return this.user;
    }

    public Rect getInsets() {
        return this.insets;
    }

    public CharSequence getMessage() {
        return this.message.getBody();
    }

    public boolean isAgentNameVisible() {
        return this.showAgentName;
    }

    public void showAgentName(boolean z11) {
        this.showAgentName = z11;
    }
}
