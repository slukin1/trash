package com.tencent.qcloud.tuikit.timcommon.component;

import android.graphics.drawable.Drawable;
import com.tencent.qcloud.tuikit.timcommon.interfaces.IMessageProperties;
import com.tencent.qcloud.tuikit.timcommon.util.ScreenUtil;

public class MessageProperties implements IMessageProperties {
    private static MessageProperties sP = new MessageProperties();
    private int[] avatarSize = null;
    private int mAvatarId;
    private int mAvatarRadius;
    private int mChatContextFontSize;
    private Drawable mChatTimeBubble;
    private int mChatTimeFontColor;
    private int mChatTimeFontSize;
    private Drawable mFriendBubble;
    private int mFriendChatContentFontColor;
    private int mLeftNameVisibility;
    private Drawable mMyBubble;
    private int mMyChatContentFontColor;
    private int mNameFontColor;
    private int mNameFontSize;
    private int mRightNameVisibility;
    private Drawable mTipsMessageBubble;
    private int mTipsMessageFontColor;
    private int mTipsMessageFontSize;

    private MessageProperties() {
    }

    public static MessageProperties getInstance() {
        if (sP == null) {
            sP = new MessageProperties();
        }
        return sP;
    }

    public int getAvatar() {
        return this.mAvatarId;
    }

    public int getAvatarRadius() {
        return this.mAvatarRadius;
    }

    public int[] getAvatarSize() {
        return this.avatarSize;
    }

    public int getChatContextFontSize() {
        return this.mChatContextFontSize;
    }

    public Drawable getChatTimeBubble() {
        return this.mChatTimeBubble;
    }

    public int getChatTimeFontColor() {
        return this.mChatTimeFontColor;
    }

    public int getChatTimeFontSize() {
        return this.mChatTimeFontSize;
    }

    public Drawable getLeftBubble() {
        return this.mFriendBubble;
    }

    public int getLeftChatContentFontColor() {
        return this.mFriendChatContentFontColor;
    }

    public int getLeftNameVisibility() {
        return this.mLeftNameVisibility;
    }

    public int getNameFontColor() {
        return this.mNameFontColor;
    }

    public int getNameFontSize() {
        return this.mNameFontSize;
    }

    public Drawable getRightBubble() {
        return this.mMyBubble;
    }

    public int getRightChatContentFontColor() {
        return this.mMyChatContentFontColor;
    }

    public int getRightNameVisibility() {
        return this.mRightNameVisibility;
    }

    public Drawable getTipsMessageBubble() {
        return this.mTipsMessageBubble;
    }

    public int getTipsMessageFontColor() {
        return this.mTipsMessageFontColor;
    }

    public int getTipsMessageFontSize() {
        return this.mTipsMessageFontSize;
    }

    public void setAvatar(int i11) {
        this.mAvatarId = i11;
    }

    public void setAvatarRadius(int i11) {
        this.mAvatarRadius = ScreenUtil.getPxByDp((float) i11);
    }

    public void setAvatarSize(int[] iArr) {
        if (iArr != null && iArr.length == 2) {
            int[] iArr2 = new int[2];
            this.avatarSize = iArr2;
            iArr2[0] = ScreenUtil.getPxByDp((float) iArr[0]);
            this.avatarSize[1] = ScreenUtil.getPxByDp((float) iArr[1]);
        }
    }

    public void setChatContextFontSize(int i11) {
        this.mChatContextFontSize = i11;
    }

    public void setChatTimeBubble(Drawable drawable) {
        this.mChatTimeBubble = drawable;
    }

    public void setChatTimeFontColor(int i11) {
        this.mChatTimeFontColor = i11;
    }

    public void setChatTimeFontSize(int i11) {
        this.mChatTimeFontSize = i11;
    }

    public void setLeftBubble(Drawable drawable) {
        this.mFriendBubble = drawable;
    }

    public void setLeftChatContentFontColor(int i11) {
        this.mFriendChatContentFontColor = i11;
    }

    public void setLeftNameVisibility(int i11) {
        this.mLeftNameVisibility = i11;
    }

    public void setNameFontColor(int i11) {
        this.mNameFontColor = i11;
    }

    public void setNameFontSize(int i11) {
        this.mNameFontSize = i11;
    }

    public void setRightBubble(Drawable drawable) {
        this.mMyBubble = drawable;
    }

    public void setRightChatContentFontColor(int i11) {
        this.mMyChatContentFontColor = i11;
    }

    public void setRightNameVisibility(int i11) {
        this.mRightNameVisibility = i11;
    }

    public void setTipsMessageBubble(Drawable drawable) {
        this.mTipsMessageBubble = drawable;
    }

    public void setTipsMessageFontColor(int i11) {
        this.mTipsMessageFontColor = i11;
    }

    public void setTipsMessageFontSize(int i11) {
        this.mTipsMessageFontSize = i11;
    }
}
