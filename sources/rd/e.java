package rd;

import com.tencent.imsdk.v2.V2TIMUserFullInfo;

public interface e {

    public static final class a {
        public static void a(e eVar, int i11, String str) {
        }

        public static /* synthetic */ void b(e eVar, int i11, String str, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 1) != 0) {
                    i11 = 0;
                }
                if ((i12 & 2) != 0) {
                    str = null;
                }
                eVar.a(i11, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: error");
        }

        public static void c(e eVar, V2TIMUserFullInfo v2TIMUserFullInfo) {
            eVar.c(v2TIMUserFullInfo.getFaceUrl(), v2TIMUserFullInfo.getNickName());
        }

        public static void d(e eVar, String str, String str2) {
        }
    }

    void a(int i11, String str);

    void b(V2TIMUserFullInfo v2TIMUserFullInfo);

    void c(String str, String str2);
}
