package com.huobi.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.hbg.lib.widgets.R$styleable;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import g6.b;
import java.util.ArrayList;
import java.util.List;

public class HomeMoneyView extends RelativeLayout implements View.OnClickListener {
    private static final int MAX_ITEM = 3;
    private static final String TAG = "HomeMoneyView";
    private CallBack callBack;
    private View layoutOne;
    private View layoutThree;
    private View layoutTwo;
    private List<ItemHomeMoneyViewBean> lists;
    private View thisView;
    private int type;

    public interface CallBack {
        void itemClick(ItemHomeMoneyViewBean itemHomeMoneyViewBean);

        void oneClick(ItemHomeMoneyViewBean itemHomeMoneyViewBean);

        void threeClick(ItemHomeMoneyViewBean itemHomeMoneyViewBean);

        void twoClick(ItemHomeMoneyViewBean itemHomeMoneyViewBean);
    }

    public static class ItemHomeMoneyViewBean {
        /* access modifiers changed from: private */
        public String bankImage;
        private String code;
        /* access modifiers changed from: private */
        public String desc;
        /* access modifiers changed from: private */
        public String tag;
        /* access modifiers changed from: private */
        public String title;

        public ItemHomeMoneyViewBean() {
        }

        public String getBankImage() {
            return this.bankImage;
        }

        public String getCode() {
            return this.code;
        }

        public String getDesc() {
            return this.desc;
        }

        public String getTag() {
            return this.tag;
        }

        public String getTitle() {
            return this.title;
        }

        public void setBankImage(String str) {
            this.bankImage = str;
        }

        public void setCode(String str) {
            this.code = str;
        }

        public void setDesc(String str) {
            this.desc = str;
        }

        public void setTag(String str) {
            this.tag = str;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public ItemHomeMoneyViewBean(String str, String str2, String str3, String str4, String str5) {
            this.title = str;
            this.desc = str2;
            this.bankImage = str3;
            this.code = str4;
            this.tag = str5;
        }
    }

    public HomeMoneyView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void initOneView(ItemHomeMoneyViewBean itemHomeMoneyViewBean) {
        ((TextView) this.thisView.findViewById(R$id.buy_with_ru)).setText(itemHomeMoneyViewBean.title);
        ((TextView) this.thisView.findViewById(R$id.visa_master)).setText(itemHomeMoneyViewBean.desc);
        b.c().h((ImageView) this.thisView.findViewById(R$id.icon), itemHomeMoneyViewBean.bankImage);
        TextView textView = (TextView) this.thisView.findViewById(R$id.home_type_one_tag);
        String access$300 = itemHomeMoneyViewBean.tag;
        if (!TextUtils.isEmpty(access$300)) {
            textView.setText(access$300);
            textView.setVisibility(0);
        }
    }

    /* JADX WARNING: type inference failed for: r12v8, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void initThreeView(com.huobi.view.HomeMoneyView.ItemHomeMoneyViewBean r12, com.huobi.view.HomeMoneyView.ItemHomeMoneyViewBean r13, com.huobi.view.HomeMoneyView.ItemHomeMoneyViewBean r14) {
        /*
            r11 = this;
            android.view.View r0 = r11.thisView
            int r1 = com.hbg.lib.widgets.R$id.buy_with_ru_three
            android.view.View r0 = r0.findViewById(r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            android.view.View r1 = r11.thisView
            int r2 = com.hbg.lib.widgets.R$id.visa_master_three
            android.view.View r1 = r1.findViewById(r2)
            android.widget.TextView r1 = (android.widget.TextView) r1
            android.view.View r2 = r11.thisView
            int r3 = com.hbg.lib.widgets.R$id.icon_three
            android.view.View r2 = r2.findViewById(r3)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            android.view.View r3 = r11.thisView
            int r4 = com.hbg.lib.widgets.R$id.buy_with_ru_three_1
            android.view.View r3 = r3.findViewById(r4)
            android.widget.TextView r3 = (android.widget.TextView) r3
            android.view.View r4 = r11.thisView
            int r5 = com.hbg.lib.widgets.R$id.visa_master_three_1
            android.view.View r4 = r4.findViewById(r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            android.view.View r5 = r11.thisView
            int r6 = com.hbg.lib.widgets.R$id.icon_three_1
            android.view.View r5 = r5.findViewById(r6)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            android.view.View r6 = r11.thisView
            int r7 = com.hbg.lib.widgets.R$id.buy_with_ru_three_2
            android.view.View r6 = r6.findViewById(r7)
            android.widget.TextView r6 = (android.widget.TextView) r6
            android.view.View r7 = r11.thisView
            int r8 = com.hbg.lib.widgets.R$id.visa_master_three_2
            android.view.View r7 = r7.findViewById(r8)
            android.widget.TextView r7 = (android.widget.TextView) r7
            android.view.View r8 = r11.thisView
            int r9 = com.hbg.lib.widgets.R$id.icon_three_2
            android.view.View r8 = r8.findViewById(r9)
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            java.lang.String r9 = r12.title
            r0.setText(r9)
            java.lang.String r0 = r12.desc
            r1.setText(r0)
            g6.b r0 = g6.b.c()
            java.lang.String r1 = r12.bankImage
            r0.h(r2, r1)
            java.lang.String r0 = r13.title
            r3.setText(r0)
            java.lang.String r0 = r13.desc
            r4.setText(r0)
            g6.b r0 = g6.b.c()
            java.lang.String r1 = r13.bankImage
            r0.h(r5, r1)
            java.lang.String r0 = r14.title
            r6.setText(r0)
            java.lang.String r0 = r14.desc
            r7.setText(r0)
            g6.b r0 = g6.b.c()
            java.lang.String r1 = r14.bankImage
            r0.h(r8, r1)
            java.lang.String r0 = r12.tag
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00be
            android.view.View r13 = r11.thisView
            int r14 = com.hbg.lib.widgets.R$id.home_type_three_tag_1
            android.view.View r13 = r13.findViewById(r14)
            android.widget.TextView r13 = (android.widget.TextView) r13
            java.lang.String r12 = r12.tag
            goto L_0x00f7
        L_0x00be:
            java.lang.String r12 = r13.tag
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 != 0) goto L_0x00da
            android.view.View r12 = r11.thisView
            int r14 = com.hbg.lib.widgets.R$id.home_type_three_tag_2
            android.view.View r12 = r12.findViewById(r14)
            android.widget.TextView r12 = (android.widget.TextView) r12
            java.lang.String r13 = r13.tag
            r10 = r13
            r13 = r12
            r12 = r10
            goto L_0x00f7
        L_0x00da:
            java.lang.String r12 = r14.tag
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 != 0) goto L_0x00f4
            android.view.View r12 = r11.thisView
            int r13 = com.hbg.lib.widgets.R$id.home_type_three_tag_3
            android.view.View r12 = r12.findViewById(r13)
            r13 = r12
            android.widget.TextView r13 = (android.widget.TextView) r13
            java.lang.String r12 = r14.tag
            goto L_0x00f7
        L_0x00f4:
            r13 = 0
            java.lang.String r12 = ""
        L_0x00f7:
            if (r13 == 0) goto L_0x0106
            boolean r14 = android.text.TextUtils.isEmpty(r12)
            if (r14 != 0) goto L_0x0106
            r14 = 0
            r13.setVisibility(r14)
            r13.setText(r12)
        L_0x0106:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.view.HomeMoneyView.initThreeView(com.huobi.view.HomeMoneyView$ItemHomeMoneyViewBean, com.huobi.view.HomeMoneyView$ItemHomeMoneyViewBean, com.huobi.view.HomeMoneyView$ItemHomeMoneyViewBean):void");
    }

    private void initTwoView(ItemHomeMoneyViewBean itemHomeMoneyViewBean, ItemHomeMoneyViewBean itemHomeMoneyViewBean2) {
        TextView textView;
        String str;
        ((TextView) this.thisView.findViewById(R$id.buy_with_ru_two)).setText(itemHomeMoneyViewBean.title);
        ((TextView) this.thisView.findViewById(R$id.visa_master_tow)).setText(itemHomeMoneyViewBean.desc);
        b.c().h((ImageView) this.thisView.findViewById(R$id.icon_tow), itemHomeMoneyViewBean.bankImage);
        ((TextView) this.thisView.findViewById(R$id.buy_with_ru_two_1)).setText(itemHomeMoneyViewBean2.title);
        ((TextView) this.thisView.findViewById(R$id.visa_master_tow_1)).setText(itemHomeMoneyViewBean2.desc);
        b.c().h((ImageView) this.thisView.findViewById(R$id.icon_tow_1), itemHomeMoneyViewBean2.bankImage);
        if (!TextUtils.isEmpty(itemHomeMoneyViewBean.tag)) {
            textView = (TextView) this.thisView.findViewById(R$id.home_type_two_tag);
            str = itemHomeMoneyViewBean.tag;
        } else if (!TextUtils.isEmpty(itemHomeMoneyViewBean2.tag)) {
            String access$300 = itemHomeMoneyViewBean2.tag;
            textView = (TextView) this.thisView.findViewById(R$id.home_type_two_tag_2);
            str = access$300;
        } else {
            textView = null;
            str = "";
        }
        if (textView != null && !TextUtils.isEmpty(str)) {
            textView.setVisibility(0);
            textView.setText(str);
        }
    }

    private void initView(TypedArray typedArray) {
        this.type = typedArray.getInteger(R$styleable.HomeMoneyView_home_money_type, 1);
        this.layoutOne = this.thisView.findViewById(R$id.layout_type_one);
        this.layoutTwo = this.thisView.findViewById(R$id.layout_type_two);
        this.layoutThree = this.thisView.findViewById(R$id.layout_type_three);
        View findViewById = this.thisView.findViewById(R$id.money_layout_two);
        View findViewById2 = this.thisView.findViewById(R$id.money_layout_two_1);
        View findViewById3 = this.thisView.findViewById(R$id.money_layout_three);
        View findViewById4 = this.thisView.findViewById(R$id.money_layout_three_1);
        View findViewById5 = this.thisView.findViewById(R$id.money_layout_three_2);
        setType(this.type);
        this.layoutOne.setOnClickListener(this);
        findViewById.setOnClickListener(this);
        findViewById3.setOnClickListener(this);
        findViewById2.setOnClickListener(this);
        findViewById4.setOnClickListener(this);
        findViewById5.setOnClickListener(this);
    }

    private void setType(int i11) {
        this.layoutOne.setVisibility(8);
        this.layoutTwo.setVisibility(8);
        this.layoutThree.setVisibility(8);
        if (i11 > 3) {
            this.type = 3;
        } else {
            this.type = i11;
        }
        if (i11 == 2) {
            this.layoutTwo.setVisibility(0);
        } else if (i11 != 3) {
            this.layoutOne.setVisibility(0);
            Log.d(TAG, "HomeMoneyView type is 1 or default type (type =" + i11 + ")");
        } else {
            this.layoutThree.setVisibility(0);
        }
    }

    public void notifyData(List<ItemHomeMoneyViewBean> list) {
        if (list != null && !list.isEmpty()) {
            setType(list.size());
            int size = list.size();
            int i11 = this.type;
            if (size < i11) {
                return;
            }
            if (i11 == 2) {
                initTwoView(list.get(0), list.get(1));
            } else if (i11 != 3) {
                initOneView(list.get(0));
            } else {
                initThreeView(list.get(0), list.get(1), list.get(2));
            }
        }
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (this.callBack != null) {
            int id2 = view.getId();
            if (id2 == R$id.layout_type_one || id2 == R$id.money_layout_two || id2 == R$id.money_layout_three) {
                if (this.lists.size() > 0) {
                    this.callBack.itemClick(this.lists.get(0));
                    this.callBack.oneClick(this.lists.get(0));
                } else {
                    this.callBack.itemClick((ItemHomeMoneyViewBean) null);
                    this.callBack.oneClick((ItemHomeMoneyViewBean) null);
                }
            } else if (id2 == R$id.money_layout_two_1 || id2 == R$id.money_layout_three_1) {
                if (this.lists.size() > 1) {
                    this.callBack.itemClick(this.lists.get(1));
                    this.callBack.twoClick(this.lists.get(1));
                } else {
                    this.callBack.itemClick((ItemHomeMoneyViewBean) null);
                    this.callBack.twoClick((ItemHomeMoneyViewBean) null);
                }
            } else if (id2 == R$id.money_layout_three_2) {
                if (this.lists.size() > 2) {
                    this.callBack.itemClick(this.lists.get(2));
                    this.callBack.threeClick(this.lists.get(2));
                } else {
                    this.callBack.itemClick((ItemHomeMoneyViewBean) null);
                    this.callBack.threeClick((ItemHomeMoneyViewBean) null);
                }
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void setCallBack(CallBack callBack2) {
        this.callBack = callBack2;
    }

    public void setData(List<ItemHomeMoneyViewBean> list) {
        this.lists.clear();
        this.lists.addAll(list);
        notifyData(list);
    }

    public HomeMoneyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HomeMoneyView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.lists = new ArrayList();
        this.type = 1;
        this.thisView = LayoutInflater.from(context).inflate(R$layout.home_money_layout, this, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.HomeMoneyView);
        initView(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public void notifyData() {
        notifyData(this.lists);
    }
}
