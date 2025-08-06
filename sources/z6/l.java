package z6;

import com.hbg.lib.data.future.bean.FutureUserInfo;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapUserInfo;
import com.hbg.lib.network.option.core.bean.OptionUserInfo;
import i8.s;
import java.util.HashMap;
import java.util.Map;
import q8.h;
import rx.Observable;

public final class l {

    /* renamed from: c  reason: collision with root package name */
    public static volatile l f69088c;

    /* renamed from: a  reason: collision with root package name */
    public FutureUserInfo f69089a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<TradeType, FutureUserInfo> f69090b = new HashMap();

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f69091a;

        static {
            int[] iArr = new int[TradeType.values().length];
            f69091a = iArr;
            try {
                iArr[TradeType.LINEAR_SWAP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static l c() {
        if (f69088c == null) {
            synchronized (l.class) {
                if (f69088c == null) {
                    f69088c = new l();
                }
            }
        }
        return f69088c;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ FutureUserInfo j(OptionUserInfo optionUserInfo) {
        FutureUserInfo futureUserInfo = new FutureUserInfo();
        this.f69089a = futureUserInfo;
        futureUserInfo.optionConvert(futureUserInfo, optionUserInfo);
        this.f69090b.put(TradeType.OPTION, this.f69089a);
        return this.f69089a;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ FutureUserInfo k(TradeType tradeType, LinearSwapUserInfo linearSwapUserInfo) {
        FutureUserInfo g11 = g(tradeType);
        if (g11 == null) {
            g11 = new FutureUserInfo();
            this.f69090b.put(tradeType, g11);
        }
        g11.convert(g11, linearSwapUserInfo);
        return g11;
    }

    public Observable<FutureUserInfo> d(TradeType tradeType, boolean z11) {
        if (a.f69091a[tradeType.ordinal()] != 1) {
            return e(z11);
        }
        return s.d().e(z11).map(new k(this, tradeType));
    }

    public Observable<FutureUserInfo> e(boolean z11) {
        return h.d().e(z11).map(new j(this));
    }

    public FutureUserInfo f() {
        return this.f69089a;
    }

    public FutureUserInfo g(TradeType tradeType) {
        return this.f69090b.get(tradeType);
    }

    public boolean h() {
        FutureUserInfo futureUserInfo = this.f69089a;
        return futureUserInfo != null && futureUserInfo.getActiveState() == 1;
    }

    public boolean i(TradeType tradeType) {
        FutureUserInfo g11 = g(tradeType);
        if (g11 == null || g11.getActiveState() != 1) {
            return false;
        }
        return true;
    }
}
