package fk;

import android.content.Context;
import com.huobi.edgeengine.template.widget.Widget;
import com.huobi.edgeengine.widget.SearchHistoryWidget;
import com.huobi.edgeengine.widget.view.FloatLayout;

public final /* synthetic */ class i implements Widget.u {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchHistoryWidget f54673a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f54674b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FloatLayout f54675c;

    public /* synthetic */ i(SearchHistoryWidget searchHistoryWidget, Context context, FloatLayout floatLayout) {
        this.f54673a = searchHistoryWidget;
        this.f54674b = context;
        this.f54675c = floatLayout;
    }

    public final void a(String str) {
        SearchHistoryWidget.d0(this.f54673a, this.f54674b, this.f54675c, str);
    }
}
