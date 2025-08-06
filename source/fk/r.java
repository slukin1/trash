package fk;

import android.content.Context;
import com.huobi.edgeengine.template.widget.Widget;
import com.huobi.edgeengine.widget.SeekBarWidget;
import com.huobi.view.seekbar.MultiConfigBuilder;

public final /* synthetic */ class r implements Widget.u {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MultiConfigBuilder f54693a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f54694b;

    public /* synthetic */ r(MultiConfigBuilder multiConfigBuilder, Context context) {
        this.f54693a = multiConfigBuilder;
        this.f54694b = context;
    }

    public final void a(String str) {
        SeekBarWidget.r0(this.f54693a, this.f54694b, str);
    }
}
