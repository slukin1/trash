package y4;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Priority;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.b;
import com.fluttercandies.photo_manager.core.entity.f;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.io.ByteArrayOutputStream;
import java.io.File;
import kotlin.jvm.internal.r;
import z4.e;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f66718a = new a();

    public final void a(Context context) {
        com.bumptech.glide.a.d(context).b();
    }

    public final void b(Context context, String str, int i11, int i12, Bitmap.CompressFormat compressFormat, int i13, long j11, MethodChannel.Result result) {
        e eVar = new e(result, (MethodCall) null, 2, (r) null);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ((Bitmap) com.bumptech.glide.a.v(context).b().b(((RequestOptions) new RequestOptions().p(j11)).c0(Priority.IMMEDIATE)).J0(new File(str)).S0(i11, i12).get()).compress(compressFormat, i13, byteArrayOutputStream);
            eVar.h(byteArrayOutputStream.toByteArray());
        } catch (Exception unused) {
            eVar.h((Object) null);
        }
    }

    public final b<Bitmap> c(Context context, String str, f fVar) {
        return com.bumptech.glide.a.v(context).b().b(((RequestOptions) new RequestOptions().p(fVar.b())).c0(Priority.LOW)).M0(str).S0(fVar.e(), fVar.c());
    }
}
