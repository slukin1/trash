package com.huobi.c2c.lend.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewpager.widget.ViewPager;
import com.hbg.lib.widgets.CommonTextListIndicator;
import d7.k;
import i6.d;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import pro.huobi.R;

public class C2CLendActionView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public CommonTextListIndicator f42927b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f42928c;

    /* renamed from: d  reason: collision with root package name */
    public List<String> f42929d;

    /* renamed from: e  reason: collision with root package name */
    public b f42930e;

    /* renamed from: f  reason: collision with root package name */
    public final Interpolator f42931f;

    public class a implements CommonTextListIndicator.b {
        public a() {
        }

        public void a(int i11, View view) {
        }

        public void onItemClick(int i11) {
            if (C2CLendActionView.this.f42929d != null && i11 < C2CLendActionView.this.f42929d.size() && C2CLendActionView.this.f42930e != null) {
                C2CLendActionView.this.f42930e.a(i11, (String) C2CLendActionView.this.f42929d.get(i11));
            }
        }
    }

    public interface b {
        void a(int i11, String str);
    }

    public C2CLendActionView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h(boolean z11) {
        d.b("C2CLendActionView-->onScrollChange-->" + z11);
        if (z11) {
            this.f42928c.setVisibility(0);
            this.f42928c.animate().setInterpolator(this.f42931f).setDuration(300).translationX(0.0f).alpha(1.0f);
            return;
        }
        this.f42928c.animate().setInterpolator(this.f42931f).setDuration(300).translationX((float) this.f42928c.getWidth()).alpha(0.0f);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i(Void voidR) {
        this.f42927b.w();
    }

    public final void e() {
        this.f42927b.setCallback(new a());
        this.f42927b.setOnScrollChangeCallback(new qi.a(this));
        dw.a.a(this.f42928c).throttleFirst(300, TimeUnit.MILLISECONDS).subscribe(new qi.b(this));
    }

    public void f(ViewPager viewPager) {
        ViewPagerHelper.a(this.f42927b, viewPager);
    }

    public final void g(Context context) {
        this.f42928c = (ImageView) findViewById(R.id.c2c_lend_action_view_arrow);
        CommonTextListIndicator commonTextListIndicator = (CommonTextListIndicator) findViewById(R.id.c2c_lend_action_view_indicator);
        this.f42927b = commonTextListIndicator;
        commonTextListIndicator.setUseCoverView(false);
        this.f42927b.setInitPostScrollCallback(false);
    }

    public void setCallback(b bVar) {
        this.f42930e = bVar;
    }

    public void setTabList(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String z11 : list) {
            arrayList.add(k.C().z(z11));
        }
        this.f42929d = list;
        this.f42927b.setDataList(arrayList);
    }

    public C2CLendActionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C2CLendActionView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f42931f = new DecelerateInterpolator();
        FrameLayout.inflate(context, R.layout.c2c_lend_action_view, this);
        g(context);
        e();
    }
}
