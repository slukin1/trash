package com.hbg.module.livesquare.bean;

import android.view.View;
import com.hbg.module.livesquare.viewholder.LiveDialogGetGiftHandler;
import java.io.Serializable;

public class LiveGetGiftInfo implements Serializable, s9.a {
    private static final long serialVersionUID = 8022057565578412135L;
    public String buttonText;
    public a callback;
    public String content;
    public String contentTips;
    public int iconRes;
    public int type;

    public interface a {
        void a(View view, LiveGetGiftInfo liveGetGiftInfo);
    }

    public LiveGetGiftInfo(int i11, int i12, String str, String str2, String str3, a aVar) {
        this.type = i11;
        this.iconRes = i12;
        this.content = str;
        this.contentTips = str2;
        this.buttonText = str3;
        this.callback = aVar;
    }

    public String getViewHandlerName() {
        return LiveDialogGetGiftHandler.class.getName();
    }
}
