package fk;

import android.content.Context;
import android.widget.TextView;
import com.huobi.edgeengine.template.widget.Widget;
import com.huobi.edgeengine.widget.LightingAnimationWidget;

public final /* synthetic */ class b implements Widget.u {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TextView f54658a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LightingAnimationWidget f54659b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f54660c;

    public /* synthetic */ b(TextView textView, LightingAnimationWidget lightingAnimationWidget, Context context) {
        this.f54658a = textView;
        this.f54659b = lightingAnimationWidget;
        this.f54660c = context;
    }

    public final void a(String str) {
        LightingAnimationWidget.d0(this.f54658a, this.f54659b, this.f54660c, str);
    }
}
