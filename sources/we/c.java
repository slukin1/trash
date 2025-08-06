package we;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.z;
import com.hbg.lib.network.hbg.core.bean.CommentInfo;
import com.hbg.lib.network.hbg.core.bean.LiveSquareBaseData;
import com.hbg.module.libkt.utils.event.bean.CommentNum;
import com.hbg.module.libkt.utils.event.bean.GiftBean;
import com.hbg.module.libkt.utils.event.bean.PageVisible;
import com.hbg.module.libkt.utils.event.bean.RisePut;
import com.hbg.module.libkt.utils.event.bean.ShareNum;
import xe.a;
import xe.b;
import xe.e;
import xe.g;
import xe.h;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f26319a = new c();

    public static /* synthetic */ void A(int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = 0;
        }
        z(i11);
    }

    public static final void B(GiftBean giftBean, int i11, int i12, int[] iArr) {
        b.m("rewardGifts", (Class) null, 2, (Object) null).g(new h(giftBean, i11, i12, iArr));
    }

    public static /* synthetic */ void C(GiftBean giftBean, int i11, int i12, int[] iArr, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            i12 = 0;
        }
        B(giftBean, i11, i12, iArr);
    }

    public static final void D() {
        b.m("rewardDeductionReminder", (Class) null, 2, (Object) null).g(null);
    }

    public static final void E(long j11, int i11) {
        b.m("shareNum", (Class) null, 2, (Object) null).g(new ShareNum(j11, i11));
    }

    public static final void F(String str) {
        b.m("updateGroupId", (Class) null, 2, (Object) null).g(str);
    }

    public static final void G(long j11, int i11, int i12, int i13) {
        b.m("risePut", (Class) null, 2, (Object) null).g(new RisePut(j11, i11, i12, i13));
    }

    public static final void a(LifecycleOwner lifecycleOwner, z<? super CommentNum> zVar) {
        b.m("commentNum", (Class) null, 2, (Object) null).observe(lifecycleOwner, zVar);
    }

    public static final void b(LifecycleOwner lifecycleOwner, z<? super b> zVar) {
        b.m("communityPraise", (Class) null, 2, (Object) null).observe(lifecycleOwner, zVar);
    }

    public static final void c(LifecycleOwner lifecycleOwner, z<? super Object> zVar) {
        b.m("insufficientBalance", (Class) null, 2, (Object) null).observe(lifecycleOwner, zVar);
    }

    public static final void d(LifecycleOwner lifecycleOwner, z<? super Integer> zVar) {
        b.m("integralChange", (Class) null, 2, (Object) null).observe(lifecycleOwner, zVar);
    }

    public static final void e(LifecycleOwner lifecycleOwner, z<? super GiftBean> zVar) {
        b.m("integralGiftChange", (Class) null, 2, (Object) null).observe(lifecycleOwner, zVar);
    }

    public static final void f(LifecycleOwner lifecycleOwner, z<? super a> zVar) {
        b.m("join_num", (Class) null, 2, (Object) null).observe(lifecycleOwner, zVar);
    }

    public static final void g(LifecycleOwner lifecycleOwner, z<? super LiveSquareBaseData> zVar) {
        b.m("liveRefresh", (Class) null, 2, (Object) null).observe(lifecycleOwner, zVar);
    }

    public static final void h(LifecycleOwner lifecycleOwner, z<? super PageVisible> zVar) {
        b.m("pageVisible", (Class) null, 2, (Object) null).observe(lifecycleOwner, zVar);
    }

    public static final void i(LifecycleOwner lifecycleOwner, z<? super Object> zVar) {
        b.m("onTheRankList", (Class) null, 2, (Object) null).observe(lifecycleOwner, zVar);
    }

    public static final void j(LifecycleOwner lifecycleOwner, z<? super Integer> zVar) {
        b.m("refreshGiftPanel", (Class) null, 2, (Object) null).observe(lifecycleOwner, zVar);
    }

    public static final void k(LifecycleOwner lifecycleOwner, z<? super h> zVar) {
        b.m("rewardGifts", (Class) null, 2, (Object) null).observe(lifecycleOwner, zVar);
    }

    public static final void l(LifecycleOwner lifecycleOwner, z<? super Object> zVar) {
        b.m("rewardDeductionReminder", (Class) null, 2, (Object) null).observe(lifecycleOwner, zVar);
    }

    public static final void m(LifecycleOwner lifecycleOwner, z<? super String> zVar) {
        b.m("updateGroupId", (Class) null, 2, (Object) null).observe(lifecycleOwner, zVar);
    }

    public static final void n(int i11, long j11, String str, int i12, int i13, CommentInfo commentInfo, boolean z11, boolean z12, String str2) {
        b.m("commentNum", (Class) null, 2, (Object) null).g(new CommentNum(i11, j11, str, i12, i13, commentInfo, z11, z12, str2));
    }

    public static /* synthetic */ void o(int i11, long j11, String str, int i12, int i13, CommentInfo commentInfo, boolean z11, boolean z12, String str2, int i14, Object obj) {
        int i15 = i14;
        int i16 = (i15 & 1) != 0 ? 1 : i11;
        long j12 = (i15 & 2) != 0 ? 0 : j11;
        String str3 = "";
        String str4 = (i15 & 4) != 0 ? str3 : str;
        boolean z13 = false;
        int i17 = (i15 & 8) != 0 ? 0 : i12;
        int i18 = (i15 & 16) != 0 ? -1 : i13;
        CommentInfo commentInfo2 = (i15 & 32) != 0 ? null : commentInfo;
        boolean z14 = (i15 & 64) != 0 ? false : z11;
        if ((i15 & 128) == 0) {
            z13 = z12;
        }
        if ((i15 & 256) == 0) {
            str3 = str2;
        }
        n(i16, j12, str4, i17, i18, commentInfo2, z14, z13, str3);
    }

    public static final void p(String str, int i11, int i12) {
        b.m("communityPraise", (Class) null, 2, (Object) null).g(new b(str, i11, i12));
    }

    public static final void q(String str, int i11) {
        b.m("followStatus", (Class) null, 2, (Object) null).g(new e(str, i11));
    }

    public static final void r() {
        b.m("insufficientBalance", (Class) null, 2, (Object) null).g(null);
    }

    public static final void s(int i11) {
        b.m("integralChange", (Class) null, 2, (Object) null).g(Integer.valueOf(i11));
    }

    public static final void t(GiftBean giftBean) {
        b.m("integralGiftChange", (Class) null, 2, (Object) null).g(giftBean);
    }

    public static final void u(int i11, int i12) {
        b.m("join_num", (Class) null, 2, (Object) null).g(new a(i11, i12));
    }

    public static final void v(LiveSquareBaseData liveSquareBaseData) {
        b.m("liveRefresh", (Class) null, 2, (Object) null).g(liveSquareBaseData);
    }

    public static final void w() {
        b.m("pageVisible", (Class) null, 2, (Object) null).g(null);
    }

    public static final void x() {
        b.m("onTheRankList", (Class) null, 2, (Object) null).g(null);
    }

    public static final void y(String str, String str2, int i11, int i12, boolean z11) {
        b.m("praiseNum", (Class) null, 2, (Object) null).g(new g(str, str2, i11, i12, z11));
    }

    public static final void z(int i11) {
        b.m("refreshGiftPanel", (Class) null, 2, (Object) null).g(Integer.valueOf(i11));
    }
}
