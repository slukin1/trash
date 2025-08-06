package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.util.Consumer;
import androidx.core.view.MenuProvider;
import androidx.fragment.R$id;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.q0;
import androidx.lifecycle.r;
import com.iproov.sdk.bridge.OptionsBridge;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class FragmentManager {
    public static boolean S = false;
    public FragmentFactory A = new d();
    public m0 B = null;
    public m0 C = new e();
    public ActivityResultLauncher<Intent> D;
    public ActivityResultLauncher<IntentSenderRequest> E;
    public ActivityResultLauncher<String[]> F;
    public ArrayDeque<LaunchedFragmentInfo> G = new ArrayDeque<>();
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public ArrayList<a> M;
    public ArrayList<Boolean> N;
    public ArrayList<Fragment> O;
    public z P;
    public FragmentStrictMode.Policy Q;
    public Runnable R = new f();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<n> f9560a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public boolean f9561b;

    /* renamed from: c  reason: collision with root package name */
    public final f0 f9562c = new f0();

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<a> f9563d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<Fragment> f9564e;

    /* renamed from: f  reason: collision with root package name */
    public final q f9565f = new q(this);

    /* renamed from: g  reason: collision with root package name */
    public OnBackPressedDispatcher f9566g;

    /* renamed from: h  reason: collision with root package name */
    public final androidx.activity.o f9567h = new b(false);

    /* renamed from: i  reason: collision with root package name */
    public final AtomicInteger f9568i = new AtomicInteger();

    /* renamed from: j  reason: collision with root package name */
    public final Map<String, BackStackState> f9569j = Collections.synchronizedMap(new HashMap());

    /* renamed from: k  reason: collision with root package name */
    public final Map<String, Bundle> f9570k = Collections.synchronizedMap(new HashMap());

    /* renamed from: l  reason: collision with root package name */
    public final Map<String, l> f9571l = Collections.synchronizedMap(new HashMap());

    /* renamed from: m  reason: collision with root package name */
    public ArrayList<m> f9572m;

    /* renamed from: n  reason: collision with root package name */
    public final r f9573n = new r(this);

    /* renamed from: o  reason: collision with root package name */
    public final CopyOnWriteArrayList<a0> f9574o = new CopyOnWriteArrayList<>();

    /* renamed from: p  reason: collision with root package name */
    public final Consumer<Configuration> f9575p = new s(this);

    /* renamed from: q  reason: collision with root package name */
    public final Consumer<Integer> f9576q = new v(this);

    /* renamed from: r  reason: collision with root package name */
    public final Consumer<p0.i> f9577r = new t(this);

    /* renamed from: s  reason: collision with root package name */
    public final Consumer<p0.p> f9578s = new u(this);

    /* renamed from: t  reason: collision with root package name */
    public final MenuProvider f9579t = new c();

    /* renamed from: u  reason: collision with root package name */
    public int f9580u = -1;

    /* renamed from: v  reason: collision with root package name */
    public FragmentHostCallback<?> f9581v;

    /* renamed from: w  reason: collision with root package name */
    public FragmentContainer f9582w;

    /* renamed from: x  reason: collision with root package name */
    public Fragment f9583x;

    /* renamed from: y  reason: collision with root package name */
    public Fragment f9584y;

    /* renamed from: z  reason: collision with root package name */
    public FragmentFactory f9585z = null;

    public static abstract class FragmentLifecycleCallbacks {
        @Deprecated
        public void onFragmentActivityCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
        }

        public void onFragmentCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentDestroyed(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentDetached(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentPaused(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentPreAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
        }

        public void onFragmentPreCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentResumed(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentSaveInstanceState(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentStarted(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentStopped(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentViewCreated(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
        }

        public void onFragmentViewDestroyed(FragmentManager fragmentManager, Fragment fragment) {
        }
    }

    public class a implements ActivityResultCallback<Map<String, Boolean>> {
        public a() {
        }

        @SuppressLint({"SyntheticAccessor"})
        /* renamed from: a */
        public void onActivityResult(Map<String, Boolean> map) {
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map.values());
            int[] iArr = new int[arrayList.size()];
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                iArr[i11] = ((Boolean) arrayList.get(i11)).booleanValue() ? 0 : -1;
            }
            LaunchedFragmentInfo pollFirst = FragmentManager.this.G.pollFirst();
            if (pollFirst == null) {
                Log.w("FragmentManager", "No permissions were requested for " + this);
                return;
            }
            String str = pollFirst.mWho;
            int i12 = pollFirst.mRequestCode;
            Fragment i13 = FragmentManager.this.f9562c.i(str);
            if (i13 == null) {
                Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str);
                return;
            }
            i13.onRequestPermissionsResult(i12, strArr, iArr);
        }
    }

    public class b extends androidx.activity.o {
        public b(boolean z11) {
            super(z11);
        }

        public void handleOnBackPressed() {
            FragmentManager.this.L0();
        }
    }

    public class c implements MenuProvider {
        public c() {
        }

        public void a(Menu menu, MenuInflater menuInflater) {
            FragmentManager.this.G(menu, menuInflater);
        }

        public void b(Menu menu) {
            FragmentManager.this.O(menu);
        }

        public void c(Menu menu) {
            FragmentManager.this.S(menu);
        }

        public boolean d(MenuItem menuItem) {
            return FragmentManager.this.N(menuItem);
        }
    }

    public class d extends FragmentFactory {
        public d() {
        }

        public Fragment a(ClassLoader classLoader, String str) {
            return FragmentManager.this.C0().b(FragmentManager.this.C0().f(), str, (Bundle) null);
        }
    }

    public class e implements m0 {
        public e() {
        }

        public SpecialEffectsController a(ViewGroup viewGroup) {
            return new DefaultSpecialEffectsController(viewGroup);
        }
    }

    public class f implements Runnable {
        public f() {
        }

        public void run() {
            FragmentManager.this.e0(true);
        }
    }

    public class g implements r {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f9592b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c0 f9593c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Lifecycle f9594d;

        public g(String str, c0 c0Var, Lifecycle lifecycle) {
            this.f9592b = str;
            this.f9593c = c0Var;
            this.f9594d = lifecycle;
        }

        public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            Bundle bundle;
            if (event == Lifecycle.Event.ON_START && (bundle = (Bundle) FragmentManager.this.f9570k.get(this.f9592b)) != null) {
                this.f9593c.a(this.f9592b, bundle);
                FragmentManager.this.v(this.f9592b);
            }
            if (event == Lifecycle.Event.ON_DESTROY) {
                this.f9594d.d(this);
                FragmentManager.this.f9571l.remove(this.f9592b);
            }
        }
    }

    public class h implements a0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Fragment f9596b;

        public h(Fragment fragment) {
            this.f9596b = fragment;
        }

        public void a(FragmentManager fragmentManager, Fragment fragment) {
            this.f9596b.onAttachFragment(fragment);
        }
    }

    public class i implements ActivityResultCallback<ActivityResult> {
        public i() {
        }

        /* renamed from: a */
        public void onActivityResult(ActivityResult activityResult) {
            LaunchedFragmentInfo pollLast = FragmentManager.this.G.pollLast();
            if (pollLast == null) {
                Log.w("FragmentManager", "No Activities were started for result for " + this);
                return;
            }
            String str = pollLast.mWho;
            int i11 = pollLast.mRequestCode;
            Fragment i12 = FragmentManager.this.f9562c.i(str);
            if (i12 == null) {
                Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
                return;
            }
            i12.onActivityResult(i11, activityResult.getResultCode(), activityResult.getData());
        }
    }

    public class j implements ActivityResultCallback<ActivityResult> {
        public j() {
        }

        /* renamed from: a */
        public void onActivityResult(ActivityResult activityResult) {
            LaunchedFragmentInfo pollFirst = FragmentManager.this.G.pollFirst();
            if (pollFirst == null) {
                Log.w("FragmentManager", "No IntentSenders were started for " + this);
                return;
            }
            String str = pollFirst.mWho;
            int i11 = pollFirst.mRequestCode;
            Fragment i12 = FragmentManager.this.f9562c.i(str);
            if (i12 == null) {
                Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
                return;
            }
            i12.onActivityResult(i11, activityResult.getResultCode(), activityResult.getData());
        }
    }

    public static class k extends ActivityResultContract<IntentSenderRequest, ActivityResult> {
        /* renamed from: a */
        public Intent createIntent(Context context, IntentSenderRequest intentSenderRequest) {
            Bundle bundleExtra;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent fillInIntent = intentSenderRequest.getFillInIntent();
            if (!(fillInIntent == null || (bundleExtra = fillInIntent.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) == null)) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                fillInIntent.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (fillInIntent.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    intentSenderRequest = new IntentSenderRequest.a(intentSenderRequest.getIntentSender()).b((Intent) null).c(intentSenderRequest.getFlagsValues(), intentSenderRequest.getFlagsMask()).a();
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", intentSenderRequest);
            if (FragmentManager.P0(2)) {
                Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
            }
            return intent;
        }

        /* renamed from: b */
        public ActivityResult parseResult(int i11, Intent intent) {
            return new ActivityResult(i11, intent);
        }
    }

    public static class l implements c0 {

        /* renamed from: a  reason: collision with root package name */
        public final Lifecycle f9600a;

        /* renamed from: b  reason: collision with root package name */
        public final c0 f9601b;

        /* renamed from: c  reason: collision with root package name */
        public final r f9602c;

        public l(Lifecycle lifecycle, c0 c0Var, r rVar) {
            this.f9600a = lifecycle;
            this.f9601b = c0Var;
            this.f9602c = rVar;
        }

        public void a(String str, Bundle bundle) {
            this.f9601b.a(str, bundle);
        }

        public boolean b(Lifecycle.State state) {
            return this.f9600a.b().isAtLeast(state);
        }

        public void c() {
            this.f9600a.d(this.f9602c);
        }
    }

    public interface m {
        void onBackStackChangeCommitted(Fragment fragment, boolean z11);

        void onBackStackChangeStarted(Fragment fragment, boolean z11);

        void onBackStackChanged();
    }

    public interface n {
        boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2);
    }

    public class o implements n {

        /* renamed from: a  reason: collision with root package name */
        public final String f9603a;

        /* renamed from: b  reason: collision with root package name */
        public final int f9604b;

        /* renamed from: c  reason: collision with root package name */
        public final int f9605c;

        public o(String str, int i11, int i12) {
            this.f9603a = str;
            this.f9604b = i11;
            this.f9605c = i12;
        }

        public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
            Fragment fragment = FragmentManager.this.f9584y;
            if (fragment != null && this.f9604b < 0 && this.f9603a == null && fragment.getChildFragmentManager().m1()) {
                return false;
            }
            return FragmentManager.this.p1(arrayList, arrayList2, this.f9603a, this.f9604b, this.f9605c);
        }
    }

    public class p implements n {

        /* renamed from: a  reason: collision with root package name */
        public final String f9607a;

        public p(String str) {
            this.f9607a = str;
        }

        public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
            return FragmentManager.this.x1(arrayList, arrayList2, this.f9607a);
        }
    }

    public class q implements n {

        /* renamed from: a  reason: collision with root package name */
        public final String f9609a;

        public q(String str) {
            this.f9609a = str;
        }

        public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
            return FragmentManager.this.C1(arrayList, arrayList2, this.f9609a);
        }
    }

    public static Fragment J0(View view) {
        Object tag = view.getTag(R$id.fragment_container_view_tag);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    public static boolean P0(int i11) {
        return S || Log.isLoggable("FragmentManager", i11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Y0(Configuration configuration) {
        if (R0()) {
            D(configuration, false);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Z0(Integer num) {
        if (R0() && num.intValue() == 80) {
            J(false);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a1(p0.i iVar) {
        if (R0()) {
            K(iVar.a(), false);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b1(p0.p pVar) {
        if (R0()) {
            R(pVar.a(), false);
        }
    }

    public static void g0(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i11, int i12) {
        while (i11 < i12) {
            a aVar = arrayList.get(i11);
            if (arrayList2.get(i11).booleanValue()) {
                aVar.B(-1);
                aVar.H();
            } else {
                aVar.B(1);
                aVar.G();
            }
            i11++;
        }
    }

    public static FragmentManager o0(View view) {
        Fragment p02 = p0(view);
        if (p02 == null) {
            Context context = view.getContext();
            FragmentActivity fragmentActivity = null;
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    break;
                } else if (context instanceof FragmentActivity) {
                    fragmentActivity = (FragmentActivity) context;
                    break;
                } else {
                    context = ((ContextWrapper) context).getBaseContext();
                }
            }
            if (fragmentActivity != null) {
                return fragmentActivity.getSupportFragmentManager();
            }
            throw new IllegalStateException("View " + view + " is not within a subclass of FragmentActivity.");
        } else if (p02.isAdded()) {
            return p02.getChildFragmentManager();
        } else {
            throw new IllegalStateException("The Fragment " + p02 + " that owns View " + view + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
        }
    }

    public static Fragment p0(View view) {
        while (view != null) {
            Fragment J0 = J0(view);
            if (J0 != null) {
                return J0;
            }
            ViewParent parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    public static int z1(int i11) {
        if (i11 == 4097) {
            return 8194;
        }
        if (i11 == 8194) {
            return 4097;
        }
        if (i11 == 8197) {
            return 4100;
        }
        if (i11 != 4099) {
            return i11 != 4100 ? 0 : 8197;
        }
        return 4099;
    }

    public void A(Fragment fragment) {
        if (P0(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (P0(2)) {
                    Log.v("FragmentManager", "remove from detach: " + fragment);
                }
                this.f9562c.u(fragment);
                if (Q0(fragment)) {
                    this.H = true;
                }
                K1(fragment);
            }
        }
    }

    public f0 A0() {
        return this.f9562c;
    }

    /* renamed from: A1 */
    public Bundle X0() {
        int size;
        Bundle bundle = new Bundle();
        q0();
        b0();
        e0(true);
        this.I = true;
        this.P.l0(true);
        ArrayList<String> y11 = this.f9562c.y();
        HashMap<String, Bundle> m11 = this.f9562c.m();
        if (!m11.isEmpty()) {
            ArrayList<String> z11 = this.f9562c.z();
            BackStackRecordState[] backStackRecordStateArr = null;
            ArrayList<a> arrayList = this.f9563d;
            if (arrayList != null && (size = arrayList.size()) > 0) {
                backStackRecordStateArr = new BackStackRecordState[size];
                for (int i11 = 0; i11 < size; i11++) {
                    backStackRecordStateArr[i11] = new BackStackRecordState(this.f9563d.get(i11));
                    if (P0(2)) {
                        Log.v("FragmentManager", "saveAllState: adding back stack #" + i11 + com.sumsub.sns.internal.fingerprint.infoproviders.l.f34627b + this.f9563d.get(i11));
                    }
                }
            }
            FragmentManagerState fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.mActive = y11;
            fragmentManagerState.mAdded = z11;
            fragmentManagerState.mBackStack = backStackRecordStateArr;
            fragmentManagerState.mBackStackIndex = this.f9568i.get();
            Fragment fragment = this.f9584y;
            if (fragment != null) {
                fragmentManagerState.mPrimaryNavActiveWho = fragment.mWho;
            }
            fragmentManagerState.mBackStackStateKeys.addAll(this.f9569j.keySet());
            fragmentManagerState.mBackStackStates.addAll(this.f9569j.values());
            fragmentManagerState.mLaunchedFragments = new ArrayList<>(this.G);
            bundle.putParcelable("state", fragmentManagerState);
            for (String next : this.f9570k.keySet()) {
                bundle.putBundle("result_" + next, this.f9570k.get(next));
            }
            for (String next2 : m11.keySet()) {
                bundle.putBundle("fragment_" + next2, m11.get(next2));
            }
        } else if (P0(2)) {
            Log.v("FragmentManager", "saveAllState: no fragments!");
        }
        return bundle;
    }

    public void B() {
        this.I = false;
        this.J = false;
        this.P.l0(false);
        W(4);
    }

    public List<Fragment> B0() {
        return this.f9562c.o();
    }

    public void B1(String str) {
        c0(new q(str), false);
    }

    public void C() {
        this.I = false;
        this.J = false;
        this.P.l0(false);
        W(0);
    }

    public FragmentHostCallback<?> C0() {
        return this.f9581v;
    }

    public boolean C1(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, String str) {
        String str2;
        int i11;
        String str3 = str;
        int k02 = k0(str3, -1, true);
        if (k02 < 0) {
            return false;
        }
        for (int i12 = k02; i12 < this.f9563d.size(); i12++) {
            a aVar = this.f9563d.get(i12);
            if (!aVar.f9639r) {
                N1(new IllegalArgumentException("saveBackStack(\"" + str3 + "\") included FragmentTransactions must use setReorderingAllowed(true) to ensure that the back stack can be restored as an atomic operation. Found " + aVar + " that did not use setReorderingAllowed(true)."));
            }
        }
        HashSet hashSet = new HashSet();
        for (int i13 = k02; i13 < this.f9563d.size(); i13++) {
            a aVar2 = this.f9563d.get(i13);
            HashSet hashSet2 = new HashSet();
            HashSet hashSet3 = new HashSet();
            Iterator<FragmentTransaction.a> it2 = aVar2.f9624c.iterator();
            while (it2.hasNext()) {
                FragmentTransaction.a next = it2.next();
                Fragment fragment = next.f9642b;
                if (fragment != null) {
                    if (!next.f9643c || (i11 = next.f9641a) == 1 || i11 == 2 || i11 == 8) {
                        hashSet.add(fragment);
                        hashSet2.add(fragment);
                    }
                    int i14 = next.f9641a;
                    if (i14 == 1 || i14 == 2) {
                        hashSet3.add(fragment);
                    }
                }
            }
            hashSet2.removeAll(hashSet3);
            if (!hashSet2.isEmpty()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("saveBackStack(\"");
                sb2.append(str3);
                sb2.append("\") must be self contained and not reference fragments from non-saved FragmentTransactions. Found reference to fragment");
                if (hashSet2.size() == 1) {
                    str2 = " " + hashSet2.iterator().next();
                } else {
                    str2 = "s " + hashSet2;
                }
                sb2.append(str2);
                sb2.append(" in ");
                sb2.append(aVar2);
                sb2.append(" that were previously added to the FragmentManager through a separate FragmentTransaction.");
                N1(new IllegalArgumentException(sb2.toString()));
            }
        }
        ArrayDeque arrayDeque = new ArrayDeque(hashSet);
        while (!arrayDeque.isEmpty()) {
            Fragment fragment2 = (Fragment) arrayDeque.removeFirst();
            if (fragment2.mRetainInstance) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("saveBackStack(\"");
                sb3.append(str3);
                sb3.append("\") must not contain retained fragments. Found ");
                sb3.append(hashSet.contains(fragment2) ? "direct reference to retained " : "retained child ");
                sb3.append("fragment ");
                sb3.append(fragment2);
                N1(new IllegalArgumentException(sb3.toString()));
            }
            for (Fragment next2 : fragment2.mChildFragmentManager.t0()) {
                if (next2 != null) {
                    arrayDeque.addLast(next2);
                }
            }
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it3 = hashSet.iterator();
        while (it3.hasNext()) {
            arrayList3.add(((Fragment) it3.next()).mWho);
        }
        ArrayList arrayList4 = new ArrayList(this.f9563d.size() - k02);
        for (int i15 = k02; i15 < this.f9563d.size(); i15++) {
            arrayList4.add((Object) null);
        }
        BackStackState backStackState = new BackStackState(arrayList3, arrayList4);
        for (int size = this.f9563d.size() - 1; size >= k02; size--) {
            a remove = this.f9563d.remove(size);
            a aVar3 = new a(remove);
            aVar3.C();
            arrayList4.set(size - k02, new BackStackRecordState(aVar3));
            remove.f9695w = true;
            arrayList.add(remove);
            arrayList2.add(Boolean.TRUE);
        }
        this.f9569j.put(str3, backStackState);
        return true;
    }

    public void D(Configuration configuration, boolean z11) {
        if (z11 && (this.f9581v instanceof q0.c)) {
            N1(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
        }
        for (Fragment next : this.f9562c.o()) {
            if (next != null) {
                next.performConfigurationChanged(configuration);
                if (z11) {
                    next.mChildFragmentManager.D(configuration, true);
                }
            }
        }
    }

    public LayoutInflater.Factory2 D0() {
        return this.f9565f;
    }

    public Fragment.SavedState D1(Fragment fragment) {
        d0 n11 = this.f9562c.n(fragment.mWho);
        if (n11 == null || !n11.k().equals(fragment)) {
            N1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        return n11.q();
    }

    public boolean E(MenuItem menuItem) {
        if (this.f9580u < 1) {
            return false;
        }
        for (Fragment next : this.f9562c.o()) {
            if (next != null && next.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public r E0() {
        return this.f9573n;
    }

    public void E1() {
        synchronized (this.f9560a) {
            boolean z11 = true;
            if (this.f9560a.size() != 1) {
                z11 = false;
            }
            if (z11) {
                this.f9581v.g().removeCallbacks(this.R);
                this.f9581v.g().post(this.R);
                P1();
            }
        }
    }

    public void F() {
        this.I = false;
        this.J = false;
        this.P.l0(false);
        W(1);
    }

    public Fragment F0() {
        return this.f9583x;
    }

    public void F1(Fragment fragment, boolean z11) {
        ViewGroup y02 = y0(fragment);
        if (y02 != null && (y02 instanceof FragmentContainerView)) {
            ((FragmentContainerView) y02).setDrawDisappearingViewsLast(!z11);
        }
    }

    public boolean G(Menu menu, MenuInflater menuInflater) {
        if (this.f9580u < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z11 = false;
        for (Fragment next : this.f9562c.o()) {
            if (next != null && T0(next) && next.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(next);
                z11 = true;
            }
        }
        if (this.f9564e != null) {
            for (int i11 = 0; i11 < this.f9564e.size(); i11++) {
                Fragment fragment = this.f9564e.get(i11);
                if (arrayList == null || !arrayList.contains(fragment)) {
                    fragment.onDestroyOptionsMenu();
                }
            }
        }
        this.f9564e = arrayList;
        return z11;
    }

    public Fragment G0() {
        return this.f9584y;
    }

    public final void G1(String str, Bundle bundle) {
        l lVar = this.f9571l.get(str);
        if (lVar == null || !lVar.b(Lifecycle.State.STARTED)) {
            this.f9570k.put(str, bundle);
        } else {
            lVar.a(str, bundle);
        }
        if (P0(2)) {
            Log.v("FragmentManager", "Setting fragment result with key " + str + " and result " + bundle);
        }
    }

    public void H() {
        this.K = true;
        e0(true);
        b0();
        u();
        W(-1);
        FragmentHostCallback<?> fragmentHostCallback = this.f9581v;
        if (fragmentHostCallback instanceof q0.d) {
            ((q0.d) fragmentHostCallback).removeOnTrimMemoryListener(this.f9576q);
        }
        FragmentHostCallback<?> fragmentHostCallback2 = this.f9581v;
        if (fragmentHostCallback2 instanceof q0.c) {
            ((q0.c) fragmentHostCallback2).removeOnConfigurationChangedListener(this.f9575p);
        }
        FragmentHostCallback<?> fragmentHostCallback3 = this.f9581v;
        if (fragmentHostCallback3 instanceof p0.n) {
            ((p0.n) fragmentHostCallback3).removeOnMultiWindowModeChangedListener(this.f9577r);
        }
        FragmentHostCallback<?> fragmentHostCallback4 = this.f9581v;
        if (fragmentHostCallback4 instanceof p0.o) {
            ((p0.o) fragmentHostCallback4).removeOnPictureInPictureModeChangedListener(this.f9578s);
        }
        FragmentHostCallback<?> fragmentHostCallback5 = this.f9581v;
        if ((fragmentHostCallback5 instanceof androidx.core.view.j) && this.f9583x == null) {
            ((androidx.core.view.j) fragmentHostCallback5).removeMenuProvider(this.f9579t);
        }
        this.f9581v = null;
        this.f9582w = null;
        this.f9583x = null;
        if (this.f9566g != null) {
            this.f9567h.remove();
            this.f9566g = null;
        }
        ActivityResultLauncher<Intent> activityResultLauncher = this.D;
        if (activityResultLauncher != null) {
            activityResultLauncher.c();
            this.E.c();
            this.F.c();
        }
    }

    public m0 H0() {
        m0 m0Var = this.B;
        if (m0Var != null) {
            return m0Var;
        }
        Fragment fragment = this.f9583x;
        if (fragment != null) {
            return fragment.mFragmentManager.H0();
        }
        return this.C;
    }

    @SuppressLint({"SyntheticAccessor"})
    public final void H1(String str, LifecycleOwner lifecycleOwner, c0 c0Var) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (lifecycle.b() != Lifecycle.State.DESTROYED) {
            g gVar = new g(str, c0Var, lifecycle);
            l put = this.f9571l.put(str, new l(lifecycle, c0Var, gVar));
            if (put != null) {
                put.c();
            }
            if (P0(2)) {
                Log.v("FragmentManager", "Setting FragmentResultListener with key " + str + " lifecycleOwner " + lifecycle + " and listener " + c0Var);
            }
            lifecycle.a(gVar);
        }
    }

    public void I() {
        W(1);
    }

    public FragmentStrictMode.Policy I0() {
        return this.Q;
    }

    public void I1(Fragment fragment, Lifecycle.State state) {
        if (!fragment.equals(j0(fragment.mWho)) || !(fragment.mHost == null || fragment.mFragmentManager == this)) {
            throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
        }
        fragment.mMaxState = state;
    }

    public void J(boolean z11) {
        if (z11 && (this.f9581v instanceof q0.d)) {
            N1(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
        }
        for (Fragment next : this.f9562c.o()) {
            if (next != null) {
                next.performLowMemory();
                if (z11) {
                    next.mChildFragmentManager.J(true);
                }
            }
        }
    }

    public void J1(Fragment fragment) {
        if (fragment == null || (fragment.equals(j0(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this))) {
            Fragment fragment2 = this.f9584y;
            this.f9584y = fragment;
            P(fragment2);
            P(this.f9584y);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public void K(boolean z11, boolean z12) {
        if (z12 && (this.f9581v instanceof p0.n)) {
            N1(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
        }
        for (Fragment next : this.f9562c.o()) {
            if (next != null) {
                next.performMultiWindowModeChanged(z11);
                if (z12) {
                    next.mChildFragmentManager.K(z11, true);
                }
            }
        }
    }

    public ViewModelStore K0(Fragment fragment) {
        return this.P.i0(fragment);
    }

    public final void K1(Fragment fragment) {
        ViewGroup y02 = y0(fragment);
        if (y02 != null && fragment.getEnterAnim() + fragment.getExitAnim() + fragment.getPopEnterAnim() + fragment.getPopExitAnim() > 0) {
            int i11 = R$id.visible_removing_fragment_view_tag;
            if (y02.getTag(i11) == null) {
                y02.setTag(i11, fragment);
            }
            ((Fragment) y02.getTag(i11)).setPopDirection(fragment.getPopDirection());
        }
    }

    public void L(Fragment fragment) {
        Iterator<a0> it2 = this.f9574o.iterator();
        while (it2.hasNext()) {
            it2.next().a(this, fragment);
        }
    }

    public void L0() {
        e0(true);
        if (this.f9567h.isEnabled()) {
            m1();
        } else {
            this.f9566g.l();
        }
    }

    public void L1(Fragment fragment) {
        if (P0(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    public void M() {
        for (Fragment next : this.f9562c.l()) {
            if (next != null) {
                next.onHiddenChanged(next.isHidden());
                next.mChildFragmentManager.M();
            }
        }
    }

    public void M0(Fragment fragment) {
        if (P0(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
            K1(fragment);
        }
    }

    public final void M1() {
        for (d0 i12 : this.f9562c.k()) {
            i1(i12);
        }
    }

    public boolean N(MenuItem menuItem) {
        if (this.f9580u < 1) {
            return false;
        }
        for (Fragment next : this.f9562c.o()) {
            if (next != null && next.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void N0(Fragment fragment) {
        if (fragment.mAdded && Q0(fragment)) {
            this.H = true;
        }
    }

    public final void N1(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new i0("FragmentManager"));
        FragmentHostCallback<?> fragmentHostCallback = this.f9581v;
        if (fragmentHostCallback != null) {
            try {
                fragmentHostCallback.h("  ", (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e11) {
                Log.e("FragmentManager", "Failed dumping state", e11);
            }
        } else {
            try {
                a0("  ", (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e12) {
                Log.e("FragmentManager", "Failed dumping state", e12);
            }
        }
        throw runtimeException;
    }

    public void O(Menu menu) {
        if (this.f9580u >= 1) {
            for (Fragment next : this.f9562c.o()) {
                if (next != null) {
                    next.performOptionsMenuClosed(menu);
                }
            }
        }
    }

    public boolean O0() {
        return this.K;
    }

    public void O1(FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
        this.f9573n.p(fragmentLifecycleCallbacks);
    }

    public final void P(Fragment fragment) {
        if (fragment != null && fragment.equals(j0(fragment.mWho))) {
            fragment.performPrimaryNavigationFragmentChanged();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        if (u0() <= 0) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        if (U0(r3.f9583x) == false) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
        r0.setEnabled(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0029, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        r0 = r3.f9567h;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void P1() {
        /*
            r3 = this;
            java.util.ArrayList<androidx.fragment.app.FragmentManager$n> r0 = r3.f9560a
            monitor-enter(r0)
            java.util.ArrayList<androidx.fragment.app.FragmentManager$n> r1 = r3.f9560a     // Catch:{ all -> 0x002a }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x002a }
            r2 = 1
            if (r1 != 0) goto L_0x0013
            androidx.activity.o r1 = r3.f9567h     // Catch:{ all -> 0x002a }
            r1.setEnabled(r2)     // Catch:{ all -> 0x002a }
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            return
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            androidx.activity.o r0 = r3.f9567h
            int r1 = r3.u0()
            if (r1 <= 0) goto L_0x0025
            androidx.fragment.app.Fragment r1 = r3.f9583x
            boolean r1 = r3.U0(r1)
            if (r1 == 0) goto L_0x0025
            goto L_0x0026
        L_0x0025:
            r2 = 0
        L_0x0026:
            r0.setEnabled(r2)
            return
        L_0x002a:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.P1():void");
    }

    public void Q() {
        W(5);
    }

    public final boolean Q0(Fragment fragment) {
        return (fragment.mHasMenu && fragment.mMenuVisible) || fragment.mChildFragmentManager.r();
    }

    public void R(boolean z11, boolean z12) {
        if (z12 && (this.f9581v instanceof p0.o)) {
            N1(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
        }
        for (Fragment next : this.f9562c.o()) {
            if (next != null) {
                next.performPictureInPictureModeChanged(z11);
                if (z12) {
                    next.mChildFragmentManager.R(z11, true);
                }
            }
        }
    }

    public final boolean R0() {
        Fragment fragment = this.f9583x;
        if (fragment == null) {
            return true;
        }
        if (!fragment.isAdded() || !this.f9583x.getParentFragmentManager().R0()) {
            return false;
        }
        return true;
    }

    public boolean S(Menu menu) {
        boolean z11 = false;
        if (this.f9580u < 1) {
            return false;
        }
        for (Fragment next : this.f9562c.o()) {
            if (next != null && T0(next) && next.performPrepareOptionsMenu(menu)) {
                z11 = true;
            }
        }
        return z11;
    }

    public boolean S0(Fragment fragment) {
        if (fragment == null) {
            return false;
        }
        return fragment.isHidden();
    }

    public void T() {
        P1();
        P(this.f9584y);
    }

    public boolean T0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.isMenuVisible();
    }

    public void U() {
        this.I = false;
        this.J = false;
        this.P.l0(false);
        W(7);
    }

    public boolean U0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (!fragment.equals(fragmentManager.G0()) || !U0(fragmentManager.f9583x)) {
            return false;
        }
        return true;
    }

    public void V() {
        this.I = false;
        this.J = false;
        this.P.l0(false);
        W(5);
    }

    public boolean V0(int i11) {
        return this.f9580u >= i11;
    }

    /* JADX INFO: finally extract failed */
    public final void W(int i11) {
        try {
            this.f9561b = true;
            this.f9562c.d(i11);
            f1(i11, false);
            for (SpecialEffectsController n11 : x()) {
                n11.n();
            }
            this.f9561b = false;
            e0(true);
        } catch (Throwable th2) {
            this.f9561b = false;
            throw th2;
        }
    }

    public boolean W0() {
        return this.I || this.J;
    }

    public void X() {
        this.J = true;
        this.P.l0(true);
        W(4);
    }

    public void Y() {
        W(2);
    }

    public final void Z() {
        if (this.L) {
            this.L = false;
            M1();
        }
    }

    public void a0(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        this.f9562c.e(str, fileDescriptor, printWriter, strArr);
        ArrayList<Fragment> arrayList = this.f9564e;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i11 = 0; i11 < size2; i11++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i11);
                printWriter.print(com.sumsub.sns.internal.fingerprint.infoproviders.l.f34627b);
                printWriter.println(this.f9564e.get(i11).toString());
            }
        }
        ArrayList<a> arrayList2 = this.f9563d;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i12 = 0; i12 < size; i12++) {
                a aVar = this.f9563d.get(i12);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i12);
                printWriter.print(com.sumsub.sns.internal.fingerprint.infoproviders.l.f34627b);
                printWriter.println(aVar.toString());
                aVar.E(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f9568i.get());
        synchronized (this.f9560a) {
            int size3 = this.f9560a.size();
            if (size3 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i13 = 0; i13 < size3; i13++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i13);
                    printWriter.print(com.sumsub.sns.internal.fingerprint.infoproviders.l.f34627b);
                    printWriter.println(this.f9560a.get(i13));
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f9581v);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f9582w);
        if (this.f9583x != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f9583x);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f9580u);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.I);
        printWriter.print(" mStopped=");
        printWriter.print(this.J);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.K);
        if (this.H) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.H);
        }
    }

    public final void b0() {
        for (SpecialEffectsController n11 : x()) {
            n11.n();
        }
    }

    public void c0(n nVar, boolean z11) {
        if (!z11) {
            if (this.f9581v != null) {
                s();
            } else if (this.K) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            } else {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
        }
        synchronized (this.f9560a) {
            if (this.f9581v != null) {
                this.f9560a.add(nVar);
                E1();
            } else if (!z11) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    public void c1(Fragment fragment, String[] strArr, int i11) {
        if (this.F != null) {
            this.G.addLast(new LaunchedFragmentInfo(fragment.mWho, i11));
            this.F.a(strArr);
            return;
        }
        this.f9581v.k(fragment, strArr, i11);
    }

    public final void d0(boolean z11) {
        if (this.f9561b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.f9581v == null) {
            if (this.K) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            throw new IllegalStateException("FragmentManager has not been attached to a host.");
        } else if (Looper.myLooper() == this.f9581v.g().getLooper()) {
            if (!z11) {
                s();
            }
            if (this.M == null) {
                this.M = new ArrayList<>();
                this.N = new ArrayList<>();
            }
        } else {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
    }

    public void d1(Fragment fragment, Intent intent, int i11, Bundle bundle) {
        if (this.D != null) {
            this.G.addLast(new LaunchedFragmentInfo(fragment.mWho, i11));
            if (bundle != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
            }
            this.D.a(intent);
            return;
        }
        this.f9581v.m(fragment, intent, i11, bundle);
    }

    /* JADX INFO: finally extract failed */
    public boolean e0(boolean z11) {
        d0(z11);
        boolean z12 = false;
        while (s0(this.M, this.N)) {
            this.f9561b = true;
            try {
                t1(this.M, this.N);
                t();
                z12 = true;
            } catch (Throwable th2) {
                t();
                throw th2;
            }
        }
        P1();
        Z();
        this.f9562c.b();
        return z12;
    }

    public void e1(Fragment fragment, IntentSender intentSender, int i11, Intent intent, int i12, int i13, int i14, Bundle bundle) throws IntentSender.SendIntentException {
        Intent intent2;
        Fragment fragment2 = fragment;
        Bundle bundle2 = bundle;
        if (this.E != null) {
            if (bundle2 != null) {
                if (intent == null) {
                    intent2 = new Intent();
                    intent2.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
                } else {
                    intent2 = intent;
                }
                if (P0(2)) {
                    Log.v("FragmentManager", "ActivityOptions " + bundle2 + " were added to fillInIntent " + intent2 + " for fragment " + fragment);
                }
                intent2.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle2);
            } else {
                intent2 = intent;
            }
            IntentSender intentSender2 = intentSender;
            IntentSenderRequest a11 = new IntentSenderRequest.a(intentSender).b(intent2).c(i13, i12).a();
            int i15 = i11;
            this.G.addLast(new LaunchedFragmentInfo(fragment2.mWho, i11));
            if (P0(2)) {
                Log.v("FragmentManager", "Fragment " + fragment + "is launching an IntentSender for result ");
            }
            this.E.a(a11);
            return;
        }
        IntentSender intentSender3 = intentSender;
        int i16 = i11;
        int i17 = i12;
        int i18 = i13;
        this.f9581v.n(fragment, intentSender, i11, intent, i12, i13, i14, bundle);
    }

    public void f0(n nVar, boolean z11) {
        if (!z11 || (this.f9581v != null && !this.K)) {
            d0(z11);
            if (nVar.a(this.M, this.N)) {
                this.f9561b = true;
                try {
                    t1(this.M, this.N);
                } finally {
                    t();
                }
            }
            P1();
            Z();
            this.f9562c.b();
        }
    }

    public void f1(int i11, boolean z11) {
        FragmentHostCallback<?> fragmentHostCallback;
        if (this.f9581v == null && i11 != -1) {
            throw new IllegalStateException("No activity");
        } else if (z11 || i11 != this.f9580u) {
            this.f9580u = i11;
            this.f9562c.t();
            M1();
            if (this.H && (fragmentHostCallback = this.f9581v) != null && this.f9580u == 7) {
                fragmentHostCallback.o();
                this.H = false;
            }
        }
    }

    public void g1() {
        if (this.f9581v != null) {
            this.I = false;
            this.J = false;
            this.P.l0(false);
            for (Fragment next : this.f9562c.o()) {
                if (next != null) {
                    next.noteStateNotSaved();
                }
            }
        }
    }

    public final void h0(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i11, int i12) {
        ArrayList<m> arrayList3;
        boolean z11 = arrayList.get(i11).f9639r;
        ArrayList<Fragment> arrayList4 = this.O;
        if (arrayList4 == null) {
            this.O = new ArrayList<>();
        } else {
            arrayList4.clear();
        }
        this.O.addAll(this.f9562c.o());
        Fragment G0 = G0();
        boolean z12 = false;
        for (int i13 = i11; i13 < i12; i13++) {
            a aVar = arrayList.get(i13);
            if (!arrayList2.get(i13).booleanValue()) {
                G0 = aVar.I(this.O, G0);
            } else {
                G0 = aVar.L(this.O, G0);
            }
            z12 = z12 || aVar.f9630i;
        }
        this.O.clear();
        if (!z11 && this.f9580u >= 1) {
            for (int i14 = i11; i14 < i12; i14++) {
                Iterator<FragmentTransaction.a> it2 = arrayList.get(i14).f9624c.iterator();
                while (it2.hasNext()) {
                    Fragment fragment = it2.next().f9642b;
                    if (!(fragment == null || fragment.mFragmentManager == null)) {
                        this.f9562c.r(z(fragment));
                    }
                }
            }
        }
        g0(arrayList, arrayList2, i11, i12);
        boolean booleanValue = arrayList2.get(i12 - 1).booleanValue();
        if (z12 && (arrayList3 = this.f9572m) != null && !arrayList3.isEmpty()) {
            LinkedHashSet<Fragment> linkedHashSet = new LinkedHashSet<>();
            Iterator<a> it3 = arrayList.iterator();
            while (it3.hasNext()) {
                linkedHashSet.addAll(r0(it3.next()));
            }
            Iterator<m> it4 = this.f9572m.iterator();
            while (it4.hasNext()) {
                m next = it4.next();
                for (Fragment onBackStackChangeStarted : linkedHashSet) {
                    next.onBackStackChangeStarted(onBackStackChangeStarted, booleanValue);
                }
            }
            Iterator<m> it5 = this.f9572m.iterator();
            while (it5.hasNext()) {
                m next2 = it5.next();
                for (Fragment onBackStackChangeCommitted : linkedHashSet) {
                    next2.onBackStackChangeCommitted(onBackStackChangeCommitted, booleanValue);
                }
            }
        }
        for (int i15 = i11; i15 < i12; i15++) {
            a aVar2 = arrayList.get(i15);
            if (booleanValue) {
                for (int size = aVar2.f9624c.size() - 1; size >= 0; size--) {
                    Fragment fragment2 = aVar2.f9624c.get(size).f9642b;
                    if (fragment2 != null) {
                        z(fragment2).m();
                    }
                }
            } else {
                Iterator<FragmentTransaction.a> it6 = aVar2.f9624c.iterator();
                while (it6.hasNext()) {
                    Fragment fragment3 = it6.next().f9642b;
                    if (fragment3 != null) {
                        z(fragment3).m();
                    }
                }
            }
        }
        f1(this.f9580u, true);
        for (SpecialEffectsController next3 : y(arrayList, i11, i12)) {
            next3.v(booleanValue);
            next3.t();
            next3.k();
        }
        while (i11 < i12) {
            a aVar3 = arrayList.get(i11);
            if (arrayList2.get(i11).booleanValue() && aVar3.f9694v >= 0) {
                aVar3.f9694v = -1;
            }
            aVar3.K();
            i11++;
        }
        if (z12) {
            v1();
        }
    }

    public void h1(FragmentContainerView fragmentContainerView) {
        View view;
        for (d0 next : this.f9562c.k()) {
            Fragment k11 = next.k();
            if (k11.mContainerId == fragmentContainerView.getId() && (view = k11.mView) != null && view.getParent() == null) {
                k11.mContainer = fragmentContainerView;
                next.b();
            }
        }
    }

    public void i(a aVar) {
        if (this.f9563d == null) {
            this.f9563d = new ArrayList<>();
        }
        this.f9563d.add(aVar);
    }

    public boolean i0() {
        boolean e02 = e0(true);
        q0();
        return e02;
    }

    public void i1(d0 d0Var) {
        Fragment k11 = d0Var.k();
        if (!k11.mDeferStart) {
            return;
        }
        if (this.f9561b) {
            this.L = true;
            return;
        }
        k11.mDeferStart = false;
        d0Var.m();
    }

    public d0 j(Fragment fragment) {
        String str = fragment.mPreviousWho;
        if (str != null) {
            FragmentStrictMode.h(fragment, str);
        }
        if (P0(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        d0 z11 = z(fragment);
        fragment.mFragmentManager = this;
        this.f9562c.r(z11);
        if (!fragment.mDetached) {
            this.f9562c.a(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (Q0(fragment)) {
                this.H = true;
            }
        }
        return z11;
    }

    public Fragment j0(String str) {
        return this.f9562c.f(str);
    }

    public void j1() {
        c0(new o((String) null, -1, 0), false);
    }

    public void k(a0 a0Var) {
        this.f9574o.add(a0Var);
    }

    public final int k0(String str, int i11, boolean z11) {
        ArrayList<a> arrayList = this.f9563d;
        if (arrayList == null || arrayList.isEmpty()) {
            return -1;
        }
        if (str != null || i11 >= 0) {
            int size = this.f9563d.size() - 1;
            while (size >= 0) {
                a aVar = this.f9563d.get(size);
                if ((str != null && str.equals(aVar.J())) || (i11 >= 0 && i11 == aVar.f9694v)) {
                    break;
                }
                size--;
            }
            if (size < 0) {
                return size;
            }
            if (z11) {
                while (size > 0) {
                    a aVar2 = this.f9563d.get(size - 1);
                    if ((str == null || !str.equals(aVar2.J())) && (i11 < 0 || i11 != aVar2.f9694v)) {
                        return size;
                    }
                    size--;
                }
                return size;
            } else if (size == this.f9563d.size() - 1) {
                return -1;
            } else {
                return size + 1;
            }
        } else if (z11) {
            return 0;
        } else {
            return this.f9563d.size() - 1;
        }
    }

    public void k1(int i11, int i12, boolean z11) {
        if (i11 >= 0) {
            c0(new o((String) null, i11, i12), z11);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i11);
    }

    public void l(m mVar) {
        if (this.f9572m == null) {
            this.f9572m = new ArrayList<>();
        }
        this.f9572m.add(mVar);
    }

    public Fragment l0(int i11) {
        return this.f9562c.g(i11);
    }

    public void l1(String str, int i11) {
        c0(new o(str, -1, i11), false);
    }

    public void m(Fragment fragment) {
        this.P.b(fragment);
    }

    public Fragment m0(String str) {
        return this.f9562c.h(str);
    }

    public boolean m1() {
        return o1((String) null, -1, 0);
    }

    public int n() {
        return this.f9568i.getAndIncrement();
    }

    public Fragment n0(String str) {
        return this.f9562c.i(str);
    }

    public boolean n1(int i11, int i12) {
        if (i11 >= 0) {
            return o1((String) null, i11, i12);
        }
        throw new IllegalArgumentException("Bad id: " + i11);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v29, resolved type: androidx.activity.q} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v30, resolved type: androidx.fragment.app.Fragment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v31, resolved type: androidx.fragment.app.Fragment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v36, resolved type: androidx.fragment.app.Fragment} */
    /* JADX WARNING: Multi-variable type inference failed */
    @android.annotation.SuppressLint({"SyntheticAccessor"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void o(androidx.fragment.app.FragmentHostCallback<?> r4, androidx.fragment.app.FragmentContainer r5, androidx.fragment.app.Fragment r6) {
        /*
            r3 = this;
            androidx.fragment.app.FragmentHostCallback<?> r0 = r3.f9581v
            if (r0 != 0) goto L_0x016c
            r3.f9581v = r4
            r3.f9582w = r5
            r3.f9583x = r6
            if (r6 == 0) goto L_0x0015
            androidx.fragment.app.FragmentManager$h r5 = new androidx.fragment.app.FragmentManager$h
            r5.<init>(r6)
            r3.k(r5)
            goto L_0x001f
        L_0x0015:
            boolean r5 = r4 instanceof androidx.fragment.app.a0
            if (r5 == 0) goto L_0x001f
            r5 = r4
            androidx.fragment.app.a0 r5 = (androidx.fragment.app.a0) r5
            r3.k(r5)
        L_0x001f:
            androidx.fragment.app.Fragment r5 = r3.f9583x
            if (r5 == 0) goto L_0x0026
            r3.P1()
        L_0x0026:
            boolean r5 = r4 instanceof androidx.activity.q
            if (r5 == 0) goto L_0x003b
            r5 = r4
            androidx.activity.q r5 = (androidx.activity.q) r5
            androidx.activity.OnBackPressedDispatcher r0 = r5.getOnBackPressedDispatcher()
            r3.f9566g = r0
            if (r6 == 0) goto L_0x0036
            r5 = r6
        L_0x0036:
            androidx.activity.o r1 = r3.f9567h
            r0.i(r5, r1)
        L_0x003b:
            if (r6 == 0) goto L_0x0046
            androidx.fragment.app.FragmentManager r4 = r6.mFragmentManager
            androidx.fragment.app.z r4 = r4.v0(r6)
            r3.P = r4
            goto L_0x005f
        L_0x0046:
            boolean r5 = r4 instanceof androidx.lifecycle.q0
            if (r5 == 0) goto L_0x0057
            androidx.lifecycle.q0 r4 = (androidx.lifecycle.q0) r4
            androidx.lifecycle.ViewModelStore r4 = r4.getViewModelStore()
            androidx.fragment.app.z r4 = androidx.fragment.app.z.j(r4)
            r3.P = r4
            goto L_0x005f
        L_0x0057:
            androidx.fragment.app.z r4 = new androidx.fragment.app.z
            r5 = 0
            r4.<init>(r5)
            r3.P = r4
        L_0x005f:
            androidx.fragment.app.z r4 = r3.P
            boolean r5 = r3.W0()
            r4.l0(r5)
            androidx.fragment.app.f0 r4 = r3.f9562c
            androidx.fragment.app.z r5 = r3.P
            r4.A(r5)
            androidx.fragment.app.FragmentHostCallback<?> r4 = r3.f9581v
            boolean r5 = r4 instanceof androidx.savedstate.c
            if (r5 == 0) goto L_0x0090
            if (r6 != 0) goto L_0x0090
            androidx.savedstate.c r4 = (androidx.savedstate.c) r4
            androidx.savedstate.SavedStateRegistry r4 = r4.getSavedStateRegistry()
            androidx.fragment.app.w r5 = new androidx.fragment.app.w
            r5.<init>(r3)
            java.lang.String r0 = "android:support:fragments"
            r4.h(r0, r5)
            android.os.Bundle r4 = r4.b(r0)
            if (r4 == 0) goto L_0x0090
            r3.y1(r4)
        L_0x0090:
            androidx.fragment.app.FragmentHostCallback<?> r4 = r3.f9581v
            boolean r5 = r4 instanceof androidx.activity.result.c
            if (r5 == 0) goto L_0x0128
            androidx.activity.result.c r4 = (androidx.activity.result.c) r4
            androidx.activity.result.ActivityResultRegistry r4 = r4.getActivityResultRegistry()
            if (r6 == 0) goto L_0x00b2
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = r6.mWho
            r5.append(r0)
            java.lang.String r0 = ":"
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            goto L_0x00b4
        L_0x00b2:
            java.lang.String r5 = ""
        L_0x00b4:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "FragmentManager:"
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            java.lang.String r1 = "StartActivityForResult"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult r1 = new androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult
            r1.<init>()
            androidx.fragment.app.FragmentManager$i r2 = new androidx.fragment.app.FragmentManager$i
            r2.<init>()
            androidx.activity.result.ActivityResultLauncher r0 = r4.i(r0, r1, r2)
            r3.D = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            java.lang.String r1 = "StartIntentSenderForResult"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            androidx.fragment.app.FragmentManager$k r1 = new androidx.fragment.app.FragmentManager$k
            r1.<init>()
            androidx.fragment.app.FragmentManager$j r2 = new androidx.fragment.app.FragmentManager$j
            r2.<init>()
            androidx.activity.result.ActivityResultLauncher r0 = r4.i(r0, r1, r2)
            r3.E = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            java.lang.String r5 = "RequestPermissions"
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            androidx.activity.result.contract.ActivityResultContracts$RequestMultiplePermissions r0 = new androidx.activity.result.contract.ActivityResultContracts$RequestMultiplePermissions
            r0.<init>()
            androidx.fragment.app.FragmentManager$a r1 = new androidx.fragment.app.FragmentManager$a
            r1.<init>()
            androidx.activity.result.ActivityResultLauncher r4 = r4.i(r5, r0, r1)
            r3.F = r4
        L_0x0128:
            androidx.fragment.app.FragmentHostCallback<?> r4 = r3.f9581v
            boolean r5 = r4 instanceof q0.c
            if (r5 == 0) goto L_0x0135
            q0.c r4 = (q0.c) r4
            androidx.core.util.Consumer<android.content.res.Configuration> r5 = r3.f9575p
            r4.addOnConfigurationChangedListener(r5)
        L_0x0135:
            androidx.fragment.app.FragmentHostCallback<?> r4 = r3.f9581v
            boolean r5 = r4 instanceof q0.d
            if (r5 == 0) goto L_0x0142
            q0.d r4 = (q0.d) r4
            androidx.core.util.Consumer<java.lang.Integer> r5 = r3.f9576q
            r4.addOnTrimMemoryListener(r5)
        L_0x0142:
            androidx.fragment.app.FragmentHostCallback<?> r4 = r3.f9581v
            boolean r5 = r4 instanceof p0.n
            if (r5 == 0) goto L_0x014f
            p0.n r4 = (p0.n) r4
            androidx.core.util.Consumer<p0.i> r5 = r3.f9577r
            r4.addOnMultiWindowModeChangedListener(r5)
        L_0x014f:
            androidx.fragment.app.FragmentHostCallback<?> r4 = r3.f9581v
            boolean r5 = r4 instanceof p0.o
            if (r5 == 0) goto L_0x015c
            p0.o r4 = (p0.o) r4
            androidx.core.util.Consumer<p0.p> r5 = r3.f9578s
            r4.addOnPictureInPictureModeChangedListener(r5)
        L_0x015c:
            androidx.fragment.app.FragmentHostCallback<?> r4 = r3.f9581v
            boolean r5 = r4 instanceof androidx.core.view.j
            if (r5 == 0) goto L_0x016b
            if (r6 != 0) goto L_0x016b
            androidx.core.view.j r4 = (androidx.core.view.j) r4
            androidx.core.view.MenuProvider r5 = r3.f9579t
            r4.addMenuProvider(r5)
        L_0x016b:
            return
        L_0x016c:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "Already attached"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.o(androidx.fragment.app.FragmentHostCallback, androidx.fragment.app.FragmentContainer, androidx.fragment.app.Fragment):void");
    }

    public final boolean o1(String str, int i11, int i12) {
        e0(false);
        d0(true);
        Fragment fragment = this.f9584y;
        if (fragment != null && i11 < 0 && str == null && fragment.getChildFragmentManager().m1()) {
            return true;
        }
        boolean p12 = p1(this.M, this.N, str, i11, i12);
        if (p12) {
            this.f9561b = true;
            try {
                t1(this.M, this.N);
            } finally {
                t();
            }
        }
        P1();
        Z();
        this.f9562c.b();
        return p12;
    }

    public void p(Fragment fragment) {
        if (P0(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (!fragment.mAdded) {
                this.f9562c.a(fragment);
                if (P0(2)) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                if (Q0(fragment)) {
                    this.H = true;
                }
            }
        }
    }

    public boolean p1(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, String str, int i11, int i12) {
        int k02 = k0(str, i11, (i12 & 1) != 0);
        if (k02 < 0) {
            return false;
        }
        for (int size = this.f9563d.size() - 1; size >= k02; size--) {
            arrayList.add(this.f9563d.remove(size));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    public FragmentTransaction q() {
        return new a(this);
    }

    public final void q0() {
        for (SpecialEffectsController o11 : x()) {
            o11.o();
        }
    }

    public void q1(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mFragmentManager != this) {
            N1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putString(str, fragment.mWho);
    }

    public boolean r() {
        boolean z11 = false;
        for (Fragment next : this.f9562c.l()) {
            if (next != null) {
                z11 = Q0(next);
                continue;
            }
            if (z11) {
                return true;
            }
        }
        return false;
    }

    public final Set<Fragment> r0(a aVar) {
        HashSet hashSet = new HashSet();
        for (int i11 = 0; i11 < aVar.f9624c.size(); i11++) {
            Fragment fragment = aVar.f9624c.get(i11).f9642b;
            if (fragment != null && aVar.f9630i) {
                hashSet.add(fragment);
            }
        }
        return hashSet;
    }

    public void r1(FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z11) {
        this.f9573n.o(fragmentLifecycleCallbacks, z11);
    }

    public final void s() {
        if (W0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    public final boolean s0(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this.f9560a) {
            if (this.f9560a.isEmpty()) {
                return false;
            }
            try {
                int size = this.f9560a.size();
                boolean z11 = false;
                for (int i11 = 0; i11 < size; i11++) {
                    z11 |= this.f9560a.get(i11).a(arrayList, arrayList2);
                }
                return z11;
            } finally {
                this.f9560a.clear();
                this.f9581v.g().removeCallbacks(this.R);
            }
        }
    }

    public void s1(Fragment fragment) {
        if (P0(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean z11 = !fragment.isInBackStack();
        if (!fragment.mDetached || z11) {
            this.f9562c.u(fragment);
            if (Q0(fragment)) {
                this.H = true;
            }
            fragment.mRemoving = true;
            K1(fragment);
        }
    }

    public final void t() {
        this.f9561b = false;
        this.N.clear();
        this.M.clear();
    }

    public List<Fragment> t0() {
        return this.f9562c.l();
    }

    public final void t1(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (!arrayList.isEmpty()) {
            if (arrayList.size() == arrayList2.size()) {
                int size = arrayList.size();
                int i11 = 0;
                int i12 = 0;
                while (i11 < size) {
                    if (!arrayList.get(i11).f9639r) {
                        if (i12 != i11) {
                            h0(arrayList, arrayList2, i12, i11);
                        }
                        i12 = i11 + 1;
                        if (arrayList2.get(i11).booleanValue()) {
                            while (i12 < size && arrayList2.get(i12).booleanValue() && !arrayList.get(i12).f9639r) {
                                i12++;
                            }
                        }
                        h0(arrayList, arrayList2, i11, i12);
                        i11 = i12 - 1;
                    }
                    i11++;
                }
                if (i12 != size) {
                    h0(arrayList, arrayList2, i12, size);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error with the back stack records");
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("FragmentManager{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" in ");
        Fragment fragment = this.f9583x;
        if (fragment != null) {
            sb2.append(fragment.getClass().getSimpleName());
            sb2.append("{");
            sb2.append(Integer.toHexString(System.identityHashCode(this.f9583x)));
            sb2.append("}");
        } else {
            FragmentHostCallback<?> fragmentHostCallback = this.f9581v;
            if (fragmentHostCallback != null) {
                sb2.append(fragmentHostCallback.getClass().getSimpleName());
                sb2.append("{");
                sb2.append(Integer.toHexString(System.identityHashCode(this.f9581v)));
                sb2.append("}");
            } else {
                sb2.append(OptionsBridge.NULL_VALUE);
            }
        }
        sb2.append("}}");
        return sb2.toString();
    }

    public final void u() {
        FragmentHostCallback<?> fragmentHostCallback = this.f9581v;
        boolean z11 = true;
        if (fragmentHostCallback instanceof q0) {
            z11 = this.f9562c.p().j0();
        } else if (fragmentHostCallback.f() instanceof Activity) {
            z11 = true ^ ((Activity) this.f9581v.f()).isChangingConfigurations();
        }
        if (z11) {
            for (BackStackState backStackState : this.f9569j.values()) {
                for (String d11 : backStackState.mFragments) {
                    this.f9562c.p().d(d11, false);
                }
            }
        }
    }

    public int u0() {
        ArrayList<a> arrayList = this.f9563d;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public void u1(Fragment fragment) {
        this.P.k0(fragment);
    }

    public final void v(String str) {
        this.f9570k.remove(str);
        if (P0(2)) {
            Log.v("FragmentManager", "Clearing fragment result with key " + str);
        }
    }

    public final z v0(Fragment fragment) {
        return this.P.i(fragment);
    }

    public final void v1() {
        if (this.f9572m != null) {
            for (int i11 = 0; i11 < this.f9572m.size(); i11++) {
                this.f9572m.get(i11).onBackStackChanged();
            }
        }
    }

    public final void w(String str) {
        l remove = this.f9571l.remove(str);
        if (remove != null) {
            remove.c();
        }
        if (P0(2)) {
            Log.v("FragmentManager", "Clearing FragmentResultListener for key " + str);
        }
    }

    public FragmentContainer w0() {
        return this.f9582w;
    }

    public void w1(String str) {
        c0(new p(str), false);
    }

    public final Set<SpecialEffectsController> x() {
        HashSet hashSet = new HashSet();
        for (d0 k11 : this.f9562c.k()) {
            ViewGroup viewGroup = k11.k().mContainer;
            if (viewGroup != null) {
                hashSet.add(SpecialEffectsController.s(viewGroup, H0()));
            }
        }
        return hashSet;
    }

    public Fragment x0(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment j02 = j0(string);
        if (j02 == null) {
            N1(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        }
        return j02;
    }

    public boolean x1(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, String str) {
        BackStackState remove = this.f9569j.remove(str);
        if (remove == null) {
            return false;
        }
        HashMap hashMap = new HashMap();
        Iterator<a> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            if (next.f9695w) {
                Iterator<FragmentTransaction.a> it3 = next.f9624c.iterator();
                while (it3.hasNext()) {
                    Fragment fragment = it3.next().f9642b;
                    if (fragment != null) {
                        hashMap.put(fragment.mWho, fragment);
                    }
                }
            }
        }
        Iterator<a> it4 = remove.instantiate(this, hashMap).iterator();
        while (true) {
            boolean z11 = false;
            while (true) {
                if (!it4.hasNext()) {
                    return z11;
                }
                if (it4.next().a(arrayList, arrayList2) || z11) {
                    z11 = true;
                }
            }
        }
    }

    public final Set<SpecialEffectsController> y(ArrayList<a> arrayList, int i11, int i12) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i11 < i12) {
            Iterator<FragmentTransaction.a> it2 = arrayList.get(i11).f9624c.iterator();
            while (it2.hasNext()) {
                Fragment fragment = it2.next().f9642b;
                if (!(fragment == null || (viewGroup = fragment.mContainer) == null)) {
                    hashSet.add(SpecialEffectsController.r(viewGroup, this));
                }
            }
            i11++;
        }
        return hashSet;
    }

    public final ViewGroup y0(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.mContainerId > 0 && this.f9582w.d()) {
            View c11 = this.f9582w.c(fragment.mContainerId);
            if (c11 instanceof ViewGroup) {
                return (ViewGroup) c11;
            }
        }
        return null;
    }

    public void y1(Parcelable parcelable) {
        d0 d0Var;
        Bundle bundle;
        Bundle bundle2;
        if (parcelable != null) {
            Bundle bundle3 = (Bundle) parcelable;
            for (String str : bundle3.keySet()) {
                if (str.startsWith("result_") && (bundle2 = bundle3.getBundle(str)) != null) {
                    bundle2.setClassLoader(this.f9581v.f().getClassLoader());
                    this.f9570k.put(str.substring(7), bundle2);
                }
            }
            HashMap hashMap = new HashMap();
            for (String str2 : bundle3.keySet()) {
                if (str2.startsWith("fragment_") && (bundle = bundle3.getBundle(str2)) != null) {
                    bundle.setClassLoader(this.f9581v.f().getClassLoader());
                    hashMap.put(str2.substring(9), bundle);
                }
            }
            this.f9562c.x(hashMap);
            FragmentManagerState fragmentManagerState = (FragmentManagerState) bundle3.getParcelable("state");
            if (fragmentManagerState != null) {
                this.f9562c.v();
                Iterator<String> it2 = fragmentManagerState.mActive.iterator();
                while (it2.hasNext()) {
                    Bundle B2 = this.f9562c.B(it2.next(), (Bundle) null);
                    if (B2 != null) {
                        Fragment h11 = this.P.h(((FragmentState) B2.getParcelable("state")).mWho);
                        if (h11 != null) {
                            if (P0(2)) {
                                Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + h11);
                            }
                            d0Var = new d0(this.f9573n, this.f9562c, h11, B2);
                        } else {
                            d0Var = new d0(this.f9573n, this.f9562c, this.f9581v.f().getClassLoader(), z0(), B2);
                        }
                        Fragment k11 = d0Var.k();
                        k11.mSavedFragmentState = B2;
                        k11.mFragmentManager = this;
                        if (P0(2)) {
                            Log.v("FragmentManager", "restoreSaveState: active (" + k11.mWho + "): " + k11);
                        }
                        d0Var.o(this.f9581v.f().getClassLoader());
                        this.f9562c.r(d0Var);
                        d0Var.t(this.f9580u);
                    }
                }
                for (Fragment next : this.P.h0()) {
                    if (!this.f9562c.c(next.mWho)) {
                        if (P0(2)) {
                            Log.v("FragmentManager", "Discarding retained Fragment " + next + " that was not found in the set of active Fragments " + fragmentManagerState.mActive);
                        }
                        this.P.k0(next);
                        next.mFragmentManager = this;
                        d0 d0Var2 = new d0(this.f9573n, this.f9562c, next);
                        d0Var2.t(1);
                        d0Var2.m();
                        next.mRemoving = true;
                        d0Var2.m();
                    }
                }
                this.f9562c.w(fragmentManagerState.mAdded);
                if (fragmentManagerState.mBackStack != null) {
                    this.f9563d = new ArrayList<>(fragmentManagerState.mBackStack.length);
                    int i11 = 0;
                    while (true) {
                        BackStackRecordState[] backStackRecordStateArr = fragmentManagerState.mBackStack;
                        if (i11 >= backStackRecordStateArr.length) {
                            break;
                        }
                        a instantiate = backStackRecordStateArr[i11].instantiate(this);
                        if (P0(2)) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i11 + " (index " + instantiate.f9694v + "): " + instantiate);
                            PrintWriter printWriter = new PrintWriter(new i0("FragmentManager"));
                            instantiate.F("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.f9563d.add(instantiate);
                        i11++;
                    }
                } else {
                    this.f9563d = null;
                }
                this.f9568i.set(fragmentManagerState.mBackStackIndex);
                String str3 = fragmentManagerState.mPrimaryNavActiveWho;
                if (str3 != null) {
                    Fragment j02 = j0(str3);
                    this.f9584y = j02;
                    P(j02);
                }
                ArrayList<String> arrayList = fragmentManagerState.mBackStackStateKeys;
                if (arrayList != null) {
                    for (int i12 = 0; i12 < arrayList.size(); i12++) {
                        this.f9569j.put(arrayList.get(i12), fragmentManagerState.mBackStackStates.get(i12));
                    }
                }
                this.G = new ArrayDeque<>(fragmentManagerState.mLaunchedFragments);
            }
        }
    }

    public d0 z(Fragment fragment) {
        d0 n11 = this.f9562c.n(fragment.mWho);
        if (n11 != null) {
            return n11;
        }
        d0 d0Var = new d0(this.f9573n, this.f9562c, fragment);
        d0Var.o(this.f9581v.f().getClassLoader());
        d0Var.t(this.f9580u);
        return d0Var;
    }

    public FragmentFactory z0() {
        FragmentFactory fragmentFactory = this.f9585z;
        if (fragmentFactory != null) {
            return fragmentFactory;
        }
        Fragment fragment = this.f9583x;
        if (fragment != null) {
            return fragment.mFragmentManager.z0();
        }
        return this.A;
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = new a();
        public int mRequestCode;
        public String mWho;

        public class a implements Parcelable.Creator<LaunchedFragmentInfo> {
            /* renamed from: a */
            public LaunchedFragmentInfo createFromParcel(Parcel parcel) {
                return new LaunchedFragmentInfo(parcel);
            }

            /* renamed from: b */
            public LaunchedFragmentInfo[] newArray(int i11) {
                return new LaunchedFragmentInfo[i11];
            }
        }

        public LaunchedFragmentInfo(String str, int i11) {
            this.mWho = str;
            this.mRequestCode = i11;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeString(this.mWho);
            parcel.writeInt(this.mRequestCode);
        }

        public LaunchedFragmentInfo(Parcel parcel) {
            this.mWho = parcel.readString();
            this.mRequestCode = parcel.readInt();
        }
    }
}
