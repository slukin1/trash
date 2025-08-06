package rc;

import com.hbg.lib.network.hbg.core.bean.CommentInfo;

public interface a {

    /* renamed from: rc.a$a  reason: collision with other inner class name */
    public static final class C0133a {
        public static /* synthetic */ void a(a aVar, CommentInfo commentInfo, int i11, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 2) != 0) {
                    i11 = 0;
                }
                aVar.a(commentInfo, i11);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resultCallBack");
        }
    }

    void a(CommentInfo commentInfo, int i11);

    void b();
}
