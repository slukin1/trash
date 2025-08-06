package com.iproov.sdk;

import android.content.Context;
import androidx.annotation.Keep;
import com.iproov.sdk.CommonApi;
import com.iproov.sdk.IProov;
import com.iproov.sdk.core.Cfor;
import com.iproov.sdk.core.exception.IProovException;
import com.iproov.sdk.core.exception.UnexpectedErrorException;
import com.iproov.sdk.p026return.Cextends;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.g;
import kotlinx.coroutines.h;
import kotlinx.coroutines.i;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v0;

@Metadata(bv = {}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b*\u0010+B\u0011\b\u0010\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b*\u0010,J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001b\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ(\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u0013J(\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0016H\u0001R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR \u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001d0\u001c8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R$\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)\u0002\u0004\n\u0002\b\u0019¨\u0006."}, d2 = {"Lcom/iproov/sdk/IProovCallbackLauncher;", "Lcom/iproov/sdk/CommonApi;", "Ljava/util/UUID;", "uuid", "", "createListenerJob", "Lcom/iproov/sdk/IProov$IProovState;", "state", "dispatchToListener", "(Lcom/iproov/sdk/IProov$IProovState;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Landroid/content/Context;", "context", "Lcom/iproov/sdk/CommonApi$KeyPair;", "getKeyPair", "Lcom/iproov/sdk/IProov$Session;", "currentSession", "", "streamingUrl", "token", "Lcom/iproov/sdk/IProov$Options;", "options", "launch", "Lcom/iproov/sdk/return/extends;", "sessionOptions", "launchSession", "Lcom/iproov/sdk/core/for;", "internalOptions", "Lcom/iproov/sdk/core/for;", "", "Lkotlinx/coroutines/n1;", "jobs", "Ljava/util/Map;", "Lcom/iproov/sdk/IProovFlowLauncher;", "iProovFlowLauncher", "Lcom/iproov/sdk/IProovFlowLauncher;", "Lcom/iproov/sdk/IProovCallbackLauncher$Listener;", "listener", "Lcom/iproov/sdk/IProovCallbackLauncher$Listener;", "getListener", "()Lcom/iproov/sdk/IProovCallbackLauncher$Listener;", "setListener", "(Lcom/iproov/sdk/IProovCallbackLauncher$Listener;)V", "<init>", "()V", "(Lcom/iproov/sdk/core/for;)V", "Listener", "iproov_release"}, k = 1, mv = {1, 5, 1})
@Keep
public final class IProovCallbackLauncher implements CommonApi {
    /* access modifiers changed from: private */
    public final IProovFlowLauncher iProovFlowLauncher;
    private Cfor internalOptions;
    /* access modifiers changed from: private */
    public final Map<UUID, n1> jobs;
    private Listener listener;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\u001a\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\rH&J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH&J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H&¨\u0006\u0015"}, d2 = {"Lcom/iproov/sdk/IProovCallbackLauncher$Listener;", "", "", "onConnecting", "onConnected", "", "progress", "", "message", "onProcessing", "Lcom/iproov/sdk/IProov$SuccessResult;", "result", "onSuccess", "Lcom/iproov/sdk/IProov$FailureResult;", "onFailure", "Lcom/iproov/sdk/IProov$Canceller;", "canceller", "onCancelled", "Lcom/iproov/sdk/core/exception/IProovException;", "exception", "onError", "iproov_release"}, k = 1, mv = {1, 5, 1})
    public interface Listener {
        void onCancelled(IProov.Canceller canceller);

        void onConnected();

        void onConnecting();

        void onError(IProovException iProovException);

        void onFailure(IProov.FailureResult failureResult);

        void onProcessing(double d11, String str);

        void onSuccess(IProov.SuccessResult successResult);
    }

    public IProovCallbackLauncher() {
        this.internalOptions = new Cfor();
        this.jobs = new LinkedHashMap();
        this.iProovFlowLauncher = new IProovFlowLauncher(this.internalOptions);
    }

    /* access modifiers changed from: private */
    public final void createListenerJob(UUID uuid) {
        this.jobs.put(uuid, i.d(i0.a(v0.a()), (CoroutineContext) null, (CoroutineStart) null, new IProovCallbackLauncher$createListenerJob$job$1(this, uuid, (c<? super IProovCallbackLauncher$createListenerJob$job$1>) null), 3, (Object) null));
    }

    /* access modifiers changed from: private */
    public final Object dispatchToListener(IProov.IProovState iProovState, c<? super Unit> cVar) {
        return g.g(v0.c(), new IProovCallbackLauncher$dispatchToListener$2(iProovState, this, (c<? super IProovCallbackLauncher$dispatchToListener$2>) null), cVar);
    }

    public static /* synthetic */ IProov.Session launch$default(IProovCallbackLauncher iProovCallbackLauncher, Context context, String str, String str2, IProov.Options options, int i11, Object obj) {
        String str3;
        String str4;
        Context context2;
        IProovCallbackLauncher iProovCallbackLauncher2;
        IProov.Options options2;
        if ((i11 & 8) != 0) {
            options2 = new IProov.Options((String) null, 0, 0, (IProov.Options.Filter) null, 0, (IProov.Options.Font) null, (IProov.Options.Icon) null, false, (IProov.Options.CloseButton) null, 0, 0, false, false, (List) null, 0, (IProov.Orientation) null, (IProov.Camera) null, (IProov.FaceDetector) null, (IProov.Options.GenuinePresenceAssurance) null, (IProov.Options.LivenessAssurance) null, 1048575, (r) null);
            iProovCallbackLauncher2 = iProovCallbackLauncher;
            context2 = context;
            str4 = str;
            str3 = str2;
        } else {
            iProovCallbackLauncher2 = iProovCallbackLauncher;
            context2 = context;
            str4 = str;
            str3 = str2;
            options2 = options;
        }
        return iProovCallbackLauncher2.launch(context2, str4, str3, options2);
    }

    public final IProov.Session currentSession() {
        return (IProov.Session) h.b((CoroutineContext) null, new IProovCallbackLauncher$currentSession$1((c<? super IProovCallbackLauncher$currentSession$1>) null), 1, (Object) null);
    }

    public String getBuildHash() {
        return CommonApi.Cdo.m54do(this);
    }

    public String getBuildNumber() {
        return CommonApi.Cdo.m56if(this);
    }

    public CommonApi.KeyPair getKeyPair(Context context) throws UnexpectedErrorException {
        return this.iProovFlowLauncher.getKeyPair(context);
    }

    public final Listener getListener() {
        return this.listener;
    }

    public String getSdkVersion() {
        return CommonApi.Cdo.m55for(this);
    }

    public final IProov.Session launch(Context context, String str, String str2, IProov.Options options) {
        return (IProov.Session) h.b((CoroutineContext) null, new IProovCallbackLauncher$launch$1(this, context, str, str2, options, (c<? super IProovCallbackLauncher$launch$1>) null), 1, (Object) null);
    }

    public final IProov.Session launchSession(Context context, String str, String str2, Cextends extendsR) {
        return (IProov.Session) h.b((CoroutineContext) null, new IProovCallbackLauncher$launchSession$1(this, context, str, str2, extendsR, (c<? super IProovCallbackLauncher$launchSession$1>) null), 1, (Object) null);
    }

    public final void setListener(Listener listener2) {
        this.listener = listener2;
    }

    public IProovCallbackLauncher(Cfor forR) {
        this();
        this.internalOptions = forR;
    }
}
