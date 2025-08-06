package yj;

import android.widget.TextView;
import com.huobi.edgeengine.template.widget.TextWidget;
import rj.n;
import sj.c;

public final /* synthetic */ class h implements c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TextWidget.k f61749a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f61750b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f61751c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TextView f61752d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ n.c f61753e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ n f61754f;

    public /* synthetic */ h(TextWidget.k kVar, String str, int i11, TextView textView, n.c cVar, n nVar) {
        this.f61749a = kVar;
        this.f61750b = str;
        this.f61751c = i11;
        this.f61752d = textView;
        this.f61753e = cVar;
        this.f61754f = nVar;
    }

    public final void callback(String str) {
        this.f61749a.b(this.f61750b, this.f61751c, this.f61752d, this.f61753e, this.f61754f, str);
    }
}
