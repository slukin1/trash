package com.zopim.android.sdk.model.items;

import com.zopim.android.sdk.model.items.RowItem;

public class VisitorMessage extends VisitorItem<VisitorMessage> {
    private String message;

    public VisitorMessage() {
        super.setType(RowItem.Type.VISITOR_MESSAGE);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VisitorMessage) || !super.equals(obj)) {
            return false;
        }
        String str = this.message;
        String str2 = ((VisitorMessage) obj).message;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public String getMessage() {
        String str = this.message;
        return str != null ? str : "";
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.message;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String toString() {
        return "msg:" + this.message + super.toString();
    }

    public void update(VisitorMessage visitorMessage) {
        super.update(visitorMessage);
        this.message = visitorMessage.message;
    }
}
