package com.tencent.qcloud.tuikit.tuichat.bean;

import com.tencent.imsdk.v2.V2TIMGroupAtInfo;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ChatInfo implements Serializable {
    public static final int TYPE_C2C = 1;
    public static final int TYPE_GROUP = 2;
    public static final int TYPE_INVALID = 0;
    private static List<V2TIMGroupAtInfo> atInfoList;
    public String chatName;
    private DraftInfo draft;
    public String faceUrl;
    private String groupType;
    private List<Object> iconUrlList = new ArrayList();

    /* renamed from: id  reason: collision with root package name */
    private String f48586id;
    private boolean isTopChat;
    private TUIMessageBean locateMessage;
    private String messageId;
    private int type = 1;

    public List<V2TIMGroupAtInfo> getAtInfoList() {
        return atInfoList;
    }

    public String getChatName() {
        return this.chatName;
    }

    public DraftInfo getDraft() {
        return this.draft;
    }

    public String getFaceUrl() {
        return this.faceUrl;
    }

    public String getGroupType() {
        return this.groupType;
    }

    public List<Object> getIconUrlList() {
        return this.iconUrlList;
    }

    public String getId() {
        return this.f48586id;
    }

    public TUIMessageBean getLocateMessage() {
        return this.locateMessage;
    }

    public String getMsgId() {
        return this.messageId;
    }

    public int getType() {
        return this.type;
    }

    public boolean isTopChat() {
        return this.isTopChat;
    }

    public void setAtInfoList(List<V2TIMGroupAtInfo> list) {
        atInfoList = list;
    }

    public void setChatName(String str) {
        this.chatName = str;
    }

    public void setDraft(DraftInfo draftInfo) {
        this.draft = draftInfo;
    }

    public void setFaceUrl(String str) {
        this.faceUrl = str;
    }

    public void setGroupType(String str) {
        this.groupType = str;
    }

    public void setIconUrlList(List<Object> list) {
        this.iconUrlList = list;
    }

    public void setId(String str) {
        this.f48586id = str;
    }

    public void setLocateMessage(TUIMessageBean tUIMessageBean) {
        this.locateMessage = tUIMessageBean;
    }

    public void setMsgId(String str) {
        this.messageId = str;
    }

    public void setTopChat(boolean z11) {
        this.isTopChat = z11;
    }

    public void setType(int i11) {
        this.type = i11;
    }
}
