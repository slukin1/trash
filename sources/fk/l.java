package fk;

import android.content.Context;
import com.huobi.edgeengine.template.widget.Widget;
import com.huobi.edgeengine.widget.SeekBarWidget;
import com.huobi.view.seekbar.MultiConfigBuilder;

public final /* synthetic */ class l implements Widget.u {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MultiConfigBuilder f54681a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f54682b;

    public /* synthetic */ l(MultiConfigBuilder multiConfigBuilder, Context context) {
        this.f54681a = multiConfigBuilder;
        this.f54682b = context;
    }

    public final void a(String str) {
        SeekBarWidget.s0(this.f54681a, this.f54682b, str);
    }
}
