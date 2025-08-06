package com.huobi.linearswap.ordertutorial.ui;

import a7.e;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Keep;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.rxjava.RxJavaHelper;
import com.huobi.linearswap.ordertutorial.presenter.OrderTutorialPresenter;
import com.huobi.login.bean.JumpTarget;
import com.huobi.utils.k0;
import com.huobi.view.title.HbTitleBar;
import java.util.concurrent.TimeUnit;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import rx.Observable;
import zm.d;

public class OrderTutorialActivity extends BaseActivity<OrderTutorialPresenter, OrderTutorialPresenter.b> implements OrderTutorialPresenter.b {

    /* renamed from: b  reason: collision with root package name */
    public final int f74989b = 0;

    /* renamed from: c  reason: collision with root package name */
    public View f74990c;

    /* renamed from: d  reason: collision with root package name */
    public ViewPager2 f74991d;

    /* renamed from: e  reason: collision with root package name */
    public OrderTutorialWelcomeFragment f74992e;

    /* renamed from: f  reason: collision with root package name */
    public OrderTutorialStep1Fragment f74993f;

    /* renamed from: g  reason: collision with root package name */
    public OrderTutorialStep2Fragment f74994g;

    /* renamed from: h  reason: collision with root package name */
    public OrderTutorialSuccFragment f74995h;

    /* renamed from: i  reason: collision with root package name */
    public HbTitleBar f74996i;

    public class a extends EasySubscriber<Object> {
        public a() {
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            e.M(2, TradeType.LINEAR_SWAP);
        }
    }

    public class b extends ViewPager2.OnPageChangeCallback {
        public b() {
        }

        public void onPageSelected(int i11) {
            super.onPageSelected(i11);
            if (i11 == 3) {
                OrderTutorialActivity.this.f74990c.setVisibility(8);
                OrderTutorialActivity.this.f74996i.setTitle("");
                return;
            }
            OrderTutorialActivity.this.f74990c.setVisibility(0);
            OrderTutorialActivity.this.f74996i.setTitle(OrderTutorialActivity.this.getResources().getString(R.string.n_linear_swap_guide));
        }
    }

    public class c extends FragmentStateAdapter {
        public c(FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        public Fragment createFragment(int i11) {
            if (i11 == 0) {
                return OrderTutorialActivity.this.uh();
            }
            if (i11 == 1) {
                return OrderTutorialActivity.this.qh();
            }
            if (i11 == 2) {
                return OrderTutorialActivity.this.rh();
            }
            if (i11 == 3) {
                return OrderTutorialActivity.this.sh();
            }
            return null;
        }

        public int getItemCount() {
            return 4;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void xh(Void voidR) {
        vh();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void yh(Void voidR) {
        finish();
    }

    public final void Ah() {
        FutureContractInfo Q = ((OrderTutorialPresenter) getPresenter()).Q();
        if (Q != null) {
            Intent i11 = k0.i(this, true);
            i11.putExtra("linear_swap_currency_info", Q);
            startActivity(i11);
        }
    }

    public void S4(int i11) {
        this.f74991d.setCurrentItem(i11, false);
    }

    public void addEvent() {
        SP.y("is_first_order", false);
        e.L(2, TradeType.LINEAR_SWAP).compose(RxJavaHelper.g((RequestCallback1) null)).subscribe(new a());
    }

    public void finish() {
        super.finish();
        Ah();
    }

    public int getContentView() {
        return R.layout.activity_linear_swap_order_tutorial;
    }

    public void initView() {
        this.f74996i = (HbTitleBar) this.viewFinder.b(R.id.hb_title_bar);
        this.f74990c = this.viewFinder.b(R.id.iv_back);
        wh();
        Observable<Void> a11 = dw.a.a(this.f74990c);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        a11.throttleFirst(1, timeUnit).subscribe(new zm.e(this));
        dw.a.a(this.viewFinder.b(R.id.iv_action)).throttleFirst(1, timeUnit).subscribe(new d(this));
    }

    /* renamed from: oh */
    public OrderTutorialPresenter createPresenter() {
        return new OrderTutorialPresenter();
    }

    public void onBackPressed() {
        if (this.f74991d.getCurrentItem() == 3) {
            finish();
        } else {
            vh();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventBus.d().p(this);
    }

    public void onDestroy() {
        super.onDestroy();
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenErrorEvent(p6.a aVar) {
        rn.c.i().m(this, new JumpTarget((Intent) null, (Intent) null));
        OrderTutorialStep2Fragment orderTutorialStep2Fragment = this.f74994g;
        if (orderTutorialStep2Fragment != null) {
            orderTutorialStep2Fragment.Xh();
        }
    }

    public an.a ph() {
        return (an.a) getPresenter();
    }

    public final OrderTutorialStep1Fragment qh() {
        if (this.f74993f == null) {
            this.f74993f = new OrderTutorialStep1Fragment();
        }
        return this.f74993f;
    }

    public final OrderTutorialStep2Fragment rh() {
        if (this.f74994g == null) {
            this.f74994g = new OrderTutorialStep2Fragment();
        }
        return this.f74994g;
    }

    public final OrderTutorialSuccFragment sh() {
        if (this.f74995h == null) {
            this.f74995h = new OrderTutorialSuccFragment();
        }
        return this.f74995h;
    }

    /* renamed from: th */
    public OrderTutorialPresenter.b getUI() {
        return this;
    }

    public final OrderTutorialWelcomeFragment uh() {
        if (this.f74992e == null) {
            this.f74992e = new OrderTutorialWelcomeFragment();
        }
        return this.f74992e;
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }

    public void vh() {
        int currentItem = this.f74991d.getCurrentItem();
        if (currentItem == 0) {
            finish();
        } else {
            this.f74991d.setCurrentItem(currentItem - 1, false);
        }
        if (currentItem == 2) {
            this.f74994g.mi();
        }
    }

    public final void wh() {
        ViewPager2 viewPager2 = (ViewPager2) this.viewFinder.b(R.id.f16922vp);
        this.f74991d = viewPager2;
        viewPager2.setAdapter(new c(this));
        this.f74991d.setUserInputEnabled(false);
        this.f74991d.registerOnPageChangeCallback(new b());
    }

    public void zh() {
        ((OrderTutorialPresenter) getPresenter()).S();
        this.f74991d.setCurrentItem(0, false);
        this.f74993f.Sh();
        this.f74994g.mi();
    }
}
