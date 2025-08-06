package com.huobi.edgeengine.template.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.huobi.edgeengine.node.trace.ArrayListener;
import com.huobi.edgeengine.node.trace.TraceMap;
import com.huobi.edgeengine.template.widget.list.CellWidget;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import rj.n;
import yj.d;

public class ForWidget extends ContainerWidget {

    /* renamed from: i0  reason: collision with root package name */
    public String f44071i0 = "item";

    /* renamed from: j0  reason: collision with root package name */
    public String f44072j0 = "i";

    /* renamed from: k0  reason: collision with root package name */
    public String f44073k0 = "type";

    /* renamed from: l0  reason: collision with root package name */
    public String f44074l0;

    /* renamed from: m0  reason: collision with root package name */
    public String f44075m0;

    /* renamed from: n0  reason: collision with root package name */
    public String f44076n0;

    /* renamed from: o0  reason: collision with root package name */
    public List<ArrayListener.a> f44077o0 = new ArrayList();

    /* renamed from: p0  reason: collision with root package name */
    public List<CellWidget> f44078p0 = new ArrayList();

    public static /* synthetic */ void a0(ArrayListener.a aVar, int i11, List list, List list2) {
        if (aVar != null) {
            aVar.a(i11, list, list2);
        }
    }

    public void C(Context context, Map<String, String> map) {
        super.C(context, map);
        String str = map.get("itemKey");
        this.f44071i0 = str;
        if (TextUtils.isEmpty(str)) {
            this.f44071i0 = "item";
        }
        String str2 = map.get("typeKey");
        this.f44073k0 = str2;
        if (TextUtils.isEmpty(str2)) {
            this.f44073k0 = "type";
        }
        String str3 = map.get("data");
        this.f44074l0 = str3;
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        if (this.f44074l0.startsWith(TIMMentionEditText.TIM_MENTION_TAG)) {
            int indexOf = this.f44074l0.indexOf(InstructionFileId.DOT);
            if (indexOf > 0) {
                this.f44076n0 = this.f44074l0.substring(1, indexOf);
                this.f44075m0 = this.f44074l0.substring(indexOf + 1);
                return;
            }
            return;
        }
        this.f44075m0 = this.f44074l0;
    }

    public void X(Widget widget) {
        if (widget instanceof CellWidget) {
            this.f44078p0.add((CellWidget) widget);
        }
    }

    public List<Pair<Widget, n>> Z(n nVar) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(this.f44075m0)) {
            return arrayList;
        }
        String str = this.f44076n0;
        if (TextUtils.isEmpty(str)) {
            str = nVar.f47793e;
        }
        for (int i11 = 0; i11 < nVar.q(this.f44075m0, str); i11++) {
            n p11 = nVar.p(this.f44071i0, this.f44075m0, i11, str);
            if (this.f44078p0.size() == 1) {
                arrayList.add(new Pair(this.f44078p0.get(0), p11));
            } else {
                for (CellWidget next : this.f44078p0) {
                    if (TextUtils.equals(next.d0(), p11.s(this.f44073k0))) {
                        arrayList.add(new Pair(next, p11));
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: b0 */
    public ViewGroup Q(Context context, n nVar) {
        return null;
    }

    public TraceMap.a c0(Context context, n nVar, ArrayListener.a aVar) {
        if (TextUtils.isEmpty(this.f44075m0) || aVar == null) {
            return null;
        }
        String str = this.f44076n0;
        if (TextUtils.isEmpty(str)) {
            str = nVar.f47793e;
        }
        return nVar.G(this.f44075m0, new d(aVar), str);
    }

    public View q(Context context) {
        return null;
    }
}
