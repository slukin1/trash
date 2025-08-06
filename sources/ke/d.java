package ke;

import android.view.View;
import com.hbg.module.libkt.custom.PicView;

public final /* synthetic */ class d implements View.OnLongClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f56562b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PicView f56563c;

    public /* synthetic */ d(int i11, PicView picView) {
        this.f56562b = i11;
        this.f56563c = picView;
    }

    public final boolean onLongClick(View view) {
        return PicView.d(this.f56562b, this.f56563c, view);
    }
}
