package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.util.h;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class FragmentHostCallback<E> extends FragmentContainer {

    /* renamed from: b  reason: collision with root package name */
    public final Activity f9555b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f9556c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f9557d;

    /* renamed from: e  reason: collision with root package name */
    public final int f9558e;

    /* renamed from: f  reason: collision with root package name */
    public final FragmentManager f9559f;

    public FragmentHostCallback(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, new Handler(), 0);
    }

    public View c(int i11) {
        return null;
    }

    public boolean d() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public Activity e() {
        return this.f9555b;
    }

    /* access modifiers changed from: package-private */
    public Context f() {
        return this.f9556c;
    }

    public Handler g() {
        return this.f9557d;
    }

    public void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public abstract E i();

    public LayoutInflater j() {
        return LayoutInflater.from(this.f9556c);
    }

    @Deprecated
    public void k(Fragment fragment, String[] strArr, int i11) {
    }

    public boolean l(String str) {
        return false;
    }

    public void m(Fragment fragment, Intent intent, int i11, Bundle bundle) {
        if (i11 == -1) {
            ContextCompat.startActivity(this.f9556c, intent, bundle);
            return;
        }
        throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }

    @Deprecated
    public void n(Fragment fragment, IntentSender intentSender, int i11, Intent intent, int i12, int i13, int i14, Bundle bundle) throws IntentSender.SendIntentException {
        if (i11 == -1) {
            ActivityCompat.startIntentSenderForResult(this.f9555b, intentSender, i11, intent, i12, i13, i14, bundle);
        } else {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
    }

    public void o() {
    }

    public FragmentHostCallback(Activity activity, Context context, Handler handler, int i11) {
        this.f9559f = new y();
        this.f9555b = activity;
        this.f9556c = (Context) h.h(context, "context == null");
        this.f9557d = (Handler) h.h(handler, "handler == null");
        this.f9558e = i11;
    }
}
