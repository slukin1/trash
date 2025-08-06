package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;

public interface a {
    <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> activityResultContract, ActivityResultCallback<O> activityResultCallback);
}
