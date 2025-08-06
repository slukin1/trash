package com.hbg.lib.core.network.rx;

import android.text.TextUtils;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import com.hbg.lib.network.retrofit.util.SPUtil;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import i6.k;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;
import retrofit2.HttpException;
import rx.functions.Action0;
import rx.functions.Action1;

public class EasySubscriber<T> extends BaseSubscriber<T> {
    public static final String ERROR_CODE_1450 = "1450";
    public static final String ERROR_CODE_1451 = "1451";
    private Action0 after;
    private Action0 before;
    private Action1<Throwable> error;
    private Action1<APIStatusErrorException> failed;
    private Action1<T> next;

    public EasySubscriber() {
    }

    public static <B> EasySubscriber<B> create(Action1<B> action1) {
        return new EasySubscriber<>(action1);
    }

    private boolean doubleCheckUnionMode(String str) {
        if ("6001".equalsIgnoreCase(str)) {
            return !SPUtil.j();
        }
        return false;
    }

    public void onAfter() {
        super.onAfter();
        Action0 action0 = this.after;
        if (action0 != null) {
            action0.call();
        }
    }

    public final void onError(Throwable th2) {
        if (th2 instanceof APIStatusErrorException) {
            onFailed((APIStatusErrorException) th2);
        } else {
            onError2(th2);
        }
        super.onError(th2);
    }

    public void onError2(Throwable th2) {
        Action1<Throwable> action1 = this.error;
        if (action1 != null) {
            action1.call(th2);
        }
        if ((th2 instanceof SocketTimeoutException) || (th2 instanceof SocketException) || (th2 instanceof TimeoutException) || (th2 instanceof HttpException) || (th2 instanceof UnknownHostException)) {
            k.e("ERROR_TOAST");
            printLog(th2);
        }
    }

    public void onFailed(APIStatusErrorException aPIStatusErrorException) {
        Action1<APIStatusErrorException> action1 = this.failed;
        if (action1 != null) {
            action1.call(aPIStatusErrorException);
        }
        if (!doubleCheckUnionMode(aPIStatusErrorException.getErrCode()) && !TextUtils.isEmpty(aPIStatusErrorException.getErrMsg())) {
            HuobiToastUtil.l(BaseApplication.b(), aPIStatusErrorException.getErrMsg());
        }
    }

    public void onNext(T t11) {
        super.onNext(t11);
        Action1<T> action1 = this.next;
        if (action1 != null) {
            action1.call(t11);
        }
    }

    public void onStart() {
        super.onStart();
        Action0 action0 = this.before;
        if (action0 != null) {
            action0.call();
        }
    }

    public void printLog(Throwable th2) {
        if (!(th2 instanceof APIStatusErrorException)) {
            StackTraceElement[] stackTrace = th2.getStackTrace();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(th2 + "\n");
            if (stackTrace != null) {
                for (StackTraceElement append : stackTrace) {
                    sb2.append(append);
                    sb2.append("\n");
                }
            }
            RetrofitLogger.g(sb2.toString());
        }
    }

    public EasySubscriber(Action1<T> action1) {
        this.next = action1;
    }

    public static <B> EasySubscriber<B> create(Action1<B> action1, Action1<APIStatusErrorException> action12, Action1<Throwable> action13) {
        return new EasySubscriber<>(action1, action12, action13);
    }

    public static <B> EasySubscriber<B> create(Action0 action0, Action1<B> action1, Action1<APIStatusErrorException> action12, Action1<Throwable> action13) {
        return new EasySubscriber<>(action0, action1, action12, action13);
    }

    public EasySubscriber(Action1<T> action1, Action1<APIStatusErrorException> action12, Action1<Throwable> action13) {
        this.next = action1;
        this.failed = action12;
        this.error = action13;
    }

    public static <B> EasySubscriber<B> create(Action0 action0, Action1<B> action1, Action1<APIStatusErrorException> action12, Action1<Throwable> action13, Action0 action02) {
        return new EasySubscriber(action0, action1, action12, action13, action02);
    }

    public EasySubscriber(Action0 action0, Action1<T> action1, Action1<APIStatusErrorException> action12, Action1<Throwable> action13) {
        this.before = action0;
        this.next = action1;
        this.failed = action12;
        this.error = action13;
    }

    public EasySubscriber(Action0 action0, Action1<T> action1, Action1<APIStatusErrorException> action12, Action1<Throwable> action13, Action0 action02) {
        this.before = action0;
        this.next = action1;
        this.failed = action12;
        this.error = action13;
        this.after = action02;
    }
}
