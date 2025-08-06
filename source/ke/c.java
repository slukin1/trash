package ke;

import android.view.View;
import com.hbg.module.libkt.custom.PicView;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PicView f56560b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f56561c;

    public /* synthetic */ c(PicView picView, int i11) {
        this.f56560b = picView;
        this.f56561c = i11;
    }

    public final void onClick(View view) {
        PicView.c(this.f56560b, this.f56561c, view);
    }
}
