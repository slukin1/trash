package com.huobi.otc.ui;

import android.content.Intent;
import com.hbg.lib.common.mvp.ActivityPresenter;
import u6.g;

public abstract class BaseLifeCycleFlutterFragmentActivity<P extends ActivityPresenter<V>, V extends g> extends BaseDragActivity<P, V> {

    /* renamed from: d  reason: collision with root package name */
    public a f79230d;

    public interface a {
        void onBackPressed();

        void onNewIntent(Intent intent);

        void onPostResume();

        void onRequestPermissionsResult(int i11, String[] strArr, int[] iArr);

        void onTrimMemory(int i11);

        void onUserLeaveHint();
    }

    public void onBackPressed() {
        a aVar = this.f79230d;
        if (aVar != null) {
            aVar.onBackPressed();
        }
        super.onBackPressed();
    }

    public void onNewIntent(Intent intent) {
        a aVar = this.f79230d;
        if (aVar != null) {
            aVar.onNewIntent(intent);
        }
        super.onNewIntent(intent);
    }

    public void onPostResume() {
        super.onPostResume();
        a aVar = this.f79230d;
        if (aVar != null) {
            aVar.onPostResume();
        }
    }

    public void onRequestPermissionsResult(int i11, String[] strArr, int[] iArr) {
        a aVar = this.f79230d;
        if (aVar != null) {
            aVar.onRequestPermissionsResult(i11, strArr, iArr);
        }
        super.onRequestPermissionsResult(i11, strArr, iArr);
    }

    public void onTrimMemory(int i11) {
        super.onTrimMemory(i11);
        a aVar = this.f79230d;
        if (aVar != null) {
            aVar.onTrimMemory(i11);
        }
    }

    public void onUserLeaveHint() {
        a aVar = this.f79230d;
        if (aVar != null) {
            aVar.onUserLeaveHint();
        }
        super.onUserLeaveHint();
    }
}
