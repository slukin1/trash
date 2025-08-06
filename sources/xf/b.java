package xf;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.ShareGroupList;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f61538b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ShareGroupList.ShareGroup f61539c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f61540d;

    public /* synthetic */ b(c cVar, ShareGroupList.ShareGroup shareGroup, int i11) {
        this.f61538b = cVar;
        this.f61539c = shareGroup;
        this.f61540d = i11;
    }

    public final void onClick(View view) {
        c.q(this.f61538b, this.f61539c, this.f61540d, view);
    }
}
