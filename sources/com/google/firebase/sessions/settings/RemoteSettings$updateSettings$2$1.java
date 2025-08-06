package com.google.firebase.sessions.settings;

import d10.p;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import org.json.JSONObject;

@d(c = "com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$1", f = "RemoteSettings.kt", l = {122, 125, 128, 130, 131, 133}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"Lorg/json/JSONObject;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
public final class RemoteSettings$updateSettings$2$1 extends SuspendLambda implements p<JSONObject, c<? super Unit>, Object> {
    public /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    public final /* synthetic */ RemoteSettings this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RemoteSettings$updateSettings$2$1(RemoteSettings remoteSettings, c<? super RemoteSettings$updateSettings$2$1> cVar) {
        super(2, cVar);
        this.this$0 = remoteSettings;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        RemoteSettings$updateSettings$2$1 remoteSettings$updateSettings$2$1 = new RemoteSettings$updateSettings$2$1(this.this$0, cVar);
        remoteSettings$updateSettings$2$1.L$0 = obj;
        return remoteSettings$updateSettings$2$1;
    }

    public final Object invoke(JSONObject jSONObject, c<? super Unit> cVar) {
        return ((RemoteSettings$updateSettings$2$1) create(jSONObject, cVar)).invokeSuspend(Unit.f56620a);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00dd, code lost:
        r12 = (java.lang.Integer) r7.element;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e1, code lost:
        if (r12 == null) goto L_0x0100;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00e3, code lost:
        r2 = r11.this$0;
        r12.intValue();
        r11.L$0 = r1;
        r11.L$1 = r0;
        r11.L$2 = null;
        r11.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00fd, code lost:
        if (r2.settingsCache.updateSessionRestartTimeout((java.lang.Integer) r7.element, r11) != r4) goto L_0x0100;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ff, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0100, code lost:
        r12 = (java.lang.Double) r1.element;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0104, code lost:
        if (r12 == null) goto L_0x0123;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0106, code lost:
        r2 = r11.this$0;
        r12.doubleValue();
        r11.L$0 = r0;
        r11.L$1 = null;
        r11.L$2 = null;
        r11.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0120, code lost:
        if (r2.settingsCache.updateSamplingRate((java.lang.Double) r1.element, r11) != r4) goto L_0x0123;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0122, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0123, code lost:
        r12 = (java.lang.Integer) r0.element;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0127, code lost:
        if (r12 == null) goto L_0x0149;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0129, code lost:
        r1 = r11.this$0;
        r12.intValue();
        r11.L$0 = null;
        r11.L$1 = null;
        r11.L$2 = null;
        r11.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0143, code lost:
        if (r1.settingsCache.updateSessionCacheDuration((java.lang.Integer) r0.element, r11) != r4) goto L_0x0146;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0145, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0146, code lost:
        r12 = kotlin.Unit.f56620a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0149, code lost:
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x014a, code lost:
        if (r12 != null) goto L_0x0169;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x014c, code lost:
        r12 = r11.this$0.settingsCache;
        r0 = kotlin.coroutines.jvm.internal.a.c(86400);
        r11.L$0 = null;
        r11.L$1 = null;
        r11.L$2 = null;
        r11.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0166, code lost:
        if (r12.updateSessionCacheDuration(r0, r11) != r4) goto L_0x0169;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0168, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0169, code lost:
        r12 = r11.this$0.settingsCache;
        r0 = kotlin.coroutines.jvm.internal.a.d(java.lang.System.currentTimeMillis());
        r11.L$0 = null;
        r11.L$1 = null;
        r11.L$2 = null;
        r11.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0184, code lost:
        if (r12.updateSessionCacheUpdatedTime(r0, r11) != r4) goto L_0x0187;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0186, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0189, code lost:
        return kotlin.Unit.f56620a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00db  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.String r0 = "cache_duration"
            java.lang.String r1 = "session_timeout_seconds"
            java.lang.String r2 = "sampling_rate"
            java.lang.String r3 = "sessions_enabled"
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r5 = r11.label
            r6 = 0
            switch(r5) {
                case 0: goto L_0x0050;
                case 1: goto L_0x003f;
                case 2: goto L_0x0032;
                case 3: goto L_0x0029;
                case 4: goto L_0x0024;
                case 5: goto L_0x001f;
                case 6: goto L_0x001a;
                default: goto L_0x0012;
            }
        L_0x0012:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x001a:
            kotlin.k.b(r12)
            goto L_0x0187
        L_0x001f:
            kotlin.k.b(r12)
            goto L_0x0169
        L_0x0024:
            kotlin.k.b(r12)
            goto L_0x0146
        L_0x0029:
            java.lang.Object r0 = r11.L$0
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref$ObjectRef) r0
            kotlin.k.b(r12)
            goto L_0x0123
        L_0x0032:
            java.lang.Object r0 = r11.L$1
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref$ObjectRef) r0
            java.lang.Object r1 = r11.L$0
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref$ObjectRef) r1
            kotlin.k.b(r12)
            goto L_0x0100
        L_0x003f:
            java.lang.Object r0 = r11.L$2
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref$ObjectRef) r0
            java.lang.Object r1 = r11.L$1
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref$ObjectRef) r1
            java.lang.Object r2 = r11.L$0
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref$ObjectRef) r2
            kotlin.k.b(r12)
            goto L_0x00d8
        L_0x0050:
            kotlin.k.b(r12)
            java.lang.Object r12 = r11.L$0
            org.json.JSONObject r12 = (org.json.JSONObject) r12
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
            r7.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r8 = new kotlin.jvm.internal.Ref$ObjectRef
            r8.<init>()
            java.lang.String r9 = "app_quality"
            boolean r10 = r12.has(r9)
            if (r10 == 0) goto L_0x00b9
            java.lang.Object r12 = r12.get(r9)
            org.json.JSONObject r12 = (org.json.JSONObject) r12
            boolean r9 = r12.has(r3)     // Catch:{ JSONException -> 0x00af }
            if (r9 == 0) goto L_0x0081
            java.lang.Object r3 = r12.get(r3)     // Catch:{ JSONException -> 0x00af }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ JSONException -> 0x00af }
            goto L_0x0082
        L_0x0081:
            r3 = r6
        L_0x0082:
            boolean r9 = r12.has(r2)     // Catch:{ JSONException -> 0x00ad }
            if (r9 == 0) goto L_0x0090
            java.lang.Object r2 = r12.get(r2)     // Catch:{ JSONException -> 0x00ad }
            java.lang.Double r2 = (java.lang.Double) r2     // Catch:{ JSONException -> 0x00ad }
            r5.element = r2     // Catch:{ JSONException -> 0x00ad }
        L_0x0090:
            boolean r2 = r12.has(r1)     // Catch:{ JSONException -> 0x00ad }
            if (r2 == 0) goto L_0x009e
            java.lang.Object r1 = r12.get(r1)     // Catch:{ JSONException -> 0x00ad }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ JSONException -> 0x00ad }
            r7.element = r1     // Catch:{ JSONException -> 0x00ad }
        L_0x009e:
            boolean r1 = r12.has(r0)     // Catch:{ JSONException -> 0x00ad }
            if (r1 == 0) goto L_0x00ba
            java.lang.Object r12 = r12.get(r0)     // Catch:{ JSONException -> 0x00ad }
            java.lang.Integer r12 = (java.lang.Integer) r12     // Catch:{ JSONException -> 0x00ad }
            r8.element = r12     // Catch:{ JSONException -> 0x00ad }
            goto L_0x00ba
        L_0x00ad:
            r12 = move-exception
            goto L_0x00b1
        L_0x00af:
            r12 = move-exception
            r3 = r6
        L_0x00b1:
            java.lang.String r0 = "SessionConfigFetcher"
            java.lang.String r1 = "Error parsing the configs remotely fetched: "
            android.util.Log.e(r0, r1, r12)
            goto L_0x00ba
        L_0x00b9:
            r3 = r6
        L_0x00ba:
            if (r3 == 0) goto L_0x00db
            com.google.firebase.sessions.settings.RemoteSettings r12 = r11.this$0
            r3.booleanValue()
            com.google.firebase.sessions.settings.SettingsCache r12 = r12.settingsCache
            r11.L$0 = r5
            r11.L$1 = r7
            r11.L$2 = r8
            r0 = 1
            r11.label = r0
            java.lang.Object r12 = r12.updateSettingsEnabled(r3, r11)
            if (r12 != r4) goto L_0x00d5
            return r4
        L_0x00d5:
            r2 = r5
            r1 = r7
            r0 = r8
        L_0x00d8:
            r7 = r1
            r1 = r2
            goto L_0x00dd
        L_0x00db:
            r1 = r5
            r0 = r8
        L_0x00dd:
            T r12 = r7.element
            java.lang.Integer r12 = (java.lang.Integer) r12
            if (r12 == 0) goto L_0x0100
            com.google.firebase.sessions.settings.RemoteSettings r2 = r11.this$0
            r12.intValue()
            com.google.firebase.sessions.settings.SettingsCache r12 = r2.settingsCache
            T r2 = r7.element
            java.lang.Integer r2 = (java.lang.Integer) r2
            r11.L$0 = r1
            r11.L$1 = r0
            r11.L$2 = r6
            r3 = 2
            r11.label = r3
            java.lang.Object r12 = r12.updateSessionRestartTimeout(r2, r11)
            if (r12 != r4) goto L_0x0100
            return r4
        L_0x0100:
            T r12 = r1.element
            java.lang.Double r12 = (java.lang.Double) r12
            if (r12 == 0) goto L_0x0123
            com.google.firebase.sessions.settings.RemoteSettings r2 = r11.this$0
            r12.doubleValue()
            com.google.firebase.sessions.settings.SettingsCache r12 = r2.settingsCache
            T r1 = r1.element
            java.lang.Double r1 = (java.lang.Double) r1
            r11.L$0 = r0
            r11.L$1 = r6
            r11.L$2 = r6
            r2 = 3
            r11.label = r2
            java.lang.Object r12 = r12.updateSamplingRate(r1, r11)
            if (r12 != r4) goto L_0x0123
            return r4
        L_0x0123:
            T r12 = r0.element
            java.lang.Integer r12 = (java.lang.Integer) r12
            if (r12 == 0) goto L_0x0149
            com.google.firebase.sessions.settings.RemoteSettings r1 = r11.this$0
            r12.intValue()
            com.google.firebase.sessions.settings.SettingsCache r12 = r1.settingsCache
            T r0 = r0.element
            java.lang.Integer r0 = (java.lang.Integer) r0
            r11.L$0 = r6
            r11.L$1 = r6
            r11.L$2 = r6
            r1 = 4
            r11.label = r1
            java.lang.Object r12 = r12.updateSessionCacheDuration(r0, r11)
            if (r12 != r4) goto L_0x0146
            return r4
        L_0x0146:
            kotlin.Unit r12 = kotlin.Unit.f56620a
            goto L_0x014a
        L_0x0149:
            r12 = r6
        L_0x014a:
            if (r12 != 0) goto L_0x0169
            com.google.firebase.sessions.settings.RemoteSettings r12 = r11.this$0
            com.google.firebase.sessions.settings.SettingsCache r12 = r12.settingsCache
            r0 = 86400(0x15180, float:1.21072E-40)
            java.lang.Integer r0 = kotlin.coroutines.jvm.internal.a.c(r0)
            r11.L$0 = r6
            r11.L$1 = r6
            r11.L$2 = r6
            r1 = 5
            r11.label = r1
            java.lang.Object r12 = r12.updateSessionCacheDuration(r0, r11)
            if (r12 != r4) goto L_0x0169
            return r4
        L_0x0169:
            com.google.firebase.sessions.settings.RemoteSettings r12 = r11.this$0
            com.google.firebase.sessions.settings.SettingsCache r12 = r12.settingsCache
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.Long r0 = kotlin.coroutines.jvm.internal.a.d(r0)
            r11.L$0 = r6
            r11.L$1 = r6
            r11.L$2 = r6
            r1 = 6
            r11.label = r1
            java.lang.Object r12 = r12.updateSessionCacheUpdatedTime(r0, r11)
            if (r12 != r4) goto L_0x0187
            return r4
        L_0x0187:
            kotlin.Unit r12 = kotlin.Unit.f56620a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
