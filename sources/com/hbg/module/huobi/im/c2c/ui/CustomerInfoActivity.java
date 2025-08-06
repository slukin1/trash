package com.hbg.module.huobi.im.c2c.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import androidx.lifecycle.MutableLiveData;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.network.hbg.core.bean.CustomerInfo;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.huobi.im.R$string;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.base.ui.BaseActivity;
import com.tencent.android.tpush.common.Constants;
import com.tencent.qcloud.tuicore.TUIConstants;
import fd.a;
import v7.b;

@Route(path = "/im/accountManager")
public final class CustomerInfoActivity extends BaseActivity<a> {

    /* renamed from: i  reason: collision with root package name */
    public String f19650i;

    /* renamed from: j  reason: collision with root package name */
    public String f19651j;

    /* renamed from: k  reason: collision with root package name */
    public CustomerInfo f19652k;

    public static final /* synthetic */ a yh(CustomerInfoActivity customerInfoActivity) {
        return (a) customerInfoActivity.Yf();
    }

    /* renamed from: Ah */
    public a Og() {
        return a.K(getLayoutInflater());
    }

    public final void Bh() {
        if (this.f19652k != null) {
            b2.a.d().a("/im/chat").withString(TUIConstants.TUIChat.CHAT_TYPE, "1").withString("chatId", this.f19651j).navigation();
        }
    }

    public final void Ch(CustomerInfo customerInfo) {
        this.f19652k = customerInfo;
    }

    public void initView() {
        super.initView();
        Qg(NightHelper.e().g());
        ((a) Yf()).N(this);
        sh();
        RequestExtKt.d(b.a().getCustomerInfo(this.f19650i, this.f19651j), new CustomerInfoActivity$initView$1(this), new CustomerInfoActivity$initView$2(this), (MutableLiveData) null, 4, (Object) null);
    }

    public void oh() {
        super.oh();
        this.f19650i = getIntent().getStringExtra("uid");
        this.f19651j = getIntent().getStringExtra(Constants.FLAG_ACCOUNT);
    }

    public final void zh() {
        CustomerInfo customerInfo = this.f19652k;
        if (customerInfo != null) {
            ((ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText((CharSequence) null, customerInfo.getEmail()));
            HuobiToastUtil.m(getResources().getString(R$string.security_ga_key_already_copy));
        }
    }
}
