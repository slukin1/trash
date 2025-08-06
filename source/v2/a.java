package v2;

import android.util.Log;
import java.util.Random;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f16699a;

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f16700a = new a();
    }

    public a() {
        try {
            Random random = new Random();
            char[] cArr = new char[12];
            for (int i11 = 0; i11 < 12; i11++) {
                cArr[i11] = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".charAt(random.nextInt(62));
            }
            this.f16699a = new String(cArr);
        } catch (Exception e11) {
            Log.d("SessionTrackMgr", e11.getMessage(), e11);
        }
    }

    public static a a() {
        return b.f16700a;
    }

    public String b() {
        return this.f16699a;
    }
}
