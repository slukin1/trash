package ef;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.LiveSquareBaseData;
import ef.b;

public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b.a f54317b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LiveSquareBaseData f54318c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f54319d;

    public /* synthetic */ e(b.a aVar, LiveSquareBaseData liveSquareBaseData, int i11) {
        this.f54317b = aVar;
        this.f54318c = liveSquareBaseData;
        this.f54319d = i11;
    }

    public final void onClick(View view) {
        g.p(this.f54317b, this.f54318c, this.f54319d, view);
    }
}
