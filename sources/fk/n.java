package fk;

import android.content.Context;
import com.huobi.edgeengine.template.widget.Widget;
import com.huobi.edgeengine.widget.SeekBarWidget;
import com.huobi.view.seekbar.MultiConfigBuilder;

public final /* synthetic */ class n implements Widget.u {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MultiConfigBuilder f54685a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f54686b;

    public /* synthetic */ n(MultiConfigBuilder multiConfigBuilder, Context context) {
        this.f54685a = multiConfigBuilder;
        this.f54686b = context;
    }

    public final void a(String str) {
        SeekBarWidget.q0(this.f54685a, this.f54686b, str);
    }
}
