package a3;

import com.alibaba.sdk.android.tbrest.utils.LogUtil;
import com.alibaba.sdk.android.tbrest.utils.MD5Utils;
import com.alibaba.sdk.android.tbrest.utils.RC4;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import net.sf.scuba.smartcards.ISO7816;
import net.sf.scuba.smartcards.ISOFileInfo;
import org.jmrtd.lds.CVCAFile;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f3485a = false;

    /* renamed from: b  reason: collision with root package name */
    public String f3486b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f3487c = null;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f3488d = null;

    public a(String str, String str2, boolean z11) {
        this.f3486b = str;
        this.f3487c = str2;
        this.f3485a = z11;
    }

    public static String a(byte[] bArr, byte[] bArr2) throws Exception {
        Mac instance = Mac.getInstance("HmacSHA1");
        instance.init(new SecretKeySpec(bArr, instance.getAlgorithm()));
        return MD5Utils.c(instance.doFinal(bArr2));
    }

    public final byte[] b() {
        if (this.f3488d == null) {
            this.f3488d = RC4.c(new byte[]{CVCAFile.CAR_TAG, 37, ISO7816.INS_PSO, -119, 118, -104, ISO7816.INS_APPEND_RECORD, 4, ISOFileInfo.A1, 15, -26, -12, -75, -102, 71, 23, -3, -120, -1, -57, ISO7816.INS_PSO, 99, -16, -101, 103, ISO7816.INS_READ_RECORD_STAMPED, 93, ISOFileInfo.CHANNEL_SECURITY, ISO7816.INS_MANAGE_CHANNEL, -26, -24, -24});
        }
        return this.f3488d;
    }

    public String c(String str) {
        String str2;
        if (this.f3486b == null || (str2 = this.f3487c) == null) {
            LogUtil.b("There is no appkey,please check it!");
            return null;
        } else if (str == null) {
            return null;
        } else {
            try {
                if (this.f3485a) {
                    return a(str2.getBytes(), str.getBytes());
                }
                return a(b(), str.getBytes());
            } catch (Exception unused) {
                return "";
            }
        }
    }
}
