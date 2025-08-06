package fk;

import android.content.Context;
import com.huobi.edgeengine.template.widget.Widget;
import com.huobi.edgeengine.widget.SeekBarWidget;
import com.huobi.view.seekbar.MultiConfigBuilder;

public final /* synthetic */ class m implements Widget.u {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MultiConfigBuilder f54683a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f54684b;

    public /* synthetic */ m(MultiConfigBuilder multiConfigBuilder, Context context) {
        this.f54683a = multiConfigBuilder;
        this.f54684b = context;
    }

    public final void a(String str) {
        SeekBarWidget.n0(this.f54683a, this.f54684b, str);
    }
}
