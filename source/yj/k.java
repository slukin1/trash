package yj;

import com.huobi.edgeengine.template.widget.Widget;
import java.util.List;
import vj.a;

public final /* synthetic */ class k implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f61757a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f61758b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f61759c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Widget.u f61760d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ StringBuffer f61761e;

    public /* synthetic */ k(List list, int i11, String str, Widget.u uVar, StringBuffer stringBuffer) {
        this.f61757a = list;
        this.f61758b = i11;
        this.f61759c = str;
        this.f61760d = uVar;
        this.f61761e = stringBuffer;
    }

    public final void onCallback(Object obj) {
        Widget.D(this.f61757a, this.f61758b, this.f61759c, this.f61760d, this.f61761e, obj);
    }
}
