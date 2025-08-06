package com.huobi.account.entity;

import com.hbg.lib.network.hbg.core.bean.AccountTaskResp;
import com.hbg.lib.network.hbg.core.bean.CustomerData;
import com.hbg.lib.network.hbg.core.bean.PersonalcenterActivityInfoBean;
import com.hbg.lib.network.hbg.core.bean.RewardInfo;
import com.hbg.lib.network.hbg.core.bean.SubscribeBox;
import com.huobi.account.bean.BoxToolRespBean;
import com.huobi.account.bean.KnapsackItem;
import java.util.List;

public class AccountBoxItem {

    /* renamed from: a  reason: collision with root package name */
    public List<PersonalcenterActivityInfoBean> f40971a;

    /* renamed from: b  reason: collision with root package name */
    public AccountTaskResp f40972b;

    /* renamed from: c  reason: collision with root package name */
    public KnapsackItem f40973c;

    /* renamed from: d  reason: collision with root package name */
    public CustomerData f40974d;

    /* renamed from: e  reason: collision with root package name */
    public SubscribeBox.MySubscribeBean f40975e;

    /* renamed from: f  reason: collision with root package name */
    public BoxToolRespBean f40976f;

    public AccountTaskResp a() {
        return this.f40972b;
    }

    public List<PersonalcenterActivityInfoBean> b() {
        return this.f40971a;
    }

    public BoxToolRespBean c() {
        return this.f40976f;
    }

    public CustomerData d() {
        return this.f40974d;
    }

    public KnapsackItem e() {
        return this.f40973c;
    }

    public SubscribeBox.MySubscribeBean f() {
        return this.f40975e;
    }

    public AccountBoxItem g(AccountTaskResp accountTaskResp) {
        this.f40972b = accountTaskResp;
        return this;
    }

    public AccountBoxItem h(List<PersonalcenterActivityInfoBean> list) {
        this.f40971a = list;
        return this;
    }

    public AccountBoxItem i(CustomerData customerData) {
        this.f40974d = customerData;
        return this;
    }

    public AccountBoxItem j(RewardInfo rewardInfo) {
        KnapsackItem knapsackItem = new KnapsackItem();
        this.f40973c = knapsackItem;
        knapsackItem.e(rewardInfo);
        return this;
    }

    public AccountBoxItem k(SubscribeBox.MySubscribeBean mySubscribeBean) {
        this.f40975e = mySubscribeBean;
        return this;
    }

    public AccountBoxItem l(SubscribeBox.MyToolRespBean myToolRespBean) {
        BoxToolRespBean boxToolRespBean = new BoxToolRespBean();
        this.f40976f = boxToolRespBean;
        boxToolRespBean.c(myToolRespBean);
        return this;
    }
}
