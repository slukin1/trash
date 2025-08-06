package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.zac;
import com.google.android.gms.dynamic.LifecycleDelegate;
import java.util.LinkedList;

@KeepForSdk
public abstract class DeferredLifecycleHelper<T extends LifecycleDelegate> {
    /* access modifiers changed from: private */
    public T zaa;
    /* access modifiers changed from: private */
    public Bundle zab;
    /* access modifiers changed from: private */
    public LinkedList<zah> zac;
    private final OnDelegateCreatedListener<T> zad = new zaa(this);

    @KeepForSdk
    public static void showGooglePlayUnavailableMessage(FrameLayout frameLayout) {
        GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
        Context context = frameLayout.getContext();
        int isGooglePlayServicesAvailable = instance.isGooglePlayServicesAvailable(context);
        String zad2 = zac.zad(context, isGooglePlayServicesAvailable);
        String zac2 = zac.zac(context, isGooglePlayServicesAvailable);
        LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        TextView textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        textView.setText(zad2);
        linearLayout.addView(textView);
        Intent errorResolutionIntent = instance.getErrorResolutionIntent(context, isGooglePlayServicesAvailable, (String) null);
        if (errorResolutionIntent != null) {
            Button button = new Button(context);
            button.setId(16908313);
            button.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            button.setText(zac2);
            linearLayout.addView(button);
            button.setOnClickListener(new zae(context, errorResolutionIntent));
        }
    }

    private final void zae(int i11) {
        while (!this.zac.isEmpty() && this.zac.getLast().zaa() >= i11) {
            this.zac.removeLast();
        }
    }

    private final void zaf(Bundle bundle, zah zah) {
        T t11 = this.zaa;
        if (t11 != null) {
            zah.zab(t11);
            return;
        }
        if (this.zac == null) {
            this.zac = new LinkedList<>();
        }
        this.zac.add(zah);
        if (bundle != null) {
            Bundle bundle2 = this.zab;
            if (bundle2 == null) {
                this.zab = (Bundle) bundle.clone();
            } else {
                bundle2.putAll(bundle);
            }
        }
        createDelegate(this.zad);
    }

    @KeepForSdk
    public abstract void createDelegate(OnDelegateCreatedListener<T> onDelegateCreatedListener);

    @KeepForSdk
    public T getDelegate() {
        return this.zaa;
    }

    @KeepForSdk
    public void handleGooglePlayUnavailable(FrameLayout frameLayout) {
        showGooglePlayUnavailableMessage(frameLayout);
    }

    @KeepForSdk
    public void onCreate(Bundle bundle) {
        zaf(bundle, new zac(this, bundle));
    }

    @KeepForSdk
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        zaf(bundle, new zad(this, frameLayout, layoutInflater, viewGroup, bundle));
        if (this.zaa == null) {
            handleGooglePlayUnavailable(frameLayout);
        }
        return frameLayout;
    }

    @KeepForSdk
    public void onDestroy() {
        T t11 = this.zaa;
        if (t11 != null) {
            t11.onDestroy();
        } else {
            zae(1);
        }
    }

    @KeepForSdk
    public void onDestroyView() {
        T t11 = this.zaa;
        if (t11 != null) {
            t11.onDestroyView();
        } else {
            zae(2);
        }
    }

    @KeepForSdk
    public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
        zaf(bundle2, new zab(this, activity, bundle, bundle2));
    }

    @KeepForSdk
    public void onLowMemory() {
        T t11 = this.zaa;
        if (t11 != null) {
            t11.onLowMemory();
        }
    }

    @KeepForSdk
    public void onPause() {
        T t11 = this.zaa;
        if (t11 != null) {
            t11.onPause();
        } else {
            zae(5);
        }
    }

    @KeepForSdk
    public void onResume() {
        zaf((Bundle) null, new zag(this));
    }

    @KeepForSdk
    public void onSaveInstanceState(Bundle bundle) {
        T t11 = this.zaa;
        if (t11 != null) {
            t11.onSaveInstanceState(bundle);
            return;
        }
        Bundle bundle2 = this.zab;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
    }

    @KeepForSdk
    public void onStart() {
        zaf((Bundle) null, new zaf(this));
    }

    @KeepForSdk
    public void onStop() {
        T t11 = this.zaa;
        if (t11 != null) {
            t11.onStop();
        } else {
            zae(4);
        }
    }
}
