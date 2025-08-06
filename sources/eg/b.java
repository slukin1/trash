package eg;

import com.huawei.hmf.tasks.Task;

public interface b<TResult> {
    void onComplete(Task<TResult> task);
}
