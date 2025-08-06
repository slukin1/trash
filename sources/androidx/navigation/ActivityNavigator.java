package androidx.navigation;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import androidx.core.content.ContextCompat;
import androidx.navigation.Navigator;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import p0.c;

@Navigator.b("activity")
public class ActivityNavigator extends Navigator<b> {

    /* renamed from: e  reason: collision with root package name */
    public static final a f10214e = new a((r) null);

    /* renamed from: c  reason: collision with root package name */
    public final Context f10215c;

    /* renamed from: d  reason: collision with root package name */
    public final Activity f10216d;

    public static final class Extras implements Navigator.a {

        /* renamed from: a  reason: collision with root package name */
        public final int f10217a;

        /* renamed from: b  reason: collision with root package name */
        public final c f10218b;

        public static final class Builder {
        }

        public final c a() {
            return this.f10218b;
        }

        public final int b() {
            return this.f10217a;
        }
    }

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public static class b extends NavDestination {

        /* renamed from: m  reason: collision with root package name */
        public Intent f10219m;

        /* renamed from: n  reason: collision with root package name */
        public String f10220n;

        public b(Navigator<? extends b> navigator) {
            super((Navigator<? extends NavDestination>) navigator);
        }

        public final String A() {
            Intent intent = this.f10219m;
            if (intent != null) {
                return intent.getAction();
            }
            return null;
        }

        public final ComponentName B() {
            Intent intent = this.f10219m;
            if (intent != null) {
                return intent.getComponent();
            }
            return null;
        }

        public final String C() {
            return this.f10220n;
        }

        public final Intent D() {
            return this.f10219m;
        }

        public final String E(Context context, String str) {
            if (str == null) {
                return null;
            }
            return StringsKt__StringsJVMKt.G(str, "${applicationId}", context.getPackageName(), false, 4, (Object) null);
        }

        public final b F(String str) {
            if (this.f10219m == null) {
                this.f10219m = new Intent();
            }
            this.f10219m.setAction(str);
            return this;
        }

        public final b G(ComponentName componentName) {
            if (this.f10219m == null) {
                this.f10219m = new Intent();
            }
            this.f10219m.setComponent(componentName);
            return this;
        }

        public final b H(Uri uri) {
            if (this.f10219m == null) {
                this.f10219m = new Intent();
            }
            this.f10219m.setData(uri);
            return this;
        }

        public final b I(String str) {
            this.f10220n = str;
            return this;
        }

        public final b J(String str) {
            if (this.f10219m == null) {
                this.f10219m = new Intent();
            }
            this.f10219m.setPackage(str);
            return this;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof b) || !super.equals(obj)) {
                return false;
            }
            Intent intent = this.f10219m;
            if (!(intent != null ? intent.filterEquals(((b) obj).f10219m) : ((b) obj).f10219m == null) || !x.b(this.f10220n, ((b) obj).f10220n)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hashCode = super.hashCode() * 31;
            Intent intent = this.f10219m;
            int i11 = 0;
            int filterHashCode = (hashCode + (intent != null ? intent.filterHashCode() : 0)) * 31;
            String str = this.f10220n;
            if (str != null) {
                i11 = str.hashCode();
            }
            return filterHashCode + i11;
        }

        public String toString() {
            ComponentName B = B();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(super.toString());
            if (B != null) {
                sb2.append(" class=");
                sb2.append(B.getClassName());
            } else {
                String A = A();
                if (A != null) {
                    sb2.append(" action=");
                    sb2.append(A);
                }
            }
            return sb2.toString();
        }

        public void u(Context context, AttributeSet attributeSet) {
            super.u(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R$styleable.ActivityNavigator);
            J(E(context, obtainAttributes.getString(R$styleable.ActivityNavigator_targetPackage)));
            String string = obtainAttributes.getString(R$styleable.ActivityNavigator_android_name);
            if (string != null) {
                if (string.charAt(0) == '.') {
                    string = context.getPackageName() + string;
                }
                G(new ComponentName(context, string));
            }
            F(obtainAttributes.getString(R$styleable.ActivityNavigator_action));
            String E = E(context, obtainAttributes.getString(R$styleable.ActivityNavigator_data));
            if (E != null) {
                H(Uri.parse(E));
            }
            I(E(context, obtainAttributes.getString(R$styleable.ActivityNavigator_dataPattern)));
            obtainAttributes.recycle();
        }

        public boolean z() {
            return false;
        }
    }

    public ActivityNavigator(Context context) {
        Object obj;
        this.f10215c = context;
        Iterator it2 = SequencesKt__SequencesKt.g(context, ActivityNavigator$hostActivity$1.INSTANCE).iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            if (((Context) obj) instanceof Activity) {
                break;
            }
        }
        this.f10216d = (Activity) obj;
    }

    public boolean k() {
        Activity activity = this.f10216d;
        if (activity == null) {
            return false;
        }
        activity.finish();
        return true;
    }

    /* renamed from: l */
    public b a() {
        return new b(this);
    }

    /* renamed from: m */
    public NavDestination d(b bVar, Bundle bundle, NavOptions navOptions, Navigator.a aVar) {
        Intent intent;
        int intExtra;
        if (bVar.D() != null) {
            Intent intent2 = new Intent(bVar.D());
            if (bundle != null) {
                intent2.putExtras(bundle);
                String C = bVar.C();
                if (!(C == null || C.length() == 0)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(C);
                    while (matcher.find()) {
                        String group = matcher.group(1);
                        if (bundle.containsKey(group)) {
                            matcher.appendReplacement(stringBuffer, "");
                            stringBuffer.append(Uri.encode(String.valueOf(bundle.get(group))));
                        } else {
                            throw new IllegalArgumentException("Could not find " + group + " in " + bundle + " to fill data pattern " + C);
                        }
                    }
                    matcher.appendTail(stringBuffer);
                    intent2.setData(Uri.parse(stringBuffer.toString()));
                }
            }
            boolean z11 = aVar instanceof Extras;
            if (z11) {
                intent2.addFlags(((Extras) aVar).b());
            }
            if (this.f10216d == null) {
                intent2.addFlags(268435456);
            }
            if (navOptions != null && navOptions.g()) {
                intent2.addFlags(536870912);
            }
            Activity activity = this.f10216d;
            if (!(activity == null || (intent = activity.getIntent()) == null || (intExtra = intent.getIntExtra("android-support-navigation:ActivityNavigator:current", 0)) == 0)) {
                intent2.putExtra("android-support-navigation:ActivityNavigator:source", intExtra);
            }
            intent2.putExtra("android-support-navigation:ActivityNavigator:current", bVar.l());
            Resources resources = this.f10215c.getResources();
            if (navOptions != null) {
                int c11 = navOptions.c();
                int d11 = navOptions.d();
                if ((c11 <= 0 || !x.b(resources.getResourceTypeName(c11), "animator")) && (d11 <= 0 || !x.b(resources.getResourceTypeName(d11), "animator"))) {
                    intent2.putExtra("android-support-navigation:ActivityNavigator:popEnterAnim", c11);
                    intent2.putExtra("android-support-navigation:ActivityNavigator:popExitAnim", d11);
                } else {
                    Log.w("ActivityNavigator", "Activity destinations do not support Animator resource. Ignoring popEnter resource " + resources.getResourceName(c11) + " and popExit resource " + resources.getResourceName(d11) + " when launching " + bVar);
                }
            }
            if (z11) {
                c a11 = ((Extras) aVar).a();
                if (a11 != null) {
                    ContextCompat.startActivity(this.f10215c, intent2, a11.b());
                } else {
                    this.f10215c.startActivity(intent2);
                }
            } else {
                this.f10215c.startActivity(intent2);
            }
            if (navOptions == null || this.f10216d == null) {
                return null;
            }
            int a12 = navOptions.a();
            int b11 = navOptions.b();
            if ((a12 > 0 && x.b(resources.getResourceTypeName(a12), "animator")) || (b11 > 0 && x.b(resources.getResourceTypeName(b11), "animator"))) {
                Log.w("ActivityNavigator", "Activity destinations do not support Animator resource. Ignoring enter resource " + resources.getResourceName(a12) + " and exit resource " + resources.getResourceName(b11) + "when launching " + bVar);
                return null;
            } else if (a12 < 0 && b11 < 0) {
                return null;
            } else {
                this.f10216d.overridePendingTransition(RangesKt___RangesKt.d(a12, 0), RangesKt___RangesKt.d(b11, 0));
                return null;
            }
        } else {
            throw new IllegalStateException(("Destination " + bVar.l() + " does not have an Intent set.").toString());
        }
    }
}
