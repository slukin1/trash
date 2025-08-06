package fk;

import android.view.View;
import com.huobi.edgeengine.widget.LottieWidget;
import vj.a;

public final /* synthetic */ class d implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieWidget f54664a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f54665b;

    public /* synthetic */ d(LottieWidget lottieWidget, View view) {
        this.f54664a = lottieWidget;
        this.f54665b = view;
    }

    public final void onCallback(Object obj) {
        LottieWidget.e0(this.f54664a, this.f54665b, obj);
    }
}
