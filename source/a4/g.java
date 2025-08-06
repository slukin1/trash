package a4;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.d;
import com.bumptech.glide.manager.RequestManagerFragment;
import com.bumptech.glide.manager.SupportRequestManagerFragment;
import f4.h;
import f4.i;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class g implements Handler.Callback {

    /* renamed from: j  reason: collision with root package name */
    public static final b f63120j = new a();

    /* renamed from: b  reason: collision with root package name */
    public volatile d f63121b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<FragmentManager, RequestManagerFragment> f63122c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public final Map<androidx.fragment.app.FragmentManager, SupportRequestManagerFragment> f63123d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public final Handler f63124e;

    /* renamed from: f  reason: collision with root package name */
    public final b f63125f;

    /* renamed from: g  reason: collision with root package name */
    public final ArrayMap<View, Fragment> f63126g = new ArrayMap<>();

    /* renamed from: h  reason: collision with root package name */
    public final ArrayMap<View, android.app.Fragment> f63127h = new ArrayMap<>();

    /* renamed from: i  reason: collision with root package name */
    public final Bundle f63128i = new Bundle();

    public class a implements b {
        public d a(com.bumptech.glide.a aVar, d dVar, h hVar, Context context) {
            return new d(aVar, dVar, hVar, context);
        }
    }

    public interface b {
        d a(com.bumptech.glide.a aVar, d dVar, h hVar, Context context);
    }

    public g(b bVar) {
        this.f63125f = bVar == null ? f63120j : bVar;
        this.f63124e = new Handler(Looper.getMainLooper(), this);
    }

    @TargetApi(17)
    public static void a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    public static Activity b(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return b(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static void e(Collection<Fragment> collection, Map<View, Fragment> map) {
        if (collection != null) {
            for (Fragment next : collection) {
                if (!(next == null || next.getView() == null)) {
                    map.put(next.getView(), next);
                    e(next.getChildFragmentManager().B0(), map);
                }
            }
        }
    }

    public static boolean t(Context context) {
        Activity b11 = b(context);
        return b11 == null || !b11.isFinishing();
    }

    @TargetApi(26)
    @Deprecated
    public final void c(FragmentManager fragmentManager, ArrayMap<View, android.app.Fragment> arrayMap) {
        if (Build.VERSION.SDK_INT >= 26) {
            for (android.app.Fragment next : fragmentManager.getFragments()) {
                if (next.getView() != null) {
                    arrayMap.put(next.getView(), next);
                    c(next.getChildFragmentManager(), arrayMap);
                }
            }
            return;
        }
        d(fragmentManager, arrayMap);
    }

    @Deprecated
    public final void d(FragmentManager fragmentManager, ArrayMap<View, android.app.Fragment> arrayMap) {
        int i11 = 0;
        while (true) {
            int i12 = i11 + 1;
            this.f63128i.putInt("key", i11);
            android.app.Fragment fragment = null;
            try {
                fragment = fragmentManager.getFragment(this.f63128i, "key");
            } catch (Exception unused) {
            }
            if (fragment != null) {
                if (fragment.getView() != null) {
                    arrayMap.put(fragment.getView(), fragment);
                    if (Build.VERSION.SDK_INT >= 17) {
                        c(fragment.getChildFragmentManager(), arrayMap);
                    }
                }
                i11 = i12;
            } else {
                return;
            }
        }
    }

    @Deprecated
    public final android.app.Fragment f(View view, Activity activity) {
        this.f63127h.clear();
        c(activity.getFragmentManager(), this.f63127h);
        View findViewById = activity.findViewById(16908290);
        android.app.Fragment fragment = null;
        while (!view.equals(findViewById) && (fragment = this.f63127h.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.f63127h.clear();
        return fragment;
    }

    public final Fragment g(View view, FragmentActivity fragmentActivity) {
        this.f63126g.clear();
        e(fragmentActivity.getSupportFragmentManager().B0(), this.f63126g);
        View findViewById = fragmentActivity.findViewById(16908290);
        Fragment fragment = null;
        while (!view.equals(findViewById) && (fragment = this.f63126g.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.f63126g.clear();
        return fragment;
    }

    @Deprecated
    public final d h(Context context, FragmentManager fragmentManager, android.app.Fragment fragment, boolean z11) {
        RequestManagerFragment q11 = q(fragmentManager, fragment, z11);
        d e11 = q11.e();
        if (e11 != null) {
            return e11;
        }
        d a11 = this.f63125f.a(com.bumptech.glide.a.d(context), q11.c(), q11.f(), context);
        q11.k(a11);
        return a11;
    }

    public boolean handleMessage(Message message) {
        Object obj;
        Object obj2;
        Object obj3;
        int i11 = message.what;
        Object obj4 = null;
        boolean z11 = true;
        if (i11 == 1) {
            obj3 = (FragmentManager) message.obj;
            obj2 = this.f63122c.remove(obj3);
        } else if (i11 != 2) {
            z11 = false;
            obj = null;
            if (z11 && obj4 == null && Log.isLoggable("RMRetriever", 5)) {
                Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj);
            }
            return z11;
        } else {
            obj3 = (androidx.fragment.app.FragmentManager) message.obj;
            obj2 = this.f63123d.remove(obj3);
        }
        Object obj5 = obj3;
        obj4 = obj2;
        obj = obj5;
        Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj);
        return z11;
    }

    public d i(Activity activity) {
        if (i.q()) {
            return k(activity.getApplicationContext());
        }
        a(activity);
        return h(activity, activity.getFragmentManager(), (android.app.Fragment) null, t(activity));
    }

    @TargetApi(17)
    @Deprecated
    public d j(android.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
        } else if (i.q() || Build.VERSION.SDK_INT < 17) {
            return k(fragment.getActivity().getApplicationContext());
        } else {
            return h(fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
        }
    }

    public d k(Context context) {
        if (context != null) {
            if (i.r() && !(context instanceof Application)) {
                if (context instanceof FragmentActivity) {
                    return n((FragmentActivity) context);
                }
                if (context instanceof Activity) {
                    return i((Activity) context);
                }
                if (context instanceof ContextWrapper) {
                    ContextWrapper contextWrapper = (ContextWrapper) context;
                    if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                        return k(contextWrapper.getBaseContext());
                    }
                }
            }
            return o(context);
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    public d l(View view) {
        if (i.q()) {
            return k(view.getContext().getApplicationContext());
        }
        h.d(view);
        h.e(view.getContext(), "Unable to obtain a request manager for a view without a Context");
        Activity b11 = b(view.getContext());
        if (b11 == null) {
            return k(view.getContext().getApplicationContext());
        }
        if (b11 instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) b11;
            Fragment g11 = g(view, fragmentActivity);
            return g11 != null ? m(g11) : n(fragmentActivity);
        }
        android.app.Fragment f11 = f(view, b11);
        if (f11 == null) {
            return i(b11);
        }
        return j(f11);
    }

    public d m(Fragment fragment) {
        h.e(fragment.getContext(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (i.q()) {
            return k(fragment.getContext().getApplicationContext());
        }
        return u(fragment.getContext(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }

    public d n(FragmentActivity fragmentActivity) {
        if (i.q()) {
            return k(fragmentActivity.getApplicationContext());
        }
        a(fragmentActivity);
        return u(fragmentActivity, fragmentActivity.getSupportFragmentManager(), (Fragment) null, t(fragmentActivity));
    }

    public final d o(Context context) {
        if (this.f63121b == null) {
            synchronized (this) {
                if (this.f63121b == null) {
                    this.f63121b = this.f63125f.a(com.bumptech.glide.a.d(context.getApplicationContext()), new b(), new c(), context.getApplicationContext());
                }
            }
        }
        return this.f63121b;
    }

    @Deprecated
    public RequestManagerFragment p(Activity activity) {
        return q(activity.getFragmentManager(), (android.app.Fragment) null, t(activity));
    }

    public final RequestManagerFragment q(FragmentManager fragmentManager, android.app.Fragment fragment, boolean z11) {
        RequestManagerFragment requestManagerFragment = (RequestManagerFragment) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (requestManagerFragment == null && (requestManagerFragment = this.f63122c.get(fragmentManager)) == null) {
            requestManagerFragment = new RequestManagerFragment();
            requestManagerFragment.j(fragment);
            if (z11) {
                requestManagerFragment.c().d();
            }
            this.f63122c.put(fragmentManager, requestManagerFragment);
            fragmentManager.beginTransaction().add(requestManagerFragment, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.f63124e.obtainMessage(1, fragmentManager).sendToTarget();
        }
        return requestManagerFragment;
    }

    public SupportRequestManagerFragment r(Context context, androidx.fragment.app.FragmentManager fragmentManager) {
        return s(fragmentManager, (Fragment) null, t(context));
    }

    public final SupportRequestManagerFragment s(androidx.fragment.app.FragmentManager fragmentManager, Fragment fragment, boolean z11) {
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) fragmentManager.m0("com.bumptech.glide.manager");
        if (supportRequestManagerFragment == null && (supportRequestManagerFragment = this.f63123d.get(fragmentManager)) == null) {
            supportRequestManagerFragment = new SupportRequestManagerFragment();
            supportRequestManagerFragment.zh(fragment);
            if (z11) {
                supportRequestManagerFragment.rh().d();
            }
            this.f63123d.put(fragmentManager, supportRequestManagerFragment);
            fragmentManager.q().e(supportRequestManagerFragment, "com.bumptech.glide.manager").k();
            this.f63124e.obtainMessage(2, fragmentManager).sendToTarget();
        }
        return supportRequestManagerFragment;
    }

    public final d u(Context context, androidx.fragment.app.FragmentManager fragmentManager, Fragment fragment, boolean z11) {
        SupportRequestManagerFragment s11 = s(fragmentManager, fragment, z11);
        d th2 = s11.th();
        if (th2 != null) {
            return th2;
        }
        d a11 = this.f63125f.a(com.bumptech.glide.a.d(context), s11.rh(), s11.uh(), context);
        s11.Ah(a11);
        return a11;
    }
}
