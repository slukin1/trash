package kf;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import com.hbg.module.market.widget.bean.MarketWidgetSymbolItem;
import com.hbg.module.market.widget.event.MarketSettingEvent;
import org.greenrobot.eventbus.EventBus;
import u6.g;

public class c implements MarketWidgetSymbolItem.a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f29081a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f29082b;

    /* renamed from: c  reason: collision with root package name */
    public MarketWidgetSymbolItem f29083c;

    /* renamed from: d  reason: collision with root package name */
    public g f29084d;

    /* renamed from: e  reason: collision with root package name */
    public C0254c f29085e;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        public void onAnimationEnd(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MarketWidgetSymbolItem f29087b;

        public b(MarketWidgetSymbolItem marketWidgetSymbolItem) {
            this.f29087b = marketWidgetSymbolItem;
        }

        public void onAnimationEnd(Animator animator) {
            MarketSettingEvent marketSettingEvent = new MarketSettingEvent();
            marketSettingEvent.f(true);
            marketSettingEvent.g(this.f29087b.getSymbol());
            marketSettingEvent.h(this.f29087b.getTradeType());
            marketSettingEvent.i(this.f29087b);
            EventBus.d().k(marketSettingEvent);
            boolean unused = c.this.f29082b = false;
        }
    }

    /* renamed from: kf.c$c  reason: collision with other inner class name */
    public interface C0254c {
        void J0();

        void a(MarketWidgetSymbolItem marketWidgetSymbolItem);
    }

    public c(g gVar, C0254c cVar) {
        this.f29084d = gVar;
        this.f29085e = cVar;
    }

    public static /* synthetic */ void j(View view, ValueAnimator valueAnimator) {
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            view.setLayoutParams(layoutParams);
        }
    }

    public static /* synthetic */ void k(View view, ValueAnimator valueAnimator) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        view.setLayoutParams(layoutParams);
    }

    public void a(MarketWidgetSymbolItem marketWidgetSymbolItem) {
        C0254c cVar = this.f29085e;
        if (cVar != null) {
            cVar.a(marketWidgetSymbolItem);
        }
    }

    public void b(boolean z11) {
        this.f29081a = z11;
    }

    public void c() {
        boolean z11;
        C0254c cVar;
        if (!this.f29081a) {
            MarketWidgetSymbolItem marketWidgetSymbolItem = this.f29083c;
            if (marketWidgetSymbolItem != null) {
                marketWidgetSymbolItem.setDelBtnStatus(3);
                z11 = true;
            } else {
                z11 = false;
            }
            this.f29083c = null;
            if (z11 && (cVar = this.f29085e) != null) {
                cVar.J0();
            }
            this.f29082b = false;
        }
    }

    public void d(View view, View view2, MarketWidgetSymbolItem marketWidgetSymbolItem) {
        if (marketWidgetSymbolItem != null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{view2.getWidth(), view.getWidth()});
            ofInt.addUpdateListener(new a(view2));
            ofInt.setInterpolator(new DecelerateInterpolator());
            ofInt.setDuration(270);
            ofInt.addListener(new a());
            ofInt.start();
            ValueAnimator ofInt2 = ValueAnimator.ofInt(new int[]{view2.getHeight(), 0});
            ofInt2.addUpdateListener(new b(view));
            ofInt2.addListener(new b(marketWidgetSymbolItem));
            ofInt2.setInterpolator(new DecelerateInterpolator());
            ofInt2.setDuration(270);
            ofInt2.start();
        }
    }

    public void e(MarketWidgetSymbolItem marketWidgetSymbolItem) {
        if (!this.f29081a) {
            MarketWidgetSymbolItem marketWidgetSymbolItem2 = this.f29083c;
            if (marketWidgetSymbolItem2 != null) {
                marketWidgetSymbolItem2.setDelBtnStatus(3);
            }
            this.f29083c = marketWidgetSymbolItem;
            marketWidgetSymbolItem.setDelBtnStatus(2);
            C0254c cVar = this.f29085e;
            if (cVar != null) {
                cVar.J0();
            }
            this.f29082b = true;
        }
    }

    public boolean f() {
        return this.f29082b;
    }
}
