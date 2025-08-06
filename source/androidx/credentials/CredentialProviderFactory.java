package androidx.credentials;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.r;

public final class CredentialProviderFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final a f8747a = new a((r) null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final List<String> a(Context context) {
            String string;
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 132);
            ArrayList arrayList = new ArrayList();
            ServiceInfo[] serviceInfoArr = packageInfo.services;
            if (serviceInfoArr != null) {
                for (ServiceInfo serviceInfo : serviceInfoArr) {
                    Bundle bundle = serviceInfo.metaData;
                    if (!(bundle == null || (string = bundle.getString("androidx.credentials.CREDENTIAL_PROVIDER_KEY")) == null)) {
                        arrayList.add(string);
                    }
                }
            }
            return CollectionsKt___CollectionsKt.I0(arrayList);
        }

        public final j b(Context context) {
            return d(context);
        }

        public final j c(List<String> list, Context context) {
            j jVar = null;
            for (String cls : list) {
                try {
                    j jVar2 = (j) Class.forName(cls).getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context});
                    if (!jVar2.isAvailableOnDevice()) {
                        continue;
                    } else if (jVar != null) {
                        Log.i("CredProviderFactory", "Only one active OEM CredentialProvider allowed");
                        return null;
                    } else {
                        jVar = jVar2;
                    }
                } catch (Throwable unused) {
                }
            }
            return jVar;
        }

        public final j d(Context context) {
            List<String> a11 = a(context);
            if (a11.isEmpty()) {
                return null;
            }
            return c(a11, context);
        }
    }
}
