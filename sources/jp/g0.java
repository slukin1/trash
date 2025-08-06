package jp;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import com.huobi.view.OtcHeavyBubbleDialog;
import jp.h0;

public final /* synthetic */ class g0 implements OtcHeavyBubbleDialog.Builder.OnDialogClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h0 f56016a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f56017b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ h0.c f56018c;

    public /* synthetic */ g0(h0 h0Var, Context context, h0.c cVar) {
        this.f56016a = h0Var;
        this.f56017b = context;
        this.f56018c = cVar;
    }

    public final void onDialogClick(DialogFragment dialogFragment, View view) {
        this.f56016a.f(this.f56017b, this.f56018c, dialogFragment, view);
    }
}
