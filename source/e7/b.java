package e7;

import android.content.Context;
import android.view.View;
import com.hbg.lib.imsdk.BottomBarView;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BottomBarView f54280b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f54281c;

    public /* synthetic */ b(BottomBarView bottomBarView, Context context) {
        this.f54280b = bottomBarView;
        this.f54281c = context;
    }

    public final void onClick(View view) {
        this.f54280b.m(this.f54281c, view);
    }
}
