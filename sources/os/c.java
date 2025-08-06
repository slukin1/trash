package os;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import bh.j;
import com.hbg.lib.common.utils.SystemUtils;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.hbg.core.VipLevel;
import com.hbg.lib.network.hbg.core.bean.VipFeeInfo;
import com.hbg.lib.network.hbg.core.bean.VipInfoResult;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.domain.DomainSwitcher;
import com.huochat.community.network.domain.DomainTool;
import i6.k;
import java.util.List;
import pro.huobi.R;
import rx.Observable;
import rx.schedulers.Schedulers;
import tg.r;
import u6.g;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static List<VipLevel> f84544a;

    /* renamed from: b  reason: collision with root package name */
    public static VipInfoResult f84545b;

    /* renamed from: c  reason: collision with root package name */
    public static VipFeeInfo f84546c;

    public class a extends RequestCallback1<VipInfoResult> {
        /* renamed from: a */
        public void onRequestSuccess(VipInfoResult vipInfoResult) {
            VipInfoResult unused = c.f84545b = vipInfoResult;
            if (vipInfoResult == null) {
                HuobiToastUtil.t(j.c(), R.string.string_login_ok);
            } else if (c.h() == 0) {
                HuobiToastUtil.t(j.c(), R.string.string_login_ok);
            } else {
                tg.e.d(j.c());
            }
        }

        public void onRequestFailure(Throwable th2) {
        }
    }

    public class b extends RequestCallback1<VipInfoResult> {
        /* renamed from: a */
        public void onRequestSuccess(VipInfoResult vipInfoResult) {
            VipInfoResult unused = c.f84545b = vipInfoResult;
        }

        public void onRequestFailure(Throwable th2) {
        }
    }

    /* renamed from: os.c$c  reason: collision with other inner class name */
    public class C0881c extends RequestCallback1<List<VipLevel>> {
        /* renamed from: a */
        public void onRequestSuccess(List<VipLevel> list) {
            i6.d.b("UserVipConfigHelper-->requestVipLevels-->" + list);
            List unused = c.f84544a = list;
        }

        public void onRequestFailure(Throwable th2) {
            i6.d.f("UserVipConfigHelper-->requestVipLevels-->", th2);
        }
    }

    public class d extends BaseSubscriber<Pair> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c6.a f84547b;

        public d(c6.a aVar) {
            this.f84547b = aVar;
        }

        /* renamed from: a */
        public void onNext(Pair pair) {
            List list;
            if (pair != null) {
                Pair pair2 = (Pair) pair.first;
                VipFeeInfo vipFeeInfo = (VipFeeInfo) pair.second;
                VipInfoResult vipInfoResult = null;
                if (pair2 != null) {
                    vipInfoResult = (VipInfoResult) pair2.first;
                    list = (List) pair2.second;
                    if (vipInfoResult != null) {
                        VipInfoResult unused = c.f84545b = vipInfoResult;
                    }
                    if (list != null && !list.isEmpty()) {
                        List unused2 = c.f84544a = list;
                    }
                } else {
                    list = null;
                }
                if (vipFeeInfo != null) {
                    VipFeeInfo unused3 = c.f84546c = vipFeeInfo;
                }
                k.o("requestVipInfoFee", "result:" + vipInfoResult + " levelList:" + list + " feeInfo:" + vipFeeInfo);
                c6.a aVar = this.f84547b;
                if (aVar != null) {
                    aVar.a();
                }
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            k.f("requestVipInfoFee", "error:" + th2.getMessage());
        }
    }

    public class e extends RequestCallback1<VipInfoResult> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RequestCallback1 f84548a;

        public e(RequestCallback1 requestCallback1) {
            this.f84548a = requestCallback1;
        }

        /* renamed from: a */
        public void onRequestSuccess(VipInfoResult vipInfoResult) {
            VipInfoResult unused = c.f84545b = vipInfoResult;
            i6.d.b("UserVipConfigHelper-->requestVipInfo-->" + vipInfoResult);
            RequestCallback1 requestCallback1 = this.f84548a;
            if (requestCallback1 != null) {
                requestCallback1.onRequestSuccess(c.f84545b);
            }
        }

        public void onRequestFailure(Throwable th2) {
            i6.d.f("UserVipConfigHelper-->requestVipInfo-->", th2);
            RequestCallback1 requestCallback1 = this.f84548a;
            if (requestCallback1 != null) {
                requestCallback1.onRequestFailure(th2);
            }
        }
    }

    public static void g() {
        f84545b = null;
        f84546c = null;
        e.b().a();
    }

    public static int h() {
        VipInfoResult vipInfoResult;
        if (!r.x().F0() || (vipInfoResult = f84545b) == null) {
            return 0;
        }
        return vipInfoResult.getLevel();
    }

    public static void i() {
        o(new a());
    }

    public static void j() {
        o(new b());
    }

    public static Intent k(Activity activity) {
        String curLanguageUrlLowerCase = AppLanguageHelper.getInstance().getCurLanguageUrlLowerCase();
        String str = DomainTool.DOMAIN_PREFIX + DomainSwitcher.w();
        if (!SystemUtils.c()) {
            str = wi.b.f48038b;
        }
        String format = String.format(str + "/%1$s/topic/vip/h5/rule/?hideNav=1", new Object[]{curLanguageUrlLowerCase});
        if (TextUtils.isEmpty(format)) {
            return null;
        }
        Intent webViewIntent = HBBaseWebActivity.getWebViewIntent(activity, format, "", "", false);
        webViewIntent.putExtra("EXTRA_FORCE_JUMP_VIP_RULE", true);
        return webViewIntent;
    }

    public static boolean l() {
        VipInfoResult vipInfoResult = f84545b;
        if (vipInfoResult == null) {
            return false;
        }
        int level = vipInfoResult.getLevel();
        return level == 1 || level == 2 || level == 3 || level == 4 || level == 5;
    }

    public static /* synthetic */ VipFeeInfo m(Throwable th2) {
        return null;
    }

    public static /* synthetic */ Pair n(VipInfoResult vipInfoResult, List list, VipFeeInfo vipFeeInfo) {
        return new Pair(new Pair(vipInfoResult, list), vipFeeInfo);
    }

    public static void o(RequestCallback1<VipInfoResult> requestCallback1) {
        VipInfoResult vipInfoResult = f84545b;
        if (vipInfoResult == null) {
            v7.b.a().getVipInfo().d(new e(requestCallback1));
        } else if (requestCallback1 != null) {
            requestCallback1.onRequestSuccess(vipInfoResult);
        }
    }

    public static void p(c6.a aVar) {
        Observable.zip(v7.b.a().getVipInfo().b().subscribeOn(Schedulers.io()), v7.b.a().getVipLevels().b().subscribeOn(Schedulers.io()), v7.b.a().getVipFeeInfo().b().subscribeOn(Schedulers.io()).retry(3).onErrorReturn(a.f25596b), b.f25597b).compose(RxJavaHelper.t((g) null)).subscribe(new d(aVar));
    }

    public static void q() {
        v7.b.a().getVipLevels().d(new C0881c());
    }
}
