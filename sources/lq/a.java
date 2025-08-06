package lq;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import cf.b;
import com.huobi.provider.HbgShareProver;

public final /* synthetic */ class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f58040a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f58041b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f58042c;

    public /* synthetic */ a(View view, FragmentActivity fragmentActivity, String str) {
        this.f58040a = view;
        this.f58041b = fragmentActivity;
        this.f58042c = str;
    }

    public final void a(boolean z11) {
        HbgShareProver.v(this.f58040a, this.f58041b, this.f58042c, z11);
    }
}
