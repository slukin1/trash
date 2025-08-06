package com.google.android.recaptcha.internal;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import kotlinx.coroutines.n0;

public final class zzj {
    public static final Task zza(n0 n0Var) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource(new CancellationTokenSource().getToken());
        n0Var.L(new zzi(taskCompletionSource, n0Var));
        return taskCompletionSource.getTask();
    }
}
