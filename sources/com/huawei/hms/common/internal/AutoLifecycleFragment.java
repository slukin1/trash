package com.huawei.hms.common.internal;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.SparseArray;
import com.huawei.hms.api.HuaweiApiClient;

public class AutoLifecycleFragment extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private final SparseArray<a> f37891a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    private boolean f37892b;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final HuaweiApiClient f37893a;

        /* renamed from: b  reason: collision with root package name */
        public final int f37894b;

        public a(int i11, HuaweiApiClient huaweiApiClient) {
            this.f37893a = huaweiApiClient;
            this.f37894b = i11;
        }

        public void a() {
            this.f37893a.disconnect();
        }
    }

    public static AutoLifecycleFragment getInstance(Activity activity) {
        Preconditions.checkMainThread("Must be called on the main thread");
        try {
            AutoLifecycleFragment autoLifecycleFragment = (AutoLifecycleFragment) activity.getFragmentManager().findFragmentByTag("HmsAutoLifecycleFrag");
            FragmentManager fragmentManager = activity.getFragmentManager();
            if (autoLifecycleFragment != null) {
                return autoLifecycleFragment;
            }
            AutoLifecycleFragment autoLifecycleFragment2 = new AutoLifecycleFragment();
            fragmentManager.beginTransaction().add(autoLifecycleFragment2, "HmsAutoLifecycleFrag").commitAllowingStateLoss();
            fragmentManager.executePendingTransactions();
            return autoLifecycleFragment2;
        } catch (ClassCastException e11) {
            throw new IllegalStateException("Fragment with tag HmsAutoLifecycleFrag is not a AutoLifecycleFragment", e11);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onStart() {
        super.onStart();
        this.f37892b = true;
        for (int i11 = 0; i11 < this.f37891a.size(); i11++) {
            this.f37891a.valueAt(i11).f37893a.connect((Activity) null);
        }
    }

    public void onStop() {
        super.onStop();
        this.f37892b = false;
        for (int i11 = 0; i11 < this.f37891a.size(); i11++) {
            this.f37891a.valueAt(i11).f37893a.disconnect();
        }
    }

    public void startAutoMange(int i11, HuaweiApiClient huaweiApiClient) {
        Preconditions.checkNotNull(huaweiApiClient, "HuaweiApiClient instance cannot be null");
        boolean z11 = this.f37891a.indexOfKey(i11) < 0;
        Preconditions.checkState(z11, "Already managing a HuaweiApiClient with this clientId: " + i11);
        this.f37891a.put(i11, new a(i11, huaweiApiClient));
        if (this.f37892b) {
            huaweiApiClient.connect((Activity) null);
        }
    }

    public void stopAutoManage(int i11) {
        a aVar = this.f37891a.get(i11);
        this.f37891a.remove(i11);
        if (aVar != null) {
            aVar.a();
        }
    }
}
