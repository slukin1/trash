package xw;

import com.kakao.network.tasks.KakaoResultTask;
import java.util.concurrent.Future;

public interface b {
    <T> Future<T> a(KakaoResultTask<T> kakaoResultTask);
}
