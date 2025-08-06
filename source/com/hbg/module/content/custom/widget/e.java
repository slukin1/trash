package com.hbg.module.content.custom.widget;

import android.content.Context;
import android.view.View;
import com.huobi.edgeengine.template.widget.Widget;

public final /* synthetic */ class e implements Widget.u {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f18217a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RichTextWidget f18218b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f18219c;

    public /* synthetic */ e(View view, RichTextWidget richTextWidget, Context context) {
        this.f18217a = view;
        this.f18218b = richTextWidget;
        this.f18219c = context;
    }

    public final void a(String str) {
        RichTextWidget.f0(this.f18217a, this.f18218b, this.f18219c, str);
    }
}
