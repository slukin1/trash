package com.tencent.qcloud.tuikit.timcommon.bean;

import android.text.TextUtils;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuikit.timcommon.util.MessageBuilder;
import com.tencent.qcloud.tuikit.timcommon.util.MessageParser;
import com.tencent.qcloud.tuikit.timcommon.util.TIMCommonConstants;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class TUIMessageBean implements Serializable {
    public static final int MSG_STATUS_DELETE = 274;
    public static final int MSG_STATUS_DOWNLOADED = 6;
    public static final int MSG_STATUS_DOWNLOADING = 4;
    public static final int MSG_STATUS_NORMAL = 0;
    public static final int MSG_STATUS_READ = 273;
    public static final int MSG_STATUS_REVOKE = 275;
    public static final int MSG_STATUS_SENDING = 1;
    public static final int MSG_STATUS_SEND_FAIL = 3;
    public static final int MSG_STATUS_SEND_SUCCESS = 2;
    public static final int MSG_STATUS_UN_DOWNLOAD = 5;
    public static final int MSG_TRANSLATE_STATUS_HIDDEN = 1;
    public static final int MSG_TRANSLATE_STATUS_LOADING = 2;
    public static final int MSG_TRANSLATE_STATUS_SHOWN = 3;
    public static final int MSG_TRANSLATE_STATUS_UNKNOWN = 0;
    public static final String TRANSLATION_KEY = "translation";
    public static final String TRANSLATION_VIEW_STATUS_KEY = "translation_view_status";
    private String businessID;
    private int downloadStatus;
    private boolean excludeFromHistory;
    private String extra;

    /* renamed from: id  reason: collision with root package name */
    private String f48168id;
    private boolean isEnableForward = true;
    private boolean isGroup;
    private boolean isShowTime;
    private boolean isUseMsgReceiverAvatar = false;
    private MessageReactBean messageReactBean;
    private MessageReceiptInfo messageReceiptInfo;
    private MessageRepliesBean messageRepliesBean;
    private long msgTime;
    private boolean peerRead;
    private boolean read;
    private String selectText;
    private int status;
    private int translationStatus = 0;
    private V2TIMMessage v2TIMMessage;

    public String getBusinessID() {
        return this.businessID;
    }

    public int getDownloadStatus() {
        return this.downloadStatus;
    }

    public String getExtra() {
        return this.extra;
    }

    public String getFaceUrl() {
        V2TIMMessage v2TIMMessage2 = this.v2TIMMessage;
        return v2TIMMessage2 != null ? v2TIMMessage2.getFaceUrl() : "";
    }

    public String getFriendRemark() {
        V2TIMMessage v2TIMMessage2 = this.v2TIMMessage;
        return v2TIMMessage2 != null ? v2TIMMessage2.getFriendRemark() : "";
    }

    public String getGroupId() {
        V2TIMMessage v2TIMMessage2 = this.v2TIMMessage;
        return v2TIMMessage2 != null ? v2TIMMessage2.getGroupID() : "";
    }

    public String getId() {
        return this.f48168id;
    }

    public MessageReactBean getMessageReactBean() {
        return this.messageReactBean;
    }

    public MessageRepliesBean getMessageRepliesBean() {
        return this.messageRepliesBean;
    }

    public final long getMessageTime() {
        V2TIMMessage v2TIMMessage2 = this.v2TIMMessage;
        if (v2TIMMessage2 != null) {
            long timestamp = v2TIMMessage2.getTimestamp();
            if (timestamp != 0) {
                return timestamp;
            }
        }
        return this.msgTime;
    }

    public long getMsgSeq() {
        V2TIMMessage v2TIMMessage2 = this.v2TIMMessage;
        if (v2TIMMessage2 != null) {
            return v2TIMMessage2.getSeq();
        }
        return 0;
    }

    public int getMsgType() {
        V2TIMMessage v2TIMMessage2 = this.v2TIMMessage;
        if (v2TIMMessage2 != null) {
            return v2TIMMessage2.getElemType();
        }
        return 0;
    }

    public String getNameCard() {
        V2TIMMessage v2TIMMessage2 = this.v2TIMMessage;
        return v2TIMMessage2 != null ? v2TIMMessage2.getNameCard() : "";
    }

    public String getNickName() {
        V2TIMMessage v2TIMMessage2 = this.v2TIMMessage;
        return v2TIMMessage2 != null ? v2TIMMessage2.getNickName() : "";
    }

    public long getReadCount() {
        MessageReceiptInfo messageReceiptInfo2 = this.messageReceiptInfo;
        if (messageReceiptInfo2 != null) {
            return messageReceiptInfo2.getReadCount();
        }
        return 0;
    }

    public Class<? extends TUIReplyQuoteBean> getReplyQuoteBeanClass() {
        return null;
    }

    public String getSelectText() {
        return this.selectText;
    }

    public String getSender() {
        V2TIMMessage v2TIMMessage2 = this.v2TIMMessage;
        String sender = v2TIMMessage2 != null ? v2TIMMessage2.getSender() : null;
        return TextUtils.isEmpty(sender) ? V2TIMManager.getInstance().getLoginUser() : sender;
    }

    public int getStatus() {
        return this.status;
    }

    public String getTranslation() {
        V2TIMMessage v2TIMMessage2 = this.v2TIMMessage;
        if (v2TIMMessage2 == null) {
            return "";
        }
        String localCustomData = v2TIMMessage2.getLocalCustomData();
        if (TextUtils.isEmpty(localCustomData)) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(localCustomData);
            if (jSONObject.has(TRANSLATION_KEY)) {
                return jSONObject.getString(TRANSLATION_KEY);
            }
            return "";
        } catch (JSONException e11) {
            e11.printStackTrace();
            return "";
        }
    }

    public int getTranslationStatus() {
        int i11 = this.translationStatus;
        if (i11 != 0) {
            return i11;
        }
        V2TIMMessage v2TIMMessage2 = this.v2TIMMessage;
        if (v2TIMMessage2 != null) {
            String localCustomData = v2TIMMessage2.getLocalCustomData();
            if (TextUtils.isEmpty(localCustomData)) {
                return this.translationStatus;
            }
            try {
                JSONObject jSONObject = new JSONObject(localCustomData);
                if (jSONObject.has(TRANSLATION_VIEW_STATUS_KEY)) {
                    this.translationStatus = jSONObject.getInt(TRANSLATION_VIEW_STATUS_KEY);
                }
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
        }
        return this.translationStatus;
    }

    public long getUnreadCount() {
        MessageReceiptInfo messageReceiptInfo2 = this.messageReceiptInfo;
        if (messageReceiptInfo2 != null) {
            return messageReceiptInfo2.getUnreadCount();
        }
        return 0;
    }

    public String getUserDisplayName() {
        if (!TextUtils.isEmpty(getNameCard())) {
            return getNameCard();
        }
        if (!TextUtils.isEmpty(getFriendRemark())) {
            return getFriendRemark();
        }
        if (!TextUtils.isEmpty(getNickName())) {
            return getNickName();
        }
        return getSender();
    }

    public String getUserId() {
        V2TIMMessage v2TIMMessage2 = this.v2TIMMessage;
        return v2TIMMessage2 != null ? v2TIMMessage2.getUserID() : "";
    }

    public V2TIMMessage getV2TIMMessage() {
        return this.v2TIMMessage;
    }

    public boolean isAllRead() {
        return getUnreadCount() == 0 && getReadCount() > 0;
    }

    public boolean isEnableForward() {
        return this.isEnableForward;
    }

    public boolean isExcludeFromHistory() {
        return this.excludeFromHistory;
    }

    public boolean isGroup() {
        return this.isGroup;
    }

    public boolean isNeedReadReceipt() {
        V2TIMMessage v2TIMMessage2 = this.v2TIMMessage;
        if (v2TIMMessage2 != null) {
            return v2TIMMessage2.isNeedReadReceipt();
        }
        return false;
    }

    public boolean isPeerRead() {
        MessageReceiptInfo messageReceiptInfo2 = this.messageReceiptInfo;
        if (messageReceiptInfo2 != null) {
            return messageReceiptInfo2.isPeerRead();
        }
        return this.peerRead;
    }

    public boolean isRead() {
        return this.read;
    }

    public boolean isSelf() {
        V2TIMMessage v2TIMMessage2 = this.v2TIMMessage;
        if (v2TIMMessage2 != null) {
            return v2TIMMessage2.isSelf();
        }
        return true;
    }

    public boolean isShowTime() {
        return this.isShowTime;
    }

    public MessageFeature isSupportTyping() {
        return MessageParser.isSupportTyping(this);
    }

    public boolean isUnread() {
        return getReadCount() == 0;
    }

    public boolean isUseMsgReceiverAvatar() {
        return this.isUseMsgReceiverAvatar;
    }

    public abstract String onGetDisplayString();

    public abstract void onProcessMessage(V2TIMMessage v2TIMMessage2);

    public void setBusinessID(String str) {
        this.businessID = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.util.Map} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v16, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.util.Map} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setCommonAttribute(com.tencent.imsdk.v2.V2TIMMessage r7) {
        /*
            r6 = this;
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 / r2
            r6.msgTime = r0
            r6.v2TIMMessage = r7
            if (r7 != 0) goto L_0x000e
            return
        L_0x000e:
            boolean r0 = r7.isPeerRead()
            r6.peerRead = r0
            boolean r0 = r7.isRead()
            r6.read = r0
            java.lang.String r0 = r7.getMsgID()
            r6.f48168id = r0
            java.lang.String r0 = r7.getGroupID()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 1
            r0 = r0 ^ r1
            r6.isGroup = r0
            int r0 = r7.getStatus()
            r2 = 6
            if (r0 != r2) goto L_0x007f
            r0 = 275(0x113, float:3.85E-43)
            r6.status = r0
            boolean r0 = r6.isSelf()
            if (r0 == 0) goto L_0x004a
            android.content.Context r0 = com.tencent.qcloud.tuicore.ServiceInitializer.getAppContext()
            int r1 = com.tencent.qcloud.tuikit.timcommon.R.string.revoke_tips_you
            java.lang.String r0 = r0.getString(r1)
            r6.extra = r0
            goto L_0x00a1
        L_0x004a:
            boolean r0 = r6.isGroup
            if (r0 == 0) goto L_0x0072
            java.lang.String r0 = r6.getSender()
            java.lang.String r0 = com.tencent.qcloud.tuikit.timcommon.util.TIMCommonConstants.covert2HTMLString(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            android.content.Context r0 = com.tencent.qcloud.tuicore.ServiceInitializer.getAppContext()
            int r2 = com.tencent.qcloud.tuikit.timcommon.R.string.revoke_tips
            java.lang.String r0 = r0.getString(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r6.extra = r0
            goto L_0x00a1
        L_0x0072:
            android.content.Context r0 = com.tencent.qcloud.tuicore.ServiceInitializer.getAppContext()
            int r1 = com.tencent.qcloud.tuikit.timcommon.R.string.revoke_tips_other
            java.lang.String r0 = r0.getString(r1)
            r6.extra = r0
            goto L_0x00a1
        L_0x007f:
            boolean r0 = r6.isSelf()
            if (r0 == 0) goto L_0x00a1
            int r0 = r7.getStatus()
            r2 = 3
            if (r0 != r2) goto L_0x008f
            r6.status = r2
            goto L_0x00a1
        L_0x008f:
            int r0 = r7.getStatus()
            r2 = 2
            if (r0 != r2) goto L_0x0099
            r6.status = r2
            goto L_0x00a1
        L_0x0099:
            int r0 = r7.getStatus()
            if (r0 != r1) goto L_0x00a1
            r6.status = r1
        L_0x00a1:
            com.tencent.imsdk.v2.V2TIMCustomElem r7 = r7.getCustomElem()     // Catch:{ all -> 0x013e }
            byte[] r7 = r7.getData()     // Catch:{ all -> 0x013e }
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x013e }
            r0.<init>(r7)     // Catch:{ all -> 0x013e }
            com.google.gson.Gson r7 = new com.google.gson.Gson     // Catch:{ all -> 0x013e }
            r7.<init>()     // Catch:{ all -> 0x013e }
            r1 = 0
            java.lang.Class<java.util.HashMap> r2 = java.util.HashMap.class
            java.lang.Object r7 = r7.fromJson((java.lang.String) r0, r2)     // Catch:{ JsonSyntaxException -> 0x00bd }
            java.util.HashMap r7 = (java.util.HashMap) r7     // Catch:{ JsonSyntaxException -> 0x00bd }
            goto L_0x00c2
        L_0x00bd:
            r7 = move-exception
            r7.printStackTrace()     // Catch:{ all -> 0x013e }
            r7 = r1
        L_0x00c2:
            if (r7 == 0) goto L_0x00cb
            java.lang.String r0 = "businessID"
            java.lang.Object r0 = r7.get(r0)     // Catch:{ all -> 0x013e }
            goto L_0x00cc
        L_0x00cb:
            r0 = r1
        L_0x00cc:
            boolean r2 = r0 instanceof java.lang.String     // Catch:{ all -> 0x013e }
            if (r2 == 0) goto L_0x0142
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x013e }
            r6.businessID = r0     // Catch:{ all -> 0x013e }
            java.lang.String r2 = "huobi_group_business_share"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x013e }
            if (r0 != 0) goto L_0x00e6
            java.lang.String r0 = r6.businessID     // Catch:{ all -> 0x013e }
            java.lang.String r2 = "huobi_group_business_share_text"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x013e }
            if (r0 == 0) goto L_0x0142
        L_0x00e6:
            java.lang.String r0 = "data"
            java.lang.Object r7 = r7.get(r0)     // Catch:{ all -> 0x013e }
            java.util.Map r7 = (java.util.Map) r7     // Catch:{ all -> 0x013e }
            java.lang.String r0 = "extInfo"
            java.lang.Object r7 = r7.get(r0)     // Catch:{ all -> 0x013e }
            boolean r0 = r7 instanceof java.lang.String     // Catch:{ all -> 0x013e }
            if (r0 == 0) goto L_0x0109
            com.google.gson.Gson r0 = new com.google.gson.Gson     // Catch:{ all -> 0x013e }
            r0.<init>()     // Catch:{ all -> 0x013e }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x013e }
            java.lang.Class<java.util.HashMap> r1 = java.util.HashMap.class
            java.lang.Object r7 = r0.fromJson((java.lang.String) r7, r1)     // Catch:{ all -> 0x013e }
            r1 = r7
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ all -> 0x013e }
            goto L_0x0110
        L_0x0109:
            boolean r0 = r7 instanceof java.util.Map     // Catch:{ all -> 0x013e }
            if (r0 == 0) goto L_0x0110
            r1 = r7
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ all -> 0x013e }
        L_0x0110:
            if (r1 == 0) goto L_0x0142
            java.lang.String r7 = "shareChannel"
            java.lang.Object r7 = r1.get(r7)     // Catch:{ all -> 0x013e }
            boolean r0 = r7 instanceof java.lang.Double     // Catch:{ all -> 0x013e }
            java.lang.String r1 = "huobi_group_business_share_prime"
            if (r0 == 0) goto L_0x012e
            r2 = 4619567317775286272(0x401c000000000000, double:7.0)
            r0 = r7
            java.lang.Double r0 = (java.lang.Double) r0     // Catch:{ all -> 0x013e }
            double r4 = r0.doubleValue()     // Catch:{ all -> 0x013e }
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x012e
            r6.businessID = r1     // Catch:{ all -> 0x013e }
            goto L_0x0142
        L_0x012e:
            boolean r0 = r7 instanceof java.lang.Integer     // Catch:{ all -> 0x013e }
            if (r0 == 0) goto L_0x0142
            r0 = 7
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch:{ all -> 0x013e }
            int r7 = r7.intValue()     // Catch:{ all -> 0x013e }
            if (r0 != r7) goto L_0x0142
            r6.businessID = r1     // Catch:{ all -> 0x013e }
            goto L_0x0142
        L_0x013e:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0142:
            com.tencent.qcloud.tuikit.timcommon.bean.MessageReactBean r7 = com.tencent.qcloud.tuikit.timcommon.util.MessageParser.parseMessageReact(r6)
            r6.messageReactBean = r7
            com.tencent.qcloud.tuikit.timcommon.bean.MessageRepliesBean r7 = com.tencent.qcloud.tuikit.timcommon.util.MessageParser.parseMessageReplies(r6)
            r6.messageRepliesBean = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean.setCommonAttribute(com.tencent.imsdk.v2.V2TIMMessage):void");
    }

    public void setDownloadStatus(int i11) {
        this.downloadStatus = i11;
    }

    public void setEnableForward(boolean z11) {
        this.isEnableForward = z11;
    }

    public void setExcludeFromHistory(boolean z11) {
        this.excludeFromHistory = z11;
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    public void setGroup(boolean z11) {
        this.isGroup = z11;
    }

    public void setId(String str) {
        this.f48168id = str;
    }

    public void setMessageReactBean(MessageReactBean messageReactBean2) {
        this.messageReactBean = messageReactBean2;
        MessageBuilder.mergeCloudCustomData(this, TIMCommonConstants.MESSAGE_REACT_KEY, messageReactBean2);
    }

    public void setMessageReceiptInfo(MessageReceiptInfo messageReceiptInfo2) {
        this.messageReceiptInfo = messageReceiptInfo2;
    }

    public void setMessageRepliesBean(MessageRepliesBean messageRepliesBean2) {
        this.messageRepliesBean = messageRepliesBean2;
        MessageBuilder.mergeCloudCustomData(this, TIMCommonConstants.MESSAGE_REPLIES_KEY, messageRepliesBean2);
    }

    public void setMessageTypingFeature(MessageFeature messageFeature) {
        MessageBuilder.mergeCloudCustomData(this, TIMCommonConstants.MESSAGE_FEATURE_KEY, messageFeature);
    }

    public void setNeedReadReceipt(boolean z11) {
        V2TIMMessage v2TIMMessage2 = this.v2TIMMessage;
        if (v2TIMMessage2 != null) {
            v2TIMMessage2.setNeedReadReceipt(z11);
        }
    }

    public void setPeerRead(boolean z11) {
        this.peerRead = z11;
    }

    public void setRead(boolean z11) {
        this.read = z11;
    }

    public void setSelectText(String str) {
        this.selectText = str;
    }

    public void setShowTime(boolean z11) {
        this.isShowTime = z11;
    }

    public void setStatus(int i11) {
        this.status = i11;
    }

    public void setTranslation(String str) {
        V2TIMMessage v2TIMMessage2 = this.v2TIMMessage;
        if (v2TIMMessage2 != null) {
            String localCustomData = v2TIMMessage2.getLocalCustomData();
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(localCustomData)) {
                    jSONObject = new JSONObject(localCustomData);
                }
                jSONObject.put(TRANSLATION_KEY, str);
                jSONObject.put(TRANSLATION_VIEW_STATUS_KEY, 3);
                this.v2TIMMessage.setLocalCustomData(jSONObject.toString());
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
            this.translationStatus = 3;
        }
    }

    public void setTranslationStatus(int i11) {
        if ((i11 != 0 && i11 != 1 && i11 != 3 && i11 != 2) || i11 == this.translationStatus) {
            return;
        }
        if (i11 == 2) {
            this.translationStatus = 2;
            return;
        }
        this.translationStatus = i11;
        V2TIMMessage v2TIMMessage2 = this.v2TIMMessage;
        if (v2TIMMessage2 != null) {
            String localCustomData = v2TIMMessage2.getLocalCustomData();
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(localCustomData)) {
                    jSONObject = new JSONObject(localCustomData);
                }
                jSONObject.put(TRANSLATION_VIEW_STATUS_KEY, i11);
                this.v2TIMMessage.setLocalCustomData(jSONObject.toString());
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
        }
    }

    public void setUseMsgReceiverAvatar(boolean z11) {
        this.isUseMsgReceiverAvatar = z11;
    }

    public void setV2TIMMessage(V2TIMMessage v2TIMMessage2) {
        this.v2TIMMessage = v2TIMMessage2;
        setCommonAttribute(v2TIMMessage2);
        onProcessMessage(v2TIMMessage2);
    }

    public void update(TUIMessageBean tUIMessageBean) {
        setV2TIMMessage(tUIMessageBean.getV2TIMMessage());
    }
}
