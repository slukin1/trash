var MAX_DP = 1e6, MAX_POWER = 1e6, NAME = "[big.js] ", INVALID = NAME + "Invalid ", INVALID_DP = INVALID + "decimal places", INVALID_RM = INVALID + "rounding mode", DIV_BY_ZERO = NAME + "Division by zero", P = {}, UNDEFINED = void 0;

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

var clickable = true;

var commonData = {
    priceColorType: 0,
    colorMode: 0,
    OS: 0,
    webUrl: "",
    appVersion: "",
    isInReview: 1,
    isLogin: 0,
    language: ""
};

async function sendCommonConfig$1(param) {
    if (param == null) return;
    console.log(param);
    commonData.priceColorType = parseInt(param.priceColorType);
    commonData.colorMode = parseInt(param.colorMode);
    commonData.OS = parseInt(param.OS);
    commonData.appVersion = param.appVersion;
    commonData.isInReview = parseInt(param.isInReview);
    commonData.language = param.language;
    commonData.isLogin = parseInt(param.isLogin);
    commonData.webUrl = param.webUrl;
    var redColorList = [ "#ADB0B2", "#E94359", "#DE2941", "#CE142B" ];
    var greenColorList = [ "#ADB0B2", "#00A171", "#008B61", "#006245" ];
    if (parseInt(commonData.priceColorType) == 0) {
        upColorList = redColorList;
        downColorList = greenColorList;
    } else {
        upColorList = greenColorList;
        downColorList = redColorList;
    }
}

async function sendRequest(path, params = {}, method = 0, hostType = 0, header = {}) {
    console.log(`request ${path}, params:${JSON.stringify(params)}`);
    if (hostType == 5 || hostType == 6) {
        header["Content-Type"] = "application/json";
    }
    const param = {
        path: path,
        method: method,
        hostType: hostType,
        header: header,
        params: params
    };
    try {
        var responseString = await $nativeAPI.request(JSON.stringify(param));
        var response = JSON.parse(responseString);
        var {code: code, data: data} = response;
        if (8 == hostType) {
            var status = response.status;
            var err_code = response.err_code;
            var err_msg = response.err_msg;
            if (status == "ok") {
                console.log(`request ${path} done`);
                if (typeof data === "number") {
                    let start = `"data":`;
                    let startIndex = responseString.indexOf(start);
                    let end = `,"ts":`;
                    let endIndex = responseString.indexOf(end);
                    let dataString = responseString.substring(startIndex + start.length, endIndex);
                    console.log(`data is typeof number, dataString = ${dataString}`);
                    return dataString;
                }
                return data;
            } else {
                console.log(`request failed, code=${err_code}, message=${err_msg}`);
                if (method != 0) {
                    showToast(err_msg);
                }
                return null;
            }
        } else if (code == 200) {
            if (data == null) {
                return response;
            }
            console.log(`request ${path} done`);
            return data;
        } else {
            console.log(`request failed, code=${code}`);
            let message = response.message;
            if (method != 0 && message) {
                showToast(message);
            }
            return null;
        }
    } catch (e) {
        console.log(`request error, error=${e}`);
        return null;
    }
}

async function openURL(url) {
    if (!clickable) {
        return;
    }
    console.log(`open url:`, url);
    if (url && url != null && url.length > 0) {
        await $nativeAPI.openRoute(url);
    }
    clickable = false;
    setTimeout((() => {
        clickable = true;
    }), 1e3);
}

async function showToast(msg) {
    await $nativeAPI.hbToast(msg);
}

async function save(module, key, data) {
    await $nativeAPI.storage({
        action: "save",
        name: module,
        key: key,
        data: JSON.stringify(data)
    });
}

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

function showLoading(isShow = true) {
    $nativeAPI.showLoading(isShow ? 1 : 0);
}

async function analytics(event = "", properties = {}) {
    const propertiesJson = JSON.stringify(properties);
    console.log(`analytics event: ${event}, propertiesJson = ${propertiesJson}`);
    var map = {
        event: event,
        properties: propertiesJson
    };
    await $nativeAPI.analytics(map);
}

function moduleDefine(moduleName, startFunction, defaultDataFunction) {
    console.log(`loadModule`, moduleName);
    $data[moduleName] = defaultDataFunction();
    $event[moduleName] = {
        start: startFunction
    };
    return {
        moduleEvent: $event[moduleName],
        moduleData: $data[moduleName]
    };
}

async function start$3() {
    console.log(`more functions pop-start`);
}

function defaultData$3() {
    return {
        marginVideoGuideJumpUrl: "",
        showMarginVideoGuide: false,
        transactionType: "",
        showUpdateDetail: false,
        isLogin: false,
        isFavorite: false,
        removePop: false,
        functionType: -1,
        clickedItem: {
            transactionType: "",
            itemType: -1
        },
        functionDeposit: 0,
        functionTransfer: 1,
        functionTradeSettings: 2,
        functionBeginnerGuide: 3,
        functionMarginGuide: 4,
        functionAboutLoan: 5,
        functionFavorite: 6,
        functionUpdateDetail: 7,
        functionRules: 8,
        functionRedeem: 9,
        functionLoan: 10,
        popShow: false
    };
}

var currencyUpdateData = {
    upDetailCurrency: "",
    upgradeCurrency: "",
    upgradeJumpUrl: "",
    upgradeDetailUrl: "",
    upgradeState: false
};

const {moduleData: moduleData$3, moduleEvent: moduleEvent$3} = moduleDefine("exchange", start$3, defaultData$3);

async function setupItems(params) {
    if (params == null) return;
    clickedFunctionItem = false;
    isPopDismiss$1 = false;
    moduleData$3.removePop = false;
    moduleData$3.functionType = -1;
    console.log(params);
    moduleData$3.transactionType = params.transactionType;
    moduleData$3.isLogin = params.isLogin == "true" ? true : false;
    moduleData$3.isFavorite = params.isFavorite == "true" ? true : false;
    moduleData$3.showMarginVideoGuide = params.showGuide == "true" ? true : false;
    currencyUpdateData = await read("global", "currencyUpdateData");
    console.log(`currencyUpdateData==${currencyUpdateData}`);
    moduleData$3.showUpdateDetail = currencyUpdateData.upgradeState;
    var items = [];
    if ("margin" == moduleData$3.transactionType || "superMargin" == moduleData$3.transactionType) {
        items.push(getItem(moduleData$3.functionLoan));
        items.push(getItem(moduleData$3.functionTransfer));
        items.push(getItem(moduleData$3.functionTradeSettings));
        items.push(getItem(moduleData$3.functionBeginnerGuide));
        if (moduleData$3.showMarginVideoGuide) {
            moduleData$3.marginVideoGuideJumpUrl = params["jumpUrl"];
            items.push(getItem(moduleData$3.functionMarginGuide));
        }
        items.push(getItem(moduleData$3.functionAboutLoan));
        items.push(getItem(moduleData$3.functionFavorite));
    } else {
        if (moduleData$3.showUpdateDetail) {
            items.push(getItem(moduleData$3.functionUpdateDetail));
        }
        items.push(getItem(moduleData$3.functionDeposit));
        items.push(getItem(moduleData$3.functionTransfer));
        items.push(getItem(moduleData$3.functionTradeSettings));
        if (moduleData$3.isLogin) {
            items.push(getItem(moduleData$3.functionRedeem));
        }
        items.push(getItem(moduleData$3.functionRules));
        items.push(getItem(moduleData$3.functionFavorite));
    }
    moduleData$3.moreFunctions = items;
}

function getItem(itemType) {
    if (itemType == moduleData$3.functionLoan) {
        return {
            type: itemType,
            cellType: "1",
            icon: "@drawable/edge_engine_exchange_morefunction_finance",
            title: $i18n.pop_menu_balance_loan_new
        };
    } else if (itemType == moduleData$3.functionTransfer) {
        return {
            type: itemType,
            cellType: "1",
            icon: "@drawable/edge_engine_exchange_morefunction_transfer",
            title: $i18n.pop_menu_balance_transfer_new
        };
    } else if (itemType == moduleData$3.functionDeposit) {
        return {
            type: itemType,
            cellType: "1",
            icon: "@drawable/edge_engine_exchange_morefunction_deposit",
            title: $i18n.pop_menu_balance_deposit_new
        };
    } else if (itemType == moduleData$3.functionTradeSettings) {
        return {
            type: itemType,
            cellType: "1",
            icon: "@drawable/edge_engine_exchange_morefunction_trade_setting",
            title: $i18n.n_otc_trade_set_title
        };
    } else if (itemType == moduleData$3.functionBeginnerGuide) {
        return {
            type: itemType,
            cellType: "1",
            icon: "@drawable/edge_engine_exchange_morefunction_new_guide",
            title: $i18n.n_contract_trade_new_guide_menu
        };
    } else if (itemType == moduleData$3.functionMarginGuide) {
        return {
            type: itemType,
            cellType: "1",
            icon: "@drawable/edge_engine_exchange_morefunction_loan_course",
            title: $i18n.n_margin_video_guide
        };
    } else if (itemType == moduleData$3.functionAboutLoan) {
        return {
            type: itemType,
            cellType: "1",
            icon: "@drawable/edge_engine_exchange_morefunction_about_loan",
            title: $i18n.pop_menu_balance_about_new
        };
    } else if (itemType == moduleData$3.functionFavorite) {
        var favoriteIcon = moduleData$3.isFavorite ? "@drawable/edge_engine_exchange_morefunction_favorite_sel" : "@drawable/edge_engine_exchange_morefunction_favorite_unsel";
        var title = moduleData$3.isFavorite ? $i18n.n_contract_removecollection : $i18n.n_contract_addcollection;
        return {
            type: itemType,
            cellType: "1",
            icon: favoriteIcon,
            title: title
        };
    } else if (itemType == moduleData$3.functionUpdateDetail) {
        return {
            type: itemType,
            cellType: "1",
            icon: "@drawable/edge_engine_exchange_morefunction_update",
            title: $i18n.pop_menu_balance_updetail
        };
    } else if (itemType == moduleData$3.functionRules) {
        return {
            type: itemType,
            cellType: "1",
            icon: "@drawable/edge_engine_exchange_morefunction_trade_rule",
            title: $i18n.n_trade_rules_tips
        };
    } else if (itemType == moduleData$3.functionRedeem) {
        return {
            type: itemType,
            cellType: "1",
            icon: "@drawable/edge_engine_exchange_morefunction_finance",
            title: $i18n.n_exchange_redeem_earn_settings
        };
    }
}

var isPopDismiss$1 = false;

function popDismiss$1() {
    console.log("@@@@@@@@@@pop dismiss@@@@@@@");
    if (isPopDismiss$1) return;
    isPopDismiss$1 = true;
    moduleData$3.removePop = true;
    moduleData$3.popShow = false;
    console.log("@@@@@@@@@@pop dismiss end@@@@@@@");
}

function showMoreView() {
    console.log("@@@@@@@@@@ showMoreView @@@@@@@");
    moduleData$3.popShow = true;
}

var clickedFunctionItem = false;

function moreFunctionItemClick(type) {
    if (clickedFunctionItem) return;
    clickedFunctionItem = true;
    moduleData$3.functionType = type;
    moduleData$3.clickedItem = {
        transactionType: moduleData$3.transactionType,
        itemType: type
    };
    if (type == moduleData$3.functionRedeem) {
        console.log("打开赎回赚币页面");
        openURL(`holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/edgeengine/container?scene=exchange&rootName=redeemSettings&navConfig=native`);
    }
    popDismiss$1();
    console.log(`moreFunctionItemClick==${type}`);
}

moduleEvent$3.popDismiss = popDismiss$1;

moduleEvent$3.setupItems = setupItems;

moduleEvent$3.moreFunctionItemClick = moreFunctionItemClick;

moduleEvent$3.showMoreView = showMoreView;

async function start$2() {
    console.log(`more functions pop-start`);
}

function defaultData$2() {
    return {
        removePop: false,
        brrowSwitch: true,
        brrowSrc: "@drawable/edge_engine_common_switch_open",
        repaySwitch: true,
        repaySrc: "@drawable/edge_engine_common_switch_open",
        popShow: false
    };
}

const {moduleData: moduleData$2, moduleEvent: moduleEvent$2} = moduleDefine("brrowAndRepayTypePop", start$2, defaultData$2);

async function setupType(params) {
    isPopDismiss = false;
    moduleData$2.removePop = false;
    moduleData$2.brrowAndRepayType = parseInt(params.type);
    if (moduleData$2.brrowAndRepayType == 1 || moduleData$2.brrowAndRepayType == 3) {
        moduleData$2.brrowSwitch = true;
        moduleData$2.brrowSrc = "@drawable/edge_engine_common_switch_open";
    } else {
        moduleData$2.brrowSwitch = false;
        moduleData$2.brrowSrc = "@drawable/edge_engine_common_switch_close";
    }
    if (moduleData$2.brrowAndRepayType == 2 || moduleData$2.brrowAndRepayType == 3) {
        moduleData$2.repaySwitch = true;
        moduleData$2.repaySrc = "@drawable/edge_engine_common_switch_open";
    } else {
        moduleData$2.repaySwitch = false;
        moduleData$2.repaySrc = "@drawable/edge_engine_common_switch_close";
    }
    moduleData$2.popShow = true;
}

async function updateType() {
    var type = 0;
    if (moduleData$2.brrowSwitch == true) {
        type += 1;
    }
    if (moduleData$2.repaySwitch == true) {
        type += 2;
    }
    moduleData$2.brrowAndRepayType = type;
}

var isPopDismiss = false;

function popDismiss() {
    if (isPopDismiss) return;
    isPopDismiss = true;
    moduleData$2.removePop = true;
    moduleData$2.popShow = false;
}

function switchClick(element) {
    if (element == "brrow") {
        if (moduleData$2.brrowSwitch == true) {
            moduleData$2.brrowSwitch = false;
            moduleData$2.brrowSrc = "@drawable/edge_engine_common_switch_close";
        } else {
            moduleData$2.brrowSwitch = true;
            moduleData$2.brrowSrc = "@drawable/edge_engine_common_switch_open";
        }
    } else if (element == "repay") {
        if (moduleData$2.repaySwitch == true) {
            moduleData$2.repaySwitch = false;
            moduleData$2.repaySrc = "@drawable/edge_engine_common_switch_close";
        } else {
            moduleData$2.repaySwitch = true;
            moduleData$2.repaySrc = "@drawable/edge_engine_common_switch_open";
        }
    }
    updateType();
}

moduleEvent$2.popDismiss = popDismiss;

moduleEvent$2.switchClick = switchClick;

const config = {
    set isOpen(value) {
        moduleData$1.switchOpen = value == 1 ? "visible" : "gone";
        moduleData$1.switchClose = value != 1 ? "visible" : "gone";
        if (value === 0) {
            moduleData$1.openText = $i18n.n_exchange_redeem_status_part_open;
        } else if (value === 1) {
            moduleData$1.openText = $i18n.n_exchange_redeem_status_all_open;
        } else {
            moduleData$1.openText = $i18n.n_exchange_redeem_status_all_closed;
        }
        save("exchange", "redeemSwitchV2", value);
        console.log(`tl -- 赎回开关状态switchClose==${moduleData$1.switchClose},switchOpen==${moduleData$1.switchOpen}`);
    },
    get isOpen() {
        return moduleData$1.switchOpen == "visible" ? true : false;
    }
};

async function start$1() {
    console.log(`redeem switch page -start`);
}

function defaultData$1() {
    return {
        switchOpen: "gone",
        switchClose: "gone",
        openText: ""
    };
}

const {moduleData: moduleData$1, moduleEvent: moduleEvent$1} = moduleDefine("redeemSettings", start$1, defaultData$1);

moduleEvent$1.onCreate = async function(eventParams) {
    console.log(`tl -- onCreate,eventParams==${eventParams}`);
    moduleData$1.navConfig = getNavConfigString();
    const localStatus = await read("exchange", "redeemSwitchV2");
    if (localStatus == null) {
        console.log(`tl -- onCreate, localStatus=null}`);
        config.isOpen = -1;
    } else {
        console.log(`tl -- onCreate,localStatus==${localStatus}`);
        config.isOpen = localStatus;
    }
};

function getNavConfigString() {
    let nav = {
        titleKey: "n_exchange_redeem_earn_settings",
        left: {
            action: {
                type: "back",
                parameter: ""
            },
            icon: "edge_engine_top_bar_back_normal"
        }
    };
    return nav;
}

async function querySwitchStatus() {
    console.log("tl -- 开始查询开关状态");
    const ret = await sendRequest("/v1/saving/mining/user/balanceAuto/queryOneClickSwitch");
    console.log(`tl -- 查询开关状态结果ret==${ret}`);
    if (ret != null) {
        console.log(`tl -- 查询开关状态结果redeemSwitch==${ret.redeemSwitch}`);
        config.isOpen = ret.redeemSwitch;
    }
}

async function updateSwitchStatus() {
    console.log(`tl -- 开始修改开关状态`);
    showLoading();
    var status = config.isOpen ? 0 : 1;
    console.log(`tl -- 当前开关状态==${config.isOpen},目标开关状态==${status}`);
    var url = `v1/saving/mining/user/balanceAuto/oneClickRedeemSwitch`;
    var params = {
        open: status
    };
    const requestParams = getRequestParams(url, params, 1, 0, {
        "Content-Type": "application/json"
    });
    try {
        const responseString = await $nativeAPI.request(requestParams);
        const response = JSON.parse(responseString);
        const {code: code, message: message, data: data} = response;
        if (code == 200) {
            console.log(`tl -- 开始修改开关状态成功`);
            showLoading(false);
            config.isOpen = status == 1 ? 1 : -1;
        } else {
            console.log(`tl -- 开始修改开关状态失败111,code==${code},message==${message}`);
            showLoading(false);
        }
    } catch (e) {
        console.log(`tl -- 开始修改开关状态失败222`);
        showLoading(false);
    }
}

function getRequestParams(path, params = {}, method = 0, hostType = 0, header = {}) {
    const param = {
        path: path,
        params: params,
        method: method,
        hostType: hostType,
        header: header
    };
    return JSON.stringify(param);
}

moduleEvent$1.clickedSwitch = async function() {
    await updateSwitchStatus();
};

moduleEvent$1.clickedAutoRedeem = async function() {
    console.log(`tl -- clickedAutoRedeem ${commonData.webUrl}/${commonData.language}/financial/earn/h5/autoInvest/detial?tabIndex=1`);
    openURL(`${commonData.webUrl}/${commonData.language}/financial/earn/h5/autoInvest/detial?tabIndex=1`);
};

moduleEvent$1.onDestroy = async function() {};

moduleEvent$1.onResume = async function() {
    await querySwitchStatus();
};

moduleEvent$1.onPause = async function() {};

moduleEvent$1.onStart = async function() {};

moduleEvent$1.onStop = async function() {};

var adConfig = {
    adSymbol: "",
    adShowType: 9,
    adPageType: 43
};

var noticeDataList = [];

var closedNoticeSet = new Set;

var noticeExposureMap = new Set;

async function start() {}

function defaultData() {
    return {
        noticeList: [],
        noticeVisibility: "gone",
        noticeIndicatorList: [],
        noticeIndicatorVisibility: "gone",
        autoScroll: "true",
        currentNoticeIndex: "0"
    };
}

const {moduleData: moduleData, moduleEvent: moduleEvent} = moduleDefine("adActivityBanner", start, defaultData);

async function pageAppear(params) {
    adConfig.adSymbol = params.symbol;
    adConfig.adShowType = params.showType;
    adConfig.adPageType = params.pageType;
    console.log(`${adConfig.adSymbol} - 广告Banner: pageAppear - ${JSON.stringify(params)}`);
    await syncClosedNoticeData();
    var param = {
        symbol: adConfig.adSymbol,
        pageType: `${adConfig.adPageType}`,
        showType: adConfig.adShowType
    };
    let noticeData = await sendRequest("v1/config/push/banner/list", param, 0, 0, {});
    var filterAdBannerList = [];
    if (noticeData && noticeData.bannerAdvList != null && noticeData.bannerAdvList.length > 0) {
        let bannerAdvList = noticeData.bannerAdvList;
        for (let item of bannerAdvList) {
            let advId = item["advId"];
            if (closedNoticeSet.has(advId)) {
                console.log(`${adConfig.adSymbol} - 广告Banner: advId - ${advId} 已过滤`);
                continue;
            }
            console.log(`${adConfig.adSymbol} - 广告Banner: advId - ${advId} 已添加`);
            item.type = "1";
            item.currentImageURL = commonData.colorMode === 1 ? item.nightImageUrl : item.imageUrl;
            filterAdBannerList.push(item);
        }
    }
    let cacheListJson = JSON.stringify(noticeDataList);
    let newListJson = JSON.stringify(filterAdBannerList);
    if (cacheListJson == newListJson) {
        console.log(`${adConfig.adSymbol} - 广告Banner: 最新数据与缓存数据一致 - 无需处理`);
    } else {
        console.log(`${adConfig.adSymbol} - 广告Banner: 最新数据与缓存数据不一致 - 更新`);
        handleSliderView(filterAdBannerList);
    }
    if (noticeDataList.length > 0) {
        noticeExposure();
        moduleData.autoScroll = "true";
    }
}

moduleEvent.pageAppear = pageAppear;

function pageDisappear() {
    console.log(`${adConfig.adSymbol} - 广告Banner: pageDisappear`);
    moduleData.autoScroll = "false";
}

moduleEvent.pageDisappear = pageDisappear;

function handleSliderView(list) {
    noticeDataList = list;
    moduleData.noticeList = list;
    moduleData.noticeVisibility = list.length > 0 ? "visible" : "gone";
    handleSliderIndicatorView();
}

function handleSliderIndicatorView() {
    let indicatorList = [];
    for (let index = 0; index < noticeDataList.length; index++) {
        if (moduleData.currentNoticeIndex == String(index)) {
            indicatorList.push({
                type: "1"
            });
        } else {
            indicatorList.push({
                type: "2"
            });
        }
    }
    moduleData.noticeIndicatorVisibility = indicatorList.length > 1 ? "visible" : "gone";
    moduleData.noticeIndicatorList = indicatorList;
}

async function noticeExposure() {
    var index = parseInt(moduleData.currentNoticeIndex);
    if (index >= noticeDataList.length) {
        return;
    }
    var obj = noticeDataList[index];
    let advId = obj["advId"];
    if (noticeExposureMap.has(advId)) ; else {
        try {
            await analytics("app_spot_trade_middleAD_showview", {
                ad_id: String(advId),
                ad_Title: obj["title"],
                ad_Type: String(adConfig.adShowType)
            });
            noticeExposureMap.add(advId);
        } catch (e) {
            console.log(`${adConfig.adSymbol} - 广告Banner: noticeExposure error - ${e}`);
        }
    }
}

moduleEvent.selectedNoticeIndex = async function(index) {
    moduleData.currentNoticeIndex = String(index);
    handleSliderIndicatorView();
    noticeExposure();
};

moduleEvent.clickNoticeItem = async function() {
    let index = parseInt(moduleData.currentNoticeIndex);
    if (index >= noticeDataList.length) {
        return;
    }
    let obj = noticeDataList[index];
    if (obj.jumpTo != null) {
        console.log(`${adConfig.adSymbol} - 广告Banner: ${obj.jumpTo}`);
        await openURL(encodeURI(obj.jumpTo));
    }
    try {
        await analytics("app_spot_trade_middleAD_click", {
            ad_id: String(obj["advId"]),
            ad_Title: obj["title"],
            ad_Type: String(adConfig.adShowType)
        });
    } catch (e) {
        console.log(`${adConfig.adSymbol} - 广告Banner: clickNoticeItem error - ${e}`);
    }
};

const cacheModuleName = "spotAdNotice";

const cacheAdIdKey = "spotNoticeClosedIdList";

moduleEvent.clickNoticeClose = async function() {
    moduleData.noticeVisibility = "gone";
    moduleData.autoScroll = "false";
    let closedIdList = [];
    for (let item of noticeDataList) {
        closedNoticeSet.add(item["advId"]);
    }
    closedNoticeSet.forEach((function(value) {
        closedIdList.push(value);
    }));
    noticeDataList = [];
    moduleData.noticeList = [];
    console.log(`${adConfig.adSymbol} - 广告Banner: 存储关闭Ids - ${JSON.stringify(closedIdList)}`);
    await save(cacheModuleName, cacheAdIdKey, closedIdList);
};

async function syncClosedNoticeData() {
    closedNoticeSet.clear();
    var closedIdList = await read(cacheModuleName, cacheAdIdKey);
    if (closedIdList && closedIdList.length > 0) {
        console.log(`${adConfig.adSymbol} - 广告Banner: 读取关闭Ids - ${JSON.stringify(closedIdList)}`);
        for (let item of closedIdList) {
            closedNoticeSet.add(item);
        }
    }
}

function sendCommonConfig(param) {
    sendCommonConfig$1(param);
}

async function moduleAppear() {}

function moduleWillDisappear() {}

async function moduleDisappear() {
    console.log("moduleDisappear");
}

function sendMoreFunctionsPopData(params) {
    setupItems(params);
}

function sendBrrowAndRepayType(params) {
    setupType(params);
}

start$1();

$event.sendCommonConfig = sendCommonConfig;

$event.sendMoreFunctionsPopData = sendMoreFunctionsPopData;

$event.moduleAppear = moduleAppear;

$event.moduleWillDisappear = moduleWillDisappear;

$event.moduleDisappear = moduleDisappear;

$event.sendBrrowAndRepayType = sendBrrowAndRepayType;
//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoibWFpbi5qcyIsInNvdXJjZXMiOlsiLi4vLi4vcmVwb3NpdG9yeS9ub2RlX21vZHVsZXMvYmlnLmpzL2JpZy5tanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9jb21tb24uanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9tb3JlRnVuY3Rpb25Qb3AuanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9icnJvd0FuZFJlcGF5VHlwZVBvcC5qcyIsIi4uLy4uL3JlcG9zaXRvcnkvc3JjL3JlZGVlbVNldHRpbmdzLmpzIiwiLi4vLi4vcmVwb3NpdG9yeS9zcmMvYWRBY3Rpdml0eUJhbm5lci5qcyIsIi4uLy4uL3JlcG9zaXRvcnkvc3JjL21haW4uanMiXSwic291cmNlc0NvbnRlbnQiOlsiLypcclxuICogIGJpZy5qcyB2NS4yLjJcclxuICogIEEgc21hbGwsIGZhc3QsIGVhc3ktdG8tdXNlIGxpYnJhcnkgZm9yIGFyYml0cmFyeS1wcmVjaXNpb24gZGVjaW1hbCBhcml0aG1ldGljLlxyXG4gKiAgQ29weXJpZ2h0IChjKSAyMDE4IE1pY2hhZWwgTWNsYXVnaGxpbiA8TThjaDg4bEBnbWFpbC5jb20+XHJcbiAqICBodHRwczovL2dpdGh1Yi5jb20vTWlrZU1jbC9iaWcuanMvTElDRU5DRVxyXG4gKi9cclxuXHJcblxyXG4vKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKiogRURJVEFCTEUgREVGQVVMVFMgKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKiovXHJcblxyXG5cclxuICAvLyBUaGUgZGVmYXVsdCB2YWx1ZXMgYmVsb3cgbXVzdCBiZSBpbnRlZ2VycyB3aXRoaW4gdGhlIHN0YXRlZCByYW5nZXMuXHJcblxyXG4gIC8qXHJcbiAgICogVGhlIG1heGltdW0gbnVtYmVyIG9mIGRlY2ltYWwgcGxhY2VzIChEUCkgb2YgdGhlIHJlc3VsdHMgb2Ygb3BlcmF0aW9ucyBpbnZvbHZpbmcgZGl2aXNpb246XHJcbiAgICogZGl2IGFuZCBzcXJ0LCBhbmQgcG93IHdpdGggbmVnYXRpdmUgZXhwb25lbnRzLlxyXG4gICAqL1xyXG52YXIgRFAgPSAyMCwgICAgICAgICAgLy8gMCB0byBNQVhfRFBcclxuXHJcbiAgLypcclxuICAgKiBUaGUgcm91bmRpbmcgbW9kZSAoUk0pIHVzZWQgd2hlbiByb3VuZGluZyB0byB0aGUgYWJvdmUgZGVjaW1hbCBwbGFjZXMuXHJcbiAgICpcclxuICAgKiAgMCAgVG93YXJkcyB6ZXJvIChpLmUuIHRydW5jYXRlLCBubyByb3VuZGluZykuICAgICAgIChST1VORF9ET1dOKVxyXG4gICAqICAxICBUbyBuZWFyZXN0IG5laWdoYm91ci4gSWYgZXF1aWRpc3RhbnQsIHJvdW5kIHVwLiAgKFJPVU5EX0hBTEZfVVApXHJcbiAgICogIDIgIFRvIG5lYXJlc3QgbmVpZ2hib3VyLiBJZiBlcXVpZGlzdGFudCwgdG8gZXZlbi4gICAoUk9VTkRfSEFMRl9FVkVOKVxyXG4gICAqICAzICBBd2F5IGZyb20gemVyby4gICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgKFJPVU5EX1VQKVxyXG4gICAqL1xyXG4gIFJNID0gMSwgICAgICAgICAgICAgLy8gMCwgMSwgMiBvciAzXHJcblxyXG4gIC8vIFRoZSBtYXhpbXVtIHZhbHVlIG9mIERQIGFuZCBCaWcuRFAuXHJcbiAgTUFYX0RQID0gMUU2LCAgICAgICAvLyAwIHRvIDEwMDAwMDBcclxuXHJcbiAgLy8gVGhlIG1heGltdW0gbWFnbml0dWRlIG9mIHRoZSBleHBvbmVudCBhcmd1bWVudCB0byB0aGUgcG93IG1ldGhvZC5cclxuICBNQVhfUE9XRVIgPSAxRTYsICAgIC8vIDEgdG8gMTAwMDAwMFxyXG5cclxuICAvKlxyXG4gICAqIFRoZSBuZWdhdGl2ZSBleHBvbmVudCAoTkUpIGF0IGFuZCBiZW5lYXRoIHdoaWNoIHRvU3RyaW5nIHJldHVybnMgZXhwb25lbnRpYWwgbm90YXRpb24uXHJcbiAgICogKEphdmFTY3JpcHQgbnVtYmVyczogLTcpXHJcbiAgICogLTEwMDAwMDAgaXMgdGhlIG1pbmltdW0gcmVjb21tZW5kZWQgZXhwb25lbnQgdmFsdWUgb2YgYSBCaWcuXHJcbiAgICovXHJcbiAgTkUgPSAtNywgICAgICAgICAgICAvLyAwIHRvIC0xMDAwMDAwXHJcblxyXG4gIC8qXHJcbiAgICogVGhlIHBvc2l0aXZlIGV4cG9uZW50IChQRSkgYXQgYW5kIGFib3ZlIHdoaWNoIHRvU3RyaW5nIHJldHVybnMgZXhwb25lbnRpYWwgbm90YXRpb24uXHJcbiAgICogKEphdmFTY3JpcHQgbnVtYmVyczogMjEpXHJcbiAgICogMTAwMDAwMCBpcyB0aGUgbWF4aW11bSByZWNvbW1lbmRlZCBleHBvbmVudCB2YWx1ZSBvZiBhIEJpZy5cclxuICAgKiAoVGhpcyBsaW1pdCBpcyBub3QgZW5mb3JjZWQgb3IgY2hlY2tlZC4pXHJcbiAgICovXHJcbiAgUEUgPSAyMSwgICAgICAgICAgICAvLyAwIHRvIDEwMDAwMDBcclxuXHJcblxyXG4vKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKiovXHJcblxyXG5cclxuICAvLyBFcnJvciBtZXNzYWdlcy5cclxuICBOQU1FID0gJ1tiaWcuanNdICcsXHJcbiAgSU5WQUxJRCA9IE5BTUUgKyAnSW52YWxpZCAnLFxyXG4gIElOVkFMSURfRFAgPSBJTlZBTElEICsgJ2RlY2ltYWwgcGxhY2VzJyxcclxuICBJTlZBTElEX1JNID0gSU5WQUxJRCArICdyb3VuZGluZyBtb2RlJyxcclxuICBESVZfQllfWkVSTyA9IE5BTUUgKyAnRGl2aXNpb24gYnkgemVybycsXHJcblxyXG4gIC8vIFRoZSBzaGFyZWQgcHJvdG90eXBlIG9iamVjdC5cclxuICBQID0ge30sXHJcbiAgVU5ERUZJTkVEID0gdm9pZCAwLFxyXG4gIE5VTUVSSUMgPSAvXi0/KFxcZCsoXFwuXFxkKik/fFxcLlxcZCspKGVbKy1dP1xcZCspPyQvaTtcclxuXHJcblxyXG4vKlxyXG4gKiBDcmVhdGUgYW5kIHJldHVybiBhIEJpZyBjb25zdHJ1Y3Rvci5cclxuICpcclxuICovXHJcbmZ1bmN0aW9uIF9CaWdfKCkge1xyXG5cclxuICAvKlxyXG4gICAqIFRoZSBCaWcgY29uc3RydWN0b3IgYW5kIGV4cG9ydGVkIGZ1bmN0aW9uLlxyXG4gICAqIENyZWF0ZSBhbmQgcmV0dXJuIGEgbmV3IGluc3RhbmNlIG9mIGEgQmlnIG51bWJlciBvYmplY3QuXHJcbiAgICpcclxuICAgKiBuIHtudW1iZXJ8c3RyaW5nfEJpZ30gQSBudW1lcmljIHZhbHVlLlxyXG4gICAqL1xyXG4gIGZ1bmN0aW9uIEJpZyhuKSB7XHJcbiAgICB2YXIgeCA9IHRoaXM7XHJcblxyXG4gICAgLy8gRW5hYmxlIGNvbnN0cnVjdG9yIHVzYWdlIHdpdGhvdXQgbmV3LlxyXG4gICAgaWYgKCEoeCBpbnN0YW5jZW9mIEJpZykpIHJldHVybiBuID09PSBVTkRFRklORUQgPyBfQmlnXygpIDogbmV3IEJpZyhuKTtcclxuXHJcbiAgICAvLyBEdXBsaWNhdGUuXHJcbiAgICBpZiAobiBpbnN0YW5jZW9mIEJpZykge1xyXG4gICAgICB4LnMgPSBuLnM7XHJcbiAgICAgIHguZSA9IG4uZTtcclxuICAgICAgeC5jID0gbi5jLnNsaWNlKCk7XHJcbiAgICB9IGVsc2Uge1xyXG4gICAgICBwYXJzZSh4LCBuKTtcclxuICAgIH1cclxuXHJcbiAgICAvKlxyXG4gICAgICogUmV0YWluIGEgcmVmZXJlbmNlIHRvIHRoaXMgQmlnIGNvbnN0cnVjdG9yLCBhbmQgc2hhZG93IEJpZy5wcm90b3R5cGUuY29uc3RydWN0b3Igd2hpY2hcclxuICAgICAqIHBvaW50cyB0byBPYmplY3QuXHJcbiAgICAgKi9cclxuICAgIHguY29uc3RydWN0b3IgPSBCaWc7XHJcbiAgfVxyXG5cclxuICBCaWcucHJvdG90eXBlID0gUDtcclxuICBCaWcuRFAgPSBEUDtcclxuICBCaWcuUk0gPSBSTTtcclxuICBCaWcuTkUgPSBORTtcclxuICBCaWcuUEUgPSBQRTtcclxuICBCaWcudmVyc2lvbiA9ICc1LjIuMic7XHJcblxyXG4gIHJldHVybiBCaWc7XHJcbn1cclxuXHJcblxyXG4vKlxyXG4gKiBQYXJzZSB0aGUgbnVtYmVyIG9yIHN0cmluZyB2YWx1ZSBwYXNzZWQgdG8gYSBCaWcgY29uc3RydWN0b3IuXHJcbiAqXHJcbiAqIHgge0JpZ30gQSBCaWcgbnVtYmVyIGluc3RhbmNlLlxyXG4gKiBuIHtudW1iZXJ8c3RyaW5nfSBBIG51bWVyaWMgdmFsdWUuXHJcbiAqL1xyXG5mdW5jdGlvbiBwYXJzZSh4LCBuKSB7XHJcbiAgdmFyIGUsIGksIG5sO1xyXG5cclxuICAvLyBNaW51cyB6ZXJvP1xyXG4gIGlmIChuID09PSAwICYmIDEgLyBuIDwgMCkgbiA9ICctMCc7XHJcbiAgZWxzZSBpZiAoIU5VTUVSSUMudGVzdChuICs9ICcnKSkgdGhyb3cgRXJyb3IoSU5WQUxJRCArICdudW1iZXInKTtcclxuXHJcbiAgLy8gRGV0ZXJtaW5lIHNpZ24uXHJcbiAgeC5zID0gbi5jaGFyQXQoMCkgPT0gJy0nID8gKG4gPSBuLnNsaWNlKDEpLCAtMSkgOiAxO1xyXG5cclxuICAvLyBEZWNpbWFsIHBvaW50P1xyXG4gIGlmICgoZSA9IG4uaW5kZXhPZignLicpKSA+IC0xKSBuID0gbi5yZXBsYWNlKCcuJywgJycpO1xyXG5cclxuICAvLyBFeHBvbmVudGlhbCBmb3JtP1xyXG4gIGlmICgoaSA9IG4uc2VhcmNoKC9lL2kpKSA+IDApIHtcclxuXHJcbiAgICAvLyBEZXRlcm1pbmUgZXhwb25lbnQuXHJcbiAgICBpZiAoZSA8IDApIGUgPSBpO1xyXG4gICAgZSArPSArbi5zbGljZShpICsgMSk7XHJcbiAgICBuID0gbi5zdWJzdHJpbmcoMCwgaSk7XHJcbiAgfSBlbHNlIGlmIChlIDwgMCkge1xyXG5cclxuICAgIC8vIEludGVnZXIuXHJcbiAgICBlID0gbi5sZW5ndGg7XHJcbiAgfVxyXG5cclxuICBubCA9IG4ubGVuZ3RoO1xyXG5cclxuICAvLyBEZXRlcm1pbmUgbGVhZGluZyB6ZXJvcy5cclxuICBmb3IgKGkgPSAwOyBpIDwgbmwgJiYgbi5jaGFyQXQoaSkgPT0gJzAnOykgKytpO1xyXG5cclxuICBpZiAoaSA9PSBubCkge1xyXG5cclxuICAgIC8vIFplcm8uXHJcbiAgICB4LmMgPSBbeC5lID0gMF07XHJcbiAgfSBlbHNlIHtcclxuXHJcbiAgICAvLyBEZXRlcm1pbmUgdHJhaWxpbmcgemVyb3MuXHJcbiAgICBmb3IgKDsgbmwgPiAwICYmIG4uY2hhckF0KC0tbmwpID09ICcwJzspO1xyXG4gICAgeC5lID0gZSAtIGkgLSAxO1xyXG4gICAgeC5jID0gW107XHJcblxyXG4gICAgLy8gQ29udmVydCBzdHJpbmcgdG8gYXJyYXkgb2YgZGlnaXRzIHdpdGhvdXQgbGVhZGluZy90cmFpbGluZyB6ZXJvcy5cclxuICAgIGZvciAoZSA9IDA7IGkgPD0gbmw7KSB4LmNbZSsrXSA9ICtuLmNoYXJBdChpKyspO1xyXG4gIH1cclxuXHJcbiAgcmV0dXJuIHg7XHJcbn1cclxuXHJcblxyXG4vKlxyXG4gKiBSb3VuZCBCaWcgeCB0byBhIG1heGltdW0gb2YgZHAgZGVjaW1hbCBwbGFjZXMgdXNpbmcgcm91bmRpbmcgbW9kZSBybS5cclxuICogQ2FsbGVkIGJ5IHN0cmluZ2lmeSwgUC5kaXYsIFAucm91bmQgYW5kIFAuc3FydC5cclxuICpcclxuICogeCB7QmlnfSBUaGUgQmlnIHRvIHJvdW5kLlxyXG4gKiBkcCB7bnVtYmVyfSBJbnRlZ2VyLCAwIHRvIE1BWF9EUCBpbmNsdXNpdmUuXHJcbiAqIHJtIHtudW1iZXJ9IDAsIDEsIDIgb3IgMyAoRE9XTiwgSEFMRl9VUCwgSEFMRl9FVkVOLCBVUClcclxuICogW21vcmVdIHtib29sZWFufSBXaGV0aGVyIHRoZSByZXN1bHQgb2YgZGl2aXNpb24gd2FzIHRydW5jYXRlZC5cclxuICovXHJcbmZ1bmN0aW9uIHJvdW5kKHgsIGRwLCBybSwgbW9yZSkge1xyXG4gIHZhciB4YyA9IHguYyxcclxuICAgIGkgPSB4LmUgKyBkcCArIDE7XHJcblxyXG4gIGlmIChpIDwgeGMubGVuZ3RoKSB7XHJcbiAgICBpZiAocm0gPT09IDEpIHtcclxuXHJcbiAgICAgIC8vIHhjW2ldIGlzIHRoZSBkaWdpdCBhZnRlciB0aGUgZGlnaXQgdGhhdCBtYXkgYmUgcm91bmRlZCB1cC5cclxuICAgICAgbW9yZSA9IHhjW2ldID49IDU7XHJcbiAgICB9IGVsc2UgaWYgKHJtID09PSAyKSB7XHJcbiAgICAgIG1vcmUgPSB4Y1tpXSA+IDUgfHwgeGNbaV0gPT0gNSAmJlxyXG4gICAgICAgIChtb3JlIHx8IGkgPCAwIHx8IHhjW2kgKyAxXSAhPT0gVU5ERUZJTkVEIHx8IHhjW2kgLSAxXSAmIDEpO1xyXG4gICAgfSBlbHNlIGlmIChybSA9PT0gMykge1xyXG4gICAgICBtb3JlID0gbW9yZSB8fCAhIXhjWzBdO1xyXG4gICAgfSBlbHNlIHtcclxuICAgICAgbW9yZSA9IGZhbHNlO1xyXG4gICAgICBpZiAocm0gIT09IDApIHRocm93IEVycm9yKElOVkFMSURfUk0pO1xyXG4gICAgfVxyXG5cclxuICAgIGlmIChpIDwgMSkge1xyXG4gICAgICB4Yy5sZW5ndGggPSAxO1xyXG5cclxuICAgICAgaWYgKG1vcmUpIHtcclxuXHJcbiAgICAgICAgLy8gMSwgMC4xLCAwLjAxLCAwLjAwMSwgMC4wMDAxIGV0Yy5cclxuICAgICAgICB4LmUgPSAtZHA7XHJcbiAgICAgICAgeGNbMF0gPSAxO1xyXG4gICAgICB9IGVsc2Uge1xyXG5cclxuICAgICAgICAvLyBaZXJvLlxyXG4gICAgICAgIHhjWzBdID0geC5lID0gMDtcclxuICAgICAgfVxyXG4gICAgfSBlbHNlIHtcclxuXHJcbiAgICAgIC8vIFJlbW92ZSBhbnkgZGlnaXRzIGFmdGVyIHRoZSByZXF1aXJlZCBkZWNpbWFsIHBsYWNlcy5cclxuICAgICAgeGMubGVuZ3RoID0gaS0tO1xyXG5cclxuICAgICAgLy8gUm91bmQgdXA/XHJcbiAgICAgIGlmIChtb3JlKSB7XHJcblxyXG4gICAgICAgIC8vIFJvdW5kaW5nIHVwIG1heSBtZWFuIHRoZSBwcmV2aW91cyBkaWdpdCBoYXMgdG8gYmUgcm91bmRlZCB1cC5cclxuICAgICAgICBmb3IgKDsgKyt4Y1tpXSA+IDk7KSB7XHJcbiAgICAgICAgICB4Y1tpXSA9IDA7XHJcbiAgICAgICAgICBpZiAoIWktLSkge1xyXG4gICAgICAgICAgICArK3guZTtcclxuICAgICAgICAgICAgeGMudW5zaGlmdCgxKTtcclxuICAgICAgICAgIH1cclxuICAgICAgICB9XHJcbiAgICAgIH1cclxuXHJcbiAgICAgIC8vIFJlbW92ZSB0cmFpbGluZyB6ZXJvcy5cclxuICAgICAgZm9yIChpID0geGMubGVuZ3RoOyAheGNbLS1pXTspIHhjLnBvcCgpO1xyXG4gICAgfVxyXG4gIH0gZWxzZSBpZiAocm0gPCAwIHx8IHJtID4gMyB8fCBybSAhPT0gfn5ybSkge1xyXG4gICAgdGhyb3cgRXJyb3IoSU5WQUxJRF9STSk7XHJcbiAgfVxyXG5cclxuICByZXR1cm4geDtcclxufVxyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIHN0cmluZyByZXByZXNlbnRpbmcgdGhlIHZhbHVlIG9mIEJpZyB4IGluIG5vcm1hbCBvciBleHBvbmVudGlhbCBub3RhdGlvbi5cclxuICogSGFuZGxlcyBQLnRvRXhwb25lbnRpYWwsIFAudG9GaXhlZCwgUC50b0pTT04sIFAudG9QcmVjaXNpb24sIFAudG9TdHJpbmcgYW5kIFAudmFsdWVPZi5cclxuICpcclxuICogeCB7QmlnfVxyXG4gKiBpZD8ge251bWJlcn0gQ2FsbGVyIGlkLlxyXG4gKiAgICAgICAgIDEgdG9FeHBvbmVudGlhbFxyXG4gKiAgICAgICAgIDIgdG9GaXhlZFxyXG4gKiAgICAgICAgIDMgdG9QcmVjaXNpb25cclxuICogICAgICAgICA0IHZhbHVlT2ZcclxuICogbj8ge251bWJlcnx1bmRlZmluZWR9IENhbGxlcidzIGFyZ3VtZW50LlxyXG4gKiBrPyB7bnVtYmVyfHVuZGVmaW5lZH1cclxuICovXHJcbmZ1bmN0aW9uIHN0cmluZ2lmeSh4LCBpZCwgbiwgaykge1xyXG4gIHZhciBlLCBzLFxyXG4gICAgQmlnID0geC5jb25zdHJ1Y3RvcixcclxuICAgIHogPSAheC5jWzBdO1xyXG5cclxuICBpZiAobiAhPT0gVU5ERUZJTkVEKSB7XHJcbiAgICBpZiAobiAhPT0gfn5uIHx8IG4gPCAoaWQgPT0gMykgfHwgbiA+IE1BWF9EUCkge1xyXG4gICAgICB0aHJvdyBFcnJvcihpZCA9PSAzID8gSU5WQUxJRCArICdwcmVjaXNpb24nIDogSU5WQUxJRF9EUCk7XHJcbiAgICB9XHJcblxyXG4gICAgeCA9IG5ldyBCaWcoeCk7XHJcblxyXG4gICAgLy8gVGhlIGluZGV4IG9mIHRoZSBkaWdpdCB0aGF0IG1heSBiZSByb3VuZGVkIHVwLlxyXG4gICAgbiA9IGsgLSB4LmU7XHJcblxyXG4gICAgLy8gUm91bmQ/XHJcbiAgICBpZiAoeC5jLmxlbmd0aCA+ICsraykgcm91bmQoeCwgbiwgQmlnLlJNKTtcclxuXHJcbiAgICAvLyB0b0ZpeGVkOiByZWNhbGN1bGF0ZSBrIGFzIHguZSBtYXkgaGF2ZSBjaGFuZ2VkIGlmIHZhbHVlIHJvdW5kZWQgdXAuXHJcbiAgICBpZiAoaWQgPT0gMikgayA9IHguZSArIG4gKyAxO1xyXG5cclxuICAgIC8vIEFwcGVuZCB6ZXJvcz9cclxuICAgIGZvciAoOyB4LmMubGVuZ3RoIDwgazspIHguYy5wdXNoKDApO1xyXG4gIH1cclxuXHJcbiAgZSA9IHguZTtcclxuICBzID0geC5jLmpvaW4oJycpO1xyXG4gIG4gPSBzLmxlbmd0aDtcclxuXHJcbiAgLy8gRXhwb25lbnRpYWwgbm90YXRpb24/XHJcbiAgaWYgKGlkICE9IDIgJiYgKGlkID09IDEgfHwgaWQgPT0gMyAmJiBrIDw9IGUgfHwgZSA8PSBCaWcuTkUgfHwgZSA+PSBCaWcuUEUpKSB7XHJcbiAgICBzID0gcy5jaGFyQXQoMCkgKyAobiA+IDEgPyAnLicgKyBzLnNsaWNlKDEpIDogJycpICsgKGUgPCAwID8gJ2UnIDogJ2UrJykgKyBlO1xyXG5cclxuICAvLyBOb3JtYWwgbm90YXRpb24uXHJcbiAgfSBlbHNlIGlmIChlIDwgMCkge1xyXG4gICAgZm9yICg7ICsrZTspIHMgPSAnMCcgKyBzO1xyXG4gICAgcyA9ICcwLicgKyBzO1xyXG4gIH0gZWxzZSBpZiAoZSA+IDApIHtcclxuICAgIGlmICgrK2UgPiBuKSBmb3IgKGUgLT0gbjsgZS0tOykgcyArPSAnMCc7XHJcbiAgICBlbHNlIGlmIChlIDwgbikgcyA9IHMuc2xpY2UoMCwgZSkgKyAnLicgKyBzLnNsaWNlKGUpO1xyXG4gIH0gZWxzZSBpZiAobiA+IDEpIHtcclxuICAgIHMgPSBzLmNoYXJBdCgwKSArICcuJyArIHMuc2xpY2UoMSk7XHJcbiAgfVxyXG5cclxuICByZXR1cm4geC5zIDwgMCAmJiAoIXogfHwgaWQgPT0gNCkgPyAnLScgKyBzIDogcztcclxufVxyXG5cclxuXHJcbi8vIFByb3RvdHlwZS9pbnN0YW5jZSBtZXRob2RzXHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgbmV3IEJpZyB3aG9zZSB2YWx1ZSBpcyB0aGUgYWJzb2x1dGUgdmFsdWUgb2YgdGhpcyBCaWcuXHJcbiAqL1xyXG5QLmFicyA9IGZ1bmN0aW9uICgpIHtcclxuICB2YXIgeCA9IG5ldyB0aGlzLmNvbnN0cnVjdG9yKHRoaXMpO1xyXG4gIHgucyA9IDE7XHJcbiAgcmV0dXJuIHg7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIDEgaWYgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIGlzIGdyZWF0ZXIgdGhhbiB0aGUgdmFsdWUgb2YgQmlnIHksXHJcbiAqICAgICAgIC0xIGlmIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBpcyBsZXNzIHRoYW4gdGhlIHZhbHVlIG9mIEJpZyB5LCBvclxyXG4gKiAgICAgICAgMCBpZiB0aGV5IGhhdmUgdGhlIHNhbWUgdmFsdWUuXHJcbiovXHJcblAuY21wID0gZnVuY3Rpb24gKHkpIHtcclxuICB2YXIgaXNuZWcsXHJcbiAgICB4ID0gdGhpcyxcclxuICAgIHhjID0geC5jLFxyXG4gICAgeWMgPSAoeSA9IG5ldyB4LmNvbnN0cnVjdG9yKHkpKS5jLFxyXG4gICAgaSA9IHgucyxcclxuICAgIGogPSB5LnMsXHJcbiAgICBrID0geC5lLFxyXG4gICAgbCA9IHkuZTtcclxuXHJcbiAgLy8gRWl0aGVyIHplcm8/XHJcbiAgaWYgKCF4Y1swXSB8fCAheWNbMF0pIHJldHVybiAheGNbMF0gPyAheWNbMF0gPyAwIDogLWogOiBpO1xyXG5cclxuICAvLyBTaWducyBkaWZmZXI/XHJcbiAgaWYgKGkgIT0gaikgcmV0dXJuIGk7XHJcblxyXG4gIGlzbmVnID0gaSA8IDA7XHJcblxyXG4gIC8vIENvbXBhcmUgZXhwb25lbnRzLlxyXG4gIGlmIChrICE9IGwpIHJldHVybiBrID4gbCBeIGlzbmVnID8gMSA6IC0xO1xyXG5cclxuICBqID0gKGsgPSB4Yy5sZW5ndGgpIDwgKGwgPSB5Yy5sZW5ndGgpID8gayA6IGw7XHJcblxyXG4gIC8vIENvbXBhcmUgZGlnaXQgYnkgZGlnaXQuXHJcbiAgZm9yIChpID0gLTE7ICsraSA8IGo7KSB7XHJcbiAgICBpZiAoeGNbaV0gIT0geWNbaV0pIHJldHVybiB4Y1tpXSA+IHljW2ldIF4gaXNuZWcgPyAxIDogLTE7XHJcbiAgfVxyXG5cclxuICAvLyBDb21wYXJlIGxlbmd0aHMuXHJcbiAgcmV0dXJuIGsgPT0gbCA/IDAgOiBrID4gbCBeIGlzbmVnID8gMSA6IC0xO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIG5ldyBCaWcgd2hvc2UgdmFsdWUgaXMgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIGRpdmlkZWQgYnkgdGhlIHZhbHVlIG9mIEJpZyB5LCByb3VuZGVkLFxyXG4gKiBpZiBuZWNlc3NhcnksIHRvIGEgbWF4aW11bSBvZiBCaWcuRFAgZGVjaW1hbCBwbGFjZXMgdXNpbmcgcm91bmRpbmcgbW9kZSBCaWcuUk0uXHJcbiAqL1xyXG5QLmRpdiA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgdmFyIHggPSB0aGlzLFxyXG4gICAgQmlnID0geC5jb25zdHJ1Y3RvcixcclxuICAgIGEgPSB4LmMsICAgICAgICAgICAgICAgICAgLy8gZGl2aWRlbmRcclxuICAgIGIgPSAoeSA9IG5ldyBCaWcoeSkpLmMsICAgLy8gZGl2aXNvclxyXG4gICAgayA9IHgucyA9PSB5LnMgPyAxIDogLTEsXHJcbiAgICBkcCA9IEJpZy5EUDtcclxuXHJcbiAgaWYgKGRwICE9PSB+fmRwIHx8IGRwIDwgMCB8fCBkcCA+IE1BWF9EUCkgdGhyb3cgRXJyb3IoSU5WQUxJRF9EUCk7XHJcblxyXG4gIC8vIERpdmlzb3IgaXMgemVybz9cclxuICBpZiAoIWJbMF0pIHRocm93IEVycm9yKERJVl9CWV9aRVJPKTtcclxuXHJcbiAgLy8gRGl2aWRlbmQgaXMgMD8gUmV0dXJuICstMC5cclxuICBpZiAoIWFbMF0pIHJldHVybiBuZXcgQmlnKGsgKiAwKTtcclxuXHJcbiAgdmFyIGJsLCBidCwgbiwgY21wLCByaSxcclxuICAgIGJ6ID0gYi5zbGljZSgpLFxyXG4gICAgYWkgPSBibCA9IGIubGVuZ3RoLFxyXG4gICAgYWwgPSBhLmxlbmd0aCxcclxuICAgIHIgPSBhLnNsaWNlKDAsIGJsKSwgICAvLyByZW1haW5kZXJcclxuICAgIHJsID0gci5sZW5ndGgsXHJcbiAgICBxID0geSwgICAgICAgICAgICAgICAgLy8gcXVvdGllbnRcclxuICAgIHFjID0gcS5jID0gW10sXHJcbiAgICBxaSA9IDAsXHJcbiAgICBkID0gZHAgKyAocS5lID0geC5lIC0geS5lKSArIDE7ICAgIC8vIG51bWJlciBvZiBkaWdpdHMgb2YgdGhlIHJlc3VsdFxyXG5cclxuICBxLnMgPSBrO1xyXG4gIGsgPSBkIDwgMCA/IDAgOiBkO1xyXG5cclxuICAvLyBDcmVhdGUgdmVyc2lvbiBvZiBkaXZpc29yIHdpdGggbGVhZGluZyB6ZXJvLlxyXG4gIGJ6LnVuc2hpZnQoMCk7XHJcblxyXG4gIC8vIEFkZCB6ZXJvcyB0byBtYWtlIHJlbWFpbmRlciBhcyBsb25nIGFzIGRpdmlzb3IuXHJcbiAgZm9yICg7IHJsKysgPCBibDspIHIucHVzaCgwKTtcclxuXHJcbiAgZG8ge1xyXG5cclxuICAgIC8vIG4gaXMgaG93IG1hbnkgdGltZXMgdGhlIGRpdmlzb3IgZ29lcyBpbnRvIGN1cnJlbnQgcmVtYWluZGVyLlxyXG4gICAgZm9yIChuID0gMDsgbiA8IDEwOyBuKyspIHtcclxuXHJcbiAgICAgIC8vIENvbXBhcmUgZGl2aXNvciBhbmQgcmVtYWluZGVyLlxyXG4gICAgICBpZiAoYmwgIT0gKHJsID0gci5sZW5ndGgpKSB7XHJcbiAgICAgICAgY21wID0gYmwgPiBybCA/IDEgOiAtMTtcclxuICAgICAgfSBlbHNlIHtcclxuICAgICAgICBmb3IgKHJpID0gLTEsIGNtcCA9IDA7ICsrcmkgPCBibDspIHtcclxuICAgICAgICAgIGlmIChiW3JpXSAhPSByW3JpXSkge1xyXG4gICAgICAgICAgICBjbXAgPSBiW3JpXSA+IHJbcmldID8gMSA6IC0xO1xyXG4gICAgICAgICAgICBicmVhaztcclxuICAgICAgICAgIH1cclxuICAgICAgICB9XHJcbiAgICAgIH1cclxuXHJcbiAgICAgIC8vIElmIGRpdmlzb3IgPCByZW1haW5kZXIsIHN1YnRyYWN0IGRpdmlzb3IgZnJvbSByZW1haW5kZXIuXHJcbiAgICAgIGlmIChjbXAgPCAwKSB7XHJcblxyXG4gICAgICAgIC8vIFJlbWFpbmRlciBjYW4ndCBiZSBtb3JlIHRoYW4gMSBkaWdpdCBsb25nZXIgdGhhbiBkaXZpc29yLlxyXG4gICAgICAgIC8vIEVxdWFsaXNlIGxlbmd0aHMgdXNpbmcgZGl2aXNvciB3aXRoIGV4dHJhIGxlYWRpbmcgemVybz9cclxuICAgICAgICBmb3IgKGJ0ID0gcmwgPT0gYmwgPyBiIDogYno7IHJsOykge1xyXG4gICAgICAgICAgaWYgKHJbLS1ybF0gPCBidFtybF0pIHtcclxuICAgICAgICAgICAgcmkgPSBybDtcclxuICAgICAgICAgICAgZm9yICg7IHJpICYmICFyWy0tcmldOykgcltyaV0gPSA5O1xyXG4gICAgICAgICAgICAtLXJbcmldO1xyXG4gICAgICAgICAgICByW3JsXSArPSAxMDtcclxuICAgICAgICAgIH1cclxuICAgICAgICAgIHJbcmxdIC09IGJ0W3JsXTtcclxuICAgICAgICB9XHJcblxyXG4gICAgICAgIGZvciAoOyAhclswXTspIHIuc2hpZnQoKTtcclxuICAgICAgfSBlbHNlIHtcclxuICAgICAgICBicmVhaztcclxuICAgICAgfVxyXG4gICAgfVxyXG5cclxuICAgIC8vIEFkZCB0aGUgZGlnaXQgbiB0byB0aGUgcmVzdWx0IGFycmF5LlxyXG4gICAgcWNbcWkrK10gPSBjbXAgPyBuIDogKytuO1xyXG5cclxuICAgIC8vIFVwZGF0ZSB0aGUgcmVtYWluZGVyLlxyXG4gICAgaWYgKHJbMF0gJiYgY21wKSByW3JsXSA9IGFbYWldIHx8IDA7XHJcbiAgICBlbHNlIHIgPSBbYVthaV1dO1xyXG5cclxuICB9IHdoaWxlICgoYWkrKyA8IGFsIHx8IHJbMF0gIT09IFVOREVGSU5FRCkgJiYgay0tKTtcclxuXHJcbiAgLy8gTGVhZGluZyB6ZXJvPyBEbyBub3QgcmVtb3ZlIGlmIHJlc3VsdCBpcyBzaW1wbHkgemVybyAocWkgPT0gMSkuXHJcbiAgaWYgKCFxY1swXSAmJiBxaSAhPSAxKSB7XHJcblxyXG4gICAgLy8gVGhlcmUgY2FuJ3QgYmUgbW9yZSB0aGFuIG9uZSB6ZXJvLlxyXG4gICAgcWMuc2hpZnQoKTtcclxuICAgIHEuZS0tO1xyXG4gIH1cclxuXHJcbiAgLy8gUm91bmQ/XHJcbiAgaWYgKHFpID4gZCkgcm91bmQocSwgZHAsIEJpZy5STSwgclswXSAhPT0gVU5ERUZJTkVEKTtcclxuXHJcbiAgcmV0dXJuIHE7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIHRydWUgaWYgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIGlzIGVxdWFsIHRvIHRoZSB2YWx1ZSBvZiBCaWcgeSwgb3RoZXJ3aXNlIHJldHVybiBmYWxzZS5cclxuICovXHJcblAuZXEgPSBmdW5jdGlvbiAoeSkge1xyXG4gIHJldHVybiAhdGhpcy5jbXAoeSk7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIHRydWUgaWYgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIGlzIGdyZWF0ZXIgdGhhbiB0aGUgdmFsdWUgb2YgQmlnIHksIG90aGVyd2lzZSByZXR1cm5cclxuICogZmFsc2UuXHJcbiAqL1xyXG5QLmd0ID0gZnVuY3Rpb24gKHkpIHtcclxuICByZXR1cm4gdGhpcy5jbXAoeSkgPiAwO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiB0cnVlIGlmIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBpcyBncmVhdGVyIHRoYW4gb3IgZXF1YWwgdG8gdGhlIHZhbHVlIG9mIEJpZyB5LCBvdGhlcndpc2VcclxuICogcmV0dXJuIGZhbHNlLlxyXG4gKi9cclxuUC5ndGUgPSBmdW5jdGlvbiAoeSkge1xyXG4gIHJldHVybiB0aGlzLmNtcCh5KSA+IC0xO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiB0cnVlIGlmIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBpcyBsZXNzIHRoYW4gdGhlIHZhbHVlIG9mIEJpZyB5LCBvdGhlcndpc2UgcmV0dXJuIGZhbHNlLlxyXG4gKi9cclxuUC5sdCA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgcmV0dXJuIHRoaXMuY21wKHkpIDwgMDtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gdHJ1ZSBpZiB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgaXMgbGVzcyB0aGFuIG9yIGVxdWFsIHRvIHRoZSB2YWx1ZSBvZiBCaWcgeSwgb3RoZXJ3aXNlXHJcbiAqIHJldHVybiBmYWxzZS5cclxuICovXHJcblAubHRlID0gZnVuY3Rpb24gKHkpIHtcclxuICByZXR1cm4gdGhpcy5jbXAoeSkgPCAxO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIG5ldyBCaWcgd2hvc2UgdmFsdWUgaXMgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIG1pbnVzIHRoZSB2YWx1ZSBvZiBCaWcgeS5cclxuICovXHJcblAubWludXMgPSBQLnN1YiA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgdmFyIGksIGosIHQsIHhsdHksXHJcbiAgICB4ID0gdGhpcyxcclxuICAgIEJpZyA9IHguY29uc3RydWN0b3IsXHJcbiAgICBhID0geC5zLFxyXG4gICAgYiA9ICh5ID0gbmV3IEJpZyh5KSkucztcclxuXHJcbiAgLy8gU2lnbnMgZGlmZmVyP1xyXG4gIGlmIChhICE9IGIpIHtcclxuICAgIHkucyA9IC1iO1xyXG4gICAgcmV0dXJuIHgucGx1cyh5KTtcclxuICB9XHJcblxyXG4gIHZhciB4YyA9IHguYy5zbGljZSgpLFxyXG4gICAgeGUgPSB4LmUsXHJcbiAgICB5YyA9IHkuYyxcclxuICAgIHllID0geS5lO1xyXG5cclxuICAvLyBFaXRoZXIgemVybz9cclxuICBpZiAoIXhjWzBdIHx8ICF5Y1swXSkge1xyXG5cclxuICAgIC8vIHkgaXMgbm9uLXplcm8/IHggaXMgbm9uLXplcm8/IE9yIGJvdGggYXJlIHplcm8uXHJcbiAgICByZXR1cm4geWNbMF0gPyAoeS5zID0gLWIsIHkpIDogbmV3IEJpZyh4Y1swXSA/IHggOiAwKTtcclxuICB9XHJcblxyXG4gIC8vIERldGVybWluZSB3aGljaCBpcyB0aGUgYmlnZ2VyIG51bWJlci4gUHJlcGVuZCB6ZXJvcyB0byBlcXVhbGlzZSBleHBvbmVudHMuXHJcbiAgaWYgKGEgPSB4ZSAtIHllKSB7XHJcblxyXG4gICAgaWYgKHhsdHkgPSBhIDwgMCkge1xyXG4gICAgICBhID0gLWE7XHJcbiAgICAgIHQgPSB4YztcclxuICAgIH0gZWxzZSB7XHJcbiAgICAgIHllID0geGU7XHJcbiAgICAgIHQgPSB5YztcclxuICAgIH1cclxuXHJcbiAgICB0LnJldmVyc2UoKTtcclxuICAgIGZvciAoYiA9IGE7IGItLTspIHQucHVzaCgwKTtcclxuICAgIHQucmV2ZXJzZSgpO1xyXG4gIH0gZWxzZSB7XHJcblxyXG4gICAgLy8gRXhwb25lbnRzIGVxdWFsLiBDaGVjayBkaWdpdCBieSBkaWdpdC5cclxuICAgIGogPSAoKHhsdHkgPSB4Yy5sZW5ndGggPCB5Yy5sZW5ndGgpID8geGMgOiB5YykubGVuZ3RoO1xyXG5cclxuICAgIGZvciAoYSA9IGIgPSAwOyBiIDwgajsgYisrKSB7XHJcbiAgICAgIGlmICh4Y1tiXSAhPSB5Y1tiXSkge1xyXG4gICAgICAgIHhsdHkgPSB4Y1tiXSA8IHljW2JdO1xyXG4gICAgICAgIGJyZWFrO1xyXG4gICAgICB9XHJcbiAgICB9XHJcbiAgfVxyXG5cclxuICAvLyB4IDwgeT8gUG9pbnQgeGMgdG8gdGhlIGFycmF5IG9mIHRoZSBiaWdnZXIgbnVtYmVyLlxyXG4gIGlmICh4bHR5KSB7XHJcbiAgICB0ID0geGM7XHJcbiAgICB4YyA9IHljO1xyXG4gICAgeWMgPSB0O1xyXG4gICAgeS5zID0gLXkucztcclxuICB9XHJcblxyXG4gIC8qXHJcbiAgICogQXBwZW5kIHplcm9zIHRvIHhjIGlmIHNob3J0ZXIuIE5vIG5lZWQgdG8gYWRkIHplcm9zIHRvIHljIGlmIHNob3J0ZXIgYXMgc3VidHJhY3Rpb24gb25seVxyXG4gICAqIG5lZWRzIHRvIHN0YXJ0IGF0IHljLmxlbmd0aC5cclxuICAgKi9cclxuICBpZiAoKGIgPSAoaiA9IHljLmxlbmd0aCkgLSAoaSA9IHhjLmxlbmd0aCkpID4gMCkgZm9yICg7IGItLTspIHhjW2krK10gPSAwO1xyXG5cclxuICAvLyBTdWJ0cmFjdCB5YyBmcm9tIHhjLlxyXG4gIGZvciAoYiA9IGk7IGogPiBhOykge1xyXG4gICAgaWYgKHhjWy0tal0gPCB5Y1tqXSkge1xyXG4gICAgICBmb3IgKGkgPSBqOyBpICYmICF4Y1stLWldOykgeGNbaV0gPSA5O1xyXG4gICAgICAtLXhjW2ldO1xyXG4gICAgICB4Y1tqXSArPSAxMDtcclxuICAgIH1cclxuXHJcbiAgICB4Y1tqXSAtPSB5Y1tqXTtcclxuICB9XHJcblxyXG4gIC8vIFJlbW92ZSB0cmFpbGluZyB6ZXJvcy5cclxuICBmb3IgKDsgeGNbLS1iXSA9PT0gMDspIHhjLnBvcCgpO1xyXG5cclxuICAvLyBSZW1vdmUgbGVhZGluZyB6ZXJvcyBhbmQgYWRqdXN0IGV4cG9uZW50IGFjY29yZGluZ2x5LlxyXG4gIGZvciAoOyB4Y1swXSA9PT0gMDspIHtcclxuICAgIHhjLnNoaWZ0KCk7XHJcbiAgICAtLXllO1xyXG4gIH1cclxuXHJcbiAgaWYgKCF4Y1swXSkge1xyXG5cclxuICAgIC8vIG4gLSBuID0gKzBcclxuICAgIHkucyA9IDE7XHJcblxyXG4gICAgLy8gUmVzdWx0IG11c3QgYmUgemVyby5cclxuICAgIHhjID0gW3llID0gMF07XHJcbiAgfVxyXG5cclxuICB5LmMgPSB4YztcclxuICB5LmUgPSB5ZTtcclxuXHJcbiAgcmV0dXJuIHk7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgbmV3IEJpZyB3aG9zZSB2YWx1ZSBpcyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgbW9kdWxvIHRoZSB2YWx1ZSBvZiBCaWcgeS5cclxuICovXHJcblAubW9kID0gZnVuY3Rpb24gKHkpIHtcclxuICB2YXIgeWd0eCxcclxuICAgIHggPSB0aGlzLFxyXG4gICAgQmlnID0geC5jb25zdHJ1Y3RvcixcclxuICAgIGEgPSB4LnMsXHJcbiAgICBiID0gKHkgPSBuZXcgQmlnKHkpKS5zO1xyXG5cclxuICBpZiAoIXkuY1swXSkgdGhyb3cgRXJyb3IoRElWX0JZX1pFUk8pO1xyXG5cclxuICB4LnMgPSB5LnMgPSAxO1xyXG4gIHlndHggPSB5LmNtcCh4KSA9PSAxO1xyXG4gIHgucyA9IGE7XHJcbiAgeS5zID0gYjtcclxuXHJcbiAgaWYgKHlndHgpIHJldHVybiBuZXcgQmlnKHgpO1xyXG5cclxuICBhID0gQmlnLkRQO1xyXG4gIGIgPSBCaWcuUk07XHJcbiAgQmlnLkRQID0gQmlnLlJNID0gMDtcclxuICB4ID0geC5kaXYoeSk7XHJcbiAgQmlnLkRQID0gYTtcclxuICBCaWcuUk0gPSBiO1xyXG5cclxuICByZXR1cm4gdGhpcy5taW51cyh4LnRpbWVzKHkpKTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBuZXcgQmlnIHdob3NlIHZhbHVlIGlzIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBwbHVzIHRoZSB2YWx1ZSBvZiBCaWcgeS5cclxuICovXHJcblAucGx1cyA9IFAuYWRkID0gZnVuY3Rpb24gKHkpIHtcclxuICB2YXIgdCxcclxuICAgIHggPSB0aGlzLFxyXG4gICAgQmlnID0geC5jb25zdHJ1Y3RvcixcclxuICAgIGEgPSB4LnMsXHJcbiAgICBiID0gKHkgPSBuZXcgQmlnKHkpKS5zO1xyXG5cclxuICAvLyBTaWducyBkaWZmZXI/XHJcbiAgaWYgKGEgIT0gYikge1xyXG4gICAgeS5zID0gLWI7XHJcbiAgICByZXR1cm4geC5taW51cyh5KTtcclxuICB9XHJcblxyXG4gIHZhciB4ZSA9IHguZSxcclxuICAgIHhjID0geC5jLFxyXG4gICAgeWUgPSB5LmUsXHJcbiAgICB5YyA9IHkuYztcclxuXHJcbiAgLy8gRWl0aGVyIHplcm8/IHkgaXMgbm9uLXplcm8/IHggaXMgbm9uLXplcm8/IE9yIGJvdGggYXJlIHplcm8uXHJcbiAgaWYgKCF4Y1swXSB8fCAheWNbMF0pIHJldHVybiB5Y1swXSA/IHkgOiBuZXcgQmlnKHhjWzBdID8geCA6IGEgKiAwKTtcclxuXHJcbiAgeGMgPSB4Yy5zbGljZSgpO1xyXG5cclxuICAvLyBQcmVwZW5kIHplcm9zIHRvIGVxdWFsaXNlIGV4cG9uZW50cy5cclxuICAvLyBOb3RlOiByZXZlcnNlIGZhc3RlciB0aGFuIHVuc2hpZnRzLlxyXG4gIGlmIChhID0geGUgLSB5ZSkge1xyXG4gICAgaWYgKGEgPiAwKSB7XHJcbiAgICAgIHllID0geGU7XHJcbiAgICAgIHQgPSB5YztcclxuICAgIH0gZWxzZSB7XHJcbiAgICAgIGEgPSAtYTtcclxuICAgICAgdCA9IHhjO1xyXG4gICAgfVxyXG5cclxuICAgIHQucmV2ZXJzZSgpO1xyXG4gICAgZm9yICg7IGEtLTspIHQucHVzaCgwKTtcclxuICAgIHQucmV2ZXJzZSgpO1xyXG4gIH1cclxuXHJcbiAgLy8gUG9pbnQgeGMgdG8gdGhlIGxvbmdlciBhcnJheS5cclxuICBpZiAoeGMubGVuZ3RoIC0geWMubGVuZ3RoIDwgMCkge1xyXG4gICAgdCA9IHljO1xyXG4gICAgeWMgPSB4YztcclxuICAgIHhjID0gdDtcclxuICB9XHJcblxyXG4gIGEgPSB5Yy5sZW5ndGg7XHJcblxyXG4gIC8vIE9ubHkgc3RhcnQgYWRkaW5nIGF0IHljLmxlbmd0aCAtIDEgYXMgdGhlIGZ1cnRoZXIgZGlnaXRzIG9mIHhjIGNhbiBiZSBsZWZ0IGFzIHRoZXkgYXJlLlxyXG4gIGZvciAoYiA9IDA7IGE7IHhjW2FdICU9IDEwKSBiID0gKHhjWy0tYV0gPSB4Y1thXSArIHljW2FdICsgYikgLyAxMCB8IDA7XHJcblxyXG4gIC8vIE5vIG5lZWQgdG8gY2hlY2sgZm9yIHplcm8sIGFzICt4ICsgK3kgIT0gMCAmJiAteCArIC15ICE9IDBcclxuXHJcbiAgaWYgKGIpIHtcclxuICAgIHhjLnVuc2hpZnQoYik7XHJcbiAgICArK3llO1xyXG4gIH1cclxuXHJcbiAgLy8gUmVtb3ZlIHRyYWlsaW5nIHplcm9zLlxyXG4gIGZvciAoYSA9IHhjLmxlbmd0aDsgeGNbLS1hXSA9PT0gMDspIHhjLnBvcCgpO1xyXG5cclxuICB5LmMgPSB4YztcclxuICB5LmUgPSB5ZTtcclxuXHJcbiAgcmV0dXJuIHk7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgQmlnIHdob3NlIHZhbHVlIGlzIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyByYWlzZWQgdG8gdGhlIHBvd2VyIG4uXHJcbiAqIElmIG4gaXMgbmVnYXRpdmUsIHJvdW5kIHRvIGEgbWF4aW11bSBvZiBCaWcuRFAgZGVjaW1hbCBwbGFjZXMgdXNpbmcgcm91bmRpbmdcclxuICogbW9kZSBCaWcuUk0uXHJcbiAqXHJcbiAqIG4ge251bWJlcn0gSW50ZWdlciwgLU1BWF9QT1dFUiB0byBNQVhfUE9XRVIgaW5jbHVzaXZlLlxyXG4gKi9cclxuUC5wb3cgPSBmdW5jdGlvbiAobikge1xyXG4gIHZhciB4ID0gdGhpcyxcclxuICAgIG9uZSA9IG5ldyB4LmNvbnN0cnVjdG9yKDEpLFxyXG4gICAgeSA9IG9uZSxcclxuICAgIGlzbmVnID0gbiA8IDA7XHJcblxyXG4gIGlmIChuICE9PSB+fm4gfHwgbiA8IC1NQVhfUE9XRVIgfHwgbiA+IE1BWF9QT1dFUikgdGhyb3cgRXJyb3IoSU5WQUxJRCArICdleHBvbmVudCcpO1xyXG4gIGlmIChpc25lZykgbiA9IC1uO1xyXG5cclxuICBmb3IgKDs7KSB7XHJcbiAgICBpZiAobiAmIDEpIHkgPSB5LnRpbWVzKHgpO1xyXG4gICAgbiA+Pj0gMTtcclxuICAgIGlmICghbikgYnJlYWs7XHJcbiAgICB4ID0geC50aW1lcyh4KTtcclxuICB9XHJcblxyXG4gIHJldHVybiBpc25lZyA/IG9uZS5kaXYoeSkgOiB5O1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIG5ldyBCaWcgd2hvc2UgdmFsdWUgaXMgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIHJvdW5kZWQgdXNpbmcgcm91bmRpbmcgbW9kZSBybVxyXG4gKiB0byBhIG1heGltdW0gb2YgZHAgZGVjaW1hbCBwbGFjZXMsIG9yLCBpZiBkcCBpcyBuZWdhdGl2ZSwgdG8gYW4gaW50ZWdlciB3aGljaCBpcyBhXHJcbiAqIG11bHRpcGxlIG9mIDEwKiotZHAuXHJcbiAqIElmIGRwIGlzIG5vdCBzcGVjaWZpZWQsIHJvdW5kIHRvIDAgZGVjaW1hbCBwbGFjZXMuXHJcbiAqIElmIHJtIGlzIG5vdCBzcGVjaWZpZWQsIHVzZSBCaWcuUk0uXHJcbiAqXHJcbiAqIGRwPyB7bnVtYmVyfSBJbnRlZ2VyLCAtTUFYX0RQIHRvIE1BWF9EUCBpbmNsdXNpdmUuXHJcbiAqIHJtPyAwLCAxLCAyIG9yIDMgKFJPVU5EX0RPV04sIFJPVU5EX0hBTEZfVVAsIFJPVU5EX0hBTEZfRVZFTiwgUk9VTkRfVVApXHJcbiAqL1xyXG5QLnJvdW5kID0gZnVuY3Rpb24gKGRwLCBybSkge1xyXG4gIHZhciBCaWcgPSB0aGlzLmNvbnN0cnVjdG9yO1xyXG4gIGlmIChkcCA9PT0gVU5ERUZJTkVEKSBkcCA9IDA7XHJcbiAgZWxzZSBpZiAoZHAgIT09IH5+ZHAgfHwgZHAgPCAtTUFYX0RQIHx8IGRwID4gTUFYX0RQKSB0aHJvdyBFcnJvcihJTlZBTElEX0RQKTtcclxuICByZXR1cm4gcm91bmQobmV3IEJpZyh0aGlzKSwgZHAsIHJtID09PSBVTkRFRklORUQgPyBCaWcuUk0gOiBybSk7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgbmV3IEJpZyB3aG9zZSB2YWx1ZSBpcyB0aGUgc3F1YXJlIHJvb3Qgb2YgdGhlIHZhbHVlIG9mIHRoaXMgQmlnLCByb3VuZGVkLCBpZlxyXG4gKiBuZWNlc3NhcnksIHRvIGEgbWF4aW11bSBvZiBCaWcuRFAgZGVjaW1hbCBwbGFjZXMgdXNpbmcgcm91bmRpbmcgbW9kZSBCaWcuUk0uXHJcbiAqL1xyXG5QLnNxcnQgPSBmdW5jdGlvbiAoKSB7XHJcbiAgdmFyIHIsIGMsIHQsXHJcbiAgICB4ID0gdGhpcyxcclxuICAgIEJpZyA9IHguY29uc3RydWN0b3IsXHJcbiAgICBzID0geC5zLFxyXG4gICAgZSA9IHguZSxcclxuICAgIGhhbGYgPSBuZXcgQmlnKDAuNSk7XHJcblxyXG4gIC8vIFplcm8/XHJcbiAgaWYgKCF4LmNbMF0pIHJldHVybiBuZXcgQmlnKHgpO1xyXG5cclxuICAvLyBOZWdhdGl2ZT9cclxuICBpZiAocyA8IDApIHRocm93IEVycm9yKE5BTUUgKyAnTm8gc3F1YXJlIHJvb3QnKTtcclxuXHJcbiAgLy8gRXN0aW1hdGUuXHJcbiAgcyA9IE1hdGguc3FydCh4ICsgJycpO1xyXG5cclxuICAvLyBNYXRoLnNxcnQgdW5kZXJmbG93L292ZXJmbG93P1xyXG4gIC8vIFJlLWVzdGltYXRlOiBwYXNzIHggY29lZmZpY2llbnQgdG8gTWF0aC5zcXJ0IGFzIGludGVnZXIsIHRoZW4gYWRqdXN0IHRoZSByZXN1bHQgZXhwb25lbnQuXHJcbiAgaWYgKHMgPT09IDAgfHwgcyA9PT0gMSAvIDApIHtcclxuICAgIGMgPSB4LmMuam9pbignJyk7XHJcbiAgICBpZiAoIShjLmxlbmd0aCArIGUgJiAxKSkgYyArPSAnMCc7XHJcbiAgICBzID0gTWF0aC5zcXJ0KGMpO1xyXG4gICAgZSA9ICgoZSArIDEpIC8gMiB8IDApIC0gKGUgPCAwIHx8IGUgJiAxKTtcclxuICAgIHIgPSBuZXcgQmlnKChzID09IDEgLyAwID8gJzFlJyA6IChzID0gcy50b0V4cG9uZW50aWFsKCkpLnNsaWNlKDAsIHMuaW5kZXhPZignZScpICsgMSkpICsgZSk7XHJcbiAgfSBlbHNlIHtcclxuICAgIHIgPSBuZXcgQmlnKHMpO1xyXG4gIH1cclxuXHJcbiAgZSA9IHIuZSArIChCaWcuRFAgKz0gNCk7XHJcblxyXG4gIC8vIE5ld3Rvbi1SYXBoc29uIGl0ZXJhdGlvbi5cclxuICBkbyB7XHJcbiAgICB0ID0gcjtcclxuICAgIHIgPSBoYWxmLnRpbWVzKHQucGx1cyh4LmRpdih0KSkpO1xyXG4gIH0gd2hpbGUgKHQuYy5zbGljZSgwLCBlKS5qb2luKCcnKSAhPT0gci5jLnNsaWNlKDAsIGUpLmpvaW4oJycpKTtcclxuXHJcbiAgcmV0dXJuIHJvdW5kKHIsIEJpZy5EUCAtPSA0LCBCaWcuUk0pO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIG5ldyBCaWcgd2hvc2UgdmFsdWUgaXMgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIHRpbWVzIHRoZSB2YWx1ZSBvZiBCaWcgeS5cclxuICovXHJcblAudGltZXMgPSBQLm11bCA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgdmFyIGMsXHJcbiAgICB4ID0gdGhpcyxcclxuICAgIEJpZyA9IHguY29uc3RydWN0b3IsXHJcbiAgICB4YyA9IHguYyxcclxuICAgIHljID0gKHkgPSBuZXcgQmlnKHkpKS5jLFxyXG4gICAgYSA9IHhjLmxlbmd0aCxcclxuICAgIGIgPSB5Yy5sZW5ndGgsXHJcbiAgICBpID0geC5lLFxyXG4gICAgaiA9IHkuZTtcclxuXHJcbiAgLy8gRGV0ZXJtaW5lIHNpZ24gb2YgcmVzdWx0LlxyXG4gIHkucyA9IHgucyA9PSB5LnMgPyAxIDogLTE7XHJcblxyXG4gIC8vIFJldHVybiBzaWduZWQgMCBpZiBlaXRoZXIgMC5cclxuICBpZiAoIXhjWzBdIHx8ICF5Y1swXSkgcmV0dXJuIG5ldyBCaWcoeS5zICogMCk7XHJcblxyXG4gIC8vIEluaXRpYWxpc2UgZXhwb25lbnQgb2YgcmVzdWx0IGFzIHguZSArIHkuZS5cclxuICB5LmUgPSBpICsgajtcclxuXHJcbiAgLy8gSWYgYXJyYXkgeGMgaGFzIGZld2VyIGRpZ2l0cyB0aGFuIHljLCBzd2FwIHhjIGFuZCB5YywgYW5kIGxlbmd0aHMuXHJcbiAgaWYgKGEgPCBiKSB7XHJcbiAgICBjID0geGM7XHJcbiAgICB4YyA9IHljO1xyXG4gICAgeWMgPSBjO1xyXG4gICAgaiA9IGE7XHJcbiAgICBhID0gYjtcclxuICAgIGIgPSBqO1xyXG4gIH1cclxuXHJcbiAgLy8gSW5pdGlhbGlzZSBjb2VmZmljaWVudCBhcnJheSBvZiByZXN1bHQgd2l0aCB6ZXJvcy5cclxuICBmb3IgKGMgPSBuZXcgQXJyYXkoaiA9IGEgKyBiKTsgai0tOykgY1tqXSA9IDA7XHJcblxyXG4gIC8vIE11bHRpcGx5LlxyXG5cclxuICAvLyBpIGlzIGluaXRpYWxseSB4Yy5sZW5ndGguXHJcbiAgZm9yIChpID0gYjsgaS0tOykge1xyXG4gICAgYiA9IDA7XHJcblxyXG4gICAgLy8gYSBpcyB5Yy5sZW5ndGguXHJcbiAgICBmb3IgKGogPSBhICsgaTsgaiA+IGk7KSB7XHJcblxyXG4gICAgICAvLyBDdXJyZW50IHN1bSBvZiBwcm9kdWN0cyBhdCB0aGlzIGRpZ2l0IHBvc2l0aW9uLCBwbHVzIGNhcnJ5LlxyXG4gICAgICBiID0gY1tqXSArIHljW2ldICogeGNbaiAtIGkgLSAxXSArIGI7XHJcbiAgICAgIGNbai0tXSA9IGIgJSAxMDtcclxuXHJcbiAgICAgIC8vIGNhcnJ5XHJcbiAgICAgIGIgPSBiIC8gMTAgfCAwO1xyXG4gICAgfVxyXG5cclxuICAgIGNbal0gPSAoY1tqXSArIGIpICUgMTA7XHJcbiAgfVxyXG5cclxuICAvLyBJbmNyZW1lbnQgcmVzdWx0IGV4cG9uZW50IGlmIHRoZXJlIGlzIGEgZmluYWwgY2FycnksIG90aGVyd2lzZSByZW1vdmUgbGVhZGluZyB6ZXJvLlxyXG4gIGlmIChiKSArK3kuZTtcclxuICBlbHNlIGMuc2hpZnQoKTtcclxuXHJcbiAgLy8gUmVtb3ZlIHRyYWlsaW5nIHplcm9zLlxyXG4gIGZvciAoaSA9IGMubGVuZ3RoOyAhY1stLWldOykgYy5wb3AoKTtcclxuICB5LmMgPSBjO1xyXG5cclxuICByZXR1cm4geTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBzdHJpbmcgcmVwcmVzZW50aW5nIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBpbiBleHBvbmVudGlhbCBub3RhdGlvbiB0byBkcCBmaXhlZCBkZWNpbWFsXHJcbiAqIHBsYWNlcyBhbmQgcm91bmRlZCB1c2luZyBCaWcuUk0uXHJcbiAqXHJcbiAqIGRwPyB7bnVtYmVyfSBJbnRlZ2VyLCAwIHRvIE1BWF9EUCBpbmNsdXNpdmUuXHJcbiAqL1xyXG5QLnRvRXhwb25lbnRpYWwgPSBmdW5jdGlvbiAoZHApIHtcclxuICByZXR1cm4gc3RyaW5naWZ5KHRoaXMsIDEsIGRwLCBkcCk7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgc3RyaW5nIHJlcHJlc2VudGluZyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgaW4gbm9ybWFsIG5vdGF0aW9uIHRvIGRwIGZpeGVkIGRlY2ltYWxcclxuICogcGxhY2VzIGFuZCByb3VuZGVkIHVzaW5nIEJpZy5STS5cclxuICpcclxuICogZHA/IHtudW1iZXJ9IEludGVnZXIsIDAgdG8gTUFYX0RQIGluY2x1c2l2ZS5cclxuICpcclxuICogKC0wKS50b0ZpeGVkKDApIGlzICcwJywgYnV0ICgtMC4xKS50b0ZpeGVkKDApIGlzICctMCcuXHJcbiAqICgtMCkudG9GaXhlZCgxKSBpcyAnMC4wJywgYnV0ICgtMC4wMSkudG9GaXhlZCgxKSBpcyAnLTAuMCcuXHJcbiAqL1xyXG5QLnRvRml4ZWQgPSBmdW5jdGlvbiAoZHApIHtcclxuICByZXR1cm4gc3RyaW5naWZ5KHRoaXMsIDIsIGRwLCB0aGlzLmUgKyBkcCk7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgc3RyaW5nIHJlcHJlc2VudGluZyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgcm91bmRlZCB0byBzZCBzaWduaWZpY2FudCBkaWdpdHMgdXNpbmdcclxuICogQmlnLlJNLiBVc2UgZXhwb25lbnRpYWwgbm90YXRpb24gaWYgc2QgaXMgbGVzcyB0aGFuIHRoZSBudW1iZXIgb2YgZGlnaXRzIG5lY2Vzc2FyeSB0byByZXByZXNlbnRcclxuICogdGhlIGludGVnZXIgcGFydCBvZiB0aGUgdmFsdWUgaW4gbm9ybWFsIG5vdGF0aW9uLlxyXG4gKlxyXG4gKiBzZCB7bnVtYmVyfSBJbnRlZ2VyLCAxIHRvIE1BWF9EUCBpbmNsdXNpdmUuXHJcbiAqL1xyXG5QLnRvUHJlY2lzaW9uID0gZnVuY3Rpb24gKHNkKSB7XHJcbiAgcmV0dXJuIHN0cmluZ2lmeSh0aGlzLCAzLCBzZCwgc2QgLSAxKTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBzdHJpbmcgcmVwcmVzZW50aW5nIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZy5cclxuICogUmV0dXJuIGV4cG9uZW50aWFsIG5vdGF0aW9uIGlmIHRoaXMgQmlnIGhhcyBhIHBvc2l0aXZlIGV4cG9uZW50IGVxdWFsIHRvIG9yIGdyZWF0ZXIgdGhhblxyXG4gKiBCaWcuUEUsIG9yIGEgbmVnYXRpdmUgZXhwb25lbnQgZXF1YWwgdG8gb3IgbGVzcyB0aGFuIEJpZy5ORS5cclxuICogT21pdCB0aGUgc2lnbiBmb3IgbmVnYXRpdmUgemVyby5cclxuICovXHJcblAudG9TdHJpbmcgPSBmdW5jdGlvbiAoKSB7XHJcbiAgcmV0dXJuIHN0cmluZ2lmeSh0aGlzKTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBzdHJpbmcgcmVwcmVzZW50aW5nIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZy5cclxuICogUmV0dXJuIGV4cG9uZW50aWFsIG5vdGF0aW9uIGlmIHRoaXMgQmlnIGhhcyBhIHBvc2l0aXZlIGV4cG9uZW50IGVxdWFsIHRvIG9yIGdyZWF0ZXIgdGhhblxyXG4gKiBCaWcuUEUsIG9yIGEgbmVnYXRpdmUgZXhwb25lbnQgZXF1YWwgdG8gb3IgbGVzcyB0aGFuIEJpZy5ORS5cclxuICogSW5jbHVkZSB0aGUgc2lnbiBmb3IgbmVnYXRpdmUgemVyby5cclxuICovXHJcblAudmFsdWVPZiA9IFAudG9KU09OID0gZnVuY3Rpb24gKCkge1xyXG4gIHJldHVybiBzdHJpbmdpZnkodGhpcywgNCk7XHJcbn07XHJcblxyXG5cclxuLy8gRXhwb3J0XHJcblxyXG5cclxuZXhwb3J0IHZhciBCaWcgPSBfQmlnXygpO1xyXG5cclxuZXhwb3J0IGRlZmF1bHQgQmlnO1xyXG4iLCJpbXBvcnQgKiBhcyBudW1iZXIgZnJvbSBcIi4vbnVtYmVyXCI7XG5cbnZhciBjbGlja2FibGUgPSB0cnVlO1xuXG4vKipcbiAqIEB0eXBlZGVmIHtPYmplY3R9IENvbW1vbkRhdGFcbiAqIEBwcm9wZXJ0eSB7bnVtYmVyfSBwcmljZUNvbG9yVHlwZSAgICAtIOS7t+agvOa2qOi3jOW5heminOiJsuiuvue9rlxuICogQHByb3BlcnR5IHtudW1iZXJ9IGNvbG9yTW9kZSAgICAgICAgIC0g55m95aSp6buR5aSc5qih5byPXG4gKiBAcHJvcGVydHkge3N0cmluZ30gbGFuZ3VhZ2UgICAgICAgICAgLSDor63np43phY3nva5cbiAqIEBwcm9wZXJ0eSB7c3RyaW5nfSBPUyAgICAgICAgICAgICAgICAtIOezu+e7n1xuICogQHByb3BlcnR5IHtzdHJpbmd9IGFwcFZlcnNpb24gICAgICAgIC0g54mI5pys5Y+3XG4gKiBAcHJvcGVydHkge251bWJlcn0gaXNJblJldmlldyAgICAgICAgLSBpT1PlrqHmoLjnirbmgIFcbiAqIEBwcm9wZXJ0eSB7bnVtYmVyfSBpc0xvZ2luICAgICAgICAgICAtIOaYr+WQpueZu+W9lVxuICovXG5cbi8qKiBAdHlwZSBDb21tb25EYXRhICovXG5leHBvcnQgdmFyIGNvbW1vbkRhdGEgPSB7XG4gIHByaWNlQ29sb3JUeXBlOiAwLCAvLy8w77ya57qi5rao57u/6LeMICAgMe+8mue7v+a2qOe6oui3jFxuICBjb2xvck1vZGU6IDAsIC8vLzDvvJrnmb3lpKkgICAx77ya6buR5aScXG4gIE9TOiAwLCAvLzDvvJppT1MgIDHvvJrlronljZNcbiAgd2ViVXJsOiBcIlwiLCAvLy8gaDXliqjmgIHln5/lkI1cbiAgYXBwVmVyc2lvbjogXCJcIiwgLy9hcHDniYjmnKzlj7dcbiAgaXNJblJldmlldzogMSxcbiAgaXNMb2dpbjogMCxcbiAgbGFuZ3VhZ2U6IFwiXCIsIC8vLyDor63oqIDnp43nsbtcbn07XG5cblxuLy/orr7nva7pgJrnlKjphY3nva5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBzZW5kQ29tbW9uQ29uZmlnKHBhcmFtKSB7XG4gIGlmIChwYXJhbSA9PSBudWxsKSByZXR1cm47XG5cbiAgY29uc29sZS5sb2cocGFyYW0pO1xuICBjb21tb25EYXRhLnByaWNlQ29sb3JUeXBlID0gcGFyc2VJbnQocGFyYW0ucHJpY2VDb2xvclR5cGUpO1xuICBjb21tb25EYXRhLmNvbG9yTW9kZSA9IHBhcnNlSW50KHBhcmFtLmNvbG9yTW9kZSk7XG4gIGNvbW1vbkRhdGEuT1MgPSBwYXJzZUludChwYXJhbS5PUyk7XG4gIGNvbW1vbkRhdGEuYXBwVmVyc2lvbiA9IHBhcmFtLmFwcFZlcnNpb247XG4gIGNvbW1vbkRhdGEuaXNJblJldmlldyA9IHBhcnNlSW50KHBhcmFtLmlzSW5SZXZpZXcpO1xuICBjb21tb25EYXRhLmxhbmd1YWdlID0gcGFyYW0ubGFuZ3VhZ2U7XG4gIGNvbW1vbkRhdGEuaXNMb2dpbiA9IHBhcnNlSW50KHBhcmFtLmlzTG9naW4pO1xuICBjb21tb25EYXRhLndlYlVybCA9IHBhcmFtLndlYlVybDtcblxuICB2YXIgcmVkQ29sb3JMaXN0ID0gW1wiI0FEQjBCMlwiLCBcIiNFOTQzNTlcIiwgXCIjREUyOTQxXCIsIFwiI0NFMTQyQlwiXTtcbiAgdmFyIGdyZWVuQ29sb3JMaXN0ID0gW1wiI0FEQjBCMlwiLCBcIiMwMEExNzFcIiwgXCIjMDA4QjYxXCIsIFwiIzAwNjI0NVwiXTtcbiAgaWYgKHBhcnNlSW50KGNvbW1vbkRhdGEucHJpY2VDb2xvclR5cGUpID09IDApIHtcbiAgICB1cENvbG9yTGlzdCA9IHJlZENvbG9yTGlzdDtcbiAgICBkb3duQ29sb3JMaXN0ID0gZ3JlZW5Db2xvckxpc3Q7XG4gIH0gZWxzZSB7XG4gICAgdXBDb2xvckxpc3QgPSBncmVlbkNvbG9yTGlzdDtcbiAgICBkb3duQ29sb3JMaXN0ID0gcmVkQ29sb3JMaXN0O1xuICB9XG59XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBzdWJQcmljZVdlYlNvY2tldCh0eXBlID0gXCJsaW5lYXJTd2FwV3NcIikge1xuICBhd2FpdCAkbmF0aXZlQVBJLmNvcHlUcmFkaW5nQnJpZGdlKHtcbiAgICBhY3Rpb246IFwic3ViUHJpY2VXZWJTb2NrZXRcIixcbiAgICB0eXBlOiB0eXBlLFxuICB9KTtcbn1cblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHVuc3ViUHJpY2VXZWJTb2NrZXQodHlwZSA9IFwibGluZWFyU3dhcFdzXCIpIHtcbiAgYXdhaXQgJG5hdGl2ZUFQSS5jb3B5VHJhZGluZ0JyaWRnZSh7XG4gICAgYWN0aW9uOiBcInVuc3ViUHJpY2VXZWJTb2NrZXRcIixcbiAgICB0eXBlOiB0eXBlLFxuICB9KTtcbn1cblxuXG4vL+WPkemAgeivt+axglxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHNlbmRSZXF1ZXN0KHBhdGgsIHBhcmFtcyA9IHt9LCBtZXRob2QgPSAwLCBob3N0VHlwZSA9IDAsIGhlYWRlciA9IHt9KSB7XG4gIGNvbnNvbGUubG9nKGByZXF1ZXN0ICR7cGF0aH0sIHBhcmFtczoke0pTT04uc3RyaW5naWZ5KHBhcmFtcyl9YCk7XG5cbiAgaWYgKGhvc3RUeXBlID09IDUgfHwgaG9zdFR5cGUgPT0gNikge1xuICAgIGhlYWRlcltcIkNvbnRlbnQtVHlwZVwiXSA9IFwiYXBwbGljYXRpb24vanNvblwiO1xuICB9XG5cbiAgY29uc3QgcGFyYW0gPSB7XG4gICAgcGF0aCxcbiAgICBtZXRob2QsXG4gICAgaG9zdFR5cGUsXG4gICAgaGVhZGVyLFxuICAgIHBhcmFtcyxcbiAgfTtcbiAgdHJ5IHtcbiAgICB2YXIgcmVzcG9uc2VTdHJpbmcgPSBhd2FpdCAkbmF0aXZlQVBJLnJlcXVlc3QoSlNPTi5zdHJpbmdpZnkocGFyYW0pKTtcbiAgICB2YXIgcmVzcG9uc2UgPSBKU09OLnBhcnNlKHJlc3BvbnNlU3RyaW5nKTtcbiAgICB2YXIgeyBjb2RlLCBkYXRhIH0gPSByZXNwb25zZTtcbiAgICBpZiAoOCA9PSBob3N0VHlwZSkge1xuICAgICAgLy/lkIjnuqbnmoTmjqXlj6PlpITnkIZcbiAgICAgIHZhciBzdGF0dXMgPSByZXNwb25zZS5zdGF0dXM7XG4gICAgICB2YXIgZXJyX2NvZGUgPSByZXNwb25zZS5lcnJfY29kZTtcbiAgICAgIHZhciBlcnJfbXNnID0gcmVzcG9uc2UuZXJyX21zZztcbiAgICAgIGlmIChzdGF0dXMgPT0gXCJva1wiKSB7XG4gICAgICAgIGNvbnNvbGUubG9nKGByZXF1ZXN0ICR7cGF0aH0gZG9uZWApO1xuICAgICAgICBpZiAodHlwZW9mIGRhdGEgPT09ICdudW1iZXInKSB7XG4gICAgICAgICAgbGV0IHN0YXJ0ID0gYFwiZGF0YVwiOmA7XG4gICAgICAgICAgbGV0IHN0YXJ0SW5kZXggPSByZXNwb25zZVN0cmluZy5pbmRleE9mKHN0YXJ0KTtcbiAgICAgICAgICBsZXQgZW5kID0gYCxcInRzXCI6YDtcbiAgICAgICAgICBsZXQgZW5kSW5kZXggPSByZXNwb25zZVN0cmluZy5pbmRleE9mKGVuZCk7XG4gICAgICAgICAgbGV0IGRhdGFTdHJpbmcgPSByZXNwb25zZVN0cmluZy5zdWJzdHJpbmcoc3RhcnRJbmRleCArIHN0YXJ0Lmxlbmd0aCwgZW5kSW5kZXgpO1xuICAgICAgICAgIGNvbnNvbGUubG9nKGBkYXRhIGlzIHR5cGVvZiBudW1iZXIsIGRhdGFTdHJpbmcgPSAke2RhdGFTdHJpbmd9YCk7XG4gICAgICAgICAgcmV0dXJuIGRhdGFTdHJpbmc7XG4gICAgICAgIH1cbiAgICAgICAgcmV0dXJuIGRhdGE7XG4gICAgICB9IGVsc2Uge1xuICAgICAgICBjb25zb2xlLmxvZyhgcmVxdWVzdCBmYWlsZWQsIGNvZGU9JHtlcnJfY29kZX0sIG1lc3NhZ2U9JHtlcnJfbXNnfWApO1xuICAgICAgICBpZiAobWV0aG9kICE9IDApIHtcbiAgICAgICAgICBzaG93VG9hc3QoZXJyX21zZyk7XG4gICAgICAgIH1cbiAgICAgICAgcmV0dXJuIG51bGw7XG4gICAgICB9XG4gICAgfSBlbHNlIGlmIChjb2RlID09IDIwMCkge1xuICAgICAgaWYgKGRhdGEgPT0gbnVsbCkge1xuICAgICAgICByZXR1cm4gcmVzcG9uc2U7XG4gICAgICB9XG4gICAgICBjb25zb2xlLmxvZyhgcmVxdWVzdCAke3BhdGh9IGRvbmVgKTtcbiAgICAgIHJldHVybiBkYXRhO1xuICAgIH0gZWxzZSB7XG4gICAgICBjb25zb2xlLmxvZyhgcmVxdWVzdCBmYWlsZWQsIGNvZGU9JHtjb2RlfWApO1xuICAgICAgbGV0IG1lc3NhZ2UgPSByZXNwb25zZS5tZXNzYWdlO1xuICAgICAgaWYgKG1ldGhvZCAhPSAwICYmIG1lc3NhZ2UpIHtcbiAgICAgICAgc2hvd1RvYXN0KG1lc3NhZ2UpO1xuICAgICAgfVxuICAgICAgcmV0dXJuIG51bGw7XG4gICAgfVxuICB9IGNhdGNoIChlKSB7XG4gICAgY29uc29sZS5sb2coYHJlcXVlc3QgZXJyb3IsIGVycm9yPSR7ZX1gKTtcbiAgICByZXR1cm4gbnVsbDtcbiAgfVxufVxuXG4vL+WPkemAgeivt+axglxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHNlbmRSZXF1ZXN0UmV0dXJuQ29kZShwYXRoLCBwYXJhbXMgPSB7fSwgbWV0aG9kID0gMCwgaG9zdFR5cGUgPSAwLCBoZWFkZXIgPSB7fSkge1xuICBjb25zb2xlLmxvZyhgcmVxdWVzdCAke3BhdGh9LCBwYXJhbXM6JHtKU09OLnN0cmluZ2lmeShwYXJhbXMpfWApO1xuXG4gIGlmIChob3N0VHlwZSA9PSA1IHx8IGhvc3RUeXBlID09IDYpIHtcbiAgICBoZWFkZXJbXCJDb250ZW50LVR5cGVcIl0gPSBcImFwcGxpY2F0aW9uL2pzb25cIjtcbiAgfVxuXG4gIGNvbnN0IHBhcmFtID0ge1xuICAgIHBhdGgsXG4gICAgbWV0aG9kLFxuICAgIGhvc3RUeXBlLFxuICAgIGhlYWRlcixcbiAgICBwYXJhbXMsXG4gIH07XG4gIHRyeSB7XG4gICAgdmFyIHJlc3BvbnNlU3RyaW5nID0gYXdhaXQgJG5hdGl2ZUFQSS5yZXF1ZXN0KEpTT04uc3RyaW5naWZ5KHBhcmFtKSk7XG4gICAgdmFyIHJlc3BvbnNlID0gSlNPTi5wYXJzZShyZXNwb25zZVN0cmluZyk7XG4gICAgdmFyIHsgY29kZSwgZGF0YSB9ID0gcmVzcG9uc2U7XG4gICAgaWYgKDggPT0gaG9zdFR5cGUpIHtcbiAgICAgIC8v5ZCI57qm55qE5o6l5Y+j5aSE55CGXG4gICAgICB2YXIgc3RhdHVzID0gcmVzcG9uc2Uuc3RhdHVzO1xuICAgICAgdmFyIGVycl9jb2RlID0gcmVzcG9uc2UuZXJyX2NvZGU7XG4gICAgICB2YXIgZXJyX21zZyA9IHJlc3BvbnNlLmVycl9tc2c7XG4gICAgICBpZiAoc3RhdHVzID09IFwib2tcIikge1xuICAgICAgICByZXR1cm4gY29kZTtcbiAgICAgIH0gZWxzZSB7XG4gICAgICAgIGNvbnNvbGUubG9nKGByZXF1ZXN0IGZhaWxlZCwgY29kZT0ke2Vycl9jb2RlfSwgbWVzc2FnZT0ke2Vycl9tc2d9YCk7XG4gICAgICAgIGlmIChtZXRob2QgIT0gMCkge1xuICAgICAgICAgIHNob3dUb2FzdChlcnJfbXNnKTtcbiAgICAgICAgfVxuICAgICAgICByZXR1cm4gY29kZTtcbiAgICAgIH1cbiAgICB9IGVsc2UgaWYgKGNvZGUgPT0gMjAwKSB7XG4gICAgICBjb25zb2xlLmxvZyhgcmVxdWVzdCAke3BhdGh9IGRvbmVgKTtcbiAgICAgIHJldHVybiBjb2RlO1xuICAgIH0gZWxzZSB7XG4gICAgICBjb25zb2xlLmxvZyhgcmVxdWVzdCBmYWlsZWQsIGNvZGU9JHtjb2RlfWApO1xuICAgICAgbGV0IG1lc3NhZ2UgPSByZXNwb25zZS5tZXNzYWdlO1xuICAgICAgaWYgKG1ldGhvZCAhPSAwICYmIG1lc3NhZ2UpIHtcbiAgICAgICAgc2hvd1RvYXN0KG1lc3NhZ2UpO1xuICAgICAgfVxuICAgICAgcmV0dXJuIGNvZGU7XG4gICAgfVxuICB9IGNhdGNoIChlKSB7XG4gICAgY29uc29sZS5sb2coYHJlcXVlc3QgZXJyb3IsIGVycm9yPSR7ZX1gKTtcbiAgICByZXR1cm4gMDtcbiAgfVxufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gc2VuZFJlcXVlc3RXaXRoQ2FjaGUoXG4gIHBhdGgsXG4gIGNhbGxiYWNrLFxuICBwYXJhbXMgPSB7fSxcbiAgbWV0aG9kID0gMCxcbiAgaG9zdFR5cGUgPSAwLFxuICBoZWFkZXIgPSB7fSxcbiAgY2FjaGVLZXlMaXN0ID0gbnVsbFxuKSB7XG4gIHZhciBjYWNoZUtleSA9IGdldENhY2hlS2V5KHBhdGgsIHBhcmFtcywgY2FjaGVLZXlMaXN0KTtcbiAgY29uc3QgY2FjaGUgPSBhd2FpdCByZWFkKFwiYXBpQ2FjaGVcIiwgY2FjaGVLZXkpO1xuICBpZiAoY2FjaGUgJiYgY2FsbGJhY2spIHtcbiAgICBjYWxsYmFjayhjYWNoZSwgdHJ1ZSk7XG4gIH1cbiAgY29uc3QgcmVxdWVzdERhdGEgPSBhd2FpdCBzZW5kUmVxdWVzdChwYXRoLCBwYXJhbXMsIG1ldGhvZCwgaG9zdFR5cGUsIGhlYWRlcik7XG4gIGF3YWl0IHNhdmUoXCJhcGlDYWNoZVwiLCBjYWNoZUtleSwgcmVxdWVzdERhdGEpO1xuICBpZiAocmVxdWVzdERhdGEgJiYgY2FsbGJhY2spIHtcbiAgICBjYWxsYmFjayhyZXF1ZXN0RGF0YSwgZmFsc2UpO1xuICB9XG4gIHJldHVybiByZXF1ZXN0RGF0YTtcbn1cblxuZnVuY3Rpb24gZ2V0Q2FjaGVLZXkocGF0aCwgcGFyYW1zLCBjYWNoZUtleUxpc3QgPSBudWxsKSB7XG4gIHZhciBjYWNoZUtleSA9IFwiXCI7XG4gIGlmIChjYWNoZUtleUxpc3QgPT0gbnVsbCkge1xuICAgIC8vbnVsbO+8muaJgOacieWPguaVsOS9nOS4uue8k+WtmOWPguaVsFxuICAgIHZhciBwYXJhbVN0ciA9IEpTT04uc3RyaW5naWZ5KHBhcmFtcyk7XG4gICAgY2FjaGVLZXkgPSBgJHtwYXRofV8ke3BhcmFtU3RyfV8ke2NvbW1vbkRhdGEubGFuZ3VhZ2V9XyR7Y29tbW9uRGF0YS5jb2xvck1vZGV9XyR7Y29tbW9uRGF0YS5pc0xvZ2lufWA7XG4gIH0gZWxzZSBpZiAoY2FjaGVLZXlMaXN0Lmxlbmd0aCA9PSAwKSB7XG4gICAgLy8gW10gLOS4quaVsOS4ujDvvJrkuI3pnIDopoHlj4LmlbDkvZzkuLrnvJPlrZjlj4LmlbBcbiAgICBjYWNoZUtleSA9IGAke3BhdGh9XyR7Y29tbW9uRGF0YS5sYW5ndWFnZX1fJHtjb21tb25EYXRhLmNvbG9yTW9kZX1fJHtjb21tb25EYXRhLmlzTG9naW59YDtcbiAgfSBlbHNlIHtcbiAgICB2YXIgY2FjaGVLZXlMaXN0U3RyID0gY2FjaGVLZXlMaXN0LmpvaW4oXCJfXCIpO1xuICAgIGNhY2hlS2V5ID0gYCR7cGF0aH1fJHtjYWNoZUtleUxpc3RTdHJ9XyR7Y29tbW9uRGF0YS5sYW5ndWFnZX1fJHtjb21tb25EYXRhLmNvbG9yTW9kZX1fJHtjb21tb25EYXRhLmlzTG9naW59YDtcbiAgfVxuICByZXR1cm4gY2FjaGVLZXk7XG59XG5cbi8v5qC55o2u5rao6LeM5bmF6I635Y+W5pi+56S66aKc6ImyXG5leHBvcnQgZnVuY3Rpb24gZ2V0UHJpY2VDb2xvcihyYXRpbykge1xuICAvLyBjb25zb2xlLmxvZygnZ2V0UHJpY2VDb2xvcicpO1xuICBpZiAocmF0aW8gPT0gbnVsbCkge1xuICAgIHJhdGlvID0gMDtcbiAgfVxuICBjb25zdCByYXRpb19hYnMgPSBNYXRoLmFicyhyYXRpbyk7XG4gIHZhciBjb2xvckxldmVsID0gMDtcbiAgaWYgKHJhdGlvX2FicyA+IDAgJiYgcmF0aW9fYWJzIDwgMykge1xuICAgIGNvbG9yTGV2ZWwgPSAxO1xuICB9IGVsc2UgaWYgKHJhdGlvX2FicyA+PSAzICYmIHJhdGlvX2FicyA8IDgpIHtcbiAgICBjb2xvckxldmVsID0gMjtcbiAgfSBlbHNlIGlmIChyYXRpb19hYnMgPj0gOCkge1xuICAgIGNvbG9yTGV2ZWwgPSAzO1xuICB9XG4gIHZhciBjb2xvckhleFN0ciA9IG51bGw7XG4gIGlmIChyYXRpbyA+IDApIHtcbiAgICBjb2xvckhleFN0ciA9IHVwQ29sb3JMaXN0W2NvbG9yTGV2ZWxdO1xuICB9IGVsc2Uge1xuICAgIGNvbG9ySGV4U3RyID0gZG93bkNvbG9yTGlzdFtjb2xvckxldmVsXTtcbiAgfVxuICByZXR1cm4gY29sb3JIZXhTdHI7XG59XG5cbi8v6I635Y+W5Lu35qC85pi+56S65paH5pysXG5leHBvcnQgZnVuY3Rpb24gZ2V0UHJpY2VTdHJpbmcocHJpY2VTdHIsIHByZWNpc2lvbikge1xuICB2YXIgcHJpY2VUZW1wID0gcHJpY2VTdHI7XG4gIHZhciBkZWNpbWFsQXJyID0gcHJpY2VUZW1wLnNwbGl0KFwiLlwiKTtcbiAgaWYgKGRlY2ltYWxBcnIubGVuZ3RoIDwgMikge1xuICAgIHByaWNlVGVtcCA9IHBhcnNlRmxvYXQocHJpY2VUZW1wKS50b0ZpeGVkKDEpO1xuICAgIGRlY2ltYWxBcnIgPSBwcmljZVRlbXAuc3BsaXQoXCIuXCIpO1xuICB9XG4gIGNvbnN0IGRlY2ltYWxDb3VudCA9IGRlY2ltYWxBcnJbMV0ubGVuZ3RoO1xuICBjb25zdCBwYWRkZWRQcmljZVN0ciA9XG4gICAgZGVjaW1hbENvdW50IDwgcHJlY2lzaW9uXG4gICAgICA/IHByaWNlVGVtcC5wYWRFbmQocHJpY2VUZW1wLmxlbmd0aCArIChwcmVjaXNpb24gLSBkZWNpbWFsQ291bnQpLCBcIjBcIilcbiAgICAgIDogcGFyc2VGbG9hdChwcmljZVRlbXApLnRvRml4ZWQocHJlY2lzaW9uKTtcbiAgY29uc3QgZmluYWxQcmljZVN0ciA9IHBhZGRlZFByaWNlU3RyLnJlcGxhY2UoL1xcZCg/PShcXGR7M30pK1xcLikvZywgXCIkJixcIik7XG4gIHJldHVybiBmaW5hbFByaWNlU3RyO1xufVxuXG4vL+i/m+ihjOeyvuW6puWkhOeQhlxuZXhwb3J0IGZ1bmN0aW9uIGZvcm1hdFByZWNpc2lvbih2YWx1ZSwgcHJlY2lzaW9uKSB7XG4gIHRyeSB7XG4gICAgY29uc3QgcmVzdWx0ID0gbnVtYmVyLmZvcm1hdCh2YWx1ZSwgcHJlY2lzaW9uKTtcbiAgICByZXR1cm4gcmVzdWx0O1xuICB9IGNhdGNoIChlKSB7XG4gICAgY29uc29sZS5sb2coZSk7XG4gICAgcmV0dXJuIHZhbHVlLnRvRml4ZWQocHJlY2lzaW9uKTtcbiAgfVxufVxuXG4vLyAvL+aJk+W8gFVSTFxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIG9wZW5VUkwodXJsKSB7XG4gIGlmICghY2xpY2thYmxlKSB7XG4gICAgcmV0dXJuO1xuICB9XG4gIGNvbnNvbGUubG9nKGBvcGVuIHVybDpgLCB1cmwpO1xuICBpZiAodXJsICYmIHVybCAhPSBudWxsICYmIHVybC5sZW5ndGggPiAwKSB7XG4gICAgYXdhaXQgJG5hdGl2ZUFQSS5vcGVuUm91dGUodXJsKTtcbiAgfVxuICBjbGlja2FibGUgPSBmYWxzZTtcbiAgc2V0VGltZW91dCgoKSA9PiB7XG4gICAgY2xpY2thYmxlID0gdHJ1ZTtcbiAgfSwgMTAwMCk7XG59XG5cbi8v5omT5byA6aG16Z2iXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gb3BlblBhZ2UocGFnZSwgdHlwZSA9IFwibmF0aXZlXCIsIHBhcmFtcyA9IHt9KSB7XG4gIGF3YWl0ICRuYXRpdmVBUEkuY29weVRyYWRpbmdCcmlkZ2Uoe1xuICAgIGFjdGlvbjogXCJvcGVuUGFnZVwiLFxuICAgIHR5cGU6IHR5cGUsXG4gICAgcGFnZTogcGFnZSxcbiAgICBwYXJhbXM6IEpTT04uc3RyaW5naWZ5KHBhcmFtcyksXG4gIH0pO1xufVxuXG4vL3RvYXN0XG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gc2hvd1RvYXN0KG1zZykge1xuICBhd2FpdCAkbmF0aXZlQVBJLmhiVG9hc3QobXNnKTtcbn1cblxuLy/kv53lrZjmlbDmja5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBzYXZlKG1vZHVsZSwga2V5LCBkYXRhKSB7XG4gIGF3YWl0ICRuYXRpdmVBUEkuc3RvcmFnZSh7XG4gICAgYWN0aW9uOiBcInNhdmVcIixcbiAgICBuYW1lOiBtb2R1bGUsXG4gICAga2V5OiBrZXksXG4gICAgZGF0YTogSlNPTi5zdHJpbmdpZnkoZGF0YSksXG4gIH0pO1xufVxuXG4vL+ivu+WPluaVsOaNrlxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHJlYWQobW9kdWxlLCBrZXkpIHtcbiAgY29uc3QgZGF0YSA9IGF3YWl0ICRuYXRpdmVBUEkuc3RvcmFnZSh7XG4gICAgYWN0aW9uOiBcInJlYWRcIixcbiAgICBuYW1lOiBtb2R1bGUsXG4gICAga2V5OiBrZXksXG4gIH0pO1xuICBpZiAoZGF0YSAmJiBkYXRhICE9IFwiXCIpIHtcbiAgICByZXR1cm4gSlNPTi5wYXJzZShkYXRhKTtcbiAgfVxuICByZXR1cm4gbnVsbDtcbn1cblxuLy/muIXnkIbmlbDmja5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBjbGVhcihtb2R1bGUsIGtleSkge1xuICBhd2FpdCAkbmF0aXZlQVBJLnN0b3JhZ2Uoe1xuICAgIGFjdGlvbjogXCJjbGVhclwiLFxuICAgIG5hbWU6IG1vZHVsZSxcbiAgICBrZXk6IGtleSxcbiAgfSk7XG59XG5cbi8v5riF55CG5YWo6YOo5pWw5o2uXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gY2xlYXJBbGwobW9kdWxlKSB7XG4gIGF3YWl0ICRuYXRpdmVBUEkuc3RvcmFnZSh7XG4gICAgYWN0aW9uOiBcImNsZWFyXCIsXG4gICAgbmFtZTogbW9kdWxlLFxuICB9KTtcbn1cblxuZXhwb3J0IGZ1bmN0aW9uIGdldFVwRG93bkNvbG9yKGlzVXBwZXIgPSB0cnVlLCBsZXZlbCA9IDEpIHtcbiAgY29uc3QgbGV2ID0gbGV2ZWwgPCA0ID8gbGV2ZWwgOiAwO1xuICBpZiAoaXNVcHBlcikge1xuICAgIHJldHVybiB1cENvbG9yTGlzdFtsZXZdO1xuICB9XG4gIHJldHVybiBkb3duQ29sb3JMaXN0W2xldl07XG59XG5cbi8qKlxuICogXG4gKiBAcGFyYW0ge+aXtumXtOaXpeacn+agvOW8j+WMln0gZm10IHl5eXktTU0tZGQgaGg6bW06c3NcbiAqIEByZXR1cm5zIOagvOW8j+WMluS5i+WQjueahCDlrZfnrKbkuLLvvIznlKjms5XkvovlpoIgbmV3IERhdGUo5pe26Ze05oizKS5Gb3JtYXQoXCJ5eXl5LU1NLWRkIGhoOm1tOnNzXCIpXG4gKi9cbkRhdGUucHJvdG90eXBlLkZvcm1hdCA9IGZ1bmN0aW9uIChmbXQpIHtcbiAgdmFyIG8gPSB7XG4gICAgXCJNK1wiOiB0aGlzLmdldE1vbnRoKCkgKyAxLCAvL+aciOS7vSBcbiAgICBcImQrXCI6IHRoaXMuZ2V0RGF0ZSgpLCAvL+aXpSBcbiAgICBcImgrXCI6IHRoaXMuZ2V0SG91cnMoKSwgLy/lsI/ml7YgXG4gICAgXCJtK1wiOiB0aGlzLmdldE1pbnV0ZXMoKSwgLy/liIYgXG4gICAgXCJzK1wiOiB0aGlzLmdldFNlY29uZHMoKSwgLy/np5IgXG4gICAgXCJxK1wiOiBNYXRoLmZsb29yKCh0aGlzLmdldE1vbnRoKCkgKyAzKSAvIDMpLCAvL+Wto+W6piBcbiAgICBcIlNcIjogdGhpcy5nZXRNaWxsaXNlY29uZHMoKSAvL+avq+enkiBcbiAgfTtcbiAgaWYgKC8oeSspLy50ZXN0KGZtdCkpIGZtdCA9IGZtdC5yZXBsYWNlKFJlZ0V4cC4kMSwgKHRoaXMuZ2V0RnVsbFllYXIoKSArIFwiXCIpLnN1YnN0cig0IC0gUmVnRXhwLiQxLmxlbmd0aCkpO1xuICBmb3IgKHZhciBrIGluIG8pXG4gICAgaWYgKG5ldyBSZWdFeHAoXCIoXCIgKyBrICsgXCIpXCIpLnRlc3QoZm10KSkgZm10ID0gZm10LnJlcGxhY2UoUmVnRXhwLiQxLCAoUmVnRXhwLiQxLmxlbmd0aCA9PSAxKSA/IChvW2tdKSA6ICgoXCIwMFwiICsgb1trXSkuc3Vic3RyKChcIlwiICsgb1trXSkubGVuZ3RoKSkpO1xuICByZXR1cm4gZm10O1xufVxuXG4vKipcbiAqIFxuICogQHBhcmFtIHtib29sZWFufSBpc1Nob3cg5piv5ZCm5pi+56S65Yqg6L295qGGXG4gKi9cbmV4cG9ydCBmdW5jdGlvbiBzaG93TG9hZGluZyhpc1Nob3cgPSB0cnVlKSB7XG4gICRuYXRpdmVBUEkuc2hvd0xvYWRpbmcoaXNTaG93ID8gMSA6IDApO1xufVxuXG4vKipcbiAqIOeUn+aIkOWvjOaWh+acrO+8jOagueaNruaMh+WumueahOeJueWumuWtl+espuS4suiuvue9ruS4jeWQjOeahOminOiJsuWSjOWtl+WPt+agt+W8j+OAglxuICogQHBhcmFtIHtzdHJpbmd9IGlucHV0VGV4dCAtIOi+k+WFpeeahOaWh+acrOOAglxuICogQHBhcmFtIHtBcnJheX0gc3BlY2lmaWNTdHJpbmdzIC0g5YyF5ZCr54m55a6a5a2X56ym5Liy5Y+K5YW25qC35byP55qE5a+56LGh5pWw57uE44CCXG4gKiBAcGFyYW0ge09iamVjdH0gW2RlZmF1bHRTdHlsZV0gLSDpu5jorqTnmoTmoLflvI/lr7nosaHvvIzljIXlkKvpu5jorqTnmoTpopzoibLlkozlrZflj7fjgIJcbiAqIEByZXR1cm5zIHtzdHJpbmd9IC0g5qC85byP5YyW5ZCO55qE5a+M5paH5pys5a2X56ym5Liy44CCXG4gKi9cbmV4cG9ydCBjb25zdCBnZW5lcmF0ZVJpY2hUZXh0ID0gKGlucHV0VGV4dCwgZGVmYXVsdFN0eWxlLCBzcGVjaWZpY1N0cmluZ3MpID0+IHtcbiAgaWYgKCFkZWZhdWx0U3R5bGUpIHJldHVybiBpbnB1dFRleHQ7XG5cbiAgY29uc3QgZGVmYXVsdENvbG9yID0gZGVmYXVsdFN0eWxlLmNvbG9yIHx8ICcnO1xuICBjb25zdCBkZWZhdWx0Rm9udFNpemUgPSBkZWZhdWx0U3R5bGUuZm9udFNpemUgfHwgJyc7XG5cbiAgaWYgKCFkZWZhdWx0Q29sb3IgfHwgIWRlZmF1bHRGb250U2l6ZSkgcmV0dXJuIGlucHV0VGV4dDtcblxuICBsZXQgcmVzdWx0ID0gc3BlY2lmaWNTdHJpbmdzICYmIHNwZWNpZmljU3RyaW5ncy5sZW5ndGggPiAwXG4gICAgPyBzcGVjaWZpY1N0cmluZ3MucmVkdWNlKFxuICAgICAgKGZvcm1hdHRlZFRleHQsIHsgdGV4dCwgY29sb3IgPSBkZWZhdWx0Q29sb3IsIGZvbnRTaXplID0gZGVmYXVsdEZvbnRTaXplIH0pID0+XG4gICAgICAgIGZvcm1hdHRlZFRleHQucmVwbGFjZShcbiAgICAgICAgICBuZXcgUmVnRXhwKHRleHQsICdnJyksXG4gICAgICAgICAgYDxzcGFuIHN0eWxlPVwiY29sb3I6ICR7Y29sb3J9OyBmb250LXNpemU6ICR7Zm9udFNpemV9O1wiPiR7dGV4dH08L3NwYW4+YFxuICAgICAgICApLFxuICAgICAgYDxzcGFuIHN0eWxlPVwiY29sb3I6ICR7ZGVmYXVsdENvbG9yfTsgZm9udC1zaXplOiAke2RlZmF1bHRGb250U2l6ZX07XCI+JHtpbnB1dFRleHR9PC9zcGFuPmBcbiAgICApXG4gICAgOiBgPHNwYW4gc3R5bGU9XCJjb2xvcjogJHtkZWZhdWx0Q29sb3J9OyBmb250LXNpemU6ICR7ZGVmYXVsdEZvbnRTaXplfTtcIj4ke2lucHV0VGV4dH08L3NwYW4+YDtcbiAgY29uc29sZS5sb2coXCJyaWNoIHRleHQ6JW9cIiwgcmVzdWx0KTtcbiAgcmV0dXJuIHJlc3VsdDtcbn07XG5cblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHN1YktleWJvcmRTb2NrZXQoc2hvdykge1xuICBhd2FpdCAkbmF0aXZlQVBJLmNvcHlUcmFkaW5nQnJpZGdlKHtcbiAgICBhY3Rpb246IHNob3csXG4gICAgdHlwZTogXCJ0cmFkZUxpbWl0S2V5Ym9hcmRcIixcbiAgfSk7XG59XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBjaGVja0xvZ2luKCkge1xuICByZXR1cm4gYXdhaXQgJG5hdGl2ZUFQSS5jaGVja0xvZ2luKCk7XG59XG5cbmV4cG9ydCBmdW5jdGlvbiBnZXRQTkdJY29uVVJMQnlDdXJyZW5jeShjdXJyZW5jeSkge1xuICBsZXQgYmFzZVVybCA9IGNvbW1vbkRhdGEud2ViVXJsID8gY29tbW9uRGF0YS53ZWJVcmwgOiBcIlwiO1xuICByZXR1cm4gYCR7YmFzZVVybH0vLS94L2hiL3AvYXBpL2NvbnRlbnRzL2N1cnJlbmN5L2ljb25fcG5nLyR7Y3VycmVuY3kudG9Mb3dlckNhc2UoKX0ucG5nYDtcbn1cblxuLyog6Ziy5q2i6YeN5aSN54K55Ye7ICovXG5sZXQgY2xpY2tUaW1lciA9IDBcblxuZXhwb3J0IGZ1bmN0aW9uIGNsaWNrVGhyb3R0bGUoaW50ZXJ2YWwgPSAyMDAwKSB7XG4gIHRyeSB7XG4gICAgbGV0IG5vdyA9IG5ldyBEYXRlKCkuZ2V0VGltZSgpO1xuICAgIGxldCB0aW1lciA9IGNsaWNrVGltZXI7XG4gICAgY29uc29sZS5sb2coYGNvbW1vbiBjbGlja1Rocm90dGxlIG5vdyA9ICR7bm93fWApXG4gICAgY29uc29sZS5sb2coYGNvbW1vbiBjbGlja1Rocm90dGxlIHRpbWVyID0gJHt0aW1lcn1gKVxuICAgIGlmIChub3cgLSB0aW1lciA8IGludGVydmFsKSB7XG4gICAgICBjb25zb2xlLmxvZyhgY29tbW9uIGNsaWNrVGhyb3R0bGUgZG91YmxlIGNsaWNrYClcbiAgICAgIHJldHVybiBmYWxzZTtcbiAgICB9IGVsc2Uge1xuICAgICAgY2xpY2tUaW1lciA9IG5vdztcbiAgICAgIHJldHVybiB0cnVlO1xuICAgIH1cbiAgfSBjYXRjaCAoZSkge1xuICAgIGNvbnNvbGUubG9nKGBjb21tb24gY2xpY2tUaHJvdHRsZSBlcnJvciA9ICR7ZX1gKVxuICB9XG59XG5cbmV4cG9ydCBmdW5jdGlvbiBwYXJzZUJvb2xlYW4oc3RyaW5nKSB7XG4gIHN3aXRjaCAoU3RyaW5nKHN0cmluZykudG9Mb3dlckNhc2UoKSkge1xuICAgIGNhc2UgXCJ0cnVlXCI6XG4gICAgY2FzZSBcIjFcIjpcbiAgICBjYXNlIFwieWVzXCI6XG4gICAgY2FzZSBcInlcIjpcbiAgICAgIHJldHVybiB0cnVlO1xuICAgIGNhc2UgXCJmYWxzZVwiOlxuICAgIGNhc2UgXCIwXCI6XG4gICAgY2FzZSBcIm5vXCI6XG4gICAgY2FzZSBcIm5cIjpcbiAgICAgIHJldHVybiBmYWxzZTtcbiAgICBkZWZhdWx0OlxuICAgICAgLy95b3UgY291bGQgdGhyb3cgYW4gZXJyb3IsIGJ1dCAndW5kZWZpbmVkJyBzZWVtcyBhIG1vcmUgbG9naWNhbCByZXBseVxuICAgICAgcmV0dXJuIHVuZGVmaW5lZDtcbiAgfVxufVxuXG5leHBvcnQgZnVuY3Rpb24gbm90TnVsbChzdHJpbmcpIHtcbiAgaWYgKHN0cmluZyA9PSBudWxsIHx8IHN0cmluZyA9PSBcIlwiKSB7XG4gICAgcmV0dXJuIGZhbHNlO1xuICB9XG4gIHJldHVybiB0cnVlO1xufVxuXG4vL+Wfi+eCuVxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGFuYWx5dGljcyhldmVudCA9IFwiXCIsIHByb3BlcnRpZXMgPSB7fSkge1xuICBjb25zdCBwcm9wZXJ0aWVzSnNvbiA9IEpTT04uc3RyaW5naWZ5KHByb3BlcnRpZXMpO1xuICBjb25zb2xlLmxvZyhgYW5hbHl0aWNzIGV2ZW50OiAke2V2ZW50fSwgcHJvcGVydGllc0pzb24gPSAke3Byb3BlcnRpZXNKc29ufWApO1xuICB2YXIgbWFwID0ge1xuICAgIGV2ZW50OiBldmVudCxcbiAgICBwcm9wZXJ0aWVzOiBwcm9wZXJ0aWVzSnNvblxuICB9O1xuICBhd2FpdCAkbmF0aXZlQVBJLmFuYWx5dGljcyhtYXApO1xufVxuXG5leHBvcnQgZnVuY3Rpb24gbW9kdWxlRGVmaW5lKG1vZHVsZU5hbWUsIHN0YXJ0RnVuY3Rpb24sIGRlZmF1bHREYXRhRnVuY3Rpb24pIHtcbiAgY29uc29sZS5sb2coYGxvYWRNb2R1bGVgLCBtb2R1bGVOYW1lKTtcbiAgJGRhdGFbbW9kdWxlTmFtZV0gPSBkZWZhdWx0RGF0YUZ1bmN0aW9uKCk7XG4gICRldmVudFttb2R1bGVOYW1lXSA9IHsgc3RhcnQ6IHN0YXJ0RnVuY3Rpb24gfTtcbiAgcmV0dXJuIHtcbiAgICBtb2R1bGVFdmVudDogJGV2ZW50W21vZHVsZU5hbWVdLFxuICAgIG1vZHVsZURhdGE6ICRkYXRhW21vZHVsZU5hbWVdLFxuICB9O1xufSIsImltcG9ydCAqIGFzIGNvbW1vbiBmcm9tIFwiLi9jb21tb25cIjtcblxuYXN5bmMgZnVuY3Rpb24gc3RhcnQoKSB7XG4gIGNvbnNvbGUubG9nKGBtb3JlIGZ1bmN0aW9ucyBwb3Atc3RhcnRgKTtcbn1cblxuZnVuY3Rpb24gZGVmYXVsdERhdGEoKSB7XG4gIHJldHVybiB7XG4gICAgbWFyZ2luVmlkZW9HdWlkZUp1bXBVcmw6IFwiXCIsXG4gICAgc2hvd01hcmdpblZpZGVvR3VpZGU6IGZhbHNlLFxuICAgIHRyYW5zYWN0aW9uVHlwZTogXCJcIixcbiAgICBzaG93VXBkYXRlRGV0YWlsOiBmYWxzZSxcbiAgICBpc0xvZ2luOiBmYWxzZSxcbiAgICBpc0Zhdm9yaXRlOiBmYWxzZSxcbiAgICByZW1vdmVQb3A6IGZhbHNlLFxuICAgIGZ1bmN0aW9uVHlwZTogLTEsXG4gICAgY2xpY2tlZEl0ZW06IHtcbiAgICAgIFwidHJhbnNhY3Rpb25UeXBlXCI6IFwiXCIsXG4gICAgICBcIml0ZW1UeXBlXCI6IC0xLFxuICAgIH0sXG5cbiAgICBmdW5jdGlvbkRlcG9zaXQ6IDAsLy/lhYXluIFcbiAgICBmdW5jdGlvblRyYW5zZmVyOiAxLC8v5YiS6L2sXG4gICAgZnVuY3Rpb25UcmFkZVNldHRpbmdzOiAyLC8v5Lqk5piT6K6+572uXG4gICAgZnVuY3Rpb25CZWdpbm5lckd1aWRlOiAzLC8v5paw5omL5byV5a+8XG4gICAgZnVuY3Rpb25NYXJnaW5HdWlkZTogNCwvL+adoOadhuW8leWvvFxuICAgIGZ1bmN0aW9uQWJvdXRMb2FuOiA1LC8v5YWz5LqO5p2g5p2GXG4gICAgZnVuY3Rpb25GYXZvcml0ZTogNiwvL+iHqumAiVxuICAgIGZ1bmN0aW9uVXBkYXRlRGV0YWlsOiA3LC8v5YWR5o2i6K+m5oOFXG4gICAgZnVuY3Rpb25SdWxlczogOCwvL+S6pOaYk+inhOWImVxuICAgIGZ1bmN0aW9uUmVkZWVtOiA5LC8v6LWO5Zue6LWa5biB6K6+572uXG4gICAgZnVuY3Rpb25Mb2FuOiAxMCwvL+WAn+W4gVxuICAgIHBvcFNob3c6IGZhbHNlLCAvLyDpu5jorqTkuI3mmL7npLpcbiAgfTtcbn1cblxudmFyIGN1cnJlbmN5VXBkYXRlRGF0YSA9IHtcbiAgdXBEZXRhaWxDdXJyZW5jeTogXCJcIixcbiAgdXBncmFkZUN1cnJlbmN5OiBcIlwiLFxuICB1cGdyYWRlSnVtcFVybDogXCJcIixcbiAgdXBncmFkZURldGFpbFVybDogXCJcIixcbiAgdXBncmFkZVN0YXRlOiBmYWxzZVxufTtcblxuY29uc3QgeyBtb2R1bGVEYXRhLCBtb2R1bGVFdmVudCB9ID0gY29tbW9uLm1vZHVsZURlZmluZShcbiAgXCJleGNoYW5nZVwiLFxuICBzdGFydCxcbiAgZGVmYXVsdERhdGFcbik7XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBzZXR1cEl0ZW1zKHBhcmFtcykge1xuICBpZiAocGFyYW1zID09IG51bGwpIHJldHVybjtcblxuICBjbGlja2VkRnVuY3Rpb25JdGVtID0gZmFsc2U7XG4gIGlzUG9wRGlzbWlzcyA9IGZhbHNlO1xuICBtb2R1bGVEYXRhLnJlbW92ZVBvcCA9IGZhbHNlOy8v5q+P5qyh5bGV56S66YeN572ucG9w5by55Ye65qCH6K6wXG4gIG1vZHVsZURhdGEuZnVuY3Rpb25UeXBlID0gLTE7Ly/ph43nva7lip/og73nsbvlnovmoIforrBcblxuICBjb25zb2xlLmxvZyhwYXJhbXMpO1xuICBtb2R1bGVEYXRhLnRyYW5zYWN0aW9uVHlwZSA9IHBhcmFtcy50cmFuc2FjdGlvblR5cGU7XG4gIG1vZHVsZURhdGEuaXNMb2dpbiA9IHBhcmFtcy5pc0xvZ2luID09IFwidHJ1ZVwiID8gdHJ1ZSA6IGZhbHNlO1xuICBtb2R1bGVEYXRhLmlzRmF2b3JpdGUgPSBwYXJhbXMuaXNGYXZvcml0ZSA9PSBcInRydWVcIiA/IHRydWUgOiBmYWxzZTtcbiAgbW9kdWxlRGF0YS5zaG93TWFyZ2luVmlkZW9HdWlkZSA9IHBhcmFtcy5zaG93R3VpZGUgPT0gXCJ0cnVlXCIgPyB0cnVlIDogZmFsc2U7XG4gIGN1cnJlbmN5VXBkYXRlRGF0YSA9IGF3YWl0IGNvbW1vbi5yZWFkKFwiZ2xvYmFsXCIsIFwiY3VycmVuY3lVcGRhdGVEYXRhXCIpO1xuICBjb25zb2xlLmxvZyhgY3VycmVuY3lVcGRhdGVEYXRhPT0ke2N1cnJlbmN5VXBkYXRlRGF0YX1gKTtcbiAgbW9kdWxlRGF0YS5zaG93VXBkYXRlRGV0YWlsID0gY3VycmVuY3lVcGRhdGVEYXRhLnVwZ3JhZGVTdGF0ZTtcblxuICB2YXIgaXRlbXMgPSBbXTtcbiAgaWYgKFwibWFyZ2luXCIgPT0gbW9kdWxlRGF0YS50cmFuc2FjdGlvblR5cGUgfHwgXCJzdXBlck1hcmdpblwiID09IG1vZHVsZURhdGEudHJhbnNhY3Rpb25UeXBlKSB7XG4gICAgaXRlbXMucHVzaChnZXRJdGVtKG1vZHVsZURhdGEuZnVuY3Rpb25Mb2FuKSk7XG4gICAgaXRlbXMucHVzaChnZXRJdGVtKG1vZHVsZURhdGEuZnVuY3Rpb25UcmFuc2ZlcikpO1xuICAgIGl0ZW1zLnB1c2goZ2V0SXRlbShtb2R1bGVEYXRhLmZ1bmN0aW9uVHJhZGVTZXR0aW5ncykpO1xuICAgIGl0ZW1zLnB1c2goZ2V0SXRlbShtb2R1bGVEYXRhLmZ1bmN0aW9uQmVnaW5uZXJHdWlkZSkpO1xuICAgIGlmIChtb2R1bGVEYXRhLnNob3dNYXJnaW5WaWRlb0d1aWRlKSB7XG4gICAgICBtb2R1bGVEYXRhLm1hcmdpblZpZGVvR3VpZGVKdW1wVXJsID0gcGFyYW1zW1wianVtcFVybFwiXTtcbiAgICAgIGl0ZW1zLnB1c2goZ2V0SXRlbShtb2R1bGVEYXRhLmZ1bmN0aW9uTWFyZ2luR3VpZGUpKTtcbiAgICB9XG4gICAgaXRlbXMucHVzaChnZXRJdGVtKG1vZHVsZURhdGEuZnVuY3Rpb25BYm91dExvYW4pKTtcbiAgICBpdGVtcy5wdXNoKGdldEl0ZW0obW9kdWxlRGF0YS5mdW5jdGlvbkZhdm9yaXRlKSk7XG4gIH0gZWxzZSB7XG4gICAgaWYgKG1vZHVsZURhdGEuc2hvd1VwZGF0ZURldGFpbCkge1xuICAgICAgaXRlbXMucHVzaChnZXRJdGVtKG1vZHVsZURhdGEuZnVuY3Rpb25VcGRhdGVEZXRhaWwpKTtcbiAgICB9XG4gICAgaXRlbXMucHVzaChnZXRJdGVtKG1vZHVsZURhdGEuZnVuY3Rpb25EZXBvc2l0KSk7XG4gICAgaXRlbXMucHVzaChnZXRJdGVtKG1vZHVsZURhdGEuZnVuY3Rpb25UcmFuc2ZlcikpO1xuICAgIGl0ZW1zLnB1c2goZ2V0SXRlbShtb2R1bGVEYXRhLmZ1bmN0aW9uVHJhZGVTZXR0aW5ncykpO1xuICAgIGlmIChtb2R1bGVEYXRhLmlzTG9naW4pIHtcbiAgICAgIGl0ZW1zLnB1c2goZ2V0SXRlbShtb2R1bGVEYXRhLmZ1bmN0aW9uUmVkZWVtKSk7XG4gICAgfVxuICAgIGl0ZW1zLnB1c2goZ2V0SXRlbShtb2R1bGVEYXRhLmZ1bmN0aW9uUnVsZXMpKTtcbiAgICBpdGVtcy5wdXNoKGdldEl0ZW0obW9kdWxlRGF0YS5mdW5jdGlvbkZhdm9yaXRlKSk7XG4gIH1cbiAgbW9kdWxlRGF0YS5tb3JlRnVuY3Rpb25zID0gaXRlbXM7XG59XG5cbmZ1bmN0aW9uIGdldEl0ZW0oaXRlbVR5cGUpIHtcbiAgaWYgKGl0ZW1UeXBlID09IG1vZHVsZURhdGEuZnVuY3Rpb25Mb2FuKSB7XG4gICAgLy/lgJ/luIFcbiAgICByZXR1cm4ge1xuICAgICAgdHlwZTogaXRlbVR5cGUsXG4gICAgICBjZWxsVHlwZTogXCIxXCIsXG4gICAgICBpY29uOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9leGNoYW5nZV9tb3JlZnVuY3Rpb25fZmluYW5jZVwiLFxuICAgICAgdGl0bGU6ICRpMThuLnBvcF9tZW51X2JhbGFuY2VfbG9hbl9uZXcsXG4gICAgfTtcbiAgfSBlbHNlIGlmIChpdGVtVHlwZSA9PSBtb2R1bGVEYXRhLmZ1bmN0aW9uVHJhbnNmZXIpIHtcbiAgICAvL+WIkui9rFxuICAgIHJldHVybiB7XG4gICAgICB0eXBlOiBpdGVtVHlwZSxcbiAgICAgIGNlbGxUeXBlOiBcIjFcIixcbiAgICAgIGljb246IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX2V4Y2hhbmdlX21vcmVmdW5jdGlvbl90cmFuc2ZlclwiLFxuICAgICAgdGl0bGU6ICRpMThuLnBvcF9tZW51X2JhbGFuY2VfdHJhbnNmZXJfbmV3LFxuICAgIH07XG4gIH0gZWxzZSBpZiAoaXRlbVR5cGUgPT0gbW9kdWxlRGF0YS5mdW5jdGlvbkRlcG9zaXQpIHtcbiAgICAvL+WFheW4gVxuICAgIHJldHVybiB7XG4gICAgICB0eXBlOiBpdGVtVHlwZSxcbiAgICAgIGNlbGxUeXBlOiBcIjFcIixcbiAgICAgIGljb246IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX2V4Y2hhbmdlX21vcmVmdW5jdGlvbl9kZXBvc2l0XCIsXG4gICAgICB0aXRsZTogJGkxOG4ucG9wX21lbnVfYmFsYW5jZV9kZXBvc2l0X25ldyxcbiAgICB9O1xuICB9IGVsc2UgaWYgKGl0ZW1UeXBlID09IG1vZHVsZURhdGEuZnVuY3Rpb25UcmFkZVNldHRpbmdzKSB7XG4gICAgLy/kuqTmmJPorr7nva5cbiAgICByZXR1cm4ge1xuICAgICAgdHlwZTogaXRlbVR5cGUsXG4gICAgICBjZWxsVHlwZTogXCIxXCIsXG4gICAgICBpY29uOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9leGNoYW5nZV9tb3JlZnVuY3Rpb25fdHJhZGVfc2V0dGluZ1wiLFxuICAgICAgdGl0bGU6ICRpMThuLm5fb3RjX3RyYWRlX3NldF90aXRsZSxcbiAgICB9O1xuICB9IGVsc2UgaWYgKGl0ZW1UeXBlID09IG1vZHVsZURhdGEuZnVuY3Rpb25CZWdpbm5lckd1aWRlKSB7XG4gICAgLy/mlrDmiYvlvJXlr7xcbiAgICByZXR1cm4ge1xuICAgICAgdHlwZTogaXRlbVR5cGUsXG4gICAgICBjZWxsVHlwZTogXCIxXCIsXG4gICAgICBpY29uOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9leGNoYW5nZV9tb3JlZnVuY3Rpb25fbmV3X2d1aWRlXCIsXG4gICAgICB0aXRsZTogJGkxOG4ubl9jb250cmFjdF90cmFkZV9uZXdfZ3VpZGVfbWVudSxcbiAgICB9O1xuICB9IGVsc2UgaWYgKGl0ZW1UeXBlID09IG1vZHVsZURhdGEuZnVuY3Rpb25NYXJnaW5HdWlkZSkge1xuICAgIC8v5p2g5p2G5pWZ56iLXG4gICAgcmV0dXJuIHtcbiAgICAgIHR5cGU6IGl0ZW1UeXBlLFxuICAgICAgY2VsbFR5cGU6IFwiMVwiLFxuICAgICAgaWNvbjogXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfZXhjaGFuZ2VfbW9yZWZ1bmN0aW9uX2xvYW5fY291cnNlXCIsXG4gICAgICB0aXRsZTogJGkxOG4ubl9tYXJnaW5fdmlkZW9fZ3VpZGUsXG4gICAgfTtcbiAgfSBlbHNlIGlmIChpdGVtVHlwZSA9PSBtb2R1bGVEYXRhLmZ1bmN0aW9uQWJvdXRMb2FuKSB7XG4gICAgLy/lhbPkuo7mnaDmnYZcbiAgICByZXR1cm4ge1xuICAgICAgdHlwZTogaXRlbVR5cGUsXG4gICAgICBjZWxsVHlwZTogXCIxXCIsXG4gICAgICBpY29uOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9leGNoYW5nZV9tb3JlZnVuY3Rpb25fYWJvdXRfbG9hblwiLFxuICAgICAgdGl0bGU6ICRpMThuLnBvcF9tZW51X2JhbGFuY2VfYWJvdXRfbmV3LFxuICAgIH07XG4gIH0gZWxzZSBpZiAoaXRlbVR5cGUgPT0gbW9kdWxlRGF0YS5mdW5jdGlvbkZhdm9yaXRlKSB7XG4gICAgLy/oh6rpgIlcbiAgICB2YXIgZmF2b3JpdGVJY29uID0gbW9kdWxlRGF0YS5pc0Zhdm9yaXRlXG4gICAgICA/IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX2V4Y2hhbmdlX21vcmVmdW5jdGlvbl9mYXZvcml0ZV9zZWxcIlxuICAgICAgOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9leGNoYW5nZV9tb3JlZnVuY3Rpb25fZmF2b3JpdGVfdW5zZWxcIjtcbiAgICB2YXIgdGl0bGUgPSBtb2R1bGVEYXRhLmlzRmF2b3JpdGUgPyAkaTE4bi5uX2NvbnRyYWN0X3JlbW92ZWNvbGxlY3Rpb24gOiAkaTE4bi5uX2NvbnRyYWN0X2FkZGNvbGxlY3Rpb247XG4gICAgcmV0dXJuIHtcbiAgICAgIHR5cGU6IGl0ZW1UeXBlLFxuICAgICAgY2VsbFR5cGU6IFwiMVwiLFxuICAgICAgaWNvbjogZmF2b3JpdGVJY29uLFxuICAgICAgdGl0bGU6IHRpdGxlLFxuICAgIH07XG4gIH0gZWxzZSBpZiAoaXRlbVR5cGUgPT0gbW9kdWxlRGF0YS5mdW5jdGlvblVwZGF0ZURldGFpbCkge1xuICAgIC8v5YWR5o2i6K+m5oOFXG4gICAgcmV0dXJuIHtcbiAgICAgIHR5cGU6IGl0ZW1UeXBlLFxuICAgICAgY2VsbFR5cGU6IFwiMVwiLFxuICAgICAgaWNvbjogXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfZXhjaGFuZ2VfbW9yZWZ1bmN0aW9uX3VwZGF0ZVwiLFxuICAgICAgdGl0bGU6ICRpMThuLnBvcF9tZW51X2JhbGFuY2VfdXBkZXRhaWwsXG4gICAgfTtcbiAgfSBlbHNlIGlmIChpdGVtVHlwZSA9PSBtb2R1bGVEYXRhLmZ1bmN0aW9uUnVsZXMpIHtcbiAgICAvL+S6pOaYk+inhOWImVxuICAgIHJldHVybiB7XG4gICAgICB0eXBlOiBpdGVtVHlwZSxcbiAgICAgIGNlbGxUeXBlOiBcIjFcIixcbiAgICAgIGljb246IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX2V4Y2hhbmdlX21vcmVmdW5jdGlvbl90cmFkZV9ydWxlXCIsXG4gICAgICB0aXRsZTogJGkxOG4ubl90cmFkZV9ydWxlc190aXBzLFxuICAgIH07XG4gIH0gZWxzZSBpZiAoaXRlbVR5cGUgPT0gbW9kdWxlRGF0YS5mdW5jdGlvblJlZGVlbSkge1xuICAgIC8v6LWO5Zue6LWa5biB6K6+572uXG4gICAgcmV0dXJuIHtcbiAgICAgIHR5cGU6IGl0ZW1UeXBlLFxuICAgICAgY2VsbFR5cGU6IFwiMVwiLFxuICAgICAgaWNvbjogXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfZXhjaGFuZ2VfbW9yZWZ1bmN0aW9uX2ZpbmFuY2VcIixcbiAgICAgIHRpdGxlOiAkaTE4bi5uX2V4Y2hhbmdlX3JlZGVlbV9lYXJuX3NldHRpbmdzLFxuICAgIH07XG4gIH1cbn1cblxuLy8v54K55Ye75LqGIHBvcCDog4zmma/vvIznq6/kuIrmnInnm5HlkKwgZXhjaGFuZ2UucG9wRGlzbWlzc1xudmFyIGlzUG9wRGlzbWlzcyA9IGZhbHNlO1xuZnVuY3Rpb24gcG9wRGlzbWlzcygpIHtcbiAgY29uc29sZS5sb2coXCJAQEBAQEBAQEBAcG9wIGRpc21pc3NAQEBAQEBAXCIpO1xuICBpZiAoaXNQb3BEaXNtaXNzKSByZXR1cm47XG4gIGlzUG9wRGlzbWlzcyA9IHRydWU7XG4gIG1vZHVsZURhdGEucmVtb3ZlUG9wID0gdHJ1ZTtcbiAgbW9kdWxlRGF0YS5wb3BTaG93ID0gZmFsc2U7XG4gIGNvbnNvbGUubG9nKFwiQEBAQEBAQEBAQHBvcCBkaXNtaXNzIGVuZEBAQEBAQEBcIik7XG59XG5cbmZ1bmN0aW9uIHNob3dNb3JlVmlldygpIHtcbiAgY29uc29sZS5sb2coXCJAQEBAQEBAQEBAIHNob3dNb3JlVmlldyBAQEBAQEBAXCIpO1xuICBtb2R1bGVEYXRhLnBvcFNob3cgPSB0cnVlO1xufVxuXG4vLy/ov4fmu6Tph43lpI3ngrnlh7tcbnZhciBjbGlja2VkRnVuY3Rpb25JdGVtID0gZmFsc2U7XG5mdW5jdGlvbiBtb3JlRnVuY3Rpb25JdGVtQ2xpY2sodHlwZSkge1xuICBpZiAoY2xpY2tlZEZ1bmN0aW9uSXRlbSkgcmV0dXJuO1xuICBjbGlja2VkRnVuY3Rpb25JdGVtID0gdHJ1ZTtcbiAgbW9kdWxlRGF0YS5mdW5jdGlvblR5cGUgPSB0eXBlO1xuXG4gIG1vZHVsZURhdGEuY2xpY2tlZEl0ZW0gPSB7XG4gICAgXCJ0cmFuc2FjdGlvblR5cGVcIjogbW9kdWxlRGF0YS50cmFuc2FjdGlvblR5cGUsXG4gICAgXCJpdGVtVHlwZVwiOiB0eXBlLFxuICB9XG4gIGlmICh0eXBlID09IG1vZHVsZURhdGEuZnVuY3Rpb25SZWRlZW0pIHsvL+i1juWbnui1muW4geiuvue9rlxuICAgIGNvbnNvbGUubG9nKFwi5omT5byA6LWO5Zue6LWa5biB6aG16Z2iXCIpO1xuICAgIGNvbW1vbi5vcGVuVVJMKGBob2xpZ2VpdDovXFwvb3Blbi92MT9sb2dpbj0xJnVybD1paHVvYmlnbG9iYWw6L1xcL20uaGJnLmNvbS9lZGdlZW5naW5lL2NvbnRhaW5lcj9zY2VuZT1leGNoYW5nZSZyb290TmFtZT1yZWRlZW1TZXR0aW5ncyZuYXZDb25maWc9bmF0aXZlYCk7XG4gIH1cbiAgcG9wRGlzbWlzcygpO1xuICBjb25zb2xlLmxvZyhgbW9yZUZ1bmN0aW9uSXRlbUNsaWNrPT0ke3R5cGV9YCk7XG59XG5cbm1vZHVsZUV2ZW50LnBvcERpc21pc3MgPSBwb3BEaXNtaXNzO1xubW9kdWxlRXZlbnQuc2V0dXBJdGVtcyA9IHNldHVwSXRlbXM7XG5tb2R1bGVFdmVudC5tb3JlRnVuY3Rpb25JdGVtQ2xpY2sgPSBtb3JlRnVuY3Rpb25JdGVtQ2xpY2s7XG5tb2R1bGVFdmVudC5zaG93TW9yZVZpZXcgPSBzaG93TW9yZVZpZXc7IiwiaW1wb3J0ICogYXMgY29tbW9uIGZyb20gXCIuL2NvbW1vblwiO1xuXG5hc3luYyBmdW5jdGlvbiBzdGFydCgpIHtcbiAgY29uc29sZS5sb2coYG1vcmUgZnVuY3Rpb25zIHBvcC1zdGFydGApO1xufVxuXG5mdW5jdGlvbiBkZWZhdWx0RGF0YSgpIHtcbiAgcmV0dXJuIHtcbiAgICByZW1vdmVQb3A6IGZhbHNlLFxuICAgIC8vYnJyb3dBbmRSZXBheVR5cGU6IDAsLy8w6KGo56S66YO95pyq5byA5ZCvIDHooajnpLrlvIDlkK/lgJ/mrL4gMuihqOekuuW8gOWQr+i/mOasviAz6KGo56S65ZCM5pe25byA5ZCv5YCf5qy+5ZKM6L+Y5qy+XG4gICAgYnJyb3dTd2l0Y2g6dHJ1ZSxcbiAgICBicnJvd1NyYzpcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9jb21tb25fc3dpdGNoX29wZW5cIixcbiAgICByZXBheVN3aXRjaDp0cnVlLFxuICAgIHJlcGF5U3JjOlwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX2NvbW1vbl9zd2l0Y2hfb3BlblwiLFxuICAgIHBvcFNob3c6IGZhbHNlLCAvLyDpu5jorqTkuI3mmL7npLpcbiAgfTtcbn1cblxuXG5jb25zdCB7IG1vZHVsZURhdGEsIG1vZHVsZUV2ZW50IH0gPSBjb21tb24ubW9kdWxlRGVmaW5lKFxuICBcImJycm93QW5kUmVwYXlUeXBlUG9wXCIsXG4gIHN0YXJ0LFxuICBkZWZhdWx0RGF0YVxuKTtcblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHNldHVwVHlwZShwYXJhbXMpIHtcblxuICBpc1BvcERpc21pc3MgPSBmYWxzZTtcbiAgbW9kdWxlRGF0YS5yZW1vdmVQb3AgPSBmYWxzZTsvL+avj+asoeWxleekuumHjee9rnBvcOW8ueWHuuagh+iusCAgXG4gIG1vZHVsZURhdGEuYnJyb3dBbmRSZXBheVR5cGUgPSBwYXJzZUludChwYXJhbXMudHlwZSk7XG4gIGlmIChtb2R1bGVEYXRhLmJycm93QW5kUmVwYXlUeXBlID09IDEgfHwgbW9kdWxlRGF0YS5icnJvd0FuZFJlcGF5VHlwZSA9PSAzKSB7XG4gICAgbW9kdWxlRGF0YS5icnJvd1N3aXRjaCA9IHRydWU7XG4gICAgbW9kdWxlRGF0YS5icnJvd1NyYyA9IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX2NvbW1vbl9zd2l0Y2hfb3BlblwiO1xuICB9IGVsc2Uge1xuICAgIG1vZHVsZURhdGEuYnJyb3dTd2l0Y2ggPSBmYWxzZTtcbiAgICBtb2R1bGVEYXRhLmJycm93U3JjID0gXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfY29tbW9uX3N3aXRjaF9jbG9zZVwiO1xuICB9XG4gIGlmIChtb2R1bGVEYXRhLmJycm93QW5kUmVwYXlUeXBlID09IDIgfHwgbW9kdWxlRGF0YS5icnJvd0FuZFJlcGF5VHlwZSA9PSAzKSB7XG4gICAgbW9kdWxlRGF0YS5yZXBheVN3aXRjaCA9IHRydWU7XG4gICAgbW9kdWxlRGF0YS5yZXBheVNyYyA9IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX2NvbW1vbl9zd2l0Y2hfb3BlblwiO1xuICB9XG4gIGVsc2Uge1xuICAgIG1vZHVsZURhdGEucmVwYXlTd2l0Y2ggPSBmYWxzZTtcbiAgICBtb2R1bGVEYXRhLnJlcGF5U3JjID0gXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfY29tbW9uX3N3aXRjaF9jbG9zZVwiO1xuICB9XG4gICBtb2R1bGVEYXRhLnBvcFNob3cgPSB0cnVlO1xuXG59XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiB1cGRhdGVUeXBlKCkge1xuICB2YXIgdHlwZSA9IDA7XG4gIGlmIChtb2R1bGVEYXRhLmJycm93U3dpdGNoID09IHRydWUpIHtcbiAgICB0eXBlICs9IDE7XG4gIH1cbiAgaWYgKG1vZHVsZURhdGEucmVwYXlTd2l0Y2ggPT0gdHJ1ZSkge1xuICAgIHR5cGUgKz0gMjtcbiAgfVxuICBtb2R1bGVEYXRhLmJycm93QW5kUmVwYXlUeXBlID0gdHlwZTtcbn1cblxuLy8v54K55Ye75LqGIHBvcCDog4zmma/vvIznq6/kuIrmnInnm5HlkKwgYnJyb3dBbmRSZXBheVR5cGVQb3AucG9wRGlzbWlzc1xudmFyIGlzUG9wRGlzbWlzcyA9IGZhbHNlO1xuZnVuY3Rpb24gcG9wRGlzbWlzcygpIHtcbiAgaWYgKGlzUG9wRGlzbWlzcykgcmV0dXJuO1xuICBpc1BvcERpc21pc3MgPSB0cnVlO1xuICBtb2R1bGVEYXRhLnJlbW92ZVBvcCA9IHRydWU7XG4gIG1vZHVsZURhdGEucG9wU2hvdyA9IGZhbHNlO1xufVxuXG5mdW5jdGlvbiBzd2l0Y2hDbGljayhlbGVtZW50KSB7XG4gIFxuICBpZiAoZWxlbWVudCA9PSBcImJycm93XCIpIHtcbiAgICBpZiAobW9kdWxlRGF0YS5icnJvd1N3aXRjaCA9PSB0cnVlKSB7XG4gICAgICBtb2R1bGVEYXRhLmJycm93U3dpdGNoID0gZmFsc2U7XG4gICAgICBtb2R1bGVEYXRhLmJycm93U3JjID0gXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfY29tbW9uX3N3aXRjaF9jbG9zZVwiO1xuICAgIH1cbiAgICBlbHNlIHtcbiAgICAgIG1vZHVsZURhdGEuYnJyb3dTd2l0Y2ggPSB0cnVlO1xuICAgICAgbW9kdWxlRGF0YS5icnJvd1NyYyA9IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX2NvbW1vbl9zd2l0Y2hfb3BlblwiO1xuICAgIH1cbiAgfVxuICBlbHNlIGlmIChlbGVtZW50ID09IFwicmVwYXlcIikge1xuICAgIGlmIChtb2R1bGVEYXRhLnJlcGF5U3dpdGNoID09IHRydWUpIHtcbiAgICAgIG1vZHVsZURhdGEucmVwYXlTd2l0Y2ggPSBmYWxzZTtcbiAgICAgIG1vZHVsZURhdGEucmVwYXlTcmMgPSBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9jb21tb25fc3dpdGNoX2Nsb3NlXCI7XG4gICAgfVxuICAgIGVsc2Uge1xuICAgICAgbW9kdWxlRGF0YS5yZXBheVN3aXRjaCA9IHRydWU7XG4gICAgICBtb2R1bGVEYXRhLnJlcGF5U3JjID0gXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfY29tbW9uX3N3aXRjaF9vcGVuXCI7XG4gICAgfVxuICB9XG4gIHVwZGF0ZVR5cGUoKTtcbn1cblxuXG5cblxubW9kdWxlRXZlbnQucG9wRGlzbWlzcyA9IHBvcERpc21pc3M7XG5tb2R1bGVFdmVudC5zd2l0Y2hDbGljayA9IHN3aXRjaENsaWNrOyIsImltcG9ydCAqIGFzIGNvbW1vbiBmcm9tIFwiLi9jb21tb25cIjtcblxuY29uc3QgY29uZmlnID0ge1xuICAvKipcbiAgICogQHBhcmFtIHtudW1iZXJ9IHZhbHVlOiDotY7lm54gIDE65YWo6YOo5omT5byAIC0xOuWFqOmDqOWFs+mXrSAwOumDqOWIhuW8gOWQr1xuICAgKi9cbiAgc2V0IGlzT3Blbih2YWx1ZSkge1xuICAgIC8v5byA5ZCvL+WFs+mXreaMiemSru+8mueKtuaAgeS4uuW3suWFqOmDqOW8gOWQr+aXtu+8jOaMiemSruWxleekuuS4uuW8gOWQr++8m+eKtuaAgeS4uuW3suWFqOmDqOWFs+mXreaIluW3sumDqOWIhuW8gOWQr+aXtu+8jOaMiemSruWxleekuuS4uuWFs+mXrVxuICAgIG1vZHVsZURhdGEuc3dpdGNoT3BlbiA9IHZhbHVlID09IDEgPyBcInZpc2libGVcIiA6IFwiZ29uZVwiO1xuICAgIG1vZHVsZURhdGEuc3dpdGNoQ2xvc2UgPSB2YWx1ZSAhPSAxID8gXCJ2aXNpYmxlXCIgOiBcImdvbmVcIjtcbiAgICBpZiAodmFsdWUgPT09IDApIHtcbiAgICAgICAgbW9kdWxlRGF0YS5vcGVuVGV4dCA9ICRpMThuLm5fZXhjaGFuZ2VfcmVkZWVtX3N0YXR1c19wYXJ0X29wZW47XG4gICAgfSBlbHNlIGlmICh2YWx1ZSA9PT0gMSkge1xuICAgICAgICBtb2R1bGVEYXRhLm9wZW5UZXh0ID0gJGkxOG4ubl9leGNoYW5nZV9yZWRlZW1fc3RhdHVzX2FsbF9vcGVuO1xuICAgIH0gZWxzZSB7XG4gICAgICAgIG1vZHVsZURhdGEub3BlblRleHQgPSAkaTE4bi5uX2V4Y2hhbmdlX3JlZGVlbV9zdGF0dXNfYWxsX2Nsb3NlZDtcbiAgICB9XG4gICAgY29tbW9uLnNhdmUoXCJleGNoYW5nZVwiLCBcInJlZGVlbVN3aXRjaFYyXCIsIHZhbHVlKTtcbiAgICBjb25zb2xlLmxvZyhgdGwgLS0g6LWO5Zue5byA5YWz54q25oCBc3dpdGNoQ2xvc2U9PSR7bW9kdWxlRGF0YS5zd2l0Y2hDbG9zZX0sc3dpdGNoT3Blbj09JHttb2R1bGVEYXRhLnN3aXRjaE9wZW59YCk7XG4gIH0sXG4gIGdldCBpc09wZW4oKSB7XG4gICAgcmV0dXJuIG1vZHVsZURhdGEuc3dpdGNoT3BlbiA9PSBcInZpc2libGVcIiA/IHRydWUgOiBmYWxzZTtcbiAgfSxcbn07XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBzdGFydCgpIHtcbiAgY29uc29sZS5sb2coYHJlZGVlbSBzd2l0Y2ggcGFnZSAtc3RhcnRgKTtcbn1cblxuZnVuY3Rpb24gZGVmYXVsdERhdGEoKSB7XG4gIHJldHVybiB7XG4gICAgc3dpdGNoT3BlbjogXCJnb25lXCIsXG4gICAgc3dpdGNoQ2xvc2U6IFwiZ29uZVwiLFxuICAgIG9wZW5UZXh0OiBcIlwiLFxuICB9O1xufVxuXG5jb25zdCB7IG1vZHVsZURhdGEsIG1vZHVsZUV2ZW50IH0gPSBjb21tb24ubW9kdWxlRGVmaW5lKFxuICBcInJlZGVlbVNldHRpbmdzXCIsXG4gIHN0YXJ0LFxuICBkZWZhdWx0RGF0YVxuKTtcblxubW9kdWxlRXZlbnQub25DcmVhdGUgPSBhc3luYyBmdW5jdGlvbiAoZXZlbnRQYXJhbXMpIHtcbiAgY29uc29sZS5sb2coYHRsIC0tIG9uQ3JlYXRlLGV2ZW50UGFyYW1zPT0ke2V2ZW50UGFyYW1zfWApO1xuICBtb2R1bGVEYXRhLm5hdkNvbmZpZyA9IGdldE5hdkNvbmZpZ1N0cmluZygpO1xuXG4gIC8v6I635Y+W5pys5Zyw5byA5YWz54q25oCBXG4gIGNvbnN0IGxvY2FsU3RhdHVzID0gYXdhaXQgY29tbW9uLnJlYWQoXCJleGNoYW5nZVwiLCBcInJlZGVlbVN3aXRjaFYyXCIpO1xuICBpZiAobG9jYWxTdGF0dXMgPT0gbnVsbCkge1xuICAgIGNvbnNvbGUubG9nKGB0bCAtLSBvbkNyZWF0ZSwgbG9jYWxTdGF0dXM9bnVsbH1gKTtcbiAgICBjb25maWcuaXNPcGVuID0gLTE7XG4gIH0gZWxzZSB7XG4gICAgY29uc29sZS5sb2coYHRsIC0tIG9uQ3JlYXRlLGxvY2FsU3RhdHVzPT0ke2xvY2FsU3RhdHVzfWApO1xuICAgIGNvbmZpZy5pc09wZW4gPSBsb2NhbFN0YXR1cztcbiAgfVxufVxuXG5mdW5jdGlvbiBnZXROYXZDb25maWdTdHJpbmcoKSB7XG4gIGxldCBuYXYgPSB7XG4gICAgJ3RpdGxlS2V5JzogJ25fZXhjaGFuZ2VfcmVkZWVtX2Vhcm5fc2V0dGluZ3MnLFxuICAgICdsZWZ0Jzoge1xuICAgICAgJ2FjdGlvbic6IHtcbiAgICAgICAgJ3R5cGUnOiAnYmFjaycsXG4gICAgICAgICdwYXJhbWV0ZXInOiAnJ1xuICAgICAgfSxcbiAgICAgICdpY29uJzogJ2VkZ2VfZW5naW5lX3RvcF9iYXJfYmFja19ub3JtYWwnXG4gICAgfVxuICB9O1xuICByZXR1cm4gbmF2O1xufVxuXG5hc3luYyBmdW5jdGlvbiBxdWVyeVN3aXRjaFN0YXR1cygpIHtcbiAgY29uc29sZS5sb2coXCJ0bCAtLSDlvIDlp4vmn6Xor6LlvIDlhbPnirbmgIFcIik7XG4gIGNvbnN0IHJldCA9IGF3YWl0IGNvbW1vbi5zZW5kUmVxdWVzdChcIi92MS9zYXZpbmcvbWluaW5nL3VzZXIvYmFsYW5jZUF1dG8vcXVlcnlPbmVDbGlja1N3aXRjaFwiKTtcbiAgY29uc29sZS5sb2coYHRsIC0tIOafpeivouW8gOWFs+eKtuaAgee7k+aenHJldD09JHtyZXR9YCk7XG4gIGlmIChyZXQgIT0gbnVsbCkge1xuICAgIGNvbnNvbGUubG9nKGB0bCAtLSDmn6Xor6LlvIDlhbPnirbmgIHnu5PmnpxyZWRlZW1Td2l0Y2g9PSR7cmV0LnJlZGVlbVN3aXRjaH1gKTtcbiAgICBjb25maWcuaXNPcGVuID0gcmV0LnJlZGVlbVN3aXRjaDtcbiAgfVxufVxuXG5hc3luYyBmdW5jdGlvbiB1cGRhdGVTd2l0Y2hTdGF0dXMoKSB7XG4gIGNvbnNvbGUubG9nKGB0bCAtLSDlvIDlp4vkv67mlLnlvIDlhbPnirbmgIFgKTtcbiAgY29tbW9uLnNob3dMb2FkaW5nKCk7XG4gIHZhciBzdGF0dXMgPSBjb25maWcuaXNPcGVuID8gMCA6IDE7XG4gIGNvbnNvbGUubG9nKGB0bCAtLSDlvZPliY3lvIDlhbPnirbmgIE9PSR7Y29uZmlnLmlzT3Blbn0s55uu5qCH5byA5YWz54q25oCBPT0ke3N0YXR1c31gKTtcbiAgdmFyIHVybCA9IGB2MS9zYXZpbmcvbWluaW5nL3VzZXIvYmFsYW5jZUF1dG8vb25lQ2xpY2tSZWRlZW1Td2l0Y2hgO1xuICB2YXIgcGFyYW1zID0ge1wib3BlblwiOiBzdGF0dXN9O1xuICBjb25zdCByZXF1ZXN0UGFyYW1zID0gZ2V0UmVxdWVzdFBhcmFtcyh1cmwsIHBhcmFtcywgMSwgMCwgeyBcIkNvbnRlbnQtVHlwZVwiOiBcImFwcGxpY2F0aW9uL2pzb25cIiB9KTtcbiAgdHJ5IHtcbiAgICBjb25zdCByZXNwb25zZVN0cmluZyA9IGF3YWl0ICRuYXRpdmVBUEkucmVxdWVzdChyZXF1ZXN0UGFyYW1zKTtcbiAgICBjb25zdCByZXNwb25zZSA9IEpTT04ucGFyc2UocmVzcG9uc2VTdHJpbmcpO1xuICAgIGNvbnN0IHsgY29kZSwgbWVzc2FnZSwgZGF0YSB9ID0gcmVzcG9uc2U7XG4gICAgaWYgKGNvZGUgPT0gMjAwKSB7XG4gICAgICBjb25zb2xlLmxvZyhgdGwgLS0g5byA5aeL5L+u5pS55byA5YWz54q25oCB5oiQ5YqfYCk7XG4gICAgICBjb21tb24uc2hvd0xvYWRpbmcoZmFsc2UpO1xuICAgICAgLy8xOuWFqOmDqOaJk+W8gCAtMTrlhajpg6jlhbPpl60gMDrpg6jliIblvIDlkK9cbiAgICAgIGNvbmZpZy5pc09wZW4gPSBzdGF0dXMgPT0gMSA/IDEgOiAtMTtcbiAgICB9IGVsc2Uge1xuICAgICAgY29uc29sZS5sb2coYHRsIC0tIOW8gOWni+S/ruaUueW8gOWFs+eKtuaAgeWksei0pTExMSxjb2RlPT0ke2NvZGV9LG1lc3NhZ2U9PSR7bWVzc2FnZX1gKTtcbiAgICAgIGNvbW1vbi5zaG93TG9hZGluZyhmYWxzZSk7XG4gICAgfVxuICB9IGNhdGNoIChlKSB7XG4gICAgY29uc29sZS5sb2coYHRsIC0tIOW8gOWni+S/ruaUueW8gOWFs+eKtuaAgeWksei0pTIyMmApO1xuICAgIGNvbW1vbi5zaG93TG9hZGluZyhmYWxzZSk7XG4gIH1cbn1cblxuZnVuY3Rpb24gZ2V0UmVxdWVzdFBhcmFtcyhwYXRoLCBwYXJhbXMgPSB7fSwgbWV0aG9kID0gMCwgaG9zdFR5cGUgPSAwLCBoZWFkZXIgPSB7fSkge1xuICBjb25zdCBwYXJhbSA9IHtcbiAgICBwYXRoLFxuICAgIHBhcmFtcyxcbiAgICBtZXRob2QsXG4gICAgaG9zdFR5cGUsXG4gICAgaGVhZGVyXG4gIH07XG4gIHJldHVybiBKU09OLnN0cmluZ2lmeShwYXJhbSk7XG59XG5cbi8vL+eCueWHu+i1juWbnuW8gOWFs1xubW9kdWxlRXZlbnQuY2xpY2tlZFN3aXRjaCA9IGFzeW5jIGZ1bmN0aW9uICgpIHtcbiAgYXdhaXQgdXBkYXRlU3dpdGNoU3RhdHVzKCk7XG59XG5cbi8vL+eCueWHu2l0ZW1cbm1vZHVsZUV2ZW50LmNsaWNrZWRBdXRvUmVkZWVtID0gYXN5bmMgZnVuY3Rpb24gKCkge1xuICAvL+eCueWHu+WQjui3s+i9rOiHs+euoeeQhuiHquWKqOi1muW4gS3oh6rliqjotY7lm57pobXvvIzngrnlh7vov5Tlm57mjInpkq7vvIzlm57liLDmtLvmnJ/otZrluIHoh6rliqjotY7lm57orr7nva7pobVcbiAgY29uc29sZS5sb2coYHRsIC0tIGNsaWNrZWRBdXRvUmVkZWVtICR7Y29tbW9uLmNvbW1vbkRhdGEud2ViVXJsfS8ke2NvbW1vbi5jb21tb25EYXRhLmxhbmd1YWdlfS9maW5hbmNpYWwvZWFybi9oNS9hdXRvSW52ZXN0L2RldGlhbD90YWJJbmRleD0xYCk7XG4gIGNvbW1vbi5vcGVuVVJMKGAke2NvbW1vbi5jb21tb25EYXRhLndlYlVybH0vJHtjb21tb24uY29tbW9uRGF0YS5sYW5ndWFnZX0vZmluYW5jaWFsL2Vhcm4vaDUvYXV0b0ludmVzdC9kZXRpYWw/dGFiSW5kZXg9MWApO1xufVxuXG5tb2R1bGVFdmVudC5vbkRlc3Ryb3kgPSBhc3luYyBmdW5jdGlvbiAoKSB7XG59XG5cbm1vZHVsZUV2ZW50Lm9uUmVzdW1lID0gYXN5bmMgZnVuY3Rpb24gKCkge1xuICAvL+S7juacjeWKoeerr+afpeivouW8gOWFs+eKtuaAgVxuICBhd2FpdCBxdWVyeVN3aXRjaFN0YXR1cygpO1xufVxuXG5tb2R1bGVFdmVudC5vblBhdXNlID0gYXN5bmMgZnVuY3Rpb24gKCkge1xufVxuXG5tb2R1bGVFdmVudC5vblN0YXJ0ID0gYXN5bmMgZnVuY3Rpb24gKCkge1xufVxuXG5tb2R1bGVFdmVudC5vblN0b3AgPSBhc3luYyBmdW5jdGlvbiAoKSB7XG59XG4iLCJpbXBvcnQgKiBhcyBjb21tb24gZnJvbSAnLi9jb21tb24nXG5cbi8qKlxuICog5bm/5ZGK5L2N6YWN572uXG4gKi9cbnZhciBhZENvbmZpZyA9IHtcbiAgLy8gIOW9k+WJjeWxleekuueahOW4geWvuVxuICBhZFN5bWJvbDogJycsXG4gIC8vICDlub/lkYrnsbvlnotcbiAgYWRTaG93VHlwZTogOSxcbiAgLy8gIOW5v+WRiuagh+ivhlxuICBhZFBhZ2VUeXBlOiA0Myxcbn1cblxuLyoqXG4gKiDlub/lkYrliJfooajmlbDmja5cbiAqL1xudmFyIG5vdGljZURhdGFMaXN0ID0gW107XG5cbi8qKlxuICog5YWz6Zet55qE5bm/5ZGK5pWw5o2uXG4gKi9cbnZhciBjbG9zZWROb3RpY2VTZXQgPSBuZXcgU2V0KCk7XG5cbi8qKlxuICog5pud5YWJ55qE5bm/5ZGK5pWw5o2uXG4gKi9cbnZhciBub3RpY2VFeHBvc3VyZU1hcCA9IG5ldyBTZXQoKTtcblxuLyoqXG4gKiDliJ3lp4vljJZcbiAqL1xuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHN0YXJ0KCkgeyB9XG5cbi8qKlxuICog5Yid5aeL5YyW5pWw5o2uXG4gKiBAcmV0dXJucyB7b2JqZWN0fVxuICovXG5mdW5jdGlvbiBkZWZhdWx0RGF0YSgpIHtcbiAgcmV0dXJuIHtcbiAgICAvLyAg5bm/5ZGK5YiX6KGoXG4gICAgbm90aWNlTGlzdDogW10sXG4gICAgLy8gIOaYr+WQpuWPr+ingVxuICAgIG5vdGljZVZpc2liaWxpdHk6ICdnb25lJyxcbiAgICAvLyAg5bm/5ZGK5YiX6KGo5oyH56S65ZmoXG4gICAgbm90aWNlSW5kaWNhdG9yTGlzdDogW10sXG4gICAgLy8gIOW5v+WRiuWIl+ihqOaMh+ekuuWZqOaYr+WQpuWPr+ingVxuICAgIG5vdGljZUluZGljYXRvclZpc2liaWxpdHk6ICdnb25lJyxcbiAgICAvLyAg5piv5ZCm6Ieq5Yqo5rua5YqoXG4gICAgYXV0b1Njcm9sbDogJ3RydWUnLFxuICAgIC8vICDlvZPliY3lub/lkYrntKLlvJVcbiAgICBjdXJyZW50Tm90aWNlSW5kZXg6ICcwJ1xuICB9O1xufVxuXG5jb25zdCB7IG1vZHVsZURhdGEsIG1vZHVsZUV2ZW50IH0gPSBjb21tb24ubW9kdWxlRGVmaW5lKCdhZEFjdGl2aXR5QmFubmVyJywgc3RhcnQsIGRlZmF1bHREYXRhKTtcblxuLyoqXG4gKiDpobXpnaLlj6/op4Eg6K+35rGC5bm/5ZGK5YiX6KGoXG4gKi9cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBwYWdlQXBwZWFyKHBhcmFtcykge1xuICAvLyAg5ZCM5q2l5bm/5ZGK6YWN572uXG4gIGFkQ29uZmlnLmFkU3ltYm9sID0gcGFyYW1zLnN5bWJvbDtcbiAgYWRDb25maWcuYWRTaG93VHlwZSA9IHBhcmFtcy5zaG93VHlwZTtcbiAgYWRDb25maWcuYWRQYWdlVHlwZSA9IHBhcmFtcy5wYWdlVHlwZTtcbiAgY29uc29sZS5sb2coYCR7YWRDb25maWcuYWRTeW1ib2x9IC0g5bm/5ZGKQmFubmVyOiBwYWdlQXBwZWFyIC0gJHtKU09OLnN0cmluZ2lmeShwYXJhbXMpfWApO1xuICAvLyAg5ZCM5q2l5pys5Zyw5bey6KKr55So5oi35YWz6Zet55qE5bm/5ZGKSWRcbiAgYXdhaXQgc3luY0Nsb3NlZE5vdGljZURhdGEoKTtcbiAgLy8gIOivt+axguW5v+WRiuWIl+ihqFxuICB2YXIgcGFyYW0gPSB7ICdzeW1ib2wnOiBhZENvbmZpZy5hZFN5bWJvbCwgJ3BhZ2VUeXBlJzogYCR7YWRDb25maWcuYWRQYWdlVHlwZX1gLCAnc2hvd1R5cGUnOiBhZENvbmZpZy5hZFNob3dUeXBlIH07XG4gIGxldCBub3RpY2VEYXRhID0gYXdhaXQgY29tbW9uLnNlbmRSZXF1ZXN0KCd2MS9jb25maWcvcHVzaC9iYW5uZXIvbGlzdCcsIHBhcmFtLCAwLCAwLCB7fSk7XG4gIC8vICDov4fmu6TlkI7nmoTlub/lkYrliJfooajmlbDmja5cbiAgdmFyIGZpbHRlckFkQmFubmVyTGlzdCA9IFtdO1xuICBpZiAobm90aWNlRGF0YSAmJiBub3RpY2VEYXRhLmJhbm5lckFkdkxpc3QgIT0gbnVsbCAmJiBub3RpY2VEYXRhLmJhbm5lckFkdkxpc3QubGVuZ3RoID4gMCkge1xuICAgIGxldCBiYW5uZXJBZHZMaXN0ID0gbm90aWNlRGF0YS5iYW5uZXJBZHZMaXN0O1xuICAgIC8vICDov4fmu6Tlt7LooqvnlKjmiLflhbPpl63nmoTlub/lkYpcbiAgICBmb3IgKGxldCBpdGVtIG9mIGJhbm5lckFkdkxpc3QpIHtcbiAgICAgIGxldCBhZHZJZCA9IGl0ZW1bJ2FkdklkJ107XG4gICAgICBpZiAoY2xvc2VkTm90aWNlU2V0LmhhcyhhZHZJZCkpIHtcbiAgICAgICAgY29uc29sZS5sb2coYCR7YWRDb25maWcuYWRTeW1ib2x9IC0g5bm/5ZGKQmFubmVyOiBhZHZJZCAtICR7YWR2SWR9IOW3sui/h+a7pGApO1xuICAgICAgICBjb250aW51ZTtcbiAgICAgIH1cbiAgICAgIGNvbnNvbGUubG9nKGAke2FkQ29uZmlnLmFkU3ltYm9sfSAtIOW5v+WRikJhbm5lcjogYWR2SWQgLSAke2FkdklkfSDlt7Lmt7vliqBgKTtcbiAgICAgIGl0ZW0udHlwZSA9ICcxJztcbiAgICAgIGl0ZW0uY3VycmVudEltYWdlVVJMID0gY29tbW9uLmNvbW1vbkRhdGEuY29sb3JNb2RlID09PSAxID8gaXRlbS5uaWdodEltYWdlVXJsIDogaXRlbS5pbWFnZVVybDtcbiAgICAgIGZpbHRlckFkQmFubmVyTGlzdC5wdXNoKGl0ZW0pO1xuICAgIH1cbiAgfVxuICBsZXQgY2FjaGVMaXN0SnNvbiA9IEpTT04uc3RyaW5naWZ5KG5vdGljZURhdGFMaXN0KTtcbiAgbGV0IG5ld0xpc3RKc29uID0gSlNPTi5zdHJpbmdpZnkoZmlsdGVyQWRCYW5uZXJMaXN0KTtcbiAgaWYgKGNhY2hlTGlzdEpzb24gPT0gbmV3TGlzdEpzb24pIHtcbiAgICBjb25zb2xlLmxvZyhgJHthZENvbmZpZy5hZFN5bWJvbH0gLSDlub/lkYpCYW5uZXI6IOacgOaWsOaVsOaNruS4jue8k+WtmOaVsOaNruS4gOiHtCAtIOaXoOmcgOWkhOeQhmApO1xuICB9IGVsc2Uge1xuICAgIGNvbnNvbGUubG9nKGAke2FkQ29uZmlnLmFkU3ltYm9sfSAtIOW5v+WRikJhbm5lcjog5pyA5paw5pWw5o2u5LiO57yT5a2Y5pWw5o2u5LiN5LiA6Ie0IC0g5pu05pawYCk7XG4gICAgaGFuZGxlU2xpZGVyVmlldyhmaWx0ZXJBZEJhbm5lckxpc3QpO1xuICB9XG4gIGlmIChub3RpY2VEYXRhTGlzdC5sZW5ndGggPiAwKSB7XG4gICAgLy8gIOWPquacieS4gOadoeaVsOaNruaXtuS4jeS8muaciea7keWKqOWbnuiwgyzmiYvliqjmm53lhYnkuIrmiqVcbiAgICBub3RpY2VFeHBvc3VyZSgpO1xuICAgIG1vZHVsZURhdGEuYXV0b1Njcm9sbCA9ICd0cnVlJztcbiAgfVxufVxuXG5tb2R1bGVFdmVudC5wYWdlQXBwZWFyID0gcGFnZUFwcGVhcjtcblxuLyoqXG4gKiDpobXpnaLkuI3lj6/op4FcbiAqIEByZXR1cm5zIFxuICovXG5leHBvcnQgZnVuY3Rpb24gcGFnZURpc2FwcGVhcigpIHtcbiAgY29uc29sZS5sb2coYCR7YWRDb25maWcuYWRTeW1ib2x9IC0g5bm/5ZGKQmFubmVyOiBwYWdlRGlzYXBwZWFyYCk7XG4gIG1vZHVsZURhdGEuYXV0b1Njcm9sbCA9ICdmYWxzZSc7XG59XG5cbm1vZHVsZUV2ZW50LnBhZ2VEaXNhcHBlYXIgPSBwYWdlRGlzYXBwZWFyO1xuXG4vKipcbiAqIOWkhOeQhui9ruaSreinhuWbvlxuICogQHBhcmFtIHtBcnJheX0gbGlzdCBcbiAqL1xuZnVuY3Rpb24gaGFuZGxlU2xpZGVyVmlldyhsaXN0KSB7XG4gIG5vdGljZURhdGFMaXN0ID0gbGlzdDtcbiAgbW9kdWxlRGF0YS5ub3RpY2VMaXN0ID0gbGlzdDtcbiAgbW9kdWxlRGF0YS5ub3RpY2VWaXNpYmlsaXR5ID0gbGlzdC5sZW5ndGggPiAwID8gJ3Zpc2libGUnIDogJ2dvbmUnO1xuICBoYW5kbGVTbGlkZXJJbmRpY2F0b3JWaWV3KCk7XG59XG5cbi8qKlxuICog5aSE55CG6L2u5pKt5oyH56S65Zmo6KeG5Zu+XG4gKi9cbmZ1bmN0aW9uIGhhbmRsZVNsaWRlckluZGljYXRvclZpZXcoKSB7XG4gIGxldCBpbmRpY2F0b3JMaXN0ID0gW107XG4gIGZvciAobGV0IGluZGV4ID0gMDsgaW5kZXggPCBub3RpY2VEYXRhTGlzdC5sZW5ndGg7IGluZGV4KyspIHtcbiAgICBpZiAobW9kdWxlRGF0YS5jdXJyZW50Tm90aWNlSW5kZXggPT0gU3RyaW5nKGluZGV4KSkge1xuICAgICAgaW5kaWNhdG9yTGlzdC5wdXNoKHsgJ3R5cGUnOiAnMScgfSk7XG4gICAgfSBlbHNlIHtcbiAgICAgIGluZGljYXRvckxpc3QucHVzaCh7ICd0eXBlJzogJzInIH0pO1xuICAgIH1cbiAgfVxuICBtb2R1bGVEYXRhLm5vdGljZUluZGljYXRvclZpc2liaWxpdHkgPSBpbmRpY2F0b3JMaXN0Lmxlbmd0aCA+IDEgPyAndmlzaWJsZScgOiAnZ29uZSc7XG4gIG1vZHVsZURhdGEubm90aWNlSW5kaWNhdG9yTGlzdCA9IGluZGljYXRvckxpc3Q7XG59XG5cbi8qKlxuICog5pud5YWJXG4gKiBAcmV0dXJucyBcbiAqL1xuYXN5bmMgZnVuY3Rpb24gbm90aWNlRXhwb3N1cmUoKSB7XG4gIHZhciBpbmRleCA9IHBhcnNlSW50KG1vZHVsZURhdGEuY3VycmVudE5vdGljZUluZGV4KTtcbiAgaWYgKGluZGV4ID49IG5vdGljZURhdGFMaXN0Lmxlbmd0aCkge1xuICAgIHJldHVybjtcbiAgfVxuICB2YXIgb2JqID0gbm90aWNlRGF0YUxpc3RbaW5kZXhdO1xuICBsZXQgYWR2SWQgPSBvYmpbJ2FkdklkJ107XG4gIGlmIChub3RpY2VFeHBvc3VyZU1hcC5oYXMoYWR2SWQpKSB7XG4gICAgLy8gY29uc29sZS5sb2coYCR7YWRDb25maWcuYWRTeW1ib2x9IC0g5bm/5ZGKQmFubmVyOiAke2FkdklkfSAtIOW3suabneWFiWApO1xuICB9IGVsc2Uge1xuICAgIC8vIGNvbnNvbGUubG9nKGAke2FkQ29uZmlnLmFkU3ltYm9sfSAtIOW5v+WRikJhbm5lcjogJHthZHZJZH0gLSDmnKrmm53lhYlgKTtcbiAgICB0cnkge1xuICAgICAgYXdhaXQgY29tbW9uLmFuYWx5dGljcygnYXBwX3Nwb3RfdHJhZGVfbWlkZGxlQURfc2hvd3ZpZXcnLCB7XG4gICAgICAgIGFkX2lkOiBTdHJpbmcoYWR2SWQpLFxuICAgICAgICBhZF9UaXRsZTogb2JqWyd0aXRsZSddLFxuICAgICAgICBhZF9UeXBlOiBTdHJpbmcoYWRDb25maWcuYWRTaG93VHlwZSksXG4gICAgICB9KTtcbiAgICAgIG5vdGljZUV4cG9zdXJlTWFwLmFkZChhZHZJZCk7XG4gICAgfSBjYXRjaCAoZSkge1xuICAgICAgY29uc29sZS5sb2coYCR7YWRDb25maWcuYWRTeW1ib2x9IC0g5bm/5ZGKQmFubmVyOiBub3RpY2VFeHBvc3VyZSBlcnJvciAtICR7ZX1gKTtcbiAgICB9XG4gIH1cbn1cblxuLyoqXG4gKiDlub/lkYrkvY3pgInkuK3nm5HlkKxcbiAqIEBwYXJhbSB7bnVtYmVyfSBpbmRleCBcbiAqL1xubW9kdWxlRXZlbnQuc2VsZWN0ZWROb3RpY2VJbmRleCA9IGFzeW5jIGZ1bmN0aW9uIChpbmRleCkge1xuICBtb2R1bGVEYXRhLmN1cnJlbnROb3RpY2VJbmRleCA9IFN0cmluZyhpbmRleCk7XG4gIGhhbmRsZVNsaWRlckluZGljYXRvclZpZXcoKTtcbiAgbm90aWNlRXhwb3N1cmUoKTtcbn1cblxuLyoqXG4gKiDngrnlh7vlub/lkYrkvY1cbiAqIEByZXR1cm5zIFxuICovXG5tb2R1bGVFdmVudC5jbGlja05vdGljZUl0ZW0gPSBhc3luYyBmdW5jdGlvbiAoKSB7XG4gIGxldCBpbmRleCA9IHBhcnNlSW50KG1vZHVsZURhdGEuY3VycmVudE5vdGljZUluZGV4KTtcbiAgaWYgKGluZGV4ID49IG5vdGljZURhdGFMaXN0Lmxlbmd0aCkge1xuICAgIHJldHVybjtcbiAgfVxuICBsZXQgb2JqID0gbm90aWNlRGF0YUxpc3RbaW5kZXhdO1xuICBpZiAob2JqLmp1bXBUbyAhPSBudWxsKSB7XG4gICAgY29uc29sZS5sb2coYCR7YWRDb25maWcuYWRTeW1ib2x9IC0g5bm/5ZGKQmFubmVyOiAke29iai5qdW1wVG99YCk7XG4gICAgYXdhaXQgY29tbW9uLm9wZW5VUkwoZW5jb2RlVVJJKG9iai5qdW1wVG8pKTtcbiAgfVxuICB0cnkge1xuICAgIGF3YWl0IGNvbW1vbi5hbmFseXRpY3MoJ2FwcF9zcG90X3RyYWRlX21pZGRsZUFEX2NsaWNrJywge1xuICAgICAgYWRfaWQ6IFN0cmluZyhvYmpbJ2FkdklkJ10pLFxuICAgICAgYWRfVGl0bGU6IG9ialsndGl0bGUnXSxcbiAgICAgIGFkX1R5cGU6IFN0cmluZyhhZENvbmZpZy5hZFNob3dUeXBlKSxcbiAgICB9KTtcbiAgfSBjYXRjaCAoZSkge1xuICAgIGNvbnNvbGUubG9nKGAke2FkQ29uZmlnLmFkU3ltYm9sfSAtIOW5v+WRikJhbm5lcjogY2xpY2tOb3RpY2VJdGVtIGVycm9yIC0gJHtlfWApO1xuICB9XG59XG5cbi8qKlxuICog546w6LSn57yT5a2Y5qih5Z2X5ZCN56ewXG4gKi9cbmNvbnN0IGNhY2hlTW9kdWxlTmFtZSA9ICdzcG90QWROb3RpY2UnO1xuXG4vKipcbiAqIOeOsOi0p+e8k+WtmOW5v+WRiklk5ZCN56ewXG4gKi9cbmNvbnN0IGNhY2hlQWRJZEtleSA9ICdzcG90Tm90aWNlQ2xvc2VkSWRMaXN0JztcblxuLyoqXG4gKiDlhbPpl63lub/lkYrkvY1cbiAqL1xubW9kdWxlRXZlbnQuY2xpY2tOb3RpY2VDbG9zZSA9IGFzeW5jIGZ1bmN0aW9uICgpIHtcbiAgbW9kdWxlRGF0YS5ub3RpY2VWaXNpYmlsaXR5ID0gJ2dvbmUnO1xuICBtb2R1bGVEYXRhLmF1dG9TY3JvbGwgPSAnZmFsc2UnO1xuICBsZXQgY2xvc2VkSWRMaXN0ID0gW107XG4gIGZvciAobGV0IGl0ZW0gb2Ygbm90aWNlRGF0YUxpc3QpIHtcbiAgICBjbG9zZWROb3RpY2VTZXQuYWRkKGl0ZW1bJ2FkdklkJ10pO1xuICB9XG4gIGNsb3NlZE5vdGljZVNldC5mb3JFYWNoKGZ1bmN0aW9uICh2YWx1ZSkge1xuICAgIGNsb3NlZElkTGlzdC5wdXNoKHZhbHVlKTtcbiAgfSlcbiAgbm90aWNlRGF0YUxpc3QgPSBbXTtcbiAgbW9kdWxlRGF0YS5ub3RpY2VMaXN0ID0gW107XG4gIC8vICDlrZjlgqjlhbPpl63lub/lkYpcbiAgY29uc29sZS5sb2coYCR7YWRDb25maWcuYWRTeW1ib2x9IC0g5bm/5ZGKQmFubmVyOiDlrZjlgqjlhbPpl61JZHMgLSAke0pTT04uc3RyaW5naWZ5KGNsb3NlZElkTGlzdCl9YCk7XG4gIGF3YWl0IGNvbW1vbi5zYXZlKGNhY2hlTW9kdWxlTmFtZSwgY2FjaGVBZElkS2V5LCBjbG9zZWRJZExpc3QpO1xufVxuXG4vKipcbiAqIOWQjOatpeW3suWFs+mXreeahOW5v+WRiumbhuWQiFxuICovXG5hc3luYyBmdW5jdGlvbiBzeW5jQ2xvc2VkTm90aWNlRGF0YSgpIHtcbiAgY2xvc2VkTm90aWNlU2V0LmNsZWFyKCk7XG4gIHZhciBjbG9zZWRJZExpc3QgPSBhd2FpdCBjb21tb24ucmVhZChjYWNoZU1vZHVsZU5hbWUsIGNhY2hlQWRJZEtleSk7XG4gIGlmIChjbG9zZWRJZExpc3QgJiYgY2xvc2VkSWRMaXN0Lmxlbmd0aCA+IDApIHtcbiAgICBjb25zb2xlLmxvZyhgJHthZENvbmZpZy5hZFN5bWJvbH0gLSDlub/lkYpCYW5uZXI6IOivu+WPluWFs+mXrUlkcyAtICR7SlNPTi5zdHJpbmdpZnkoY2xvc2VkSWRMaXN0KX1gKTtcbiAgICBmb3IgKGxldCBpdGVtIG9mIGNsb3NlZElkTGlzdCkge1xuICAgICAgY2xvc2VkTm90aWNlU2V0LmFkZChpdGVtKTtcbiAgICB9XG4gIH1cbn0iLCJpbXBvcnQgKiBhcyBjb21tb24gZnJvbSBcIi4vY29tbW9uXCI7XG5pbXBvcnQgKiBhcyBtb3JlRnVuY3Rpb25Qb3AgZnJvbSBcIi4vbW9yZUZ1bmN0aW9uUG9wXCI7XG5pbXBvcnQgKiBhcyBicnJvd0FuZFJlcGF5VHlwZVBvcCBmcm9tIFwiLi9icnJvd0FuZFJlcGF5VHlwZVBvcFwiO1xuaW1wb3J0ICogYXMgcmVkZWVtU2V0dGluZ3MgZnJvbSBcIi4vcmVkZWVtU2V0dGluZ3NcIjtcbmltcG9ydCAqIGFzIGFkQWN0aXZpdHlCYW5uZXIgZnJvbSBcIi4vYWRBY3Rpdml0eUJhbm5lclwiO1xuXG5mdW5jdGlvbiBzZW5kQ29tbW9uQ29uZmlnKHBhcmFtKSB7XG4gIGNvbW1vbi5zZW5kQ29tbW9uQ29uZmlnKHBhcmFtKTtcbn1cblxuYXN5bmMgZnVuY3Rpb24gbW9kdWxlQXBwZWFyKCkge1xufVxuXG5mdW5jdGlvbiBtb2R1bGVXaWxsRGlzYXBwZWFyKCkge1xufVxuXG5hc3luYyBmdW5jdGlvbiBtb2R1bGVEaXNhcHBlYXIoKSB7XG4gIGNvbnNvbGUubG9nKCdtb2R1bGVEaXNhcHBlYXInKTtcbn1cblxuZnVuY3Rpb24gc2VuZE1vcmVGdW5jdGlvbnNQb3BEYXRhKHBhcmFtcykge1xuICBtb3JlRnVuY3Rpb25Qb3Auc2V0dXBJdGVtcyhwYXJhbXMpO1xufVxuXG5mdW5jdGlvbiBzZW5kQnJyb3dBbmRSZXBheVR5cGUocGFyYW1zKSB7XG4gIGJycm93QW5kUmVwYXlUeXBlUG9wLnNldHVwVHlwZShwYXJhbXMpO1xufVxuXG5yZWRlZW1TZXR0aW5ncy5zdGFydCgpO1xuXG4kZXZlbnQuc2VuZENvbW1vbkNvbmZpZyA9IHNlbmRDb21tb25Db25maWc7XG4kZXZlbnQuc2VuZE1vcmVGdW5jdGlvbnNQb3BEYXRhID0gc2VuZE1vcmVGdW5jdGlvbnNQb3BEYXRhO1xuJGV2ZW50Lm1vZHVsZUFwcGVhciA9IG1vZHVsZUFwcGVhcjtcbiRldmVudC5tb2R1bGVXaWxsRGlzYXBwZWFyID0gbW9kdWxlV2lsbERpc2FwcGVhcjtcbiRldmVudC5tb2R1bGVEaXNhcHBlYXIgPSBtb2R1bGVEaXNhcHBlYXI7XG4kZXZlbnQuc2VuZEJycm93QW5kUmVwYXlUeXBlID0gc2VuZEJycm93QW5kUmVwYXlUeXBlOyJdLCJuYW1lcyI6WyJNQVhfRFAiLCJNQVhfUE9XRVIiLCJOQU1FIiwiSU5WQUxJRCIsIklOVkFMSURfRFAiLCJJTlZBTElEX1JNIiwiRElWX0JZX1pFUk8iLCJQIiwiVU5ERUZJTkVEIiwicm91bmQiLCJ4IiwiZHAiLCJybSIsIm1vcmUiLCJjIiwiaSIsImUiLCJ4YyIsImxlbmd0aCIsIkVycm9yIiwidW5zaGlmdCIsInBvcCIsInN0cmluZ2lmeSIsImlkIiwibiIsImsiLCJzIiwiQmlnIiwiY29uc3RydWN0b3IiLCJ6IiwiUk0iLCJwdXNoIiwiTkUiLCJQRSIsImNoYXJBdCIsInNsaWNlIiwiYWJzIiwidGhpcyIsImNtcCIsInkiLCJ5YyIsImoiLCJsIiwiaXNuZWciLCJkaXYiLCJhIiwiYiIsIkRQIiwiYmwiLCJidCIsInJpIiwiYnoiLCJhaSIsImFsIiwiciIsInJsIiwicSIsInFjIiwicWkiLCJkIiwic2hpZnQiLCJlcSIsImd0IiwiZ3RlIiwibHQiLCJsdGUiLCJtaW51cyIsInN1YiIsInQiLCJ4bHR5IiwicGx1cyIsInhlIiwieWUiLCJyZXZlcnNlIiwibW9kIiwieWd0eCIsInRpbWVzIiwiYWRkIiwicG93Iiwib25lIiwic3FydCIsImhhbGYiLCJNYXRoIiwiam9pbiIsInRvRXhwb25lbnRpYWwiLCJpbmRleE9mIiwibXVsIiwiQXJyYXkiLCJ0b0ZpeGVkIiwidG9QcmVjaXNpb24iLCJzZCIsInRvU3RyaW5nIiwidmFsdWVPZiIsInRvSlNPTiIsImNsaWNrYWJsZSIsImNvbW1vbkRhdGEiLCJwcmljZUNvbG9yVHlwZSIsImNvbG9yTW9kZSIsIk9TIiwid2ViVXJsIiwiYXBwVmVyc2lvbiIsImlzSW5SZXZpZXciLCJpc0xvZ2luIiwibGFuZ3VhZ2UiLCJhc3luYyIsInNlbmRDb21tb25Db25maWckMSIsInBhcmFtIiwiY29uc29sZSIsImxvZyIsInBhcnNlSW50IiwicmVkQ29sb3JMaXN0IiwiZ3JlZW5Db2xvckxpc3QiLCJ1cENvbG9yTGlzdCIsImRvd25Db2xvckxpc3QiLCJzZW5kUmVxdWVzdCIsInBhcmFtcyIsIm1ldGhvZCIsImhvc3RUeXBlIiwiaGVhZGVyIiwicGF0aCIsIkpTT04iLCJyZXNwb25zZVN0cmluZyIsIiRuYXRpdmVBUEkiLCJyZXF1ZXN0IiwicmVzcG9uc2UiLCJwYXJzZSIsImNvZGUiLCJkYXRhIiwic3RhdHVzIiwiZXJyX2NvZGUiLCJlcnJfbXNnIiwic3RhcnQiLCJzdGFydEluZGV4IiwiZW5kIiwiZW5kSW5kZXgiLCJkYXRhU3RyaW5nIiwic3Vic3RyaW5nIiwic2hvd1RvYXN0IiwibWVzc2FnZSIsIm9wZW5VUkwiLCJ1cmwiLCJvcGVuUm91dGUiLCJzZXRUaW1lb3V0IiwiaGJUb2FzdCIsIm1zZyIsInNhdmUiLCJtb2R1bGUiLCJrZXkiLCJzdG9yYWdlIiwiYWN0aW9uIiwibmFtZSIsInJlYWQiLCJEYXRlIiwicHJvdG90eXBlIiwiRm9ybWF0IiwiZm10IiwiZ2V0TW9udGgiLCJnZXREYXRlIiwiZ2V0SG91cnMiLCJnZXRNaW51dGVzIiwiZ2V0U2Vjb25kcyIsIlMiLCJnZXRNaWxsaXNlY29uZHMiLCJ0ZXN0IiwicmVwbGFjZSIsIlJlZ0V4cCIsIiQxIiwiZ2V0RnVsbFllYXIiLCJzdWJzdHIiLCJvIiwic2hvd0xvYWRpbmciLCJpc1Nob3ciLCJldmVudCIsInByb3BlcnRpZXMiLCJwcm9wZXJ0aWVzSnNvbiIsIm1hcCIsImFuYWx5dGljcyIsIm1vZHVsZURlZmluZSIsInN0YXJ0RnVuY3Rpb24iLCJkZWZhdWx0RGF0YUZ1bmN0aW9uIiwibW9kdWxlTmFtZSIsIiRkYXRhIiwiJGV2ZW50IiwibW9kdWxlRXZlbnQiLCJtb2R1bGVEYXRhIiwic3RhcnQkMyIsImRlZmF1bHREYXRhJDMiLCJtYXJnaW5WaWRlb0d1aWRlSnVtcFVybCIsInNob3dNYXJnaW5WaWRlb0d1aWRlIiwidHJhbnNhY3Rpb25UeXBlIiwic2hvd1VwZGF0ZURldGFpbCIsImlzRmF2b3JpdGUiLCJyZW1vdmVQb3AiLCJmdW5jdGlvblR5cGUiLCJjbGlja2VkSXRlbSIsIml0ZW1UeXBlIiwiZnVuY3Rpb25EZXBvc2l0IiwiZnVuY3Rpb25UcmFuc2ZlciIsImZ1bmN0aW9uVHJhZGVTZXR0aW5ncyIsImZ1bmN0aW9uQmVnaW5uZXJHdWlkZSIsImZ1bmN0aW9uTWFyZ2luR3VpZGUiLCJmdW5jdGlvbkFib3V0TG9hbiIsImZ1bmN0aW9uRmF2b3JpdGUiLCJmdW5jdGlvblVwZGF0ZURldGFpbCIsImZ1bmN0aW9uUnVsZXMiLCJmdW5jdGlvblJlZGVlbSIsImZ1bmN0aW9uTG9hbiIsInBvcFNob3ciLCJjdXJyZW5jeVVwZGF0ZURhdGEiLCJ1cERldGFpbEN1cnJlbmN5IiwidXBncmFkZUN1cnJlbmN5IiwidXBncmFkZUp1bXBVcmwiLCJ1cGdyYWRlRGV0YWlsVXJsIiwidXBncmFkZVN0YXRlIiwibW9kdWxlRGF0YSQzIiwibW9kdWxlRXZlbnQkMyIsImRlZmF1bHREYXRhIiwic2V0dXBJdGVtcyIsImlzUG9wRGlzbWlzcyIsInNob3dHdWlkZSIsIml0ZW1zIiwiZ2V0SXRlbSIsIm1vcmVGdW5jdGlvbnMiLCJ0eXBlIiwiY2VsbFR5cGUiLCJpY29uIiwidGl0bGUiLCIkaTE4biIsInBvcF9tZW51X2JhbGFuY2VfbG9hbl9uZXciLCJwb3BfbWVudV9iYWxhbmNlX3RyYW5zZmVyX25ldyIsInBvcF9tZW51X2JhbGFuY2VfZGVwb3NpdF9uZXciLCJuX290Y190cmFkZV9zZXRfdGl0bGUiLCJuX2NvbnRyYWN0X3RyYWRlX25ld19ndWlkZV9tZW51Iiwibl9tYXJnaW5fdmlkZW9fZ3VpZGUiLCJwb3BfbWVudV9iYWxhbmNlX2Fib3V0X25ldyIsImZhdm9yaXRlSWNvbiIsIm5fY29udHJhY3RfcmVtb3ZlY29sbGVjdGlvbiIsIm5fY29udHJhY3RfYWRkY29sbGVjdGlvbiIsInBvcF9tZW51X2JhbGFuY2VfdXBkZXRhaWwiLCJuX3RyYWRlX3J1bGVzX3RpcHMiLCJuX2V4Y2hhbmdlX3JlZGVlbV9lYXJuX3NldHRpbmdzIiwiaXNQb3BEaXNtaXNzJDEiLCJwb3BEaXNtaXNzJDEiLCJzaG93TW9yZVZpZXciLCJjbGlja2VkRnVuY3Rpb25JdGVtIiwibW9yZUZ1bmN0aW9uSXRlbUNsaWNrIiwiY29tbW9uLm9wZW5VUkwiLCJwb3BEaXNtaXNzIiwic3RhcnQkMiIsImRlZmF1bHREYXRhJDIiLCJicnJvd1N3aXRjaCIsImJycm93U3JjIiwicmVwYXlTd2l0Y2giLCJyZXBheVNyYyIsIm1vZHVsZURhdGEkMiIsIm1vZHVsZUV2ZW50JDIiLCJzZXR1cFR5cGUiLCJicnJvd0FuZFJlcGF5VHlwZSIsInVwZGF0ZVR5cGUiLCJzd2l0Y2hDbGljayIsImVsZW1lbnQiLCJjb25maWciLCJpc09wZW4iLCJ2YWx1ZSIsInN3aXRjaE9wZW4iLCJtb2R1bGVEYXRhJDEiLCJzd2l0Y2hDbG9zZSIsIm9wZW5UZXh0Iiwibl9leGNoYW5nZV9yZWRlZW1fc3RhdHVzX3BhcnRfb3BlbiIsIm5fZXhjaGFuZ2VfcmVkZWVtX3N0YXR1c19hbGxfb3BlbiIsIm5fZXhjaGFuZ2VfcmVkZWVtX3N0YXR1c19hbGxfY2xvc2VkIiwiY29tbW9uLnNhdmUiLCJzdGFydCQxIiwiZGVmYXVsdERhdGEkMSIsIm1vZHVsZUV2ZW50JDEiLCJvbkNyZWF0ZSIsImV2ZW50UGFyYW1zIiwibmF2Q29uZmlnIiwiZ2V0TmF2Q29uZmlnU3RyaW5nIiwibG9jYWxTdGF0dXMiLCJuYXYiLCJ0aXRsZUtleSIsImxlZnQiLCJwYXJhbWV0ZXIiLCJxdWVyeVN3aXRjaFN0YXR1cyIsInJldCIsInJlZGVlbVN3aXRjaCIsInVwZGF0ZVN3aXRjaFN0YXR1cyIsImNvbW1vbi5zaG93TG9hZGluZyIsIm9wZW4iLCJyZXF1ZXN0UGFyYW1zIiwiZ2V0UmVxdWVzdFBhcmFtcyIsImNsaWNrZWRTd2l0Y2giLCJjbGlja2VkQXV0b1JlZGVlbSIsImNvbW1vbi5jb21tb25EYXRhIiwib25EZXN0cm95Iiwib25SZXN1bWUiLCJvblBhdXNlIiwib25TdGFydCIsIm9uU3RvcCIsImFkQ29uZmlnIiwiYWRTeW1ib2wiLCJhZFNob3dUeXBlIiwiYWRQYWdlVHlwZSIsIm5vdGljZURhdGFMaXN0IiwiY2xvc2VkTm90aWNlU2V0IiwiU2V0Iiwibm90aWNlRXhwb3N1cmVNYXAiLCJub3RpY2VMaXN0Iiwibm90aWNlVmlzaWJpbGl0eSIsIm5vdGljZUluZGljYXRvckxpc3QiLCJub3RpY2VJbmRpY2F0b3JWaXNpYmlsaXR5IiwiYXV0b1Njcm9sbCIsImN1cnJlbnROb3RpY2VJbmRleCIsInBhZ2VBcHBlYXIiLCJzeW1ib2wiLCJzaG93VHlwZSIsInBhZ2VUeXBlIiwic3luY0Nsb3NlZE5vdGljZURhdGEiLCJjb21tb24uc2VuZFJlcXVlc3QiLCJub3RpY2VEYXRhIiwiZmlsdGVyQWRCYW5uZXJMaXN0IiwiYmFubmVyQWR2TGlzdCIsIml0ZW0iLCJhZHZJZCIsImhhcyIsIm5pZ2h0SW1hZ2VVcmwiLCJpbWFnZVVybCIsImNhY2hlTGlzdEpzb24iLCJuZXdMaXN0SnNvbiIsImhhbmRsZVNsaWRlclZpZXciLCJub3RpY2VFeHBvc3VyZSIsInBhZ2VEaXNhcHBlYXIiLCJsaXN0IiwiaGFuZGxlU2xpZGVySW5kaWNhdG9yVmlldyIsImluZGljYXRvckxpc3QiLCJpbmRleCIsIlN0cmluZyIsIm9iaiIsImFkX2lkIiwiYWRfVGl0bGUiLCJhZF9UeXBlIiwic2VsZWN0ZWROb3RpY2VJbmRleCIsImNsaWNrTm90aWNlSXRlbSIsImp1bXBUbyIsImVuY29kZVVSSSIsImNhY2hlTW9kdWxlTmFtZSIsImNhY2hlQWRJZEtleSIsImNsaWNrTm90aWNlQ2xvc2UiLCJjbG9zZWRJZExpc3QiLCJmb3JFYWNoIiwiY2xlYXIiLCJzZW5kQ29tbW9uQ29uZmlnIiwibW9kdWxlQXBwZWFyIiwibW9kdWxlV2lsbERpc2FwcGVhciIsIm1vZHVsZURpc2FwcGVhciIsInNlbmRNb3JlRnVuY3Rpb25zUG9wRGF0YSIsInNlbmRCcnJvd0FuZFJlcGF5VHlwZSJdLCJtYXBwaW5ncyI6IkFBaUJHLElBYURBLFNBQVMsS0FHVEMsWUFBWSxLQXNCWkMsT0FBTyxhQUNQQyxVQUFVRCxPQUFPLFlBQ2pCRSxhQUFhRCxVQUFVLGtCQUN2QkUsYUFBYUYsVUFBVSxpQkFDdkJHLGNBQWNKLE9BQU8sb0JBR3JCSyxJ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
