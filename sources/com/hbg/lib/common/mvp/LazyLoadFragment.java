package com.hbg.lib.common.mvp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hbg.lib.common.ui.BaseCoreFragment;
import i6.d;
import i6.i;

abstract class LazyLoadFragment extends BaseCoreFragment {

    /* renamed from: c  reason: collision with root package name */
    public boolean f67461c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f67462d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f67463e = false;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f67464f = new a();

    /* renamed from: g  reason: collision with root package name */
    public Runnable f67465g = new b();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            LazyLoadFragment.this.uh(true);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            LazyLoadFragment.this.uh(false);
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getUserVisibleHint() && !this.f67462d) {
            sh();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f67461c = true;
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        wh(!z11 && getUserVisibleHint());
    }

    public void onPause() {
        super.onPause();
        if (isAdded()) {
            wh(false);
        }
    }

    public void onResume() {
        super.onResume();
        if (isAdded()) {
            wh(!vh() && getUserVisibleHint());
        }
    }

    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        if (z11 && this.f67461c && !this.f67462d) {
            sh();
        }
        if (this.f67461c && isAdded()) {
            wh(z11 && !vh());
        }
    }

    public void sh() {
        this.f67462d = true;
    }

    public void th(boolean z11) {
        d.i(getClass().getSimpleName() + "------enter------  visible:" + z11);
        i.b().h(this.f67464f);
        i.b().h(this.f67465g);
        if (z11) {
            i.b().g(this.f67464f, 50);
        } else {
            i.b().g(this.f67465g, 50);
        }
    }

    public void uh(boolean z11) {
    }

    public boolean vh() {
        if (getParentFragment() == null) {
            return isHidden();
        }
        if (getParentFragment() instanceof LazyLoadFragment) {
            if (((LazyLoadFragment) getParentFragment()).vh() || isHidden()) {
                return true;
            }
            return false;
        } else if (!isHidden() || !getParentFragment().isHidden()) {
            return false;
        } else {
            return true;
        }
    }

    public final void wh(boolean z11) {
        if (this.f67463e != z11) {
            this.f67463e = z11;
            th(z11);
        }
    }
}
