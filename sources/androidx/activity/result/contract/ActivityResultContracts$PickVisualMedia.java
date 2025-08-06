package androidx.activity.result.contract;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.ext.SdkExtensions;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContract;
import com.luck.picture.lib.config.SelectMimeType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.r;

public class ActivityResultContracts$PickVisualMedia extends ActivityResultContract<PickVisualMediaRequest, Uri> {

    /* renamed from: a  reason: collision with root package name */
    public static final a f3719a = new a((r) null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final ResolveInfo a(Context context) {
            return context.getPackageManager().resolveActivity(new Intent("com.google.android.gms.provider.action.PICK_IMAGES"), 1114112);
        }

        public final ResolveInfo b(Context context) {
            return context.getPackageManager().resolveActivity(new Intent("androidx.activity.result.contract.action.PICK_IMAGES"), 1114112);
        }

        public final String c(d dVar) {
            if (dVar instanceof c) {
                return ((c) dVar).a();
            }
            if (dVar instanceof b) {
                return null;
            }
            throw new NoWhenBranchMatchedException();
        }

        public final boolean d(Context context) {
            return a(context) != null;
        }

        public final boolean e(Context context) {
            return b(context) != null;
        }

        @SuppressLint({"ClassVerificationFailure", "NewApi"})
        public final boolean f() {
            int i11 = Build.VERSION.SDK_INT;
            return i11 >= 33 || (i11 >= 30 && SdkExtensions.getExtensionVersion(30) >= 2);
        }
    }

    public static final class b implements d {

        /* renamed from: a  reason: collision with root package name */
        public static final b f3720a = new b();
    }

    public static final class c implements d {

        /* renamed from: a  reason: collision with root package name */
        public final String f3721a;

        public final String a() {
            return this.f3721a;
        }
    }

    public interface d {
    }

    /* renamed from: a */
    public Intent createIntent(Context context, PickVisualMediaRequest pickVisualMediaRequest) {
        Intent intent;
        a aVar = f3719a;
        if (aVar.f()) {
            Intent intent2 = new Intent("android.provider.action.PICK_IMAGES");
            intent2.setType(aVar.c(pickVisualMediaRequest.a()));
            return intent2;
        }
        if (aVar.e(context)) {
            ResolveInfo b11 = aVar.b(context);
            if (b11 != null) {
                ActivityInfo activityInfo = b11.activityInfo;
                intent = new Intent("androidx.activity.result.contract.action.PICK_IMAGES");
                intent.setClassName(activityInfo.applicationInfo.packageName, activityInfo.name);
                intent.setType(aVar.c(pickVisualMediaRequest.a()));
            } else {
                throw new IllegalStateException("Required value was null.".toString());
            }
        } else if (aVar.d(context)) {
            ResolveInfo a11 = aVar.a(context);
            if (a11 != null) {
                ActivityInfo activityInfo2 = a11.activityInfo;
                intent = new Intent("com.google.android.gms.provider.action.PICK_IMAGES");
                intent.setClassName(activityInfo2.applicationInfo.packageName, activityInfo2.name);
                intent.setType(aVar.c(pickVisualMediaRequest.a()));
            } else {
                throw new IllegalStateException("Required value was null.".toString());
            }
        } else {
            Intent intent3 = new Intent("android.intent.action.OPEN_DOCUMENT");
            intent3.setType(aVar.c(pickVisualMediaRequest.a()));
            if (intent3.getType() != null) {
                return intent3;
            }
            intent3.setType("*/*");
            intent3.putExtra("android.intent.extra.MIME_TYPES", new String[]{SelectMimeType.SYSTEM_IMAGE, SelectMimeType.SYSTEM_VIDEO});
            return intent3;
        }
        return intent;
    }

    /* renamed from: b */
    public final ActivityResultContract.a<Uri> getSynchronousResult(Context context, PickVisualMediaRequest pickVisualMediaRequest) {
        return null;
    }

    public final Uri parseResult(int i11, Intent intent) {
        if (!(i11 == -1)) {
            intent = null;
        }
        if (intent == null) {
            return null;
        }
        Uri data = intent.getData();
        if (data == null) {
            data = (Uri) CollectionsKt___CollectionsKt.c0(ActivityResultContracts$GetMultipleContents.f3716a.a(intent));
        }
        return data;
    }
}
