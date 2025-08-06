package tu;

import android.app.Activity;
import android.app.Application;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MenuItem;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import bh.j;
import com.blankj.utilcode.util.g;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.webview.HBWebView;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.login.bean.WebTarget;
import com.huobi.utils.download.FileDownloadHelper;
import com.huobi.view.bottompopfragmentmenu.BottomMenuFragment;
import com.huobi.view.bottompopfragmentmenu.MenuItem;
import com.huobi.webview2.action.JsBusinessActionHelper;
import com.huobi.webview2.action.JsCommonActionHelper;
import com.huobi.webview2.action.JsFinanceActionHelper;
import com.huobi.webview2.action.JsOtcActionHelper;
import com.luck.picture.lib.config.PictureMimeType;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import pro.huobi.R;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.observables.SyncOnSubscribe;
import sn.f;
import tg.r;
import v6.w;
import x6.h;

public final class c {

    public class a implements h {
        public void a(String str) {
            c.g(str);
        }

        public void b(Activity activity, String str) {
            if (!TextUtils.isEmpty(str)) {
                zn.a.d().m(activity, Uri.parse(str));
            }
        }

        public void c(Activity activity, String str) {
            if (!TextUtils.isEmpty(str)) {
                BaseModuleConfig.a().k0(str);
            }
        }

        public String d(String str) {
            return "BigHuobi/10.54.0 " + str + String.format(" HB_ENV (%s)", new Object[]{com.huobi.domain.d.a()});
        }

        public void e(HBWebView hBWebView, String str) {
            c.i(hBWebView, str);
        }

        public void f(Activity activity, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            c.h(activity, onMenuItemClickListener);
        }

        public void g(String str, String str2, long j11, int i11, String str3) {
        }

        public boolean h(Activity activity, String str, String str2) {
            if (r.x().F0()) {
                return true;
            }
            f.d(activity, new WebTarget("", str, str2, true));
            return false;
        }
    }

    public class b extends BaseSubscriber<Object> {
        public void onNext(Object obj) {
            Application c11 = j.c();
            WebView webView = new WebView(c11);
            webView.clearHistory();
            webView.clearFormData();
            webView.clearCache(true);
            if (Build.VERSION.SDK_INT >= 22) {
                CookieManager.getInstance().removeAllCookies((ValueCallback) null);
                return;
            }
            CookieSyncManager createInstance = CookieSyncManager.createInstance(c11);
            createInstance.startSync();
            CookieManager instance = CookieManager.getInstance();
            instance.removeAllCookie();
            instance.removeSessionCookie();
            createInstance.stopSync();
            createInstance.sync();
        }
    }

    /* renamed from: tu.c$c  reason: collision with other inner class name */
    public class C0211c extends BaseSubscriber<File> {
        /* renamed from: a */
        public void onNext(File file) {
            super.onNext(file);
            if (file != null) {
                HuobiToastUtil.v(j.c().getResources().getString(R.string.n_photo_save_success));
                try {
                    MediaScannerConnection.scanFile(j.c(), new String[]{file.getParentFile().getAbsolutePath()}, (String[]) null, (MediaScannerConnection.OnScanCompletedListener) null);
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            HuobiToastUtil.v(j.c().getResources().getString(R.string.n_photo_save_failure));
            i6.d.b(th2.toString());
        }
    }

    public class d extends SyncOnSubscribe<String, File> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f23403b;

        public d(String str) {
            this.f23403b = str;
        }

        /* renamed from: a */
        public String generateState() {
            return "generateState";
        }

        /* renamed from: b */
        public String next(String str, Observer<? super File> observer) {
            FileDownloadHelper fileDownloadHelper = new FileDownloadHelper();
            String str2 = System.currentTimeMillis() + PictureMimeType.PNG;
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "huobipro");
            if (file.exists() || file.mkdirs()) {
                File file2 = new File(file, str2);
                if (this.f23403b.startsWith("data:image/png;base64")) {
                    byte[] decode = Base64.decode(this.f23403b.split(Constants.ACCEPT_TIME_SEPARATOR_SP)[1], 0);
                    FileOutputStream fileOutputStream = null;
                    try {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                        try {
                            fileOutputStream2.write(decode);
                            fileOutputStream2.close();
                            g.a(fileOutputStream2);
                        } catch (Exception e11) {
                            e = e11;
                            fileOutputStream = fileOutputStream2;
                            try {
                                e.printStackTrace();
                                g.a(fileOutputStream);
                                observer.onNext(file2);
                                observer.onCompleted();
                                return str;
                            } catch (Throwable th2) {
                                th = th2;
                                g.a(fileOutputStream);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            fileOutputStream = fileOutputStream2;
                            g.a(fileOutputStream);
                            throw th;
                        }
                    } catch (Exception e12) {
                        e = e12;
                        e.printStackTrace();
                        g.a(fileOutputStream);
                        observer.onNext(file2);
                        observer.onCompleted();
                        return str;
                    }
                } else {
                    fileDownloadHelper.d(this.f23403b, file2.getAbsolutePath());
                }
                observer.onNext(file2);
                observer.onCompleted();
            } else {
                observer.onError(new Exception());
            }
            return str;
        }
    }

    public static void d() {
        Observable.just(null).observeOn(AndroidSchedulers.mainThread()).subscribe(new b());
    }

    public static void e() {
        w.e().a(JsBusinessActionHelper.class);
        w.e().a(JsFinanceActionHelper.class);
        w.e().a(JsCommonActionHelper.class);
        w.e().a(JsOtcActionHelper.class);
        w.e().k(new a());
        w.e().b();
    }

    public static /* synthetic */ void f(BottomMenuFragment bottomMenuFragment, MenuItem.OnMenuItemClickListener onMenuItemClickListener, View view, com.huobi.view.bottompopfragmentmenu.MenuItem menuItem, int i11) {
        bottomMenuFragment.dismiss();
        onMenuItemClickListener.onMenuItemClick((MenuItem) null);
    }

    public static void g(String str) {
        Observable.create(new d(str)).compose(RxJavaHelper.t((u6.g) null)).subscribe(new C0211c());
    }

    public static void h(Activity activity, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        try {
            BottomMenuFragment bottomMenuFragment = new BottomMenuFragment();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new com.huobi.view.bottompopfragmentmenu.MenuItem("", activity.getString(R.string.n_photo_save), MenuItem.MenuItemStyle.STRESS, new b(bottomMenuFragment, onMenuItemClickListener)));
            bottomMenuFragment.setMenuItems(arrayList);
            bottomMenuFragment.show(activity.getFragmentManager(), "BottomMenuFragment");
        } catch (Throwable unused) {
        }
    }

    public static void i(WebView webView, String str) {
    }
}
