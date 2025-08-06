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

function multiply(x, y) {
    return new Big(x).times(y).toString();
}

function format(value, precision) {
    const bigValue = new Big(value);
    let stringValue = bigValue.toString();
    if (stringValue.includes(".")) {
        let strArray = stringValue.split(".");
        if (strArray[1].length >= precision) {
            if (0 == precision) {
                return strArray[0];
            } else {
                let truncate = strArray[1].substring(0, precision);
                return `${strArray[0]}.${truncate}`;
            }
        } else {
            let zeroNumber = precision - strArray[1].length;
            var str = "";
            for (let i = 0; i < zeroNumber; i++) {
                str += "0";
            }
            return `${stringValue}${str}`;
        }
    } else {
        if (0 == precision) {
            return stringValue;
        } else {
            let zeroNumber = precision;
            var str = "";
            for (let i = 0; i < zeroNumber; i++) {
                str += "0";
            }
            return `${stringValue}.${str}`;
        }
    }
}

var clickable = true;

function moduleDefine(moduleName, defaultDataFunction, functions = {
    onCreate: onCreate$5,
    onDestroy: onDestroy$4,
    onResume: onResume$3,
    onPause: onPause$3,
    onStart: onStart$4,
    onStop: onStop$2
}) {
    console.log(`loadModule`, moduleName);
    $data[moduleName] = defaultDataFunction();
    $event[moduleName] = {
        onCreate: typeof functions.onCreate == "undefined" ? onCreate$5 : functions.onCreate,
        onDestroy: typeof functions.onDestroy == "undefined" ? onDestroy$4 : functions.onDestroy,
        onResume: typeof functions.onResume == "undefined" ? onResume$3 : functions.onResume,
        onPause: typeof functions.onPause == "undefined" ? onPause$3 : functions.onPause,
        onStart: typeof functions.onStart == "undefined" ? onStart$4 : functions.onStart,
        onStop: typeof functions.onStop == "undefined" ? onStop$2 : functions.onStop
    };
    return {
        moduleData: $data[moduleName],
        moduleEvent: $event[moduleName]
    };
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

function onCreate$5() {
    console.log("common onCreate");
}

function onDestroy$4() {}

function onResume$3() {}

function onPause$3() {}

function onStart$4() {}

function onStop$2() {}

var commonData = {
    priceColorType: 0,
    colorMode: 0,
    OS: 0,
    appVersion: "",
    isInReview: 1,
    h5Url: "",
    language: "",
    statusHeight: 0,
    vToken: "",
    oldVToken: ""
};

$data.commonData = commonData;

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

function getCommonConfig(param) {
    console.log(param);
    commonData.priceColorType = parseInt(param.priceColorType);
    commonData.colorMode = parseInt(param.colorMode);
    commonData.OS = parseInt(param.OS);
    commonData.appVersion = param.appVersion;
    commonData.isInReview = parseInt(param.isInReview);
    commonData.language = param.language;
    commonData.h5Url = param.h5Url;
    commonData.statusHeight = param.statusHeight;
    commonData.vToken = param.vToken;
    commonData.oldVToken = param.oldVToken;
    $data.commonData = commonData;
    $data.deposit.statusHeight = commonData.statusHeight;
    $data.detail.statusHeight = commonData.statusHeight;
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

async function showToast(msg) {
    await $nativeAPI.hbToast(msg);
}

function showLoading(isShow = true) {
    $nativeAPI.showLoading(isShow ? 1 : 0);
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

function formatPrecision(value, precision) {
    try {
        const result = format(value, precision);
        return result;
    } catch (e) {
        console.log(e);
        return value.toFixed(precision);
    }
}

function containerBack() {
    console.log("containerBack");
    $nativeAPI.containerBack();
}

function getPriceString(priceStr, precision) {
    const priceNum = Number(priceStr);
    const bigValue = new Big(priceNum);
    const priceString = precision == -1 ? bigValue.toString() : bigValue.toFixed(precision);
    const finalPriceStr = priceString.replace(/\d+/, (function(n) {
        return n.replace(/(\d)(?=(\d{3})+$)/g, (function($1) {
            return $1 + ",";
        }));
    }));
    return finalPriceStr;
}

function getPriceColor(isRise) {
    if (isRise) {
        return commonData.priceColorType == 1 ? "#00A171" : "#E94359";
    } else {
        return commonData.priceColorType == 0 ? "#00A171" : "#E94359";
    }
}

$data.alert = {
    content: "",
    title: $i18n.n_copy_trading_tip,
    alertPopShow: "false",
    priceTips: ""
};

$event.alert = {
    showLimitAlert() {
        $event.deposit.closeKeyBoard();
        $data.alert.content = $data.deposit.userSurplusAlert;
        $data.alert.alertPopShow = "true";
    },
    showSettlementAlert() {
        $event.deposit.closeKeyBoard();
        $data.alert.content = $data.alert.priceTips;
        $data.alert.alertPopShow = "true";
        analytics("app_earn_shakeFin_orderDetail_priceAtExpirationExplanation_click");
    },
    showAutoSubscribeAlert() {
        $event.deposit.closeKeyBoard();
        $data.alert.title = $i18n.n_shark_fin_autoSubscribe_title;
        $data.alert.content = `${$i18n.n_shark_fin_autoSubscribe_content_1}\n${$i18n.n_shark_fin_autoSubscribe_content_2}`;
        $data.alert.alertPopShow = "true";
    },
    confirm() {
        $data.alert.alertPopShow = "false";
        $data.alert.title = $i18n.n_copy_trading_tip;
    }
};

var projectId = 0;

var orderId = 0;

var needRefresh = false;

var sTime = 0;

var sysTime = 0;

var startTime = 0;

var intercal = null;

const mm = 60;

const hh = 3600;

const dd = 86400;

var autoSubscribe$1 = 0;

function defaultData$4() {
    return {
        datalist: [],
        inputData: {},
        confirmShow: "false",
        successShow: "gone",
        confirmlist: [],
        userSurplusAlert: "",
        onFocus: "false",
        onFocusInternal: "false",
        editText: "",
        inputText: "",
        balanceAmount: 0,
        userLowerLimit: 0,
        userSurplusAmount: 0,
        surplusAmount: 0,
        coin: "",
        unit: "",
        buttonEnabled: false,
        btnColor: "@color/eButtonUnenabledBgColor",
        confirmBtnColor: "@color/eButtonUnenabledBgColor",
        huobiSelected: false,
        huobiAgreeImage: "@drawable/edge_engine_live_redpacket_unselect",
        statusHeight: 20,
        navTitle: "",
        id: "",
        successText: "",
        empty: "gone",
        notEmpty: "gone",
        showInput: "gone",
        btnTitle: "",
        needCountDown: "gone",
        borderColor: "@color/baseColorInputBackground",
        switchColor: "@color/KBaseColorContentBackground",
        switchBackColor: "@color/eButtonUnenabledBgColor",
        switchWidth: "2"
    };
}

function onCreate$4(eventParams) {
    reloadData$1();
    buttonChangeStatus();
    moduleData$4.statusBarConfig = {
        statusBarMode: "false"
    };
    if (!eventParams || eventParams == null) {
        showDetailEmpty$1(true);
        return;
    }
    const params = JSON.parse(eventParams);
    projectId = params.projectId;
    requestBuyDetail(projectId);
}

function onDestroy$3() {
    clearTimer$1();
    reloadData$1();
}

function onResume$2() {
    if (needRefresh) {
        needRefresh = false;
        requestBuyDetail(projectId);
    } else {
        startTimer$1();
    }
}

function onPause$2() {
    clearTimer$1();
}

const {moduleData: moduleData$4, moduleEvent: moduleEvent$4} = moduleDefine("deposit", defaultData$4, {
    onCreate: onCreate$4,
    onDestroy: onDestroy$3,
    onResume: onResume$2,
    onPause: onPause$2,
    onStart: onStart$3
});

async function requestBuyDetail(projectId) {
    showLoading(true);
    const data = await sendRequest("v4/saving/mining/shark/project/buy/detail", {
        projectId: projectId
    });
    showLoading(false);
    if (!data || data == null) {
        showDetailEmpty$1(true);
        return;
    }
    showDetailEmpty$1(false);
    handleDetailData$1(data);
}

function handleDetailData$1(data) {
    sTime = data.sTime;
    sysTime = (new Date).getTime();
    const projectDetail = data.projectDetail;
    if (projectDetail && projectDetail != null) {
        moduleData$4.id = projectDetail.id;
        moduleData$4.coin = projectDetail.currency;
        moduleData$4.unit = projectDetail.quoteCurrency;
        const minRate = formatPrecision(multiply(projectDetail.minRate, "100"), 2);
        const maxRate = formatPrecision(multiply(projectDetail.maxRate, "100"), 2);
        const expiryTime = new Date(projectDetail.expiryTime).Format("yyyy/MM/dd");
        const callPutText = projectDetail.callPut == 1 ? $i18n.$intercept.n_shark_fin_bullish(projectDetail.currency) : $i18n.$intercept.n_shark_fin_bearish(projectDetail.currency);
        const callPutColor = getPriceColor(projectDetail.callPut == 1);
        moduleData$4.navTitle = callPutText;
        moduleData$4.datalist = [ {
            type: "normal",
            name: $i18n.n_shark_fin_APY_Est,
            value: `${minRate}% ~ ${maxRate}%`
        }, {
            type: "normal",
            name: $i18n.n_mining_duration,
            value: `${projectDetail.term} ${$i18n.n_mining_day_text}`
        }, {
            type: "normal",
            name: $i18n.n_mining_end_time,
            value: expiryTime
        } ];
        moduleData$4.confirmlist = [ {
            type: "normal",
            name: $i18n.n_shark_fin_product_type,
            value: "",
            state: callPutText,
            stateColor: callPutColor
        }, {
            type: "num",
            name: $i18n.n_asset_subscribe_number,
            value: `${moduleData$4.inputText} ${projectDetail.quoteCurrency}`,
            state: `${$i18n.n_assets_transfer_spot} -${moduleData$4.inputText} ${projectDetail.quoteCurrency}`
        }, {
            type: "normal",
            name: $i18n.n_shark_fin_APY_Est,
            value: `${minRate}% ~ ${maxRate}%`,
            state: "",
            stateColor: "@color/kColorPrimaryText"
        }, {
            type: "normal",
            name: $i18n.n_mining_duration,
            value: `${projectDetail.term} ${$i18n.n_mining_day_text}`,
            state: "",
            stateColor: "@color/kColorPrimaryText"
        }, {
            type: "normal",
            name: $i18n.n_mining_end_time,
            value: expiryTime,
            state: "",
            stateColor: "@color/kColorPrimaryText"
        }, {
            type: "normal",
            name: $i18n.n_shark_fin_autoSubscribe,
            value: "",
            state: "",
            stateColor: "@color/kColorPrimaryText"
        } ];
        const userSurplus = `${getPriceString(data.userSurplusAmount, -1)} ${projectDetail.quoteCurrency}`;
        moduleData$4.userSurplusAlert = $i18n.$intercept.n_shark_fin_alert_limit_new(userSurplus);
        const balanceTitleColor = data.balanceAmount > data.userLowerLimit ? "@color/kColorThreeLevelText" : "@color/KBaseInputInvalidTipColor";
        const balanceColor = data.balanceAmount > data.userLowerLimit ? "@color/kColorPrimaryText" : "@color/KBaseInputInvalidTipColor";
        const userSurplusColor = data.userSurplusAmount >= data.userLowerLimit ? "@color/kColorPrimaryText" : "@color/KBaseInputInvalidTipColor";
        const surplusColor = data.surplusAmount >= data.userLowerLimit ? "@color/kColorPrimaryText" : "@color/KBaseInputInvalidTipColor";
        moduleData$4.inputData = {
            type: "I",
            name: $i18n.n_asset_subscribe_number,
            unit: projectDetail.quoteCurrency,
            balanceTitleColor: balanceTitleColor,
            balanceColor: balanceColor,
            balance: `${getPriceString(data.balanceAmount, -1)} ${projectDetail.quoteCurrency}`,
            hint: $i18n.$intercept.n_shark_fin_min_amount(`${data.userLowerLimit}`),
            userSurplus: userSurplus,
            userSurplusColor: userSurplusColor,
            surplus: `${getPriceString(data.surplusAmount, -1)} ${projectDetail.quoteCurrency}`,
            surplusColor: surplusColor
        };
        const viewStatus = projectDetail.viewStatus;
        startTime = projectDetail.subscribeStartTime;
        if (viewStatus == 0 || startTime > sTime) {
            moduleData$4.needCountDown = "visible";
            changeCountdown();
            startTimer$1();
        } else {
            moduleData$4.needCountDown = "gone";
            moduleData$4.showInput = "visible";
            moduleData$4.btnTitle = $i18n.n_balance_subscribe_btn;
        }
        $event.pnlrule.handleData(data.projectDetail);
        moduleData$4.balanceAmount = data.balanceAmount;
        moduleData$4.userLowerLimit = data.userLowerLimit;
        moduleData$4.userSurplusAmount = data.userSurplusAmount;
        moduleData$4.surplusAmount = data.surplusAmount;
    }
}

function onStart$3() {
    analytics("app_earn_shakeFinSubscribe_view");
}

function buttonChangeStatus() {
    console.log("buttonChangeStatus ");
    const inputNumber = parseFloat(moduleData$4.inputText);
    const normalColor = moduleData$4.onFocusInternal == "true" ? "@color/kColorMajorTheme100" : "@color/baseColorInputBackground";
    if (inputNumber > 0 && inputNumber <= moduleData$4.balanceAmount && inputNumber >= moduleData$4.userLowerLimit && inputNumber <= moduleData$4.userSurplusAmount && inputNumber <= moduleData$4.surplusAmount) {
        moduleData$4.buttonEnabled = true;
        moduleData$4.btnColor = "@color/kColorMajorTheme100";
        moduleData$4.borderColor = normalColor;
        console.log("buttonChangeStatus 1");
    } else {
        moduleData$4.buttonEnabled = false;
        moduleData$4.btnColor = "@color/eButtonUnenabledBgColor";
        if (moduleData$4.inputText == "") {
            moduleData$4.borderColor = normalColor;
            console.log("buttonChangeStatus 2 ");
        } else {
            moduleData$4.borderColor = "@color/KBaseInputInvalidTipColor";
            console.log("buttonChangeStatus 3 ");
        }
    }
}

function showDetailEmpty$1(show) {
    moduleData$4.empty = show ? "visible" : "gone";
    moduleData$4.notEmpty = show ? "gone" : "visible";
}

function startTimer$1() {
    if (moduleData$4.needCountDown == "visible" && intercal == null) {
        intercal = setInterval(changeCountdown, 1e3);
    }
}

function clearTimer$1() {
    if (intercal != null) {
        clearInterval(intercal);
        intercal = null;
    }
}

function changeCountdown() {
    const serverTimeDiff = startTime - sTime;
    const sysTimeDiff = (new Date).getTime() - sysTime;
    const difference = (serverTimeDiff - sysTimeDiff) / 1e3;
    if (difference > 0) {
        moduleData$4.showInput = "gone";
        const d = Math.floor(difference / dd);
        const h = Math.floor(difference % dd / hh);
        const m = Math.floor(difference % hh / mm);
        const s = Math.floor(difference % mm);
        const showH = h < 10 ? `0${h}` : `${h}`;
        const showM = m < 10 ? `0${m}` : `${m}`;
        const showS = s < 10 ? `0${s}` : `${s}`;
        if (d > 0) {
            moduleData$4.btnTitle = `${d}${$i18n.n_mining_day_text} ${showH}:${showM}:${showS}`;
        } else {
            moduleData$4.btnTitle = `${showH}:${showM}:${showS}`;
        }
    } else {
        moduleData$4.showInput = "visible";
        moduleData$4.btnTitle = $i18n.n_balance_subscribe_btn;
        moduleData$4.needCountDown = "gone";
        clearTimer$1();
    }
}

function inputNum(t) {
    const inputRe = /^[1-9]\d*$/;
    if (t == null || isNaN(t) || inputRe.test(t) == false) {
        return false;
    }
    return true;
}

function reloadData$1() {
    moduleData$4.navTitle = "";
    moduleData$4.notEmpty = "gone";
    moduleData$4.empty = "gone";
    moduleData$4.successShow = "gone";
    moduleData$4.inputText = "";
    moduleData$4.editText = "";
    moduleData$4.onFocus = "false";
    moduleData$4.onFocusInternal = "false";
    moduleData$4.datalist = [];
    moduleData$4.inputData = {};
    moduleData$4.huobiSelected = false;
    moduleData$4.huobiAgreeImage = "@drawable/edge_engine_live_redpacket_unselect";
    moduleData$4.confirmBtnColor = "@color/eButtonUnenabledBgColor";
}

moduleEvent$4.focusChange = function(focus) {
    moduleData$4.onFocusInternal = focus ? "true" : "false";
    buttonChangeStatus();
};

moduleEvent$4.textChange = function(text) {
    if (text == "" || inputNum(text)) {
        moduleData$4.inputText = text;
    } else {
        moduleData$4.editText = moduleData$4.inputText;
    }
    buttonChangeStatus();
};

moduleEvent$4.onReturn = function(params) {
    moduleData$4.onFocus = "false";
    moduleData$4.onFocusInternal = "false";
};

moduleEvent$4.clickedAll = function() {
    var minAmount = Math.min(moduleData$4.balanceAmount, moduleData$4.userSurplusAmount, moduleData$4.surplusAmount);
    minAmount = Math.floor(minAmount);
    moduleData$4.editText = `${minAmount}`;
    moduleData$4.inputText = moduleData$4.editText;
    buttonChangeStatus();
    analytics("app_earn_shakeFinSubscribe_amount_all_click");
};

moduleEvent$4.closeKeyBoard = function() {
    moduleData$4.onFocus = "false";
    moduleData$4.onFocusInternal = "false";
};

function toBack() {
    clearTimer$1();
    containerBack();
}

moduleEvent$4.backClicked = function() {
    analytics("app_earn_shakeFinSubscribe_returnButton_click");
    toBack();
};

moduleEvent$4.popConfirmOpen = function() {
    analytics("app_earn_shakeFinSubscribe_subscribeButton_click");
    moduleEvent$4.closeKeyBoard();
    if (!moduleData$4.buttonEnabled) {
        return;
    }
    moduleData$4.confirmlist[1].value = `${moduleData$4.inputText} ${moduleData$4.unit}`;
    moduleData$4.confirmlist[1].state = `${$i18n.n_assets_transfer_spot} -${moduleData$4.inputText} ${moduleData$4.unit}`;
    moduleData$4.confirmlist[5].value = autoSubscribe$1 == 0 ? $i18n.n_shark_fin_autoSubscribe_close : $i18n.n_shark_fin_autoSubscribe_open;
    moduleData$4.confirmShow = "true";
    analytics("app_earn_shakeFin_confirmOrderWindows_show");
};

moduleEvent$4.popConfirmClose = function() {
    moduleData$4.confirmShow = "false";
    analytics("app_earn_shakeFin_confirmOrderWindows_closeButton_click");
};

moduleEvent$4.huobiSelected = function() {
    if (moduleData$4.huobiSelected) {
        moduleData$4.huobiSelected = false;
        moduleData$4.huobiAgreeImage = "@drawable/edge_engine_live_redpacket_unselect";
        moduleData$4.confirmBtnColor = "@color/eButtonUnenabledBgColor";
    } else {
        moduleData$4.huobiSelected = true;
        moduleData$4.huobiAgreeImage = "@drawable/edge_engine_live_redpacket_select";
        moduleData$4.confirmBtnColor = "@color/kColorMajorTheme100";
    }
};

moduleEvent$4.huobilink = function() {
    moduleData$4.confirmShow = "false";
    openURL(`${commonData.h5Url}/support/${commonData.language}/detail/24952033711717`);
};

moduleEvent$4.popSuccessOpen = async function() {
    analytics("app_earn_shakeFin_confirmOrderWindows_confirmButton_show");
    if (!moduleData$4.huobiSelected) {
        return;
    }
    const param = {
        id: moduleData$4.id,
        amount: moduleData$4.inputText,
        vToken: commonData.vToken,
        oldVToken: commonData.oldVToken,
        autoSubscribe: autoSubscribe$1
    };
    showLoading(true);
    const data = await sendRequest("v4/saving/mining/shark/project/demand", param, 1, 0, {
        "Content-Type": "application/json"
    });
    showLoading(false);
    if (data && data != null) {
        moduleData$4.confirmShow = "false";
        moduleData$4.successText = `${data.amount} ${data.currency}`;
        orderId = data.orderId;
        moduleData$4.successShow = "visible";
        analytics("app_earn_shakeFin_subscribeSuccess_view");
    }
};

moduleEvent$4.popSuccessClose = function() {
    analytics("app_earn_shakeFin_subscribeSuccess_closeButton_click");
    moduleEvent$4.backClicked();
};

moduleEvent$4.openDetail = function() {
    needRefresh = true;
    moduleEvent$4.backClicked();
    analytics("app_earn_shakeFin_subscribeSuccess_viewOrdersButton_click");
    openURL(`holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/edgeengine/container?scene=sharkfin&rootName=detail&navConfig=&type=order&id=${orderId}`);
};

moduleEvent$4.jumpToTransfer = function(coin) {
    needRefresh = true;
    moduleEvent$4.closeKeyBoard();
    const url = `holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/balance/transfer?coin=${coin}&account=5`;
    openURL(url);
    analytics("app_earn_shakeFinSubscribe_transferButton_click");
};

moduleEvent$4.jumpToBuyCoin = function(coin) {
    needRefresh = true;
    moduleEvent$4.closeKeyBoard();
    var url = `holigeit://open/v1?&login=1&url=ihuobiglobal://m.hbg.com/otc/index?tradeArea=p2p&isOutArea=true&tradeSide=buy&tradeCurrency=USDT`;
    openURL(url);
    analytics("app_earn_shakeFinSubscribe_buyButton_click");
};

moduleEvent$4.autoClicked = function() {
    if (autoSubscribe$1 == 0) {
        autoSubscribe$1 = 1;
        moduleData$4.switchColor = "@color/KBaseColorContentBackground";
        moduleData$4.switchBackColor = "@color/baseColorMajorTheme100";
        moduleData$4.switchWidth = "14";
    } else {
        autoSubscribe$1 = 0;
        moduleData$4.switchColor = "@color/KBaseColorContentBackground";
        moduleData$4.switchBackColor = "@color/eButtonUnenabledBgColor";
        moduleData$4.switchWidth = "2";
    }
};

$data.pnlrule = {
    subTitle: "",
    KeyTitle: "",
    key1: "",
    key2: "",
    value1: "",
    value2: "",
    minRate: "",
    maxRate: "",
    minPrice: "",
    maxPrice: "",
    src: "",
    showIcon: "gone",
    showContent: ""
};

$event.pnlrule = {
    handleData(params) {
        const barrier = getPriceString(params.barrier, -1);
        if (params.viewStatus == 3) {
            const settlementPrice = getPriceString(params.settlementPrice, -1);
            $data.pnlrule.subTitle = $i18n.$intercept.n_shark_fin_settlement_price(params.currency) + `: $${settlementPrice}`;
            $data.pnlrule.showIcon = params.settlementPrice > 0 ? "visible" : "gone";
            const expiryTime = new Date(params.expiryTime).Format("yyyy/MM/dd");
            if (params.settlementRemarkType == -1) {
                $data.pnlrule.showIcon = "gone";
            } else if (params.settlementRemarkType == 0) {
                $data.pnlrule.showContent = $i18n.$intercept.n_shark_fin_toast_3(`${expiryTime}`);
            } else {
                const settlementPriceTime = new Date(params.settlementPriceTime).Format("yyyy/MM/dd hh:mm:ss");
                const settlementPriceTimeEnd = new Date(params.settlementPriceTime + 3599e3).Format("yyyy/MM/dd hh:mm:ss");
                if (params.callPut == 1) {
                    $data.pnlrule.showContent = $i18n.$intercept.n_shark_fin_toast_bullish(`${settlementPriceTime}`, `${settlementPriceTimeEnd}`, `$${barrier}`, `${settlementPriceTime}`, `${settlementPriceTimeEnd}`, `$${settlementPrice}`);
                } else {
                    $data.pnlrule.showContent = $i18n.$intercept.n_shark_fin_toast_bearish(`${settlementPriceTime}`, `${settlementPriceTimeEnd}`, `$${barrier}`, `${settlementPriceTime}`, `${settlementPriceTimeEnd}`, `$${settlementPrice}`);
                }
            }
        } else {
            $data.pnlrule.subTitle = $i18n.$intercept.n_shark_fin_current_price_new(params.currency, "");
            $data.pnlrule.showIcon = "gone";
            requestMarketPrice(params);
        }
        $data.pnlrule.KeyTitle = $i18n.$intercept.n_shark_fin_settlement_price(params.currency);
        const minRate = formatPrecision(multiply(params.minRate, "100"), 2);
        const maxRate = formatPrecision(multiply(params.maxRate, "100"), 2);
        const strike = getPriceString(params.strike, -1);
        if (params.callPut == 1) {
            $data.pnlrule.key1 = `< $${strike} ${$i18n.n_otc_order_or} > $${barrier}`;
            $data.pnlrule.key2 = `$${strike} ~ $${barrier}`;
            $data.pnlrule.minPrice = `$${strike}`;
            $data.pnlrule.maxPrice = `$${barrier}`;
            $data.pnlrule.src = "@drawable/edge_engine_sharkfin_introduce_up";
            $data.alert.priceTips = $i18n.$intercept.n_shark_fin_alert_product_n(params.currency, ` > $${barrier}`, `${minRate}%`, ` <= $${barrier}`, params.currency, $data.pnlrule.key2, `${minRate}% ~ ${maxRate}%`, params.currency, ` < $${strike}`, `${minRate}%`);
        } else {
            $data.pnlrule.key1 = `< $${barrier} ${$i18n.n_otc_order_or} > $${strike}`;
            $data.pnlrule.key2 = `$${barrier} ~ $${strike}`;
            $data.pnlrule.minPrice = `$${barrier}`;
            $data.pnlrule.maxPrice = `$${strike}`;
            $data.pnlrule.src = "@drawable/edge_engine_sharkfin_introduce_down";
            $data.alert.priceTips = $i18n.$intercept.n_shark_fin_alert_product_n(params.currency, ` < $${barrier}`, `${minRate}%`, ` >= $${barrier}`, params.currency, $data.pnlrule.key2, `${minRate}% ~ ${maxRate}%`, params.currency, ` > $${strike}`, `${minRate}%`);
        }
        $data.pnlrule.value1 = `${minRate}%`;
        $data.pnlrule.value2 = `${minRate}% ~ ${maxRate}%`;
        $data.pnlrule.minRate = `${minRate}%`;
        $data.pnlrule.maxRate = `${maxRate}%`;
    },
    clearData() {
        $data.pnlrule.src = "";
    },
    showIconAlert() {
        $data.alert.content = $data.pnlrule.showContent;
        $data.alert.alertPopShow = "true";
    }
};

async function requestMarketPrice(params) {
    const reqParams = {
        path: "market/priceAll",
        method: 0,
        hostType: 4,
        header: {
            "Content-Type": "application/json"
        },
        params: {}
    };
    try {
        var responseString = await $nativeAPI.request(JSON.stringify(reqParams));
        var response = JSON.parse(responseString);
        var {status: status, code: code, data: data} = response;
        if (status && status == "ok" || code && code == 200) {
            const key = `${params.currency}${params.quoteCurrency}`.toLowerCase();
            const result = data[key];
            if (result && result != null) {
                const tPrice = getPriceString(result[0], -1);
                $data.pnlrule.subTitle = $i18n.$intercept.n_shark_fin_current_price_new(params.currency, `$${tPrice}`);
            }
        }
    } catch (e) {
        console.log(`requestMarketPrice error, error=${e}`);
    }
}

var viewStatus = 0;

var autoSubscribe = 0;

var autoSubscribeState = 0;

var autoOrderId = "";

function defaultData$3() {
    return {
        navTitle: "",
        celllist: [],
        unit: "USDT",
        empty: "gone",
        notEmpty: "gone",
        subscribeEndTime: 0,
        orderShow: "gone",
        buyNumber: "",
        buyPnl: "",
        buyNumberAmount: "",
        buyPnlAmount: "",
        statusHeight: 20,
        type: "",
        borderColor: "@color/baseColorInputBackground",
        switchColor: "@color/KBaseColorContentBackground",
        switchBackColor: "@color/eButtonUnenabledBgColor",
        switchWidth: "2",
        switchOpacity: "1",
        resultRemark: $i18n.n_shark_fin_autoSubscribe_desc,
        resultColor: "@color/kColorThreeLevelText"
    };
}

function onCreate$3(eventParams) {
    reloadData();
    moduleData$3.statusBarConfig = {
        statusBarMode: "false"
    };
    console.log("detail:%o", eventParams);
    if (!eventParams || eventParams == null) {
        showDetailEmpty(true);
        return;
    }
    const params = JSON.parse(eventParams);
    const type = params.type;
    moduleData$3.type = type;
    if (type == "order") {
        moduleData$3.navTitle = $i18n.n_exchange_timing_entrust_detail;
        requestOrderDetail(params.id);
    } else {
        moduleData$3.navTitle = $i18n.n_shark_fin_product_detail;
        requestProjectDetail(params.id);
    }
}

function onDestroy$2() {
    reloadData();
}

function onStart$2() {
    analytics("app_earn_shakeFin_orderDetail_view");
}

const {moduleData: moduleData$3, moduleEvent: moduleEvent$3} = moduleDefine("detail", defaultData$3, {
    onCreate: onCreate$3,
    onDestroy: onDestroy$2,
    onStart: onStart$2
});

async function requestOrderDetail(orderId) {
    autoOrderId = orderId;
    showLoading(true);
    const data = await sendRequest("v4/saving/mining/user/order/sharkDetail", {
        orderId: orderId
    });
    console.log(JSON.stringify(data));
    showLoading(false);
    if (!data || data == null) {
        showDetailEmpty(true);
        return;
    }
    $event.pnlrule.handleData(data.projectDetail);
    handleDetailData(data.projectDetail);
    moduleData$3.orderShow = "visible";
    moduleData$3.buyNumber = $i18n.n_asset_subscribe_number + `(${data.projectDetail.quoteCurrency})`;
    moduleData$3.buyPnl = $i18n.n_shark_fin_deposit_pnl + `(${data.projectDetail.quoteCurrency})`;
    moduleData$3.buyNumberAmount = `${data.amount}`;
    moduleData$3.buyPnlAmount = `${data.totalIncomeAmount}`;
    if (data.projectDetail && data.projectDetail.viewStatus != 3) {
        moduleData$3.buyPnlAmount = $i18n.n_shark_fin_orphan;
    }
    if (data.autoSubscribeInfo) {
        autoSubscribe = data.autoSubscribeInfo.autoSubscribe;
        autoSubscribeState = data.autoSubscribeInfo.autoSubscribeState;
        const resultCode = data.autoSubscribeInfo.autoSubscribeResultCode;
        const resultRemark = data.autoSubscribeInfo.autoSubscribeResultRemark;
        changeSwitchStatus();
        changeSwitchRemark(resultCode, resultRemark);
    }
    showDetailEmpty(false);
}

async function requestProjectDetail(projectId) {
    showLoading(true);
    const data = await sendRequest("v4/saving/mining/shark/project/detail", {
        projectId: projectId
    });
    showLoading(false);
    if (!data || data == null) {
        showDetailEmpty(true);
        return;
    }
    $event.pnlrule.handleData(data);
    handleDetailData(data);
    showDetailEmpty(false);
}

function handleDetailData(data) {
    viewStatus = data.viewStatus;
    moduleData$3.unit = data.quoteCurrency;
    const callPutText = data.callPut == 1 ? $i18n.$intercept.n_shark_fin_bullish(data.currency) : $i18n.$intercept.n_shark_fin_bearish(data.currency);
    const minRate = formatPrecision(multiply(data.minRate, "100"), 2);
    const maxRate = formatPrecision(multiply(data.maxRate, "100"), 2);
    const finalRate = formatPrecision(multiply(data.finalRate, "100"), 2);
    const expiryTime = new Date(data.expiryTime).Format("yyyy/MM/dd");
    const statueValue = handleStatus(data.viewStatus);
    const stateColor = data.viewStatus == 2 ? "#00A171" : "@color/kColorPrimaryText";
    var APYEst = $i18n.n_shark_fin_APY_Est;
    var APYEstValue = `${minRate}% ~ ${maxRate}%`;
    if (data.viewStatus == 3) {
        APYEst = $i18n.n_shark_fin_Est_APY;
        APYEstValue = `${finalRate}%`;
    }
    moduleData$3.celllist = [ {
        type: "H1",
        name: $i18n.n_shark_fin_deposit_info
    }, {
        type: "normal",
        name: $i18n.n_exchange_timing_order_status,
        value: "",
        state: statueValue,
        tipsShow: "visible",
        stateColor: stateColor
    }, {
        type: "normal",
        name: $i18n.n_shark_fin_product,
        value: "",
        state: callPutText,
        tipsShow: "gone",
        stateColor: "@color/kColorPrimaryText"
    }, {
        type: "normal",
        name: APYEst,
        value: APYEstValue,
        state: "",
        tipsShow: "gone",
        stateColor: "@color/kColorPrimaryText"
    }, {
        type: "normal",
        name: $i18n.n_mining_duration,
        value: `${data.term} ${$i18n.n_mining_day_text}`,
        state: "",
        tipsShow: "gone",
        stateColor: "@color/kColorPrimaryText"
    }, {
        type: "normal",
        name: $i18n.n_mining_end_time,
        value: expiryTime,
        state: "",
        tipsShow: "gone",
        stateColor: "@color/kColorPrimaryText"
    } ];
    moduleData$3.subscribeEndTime = data.subscribeEndTime;
}

function handleStatus(status) {
    var value = $i18n.n_shark_fin_orphan;
    switch (status) {
      case 0:
        value = $i18n.n_shark_fin_orphan;
        break;

      case 1:
        value = $i18n.n_shark_fin_orphan;
        break;

      case 2:
        value = $i18n.n_shark_fin_earning;
        break;

      case 3:
        value = $i18n.n_shark_fin_expired;
        break;
    }
    return value;
}

function showDetailEmpty(isEmpty) {
    moduleData$3.empty = isEmpty ? "visible" : "gone";
    moduleData$3.notEmpty = isEmpty ? "gone" : "visible";
}

function reloadData() {
    moduleData$3.empty = "gone";
    moduleData$3.notEmpty = "gone";
    moduleData$3.orderShow = "gone";
    $data.alert.alertPopShow = "false";
    moduleData$3.celllist = [];
}

moduleEvent$3.statusAlert = function() {
    if (viewStatus == 3) {
        $data.alert.content = $i18n.n_shark_fin_alert_expired;
    } else if (viewStatus == 2) {
        $data.alert.content = $i18n.n_shark_fin_alert_earning;
    } else {
        const subscribeEndTime = new Date(moduleData$3.subscribeEndTime).Format("yyyy/MM/dd hh:mm:ss");
        $data.alert.content = $i18n.$intercept.n_shark_fin_alert_orphan(subscribeEndTime);
    }
    $data.alert.alertPopShow = "true";
    analytics("app_earn_shakeFin_orderDetail_stateExplanation_click");
};

function backClicked() {
    if (moduleData$3.type == "order") {
        analytics("app_earn_shakeFin_orderDetail_returnButton_click");
    }
    toBack();
}

function changeSwitchRemark(code, remark) {
    if (code == 1) {
        moduleData$3.resultRemark = $i18n.n_shark_fin_autoSubscribe_result_1;
        moduleData$3.resultColor = "@color/kColorPriceRed";
    } else if (code == 2) {
        moduleData$3.resultRemark = $i18n.n_shark_fin_autoSubscribe_result_2;
        moduleData$3.resultColor = "@color/kColorPriceRed";
    } else if (code == 3) {
        moduleData$3.resultRemark = $i18n.n_shark_fin_autoSubscribe_result_3;
        moduleData$3.resultColor = "@color/kColorPriceRed";
    } else if (code == 4) {
        moduleData$3.resultRemark = $i18n.n_shark_fin_autoSubscribe_result_4;
        moduleData$3.resultColor = "@color/kColorPriceRed";
    } else if (code == 5) {
        moduleData$3.resultRemark = $i18n.n_shark_fin_autoSubscribe_result_5;
        moduleData$3.resultColor = "@color/kColorPriceRed";
    } else {
        moduleData$3.resultRemark = $i18n.n_shark_fin_autoSubscribe_desc;
        moduleData$3.resultColor = "@color/kColorThreeLevelText";
    }
    if (remark && remark != null) {
        moduleData$3.resultRemark = remark;
    }
}

function changeSwitchStatus() {
    if (autoSubscribe == 0) {
        moduleData$3.switchColor = "@color/KBaseColorContentBackground";
        moduleData$3.switchBackColor = "@color/eButtonUnenabledBgColor";
        moduleData$3.switchWidth = "2";
    } else {
        moduleData$3.switchColor = "@color/KBaseColorContentBackground";
        moduleData$3.switchBackColor = "@color/baseColorMajorTheme100";
        moduleData$3.switchWidth = "14";
    }
    moduleData$3.switchOpacity = autoSubscribeState == 0 ? "0.2" : "1";
}

moduleEvent$3.autoClicked = async function() {
    if (autoSubscribeState == 0) {
        return;
    }
    const param = {
        orderId: autoOrderId,
        autoSubscribe: autoSubscribe == 0 ? 1 : 0
    };
    showLoading(true);
    const data = await sendRequest("v4/saving/mining/shark/config/autoSubscribe", param, 1, 0, {
        "Content-Type": "application/json"
    });
    showLoading(false);
    console.log(JSON.stringify(data));
    if (data && data != null) {
        autoSubscribe = data.autoSubscribe;
        autoSubscribeState = data.autoSubscribeState;
        const resultCode = data.autoSubscribeResultCode;
        const resultRemark = data.autoSubscribeResultRemark;
        changeSwitchStatus();
        changeSwitchRemark(resultCode, resultRemark);
    }
};

moduleEvent$3.backClicked = backClicked;

function getNavConfigString$1() {
    let nav = {
        titleKey: "n_shark_fin_introduce",
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

function defaultData$2() {
    return {
        currentTag: 0,
        currentIndex: 0,
        titleData: [ {
            title: $i18n.n_shark_fin_product_rule,
            titleSize: "14",
            titleColor: "@color/kColorPrimaryText",
            tag: "0"
        }, {
            title: $i18n.n_shark_fin_common_problem,
            titleSize: "14",
            titleColor: "@color/kColorSecondaryText",
            tag: "1"
        } ],
        sliderData: [ {
            listType: "1"
        }, {
            listType: "2"
        } ],
        problems1Open: "visible",
        problems1Close: "gone",
        problems2Open: "gone",
        problems2Close: "visible",
        problems3Open: "gone",
        problems3Close: "visible",
        problems4Open: "gone",
        problems4Close: "visible",
        problems5Open: "gone",
        problems5Close: "visible",
        problems6Open: "gone",
        problems6Close: "visible",
        problems61Open: "gone",
        problems61Close: "visible",
        problems7Open: "gone",
        problems7Close: "visible",
        problems8Open: "gone",
        problems8Close: "visible",
        problems9Open: "gone",
        problems9Close: "visible"
    };
}

const {moduleData: moduleData$2, moduleEvent: moduleEvent$2} = moduleDefine("introduce", defaultData$2, {
    onCreate: onCreate$2
});

function onCreate$2(param) {
    console.log("introduce on create");
    console.log(param);
    moduleData$2.navConfig = getNavConfigString$1();
    let paramDic = JSON.parse(param);
    let index = parseInt(paramDic["index"]);
    console.log(index);
    console.log(parseInt(index));
    if (index == undefined || isNaN(index)) {
        index = 0;
    }
    moduleEvent$2.tabClick(index);
}

function resetTitlesStyle(idx) {
    for (let i = 0; i < moduleData$2.titleData.length; i++) {
        var obj = moduleData$2.titleData[i];
        obj.titleSize = "14";
        obj.titleColor = "@color/kColorSecondaryText";
    }
    var cur = moduleData$2.titleData[idx];
    cur.titleColor = "@color/kColorPrimaryText";
}

moduleEvent$2.openOrCloseProblem = function(index) {
    let visible = moduleData$2[`problems${index}Open`];
    if (visible == "visible") {
        moduleData$2[`problems${index}Close`] = visible;
        visible = "gone";
    } else {
        moduleData$2[`problems${index}Close`] = visible;
        visible = "visible";
    }
    moduleData$2[`problems${index}Open`] = visible;
};

moduleEvent$2.tabClick = function(idx) {
    resetTitlesStyle(idx);
    moduleData$2.currentIndex = `${idx}`;
};

moduleEvent$2.resetTitleSelectTab = function(idx) {
    resetTitlesStyle(idx);
};

var tabKey = "";

function defaultData$1() {
    return {
        questionList: createQuestionList()
    };
}

function createQuestionList() {
    var sixAString = $i18n.n_shark_fin_common_answer_six_a_first_new + " \n \n" + $i18n.n_shark_fin_common_answer_six_a_second_new;
    var sevenString = $i18n.n_shark_fin_common_answer_seven_a_first + " \n \n" + $i18n.n_shark_fin_common_answer_seven_a_second + " \n \n" + $i18n.n_shark_fin_common_answer_seven_a_third + " \n \n" + $i18n.n_shark_fin_common_answer_seven_a_four + " \n \n" + $i18n.n_shark_fin_common_answer_seven_second + " \n \n" + $i18n.n_shark_fin_common_answer_seven_third;
    var questionList = [ {
        cellType: "normal",
        q: $i18n.n_shark_fin_common_problem_one,
        a: $i18n.n_shark_fin_common_answer_one,
        answerVisable: "gone",
        qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
    }, {
        cellType: "normal",
        q: $i18n.n_shark_fin_common_problem_two,
        a: $i18n.n_shark_fin_common_answer_two_new,
        answerVisable: "gone",
        qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
    }, {
        cellType: "normal",
        q: $i18n.n_shark_fin_common_problem_three,
        a: $i18n.n_shark_fin_common_answer_three,
        answerVisable: "gone",
        qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
    }, {
        cellType: "normal",
        q: $i18n.n_shark_fin_common_problem_four,
        a: $i18n.n_shark_fin_common_answer_four_c,
        answerVisable: "gone",
        qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
    }, {
        cellType: "normal",
        q: $i18n.n_shark_fin_common_problem_five_new,
        a: $i18n.n_shark_fin_common_answer_five_new_c,
        answerVisable: "gone",
        qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
    }, {
        cellType: "normal",
        q: $i18n.n_shark_fin_common_problem_six,
        a: $i18n.n_shark_fin_common_answer_six,
        answerVisable: "gone",
        qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
    }, {
        cellType: "normal",
        q: $i18n.n_shark_fin_common_problem_six_a,
        a: sixAString,
        answerVisable: "gone",
        qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
    }, {
        cellType: "normal",
        q: $i18n.n_shark_fin_common_problem_seven,
        a: sevenString,
        answerVisable: "gone",
        qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
    }, {
        cellType: "normal",
        q: $i18n.n_shark_fin_common_problem_eight,
        a: $i18n.n_shark_fin_common_answer_eight_new_c,
        answerVisable: "gone",
        qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
    }, {
        cellType: "normal",
        q: $i18n.n_shark_fin_common_problem_nine,
        a: $i18n.n_shark_fin_common_answer_nine_new,
        answerVisable: "gone",
        qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
    } ];
    questionList.forEach(((element, index) => {
        element.index = index;
    }));
    return questionList;
}

const {moduleData: moduleData$1, moduleEvent: moduleEvent$1} = moduleDefine("home", defaultData$1, {
    onCreate: onCreate$1,
    onDestroy: onDestroy$1,
    onResume: onResume$1,
    onPause: onPause$1,
    onStart: onStart$1,
    onStop: onStop$1
});

function onCreate$1(eventParams) {
    console.log("home onCreate");
    moduleData$1.statusBarConfig = {
        statusBarMode: "false"
    };
    moduleData$1.isInit = false;
    moduleData$1.isFirst = true;
    moduleData$1.timerObject;
    moduleData$1.statusHeight = commonData.statusHeight;
    if (tabKey.length == 0 && eventParams && eventParams != null) {
        const params = JSON.parse(eventParams);
        tabKey = params.tabKey ? params.tabKey : "";
    }
    requestSharkHomeData();
}

function onDestroy$1() {}

async function onResume$1() {
    console.log("home onResume");
    startTimer();
    if (!moduleData$1.isFirst) {
        requestSharkHomeData();
    }
    moduleData$1.isFirst = false;
}

function onPause$1() {
    console.log("home onPause");
    clearTimer();
}

function onStart$1() {
    analytics("app_earn_shakeFinProduct_view");
}

function onStop$1() {}

async function requestSharkHomeData() {
    showLoading(true);
    const data = await sendRequest("v4/saving/mining/shark", {
        tabKey: tabKey
    });
    showLoading(false);
    sharkTabKey(data);
    sharkHomeData(data);
    moduleData$1.isInit = true;
}

function sharkTabKey(oData) {
    if (!oData || oData == null || !oData.tabInfo || oData.tabInfo == null || oData.tabInfo.length < 2) {
        moduleData$1.tabVisable = "gone";
        return;
    }
    moduleData$1.tabVisable = "visible";
    var muArray = [];
    for (let index = 0; index < oData.tabInfo.length; index++) {
        var element = oData.tabInfo[index];
        if (element.highlight) {
            tabKey = element.tabKey;
            element.background = "@color/KBaseColorContentBackground";
            element.textColor = "@color/kColorPrimaryText";
        } else {
            element.background = "@color/KBaseColorDeepestBackground";
            element.textColor = "@color/kColorThreeLevelText";
        }
        muArray.push(element);
    }
    moduleData$1.tab0 = muArray[0];
    moduleData$1.tab1 = muArray[1];
}

function sharkHomeData(oData) {
    if (!oData || oData == null || !oData.sharkInfo || oData.sharkInfo == null || oData.sharkInfo.length == 0) {
        clearTimer();
        moduleData$1.contentVisable = "gone";
        return;
    }
    const data = oData.sharkInfo[0];
    console.log("home sharkHomeData" + JSON.stringify(data));
    moduleData$1.contentVisable = "visible";
    moduleData$1.quoteCurrency = data.quoteCurrency;
    moduleData$1.viewStatus = data.viewStatus;
    moduleData$1.startTime = data.startTime;
    moduleData$1.endTime = data.endTime;
    moduleData$1.subscribeStartTime = data.subscribeStartTime;
    moduleData$1.subscribeEndTime = data.subscribeEndTime;
    moduleData$1.totalLimit = `/ ${getPriceString(data.totalLimit, 0)}`;
    moduleData$1.finishAmount = getPriceString(data.finishAmount, 0);
    var finishProportion = String(parseInt(data.finishAmount * 100 / data.totalLimit));
    moduleData$1.finishProportion = String(parseInt(finishProportion));
    var usedProportion = String(parseInt((data.totalLimit - data.finishAmount) * 100 / data.totalLimit));
    if (data.finishAmount > 0 && finishProportion < 1) {
        finishProportion = 1;
    }
    if (usedProportion < 1) {
        usedProportion = 1;
    }
    moduleData$1.usedProportion = String(parseInt(usedProportion));
    moduleData$1.sTime = data.sTime;
    moduleData$1.serviceTimeInterval = data.sTime - (new Date).getTime();
    moduleData$1.subscriptionTitle = "";
    if (data.viewStatus == 0) {
        moduleData$1.subscriptionTitle = $i18n.n_shark_fin_deposit_open;
        moduleData$1.subscriptionDate = `${new Date(data.subscribeStartTime).Format("yyyy/MM/dd hh:mm")}`;
        var isZero = updateCountDown(data.subscribeStartTime);
        moduleData$1.progressVisable = "gone";
        moduleData$1.countdownVisable = isZero ? "gone" : "visible";
        moduleData$1.subscriptionDateVisable = "visible";
    } else if (data.viewStatus == 1 && data.finishAmount < data.totalLimit) {
        moduleData$1.subscriptionTitle = $i18n.n_shark_fin_deposit_close;
        moduleData$1.subscriptionDate = `${new Date(data.subscribeEndTime).Format("yyyy/MM/dd hh:mm")}`;
        var isZero = updateCountDown(data.subscribeEndTime);
        moduleData$1.progressVisable = "visible";
        moduleData$1.countdownVisable = isZero ? "gone" : "visible";
        moduleData$1.subscriptionDateVisable = "visible";
    } else {
        moduleData$1.subscriptionTitle = $i18n.n_shark_fin_deposit_closed;
        moduleData$1.progressVisable = "visible";
        moduleData$1.countdownVisable = "gone";
        moduleData$1.subscriptionDateVisable = "gone";
        clearTimer();
    }
    moduleData$1.depositAmountTitle = $i18n.$intercept.n_shark_fin_deposit_amount(data.quoteCurrency);
    var array = [];
    for (var i = 0; i < data.projects.length; i++) {
        let tmpObj = data.projects[i];
        let obj = {
            idx: i,
            icon: tmpObj.callPut == -1 ? "@drawable/edge_engine_shark_home_down_icon" : "@drawable/edge_engine_shark_home_up_icon",
            title: tmpObj.callPut == -1 ? $i18n.$intercept.n_shark_fin_bearish(tmpObj.currency) : $i18n.$intercept.n_shark_fin_bullish(tmpObj.currency),
            term: `${tmpObj.term} ${$i18n.n_mining_day_text}`,
            earnings: `${formatPrecision(multiply(tmpObj.minRate, "100"), 2)}%~${formatPrecision(multiply(tmpObj.maxRate, "100"), 2)}%`,
            cellType: "normal",
            id: tmpObj.id,
            type: tmpObj.callPut == -1 ? "bearrish" : "bullish",
            termStr: `${tmpObj.term}`,
            currency: tmpObj.currency
        };
        array.push(obj);
    }
    console.log("array" + JSON.stringify(array));
    moduleData$1.productList = array;
    productList = array;
}

function updateCountDown(date) {
    var timeMap = getCountDownMap(date);
    if (timeMap.isZero) {
        moduleData$1.countdownVisable = "gone";
    } else {
        moduleData$1.countdown = {
            day: timeMap.day,
            hour: timeMap.hour,
            minute: timeMap.minute,
            second: timeMap.second,
            showDay: timeMap.showDay
        };
    }
    return timeMap.isZero;
}

function getCountDownMap(date) {
    const beginDate = new Date(date).getTime();
    const newDate = (new Date).getTime() + moduleData$1.serviceTimeInterval;
    const milliseconds = beginDate - newDate;
    const interval = milliseconds / 1e3;
    if (interval <= 0) {
        return {
            day: "00",
            hour: "00",
            minute: "00",
            second: "00",
            showDay: "gone",
            isZero: true
        };
    }
    let d = parseInt(interval / 60 / 60 / 24);
    let day = d < 10 ? `0${d}` : `${d}`;
    let h = parseInt(interval / 60 / 60 % 24);
    let hour = h < 10 ? `0${h}` : `${h}`;
    let m = parseInt(interval / 60 % 60);
    let minute = m < 10 ? `0${m}` : `${m}`;
    let s = parseInt(interval % 60);
    let second = s < 10 ? `0${s}` : `${s}`;
    var showDay = d > 0 ? "visible" : "gone";
    var isZero = d + h + m + s > 0 ? false : true;
    return {
        day: day,
        hour: hour,
        minute: minute,
        second: second,
        showDay: showDay,
        isZero: isZero
    };
}

function startTimer() {
    console.log("startTimer ");
    if (moduleData$1.timerObject == null) {
        moduleData$1.timerObject = setInterval(timer, 1e3);
    }
}

function clearTimer() {
    if (moduleData$1.timerObject != null) {
        console.log("clearTimer ");
        clearInterval(moduleData$1.timerObject);
        moduleData$1.timerObject = null;
    }
}

async function timer() {
    console.log("timer ");
    var isZero = false;
    if (moduleData$1.viewStatus == 0) {
        isZero = updateCountDown(moduleData$1.subscribeStartTime);
    } else if (moduleData$1.viewStatus == 1) {
        isZero = updateCountDown(moduleData$1.subscribeEndTime);
    }
    if (isZero) {
        data = await sendRequest("v4/saving/mining/shark", {
            tabKey: tabKey
        });
        sharkTabKey(data);
        sharkHomeData(data);
    }
}

function clickQA(index) {
    if (moduleData$1.questionList[index].answerVisable == "gone") {
        moduleData$1.questionList[index].answerVisable = "visible";
        moduleData$1.questionList[index].qaIcon = "@drawable/edge_engine_shark_home_qa_retract_icon";
    } else {
        moduleData$1.questionList[index].answerVisable = "gone";
        moduleData$1.questionList[index].qaIcon = "@drawable/edge_engine_shark_home_qa_spread_icon";
    }
    analytics("app_earn_shakeFinProduct_FAQs_click", {
        order: parseInt(index) + 1
    });
}

function goMyProperties() {
    openURL(`${commonData.h5Url}/${commonData.language}/financial/earn/assets/h5?tabIndex=3`);
    analytics("app_earn_shakeFinProduct_currentHoldings_click");
}

function goHistory() {
    openURL("holigeit://open/v1?login=0&url=ihuobiglobal://m.hbg.com/edgeengine/container?scene=sharkfin&rootName=history&navConfig=native&pageType=onGoing");
    analytics("app_earn_shakeFinProduct_viewAllListings_click");
}

function goAllFAQs() {
    openURL("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/edgeengine/container?scene=sharkfin&rootName=introduce&navConfig=native&index=1");
    analytics("app_earn_shakeFinProduct_FAQs_more_click");
}

function goBack() {
    console.log("home back");
    containerBack();
    analytics("app_earn_shakeFinProduct_returnButton_click");
}

function goIntroduce() {
    openURL("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/edgeengine/container?scene=sharkfin&rootName=introduce&navConfig=native&index=0");
    analytics("app_earn_shakeFinProduct_shakeFinIntro_click");
}

function goDeposit(idx) {
    var item = moduleData$1.productList[idx];
    openURL(`holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/edgeengine/container?scene=sharkfin&rootName=deposit&navConfig=&projectId=${item.id}`);
    analytics("app_earn_shakeFinProduct_product_click", {
        type: item.type,
        term: item.termStr,
        currency: item.currency
    });
}

function tabClicked(selectTabKey) {
    if (tabKey != selectTabKey) {
        tabKey = selectTabKey;
    }
    startTimer();
    requestSharkHomeData();
}

moduleEvent$1.clickQA = clickQA;

moduleEvent$1.goMyProperties = goMyProperties;

moduleEvent$1.goHistory = goHistory;

moduleEvent$1.goAllFAQs = goAllFAQs;

moduleEvent$1.goBack = goBack;

moduleEvent$1.goIntroduce = goIntroduce;

moduleEvent$1.goDeposit = goDeposit;

moduleEvent$1.tabClicked = tabClicked;

var history_titleColor_Normal;

var history_titleColor_Selected;

var history_onGoingPage = 2;

var history_finishedPage = 3;

function defaultData() {
    return {
        listData: [ {
            type: "normal",
            data: [],
            rightTitle: $i18n.n_shark_fin_APY_Est,
            loadMoreStatus: 0,
            empty: "gone",
            showList: "gone"
        }, {
            type: "normal",
            data: [],
            rightTitle: $i18n.n_shark_fin_Est_APY,
            loadMoreStatus: 0,
            empty: "gone",
            showList: "gone"
        } ],
        poplistData: {
            projectList: []
        },
        onGoingPage: 1,
        finishedPage: 1,
        onGoingData: [],
        finishedData: [],
        currentIndex: 0
    };
}

const {moduleData: moduleData, moduleEvent: moduleEvent} = moduleDefine("history", defaultData, {
    onCreate: onCreate,
    onDestroy: onDestroy,
    onResume: onResume,
    onPause: onPause,
    onStart: onStart,
    onStop: onStop
});

function getNavConfigString() {
    return {
        titleKey: "n_shark_fin_historical_products",
        left: {
            action: {
                type: "back",
                parameter: ""
            },
            icon: "edge_engine_top_bar_back_normal"
        },
        backgroundColor: "KBaseColorContentBackground"
    };
}

function onCreate(eventParams) {
    console.log("onCreate history" + eventParams);
    if (commonData.colorMode == 1) {
        history_titleColor_Normal = "#8C8C93";
        history_titleColor_Selected = "#E6E6E6";
    } else {
        history_titleColor_Normal = "#565656";
        history_titleColor_Selected = "#000000";
    }
    moduleData.statusBarConfig = {
        statusBarMode: "true",
        adStatusBarColor: "KBaseColorContentBackground"
    };
    moduleData.navConfig = getNavConfigString();
    const params = JSON.parse(eventParams);
    var pageType = params != null && params.pageType != null ? params.pageType : "onGoing";
    console.log("onCreate history" + JSON.stringify(pageType));
    tabClick(pageType);
    showLoading(true);
    requestSharkPrevRecordsData(history_onGoingPage, moduleData.onGoingPage);
    requestSharkPrevRecordsData(history_finishedPage, moduleData.finishedPage);
    showLoading(false);
}

function onDestroy() {
    clearModuleData();
}

function onResume() {}

function onPause() {}

function onStart() {}

function onStop() {}

function clearModuleData() {
    moduleData.listData = [ {
        type: "normal",
        data: [],
        rightTitle: $i18n.n_shark_fin_APY_Est,
        loadMoreStatus: 0,
        empty: "gone",
        showList: "gone"
    }, {
        type: "normal",
        data: [],
        rightTitle: $i18n.n_shark_fin_Est_APY,
        loadMoreStatus: 0,
        empty: "gone",
        showList: "gone"
    } ];
    moduleData.poplistData = {
        projectList: []
    };
    moduleData.onGoingPage = 1;
    moduleData.finishedPage = 1;
    moduleData.onGoingData = [];
    moduleData.finishedData = [];
    moduleData.currentIndex = 0;
}

async function requestSharkPrevRecordsData(type, currPage) {
    const data = await sendRequest("/v4/saving/mining/shark/prevRecords", {
        type: type,
        currPage: currPage
    });
    if (!data || data == null) {
        setEmpty(type);
        return;
    }
    var sharkPrevRecordsData = changeDataObject(data);
    if (sharkPrevRecordsData.allarray.length == 0) {
        setEmpty(type);
        return;
    }
    if (type == history_onGoingPage) {
        var tempData0 = moduleData.listData[0].data;
        if (tempData0 == null || tempData0.length == 0) {
            moduleData.listData[0].type = "normal";
            tempData0 = sharkPrevRecordsData.allarray;
        } else {
            tempData0.push(...sharkPrevRecordsData.allarray);
        }
        moduleData.listData[0].data = tempData0.map((function(item, idx) {
            var ret = item;
            ret.idx = idx;
            return ret;
        }));
        moduleData.onGoingData.push(...sharkPrevRecordsData.dataObjects);
        moduleData.listData[0].empty = "gone";
        moduleData.listData[0].showList = "visible";
    } else if (type == history_finishedPage) {
        var tempData1 = moduleData.listData[1].data;
        if (tempData1 == null || tempData1.length == 0) {
            moduleData.listData[1].type = "normal";
            tempData1 = sharkPrevRecordsData.allarray;
        } else {
            tempData1.push(...sharkPrevRecordsData.allarray);
        }
        moduleData.listData[1].data = tempData1.map((function(item, idx) {
            var ret = item;
            ret.idx = idx;
            return ret;
        }));
        moduleData.finishedData.push(...sharkPrevRecordsData.dataObjects);
        moduleData.listData[1].empty = "gone";
        moduleData.listData[1].showList = "visible";
    }
    if (sharkPrevRecordsData != null && sharkPrevRecordsData.allarray != null && sharkPrevRecordsData.allarray.length > 0) {
        if (type == history_onGoingPage) {
            moduleData.onGoingPage++;
        } else if (type == history_finishedPage) {
            moduleData.finishedPage++;
        }
    }
}

function setEmpty(type) {
    if (type == history_onGoingPage) {
        if (moduleData.listData[0].data == null || moduleData.listData[0].data.length == 0) {
            moduleData.listData[0].empty = "visible";
            moduleData.listData[0].showList = "gone";
        }
    } else if (type == history_finishedPage) {
        if (moduleData.listData[1].data == null || moduleData.listData[1].data.length == 0) {
            moduleData.listData[1].empty = "visible";
            moduleData.listData[1].showList = "gone";
        }
    }
}

function changeDataObject(data) {
    var dataObjects = {
        dataObjects: [],
        allarray: []
    };
    console.log("updataData" + JSON.stringify(data));
    var allarray = [];
    for (var i = 0; i < data.length; i++) {
        var tmpProjectsObj = data[i];
        var projectsObj = {};
        console.log("updataData 1" + JSON.stringify(tmpProjectsObj));
        projectsObj.index = i;
        projectsObj.quoteCurrency = tmpProjectsObj.quoteCurrency;
        projectsObj.viewStatus = tmpProjectsObj.viewStatus;
        projectsObj.endTime = tmpProjectsObj.endTime;
        projectsObj.subscribeEndTime = tmpProjectsObj.subscribeEndTime;
        projectsObj.finishAmount = tmpProjectsObj.finishAmount;
        projectsObj.finishAmountStr = getPriceString(tmpProjectsObj.finishAmount, -1);
        projectsObj.settleIncomeAmount = tmpProjectsObj.settleIncomeAmount;
        projectsObj.settleIncomeAmountStr = getPriceString(tmpProjectsObj.settleIncomeAmount, -1);
        projectsObj.allowRaiseDetail = tmpProjectsObj.allowRaiseDetail;
        let objTerm = tmpProjectsObj.term ? tmpProjectsObj.term : "";
        projectsObj.showDate = `${new Date(tmpProjectsObj.subscribeEndTime).Format("yyyy/MM/dd")} ~ ${new Date(tmpProjectsObj.endTime).Format("yyyy/MM/dd")}（${objTerm}${$i18n.n_mining_day_text}）`;
        projectsObj.showDesc = "";
        if (tmpProjectsObj.viewStatus == 2) {
            projectsObj.showDesc = `${$i18n.n_shark_fin_raised_amount}: `;
            projectsObj.showNumber = `${getPriceString(tmpProjectsObj.finishAmount, -1)} ${tmpProjectsObj.quoteCurrency}`;
        } else if (tmpProjectsObj.viewStatus == 3) {
            projectsObj.showDesc = `${$i18n.$intercept.n_shark_fin_settlement_interest("")}`;
            projectsObj.showNumber = `${getPriceString(tmpProjectsObj.settleIncomeAmount, -1)} ${tmpProjectsObj.quoteCurrency}`;
        }
        console.log("updataData 2 " + tmpProjectsObj.allowRaiseDetail);
        projectsObj.isShowDesc = tmpProjectsObj.allowRaiseDetail ? "visible" : "gone";
        var array = [];
        array.push({
            showDate: projectsObj.showDate,
            showDesc: projectsObj.showDesc,
            showNumber: projectsObj.showNumber,
            isShowDesc: projectsObj.isShowDesc,
            index: i,
            type: "header"
        });
        console.log("updataData 3");
        for (var j = 0; j < tmpProjectsObj.projects.length; j++) {
            console.log("updataData 4");
            let tmpObj = tmpProjectsObj.projects[j];
            let obj = {
                title: tmpObj.callPut == -1 ? $i18n.$intercept.n_shark_fin_bearish(tmpObj.currency) : $i18n.$intercept.n_shark_fin_bullish(tmpObj.currency),
                term: `${tmpObj.term} ${$i18n.n_mining_day_text}`,
                finishAmountStr: getPriceString(tmpObj.finishAmount, -1),
                settleIncomeAmountStr: getPriceString(tmpObj.settleIncomeAmount, -1),
                type: "normal",
                id: tmpObj.id,
                termStr: `${tmpObj.term}`,
                upDown: tmpObj.callPut == -1 ? "bearrish" : "bullish",
                currency: tmpObj.currency
            };
            if (tmpProjectsObj.viewStatus == 2) {
                obj.showRate = `${formatPrecision(multiply(tmpObj.minRate, "100"), 2)}%~${formatPrecision(multiply(tmpObj.maxRate, "100"), 2)}%`;
                obj.showDetail = $i18n.$intercept.n_shark_fin_now_price_new(tmpObj.currency, `$ ${getPriceString(tmpObj.currentPrice, -1)}`);
            } else if (tmpProjectsObj.viewStatus == 3) {
                obj.showRate = `${formatPrecision(multiply(tmpObj.finalRate, "100"), 2)}%`;
                obj.showDetail = $i18n.$intercept.n_shark_fin_settlement_price_2_new(tmpObj.currency, `$ ${getPriceString(tmpObj.settlementPrice, -1)}`);
            }
            array.push(obj);
        }
        array.push({
            index: i,
            type: "empty"
        });
        console.log("updataData 5");
        allarray.push(...array);
        projectsObj.projects = array;
        dataObjects.dataObjects.push(projectsObj);
    }
    dataObjects.allarray = allarray;
    return dataObjects;
}

async function tabClick(tag) {
    console.log("tabClick history" + JSON.stringify(tag));
    var index = tag == "onGoing" ? "0" : "1";
    if (moduleData.currentIndex != index) {
        moduleData.currentIndex = index;
    }
    await resetTitleSelectTab(index);
}

async function resetTitleSelectTab(index) {
    console.log(`resetTitleSelectTab index = ${index}`);
    if (index == "0") {
        moduleData.finishedTitleColor = history_titleColor_Normal;
        moduleData.onGoingTitleColor = history_titleColor_Selected;
        analytics("app_earn_shakeFinListings_earning_show");
    } else {
        moduleData.finishedTitleColor = history_titleColor_Selected;
        moduleData.onGoingTitleColor = history_titleColor_Normal;
        analytics("app_earn_shakeFinListings_expired_show");
    }
}

function openDetail(index) {
    var dataObject = moduleData.listData[moduleData.currentIndex];
    if (index >= dataObject.data.length) {
        return;
    }
    var item = dataObject.data[index];
    analytics("app_earn_shakeFinListings_product_click", {
        type: item.upDown,
        currency: item.currency,
        term: item.termStr
    });
    openURL(`holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/edgeengine/container?scene=sharkfin&rootName=detail&type=project&navConfig=&id=${item.id}`);
}

async function onLoadMore() {
    console.log("onLoadMore ");
    if (moduleData.currentIndex == 0) {
        requestSharkPrevRecordsData(history_onGoingPage, moduleData.onGoingPage);
        moduleData.listData[0].loadMoreStatus = "2";
    } else if (moduleData.currentIndex == 1) {
        requestSharkPrevRecordsData(history_finishedPage, moduleData.finishedPage);
        moduleData.listData[1].loadMoreStatus = "2";
    }
}

async function projectTitleClick(index) {
    console.log("projectTitleClick " + index);
    var currentPage = moduleData.currentIndex;
    console.log("projectTitleClick currentPage = " + currentPage);
    var projectData = currentPage == 0 ? moduleData.onGoingData[index] : moduleData.finishedData[index];
    var projectList = projectData.projects;
    console.log("projectTitleClick data = 1");
    var poplistData = {
        title: projectData.viewStatus == 2 ? $i18n.n_shark_fin_raised_amount : $i18n.n_shark_fin_settlement_interest_title,
        left: $i18n.n_shark_fin_product,
        middle: projectData.viewStatus == 2 ? "" : `${$i18n.n_shark_fin_principal}(${projectData.quoteCurrency})`,
        right: projectData.viewStatus == 2 ? `${$i18n.n_shark_fin_principal}(${projectData.quoteCurrency})` : `${$i18n.n_shark_fin_interest}(${projectData.quoteCurrency})`,
        finishAmountStr: projectData.finishAmountStr,
        settleIncomeAmountStr: projectData.settleIncomeAmountStr,
        isShowIncome: projectData.viewStatus == 2 ? "gone" : "visible",
        projectList: []
    };
    for (var i = 0; i < projectList.length; i++) {
        let tmpObj = projectList[i];
        if (tmpObj.type == "normal") {
            let obj = {
                cellType: "normal",
                left: tmpObj.title,
                middle: projectData.viewStatus == 2 ? "" : tmpObj.finishAmountStr,
                right: projectData.viewStatus == 2 ? tmpObj.finishAmountStr : tmpObj.settleIncomeAmountStr
            };
            poplistData.projectList.push(obj);
        }
    }
    console.log("projectTitleClick data = " + JSON.stringify(poplistData));
    moduleData.poplistData = poplistData;
    moduleData.alertPopShow = true;
    analytics(projectData.viewStatus == 2 ? "app_earn_shakeFinListings_amountRaisedExplanation_click" : "app_earn_shakeFinListings_settlementInterestExplanation_click");
    console.log("showpop ");
}

$event.historyPop = {};

$event.historyPop.cancel = function() {
    moduleData.alertPopShow = false;
};

$event.historyPop.popDismiss = function() {
    if (moduleData.alertPopShow != false) {
        moduleData.alertPopShow = false;
    }
};

moduleEvent.projectTitleClick = projectTitleClick;

moduleEvent.tabClick = tabClick;

moduleEvent.resetTitleSelectTab = resetTitleSelectTab;

moduleEvent.onLoadMore = onLoadMore;

moduleEvent.openDetail = openDetail;

function sendCommonConfig(param) {
    getCommonConfig(param);
}

$event.sendCommonConfig = sendCommonConfig;
//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoibWFpbi5qcyIsInNvdXJjZXMiOlsiLi4vLi4vcmVwb3NpdG9yeS9ub2RlX21vZHVsZXMvYmlnLmpzL2JpZy5tanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9udW1iZXIuanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9jb21tb24uanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9hbGVydC5qcyIsIi4uLy4uL3JlcG9zaXRvcnkvc3JjL2RlcG9zaXQuanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9wbmxydWxlLmpzIiwiLi4vLi4vcmVwb3NpdG9yeS9zcmMvZGV0YWlsLmpzIiwiLi4vLi4vcmVwb3NpdG9yeS9zcmMvaW50cm9kdWNlLmpzIiwiLi4vLi4vcmVwb3NpdG9yeS9zcmMvaG9tZS5qcyIsIi4uLy4uL3JlcG9zaXRvcnkvc3JjL2hpc3RvcnkuanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9tYWluLmpzIl0sInNvdXJjZXNDb250ZW50IjpbIi8qXHJcbiAqICBiaWcuanMgdjUuMi4yXHJcbiAqICBBIHNtYWxsLCBmYXN0LCBlYXN5LXRvLXVzZSBsaWJyYXJ5IGZvciBhcmJpdHJhcnktcHJlY2lzaW9uIGRlY2ltYWwgYXJpdGhtZXRpYy5cclxuICogIENvcHlyaWdodCAoYykgMjAxOCBNaWNoYWVsIE1jbGF1Z2hsaW4gPE04Y2g4OGxAZ21haWwuY29tPlxyXG4gKiAgaHR0cHM6Ly9naXRodWIuY29tL01pa2VNY2wvYmlnLmpzL0xJQ0VOQ0VcclxuICovXHJcblxyXG5cclxuLyoqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqIEVESVRBQkxFIERFRkFVTFRTICoqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqL1xyXG5cclxuXHJcbiAgLy8gVGhlIGRlZmF1bHQgdmFsdWVzIGJlbG93IG11c3QgYmUgaW50ZWdlcnMgd2l0aGluIHRoZSBzdGF0ZWQgcmFuZ2VzLlxyXG5cclxuICAvKlxyXG4gICAqIFRoZSBtYXhpbXVtIG51bWJlciBvZiBkZWNpbWFsIHBsYWNlcyAoRFApIG9mIHRoZSByZXN1bHRzIG9mIG9wZXJhdGlvbnMgaW52b2x2aW5nIGRpdmlzaW9uOlxyXG4gICAqIGRpdiBhbmQgc3FydCwgYW5kIHBvdyB3aXRoIG5lZ2F0aXZlIGV4cG9uZW50cy5cclxuICAgKi9cclxudmFyIERQID0gMjAsICAgICAgICAgIC8vIDAgdG8gTUFYX0RQXHJcblxyXG4gIC8qXHJcbiAgICogVGhlIHJvdW5kaW5nIG1vZGUgKFJNKSB1c2VkIHdoZW4gcm91bmRpbmcgdG8gdGhlIGFib3ZlIGRlY2ltYWwgcGxhY2VzLlxyXG4gICAqXHJcbiAgICogIDAgIFRvd2FyZHMgemVybyAoaS5lLiB0cnVuY2F0ZSwgbm8gcm91bmRpbmcpLiAgICAgICAoUk9VTkRfRE9XTilcclxuICAgKiAgMSAgVG8gbmVhcmVzdCBuZWlnaGJvdXIuIElmIGVxdWlkaXN0YW50LCByb3VuZCB1cC4gIChST1VORF9IQUxGX1VQKVxyXG4gICAqICAyICBUbyBuZWFyZXN0IG5laWdoYm91ci4gSWYgZXF1aWRpc3RhbnQsIHRvIGV2ZW4uICAgKFJPVU5EX0hBTEZfRVZFTilcclxuICAgKiAgMyAgQXdheSBmcm9tIHplcm8uICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIChST1VORF9VUClcclxuICAgKi9cclxuICBSTSA9IDEsICAgICAgICAgICAgIC8vIDAsIDEsIDIgb3IgM1xyXG5cclxuICAvLyBUaGUgbWF4aW11bSB2YWx1ZSBvZiBEUCBhbmQgQmlnLkRQLlxyXG4gIE1BWF9EUCA9IDFFNiwgICAgICAgLy8gMCB0byAxMDAwMDAwXHJcblxyXG4gIC8vIFRoZSBtYXhpbXVtIG1hZ25pdHVkZSBvZiB0aGUgZXhwb25lbnQgYXJndW1lbnQgdG8gdGhlIHBvdyBtZXRob2QuXHJcbiAgTUFYX1BPV0VSID0gMUU2LCAgICAvLyAxIHRvIDEwMDAwMDBcclxuXHJcbiAgLypcclxuICAgKiBUaGUgbmVnYXRpdmUgZXhwb25lbnQgKE5FKSBhdCBhbmQgYmVuZWF0aCB3aGljaCB0b1N0cmluZyByZXR1cm5zIGV4cG9uZW50aWFsIG5vdGF0aW9uLlxyXG4gICAqIChKYXZhU2NyaXB0IG51bWJlcnM6IC03KVxyXG4gICAqIC0xMDAwMDAwIGlzIHRoZSBtaW5pbXVtIHJlY29tbWVuZGVkIGV4cG9uZW50IHZhbHVlIG9mIGEgQmlnLlxyXG4gICAqL1xyXG4gIE5FID0gLTcsICAgICAgICAgICAgLy8gMCB0byAtMTAwMDAwMFxyXG5cclxuICAvKlxyXG4gICAqIFRoZSBwb3NpdGl2ZSBleHBvbmVudCAoUEUpIGF0IGFuZCBhYm92ZSB3aGljaCB0b1N0cmluZyByZXR1cm5zIGV4cG9uZW50aWFsIG5vdGF0aW9uLlxyXG4gICAqIChKYXZhU2NyaXB0IG51bWJlcnM6IDIxKVxyXG4gICAqIDEwMDAwMDAgaXMgdGhlIG1heGltdW0gcmVjb21tZW5kZWQgZXhwb25lbnQgdmFsdWUgb2YgYSBCaWcuXHJcbiAgICogKFRoaXMgbGltaXQgaXMgbm90IGVuZm9yY2VkIG9yIGNoZWNrZWQuKVxyXG4gICAqL1xyXG4gIFBFID0gMjEsICAgICAgICAgICAgLy8gMCB0byAxMDAwMDAwXHJcblxyXG5cclxuLyoqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqL1xyXG5cclxuXHJcbiAgLy8gRXJyb3IgbWVzc2FnZXMuXHJcbiAgTkFNRSA9ICdbYmlnLmpzXSAnLFxyXG4gIElOVkFMSUQgPSBOQU1FICsgJ0ludmFsaWQgJyxcclxuICBJTlZBTElEX0RQID0gSU5WQUxJRCArICdkZWNpbWFsIHBsYWNlcycsXHJcbiAgSU5WQUxJRF9STSA9IElOVkFMSUQgKyAncm91bmRpbmcgbW9kZScsXHJcbiAgRElWX0JZX1pFUk8gPSBOQU1FICsgJ0RpdmlzaW9uIGJ5IHplcm8nLFxyXG5cclxuICAvLyBUaGUgc2hhcmVkIHByb3RvdHlwZSBvYmplY3QuXHJcbiAgUCA9IHt9LFxyXG4gIFVOREVGSU5FRCA9IHZvaWQgMCxcclxuICBOVU1FUklDID0gL14tPyhcXGQrKFxcLlxcZCopP3xcXC5cXGQrKShlWystXT9cXGQrKT8kL2k7XHJcblxyXG5cclxuLypcclxuICogQ3JlYXRlIGFuZCByZXR1cm4gYSBCaWcgY29uc3RydWN0b3IuXHJcbiAqXHJcbiAqL1xyXG5mdW5jdGlvbiBfQmlnXygpIHtcclxuXHJcbiAgLypcclxuICAgKiBUaGUgQmlnIGNvbnN0cnVjdG9yIGFuZCBleHBvcnRlZCBmdW5jdGlvbi5cclxuICAgKiBDcmVhdGUgYW5kIHJldHVybiBhIG5ldyBpbnN0YW5jZSBvZiBhIEJpZyBudW1iZXIgb2JqZWN0LlxyXG4gICAqXHJcbiAgICogbiB7bnVtYmVyfHN0cmluZ3xCaWd9IEEgbnVtZXJpYyB2YWx1ZS5cclxuICAgKi9cclxuICBmdW5jdGlvbiBCaWcobikge1xyXG4gICAgdmFyIHggPSB0aGlzO1xyXG5cclxuICAgIC8vIEVuYWJsZSBjb25zdHJ1Y3RvciB1c2FnZSB3aXRob3V0IG5ldy5cclxuICAgIGlmICghKHggaW5zdGFuY2VvZiBCaWcpKSByZXR1cm4gbiA9PT0gVU5ERUZJTkVEID8gX0JpZ18oKSA6IG5ldyBCaWcobik7XHJcblxyXG4gICAgLy8gRHVwbGljYXRlLlxyXG4gICAgaWYgKG4gaW5zdGFuY2VvZiBCaWcpIHtcclxuICAgICAgeC5zID0gbi5zO1xyXG4gICAgICB4LmUgPSBuLmU7XHJcbiAgICAgIHguYyA9IG4uYy5zbGljZSgpO1xyXG4gICAgfSBlbHNlIHtcclxuICAgICAgcGFyc2UoeCwgbik7XHJcbiAgICB9XHJcblxyXG4gICAgLypcclxuICAgICAqIFJldGFpbiBhIHJlZmVyZW5jZSB0byB0aGlzIEJpZyBjb25zdHJ1Y3RvciwgYW5kIHNoYWRvdyBCaWcucHJvdG90eXBlLmNvbnN0cnVjdG9yIHdoaWNoXHJcbiAgICAgKiBwb2ludHMgdG8gT2JqZWN0LlxyXG4gICAgICovXHJcbiAgICB4LmNvbnN0cnVjdG9yID0gQmlnO1xyXG4gIH1cclxuXHJcbiAgQmlnLnByb3RvdHlwZSA9IFA7XHJcbiAgQmlnLkRQID0gRFA7XHJcbiAgQmlnLlJNID0gUk07XHJcbiAgQmlnLk5FID0gTkU7XHJcbiAgQmlnLlBFID0gUEU7XHJcbiAgQmlnLnZlcnNpb24gPSAnNS4yLjInO1xyXG5cclxuICByZXR1cm4gQmlnO1xyXG59XHJcblxyXG5cclxuLypcclxuICogUGFyc2UgdGhlIG51bWJlciBvciBzdHJpbmcgdmFsdWUgcGFzc2VkIHRvIGEgQmlnIGNvbnN0cnVjdG9yLlxyXG4gKlxyXG4gKiB4IHtCaWd9IEEgQmlnIG51bWJlciBpbnN0YW5jZS5cclxuICogbiB7bnVtYmVyfHN0cmluZ30gQSBudW1lcmljIHZhbHVlLlxyXG4gKi9cclxuZnVuY3Rpb24gcGFyc2UoeCwgbikge1xyXG4gIHZhciBlLCBpLCBubDtcclxuXHJcbiAgLy8gTWludXMgemVybz9cclxuICBpZiAobiA9PT0gMCAmJiAxIC8gbiA8IDApIG4gPSAnLTAnO1xyXG4gIGVsc2UgaWYgKCFOVU1FUklDLnRlc3QobiArPSAnJykpIHRocm93IEVycm9yKElOVkFMSUQgKyAnbnVtYmVyJyk7XHJcblxyXG4gIC8vIERldGVybWluZSBzaWduLlxyXG4gIHgucyA9IG4uY2hhckF0KDApID09ICctJyA/IChuID0gbi5zbGljZSgxKSwgLTEpIDogMTtcclxuXHJcbiAgLy8gRGVjaW1hbCBwb2ludD9cclxuICBpZiAoKGUgPSBuLmluZGV4T2YoJy4nKSkgPiAtMSkgbiA9IG4ucmVwbGFjZSgnLicsICcnKTtcclxuXHJcbiAgLy8gRXhwb25lbnRpYWwgZm9ybT9cclxuICBpZiAoKGkgPSBuLnNlYXJjaCgvZS9pKSkgPiAwKSB7XHJcblxyXG4gICAgLy8gRGV0ZXJtaW5lIGV4cG9uZW50LlxyXG4gICAgaWYgKGUgPCAwKSBlID0gaTtcclxuICAgIGUgKz0gK24uc2xpY2UoaSArIDEpO1xyXG4gICAgbiA9IG4uc3Vic3RyaW5nKDAsIGkpO1xyXG4gIH0gZWxzZSBpZiAoZSA8IDApIHtcclxuXHJcbiAgICAvLyBJbnRlZ2VyLlxyXG4gICAgZSA9IG4ubGVuZ3RoO1xyXG4gIH1cclxuXHJcbiAgbmwgPSBuLmxlbmd0aDtcclxuXHJcbiAgLy8gRGV0ZXJtaW5lIGxlYWRpbmcgemVyb3MuXHJcbiAgZm9yIChpID0gMDsgaSA8IG5sICYmIG4uY2hhckF0KGkpID09ICcwJzspICsraTtcclxuXHJcbiAgaWYgKGkgPT0gbmwpIHtcclxuXHJcbiAgICAvLyBaZXJvLlxyXG4gICAgeC5jID0gW3guZSA9IDBdO1xyXG4gIH0gZWxzZSB7XHJcblxyXG4gICAgLy8gRGV0ZXJtaW5lIHRyYWlsaW5nIHplcm9zLlxyXG4gICAgZm9yICg7IG5sID4gMCAmJiBuLmNoYXJBdCgtLW5sKSA9PSAnMCc7KTtcclxuICAgIHguZSA9IGUgLSBpIC0gMTtcclxuICAgIHguYyA9IFtdO1xyXG5cclxuICAgIC8vIENvbnZlcnQgc3RyaW5nIHRvIGFycmF5IG9mIGRpZ2l0cyB3aXRob3V0IGxlYWRpbmcvdHJhaWxpbmcgemVyb3MuXHJcbiAgICBmb3IgKGUgPSAwOyBpIDw9IG5sOykgeC5jW2UrK10gPSArbi5jaGFyQXQoaSsrKTtcclxuICB9XHJcblxyXG4gIHJldHVybiB4O1xyXG59XHJcblxyXG5cclxuLypcclxuICogUm91bmQgQmlnIHggdG8gYSBtYXhpbXVtIG9mIGRwIGRlY2ltYWwgcGxhY2VzIHVzaW5nIHJvdW5kaW5nIG1vZGUgcm0uXHJcbiAqIENhbGxlZCBieSBzdHJpbmdpZnksIFAuZGl2LCBQLnJvdW5kIGFuZCBQLnNxcnQuXHJcbiAqXHJcbiAqIHgge0JpZ30gVGhlIEJpZyB0byByb3VuZC5cclxuICogZHAge251bWJlcn0gSW50ZWdlciwgMCB0byBNQVhfRFAgaW5jbHVzaXZlLlxyXG4gKiBybSB7bnVtYmVyfSAwLCAxLCAyIG9yIDMgKERPV04sIEhBTEZfVVAsIEhBTEZfRVZFTiwgVVApXHJcbiAqIFttb3JlXSB7Ym9vbGVhbn0gV2hldGhlciB0aGUgcmVzdWx0IG9mIGRpdmlzaW9uIHdhcyB0cnVuY2F0ZWQuXHJcbiAqL1xyXG5mdW5jdGlvbiByb3VuZCh4LCBkcCwgcm0sIG1vcmUpIHtcclxuICB2YXIgeGMgPSB4LmMsXHJcbiAgICBpID0geC5lICsgZHAgKyAxO1xyXG5cclxuICBpZiAoaSA8IHhjLmxlbmd0aCkge1xyXG4gICAgaWYgKHJtID09PSAxKSB7XHJcblxyXG4gICAgICAvLyB4Y1tpXSBpcyB0aGUgZGlnaXQgYWZ0ZXIgdGhlIGRpZ2l0IHRoYXQgbWF5IGJlIHJvdW5kZWQgdXAuXHJcbiAgICAgIG1vcmUgPSB4Y1tpXSA+PSA1O1xyXG4gICAgfSBlbHNlIGlmIChybSA9PT0gMikge1xyXG4gICAgICBtb3JlID0geGNbaV0gPiA1IHx8IHhjW2ldID09IDUgJiZcclxuICAgICAgICAobW9yZSB8fCBpIDwgMCB8fCB4Y1tpICsgMV0gIT09IFVOREVGSU5FRCB8fCB4Y1tpIC0gMV0gJiAxKTtcclxuICAgIH0gZWxzZSBpZiAocm0gPT09IDMpIHtcclxuICAgICAgbW9yZSA9IG1vcmUgfHwgISF4Y1swXTtcclxuICAgIH0gZWxzZSB7XHJcbiAgICAgIG1vcmUgPSBmYWxzZTtcclxuICAgICAgaWYgKHJtICE9PSAwKSB0aHJvdyBFcnJvcihJTlZBTElEX1JNKTtcclxuICAgIH1cclxuXHJcbiAgICBpZiAoaSA8IDEpIHtcclxuICAgICAgeGMubGVuZ3RoID0gMTtcclxuXHJcbiAgICAgIGlmIChtb3JlKSB7XHJcblxyXG4gICAgICAgIC8vIDEsIDAuMSwgMC4wMSwgMC4wMDEsIDAuMDAwMSBldGMuXHJcbiAgICAgICAgeC5lID0gLWRwO1xyXG4gICAgICAgIHhjWzBdID0gMTtcclxuICAgICAgfSBlbHNlIHtcclxuXHJcbiAgICAgICAgLy8gWmVyby5cclxuICAgICAgICB4Y1swXSA9IHguZSA9IDA7XHJcbiAgICAgIH1cclxuICAgIH0gZWxzZSB7XHJcblxyXG4gICAgICAvLyBSZW1vdmUgYW55IGRpZ2l0cyBhZnRlciB0aGUgcmVxdWlyZWQgZGVjaW1hbCBwbGFjZXMuXHJcbiAgICAgIHhjLmxlbmd0aCA9IGktLTtcclxuXHJcbiAgICAgIC8vIFJvdW5kIHVwP1xyXG4gICAgICBpZiAobW9yZSkge1xyXG5cclxuICAgICAgICAvLyBSb3VuZGluZyB1cCBtYXkgbWVhbiB0aGUgcHJldmlvdXMgZGlnaXQgaGFzIHRvIGJlIHJvdW5kZWQgdXAuXHJcbiAgICAgICAgZm9yICg7ICsreGNbaV0gPiA5Oykge1xyXG4gICAgICAgICAgeGNbaV0gPSAwO1xyXG4gICAgICAgICAgaWYgKCFpLS0pIHtcclxuICAgICAgICAgICAgKyt4LmU7XHJcbiAgICAgICAgICAgIHhjLnVuc2hpZnQoMSk7XHJcbiAgICAgICAgICB9XHJcbiAgICAgICAgfVxyXG4gICAgICB9XHJcblxyXG4gICAgICAvLyBSZW1vdmUgdHJhaWxpbmcgemVyb3MuXHJcbiAgICAgIGZvciAoaSA9IHhjLmxlbmd0aDsgIXhjWy0taV07KSB4Yy5wb3AoKTtcclxuICAgIH1cclxuICB9IGVsc2UgaWYgKHJtIDwgMCB8fCBybSA+IDMgfHwgcm0gIT09IH5+cm0pIHtcclxuICAgIHRocm93IEVycm9yKElOVkFMSURfUk0pO1xyXG4gIH1cclxuXHJcbiAgcmV0dXJuIHg7XHJcbn1cclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBzdHJpbmcgcmVwcmVzZW50aW5nIHRoZSB2YWx1ZSBvZiBCaWcgeCBpbiBub3JtYWwgb3IgZXhwb25lbnRpYWwgbm90YXRpb24uXHJcbiAqIEhhbmRsZXMgUC50b0V4cG9uZW50aWFsLCBQLnRvRml4ZWQsIFAudG9KU09OLCBQLnRvUHJlY2lzaW9uLCBQLnRvU3RyaW5nIGFuZCBQLnZhbHVlT2YuXHJcbiAqXHJcbiAqIHgge0JpZ31cclxuICogaWQ/IHtudW1iZXJ9IENhbGxlciBpZC5cclxuICogICAgICAgICAxIHRvRXhwb25lbnRpYWxcclxuICogICAgICAgICAyIHRvRml4ZWRcclxuICogICAgICAgICAzIHRvUHJlY2lzaW9uXHJcbiAqICAgICAgICAgNCB2YWx1ZU9mXHJcbiAqIG4/IHtudW1iZXJ8dW5kZWZpbmVkfSBDYWxsZXIncyBhcmd1bWVudC5cclxuICogaz8ge251bWJlcnx1bmRlZmluZWR9XHJcbiAqL1xyXG5mdW5jdGlvbiBzdHJpbmdpZnkoeCwgaWQsIG4sIGspIHtcclxuICB2YXIgZSwgcyxcclxuICAgIEJpZyA9IHguY29uc3RydWN0b3IsXHJcbiAgICB6ID0gIXguY1swXTtcclxuXHJcbiAgaWYgKG4gIT09IFVOREVGSU5FRCkge1xyXG4gICAgaWYgKG4gIT09IH5+biB8fCBuIDwgKGlkID09IDMpIHx8IG4gPiBNQVhfRFApIHtcclxuICAgICAgdGhyb3cgRXJyb3IoaWQgPT0gMyA/IElOVkFMSUQgKyAncHJlY2lzaW9uJyA6IElOVkFMSURfRFApO1xyXG4gICAgfVxyXG5cclxuICAgIHggPSBuZXcgQmlnKHgpO1xyXG5cclxuICAgIC8vIFRoZSBpbmRleCBvZiB0aGUgZGlnaXQgdGhhdCBtYXkgYmUgcm91bmRlZCB1cC5cclxuICAgIG4gPSBrIC0geC5lO1xyXG5cclxuICAgIC8vIFJvdW5kP1xyXG4gICAgaWYgKHguYy5sZW5ndGggPiArK2spIHJvdW5kKHgsIG4sIEJpZy5STSk7XHJcblxyXG4gICAgLy8gdG9GaXhlZDogcmVjYWxjdWxhdGUgayBhcyB4LmUgbWF5IGhhdmUgY2hhbmdlZCBpZiB2YWx1ZSByb3VuZGVkIHVwLlxyXG4gICAgaWYgKGlkID09IDIpIGsgPSB4LmUgKyBuICsgMTtcclxuXHJcbiAgICAvLyBBcHBlbmQgemVyb3M/XHJcbiAgICBmb3IgKDsgeC5jLmxlbmd0aCA8IGs7KSB4LmMucHVzaCgwKTtcclxuICB9XHJcblxyXG4gIGUgPSB4LmU7XHJcbiAgcyA9IHguYy5qb2luKCcnKTtcclxuICBuID0gcy5sZW5ndGg7XHJcblxyXG4gIC8vIEV4cG9uZW50aWFsIG5vdGF0aW9uP1xyXG4gIGlmIChpZCAhPSAyICYmIChpZCA9PSAxIHx8IGlkID09IDMgJiYgayA8PSBlIHx8IGUgPD0gQmlnLk5FIHx8IGUgPj0gQmlnLlBFKSkge1xyXG4gICAgcyA9IHMuY2hhckF0KDApICsgKG4gPiAxID8gJy4nICsgcy5zbGljZSgxKSA6ICcnKSArIChlIDwgMCA/ICdlJyA6ICdlKycpICsgZTtcclxuXHJcbiAgLy8gTm9ybWFsIG5vdGF0aW9uLlxyXG4gIH0gZWxzZSBpZiAoZSA8IDApIHtcclxuICAgIGZvciAoOyArK2U7KSBzID0gJzAnICsgcztcclxuICAgIHMgPSAnMC4nICsgcztcclxuICB9IGVsc2UgaWYgKGUgPiAwKSB7XHJcbiAgICBpZiAoKytlID4gbikgZm9yIChlIC09IG47IGUtLTspIHMgKz0gJzAnO1xyXG4gICAgZWxzZSBpZiAoZSA8IG4pIHMgPSBzLnNsaWNlKDAsIGUpICsgJy4nICsgcy5zbGljZShlKTtcclxuICB9IGVsc2UgaWYgKG4gPiAxKSB7XHJcbiAgICBzID0gcy5jaGFyQXQoMCkgKyAnLicgKyBzLnNsaWNlKDEpO1xyXG4gIH1cclxuXHJcbiAgcmV0dXJuIHgucyA8IDAgJiYgKCF6IHx8IGlkID09IDQpID8gJy0nICsgcyA6IHM7XHJcbn1cclxuXHJcblxyXG4vLyBQcm90b3R5cGUvaW5zdGFuY2UgbWV0aG9kc1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIG5ldyBCaWcgd2hvc2UgdmFsdWUgaXMgdGhlIGFic29sdXRlIHZhbHVlIG9mIHRoaXMgQmlnLlxyXG4gKi9cclxuUC5hYnMgPSBmdW5jdGlvbiAoKSB7XHJcbiAgdmFyIHggPSBuZXcgdGhpcy5jb25zdHJ1Y3Rvcih0aGlzKTtcclxuICB4LnMgPSAxO1xyXG4gIHJldHVybiB4O1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiAxIGlmIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBpcyBncmVhdGVyIHRoYW4gdGhlIHZhbHVlIG9mIEJpZyB5LFxyXG4gKiAgICAgICAtMSBpZiB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgaXMgbGVzcyB0aGFuIHRoZSB2YWx1ZSBvZiBCaWcgeSwgb3JcclxuICogICAgICAgIDAgaWYgdGhleSBoYXZlIHRoZSBzYW1lIHZhbHVlLlxyXG4qL1xyXG5QLmNtcCA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgdmFyIGlzbmVnLFxyXG4gICAgeCA9IHRoaXMsXHJcbiAgICB4YyA9IHguYyxcclxuICAgIHljID0gKHkgPSBuZXcgeC5jb25zdHJ1Y3Rvcih5KSkuYyxcclxuICAgIGkgPSB4LnMsXHJcbiAgICBqID0geS5zLFxyXG4gICAgayA9IHguZSxcclxuICAgIGwgPSB5LmU7XHJcblxyXG4gIC8vIEVpdGhlciB6ZXJvP1xyXG4gIGlmICgheGNbMF0gfHwgIXljWzBdKSByZXR1cm4gIXhjWzBdID8gIXljWzBdID8gMCA6IC1qIDogaTtcclxuXHJcbiAgLy8gU2lnbnMgZGlmZmVyP1xyXG4gIGlmIChpICE9IGopIHJldHVybiBpO1xyXG5cclxuICBpc25lZyA9IGkgPCAwO1xyXG5cclxuICAvLyBDb21wYXJlIGV4cG9uZW50cy5cclxuICBpZiAoayAhPSBsKSByZXR1cm4gayA+IGwgXiBpc25lZyA/IDEgOiAtMTtcclxuXHJcbiAgaiA9IChrID0geGMubGVuZ3RoKSA8IChsID0geWMubGVuZ3RoKSA/IGsgOiBsO1xyXG5cclxuICAvLyBDb21wYXJlIGRpZ2l0IGJ5IGRpZ2l0LlxyXG4gIGZvciAoaSA9IC0xOyArK2kgPCBqOykge1xyXG4gICAgaWYgKHhjW2ldICE9IHljW2ldKSByZXR1cm4geGNbaV0gPiB5Y1tpXSBeIGlzbmVnID8gMSA6IC0xO1xyXG4gIH1cclxuXHJcbiAgLy8gQ29tcGFyZSBsZW5ndGhzLlxyXG4gIHJldHVybiBrID09IGwgPyAwIDogayA+IGwgXiBpc25lZyA/IDEgOiAtMTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBuZXcgQmlnIHdob3NlIHZhbHVlIGlzIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBkaXZpZGVkIGJ5IHRoZSB2YWx1ZSBvZiBCaWcgeSwgcm91bmRlZCxcclxuICogaWYgbmVjZXNzYXJ5LCB0byBhIG1heGltdW0gb2YgQmlnLkRQIGRlY2ltYWwgcGxhY2VzIHVzaW5nIHJvdW5kaW5nIG1vZGUgQmlnLlJNLlxyXG4gKi9cclxuUC5kaXYgPSBmdW5jdGlvbiAoeSkge1xyXG4gIHZhciB4ID0gdGhpcyxcclxuICAgIEJpZyA9IHguY29uc3RydWN0b3IsXHJcbiAgICBhID0geC5jLCAgICAgICAgICAgICAgICAgIC8vIGRpdmlkZW5kXHJcbiAgICBiID0gKHkgPSBuZXcgQmlnKHkpKS5jLCAgIC8vIGRpdmlzb3JcclxuICAgIGsgPSB4LnMgPT0geS5zID8gMSA6IC0xLFxyXG4gICAgZHAgPSBCaWcuRFA7XHJcblxyXG4gIGlmIChkcCAhPT0gfn5kcCB8fCBkcCA8IDAgfHwgZHAgPiBNQVhfRFApIHRocm93IEVycm9yKElOVkFMSURfRFApO1xyXG5cclxuICAvLyBEaXZpc29yIGlzIHplcm8/XHJcbiAgaWYgKCFiWzBdKSB0aHJvdyBFcnJvcihESVZfQllfWkVSTyk7XHJcblxyXG4gIC8vIERpdmlkZW5kIGlzIDA/IFJldHVybiArLTAuXHJcbiAgaWYgKCFhWzBdKSByZXR1cm4gbmV3IEJpZyhrICogMCk7XHJcblxyXG4gIHZhciBibCwgYnQsIG4sIGNtcCwgcmksXHJcbiAgICBieiA9IGIuc2xpY2UoKSxcclxuICAgIGFpID0gYmwgPSBiLmxlbmd0aCxcclxuICAgIGFsID0gYS5sZW5ndGgsXHJcbiAgICByID0gYS5zbGljZSgwLCBibCksICAgLy8gcmVtYWluZGVyXHJcbiAgICBybCA9IHIubGVuZ3RoLFxyXG4gICAgcSA9IHksICAgICAgICAgICAgICAgIC8vIHF1b3RpZW50XHJcbiAgICBxYyA9IHEuYyA9IFtdLFxyXG4gICAgcWkgPSAwLFxyXG4gICAgZCA9IGRwICsgKHEuZSA9IHguZSAtIHkuZSkgKyAxOyAgICAvLyBudW1iZXIgb2YgZGlnaXRzIG9mIHRoZSByZXN1bHRcclxuXHJcbiAgcS5zID0gaztcclxuICBrID0gZCA8IDAgPyAwIDogZDtcclxuXHJcbiAgLy8gQ3JlYXRlIHZlcnNpb24gb2YgZGl2aXNvciB3aXRoIGxlYWRpbmcgemVyby5cclxuICBiei51bnNoaWZ0KDApO1xyXG5cclxuICAvLyBBZGQgemVyb3MgdG8gbWFrZSByZW1haW5kZXIgYXMgbG9uZyBhcyBkaXZpc29yLlxyXG4gIGZvciAoOyBybCsrIDwgYmw7KSByLnB1c2goMCk7XHJcblxyXG4gIGRvIHtcclxuXHJcbiAgICAvLyBuIGlzIGhvdyBtYW55IHRpbWVzIHRoZSBkaXZpc29yIGdvZXMgaW50byBjdXJyZW50IHJlbWFpbmRlci5cclxuICAgIGZvciAobiA9IDA7IG4gPCAxMDsgbisrKSB7XHJcblxyXG4gICAgICAvLyBDb21wYXJlIGRpdmlzb3IgYW5kIHJlbWFpbmRlci5cclxuICAgICAgaWYgKGJsICE9IChybCA9IHIubGVuZ3RoKSkge1xyXG4gICAgICAgIGNtcCA9IGJsID4gcmwgPyAxIDogLTE7XHJcbiAgICAgIH0gZWxzZSB7XHJcbiAgICAgICAgZm9yIChyaSA9IC0xLCBjbXAgPSAwOyArK3JpIDwgYmw7KSB7XHJcbiAgICAgICAgICBpZiAoYltyaV0gIT0gcltyaV0pIHtcclxuICAgICAgICAgICAgY21wID0gYltyaV0gPiByW3JpXSA/IDEgOiAtMTtcclxuICAgICAgICAgICAgYnJlYWs7XHJcbiAgICAgICAgICB9XHJcbiAgICAgICAgfVxyXG4gICAgICB9XHJcblxyXG4gICAgICAvLyBJZiBkaXZpc29yIDwgcmVtYWluZGVyLCBzdWJ0cmFjdCBkaXZpc29yIGZyb20gcmVtYWluZGVyLlxyXG4gICAgICBpZiAoY21wIDwgMCkge1xyXG5cclxuICAgICAgICAvLyBSZW1haW5kZXIgY2FuJ3QgYmUgbW9yZSB0aGFuIDEgZGlnaXQgbG9uZ2VyIHRoYW4gZGl2aXNvci5cclxuICAgICAgICAvLyBFcXVhbGlzZSBsZW5ndGhzIHVzaW5nIGRpdmlzb3Igd2l0aCBleHRyYSBsZWFkaW5nIHplcm8/XHJcbiAgICAgICAgZm9yIChidCA9IHJsID09IGJsID8gYiA6IGJ6OyBybDspIHtcclxuICAgICAgICAgIGlmIChyWy0tcmxdIDwgYnRbcmxdKSB7XHJcbiAgICAgICAgICAgIHJpID0gcmw7XHJcbiAgICAgICAgICAgIGZvciAoOyByaSAmJiAhclstLXJpXTspIHJbcmldID0gOTtcclxuICAgICAgICAgICAgLS1yW3JpXTtcclxuICAgICAgICAgICAgcltybF0gKz0gMTA7XHJcbiAgICAgICAgICB9XHJcbiAgICAgICAgICByW3JsXSAtPSBidFtybF07XHJcbiAgICAgICAgfVxyXG5cclxuICAgICAgICBmb3IgKDsgIXJbMF07KSByLnNoaWZ0KCk7XHJcbiAgICAgIH0gZWxzZSB7XHJcbiAgICAgICAgYnJlYWs7XHJcbiAgICAgIH1cclxuICAgIH1cclxuXHJcbiAgICAvLyBBZGQgdGhlIGRpZ2l0IG4gdG8gdGhlIHJlc3VsdCBhcnJheS5cclxuICAgIHFjW3FpKytdID0gY21wID8gbiA6ICsrbjtcclxuXHJcbiAgICAvLyBVcGRhdGUgdGhlIHJlbWFpbmRlci5cclxuICAgIGlmIChyWzBdICYmIGNtcCkgcltybF0gPSBhW2FpXSB8fCAwO1xyXG4gICAgZWxzZSByID0gW2FbYWldXTtcclxuXHJcbiAgfSB3aGlsZSAoKGFpKysgPCBhbCB8fCByWzBdICE9PSBVTkRFRklORUQpICYmIGstLSk7XHJcblxyXG4gIC8vIExlYWRpbmcgemVybz8gRG8gbm90IHJlbW92ZSBpZiByZXN1bHQgaXMgc2ltcGx5IHplcm8gKHFpID09IDEpLlxyXG4gIGlmICghcWNbMF0gJiYgcWkgIT0gMSkge1xyXG5cclxuICAgIC8vIFRoZXJlIGNhbid0IGJlIG1vcmUgdGhhbiBvbmUgemVyby5cclxuICAgIHFjLnNoaWZ0KCk7XHJcbiAgICBxLmUtLTtcclxuICB9XHJcblxyXG4gIC8vIFJvdW5kP1xyXG4gIGlmIChxaSA+IGQpIHJvdW5kKHEsIGRwLCBCaWcuUk0sIHJbMF0gIT09IFVOREVGSU5FRCk7XHJcblxyXG4gIHJldHVybiBxO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiB0cnVlIGlmIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBpcyBlcXVhbCB0byB0aGUgdmFsdWUgb2YgQmlnIHksIG90aGVyd2lzZSByZXR1cm4gZmFsc2UuXHJcbiAqL1xyXG5QLmVxID0gZnVuY3Rpb24gKHkpIHtcclxuICByZXR1cm4gIXRoaXMuY21wKHkpO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiB0cnVlIGlmIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBpcyBncmVhdGVyIHRoYW4gdGhlIHZhbHVlIG9mIEJpZyB5LCBvdGhlcndpc2UgcmV0dXJuXHJcbiAqIGZhbHNlLlxyXG4gKi9cclxuUC5ndCA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgcmV0dXJuIHRoaXMuY21wKHkpID4gMDtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gdHJ1ZSBpZiB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgaXMgZ3JlYXRlciB0aGFuIG9yIGVxdWFsIHRvIHRoZSB2YWx1ZSBvZiBCaWcgeSwgb3RoZXJ3aXNlXHJcbiAqIHJldHVybiBmYWxzZS5cclxuICovXHJcblAuZ3RlID0gZnVuY3Rpb24gKHkpIHtcclxuICByZXR1cm4gdGhpcy5jbXAoeSkgPiAtMTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gdHJ1ZSBpZiB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgaXMgbGVzcyB0aGFuIHRoZSB2YWx1ZSBvZiBCaWcgeSwgb3RoZXJ3aXNlIHJldHVybiBmYWxzZS5cclxuICovXHJcblAubHQgPSBmdW5jdGlvbiAoeSkge1xyXG4gIHJldHVybiB0aGlzLmNtcCh5KSA8IDA7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIHRydWUgaWYgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIGlzIGxlc3MgdGhhbiBvciBlcXVhbCB0byB0aGUgdmFsdWUgb2YgQmlnIHksIG90aGVyd2lzZVxyXG4gKiByZXR1cm4gZmFsc2UuXHJcbiAqL1xyXG5QLmx0ZSA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgcmV0dXJuIHRoaXMuY21wKHkpIDwgMTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBuZXcgQmlnIHdob3NlIHZhbHVlIGlzIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBtaW51cyB0aGUgdmFsdWUgb2YgQmlnIHkuXHJcbiAqL1xyXG5QLm1pbnVzID0gUC5zdWIgPSBmdW5jdGlvbiAoeSkge1xyXG4gIHZhciBpLCBqLCB0LCB4bHR5LFxyXG4gICAgeCA9IHRoaXMsXHJcbiAgICBCaWcgPSB4LmNvbnN0cnVjdG9yLFxyXG4gICAgYSA9IHgucyxcclxuICAgIGIgPSAoeSA9IG5ldyBCaWcoeSkpLnM7XHJcblxyXG4gIC8vIFNpZ25zIGRpZmZlcj9cclxuICBpZiAoYSAhPSBiKSB7XHJcbiAgICB5LnMgPSAtYjtcclxuICAgIHJldHVybiB4LnBsdXMoeSk7XHJcbiAgfVxyXG5cclxuICB2YXIgeGMgPSB4LmMuc2xpY2UoKSxcclxuICAgIHhlID0geC5lLFxyXG4gICAgeWMgPSB5LmMsXHJcbiAgICB5ZSA9IHkuZTtcclxuXHJcbiAgLy8gRWl0aGVyIHplcm8/XHJcbiAgaWYgKCF4Y1swXSB8fCAheWNbMF0pIHtcclxuXHJcbiAgICAvLyB5IGlzIG5vbi16ZXJvPyB4IGlzIG5vbi16ZXJvPyBPciBib3RoIGFyZSB6ZXJvLlxyXG4gICAgcmV0dXJuIHljWzBdID8gKHkucyA9IC1iLCB5KSA6IG5ldyBCaWcoeGNbMF0gPyB4IDogMCk7XHJcbiAgfVxyXG5cclxuICAvLyBEZXRlcm1pbmUgd2hpY2ggaXMgdGhlIGJpZ2dlciBudW1iZXIuIFByZXBlbmQgemVyb3MgdG8gZXF1YWxpc2UgZXhwb25lbnRzLlxyXG4gIGlmIChhID0geGUgLSB5ZSkge1xyXG5cclxuICAgIGlmICh4bHR5ID0gYSA8IDApIHtcclxuICAgICAgYSA9IC1hO1xyXG4gICAgICB0ID0geGM7XHJcbiAgICB9IGVsc2Uge1xyXG4gICAgICB5ZSA9IHhlO1xyXG4gICAgICB0ID0geWM7XHJcbiAgICB9XHJcblxyXG4gICAgdC5yZXZlcnNlKCk7XHJcbiAgICBmb3IgKGIgPSBhOyBiLS07KSB0LnB1c2goMCk7XHJcbiAgICB0LnJldmVyc2UoKTtcclxuICB9IGVsc2Uge1xyXG5cclxuICAgIC8vIEV4cG9uZW50cyBlcXVhbC4gQ2hlY2sgZGlnaXQgYnkgZGlnaXQuXHJcbiAgICBqID0gKCh4bHR5ID0geGMubGVuZ3RoIDwgeWMubGVuZ3RoKSA/IHhjIDogeWMpLmxlbmd0aDtcclxuXHJcbiAgICBmb3IgKGEgPSBiID0gMDsgYiA8IGo7IGIrKykge1xyXG4gICAgICBpZiAoeGNbYl0gIT0geWNbYl0pIHtcclxuICAgICAgICB4bHR5ID0geGNbYl0gPCB5Y1tiXTtcclxuICAgICAgICBicmVhaztcclxuICAgICAgfVxyXG4gICAgfVxyXG4gIH1cclxuXHJcbiAgLy8geCA8IHk/IFBvaW50IHhjIHRvIHRoZSBhcnJheSBvZiB0aGUgYmlnZ2VyIG51bWJlci5cclxuICBpZiAoeGx0eSkge1xyXG4gICAgdCA9IHhjO1xyXG4gICAgeGMgPSB5YztcclxuICAgIHljID0gdDtcclxuICAgIHkucyA9IC15LnM7XHJcbiAgfVxyXG5cclxuICAvKlxyXG4gICAqIEFwcGVuZCB6ZXJvcyB0byB4YyBpZiBzaG9ydGVyLiBObyBuZWVkIHRvIGFkZCB6ZXJvcyB0byB5YyBpZiBzaG9ydGVyIGFzIHN1YnRyYWN0aW9uIG9ubHlcclxuICAgKiBuZWVkcyB0byBzdGFydCBhdCB5Yy5sZW5ndGguXHJcbiAgICovXHJcbiAgaWYgKChiID0gKGogPSB5Yy5sZW5ndGgpIC0gKGkgPSB4Yy5sZW5ndGgpKSA+IDApIGZvciAoOyBiLS07KSB4Y1tpKytdID0gMDtcclxuXHJcbiAgLy8gU3VidHJhY3QgeWMgZnJvbSB4Yy5cclxuICBmb3IgKGIgPSBpOyBqID4gYTspIHtcclxuICAgIGlmICh4Y1stLWpdIDwgeWNbal0pIHtcclxuICAgICAgZm9yIChpID0gajsgaSAmJiAheGNbLS1pXTspIHhjW2ldID0gOTtcclxuICAgICAgLS14Y1tpXTtcclxuICAgICAgeGNbal0gKz0gMTA7XHJcbiAgICB9XHJcblxyXG4gICAgeGNbal0gLT0geWNbal07XHJcbiAgfVxyXG5cclxuICAvLyBSZW1vdmUgdHJhaWxpbmcgemVyb3MuXHJcbiAgZm9yICg7IHhjWy0tYl0gPT09IDA7KSB4Yy5wb3AoKTtcclxuXHJcbiAgLy8gUmVtb3ZlIGxlYWRpbmcgemVyb3MgYW5kIGFkanVzdCBleHBvbmVudCBhY2NvcmRpbmdseS5cclxuICBmb3IgKDsgeGNbMF0gPT09IDA7KSB7XHJcbiAgICB4Yy5zaGlmdCgpO1xyXG4gICAgLS15ZTtcclxuICB9XHJcblxyXG4gIGlmICgheGNbMF0pIHtcclxuXHJcbiAgICAvLyBuIC0gbiA9ICswXHJcbiAgICB5LnMgPSAxO1xyXG5cclxuICAgIC8vIFJlc3VsdCBtdXN0IGJlIHplcm8uXHJcbiAgICB4YyA9IFt5ZSA9IDBdO1xyXG4gIH1cclxuXHJcbiAgeS5jID0geGM7XHJcbiAgeS5lID0geWU7XHJcblxyXG4gIHJldHVybiB5O1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIG5ldyBCaWcgd2hvc2UgdmFsdWUgaXMgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIG1vZHVsbyB0aGUgdmFsdWUgb2YgQmlnIHkuXHJcbiAqL1xyXG5QLm1vZCA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgdmFyIHlndHgsXHJcbiAgICB4ID0gdGhpcyxcclxuICAgIEJpZyA9IHguY29uc3RydWN0b3IsXHJcbiAgICBhID0geC5zLFxyXG4gICAgYiA9ICh5ID0gbmV3IEJpZyh5KSkucztcclxuXHJcbiAgaWYgKCF5LmNbMF0pIHRocm93IEVycm9yKERJVl9CWV9aRVJPKTtcclxuXHJcbiAgeC5zID0geS5zID0gMTtcclxuICB5Z3R4ID0geS5jbXAoeCkgPT0gMTtcclxuICB4LnMgPSBhO1xyXG4gIHkucyA9IGI7XHJcblxyXG4gIGlmICh5Z3R4KSByZXR1cm4gbmV3IEJpZyh4KTtcclxuXHJcbiAgYSA9IEJpZy5EUDtcclxuICBiID0gQmlnLlJNO1xyXG4gIEJpZy5EUCA9IEJpZy5STSA9IDA7XHJcbiAgeCA9IHguZGl2KHkpO1xyXG4gIEJpZy5EUCA9IGE7XHJcbiAgQmlnLlJNID0gYjtcclxuXHJcbiAgcmV0dXJuIHRoaXMubWludXMoeC50aW1lcyh5KSk7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgbmV3IEJpZyB3aG9zZSB2YWx1ZSBpcyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgcGx1cyB0aGUgdmFsdWUgb2YgQmlnIHkuXHJcbiAqL1xyXG5QLnBsdXMgPSBQLmFkZCA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgdmFyIHQsXHJcbiAgICB4ID0gdGhpcyxcclxuICAgIEJpZyA9IHguY29uc3RydWN0b3IsXHJcbiAgICBhID0geC5zLFxyXG4gICAgYiA9ICh5ID0gbmV3IEJpZyh5KSkucztcclxuXHJcbiAgLy8gU2lnbnMgZGlmZmVyP1xyXG4gIGlmIChhICE9IGIpIHtcclxuICAgIHkucyA9IC1iO1xyXG4gICAgcmV0dXJuIHgubWludXMoeSk7XHJcbiAgfVxyXG5cclxuICB2YXIgeGUgPSB4LmUsXHJcbiAgICB4YyA9IHguYyxcclxuICAgIHllID0geS5lLFxyXG4gICAgeWMgPSB5LmM7XHJcblxyXG4gIC8vIEVpdGhlciB6ZXJvPyB5IGlzIG5vbi16ZXJvPyB4IGlzIG5vbi16ZXJvPyBPciBib3RoIGFyZSB6ZXJvLlxyXG4gIGlmICgheGNbMF0gfHwgIXljWzBdKSByZXR1cm4geWNbMF0gPyB5IDogbmV3IEJpZyh4Y1swXSA/IHggOiBhICogMCk7XHJcblxyXG4gIHhjID0geGMuc2xpY2UoKTtcclxuXHJcbiAgLy8gUHJlcGVuZCB6ZXJvcyB0byBlcXVhbGlzZSBleHBvbmVudHMuXHJcbiAgLy8gTm90ZTogcmV2ZXJzZSBmYXN0ZXIgdGhhbiB1bnNoaWZ0cy5cclxuICBpZiAoYSA9IHhlIC0geWUpIHtcclxuICAgIGlmIChhID4gMCkge1xyXG4gICAgICB5ZSA9IHhlO1xyXG4gICAgICB0ID0geWM7XHJcbiAgICB9IGVsc2Uge1xyXG4gICAgICBhID0gLWE7XHJcbiAgICAgIHQgPSB4YztcclxuICAgIH1cclxuXHJcbiAgICB0LnJldmVyc2UoKTtcclxuICAgIGZvciAoOyBhLS07KSB0LnB1c2goMCk7XHJcbiAgICB0LnJldmVyc2UoKTtcclxuICB9XHJcblxyXG4gIC8vIFBvaW50IHhjIHRvIHRoZSBsb25nZXIgYXJyYXkuXHJcbiAgaWYgKHhjLmxlbmd0aCAtIHljLmxlbmd0aCA8IDApIHtcclxuICAgIHQgPSB5YztcclxuICAgIHljID0geGM7XHJcbiAgICB4YyA9IHQ7XHJcbiAgfVxyXG5cclxuICBhID0geWMubGVuZ3RoO1xyXG5cclxuICAvLyBPbmx5IHN0YXJ0IGFkZGluZyBhdCB5Yy5sZW5ndGggLSAxIGFzIHRoZSBmdXJ0aGVyIGRpZ2l0cyBvZiB4YyBjYW4gYmUgbGVmdCBhcyB0aGV5IGFyZS5cclxuICBmb3IgKGIgPSAwOyBhOyB4Y1thXSAlPSAxMCkgYiA9ICh4Y1stLWFdID0geGNbYV0gKyB5Y1thXSArIGIpIC8gMTAgfCAwO1xyXG5cclxuICAvLyBObyBuZWVkIHRvIGNoZWNrIGZvciB6ZXJvLCBhcyAreCArICt5ICE9IDAgJiYgLXggKyAteSAhPSAwXHJcblxyXG4gIGlmIChiKSB7XHJcbiAgICB4Yy51bnNoaWZ0KGIpO1xyXG4gICAgKyt5ZTtcclxuICB9XHJcblxyXG4gIC8vIFJlbW92ZSB0cmFpbGluZyB6ZXJvcy5cclxuICBmb3IgKGEgPSB4Yy5sZW5ndGg7IHhjWy0tYV0gPT09IDA7KSB4Yy5wb3AoKTtcclxuXHJcbiAgeS5jID0geGM7XHJcbiAgeS5lID0geWU7XHJcblxyXG4gIHJldHVybiB5O1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIEJpZyB3aG9zZSB2YWx1ZSBpcyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgcmFpc2VkIHRvIHRoZSBwb3dlciBuLlxyXG4gKiBJZiBuIGlzIG5lZ2F0aXZlLCByb3VuZCB0byBhIG1heGltdW0gb2YgQmlnLkRQIGRlY2ltYWwgcGxhY2VzIHVzaW5nIHJvdW5kaW5nXHJcbiAqIG1vZGUgQmlnLlJNLlxyXG4gKlxyXG4gKiBuIHtudW1iZXJ9IEludGVnZXIsIC1NQVhfUE9XRVIgdG8gTUFYX1BPV0VSIGluY2x1c2l2ZS5cclxuICovXHJcblAucG93ID0gZnVuY3Rpb24gKG4pIHtcclxuICB2YXIgeCA9IHRoaXMsXHJcbiAgICBvbmUgPSBuZXcgeC5jb25zdHJ1Y3RvcigxKSxcclxuICAgIHkgPSBvbmUsXHJcbiAgICBpc25lZyA9IG4gPCAwO1xyXG5cclxuICBpZiAobiAhPT0gfn5uIHx8IG4gPCAtTUFYX1BPV0VSIHx8IG4gPiBNQVhfUE9XRVIpIHRocm93IEVycm9yKElOVkFMSUQgKyAnZXhwb25lbnQnKTtcclxuICBpZiAoaXNuZWcpIG4gPSAtbjtcclxuXHJcbiAgZm9yICg7Oykge1xyXG4gICAgaWYgKG4gJiAxKSB5ID0geS50aW1lcyh4KTtcclxuICAgIG4gPj49IDE7XHJcbiAgICBpZiAoIW4pIGJyZWFrO1xyXG4gICAgeCA9IHgudGltZXMoeCk7XHJcbiAgfVxyXG5cclxuICByZXR1cm4gaXNuZWcgPyBvbmUuZGl2KHkpIDogeTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBuZXcgQmlnIHdob3NlIHZhbHVlIGlzIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyByb3VuZGVkIHVzaW5nIHJvdW5kaW5nIG1vZGUgcm1cclxuICogdG8gYSBtYXhpbXVtIG9mIGRwIGRlY2ltYWwgcGxhY2VzLCBvciwgaWYgZHAgaXMgbmVnYXRpdmUsIHRvIGFuIGludGVnZXIgd2hpY2ggaXMgYVxyXG4gKiBtdWx0aXBsZSBvZiAxMCoqLWRwLlxyXG4gKiBJZiBkcCBpcyBub3Qgc3BlY2lmaWVkLCByb3VuZCB0byAwIGRlY2ltYWwgcGxhY2VzLlxyXG4gKiBJZiBybSBpcyBub3Qgc3BlY2lmaWVkLCB1c2UgQmlnLlJNLlxyXG4gKlxyXG4gKiBkcD8ge251bWJlcn0gSW50ZWdlciwgLU1BWF9EUCB0byBNQVhfRFAgaW5jbHVzaXZlLlxyXG4gKiBybT8gMCwgMSwgMiBvciAzIChST1VORF9ET1dOLCBST1VORF9IQUxGX1VQLCBST1VORF9IQUxGX0VWRU4sIFJPVU5EX1VQKVxyXG4gKi9cclxuUC5yb3VuZCA9IGZ1bmN0aW9uIChkcCwgcm0pIHtcclxuICB2YXIgQmlnID0gdGhpcy5jb25zdHJ1Y3RvcjtcclxuICBpZiAoZHAgPT09IFVOREVGSU5FRCkgZHAgPSAwO1xyXG4gIGVsc2UgaWYgKGRwICE9PSB+fmRwIHx8IGRwIDwgLU1BWF9EUCB8fCBkcCA+IE1BWF9EUCkgdGhyb3cgRXJyb3IoSU5WQUxJRF9EUCk7XHJcbiAgcmV0dXJuIHJvdW5kKG5ldyBCaWcodGhpcyksIGRwLCBybSA9PT0gVU5ERUZJTkVEID8gQmlnLlJNIDogcm0pO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIG5ldyBCaWcgd2hvc2UgdmFsdWUgaXMgdGhlIHNxdWFyZSByb290IG9mIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZywgcm91bmRlZCwgaWZcclxuICogbmVjZXNzYXJ5LCB0byBhIG1heGltdW0gb2YgQmlnLkRQIGRlY2ltYWwgcGxhY2VzIHVzaW5nIHJvdW5kaW5nIG1vZGUgQmlnLlJNLlxyXG4gKi9cclxuUC5zcXJ0ID0gZnVuY3Rpb24gKCkge1xyXG4gIHZhciByLCBjLCB0LFxyXG4gICAgeCA9IHRoaXMsXHJcbiAgICBCaWcgPSB4LmNvbnN0cnVjdG9yLFxyXG4gICAgcyA9IHgucyxcclxuICAgIGUgPSB4LmUsXHJcbiAgICBoYWxmID0gbmV3IEJpZygwLjUpO1xyXG5cclxuICAvLyBaZXJvP1xyXG4gIGlmICgheC5jWzBdKSByZXR1cm4gbmV3IEJpZyh4KTtcclxuXHJcbiAgLy8gTmVnYXRpdmU/XHJcbiAgaWYgKHMgPCAwKSB0aHJvdyBFcnJvcihOQU1FICsgJ05vIHNxdWFyZSByb290Jyk7XHJcblxyXG4gIC8vIEVzdGltYXRlLlxyXG4gIHMgPSBNYXRoLnNxcnQoeCArICcnKTtcclxuXHJcbiAgLy8gTWF0aC5zcXJ0IHVuZGVyZmxvdy9vdmVyZmxvdz9cclxuICAvLyBSZS1lc3RpbWF0ZTogcGFzcyB4IGNvZWZmaWNpZW50IHRvIE1hdGguc3FydCBhcyBpbnRlZ2VyLCB0aGVuIGFkanVzdCB0aGUgcmVzdWx0IGV4cG9uZW50LlxyXG4gIGlmIChzID09PSAwIHx8IHMgPT09IDEgLyAwKSB7XHJcbiAgICBjID0geC5jLmpvaW4oJycpO1xyXG4gICAgaWYgKCEoYy5sZW5ndGggKyBlICYgMSkpIGMgKz0gJzAnO1xyXG4gICAgcyA9IE1hdGguc3FydChjKTtcclxuICAgIGUgPSAoKGUgKyAxKSAvIDIgfCAwKSAtIChlIDwgMCB8fCBlICYgMSk7XHJcbiAgICByID0gbmV3IEJpZygocyA9PSAxIC8gMCA/ICcxZScgOiAocyA9IHMudG9FeHBvbmVudGlhbCgpKS5zbGljZSgwLCBzLmluZGV4T2YoJ2UnKSArIDEpKSArIGUpO1xyXG4gIH0gZWxzZSB7XHJcbiAgICByID0gbmV3IEJpZyhzKTtcclxuICB9XHJcblxyXG4gIGUgPSByLmUgKyAoQmlnLkRQICs9IDQpO1xyXG5cclxuICAvLyBOZXd0b24tUmFwaHNvbiBpdGVyYXRpb24uXHJcbiAgZG8ge1xyXG4gICAgdCA9IHI7XHJcbiAgICByID0gaGFsZi50aW1lcyh0LnBsdXMoeC5kaXYodCkpKTtcclxuICB9IHdoaWxlICh0LmMuc2xpY2UoMCwgZSkuam9pbignJykgIT09IHIuYy5zbGljZSgwLCBlKS5qb2luKCcnKSk7XHJcblxyXG4gIHJldHVybiByb3VuZChyLCBCaWcuRFAgLT0gNCwgQmlnLlJNKTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBuZXcgQmlnIHdob3NlIHZhbHVlIGlzIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyB0aW1lcyB0aGUgdmFsdWUgb2YgQmlnIHkuXHJcbiAqL1xyXG5QLnRpbWVzID0gUC5tdWwgPSBmdW5jdGlvbiAoeSkge1xyXG4gIHZhciBjLFxyXG4gICAgeCA9IHRoaXMsXHJcbiAgICBCaWcgPSB4LmNvbnN0cnVjdG9yLFxyXG4gICAgeGMgPSB4LmMsXHJcbiAgICB5YyA9ICh5ID0gbmV3IEJpZyh5KSkuYyxcclxuICAgIGEgPSB4Yy5sZW5ndGgsXHJcbiAgICBiID0geWMubGVuZ3RoLFxyXG4gICAgaSA9IHguZSxcclxuICAgIGogPSB5LmU7XHJcblxyXG4gIC8vIERldGVybWluZSBzaWduIG9mIHJlc3VsdC5cclxuICB5LnMgPSB4LnMgPT0geS5zID8gMSA6IC0xO1xyXG5cclxuICAvLyBSZXR1cm4gc2lnbmVkIDAgaWYgZWl0aGVyIDAuXHJcbiAgaWYgKCF4Y1swXSB8fCAheWNbMF0pIHJldHVybiBuZXcgQmlnKHkucyAqIDApO1xyXG5cclxuICAvLyBJbml0aWFsaXNlIGV4cG9uZW50IG9mIHJlc3VsdCBhcyB4LmUgKyB5LmUuXHJcbiAgeS5lID0gaSArIGo7XHJcblxyXG4gIC8vIElmIGFycmF5IHhjIGhhcyBmZXdlciBkaWdpdHMgdGhhbiB5Yywgc3dhcCB4YyBhbmQgeWMsIGFuZCBsZW5ndGhzLlxyXG4gIGlmIChhIDwgYikge1xyXG4gICAgYyA9IHhjO1xyXG4gICAgeGMgPSB5YztcclxuICAgIHljID0gYztcclxuICAgIGogPSBhO1xyXG4gICAgYSA9IGI7XHJcbiAgICBiID0gajtcclxuICB9XHJcblxyXG4gIC8vIEluaXRpYWxpc2UgY29lZmZpY2llbnQgYXJyYXkgb2YgcmVzdWx0IHdpdGggemVyb3MuXHJcbiAgZm9yIChjID0gbmV3IEFycmF5KGogPSBhICsgYik7IGotLTspIGNbal0gPSAwO1xyXG5cclxuICAvLyBNdWx0aXBseS5cclxuXHJcbiAgLy8gaSBpcyBpbml0aWFsbHkgeGMubGVuZ3RoLlxyXG4gIGZvciAoaSA9IGI7IGktLTspIHtcclxuICAgIGIgPSAwO1xyXG5cclxuICAgIC8vIGEgaXMgeWMubGVuZ3RoLlxyXG4gICAgZm9yIChqID0gYSArIGk7IGogPiBpOykge1xyXG5cclxuICAgICAgLy8gQ3VycmVudCBzdW0gb2YgcHJvZHVjdHMgYXQgdGhpcyBkaWdpdCBwb3NpdGlvbiwgcGx1cyBjYXJyeS5cclxuICAgICAgYiA9IGNbal0gKyB5Y1tpXSAqIHhjW2ogLSBpIC0gMV0gKyBiO1xyXG4gICAgICBjW2otLV0gPSBiICUgMTA7XHJcblxyXG4gICAgICAvLyBjYXJyeVxyXG4gICAgICBiID0gYiAvIDEwIHwgMDtcclxuICAgIH1cclxuXHJcbiAgICBjW2pdID0gKGNbal0gKyBiKSAlIDEwO1xyXG4gIH1cclxuXHJcbiAgLy8gSW5jcmVtZW50IHJlc3VsdCBleHBvbmVudCBpZiB0aGVyZSBpcyBhIGZpbmFsIGNhcnJ5LCBvdGhlcndpc2UgcmVtb3ZlIGxlYWRpbmcgemVyby5cclxuICBpZiAoYikgKyt5LmU7XHJcbiAgZWxzZSBjLnNoaWZ0KCk7XHJcblxyXG4gIC8vIFJlbW92ZSB0cmFpbGluZyB6ZXJvcy5cclxuICBmb3IgKGkgPSBjLmxlbmd0aDsgIWNbLS1pXTspIGMucG9wKCk7XHJcbiAgeS5jID0gYztcclxuXHJcbiAgcmV0dXJuIHk7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgc3RyaW5nIHJlcHJlc2VudGluZyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgaW4gZXhwb25lbnRpYWwgbm90YXRpb24gdG8gZHAgZml4ZWQgZGVjaW1hbFxyXG4gKiBwbGFjZXMgYW5kIHJvdW5kZWQgdXNpbmcgQmlnLlJNLlxyXG4gKlxyXG4gKiBkcD8ge251bWJlcn0gSW50ZWdlciwgMCB0byBNQVhfRFAgaW5jbHVzaXZlLlxyXG4gKi9cclxuUC50b0V4cG9uZW50aWFsID0gZnVuY3Rpb24gKGRwKSB7XHJcbiAgcmV0dXJuIHN0cmluZ2lmeSh0aGlzLCAxLCBkcCwgZHApO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIHN0cmluZyByZXByZXNlbnRpbmcgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIGluIG5vcm1hbCBub3RhdGlvbiB0byBkcCBmaXhlZCBkZWNpbWFsXHJcbiAqIHBsYWNlcyBhbmQgcm91bmRlZCB1c2luZyBCaWcuUk0uXHJcbiAqXHJcbiAqIGRwPyB7bnVtYmVyfSBJbnRlZ2VyLCAwIHRvIE1BWF9EUCBpbmNsdXNpdmUuXHJcbiAqXHJcbiAqICgtMCkudG9GaXhlZCgwKSBpcyAnMCcsIGJ1dCAoLTAuMSkudG9GaXhlZCgwKSBpcyAnLTAnLlxyXG4gKiAoLTApLnRvRml4ZWQoMSkgaXMgJzAuMCcsIGJ1dCAoLTAuMDEpLnRvRml4ZWQoMSkgaXMgJy0wLjAnLlxyXG4gKi9cclxuUC50b0ZpeGVkID0gZnVuY3Rpb24gKGRwKSB7XHJcbiAgcmV0dXJuIHN0cmluZ2lmeSh0aGlzLCAyLCBkcCwgdGhpcy5lICsgZHApO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIHN0cmluZyByZXByZXNlbnRpbmcgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIHJvdW5kZWQgdG8gc2Qgc2lnbmlmaWNhbnQgZGlnaXRzIHVzaW5nXHJcbiAqIEJpZy5STS4gVXNlIGV4cG9uZW50aWFsIG5vdGF0aW9uIGlmIHNkIGlzIGxlc3MgdGhhbiB0aGUgbnVtYmVyIG9mIGRpZ2l0cyBuZWNlc3NhcnkgdG8gcmVwcmVzZW50XHJcbiAqIHRoZSBpbnRlZ2VyIHBhcnQgb2YgdGhlIHZhbHVlIGluIG5vcm1hbCBub3RhdGlvbi5cclxuICpcclxuICogc2Qge251bWJlcn0gSW50ZWdlciwgMSB0byBNQVhfRFAgaW5jbHVzaXZlLlxyXG4gKi9cclxuUC50b1ByZWNpc2lvbiA9IGZ1bmN0aW9uIChzZCkge1xyXG4gIHJldHVybiBzdHJpbmdpZnkodGhpcywgMywgc2QsIHNkIC0gMSk7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgc3RyaW5nIHJlcHJlc2VudGluZyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcuXHJcbiAqIFJldHVybiBleHBvbmVudGlhbCBub3RhdGlvbiBpZiB0aGlzIEJpZyBoYXMgYSBwb3NpdGl2ZSBleHBvbmVudCBlcXVhbCB0byBvciBncmVhdGVyIHRoYW5cclxuICogQmlnLlBFLCBvciBhIG5lZ2F0aXZlIGV4cG9uZW50IGVxdWFsIHRvIG9yIGxlc3MgdGhhbiBCaWcuTkUuXHJcbiAqIE9taXQgdGhlIHNpZ24gZm9yIG5lZ2F0aXZlIHplcm8uXHJcbiAqL1xyXG5QLnRvU3RyaW5nID0gZnVuY3Rpb24gKCkge1xyXG4gIHJldHVybiBzdHJpbmdpZnkodGhpcyk7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgc3RyaW5nIHJlcHJlc2VudGluZyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcuXHJcbiAqIFJldHVybiBleHBvbmVudGlhbCBub3RhdGlvbiBpZiB0aGlzIEJpZyBoYXMgYSBwb3NpdGl2ZSBleHBvbmVudCBlcXVhbCB0byBvciBncmVhdGVyIHRoYW5cclxuICogQmlnLlBFLCBvciBhIG5lZ2F0aXZlIGV4cG9uZW50IGVxdWFsIHRvIG9yIGxlc3MgdGhhbiBCaWcuTkUuXHJcbiAqIEluY2x1ZGUgdGhlIHNpZ24gZm9yIG5lZ2F0aXZlIHplcm8uXHJcbiAqL1xyXG5QLnZhbHVlT2YgPSBQLnRvSlNPTiA9IGZ1bmN0aW9uICgpIHtcclxuICByZXR1cm4gc3RyaW5naWZ5KHRoaXMsIDQpO1xyXG59O1xyXG5cclxuXHJcbi8vIEV4cG9ydFxyXG5cclxuXHJcbmV4cG9ydCB2YXIgQmlnID0gX0JpZ18oKTtcclxuXHJcbmV4cG9ydCBkZWZhdWx0IEJpZztcclxuIiwiaW1wb3J0IEJpZyBmcm9tICdiaWcuanMnO1xuXG4vKipcbiAqIOWKoOazleWHveaVsFxuICogQHBhcmFtIHtudW1iZXJ8c3RyaW5nfSB4IC0g5Yqg5pWwXG4gKiBAcGFyYW0ge251bWJlcnxzdHJpbmd9IHkgLSDliqDmlbBcbiAqIEByZXR1cm5zIHtzdHJpbmd9IC0g6L+U5Zue55u45Yqg57uT5p6cXG4gKi9cbmZ1bmN0aW9uIGFkZCh4LCB5KSB7XG4gICAgcmV0dXJuIG5ldyBCaWcoeCkucGx1cyh5KS50b1N0cmluZygpO1xufVxuXG4vKipcbiAqIOWHj+azleWHveaVsFxuICogQHBhcmFtIHtudW1iZXJ8c3RyaW5nfSB4IC0g6KKr5YeP5pWwXG4gKiBAcGFyYW0ge251bWJlcnxzdHJpbmd9IHkgLSDlh4/mlbBcbiAqIEByZXR1cm5zIHtzdHJpbmd9IC0g6L+U5Zue55u45YeP57uT5p6cXG4gKi9cbmZ1bmN0aW9uIHN1YnRyYWN0KHgsIHkpIHtcbiAgICByZXR1cm4gbmV3IEJpZyh4KS5taW51cyh5KS50b1N0cmluZygpO1xufVxuXG4vKipcbiAqIOS5mOazleWHveaVsFxuICogQHBhcmFtIHtudW1iZXJ8c3RyaW5nfSB4IC0g5LmY5pWwXG4gKiBAcGFyYW0ge251bWJlcnxzdHJpbmd9IHkgLSDkuZjmlbBcbiAqIEByZXR1cm5zIHtzdHJpbmd9IC0g6L+U5Zue55u45LmY57uT5p6cXG4gKi9cbmZ1bmN0aW9uIG11bHRpcGx5KHgsIHkpIHtcbiAgICByZXR1cm4gbmV3IEJpZyh4KS50aW1lcyh5KS50b1N0cmluZygpO1xufVxuXG4vKipcbiAqIOmZpOazleWHveaVsFxuICogQHBhcmFtIHtudW1iZXJ8c3RyaW5nfSB4IC0g6KKr6Zmk5pWwXG4gKiBAcGFyYW0ge251bWJlcnxzdHJpbmd9IHkgLSDpmaTmlbBcbiAqIEByZXR1cm5zIHtzdHJpbmd9IC0g6L+U5Zue55u46Zmk57uT5p6cXG4gKi9cbmZ1bmN0aW9uIGRpdmlkZSh4LCB5KSB7XG4gICAgcmV0dXJuIG5ldyBCaWcoeCkuZGl2KHkpLnRvU3RyaW5nKCk7XG59XG5cbi8qKlxuICog5qC85byP5YyW5pWw5a2XXG4gKiBAcGFyYW0ge251bWJlcnxzdHJpbmd9IHZhbHVlIC0g5b6F5qC85byP5YyW55qE5pWw5a2XXG4gKiBAcGFyYW0ge251bWJlcn0gW3ByZWNpc2lvbl0gLSDnsr7luqbvvIzljbPlsI/mlbDkvY3mlbBcbiAqIEByZXR1cm5zIHtzdHJpbmd9IC0g5qC85byP5YyW5ZCO55qE5a2X56ym5LiyXG4gKi9cbmZ1bmN0aW9uIGZvcm1hdCh2YWx1ZSwgcHJlY2lzaW9uKSB7XG4gICAgY29uc3QgYmlnVmFsdWUgPSBuZXcgQmlnKHZhbHVlKTtcbiAgICBsZXQgc3RyaW5nVmFsdWUgPSBiaWdWYWx1ZS50b1N0cmluZygpO1xuICAgIC8v5YaZ6L+Z5LmI6bq754Om77yM5piv5Zug5Li6QmlnLnJvdW5k55u45YWz5pa55rOV5LiN5aW95L2/77yM5b6X5LiN5Yiw6aKE5pyf57uT5p6c44CCXG4gICAgaWYgKHN0cmluZ1ZhbHVlLmluY2x1ZGVzKCcuJykpIHtcbiAgICAgICAgbGV0IHN0ckFycmF5ID0gc3RyaW5nVmFsdWUuc3BsaXQoJy4nKTtcbiAgICAgICAgaWYgKHN0ckFycmF5WzFdLmxlbmd0aCA+PSBwcmVjaXNpb24pIHtcbiAgICAgICAgICAgIGlmICgwID09IHByZWNpc2lvbikge1xuICAgICAgICAgICAgICAgIHJldHVybiBzdHJBcnJheVswXTtcbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIGVsc2Uge1xuICAgICAgICAgICAgICAgIC8v5oiq5patXG4gICAgICAgICAgICAgICAgbGV0IHRydW5jYXRlID0gc3RyQXJyYXlbMV0uc3Vic3RyaW5nKDAsIHByZWNpc2lvbik7XG4gICAgICAgICAgICAgICAgcmV0dXJuIGAke3N0ckFycmF5WzBdfS4ke3RydW5jYXRlfWA7XG4gICAgICAgICAgICB9XG4gICAgICAgIH1cbiAgICAgICAgZWxzZSB7XG4gICAgICAgICAgICAvL+ihpembtlxuICAgICAgICAgICAgbGV0IHplcm9OdW1iZXIgPSBwcmVjaXNpb24gLSBzdHJBcnJheVsxXS5sZW5ndGg7XG4gICAgICAgICAgICB2YXIgc3RyID0gJyc7XG4gICAgICAgICAgICBmb3IgKGxldCBpID0gMDsgaSA8IHplcm9OdW1iZXI7IGkrKykge1xuICAgICAgICAgICAgICAgIHN0ciArPSAnMCc7XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICByZXR1cm4gYCR7c3RyaW5nVmFsdWV9JHtzdHJ9YDtcbiAgICAgICAgfVxuICAgIH1cbiAgICBlbHNlIHtcbiAgICAgICAgaWYgKDAgPT0gcHJlY2lzaW9uKSB7XG4gICAgICAgICAgICByZXR1cm4gc3RyaW5nVmFsdWU7XG4gICAgICAgIH1cbiAgICAgICAgZWxzZSB7XG4gICAgICAgICAgICBsZXQgemVyb051bWJlciA9IHByZWNpc2lvbjtcbiAgICAgICAgICAgIHZhciBzdHIgPSAnJztcbiAgICAgICAgICAgIGZvciAobGV0IGkgPSAwOyBpIDwgemVyb051bWJlcjsgaSsrKSB7XG4gICAgICAgICAgICAgICAgc3RyICs9ICcwJztcbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIHJldHVybiBgJHtzdHJpbmdWYWx1ZX0uJHtzdHJ9YDtcbiAgICAgICAgfVxuICAgIH1cbn1cblxuLyoqXG4gKiDlr7nmlbDnu4TkuK3nmoTmr4/kuKrlhYPntKDov5vooYznsr7noa7ov5Dnrpflubbov5Tlm57kuIDkuKrmlrDmlbDnu4RcbiAqIEBwYXJhbSB7QXJyYXk8bnVtYmVyfHN0cmluZz59IGFyciAtIOW+hei/kOeul+aVsOe7hFxuICogQHJldHVybnMge0FycmF5PHN0cmluZz59IC0g6L+U5Zue6L+Q566X57uT5p6c5pWw57uEXG4gKi9cbmZ1bmN0aW9uIGJpZ251bWJlcihhcnIpIHtcbiAgICBpZiAoQXJyYXkuaXNBcnJheShhcnIpKSB7XG4gICAgICAgIHJldHVybiBhcnIubWFwKCh2YWx1ZSkgPT4gQmlnKHZhbHVlKS50b0ZpeGVkKCkpO1xuICAgIH0gZWxzZSB7XG4gICAgICAgIHJldHVybiBCaWcoYXJyKS50b0ZpeGVkKCk7XG4gICAgfVxufVxuXG5leHBvcnQgeyBhZGQsIHN1YnRyYWN0LCBtdWx0aXBseSwgZGl2aWRlLCBmb3JtYXQsIGJpZ251bWJlciB9O1xuIiwiaW1wb3J0ICogYXMgbnVtYmVyIGZyb20gXCIuL251bWJlclwiO1xuaW1wb3J0IEJpZyBmcm9tICdiaWcuanMnO1xuXG52YXIgY2xpY2thYmxlID0gdHJ1ZTtcblxuZXhwb3J0IGZ1bmN0aW9uIG1vZHVsZURlZmluZShtb2R1bGVOYW1lLCBkZWZhdWx0RGF0YUZ1bmN0aW9uLCBmdW5jdGlvbnMgPSB7IG9uQ3JlYXRlLCBvbkRlc3Ryb3ksIG9uUmVzdW1lLCBvblBhdXNlLCBvblN0YXJ0LCBvblN0b3AgfSkge1xuICAgIGNvbnNvbGUubG9nKGBsb2FkTW9kdWxlYCwgbW9kdWxlTmFtZSk7XG4gICAgJGRhdGFbbW9kdWxlTmFtZV0gPSBkZWZhdWx0RGF0YUZ1bmN0aW9uKCk7XG4gICAgJGV2ZW50W21vZHVsZU5hbWVdID0ge1xuICAgICAgICBvbkNyZWF0ZTogdHlwZW9mIGZ1bmN0aW9ucy5vbkNyZWF0ZSA9PSAndW5kZWZpbmVkJyA/IG9uQ3JlYXRlIDogZnVuY3Rpb25zLm9uQ3JlYXRlLFxuICAgICAgICBvbkRlc3Ryb3k6IHR5cGVvZiBmdW5jdGlvbnMub25EZXN0cm95ID09ICd1bmRlZmluZWQnID8gb25EZXN0cm95IDogZnVuY3Rpb25zLm9uRGVzdHJveSxcbiAgICAgICAgb25SZXN1bWU6IHR5cGVvZiBmdW5jdGlvbnMub25SZXN1bWUgPT0gJ3VuZGVmaW5lZCcgPyBvblJlc3VtZSA6IGZ1bmN0aW9ucy5vblJlc3VtZSxcbiAgICAgICAgb25QYXVzZTogdHlwZW9mIGZ1bmN0aW9ucy5vblBhdXNlID09ICd1bmRlZmluZWQnID8gb25QYXVzZSA6IGZ1bmN0aW9ucy5vblBhdXNlLFxuICAgICAgICBvblN0YXJ0OiB0eXBlb2YgZnVuY3Rpb25zLm9uU3RhcnQgPT0gJ3VuZGVmaW5lZCcgPyBvblN0YXJ0IDogZnVuY3Rpb25zLm9uU3RhcnQsXG4gICAgICAgIG9uU3RvcDogdHlwZW9mIGZ1bmN0aW9ucy5vblN0b3AgPT0gJ3VuZGVmaW5lZCcgPyBvblN0b3AgOiBmdW5jdGlvbnMub25TdG9wLFxuICAgIH07XG4gICAgcmV0dXJuIHtcbiAgICAgICAgbW9kdWxlRGF0YTogJGRhdGFbbW9kdWxlTmFtZV0sXG4gICAgICAgIG1vZHVsZUV2ZW50OiAkZXZlbnRbbW9kdWxlTmFtZV1cbiAgICB9O1xufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gYW5hbHl0aWNzKGV2ZW50ID0gXCJcIiwgcHJvcGVydGllcyA9IHt9KSB7XG4gICAgY29uc3QgcHJvcGVydGllc0pzb24gPSBKU09OLnN0cmluZ2lmeShwcm9wZXJ0aWVzKTtcbiAgICBjb25zb2xlLmxvZyhgYW5hbHl0aWNzIGV2ZW50OiAke2V2ZW50fSwgcHJvcGVydGllc0pzb24gPSAke3Byb3BlcnRpZXNKc29ufWApO1xuICAgIHZhciBtYXAgPSB7XG4gICAgICAgIGV2ZW50OiBldmVudCxcbiAgICAgICAgcHJvcGVydGllczogcHJvcGVydGllc0pzb25cbiAgICB9O1xuICAgIGF3YWl0ICRuYXRpdmVBUEkuYW5hbHl0aWNzKG1hcCk7XG59XG5cbmZ1bmN0aW9uIG9uQ3JlYXRlKCkge1xuICAgIGNvbnNvbGUubG9nKCdjb21tb24gb25DcmVhdGUnKTtcbn1cblxuZnVuY3Rpb24gb25EZXN0cm95KCkge1xufVxuXG5mdW5jdGlvbiBvblJlc3VtZSgpIHtcbn1cblxuZnVuY3Rpb24gb25QYXVzZSgpIHtcbn1cblxuZnVuY3Rpb24gb25TdGFydCgpIHtcbn1cblxuZnVuY3Rpb24gb25TdG9wKCkge1xufVxuXG5leHBvcnQgdmFyIGNvbW1vbkRhdGEgPSB7XG4gICAgcHJpY2VDb2xvclR5cGU6IDAsIC8vLzDvvJrnuqLmtqjnu7/ot4wgICAx77ya57u/5rao57qi6LeMXG4gICAgY29sb3JNb2RlOiAwLCAvLy8w77ya55m95aSpICAgMe+8mum7keWknFxuICAgIE9TOiAwLCAvLzDvvJppT1MgIDHvvJrlronljZNcbiAgICBhcHBWZXJzaW9uOiBcIlwiLCAvL2FwcOeJiOacrOWPt1xuICAgIGlzSW5SZXZpZXc6IDEsXG4gICAgaDVVcmw6IFwiXCIsIC8vLyBoNeWKqOaAgeWfn+WQjVxuICAgIGxhbmd1YWdlOiBcIlwiLCAvLy8g6K+t6KiA56eN57G7XG4gICAgc3RhdHVzSGVpZ2h0OiAwLFxuICAgIHZUb2tlbjogXCJcIiwgLy8g5paw6K6+5aSH5oyH57q5XG4gICAgb2xkVlRva2VuOiBcIlwiLCAvLyDml6forr7lpIfmjIfnurks5Y+C6ICD5Y6f5p2lXCJmcFwiXG59O1xuJGRhdGEuY29tbW9uRGF0YSA9IGNvbW1vbkRhdGE7XG5cbi8vIC8v5omT5byAVVJMXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gb3BlblVSTCh1cmwpIHtcbiAgICBpZiAoIWNsaWNrYWJsZSkge1xuICAgICAgICByZXR1cm47XG4gICAgfVxuICAgIGNvbnNvbGUubG9nKGBvcGVuIHVybDpgLCB1cmwpO1xuICAgIGlmICh1cmwgJiYgdXJsICE9IG51bGwgJiYgdXJsLmxlbmd0aCA+IDApIHtcbiAgICAgICAgYXdhaXQgJG5hdGl2ZUFQSS5vcGVuUm91dGUodXJsKTtcbiAgICB9XG4gICAgY2xpY2thYmxlID0gZmFsc2U7XG4gICAgc2V0VGltZW91dCgoKSA9PiB7XG4gICAgICAgIGNsaWNrYWJsZSA9IHRydWU7XG4gICAgfSwgMTAwMCk7XG59XG5cbi8v6K6+572u6YCa55So6YWN572uXG5leHBvcnQgZnVuY3Rpb24gZ2V0Q29tbW9uQ29uZmlnKHBhcmFtKSB7XG4gICAgY29uc29sZS5sb2cocGFyYW0pO1xuICAgIGNvbW1vbkRhdGEucHJpY2VDb2xvclR5cGUgPSBwYXJzZUludChwYXJhbS5wcmljZUNvbG9yVHlwZSk7XG4gICAgY29tbW9uRGF0YS5jb2xvck1vZGUgPSBwYXJzZUludChwYXJhbS5jb2xvck1vZGUpO1xuICAgIGNvbW1vbkRhdGEuT1MgPSBwYXJzZUludChwYXJhbS5PUyk7XG4gICAgY29tbW9uRGF0YS5hcHBWZXJzaW9uID0gcGFyYW0uYXBwVmVyc2lvbjtcbiAgICBjb21tb25EYXRhLmlzSW5SZXZpZXcgPSBwYXJzZUludChwYXJhbS5pc0luUmV2aWV3KTtcbiAgICBjb21tb25EYXRhLmxhbmd1YWdlID0gcGFyYW0ubGFuZ3VhZ2U7XG4gICAgY29tbW9uRGF0YS5oNVVybCA9IHBhcmFtLmg1VXJsO1xuICAgIGNvbW1vbkRhdGEuc3RhdHVzSGVpZ2h0ID0gcGFyYW0uc3RhdHVzSGVpZ2h0O1xuICAgIGNvbW1vbkRhdGEudlRva2VuID0gcGFyYW0udlRva2VuO1xuICAgIGNvbW1vbkRhdGEub2xkVlRva2VuID0gcGFyYW0ub2xkVlRva2VuO1xuXG4gICAgJGRhdGEuY29tbW9uRGF0YSA9IGNvbW1vbkRhdGE7XG4gICAgJGRhdGEuZGVwb3NpdC5zdGF0dXNIZWlnaHQgPSBjb21tb25EYXRhLnN0YXR1c0hlaWdodDtcbiAgICAkZGF0YS5kZXRhaWwuc3RhdHVzSGVpZ2h0ID0gY29tbW9uRGF0YS5zdGF0dXNIZWlnaHQ7XG59XG5cblxuLy/lj5HpgIHor7fmsYJcbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBzZW5kUmVxdWVzdChwYXRoLCBwYXJhbXMgPSB7fSwgbWV0aG9kID0gMCwgaG9zdFR5cGUgPSAwLCBoZWFkZXIgPSB7fSkge1xuICAgIGNvbnNvbGUubG9nKGByZXF1ZXN0ICR7cGF0aH0sIHBhcmFtczoke0pTT04uc3RyaW5naWZ5KHBhcmFtcyl9YCk7XG5cbiAgICBpZiAoaG9zdFR5cGUgPT0gNSB8fCBob3N0VHlwZSA9PSA2KSB7XG4gICAgICAgIGhlYWRlcltcIkNvbnRlbnQtVHlwZVwiXSA9IFwiYXBwbGljYXRpb24vanNvblwiO1xuICAgIH1cblxuICAgIGNvbnN0IHBhcmFtID0ge1xuICAgICAgICBwYXRoLFxuICAgICAgICBtZXRob2QsXG4gICAgICAgIGhvc3RUeXBlLFxuICAgICAgICBoZWFkZXIsXG4gICAgICAgIHBhcmFtcyxcbiAgICB9O1xuICAgIHRyeSB7XG4gICAgICAgIHZhciByZXNwb25zZVN0cmluZyA9IGF3YWl0ICRuYXRpdmVBUEkucmVxdWVzdChKU09OLnN0cmluZ2lmeShwYXJhbSkpO1xuICAgICAgICB2YXIgcmVzcG9uc2UgPSBKU09OLnBhcnNlKHJlc3BvbnNlU3RyaW5nKTtcbiAgICAgICAgdmFyIHsgY29kZSwgZGF0YSB9ID0gcmVzcG9uc2U7XG4gICAgICAgIGlmICg4ID09IGhvc3RUeXBlKSB7XG4gICAgICAgICAgICAvL+WQiOe6pueahOaOpeWPo+WkhOeQhlxuICAgICAgICAgICAgdmFyIHN0YXR1cyA9IHJlc3BvbnNlLnN0YXR1cztcbiAgICAgICAgICAgIHZhciBlcnJfY29kZSA9IHJlc3BvbnNlLmVycl9jb2RlO1xuICAgICAgICAgICAgdmFyIGVycl9tc2cgPSByZXNwb25zZS5lcnJfbXNnO1xuICAgICAgICAgICAgaWYgKHN0YXR1cyA9PSBcIm9rXCIpIHtcbiAgICAgICAgICAgICAgICBjb25zb2xlLmxvZyhgcmVxdWVzdCAke3BhdGh9IGRvbmVgKTtcbiAgICAgICAgICAgICAgICBpZiAodHlwZW9mIGRhdGEgPT09ICdudW1iZXInKSB7XG4gICAgICAgICAgICAgICAgICAgIGxldCBzdGFydCA9IGBcImRhdGFcIjpgO1xuICAgICAgICAgICAgICAgICAgICBsZXQgc3RhcnRJbmRleCA9IHJlc3BvbnNlU3RyaW5nLmluZGV4T2Yoc3RhcnQpO1xuICAgICAgICAgICAgICAgICAgICBsZXQgZW5kID0gYCxcInRzXCI6YDtcbiAgICAgICAgICAgICAgICAgICAgbGV0IGVuZEluZGV4ID0gcmVzcG9uc2VTdHJpbmcuaW5kZXhPZihlbmQpO1xuICAgICAgICAgICAgICAgICAgICBsZXQgZGF0YVN0cmluZyA9IHJlc3BvbnNlU3RyaW5nLnN1YnN0cmluZyhzdGFydEluZGV4ICsgc3RhcnQubGVuZ3RoLCBlbmRJbmRleCk7XG4gICAgICAgICAgICAgICAgICAgIGNvbnNvbGUubG9nKGBkYXRhIGlzIHR5cGVvZiBudW1iZXIsIGRhdGFTdHJpbmcgPSAke2RhdGFTdHJpbmd9YCk7XG4gICAgICAgICAgICAgICAgICAgIHJldHVybiBkYXRhU3RyaW5nO1xuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgICAgICByZXR1cm4gZGF0YTtcbiAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICAgY29uc29sZS5sb2coYHJlcXVlc3QgZmFpbGVkLCBjb2RlPSR7ZXJyX2NvZGV9LCBtZXNzYWdlPSR7ZXJyX21zZ31gKTtcbiAgICAgICAgICAgICAgICBpZiAobWV0aG9kICE9IDApIHtcbiAgICAgICAgICAgICAgICAgICAgc2hvd1RvYXN0KGVycl9tc2cpO1xuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgICAgICByZXR1cm4gbnVsbDtcbiAgICAgICAgICAgIH1cbiAgICAgICAgfSBlbHNlIGlmIChjb2RlID09IDIwMCkge1xuICAgICAgICAgICAgY29uc29sZS5sb2coYHJlcXVlc3QgJHtwYXRofSBkb25lYCk7XG4gICAgICAgICAgICByZXR1cm4gZGF0YTtcbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIGNvbnNvbGUubG9nKGByZXF1ZXN0IGZhaWxlZCwgY29kZT0ke2NvZGV9YCk7XG4gICAgICAgICAgICBsZXQgbWVzc2FnZSA9IHJlc3BvbnNlLm1lc3NhZ2U7XG4gICAgICAgICAgICBpZiAobWV0aG9kICE9IDAgJiYgbWVzc2FnZSkge1xuICAgICAgICAgICAgICAgIHNob3dUb2FzdChtZXNzYWdlKTtcbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIHJldHVybiBudWxsO1xuICAgICAgICB9XG4gICAgfSBjYXRjaCAoZSkge1xuICAgICAgICBjb25zb2xlLmxvZyhgcmVxdWVzdCBlcnJvciwgZXJyb3I9JHtlfWApO1xuICAgICAgICByZXR1cm4gbnVsbDtcbiAgICB9XG59XG5cbi8vdG9hc3RcbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBzaG93VG9hc3QobXNnKSB7XG4gICAgYXdhaXQgJG5hdGl2ZUFQSS5oYlRvYXN0KG1zZyk7XG59XG5cbi8qKlxuICogXG4gKiBAcGFyYW0ge2Jvb2xlYW59IGlzU2hvdyDmmK/lkKbmmL7npLrliqDovb3moYZcbiAqL1xuZXhwb3J0IGZ1bmN0aW9uIHNob3dMb2FkaW5nKGlzU2hvdyA9IHRydWUpIHtcbiAgICAkbmF0aXZlQVBJLnNob3dMb2FkaW5nKGlzU2hvdyA/IDEgOiAwKTtcbn1cblxuLyoqXG4gKiBcbiAqIEBwYXJhbSB75pe26Ze05pel5pyf5qC85byP5YyWfSBmbXQgeXl5eS1NTS1kZCBoaDptbTpzc1xuICogQHJldHVybnMg5qC85byP5YyW5LmL5ZCO55qEIOWtl+espuS4su+8jOeUqOazleS+i+WmgiBuZXcgRGF0ZSjml7bpl7TmiLMpLkZvcm1hdChcInl5eXktTU0tZGQgaGg6bW06c3NcIilcbiAqL1xuRGF0ZS5wcm90b3R5cGUuRm9ybWF0ID0gZnVuY3Rpb24gKGZtdCkge1xuICAgIHZhciBvID0ge1xuICAgICAgICBcIk0rXCI6IHRoaXMuZ2V0TW9udGgoKSArIDEsIC8v5pyI5Lu9IFxuICAgICAgICBcImQrXCI6IHRoaXMuZ2V0RGF0ZSgpLCAvL+aXpSBcbiAgICAgICAgXCJoK1wiOiB0aGlzLmdldEhvdXJzKCksIC8v5bCP5pe2IFxuICAgICAgICBcIm0rXCI6IHRoaXMuZ2V0TWludXRlcygpLCAvL+WIhiBcbiAgICAgICAgXCJzK1wiOiB0aGlzLmdldFNlY29uZHMoKSwgLy/np5IgXG4gICAgICAgIFwicStcIjogTWF0aC5mbG9vcigodGhpcy5nZXRNb250aCgpICsgMykgLyAzKSwgLy/lraPluqYgXG4gICAgICAgIFwiU1wiOiB0aGlzLmdldE1pbGxpc2Vjb25kcygpIC8v5q+r56eSIFxuICAgIH07XG4gICAgaWYgKC8oeSspLy50ZXN0KGZtdCkpIGZtdCA9IGZtdC5yZXBsYWNlKFJlZ0V4cC4kMSwgKHRoaXMuZ2V0RnVsbFllYXIoKSArIFwiXCIpLnN1YnN0cig0IC0gUmVnRXhwLiQxLmxlbmd0aCkpO1xuICAgIGZvciAodmFyIGsgaW4gbylcbiAgICAgICAgaWYgKG5ldyBSZWdFeHAoXCIoXCIgKyBrICsgXCIpXCIpLnRlc3QoZm10KSkgZm10ID0gZm10LnJlcGxhY2UoUmVnRXhwLiQxLCAoUmVnRXhwLiQxLmxlbmd0aCA9PSAxKSA/IChvW2tdKSA6ICgoXCIwMFwiICsgb1trXSkuc3Vic3RyKChcIlwiICsgb1trXSkubGVuZ3RoKSkpO1xuICAgIHJldHVybiBmbXQ7XG59XG5cbi8v6L+b6KGM57K+5bqm5aSE55CGXG5leHBvcnQgZnVuY3Rpb24gZm9ybWF0UHJlY2lzaW9uKHZhbHVlLCBwcmVjaXNpb24pIHtcbiAgICB0cnkge1xuICAgICAgICBjb25zdCByZXN1bHQgPSBudW1iZXIuZm9ybWF0KHZhbHVlLCBwcmVjaXNpb24pO1xuICAgICAgICByZXR1cm4gcmVzdWx0O1xuICAgIH0gY2F0Y2ggKGUpIHtcbiAgICAgICAgY29uc29sZS5sb2coZSk7XG4gICAgICAgIHJldHVybiB2YWx1ZS50b0ZpeGVkKHByZWNpc2lvbik7XG4gICAgfVxufVxuXG4vL+WuueWZqOi/lOWbnuiDveWKm1xuZXhwb3J0IGZ1bmN0aW9uIGNvbnRhaW5lckJhY2soKSB7XG4gICAgY29uc29sZS5sb2coXCJjb250YWluZXJCYWNrXCIpXG4gICAgJG5hdGl2ZUFQSS5jb250YWluZXJCYWNrKClcbn1cblxuLy/ojrflj5bku7fmoLzmmL7npLrmlofmnKxcbmV4cG9ydCBmdW5jdGlvbiBnZXRQcmljZVN0cmluZyhwcmljZVN0ciwgcHJlY2lzaW9uKSB7XG4gICAgY29uc3QgcHJpY2VOdW0gPSBOdW1iZXIocHJpY2VTdHIpO1xuICAgIGNvbnN0IGJpZ1ZhbHVlID0gbmV3IEJpZyhwcmljZU51bSk7XG4gICAgY29uc3QgcHJpY2VTdHJpbmcgPSBwcmVjaXNpb24gPT0gLTEgPyBiaWdWYWx1ZS50b1N0cmluZygpIDogYmlnVmFsdWUudG9GaXhlZChwcmVjaXNpb24pO1xuICAgIGNvbnN0IGZpbmFsUHJpY2VTdHIgPSBwcmljZVN0cmluZy5yZXBsYWNlKC9cXGQrLywgZnVuY3Rpb24obil7IC8vIOWFiOaPkOWPluaVtOaVsOmDqOWIhlxuICAgICAgICByZXR1cm4gbi5yZXBsYWNlKC8oXFxkKSg/PShcXGR7M30pKyQpL2csZnVuY3Rpb24oJDEpe1xuICAgICAgICAgICByZXR1cm4gJDErXCIsXCI7XG4gICAgICAgICB9KTtcbiAgIH0pXG4gICAgLy8gY29uc3QgZmluYWxQcmljZVN0ciA9IHByaWNlU3RyaW5nLnRvU3RyaW5nKCkucmVwbGFjZSgvXFxCKD89KFxcZHszfSkrKD8hXFxkKSkvZywgXCIsXCIpO1xuICAgIHJldHVybiBmaW5hbFByaWNlU3RyO1xufVxuXG4vLyDmtqjot4zoibIgaXNSaXNlIO+8miB0cnVlIG9yIGZhbHNlXG5leHBvcnQgZnVuY3Rpb24gZ2V0UHJpY2VDb2xvcihpc1Jpc2UpIHtcbiAgICBpZiAoaXNSaXNlKSB7XG4gICAgICAgIHJldHVybiBjb21tb25EYXRhLnByaWNlQ29sb3JUeXBlID09IDEgPyBcIiMwMEExNzFcIiA6IFwiI0U5NDM1OVwiO1xuICAgIH0gZWxzZSB7XG4gICAgICAgIHJldHVybiBjb21tb25EYXRhLnByaWNlQ29sb3JUeXBlID09IDAgPyBcIiMwMEExNzFcIiA6IFwiI0U5NDM1OVwiO1xuICAgIH1cbn1cbiIsImltcG9ydCAqIGFzIGNvbW1vbiBmcm9tIFwiLi9jb21tb25cIlxuXG4kZGF0YS5hbGVydCA9IHtcbiAgICBjb250ZW50OiBcIlwiLFxuICAgIHRpdGxlOiAkaTE4bi5uX2NvcHlfdHJhZGluZ190aXAsXG4gICAgYWxlcnRQb3BTaG93OiBcImZhbHNlXCIsXG4gICAgcHJpY2VUaXBzOiBcIlwiLCAvL+e7k+eul+S7t+aPkOekulxufVxuXG4kZXZlbnQuYWxlcnQgPSB7XG4gICAgc2hvd0xpbWl0QWxlcnQoKSB7XG4gICAgICAgICRldmVudC5kZXBvc2l0LmNsb3NlS2V5Qm9hcmQoKTtcbiAgICAgICAgJGRhdGEuYWxlcnQuY29udGVudCA9ICRkYXRhLmRlcG9zaXQudXNlclN1cnBsdXNBbGVydDtcbiAgICAgICAgJGRhdGEuYWxlcnQuYWxlcnRQb3BTaG93ID0gXCJ0cnVlXCI7XG4gICAgfSxcbiAgICBzaG93U2V0dGxlbWVudEFsZXJ0KCkge1xuICAgICAgICAkZXZlbnQuZGVwb3NpdC5jbG9zZUtleUJvYXJkKCk7XG4gICAgICAgICRkYXRhLmFsZXJ0LmNvbnRlbnQgPSAkZGF0YS5hbGVydC5wcmljZVRpcHM7XG4gICAgICAgICRkYXRhLmFsZXJ0LmFsZXJ0UG9wU2hvdyA9IFwidHJ1ZVwiO1xuICAgICAgICBjb21tb24uYW5hbHl0aWNzKFwiYXBwX2Vhcm5fc2hha2VGaW5fb3JkZXJEZXRhaWxfcHJpY2VBdEV4cGlyYXRpb25FeHBsYW5hdGlvbl9jbGlja1wiKTtcbiAgICB9LFxuICAgIHNob3dBdXRvU3Vic2NyaWJlQWxlcnQoKSB7XG4gICAgICAkZXZlbnQuZGVwb3NpdC5jbG9zZUtleUJvYXJkKCk7XG4gICAgICAkZGF0YS5hbGVydC50aXRsZSA9ICRpMThuLm5fc2hhcmtfZmluX2F1dG9TdWJzY3JpYmVfdGl0bGU7XG4gICAgICAkZGF0YS5hbGVydC5jb250ZW50ID0gYCR7JGkxOG4ubl9zaGFya19maW5fYXV0b1N1YnNjcmliZV9jb250ZW50XzF9XFxuJHskaTE4bi5uX3NoYXJrX2Zpbl9hdXRvU3Vic2NyaWJlX2NvbnRlbnRfMn1gO1xuICAgICAgJGRhdGEuYWxlcnQuYWxlcnRQb3BTaG93ID0gXCJ0cnVlXCI7XG4gIH0sXG4gICAgY29uZmlybSgpIHtcbiAgICAgICAgJGRhdGEuYWxlcnQuYWxlcnRQb3BTaG93ID0gXCJmYWxzZVwiO1xuICAgICAgICAkZGF0YS5hbGVydC50aXRsZSA9ICRpMThuLm5fY29weV90cmFkaW5nX3RpcDtcbiAgICB9LFxufSIsImltcG9ydCAqIGFzIGNvbW1vbiBmcm9tIFwiLi9jb21tb25cIlxuaW1wb3J0ICogYXMgbnVtYmVyIGZyb20gXCIuL251bWJlclwiO1xuXG52YXIgcHJvamVjdElkID0gMDtcbnZhciBvcmRlcklkID0gMDsgLy8g55Sz6LSt5oiQ5Yqf5ZCO55qE6K6i5Y2VSWRcbnZhciBuZWVkUmVmcmVzaCA9IGZhbHNlO1xudmFyIHNUaW1lID0gMDsgLy8g5b2T5YmN5pyN5Yqh5Zmo5pe26Ze0XG52YXIgc3lzVGltZSA9IDA7IC8vIOi3n+acjeWKoeWZqOaXtumXtOWvueW6lOeahOezu+e7n+aXtumXtFxudmFyIHN0YXJ0VGltZSA9IDA7IC8vIOW8gOWni+aXtumXtFxudmFyIGludGVyY2FsID0gbnVsbDtcbmNvbnN0IG1tID0gNjA7XG5jb25zdCBoaCA9IDM2MDA7XG5jb25zdCBkZCA9IDg2NDAwO1xudmFyIGF1dG9TdWJzY3JpYmUgPSAwO1xuXG5mdW5jdGlvbiBkZWZhdWx0RGF0YSgpIHtcbiAgICByZXR1cm4ge1xuICAgICAgICBkYXRhbGlzdDogW10sXG4gICAgICAgIGlucHV0RGF0YToge30sXG4gICAgICAgIGNvbmZpcm1TaG93OiBcImZhbHNlXCIsXG4gICAgICAgIHN1Y2Nlc3NTaG93OiBcImdvbmVcIixcbiAgICAgICAgY29uZmlybWxpc3Q6IFtdLFxuICAgICAgICB1c2VyU3VycGx1c0FsZXJ0OiBcIlwiLFxuICAgICAgICBvbkZvY3VzOiBcImZhbHNlXCIsXG4gICAgICAgIG9uRm9jdXNJbnRlcm5hbDogXCJmYWxzZVwiLFxuICAgICAgICBlZGl0VGV4dDogXCJcIixcbiAgICAgICAgaW5wdXRUZXh0OiBcIlwiLFxuICAgICAgICBiYWxhbmNlQW1vdW50OiAwLCAvL+S4quS6uuS9meminVxuICAgICAgICB1c2VyTG93ZXJMaW1pdDogMCwgLy8g6LW35oqVXG4gICAgICAgIHVzZXJTdXJwbHVzQW1vdW50OiAwLCAvLyDkuKrkurrliankvZnpop3luqZcbiAgICAgICAgc3VycGx1c0Ftb3VudDogMCwgLy8g6aG555uu5Ymp5L2Z6aKd5bqmXG4gICAgICAgIGNvaW46IFwiXCIsXG4gICAgICAgIHVuaXQ6IFwiXCIsXG4gICAgICAgIGJ1dHRvbkVuYWJsZWQ6IGZhbHNlLFxuICAgICAgICBidG5Db2xvcjogXCJAY29sb3IvZUJ1dHRvblVuZW5hYmxlZEJnQ29sb3JcIixcbiAgICAgICAgY29uZmlybUJ0bkNvbG9yOiBcIkBjb2xvci9lQnV0dG9uVW5lbmFibGVkQmdDb2xvclwiLFxuICAgICAgICBodW9iaVNlbGVjdGVkOiBmYWxzZSxcbiAgICAgICAgaHVvYmlBZ3JlZUltYWdlOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9saXZlX3JlZHBhY2tldF91bnNlbGVjdFwiLFxuICAgICAgICBzdGF0dXNIZWlnaHQ6IDIwLFxuICAgICAgICBuYXZUaXRsZTogXCJcIixcbiAgICAgICAgaWQ6IFwiXCIsIC8vIOmhueebrmlkXG4gICAgICAgIHN1Y2Nlc3NUZXh0OiBcIlwiLCAvLyDnlLPotK3miJDlip9cbiAgICAgICAgZW1wdHk6IFwiZ29uZVwiLFxuICAgICAgICBub3RFbXB0eTogXCJnb25lXCIsXG4gICAgICAgIHNob3dJbnB1dDogXCJnb25lXCIsXG4gICAgICAgIGJ0blRpdGxlOiBcIlwiLFxuICAgICAgICBuZWVkQ291bnREb3duOiBcImdvbmVcIixcbiAgICAgICAgYm9yZGVyQ29sb3I6IFwiQGNvbG9yL2Jhc2VDb2xvcklucHV0QmFja2dyb3VuZFwiLFxuICAgICAgICBzd2l0Y2hDb2xvcjogXCJAY29sb3IvS0Jhc2VDb2xvckNvbnRlbnRCYWNrZ3JvdW5kXCIsXG4gICAgICAgIHN3aXRjaEJhY2tDb2xvcjogXCJAY29sb3IvZUJ1dHRvblVuZW5hYmxlZEJnQ29sb3JcIixcbiAgICAgICAgc3dpdGNoV2lkdGg6IFwiMlwiLFxuICAgIH07XG59XG5cbmZ1bmN0aW9uIG9uQ3JlYXRlKGV2ZW50UGFyYW1zKSB7XG4gICAgcmVsb2FkRGF0YSgpO1xuICAgIGJ1dHRvbkNoYW5nZVN0YXR1cygpO1xuICAgIG1vZHVsZURhdGEuc3RhdHVzQmFyQ29uZmlnID0geyBcInN0YXR1c0Jhck1vZGVcIjogXCJmYWxzZVwiIH07XG4gICAgaWYgKCFldmVudFBhcmFtcyB8fCBldmVudFBhcmFtcyA9PSBudWxsKSB7XG4gICAgICAgIHNob3dEZXRhaWxFbXB0eSh0cnVlKTtcbiAgICAgICAgcmV0dXJuO1xuICAgIH1cbiAgICBjb25zdCBwYXJhbXMgPSBKU09OLnBhcnNlKGV2ZW50UGFyYW1zKTtcbiAgICBwcm9qZWN0SWQgPSBwYXJhbXMucHJvamVjdElkO1xuICAgIHJlcXVlc3RCdXlEZXRhaWwocHJvamVjdElkKTtcbn1cblxuZnVuY3Rpb24gb25EZXN0cm95KCkge1xuICAgIGNsZWFyVGltZXIoKTtcbiAgICByZWxvYWREYXRhKCk7XG59XG5cbmZ1bmN0aW9uIG9uUmVzdW1lKCkge1xuICAgIGlmIChuZWVkUmVmcmVzaCkge1xuICAgICAgICBuZWVkUmVmcmVzaCA9IGZhbHNlO1xuICAgICAgICByZXF1ZXN0QnV5RGV0YWlsKHByb2plY3RJZCk7XG4gICAgfSBlbHNlIHtcbiAgICAgICAgc3RhcnRUaW1lcigpO1xuICAgIH1cbn1cblxuZnVuY3Rpb24gb25QYXVzZSgpIHtcbiAgICBjbGVhclRpbWVyKCk7XG59XG5cbmNvbnN0IHsgbW9kdWxlRGF0YSwgbW9kdWxlRXZlbnQgfSA9IGNvbW1vbi5tb2R1bGVEZWZpbmUoXCJkZXBvc2l0XCIsIGRlZmF1bHREYXRhLCB7IG9uQ3JlYXRlLCBvbkRlc3Ryb3ksIG9uUmVzdW1lLCBvblBhdXNlLG9uU3RhcnQgfSk7XG5cbi8vIGh0dHBzOi8veWFwaS5odW9iaWFwcHMuY29tL3Byb2plY3QvMTY4NS9pbnRlcmZhY2UvYXBpLzkwMDQ4XG5hc3luYyBmdW5jdGlvbiByZXF1ZXN0QnV5RGV0YWlsKHByb2plY3RJZCkge1xuICAgIC8vIHByb2plY3RJZCA9IDIxNjsgLy8gMTMxIDog55yL6LeM77yMMTMy77ya55yL5raoXG4gICAgY29tbW9uLnNob3dMb2FkaW5nKHRydWUpO1xuICAgIGNvbnN0IGRhdGEgPSBhd2FpdCBjb21tb24uc2VuZFJlcXVlc3QoXCJ2NC9zYXZpbmcvbWluaW5nL3NoYXJrL3Byb2plY3QvYnV5L2RldGFpbFwiLCB7IHByb2plY3RJZCB9KTtcbiAgICBjb21tb24uc2hvd0xvYWRpbmcoZmFsc2UpO1xuICAgIGlmICghZGF0YSB8fCBkYXRhID09IG51bGwpIHtcbiAgICAgICAgc2hvd0RldGFpbEVtcHR5KHRydWUpO1xuICAgICAgICByZXR1cm47XG4gICAgfVxuICAgIHNob3dEZXRhaWxFbXB0eShmYWxzZSk7XG4gICAgaGFuZGxlRGV0YWlsRGF0YShkYXRhKTtcbn1cblxuZnVuY3Rpb24gaGFuZGxlRGV0YWlsRGF0YShkYXRhKSB7XG4gICAgc1RpbWUgPSBkYXRhLnNUaW1lOyAvLyDlvZPliY3mnI3liqHlmajml7bpl7RcbiAgICBzeXNUaW1lID0gbmV3IERhdGUoKS5nZXRUaW1lKCk7IC8vIOW9k+WJjeaXtumXtFxuICAgIGNvbnN0IHByb2plY3REZXRhaWwgPSBkYXRhLnByb2plY3REZXRhaWw7XG4gICAgaWYgKHByb2plY3REZXRhaWwgJiYgcHJvamVjdERldGFpbCAhPSBudWxsKSB7XG4gICAgICAgIG1vZHVsZURhdGEuaWQgPSBwcm9qZWN0RGV0YWlsLmlkO1xuICAgICAgICBtb2R1bGVEYXRhLmNvaW4gPSBwcm9qZWN0RGV0YWlsLmN1cnJlbmN5O1xuICAgICAgICBtb2R1bGVEYXRhLnVuaXQgPSBwcm9qZWN0RGV0YWlsLnF1b3RlQ3VycmVuY3k7XG4gICAgICAgIGNvbnN0IG1pblJhdGUgPSBjb21tb24uZm9ybWF0UHJlY2lzaW9uKG51bWJlci5tdWx0aXBseShwcm9qZWN0RGV0YWlsLm1pblJhdGUsIFwiMTAwXCIpLCAyKTtcbiAgICAgICAgY29uc3QgbWF4UmF0ZSA9IGNvbW1vbi5mb3JtYXRQcmVjaXNpb24obnVtYmVyLm11bHRpcGx5KHByb2plY3REZXRhaWwubWF4UmF0ZSwgXCIxMDBcIiksIDIpO1xuICAgICAgICBjb25zdCBleHBpcnlUaW1lID0gbmV3IERhdGUocHJvamVjdERldGFpbC5leHBpcnlUaW1lKS5Gb3JtYXQoXCJ5eXl5L01NL2RkXCIpO1xuICAgICAgICBjb25zdCBjYWxsUHV0VGV4dCA9IHByb2plY3REZXRhaWwuY2FsbFB1dCA9PSAxID8gJGkxOG4uJGludGVyY2VwdC5uX3NoYXJrX2Zpbl9idWxsaXNoKHByb2plY3REZXRhaWwuY3VycmVuY3kpIDogJGkxOG4uJGludGVyY2VwdC5uX3NoYXJrX2Zpbl9iZWFyaXNoKHByb2plY3REZXRhaWwuY3VycmVuY3kpO1xuICAgICAgICBjb25zdCBjYWxsUHV0Q29sb3IgPSBjb21tb24uZ2V0UHJpY2VDb2xvcihwcm9qZWN0RGV0YWlsLmNhbGxQdXQgPT0gMSk7XG4gICAgICAgIG1vZHVsZURhdGEubmF2VGl0bGUgPSBjYWxsUHV0VGV4dDtcbiAgICAgICAgLy8g5pWw5o2u5bGV56S6XG4gICAgICAgIG1vZHVsZURhdGEuZGF0YWxpc3QgPSBbXG4gICAgICAgICAgICB7IHR5cGU6IFwibm9ybWFsXCIsIG5hbWU6ICRpMThuLm5fc2hhcmtfZmluX0FQWV9Fc3QsIHZhbHVlOiBgJHttaW5SYXRlfSUgfiAke21heFJhdGV9JWAgfSxcbiAgICAgICAgICAgIHsgdHlwZTogXCJub3JtYWxcIiwgbmFtZTogJGkxOG4ubl9taW5pbmdfZHVyYXRpb24sIHZhbHVlOiBgJHtwcm9qZWN0RGV0YWlsLnRlcm19ICR7JGkxOG4ubl9taW5pbmdfZGF5X3RleHR9YCB9LFxuICAgICAgICAgICAgeyB0eXBlOiBcIm5vcm1hbFwiLCBuYW1lOiAkaTE4bi5uX21pbmluZ19lbmRfdGltZSwgdmFsdWU6IGV4cGlyeVRpbWUgfVxuICAgICAgICBdO1xuICAgICAgICAvLyDlvLnnqpflrZfmrrVcbiAgICAgICAgbW9kdWxlRGF0YS5jb25maXJtbGlzdCA9IFtcbiAgICAgICAgICAgIHsgdHlwZTogXCJub3JtYWxcIiwgbmFtZTogJGkxOG4ubl9zaGFya19maW5fcHJvZHVjdF90eXBlLCB2YWx1ZTogXCJcIiwgc3RhdGU6IGNhbGxQdXRUZXh0LCBzdGF0ZUNvbG9yOiBjYWxsUHV0Q29sb3IgfSxcbiAgICAgICAgICAgIHsgdHlwZTogXCJudW1cIiwgbmFtZTogJGkxOG4ubl9hc3NldF9zdWJzY3JpYmVfbnVtYmVyLCB2YWx1ZTogYCR7bW9kdWxlRGF0YS5pbnB1dFRleHR9ICR7cHJvamVjdERldGFpbC5xdW90ZUN1cnJlbmN5fWAsIHN0YXRlOiBgJHskaTE4bi5uX2Fzc2V0c190cmFuc2Zlcl9zcG90fSAtJHttb2R1bGVEYXRhLmlucHV0VGV4dH0gJHtwcm9qZWN0RGV0YWlsLnF1b3RlQ3VycmVuY3l9YCB9LFxuICAgICAgICAgICAgeyB0eXBlOiBcIm5vcm1hbFwiLCBuYW1lOiAkaTE4bi5uX3NoYXJrX2Zpbl9BUFlfRXN0LCB2YWx1ZTogYCR7bWluUmF0ZX0lIH4gJHttYXhSYXRlfSVgLCBzdGF0ZTogXCJcIiwgc3RhdGVDb2xvcjogXCJAY29sb3Iva0NvbG9yUHJpbWFyeVRleHRcIiB9LFxuICAgICAgICAgICAgeyB0eXBlOiBcIm5vcm1hbFwiLCBuYW1lOiAkaTE4bi5uX21pbmluZ19kdXJhdGlvbiwgdmFsdWU6IGAke3Byb2plY3REZXRhaWwudGVybX0gJHskaTE4bi5uX21pbmluZ19kYXlfdGV4dH1gLCBzdGF0ZTogXCJcIiwgc3RhdGVDb2xvcjogXCJAY29sb3Iva0NvbG9yUHJpbWFyeVRleHRcIiB9LFxuICAgICAgICAgICAgeyB0eXBlOiBcIm5vcm1hbFwiLCBuYW1lOiAkaTE4bi5uX21pbmluZ19lbmRfdGltZSwgdmFsdWU6IGV4cGlyeVRpbWUsIHN0YXRlOiBcIlwiLCBzdGF0ZUNvbG9yOiBcIkBjb2xvci9rQ29sb3JQcmltYXJ5VGV4dFwiIH0sXG4gICAgICAgICAgICB7IHR5cGU6IFwibm9ybWFsXCIsIG5hbWU6ICRpMThuLm5fc2hhcmtfZmluX2F1dG9TdWJzY3JpYmUsIHZhbHVlOiBcIlwiLCBzdGF0ZTogXCJcIiwgc3RhdGVDb2xvcjogXCJAY29sb3Iva0NvbG9yUHJpbWFyeVRleHRcIiB9LFxuICAgICAgICBdO1xuICAgICAgICAvLyDovpPlhaXmoYZcbiAgICAgICAgY29uc3QgdXNlclN1cnBsdXMgPSBgJHtjb21tb24uZ2V0UHJpY2VTdHJpbmcoZGF0YS51c2VyU3VycGx1c0Ftb3VudCwgLTEpfSAke3Byb2plY3REZXRhaWwucXVvdGVDdXJyZW5jeX1gO1xuICAgICAgICBtb2R1bGVEYXRhLnVzZXJTdXJwbHVzQWxlcnQgPSAkaTE4bi4kaW50ZXJjZXB0Lm5fc2hhcmtfZmluX2FsZXJ0X2xpbWl0X25ldyh1c2VyU3VycGx1cyk7XG4gICAgICAgIGNvbnN0IGJhbGFuY2VUaXRsZUNvbG9yID0gZGF0YS5iYWxhbmNlQW1vdW50ID4gZGF0YS51c2VyTG93ZXJMaW1pdCA/IFwiQGNvbG9yL2tDb2xvclRocmVlTGV2ZWxUZXh0XCIgOiBcIkBjb2xvci9LQmFzZUlucHV0SW52YWxpZFRpcENvbG9yXCI7XG4gICAgICAgIGNvbnN0IGJhbGFuY2VDb2xvciA9IGRhdGEuYmFsYW5jZUFtb3VudCA+IGRhdGEudXNlckxvd2VyTGltaXQgPyBcIkBjb2xvci9rQ29sb3JQcmltYXJ5VGV4dFwiIDogXCJAY29sb3IvS0Jhc2VJbnB1dEludmFsaWRUaXBDb2xvclwiO1xuICAgICAgICBjb25zdCB1c2VyU3VycGx1c0NvbG9yID0gZGF0YS51c2VyU3VycGx1c0Ftb3VudCA+PSBkYXRhLnVzZXJMb3dlckxpbWl0ID8gXCJAY29sb3Iva0NvbG9yUHJpbWFyeVRleHRcIiA6IFwiQGNvbG9yL0tCYXNlSW5wdXRJbnZhbGlkVGlwQ29sb3JcIjtcbiAgICAgICAgY29uc3Qgc3VycGx1c0NvbG9yID0gZGF0YS5zdXJwbHVzQW1vdW50ID49IGRhdGEudXNlckxvd2VyTGltaXQgPyBcIkBjb2xvci9rQ29sb3JQcmltYXJ5VGV4dFwiIDogXCJAY29sb3IvS0Jhc2VJbnB1dEludmFsaWRUaXBDb2xvclwiO1xuICAgICAgICAvLyDovpPlhaXmoYZcbiAgICAgICAgbW9kdWxlRGF0YS5pbnB1dERhdGEgPSB7XG4gICAgICAgICAgICB0eXBlOiBcIklcIixcbiAgICAgICAgICAgIG5hbWU6ICRpMThuLm5fYXNzZXRfc3Vic2NyaWJlX251bWJlcixcbiAgICAgICAgICAgIHVuaXQ6IHByb2plY3REZXRhaWwucXVvdGVDdXJyZW5jeSxcbiAgICAgICAgICAgIGJhbGFuY2VUaXRsZUNvbG9yOiBiYWxhbmNlVGl0bGVDb2xvcixcbiAgICAgICAgICAgIGJhbGFuY2VDb2xvcjogYmFsYW5jZUNvbG9yLFxuICAgICAgICAgICAgYmFsYW5jZTogYCR7Y29tbW9uLmdldFByaWNlU3RyaW5nKGRhdGEuYmFsYW5jZUFtb3VudCwgLTEpfSAke3Byb2plY3REZXRhaWwucXVvdGVDdXJyZW5jeX1gLFxuICAgICAgICAgICAgaGludDogJGkxOG4uJGludGVyY2VwdC5uX3NoYXJrX2Zpbl9taW5fYW1vdW50KGAke2RhdGEudXNlckxvd2VyTGltaXR9YCksXG4gICAgICAgICAgICB1c2VyU3VycGx1czogdXNlclN1cnBsdXMsXG4gICAgICAgICAgICB1c2VyU3VycGx1c0NvbG9yOiB1c2VyU3VycGx1c0NvbG9yLFxuICAgICAgICAgICAgc3VycGx1czogYCR7Y29tbW9uLmdldFByaWNlU3RyaW5nKGRhdGEuc3VycGx1c0Ftb3VudCwgLTEpfSAke3Byb2plY3REZXRhaWwucXVvdGVDdXJyZW5jeX1gLFxuICAgICAgICAgICAgc3VycGx1c0NvbG9yIDogc3VycGx1c0NvbG9yLFxuICAgICAgICB9O1xuICAgICAgICBjb25zdCB2aWV3U3RhdHVzID0gcHJvamVjdERldGFpbC52aWV3U3RhdHVzOyAvLyDnlLPotK3nirbmgIFcbiAgICAgICAgc3RhcnRUaW1lID0gcHJvamVjdERldGFpbC5zdWJzY3JpYmVTdGFydFRpbWU7IC8vIOeUs+i0reW8gOWni+aXtumXtFxuICAgICAgICAvLyBzdGFydFRpbWUgPSAxNjg5MjI5MTU0MDAwO1xuICAgICAgICBpZiAodmlld1N0YXR1cyA9PSAwIHx8IHN0YXJ0VGltZSA+IHNUaW1lKSB7XG4gICAgICAgICAgICBtb2R1bGVEYXRhLm5lZWRDb3VudERvd24gPSBcInZpc2libGVcIjtcbiAgICAgICAgICAgIGNoYW5nZUNvdW50ZG93bigpO1xuICAgICAgICAgICAgc3RhcnRUaW1lcigpO1xuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgbW9kdWxlRGF0YS5uZWVkQ291bnREb3duID0gXCJnb25lXCI7XG4gICAgICAgICAgICBtb2R1bGVEYXRhLnNob3dJbnB1dCA9IFwidmlzaWJsZVwiO1xuICAgICAgICAgICAgbW9kdWxlRGF0YS5idG5UaXRsZSA9ICRpMThuLm5fYmFsYW5jZV9zdWJzY3JpYmVfYnRuO1xuICAgICAgICB9XG4gICAgICAgIC8vIOihqOagvFxuICAgICAgICAkZXZlbnQucG5scnVsZS5oYW5kbGVEYXRhKGRhdGEucHJvamVjdERldGFpbCk7XG4gICAgICAgIG1vZHVsZURhdGEuYmFsYW5jZUFtb3VudCA9IGRhdGEuYmFsYW5jZUFtb3VudDtcbiAgICAgICAgbW9kdWxlRGF0YS51c2VyTG93ZXJMaW1pdCA9IGRhdGEudXNlckxvd2VyTGltaXQ7XG4gICAgICAgIG1vZHVsZURhdGEudXNlclN1cnBsdXNBbW91bnQgPSBkYXRhLnVzZXJTdXJwbHVzQW1vdW50O1xuICAgICAgICBtb2R1bGVEYXRhLnN1cnBsdXNBbW91bnQgPSBkYXRhLnN1cnBsdXNBbW91bnQ7XG4gICAgfVxufVxuXG5mdW5jdGlvbiBvblN0YXJ0KCkge1xuICAgIGNvbW1vbi5hbmFseXRpY3MoXCJhcHBfZWFybl9zaGFrZUZpblN1YnNjcmliZV92aWV3XCIpO1xufVxuXG5mdW5jdGlvbiBidXR0b25DaGFuZ2VTdGF0dXMoKSB7XG4gICAgY29uc29sZS5sb2coXCJidXR0b25DaGFuZ2VTdGF0dXMgXCIpO1xuICAgIGNvbnN0IGlucHV0TnVtYmVyID0gcGFyc2VGbG9hdChtb2R1bGVEYXRhLmlucHV0VGV4dCk7XG4gICAgY29uc3Qgbm9ybWFsQ29sb3IgPSBtb2R1bGVEYXRhLm9uRm9jdXNJbnRlcm5hbCA9PSBcInRydWVcIiA/IFwiQGNvbG9yL2tDb2xvck1ham9yVGhlbWUxMDBcIiA6IFwiQGNvbG9yL2Jhc2VDb2xvcklucHV0QmFja2dyb3VuZFwiO1xuICAgIGlmIChpbnB1dE51bWJlciA+IDAgJiZcbiAgICAgICAgaW5wdXROdW1iZXIgPD0gbW9kdWxlRGF0YS5iYWxhbmNlQW1vdW50ICYmXG4gICAgICAgIGlucHV0TnVtYmVyID49IG1vZHVsZURhdGEudXNlckxvd2VyTGltaXQgJiZcbiAgICAgICAgaW5wdXROdW1iZXIgPD0gbW9kdWxlRGF0YS51c2VyU3VycGx1c0Ftb3VudCAmJlxuICAgICAgICBpbnB1dE51bWJlciA8PSBtb2R1bGVEYXRhLnN1cnBsdXNBbW91bnQpIHtcbiAgICAgICAgbW9kdWxlRGF0YS5idXR0b25FbmFibGVkID0gdHJ1ZTtcbiAgICAgICAgbW9kdWxlRGF0YS5idG5Db2xvciA9IFwiQGNvbG9yL2tDb2xvck1ham9yVGhlbWUxMDBcIjtcbiAgICAgICAgbW9kdWxlRGF0YS5ib3JkZXJDb2xvciA9IG5vcm1hbENvbG9yO1xuICAgICAgICBjb25zb2xlLmxvZyhcImJ1dHRvbkNoYW5nZVN0YXR1cyAxXCIpO1xuICAgIH0gZWxzZSB7XG4gICAgICAgIG1vZHVsZURhdGEuYnV0dG9uRW5hYmxlZCA9IGZhbHNlO1xuICAgICAgICBtb2R1bGVEYXRhLmJ0bkNvbG9yID0gXCJAY29sb3IvZUJ1dHRvblVuZW5hYmxlZEJnQ29sb3JcIjtcbiAgICAgICAgaWYgKG1vZHVsZURhdGEuaW5wdXRUZXh0ID09IFwiXCIpIHtcbiAgICAgICAgICAgIG1vZHVsZURhdGEuYm9yZGVyQ29sb3IgPSBub3JtYWxDb2xvcjtcbiAgICAgICAgICAgIGNvbnNvbGUubG9nKFwiYnV0dG9uQ2hhbmdlU3RhdHVzIDIgXCIpO1xuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgbW9kdWxlRGF0YS5ib3JkZXJDb2xvciA9IFwiQGNvbG9yL0tCYXNlSW5wdXRJbnZhbGlkVGlwQ29sb3JcIjtcbiAgICAgICAgICAgIGNvbnNvbGUubG9nKFwiYnV0dG9uQ2hhbmdlU3RhdHVzIDMgXCIpO1xuXG4gICAgICAgIH1cbiAgICB9XG59XG5cbmZ1bmN0aW9uIHNob3dEZXRhaWxFbXB0eShzaG93KSB7XG4gICAgbW9kdWxlRGF0YS5lbXB0eSA9IHNob3cgPyBcInZpc2libGVcIiA6IFwiZ29uZVwiO1xuICAgIG1vZHVsZURhdGEubm90RW1wdHkgPSBzaG93ID8gXCJnb25lXCIgOiBcInZpc2libGVcIjtcbn1cblxuZnVuY3Rpb24gc3RhcnRUaW1lcigpIHtcbiAgICBpZiAobW9kdWxlRGF0YS5uZWVkQ291bnREb3duID09IFwidmlzaWJsZVwiICYmIGludGVyY2FsID09IG51bGwpIHtcbiAgICAgICAgaW50ZXJjYWwgPSBzZXRJbnRlcnZhbChjaGFuZ2VDb3VudGRvd24sIDEwMDApO1xuICAgIH1cbn1cblxuZnVuY3Rpb24gY2xlYXJUaW1lcigpIHtcbiAgICBpZiAoaW50ZXJjYWwgIT0gbnVsbCkge1xuICAgICAgICBjbGVhckludGVydmFsKGludGVyY2FsKTtcbiAgICAgICAgaW50ZXJjYWwgPSBudWxsO1xuICAgIH1cbn1cblxuLy8g5YCS6K6h5pe2XG5mdW5jdGlvbiBjaGFuZ2VDb3VudGRvd24oKSB7XG4gICAgLy8g5YCS6K6h5pe2XG4gICAgY29uc3Qgc2VydmVyVGltZURpZmYgPSBzdGFydFRpbWUgLSBzVGltZTsgLy8g5Ymp5L2Z5pe26Ze0XG4gICAgY29uc3Qgc3lzVGltZURpZmYgPSBuZXcgRGF0ZSgpLmdldFRpbWUoKSAtIHN5c1RpbWU7IC8vIOaXtumXtOW3ruavq+enkuaVsFxuICAgIGNvbnN0IGRpZmZlcmVuY2UgPSAoc2VydmVyVGltZURpZmYgLSBzeXNUaW1lRGlmZikgLyAxMDAwO1xuICAgIGlmIChkaWZmZXJlbmNlID4gMCkge1xuICAgICAgICBtb2R1bGVEYXRhLnNob3dJbnB1dCA9IFwiZ29uZVwiO1xuICAgICAgICAvLyDnlLPotK3lgJLorqHml7ZcbiAgICAgICAgY29uc3QgZCA9IE1hdGguZmxvb3IoZGlmZmVyZW5jZSAvIGRkKTtcbiAgICAgICAgY29uc3QgaCA9IE1hdGguZmxvb3IoKGRpZmZlcmVuY2UgJSBkZCkgLyBoaCk7XG4gICAgICAgIGNvbnN0IG0gPSBNYXRoLmZsb29yKChkaWZmZXJlbmNlICUgaGgpIC8gbW0pO1xuICAgICAgICBjb25zdCBzID0gTWF0aC5mbG9vcihkaWZmZXJlbmNlICUgbW0pO1xuICAgICAgICBjb25zdCBzaG93SCA9IGggPCAxMCA/IGAwJHtofWAgOiBgJHtofWA7XG4gICAgICAgIGNvbnN0IHNob3dNID0gbSA8IDEwID8gYDAke219YCA6IGAke219YDtcbiAgICAgICAgY29uc3Qgc2hvd1MgPSBzIDwgMTAgPyBgMCR7c31gIDogYCR7c31gO1xuICAgICAgICBpZiAoZCA+IDApIHtcbiAgICAgICAgICAgIG1vZHVsZURhdGEuYnRuVGl0bGUgPSBgJHtkfSR7JGkxOG4ubl9taW5pbmdfZGF5X3RleHR9ICR7c2hvd0h9OiR7c2hvd019OiR7c2hvd1N9YDtcbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIG1vZHVsZURhdGEuYnRuVGl0bGUgPSBgJHtzaG93SH06JHtzaG93TX06JHtzaG93U31gO1xuICAgICAgICB9XG4gICAgfSBlbHNlIHtcbiAgICAgICAgLy8g55Sz6LSt5byA5aeLXG4gICAgICAgIG1vZHVsZURhdGEuc2hvd0lucHV0ID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgIG1vZHVsZURhdGEuYnRuVGl0bGUgPSAkaTE4bi5uX2JhbGFuY2Vfc3Vic2NyaWJlX2J0bjtcbiAgICAgICAgbW9kdWxlRGF0YS5uZWVkQ291bnREb3duID0gXCJnb25lXCI7XG4gICAgICAgIGNsZWFyVGltZXIoKTtcbiAgICB9XG59XG5cbmZ1bmN0aW9uIGlucHV0TnVtKHQpIHtcbiAgY29uc3QgaW5wdXRSZSA9IC9eWzEtOV1cXGQqJC87XG4gIGlmICh0ID09IG51bGwgfHwgaXNOYU4odCkgfHwgaW5wdXRSZS50ZXN0KHQpID09IGZhbHNlKSB7XG4gICAgcmV0dXJuIGZhbHNlO1xuICB9XG4gIHJldHVybiB0cnVlO1xufVxuXG5mdW5jdGlvbiByZWxvYWREYXRhICgpIHtcbiAgbW9kdWxlRGF0YS5uYXZUaXRsZSA9IFwiXCI7XG4gIG1vZHVsZURhdGEubm90RW1wdHkgPSBcImdvbmVcIjtcbiAgbW9kdWxlRGF0YS5lbXB0eSA9IFwiZ29uZVwiO1xuICBtb2R1bGVEYXRhLnN1Y2Nlc3NTaG93ID0gXCJnb25lXCI7XG4gIG1vZHVsZURhdGEuaW5wdXRUZXh0ID0gXCJcIjtcbiAgbW9kdWxlRGF0YS5lZGl0VGV4dCA9IFwiXCI7XG4gIG1vZHVsZURhdGEub25Gb2N1cyA9IFwiZmFsc2VcIjtcbiAgbW9kdWxlRGF0YS5vbkZvY3VzSW50ZXJuYWwgPSBcImZhbHNlXCI7XG4gIG1vZHVsZURhdGEuZGF0YWxpc3QgPSBbXTtcbiAgbW9kdWxlRGF0YS5pbnB1dERhdGEgPSB7fTtcbiAgbW9kdWxlRGF0YS5odW9iaVNlbGVjdGVkID0gZmFsc2U7XG4gIG1vZHVsZURhdGEuaHVvYmlBZ3JlZUltYWdlID0gXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfbGl2ZV9yZWRwYWNrZXRfdW5zZWxlY3RcIjtcbiAgbW9kdWxlRGF0YS5jb25maXJtQnRuQ29sb3IgPSBcIkBjb2xvci9lQnV0dG9uVW5lbmFibGVkQmdDb2xvclwiO1xuLy8gICAkZXZlbnQucG5scnVsZS5jbGVhckRhdGEoKTtcbn1cblxuLy8g6L6T5YWl5qGG5LqL5Lu2XG5tb2R1bGVFdmVudC5mb2N1c0NoYW5nZSA9IGZ1bmN0aW9uIChmb2N1cykge1xuICBtb2R1bGVEYXRhLm9uRm9jdXNJbnRlcm5hbCA9IGZvY3VzID8gXCJ0cnVlXCIgOiBcImZhbHNlXCI7XG4gIGJ1dHRvbkNoYW5nZVN0YXR1cygpO1xufVxuXG5tb2R1bGVFdmVudC50ZXh0Q2hhbmdlID0gZnVuY3Rpb24gKHRleHQpIHtcbiAgaWYgKHRleHQgPT0gXCJcIiB8fCBpbnB1dE51bSh0ZXh0KSkge1xuICAgIG1vZHVsZURhdGEuaW5wdXRUZXh0ID0gdGV4dDtcbiAgfSBlbHNlIHtcbiAgICBtb2R1bGVEYXRhLmVkaXRUZXh0ID0gbW9kdWxlRGF0YS5pbnB1dFRleHQ7XG4gIH1cbiAgYnV0dG9uQ2hhbmdlU3RhdHVzKCk7XG59XG5cbm1vZHVsZUV2ZW50Lm9uUmV0dXJuID0gZnVuY3Rpb24gKHBhcmFtcykge1xuICBtb2R1bGVEYXRhLm9uRm9jdXMgPSBcImZhbHNlXCI7XG4gIG1vZHVsZURhdGEub25Gb2N1c0ludGVybmFsID0gXCJmYWxzZVwiO1xufVxuXG5tb2R1bGVFdmVudC5jbGlja2VkQWxsID0gZnVuY3Rpb24gKCkge1xuICAgIHZhciBtaW5BbW91bnQgPSBNYXRoLm1pbihtb2R1bGVEYXRhLmJhbGFuY2VBbW91bnQsIG1vZHVsZURhdGEudXNlclN1cnBsdXNBbW91bnQsIG1vZHVsZURhdGEuc3VycGx1c0Ftb3VudCk7XG4gICAgbWluQW1vdW50ID0gTWF0aC5mbG9vcihtaW5BbW91bnQpO1xuICAgIG1vZHVsZURhdGEuZWRpdFRleHQgPSBgJHttaW5BbW91bnR9YDtcbiAgICBtb2R1bGVEYXRhLmlucHV0VGV4dCA9IG1vZHVsZURhdGEuZWRpdFRleHQ7XG4gICAgYnV0dG9uQ2hhbmdlU3RhdHVzKCk7XG4gICAgY29tbW9uLmFuYWx5dGljcyhcImFwcF9lYXJuX3NoYWtlRmluU3Vic2NyaWJlX2Ftb3VudF9hbGxfY2xpY2tcIik7XG59XG5cbi8v5pS26ZSu55uYXG5tb2R1bGVFdmVudC5jbG9zZUtleUJvYXJkID0gZnVuY3Rpb24gKCkge1xuICAgIG1vZHVsZURhdGEub25Gb2N1cyA9IFwiZmFsc2VcIjtcbiAgICBtb2R1bGVEYXRhLm9uRm9jdXNJbnRlcm5hbCA9IFwiZmFsc2VcIjtcbn1cblxuZXhwb3J0IGZ1bmN0aW9uIHRvQmFjaygpIHtcbiAgICBjbGVhclRpbWVyKCk7XG4gICAgY29tbW9uLmNvbnRhaW5lckJhY2soKTtcbn1cblxuLy8g54K55Ye75LqL5Lu2XG5tb2R1bGVFdmVudC5iYWNrQ2xpY2tlZCA9IGZ1bmN0aW9uICgpIHtcbiAgICBjb21tb24uYW5hbHl0aWNzKFwiYXBwX2Vhcm5fc2hha2VGaW5TdWJzY3JpYmVfcmV0dXJuQnV0dG9uX2NsaWNrXCIpO1xuICAgIHRvQmFjaygpO1xufVxuXG5tb2R1bGVFdmVudC5wb3BDb25maXJtT3BlbiA9IGZ1bmN0aW9uICgpIHtcbiAgICBjb21tb24uYW5hbHl0aWNzKFwiYXBwX2Vhcm5fc2hha2VGaW5TdWJzY3JpYmVfc3Vic2NyaWJlQnV0dG9uX2NsaWNrXCIpO1xuICAgIG1vZHVsZUV2ZW50LmNsb3NlS2V5Qm9hcmQoKTtcbiAgICBpZiAoIW1vZHVsZURhdGEuYnV0dG9uRW5hYmxlZCkge1xuICAgICAgICByZXR1cm47XG4gICAgfVxuICAgIG1vZHVsZURhdGEuY29uZmlybWxpc3RbMV0udmFsdWUgPSBgJHttb2R1bGVEYXRhLmlucHV0VGV4dH0gJHttb2R1bGVEYXRhLnVuaXR9YDtcbiAgICBtb2R1bGVEYXRhLmNvbmZpcm1saXN0WzFdLnN0YXRlID0gYCR7JGkxOG4ubl9hc3NldHNfdHJhbnNmZXJfc3BvdH0gLSR7bW9kdWxlRGF0YS5pbnB1dFRleHR9ICR7bW9kdWxlRGF0YS51bml0fWA7XG4gICAgbW9kdWxlRGF0YS5jb25maXJtbGlzdFs1XS52YWx1ZSA9IGF1dG9TdWJzY3JpYmUgPT0gMCA/ICRpMThuLm5fc2hhcmtfZmluX2F1dG9TdWJzY3JpYmVfY2xvc2UgOiAkaTE4bi5uX3NoYXJrX2Zpbl9hdXRvU3Vic2NyaWJlX29wZW47XG4gICAgbW9kdWxlRGF0YS5jb25maXJtU2hvdyA9IFwidHJ1ZVwiO1xuICAgIGNvbW1vbi5hbmFseXRpY3MoXCJhcHBfZWFybl9zaGFrZUZpbl9jb25maXJtT3JkZXJXaW5kb3dzX3Nob3dcIik7XG59XG5cbm1vZHVsZUV2ZW50LnBvcENvbmZpcm1DbG9zZSA9IGZ1bmN0aW9uICgpIHtcbiAgICBtb2R1bGVEYXRhLmNvbmZpcm1TaG93ID0gXCJmYWxzZVwiO1xuICAgIGNvbW1vbi5hbmFseXRpY3MoXCJhcHBfZWFybl9zaGFrZUZpbl9jb25maXJtT3JkZXJXaW5kb3dzX2Nsb3NlQnV0dG9uX2NsaWNrXCIpO1xufVxuXG5cbi8vIGh1b2Jp5Y2P6K6uXG5tb2R1bGVFdmVudC5odW9iaVNlbGVjdGVkID0gZnVuY3Rpb24gKCkge1xuICAgIGlmIChtb2R1bGVEYXRhLmh1b2JpU2VsZWN0ZWQpIHtcbiAgICAgICAgbW9kdWxlRGF0YS5odW9iaVNlbGVjdGVkID0gZmFsc2U7XG4gICAgICAgIG1vZHVsZURhdGEuaHVvYmlBZ3JlZUltYWdlID0gXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfbGl2ZV9yZWRwYWNrZXRfdW5zZWxlY3RcIjtcbiAgICAgICAgbW9kdWxlRGF0YS5jb25maXJtQnRuQ29sb3IgPSBcIkBjb2xvci9lQnV0dG9uVW5lbmFibGVkQmdDb2xvclwiO1xuICAgIH0gZWxzZSB7XG4gICAgICAgIG1vZHVsZURhdGEuaHVvYmlTZWxlY3RlZCA9IHRydWU7XG4gICAgICAgIG1vZHVsZURhdGEuaHVvYmlBZ3JlZUltYWdlID0gXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfbGl2ZV9yZWRwYWNrZXRfc2VsZWN0XCI7XG4gICAgICAgIG1vZHVsZURhdGEuY29uZmlybUJ0bkNvbG9yID0gXCJAY29sb3Iva0NvbG9yTWFqb3JUaGVtZTEwMFwiO1xuICAgIH1cbn1cblxubW9kdWxlRXZlbnQuaHVvYmlsaW5rID0gZnVuY3Rpb24gKCkge1xuICAgIG1vZHVsZURhdGEuY29uZmlybVNob3cgPSBcImZhbHNlXCI7XG4gICAgY29tbW9uLm9wZW5VUkwoYCR7Y29tbW9uLmNvbW1vbkRhdGEuaDVVcmx9L3N1cHBvcnQvJHtjb21tb24uY29tbW9uRGF0YS5sYW5ndWFnZX0vZGV0YWlsLzI0OTUyMDMzNzExNzE3YCk7XG59XG5cbm1vZHVsZUV2ZW50LnBvcFN1Y2Nlc3NPcGVuID0gYXN5bmMgZnVuY3Rpb24gKCkge1xuICAgIGNvbW1vbi5hbmFseXRpY3MoXCJhcHBfZWFybl9zaGFrZUZpbl9jb25maXJtT3JkZXJXaW5kb3dzX2NvbmZpcm1CdXR0b25fc2hvd1wiKTtcbiAgICBpZiAoIW1vZHVsZURhdGEuaHVvYmlTZWxlY3RlZCkge1xuICAgICAgICByZXR1cm47XG4gICAgfVxuICAgIGNvbnN0IHBhcmFtID0ge1xuICAgICAgICBpZCA6IG1vZHVsZURhdGEuaWQsXG4gICAgICAgIGFtb3VudCA6IG1vZHVsZURhdGEuaW5wdXRUZXh0LFxuICAgICAgICB2VG9rZW4gOiBjb21tb24uY29tbW9uRGF0YS52VG9rZW4sXG4gICAgICAgIG9sZFZUb2tlbiA6IGNvbW1vbi5jb21tb25EYXRhLm9sZFZUb2tlbixcbiAgICAgICAgYXV0b1N1YnNjcmliZVxuICAgIH07XG4gICAgY29tbW9uLnNob3dMb2FkaW5nKHRydWUpO1xuICAgIGNvbnN0IGRhdGEgPSBhd2FpdCBjb21tb24uc2VuZFJlcXVlc3QoXCJ2NC9zYXZpbmcvbWluaW5nL3NoYXJrL3Byb2plY3QvZGVtYW5kXCIsIHBhcmFtLCAxLCAwLHtcIkNvbnRlbnQtVHlwZVwiOlwiYXBwbGljYXRpb24vanNvblwifSk7XG4gICAgY29tbW9uLnNob3dMb2FkaW5nKGZhbHNlKTtcbiAgICBpZiAoZGF0YSAmJiBkYXRhICE9IG51bGwpIHtcbiAgICAgICAgLy8ge1wiYW1vdW50XCI6OTkwLFwiY3VycmVuY3lcIjpcIlVTRFRcIixcIm9yZGVySWRcIjoxNjc4NTU0MDA2ODU1fVxuICAgICAgICBtb2R1bGVEYXRhLmNvbmZpcm1TaG93ID0gXCJmYWxzZVwiO1xuICAgICAgICBtb2R1bGVEYXRhLnN1Y2Nlc3NUZXh0ID0gYCR7ZGF0YS5hbW91bnR9ICR7ZGF0YS5jdXJyZW5jeX1gO1xuICAgICAgICBvcmRlcklkID0gZGF0YS5vcmRlcklkO1xuICAgICAgICBtb2R1bGVEYXRhLnN1Y2Nlc3NTaG93ID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgIGNvbW1vbi5hbmFseXRpY3MoXCJhcHBfZWFybl9zaGFrZUZpbl9zdWJzY3JpYmVTdWNjZXNzX3ZpZXdcIik7XG4gICAgfVxufVxuXG5tb2R1bGVFdmVudC5wb3BTdWNjZXNzQ2xvc2UgPSBmdW5jdGlvbiAoKSB7XG4gICAgY29tbW9uLmFuYWx5dGljcyhcImFwcF9lYXJuX3NoYWtlRmluX3N1YnNjcmliZVN1Y2Nlc3NfY2xvc2VCdXR0b25fY2xpY2tcIik7XG4gICAgbW9kdWxlRXZlbnQuYmFja0NsaWNrZWQoKTtcbn1cblxubW9kdWxlRXZlbnQub3BlbkRldGFpbCA9IGZ1bmN0aW9uICgpIHtcbiAgICBuZWVkUmVmcmVzaCA9IHRydWU7XG4gICAgbW9kdWxlRXZlbnQuYmFja0NsaWNrZWQoKTtcbiAgICBjb21tb24uYW5hbHl0aWNzKFwiYXBwX2Vhcm5fc2hha2VGaW5fc3Vic2NyaWJlU3VjY2Vzc192aWV3T3JkZXJzQnV0dG9uX2NsaWNrXCIpO1xuICAgIGNvbW1vbi5vcGVuVVJMKGBob2xpZ2VpdDovL29wZW4vdjE/bG9naW49MSZ1cmw9aWh1b2JpZ2xvYmFsOi8vbS5oYmcuY29tL2VkZ2VlbmdpbmUvY29udGFpbmVyP3NjZW5lPXNoYXJrZmluJnJvb3ROYW1lPWRldGFpbCZuYXZDb25maWc9JnR5cGU9b3JkZXImaWQ9JHtvcmRlcklkfWApO1xufVxuXG5tb2R1bGVFdmVudC5qdW1wVG9UcmFuc2ZlciA9IGZ1bmN0aW9uIChjb2luKSB7XG4gICAgbmVlZFJlZnJlc2ggPSB0cnVlO1xuICAgIG1vZHVsZUV2ZW50LmNsb3NlS2V5Qm9hcmQoKTtcbiAgICBjb25zdCB1cmwgPSBgaG9saWdlaXQ6Ly9vcGVuL3YxP2xvZ2luPTEmdXJsPWlodW9iaWdsb2JhbDovL20uaGJnLmNvbS9iYWxhbmNlL3RyYW5zZmVyP2NvaW49JHtjb2lufSZhY2NvdW50PTVgO1xuICAgIGNvbW1vbi5vcGVuVVJMKHVybCk7XG4gICAgY29tbW9uLmFuYWx5dGljcyhcImFwcF9lYXJuX3NoYWtlRmluU3Vic2NyaWJlX3RyYW5zZmVyQnV0dG9uX2NsaWNrXCIpO1xufVxuXG5tb2R1bGVFdmVudC5qdW1wVG9CdXlDb2luID0gZnVuY3Rpb24gKGNvaW4pIHtcbiAgICBuZWVkUmVmcmVzaCA9IHRydWU7XG4gICAgbW9kdWxlRXZlbnQuY2xvc2VLZXlCb2FyZCgpO1xuICAgIHZhciB1cmwgPSBgaG9saWdlaXQ6Ly9vcGVuL3YxPyZsb2dpbj0xJnVybD1paHVvYmlnbG9iYWw6Ly9tLmhiZy5jb20vb3RjL2luZGV4P3RyYWRlQXJlYT1wMnAmaXNPdXRBcmVhPXRydWUmdHJhZGVTaWRlPWJ1eSZ0cmFkZUN1cnJlbmN5PVVTRFRgO1xuICAgIGNvbW1vbi5vcGVuVVJMKHVybCk7XG4gICAgY29tbW9uLmFuYWx5dGljcyhcImFwcF9lYXJuX3NoYWtlRmluU3Vic2NyaWJlX2J1eUJ1dHRvbl9jbGlja1wiKTtcbn1cblxubW9kdWxlRXZlbnQuYXV0b0NsaWNrZWQgPSBmdW5jdGlvbiAoKSB7XG4gIGlmIChhdXRvU3Vic2NyaWJlID09IDApIHtcbiAgICBhdXRvU3Vic2NyaWJlID0gMTtcbiAgICBtb2R1bGVEYXRhLnN3aXRjaENvbG9yID0gXCJAY29sb3IvS0Jhc2VDb2xvckNvbnRlbnRCYWNrZ3JvdW5kXCI7XG4gICAgbW9kdWxlRGF0YS5zd2l0Y2hCYWNrQ29sb3IgPSBcIkBjb2xvci9iYXNlQ29sb3JNYWpvclRoZW1lMTAwXCI7XG4gICAgbW9kdWxlRGF0YS5zd2l0Y2hXaWR0aCA9IFwiMTRcIjtcbiAgfSBlbHNlIHtcbiAgICBhdXRvU3Vic2NyaWJlID0gMDtcbiAgICBtb2R1bGVEYXRhLnN3aXRjaENvbG9yID0gXCJAY29sb3IvS0Jhc2VDb2xvckNvbnRlbnRCYWNrZ3JvdW5kXCI7XG4gICAgbW9kdWxlRGF0YS5zd2l0Y2hCYWNrQ29sb3IgPSBcIkBjb2xvci9lQnV0dG9uVW5lbmFibGVkQmdDb2xvclwiO1xuICAgIG1vZHVsZURhdGEuc3dpdGNoV2lkdGggPSBcIjJcIjtcbiAgfVxufVxuXG4vLyBUT0RPXG4vLyByZXF1ZXN0QnV5RGV0YWlsKDEzMzEpO1xuIiwiaW1wb3J0ICogYXMgY29tbW9uIGZyb20gXCIuL2NvbW1vblwiO1xuaW1wb3J0ICogYXMgbnVtYmVyIGZyb20gXCIuL251bWJlclwiO1xuXG4kZGF0YS5wbmxydWxlID0ge1xuICAgIHN1YlRpdGxlOiBcIlwiLFxuICAgIEtleVRpdGxlOiBcIlwiLFxuICAgIGtleTE6IFwiXCIsXG4gICAga2V5MjogXCJcIixcbiAgICB2YWx1ZTE6IFwiXCIsXG4gICAgdmFsdWUyOiBcIlwiLFxuICAgIG1pblJhdGUgOiBcIlwiLFxuICAgIG1heFJhdGU6IFwiXCIsXG4gICAgbWluUHJpY2U6IFwiXCIsXG4gICAgbWF4UHJpY2U6IFwiXCIsXG4gICAgc3JjOiBcIlwiLFxuICAgIHNob3dJY29uOiBcImdvbmVcIixcbiAgICBzaG93Q29udGVudDogXCJcIixcbn1cblxuJGV2ZW50LnBubHJ1bGUgPSB7XG4gICAgaGFuZGxlRGF0YShwYXJhbXMpIHtcbiAgICAgICAgY29uc3QgYmFycmllciA9IGNvbW1vbi5nZXRQcmljZVN0cmluZyhwYXJhbXMuYmFycmllciwgLTEpO1xuICAgICAgICBpZiAocGFyYW1zLnZpZXdTdGF0dXMgPT0gMykge1xuICAgICAgICAgIGNvbnN0IHNldHRsZW1lbnRQcmljZSA9IGNvbW1vbi5nZXRQcmljZVN0cmluZyhwYXJhbXMuc2V0dGxlbWVudFByaWNlLCAtMSk7XG4gICAgICAgICAgJGRhdGEucG5scnVsZS5zdWJUaXRsZSA9ICRpMThuLiRpbnRlcmNlcHQubl9zaGFya19maW5fc2V0dGxlbWVudF9wcmljZShwYXJhbXMuY3VycmVuY3kpICsgYDogJCR7c2V0dGxlbWVudFByaWNlfWA7XG4gICAgICAgICAgJGRhdGEucG5scnVsZS5zaG93SWNvbiA9IHBhcmFtcy5zZXR0bGVtZW50UHJpY2UgPiAwID8gXCJ2aXNpYmxlXCIgOiBcImdvbmVcIjtcbiAgICAgICAgICBjb25zdCBleHBpcnlUaW1lID0gbmV3IERhdGUocGFyYW1zLmV4cGlyeVRpbWUpLkZvcm1hdChcInl5eXkvTU0vZGRcIik7XG4gICAgICAgICAgLy8gLTEt5LiN5bGV56S6OyAwLeacquaVsuWHujsxLeW3suaVsuWHuiBzZXR0bGVtZW50UHJpY2VUaW1lXG4gICAgICAgICAgaWYgKHBhcmFtcy5zZXR0bGVtZW50UmVtYXJrVHlwZSA9PSAtMSkge1xuICAgICAgICAgICAgJGRhdGEucG5scnVsZS5zaG93SWNvbiA9IFwiZ29uZVwiO1xuICAgICAgICAgIH0gZWxzZSBpZiAocGFyYW1zLnNldHRsZW1lbnRSZW1hcmtUeXBlID09IDApIHtcbiAgICAgICAgICAgICAgJGRhdGEucG5scnVsZS5zaG93Q29udGVudCA9ICRpMThuLiRpbnRlcmNlcHQubl9zaGFya19maW5fdG9hc3RfMyhgJHtleHBpcnlUaW1lfWApO1xuICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICBjb25zdCBzZXR0bGVtZW50UHJpY2VUaW1lID0gbmV3IERhdGUocGFyYW1zLnNldHRsZW1lbnRQcmljZVRpbWUpLkZvcm1hdChcInl5eXkvTU0vZGQgaGg6bW06c3NcIik7XG4gICAgICAgICAgICBjb25zdCBzZXR0bGVtZW50UHJpY2VUaW1lRW5kID0gbmV3IERhdGUocGFyYW1zLnNldHRsZW1lbnRQcmljZVRpbWUgKyAzNTk5MDAwKS5Gb3JtYXQoXCJ5eXl5L01NL2RkIGhoOm1tOnNzXCIpO1xuICAgICAgICAgICAgaWYgKHBhcmFtcy5jYWxsUHV0ID09IDEpIHtcbiAgICAgICAgICAgICAgJGRhdGEucG5scnVsZS5zaG93Q29udGVudCA9ICRpMThuLiRpbnRlcmNlcHQubl9zaGFya19maW5fdG9hc3RfYnVsbGlzaChgJHtzZXR0bGVtZW50UHJpY2VUaW1lfWAsYCR7c2V0dGxlbWVudFByaWNlVGltZUVuZH1gLGAkJHtiYXJyaWVyfWAsYCR7c2V0dGxlbWVudFByaWNlVGltZX1gLGAke3NldHRsZW1lbnRQcmljZVRpbWVFbmR9YCxgJCR7c2V0dGxlbWVudFByaWNlfWApO1xuICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgJGRhdGEucG5scnVsZS5zaG93Q29udGVudCA9ICRpMThuLiRpbnRlcmNlcHQubl9zaGFya19maW5fdG9hc3RfYmVhcmlzaChgJHtzZXR0bGVtZW50UHJpY2VUaW1lfWAsYCR7c2V0dGxlbWVudFByaWNlVGltZUVuZH1gLGAkJHtiYXJyaWVyfWAsYCR7c2V0dGxlbWVudFByaWNlVGltZX1gLGAke3NldHRsZW1lbnRQcmljZVRpbWVFbmR9YCxgJCR7c2V0dGxlbWVudFByaWNlfWApO1xuICAgICAgICAgICAgfVxuICAgICAgICAgIH1cbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAkZGF0YS5wbmxydWxlLnN1YlRpdGxlID0gJGkxOG4uJGludGVyY2VwdC5uX3NoYXJrX2Zpbl9jdXJyZW50X3ByaWNlX25ldyhwYXJhbXMuY3VycmVuY3ksIFwiXCIpO1xuICAgICAgICAgICRkYXRhLnBubHJ1bGUuc2hvd0ljb24gPSBcImdvbmVcIjtcbiAgICAgICAgICByZXF1ZXN0TWFya2V0UHJpY2UocGFyYW1zKTtcbiAgICAgICAgfVxuICAgICAgICAkZGF0YS5wbmxydWxlLktleVRpdGxlID0gJGkxOG4uJGludGVyY2VwdC5uX3NoYXJrX2Zpbl9zZXR0bGVtZW50X3ByaWNlKHBhcmFtcy5jdXJyZW5jeSk7XG4gICAgICAgIGNvbnN0IG1pblJhdGUgPSBjb21tb24uZm9ybWF0UHJlY2lzaW9uKG51bWJlci5tdWx0aXBseShwYXJhbXMubWluUmF0ZSwgXCIxMDBcIiksIDIpO1xuICAgICAgICBjb25zdCBtYXhSYXRlID0gY29tbW9uLmZvcm1hdFByZWNpc2lvbihudW1iZXIubXVsdGlwbHkocGFyYW1zLm1heFJhdGUsIFwiMTAwXCIpLCAyKTtcbiAgICAgICAgY29uc3Qgc3RyaWtlID0gY29tbW9uLmdldFByaWNlU3RyaW5nKHBhcmFtcy5zdHJpa2UsIC0xKTtcbiAgICAgICAgLy8gc3RyaWtlIOihjOadg+S7t++8jOeci+a2qO+8jOihjOadg+S7t+WcqOW3pu+8m+eci+i3jO+8jOihjOadg+S7t+WcqOWPs1x0XG4gICAgICAgIC8vIGJhcnJpZXIg5pWy5Ye65Lu377yM55yL5rao77yM5pWy5Ye65Lu35Zyo5Y+z77yb55yL6LeM77yM5pWy5Ye65Lu35Zyo5bemXG4gICAgICAgIGlmIChwYXJhbXMuY2FsbFB1dCA9PSAxKSB7XG4gICAgICAgICAgICAkZGF0YS5wbmxydWxlLmtleTEgPSBgPCAkJHtzdHJpa2V9ICR7JGkxOG4ubl9vdGNfb3JkZXJfb3J9ID4gJCR7YmFycmllcn1gO1xuICAgICAgICAgICAgJGRhdGEucG5scnVsZS5rZXkyID0gYCQke3N0cmlrZX0gfiAkJHtiYXJyaWVyfWA7XG4gICAgICAgICAgICAkZGF0YS5wbmxydWxlLm1pblByaWNlID0gYCQke3N0cmlrZX1gO1xuICAgICAgICAgICAgJGRhdGEucG5scnVsZS5tYXhQcmljZSA9IGAkJHtiYXJyaWVyfWA7XG4gICAgICAgICAgICAkZGF0YS5wbmxydWxlLnNyYyA9IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX3NoYXJrZmluX2ludHJvZHVjZV91cFwiO1xuICAgICAgICAgICAgJGRhdGEuYWxlcnQucHJpY2VUaXBzID0gJGkxOG4uJGludGVyY2VwdC5uX3NoYXJrX2Zpbl9hbGVydF9wcm9kdWN0X24ocGFyYW1zLmN1cnJlbmN5LCBgID4gJCR7YmFycmllcn1gLCBgJHttaW5SYXRlfSVgLCBgIDw9ICQke2JhcnJpZXJ9YCwgcGFyYW1zLmN1cnJlbmN5LCAkZGF0YS5wbmxydWxlLmtleTIsIGAke21pblJhdGV9JSB+ICR7bWF4UmF0ZX0lYCwgcGFyYW1zLmN1cnJlbmN5LCBgIDwgJCR7c3RyaWtlfWAsIGAke21pblJhdGV9JWApO1xuXG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAkZGF0YS5wbmxydWxlLmtleTEgPSBgPCAkJHtiYXJyaWVyfSAkeyRpMThuLm5fb3RjX29yZGVyX29yfSA+ICQke3N0cmlrZX1gO1xuICAgICAgICAgICAgJGRhdGEucG5scnVsZS5rZXkyID0gYCQke2JhcnJpZXJ9IH4gJCR7c3RyaWtlfWA7XG4gICAgICAgICAgICAkZGF0YS5wbmxydWxlLm1pblByaWNlID0gYCQke2JhcnJpZXJ9YDtcbiAgICAgICAgICAgICRkYXRhLnBubHJ1bGUubWF4UHJpY2UgPSBgJCR7c3RyaWtlfWA7XG4gICAgICAgICAgICAkZGF0YS5wbmxydWxlLnNyYyA9IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX3NoYXJrZmluX2ludHJvZHVjZV9kb3duXCI7XG4gICAgICAgICAgICAkZGF0YS5hbGVydC5wcmljZVRpcHMgPSAkaTE4bi4kaW50ZXJjZXB0Lm5fc2hhcmtfZmluX2FsZXJ0X3Byb2R1Y3RfbihwYXJhbXMuY3VycmVuY3ksIGAgPCAkJHtiYXJyaWVyfWAsIGAke21pblJhdGV9JWAsIGAgPj0gJCR7YmFycmllcn1gLCBwYXJhbXMuY3VycmVuY3ksICRkYXRhLnBubHJ1bGUua2V5MiwgYCR7bWluUmF0ZX0lIH4gJHttYXhSYXRlfSVgLCBwYXJhbXMuY3VycmVuY3ksIGAgPiAkJHtzdHJpa2V9YCwgYCR7bWluUmF0ZX0lYCk7XG4gICAgICAgIH1cbiAgICAgICAgJGRhdGEucG5scnVsZS52YWx1ZTEgPSBgJHttaW5SYXRlfSVgO1xuICAgICAgICAkZGF0YS5wbmxydWxlLnZhbHVlMiA9IGAke21pblJhdGV9JSB+ICR7bWF4UmF0ZX0lYDtcbiAgICAgICAgJGRhdGEucG5scnVsZS5taW5SYXRlID0gYCR7bWluUmF0ZX0lYDtcbiAgICAgICAgJGRhdGEucG5scnVsZS5tYXhSYXRlID0gYCR7bWF4UmF0ZX0lYDtcbiAgICB9LFxuICAgIGNsZWFyRGF0YSgpIHtcbiAgICAgICRkYXRhLnBubHJ1bGUuc3JjID0gXCJcIjtcbiAgICB9LFxuICAgIHNob3dJY29uQWxlcnQoKSB7XG4gICAgICAkZGF0YS5hbGVydC5jb250ZW50ID0gJGRhdGEucG5scnVsZS5zaG93Q29udGVudDtcbiAgICAgICRkYXRhLmFsZXJ0LmFsZXJ0UG9wU2hvdyA9IFwidHJ1ZVwiO1xuICAgIH1cbn1cblxuYXN5bmMgZnVuY3Rpb24gcmVxdWVzdE1hcmtldFByaWNlKHBhcmFtcykge1xuICAgIGNvbnN0IHJlcVBhcmFtcyA9IHtcbiAgICAgICAgcGF0aDogXCJtYXJrZXQvcHJpY2VBbGxcIixcbiAgICAgICAgbWV0aG9kOiAwLFxuICAgICAgICBob3N0VHlwZTogNCxcbiAgICAgICAgaGVhZGVyOiB7IFwiQ29udGVudC1UeXBlXCI6IFwiYXBwbGljYXRpb24vanNvblwiIH0sXG4gICAgICAgIHBhcmFtczoge30sXG4gICAgfTtcbiAgICB0cnkge1xuICAgICAgICB2YXIgcmVzcG9uc2VTdHJpbmcgPSBhd2FpdCAkbmF0aXZlQVBJLnJlcXVlc3QoSlNPTi5zdHJpbmdpZnkocmVxUGFyYW1zKSk7XG4gICAgICAgIHZhciByZXNwb25zZSA9IEpTT04ucGFyc2UocmVzcG9uc2VTdHJpbmcpO1xuICAgICAgICB2YXIgeyBzdGF0dXMsIGNvZGUsIGRhdGEgfSA9IHJlc3BvbnNlO1xuICAgICAgICBpZiAoKHN0YXR1cyAmJiBzdGF0dXMgPT0gXCJva1wiKSB8fCAoY29kZSAmJiBjb2RlID09IDIwMCkpIHtcbiAgICAgICAgICAgIGNvbnN0IGtleSA9IGAke3BhcmFtcy5jdXJyZW5jeX0ke3BhcmFtcy5xdW90ZUN1cnJlbmN5fWAudG9Mb3dlckNhc2UoKTtcbiAgICAgICAgICAgIGNvbnN0IHJlc3VsdCA9IGRhdGFba2V5XTtcbiAgICAgICAgICAgIGlmIChyZXN1bHQgJiYgcmVzdWx0ICE9IG51bGwpIHtcbiAgICAgICAgICAgICAgICBjb25zdCB0UHJpY2UgPSBjb21tb24uZ2V0UHJpY2VTdHJpbmcocmVzdWx0WzBdLCAtMSk7XG4gICAgICAgICAgICAgICAgJGRhdGEucG5scnVsZS5zdWJUaXRsZSA9ICRpMThuLiRpbnRlcmNlcHQubl9zaGFya19maW5fY3VycmVudF9wcmljZV9uZXcocGFyYW1zLmN1cnJlbmN5LCBgJCR7dFByaWNlfWApO1xuICAgICAgICAgICAgfVxuICAgICAgICB9XG4gICAgfSBjYXRjaCAoZSkge1xuICAgICAgICBjb25zb2xlLmxvZyhgcmVxdWVzdE1hcmtldFByaWNlIGVycm9yLCBlcnJvcj0ke2V9YCk7XG4gICAgfVxufVxuXG4iLCJpbXBvcnQgKiBhcyBjb21tb24gZnJvbSBcIi4vY29tbW9uXCJcbmltcG9ydCAqIGFzIG51bWJlciBmcm9tIFwiLi9udW1iZXJcIjtcbmltcG9ydCAqIGFzIGRlcG9zaXQgZnJvbSBcIi4vZGVwb3NpdFwiO1xuXG52YXIgdmlld1N0YXR1cyA9IDA7XG52YXIgYXV0b1N1YnNjcmliZSA9IDA7XG52YXIgYXV0b1N1YnNjcmliZVN0YXRlID0gMDtcbnZhciBhdXRvT3JkZXJJZCA9IFwiXCI7XG5cbmZ1bmN0aW9uIGRlZmF1bHREYXRhKCkge1xuICAgIHJldHVybiB7XG4gICAgICAgIG5hdlRpdGxlOiBcIlwiLFxuICAgICAgICBjZWxsbGlzdDogW10sXG4gICAgICAgIHVuaXQ6IFwiVVNEVFwiLFxuICAgICAgICBlbXB0eTogXCJnb25lXCIsXG4gICAgICAgIG5vdEVtcHR5OiBcImdvbmVcIixcbiAgICAgICAgc3Vic2NyaWJlRW5kVGltZTogMCxcbiAgICAgICAgb3JkZXJTaG93OiBcImdvbmVcIixcbiAgICAgICAgYnV5TnVtYmVyOiBcIlwiLFxuICAgICAgICBidXlQbmw6IFwiXCIsXG4gICAgICAgIGJ1eU51bWJlckFtb3VudDogXCJcIixcbiAgICAgICAgYnV5UG5sQW1vdW50OiBcIlwiLFxuICAgICAgICBzdGF0dXNIZWlnaHQ6IDIwLFxuICAgICAgICB0eXBlOicnLFxuICAgICAgICBib3JkZXJDb2xvcjogXCJAY29sb3IvYmFzZUNvbG9ySW5wdXRCYWNrZ3JvdW5kXCIsXG4gICAgICAgIHN3aXRjaENvbG9yOiBcIkBjb2xvci9LQmFzZUNvbG9yQ29udGVudEJhY2tncm91bmRcIixcbiAgICAgICAgc3dpdGNoQmFja0NvbG9yOiBcIkBjb2xvci9lQnV0dG9uVW5lbmFibGVkQmdDb2xvclwiLFxuICAgICAgICBzd2l0Y2hXaWR0aDogXCIyXCIsXG4gICAgICAgIHN3aXRjaE9wYWNpdHk6IFwiMVwiLFxuICAgICAgICByZXN1bHRSZW1hcms6ICRpMThuLm5fc2hhcmtfZmluX2F1dG9TdWJzY3JpYmVfZGVzYyxcbiAgICAgICAgcmVzdWx0Q29sb3I6IFwiQGNvbG9yL2tDb2xvclRocmVlTGV2ZWxUZXh0XCIsXG4gICAgfTtcbn1cblxuXG5mdW5jdGlvbiBvbkNyZWF0ZShldmVudFBhcmFtcykge1xuICAgIHJlbG9hZERhdGEoKTtcbiAgICBtb2R1bGVEYXRhLnN0YXR1c0JhckNvbmZpZyA9IHsgXCJzdGF0dXNCYXJNb2RlXCI6IFwiZmFsc2VcIiB9O1xuICAgIGNvbnNvbGUubG9nKFwiZGV0YWlsOiVvXCIsIGV2ZW50UGFyYW1zKTtcbiAgIFxuICAgIGlmICghZXZlbnRQYXJhbXMgfHwgZXZlbnRQYXJhbXMgPT0gbnVsbCkge1xuICAgICAgICBzaG93RGV0YWlsRW1wdHkodHJ1ZSk7XG4gICAgICAgIHJldHVybjtcbiAgICB9XG4gICAgY29uc3QgcGFyYW1zID0gSlNPTi5wYXJzZShldmVudFBhcmFtcyk7XG4gICAgY29uc3QgdHlwZSA9IHBhcmFtcy50eXBlO1xuICAgIG1vZHVsZURhdGEudHlwZSA9IHR5cGU7XG4gICAgLy8gcHJvamVjdO+8mumhueebruivpuaDhe+8jG9yZGVy77ya6K6i5Y2V6K+m5oOFXG4gICAgaWYgKHR5cGUgPT0gXCJvcmRlclwiKSB7XG4gICAgICAgIG1vZHVsZURhdGEubmF2VGl0bGUgPSAkaTE4bi5uX2V4Y2hhbmdlX3RpbWluZ19lbnRydXN0X2RldGFpbDtcbiAgICAgICAgcmVxdWVzdE9yZGVyRGV0YWlsKHBhcmFtcy5pZCk7XG4gICAgfSBlbHNlIHtcbiAgICAgICAgbW9kdWxlRGF0YS5uYXZUaXRsZSA9ICRpMThuLm5fc2hhcmtfZmluX3Byb2R1Y3RfZGV0YWlsO1xuICAgICAgICByZXF1ZXN0UHJvamVjdERldGFpbChwYXJhbXMuaWQpO1xuICAgIH1cbn1cblxuZnVuY3Rpb24gb25EZXN0cm95ICgpIHtcbiAgcmVsb2FkRGF0YSgpO1xufVxuXG5mdW5jdGlvbiBvblN0YXJ0KCkge1xuICAgIGNvbW1vbi5hbmFseXRpY3MoXCJhcHBfZWFybl9zaGFrZUZpbl9vcmRlckRldGFpbF92aWV3XCIpO1xufVxuXG5jb25zdCB7IG1vZHVsZURhdGEsIG1vZHVsZUV2ZW50IH0gPSBjb21tb24ubW9kdWxlRGVmaW5lKFwiZGV0YWlsXCIsIGRlZmF1bHREYXRhLCB7IG9uQ3JlYXRlLCBvbkRlc3Ryb3ksIG9uU3RhcnQgfSk7XG5cbi8vIGh0dHBzOi8veWFwaS5odW9iaWFwcHMuY29tL3Byb2plY3QvMTY4NS9pbnRlcmZhY2UvYXBpLzkwMDU4IOiuouWNlemhteivpuaDhe+8jOmcgOimgeeahOaYr+iuouWNlWlkXG5hc3luYyBmdW5jdGlvbiByZXF1ZXN0T3JkZXJEZXRhaWwob3JkZXJJZCkge1xuICAgIGF1dG9PcmRlcklkID0gb3JkZXJJZDtcbiAgICBjb21tb24uc2hvd0xvYWRpbmcodHJ1ZSk7XG4gICAgY29uc3QgZGF0YSA9IGF3YWl0IGNvbW1vbi5zZW5kUmVxdWVzdChcInY0L3NhdmluZy9taW5pbmcvdXNlci9vcmRlci9zaGFya0RldGFpbFwiLCB7IG9yZGVySWQgfSk7XG4gICAgY29uc29sZS5sb2coSlNPTi5zdHJpbmdpZnkoZGF0YSkpO1xuICAgIGNvbW1vbi5zaG93TG9hZGluZyhmYWxzZSk7XG4gICAgaWYgKCFkYXRhIHx8IGRhdGEgPT0gbnVsbCkge1xuICAgICAgICBzaG93RGV0YWlsRW1wdHkodHJ1ZSk7XG4gICAgICAgIHJldHVybjtcbiAgICB9XG4gICAgJGV2ZW50LnBubHJ1bGUuaGFuZGxlRGF0YShkYXRhLnByb2plY3REZXRhaWwpO1xuICAgIGhhbmRsZURldGFpbERhdGEoZGF0YS5wcm9qZWN0RGV0YWlsKTtcbiAgICBtb2R1bGVEYXRhLm9yZGVyU2hvdyA9IFwidmlzaWJsZVwiO1xuICAgIG1vZHVsZURhdGEuYnV5TnVtYmVyID0gJGkxOG4ubl9hc3NldF9zdWJzY3JpYmVfbnVtYmVyICsgYCgke2RhdGEucHJvamVjdERldGFpbC5xdW90ZUN1cnJlbmN5fSlgO1xuICAgIG1vZHVsZURhdGEuYnV5UG5sID0kaTE4bi5uX3NoYXJrX2Zpbl9kZXBvc2l0X3BubCArIGAoJHtkYXRhLnByb2plY3REZXRhaWwucXVvdGVDdXJyZW5jeX0pYDtcbiAgICBtb2R1bGVEYXRhLmJ1eU51bWJlckFtb3VudCA9IGAke2RhdGEuYW1vdW50fWA7XG4gICAgbW9kdWxlRGF0YS5idXlQbmxBbW91bnQgPSBgJHtkYXRhLnRvdGFsSW5jb21lQW1vdW50fWA7XG4gICAgaWYgKGRhdGEucHJvamVjdERldGFpbCAmJiBkYXRhLnByb2plY3REZXRhaWwudmlld1N0YXR1cyAhPSAzKSB7XG4gICAgICBtb2R1bGVEYXRhLmJ1eVBubEFtb3VudCA9ICRpMThuLm5fc2hhcmtfZmluX29ycGhhbjtcbiAgICB9XG4gICAgaWYgKGRhdGEuYXV0b1N1YnNjcmliZUluZm8pIHtcbiAgICAgIGF1dG9TdWJzY3JpYmUgPSBkYXRhLmF1dG9TdWJzY3JpYmVJbmZvLmF1dG9TdWJzY3JpYmU7XG4gICAgICBhdXRvU3Vic2NyaWJlU3RhdGUgPSBkYXRhLmF1dG9TdWJzY3JpYmVJbmZvLmF1dG9TdWJzY3JpYmVTdGF0ZTtcbiAgICAgIGNvbnN0IHJlc3VsdENvZGUgPSBkYXRhLmF1dG9TdWJzY3JpYmVJbmZvLmF1dG9TdWJzY3JpYmVSZXN1bHRDb2RlO1xuICAgICAgY29uc3QgcmVzdWx0UmVtYXJrID0gZGF0YS5hdXRvU3Vic2NyaWJlSW5mby5hdXRvU3Vic2NyaWJlUmVzdWx0UmVtYXJrO1xuICAgICAgY2hhbmdlU3dpdGNoU3RhdHVzKCk7XG4gICAgICBjaGFuZ2VTd2l0Y2hSZW1hcmsocmVzdWx0Q29kZSwgcmVzdWx0UmVtYXJrKTtcbiAgICB9XG4gICAgc2hvd0RldGFpbEVtcHR5KGZhbHNlKTtcbn1cblxuLy8gaHR0cHM6Ly95YXBpLmh1b2JpYXBwcy5jb20vcHJvamVjdC8xNjg1L2ludGVyZmFjZS9hcGkvOTAwNTAg5Y6G5Y+y6aG555uu6K+m5oOFXG5hc3luYyBmdW5jdGlvbiByZXF1ZXN0UHJvamVjdERldGFpbChwcm9qZWN0SWQpIHtcbiAgICBjb21tb24uc2hvd0xvYWRpbmcodHJ1ZSk7XG4gICAgY29uc3QgZGF0YSA9IGF3YWl0IGNvbW1vbi5zZW5kUmVxdWVzdChcInY0L3NhdmluZy9taW5pbmcvc2hhcmsvcHJvamVjdC9kZXRhaWxcIiwgeyBwcm9qZWN0SWQgfSk7XG4gICAgY29tbW9uLnNob3dMb2FkaW5nKGZhbHNlKTtcbiAgICBpZiAoIWRhdGEgfHwgZGF0YSA9PSBudWxsKSB7XG4gICAgICAgIHNob3dEZXRhaWxFbXB0eSh0cnVlKTtcbiAgICAgICAgcmV0dXJuO1xuICAgIH1cbiAgICAkZXZlbnQucG5scnVsZS5oYW5kbGVEYXRhKGRhdGEpO1xuICAgIGhhbmRsZURldGFpbERhdGEoZGF0YSk7XG4gICAgc2hvd0RldGFpbEVtcHR5KGZhbHNlKTtcbn1cblxuZnVuY3Rpb24gaGFuZGxlRGV0YWlsRGF0YShkYXRhKSB7XG4gICAgdmlld1N0YXR1cyA9IGRhdGEudmlld1N0YXR1cztcbiAgICBtb2R1bGVEYXRhLnVuaXQgPSBkYXRhLnF1b3RlQ3VycmVuY3k7XG4gICAgY29uc3QgY2FsbFB1dFRleHQgPSBkYXRhLmNhbGxQdXQgPT0gMSA/ICRpMThuLiRpbnRlcmNlcHQubl9zaGFya19maW5fYnVsbGlzaChkYXRhLmN1cnJlbmN5KSA6ICRpMThuLiRpbnRlcmNlcHQubl9zaGFya19maW5fYmVhcmlzaChkYXRhLmN1cnJlbmN5KTtcbiAgICBjb25zdCBtaW5SYXRlID0gY29tbW9uLmZvcm1hdFByZWNpc2lvbihudW1iZXIubXVsdGlwbHkoZGF0YS5taW5SYXRlLCBcIjEwMFwiKSwgMik7XG4gICAgY29uc3QgbWF4UmF0ZSA9IGNvbW1vbi5mb3JtYXRQcmVjaXNpb24obnVtYmVyLm11bHRpcGx5KGRhdGEubWF4UmF0ZSwgXCIxMDBcIiksIDIpO1xuICAgIGNvbnN0IGZpbmFsUmF0ZSA9IGNvbW1vbi5mb3JtYXRQcmVjaXNpb24obnVtYmVyLm11bHRpcGx5KGRhdGEuZmluYWxSYXRlLCBcIjEwMFwiKSwgMik7XG4gICAgY29uc3QgZXhwaXJ5VGltZSA9IG5ldyBEYXRlKGRhdGEuZXhwaXJ5VGltZSkuRm9ybWF0KFwieXl5eS9NTS9kZFwiKTtcbiAgICBjb25zdCBzdGF0dWVWYWx1ZSA9IGhhbmRsZVN0YXR1cyhkYXRhLnZpZXdTdGF0dXMpO1xuICAgIGNvbnN0IHN0YXRlQ29sb3IgPSBkYXRhLnZpZXdTdGF0dXMgPT0gMiA/IFwiIzAwQTE3MVwiIDogXCJAY29sb3Iva0NvbG9yUHJpbWFyeVRleHRcIjtcbiAgICB2YXIgQVBZRXN0ID0gJGkxOG4ubl9zaGFya19maW5fQVBZX0VzdDtcbiAgICB2YXIgQVBZRXN0VmFsdWUgPSBgJHttaW5SYXRlfSUgfiAke21heFJhdGV9JWA7XG4gICAgaWYgKGRhdGEudmlld1N0YXR1cyA9PSAzKSB7XG4gICAgICBBUFlFc3QgPSAkaTE4bi5uX3NoYXJrX2Zpbl9Fc3RfQVBZO1xuICAgICAgQVBZRXN0VmFsdWUgPSBgJHtmaW5hbFJhdGV9JWA7XG4gICAgfSBcbiAgICBtb2R1bGVEYXRhLmNlbGxsaXN0ID0gW1xuICAgICAgICB7IHR5cGU6IFwiSDFcIiwgbmFtZTogJGkxOG4ubl9zaGFya19maW5fZGVwb3NpdF9pbmZvIH0sXG4gICAgICAgIHsgdHlwZTogXCJub3JtYWxcIiwgbmFtZTogJGkxOG4ubl9leGNoYW5nZV90aW1pbmdfb3JkZXJfc3RhdHVzLCB2YWx1ZTogXCJcIiwgc3RhdGU6IHN0YXR1ZVZhbHVlLCB0aXBzU2hvdzogXCJ2aXNpYmxlXCIsIHN0YXRlQ29sb3I6IHN0YXRlQ29sb3IgfSxcbiAgICAgICAgeyB0eXBlOiBcIm5vcm1hbFwiLCBuYW1lOiAkaTE4bi5uX3NoYXJrX2Zpbl9wcm9kdWN0LCB2YWx1ZTogXCJcIiwgc3RhdGU6IGNhbGxQdXRUZXh0LCB0aXBzU2hvdzogXCJnb25lXCIsIHN0YXRlQ29sb3I6IFwiQGNvbG9yL2tDb2xvclByaW1hcnlUZXh0XCIgfSxcbiAgICAgICAgeyB0eXBlOiBcIm5vcm1hbFwiLCBuYW1lOiBBUFlFc3QsIHZhbHVlOiBBUFlFc3RWYWx1ZSwgc3RhdGU6IFwiXCIsIHRpcHNTaG93OiBcImdvbmVcIiwgc3RhdGVDb2xvcjogXCJAY29sb3Iva0NvbG9yUHJpbWFyeVRleHRcIiB9LFxuICAgICAgICB7IHR5cGU6IFwibm9ybWFsXCIsIG5hbWU6ICRpMThuLm5fbWluaW5nX2R1cmF0aW9uLCB2YWx1ZTogYCR7ZGF0YS50ZXJtfSAkeyRpMThuLm5fbWluaW5nX2RheV90ZXh0fWAsIHN0YXRlOiBcIlwiLCB0aXBzU2hvdzogXCJnb25lXCIsIHN0YXRlQ29sb3I6IFwiQGNvbG9yL2tDb2xvclByaW1hcnlUZXh0XCIgfSxcbiAgICAgICAgeyB0eXBlOiBcIm5vcm1hbFwiLCBuYW1lOiAkaTE4bi5uX21pbmluZ19lbmRfdGltZSwgdmFsdWU6IGV4cGlyeVRpbWUsIHN0YXRlOiBcIlwiLCB0aXBzU2hvdzogXCJnb25lXCIsIHN0YXRlQ29sb3I6IFwiQGNvbG9yL2tDb2xvclByaW1hcnlUZXh0XCIgfSxcbiAgICBdO1xuICAgIG1vZHVsZURhdGEuc3Vic2NyaWJlRW5kVGltZSA9IGRhdGEuc3Vic2NyaWJlRW5kVGltZTtcbn1cblxuLy8gdmlld1N0YXR1cyDkuqflk4HnirbmgIHvvJowLeacquW8gOWni++8mzEt5Yuf6LWE5Lit77ybMi3otZrluIHkuK3vvJszLeW3suWIsOacn1xuZnVuY3Rpb24gaGFuZGxlU3RhdHVzKHN0YXR1cykge1xuICAgIHZhciB2YWx1ZSA9ICRpMThuLm5fc2hhcmtfZmluX29ycGhhbjtcbiAgICBzd2l0Y2ggKHN0YXR1cykge1xuICAgICAgICBjYXNlIDA6XG4gICAgICAgICAgICB2YWx1ZSA9ICRpMThuLm5fc2hhcmtfZmluX29ycGhhbjsgXG4gICAgICAgICAgICBicmVhaztcbiAgICAgICAgY2FzZSAxOlxuICAgICAgICAgICAgdmFsdWUgPSAkaTE4bi5uX3NoYXJrX2Zpbl9vcnBoYW47XG4gICAgICAgICAgICBicmVhaztcbiAgICAgICAgY2FzZSAyOlxuICAgICAgICAgICAgdmFsdWUgPSAkaTE4bi5uX3NoYXJrX2Zpbl9lYXJuaW5nO1xuICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgIGNhc2UgMzpcbiAgICAgICAgICAgIHZhbHVlID0gJGkxOG4ubl9zaGFya19maW5fZXhwaXJlZDtcbiAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICBkZWZhdWx0OlxuICAgICAgICAgICAgYnJlYWs7XG4gICAgfVxuICAgIHJldHVybiB2YWx1ZTtcbn1cblxuZnVuY3Rpb24gc2hvd0RldGFpbEVtcHR5KGlzRW1wdHkpIHtcbiAgICBtb2R1bGVEYXRhLmVtcHR5ID0gaXNFbXB0eSA/IFwidmlzaWJsZVwiIDogXCJnb25lXCI7XG4gICAgbW9kdWxlRGF0YS5ub3RFbXB0eSA9IGlzRW1wdHkgPyBcImdvbmVcIiA6IFwidmlzaWJsZVwiO1xufVxuXG5mdW5jdGlvbiByZWxvYWREYXRhKCkge1xuICAgIG1vZHVsZURhdGEuZW1wdHkgPSBcImdvbmVcIjtcbiAgICBtb2R1bGVEYXRhLm5vdEVtcHR5ID0gXCJnb25lXCI7XG4gICAgbW9kdWxlRGF0YS5vcmRlclNob3cgPSBcImdvbmVcIjtcbiAgICAkZGF0YS5hbGVydC5hbGVydFBvcFNob3cgPSBcImZhbHNlXCI7XG4gICAgbW9kdWxlRGF0YS5jZWxsbGlzdCA9IFtdO1xufVxuXG5tb2R1bGVFdmVudC5zdGF0dXNBbGVydCA9IGZ1bmN0aW9uICgpIHtcbiAgICBpZiAodmlld1N0YXR1cyA9PSAzKSB7XG4gICAgICAgICRkYXRhLmFsZXJ0LmNvbnRlbnQgPSAkaTE4bi5uX3NoYXJrX2Zpbl9hbGVydF9leHBpcmVkO1xuICAgIH0gZWxzZSBpZiAodmlld1N0YXR1cyA9PSAyKSB7XG4gICAgICAgICRkYXRhLmFsZXJ0LmNvbnRlbnQgPSAkaTE4bi5uX3NoYXJrX2Zpbl9hbGVydF9lYXJuaW5nO1xuICAgIH0gZWxzZSB7XG4gICAgICAgIGNvbnN0IHN1YnNjcmliZUVuZFRpbWUgPSBuZXcgRGF0ZShtb2R1bGVEYXRhLnN1YnNjcmliZUVuZFRpbWUpLkZvcm1hdChcInl5eXkvTU0vZGQgaGg6bW06c3NcIik7XG4gICAgICAgICRkYXRhLmFsZXJ0LmNvbnRlbnQgPSAkaTE4bi4kaW50ZXJjZXB0Lm5fc2hhcmtfZmluX2FsZXJ0X29ycGhhbihzdWJzY3JpYmVFbmRUaW1lKTtcbiAgICB9XG4gICAgJGRhdGEuYWxlcnQuYWxlcnRQb3BTaG93ID0gXCJ0cnVlXCI7XG4gICAgY29tbW9uLmFuYWx5dGljcyhcImFwcF9lYXJuX3NoYWtlRmluX29yZGVyRGV0YWlsX3N0YXRlRXhwbGFuYXRpb25fY2xpY2tcIik7XG59XG5cblxuZnVuY3Rpb24gYmFja0NsaWNrZWQoKSB7XG4gICAgaWYgKG1vZHVsZURhdGEudHlwZSA9PSBcIm9yZGVyXCIpIHtcbiAgICAgICAgY29tbW9uLmFuYWx5dGljcyhcImFwcF9lYXJuX3NoYWtlRmluX29yZGVyRGV0YWlsX3JldHVybkJ1dHRvbl9jbGlja1wiKTtcbiAgICB9XG4gICAgZGVwb3NpdC50b0JhY2soKTtcbn1cblxuZnVuY3Rpb24gY2hhbmdlU3dpdGNoUmVtYXJrKGNvZGUsIHJlbWFyaykge1xuICBpZiAoY29kZSA9PSAxKSB7XG4gICAgbW9kdWxlRGF0YS5yZXN1bHRSZW1hcmsgPSAkaTE4bi5uX3NoYXJrX2Zpbl9hdXRvU3Vic2NyaWJlX3Jlc3VsdF8xO1xuICAgIG1vZHVsZURhdGEucmVzdWx0Q29sb3IgPSBcIkBjb2xvci9rQ29sb3JQcmljZVJlZFwiO1xuICB9IGVsc2UgaWYgKGNvZGUgPT0gMikge1xuICAgIG1vZHVsZURhdGEucmVzdWx0UmVtYXJrID0gJGkxOG4ubl9zaGFya19maW5fYXV0b1N1YnNjcmliZV9yZXN1bHRfMjtcbiAgICBtb2R1bGVEYXRhLnJlc3VsdENvbG9yID0gXCJAY29sb3Iva0NvbG9yUHJpY2VSZWRcIjtcbiAgfSBlbHNlIGlmIChjb2RlID09IDMpIHtcbiAgICBtb2R1bGVEYXRhLnJlc3VsdFJlbWFyayA9ICRpMThuLm5fc2hhcmtfZmluX2F1dG9TdWJzY3JpYmVfcmVzdWx0XzM7XG4gICAgbW9kdWxlRGF0YS5yZXN1bHRDb2xvciA9IFwiQGNvbG9yL2tDb2xvclByaWNlUmVkXCI7XG4gIH0gZWxzZSBpZiAoY29kZSA9PSA0KSB7XG4gICAgbW9kdWxlRGF0YS5yZXN1bHRSZW1hcmsgPSAkaTE4bi5uX3NoYXJrX2Zpbl9hdXRvU3Vic2NyaWJlX3Jlc3VsdF80O1xuICAgIG1vZHVsZURhdGEucmVzdWx0Q29sb3IgPSBcIkBjb2xvci9rQ29sb3JQcmljZVJlZFwiO1xuICB9IGVsc2UgaWYgKGNvZGUgPT0gNSkge1xuICAgIG1vZHVsZURhdGEucmVzdWx0UmVtYXJrID0gJGkxOG4ubl9zaGFya19maW5fYXV0b1N1YnNjcmliZV9yZXN1bHRfNTtcbiAgICBtb2R1bGVEYXRhLnJlc3VsdENvbG9yID0gXCJAY29sb3Iva0NvbG9yUHJpY2VSZWRcIjtcbiAgfSBlbHNlIHtcbiAgICBtb2R1bGVEYXRhLnJlc3VsdFJlbWFyayA9ICRpMThuLm5fc2hhcmtfZmluX2F1dG9TdWJzY3JpYmVfZGVzYztcbiAgICBtb2R1bGVEYXRhLnJlc3VsdENvbG9yID0gXCJAY29sb3Iva0NvbG9yVGhyZWVMZXZlbFRleHRcIjtcbiAgfVxuICBpZiAocmVtYXJrICYmIHJlbWFyayAhPSBudWxsKSB7XG4gICAgbW9kdWxlRGF0YS5yZXN1bHRSZW1hcmsgPSByZW1hcms7XG4gIH1cbn1cblxuZnVuY3Rpb24gY2hhbmdlU3dpdGNoU3RhdHVzKCkge1xuICBpZiAoYXV0b1N1YnNjcmliZSA9PSAwKSB7XG4gICAgbW9kdWxlRGF0YS5zd2l0Y2hDb2xvciA9IFwiQGNvbG9yL0tCYXNlQ29sb3JDb250ZW50QmFja2dyb3VuZFwiO1xuICAgIG1vZHVsZURhdGEuc3dpdGNoQmFja0NvbG9yID0gXCJAY29sb3IvZUJ1dHRvblVuZW5hYmxlZEJnQ29sb3JcIjtcbiAgICBtb2R1bGVEYXRhLnN3aXRjaFdpZHRoID0gXCIyXCI7XG4gIH0gZWxzZSB7XG4gICAgbW9kdWxlRGF0YS5zd2l0Y2hDb2xvciA9IFwiQGNvbG9yL0tCYXNlQ29sb3JDb250ZW50QmFja2dyb3VuZFwiO1xuICAgIG1vZHVsZURhdGEuc3dpdGNoQmFja0NvbG9yID0gXCJAY29sb3IvYmFzZUNvbG9yTWFqb3JUaGVtZTEwMFwiO1xuICAgIG1vZHVsZURhdGEuc3dpdGNoV2lkdGggPSBcIjE0XCI7XG4gIH1cbiAgbW9kdWxlRGF0YS5zd2l0Y2hPcGFjaXR5ID0gYXV0b1N1YnNjcmliZVN0YXRlID09IDAgPyBcIjAuMlwiIDogXCIxXCI7XG59XG5cbm1vZHVsZUV2ZW50LmF1dG9DbGlja2VkID0gYXN5bmMgZnVuY3Rpb24gKCkge1xuICBpZiAoYXV0b1N1YnNjcmliZVN0YXRlID09IDApIHtcbiAgICByZXR1cm47XG4gIH1cbiAgY29uc3QgcGFyYW0gPSB7XG4gICAgb3JkZXJJZDogYXV0b09yZGVySWQsXG4gICAgYXV0b1N1YnNjcmliZTogYXV0b1N1YnNjcmliZSA9PSAwID8gMSA6IDBcbiAgfTtcbiAgY29tbW9uLnNob3dMb2FkaW5nKHRydWUpO1xuICBjb25zdCBkYXRhID0gYXdhaXQgY29tbW9uLnNlbmRSZXF1ZXN0KFwidjQvc2F2aW5nL21pbmluZy9zaGFyay9jb25maWcvYXV0b1N1YnNjcmliZVwiLCBwYXJhbSwgMSwgMCwgeyBcIkNvbnRlbnQtVHlwZVwiOiBcImFwcGxpY2F0aW9uL2pzb25cIiB9KTtcbiAgY29tbW9uLnNob3dMb2FkaW5nKGZhbHNlKTtcbiAgY29uc29sZS5sb2coSlNPTi5zdHJpbmdpZnkoZGF0YSkpO1xuICBpZiAoZGF0YSAmJiBkYXRhICE9IG51bGwpIHtcbiAgICBhdXRvU3Vic2NyaWJlID0gZGF0YS5hdXRvU3Vic2NyaWJlO1xuICAgIGF1dG9TdWJzY3JpYmVTdGF0ZSA9IGRhdGEuYXV0b1N1YnNjcmliZVN0YXRlO1xuICAgIGNvbnN0IHJlc3VsdENvZGUgPSBkYXRhLmF1dG9TdWJzY3JpYmVSZXN1bHRDb2RlO1xuICAgIGNvbnN0IHJlc3VsdFJlbWFyayA9IGRhdGEuYXV0b1N1YnNjcmliZVJlc3VsdFJlbWFyaztcbiAgICBjaGFuZ2VTd2l0Y2hTdGF0dXMoKTtcbiAgICBjaGFuZ2VTd2l0Y2hSZW1hcmsocmVzdWx0Q29kZSwgcmVzdWx0UmVtYXJrKTtcbiAgfVxufVxuXG5tb2R1bGVFdmVudC5iYWNrQ2xpY2tlZCA9IGJhY2tDbGlja2VkO1xuXG4vLyBUT0RPXG4vLyByZXF1ZXN0T3JkZXJEZXRhaWwoMTY3ODU1NDM0MTk3OCk7XG4iLCIvLyDot6/nlLHvvJpob2xpZ2VpdDovL29wZW4vdjE/bG9naW49MSZ1cmw9aWh1b2JpZ2xvYmFsOi8vbS5oYmcuY29tL2VkZ2VlbmdpbmUvY29udGFpbmVyP3NjZW5lPXNoYXJrZmluJnJvb3ROYW1lPWludHJvZHVjZSZuYXZDb25maWc9bmF0aXZlXG5pbXBvcnQgKiBhcyBjb21tb24gZnJvbSBcIi4vY29tbW9uXCI7XG5cbmZ1bmN0aW9uIGdldE5hdkNvbmZpZ1N0cmluZygpIHtcbiAgICBsZXQgbmF2ID0ge1xuICAgICAgICAndGl0bGVLZXknOiAnbl9zaGFya19maW5faW50cm9kdWNlJyxcbiAgICAgICAgJ2xlZnQnOiB7XG4gICAgICAgICAgICAnYWN0aW9uJzoge1xuICAgICAgICAgICAgICAgICd0eXBlJzogJ2JhY2snLFxuICAgICAgICAgICAgICAgICdwYXJhbWV0ZXInOiAnJ1xuICAgICAgICAgICAgfSxcbiAgICAgICAgICAgICdpY29uJzogJ2VkZ2VfZW5naW5lX3RvcF9iYXJfYmFja19ub3JtYWwnXG4gICAgICAgIH1cbiAgICB9O1xuICAgIHJldHVybiBuYXY7XG59XG5cbmZ1bmN0aW9uIGRlZmF1bHREYXRhKCkge1xuXG4gICAgcmV0dXJuIHtcbiAgICAgICAgY3VycmVudFRhZzogMCxcbiAgICAgICAgY3VycmVudEluZGV4OiAwLFxuICAgICAgICB0aXRsZURhdGE6IFtcbiAgICAgICAgICAgIHtcbiAgICAgICAgICAgICAgICAndGl0bGUnOiAkaTE4bi5uX3NoYXJrX2Zpbl9wcm9kdWN0X3J1bGUsXG4gICAgICAgICAgICAgICAgJ3RpdGxlU2l6ZSc6ICcxNCcsXG4gICAgICAgICAgICAgICAgJ3RpdGxlQ29sb3InOiAnQGNvbG9yL2tDb2xvclByaW1hcnlUZXh0JyxcbiAgICAgICAgICAgICAgICAndGFnJzogJzAnXG5cbiAgICAgICAgICAgIH0sXG4gICAgICAgICAgICB7XG4gICAgICAgICAgICAgICAgJ3RpdGxlJzogJGkxOG4ubl9zaGFya19maW5fY29tbW9uX3Byb2JsZW0sXG4gICAgICAgICAgICAgICAgJ3RpdGxlU2l6ZSc6ICcxNCcsXG4gICAgICAgICAgICAgICAgJ3RpdGxlQ29sb3InOiAnQGNvbG9yL2tDb2xvclNlY29uZGFyeVRleHQnLFxuICAgICAgICAgICAgICAgICd0YWcnOiAnMSdcbiAgICAgICAgICAgIH1cbiAgICAgICAgXSxcbiAgICAgICAgc2xpZGVyRGF0YTogW3tcbiAgICAgICAgICAgIFwibGlzdFR5cGVcIjogJzEnLFxuICAgICAgICB9LCB7XG4gICAgICAgICAgICBcImxpc3RUeXBlXCI6ICcyJyxcbiAgICAgICAgfV0sXG5cbiAgICAgICAgcHJvYmxlbXMxT3BlbjondmlzaWJsZScsXG4gICAgICAgIHByb2JsZW1zMUNsb3NlOidnb25lJyxcblxuICAgICAgICBwcm9ibGVtczJPcGVuOidnb25lJyxcbiAgICAgICAgcHJvYmxlbXMyQ2xvc2U6J3Zpc2libGUnLFxuXG4gICAgICAgIHByb2JsZW1zM09wZW46J2dvbmUnLFxuICAgICAgICBwcm9ibGVtczNDbG9zZTondmlzaWJsZScsXG5cbiAgICAgICAgcHJvYmxlbXM0T3BlbjonZ29uZScsXG4gICAgICAgIHByb2JsZW1zNENsb3NlOid2aXNpYmxlJyxcblxuICAgICAgICBwcm9ibGVtczVPcGVuOidnb25lJyxcbiAgICAgICAgcHJvYmxlbXM1Q2xvc2U6J3Zpc2libGUnLFxuXG4gICAgICAgIHByb2JsZW1zNk9wZW46J2dvbmUnLFxuICAgICAgICBwcm9ibGVtczZDbG9zZTondmlzaWJsZScsXG5cbiAgICAgICAgcHJvYmxlbXM2MU9wZW46J2dvbmUnLFxuICAgICAgICBwcm9ibGVtczYxQ2xvc2U6J3Zpc2libGUnLFxuXG4gICAgICAgIHByb2JsZW1zN09wZW46J2dvbmUnLFxuICAgICAgICBwcm9ibGVtczdDbG9zZTondmlzaWJsZScsXG5cbiAgICAgICAgcHJvYmxlbXM4T3BlbjonZ29uZScsXG4gICAgICAgIHByb2JsZW1zOENsb3NlOid2aXNpYmxlJyxcblxuICAgICAgICBwcm9ibGVtczlPcGVuOidnb25lJyxcbiAgICAgICAgcHJvYmxlbXM5Q2xvc2U6J3Zpc2libGUnLFxuXG4gICAgfVxufVxuXG5cbmNvbnN0IHsgbW9kdWxlRGF0YSwgbW9kdWxlRXZlbnQgfSA9IGNvbW1vbi5tb2R1bGVEZWZpbmUoXCJpbnRyb2R1Y2VcIiwgZGVmYXVsdERhdGEsIHsgb25DcmVhdGUgfSk7XG5cbmZ1bmN0aW9uIG9uQ3JlYXRlKHBhcmFtKSB7XG4gICAgY29uc29sZS5sb2coJ2ludHJvZHVjZSBvbiBjcmVhdGUnKTtcbiAgICBjb25zb2xlLmxvZyhwYXJhbSk7XG4gICAgbW9kdWxlRGF0YS5uYXZDb25maWcgPSBnZXROYXZDb25maWdTdHJpbmcoKTtcbiAgICBsZXQgcGFyYW1EaWMgPSBKU09OLnBhcnNlKHBhcmFtKTtcbiAgICBsZXQgaW5kZXggPSBwYXJzZUludChwYXJhbURpY1snaW5kZXgnXSk7XG4gICAgY29uc29sZS5sb2coaW5kZXgpO1xuICAgIGNvbnNvbGUubG9nKHBhcnNlSW50KGluZGV4KSk7XG4gICAgaWYgKGluZGV4ID09IHVuZGVmaW5lZCB8fCBpc05hTihpbmRleCkpIHtcbiAgICAgICAgaW5kZXggPSAwO1xuICAgIH0gXG4gICAgbW9kdWxlRXZlbnQudGFiQ2xpY2soaW5kZXgpO1xufVxuXG5cblxuZnVuY3Rpb24gcmVzZXRUaXRsZXNTdHlsZShpZHgpIHtcbiAgICBmb3IgKGxldCBpID0gMDsgaSA8IG1vZHVsZURhdGEudGl0bGVEYXRhLmxlbmd0aDsgaSsrKSB7XG4gICAgICAgIHZhciBvYmogPSAgbW9kdWxlRGF0YS50aXRsZURhdGFbaV07XG4gICAgICAgIG9iai50aXRsZVNpemU9JzE0JztcbiAgICAgICAgb2JqLnRpdGxlQ29sb3IgPSAnQGNvbG9yL2tDb2xvclNlY29uZGFyeVRleHQnO1xuICAgIH1cbiAgIHZhciBjdXIgPSAgbW9kdWxlRGF0YS50aXRsZURhdGFbaWR4XTtcbiAgIGN1ci50aXRsZUNvbG9yID0gJ0Bjb2xvci9rQ29sb3JQcmltYXJ5VGV4dCc7XG59XG5cbm1vZHVsZUV2ZW50Lm9wZW5PckNsb3NlUHJvYmxlbSA9ICBmdW5jdGlvbiAoaW5kZXgpIHtcbiAgIGxldCB2aXNpYmxlID0gbW9kdWxlRGF0YVtgcHJvYmxlbXMke2luZGV4fU9wZW5gXTtcbiAgIGlmICh2aXNpYmxlID09ICd2aXNpYmxlJykge1xuICAgICAgICBtb2R1bGVEYXRhW2Bwcm9ibGVtcyR7aW5kZXh9Q2xvc2VgXSA9IHZpc2libGU7XG4gICAgICAgIHZpc2libGUgPSAnZ29uZSdcbiAgIH0gZWxzZSB7XG4gICAgICAgIG1vZHVsZURhdGFbYHByb2JsZW1zJHtpbmRleH1DbG9zZWBdID0gdmlzaWJsZTtcbiAgICAgICAgdmlzaWJsZSA9ICd2aXNpYmxlJ1xuICAgfVxuICAgbW9kdWxlRGF0YVtgcHJvYmxlbXMke2luZGV4fU9wZW5gXSA9IHZpc2libGU7XG59XG5cbm1vZHVsZUV2ZW50LnRhYkNsaWNrID0gZnVuY3Rpb24gKGlkeCkge1xuICAgIHJlc2V0VGl0bGVzU3R5bGUoaWR4KTtcbiAgICBtb2R1bGVEYXRhLmN1cnJlbnRJbmRleCA9IGAke2lkeH1gO1xufVxuXG5tb2R1bGVFdmVudC5yZXNldFRpdGxlU2VsZWN0VGFiID0gZnVuY3Rpb24gKGlkeCkge1xuICAgIHJlc2V0VGl0bGVzU3R5bGUoaWR4KTtcbn1cblxuIiwiaW1wb3J0ICogYXMgY29tbW9uIGZyb20gXCIuL2NvbW1vblwiXG5pbXBvcnQgKiBhcyBudW1iZXIgZnJvbSBcIi4vbnVtYmVyXCI7XG5cbnZhciB0YWJLZXkgPSBcIlwiO1xuXG5mdW5jdGlvbiBkZWZhdWx0RGF0YSgpIHtcbiAgcmV0dXJuIHtcbiAgICBxdWVzdGlvbkxpc3Q6IGNyZWF0ZVF1ZXN0aW9uTGlzdCgpLFxuICB9O1xufVxuXG5mdW5jdGlvbiBjcmVhdGVRdWVzdGlvbkxpc3QoKSB7XG4gIHZhciBzaXhBU3RyaW5nID0gJGkxOG4ubl9zaGFya19maW5fY29tbW9uX2Fuc3dlcl9zaXhfYV9maXJzdF9uZXcgKyBcIiBcXG4gXFxuXCIgKyAkaTE4bi5uX3NoYXJrX2Zpbl9jb21tb25fYW5zd2VyX3NpeF9hX3NlY29uZF9uZXc7XG4gIHZhciBzZXZlblN0cmluZyA9ICRpMThuLm5fc2hhcmtfZmluX2NvbW1vbl9hbnN3ZXJfc2V2ZW5fYV9maXJzdCArIFwiIFxcbiBcXG5cIiArICRpMThuLm5fc2hhcmtfZmluX2NvbW1vbl9hbnN3ZXJfc2V2ZW5fYV9zZWNvbmQgKyBcIiBcXG4gXFxuXCIgKyAkaTE4bi5uX3NoYXJrX2Zpbl9jb21tb25fYW5zd2VyX3NldmVuX2FfdGhpcmQgKyBcIiBcXG4gXFxuXCIgKyAkaTE4bi5uX3NoYXJrX2Zpbl9jb21tb25fYW5zd2VyX3NldmVuX2FfZm91ciArIFwiIFxcbiBcXG5cIiArICRpMThuLm5fc2hhcmtfZmluX2NvbW1vbl9hbnN3ZXJfc2V2ZW5fc2Vjb25kICsgXCIgXFxuIFxcblwiICsgJGkxOG4ubl9zaGFya19maW5fY29tbW9uX2Fuc3dlcl9zZXZlbl90aGlyZDtcblxuICB2YXIgcXVlc3Rpb25MaXN0ID0gW1xuICAgIHsgY2VsbFR5cGU6IFwibm9ybWFsXCIsIHE6ICRpMThuLm5fc2hhcmtfZmluX2NvbW1vbl9wcm9ibGVtX29uZSwgYTogJGkxOG4ubl9zaGFya19maW5fY29tbW9uX2Fuc3dlcl9vbmUsIGFuc3dlclZpc2FibGU6IFwiZ29uZVwiLCBxYUljb246XCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfc2hhcmtfaG9tZV9xYV9zcHJlYWRfaWNvblwifSxcbiAgICB7IGNlbGxUeXBlOiBcIm5vcm1hbFwiLCBxOiAkaTE4bi5uX3NoYXJrX2Zpbl9jb21tb25fcHJvYmxlbV90d28sIGE6ICRpMThuLm5fc2hhcmtfZmluX2NvbW1vbl9hbnN3ZXJfdHdvX25ldywgYW5zd2VyVmlzYWJsZTogXCJnb25lXCIsIHFhSWNvbjpcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9zaGFya19ob21lX3FhX3NwcmVhZF9pY29uXCIgfSxcbiAgICB7IGNlbGxUeXBlOiBcIm5vcm1hbFwiLCBxOiAkaTE4bi5uX3NoYXJrX2Zpbl9jb21tb25fcHJvYmxlbV90aHJlZSwgYTogJGkxOG4ubl9zaGFya19maW5fY29tbW9uX2Fuc3dlcl90aHJlZSwgYW5zd2VyVmlzYWJsZTogXCJnb25lXCIsIHFhSWNvbjpcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9zaGFya19ob21lX3FhX3NwcmVhZF9pY29uXCJ9LFxuICAgIHsgY2VsbFR5cGU6IFwibm9ybWFsXCIsIHE6ICRpMThuLm5fc2hhcmtfZmluX2NvbW1vbl9wcm9ibGVtX2ZvdXIsIGE6ICRpMThuLm5fc2hhcmtfZmluX2NvbW1vbl9hbnN3ZXJfZm91cl9jLCBhbnN3ZXJWaXNhYmxlOiBcImdvbmVcIiwgcWFJY29uOlwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX3NoYXJrX2hvbWVfcWFfc3ByZWFkX2ljb25cIn0sXG4gICAgeyBjZWxsVHlwZTogXCJub3JtYWxcIiwgcTogJGkxOG4ubl9zaGFya19maW5fY29tbW9uX3Byb2JsZW1fZml2ZV9uZXcsIGE6ICRpMThuLm5fc2hhcmtfZmluX2NvbW1vbl9hbnN3ZXJfZml2ZV9uZXdfYywgYW5zd2VyVmlzYWJsZTogXCJnb25lXCIsIHFhSWNvbjpcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9zaGFya19ob21lX3FhX3NwcmVhZF9pY29uXCJ9LFxuICAgIHsgY2VsbFR5cGU6IFwibm9ybWFsXCIsIHE6ICRpMThuLm5fc2hhcmtfZmluX2NvbW1vbl9wcm9ibGVtX3NpeCwgYTogJGkxOG4ubl9zaGFya19maW5fY29tbW9uX2Fuc3dlcl9zaXgsIGFuc3dlclZpc2FibGU6IFwiZ29uZVwiLCBxYUljb246XCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfc2hhcmtfaG9tZV9xYV9zcHJlYWRfaWNvblwifSxcbiAgICB7IGNlbGxUeXBlOiBcIm5vcm1hbFwiLCBxOiAkaTE4bi5uX3NoYXJrX2Zpbl9jb21tb25fcHJvYmxlbV9zaXhfYSwgYTogc2l4QVN0cmluZywgYW5zd2VyVmlzYWJsZTogXCJnb25lXCIsIHFhSWNvbjpcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9zaGFya19ob21lX3FhX3NwcmVhZF9pY29uXCJ9LFxuICAgIHsgY2VsbFR5cGU6IFwibm9ybWFsXCIsIHE6ICRpMThuLm5fc2hhcmtfZmluX2NvbW1vbl9wcm9ibGVtX3NldmVuLCBhOiBzZXZlblN0cmluZywgYW5zd2VyVmlzYWJsZTogXCJnb25lXCIsIHFhSWNvbjpcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9zaGFya19ob21lX3FhX3NwcmVhZF9pY29uXCJ9LFxuICAgIHsgY2VsbFR5cGU6IFwibm9ybWFsXCIsIHE6ICRpMThuLm5fc2hhcmtfZmluX2NvbW1vbl9wcm9ibGVtX2VpZ2h0LCBhOiAkaTE4bi5uX3NoYXJrX2Zpbl9jb21tb25fYW5zd2VyX2VpZ2h0X25ld19jLCBhbnN3ZXJWaXNhYmxlOiBcImdvbmVcIiwgcWFJY29uOlwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX3NoYXJrX2hvbWVfcWFfc3ByZWFkX2ljb25cIn0sXG4gICAgeyBjZWxsVHlwZTogXCJub3JtYWxcIiwgcTogJGkxOG4ubl9zaGFya19maW5fY29tbW9uX3Byb2JsZW1fbmluZSwgYTogJGkxOG4ubl9zaGFya19maW5fY29tbW9uX2Fuc3dlcl9uaW5lX25ldywgYW5zd2VyVmlzYWJsZTogXCJnb25lXCIsIHFhSWNvbjpcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9zaGFya19ob21lX3FhX3NwcmVhZF9pY29uXCJ9LFxuICBdXG5cbiAgcXVlc3Rpb25MaXN0LmZvckVhY2goKGVsZW1lbnQsIGluZGV4KSAgPT4ge1xuICAgIGVsZW1lbnQuaW5kZXggPSBpbmRleDtcbiAgfSk7XG5cbiAgcmV0dXJuIHF1ZXN0aW9uTGlzdDtcbn1cblxuY29uc3QgeyBtb2R1bGVEYXRhLCBtb2R1bGVFdmVudCB9ID0gY29tbW9uLm1vZHVsZURlZmluZShcImhvbWVcIiwgZGVmYXVsdERhdGEsIHsgb25DcmVhdGUsIG9uRGVzdHJveSwgb25SZXN1bWUsIG9uUGF1c2UsIG9uU3RhcnQsIG9uU3RvcCB9KTtcblxuZnVuY3Rpb24gb25DcmVhdGUoZXZlbnRQYXJhbXMpIHtcbiAgY29uc29sZS5sb2coJ2hvbWUgb25DcmVhdGUnKTtcbiAgbW9kdWxlRGF0YS5zdGF0dXNCYXJDb25maWcgPSB7IFwic3RhdHVzQmFyTW9kZVwiOiBcImZhbHNlXCIgfTtcbiAgbW9kdWxlRGF0YS5pc0luaXQgPSBmYWxzZTtcbiAgbW9kdWxlRGF0YS5pc0ZpcnN0ID0gdHJ1ZTtcbiAgbW9kdWxlRGF0YS50aW1lck9iamVjdCA7XG4gIG1vZHVsZURhdGEuc3RhdHVzSGVpZ2h0ID0gY29tbW9uLmNvbW1vbkRhdGEuc3RhdHVzSGVpZ2h0O1xuICBpZiAodGFiS2V5Lmxlbmd0aCA9PSAwICYmIGV2ZW50UGFyYW1zICYmIGV2ZW50UGFyYW1zICE9IG51bGwpIHtcbiAgICBjb25zdCBwYXJhbXMgPSBKU09OLnBhcnNlKGV2ZW50UGFyYW1zKTtcbiAgICB0YWJLZXkgPSBwYXJhbXMudGFiS2V5ID8gcGFyYW1zLnRhYktleSA6IFwiXCI7XG4gIH1cbiAgcmVxdWVzdFNoYXJrSG9tZURhdGEoKTtcbn1cblxuZnVuY3Rpb24gb25EZXN0cm95KCkge1xufVxuXG5hc3luYyBmdW5jdGlvbiBvblJlc3VtZSgpIHtcbiAgY29uc29sZS5sb2coJ2hvbWUgb25SZXN1bWUnKTtcbiAgc3RhcnRUaW1lcigpO1xuICBpZighbW9kdWxlRGF0YS5pc0ZpcnN0KSB7XG4gICAgcmVxdWVzdFNoYXJrSG9tZURhdGEoKTtcbiAgfVxuICBtb2R1bGVEYXRhLmlzRmlyc3QgPSBmYWxzZTtcbn1cblxuZnVuY3Rpb24gb25QYXVzZSgpIHtcbiAgY29uc29sZS5sb2coJ2hvbWUgb25QYXVzZScpO1xuICBjbGVhclRpbWVyKCk7XG59XG5cbmZ1bmN0aW9uIG9uU3RhcnQoKSB7XG4gIGNvbW1vbi5hbmFseXRpY3MoXCJhcHBfZWFybl9zaGFrZUZpblByb2R1Y3Rfdmlld1wiKTtcbn1cblxuZnVuY3Rpb24gb25TdG9wKCkge1xufVxuXG4vLyBpZFx0XHRcdFx0XHRcdFx0XHRcdFx0XHRcdFx0aWRcbi8vIHF1b3RlQ3VycmVuY3lcdFx0XHRcdFx0XHRcdOiuoeS7t+W4geenjVxuLy8gdmlld1N0YXR1c1x0XHRcdFx0XHRcdFx0XHRcdDAt5pyq5byA5aeL77ybMS3lvoXnoa7orqTvvJsyLei1muW4geS4re+8mzMt5bey5Yiw5pyfXG4vLyBzdGFydFRpbWVcdFx0XHRcdFx0XHRcdFx0XHTpobnnm67lvIDlp4vml7bpl7Rcbi8vIGVuZFRpbWVcdFx0XHRcdFx0XHRcdFx0XHRcdOmhueebrue7k+adn+aXtumXtFxuLy8gc3Vic2NyaWJlU3RhcnRUaW1lXHRcdFx0ICBcdOeUs+i0reW8gOWni+aXtumXtFxuLy8gc3Vic2NyaWJlRW5kVGltZVx0XHRcdFx0XHRcdOeUs+i0ree7k+adn+aXtumXtFxuLy8gdG90YWxMaW1pdFx0XHRcdFx0XHRcdFx0XHRcdOWLn+i1hOS4iumZkFxuLy8gZmluaXNoQW1vdW50XHRcdFx0XHRcdFx0XHQgIOW3suWLn+i1hOmHkeminVxuLy8gcHJvamVjdHNcdFx0XHRcdFx0XHRcdFx0XHRcdOeci+a2qOeci+i3jOmhueebruWIl+ihqFtPQkpFQ1RdXG4vLyBcdFx0XHRpZFx0XHRcdFx0XHRcdFx0XHRcdFx0aWRcbi8vIFx0XHRcdGN1cnJlbmN5XHRcdFx0XHRcdFx0XHTmoIfnmoTluIHnp43vvIhidGMvZXRoLi4u77yJXG4vLyBcdFx0XHRjYWxsUHV0XHRcdFx0XHRcdFx0XHRcdOeci+a2qOeci+i3jDogLTEtcHV06LeMLCAxLWNhbGzmtqhcbi8vIFx0XHRcdHRlcm1cdFx0XHRcdFx0XHRcdFx0XHTpobnnm67lkajmnJ/vvIjlpKnvvIlcbi8vIFx0XHRcdHNldHRsZVRpbWVcdFx0XHRcdFx0XHRlcG9jaE1zIOWPquWxleekuuWIsOWkqe+8jOWmgjIwMjMvMDYvMDJcbi8vIFx0XHRcdG1pblJhdGVcdFx0XHRcdFx0XHRcdCAg5pyA5bCP5bm05YyW5pS255uKXG4vLyBcdFx0XHRtYXhSYXRlXHRcdFx0XHRcdFx0XHQgIOacgOWkp+W5tOWMluaUtuebilxuLy8gXHRcdFx0ZmluaXNoQW1vdW50XHRcdFx0XHQgIOW3suWLn+i1hOmHkeminVxuLy8gXHRcdFx0c2V0dGxlSW5jb21lQW1vdW50XHRcdOe7k+eul+WIqeaBr1xuLy8gc1RpbWVcdFx0XHRcdFx0XHRcdFx0XHRcdCAg5b2T5YmN5pyN5Yqh5Zmo5pe26Ze0XG5hc3luYyBmdW5jdGlvbiByZXF1ZXN0U2hhcmtIb21lRGF0YSgpIHtcbiAgY29tbW9uLnNob3dMb2FkaW5nKHRydWUpO1xuICBjb25zdCBkYXRhID0gYXdhaXQgY29tbW9uLnNlbmRSZXF1ZXN0KCd2NC9zYXZpbmcvbWluaW5nL3NoYXJrJywgeyB0YWJLZXkgfSk7XG4gIGNvbW1vbi5zaG93TG9hZGluZyhmYWxzZSk7XG4gIHNoYXJrVGFiS2V5KGRhdGEpO1xuICBzaGFya0hvbWVEYXRhKGRhdGEpO1xuICBtb2R1bGVEYXRhLmlzSW5pdCA9IHRydWU7XG59XG5cbmZ1bmN0aW9uIHNoYXJrVGFiS2V5KG9EYXRhKSB7XG4gIGlmICghb0RhdGEgfHwgb0RhdGEgPT0gbnVsbCB8fCAhb0RhdGEudGFiSW5mbyB8fCBvRGF0YS50YWJJbmZvID09IG51bGwgfHwgb0RhdGEudGFiSW5mby5sZW5ndGggPCAyKSB7XG4gICAgbW9kdWxlRGF0YS50YWJWaXNhYmxlID0gXCJnb25lXCI7XG4gICAgcmV0dXJuO1xuICB9XG4gIG1vZHVsZURhdGEudGFiVmlzYWJsZSA9IFwidmlzaWJsZVwiO1xuICB2YXIgbXVBcnJheSA9IFtdO1xuICBmb3IgKGxldCBpbmRleCA9IDA7IGluZGV4IDwgb0RhdGEudGFiSW5mby5sZW5ndGg7IGluZGV4KyspIHtcbiAgICB2YXIgZWxlbWVudCA9IG9EYXRhLnRhYkluZm9baW5kZXhdO1xuICAgIGlmIChlbGVtZW50LmhpZ2hsaWdodCkge1xuICAgICAgdGFiS2V5ID0gZWxlbWVudC50YWJLZXk7XG4gICAgICBlbGVtZW50LmJhY2tncm91bmQ9IFwiQGNvbG9yL0tCYXNlQ29sb3JDb250ZW50QmFja2dyb3VuZFwiO1xuICAgICAgZWxlbWVudC50ZXh0Q29sb3IgPSBcIkBjb2xvci9rQ29sb3JQcmltYXJ5VGV4dFwiO1xuICAgIH0gZWxzZSB7XG4gICAgICBlbGVtZW50LmJhY2tncm91bmQ9IFwiQGNvbG9yL0tCYXNlQ29sb3JEZWVwZXN0QmFja2dyb3VuZFwiO1xuICAgICAgZWxlbWVudC50ZXh0Q29sb3IgPSBcIkBjb2xvci9rQ29sb3JUaHJlZUxldmVsVGV4dFwiO1xuICAgIH1cbiAgICBtdUFycmF5LnB1c2goZWxlbWVudCk7XG4gIH1cbiAgbW9kdWxlRGF0YS50YWIwID0gbXVBcnJheVswXTtcbiAgbW9kdWxlRGF0YS50YWIxID0gbXVBcnJheVsxXTtcbn1cblxuZnVuY3Rpb24gc2hhcmtIb21lRGF0YShvRGF0YSkge1xuICBpZiAoIW9EYXRhIHx8IG9EYXRhID09IG51bGwgfHwgIW9EYXRhLnNoYXJrSW5mbyB8fCBvRGF0YS5zaGFya0luZm8gPT0gbnVsbCB8fCBvRGF0YS5zaGFya0luZm8ubGVuZ3RoID09IDApIHtcbiAgICBjbGVhclRpbWVyKCk7XG4gICAgbW9kdWxlRGF0YS5jb250ZW50VmlzYWJsZSA9IFwiZ29uZVwiO1xuICAgIHJldHVybjtcbiAgfVxuICBjb25zdCBkYXRhID0gb0RhdGEuc2hhcmtJbmZvWzBdO1xuICBjb25zb2xlLmxvZygnaG9tZSBzaGFya0hvbWVEYXRhJyArIEpTT04uc3RyaW5naWZ5KGRhdGEpKTtcblxuICBtb2R1bGVEYXRhLmNvbnRlbnRWaXNhYmxlID0gXCJ2aXNpYmxlXCI7XG5cbiAgbW9kdWxlRGF0YS5xdW90ZUN1cnJlbmN5ID0gZGF0YS5xdW90ZUN1cnJlbmN5O1xuICBtb2R1bGVEYXRhLnZpZXdTdGF0dXMgPSBkYXRhLnZpZXdTdGF0dXM7XG5cbiAgbW9kdWxlRGF0YS5zdGFydFRpbWUgPSBkYXRhLnN0YXJ0VGltZTtcbiAgbW9kdWxlRGF0YS5lbmRUaW1lID0gZGF0YS5lbmRUaW1lO1xuXG4gIG1vZHVsZURhdGEuc3Vic2NyaWJlU3RhcnRUaW1lID0gZGF0YS5zdWJzY3JpYmVTdGFydFRpbWU7XG4gIG1vZHVsZURhdGEuc3Vic2NyaWJlRW5kVGltZSA9IGRhdGEuc3Vic2NyaWJlRW5kVGltZTtcblxuICBtb2R1bGVEYXRhLnRvdGFsTGltaXQgPSBgLyAke2NvbW1vbi5nZXRQcmljZVN0cmluZyhkYXRhLnRvdGFsTGltaXQsIDApfWA7XG4gIG1vZHVsZURhdGEuZmluaXNoQW1vdW50ID0gY29tbW9uLmdldFByaWNlU3RyaW5nKGRhdGEuZmluaXNoQW1vdW50LCAwKTtcblxuICB2YXIgZmluaXNoUHJvcG9ydGlvbiA9IFN0cmluZyhwYXJzZUludChkYXRhLmZpbmlzaEFtb3VudCAqIDEwMC4wIC8gZGF0YS50b3RhbExpbWl0KSk7XG4gIG1vZHVsZURhdGEuZmluaXNoUHJvcG9ydGlvbiA9IFN0cmluZyhwYXJzZUludChmaW5pc2hQcm9wb3J0aW9uKSk7XG5cbiAgdmFyIHVzZWRQcm9wb3J0aW9uID0gIFN0cmluZyhwYXJzZUludCgoZGF0YS50b3RhbExpbWl0IC0gZGF0YS5maW5pc2hBbW91bnQpICogMTAwLjAgLyBkYXRhLnRvdGFsTGltaXQpKTtcbiAgaWYoZGF0YS5maW5pc2hBbW91bnQgPiAwICYmIGZpbmlzaFByb3BvcnRpb24gPCAxKXtcbiAgICBmaW5pc2hQcm9wb3J0aW9uID0gMTtcbiAgfVxuICBpZiAodXNlZFByb3BvcnRpb24gPCAxKSB7XG4gICAgdXNlZFByb3BvcnRpb24gPSAxO1xuICB9XG4gIG1vZHVsZURhdGEudXNlZFByb3BvcnRpb24gPSBTdHJpbmcocGFyc2VJbnQodXNlZFByb3BvcnRpb24pKTtcblxuICBtb2R1bGVEYXRhLnNUaW1lID0gZGF0YS5zVGltZTtcbiAgbW9kdWxlRGF0YS5zZXJ2aWNlVGltZUludGVydmFsID0gZGF0YS5zVGltZSAtIG5ldyBEYXRlKCkuZ2V0VGltZSgpO1xuXG4gIG1vZHVsZURhdGEuc3Vic2NyaXB0aW9uVGl0bGUgPSBcIlwiO1xuICBpZiAoZGF0YS52aWV3U3RhdHVzID09IDApIHsgLy/mnKrlvIDlp4tcbiAgICBtb2R1bGVEYXRhLnN1YnNjcmlwdGlvblRpdGxlID0gJGkxOG4ubl9zaGFya19maW5fZGVwb3NpdF9vcGVuO1xuICAgIG1vZHVsZURhdGEuc3Vic2NyaXB0aW9uRGF0ZSA9IGAke25ldyBEYXRlKGRhdGEuc3Vic2NyaWJlU3RhcnRUaW1lKS5Gb3JtYXQoXCJ5eXl5L01NL2RkIGhoOm1tXCIpfWA7XG4gICAgdmFyIGlzWmVybyA9IHVwZGF0ZUNvdW50RG93bihkYXRhLnN1YnNjcmliZVN0YXJ0VGltZSk7XG4gICAgbW9kdWxlRGF0YS5wcm9ncmVzc1Zpc2FibGUgPSBcImdvbmVcIjtcbiAgICBtb2R1bGVEYXRhLmNvdW50ZG93blZpc2FibGUgPSBpc1plcm8gPyBcImdvbmVcIiA6IFwidmlzaWJsZVwiO1xuICAgIG1vZHVsZURhdGEuc3Vic2NyaXB0aW9uRGF0ZVZpc2FibGU9XCJ2aXNpYmxlXCI7XG4gIH0gZWxzZSBpZiAoZGF0YS52aWV3U3RhdHVzID09IDEgJiYgZGF0YS5maW5pc2hBbW91bnQgPCBkYXRhLnRvdGFsTGltaXQpIHsgLy/lvoXnoa7orqQg5pyq5ruhXG4gICAgbW9kdWxlRGF0YS5zdWJzY3JpcHRpb25UaXRsZSA9ICRpMThuLm5fc2hhcmtfZmluX2RlcG9zaXRfY2xvc2U7XG4gICAgbW9kdWxlRGF0YS5zdWJzY3JpcHRpb25EYXRlID0gIGAke25ldyBEYXRlKGRhdGEuc3Vic2NyaWJlRW5kVGltZSkuRm9ybWF0KFwieXl5eS9NTS9kZCBoaDptbVwiKX1gO1xuICAgIHZhciBpc1plcm8gPSB1cGRhdGVDb3VudERvd24oZGF0YS5zdWJzY3JpYmVFbmRUaW1lKTtcbiAgICBtb2R1bGVEYXRhLnByb2dyZXNzVmlzYWJsZSA9IFwidmlzaWJsZVwiO1xuICAgIG1vZHVsZURhdGEuY291bnRkb3duVmlzYWJsZSA9IGlzWmVybyA/IFwiZ29uZVwiIDogXCJ2aXNpYmxlXCI7XG4gICAgbW9kdWxlRGF0YS5zdWJzY3JpcHRpb25EYXRlVmlzYWJsZT1cInZpc2libGVcIjtcbiAgfSBlbHNlIHsgIC8v6LWa5biB5Lit77yb5bey5Yiw5pyf77yb5b6F56Gu6K6kIOW3sua7oVxuICAgIG1vZHVsZURhdGEuc3Vic2NyaXB0aW9uVGl0bGUgPSAkaTE4bi5uX3NoYXJrX2Zpbl9kZXBvc2l0X2Nsb3NlZDtcbiAgICBtb2R1bGVEYXRhLnByb2dyZXNzVmlzYWJsZSA9IFwidmlzaWJsZVwiO1xuICAgIG1vZHVsZURhdGEuY291bnRkb3duVmlzYWJsZSA9IFwiZ29uZVwiO1xuICAgIG1vZHVsZURhdGEuc3Vic2NyaXB0aW9uRGF0ZVZpc2FibGU9XCJnb25lXCI7XG4gICAgY2xlYXJUaW1lcigpO1xuICB9XG5cbiAgbW9kdWxlRGF0YS5kZXBvc2l0QW1vdW50VGl0bGUgPSAkaTE4bi4kaW50ZXJjZXB0Lm5fc2hhcmtfZmluX2RlcG9zaXRfYW1vdW50KGRhdGEucXVvdGVDdXJyZW5jeSk7XG5cbiAgdmFyIGFycmF5ID0gW107XG4gIGZvciAodmFyIGkgPSAwOyBpIDwgZGF0YS5wcm9qZWN0cy5sZW5ndGg7IGkrKykge1xuICAgIGxldCB0bXBPYmogPSBkYXRhLnByb2plY3RzW2ldO1xuICAgIGxldCBvYmogPSB7XG4gICAgICBcImlkeFwiOmksXG4gICAgICBcImljb25cIjogdG1wT2JqLmNhbGxQdXQgPT0gLTEgPyBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9zaGFya19ob21lX2Rvd25faWNvblwiIDogXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfc2hhcmtfaG9tZV91cF9pY29uXCIsXG4gICAgICBcInRpdGxlXCI6IHRtcE9iai5jYWxsUHV0ID09IC0xID8gJGkxOG4uJGludGVyY2VwdC5uX3NoYXJrX2Zpbl9iZWFyaXNoKHRtcE9iai5jdXJyZW5jeSkgOiAkaTE4bi4kaW50ZXJjZXB0Lm5fc2hhcmtfZmluX2J1bGxpc2godG1wT2JqLmN1cnJlbmN5KSxcbiAgICAgIFwidGVybVwiOiBgJHt0bXBPYmoudGVybX0gJHskaTE4bi5uX21pbmluZ19kYXlfdGV4dH1gLFxuICAgICAgXCJlYXJuaW5nc1wiOiBgJHtjb21tb24uZm9ybWF0UHJlY2lzaW9uKG51bWJlci5tdWx0aXBseSh0bXBPYmoubWluUmF0ZSwgXCIxMDBcIiksIDIpfSV+JHtjb21tb24uZm9ybWF0UHJlY2lzaW9uKG51bWJlci5tdWx0aXBseSh0bXBPYmoubWF4UmF0ZSwgXCIxMDBcIiksIDIpfSVgLFxuICAgICAgXCJjZWxsVHlwZVwiOiBcIm5vcm1hbFwiLFxuICAgICAgXCJpZFwiOiB0bXBPYmouaWQsXG4gICAgICBcInR5cGVcIjogdG1wT2JqLmNhbGxQdXQgPT0gLTEgPyBcImJlYXJyaXNoXCIgOiBcImJ1bGxpc2hcIixcbiAgICAgIFwidGVybVN0clwiOmAke3RtcE9iai50ZXJtfWAsXG4gICAgICBcImN1cnJlbmN5XCI6dG1wT2JqLmN1cnJlbmN5XG4gICAgfVxuICAgIGFycmF5LnB1c2gob2JqKTtcbiAgfVxuICBjb25zb2xlLmxvZyhcImFycmF5XCIgKyBKU09OLnN0cmluZ2lmeShhcnJheSkpO1xuICBtb2R1bGVEYXRhLnByb2R1Y3RMaXN0ID0gYXJyYXk7XG4gIHByb2R1Y3RMaXN0ID0gYXJyYXk7XG59XG5cbmZ1bmN0aW9uIHVwZGF0ZUNvdW50RG93bihkYXRlKSB7XG4gIHZhciB0aW1lTWFwID0gZ2V0Q291bnREb3duTWFwKGRhdGUpO1xuICBpZih0aW1lTWFwLmlzWmVybykge1xuICAgIG1vZHVsZURhdGEuY291bnRkb3duVmlzYWJsZSA9IFwiZ29uZVwiO1xuICB9IGVsc2Uge1xuICAgIG1vZHVsZURhdGEuY291bnRkb3duID0ge1xuICAgICAgXCJkYXlcIjp0aW1lTWFwLmRheSxcbiAgICAgIFwiaG91clwiOnRpbWVNYXAuaG91cixcbiAgICAgIFwibWludXRlXCI6dGltZU1hcC5taW51dGUsXG4gICAgICBcInNlY29uZFwiOnRpbWVNYXAuc2Vjb25kLFxuICAgICAgXCJzaG93RGF5XCI6dGltZU1hcC5zaG93RGF5LFxuICAgIH07XG4gIH1cbiAgcmV0dXJuIHRpbWVNYXAuaXNaZXJvO1xufVxuXG5mdW5jdGlvbiBnZXRDb3VudERvd25NYXAoZGF0ZSkge1xuICBjb25zdCBiZWdpbkRhdGUgPSBuZXcgRGF0ZShkYXRlKS5nZXRUaW1lKCk7XG4gIGNvbnN0IG5ld0RhdGUgPSBuZXcgRGF0ZSgpLmdldFRpbWUoKSArIG1vZHVsZURhdGEuc2VydmljZVRpbWVJbnRlcnZhbDtcblxuICBjb25zdCBtaWxsaXNlY29uZHMgPSBiZWdpbkRhdGUgLSBuZXdEYXRlO1xuICBjb25zdCBpbnRlcnZhbCA9IG1pbGxpc2Vjb25kcyAvIDEwMDA7XG5cbiAgaWYgKGludGVydmFsIDw9IDApIHtcbiAgICAgIHJldHVybiB7XG4gICAgICAgICAgZGF5OiAnMDAnLFxuICAgICAgICAgIGhvdXI6ICcwMCcsXG4gICAgICAgICAgbWludXRlOiAnMDAnLFxuICAgICAgICAgIHNlY29uZDogJzAwJyxcbiAgICAgICAgICBzaG93RGF5OiAnZ29uZScsXG4gICAgICAgICAgaXNaZXJvOiB0cnVlXG4gICAgICB9O1xuICB9XG5cbiAgbGV0IGQgPSBwYXJzZUludChpbnRlcnZhbCAvIDYwIC8gNjAgLyAyNCk7XG4gIGxldCBkYXkgPSBkIDwgMTAgPyBgMCR7ZH1gIDogYCR7ZH1gO1xuXG4gIGxldCBoID0gcGFyc2VJbnQoaW50ZXJ2YWwgLyA2MCAvIDYwICUgMjQpO1xuICBsZXQgaG91ciA9IGggPCAxMCA/IGAwJHtofWAgOiBgJHtofWA7XG5cbiAgbGV0IG0gPSBwYXJzZUludChpbnRlcnZhbCAvIDYwICUgNjApO1xuICBsZXQgbWludXRlID0gbSA8IDEwID8gYDAke219YCA6IGAke219YDtcblxuICBsZXQgcyA9IHBhcnNlSW50KGludGVydmFsICUgNjApO1xuICBsZXQgc2Vjb25kID0gcyA8IDEwID8gYDAke3N9YCA6IGAke3N9YDtcblxuICB2YXIgc2hvd0RheSA9IGQgPiAwID8gXCJ2aXNpYmxlXCIgOiAnZ29uZSc7XG4gIHZhciBpc1plcm8gPSBkICsgaCArIG0gKyBzID4gMCA/IGZhbHNlIDogdHJ1ZTtcblxuICByZXR1cm4ge1xuICAgICAgZGF5LFxuICAgICAgaG91cixcbiAgICAgIG1pbnV0ZSxcbiAgICAgIHNlY29uZCxcbiAgICAgIHNob3dEYXksXG4gICAgICBpc1plcm9cbiAgfTtcbn1cblxuXG5mdW5jdGlvbiBzdGFydFRpbWVyKCkge1xuICBjb25zb2xlLmxvZyhcInN0YXJ0VGltZXIgXCIpO1xuICBpZiAobW9kdWxlRGF0YS50aW1lck9iamVjdCA9PSBudWxsKSB7XG4gICAgbW9kdWxlRGF0YS50aW1lck9iamVjdCA9IHNldEludGVydmFsKHRpbWVyLCAxMDAwKTtcbiAgfVxufVxuXG5mdW5jdGlvbiBjbGVhclRpbWVyKCkge1xuICBpZiAobW9kdWxlRGF0YS50aW1lck9iamVjdCAhPSBudWxsKSB7XG4gICAgY29uc29sZS5sb2coXCJjbGVhclRpbWVyIFwiKTtcbiAgICBjbGVhckludGVydmFsKG1vZHVsZURhdGEudGltZXJPYmplY3QpO1xuICAgIG1vZHVsZURhdGEudGltZXJPYmplY3QgPSBudWxsO1xuICB9XG59XG5cbmFzeW5jIGZ1bmN0aW9uIHRpbWVyKCkge1xuICBjb25zb2xlLmxvZyhcInRpbWVyIFwiKTtcbiAgdmFyIGlzWmVybyA9IGZhbHNlO1xuICBpZiAobW9kdWxlRGF0YS52aWV3U3RhdHVzID09IDApIHsgLy/mnKrlvIDlp4tcbiAgICBpc1plcm8gPSB1cGRhdGVDb3VudERvd24obW9kdWxlRGF0YS5zdWJzY3JpYmVTdGFydFRpbWUpO1xuICB9IGVsc2UgaWYgKG1vZHVsZURhdGEudmlld1N0YXR1cyA9PSAxKSB7IC8v5b6F56Gu6K6kXG4gICAgaXNaZXJvID0gIHVwZGF0ZUNvdW50RG93bihtb2R1bGVEYXRhLnN1YnNjcmliZUVuZFRpbWUpO1xuICB9IFxuXG4gIGlmKGlzWmVybykge1xuICAgIGRhdGEgPSBhd2FpdCBjb21tb24uc2VuZFJlcXVlc3QoJ3Y0L3NhdmluZy9taW5pbmcvc2hhcmsnLCB7IHRhYktleSB9KTtcbiAgICBzaGFya1RhYktleShkYXRhKTtcbiAgICBzaGFya0hvbWVEYXRhKGRhdGEpO1xuICB9XG59XG5cbmZ1bmN0aW9uIGNsaWNrUUEoaW5kZXgpIHtcbiAgaWYobW9kdWxlRGF0YS5xdWVzdGlvbkxpc3RbaW5kZXhdLmFuc3dlclZpc2FibGUgPT0gXCJnb25lXCIpe1xuICAgIG1vZHVsZURhdGEucXVlc3Rpb25MaXN0W2luZGV4XS5hbnN3ZXJWaXNhYmxlPVwidmlzaWJsZVwiO1xuICAgIG1vZHVsZURhdGEucXVlc3Rpb25MaXN0W2luZGV4XS5xYUljb249XCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfc2hhcmtfaG9tZV9xYV9yZXRyYWN0X2ljb25cIlxuICB9IGVsc2Uge1xuICAgIG1vZHVsZURhdGEucXVlc3Rpb25MaXN0W2luZGV4XS5hbnN3ZXJWaXNhYmxlPVwiZ29uZVwiO1xuICAgIG1vZHVsZURhdGEucXVlc3Rpb25MaXN0W2luZGV4XS5xYUljb249XCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfc2hhcmtfaG9tZV9xYV9zcHJlYWRfaWNvblwiXG4gIH1cbiAgY29tbW9uLmFuYWx5dGljcyhcImFwcF9lYXJuX3NoYWtlRmluUHJvZHVjdF9GQVFzX2NsaWNrXCIse1xuICAgICdvcmRlcic6cGFyc2VJbnQoaW5kZXgpKzFcbiAgfSk7XG59XG5cbi8v6Lez6L2s5oiR5oyB5pyJ55qEXG5mdW5jdGlvbiBnb015UHJvcGVydGllcygpIHtcbiAgICAvL+i3s+i9rOiHs+i1hOS6p+mhteWvueW6lOeahOmyqOmxvOmzjeagh+etvuWFpeWPoyBodHRwczovL3d3dy5nbG9iYWwtYmFzZS50Yy1qcDEuaHVvYmlhcHBzLmNvbS96aC1jbi9maW5hbmNpYWwvZWFybi9hc3NldHMvaDU/dGFiSW5kZXg9M1xuICAgIGNvbW1vbi5vcGVuVVJMKGAke2NvbW1vbi5jb21tb25EYXRhLmg1VXJsfS8ke2NvbW1vbi5jb21tb25EYXRhLmxhbmd1YWdlfS9maW5hbmNpYWwvZWFybi9hc3NldHMvaDU/dGFiSW5kZXg9M2ApO1xuICAgIGNvbW1vbi5hbmFseXRpY3MoXCJhcHBfZWFybl9zaGFrZUZpblByb2R1Y3RfY3VycmVudEhvbGRpbmdzX2NsaWNrXCIpO1xuXG59XG5cbi8v6Lez6L2s5YWo6YOo5Y6G5Y+y5Lqn5ZOBXG5mdW5jdGlvbiBnb0hpc3RvcnkoKSB7XG4gIGNvbW1vbi5vcGVuVVJMKFwiaG9saWdlaXQ6Ly9vcGVuL3YxP2xvZ2luPTAmdXJsPWlodW9iaWdsb2JhbDovL20uaGJnLmNvbS9lZGdlZW5naW5lL2NvbnRhaW5lcj9zY2VuZT1zaGFya2ZpbiZyb290TmFtZT1oaXN0b3J5Jm5hdkNvbmZpZz1uYXRpdmUmcGFnZVR5cGU9b25Hb2luZ1wiKTtcbiAgY29tbW9uLmFuYWx5dGljcyhcImFwcF9lYXJuX3NoYWtlRmluUHJvZHVjdF92aWV3QWxsTGlzdGluZ3NfY2xpY2tcIik7XG5cbn1cblxuLy/ot7Povazlhajpg6jluLjop4Hpl67pophcbmZ1bmN0aW9uIGdvQWxsRkFRcygpIHtcbiAgY29tbW9uLm9wZW5VUkwoXCJob2xpZ2VpdDovL29wZW4vdjE/bG9naW49MSZ1cmw9aWh1b2JpZ2xvYmFsOi8vbS5oYmcuY29tL2VkZ2VlbmdpbmUvY29udGFpbmVyP3NjZW5lPXNoYXJrZmluJnJvb3ROYW1lPWludHJvZHVjZSZuYXZDb25maWc9bmF0aXZlJmluZGV4PTFcIik7XG4gIGNvbW1vbi5hbmFseXRpY3MoXCJhcHBfZWFybl9zaGFrZUZpblByb2R1Y3RfRkFRc19tb3JlX2NsaWNrXCIpO1xufVxuXG4vL2JhY2tcbmZ1bmN0aW9uIGdvQmFjaygpIHtcbiAgY29uc29sZS5sb2coXCJob21lIGJhY2tcIilcbiAgY29tbW9uLmNvbnRhaW5lckJhY2soKTtcbiAgY29tbW9uLmFuYWx5dGljcyhcImFwcF9lYXJuX3NoYWtlRmluUHJvZHVjdF9yZXR1cm5CdXR0b25fY2xpY2tcIik7XG59XG5cbi8v6Lez6L2s5LuL57uN6aG16Z2iXG5mdW5jdGlvbiBnb0ludHJvZHVjZSgpIHtcbiAgY29tbW9uLm9wZW5VUkwoXCJob2xpZ2VpdDovL29wZW4vdjE/bG9naW49MSZ1cmw9aWh1b2JpZ2xvYmFsOi8vbS5oYmcuY29tL2VkZ2VlbmdpbmUvY29udGFpbmVyP3NjZW5lPXNoYXJrZmluJnJvb3ROYW1lPWludHJvZHVjZSZuYXZDb25maWc9bmF0aXZlJmluZGV4PTBcIik7XG4gIGNvbW1vbi5hbmFseXRpY3MoXCJhcHBfZWFybl9zaGFrZUZpblByb2R1Y3Rfc2hha2VGaW5JbnRyb19jbGlja1wiKTtcblxufVxuXG4vL+i3s+i9rOeUs+i0rVxuZnVuY3Rpb24gZ29EZXBvc2l0KGlkeCkge1xuICB2YXIgaXRlbSA9IG1vZHVsZURhdGEucHJvZHVjdExpc3RbaWR4XTtcbiAgY29tbW9uLm9wZW5VUkwoYGhvbGlnZWl0Oi8vb3Blbi92MT9sb2dpbj0xJnVybD1paHVvYmlnbG9iYWw6Ly9tLmhiZy5jb20vZWRnZWVuZ2luZS9jb250YWluZXI/c2NlbmU9c2hhcmtmaW4mcm9vdE5hbWU9ZGVwb3NpdCZuYXZDb25maWc9JnByb2plY3RJZD0ke2l0ZW0uaWR9YCk7XG4gIGNvbW1vbi5hbmFseXRpY3MoXCJhcHBfZWFybl9zaGFrZUZpblByb2R1Y3RfcHJvZHVjdF9jbGlja1wiLHtcbiAgICAndHlwZSc6aXRlbS50eXBlLFxuICAgICd0ZXJtJzppdGVtLnRlcm1TdHIsXG4gICAgJ2N1cnJlbmN5JzppdGVtLmN1cnJlbmN5XG4gIH0pO1xuXG59XG5cbi8v6Lez6L2s5LuL57uN6aG16Z2iXG5mdW5jdGlvbiB0YWJDbGlja2VkKHNlbGVjdFRhYktleSkge1xuICBpZiAodGFiS2V5ICE9IHNlbGVjdFRhYktleSkge1xuICAgIHRhYktleSA9IHNlbGVjdFRhYktleTtcbiAgfVxuICBzdGFydFRpbWVyKCk7XG4gIHJlcXVlc3RTaGFya0hvbWVEYXRhKCk7XG59XG5cblxubW9kdWxlRXZlbnQuY2xpY2tRQSA9IGNsaWNrUUE7XG5tb2R1bGVFdmVudC5nb015UHJvcGVydGllcyA9IGdvTXlQcm9wZXJ0aWVzO1xubW9kdWxlRXZlbnQuZ29IaXN0b3J5ID0gZ29IaXN0b3J5O1xubW9kdWxlRXZlbnQuZ29BbGxGQVFzID0gZ29BbGxGQVFzO1xubW9kdWxlRXZlbnQuZ29CYWNrID0gZ29CYWNrO1xubW9kdWxlRXZlbnQuZ29JbnRyb2R1Y2UgPSBnb0ludHJvZHVjZTtcbm1vZHVsZUV2ZW50LmdvRGVwb3NpdCA9IGdvRGVwb3NpdDtcbm1vZHVsZUV2ZW50LnRhYkNsaWNrZWQgPSB0YWJDbGlja2VkO1xuIiwiaW1wb3J0ICogYXMgY29tbW9uIGZyb20gXCIuL2NvbW1vblwiXG5pbXBvcnQgKiBhcyBudW1iZXIgZnJvbSBcIi4vbnVtYmVyXCI7XG5cbnZhciBoaXN0b3J5X3RpdGxlQ29sb3JfTm9ybWFsO1xudmFyIGhpc3RvcnlfdGl0bGVDb2xvcl9TZWxlY3RlZDtcblxudmFyIGhpc3Rvcnlfb25Hb2luZ1BhZ2UgPSAyO1xudmFyIGhpc3RvcnlfZmluaXNoZWRQYWdlID0gMztcblxuLy8gdmFyIG9uR29pbmdEYXRhID0gW107XG4vLyB2YXIgZmluaXNoZWREYXRhID0gW107XG5cbmZ1bmN0aW9uIGRlZmF1bHREYXRhKCkge1xuICByZXR1cm4ge1xuICAgIGxpc3REYXRhOiBbXG4gICAgICB7J3R5cGUnOiAnbm9ybWFsJywgJ2RhdGEnOiBbXSwgXCJyaWdodFRpdGxlXCI6JGkxOG4ubl9zaGFya19maW5fQVBZX0VzdCwgXCJsb2FkTW9yZVN0YXR1c1wiOiAwLCBcImVtcHR5XCIgOlwiZ29uZVwiLCBcInNob3dMaXN0XCI6XCJnb25lXCJ9LFxuICAgICAgeyd0eXBlJzogJ25vcm1hbCcsICdkYXRhJzogW10sIFwicmlnaHRUaXRsZVwiOiRpMThuLm5fc2hhcmtfZmluX0VzdF9BUFksIFwibG9hZE1vcmVTdGF0dXNcIjogMCwgXCJlbXB0eVwiIDpcImdvbmVcIiwgXCJzaG93TGlzdFwiOlwiZ29uZVwiIH1cbiAgICBdLFxuICAgIHBvcGxpc3REYXRhOntcbiAgICAgIFwicHJvamVjdExpc3RcIjpbXVxuICAgIH0sXG4gICAgb25Hb2luZ1BhZ2U6IDEsXG4gICAgZmluaXNoZWRQYWdlOiAxLFxuICAgIG9uR29pbmdEYXRhOiBbXSxcbiAgICBmaW5pc2hlZERhdGE6W10sXG4gICAgY3VycmVudEluZGV4OiAwXG4gIH1cbn1cblxuY29uc3QgeyBtb2R1bGVEYXRhLCBtb2R1bGVFdmVudCB9ID0gY29tbW9uLm1vZHVsZURlZmluZShcImhpc3RvcnlcIiwgZGVmYXVsdERhdGEsIHtvbkNyZWF0ZSwgb25EZXN0cm95LCBvblJlc3VtZSwgb25QYXVzZSwgb25TdGFydCwgb25TdG9wfSk7XG5cbmZ1bmN0aW9uIGdldE5hdkNvbmZpZ1N0cmluZygpIHtcbiAgcmV0dXJuIHtcbiAgICAndGl0bGVLZXknOiAnbl9zaGFya19maW5faGlzdG9yaWNhbF9wcm9kdWN0cycsXG4gICAgJ2xlZnQnOiB7XG4gICAgICAnYWN0aW9uJzoge1xuICAgICAgICAndHlwZSc6ICdiYWNrJyxcbiAgICAgICAgJ3BhcmFtZXRlcic6ICcnXG4gICAgICB9LFxuICAgICAgJ2ljb24nOiAnZWRnZV9lbmdpbmVfdG9wX2Jhcl9iYWNrX25vcm1hbCdcbiAgICB9LFxuICAgICdiYWNrZ3JvdW5kQ29sb3InOidLQmFzZUNvbG9yQ29udGVudEJhY2tncm91bmQnXG4gIH07XG59XG5cbmZ1bmN0aW9uIG9uQ3JlYXRlKGV2ZW50UGFyYW1zKSB7XG4gIGNvbnNvbGUubG9nKCdvbkNyZWF0ZSBoaXN0b3J5JyArIGV2ZW50UGFyYW1zKTtcblxuICBpZiAoY29tbW9uLmNvbW1vbkRhdGEuY29sb3JNb2RlID09IDEpIHtcbiAgICBoaXN0b3J5X3RpdGxlQ29sb3JfTm9ybWFsID0gXCIjOEM4QzkzXCI7XG4gICAgaGlzdG9yeV90aXRsZUNvbG9yX1NlbGVjdGVkID0gXCIjRTZFNkU2XCI7XG4gIH1cbiAgZWxzZSB7XG4gICAgaGlzdG9yeV90aXRsZUNvbG9yX05vcm1hbCA9IFwiIzU2NTY1NlwiO1xuICAgIGhpc3RvcnlfdGl0bGVDb2xvcl9TZWxlY3RlZCA9IFwiIzAwMDAwMFwiO1xuICB9XG5cbiAgbW9kdWxlRGF0YS5zdGF0dXNCYXJDb25maWcgPSB7IFwic3RhdHVzQmFyTW9kZVwiOiBcInRydWVcIiwgXCJhZFN0YXR1c0JhckNvbG9yXCI6XCJLQmFzZUNvbG9yQ29udGVudEJhY2tncm91bmRcIiB9O1xuICBtb2R1bGVEYXRhLm5hdkNvbmZpZyA9IGdldE5hdkNvbmZpZ1N0cmluZygpO1xuXG4gIGNvbnN0IHBhcmFtcyA9IEpTT04ucGFyc2UoZXZlbnRQYXJhbXMpO1xuICB2YXIgcGFnZVR5cGUgPSBwYXJhbXMgIT0gbnVsbCAmJiBwYXJhbXMucGFnZVR5cGUgIT0gbnVsbCA/IHBhcmFtcy5wYWdlVHlwZSA6IFwib25Hb2luZ1wiO1xuICBjb25zb2xlLmxvZygnb25DcmVhdGUgaGlzdG9yeScgKyBKU09OLnN0cmluZ2lmeShwYWdlVHlwZSkpO1xuICB0YWJDbGljayhwYWdlVHlwZSk7XG5cbiAgY29tbW9uLnNob3dMb2FkaW5nKHRydWUpO1xuICByZXF1ZXN0U2hhcmtQcmV2UmVjb3Jkc0RhdGEoaGlzdG9yeV9vbkdvaW5nUGFnZSwgbW9kdWxlRGF0YS5vbkdvaW5nUGFnZSk7XG4gIHJlcXVlc3RTaGFya1ByZXZSZWNvcmRzRGF0YShoaXN0b3J5X2ZpbmlzaGVkUGFnZSwgbW9kdWxlRGF0YS5maW5pc2hlZFBhZ2UpO1xuICBjb21tb24uc2hvd0xvYWRpbmcoZmFsc2UpO1xufVxuXG5mdW5jdGlvbiBvbkRlc3Ryb3koKSB7XG4gIGNsZWFyTW9kdWxlRGF0YSgpO1xufVxuXG5mdW5jdGlvbiBvblJlc3VtZSgpIHtcbn1cblxuZnVuY3Rpb24gb25QYXVzZSgpIHtcbn1cblxuZnVuY3Rpb24gb25TdGFydCgpIHtcbn1cblxuZnVuY3Rpb24gb25TdG9wKCkge1xufVxuXG5mdW5jdGlvbiBjbGVhck1vZHVsZURhdGEoKSB7XG4gIG1vZHVsZURhdGEubGlzdERhdGEgPSBbXG4gICAgeyd0eXBlJzogJ25vcm1hbCcsICdkYXRhJzogW10sIFwicmlnaHRUaXRsZVwiOiRpMThuLm5fc2hhcmtfZmluX0FQWV9Fc3QsIFwibG9hZE1vcmVTdGF0dXNcIjogMCwgXCJlbXB0eVwiIDpcImdvbmVcIiwgXCJzaG93TGlzdFwiOlwiZ29uZVwifSxcbiAgICB7J3R5cGUnOiAnbm9ybWFsJywgJ2RhdGEnOiBbXSwgXCJyaWdodFRpdGxlXCI6JGkxOG4ubl9zaGFya19maW5fRXN0X0FQWSwgXCJsb2FkTW9yZVN0YXR1c1wiOiAwLCBcImVtcHR5XCIgOlwiZ29uZVwiLCBcInNob3dMaXN0XCI6XCJnb25lXCIgfVxuICBdO1xuICBtb2R1bGVEYXRhLnBvcGxpc3REYXRhID0ge1xuICAgIFwicHJvamVjdExpc3RcIjpbXVxuICB9O1xuICBtb2R1bGVEYXRhLm9uR29pbmdQYWdlID0gMTtcbiAgbW9kdWxlRGF0YS5maW5pc2hlZFBhZ2UgPSAxO1xuICBtb2R1bGVEYXRhLm9uR29pbmdEYXRhID0gW107XG4gIG1vZHVsZURhdGEuZmluaXNoZWREYXRhID0gW107XG4gIG1vZHVsZURhdGEuY3VycmVudEluZGV4ID0gMDtcbn1cblxuLy8gcXVvdGVDdXJyZW5jeSAgICAgICAgICAgICAgICDorqHku7fluIHnp41cbi8vIHZpZXdTdGF0dXMgICAgICAgICAgICAgICAgICAgMC3mnKrlvIDlp4vvvJsxLeW+heehruiupO+8mzIt6LWa5biB5Lit77ybMy3lt7LliLDmnJ9cbi8vIGVuZFRpbWUgICAgICAgICAgICAgICAgICAgICAg6aG555uu57uT5p2f5pe26Ze0XG4vLyBzdWJzY3JpYmVFbmRUaW1lICAgICAgICAgICAgIOeUs+i0ree7k+adn+aXtumXtCBcbi8vIGZpbmlzaEFtb3VudCAgICAgICAgICAgICAgICAg5bey5Yuf6LWE6YeR6aKdXG4vLyBzZXR0bGVJbmNvbWVBbW91bnQgICAgICAgICAgIOe7k+eul+WIqeaBr1xuLy8gYWxsb3dSYWlzZURldGFpbCAgICAgICAgICAgICDmmK/lkKblhYHorrjmn6XnnIvli5/pm4bor6bmg4Vcbi8vIHByb2plY3RzICAgICAgICAgICAgICAgICAgICAg55yL5rao55yL6LeM6aG555uu5YiX6KGoIFxuLy8gICBpZCAgICAgICAgICAgICAgICAgICAgICAgICBpZFxuLy8gICBjdXJyZW5jeSAgICAgICAgICAgICAgICAgICDmoIfnmoTluIHnp43vvIhidGMvZXRoLi4u77yJXG4vLyAgIGNhbGxQdXQgICAgICAgICAgICAgICAgICAgIOeci+a2qOeci+i3jDogLTEtcHV06LeMLCAxLWNhbGzmtqhcbi8vICAgdGVybSAgICAgICAgICAgICAgICAgICAgICAg6aG555uu5ZGo5pyf77yI5aSp77yJXG4vLyAgIHNldHRsZVRpbWUgICAgICAgICAgICAgICAgIGVwb2NoTXMg5Y+q5bGV56S65Yiw5aSp77yM5aaCMjAyMy8wNi8wMlxuLy8gICBtaW5SYXRlICAgICAgICAgICAgICAgICAgICDmnIDlsI/lubTljJbmlLbnm4pcbi8vICAgbWF4UmF0ZSAgICAgICAgICAgICAgICAgICAg5pyA5aSn5bm05YyW5pS255uKXG4vLyAgIGZpbmlzaEFtb3VudCAgICAgICAgICAgICAgIOW3suWLn+i1hOmHkeminVxuLy8gICBzZXR0bGVJbmNvbWVBbW91bnQgICAgICAgICDnu5PnrpfliKnmga9cbi8vICAgc2V0dGxlbWVudFByaWNlICAgICAgICAgICAg57uT566X5Lu35qC8XHRcbi8vICAgZmluYWxSYXRlICAgICAgICAgICAgICAgICAg5pyA57uI5bm05YyW546HXHRcblxuLy90eXBlICAgICAgIDIt6LWa5biB5Lit77ybMy3lt7LliLDmnJ9cbi8vY3VyclBhZ2VcdCDpobXmlbBcbmFzeW5jIGZ1bmN0aW9uIHJlcXVlc3RTaGFya1ByZXZSZWNvcmRzRGF0YSh0eXBlLCBjdXJyUGFnZSkge1xuXG4gIGNvbnN0IGRhdGEgPSBhd2FpdCBjb21tb24uc2VuZFJlcXVlc3QoJy92NC9zYXZpbmcvbWluaW5nL3NoYXJrL3ByZXZSZWNvcmRzJywge3R5cGUsIGN1cnJQYWdlfSk7XG4gIFxuICAvLyBjb25zb2xlLmxvZyhcInJlcXVlc3RTaGFya1ByZXZSZWNvcmRzRGF0YVwiICsgSlNPTi5zdHJpbmdpZnkoZGF0YSkpO1xuXG4gIGlmICghZGF0YSB8fCBkYXRhID09IG51bGwpIHtcbiAgICBzZXRFbXB0eSh0eXBlKTtcbiAgICByZXR1cm47XG4gIH1cbiAgXG4gIHZhciBzaGFya1ByZXZSZWNvcmRzRGF0YSA9IGNoYW5nZURhdGFPYmplY3QoZGF0YSk7XG4gIC8vIGNvbnNvbGUubG9nKFwicmVxdWVzdFNoYXJrUHJldlJlY29yZHNEYXRhXCIgKyBKU09OLnN0cmluZ2lmeShzaGFya1ByZXZSZWNvcmRzRGF0YS5hbGxhcnJheSkpO1xuXG4gIGlmIChzaGFya1ByZXZSZWNvcmRzRGF0YS5hbGxhcnJheS5sZW5ndGggPT0gMCkge1xuICAgIHNldEVtcHR5KHR5cGUpO1xuICAgIHJldHVybjtcbiAgfVxuXG4gIGlmKHR5cGUgPT0gaGlzdG9yeV9vbkdvaW5nUGFnZSkge1xuICAgIHZhciB0ZW1wRGF0YTAgPSBtb2R1bGVEYXRhLmxpc3REYXRhWzBdLmRhdGE7XG4gICAgaWYodGVtcERhdGEwID09IG51bGwgfHwgdGVtcERhdGEwLmxlbmd0aCA9PSAwKSB7XG4gICAgICBtb2R1bGVEYXRhLmxpc3REYXRhWzBdLnR5cGUgPSBcIm5vcm1hbFwiO1xuICAgICAgdGVtcERhdGEwID0gc2hhcmtQcmV2UmVjb3Jkc0RhdGEuYWxsYXJyYXk7XG4gICAgfSBlbHNlIHtcbiAgICAgIHRlbXBEYXRhMC5wdXNoKC4uLnNoYXJrUHJldlJlY29yZHNEYXRhLmFsbGFycmF5KTtcbiAgICB9XG4gICAgbW9kdWxlRGF0YS5saXN0RGF0YVswXS5kYXRhID0gdGVtcERhdGEwLm1hcChmdW5jdGlvbihpdGVtLCBpZHgpIHtcbiAgICAgIHZhciByZXQgPSBpdGVtO1xuICAgICAgcmV0LmlkeCA9IGlkeDtcbiAgICAgIHJldHVybiByZXQ7XG4gICAgfSk7XG4gICAgbW9kdWxlRGF0YS5vbkdvaW5nRGF0YS5wdXNoKC4uLnNoYXJrUHJldlJlY29yZHNEYXRhLmRhdGFPYmplY3RzKTtcbiAgICBtb2R1bGVEYXRhLmxpc3REYXRhWzBdLmVtcHR5ID0gXCJnb25lXCI7XG4gICAgbW9kdWxlRGF0YS5saXN0RGF0YVswXS5zaG93TGlzdCA9IFwidmlzaWJsZVwiO1xuICAgIC8vIG9uR29pbmdEYXRhLnB1c2goLi4uc2hhcmtQcmV2UmVjb3Jkc0RhdGEuZGF0YU9iamVjdHMpO1xuXG4gIH0gZWxzZSBpZigodHlwZSA9PSBoaXN0b3J5X2ZpbmlzaGVkUGFnZSkpIHtcbiAgICB2YXIgdGVtcERhdGExID0gbW9kdWxlRGF0YS5saXN0RGF0YVsxXS5kYXRhO1xuICAgaWYodGVtcERhdGExID09IG51bGwgfHwgdGVtcERhdGExLmxlbmd0aCA9PSAwKSB7XG4gICAgICBtb2R1bGVEYXRhLmxpc3REYXRhWzFdLnR5cGUgPSBcIm5vcm1hbFwiO1xuICAgICAgdGVtcERhdGExID0gc2hhcmtQcmV2UmVjb3Jkc0RhdGEuYWxsYXJyYXk7XG4gICAgfSBlbHNlIHtcbiAgICAgIHRlbXBEYXRhMS5wdXNoKC4uLnNoYXJrUHJldlJlY29yZHNEYXRhLmFsbGFycmF5KTtcbiAgICB9XG4gICAgbW9kdWxlRGF0YS5saXN0RGF0YVsxXS5kYXRhID0gdGVtcERhdGExLm1hcChmdW5jdGlvbihpdGVtLCBpZHgpIHtcbiAgICAgIHZhciByZXQgPSBpdGVtO1xuICAgICAgcmV0LmlkeCA9IGlkeDtcbiAgICAgIHJldHVybiByZXQ7XG4gICAgfSk7XG4gICAgbW9kdWxlRGF0YS5maW5pc2hlZERhdGEucHVzaCguLi5zaGFya1ByZXZSZWNvcmRzRGF0YS5kYXRhT2JqZWN0cyk7XG5cbiAgICBtb2R1bGVEYXRhLmxpc3REYXRhWzFdLmVtcHR5ID0gXCJnb25lXCI7XG4gICAgbW9kdWxlRGF0YS5saXN0RGF0YVsxXS5zaG93TGlzdCA9IFwidmlzaWJsZVwiO1xuICB9XG5cbiAgIC8v5pWw5o2u5LiN5Li6bnVsbFxuICAgaWYoc2hhcmtQcmV2UmVjb3Jkc0RhdGEgIT0gbnVsbCAmJiBzaGFya1ByZXZSZWNvcmRzRGF0YS5hbGxhcnJheSAhPSBudWxsICYmIHNoYXJrUHJldlJlY29yZHNEYXRhLmFsbGFycmF5Lmxlbmd0aCA+IDApIHtcbiAgICBpZih0eXBlID09IGhpc3Rvcnlfb25Hb2luZ1BhZ2UpIHtcbiAgICAgIG1vZHVsZURhdGEub25Hb2luZ1BhZ2UrKztcbiAgICB9IGVsc2UgaWYoKHR5cGUgPT0gaGlzdG9yeV9maW5pc2hlZFBhZ2UpKSB7XG4gICAgICBtb2R1bGVEYXRhLmZpbmlzaGVkUGFnZSsrO1xuICAgIH1cbiAgfVxufVxuXG5mdW5jdGlvbiBzZXRFbXB0eSh0eXBlKSB7XG4gIGlmKHR5cGUgPT0gaGlzdG9yeV9vbkdvaW5nUGFnZSkge1xuICAgIGlmKG1vZHVsZURhdGEubGlzdERhdGFbMF0uZGF0YSA9PSBudWxsIHx8IG1vZHVsZURhdGEubGlzdERhdGFbMF0uZGF0YS5sZW5ndGggPT0gMCkge1xuICAgICAgbW9kdWxlRGF0YS5saXN0RGF0YVswXS5lbXB0eSA9IFwidmlzaWJsZVwiO1xuICAgICAgbW9kdWxlRGF0YS5saXN0RGF0YVswXS5zaG93TGlzdCA9IFwiZ29uZVwiO1xuICAgIH1cbiAgfSBlbHNlIGlmKCh0eXBlID09IGhpc3RvcnlfZmluaXNoZWRQYWdlKSkge1xuICAgIGlmKG1vZHVsZURhdGEubGlzdERhdGFbMV0uZGF0YSA9PSBudWxsIHx8IG1vZHVsZURhdGEubGlzdERhdGFbMV0uZGF0YS5sZW5ndGggPT0gMCkge1xuICAgICAgbW9kdWxlRGF0YS5saXN0RGF0YVsxXS5lbXB0eSA9IFwidmlzaWJsZVwiO1xuICAgICAgbW9kdWxlRGF0YS5saXN0RGF0YVsxXS5zaG93TGlzdCA9IFwiZ29uZVwiO1xuICAgIH1cbiAgfVxufVxuXG5mdW5jdGlvbiBjaGFuZ2VEYXRhT2JqZWN0KGRhdGEpIHtcbiAgdmFyIGRhdGFPYmplY3RzID0ge1xuICAgIFwiZGF0YU9iamVjdHNcIjpbXSxcbiAgICBcImFsbGFycmF5XCI6W11cbiAgfTtcbiAgY29uc29sZS5sb2coXCJ1cGRhdGFEYXRhXCIgKyBKU09OLnN0cmluZ2lmeShkYXRhKSk7XG4gIHZhciBhbGxhcnJheSA9IFtdO1xuICBmb3IgKHZhciBpID0gMDsgaSA8IGRhdGEubGVuZ3RoOyBpKyspIHtcbiAgICB2YXIgdG1wUHJvamVjdHNPYmogPSBkYXRhW2ldO1xuICAgIHZhciBwcm9qZWN0c09iaiA9IHt9O1xuICAgIFxuICAgIGNvbnNvbGUubG9nKFwidXBkYXRhRGF0YSAxXCIgKyBKU09OLnN0cmluZ2lmeSh0bXBQcm9qZWN0c09iaikpO1xuXG4gICAgcHJvamVjdHNPYmouaW5kZXggPSBpO1xuICAgIHByb2plY3RzT2JqLnF1b3RlQ3VycmVuY3kgPSB0bXBQcm9qZWN0c09iai5xdW90ZUN1cnJlbmN5O1xuICAgIHByb2plY3RzT2JqLnZpZXdTdGF0dXMgPSB0bXBQcm9qZWN0c09iai52aWV3U3RhdHVzO1xuICAgIHByb2plY3RzT2JqLmVuZFRpbWUgPSB0bXBQcm9qZWN0c09iai5lbmRUaW1lO1xuICAgIHByb2plY3RzT2JqLnN1YnNjcmliZUVuZFRpbWUgPSB0bXBQcm9qZWN0c09iai5zdWJzY3JpYmVFbmRUaW1lO1xuICAgIHByb2plY3RzT2JqLmZpbmlzaEFtb3VudCA9IHRtcFByb2plY3RzT2JqLmZpbmlzaEFtb3VudDtcbiAgICBwcm9qZWN0c09iai5maW5pc2hBbW91bnRTdHIgPSBjb21tb24uZ2V0UHJpY2VTdHJpbmcodG1wUHJvamVjdHNPYmouZmluaXNoQW1vdW50LCAtMSk7XG4gICAgcHJvamVjdHNPYmouc2V0dGxlSW5jb21lQW1vdW50ID0gdG1wUHJvamVjdHNPYmouc2V0dGxlSW5jb21lQW1vdW50O1xuICAgIHByb2plY3RzT2JqLnNldHRsZUluY29tZUFtb3VudFN0ciA9IGNvbW1vbi5nZXRQcmljZVN0cmluZyh0bXBQcm9qZWN0c09iai5zZXR0bGVJbmNvbWVBbW91bnQsIC0xKTtcbiAgICBwcm9qZWN0c09iai5hbGxvd1JhaXNlRGV0YWlsID0gdG1wUHJvamVjdHNPYmouYWxsb3dSYWlzZURldGFpbDtcbiAgICBsZXQgb2JqVGVybSA9IHRtcFByb2plY3RzT2JqLnRlcm0gPyB0bXBQcm9qZWN0c09iai50ZXJtIDogXCJcIjtcbiAgICBwcm9qZWN0c09iai5zaG93RGF0ZSA9IGAke25ldyBEYXRlKHRtcFByb2plY3RzT2JqLnN1YnNjcmliZUVuZFRpbWUpLkZvcm1hdChcInl5eXkvTU0vZGRcIil9IH4gJHtuZXcgRGF0ZSh0bXBQcm9qZWN0c09iai5lbmRUaW1lKS5Gb3JtYXQoXCJ5eXl5L01NL2RkXCIpfe+8iCR7b2JqVGVybX0keyRpMThuLm5fbWluaW5nX2RheV90ZXh0fe+8iWA7XG4gICAgcHJvamVjdHNPYmouc2hvd0Rlc2MgPSBcIlwiXG4gICAgaWYodG1wUHJvamVjdHNPYmoudmlld1N0YXR1cyA9PSAyKSB7XG4gICAgICBwcm9qZWN0c09iai5zaG93RGVzYyA9IGAkeyRpMThuLm5fc2hhcmtfZmluX3JhaXNlZF9hbW91bnR9OiBgO1xuICAgICAgcHJvamVjdHNPYmouc2hvd051bWJlciA9IGAke2NvbW1vbi5nZXRQcmljZVN0cmluZyh0bXBQcm9qZWN0c09iai5maW5pc2hBbW91bnQsIC0xKX0gJHt0bXBQcm9qZWN0c09iai5xdW90ZUN1cnJlbmN5fWA7XG4gICAgfSBlbHNlIGlmKHRtcFByb2plY3RzT2JqLnZpZXdTdGF0dXMgPT0gMykge1xuICAgICAgcHJvamVjdHNPYmouc2hvd0Rlc2MgPSBgJHskaTE4bi4kaW50ZXJjZXB0Lm5fc2hhcmtfZmluX3NldHRsZW1lbnRfaW50ZXJlc3QoXCJcIil9YDtcbiAgICAgIHByb2plY3RzT2JqLnNob3dOdW1iZXIgPSBgJHtjb21tb24uZ2V0UHJpY2VTdHJpbmcodG1wUHJvamVjdHNPYmouc2V0dGxlSW5jb21lQW1vdW50LCAtMSl9ICR7dG1wUHJvamVjdHNPYmoucXVvdGVDdXJyZW5jeX1gO1xuICAgIH1cblxuICAgIGNvbnNvbGUubG9nKFwidXBkYXRhRGF0YSAyIFwiICArIHRtcFByb2plY3RzT2JqLmFsbG93UmFpc2VEZXRhaWwpO1xuXG4gICAgcHJvamVjdHNPYmouaXNTaG93RGVzYyA9IHRtcFByb2plY3RzT2JqLmFsbG93UmFpc2VEZXRhaWwgPyBcInZpc2libGVcIiA6IFwiZ29uZVwiO1xuICAgIFxuICAgIHZhciBhcnJheSA9IFtdO1xuXG4gICAgYXJyYXkucHVzaCh7XG4gICAgICBcInNob3dEYXRlXCI6IHByb2plY3RzT2JqLnNob3dEYXRlLFxuICAgICAgXCJzaG93RGVzY1wiOiBwcm9qZWN0c09iai5zaG93RGVzYyxcbiAgICAgIFwic2hvd051bWJlclwiOiBwcm9qZWN0c09iai5zaG93TnVtYmVyLFxuICAgICAgXCJpc1Nob3dEZXNjXCI6IHByb2plY3RzT2JqLmlzU2hvd0Rlc2MsXG4gICAgICBcImluZGV4XCI6IGksXG4gICAgICBcInR5cGVcIjogXCJoZWFkZXJcIixcbiAgICB9KTtcblxuICAgIGNvbnNvbGUubG9nKFwidXBkYXRhRGF0YSAzXCIgKTtcblxuICAgIGZvciAodmFyIGogPSAwOyBqIDwgdG1wUHJvamVjdHNPYmoucHJvamVjdHMubGVuZ3RoOyBqKyspIHtcbiAgICAgIGNvbnNvbGUubG9nKFwidXBkYXRhRGF0YSA0XCIpO1xuICAgICAgbGV0IHRtcE9iaiA9IHRtcFByb2plY3RzT2JqLnByb2plY3RzW2pdO1xuICAgICAgbGV0IG9iaiA9IHtcbiAgICAgICAgXCJ0aXRsZVwiOiB0bXBPYmouY2FsbFB1dCA9PSAtMSA/ICRpMThuLiRpbnRlcmNlcHQubl9zaGFya19maW5fYmVhcmlzaCh0bXBPYmouY3VycmVuY3kpIDogJGkxOG4uJGludGVyY2VwdC5uX3NoYXJrX2Zpbl9idWxsaXNoKHRtcE9iai5jdXJyZW5jeSksXG4gICAgICAgIFwidGVybVwiOiBgJHt0bXBPYmoudGVybX0gJHskaTE4bi5uX21pbmluZ19kYXlfdGV4dH1gLFxuICAgICAgICBcImZpbmlzaEFtb3VudFN0clwiOiBjb21tb24uZ2V0UHJpY2VTdHJpbmcodG1wT2JqLmZpbmlzaEFtb3VudCwgLTEpLFxuICAgICAgICBcInNldHRsZUluY29tZUFtb3VudFN0clwiOiBjb21tb24uZ2V0UHJpY2VTdHJpbmcodG1wT2JqLnNldHRsZUluY29tZUFtb3VudCwgLTEpLFxuICAgICAgICBcInR5cGVcIjogXCJub3JtYWxcIixcbiAgICAgICAgXCJpZFwiIDogdG1wT2JqLmlkLFxuICAgICAgICBcInRlcm1TdHJcIjpgJHt0bXBPYmoudGVybX1gLFxuICAgICAgICBcInVwRG93blwiOiB0bXBPYmouY2FsbFB1dCA9PSAtMSA/IFwiYmVhcnJpc2hcIjpcImJ1bGxpc2hcIixcbiAgICAgICAgXCJjdXJyZW5jeVwiOnRtcE9iai5jdXJyZW5jeVxuICAgICAgfVxuXG4gICAgICBpZih0bXBQcm9qZWN0c09iai52aWV3U3RhdHVzID09IDIpIHtcbiAgICAgICAgb2JqLnNob3dSYXRlID0gYCR7Y29tbW9uLmZvcm1hdFByZWNpc2lvbihudW1iZXIubXVsdGlwbHkodG1wT2JqLm1pblJhdGUsIFwiMTAwXCIpLCAyKX0lfiR7Y29tbW9uLmZvcm1hdFByZWNpc2lvbihudW1iZXIubXVsdGlwbHkodG1wT2JqLm1heFJhdGUsIFwiMTAwXCIpLCAyKX0lYDtcbiAgICAgICAgLy/lvZPliY3ku7fmoLxcbiAgICAgICAgb2JqLnNob3dEZXRhaWwgPSAkaTE4bi4kaW50ZXJjZXB0Lm5fc2hhcmtfZmluX25vd19wcmljZV9uZXcodG1wT2JqLmN1cnJlbmN5LCBgJCAke2NvbW1vbi5nZXRQcmljZVN0cmluZyh0bXBPYmouY3VycmVudFByaWNlLCAtMSl9YCk7XG4gICAgICB9IGVsc2UgaWYodG1wUHJvamVjdHNPYmoudmlld1N0YXR1cyA9PSAzKSB7XG4gICAgICAgIG9iai5zaG93UmF0ZSA9IGAke2NvbW1vbi5mb3JtYXRQcmVjaXNpb24obnVtYmVyLm11bHRpcGx5KHRtcE9iai5maW5hbFJhdGUsIFwiMTAwXCIpLCAyKX0lYDtcbiAgICAgICAgLy/nu5Pnrpfku7fmoLxcbiAgICAgICAgb2JqLnNob3dEZXRhaWwgPSAkaTE4bi4kaW50ZXJjZXB0Lm5fc2hhcmtfZmluX3NldHRsZW1lbnRfcHJpY2VfMl9uZXcodG1wT2JqLmN1cnJlbmN5LCBgJCAke2NvbW1vbi5nZXRQcmljZVN0cmluZyh0bXBPYmouc2V0dGxlbWVudFByaWNlLCAtMSl9YCk7XG4gICAgICB9XG5cbiAgICAgIGFycmF5LnB1c2gob2JqKTtcbiAgICB9XG5cbiAgICBhcnJheS5wdXNoKHtcbiAgICAgIFwiaW5kZXhcIjogaSxcbiAgICAgIFwidHlwZVwiOiBcImVtcHR5XCIsXG4gICAgfSk7XG5cbiAgICBjb25zb2xlLmxvZyhcInVwZGF0YURhdGEgNVwiICk7XG5cbiAgICBhbGxhcnJheS5wdXNoKC4uLmFycmF5KTtcbiAgICBwcm9qZWN0c09iai5wcm9qZWN0cyA9IGFycmF5O1xuICAgIGRhdGFPYmplY3RzLmRhdGFPYmplY3RzLnB1c2gocHJvamVjdHNPYmopO1xuICB9XG5cbiAgZGF0YU9iamVjdHMuYWxsYXJyYXkgPSBhbGxhcnJheTtcblxuICByZXR1cm4gZGF0YU9iamVjdHM7XG59XG5cbmFzeW5jIGZ1bmN0aW9uIHRhYkNsaWNrKHRhZykge1xuICBjb25zb2xlLmxvZygndGFiQ2xpY2sgaGlzdG9yeScgKyBKU09OLnN0cmluZ2lmeSh0YWcpKTtcbiAgdmFyIGluZGV4ID0gdGFnID09IFwib25Hb2luZ1wiID8gXCIwXCIgOiBcIjFcIjtcbiAgaWYobW9kdWxlRGF0YS5jdXJyZW50SW5kZXggIT0gaW5kZXgpIHtcbiAgICBtb2R1bGVEYXRhLmN1cnJlbnRJbmRleCA9IGluZGV4O1xuICB9XG4gIGF3YWl0IHJlc2V0VGl0bGVTZWxlY3RUYWIoaW5kZXgpO1xufVxuXG5hc3luYyBmdW5jdGlvbiByZXNldFRpdGxlU2VsZWN0VGFiKGluZGV4KSB7XG4gIGNvbnNvbGUubG9nKGByZXNldFRpdGxlU2VsZWN0VGFiIGluZGV4ID0gJHtpbmRleH1gKTtcbiAgaWYoaW5kZXggPT0gXCIwXCIpIHtcbiAgICBtb2R1bGVEYXRhLmZpbmlzaGVkVGl0bGVDb2xvciA9IGhpc3RvcnlfdGl0bGVDb2xvcl9Ob3JtYWw7XG4gICAgbW9kdWxlRGF0YS5vbkdvaW5nVGl0bGVDb2xvciA9IGhpc3RvcnlfdGl0bGVDb2xvcl9TZWxlY3RlZDtcbiAgICBjb21tb24uYW5hbHl0aWNzKFwiYXBwX2Vhcm5fc2hha2VGaW5MaXN0aW5nc19lYXJuaW5nX3Nob3dcIik7XG4gIH0gZWxzZSB7XG4gICAgbW9kdWxlRGF0YS5maW5pc2hlZFRpdGxlQ29sb3IgPSBoaXN0b3J5X3RpdGxlQ29sb3JfU2VsZWN0ZWQ7XG4gICAgbW9kdWxlRGF0YS5vbkdvaW5nVGl0bGVDb2xvciA9IGhpc3RvcnlfdGl0bGVDb2xvcl9Ob3JtYWwgO1xuICAgIGNvbW1vbi5hbmFseXRpY3MoXCJhcHBfZWFybl9zaGFrZUZpbkxpc3RpbmdzX2V4cGlyZWRfc2hvd1wiKTtcbiAgfVxuXG59XG5cbmZ1bmN0aW9uIG9wZW5EZXRhaWwoaW5kZXgpIHtcbiAgdmFyIGRhdGFPYmplY3QgPSAgbW9kdWxlRGF0YS5saXN0RGF0YVttb2R1bGVEYXRhLmN1cnJlbnRJbmRleF07XG4gIGlmICggaW5kZXggPj0gZGF0YU9iamVjdC5kYXRhLmxlbmd0aCkge1xuICAgIHJldHVybjtcbiAgfVxuICB2YXIgaXRlbSA9IGRhdGFPYmplY3QuZGF0YVtpbmRleF07XG4gIGNvbW1vbi5hbmFseXRpY3MoXCJhcHBfZWFybl9zaGFrZUZpbkxpc3RpbmdzX3Byb2R1Y3RfY2xpY2tcIix7XG4gICAgXCJ0eXBlXCI6aXRlbS51cERvd24sXG4gICAgXCJjdXJyZW5jeVwiOml0ZW0uY3VycmVuY3ksXG4gICAgXCJ0ZXJtXCI6aXRlbS50ZXJtU3RyLFxuICB9KTtcbiAgY29tbW9uLm9wZW5VUkwoYGhvbGlnZWl0Oi8vb3Blbi92MT9sb2dpbj0xJnVybD1paHVvYmlnbG9iYWw6Ly9tLmhiZy5jb20vZWRnZWVuZ2luZS9jb250YWluZXI/c2NlbmU9c2hhcmtmaW4mcm9vdE5hbWU9ZGV0YWlsJnR5cGU9cHJvamVjdCZuYXZDb25maWc9JmlkPSR7aXRlbS5pZH1gKTtcbn1cblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIG9uTG9hZE1vcmUoKSB7XG4gIGNvbnNvbGUubG9nKFwib25Mb2FkTW9yZSBcIik7XG4gIGlmKG1vZHVsZURhdGEuY3VycmVudEluZGV4ID09IDApIHtcbiAgICByZXF1ZXN0U2hhcmtQcmV2UmVjb3Jkc0RhdGEoaGlzdG9yeV9vbkdvaW5nUGFnZSwgbW9kdWxlRGF0YS5vbkdvaW5nUGFnZSk7XG4gICAgbW9kdWxlRGF0YS5saXN0RGF0YVswXS5sb2FkTW9yZVN0YXR1cyA9IFwiMlwiO1xuICB9IGVsc2UgaWYobW9kdWxlRGF0YS5jdXJyZW50SW5kZXggPT0gMSkge1xuICAgIHJlcXVlc3RTaGFya1ByZXZSZWNvcmRzRGF0YShoaXN0b3J5X2ZpbmlzaGVkUGFnZSwgbW9kdWxlRGF0YS5maW5pc2hlZFBhZ2UpO1xuICAgIG1vZHVsZURhdGEubGlzdERhdGFbMV0ubG9hZE1vcmVTdGF0dXMgPSBcIjJcIjtcbiAgfVxufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gcHJvamVjdFRpdGxlQ2xpY2soaW5kZXgpIHtcbiAgY29uc29sZS5sb2coXCJwcm9qZWN0VGl0bGVDbGljayBcIiArIGluZGV4KTtcblxuICB2YXIgY3VycmVudFBhZ2UgPSBtb2R1bGVEYXRhLmN1cnJlbnRJbmRleDtcbiAgY29uc29sZS5sb2coXCJwcm9qZWN0VGl0bGVDbGljayBjdXJyZW50UGFnZSA9IFwiICsgY3VycmVudFBhZ2UgKTtcblxuICB2YXIgcHJvamVjdERhdGEgPSBjdXJyZW50UGFnZSA9PSAwID8gbW9kdWxlRGF0YS5vbkdvaW5nRGF0YVtpbmRleF0gOiBtb2R1bGVEYXRhLmZpbmlzaGVkRGF0YVtpbmRleF07XG5cbiAgLy8gY29uc29sZS5sb2coXCJwcm9qZWN0VGl0bGVDbGljayBkYXRhID0gXCIgKyBKU09OLnN0cmluZ2lmeShjdXJyZW50UGFnZSA9PSAwID8gb25Hb2luZ0RhdGEgOiBmaW5pc2hlZERhdGEpKTtcblxuICB2YXIgcHJvamVjdExpc3QgPSBwcm9qZWN0RGF0YS5wcm9qZWN0cztcblxuICBjb25zb2xlLmxvZyhcInByb2plY3RUaXRsZUNsaWNrIGRhdGEgPSAxXCIpO1xuXG4gIHZhciBwb3BsaXN0RGF0YSA9IHtcbiAgICBcInRpdGxlXCIgOiBwcm9qZWN0RGF0YS52aWV3U3RhdHVzID09IDIgPyAkaTE4bi5uX3NoYXJrX2Zpbl9yYWlzZWRfYW1vdW50IDogJGkxOG4ubl9zaGFya19maW5fc2V0dGxlbWVudF9pbnRlcmVzdF90aXRsZSxcbiAgICBcImxlZnRcIiA6ICRpMThuLm5fc2hhcmtfZmluX3Byb2R1Y3QsXG4gICAgXCJtaWRkbGVcIiA6IHByb2plY3REYXRhLnZpZXdTdGF0dXMgPT0gMiA/IFwiXCIgOiBgJHskaTE4bi5uX3NoYXJrX2Zpbl9wcmluY2lwYWx9KCR7cHJvamVjdERhdGEucXVvdGVDdXJyZW5jeX0pYCxcbiAgICBcInJpZ2h0XCIgOiBwcm9qZWN0RGF0YS52aWV3U3RhdHVzID09IDIgPyBgJHskaTE4bi5uX3NoYXJrX2Zpbl9wcmluY2lwYWx9KCR7cHJvamVjdERhdGEucXVvdGVDdXJyZW5jeX0pYCA6IGAkeyRpMThuLm5fc2hhcmtfZmluX2ludGVyZXN0fSgke3Byb2plY3REYXRhLnF1b3RlQ3VycmVuY3l9KWAsXG4gICAgXCJmaW5pc2hBbW91bnRTdHJcIjogcHJvamVjdERhdGEuZmluaXNoQW1vdW50U3RyLFxuICAgIFwic2V0dGxlSW5jb21lQW1vdW50U3RyXCI6IHByb2plY3REYXRhLnNldHRsZUluY29tZUFtb3VudFN0cixcbiAgICBcImlzU2hvd0luY29tZVwiOiBwcm9qZWN0RGF0YS52aWV3U3RhdHVzID09IDIgPyBcImdvbmVcIiA6IFwidmlzaWJsZVwiLFxuICAgIFwicHJvamVjdExpc3RcIjogW11cbiAgfTtcblxuICBmb3IgKHZhciBpID0gMDsgaSA8IHByb2plY3RMaXN0Lmxlbmd0aDsgaSsrKSB7XG4gICAgbGV0IHRtcE9iaiA9IHByb2plY3RMaXN0W2ldO1xuICAgIGlmKHRtcE9iai50eXBlID09IFwibm9ybWFsXCIpIHtcbiAgICAgIGxldCBvYmogPSB7XG4gICAgICAgIFwiY2VsbFR5cGVcIjpcIm5vcm1hbFwiLFxuICAgICAgICBcImxlZnRcIjogdG1wT2JqLnRpdGxlLFxuICAgICAgICBcIm1pZGRsZVwiOiBwcm9qZWN0RGF0YS52aWV3U3RhdHVzID09IDIgPyBcIlwiIDogdG1wT2JqLmZpbmlzaEFtb3VudFN0cixcbiAgICAgICAgXCJyaWdodFwiOiAgcHJvamVjdERhdGEudmlld1N0YXR1cyA9PSAyID8gdG1wT2JqLmZpbmlzaEFtb3VudFN0ciA6IHRtcE9iai5zZXR0bGVJbmNvbWVBbW91bnRTdHIsXG4gICAgICB9XG4gICAgICBwb3BsaXN0RGF0YS5wcm9qZWN0TGlzdC5wdXNoKG9iaik7XG4gICAgfVxuICB9XG5cbiAgY29uc29sZS5sb2coXCJwcm9qZWN0VGl0bGVDbGljayBkYXRhID0gXCIgKyBKU09OLnN0cmluZ2lmeShwb3BsaXN0RGF0YSkpO1xuXG4gIG1vZHVsZURhdGEucG9wbGlzdERhdGEgPSBwb3BsaXN0RGF0YTtcbiAgbW9kdWxlRGF0YS5hbGVydFBvcFNob3cgPSB0cnVlO1xuICBjb21tb24uYW5hbHl0aWNzKHByb2plY3REYXRhLnZpZXdTdGF0dXMgPT0gMiA/IFwiYXBwX2Vhcm5fc2hha2VGaW5MaXN0aW5nc19hbW91bnRSYWlzZWRFeHBsYW5hdGlvbl9jbGlja1wiOlwiYXBwX2Vhcm5fc2hha2VGaW5MaXN0aW5nc19zZXR0bGVtZW50SW50ZXJlc3RFeHBsYW5hdGlvbl9jbGlja1wiKTtcblxuICBjb25zb2xlLmxvZyhcInNob3dwb3AgXCIpO1xufVxuXG4kZXZlbnQuaGlzdG9yeVBvcCA9IHtcblxufTtcblxuJGV2ZW50Lmhpc3RvcnlQb3AuY2FuY2VsID0gZnVuY3Rpb24gKCkge1xuICBtb2R1bGVEYXRhLmFsZXJ0UG9wU2hvdyA9IGZhbHNlO1xufTtcblxuJGV2ZW50Lmhpc3RvcnlQb3AucG9wRGlzbWlzcyA9IGZ1bmN0aW9uICgpIHtcbiAgaWYgKG1vZHVsZURhdGEuYWxlcnRQb3BTaG93ICE9IGZhbHNlKSB7XG4gICAgbW9kdWxlRGF0YS5hbGVydFBvcFNob3cgPSBmYWxzZTtcbiAgfVxufTtcblxubW9kdWxlRXZlbnQucHJvamVjdFRpdGxlQ2xpY2sgPSBwcm9qZWN0VGl0bGVDbGljaztcbm1vZHVsZUV2ZW50LnRhYkNsaWNrID0gdGFiQ2xpY2s7XG5tb2R1bGVFdmVudC5yZXNldFRpdGxlU2VsZWN0VGFiID0gcmVzZXRUaXRsZVNlbGVjdFRhYjtcbm1vZHVsZUV2ZW50Lm9uTG9hZE1vcmUgPSBvbkxvYWRNb3JlO1xubW9kdWxlRXZlbnQub3BlbkRldGFpbCA9IG9wZW5EZXRhaWw7IiwiaW1wb3J0ICogYXMgY29tbW9uIGZyb20gXCIuL2NvbW1vblwiO1xuaW1wb3J0ICogYXMgYWxlcnQgZnJvbSBcIi4vYWxlcnRcIjtcbmltcG9ydCAqIGFzIGRlcG9zaXQgZnJvbSBcIi4vZGVwb3NpdFwiO1xuaW1wb3J0ICogYXMgcG5scnVsZSBmcm9tIFwiLi9wbmxydWxlXCI7XG5pbXBvcnQgKiBhcyBkZXRhaWwgZnJvbSBcIi4vZGV0YWlsXCI7XG5pbXBvcnQgKiBhcyBpbnRyb2R1Y2UgZnJvbSBcIi4vaW50cm9kdWNlXCI7XG5pbXBvcnQgKiBhcyBob21lIGZyb20gXCIuL2hvbWVcIjtcbmltcG9ydCAqIGFzIGhpc3RvcnkgZnJvbSBcIi4vaGlzdG9yeVwiO1xuXG5mdW5jdGlvbiBzZW5kQ29tbW9uQ29uZmlnKHBhcmFtKSB7XG4gIGNvbW1vbi5nZXRDb21tb25Db25maWcocGFyYW0pO1xufVxuXG4kZXZlbnQuc2VuZENvbW1vbkNvbmZpZyA9IHNlbmRDb21tb25Db25maWc7XG4iXSwibmFtZXMiOlsiRFAiLCJSTSIsIk1BWF9EUCIsIk1BWF9QT1dFUiIsIk5FIiwiUEUiLCJOQU1FIiwiSU5WQUxJRCIsIklOVkFMSURfRFAiLCJJTlZBTElEX1JNIiwiRElWX0JZX1pFUk8iLCJQIiwiVU5ERUZJTkVEIiwiTlVNRVJJQyIsIl9CaWdfIiwiQmlnIiwibiIsIngiLCJ0aGlzIiwicyIsImUiLCJjIiwic2xpY2UiLCJwYXJzZSIsImNvbnN0cnVjdG9yIiwicHJvdG90eXBlIiwidmVyc2lvbiIsImkiLCJubCIsInRlc3QiLCJFcnJvciIsImNoYXJBdCIsImluZGV4T2YiLCJyZXBsYWNlIiwic2VhcmNoIiwic3Vic3RyaW5nIiwibGVuZ3RoIiwicm91bmQiLCJkcCIsInJtIiwibW9yZSIsInhjIiwidW5zaGlmdCIsInBvcCIsInN0cmluZ2lmeSIsImlkIiwiayIsInoiLCJwdXNoIiwiam9pbiIsImFicyIsImNtcCIsInkiLCJpc25lZyIsInljIiwiaiIsImwiLCJkaXYiLCJhIiwiYiIsImJsIiwiYnQiLCJyaSIsImJ6IiwiYWkiLCJhbCIsInIiLCJybCIsInEiLCJxYyIsInFpIiwiZCIsInNoaWZ0IiwiZXEiLCJndCIsImd0ZSIsImx0IiwibHRlIiwibWludXMiLCJzdWIiLCJ0IiwieGx0eSIsInBsdXMiLCJ4ZSIsInllIiwicmV2ZXJzZSIsIm1vZCIsInlndHgiLCJ0aW1lcyIsImFkZCIsInBvdyIsIm9uZSIsInNxcnQiLCJoYWxmIiwiTWF0aCIsInRvRXhwb25lbnRpYWwiLCJtdWwiLCJBcnJheSIsInRvRml4ZWQiLCJ0b1ByZWNpc2lvbiIsInNkIiwidG9TdHJpbmciLCJ2YWx1ZU9mIiwidG9KU09OIiwibXVsdGlwbHkiLCJmb3JtYXQiLCJ2YWx1ZSIsInByZWNpc2lvbiIsImJpZ1ZhbHVlIiwic3RyaW5nVmFsdWUiLCJpbmNsdWRlcyIsInN0ckFycmF5Iiwic3BsaXQiLCJ0cnVuY2F0ZSIsInplcm9OdW1iZXIiLCJzdHIiLCJjbGlja2FibGUiLCJtb2R1bGVEZWZpbmUiLCJtb2R1bGVOYW1lIiwiZGVmYXVsdERhdGFGdW5jdGlvbiIsImZ1bmN0aW9ucyIsIm9uQ3JlYXRlIiwib25EZXN0cm95Iiwib25SZXN1bWUiLCJvblBhdXNlIiwib25TdGFydCIsIm9uU3RvcCIsImNvbnNvbGUiLCJsb2ciLCIkZGF0YSIsIiRldmVudCIsIm1vZHVsZURhdGEiLCJtb2R1bGVFdmVudCIsImFzeW5jIiwiYW5hbHl0aWNzIiwiZXZlbnQiLCJwcm9wZXJ0aWVzIiwicHJvcGVydGllc0pzb24iLCJKU09OIiwibWFwIiwiJG5hdGl2ZUFQSSIsImNvbW1vbkRhdGEiLCJwcmljZUNvbG9yVHlwZSIsImNvbG9yTW9kZSIsIk9TIiwiYXBwVmVyc2lvbiIsImlzSW5SZXZpZXciLCJoNVVybCIsImxhbmd1YWdlIiwic3RhdHVzSGVpZ2h0IiwidlRva2VuIiwib2xkVlRva2VuIiwib3BlblVSTCIsInVybCIsIm9wZW5Sb3V0ZSIsInNldFRpbWVvdXQiLCJnZXRDb21tb25Db25maWciLCJwYXJhbSIsInBhcnNlSW50IiwiZGVwb3NpdCIsImRldGFpbCIsInNlbmRSZXF1ZXN0IiwicGF0aCIsInBhcmFtcyIsIm1ldGhvZCIsImhvc3RUeXBlIiwiaGVhZGVyIiwicmVzcG9uc2VTdHJpbmciLCJyZXF1ZXN0IiwicmVzcG9uc2UiLCJjb2RlIiwiZGF0YSIsInN0YXR1cyIsImVycl9jb2RlIiwiZXJyX21zZyIsInN0YXJ0Iiwic3RhcnRJbmRleCIsImVuZCIsImVuZEluZGV4IiwiZGF0YVN0cmluZyIsInNob3dUb2FzdCIsIm1lc3NhZ2UiLCJtc2ciLCJoYlRvYXN0Iiwic2hvd0xvYWRpbmciLCJpc1Nob3ciLCJEYXRlIiwiRm9ybWF0IiwiZm10IiwibyIsImdldE1vbnRoIiwiZ2V0RGF0ZSIsImdldEhvdXJzIiwiZ2V0TWludXRlcyIsImdldFNlY29uZHMiLCJmbG9vciIsIlMiLCJnZXRNaWxsaXNlY29uZHMiLCJSZWdFeHAiLCIkMSIsImdldEZ1bGxZZWFyIiwic3Vic3RyIiwiZm9ybWF0UHJlY2lzaW9uIiwicmVzdWx0IiwibnVtYmVyLmZvcm1hdCIsImNvbnRhaW5lckJhY2siLCJnZXRQcmljZVN0cmluZyIsInByaWNlU3RyIiwicHJpY2VOdW0iLCJOdW1iZXIiLCJwcmljZVN0cmluZyIsImZpbmFsUHJpY2VTdHIiLCJnZXRQcmljZUNvbG9yIiwiaXNSaXNlIiwiYWxlcnQiLCJjb250ZW50IiwidGl0bGUiLCIkaTE4biIsIm5fY29weV90cmFkaW5nX3RpcCIsImFsZXJ0UG9wU2hvdyIsInByaWNlVGlwcyIsInNob3dMaW1pdEFsZXJ0IiwiY2xvc2VLZXlCb2FyZCIsInVzZXJTdXJwbHVzQWxlcnQiLCJzaG93U2V0dGxlbWVudEFsZXJ0IiwiY29tbW9uLmFuYWx5dGljcyIsInNob3dBdXRvU3Vic2NyaWJlQWxlcnQiLCJuX3NoYXJrX2Zpbl9hdXRvU3Vic2NyaWJlX3RpdGxlIiwibl9zaGFya19maW5fYXV0b1N1YnNjcmliZV9jb250ZW50XzEiLCJuX3NoYXJrX2Zpbl9hdXRvU3Vic2NyaWJlX2NvbnRlbnRfMiIsImNvbmZpcm0iLCJwcm9qZWN0SWQiLCJvcmRlcklkIiwibmVlZFJlZnJlc2giLCJzVGltZSIsInN5c1RpbWUiLCJzdGFydFRpbWUiLCJpbnRlcmNhbCIsIm1tIiwiaGgiLCJkZCIsImF1dG9TdWJzY3JpYmUiLCJkZWZhdWx0RGF0YSIsImRhdGFsaXN0IiwiaW5wdXREYXRhIiwiY29uZmlybVNob3ciLCJzdWNjZXNzU2hvdyIsImNvbmZpcm1saXN0Iiwib25Gb2N1cyIsIm9uRm9jdXNJbnRlcm5hbCIsImVkaXRUZXh0IiwiaW5wdXRUZXh0IiwiYmFsYW5jZUFtb3VudCIsInVzZXJMb3dlckxpbWl0IiwidXNlclN1cnBsdXNBbW91bnQiLCJzdXJwbHVzQW1vdW50IiwiY29pbiIsInVuaXQiLCJidXR0b25FbmFibGVkIiwiYnRuQ29sb3IiLCJjb25maXJtQnRuQ29sb3IiLCJodW9iaVNlbGVjdGVkIiwiaHVvYmlBZ3JlZUltYWdlIiwibmF2VGl0bGUiLCJzdWNjZXNzVGV4dCIsImVtcHR5Iiwibm90RW1wdHkiLCJzaG93SW5wdXQiLCJidG5UaXRsZSIsIm5lZWRDb3VudERvd24iLCJib3JkZXJDb2xvciIsInN3aXRjaENvbG9yIiwic3dpdGNoQmFja0NvbG9yIiwic3dpdGNoV2lkdGgiLCJldmVudFBhcmFtcyIsInJlbG9hZERhdGEiLCJidXR0b25DaGFuZ2VTdGF0dXMiLCJzdGF0dXNCYXJDb25maWciLCJzdGF0dXNCYXJNb2RlIiwic2hvd0RldGFpbEVtcHR5IiwicmVxdWVzdEJ1eURldGFpbCIsImNsZWFyVGltZXIiLCJzdGFydFRpbWVyIiwiY29tbW9uLm1vZHVsZURlZmluZSIsImNvbW1vbi5zaG93TG9hZGluZyIsImNvbW1vbi5zZW5kUmVxdWVzdCIsImhhbmRsZURldGFpbERhdGEiLCJnZXRUaW1lIiwicHJvamVjdERldGFpbCIsImN1cnJlbmN5IiwicXVvdGVDdXJyZW5jeSIsIm1pblJhdGUiLCJjb21tb24uZm9ybWF0UHJlY2lzaW9uIiwibnVtYmVyLm11bHRpcGx5IiwibWF4UmF0ZSIsImV4cGlyeVRpbWUiLCJjYWxsUHV0VGV4dCIsImNhbGxQdXQiLCIkaW50ZXJjZXB0Iiwibl9zaGFya19maW5fYnVsbGlzaCIsIm5fc2hhcmtfZmluX2JlYXJpc2giLCJjYWxsUHV0Q29sb3IiLCJjb21tb24uZ2V0UHJpY2VDb2xvciIsInR5cGUiLCJuYW1lIiwibl9zaGFya19maW5fQVBZX0VzdCIsIm5fbWluaW5nX2R1cmF0aW9uIiwidGVybSIsIm5fbWluaW5nX2RheV90ZXh0Iiwibl9taW5pbmdfZW5kX3RpbWUiLCJuX3NoYXJrX2Zpbl9wcm9kdWN0X3R5cGUiLCJzdGF0ZSIsInN0YXRlQ29sb3IiLCJuX2Fzc2V0X3N1YnNjcmliZV9udW1iZXIiLCJuX2Fzc2V0c190cmFuc2Zlcl9zcG90Iiwibl9zaGFya19maW5fYXV0b1N1YnNjcmliZSIsInVzZXJTdXJwbHVzIiwiY29tbW9uLmdldFByaWNlU3RyaW5nIiwibl9zaGFya19maW5fYWxlcnRfbGltaXRfbmV3IiwiYmFsYW5jZVRpdGxlQ29sb3IiLCJiYWxhbmNlQ29sb3IiLCJ1c2VyU3VycGx1c0NvbG9yIiwic3VycGx1c0NvbG9yIiwiYmFsYW5jZSIsImhpbnQiLCJuX3NoYXJrX2Zpbl9taW5fYW1vdW50Iiwic3VycGx1cyIsInZpZXdTdGF0dXMiLCJzdWJzY3JpYmVTdGFydFRpbWUiLCJjaGFuZ2VDb3VudGRvd24iLCJuX2JhbGFuY2Vfc3Vic2NyaWJlX2J0biIsInBubHJ1bGUiLCJoYW5kbGVEYXRhIiwiaW5wdXROdW1iZXIiLCJwYXJzZUZsb2F0Iiwibm9ybWFsQ29sb3IiLCJzaG93Iiwic2V0SW50ZXJ2YWwiLCJjbGVhckludGVydmFsIiwic2VydmVyVGltZURpZmYiLCJzeXNUaW1lRGlmZiIsImRpZmZlcmVuY2UiLCJoIiwibSIsInNob3dIIiwic2hvd00iLCJzaG93UyIsImlucHV0TnVtIiwiaW5wdXRSZSIsImlzTmFOIiwiZm9jdXNDaGFuZ2UiLCJmb2N1cyIsInRleHRDaGFuZ2UiLCJ0ZXh0Iiwib25SZXR1cm4iLCJjbGlja2VkQWxsIiwibWluQW1vdW50IiwibWluIiwidG9CYWNrIiwiY29tbW9uLmNvbnRhaW5lckJhY2siLCJiYWNrQ2xpY2tlZCIsInBvcENvbmZpcm1PcGVuIiwibl9zaGFya19maW5fYXV0b1N1YnNjcmliZV9jbG9zZSIsIm5fc2hhcmtfZmluX2F1dG9TdWJzY3JpYmVfb3BlbiIsInBvcENvbmZpcm1DbG9zZSIsImh1b2JpbGluayIsImNvbW1vbi5vcGVuVVJMIiwiY29tbW9uLmNvbW1vbkRhdGEiLCJwb3BTdWNjZXNzT3BlbiIsImFtb3VudCIsInBvcFN1Y2Nlc3NDbG9zZSIsIm9wZW5EZXRhaWwiLCJqdW1wVG9UcmFuc2ZlciIsImp1bXBUb0J1eUNvaW4iLCJhdXRvQ2xpY2tlZCIsInN1YlRpdGxlIiwiS2V5VGl0bGUiLCJrZXkxIiwia2V5MiIsInZhbHVlMSIsInZhbHVlMiIsIm1pblByaWNlIiwibWF4UHJpY2UiLCJzcmMiLCJzaG93SWNvbiIsInNob3dDb250ZW50IiwiYmFycmllciIsInNldHRsZW1lbnRQcmljZSIsIm5fc2hhcmtfZmluX3NldHRsZW1lbnRfcHJpY2UiLCJzZXR0bGVtZW50UmVtYXJrVHlwZSIsIm5fc2hhcmtfZmluX3RvYXN0XzMiLCJzZXR0bGVtZW50UHJpY2VUaW1lIiwic2V0dGxlbWVudFByaWNlVGltZUVuZCIsIm5fc2hhcmtfZmluX3RvYXN0X2J1bGxpc2giLCJuX3NoYXJrX2Zpbl90b2FzdF9iZWFyaXNoIiwibl9zaGFya19maW5fY3VycmVudF9wcmljZV9uZXciLCJyZXF1ZXN0TWFya2V0UHJpY2UiLCJzdHJpa2UiLCJuX290Y19vcmRlcl9vciIsIm5fc2hhcmtfZmluX2FsZXJ0X3Byb2R1Y3RfbiIsImNsZWFyRGF0YSIsInNob3dJY29uQWxlcnQiLCJyZXFQYXJhbXMiLCJrZXkiLCJ0b0xvd2VyQ2FzZSIsInRQcmljZSIsImF1dG9TdWJzY3JpYmVTdGF0ZSIsImF1dG9PcmRlcklkIiwiY2VsbGxpc3QiLCJzdWJzY3JpYmVFbmRUaW1lIiwib3JkZXJTaG93IiwiYnV5TnVtYmVyIiwiYnV5UG5sIiwiYnV5TnVtYmVyQW1vdW50IiwiYnV5UG5sQW1vdW50Iiwic3dpdGNoT3BhY2l0eSIsInJlc3VsdFJlbWFyayIsIm5fc2hhcmtfZmluX2F1dG9TdWJzY3JpYmVfZGVzYyIsInJlc3VsdENvbG9yIiwibl9leGNoYW5nZV90aW1pbmdfZW50cnVzdF9kZXRhaWwiLCJyZXF1ZXN0T3JkZXJEZXRhaWwiLCJuX3NoYXJrX2Zpbl9wcm9kdWN0X2RldGFpbCIsInJlcXVlc3RQcm9qZWN0RGV0YWlsIiwibl9zaGFya19maW5fZGVwb3NpdF9wbmwiLCJ0b3RhbEluY29tZUFtb3VudCIsIm5fc2hhcmtfZmluX29ycGhhbiIsImF1dG9TdWJzY3JpYmVJbmZvIiwicmVzdWx0Q29kZSIsImF1dG9TdWJzY3JpYmVSZXN1bHRDb2RlIiwiYXV0b1N1YnNjcmliZVJlc3VsdFJlbWFyayIsImNoYW5nZVN3aXRjaFN0YXR1cyIsImNoYW5nZVN3aXRjaFJlbWFyayIsImZpbmFsUmF0ZSIsInN0YXR1ZVZhbHVlIiwiaGFuZGxlU3RhdHVzIiwiQVBZRXN0IiwiQVBZRXN0VmFsdWUiLCJuX3NoYXJrX2Zpbl9Fc3RfQVBZIiwibl9zaGFya19maW5fZGVwb3NpdF9pbmZvIiwibl9leGNoYW5nZV90aW1pbmdfb3JkZXJfc3RhdHVzIiwidGlwc1Nob3ciLCJuX3NoYXJrX2Zpbl9wcm9kdWN0Iiwibl9zaGFya19maW5fZWFybmluZyIsIm5fc2hhcmtfZmluX2V4cGlyZWQiLCJpc0VtcHR5Iiwic3RhdHVzQWxlcnQiLCJuX3NoYXJrX2Zpbl9hbGVydF9leHBpcmVkIiwibl9zaGFya19maW5fYWxlcnRfZWFybmluZyIsIm5fc2hhcmtfZmluX2FsZXJ0X29ycGhhbiIsImRlcG9zaXQudG9CYWNrIiwicmVtYXJrIiwibl9zaGFya19maW5fYXV0b1N1YnNjcmliZV9yZXN1bHRfMSIsIm5fc2hhcmtfZmluX2F1dG9TdWJzY3JpYmVfcmVzdWx0XzIiLCJuX3NoYXJrX2Zpbl9hdXRvU3Vic2NyaWJlX3Jlc3VsdF8zIiwibl9zaGFya19maW5fYXV0b1N1YnNjcmliZV9yZXN1bHRfNCIsIm5fc2hhcmtfZmluX2F1dG9TdWJzY3JpYmVfcmVzdWx0XzUiLCJnZXROYXZDb25maWdTdHJpbmciLCJuYXYiLCJ0aXRsZUtleSIsImxlZnQiLCJhY3Rpb24iLCJwYXJhbWV0ZXIiLCJpY29uIiwiY3VycmVudFRhZyIsImN1cnJlbnRJbmRleCIsInRpdGxlRGF0YSIsIm5fc2hhcmtfZmluX3Byb2R1Y3RfcnVsZSIsInRpdGxlU2l6ZSIsInRpdGxlQ29sb3IiLCJ0YWciLCJuX3NoYXJrX2Zpbl9jb21tb25fcHJvYmxlbSIsInNsaWRlckRhdGEiLCJsaXN0VHlwZSIsInByb2JsZW1zMU9wZW4iLCJwcm9ibGVtczFDbG9zZSIsInByb2JsZW1zMk9wZW4iLCJwcm9ibGVtczJDbG9zZSIsInByb2JsZW1zM09wZW4iLCJwcm9ibGVtczNDbG9zZSIsInByb2JsZW1zNE9wZW4iLCJwcm9ibGVtczRDbG9zZSIsInByb2JsZW1zNU9wZW4iLCJwcm9ibGVtczVDbG9zZSIsInByb2JsZW1zNk9wZW4iLCJwcm9ibGVtczZDbG9zZSIsInByb2JsZW1zNjFPcGVuIiwicHJvYmxlbXM2MUNsb3NlIiwicHJvYmxlbXM3T3BlbiIsInByb2JsZW1zN0Nsb3NlIiwicHJvYmxlbXM4T3BlbiIsInByb2JsZW1zOENsb3NlIiwicHJvYmxlbXM5T3BlbiIsInByb2JsZW1zOUNsb3NlIiwibmF2Q29uZmlnIiwicGFyYW1EaWMiLCJpbmRleCIsInVuZGVmaW5lZCIsInRhYkNsaWNrIiwicmVzZXRUaXRsZXNTdHlsZSIsImlkeCIsIm9iaiIsImN1ciIsIm9wZW5PckNsb3NlUHJvYmxlbSIsInZpc2libGUiLCJyZXNldFRpdGxlU2VsZWN0VGFiIiwidGFiS2V5IiwicXVlc3Rpb25MaXN0IiwiY3JlYXRlUXVlc3Rpb25MaXN0Iiwic2l4QVN0cmluZyIsIm5fc2hhcmtfZmluX2NvbW1vbl9hbnN3ZXJfc2l4X2FfZmlyc3RfbmV3Iiwibl9zaGFya19maW5fY29tbW9uX2Fuc3dlcl9zaXhfYV9zZWNvbmRfbmV3Iiwic2V2ZW5TdHJpbmciLCJuX3NoYXJrX2Zpbl9jb21tb25fYW5zd2VyX3NldmVuX2FfZmlyc3QiLCJuX3NoYXJrX2Zpbl9jb21tb25fYW5zd2VyX3NldmVuX2Ffc2Vjb25kIiwibl9zaGFya19maW5fY29tbW9uX2Fuc3dlcl9zZXZlbl9hX3RoaXJkIiwibl9zaGFya19maW5fY29tbW9uX2Fuc3dlcl9zZXZlbl9hX2ZvdXIiLCJuX3NoYXJrX2Zpbl9jb21tb25fYW5zd2VyX3NldmVuX3NlY29uZCIsIm5fc2hhcmtfZmluX2NvbW1vbl9hbnN3ZXJfc2V2ZW5fdGhpcmQiLCJjZWxsVHlwZSIsIm5fc2hhcmtfZmluX2NvbW1vbl9wcm9ibGVtX29uZSIsIm5fc2hhcmtfZmluX2NvbW1vbl9hbnN3ZXJfb25lIiwiYW5zd2VyVmlzYWJsZSIsInFhSWNvbiIsIm5fc2hhcmtfZmluX2NvbW1vbl9wcm9ibGVtX3R3byIsIm5fc2hhcmtfZmluX2NvbW1vbl9hbnN3ZXJfdHdvX25ldyIsIm5fc2hhcmtfZmluX2NvbW1vbl9wcm9ibGVtX3RocmVlIiwibl9zaGFya19maW5fY29tbW9uX2Fuc3dlcl90aHJlZSIsIm5fc2hhcmtfZmluX2NvbW1vbl9wcm9ibGVtX2ZvdXIiLCJuX3NoYXJrX2Zpbl9jb21tb25fYW5zd2VyX2ZvdXJfYyIsIm5fc2hhcmtfZmluX2NvbW1vbl9wcm9ibGVtX2ZpdmVfbmV3Iiwibl9zaGFya19maW5fY29tbW9uX2Fuc3dlcl9maXZlX25ld19jIiwibl9zaGFya19maW5fY29tbW9uX3Byb2JsZW1fc2l4Iiwibl9zaGFya19maW5fY29tbW9uX2Fuc3dlcl9zaXgiLCJuX3NoYXJrX2Zpbl9jb21tb25fcHJvYmxlbV9zaXhfYSIsIm5fc2hhcmtfZmluX2NvbW1vbl9wcm9ibGVtX3NldmVuIiwibl9zaGFya19maW5fY29tbW9uX3Byb2JsZW1fZWlnaHQiLCJuX3NoYXJrX2Zpbl9jb21tb25fYW5zd2VyX2VpZ2h0X25ld19jIiwibl9zaGFya19maW5fY29tbW9uX3Byb2JsZW1fbmluZSIsIm5fc2hhcmtfZmluX2NvbW1vbl9hbnN3ZXJfbmluZV9uZXciLCJmb3JFYWNoIiwiZWxlbWVudCIsImlzSW5pdCIsImlzRmlyc3QiLCJ0aW1lck9iamVjdCIsInJlcXVlc3RTaGFya0hvbWVEYXRhIiwic2hhcmtUYWJLZXkiLCJzaGFya0hvbWVEYXRhIiwib0RhdGEiLCJ0YWJJbmZvIiwidGFiVmlzYWJsZSIsIm11QXJyYXkiLCJoaWdobGlnaHQiLCJiYWNrZ3JvdW5kIiwidGV4dENvbG9yIiwidGFiMCIsInRhYjEiLCJzaGFya0luZm8iLCJjb250ZW50VmlzYWJsZSIsImVuZFRpbWUiLCJ0b3RhbExpbWl0IiwiZmluaXNoQW1vdW50IiwiZmluaXNoUHJvcG9ydGlvbiIsIlN0cmluZyIsInVzZWRQcm9wb3J0aW9uIiwic2VydmljZVRpbWVJbnRlcnZhbCIsInN1YnNjcmlwdGlvblRpdGxlIiwibl9zaGFya19maW5fZGVwb3NpdF9vcGVuIiwic3Vic2NyaXB0aW9uRGF0ZSIsImlzWmVybyIsInVwZGF0ZUNvdW50RG93biIsInByb2dyZXNzVmlzYWJsZSIsImNvdW50ZG93blZpc2FibGUiLCJzdWJzY3JpcHRpb25EYXRlVmlzYWJsZSIsIm5fc2hhcmtfZmluX2RlcG9zaXRfY2xvc2UiLCJuX3NoYXJrX2Zpbl9kZXBvc2l0X2Nsb3NlZCIsImRlcG9zaXRBbW91bnRUaXRsZSIsIm5fc2hhcmtfZmluX2RlcG9zaXRfYW1vdW50IiwiYXJyYXkiLCJwcm9qZWN0cyIsInRtcE9iaiIsImVhcm5pbmdzIiwidGVybVN0ciIsInByb2R1Y3RMaXN0IiwiZGF0ZSIsInRpbWVNYXAiLCJnZXRDb3VudERvd25NYXAiLCJjb3VudGRvd24iLCJkYXkiLCJob3VyIiwibWludXRlIiwic2Vjb25kIiwic2hvd0RheSIsImJlZ2luRGF0ZSIsIm5ld0RhdGUiLCJtaWxsaXNlY29uZHMiLCJpbnRlcnZhbCIsInRpbWVyIiwiY2xpY2tRQSIsIm9yZGVyIiwiZ29NeVByb3BlcnRpZXMiLCJnb0hpc3RvcnkiLCJnb0FsbEZBUXMiLCJnb0JhY2siLCJnb0ludHJvZHVjZSIsImdvRGVwb3NpdCIsIml0ZW0iLCJ0YWJDbGlja2VkIiwic2VsZWN0VGFiS2V5IiwiaGlzdG9yeV90aXRsZUNvbG9yX05vcm1hbCIsImhpc3RvcnlfdGl0bGVDb2xvcl9TZWxlY3RlZCIsImhpc3Rvcnlfb25Hb2luZ1BhZ2UiLCJoaXN0b3J5X2ZpbmlzaGVkUGFnZSIsImxpc3REYXRhIiwicmlnaHRUaXRsZSIsImxvYWRNb3JlU3RhdHVzIiwic2hvd0xpc3QiLCJwb3BsaXN0RGF0YSIsInByb2plY3RMaXN0Iiwib25Hb2luZ1BhZ2UiLCJmaW5pc2hlZFBhZ2UiLCJvbkdvaW5nRGF0YSIsImZpbmlzaGVkRGF0YSIsImJhY2tncm91bmRDb2xvciIsImFkU3RhdHVzQmFyQ29sb3IiLCJwYWdlVHlwZSIsInJlcXVlc3RTaGFya1ByZXZSZWNvcmRzRGF0YSIsImNsZWFyTW9kdWxlRGF0YSIsImN1cnJQYWdlIiwic2V0RW1wdHkiLCJzaGFya1ByZXZSZWNvcmRzRGF0YSIsImNoYW5nZURhdGFPYmplY3QiLCJhbGxhcnJheSIsInRlbXBEYXRhMCIsInJldCIsImRhdGFPYmplY3RzIiwidGVtcERhdGExIiwidG1wUHJvamVjdHNPYmoiLCJwcm9qZWN0c09iaiIsImZpbmlzaEFtb3VudFN0ciIsInNldHRsZUluY29tZUFtb3VudCIsInNldHRsZUluY29tZUFtb3VudFN0ciIsImFsbG93UmFpc2VEZXRhaWwiLCJvYmpUZXJtIiwic2hvd0RhdGUiLCJzaG93RGVzYyIsIm5fc2hhcmtfZmluX3JhaXNlZF9hbW91bnQiLCJzaG93TnVtYmVyIiwibl9zaGFya19maW5fc2V0dGxlbWVudF9pbnRlcmVzdCIsImlzU2hvd0Rlc2MiLCJ1cERvd24iLCJzaG93UmF0ZSIsInNob3dEZXRhaWwiLCJuX3NoYXJrX2Zpbl9ub3dfcHJpY2VfbmV3IiwiY3VycmVudFByaWNlIiwibl9zaGFya19maW5fc2V0dGxlbWVudF9wcmljZV8yX25ldyIsImZpbmlzaGVkVGl0bGVDb2xvciIsIm9uR29pbmdUaXRsZUNvbG9yIiwiZGF0YU9iamVjdCIsIm9uTG9hZE1vcmUiLCJwcm9qZWN0VGl0bGVDbGljayIsImN1cnJlbnRQYWdlIiwicHJvamVjdERhdGEiLCJuX3NoYXJrX2Zpbl9zZXR0bGVtZW50X2ludGVyZXN0X3RpdGxlIiwibWlkZGxlIiwibl9zaGFya19maW5fcHJpbmNpcGFsIiwicmlnaHQiLCJuX3NoYXJrX2Zpbl9pbnRlcmVzdCIsImlzU2hvd0luY29tZSIsImhpc3RvcnlQb3AiLCJjYW5jZWwiLCJwb3BEaXNtaXNzIiwic2VuZENvbW1vbkNvbmZpZyIsImNvbW1vbi5nZXRDb21tb25Db25maWciXSwibWFwcGluZ3MiOiJBQWlCQSxJQUFJQSxLQUFLLElBVVBDLEtBQUssR0FHTEMsU0FBUyxLQUdUQyxZQUFZLEtBT1pDLE1BQU0sR0FRTkMsS0FBSyxJQU9MQyxPQUFPLGFBQ1BDLFVBQVVELE9BQU8sWUFDakJFLGFBQWFELFVBQVUsa0JBQ3ZCRSxhQUFhRixVQUFVLGlCQUN2QkcsY0FBY0osT0FBTyxvQkFH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
