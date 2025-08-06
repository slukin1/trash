package com.zopim.android.sdk.data.observers;

import android.content.Context;
import com.zendesk.logger.Logger;
import com.zopim.android.sdk.api.R;
import com.zopim.android.sdk.api.ZopimChatApi;
import com.zopim.android.sdk.model.Agent;
import com.zopim.android.sdk.model.ChatLog;
import com.zopim.android.sdk.model.items.AgentAttachment;
import com.zopim.android.sdk.model.items.AgentItem;
import com.zopim.android.sdk.model.items.AgentMessage;
import com.zopim.android.sdk.model.items.AgentOptions;
import com.zopim.android.sdk.model.items.AgentTyping;
import com.zopim.android.sdk.model.items.ChatEvent;
import com.zopim.android.sdk.model.items.ChatMemberEvent;
import com.zopim.android.sdk.model.items.ChatRating;
import com.zopim.android.sdk.model.items.RowItem;
import com.zopim.android.sdk.model.items.VisitorAttachment;
import com.zopim.android.sdk.model.items.VisitorItem;
import com.zopim.android.sdk.model.items.VisitorMessage;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

final class ViewModelFactory {
    private static final String LOG_TAG = "ViewModelFactory";
    private final Context context;

    /* renamed from: com.zopim.android.sdk.data.observers.ViewModelFactory$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$zopim$android$sdk$model$ChatLog$Error;
        public static final /* synthetic */ int[] $SwitchMap$com$zopim$android$sdk$model$ChatLog$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0063 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0079 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0085 */
        static {
            /*
                com.zopim.android.sdk.model.ChatLog$Error[] r0 = com.zopim.android.sdk.model.ChatLog.Error.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$zopim$android$sdk$model$ChatLog$Error = r0
                r1 = 1
                com.zopim.android.sdk.model.ChatLog$Error r2 = com.zopim.android.sdk.model.ChatLog.Error.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$zopim$android$sdk$model$ChatLog$Error     // Catch:{ NoSuchFieldError -> 0x001d }
                com.zopim.android.sdk.model.ChatLog$Error r3 = com.zopim.android.sdk.model.ChatLog.Error.UPLOAD_SIZE_ERROR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$com$zopim$android$sdk$model$ChatLog$Error     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.zopim.android.sdk.model.ChatLog$Error r4 = com.zopim.android.sdk.model.ChatLog.Error.UPLOAD_FILE_EXTENSION_ERROR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                com.zopim.android.sdk.model.ChatLog$Type[] r3 = com.zopim.android.sdk.model.ChatLog.Type.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$com$zopim$android$sdk$model$ChatLog$Type = r3
                com.zopim.android.sdk.model.ChatLog$Type r4 = com.zopim.android.sdk.model.ChatLog.Type.CHAT_MSG_VISITOR     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = $SwitchMap$com$zopim$android$sdk$model$ChatLog$Type     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.zopim.android.sdk.model.ChatLog$Type r3 = com.zopim.android.sdk.model.ChatLog.Type.VISITOR_ATTACHMENT     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$model$ChatLog$Type     // Catch:{ NoSuchFieldError -> 0x004d }
                com.zopim.android.sdk.model.ChatLog$Type r1 = com.zopim.android.sdk.model.ChatLog.Type.CHAT_MSG_AGENT     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$model$ChatLog$Type     // Catch:{ NoSuchFieldError -> 0x0058 }
                com.zopim.android.sdk.model.ChatLog$Type r1 = com.zopim.android.sdk.model.ChatLog.Type.CHAT_MSG_SYSTEM     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$model$ChatLog$Type     // Catch:{ NoSuchFieldError -> 0x0063 }
                com.zopim.android.sdk.model.ChatLog$Type r1 = com.zopim.android.sdk.model.ChatLog.Type.ACCOUNT_OFFLINE     // Catch:{ NoSuchFieldError -> 0x0063 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0063 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0063 }
            L_0x0063:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$model$ChatLog$Type     // Catch:{ NoSuchFieldError -> 0x006e }
                com.zopim.android.sdk.model.ChatLog$Type r1 = com.zopim.android.sdk.model.ChatLog.Type.CHAT_MSG_TRIGGER     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$model$ChatLog$Type     // Catch:{ NoSuchFieldError -> 0x0079 }
                com.zopim.android.sdk.model.ChatLog$Type r1 = com.zopim.android.sdk.model.ChatLog.Type.MEMBER_JOIN     // Catch:{ NoSuchFieldError -> 0x0079 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0079 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0079 }
            L_0x0079:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$model$ChatLog$Type     // Catch:{ NoSuchFieldError -> 0x0085 }
                com.zopim.android.sdk.model.ChatLog$Type r1 = com.zopim.android.sdk.model.ChatLog.Type.MEMBER_LEAVE     // Catch:{ NoSuchFieldError -> 0x0085 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0085 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0085 }
            L_0x0085:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$model$ChatLog$Type     // Catch:{ NoSuchFieldError -> 0x0091 }
                com.zopim.android.sdk.model.ChatLog$Type r1 = com.zopim.android.sdk.model.ChatLog.Type.CHAT_RATING     // Catch:{ NoSuchFieldError -> 0x0091 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0091 }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0091 }
            L_0x0091:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zopim.android.sdk.data.observers.ViewModelFactory.AnonymousClass1.<clinit>():void");
        }
    }

    public ViewModelFactory(Context context2) {
        this.context = context2;
    }

    private ChatEvent createAccountOfflineEvent(String str, ChatLog chatLog) {
        ChatEvent chatEvent = new ChatEvent();
        chatEvent.setMessage(String.format(getStringResource(R.string.chat_account_offline_message), new Object[0]));
        updateRowItem(chatEvent, str, chatLog);
        return chatEvent;
    }

    private AgentAttachment createAgentAttachment(String str, ChatLog chatLog) {
        AgentAttachment agentAttachment = new AgentAttachment();
        Long l11 = null;
        agentAttachment.setAttachmentUrl(chatLog.getAttachment() != null ? chatLog.getAttachment().getUrl() : null);
        agentAttachment.setAttachmentName(chatLog.getAttachment() != null ? chatLog.getAttachment().getName() : null);
        agentAttachment.setAttachmentFile(chatLog.getFile());
        if (chatLog.getAttachment() != null) {
            l11 = chatLog.getAttachment().getSize();
        }
        agentAttachment.setAttachmentSize(l11);
        updateRowItem(agentAttachment, str, chatLog);
        updateAgentItem(agentAttachment);
        return agentAttachment;
    }

    private AgentMessage createAgentMessage(String str, ChatLog chatLog) {
        AgentMessage agentMessage = new AgentMessage();
        agentMessage.setMessage(chatLog.getMessage());
        updateRowItem(agentMessage, str, chatLog);
        updateAgentItem(agentMessage);
        return agentMessage;
    }

    private AgentOptions createAgentOptions(String str, ChatLog chatLog) {
        AgentOptions agentOptions = new AgentOptions();
        agentOptions.setMessage(chatLog.getMessage());
        agentOptions.setOptions(new String[chatLog.getOptions().length]);
        int i11 = 0;
        while (true) {
            if (i11 >= chatLog.getOptions().length) {
                break;
            }
            ChatLog.Option option = chatLog.getOptions()[i11];
            agentOptions.getOptions()[i11] = option.getLabel();
            if (option.isSelected()) {
                agentOptions.setOptions(new String[]{option.getLabel()});
                break;
            }
            i11++;
        }
        updateRowItem(agentOptions, str, chatLog);
        updateAgentItem(agentOptions);
        return agentOptions;
    }

    private ChatMemberEvent createJoinEvent(String str, ChatLog chatLog) {
        ChatMemberEvent chatMemberEvent = new ChatMemberEvent();
        chatMemberEvent.setMessage(String.format(getStringResource(R.string.chat_agent_joined_message), new Object[]{chatLog.getDisplayName()}));
        updateRowItem(chatMemberEvent, str, chatLog);
        return chatMemberEvent;
    }

    private ChatMemberEvent createLeaveEvent(String str, ChatLog chatLog) {
        ChatMemberEvent chatMemberEvent = new ChatMemberEvent();
        chatMemberEvent.setMessage(String.format(getStringResource(R.string.chat_agent_left_message), new Object[]{chatLog.getDisplayName()}));
        updateRowItem(chatMemberEvent, str, chatLog);
        return chatMemberEvent;
    }

    private ChatRating createRatingEvent(String str, ChatLog chatLog) {
        ChatRating chatRating = new ChatRating();
        chatRating.setRating(chatLog.getRating());
        chatRating.setComment(chatLog.getComment());
        updateRowItem(chatRating, str, chatLog);
        return chatRating;
    }

    private ChatEvent createSystemEvent(String str, ChatLog chatLog) {
        ChatEvent chatEvent = new ChatEvent();
        chatEvent.setMessage(String.format(getStringResource(R.string.chat_visitor_queue_message), new Object[]{chatLog.getVisitorQueue()}));
        updateRowItem(chatEvent, str, chatLog);
        return chatEvent;
    }

    private ChatEvent createTriggerEvent(String str, ChatLog chatLog) {
        ChatEvent chatEvent = new ChatEvent();
        chatEvent.setMessage(chatLog.getMessage());
        updateRowItem(chatEvent, str, chatLog);
        return chatEvent;
    }

    private VisitorAttachment createVisitorAttachment(String str, ChatLog chatLog) {
        VisitorAttachment visitorAttachment = new VisitorAttachment();
        visitorAttachment.setUploadUrl(chatLog.getUploadUrl());
        visitorAttachment.setFile(chatLog.getFile());
        visitorAttachment.setUploadProgress(chatLog.getProgress());
        int i11 = AnonymousClass1.$SwitchMap$com$zopim$android$sdk$model$ChatLog$Error[chatLog.getError().ordinal()];
        if (i11 == 2) {
            visitorAttachment.setError(getStringResource(R.string.attachment_upload_size_limit_error_message));
        } else if (i11 == 3) {
            visitorAttachment.setError(getStringResource(R.string.attachment_upload_type_error_message));
        }
        updateVisitorItem(visitorAttachment, chatLog);
        updateRowItem(visitorAttachment, str, chatLog);
        return visitorAttachment;
    }

    private VisitorMessage createVisitorMessage(String str, ChatLog chatLog) {
        VisitorMessage visitorMessage = new VisitorMessage();
        visitorMessage.setMessage(chatLog.getMessage());
        updateVisitorItem(visitorMessage, chatLog);
        updateRowItem(visitorMessage, str, chatLog);
        return visitorMessage;
    }

    private String getStringResource(int i11) {
        Context context2 = this.context;
        return context2 != null ? context2.getResources().getString(i11) : "";
    }

    private void updateAgentItem(AgentItem agentItem) {
        Agent agent = ZopimChatApi.getDataSource().getAgents().get(agentItem.getParticipantId());
        if (agent != null) {
            agentItem.setAvatarUri(agent.getAvatarUri());
        }
    }

    private void updateRowItem(RowItem rowItem, String str, ChatLog chatLog) {
        rowItem.setId(str);
        rowItem.setDisplayName(chatLog.getDisplayName());
        rowItem.setParticipantId(chatLog.getNick());
        rowItem.setTimestamp(chatLog.getTimestamp());
    }

    private void updateVisitorItem(VisitorItem visitorItem, ChatLog chatLog) {
        visitorItem.setUnverified(chatLog.isUnverified() != null ? chatLog.isUnverified().booleanValue() : true);
        visitorItem.setFailed(chatLog.isFailed() != null ? chatLog.isFailed().booleanValue() : false);
    }

    public final TreeMap<String, AgentTyping> createItems(Map<String, Agent> map) {
        if (map == null) {
            return new TreeMap<>();
        }
        TreeMap<String, AgentTyping> treeMap = new TreeMap<>();
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            Agent agent = (Agent) next.getValue();
            if (agent.isTyping() != null) {
                AgentTyping agentTyping = new AgentTyping();
                agentTyping.setParticipantId(str);
                agentTyping.setTimestamp(Long.valueOf(System.currentTimeMillis()));
                agentTyping.setTyping(agent.isTyping().booleanValue());
                agentTyping.setAvatarUri(agent.getAvatarUri());
                agentTyping.setDisplayName(agent.getDisplayName());
                treeMap.put(agentTyping.getId(), agentTyping);
            }
        }
        return treeMap;
    }

    public final TreeMap<String, RowItem> createItems(LinkedHashMap<String, ChatLog> linkedHashMap) {
        if (linkedHashMap == null) {
            return new TreeMap<>();
        }
        TreeMap<String, RowItem> treeMap = new TreeMap<>();
        boolean z11 = true;
        for (Map.Entry next : linkedHashMap.entrySet()) {
            String str = (String) next.getKey();
            ChatLog chatLog = (ChatLog) next.getValue();
            boolean z12 = false;
            switch (AnonymousClass1.$SwitchMap$com$zopim$android$sdk$model$ChatLog$Type[chatLog.getType().ordinal()]) {
                case 1:
                    VisitorMessage createVisitorMessage = createVisitorMessage(str, chatLog);
                    treeMap.put(createVisitorMessage.getId(), createVisitorMessage);
                    break;
                case 2:
                    VisitorAttachment createVisitorAttachment = createVisitorAttachment(str, chatLog);
                    treeMap.put(createVisitorAttachment.getId(), createVisitorAttachment);
                    break;
                case 3:
                    boolean z13 = chatLog.getAttachment() != null;
                    if (chatLog.getOptions().length > 0) {
                        z12 = true;
                    }
                    if (!z13) {
                        if (!z12) {
                            AgentMessage createAgentMessage = createAgentMessage(str, chatLog);
                            treeMap.put(createAgentMessage.getId(), createAgentMessage);
                            break;
                        } else {
                            AgentOptions createAgentOptions = createAgentOptions(str, chatLog);
                            treeMap.put(createAgentOptions.getId(), createAgentOptions);
                            break;
                        }
                    } else {
                        AgentAttachment createAgentAttachment = createAgentAttachment(str, chatLog);
                        treeMap.put(createAgentAttachment.getId(), createAgentAttachment);
                        break;
                    }
                case 4:
                    ChatEvent createSystemEvent = createSystemEvent(str, chatLog);
                    treeMap.put(createSystemEvent.getId(), createSystemEvent);
                    break;
                case 5:
                    ChatEvent createAccountOfflineEvent = createAccountOfflineEvent(str, chatLog);
                    treeMap.put(createAccountOfflineEvent.getId(), createAccountOfflineEvent);
                    break;
                case 6:
                    ChatEvent createTriggerEvent = createTriggerEvent(str, chatLog);
                    treeMap.put(createTriggerEvent.getId(), createTriggerEvent);
                    break;
                case 7:
                    ChatMemberEvent createJoinEvent = createJoinEvent(str, chatLog);
                    Iterator<String> it2 = ZopimChatApi.getDataSource().getAgents().keySet().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (it2.next().equals(createJoinEvent.getParticipantId())) {
                                if (!z11) {
                                    treeMap.put(createJoinEvent.getId(), createJoinEvent);
                                    break;
                                } else {
                                    z11 = false;
                                }
                            }
                        } else {
                            break;
                        }
                    }
                case 8:
                    ChatMemberEvent createLeaveEvent = createLeaveEvent(str, chatLog);
                    Iterator<String> it3 = ZopimChatApi.getDataSource().getAgents().keySet().iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            if (it3.next().equals(createLeaveEvent.getParticipantId())) {
                                treeMap.put(createLeaveEvent.getId(), createLeaveEvent);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                case 9:
                    ChatRating createRatingEvent = createRatingEvent(str, chatLog);
                    treeMap.put(createRatingEvent.getId(), createRatingEvent);
                    break;
                default:
                    Logger.j(LOG_TAG, "Skipping build of an unknown item: ", chatLog.getType());
                    break;
            }
        }
        return treeMap;
    }
}
