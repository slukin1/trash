package b2;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.alibaba.android.arouter.core.LogisticsCenter;
import com.alibaba.android.arouter.exception.HandlerException;
import com.alibaba.android.arouter.exception.InitException;
import com.alibaba.android.arouter.exception.NoRouteFoundException;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.facade.service.AutowiredService;
import com.alibaba.android.arouter.facade.service.DegradeService;
import com.alibaba.android.arouter.facade.service.InterceptorService;
import com.alibaba.android.arouter.facade.service.PathReplaceService;
import com.alibaba.android.arouter.facade.service.PretreatmentService;
import com.alibaba.android.arouter.facade.template.ILogger;
import com.alibaba.android.arouter.utils.DefaultLogger;
import com.alibaba.android.arouter.utils.TextUtils;
import java.util.concurrent.ThreadPoolExecutor;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static ILogger f12291a = new DefaultLogger(ILogger.defaultTag);

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f12292b = false;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f12293c = false;

    /* renamed from: d  reason: collision with root package name */
    public static volatile boolean f12294d = false;

    /* renamed from: e  reason: collision with root package name */
    public static volatile b f12295e = null;

    /* renamed from: f  reason: collision with root package name */
    public static volatile boolean f12296f = false;

    /* renamed from: g  reason: collision with root package name */
    public static volatile ThreadPoolExecutor f12297g = c2.b.a();

    /* renamed from: h  reason: collision with root package name */
    public static Handler f12298h;

    /* renamed from: i  reason: collision with root package name */
    public static Context f12299i;

    /* renamed from: j  reason: collision with root package name */
    public static InterceptorService f12300j;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Postcard f12301b;

        public a(Postcard postcard) {
            this.f12301b = postcard;
        }

        public void run() {
            Context b11 = b.f12299i;
            Toast.makeText(b11, "There's no route matched!\n Path = [" + this.f12301b.getPath() + "]\n Group = [" + this.f12301b.getGroup() + "]", 1).show();
        }
    }

    /* renamed from: b2.b$b  reason: collision with other inner class name */
    public class C0062b implements InterceptorCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f12303a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f12304b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ NavigationCallback f12305c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Postcard f12306d;

        public C0062b(Context context, int i11, NavigationCallback navigationCallback, Postcard postcard) {
            this.f12303a = context;
            this.f12304b = i11;
            this.f12305c = navigationCallback;
            this.f12306d = postcard;
        }

        public void onContinue(Postcard postcard) {
            Object unused = b.this.a(this.f12303a, postcard, this.f12304b, this.f12305c);
        }

        public void onInterrupt(Throwable th2) {
            NavigationCallback navigationCallback = this.f12305c;
            if (navigationCallback != null) {
                navigationCallback.onInterrupt(this.f12306d);
            }
            ILogger iLogger = b.f12291a;
            iLogger.info(ILogger.defaultTag, "Navigation failed, termination by interceptor : " + th2.getMessage());
        }
    }

    public class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f12308b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f12309c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Intent f12310d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Postcard f12311e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NavigationCallback f12312f;

        public c(int i11, Context context, Intent intent, Postcard postcard, NavigationCallback navigationCallback) {
            this.f12308b = i11;
            this.f12309c = context;
            this.f12310d = intent;
            this.f12311e = postcard;
            this.f12312f = navigationCallback;
        }

        public void run() {
            b.this.q(this.f12308b, this.f12309c, this.f12310d, this.f12311e, this.f12312f);
        }
    }

    public static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f12314a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.alibaba.android.arouter.facade.enums.RouteType[] r0 = com.alibaba.android.arouter.facade.enums.RouteType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f12314a = r0
                com.alibaba.android.arouter.facade.enums.RouteType r1 = com.alibaba.android.arouter.facade.enums.RouteType.ACTIVITY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f12314a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.alibaba.android.arouter.facade.enums.RouteType r1 = com.alibaba.android.arouter.facade.enums.RouteType.PROVIDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f12314a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.alibaba.android.arouter.facade.enums.RouteType r1 = com.alibaba.android.arouter.facade.enums.RouteType.BOARDCAST     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f12314a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.alibaba.android.arouter.facade.enums.RouteType r1 = com.alibaba.android.arouter.facade.enums.RouteType.CONTENT_PROVIDER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f12314a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.alibaba.android.arouter.facade.enums.RouteType r1 = com.alibaba.android.arouter.facade.enums.RouteType.FRAGMENT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f12314a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.alibaba.android.arouter.facade.enums.RouteType r1 = com.alibaba.android.arouter.facade.enums.RouteType.METHOD     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f12314a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.alibaba.android.arouter.facade.enums.RouteType r1 = com.alibaba.android.arouter.facade.enums.RouteType.SERVICE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: b2.b.d.<clinit>():void");
        }
    }

    public static void e() {
        f12300j = (InterceptorService) a.d().a("/arouter/service/interceptor").navigation();
    }

    @Deprecated
    public static boolean h() {
        return f12294d;
    }

    public static boolean i() {
        return f12293c;
    }

    public static b k() {
        if (f12296f) {
            if (f12295e == null) {
                synchronized (b.class) {
                    if (f12295e == null) {
                        f12295e = new b();
                    }
                }
            }
            return f12295e;
        }
        throw new InitException("ARouterCore::Init::Invoke init(context) first!");
    }

    public static synchronized boolean l(Application application) {
        synchronized (b.class) {
            f12299i = application;
            LogisticsCenter.c(application, f12297g);
            f12291a.info(ILogger.defaultTag, "ARouter init success!");
            f12296f = true;
            f12298h = new Handler(Looper.getMainLooper());
        }
        return true;
    }

    public static void m(Object obj) {
        AutowiredService autowiredService = (AutowiredService) a.d().a("/arouter/service/autowired").navigation();
        if (autowiredService != null) {
            autowiredService.autowire(obj);
        }
    }

    public final Object a(Context context, Postcard postcard, int i11, NavigationCallback navigationCallback) {
        if (context == null) {
            context = f12299i;
        }
        Context context2 = context;
        int i12 = d.f12314a[postcard.getType().ordinal()];
        if (i12 == 1) {
            Intent intent = new Intent(context2, postcard.getDestination());
            intent.putExtras(postcard.getExtras());
            int flags = postcard.getFlags();
            if (-1 != flags) {
                intent.setFlags(flags);
            } else if (!(context2 instanceof Activity)) {
                intent.setFlags(268435456);
            }
            String action = postcard.getAction();
            if (!TextUtils.c(action)) {
                intent.setAction(action);
            }
            p(new c(i11, context2, intent, postcard, navigationCallback));
            return null;
        } else if (i12 == 2) {
            return postcard.getProvider();
        } else {
            if (i12 == 3 || i12 == 4 || i12 == 5) {
                try {
                    Object newInstance = postcard.getDestination().getConstructor(new Class[0]).newInstance(new Object[0]);
                    if (newInstance instanceof Fragment) {
                        ((Fragment) newInstance).setArguments(postcard.getExtras());
                    } else if (newInstance instanceof androidx.fragment.app.Fragment) {
                        ((androidx.fragment.app.Fragment) newInstance).setArguments(postcard.getExtras());
                    }
                    return newInstance;
                } catch (Exception e11) {
                    ILogger iLogger = f12291a;
                    iLogger.error(ILogger.defaultTag, "Fetch fragment instance error, " + TextUtils.a(e11.getStackTrace()));
                }
            }
            return null;
        }
    }

    public Postcard f(String str) {
        if (!TextUtils.c(str)) {
            PathReplaceService pathReplaceService = (PathReplaceService) a.d().h(PathReplaceService.class);
            if (pathReplaceService != null) {
                str = pathReplaceService.forString(str);
            }
            return g(str, j(str));
        }
        throw new HandlerException("ARouter::Parameter is invalid!");
    }

    public Postcard g(String str, String str2) {
        if (TextUtils.c(str) || TextUtils.c(str2)) {
            throw new HandlerException("ARouter::Parameter is invalid!");
        }
        PathReplaceService pathReplaceService = (PathReplaceService) a.d().h(PathReplaceService.class);
        if (pathReplaceService != null) {
            str = pathReplaceService.forString(str);
        }
        return new Postcard(str, str2);
    }

    public final String j(String str) {
        if (TextUtils.c(str) || !str.startsWith("/")) {
            throw new HandlerException("ARouter::Extract the default group failed, the path must be start with '/' and contain more than 2 '/'!");
        }
        try {
            String substring = str.substring(1, str.indexOf("/", 1));
            if (!TextUtils.c(substring)) {
                return substring;
            }
            throw new HandlerException("ARouter::Extract the default group failed! There's nothing between 2 '/'!");
        } catch (Exception e11) {
            ILogger iLogger = f12291a;
            iLogger.warning(ILogger.defaultTag, "Failed to extract default group! " + e11.getMessage());
            return null;
        }
    }

    public Object n(Context context, Postcard postcard, int i11, NavigationCallback navigationCallback) {
        PretreatmentService pretreatmentService = (PretreatmentService) a.d().h(PretreatmentService.class);
        if (pretreatmentService != null && !pretreatmentService.onPretreatment(context, postcard)) {
            return null;
        }
        try {
            LogisticsCenter.b(postcard);
            if (navigationCallback != null) {
                navigationCallback.onFound(postcard);
            }
            if (postcard.isGreenChannel()) {
                return a(context, postcard, i11, navigationCallback);
            }
            f12300j.doInterceptions(postcard, new C0062b(context, i11, navigationCallback, postcard));
            return null;
        } catch (NoRouteFoundException e11) {
            f12291a.warning(ILogger.defaultTag, e11.getMessage());
            if (i()) {
                p(new a(postcard));
            }
            if (navigationCallback != null) {
                navigationCallback.onLost(postcard);
            } else {
                DegradeService degradeService = (DegradeService) a.d().h(DegradeService.class);
                if (degradeService != null) {
                    degradeService.onLost(context, postcard);
                }
            }
            return null;
        }
    }

    public <T> T o(Class<? extends T> cls) {
        try {
            Postcard a11 = LogisticsCenter.a(cls.getName());
            if (a11 == null) {
                a11 = LogisticsCenter.a(cls.getSimpleName());
            }
            if (a11 == null) {
                return null;
            }
            LogisticsCenter.b(a11);
            return a11.getProvider();
        } catch (NoRouteFoundException e11) {
            f12291a.warning(ILogger.defaultTag, e11.getMessage());
            return null;
        }
    }

    public final void p(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            f12298h.post(runnable);
        } else {
            runnable.run();
        }
    }

    public final void q(int i11, Context context, Intent intent, Postcard postcard, NavigationCallback navigationCallback) {
        if (i11 < 0) {
            ContextCompat.startActivity(context, intent, postcard.getOptionsBundle());
        } else if (context instanceof Activity) {
            ActivityCompat.startActivityForResult((Activity) context, intent, i11, postcard.getOptionsBundle());
        } else {
            f12291a.warning(ILogger.defaultTag, "Must use [navigation(activity, ...)] to support [startActivityForResult]");
        }
        if (!(-1 == postcard.getEnterAnim() || -1 == postcard.getExitAnim() || !(context instanceof Activity))) {
            ((Activity) context).overridePendingTransition(postcard.getEnterAnim(), postcard.getExitAnim());
        }
        if (navigationCallback != null) {
            navigationCallback.onArrival(postcard);
        }
    }
}
