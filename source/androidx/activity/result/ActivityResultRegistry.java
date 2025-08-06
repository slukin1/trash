package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.r;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.random.Random;

public abstract class ActivityResultRegistry {

    /* renamed from: a  reason: collision with root package name */
    public final Map<Integer, String> f3687a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, Integer> f3688b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, e> f3689c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<String> f3690d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public final transient Map<String, d<?>> f3691e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, Object> f3692f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    public final Bundle f3693g = new Bundle();

    public class a implements r {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f3694b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ActivityResultCallback f3695c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ActivityResultContract f3696d;

        public a(String str, ActivityResultCallback activityResultCallback, ActivityResultContract activityResultContract) {
            this.f3694b = str;
            this.f3695c = activityResultCallback;
            this.f3696d = activityResultContract;
        }

        public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            if (Lifecycle.Event.ON_START.equals(event)) {
                ActivityResultRegistry.this.f3691e.put(this.f3694b, new d(this.f3695c, this.f3696d));
                if (ActivityResultRegistry.this.f3692f.containsKey(this.f3694b)) {
                    Object obj = ActivityResultRegistry.this.f3692f.get(this.f3694b);
                    ActivityResultRegistry.this.f3692f.remove(this.f3694b);
                    this.f3695c.onActivityResult(obj);
                }
                ActivityResult activityResult = (ActivityResult) ActivityResultRegistry.this.f3693g.getParcelable(this.f3694b);
                if (activityResult != null) {
                    ActivityResultRegistry.this.f3693g.remove(this.f3694b);
                    this.f3695c.onActivityResult(this.f3696d.parseResult(activityResult.getResultCode(), activityResult.getData()));
                }
            } else if (Lifecycle.Event.ON_STOP.equals(event)) {
                ActivityResultRegistry.this.f3691e.remove(this.f3694b);
            } else if (Lifecycle.Event.ON_DESTROY.equals(event)) {
                ActivityResultRegistry.this.l(this.f3694b);
            }
        }
    }

    public class b extends ActivityResultLauncher<I> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f3698a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ActivityResultContract f3699b;

        public b(String str, ActivityResultContract activityResultContract) {
            this.f3698a = str;
            this.f3699b = activityResultContract;
        }

        public void b(I i11, p0.c cVar) {
            Integer num = ActivityResultRegistry.this.f3688b.get(this.f3698a);
            if (num != null) {
                ActivityResultRegistry.this.f3690d.add(this.f3698a);
                try {
                    ActivityResultRegistry.this.f(num.intValue(), this.f3699b, i11, cVar);
                } catch (Exception e11) {
                    ActivityResultRegistry.this.f3690d.remove(this.f3698a);
                    throw e11;
                }
            } else {
                throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.f3699b + " and input " + i11 + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
            }
        }

        public void c() {
            ActivityResultRegistry.this.l(this.f3698a);
        }
    }

    public class c extends ActivityResultLauncher<I> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f3701a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ActivityResultContract f3702b;

        public c(String str, ActivityResultContract activityResultContract) {
            this.f3701a = str;
            this.f3702b = activityResultContract;
        }

        public void b(I i11, p0.c cVar) {
            Integer num = ActivityResultRegistry.this.f3688b.get(this.f3701a);
            if (num != null) {
                ActivityResultRegistry.this.f3690d.add(this.f3701a);
                try {
                    ActivityResultRegistry.this.f(num.intValue(), this.f3702b, i11, cVar);
                } catch (Exception e11) {
                    ActivityResultRegistry.this.f3690d.remove(this.f3701a);
                    throw e11;
                }
            } else {
                throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.f3702b + " and input " + i11 + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
            }
        }

        public void c() {
            ActivityResultRegistry.this.l(this.f3701a);
        }
    }

    public static class d<O> {

        /* renamed from: a  reason: collision with root package name */
        public final ActivityResultCallback<O> f3704a;

        /* renamed from: b  reason: collision with root package name */
        public final ActivityResultContract<?, O> f3705b;

        public d(ActivityResultCallback<O> activityResultCallback, ActivityResultContract<?, O> activityResultContract) {
            this.f3704a = activityResultCallback;
            this.f3705b = activityResultContract;
        }
    }

    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public final Lifecycle f3706a;

        /* renamed from: b  reason: collision with root package name */
        public final ArrayList<r> f3707b = new ArrayList<>();

        public e(Lifecycle lifecycle) {
            this.f3706a = lifecycle;
        }

        public void a(r rVar) {
            this.f3706a.a(rVar);
            this.f3707b.add(rVar);
        }

        public void b() {
            Iterator<r> it2 = this.f3707b.iterator();
            while (it2.hasNext()) {
                this.f3706a.d(it2.next());
            }
            this.f3707b.clear();
        }
    }

    public final void a(int i11, String str) {
        this.f3687a.put(Integer.valueOf(i11), str);
        this.f3688b.put(str, Integer.valueOf(i11));
    }

    public final boolean b(int i11, int i12, Intent intent) {
        String str = this.f3687a.get(Integer.valueOf(i11));
        if (str == null) {
            return false;
        }
        d(str, i12, intent, this.f3691e.get(str));
        return true;
    }

    public final <O> boolean c(int i11, @SuppressLint({"UnknownNullness"}) O o11) {
        ActivityResultCallback<O> activityResultCallback;
        String str = this.f3687a.get(Integer.valueOf(i11));
        if (str == null) {
            return false;
        }
        d dVar = this.f3691e.get(str);
        if (dVar == null || (activityResultCallback = dVar.f3704a) == null) {
            this.f3693g.remove(str);
            this.f3692f.put(str, o11);
            return true;
        } else if (!this.f3690d.remove(str)) {
            return true;
        } else {
            activityResultCallback.onActivityResult(o11);
            return true;
        }
    }

    public final <O> void d(String str, int i11, Intent intent, d<O> dVar) {
        if (dVar == null || dVar.f3704a == null || !this.f3690d.contains(str)) {
            this.f3692f.remove(str);
            this.f3693g.putParcelable(str, new ActivityResult(i11, intent));
            return;
        }
        dVar.f3704a.onActivityResult(dVar.f3705b.parseResult(i11, intent));
        this.f3690d.remove(str);
    }

    public final int e() {
        int nextInt = Random.Default.nextInt(2147418112);
        while (true) {
            int i11 = nextInt + 65536;
            if (!this.f3687a.containsKey(Integer.valueOf(i11))) {
                return i11;
            }
            nextInt = Random.Default.nextInt(2147418112);
        }
    }

    public abstract <I, O> void f(int i11, ActivityResultContract<I, O> activityResultContract, @SuppressLint({"UnknownNullness"}) I i12, p0.c cVar);

    public final void g(Bundle bundle) {
        if (bundle != null) {
            ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
            ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
            if (stringArrayList != null && integerArrayList != null) {
                this.f3690d = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
                this.f3693g.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
                for (int i11 = 0; i11 < stringArrayList.size(); i11++) {
                    String str = stringArrayList.get(i11);
                    if (this.f3688b.containsKey(str)) {
                        Integer remove = this.f3688b.remove(str);
                        if (!this.f3693g.containsKey(str)) {
                            this.f3687a.remove(remove);
                        }
                    }
                    a(integerArrayList.get(i11).intValue(), stringArrayList.get(i11));
                }
            }
        }
    }

    public final void h(Bundle bundle) {
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList(this.f3688b.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList(this.f3688b.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList(this.f3690d));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) this.f3693g.clone());
    }

    public final <I, O> ActivityResultLauncher<I> i(String str, ActivityResultContract<I, O> activityResultContract, ActivityResultCallback<O> activityResultCallback) {
        k(str);
        this.f3691e.put(str, new d(activityResultCallback, activityResultContract));
        if (this.f3692f.containsKey(str)) {
            Object obj = this.f3692f.get(str);
            this.f3692f.remove(str);
            activityResultCallback.onActivityResult(obj);
        }
        ActivityResult activityResult = (ActivityResult) this.f3693g.getParcelable(str);
        if (activityResult != null) {
            this.f3693g.remove(str);
            activityResultCallback.onActivityResult(activityResultContract.parseResult(activityResult.getResultCode(), activityResult.getData()));
        }
        return new c(str, activityResultContract);
    }

    public final <I, O> ActivityResultLauncher<I> j(String str, LifecycleOwner lifecycleOwner, ActivityResultContract<I, O> activityResultContract, ActivityResultCallback<O> activityResultCallback) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (!lifecycle.b().isAtLeast(Lifecycle.State.STARTED)) {
            k(str);
            e eVar = this.f3689c.get(str);
            if (eVar == null) {
                eVar = new e(lifecycle);
            }
            eVar.a(new a(str, activityResultCallback, activityResultContract));
            this.f3689c.put(str, eVar);
            return new b(str, activityResultContract);
        }
        throw new IllegalStateException("LifecycleOwner " + lifecycleOwner + " is attempting to register while current state is " + lifecycle.b() + ". LifecycleOwners must call register before they are STARTED.");
    }

    public final void k(String str) {
        if (this.f3688b.get(str) == null) {
            a(e(), str);
        }
    }

    public final void l(String str) {
        Integer remove;
        if (!this.f3690d.contains(str) && (remove = this.f3688b.remove(str)) != null) {
            this.f3687a.remove(remove);
        }
        this.f3691e.remove(str);
        if (this.f3692f.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + l.f34627b + this.f3692f.get(str));
            this.f3692f.remove(str);
        }
        if (this.f3693g.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + l.f34627b + this.f3693g.getParcelable(str));
            this.f3693g.remove(str);
        }
        e eVar = this.f3689c.get(str);
        if (eVar != null) {
            eVar.b();
            this.f3689c.remove(str);
        }
    }
}
