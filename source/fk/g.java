package fk;

import android.view.View;
import android.widget.ImageView;
import com.huobi.edgeengine.widget.SearchHistoryWidget;
import com.huobi.edgeengine.widget.view.FloatLayout;

public final /* synthetic */ class g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FloatLayout f54668b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImageView f54669c;

    public /* synthetic */ g(FloatLayout floatLayout, ImageView imageView) {
        this.f54668b = floatLayout;
        this.f54669c = imageView;
    }

    public final void onClick(View view) {
        SearchHistoryWidget.f0(this.f54668b, this.f54669c, view);
    }
}
