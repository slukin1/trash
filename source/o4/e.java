package o4;

import android.content.Context;
import com.example.flutterimagecompress.FlutterImageCompressPlugin;
import com.example.flutterimagecompress.exception.CompressError;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.io.ByteArrayOutputStream;
import java.util.List;
import p4.a;

public final class e extends g {

    /* renamed from: f  reason: collision with root package name */
    public final MethodCall f66537f;

    public e(MethodCall methodCall, MethodChannel.Result result) {
        super(result);
        this.f66537f = methodCall;
    }

    public static final void g(e eVar, Context context) {
        int i11;
        List list = (List) eVar.f66537f.arguments;
        int i12 = 0;
        byte[] bArr = (byte[]) list.get(0);
        int intValue = ((Integer) list.get(1)).intValue();
        int intValue2 = ((Integer) list.get(2)).intValue();
        int intValue3 = ((Integer) list.get(3)).intValue();
        int intValue4 = ((Integer) list.get(4)).intValue();
        boolean booleanValue = ((Boolean) list.get(5)).booleanValue();
        int intValue5 = ((Integer) list.get(6)).intValue();
        boolean booleanValue2 = ((Boolean) list.get(7)).booleanValue();
        int intValue6 = ((Integer) list.get(8)).intValue();
        if (booleanValue) {
            i12 = a.f66556a.b(bArr);
        }
        if (i12 == 90 || i12 == 270) {
            i11 = intValue;
            intValue = intValue2;
        } else {
            i11 = intValue2;
        }
        s4.a a11 = r4.a.f66597a.a(intValue5);
        if (a11 == null) {
            u4.a.a(eVar, "No support format.");
            eVar.c((Object) null);
            return;
        }
        int i13 = intValue4 + i12;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            a11.a(context, bArr, byteArrayOutputStream, intValue, i11, intValue3, i13, booleanValue2, intValue6);
            eVar.c(byteArrayOutputStream.toByteArray());
        } catch (CompressError e11) {
            u4.a.a(eVar, e11.getMessage());
            if (FlutterImageCompressPlugin.f64984d.a()) {
                e11.printStackTrace();
            }
            eVar.c((Object) null);
        } catch (Exception e12) {
            if (FlutterImageCompressPlugin.f64984d.a()) {
                e12.printStackTrace();
            }
            eVar.c((Object) null);
        } catch (Throwable th2) {
            byteArrayOutputStream.close();
            throw th2;
        }
        byteArrayOutputStream.close();
    }

    public final void f(Context context) {
        g.f66538c.a().execute(new d(this, context));
    }
}
