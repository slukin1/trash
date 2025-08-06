package com.kakao.sdk.common.util;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.provider.Settings;
import android.util.Base64;
import com.facebook.internal.ServerProtocol;
import com.google.gson.JsonObject;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.common.model.SdkIdentifier;
import com.sumsub.sentry.q;
import com.xiaomi.mipush.sdk.Constants;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.x;
import kotlin.text.Regex;

@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\"\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tJ\u0016\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u001c\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004J\u001c\u0010\u0014\u001a\u00020\u00042\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0011¨\u0006\u0017"}, d2 = {"Lcom/kakao/sdk/common/util/b;", "", "Landroid/content/Context;", "context", "", "f", "g", "Lcom/kakao/sdk/common/KakaoSdk$Type;", "sdkType", "Lcom/kakao/sdk/common/model/SdkIdentifier;", "sdkIdentifier", "d", "Lcom/google/gson/JsonObject;", "c", "", "a", "queries", "", "h", "params", "b", "<init>", "()V", "common_release"}, k = 1, mv = {1, 6, 0})
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f25110a = new b();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f25111a;

        static {
            int[] iArr = new int[KakaoSdk.Type.values().length];
            iArr[KakaoSdk.Type.RX_KOTLIN.ordinal()] = 1;
            f25111a = iArr;
        }
    }

    public static /* synthetic */ String e(b bVar, Context context, KakaoSdk.Type type, SdkIdentifier sdkIdentifier, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            sdkIdentifier = null;
        }
        return bVar.d(context, type, sdkIdentifier);
    }

    @SuppressLint({"HardwareIds"})
    public final byte[] a(Context context) throws NoSuchAlgorithmException {
        try {
            String replace = new Regex("[0\\s]").replace((CharSequence) Settings.Secure.getString(context.getContentResolver(), "android_id"), "");
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.reset();
            instance.update(x.i("SDK-", replace).getBytes(kotlin.text.b.f56908b));
            return instance.digest();
        } catch (Exception unused) {
            return ("xxxx" + Build.PRODUCT + "a23456789012345bcdefg").getBytes(kotlin.text.b.f56908b);
        }
    }

    public final String b(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry next : map.entrySet()) {
            arrayList.add(((String) next.getKey()) + '=' + ((String) next.getValue()));
        }
        Iterator it2 = arrayList.iterator();
        if (it2.hasNext()) {
            Object next2 = it2.next();
            while (it2.hasNext()) {
                next2 = ((String) next2) + '&' + ((String) it2.next());
            }
            return (String) next2;
        }
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    }

    public final JsonObject c(Context context, KakaoSdk.Type type) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("appPkg", context.getPackageName());
        jsonObject.addProperty("keyHash", f(context));
        jsonObject.addProperty("KA", e(this, context, type, (SdkIdentifier) null, 4, (Object) null));
        return jsonObject;
    }

    public final String d(Context context, KakaoSdk.Type type, SdkIdentifier sdkIdentifier) {
        String str;
        String a11;
        String i11;
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 33) {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0)).versionName;
        } else {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        }
        d0 d0Var = d0.f56774a;
        Object[] objArr = new Object[17];
        objArr[0] = ServerProtocol.DIALOG_PARAM_SDK_VERSION;
        objArr[1] = "2.20.4";
        objArr[2] = HianalyticsBaseData.SDK_TYPE;
        objArr[3] = a.f25111a[type.ordinal()] == 1 ? "rx-kotlin" : "kotlin";
        objArr[4] = q.f30469g;
        objArr[5] = Integer.valueOf(i12);
        objArr[6] = "lang";
        String language = Locale.getDefault().getLanguage();
        Locale locale = Locale.ROOT;
        objArr[7] = language.toLowerCase(locale);
        objArr[8] = Locale.getDefault().getCountry().toUpperCase(locale);
        objArr[9] = "origin";
        objArr[10] = f(context);
        objArr[11] = "device";
        objArr[12] = new Regex("\\s").replace((CharSequence) new Regex("[^\\p{ASCII}]").replace((CharSequence) Build.MODEL.toUpperCase(Locale.US), "*"), Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        objArr[13] = "android_pkg";
        objArr[14] = context.getPackageName();
        objArr[15] = "app_ver";
        objArr[16] = str;
        String format = String.format("%s/%s %s/%s %s/android-%s %s/%s-%s %s/%s %s/%s %s/%s %s/%s", Arrays.copyOf(objArr, 17));
        return (sdkIdentifier == null || (a11 = sdkIdentifier.a()) == null || (i11 = x.i(format, a11)) == null) ? format : i11;
    }

    @TargetApi(28)
    public final String f(Context context) {
        return g(context);
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    public final String g(Context context) {
        Signature[] signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
        if (signatureArr.length > 0) {
            Signature signature = signatureArr[0];
            MessageDigest instance = MessageDigest.getInstance(hg.a.f40503a);
            instance.update(signature.toByteArray());
            return Base64.encodeToString(instance.digest(), 2);
        }
        throw new IllegalStateException();
    }

    public final Map<String, String> h(String str) {
        if (str == null) {
            return MapsKt__MapsKt.h();
        }
        List<String> L0 = StringsKt__StringsKt.L0(str, new String[]{ContainerUtils.FIELD_DELIMITER}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(L0, 10));
        for (String L02 : L0) {
            arrayList.add(StringsKt__StringsKt.L0(L02, new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, (Object) null));
        }
        ArrayList<List> arrayList2 = new ArrayList<>();
        Iterator it2 = arrayList.iterator();
        while (true) {
            boolean z11 = false;
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (((List) next).size() > 1) {
                z11 = true;
            }
            if (z11) {
                arrayList2.add(next);
            }
        }
        ArrayList<Pair> arrayList3 = new ArrayList<>(CollectionsKt__IterablesKt.u(arrayList2, 10));
        for (List list : arrayList2) {
            arrayList3.add(new Pair(list.get(0), list.get(1)));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Pair pair : arrayList3) {
            linkedHashMap.put(pair.getFirst(), URLDecoder.decode((String) pair.getSecond(), "UTF-8"));
        }
        return linkedHashMap;
    }
}
