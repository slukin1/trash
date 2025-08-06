package eg;

import com.huawei.hmf.tasks.Task;

public interface a<TResult> {
    void cancel();

    void onComplete(Task<TResult> task);
}
