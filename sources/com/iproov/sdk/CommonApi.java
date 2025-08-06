package com.iproov.sdk;

import android.content.Context;
import androidx.annotation.Keep;
import com.iproov.sdk.core.exception.UnexpectedErrorException;
import com.iproov.sdk.p031this.Cif;
import com.jumio.core.environment.Environment;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\bg\u0018\u00002\u00020\u0001:\u0001\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&R\u0016\u0010\t\u001a\u00020\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0016\u0010\r\u001a\u00020\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/iproov/sdk/CommonApi;", "", "Landroid/content/Context;", "context", "Lcom/iproov/sdk/CommonApi$KeyPair;", "getKeyPair", "", "getBuildHash", "()Ljava/lang/String;", "buildHash", "getBuildNumber", "buildNumber", "getSdkVersion", "sdkVersion", "KeyPair", "iproov_release"}, k = 1, mv = {1, 5, 1})
@Keep
public interface CommonApi {

    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&R\u0016\u0010\b\u001a\u00020\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/iproov/sdk/CommonApi$KeyPair;", "", "", "data", "sign", "Lcom/iproov/sdk/this/if;", "getPublicKey", "()Lcom/iproov/sdk/this/if;", "publicKey", "iproov_release"}, k = 1, mv = {1, 5, 1})
    public interface KeyPair {
        Cif getPublicKey();

        byte[] sign(byte[] bArr);
    }

    /* renamed from: com.iproov.sdk.CommonApi$do  reason: invalid class name */
    public static final class Cdo {
        /* renamed from: do  reason: not valid java name */
        public static String m54do(CommonApi commonApi) {
            return "952589e9 ";
        }

        /* renamed from: for  reason: not valid java name */
        public static String m55for(CommonApi commonApi) {
            return Environment.IPROOV_VERSION;
        }

        /* renamed from: if  reason: not valid java name */
        public static String m56if(CommonApi commonApi) {
            return "8768";
        }
    }

    String getBuildHash();

    String getBuildNumber();

    KeyPair getKeyPair(Context context) throws UnexpectedErrorException;

    String getSdkVersion();
}
