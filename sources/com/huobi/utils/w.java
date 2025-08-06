package com.huobi.utils;

import android.text.TextUtils;
import com.facebook.appevents.UserDataStore;
import com.google.gson.reflect.TypeToken;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.contract.core.bean.ContractTagInfo;
import com.hbg.lib.network.pro.core.bean.ChainInfo;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.account.event.ContractTagEvent;
import i6.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import u6.g;

public class w {

    /* renamed from: b  reason: collision with root package name */
    public static final List<String> f83783b = Arrays.asList(new String[]{"st_futures", "st_swap", "st_linear_swap", "st_linear_futures", "new_futures", "new_swap", "new_linear_swap", "new_linear_futures", "hot_futures", "hot_swap", "hot_linear_swap", "hot_linear_futures", "activity_mining_futures", "activity_mining_swap", "activity_mining_linear_swap", "activity_mining_linear_futures", "activity_master_comp_futures", "activity_master_comp_swap", "activity_master_comp_linear_swap", "activity_master_comp_linear_futures", "common"});

    /* renamed from: c  reason: collision with root package name */
    public static final List<String> f83784c = Arrays.asList(new String[]{UserDataStore.STATE, ChainInfo.CHAIN_TYPE_NEW, "hot", "activity_mining", "activity_master_comp"});

    /* renamed from: d  reason: collision with root package name */
    public static volatile w f83785d;

    /* renamed from: a  reason: collision with root package name */
    public String f83786a;

    public class a extends EasySubscriber<ContractTagInfo> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(ContractTagInfo contractTagInfo) {
            super.onNext(contractTagInfo);
            String json = GsonHelper.a().toJson((Object) contractTagInfo);
            if (!TextUtils.equals(json, w.this.f83786a)) {
                d.d("requestContractTag changed:" + w.this.f83786a);
                SP.s("KEY_CONTRACT_TAG", json);
                String unused = w.this.f83786a = json;
                EventBus.d().k(new ContractTagEvent());
            }
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
        }
    }

    public class b extends TypeToken<ContractTagInfo> {
        public b() {
        }
    }

    public w() {
        this.f83786a = "";
        this.f83786a = SP.i("KEY_CONTRACT_TAG", "");
    }

    public static w d() {
        if (f83785d == null) {
            synchronized (w.class) {
                if (f83785d == null) {
                    f83785d = new w();
                }
            }
        }
        return f83785d;
    }

    public ContractTagInfo c() {
        if (!TextUtils.isEmpty(this.f83786a)) {
            try {
                return (ContractTagInfo) GsonHelper.a().fromJson(this.f83786a, new b().getType());
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        return null;
    }

    public List<ContractTagInfo.TagsGroupInfo.TagInfo> e(boolean z11) {
        ArrayList arrayList = new ArrayList();
        ContractTagInfo c11 = c();
        if (!(c11 == null || c11.getTagsGroup() == null)) {
            for (ContractTagInfo.TagsGroupInfo next : c11.getTagsGroup()) {
                if (!(next == null || next.e() == null)) {
                    if ("common".equalsIgnoreCase(next.b())) {
                        arrayList.addAll(next.e());
                    } else if (!TextUtils.isEmpty(next.b()) && f83784c.contains(next.b())) {
                        for (ContractTagInfo.TagsGroupInfo.TagInfo next2 : next.e()) {
                            if (f83783b.contains(next2.b())) {
                                if (z11) {
                                    if (!TextUtils.isEmpty(next2.b()) && (next2.b().contains("linear") || next2.b().contains("linear_futures"))) {
                                        arrayList.add(next2);
                                    }
                                } else if (!TextUtils.isEmpty(next2.b()) && !next2.b().contains("linear")) {
                                    if (next2.b().contains("futures") || next2.b().contains("swap")) {
                                        arrayList.add(next2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public void f() {
        q7.a.a().getContractTagInfo().b().compose(RxJavaHelper.t((g) null)).subscribe(new a());
    }
}
