package fk;

import android.content.Context;
import android.widget.TextView;
import com.huobi.edgeengine.template.widget.Widget;
import com.huobi.edgeengine.widget.LightingAnimationWidget;

public final /* synthetic */ class c implements Widget.u {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LightingAnimationWidget f54661a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f54662b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TextView f54663c;

    public /* synthetic */ c(LightingAnimationWidget lightingAnimationWidget, Context context, TextView textView) {
        this.f54661a = lightingAnimationWidget;
        this.f54662b = context;
        this.f54663c = textView;
    }

    public final void a(String str) {
        LightingAnimationWidget.c0(this.f54661a, this.f54662b, this.f54663c, str);
    }
}
