package com.huobi.account.presenter;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.newkyc.bean.DominicaKycPageInfo;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.view.bottompopfragmentmenu.MenuItem;
import java.util.ArrayList;
import java.util.List;
import pro.huobi.R;
import u6.g;
import ug.q;
import ug.r;
import ug.s;
import ug.t;
import ug.u;

public class DominicaKycPagePresenter extends ActivityPresenter<a> {

    /* renamed from: a  reason: collision with root package name */
    public String f41027a;

    public interface a extends g {
        void Ld(DominicaKycPageInfo dominicaKycPageInfo);

        void Wd(List<MenuItem> list);

        void hg(int i11);

        void mh(int i11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void V(DominicaKycPageInfo dominicaKycPageInfo) {
        ((a) getUI()).hg(4);
        ((a) getUI()).Ld(dominicaKycPageInfo);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void W(APIStatusErrorException aPIStatusErrorException) {
        ((a) getUI()).hg(1);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void X(Throwable th2) {
        ((a) getUI()).hg(1);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Y(View view, MenuItem menuItem, int i11) {
        ((a) getUI()).mh(i11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Z(View view, MenuItem menuItem, int i11) {
        ((a) getUI()).mh(i11);
    }

    public void a0() {
        n8.a.a().getDominicaKycPageInfo().b().compose(RxJavaHelper.t((g) getUI())).subscribe(EasySubscriber.create(new s(this), new t(this), new u(this)));
        b0();
    }

    public final void b0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MenuItem("", getString(R.string.n_kyc_dmc_user), MenuItem.MenuItemStyle.STRESS, new r(this)));
        arrayList.add(new MenuItem("", getString(R.string.n_kyc_entity_identity_authentication), MenuItem.MenuItemStyle.COMMON, new q(this)));
        ((a) getUI()).Wd(arrayList);
    }

    /* renamed from: c0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, a aVar) {
        super.onUIReady(baseCoreActivity, aVar);
        Intent intent = baseCoreActivity.getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("type");
            this.f41027a = stringExtra;
            if ("1".equals(stringExtra)) {
                zn.a.d().v(Uri.parse("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/account/kycQuickAuth?authType=1")).a().c();
            }
        }
    }
}
