package xf;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.ShareGroupList;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f61535b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ShareGroupList.ShareGroup f61536c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f61537d;

    public /* synthetic */ a(c cVar, ShareGroupList.ShareGroup shareGroup, int i11) {
        this.f61535b = cVar;
        this.f61536c = shareGroup;
        this.f61537d = i11;
    }

    public final void onClick(View view) {
        c.p(this.f61535b, this.f61536c, this.f61537d, view);
    }
}
