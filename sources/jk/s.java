package jk;

import android.view.View;
import com.huobi.engineutils.widget.SortSelectWidget;
import rj.n;

public final /* synthetic */ class s implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SortSelectWidget f55985b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ n f55986c;

    public /* synthetic */ s(SortSelectWidget sortSelectWidget, n nVar) {
        this.f55985b = sortSelectWidget;
        this.f55986c = nVar;
    }

    public final void onClick(View view) {
        this.f55985b.H(this.f55986c, view);
    }
}
