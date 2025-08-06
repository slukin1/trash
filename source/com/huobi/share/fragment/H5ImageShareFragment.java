package com.huobi.share.fragment;

import android.text.TextUtils;
import com.huobi.invite.bean.InviteSharePlatformListItem;
import com.huobi.social.share.HBShareHelper;
import com.huochat.community.util.ClipManager;
import java.util.List;
import pro.huobi.R;

public class H5ImageShareFragment extends ImageShareFragment {
    public String J;
    public String K;
    public String L;
    public String M;

    public boolean Hh() {
        return "enableFacebook".equals(this.f80885s) || TtmlNode.COMBINE_ALL.equals(this.f80885s);
    }

    public String Vh() {
        if (TextUtils.isEmpty(this.K)) {
            return super.Vh();
        }
        return this.K;
    }

    public void ei(String str) {
        this.L = str;
    }

    public void fi(String str) {
        this.K = str;
    }

    public void gi(String str) {
        this.M = str;
    }

    public void hi(String str) {
        this.J = str;
    }

    public void i0(HBShareHelper.HbPlatform hbPlatform) {
        if (hbPlatform == HBShareHelper.HbPlatform.TYPE_FACEBOOK) {
            if (!TextUtils.isEmpty(this.J)) {
                HBShareHelper hBShareHelper = new HBShareHelper(getActivity(), hbPlatform);
                this.f80871e = hBShareHelper;
                hBShareHelper.h(this.J);
                return;
            }
        } else if (hbPlatform == HBShareHelper.HbPlatform.TYPE_COPY_TEXT) {
            HBShareHelper hBShareHelper2 = new HBShareHelper(getActivity(), hbPlatform);
            this.f80871e = hBShareHelper2;
            hBShareHelper2.e("", this.f80886t, "");
            return;
        }
        String str = this.M;
        if (TextUtils.isEmpty(str)) {
            str = getString(R.string.n_share_default_ten_year);
        }
        ClipManager.copy(str + Eh(this.L));
        super.i0(hbPlatform);
    }

    public void zh(List<InviteSharePlatformListItem> list) {
    }
}
