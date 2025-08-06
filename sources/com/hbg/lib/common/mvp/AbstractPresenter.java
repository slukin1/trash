package com.hbg.lib.common.mvp;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.hbg.lib.common.ui.BaseCoreActivity;
import h6.a;
import java.lang.ref.WeakReference;

public class AbstractPresenter<V extends a> {
    private BaseCoreActivity activity;
    private WeakReference<V> mUI;

    public BaseCoreActivity getActivity() {
        return this.activity;
    }

    public Resources getResources() {
        return this.activity.getResources();
    }

    public String getString(int i11) {
        return getResources().getString(i11);
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
    }

    public void onDestroy() {
    }

    public void onPause() {
    }

    public void onRequestPermissionsResult(int i11, String[] strArr, int[] iArr) {
    }

    public void onRestoreInstanceState(Bundle bundle) {
    }

    public void onResume() {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public V getUI() {
        WeakReference<V> weakReference = this.mUI;
        if (weakReference == null) {
            return null;
        }
        return (a) weakReference.get();
    }

    public void onUIReady(BaseCoreActivity baseCoreActivity, V v11) {
        this.activity = baseCoreActivity;
        this.mUI = new WeakReference<>(v11);
    }
}
