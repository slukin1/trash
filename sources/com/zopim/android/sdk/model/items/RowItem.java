package com.zopim.android.sdk.model.items;

import com.zopim.android.sdk.model.items.RowItem;

public abstract class RowItem<T extends RowItem> implements Comparable<RowItem>, Updatable<T> {
    private String displayName;

    /* renamed from: id  reason: collision with root package name */
    private String f53464id;
    private String participantId;
    private Long timestamp;
    private Type type = Type.UNKNOWN;

    public enum Type {
        UNKNOWN(-1),
        VISITOR_MESSAGE(0),
        VISITOR_ATTACHMENT(1),
        AGENT_MESSAGE(2),
        AGENT_TYPING(3),
        AGENT_ATTACHMENT(4),
        AGENT_OPTIONS(5),
        CHAT_EVENT(6),
        MEMBER_EVENT(7),
        CHAT_RATING(8);
        
        public final int value;

        private Type(int i11) {
            this.value = i11;
        }

        public static Type getType(int i11) {
            for (Type type : values()) {
                if (type.getValue() == i11) {
                    return type;
                }
            }
            return UNKNOWN;
        }

        public int getValue() {
            return this.value;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RowItem)) {
            return false;
        }
        RowItem rowItem = (RowItem) obj;
        String str = this.f53464id;
        if (str == null ? rowItem.f53464id != null : !str.equals(rowItem.f53464id)) {
            return false;
        }
        if (this.type != rowItem.type) {
            return false;
        }
        String str2 = this.displayName;
        if (str2 == null ? rowItem.displayName != null : !str2.equals(rowItem.displayName)) {
            return false;
        }
        String str3 = this.participantId;
        if (str3 == null ? rowItem.participantId != null : !str3.equals(rowItem.participantId)) {
            return false;
        }
        Long l11 = this.timestamp;
        Long l12 = rowItem.timestamp;
        if (l11 != null) {
            return l11.equals(l12);
        }
        if (l12 == null) {
            return true;
        }
        return false;
    }

    public String getDisplayName() {
        String str = this.displayName;
        return str != null ? str : "";
    }

    public String getId() {
        String str = this.f53464id;
        return str != null ? str : "";
    }

    public String getParticipantId() {
        String str = this.participantId;
        return str != null ? str : "";
    }

    public Long getTimestamp() {
        Long l11 = this.timestamp;
        return Long.valueOf(l11 != null ? l11.longValue() : -1);
    }

    public Type getType() {
        Type type2 = this.type;
        return type2 != null ? type2 : Type.UNKNOWN;
    }

    public int hashCode() {
        String str = this.f53464id;
        int i11 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Type type2 = this.type;
        int hashCode2 = (hashCode + (type2 != null ? type2.hashCode() : 0)) * 31;
        String str2 = this.displayName;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.participantId;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Long l11 = this.timestamp;
        if (l11 != null) {
            i11 = l11.hashCode();
        }
        return hashCode4 + i11;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public void setId(String str) {
        this.f53464id = str;
    }

    public void setParticipantId(String str) {
        this.participantId = str;
    }

    public void setTimestamp(Long l11) {
        this.timestamp = l11;
    }

    public void setType(Type type2) {
        this.type = type2;
    }

    public String toString() {
        return " type:" + this.type + " dispName:" + this.displayName + " participant:" + this.participantId + " id:" + this.f53464id + " ts:" + this.timestamp;
    }

    public int compareTo(RowItem rowItem) throws NullPointerException {
        Long l11 = this.timestamp;
        if (l11 == null) {
            return rowItem.timestamp == null ? 0 : -1;
        }
        return l11.compareTo(rowItem.timestamp);
    }

    public void update(T t11) {
        this.f53464id = t11.getId();
        this.type = t11.getType();
        this.displayName = t11.getDisplayName();
        this.participantId = t11.getParticipantId();
        this.timestamp = t11.getTimestamp();
    }
}
