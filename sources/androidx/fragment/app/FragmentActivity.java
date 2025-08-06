package androidx.fragment.app;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.q;
import androidx.activity.result.ActivityResultRegistry;
import androidx.core.app.ActivityCompat;
import androidx.core.app.SharedElementCallback;
import androidx.core.util.Consumer;
import androidx.core.view.MenuProvider;
import androidx.core.view.j;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.q0;
import androidx.loader.app.LoaderManager;
import androidx.savedstate.SavedStateRegistry;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import p0.i;
import p0.n;
import p0.o;
import p0.p;
import q0.c;
import q0.d;

public class FragmentActivity extends ComponentActivity implements ActivityCompat.j, ActivityCompat.l {
    public static final String LIFECYCLE_TAG = "android:support:lifecycle";
    public boolean mCreated;
    public final LifecycleRegistry mFragmentLifecycleRegistry = new LifecycleRegistry(this);
    public final FragmentController mFragments = FragmentController.b(new a());
    public boolean mResumed;
    public boolean mStopped = true;

    public class a extends FragmentHostCallback<FragmentActivity> implements c, d, n, o, q0, q, androidx.activity.result.c, androidx.savedstate.c, a0, j {
        public a() {
            super(FragmentActivity.this);
        }

        public void a(FragmentManager fragmentManager, Fragment fragment) {
            FragmentActivity.this.onAttachFragment(fragment);
        }

        public void addMenuProvider(MenuProvider menuProvider) {
            FragmentActivity.this.addMenuProvider(menuProvider);
        }

        public void addOnConfigurationChangedListener(Consumer<Configuration> consumer) {
            FragmentActivity.this.addOnConfigurationChangedListener(consumer);
        }

        public void addOnMultiWindowModeChangedListener(Consumer<i> consumer) {
            FragmentActivity.this.addOnMultiWindowModeChangedListener(consumer);
        }

        public void addOnPictureInPictureModeChangedListener(Consumer<p> consumer) {
            FragmentActivity.this.addOnPictureInPictureModeChangedListener(consumer);
        }

        public void addOnTrimMemoryListener(Consumer<Integer> consumer) {
            FragmentActivity.this.addOnTrimMemoryListener(consumer);
        }

        public View c(int i11) {
            return FragmentActivity.this.findViewById(i11);
        }

        public boolean d() {
            Window window = FragmentActivity.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        public ActivityResultRegistry getActivityResultRegistry() {
            return FragmentActivity.this.getActivityResultRegistry();
        }

        public Lifecycle getLifecycle() {
            return FragmentActivity.this.mFragmentLifecycleRegistry;
        }

        public OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return FragmentActivity.this.getOnBackPressedDispatcher();
        }

        public SavedStateRegistry getSavedStateRegistry() {
            return FragmentActivity.this.getSavedStateRegistry();
        }

        public ViewModelStore getViewModelStore() {
            return FragmentActivity.this.getViewModelStore();
        }

        public void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            FragmentActivity.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        public LayoutInflater j() {
            return FragmentActivity.this.getLayoutInflater().cloneInContext(FragmentActivity.this);
        }

        public boolean l(String str) {
            return ActivityCompat.shouldShowRequestPermissionRationale(FragmentActivity.this, str);
        }

        public void o() {
            p();
        }

        public void p() {
            FragmentActivity.this.invalidateMenu();
        }

        /* renamed from: q */
        public FragmentActivity i() {
            return FragmentActivity.this;
        }

        public void removeMenuProvider(MenuProvider menuProvider) {
            FragmentActivity.this.removeMenuProvider(menuProvider);
        }

        public void removeOnConfigurationChangedListener(Consumer<Configuration> consumer) {
            FragmentActivity.this.removeOnConfigurationChangedListener(consumer);
        }

        public void removeOnMultiWindowModeChangedListener(Consumer<i> consumer) {
            FragmentActivity.this.removeOnMultiWindowModeChangedListener(consumer);
        }

        public void removeOnPictureInPictureModeChangedListener(Consumer<p> consumer) {
            FragmentActivity.this.removeOnPictureInPictureModeChangedListener(consumer);
        }

        public void removeOnTrimMemoryListener(Consumer<Integer> consumer) {
            FragmentActivity.this.removeOnTrimMemoryListener(consumer);
        }
    }

    public FragmentActivity() {
        init();
    }

    private void init() {
        getSavedStateRegistry().h(LIFECYCLE_TAG, new n(this));
        addOnConfigurationChangedListener(new m(this));
        addOnNewIntentListener(new l(this));
        addOnContextAvailableListener(new k(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Bundle lambda$init$0() {
        markFragmentsCreated();
        this.mFragmentLifecycleRegistry.i(Lifecycle.Event.ON_STOP);
        return new Bundle();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$init$1(Configuration configuration) {
        this.mFragments.m();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$init$2(Intent intent) {
        this.mFragments.m();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$init$3(Context context) {
        this.mFragments.a((Fragment) null);
    }

    private static boolean markState(FragmentManager fragmentManager, Lifecycle.State state) {
        boolean z11 = false;
        for (Fragment next : fragmentManager.B0()) {
            if (next != null) {
                if (next.getHost() != null) {
                    z11 |= markState(next.getChildFragmentManager(), state);
                }
                FragmentViewLifecycleOwner fragmentViewLifecycleOwner = next.mViewLifecycleOwner;
                if (fragmentViewLifecycleOwner != null && fragmentViewLifecycleOwner.getLifecycle().b().isAtLeast(Lifecycle.State.STARTED)) {
                    next.mViewLifecycleOwner.f(state);
                    z11 = true;
                }
                if (next.mLifecycleRegistry.b().isAtLeast(Lifecycle.State.STARTED)) {
                    next.mLifecycleRegistry.o(state);
                    z11 = true;
                }
            }
        }
        return z11;
    }

    public final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.n(view, str, context, attributeSet);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (shouldDumpInternalState(strArr)) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            String str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.mCreated);
            printWriter.print(" mResumed=");
            printWriter.print(this.mResumed);
            printWriter.print(" mStopped=");
            printWriter.print(this.mStopped);
            if (getApplication() != null) {
                LoaderManager.b(this).a(str2, fileDescriptor, printWriter, strArr);
            }
            this.mFragments.l().a0(str, fileDescriptor, printWriter, strArr);
        }
    }

    public FragmentManager getSupportFragmentManager() {
        return this.mFragments.l();
    }

    @Deprecated
    public LoaderManager getSupportLoaderManager() {
        return LoaderManager.b(this);
    }

    public void markFragmentsCreated() {
        do {
        } while (markState(getSupportFragmentManager(), Lifecycle.State.CREATED));
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        this.mFragments.m();
        super.onActivityResult(i11, i12, intent);
    }

    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.i(Lifecycle.Event.ON_CREATE);
        this.mFragments.e();
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    public void onDestroy() {
        super.onDestroy();
        this.mFragments.f();
        this.mFragmentLifecycleRegistry.i(Lifecycle.Event.ON_DESTROY);
    }

    public boolean onMenuItemSelected(int i11, MenuItem menuItem) {
        if (super.onMenuItemSelected(i11, menuItem)) {
            return true;
        }
        if (i11 == 6) {
            return this.mFragments.d(menuItem);
        }
        return false;
    }

    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.g();
        this.mFragmentLifecycleRegistry.i(Lifecycle.Event.ON_PAUSE);
    }

    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    public void onRequestPermissionsResult(int i11, String[] strArr, int[] iArr) {
        this.mFragments.m();
        super.onRequestPermissionsResult(i11, strArr, iArr);
    }

    public void onResume() {
        this.mFragments.m();
        super.onResume();
        this.mResumed = true;
        this.mFragments.k();
    }

    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.i(Lifecycle.Event.ON_RESUME);
        this.mFragments.h();
    }

    public void onStart() {
        this.mFragments.m();
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.c();
        }
        this.mFragments.k();
        this.mFragmentLifecycleRegistry.i(Lifecycle.Event.ON_START);
        this.mFragments.i();
    }

    public void onStateNotSaved() {
        this.mFragments.m();
    }

    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        this.mFragments.j();
        this.mFragmentLifecycleRegistry.i(Lifecycle.Event.ON_STOP);
    }

    public void setEnterSharedElementCallback(SharedElementCallback sharedElementCallback) {
        ActivityCompat.setEnterSharedElementCallback(this, sharedElementCallback);
    }

    public void setExitSharedElementCallback(SharedElementCallback sharedElementCallback) {
        ActivityCompat.setExitSharedElementCallback(this, sharedElementCallback);
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i11) {
        startActivityFromFragment(fragment, intent, i11, (Bundle) null);
    }

    @Deprecated
    public void startIntentSenderFromFragment(Fragment fragment, IntentSender intentSender, int i11, Intent intent, int i12, int i13, int i14, Bundle bundle) throws IntentSender.SendIntentException {
        if (i11 == -1) {
            ActivityCompat.startIntentSenderForResult(this, intentSender, i11, intent, i12, i13, i14, bundle);
        } else {
            fragment.startIntentSenderForResult(intentSender, i11, intent, i12, i13, i14, bundle);
        }
    }

    public void supportFinishAfterTransition() {
        ActivityCompat.finishAfterTransition(this);
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateMenu();
    }

    public void supportPostponeEnterTransition() {
        ActivityCompat.postponeEnterTransition(this);
    }

    public void supportStartPostponedEnterTransition() {
        ActivityCompat.startPostponedEnterTransition(this);
    }

    @Deprecated
    public final void validateRequestPermissionsRequestCode(int i11) {
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i11, Bundle bundle) {
        if (i11 == -1) {
            ActivityCompat.startActivityForResult(this, intent, -1, bundle);
        } else {
            fragment.startActivityForResult(intent, i11, bundle);
        }
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView((View) null, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    public FragmentActivity(int i11) {
        super(i11);
        init();
    }
}
