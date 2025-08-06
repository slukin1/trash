package fk;

import android.content.Context;
import com.huobi.edgeengine.template.widget.Widget;
import com.huobi.edgeengine.widget.SearchHistoryWidget;
import com.huobi.edgeengine.widget.view.FloatLayout;

public final /* synthetic */ class h implements Widget.u {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchHistoryWidget f54670a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f54671b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FloatLayout f54672c;

    public /* synthetic */ h(SearchHistoryWidget searchHistoryWidget, Context context, FloatLayout floatLayout) {
        this.f54670a = searchHistoryWidget;
        this.f54671b = context;
        this.f54672c = floatLayout;
    }

    public final void a(String str) {
        SearchHistoryWidget.e0(this.f54670a, this.f54671b, this.f54672c, str);
    }
}
