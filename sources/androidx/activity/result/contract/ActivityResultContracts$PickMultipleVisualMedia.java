package androidx.activity.result.contract;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts$PickVisualMedia;
import com.luck.picture.lib.config.SelectMimeType;
import java.util.List;
import kotlin.jvm.internal.r;

public class ActivityResultContracts$PickMultipleVisualMedia extends ActivityResultContract<PickVisualMediaRequest, List<Uri>> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f3717b = new a((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final int f3718a;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        @SuppressLint({"NewApi", "ClassVerificationFailure"})
        public final int a() {
            if (ActivityResultContracts$PickVisualMedia.f3719a.f()) {
                return MediaStore.getPickImagesMaxLimit();
            }
            return Integer.MAX_VALUE;
        }
    }

    public ActivityResultContracts$PickMultipleVisualMedia() {
        this(0, 1, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ActivityResultContracts$PickMultipleVisualMedia(int i11, int i12, r rVar) {
        this((i12 & 1) != 0 ? f3717b.a() : i11);
    }

    @SuppressLint({"NewApi", "ClassVerificationFailure"})
    /* renamed from: a */
    public Intent createIntent(Context context, PickVisualMediaRequest pickVisualMediaRequest) {
        ActivityResultContracts$PickVisualMedia.a aVar = ActivityResultContracts$PickVisualMedia.f3719a;
        boolean z11 = true;
        if (aVar.f()) {
            Intent intent = new Intent("android.provider.action.PICK_IMAGES");
            intent.setType(aVar.c(pickVisualMediaRequest.a()));
            if (this.f3718a > MediaStore.getPickImagesMaxLimit()) {
                z11 = false;
            }
            if (z11) {
                intent.putExtra("android.provider.extra.PICK_IMAGES_MAX", this.f3718a);
                return intent;
            }
            throw new IllegalArgumentException("Max items must be less or equals MediaStore.getPickImagesMaxLimit()".toString());
        } else if (aVar.e(context)) {
            ResolveInfo b11 = aVar.b(context);
            if (b11 != null) {
                ActivityInfo activityInfo = b11.activityInfo;
                Intent intent2 = new Intent("androidx.activity.result.contract.action.PICK_IMAGES");
                intent2.setClassName(activityInfo.applicationInfo.packageName, activityInfo.name);
                intent2.setType(aVar.c(pickVisualMediaRequest.a()));
                intent2.putExtra("com.google.android.gms.provider.extra.PICK_IMAGES_MAX", this.f3718a);
                return intent2;
            }
            throw new IllegalStateException("Required value was null.".toString());
        } else if (aVar.d(context)) {
            ResolveInfo a11 = aVar.a(context);
            if (a11 != null) {
                ActivityInfo activityInfo2 = a11.activityInfo;
                Intent intent3 = new Intent("com.google.android.gms.provider.action.PICK_IMAGES");
                intent3.setClassName(activityInfo2.applicationInfo.packageName, activityInfo2.name);
                intent3.putExtra("com.google.android.gms.provider.extra.PICK_IMAGES_MAX", this.f3718a);
                return intent3;
            }
            throw new IllegalStateException("Required value was null.".toString());
        } else {
            Intent intent4 = new Intent("android.intent.action.OPEN_DOCUMENT");
            intent4.setType(aVar.c(pickVisualMediaRequest.a()));
            intent4.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            if (intent4.getType() != null) {
                return intent4;
            }
            intent4.setType("*/*");
            intent4.putExtra("android.intent.extra.MIME_TYPES", new String[]{SelectMimeType.SYSTEM_IMAGE, SelectMimeType.SYSTEM_VIDEO});
            return intent4;
        }
    }

    /* renamed from: b */
    public final ActivityResultContract.a<List<Uri>> getSynchronousResult(Context context, PickVisualMediaRequest pickVisualMediaRequest) {
        return null;
    }

    public final List<Uri> parseResult(int i11, Intent intent) {
        List<Uri> a11;
        if (!(i11 == -1)) {
            intent = null;
        }
        return (intent == null || (a11 = ActivityResultContracts$GetMultipleContents.f3716a.a(intent)) == null) ? CollectionsKt__CollectionsKt.k() : a11;
    }

    public ActivityResultContracts$PickMultipleVisualMedia(int i11) {
        this.f3718a = i11;
        if (!(i11 <= 1 ? false : true)) {
            throw new IllegalArgumentException("Max items must be higher than 1".toString());
        }
    }
}
