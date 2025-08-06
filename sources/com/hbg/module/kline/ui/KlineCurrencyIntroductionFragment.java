package com.hbg.module.kline.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hbg.lib.core.ui.EmptyMVPFragment;
import com.hbg.module.kline.R$layout;

public class KlineCurrencyIntroductionFragment extends EmptyMVPFragment {
    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R$layout.fragment_kine_currency_introduction, viewGroup, false);
    }
}
