package com.huobi.edgeengine.template.widget.list;

import ak.b;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.huobi.edgeengine.template.widget.ContainerWidget;
import com.huobi.edgeengine.template.widget.FooterWidget;
import com.huobi.edgeengine.template.widget.HeaderWidget;
import com.huobi.edgeengine.template.widget.Widget;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Map;
import rj.n;

public class GirdViewWidget extends ContainerWidget {

    /* renamed from: i0  reason: collision with root package name */
    public String f44250i0 = "item";

    /* renamed from: j0  reason: collision with root package name */
    public String f44251j0 = "i";

    /* renamed from: k0  reason: collision with root package name */
    public String f44252k0;

    /* renamed from: l0  reason: collision with root package name */
    public String f44253l0;

    /* renamed from: m0  reason: collision with root package name */
    public String f44254m0;

    /* renamed from: n0  reason: collision with root package name */
    public String f44255n0;

    /* renamed from: o0  reason: collision with root package name */
    public String f44256o0;

    /* renamed from: p0  reason: collision with root package name */
    public int f44257p0;

    /* renamed from: q0  reason: collision with root package name */
    public int f44258q0;

    /* renamed from: r0  reason: collision with root package name */
    public int f44259r0;

    public static class a extends RecyclerView.ItemDecoration {

        /* renamed from: a  reason: collision with root package name */
        public final int f44260a;

        /* renamed from: b  reason: collision with root package name */
        public final int f44261b;

        public a(int i11, int i12) {
            this.f44260a = i11;
            this.f44261b = i12;
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            if ((recyclerView.getLayoutManager() instanceof GridLayoutManager) && (recyclerView.getAdapter() instanceof b)) {
                GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                b bVar = (b) recyclerView.getAdapter();
                int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
                if (bVar.f(childLayoutPosition) || bVar.e(childLayoutPosition)) {
                    rect.set(0, 0, 0, 0);
                    return;
                }
                int d11 = childLayoutPosition - bVar.d();
                int itemCount = (bVar.getItemCount() - bVar.d()) - bVar.c();
                if (gridLayoutManager.getOrientation() == 1) {
                    int k11 = gridLayoutManager.k();
                    int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
                    int i11 = childAdapterPosition % k11;
                    int i12 = this.f44261b;
                    rect.left = (i11 * i12) / k11;
                    rect.right = i12 - (((i11 + 1) * i12) / k11);
                    Log.e("EdgeEngine.Widget", "position:" + childAdapterPosition + "    columnIndex: " + i11 + "    left,right ->" + rect.left + Constants.ACCEPT_TIME_SEPARATOR_SP + rect.right);
                    if (childAdapterPosition >= k11) {
                        rect.top = this.f44260a;
                        return;
                    }
                    return;
                }
                int k12 = gridLayoutManager.k();
                if (d11 % k12 == 0) {
                    rect.top = 0;
                } else {
                    rect.top = this.f44261b;
                }
                if (itemCount - d11 < k12) {
                    rect.right = 0;
                } else {
                    rect.right = this.f44260a;
                }
            }
        }
    }

    public void C(Context context, Map<String, String> map) {
        super.C(context, map);
        this.f44250i0 = map.get("itemKey");
        this.f44251j0 = map.get("indexKey");
        this.f44252k0 = map.get("typeKey");
        String str = map.get("data");
        this.f44253l0 = str;
        if (!TextUtils.isEmpty(str)) {
            if (this.f44253l0.startsWith(TIMMentionEditText.TIM_MENTION_TAG)) {
                int indexOf = this.f44253l0.indexOf(InstructionFileId.DOT);
                if (indexOf > 0) {
                    this.f44255n0 = this.f44253l0.substring(1, indexOf);
                    this.f44254m0 = this.f44253l0.substring(indexOf + 1);
                }
            } else {
                this.f44254m0 = this.f44253l0;
            }
        }
        this.f44256o0 = Z(map, "orientation", "vertical");
        this.f44257p0 = A(context, Float.parseFloat(Z(map, "mainAxisSpace", "0")));
        this.f44258q0 = A(context, Float.parseFloat(Z(map, "crossAxisSpace", "0")));
        try {
            this.f44259r0 = Integer.parseInt(map.get("crossAxisItemCount"));
        } catch (Throwable unused) {
            Log.e("EdgeEngine.Widget", "crossAxisItemCount 解析失败！！");
        }
    }

    /* renamed from: Y */
    public RecyclerView q(Context context) {
        return new RecyclerView(context);
    }

    public String Z(Map<String, String> map, String str, String str2) {
        if (TextUtils.isEmpty(map.get(str))) {
            return str2;
        }
        return map.get(str);
    }

    /* renamed from: a0 */
    public RecyclerView Q(Context context, n nVar) {
        RecyclerView recyclerView = (RecyclerView) super.Q(context, nVar);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator((RecyclerView.ItemAnimator) null);
        b bVar = new b(context);
        bVar.o(this.f44250i0);
        if (TextUtils.isEmpty(this.f44252k0)) {
            this.f44252k0 = "type";
        }
        bVar.q(this.f44252k0);
        String str = this.f44255n0;
        if (TextUtils.isEmpty(str)) {
            str = nVar.f47793e;
        }
        bVar.l(str, this.f44254m0);
        bVar.p(nVar);
        bVar.r();
        ArrayList arrayList = new ArrayList();
        for (Widget next : this.f44069h0) {
            if (next instanceof CellWidget) {
                arrayList.add((CellWidget) next);
            } else if (next instanceof HeaderWidget) {
                bVar.n((HeaderWidget) next);
            } else if (next instanceof FooterWidget) {
                bVar.m((FooterWidget) next);
            }
        }
        bVar.k(arrayList);
        if (this.f44256o0.equals("vertical")) {
            recyclerView.setLayoutManager(new GridLayoutManager(context, this.f44259r0, 1, false));
        } else if (this.f44256o0.equals(MessengerShareContentUtility.IMAGE_RATIO_HORIZONTAL)) {
            recyclerView.setLayoutManager(new GridLayoutManager(context, this.f44259r0, 0, false));
        }
        recyclerView.addItemDecoration(new a(this.f44257p0, this.f44258q0));
        recyclerView.setAdapter(bVar);
        bVar.notifyDataSetChanged();
        return recyclerView;
    }
}
