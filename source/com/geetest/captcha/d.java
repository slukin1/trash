package com.geetest.captcha;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.geetest.captcha.GTCaptcha4Client;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0012\u0010\u001b\u001a\u00020\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\u0013H\u0002J\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\fH\u0016J\u0010\u0010\u001f\u001a\u00020\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\u0013J\u0010\u0010 \u001a\u00020\u00152\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\r\u0010!\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\"J\b\u0010#\u001a\u00020\u0015H\u0016R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/geetest/captcha/dialog/GTC4Dialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dialogStyle", "", "(Landroid/content/Context;Ljava/lang/String;)V", "themeResId", "", "(Landroid/content/Context;I)V", "cancelable", "", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "(Landroid/content/Context;ZLandroid/content/DialogInterface$OnCancelListener;)V", "dialogShowListener", "Lcom/geetest/captcha/GTCaptcha4Client$OnDialogShowListener;", "webView", "Landroid/view/View;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onInflaterView", "inflater", "Landroid/view/LayoutInflater;", "onInitView", "view", "onWindowFocusChanged", "hasFocus", "setContent", "setDialogShowListener", "setScreenAttributes", "setScreenAttributes$captcha_release", "show", "captcha_release"}, k = 1, mv = {1, 1, 16})
public final class d extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public View f65227a;

    /* renamed from: b  reason: collision with root package name */
    public GTCaptcha4Client.OnDialogShowListener f65228b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(Context context) {
        super(context, af.b(context, "gt4_captcha_dialog_style"));
        af afVar = af.f65176a;
    }

    public final void a() {
        Window window = getWindow();
        if (window != null) {
            window.addFlags(1280);
        }
        Window window2 = getWindow();
        Integer num = null;
        WindowManager.LayoutParams attributes = window2 != null ? window2.getAttributes() : null;
        ab abVar = ab.f65159a;
        int a11 = ab.a(getContext());
        int b11 = ab.b(getContext());
        if (attributes != null) {
            attributes.width = a11;
        }
        if (attributes != null) {
            attributes.height = b11;
        }
        ag agVar = ag.f65177a;
        StringBuilder sb2 = new StringBuilder("ScreenWidth: ");
        sb2.append(a11);
        sb2.append(", ScreenHeight: ");
        sb2.append(b11);
        sb2.append(", DialogWidth: ");
        sb2.append(attributes != null ? Integer.valueOf(attributes.width) : null);
        sb2.append(", DialogHeight: ");
        if (attributes != null) {
            num = Integer.valueOf(attributes.height);
        }
        sb2.append(num);
        ag.b(sb2.toString());
        if (attributes != null) {
            attributes.gravity = 17;
        }
        Window window3 = getWindow();
        if (window3 != null) {
            window3.setAttributes(attributes);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LayoutInflater.from(getContext());
        View view = this.f65227a;
        if (view != null) {
            setContentView(view);
        }
    }

    public final void onWindowFocusChanged(boolean z11) {
        GTCaptcha4Client.OnDialogShowListener onDialogShowListener = this.f65228b;
        if (onDialogShowListener != null) {
            onDialogShowListener.onDialogFocusChanged(this, z11);
        }
    }

    public final void show() {
        GTCaptcha4Client.OnDialogShowListener onDialogShowListener = this.f65228b;
        if (onDialogShowListener != null) {
            onDialogShowListener.actionBeforeDialogShow(this);
        }
        super.show();
        GTCaptcha4Client.OnDialogShowListener onDialogShowListener2 = this.f65228b;
        if (onDialogShowListener2 != null) {
            onDialogShowListener2.actionAfterDialogShow(this);
        }
        a();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(Context context, String str) {
        super(context, af.b(context, str));
        af afVar = af.f65176a;
    }
}
