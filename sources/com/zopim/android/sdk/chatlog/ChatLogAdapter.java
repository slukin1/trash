package com.zopim.android.sdk.chatlog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.zendesk.logger.Logger;
import com.zopim.android.sdk.R;
import com.zopim.android.sdk.api.ChatApi;
import com.zopim.android.sdk.chatlog.AgentOptionsHolder;
import com.zopim.android.sdk.chatlog.ChatRatingHolder;
import com.zopim.android.sdk.chatlog.VisitorHolder;
import com.zopim.android.sdk.model.ChatLog;
import com.zopim.android.sdk.model.items.AgentItem;
import com.zopim.android.sdk.model.items.AgentOptions;
import com.zopim.android.sdk.model.items.RowItem;
import com.zopim.android.sdk.model.items.VisitorAttachment;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import mz.f;

final class ChatLogAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String LOG_TAG = "ChatLogAdapter";
    private static final int VIEW_TYPE_COUNT = RowItem.Type.values().length;
    /* access modifiers changed from: private */
    public ChatApi chat;
    private Context context;
    public final List<RowItem.Type> firstAgentMessageTypes = Arrays.asList(new RowItem.Type[]{RowItem.Type.AGENT_MESSAGE, RowItem.Type.AGENT_ATTACHMENT, RowItem.Type.AGENT_OPTIONS});
    private List<RowItem> items = Collections.emptyList();
    private final Object mLock = new Object();

    /* renamed from: com.zopim.android.sdk.chatlog.ChatLogAdapter$5  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {
        public static final /* synthetic */ int[] $SwitchMap$com$zopim$android$sdk$model$items$RowItem$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(3:17|18|20)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.zopim.android.sdk.model.items.RowItem$Type[] r0 = com.zopim.android.sdk.model.items.RowItem.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$zopim$android$sdk$model$items$RowItem$Type = r0
                com.zopim.android.sdk.model.items.RowItem$Type r1 = com.zopim.android.sdk.model.items.RowItem.Type.VISITOR_MESSAGE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$model$items$RowItem$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                com.zopim.android.sdk.model.items.RowItem$Type r1 = com.zopim.android.sdk.model.items.RowItem.Type.VISITOR_ATTACHMENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$model$items$RowItem$Type     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.zopim.android.sdk.model.items.RowItem$Type r1 = com.zopim.android.sdk.model.items.RowItem.Type.AGENT_MESSAGE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$model$items$RowItem$Type     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.zopim.android.sdk.model.items.RowItem$Type r1 = com.zopim.android.sdk.model.items.RowItem.Type.AGENT_OPTIONS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$model$items$RowItem$Type     // Catch:{ NoSuchFieldError -> 0x003e }
                com.zopim.android.sdk.model.items.RowItem$Type r1 = com.zopim.android.sdk.model.items.RowItem.Type.AGENT_ATTACHMENT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$model$items$RowItem$Type     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.zopim.android.sdk.model.items.RowItem$Type r1 = com.zopim.android.sdk.model.items.RowItem.Type.AGENT_TYPING     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$model$items$RowItem$Type     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.zopim.android.sdk.model.items.RowItem$Type r1 = com.zopim.android.sdk.model.items.RowItem.Type.CHAT_EVENT     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$model$items$RowItem$Type     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.zopim.android.sdk.model.items.RowItem$Type r1 = com.zopim.android.sdk.model.items.RowItem.Type.MEMBER_EVENT     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$model$items$RowItem$Type     // Catch:{ NoSuchFieldError -> 0x006c }
                com.zopim.android.sdk.model.items.RowItem$Type r1 = com.zopim.android.sdk.model.items.RowItem.Type.CHAT_RATING     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zopim.android.sdk.chatlog.ChatLogAdapter.AnonymousClass5.<clinit>():void");
        }
    }

    private ChatLogAdapter() {
    }

    private boolean isFirstAgentMessage(AgentItem agentItem) {
        for (RowItem next : this.items) {
            if (this.firstAgentMessageTypes.contains(next.getType()) && next.getParticipantId().equals(agentItem.getParticipantId())) {
                if (next.getTimestamp().equals(agentItem.getTimestamp())) {
                    return true;
                }
                return false;
            }
        }
        return true;
    }

    private boolean isLeadMessage(int i11) {
        String participantId = getItem(i11).getParticipantId();
        String participantId2 = getItem(i11 - 1).getParticipantId();
        if (f.e(participantId) || participantId.equals(participantId2)) {
            return false;
        }
        return true;
    }

    public void add(RowItem rowItem) {
        synchronized (this.mLock) {
            this.items.add(rowItem);
        }
    }

    public void clear() {
        synchronized (this.mLock) {
            this.items.clear();
        }
    }

    public RowItem getItem(int i11) {
        List<RowItem> list = this.items;
        if (list == null || i11 < 0 || i11 >= list.size()) {
            return new UnknownRowItem();
        }
        return this.items.get(i11);
    }

    public int getItemCount() {
        return this.items.size();
    }

    public int getItemViewType(int i11) {
        List<RowItem> list = this.items;
        if (list == null || i11 < 0 || i11 >= list.size()) {
            return RowItem.Type.UNKNOWN.getValue();
        }
        RowItem rowItem = this.items.get(i11);
        if (rowItem != null && rowItem.getType() != RowItem.Type.UNKNOWN) {
            return rowItem.getType().getValue();
        }
        Logger.l(LOG_TAG, "Unknown row item of %s type may cause issues down the line", rowItem);
        return RowItem.Type.UNKNOWN.getValue();
    }

    public boolean isEmpty() {
        return getItemCount() == 0;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
        RowItem item = getItem(i11);
        switch (AnonymousClass5.$SwitchMap$com$zopim$android$sdk$model$items$RowItem$Type[RowItem.Type.getType(getItemViewType(i11)).ordinal()]) {
            case 1:
            case 2:
                if (item instanceof LeadItem) {
                    ((LeadItem) item).setLeadItem(isLeadMessage(i11));
                    break;
                }
                break;
            case 3:
            case 4:
            case 5:
            case 6:
                if (item instanceof LeadItem) {
                    ((LeadItem) item).setLeadItem(isLeadMessage(i11));
                }
                if ((item instanceof FirstItem) && (item instanceof AgentItem)) {
                    ((FirstItem) item).setFirstItem(isFirstAgentMessage((AgentItem) item));
                }
                if ((viewHolder instanceof AgentOptionsHolder) && (item instanceof AgentOptions)) {
                    AgentOptionsHolder agentOptionsHolder = (AgentOptionsHolder) viewHolder;
                    AgentOptions agentOptions = (AgentOptions) item;
                    agentOptionsHolder.optionsContainer.removeAllViews();
                    if (agentOptions.getOptions() != null && agentOptions.getOptions().length > 0) {
                        Logger.j(LOG_TAG, "Inflating agent questionnaire view", new Object[0]);
                        LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
                        for (int i12 = 0; i12 < agentOptions.getOptions().length; i12++) {
                            layoutInflater.inflate(R.layout.questinnaire_option, agentOptionsHolder.optionsContainer);
                        }
                        break;
                    }
                }
            case 7:
            case 8:
            case 9:
                break;
            default:
                Logger.l(LOG_TAG, "Can not inflate unknown adapter item type. This may cause NullPointerException down the line.", new Object[0]);
                return;
        }
        if (viewHolder instanceof ViewBinder) {
            ((ViewBinder) viewHolder).bind(item);
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        RowItem.Type type = RowItem.Type.getType(i11);
        switch (AnonymousClass5.$SwitchMap$com$zopim$android$sdk$model$items$RowItem$Type[type.ordinal()]) {
            case 1:
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_visitor_message, viewGroup, false);
                LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_visitor_message_view, (ViewGroup) inflate.findViewById(R.id.message_placeholder), true);
                VisitorMessageHolder visitorMessageHolder = new VisitorMessageHolder(inflate);
                visitorMessageHolder.setClickListener(new VisitorHolder.OnClickListener() {
                    public void onClick(int i11) {
                        ChatLogAdapter.this.chat.resend(ChatLogAdapter.this.getItem(i11).getId());
                    }
                });
                return visitorMessageHolder;
            case 2:
                View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_visitor_message, viewGroup, false);
                LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_visitor_upload_view, (ViewGroup) inflate2.findViewById(R.id.message_placeholder), true);
                VisitorAttachmentHolder visitorAttachmentHolder = new VisitorAttachmentHolder(inflate2);
                visitorAttachmentHolder.setClickListener(new VisitorHolder.OnClickListener() {
                    public void onClick(int i11) {
                        RowItem item = ChatLogAdapter.this.getItem(i11);
                        if (item instanceof VisitorAttachment) {
                            ChatLogAdapter.this.chat.send(((VisitorAttachment) item).getFile());
                        }
                    }
                });
                return visitorAttachmentHolder;
            case 3:
                View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_agent_message, viewGroup, false);
                LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_agent_message_view, (ViewGroup) inflate3.findViewById(R.id.message_placeholder), true);
                return new AgentMessageHolder(inflate3);
            case 4:
                View inflate4 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_agent_message, viewGroup, false);
                LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_agent_message_view, (ViewGroup) inflate4.findViewById(R.id.message_placeholder), true);
                AgentOptionsHolder agentOptionsHolder = new AgentOptionsHolder(inflate4);
                agentOptionsHolder.setClickListener(new AgentOptionsHolder.OptionClickListener() {
                    public void onClick(String str) {
                        if (ChatLogAdapter.this.chat != null) {
                            ChatLogAdapter.this.chat.send(str);
                        }
                    }
                });
                return agentOptionsHolder;
            case 5:
                View inflate5 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_agent_message, viewGroup, false);
                LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_agent_attachment_view, (ViewGroup) inflate5.findViewById(R.id.message_placeholder), true);
                return new AgentAttachmentHolder(inflate5);
            case 6:
                return new AgentTypingHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_agent_typing, viewGroup, false));
            case 7:
                return new ChatEventHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_event_message, viewGroup, false));
            case 8:
                return new ChatMemberEventHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_member_event, viewGroup, false));
            case 9:
                ChatRatingHolder chatRatingHolder = new ChatRatingHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_chat_rating, viewGroup, false));
                chatRatingHolder.setRatingListener(new ChatRatingHolder.RatingListener() {
                    public void onRated(ChatLog.Rating rating) {
                        if (ChatLogAdapter.this.chat != null) {
                            ChatLogAdapter.this.chat.sendChatRating(rating);
                        }
                    }
                });
                return chatRatingHolder;
            default:
                Logger.l(LOG_TAG, String.format(Locale.US, "Unexpected %s item type during ViewHolder creation. Creating UnknownTypeHolder instead or NullPointerException might occur.", new Object[]{type}), new Object[0]);
                return new UnknownTypeHolder(new View(viewGroup.getContext()));
        }
    }

    public void remove(int i11) {
        try {
            this.items.remove(i11);
            notifyItemRemoved(i11);
        } catch (UnsupportedOperationException e11) {
            Logger.k(LOG_TAG, "Can not remove an item from the adapter.", e11, new Object[0]);
        } catch (IndexOutOfBoundsException e12) {
            Logger.k(LOG_TAG, "Can not remove item. Item does not exist.", e12, new Object[0]);
        }
    }

    public void setChat(ChatApi chatApi) {
        this.chat = chatApi;
    }

    public ChatLogAdapter(Context context2, List<RowItem> list) {
        this.items = list;
        this.context = context2;
    }
}
