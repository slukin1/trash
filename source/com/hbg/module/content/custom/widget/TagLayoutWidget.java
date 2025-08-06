package com.hbg.module.content.custom.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.hbg.module.content.custom.tag.TagLayout;
import com.huobi.edgeengine.template.widget.Widget;
import java.util.Map;
import kotlin.jvm.internal.r;
import rj.n;

public final class TagLayoutWidget extends Widget {

    /* renamed from: h0  reason: collision with root package name */
    public String f18199h0;

    public static final void Y(View view, String str) {
        Log.d("TagLayoutWidget", "data : " + str);
        ((TagLayout) view).setData(str);
    }

    public void C(Context context, Map<String, String> map) {
        super.C(context, map);
        this.f18199h0 = map != null ? map.get("data") : null;
    }

    public View Q(Context context, n nVar) {
        View Q = super.Q(context, nVar);
        if (Q instanceof TagLayout) {
            w(context, this.f18199h0, new g(Q), nVar);
        }
        return Q;
    }

    public View q(Context context) {
        return new TagLayout(context, (AttributeSet) null, 0, 6, (r) null);
    }
}
