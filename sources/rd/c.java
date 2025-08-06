package rd;

import android.text.TextUtils;
import com.hbg.lib.network.hbg.core.bean.GroupInfoData;
import ld.e;
import ld.f;

public class c {

    /* renamed from: c  reason: collision with root package name */
    public static c f23348c;

    /* renamed from: a  reason: collision with root package name */
    public String f23349a;

    /* renamed from: b  reason: collision with root package name */
    public GroupInfoData f23350b;

    public class a implements kd.a<GroupInfoData> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ kd.a f23351a;

        public a(kd.a aVar) {
            this.f23351a = aVar;
        }

        /* renamed from: a */
        public void onSuccess(GroupInfoData groupInfoData) {
            GroupInfoData unused = c.this.f23350b = groupInfoData;
            kd.a aVar = this.f23351a;
            if (aVar != null) {
                aVar.onSuccess(groupInfoData);
            }
        }

        public void onFailed(int i11, String str) {
            kd.a aVar = this.f23351a;
            if (aVar != null) {
                aVar.onFailed(i11, str);
            }
        }
    }

    public static c b() {
        if (f23348c == null) {
            f23348c = new c();
        }
        return f23348c;
    }

    public void c(kd.a<GroupInfoData> aVar) {
        if (!TextUtils.isEmpty(this.f23349a)) {
            GroupInfoData groupInfoData = this.f23350b;
            if (groupInfoData == null) {
                new f((e) null).r(this.f23349a, new a(aVar));
            } else if (aVar != null) {
                aVar.onSuccess(groupInfoData);
            }
        } else if (aVar != null) {
            aVar.onFailed(-1, (String) null);
        }
    }

    public void d() {
        int userCount;
        GroupInfoData groupInfoData = this.f23350b;
        if (groupInfoData != null && (userCount = groupInfoData.getUserCount()) > 0) {
            this.f23350b.setUserCount(userCount - 1);
        }
    }

    public void e() {
        this.f23350b = null;
        f23348c = null;
    }

    public void f() {
        this.f23350b = null;
    }

    public void g(String str) {
        this.f23349a = str;
    }
}
