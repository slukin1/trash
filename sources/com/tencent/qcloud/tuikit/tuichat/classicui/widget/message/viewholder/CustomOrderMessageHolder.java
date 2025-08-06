package com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import c4.g;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.e;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.MessageContentHolder;
import com.tencent.qcloud.tuikit.timcommon.component.impl.GlideEngine;
import com.tencent.qcloud.tuikit.timcommon.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.CustomOrderMessageBean;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;

public class CustomOrderMessageHolder extends MessageContentHolder {
    public static final String TAG = "CustomOrderMessageHolder";
    private TextView contentView;
    private ImageView imageView;
    private TextView priceView;
    private TextView titleView;

    public CustomOrderMessageHolder(View view) {
        super(view);
        this.imageView = (ImageView) view.findViewById(R.id.content_image_iv);
        this.titleView = (TextView) view.findViewById(R.id.order_title);
        this.contentView = (TextView) view.findViewById(R.id.order_description);
        this.priceView = (TextView) view.findViewById(R.id.order_price);
    }

    public int getVariableLayout() {
        return R.layout.custom_order_message_layout;
    }

    public void layoutVariableViews(TUIMessageBean tUIMessageBean, int i11) {
        String str;
        String str2;
        final String str3;
        String str4;
        String str5 = "";
        if (tUIMessageBean instanceof CustomOrderMessageBean) {
            CustomOrderMessageBean customOrderMessageBean = (CustomOrderMessageBean) tUIMessageBean;
            String title = customOrderMessageBean.getTitle();
            str = customOrderMessageBean.getDescription();
            str4 = customOrderMessageBean.getPrice();
            str3 = customOrderMessageBean.getLink();
            String str6 = title;
            str5 = customOrderMessageBean.getImageUrl();
            str2 = str6;
        } else {
            str2 = str5;
            str = str2;
            str4 = str;
            str3 = str4;
        }
        GlideEngine.loadCornerImageWithoutPlaceHolder(this.imageView, str5, new e() {
            public boolean onLoadFailed(GlideException glideException, Object obj, g gVar, boolean z11) {
                String str = CustomOrderMessageHolder.TAG;
                TUIChatLog.e(str, "onLoadFailed e=" + glideException);
                return false;
            }

            public boolean onResourceReady(Object obj, Object obj2, g gVar, DataSource dataSource, boolean z11) {
                return false;
            }
        }, (float) ScreenUtil.dip2px(4.0f));
        this.titleView.setText(str2);
        this.contentView.setText(str);
        this.priceView.setText(str4);
        this.msgContentFrame.setClickable(true);
        this.msgContentFrame.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str3));
                intent.addFlags(268435456);
                ServiceInitializer.getAppContext().startActivity(intent);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
    }
}
