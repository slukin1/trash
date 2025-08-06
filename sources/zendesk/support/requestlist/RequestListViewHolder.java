package zendesk.support.requestlist;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.squareup.picasso.Picasso;
import com.zendesk.sdk.R$attr;
import com.zendesk.sdk.R$color;
import com.zendesk.sdk.R$dimen;
import com.zendesk.sdk.R$id;
import com.zendesk.sdk.R$layout;
import com.zendesk.sdk.R$string;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mz.f;
import zendesk.support.UiUtils;
import zendesk.support.ZendeskAvatarView;
import zendesk.support.requestlist.RequestListView;

class RequestListViewHolder extends RecyclerView.ViewHolder {
    private final int avatarRadius;
    private final ZendeskAvatarView avatarView;
    private final TextView commentText;
    private final Context context;
    /* access modifiers changed from: private */
    public final RequestListView.OnItemClick listener;
    private final Picasso picasso;
    private final TextView subjectText;
    private final TextView timeText;
    private final TextView userText;

    private RequestListViewHolder(View view, RequestListView.OnItemClick onItemClick, Picasso picasso2) {
        super(view);
        this.listener = onItemClick;
        this.picasso = picasso2;
        Context context2 = view.getContext();
        this.context = context2;
        this.avatarView = (ZendeskAvatarView) view.findViewById(R$id.request_list_item_avatar);
        this.timeText = (TextView) view.findViewById(R$id.request_list_item_time);
        this.userText = (TextView) view.findViewById(R$id.request_list_item_user);
        this.subjectText = (TextView) view.findViewById(R$id.request_list_item_subject);
        this.commentText = (TextView) view.findViewById(R$id.request_list_item_body);
        this.avatarRadius = context2.getResources().getDimensionPixelOffset(R$dimen.zs_request_list_avatar_radius);
    }

    private void bindAvatar(boolean z11, List<String> list, String str) {
        if (!z11) {
            this.avatarView.showUserWithIdentifier(Integer.valueOf(R$string.request_list_me));
        } else if (f.c(str)) {
            this.avatarView.showUserWithAvatarImage(this.picasso, str, list.get(0), this.avatarRadius);
        } else {
            this.avatarView.showUserWithName(list.get(0));
        }
    }

    public static RequestListViewHolder create(Context context2, ViewGroup viewGroup, RequestListView.OnItemClick onItemClick, Picasso picasso2) {
        return new RequestListViewHolder(LayoutInflater.from(context2).inflate(R$layout.zs_request_list_ticket_item, viewGroup, false), onItemClick, picasso2);
    }

    private String generateUserText(String str, List<String> list) {
        ArrayList arrayList = new ArrayList(list);
        arrayList.add(str);
        return TextUtils.join(", ", arrayList);
    }

    private CharSequence getDateTimeString(Date date) {
        return DateUtils.getRelativeTimeSpanString(this.context, date.getTime(), false);
    }

    private void style(boolean z11, boolean z12, boolean z13) {
        if (z11) {
            this.subjectText.setTypeface(Typeface.defaultFromStyle(1));
            this.userText.setTypeface(Typeface.defaultFromStyle(1));
            this.commentText.setTextColor(ContextCompat.getColor(this.context, R$color.zs_request_list_dark_text_color));
            this.timeText.setTextColor(UiUtils.themeAttributeToColor(R$attr.colorPrimary, this.context, R$color.zs_request_list_light_text_color));
        } else {
            this.subjectText.setTypeface(Typeface.defaultFromStyle(0));
            this.userText.setTypeface(Typeface.defaultFromStyle(0));
            TextView textView = this.commentText;
            Context context2 = this.context;
            int i11 = R$color.zs_request_list_light_text_color;
            textView.setTextColor(ContextCompat.getColor(context2, i11));
            this.timeText.setTextColor(ContextCompat.getColor(this.context, i11));
        }
        if (z12) {
            this.commentText.setTextColor(ContextCompat.getColor(this.context, R$color.zs_request_cell_label_color_error));
        }
        this.itemView.setBackgroundColor(ContextCompat.getColor(this.context, R$color.zs_request_list_white));
    }

    public void bind(final RequestListItem requestListItem) {
        String str;
        this.userText.setText(generateUserText(this.context.getString(R$string.request_list_me), requestListItem.getLastCommentingAgentNames()));
        TextView textView = this.subjectText;
        if (requestListItem.hasAgentReplied()) {
            str = this.context.getString(R$string.request_list_re, new Object[]{requestListItem.getFirstMessage()});
        } else {
            str = requestListItem.getFirstMessage();
        }
        textView.setText(str);
        if (requestListItem.isClosed()) {
            this.commentText.setText(R$string.request_list_ticket_closed);
        } else if (requestListItem.isFailed()) {
            this.commentText.setText(R$string.ask_request_list_failed_request_message);
        } else {
            this.commentText.setText(requestListItem.getLastMessage());
        }
        Date lastUpdated = requestListItem.getLastUpdated();
        this.timeText.setText(lastUpdated != null ? getDateTimeString(lastUpdated) : "");
        bindAvatar(requestListItem.hasAgentReplied(), requestListItem.getLastCommentingAgentNames(), requestListItem.getAvatar());
        style(requestListItem.isUnread(), requestListItem.isFailed(), requestListItem.isClosed());
        this.itemView.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                RequestListViewHolder.this.listener.onClick(requestListItem);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
    }
}
