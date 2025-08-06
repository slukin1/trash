package com.sumsub.sns.internal.fingerprint.infoproviders;

import android.annotation.SuppressLint;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.sumsub.sns.internal.fingerprint.tools.threading.safe.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.jvm.internal.Lambda;

public final class f0 implements e0 {

    /* renamed from: a  reason: collision with root package name */
    public final PackageManager f34603a;

    public static final class a extends Lambda implements d10.a<List<? extends d0>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f0 f34604a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(f0 f0Var) {
            super(0);
            this.f34604a = f0Var;
        }

        /* renamed from: a */
        public final List<d0> invoke() {
            List<ApplicationInfo> installedApplications;
            PackageManager a11 = this.f34604a.f34603a;
            if (a11 == null || (installedApplications = a11.getInstalledApplications(128)) == null) {
                return CollectionsKt__CollectionsKt.k();
            }
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(installedApplications, 10));
            for (ApplicationInfo applicationInfo : installedApplications) {
                String str = applicationInfo != null ? applicationInfo.packageName : null;
                if (str == null) {
                    str = "";
                }
                arrayList.add(new d0(str));
            }
            return arrayList;
        }
    }

    public static final class b extends Lambda implements d10.a<List<? extends d0>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f0 f34605a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(f0 f0Var) {
            super(0);
            this.f34605a = f0Var;
        }

        /* renamed from: a */
        public final List<d0> invoke() {
            String str;
            List<ApplicationInfo> installedApplications = this.f34605a.f34603a.getInstalledApplications(128);
            ArrayList<ApplicationInfo> arrayList = new ArrayList<>();
            for (T next : installedApplications) {
                ApplicationInfo applicationInfo = (ApplicationInfo) next;
                boolean z11 = false;
                if (!(applicationInfo == null || (str = applicationInfo.sourceDir) == null)) {
                    z11 = StringsKt__StringsKt.R(str, "/system/", false, 2, (Object) null);
                }
                if (z11) {
                    arrayList.add(next);
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.u(arrayList, 10));
            for (ApplicationInfo applicationInfo2 : arrayList) {
                String str2 = applicationInfo2 != null ? applicationInfo2.packageName : null;
                if (str2 == null) {
                    str2 = "";
                }
                arrayList2.add(new d0(str2));
            }
            return arrayList2;
        }
    }

    public f0(PackageManager packageManager) {
        this.f34603a = packageManager;
    }

    @SuppressLint({"QueryPermissionsNeeded"})
    public List<d0> b() {
        Object a11 = c.a(3000, new a(this));
        List k11 = CollectionsKt__CollectionsKt.k();
        if (Result.m3078isFailureimpl(a11)) {
            a11 = k11;
        }
        return (List) a11;
    }

    @SuppressLint({"QueryPermissionsNeeded"})
    public List<d0> a() {
        Object a11 = c.a(3000, new b(this));
        List k11 = CollectionsKt__CollectionsKt.k();
        if (Result.m3078isFailureimpl(a11)) {
            a11 = k11;
        }
        return (List) a11;
    }
}
