package com.kakao.sdk.network;

import com.kakao.sdk.common.model.ApiError;
import com.kakao.sdk.common.model.ApiErrorCause;
import com.kakao.sdk.common.model.ApiErrorResponse;
import com.kakao.sdk.common.util.SdkLog;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;

@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b&\u0018\u0000 \u0007*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u0011B\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00018\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\f\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J$\u0010\u000f\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0016R\u0017\u0010\u0014\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/kakao/sdk/network/ApiCallback;", "T", "Lretrofit2/Callback;", "model", "", "error", "", "b", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "Lretrofit2/Call;", "call", "t", "onFailure", "Lretrofit2/Response;", "response", "onResponse", "", "a", "Z", "()Z", "logging", "<init>", "(Z)V", "network_release"}, k = 1, mv = {1, 6, 0})
public abstract class ApiCallback<T> implements Callback<T> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f25112b = new a((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final boolean f25113a;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0007"}, d2 = {"Lcom/kakao/sdk/network/ApiCallback$a;", "", "", "t", "a", "<init>", "()V", "network_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final Throwable a(Throwable th2) {
            try {
                if (!(th2 instanceof HttpException)) {
                    return b.a(th2);
                }
                Response<?> response = ((HttpException) th2).response();
                String str = null;
                if (response != null) {
                    ResponseBody errorBody = response.errorBody();
                    if (errorBody != null) {
                        str = errorBody.string();
                    }
                }
                com.kakao.sdk.common.util.a aVar = com.kakao.sdk.common.util.a.f25105a;
                ApiErrorResponse apiErrorResponse = (ApiErrorResponse) aVar.a(str, ApiErrorResponse.class);
                ApiErrorCause apiErrorCause = (ApiErrorCause) aVar.a(String.valueOf(apiErrorResponse.getCode()), ApiErrorCause.class);
                if (apiErrorCause == null) {
                    apiErrorCause = ApiErrorCause.Unknown;
                }
                return new ApiError(((HttpException) th2).code(), apiErrorCause, apiErrorResponse);
            } catch (Throwable th3) {
                return th3;
            }
        }
    }

    public ApiCallback() {
        this(false, 1, (r) null);
    }

    public ApiCallback(boolean z11) {
        this.f25113a = z11;
    }

    public final boolean a() {
        return this.f25113a;
    }

    public abstract void b(T t11, Throwable th2);

    public void onFailure(Call<T> call, Throwable th2) {
        Throwable a11 = b.a(th2);
        if (a()) {
            SdkLog.f25100d.b(a11);
        }
        b((Object) null, a11);
    }

    public void onResponse(Call<T> call, Response<T> response) {
        T body = response.body();
        if (body != null) {
            if (this.f25113a) {
                SdkLog.f25100d.d(body);
            }
            b(body, (Throwable) null);
            return;
        }
        onFailure(call, f25112b.a(new HttpException(response)));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ApiCallback(boolean z11, int i11, r rVar) {
        this((i11 & 1) != 0 ? true : z11);
    }
}
