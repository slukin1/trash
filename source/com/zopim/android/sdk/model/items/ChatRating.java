package com.zopim.android.sdk.model.items;

import com.zopim.android.sdk.model.ChatLog;
import com.zopim.android.sdk.model.items.RowItem;

public class ChatRating extends RowItem<ChatRating> implements Disableable {
    private String comment;
    private boolean disabled;
    private ChatLog.Rating rating = ChatLog.Rating.UNKNOWN;

    public ChatRating() {
        super.setType(RowItem.Type.CHAT_RATING);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatRating) || !super.equals(obj)) {
            return false;
        }
        ChatRating chatRating = (ChatRating) obj;
        if (this.disabled != chatRating.disabled || this.rating != chatRating.rating) {
            return false;
        }
        String str = this.comment;
        String str2 = chatRating.comment;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public String getComment() {
        String str = this.comment;
        return str != null ? str : "";
    }

    public ChatLog.Rating getRating() {
        ChatLog.Rating rating2 = this.rating;
        return rating2 != null ? rating2 : ChatLog.Rating.UNKNOWN;
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        ChatLog.Rating rating2 = this.rating;
        int i11 = 0;
        int hashCode2 = (hashCode + (rating2 != null ? rating2.hashCode() : 0)) * 31;
        String str = this.comment;
        if (str != null) {
            i11 = str.hashCode();
        }
        return ((hashCode2 + i11) * 31) + (this.disabled ? 1 : 0);
    }

    public boolean isDisabled() {
        return this.disabled;
    }

    public void setComment(String str) {
        this.comment = str;
    }

    public void setDisabled(boolean z11) {
        this.disabled = z11;
    }

    public void setRating(ChatLog.Rating rating2) {
        this.rating = rating2;
    }

    public String toString() {
        return "rating:" + this.rating + " comment:" + this.comment + super.toString();
    }

    public void update(ChatRating chatRating) {
        super.update(chatRating);
        this.rating = chatRating.rating;
        this.comment = chatRating.comment;
        this.disabled = chatRating.disabled;
    }
}
