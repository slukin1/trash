package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.r;
import kotlin.l;

public final class ActivityResultContracts$RequestMultiplePermissions extends ActivityResultContract<String[], Map<String, Boolean>> {

    /* renamed from: a  reason: collision with root package name */
    public static final a f3722a = new a((r) null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final Intent a(String[] strArr) {
            return new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr);
        }
    }

    /* renamed from: a */
    public Intent createIntent(Context context, String[] strArr) {
        return f3722a.a(strArr);
    }

    /* renamed from: b */
    public ActivityResultContract.a<Map<String, Boolean>> getSynchronousResult(Context context, String[] strArr) {
        boolean z11 = true;
        if (strArr.length == 0) {
            return new ActivityResultContract.a<>(MapsKt__MapsKt.h());
        }
        int length = strArr.length;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                break;
            }
            if (!(ContextCompat.checkSelfPermission(context, strArr[i11]) == 0)) {
                z11 = false;
                break;
            }
            i11++;
        }
        if (!z11) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.d(MapsKt__MapsJVMKt.d(strArr.length), 16));
        for (String a11 : strArr) {
            Pair a12 = l.a(a11, Boolean.TRUE);
            linkedHashMap.put(a12.getFirst(), a12.getSecond());
        }
        return new ActivityResultContract.a<>(linkedHashMap);
    }

    /* renamed from: c */
    public Map<String, Boolean> parseResult(int i11, Intent intent) {
        if (i11 != -1) {
            return MapsKt__MapsKt.h();
        }
        if (intent == null) {
            return MapsKt__MapsKt.h();
        }
        String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
        int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
        if (intArrayExtra == null || stringArrayExtra == null) {
            return MapsKt__MapsKt.h();
        }
        ArrayList arrayList = new ArrayList(intArrayExtra.length);
        int length = intArrayExtra.length;
        for (int i12 = 0; i12 < length; i12++) {
            arrayList.add(Boolean.valueOf(intArrayExtra[i12] == 0));
        }
        return MapsKt__MapsKt.s(CollectionsKt___CollectionsKt.Q0(ArraysKt___ArraysKt.F(stringArrayExtra), arrayList));
    }
}
