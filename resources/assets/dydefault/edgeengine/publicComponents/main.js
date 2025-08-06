var DP = 20, RM = 1, MAX_DP = 1e6, MAX_POWER = 1e6, NE = -7, PE = 21, NAME = "[big.js] ", INVALID = NAME + "Invalid ", INVALID_DP = INVALID + "decimal places", INVALID_RM = INVALID + "rounding mode", DIV_BY_ZERO = NAME + "Division by zero", P = {}, UNDEFINED = void 0, NUMERIC = /^-?(\d+(\.\d*)?|\.\d+)(e[+-]?\d+)?$/i;

function _Big_() {
    function Big(n) {
        var x = this;
        if (!(x instanceof Big)) return n === UNDEFINED ? _Big_() : new Big(n);
        if (n instanceof Big) {
            x.s = n.s;
            x.e = n.e;
            x.c = n.c.slice();
        } else {
            parse(x, n);
        }
        x.constructor = Big;
    }
    Big.prototype = P;
    Big.DP = DP;
    Big.RM = RM;
    Big.NE = NE;
    Big.PE = PE;
    Big.version = "5.2.2";
    return Big;
}

function parse(x, n) {
    var e, i, nl;
    if (n === 0 && 1 / n < 0) n = "-0"; else if (!NUMERIC.test(n += "")) throw Error(INVALID + "number");
    x.s = n.charAt(0) == "-" ? (n = n.slice(1), -1) : 1;
    if ((e = n.indexOf(".")) > -1) n = n.replace(".", "");
    if ((i = n.search(/e/i)) > 0) {
        if (e < 0) e = i;
        e += +n.slice(i + 1);
        n = n.substring(0, i);
    } else if (e < 0) {
        e = n.length;
    }
    nl = n.length;
    for (i = 0; i < nl && n.charAt(i) == "0"; ) ++i;
    if (i == nl) {
        x.c = [ x.e = 0 ];
    } else {
        for (;nl > 0 && n.charAt(--nl) == "0"; ) ;
        x.e = e - i - 1;
        x.c = [];
        for (e = 0; i <= nl; ) x.c[e++] = +n.charAt(i++);
    }
    return x;
}

function round(x, dp, rm, more) {
    var xc = x.c, i = x.e + dp + 1;
    if (i < xc.length) {
        if (rm === 1) {
            more = xc[i] >= 5;
        } else if (rm === 2) {
            more = xc[i] > 5 || xc[i] == 5 && (more || i < 0 || xc[i + 1] !== UNDEFINED || xc[i - 1] & 1);
        } else if (rm === 3) {
            more = more || !!xc[0];
        } else {
            more = false;
            if (rm !== 0) throw Error(INVALID_RM);
        }
        if (i < 1) {
            xc.length = 1;
            if (more) {
                x.e = -dp;
                xc[0] = 1;
            } else {
                xc[0] = x.e = 0;
            }
        } else {
            xc.length = i--;
            if (more) {
                for (;++xc[i] > 9; ) {
                    xc[i] = 0;
                    if (!i--) {
                        ++x.e;
                        xc.unshift(1);
                    }
                }
            }
            for (i = xc.length; !xc[--i]; ) xc.pop();
        }
    } else if (rm < 0 || rm > 3 || rm !== ~~rm) {
        throw Error(INVALID_RM);
    }
    return x;
}

function stringify(x, id, n, k) {
    var e, s, Big = x.constructor, z = !x.c[0];
    if (n !== UNDEFINED) {
        if (n !== ~~n || n < (id == 3) || n > MAX_DP) {
            throw Error(id == 3 ? INVALID + "precision" : INVALID_DP);
        }
        x = new Big(x);
        n = k - x.e;
        if (x.c.length > ++k) round(x, n, Big.RM);
        if (id == 2) k = x.e + n + 1;
        for (;x.c.length < k; ) x.c.push(0);
    }
    e = x.e;
    s = x.c.join("");
    n = s.length;
    if (id != 2 && (id == 1 || id == 3 && k <= e || e <= Big.NE || e >= Big.PE)) {
        s = s.charAt(0) + (n > 1 ? "." + s.slice(1) : "") + (e < 0 ? "e" : "e+") + e;
    } else if (e < 0) {
        for (;++e; ) s = "0" + s;
        s = "0." + s;
    } else if (e > 0) {
        if (++e > n) for (e -= n; e--; ) s += "0"; else if (e < n) s = s.slice(0, e) + "." + s.slice(e);
    } else if (n > 1) {
        s = s.charAt(0) + "." + s.slice(1);
    }
    return x.s < 0 && (!z || id == 4) ? "-" + s : s;
}

P.abs = function() {
    var x = new this.constructor(this);
    x.s = 1;
    return x;
};

P.cmp = function(y) {
    var isneg, x = this, xc = x.c, yc = (y = new x.constructor(y)).c, i = x.s, j = y.s, k = x.e, l = y.e;
    if (!xc[0] || !yc[0]) return !xc[0] ? !yc[0] ? 0 : -j : i;
    if (i != j) return i;
    isneg = i < 0;
    if (k != l) return k > l ^ isneg ? 1 : -1;
    j = (k = xc.length) < (l = yc.length) ? k : l;
    for (i = -1; ++i < j; ) {
        if (xc[i] != yc[i]) return xc[i] > yc[i] ^ isneg ? 1 : -1;
    }
    return k == l ? 0 : k > l ^ isneg ? 1 : -1;
};

P.div = function(y) {
    var x = this, Big = x.constructor, a = x.c, b = (y = new Big(y)).c, k = x.s == y.s ? 1 : -1, dp = Big.DP;
    if (dp !== ~~dp || dp < 0 || dp > MAX_DP) throw Error(INVALID_DP);
    if (!b[0]) throw Error(DIV_BY_ZERO);
    if (!a[0]) return new Big(k * 0);
    var bl, bt, n, cmp, ri, bz = b.slice(), ai = bl = b.length, al = a.length, r = a.slice(0, bl), rl = r.length, q = y, qc = q.c = [], qi = 0, d = dp + (q.e = x.e - y.e) + 1;
    q.s = k;
    k = d < 0 ? 0 : d;
    bz.unshift(0);
    for (;rl++ < bl; ) r.push(0);
    do {
        for (n = 0; n < 10; n++) {
            if (bl != (rl = r.length)) {
                cmp = bl > rl ? 1 : -1;
            } else {
                for (ri = -1, cmp = 0; ++ri < bl; ) {
                    if (b[ri] != r[ri]) {
                        cmp = b[ri] > r[ri] ? 1 : -1;
                        break;
                    }
                }
            }
            if (cmp < 0) {
                for (bt = rl == bl ? b : bz; rl; ) {
                    if (r[--rl] < bt[rl]) {
                        ri = rl;
                        for (;ri && !r[--ri]; ) r[ri] = 9;
                        --r[ri];
                        r[rl] += 10;
                    }
                    r[rl] -= bt[rl];
                }
                for (;!r[0]; ) r.shift();
            } else {
                break;
            }
        }
        qc[qi++] = cmp ? n : ++n;
        if (r[0] && cmp) r[rl] = a[ai] || 0; else r = [ a[ai] ];
    } while ((ai++ < al || r[0] !== UNDEFINED) && k--);
    if (!qc[0] && qi != 1) {
        qc.shift();
        q.e--;
    }
    if (qi > d) round(q, dp, Big.RM, r[0] !== UNDEFINED);
    return q;
};

P.eq = function(y) {
    return !this.cmp(y);
};

P.gt = function(y) {
    return this.cmp(y) > 0;
};

P.gte = function(y) {
    return this.cmp(y) > -1;
};

P.lt = function(y) {
    return this.cmp(y) < 0;
};

P.lte = function(y) {
    return this.cmp(y) < 1;
};

P.minus = P.sub = function(y) {
    var i, j, t, xlty, x = this, Big = x.constructor, a = x.s, b = (y = new Big(y)).s;
    if (a != b) {
        y.s = -b;
        return x.plus(y);
    }
    var xc = x.c.slice(), xe = x.e, yc = y.c, ye = y.e;
    if (!xc[0] || !yc[0]) {
        return yc[0] ? (y.s = -b, y) : new Big(xc[0] ? x : 0);
    }
    if (a = xe - ye) {
        if (xlty = a < 0) {
            a = -a;
            t = xc;
        } else {
            ye = xe;
            t = yc;
        }
        t.reverse();
        for (b = a; b--; ) t.push(0);
        t.reverse();
    } else {
        j = ((xlty = xc.length < yc.length) ? xc : yc).length;
        for (a = b = 0; b < j; b++) {
            if (xc[b] != yc[b]) {
                xlty = xc[b] < yc[b];
                break;
            }
        }
    }
    if (xlty) {
        t = xc;
        xc = yc;
        yc = t;
        y.s = -y.s;
    }
    if ((b = (j = yc.length) - (i = xc.length)) > 0) for (;b--; ) xc[i++] = 0;
    for (b = i; j > a; ) {
        if (xc[--j] < yc[j]) {
            for (i = j; i && !xc[--i]; ) xc[i] = 9;
            --xc[i];
            xc[j] += 10;
        }
        xc[j] -= yc[j];
    }
    for (;xc[--b] === 0; ) xc.pop();
    for (;xc[0] === 0; ) {
        xc.shift();
        --ye;
    }
    if (!xc[0]) {
        y.s = 1;
        xc = [ ye = 0 ];
    }
    y.c = xc;
    y.e = ye;
    return y;
};

P.mod = function(y) {
    var ygtx, x = this, Big = x.constructor, a = x.s, b = (y = new Big(y)).s;
    if (!y.c[0]) throw Error(DIV_BY_ZERO);
    x.s = y.s = 1;
    ygtx = y.cmp(x) == 1;
    x.s = a;
    y.s = b;
    if (ygtx) return new Big(x);
    a = Big.DP;
    b = Big.RM;
    Big.DP = Big.RM = 0;
    x = x.div(y);
    Big.DP = a;
    Big.RM = b;
    return this.minus(x.times(y));
};

P.plus = P.add = function(y) {
    var t, x = this, Big = x.constructor, a = x.s, b = (y = new Big(y)).s;
    if (a != b) {
        y.s = -b;
        return x.minus(y);
    }
    var xe = x.e, xc = x.c, ye = y.e, yc = y.c;
    if (!xc[0] || !yc[0]) return yc[0] ? y : new Big(xc[0] ? x : a * 0);
    xc = xc.slice();
    if (a = xe - ye) {
        if (a > 0) {
            ye = xe;
            t = yc;
        } else {
            a = -a;
            t = xc;
        }
        t.reverse();
        for (;a--; ) t.push(0);
        t.reverse();
    }
    if (xc.length - yc.length < 0) {
        t = yc;
        yc = xc;
        xc = t;
    }
    a = yc.length;
    for (b = 0; a; xc[a] %= 10) b = (xc[--a] = xc[a] + yc[a] + b) / 10 | 0;
    if (b) {
        xc.unshift(b);
        ++ye;
    }
    for (a = xc.length; xc[--a] === 0; ) xc.pop();
    y.c = xc;
    y.e = ye;
    return y;
};

P.pow = function(n) {
    var x = this, one = new x.constructor(1), y = one, isneg = n < 0;
    if (n !== ~~n || n < -MAX_POWER || n > MAX_POWER) throw Error(INVALID + "exponent");
    if (isneg) n = -n;
    for (;;) {
        if (n & 1) y = y.times(x);
        n >>= 1;
        if (!n) break;
        x = x.times(x);
    }
    return isneg ? one.div(y) : y;
};

P.round = function(dp, rm) {
    var Big = this.constructor;
    if (dp === UNDEFINED) dp = 0; else if (dp !== ~~dp || dp < -MAX_DP || dp > MAX_DP) throw Error(INVALID_DP);
    return round(new Big(this), dp, rm === UNDEFINED ? Big.RM : rm);
};

P.sqrt = function() {
    var r, c, t, x = this, Big = x.constructor, s = x.s, e = x.e, half = new Big(.5);
    if (!x.c[0]) return new Big(x);
    if (s < 0) throw Error(NAME + "No square root");
    s = Math.sqrt(x + "");
    if (s === 0 || s === 1 / 0) {
        c = x.c.join("");
        if (!(c.length + e & 1)) c += "0";
        s = Math.sqrt(c);
        e = ((e + 1) / 2 | 0) - (e < 0 || e & 1);
        r = new Big((s == 1 / 0 ? "1e" : (s = s.toExponential()).slice(0, s.indexOf("e") + 1)) + e);
    } else {
        r = new Big(s);
    }
    e = r.e + (Big.DP += 4);
    do {
        t = r;
        r = half.times(t.plus(x.div(t)));
    } while (t.c.slice(0, e).join("") !== r.c.slice(0, e).join(""));
    return round(r, Big.DP -= 4, Big.RM);
};

P.times = P.mul = function(y) {
    var c, x = this, Big = x.constructor, xc = x.c, yc = (y = new Big(y)).c, a = xc.length, b = yc.length, i = x.e, j = y.e;
    y.s = x.s == y.s ? 1 : -1;
    if (!xc[0] || !yc[0]) return new Big(y.s * 0);
    y.e = i + j;
    if (a < b) {
        c = xc;
        xc = yc;
        yc = c;
        j = a;
        a = b;
        b = j;
    }
    for (c = new Array(j = a + b); j--; ) c[j] = 0;
    for (i = b; i--; ) {
        b = 0;
        for (j = a + i; j > i; ) {
            b = c[j] + yc[i] * xc[j - i - 1] + b;
            c[j--] = b % 10;
            b = b / 10 | 0;
        }
        c[j] = (c[j] + b) % 10;
    }
    if (b) ++y.e; else c.shift();
    for (i = c.length; !c[--i]; ) c.pop();
    y.c = c;
    return y;
};

P.toExponential = function(dp) {
    return stringify(this, 1, dp, dp);
};

P.toFixed = function(dp) {
    return stringify(this, 2, dp, this.e + dp);
};

P.toPrecision = function(sd) {
    return stringify(this, 3, sd, sd - 1);
};

P.toString = function() {
    return stringify(this);
};

P.valueOf = P.toJSON = function() {
    return stringify(this, 4);
};

var Big = _Big_();

function subtract(x, y) {
    return new Big(x).minus(y).toString();
}

var commonData = {
    userSign: "",
    currentSymbol: "BTC-USDT",
    currentContractInfo: {},
    contractInfoData: [],
    contractH5Url: "",
    currencyRate: "6.4",
    currencyCharacter: "CNY",
    priceColorType: 0,
    colorMode: 0,
    OS: 0,
    appVersion: "",
    isInReview: 1,
    isLogin: 0,
    webUrl: "",
    language: "",
    pageType: 53,
    contractType: "",
    userInfo: {}
};

async function read(module, key) {
    const data = await $nativeAPI.storage({
        action: "read",
        name: module,
        key: key
    });
    if (data && data != "") {
        return JSON.parse(data);
    }
    return null;
}

async function sendCommonConfig$1(param) {
    console.log(`public components sendCommonConfig: ${JSON.stringify(param)}`);
    let savedSymbol = await read("copyTrading", "currentCopyTradingSymbol");
    if (null == savedSymbol || 0 == savedSymbol.length) {
        commonData.currentSymbol = "BTC-USDT";
    } else {
        commonData.currentSymbol = savedSymbol;
    }
    commonData.contractH5Url = param.contractH5Url;
    commonData.currencyRate = param.currencyRate;
    if (param.currencyRate != null && 0 == param.currencyRate.length) {
        commonData.currencyRate = "1";
    }
    commonData.currencyCharacter = param.currencyCharacter;
    commonData.priceColorType = parseInt(param.priceColorType);
    commonData.colorMode = parseInt(param.colorMode);
    commonData.OS = parseInt(param.OS);
    commonData.appVersion = param.appVersion;
    commonData.isInReview = parseInt(param.isInReview);
    commonData.language = param.language;
    commonData.webUrl = param.h5Url;
}

function moduleDefine(moduleName, startFunction, defaultDataFunction) {
    console.log(`loadModule`, moduleName + " begin");
    $data[moduleName] = defaultDataFunction();
    $event[moduleName] = {
        start: startFunction
    };
    console.log(`loadModule`, moduleName + " end");
    return {
        moduleEvent: $event[moduleName],
        moduleData: $data[moduleName]
    };
}

Date.prototype.Format = function(fmt) {
    var o = {
        "M+": this.getMonth() + 1,
        "d+": this.getDate(),
        "h+": this.getHours(),
        "m+": this.getMinutes(),
        "s+": this.getSeconds(),
        "q+": Math.floor((this.getMonth() + 3) / 3),
        S: this.getMilliseconds()
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o) if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
    return fmt;
};

var curList = [];

async function start$2() {}

function defaultData$2() {
    return {
        list: []
    };
}

const {moduleData: moduleData$2, moduleEvent: moduleEvent$2} = moduleDefine("bottomListRadioDialog", start$2, defaultData$2);

async function refreshData(args) {
    const params = JSON.parse(args);
    console.log(`wp bottomRadioDialog refreshData ` + args.toString());
    moduleData$2.topTitle = params.topTitle;
    curList = params.list;
    for (var i = 0; i < curList.length; i++) {
        var item = curList[i];
        item.index = i;
        item.unSelectedImageVisibility = "visible";
        item.selectedImageVisibility = "gone";
        item.type = "normal";
        item.unSelectedImageVisibility = item.selected ? "gone" : "visible";
        item.selectedImageVisibility = item.selected ? "visible" : "gone";
    }
    moduleData$2.list = curList;
}

moduleEvent$2.popDismiss = function() {
    console.log(`wp popDismiss`);
    var dic = {
        closeAlert: true
    };
    moduleData$2.dialogInfo = JSON.stringify(dic);
};

moduleEvent$2.typeTapAction = function(index) {
    console.log(`wp typeTapAction  index=${index}`);
    var selectedItem;
    for (var i = 0; i < curList.length; i++) {
        var item = curList[i];
        if (i == index) {
            item.selected = true;
            item.unSelectedImageVisibility = "gone";
            item.selectedImageVisibility = "visible";
            selectedItem = item;
        } else {
            item.selected = false;
            item.unSelectedImageVisibility = "visible";
            item.selectedImageVisibility = "gone";
        }
    }
    moduleData$2.list = curList;
    var dic = {
        confirmAlert: true,
        selectedItem: selectedItem
    };
    moduleData$2.dialogInfo = JSON.stringify(dic);
};

var tempCoupons = [];

async function start$1() {}

function defaultData$1() {
    return {
        selCoupon: {},
        coupons: []
    };
}

const {moduleData: moduleData$1, moduleEvent: moduleEvent$1} = moduleDefine("couponListDialog", start$1, defaultData$1);

async function refreshCoupons$1(params) {
    const couponData = JSON.parse(params.replace(/\n/g, "\\n"));
    if (!couponData || couponData == null) return;
    const {currentId: currentId, coupons: coupons} = couponData;
    tempCoupons = [];
    handleCouponData(currentId, coupons);
    console.log(`couponListData--\x3e> coupons = ${JSON.stringify(tempCoupons)}`);
    moduleData$1.coupons = tempCoupons;
}

function handleCouponData(currentId, couponList) {
    if (!couponList || couponList == null) return;
    couponList.sort(((a, b) => {
        if (parseInt(a.type) === 9 && parseInt(b.type) === 12) {
            return -1;
        } else if (parseInt(a.type) === 12 && parseInt(b.type) === 9) {
            return 1;
        } else if (parseInt(a.type) === parseInt(b.type)) {
            return parseInt(subtract(a.validAt, b.validAt));
        }
        return 0;
    }));
    moduleData$1.selCoupon = {};
    moduleData$1.btnBackground = "@color/eColorInputFillDisabled";
    moduleData$1.btnColor = "@color/kColorThreeLevelText";
    for (let i = 0; i < couponList.length; ++i) {
        let v = couponList[i];
        v.index = i;
        if (parseInt(currentId) == parseInt(v.id) || parseInt(currentId) == parseInt(v.listId)) {
            v.selected = true;
            v.unSelectedImageVisibility = "gone";
            v.selectedImageVisibility = "visible";
            moduleData$1.selCoupon = v;
            moduleData$1.btnBackground = "@color/kColorMajorTheme100";
            moduleData$1.btnColor = "@color/KBaseTextColor";
        } else {
            v.selected = false;
            v.unSelectedImageVisibility = "visible";
            v.selectedImageVisibility = "gone";
        }
        v.unfold = false;
        v.unfoldVisibility = "gone";
        v.foldVisibility = "visible";
        if (v.validAt > 0) {
            v.time = $i18n.$intercept.n_coupon_time_dealine(new Date(v.validAt).Format("yyyy-MM-dd"));
        } else {
            v.time = "--";
        }
        if (parseInt(v.type) == 9) {
            v.type = "coupon";
            initCouponData(v);
        } else {
            v.type = "discount";
            initDiscountData(v);
        }
        tempCoupons.push(v);
    }
}

function initCouponData(coupon) {
    coupon.baseCurrency = coupon.baseCurrency.toUpperCase();
}

function initDiscountData(discount) {
    if (discount.amount > 0) {
        if (parseInt(discount.amount) == 100) {
            discount.fee = $i18n.n_transaction_interest_free;
        } else if (commonData.language.toLowerCase().startsWith("zh-")) {
            discount.fee = `${$i18n.$intercept.n_transaction_fee(((100 - parseFloat(discount.amount)) / 10).toFixed(1))}`;
        } else {
            discount.fee = `${$i18n.$intercept.n_transaction_fee(parseFloat(discount.amount).toFixed(0).toString() + "%")}`;
        }
    } else {
        discount.fee = "--";
    }
    if (discount.state == 0) {
        discount.stateText = $i18n.n_coupon_state_not_use;
    } else {
        discount.stateText = $i18n.n_coupon_state_using;
    }
}

moduleEvent$1.unfoldRulesTapAction = function(index) {
    for (var i = 0; i < tempCoupons.length; i++) {
        var item = tempCoupons[i];
        if (i == index) {
            item.unfold = !item.unfold;
            item.unfoldVisibility = item.unfold ? "visible" : "gone";
            item.foldVisibility = item.unfold ? "gone" : "visible";
        } else {
            item.unfold = false;
            item.unfoldVisibility = "gone";
            item.foldVisibility = "visible";
        }
    }
    moduleData$1.coupons = tempCoupons;
};

moduleEvent$1.couponTapAction = function(index) {
    for (var i = 0; i < tempCoupons.length; i++) {
        var item = tempCoupons[i];
        if (item.type == "coupon") {
            if (i == index) {
                item.selected = !item.selected;
                item.unSelectedImageVisibility = item.selected ? "gone" : "visible";
                item.selectedImageVisibility = item.selected ? "visible" : "gone";
                if (item.selected) {
                    moduleData$1.selCoupon = item;
                    moduleData$1.btnBackground = "@color/kColorMajorTheme100";
                    moduleData$1.btnColor = "@color/KBaseTextColor";
                } else {
                    moduleData$1.selCoupon = {};
                    moduleData$1.btnBackground = "@color/eColorInputFillDisabled";
                    moduleData$1.btnColor = "@color/kColorThreeLevelText";
                }
            } else {
                item.selected = false;
                item.unSelectedImageVisibility = "visible";
                item.selectedImageVisibility = "gone";
            }
        }
    }
    moduleData$1.coupons = tempCoupons;
};

moduleEvent$1.popConfirm = function() {
    if (moduleData$1.selCoupon.id != null && moduleData$1.selCoupon.id != "undefined" && moduleData$1.selCoupon.id != "") {
        let couponData = JSON.stringify(moduleData$1.selCoupon.rawObject()).replace('"type":"coupon"', '"type":9').replace('"type":"discount"', '"type":12');
        moduleData$1.confirmData = `{"confirm":true, "currentCoupon":${couponData}}`;
    }
};

moduleEvent$1.popDismiss = function() {
    moduleData$1.confirmData = `{"confirm":false}`;
};

async function start() {}

function defaultData() {
    console.log(`public components defaultData  ${commonData.webUrl}`);
    return {
        singleBorderColor: "@color/kColorMajorTheme100",
        unionBorderColor: "@color/baseColorInputBackground",
        richTextData: ""
    };
}

const {moduleData: moduleData, moduleEvent: moduleEvent} = moduleDefine("bottomUnionPatternDialog", start, defaultData);

async function refreshAssetData$1(args) {
    console.log(`public components defaultData  ${args}`);
    const params = JSON.parse(args);
    console.log(params);
    if (params.isUnion === "1") {
        console.log("进入联合保证金");
        moduleData.singleBorderColor = "@color/baseColorInputBackground";
        moduleData.unionBorderColor = "@color/kColorMajorTheme100";
    } else {
        console.log("进入单币保证金");
        moduleData.singleBorderColor = "@color/kColorMajorTheme100";
        moduleData.unionBorderColor = "@color/baseColorInputBackground";
    }
    moduleData.richTextData = `{"content":"n_unit_asset_detail_desc","textColor":"KBaseColorSecondaryText","textSize":12,"highlight":[{"content":"n_unit_asset_detail_limit","link":"","textColor":"kColorPrimaryText","textSize":12},{"content":"n_unit_asset_detail_link","link":"${commonData.webUrl}/${commonData.language}/support/45000308207138","textColor":"kColorMajorTheme100","textSize":12}]}`;
}

moduleEvent.popDismiss = function() {
    var dic = {
        closeAlert: true
    };
    moduleData.dialogInfo = JSON.stringify(dic);
};

moduleEvent.richTextLinkCallback = function() {
    var dic = {
        closeAlert: true
    };
    moduleData.dialogInfo = JSON.stringify(dic);
};

moduleEvent.pickSingle = function() {
    if (moduleData.singleBorderColor === "@color/kColorMajorTheme100") {
        return;
    }
    moduleData.singleBorderColor = "@color/kColorMajorTheme100";
    moduleData.unionBorderColor = "@color/baseColorInputBackground";
    var dic = {
        isUnion: false
    };
    moduleData.dialogInfo = JSON.stringify(dic);
};

moduleEvent.pickUnion = function() {
    if (moduleData.unionBorderColor === "@color/kColorMajorTheme100") {
        return;
    }
    moduleData.singleBorderColor = "@color/baseColorInputBackground";
    moduleData.unionBorderColor = "@color/kColorMajorTheme100";
    var dic = {
        isUnion: true
    };
    moduleData.dialogInfo = JSON.stringify(dic);
};

function sendCommonConfig(param) {
    sendCommonConfig$1(param);
}

async function moduleAppear() {
    console.log("main-moduleAppear");
}

function moduleWillDisappear() {
    console.log("main-moduleWillDisappear");
}

async function moduleDisappear() {
    console.log("main-moduleDisappear");
}

async function sendSocketData(data) {
    if (data.type == "market") {
        commonData.marketData = JSON.parse(data.data);
    } else if (data.type == "linearSwapWs") {
        commonData.linearSwapWsData = JSON.parse(data.data);
    }
}

async function refreshBottomData(params) {
    refreshData(params);
}

async function refreshCoupons(params) {
    refreshCoupons$1(params);
}

async function refreshAssetData(params) {
    refreshAssetData$1(params);
}

$event.sendCommonConfig = sendCommonConfig;

$event.moduleAppear = moduleAppear;

$event.moduleWillDisappear = moduleWillDisappear;

$event.moduleDisappear = moduleDisappear;

$event.sendSocketData = sendSocketData;

$event.refreshBottomData = refreshBottomData;

$event.refreshAssetData = refreshAssetData;

$event.refreshCoupons = refreshCoupons;
//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoibWFpbi5qcyIsInNvdXJjZXMiOlsiLi4vLi4vcmVwb3NpdG9yeS9ub2RlX21vZHVsZXMvYmlnLmpzL2JpZy5tanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9udW1iZXIuanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9jb21tb24uanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9ib3R0b21MaXN0UmFkaW9EaWFsb2cuanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9jb3Vwb25MaXN0RGlhbG9nLmpzIiwiLi4vLi4vcmVwb3NpdG9yeS9zcmMvYm90dG9tVW5pb25QYXR0ZXJuRGlhbG9nLmpzIiwiLi4vLi4vcmVwb3NpdG9yeS9zcmMvbWFpbi5qcyJdLCJzb3VyY2VzQ29udGVudCI6WyIvKlxyXG4gKiAgYmlnLmpzIHY1LjIuMlxyXG4gKiAgQSBzbWFsbCwgZmFzdCwgZWFzeS10by11c2UgbGlicmFyeSBmb3IgYXJiaXRyYXJ5LXByZWNpc2lvbiBkZWNpbWFsIGFyaXRobWV0aWMuXHJcbiAqICBDb3B5cmlnaHQgKGMpIDIwMTggTWljaGFlbCBNY2xhdWdobGluIDxNOGNoODhsQGdtYWlsLmNvbT5cclxuICogIGh0dHBzOi8vZ2l0aHViLmNvbS9NaWtlTWNsL2JpZy5qcy9MSUNFTkNFXHJcbiAqL1xyXG5cclxuXHJcbi8qKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKiBFRElUQUJMRSBERUZBVUxUUyAqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKi9cclxuXHJcblxyXG4gIC8vIFRoZSBkZWZhdWx0IHZhbHVlcyBiZWxvdyBtdXN0IGJlIGludGVnZXJzIHdpdGhpbiB0aGUgc3RhdGVkIHJhbmdlcy5cclxuXHJcbiAgLypcclxuICAgKiBUaGUgbWF4aW11bSBudW1iZXIgb2YgZGVjaW1hbCBwbGFjZXMgKERQKSBvZiB0aGUgcmVzdWx0cyBvZiBvcGVyYXRpb25zIGludm9sdmluZyBkaXZpc2lvbjpcclxuICAgKiBkaXYgYW5kIHNxcnQsIGFuZCBwb3cgd2l0aCBuZWdhdGl2ZSBleHBvbmVudHMuXHJcbiAgICovXHJcbnZhciBEUCA9IDIwLCAgICAgICAgICAvLyAwIHRvIE1BWF9EUFxyXG5cclxuICAvKlxyXG4gICAqIFRoZSByb3VuZGluZyBtb2RlIChSTSkgdXNlZCB3aGVuIHJvdW5kaW5nIHRvIHRoZSBhYm92ZSBkZWNpbWFsIHBsYWNlcy5cclxuICAgKlxyXG4gICAqICAwICBUb3dhcmRzIHplcm8gKGkuZS4gdHJ1bmNhdGUsIG5vIHJvdW5kaW5nKS4gICAgICAgKFJPVU5EX0RPV04pXHJcbiAgICogIDEgIFRvIG5lYXJlc3QgbmVpZ2hib3VyLiBJZiBlcXVpZGlzdGFudCwgcm91bmQgdXAuICAoUk9VTkRfSEFMRl9VUClcclxuICAgKiAgMiAgVG8gbmVhcmVzdCBuZWlnaGJvdXIuIElmIGVxdWlkaXN0YW50LCB0byBldmVuLiAgIChST1VORF9IQUxGX0VWRU4pXHJcbiAgICogIDMgIEF3YXkgZnJvbSB6ZXJvLiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAoUk9VTkRfVVApXHJcbiAgICovXHJcbiAgUk0gPSAxLCAgICAgICAgICAgICAvLyAwLCAxLCAyIG9yIDNcclxuXHJcbiAgLy8gVGhlIG1heGltdW0gdmFsdWUgb2YgRFAgYW5kIEJpZy5EUC5cclxuICBNQVhfRFAgPSAxRTYsICAgICAgIC8vIDAgdG8gMTAwMDAwMFxyXG5cclxuICAvLyBUaGUgbWF4aW11bSBtYWduaXR1ZGUgb2YgdGhlIGV4cG9uZW50IGFyZ3VtZW50IHRvIHRoZSBwb3cgbWV0aG9kLlxyXG4gIE1BWF9QT1dFUiA9IDFFNiwgICAgLy8gMSB0byAxMDAwMDAwXHJcblxyXG4gIC8qXHJcbiAgICogVGhlIG5lZ2F0aXZlIGV4cG9uZW50IChORSkgYXQgYW5kIGJlbmVhdGggd2hpY2ggdG9TdHJpbmcgcmV0dXJucyBleHBvbmVudGlhbCBub3RhdGlvbi5cclxuICAgKiAoSmF2YVNjcmlwdCBudW1iZXJzOiAtNylcclxuICAgKiAtMTAwMDAwMCBpcyB0aGUgbWluaW11bSByZWNvbW1lbmRlZCBleHBvbmVudCB2YWx1ZSBvZiBhIEJpZy5cclxuICAgKi9cclxuICBORSA9IC03LCAgICAgICAgICAgIC8vIDAgdG8gLTEwMDAwMDBcclxuXHJcbiAgLypcclxuICAgKiBUaGUgcG9zaXRpdmUgZXhwb25lbnQgKFBFKSBhdCBhbmQgYWJvdmUgd2hpY2ggdG9TdHJpbmcgcmV0dXJucyBleHBvbmVudGlhbCBub3RhdGlvbi5cclxuICAgKiAoSmF2YVNjcmlwdCBudW1iZXJzOiAyMSlcclxuICAgKiAxMDAwMDAwIGlzIHRoZSBtYXhpbXVtIHJlY29tbWVuZGVkIGV4cG9uZW50IHZhbHVlIG9mIGEgQmlnLlxyXG4gICAqIChUaGlzIGxpbWl0IGlzIG5vdCBlbmZvcmNlZCBvciBjaGVja2VkLilcclxuICAgKi9cclxuICBQRSA9IDIxLCAgICAgICAgICAgIC8vIDAgdG8gMTAwMDAwMFxyXG5cclxuXHJcbi8qKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKi9cclxuXHJcblxyXG4gIC8vIEVycm9yIG1lc3NhZ2VzLlxyXG4gIE5BTUUgPSAnW2JpZy5qc10gJyxcclxuICBJTlZBTElEID0gTkFNRSArICdJbnZhbGlkICcsXHJcbiAgSU5WQUxJRF9EUCA9IElOVkFMSUQgKyAnZGVjaW1hbCBwbGFjZXMnLFxyXG4gIElOVkFMSURfUk0gPSBJTlZBTElEICsgJ3JvdW5kaW5nIG1vZGUnLFxyXG4gIERJVl9CWV9aRVJPID0gTkFNRSArICdEaXZpc2lvbiBieSB6ZXJvJyxcclxuXHJcbiAgLy8gVGhlIHNoYXJlZCBwcm90b3R5cGUgb2JqZWN0LlxyXG4gIFAgPSB7fSxcclxuICBVTkRFRklORUQgPSB2b2lkIDAsXHJcbiAgTlVNRVJJQyA9IC9eLT8oXFxkKyhcXC5cXGQqKT98XFwuXFxkKykoZVsrLV0/XFxkKyk/JC9pO1xyXG5cclxuXHJcbi8qXHJcbiAqIENyZWF0ZSBhbmQgcmV0dXJuIGEgQmlnIGNvbnN0cnVjdG9yLlxyXG4gKlxyXG4gKi9cclxuZnVuY3Rpb24gX0JpZ18oKSB7XHJcblxyXG4gIC8qXHJcbiAgICogVGhlIEJpZyBjb25zdHJ1Y3RvciBhbmQgZXhwb3J0ZWQgZnVuY3Rpb24uXHJcbiAgICogQ3JlYXRlIGFuZCByZXR1cm4gYSBuZXcgaW5zdGFuY2Ugb2YgYSBCaWcgbnVtYmVyIG9iamVjdC5cclxuICAgKlxyXG4gICAqIG4ge251bWJlcnxzdHJpbmd8QmlnfSBBIG51bWVyaWMgdmFsdWUuXHJcbiAgICovXHJcbiAgZnVuY3Rpb24gQmlnKG4pIHtcclxuICAgIHZhciB4ID0gdGhpcztcclxuXHJcbiAgICAvLyBFbmFibGUgY29uc3RydWN0b3IgdXNhZ2Ugd2l0aG91dCBuZXcuXHJcbiAgICBpZiAoISh4IGluc3RhbmNlb2YgQmlnKSkgcmV0dXJuIG4gPT09IFVOREVGSU5FRCA/IF9CaWdfKCkgOiBuZXcgQmlnKG4pO1xyXG5cclxuICAgIC8vIER1cGxpY2F0ZS5cclxuICAgIGlmIChuIGluc3RhbmNlb2YgQmlnKSB7XHJcbiAgICAgIHgucyA9IG4ucztcclxuICAgICAgeC5lID0gbi5lO1xyXG4gICAgICB4LmMgPSBuLmMuc2xpY2UoKTtcclxuICAgIH0gZWxzZSB7XHJcbiAgICAgIHBhcnNlKHgsIG4pO1xyXG4gICAgfVxyXG5cclxuICAgIC8qXHJcbiAgICAgKiBSZXRhaW4gYSByZWZlcmVuY2UgdG8gdGhpcyBCaWcgY29uc3RydWN0b3IsIGFuZCBzaGFkb3cgQmlnLnByb3RvdHlwZS5jb25zdHJ1Y3RvciB3aGljaFxyXG4gICAgICogcG9pbnRzIHRvIE9iamVjdC5cclxuICAgICAqL1xyXG4gICAgeC5jb25zdHJ1Y3RvciA9IEJpZztcclxuICB9XHJcblxyXG4gIEJpZy5wcm90b3R5cGUgPSBQO1xyXG4gIEJpZy5EUCA9IERQO1xyXG4gIEJpZy5STSA9IFJNO1xyXG4gIEJpZy5ORSA9IE5FO1xyXG4gIEJpZy5QRSA9IFBFO1xyXG4gIEJpZy52ZXJzaW9uID0gJzUuMi4yJztcclxuXHJcbiAgcmV0dXJuIEJpZztcclxufVxyXG5cclxuXHJcbi8qXHJcbiAqIFBhcnNlIHRoZSBudW1iZXIgb3Igc3RyaW5nIHZhbHVlIHBhc3NlZCB0byBhIEJpZyBjb25zdHJ1Y3Rvci5cclxuICpcclxuICogeCB7QmlnfSBBIEJpZyBudW1iZXIgaW5zdGFuY2UuXHJcbiAqIG4ge251bWJlcnxzdHJpbmd9IEEgbnVtZXJpYyB2YWx1ZS5cclxuICovXHJcbmZ1bmN0aW9uIHBhcnNlKHgsIG4pIHtcclxuICB2YXIgZSwgaSwgbmw7XHJcblxyXG4gIC8vIE1pbnVzIHplcm8/XHJcbiAgaWYgKG4gPT09IDAgJiYgMSAvIG4gPCAwKSBuID0gJy0wJztcclxuICBlbHNlIGlmICghTlVNRVJJQy50ZXN0KG4gKz0gJycpKSB0aHJvdyBFcnJvcihJTlZBTElEICsgJ251bWJlcicpO1xyXG5cclxuICAvLyBEZXRlcm1pbmUgc2lnbi5cclxuICB4LnMgPSBuLmNoYXJBdCgwKSA9PSAnLScgPyAobiA9IG4uc2xpY2UoMSksIC0xKSA6IDE7XHJcblxyXG4gIC8vIERlY2ltYWwgcG9pbnQ/XHJcbiAgaWYgKChlID0gbi5pbmRleE9mKCcuJykpID4gLTEpIG4gPSBuLnJlcGxhY2UoJy4nLCAnJyk7XHJcblxyXG4gIC8vIEV4cG9uZW50aWFsIGZvcm0/XHJcbiAgaWYgKChpID0gbi5zZWFyY2goL2UvaSkpID4gMCkge1xyXG5cclxuICAgIC8vIERldGVybWluZSBleHBvbmVudC5cclxuICAgIGlmIChlIDwgMCkgZSA9IGk7XHJcbiAgICBlICs9ICtuLnNsaWNlKGkgKyAxKTtcclxuICAgIG4gPSBuLnN1YnN0cmluZygwLCBpKTtcclxuICB9IGVsc2UgaWYgKGUgPCAwKSB7XHJcblxyXG4gICAgLy8gSW50ZWdlci5cclxuICAgIGUgPSBuLmxlbmd0aDtcclxuICB9XHJcblxyXG4gIG5sID0gbi5sZW5ndGg7XHJcblxyXG4gIC8vIERldGVybWluZSBsZWFkaW5nIHplcm9zLlxyXG4gIGZvciAoaSA9IDA7IGkgPCBubCAmJiBuLmNoYXJBdChpKSA9PSAnMCc7KSArK2k7XHJcblxyXG4gIGlmIChpID09IG5sKSB7XHJcblxyXG4gICAgLy8gWmVyby5cclxuICAgIHguYyA9IFt4LmUgPSAwXTtcclxuICB9IGVsc2Uge1xyXG5cclxuICAgIC8vIERldGVybWluZSB0cmFpbGluZyB6ZXJvcy5cclxuICAgIGZvciAoOyBubCA+IDAgJiYgbi5jaGFyQXQoLS1ubCkgPT0gJzAnOyk7XHJcbiAgICB4LmUgPSBlIC0gaSAtIDE7XHJcbiAgICB4LmMgPSBbXTtcclxuXHJcbiAgICAvLyBDb252ZXJ0IHN0cmluZyB0byBhcnJheSBvZiBkaWdpdHMgd2l0aG91dCBsZWFkaW5nL3RyYWlsaW5nIHplcm9zLlxyXG4gICAgZm9yIChlID0gMDsgaSA8PSBubDspIHguY1tlKytdID0gK24uY2hhckF0KGkrKyk7XHJcbiAgfVxyXG5cclxuICByZXR1cm4geDtcclxufVxyXG5cclxuXHJcbi8qXHJcbiAqIFJvdW5kIEJpZyB4IHRvIGEgbWF4aW11bSBvZiBkcCBkZWNpbWFsIHBsYWNlcyB1c2luZyByb3VuZGluZyBtb2RlIHJtLlxyXG4gKiBDYWxsZWQgYnkgc3RyaW5naWZ5LCBQLmRpdiwgUC5yb3VuZCBhbmQgUC5zcXJ0LlxyXG4gKlxyXG4gKiB4IHtCaWd9IFRoZSBCaWcgdG8gcm91bmQuXHJcbiAqIGRwIHtudW1iZXJ9IEludGVnZXIsIDAgdG8gTUFYX0RQIGluY2x1c2l2ZS5cclxuICogcm0ge251bWJlcn0gMCwgMSwgMiBvciAzIChET1dOLCBIQUxGX1VQLCBIQUxGX0VWRU4sIFVQKVxyXG4gKiBbbW9yZV0ge2Jvb2xlYW59IFdoZXRoZXIgdGhlIHJlc3VsdCBvZiBkaXZpc2lvbiB3YXMgdHJ1bmNhdGVkLlxyXG4gKi9cclxuZnVuY3Rpb24gcm91bmQoeCwgZHAsIHJtLCBtb3JlKSB7XHJcbiAgdmFyIHhjID0geC5jLFxyXG4gICAgaSA9IHguZSArIGRwICsgMTtcclxuXHJcbiAgaWYgKGkgPCB4Yy5sZW5ndGgpIHtcclxuICAgIGlmIChybSA9PT0gMSkge1xyXG5cclxuICAgICAgLy8geGNbaV0gaXMgdGhlIGRpZ2l0IGFmdGVyIHRoZSBkaWdpdCB0aGF0IG1heSBiZSByb3VuZGVkIHVwLlxyXG4gICAgICBtb3JlID0geGNbaV0gPj0gNTtcclxuICAgIH0gZWxzZSBpZiAocm0gPT09IDIpIHtcclxuICAgICAgbW9yZSA9IHhjW2ldID4gNSB8fCB4Y1tpXSA9PSA1ICYmXHJcbiAgICAgICAgKG1vcmUgfHwgaSA8IDAgfHwgeGNbaSArIDFdICE9PSBVTkRFRklORUQgfHwgeGNbaSAtIDFdICYgMSk7XHJcbiAgICB9IGVsc2UgaWYgKHJtID09PSAzKSB7XHJcbiAgICAgIG1vcmUgPSBtb3JlIHx8ICEheGNbMF07XHJcbiAgICB9IGVsc2Uge1xyXG4gICAgICBtb3JlID0gZmFsc2U7XHJcbiAgICAgIGlmIChybSAhPT0gMCkgdGhyb3cgRXJyb3IoSU5WQUxJRF9STSk7XHJcbiAgICB9XHJcblxyXG4gICAgaWYgKGkgPCAxKSB7XHJcbiAgICAgIHhjLmxlbmd0aCA9IDE7XHJcblxyXG4gICAgICBpZiAobW9yZSkge1xyXG5cclxuICAgICAgICAvLyAxLCAwLjEsIDAuMDEsIDAuMDAxLCAwLjAwMDEgZXRjLlxyXG4gICAgICAgIHguZSA9IC1kcDtcclxuICAgICAgICB4Y1swXSA9IDE7XHJcbiAgICAgIH0gZWxzZSB7XHJcblxyXG4gICAgICAgIC8vIFplcm8uXHJcbiAgICAgICAgeGNbMF0gPSB4LmUgPSAwO1xyXG4gICAgICB9XHJcbiAgICB9IGVsc2Uge1xyXG5cclxuICAgICAgLy8gUmVtb3ZlIGFueSBkaWdpdHMgYWZ0ZXIgdGhlIHJlcXVpcmVkIGRlY2ltYWwgcGxhY2VzLlxyXG4gICAgICB4Yy5sZW5ndGggPSBpLS07XHJcblxyXG4gICAgICAvLyBSb3VuZCB1cD9cclxuICAgICAgaWYgKG1vcmUpIHtcclxuXHJcbiAgICAgICAgLy8gUm91bmRpbmcgdXAgbWF5IG1lYW4gdGhlIHByZXZpb3VzIGRpZ2l0IGhhcyB0byBiZSByb3VuZGVkIHVwLlxyXG4gICAgICAgIGZvciAoOyArK3hjW2ldID4gOTspIHtcclxuICAgICAgICAgIHhjW2ldID0gMDtcclxuICAgICAgICAgIGlmICghaS0tKSB7XHJcbiAgICAgICAgICAgICsreC5lO1xyXG4gICAgICAgICAgICB4Yy51bnNoaWZ0KDEpO1xyXG4gICAgICAgICAgfVxyXG4gICAgICAgIH1cclxuICAgICAgfVxyXG5cclxuICAgICAgLy8gUmVtb3ZlIHRyYWlsaW5nIHplcm9zLlxyXG4gICAgICBmb3IgKGkgPSB4Yy5sZW5ndGg7ICF4Y1stLWldOykgeGMucG9wKCk7XHJcbiAgICB9XHJcbiAgfSBlbHNlIGlmIChybSA8IDAgfHwgcm0gPiAzIHx8IHJtICE9PSB+fnJtKSB7XHJcbiAgICB0aHJvdyBFcnJvcihJTlZBTElEX1JNKTtcclxuICB9XHJcblxyXG4gIHJldHVybiB4O1xyXG59XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgc3RyaW5nIHJlcHJlc2VudGluZyB0aGUgdmFsdWUgb2YgQmlnIHggaW4gbm9ybWFsIG9yIGV4cG9uZW50aWFsIG5vdGF0aW9uLlxyXG4gKiBIYW5kbGVzIFAudG9FeHBvbmVudGlhbCwgUC50b0ZpeGVkLCBQLnRvSlNPTiwgUC50b1ByZWNpc2lvbiwgUC50b1N0cmluZyBhbmQgUC52YWx1ZU9mLlxyXG4gKlxyXG4gKiB4IHtCaWd9XHJcbiAqIGlkPyB7bnVtYmVyfSBDYWxsZXIgaWQuXHJcbiAqICAgICAgICAgMSB0b0V4cG9uZW50aWFsXHJcbiAqICAgICAgICAgMiB0b0ZpeGVkXHJcbiAqICAgICAgICAgMyB0b1ByZWNpc2lvblxyXG4gKiAgICAgICAgIDQgdmFsdWVPZlxyXG4gKiBuPyB7bnVtYmVyfHVuZGVmaW5lZH0gQ2FsbGVyJ3MgYXJndW1lbnQuXHJcbiAqIGs/IHtudW1iZXJ8dW5kZWZpbmVkfVxyXG4gKi9cclxuZnVuY3Rpb24gc3RyaW5naWZ5KHgsIGlkLCBuLCBrKSB7XHJcbiAgdmFyIGUsIHMsXHJcbiAgICBCaWcgPSB4LmNvbnN0cnVjdG9yLFxyXG4gICAgeiA9ICF4LmNbMF07XHJcblxyXG4gIGlmIChuICE9PSBVTkRFRklORUQpIHtcclxuICAgIGlmIChuICE9PSB+fm4gfHwgbiA8IChpZCA9PSAzKSB8fCBuID4gTUFYX0RQKSB7XHJcbiAgICAgIHRocm93IEVycm9yKGlkID09IDMgPyBJTlZBTElEICsgJ3ByZWNpc2lvbicgOiBJTlZBTElEX0RQKTtcclxuICAgIH1cclxuXHJcbiAgICB4ID0gbmV3IEJpZyh4KTtcclxuXHJcbiAgICAvLyBUaGUgaW5kZXggb2YgdGhlIGRpZ2l0IHRoYXQgbWF5IGJlIHJvdW5kZWQgdXAuXHJcbiAgICBuID0gayAtIHguZTtcclxuXHJcbiAgICAvLyBSb3VuZD9cclxuICAgIGlmICh4LmMubGVuZ3RoID4gKytrKSByb3VuZCh4LCBuLCBCaWcuUk0pO1xyXG5cclxuICAgIC8vIHRvRml4ZWQ6IHJlY2FsY3VsYXRlIGsgYXMgeC5lIG1heSBoYXZlIGNoYW5nZWQgaWYgdmFsdWUgcm91bmRlZCB1cC5cclxuICAgIGlmIChpZCA9PSAyKSBrID0geC5lICsgbiArIDE7XHJcblxyXG4gICAgLy8gQXBwZW5kIHplcm9zP1xyXG4gICAgZm9yICg7IHguYy5sZW5ndGggPCBrOykgeC5jLnB1c2goMCk7XHJcbiAgfVxyXG5cclxuICBlID0geC5lO1xyXG4gIHMgPSB4LmMuam9pbignJyk7XHJcbiAgbiA9IHMubGVuZ3RoO1xyXG5cclxuICAvLyBFeHBvbmVudGlhbCBub3RhdGlvbj9cclxuICBpZiAoaWQgIT0gMiAmJiAoaWQgPT0gMSB8fCBpZCA9PSAzICYmIGsgPD0gZSB8fCBlIDw9IEJpZy5ORSB8fCBlID49IEJpZy5QRSkpIHtcclxuICAgIHMgPSBzLmNoYXJBdCgwKSArIChuID4gMSA/ICcuJyArIHMuc2xpY2UoMSkgOiAnJykgKyAoZSA8IDAgPyAnZScgOiAnZSsnKSArIGU7XHJcblxyXG4gIC8vIE5vcm1hbCBub3RhdGlvbi5cclxuICB9IGVsc2UgaWYgKGUgPCAwKSB7XHJcbiAgICBmb3IgKDsgKytlOykgcyA9ICcwJyArIHM7XHJcbiAgICBzID0gJzAuJyArIHM7XHJcbiAgfSBlbHNlIGlmIChlID4gMCkge1xyXG4gICAgaWYgKCsrZSA+IG4pIGZvciAoZSAtPSBuOyBlLS07KSBzICs9ICcwJztcclxuICAgIGVsc2UgaWYgKGUgPCBuKSBzID0gcy5zbGljZSgwLCBlKSArICcuJyArIHMuc2xpY2UoZSk7XHJcbiAgfSBlbHNlIGlmIChuID4gMSkge1xyXG4gICAgcyA9IHMuY2hhckF0KDApICsgJy4nICsgcy5zbGljZSgxKTtcclxuICB9XHJcblxyXG4gIHJldHVybiB4LnMgPCAwICYmICgheiB8fCBpZCA9PSA0KSA/ICctJyArIHMgOiBzO1xyXG59XHJcblxyXG5cclxuLy8gUHJvdG90eXBlL2luc3RhbmNlIG1ldGhvZHNcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBuZXcgQmlnIHdob3NlIHZhbHVlIGlzIHRoZSBhYnNvbHV0ZSB2YWx1ZSBvZiB0aGlzIEJpZy5cclxuICovXHJcblAuYWJzID0gZnVuY3Rpb24gKCkge1xyXG4gIHZhciB4ID0gbmV3IHRoaXMuY29uc3RydWN0b3IodGhpcyk7XHJcbiAgeC5zID0gMTtcclxuICByZXR1cm4geDtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gMSBpZiB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgaXMgZ3JlYXRlciB0aGFuIHRoZSB2YWx1ZSBvZiBCaWcgeSxcclxuICogICAgICAgLTEgaWYgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIGlzIGxlc3MgdGhhbiB0aGUgdmFsdWUgb2YgQmlnIHksIG9yXHJcbiAqICAgICAgICAwIGlmIHRoZXkgaGF2ZSB0aGUgc2FtZSB2YWx1ZS5cclxuKi9cclxuUC5jbXAgPSBmdW5jdGlvbiAoeSkge1xyXG4gIHZhciBpc25lZyxcclxuICAgIHggPSB0aGlzLFxyXG4gICAgeGMgPSB4LmMsXHJcbiAgICB5YyA9ICh5ID0gbmV3IHguY29uc3RydWN0b3IoeSkpLmMsXHJcbiAgICBpID0geC5zLFxyXG4gICAgaiA9IHkucyxcclxuICAgIGsgPSB4LmUsXHJcbiAgICBsID0geS5lO1xyXG5cclxuICAvLyBFaXRoZXIgemVybz9cclxuICBpZiAoIXhjWzBdIHx8ICF5Y1swXSkgcmV0dXJuICF4Y1swXSA/ICF5Y1swXSA/IDAgOiAtaiA6IGk7XHJcblxyXG4gIC8vIFNpZ25zIGRpZmZlcj9cclxuICBpZiAoaSAhPSBqKSByZXR1cm4gaTtcclxuXHJcbiAgaXNuZWcgPSBpIDwgMDtcclxuXHJcbiAgLy8gQ29tcGFyZSBleHBvbmVudHMuXHJcbiAgaWYgKGsgIT0gbCkgcmV0dXJuIGsgPiBsIF4gaXNuZWcgPyAxIDogLTE7XHJcblxyXG4gIGogPSAoayA9IHhjLmxlbmd0aCkgPCAobCA9IHljLmxlbmd0aCkgPyBrIDogbDtcclxuXHJcbiAgLy8gQ29tcGFyZSBkaWdpdCBieSBkaWdpdC5cclxuICBmb3IgKGkgPSAtMTsgKytpIDwgajspIHtcclxuICAgIGlmICh4Y1tpXSAhPSB5Y1tpXSkgcmV0dXJuIHhjW2ldID4geWNbaV0gXiBpc25lZyA/IDEgOiAtMTtcclxuICB9XHJcblxyXG4gIC8vIENvbXBhcmUgbGVuZ3Rocy5cclxuICByZXR1cm4gayA9PSBsID8gMCA6IGsgPiBsIF4gaXNuZWcgPyAxIDogLTE7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgbmV3IEJpZyB3aG9zZSB2YWx1ZSBpcyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgZGl2aWRlZCBieSB0aGUgdmFsdWUgb2YgQmlnIHksIHJvdW5kZWQsXHJcbiAqIGlmIG5lY2Vzc2FyeSwgdG8gYSBtYXhpbXVtIG9mIEJpZy5EUCBkZWNpbWFsIHBsYWNlcyB1c2luZyByb3VuZGluZyBtb2RlIEJpZy5STS5cclxuICovXHJcblAuZGl2ID0gZnVuY3Rpb24gKHkpIHtcclxuICB2YXIgeCA9IHRoaXMsXHJcbiAgICBCaWcgPSB4LmNvbnN0cnVjdG9yLFxyXG4gICAgYSA9IHguYywgICAgICAgICAgICAgICAgICAvLyBkaXZpZGVuZFxyXG4gICAgYiA9ICh5ID0gbmV3IEJpZyh5KSkuYywgICAvLyBkaXZpc29yXHJcbiAgICBrID0geC5zID09IHkucyA/IDEgOiAtMSxcclxuICAgIGRwID0gQmlnLkRQO1xyXG5cclxuICBpZiAoZHAgIT09IH5+ZHAgfHwgZHAgPCAwIHx8IGRwID4gTUFYX0RQKSB0aHJvdyBFcnJvcihJTlZBTElEX0RQKTtcclxuXHJcbiAgLy8gRGl2aXNvciBpcyB6ZXJvP1xyXG4gIGlmICghYlswXSkgdGhyb3cgRXJyb3IoRElWX0JZX1pFUk8pO1xyXG5cclxuICAvLyBEaXZpZGVuZCBpcyAwPyBSZXR1cm4gKy0wLlxyXG4gIGlmICghYVswXSkgcmV0dXJuIG5ldyBCaWcoayAqIDApO1xyXG5cclxuICB2YXIgYmwsIGJ0LCBuLCBjbXAsIHJpLFxyXG4gICAgYnogPSBiLnNsaWNlKCksXHJcbiAgICBhaSA9IGJsID0gYi5sZW5ndGgsXHJcbiAgICBhbCA9IGEubGVuZ3RoLFxyXG4gICAgciA9IGEuc2xpY2UoMCwgYmwpLCAgIC8vIHJlbWFpbmRlclxyXG4gICAgcmwgPSByLmxlbmd0aCxcclxuICAgIHEgPSB5LCAgICAgICAgICAgICAgICAvLyBxdW90aWVudFxyXG4gICAgcWMgPSBxLmMgPSBbXSxcclxuICAgIHFpID0gMCxcclxuICAgIGQgPSBkcCArIChxLmUgPSB4LmUgLSB5LmUpICsgMTsgICAgLy8gbnVtYmVyIG9mIGRpZ2l0cyBvZiB0aGUgcmVzdWx0XHJcblxyXG4gIHEucyA9IGs7XHJcbiAgayA9IGQgPCAwID8gMCA6IGQ7XHJcblxyXG4gIC8vIENyZWF0ZSB2ZXJzaW9uIG9mIGRpdmlzb3Igd2l0aCBsZWFkaW5nIHplcm8uXHJcbiAgYnoudW5zaGlmdCgwKTtcclxuXHJcbiAgLy8gQWRkIHplcm9zIHRvIG1ha2UgcmVtYWluZGVyIGFzIGxvbmcgYXMgZGl2aXNvci5cclxuICBmb3IgKDsgcmwrKyA8IGJsOykgci5wdXNoKDApO1xyXG5cclxuICBkbyB7XHJcblxyXG4gICAgLy8gbiBpcyBob3cgbWFueSB0aW1lcyB0aGUgZGl2aXNvciBnb2VzIGludG8gY3VycmVudCByZW1haW5kZXIuXHJcbiAgICBmb3IgKG4gPSAwOyBuIDwgMTA7IG4rKykge1xyXG5cclxuICAgICAgLy8gQ29tcGFyZSBkaXZpc29yIGFuZCByZW1haW5kZXIuXHJcbiAgICAgIGlmIChibCAhPSAocmwgPSByLmxlbmd0aCkpIHtcclxuICAgICAgICBjbXAgPSBibCA+IHJsID8gMSA6IC0xO1xyXG4gICAgICB9IGVsc2Uge1xyXG4gICAgICAgIGZvciAocmkgPSAtMSwgY21wID0gMDsgKytyaSA8IGJsOykge1xyXG4gICAgICAgICAgaWYgKGJbcmldICE9IHJbcmldKSB7XHJcbiAgICAgICAgICAgIGNtcCA9IGJbcmldID4gcltyaV0gPyAxIDogLTE7XHJcbiAgICAgICAgICAgIGJyZWFrO1xyXG4gICAgICAgICAgfVxyXG4gICAgICAgIH1cclxuICAgICAgfVxyXG5cclxuICAgICAgLy8gSWYgZGl2aXNvciA8IHJlbWFpbmRlciwgc3VidHJhY3QgZGl2aXNvciBmcm9tIHJlbWFpbmRlci5cclxuICAgICAgaWYgKGNtcCA8IDApIHtcclxuXHJcbiAgICAgICAgLy8gUmVtYWluZGVyIGNhbid0IGJlIG1vcmUgdGhhbiAxIGRpZ2l0IGxvbmdlciB0aGFuIGRpdmlzb3IuXHJcbiAgICAgICAgLy8gRXF1YWxpc2UgbGVuZ3RocyB1c2luZyBkaXZpc29yIHdpdGggZXh0cmEgbGVhZGluZyB6ZXJvP1xyXG4gICAgICAgIGZvciAoYnQgPSBybCA9PSBibCA/IGIgOiBiejsgcmw7KSB7XHJcbiAgICAgICAgICBpZiAoclstLXJsXSA8IGJ0W3JsXSkge1xyXG4gICAgICAgICAgICByaSA9IHJsO1xyXG4gICAgICAgICAgICBmb3IgKDsgcmkgJiYgIXJbLS1yaV07KSByW3JpXSA9IDk7XHJcbiAgICAgICAgICAgIC0tcltyaV07XHJcbiAgICAgICAgICAgIHJbcmxdICs9IDEwO1xyXG4gICAgICAgICAgfVxyXG4gICAgICAgICAgcltybF0gLT0gYnRbcmxdO1xyXG4gICAgICAgIH1cclxuXHJcbiAgICAgICAgZm9yICg7ICFyWzBdOykgci5zaGlmdCgpO1xyXG4gICAgICB9IGVsc2Uge1xyXG4gICAgICAgIGJyZWFrO1xyXG4gICAgICB9XHJcbiAgICB9XHJcblxyXG4gICAgLy8gQWRkIHRoZSBkaWdpdCBuIHRvIHRoZSByZXN1bHQgYXJyYXkuXHJcbiAgICBxY1txaSsrXSA9IGNtcCA/IG4gOiArK247XHJcblxyXG4gICAgLy8gVXBkYXRlIHRoZSByZW1haW5kZXIuXHJcbiAgICBpZiAoclswXSAmJiBjbXApIHJbcmxdID0gYVthaV0gfHwgMDtcclxuICAgIGVsc2UgciA9IFthW2FpXV07XHJcblxyXG4gIH0gd2hpbGUgKChhaSsrIDwgYWwgfHwgclswXSAhPT0gVU5ERUZJTkVEKSAmJiBrLS0pO1xyXG5cclxuICAvLyBMZWFkaW5nIHplcm8/IERvIG5vdCByZW1vdmUgaWYgcmVzdWx0IGlzIHNpbXBseSB6ZXJvIChxaSA9PSAxKS5cclxuICBpZiAoIXFjWzBdICYmIHFpICE9IDEpIHtcclxuXHJcbiAgICAvLyBUaGVyZSBjYW4ndCBiZSBtb3JlIHRoYW4gb25lIHplcm8uXHJcbiAgICBxYy5zaGlmdCgpO1xyXG4gICAgcS5lLS07XHJcbiAgfVxyXG5cclxuICAvLyBSb3VuZD9cclxuICBpZiAocWkgPiBkKSByb3VuZChxLCBkcCwgQmlnLlJNLCByWzBdICE9PSBVTkRFRklORUQpO1xyXG5cclxuICByZXR1cm4gcTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gdHJ1ZSBpZiB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgaXMgZXF1YWwgdG8gdGhlIHZhbHVlIG9mIEJpZyB5LCBvdGhlcndpc2UgcmV0dXJuIGZhbHNlLlxyXG4gKi9cclxuUC5lcSA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgcmV0dXJuICF0aGlzLmNtcCh5KTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gdHJ1ZSBpZiB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgaXMgZ3JlYXRlciB0aGFuIHRoZSB2YWx1ZSBvZiBCaWcgeSwgb3RoZXJ3aXNlIHJldHVyblxyXG4gKiBmYWxzZS5cclxuICovXHJcblAuZ3QgPSBmdW5jdGlvbiAoeSkge1xyXG4gIHJldHVybiB0aGlzLmNtcCh5KSA+IDA7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIHRydWUgaWYgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIGlzIGdyZWF0ZXIgdGhhbiBvciBlcXVhbCB0byB0aGUgdmFsdWUgb2YgQmlnIHksIG90aGVyd2lzZVxyXG4gKiByZXR1cm4gZmFsc2UuXHJcbiAqL1xyXG5QLmd0ZSA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgcmV0dXJuIHRoaXMuY21wKHkpID4gLTE7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIHRydWUgaWYgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIGlzIGxlc3MgdGhhbiB0aGUgdmFsdWUgb2YgQmlnIHksIG90aGVyd2lzZSByZXR1cm4gZmFsc2UuXHJcbiAqL1xyXG5QLmx0ID0gZnVuY3Rpb24gKHkpIHtcclxuICByZXR1cm4gdGhpcy5jbXAoeSkgPCAwO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiB0cnVlIGlmIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBpcyBsZXNzIHRoYW4gb3IgZXF1YWwgdG8gdGhlIHZhbHVlIG9mIEJpZyB5LCBvdGhlcndpc2VcclxuICogcmV0dXJuIGZhbHNlLlxyXG4gKi9cclxuUC5sdGUgPSBmdW5jdGlvbiAoeSkge1xyXG4gIHJldHVybiB0aGlzLmNtcCh5KSA8IDE7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgbmV3IEJpZyB3aG9zZSB2YWx1ZSBpcyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgbWludXMgdGhlIHZhbHVlIG9mIEJpZyB5LlxyXG4gKi9cclxuUC5taW51cyA9IFAuc3ViID0gZnVuY3Rpb24gKHkpIHtcclxuICB2YXIgaSwgaiwgdCwgeGx0eSxcclxuICAgIHggPSB0aGlzLFxyXG4gICAgQmlnID0geC5jb25zdHJ1Y3RvcixcclxuICAgIGEgPSB4LnMsXHJcbiAgICBiID0gKHkgPSBuZXcgQmlnKHkpKS5zO1xyXG5cclxuICAvLyBTaWducyBkaWZmZXI/XHJcbiAgaWYgKGEgIT0gYikge1xyXG4gICAgeS5zID0gLWI7XHJcbiAgICByZXR1cm4geC5wbHVzKHkpO1xyXG4gIH1cclxuXHJcbiAgdmFyIHhjID0geC5jLnNsaWNlKCksXHJcbiAgICB4ZSA9IHguZSxcclxuICAgIHljID0geS5jLFxyXG4gICAgeWUgPSB5LmU7XHJcblxyXG4gIC8vIEVpdGhlciB6ZXJvP1xyXG4gIGlmICgheGNbMF0gfHwgIXljWzBdKSB7XHJcblxyXG4gICAgLy8geSBpcyBub24temVybz8geCBpcyBub24temVybz8gT3IgYm90aCBhcmUgemVyby5cclxuICAgIHJldHVybiB5Y1swXSA/ICh5LnMgPSAtYiwgeSkgOiBuZXcgQmlnKHhjWzBdID8geCA6IDApO1xyXG4gIH1cclxuXHJcbiAgLy8gRGV0ZXJtaW5lIHdoaWNoIGlzIHRoZSBiaWdnZXIgbnVtYmVyLiBQcmVwZW5kIHplcm9zIHRvIGVxdWFsaXNlIGV4cG9uZW50cy5cclxuICBpZiAoYSA9IHhlIC0geWUpIHtcclxuXHJcbiAgICBpZiAoeGx0eSA9IGEgPCAwKSB7XHJcbiAgICAgIGEgPSAtYTtcclxuICAgICAgdCA9IHhjO1xyXG4gICAgfSBlbHNlIHtcclxuICAgICAgeWUgPSB4ZTtcclxuICAgICAgdCA9IHljO1xyXG4gICAgfVxyXG5cclxuICAgIHQucmV2ZXJzZSgpO1xyXG4gICAgZm9yIChiID0gYTsgYi0tOykgdC5wdXNoKDApO1xyXG4gICAgdC5yZXZlcnNlKCk7XHJcbiAgfSBlbHNlIHtcclxuXHJcbiAgICAvLyBFeHBvbmVudHMgZXF1YWwuIENoZWNrIGRpZ2l0IGJ5IGRpZ2l0LlxyXG4gICAgaiA9ICgoeGx0eSA9IHhjLmxlbmd0aCA8IHljLmxlbmd0aCkgPyB4YyA6IHljKS5sZW5ndGg7XHJcblxyXG4gICAgZm9yIChhID0gYiA9IDA7IGIgPCBqOyBiKyspIHtcclxuICAgICAgaWYgKHhjW2JdICE9IHljW2JdKSB7XHJcbiAgICAgICAgeGx0eSA9IHhjW2JdIDwgeWNbYl07XHJcbiAgICAgICAgYnJlYWs7XHJcbiAgICAgIH1cclxuICAgIH1cclxuICB9XHJcblxyXG4gIC8vIHggPCB5PyBQb2ludCB4YyB0byB0aGUgYXJyYXkgb2YgdGhlIGJpZ2dlciBudW1iZXIuXHJcbiAgaWYgKHhsdHkpIHtcclxuICAgIHQgPSB4YztcclxuICAgIHhjID0geWM7XHJcbiAgICB5YyA9IHQ7XHJcbiAgICB5LnMgPSAteS5zO1xyXG4gIH1cclxuXHJcbiAgLypcclxuICAgKiBBcHBlbmQgemVyb3MgdG8geGMgaWYgc2hvcnRlci4gTm8gbmVlZCB0byBhZGQgemVyb3MgdG8geWMgaWYgc2hvcnRlciBhcyBzdWJ0cmFjdGlvbiBvbmx5XHJcbiAgICogbmVlZHMgdG8gc3RhcnQgYXQgeWMubGVuZ3RoLlxyXG4gICAqL1xyXG4gIGlmICgoYiA9IChqID0geWMubGVuZ3RoKSAtIChpID0geGMubGVuZ3RoKSkgPiAwKSBmb3IgKDsgYi0tOykgeGNbaSsrXSA9IDA7XHJcblxyXG4gIC8vIFN1YnRyYWN0IHljIGZyb20geGMuXHJcbiAgZm9yIChiID0gaTsgaiA+IGE7KSB7XHJcbiAgICBpZiAoeGNbLS1qXSA8IHljW2pdKSB7XHJcbiAgICAgIGZvciAoaSA9IGo7IGkgJiYgIXhjWy0taV07KSB4Y1tpXSA9IDk7XHJcbiAgICAgIC0teGNbaV07XHJcbiAgICAgIHhjW2pdICs9IDEwO1xyXG4gICAgfVxyXG5cclxuICAgIHhjW2pdIC09IHljW2pdO1xyXG4gIH1cclxuXHJcbiAgLy8gUmVtb3ZlIHRyYWlsaW5nIHplcm9zLlxyXG4gIGZvciAoOyB4Y1stLWJdID09PSAwOykgeGMucG9wKCk7XHJcblxyXG4gIC8vIFJlbW92ZSBsZWFkaW5nIHplcm9zIGFuZCBhZGp1c3QgZXhwb25lbnQgYWNjb3JkaW5nbHkuXHJcbiAgZm9yICg7IHhjWzBdID09PSAwOykge1xyXG4gICAgeGMuc2hpZnQoKTtcclxuICAgIC0teWU7XHJcbiAgfVxyXG5cclxuICBpZiAoIXhjWzBdKSB7XHJcblxyXG4gICAgLy8gbiAtIG4gPSArMFxyXG4gICAgeS5zID0gMTtcclxuXHJcbiAgICAvLyBSZXN1bHQgbXVzdCBiZSB6ZXJvLlxyXG4gICAgeGMgPSBbeWUgPSAwXTtcclxuICB9XHJcblxyXG4gIHkuYyA9IHhjO1xyXG4gIHkuZSA9IHllO1xyXG5cclxuICByZXR1cm4geTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBuZXcgQmlnIHdob3NlIHZhbHVlIGlzIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBtb2R1bG8gdGhlIHZhbHVlIG9mIEJpZyB5LlxyXG4gKi9cclxuUC5tb2QgPSBmdW5jdGlvbiAoeSkge1xyXG4gIHZhciB5Z3R4LFxyXG4gICAgeCA9IHRoaXMsXHJcbiAgICBCaWcgPSB4LmNvbnN0cnVjdG9yLFxyXG4gICAgYSA9IHgucyxcclxuICAgIGIgPSAoeSA9IG5ldyBCaWcoeSkpLnM7XHJcblxyXG4gIGlmICgheS5jWzBdKSB0aHJvdyBFcnJvcihESVZfQllfWkVSTyk7XHJcblxyXG4gIHgucyA9IHkucyA9IDE7XHJcbiAgeWd0eCA9IHkuY21wKHgpID09IDE7XHJcbiAgeC5zID0gYTtcclxuICB5LnMgPSBiO1xyXG5cclxuICBpZiAoeWd0eCkgcmV0dXJuIG5ldyBCaWcoeCk7XHJcblxyXG4gIGEgPSBCaWcuRFA7XHJcbiAgYiA9IEJpZy5STTtcclxuICBCaWcuRFAgPSBCaWcuUk0gPSAwO1xyXG4gIHggPSB4LmRpdih5KTtcclxuICBCaWcuRFAgPSBhO1xyXG4gIEJpZy5STSA9IGI7XHJcblxyXG4gIHJldHVybiB0aGlzLm1pbnVzKHgudGltZXMoeSkpO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIG5ldyBCaWcgd2hvc2UgdmFsdWUgaXMgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIHBsdXMgdGhlIHZhbHVlIG9mIEJpZyB5LlxyXG4gKi9cclxuUC5wbHVzID0gUC5hZGQgPSBmdW5jdGlvbiAoeSkge1xyXG4gIHZhciB0LFxyXG4gICAgeCA9IHRoaXMsXHJcbiAgICBCaWcgPSB4LmNvbnN0cnVjdG9yLFxyXG4gICAgYSA9IHgucyxcclxuICAgIGIgPSAoeSA9IG5ldyBCaWcoeSkpLnM7XHJcblxyXG4gIC8vIFNpZ25zIGRpZmZlcj9cclxuICBpZiAoYSAhPSBiKSB7XHJcbiAgICB5LnMgPSAtYjtcclxuICAgIHJldHVybiB4Lm1pbnVzKHkpO1xyXG4gIH1cclxuXHJcbiAgdmFyIHhlID0geC5lLFxyXG4gICAgeGMgPSB4LmMsXHJcbiAgICB5ZSA9IHkuZSxcclxuICAgIHljID0geS5jO1xyXG5cclxuICAvLyBFaXRoZXIgemVybz8geSBpcyBub24temVybz8geCBpcyBub24temVybz8gT3IgYm90aCBhcmUgemVyby5cclxuICBpZiAoIXhjWzBdIHx8ICF5Y1swXSkgcmV0dXJuIHljWzBdID8geSA6IG5ldyBCaWcoeGNbMF0gPyB4IDogYSAqIDApO1xyXG5cclxuICB4YyA9IHhjLnNsaWNlKCk7XHJcblxyXG4gIC8vIFByZXBlbmQgemVyb3MgdG8gZXF1YWxpc2UgZXhwb25lbnRzLlxyXG4gIC8vIE5vdGU6IHJldmVyc2UgZmFzdGVyIHRoYW4gdW5zaGlmdHMuXHJcbiAgaWYgKGEgPSB4ZSAtIHllKSB7XHJcbiAgICBpZiAoYSA+IDApIHtcclxuICAgICAgeWUgPSB4ZTtcclxuICAgICAgdCA9IHljO1xyXG4gICAgfSBlbHNlIHtcclxuICAgICAgYSA9IC1hO1xyXG4gICAgICB0ID0geGM7XHJcbiAgICB9XHJcblxyXG4gICAgdC5yZXZlcnNlKCk7XHJcbiAgICBmb3IgKDsgYS0tOykgdC5wdXNoKDApO1xyXG4gICAgdC5yZXZlcnNlKCk7XHJcbiAgfVxyXG5cclxuICAvLyBQb2ludCB4YyB0byB0aGUgbG9uZ2VyIGFycmF5LlxyXG4gIGlmICh4Yy5sZW5ndGggLSB5Yy5sZW5ndGggPCAwKSB7XHJcbiAgICB0ID0geWM7XHJcbiAgICB5YyA9IHhjO1xyXG4gICAgeGMgPSB0O1xyXG4gIH1cclxuXHJcbiAgYSA9IHljLmxlbmd0aDtcclxuXHJcbiAgLy8gT25seSBzdGFydCBhZGRpbmcgYXQgeWMubGVuZ3RoIC0gMSBhcyB0aGUgZnVydGhlciBkaWdpdHMgb2YgeGMgY2FuIGJlIGxlZnQgYXMgdGhleSBhcmUuXHJcbiAgZm9yIChiID0gMDsgYTsgeGNbYV0gJT0gMTApIGIgPSAoeGNbLS1hXSA9IHhjW2FdICsgeWNbYV0gKyBiKSAvIDEwIHwgMDtcclxuXHJcbiAgLy8gTm8gbmVlZCB0byBjaGVjayBmb3IgemVybywgYXMgK3ggKyAreSAhPSAwICYmIC14ICsgLXkgIT0gMFxyXG5cclxuICBpZiAoYikge1xyXG4gICAgeGMudW5zaGlmdChiKTtcclxuICAgICsreWU7XHJcbiAgfVxyXG5cclxuICAvLyBSZW1vdmUgdHJhaWxpbmcgemVyb3MuXHJcbiAgZm9yIChhID0geGMubGVuZ3RoOyB4Y1stLWFdID09PSAwOykgeGMucG9wKCk7XHJcblxyXG4gIHkuYyA9IHhjO1xyXG4gIHkuZSA9IHllO1xyXG5cclxuICByZXR1cm4geTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBCaWcgd2hvc2UgdmFsdWUgaXMgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIHJhaXNlZCB0byB0aGUgcG93ZXIgbi5cclxuICogSWYgbiBpcyBuZWdhdGl2ZSwgcm91bmQgdG8gYSBtYXhpbXVtIG9mIEJpZy5EUCBkZWNpbWFsIHBsYWNlcyB1c2luZyByb3VuZGluZ1xyXG4gKiBtb2RlIEJpZy5STS5cclxuICpcclxuICogbiB7bnVtYmVyfSBJbnRlZ2VyLCAtTUFYX1BPV0VSIHRvIE1BWF9QT1dFUiBpbmNsdXNpdmUuXHJcbiAqL1xyXG5QLnBvdyA9IGZ1bmN0aW9uIChuKSB7XHJcbiAgdmFyIHggPSB0aGlzLFxyXG4gICAgb25lID0gbmV3IHguY29uc3RydWN0b3IoMSksXHJcbiAgICB5ID0gb25lLFxyXG4gICAgaXNuZWcgPSBuIDwgMDtcclxuXHJcbiAgaWYgKG4gIT09IH5+biB8fCBuIDwgLU1BWF9QT1dFUiB8fCBuID4gTUFYX1BPV0VSKSB0aHJvdyBFcnJvcihJTlZBTElEICsgJ2V4cG9uZW50Jyk7XHJcbiAgaWYgKGlzbmVnKSBuID0gLW47XHJcblxyXG4gIGZvciAoOzspIHtcclxuICAgIGlmIChuICYgMSkgeSA9IHkudGltZXMoeCk7XHJcbiAgICBuID4+PSAxO1xyXG4gICAgaWYgKCFuKSBicmVhaztcclxuICAgIHggPSB4LnRpbWVzKHgpO1xyXG4gIH1cclxuXHJcbiAgcmV0dXJuIGlzbmVnID8gb25lLmRpdih5KSA6IHk7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgbmV3IEJpZyB3aG9zZSB2YWx1ZSBpcyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgcm91bmRlZCB1c2luZyByb3VuZGluZyBtb2RlIHJtXHJcbiAqIHRvIGEgbWF4aW11bSBvZiBkcCBkZWNpbWFsIHBsYWNlcywgb3IsIGlmIGRwIGlzIG5lZ2F0aXZlLCB0byBhbiBpbnRlZ2VyIHdoaWNoIGlzIGFcclxuICogbXVsdGlwbGUgb2YgMTAqKi1kcC5cclxuICogSWYgZHAgaXMgbm90IHNwZWNpZmllZCwgcm91bmQgdG8gMCBkZWNpbWFsIHBsYWNlcy5cclxuICogSWYgcm0gaXMgbm90IHNwZWNpZmllZCwgdXNlIEJpZy5STS5cclxuICpcclxuICogZHA/IHtudW1iZXJ9IEludGVnZXIsIC1NQVhfRFAgdG8gTUFYX0RQIGluY2x1c2l2ZS5cclxuICogcm0/IDAsIDEsIDIgb3IgMyAoUk9VTkRfRE9XTiwgUk9VTkRfSEFMRl9VUCwgUk9VTkRfSEFMRl9FVkVOLCBST1VORF9VUClcclxuICovXHJcblAucm91bmQgPSBmdW5jdGlvbiAoZHAsIHJtKSB7XHJcbiAgdmFyIEJpZyA9IHRoaXMuY29uc3RydWN0b3I7XHJcbiAgaWYgKGRwID09PSBVTkRFRklORUQpIGRwID0gMDtcclxuICBlbHNlIGlmIChkcCAhPT0gfn5kcCB8fCBkcCA8IC1NQVhfRFAgfHwgZHAgPiBNQVhfRFApIHRocm93IEVycm9yKElOVkFMSURfRFApO1xyXG4gIHJldHVybiByb3VuZChuZXcgQmlnKHRoaXMpLCBkcCwgcm0gPT09IFVOREVGSU5FRCA/IEJpZy5STSA6IHJtKTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBuZXcgQmlnIHdob3NlIHZhbHVlIGlzIHRoZSBzcXVhcmUgcm9vdCBvZiB0aGUgdmFsdWUgb2YgdGhpcyBCaWcsIHJvdW5kZWQsIGlmXHJcbiAqIG5lY2Vzc2FyeSwgdG8gYSBtYXhpbXVtIG9mIEJpZy5EUCBkZWNpbWFsIHBsYWNlcyB1c2luZyByb3VuZGluZyBtb2RlIEJpZy5STS5cclxuICovXHJcblAuc3FydCA9IGZ1bmN0aW9uICgpIHtcclxuICB2YXIgciwgYywgdCxcclxuICAgIHggPSB0aGlzLFxyXG4gICAgQmlnID0geC5jb25zdHJ1Y3RvcixcclxuICAgIHMgPSB4LnMsXHJcbiAgICBlID0geC5lLFxyXG4gICAgaGFsZiA9IG5ldyBCaWcoMC41KTtcclxuXHJcbiAgLy8gWmVybz9cclxuICBpZiAoIXguY1swXSkgcmV0dXJuIG5ldyBCaWcoeCk7XHJcblxyXG4gIC8vIE5lZ2F0aXZlP1xyXG4gIGlmIChzIDwgMCkgdGhyb3cgRXJyb3IoTkFNRSArICdObyBzcXVhcmUgcm9vdCcpO1xyXG5cclxuICAvLyBFc3RpbWF0ZS5cclxuICBzID0gTWF0aC5zcXJ0KHggKyAnJyk7XHJcblxyXG4gIC8vIE1hdGguc3FydCB1bmRlcmZsb3cvb3ZlcmZsb3c/XHJcbiAgLy8gUmUtZXN0aW1hdGU6IHBhc3MgeCBjb2VmZmljaWVudCB0byBNYXRoLnNxcnQgYXMgaW50ZWdlciwgdGhlbiBhZGp1c3QgdGhlIHJlc3VsdCBleHBvbmVudC5cclxuICBpZiAocyA9PT0gMCB8fCBzID09PSAxIC8gMCkge1xyXG4gICAgYyA9IHguYy5qb2luKCcnKTtcclxuICAgIGlmICghKGMubGVuZ3RoICsgZSAmIDEpKSBjICs9ICcwJztcclxuICAgIHMgPSBNYXRoLnNxcnQoYyk7XHJcbiAgICBlID0gKChlICsgMSkgLyAyIHwgMCkgLSAoZSA8IDAgfHwgZSAmIDEpO1xyXG4gICAgciA9IG5ldyBCaWcoKHMgPT0gMSAvIDAgPyAnMWUnIDogKHMgPSBzLnRvRXhwb25lbnRpYWwoKSkuc2xpY2UoMCwgcy5pbmRleE9mKCdlJykgKyAxKSkgKyBlKTtcclxuICB9IGVsc2Uge1xyXG4gICAgciA9IG5ldyBCaWcocyk7XHJcbiAgfVxyXG5cclxuICBlID0gci5lICsgKEJpZy5EUCArPSA0KTtcclxuXHJcbiAgLy8gTmV3dG9uLVJhcGhzb24gaXRlcmF0aW9uLlxyXG4gIGRvIHtcclxuICAgIHQgPSByO1xyXG4gICAgciA9IGhhbGYudGltZXModC5wbHVzKHguZGl2KHQpKSk7XHJcbiAgfSB3aGlsZSAodC5jLnNsaWNlKDAsIGUpLmpvaW4oJycpICE9PSByLmMuc2xpY2UoMCwgZSkuam9pbignJykpO1xyXG5cclxuICByZXR1cm4gcm91bmQociwgQmlnLkRQIC09IDQsIEJpZy5STSk7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgbmV3IEJpZyB3aG9zZSB2YWx1ZSBpcyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgdGltZXMgdGhlIHZhbHVlIG9mIEJpZyB5LlxyXG4gKi9cclxuUC50aW1lcyA9IFAubXVsID0gZnVuY3Rpb24gKHkpIHtcclxuICB2YXIgYyxcclxuICAgIHggPSB0aGlzLFxyXG4gICAgQmlnID0geC5jb25zdHJ1Y3RvcixcclxuICAgIHhjID0geC5jLFxyXG4gICAgeWMgPSAoeSA9IG5ldyBCaWcoeSkpLmMsXHJcbiAgICBhID0geGMubGVuZ3RoLFxyXG4gICAgYiA9IHljLmxlbmd0aCxcclxuICAgIGkgPSB4LmUsXHJcbiAgICBqID0geS5lO1xyXG5cclxuICAvLyBEZXRlcm1pbmUgc2lnbiBvZiByZXN1bHQuXHJcbiAgeS5zID0geC5zID09IHkucyA/IDEgOiAtMTtcclxuXHJcbiAgLy8gUmV0dXJuIHNpZ25lZCAwIGlmIGVpdGhlciAwLlxyXG4gIGlmICgheGNbMF0gfHwgIXljWzBdKSByZXR1cm4gbmV3IEJpZyh5LnMgKiAwKTtcclxuXHJcbiAgLy8gSW5pdGlhbGlzZSBleHBvbmVudCBvZiByZXN1bHQgYXMgeC5lICsgeS5lLlxyXG4gIHkuZSA9IGkgKyBqO1xyXG5cclxuICAvLyBJZiBhcnJheSB4YyBoYXMgZmV3ZXIgZGlnaXRzIHRoYW4geWMsIHN3YXAgeGMgYW5kIHljLCBhbmQgbGVuZ3Rocy5cclxuICBpZiAoYSA8IGIpIHtcclxuICAgIGMgPSB4YztcclxuICAgIHhjID0geWM7XHJcbiAgICB5YyA9IGM7XHJcbiAgICBqID0gYTtcclxuICAgIGEgPSBiO1xyXG4gICAgYiA9IGo7XHJcbiAgfVxyXG5cclxuICAvLyBJbml0aWFsaXNlIGNvZWZmaWNpZW50IGFycmF5IG9mIHJlc3VsdCB3aXRoIHplcm9zLlxyXG4gIGZvciAoYyA9IG5ldyBBcnJheShqID0gYSArIGIpOyBqLS07KSBjW2pdID0gMDtcclxuXHJcbiAgLy8gTXVsdGlwbHkuXHJcblxyXG4gIC8vIGkgaXMgaW5pdGlhbGx5IHhjLmxlbmd0aC5cclxuICBmb3IgKGkgPSBiOyBpLS07KSB7XHJcbiAgICBiID0gMDtcclxuXHJcbiAgICAvLyBhIGlzIHljLmxlbmd0aC5cclxuICAgIGZvciAoaiA9IGEgKyBpOyBqID4gaTspIHtcclxuXHJcbiAgICAgIC8vIEN1cnJlbnQgc3VtIG9mIHByb2R1Y3RzIGF0IHRoaXMgZGlnaXQgcG9zaXRpb24sIHBsdXMgY2FycnkuXHJcbiAgICAgIGIgPSBjW2pdICsgeWNbaV0gKiB4Y1tqIC0gaSAtIDFdICsgYjtcclxuICAgICAgY1tqLS1dID0gYiAlIDEwO1xyXG5cclxuICAgICAgLy8gY2FycnlcclxuICAgICAgYiA9IGIgLyAxMCB8IDA7XHJcbiAgICB9XHJcblxyXG4gICAgY1tqXSA9IChjW2pdICsgYikgJSAxMDtcclxuICB9XHJcblxyXG4gIC8vIEluY3JlbWVudCByZXN1bHQgZXhwb25lbnQgaWYgdGhlcmUgaXMgYSBmaW5hbCBjYXJyeSwgb3RoZXJ3aXNlIHJlbW92ZSBsZWFkaW5nIHplcm8uXHJcbiAgaWYgKGIpICsreS5lO1xyXG4gIGVsc2UgYy5zaGlmdCgpO1xyXG5cclxuICAvLyBSZW1vdmUgdHJhaWxpbmcgemVyb3MuXHJcbiAgZm9yIChpID0gYy5sZW5ndGg7ICFjWy0taV07KSBjLnBvcCgpO1xyXG4gIHkuYyA9IGM7XHJcblxyXG4gIHJldHVybiB5O1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIHN0cmluZyByZXByZXNlbnRpbmcgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIGluIGV4cG9uZW50aWFsIG5vdGF0aW9uIHRvIGRwIGZpeGVkIGRlY2ltYWxcclxuICogcGxhY2VzIGFuZCByb3VuZGVkIHVzaW5nIEJpZy5STS5cclxuICpcclxuICogZHA/IHtudW1iZXJ9IEludGVnZXIsIDAgdG8gTUFYX0RQIGluY2x1c2l2ZS5cclxuICovXHJcblAudG9FeHBvbmVudGlhbCA9IGZ1bmN0aW9uIChkcCkge1xyXG4gIHJldHVybiBzdHJpbmdpZnkodGhpcywgMSwgZHAsIGRwKTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBzdHJpbmcgcmVwcmVzZW50aW5nIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBpbiBub3JtYWwgbm90YXRpb24gdG8gZHAgZml4ZWQgZGVjaW1hbFxyXG4gKiBwbGFjZXMgYW5kIHJvdW5kZWQgdXNpbmcgQmlnLlJNLlxyXG4gKlxyXG4gKiBkcD8ge251bWJlcn0gSW50ZWdlciwgMCB0byBNQVhfRFAgaW5jbHVzaXZlLlxyXG4gKlxyXG4gKiAoLTApLnRvRml4ZWQoMCkgaXMgJzAnLCBidXQgKC0wLjEpLnRvRml4ZWQoMCkgaXMgJy0wJy5cclxuICogKC0wKS50b0ZpeGVkKDEpIGlzICcwLjAnLCBidXQgKC0wLjAxKS50b0ZpeGVkKDEpIGlzICctMC4wJy5cclxuICovXHJcblAudG9GaXhlZCA9IGZ1bmN0aW9uIChkcCkge1xyXG4gIHJldHVybiBzdHJpbmdpZnkodGhpcywgMiwgZHAsIHRoaXMuZSArIGRwKTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBzdHJpbmcgcmVwcmVzZW50aW5nIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyByb3VuZGVkIHRvIHNkIHNpZ25pZmljYW50IGRpZ2l0cyB1c2luZ1xyXG4gKiBCaWcuUk0uIFVzZSBleHBvbmVudGlhbCBub3RhdGlvbiBpZiBzZCBpcyBsZXNzIHRoYW4gdGhlIG51bWJlciBvZiBkaWdpdHMgbmVjZXNzYXJ5IHRvIHJlcHJlc2VudFxyXG4gKiB0aGUgaW50ZWdlciBwYXJ0IG9mIHRoZSB2YWx1ZSBpbiBub3JtYWwgbm90YXRpb24uXHJcbiAqXHJcbiAqIHNkIHtudW1iZXJ9IEludGVnZXIsIDEgdG8gTUFYX0RQIGluY2x1c2l2ZS5cclxuICovXHJcblAudG9QcmVjaXNpb24gPSBmdW5jdGlvbiAoc2QpIHtcclxuICByZXR1cm4gc3RyaW5naWZ5KHRoaXMsIDMsIHNkLCBzZCAtIDEpO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIHN0cmluZyByZXByZXNlbnRpbmcgdGhlIHZhbHVlIG9mIHRoaXMgQmlnLlxyXG4gKiBSZXR1cm4gZXhwb25lbnRpYWwgbm90YXRpb24gaWYgdGhpcyBCaWcgaGFzIGEgcG9zaXRpdmUgZXhwb25lbnQgZXF1YWwgdG8gb3IgZ3JlYXRlciB0aGFuXHJcbiAqIEJpZy5QRSwgb3IgYSBuZWdhdGl2ZSBleHBvbmVudCBlcXVhbCB0byBvciBsZXNzIHRoYW4gQmlnLk5FLlxyXG4gKiBPbWl0IHRoZSBzaWduIGZvciBuZWdhdGl2ZSB6ZXJvLlxyXG4gKi9cclxuUC50b1N0cmluZyA9IGZ1bmN0aW9uICgpIHtcclxuICByZXR1cm4gc3RyaW5naWZ5KHRoaXMpO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIHN0cmluZyByZXByZXNlbnRpbmcgdGhlIHZhbHVlIG9mIHRoaXMgQmlnLlxyXG4gKiBSZXR1cm4gZXhwb25lbnRpYWwgbm90YXRpb24gaWYgdGhpcyBCaWcgaGFzIGEgcG9zaXRpdmUgZXhwb25lbnQgZXF1YWwgdG8gb3IgZ3JlYXRlciB0aGFuXHJcbiAqIEJpZy5QRSwgb3IgYSBuZWdhdGl2ZSBleHBvbmVudCBlcXVhbCB0byBvciBsZXNzIHRoYW4gQmlnLk5FLlxyXG4gKiBJbmNsdWRlIHRoZSBzaWduIGZvciBuZWdhdGl2ZSB6ZXJvLlxyXG4gKi9cclxuUC52YWx1ZU9mID0gUC50b0pTT04gPSBmdW5jdGlvbiAoKSB7XHJcbiAgcmV0dXJuIHN0cmluZ2lmeSh0aGlzLCA0KTtcclxufTtcclxuXHJcblxyXG4vLyBFeHBvcnRcclxuXHJcblxyXG5leHBvcnQgdmFyIEJpZyA9IF9CaWdfKCk7XHJcblxyXG5leHBvcnQgZGVmYXVsdCBCaWc7XHJcbiIsImltcG9ydCBCaWcgZnJvbSAnYmlnLmpzJztcblxuLyoqXG4gKiDliqDms5Xlh73mlbBcbiAqIEBwYXJhbSB7bnVtYmVyfHN0cmluZ30geCAtIOWKoOaVsFxuICogQHBhcmFtIHtudW1iZXJ8c3RyaW5nfSB5IC0g5Yqg5pWwXG4gKiBAcmV0dXJucyB7c3RyaW5nfSAtIOi/lOWbnuebuOWKoOe7k+aenFxuICovXG5mdW5jdGlvbiBhZGQoeCwgeSkge1xuICAgIHJldHVybiBuZXcgQmlnKHgpLnBsdXMoeSkudG9TdHJpbmcoKTtcbn1cblxuLyoqXG4gKiDlh4/ms5Xlh73mlbBcbiAqIEBwYXJhbSB7bnVtYmVyfHN0cmluZ30geCAtIOiiq+WHj+aVsFxuICogQHBhcmFtIHtudW1iZXJ8c3RyaW5nfSB5IC0g5YeP5pWwXG4gKiBAcmV0dXJucyB7c3RyaW5nfSAtIOi/lOWbnuebuOWHj+e7k+aenFxuICovXG5mdW5jdGlvbiBzdWJ0cmFjdCh4LCB5KSB7XG4gICAgcmV0dXJuIG5ldyBCaWcoeCkubWludXMoeSkudG9TdHJpbmcoKTtcbn1cblxuLyoqXG4gKiDkuZjms5Xlh73mlbBcbiAqIEBwYXJhbSB7bnVtYmVyfHN0cmluZ30geCAtIOS5mOaVsFxuICogQHBhcmFtIHtudW1iZXJ8c3RyaW5nfSB5IC0g5LmY5pWwXG4gKiBAcmV0dXJucyB7c3RyaW5nfSAtIOi/lOWbnuebuOS5mOe7k+aenFxuICovXG5mdW5jdGlvbiBtdWx0aXBseSh4LCB5KSB7XG4gICAgcmV0dXJuIG5ldyBCaWcoeCkudGltZXMoeSkudG9TdHJpbmcoKTtcbn1cblxuLyoqXG4gKiDpmaTms5Xlh73mlbBcbiAqIEBwYXJhbSB7bnVtYmVyfHN0cmluZ30geCAtIOiiq+mZpOaVsFxuICogQHBhcmFtIHtudW1iZXJ8c3RyaW5nfSB5IC0g6Zmk5pWwXG4gKiBAcmV0dXJucyB7c3RyaW5nfSAtIOi/lOWbnuebuOmZpOe7k+aenFxuICovXG5mdW5jdGlvbiBkaXZpZGUoeCwgeSkge1xuICAgIHJldHVybiBuZXcgQmlnKHgpLmRpdih5KS50b1N0cmluZygpO1xufVxuXG4vKipcbiAqIOagvOW8j+WMluaVsOWtl1xuICogQHBhcmFtIHtudW1iZXJ8c3RyaW5nfSB2YWx1ZSAtIOW+heagvOW8j+WMlueahOaVsOWtl1xuICogQHBhcmFtIHtudW1iZXJ9IFtwcmVjaXNpb25dIC0g57K+5bqm77yM5Y2z5bCP5pWw5L2N5pWwXG4gKiBAcmV0dXJucyB7c3RyaW5nfSAtIOagvOW8j+WMluWQjueahOWtl+espuS4slxuICovXG5mdW5jdGlvbiBmb3JtYXQodmFsdWUsIHByZWNpc2lvbikge1xuICAgIGNvbnN0IGJpZ1ZhbHVlID0gbmV3IEJpZyh2YWx1ZSk7XG4gICAgbGV0IHN0cmluZ1ZhbHVlID0gYmlnVmFsdWUudG9TdHJpbmcoKTtcbiAgICBzdHJpbmdWYWx1ZSA9IHNjaWVudGlmaWNUb051bWJlcihzdHJpbmdWYWx1ZSk7IFxuICAgIC8v5YaZ6L+Z5LmI6bq754Om77yM5piv5Zug5Li6QmlnLnJvdW5k55u45YWz5pa55rOV5LiN5aW95L2/77yM5b6X5LiN5Yiw6aKE5pyf57uT5p6c44CCXG4gICAgaWYgKHN0cmluZ1ZhbHVlLmluY2x1ZGVzKCcuJykpIHtcbiAgICAgICAgbGV0IHN0ckFycmF5ID0gc3RyaW5nVmFsdWUuc3BsaXQoJy4nKTtcbiAgICAgICAgaWYgKHN0ckFycmF5WzFdLmxlbmd0aCA+PSBwcmVjaXNpb24pIHtcbiAgICAgICAgICAgIGlmICgwID09IHByZWNpc2lvbikge1xuICAgICAgICAgICAgICAgIHJldHVybiBzdHJBcnJheVswXTtcbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIGVsc2Uge1xuICAgICAgICAgICAgICAgIC8v5oiq5patXG4gICAgICAgICAgICAgICAgbGV0IHRydW5jYXRlID0gc3RyQXJyYXlbMV0uc3Vic3RyaW5nKDAsIHByZWNpc2lvbik7XG4gICAgICAgICAgICAgICAgcmV0dXJuIGAke3N0ckFycmF5WzBdfS4ke3RydW5jYXRlfWA7XG4gICAgICAgICAgICB9XG4gICAgICAgIH1cbiAgICAgICAgZWxzZSB7XG4gICAgICAgICAgICAvL+ihpembtlxuICAgICAgICAgICAgbGV0IHplcm9OdW1iZXIgPSBwcmVjaXNpb24gLSBzdHJBcnJheVsxXS5sZW5ndGg7XG4gICAgICAgICAgICB2YXIgc3RyID0gJyc7XG4gICAgICAgICAgICBmb3IgKGxldCBpID0gMDsgaSA8IHplcm9OdW1iZXI7IGkrKykge1xuICAgICAgICAgICAgICAgIHN0ciArPSAnMCc7XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICByZXR1cm4gYCR7c3RyaW5nVmFsdWV9JHtzdHJ9YDtcbiAgICAgICAgfVxuICAgIH1cbiAgICBlbHNlIHtcbiAgICAgICAgaWYgKDAgPT0gcHJlY2lzaW9uKSB7XG4gICAgICAgICAgICByZXR1cm4gc3RyaW5nVmFsdWU7XG4gICAgICAgIH1cbiAgICAgICAgZWxzZSB7XG4gICAgICAgICAgICBsZXQgemVyb051bWJlciA9IHByZWNpc2lvbjtcbiAgICAgICAgICAgIHZhciBzdHIgPSAnJztcbiAgICAgICAgICAgIGZvciAobGV0IGkgPSAwOyBpIDwgemVyb051bWJlcjsgaSsrKSB7XG4gICAgICAgICAgICAgICAgc3RyICs9ICcwJztcbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIHJldHVybiBgJHtzdHJpbmdWYWx1ZX0uJHtzdHJ9YDtcbiAgICAgICAgfVxuICAgIH1cbn1cblxuLyoqXG4gKiDlr7nmlbDnu4TkuK3nmoTmr4/kuKrlhYPntKDov5vooYznsr7noa7ov5Dnrpflubbov5Tlm57kuIDkuKrmlrDmlbDnu4RcbiAqIEBwYXJhbSB7QXJyYXk8bnVtYmVyfHN0cmluZz59IGFyciAtIOW+hei/kOeul+aVsOe7hFxuICogQHJldHVybnMge0FycmF5PHN0cmluZz59IC0g6L+U5Zue6L+Q566X57uT5p6c5pWw57uEXG4gKi9cbmZ1bmN0aW9uIGJpZ251bWJlcihhcnIpIHtcbiAgICBpZiAoQXJyYXkuaXNBcnJheShhcnIpKSB7XG4gICAgICAgIHJldHVybiBhcnIubWFwKCh2YWx1ZSkgPT4gQmlnKHZhbHVlKS50b0ZpeGVkKCkpO1xuICAgIH0gZWxzZSB7XG4gICAgICAgIHJldHVybiBCaWcoYXJyKS50b0ZpeGVkKCk7XG4gICAgfVxufVxuXG4vKipcbiAqIEphdmFzY3JpcHQg5Zyo5Lul5LiL5oOF5pmv5LiL5Lya6Ieq5Yqo5bCG5pWw5YC86L2s5o2i5Li656eR5a2m6K6h5pWw5rOV77yaXG4gKiAx44CB5b2T5pW05pWw55qE5L2N5pWw6LaF6L+HMjLkvY3ml7bvvIxqc+S8muiHquWKqOWwhuaVtOaVsOaVsOWAvOi9rOWMluS4uuenkeWtpuiusOaVsOazleOAglxuICAgICAganPkuK3nmoTnp5HlraborrDmlbDms5XvvJoxMDAwMDAwMDAwMDAwMDAwMDAwMO+8iDIx5LiqMO+8ieWcqGpz5Lit55qE56eR5a2m6K6w5pWw5rOV6KGo56S65Li677yaMWUrMjE7ICAgICBcbiAqIDLjgIHlsI/mlbDngrnliY3ovrnmmK8w77yM5bCP5pWw54K55ZCO5Y2B5YiG5L2N77yI5YyF5ZCr5Y2B5YiG5L2N77yJ5LmL5ZCO55qEMOeahOS4quaVsOi2hei/hzbkuKrmlbDlgLzlsLHkvJroh6rliqjovazljJbkuLrnp5HlraborqHmlbDms5XvvJtcbiAgICAgICAwLjAwMDAwMDQg5Lya6L2s5o2i5Li677yaIDRlLTcsICDogIwwLjEwMDAwMDA0IOWImeS4jeS8muiiq+i9rOaNou+8jDEuMDAwMDAwMDA05Lmf5LiN5Lya6KKr6L2s5o2iXG4gKiDkuLrkuobpgb/lhY3ov5nnp43oh6rliqjovazmjaLvvIznvJblhpnkuIDkuKrlh73mlbDliKnnlKjmraPliJnmnaXlsIbnp5HlraborqHmlbDms5XnmoTmlbDlgLzovazmjaLkuLrmlbDlgLzmmL7npLrvvJpcbiAqL1xuZnVuY3Rpb24gc2NpZW50aWZpY1RvTnVtYmVyKG51bSkge1xuICAgIGlmICgvXFxkK1xcLj9cXGQqZVtcXCtcXC1dKlxcZCsvaS50ZXN0KG51bSkpIHtcbiAgICAgICAgbGV0IHplcm8gPSAnMCc7XG4gICAgICAgIGxldCBwYXJ0cyA9IFN0cmluZyhudW0pLnRvTG93ZXJDYXNlKCkuc3BsaXQoJ2UnKTtcbiAgICAgICAgbGV0IGUgPSBwYXJ0c1sxXTtcbiAgICAgICAgbGV0IHplcm9MZW4gPSBNYXRoLmFicyhlKTtcbiAgICAgICAgbGV0IHNpZ24gPSBlIC8gemVyb0xlbjtcbiAgICAgICAgbGV0IGJlZm9yZUFyciA9IHBhcnRzWzBdLnNwbGl0KCcuJyk7XG4gICAgICAgIGlmIChzaWduIDwgMCkge1xuICAgICAgICAgICAgbnVtID0gemVybyArICcuJyArIG5ldyBBcnJheSh6ZXJvTGVuKS5qb2luKHplcm8pICsgYmVmb3JlQXJyLmpvaW4oJycpO1xuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgbGV0IGRlYyA9IGJlZm9yZUFyclsxXTtcbiAgICAgICAgICAgIGlmIChkZWMpIHtcbiAgICAgICAgICAgICAgICB6ZXJvTGVuID0gemVyb0xlbiAtIGRlYy5sZW5ndGg7XG4gICAgICAgICAgICAgICAgbnVtID0gYmVmb3JlQXJyLmpvaW4oJycpICsgbmV3IEFycmF5KHplcm9MZW4gKyAxKS5qb2luKHplcm8pO1xuICAgICAgICAgICAgfVxuICAgICAgICB9XG4gICAgfVxuICAgIHJldHVybiBudW07XG59XG5cblxuZXhwb3J0IHsgYWRkLCBzdWJ0cmFjdCwgbXVsdGlwbHksIGRpdmlkZSwgZm9ybWF0LCBiaWdudW1iZXIsIHNjaWVudGlmaWNUb051bWJlciB9O1xuIiwiaW1wb3J0ICogYXMgbnVtYmVyIGZyb20gXCIuL251bWJlclwiO1xuXG52YXIgY2xpY2thYmxlID0gdHJ1ZTtcblxuLy8g6aKc6Imy6YWN572uIDA657qi5rao57u/6LeMIOaIliAxOue7v+a2qOe6oui3jFxudmFyIHVwQ29sb3JMaXN0O1xudmFyIGRvd25Db2xvckxpc3Q7XG5cbi8qKlxuICogQHR5cGVkZWYge09iamVjdH0gQ29tbW9uRGF0YVxuICogQHByb3BlcnR5IHtudW1iZXJ9IHByaWNlQ29sb3JUeXBlICAgIC0g5Lu35qC85rao6LeM5bmF6aKc6Imy6K6+572uXG4gKiBAcHJvcGVydHkge251bWJlcn0gY29sb3JNb2RlICAgICAgICAgLSDnmb3lpKnpu5HlpJzmqKHlvI9cbiAqIEBwcm9wZXJ0eSB7c3RyaW5nfSBsYW5ndWFnZSAgICAgICAgICAtIOivreenjemFjee9rlxuICogQHByb3BlcnR5IHtzdHJpbmd9IE9TICAgICAgICAgICAgICAgIC0g57O757ufXG4gKiBAcHJvcGVydHkge3N0cmluZ30gYXBwVmVyc2lvbiAgICAgICAgLSDniYjmnKzlj7dcbiAqIEBwcm9wZXJ0eSB7bnVtYmVyfSBpc0luUmV2aWV3ICAgICAgICAtIGlPU+WuoeaguOeKtuaAgVxuICogQHByb3BlcnR5IHtudW1iZXJ9IGlzTG9naW4gICAgICAgICAgIC0g5piv5ZCm55m75b2VXG4gKiBAcHJvcGVydHkge29iamVjdH0gbGluZWFyU3dhcFdzRGF0YSAgLSBV5pys5L2N5ZCI57qm6K6i6ZiF5L+h5oGvXG4gKi9cblxuLyoqIEB0eXBlIENvbW1vbkRhdGEgKi9cbmV4cG9ydCB2YXIgY29tbW9uRGF0YSA9IHtcbiAgdXNlclNpZ246IFwiXCIsIC8vLyDnlKjmiLfmoIfor4ZcbiAgY3VycmVudFN5bWJvbDogXCJCVEMtVVNEVFwiLCAvLy/lvZPliY3nmoTlkIjnuqblk4Hnp41cbiAgY3VycmVudENvbnRyYWN0SW5mbzoge30sIC8vL+W9k+WJjeeahOWQiOe6puWTgeenjeaVsOaNrlxuICBjb250cmFjdEluZm9EYXRhOiBbXSwgLy8vbGluZWFyLXN3YXAtb3JkZXIveC92MS9saW5lYXJfc3dhcF9jb250cmFjdF9pbmZvP2J1c2luZXNzX3R5cGU9YWxsJnRyYWRlX3BhcnRpdGlvbj1hbGzjgIDmjqXlj6Pov5Tlm57nmoTmiYDmnInlkIjnuqblk4Hnp43mlbDmja5cbiAgY29udHJhY3RINVVybDogXCJcIiwgLy8v5ZCI57qmSDXlnLDlnYBcbiAgY3VycmVuY3lSYXRlOiBcIjYuNFwiLCAvLy/nvo7lhYPlr7nlhbblroPms5XluIHnmoTmsYfnjodcbiAgY3VycmVuY3lDaGFyYWN0ZXI6IFwiQ05ZXCIsIC8vL+azleW4geespuWPt1xuICBwcmljZUNvbG9yVHlwZTogMCwgLy8vMO+8mue6oua2qOe7v+i3jCAgIDHvvJrnu7/mtqjnuqLot4xcbiAgY29sb3JNb2RlOiAwLCAvLy8w77ya55m95aSpICAgMe+8mum7keWknFxuICBPUzogMCwgLy8w77yaaU9TICAx77ya5a6J5Y2TXG4gIGFwcFZlcnNpb246IFwiXCIsIC8vYXBw54mI5pys5Y+3XG4gIGlzSW5SZXZpZXc6IDEsXG4gIGlzTG9naW46IDAsXG4gIHdlYlVybDogXCJcIiwgLy8vIGg15Yqo5oCB5Z+f5ZCNXG4gIGxhbmd1YWdlOiBcIlwiLCAvLy8g6K+t6KiA56eN57G7XG4gIHBhZ2VUeXBlOiA1MywvLzUzIOWQiOe6pi3ohbDpg6jlhaXlj6MtYXBw44CBNTUg5ZCI57qm6Lef5Y2VLeiFsOmDqC1hcHBcbiAgY29udHJhY3RUeXBlOiBcIlwiLCAvL+WQiOe6puS6p+WTgee6v+exu+Wei1xuICB1c2VySW5mbzoge31cbn07XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBzdWJXZWJTb2NrZXQodHlwZSkge1xuICBhd2FpdCAkbmF0aXZlQVBJLmhhbmRsZVNvY2tldCh7XG4gICAgYWN0aW9uOiBcInN1YldlYlNvY2tldFwiLFxuICAgIHR5cGU6IHR5cGUsXG4gIH0pO1xufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gdW5TdWJXZWJTb2NrZXQodHlwZSkge1xuICBhd2FpdCAkbmF0aXZlQVBJLmhhbmRsZVNvY2tldCh7XG4gICAgYWN0aW9uOiBcInVuU3ViV2ViU29ja2V0XCIsXG4gICAgdHlwZTogdHlwZSxcbiAgfSk7XG59XG5cbi8v5Y+R6YCB6K+35rGCXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gc2VuZFJlcXVlc3QocGF0aCwgcGFyYW1zID0ge30sIG1ldGhvZCA9IDAsIGhvc3RUeXBlID0gMCwgaGVhZGVyID0ge30pIHtcbiAgY29uc29sZS5sb2coYHJlcXVlc3QgJHtwYXRofSwgcGFyYW1zOiR7SlNPTi5zdHJpbmdpZnkocGFyYW1zKX1gKTtcblxuICBpZiAoaG9zdFR5cGUgPT0gNSB8fCBob3N0VHlwZSA9PSA2KSB7XG4gICAgaGVhZGVyW1wiQ29udGVudC1UeXBlXCJdID0gXCJhcHBsaWNhdGlvbi9qc29uXCI7XG4gIH1cblxuICBjb25zdCBwYXJhbSA9IHtcbiAgICBwYXRoLFxuICAgIG1ldGhvZCxcbiAgICBob3N0VHlwZSxcbiAgICBoZWFkZXIsXG4gICAgcGFyYW1zLFxuICB9O1xuICB0cnkge1xuICAgIHZhciByZXNwb25zZVN0cmluZyA9IGF3YWl0ICRuYXRpdmVBUEkucmVxdWVzdChKU09OLnN0cmluZ2lmeShwYXJhbSkpO1xuICAgIHZhciByZXNwb25zZSA9IEpTT04ucGFyc2UocmVzcG9uc2VTdHJpbmcpO1xuICAgIHZhciB7IGNvZGUsIGRhdGEgfSA9IHJlc3BvbnNlO1xuICAgIGlmICg4ID09IGhvc3RUeXBlKSB7XG4gICAgICAvL+WQiOe6pueahOaOpeWPo+WkhOeQhlxuICAgICAgdmFyIHN0YXR1cyA9IHJlc3BvbnNlLnN0YXR1cztcbiAgICAgIHZhciBlcnJfY29kZSA9IHJlc3BvbnNlLmVycl9jb2RlO1xuICAgICAgdmFyIGVycl9tc2cgPSByZXNwb25zZS5lcnJfbXNnO1xuICAgICAgaWYgKHN0YXR1cyA9PSBcIm9rXCIpIHtcbiAgICAgICAgY29uc29sZS5sb2coYHJlcXVlc3QgJHtwYXRofSBkb25lYCk7XG4gICAgICAgIGlmICh0eXBlb2YgZGF0YSA9PT0gJ251bWJlcicpIHtcbiAgICAgICAgICBsZXQgc3RhcnQgPSBgXCJkYXRhXCI6YDtcbiAgICAgICAgICBsZXQgc3RhcnRJbmRleCA9IHJlc3BvbnNlU3RyaW5nLmluZGV4T2Yoc3RhcnQpO1xuICAgICAgICAgIGxldCBlbmQgPSBgLFwidHNcIjpgO1xuICAgICAgICAgIGxldCBlbmRJbmRleCA9IHJlc3BvbnNlU3RyaW5nLmluZGV4T2YoZW5kKTtcbiAgICAgICAgICBsZXQgZGF0YVN0cmluZyA9IHJlc3BvbnNlU3RyaW5nLnN1YnN0cmluZyhzdGFydEluZGV4ICsgc3RhcnQubGVuZ3RoLCBlbmRJbmRleCk7XG4gICAgICAgICAgY29uc29sZS5sb2coYGRhdGEgaXMgdHlwZW9mIG51bWJlciwgZGF0YVN0cmluZyA9ICR7ZGF0YVN0cmluZ31gKTtcbiAgICAgICAgICByZXR1cm4gZGF0YVN0cmluZztcbiAgICAgICAgfVxuICAgICAgICByZXR1cm4gZGF0YTtcbiAgICAgIH0gZWxzZSB7XG4gICAgICAgIGNvbnNvbGUubG9nKGByZXF1ZXN0IGZhaWxlZCwgY29kZT0ke2Vycl9jb2RlfSwgbWVzc2FnZT0ke2Vycl9tc2d9YCk7XG4gICAgICAgIGlmIChtZXRob2QgIT0gMCkge1xuICAgICAgICAgIHNob3dUb2FzdChlcnJfbXNnKTtcbiAgICAgICAgfVxuICAgICAgICByZXR1cm4gbnVsbDtcbiAgICAgIH1cbiAgICB9IGVsc2UgaWYgKGNvZGUgPT0gMjAwKSB7XG4gICAgICBjb25zb2xlLmxvZyhgcmVxdWVzdCAke3BhdGh9IGRvbmVgKTtcbiAgICAgIHJldHVybiBkYXRhO1xuICAgIH0gZWxzZSB7XG4gICAgICBjb25zb2xlLmxvZyhgcmVxdWVzdCBmYWlsZWQsIGNvZGU9JHtjb2RlfWApO1xuICAgICAgbGV0IG1lc3NhZ2UgPSByZXNwb25zZS5tZXNzYWdlO1xuICAgICAgaWYgKG1ldGhvZCAhPSAwICYmIG1lc3NhZ2UpIHtcbiAgICAgICAgc2hvd1RvYXN0KG1lc3NhZ2UpO1xuICAgICAgfVxuICAgICAgcmV0dXJuIG51bGw7XG4gICAgfVxuICB9IGNhdGNoIChlKSB7XG4gICAgY29uc29sZS5sb2coYHJlcXVlc3QgZXJyb3IsIGVycm9yPSR7ZX1gKTtcbiAgICByZXR1cm4gbnVsbDtcbiAgfVxufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gc2VuZFJlcXVlc3RXaXRoQ2FjaGUoXG4gIHBhdGgsXG4gIGNhbGxiYWNrLFxuICBwYXJhbXMgPSB7fSxcbiAgbWV0aG9kID0gMCxcbiAgaG9zdFR5cGUgPSAwLFxuICBoZWFkZXIgPSB7fSxcbiAgY2FjaGVLZXlMaXN0ID0gbnVsbFxuKSB7XG4gIHZhciBjYWNoZUtleSA9IGdldENhY2hlS2V5KHBhdGgsIHBhcmFtcywgY2FjaGVLZXlMaXN0KTtcbiAgY29uc3QgY2FjaGUgPSBhd2FpdCByZWFkKFwiYXBpQ2FjaGVcIiwgY2FjaGVLZXkpO1xuICBpZiAoY2FjaGUgJiYgY2FsbGJhY2spIHtcbiAgICBjYWxsYmFjayhjYWNoZSwgdHJ1ZSk7XG4gIH1cbiAgY29uc3QgcmVxdWVzdERhdGEgPSBhd2FpdCBzZW5kUmVxdWVzdChwYXRoLCBwYXJhbXMsIG1ldGhvZCwgaG9zdFR5cGUsIGhlYWRlcik7XG4gIGF3YWl0IHNhdmUoXCJhcGlDYWNoZVwiLCBjYWNoZUtleSwgcmVxdWVzdERhdGEpO1xuICBpZiAocmVxdWVzdERhdGEgJiYgY2FsbGJhY2spIHtcbiAgICBjYWxsYmFjayhyZXF1ZXN0RGF0YSwgZmFsc2UpO1xuICB9XG4gIHJldHVybiByZXF1ZXN0RGF0YTtcbn1cblxuZnVuY3Rpb24gZ2V0Q2FjaGVLZXkocGF0aCwgcGFyYW1zLCBjYWNoZUtleUxpc3QgPSBudWxsKSB7XG4gIHZhciBjYWNoZUtleSA9IFwiXCI7XG4gIGlmIChjYWNoZUtleUxpc3QgPT0gbnVsbCkge1xuICAgIC8vbnVsbO+8muaJgOacieWPguaVsOS9nOS4uue8k+WtmOWPguaVsFxuICAgIHZhciBwYXJhbVN0ciA9IEpTT04uc3RyaW5naWZ5KHBhcmFtcyk7XG4gICAgY2FjaGVLZXkgPSBgJHtwYXRofV8ke3BhcmFtU3RyfV8ke2NvbW1vbkRhdGEubGFuZ3VhZ2V9XyR7Y29tbW9uRGF0YS5jb2xvck1vZGV9XyR7Y29tbW9uRGF0YS5pc0xvZ2lufWA7XG4gIH0gZWxzZSBpZiAoY2FjaGVLZXlMaXN0Lmxlbmd0aCA9PSAwKSB7XG4gICAgLy8gW10gLOS4quaVsOS4ujDvvJrkuI3pnIDopoHlj4LmlbDkvZzkuLrnvJPlrZjlj4LmlbBcbiAgICBjYWNoZUtleSA9IGAke3BhdGh9XyR7Y29tbW9uRGF0YS5sYW5ndWFnZX1fJHtjb21tb25EYXRhLmNvbG9yTW9kZX1fJHtjb21tb25EYXRhLmlzTG9naW59YDtcbiAgfSBlbHNlIHtcbiAgICB2YXIgY2FjaGVLZXlMaXN0U3RyID0gY2FjaGVLZXlMaXN0LmpvaW4oXCJfXCIpO1xuICAgIGNhY2hlS2V5ID0gYCR7cGF0aH1fJHtjYWNoZUtleUxpc3RTdHJ9XyR7Y29tbW9uRGF0YS5sYW5ndWFnZX1fJHtjb21tb25EYXRhLmNvbG9yTW9kZX1fJHtjb21tb25EYXRhLmlzTG9naW59YDtcbiAgfVxuICByZXR1cm4gY2FjaGVLZXk7XG59XG5cbi8v5qC55o2u5rao6LeM5bmF6I635Y+W5pi+56S66aKc6ImyXG5leHBvcnQgZnVuY3Rpb24gZ2V0UHJpY2VDb2xvcihyYXRpbykge1xuICAvLyBjb25zb2xlLmxvZygnZ2V0UHJpY2VDb2xvcicpO1xuICBpZiAocmF0aW8gPT0gbnVsbCkge1xuICAgIHJhdGlvID0gMDtcbiAgfVxuICBjb25zdCByYXRpb19hYnMgPSBNYXRoLmFicyhyYXRpbyk7XG4gIHZhciBjb2xvckxldmVsID0gMDtcbiAgaWYgKHJhdGlvX2FicyA+IDAgJiYgcmF0aW9fYWJzIDwgMykge1xuICAgIGNvbG9yTGV2ZWwgPSAxO1xuICB9IGVsc2UgaWYgKHJhdGlvX2FicyA+PSAzICYmIHJhdGlvX2FicyA8IDgpIHtcbiAgICBjb2xvckxldmVsID0gMjtcbiAgfSBlbHNlIGlmIChyYXRpb19hYnMgPj0gOCkge1xuICAgIGNvbG9yTGV2ZWwgPSAzO1xuICB9XG4gIHZhciBjb2xvckhleFN0ciA9IG51bGw7XG4gIGlmIChyYXRpbyA+IDApIHtcbiAgICBjb2xvckhleFN0ciA9IHVwQ29sb3JMaXN0W2NvbG9yTGV2ZWxdO1xuICB9IGVsc2Uge1xuICAgIGNvbG9ySGV4U3RyID0gZG93bkNvbG9yTGlzdFtjb2xvckxldmVsXTtcbiAgfVxuICByZXR1cm4gY29sb3JIZXhTdHI7XG59XG5cbi8v6I635Y+W5Lu35qC85pi+56S65paH5pysXG5leHBvcnQgZnVuY3Rpb24gZ2V0UHJpY2VTdHJpbmcocHJpY2VTdHIsIHByZWNpc2lvbikge1xuICB2YXIgcHJpY2VUZW1wID0gcHJpY2VTdHI7XG4gIHZhciBkZWNpbWFsQXJyID0gcHJpY2VUZW1wLnNwbGl0KFwiLlwiKTtcbiAgaWYgKGRlY2ltYWxBcnIubGVuZ3RoIDwgMikge1xuICAgIHByaWNlVGVtcCA9IHBhcnNlRmxvYXQocHJpY2VUZW1wKS50b0ZpeGVkKDEpO1xuICAgIGRlY2ltYWxBcnIgPSBwcmljZVRlbXAuc3BsaXQoXCIuXCIpO1xuICB9XG4gIGNvbnN0IGRlY2ltYWxDb3VudCA9IGRlY2ltYWxBcnJbMV0ubGVuZ3RoO1xuICBjb25zdCBwYWRkZWRQcmljZVN0ciA9XG4gICAgZGVjaW1hbENvdW50IDwgcHJlY2lzaW9uXG4gICAgICA/IHByaWNlVGVtcC5wYWRFbmQocHJpY2VUZW1wLmxlbmd0aCArIChwcmVjaXNpb24gLSBkZWNpbWFsQ291bnQpLCBcIjBcIilcbiAgICAgIDogcGFyc2VGbG9hdChwcmljZVRlbXApLnRvRml4ZWQocHJlY2lzaW9uKTtcbiAgY29uc3QgZmluYWxQcmljZVN0ciA9IHBhZGRlZFByaWNlU3RyLnJlcGxhY2UoL1xcZCg/PShcXGR7M30pK1xcLikvZywgXCIkJixcIik7XG4gIHJldHVybiBmaW5hbFByaWNlU3RyO1xufVxuXG4vL+i/m+ihjOeyvuW6puWkhOeQhlxuZXhwb3J0IGZ1bmN0aW9uIGZvcm1hdFByZWNpc2lvbih2YWx1ZSwgcHJlY2lzaW9uKSB7XG4gIHRyeSB7XG4gICAgY29uc3QgcmVzdWx0ID0gbnVtYmVyLmZvcm1hdCh2YWx1ZSwgcHJlY2lzaW9uKTtcbiAgICByZXR1cm4gcmVzdWx0O1xuICB9IGNhdGNoIChlKSB7XG4gICAgY29uc29sZS5sb2coZSk7XG4gICAgcmV0dXJuIHZhbHVlLnRvRml4ZWQocHJlY2lzaW9uKTtcbiAgfVxufVxuXG4vLyAvL+aJk+W8gFVSTFxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIG9wZW5VUkwodXJsKSB7XG4gIGlmICghY2xpY2thYmxlKSB7XG4gICAgcmV0dXJuO1xuICB9XG4gIGNvbnNvbGUubG9nKGBvcGVuIHVybDpgLCB1cmwpO1xuICBpZiAodXJsICYmIHVybCAhPSBudWxsICYmIHVybC5sZW5ndGggPiAwKSB7XG4gICAgYXdhaXQgJG5hdGl2ZUFQSS5vcGVuUm91dGUodXJsKTtcbiAgfVxuICBjbGlja2FibGUgPSBmYWxzZTtcbiAgc2V0VGltZW91dCgoKSA9PiB7XG4gICAgY2xpY2thYmxlID0gdHJ1ZTtcbiAgfSwgMTAwMCk7XG59XG5cbi8v5omT5byA6aG16Z2iXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gb3BlblBhZ2UocGFnZSwgdHlwZSA9IFwibmF0aXZlXCIsIHBhcmFtcyA9IHt9KSB7XG4gIGF3YWl0ICRuYXRpdmVBUEkuY29weVRyYWRpbmdCcmlkZ2Uoe1xuICAgIGFjdGlvbjogXCJvcGVuUGFnZVwiLFxuICAgIHR5cGU6IHR5cGUsXG4gICAgcGFnZTogcGFnZSxcbiAgICBwYXJhbXM6IEpTT04uc3RyaW5naWZ5KHBhcmFtcyksXG4gIH0pO1xufVxuXG4vL3RvYXN0XG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gc2hvd1RvYXN0KG1zZykge1xuICBhd2FpdCAkbmF0aXZlQVBJLmhiVG9hc3QobXNnKTtcbn1cblxuLy/kv53lrZjmlbDmja5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBzYXZlKG1vZHVsZSwga2V5LCBkYXRhKSB7XG4gIGF3YWl0ICRuYXRpdmVBUEkuc3RvcmFnZSh7XG4gICAgYWN0aW9uOiBcInNhdmVcIixcbiAgICBuYW1lOiBtb2R1bGUsXG4gICAga2V5OiBrZXksXG4gICAgZGF0YTogSlNPTi5zdHJpbmdpZnkoZGF0YSksXG4gIH0pO1xufVxuXG4vL+ivu+WPluaVsOaNrlxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHJlYWQobW9kdWxlLCBrZXkpIHtcbiAgY29uc3QgZGF0YSA9IGF3YWl0ICRuYXRpdmVBUEkuc3RvcmFnZSh7XG4gICAgYWN0aW9uOiBcInJlYWRcIixcbiAgICBuYW1lOiBtb2R1bGUsXG4gICAga2V5OiBrZXksXG4gIH0pO1xuICBpZiAoZGF0YSAmJiBkYXRhICE9IFwiXCIpIHtcbiAgICByZXR1cm4gSlNPTi5wYXJzZShkYXRhKTtcbiAgfVxuICByZXR1cm4gbnVsbDtcbn1cblxuLy/muIXnkIbmlbDmja5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBjbGVhcihtb2R1bGUsIGtleSkge1xuICBhd2FpdCAkbmF0aXZlQVBJLnN0b3JhZ2Uoe1xuICAgIGFjdGlvbjogXCJjbGVhclwiLFxuICAgIG5hbWU6IG1vZHVsZSxcbiAgICBrZXk6IGtleSxcbiAgfSk7XG59XG5cbi8v5riF55CG5YWo6YOo5pWw5o2uXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gY2xlYXJBbGwobW9kdWxlKSB7XG4gIGF3YWl0ICRuYXRpdmVBUEkuc3RvcmFnZSh7XG4gICAgYWN0aW9uOiBcImNsZWFyXCIsXG4gICAgbmFtZTogbW9kdWxlLFxuICB9KTtcbn1cblxuLy/ln4vngrlcbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBhbmFseXRpY3MoZXZlbnQgPSBcIlwiLCBwcm9wZXJ0aWVzID0ge30pIHtcbiAgICBjb25zdCBwcm9wZXJ0aWVzSnNvbiA9IEpTT04uc3RyaW5naWZ5KHByb3BlcnRpZXMpO1xuICAgIGNvbnNvbGUubG9nKGBhbmFseXRpY3MgZXZlbnQ6ICR7ZXZlbnR9LCBwcm9wZXJ0aWVzSnNvbiA9ICR7cHJvcGVydGllc0pzb259YCk7XG4gICAgdmFyIG1hcCA9IHtcbiAgICAgICAgZXZlbnQ6IGV2ZW50LFxuICAgICAgICBwcm9wZXJ0aWVzOiBwcm9wZXJ0aWVzSnNvblxuICAgIH07XG4gICAgYXdhaXQgJG5hdGl2ZUFQSS5hbmFseXRpY3MobWFwKTtcbn1cblxuLy/orr7nva7pgJrnlKjphY3nva5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBzZW5kQ29tbW9uQ29uZmlnKHBhcmFtKSB7XG4gIGNvbnNvbGUubG9nKGBwdWJsaWMgY29tcG9uZW50cyBzZW5kQ29tbW9uQ29uZmlnOiAke0pTT04uc3RyaW5naWZ5KHBhcmFtKX1gKTtcbiAgbGV0IHNhdmVkU3ltYm9sID0gYXdhaXQgcmVhZChcImNvcHlUcmFkaW5nXCIsIFwiY3VycmVudENvcHlUcmFkaW5nU3ltYm9sXCIpO1xuICBpZiAobnVsbCA9PSBzYXZlZFN5bWJvbCB8fCAwID09IHNhdmVkU3ltYm9sLmxlbmd0aCkge1xuICAgIGNvbW1vbkRhdGEuY3VycmVudFN5bWJvbCA9IFwiQlRDLVVTRFRcIjtcbiAgfSBlbHNlIHtcbiAgICBjb21tb25EYXRhLmN1cnJlbnRTeW1ib2wgPSBzYXZlZFN5bWJvbDtcbiAgfVxuICBjb21tb25EYXRhLmNvbnRyYWN0SDVVcmwgPSBwYXJhbS5jb250cmFjdEg1VXJsO1xuICBjb21tb25EYXRhLmN1cnJlbmN5UmF0ZSA9IHBhcmFtLmN1cnJlbmN5UmF0ZTtcbiAgaWYgKHBhcmFtLmN1cnJlbmN5UmF0ZSAhPSBudWxsICYmIDAgPT0gcGFyYW0uY3VycmVuY3lSYXRlLmxlbmd0aCkge1xuICAgIGNvbW1vbkRhdGEuY3VycmVuY3lSYXRlID0gXCIxXCI7XG4gIH1cbiAgY29tbW9uRGF0YS5jdXJyZW5jeUNoYXJhY3RlciA9IHBhcmFtLmN1cnJlbmN5Q2hhcmFjdGVyO1xuICBjb21tb25EYXRhLnByaWNlQ29sb3JUeXBlID0gcGFyc2VJbnQocGFyYW0ucHJpY2VDb2xvclR5cGUpO1xuICBjb21tb25EYXRhLmNvbG9yTW9kZSA9IHBhcnNlSW50KHBhcmFtLmNvbG9yTW9kZSk7XG4gIGNvbW1vbkRhdGEuT1MgPSBwYXJzZUludChwYXJhbS5PUyk7XG4gIGNvbW1vbkRhdGEuYXBwVmVyc2lvbiA9IHBhcmFtLmFwcFZlcnNpb247XG4gIGNvbW1vbkRhdGEuaXNJblJldmlldyA9IHBhcnNlSW50KHBhcmFtLmlzSW5SZXZpZXcpO1xuICBjb21tb25EYXRhLmxhbmd1YWdlID0gcGFyYW0ubGFuZ3VhZ2U7XG4gIGNvbW1vbkRhdGEud2ViVXJsID0gcGFyYW0uaDVVcmw7XG5cbiAgdmFyIHJlZENvbG9yTGlzdCA9IFtcIiM4QzlGQURcIiwgXCIjRTk0MzU5XCIsIFwiI0VFM0YzNFwiLCBcIiNERDI4MURcIiwgXCIjRkZGNUY0XCJdO1xuICB2YXIgZ3JlZW5Db2xvckxpc3QgPSBbXCIjOEM5RkFEXCIsIFwiIzAwQTE3MVwiLCBcIiMxMzlBODRcIiwgXCIjMEY3NjY1XCIsIFwiIzEyMUYyNVwiXTtcblxuICBpZiAocGFyc2VJbnQoY29tbW9uRGF0YS5wcmljZUNvbG9yVHlwZSkgPT0gMCkge1xuICAgIHVwQ29sb3JMaXN0ID0gcmVkQ29sb3JMaXN0O1xuICAgIGRvd25Db2xvckxpc3QgPSBncmVlbkNvbG9yTGlzdDtcbiAgfSBlbHNlIHtcbiAgICB1cENvbG9yTGlzdCA9IGdyZWVuQ29sb3JMaXN0O1xuICAgIGRvd25Db2xvckxpc3QgPSByZWRDb2xvckxpc3Q7XG4gIH1cbn1cblxuZXhwb3J0IGZ1bmN0aW9uIGdldFVwRG93bkNvbG9yKGlzVXBwZXIgPSB0cnVlLCBsZXZlbCA9IDEpIHtcbiAgY29uc3QgbGV2ID0gbGV2ZWwgPCA0ID8gbGV2ZWwgOiAwO1xuICBpZiAoaXNVcHBlcikge1xuICAgIHJldHVybiB1cENvbG9yTGlzdFtsZXZdO1xuICB9XG4gIHJldHVybiBkb3duQ29sb3JMaXN0W2xldl07XG59XG5sZXQgc3ltYm9sRGVzY01hcCA9IHt9XG5leHBvcnQgZnVuY3Rpb24gc3ltYm9sRGVzYyhzeW1ib2wpIHtcbiAgaWYgKCFzeW1ib2xEZXNjTWFwLmhhc093blByb3BlcnR5KHN5bWJvbCkpIHtcbiAgICBzeW1ib2xEZXNjTWFwW3N5bWJvbF0gPSAkaTE4bi4kaW50ZXJjZXB0Lm5fY29udHJhY3Rfc3dhcF90cmFkZV9uYW1lKHN5bWJvbC5yZXBsYWNlKFwiLVwiLCBcIlwiKSk7XG4gIH1cbiAgcmV0dXJuIHN5bWJvbERlc2NNYXBbc3ltYm9sXTtcbn1cblxuZXhwb3J0IGZ1bmN0aW9uIG1vZHVsZURlZmluZShtb2R1bGVOYW1lLCBzdGFydEZ1bmN0aW9uLCBkZWZhdWx0RGF0YUZ1bmN0aW9uKSB7XG4gIGNvbnNvbGUubG9nKGBsb2FkTW9kdWxlYCwgbW9kdWxlTmFtZStcIiBiZWdpblwiKTtcbiAgJGRhdGFbbW9kdWxlTmFtZV0gPSBkZWZhdWx0RGF0YUZ1bmN0aW9uKCk7XG4gICRldmVudFttb2R1bGVOYW1lXSA9IHsgc3RhcnQ6IHN0YXJ0RnVuY3Rpb24gfTtcbiAgY29uc29sZS5sb2coYGxvYWRNb2R1bGVgLCBtb2R1bGVOYW1lK1wiIGVuZFwiKTtcbiAgcmV0dXJuIHtcbiAgICBtb2R1bGVFdmVudDogJGV2ZW50W21vZHVsZU5hbWVdLFxuICAgIG1vZHVsZURhdGE6ICRkYXRhW21vZHVsZU5hbWVdLFxuICB9O1xufVxuXG5leHBvcnQgZnVuY3Rpb24gTG9nKG1zZywgLi4uYXJncykge1xuICBjb25zb2xlLmxvZyhgW2NvcHl0cmFkaW5nIGpzLV0ke21zZ31gLCBhcmdzKTtcbn1cblxuLyoqXG4gKiBcbiAqIEBwYXJhbSB7Ym9vbGVhbn0gaXNTaG93IOaYr+WQpuaYvuekuuWKoOi9veahhlxuICovXG5leHBvcnQgZnVuY3Rpb24gc2hvd0xvYWRpbmcoaXNTaG93ID0gdHJ1ZSkge1xuICAkbmF0aXZlQVBJLnNob3dMb2FkaW5nKGlzU2hvdyA/IDEgOiAwKTtcbn1cblxubGV0IHN5bWJvbE1hcCA9IHt9O1xuXG4vKipcbiAqIFxuICogQHBhcmFtIHtzdHJpbmd9IHN5bWJvbCDluIHlr7nkv6Hmga/vvIxCVEMtVVNEVFxuICogQHJldHVybnMg6L+U5Zue546w6LSn5Lqk5piT5a+55qih5Z6LXG4gKi9cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBnZXRTcG90U3ltYm9sTW9kZWwoc3ltYm9sKSB7XG4gIGlmIChzeW1ib2xNYXAuaGFzT3duUHJvcGVydHkoc3ltYm9sKSkge1xuICAgIHJldHVybiBzeW1ib2xNYXBbc3ltYm9sXTtcbiAgfVxuICBjb25zdCBqc29uID0gYXdhaXQgJG5hdGl2ZUFQSS5nZXRTcG90U3ltYm9sTW9kZWwoc3ltYm9sKTtcbiAgY29uc29sZS5sb2coYHRsIC0tIGdldFNwb3RTeW1ib2xNb2RlbD09Pmpzb249PSR7anNvbn1gKTtcbiAgY29uc3QgcmVzcG9uc2UgPSBKU09OLnBhcnNlKGpzb24pO1xuICBjb25zb2xlLmxvZyhgdGwgLS0gZ2V0U3BvdFN5bWJvbE1vZGVsPT0+cmVzcG9uc2U9PSR7cmVzcG9uc2V9YCk7XG4gIHN5bWJvbE1hcFtzeW1ib2xdID0gcmVzcG9uc2U7XG4gIHJldHVybiByZXNwb25zZTtcbn1cblxuLyoqXG4gKiDmt7vliqAv5Yig6Zmk6Ieq6YCJXG4gKiBAcGFyYW0ge3N0cmluZ30gc3ltYm9sIOW4geWvueS/oeaBr++8jEJUQy1VU0RUXG4gKiBAcGFyYW0ge2Jvb2xlYW59IGlzRmF2b3JpdGUgPTEg5bey5re75YqgID0+IOacqua3u+WKoFxuICogQHJldHVybiAwIOaTjeS9nOWksei0pe+8jDEg5pON5L2c5oiQ5YqfXG4gKi9cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBoYW5kbGVGYXZvcml0ZShzeW1ib2wsIGlzRmF2b3JpdGUpIHtcbiAgdmFyIGRpY3QgPSB7ICdzeW1ib2wnOiBzeW1ib2wsICdpc0Zhdm9yaXRlJzogaXNGYXZvcml0ZSB9O1xuICBjb25zb2xlLmxvZyhgdGwgLS0gaGFuZGxlRmF2b3JpdGUsIHN5bWJvbD09JHtzeW1ib2x9LCBpc0Zhdm9yaXRlPT0ke2lzRmF2b3JpdGV9YCk7XG4gIHJldHVybiBhd2FpdCAkbmF0aXZlQVBJLmhhbmRsZUZhdm9yaXRlKEpTT04uc3RyaW5naWZ5KGRpY3QpKTtcbn1cblxuLyoqXG4gKiDojrflj5bluIHnp43lm77moIdcbiAqIEBwYXJhbSB7c3RyaW5nfSBiYXNlQ3VycmVuY3kg5Z+656GA5biB5L+h5oGv77yM5L6L5aaCIEJUQ++8jEVUSFxuICogQHJldHVybnMg6L+U5Zue5biB5a+55Zu+5qCHIHBuZyDlnLDlnYBcbiAqL1xuZXhwb3J0IGZ1bmN0aW9uIGhhbmRsZVBOR0ljb25VcmwoYmFzZUN1cnJlbmN5KSB7XG4gIGxldCBiYXNlVXJsID0gY29tbW9uRGF0YS53ZWJVcmwgPyBjb21tb25EYXRhLndlYlVybCA6IFwiXCI7XG4gIGxldCBpY29uVXJsID0gYCR7YmFzZVVybH0vLS94L2hiL3AvYXBpL2NvbnRlbnRzL2N1cnJlbmN5L2ljb25fcG5nLyR7YmFzZUN1cnJlbmN5LnRvTG93ZXJDYXNlKCl9LnBuZ2A7XG4gIGNvbnNvbGUubG9nKGB0bCAtLSBoYW5kbGVQTkdJY29uVXJsLCBpY29uVXJsPT0ke2ljb25Vcmx9YCk7XG4gIHJldHVybiBpY29uVXJsO1xufVxuXG4vKipcbiAqXG4gKiBAcGFyYW0ge+aXtumXtOaXpeacn+agvOW8j+WMln0gZm10IHl5eXktTU0tZGQgaGg6bW06c3NcbiAqIEByZXR1cm5zIOagvOW8j+WMluS5i+WQjueahCDlrZfnrKbkuLLvvIznlKjms5XkvovlpoIgbmV3IERhdGUo5pe26Ze05oizKS5Gb3JtYXQoXCJ5eXl5LU1NLWRkIGhoOm1tOnNzXCIpXG4gKi9cbkRhdGUucHJvdG90eXBlLkZvcm1hdCA9IGZ1bmN0aW9uIChmbXQpIHtcbiAgICB2YXIgbyA9IHtcbiAgICAgICAgXCJNK1wiOiB0aGlzLmdldE1vbnRoKCkgKyAxLCAvL+aciOS7vVxuICAgICAgICBcImQrXCI6IHRoaXMuZ2V0RGF0ZSgpLCAvL+aXpVxuICAgICAgICBcImgrXCI6IHRoaXMuZ2V0SG91cnMoKSwgLy/lsI/ml7ZcbiAgICAgICAgXCJtK1wiOiB0aGlzLmdldE1pbnV0ZXMoKSwgLy/liIZcbiAgICAgICAgXCJzK1wiOiB0aGlzLmdldFNlY29uZHMoKSwgLy/np5JcbiAgICAgICAgXCJxK1wiOiBNYXRoLmZsb29yKCh0aGlzLmdldE1vbnRoKCkgKyAzKSAvIDMpLCAvL+Wto+W6plxuICAgICAgICBcIlNcIjogdGhpcy5nZXRNaWxsaXNlY29uZHMoKSAvL+avq+enklxuICAgIH07XG4gICAgaWYgKC8oeSspLy50ZXN0KGZtdCkpIGZtdCA9IGZtdC5yZXBsYWNlKFJlZ0V4cC4kMSwgKHRoaXMuZ2V0RnVsbFllYXIoKSArIFwiXCIpLnN1YnN0cig0IC0gUmVnRXhwLiQxLmxlbmd0aCkpO1xuICAgIGZvciAodmFyIGsgaW4gbylcbiAgICAgICAgaWYgKG5ldyBSZWdFeHAoXCIoXCIgKyBrICsgXCIpXCIpLnRlc3QoZm10KSkgZm10ID0gZm10LnJlcGxhY2UoUmVnRXhwLiQxLCAoUmVnRXhwLiQxLmxlbmd0aCA9PSAxKSA/IChvW2tdKSA6ICgoXCIwMFwiICsgb1trXSkuc3Vic3RyKChcIlwiICsgb1trXSkubGVuZ3RoKSkpO1xuICAgIHJldHVybiBmbXQ7XG59IiwiaW1wb3J0ICogYXMgY29tbW9uIGZyb20gJy4vY29tbW9uJztcblxudmFyIGN1ckxpc3QgPSBbXTtcblxuLy/liJ3lp4vljJZcbmFzeW5jIGZ1bmN0aW9uIHN0YXJ0KCkge1xuXG59XG5cbi8v5Yid5aeL5YyW5pWw5o2uXG5mdW5jdGlvbiBkZWZhdWx0RGF0YSgpIHtcbiAgICByZXR1cm4ge1xuICAgICAgICBsaXN0OiBbXSxcbiAgICB9O1xufVxuXG5jb25zdCB7IG1vZHVsZURhdGEsIG1vZHVsZUV2ZW50IH0gPSBjb21tb24ubW9kdWxlRGVmaW5lKFwiYm90dG9tTGlzdFJhZGlvRGlhbG9nXCIsIHN0YXJ0LCBkZWZhdWx0RGF0YSk7XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiByZWZyZXNoRGF0YShhcmdzKSB7XG4gICAgY29uc3QgcGFyYW1zID0gSlNPTi5wYXJzZShhcmdzKTtcbiAgICBjb25zb2xlLmxvZyhgd3AgYm90dG9tUmFkaW9EaWFsb2cgcmVmcmVzaERhdGEgYCArIGFyZ3MudG9TdHJpbmcoKSk7XG4gICAgbW9kdWxlRGF0YS50b3BUaXRsZSA9IHBhcmFtcy50b3BUaXRsZTtcbiAgICBjdXJMaXN0ID0gcGFyYW1zLmxpc3Q7XG4gICAgZm9yICh2YXIgaSA9IDA7IGkgPCBjdXJMaXN0Lmxlbmd0aDsgaSsrKSB7XG4gICAgICAgIHZhciBpdGVtID0gY3VyTGlzdFtpXTtcbiAgICAgICAgaXRlbS5pbmRleCA9IGk7XG4gICAgICAgIGl0ZW0udW5TZWxlY3RlZEltYWdlVmlzaWJpbGl0eSA9IFwidmlzaWJsZVwiO1xuICAgICAgICBpdGVtLnNlbGVjdGVkSW1hZ2VWaXNpYmlsaXR5ID0gXCJnb25lXCI7XG4gICAgICAgIGl0ZW0udHlwZSA9IFwibm9ybWFsXCI7XG4gICAgICAgIGl0ZW0udW5TZWxlY3RlZEltYWdlVmlzaWJpbGl0eSA9IGl0ZW0uc2VsZWN0ZWQgPyBcImdvbmVcIiA6IFwidmlzaWJsZVwiO1xuICAgICAgICBpdGVtLnNlbGVjdGVkSW1hZ2VWaXNpYmlsaXR5ID0gaXRlbS5zZWxlY3RlZCA/IFwidmlzaWJsZVwiIDogXCJnb25lXCI7XG4gICAgfVxuICAgIG1vZHVsZURhdGEubGlzdCA9IGN1ckxpc3Q7XG59XG5cbm1vZHVsZUV2ZW50LnBvcERpc21pc3MgPSBmdW5jdGlvbiAoKSB7XG4gICAgY29uc29sZS5sb2coYHdwIHBvcERpc21pc3NgKTtcbiAgICB2YXIgZGljID0ge1wiY2xvc2VBbGVydFwiOnRydWV9O1xuICAgIG1vZHVsZURhdGEuZGlhbG9nSW5mbyA9IEpTT04uc3RyaW5naWZ5KGRpYyk7XG59XG5cbm1vZHVsZUV2ZW50LnR5cGVUYXBBY3Rpb24gPSBmdW5jdGlvbiAoaW5kZXgpIHtcbiAgICBjb25zb2xlLmxvZyhgd3AgdHlwZVRhcEFjdGlvbiAgaW5kZXg9JHtpbmRleH1gKTtcbiAgICB2YXIgc2VsZWN0ZWRJdGVtO1xuICAgIGZvciAodmFyIGkgPSAwOyBpIDwgY3VyTGlzdC5sZW5ndGg7IGkrKykge1xuICAgICAgICB2YXIgaXRlbSA9IGN1ckxpc3RbaV07XG4gICAgICAgIGlmIChpID09IGluZGV4KSB7XG4gICAgICAgICAgICBpdGVtLnNlbGVjdGVkID0gdHJ1ZTtcbiAgICAgICAgICAgIGl0ZW0udW5TZWxlY3RlZEltYWdlVmlzaWJpbGl0eSA9IFwiZ29uZVwiO1xuICAgICAgICAgICAgaXRlbS5zZWxlY3RlZEltYWdlVmlzaWJpbGl0eSA9IFwidmlzaWJsZVwiO1xuICAgICAgICAgICAgc2VsZWN0ZWRJdGVtID0gaXRlbTtcbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIGl0ZW0uc2VsZWN0ZWQgPSBmYWxzZTtcbiAgICAgICAgICAgIGl0ZW0udW5TZWxlY3RlZEltYWdlVmlzaWJpbGl0eSA9IFwidmlzaWJsZVwiO1xuICAgICAgICAgICAgaXRlbS5zZWxlY3RlZEltYWdlVmlzaWJpbGl0eSA9IFwiZ29uZVwiO1xuICAgICAgICB9XG4gICAgfVxuICAgIG1vZHVsZURhdGEubGlzdCA9IGN1ckxpc3Q7XG4gICAgdmFyIGRpYyA9IHtcImNvbmZpcm1BbGVydFwiOnRydWUsIFwic2VsZWN0ZWRJdGVtXCI6c2VsZWN0ZWRJdGVtfTtcbiAgICBtb2R1bGVEYXRhLmRpYWxvZ0luZm8gPSBKU09OLnN0cmluZ2lmeShkaWMpO1xufVxuIiwiaW1wb3J0ICogYXMgY29tbW9uIGZyb20gJy4vY29tbW9uJztcbmltcG9ydCAqIGFzIG51bWJlciBmcm9tICcuL251bWJlcic7XG5cbnZhciB0ZW1wQ291cG9ucyA9IFtdXG5cbi8v5Yid5aeL5YyWXG5hc3luYyBmdW5jdGlvbiBzdGFydCgpIHtcblxufVxuXG4vL+WIneWni+WMluaVsOaNrlxuZnVuY3Rpb24gZGVmYXVsdERhdGEoKSB7XG4gICAgcmV0dXJuIHtcbiAgICAgICAgc2VsQ291cG9uOiB7fSxcbiAgICAgICAgY291cG9uczogW11cbiAgICB9O1xufVxuXG5jb25zdCB7IG1vZHVsZURhdGEsIG1vZHVsZUV2ZW50IH0gPSBjb21tb24ubW9kdWxlRGVmaW5lKFwiY291cG9uTGlzdERpYWxvZ1wiLCBzdGFydCwgZGVmYXVsdERhdGEpO1xuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gcmVmcmVzaENvdXBvbnMocGFyYW1zKSB7XG4gICAgY29uc3QgY291cG9uRGF0YSA9IEpTT04ucGFyc2UocGFyYW1zLnJlcGxhY2UoL1xcbi9nLCAnXFxcXG4nKSlcbiAgICBpZiAoIWNvdXBvbkRhdGEgfHwgY291cG9uRGF0YSA9PSBudWxsKSByZXR1cm5cbiAgICBjb25zdCB7IGN1cnJlbnRJZCwgY291cG9ucyB9ID0gY291cG9uRGF0YVxuICAgIHRlbXBDb3Vwb25zID0gW11cbiAgICBoYW5kbGVDb3Vwb25EYXRhKGN1cnJlbnRJZCwgY291cG9ucylcbiAgICBjb25zb2xlLmxvZyhgY291cG9uTGlzdERhdGEtLT4+IGNvdXBvbnMgPSAke0pTT04uc3RyaW5naWZ5KHRlbXBDb3Vwb25zKX1gKVxuICAgIG1vZHVsZURhdGEuY291cG9ucyA9IHRlbXBDb3Vwb25zXG59XG5cbmZ1bmN0aW9uIGhhbmRsZUNvdXBvbkRhdGEoY3VycmVudElkLCBjb3Vwb25MaXN0KSB7XG4gICAgaWYgKCFjb3Vwb25MaXN0IHx8IGNvdXBvbkxpc3QgPT0gbnVsbCkgcmV0dXJuXG4gICAgY291cG9uTGlzdC5zb3J0KChhLCBiKSA9PiB7XG4gICAgICAgIGlmIChwYXJzZUludChhLnR5cGUpID09PSA5ICYmIHBhcnNlSW50KGIudHlwZSkgPT09IDEyKSB7XG4gICAgICAgICAgICByZXR1cm4gLTFcbiAgICAgICAgfSBlbHNlIGlmIChwYXJzZUludChhLnR5cGUpID09PSAxMiAmJiBwYXJzZUludChiLnR5cGUpID09PSA5KSB7XG4gICAgICAgICAgICByZXR1cm4gMVxuICAgICAgICB9IGVsc2UgaWYgKHBhcnNlSW50KGEudHlwZSkgPT09IHBhcnNlSW50KGIudHlwZSkpIHtcbiAgICAgICAgICAgIHJldHVybiBwYXJzZUludChudW1iZXIuc3VidHJhY3QoYS52YWxpZEF0LCBiLnZhbGlkQXQpKVxuICAgICAgICB9XG4gICAgICAgIHJldHVybiAwXG4gICAgfSlcbiAgICBtb2R1bGVEYXRhLnNlbENvdXBvbiA9IHt9XG4gICAgbW9kdWxlRGF0YS5idG5CYWNrZ3JvdW5kID0gXCJAY29sb3IvZUNvbG9ySW5wdXRGaWxsRGlzYWJsZWRcIlxuICAgIG1vZHVsZURhdGEuYnRuQ29sb3IgPSBcIkBjb2xvci9rQ29sb3JUaHJlZUxldmVsVGV4dFwiXG4gICAgZm9yIChsZXQgaSA9IDA7IGkgPCBjb3Vwb25MaXN0Lmxlbmd0aDsgKytpKSB7XG4gICAgICAgIGxldCB2ID0gY291cG9uTGlzdFtpXVxuICAgICAgICB2LmluZGV4ID0gaVxuICAgICAgICBpZiAocGFyc2VJbnQoY3VycmVudElkKSA9PSBwYXJzZUludCh2LmlkKSB8fCBwYXJzZUludChjdXJyZW50SWQpID09IHBhcnNlSW50KHYubGlzdElkKSkge1xuICAgICAgICAgICAgdi5zZWxlY3RlZCA9IHRydWVcbiAgICAgICAgICAgIHYudW5TZWxlY3RlZEltYWdlVmlzaWJpbGl0eSA9IFwiZ29uZVwiXG4gICAgICAgICAgICB2LnNlbGVjdGVkSW1hZ2VWaXNpYmlsaXR5ID0gXCJ2aXNpYmxlXCJcbiAgICAgICAgICAgIG1vZHVsZURhdGEuc2VsQ291cG9uID0gdlxuICAgICAgICAgICAgbW9kdWxlRGF0YS5idG5CYWNrZ3JvdW5kID0gXCJAY29sb3Iva0NvbG9yTWFqb3JUaGVtZTEwMFwiXG4gICAgICAgICAgICBtb2R1bGVEYXRhLmJ0bkNvbG9yID0gXCJAY29sb3IvS0Jhc2VUZXh0Q29sb3JcIlxuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgdi5zZWxlY3RlZCA9IGZhbHNlXG4gICAgICAgICAgICB2LnVuU2VsZWN0ZWRJbWFnZVZpc2liaWxpdHkgPSBcInZpc2libGVcIlxuICAgICAgICAgICAgdi5zZWxlY3RlZEltYWdlVmlzaWJpbGl0eSA9IFwiZ29uZVwiXG4gICAgICAgIH1cbiAgICAgICAgdi51bmZvbGQgPSBmYWxzZTtcbiAgICAgICAgdi51bmZvbGRWaXNpYmlsaXR5ID0gXCJnb25lXCJcbiAgICAgICAgdi5mb2xkVmlzaWJpbGl0eSA9IFwidmlzaWJsZVwiXG4gICAgICAgIGlmICh2LnZhbGlkQXQgPiAwKSB7XG4gICAgICAgICAgICB2LnRpbWUgPSAkaTE4bi4kaW50ZXJjZXB0Lm5fY291cG9uX3RpbWVfZGVhbGluZShuZXcgRGF0ZSh2LnZhbGlkQXQpLkZvcm1hdChcInl5eXktTU0tZGRcIikpXG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICB2LnRpbWUgPSAnLS0nXG4gICAgICAgIH1cbiAgICAgICAgaWYgKHBhcnNlSW50KHYudHlwZSkgPT0gOSkge1xuICAgICAgICAgICAgdi50eXBlID0gXCJjb3Vwb25cIlxuICAgICAgICAgICAgaW5pdENvdXBvbkRhdGEodilcbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIHYudHlwZSA9IFwiZGlzY291bnRcIlxuICAgICAgICAgICAgaW5pdERpc2NvdW50RGF0YSh2KVxuICAgICAgICB9XG4gICAgICAgIHRlbXBDb3Vwb25zLnB1c2godilcbiAgICB9XG59XG5cbmZ1bmN0aW9uIGluaXRDb3Vwb25EYXRhKGNvdXBvbikge1xuICAgIGNvdXBvbi5iYXNlQ3VycmVuY3kgPSBjb3Vwb24uYmFzZUN1cnJlbmN5LnRvVXBwZXJDYXNlKCk7XG59XG5cbmZ1bmN0aW9uIGluaXREaXNjb3VudERhdGEoZGlzY291bnQpIHtcbiAgICBpZiAoZGlzY291bnQuYW1vdW50ID4gMCkge1xuICAgICAgICBpZiAocGFyc2VJbnQoZGlzY291bnQuYW1vdW50KSA9PSAxMDApIHtcbiAgICAgICAgICAgIGRpc2NvdW50LmZlZSA9ICRpMThuLm5fdHJhbnNhY3Rpb25faW50ZXJlc3RfZnJlZVxuICAgICAgICB9IGVsc2UgaWYgKGNvbW1vbi5jb21tb25EYXRhLmxhbmd1YWdlLnRvTG93ZXJDYXNlKCkuc3RhcnRzV2l0aChcInpoLVwiKSkge1xuICAgICAgICAgICAgZGlzY291bnQuZmVlID0gYCR7JGkxOG4uJGludGVyY2VwdC5uX3RyYW5zYWN0aW9uX2ZlZSgoKDEwMCAtIHBhcnNlRmxvYXQoZGlzY291bnQuYW1vdW50KSkgLyAxMCkudG9GaXhlZCgxKSl9YFxuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgZGlzY291bnQuZmVlID0gYCR7JGkxOG4uJGludGVyY2VwdC5uX3RyYW5zYWN0aW9uX2ZlZShwYXJzZUZsb2F0KGRpc2NvdW50LmFtb3VudCkudG9GaXhlZCgwKS50b1N0cmluZygpICsgXCIlXCIpfWBcbiAgICAgICAgfVxuICAgIH0gZWxzZSB7XG4gICAgICAgIGRpc2NvdW50LmZlZSA9IFwiLS1cIlxuICAgIH1cbiAgICBpZiAoZGlzY291bnQuc3RhdGUgPT0gMCkge1xuICAgICAgICBkaXNjb3VudC5zdGF0ZVRleHQgPSAkaTE4bi5uX2NvdXBvbl9zdGF0ZV9ub3RfdXNlXG4gICAgfSBlbHNlIHtcbiAgICAgICAgZGlzY291bnQuc3RhdGVUZXh0ID0gJGkxOG4ubl9jb3Vwb25fc3RhdGVfdXNpbmdcbiAgICB9XG59XG5cbm1vZHVsZUV2ZW50LnVuZm9sZFJ1bGVzVGFwQWN0aW9uID0gZnVuY3Rpb24gKGluZGV4KSB7XG4gICAgZm9yICh2YXIgaSA9IDA7IGkgPCB0ZW1wQ291cG9ucy5sZW5ndGg7IGkrKykge1xuICAgICAgICB2YXIgaXRlbSA9IHRlbXBDb3Vwb25zW2ldO1xuICAgICAgICBpZiAoaSA9PSBpbmRleCkge1xuICAgICAgICAgICAgaXRlbS51bmZvbGQgPSAhaXRlbS51bmZvbGQ7XG4gICAgICAgICAgICBpdGVtLnVuZm9sZFZpc2liaWxpdHkgPSBpdGVtLnVuZm9sZCA/IFwidmlzaWJsZVwiIDogXCJnb25lXCI7XG4gICAgICAgICAgICBpdGVtLmZvbGRWaXNpYmlsaXR5ID0gaXRlbS51bmZvbGQgPyBcImdvbmVcIiA6IFwidmlzaWJsZVwiO1xuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgaXRlbS51bmZvbGQgPSBmYWxzZTtcbiAgICAgICAgICAgIGl0ZW0udW5mb2xkVmlzaWJpbGl0eSA9IFwiZ29uZVwiO1xuICAgICAgICAgICAgaXRlbS5mb2xkVmlzaWJpbGl0eSA9IFwidmlzaWJsZVwiO1xuICAgICAgICB9XG4gICAgfVxuICAgIG1vZHVsZURhdGEuY291cG9ucyA9IHRlbXBDb3Vwb25zO1xufVxuXG5tb2R1bGVFdmVudC5jb3Vwb25UYXBBY3Rpb24gPSBmdW5jdGlvbiAoaW5kZXgpIHtcbiAgICBmb3IgKHZhciBpID0gMDsgaSA8IHRlbXBDb3Vwb25zLmxlbmd0aDsgaSsrKSB7XG4gICAgICAgIHZhciBpdGVtID0gdGVtcENvdXBvbnNbaV07XG4gICAgICAgIGlmIChpdGVtLnR5cGUgPT0gXCJjb3Vwb25cIikge1xuICAgICAgICAgICAgaWYgKGkgPT0gaW5kZXgpIHtcbiAgICAgICAgICAgICAgICBpdGVtLnNlbGVjdGVkID0gIWl0ZW0uc2VsZWN0ZWQ7XG4gICAgICAgICAgICAgICAgaXRlbS51blNlbGVjdGVkSW1hZ2VWaXNpYmlsaXR5ID0gaXRlbS5zZWxlY3RlZCA/IFwiZ29uZVwiIDogXCJ2aXNpYmxlXCI7XG4gICAgICAgICAgICAgICAgaXRlbS5zZWxlY3RlZEltYWdlVmlzaWJpbGl0eSA9IGl0ZW0uc2VsZWN0ZWQgPyBcInZpc2libGVcIiA6IFwiZ29uZVwiO1xuICAgICAgICAgICAgICAgIGlmIChpdGVtLnNlbGVjdGVkKSB7XG4gICAgICAgICAgICAgICAgICAgIG1vZHVsZURhdGEuc2VsQ291cG9uID0gaXRlbVxuICAgICAgICAgICAgICAgICAgICBtb2R1bGVEYXRhLmJ0bkJhY2tncm91bmQgPSBcIkBjb2xvci9rQ29sb3JNYWpvclRoZW1lMTAwXCJcbiAgICAgICAgICAgICAgICAgICAgbW9kdWxlRGF0YS5idG5Db2xvciA9IFwiQGNvbG9yL0tCYXNlVGV4dENvbG9yXCJcbiAgICAgICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgICAgICBtb2R1bGVEYXRhLnNlbENvdXBvbiA9IHt9XG4gICAgICAgICAgICAgICAgICAgIG1vZHVsZURhdGEuYnRuQmFja2dyb3VuZCA9IFwiQGNvbG9yL2VDb2xvcklucHV0RmlsbERpc2FibGVkXCJcbiAgICAgICAgICAgICAgICAgICAgbW9kdWxlRGF0YS5idG5Db2xvciA9IFwiQGNvbG9yL2tDb2xvclRocmVlTGV2ZWxUZXh0XCJcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgIGl0ZW0uc2VsZWN0ZWQgPSBmYWxzZTtcbiAgICAgICAgICAgICAgICBpdGVtLnVuU2VsZWN0ZWRJbWFnZVZpc2liaWxpdHkgPSBcInZpc2libGVcIjtcbiAgICAgICAgICAgICAgICBpdGVtLnNlbGVjdGVkSW1hZ2VWaXNpYmlsaXR5ID0gXCJnb25lXCI7XG4gICAgICAgICAgICB9XG4gICAgICAgIH1cbiAgICB9XG4gICAgbW9kdWxlRGF0YS5jb3Vwb25zID0gdGVtcENvdXBvbnM7XG59XG5cbm1vZHVsZUV2ZW50LnBvcENvbmZpcm0gPSBmdW5jdGlvbiAoKSB7XG4gICAgaWYgKG1vZHVsZURhdGEuc2VsQ291cG9uLmlkICE9IG51bGwgJiYgbW9kdWxlRGF0YS5zZWxDb3Vwb24uaWQgIT0gXCJ1bmRlZmluZWRcIiAmJiBtb2R1bGVEYXRhLnNlbENvdXBvbi5pZCAhPSBcIlwiKSB7XG4gICAgICAgIGxldCBjb3Vwb25EYXRhID0gSlNPTi5zdHJpbmdpZnkobW9kdWxlRGF0YS5zZWxDb3Vwb24ucmF3T2JqZWN0KCkpLnJlcGxhY2UoXCJcXFwidHlwZVxcXCI6XFxcImNvdXBvblxcXCJcIiwgXCJcXFwidHlwZVxcXCI6OVwiKS5yZXBsYWNlKFwiXFxcInR5cGVcXFwiOlxcXCJkaXNjb3VudFxcXCJcIiwgXCJcXFwidHlwZVxcXCI6MTJcIilcbiAgICAgICAgbW9kdWxlRGF0YS5jb25maXJtRGF0YSA9IGB7XCJjb25maXJtXCI6dHJ1ZSwgXCJjdXJyZW50Q291cG9uXCI6JHtjb3Vwb25EYXRhfX1gXG4gICAgfVxufVxuXG5tb2R1bGVFdmVudC5wb3BEaXNtaXNzID0gZnVuY3Rpb24gKCkge1xuICAgIG1vZHVsZURhdGEuY29uZmlybURhdGEgPSBge1wiY29uZmlybVwiOmZhbHNlfWBcbn0iLCJpbXBvcnQgKiBhcyBjb21tb24gZnJvbSAnLi9jb21tb24nO1xuXG5cbi8v5Yid5aeL5YyWXG5hc3luYyBmdW5jdGlvbiBzdGFydCgpIHtcblxufVxuXG4vL+WIneWni+WMluaVsOaNrlxuZnVuY3Rpb24gZGVmYXVsdERhdGEoKSB7XG4gbGV0IGNvbG9yID0gY29tbW9uLmNvbW1vbkRhdGEuY29sb3JNb2RlID8gXCIjRTZFNkU2XCIgOiBcIiMwMDAwMDBcIlxuIGxldCBkZXNjID0gJyR7JGkxOG4ubl91bml0X2Fzc2V0X2RldGFpbF9kZXNjfSdcbiAgICBjb25zb2xlLmxvZyhgcHVibGljIGNvbXBvbmVudHMgZGVmYXVsdERhdGEgICR7Y29tbW9uLmNvbW1vbkRhdGEud2ViVXJsfWApXG4gICAgcmV0dXJuIHtcbiAgICAgICAgc2luZ2xlQm9yZGVyQ29sb3I6XCJAY29sb3Iva0NvbG9yTWFqb3JUaGVtZTEwMFwiLFxuICAgICAgICB1bmlvbkJvcmRlckNvbG9yOlwiQGNvbG9yL2Jhc2VDb2xvcklucHV0QmFja2dyb3VuZFwiLFxuICAgICAgICByaWNoVGV4dERhdGE6IFwiXCJcbiAgICB9O1xufVxuY29uc3QgeyBtb2R1bGVEYXRhLCBtb2R1bGVFdmVudCB9ID0gY29tbW9uLm1vZHVsZURlZmluZShcImJvdHRvbVVuaW9uUGF0dGVybkRpYWxvZ1wiLCBzdGFydCwgZGVmYXVsdERhdGEpO1xuXG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiByZWZyZXNoQXNzZXREYXRhKGFyZ3MpIHtcbiAgICBjb25zb2xlLmxvZyhgcHVibGljIGNvbXBvbmVudHMgZGVmYXVsdERhdGEgICR7YXJnc31gKVxuICAgIGNvbnN0IHBhcmFtcyA9IEpTT04ucGFyc2UoYXJncyk7XG4gICAgY29uc29sZS5sb2cocGFyYW1zKTtcbiAgICAgaWYgKHBhcmFtcy5pc1VuaW9uID09PSBcIjFcIikge1xuICAgICAgICBjb25zb2xlLmxvZyhcIui/m+WFpeiBlOWQiOS/neivgemHkVwiKTtcbiAgICAgICAgbW9kdWxlRGF0YS5zaW5nbGVCb3JkZXJDb2xvciA9IFwiQGNvbG9yL2Jhc2VDb2xvcklucHV0QmFja2dyb3VuZFwiO1xuICAgICAgICBtb2R1bGVEYXRhLnVuaW9uQm9yZGVyQ29sb3IgPSBcIkBjb2xvci9rQ29sb3JNYWpvclRoZW1lMTAwXCI7XG4gICAgIH0gZWxzZSB7XG4gICAgICAgIGNvbnNvbGUubG9nKFwi6L+b5YWl5Y2V5biB5L+d6K+B6YeRXCIpO1xuICAgICAgICBtb2R1bGVEYXRhLnNpbmdsZUJvcmRlckNvbG9yID0gXCJAY29sb3Iva0NvbG9yTWFqb3JUaGVtZTEwMFwiO1xuICAgICAgICBtb2R1bGVEYXRhLnVuaW9uQm9yZGVyQ29sb3IgPSBcIkBjb2xvci9iYXNlQ29sb3JJbnB1dEJhY2tncm91bmRcIjtcbiAgICAgfVxuICAgICBtb2R1bGVEYXRhLnJpY2hUZXh0RGF0YSA9IGB7XCJjb250ZW50XCI6XCJuX3VuaXRfYXNzZXRfZGV0YWlsX2Rlc2NcIixcInRleHRDb2xvclwiOlwiS0Jhc2VDb2xvclNlY29uZGFyeVRleHRcIixcInRleHRTaXplXCI6MTIsXCJoaWdobGlnaHRcIjpbe1wiY29udGVudFwiOlwibl91bml0X2Fzc2V0X2RldGFpbF9saW1pdFwiLFwibGlua1wiOlwiXCIsXCJ0ZXh0Q29sb3JcIjpcImtDb2xvclByaW1hcnlUZXh0XCIsXCJ0ZXh0U2l6ZVwiOjEyfSx7XCJjb250ZW50XCI6XCJuX3VuaXRfYXNzZXRfZGV0YWlsX2xpbmtcIixcImxpbmtcIjpcIiR7Y29tbW9uLmNvbW1vbkRhdGEud2ViVXJsfS8ke2NvbW1vbi5jb21tb25EYXRhLmxhbmd1YWdlfS9zdXBwb3J0LzQ1MDAwMzA4MjA3MTM4XCIsXCJ0ZXh0Q29sb3JcIjpcImtDb2xvck1ham9yVGhlbWUxMDBcIixcInRleHRTaXplXCI6MTJ9XX1gXG59XG5cbm1vZHVsZUV2ZW50LnBvcERpc21pc3MgPSBmdW5jdGlvbiAoKSB7XG4gICAgdmFyIGRpYyA9IHtcImNsb3NlQWxlcnRcIjp0cnVlfTtcbiAgICBtb2R1bGVEYXRhLmRpYWxvZ0luZm8gPSBKU09OLnN0cmluZ2lmeShkaWMpO1xufVxuXG5tb2R1bGVFdmVudC5yaWNoVGV4dExpbmtDYWxsYmFjayA9IGZ1bmN0aW9uICgpIHtcbiAgICB2YXIgZGljID0ge1wiY2xvc2VBbGVydFwiOnRydWV9O1xuICAgIG1vZHVsZURhdGEuZGlhbG9nSW5mbyA9IEpTT04uc3RyaW5naWZ5KGRpYyk7XG59XG5cbm1vZHVsZUV2ZW50LnBpY2tTaW5nbGUgPSBmdW5jdGlvbiAoKSB7XG4gICAgaWYgKG1vZHVsZURhdGEuc2luZ2xlQm9yZGVyQ29sb3IgPT09IFwiQGNvbG9yL2tDb2xvck1ham9yVGhlbWUxMDBcIiApIHtcbiAgICAgICAgcmV0dXJuIDtcbiAgICB9XG4gICAgbW9kdWxlRGF0YS5zaW5nbGVCb3JkZXJDb2xvciA9IFwiQGNvbG9yL2tDb2xvck1ham9yVGhlbWUxMDBcIjtcbiAgICBtb2R1bGVEYXRhLnVuaW9uQm9yZGVyQ29sb3IgPSBcIkBjb2xvci9iYXNlQ29sb3JJbnB1dEJhY2tncm91bmRcIjtcbiAgICBcbiAgICB2YXIgZGljID0ge1wiaXNVbmlvblwiOmZhbHNlfTtcbiAgICBtb2R1bGVEYXRhLmRpYWxvZ0luZm8gPSBKU09OLnN0cmluZ2lmeShkaWMpO1xufVxuXG5tb2R1bGVFdmVudC5waWNrVW5pb24gPSBmdW5jdGlvbiAoKSB7XG4gICAgaWYgKG1vZHVsZURhdGEudW5pb25Cb3JkZXJDb2xvciA9PT0gXCJAY29sb3Iva0NvbG9yTWFqb3JUaGVtZTEwMFwiICkge1xuICAgICAgICByZXR1cm47XG4gICAgfVxuICAgIG1vZHVsZURhdGEuc2luZ2xlQm9yZGVyQ29sb3IgPSBcIkBjb2xvci9iYXNlQ29sb3JJbnB1dEJhY2tncm91bmRcIjtcbiAgICBtb2R1bGVEYXRhLnVuaW9uQm9yZGVyQ29sb3IgPSBcIkBjb2xvci9rQ29sb3JNYWpvclRoZW1lMTAwXCI7XG5cbiAgICB2YXIgZGljID0ge1wiaXNVbmlvblwiOnRydWV9O1xuICAgIG1vZHVsZURhdGEuZGlhbG9nSW5mbyA9IEpTT04uc3RyaW5naWZ5KGRpYyk7XG59IiwiaW1wb3J0ICogYXMgY29tbW9uIGZyb20gXCIuL2NvbW1vblwiO1xuaW1wb3J0ICogYXMgYm90dG9tTGlzdFJhZGlvRGlhbG9nIGZyb20gXCIuL2JvdHRvbUxpc3RSYWRpb0RpYWxvZ1wiO1xuaW1wb3J0ICogYXMgY291cG9uTGlzdERpYWxvZyBmcm9tIFwiLi9jb3Vwb25MaXN0RGlhbG9nXCI7XG5pbXBvcnQgKiBhcyBib3R0b21VbmlvblBhdHRlcm5EaWFsb2cgZnJvbSBcIi4vYm90dG9tVW5pb25QYXR0ZXJuRGlhbG9nXCI7XG5cbmZ1bmN0aW9uIHNlbmRDb21tb25Db25maWcocGFyYW0pIHtcbiAgICBjb21tb24uc2VuZENvbW1vbkNvbmZpZyhwYXJhbSk7XG59XG5cbmFzeW5jIGZ1bmN0aW9uIG1vZHVsZUFwcGVhcigpIHtcbiAgICBjb25zb2xlLmxvZygnbWFpbi1tb2R1bGVBcHBlYXInKTtcbn1cblxuZnVuY3Rpb24gbW9kdWxlV2lsbERpc2FwcGVhcigpIHtcbiAgICBjb25zb2xlLmxvZygnbWFpbi1tb2R1bGVXaWxsRGlzYXBwZWFyJyk7XG59XG5cbmFzeW5jIGZ1bmN0aW9uIG1vZHVsZURpc2FwcGVhcigpIHtcbiAgICBjb25zb2xlLmxvZygnbWFpbi1tb2R1bGVEaXNhcHBlYXInKTtcbn1cblxuYXN5bmMgZnVuY3Rpb24gc2VuZFNvY2tldERhdGEoZGF0YSkge1xuICAgIGlmIChkYXRhLnR5cGUgPT0gXCJtYXJrZXRcIikge1xuICAgICAgICBjb21tb24uY29tbW9uRGF0YS5tYXJrZXREYXRhID0gSlNPTi5wYXJzZShkYXRhLmRhdGEpO1xuICAgIH0gZWxzZSBpZiAoZGF0YS50eXBlID09IFwibGluZWFyU3dhcFdzXCIpIHtcbiAgICAgICAgY29tbW9uLmNvbW1vbkRhdGEubGluZWFyU3dhcFdzRGF0YSA9IEpTT04ucGFyc2UoZGF0YS5kYXRhKTtcbiAgICB9XG59XG5cbmFzeW5jIGZ1bmN0aW9uIHJlZnJlc2hCb3R0b21EYXRhKHBhcmFtcykge1xuICAgIGJvdHRvbUxpc3RSYWRpb0RpYWxvZy5yZWZyZXNoRGF0YShwYXJhbXMpO1xufVxuXG5hc3luYyBmdW5jdGlvbiByZWZyZXNoQ291cG9ucyhwYXJhbXMpIHtcbiAgICBjb3Vwb25MaXN0RGlhbG9nLnJlZnJlc2hDb3Vwb25zKHBhcmFtcyk7XG59XG5cbmFzeW5jIGZ1bmN0aW9uIHJlZnJlc2hBc3NldERhdGEocGFyYW1zKSB7XG4gICAgYm90dG9tVW5pb25QYXR0ZXJuRGlhbG9nLnJlZnJlc2hBc3NldERhdGEocGFyYW1zKTtcbn1cblxuJGV2ZW50LnNlbmRDb21tb25Db25maWcgPSBzZW5kQ29tbW9uQ29uZmlnO1xuJGV2ZW50Lm1vZHVsZUFwcGVhciA9IG1vZHVsZUFwcGVhcjtcbiRldmVudC5tb2R1bGVXaWxsRGlzYXBwZWFyID0gbW9kdWxlV2lsbERpc2FwcGVhcjtcbiRldmVudC5tb2R1bGVEaXNhcHBlYXIgPSBtb2R1bGVEaXNhcHBlYXI7XG4kZXZlbnQuc2VuZFNvY2tldERhdGEgPSBzZW5kU29ja2V0RGF0YTtcbiRldmVudC5yZWZyZXNoQm90dG9tRGF0YSA9IHJlZnJlc2hCb3R0b21EYXRhO1xuJGV2ZW50LnJlZnJlc2hBc3NldERhdGEgPSByZWZyZXNoQXNzZXREYXRhO1xuJGV2ZW50LnJlZnJlc2hDb3Vwb25zID0gcmVmcmVzaENvdXBvbnM7XG4iXSwibmFtZXMiOlsiRFAiLCJSTSIsIk1BWF9EUCIsIk1BWF9QT1dFUiIsIk5FIiwiUEUiLCJOQU1FIiwiSU5WQUxJRCIsIklOVkFMSURfRFAiLCJJTlZBTElEX1JNIiwiRElWX0JZX1pFUk8iLCJQIiwiVU5ERUZJTkVEIiwiTlVNRVJJQyIsIl9CaWdfIiwiQmlnIiwibiIsIngiLCJ0aGlzIiwicyIsImUiLCJjIiwic2xpY2UiLCJwYXJzZSIsImNvbnN0cnVjdG9yIiwicHJvdG90eXBlIiwidmVyc2lvbiIsImkiLCJubCIsInRlc3QiLCJFcnJvciIsImNoYXJBdCIsImluZGV4T2YiLCJyZXBsYWNlIiwic2VhcmNoIiwic3Vic3RyaW5nIiwibGVuZ3RoIiwicm91bmQiLCJkcCIsInJtIiwibW9yZSIsInhjIiwidW5zaGlmdCIsInBvcCIsInN0cmluZ2lmeSIsImlkIiwiayIsInoiLCJwdXNoIiwiam9pbiIsImFicyIsImNtcCIsInkiLCJpc25lZyIsInljIiwiaiIsImwiLCJkaXYiLCJhIiwiYiIsImJsIiwiYnQiLCJyaSIsImJ6IiwiYWkiLCJhbCIsInIiLCJybCIsInEiLCJxYyIsInFpIiwiZCIsInNoaWZ0IiwiZXEiLCJndCIsImd0ZSIsImx0IiwibHRlIiwibWludXMiLCJzdWIiLCJ0IiwieGx0eSIsInBsdXMiLCJ4ZSIsInllIiwicmV2ZXJzZSIsIm1vZCIsInlndHgiLCJ0aW1lcyIsImFkZCIsInBvdyIsIm9uZSIsInNxcnQiLCJoYWxmIiwiTWF0aCIsInRvRXhwb25lbnRpYWwiLCJtdWwiLCJBcnJheSIsInRvRml4ZWQiLCJ0b1ByZWNpc2lvbiIsInNkIiwidG9TdHJpbmciLCJ2YWx1ZU9mIiwidG9KU09OIiwic3VidHJhY3QiLCJjb21tb25EYXRhIiwidXNlclNpZ24iLCJjdXJyZW50U3ltYm9sIiwiY3VycmVudENvbnRyYWN0SW5mbyIsImNvbnRyYWN0SW5mb0RhdGEiLCJjb250cmFjdEg1VXJsIiwiY3VycmVuY3lSYXRlIiwiY3VycmVuY3lDaGFyYWN0ZXIiLCJwcmljZUNvbG9yVHlwZSIsImNvbG9yTW9kZSIsIk9TIiwiYXBwVmVyc2lvbiIsImlzSW5SZXZpZXciLCJpc0xvZ2luIiwid2ViVXJsIiwibGFuZ3VhZ2UiLCJwYWdlVHlwZSIsImNvbnRyYWN0VHlwZSIsInVzZXJJbmZvIiwiYXN5bmMiLCJyZWFkIiwibW9kdWxlIiwia2V5IiwiZGF0YSIsIiRuYXRpdmVBUEkiLCJzdG9yYWdlIiwiYWN0aW9uIiwibmFtZSIsIkpTT04iLCJzZW5kQ29tbW9uQ29uZmlnIiwicGFyYW0iLCJjb25zb2xlIiwibG9nIiwic2F2ZWRTeW1ib2wiLCJwYXJzZUludCIsImg1VXJsIiwibW9kdWxlRGVmaW5lIiwibW9kdWxlTmFtZSIsInN0YXJ0RnVuY3Rpb24iLCJkZWZhdWx0RGF0YUZ1bmN0aW9uIiwiJGRhdGEiLCIkZXZlbnQiLCJzdGFydCIsIm1vZHVsZUV2ZW50IiwibW9kdWxlRGF0YSIsIkRhdGUiLCJGb3JtYXQiLCJmbXQiLCJvIiwiZ2V0TW9udGgiLCJnZXREYXRlIiwiZ2V0SG91cnMiLCJnZXRNaW51dGVzIiwiZ2V0U2Vjb25kcyIsImZsb29yIiwiUyIsImdldE1pbGxpc2Vjb25kcyIsIlJlZ0V4cCIsIiQxIiwiZ2V0RnVsbFllYXIiLCJzdWJzdHIiLCJjdXJMaXN0IiwiZGVmYXVsdERhdGEiLCJsaXN0IiwiY29tbW9uLm1vZHVsZURlZmluZSIsInJlZnJlc2hEYXRhIiwiYXJncyIsInBhcmFtcyIsInRvcFRpdGxlIiwiaXRlbSIsImluZGV4IiwidW5TZWxlY3RlZEltYWdlVmlzaWJpbGl0eSIsInNlbGVjdGVkSW1hZ2VWaXNpYmlsaXR5IiwidHlwZSIsInNlbGVjdGVkIiwicG9wRGlzbWlzcyIsImRpYyIsImNsb3NlQWxlcnQiLCJkaWFsb2dJbmZvIiwidHlwZVRhcEFjdGlvbiIsInNlbGVjdGVkSXRlbSIsImNvbmZpcm1BbGVydCIsInRlbXBDb3Vwb25zIiwic2VsQ291cG9uIiwiY291cG9ucyIsInJlZnJlc2hDb3Vwb25zIiwiY291cG9uRGF0YSIsImN1cnJlbnRJZCIsImhhbmRsZUNvdXBvbkRhdGEiLCJjb3Vwb25MaXN0Iiwic29ydCIsIm51bWJlci5zdWJ0cmFjdCIsInZhbGlkQXQiLCJidG5CYWNrZ3JvdW5kIiwiYnRuQ29sb3IiLCJ2IiwibGlzdElkIiwidW5mb2xkIiwidW5mb2xkVmlzaWJpbGl0eSIsImZvbGRWaXNpYmlsaXR5IiwidGltZSIsIiRpMThuIiwiJGludGVyY2VwdCIsIm5fY291cG9uX3RpbWVfZGVhbGluZSIsImluaXRDb3Vwb25EYXRhIiwiaW5pdERpc2NvdW50RGF0YSIsImNvdXBvbiIsImJhc2VDdXJyZW5jeSIsInRvVXBwZXJDYXNlIiwiZGlzY291bnQiLCJhbW91bnQiLCJmZWUiLCJuX3RyYW5zYWN0aW9uX2ludGVyZXN0X2ZyZWUiLCJjb21tb24uY29tbW9uRGF0YSIsInRvTG93ZXJDYXNlIiwic3RhcnRzV2l0aCIsIm5fdHJhbnNhY3Rpb25fZmVlIiwicGFyc2VGbG9hdCIsInN0YXRlIiwic3RhdGVUZXh0Iiwibl9jb3Vwb25fc3RhdGVfbm90X3VzZSIsIm5fY291cG9uX3N0YXRlX3VzaW5nIiwidW5mb2xkUnVsZXNUYXBBY3Rpb24iLCJjb3Vwb25UYXBBY3Rpb24iLCJwb3BDb25maXJtIiwicmF3T2JqZWN0IiwiY29uZmlybURhdGEiLCJzaW5nbGVCb3JkZXJDb2xvciIsInVuaW9uQm9yZGVyQ29sb3IiLCJyaWNoVGV4dERhdGEiLCJyZWZyZXNoQXNzZXREYXRhIiwiaXNVbmlvbiIsInJpY2hUZXh0TGlua0NhbGxiYWNrIiwicGlja1NpbmdsZSIsInBpY2tVbmlvbiIsImNvbW1vbi5zZW5kQ29tbW9uQ29uZmlnIiwibW9kdWxlQXBwZWFyIiwibW9kdWxlV2lsbERpc2FwcGVhciIsIm1vZHVsZURpc2FwcGVhciIsInNlbmRTb2NrZXREYXRhIiwibWFya2V0RGF0YSIsImxpbmVhclN3YXBXc0RhdGEiLCJyZWZyZXNoQm90dG9tRGF0YSIsImJvdHRvbUxpc3RSYWRpb0RpYWxvZy5yZWZyZXNoRGF0YSIsImNvdXBvbkxpc3REaWFsb2cucmVmcmVzaENvdXBvbnMiLCJib3R0b21VbmlvblBhdHRlcm5EaWFsb2cucmVmcmVzaEFzc2V0RGF0YSJdLCJtYXBwaW5ncyI6IkFBaUJBLElBQUlBLEtBQUssSUFVUEMsS0FBSyxHQUdMQyxTQUFTLEtBR1RDLFlBQVksS0FPWkMsTUFBTSxHQVFOQyxLQUFLLElBT0xDLE9BQU8sYUFDUEMsVUFBVUQsT0FBTyxZQUNqQkUs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
