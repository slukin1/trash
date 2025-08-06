package com.huobi.login.bean;

import android.content.Context;
import android.os.Parcel;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import java.io.Serializable;
import kn.a;

public class WebTarget implements a, Serializable {
    private static final long serialVersionUID = 5620774165925992463L;
    private boolean isAuth;
    private String title;
    private String titleBack;
    private String url;

    public WebTarget(String str, String str2, String str3, boolean z11) {
        this.title = str;
        this.url = str2;
        this.titleBack = str3;
        this.isAuth = z11;
    }

    public boolean allowTrader() {
        return false;
    }

    public void show(Context context) {
        HBBaseWebActivity.showWebView(context, this.url, this.title, this.titleBack, this.isAuth);
    }

    public WebTarget(Parcel parcel) {
        this.title = parcel.readString();
        this.url = parcel.readString();
        this.titleBack = parcel.readString();
        this.isAuth = ((Boolean) parcel.readSerializable()).booleanValue();
    }
}
