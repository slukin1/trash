package com.kakao.sdk.common.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import com.google.gson.JsonObject;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.common.util.b;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\u0006\u0010%\u001a\u00020\u0013\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010&\u001a\u00020\u0003\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0005R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0005R\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0017R\u0014\u0010\u001f\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0017R\u0014\u0010$\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006-"}, d2 = {"Lcom/kakao/sdk/common/model/ApplicationContextInfo;", "Lcom/kakao/sdk/common/model/ApplicationInfo;", "Lcom/kakao/sdk/common/model/ContextInfo;", "", "mClientId", "Ljava/lang/String;", "mCustomScheme", "mKaHeader", "mKeyHash", "Lcom/google/gson/JsonObject;", "mExtras", "Lcom/google/gson/JsonObject;", "Landroid/content/SharedPreferences;", "mSharedPreferences", "Landroid/content/SharedPreferences;", "mAppVer", "", "mSalt", "[B", "Landroid/content/Context;", "mApplicationContext", "Landroid/content/Context;", "d", "()Ljava/lang/String;", "appKey", "c", "kaHeader", "b", "signingKeyHash", "getExtras", "()Lcom/google/gson/JsonObject;", "extras", "a", "appVer", "getSalt", "()[B", "salt", "context", "customScheme", "Lcom/kakao/sdk/common/KakaoSdk$Type;", "sdkType", "Lcom/kakao/sdk/common/model/SdkIdentifier;", "sdkIdentifier", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/kakao/sdk/common/KakaoSdk$Type;Lcom/kakao/sdk/common/model/SdkIdentifier;)V", "common_release"}, k = 1, mv = {1, 6, 0})
public final class ApplicationContextInfo implements ApplicationInfo, ContextInfo {
    private final String mAppVer;
    private final Context mApplicationContext;
    private final String mClientId;
    private final String mCustomScheme;
    private final JsonObject mExtras;
    private final String mKaHeader;
    private final String mKeyHash;
    private final byte[] mSalt;
    private final SharedPreferences mSharedPreferences;

    public ApplicationContextInfo(Context context, String str, String str2, KakaoSdk.Type type, SdkIdentifier sdkIdentifier) {
        String str3;
        this.mClientId = str;
        this.mCustomScheme = str2;
        b bVar = b.f25110a;
        this.mKaHeader = bVar.d(context, type, sdkIdentifier);
        this.mKeyHash = bVar.f(context);
        this.mExtras = bVar.c(context, type);
        this.mSharedPreferences = context.getSharedPreferences(str, 0);
        if (Build.VERSION.SDK_INT >= 33) {
            str3 = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0)).versionName;
        } else {
            str3 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        }
        this.mAppVer = str3;
        this.mSalt = bVar.a(context);
        this.mApplicationContext = context.getApplicationContext();
    }

    public String a() {
        return this.mAppVer;
    }

    public String b() {
        return this.mKeyHash;
    }

    public String c() {
        return this.mKaHeader;
    }

    public String d() {
        return this.mClientId;
    }

    public JsonObject getExtras() {
        return this.mExtras;
    }

    public byte[] getSalt() {
        return this.mSalt;
    }
}
