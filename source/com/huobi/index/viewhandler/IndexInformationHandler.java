package com.huobi.index.viewhandler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import b2.a;
import com.airbnb.lottie.LottieAnimationView;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.util.w;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformation;
import com.hbg.lib.widgets.photoviewer.PhotoViewerUtils;
import com.hbg.module.content.ui.activity.NewsDetailActivity;
import com.hbg.module.libkt.base.ext.b;
import com.huobi.index.bean.IndexInformationItem;
import com.huochat.community.widget.expandable.ExpandableTextView;
import com.huochat.community.widget.expandable.StatusType;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gs.g;
import java.util.ArrayList;
import java.util.HashMap;
import pro.huobi.R;
import s9.c;
import tg.r;

public class IndexInformationHandler implements c, View.OnClickListener {

    /* renamed from: d  reason: collision with root package name */
    public static long f74121d;

    /* renamed from: e  reason: collision with root package name */
    public static long f74122e;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Object> f74123b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public IndexInformationItem f74124c;

    /* access modifiers changed from: private */
    public /* synthetic */ void l(Context context, NewFlashInformation newFlashInformation, StatusType statusType) {
        j(context, newFlashInformation);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void m(Context context, NewFlashInformation newFlashInformation, View view) {
        j(context, newFlashInformation);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void n(Context context, NewFlashInformation newFlashInformation, View view) {
        g.i("app_news_rechome_nrkppl", i());
        j(context, newFlashInformation);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void o(Context context, NewFlashInformation newFlashInformation, View view) {
        Intent intent = new Intent(context, HBBaseWebActivity.class);
        intent.putExtra("url", newFlashInformation.getLink());
        context.startActivity(intent);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void p(Context context, NewFlashInformation newFlashInformation, View view) {
        j(context, newFlashInformation);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void q(NewFlashInformation newFlashInformation, View view) {
        g.i("app_news_rechome_nrkpimg", i());
        if (newFlashInformation.getImages() != null && newFlashInformation.getImages().size() > 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(newFlashInformation.getImages().get(0).getImage());
            PhotoViewerUtils.a((Activity) view.getContext(), PhotoViewerUtils.b(arrayList), 0);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public int getResId() {
        return R.layout.item_fast_news_index;
    }

    public final HashMap<String, Object> i() {
        return new HashMap<String, Object>() {
            {
                String J = r.x().J();
                put("uid", (J == null || J.equals("")) ? "0" : J);
                put("type", 1);
                put("timestamp", Long.valueOf(System.currentTimeMillis()));
                if (IndexInformationHandler.this.f74124c != null) {
                    if (IndexInformationHandler.this.f74124c.k() != null) {
                        put("contentid", Long.valueOf(IndexInformationHandler.this.f74124c.k().getId()));
                        put("title", IndexInformationHandler.this.f74124c.k().getTitle());
                    }
                    put("category", "homefeeds");
                    put("recom_base_info", IndexInformationHandler.this.f74124c.d());
                }
            }
        };
    }

    public final void j(Context context, NewFlashInformation newFlashInformation) {
        g.i("app_news_rechome_nrkp", i());
        long dynamicId = newFlashInformation.getDynamicId();
        if (0 == dynamicId) {
            long id2 = newFlashInformation.getId();
            if (0 != id2) {
                Intent intent = new Intent(context, NewsDetailActivity.class);
                intent.putExtra("newflashId", String.valueOf(id2));
                intent.putExtra("feedCommentClick", false);
                context.startActivity(intent);
                return;
            }
            return;
        }
        a.d().a("/content/DynamicDetail").withString("dynamicId", String.valueOf(dynamicId)).navigation();
    }

    /* renamed from: k */
    public void handleView(v9.c cVar, int i11, IndexInformationItem indexInformationItem, ViewGroup viewGroup) {
        this.f74124c = indexInformationItem;
        i6.r e11 = cVar.e();
        Context context = cVar.itemView.getContext();
        TextView textView = (TextView) e11.b(R.id.tvDate);
        View b11 = e11.b(R.id.vHideView);
        LinearLayout linearLayout = (LinearLayout) e11.b(R.id.llNewsTop);
        TextView textView2 = (TextView) e11.b(R.id.tvTime);
        TextView textView3 = (TextView) e11.b(R.id.tvTitle);
        ExpandableTextView expandableTextView = (ExpandableTextView) e11.b(R.id.tvContent);
        ConstraintLayout constraintLayout = (ConstraintLayout) e11.b(R.id.clPic);
        ImageView imageView = (ImageView) e11.b(R.id.ivPic);
        TextView textView4 = (TextView) e11.b(R.id.tvRise);
        ImageView imageView2 = (ImageView) e11.b(R.id.imageRise);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) e11.b(R.id.lottieRise);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) e11.b(R.id.consPut);
        TextView textView5 = (TextView) e11.b(R.id.tvPut);
        ImageView imageView3 = (ImageView) e11.b(R.id.imagePut);
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) e11.b(R.id.lottiePut);
        ConstraintLayout constraintLayout3 = (ConstraintLayout) e11.b(R.id.consRise);
        ConstraintLayout constraintLayout4 = (ConstraintLayout) e11.b(R.id.consShare);
        TextView textView6 = (TextView) e11.b(R.id.tvLink);
        e11.b(R.id.vLine);
        b.R(textView3);
        NewFlashInformation k11 = indexInformationItem.k();
        k11.getCoinTags();
        boolean isEmpty = TextUtils.isEmpty(indexInformationItem.f());
        TextView textView7 = (TextView) e11.b(R.id.tvShare);
        TextView textView8 = (TextView) e11.b(R.id.tvComment);
        if (isEmpty) {
            textView.setVisibility(8);
            b11.setVisibility(8);
            ((LinearLayout.LayoutParams) linearLayout.getLayoutParams()).topMargin = (int) linearLayout.getContext().getResources().getDimension(R.dimen.dimen_9);
        } else {
            textView.setVisibility(0);
            textView.setText(indexInformationItem.f());
            b11.setVisibility(0);
            ((LinearLayout.LayoutParams) linearLayout.getLayoutParams()).topMargin = 0;
        }
        linearLayout.requestLayout();
        textView3.setTextColor(ContextCompat.getColor(context, k11.getRank() == 0 ? R.color.baseColorPrimaryText : R.color.color_news_light_title));
        textView2.setText(DateTimeUtils.t(k11.getIssueTime()));
        textView3.setText(k11.getTitle());
        expandableTextView.setContent((CharSequence) k11.getContent(), StatusType.STATUS_EXPAND);
        expandableTextView.setExpandOrContractClickListener(new l(this, context, k11));
        expandableTextView.setOnClickListener(new i(this, context, k11));
        e11.b(R.id.consComment).setOnClickListener(new h(this, context, k11));
        try {
            if (k11.getImages() == null || k11.getImages().size() <= 0) {
                constraintLayout.setVisibility(8);
            } else {
                constraintLayout.setVisibility(0);
                he.b.i(imageView, k11.getImages().get(0).getImage());
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        LottieAnimationView lottieAnimationView3 = lottieAnimationView;
        ImageView imageView4 = imageView3;
        ConstraintLayout constraintLayout5 = constraintLayout2;
        ImageView imageView5 = imageView2;
        r(context, k11, imageView2, textView4, imageView3, textView5, textView8, textView7);
        TextView textView9 = textView6;
        textView9.setText(k11.getLinkTitle());
        textView9.setVisibility((TextUtils.isEmpty(k11.getLinkTitle()) || TextUtils.isEmpty(k11.getLink())) ? 8 : 0);
        textView9.setOnClickListener(new f(context, k11));
        v9.c cVar2 = cVar;
        cVar2.itemView.setOnClickListener(new g(this, context, k11));
        imageView.setOnClickListener(new j(this, k11));
        ConstraintLayout constraintLayout6 = constraintLayout3;
        constraintLayout6.setOnClickListener(this);
        constraintLayout6.setTag(R.id.item_data2, Integer.valueOf(i11));
        IndexInformationItem indexInformationItem2 = indexInformationItem;
        constraintLayout6.setTag(R.id.item_data1, indexInformationItem2);
        constraintLayout5.setOnClickListener(this);
        constraintLayout5.setTag(R.id.item_data2, Integer.valueOf(i11));
        constraintLayout5.setTag(R.id.item_data1, indexInformationItem2);
        ConstraintLayout constraintLayout7 = constraintLayout4;
        constraintLayout7.setOnClickListener(this);
        constraintLayout7.setTag(R.id.item_data2, Integer.valueOf(i11));
        constraintLayout7.setTag(R.id.item_data1, indexInformationItem2);
        cVar2.itemView.setTag(R.id.item_data2, Integer.valueOf(i11));
        cVar2.itemView.setTag(R.id.item_data1, indexInformationItem2);
        lottieAnimationView3.setTag(R.id.item_position, Integer.valueOf(i11));
        ImageView imageView6 = imageView5;
        imageView6.setTag(R.id.item_position, Integer.valueOf(i11));
        LottieAnimationView lottieAnimationView4 = lottieAnimationView2;
        lottieAnimationView4.setTag(R.id.item_position, Integer.valueOf(i11));
        ImageView imageView7 = imageView4;
        imageView7.setTag(R.id.item_position, Integer.valueOf(i11));
        lottieAnimationView3.cancelAnimation();
        lottieAnimationView4.cancelAnimation();
        lottieAnimationView3.setVisibility(8);
        lottieAnimationView4.setVisibility(8);
        imageView6.setVisibility(0);
        imageView7.setVisibility(0);
        indexInformationItem2.l(new k(this, imageView6, lottieAnimationView3, imageView7, lottieAnimationView4, context, k11, textView4, textView5, textView8, textView7));
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        view.getContext();
        IndexInformationItem indexInformationItem = (IndexInformationItem) view.getTag(R.id.item_data1);
        int intValue = ((Integer) view.getTag(R.id.item_data2)).intValue();
        switch (view.getId()) {
            case R.id.consPut:
                if (System.currentTimeMillis() - f74122e > 2000) {
                    if (indexInformationItem.e() != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("contentid", Long.valueOf(indexInformationItem.k().getId()));
                        g.i("APP_HP_Bearish_hits", hashMap);
                        indexInformationItem.e().a(intValue, 2, indexInformationItem);
                    }
                    f74122e = System.currentTimeMillis();
                    g.i("app_news_rechome_nrkpkd", i());
                    break;
                }
                break;
            case R.id.consRise:
                if (System.currentTimeMillis() - f74121d > 2000) {
                    if (indexInformationItem.e() != null) {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("contentid", Long.valueOf(indexInformationItem.k().getId()));
                        g.i("APP_HP_Bullish_hits", hashMap2);
                        indexInformationItem.e().a(intValue, 1, indexInformationItem);
                    }
                    f74121d = System.currentTimeMillis();
                    g.i("app_news_rechome_nrkpkz", i());
                    break;
                }
                break;
            case R.id.consShare:
                if (indexInformationItem.e() != null) {
                    g.i("app_news_rechome_nrkpfx", i());
                    indexInformationItem.e().b(intValue, indexInformationItem);
                    break;
                }
                break;
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void r(Context context, NewFlashInformation newFlashInformation, ImageView imageView, TextView textView, ImageView imageView2, TextView textView2, TextView textView3, TextView textView4) {
        if (newFlashInformation.getVotedType() == 0) {
            imageView.setImageResource(R.drawable.information_up_normal);
            textView.setTextColor(ContextCompat.getColor(context, R.color.baseColorSecondaryTextNew));
            imageView2.setImageResource(R.drawable.information_down_normal);
            textView2.setTextColor(ContextCompat.getColor(context, R.color.baseColorSecondaryTextNew));
        } else if (newFlashInformation.getVotedType() == 1) {
            textView.setTextColor(ContextCompat.getColor(context, w.h()));
            if (w.l()) {
                imageView.setImageResource(R.drawable.information_up_red);
            } else {
                imageView.setImageResource(R.drawable.information_up_green);
            }
            imageView2.setImageResource(R.drawable.information_down_normal);
            textView2.setTextColor(ContextCompat.getColor(context, R.color.baseColorSecondaryTextNew));
        } else {
            textView.setTextColor(ContextCompat.getColor(context, R.color.baseColorSecondaryTextNew));
            imageView.setImageResource(R.drawable.information_up_normal);
            if (w.l()) {
                imageView2.setImageResource(R.drawable.information_down_green);
            } else {
                imageView2.setImageResource(R.drawable.information_down_red);
            }
            textView2.setTextColor(ContextCompat.getColor(context, w.d()));
        }
        he.b.l(textView, String.valueOf(newFlashInformation.getBullVote()));
        he.b.l(textView2, String.valueOf(newFlashInformation.getBadVote()));
        he.b.l(textView3, String.valueOf(newFlashInformation.getComments()));
        he.b.l(textView4, String.valueOf(newFlashInformation.getShared()));
    }
}
