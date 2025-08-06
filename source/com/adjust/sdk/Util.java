package com.adjust.sdk;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import com.adjust.sdk.scheduler.AsyncTaskExecutor;
import com.adjust.sdk.scheduler.SingleThreadFutureScheduler;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.iproov.sdk.bridge.OptionsBridge;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class Util {
    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'Z";
    public static final DecimalFormat SecondsDisplayFormat = newLocalDecimalFormat();
    public static final SimpleDateFormat dateFormatter = new SimpleDateFormat(DATE_FORMAT, Locale.US);
    private static final String fieldReadErrorMessage = "Unable to read '%s' field in migration device with message (%s)";
    private static volatile SingleThreadFutureScheduler playAdIdScheduler = null;

    public class a implements Callable<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f13945a;

        public a(Context context) {
            this.f13945a = context;
        }

        public final Object call() {
            try {
                return Reflection.getAdvertisingInfoObject(this.f13945a);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public class b implements Callable<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f13946a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Object f13947b;

        public b(Context context, Object obj) {
            this.f13946a = context;
            this.f13947b = obj;
        }

        public final Object call() {
            return Reflection.getPlayAdId(this.f13946a, this.f13947b);
        }
    }

    public class c implements Callable<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f13948a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Object f13949b;

        public c(Context context, Object obj) {
            this.f13948a = context;
            this.f13949b = obj;
        }

        public final Object call() {
            return Reflection.isPlayTrackingEnabled(this.f13948a, this.f13949b);
        }
    }

    public class d extends AsyncTaskExecutor<Context, String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OnGoogleAdIdReadListener f13950a;

        public d(OnGoogleAdIdReadListener onGoogleAdIdReadListener) {
            this.f13950a = onGoogleAdIdReadListener;
        }

        public final Object doInBackground(Object[] objArr) {
            ILogger logger = AdjustFactory.getLogger();
            String access$000 = Util.getGoogleAdId(((Context[]) objArr)[0]);
            logger.debug("GoogleAdId read " + access$000, new Object[0]);
            return access$000;
        }

        public final void onPostExecute(Object obj) {
            String str = (String) obj;
            OnGoogleAdIdReadListener onGoogleAdIdReadListener = this.f13950a;
            if (onGoogleAdIdReadListener != null) {
                onGoogleAdIdReadListener.onGoogleAdIdRead(str);
            }
        }
    }

    public static AdjustAttribution attributionFromJson(JSONObject jSONObject, String str) {
        String str2;
        if (jSONObject == null) {
            return null;
        }
        AdjustAttribution adjustAttribution = new AdjustAttribution();
        if ("unity".equals(str)) {
            adjustAttribution.trackerToken = jSONObject.optString("tracker_token", "");
            adjustAttribution.trackerName = jSONObject.optString("tracker_name", "");
            adjustAttribution.network = jSONObject.optString(OptionsBridge.NETWORK_KEY, "");
            adjustAttribution.campaign = jSONObject.optString("campaign", "");
            adjustAttribution.adgroup = jSONObject.optString("adgroup", "");
            adjustAttribution.creative = jSONObject.optString("creative", "");
            adjustAttribution.clickLabel = jSONObject.optString("click_label", "");
            adjustAttribution.costType = jSONObject.optString("cost_type", "");
            adjustAttribution.costAmount = Double.valueOf(jSONObject.optDouble("cost_amount", 0.0d));
            adjustAttribution.costCurrency = jSONObject.optString("cost_currency", "");
            str2 = jSONObject.optString("fb_install_referrer", "");
        } else {
            adjustAttribution.trackerToken = jSONObject.optString("tracker_token");
            adjustAttribution.trackerName = jSONObject.optString("tracker_name");
            adjustAttribution.network = jSONObject.optString(OptionsBridge.NETWORK_KEY);
            adjustAttribution.campaign = jSONObject.optString("campaign");
            adjustAttribution.adgroup = jSONObject.optString("adgroup");
            adjustAttribution.creative = jSONObject.optString("creative");
            adjustAttribution.clickLabel = jSONObject.optString("click_label");
            adjustAttribution.costType = jSONObject.optString("cost_type");
            adjustAttribution.costAmount = Double.valueOf(jSONObject.optDouble("cost_amount"));
            adjustAttribution.costCurrency = jSONObject.optString("cost_currency");
            str2 = jSONObject.optString("fb_install_referrer");
        }
        adjustAttribution.fbInstallReferrer = str2;
        return adjustAttribution;
    }

    public static boolean canReadNonPlayIds(AdjustConfig adjustConfig) {
        return !adjustConfig.coppaComplianceEnabled && !adjustConfig.playStoreKidsComplianceEnabled;
    }

    public static boolean canReadPlayIds(AdjustConfig adjustConfig) {
        return !adjustConfig.coppaComplianceEnabled && !adjustConfig.playStoreKidsComplianceEnabled;
    }

    public static boolean checkPermission(Context context, String str) {
        try {
            return context.checkCallingOrSelfPermission(str) == 0;
        } catch (Exception e11) {
            getLogger().debug("Unable to check permission '%s' with message (%s)", str, e11.getMessage());
            return false;
        }
    }

    public static String convertToHex(byte[] bArr) {
        BigInteger bigInteger = new BigInteger(1, bArr);
        return formatString("%0" + (bArr.length << 1) + "x", bigInteger);
    }

    public static String createUuid() {
        return UUID.randomUUID().toString();
    }

    public static boolean equalBoolean(Boolean bool, Boolean bool2) {
        return equalObject(bool, bool2);
    }

    public static boolean equalEnum(Enum enumR, Enum enumR2) {
        return equalObject(enumR, enumR2);
    }

    public static boolean equalInt(Integer num, Integer num2) {
        return equalObject(num, num2);
    }

    public static boolean equalLong(Long l11, Long l12) {
        return equalObject(l11, l12);
    }

    public static boolean equalObject(Object obj, Object obj2) {
        return (obj == null || obj2 == null) ? obj == null && obj2 == null : obj.equals(obj2);
    }

    public static boolean equalString(String str, String str2) {
        return equalObject(str, str2);
    }

    public static boolean equalsDouble(Double d11, Double d12) {
        return (d11 == null || d12 == null) ? d11 == null && d12 == null : Double.doubleToLongBits(d11.doubleValue()) == Double.doubleToLongBits(d12.doubleValue());
    }

    public static String formatString(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static Object getAdvertisingInfoObject(Context context, long j11) {
        return runSyncInPlayAdIdSchedulerWithTimeout(context, new a(context), j11);
    }

    public static String getAndroidId(Context context) {
        return AndroidIdUtil.getAndroidId(context);
    }

    public static String getCpuAbi() {
        if (Build.VERSION.SDK_INT < 21) {
            return Build.CPU_ABI;
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0010, code lost:
        r0 = getAdvertisingInfoObject(r3, 11000);
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0016  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getGoogleAdId(android.content.Context r3) {
        /*
            r0 = 11000(0x2af8, double:5.4347E-320)
            com.adjust.sdk.GooglePlayServicesClient$GooglePlayServicesInfo r2 = com.adjust.sdk.GooglePlayServicesClient.getGooglePlayServicesInfo(r3, r0)     // Catch:{ Exception -> 0x000d }
            if (r2 == 0) goto L_0x000d
            java.lang.String r2 = r2.getGpsAdid()     // Catch:{ Exception -> 0x000d }
            goto L_0x000e
        L_0x000d:
            r2 = 0
        L_0x000e:
            if (r2 != 0) goto L_0x001c
            java.lang.Object r0 = getAdvertisingInfoObject(r3, r0)
            if (r0 == 0) goto L_0x001c
            r1 = 1000(0x3e8, double:4.94E-321)
            java.lang.String r2 = getPlayAdId(r3, r0, r1)
        L_0x001c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adjust.sdk.Util.getGoogleAdId(android.content.Context):java.lang.String");
    }

    public static Locale getLocale(Configuration configuration) {
        LocaleList locales;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 24 && (locales = configuration.getLocales()) != null && !locales.isEmpty()) {
            return locales.get(0);
        }
        if (i11 < 24) {
            return configuration.locale;
        }
        return null;
    }

    private static ILogger getLogger() {
        return AdjustFactory.getLogger();
    }

    public static String getPlayAdId(Context context, Object obj, long j11) {
        return (String) runSyncInPlayAdIdSchedulerWithTimeout(context, new b(context, obj), j11);
    }

    public static String getReasonString(String str, Throwable th2) {
        if (th2 != null) {
            return formatString("%s: %s", str, th2);
        }
        return formatString("%s", str);
    }

    public static String getRootCause(Exception exc) {
        if (!hasRootCause(exc)) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        String stringWriter2 = stringWriter.toString();
        int indexOf = stringWriter2.indexOf("Caused by:");
        return stringWriter2.substring(indexOf, stringWriter2.indexOf("\n", indexOf));
    }

    private static String getSdkPrefix(String str) {
        String[] split;
        if (str != null && str.contains(TIMMentionEditText.TIM_MENTION_TAG) && (split = str.split(TIMMentionEditText.TIM_MENTION_TAG)) != null && split.length == 2) {
            return split[0];
        }
        return null;
    }

    public static String getSdkPrefixPlatform(String str) {
        String[] split;
        String sdkPrefix = getSdkPrefix(str);
        if (sdkPrefix == null || (split = sdkPrefix.split("\\d+", 2)) == null || split.length == 0) {
            return null;
        }
        return split[0];
    }

    public static String getSdkVersion() {
        return Constants.CLIENT_SDK;
    }

    public static String[] getSupportedAbis() {
        if (Build.VERSION.SDK_INT >= 21) {
            return Build.SUPPORTED_ABIS;
        }
        return null;
    }

    public static long getWaitingTime(int i11, BackoffStrategy backoffStrategy) {
        int i12 = backoffStrategy.minRetries;
        if (i11 < i12) {
            return 0;
        }
        return (long) (((double) Math.min(((long) Math.pow(2.0d, (double) (i11 - i12))) * backoffStrategy.milliSecondMultiplier, backoffStrategy.maxWait)) * randomInRange(backoffStrategy.minRange, backoffStrategy.maxRange));
    }

    public static boolean hasRootCause(Exception exc) {
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString().contains("Caused by:");
    }

    public static String hash(String str, String str2) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            MessageDigest instance = MessageDigest.getInstance(str2);
            instance.update(bytes, 0, bytes.length);
            return convertToHex(instance.digest());
        } catch (Exception unused) {
            return null;
        }
    }

    public static int hashBoolean(Boolean bool, int i11) {
        int i12 = i11 * 37;
        return bool == null ? i12 : bool.hashCode() + i12;
    }

    public static int hashDouble(Double d11, int i11) {
        int i12 = i11 * 37;
        return d11 == null ? i12 : d11.hashCode() + i12;
    }

    public static int hashEnum(Enum enumR, int i11) {
        int i12 = i11 * 37;
        return enumR == null ? i12 : enumR.hashCode() + i12;
    }

    public static int hashLong(Long l11, int i11) {
        int i12 = i11 * 37;
        return l11 == null ? i12 : l11.hashCode() + i12;
    }

    public static int hashObject(Object obj, int i11) {
        int i12 = i11 * 37;
        return obj == null ? i12 : obj.hashCode() + i12;
    }

    public static int hashString(String str, int i11) {
        int i12 = i11 * 37;
        return str == null ? i12 : str.hashCode() + i12;
    }

    public static boolean isAdjustUninstallDetectionPayload(Map<String, String> map) {
        return map != null && map.size() == 1 && Objects.equals(map.get(Constants.FCM_PAYLOAD_KEY), Constants.FCM_PAYLOAD_VALUE);
    }

    public static boolean isEnabledFromActivityStateFile(Context context) {
        ActivityState activityState = (ActivityState) readObject(context, Constants.ACTIVITY_STATE_FILENAME, "Activity state", ActivityState.class);
        if (activityState == null) {
            return true;
        }
        return activityState.enabled;
    }

    private static boolean isEqualGoogleReferrerDetails(ReferrerDetails referrerDetails, ActivityState activityState) {
        return referrerDetails.referrerClickTimestampSeconds == activityState.clickTime && referrerDetails.installBeginTimestampSeconds == activityState.installBegin && referrerDetails.referrerClickTimestampServerSeconds == activityState.clickTimeServer && referrerDetails.installBeginTimestampServerSeconds == activityState.installBeginServer && equalString(referrerDetails.installReferrer, activityState.installReferrer) && equalString(referrerDetails.installVersion, activityState.installVersion) && equalBoolean(referrerDetails.googlePlayInstant, activityState.googlePlayInstant);
    }

    private static boolean isEqualHuaweiReferrerAdsDetails(ReferrerDetails referrerDetails, ActivityState activityState) {
        return referrerDetails.referrerClickTimestampSeconds == activityState.clickTimeHuawei && referrerDetails.installBeginTimestampSeconds == activityState.installBeginHuawei && equalString(referrerDetails.installReferrer, activityState.installReferrerHuawei);
    }

    private static boolean isEqualHuaweiReferrerAppGalleryDetails(ReferrerDetails referrerDetails, ActivityState activityState) {
        return referrerDetails.referrerClickTimestampSeconds == activityState.clickTimeHuawei && referrerDetails.installBeginTimestampSeconds == activityState.installBeginHuawei && equalString(referrerDetails.installReferrer, activityState.installReferrerHuaweiAppGallery);
    }

    private static boolean isEqualMetaReferrerDetails(ReferrerDetails referrerDetails, ActivityState activityState) {
        return referrerDetails.referrerClickTimestampSeconds == activityState.clickTimeMeta && equalString(referrerDetails.installReferrer, activityState.installReferrerMeta) && equalBoolean(referrerDetails.isClick, activityState.isClickMeta);
    }

    public static boolean isEqualReferrerDetails(ReferrerDetails referrerDetails, String str, ActivityState activityState) {
        if (str.equals(Constants.REFERRER_API_GOOGLE)) {
            return isEqualGoogleReferrerDetails(referrerDetails, activityState);
        }
        if (str.equals(Constants.REFERRER_API_HUAWEI_ADS)) {
            return isEqualHuaweiReferrerAdsDetails(referrerDetails, activityState);
        }
        if (str.equals(Constants.REFERRER_API_HUAWEI_APP_GALLERY)) {
            return isEqualHuaweiReferrerAppGalleryDetails(referrerDetails, activityState);
        }
        if (str.equals(Constants.REFERRER_API_SAMSUNG)) {
            return isEqualSamsungReferrerDetails(referrerDetails, activityState);
        }
        if (str.equals("xiaomi")) {
            return isEqualXiaomiReferrerDetails(referrerDetails, activityState);
        }
        if (str.equals("vivo")) {
            return isEqualVivoReferrerDetails(referrerDetails, activityState);
        }
        if (str.equals(Constants.REFERRER_API_META)) {
            return isEqualMetaReferrerDetails(referrerDetails, activityState);
        }
        return false;
    }

    private static boolean isEqualSamsungReferrerDetails(ReferrerDetails referrerDetails, ActivityState activityState) {
        return referrerDetails.referrerClickTimestampSeconds == activityState.clickTimeSamsung && referrerDetails.installBeginTimestampSeconds == activityState.installBeginSamsung && equalString(referrerDetails.installReferrer, activityState.installReferrerSamsung);
    }

    private static boolean isEqualVivoReferrerDetails(ReferrerDetails referrerDetails, ActivityState activityState) {
        return referrerDetails.referrerClickTimestampSeconds == activityState.clickTimeVivo && referrerDetails.installBeginTimestampSeconds == activityState.installBeginVivo && equalString(referrerDetails.installReferrer, activityState.installReferrerVivo) && equalString(referrerDetails.installVersion, activityState.installVersionVivo);
    }

    private static boolean isEqualXiaomiReferrerDetails(ReferrerDetails referrerDetails, ActivityState activityState) {
        return referrerDetails.referrerClickTimestampSeconds == activityState.clickTimeXiaomi && referrerDetails.installBeginTimestampSeconds == activityState.installBeginXiaomi && referrerDetails.referrerClickTimestampServerSeconds == activityState.clickTimeServerXiaomi && referrerDetails.installBeginTimestampServerSeconds == activityState.installBeginServerXiaomi && equalString(referrerDetails.installReferrer, activityState.installReferrerXiaomi) && equalString(referrerDetails.installVersion, activityState.installVersionXiaomi);
    }

    public static boolean isGooglePlayGamesForPC(Context context) {
        return context.getPackageManager().hasSystemFeature("com.google.android.play.feature.HPE_EXPERIENCE");
    }

    public static Boolean isPlayTrackingEnabled(Context context, Object obj, long j11) {
        return (Boolean) runSyncInPlayAdIdSchedulerWithTimeout(context, new c(context, obj), j11);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0004, code lost:
        r2 = r2.toString();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isUrlFilteredOut(android.net.Uri r2) {
        /*
            r0 = 1
            if (r2 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r2 = r2.toString()
            if (r2 == 0) goto L_0x001c
            int r1 = r2.length()
            if (r1 != 0) goto L_0x0011
            goto L_0x001c
        L_0x0011:
            java.lang.String r1 = "^(fb|vk)[0-9]{5,}[^:]*://authorize.*access_token=.*"
            boolean r2 = r2.matches(r1)
            if (r2 == 0) goto L_0x001a
            return r0
        L_0x001a:
            r2 = 0
            return r2
        L_0x001c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adjust.sdk.Util.isUrlFilteredOut(android.net.Uri):boolean");
    }

    public static boolean isValidParameter(String str, String str2, String str3) {
        if (str == null) {
            getLogger().error("%s parameter %s is missing", str3, str2);
            return false;
        } else if (!str.equals("")) {
            return true;
        } else {
            getLogger().error("%s parameter %s is empty", str3, str2);
            return false;
        }
    }

    public static Map<String, String> mergeParameters(Map<String, String> map, Map<String, String> map2, String str) {
        if (map == null) {
            return map2;
        }
        if (map2 == null) {
            return map;
        }
        HashMap hashMap = new HashMap(map);
        ILogger logger = getLogger();
        for (Map.Entry next : map2.entrySet()) {
            String str2 = (String) hashMap.put((String) next.getKey(), (String) next.getValue());
            if (str2 != null) {
                logger.warn("Key %s with value %s from %s parameter was replaced by value %s", next.getKey(), str2, str, next.getValue());
            }
        }
        return hashMap;
    }

    private static DecimalFormat newLocalDecimalFormat() {
        return new DecimalFormat(IdManager.DEFAULT_VERSION_NAME, new DecimalFormatSymbols(Locale.US));
    }

    public static String quote(String str) {
        if (str == null) {
            return null;
        }
        if (!Pattern.compile("\\s").matcher(str).find()) {
            return str;
        }
        return formatString("'%s'", str);
    }

    private static double randomInRange(double d11, double d12) {
        return (new Random().nextDouble() * (d12 - d11)) + d11;
    }

    public static boolean readBooleanField(ObjectInputStream.GetField getField, String str, boolean z11) {
        try {
            return getField.get(str, z11);
        } catch (Exception e11) {
            getLogger().debug(fieldReadErrorMessage, str, e11.getMessage());
            return z11;
        }
    }

    public static double readDoubleField(ObjectInputStream.GetField getField, String str, double d11) {
        try {
            return getField.get(str, d11);
        } catch (Exception e11) {
            getLogger().debug(fieldReadErrorMessage, str, e11.getMessage());
            return d11;
        }
    }

    public static int readIntField(ObjectInputStream.GetField getField, String str, int i11) {
        try {
            return getField.get(str, i11);
        } catch (Exception e11) {
            getLogger().debug(fieldReadErrorMessage, str, e11.getMessage());
            return i11;
        }
    }

    public static long readLongField(ObjectInputStream.GetField getField, String str, long j11) {
        try {
            return getField.get(str, j11);
        } catch (Exception e11) {
            getLogger().debug(fieldReadErrorMessage, str, e11.getMessage());
            return j11;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x009f A[SYNTHETIC, Splitter:B:32:0x009f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T readObject(android.content.Context r7, java.lang.String r8, java.lang.String r9, java.lang.Class<T> r10) {
        /*
            r0 = 0
            r1 = 2
            r2 = 0
            r3 = 1
            java.io.FileInputStream r7 = r7.openFileInput(r8)     // Catch:{ FileNotFoundException -> 0x008c, Exception -> 0x0076 }
            java.io.BufferedInputStream r8 = new java.io.BufferedInputStream     // Catch:{ FileNotFoundException -> 0x0072, Exception -> 0x006d }
            r8.<init>(r7)     // Catch:{ FileNotFoundException -> 0x0072, Exception -> 0x006d }
            java.io.ObjectInputStream r7 = new java.io.ObjectInputStream     // Catch:{ FileNotFoundException -> 0x008f, Exception -> 0x006b }
            r7.<init>(r8)     // Catch:{ FileNotFoundException -> 0x008f, Exception -> 0x006b }
            java.lang.Object r8 = r7.readObject()     // Catch:{ ClassNotFoundException -> 0x0056, ClassCastException -> 0x0041, Exception -> 0x002b }
            java.lang.Object r0 = r10.cast(r8)     // Catch:{ ClassNotFoundException -> 0x0056, ClassCastException -> 0x0041, Exception -> 0x002b }
            com.adjust.sdk.ILogger r8 = getLogger()     // Catch:{ ClassNotFoundException -> 0x0056, ClassCastException -> 0x0041, Exception -> 0x002b }
            java.lang.String r10 = "Read %s: %s"
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ ClassNotFoundException -> 0x0056, ClassCastException -> 0x0041, Exception -> 0x002b }
            r4[r2] = r9     // Catch:{ ClassNotFoundException -> 0x0056, ClassCastException -> 0x0041, Exception -> 0x002b }
            r4[r3] = r0     // Catch:{ ClassNotFoundException -> 0x0056, ClassCastException -> 0x0041, Exception -> 0x002b }
            r8.debug(r10, r4)     // Catch:{ ClassNotFoundException -> 0x0056, ClassCastException -> 0x0041, Exception -> 0x002b }
            goto L_0x009d
        L_0x002b:
            r8 = move-exception
            com.adjust.sdk.ILogger r10 = getLogger()     // Catch:{ FileNotFoundException -> 0x0072, Exception -> 0x006d }
            java.lang.String r4 = "Failed to read %s object (%s)"
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ FileNotFoundException -> 0x0072, Exception -> 0x006d }
            r5[r2] = r9     // Catch:{ FileNotFoundException -> 0x0072, Exception -> 0x006d }
            java.lang.String r8 = r8.getMessage()     // Catch:{ FileNotFoundException -> 0x0072, Exception -> 0x006d }
            r5[r3] = r8     // Catch:{ FileNotFoundException -> 0x0072, Exception -> 0x006d }
            r10.error(r4, r5)     // Catch:{ FileNotFoundException -> 0x0072, Exception -> 0x006d }
            goto L_0x009d
        L_0x0041:
            r8 = move-exception
            com.adjust.sdk.ILogger r10 = getLogger()     // Catch:{ FileNotFoundException -> 0x0072, Exception -> 0x006d }
            java.lang.String r4 = "Failed to cast %s object (%s)"
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ FileNotFoundException -> 0x0072, Exception -> 0x006d }
            r5[r2] = r9     // Catch:{ FileNotFoundException -> 0x0072, Exception -> 0x006d }
            java.lang.String r8 = r8.getMessage()     // Catch:{ FileNotFoundException -> 0x0072, Exception -> 0x006d }
            r5[r3] = r8     // Catch:{ FileNotFoundException -> 0x0072, Exception -> 0x006d }
            r10.error(r4, r5)     // Catch:{ FileNotFoundException -> 0x0072, Exception -> 0x006d }
            goto L_0x009d
        L_0x0056:
            r8 = move-exception
            com.adjust.sdk.ILogger r10 = getLogger()     // Catch:{ FileNotFoundException -> 0x0072, Exception -> 0x006d }
            java.lang.String r4 = "Failed to find %s class (%s)"
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ FileNotFoundException -> 0x0072, Exception -> 0x006d }
            r5[r2] = r9     // Catch:{ FileNotFoundException -> 0x0072, Exception -> 0x006d }
            java.lang.String r8 = r8.getMessage()     // Catch:{ FileNotFoundException -> 0x0072, Exception -> 0x006d }
            r5[r3] = r8     // Catch:{ FileNotFoundException -> 0x0072, Exception -> 0x006d }
            r10.error(r4, r5)     // Catch:{ FileNotFoundException -> 0x0072, Exception -> 0x006d }
            goto L_0x009d
        L_0x006b:
            r7 = move-exception
            goto L_0x007c
        L_0x006d:
            r8 = move-exception
            r6 = r0
            r0 = r7
            r7 = r6
            goto L_0x0078
        L_0x0072:
            r6 = r0
            r0 = r7
            r7 = r6
            goto L_0x008d
        L_0x0076:
            r8 = move-exception
            r7 = r0
        L_0x0078:
            r6 = r0
            r0 = r7
            r7 = r8
            r8 = r6
        L_0x007c:
            com.adjust.sdk.ILogger r10 = getLogger()
            java.lang.Object[] r4 = new java.lang.Object[r1]
            r4[r2] = r9
            r4[r3] = r7
            java.lang.String r7 = "Failed to open %s file for reading (%s)"
            r10.error(r7, r4)
            goto L_0x009c
        L_0x008c:
            r7 = r0
        L_0x008d:
            r8 = r0
            r0 = r7
        L_0x008f:
            com.adjust.sdk.ILogger r7 = getLogger()
            java.lang.Object[] r10 = new java.lang.Object[r3]
            r10[r2] = r9
            java.lang.String r4 = "%s file not found"
            r7.debug(r4, r10)
        L_0x009c:
            r7 = r8
        L_0x009d:
            if (r7 == 0) goto L_0x00b3
            r7.close()     // Catch:{ Exception -> 0x00a3 }
            goto L_0x00b3
        L_0x00a3:
            r7 = move-exception
            com.adjust.sdk.ILogger r8 = getLogger()
            java.lang.Object[] r10 = new java.lang.Object[r1]
            r10[r2] = r9
            r10[r3] = r7
            java.lang.String r7 = "Failed to close %s file for reading (%s)"
            r8.error(r7, r10)
        L_0x00b3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adjust.sdk.Util.readObject(android.content.Context, java.lang.String, java.lang.String, java.lang.Class):java.lang.Object");
    }

    public static <T> T readObjectField(ObjectInputStream.GetField getField, String str, T t11) {
        try {
            return getField.get(str, t11);
        } catch (Exception e11) {
            getLogger().debug(fieldReadErrorMessage, str, e11.getMessage());
            return t11;
        }
    }

    public static String readStringField(ObjectInputStream.GetField getField, String str, String str2) {
        return (String) readObjectField(getField, str, str2);
    }

    public static boolean resolveContentProvider(Context context, String str) {
        try {
            return context.getPackageManager().resolveContentProvider(str, 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    private static <R> R runSyncInPlayAdIdSchedulerWithTimeout(Context context, Callable<R> callable, long j11) {
        if (playAdIdScheduler == null) {
            synchronized (Util.class) {
                if (playAdIdScheduler == null) {
                    playAdIdScheduler = new SingleThreadFutureScheduler("PlayAdIdLibrary", true);
                }
            }
        }
        try {
            return playAdIdScheduler.scheduleFutureWithReturn(callable, 0).get(j11, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException unused) {
            return null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:5|6|7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0024 */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004b A[SYNTHETIC, Splitter:B:18:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> void writeObject(T r5, android.content.Context r6, java.lang.String r7, java.lang.String r8) {
        /*
            r0 = 2
            r1 = 1
            r2 = 0
            java.io.FileOutputStream r6 = r6.openFileOutput(r7, r2)     // Catch:{ Exception -> 0x0036 }
            java.io.BufferedOutputStream r7 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x0034 }
            r7.<init>(r6)     // Catch:{ Exception -> 0x0034 }
            java.io.ObjectOutputStream r6 = new java.io.ObjectOutputStream     // Catch:{ Exception -> 0x0032 }
            r6.<init>(r7)     // Catch:{ Exception -> 0x0032 }
            r6.writeObject(r5)     // Catch:{ NotSerializableException -> 0x0024 }
            com.adjust.sdk.ILogger r7 = getLogger()     // Catch:{ NotSerializableException -> 0x0024 }
            java.lang.String r3 = "Wrote %s: %s"
            java.lang.Object[] r4 = new java.lang.Object[r0]     // Catch:{ NotSerializableException -> 0x0024 }
            r4[r2] = r8     // Catch:{ NotSerializableException -> 0x0024 }
            r4[r1] = r5     // Catch:{ NotSerializableException -> 0x0024 }
            r7.debug(r3, r4)     // Catch:{ NotSerializableException -> 0x0024 }
            goto L_0x0049
        L_0x0024:
            com.adjust.sdk.ILogger r5 = getLogger()     // Catch:{ Exception -> 0x0034 }
            java.lang.String r7 = "Failed to serialize %s"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0034 }
            r3[r2] = r8     // Catch:{ Exception -> 0x0034 }
            r5.error(r7, r3)     // Catch:{ Exception -> 0x0034 }
            goto L_0x0049
        L_0x0032:
            r5 = move-exception
            goto L_0x0039
        L_0x0034:
            r5 = move-exception
            goto L_0x0038
        L_0x0036:
            r5 = move-exception
            r6 = 0
        L_0x0038:
            r7 = r6
        L_0x0039:
            com.adjust.sdk.ILogger r6 = getLogger()
            java.lang.Object[] r3 = new java.lang.Object[r0]
            r3[r2] = r8
            r3[r1] = r5
            java.lang.String r5 = "Failed to open %s for writing (%s)"
            r6.error(r5, r3)
            r6 = r7
        L_0x0049:
            if (r6 == 0) goto L_0x005f
            r6.close()     // Catch:{ Exception -> 0x004f }
            goto L_0x005f
        L_0x004f:
            r5 = move-exception
            com.adjust.sdk.ILogger r6 = getLogger()
            java.lang.Object[] r7 = new java.lang.Object[r0]
            r7[r2] = r8
            r7[r1] = r5
            java.lang.String r5 = "Failed to close %s file for writing (%s)"
            r6.error(r5, r7)
        L_0x005f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adjust.sdk.Util.writeObject(java.lang.Object, android.content.Context, java.lang.String, java.lang.String):void");
    }

    public static void getGoogleAdId(Context context, OnGoogleAdIdReadListener onGoogleAdIdReadListener) {
        new d(onGoogleAdIdReadListener).execute(context);
    }
}
