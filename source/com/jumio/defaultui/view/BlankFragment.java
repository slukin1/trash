package com.jumio.defaultui.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jumio.defaultui.R;

public final class BlankFragment extends BaseFragment {
    public View createLayout(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.jumio_fragment_blank, viewGroup, false);
    }
}
