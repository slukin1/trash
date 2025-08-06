package oupson.apng;

import d10.p;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;

@d(c = "oupson.apng.Loader$Companion$load$2", f = "Loader.kt", l = {}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\u0010\u0005\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0000H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/h0;", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class Loader$Companion$load$2 extends SuspendLambda implements p<h0, c<? super byte[]>, Object> {
    public final /* synthetic */ URL $url;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Loader$Companion$load$2(URL url, c cVar) {
        super(2, cVar);
        this.$url = url;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new Loader$Companion$load$2(this.$url, cVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((Loader$Companion$load$2) create(obj, (c) obj2)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        int read;
        Object unused = IntrinsicsKt__IntrinsicsKt.d();
        if (this.label == 0) {
            k.b(obj);
            URLConnection openConnection = this.$url.openConnection();
            Objects.requireNonNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setUseCaches(true);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[4096];
                do {
                    read = bufferedInputStream.read(bArr);
                    if (read > -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                        continue;
                    }
                } while (read != -1);
                bufferedInputStream.close();
                byteArrayOutputStream.close();
                httpURLConnection.disconnect();
                return byteArrayOutputStream.toByteArray();
            }
            httpURLConnection.disconnect();
            throw new Exception("Error when downloading file : " + httpURLConnection.getResponseCode());
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
