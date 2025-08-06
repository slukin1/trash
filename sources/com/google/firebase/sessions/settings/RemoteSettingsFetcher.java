package com.google.firebase.sessions.settings;

import android.net.Uri;
import com.adjust.sdk.Constants;
import com.google.firebase.sessions.ApplicationInfo;
import d10.p;
import java.net.URL;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.g;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB!\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002Jo\u0010\u000e\u001a\u00020\n2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\"\u0010\f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00072\"\u0010\r\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0007H@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lcom/google/firebase/sessions/settings/RemoteSettingsFetcher;", "Lcom/google/firebase/sessions/settings/CrashlyticsSettingsFetcher;", "Ljava/net/URL;", "settingsUrl", "", "", "headerOptions", "Lkotlin/Function2;", "Lorg/json/JSONObject;", "Lkotlin/coroutines/c;", "", "", "onSuccess", "onFailure", "doConfigFetch", "(Ljava/util/Map;Ld10/p;Ld10/p;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lcom/google/firebase/sessions/ApplicationInfo;", "appInfo", "Lcom/google/firebase/sessions/ApplicationInfo;", "Lkotlin/coroutines/CoroutineContext;", "blockingDispatcher", "Lkotlin/coroutines/CoroutineContext;", "baseUrl", "Ljava/lang/String;", "<init>", "(Lcom/google/firebase/sessions/ApplicationInfo;Lkotlin/coroutines/CoroutineContext;Ljava/lang/String;)V", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1})
public final class RemoteSettingsFetcher implements CrashlyticsSettingsFetcher {
    public static final Companion Companion = new Companion((r) null);
    private static final String FIREBASE_PLATFORM = "android";
    private static final String FIREBASE_SESSIONS_BASE_URL_STRING = "firebase-settings.crashlytics.com";
    private final ApplicationInfo appInfo;
    private final String baseUrl;
    private final CoroutineContext blockingDispatcher;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/google/firebase/sessions/settings/RemoteSettingsFetcher$Companion;", "", "()V", "FIREBASE_PLATFORM", "", "FIREBASE_SESSIONS_BASE_URL_STRING", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }
    }

    public RemoteSettingsFetcher(ApplicationInfo applicationInfo, CoroutineContext coroutineContext, String str) {
        this.appInfo = applicationInfo;
        this.blockingDispatcher = coroutineContext;
        this.baseUrl = str;
    }

    /* access modifiers changed from: private */
    public final URL settingsUrl() {
        return new URL(new Uri.Builder().scheme(Constants.SCHEME).authority(this.baseUrl).appendPath("spi").appendPath("v2").appendPath("platforms").appendPath("android").appendPath("gmp").appendPath(this.appInfo.getAppId()).appendPath("settings").appendQueryParameter(DefaultSettingsSpiCall.BUILD_VERSION_PARAM, this.appInfo.getAndroidAppInfo().getAppBuildVersion()).appendQueryParameter(DefaultSettingsSpiCall.DISPLAY_VERSION_PARAM, this.appInfo.getAndroidAppInfo().getVersionName()).build().toString());
    }

    public Object doConfigFetch(Map<String, String> map, p<? super JSONObject, ? super c<? super Unit>, ? extends Object> pVar, p<? super String, ? super c<? super Unit>, ? extends Object> pVar2, c<? super Unit> cVar) {
        Object g11 = g.g(this.blockingDispatcher, new RemoteSettingsFetcher$doConfigFetch$2(this, map, pVar, pVar2, (c<? super RemoteSettingsFetcher$doConfigFetch$2>) null), cVar);
        return g11 == IntrinsicsKt__IntrinsicsKt.d() ? g11 : Unit.f56620a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RemoteSettingsFetcher(ApplicationInfo applicationInfo, CoroutineContext coroutineContext, String str, int i11, r rVar) {
        this(applicationInfo, coroutineContext, (i11 & 4) != 0 ? FIREBASE_SESSIONS_BASE_URL_STRING : str);
    }
}
