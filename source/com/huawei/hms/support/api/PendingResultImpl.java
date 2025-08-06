package com.huawei.hms.support.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hms.adapter.BaseAdapter;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.InnerPendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.api.transport.DatagramTransport;
import com.huawei.hms.support.gentyref.GenericTypeReflector;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class PendingResultImpl<R extends Result, T extends IMessageEntity> extends InnerPendingResult<R> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public CountDownLatch f38471a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public R f38472b = null;

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<ApiClient> f38473c;

    /* renamed from: d  reason: collision with root package name */
    private String f38474d = null;

    /* renamed from: e  reason: collision with root package name */
    private String f38475e = null;

    /* renamed from: f  reason: collision with root package name */
    private boolean f38476f = true;
    public DatagramTransport transport = null;

    public class a implements DatagramTransport.a {
        public a() {
        }

        public void a(int i11, IMessageEntity iMessageEntity) {
            PendingResultImpl.this.a(i11, iMessageEntity);
            PendingResultImpl.this.f38471a.countDown();
        }
    }

    public class b implements DatagramTransport.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f38478a;

        public b(AtomicBoolean atomicBoolean) {
            this.f38478a = atomicBoolean;
        }

        public void a(int i11, IMessageEntity iMessageEntity) {
            if (!this.f38478a.get()) {
                PendingResultImpl.this.a(i11, iMessageEntity);
            }
            PendingResultImpl.this.f38471a.countDown();
        }
    }

    public class c implements DatagramTransport.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f38480a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ResultCallback f38481b;

        public c(d dVar, ResultCallback resultCallback) {
            this.f38480a = dVar;
            this.f38481b = resultCallback;
        }

        public void a(int i11, IMessageEntity iMessageEntity) {
            PendingResultImpl.this.a(i11, iMessageEntity);
            this.f38480a.a(this.f38481b, PendingResultImpl.this.f38472b);
        }
    }

    public static class d<R extends Result> extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        public void a(ResultCallback<? super R> resultCallback, R r11) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r11)));
        }

        public void b(ResultCallback<? super R> resultCallback, R r11) {
            resultCallback.onResult(r11);
        }

        public void handleMessage(Message message) {
            if (message.what == 1) {
                Pair pair = (Pair) message.obj;
                b((ResultCallback) pair.first, (Result) pair.second);
            }
        }
    }

    public PendingResultImpl(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
        a(apiClient, str, iMessageEntity, getResponseType(), 0);
    }

    public final R await() {
        HMSLog.i("PendingResultImpl", "await");
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return awaitOnAnyThread();
        }
        HMSLog.e("PendingResultImpl", "await in main thread");
        throw new IllegalStateException("await must not be called on the UI thread");
    }

    public final R awaitOnAnyThread() {
        HMSLog.i("PendingResultImpl", "awaitOnAnyThread");
        WeakReference<ApiClient> weakReference = this.f38473c;
        if (weakReference == null) {
            HMSLog.e("PendingResultImpl", "api is null");
            a((int) CommonCode.ErrorCode.CLIENT_API_INVALID, (IMessageEntity) null);
            return this.f38472b;
        }
        ApiClient apiClient = (ApiClient) weakReference.get();
        if (!checkApiClient(apiClient)) {
            HMSLog.e("PendingResultImpl", "client invalid");
            a((int) CommonCode.ErrorCode.CLIENT_API_INVALID, (IMessageEntity) null);
            return this.f38472b;
        }
        if (this.f38476f) {
            a(0, 1);
        }
        this.transport.send(apiClient, new a());
        try {
            this.f38471a.await();
        } catch (InterruptedException unused) {
            HMSLog.e("PendingResultImpl", "await in anythread InterruptedException");
            a((int) CommonCode.ErrorCode.INTERNAL_ERROR, (IMessageEntity) null);
        }
        return this.f38472b;
    }

    @Deprecated
    public void cancel() {
    }

    public boolean checkApiClient(ApiClient apiClient) {
        return true;
    }

    public Class<T> getResponseType() {
        Type type;
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass == null || (type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[1]) == null) {
            return null;
        }
        return (Class) type;
    }

    @Deprecated
    public boolean isCanceled() {
        return false;
    }

    public abstract R onComplete(T t11);

    public R onError(int i11) {
        Type genericSuperclass = getClass().getGenericSuperclass();
        Type type = genericSuperclass != null ? ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0] : null;
        Class type2 = type != null ? GenericTypeReflector.getType(type) : null;
        if (type2 != null) {
            try {
                R r11 = (Result) type2.newInstance();
                this.f38472b = r11;
                r11.setStatus(new Status(i11));
            } catch (Exception e11) {
                HMSLog.e("PendingResultImpl", "on Error:" + e11.getMessage());
                return null;
            }
        }
        return this.f38472b;
    }

    public void setResultCallback(ResultCallback<R> resultCallback) {
        this.f38476f = !(resultCallback instanceof BaseAdapter.BaseRequestResultCallback);
        setResultCallback(Looper.getMainLooper(), resultCallback);
    }

    private void a(ApiClient apiClient, String str, IMessageEntity iMessageEntity, Class<T> cls, int i11) {
        HMSLog.i("PendingResultImpl", "init uri:" + str);
        this.f38474d = str;
        if (apiClient == null) {
            HMSLog.e("PendingResultImpl", "client is null");
            return;
        }
        this.f38473c = new WeakReference<>(apiClient);
        this.f38471a = new CountDownLatch(1);
        try {
            this.transport = (DatagramTransport) Class.forName(apiClient.getTransportName()).getConstructor(new Class[]{String.class, IMessageEntity.class, Class.class, Integer.TYPE}).newInstance(new Object[]{str, iMessageEntity, cls, Integer.valueOf(i11)});
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | InvocationTargetException e11) {
            HMSLog.e("PendingResultImpl", "gen transport error:" + e11.getMessage());
            throw new IllegalStateException("Instancing transport exception, " + e11.getMessage(), e11);
        }
    }

    public final void setResultCallback(Looper looper, ResultCallback<R> resultCallback) {
        HMSLog.i("PendingResultImpl", "setResultCallback");
        if (looper == null) {
            looper = Looper.myLooper();
        }
        d dVar = new d(looper);
        WeakReference<ApiClient> weakReference = this.f38473c;
        if (weakReference == null) {
            HMSLog.e("PendingResultImpl", "api is null");
            a((int) CommonCode.ErrorCode.CLIENT_API_INVALID, (IMessageEntity) null);
            return;
        }
        ApiClient apiClient = (ApiClient) weakReference.get();
        if (!checkApiClient(apiClient)) {
            HMSLog.e("PendingResultImpl", "client is invalid");
            a((int) CommonCode.ErrorCode.CLIENT_API_INVALID, (IMessageEntity) null);
            dVar.a(resultCallback, this.f38472b);
            return;
        }
        if (this.f38476f) {
            a(0, 1);
        }
        this.transport.post(apiClient, new c(dVar, resultCallback));
    }

    public R await(long j11, TimeUnit timeUnit) {
        HMSLog.i("PendingResultImpl", "await timeout:" + j11 + " unit:" + timeUnit.toString());
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return awaitOnAnyThread(j11, timeUnit);
        }
        HMSLog.i("PendingResultImpl", "await in main thread");
        throw new IllegalStateException("await must not be called on the UI thread");
    }

    public PendingResultImpl(ApiClient apiClient, String str, IMessageEntity iMessageEntity, Class<T> cls) {
        a(apiClient, str, iMessageEntity, cls, 0);
    }

    /* access modifiers changed from: private */
    public void a(int i11, IMessageEntity iMessageEntity) {
        Status status;
        HMSLog.i("PendingResultImpl", "setResult:" + i11);
        Status commonStatus = iMessageEntity instanceof AbstractMessageEntity ? ((AbstractMessageEntity) iMessageEntity).getCommonStatus() : null;
        if (i11 == 0) {
            this.f38472b = onComplete(iMessageEntity);
        } else {
            this.f38472b = onError(i11);
        }
        if (this.f38476f) {
            a(i11, 2);
        }
        R r11 = this.f38472b;
        if (r11 != null && (status = r11.getStatus()) != null && commonStatus != null) {
            int statusCode = status.getStatusCode();
            String statusMessage = status.getStatusMessage();
            int statusCode2 = commonStatus.getStatusCode();
            String statusMessage2 = commonStatus.getStatusMessage();
            if (statusCode != statusCode2) {
                HMSLog.e("PendingResultImpl", "rstStatus code (" + statusCode + ") is not equal commonStatus code (" + statusCode2 + ")");
                HMSLog.e("PendingResultImpl", "rstStatus msg (" + statusMessage + ") is not equal commonStatus msg (" + statusMessage2 + ")");
            } else if (TextUtils.isEmpty(statusMessage) && !TextUtils.isEmpty(statusMessage2)) {
                HMSLog.i("PendingResultImpl", "rstStatus msg (" + statusMessage + ") is not equal commonStatus msg (" + statusMessage2 + ")");
                this.f38472b.setStatus(new Status(statusCode, statusMessage2, status.getResolution()));
            }
        }
    }

    public PendingResultImpl(ApiClient apiClient, String str, IMessageEntity iMessageEntity, int i11) {
        a(apiClient, str, iMessageEntity, getResponseType(), i11);
    }

    @Deprecated
    public void setResultCallback(ResultCallback<R> resultCallback, long j11, TimeUnit timeUnit) {
        setResultCallback(resultCallback);
    }

    public final R awaitOnAnyThread(long j11, TimeUnit timeUnit) {
        HMSLog.i("PendingResultImpl", "awaitOnAnyThread timeout:" + j11 + " unit:" + timeUnit.toString());
        WeakReference<ApiClient> weakReference = this.f38473c;
        if (weakReference == null) {
            HMSLog.e("PendingResultImpl", "api is null");
            a((int) CommonCode.ErrorCode.CLIENT_API_INVALID, (IMessageEntity) null);
            return this.f38472b;
        }
        ApiClient apiClient = (ApiClient) weakReference.get();
        if (!checkApiClient(apiClient)) {
            HMSLog.e("PendingResultImpl", "client invalid");
            a((int) CommonCode.ErrorCode.CLIENT_API_INVALID, (IMessageEntity) null);
            return this.f38472b;
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        if (this.f38476f) {
            a(0, 1);
        }
        this.transport.post(apiClient, new b(atomicBoolean));
        try {
            if (!this.f38471a.await(j11, timeUnit)) {
                atomicBoolean.set(true);
                a((int) CommonCode.ErrorCode.EXECUTE_TIMEOUT, (IMessageEntity) null);
            }
        } catch (InterruptedException unused) {
            HMSLog.e("PendingResultImpl", "awaitOnAnyThread InterruptedException");
            a((int) CommonCode.ErrorCode.INTERNAL_ERROR, (IMessageEntity) null);
        }
        return this.f38472b;
    }

    private void a(int i11, int i12) {
        SubAppInfo subAppInfo;
        HMSLog.i("PendingResultImpl", "biReportEvent ====== ");
        ApiClient apiClient = (ApiClient) this.f38473c.get();
        if (apiClient == null || this.f38474d == null || HiAnalyticsUtil.getInstance().hasError(apiClient.getContext())) {
            HMSLog.e("PendingResultImpl", "<biReportEvent> has some error.");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("package", apiClient.getPackageName());
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION, "6.11.0.302");
        if (i12 == 1) {
            hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.REQUEST);
        } else {
            hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.RESPONSE);
            hashMap.put("result", String.valueOf(i11));
            R r11 = this.f38472b;
            if (!(r11 == null || r11.getStatus() == null)) {
                hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, String.valueOf(this.f38472b.getStatus().getStatusCode()));
            }
        }
        hashMap.put("version", "0");
        String appId = Util.getAppId(apiClient.getContext());
        if (TextUtils.isEmpty(appId) && (subAppInfo = apiClient.getSubAppInfo()) != null) {
            appId = subAppInfo.getSubAppID();
        }
        hashMap.put("appid", appId);
        if (TextUtils.isEmpty(this.f38475e)) {
            String id2 = TransactionIdCreater.getId(appId, this.f38474d);
            this.f38475e = id2;
            hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_TRANSID, id2);
        } else {
            hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_TRANSID, this.f38475e);
            this.f38475e = null;
        }
        String[] split = this.f38474d.split("\\.");
        if (split.length >= 2) {
            hashMap.put("service", split[0]);
            hashMap.put("apiName", split[1]);
        }
        hashMap.put("callTime", String.valueOf(System.currentTimeMillis()));
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onEvent(apiClient.getContext(), HiAnalyticsConstant.HMS_SDK_BASE_CALL_AIDL, (Map<String, String>) hashMap);
    }
}
