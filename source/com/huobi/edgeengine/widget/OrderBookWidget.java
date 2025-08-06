package com.huobi.edgeengine.widget;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huobi.edgeengine.template.widget.Widget;
import com.huobi.edgeengine.widget.view.OrderBookView;
import com.huobi.trade.bean.MarketBuySellItem;
import java.util.Map;
import k6.b;
import k6.c;
import rj.n;

public class OrderBookWidget extends Widget {

    /* renamed from: h0  reason: collision with root package name */
    public String f44394h0;

    /* renamed from: i0  reason: collision with root package name */
    public String f44395i0;

    /* renamed from: j0  reason: collision with root package name */
    public String f44396j0;

    /* renamed from: k0  reason: collision with root package name */
    public String f44397k0;

    /* renamed from: l0  reason: collision with root package name */
    public String f44398l0;

    /* renamed from: m0  reason: collision with root package name */
    public String f44399m0;

    /* renamed from: n0  reason: collision with root package name */
    public String f44400n0;

    public class a extends com.huobi.edgeengine.template.widget.c<OrderBookView> {
        public a(OrderBookView orderBookView) {
            super(orderBookView);
        }

        /* renamed from: c */
        public void b(OrderBookView orderBookView, String str) {
            if (!TextUtils.isEmpty(str)) {
                JSONObject parseObject = JSON.parseObject(str);
                try {
                    Integer integer = parseObject.getInteger("cellCount");
                    if (integer != null) {
                        orderBookView.x(integer.intValue(), integer.intValue() * 2);
                    }
                } catch (Throwable unused) {
                }
                orderBookView.t(parseObject.getString("contractCode"), parseObject.getString("contractShortType"), parseObject.getString("contractSize"), parseObject.getString("unitType"));
                return;
            }
            orderBookView.t("", "", "", "");
        }
    }

    public class b extends com.huobi.edgeengine.template.widget.c<OrderBookView> {
        public b(OrderBookView orderBookView) {
            super(orderBookView);
        }

        /* renamed from: c */
        public void b(OrderBookView orderBookView, String str) {
            if (!TextUtils.isEmpty(str)) {
                orderBookView.u(str.equals("true"));
            }
        }
    }

    public class c extends com.huobi.edgeengine.template.widget.c<OrderBookView> {
        public c(OrderBookView orderBookView) {
            super(orderBookView);
        }

        /* renamed from: c */
        public void b(OrderBookView orderBookView, String str) {
            try {
                int intValue = Integer.valueOf(str).intValue();
                orderBookView.x(intValue, intValue * 2);
            } catch (Throwable unused) {
            }
        }
    }

    public class d extends com.huobi.edgeengine.template.widget.c<OrderBookView> {
        public d(OrderBookView orderBookView) {
            super(orderBookView);
        }

        /* renamed from: c */
        public void b(OrderBookView orderBookView, String str) {
            orderBookView.z(str);
        }
    }

    public class e implements OrderBookView.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f44405a;

        public e(n nVar) {
            this.f44405a = nVar;
        }

        public void a(c.a aVar) {
            if (!TextUtils.isEmpty(OrderBookWidget.this.f44397k0)) {
                String X = OrderBookWidget.this.f44397k0;
                boolean unused = OrderBookWidget.this.z(X.replace("@eventParams", "'" + aVar.a() + "'"), this.f44405a);
            }
        }

        public void b(b.a aVar) {
        }

        public void c(b.a aVar) {
        }

        public void d(b.a aVar) {
            if (!TextUtils.isEmpty(OrderBookWidget.this.f44399m0)) {
                String Z = OrderBookWidget.this.f44399m0;
                boolean unused = OrderBookWidget.this.z(Z.replace("@eventParams", "'" + aVar.a() + "'"), this.f44405a);
            }
        }

        public void e(MarketBuySellItem marketBuySellItem, MarketBuySellItem marketBuySellItem2) {
            if (!TextUtils.isEmpty(OrderBookWidget.this.f44398l0)) {
                String b02 = OrderBookWidget.this.f44398l0;
                boolean unused = OrderBookWidget.this.z(b02.replace("@eventParams", "'" + marketBuySellItem.a() + "','" + marketBuySellItem2.a() + "'"), this.f44405a);
            }
        }
    }

    public void C(Context context, Map<String, String> map) {
        super.C(context, map);
        this.f44394h0 = map.get("contractInfo");
        this.f44395i0 = map.get("cellCount");
        this.f44396j0 = map.get("markPrice");
        this.f44397k0 = map.get("selectPrice");
        this.f44398l0 = map.get("buySellFirstPrice");
        this.f44399m0 = map.get("updateLastPrice");
        this.f44400n0 = map.get("isAppear");
    }

    /* renamed from: d0 */
    public OrderBookView q(Context context) {
        return new OrderBookView(context);
    }

    /* renamed from: e0 */
    public OrderBookView Q(Context context, n nVar) {
        OrderBookView orderBookView = (OrderBookView) super.Q(context, nVar);
        w(context, this.f44394h0, new a(orderBookView), nVar);
        w(context, this.f44400n0, new b(orderBookView), nVar);
        w(context, this.f44395i0, new c(orderBookView), nVar);
        w(context, this.f44396j0, new d(orderBookView), nVar);
        orderBookView.setCallback(new e(nVar));
        return orderBookView;
    }
}
