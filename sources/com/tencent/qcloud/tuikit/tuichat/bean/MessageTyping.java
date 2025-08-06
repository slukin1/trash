package com.tencent.qcloud.tuikit.tuichat.bean;

import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import java.io.Serializable;

public class MessageTyping implements Serializable {
    public static final String EDIT_END = "EIMAMSG_InputStatus_End";
    public static final String EDIT_START = "EIMAMSG_InputStatus_Ing";
    public static final int TYPE_TYPING = 14;
    public String actionParam = "";
    public String businessID = TUIChatConstants.BUSINESS_ID_CUSTOM_TYPING;
    public int typingStatus = 0;
    public int userAction = 0;
    public int version = 0;

    public void setTypingStatus(boolean z11) {
        if (z11) {
            this.typingStatus = 1;
            this.userAction = 14;
            this.actionParam = EDIT_START;
            return;
        }
        this.typingStatus = 0;
        this.userAction = 0;
        this.actionParam = EDIT_END;
    }
}
