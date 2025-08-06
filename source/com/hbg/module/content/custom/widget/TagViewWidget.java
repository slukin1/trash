package com.hbg.module.content.custom.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.hbg.module.content.custom.tag.TagLayout;
import com.hbg.module.libkt.base.ext.b;
import com.huobi.edgeengine.template.widget.ContainerWidget;
import com.huobi.edgeengine.template.widget.Widget;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import rj.n;

public final class TagViewWidget extends ContainerWidget {

    /* renamed from: r0  reason: collision with root package name */
    public static final a f18200r0 = new a((r) null);

    /* renamed from: i0  reason: collision with root package name */
    public String f18201i0 = "item";

    /* renamed from: j0  reason: collision with root package name */
    public String f18202j0 = "type";

    /* renamed from: k0  reason: collision with root package name */
    public String f18203k0;

    /* renamed from: l0  reason: collision with root package name */
    public String f18204l0;

    /* renamed from: m0  reason: collision with root package name */
    public String f18205m0;

    /* renamed from: n0  reason: collision with root package name */
    public float f18206n0;

    /* renamed from: o0  reason: collision with root package name */
    public float f18207o0;

    /* renamed from: p0  reason: collision with root package name */
    public final ArrayList<TagCellWidget> f18208p0 = new ArrayList<>();

    /* renamed from: q0  reason: collision with root package name */
    public Context f18209q0;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public static final void f0(TagLayout tagLayout, n nVar, TagViewWidget tagViewWidget, int i11, List list, List list2) {
        tagLayout.removeAllViews();
        if (list.size() > 0) {
            int q11 = nVar.q(tagViewWidget.f18205m0, tagViewWidget.f18203k0);
            for (int i12 = 0; i12 < q11; i12++) {
                n p11 = nVar.p(tagViewWidget.f18201i0, tagViewWidget.f18205m0, i12, tagViewWidget.f18203k0);
                TagCellWidget c02 = tagViewWidget.c0(p11);
                tagLayout.addView(c02 != null ? c02.Q(tagViewWidget.f18209q0, p11) : null, tagViewWidget.Z());
            }
        }
        tagLayout.invalidate();
    }

    public void C(Context context, Map<String, String> map) {
        String str;
        super.C(context, map);
        String str2 = null;
        this.f18201i0 = map != null ? map.get("itemKey") : null;
        if (map == null || (str = map.get("typeKey")) == null) {
            str = "type";
        }
        this.f18202j0 = str;
        String str3 = map != null ? map.get("data") : null;
        this.f18204l0 = str3;
        if (!b.x(str3)) {
            int i11 = 0;
            if (StringsKt__StringsJVMKt.M(this.f18204l0, TIMMentionEditText.TIM_MENTION_TAG, false, 2, (Object) null)) {
                String str4 = this.f18204l0;
                if (str4 != null) {
                    i11 = StringsKt__StringsKt.g0(str4, InstructionFileId.DOT, 0, false, 6, (Object) null);
                }
                if (i11 > 0) {
                    String str5 = this.f18204l0;
                    this.f18203k0 = str5 != null ? str5.substring(1, i11) : null;
                    String str6 = this.f18204l0;
                    if (str6 != null) {
                        str2 = str6.substring(i11 + 1);
                    }
                    this.f18205m0 = str2;
                }
            }
        }
        this.f18206n0 = (float) A(context, Float.parseFloat(b0(map, "mainAxisSpace", "0")));
        this.f18207o0 = (float) A(context, Float.parseFloat(b0(map, "crossAxisSpace", "0")));
    }

    public final LinearLayout.LayoutParams Z() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMarginEnd((int) this.f18206n0);
        layoutParams.bottomMargin = (int) this.f18207o0;
        return layoutParams;
    }

    /* renamed from: a0 */
    public TagLayout q(Context context) {
        return new TagLayout(context, (AttributeSet) null, 0, 6, (r) null);
    }

    public final String b0(Map<String, String> map, String str, String str2) {
        return b.x(map != null ? map.get(str) : null) ? str2 : map.get(str);
    }

    public final TagCellWidget c0(n nVar) {
        try {
            int i11 = 0;
            if (this.f18208p0.size() == 1) {
                return this.f18208p0.get(0);
            }
            for (T next : this.f18208p0) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    CollectionsKt__CollectionsKt.t();
                }
                TagCellWidget tagCellWidget = (TagCellWidget) next;
                n p11 = nVar != null ? nVar.p(this.f18201i0, this.f18205m0, i11, this.f18203k0) : null;
                if (x.b(tagCellWidget.d0(), p11 != null ? p11.s(this.f18202j0) : null)) {
                    return tagCellWidget;
                }
                i11 = i12;
            }
            return null;
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* renamed from: d0 */
    public TagLayout Q(Context context, n nVar) {
        this.f18209q0 = context;
        TagLayout tagLayout = (TagLayout) super.Q(context, nVar);
        for (Widget widget : this.f44069h0) {
            this.f18208p0.add((TagCellWidget) widget);
        }
        e0(nVar, tagLayout);
        return tagLayout;
    }

    public final void e0(n nVar, TagLayout tagLayout) {
        if (!b.x(this.f18205m0)) {
            if (b.x(this.f18203k0)) {
                this.f18203k0 = nVar != null ? nVar.f47793e : null;
            }
            if (nVar != null) {
                nVar.G(this.f18205m0, new h(tagLayout, nVar, this), this.f18203k0);
            }
        }
    }
}
