package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import p0.q;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f8320a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static Field f8321b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f8322c;

    /* renamed from: d  reason: collision with root package name */
    public static final Object f8323d = new Object();

    public static SparseArray<Bundle> a(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int i11 = 0; i11 < size; i11++) {
            Bundle bundle = list.get(i11);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i11, bundle);
            }
        }
        return sparseArray;
    }

    public static q b(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("allowedDataTypes");
        HashSet hashSet = new HashSet();
        if (stringArrayList != null) {
            Iterator<String> it2 = stringArrayList.iterator();
            while (it2.hasNext()) {
                hashSet.add(it2.next());
            }
        }
        return new q(bundle.getString("resultKey"), bundle.getCharSequence("label"), bundle.getCharSequenceArray("choices"), bundle.getBoolean("allowFreeFormInput"), 0, bundle.getBundle("extras"), hashSet);
    }

    public static q[] c(Bundle[] bundleArr) {
        if (bundleArr == null) {
            return null;
        }
        q[] qVarArr = new q[bundleArr.length];
        for (int i11 = 0; i11 < bundleArr.length; i11++) {
            qVarArr[i11] = b(bundleArr[i11]);
        }
        return qVarArr;
    }

    public static NotificationCompat.Action d(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("extras");
        boolean z11 = false;
        if (bundle2 != null) {
            z11 = bundle2.getBoolean("android.support.allowGeneratedReplies", false);
        }
        return new NotificationCompat.Action(bundle.getInt("icon"), bundle.getCharSequence("title"), (PendingIntent) bundle.getParcelable("actionIntent"), bundle.getBundle("extras"), c(e(bundle, "remoteInputs")), c(e(bundle, "dataOnlyRemoteInputs")), z11, bundle.getInt("semanticAction"), bundle.getBoolean("showsUserInterface"), false, false);
    }

    public static Bundle[] e(Bundle bundle, String str) {
        Parcelable[] parcelableArray = bundle.getParcelableArray(str);
        if ((parcelableArray instanceof Bundle[]) || parcelableArray == null) {
            return (Bundle[]) parcelableArray;
        }
        Bundle[] bundleArr = (Bundle[]) Arrays.copyOf(parcelableArray, parcelableArray.length, Bundle[].class);
        bundle.putParcelableArray(str, bundleArr);
        return bundleArr;
    }

    public static Bundle f(NotificationCompat.Action action) {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        IconCompat f11 = action.f();
        bundle2.putInt("icon", f11 != null ? f11.n() : 0);
        bundle2.putCharSequence("title", action.j());
        bundle2.putParcelable("actionIntent", action.a());
        if (action.d() != null) {
            bundle = new Bundle(action.d());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", action.b());
        bundle2.putBundle("extras", bundle);
        bundle2.putParcelableArray("remoteInputs", i(action.g()));
        bundle2.putBoolean("showsUserInterface", action.i());
        bundle2.putInt("semanticAction", action.h());
        return bundle2;
    }

    public static Bundle g(Notification notification) {
        synchronized (f8320a) {
            if (f8322c) {
                return null;
            }
            try {
                if (f8321b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        f8322c = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    f8321b = declaredField;
                }
                Bundle bundle = (Bundle) f8321b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f8321b.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e11) {
                Log.e("NotificationCompat", "Unable to access notification extras", e11);
                f8322c = true;
                return null;
            } catch (NoSuchFieldException e12) {
                Log.e("NotificationCompat", "Unable to access notification extras", e12);
                f8322c = true;
                return null;
            }
        }
    }

    public static Bundle h(q qVar) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", qVar.j());
        bundle.putCharSequence("label", qVar.i());
        bundle.putCharSequenceArray("choices", qVar.f());
        bundle.putBoolean("allowFreeFormInput", qVar.d());
        bundle.putBundle("extras", qVar.h());
        Set<String> e11 = qVar.e();
        if (e11 != null && !e11.isEmpty()) {
            ArrayList arrayList = new ArrayList(e11.size());
            for (String add : e11) {
                arrayList.add(add);
            }
            bundle.putStringArrayList("allowedDataTypes", arrayList);
        }
        return bundle;
    }

    public static Bundle[] i(q[] qVarArr) {
        if (qVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[qVarArr.length];
        for (int i11 = 0; i11 < qVarArr.length; i11++) {
            bundleArr[i11] = h(qVarArr[i11]);
        }
        return bundleArr;
    }

    public static Bundle j(Notification.Builder builder, NotificationCompat.Action action) {
        IconCompat f11 = action.f();
        builder.addAction(f11 != null ? f11.n() : 0, action.j(), action.a());
        Bundle bundle = new Bundle(action.d());
        if (action.g() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", i(action.g()));
        }
        if (action.c() != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", i(action.c()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", action.b());
        return bundle;
    }
}
