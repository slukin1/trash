package com.yanzhenjie.recyclerview.swipe;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.h0;
import androidx.core.widget.l;
import androidx.recyclerview.widget.RecyclerView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import dz.c;
import dz.d;
import dz.f;
import dz.g;
import dz.h;
import java.util.List;

public class SwipeMenuView extends LinearLayout implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView.ViewHolder f52687b;

    /* renamed from: c  reason: collision with root package name */
    public h f52688c;

    /* renamed from: d  reason: collision with root package name */
    public g f52689d;

    /* renamed from: e  reason: collision with root package name */
    public int f52690e;

    public SwipeMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void a(RecyclerView.ViewHolder viewHolder) {
        this.f52687b = viewHolder;
    }

    public final ImageView b(f fVar) {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageDrawable(fVar.c());
        return imageView;
    }

    public void c(c cVar, h hVar, g gVar, int i11) {
        removeAllViews();
        this.f52688c = hVar;
        this.f52689d = gVar;
        this.f52690e = i11;
        List<f> a11 = cVar.a();
        for (int i12 = 0; i12 < a11.size(); i12++) {
            f fVar = a11.get(i12);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(fVar.j(), fVar.b());
            layoutParams.weight = (float) fVar.i();
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setId(i12);
            linearLayout.setGravity(17);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(layoutParams);
            h0.B0(linearLayout, fVar.a());
            linearLayout.setOnClickListener(this);
            addView(linearLayout);
            d dVar = new d(this.f52690e, i12, this.f52688c, linearLayout);
            linearLayout.setTag(dVar);
            if (fVar.c() != null) {
                ImageView b11 = b(fVar);
                dVar.f52825g = b11;
                linearLayout.addView(b11);
            }
            if (!TextUtils.isEmpty(fVar.d())) {
                TextView d11 = d(fVar);
                dVar.f52824f = d11;
                linearLayout.addView(d11);
            }
        }
    }

    public final TextView d(f fVar) {
        TextView textView = new TextView(getContext());
        textView.setText(fVar.d());
        textView.setGravity(17);
        int f11 = fVar.f();
        if (f11 > 0) {
            textView.setTextSize((float) f11);
        }
        ColorStateList h11 = fVar.h();
        if (h11 != null) {
            textView.setTextColor(h11);
        }
        int e11 = fVar.e();
        if (e11 != 0) {
            l.s(textView, e11);
        }
        Typeface g11 = fVar.g();
        if (g11 != null) {
            textView.setTypeface(g11);
        }
        return textView;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (this.f52689d != null && this.f52688c.a()) {
            d dVar = (d) view.getTag();
            dVar.f52823e = this.f52687b.getAdapterPosition();
            this.f52689d.a(dVar);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public SwipeMenuView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
