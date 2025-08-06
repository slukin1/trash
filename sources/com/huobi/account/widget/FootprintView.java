package com.huobi.account.widget;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gs.g;
import i6.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import pro.huobi.R;
import s9.a;
import sn.f;

public class FootprintView extends LinearLayout implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public String f41961b;

    /* renamed from: c  reason: collision with root package name */
    public EasyRecyclerView<a> f41962c;

    /* renamed from: d  reason: collision with root package name */
    public EasyRecyclerView<a> f41963d;

    /* renamed from: e  reason: collision with root package name */
    public final List<a> f41964e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public Paint f41965f;

    /* renamed from: g  reason: collision with root package name */
    public View f41966g;

    /* renamed from: h  reason: collision with root package name */
    public View f41967h;

    public FootprintView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public final void a(Context context) {
        Paint paint = new Paint();
        this.f41965f = paint;
        paint.setStrokeWidth(context.getResources().getDimension(R.dimen.dimen_0_6));
        this.f41965f.setColor(context.getResources().getColor(R.color.baseColorPrimarySeparator));
        LayoutInflater.from(context).inflate(R.layout.view_personal_footprint, this, true);
        r rVar = new r((View) this);
        rVar.b(R.id.text_view_personal_more).setOnClickListener(this);
        rVar.b(R.id.font_icon_text_view_personal_more).setOnClickListener(this);
        this.f41962c = (EasyRecyclerView) rVar.b(R.id.recycler_view_personal_activity_footprint);
        this.f41963d = (EasyRecyclerView) rVar.b(R.id.recycler_view_personal_market_footprint);
        this.f41966g = rVar.b(R.id.view_personal_activity_footprint_underline);
        this.f41967h = rVar.b(R.id.foot_more_layout);
        b(this.f41962c);
        b(this.f41963d);
        this.f41963d.setLayoutManager(new GridLayoutManager(context, 3));
        this.f41962c.setLayoutManager(new GridLayoutManager(context, 2));
        setOrientation(1);
        setBackgroundResource(R.color.baseColorContentBackground);
        setVisibility(8);
    }

    public final void b(RecyclerView recyclerView) {
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.setChangeDuration(0);
            itemAnimator.setAddDuration(0);
            itemAnimator.setMoveDuration(0);
            itemAnimator.setRemoveDuration(0);
        }
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.f41961b)) {
            f.T(getContext(), this.f41961b);
        }
        g.i("View_More_Me_click", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public FootprintView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
