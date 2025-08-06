package com.hbg.module.content;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.b;
import androidx.databinding.f;
import java.util.ArrayList;
import java.util.List;
import lc.b0;
import lc.b1;
import lc.b2;
import lc.b3;
import lc.b4;
import lc.b5;
import lc.b6;
import lc.b7;
import lc.d;
import lc.d0;
import lc.d1;
import lc.d2;
import lc.d3;
import lc.d4;
import lc.d5;
import lc.d6;
import lc.f0;
import lc.f1;
import lc.f2;
import lc.f3;
import lc.f4;
import lc.f5;
import lc.f6;
import lc.h;
import lc.h0;
import lc.h1;
import lc.h2;
import lc.h3;
import lc.h4;
import lc.h5;
import lc.h6;
import lc.j;
import lc.j0;
import lc.j1;
import lc.j2;
import lc.j3;
import lc.j4;
import lc.j5;
import lc.j6;
import lc.l;
import lc.l0;
import lc.l1;
import lc.l2;
import lc.l3;
import lc.l4;
import lc.l5;
import lc.l6;
import lc.n;
import lc.n0;
import lc.n1;
import lc.n2;
import lc.n3;
import lc.n4;
import lc.n5;
import lc.n6;
import lc.p;
import lc.p0;
import lc.p1;
import lc.p2;
import lc.p3;
import lc.p4;
import lc.p5;
import lc.p6;
import lc.r;
import lc.r0;
import lc.r1;
import lc.r2;
import lc.r3;
import lc.r4;
import lc.r5;
import lc.r6;
import lc.t;
import lc.t0;
import lc.t1;
import lc.t2;
import lc.t3;
import lc.t4;
import lc.t5;
import lc.t6;
import lc.v;
import lc.v0;
import lc.v1;
import lc.v2;
import lc.v3;
import lc.v4;
import lc.v5;
import lc.v6;
import lc.x;
import lc.x0;
import lc.x1;
import lc.x2;
import lc.x3;
import lc.x4;
import lc.x5;
import lc.x6;
import lc.z;
import lc.z0;
import lc.z1;
import lc.z2;
import lc.z3;
import lc.z4;
import lc.z5;
import lc.z6;

public class DataBinderMapperImpl extends DataBinderMapper {

    /* renamed from: a  reason: collision with root package name */
    public static final SparseIntArray f17744a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(105);
        f17744a = sparseIntArray;
        sparseIntArray.put(R$layout.activity_comment_detail, 1);
        sparseIntArray.put(R$layout.activity_dynamic_detail, 2);
        sparseIntArray.put(R$layout.activity_fans_list, 3);
        sparseIntArray.put(R$layout.activity_follow_list, 4);
        sparseIntArray.put(R$layout.activity_full_screen_live, 5);
        sparseIntArray.put(R$layout.activity_live_category, 6);
        sparseIntArray.put(R$layout.activity_live_detail, 7);
        sparseIntArray.put(R$layout.activity_new_content, 8);
        sparseIntArray.put(R$layout.activity_news_detail, 9);
        sparseIntArray.put(R$layout.activity_personal_center, 10);
        sparseIntArray.put(R$layout.activity_post_dynamic, 11);
        sparseIntArray.put(R$layout.activity_recommend_speaker, 12);
        sparseIntArray.put(R$layout.activity_topic_detail, 13);
        sparseIntArray.put(R$layout.custom_coin_tag, 14);
        sparseIntArray.put(R$layout.custom_coin_tag_v2, 15);
        sparseIntArray.put(R$layout.dialog_h5_fragment, 16);
        sparseIntArray.put(R$layout.dialog_live_more_controller, 17);
        sparseIntArray.put(R$layout.dialog_live_rank, 18);
        sparseIntArray.put(R$layout.dialog_live_recommend, 19);
        sparseIntArray.put(R$layout.dialog_live_trader, 20);
        sparseIntArray.put(R$layout.dialog_live_user_info, 21);
        sparseIntArray.put(R$layout.dialog_reason, 22);
        sparseIntArray.put(R$layout.dialog_search_user, 23);
        sparseIntArray.put(R$layout.error_live, 24);
        sparseIntArray.put(R$layout.fragment_achievement_tab, 25);
        sparseIntArray.put(R$layout.fragment_child_community_kline, 26);
        sparseIntArray.put(R$layout.fragment_comment_list, 27);
        sparseIntArray.put(R$layout.fragment_community, 28);
        sparseIntArray.put(R$layout.fragment_community_child, 29);
        sparseIntArray.put(R$layout.fragment_community_kline, 30);
        sparseIntArray.put(R$layout.fragment_gift_list, 31);
        sparseIntArray.put(R$layout.fragment_gift_rank, 32);
        sparseIntArray.put(R$layout.fragment_h5, 33);
        sparseIntArray.put(R$layout.fragment_kline_deep, 34);
        sparseIntArray.put(R$layout.fragment_live_category, 35);
        sparseIntArray.put(R$layout.fragment_live_category_child, 36);
        sparseIntArray.put(R$layout.fragment_live_category_list, 37);
        sparseIntArray.put(R$layout.fragment_live_self_award, 38);
        sparseIntArray.put(R$layout.fragment_live_user, 39);
        sparseIntArray.put(R$layout.fragment_new_content, 40);
        sparseIntArray.put(R$layout.fragment_new_content_child, 41);
        sparseIntArray.put(R$layout.fragment_news_home, 42);
        sparseIntArray.put(R$layout.fragment_personal_center_tab, 43);
        sparseIntArray.put(R$layout.fragment_recycler_list, 44);
        sparseIntArray.put(R$layout.fragment_topic_detail_tab, 45);
        sparseIntArray.put(R$layout.item_achievement, 46);
        sparseIntArray.put(R$layout.item_attitude, 47);
        sparseIntArray.put(R$layout.item_category, 48);
        sparseIntArray.put(R$layout.item_comment, 49);
        sparseIntArray.put(R$layout.item_community_attention_recommend, 50);
        sparseIntArray.put(R$layout.item_community_attention_recommend_cell, 51);
        sparseIntArray.put(R$layout.item_community_base, 52);
        sparseIntArray.put(R$layout.item_community_feed, 53);
        sparseIntArray.put(R$layout.item_community_feed_comment, 54);
        sparseIntArray.put(R$layout.item_community_feed_comment_cell, 55);
        sparseIntArray.put(R$layout.item_community_feed_reply_comment, 56);
        sparseIntArray.put(R$layout.item_community_feed_share, 57);
        sparseIntArray.put(R$layout.item_community_image, 58);
        sparseIntArray.put(R$layout.item_community_img, 59);
        sparseIntArray.put(R$layout.item_community_interest_tag, 60);
        sparseIntArray.put(R$layout.item_community_reply_article, 61);
        sparseIntArray.put(R$layout.item_community_reply_comment, 62);
        sparseIntArray.put(R$layout.item_community_topic, 63);
        sparseIntArray.put(R$layout.item_community_topic_item, 64);
        sparseIntArray.put(R$layout.item_community_vote, 65);
        sparseIntArray.put(R$layout.item_deep_news, 66);
        sparseIntArray.put(R$layout.item_fans, 67);
        sparseIntArray.put(R$layout.item_fast_news, 68);
        sparseIntArray.put(R$layout.item_fast_news_index, 69);
        sparseIntArray.put(R$layout.item_gift, 70);
        sparseIntArray.put(R$layout.item_gift_rank, 71);
        sparseIntArray.put(R$layout.item_gift_top, 72);
        sparseIntArray.put(R$layout.item_live_award_cell, 73);
        sparseIntArray.put(R$layout.item_live_banner, 74);
        sparseIntArray.put(R$layout.item_live_category, 75);
        sparseIntArray.put(R$layout.item_live_category_title, 76);
        sparseIntArray.put(R$layout.item_live_content_one_cell_category, 77);
        sparseIntArray.put(R$layout.item_live_content_playback_cell_category, 78);
        sparseIntArray.put(R$layout.item_live_content_two_cell_category, 79);
        sparseIntArray.put(R$layout.item_live_desc, 80);
        sparseIntArray.put(R$layout.item_live_member, 81);
        sparseIntArray.put(R$layout.item_live_recommend_speaker, 82);
        sparseIntArray.put(R$layout.item_recommend_live, 83);
        sparseIntArray.put(R$layout.item_recommend_live_item, 84);
        sparseIntArray.put(R$layout.item_recommend_speaker, 85);
        sparseIntArray.put(R$layout.item_reply, 86);
        sparseIntArray.put(R$layout.item_sister, 87);
        sparseIntArray.put(R$layout.item_speaker, 88);
        sparseIntArray.put(R$layout.item_subtitle, 89);
        sparseIntArray.put(R$layout.item_title_list, 90);
        sparseIntArray.put(R$layout.item_trader_rank, 91);
        sparseIntArray.put(R$layout.item_ugc_task, 92);
        sparseIntArray.put(R$layout.item_user_header, 93);
        sparseIntArray.put(R$layout.lay_chart_group, 94);
        sparseIntArray.put(R$layout.lay_live_load_error, 95);
        sparseIntArray.put(R$layout.lay_live_load_error_float, 96);
        sparseIntArray.put(R$layout.lay_live_tips, 97);
        sparseIntArray.put(R$layout.lay_live_toggle, 98);
        sparseIntArray.put(R$layout.lay_vod_loading, 99);
        sparseIntArray.put(R$layout.lay_vod_loading_float, 100);
        sparseIntArray.put(R$layout.layout_community_indicator, 101);
        sparseIntArray.put(R$layout.layout_live_finish_recommend, 102);
        sparseIntArray.put(R$layout.pop_tips, 103);
        sparseIntArray.put(R$layout.topic_news_item, 104);
        sparseIntArray.put(R$layout.view_countdown, 105);
    }

    public List<DataBinderMapper> a() {
        ArrayList arrayList = new ArrayList(7);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.business.common.DataBinderMapperImpl());
        arrayList.add(new com.hbg.lib.widgets.DataBinderMapperImpl());
        arrayList.add(new com.hbg.module.asset.DataBinderMapperImpl());
        arrayList.add(new com.hbg.module.huobi.im.DataBinderMapperImpl());
        arrayList.add(new com.hbg.module.libkt.DataBinderMapperImpl());
        arrayList.add(new com.hbg.module.share.DataBinderMapperImpl());
        return arrayList;
    }

    public f b(b bVar, View view, int i11) {
        int i12 = f17744a.get(i11);
        if (i12 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag != null) {
            int i13 = (i12 - 1) / 50;
            if (i13 == 0) {
                return d(bVar, view, i12, tag);
            }
            if (i13 == 1) {
                return e(bVar, view, i12, tag);
            }
            if (i13 != 2) {
                return null;
            }
            return f(bVar, view, i12, tag);
        }
        throw new RuntimeException("view must have a tag");
    }

    public f c(b bVar, View[] viewArr, int i11) {
        if (viewArr == null || viewArr.length == 0 || f17744a.get(i11) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    public final f d(b bVar, View view, int i11, Object obj) {
        switch (i11) {
            case 1:
                if ("layout/activity_comment_detail_0".equals(obj)) {
                    return new lc.b(bVar, view);
                }
                throw new IllegalArgumentException("The tag for activity_comment_detail is invalid. Received: " + obj);
            case 2:
                if ("layout/activity_dynamic_detail_0".equals(obj)) {
                    return new d(bVar, view);
                }
                throw new IllegalArgumentException("The tag for activity_dynamic_detail is invalid. Received: " + obj);
            case 3:
                if ("layout/activity_fans_list_0".equals(obj)) {
                    return new lc.f(bVar, view);
                }
                throw new IllegalArgumentException("The tag for activity_fans_list is invalid. Received: " + obj);
            case 4:
                if ("layout/activity_follow_list_0".equals(obj)) {
                    return new h(bVar, view);
                }
                throw new IllegalArgumentException("The tag for activity_follow_list is invalid. Received: " + obj);
            case 5:
                if ("layout/activity_full_screen_live_0".equals(obj)) {
                    return new j(bVar, view);
                }
                throw new IllegalArgumentException("The tag for activity_full_screen_live is invalid. Received: " + obj);
            case 6:
                if ("layout/activity_live_category_0".equals(obj)) {
                    return new l(bVar, view);
                }
                throw new IllegalArgumentException("The tag for activity_live_category is invalid. Received: " + obj);
            case 7:
                if ("layout/activity_live_detail_0".equals(obj)) {
                    return new n(bVar, view);
                }
                throw new IllegalArgumentException("The tag for activity_live_detail is invalid. Received: " + obj);
            case 8:
                if ("layout/activity_new_content_0".equals(obj)) {
                    return new p(bVar, view);
                }
                throw new IllegalArgumentException("The tag for activity_new_content is invalid. Received: " + obj);
            case 9:
                if ("layout/activity_news_detail_0".equals(obj)) {
                    return new r(bVar, view);
                }
                throw new IllegalArgumentException("The tag for activity_news_detail is invalid. Received: " + obj);
            case 10:
                if ("layout/activity_personal_center_0".equals(obj)) {
                    return new t(bVar, view);
                }
                throw new IllegalArgumentException("The tag for activity_personal_center is invalid. Received: " + obj);
            case 11:
                if ("layout/activity_post_dynamic_0".equals(obj)) {
                    return new v(bVar, view);
                }
                throw new IllegalArgumentException("The tag for activity_post_dynamic is invalid. Received: " + obj);
            case 12:
                if ("layout/activity_recommend_speaker_0".equals(obj)) {
                    return new x(bVar, view);
                }
                throw new IllegalArgumentException("The tag for activity_recommend_speaker is invalid. Received: " + obj);
            case 13:
                if ("layout/activity_topic_detail_0".equals(obj)) {
                    return new z(bVar, view);
                }
                throw new IllegalArgumentException("The tag for activity_topic_detail is invalid. Received: " + obj);
            case 14:
                if ("layout/custom_coin_tag_0".equals(obj)) {
                    return new b0(bVar, view);
                }
                throw new IllegalArgumentException("The tag for custom_coin_tag is invalid. Received: " + obj);
            case 15:
                if ("layout/custom_coin_tag_v2_0".equals(obj)) {
                    return new d0(bVar, view);
                }
                throw new IllegalArgumentException("The tag for custom_coin_tag_v2 is invalid. Received: " + obj);
            case 16:
                if ("layout/dialog_h5_fragment_0".equals(obj)) {
                    return new f0(bVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_h5_fragment is invalid. Received: " + obj);
            case 17:
                if ("layout/dialog_live_more_controller_0".equals(obj)) {
                    return new h0(bVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_live_more_controller is invalid. Received: " + obj);
            case 18:
                if ("layout/dialog_live_rank_0".equals(obj)) {
                    return new j0(bVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_live_rank is invalid. Received: " + obj);
            case 19:
                if ("layout/dialog_live_recommend_0".equals(obj)) {
                    return new l0(bVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_live_recommend is invalid. Received: " + obj);
            case 20:
                if ("layout/dialog_live_trader_0".equals(obj)) {
                    return new n0(bVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_live_trader is invalid. Received: " + obj);
            case 21:
                if ("layout/dialog_live_user_info_0".equals(obj)) {
                    return new p0(bVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_live_user_info is invalid. Received: " + obj);
            case 22:
                if ("layout/dialog_reason_0".equals(obj)) {
                    return new r0(bVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_reason is invalid. Received: " + obj);
            case 23:
                if ("layout/dialog_search_user_0".equals(obj)) {
                    return new t0(bVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_search_user is invalid. Received: " + obj);
            case 24:
                if ("layout/error_live_0".equals(obj)) {
                    return new v0(bVar, view);
                }
                throw new IllegalArgumentException("The tag for error_live is invalid. Received: " + obj);
            case 25:
                if ("layout/fragment_achievement_tab_0".equals(obj)) {
                    return new x0(bVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_achievement_tab is invalid. Received: " + obj);
            case 26:
                if ("layout/fragment_child_community_kline_0".equals(obj)) {
                    return new z0(bVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_child_community_kline is invalid. Received: " + obj);
            case 27:
                if ("layout/fragment_comment_list_0".equals(obj)) {
                    return new b1(bVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_comment_list is invalid. Received: " + obj);
            case 28:
                if ("layout/fragment_community_0".equals(obj)) {
                    return new d1(bVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_community is invalid. Received: " + obj);
            case 29:
                if ("layout/fragment_community_child_0".equals(obj)) {
                    return new f1(bVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_community_child is invalid. Received: " + obj);
            case 30:
                if ("layout/fragment_community_kline_0".equals(obj)) {
                    return new h1(bVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_community_kline is invalid. Received: " + obj);
            case 31:
                if ("layout/fragment_gift_list_0".equals(obj)) {
                    return new j1(bVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_gift_list is invalid. Received: " + obj);
            case 32:
                if ("layout/fragment_gift_rank_0".equals(obj)) {
                    return new l1(bVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_gift_rank is invalid. Received: " + obj);
            case 33:
                if ("layout/fragment_h5_0".equals(obj)) {
                    return new n1(bVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_h5 is invalid. Received: " + obj);
            case 34:
                if ("layout/fragment_kline_deep_0".equals(obj)) {
                    return new p1(bVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_kline_deep is invalid. Received: " + obj);
            case 35:
                if ("layout/fragment_live_category_0".equals(obj)) {
                    return new r1(bVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_live_category is invalid. Received: " + obj);
            case 36:
                if ("layout/fragment_live_category_child_0".equals(obj)) {
                    return new t1(bVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_live_category_child is invalid. Received: " + obj);
            case 37:
                if ("layout/fragment_live_category_list_0".equals(obj)) {
                    return new v1(bVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_live_category_list is invalid. Received: " + obj);
            case 38:
                if ("layout/fragment_live_self_award_0".equals(obj)) {
                    return new x1(bVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_live_self_award is invalid. Received: " + obj);
            case 39:
                if ("layout/fragment_live_user_0".equals(obj)) {
                    return new z1(bVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_live_user is invalid. Received: " + obj);
            case 40:
                if ("layout/fragment_new_content_0".equals(obj)) {
                    return new b2(bVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_new_content is invalid. Received: " + obj);
            case 41:
                if ("layout/fragment_new_content_child_0".equals(obj)) {
                    return new d2(bVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_new_content_child is invalid. Received: " + obj);
            case 42:
                if ("layout/fragment_news_home_0".equals(obj)) {
                    return new f2(bVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_news_home is invalid. Received: " + obj);
            case 43:
                if ("layout/fragment_personal_center_tab_0".equals(obj)) {
                    return new h2(bVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_personal_center_tab is invalid. Received: " + obj);
            case 44:
                if ("layout/fragment_recycler_list_0".equals(obj)) {
                    return new j2(bVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_recycler_list is invalid. Received: " + obj);
            case 45:
                if ("layout/fragment_topic_detail_tab_0".equals(obj)) {
                    return new l2(bVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_topic_detail_tab is invalid. Received: " + obj);
            case 46:
                if ("layout/item_achievement_0".equals(obj)) {
                    return new n2(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_achievement is invalid. Received: " + obj);
            case 47:
                if ("layout/item_attitude_0".equals(obj)) {
                    return new p2(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_attitude is invalid. Received: " + obj);
            case 48:
                if ("layout/item_category_0".equals(obj)) {
                    return new r2(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_category is invalid. Received: " + obj);
            case 49:
                if ("layout/item_comment_0".equals(obj)) {
                    return new t2(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_comment is invalid. Received: " + obj);
            case 50:
                if ("layout/item_community_attention_recommend_0".equals(obj)) {
                    return new v2(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_community_attention_recommend is invalid. Received: " + obj);
            default:
                return null;
        }
    }

    public final f e(b bVar, View view, int i11, Object obj) {
        switch (i11) {
            case 51:
                if ("layout/item_community_attention_recommend_cell_0".equals(obj)) {
                    return new x2(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_community_attention_recommend_cell is invalid. Received: " + obj);
            case 52:
                if ("layout/item_community_base_0".equals(obj)) {
                    return new z2(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_community_base is invalid. Received: " + obj);
            case 53:
                if ("layout/item_community_feed_0".equals(obj)) {
                    return new b3(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_community_feed is invalid. Received: " + obj);
            case 54:
                if ("layout/item_community_feed_comment_0".equals(obj)) {
                    return new d3(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_community_feed_comment is invalid. Received: " + obj);
            case 55:
                if ("layout/item_community_feed_comment_cell_0".equals(obj)) {
                    return new f3(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_community_feed_comment_cell is invalid. Received: " + obj);
            case 56:
                if ("layout/item_community_feed_reply_comment_0".equals(obj)) {
                    return new h3(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_community_feed_reply_comment is invalid. Received: " + obj);
            case 57:
                if ("layout/item_community_feed_share_0".equals(obj)) {
                    return new j3(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_community_feed_share is invalid. Received: " + obj);
            case 58:
                if ("layout/item_community_image_0".equals(obj)) {
                    return new l3(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_community_image is invalid. Received: " + obj);
            case 59:
                if ("layout/item_community_img_0".equals(obj)) {
                    return new n3(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_community_img is invalid. Received: " + obj);
            case 60:
                if ("layout/item_community_interest_tag_0".equals(obj)) {
                    return new p3(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_community_interest_tag is invalid. Received: " + obj);
            case 61:
                if ("layout/item_community_reply_article_0".equals(obj)) {
                    return new r3(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_community_reply_article is invalid. Received: " + obj);
            case 62:
                if ("layout/item_community_reply_comment_0".equals(obj)) {
                    return new t3(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_community_reply_comment is invalid. Received: " + obj);
            case 63:
                if ("layout/item_community_topic_0".equals(obj)) {
                    return new v3(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_community_topic is invalid. Received: " + obj);
            case 64:
                if ("layout/item_community_topic_item_0".equals(obj)) {
                    return new x3(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_community_topic_item is invalid. Received: " + obj);
            case 65:
                if ("layout/item_community_vote_0".equals(obj)) {
                    return new z3(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_community_vote is invalid. Received: " + obj);
            case 66:
                if ("layout/item_deep_news_0".equals(obj)) {
                    return new b4(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_deep_news is invalid. Received: " + obj);
            case 67:
                if ("layout/item_fans_0".equals(obj)) {
                    return new d4(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_fans is invalid. Received: " + obj);
            case 68:
                if ("layout/item_fast_news_0".equals(obj)) {
                    return new f4(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_fast_news is invalid. Received: " + obj);
            case 69:
                if ("layout/item_fast_news_index_0".equals(obj)) {
                    return new h4(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_fast_news_index is invalid. Received: " + obj);
            case 70:
                if ("layout/item_gift_0".equals(obj)) {
                    return new j4(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_gift is invalid. Received: " + obj);
            case 71:
                if ("layout/item_gift_rank_0".equals(obj)) {
                    return new l4(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_gift_rank is invalid. Received: " + obj);
            case 72:
                if ("layout/item_gift_top_0".equals(obj)) {
                    return new n4(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_gift_top is invalid. Received: " + obj);
            case 73:
                if ("layout/item_live_award_cell_0".equals(obj)) {
                    return new p4(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_live_award_cell is invalid. Received: " + obj);
            case 74:
                if ("layout/item_live_banner_0".equals(obj)) {
                    return new r4(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_live_banner is invalid. Received: " + obj);
            case 75:
                if ("layout/item_live_category_0".equals(obj)) {
                    return new t4(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_live_category is invalid. Received: " + obj);
            case 76:
                if ("layout/item_live_category_title_0".equals(obj)) {
                    return new v4(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_live_category_title is invalid. Received: " + obj);
            case 77:
                if ("layout/item_live_content_one_cell_category_0".equals(obj)) {
                    return new x4(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_live_content_one_cell_category is invalid. Received: " + obj);
            case 78:
                if ("layout/item_live_content_playback_cell_category_0".equals(obj)) {
                    return new z4(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_live_content_playback_cell_category is invalid. Received: " + obj);
            case 79:
                if ("layout/item_live_content_two_cell_category_0".equals(obj)) {
                    return new b5(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_live_content_two_cell_category is invalid. Received: " + obj);
            case 80:
                if ("layout/item_live_desc_0".equals(obj)) {
                    return new d5(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_live_desc is invalid. Received: " + obj);
            case 81:
                if ("layout/item_live_member_0".equals(obj)) {
                    return new f5(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_live_member is invalid. Received: " + obj);
            case 82:
                if ("layout/item_live_recommend_speaker_0".equals(obj)) {
                    return new h5(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_live_recommend_speaker is invalid. Received: " + obj);
            case 83:
                if ("layout/item_recommend_live_0".equals(obj)) {
                    return new j5(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_recommend_live is invalid. Received: " + obj);
            case 84:
                if ("layout/item_recommend_live_item_0".equals(obj)) {
                    return new l5(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_recommend_live_item is invalid. Received: " + obj);
            case 85:
                if ("layout/item_recommend_speaker_0".equals(obj)) {
                    return new n5(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_recommend_speaker is invalid. Received: " + obj);
            case 86:
                if ("layout/item_reply_0".equals(obj)) {
                    return new p5(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_reply is invalid. Received: " + obj);
            case 87:
                if ("layout/item_sister_0".equals(obj)) {
                    return new r5(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_sister is invalid. Received: " + obj);
            case 88:
                if ("layout/item_speaker_0".equals(obj)) {
                    return new t5(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_speaker is invalid. Received: " + obj);
            case 89:
                if ("layout/item_subtitle_0".equals(obj)) {
                    return new v5(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_subtitle is invalid. Received: " + obj);
            case 90:
                if ("layout/item_title_list_0".equals(obj)) {
                    return new x5(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_title_list is invalid. Received: " + obj);
            case 91:
                if ("layout/item_trader_rank_0".equals(obj)) {
                    return new z5(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_trader_rank is invalid. Received: " + obj);
            case 92:
                if ("layout/item_ugc_task_0".equals(obj)) {
                    return new b6(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_ugc_task is invalid. Received: " + obj);
            case 93:
                if ("layout/item_user_header_0".equals(obj)) {
                    return new d6(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_user_header is invalid. Received: " + obj);
            case 94:
                if ("layout/lay_chart_group_0".equals(obj)) {
                    return new f6(bVar, view);
                }
                throw new IllegalArgumentException("The tag for lay_chart_group is invalid. Received: " + obj);
            case 95:
                if ("layout/lay_live_load_error_0".equals(obj)) {
                    return new h6(bVar, view);
                }
                throw new IllegalArgumentException("The tag for lay_live_load_error is invalid. Received: " + obj);
            case 96:
                if ("layout/lay_live_load_error_float_0".equals(obj)) {
                    return new j6(bVar, view);
                }
                throw new IllegalArgumentException("The tag for lay_live_load_error_float is invalid. Received: " + obj);
            case 97:
                if ("layout/lay_live_tips_0".equals(obj)) {
                    return new l6(bVar, view);
                }
                throw new IllegalArgumentException("The tag for lay_live_tips is invalid. Received: " + obj);
            case 98:
                if ("layout/lay_live_toggle_0".equals(obj)) {
                    return new n6(bVar, view);
                }
                throw new IllegalArgumentException("The tag for lay_live_toggle is invalid. Received: " + obj);
            case 99:
                if ("layout/lay_vod_loading_0".equals(obj)) {
                    return new p6(bVar, view);
                }
                throw new IllegalArgumentException("The tag for lay_vod_loading is invalid. Received: " + obj);
            case 100:
                if ("layout/lay_vod_loading_float_0".equals(obj)) {
                    return new r6(bVar, view);
                }
                throw new IllegalArgumentException("The tag for lay_vod_loading_float is invalid. Received: " + obj);
            default:
                return null;
        }
    }

    public final f f(b bVar, View view, int i11, Object obj) {
        switch (i11) {
            case 101:
                if ("layout/layout_community_indicator_0".equals(obj)) {
                    return new t6(bVar, view);
                }
                throw new IllegalArgumentException("The tag for layout_community_indicator is invalid. Received: " + obj);
            case 102:
                if ("layout/layout_live_finish_recommend_0".equals(obj)) {
                    return new v6(bVar, view);
                }
                throw new IllegalArgumentException("The tag for layout_live_finish_recommend is invalid. Received: " + obj);
            case 103:
                if ("layout/pop_tips_0".equals(obj)) {
                    return new x6(bVar, view);
                }
                throw new IllegalArgumentException("The tag for pop_tips is invalid. Received: " + obj);
            case 104:
                if ("layout/topic_news_item_0".equals(obj)) {
                    return new z6(bVar, view);
                }
                throw new IllegalArgumentException("The tag for topic_news_item is invalid. Received: " + obj);
            case 105:
                if ("layout/view_countdown_0".equals(obj)) {
                    return new b7(bVar, view);
                }
                throw new IllegalArgumentException("The tag for view_countdown is invalid. Received: " + obj);
            default:
                return null;
        }
    }
}
