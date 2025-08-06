package p0;

import android.app.RemoteInput;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    public final String f16349a;

    /* renamed from: b  reason: collision with root package name */
    public final CharSequence f16350b;

    /* renamed from: c  reason: collision with root package name */
    public final CharSequence[] f16351c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f16352d;

    /* renamed from: e  reason: collision with root package name */
    public final int f16353e;

    /* renamed from: f  reason: collision with root package name */
    public final Bundle f16354f;

    /* renamed from: g  reason: collision with root package name */
    public final Set<String> f16355g;

    public static class a {
        public static void a(Object obj, Intent intent, Bundle bundle) {
            RemoteInput.addResultsToIntent((RemoteInput[]) obj, intent, bundle);
        }

        public static RemoteInput b(q qVar) {
            Set<String> e11;
            RemoteInput.Builder addExtras = new RemoteInput.Builder(qVar.j()).setLabel(qVar.i()).setChoices(qVar.f()).setAllowFreeFormInput(qVar.d()).addExtras(qVar.h());
            if (Build.VERSION.SDK_INT >= 26 && (e11 = qVar.e()) != null) {
                for (String d11 : e11) {
                    b.d(addExtras, d11, true);
                }
            }
            if (Build.VERSION.SDK_INT >= 29) {
                c.b(addExtras, qVar.g());
            }
            return addExtras.build();
        }

        public static q c(Object obj) {
            Set<String> b11;
            RemoteInput remoteInput = (RemoteInput) obj;
            d a11 = new d(remoteInput.getResultKey()).g(remoteInput.getLabel()).e(remoteInput.getChoices()).d(remoteInput.getAllowFreeFormInput()).a(remoteInput.getExtras());
            if (Build.VERSION.SDK_INT >= 26 && (b11 = b.b(remoteInput)) != null) {
                for (String c11 : b11) {
                    a11.c(c11, true);
                }
            }
            if (Build.VERSION.SDK_INT >= 29) {
                a11.f(c.a(remoteInput));
            }
            return a11.b();
        }

        public static Bundle d(Intent intent) {
            return RemoteInput.getResultsFromIntent(intent);
        }
    }

    public static class b {
        public static void a(q qVar, Intent intent, Map<String, Uri> map) {
            RemoteInput.addDataResultToIntent(q.a(qVar), intent, map);
        }

        public static Set<String> b(Object obj) {
            return ((RemoteInput) obj).getAllowedDataTypes();
        }

        public static Map<String, Uri> c(Intent intent, String str) {
            return RemoteInput.getDataResultsFromIntent(intent, str);
        }

        public static RemoteInput.Builder d(RemoteInput.Builder builder, String str, boolean z11) {
            return builder.setAllowDataType(str, z11);
        }
    }

    public static class c {
        public static int a(Object obj) {
            return ((RemoteInput) obj).getEditChoicesBeforeSending();
        }

        public static RemoteInput.Builder b(RemoteInput.Builder builder, int i11) {
            return builder.setEditChoicesBeforeSending(i11);
        }
    }

    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final String f16356a;

        /* renamed from: b  reason: collision with root package name */
        public final Set<String> f16357b = new HashSet();

        /* renamed from: c  reason: collision with root package name */
        public final Bundle f16358c = new Bundle();

        /* renamed from: d  reason: collision with root package name */
        public CharSequence f16359d;

        /* renamed from: e  reason: collision with root package name */
        public CharSequence[] f16360e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f16361f = true;

        /* renamed from: g  reason: collision with root package name */
        public int f16362g = 0;

        public d(String str) {
            if (str != null) {
                this.f16356a = str;
                return;
            }
            throw new IllegalArgumentException("Result key can't be null");
        }

        public d a(Bundle bundle) {
            if (bundle != null) {
                this.f16358c.putAll(bundle);
            }
            return this;
        }

        public q b() {
            return new q(this.f16356a, this.f16359d, this.f16360e, this.f16361f, this.f16362g, this.f16358c, this.f16357b);
        }

        public d c(String str, boolean z11) {
            if (z11) {
                this.f16357b.add(str);
            } else {
                this.f16357b.remove(str);
            }
            return this;
        }

        public d d(boolean z11) {
            this.f16361f = z11;
            return this;
        }

        public d e(CharSequence[] charSequenceArr) {
            this.f16360e = charSequenceArr;
            return this;
        }

        public d f(int i11) {
            this.f16362g = i11;
            return this;
        }

        public d g(CharSequence charSequence) {
            this.f16359d = charSequence;
            return this;
        }
    }

    public q(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z11, int i11, Bundle bundle, Set<String> set) {
        this.f16349a = str;
        this.f16350b = charSequence;
        this.f16351c = charSequenceArr;
        this.f16352d = z11;
        this.f16353e = i11;
        this.f16354f = bundle;
        this.f16355g = set;
        if (g() == 2 && !d()) {
            throw new IllegalArgumentException("setEditChoicesBeforeSending requires setAllowFreeFormInput");
        }
    }

    public static RemoteInput a(q qVar) {
        return a.b(qVar);
    }

    public static RemoteInput[] b(q[] qVarArr) {
        if (qVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[qVarArr.length];
        for (int i11 = 0; i11 < qVarArr.length; i11++) {
            remoteInputArr[i11] = a(qVarArr[i11]);
        }
        return remoteInputArr;
    }

    public static q c(RemoteInput remoteInput) {
        return a.c(remoteInput);
    }

    public boolean d() {
        return this.f16352d;
    }

    public Set<String> e() {
        return this.f16355g;
    }

    public CharSequence[] f() {
        return this.f16351c;
    }

    public int g() {
        return this.f16353e;
    }

    public Bundle h() {
        return this.f16354f;
    }

    public CharSequence i() {
        return this.f16350b;
    }

    public String j() {
        return this.f16349a;
    }

    public boolean k() {
        return !d() && (f() == null || f().length == 0) && e() != null && !e().isEmpty();
    }
}
