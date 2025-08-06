package com.huobi.edgeengine.template.widget.list;

import android.content.Context;
import com.huobi.edgeengine.template.widget.FrameWidget;
import java.util.Map;

public class CellWidget extends FrameWidget {

    /* renamed from: k0  reason: collision with root package name */
    public String f44247k0;

    /* renamed from: l0  reason: collision with root package name */
    public String f44248l0 = "type";

    /* renamed from: m0  reason: collision with root package name */
    public String f44249m0 = "i";

    public void C(Context context, Map<String, String> map) {
        super.C(context, map);
        this.f44247k0 = map.get(this.f44248l0);
    }

    public String d0() {
        return this.f44247k0;
    }
}
