package com.huobi.webview2.ui;

import android.content.Intent;
import android.os.Bundle;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.huobi.login.bean.JumpTarget;
import i6.l;
import kn.a;

public class LoginWebActivity extends HBBaseWebActivity {

    /* renamed from: b  reason: collision with root package name */
    public a f20898b;

    /* renamed from: c  reason: collision with root package name */
    public JumpTarget f20899c;

    public void finish() {
        JumpTarget jumpTarget = this.f20899c;
        if (jumpTarget != null) {
            jumpTarget.back(getActivity());
            super.finish();
            return;
        }
        super.finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(8192, 8192);
        Intent intent = getActivity().getIntent();
        if (intent != null && intent.getExtras() != null && intent.getExtras().containsKey("target")) {
            a aVar = (a) intent.getExtras().get("target");
            this.f20898b = aVar;
            if (aVar instanceof JumpTarget) {
                this.f20899c = (JumpTarget) aVar;
            }
        }
    }

    public void setWebViewUserAgent() {
        this.mWebView.getSettings().setUserAgentString(l.f());
    }

    public a xh() {
        return this.f20898b;
    }
}
