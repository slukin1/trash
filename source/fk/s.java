package fk;

import android.content.Context;
import com.huobi.edgeengine.template.widget.Widget;
import com.huobi.edgeengine.widget.SeekBarWidget;
import com.huobi.view.seekbar.MultiConfigBuilder;

public final /* synthetic */ class s implements Widget.u {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MultiConfigBuilder f54695a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f54696b;

    public /* synthetic */ s(MultiConfigBuilder multiConfigBuilder, Context context) {
        this.f54695a = multiConfigBuilder;
        this.f54696b = context;
    }

    public final void a(String str) {
        SeekBarWidget.t0(this.f54695a, this.f54696b, str);
    }
}
