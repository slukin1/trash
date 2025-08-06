package n8;

import android.content.Context;
import com.hbg.lib.network.newkyc.bean.AuthUserLevelInfo;
import com.hbg.lib.network.newkyc.bean.DominicaKycPageInfo;
import com.hbg.lib.network.newkyc.bean.KycCountryInfo;
import com.hbg.lib.network.newkyc.bean.KycSDKTokenInfo;
import com.hbg.lib.network.newkyc.bean.KycTicketInfo;
import com.hbg.lib.network.newkyc.bean.UnifyKycInfo;
import com.hbg.lib.network.newkyc.bean.UserKycInfoNew;
import d9.a;
import java.util.List;

public interface b {
    void a(String str, Context context, c9.b bVar);

    a<String> b(String str);

    a<KycSDKTokenInfo> c();

    a<KycTicketInfo> d();

    a<String> e(String str, int i11, String str2);

    a<String> f(String str, int i11, String str2);

    a<UserKycInfoNew> getAuthInfo();

    a<AuthUserLevelInfo> getAuthUserLevel();

    a<DominicaKycPageInfo> getDominicaKycPageInfo();

    a<List<KycCountryInfo>> getKycCountryList();

    a<UnifyKycInfo> getUnifyKycInfoV2();
}
