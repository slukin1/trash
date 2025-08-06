package cn.sharesdk.framework;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import cn.sharesdk.framework.AgreementDialog;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.a.a;
import cn.sharesdk.framework.a.a.e;
import cn.sharesdk.framework.loopshare.MoblinkActionListener;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.onekeyshare.OnekeyShare;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.iproov.sdk.bridge.OptionsBridge;
import com.mob.MobSDK;
import com.mob.commons.ForbThrowable;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.ResHelper;
import com.sumsub.sns.internal.core.analytics.d;
import java.util.HashMap;

public class g {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Platform f13441a;

    /* renamed from: b  reason: collision with root package name */
    private PlatformDb f13442b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public e f13443c;

    /* renamed from: d  reason: collision with root package name */
    private int f13444d;

    /* renamed from: e  reason: collision with root package name */
    private int f13445e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f13446f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f13447g = true;

    /* renamed from: h  reason: collision with root package name */
    private boolean f13448h;

    public g(Platform platform) {
        this.f13441a = platform;
        String name = platform.getName();
        this.f13442b = new PlatformDb(name, platform.getVersion());
        a(name);
        this.f13443c = new e();
        c.a();
    }

    private String b(int i11) {
        if (i11 == 1) {
            return "ACTION_AUTHORIZING";
        }
        if (i11 == 2) {
            return "ACTION_GETTING_FRIEND_LIST";
        }
        switch (i11) {
            case 5:
                return "ACTION_SENDING_DIRECT_MESSAGE";
            case 6:
                return "ACTION_FOLLOWING_USER";
            case 7:
                return "ACTION_TIMELINE";
            case 8:
                return "ACTION_USER_INFOR";
            case 9:
                return "ACTION_SHARE";
            case 10:
                return "ACTION_GETTING_BILATERAL_LIST";
            case 11:
                return "ACTION_GETTING_FOLLOWER_LIST";
            default:
                return "ACTION_CUSTOMER";
        }
    }

    /* access modifiers changed from: private */
    public boolean j() {
        if (ShareSDK.b()) {
            this.f13447g = !d.f31895b.equals(a(this.f13441a.getPlatformId(), "covert_url", (String) null));
            this.f13441a.setNetworkDevinfo();
            return true;
        }
        try {
            ShareSDK.a((ShareSDKCallback<Boolean>) new ShareSDKCallback<Boolean>() {
                /* renamed from: a */
                public void onCallback(Boolean bool) {
                    if (bool.booleanValue()) {
                        g gVar = g.this;
                        String a11 = gVar.a(gVar.f13441a.getPlatformId(), "covert_url", (String) null);
                        if (a11 != null) {
                            a11 = a11.trim();
                        }
                        boolean unused = g.this.f13447g = !d.f31895b.equals(a11);
                        g.this.f13441a.setNetworkDevinfo();
                    }
                }
            });
            return false;
        } catch (Throwable th2) {
            SSDKLog.b().b(th2);
            return false;
        }
    }

    private String k() {
        StringBuilder sb2 = new StringBuilder();
        try {
            if ("TencentWeibo".equals(this.f13441a.getName())) {
                SSDKLog.b().c("user id %s ==>>", g().getUserName());
                sb2.append(Data.urlEncode(g().getUserName(), "utf-8"));
            } else {
                sb2.append(Data.urlEncode(g().getUserId(), "utf-8"));
            }
            sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb2.append(Data.urlEncode(g().get("secretType"), "utf-8"));
            sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb2.append(Data.urlEncode(g().get("gender"), "utf-8"));
            sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb2.append(Data.urlEncode(g().get("birthday"), "utf-8"));
            sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb2.append(Data.urlEncode(g().get("educationJSONArrayStr"), "utf-8"));
            sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb2.append(Data.urlEncode(g().get("workJSONArrayStr"), "utf-8"));
        } catch (Throwable th2) {
            SSDKLog.b().b(th2);
        }
        return sb2.toString();
    }

    public boolean d() {
        return this.f13442b.isValid();
    }

    public boolean e() {
        return this.f13446f;
    }

    public boolean f() {
        return this.f13448h;
    }

    public PlatformDb g() {
        return this.f13442b;
    }

    public void h() {
        this.f13442b.removeAccount();
    }

    public PlatformActionListener i() {
        return this.f13443c;
    }

    public PlatformActionListener c() {
        return this.f13443c.a();
    }

    public String d(String str) {
        return ShareSDK.a(str);
    }

    public int b() {
        return this.f13445e;
    }

    public void c(final int i11, final Object obj) {
        new Thread(a(i11)) {
            public void run() {
                try {
                    if (!MobSDK.isForb() && a.a()) {
                        int isAuth = MobSDK.isAuth();
                        if (isAuth == 1 || isAuth == 2) {
                            boolean unused = g.this.j();
                            SSDKLog.b().a("The user is using the privacy version without a popup newThreadJob 001");
                        }
                    }
                } catch (Throwable th2) {
                    SSDKLog b11 = SSDKLog.b();
                    b11.a("newThreadJob  " + th2);
                }
            }
        }.start();
        new Thread() {
            /* JADX WARNING: Can't wrap try/catch for region: R(3:18|19|38) */
            /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
                cn.sharesdk.framework.ProvicyCanContinue.a().a(new cn.sharesdk.framework.g.AnonymousClass6.AnonymousClass1(r4));
             */
            /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
                return;
             */
            /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0073 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r4 = this;
                    boolean r0 = com.mob.MobSDK.isForb()     // Catch:{ all -> 0x00c5 }
                    if (r0 == 0) goto L_0x0013
                    cn.sharesdk.framework.g r0 = cn.sharesdk.framework.g.this     // Catch:{ all -> 0x00c5 }
                    cn.sharesdk.framework.e r1 = r0.f13443c     // Catch:{ all -> 0x00c5 }
                    int r2 = r3     // Catch:{ all -> 0x00c5 }
                    r0.a((cn.sharesdk.framework.e) r1, (int) r2)     // Catch:{ all -> 0x00c5 }
                    goto L_0x00e1
                L_0x0013:
                    int r0 = com.mob.MobSDK.isAuth()     // Catch:{ all -> 0x0073 }
                    r1 = 1
                    if (r0 == r1) goto L_0x003d
                    r1 = 2
                    if (r0 == r1) goto L_0x003d
                    cn.sharesdk.framework.g r0 = cn.sharesdk.framework.g.this     // Catch:{ all -> 0x0073 }
                    cn.sharesdk.framework.e r0 = r0.f13443c     // Catch:{ all -> 0x0073 }
                    if (r0 == 0) goto L_0x00e1
                    cn.sharesdk.framework.g r0 = cn.sharesdk.framework.g.this     // Catch:{ all -> 0x0073 }
                    cn.sharesdk.framework.e r0 = r0.f13443c     // Catch:{ all -> 0x0073 }
                    cn.sharesdk.framework.g r1 = cn.sharesdk.framework.g.this     // Catch:{ all -> 0x0073 }
                    cn.sharesdk.framework.Platform r1 = r1.f13441a     // Catch:{ all -> 0x0073 }
                    int r2 = r3     // Catch:{ all -> 0x0073 }
                    com.mob.commons.dialog.PolicyThrowable r3 = new com.mob.commons.dialog.PolicyThrowable     // Catch:{ all -> 0x0073 }
                    r3.<init>()     // Catch:{ all -> 0x0073 }
                    r0.onError(r1, r2, r3)     // Catch:{ all -> 0x0073 }
                    goto L_0x00e1
                L_0x003d:
                    boolean r0 = cn.sharesdk.framework.a.a()     // Catch:{ all -> 0x0073 }
                    if (r0 != 0) goto L_0x0050
                    cn.sharesdk.framework.g r0 = cn.sharesdk.framework.g.this     // Catch:{ all -> 0x0073 }
                    cn.sharesdk.framework.e r1 = r0.f13443c     // Catch:{ all -> 0x0073 }
                    int r2 = r3     // Catch:{ all -> 0x0073 }
                    r0.b((cn.sharesdk.framework.e) r1, (int) r2)     // Catch:{ all -> 0x0073 }
                    goto L_0x00e1
                L_0x0050:
                    cn.sharesdk.framework.g r0 = cn.sharesdk.framework.g.this     // Catch:{ all -> 0x0073 }
                    cn.sharesdk.framework.Platform r0 = r0.f13441a     // Catch:{ all -> 0x0073 }
                    int r1 = r3     // Catch:{ all -> 0x0073 }
                    java.lang.Object r2 = r4     // Catch:{ all -> 0x0073 }
                    boolean r0 = r0.checkAuthorize(r1, r2)     // Catch:{ all -> 0x0073 }
                    if (r0 == 0) goto L_0x00e1
                    cn.sharesdk.framework.g r0 = cn.sharesdk.framework.g.this     // Catch:{ all -> 0x0073 }
                    int r1 = r3     // Catch:{ all -> 0x0073 }
                    java.lang.Object r2 = r4     // Catch:{ all -> 0x0073 }
                    r0.b((int) r1, (java.lang.Object) r2)     // Catch:{ all -> 0x0073 }
                    cn.sharesdk.framework.utils.SSDKLog r0 = cn.sharesdk.framework.utils.SSDKLog.b()     // Catch:{ all -> 0x0073 }
                    java.lang.String r1 = "The user is using the privacy version without a popup newThreadJob 002"
                    r0.a((java.lang.String) r1)     // Catch:{ all -> 0x0073 }
                    goto L_0x00e1
                L_0x0073:
                    cn.sharesdk.framework.ProvicyCanContinue r0 = cn.sharesdk.framework.ProvicyCanContinue.a()     // Catch:{ all -> 0x0080 }
                    cn.sharesdk.framework.g$6$1 r1 = new cn.sharesdk.framework.g$6$1     // Catch:{ all -> 0x0080 }
                    r1.<init>()     // Catch:{ all -> 0x0080 }
                    r0.a(r1)     // Catch:{ all -> 0x0080 }
                    goto L_0x00e1
                L_0x0080:
                    r0 = move-exception
                    boolean r1 = cn.sharesdk.framework.a.a()     // Catch:{ all -> 0x00c5 }
                    if (r1 != 0) goto L_0x0093
                    cn.sharesdk.framework.g r1 = cn.sharesdk.framework.g.this     // Catch:{ all -> 0x00c5 }
                    cn.sharesdk.framework.e r2 = r1.f13443c     // Catch:{ all -> 0x00c5 }
                    int r3 = r3     // Catch:{ all -> 0x00c5 }
                    r1.b((cn.sharesdk.framework.e) r2, (int) r3)     // Catch:{ all -> 0x00c5 }
                    goto L_0x00ac
                L_0x0093:
                    cn.sharesdk.framework.g r1 = cn.sharesdk.framework.g.this     // Catch:{ all -> 0x00c5 }
                    cn.sharesdk.framework.Platform r1 = r1.f13441a     // Catch:{ all -> 0x00c5 }
                    int r2 = r3     // Catch:{ all -> 0x00c5 }
                    java.lang.Object r3 = r4     // Catch:{ all -> 0x00c5 }
                    boolean r1 = r1.checkAuthorize(r2, r3)     // Catch:{ all -> 0x00c5 }
                    if (r1 == 0) goto L_0x00ac
                    cn.sharesdk.framework.g r1 = cn.sharesdk.framework.g.this     // Catch:{ all -> 0x00c5 }
                    int r2 = r3     // Catch:{ all -> 0x00c5 }
                    java.lang.Object r3 = r4     // Catch:{ all -> 0x00c5 }
                    r1.b((int) r2, (java.lang.Object) r3)     // Catch:{ all -> 0x00c5 }
                L_0x00ac:
                    cn.sharesdk.framework.utils.SSDKLog r1 = cn.sharesdk.framework.utils.SSDKLog.b()     // Catch:{ all -> 0x00c5 }
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c5 }
                    r2.<init>()     // Catch:{ all -> 0x00c5 }
                    java.lang.String r3 = "The user is using the non-privacy version newThreadJob 002 "
                    r2.append(r3)     // Catch:{ all -> 0x00c5 }
                    r2.append(r0)     // Catch:{ all -> 0x00c5 }
                    java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x00c5 }
                    r1.a((java.lang.String) r0)     // Catch:{ all -> 0x00c5 }
                    goto L_0x00e1
                L_0x00c5:
                    r0 = move-exception
                    cn.sharesdk.framework.utils.SSDKLog r1 = cn.sharesdk.framework.utils.SSDKLog.b()
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "new Thread(getThreadName(action)) "
                    r2.append(r3)
                    r2.append(r0)
                    java.lang.String r0 = r2.toString()
                    r2 = 0
                    java.lang.Object[] r2 = new java.lang.Object[r2]
                    r1.a(r0, r2)
                L_0x00e1:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.framework.g.AnonymousClass6.run():void");
            }
        }.start();
    }

    public void b(int i11, Object obj) {
        String str = null;
        if (i11 == 1) {
            e eVar = this.f13443c;
            if (eVar != null) {
                eVar.onComplete(this.f13441a, 1, (HashMap<String, Object>) null);
            }
        } else if (i11 != 2) {
            switch (i11) {
                case 6:
                    this.f13441a.follow((String) obj);
                    return;
                case 7:
                    Object[] objArr = (Object[]) obj;
                    this.f13441a.timeline(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), (String) objArr[2]);
                    return;
                case 8:
                    Platform platform = this.f13441a;
                    if (obj != null) {
                        str = (String) obj;
                    }
                    platform.userInfor(str);
                    return;
                case 9:
                    final Platform.ShareParams shareParams = (Platform.ShareParams) obj;
                    e eVar2 = this.f13443c;
                    if (eVar2 instanceof e) {
                        eVar2.a(this.f13441a, shareParams);
                    }
                    try {
                        if (shareParams.getLoopshareCustomParams().size() <= 0 || shareParams.getLoopshareCustomParams() == null) {
                            this.f13441a.doShare(shareParams);
                            return;
                        } else if (this.f13441a.getName().equals("QQ")) {
                            if (!TextUtils.isEmpty(shareParams.getTitleUrl())) {
                                ShareSDK.mobLinkGetMobID(shareParams.getLoopshareCustomParams(), new MoblinkActionListener() {
                                    public void onError(Throwable th2) {
                                        if (g.this.f13443c != null) {
                                            g.this.f13443c.onError(g.this.f13441a, 9, th2);
                                        }
                                    }

                                    public void onResult(Object obj) {
                                        if (!TextUtils.isEmpty(Uri.parse(shareParams.getTitleUrl()).getEncodedQuery())) {
                                            Platform.ShareParams shareParams = shareParams;
                                            shareParams.setTitleUrl(shareParams.getTitleUrl() + "&mobid=" + obj);
                                        } else {
                                            Platform.ShareParams shareParams2 = shareParams;
                                            shareParams2.setTitleUrl(shareParams.getTitleUrl() + "?mobid=" + obj);
                                        }
                                        new Thread() {
                                            public void run() {
                                                super.run();
                                                g.this.f13441a.doShare(shareParams);
                                            }
                                        }.start();
                                    }
                                });
                                return;
                            } else if (this.f13443c != null) {
                                this.f13443c.onError(this.f13441a, 9, new Throwable("TitleUrl cannot be empty if setLoopshareCustomParams is used in QQ"));
                                return;
                            } else {
                                return;
                            }
                        } else if (!TextUtils.isEmpty(shareParams.getUrl())) {
                            if (this.f13443c != null) {
                                ShareSDK.mobLinkGetMobID(shareParams.getLoopshareCustomParams(), new MoblinkActionListener() {
                                    public void onError(Throwable th2) {
                                        if (g.this.f13443c != null) {
                                            g.this.f13443c.onError(g.this.f13441a, 9, th2);
                                        }
                                    }

                                    public void onResult(Object obj) {
                                        if (!TextUtils.isEmpty(Uri.parse(shareParams.getUrl()).getEncodedQuery())) {
                                            Platform.ShareParams shareParams = shareParams;
                                            shareParams.setUrl(shareParams.getUrl() + "&mobid=" + obj);
                                        } else {
                                            Platform.ShareParams shareParams2 = shareParams;
                                            shareParams2.setUrl(shareParams.getUrl() + "?mobid=" + obj);
                                        }
                                        new Thread() {
                                            public void run() {
                                                super.run();
                                                g.this.f13441a.doShare(shareParams);
                                            }
                                        }.start();
                                    }
                                });
                                return;
                            }
                            return;
                        } else if (this.f13443c != null) {
                            this.f13443c.onError(this.f13441a, 9, new Throwable("SetUrl cannot be empty if setLoopshareCustomParams is used"));
                            return;
                        } else {
                            return;
                        }
                    } catch (Throwable th2) {
                        SSDKLog b11 = SSDKLog.b();
                        b11.a("PlatformImpl platform.doshare() " + th2, new Object[0]);
                        return;
                    }
                default:
                    Object[] objArr2 = (Object[]) obj;
                    this.f13441a.doCustomerProtocol(String.valueOf(objArr2[0]), String.valueOf(objArr2[1]), i11, (HashMap) objArr2[2], (HashMap) objArr2[3]);
                    return;
            }
        } else {
            Object[] objArr3 = (Object[]) obj;
            this.f13441a.getFriendList(((Integer) objArr3[0]).intValue(), ((Integer) objArr3[1]).intValue(), (String) objArr3[2]);
        }
    }

    public void a(String str) {
        try {
            this.f13444d = ResHelper.parseInt(String.valueOf(ShareSDK.getDevinfo(str, "Id")).trim());
        } catch (Throwable unused) {
            if (!(this.f13441a instanceof CustomPlatform)) {
                SSDKLog b11 = SSDKLog.b();
                b11.a(this.f13441a.getName() + " failed to parse Id, this will cause method getId() always returens 0", new Object[0]);
            }
        }
        try {
            this.f13445e = ResHelper.parseInt(String.valueOf(ShareSDK.getDevinfo(str, "SortId")).trim());
        } catch (Throwable unused2) {
            if (!(this.f13441a instanceof CustomPlatform)) {
                SSDKLog b12 = SSDKLog.b();
                b12.a(this.f13441a.getName() + " failed to parse SortId, this won't cause any problem, don't worry", new Object[0]);
            }
        }
        String devinfo = ShareSDK.getDevinfo(str, "Enable");
        if (devinfo == null) {
            this.f13448h = true;
            if (!(this.f13441a instanceof CustomPlatform)) {
                SSDKLog b13 = SSDKLog.b();
                b13.a(this.f13441a.getName() + " failed to parse Enable, this will cause platform always be enable", new Object[0]);
            }
        } else {
            this.f13448h = "true".equals(devinfo.trim());
        }
        this.f13441a.initDevInfo(str);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:7|8|(1:10)|11|12|17) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0021 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(cn.sharesdk.framework.Platform.ShareParams r4) {
        /*
            r3 = this;
            r0 = 9
            if (r4 != 0) goto L_0x0015
            cn.sharesdk.framework.e r4 = r3.f13443c     // Catch:{ all -> 0x0013 }
            if (r4 == 0) goto L_0x0012
            cn.sharesdk.framework.Platform r1 = r3.f13441a     // Catch:{ all -> 0x0013 }
            java.lang.NullPointerException r2 = new java.lang.NullPointerException     // Catch:{ all -> 0x0013 }
            r2.<init>()     // Catch:{ all -> 0x0013 }
            r4.onError(r1, r0, r2)     // Catch:{ all -> 0x0013 }
        L_0x0012:
            return
        L_0x0013:
            r4 = move-exception
            goto L_0x0025
        L_0x0015:
            boolean r1 = r4.getOpenCustomEven()     // Catch:{ all -> 0x0021 }
            if (r1 != 0) goto L_0x0021
            r1 = 3
            cn.sharesdk.framework.Platform r2 = r3.f13441a     // Catch:{ all -> 0x0021 }
            cn.sharesdk.framework.ShareSDK.logDemoEvent(r1, r2)     // Catch:{ all -> 0x0021 }
        L_0x0021:
            r3.c(r0, r4)     // Catch:{ all -> 0x0013 }
            goto L_0x002c
        L_0x0025:
            cn.sharesdk.framework.utils.SSDKLog r0 = cn.sharesdk.framework.utils.SSDKLog.b()
            r0.d(r4)
        L_0x002c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.framework.g.c(cn.sharesdk.framework.Platform$ShareParams):void");
    }

    public void c(String str) {
        c(8, str);
    }

    public int a() {
        return this.f13444d;
    }

    public void a(PlatformActionListener platformActionListener) {
        this.f13443c.a(platformActionListener);
    }

    public void a(boolean z11) {
        this.f13446f = z11;
    }

    private String a(int i11) {
        return "ShareSDK_" + this.f13441a.getName() + "_" + b(i11);
    }

    public String a(int i11, String str, String str2) {
        String a11 = ShareSDK.a(i11, str);
        if (!TextUtils.isEmpty(a11) && !OptionsBridge.NULL_VALUE.equals(a11)) {
            return a11;
        }
        Platform platform = this.f13441a;
        return platform.getDevinfo(platform.getName(), str2);
    }

    public void a(int i11, Object obj) {
        this.f13443c.a(this.f13441a, i11, obj);
    }

    /* access modifiers changed from: private */
    public void a(e eVar, int i11) {
        if (eVar != null) {
            eVar.onError(this.f13441a, i11, new ForbThrowable());
        }
    }

    public void a(final Platform.ShareParams shareParams) {
        if (shareParams == null) {
            e eVar = this.f13443c;
            if (eVar != null) {
                eVar.onError(this.f13441a, 9, new NullPointerException());
                return;
            }
            return;
        }
        new Thread(a(1)) {
            public void run() {
                try {
                    g.this.f13441a.subscribeAuth(shareParams);
                    SSDKLog.b().a(OnekeyShare.SHARESDK_TAG, "subscribeAuth start on PlatformImpl");
                } catch (Throwable th2) {
                    SSDKLog b11 = SSDKLog.b();
                    b11.a(OnekeyShare.SHARESDK_TAG, " subscribeAuth catch " + th2);
                }
            }
        }.start();
    }

    public void a(final String[] strArr) {
        try {
            if (!MobSDK.isGppVer() || e.a().i("no_use_gpp")) {
                b(strArr);
            } else if (!e.a().i("gpp_ver_sent")) {
                AgreementDialog agreementDialog = new AgreementDialog();
                agreementDialog.setShareParam(new AgreementDialog.OnDialogDismiss() {
                    public void consent() {
                        e.a().a(true);
                        g.this.b(strArr);
                    }

                    public void refuse() {
                        if (g.this.f13443c != null) {
                            g.this.f13443c.onError(g.this.f13441a, 21, (Throwable) null);
                        }
                    }
                });
                agreementDialog.show(MobSDK.getContext(), (Intent) null);
            } else {
                b(strArr);
            }
        } catch (Throwable th2) {
            SSDKLog.b().b(th2);
            b(strArr);
        }
    }

    /* access modifiers changed from: private */
    public void b(e eVar, int i11) {
        if (eVar != null) {
            eVar.onError(this.f13441a, i11, new Throwable("'appkey' is illegal"));
        }
    }

    /* access modifiers changed from: private */
    public void b(final String[] strArr) {
        new Thread(a(1)) {
            public void run() {
                try {
                    if (!MobSDK.isForb() && a.a()) {
                        int isAuth = MobSDK.isAuth();
                        if (isAuth == 1 || isAuth == 2) {
                            boolean unused = g.this.j();
                            SSDKLog.b().a("The user is using the privacy version without a popup authorize 001");
                        }
                    }
                } catch (Throwable th2) {
                    SSDKLog b11 = SSDKLog.b();
                    b11.a("authorize(final String[] permissions) " + th2, new Object[0]);
                }
            }
        }.start();
        new Thread() {
            /* JADX WARNING: Can't wrap try/catch for region: R(3:16|17|33) */
            /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
                cn.sharesdk.framework.ProvicyCanContinue.a().a(new cn.sharesdk.framework.g.AnonymousClass10.AnonymousClass1(r4));
             */
            /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
                return;
             */
            /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0055 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r4 = this;
                    boolean r0 = com.mob.MobSDK.isForb()     // Catch:{ all -> 0x0097 }
                    r1 = 1
                    if (r0 == 0) goto L_0x0012
                    cn.sharesdk.framework.g r0 = cn.sharesdk.framework.g.this     // Catch:{ all -> 0x0097 }
                    cn.sharesdk.framework.e r2 = r0.f13443c     // Catch:{ all -> 0x0097 }
                    r0.a((cn.sharesdk.framework.e) r2, (int) r1)     // Catch:{ all -> 0x0097 }
                    goto L_0x00b3
                L_0x0012:
                    int r0 = com.mob.MobSDK.isAuth()     // Catch:{ all -> 0x0055 }
                    if (r0 == r1) goto L_0x0039
                    r2 = 2
                    if (r0 == r2) goto L_0x0039
                    cn.sharesdk.framework.g r0 = cn.sharesdk.framework.g.this     // Catch:{ all -> 0x0055 }
                    cn.sharesdk.framework.e r0 = r0.f13443c     // Catch:{ all -> 0x0055 }
                    if (r0 == 0) goto L_0x00b3
                    cn.sharesdk.framework.g r0 = cn.sharesdk.framework.g.this     // Catch:{ all -> 0x0055 }
                    cn.sharesdk.framework.e r0 = r0.f13443c     // Catch:{ all -> 0x0055 }
                    cn.sharesdk.framework.g r2 = cn.sharesdk.framework.g.this     // Catch:{ all -> 0x0055 }
                    cn.sharesdk.framework.Platform r2 = r2.f13441a     // Catch:{ all -> 0x0055 }
                    com.mob.commons.dialog.PolicyThrowable r3 = new com.mob.commons.dialog.PolicyThrowable     // Catch:{ all -> 0x0055 }
                    r3.<init>()     // Catch:{ all -> 0x0055 }
                    r0.onError(r2, r1, r3)     // Catch:{ all -> 0x0055 }
                    goto L_0x00b3
                L_0x0039:
                    boolean r0 = cn.sharesdk.framework.a.a()     // Catch:{ all -> 0x0055 }
                    if (r0 != 0) goto L_0x0049
                    cn.sharesdk.framework.g r0 = cn.sharesdk.framework.g.this     // Catch:{ all -> 0x0055 }
                    cn.sharesdk.framework.e r2 = r0.f13443c     // Catch:{ all -> 0x0055 }
                    r0.b((cn.sharesdk.framework.e) r2, (int) r1)     // Catch:{ all -> 0x0055 }
                    goto L_0x00b3
                L_0x0049:
                    cn.sharesdk.framework.g r0 = cn.sharesdk.framework.g.this     // Catch:{ all -> 0x0055 }
                    cn.sharesdk.framework.Platform r0 = r0.f13441a     // Catch:{ all -> 0x0055 }
                    java.lang.String[] r2 = r3     // Catch:{ all -> 0x0055 }
                    r0.doAuthorize(r2)     // Catch:{ all -> 0x0055 }
                    goto L_0x00b3
                L_0x0055:
                    cn.sharesdk.framework.ProvicyCanContinue r0 = cn.sharesdk.framework.ProvicyCanContinue.a()     // Catch:{ all -> 0x0062 }
                    cn.sharesdk.framework.g$10$1 r2 = new cn.sharesdk.framework.g$10$1     // Catch:{ all -> 0x0062 }
                    r2.<init>()     // Catch:{ all -> 0x0062 }
                    r0.a(r2)     // Catch:{ all -> 0x0062 }
                    goto L_0x00b3
                L_0x0062:
                    r0 = move-exception
                    boolean r2 = cn.sharesdk.framework.a.a()     // Catch:{ all -> 0x0097 }
                    if (r2 != 0) goto L_0x0073
                    cn.sharesdk.framework.g r2 = cn.sharesdk.framework.g.this     // Catch:{ all -> 0x0097 }
                    cn.sharesdk.framework.e r3 = r2.f13443c     // Catch:{ all -> 0x0097 }
                    r2.b((cn.sharesdk.framework.e) r3, (int) r1)     // Catch:{ all -> 0x0097 }
                    goto L_0x007e
                L_0x0073:
                    cn.sharesdk.framework.g r1 = cn.sharesdk.framework.g.this     // Catch:{ all -> 0x0097 }
                    cn.sharesdk.framework.Platform r1 = r1.f13441a     // Catch:{ all -> 0x0097 }
                    java.lang.String[] r2 = r3     // Catch:{ all -> 0x0097 }
                    r1.doAuthorize(r2)     // Catch:{ all -> 0x0097 }
                L_0x007e:
                    cn.sharesdk.framework.utils.SSDKLog r1 = cn.sharesdk.framework.utils.SSDKLog.b()     // Catch:{ all -> 0x0097 }
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0097 }
                    r2.<init>()     // Catch:{ all -> 0x0097 }
                    java.lang.String r3 = "The user is using the non-privacy version authorize 002 "
                    r2.append(r3)     // Catch:{ all -> 0x0097 }
                    r2.append(r0)     // Catch:{ all -> 0x0097 }
                    java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0097 }
                    r1.a((java.lang.String) r0)     // Catch:{ all -> 0x0097 }
                    goto L_0x00b3
                L_0x0097:
                    r0 = move-exception
                    cn.sharesdk.framework.utils.SSDKLog r1 = cn.sharesdk.framework.utils.SSDKLog.b()
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "new Thread Platform.ACTION_AUTHORIZING "
                    r2.append(r3)
                    r2.append(r0)
                    java.lang.String r0 = r2.toString()
                    r2 = 0
                    java.lang.Object[] r2 = new java.lang.Object[r2]
                    r1.a(r0, r2)
                L_0x00b3:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.framework.g.AnonymousClass10.run():void");
            }
        }.start();
    }

    public void b(final Platform.ShareParams shareParams) {
        try {
            if (!MobSDK.isGppVer() || e.a().i("no_use_gpp")) {
                c(shareParams);
            } else if (!e.a().i("gpp_ver_sent")) {
                AgreementDialog agreementDialog = new AgreementDialog();
                agreementDialog.setShareParam(new AgreementDialog.OnDialogDismiss() {
                    public void consent() {
                        e.a().a(true);
                        g.this.c(shareParams);
                    }

                    public void refuse() {
                        if (g.this.f13443c != null) {
                            g.this.f13443c.onError(g.this.f13441a, 21, new Throwable("The user rejected the request to read the applist"));
                        }
                    }
                });
                agreementDialog.show(MobSDK.getContext(), (Intent) null);
            } else {
                c(shareParams);
            }
        } catch (Throwable unused) {
            c(shareParams);
        }
    }

    public void a(String str, int i11, int i12) {
        c(7, new Object[]{Integer.valueOf(i11), Integer.valueOf(i12), str});
    }

    public void a(int i11, int i12, String str) {
        c(2, new Object[]{Integer.valueOf(i11), Integer.valueOf(i12), str});
    }

    public void a(String str, String str2, short s11, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2) {
        c(s11 | 655360, new Object[]{str, str2, hashMap, hashMap2});
    }

    public void a(String str, boolean z11, ShareSDKCallback<String> shareSDKCallback) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.f13447g) {
            SSDKLog b11 = SSDKLog.b();
            b11.b("getShortLintk use time: " + (System.currentTimeMillis() - currentTimeMillis));
            if (shareSDKCallback != null) {
                shareSDKCallback.onCallback(str);
            }
        } else if (TextUtils.isEmpty(str)) {
            SSDKLog b12 = SSDKLog.b();
            b12.b("getShortLintk use time: " + (System.currentTimeMillis() - currentTimeMillis));
            if (shareSDKCallback != null) {
                shareSDKCallback.onCallback(str);
            }
        } else {
            ShareSDK.a(str, z11, this.f13441a.getPlatformId(), k(), shareSDKCallback);
            SSDKLog b13 = SSDKLog.b();
            b13.b("getShortLintk use time: " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public void b(String str) {
        c(6, str);
    }

    public String a(Bitmap bitmap) {
        return ShareSDK.a(bitmap);
    }

    public String a(String str, boolean z11, HashMap<String, String> hashMap) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.f13447g) {
            SSDKLog b11 = SSDKLog.b();
            b11.b("getShortLintk use time: " + (System.currentTimeMillis() - currentTimeMillis));
            return str;
        } else if (TextUtils.isEmpty(str)) {
            SSDKLog b12 = SSDKLog.b();
            b12.b("getShortLintk use time: " + (System.currentTimeMillis() - currentTimeMillis));
            return str;
        } else {
            String a11 = a.a().a(str, this.f13441a.getPlatformId(), z11, k(), hashMap);
            SSDKLog b13 = SSDKLog.b();
            b13.b("getShortLintk use time: " + (System.currentTimeMillis() - currentTimeMillis));
            return a11;
        }
    }
}
