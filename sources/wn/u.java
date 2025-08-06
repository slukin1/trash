package wn;

import android.view.View;
import android.widget.ImageView;

public final /* synthetic */ class u implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b0 f61482b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImageView f61483c;

    public /* synthetic */ u(b0 b0Var, ImageView imageView) {
        this.f61482b = b0Var;
        this.f61483c = imageView;
    }

    public final void onClick(View view) {
        this.f61482b.H(this.f61483c, view);
    }
}
