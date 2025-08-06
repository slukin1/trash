package ef;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.LiveSquareBaseData;
import ef.b;

public final /* synthetic */ class k implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b.a f54323b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LiveSquareBaseData f54324c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f54325d;

    public /* synthetic */ k(b.a aVar, LiveSquareBaseData liveSquareBaseData, int i11) {
        this.f54323b = aVar;
        this.f54324c = liveSquareBaseData;
        this.f54325d = i11;
    }

    public final void onClick(View view) {
        l.i(this.f54323b, this.f54324c, this.f54325d, view);
    }
}
