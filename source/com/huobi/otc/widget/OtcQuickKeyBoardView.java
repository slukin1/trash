package com.huobi.otc.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.blankj.utilcode.util.u;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.module.otc.R$color;
import com.hbg.module.otc.R$dimen;
import com.hbg.module.otc.R$drawable;
import com.hbg.module.otc.R$font;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.List;
import vp.j0;
import vp.k0;

public class OtcQuickKeyBoardView extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public final String f80037b;

    /* renamed from: c  reason: collision with root package name */
    public final String f80038c;

    /* renamed from: d  reason: collision with root package name */
    public final String f80039d;

    /* renamed from: e  reason: collision with root package name */
    public b f80040e;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f80041a;

        /* renamed from: b  reason: collision with root package name */
        public String f80042b;

        /* renamed from: c  reason: collision with root package name */
        public int f80043c;

        public a(String str, String str2) {
            this.f80041a = str;
            this.f80042b = str2;
        }

        public int b() {
            return this.f80043c;
        }

        public String c() {
            return this.f80041a;
        }

        public void d(int i11) {
            this.f80043c = i11;
        }
    }

    public interface b {
        void a();

        void b(String str);
    }

    public OtcQuickKeyBoardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void g(a aVar, View view) {
        String str;
        if (this.f80040e != null) {
            if (aVar.f80042b.equals("point")) {
                str = InstructionFileId.DOT;
            } else {
                str = aVar.c();
            }
            this.f80040e.b(str);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void h(View view) {
        this.f80040e.a();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void c(Context context, List<a> list) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (i11 % 3 == 0) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(0);
                for (int i12 = 0; i12 < 3; i12++) {
                    a aVar = list.get(i11 + i12);
                    if (aVar.f80042b.equals("number") || aVar.f80042b.equals("point")) {
                        TextView e11 = e(context, linearLayout);
                        e11.setText(aVar.c());
                        e11.setOnClickListener(new k0(this, aVar));
                    } else if (aVar.f80042b.equals("delete")) {
                        ImageView d11 = d(context, linearLayout);
                        d11.setImageResource(aVar.b());
                        d11.setOnClickListener(new j0(this));
                    }
                }
                addView(linearLayout);
            }
        }
    }

    public final ImageView d(Context context, ViewGroup viewGroup) {
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(u.b() / 3, PixelUtils.a(65.0f));
        layoutParams.gravity = 17;
        viewGroup.addView(imageView, layoutParams);
        return imageView;
    }

    public final TextView e(Context context, ViewGroup viewGroup) {
        TextView textView = new TextView(context);
        textView.setTextSize(0, (float) getResources().getDimensionPixelSize(R$dimen.dimen_24));
        textView.setTypeface(ResourcesCompat.h(context, R$font.dinpro_medium));
        textView.setTextColor(ContextCompat.getColor(context, R$color.baseColorPrimaryText));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(u.b() / 3, PixelUtils.a(65.0f));
        layoutParams.gravity = 17;
        textView.setGravity(17);
        viewGroup.addView(textView, layoutParams);
        return textView;
    }

    public final void f(Context context) {
        setOrientation(1);
        setGravity(1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a("1", "number"));
        arrayList.add(new a("2", "number"));
        arrayList.add(new a("3", "number"));
        arrayList.add(new a("4", "number"));
        arrayList.add(new a(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_OTC, "number"));
        arrayList.add(new a(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL, "number"));
        arrayList.add(new a(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_SWAP, "number"));
        arrayList.add(new a("8", "number"));
        arrayList.add(new a("9", "number"));
        arrayList.add(new a("·", "point"));
        arrayList.add(new a("0", "number"));
        a aVar = new a("", "delete");
        aVar.d(R$drawable.otc_quick_keyboard_delete);
        arrayList.add(aVar);
        c(context, arrayList);
    }

    public void setBoardListener(b bVar) {
        this.f80040e = bVar;
    }

    public OtcQuickKeyBoardView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f80037b = "number";
        this.f80038c = "point";
        this.f80039d = "delete";
        f(context);
    }
}
