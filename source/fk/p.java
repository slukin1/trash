package fk;

import android.content.Context;
import com.huobi.edgeengine.template.widget.Widget;
import com.huobi.edgeengine.widget.SeekBarWidget;
import com.huobi.view.seekbar.MultiConfigBuilder;

public final /* synthetic */ class p implements Widget.u {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MultiConfigBuilder f54689a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f54690b;

    public /* synthetic */ p(MultiConfigBuilder multiConfigBuilder, Context context) {
        this.f54689a = multiConfigBuilder;
        this.f54690b = context;
    }

    public final void a(String str) {
        SeekBarWidget.o0(this.f54689a, this.f54690b, str);
    }
}
