package tu;

import android.graphics.Bitmap;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.share.fragment.H5ImageShareFragment;
import com.huobi.share.fragment.ImageShareFragment;
import com.huobi.sharev2.bean.ShareInfo;
import com.nostra13.universalimageloader.core.assist.FailReason;
import pro.huobi.R;
import v6.u;

public class a implements tx.a {

    /* renamed from: a  reason: collision with root package name */
    public final u f23401a;

    /* renamed from: b  reason: collision with root package name */
    public ShareInfo f23402b;

    public a(u uVar, ShareInfo shareInfo) {
        this.f23401a = uVar;
        this.f23402b = shareInfo;
    }

    public static boolean f(u uVar) {
        if (uVar == null) {
            return false;
        }
        Object tag = uVar.getWebView().getTag();
        if (tag instanceof ImageShareFragment) {
            return ((ImageShareFragment) tag).isResumed();
        }
        return false;
    }

    public void a(String str, View view) {
        u uVar = this.f23401a;
        if (uVar != null && uVar.isAlive()) {
            this.f23401a.showProgressDialog();
        }
    }

    public void b(String str, View view, FailReason failReason) {
        u uVar = this.f23401a;
        if (uVar != null) {
            uVar.dismissProgressDialog();
        }
        HuobiToastUtil.g(R.string.server_error);
    }

    public void c(String str, View view, Bitmap bitmap) {
        u uVar = this.f23401a;
        if (uVar != null && uVar.getActivity() != null && this.f23401a.isAlive() && !f(this.f23401a)) {
            H5ImageShareFragment e11 = e(this.f23402b, bitmap);
            this.f23401a.dismissProgressDialog();
            e11.show(((FragmentActivity) this.f23401a.getActivity()).getSupportFragmentManager(), "doShareImage[16]");
            this.f23401a.getWebView().setTag(e11);
        }
    }

    public void d(String str, View view) {
        u uVar = this.f23401a;
        if (uVar != null) {
            uVar.dismissProgressDialog();
        }
    }

    public final H5ImageShareFragment e(ShareInfo shareInfo, Bitmap bitmap) {
        H5ImageShareFragment h5ImageShareFragment = new H5ImageShareFragment();
        h5ImageShareFragment.di(!shareInfo.getSource().equals("liveGroup") && shareInfo.isShowNativeQr());
        h5ImageShareFragment.Mh(shareInfo.getCondition());
        h5ImageShareFragment.hi(shareInfo.getShareUrl());
        h5ImageShareFragment.fi(shareInfo.getQrUrl());
        h5ImageShareFragment.Nh(shareInfo.getCopyText());
        h5ImageShareFragment.ei(shareInfo.getParseUrl());
        h5ImageShareFragment.gi(shareInfo.getShareText());
        is.a.y(shareInfo.getExtend());
        h5ImageShareFragment.Oh(shareInfo.getExtend());
        h5ImageShareFragment.ai(bitmap);
        h5ImageShareFragment.bi(((float) bitmap.getHeight()) / ((float) bitmap.getWidth()));
        return h5ImageShareFragment;
    }
}
