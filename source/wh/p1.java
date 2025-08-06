package wh;

import android.view.View;
import com.alibaba.fastjson.JSONObject;
import fi.t;

public final /* synthetic */ class p1 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ q1 f61330b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ t f61331c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f61332d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ JSONObject f61333e;

    public /* synthetic */ p1(q1 q1Var, t tVar, int i11, JSONObject jSONObject) {
        this.f61330b = q1Var;
        this.f61331c = tVar;
        this.f61332d = i11;
        this.f61333e = jSONObject;
    }

    public final void onClick(View view) {
        this.f61330b.j(this.f61331c, this.f61332d, this.f61333e, view);
    }
}
