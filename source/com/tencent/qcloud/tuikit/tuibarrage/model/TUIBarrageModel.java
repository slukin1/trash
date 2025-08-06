package com.tencent.qcloud.tuikit.tuibarrage.model;

import java.util.HashMap;

public class TUIBarrageModel {
    public HashMap<String, String> extInfo = new HashMap<>();
    public String faceUrl;
    public String groupId;
    public boolean isSelf;
    public String message;
    public String msgId;
    public long msgSeq;
    public String nickName;
    public String sender;
    public int status;
    public long timestamp;

    public String toString() {
        return "TUIBarrageModel{message='" + this.message + '\'' + '}';
    }
}
