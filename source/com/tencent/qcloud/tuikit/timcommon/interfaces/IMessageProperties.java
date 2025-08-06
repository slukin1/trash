package com.tencent.qcloud.tuikit.timcommon.interfaces;

import android.graphics.drawable.Drawable;

public interface IMessageProperties {
    int getAvatar();

    int getAvatarRadius();

    int[] getAvatarSize();

    int getChatContextFontSize();

    Drawable getChatTimeBubble();

    int getChatTimeFontColor();

    int getChatTimeFontSize();

    Drawable getLeftBubble();

    int getLeftChatContentFontColor();

    int getLeftNameVisibility();

    int getNameFontColor();

    int getNameFontSize();

    Drawable getRightBubble();

    int getRightChatContentFontColor();

    int getRightNameVisibility();

    Drawable getTipsMessageBubble();

    int getTipsMessageFontColor();

    int getTipsMessageFontSize();

    void setAvatar(int i11);

    void setAvatarRadius(int i11);

    void setAvatarSize(int[] iArr);

    void setChatContextFontSize(int i11);

    void setChatTimeBubble(Drawable drawable);

    void setChatTimeFontColor(int i11);

    void setChatTimeFontSize(int i11);

    void setLeftBubble(Drawable drawable);

    void setLeftChatContentFontColor(int i11);

    void setLeftNameVisibility(int i11);

    void setNameFontColor(int i11);

    void setNameFontSize(int i11);

    void setRightBubble(Drawable drawable);

    void setRightChatContentFontColor(int i11);

    void setRightNameVisibility(int i11);

    void setTipsMessageBubble(Drawable drawable);

    void setTipsMessageFontColor(int i11);

    void setTipsMessageFontSize(int i11);
}
