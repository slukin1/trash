package su;

import a7.e;
import android.net.Uri;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.webview.HBWebView;
import com.hbg.lib.core.webview.bean.JsMessage;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.controller.FutureContractInfoController;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.huobi.contract.entity.CalculateData;
import com.huobi.contract.entity.WebContractSymbolData;
import com.huobi.contract.helper.ContractUserInfoProvider;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.webview2.action.JsCommonActionHelper;
import i6.d;
import java.util.concurrent.TimeUnit;
import qk.k;
import rx.Observable;
import v6.u;
import x6.c;

public class b extends c {

    /* renamed from: b  reason: collision with root package name */
    public C0210b f23398b;

    /* renamed from: c  reason: collision with root package name */
    public CalculateData f23399c;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f23400a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.hbg.lib.data.symbol.TradeType[] r0 = com.hbg.lib.data.symbol.TradeType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f23400a = r0
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.LINEAR_SWAP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f23400a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.SWAP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f23400a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.CONTRACT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f23400a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.OPTION     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: su.b.a.<clinit>():void");
        }
    }

    /* renamed from: su.b$b  reason: collision with other inner class name */
    public interface C0210b {
        void W4(String str);
    }

    public b(CalculateData calculateData, u uVar, C0210b bVar) {
        super(uVar);
        this.f23399c = calculateData;
        this.f23398b = bVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(Long l11) {
        C0210b bVar = this.f23398b;
        if (bVar != null) {
            bVar.W4("");
        }
    }

    public boolean b(JsMessage jsMessage, u uVar) {
        String action = jsMessage.getAction();
        if (JsCommonActionHelper.ACTION_CONTRACT_OPEN_SUCC.equals(action)) {
            Observable.timer(1, TimeUnit.SECONDS).compose(RxJavaHelper.t(uVar)).subscribe(EasySubscriber.create(new a(this)));
            return true;
        } else if (JsCommonActionHelper.ACTION_CONTRACT_CALCULATE.equals(action)) {
            e(jsMessage, uVar);
            return true;
        } else if (!JsCommonActionHelper.ACTION_CONTRACT_SYMBOL.equals(jsMessage.getAction())) {
            return false;
        } else {
            d(jsMessage, uVar);
            return true;
        }
    }

    public final void d(JsMessage jsMessage, u uVar) {
        if (uVar != null && this.f23399c != null) {
            String callback = jsMessage.getCallback();
            d.b("JsCommonActionHelper-->dealWithLanguage-->action:" + callback);
            JsMessage jsMessage2 = new JsMessage();
            jsMessage2.setCode(200);
            jsMessage2.setData(new WebContractSymbolData(this.f23399c.getContractCode()));
            jsMessage2.setAction(callback);
            x6.b.d(jsMessage2, uVar);
        }
    }

    public final void e(JsMessage jsMessage, u uVar) {
        if (uVar != null) {
            if ((uVar.getWebView() instanceof HBWebView) && ((HBWebView) uVar.getWebView()).getHBWebViewUrl() != null && ((HBWebView) uVar.getWebView()).getHBWebViewUrl().contains("source=copytrading")) {
                try {
                    String queryParameter = Uri.parse(((HBWebView) uVar.getWebView()).getHBWebViewUrl()).getQueryParameter("symbol");
                    CalculateData calculateData = new CalculateData(queryParameter, e.c(TradeType.LINEAR_SWAP), LegalCurrencyConfigUtil.y().toUpperCase());
                    this.f23399c = calculateData;
                    calculateData.setCurrentContractCode(queryParameter);
                    this.f23399c.setContractCode(queryParameter);
                } catch (Throwable th2) {
                    d.g(th2);
                }
            }
            if (this.f23399c == null) {
                TradeType a11 = fl.a.a();
                if (a11 != null) {
                    int i11 = a.f23400a[a11.ordinal()];
                    if (i11 == 1) {
                        FutureContractInfo f11 = k.f(FutureContractInfoController.n().e(a11));
                        if (f11 != null) {
                            CalculateData calculateData2 = new CalculateData(f11.getSymbol(), e.c(a11), LegalCurrencyConfigUtil.y().toUpperCase());
                            this.f23399c = calculateData2;
                            calculateData2.setCurrentContractCode(f11.getContractShortType());
                            this.f23399c.setContractCode(f11.getContractCode());
                        }
                    } else if (i11 == 2 || i11 == 3) {
                        ContractCurrencyInfo k11 = ContractUserInfoProvider.i().k();
                        if (k11 != null) {
                            CalculateData calculateData3 = new CalculateData(k11.getSymbol(), e.c(a11), LegalCurrencyConfigUtil.y().toUpperCase());
                            this.f23399c = calculateData3;
                            calculateData3.setCurrentContractCode(ContractUserInfoProvider.i().h());
                            this.f23399c.setContractCode(k11.getContractCode());
                        }
                    } else if (i11 != 4) {
                        this.f23399c = new CalculateData("", "", LegalCurrencyConfigUtil.y().toUpperCase());
                    }
                } else {
                    this.f23399c = new CalculateData("", "", LegalCurrencyConfigUtil.y().toUpperCase());
                }
            }
            if (this.f23399c != null) {
                JsMessage jsMessage2 = new JsMessage();
                jsMessage2.setCode(200);
                if (dn.d.f().j(this.f23399c.getSymbol())) {
                    this.f23399c.setCrossedIsolatedType(FutureContractInfo.MARGIN_CROSS);
                } else {
                    this.f23399c.setCrossedIsolatedType(FutureContractInfo.MARGIN_ISOLATED);
                }
                jsMessage2.setData(this.f23399c);
                d.b("JsContractCallback-->doCalculator-->" + this.f23399c);
                jsMessage2.setAction(jsMessage.getCallback());
                x6.b.d(jsMessage2, uVar);
            }
        }
    }
}
