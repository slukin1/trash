package fk;

import android.content.Context;
import com.huobi.edgeengine.template.widget.Widget;
import com.huobi.edgeengine.widget.SeekBarWidget;
import com.huobi.view.seekbar.MultiConfigBuilder;

public final /* synthetic */ class q implements Widget.u {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MultiConfigBuilder f54691a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f54692b;

    public /* synthetic */ q(MultiConfigBuilder multiConfigBuilder, Context context) {
        this.f54691a = multiConfigBuilder;
        this.f54692b = context;
    }

    public final void a(String str) {
        SeekBarWidget.p0(this.f54691a, this.f54692b, str);
    }
}
