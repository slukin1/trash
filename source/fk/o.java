package fk;

import android.content.Context;
import com.huobi.edgeengine.template.widget.Widget;
import com.huobi.edgeengine.widget.SeekBarWidget;
import com.huobi.view.seekbar.MultiConfigBuilder;

public final /* synthetic */ class o implements Widget.u {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MultiConfigBuilder f54687a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f54688b;

    public /* synthetic */ o(MultiConfigBuilder multiConfigBuilder, Context context) {
        this.f54687a = multiConfigBuilder;
        this.f54688b = context;
    }

    public final void a(String str) {
        SeekBarWidget.v0(this.f54687a, this.f54688b, str);
    }
}
