package xw;

import com.kakao.network.tasks.KakaoResultTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public abstract class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public ExecutorService f26378a;

    public a(ExecutorService executorService) {
        this.f26378a = executorService;
    }

    public <T> Future<T> a(KakaoResultTask<T> kakaoResultTask) {
        return this.f26378a.submit(kakaoResultTask.c());
    }
}
