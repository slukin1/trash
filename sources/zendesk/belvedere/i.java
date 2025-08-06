package zendesk.belvedere;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.luck.picture.lib.permissions.PermissionConfig;
import f30.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class i {

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f62334b = {PermissionConfig.READ_MEDIA_IMAGES, PermissionConfig.READ_MEDIA_VIDEO};

    /* renamed from: a  reason: collision with root package name */
    public c f62335a = null;

    public class a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f62336a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f62337b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f62338c;

        public a(Context context, List list, d dVar) {
            this.f62336a = context;
            this.f62337b = list;
            this.f62338c = dVar;
        }

        public void a(Map<String, Boolean> map) {
            List a11 = i.this.f(this.f62336a, this.f62337b);
            if (i.this.e(this.f62336a)) {
                this.f62338c.a(a11);
            } else {
                this.f62338c.b();
            }
        }
    }

    public class b implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f62340a;

        public b(c cVar) {
            this.f62340a = cVar;
        }

        public void a(Map<String, Boolean> map) {
            this.f62340a.a(map);
            i.this.k((c) null);
        }
    }

    public interface c {
        void a(Map<String, Boolean> map);
    }

    public interface d {
        void a(List<MediaIntent> list);

        void b();
    }

    public void d(Fragment fragment, List<String> list, c cVar) {
        k(new b(cVar));
        fragment.requestPermissions((String[]) list.toArray(new String[list.size()]), 9842);
    }

    public final boolean e(Context context) {
        boolean z11;
        int i11 = Build.VERSION.SDK_INT;
        boolean z12 = i11 < 19;
        if (i11 >= 33) {
            z11 = f.c(context, f62334b);
        } else {
            z11 = f.b(context, PermissionConfig.READ_EXTERNAL_STORAGE);
        }
        if (z12 || z11) {
            return true;
        }
        return false;
    }

    public final List<MediaIntent> f(Context context, List<MediaIntent> list) {
        ArrayList arrayList = new ArrayList();
        for (MediaIntent next : list) {
            if (next.isAvailable()) {
                if (TextUtils.isEmpty(next.getPermission())) {
                    arrayList.add(next);
                } else if (f.b(context, next.getPermission())) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public final List<String> g(Context context) {
        ArrayList arrayList = new ArrayList();
        if (!e(context)) {
            if (Build.VERSION.SDK_INT >= 33) {
                Collections.addAll(arrayList, f62334b);
            } else {
                arrayList.add(PermissionConfig.READ_EXTERNAL_STORAGE);
            }
        }
        return arrayList;
    }

    public final List<String> h(List<MediaIntent> list) {
        ArrayList arrayList = new ArrayList();
        for (MediaIntent next : list) {
            if (!TextUtils.isEmpty(next.getPermission()) && next.isAvailable()) {
                arrayList.add(next.getPermission());
            }
        }
        return arrayList;
    }

    public void i(Fragment fragment, List<MediaIntent> list, d dVar) {
        Context context = fragment.getContext();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(g(context));
        arrayList.addAll(h(list));
        if (e(context) && arrayList.isEmpty()) {
            dVar.a(f(context, list));
        } else if (e(context) || !arrayList.isEmpty()) {
            d(fragment, arrayList, new a(context, list, dVar));
        } else {
            dVar.b();
        }
    }

    public boolean j(int i11, String[] strArr, int[] iArr) {
        if (i11 != 9842) {
            return false;
        }
        HashMap hashMap = new HashMap();
        int length = strArr.length;
        for (int i12 = 0; i12 < length; i12++) {
            if (iArr[i12] == 0) {
                hashMap.put(strArr[i12], Boolean.TRUE);
            } else if (iArr[i12] == -1) {
                hashMap.put(strArr[i12], Boolean.FALSE);
            }
        }
        c cVar = this.f62335a;
        if (cVar == null) {
            return true;
        }
        cVar.a(hashMap);
        return true;
    }

    public final void k(c cVar) {
        this.f62335a = cVar;
    }
}
