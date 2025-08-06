package ol;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import ba.a;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.util.RemindBusinessType;
import com.hbg.lib.network.contract.core.util.RemindContractType;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.market.MarketModuleConfig;
import com.hbg.module.market.R$drawable;
import com.hbg.module.market.R$string;
import com.huobi.homemarket.bean.MarketContractSymbolPriceItem;
import com.huobi.homemarket.bean.MarketLinearSwapPriceItem;
import com.huobi.homemarket.bean.MarketSwapPriceItem;
import com.huobi.homemarket.ui.EditCollectionActivity;
import java.util.ArrayList;
import java.util.HashMap;
import u6.g;
import z9.f1;

public class b extends f1 implements a.C0785a {

    /* renamed from: q  reason: collision with root package name */
    public static String f76386q;

    /* renamed from: h  reason: collision with root package name */
    public g f76387h;

    /* renamed from: i  reason: collision with root package name */
    public Activity f76388i;

    /* renamed from: j  reason: collision with root package name */
    public String f76389j;

    /* renamed from: k  reason: collision with root package name */
    public String f76390k;

    /* renamed from: l  reason: collision with root package name */
    public d f76391l;

    /* renamed from: m  reason: collision with root package name */
    public s9.a f76392m;

    /* renamed from: n  reason: collision with root package name */
    public TradeType f76393n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f76394o;

    /* renamed from: p  reason: collision with root package name */
    public AnimatorSet f76395p;

    public class a extends q6.a<Object> {
        public a(g gVar, boolean z11) {
            super(gVar, z11);
        }

        public void onRequestSuccess(Object obj) {
            if (b.this.f76391l != null) {
                b.this.f76391l.c();
            }
            if (b.this.f76388i != null) {
                HuobiToastUtil.s(R$string.market_add_collection_success);
            }
        }
    }

    /* renamed from: ol.b$b  reason: collision with other inner class name */
    public class C0818b extends EasySubscriber<Object> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f76397b;

        public C0818b(boolean z11) {
            this.f76397b = z11;
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            if (aPIStatusErrorException != null && !this.f76397b && MarketModuleConfig.a().G().equals(aPIStatusErrorException.getErrCode())) {
                b.this.o(MarketModuleConfig.a().l(), true);
            }
            if (!this.f76397b) {
                super.onFailed(aPIStatusErrorException);
            }
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            if (b.this.f76388i != null) {
                HuobiToastUtil.s(R$string.market_delete_collection_success);
            }
            if (b.this.f76391l != null) {
                b.this.f76391l.a();
            }
        }
    }

    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        public void onAnimationEnd(Animator animator) {
            b.super.dismiss();
        }
    }

    public interface d<T extends s9.a> {
        void a();

        void b(T t11);

        void c();
    }

    public b(Activity activity, g gVar, d dVar) {
        super(activity);
        this.f76388i = activity;
        this.f76387h = gVar;
        this.f76391l = dVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t(boolean z11, Throwable th2) {
        if (z11) {
            o(this.f76390k, false);
        }
    }

    public static void u(String str) {
        i6.d.b("-->" + str);
        f76386q = str;
    }

    public void a(ba.a aVar) {
        boolean z11 = true;
        switch (aVar.f()) {
            case 1:
                new d9.a(MarketModuleConfig.a().B(this.f76389j, this.f76388i, this.f76390k)).d(new a(this.f76387h, true));
                HashMap hashMap = new HashMap();
                hashMap.put("list", f76386q);
                hashMap.put("symbol", this.f76389j);
                BaseModuleConfig.a().b("4114", hashMap);
                i6.d.b("--> TYPE_ADD_COLLECTION list:" + f76386q + " mSymbol:" + this.f76389j);
                break;
            case 2:
                MarketModuleConfig.a().g(this.f76389j, new a(this));
                break;
            case 3:
                d dVar = this.f76391l;
                if (dVar != null) {
                    dVar.b(this.f76392m);
                }
                HashMap hashMap2 = new HashMap(1);
                hashMap2.put("symbol", this.f76389j);
                BaseModuleConfig.a().b("4116", hashMap2);
                i6.d.b("--> TYPE_TOP mSymbol:" + this.f76389j);
                break;
            case 4:
                RemindContractType r11 = r();
                RemindBusinessType q11 = q();
                if (BaseModuleConfig.a().a()) {
                    MarketModuleConfig.a().P(this.f76388i, this.f76389j, r11, q11);
                } else {
                    MarketModuleConfig.a().k0(this.f76388i, this.f76389j, r11, q11);
                }
                HashMap hashMap3 = new HashMap(1);
                hashMap3.put("list", f76386q);
                hashMap3.put("symbol", this.f76389j);
                BaseModuleConfig.a().b("4117", hashMap3);
                i6.d.b("--> TYPE_REMIND list:" + f76386q + " mSymbol:" + this.f76389j);
                break;
            case 5:
                if (!this.f76394o) {
                    hf.b.m(this.f76389j, this.f76393n, true);
                    break;
                } else {
                    hf.b.z(this.f76389j, this.f76393n);
                    break;
                }
            case 6:
                Intent intent = new Intent(this.f76388i, EditCollectionActivity.class);
                if (this.f76393n != TradeType.PRO) {
                    z11 = false;
                }
                intent.putExtra("isSpot", z11);
                this.f76388i.startActivity(intent);
                this.f76388i.overridePendingTransition(0, 0);
                break;
        }
        dismiss();
    }

    public void dismiss() {
        AnimatorSet animatorSet = this.f76395p;
        if (animatorSet == null || !animatorSet.isRunning()) {
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.f76395p = animatorSet2;
            animatorSet2.playTogether(new Animator[]{ObjectAnimator.ofFloat(this.f76971b, View.ALPHA, new float[]{1.0f, 0.0f}), ObjectAnimator.ofFloat(this.f76971b, View.SCALE_X, new float[]{1.0f, 0.7f}), ObjectAnimator.ofFloat(this.f76971b, View.SCALE_Y, new float[]{1.0f, 0.7f})});
            this.f76395p.setInterpolator(new FastOutSlowInInterpolator());
            this.f76395p.setDuration(150);
            this.f76395p.addListener(new c());
            this.f76395p.start();
        }
    }

    public final void o(String str, boolean z11) {
        MarketModuleConfig.a().g0(this.f76389j, this.f76388i, str).compose(RxJavaHelper.t(this.f76387h)).subscribe(new C0818b(z11));
        HashMap hashMap = new HashMap(1);
        hashMap.put("list", f76386q);
        hashMap.put("symbol", this.f76389j);
        BaseModuleConfig.a().b("4115", hashMap);
        i6.d.b("--> TYPE_DELETE_COLLECTION list:" + f76386q + " mSymbol:" + this.f76389j);
    }

    public void p() {
        super.dismiss();
    }

    public final RemindBusinessType q() {
        s9.a aVar = this.f76392m;
        if (aVar instanceof MarketContractSymbolPriceItem) {
            return RemindBusinessType.CONTRACT;
        }
        if (aVar instanceof MarketSwapPriceItem) {
            return RemindBusinessType.SWAP;
        }
        if (aVar instanceof MarketLinearSwapPriceItem) {
            return RemindBusinessType.LINEAR_SWAP;
        }
        return null;
    }

    public final RemindContractType r() {
        s9.a aVar = this.f76392m;
        if (aVar instanceof MarketContractSymbolPriceItem) {
            RemindContractType remindContractType = RemindContractType.TYPE_CURRENT_WEEK;
            if (this.f76389j.contains("NQ")) {
                return RemindContractType.TYPE_NEXT_SEASON;
            }
            if (this.f76389j.contains("CQ")) {
                return RemindContractType.TYPE_CURRENT_SEASON;
            }
            if (this.f76389j.contains("NW")) {
                return RemindContractType.TYPE_NEXT_WEEK;
            }
            return remindContractType;
        } else if (aVar instanceof MarketSwapPriceItem) {
            return RemindContractType.TYPE_SWAP;
        } else {
            if (aVar instanceof MarketLinearSwapPriceItem) {
                return RemindContractType.TYPE_LINEAR_SWAP;
            }
            return null;
        }
    }

    public final void s(boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
        int i11;
        ArrayList arrayList = new ArrayList();
        if (z11) {
            arrayList.add(new ba.a(1, R$drawable.quotes_qptional, this.f76388i.getString(R$string.market_markets_addcollection), this));
        }
        if (z12) {
            arrayList.add(new ba.a(2, R$drawable.quotes_qptional_selected, this.f76388i.getString(R$string.market_markets_removecollection), this));
        }
        if (z13) {
            arrayList.add(new ba.a(3, R$drawable.quotes_top, this.f76388i.getString(R$string.n_market_top_title), this));
        }
        if (z14 && (MarketModuleConfig.a().J(this.f76389j) || MarketModuleConfig.a().V(this.f76389j) || MarketModuleConfig.a().q(this.f76389j))) {
            arrayList.add(new ba.a(4, R$drawable.quotes_remind, this.f76388i.getString(R$string.staring_remind), this));
        }
        if (z15) {
            if (this.f76394o) {
                i11 = R$drawable.quotes_floatingwindow;
            } else {
                i11 = R$drawable.quotes_floatingwindow_normal;
            }
            arrayList.add(new ba.a(5, i11, this.f76388i.getString(R$string.n_widget_market_float_window), this));
        }
        if (z16) {
            arrayList.add(new ba.a(6, R$drawable.quotes_window_edit, this.f76388i.getString(R$string.n_market_edit), this));
        }
        h(arrayList);
    }

    public void v(View view, String str, String str2, boolean z11, boolean z12, boolean z13, boolean z14, s9.a aVar, TradeType tradeType) {
        x(view, str, str2, z11, z12, z13, z14, true, false, aVar, tradeType);
    }

    public void w(View view, String str, String str2, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, s9.a aVar, TradeType tradeType) {
        x(view, str, str2, z11, z12, z13, z14, z15, false, aVar, tradeType);
    }

    public void x(View view, String str, String str2, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, s9.a aVar, TradeType tradeType) {
        String str3 = str2;
        boolean z17 = z15;
        TradeType tradeType2 = tradeType;
        i6.d.b("MarketItemTipsDialog-->show--> Website:" + str + " Symbol:" + str3 + " 添加自选:" + z11 + " 删除自选:" + z12 + " 置顶:" + z13 + " 提醒:" + z14 + " 悬浮窗:" + z17 + " 编辑:" + z16);
        this.f76389j = str3;
        this.f76390k = str;
        this.f76392m = aVar;
        this.f76393n = tradeType2;
        this.f76394o = z17 && hf.b.o(str3, tradeType2);
        s(z11, z12, z13, z14, z15, z16);
        super.i(view);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f76395p = animatorSet;
        animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(this.f76971b, View.ALPHA, new float[]{0.0f, 1.0f}), ObjectAnimator.ofFloat(this.f76971b, View.SCALE_X, new float[]{0.7f, 1.0f}), ObjectAnimator.ofFloat(this.f76971b, View.SCALE_Y, new float[]{0.7f, 1.0f})});
        this.f76395p.setInterpolator(new FastOutSlowInInterpolator());
        this.f76395p.setDuration(150);
        this.f76395p.start();
    }
}
