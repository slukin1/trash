package wn;

import android.view.View;
import android.widget.ImageView;

public final /* synthetic */ class i implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p f61443b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImageView f61444c;

    public /* synthetic */ i(p pVar, ImageView imageView) {
        this.f61443b = pVar;
        this.f61444c = imageView;
    }

    public final void onClick(View view) {
        this.f61443b.C(this.f61444c, view);
    }
}
