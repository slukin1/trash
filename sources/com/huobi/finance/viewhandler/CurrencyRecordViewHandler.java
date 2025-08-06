package com.huobi.finance.viewhandler;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import bl.j2;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.huobi.finance.bean.FinanceRecordItem;
import com.huobi.finance.ui.CurrencyDetailOrderActivity;
import com.huobi.finance.ui.UnifyRiskActivity;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sumsub.sns.internal.core.common.n0;
import d7.k;
import i6.m;
import java.util.Locale;
import oa.a;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;
import org.greenrobot.eventbus.EventBus;
import pro.huobi.R;
import s9.c;

public class CurrencyRecordViewHandler implements c, View.OnClickListener {
    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void h(View view, FinanceRecordItem financeRecordItem, View view2) {
        f(view.getContext(), financeRecordItem);
        SensorsDataAutoTrackHelper.trackViewOnClick(view2);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void i(FinanceRecordItem financeRecordItem, v9.c cVar, View view) {
        String str;
        String currency = financeRecordItem.getCurrency();
        String upperCase = currency.toUpperCase(Locale.US);
        String x11 = k.C().x(currency, financeRecordItem.getChain());
        if ("usdt".equals(currency)) {
            str = m.F(x11, 4);
        } else {
            str = m.F(x11, 8);
        }
        k(upperCase, str, cVar.itemView.getContext());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final String e(Context context, String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -2084295844:
                if (str.equals(FinanceRecordItem.TYPE_MASTER_TRANSFER_IN)) {
                    c11 = 0;
                    break;
                }
                break;
            case -2079162029:
                if (str.equals(FinanceRecordItem.TYPE_SYS_COUPON_YSTEM_TO_SPOT)) {
                    c11 = 1;
                    break;
                }
                break;
            case -2008443584:
                if (str.equals(FinanceRecordItem.TYPE_GLOBAL_ACTIVITY_TO_SPOT)) {
                    c11 = 2;
                    break;
                }
                break;
            case -1936523770:
                if (str.equals(FinanceRecordItem.TYPE_GLOBAL_REBATE_5)) {
                    c11 = 3;
                    break;
                }
                break;
            case -1923746100:
                if (str.equals(FinanceRecordItem.TYPE_FUND_RISE_SYSTEM_TO_FUND_ORG)) {
                    c11 = 4;
                    break;
                }
                break;
            case -1878752176:
                if (str.equals("mine-pool-transfer-in")) {
                    c11 = 5;
                    break;
                }
                break;
            case -1816318536:
                if (str.equals(FinanceRecordItem.TYPE_FUTURES_TO_PRO)) {
                    c11 = 6;
                    break;
                }
                break;
            case -1633968851:
                if (str.equals(FinanceRecordItem.TYPE_FINANCE_PROJECT_SYSTEM_TO_KOL_SYSTEM)) {
                    c11 = 7;
                    break;
                }
                break;
            case -1605601539:
                if (str.equals(FinanceRecordItem.TYPE_INSTITUTION_INVESTOR_TO_FUND_RISE_SYSTEM)) {
                    c11 = 8;
                    break;
                }
                break;
            case -1592102762:
                if (str.equals(FinanceRecordItem.TYPE_GLOBAL_REBATE_7)) {
                    c11 = 9;
                    break;
                }
                break;
            case -1559140840:
                if (str.equals(FinanceRecordItem.TYPE_POINT_REFUND)) {
                    c11 = 10;
                    break;
                }
                break;
            case -1528095678:
                if (str.equals(FinanceRecordItem.TYPE_GLOBAL_REBATE_8)) {
                    c11 = 11;
                    break;
                }
                break;
            case -1457541922:
                if (str.equals(FinanceRecordItem.TYPE_PRO_TO_FUTURES)) {
                    c11 = 12;
                    break;
                }
                break;
            case -1391285118:
                if (str.equals(FinanceRecordItem.TYPE_LINEAR_SWAP_TO_PRO)) {
                    c11 = 13;
                    break;
                }
                break;
            case -1285931775:
                if (str.equals(FinanceRecordItem.TYPE_SYS_OVERSEAS_ACTIVITY_TO_SPOT)) {
                    c11 = 14;
                    break;
                }
                break;
            case -1167865889:
                if (str.equals(FinanceRecordItem.TYPE_ETP_OPERATIONS_TO_SPOT)) {
                    c11 = 15;
                    break;
                }
                break;
            case -1105909470:
                if (str.equals(FinanceRecordItem.TYPE_FUND_RISE_SYSTEM_TO_FUNDER)) {
                    c11 = 16;
                    break;
                }
                break;
            case -929832390:
                if (str.equals(FinanceRecordItem.TYPE_SUB_TRANSFER_IN)) {
                    c11 = 17;
                    break;
                }
                break;
            case -896970345:
                if (str.equals(FinanceRecordItem.TYPE_FORK_TRANSFER_OUT)) {
                    c11 = 18;
                    break;
                }
                break;
            case -864804824:
                if (str.equals(FinanceRecordItem.TYPE_FINANCE_PROJECT_SYSTEM_TO_CHANNEL_SYSTEM)) {
                    c11 = 19;
                    break;
                }
                break;
            case -825179062:
                if (str.equals(FinanceRecordItem.TYPE_MINING_TO_PRO_1)) {
                    c11 = 20;
                    break;
                }
                break;
            case -772118412:
                if (str.equals(FinanceRecordItem.TYPE_BITEXPRO_TO_OLDHUOBI)) {
                    c11 = 21;
                    break;
                }
                break;
            case -766102330:
                if (str.equals(FinanceRecordItem.TYPE_GLOBAL_REBATE_1)) {
                    c11 = 22;
                    break;
                }
                break;
            case -709692792:
                if (str.equals(FinanceRecordItem.TYPE_SUPPER_MARGIN_OUT)) {
                    c11 = 23;
                    break;
                }
                break;
            case -671379322:
                if (str.equals(FinanceRecordItem.TYPE_PRO_TO_INSTITUTION)) {
                    c11 = 24;
                    break;
                }
                break;
            case -663964420:
                if (str.equals(FinanceRecordItem.TYPE_PRO_TO_OPTION)) {
                    c11 = 25;
                    break;
                }
                break;
            case -597593057:
                if (str.equals(FinanceRecordItem.TYPE_RED_ENVELOPE)) {
                    c11 = 26;
                    break;
                }
                break;
            case -545721176:
                if (str.equals("margin-transfer-in")) {
                    c11 = 27;
                    break;
                }
                break;
            case -433414350:
                if (str.equals(FinanceRecordItem.TYPE_SUPPER_MARGIN_IN)) {
                    c11 = 28;
                    break;
                }
                break;
            case -429939310:
                if (str.equals(FinanceRecordItem.ETP_SHARES_MERGE_SYS_TO_SPOT)) {
                    c11 = 29;
                    break;
                }
                break;
            case -420924858:
                if (str.equals(FinanceRecordItem.TYPE_USER_TO_ETP_PEPEL_SYS)) {
                    c11 = 30;
                    break;
                }
                break;
            case -250493783:
                if (str.equals(FinanceRecordItem.TYPE_GLOBAL_REBATE_4)) {
                    c11 = 31;
                    break;
                }
                break;
            case -188655625:
                if (str.equals(FinanceRecordItem.TYPE_MASTER_TRANSFER_OUT)) {
                    c11 = ' ';
                    break;
                }
                break;
            case -28934724:
                if (str.equals(FinanceRecordItem.TYPE_FORK_TRANSFER_IN)) {
                    c11 = '!';
                    break;
                }
                break;
            case 8774420:
                if (str.equals(FinanceRecordItem.TYPE_PRO_TO_LINEAR_SWAP)) {
                    c11 = '\"';
                    break;
                }
                break;
            case 48157262:
                if (str.equals(FinanceRecordItem.TYPE_BITEXPRO_TO_BITEX)) {
                    c11 = n0.h.f32179b;
                    break;
                }
                break;
            case 141853772:
                if (str.equals(FinanceRecordItem.TYPE_FUND_ORG_TO_FUND_RISE_SYSTEM)) {
                    c11 = DecodedChar.FNC1;
                    break;
                }
                break;
            case 165300204:
                if (str.equals(FinanceRecordItem.TYPE_PRO_TO_OTC)) {
                    c11 = '%';
                    break;
                }
                break;
            case 167228554:
                if (str.equals(FinanceRecordItem.TYPE_FINANCE_PROJECT_SYSTEM_TO_ACTIVITY_SYSTEM)) {
                    c11 = '&';
                    break;
                }
                break;
            case 188394184:
                if (str.equals(FinanceRecordItem.TYPE_PRO_TO_OTC_OPTIONS)) {
                    c11 = '\'';
                    break;
                }
                break;
            case 253340294:
                if (str.equals(FinanceRecordItem.TYPE_PRO_TO_MINING)) {
                    c11 = '(';
                    break;
                }
                break;
            case 253947942:
                if (str.equals(FinanceRecordItem.TYPE_AIRDROP)) {
                    c11 = ')';
                    break;
                }
                break;
            case 262518827:
                if (str.equals("margin-transfer-out")) {
                    c11 = '*';
                    break;
                }
                break;
            case 302999464:
                if (str.equals(FinanceRecordItem.TYPE_GLOBAL_REBATE_3)) {
                    c11 = '+';
                    break;
                }
                break;
            case 319813722:
                if (str.equals(FinanceRecordItem.TYPE_GLOBAL_REBATE_2)) {
                    c11 = ',';
                    break;
                }
                break;
            case 334388582:
                if (str.equals(FinanceRecordItem.TYPE_ETP_PEPEL_SYS_TO_USER)) {
                    c11 = '-';
                    break;
                }
                break;
            case 390628210:
                if (str.equals(FinanceRecordItem.TYPE_BITEX_TO_BITEXPRO)) {
                    c11 = '.';
                    break;
                }
                break;
            case 418662377:
                if (str.equals(FinanceRecordItem.TYPE_GLOBAL_MINING_SYSTEM_TO_SPOT)) {
                    c11 = '/';
                    break;
                }
                break;
            case 560021501:
                if (str.equals(FinanceRecordItem.TYPE_MINING_IN)) {
                    c11 = '0';
                    break;
                }
                break;
            case 629985299:
                if (str.equals(FinanceRecordItem.TYPE_GLOBAL_REBATE_6)) {
                    c11 = '1';
                    break;
                }
                break;
            case 676836316:
                if (str.equals(FinanceRecordItem.TYPE_FINANCE_PROJECT_SYSTEM_TO_RELATIONS_SYSTEM)) {
                    c11 = '2';
                    break;
                }
                break;
            case 697553140:
                if (str.equals(FinanceRecordItem.TYPE_OLDHUOBI_TO_BITEXPRO)) {
                    c11 = '3';
                    break;
                }
                break;
            case 721918332:
                if (str.equals(FinanceRecordItem.TYPE_EARN_SYS_RATE)) {
                    c11 = '4';
                    break;
                }
                break;
            case 777811748:
                if (str.equals(FinanceRecordItem.ETP_SHARES_MERGE_SPOT_TO_SYS)) {
                    c11 = '5';
                    break;
                }
                break;
            case 789673736:
                if (str.equals(FinanceRecordItem.TYPE_INVESTOR_TO_FUND_RISE_SYSTEM)) {
                    c11 = '6';
                    break;
                }
                break;
            case 874751196:
                if (str.equals(FinanceRecordItem.TYPE_FINANCE_PROJECT_SYSTEM_TO_KOL_MARKET_SYSTEM)) {
                    c11 = '7';
                    break;
                }
                break;
            case 909017142:
                if (str.equals(FinanceRecordItem.TYPE_OTC_OPTIONS_TO_PRO)) {
                    c11 = '8';
                    break;
                }
                break;
            case 972518781:
                if (str.equals(FinanceRecordItem.TYPE_REBATE_ACCOUNT_TRANSFER_IN)) {
                    c11 = '9';
                    break;
                }
                break;
            case 1058530832:
                if (str.equals(FinanceRecordItem.TYPE_INSTITUTION_TO_PRO)) {
                    c11 = ':';
                    break;
                }
                break;
            case 1105767574:
                if (str.equals(FinanceRecordItem.TYPE_MINING_TO_PRO_2)) {
                    c11 = ';';
                    break;
                }
                break;
            case 1118541859:
                if (str.equals(FinanceRecordItem.TYPE_MINING_OUT_1)) {
                    c11 = '<';
                    break;
                }
                break;
            case 1216834384:
                if (str.equals(FinanceRecordItem.TYPE_GLOBAL_REBATE_9)) {
                    c11 = '=';
                    break;
                }
                break;
            case 1239973081:
                if (str.equals(FinanceRecordItem.TYPE_SUB_TRANSFER_OUT)) {
                    c11 = '>';
                    break;
                }
                break;
            case 1284839057:
                if (str.equals(FinanceRecordItem.TYPE_SWAP_TO_PRO)) {
                    c11 = '?';
                    break;
                }
                break;
            case 1294859906:
                if (str.equals(FinanceRecordItem.TYPE_GLOBAL_FORCE_TO_SPOT)) {
                    c11 = '@';
                    break;
                }
                break;
            case 1304850771:
                if (str.equals(FinanceRecordItem.TYPE_SYS_SPOT_TO_OVERSEAS)) {
                    c11 = 'A';
                    break;
                }
                break;
            case 1334328007:
                if (str.equals(FinanceRecordItem.TYPE_EARN_SYS_COMMISSION)) {
                    c11 = 'B';
                    break;
                }
                break;
            case 1410804545:
                if (str.equals(FinanceRecordItem.TYPE_PRO_TO_SWAP)) {
                    c11 = 'C';
                    break;
                }
                break;
            case 1602985450:
                if (str.equals(FinanceRecordItem.TYPE_OTC_TO_PRO)) {
                    c11 = 'D';
                    break;
                }
                break;
            case 1619173256:
                if (str.equals(FinanceRecordItem.TYPE_FUND_RISE_SYSTEM_TO_INVESTOR)) {
                    c11 = 'E';
                    break;
                }
                break;
            case 1637906551:
                if (str.equals(FinanceRecordItem.TYPE_FINANCE_PROJECT_SYSTEM_TO_MARKET_SYSTEM)) {
                    c11 = 'F';
                    break;
                }
                break;
            case 1705735148:
                if (str.equals(FinanceRecordItem.TYPE_FINANCE_PROJECT_SYSTEM_TO_BRAND_SYSTEM)) {
                    c11 = 'G';
                    break;
                }
                break;
            case 1753443826:
                if (str.equals(FinanceRecordItem.TYPE_ACTIVITY)) {
                    c11 = 'H';
                    break;
                }
                break;
            case 1780582803:
                if (str.equals(FinanceRecordItem.TYPE_GRID_TRANSFER_OUT)) {
                    c11 = 'I';
                    break;
                }
                break;
            case 1789000756:
                if (str.equals(FinanceRecordItem.TYPE_SAVINGS_TRANSFER_IN)) {
                    c11 = 'J';
                    break;
                }
                break;
            case 1827832829:
                if (str.equals(FinanceRecordItem.TYPE_FUND_RISE_SYSTEM_TO_INSTITUTION_INVESTOR)) {
                    c11 = 'K';
                    break;
                }
                break;
            case 1885649442:
                if (str.equals(FinanceRecordItem.TYPE_SAVINGS_TRANSFER_OUT)) {
                    c11 = Matrix.MATRIX_TYPE_RANDOM_LT;
                    break;
                }
                break;
            case 1888230787:
                if (str.equals("mine-pool-transfer-out")) {
                    c11 = 'M';
                    break;
                }
                break;
            case 1930102716:
                if (str.equals(FinanceRecordItem.TYPE_OPTION_TO_PRO)) {
                    c11 = 'N';
                    break;
                }
                break;
            case 1997100608:
                if (str.equals(FinanceRecordItem.TYPE_GRID_TRANSFER_IN)) {
                    c11 = 'O';
                    break;
                }
                break;
            case 2062744665:
                if (str.equals(FinanceRecordItem.TYPE_MINING_OUT_2)) {
                    c11 = 'P';
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case '>':
                return context.getResources().getString(R.string.currency_detail_sub_transfer_out);
            case 1:
                return context.getResources().getString(R.string.n_balance_cashback_voucher);
            case 2:
                return context.getResources().getString(R.string.n_balance_detail_activity_bonus);
            case 3:
            case 9:
            case 11:
            case 22:
            case 31:
            case '+':
            case ',':
            case '1':
            case '=':
                return context.getResources().getString(R.string.n_user_center_invite_brokerage_title);
            case 4:
            case 16:
            case ')':
            case 'E':
            case 'K':
                return context.getResources().getString(R.string.currency_detail_platform_transfer_in);
            case 5:
                return context.getResources().getString(R.string.n_transfer_to_mine);
            case 6:
                return context.getResources().getString(R.string.n_balance_contract_to_pro);
            case 7:
            case 19:
            case '&':
            case '0':
            case '2':
            case '7':
            case 'F':
            case 'G':
                return context.getResources().getString(R.string.n_mining_system_in);
            case 8:
            case '$':
            case '6':
                return context.getResources().getString(R.string.currency_detail_platform_transfer_out);
            case 10:
                return context.getResources().getString(R.string.n_point_system_recycle);
            case 12:
                return context.getResources().getString(R.string.n_balance_pro_to_contract);
            case 13:
                return context.getResources().getString(R.string.n_balance_linear_swap_usdt_to_pro);
            case 14:
                return context.getResources().getString(R.string.n_activity_reward_receive);
            case 15:
                return context.getResources().getString(R.string.n_etp_clear_transfer_in);
            case 17:
            case ' ':
                return context.getResources().getString(R.string.currency_detail_sub_transfer_in);
            case 18:
            case '.':
            case '3':
            case '9':
                return context.getResources().getString(R.string.currency_detail_transfer_to);
            case 20:
            case ';':
                return context.getResources().getString(R.string.n_mining_transfer_from_m_to_pro);
            case 21:
            case '!':
            case '#':
                return context.getResources().getString(R.string.currency_detail_transfer_from);
            case 23:
                return context.getResources().getString(R.string.n_transfer_from_supper_margin);
            case 24:
                return context.getResources().getString(R.string.n_transfer_to_institution);
            case 25:
                return context.getResources().getString(R.string.n_balance_pro_to_option);
            case 26:
                return context.getResources().getString(R.string.n_red_envelope_reward);
            case 27:
                return context.getResources().getString(R.string.n_transfer_to_isolated_margin);
            case 28:
                return context.getResources().getString(R.string.n_transfer_to_supper_margin);
            case 29:
                return context.getResources().getString(R.string.n_etp_shares_merge_sys_to_spot);
            case 30:
                return context.getResources().getString(R.string.n_etp_clear_recycle);
            case '\"':
                return context.getResources().getString(R.string.n_balance_pro_to_linear_swap_usdt);
            case '%':
                return context.getResources().getString(R.string.n_transfer_to_otc);
            case '\'':
                return context.getResources().getString(R.string.n_balance_pro_to_otc_option);
            case '(':
                return context.getResources().getString(R.string.n_mining_transfer_from_pro_to_m);
            case '*':
                return context.getResources().getString(R.string.n_transfer_from_isolate_margin);
            case '-':
                return context.getResources().getString(R.string.n_etp_clear_transfer_in);
            case '/':
                return context.getResources().getString(R.string.n_balance_detail_activity_bonus);
            case '4':
                return context.getResources().getString(R.string.n_mining_transfer_from_m_to_pro);
            case '5':
                return context.getResources().getString(R.string.n_etp_shares_merge_spot_to_sys);
            case '8':
                return context.getResources().getString(R.string.n_balance_otc_option_to_pro);
            case ':':
                return context.getResources().getString(R.string.n_transfer_from_institution);
            case '<':
            case 'P':
                return context.getResources().getString(R.string.n_mining_system_out);
            case '?':
                return context.getResources().getString(R.string.n_balance_swap_to_pro);
            case '@':
                return context.getResources().getString(R.string.n_balance_detail_activity_bonus);
            case 'A':
                return context.getResources().getString(R.string.n_activity_deduction);
            case 'B':
                return context.getResources().getString(R.string.n_balance_earn_award);
            case 'C':
                return context.getResources().getString(R.string.n_balance_pro_to_swap);
            case 'D':
                return context.getResources().getString(R.string.n_transfer_from_otc);
            case 'H':
                return context.getResources().getString(R.string.currency_detail_contract_status_reward);
            case 'I':
                return context.getResources().getString(R.string.n_grid_transfer_out);
            case 'J':
                return context.getResources().getString(R.string.n_balance_pro_to_savings);
            case 'L':
                return context.getResources().getString(R.string.n_balance_savings_to_pro);
            case 'M':
                return context.getResources().getString(R.string.n_transfer_from_mine);
            case 'N':
                return context.getResources().getString(R.string.n_balance_option_to_pro);
            case 'O':
                return context.getResources().getString(R.string.n_grid_transfer_in);
            default:
                return "";
        }
    }

    public final void f(Context context, FinanceRecordItem financeRecordItem) {
        Intent intent = new Intent();
        intent.setClass(context, CurrencyDetailOrderActivity.class);
        intent.putExtra("finance_record_item", financeRecordItem);
        context.startActivity(intent);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x025f, code lost:
        if (r4.equals(com.huobi.finance.bean.FinanceRecordItem.TYPE_FUTURES_TO_PRO) == false) goto L_0x00c0;
     */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleView(v9.c r33, int r34, com.huobi.finance.bean.FinanceRecordItem r35, android.view.ViewGroup r36) {
        /*
            r32 = this;
            r0 = r32
            r1 = r33
            r2 = r35
            android.view.View r3 = r1.itemView
            i6.r r4 = r33.e()
            r5 = 2131428964(0x7f0b0664, float:1.8479587E38)
            android.widget.TextView r5 = r4.e(r5)
            r6 = 2131428976(0x7f0b0670, float:1.8479612E38)
            android.widget.TextView r6 = r4.e(r6)
            r7 = 2131428961(0x7f0b0661, float:1.8479581E38)
            android.widget.TextView r7 = r4.e(r7)
            r8 = 2131428968(0x7f0b0668, float:1.8479595E38)
            android.widget.TextView r8 = r4.e(r8)
            r9 = 2131428959(0x7f0b065f, float:1.8479577E38)
            android.widget.TextView r9 = r4.e(r9)
            r10 = 2131428974(0x7f0b066e, float:1.8479608E38)
            android.widget.TextView r10 = r4.e(r10)
            r11 = 2131428973(0x7f0b066d, float:1.8479606E38)
            android.widget.TextView r11 = r4.e(r11)
            r12 = 2131428982(0x7f0b0676, float:1.8479624E38)
            android.view.View r12 = r4.b(r12)
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            r13 = 2131431236(0x7f0b0f44, float:1.8484196E38)
            android.view.View r4 = r4.b(r13)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            r13 = 8
            r7.setVisibility(r13)
            r12.setVisibility(r13)
            r14 = 2131431238(0x7f0b0f46, float:1.84842E38)
            r7.setTag(r14, r2)
            int r14 = r35.getLayoutType()
            r16 = 18
            r17 = 17
            r18 = 16
            r19 = 15
            r20 = 14
            r21 = 13
            r22 = 11
            r23 = 10
            r24 = 9
            r25 = 7
            r26 = 6
            r27 = 5
            r28 = 4
            r29 = 3
            r30 = 2
            r31 = -1
            r15 = 1
            r13 = 0
            if (r14 != r15) goto L_0x0385
            java.lang.String r7 = r35.getCurrency()
            if (r7 != 0) goto L_0x008e
            java.lang.String r7 = ""
            goto L_0x0098
        L_0x008e:
            java.lang.String r7 = r35.getCurrency()
            java.util.Locale r14 = java.util.Locale.US
            java.lang.String r7 = r7.toUpperCase(r14)
        L_0x0098:
            r5.setText(r7)
            d7.k r7 = d7.k.C()
            java.lang.String r14 = r35.getCurrency()
            java.lang.String r7 = r7.z(r14)
            r14 = 8
            r4.setVisibility(r14)
            r4 = 2132025673(0x7f142149, float:1.9689857E38)
            r11.setText(r4)
            java.lang.String r4 = r35.getType()
            r4.hashCode()
            int r11 = r4.hashCode()
            switch(r11) {
                case -1878752176: goto L_0x0263;
                case -1816318536: goto L_0x0259;
                case -1655215789: goto L_0x024c;
                case -1457541922: goto L_0x023f;
                case -1391285118: goto L_0x0232;
                case -1037117828: goto L_0x0225;
                case -825179062: goto L_0x0218;
                case -709692792: goto L_0x020b;
                case -663964420: goto L_0x01fd;
                case -433414350: goto L_0x01ef;
                case 8774420: goto L_0x01e1;
                case 165300204: goto L_0x01d3;
                case 188394184: goto L_0x01c5;
                case 253340294: goto L_0x01b7;
                case 560021501: goto L_0x01a9;
                case 721918332: goto L_0x019b;
                case 909017142: goto L_0x018d;
                case 1105767574: goto L_0x017f;
                case 1118541859: goto L_0x0171;
                case 1284839057: goto L_0x0163;
                case 1334328007: goto L_0x0155;
                case 1410804545: goto L_0x0147;
                case 1551416293: goto L_0x0139;
                case 1602985450: goto L_0x012c;
                case 1780582803: goto L_0x011f;
                case 1789000756: goto L_0x0112;
                case 1867753788: goto L_0x0105;
                case 1885649442: goto L_0x00f8;
                case 1888230787: goto L_0x00eb;
                case 1930102716: goto L_0x00de;
                case 1997100608: goto L_0x00d1;
                case 2062744665: goto L_0x00c4;
                default: goto L_0x00c0;
            }
        L_0x00c0:
            r15 = r31
            goto L_0x026e
        L_0x00c4:
            java.lang.String r11 = "pool-savings-asset-management-spot-to-interest"
            boolean r4 = r4.equals(r11)
            if (r4 != 0) goto L_0x00cd
            goto L_0x00c0
        L_0x00cd:
            r15 = 31
            goto L_0x026e
        L_0x00d1:
            java.lang.String r11 = "grid-transfer-in"
            boolean r4 = r4.equals(r11)
            if (r4 != 0) goto L_0x00da
            goto L_0x00c0
        L_0x00da:
            r15 = 30
            goto L_0x026e
        L_0x00de:
            java.lang.String r11 = "option-to-spot"
            boolean r4 = r4.equals(r11)
            if (r4 != 0) goto L_0x00e7
            goto L_0x00c0
        L_0x00e7:
            r15 = 29
            goto L_0x026e
        L_0x00eb:
            java.lang.String r11 = "mine-pool-transfer-out"
            boolean r4 = r4.equals(r11)
            if (r4 != 0) goto L_0x00f4
            goto L_0x00c0
        L_0x00f4:
            r15 = 28
            goto L_0x026e
        L_0x00f8:
            java.lang.String r11 = "deposit-earning-to-spot"
            boolean r4 = r4.equals(r11)
            if (r4 != 0) goto L_0x0101
            goto L_0x00c0
        L_0x0101:
            r15 = 27
            goto L_0x026e
        L_0x0105:
            java.lang.String r11 = "borrow-to-spot"
            boolean r4 = r4.equals(r11)
            if (r4 != 0) goto L_0x010e
            goto L_0x00c0
        L_0x010e:
            r15 = 26
            goto L_0x026e
        L_0x0112:
            java.lang.String r11 = "spot-to-deposit-earning"
            boolean r4 = r4.equals(r11)
            if (r4 != 0) goto L_0x011b
            goto L_0x00c0
        L_0x011b:
            r15 = 25
            goto L_0x026e
        L_0x011f:
            java.lang.String r11 = "grid-transfer-out"
            boolean r4 = r4.equals(r11)
            if (r4 != 0) goto L_0x0128
            goto L_0x00c0
        L_0x0128:
            r15 = 24
            goto L_0x026e
        L_0x012c:
            java.lang.String r11 = "otc-to-pro"
            boolean r4 = r4.equals(r11)
            if (r4 != 0) goto L_0x0135
            goto L_0x00c0
        L_0x0135:
            r15 = 23
            goto L_0x026e
        L_0x0139:
            java.lang.String r11 = "ibox-spot-to-sys-benefit"
            boolean r4 = r4.equals(r11)
            if (r4 != 0) goto L_0x0143
            goto L_0x00c0
        L_0x0143:
            r15 = 22
            goto L_0x026e
        L_0x0147:
            java.lang.String r11 = "dm-pro-to-swap"
            boolean r4 = r4.equals(r11)
            if (r4 != 0) goto L_0x0151
            goto L_0x00c0
        L_0x0151:
            r15 = 21
            goto L_0x026e
        L_0x0155:
            java.lang.String r11 = "earn-sys-commission-to-spot"
            boolean r4 = r4.equals(r11)
            if (r4 != 0) goto L_0x015f
            goto L_0x00c0
        L_0x015f:
            r15 = 20
            goto L_0x026e
        L_0x0163:
            java.lang.String r11 = "dm-swap-to-pro"
            boolean r4 = r4.equals(r11)
            if (r4 != 0) goto L_0x016d
            goto L_0x00c0
        L_0x016d:
            r15 = 19
            goto L_0x026e
        L_0x0171:
            java.lang.String r11 = "pool-savings-asset-management-spot-to-ops"
            boolean r4 = r4.equals(r11)
            if (r4 != 0) goto L_0x017b
            goto L_0x00c0
        L_0x017b:
            r15 = r16
            goto L_0x026e
        L_0x017f:
            java.lang.String r11 = "pool-savings-interest-to-spot"
            boolean r4 = r4.equals(r11)
            if (r4 != 0) goto L_0x0189
            goto L_0x00c0
        L_0x0189:
            r15 = r17
            goto L_0x026e
        L_0x018d:
            java.lang.String r11 = "otc-options-to-spot"
            boolean r4 = r4.equals(r11)
            if (r4 != 0) goto L_0x0197
            goto L_0x00c0
        L_0x0197:
            r15 = r18
            goto L_0x026e
        L_0x019b:
            java.lang.String r11 = "earn-sys-rate-to-spot"
            boolean r4 = r4.equals(r11)
            if (r4 != 0) goto L_0x01a5
            goto L_0x00c0
        L_0x01a5:
            r15 = r19
            goto L_0x026e
        L_0x01a9:
            java.lang.String r11 = "pool-savings-ops-to-asset-management-spot"
            boolean r4 = r4.equals(r11)
            if (r4 != 0) goto L_0x01b3
            goto L_0x00c0
        L_0x01b3:
            r15 = r20
            goto L_0x026e
        L_0x01b7:
            java.lang.String r11 = "pool-savings-spot-to-clct"
            boolean r4 = r4.equals(r11)
            if (r4 != 0) goto L_0x01c1
            goto L_0x00c0
        L_0x01c1:
            r15 = r21
            goto L_0x026e
        L_0x01c5:
            java.lang.String r11 = "spot-to-otc-options"
            boolean r4 = r4.equals(r11)
            if (r4 != 0) goto L_0x01cf
            goto L_0x00c0
        L_0x01cf:
            r15 = 12
            goto L_0x026e
        L_0x01d3:
            java.lang.String r11 = "pro-to-otc"
            boolean r4 = r4.equals(r11)
            if (r4 != 0) goto L_0x01dd
            goto L_0x00c0
        L_0x01dd:
            r15 = r22
            goto L_0x026e
        L_0x01e1:
            java.lang.String r11 = "spot-to-linear-swap"
            boolean r4 = r4.equals(r11)
            if (r4 != 0) goto L_0x01eb
            goto L_0x00c0
        L_0x01eb:
            r15 = r23
            goto L_0x026e
        L_0x01ef:
            java.lang.String r11 = "pro-to-super-margin"
            boolean r4 = r4.equals(r11)
            if (r4 != 0) goto L_0x01f9
            goto L_0x00c0
        L_0x01f9:
            r15 = r24
            goto L_0x026e
        L_0x01fd:
            java.lang.String r11 = "spot-to-option"
            boolean r4 = r4.equals(r11)
            if (r4 != 0) goto L_0x0207
            goto L_0x00c0
        L_0x0207:
            r15 = 8
            goto L_0x026e
        L_0x020b:
            java.lang.String r11 = "super-margin-to-pro"
            boolean r4 = r4.equals(r11)
            if (r4 != 0) goto L_0x0215
            goto L_0x00c0
        L_0x0215:
            r15 = r25
            goto L_0x026e
        L_0x0218:
            java.lang.String r11 = "pool-savings-expend-to-spot"
            boolean r4 = r4.equals(r11)
            if (r4 != 0) goto L_0x0222
            goto L_0x00c0
        L_0x0222:
            r15 = r26
            goto L_0x026e
        L_0x0225:
            java.lang.String r11 = "spot-to-borrow"
            boolean r4 = r4.equals(r11)
            if (r4 != 0) goto L_0x022f
            goto L_0x00c0
        L_0x022f:
            r15 = r27
            goto L_0x026e
        L_0x0232:
            java.lang.String r11 = "linear-swap-to-spot"
            boolean r4 = r4.equals(r11)
            if (r4 != 0) goto L_0x023c
            goto L_0x00c0
        L_0x023c:
            r15 = r28
            goto L_0x026e
        L_0x023f:
            java.lang.String r11 = "pro-to-futures"
            boolean r4 = r4.equals(r11)
            if (r4 != 0) goto L_0x0249
            goto L_0x00c0
        L_0x0249:
            r15 = r29
            goto L_0x026e
        L_0x024c:
            java.lang.String r11 = "ibox-sys-benefit-to-spot"
            boolean r4 = r4.equals(r11)
            if (r4 != 0) goto L_0x0256
            goto L_0x00c0
        L_0x0256:
            r15 = r30
            goto L_0x026e
        L_0x0259:
            java.lang.String r11 = "futures-to-pro"
            boolean r4 = r4.equals(r11)
            if (r4 != 0) goto L_0x026e
            goto L_0x00c0
        L_0x0263:
            java.lang.String r11 = "mine-pool-transfer-in"
            boolean r4 = r4.equals(r11)
            if (r4 != 0) goto L_0x026d
            goto L_0x00c0
        L_0x026d:
            r15 = r13
        L_0x026e:
            switch(r15) {
                case 0: goto L_0x037d;
                case 1: goto L_0x0375;
                case 2: goto L_0x036d;
                case 3: goto L_0x0365;
                case 4: goto L_0x035d;
                case 5: goto L_0x0352;
                case 6: goto L_0x034a;
                case 7: goto L_0x033f;
                case 8: goto L_0x0337;
                case 9: goto L_0x032c;
                case 10: goto L_0x0324;
                case 11: goto L_0x0311;
                case 12: goto L_0x0309;
                case 13: goto L_0x0301;
                case 14: goto L_0x02f9;
                case 15: goto L_0x02f1;
                case 16: goto L_0x02e9;
                case 17: goto L_0x034a;
                case 18: goto L_0x02e1;
                case 19: goto L_0x02d9;
                case 20: goto L_0x02d1;
                case 21: goto L_0x02c9;
                case 22: goto L_0x02c1;
                case 23: goto L_0x02ae;
                case 24: goto L_0x02a6;
                case 25: goto L_0x029e;
                case 26: goto L_0x0293;
                case 27: goto L_0x028b;
                case 28: goto L_0x0283;
                case 29: goto L_0x027b;
                case 30: goto L_0x0273;
                case 31: goto L_0x02e1;
                default: goto L_0x0271;
            }
        L_0x0271:
            goto L_0x0606
        L_0x0273:
            r4 = 2132022228(0x7f1413d4, float:1.968287E38)
            r8.setText(r4)
            goto L_0x0606
        L_0x027b:
            r4 = 2132020182(0x7f140bd6, float:1.967872E38)
            r8.setText(r4)
            goto L_0x0606
        L_0x0283:
            r4 = 2132025237(0x7f141f95, float:1.9688973E38)
            r8.setText(r4)
            goto L_0x0606
        L_0x028b:
            r4 = 2132020210(0x7f140bf2, float:1.9678777E38)
            r8.setText(r4)
            goto L_0x0606
        L_0x0293:
            r5.setText(r7)
            r4 = 2132025233(0x7f141f91, float:1.9688965E38)
            r8.setText(r4)
            goto L_0x0606
        L_0x029e:
            r4 = 2132020216(0x7f140bf8, float:1.9678789E38)
            r8.setText(r4)
            goto L_0x0606
        L_0x02a6:
            r4 = 2132022229(0x7f1413d5, float:1.9682872E38)
            r8.setText(r4)
            goto L_0x0606
        L_0x02ae:
            java.lang.String r4 = r35.getCurrency()
            java.lang.String r4 = com.huobi.otc.utils.OtcMarketPriceConfigUtil.d(r4)
            r5.setText(r4)
            r4 = 2132025238(0x7f141f96, float:1.9688975E38)
            r8.setText(r4)
            goto L_0x0606
        L_0x02c1:
            r4 = 2132020411(0x7f140cbb, float:1.9679184E38)
            r8.setText(r4)
            goto L_0x0606
        L_0x02c9:
            r4 = 2132020211(0x7f140bf3, float:1.9678779E38)
            r8.setText(r4)
            goto L_0x0606
        L_0x02d1:
            r4 = 2132020131(0x7f140ba3, float:1.9678616E38)
            r8.setText(r4)
            goto L_0x0606
        L_0x02d9:
            r4 = 2132020227(0x7f140c03, float:1.9678811E38)
            r8.setText(r4)
            goto L_0x0606
        L_0x02e1:
            r4 = 2132023240(0x7f1417c8, float:1.9684922E38)
            r8.setText(r4)
            goto L_0x0606
        L_0x02e9:
            r4 = 2132020186(0x7f140bda, float:1.9678728E38)
            r8.setText(r4)
            goto L_0x0606
        L_0x02f1:
            r4 = 2132023245(0x7f1417cd, float:1.9684932E38)
            r8.setText(r4)
            goto L_0x0606
        L_0x02f9:
            r4 = 2132023239(0x7f1417c7, float:1.968492E38)
            r8.setText(r4)
            goto L_0x0606
        L_0x0301:
            r4 = 2132023246(0x7f1417ce, float:1.9684934E38)
            r8.setText(r4)
            goto L_0x0606
        L_0x0309:
            r4 = 2132020209(0x7f140bf1, float:1.9678775E38)
            r8.setText(r4)
            goto L_0x0606
        L_0x0311:
            java.lang.String r4 = r35.getCurrency()
            java.lang.String r4 = com.huobi.otc.utils.OtcMarketPriceConfigUtil.d(r4)
            r5.setText(r4)
            r4 = 2132025263(0x7f141faf, float:1.9689025E38)
            r8.setText(r4)
            goto L_0x0606
        L_0x0324:
            r4 = 2132020206(0x7f140bee, float:1.9678769E38)
            r8.setText(r4)
            goto L_0x0606
        L_0x032c:
            r5.setText(r7)
            r4 = 2132025264(0x7f141fb0, float:1.9689027E38)
            r8.setText(r4)
            goto L_0x0606
        L_0x0337:
            r4 = 2132020207(0x7f140bef, float:1.967877E38)
            r8.setText(r4)
            goto L_0x0606
        L_0x033f:
            r5.setText(r7)
            r4 = 2132025239(0x7f141f97, float:1.9688977E38)
            r8.setText(r4)
            goto L_0x0606
        L_0x034a:
            r4 = 2132023245(0x7f1417cd, float:1.9684932E38)
            r8.setText(r4)
            goto L_0x0606
        L_0x0352:
            r5.setText(r7)
            r4 = 2132025258(0x7f141faa, float:1.9689015E38)
            r8.setText(r4)
            goto L_0x0606
        L_0x035d:
            r4 = 2132020157(0x7f140bbd, float:1.967867E38)
            r8.setText(r4)
            goto L_0x0606
        L_0x0365:
            r4 = 2132020203(0x7f140beb, float:1.9678763E38)
            r8.setText(r4)
            goto L_0x0606
        L_0x036d:
            r4 = 2132020405(0x7f140cb5, float:1.9679172E38)
            r8.setText(r4)
            goto L_0x0606
        L_0x0375:
            r4 = 2132020117(0x7f140b95, float:1.9678588E38)
            r8.setText(r4)
            goto L_0x0606
        L_0x037d:
            r4 = 2132025262(0x7f141fae, float:1.9689023E38)
            r8.setText(r4)
            goto L_0x0606
        L_0x0385:
            r4.setVisibility(r13)
            bl.h2 r4 = new bl.h2
            r4.<init>(r0, r3, r2)
            r3.setOnClickListener(r4)
            r4 = 2132018417(0x7f1404f1, float:1.967514E38)
            r11.setText(r4)
            java.lang.String r4 = r35.getType()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x03b7
            java.lang.String r4 = r35.getType()
            java.lang.String r11 = r35.getDirection()
            com.hbg.lib.data.symbol.TradeType r14 = r35.getTradeType()
            android.content.Context r15 = r3.getContext()
            java.lang.String r4 = al.x.a(r4, r11, r14, r15)
            r5.setText(r4)
        L_0x03b7:
            r7.setOnClickListener(r0)
            java.lang.String r4 = r35.getState()
            r4.hashCode()
            int r5 = r4.hashCode()
            switch(r5) {
                case -1973793199: goto L_0x0535;
                case -1961320569: goto L_0x0529;
                case -1314742011: goto L_0x051c;
                case -1284171314: goto L_0x050f;
                case -1196781354: goto L_0x0502;
                case -1008410488: goto L_0x04f5;
                case -934710369: goto L_0x04e8;
                case -853033797: goto L_0x04db;
                case -810471509: goto L_0x04cd;
                case -804109473: goto L_0x04bf;
                case -436788878: goto L_0x04b1;
                case -123173735: goto L_0x04a3;
                case 3433489: goto L_0x0495;
                case 3522445: goto L_0x0487;
                case 69357375: goto L_0x0479;
                case 111972348: goto L_0x046b;
                case 189047877: goto L_0x045d;
                case 216860606: goto L_0x044f;
                case 308097193: goto L_0x0441;
                case 348678395: goto L_0x0434;
                case 768015450: goto L_0x0427;
                case 842414370: goto L_0x041a;
                case 845841297: goto L_0x040d;
                case 854201778: goto L_0x0400;
                case 1316540403: goto L_0x03f3;
                case 1636423606: goto L_0x03e6;
                case 1760153557: goto L_0x03d9;
                case 2096857181: goto L_0x03cc;
                default: goto L_0x03c8;
            }
        L_0x03c8:
            r15 = r31
            goto L_0x0540
        L_0x03cc:
            java.lang.String r5 = "Failed"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x03d5
            goto L_0x03c8
        L_0x03d5:
            r15 = 27
            goto L_0x0540
        L_0x03d9:
            java.lang.String r5 = "pre-transfer"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x03e2
            goto L_0x03c8
        L_0x03e2:
            r15 = 26
            goto L_0x0540
        L_0x03e6:
            java.lang.String r5 = "rollback-confirmed"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x03ef
            goto L_0x03c8
        L_0x03ef:
            r15 = 25
            goto L_0x0540
        L_0x03f3:
            java.lang.String r5 = "wallet-reject"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x03fc
            goto L_0x03c8
        L_0x03fc:
            r15 = 24
            goto L_0x0540
        L_0x0400:
            java.lang.String r5 = "orphan-safe"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0409
            goto L_0x03c8
        L_0x0409:
            r15 = 23
            goto L_0x0540
        L_0x040d:
            java.lang.String r5 = "rollback-orphan"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0416
            goto L_0x03c8
        L_0x0416:
            r15 = 22
            goto L_0x0540
        L_0x041a:
            java.lang.String r5 = "confirming"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0423
            goto L_0x03c8
        L_0x0423:
            r15 = 21
            goto L_0x0540
        L_0x0427:
            java.lang.String r5 = "orphan-confirmed"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0430
            goto L_0x03c8
        L_0x0430:
            r15 = 20
            goto L_0x0540
        L_0x0434:
            java.lang.String r5 = "submitted"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x043d
            goto L_0x03c8
        L_0x043d:
            r15 = 19
            goto L_0x0540
        L_0x0441:
            java.lang.String r5 = "Verifying"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x044b
            goto L_0x03c8
        L_0x044b:
            r15 = r16
            goto L_0x0540
        L_0x044f:
            java.lang.String r5 = "large-amount-examine"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0459
            goto L_0x03c8
        L_0x0459:
            r15 = r17
            goto L_0x0540
        L_0x045d:
            java.lang.String r5 = "waiting-tiny-amount"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0467
            goto L_0x03c8
        L_0x0467:
            r15 = r18
            goto L_0x0540
        L_0x046b:
            java.lang.String r5 = "valid"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0475
            goto L_0x03c8
        L_0x0475:
            r15 = r19
            goto L_0x0540
        L_0x0479:
            java.lang.String r5 = "wallet-transfer"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0483
            goto L_0x03c8
        L_0x0483:
            r15 = r20
            goto L_0x0540
        L_0x0487:
            java.lang.String r5 = "safe"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0491
            goto L_0x03c8
        L_0x0491:
            r15 = r21
            goto L_0x0540
        L_0x0495:
            java.lang.String r5 = "pass"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x049f
            goto L_0x03c8
        L_0x049f:
            r15 = 12
            goto L_0x0540
        L_0x04a3:
            java.lang.String r5 = "canceled"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x04ad
            goto L_0x03c8
        L_0x04ad:
            r15 = r22
            goto L_0x0540
        L_0x04b1:
            java.lang.String r5 = "repealed"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x04bb
            goto L_0x03c8
        L_0x04bb:
            r15 = r23
            goto L_0x0540
        L_0x04bf:
            java.lang.String r5 = "confirmed"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x04c9
            goto L_0x03c8
        L_0x04c9:
            r15 = r24
            goto L_0x0540
        L_0x04cd:
            java.lang.String r5 = "rollback-confirming"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x04d7
            goto L_0x03c8
        L_0x04d7:
            r15 = 8
            goto L_0x0540
        L_0x04db:
            java.lang.String r5 = "confirm-error"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x04e5
            goto L_0x03c8
        L_0x04e5:
            r15 = r25
            goto L_0x0540
        L_0x04e8:
            java.lang.String r5 = "reject"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x04f2
            goto L_0x03c8
        L_0x04f2:
            r15 = r26
            goto L_0x0540
        L_0x04f5:
            java.lang.String r5 = "orphan"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x04ff
            goto L_0x03c8
        L_0x04ff:
            r15 = r27
            goto L_0x0540
        L_0x0502:
            java.lang.String r5 = "rollback-safe"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x050c
            goto L_0x03c8
        L_0x050c:
            r15 = r28
            goto L_0x0540
        L_0x050f:
            java.lang.String r5 = "reexamine"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0519
            goto L_0x03c8
        L_0x0519:
            r15 = r29
            goto L_0x0540
        L_0x051c:
            java.lang.String r5 = "risk-delay"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0526
            goto L_0x03c8
        L_0x0526:
            r15 = r30
            goto L_0x0540
        L_0x0529:
            java.lang.String r5 = "orphan-confirming"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0533
            goto L_0x03c8
        L_0x0533:
            r15 = 1
            goto L_0x0540
        L_0x0535:
            java.lang.String r5 = "pre-submitted"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x053f
            goto L_0x03c8
        L_0x053f:
            r15 = r13
        L_0x0540:
            r4 = 2132024004(0x7f141ac4, float:1.9686472E38)
            switch(r15) {
                case 0: goto L_0x05f2;
                case 1: goto L_0x05e9;
                case 2: goto L_0x05e0;
                case 3: goto L_0x05f2;
                case 4: goto L_0x05d7;
                case 5: goto L_0x05ce;
                case 6: goto L_0x05c5;
                case 7: goto L_0x05bc;
                case 8: goto L_0x05e9;
                case 9: goto L_0x0597;
                case 10: goto L_0x058d;
                case 11: goto L_0x058d;
                case 12: goto L_0x0583;
                case 13: goto L_0x05d7;
                case 14: goto L_0x0579;
                case 15: goto L_0x05d7;
                case 16: goto L_0x056f;
                case 17: goto L_0x0565;
                case 18: goto L_0x0552;
                case 19: goto L_0x05f2;
                case 20: goto L_0x05e9;
                case 21: goto L_0x05e9;
                case 22: goto L_0x05ce;
                case 23: goto L_0x05d7;
                case 24: goto L_0x05bc;
                case 25: goto L_0x05e9;
                case 26: goto L_0x0583;
                case 27: goto L_0x0548;
                default: goto L_0x0546;
            }
        L_0x0546:
            goto L_0x0603
        L_0x0548:
            r4 = 2132018439(0x7f140507, float:1.9675185E38)
            r5 = 8
            r12.setVisibility(r5)
            goto L_0x0603
        L_0x0552:
            r5 = 8
            r4 = 2132018438(0x7f140506, float:1.9675183E38)
            r12.setVisibility(r5)
            r11 = 2132018800(0x7f140670, float:1.9675917E38)
            r7.setText(r11)
            r7.setVisibility(r13)
            goto L_0x0603
        L_0x0565:
            r5 = 8
            r12.setVisibility(r5)
            r4 = 2132018431(0x7f1404ff, float:1.9675168E38)
            goto L_0x0603
        L_0x056f:
            r5 = 8
            r4 = 2132018440(0x7f140508, float:1.9675187E38)
            r12.setVisibility(r13)
            goto L_0x0603
        L_0x0579:
            r5 = 8
            r12.setVisibility(r5)
            r4 = 2132018434(0x7f140502, float:1.9675175E38)
            goto L_0x0603
        L_0x0583:
            r5 = 8
            r12.setVisibility(r5)
            r4 = 2132018433(0x7f140501, float:1.9675173E38)
            goto L_0x0603
        L_0x058d:
            r5 = 8
            r12.setVisibility(r5)
            r4 = 2132018427(0x7f1404fb, float:1.967516E38)
            goto L_0x0603
        L_0x0597:
            java.lang.String r5 = r35.getType()
            java.lang.String r7 = "withdraw"
            boolean r5 = r5.contains(r7)
            if (r5 == 0) goto L_0x05a7
            r4 = 2132018428(0x7f1404fc, float:1.9675162E38)
            goto L_0x05b6
        L_0x05a7:
            java.lang.String r5 = r35.getType()
            java.lang.String r7 = "deposit"
            boolean r5 = r5.contains(r7)
            if (r5 == 0) goto L_0x05b6
            r4 = 2132018429(0x7f1404fd, float:1.9675164E38)
        L_0x05b6:
            r5 = 8
            r12.setVisibility(r5)
            goto L_0x0603
        L_0x05bc:
            r5 = 8
            r12.setVisibility(r5)
            r4 = 2132018430(0x7f1404fe, float:1.9675166E38)
            goto L_0x0603
        L_0x05c5:
            r5 = 8
            r4 = 2132018437(0x7f140505, float:1.967518E38)
            r12.setVisibility(r5)
            goto L_0x0603
        L_0x05ce:
            r5 = 8
            r4 = 2132018432(0x7f140500, float:1.967517E38)
            r12.setVisibility(r5)
            goto L_0x0603
        L_0x05d7:
            r5 = 8
            r12.setVisibility(r5)
            r4 = 2132018428(0x7f1404fc, float:1.9675162E38)
            goto L_0x0603
        L_0x05e0:
            r5 = 8
            r4 = 2132018435(0x7f140503, float:1.9675177E38)
            r12.setVisibility(r5)
            goto L_0x0603
        L_0x05e9:
            r5 = 8
            r12.setVisibility(r5)
            r4 = 2132018429(0x7f1404fd, float:1.9675164E38)
            goto L_0x0603
        L_0x05f2:
            r5 = 8
            r12.setVisibility(r5)
            r4 = 2132018431(0x7f1404ff, float:1.9675168E38)
            r5 = 2132018415(0x7f1404ef, float:1.9675136E38)
            r7.setText(r5)
            r7.setVisibility(r13)
        L_0x0603:
            r8.setText(r4)
        L_0x0606:
            long r4 = r35.getCreatedAt()
            boolean r4 = com.hbg.lib.common.utils.DateTimeUtils.E(r4)
            if (r4 == 0) goto L_0x061e
            long r4 = r35.getCreatedAt()
            java.lang.String r7 = "HH:mm MM/dd"
            java.lang.String r4 = com.hbg.lib.common.utils.DateTimeUtils.h(r4, r7)
            r6.setText(r4)
            goto L_0x062b
        L_0x061e:
            long r4 = r35.getUpdatedAt()
            java.lang.String r7 = "HH:mm MM/dd/yyyy "
            java.lang.String r4 = com.hbg.lib.common.utils.DateTimeUtils.h(r4, r7)
            r6.setText(r4)
        L_0x062b:
            java.lang.String r4 = r35.getAmount()
            java.lang.String r5 = r35.getCurrency()
            int r5 = com.hbg.lib.data.symbol.PrecisionUtil.b(r5)
            r6 = 12
            java.lang.String r4 = i6.m.u0(r4, r6, r5)
            r9.setText(r4)
            android.content.Context r3 = r3.getContext()
            java.lang.String r4 = r35.getType()
            java.lang.String r3 = r0.e(r3, r4)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L_0x0659
            r10.setVisibility(r13)
            r10.setText(r3)
            goto L_0x065e
        L_0x0659:
            r3 = 8
            r10.setVisibility(r3)
        L_0x065e:
            bl.i2 r3 = new bl.i2
            r3.<init>(r0, r2, r1)
            r12.setOnClickListener(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.finance.viewhandler.CurrencyRecordViewHandler.handleView(v9.c, int, com.huobi.finance.bean.FinanceRecordItem, android.view.ViewGroup):void");
    }

    public int getResId() {
        return R.layout.item_currency_allrecord;
    }

    public final void k(String str, String str2, Context context) {
        DialogUtils.X((FragmentActivity) a.g().b(), context.getResources().getString(R.string.dialog_minamount_hint_title), context.getResources().getString(R.string.dialog_minamount_content_hint, new Object[]{str2, str}), (String) null, context.getResources().getString(R.string.dialog_minamount_hint_confrm_btn), j2.f12633a);
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        FinanceRecordItem financeRecordItem = (FinanceRecordItem) view.getTag(R.id.item_data);
        if (FinanceRecordItem.STATE_VERIFYING.equals(financeRecordItem.getState())) {
            view.getContext().startActivity(UnifyRiskActivity.Ch(view.getContext(), financeRecordItem.getTransactionId(), 1));
        } else {
            EventBus.d().k(financeRecordItem);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
