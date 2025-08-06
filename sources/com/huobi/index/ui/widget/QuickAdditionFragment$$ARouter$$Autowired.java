package com.huobi.index.ui.widget;

import b2.a;
import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;

public class QuickAdditionFragment$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    public void inject(Object obj) {
        this.serializationService = (SerializationService) a.d().h(SerializationService.class);
        QuickAdditionFragment quickAdditionFragment = (QuickAdditionFragment) obj;
        quickAdditionFragment.f74085q = quickAdditionFragment.getArguments().getString("title");
        quickAdditionFragment.f74086r = quickAdditionFragment.getArguments().getString("imgUrl");
        quickAdditionFragment.f74087s = quickAdditionFragment.getArguments().getString("groupCode");
    }
}
