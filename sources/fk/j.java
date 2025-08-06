package fk;

import android.content.Context;
import android.widget.ImageView;
import com.huobi.edgeengine.template.widget.Widget;
import com.huobi.edgeengine.widget.SearchHistoryWidget;
import com.huobi.edgeengine.widget.view.FloatLayout;

public final /* synthetic */ class j implements Widget.u {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FloatLayout f54676a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchHistoryWidget f54677b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImageView f54678c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Context f54679d;

    public /* synthetic */ j(FloatLayout floatLayout, SearchHistoryWidget searchHistoryWidget, ImageView imageView, Context context) {
        this.f54676a = floatLayout;
        this.f54677b = searchHistoryWidget;
        this.f54678c = imageView;
        this.f54679d = context;
    }

    public final void a(String str) {
        SearchHistoryWidget.g0(this.f54676a, this.f54677b, this.f54678c, this.f54679d, str);
    }
}
