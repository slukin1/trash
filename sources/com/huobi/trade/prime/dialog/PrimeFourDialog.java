package com.huobi.trade.prime.dialog;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.huobi.view.rv.VerticalDividerItemDecoration;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import java.util.List;
import pro.huobi.R;

public class PrimeFourDialog extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public EasyRecyclerView<s9.a> f82177b;

    /* renamed from: c  reason: collision with root package name */
    public View f82178c;

    /* renamed from: d  reason: collision with root package name */
    public View f82179d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f82180e;

    /* renamed from: f  reason: collision with root package name */
    public List<s9.a> f82181f;

    /* renamed from: g  reason: collision with root package name */
    public String f82182g;

    /* renamed from: h  reason: collision with root package name */
    public VerticalDividerItemDecoration f82183h;

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        public float f82184b;

        /* renamed from: c  reason: collision with root package name */
        public float f82185c;

        public a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator.getAnimatedValue() instanceof Float) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.f82184b = floatValue;
                this.f82185c = (floatValue * 0.2f) + 0.8f;
                PrimeFourDialog.this.f82179d.setAlpha(this.f82184b);
                PrimeFourDialog.this.f82179d.setScaleX(this.f82185c);
                PrimeFourDialog.this.f82179d.setScaleY(this.f82185c);
            }
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void addEvent(r rVar) {
        this.f82178c.setOnClickListener(new gt.a(this));
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(new a());
        ofFloat.setDuration(300);
        ofFloat.setInterpolator(new OvershootInterpolator());
        ofFloat.start();
    }

    public void afterInit() {
        this.f82177b.setData(this.f82181f);
        this.f82180e.setText(this.f82182g);
    }

    public void doDismiss() {
        super.doDismiss();
    }

    public int getContentViewResId() {
        return R.layout.prime_four_dialog;
    }

    public int getGravity() {
        return 17;
    }

    public void initView(r rVar) {
        this.f82177b = (EasyRecyclerView) rVar.b(R.id.list_view);
        this.f82180e = (TextView) rVar.b(R.id.rate);
        this.f82178c = rVar.b(R.id.close);
        this.f82179d = rVar.b(R.id.root_view);
        VerticalDividerItemDecoration verticalDividerItemDecoration = new VerticalDividerItemDecoration(ContextCompat.getDrawable(getActivity(), R.drawable.vertical_divider_prime_bg), PixelUtils.a(0.5f), false, false);
        this.f82183h = verticalDividerItemDecoration;
        this.f82177b.addItemDecoration(verticalDividerItemDecoration);
    }

    public boolean isFullScreen() {
        return true;
    }

    public boolean isTransparent() {
        return false;
    }

    public void uh(String str, List<s9.a> list) {
        this.f82182g = str;
        this.f82181f = list;
    }
}
