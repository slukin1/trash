package com.hbg.module.content.custom.widget;

import android.content.Context;
import android.view.View;
import com.huobi.edgeengine.template.widget.Widget;

public final /* synthetic */ class f implements Widget.u {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RichTextWidget f18220a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f18221b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f18222c;

    public /* synthetic */ f(RichTextWidget richTextWidget, Context context, View view) {
        this.f18220a = richTextWidget;
        this.f18221b = context;
        this.f18222c = view;
    }

    public final void a(String str) {
        RichTextWidget.e0(this.f18220a, this.f18221b, this.f18222c, str);
    }
}
