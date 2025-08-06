package bj;

import android.view.View;
import bj.q2;
import com.huobi.feature.ui.LeverSelectDialogFragment;
import java.util.Map;

public final /* synthetic */ class n2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ q2.a f12465b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Map f12466c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ LeverSelectDialogFragment f12467d;

    public /* synthetic */ n2(q2.a aVar, Map map, LeverSelectDialogFragment leverSelectDialogFragment) {
        this.f12465b = aVar;
        this.f12466c = map;
        this.f12467d = leverSelectDialogFragment;
    }

    public final void onClick(View view) {
        this.f12465b.f(this.f12466c, this.f12467d, view);
    }
}
