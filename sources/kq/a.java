package kq;

import android.view.View;
import android.widget.TextView;
import com.huobi.points.viewhandler.PointsBuyCurrencyViewHandler;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f57970b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ gq.a f57971c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TextView f57972d;

    public /* synthetic */ a(int i11, gq.a aVar, TextView textView) {
        this.f57970b = i11;
        this.f57971c = aVar;
        this.f57972d = textView;
    }

    public final void onClick(View view) {
        PointsBuyCurrencyViewHandler.d(this.f57970b, this.f57971c, this.f57972d, view);
    }
}
