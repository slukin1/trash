package com.hbg.module.content.custom.widget;

import android.content.Context;
import com.huobi.edgeengine.template.widget.FrameWidget;
import java.util.Map;
import kotlin.jvm.internal.r;

public final class TagCellWidget extends FrameWidget {

    /* renamed from: n0  reason: collision with root package name */
    public static final a f18195n0 = new a((r) null);

    /* renamed from: k0  reason: collision with root package name */
    public String f18196k0;

    /* renamed from: l0  reason: collision with root package name */
    public String f18197l0 = "type";

    /* renamed from: m0  reason: collision with root package name */
    public String f18198m0 = "i";

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public void C(Context context, Map<String, String> map) {
        super.C(context, map);
        this.f18196k0 = map != null ? map.get(this.f18197l0) : null;
    }

    public final String d0() {
        return this.f18196k0;
    }
}
