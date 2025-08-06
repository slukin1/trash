package fk;

import android.content.Context;
import com.huobi.edgeengine.template.widget.Widget;
import com.huobi.edgeengine.widget.SeekBarWidget;
import com.huobi.view.seekbar.MultiConfigBuilder;

public final /* synthetic */ class t implements Widget.u {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MultiConfigBuilder f54697a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f54698b;

    public /* synthetic */ t(MultiConfigBuilder multiConfigBuilder, Context context) {
        this.f54697a = multiConfigBuilder;
        this.f54698b = context;
    }

    public final void a(String str) {
        SeekBarWidget.u0(this.f54697a, this.f54698b, str);
    }
}
