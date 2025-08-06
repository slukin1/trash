package lq;

import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.network.hbg.core.bean.ShareConfig;
import com.huobi.provider.HbgShareProver;
import d10.l;

public final /* synthetic */ class b implements l {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f58043b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f58044c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TextView f58045d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f58046e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f58047f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f58048g;

    public /* synthetic */ b(View view, String str, TextView textView, FragmentActivity fragmentActivity, String str2, String str3) {
        this.f58043b = view;
        this.f58044c = str;
        this.f58045d = textView;
        this.f58046e = fragmentActivity;
        this.f58047f = str2;
        this.f58048g = str3;
    }

    public final Object invoke(Object obj) {
        return HbgShareProver.w(this.f58043b, this.f58044c, this.f58045d, this.f58046e, this.f58047f, this.f58048g, (ShareConfig) obj);
    }
}
