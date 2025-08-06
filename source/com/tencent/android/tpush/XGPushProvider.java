package com.tencent.android.tpush;

import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.data.RegisterEntity;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.message.e;
import com.tencent.android.tpush.service.b;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.service.util.c;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.TTask;
import java.net.URISyntaxException;
import java.util.Arrays;

public class XGPushProvider extends ContentProvider {
    public static String AUTH_PRIX = ".XGVIP_PUSH_AUTH";
    public static final String TAG = "XGPushProvider";
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static Context f68052a;

    /* renamed from: c  reason: collision with root package name */
    private static UriMatcher f68053c = new UriMatcher(-1);

    /* renamed from: d  reason: collision with root package name */
    private static int f68054d;

    /* renamed from: b  reason: collision with root package name */
    private String f68055b = null;

    /* renamed from: com.tencent.android.tpush.XGPushProvider$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f68057a;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.tencent.android.tpush.TypeStr[] r0 = com.tencent.android.tpush.TypeStr.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f68057a = r0
                com.tencent.android.tpush.TypeStr r1 = com.tencent.android.tpush.TypeStr.config     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f68057a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tencent.android.tpush.TypeStr r1 = com.tencent.android.tpush.TypeStr.config_all     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f68057a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.tencent.android.tpush.TypeStr r1 = com.tencent.android.tpush.TypeStr.hearbeat_cyclecheck     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f68057a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.tencent.android.tpush.TypeStr r1 = com.tencent.android.tpush.TypeStr.hearbeat     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f68057a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.tencent.android.tpush.TypeStr r1 = com.tencent.android.tpush.TypeStr.pullupxg     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f68057a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.tencent.android.tpush.TypeStr r1 = com.tencent.android.tpush.TypeStr.hearbeat_all     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f68057a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.tencent.android.tpush.TypeStr r1 = com.tencent.android.tpush.TypeStr.token     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f68057a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.tencent.android.tpush.TypeStr r1 = com.tencent.android.tpush.TypeStr.register     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f68057a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.tencent.android.tpush.TypeStr r1 = com.tencent.android.tpush.TypeStr.msg     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f68057a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.tencent.android.tpush.TypeStr r1 = com.tencent.android.tpush.TypeStr.msg_all     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f68057a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.tencent.android.tpush.TypeStr r1 = com.tencent.android.tpush.TypeStr.feedback     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f68057a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.tencent.android.tpush.TypeStr r1 = com.tencent.android.tpush.TypeStr.feedback_all     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.XGPushProvider.AnonymousClass2.<clinit>():void");
        }
    }

    private void b() {
        if (XGPushManager.getContext() == null) {
            XGPushManager.setContext(f68052a);
        }
        if (b.e() == null) {
            b.b(f68052a);
        }
    }

    private void c() {
        f68052a = getContext().getApplicationContext();
        b();
        fetchProviderAuthorities(f68052a);
        this.f68055b = f68052a.getPackageName();
        String str = this.f68055b + AUTH_PRIX;
        TLogger.i(TAG, "init auth " + str);
        UriMatcher uriMatcher = f68053c;
        TypeStr typeStr = TypeStr.config;
        uriMatcher.addURI(str, typeStr.getStr(), typeStr.getType());
        UriMatcher uriMatcher2 = f68053c;
        TypeStr typeStr2 = TypeStr.config_all;
        uriMatcher2.addURI(str, typeStr2.getStr(), typeStr2.getType());
        UriMatcher uriMatcher3 = f68053c;
        TypeStr typeStr3 = TypeStr.msg;
        uriMatcher3.addURI(str, typeStr3.getStr(), typeStr3.getType());
        UriMatcher uriMatcher4 = f68053c;
        TypeStr typeStr4 = TypeStr.msg_all;
        uriMatcher4.addURI(str, typeStr4.getStr(), typeStr4.getType());
        UriMatcher uriMatcher5 = f68053c;
        TypeStr typeStr5 = TypeStr.hearbeat;
        uriMatcher5.addURI(str, typeStr5.getStr(), typeStr5.getType());
        UriMatcher uriMatcher6 = f68053c;
        TypeStr typeStr6 = TypeStr.hearbeat_all;
        uriMatcher6.addURI(str, typeStr6.getStr(), typeStr6.getType());
        UriMatcher uriMatcher7 = f68053c;
        TypeStr typeStr7 = TypeStr.feedback;
        uriMatcher7.addURI(str, typeStr7.getStr(), typeStr7.getType());
        UriMatcher uriMatcher8 = f68053c;
        TypeStr typeStr8 = TypeStr.feedback_all;
        uriMatcher8.addURI(str, typeStr8.getStr(), typeStr8.getType());
        UriMatcher uriMatcher9 = f68053c;
        TypeStr typeStr9 = TypeStr.token;
        uriMatcher9.addURI(str, typeStr9.getStr(), typeStr9.getType());
        UriMatcher uriMatcher10 = f68053c;
        TypeStr typeStr10 = TypeStr.register;
        uriMatcher10.addURI(str, typeStr10.getStr(), typeStr10.getType());
        UriMatcher uriMatcher11 = f68053c;
        TypeStr typeStr11 = TypeStr.insert_mid_new;
        uriMatcher11.addURI(str, typeStr11.getStr(), typeStr11.getType());
        UriMatcher uriMatcher12 = f68053c;
        TypeStr typeStr12 = TypeStr.insert_mid_old;
        uriMatcher12.addURI(str, typeStr12.getStr(), typeStr12.getType());
        UriMatcher uriMatcher13 = f68053c;
        TypeStr typeStr13 = TypeStr.pullupxg;
        uriMatcher13.addURI(str, typeStr13.getStr(), typeStr13.getType());
        UriMatcher uriMatcher14 = f68053c;
        TypeStr typeStr14 = TypeStr.hearbeat_cyclecheck;
        uriMatcher14.addURI(str, typeStr14.getStr(), typeStr14.getType());
        CommonWorkingThread.getInstance().execute(new TTask() {
            public void TRun() {
                boolean z11 = PushPreferences.getBoolean(XGPushProvider.f68052a, Constants.KEY_START_SERVICE_BY_USER, false);
                if (!XGPushConfig.autoInit || !z11) {
                    TLogger.ii(XGPushProvider.TAG, "initGlobal abolish");
                    return;
                }
                TLogger.i(XGPushProvider.TAG, "initGlobal");
                j.a(XGPushProvider.f68052a);
            }
        });
    }

    public static void fetchProviderAuthorities(Context context) {
        try {
            String packageName = context.getPackageName();
            ProviderInfo providerInfo = context.getPackageManager().getProviderInfo(new ComponentName(packageName, XGPushProvider.class.getName()), 0);
            AUTH_PRIX = providerInfo.authority.replace(packageName, "");
            TLogger.i(TAG, "name:" + providerInfo.name + ", authority:" + providerInfo.authority + ", AUTH_PRIX:" + AUTH_PRIX);
        } catch (Throwable th2) {
            TLogger.w(TAG, "unexpected for fetchProviderAuthorities", th2);
        }
    }

    public static String getProviderAuthority(Context context) {
        if (context == null) {
            return "";
        }
        String packageName = context.getPackageName();
        return packageName + AUTH_PRIX;
    }

    public static int getProviderPid() {
        return f68054d;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        TLogger.w(TAG, "delete uri:" + uri + ",selection:" + str + ",selectionArgs:" + Arrays.toString(strArr));
        return 0;
    }

    public String getType(Uri uri) {
        int match = f68053c.match(uri);
        TLogger.i(TAG, "getType uri:" + uri + ",match:" + match);
        TypeStr typeStr = TypeStr.getTypeStr(match);
        if (typeStr == null) {
            return null;
        }
        switch (AnonymousClass2.f68057a[typeStr.ordinal()]) {
            case 1:
                return "CONFIG";
            case 2:
                return "CONFIG_ALL";
            case 3:
                c.a(f68052a, true);
                break;
            case 4:
                break;
            case 5:
                TLogger.i(TAG, "Start XGService by provider");
                b.a(f68052a);
                return null;
            case 6:
                return "HEARTBEAT_ALL";
            case 7:
                return GuidInfoManager.getToken(f68052a);
            case 8:
                RegisterEntity currentAppRegisterEntity = CacheManager.getCurrentAppRegisterEntity(f68052a);
                TLogger.i(TAG, "get RegisterEntity:" + currentAppRegisterEntity);
                return Rijndael.encrypt(RegisterEntity.encode(currentAppRegisterEntity));
            default:
                return null;
        }
        e.a(f68052a).a(false);
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        int match = f68053c.match(uri);
        TypeStr typeStr = TypeStr.getTypeStr(match);
        if (typeStr == null) {
            return null;
        }
        TLogger.i(TAG, "insert uri:" + uri + ",match:" + match + ",values:" + contentValues);
        if (AnonymousClass2.f68057a[typeStr.ordinal()] != 9) {
            return null;
        }
        try {
            String asString = contentValues.getAsString("key");
            if (asString == null) {
                TLogger.e(TAG, "key is null");
                return null;
            }
            Intent parseUri = Intent.parseUri(asString, 0);
            parseUri.addCategory("android.intent.category.BROWSABLE");
            parseUri.setComponent((ComponentName) null);
            if (Build.VERSION.SDK_INT >= 15) {
                try {
                    parseUri.getClass().getMethod("setSelector", new Class[]{Intent.class}).invoke(parseUri, new Object[]{null});
                } catch (Throwable th2) {
                    TLogger.w(TAG, "invoke intent.setComponent error.", th2);
                }
            }
            e.a(f68052a).b(parseUri);
            return null;
        } catch (URISyntaxException e11) {
            e11.printStackTrace();
        }
    }

    public boolean onCreate() {
        TLogger.i(TAG, "XGPushProvider onCreate");
        f68054d = Process.myPid();
        c();
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        TLogger.i(TAG, "query uri:" + uri + ",projection:" + Arrays.toString(strArr) + ",selection:" + str + ",selectionArgs:" + Arrays.toString(strArr2) + ",sortOrder:" + str2);
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        int match = f68053c.match(uri);
        TypeStr typeStr = TypeStr.getTypeStr(match);
        if (typeStr == null) {
            return 0;
        }
        TLogger.i(TAG, "update uri:" + uri + ",values:" + contentValues + ",selection:" + str + ",selectionArgs:" + Arrays.toString(strArr) + ",match:" + match);
        if (AnonymousClass2.f68057a[typeStr.ordinal()] != 11) {
            return 0;
        }
        String decrypt = Rijndael.decrypt(contentValues.getAsString("feedback"));
        TLogger.i(TAG, "feeback: " + decrypt);
        return 0;
    }
}
