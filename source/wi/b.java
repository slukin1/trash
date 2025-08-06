package wi;

import com.hbg.lib.core.util.ConfigPreferences;
import com.huobi.constants.Environment;

public final class b {
    public static String A;
    public static String B;
    public static String C = "account/login.php";
    public static final String D = (f48038b + "/msg/");
    public static String E = "/user/login/?backUrl=webview";

    /* renamed from: a  reason: collision with root package name */
    public static String f48037a;

    /* renamed from: b  reason: collision with root package name */
    public static String f48038b;

    /* renamed from: c  reason: collision with root package name */
    public static String f48039c;

    /* renamed from: d  reason: collision with root package name */
    public static String f48040d;

    /* renamed from: e  reason: collision with root package name */
    public static String f48041e;

    /* renamed from: f  reason: collision with root package name */
    public static String f48042f;

    /* renamed from: g  reason: collision with root package name */
    public static String f48043g;

    /* renamed from: h  reason: collision with root package name */
    public static String f48044h;

    /* renamed from: i  reason: collision with root package name */
    public static String f48045i;

    /* renamed from: j  reason: collision with root package name */
    public static String f48046j;

    /* renamed from: k  reason: collision with root package name */
    public static String f48047k;

    /* renamed from: l  reason: collision with root package name */
    public static String f48048l;

    /* renamed from: m  reason: collision with root package name */
    public static String f48049m;

    /* renamed from: n  reason: collision with root package name */
    public static String f48050n;

    /* renamed from: o  reason: collision with root package name */
    public static String f48051o;

    /* renamed from: p  reason: collision with root package name */
    public static String f48052p;

    /* renamed from: q  reason: collision with root package name */
    public static String f48053q;

    /* renamed from: r  reason: collision with root package name */
    public static String f48054r;

    /* renamed from: s  reason: collision with root package name */
    public static String f48055s;

    /* renamed from: t  reason: collision with root package name */
    public static String f48056t;

    /* renamed from: u  reason: collision with root package name */
    public static String f48057u;

    /* renamed from: v  reason: collision with root package name */
    public static String f48058v;

    /* renamed from: w  reason: collision with root package name */
    public static String f48059w;

    /* renamed from: x  reason: collision with root package name */
    public static String f48060x;

    /* renamed from: y  reason: collision with root package name */
    public static String f48061y;

    /* renamed from: z  reason: collision with root package name */
    public static String f48062z;

    static {
        a();
    }

    public static void a() {
        ConfigPreferences.e("user_config", "choose_environment", "environment_dev1");
        Environment environment = Environment.RELEASE;
        f48057u = ".huobi.pro";
        f48058v = ".huobi.com";
        B = "prd";
        f48037a = environment.huobi_php;
        f48038b = environment.pro_h5_base;
        C = environment.huobi_login_check;
        f48040d = environment.pro_base;
        f48041e = environment.etf_base;
        f48048l = environment.pro_socket;
        f48049m = environment.hbg_socket;
        f48050n = environment.contractSocketBase;
        f48056t = environment.contractH5Base;
        f48053q = environment.swapH5Base;
        f48045i = environment.swapBase;
        f48051o = environment.swapSocketBase;
        f48052p = environment.linearSwapSocketBase;
        f48054r = environment.optionSocketBase;
        f48039c = environment.uc_base;
        f48042f = environment.otc_base;
        f48047k = environment.m_base;
        f48044h = environment.contract_base;
        f48046j = environment.indexBase;
        f48055s = environment.indexSocketBase;
        f48059w = environment.otcOrderReminderSocket;
        f48060x = environment.riskBase;
        f48043g = environment.institutionBase;
        A = environment.woodPackerBase;
        f48061y = environment.kycWebBaseUrl;
    }
}
