package com.huobi;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.b;
import androidx.databinding.f;
import java.util.ArrayList;
import java.util.List;
import lj.b0;
import lj.d;
import lj.d0;
import lj.f0;
import lj.h;
import lj.h0;
import lj.j;
import lj.j0;
import lj.l;
import lj.l0;
import lj.n;
import lj.n0;
import lj.p;
import lj.p0;
import lj.r;
import lj.r0;
import lj.t;
import lj.t0;
import lj.v;
import lj.x;
import lj.z;
import pro.huobi.R;

public class DataBinderMapperImpl extends DataBinderMapper {

    /* renamed from: a  reason: collision with root package name */
    public static final SparseIntArray f40905a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(23);
        f40905a = sparseIntArray;
        sparseIntArray.put(R.layout.activity_contract_bot_complete, 1);
        sparseIntArray.put(R.layout.activity_contract_bot_detail, 2);
        sparseIntArray.put(R.layout.activity_contract_grid, 3);
        sparseIntArray.put(R.layout.activity_contract_zero_swap, 4);
        sparseIntArray.put(R.layout.activity_copy_trading_trader_info, 5);
        sparseIntArray.put(R.layout.activity_copytrading_main, 6);
        sparseIntArray.put(R.layout.activity_edge_engine_container, 7);
        sparseIntArray.put(R.layout.activity_edge_engine_page, 8);
        sparseIntArray.put(R.layout.activity_message, 9);
        sparseIntArray.put(R.layout.activity_trading_bot, 10);
        sparseIntArray.put(R.layout.dialog_fragment_zero_swap, 11);
        sparseIntArray.put(R.layout.fragment_copy_trading_home, 12);
        sparseIntArray.put(R.layout.fragment_copy_trading_me, 13);
        sparseIntArray.put(R.layout.fragment_copy_trading_new_home, 14);
        sparseIntArray.put(R.layout.fragment_copy_trading_trade, 15);
        sparseIntArray.put(R.layout.item_dialog_zero_swap, 16);
        sparseIntArray.put(R.layout.item_home_content_rank, 17);
        sparseIntArray.put(R.layout.item_home_deep_news, 18);
        sparseIntArray.put(R.layout.item_index_recommend_live_item, 19);
        sparseIntArray.put(R.layout.item_index_topic_item, 20);
        sparseIntArray.put(R.layout.item_zero_swap_open_position, 21);
        sparseIntArray.put(R.layout.item_zero_swap_open_position_footer, 22);
        sparseIntArray.put(R.layout.temp_copy_trading_tab, 23);
    }

    public List<DataBinderMapper> a() {
        ArrayList arrayList = new ArrayList(10);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.business.common.DataBinderMapperImpl());
        arrayList.add(new com.hbg.lib.widgets.DataBinderMapperImpl());
        arrayList.add(new com.hbg.module.account.DataBinderMapperImpl());
        arrayList.add(new com.hbg.module.asset.DataBinderMapperImpl());
        arrayList.add(new com.hbg.module.content.DataBinderMapperImpl());
        arrayList.add(new com.hbg.module.huobi.im.DataBinderMapperImpl());
        arrayList.add(new com.hbg.module.libkt.DataBinderMapperImpl());
        arrayList.add(new com.hbg.module.market.DataBinderMapperImpl());
        arrayList.add(new com.hbg.module.share.DataBinderMapperImpl());
        return arrayList;
    }

    public f b(b bVar, View view, int i11) {
        int i12 = f40905a.get(i11);
        if (i12 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag != null) {
            switch (i12) {
                case 1:
                    if ("layout/activity_contract_bot_complete_0".equals(tag)) {
                        return new lj.b(bVar, view);
                    }
                    throw new IllegalArgumentException("The tag for activity_contract_bot_complete is invalid. Received: " + tag);
                case 2:
                    if ("layout/activity_contract_bot_detail_0".equals(tag)) {
                        return new d(bVar, view);
                    }
                    throw new IllegalArgumentException("The tag for activity_contract_bot_detail is invalid. Received: " + tag);
                case 3:
                    if ("layout/activity_contract_grid_0".equals(tag)) {
                        return new lj.f(bVar, view);
                    }
                    throw new IllegalArgumentException("The tag for activity_contract_grid is invalid. Received: " + tag);
                case 4:
                    if ("layout/activity_contract_zero_swap_0".equals(tag)) {
                        return new h(bVar, view);
                    }
                    throw new IllegalArgumentException("The tag for activity_contract_zero_swap is invalid. Received: " + tag);
                case 5:
                    if ("layout/activity_copy_trading_trader_info_0".equals(tag)) {
                        return new j(bVar, view);
                    }
                    throw new IllegalArgumentException("The tag for activity_copy_trading_trader_info is invalid. Received: " + tag);
                case 6:
                    if ("layout/activity_copytrading_main_0".equals(tag)) {
                        return new l(bVar, view);
                    }
                    throw new IllegalArgumentException("The tag for activity_copytrading_main is invalid. Received: " + tag);
                case 7:
                    if ("layout/activity_edge_engine_container_0".equals(tag)) {
                        return new n(bVar, view);
                    }
                    throw new IllegalArgumentException("The tag for activity_edge_engine_container is invalid. Received: " + tag);
                case 8:
                    if ("layout/activity_edge_engine_page_0".equals(tag)) {
                        return new p(bVar, view);
                    }
                    throw new IllegalArgumentException("The tag for activity_edge_engine_page is invalid. Received: " + tag);
                case 9:
                    if ("layout/activity_message_0".equals(tag)) {
                        return new r(bVar, view);
                    }
                    throw new IllegalArgumentException("The tag for activity_message is invalid. Received: " + tag);
                case 10:
                    if ("layout/activity_trading_bot_0".equals(tag)) {
                        return new t(bVar, view);
                    }
                    throw new IllegalArgumentException("The tag for activity_trading_bot is invalid. Received: " + tag);
                case 11:
                    if ("layout/dialog_fragment_zero_swap_0".equals(tag)) {
                        return new v(bVar, view);
                    }
                    throw new IllegalArgumentException("The tag for dialog_fragment_zero_swap is invalid. Received: " + tag);
                case 12:
                    if ("layout/fragment_copy_trading_home_0".equals(tag)) {
                        return new x(bVar, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_copy_trading_home is invalid. Received: " + tag);
                case 13:
                    if ("layout/fragment_copy_trading_me_0".equals(tag)) {
                        return new z(bVar, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_copy_trading_me is invalid. Received: " + tag);
                case 14:
                    if ("layout/fragment_copy_trading_new_home_0".equals(tag)) {
                        return new b0(bVar, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_copy_trading_new_home is invalid. Received: " + tag);
                case 15:
                    if ("layout/fragment_copy_trading_trade_0".equals(tag)) {
                        return new d0(bVar, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_copy_trading_trade is invalid. Received: " + tag);
                case 16:
                    if ("layout/item_dialog_zero_swap_0".equals(tag)) {
                        return new f0(bVar, view);
                    }
                    throw new IllegalArgumentException("The tag for item_dialog_zero_swap is invalid. Received: " + tag);
                case 17:
                    if ("layout/item_home_content_rank_0".equals(tag)) {
                        return new h0(bVar, view);
                    }
                    throw new IllegalArgumentException("The tag for item_home_content_rank is invalid. Received: " + tag);
                case 18:
                    if ("layout/item_home_deep_news_0".equals(tag)) {
                        return new j0(bVar, view);
                    }
                    throw new IllegalArgumentException("The tag for item_home_deep_news is invalid. Received: " + tag);
                case 19:
                    if ("layout/item_index_recommend_live_item_0".equals(tag)) {
                        return new l0(bVar, view);
                    }
                    throw new IllegalArgumentException("The tag for item_index_recommend_live_item is invalid. Received: " + tag);
                case 20:
                    if ("layout/item_index_topic_item_0".equals(tag)) {
                        return new n0(bVar, view);
                    }
                    throw new IllegalArgumentException("The tag for item_index_topic_item is invalid. Received: " + tag);
                case 21:
                    if ("layout/item_zero_swap_open_position_0".equals(tag)) {
                        return new p0(bVar, view);
                    }
                    throw new IllegalArgumentException("The tag for item_zero_swap_open_position is invalid. Received: " + tag);
                case 22:
                    if ("layout/item_zero_swap_open_position_footer_0".equals(tag)) {
                        return new r0(bVar, view);
                    }
                    throw new IllegalArgumentException("The tag for item_zero_swap_open_position_footer is invalid. Received: " + tag);
                case 23:
                    if ("layout/temp_copy_trading_tab_0".equals(tag)) {
                        return new t0(bVar, view);
                    }
                    throw new IllegalArgumentException("The tag for temp_copy_trading_tab is invalid. Received: " + tag);
                default:
                    return null;
            }
        } else {
            throw new RuntimeException("view must have a tag");
        }
    }

    public f c(b bVar, View[] viewArr, int i11) {
        if (viewArr == null || viewArr.length == 0 || f40905a.get(i11) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
