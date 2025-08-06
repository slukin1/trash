package ef;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.LiveSquareBaseData;
import ef.b;

public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b.a f54320b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LiveSquareBaseData f54321c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f54322d;

    public /* synthetic */ f(b.a aVar, LiveSquareBaseData liveSquareBaseData, int i11) {
        this.f54320b = aVar;
        this.f54321c = liveSquareBaseData;
        this.f54322d = i11;
    }

    public final void onClick(View view) {
        g.o(this.f54320b, this.f54321c, this.f54322d, view);
    }
}
