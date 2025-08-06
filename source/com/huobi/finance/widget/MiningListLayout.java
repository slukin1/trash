package com.huobi.finance.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$color;
import com.hbg.module.asset.R$dimen;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.huobi.view.rv.VerticalDividerItemDecoration;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.List;
import java.util.Map;

public class MiningListLayout extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public EasyRecyclerView f67652b;

    /* renamed from: c  reason: collision with root package name */
    public LoadingLayout f67653c;

    public class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            BaseModuleConfig.a().b("5173", (Map<String, Object>) null);
            AssetModuleConfig.a().m1(view.getContext());
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public MiningListLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public final void a(Context context) {
        LayoutInflater.from(context).inflate(R$layout.layout_mining_list, this, true);
        this.f67653c = (LoadingLayout) findViewById(R$id.loading_layout);
        this.f67652b = (EasyRecyclerView) findViewById(R$id.rcv);
        findViewById(R$id.tv_mining_now).setOnClickListener(new a());
        this.f67652b.addItemDecoration(new VerticalDividerItemDecoration((Drawable) new ColorDrawable(ContextCompat.getColor(context, R$color.baseColorPrimarySeparator)), (int) context.getResources().getDimension(R$dimen.dimen_0_5), true, true));
    }

    public void setData(List<? extends s9.a> list) {
        if (list == null) {
            this.f67653c.k();
        } else if (list.isEmpty()) {
            this.f67653c.i();
        } else {
            this.f67653c.g();
            this.f67652b.setData(list);
        }
    }

    public void setRetryListener(View.OnClickListener onClickListener) {
        this.f67653c.setOnRetryClickListener(onClickListener);
    }

    public MiningListLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MiningListLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(context);
    }
}
