package com.google.firebase.sessions.settings;

import d10.p;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.k;
import kotlinx.coroutines.h0;
import org.json.JSONObject;

@d(c = "com.google.firebase.sessions.settings.RemoteSettingsFetcher$doConfigFetch$2", f = "RemoteSettingsFetcher.kt", l = {68, 70, 73}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/h0;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
public final class RemoteSettingsFetcher$doConfigFetch$2 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public final /* synthetic */ Map<String, String> $headerOptions;
    public final /* synthetic */ p<String, c<? super Unit>, Object> $onFailure;
    public final /* synthetic */ p<JSONObject, c<? super Unit>, Object> $onSuccess;
    public int label;
    public final /* synthetic */ RemoteSettingsFetcher this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RemoteSettingsFetcher$doConfigFetch$2(RemoteSettingsFetcher remoteSettingsFetcher, Map<String, String> map, p<? super JSONObject, ? super c<? super Unit>, ? extends Object> pVar, p<? super String, ? super c<? super Unit>, ? extends Object> pVar2, c<? super RemoteSettingsFetcher$doConfigFetch$2> cVar) {
        super(2, cVar);
        this.this$0 = remoteSettingsFetcher;
        this.$headerOptions = map;
        this.$onSuccess = pVar;
        this.$onFailure = pVar2;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new RemoteSettingsFetcher$doConfigFetch$2(this.this$0, this.$headerOptions, this.$onSuccess, this.$onFailure, cVar);
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((RemoteSettingsFetcher$doConfigFetch$2) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) this.this$0.settingsUrl().openConnection();
            httpsURLConnection.setRequestMethod("GET");
            httpsURLConnection.setRequestProperty("Accept", "application/json");
            for (Map.Entry next : this.$headerOptions.entrySet()) {
                httpsURLConnection.setRequestProperty((String) next.getKey(), (String) next.getValue());
            }
            int responseCode = httpsURLConnection.getResponseCode();
            if (responseCode == 200) {
                InputStream inputStream = httpsURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder sb2 = new StringBuilder();
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                while (true) {
                    T readLine = bufferedReader.readLine();
                    ref$ObjectRef.element = readLine;
                    if (readLine == null) {
                        break;
                    }
                    sb2.append(readLine);
                }
                bufferedReader.close();
                inputStream.close();
                JSONObject jSONObject = new JSONObject(sb2.toString());
                p<JSONObject, c<? super Unit>, Object> pVar = this.$onSuccess;
                this.label = 1;
                if (pVar.invoke(jSONObject, this) == d11) {
                    return d11;
                }
            } else {
                p<String, c<? super Unit>, Object> pVar2 = this.$onFailure;
                String str = "Bad response code: " + responseCode;
                this.label = 2;
                if (pVar2.invoke(str, this) == d11) {
                    return d11;
                }
            }
        } else if (i11 == 1 || i11 == 2) {
            try {
                k.b(obj);
            } catch (Exception e11) {
                p<String, c<? super Unit>, Object> pVar3 = this.$onFailure;
                String message = e11.getMessage();
                if (message == null) {
                    message = e11.toString();
                }
                this.label = 3;
                if (pVar3.invoke(message, this) == d11) {
                    return d11;
                }
            }
        } else if (i11 == 3) {
            k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f56620a;
    }
}
