package com.hbg.module.community.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;

public final class CommunityEmptyCommonBinder extends CommunityBaseCommonBinder<CommunityFeedInfo.ListBean, a> {

    public static final class a extends l {
        public a(View view) {
            super(view);
        }
    }

    public l Y(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new a((View) null);
    }

    /* renamed from: q0 */
    public void N(a aVar, CommunityFeedInfo.ListBean listBean) {
    }
}
