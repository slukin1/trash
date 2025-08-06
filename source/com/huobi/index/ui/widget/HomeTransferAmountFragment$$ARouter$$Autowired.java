package com.huobi.index.ui.widget;

import b2.a;
import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;

public class HomeTransferAmountFragment$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    public void inject(Object obj) {
        this.serializationService = (SerializationService) a.d().h(SerializationService.class);
        HomeTransferAmountFragment homeTransferAmountFragment = (HomeTransferAmountFragment) obj;
        homeTransferAmountFragment.f74000b = homeTransferAmountFragment.getArguments().getString("title");
        homeTransferAmountFragment.f74001c = homeTransferAmountFragment.getArguments().getInt("isTransfer");
        homeTransferAmountFragment.f74002d = homeTransferAmountFragment.getArguments().getString("desc");
    }
}
