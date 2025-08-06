package b7;

import android.text.TextUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.RankJumpInfo;
import com.hbg.lib.network.hbg.core.bean.RankJumpTitle;
import com.hbg.lib.network.hbg.core.bean.RankScreenBean;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import u6.g;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static RankJumpInfo f68395a = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f68396b = 2;

    /* renamed from: c  reason: collision with root package name */
    public static String f68397c = "USDT";

    /* renamed from: d  reason: collision with root package name */
    public static a f68398d = null;

    /* renamed from: e  reason: collision with root package name */
    public static String f68399e = "";

    public class a extends BaseSubscriber<RankJumpInfo> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f68400b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f68401c;

        public a(String str, int i11) {
            this.f68400b = str;
            this.f68401c = i11;
        }

        /* renamed from: a */
        public void onNext(RankJumpInfo rankJumpInfo) {
            super.onNext(rankJumpInfo);
            if (TextUtils.equals(b.f68399e, b.f(this.f68400b, this.f68401c))) {
                RankJumpInfo unused = b.f68395a = rankJumpInfo;
                if (b.f68398d != null && b.f68395a != null) {
                    b.f68395a.setRankType(Integer.valueOf(this.f68401c));
                    if (b.f68395a.getTitle() != null && !TextUtils.isEmpty(b.f68395a.getTitle().getName())) {
                        b.f68398d.a(b.f68395a.getTitle().getName());
                    }
                }
            }
        }
    }

    public static String f(String str, int i11) {
        return str + "_" + i11;
    }

    public static RankJumpInfo g() {
        if (f68395a == null) {
            i();
        }
        return f68395a;
    }

    public static void h(String str, int i11) {
        i();
        if (i11 == 2 || i11 == 5) {
            str = RankScreenBean.SCREEN_VALUE_SPOT;
        }
        f68399e = f(str, i11);
        v7.b.a().o(i11, str).b().compose(RxJavaHelper.t((g) null)).subscribe(new a(str, i11));
    }

    public static void i() {
        RankJumpTitle rankJumpTitle = new RankJumpTitle();
        rankJumpTitle.setSort(0);
        rankJumpTitle.setSortType(1);
        RankJumpInfo rankJumpInfo = new RankJumpInfo();
        f68395a = rankJumpInfo;
        rankJumpInfo.setPrimaryTitle(Integer.valueOf(f68396b));
        f68395a.setSecondaryTitle(f68397c);
        f68395a.setFilter(-1);
        f68395a.setTitle(rankJumpTitle);
        f68395a.setRankType(-1);
        f68395a.setTarget(1);
    }

    public static void j(a aVar) {
        f68398d = aVar;
    }

    public static void k(int i11) {
        f68396b = i11;
    }

    public static void l(String str) {
        f68397c = str;
    }
}
