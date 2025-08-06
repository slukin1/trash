package com.huobi.experience;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.huobi.coupon.bean.CouponReturn;
import com.huobi.experience.ExperienceFragment;
import java.util.ArrayList;
import java.util.HashMap;

public final class a {
    public static void a(FragmentManager fragmentManager, ArrayList<CouponReturn> arrayList, String str, ExperienceFragment.b bVar) {
        ExperienceFragment sh2 = ExperienceFragment.sh();
        Bundle bundle = new Bundle();
        bundle.putSerializable("COUPON_DATA", arrayList);
        bundle.putString("DIALOG_ENTRY", str);
        sh2.setArguments(bundle);
        sh2.th(bVar);
        sh2.show(fragmentManager, "");
        new HashMap().put("trade_firtab_name", str);
    }
}
