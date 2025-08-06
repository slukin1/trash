package ed;

import com.hbg.module.huobi.im.RedPoint.AbsRedPointNodeImp;
import java.util.ArrayList;
import java.util.List;

public class a extends AbsRedPointNodeImp {

    /* renamed from: c  reason: collision with root package name */
    public List<AbsRedPointNodeImp> f22749c;

    public a(List<AbsRedPointNodeImp> list) {
        this.f22749c = list;
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                list.get(i11).d(this);
            }
        }
    }

    public boolean a() {
        List<AbsRedPointNodeImp> list = this.f22749c;
        if (list == null || list.isEmpty()) {
            return false;
        }
        int size = this.f22749c.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (this.f22749c.get(i11).a()) {
                return true;
            }
        }
        return false;
    }

    public int b() {
        List<AbsRedPointNodeImp> list = this.f22749c;
        if (list == null || list.isEmpty()) {
            return 0;
        }
        int size = this.f22749c.size();
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            i11 += this.f22749c.get(i12).b();
        }
        return i11;
    }

    public void f(AbsRedPointNodeImp absRedPointNodeImp) {
        if (absRedPointNodeImp != null) {
            if (this.f22749c == null) {
                this.f22749c = new ArrayList();
            }
            if (!this.f22749c.contains(absRedPointNodeImp)) {
                this.f22749c.add(absRedPointNodeImp);
                absRedPointNodeImp.d(this);
            }
        }
    }
}
