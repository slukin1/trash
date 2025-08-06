package com.huobi.homemarket.handler;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hbg.lib.widgets.CommonCheckBox;
import com.hbg.module.market.R$id;
import com.hbg.module.market.R$layout;
import com.huobi.homemarket.model.CollEditModel;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import org.greenrobot.eventbus.EventBus;
import pl.a;
import ql.i;
import ql.j;
import ql.k;
import s9.c;

public class CollEditViewHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void f(CollEditModel collEditModel, CommonCheckBox commonCheckBox, View view) {
        if (collEditModel.isCollection()) {
            collEditModel.setCollection(false);
            commonCheckBox.setChecked(false);
        } else {
            collEditModel.setCollection(true);
            commonCheckBox.setChecked(true);
        }
        EventBus.d().k(new a(collEditModel.isCollection()));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ boolean g(CollEditModel collEditModel, v9.c cVar, View view, MotionEvent motionEvent) {
        if (collEditModel.getItemTouchHelp() == null) {
            return false;
        }
        collEditModel.getItemTouchHelp().w(cVar);
        return false;
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void h(CollEditModel collEditModel, View view) {
        if (collEditModel.getCallback() != null) {
            collEditModel.getCallback().a(collEditModel);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: e */
    public void handleView(v9.c cVar, int i11, CollEditModel collEditModel, ViewGroup viewGroup) {
        r e11 = cVar.e();
        cVar.itemView.getResources();
        CommonCheckBox commonCheckBox = (CommonCheckBox) e11.b(R$id.market_check_cb);
        TextView textView = (TextView) e11.b(R$id.market_symbol_tv2);
        ImageView imageView = (ImageView) e11.b(R$id.market_coll_drag_iv);
        RelativeLayout relativeLayout = (RelativeLayout) e11.b(R$id.market_check_rl);
        View b11 = e11.b(R$id.market_coll_top_iv);
        ((TextView) e11.b(R$id.market_symbol_tv)).setText(collEditModel.getShowSymbol());
        if (!TextUtils.isEmpty(collEditModel.getQuoteCurrency())) {
            textView.setText(collEditModel.getQuoteCurrency());
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        commonCheckBox.setChecked(collEditModel.isCollection());
        relativeLayout.setOnClickListener(new j(collEditModel, commonCheckBox));
        imageView.setOnTouchListener(new k(collEditModel, cVar));
        b11.setOnClickListener(new i(collEditModel));
    }

    public int getResId() {
        return R$layout.market_coll_edit_item;
    }
}
