package androidx.activity.result.contract;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.contract.ActivityResultContract;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.internal.r;

public class ActivityResultContracts$GetMultipleContents extends ActivityResultContract<String, List<Uri>> {

    /* renamed from: a  reason: collision with root package name */
    public static final a f3716a = new a((r) null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final List<Uri> a(Intent intent) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Uri data = intent.getData();
            if (data != null) {
                linkedHashSet.add(data);
            }
            ClipData clipData = intent.getClipData();
            if (clipData == null && linkedHashSet.isEmpty()) {
                return CollectionsKt__CollectionsKt.k();
            }
            if (clipData != null) {
                int itemCount = clipData.getItemCount();
                for (int i11 = 0; i11 < itemCount; i11++) {
                    Uri uri = clipData.getItemAt(i11).getUri();
                    if (uri != null) {
                        linkedHashSet.add(uri);
                    }
                }
            }
            return new ArrayList(linkedHashSet);
        }
    }

    /* renamed from: a */
    public final ActivityResultContract.a<List<Uri>> getSynchronousResult(Context context, String str) {
        return null;
    }

    public Intent createIntent(Context context, String str) {
        return new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(str).putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
    }

    public final List<Uri> parseResult(int i11, Intent intent) {
        List<Uri> a11;
        if (!(i11 == -1)) {
            intent = null;
        }
        return (intent == null || (a11 = f3716a.a(intent)) == null) ? CollectionsKt__CollectionsKt.k() : a11;
    }
}
