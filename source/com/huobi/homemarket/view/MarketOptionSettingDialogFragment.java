package com.huobi.homemarket.view;

import android.content.DialogInterface;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.widgets.BaseOrderFilterDialogFragment;
import com.hbg.module.market.R$id;
import com.hbg.module.market.R$layout;
import com.huobi.homemarket.bean.MarketOptionSettingBean;
import com.huobi.view.rv.GridDividerItemDecoration;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import java.util.ArrayList;
import java.util.List;
import vl.c;
import vl.d;
import vl.e;

public class MarketOptionSettingDialogFragment extends BaseOrderFilterDialogFragment implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public View f73061b;

    /* renamed from: c  reason: collision with root package name */
    public View[] f73062c;

    /* renamed from: d  reason: collision with root package name */
    public int f73063d = 1;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView f73064e;

    /* renamed from: f  reason: collision with root package name */
    public v9.a f73065f;

    /* renamed from: g  reason: collision with root package name */
    public List<MarketOptionSettingBean> f73066g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public TextView f73067h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f73068i;

    /* renamed from: j  reason: collision with root package name */
    public View f73069j;

    /* renamed from: k  reason: collision with root package name */
    public a f73070k;

    /* renamed from: l  reason: collision with root package name */
    public int f73071l;

    public interface a {
        void a(int i11);

        void b(int i11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$addEvent$0(View view, MotionEvent motionEvent) {
        View[] viewArr;
        if (motionEvent.getAction() != 0 || (viewArr = this.f73062c) == null) {
            return false;
        }
        for (View view2 : viewArr) {
            if (checkDownInView(view2, motionEvent.getRawX(), motionEvent.getRawY())) {
                view2.performClick();
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        if (this.f73063d == 4) {
            for (MarketOptionSettingBean temporarySelectedState : this.f73066g) {
                temporarySelectedState.setTemporarySelectedState(false);
            }
        } else {
            for (int i11 = 0; i11 < this.f73066g.size(); i11++) {
                if (i11 == 0) {
                    this.f73066g.get(i11).setTemporarySelectedState(true);
                } else {
                    this.f73066g.get(i11).setTemporarySelectedState(false);
                }
            }
        }
        this.f73065f.notifyDataSetChanged();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        yh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Ah(int i11) {
        this.f73063d = i11;
    }

    public void addEvent(r rVar) {
        super.addEvent(rVar);
        this.f73061b.setOnTouchListener(new e(this));
        this.f73067h.setOnClickListener(new d(this));
        this.f73068i.setOnClickListener(new c(this));
    }

    public void addExtraClickView(View... viewArr) {
        this.f73062c = viewArr;
    }

    public void afterInit() {
    }

    public final boolean checkDownInView(View view, float f11, float f12) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new Rect(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight()).contains((int) f11, (int) f12);
    }

    public void configCoverViewLayoutParams(View view, FrameLayout.LayoutParams layoutParams) {
        layoutParams.topMargin = this.f73071l;
    }

    public View getBackBtn() {
        return null;
    }

    public int getContentViewResId() {
        return R$layout.dialog_market_option_filter;
    }

    public View getFilterLayout() {
        return this.viewFinder.b(R$id.option_filter_view);
    }

    public void initView(r rVar) {
        this.f73061b = rVar.b(R$id.clickView);
        this.f73069j = rVar.b(R$id.buttonLayout);
        this.f73064e = (RecyclerView) rVar.b(R$id.contentLayout);
        this.f73068i = (TextView) rVar.b(R$id.settingSure);
        this.f73067h = (TextView) rVar.b(R$id.settingReset);
        this.f73065f = new v9.a(this.f73066g);
        this.f73064e.setLayoutManager(new GridLayoutManager(getContext(), 3));
        this.f73064e.addItemDecoration(new GridDividerItemDecoration(new ColorDrawable(0), PixelUtils.a(10.0f)));
        this.f73064e.setAdapter(this.f73065f);
        if (this.f73063d == 4) {
            this.f73069j.setVisibility(0);
        } else {
            this.f73069j.setVisibility(8);
        }
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        MarketOptionSettingBean marketOptionSettingBean = (MarketOptionSettingBean) view.getTag();
        for (MarketOptionSettingBean next : this.f73066g) {
            if (marketOptionSettingBean != next) {
                next.setTemporarySelectedState(false);
            }
        }
        this.f73065f.notifyDataSetChanged();
        if (this.f73063d != 4) {
            yh();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        a aVar = this.f73070k;
        if (aVar != null) {
            aVar.a(this.f73063d);
        }
    }

    public void onStart() {
        super.onStart();
        this.f73061b.getLayoutParams().height = this.f73071l;
    }

    public void reset() {
    }

    public void setSettingBeans(List<MarketOptionSettingBean> list) {
        this.f73066g.clear();
        this.f73066g.addAll(list);
        for (MarketOptionSettingBean next : this.f73066g) {
            next.setOnClickListener(this);
            next.setTemporarySelectedState(next.isSelected());
        }
    }

    public void setTopMargin(int i11) {
        this.f73071l = i11;
    }

    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }

    public void wh() {
        if (this.f73063d == 4) {
            this.f73069j.setVisibility(0);
        } else {
            this.f73069j.setVisibility(8);
        }
        this.f73065f.notifyDataSetChanged();
    }

    public int xh() {
        return this.f73063d;
    }

    public final void yh() {
        for (MarketOptionSettingBean next : this.f73066g) {
            next.setSelected(next.isTemporarySelectedState());
        }
        a aVar = this.f73070k;
        if (aVar != null) {
            aVar.b(this.f73063d);
        }
        dismiss();
    }

    public void zh(a aVar) {
        this.f73070k = aVar;
    }
}
