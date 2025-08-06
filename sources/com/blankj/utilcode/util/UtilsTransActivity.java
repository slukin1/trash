package com.blankj.utilcode.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.appcompat.app.AppCompatActivity;
import com.blankj.utilcode.util.Utils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UtilsTransActivity extends AppCompatActivity {

    /* renamed from: b  reason: collision with root package name */
    public static final Map<UtilsTransActivity, TransActivityDelegate> f63534b = new HashMap();

    public static abstract class TransActivityDelegate implements Serializable {
        public boolean dispatchTouchEvent(UtilsTransActivity utilsTransActivity, MotionEvent motionEvent) {
            Objects.requireNonNull(utilsTransActivity, "Argument 'activity' of type UtilsTransActivity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            return false;
        }

        public void onActivityResult(UtilsTransActivity utilsTransActivity, int i11, int i12, Intent intent) {
            Objects.requireNonNull(utilsTransActivity, "Argument 'activity' of type UtilsTransActivity (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }

        public void onCreateBefore(UtilsTransActivity utilsTransActivity, Bundle bundle) {
            Objects.requireNonNull(utilsTransActivity, "Argument 'activity' of type UtilsTransActivity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }

        public void onCreated(UtilsTransActivity utilsTransActivity, Bundle bundle) {
            Objects.requireNonNull(utilsTransActivity, "Argument 'activity' of type UtilsTransActivity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }

        public void onDestroy(UtilsTransActivity utilsTransActivity) {
            Objects.requireNonNull(utilsTransActivity, "Argument 'activity' of type UtilsTransActivity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }

        public void onPaused(UtilsTransActivity utilsTransActivity) {
            Objects.requireNonNull(utilsTransActivity, "Argument 'activity' of type UtilsTransActivity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }

        public void onRequestPermissionsResult(UtilsTransActivity utilsTransActivity, int i11, String[] strArr, int[] iArr) {
            Objects.requireNonNull(utilsTransActivity, "Argument 'activity' of type UtilsTransActivity (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            Objects.requireNonNull(strArr, "Argument 'permissions' of type String[] (#2 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            Objects.requireNonNull(iArr, "Argument 'grantResults' of type int[] (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }

        public void onResumed(UtilsTransActivity utilsTransActivity) {
            Objects.requireNonNull(utilsTransActivity, "Argument 'activity' of type UtilsTransActivity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }

        public void onSaveInstanceState(UtilsTransActivity utilsTransActivity, Bundle bundle) {
            Objects.requireNonNull(utilsTransActivity, "Argument 'activity' of type UtilsTransActivity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }

        public void onStarted(UtilsTransActivity utilsTransActivity) {
            Objects.requireNonNull(utilsTransActivity, "Argument 'activity' of type UtilsTransActivity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }

        public void onStopped(UtilsTransActivity utilsTransActivity) {
            Objects.requireNonNull(utilsTransActivity, "Argument 'activity' of type UtilsTransActivity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
    }

    public static void Af(Utils.a<Intent> aVar, TransActivityDelegate transActivityDelegate) {
        nf((Activity) null, aVar, transActivityDelegate, UtilsTransActivity.class);
    }

    public static void nf(Activity activity, Utils.a<Intent> aVar, TransActivityDelegate transActivityDelegate, Class<?> cls) {
        if (transActivityDelegate != null) {
            Intent intent = new Intent(Utils.a(), cls);
            intent.putExtra("extra_delegate", transActivityDelegate);
            if (aVar != null) {
                aVar.accept(intent);
            }
            if (activity == null) {
                intent.addFlags(268435456);
                Utils.a().startActivity(intent);
                return;
            }
            activity.startActivity(intent);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        TransActivityDelegate transActivityDelegate = f63534b.get(this);
        if (transActivityDelegate == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (transActivityDelegate.dispatchTouchEvent(this, motionEvent)) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        TransActivityDelegate transActivityDelegate = f63534b.get(this);
        if (transActivityDelegate != null) {
            transActivityDelegate.onActivityResult(this, i11, i12, intent);
        }
    }

    public void onCreate(Bundle bundle) {
        overridePendingTransition(0, 0);
        Serializable serializableExtra = getIntent().getSerializableExtra("extra_delegate");
        if (!(serializableExtra instanceof TransActivityDelegate)) {
            super.onCreate(bundle);
            finish();
            return;
        }
        TransActivityDelegate transActivityDelegate = (TransActivityDelegate) serializableExtra;
        f63534b.put(this, transActivityDelegate);
        transActivityDelegate.onCreateBefore(this, bundle);
        super.onCreate(bundle);
        transActivityDelegate.onCreated(this, bundle);
    }

    public void onDestroy() {
        super.onDestroy();
        Map<UtilsTransActivity, TransActivityDelegate> map = f63534b;
        TransActivityDelegate transActivityDelegate = map.get(this);
        if (transActivityDelegate != null) {
            transActivityDelegate.onDestroy(this);
            map.remove(this);
        }
    }

    public void onPause() {
        overridePendingTransition(0, 0);
        super.onPause();
        TransActivityDelegate transActivityDelegate = f63534b.get(this);
        if (transActivityDelegate != null) {
            transActivityDelegate.onPaused(this);
        }
    }

    public void onRequestPermissionsResult(int i11, String[] strArr, int[] iArr) {
        Objects.requireNonNull(strArr, "Argument 'permissions' of type String[] (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(iArr, "Argument 'grantResults' of type int[] (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        super.onRequestPermissionsResult(i11, strArr, iArr);
        TransActivityDelegate transActivityDelegate = f63534b.get(this);
        if (transActivityDelegate != null) {
            transActivityDelegate.onRequestPermissionsResult(this, i11, strArr, iArr);
        }
    }

    public void onResume() {
        super.onResume();
        TransActivityDelegate transActivityDelegate = f63534b.get(this);
        if (transActivityDelegate != null) {
            transActivityDelegate.onResumed(this);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        TransActivityDelegate transActivityDelegate = f63534b.get(this);
        if (transActivityDelegate != null) {
            transActivityDelegate.onSaveInstanceState(this, bundle);
        }
    }

    public void onStart() {
        super.onStart();
        TransActivityDelegate transActivityDelegate = f63534b.get(this);
        if (transActivityDelegate != null) {
            transActivityDelegate.onStarted(this);
        }
    }

    public void onStop() {
        super.onStop();
        TransActivityDelegate transActivityDelegate = f63534b.get(this);
        if (transActivityDelegate != null) {
            transActivityDelegate.onStopped(this);
        }
    }
}
