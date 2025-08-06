package eh;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.FileProvider;
import bh.j;
import com.hbg.lib.common.utils.FileUtil;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.ChannelUtils;
import com.hbg.lib.core.util.PhoneUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.appupgrade.helper.AppUpgradeDownloadHelper;
import com.huobi.appupgrade.ui.AppUpgradeActivity;
import com.huobi.appupgrade.ui.AppUpgradeNotificationView;
import com.huobi.entity.UpdateResponse;
import com.huobi.index.api.IndexService;
import com.tencent.android.tpush.common.Constants;
import i6.d;
import i6.k;
import i6.m;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import tq.p;
import u6.g;

public final class h {

    /* renamed from: g  reason: collision with root package name */
    public static final h f47496g = new h();

    /* renamed from: a  reason: collision with root package name */
    public int f47497a = 0;

    /* renamed from: b  reason: collision with root package name */
    public AppUpgradeDownloadHelper f47498b;

    /* renamed from: c  reason: collision with root package name */
    public UpdateResponse f47499c;

    /* renamed from: d  reason: collision with root package name */
    public final List<b> f47500d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public int f47501e = 0;

    /* renamed from: f  reason: collision with root package name */
    public AppUpgradeNotificationView f47502f = new AppUpgradeNotificationView();

    public class a implements Observer<String> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(String str) {
            if ("100".equals(str)) {
                int unused = h.this.f47497a = 0;
                d.j("UPGRADE", "doUpgradeApp download ");
                h.y(new File(j.c().getCacheDir(), "huobi_upgrade.apk"));
                if (!h.this.f47500d.isEmpty()) {
                    for (b b11 : h.this.f47500d) {
                        b11.b(1, (String) null);
                    }
                }
            }
        }

        public void onCompleted() {
            k.f("UPGRADE", "doUpgradeApp completed");
            int unused = h.this.f47497a = 0;
            h.this.f47502f.c();
        }

        public void onError(Throwable th2) {
            th2.printStackTrace();
            k.g("UPGRADE", "doUpgradeApp error ", th2);
            HuobiToastUtil.l(j.c(), j.c().getString(R.string.server_error));
            int unused = h.this.f47497a = 0;
            h.this.f47502f.a();
            if (!h.this.f47500d.isEmpty()) {
                for (b b11 : h.this.f47500d) {
                    b11.b(10, (String) null);
                }
            }
        }
    }

    public interface b {
        void a(int i11);

        void b(int i11, String str);
    }

    public static Observable<UpdateResponse> B() {
        HashMap hashMap = new HashMap();
        hashMap.put("a", "update");
        hashMap.put("agent", "android");
        hashMap.put("version", 105400);
        hashMap.put(Constants.FLAG_DEVICE_ID, PhoneUtils.r());
        hashMap.put("userAgent", "M:huobiapp:phone:android");
        hashMap.put("lang", AppLanguageHelper.getInstance().getCurLanguageHeader());
        hashMap.put("utm_source", ChannelUtils.a());
        hashMap.put("phOS", PhoneUtils.p());
        hashMap.put("phName", PhoneUtils.f());
        return ((IndexService) p.V(IndexService.class)).requestAppUpdateInfo(hashMap).doOnNext(g.f54331b);
    }

    public static void m() {
        File file = new File(j.c().getCacheDir(), "huobi_upgrade.apk.part");
        File file2 = new File(j.c().getCacheDir(), "huobi_upgrade.apk");
        FileUtil.h(file.getAbsolutePath());
        FileUtil.h(file2.getAbsolutePath());
    }

    public static h q() {
        return f47496g;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t(String str) {
        this.f47502f.d(m.k0(str));
        this.f47501e = m.k0(str);
        k.f("UPGRADE", "doUpgradeApp doOnNext:" + this.f47501e);
        if (!this.f47500d.isEmpty()) {
            for (b a11 : this.f47500d) {
                a11.a(m.k0(str));
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u() {
        this.f47497a = 1;
        this.f47502f.b();
        m();
    }

    public static /* synthetic */ void v(Subscriber subscriber, String str) {
        if (!"100".equals(str)) {
            subscriber.onNext(str);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w(Subscriber subscriber) {
        subscriber.onStart();
        m();
        this.f47498b.e(new c(subscriber));
        if (this.f47498b.c(this.f47499c.getDirect_downloadurl(), new File(j.c().getCacheDir(), "huobi_upgrade.apk.part").getAbsolutePath(), this.f47499c.getMd5(), 0)) {
            subscriber.onNext("100");
        } else {
            k.f("UPGRADE", "doUpgradeApp error downloadResult false");
            subscriber.onError(new RuntimeException("downloadError"));
        }
        subscriber.onCompleted();
        this.f47498b.e((b) null);
    }

    public static void y(File file) {
        Intent intent = new Intent("android.intent.action.VIEW");
        if (Build.VERSION.SDK_INT >= 24) {
            intent.setDataAndType(FileProvider.getUriForFile(j.c(), "pro.huobi.fileprovider", file), "application/vnd.android.package-archive");
            intent.addFlags(268435459);
        } else {
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            intent.setFlags(268435456);
        }
        j.c().startActivity(intent);
    }

    public static void z(Activity activity, UpdateResponse updateResponse) {
        k.f("AppConfigAboutUsActivity", "openUpgradeAppActivity");
        Intent intent = new Intent(activity, AppUpgradeActivity.class);
        intent.putExtra("MSG", updateResponse);
        intent.addFlags(65536);
        activity.overridePendingTransition(0, 0);
        activity.startActivity(intent);
    }

    public void A(b bVar) {
        this.f47500d.remove(bVar);
    }

    public void j(b bVar) {
        this.f47500d.add(bVar);
    }

    public void k(UpdateResponse updateResponse) {
        this.f47499c = updateResponse;
        d.j("UPGRADE", "cache info " + updateResponse.toString());
    }

    public void l() {
        this.f47502f.a();
    }

    public void n() {
        d.j("UPGRADE", "doUpgradeApp curStatus = " + this.f47497a);
        if (this.f47497a == 1) {
            HuobiToastUtil.l(j.c(), j.c().getString(R.string.upgrade_later));
            return;
        }
        k.f("UPGRADE", "doUpgradeApp start");
        this.f47501e = 0;
        p().compose(RxJavaHelper.t((g) null)).doOnNext(new f(this)).last().delay(1, TimeUnit.SECONDS).doOnSubscribe(new e(this)).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a());
    }

    public UpdateResponse o() {
        return this.f47499c;
    }

    public final Observable<String> p() {
        if (this.f47498b == null) {
            this.f47498b = new AppUpgradeDownloadHelper();
        }
        return Observable.create(new d(this));
    }

    public int r() {
        return this.f47501e;
    }

    public boolean s() {
        return this.f47497a == 1;
    }
}
