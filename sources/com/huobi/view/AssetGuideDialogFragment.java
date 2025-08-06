package com.huobi.view;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$color;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.n;
import i6.r;

public class AssetGuideDialogFragment extends BaseDialogFragment {
    public static final String SAVE_SHOW_COUNT = "SAVE_SHOW_COUNT";
    private TextView mConvertView;
    private View mDividerView;
    private ViewGroup mGuideLayout1;
    private ViewGroup mGuideLayout2;
    private ViewGroup mGuideLayout3;
    private ViewGroup mGuideLayout4;
    private ViewGroup mGuideLayout5;
    private ImageView mIvBottom;
    private TextView mProfitView;
    /* access modifiers changed from: private */
    public View mRootView;
    /* access modifiers changed from: private */
    public View mTopMarginView;
    private TextView mTvBTCGuide1;
    private TextView mTvBTCGuide2;
    private TextView mTvBTCGuide3;
    private TextView mTvBTCGuide4;
    private TextView mTvBTCGuide5;
    private TextView mTvBTCGuide6;
    private TextView mTvBTCGuide7;
    private TextView mTvBTCGuide8;
    private TextView mTvBottom;
    private TextView mTvCoinAverage;
    private TextView mTvCoinFlag;
    private TextView mTvCoinLimit;
    private TextView mTvCoinName;
    private TextView mTvCoinPosition;
    private TextView mTvCoinPositionType;
    private TextView mTvCoinProfit;
    private TextView mTvCoinProfitNumber;
    private TextView mTvHint1;
    private TextView mTvHint2;
    private TextView mTvHint3;
    private TextView mTvHint4;
    private TextView mTvHint5;
    private TextView mTvNameGuide1;
    private TextView mTvNameGuide2;
    private TextView mTvNameGuide3;
    private TextView mTvNameGuide4;
    private TextView mTvNameGuide5;
    private TextView mTvNameGuide6;
    private TextView mTvNameGuide7;
    private TextView mTvNameGuide8;
    private TextView mTvNext1;
    private TextView mTvNext2;
    private TextView mTvNext3;
    private TextView mTvNext4;
    private TextView mTvNext5;
    private TextView mTvProfit;
    private TextView mTvShow2;
    private TextView mTvSkip;
    private TextView mTvTitleCoinCenter;
    private TextView mTvTitleCoinEnd;
    private TextView mTvTitleCoinName;
    private TextView mTvUSDGuide1;
    private TextView mTvUSDGuide2;
    private TextView mTvUSDGuide3;
    private TextView mTvUSDGuide4;
    private TextView mTvUSDGuide5;
    private TextView mTvUSDGuide6;
    private TextView mTvUSDGuide7;
    private TextView mTvUSDGuide8;
    private TextView mTvUnit;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        dismiss();
        AssetModuleConfig.a().z(false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        this.mGuideLayout1.setVisibility(8);
        this.mGuideLayout2.setVisibility(0);
        this.mGuideLayout3.setVisibility(8);
        this.mGuideLayout4.setVisibility(8);
        this.mGuideLayout5.setVisibility(8);
        this.mTvSkip.setVisibility(0);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        this.mGuideLayout1.setVisibility(8);
        this.mGuideLayout2.setVisibility(8);
        this.mGuideLayout3.setVisibility(0);
        this.mGuideLayout4.setVisibility(8);
        this.mGuideLayout5.setVisibility(8);
        this.mTvSkip.setVisibility(0);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        this.mGuideLayout1.setVisibility(8);
        this.mGuideLayout2.setVisibility(8);
        this.mGuideLayout3.setVisibility(8);
        this.mGuideLayout4.setVisibility(0);
        this.mGuideLayout5.setVisibility(8);
        this.mTvSkip.setVisibility(0);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        this.mGuideLayout1.setVisibility(8);
        this.mGuideLayout2.setVisibility(8);
        this.mGuideLayout3.setVisibility(8);
        this.mGuideLayout4.setVisibility(8);
        this.mGuideLayout5.setVisibility(0);
        this.mTvSkip.setVisibility(8);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$5(View view) {
        dismiss();
        AssetModuleConfig.a().z(false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void addEvent(r rVar) {
        this.mTvSkip.setOnClickListener(new k(this));
        this.mTvNext1.setOnClickListener(new i(this));
        this.mTvNext2.setOnClickListener(new j(this));
        this.mTvNext3.setOnClickListener(new f(this));
        this.mTvNext4.setOnClickListener(new g(this));
        this.mTvNext5.setOnClickListener(new h(this));
    }

    public void afterInit() {
        this.mGuideLayout1.setVisibility(0);
        TextView textView = this.mTvProfit;
        Resources resources = getResources();
        int i11 = R$color.color_rise;
        textView.setTextColor(resources.getColor(i11));
        this.mTvProfit.setText("+1.27%");
        this.mProfitView.setText("+0.0032");
        this.mProfitView.setTextColor(getResources().getColor(i11));
        this.mTvUnit.setText("BTC");
        this.mConvertView.setText("≈ 142.68 USD");
        this.mTvHint1.setText(getString(R$string.n_asset_guide_hint_page_one));
        TextView textView2 = this.mTvNext1;
        int i12 = R$string.n_grid_user_guide_next;
        textView2.setText(getString(i12));
        this.mGuideLayout2.setVisibility(8);
        this.mTvShow2.setText(getString(R$string.n_asset_account_unfold_all));
        this.mTvHint2.setText(getString(R$string.n_asset_guide_hint_page_two));
        this.mTvNext2.setText(getString(i12));
        this.mGuideLayout3.setVisibility(8);
        this.mTvNameGuide1.setText(getString(R$string.n_spot));
        this.mTvBTCGuide1.setText("3.291127 BTC");
        this.mTvUSDGuide1.setText("≈144527.5 USD");
        TextView textView3 = this.mTvNameGuide2;
        int i13 = R$string.n_balance_contract_title;
        textView3.setText(getString(i13));
        this.mTvBTCGuide2.setText("0.93222575 BTC");
        this.mTvUSDGuide2.setText("≈40886 USD");
        this.mTvNameGuide3.setText(getString(R$string.margin_toolbar_header_title));
        this.mTvBTCGuide3.setText("4.28823845 BTC");
        this.mTvUSDGuide3.setText("≈188075.6 USD");
        this.mTvNameGuide4.setText(getString(R$string.n_asset_ybb_stop_financial));
        this.mTvBTCGuide4.setText("0.1864515 BTC");
        this.mTvUSDGuide4.setText("≈8177.2 USD");
        this.mTvNameGuide5.setText(getString(R$string.n_quantization_account).replace("账户", ""));
        this.mTvBTCGuide5.setText("0.52658032 BTC");
        this.mTvUSDGuide5.setText("≈23124.4 USD");
        this.mTvNameGuide6.setText(getString(R$string.mine_toolbar_header_title));
        this.mTvBTCGuide6.setText("0.7457806 BTC");
        this.mTvUSDGuide6.setText("≈32708.8 USD");
        this.mTvNameGuide7.setText(getString(R$string.n_otc_options_account).replace("账户", ""));
        this.mTvBTCGuide7.setText("3.15948192 BTC");
        this.mTvUSDGuide7.setText("≈138746.4 USD");
        this.mTvNameGuide8.setText(getString(R$string.n_asset_mortgage_account).replace("账户", ""));
        this.mTvBTCGuide8.setText("0.19746762 BTC");
        this.mTvUSDGuide8.setText("≈8671.65.4 USD");
        this.mDividerView.setVisibility(8);
        this.mTvBottom.setText(getString(R$string.n_fold_all));
        this.mIvBottom.setRotation(180.0f);
        this.mTvHint3.setText(getString(R$string.n_asset_guide_hint_page_three));
        this.mTvNext3.setText(getString(i12));
        this.mGuideLayout4.setVisibility(8);
        this.mTvTitleCoinName.setText(getString(i13));
        TextView textView4 = this.mTvTitleCoinCenter;
        textView4.setText(getString(R$string.n_contract_trade_position_hold) + "(" + getString(R$string.n_contract_trade_unit_sheet) + ") | " + getString(R$string.n_contract_avg_open_price));
        TextView textView5 = this.mTvTitleCoinEnd;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getString(R$string.n_contract_profit));
        sb2.append("(USD) | ");
        sb2.append(getResources().getString(R$string.n_contract_yield));
        textView5.setText(sb2.toString());
        this.mTvCoinFlag.setText(getString(R$string.contarct_position_more));
        this.mTvCoinFlag.setBackgroundColor(getResources().getColor(i11));
        this.mTvCoinName.setText("ADA/USDT");
        this.mTvCoinPositionType.setText(getString(R$string.n_contract_trade_margin));
        TextView textView6 = this.mTvCoinLimit;
        textView6.setText(getString(R$string.n_market_contract_swap_trade_name) + " 5X");
        this.mTvCoinPosition.setText("0.00987969(ADA)");
        this.mTvCoinAverage.setText("39073.9");
        this.mTvCoinProfit.setText("+23.9787");
        this.mTvCoinProfitNumber.setText("+34.09%");
        this.mTvHint4.setText(getString(R$string.n_asset_guide_hint_page_four));
        this.mTvNext4.setText(getString(i12));
        this.mGuideLayout5.setVisibility(8);
        this.mTvHint5.setText(getString(R$string.n_asset_guide_hint_page_five));
        this.mTvNext5.setText(getString(R$string.n_asset_guide_go_experience));
        TextView textView7 = this.mTvSkip;
        textView7.setText(getString(R$string.n_asset_guide_skip) + " ＞");
        setCanDismissOnBackPress(false);
    }

    public int getContentViewResId() {
        return R$layout.layout_new_asset_guide;
    }

    public int getGravity() {
        return 17;
    }

    public void initView(r rVar) {
        this.mRootView = rVar.b(R$id.clyt_dialog_root);
        this.mTopMarginView = rVar.b(R$id.view_top);
        this.mRootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                int[] iArr = new int[2];
                AssetGuideDialogFragment.this.mRootView.getLocationOnScreen(iArr);
                if (iArr[1] == 0) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) AssetGuideDialogFragment.this.mTopMarginView.getLayoutParams();
                    marginLayoutParams.topMargin += n.h(AssetGuideDialogFragment.this.getContext());
                    AssetGuideDialogFragment.this.mTopMarginView.setLayoutParams(marginLayoutParams);
                    AssetGuideDialogFragment.this.mRootView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            }
        });
        this.mGuideLayout1 = (ViewGroup) rVar.b(R$id.clyt_guide_one);
        this.mTvProfit = (TextView) rVar.b(R$id.tv_profit_ratio);
        this.mProfitView = (TextView) rVar.b(R$id.tv_total_profit_btc);
        this.mTvUnit = (TextView) rVar.b(R$id.tv_profit_btc_unit);
        this.mConvertView = (TextView) rVar.b(R$id.tv_profit_legal);
        this.mTvHint1 = (TextView) rVar.b(R$id.tv_guide_one);
        this.mTvNext1 = (TextView) rVar.b(R$id.tv_guide_next_one);
        this.mGuideLayout2 = (ViewGroup) rVar.b(R$id.clyt_guide_two);
        View b11 = rVar.b(R$id.include_guide_two);
        int i11 = R$id.tv_fold;
        this.mTvShow2 = (TextView) b11.findViewById(i11);
        this.mTvHint2 = (TextView) rVar.b(R$id.tv_guide_two);
        this.mTvNext2 = (TextView) rVar.b(R$id.tv_guide_next_two);
        this.mGuideLayout3 = (ViewGroup) rVar.b(R$id.clyt_guide_three);
        View b12 = rVar.b(R$id.include_guide_three_1);
        int i12 = R$id.tv_title;
        this.mTvNameGuide1 = (TextView) b12.findViewById(i12);
        int i13 = R$id.tv_amount;
        this.mTvBTCGuide1 = (TextView) b12.findViewById(i13);
        int i14 = R$id.tv_amount_legal;
        this.mTvUSDGuide1 = (TextView) b12.findViewById(i14);
        View b13 = rVar.b(R$id.include_guide_three_2);
        this.mTvNameGuide2 = (TextView) b13.findViewById(i12);
        this.mTvBTCGuide2 = (TextView) b13.findViewById(i13);
        this.mTvUSDGuide2 = (TextView) b13.findViewById(i14);
        View b14 = rVar.b(R$id.include_guide_three_3);
        this.mTvNameGuide3 = (TextView) b14.findViewById(i12);
        this.mTvBTCGuide3 = (TextView) b14.findViewById(i13);
        this.mTvUSDGuide3 = (TextView) b14.findViewById(i14);
        View b15 = rVar.b(R$id.include_guide_three_4);
        this.mTvNameGuide4 = (TextView) b15.findViewById(i12);
        this.mTvBTCGuide4 = (TextView) b15.findViewById(i13);
        this.mTvUSDGuide4 = (TextView) b15.findViewById(i14);
        View b16 = rVar.b(R$id.include_guide_three_5);
        this.mTvNameGuide5 = (TextView) b16.findViewById(i12);
        this.mTvBTCGuide5 = (TextView) b16.findViewById(i13);
        this.mTvUSDGuide5 = (TextView) b16.findViewById(i14);
        View b17 = rVar.b(R$id.include_guide_three_6);
        this.mTvNameGuide6 = (TextView) b17.findViewById(i12);
        this.mTvBTCGuide6 = (TextView) b17.findViewById(i13);
        this.mTvUSDGuide6 = (TextView) b17.findViewById(i14);
        View b18 = rVar.b(R$id.include_guide_three_7);
        this.mTvNameGuide7 = (TextView) b18.findViewById(i12);
        this.mTvBTCGuide7 = (TextView) b18.findViewById(i13);
        this.mTvUSDGuide7 = (TextView) b18.findViewById(i14);
        View b19 = rVar.b(R$id.include_guide_three_8);
        this.mTvNameGuide8 = (TextView) b19.findViewById(i12);
        this.mTvBTCGuide8 = (TextView) b19.findViewById(i13);
        this.mTvUSDGuide8 = (TextView) b19.findViewById(i14);
        View b21 = rVar.b(R$id.include_guide_three_end);
        this.mDividerView = b21.findViewById(R$id.line);
        this.mTvBottom = (TextView) b21.findViewById(i11);
        this.mIvBottom = (ImageView) b21.findViewById(R$id.iv_fold_icon);
        this.mTvHint3 = (TextView) rVar.b(R$id.tv_guide_three);
        this.mTvNext3 = (TextView) rVar.b(R$id.tv_guide_next_three);
        this.mGuideLayout4 = (ViewGroup) rVar.b(R$id.rlyt_guide_four);
        View b22 = rVar.b(R$id.include_guide_four);
        this.mTvTitleCoinName = (TextView) b22.findViewById(R$id.contract_header_title_name);
        this.mTvTitleCoinCenter = (TextView) b22.findViewById(R$id.contract_header_center_text);
        this.mTvTitleCoinEnd = (TextView) b22.findViewById(R$id.contract_header_end_text);
        View b23 = rVar.b(R$id.include_guide_four_2);
        this.mTvCoinFlag = (TextView) b23.findViewById(R$id.many);
        this.mTvCoinName = (TextView) b23.findViewById(R$id.coin_symbol);
        this.mTvCoinPositionType = (TextView) b23.findViewById(R$id.position_type);
        this.mTvCoinLimit = (TextView) b23.findViewById(R$id.limit);
        this.mTvCoinPosition = (TextView) b23.findViewById(R$id.contract_position);
        this.mTvCoinAverage = (TextView) b23.findViewById(R$id.average_price);
        this.mTvCoinProfit = (TextView) b23.findViewById(R$id.contract_profit);
        this.mTvCoinProfitNumber = (TextView) b23.findViewById(R$id.contract_profit_number);
        this.mTvHint4 = (TextView) rVar.b(R$id.tv_guide_four);
        this.mTvNext4 = (TextView) rVar.b(R$id.tv_guide_four_next);
        this.mGuideLayout5 = (ViewGroup) rVar.b(R$id.rlyt_guide_five);
        this.mTvHint5 = (TextView) rVar.b(R$id.tv_guide_five);
        this.mTvNext5 = (TextView) rVar.b(R$id.tv_guide_five_next);
        this.mTvSkip = (TextView) rVar.b(R$id.tv_skip_guide);
    }

    public boolean isTransparent() {
        return false;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getDialog() != null) {
            getDialog().getWindow().addFlags(1024);
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        AssetModuleConfig.a().z(false);
    }

    public void show(FragmentManager fragmentManager, String str) {
        AssetModuleConfig.a().z(true);
        super.show(fragmentManager, str);
    }
}
