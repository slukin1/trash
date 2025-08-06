package com.kakao.sdk.common.util;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import com.kakao.sdk.common.model.ClientError;
import com.kakao.sdk.common.model.ClientErrorCause;
import com.kakao.sdk.common.model.KakaoSdkError;
import com.kakao.sdk.common.util.SdkLog;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.x;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u00020\u0004B\u000f\b\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H&J\u0018\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J\u0015\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00028\u0000H&¢\u0006\u0002\u0010\rJ\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0017\u0010\u001f\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0011\u001a\u00020\u0012H&¢\u0006\u0002\u0010 J\u0006\u0010!\u001a\u00020\u0014J\u000e\u0010\"\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010#\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bR*\u0010\t\u001a\u0004\u0018\u00018\u00012\b\u0010\b\u001a\u0004\u0018\u00018\u0001@DX\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/kakao/sdk/common/util/BaseResultReceiver;", "T", "", "E", "Landroid/os/ResultReceiver;", "identifier", "", "(Ljava/lang/String;)V", "<set-?>", "emitter", "getEmitter", "()Ljava/lang/Object;", "setEmitter", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "isError", "", "url", "Landroid/net/Uri;", "onError", "", "error", "", "onReceiveResult", "resultCode", "", "resultData", "Landroid/os/Bundle;", "onSuccess", "response", "parseError", "parseResponse", "(Landroid/net/Uri;)Ljava/lang/Object;", "processError", "receiveCanceled", "receiveOk", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class BaseResultReceiver<T, E> extends ResultReceiver {
    private E emitter;
    private final String identifier;

    public BaseResultReceiver(String str) {
        super(new Handler(Looper.getMainLooper()));
        this.identifier = str;
    }

    public final E getEmitter() {
        return this.emitter;
    }

    public abstract boolean isError(Uri uri);

    public abstract void onError(Throwable th2);

    public void onReceiveResult(int i11, Bundle bundle) {
        SdkLog.a aVar = SdkLog.f25100d;
        aVar.a("***** " + this.identifier + " Status: " + bundle);
        if (i11 == -1) {
            receiveOk(bundle);
        } else if (i11 != 0) {
            processError();
        } else {
            receiveCanceled(bundle);
        }
        this.emitter = null;
    }

    public abstract void onSuccess(T t11);

    public abstract Throwable parseError(Uri uri);

    public abstract T parseResponse(Uri uri);

    public final void processError() {
        onError(new IllegalStateException("Unknown resultCode in " + getClass().getSimpleName() + "#onReceivedResult()"));
    }

    public final void receiveCanceled(Bundle bundle) {
        KakaoSdkError kakaoSdkError;
        if (Build.VERSION.SDK_INT >= 33) {
            kakaoSdkError = (KakaoSdkError) bundle.getSerializable("key.exception", KakaoSdkError.class);
        } else {
            Serializable serializable = bundle.getSerializable("key.exception");
            Objects.requireNonNull(serializable, "null cannot be cast to non-null type com.kakao.sdk.common.model.KakaoSdkError");
            kakaoSdkError = (KakaoSdkError) serializable;
        }
        if (kakaoSdkError != null) {
            onError(kakaoSdkError);
        }
    }

    public final void receiveOk(Bundle bundle) {
        Uri uri;
        if (Build.VERSION.SDK_INT >= 33) {
            uri = (Uri) bundle.getParcelable("key.url", Uri.class);
        } else {
            uri = (Uri) bundle.getParcelable("key.url");
        }
        if (uri == null) {
            throw new IllegalStateException();
        } else if (isError(uri)) {
            onError(parseError(uri));
        } else {
            Object parseResponse = parseResponse(uri);
            if (parseResponse == null) {
                onError(new ClientError(ClientErrorCause.Unknown, x.i("Failed to parse response\n", uri)));
            } else {
                onSuccess(parseResponse);
            }
        }
    }

    public final void setEmitter(E e11) {
        this.emitter = e11;
    }
}
