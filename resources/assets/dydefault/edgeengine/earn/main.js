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

function add(x, y) {
    return new Big(x).plus(y).toString();
}

function multiply(x, y) {
    return new Big(x).times(y).toString();
}

function divide(x, y) {
    return new Big(x).div(y).toString();
}

function format(value, precision) {
    Big.NE = -9;
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

const DEFAULT_STR = "0.00";

function moduleDefine(moduleName, defaultDataFunction, functions = {
    onCreate: onCreate$5,
    onDestroy: onDestroy$5,
    onResume: onResume$1,
    onPause: onPause$1,
    onStart: onStart$1,
    onStop: onStop
}) {
    console.log(`loadModule`, moduleName);
    $data[moduleName] = defaultDataFunction();
    $event[moduleName] = {
        onCreate: typeof functions.onCreate == "undefined" ? onCreate$5 : functions.onCreate,
        onDestroy: typeof functions.onDestroy == "undefined" ? onDestroy$5 : functions.onDestroy,
        onResume: typeof functions.onResume == "undefined" ? onResume$1 : functions.onResume,
        onPause: typeof functions.onPause == "undefined" ? onPause$1 : functions.onPause,
        onStart: typeof functions.onStart == "undefined" ? onStart$1 : functions.onStart,
        onStop: typeof functions.onStop == "undefined" ? onStop : functions.onStop
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

function onDestroy$5() {}

function onResume$1() {}

function onPause$1() {}

function onStart$1() {}

function onStop() {}

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
    oldVToken: "",
    bottomSafeAreaHeight: 0,
    countryId: ""
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
    commonData.bottomSafeAreaHeight = param.bottomSafeAreaHeight;
    commonData.countryId = param.countryId;
    $data.commonData = commonData;
}

function getPNGIconURLByCurrency(currency) {
    let baseUrl = commonData.h5Url ? commonData.h5Url : "";
    return `${baseUrl}/-/x/hb/p/api/contents/currency/icon_png/${currency.toLowerCase()}.png`;
}

async function sendRequest(path, params = {}, method = 0, hostType = 0, header = {}) {
    console.log(`request ${path}, params:${JSON.stringify(params)}`);
    if (hostType == 5 || hostType == 6) {
        header["Content-Type"] = "application/json";
    }
    header["HB-COUNTRY-ID"] = commonData.countryId;
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
        } else if (code == 200 || response.status == "ok") {
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

function containerBack(params = 0) {
    console.log("containerBack");
    $nativeAPI.containerBack(params);
}

async function openPageWithPath(urlPath) {
    console.log(`openH5WithPath:`, urlPath);
    if (urlPath && urlPath != null) {
        if (urlPath.indexOf("holigeit") == 0 || urlPath.indexOf("http") == 0) {
            openURL(urlPath);
        } else {
            openURL(`${commonData.h5Url}/${commonData.language}${urlPath}`);
        }
    }
}

async function getLegalCurrencySymbol() {
    const currencySymbol = await $nativeAPI.currencyCommon('{"type":9}');
    return currencySymbol;
}

async function convertLegalTender(symbol, amount, currencyScale) {
    if (!amount) {
        amount = "0";
    }
    var param = {
        type: 1,
        currency: symbol,
        amount: amount
    };
    if (currencyScale > 0) {
        param = {
            type: 111,
            currency: symbol,
            amount: amount,
            currencyScale: currencyScale
        };
    }
    const paramString = JSON.stringify(param);
    return await $nativeAPI.currencyCommon(paramString);
}

async function formatByMinPrecision(amount, precision) {
    if (!amount) {
        amount = "0.00";
    }
    if (!precision) {
        precision = 2;
    }
    var param = {
        type: 112,
        amount: amount,
        precision: precision
    };
    const paramString = JSON.stringify(param);
    return await $nativeAPI.currencyCommon(paramString);
}

function addCurrencySymbol(currencySymbol, source) {
    if (source === "--") {
        return source;
    } else if (source && source !== DEFAULT_STR) {
        if (source.startsWith("-")) {
            if (currencySymbol == "₮") {
                return `-${source.substring(1)} USDT`;
            }
            return `-${currencySymbol}${source.substring(1)}`;
        }
        if (currencySymbol == "₮") {
            return `${source} USDT`;
        }
        return `${currencySymbol}${source}`;
    } else {
        if (currencySymbol == "₮") {
            return `${DEFAULT_STR} USDT`;
        }
        return `${currencySymbol}${DEFAULT_STR}`;
    }
}

var structured_dualData = {
    qaData: [ {
        type: "QA",
        index: 0,
        answerVisable: "gone",
        Q: $i18n.n_strutured_Q_dual,
        A: $i18n.n_strutured_A_dual,
        A1: "",
        A2: "",
        A3: "",
        A4: "",
        A5: "",
        A1Show: "gone",
        A2Show: "gone",
        A3Show: "gone",
        A4Show: "gone",
        A5Show: "gone",
        qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
    }, {
        type: "QA",
        index: 1,
        answerVisable: "gone",
        Q: $i18n.n_double_coin_earn_issue_two,
        A: $i18n.n_double_coin_earn_answer_two_part_one,
        A1: $i18n.n_double_coin_earn_answer_two_part_two,
        A2: "",
        A3: "",
        A4: "",
        A5: "",
        A1Show: "visible",
        A2Show: "gone",
        A3Show: "gone",
        A4Show: "gone",
        A5Show: "gone",
        qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
    }, {
        type: "QA",
        index: 2,
        answerVisable: "gone",
        Q: $i18n.n_double_coin_earn_issue_three,
        A: $i18n.n_double_coin_earn_answer_three_part_one,
        A1: $i18n.n_double_coin_earn_answer_three_part_two,
        A2: $i18n.n_double_coin_earn_answer_three_part_three,
        A3: "",
        A4: "",
        A5: "",
        A1Show: "visible",
        A2Show: "visible",
        A3Show: "gone",
        A4Show: "gone",
        A5Show: "gone",
        qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
    }, {
        type: "QA",
        index: 3,
        answerVisable: "gone",
        Q: $i18n.n_double_coin_earn_issue_four_new,
        A: $i18n.n_double_coin_earn_answer_four,
        A1: "",
        A2: "",
        A3: "",
        A4: "",
        A5: "",
        A1Show: "gone",
        A2Show: "gone",
        A3Show: "gone",
        A4Show: "gone",
        A5Show: "gone",
        qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
    }, {
        type: "QA",
        index: 4,
        answerVisable: "gone",
        Q: $i18n.n_double_coin_earn_issue_five,
        A: $i18n.n_double_coin_earn_answer_five_part_one,
        A1: $i18n.n_double_coin_earn_answer_five_part_two_c,
        A2: "",
        A3: "",
        A4: "",
        A5: "",
        A1Show: "visible",
        A2Show: "gone",
        A3Show: "gone",
        A4Show: "gone",
        A5Show: "gone",
        qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
    } ],
    moreData: [ {
        type: "more",
        index: 0,
        name: $i18n.n_strutured_more_simple,
        desc: $i18n.n_strutured_more_simple_detail,
        icon: "@drawable/edge_engine_strutured_easy",
        jumpPath: "/financial/earn/h5/newDetail?activeTab=0"
    }, {
        type: "more",
        index: 1,
        name: $i18n.n_strutured_more_new,
        desc: $i18n.n_strutured_desc,
        icon: "@drawable/edge_engine_strutured_update",
        jumpPath: "/financial/earn/h5/newListing"
    }, {
        type: "more",
        index: 2,
        name: $i18n.n_strutured_more_onchain,
        desc: $i18n.n_strutured_more_onchain_detail,
        icon: "@drawable/edge_engine_strutured_onchain",
        jumpPath: "/financial/earn/h5/stackPro"
    }, {
        type: "div"
    } ],
    coinData: []
};

var structured_sharkfinData = {
    qaData: [ {
        type: "QA",
        index: 0,
        answerVisable: "gone",
        Q: $i18n.n_shark_fin_common_problem_one,
        A: $i18n.n_shark_fin_common_answer_one,
        A1: "",
        A2: "",
        A3: "",
        A4: "",
        A5: "",
        A1Show: "gone",
        A2Show: "gone",
        A3Show: "gone",
        A4Show: "gone",
        A5Show: "gone",
        qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
    }, {
        type: "QA",
        index: 1,
        answerVisable: "gone",
        Q: $i18n.n_shark_fin_common_problem_two,
        A: $i18n.n_shark_fin_common_answer_two_new,
        A1: "",
        A2: "",
        A3: "",
        A4: "",
        A5: "",
        A1Show: "gone",
        A2Show: "gone",
        A3Show: "gone",
        A4Show: "gone",
        A5Show: "gone",
        qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
    }, {
        type: "QA",
        index: 2,
        answerVisable: "gone",
        Q: $i18n.n_shark_fin_common_problem_three,
        A: $i18n.n_shark_fin_common_answer_three,
        A1: "",
        A2: "",
        A3: "",
        A4: "",
        A5: "",
        A1Show: "gone",
        A2Show: "gone",
        A3Show: "gone",
        A4Show: "gone",
        A5Show: "gone",
        qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
    }, {
        type: "QA",
        index: 3,
        answerVisable: "gone",
        Q: $i18n.n_shark_fin_common_problem_four,
        A: $i18n.n_shark_fin_common_answer_four_c,
        A1: "",
        A2: "",
        A3: "",
        A4: "",
        A5: "",
        A1Show: "gone",
        A2Show: "gone",
        A3Show: "gone",
        A4Show: "gone",
        A5Show: "gone",
        qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
    }, {
        type: "QA",
        index: 4,
        answerVisable: "gone",
        Q: $i18n.n_shark_fin_common_problem_five_new,
        A: $i18n.n_shark_fin_common_answer_five_new_c,
        A1: "",
        A2: "",
        A3: "",
        A4: "",
        A5: "",
        A1Show: "gone",
        A2Show: "gone",
        A3Show: "gone",
        A4Show: "gone",
        A5Show: "gone",
        qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
    }, {
        type: "QA",
        index: 5,
        answerVisable: "gone",
        Q: $i18n.n_shark_fin_common_problem_six,
        A: $i18n.n_shark_fin_common_answer_six,
        A1: "",
        A2: "",
        A3: "",
        A4: "",
        A5: "",
        A1Show: "gone",
        A2Show: "gone",
        A3Show: "gone",
        A4Show: "gone",
        A5Show: "gone",
        qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
    }, {
        type: "QA",
        index: 6,
        answerVisable: "gone",
        Q: $i18n.n_shark_fin_common_problem_six_a,
        A: $i18n.n_shark_fin_common_answer_six_a_first_new,
        A1: $i18n.n_shark_fin_common_answer_six_a_second_new,
        A2: "",
        A3: "",
        A4: "",
        A5: "",
        A1Show: "visible",
        A2Show: "gone",
        A3Show: "gone",
        A4Show: "gone",
        A5Show: "gone",
        qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
    }, {
        type: "QA",
        index: 7,
        answerVisable: "gone",
        Q: $i18n.n_shark_fin_common_problem_seven,
        A: $i18n.n_shark_fin_common_answer_seven_a_first,
        A1: $i18n.n_shark_fin_common_answer_seven_a_second,
        A2: $i18n.n_shark_fin_common_answer_seven_a_third,
        A3: $i18n.n_shark_fin_common_answer_seven_a_four,
        A4: $i18n.n_shark_fin_common_answer_seven_second,
        A5: $i18n.n_shark_fin_common_answer_seven_third,
        A1Show: "visible",
        A2Show: "visible",
        A3Show: "visible",
        A4Show: "visible",
        A5Show: "visible",
        qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
    }, {
        type: "QA",
        index: 8,
        answerVisable: "gone",
        Q: $i18n.n_shark_fin_common_problem_eight,
        A: $i18n.n_shark_fin_common_answer_eight_new_c,
        A1: "",
        A2: "",
        A3: "",
        A4: "",
        A5: "",
        A1Show: "gone",
        A2Show: "gone",
        A3Show: "gone",
        A4Show: "gone",
        A5Show: "gone",
        qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
    }, {
        type: "QA",
        index: 9,
        answerVisable: "gone",
        Q: $i18n.n_shark_fin_common_problem_nine,
        A: $i18n.n_shark_fin_common_answer_nine_new,
        A1: "",
        A2: "",
        A3: "",
        A4: "",
        A5: "",
        A1Show: "gone",
        A2Show: "gone",
        A3Show: "gone",
        A4Show: "gone",
        A5Show: "gone",
        qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
    }, {
        type: "QA",
        index: 10,
        answerVisable: "gone",
        Q: $i18n.n_shark_fin_autoSubscribe_Q_1,
        A: $i18n.n_shark_fin_autoSubscribe_A_1_1,
        A1: $i18n.n_shark_fin_autoSubscribe_A_1_2,
        A2: "",
        A3: "",
        A4: "",
        A5: "",
        A1Show: "visible",
        A2Show: "gone",
        A3Show: "gone",
        A4Show: "gone",
        A5Show: "gone",
        qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
    }, {
        type: "QA",
        index: 11,
        answerVisable: "gone",
        Q: $i18n.n_shark_fin_autoSubscribe_Q_2,
        A: $i18n.n_shark_fin_autoSubscribe_A_2_1,
        A1: $i18n.n_shark_fin_autoSubscribe_A_2_2,
        A2: $i18n.n_shark_fin_autoSubscribe_A_2_3,
        A3: "",
        A4: "",
        A5: "",
        A1Show: "visible",
        A2Show: "visible",
        A3Show: "gone",
        A4Show: "gone",
        A5Show: "gone",
        qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
    }, {
        type: "QA",
        index: 12,
        answerVisable: "gone",
        Q: $i18n.n_shark_fin_autoSubscribe_Q_3,
        A: $i18n.n_shark_fin_autoSubscribe_A_3_1,
        A1: $i18n.n_shark_fin_autoSubscribe_A_3_2,
        A2: "",
        A3: "",
        A4: "",
        A5: "",
        A1Show: "visible",
        A2Show: "gone",
        A3Show: "gone",
        A4Show: "gone",
        A5Show: "gone",
        qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
    } ],
    sharkfinData: []
};

var structured_onlyOneSection = {
    type: "OnlyOne",
    name: $i18n.n_strutured_onlyone_title,
    icon1: "@drawable/edge_engine_strutured_onlyone_1",
    title1: $i18n.n_strutured_onlyone_name_1,
    desc1: $i18n.n_strutured_onlyone_desc_1,
    icon2: "@drawable/edge_engine_strutured_onlyone_2",
    title2: $i18n.n_strutured_onlyone_name_2,
    desc2: $i18n.n_strutured_onlyone_desc_2,
    icon3: "@drawable/edge_engine_strutured_onlyone_3",
    title3: $i18n.n_strutured_onlyone_name_3,
    desc3: $i18n.n_strutured_onlyone_desc_3
};

var structured_problemSection = {
    type: "H1",
    name: $i18n.n_shark_fin_common_problem,
    showMore: "visible",
    tabIndex: 1
};

var structured_moreSection = {
    type: "H1",
    name: $i18n.n_strutured_others,
    showMore: "gone"
};

var tabKey = "";

var isClose = false;

function defaultData$4() {
    return {
        refresh: "0",
        currentIndex: 0,
        mainData: concatDualData(),
        dualTab: {
            textSize: 20,
            textColor: "@color/kColorPrimaryText"
        },
        sharkfinTab: {
            textSize: 16,
            textColor: "@color/kColorThreeLevelText"
        },
        selectedTab: "dual",
        descData: getDescData("dual"),
        descLineSpacing: "8",
        marginBottom: "0",
        bottomShow: "gone"
    };
}

function getNavConfigString() {
    return {
        titleKey: "n_strutured_products",
        left: {
            action: {
                type: "evalJS",
                parameter: "backClicked"
            },
            icon: "edge_engine_top_bar_back_normal"
        },
        backgroundColor: "kColorF1F7FF"
    };
}

const {moduleData: moduleData$4, moduleEvent: moduleEvent$4} = moduleDefine("structured", defaultData$4, {
    onCreate: onCreate$4,
    onDestroy: onDestroy$4,
    onResume: onResume,
    onPause: onPause
});

function onCreate$4(param) {
    console.log("structured onCreate");
    moduleData$4.statusBarConfig = {
        statusBarMode: "true",
        adStatusBarColor: "KBaseColorDeepestBackground",
        safeBottomTransparent: "true"
    };
    moduleData$4.navConfig = getNavConfigString();
    moduleData$4.descLineSpacing = commonData.OS == 1 ? "8" : "6";
    moduleData$4.marginBottom = commonData.bottomSafeAreaHeight > 0 ? "34" : "12";
    moduleData$4.borderColor = commonData.colorMode == 1 ? "4D1E1E1F" : "4DFFFFFF";
    moduleData$4.descData = getDescData(moduleData$4.selectedTab);
    moduleData$4.isFirst = true;
    moduleData$4.timerObject = null;
    let paramDic = JSON.parse(param);
    tabKey = paramDic.tabKey ? paramDic.tabKey : "";
    let selectedType = paramDic["tab"];
    isClose = Boolean(paramDic["isClose"]);
    console.log(selectedType);
    console.log(`isClose = ${isClose}`);
    if (selectedType !== "sharkfin") {
        selectedType = "dual";
    }
    moduleEvent$4.tabClicked(selectedType);
    analytics("app_earn_productPage_view", {
        page: "structuredProducts"
    });
}

function onDestroy$4() {
    tabKey = "";
}

async function onResume() {
    console.log("structured onResume");
    startTimer();
    if (!moduleData$4.isFirst) {
        if (moduleData$4.selectedTab == "dual") {
            requestCoinDatas();
        } else {
            requestSharkHomeData();
        }
    }
    moduleData$4.isFirst = false;
}

function onPause() {
    console.log("structured onPause");
    clearTimer$1();
}

function getDescData(selectedTab) {
    var title = $i18n.n_strutured_dual_desc;
    var icon = "@drawable/edge_engine_strutured_dual";
    var tabIndex = 1;
    if (selectedTab !== "dual") {
        title = $i18n.n_strutured_sharkfin_desc;
        icon = "@drawable/edge_engine_strutured_sharkfin";
        tabIndex = 2;
    }
    let highlight = ` ${$i18n.n_strutured_more_explain}`;
    var textColor = "#565656";
    var highlightColor = "#000000";
    var arrowColor = "#8A8A8E";
    if (commonData.colorMode == 1) {
        textColor = "#8C8C93";
        highlightColor = "#E6E6E6";
        arrowColor = "#4C4C4E";
    }
    const name = `<span style="color:${textColor}; font-size:12px;">${title}</span><span style="color:${highlightColor}; font-size:12px;">${highlight}</span><span style="color:${arrowColor}; font-size:12px;"> ❯</span>`;
    return {
        name: name,
        icon: icon,
        tabIndex: tabIndex
    };
}

function concatDualData() {
    var tempData = [];
    if (structured_dualData.coinData && structured_dualData.coinData.length > 0) {
        tempData = tempData.concat(structured_dualData.coinData);
    }
    var problemSection = structured_problemSection;
    problemSection.tabIndex = 1;
    tempData.push(structured_onlyOneSection);
    tempData.push(problemSection);
    tempData = tempData.concat(structured_dualData.qaData);
    tempData.push(structured_moreSection);
    tempData = tempData.concat(structured_dualData.moreData);
    return tempData;
}

function concatSharkfinData() {
    var tempData = [];
    var problemSection = structured_problemSection;
    problemSection.tabIndex = 2;
    tempData.push(problemSection);
    tempData = tempData.concat(structured_sharkfinData.qaData);
    tempData.push(structured_moreSection);
    tempData = tempData.concat(structured_dualData.moreData);
    return tempData;
}

function tabClicked(tabType) {
    moduleData$4.selectedTab = tabType;
    var tabName = "";
    if (tabType == "dual") {
        tabName = "dualInvestment";
        moduleData$4.bottomShow = "visible";
        moduleData$4.sharkfinVisibility = "gone";
        moduleData$4.dualTab.textSize = 20;
        moduleData$4.dualTab.textColor = "@color/kColorPrimaryText";
        moduleData$4.sharkfinTab.textSize = 16;
        moduleData$4.sharkfinTab.textColor = "@color/kColorThreeLevelText";
        moduleData$4.descData = getDescData(tabType);
        moduleData$4.mainData = concatDualData();
        requestCoinDatas();
    } else {
        tabName = "sharkFin";
        moduleData$4.bottomShow = "gone";
        moduleData$4.sharkfinVisibility = "visible";
        moduleData$4.sharkfinTab.textSize = 20;
        moduleData$4.sharkfinTab.textColor = "@color/kColorPrimaryText";
        moduleData$4.dualTab.textSize = 16;
        moduleData$4.dualTab.textColor = "@color/kColorThreeLevelText";
        moduleData$4.descData = getDescData(tabType);
        moduleData$4.mainData = concatSharkfinData();
        requestSharkHomeData();
    }
    analytics("app_earn_productPage_secondFloorTab_show", {
        page: "structuredProducts",
        tabName: tabName
    });
}

function clickItem(index) {
    var operationType = "";
    var curData = structured_dualData.coinData[parseInt(index)];
    if (curData.unfoldedVisible == "gone") {
        curData.unfoldedVisible = "visible";
        curData.icon_arrow = "@drawable/edge_engine_strutured_arrow_up";
        curData.yieldText = "";
        operationType = "unfold";
        analytics("app_earn_productCard_show", {
            page: "structuredProducts",
            tabName: "dualInvestment",
            token: curData.coinName,
            operate: "buyLow"
        });
        analytics("app_earn_productCard_show", {
            page: "structuredProducts",
            tabName: "dualInvestment",
            token: curData.coinName,
            operate: "sellHigh"
        });
    } else {
        curData.unfoldedVisible = "gone";
        curData.icon_arrow = "@drawable/edge_engine_strutured_arrow_down";
        curData.yieldText = curData.arrRange;
        operationType = "fold";
    }
    moduleData$4.mainData = concatDualData();
    analytics("app_earn_tokenCard_click", {
        page: "structuredProducts",
        tabName: "dualInvestment",
        token: curData.coinName,
        operationType: operationType
    });
}

function sharkfinTabClicked(selectTabKey) {
    if (tabKey != selectTabKey) {
        tabKey = selectTabKey;
    }
    startTimer();
    requestSharkHomeData();
}

function clickQA(QIndex) {
    var operationType = "";
    var tabName = "";
    var qalist = moduleData$4.selectedTab == "dual" ? structured_dualData.qaData : structured_sharkfinData.qaData;
    for (let index = 0; index < qalist.length; index++) {
        const element = qalist[index];
        if (QIndex == element.index) {
            if (element.answerVisable == "gone") {
                element.answerVisable = "visible";
                element.qaIcon = "@drawable/edge_engine_shark_home_qa_retract_icon";
                operationType = "unfold";
            } else {
                element.answerVisable = "gone";
                element.qaIcon = "@drawable/edge_engine_shark_home_qa_spread_icon";
                operationType = "fold";
            }
        }
    }
    if (moduleData$4.selectedTab == "dual") {
        moduleData$4.mainData = concatDualData();
        tabName = "dualInvestment";
    } else {
        moduleData$4.mainData = concatSharkfinData();
        tabName = "sharkFin";
    }
    analytics("app_earn_FAQs_unfoldAndFold_click", {
        page: "structuredProducts",
        tabName: tabName,
        operationType: operationType,
        order: `${QIndex + 1}`
    });
}

async function requestCoinDatas() {
    showLoading(true);
    const data = await sendRequest("otc/opt/option/v2/pre/dcw-tab-nav");
    showLoading(false);
    var dataList = [];
    if (data && data.navigations.length) {
        const list = data.navigations;
        for (var i = 0; i < list.length; i++) {
            const curData = list[i];
            var object = {};
            object.type = "dualCell";
            object.index = i;
            object.unfoldedVisible = "gone";
            object.coinName = curData.currency.toUpperCase();
            object.icon_arrow = "@drawable/edge_engine_strutured_arrow_down";
            object.mainIcon = getPNGIconURLByCurrency(curData.currency);
            object.arrRange = curData["arr-range"] != null ? curData["arr-range"] : "";
            object.yieldText = object.arrRange;
            for (var j = 0; j < curData.items.length; j++) {
                const item = curData.items[j];
                if (item["product-type-id"] == "5") {
                    object[`descText${j + 1}`] = $i18n.$intercept.n_double_coin_earn_low_buy(object.coinName);
                    object[`bigIcon${j + 1}`] = getPNGIconURLByCurrency(item["quote-currency"]);
                    object[`smallIcon${j + 1}`] = getPNGIconURLByCurrency(item["base-currency"]);
                    object["support-quotes-buy"] = item["support-quotes"];
                } else if (item["product-type-id"] == "6") {
                    object[`descText${j + 1}`] = $i18n.$intercept.n_double_coin_earn_high_sell(object.coinName);
                    object[`smallIcon${j + 1}`] = getPNGIconURLByCurrency(item["quote-currency"]);
                    object[`bigIcon${j + 1}`] = getPNGIconURLByCurrency(item["base-currency"]);
                    object["support-quotes-sell"] = item["support-quotes"];
                }
                var idxStr = j + 1 + "";
                object["yieldText" + idxStr] = item["arr-range"] != null ? item["arr-range"] : "";
                object["productTypeId" + idxStr] = `${item["product-type-id"]}`;
                object["currency"] = item["base-currency"];
            }
            dataList.push(object);
            analytics("app_earn_tokenCard_show", {
                page: "structuredProducts",
                tabName: "dualInvestment",
                token: object.coinName,
                operationType: "fold"
            });
        }
        structured_dualData.coinData = dataList;
        moduleData$4.mainData = concatDualData();
    }
    analytics("app_earn_productPage_moreRelated_show", {
        page: "structuredProducts",
        tabName: "dualInvestment"
    });
    analytics("app_earn_FAQs_show", {
        page: "structuredProducts",
        tabName: "dualInvestment"
    });
}

async function requestSharkHomeData() {
    showLoading(true);
    const data = await sendRequest("v4/saving/mining/shark", {
        tabKey: tabKey
    });
    showLoading(false);
    sharkTabKey(data);
    sharkHomeData(data);
    analytics("app_earn_productPage_moreRelated_show", {
        page: "structuredProducts",
        tabName: "sharkFin"
    });
    analytics("app_earn_FAQs_show", {
        page: "structuredProducts",
        tabName: "sharkFin"
    });
}

function sharkTabKey(oData) {
    if (!oData || oData == null || !oData.tabInfo || oData.tabInfo == null || oData.tabInfo.length < 2) {
        moduleData$4.tabVisable = "gone";
        return;
    }
    moduleData$4.tabVisable = "visible";
    var muArray = [];
    for (let index = 0; index < oData.tabInfo.length; index++) {
        var element = oData.tabInfo[index];
        if (element.highlight) {
            tabKey = element.tabKey;
            element.background = "@color/KBaseColorContentBackground";
            element.textColor = "@color/kColorPrimaryText";
        } else {
            element.background = "@color/KBaseColorInputBackground";
            element.textColor = "@color/kColorThreeLevelText";
        }
        muArray.push(element);
    }
    moduleData$4.tab0 = muArray[0];
    moduleData$4.tab1 = muArray[1];
    moduleData$4.mainData = concatSharkfinData();
}

function sharkHomeData(oData) {
    if (!oData || oData == null || !oData.sharkInfo || oData.sharkInfo == null || oData.sharkInfo.length == 0) {
        clearTimer$1();
        moduleData$4.contentVisable = "gone";
        return;
    }
    const data = oData.sharkInfo[0];
    console.log("home sharkHomeData" + JSON.stringify(data));
    moduleData$4.contentVisable = "visible";
    moduleData$4.quoteCurrency = data.quoteCurrency;
    moduleData$4.viewStatus = data.viewStatus;
    moduleData$4.startTime = data.startTime;
    moduleData$4.endTime = data.endTime;
    moduleData$4.subscribeStartTime = data.subscribeStartTime;
    moduleData$4.subscribeEndTime = data.subscribeEndTime;
    moduleData$4.totalLimit = `/ ${getPriceString(data.totalLimit, 0)}`;
    moduleData$4.finishAmount = getPriceString(data.finishAmount, 0);
    var finishProportion = parseFloat(data.finishAmount / data.totalLimit);
    if (finishProportion > 1) {
        finishProportion = 1;
    }
    if (finishProportion > 0 && finishProportion < .01) {
        finishProportion = .01;
    }
    moduleData$4.width = finishProportion * 303;
    moduleData$4.sTime = data.sTime;
    moduleData$4.serviceTimeInterval = data.sTime - (new Date).getTime();
    moduleData$4.subscriptionTitle = "";
    if (data.viewStatus == 0) {
        moduleData$4.subscriptionTitle = $i18n.n_shark_fin_deposit_open;
        moduleData$4.subscriptionDate = `${new Date(data.subscribeStartTime).Format("yyyy/MM/dd hh:mm")}`;
        var isZero = updateCountDown(data.subscribeStartTime);
        moduleData$4.progressVisable = "gone";
        moduleData$4.countdownVisable = isZero ? "gone" : "visible";
        moduleData$4.subscriptionDateVisable = "visible";
    } else if (data.viewStatus == 1 && data.finishAmount < data.totalLimit) {
        moduleData$4.subscriptionTitle = $i18n.n_shark_fin_deposit_close;
        moduleData$4.subscriptionDate = `${new Date(data.subscribeEndTime).Format("yyyy/MM/dd hh:mm")}`;
        var isZero = updateCountDown(data.subscribeEndTime);
        moduleData$4.progressVisable = "visible";
        moduleData$4.countdownVisable = isZero ? "gone" : "visible";
        moduleData$4.subscriptionDateVisable = "visible";
    } else {
        moduleData$4.subscriptionTitle = $i18n.n_shark_fin_deposit_closed;
        moduleData$4.progressVisable = "visible";
        moduleData$4.countdownVisable = "gone";
        moduleData$4.subscriptionDateVisable = "gone";
        clearTimer$1();
    }
    moduleData$4.depositAmountTitle = $i18n.$intercept.n_shark_fin_deposit_amount(data.quoteCurrency);
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
        analytics("app_earn_productCard_show", {
            page: "structuredProducts",
            tabName: "sharkFin",
            token: obj.currency,
            projectId: obj.id,
            term: obj.termStr
        });
    }
    console.log("array" + JSON.stringify(array));
    moduleData$4.productList = array;
    moduleData$4.mainData = concatSharkfinData();
}

function updateCountDown(date) {
    var timeMap = getCountDownMap(date);
    if (timeMap.isZero) {
        moduleData$4.countdownVisable = "gone";
    } else {
        moduleData$4.countdown = {
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
    const newDate = (new Date).getTime() + moduleData$4.serviceTimeInterval;
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
    if (moduleData$4.timerObject == null) {
        moduleData$4.timerObject = setInterval(timer, 1e3);
    }
}

function clearTimer$1() {
    if (moduleData$4.timerObject != null) {
        console.log("clearTimer ");
        clearInterval(moduleData$4.timerObject);
        moduleData$4.timerObject = null;
    }
}

async function timer() {
    console.log("timer ");
    var isZero = false;
    if (moduleData$4.viewStatus == 0) {
        isZero = updateCountDown(moduleData$4.subscribeStartTime);
    } else if (moduleData$4.viewStatus == 1) {
        isZero = updateCountDown(moduleData$4.subscribeEndTime);
    }
    if (isZero) {
        data = await sendRequest("v4/saving/mining/shark", {
            tabKey: tabKey
        });
        sharkTabKey(data);
        sharkHomeData(data);
    }
}

function refresh() {
    if (moduleData$4.selectedTab == "dual") {
        requestCoinDatas();
    } else {
        requestSharkHomeData();
    }
    moduleData$4.refresh = "2";
}

function toExplain() {
    openPageWithPath("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/edgeengine/container?scene=earn&rootName=introduce&navConfig=nav&index=2");
    analytics("app_earn_productPage_explanationEntrance_click", {
        explanationClassify: "structuredProducts"
    });
}

function toMoreExplain(tabIndex) {
    openPageWithPath(`holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/edgeengine/container?scene=earn&rootName=introduce&navConfig=nav&index=2&tabIndex=${tabIndex}`);
    analytics("app_earn_productPage_explanationEntrance_click", {
        explanationClassify: tabIndex == 1 ? "dualInvestment" : "sharkFin"
    });
}

function toIntroduce(tabIndex) {
    openPageWithPath(`holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/edgeengine/container?scene=earn&rootName=introduce&navConfig=nav&index=2&headerIndex=1&tabIndex=${tabIndex}`);
    analytics("app_earn_FAQs_more_click", {
        page: "structuredProducts",
        tabName: tabIndex == 1 ? "dualInvestment" : "sharkFin"
    });
}

function toDetail(index, type) {
    try {
        var curData = moduleData$4.mainData[parseInt(index)];
        console.log(`toDetail, ${JSON.stringify(curData.rawObject())}`);
        const currency = curData["currency"].toLowerCase();
        var arr = [];
        if (parseInt(type) == 5) {
            arr = curData["support-quotes-buy"];
        } else {
            arr = curData["support-quotes-sell"];
        }
        var supportQuotes = "";
        for (var i = 0; i < arr.length; i++) {
            supportQuotes = supportQuotes + arr[i];
            if (i != arr.length - 1) {
                supportQuotes = supportQuotes + "-";
            }
        }
        openPageWithPath(`holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/edgeengine/container?scene=doublecoin&rootName=coindetail&navConfig=native&productTypeId=${type}&currency=${currency}&supportQuotes=${supportQuotes}`);
        analytics("app_earn_productCard_click", {
            page: "structuredProducts",
            tabName: "dualInvestment",
            token: curData.coinName,
            operate: type == 5 ? "buyLow" : "sellHigh"
        });
    } catch (e) {
        console.log(`toDetail, error = ${e}`);
    }
}

function goDeposit(idx) {
    var item = moduleData$4.productList[idx];
    openPageWithPath(`holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/edgeengine/container?scene=sharkfin&rootName=deposit&navConfig=&projectId=${item.id}`);
    analytics("app_earn_productCard_click", {
        page: "structuredProducts",
        tabName: "sharkFin",
        token: item.currency,
        projectId: item.id,
        term: item.termStr
    });
}

function goHistory() {
    openPageWithPath("holigeit://open/v1?login=0&url=ihuobiglobal://m.hbg.com/edgeengine/container?scene=sharkfin&rootName=history&navConfig=native&pageType=onGoing");
}

moduleEvent$4.openPageWithPath = function(path, index) {
    console.log(`path = ${path}  isClose = ${isClose}`);
    var clickProductPage = "";
    if (index == 1) {
        clickProductPage = "newProduct";
    } else if (index == 2) {
        clickProductPage = "onChainEarn";
    } else {
        clickProductPage = "simpleEarn";
    }
    openPageWithPath(path);
    const tabName = moduleData$4.selectedTab == "dual" ? "dualInvestment" : "sharkFin";
    analytics("app_earn_productPage_moreRelated_click", {
        page: "structuredProducts",
        tabName: tabName,
        clickProductPage: clickProductPage
    });
    if (isClose) {
        containerBack(-1);
    }
};

moduleEvent$4.bottomOrderClicked = function() {
    openPageWithPath("/otc-option/win/h5/order");
};

moduleEvent$4.bottomCustomClicked = function() {
    openPageWithPath("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/edgeengine/container?scene=doublecoin&rootName=custom&navConfig=native");
};

moduleEvent$4.backClicked = function() {
    containerBack();
    analytics("app_earn_productPage_returnButton_click");
};

moduleEvent$4.clickQA = clickQA;

moduleEvent$4.tabClicked = tabClicked;

moduleEvent$4.sharkfinTabClicked = sharkfinTabClicked;

moduleEvent$4.refresh = refresh;

moduleEvent$4.clickItem = clickItem;

moduleEvent$4.toIntroduce = toIntroduce;

moduleEvent$4.toDetail = toDetail;

moduleEvent$4.toExplain = toExplain;

moduleEvent$4.toMoreExplain = toMoreExplain;

moduleEvent$4.goHistory = goHistory;

moduleEvent$4.goDeposit = goDeposit;

var needAddShow = false;

var productExplanationJson = "";

const intro_headerData = [ {
    index: 0,
    type: "header",
    text: $i18n.n_shark_fin_product_rule,
    textColor: "@color/kColorPrimaryText",
    backColor: "@color/KBaseColorInputBackground",
    borderColor: "@color/KBaseColorInputBackground"
}, {
    index: 1,
    type: "header",
    text: $i18n.n_shark_fin_common_problem,
    textColor: "@color/kColorSecondaryText",
    backColor: "@color/KBaseColorContentBackground",
    borderColor: "@color/KBaseColorPrimarySeparator"
} ];

const intro_simple_info = [ {
    type: "H2",
    text: $i18n.n_strutured_simple_H_1
}, {
    type: "text",
    text: $i18n.n_strutured_simple_T_1
}, {
    type: "H2",
    text: $i18n.n_strutured_simple_H_2
}, {
    type: "text",
    text: $i18n.n_strutured_simple_T_2_1
}, {
    type: "text",
    text: $i18n.n_strutured_simple_T_2_2
}, {
    type: "text",
    text: $i18n.n_strutured_simple_T_2_3
}, {
    type: "H2",
    text: $i18n.n_strutured_simple_H_3
}, {
    type: "text",
    text: $i18n.n_strutured_simple_T_3
}, {
    type: "text",
    text: $i18n.n_strutured_intro_A_3_2
}, {
    type: "text",
    text: $i18n.n_strutured_intro_A_3_3
} ];

const intro_simple_flexi = [ [ {
    type: "H2",
    text: $i18n.n_strutured_flexi_earn
}, {
    type: "text",
    text: $i18n.n_strutured_flexi_earn_1
}, {
    type: "text",
    text: $i18n.n_strutured_flexi_earn_2
}, {
    type: "text",
    text: $i18n.n_strutured_flexi_earn_3
}, {
    type: "text",
    text: $i18n.n_strutured_flexi_earn_4
}, {
    type: "H2",
    text: $i18n.n_strutured_flexi_withdraw
}, {
    type: "text",
    text: $i18n.n_strutured_flexi_withdraw_1
}, {
    type: "text",
    text: $i18n.n_strutured_flexi_withdraw_2
}, {
    type: "text",
    text: $i18n.n_strutured_flexi_withdraw_3
}, {
    type: "text",
    text: $i18n.n_strutured_flexi_withdraw_4
} ], [ {
    type: "QA",
    index: 0,
    answerVisable: "gone",
    Q: $i18n.n_strutured_flexi_Q_1,
    A: $i18n.n_strutured_flexi_A_1,
    qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
}, {
    type: "QA",
    index: 1,
    answerVisable: "gone",
    Q: $i18n.n_strutured_flexi_Q_2,
    A: $i18n.n_strutured_flexi_A_2,
    qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
}, {
    type: "QA",
    index: 2,
    answerVisable: "gone",
    Q: $i18n.n_strutured_onchain_Q_4,
    A: $i18n.n_strutured_flexi_withdraw_1 + "\n\n" + $i18n.n_strutured_flexi_withdraw_2 + "\n\n" + $i18n.n_strutured_flexi_withdraw_3 + "\n\n" + $i18n.n_strutured_flexi_withdraw_4,
    qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
}, {
    type: "QA",
    index: 3,
    answerVisable: "gone",
    Q: $i18n.n_strutured_flexi_Q_4,
    A: $i18n.n_strutured_flexi_A_4,
    qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
} ] ];

[ [ {
    type: "H2",
    text: $i18n.n_strutured_flexi_earn
}, {
    type: "text",
    text: $i18n.n_strutured_flexi_max_earn_1
}, {
    type: "text",
    text: $i18n.n_strutured_flexi_max_earn_2
}, {
    type: "text",
    text: $i18n.n_strutured_flexi_max_earn_3
}, {
    type: "text",
    text: $i18n.n_strutured_flexi_max_earn_4
}, {
    type: "H2",
    text: $i18n.n_strutured_flexi_withdraw
}, {
    type: "text",
    text: $i18n.n_strutured_flexi_max_withdraw_1
}, {
    type: "text",
    text: $i18n.n_strutured_flexi_max_withdraw_2
} ], [ {
    type: "QA",
    index: 0,
    answerVisable: "gone",
    Q: $i18n.n_strutured_flexi_max_Q_1,
    A: $i18n.n_strutured_flexi_max_A_1,
    qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
}, {
    type: "QA",
    index: 1,
    answerVisable: "gone",
    Q: $i18n.n_strutured_flexi_max_Q_2,
    A: $i18n.n_strutured_flexi_max_A_2,
    qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
}, {
    type: "QA",
    index: 2,
    answerVisable: "gone",
    Q: $i18n.n_strutured_flexi_max_Q_3,
    A: $i18n.n_strutured_flexi_max_A_3,
    qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
}, {
    type: "QA",
    index: 3,
    answerVisable: "gone",
    Q: $i18n.n_strutured_flexi_max_Q_4,
    A: $i18n.n_strutured_flexi_max_A_4_1 + "\n\n" + $i18n.n_strutured_flexi_max_A_4_2 + "\n\n" + $i18n.n_strutured_flexi_max_A_4_3 + "\n\n" + $i18n.n_strutured_flexi_max_A_4_4 + "\n\n" + $i18n.n_strutured_flexi_max_A_4_5,
    qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
} ] ];

const intro_simple_fixed = [ [ {
    type: "H2",
    text: $i18n.n_strutured_flexi_earn
}, {
    type: "text",
    text: $i18n.n_strutured_fixed_earn_1
}, {
    type: "text",
    text: $i18n.n_strutured_fixed_earn_2
}, {
    type: "text",
    text: $i18n.n_strutured_fixed_earn_3
}, {
    type: "H2",
    text: $i18n.n_strutured_flexi_withdraw
}, {
    type: "text",
    text: $i18n.n_strutured_fixed_withdraw
} ], [ {
    type: "QA",
    index: 0,
    answerVisable: "gone",
    Q: $i18n.n_strutured_fixed_Q_0,
    A: $i18n.n_strutured_fixed_A_1,
    qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
}, {
    type: "QA",
    index: 1,
    answerVisable: "gone",
    Q: $i18n.n_strutured_fixed_Q_1,
    A: $i18n.n_strutured_fixed_A_2,
    qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
} ] ];

const intro_simple = {
    titleIndex: 0,
    titleData: [ {
        title: $i18n.n_strutured_products_sum,
        titleSize: "14",
        titleColor: "@color/kColorPrimaryText",
        tag: "0",
        selectedline: "visible"
    }, {
        title: $i18n.n_asset_earn_current,
        titleSize: "14",
        titleColor: "@color/kColorThreeLevelText",
        tag: "1"
    }, {
        title: $i18n.n_mining_asset_fixed,
        titleSize: "14",
        titleColor: "@color/kColorThreeLevelText",
        tag: "2"
    } ],
    sliderData: [ {
        listType: "sliderCell",
        headerVisib: "gone",
        headerData: [],
        cellData: intro_simple_info
    }, {
        listType: "sliderCell",
        headerVisib: "visible",
        headerData: intro_headerData,
        cellData: intro_simple_flexi[0]
    }, {
        listType: "sliderCell",
        headerVisib: "visible",
        headerData: intro_headerData,
        cellData: intro_simple_fixed[0]
    } ],
    cellDatalist: [ [ intro_simple_info ], intro_simple_flexi, intro_simple_fixed ]
};

intro_new_info = [ {
    type: "H2",
    text: $i18n.n_strutured_new_H_1
}, {
    type: "text",
    text: $i18n.n_strutured_new_T_1
}, {
    type: "H2",
    text: $i18n.n_strutured_new_H_2
}, {
    type: "text",
    text: $i18n.n_strutured_new_T_2_1
}, {
    type: "text",
    text: $i18n.n_strutured_new_T_2_2
}, {
    type: "text",
    text: $i18n.n_strutured_new_T_2_3
}, {
    type: "H2",
    text: $i18n.n_strutured_new_H_3
}, {
    type: "text",
    text: $i18n.n_strutured_simple_T_3
}, {
    type: "text",
    text: $i18n.n_strutured_intro_A_3_2
}, {
    type: "text",
    text: $i18n.n_strutured_intro_A_3_3
} ];

intro_new_problem = [ {
    type: "QA",
    index: 0,
    answerVisable: "gone",
    Q: $i18n.n_strutured_new_Q_1,
    A: $i18n.n_strutured_new_A_1,
    qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
}, {
    type: "QA",
    index: 1,
    answerVisable: "gone",
    Q: $i18n.n_strutured_new_Q_2,
    A: $i18n.n_strutured_new_A_2,
    qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
}, {
    type: "QA",
    index: 2,
    answerVisable: "gone",
    Q: $i18n.n_strutured_new_Q_3,
    A: $i18n.n_strutured_new_A_3,
    qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
} ];

const intro_new = {
    titleIndex: 0,
    titleData: [ {
        title: $i18n.n_strutured_products_sum,
        titleSize: "14",
        titleColor: "@color/kColorPrimaryText",
        tag: "0",
        selectedline: "visible"
    }, {
        title: $i18n.n_shark_fin_common_problem,
        titleSize: "14",
        titleColor: "@color/kColorThreeLevelText",
        tag: "1"
    } ],
    sliderData: [ {
        listType: "sliderCell",
        headerVisib: "gone",
        headerData: [],
        cellData: intro_new_info
    }, {
        listType: "sliderCell",
        headerVisib: "gone",
        headerData: [],
        cellData: intro_new_problem
    } ],
    cellDatalist: [ [ intro_new_info ], [ intro_new_problem ] ]
};

intro_onchain_info = [ {
    type: "H2",
    text: $i18n.n_strutured_onchain_H_1
}, {
    type: "text",
    text: $i18n.n_strutured_onchain_T_1
}, {
    type: "H2",
    text: $i18n.n_strutured_onchain_H_2
}, {
    type: "text",
    text: $i18n.n_strutured_onchain_T_2
}, {
    type: "H2",
    text: $i18n.n_strutured_onchain_H_3
}, {
    type: "text",
    text: $i18n.n_strutured_onchain_T_3_1
}, {
    type: "text",
    text: $i18n.n_strutured_onchain_T_3_2
}, {
    type: "text",
    text: $i18n.n_strutured_onchain_T_3_3
}, {
    type: "H2",
    text: $i18n.n_strutured_onchain_H_4
}, {
    type: "text",
    text: $i18n.n_strutured_onchain_T_4
}, {
    type: "text",
    text: $i18n.n_strutured_intro_A_3_3
}, {
    type: "text",
    text: $i18n.n_strutured_intro_A_3_2
} ];

intro_onchain_rule = [ {
    type: "H2",
    text: $i18n.n_strutured_onchain_earn
}, {
    type: "text",
    text: $i18n.n_strutured_onchain_earn_1
}, {
    type: "text",
    text: $i18n.n_strutured_onchain_earn_2
}, {
    type: "text",
    text: $i18n.n_strutured_onchain_earn_3
}, {
    type: "H2",
    text: $i18n.n_strutured_flexi_withdraw
}, {
    type: "text",
    text: $i18n.n_strutured_onchain_withdraw_1
} ];

intro_onchain_problem = [ {
    type: "QA",
    index: 0,
    answerVisable: "gone",
    Q: $i18n.n_strutured_onchain_Q_1,
    A: $i18n.n_strutured_onchain_A_1,
    qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
}, {
    type: "QA",
    index: 1,
    answerVisable: "gone",
    Q: $i18n.n_strutured_onchain_Q_2,
    A: $i18n.n_strutured_onchain_A_2,
    qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
}, {
    type: "QA",
    index: 2,
    answerVisable: "gone",
    Q: $i18n.n_strutured_onchain_Q_3,
    A: $i18n.n_strutured_onchain_A_3_1 + "\n\n" + $i18n.n_strutured_onchain_A_3_2,
    qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
}, {
    type: "QA",
    index: 3,
    answerVisable: "gone",
    Q: $i18n.n_strutured_onchain_Q_4,
    A: $i18n.n_strutured_onchain_A_4,
    qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
}, {
    type: "QA",
    index: 4,
    answerVisable: "gone",
    Q: $i18n.n_strutured_onchain_Q_5,
    A: $i18n.n_strutured_onchain_A_5,
    qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
} ];

const intro_onchain = {
    titleIndex: 0,
    titleData: [ {
        title: $i18n.n_strutured_products_sum,
        titleSize: "14",
        titleColor: "@color/kColorPrimaryText",
        tag: "0",
        selectedline: "visible"
    }, {
        title: $i18n.n_shark_fin_product_rule,
        titleSize: "14",
        titleColor: "@color/kColorThreeLevelText",
        tag: "1"
    }, {
        title: $i18n.n_shark_fin_common_problem,
        titleSize: "14",
        titleColor: "@color/kColorThreeLevelText",
        tag: "2"
    } ],
    sliderData: [ {
        listType: "sliderCell",
        headerVisib: "gone",
        headerData: [],
        cellData: intro_onchain_info
    }, {
        listType: "sliderCell",
        headerVisib: "gone",
        headerData: [],
        cellData: intro_onchain_rule
    }, {
        listType: "sliderCell",
        headerVisib: "gone",
        headerData: [],
        cellData: intro_onchain_problem
    } ],
    cellDatalist: [ [ intro_onchain_info ], [ intro_onchain_rule ], [ intro_onchain_problem ] ]
};

const intro_structured_info = [ {
    type: "H2",
    text: $i18n.n_strutured_intro_Q_1
}, {
    type: "text",
    text: $i18n.n_strutured_intro_A_1
}, {
    type: "H2",
    text: $i18n.n_strutured_intro_Q_2
}, {
    type: "text",
    text: $i18n.n_strutured_intro_A_2_1
}, {
    type: "text",
    text: $i18n.n_strutured_intro_A_2_2
}, {
    type: "text",
    text: $i18n.n_strutured_intro_A_2_3
}, {
    type: "H2",
    text: $i18n.n_strutured_intro_Q_3
}, {
    type: "text",
    text: $i18n.n_strutured_intro_A_3_1
}, {
    type: "text",
    text: $i18n.n_strutured_intro_A_3_2
}, {
    type: "text",
    text: $i18n.n_strutured_intro_A_3_3
} ];

const intro_dual = [ [ {
    type: "H2",
    text: $i18n.n_double_coin_earn_issue_one
}, {
    type: "text",
    text: $i18n.n_strutured_A_dual_n
}, {
    type: "H2",
    text: $i18n.n_double_coin_earnings_confirm_how
}, {
    type: "text",
    text: $i18n.n_double_coin_earnings_confirm
}, {
    type: "H2",
    text: $i18n.n_double_coin_htx_advantage_what_n
}, {
    type: "H3",
    text: $i18n.n_double_coin_htx_advantage_one_n
}, {
    type: "text",
    text: $i18n.n_double_coin_htx_advantage_one_info_n
}, {
    type: "H3",
    text: $i18n.n_double_coin_htx_advantage_two
}, {
    type: "text",
    text: $i18n.n_double_coin_htx_advantage_info
}, {
    type: "H3",
    text: $i18n.n_double_coin_htx_advantage_three
}, {
    type: "text",
    text: $i18n.n_double_coin_htx_advantage_three_info
}, {
    type: "H2",
    text: $i18n.n_double_coin_term_definition
}, {
    type: "text",
    text: $i18n.n_double_coin_term_definition_one
}, {
    type: "text",
    text: $i18n.n_double_coin_term_definition_two
}, {
    type: "text",
    text: $i18n.n_double_coin_term_definition_three
}, {
    type: "text",
    text: $i18n.n_double_coin_term_definition_six
}, {
    type: "text",
    text: $i18n.n_double_coin_term_definition_seven
}, {
    type: "text",
    text: $i18n.n_double_coin_term_definition_eight_latest
} ], [ {
    type: "QA",
    index: 0,
    answerVisable: "gone",
    Q: $i18n.n_double_coin_earn_issue_one,
    A: $i18n.n_strutured_A_dual_n,
    qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
}, {
    type: "QA",
    index: 1,
    answerVisable: "gone",
    Q: $i18n.n_double_coin_earn_issue_two,
    A: $i18n.n_double_coin_earn_answer_two_part_one + "\n\n" + $i18n.n_double_coin_earn_answer_two_part_two,
    qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
}, {
    type: "QA",
    index: 2,
    answerVisable: "gone",
    Q: $i18n.n_double_coin_earn_issue_three,
    A: $i18n.n_double_coin_earn_answer_three_part_one + "\n\n" + $i18n.n_double_coin_earn_answer_three_part_two + "\n\n" + $i18n.n_double_coin_earn_answer_three_part_three,
    qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
}, {
    type: "QA",
    index: 3,
    answerVisable: "gone",
    Q: $i18n.n_double_coin_earn_issue_four_new,
    A: $i18n.n_double_coin_earn_answer_four,
    qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
}, {
    type: "QA",
    index: 4,
    answerVisable: "gone",
    Q: $i18n.n_double_coin_earn_issue_five,
    A: $i18n.n_double_coin_earn_answer_five_part_one + "\n\n" + $i18n.n_double_coin_earn_answer_five_part_two_c,
    qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
} ], [ {
    type: "H2",
    text: $i18n.n_double_coin_product_operation_how
}, {
    type: "text",
    text: $i18n.n_double_coin_product_operation_cate
}, {
    type: "text",
    text: $i18n.n_double_coin_product_operation_eg
}, {
    type: "H2",
    text: $i18n.n_double_coin_product_operation_eg_sell
}, {
    type: "text",
    text: $i18n.n_double_coin_product_operation_eg_sell_info
}, {
    type: "H3",
    text: $i18n.n_double_coin_product_operation_eg_sell_one
}, {
    type: "text_l",
    text: $i18n.n_double_coin_product_operation_eg_sell_one_greater,
    bottomHeight: 4
}, {
    type: "text_l",
    text: $i18n.n_double_coin_product_operation_eg_sell_one_less,
    bottomHeight: 12
}, {
    type: "H3",
    text: $i18n.n_double_coin_product_operation_eg_sell_two
}, {
    type: "text_l",
    text: $i18n.n_double_coin_product_operation_eg_sell_one_less,
    bottomHeight: 4
}, {
    type: "text_l",
    text: $i18n.n_double_coin_product_operation_eg_sell_two_two,
    bottomHeight: 4
}, {
    type: "text_l",
    text: $i18n.n_double_coin_product_operation_eg_sell_two_three,
    bottomHeight: 12
}, {
    type: "text",
    text: $i18n.n_double_coin_product_operation_eg_sell_all
}, {
    type: "H2",
    text: $i18n.n_double_coin_product_operation_ensample
}, {
    type: "text",
    text: $i18n.n_double_coin_ensample_sell_info
}, {
    type: "H3",
    text: $i18n.n_double_coin_ensample_sell_one
}, {
    type: "text",
    text: $i18n.n_double_coin_ensample_sell_one_info
}, {
    type: "H3",
    text: $i18n.n_double_coin_ensample_sell_two
}, {
    type: "text",
    text: $i18n.n_double_coin_ensample_sell_two_info
}, {
    type: "H3",
    text: $i18n.n_double_coin_ensample_sell_three
}, {
    type: "text",
    text: $i18n.n_double_coin_ensample_sell_three_info
}, {
    type: "H2",
    text: $i18n.n_double_coin_product_operation_eg_buy
}, {
    type: "text",
    text: $i18n.n_double_coin_product_operation_eg_buy_info
}, {
    type: "H3",
    text: $i18n.n_double_coin_product_operation_eg_sell_one
}, {
    type: "text_l",
    text: $i18n.$intercept.n_double_coin_product_operation_eg_buy_one_less("≤"),
    bottomHeight: 4
}, {
    type: "text_l",
    text: $i18n.n_double_coin_product_operation_eg_buy_one_greater,
    bottomHeight: 12
}, {
    type: "H3",
    text: $i18n.n_double_coin_product_operation_eg_sell_two
}, {
    type: "text_l",
    text: $i18n.n_double_coin_product_operation_eg_buy_one_greater,
    bottomHeight: 4
}, {
    type: "text_l",
    text: $i18n.n_double_coin_product_operation_eg_buy_two_two,
    bottomHeight: 4
}, {
    type: "text_l",
    text: $i18n.n_double_coin_product_operation_eg_buy_two_three,
    bottomHeight: 12
}, {
    type: "text",
    text: $i18n.n_double_coin_product_operation_eg_buy_all
}, {
    type: "H2",
    text: $i18n.n_double_coin_product_operation_ensample
}, {
    type: "text",
    text: $i18n.n_double_coin_ensample_buy_info
}, {
    type: "H3",
    text: $i18n.n_double_coin_ensample_buy_one
}, {
    type: "text",
    text: $i18n.n_double_coin_ensample_buy_one_info
}, {
    type: "H3",
    text: $i18n.n_double_coin_ensample_buy_two
}, {
    type: "text",
    text: $i18n.n_double_coin_ensample_buy_two_info
}, {
    type: "H3",
    text: $i18n.n_double_coin_ensample_buy_three
}, {
    type: "text",
    text: $i18n.n_double_coin_ensample_buy_three_info
} ] ];

const intro_sharkfin = [ [ {
    type: "H2",
    text: $i18n.n_shark_fin_theory_question
}, {
    type: "text",
    text: $i18n.n_shark_fin_theory_answer_new
}, {
    type: "text",
    text: $i18n.n_shark_fin_theory_disclaimer
}, {
    type: "H2",
    text: $i18n.n_shark_fin_up
}, {
    type: "APY_Est",
    src: "@drawable/edge_engine_sharkfin_introduce_up"
}, {
    type: "H3",
    text: $i18n.n_shark_fin_up_issue_one_first + "\n" + $i18n.n_shark_fin_up_issue_one_second + "\n" + $i18n.n_shark_fin_up_issue_one_third
}, {
    type: "H3",
    text: $i18n.n_shark_fin_up_issue_two_first + "\n" + $i18n.n_shark_fin_up_issue_two_second + "\n" + $i18n.n_shark_fin_up_issue_two_third + "\n" + $i18n.n_shark_fin_up_issue_two_fourth
}, {
    type: "H3",
    text: $i18n.n_shark_fin_up_issue_three_first + "\n" + $i18n.n_shark_fin_up_issue_three_second + "\n" + $i18n.n_shark_fin_up_issue_three_third
}, {
    type: "H2",
    text: $i18n.n_shark_fin_down
}, {
    type: "APY_Est",
    src: "@drawable/edge_engine_sharkfin_introduce_down"
}, {
    type: "H3",
    text: $i18n.n_shark_fin_down_issue_one_first + "\n" + $i18n.n_shark_fin_down_issue_one_second + "\n" + $i18n.n_shark_fin_down_issue_one_third
}, {
    type: "H3",
    text: $i18n.n_shark_fin_down_issue_two_first + "\n" + $i18n.n_shark_fin_down_issue_two_second + "\n" + $i18n.n_shark_fin_down_issue_two_third + "\n" + $i18n.n_shark_fin_down_issue_two_fourth
}, {
    type: "H3",
    text: $i18n.n_shark_fin_down_issue_three_first + "\n" + $i18n.n_shark_fin_down_issue_three_second + "\n" + $i18n.n_shark_fin_down_issue_three_third
}, {
    type: "text",
    text: $i18n.n_shark_fin_issue_note_1
} ], [ {
    type: "QA",
    index: 0,
    answerVisable: "gone",
    Q: $i18n.n_shark_fin_common_problem_one,
    A: $i18n.n_shark_fin_common_answer_one,
    qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
}, {
    type: "QA",
    index: 1,
    answerVisable: "gone",
    Q: $i18n.n_shark_fin_common_problem_two,
    A: $i18n.n_shark_fin_common_answer_two_new,
    qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
}, {
    type: "QA",
    index: 2,
    answerVisable: "gone",
    Q: $i18n.n_shark_fin_common_problem_three,
    A: $i18n.n_shark_fin_common_answer_three,
    qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
}, {
    type: "QA",
    index: 3,
    answerVisable: "gone",
    Q: $i18n.n_shark_fin_common_problem_four,
    A: $i18n.n_shark_fin_common_answer_four_c,
    qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
}, {
    type: "QA",
    index: 4,
    answerVisable: "gone",
    Q: $i18n.n_shark_fin_common_problem_five_new,
    A: $i18n.n_shark_fin_common_answer_five_new_c,
    qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
}, {
    type: "QA",
    index: 5,
    answerVisable: "gone",
    Q: $i18n.n_shark_fin_common_problem_six,
    A: $i18n.n_shark_fin_common_answer_six,
    qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
}, {
    type: "QA",
    index: 6,
    answerVisable: "gone",
    Q: $i18n.n_shark_fin_common_problem_six_a,
    A: $i18n.n_shark_fin_common_answer_six_a_first_new + "\n\n" + $i18n.n_shark_fin_common_answer_six_a_second_new,
    qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
}, {
    type: "QA",
    index: 7,
    answerVisable: "gone",
    Q: $i18n.n_shark_fin_common_problem_seven,
    A: $i18n.n_shark_fin_common_answer_seven_a_first + " \n \n" + $i18n.n_shark_fin_common_answer_seven_a_second + " \n \n" + $i18n.n_shark_fin_common_answer_seven_a_third + " \n \n" + $i18n.n_shark_fin_common_answer_seven_a_four + " \n \n" + $i18n.n_shark_fin_common_answer_seven_second + " \n \n" + $i18n.n_shark_fin_common_answer_seven_third,
    qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
}, {
    type: "QA",
    index: 8,
    answerVisable: "gone",
    Q: $i18n.n_shark_fin_common_problem_eight,
    A: $i18n.n_shark_fin_common_answer_eight_new_c,
    qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
}, {
    type: "QA",
    index: 9,
    answerVisable: "gone",
    Q: $i18n.n_shark_fin_common_problem_nine,
    A: $i18n.n_shark_fin_common_answer_nine_new,
    qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
}, {
    type: "QA",
    index: 10,
    answerVisable: "gone",
    Q: $i18n.n_shark_fin_autoSubscribe_Q_1,
    A: $i18n.n_shark_fin_autoSubscribe_A_1_1 + " \n\n" + $i18n.n_shark_fin_autoSubscribe_A_1_2,
    qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
}, {
    type: "QA",
    index: 11,
    answerVisable: "gone",
    Q: $i18n.n_shark_fin_autoSubscribe_Q_2,
    A: $i18n.n_shark_fin_autoSubscribe_A_2_1 + " \n\n" + $i18n.n_shark_fin_autoSubscribe_A_2_2 + " \n\n" + $i18n.n_shark_fin_autoSubscribe_A_2_3,
    qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
}, {
    type: "QA",
    index: 12,
    answerVisable: "gone",
    Q: $i18n.n_shark_fin_autoSubscribe_Q_3,
    A: $i18n.n_shark_fin_autoSubscribe_A_3_1 + " \n\n" + $i18n.n_shark_fin_autoSubscribe_A_3_2,
    qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon"
} ] ];

const intro_structured = {
    titleIndex: 0,
    titleData: [ {
        title: $i18n.n_strutured_products_sum,
        titleSize: "14",
        titleColor: "@color/kColorPrimaryText",
        tag: "0",
        selectedline: "visible"
    }, {
        title: $i18n.n_strutured_dual,
        titleSize: "14",
        titleColor: "@color/kColorThreeLevelText",
        tag: "1"
    }, {
        title: $i18n.n_shark_fin,
        titleSize: "14",
        titleColor: "@color/kColorThreeLevelText",
        tag: "2"
    } ],
    sliderData: [ {
        listType: "sliderCell",
        headerVisib: "gone",
        headerData: [],
        cellData: intro_structured_info
    }, {
        listType: "sliderCell",
        headerVisib: "visible",
        headerData: [ {
            index: 0,
            type: "header",
            text: $i18n.n_shark_fin_product_rule,
            textColor: "@color/kColorPrimaryText",
            backColor: "@color/KBaseColorInputBackground",
            borderColor: "@color/KBaseColorInputBackground"
        }, {
            index: 1,
            type: "header",
            text: $i18n.n_shark_fin_common_problem,
            textColor: "@color/kColorSecondaryText",
            backColor: "@color/KBaseColorContentBackground",
            borderColor: "@color/KBaseColorPrimarySeparator"
        }, {
            index: 2,
            type: "header",
            text: $i18n.n_double_coin_payment_regulation,
            textColor: "@color/kColorSecondaryText",
            backColor: "@color/KBaseColorContentBackground",
            borderColor: "@color/KBaseColorPrimarySeparator"
        } ],
        cellData: intro_dual[0]
    }, {
        listType: "sliderCell",
        headerVisib: "visible",
        headerData: intro_headerData,
        cellData: intro_sharkfin[0]
    } ],
    cellDatalist: [ [ intro_structured_info ], intro_dual, intro_sharkfin ]
};

const intro_navList = [ intro_simple, intro_new, intro_structured, intro_onchain ];

const intro_analytics = [ {
    productClassify: "simpleEarn",
    tabName: [ "productOverview", "flexible", "flexiMax", "fixed" ]
}, {
    productClassify: "newProduct",
    tabName: [ "productOverview", "FAQ" ]
}, {
    productClassify: "structuredProduct",
    tabName: [ "productOverview", "dualInvestment", "sharkFin" ]
}, {
    productClassify: "onChainEarn",
    tabName: [ "productOverview", "productRegulation", "FAQ" ]
} ];

function defaultData$3() {
    return {
        navIndex: 0,
        currentIndex: 0,
        navTitle: $i18n.n_strutured_more_simple,
        navData: [ {
            type: "normal",
            index: 0,
            selected: "visible",
            name: $i18n.n_strutured_more_simple,
            desc: $i18n.n_strutured_more_simple_detail,
            icon: "@drawable/edge_engine_introduce_easy"
        }, {
            type: "normal",
            index: 1,
            selected: "gone",
            name: $i18n.n_strutured_more_new,
            desc: $i18n.n_strutured_more_new_detail,
            icon: "@drawable/edge_engine_introduce_update"
        }, {
            type: "normal",
            index: 2,
            selected: "gone",
            name: $i18n.n_strutured_products,
            desc: $i18n.n_strutured_desc,
            icon: "@drawable/edge_engine_introduce_products"
        }, {
            type: "normal",
            index: 3,
            selected: "gone",
            name: $i18n.n_strutured_more_onchain,
            desc: $i18n.n_strutured_more_onchain_detail,
            icon: "@drawable/edge_engine_introduce_onchain"
        } ],
        titleData: intro_simple.titleData,
        sliderData: intro_simple.sliderData,
        navContainer: "gone",
        popShow: "false",
        navArrow: "@drawable/edge_engine_strutured_nav_arrow"
    };
}

const {moduleData: moduleData$3, moduleEvent: moduleEvent$3} = moduleDefine("introduce", defaultData$3, {
    onCreate: onCreate$3,
    onDestroy: onDestroy$3
});

function onCreate$3(param) {
    moduleData$3.statusBarConfig = {
        statusBarMode: "true",
        adStatusBarColor: "KBaseColorContentBackground",
        safeBottomTransparent: "true"
    };
    console.log("introduce on create");
    console.log(param);
    let paramDic = JSON.parse(param);
    needAddShow = false;
    let index = parseInt(paramDic["index"]);
    console.log(index);
    console.log(parseInt(index));
    if (index == undefined || isNaN(index)) {
        index = 0;
    }
    moduleEvent$3.navClicked(index, false);
    let tabIndex = parseInt(paramDic["tabIndex"]);
    console.log(tabIndex);
    console.log(parseInt(tabIndex));
    if (tabIndex == undefined || isNaN(tabIndex)) {
        tabIndex = 0;
    }
    moduleData$3.currentIndex = tabIndex;
    moduleEvent$3.resetTitleSelectTab(tabIndex);
    let headerIndex = parseInt(paramDic["headerIndex"]);
    console.log(headerIndex);
    console.log(parseInt(headerIndex));
    if (headerIndex == undefined || isNaN(headerIndex)) {
        headerIndex = 0;
    }
    moduleEvent$3.headerClicked(headerIndex);
    popGuideShow();
    productExplanationShow();
    console.log("productExplanationShow:onCreate");
}

function onDestroy$3() {
    moduleData$3.popShow = "false";
}

async function popGuideShow() {
    var guideShow = await $nativeAPI.storage({
        action: "read",
        name: "earn",
        key: "guide_introduce_show"
    });
    if (guideShow == null || guideShow == "") {
        moduleData$3.popShow = "true";
        $nativeAPI.storage({
            action: "save",
            name: "earn",
            key: "guide_introduce_show",
            data: "1"
        });
    }
}

moduleEvent$3.hideIntroPop = function() {
    moduleData$3.popShow = "false";
};

function productExplanationShow() {
    needAddShow = true;
    const navModel = intro_analytics[moduleData$3.navIndex];
    const tabName = navModel.tabName[moduleData$3.currentIndex];
    const properties = {
        productClassify: navModel.productClassify,
        tabName: tabName
    };
    const propertiesJson = JSON.stringify(properties);
    if (propertiesJson !== productExplanationJson) {
        analytics("app_earn_productExplanation_show", properties);
    }
    productExplanationJson = propertiesJson;
}

moduleEvent$3.backClicked = function() {
    containerBack();
};

moduleEvent$3.selectedNavClicked = function() {
    if (moduleData$3.navContainer == "gone") {
        moduleData$3.navArrow = "@drawable/edge_engine_strutured_nav_arrow_up";
        moduleData$3.navContainer = "visible";
    } else {
        moduleData$3.navArrow = "@drawable/edge_engine_strutured_nav_arrow";
        moduleData$3.navContainer = "gone";
    }
};

moduleEvent$3.navClicked = function(navIndex, clicked) {
    for (let index = 0; index < moduleData$3.navData.length; index++) {
        const element = moduleData$3.navData[index];
        if (navIndex == element.index) {
            element.selected = "visible";
            moduleData$3.navTitle = element.name;
        } else {
            element.selected = "gone";
        }
    }
    if (moduleData$3.navIndex != navIndex) {
        intro_navList[moduleData$3.navIndex].titleData = moduleData$3.titleData;
        intro_navList[moduleData$3.navIndex].sliderData = moduleData$3.sliderData;
        intro_navList[moduleData$3.navIndex].titleIndex = moduleData$3.currentIndex;
        moduleData$3.navIndex = navIndex;
        moduleData$3.titleData = intro_navList[navIndex].titleData;
        moduleData$3.sliderData = intro_navList[navIndex].sliderData;
        moduleData$3.currentIndex = intro_navList[navIndex].titleIndex;
        if (clicked) {
            productExplanationShow();
            console.log("productExplanationShow:navClicked");
        }
    }
    moduleData$3.navContainer = "gone";
    moduleData$3.navArrow = "@drawable/edge_engine_strutured_nav_arrow";
};

moduleEvent$3.tabClick = function(idx) {
    needAddShow = true;
    moduleData$3.currentIndex = `${idx}`;
};

moduleEvent$3.resetTitleSelectTab = function(idx) {
    for (let i = 0; i < moduleData$3.titleData.length; i++) {
        var obj = moduleData$3.titleData[i];
        obj.titleColor = "@color/kColorThreeLevelText";
        obj.selectedline = "gone";
    }
    var cur = moduleData$3.titleData[idx];
    cur.titleColor = "@color/kColorPrimaryText";
    cur.selectedline = "visible";
    if (needAddShow) {
        productExplanationShow();
        console.log("productExplanationShow:resetTitleSelectTab");
    }
};

moduleEvent$3.headerClicked = function headerClicked(headerIndex) {
    var headerData = moduleData$3.sliderData[moduleData$3.currentIndex].headerData;
    for (let index = 0; index < headerData.length; index++) {
        const element = headerData[index];
        if (index == headerIndex) {
            element.textColor = "@color/kColorPrimaryText";
            element.backColor = "@color/KBaseColorInputBackground";
            element.borderColor = "@color/KBaseColorInputBackground";
        } else {
            element.textColor = "@color/kColorSecondaryText";
            element.backColor = "@color/KBaseColorContentBackground";
            element.borderColor = "@color/KBaseColorPrimarySeparator";
        }
    }
    var headerCelllist = intro_navList[moduleData$3.navIndex].cellDatalist[moduleData$3.currentIndex];
    moduleData$3.sliderData[moduleData$3.currentIndex].cellData = headerCelllist[headerIndex];
    intro_navList[moduleData$3.navIndex].sliderData = moduleData$3.sliderData;
};

moduleEvent$3.clickQA = function(QIndex) {
    var operationType = "";
    var qalist = moduleData$3.sliderData[moduleData$3.currentIndex].cellData;
    for (let index = 0; index < qalist.length; index++) {
        const element = qalist[index];
        if (QIndex == element.index) {
            if (element.answerVisable == "gone") {
                element.answerVisable = "visible";
                element.qaIcon = "@drawable/edge_engine_shark_home_qa_retract_icon";
                operationType = "unfold";
            } else {
                element.answerVisable = "gone";
                element.qaIcon = "@drawable/edge_engine_shark_home_qa_spread_icon";
                operationType = "fold";
            }
        }
    }
    intro_navList[moduleData$3.navIndex].sliderData = moduleData$3.sliderData;
    var model = intro_navList[moduleData$3.navIndex].cellDatalist[moduleData$3.currentIndex];
    if (model && model.length > 1) {
        model[1] = qalist;
    }
    const navModel = intro_analytics[moduleData$3.navIndex];
    var classify = navModel.tabName[moduleData$3.currentIndex];
    if (classify == "FAQ") {
        classify = navModel.productClassify;
    }
    analytics("app_earn_productExplanation_FAQs_click", {
        classify: classify,
        operationType: operationType,
        order: `${QIndex + 1}`
    });
};

function defaultData$2() {
    return {
        loadingLottieVis: "visible",
        loadingLottieStatus: "play",
        funcList: [],
        totalIncome: "--",
        yesterdayIncome: "--",
        totalIncomeRich: "",
        bannerList: [],
        showIndicator: "false",
        recommend1IconUrl: "",
        recommend1Currency: "--",
        recommend1TagName: "",
        recommend1TagBg: "--",
        recommend1TagTextColor: "--",
        recommend1Apy: "--",
        recommend1Proj: "--",
        recommend2IconUrl: "",
        recommend2Currency: "--",
        recommend2TagName: "",
        recommend2TagBg: "--",
        recommend2TagTextColor: "--",
        recommend2Apy: "--",
        recommend2Proj: "--",
        nextItemName: "--",
        nextTitle: "--",
        recommendList: [],
        qaList: [],
        mainData: [],
        refreshStatus: 0,
        pop1Show: "false",
        pop2Show: "false",
        pop3Show: "false",
        pop4Show: "false",
        newLineSpacing: "0",
        title: "",
        vipIcon: "@drawable/edge_engine_earn_vip_icon_other",
        upgradeBgColor: "#D9F7E4",
        scrollToPos: 0
    };
}

var originMainData = {};

var intercal = null;

const mm = 60;

const hh = 3600;

const dd = 86400;

var sharkFinCount = 1;

var parameter = {};

var guideShow = "";

var recommendList = [];

const {moduleData: moduleData$2, moduleEvent: moduleEvent$2} = moduleDefine("home", defaultData$2, {
    onCreate: onCreate$2,
    onDestroy: onDestroy$2
});

function onCreate$2(jsonParameters) {
    console.log("home onCreate");
    moduleData$2.statusBarConfig = {
        statusBarMode: "false",
        safeBottomTransparent: "true"
    };
    moduleData$2.newLineSpacing = commonData.OS == 1 ? "2" : "0";
    moduleData$2.totalIncomeRich = handleTotalIncomeRich();
    parameter = JSON.parse(jsonParameters);
    initUI$1();
    getGuideStatus();
    requesEarnHomeData(true);
    analytics("app_earnPage_view");
}

function onDestroy$2() {
    clearTimer();
}

function initUI$1() {
    let tempFunc = [];
    for (let index = 0; index < 4; index++) {
        let element = {};
        let width = 375 / 4;
        element.index = index;
        element.type = "1";
        element.width = parseInt(width);
        if (index == 0) {
            element.title = $i18n.n_strutured_more_simple;
            element.jumpUrl = "/financial/earn/h5/newDetail?activeTab=0";
            element.icon = "@drawable/edge_engine_earn_home_func_1";
        } else if (index == 1) {
            element.title = $i18n.n_strutured_more_new;
            element.jumpUrl = "/financial/earn/h5/newListing";
            element.icon = "@drawable/edge_engine_earn_home_func_2";
        } else if (index == 2) {
            element.title = $i18n.n_strutured_products;
            element.jumpUrl = "holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/edgeengine/container?scene=earn&rootName=structured&navConfig=native&isClose=true";
            element.icon = "@drawable/edge_engine_earn_home_func_3";
        } else if (index == 3) {
            element.title = $i18n.n_strutured_more_onchain;
            element.jumpUrl = "/financial/earn/h5/stackPro";
            element.icon = "@drawable/edge_engine_earn_home_func_4";
        }
        tempFunc.push(element);
    }
    console.log(`funcList -----\x3e  ${JSON.stringify(tempFunc)}`);
    moduleData$2.funcList = tempFunc;
    if (commonData.language.toLowerCase() == "zh-cn" || commonData.language.toLowerCase() == "zh-hk") {
        moduleData$2.vipIcon = "@drawable/edge_engine_earn_vip_icon";
    }
    moduleData$2.upgradeBgColor = commonData.colorMode == 0 ? "#D9F7E4" : "#1D342E";
}

async function getGuideStatus() {
    guideShow = await $nativeAPI.storage({
        action: "read",
        name: "earn",
        key: "guide_show"
    });
    if (guideShow == "1") {
        moduleData$2.edgeEnginePageId = "64";
    }
}

async function requesEarnHomeData(isFirst = false) {
    const startTime = Date.now();
    try {
        var currencyName = await $nativeAPI.currencyCommon('{"type":3}');
        console.log(`currencyName -----\x3e  ${currencyName}`);
        var param = {
            c: currencyName
        };
        const data = await sendRequest("v4/saving/mining/home/main", param);
        originMainData = data;
        console.log(`requesEarnHomeData ${JSON.stringify(data)}  currencyName : ${currencyName}`);
        if (data != null) {
            analytics("app_earnPage_loadState", {
                pageLoadState: `success`
            });
            moduleData$2.title = data.title;
            if (data.income != null) {
                moduleData$2.totalIncome = `${data.income.totalKey} ${data.income.total}`;
                moduleData$2.yesterdayIncome = `${data.income.yesterdayKey} ${data.income.yesterday}`;
                moduleData$2.totalIncomeRich = handleTotalIncomeRich();
                console.log(`requesEarnHomeData  昨日收益`);
            }
            if (data.banner && data.banner.length > 0) {
                let tempBanner = data.banner;
                tempBanner.forEach(((element, index) => {
                    element.index = index;
                    if (element.areaType == 1) {
                        let project = element.project;
                        if (project.projType == 4) {
                            element.type = "2";
                            let div = divide(project.raising, project.raiseGoal);
                            if (div >= 1) {
                                project.firstProgress = 1;
                                project.secondProgress = .001;
                            } else {
                                if (div < .1) {
                                    div = .1;
                                }
                                project.firstProgress = parseFloat(div);
                                project.secondProgress = 1 - parseFloat(div);
                            }
                            element.project.raiseGoal = `/${element.project.raiseGoal}`;
                            startSharkFinCountDown();
                        } else {
                            element.type = "3";
                        }
                        project.iconUrl = getPNGIconURLByCurrency(project.currency);
                    } else if (element.areaType == 2) {
                        element.type = "4";
                        if (commonData.colorMode == 0) {
                            element.banner.bannerPic = element.banner.imageUrl;
                        } else {
                            element.banner.bannerPic = element.banner.nightImageUrl;
                        }
                    } else {
                        if (element.project.originApy == null || element.project.originApy == "") {
                            element.project.originApyVis = "gone";
                        } else {
                            element.project.originApyVis = "visible";
                        }
                        element.type = "1";
                    }
                }));
                moduleData$2.showIndicator = tempBanner.length > 1 ? "true" : "false";
                moduleData$2.bannerList = tempBanner;
                moduleEvent$2.bannerIndexChange(0);
                console.log(`requesEarnHomeData  banner`);
            }
            if (data.recommend && data.recommend.length > 1) {
                let recommend1 = data.recommend[0];
                moduleData$2.recommend1IconUrl = getPNGIconURLByCurrency(recommend1.currency);
                moduleData$2.recommend1Currency = recommend1.currency.toUpperCase();
                moduleData$2.recommend1Apy = recommend1.apy;
                moduleData$2.recommend1Proj = recommend1.proj;
                if (recommend1.tag != 0 && recommend1.tag != null) {
                    if (recommend1.tag == 8 || recommend1.tag == 9) {
                        moduleData$2.recommend1IconVis = "visible";
                        moduleData$2.recommend1TagVis = "gone";
                        moduleData$2.recommend1IconSrc = getTagIconByType$1(recommend1.tag);
                    } else {
                        moduleData$2.recommend1IconVis = "gone";
                        moduleData$2.recommend1TagVis = "visible";
                        moduleData$2.recommend1TagName = recommend1.tagName;
                        moduleData$2.recommend1TagBg = getTagBgByType$1(recommend1.tag);
                        moduleData$2.recommend1TagTextColor = getTagTextColorByType$1(recommend1.tag);
                    }
                }
                let recommend2 = data.recommend[1];
                moduleData$2.recommend2IconUrl = getPNGIconURLByCurrency(recommend2.currency);
                moduleData$2.recommend2Currency = recommend2.currency.toUpperCase();
                moduleData$2.recommend2Apy = recommend2.apy;
                moduleData$2.recommend2Proj = recommend2.proj;
                if (recommend2.tag != 0 && recommend2.tag != null) {
                    if (recommend2.tag == 8 || recommend2.tag == 9) {
                        moduleData$2.recommend2IconVis = "visible";
                        moduleData$2.recommend2TagVis = "gone";
                        moduleData$2.recommend2IconSrc = getTagIconByType$1(recommend2.tag);
                    } else {
                        moduleData$2.recommend2IconVis = "gone";
                        moduleData$2.recommend2TagVis = "visible";
                        moduleData$2.recommend2TagName = recommend2.tagName;
                        moduleData$2.recommend2TagBg = getTagBgByType$1(recommend2.tag);
                        moduleData$2.recommend2TagTextColor = getTagTextColorByType$1(recommend2.tag);
                    }
                }
            }
            if (data.next != null) {
                moduleData$2.nextItemName = data.next.itemName;
                moduleData$2.nextTitle = data.next.title;
                console.log(`requesEarnHomeData  推荐位`);
            }
            if (data.items != null) {
                let tempItems = data.items;
                let scrollToPosTemp = -1;
                tempItems.forEach(((element, index) => {
                    element.index = index;
                    element.type = "1";
                    element.listMainTagVis = "gone";
                    element.iconUrl = getPNGIconURLByCurrency(element.currency);
                    if (element.hold == null || element.hold == "") {
                        element.hold = "";
                        element.holdVis = "gone";
                        element.parentPadding = "18";
                    } else {
                        element.holdVis = "visible";
                        element.parentPadding = "14";
                    }
                    if (element.apy == null) {
                        element.apy = "";
                    }
                    let expand = false;
                    if (isFirst && hasCurrency()) {
                        expand = parameter.currency.toLowerCase() == element.currency.toLowerCase();
                    } else {
                        expand = index == 0;
                    }
                    console.log(`xiaoyi expand = ${expand}  index = ${index}  parameter.currency = ${parameter.currency}  element.currency = ${element.currency}`);
                    if (element.list != null && element.list.length == 1) {
                        element.childVis = "gone";
                        element.expandStatusRes = "@drawable/edge_engine_icon_earn_home_jump";
                        element.apyVis = "visible";
                        if (expand) {
                            scrollToPosTemp = index;
                        }
                    } else {
                        if (expand) {
                            scrollToPosTemp = index;
                            element.apyVis = "gone";
                            element.childVis = "visible";
                            element.expandStatusRes = "@drawable/edge_engine_strutured_arrow_up";
                        } else {
                            element.apyVis = "visible";
                            element.childVis = "gone";
                            element.expandStatusRes = "@drawable/edge_engine_strutured_arrow_down";
                        }
                    }
                    if (element.tag == 7 && element.tagApy != null && element.tagApy != "" && element.childVis == "gone") {
                        element.couponVis = "visible";
                        element.couponValue = element.tagApy;
                    } else {
                        element.couponVis = "gone";
                    }
                    if (element.tag == 8 || element.tag == 9) {
                        element.iconSrc = getTagIconByType$1(element.tag);
                        if (element.childVis == "gone") {
                            element.iconVis = "visible";
                        } else {
                            element.iconVis = "gone";
                        }
                    } else if (element.tag == 11) {
                        if (element.childVis != "visible") {
                            element.listMainTagVis = "visible";
                        }
                        element.tagBg = getTagBgByType$1(element.tag);
                        element.tagTextColor = getTagTextColorByType$1(element.tag);
                    }
                    if (element.list != null) {
                        let tempChild = element.list;
                        tempChild.forEach(((childElement, index) => {
                            childElement.type = "1";
                            childElement.index = index;
                            childElement.couponVis = "gone";
                            childElement.tagVis = "gone";
                            childElement.vipIconVis = "gone";
                            childElement.earnVipVis = "gone";
                            if (childElement.apy == null) {
                                childElement.apy = "";
                            }
                            if (childElement.tag != null && childElement.tag != 0) {
                                if (childElement.tag == 7) {
                                    if (childElement.tagApy != null && childElement.tagApy != "") {
                                        childElement.couponVis = "visible";
                                        childElement.couponValue = childElement.tagApy;
                                    }
                                } else if (childElement.tag == 8) {
                                    childElement.iconSrc = getTagIconByType$1(childElement.tag);
                                    childElement.earnVipVis = "visible";
                                    childElement.vipIconVis = "visible";
                                } else if (childElement.tag == 9) {
                                    childElement.iconSrc = getTagIconByType$1(childElement.tag);
                                    childElement.vipIconVis = "visible";
                                } else {
                                    childElement.tagVis = "visible";
                                    childElement.tagBg = getTagBgByType$1(childElement.tag);
                                    childElement.tagTextColor = getTagTextColorByType$1(childElement.tag);
                                }
                            }
                        }));
                        element.list = tempChild;
                    }
                }));
                if (scrollToPosTemp == -1) {
                    tempItems[0].childVis = "visible";
                    tempItems[0].expandStatusRes = "@drawable/edge_engine_strutured_arrow_up";
                    tempItems[0].apyVis = "gone";
                }
                moduleData$2.recommendList = tempItems;
                recommendList = tempItems;
                console.log(`xiaoyi isFirst= ${isFirst}  scrollToPosTemp = ${scrollToPosTemp}`);
                if (isFirst && hasCurrency()) {
                    $data.home.scrollToPos = scrollToPosTemp;
                }
                coinAnalytics$1(tempItems);
                console.log(`requesEarnHomeData  推荐列表 ${JSON.stringify(tempItems)}`);
            }
            let qaList = [ {
                type: "1",
                answerVisable: "gone",
                Q: $i18n.n_strutured_simple_H_1,
                A: $i18n.n_strutured_simple_T_1,
                qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon",
                A1Show: "gone",
                A2Show: "gone"
            }, {
                type: "1",
                answerVisable: "gone",
                Q: $i18n.n_strutured_simple_H_2,
                A: `${$i18n.n_strutured_simple_T_2_1}`,
                A1: `${$i18n.n_strutured_simple_T_2_2}`,
                A2: `${$i18n.n_strutured_simple_T_2_3}`,
                qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon",
                A1Show: "visible",
                A2Show: "visible"
            }, {
                type: "1",
                answerVisable: "gone",
                Q: $i18n.n_strutured_simple_H_3,
                A: `${$i18n.n_strutured_simple_T_3}`,
                A1: `${$i18n.n_strutured_intro_A_3_2}`,
                A2: `${$i18n.n_strutured_intro_A_3_3}`,
                qaIcon: "@drawable/edge_engine_shark_home_qa_spread_icon",
                A1Show: "visible",
                A2Show: "visible"
            } ];
            moduleData$2.qaList = qaList;
            console.log(`requesEarnHomeData  常见问题`);
        } else {
            analytics("app_earnPage_loadState", {
                pageLoadState: `fault`
            });
            analytics("app_earnPage_loadError", {
                errorMsg: `接口请求失败`
            });
        }
    } catch (e) {
        analytics("app_earnPage_loadState", {
            pageLoadState: `fault`
        });
        analytics("app_earnPage_loadError", {
            errorMsg: `数据异常 ： ${e}`
        });
        console.log(`requesEarnHomeData error, error = ${e}`);
    }
    console.log(`刷新结束`);
    moduleData$2.refreshStatus = 2;
    moduleData$2.loadingLottieVis = "gone";
    moduleData$2.loadingLottieStatus = "stop";
    const endTime = Date.now();
    console.log(`理财首页加载耗时 ： ${endTime - startTime}`);
    analytics("app_earnPage_loadTime", {
        pageLoadTime: `${endTime - startTime}`,
        nation: `${commonData.countryId}`
    });
    if (guideShow == null || guideShow == "") {
        guideShow = "1";
        moduleData$2.pop1Show = true;
        $nativeAPI.storage({
            action: "save",
            name: "earn",
            key: "guide_show",
            data: "1"
        });
    }
}

function hasCurrency() {
    return parameter.currency != undefined && parameter.currency != null && parameter.currency != "";
}

function handleTotalIncomeRich() {
    let text = moduleData$2.yesterdayIncome;
    let highlight = moduleData$2.totalIncome;
    var textColor = "#000000";
    var spaceColor = "#FFFFFF";
    var highlightColor = "#8A8A8E";
    var arrowColor = "#ADADB4";
    if (commonData.colorMode == 1) {
        textColor = "#E6E6E6";
        spaceColor = "#1E1E1F";
        highlightColor = "#5E5E61";
        arrowColor = "#4C4C4E";
    }
    return `<span style="color:${textColor}; font-size:12px;">${text}</span><span style="color:${spaceColor}; font-size:10px;">--</span><span style="color:${highlightColor}; font-size:12px;">${highlight}</span><span style="color:${arrowColor}; font-size:12px;"> ❯</span>`;
}

function coinAnalytics$1(coinDta) {
    try {
        coinDta.forEach(((element, index) => {
            console.log(`coinAnalytics  ${JSON.stringify(element)}`);
            analytics("app_earn_tokenCard_show", {
                page: "earnHome",
                token: element.currency,
                tsBaseInfo: element.tsBaseInfo
            });
        }));
    } catch (e) {
        console.log(`coinAnalytics error, error = ${e}`);
    }
}

function startSharkFinCountDown() {
    clearTimer();
    intercal = setInterval(changeCountdown, 1e3);
}

function changeCountdown() {
    try {
        console.log(`changeCountdown = ${JSON.stringify(moduleData$2.bannerList.rawArray())}`);
        for (let i = 0; i < moduleData$2.bannerList.length; i++) {
            if (moduleData$2.bannerList[i].areaType == 1 && moduleData$2.bannerList[i].project.projType == 4) {
                let project = moduleData$2.bannerList[i].project;
                if (project.countdown == null) {
                    return;
                }
                let countDown = (parseFloat(project.countdown) - sharkFinCount * 1e3) / 1e3;
                sharkFinCount = sharkFinCount + 1;
                if (countDown > 0) {
                    const d = Math.floor(countDown / dd);
                    const h = Math.floor(countDown % dd / hh);
                    const m = Math.floor(countDown % hh / mm);
                    const s = Math.floor(countDown % mm);
                    const showH = h < 10 ? `0${h}` : `${h}`;
                    const showM = m < 10 ? `0${m}` : `${m}`;
                    const showS = s < 10 ? `0${s}` : `${s}`;
                    if (d > 0) {
                        project.countDownStr = `${$i18n.n_exchange_call_auction_end_of_distance} ${d}${$i18n.n_mining_day_text} ${showH}:${showM}:${showS}`;
                    } else {
                        project.countDownStr = `${$i18n.n_exchange_call_auction_end_of_distance} ${showH}:${showM}:${showS}`;
                    }
                    console.log(`countDownStr = ${project.countDownStr}`);
                    moduleData$2.bannerList[i].project = project;
                } else {
                    requesEarnHomeData();
                }
            }
        }
    } catch (e) {
        console.log(`requesEarnHomeData error, error = ${e}`);
    }
}

function clearTimer() {
    if (intercal != null) {
        clearInterval(intercal);
        intercal = null;
        sharkFinCount = 1;
    }
}

function getTagIconByType$1(type) {
    if (type == 9) {
        return "@drawable/edge_engine_earn_launcher_pool_icon";
    } else {
        return moduleData$2.vipIcon;
    }
}

function getTagBgByType$1(type) {
    if (type == 0) {
        return null;
    } else if (type == 1) {
        return "@color/KColor1200A171";
    } else if (type == 2) {
        return "@color/KColor1200A171";
    } else if (type == 3) {
        return "@color/kColor1900A171";
    } else if (type == 4) {
        return "@color/KColor12FE8731";
    } else if (type == 5) {
        return "@color/kColorInputFill";
    } else if (type == 6) {
        return "@color/KColor12FE8731";
    } else if (type == 101) {
        return "@color/kColorSecondaryText";
    } else if (type == 11) {
        return "@color/kColor1A0173E5";
    }
}

function getTagTextColorByType$1(type) {
    if (type == 0) {
        return null;
    } else if (type == 1) {
        return "@color/KBaseRiskTextColorLow";
    } else if (type == 2) {
        return "@color/KBaseRiskTextColorLow";
    } else if (type == 3) {
        return "@color/kColorPriceGreen";
    } else if (type == 4) {
        return "@color/KBaseRiskTextColorMid";
    } else if (type == 5) {
        return "@color/kColorSecondaryText";
    } else if (type == 6) {
        return "@color/KBaseRiskTextColorMid";
    } else if (type == 101) {
        return "@color/kColorSecondaryText";
    } else if (type == 11) {
        return "@color/kColorMajorTheme100";
    }
}

moduleEvent$2.funcClick = function(index) {
    var element = moduleData$2.funcList[index];
    console.log(`funcClick  index : ${index}  jumpUrl : ${element.jumpUrl}`);
    openPageWithPath(element.jumpUrl);
    let productClassify = "simpleEarn";
    if (index == 0) {
        productClassify = "simpleEarn";
    } else if (index == 1) {
        productClassify = "newProduct";
    } else if (index == 2) {
        productClassify = "structuredProduct";
    } else if (index == 3) {
        productClassify = "onChainEarn";
    }
    analytics("app_earnPage_icon_click", {
        productClassify: productClassify
    });
};

moduleEvent$2.clickQA = function(Q) {
    try {
        console.log(`clickQA : ${Q}`);
        let tempQaList = moduleData$2.qaList;
        console.log(`clickQA : ${JSON.stringify(moduleData$2.qaList.rawArray())}`);
        console.log(`clickQA : ${JSON.stringify(tempQaList.rawArray())}`);
        for (let index = 0; index < tempQaList.length; index++) {
            let element = tempQaList[index];
            console.log(`clickQA : ${Q}     ${element.Q}`);
            if (Q == element.Q) {
                let operationType = "unfold";
                if (element.answerVisable == "gone") {
                    element.answerVisable = "visible";
                    element.qaIcon = "@drawable/edge_engine_shark_home_qa_retract_icon";
                    operationType = "unfold";
                } else {
                    element.answerVisable = "gone";
                    element.qaIcon = "@drawable/edge_engine_shark_home_qa_spread_icon";
                    operationType = "fold";
                }
                analytics("app_earn_FAQs_unfoldAndFold_click", {
                    page: "earnHome",
                    operationType: operationType,
                    order: `${index}`
                });
            }
        }
        moduleData$2.qaList = tempQaList;
    } catch (e) {
        console.log(`clickQA error, error = ${e}`);
    }
};

moduleEvent$2.itemClick = function(index) {
    try {
        console.log(`itemClick : ${index}    ${recommendList[index].childVis}  ${recommendList[index].listMainTagVis}`);
        let tempElement = {};
        if (commonData.OS == 1) {
            tempElement = moduleData$2.recommendList[index];
        } else {
            tempElement = recommendList[index];
        }
        if (tempElement.list != null && tempElement.list.length == 1) {
            let childElement = recommendList[index].list[0];
            jumpProduct$1(childElement, recommendList[index]);
            analytics("app_earn_productCard_show", {
                page: "earnHome",
                projectIds: childElement.projectIds,
                projectType: childElement.projType,
                token: recommendList[index].currency,
                tsBaseInfo: recommendList[index].tsBaseInfo
            });
        } else {
            let operationType = "unfold";
            if (tempElement.listMainTagVis == "visible") {
                tempElement.listMainTagVis = "gone";
            } else {
                if (tempElement.tag == 11) {
                    tempElement.listMainTagVis = "visible";
                }
            }
            if (tempElement.childVis == "gone") {
                tempElement.childVis = "visible";
                tempElement.apyVis = "gone";
                tempElement.couponVis = "gone";
                tempElement.iconVis = "gone";
                tempElement.expandStatusRes = "@drawable/edge_engine_strutured_arrow_up";
                operationType = "unfold";
                recommendList[index].list.forEach(((childElement, index) => {
                    analytics("app_earn_productCard_show", {
                        page: "earnHome",
                        projectIds: childElement.projectIds,
                        projectType: childElement.projType,
                        token: tempElement.currency,
                        tsBaseInfo: recommendList[index].tsBaseInfo
                    });
                }));
            } else {
                tempElement.childVis = "gone";
                tempElement.apyVis = "visible";
                if (tempElement.tag == 7 && tempElement.tagApy != null && tempElement.tagApy != "") {
                    tempElement.couponVis = "visible";
                    tempElement.couponValue = tempElement.tagApy;
                } else {
                    tempElement.couponVis = "gone";
                }
                if (tempElement.tag == 8 || tempElement.tag == 9) {
                    tempElement.iconVis = "visible";
                } else {
                    tempElement.iconVis = "gone";
                }
                tempElement.expandStatusRes = "@drawable/edge_engine_strutured_arrow_down";
                operationType = "fold";
            }
            console.log(`app_earn_tokenCard_click : ${JSON.stringify(tempElement)}`);
            if (commonData.OS == 1) {} else {
                moduleData$2.recommendList[index] = tempElement;
            }
            analytics("app_earn_tokenCard_click", {
                page: "earnHome",
                token: tempElement.currency,
                operationType: operationType,
                tsBaseInfo: recommendList[index].tsBaseInfo
            });
        }
    } catch (e) {
        console.log(`itemClick error, error = ${e}`);
    }
};

moduleEvent$2.nextItemClick = function(type = 0) {
    if (originMainData != null && originMainData.next != null && originMainData.next.jumpUrl != null) {
        console.log(`router = ${originMainData.next.jumpUrl}`);
        openPageWithPath(originMainData.next.jumpUrl);
    }
    if (type == 1) {
        analytics("app_earnPage_topPicks_viewMore_click");
    } else {
        analytics("app_earnPage_allToken_click");
    }
};

moduleEvent$2.refresh = function() {
    moduleData$2.refreshStatus = 1;
    requesEarnHomeData();
};

moduleEvent$2.searchClick = function() {
    openPageWithPath("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/edgeengine/container?scene=earn&rootName=searchcoin&navConfig=&fromType=1");
    analytics("app_earnPage_search_click");
};

moduleEvent$2.inComeClick = function() {
    openPageWithPath(originMainData.income.jumpUrl);
    analytics("app_earnPage_myAssets_click");
};

moduleEvent$2.autoEarnClick = function() {
    openPageWithPath("/financial/earn/h5/autoInvest");
    analytics("app_earn_homePage_autoEarn_click");
};

moduleEvent$2.productClick = function(parentIndex, childIndex) {
    let parentElement = recommendList[parentIndex];
    let childElement = recommendList[parentIndex].list[childIndex];
    jumpProduct$1(childElement, parentElement);
};

function jumpProduct$1(childElement, parentElement) {
    openPageWithPath(childElement.jumpUrl);
    analytics("app_earn_productCard_click", {
        page: "earnHome",
        projectIds: childElement.projectIds,
        projectType: childElement.projType,
        token: parentElement.currency,
        tsBaseInfo: parentElement.tsBaseInfo
    });
}

moduleEvent$2.bannerClick = function(element, index) {
    openPageWithPath(element);
    const parameters = bannerAnalyticsParameters(index);
    analytics("app_earnPage_productRecommend_click", parameters);
};

moduleEvent$2.recommend1Jump = function() {
    let element = originMainData.recommend[0];
    openPageWithPath(element.jumpUrl);
    try {
        analytics("app_earnPage_productRecommend_click", {
            state: "2",
            materialId: "",
            frame: "1",
            projectId: element.projectId,
            projectType: element.projectType,
            token: element.currency,
            term: element.term,
            tsBaseInfo: element.tsBaseInfo
        });
    } catch (e) {
        console.log(`recommend1Jump error, error = ${e}`);
    }
};

moduleEvent$2.recommend2Jump = function() {
    let element = originMainData.recommend[1];
    openPageWithPath(element.jumpUrl);
    try {
        analytics("app_earnPage_productRecommend_click", {
            state: "2",
            materialId: "",
            frame: "1",
            projectId: element.projectId,
            projectType: element.projectType,
            token: element.currency,
            term: element.term,
            tsBaseInfo: element.tsBaseInfo
        });
    } catch (e) {
        console.log(`recommend1Jump error, error = ${e}`);
    }
};

moduleEvent$2.nextPop = async function(step) {
    moduleData$2.pop1Show = "false";
    moduleData$2.pop2Show = "false";
    moduleData$2.pop3Show = "false";
    moduleData$2.pop4Show = "false";
    moduleData$2[`pop${step}Show`] = "true";
    await uploadLog("Earn", `引导 下一步, step=${step}`);
};

moduleEvent$2.hidePop = async function() {
    moduleData$2.pop1Show = "false";
    moduleData$2.pop2Show = "false";
    moduleData$2.pop3Show = "false";
    moduleData$2.pop4Show = "false";
    await uploadLog("Earn", `引导 完成`);
};

moduleEvent$2.bannerIndexChange = function(index) {
    const parameters = bannerAnalyticsParameters(index);
    analytics("app_earnPage_productRecommend_show", parameters);
};

function bannerAnalyticsParameters(index) {
    try {
        let element = moduleData$2.bannerList[parseInt(index)];
        let materialId = "";
        if (element.areaType == 2) {
            materialId = element.banner.advId;
        }
        let frame = parseInt(index) + 1;
        let projectId = "";
        let projectType = "";
        let token = "";
        let term = "";
        let tsBaseInfo = {};
        if (element.areaType == 3) {
            projectType = "newUser";
            if (element.project.tsBaseInfo && element.project.tsBaseInfo != null) {
                tsBaseInfo = element.project.tsBaseInfo.rawObject();
            }
        } else if (element.areaType == 1) {
            projectId = element.project.projectId;
            token = element.project.currency;
            term = element.project.term;
            if (element.project.tsBaseInfo && element.project.tsBaseInfo != null) {
                tsBaseInfo = element.project.tsBaseInfo.rawObject();
            }
            if (element.project.projType == 1) {
                projectType = "flexible";
            } else if (element.project.projType == 2) {
                projectType = "fixed";
            } else if (element.project.projType == 3) {
                projectType = "flexiMax";
            } else if (element.project.projType == 4) {
                projectType = "sharkFin";
            } else if (element.project.projTypepe == 5) {
                projectType = "dualInvestment";
            } else if (element.project.projType == 6) {
                projectType = "eth";
            } else if (element.project.projType == 7) {
                projectType = "regularInvest";
            }
        }
        return {
            state: "1",
            materialId: materialId,
            frame: frame,
            projectId: projectId,
            projectType: projectType,
            token: token,
            term: term,
            tsBaseInfo: tsBaseInfo
        };
    } catch (e) {
        console.log(`bannerClick error, error = ${e}`);
        return null;
    }
}

moduleEvent$2.toRecord = function() {
    openPageWithPath("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/edgeengine/container?scene=earn&rootName=introduce&navConfig=nav&index=0&tabIndex=0");
    analytics("app_earnPage_FAQ_click");
};

moduleEvent$2.backContainer = function() {
    containerBack();
    analytics("app_earnPage_returnButton_click");
};

moduleEvent$2.clickMoreQA = function() {
    openPageWithPath("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/edgeengine/container?scene=earn&rootName=introduce&navConfig=nav&index=0&tabIndex=0");
    analytics("app_earn_FAQs_more_click", {
        page: "earnHome"
    });
};

async function uploadLog(tag, info = "") {
    if (commonData.OS == 0) {
        var map = {
            tag: tag,
            info: info
        };
        await $nativeAPI.uploadLog(map);
    }
}

function defaultData$1() {
    return {
        coinDataRl: [],
        coinData: [],
        refreshStatus: 0,
        loadMoreStatus: 0,
        searchList: "",
        searchInput: "",
        onFocus: false,
        clearInputVis: "gone",
        borderColor: "@color/kColorMajorTheme100",
        backVis: "visible",
        searchHistoryVis: "visible",
        emptyDataVis: "gone",
        allCoinTitleVis: "visible",
        serachMarginLeft: "16"
    };
}

const {moduleData: moduleData$1, moduleEvent: moduleEvent$1} = moduleDefine("searchcoin", defaultData$1, {
    onCreate: onCreate$1,
    onStart: onStart,
    onDestroy: onDestroy$1
});

var page = 0;

var size = 100;

var isRefresh = true;

var lastDataSize = -1;

var searchInput = "";

var searchHistoryData = "earn_search_history_data";

var requestTimeout = null;

var coinData = [];

var needOnFocus = false;

function onCreate$1(jsonParameters) {
    let parameter = JSON.parse(jsonParameters);
    console.log(`onCreate -----\x3e  ${JSON.stringify(parameter)}`);
    const currency = parameter.currency;
    if (currency && currency != null) {
        searchInput = currency;
        moduleData$1.searchInput = currency;
    }
    initUI(parameter);
    requestCoinData();
    analytics("app_earn_allTokenPage_view");
}

function onStart() {
    if (needOnFocus) {
        moduleData$1.onFocus = true;
    }
    needOnFocus = false;
}

function initUI(parameter) {
    moduleData$1.statusBarConfig = {
        statusBarMode: "true",
        adStatusBarColor: "KBaseColorContentBackground",
        safeBottomTransparent: "true"
    };
    if (parameter.fromType == 1) {
        moduleData$1.backVis = "gone";
        moduleData$1.borderColor = "@color/kColorMajorTheme100";
        if (commonData.OS == 0) {
            needOnFocus = true;
        } else {
            moduleData$1.onFocus = true;
        }
        moduleData$1.searchHistoryVis = "visible";
        moduleData$1.serachMarginLeft = "16";
        initSearchHistoryData();
    } else if (parameter.fromType == 2) {
        moduleData$1.backVis = "visible";
        moduleData$1.borderColor = "@color/kColorInputFill";
        moduleData$1.onFocus = false;
        moduleData$1.searchHistoryVis = "gone";
        moduleData$1.serachMarginLeft = "0";
    }
    moduleData$1.coinDataRl = [];
}

async function initSearchHistoryData() {
    var historyData = await getDiskSearchData();
    console.log(`initSearchHistoryData visible : ${JSON.stringify(historyData)}`);
    if (historyData && historyData.length > 0) {
        moduleData$1.searchList = JSON.stringify(historyData);
        moduleData$1.searchHistoryVis = "visible";
    } else {
        moduleData$1.searchList = "";
        moduleData$1.searchHistoryVis = "gone";
    }
}

async function requestCoinData() {
    try {
        var parameter = {
            page: page,
            size: size,
            currency: searchInput
        };
        const data = await sendRequest("v4/saving/mining/home/currencyList", parameter);
        if (data != null && data.length > 0) {
            let tempItems = data;
            lastDataSize = tempItems.length;
            tempItems.forEach(((element, index) => {
                if (isRefresh) {
                    element.index = index;
                } else {
                    element.index = moduleData$1.coinData.length + index;
                }
                if (element.hold == null || element.hold == "") {
                    element.hold = "";
                    element.holdVis = "gone";
                } else {
                    element.holdVis = "visible";
                }
                if (element.apy == null) {
                    element.apy = "";
                }
                element.type = "1";
                element.iconUrl = getPNGIconURLByCurrency(element.currency);
                if (element.list != null && element.list.length == 1) {
                    element.expandStatusRes = "@drawable/edge_engine_icon_earn_home_jump";
                } else {
                    element.expandStatusRes = "@drawable/edge_engine_strutured_arrow_down";
                }
                element.apyVis = "visible";
                element.childVis = "gone";
                element.listMainTagVis = "gone";
                if (element.tag == 7 && element.tagApy != null && element.tagApy != "" && element.childVis == "gone") {
                    element.couponVis = "visible";
                    element.couponValue = element.tagApy;
                } else {
                    element.couponVis = "gone";
                }
                if (element.tag == 8 || element.tag == 9) {
                    element.iconSrc = getTagIconByType(element.tag);
                    if (element.childVis == "gone") {
                        element.iconVis = "visible";
                    } else {
                        element.iconVis = "gone";
                    }
                } else if (element.tag == 11) {
                    element.listMainTagVis = "visible";
                    element.tagBg = getTagBgByType(element.tag);
                    element.tagTextColor = getTagTextColorByType(element.tag);
                }
                if (element.list != null) {
                    let tempChild = element.list;
                    tempChild.forEach(((childElement, index) => {
                        childElement.type = "1";
                        childElement.index = index;
                        childElement.couponVis = "gone";
                        childElement.tagVis = "gone";
                        childElement.vipIconVis = "gone";
                        childElement.earnVipVis = "gone";
                        if (childElement.apy == null) {
                            childElement.apy = "";
                        }
                        if (childElement.tag != 0 && childElement.tag != null) {
                            if (childElement.tag == 7) {
                                if (childElement.tagApy != null && childElement.tagApy != "") {
                                    childElement.couponVis = "visible";
                                    childElement.couponValue = childElement.tagApy;
                                }
                            } else if (childElement.tag == 8) {
                                childElement.iconSrc = getTagIconByType(childElement.tag);
                                childElement.earnVipVis = "visible";
                                childElement.vipIconVis = "visible";
                            } else if (childElement.tag == 9) {
                                childElement.iconSrc = getTagIconByType(childElement.tag);
                                childElement.vipIconVis = "visible";
                            } else {
                                childElement.tagVis = "visible";
                                childElement.tagBg = getTagBgByType(childElement.tag);
                                childElement.tagTextColor = getTagTextColorByType(childElement.tag);
                            }
                        }
                    }));
                    element.list = tempChild;
                }
            }));
            if (isRefresh) {
                moduleData$1.coinData = tempItems;
                coinData = tempItems;
            } else {
                tempItems.forEach((element20 => {
                    moduleData$1.coinData.push(element20);
                }));
                coinData.push(...tempItems);
            }
            coinAnalytics(tempItems);
            console.log(`requestCoinData -----\x3e  ${JSON.stringify(moduleData$1.coinData.rawArray())}`);
        } else {
            lastDataSize = -1;
            if (isRefresh) {
                moduleData$1.coinData = [];
            }
        }
        if (moduleData$1.coinData && moduleData$1.coinData.length > 0) {
            moduleData$1.emptyDataVis = "gone";
            moduleData$1.allCoinTitleVis = "visible";
        } else {
            moduleData$1.emptyDataVis = "visible";
            moduleData$1.allCoinTitleVis = "gone";
        }
    } catch (e) {
        console.log(`requestCoinData error, error = ${e}`);
    }
    moduleData$1.refreshStatus = 2;
    moduleData$1.loadMoreStatus = 2;
}

function coinAnalytics(coinList) {
    coinList.forEach(((element, index) => {
        analytics("app_earn_tokenCard_show", {
            page: "allToken",
            token: element.currency,
            tsBaseInfo: element.tsBaseInfo
        });
    }));
}

function getTagIconByType(type) {
    if (type == 9) {
        return "@drawable/edge_engine_earn_launcher_pool_icon";
    } else {
        return $data.home.vipIcon;
    }
}

function getTagBgByType(type) {
    if (type == 0) {
        return null;
    } else if (type == 1) {
        return "@color/KColor1200A171";
    } else if (type == 2) {
        return "@color/KColor1200A171";
    } else if (type == 3) {
        return "@color/kColor1900A171";
    } else if (type == 4) {
        return "@color/KColor12FE8731";
    } else if (type == 5) {
        return "@color/kColorInputFill";
    } else if (type == 6) {
        return "@color/KColor12FE8731";
    } else if (type == 101) {
        return "@color/kColorSecondaryText";
    } else if (type == 11) {
        return "@color/kColor1A0173E5";
    }
}

function getTagTextColorByType(type) {
    if (type == 0) {
        return null;
    } else if (type == 1) {
        return "@color/KBaseRiskTextColorLow";
    } else if (type == 2) {
        return "@color/KBaseRiskTextColorLow";
    } else if (type == 3) {
        return "@color/kColorPriceGreen";
    } else if (type == 4) {
        return "@color/KBaseRiskTextColorMid";
    } else if (type == 5) {
        return "@color/kColorSecondaryText";
    } else if (type == 6) {
        return "@color/KBaseRiskTextColorMid";
    } else if (type == 101) {
        return "@color/kColorSecondaryText";
    } else if (type == 11) {
        return "@color/kColorMajorTheme100";
    }
}

moduleEvent$1.itemClick = function(index) {
    let tempElement = coinData[index];
    let operationType = "unfold";
    if (tempElement.list != null && tempElement.list.length == 1) {
        let childElement = tempElement.list[0];
        jumpProduct(childElement, tempElement);
        analytics("app_earn_productCard_show", {
            page: "earnHome",
            projectIds: childElement.projectIds,
            projectType: childElement.projType,
            token: tempElement.currency,
            tsBaseInfo: tempElement.tsBaseInfo
        });
    } else {
        if (tempElement.listMainTagVis == "visible") {
            tempElement.listMainTagVis = "gone";
        } else {
            if (tempElement.tag == 11) {
                tempElement.listMainTagVis = "visible";
            }
        }
        if (tempElement.childVis == "gone") {
            tempElement.childVis = "visible";
            tempElement.apyVis = "gone";
            tempElement.couponVis = "gone";
            tempElement.iconVis = "gone";
            tempElement.expandStatusRes = "@drawable/edge_engine_strutured_arrow_up";
            operationType = "unfold";
            let productList = tempElement.list;
            productList.forEach(((childElement, index) => {
                analytics("app_earn_productCard_show", {
                    page: "allToken",
                    projectIds: childElement.projectIds,
                    projectType: childElement.projType,
                    token: tempElement.currency,
                    tsBaseInfo: tempElement.tsBaseInfo
                });
            }));
        } else {
            tempElement.childVis = "gone";
            tempElement.apyVis = "visible";
            if (tempElement.tag == 7 && tempElement.tagApy != null && tempElement.tagApy != "") {
                tempElement.couponVis = "visible";
                tempElement.couponValue = tempElement.tagApy;
            } else {
                tempElement.couponVis = "gone";
            }
            if (tempElement.tag == 8 || tempElement.tag == 9) {
                tempElement.iconVis = "visible";
            } else {
                tempElement.iconVis = "gone";
            }
            tempElement.expandStatusRes = "@drawable/edge_engine_strutured_arrow_down";
            operationType = "fold";
        }
        saveItem2Disk(tempElement.currency);
        analytics("app_earn_tokenCard_click", {
            page: "allToken",
            token: tempElement.currency,
            operationType: operationType,
            tsBaseInfo: tempElement.tsBaseInfo
        });
        moduleData$1.coinData[index] = tempElement;
    }
};

async function saveItem2Disk(keyword) {
    if (searchInput == "" || searchInput == null) {
        return;
    }
    var saveList = [];
    var diskData = await getDiskSearchData();
    console.log(`取出的本地数据 : ${JSON.stringify(diskData)}`);
    if (diskData.indexOf(keyword) == -1) {
        saveList.push(keyword);
        if (diskData.length > 10) {
            diskData.splice(diskData.length - 1, 1);
        }
        saveList.push(...diskData);
        console.log(`cacheHsitory saveItem2Disk 将要存储的数据 : ${JSON.stringify(saveList)}`);
        await $nativeAPI.storage({
            action: "save",
            name: "earn",
            key: searchHistoryData,
            data: JSON.stringify(saveList)
        });
    } else {
        diskData = diskData.filter((function(item) {
            return item !== keyword;
        }));
        saveList.push(keyword);
        saveList.push(...diskData);
        console.log(`cacheHsitory saveItem2Disk 将要存储的数据 : ${JSON.stringify(saveList)}`);
        await $nativeAPI.storage({
            action: "save",
            name: "earn",
            key: searchHistoryData,
            data: JSON.stringify(saveList)
        });
    }
}

async function getDiskSearchData() {
    var data = await $nativeAPI.storage({
        action: "read",
        name: "earn",
        key: searchHistoryData
    });
    try {
        if (data && data != "") {
            return JSON.parse(data);
        }
        return [];
    } catch (e) {
        console.log(`getDiskSearchData error, error = ${e}`);
        return [];
    }
}

moduleEvent$1.refresh = function() {
    moduleData$1.refreshStatus = 1;
    page = 0;
    isRefresh = true;
    requestCoinData();
};

moduleEvent$1.loadMore = function() {};

moduleEvent$1.historyClick = function(clickStr) {
    console.log(`moduleEvent historyClick  ${clickStr}`);
    moduleData$1.searchInput = clickStr;
    if (commonData.OS == 0) {
        moduleEvent$1.textChange(clickStr);
    }
    analytics("app_earn_allTokenPage_searchHistory_click");
};

moduleEvent$1.onReturn = function(parameter) {
    moduleData$1.onFocus = false;
};

moduleEvent$1.textChange = function(parameter) {
    console.log(`textChange -----\x3e  ${parameter}`);
    searchInput = parameter;
    if (searchInput == "") {
        moduleData$1.clearInputVis = "gone";
    } else {
        moduleData$1.clearInputVis = "visible";
    }
    try {
        requestTimeout = setTimeout((() => {
            console.log(`延迟请求 -----\x3e`);
            page = 0;
            isRefresh = true;
            requestCoinData();
        }), 500);
        console.log(` -----\x3e ${requestTimeout}`);
    } catch (e) {
        console.log(`error, error = ${e}`);
    }
};

moduleEvent$1.focusChange = function(parameter) {
    if (parameter) {
        moduleData$1.borderColor = "@color/kColorMajorTheme100";
    } else {
        moduleData$1.borderColor = "@color/kColorInputFill";
    }
};

moduleEvent$1.cancel = function() {
    containerBack();
};

moduleEvent$1.clearFocus = function() {
    moduleData$1.onFocus = false;
};

moduleEvent$1.clearInput = function() {
    moduleData$1.searchInput = "";
};

moduleEvent$1.clearSearchHistory = async function() {
    moduleData$1.searchList = "";
    await $nativeAPI.storage({
        action: "clear",
        name: "earn",
        key: searchHistoryData
    });
    moduleData$1.searchHistoryVis = "gone";
    analytics("app_earn_allTokenPage_searchHistory_deleteButton_click");
};

moduleEvent$1.childItmClick = function(parentIndex, childIndex) {
    let parentElement = coinData[parentIndex];
    let childElement = coinData[parentIndex].list[childIndex];
    saveItem2Disk(parentElement.currency);
    jumpProduct(childElement, parentElement);
};

function jumpProduct(childElement, parentElement) {
    openPageWithPath(childElement.jumpUrl);
    analytics("app_earn_productCard_click", {
        page: "allToken",
        projectIds: childElement.projectIds,
        projectType: childElement.projType,
        token: parentElement.currency,
        tsBaseInfo: parentElement.tsBaseInfo
    });
}

function onDestroy$1() {
    moduleData$1.refreshStatus = 0;
    moduleData$1.loadMoreStatus = 0;
    moduleData$1.searchList = "";
    moduleData$1.searchInput = "";
    moduleData$1.onFocus = false;
    moduleData$1.clearInputVis = "gone";
    moduleData$1.borderColor = "@color/kColorMajorTheme100";
    moduleData$1.backVis = "visible";
    moduleData$1.searchHistoryVis = "visible";
    page = 0;
    isRefresh = true;
    lastDataSize = -1;
    searchInput = "";
    requestTimeout = null;
    needOnFocus = false;
    analytics("app_earn_allTokenPage_returnButton_click");
}

class FinanceGroupType {
    static SPOT_WITHDRAW=1;
    static SPOT_DEPOSIT=2;
    static SPOT_SYSTEM=3;
    static SPOT_POINT=4;
    static SPOT_TRANSFER_IN=5;
    static SPOT_TRANSFER_OUT=6;
    static SPOT_MANAGEMENT_FEE=7;
    static SPOT_BORROW_RETURN=8;
    static MARGIN_APPLY_LOAN=11;
    static MARGIN_REPAY_LOAN=12;
    static MARGIN_REPAY_INTEREST=13;
    static CROSS_MARGIN_APPLY_LOAN=21;
    static CROSS_MARGIN_USER_REPAY=22;
    static CROSS_MARGIN_SYSTEM_REPAY=23;
}

function getRequestType(groupType) {
    switch (groupType) {
      case FinanceGroupType.SPOT_DEPOSIT:
        return "deposit";

      case FinanceGroupType.SPOT_WITHDRAW:
        return "withdraw";

      case FinanceGroupType.SPOT_POINT:
        return "point";

      case FinanceGroupType.SPOT_TRANSFER_IN:
        return "transfer-in";

      case FinanceGroupType.SPOT_TRANSFER_OUT:
        return "transfer-out";

      case FinanceGroupType.SPOT_SYSTEM:
        return "system";
    }
    return "withdraw";
}

function getSpotFinanceTypeWithGroup(group) {
    var type;
    if (group == "deposit") {
        type = FinanceGroupType.SPOT_DEPOSIT;
    } else if (group == "withdraw") {
        type = FinanceGroupType.SPOT_WITHDRAW;
    } else if (group == "point") {
        type = FinanceGroupType.SPOT_POINT;
    } else if (group == "transfer-in") {
        type = FinanceGroupType.SPOT_TRANSFER_IN;
    } else if (group == "transfer-out") {
        type = FinanceGroupType.SPOT_TRANSFER_OUT;
    } else {
        type = FinanceGroupType.SPOT_SYSTEM;
    }
    return type;
}

function getSpotDisplayType(financeType) {
    switch (financeType) {
      case FinanceGroupType.SPOT_DEPOSIT:
        return $i18n.n_coindetail_history_deposit;

      case FinanceGroupType.SPOT_WITHDRAW:
        return $i18n.n_coindetail_history_withdraw;

      case FinanceGroupType.SPOT_POINT:
        return $i18n.n_coindetail_history_point;

      case FinanceGroupType.SPOT_TRANSFER_IN:
        return $i18n.n_coindetail_history_in;

      case FinanceGroupType.SPOT_TRANSFER_OUT:
        return $i18n.n_coindetail_history_out;

      case FinanceGroupType.SPOT_SYSTEM:
        return $i18n.n_coindetail_history_other;
    }
    return "";
}

function getSpotFinanceState(state, financeTabType) {
    var stateStr = $i18n.n_coindetail_history_status_completed;
    if (financeTabType == FinanceGroupType.SPOT_DEPOSIT) {
        if (state == "confirming" || state == "confirmed" || state == "orphan-confirming" || state == "orphan-confirmed" || state == "rollback-confirming" || state == "rollback-confirmed") {
            stateStr = $i18n.n_coindetail_history_status_confirming;
        } else if (state == "orphan" || state == "rollback-orphan") {
            stateStr = $i18n.n_coindetail_history_status_orphan;
        } else if (state.includes("safe") || state == "valid") {
            stateStr = $i18n.n_coindetail_history_status_completed;
        } else if (state == "risk-delay") {
            stateStr = $i18n.n_coindetail_history_status_to_be_credited;
        } else if (state == "pending-tiny-amount" || state == "waiting-tiny-amount") {
            stateStr = $i18n.n_coindetail_history_status_small_amount_is_not_accounted;
        } else if (state == "large-amount-examine") {
            stateStr = $i18n.n_coindetail_history_status_waiting_review;
        } else if (state == "unknown") {
            if (state == "deposit-virtual-fast") {
                stateStr = $i18n.n_coindetail_history_status_confirming;
            }
        }
    } else {
        if (state == "pre-submitted" || state == "submitted" || state == "reexamine") {
            stateStr = $i18n.n_coindetail_history_status_waiting_review;
        } else if (state == "pass" || state == "pre-transfer") {
            stateStr = $i18n.n_coindetail_history_status_processing;
        } else if (state == "reject") {
            stateStr = $i18n.n_coindetail_history_status_refused;
        } else if (state == "wallet-transfer") {
            stateStr = $i18n.n_coindetail_history_status_send;
        } else if (state == "wallet-reject" || state == "confirm-error") {
            stateStr = $i18n.n_coindetail_history_status_failed;
        } else if (state == "confirmed") {
            stateStr = $i18n.n_coindetail_history_status_completed;
        } else if (state == "canceled" || state == "repealed") {
            stateStr = $i18n.n_coindetail_history_status_canceled;
        } else if (state == "Verifying") {
            stateStr = $i18n.n_coindetail_history_status_need_verify;
        } else if (state == "Failed") {
            stateStr = $i18n.n_coindetail_history_status_verify_failure;
        }
    }
    return stateStr;
}

function getSpotDisplayStatusDetail(type, direction, desc, item_extra) {
    if (desc != null && desc != "") {
        return desc;
    }
    var displayStatusDetail = "--";
    if (type.includes("bitex") || type.includes("oldhuobi")) {
        displayStatusDetail = direction == "in" ? $i18n.n_coindetail_history_in : $i18n.n_coindetail_history_out;
        displayStatusDetail = displayStatusDetail + " huobi.com";
    } else if (type == "6" || type.includes("otc-to-pro")) {
        displayStatusDetail = $i18n.n_coindetail_history_record_otc_to_pro;
    } else if (type == "5" || type.includes("pro-to-otc")) {
        displayStatusDetail = $i18n.n_coindetail_history_record_pro_to_otc;
    } else if (type.includes("sub-transfer-out") || type == "master-transfer-in") {
        displayStatusDetail = $i18n.n_coindetail_history_record_child_to_pro;
    } else if (type.includes("sub-transfer-in") || type == "master-transfer-out") {
        displayStatusDetail = $i18n.n_coindetail_history_record_pro_to_child;
    } else if (type.includes("pro-to-super-margin")) {
        displayStatusDetail = $i18n.n_coindetail_history_record_pro_to_supermargin;
    } else if (type.includes("super-margin-to-pro")) {
        displayStatusDetail = $i18n.n_coindetail_history_record_supermargin_to_pro;
    } else if (type == "margin-transfer-in") {
        displayStatusDetail = $i18n.n_coindetail_history_record_pro_to_margin;
    } else if (type == "margin-transfer-out") {
        displayStatusDetail = $i18n.n_coindetail_history_record_margin_to_pro;
    } else if (type == "pro-to-futures") {
        displayStatusDetail = $i18n.n_coindetail_history_record_pro_to_contract;
    } else if (type == "futures-to-pro") {
        displayStatusDetail = $i18n.n_coindetail_history_record_contract_to_pro;
    } else if (type == "dm-pro-to-swap") {
        displayStatusDetail = $i18n.n_coindetail_history_record_pro_to_swap;
    } else if (type == "dm-swap-to-pro") {
        displayStatusDetail = $i18n.n_coindetail_history_record_swap_to_pro;
    } else if (type == "spot-to-linear-swap") {
        displayStatusDetail = $i18n.n_coindetail_history_record_pro_to_linear_swap_usdt;
    } else if (type == "linear-swap-to-spot") {
        displayStatusDetail = $i18n.n_coindetail_history_record_linear_swap_usdt_to_pro;
    } else if (type == "pool-savings-spot-to-clct") {
        displayStatusDetail = $i18n.n_coindetail_history_record_pro_to_earn;
    } else if (type == "pool-savings-expend-to-spot") {
        displayStatusDetail = $i18n.n_coindetail_history_record_earn_to_pro;
    } else if (type == "pool-savings-ops-to-asset-management-spot" || type == "finance-project-system-to-kol" || type == "finance-project-system-to-kol-market" || type == "finance-project-system-to-channel" || type == "finance-project-system-to-market" || type == "finance-project-system-to-brand" || type == "finance-project-system-to-relations" || type == "finance-project-system-to-activity") {
        displayStatusDetail = $i18n.n_coindetail_history_record_system_transfer_in;
    } else if (type == "pool-savings-asset-management-spot-to-ops" || type == "pool-savings-asset-management-spot-to-interest") {
        displayStatusDetail = $i18n.n_coindetail_history_record_system_transfer_out;
    } else if (type == "grid-transfer-in") {
        displayStatusDetail = $i18n.n_grid_transfer_in;
    } else if (type == "grid-transfer-out") {
        displayStatusDetail = $i18n.n_grid_transfer_out;
    } else if (type == "otc-options-to-spot") {
        displayStatusDetail = $i18n.n_coindetail_history_record_otc_option_to_pro;
    } else if (type == "spot-to-otc-options") {
        displayStatusDetail = $i18n.n_coindetail_history_record_pro_to_otc_option;
    } else if (type == "earn-sys-commission-to-spot") {
        displayStatusDetail = $i18n.n_coindetail_history_record_earn_award;
    } else if (type == "fund-org-to-fund-rise-system" || type == "investor-to-fund-rise-system" || type == "institution-investor-to-fund-rise-system") {
        displayStatusDetail = $i18n.n_coindetail_history_record_system_transfer_out;
    } else if (type == "fund-rise-system-to-fund-org" || type == "fund-rise-system-to-investor" || type == "project-airdrop-user-spot-oneside-in" || type == "fund-rise-system-to-institution-investor" || type == "fund-rise-system-to-funder") {
        displayStatusDetail = $i18n.n_coindetail_history_record_system_transfer_in;
    } else if (type == "airdrop-user-spot-oneside-in" || type == "global-activity-to-spot" || type == "global-mining-system-to-spot") {
        displayStatusDetail = $i18n.n_coindetail_history_record_activity_reward;
    } else if (type == "reward-activity-system-to-user") {
        displayStatusDetail = $i18n.n_coindetail_history_record_red_envelope_reward;
    } else if (type == "api-brokerage-auto-brokerage-to-spot" || type == "api-brokerage-futures-auto-brokerage-to-spot" || type == "api-brokerage-brokerage-to-spot" || type == "api-brokerage-futures-brokerage-to-spot" || type == "api-matching-fee-brokerage") {
        displayStatusDetail = $i18n.n_coindetail_history_record_api_brokerage_to_spot;
    } else if (type == "global-sys-overseas-activity-to-spot") {
        displayStatusDetail = $i18n.n_coindetail_history_record_reward_receive;
    } else if (type == "global-spot-to-sys-overseas-activity") {
        displayStatusDetail = $i18n.n_coindetail_history_record_deduction;
    } else if (type == "global-coupon-system-to-spot") {
        displayStatusDetail = $i18n.n_coindetail_history_record_cashback_voucher;
    } else if (type == "leverage-principal-to-loan-receivable") {
        displayStatusDetail = $i18n.n_coindetail_history_record_c2cLendInCoinTitle;
    } else if (type == "leverage-loan-receivable-to-principal") {
        displayStatusDetail = $i18n.n_coindetail_history_record_repay_coin;
    } else if (type == "leverage-spot-to-interest-receivable") {
        displayStatusDetail = $i18n.n_coindetail_history_record_accrual_title;
    } else if (type == "nft-platform-system-to-seller-spot-copyright") {
        displayStatusDetail = $i18n.n_coindetail_history_record_nft_copyright;
    } else if (type == "nft-platform-system-to-seller-spot-sale") {
        displayStatusDetail = $i18n.n_coindetail_history_record_nft_sale;
    } else if (type == "nft-spot-to-platform-system") {
        displayStatusDetail = $i18n.n_coindetail_history_record_nft_buy;
    } else if (type == "nft-platform-system-to-spot") {
        displayStatusDetail = $i18n.n_coindetail_history_record_nft_refund;
    } else if (type == "leverage-interest-receivable-to-trans-sys") {
        displayStatusDetail = $i18n.n_coindetail_history_record_repay_interest;
    } else if (type == "global-Fundraising-spot-to-system") {
        displayStatusDetail = $i18n.n_coindetail_history_record_subscribe_update;
    } else if (type == "1-Additionalnterest-system-to-spot") {
        displayStatusDetail = $i18n.n_coindetail_history_record_interest_reissue_update;
    } else if (type == "global-shark007-system-to-spot" || type == "global-ins01-system-to-spot" || type == "pool-savings-interest-to-spot") {
        displayStatusDetail = $i18n.n_coindetail_history_record_interest_issue_update;
    } else if (type == "earn-sys-rate-to-spot") {
        displayStatusDetail = $i18n.n_coindetail_history_record_interest_coupon_issue_update;
    } else if (type == "global-Fundraising-system-to-spot") {
        displayStatusDetail = $i18n.n_coindetail_history_record_redemption_update;
    } else if (type == "global-Surpluscurrency-spot-to-system" || type == "global-Surpluscurrency-system-to-spot" || type == "global-shark008-spot-to-spot" || type == "1-Additionalnterest-spot-to-system") {
        displayStatusDetail = $i18n.n_coindetail_history_other;
    } else if (type == "global-newcurrency-frozen-to-system") {
        displayStatusDetail = $i18n.n_coindetail_history_record_ht_to_htx;
    } else if (type == "global-newcurrency02-system-to-spot") {
        displayStatusDetail = $i18n.n_coindetail_history_record_htx;
    } else if (type == "global-Xcurrenyairdorp02-system-to-spot") {
        displayStatusDetail = $i18n.n_coindetail_history_record_redemption_update_htx;
    } else if (type == "common-transfer" || type == "common-transfer-in") {
        if (item_extra != null && item_extra["source-type"] != null) {
            if (item_extra["source-type"] == "spot-to-linear-swap-copytrading") {
                displayStatusDetail = $i18n.n_coindetail_history_record_spot_to_copytrading;
            } else if (item_extra["source-type"] == "linear-swap-copytrading-to-spot") {
                displayStatusDetail = $i18n.n_coindetail_history_record_copytrading_to_spot;
            }
        }
    } else if (type == "global-htxtrademining06-spot-to-system") {
        displayStatusDetail = $i18n.n_coindetail_history_record_htxtrademining06_spot_to_system;
    } else if (type == "global-htxtrademining05-system-to-spot") {
        displayStatusDetail = $i18n.n_coindetail_history_record_htxtrademining05_system_to_spot;
    } else if (type == "global-htxcontracttrademining05-system-to-spot") {
        displayStatusDetail = $i18n.n_coindetail_history_record_htxcontracttrademining05_system_to_spot;
    } else if (type == "global-htxcontracttrademining06-spot-to-system") {
        displayStatusDetail = $i18n.n_coindetail_history_record_htxcontracttrademining06_spot_to_system;
    } else if (type == "global-makermining03-system-to-spot") {
        displayStatusDetail = $i18n.n_coindetail_history_record_makermining03_system_to_spot;
    } else if (type == "global-makermining04-spot-to-system") {
        displayStatusDetail = $i18n.n_coindetail_history_record_makermining04_spot_to_system;
    } else if (type == "global-hygdwk03-system-to-spot") {
        displayStatusDetail = $i18n.n_coindetail_history_record_hygdwk03_system_to_spot;
    } else if (type == "global-hygdwk04-spot-to-system") {
        displayStatusDetail = $i18n.n_coindetail_history_record_hygdwk04_spot_to_system;
    } else if (type == "trade-fee-deduction-pay-user-trade-to-match") {
        displayStatusDetail = $i18n.n_coindetail_history_record_trade_to_match;
    } else if (type == "trade-fee-deduction-pay-user-trade-to-match-parent") {
        displayStatusDetail = $i18n.n_coindetail_history_record_trade_to_match_parent;
    } else if (type == "spot-to-sub-trade") {
        displayStatusDetail = $i18n.n_coindetail_history_record_spot_to_subtrade;
    } else if (type == "sub-trade-to-spot") {
        displayStatusDetail = $i18n.n_coindetail_history_record_subtrade_to_spot;
    } else if (type == "global-incomefromuid1-spot-to-system") {
        displayStatusDetail = $i18n.n_coindetail_history_record_income_spot_to_system;
    } else if (type == "global-restakingreward01-system-to-spot") {
        displayStatusDetail = $i18n.n_coindetail_history_record_restaking_system_to_spot;
    } else if (type == "global-coupon-system-to-spot") {
        displayStatusDetail = $i18n.n_coindetail_history_record_coupon_system_to_spot;
    } else if (type == "prepayment_system_to_spot") {
        displayStatusDetail = $i18n.n_coindetail_history_record_prepayment_system_to_spot;
    } else if (type == "prepayment_system_to_margin_trade") {
        displayStatusDetail = $i18n.n_coindetail_history_record_prepayment_system_to_margin_trade;
    } else if (type == "prepayment_system_to_supermargin_trade") {
        displayStatusDetail = $i18n.n_coindetail_history_record_prepayment_system_to_supermargin_trade;
    } else if (type == "prepayment_system_to_cryptoloan_trade") {
        displayStatusDetail = $i18n.n_coindetail_history_record_prepayment_system_to_cryptoloan_trade;
    } else if (type == "prepayment_repay0_spot_to_system") {
        displayStatusDetail = $i18n.n_coindetail_history_record_prepayment_repay0_spot_to_system;
    } else if (type == "prepayment_repay1_spot_to_system") {
        displayStatusDetail = $i18n.n_coindetail_history_record_prepayment_repay1_spot_to_system;
    } else if (type == "prepayment_repay2_spot_to_system") {
        displayStatusDetail = $i18n.n_coindetail_history_record_prepayment_repay2_spot_to_system;
    } else if (type == "prepayment_repay3_spot_to_system") {
        displayStatusDetail = $i18n.n_coindetail_history_record_prepayment_repay3_spot_to_system;
    } else if (type == "prepayment_repay4_spot_to_system") {
        displayStatusDetail = $i18n.n_coindetail_history_record_prepayment_repay4_spot_to_system;
    } else if (type == "prepayment_repay5_spot_to_system") {
        displayStatusDetail = $i18n.n_coindetail_history_record_prepayment_repay5_spot_to_system;
    } else if (type == "prepayment_repay6_spot_to_system") {
        displayStatusDetail = $i18n.n_coindetail_history_record_prepayment_repay6_spot_to_system;
    } else if (type == "global-launchpool01-system-to-spot") {
        displayStatusDetail = $i18n.n_coindetail_history_record_launchpool01_system_to_spot;
    } else if (type == "global-launchpool02-spot-to-system") {
        displayStatusDetail = $i18n.n_coindetail_history_record_launchpool02_spot_to_system;
    } else if (type == "global-rebate-brokerage-to-spot-brokerage" || type == "global-rebate-brokerage-to-spot-brokerage-htx" || type == "global-rebate-brokerage-to-spot-brokerage-trx" || type == "matching-fee-brokerage-ht" || type == "matching-fee-brokerage" || type == "futures-brokerage-to-spot" || type == "futures-brokerage-to-spot-htx" || type == "futures-brokerage-to-spot-trx" || type == "global-rebate-brokerage-to-spot-2nd") {
        displayStatusDetail = $i18n.n_coindetail_history_record_rebate_cashback;
    } else if (type == "global-rebate-brokerage-to-spot-cashback" || type == "global-rebate-brokerage-to-spot-cashback-htx" || type == "global-rebate-brokerage-to-spot-cashback-trx" || type == "futures-cashback-operation-to-spot" || type == "futures-cashback-operation-to-spot-htx" || type == "futures-cashback-operation-to-spot-trx") {
        displayStatusDetail = $i18n.n_coindetail_history_record_rebate_brokerage;
    } else if (type == "global-Championship01-system-to-spot") {
        displaysStatusDetail = $i18n.n_coindetail_history_record_championship01_system_to_spot;
    } else if (type == "global-tradeevent01-system-to-spot" || type == "global-tradeevent02-spot-to-system") {
        displayStatusDetail = $i18n.n_coindetail_history_record_tradeevent01_system_to_spot;
    } else if (type == "global-communityairdrop03-system-to-spot") {
        displayStatusDetail = $i18n.n_coindetail_history_record_global_communityairdrop03_system_to_spot;
    } else if (type == "global-communityairdrop04-spot-to-system") {
        displayStatusDetail = $i18n.n_coindetail_history_record_global_communityairdrop04_spot_to_system;
    } else if (type == "global-Redenvelope01-spot-to-system" || type == "global-Redenvelope04-spot-to-system" || type == "global-Redenvelope07-spot-to-system" || type == "global-Redenvelope10-spot-to-system") {
        displayStatusDetail = $i18n.n_coindetail_history_record_redenvelope_spot_to_system;
    } else if (type == "global-Redenvelope02-system-to-spot" || type == "global-Redenvelope05-system-to-spot" || type == "global-Redenvelope08-system-to-spot" || type == "global-Redenvelope11-system-to-spot") {
        displayStatusDetail = $i18n.n_coindetail_history_record_redenvelope_system_to_spot;
    } else if (type == "global-Redenvelope03-system-to-spot" || type == "global-Redenvelope06-system-to-spot" || type == "global-Redenvelope09-system-to-spot" || type == "global-Redenvelope12-system-to-spot") {
        displayStatusDetail = $i18n.n_coindetail_history_record_redenvelope_refund_system_to_spot;
    }
    return displayStatusDetail;
}

var requestCurrency = "";

var currencySymbol = "";

var currencyName = "";

var earnItemUrl = "";

var earnJumpUrl = "";

var todayProfitRate = "0";

var types = "withdraw";

var reqStartDate, reqEndDate;

var lastTabIndex = 0;

const originGridData = [ {
    cellType: "1",
    name: $i18n.n_asset_coindetail_available,
    value: "--",
    valueRate: "",
    rateShow: "gone",
    lineShow: "gone",
    height: "54",
    popType: 0
}, {
    cellType: "1",
    name: $i18n.n_asset_coindetail_locked,
    value: "--",
    valueRate: "",
    rateShow: "gone",
    lineShow: "visible",
    height: "54",
    popType: 1
}, {
    cellType: "1",
    name: $i18n.n_asset_coindetail_last_price,
    value: "--",
    valueRate: "",
    rateShow: "gone",
    lineShow: "gone",
    height: "54",
    popType: 0
}, {
    cellType: "1",
    name: $i18n.n_asset_coindetail_cost_price,
    value: "--",
    valueRate: "",
    rateShow: "gone",
    lineShow: "visible",
    height: "54",
    popType: 2
}, {
    cellType: "1",
    name: $i18n.n_today_profit,
    value: "--",
    valueRate: "",
    rateShow: "visible",
    lineShow: "visible",
    height: "78",
    popType: 3
}, {
    cellType: "1",
    name: $i18n.n_asset_coindetail_total_pnl,
    value: "--",
    valueRate: "",
    rateShow: "visible",
    lineShow: "visible",
    height: "78",
    popType: 4
} ];

const historyTypes = [ {
    type: "tab",
    index: 0,
    text: $i18n.n_coindetail_history_withdraw,
    textColor: "@color/kColorPrimaryText",
    bgColor: "@color/KBaseColorInputBackground",
    groupType: FinanceGroupType.SPOT_WITHDRAW
}, {
    type: "tab",
    index: 1,
    text: $i18n.n_coindetail_history_deposit,
    textColor: "@color/kColorSecondaryText",
    bgColor: "@color/KBaseColorContentBackground",
    groupType: FinanceGroupType.SPOT_DEPOSIT
}, {
    type: "tab",
    index: 2,
    text: $i18n.n_coindetail_history_in,
    textColor: "@color/kColorSecondaryText",
    bgColor: "@color/KBaseColorContentBackground",
    groupType: FinanceGroupType.SPOT_TRANSFER_IN
}, {
    type: "tab",
    index: 3,
    text: $i18n.n_coindetail_history_out,
    textColor: "@color/kColorSecondaryText",
    bgColor: "@color/KBaseColorContentBackground",
    groupType: FinanceGroupType.SPOT_TRANSFER_OUT
}, {
    type: "tab",
    index: 4,
    text: $i18n.n_coindetail_history_other,
    textColor: "@color/kColorSecondaryText",
    bgColor: "@color/KBaseColorContentBackground",
    groupType: FinanceGroupType.SPOT_SYSTEM
}, {
    type: "tab",
    index: 5,
    text: $i18n.n_coindetail_history_point,
    textColor: "@color/kColorSecondaryText",
    bgColor: "@color/KBaseColorContentBackground",
    groupType: FinanceGroupType.SPOT_POINT
} ];

const sliderData = [ {
    listType: "sliderCell",
    cellData: [],
    sliderId: 0,
    fromId: 0,
    needMore: false,
    tableHeight: 280
}, {
    listType: "sliderCell",
    cellData: [],
    sliderId: 1,
    fromId: 0,
    needMore: false,
    tableHeight: 280
}, {
    listType: "sliderCell",
    cellData: [],
    sliderId: 2,
    fromId: 0,
    needMore: false,
    tableHeight: 280
}, {
    listType: "sliderCell",
    cellData: [],
    sliderId: 3,
    fromId: 0,
    needMore: false,
    tableHeight: 280
}, {
    listType: "sliderCell",
    cellData: [],
    sliderId: 4,
    fromId: 0,
    needMore: false,
    tableHeight: 280
}, {
    listType: "sliderCell",
    cellData: [],
    sliderId: 5,
    fromId: 0,
    needMore: false,
    tableHeight: 280
} ];

function defaultData() {
    return {
        coinLogo: "",
        displayName: "",
        currencyCode: "",
        gridData: originGridData,
        coinContents: [],
        earnText: "",
        historyList: [],
        refreshStatus: 0,
        loadMoreStatus: 0,
        historyTitleKLinePrice: "",
        historyTitlePrice: "",
        popShow: false,
        popTitle: "",
        popStyle1: "gone",
        popStyle2: "gone",
        recordTabIndex: 0,
        historyTypes: historyTypes,
        sliderData: sliderData,
        launchPoolVisib: "gone"
    };
}

const {moduleData: moduleData, moduleEvent: moduleEvent} = moduleDefine("coindetail", defaultData, {
    onCreate: onCreate,
    onDestroy: onDestroy
});

function onDestroy() {}

function onCreate(jsonParameters) {
    types = "withdraw";
    todayProfitRate = "0";
    moduleData.recordTabIndex = 0;
    moduleData.gridData = originGridData;
    moduleData.coinContents = [];
    moduleData.historyList = [];
    moduleData.historyTypes = historyTypes;
    moduleData.sliderData = sliderData;
    let parameter = JSON.parse(jsonParameters);
    console.log(`onCreate -----\x3e  ${JSON.stringify(parameter)}`);
    if (parameter.stable && parameter.stable != null) {
        parameter.stable;
    }
    var startDate = new Date;
    startDate.setHours(0, 0, 0, 0);
    startDate.setDate(startDate.getDate() - 179);
    reqStartDate = startDate.getTime();
    var endDate = new Date;
    endDate.setHours(23, 59, 59, 0);
    reqEndDate = endDate.getTime();
    console.log(startDate.getTime(), endDate.getTime());
    initCurrencySymbol();
    requestContentInfoV2(parameter["currency"]);
    moduleData.recordTabIndex = 0;
    requestFinanceHistory(0);
    lastTabIndex = 0;
}

async function initCurrencySymbol() {
    currencySymbol = await getLegalCurrencySymbol();
    currencyName = await $nativeAPI.currencyCommon('{"type":4}');
    moduleData.historyTitleKLinePrice = $i18n.$intercept.n_asset_coindetail_kline_price(currencyName);
    moduleData.historyTitlePrice = $i18n.$intercept.n_asset_coindetail_price(currencyName);
}

function validString(string, defaultString = "") {
    if (string && string != null) {
        return string;
    }
    return defaultString;
}

function handleTotalBalanceRich(total, market) {
    var textColor = "#000000";
    var highlightColor = "#8A8A8E";
    if (commonData.colorMode == 1) {
        textColor = "#E6E6E6";
        highlightColor = "#5E5E61";
    }
    return `<span style="color:${textColor}; font-size:26px;">${total}</span><span style="color:${highlightColor}; font-size:14px;"> ≈ ${market}</span>`;
}

async function getRealPrice(currencySymbol, usdtPrice, priceScale) {
    if (currencySymbol == "₮") {
        priceScale = 2;
    }
    let result = await convertLegalTender("usdt", `${usdtPrice}`, priceScale);
    if (`฿` == currencySymbol && usdtPrice != 0 && result == 0) {
        result = `<0.00000001`;
    }
    return addCurrencySymbol(currencySymbol, result);
}

async function requestContentInfoV2(currency = "usdt") {
    showLoading(true);
    currency = currency.toLowerCase();
    requestCurrency = currency;
    const resData = await sendRequest("v1/open/profit/content/info/v2", {
        currency: currency
    });
    if (!resData || resData == null) {
        showLoading(false);
        moduleData.refreshStatus = 2;
        moduleData.loadMoreStatus = 2;
        return;
    }
    const priceScale = parseInt(validString(resData.marketPriceScale, "2"));
    const currencyAmountShowScale = parseInt(validString(resData.currencyAmountShowScale, "2"));
    moduleData.coinLogo = getPNGIconURLByCurrency(moduleData.currencyCode);
    moduleData.displayName = validString(resData.displayName, currency.toUpperCase());
    moduleData.currencyCode = validString(resData.currencyCode, currency);
    const marketValue = await getRealPrice(currencySymbol, validString(resData.marketValue, "0"), 0);
    const totalBalance = await formatByMinPrecision(validString(resData.totalBalance, "0"), currencyAmountShowScale);
    moduleData.totalBalance = handleTotalBalanceRich(totalBalance, marketValue);
    earnJumpUrl = validString(resData.earnJumpUrl, "");
    var tmpGridData = originGridData;
    tmpGridData[0].value = await formatByMinPrecision(validString(resData.availableNum, "0"), currencyAmountShowScale);
    tmpGridData[1].value = await formatByMinPrecision(add(validString(resData.suspenseNum, "0"), validString(resData.lockNum, "0")), currencyAmountShowScale);
    moduleData.suspenseNum = await formatByMinPrecision(validString(resData.suspenseNum, "0"), currencyAmountShowScale);
    moduleData.lockNum = await formatByMinPrecision(validString(resData.lockNum, "0"), currencyAmountShowScale);
    tmpGridData[2].value = await getRealPrice(currencySymbol, validString(resData.marketPrice, "0"), priceScale);
    tmpGridData[3].value = await getRealPrice(currencySymbol, validString(resData.avgPositionCost, "0"), priceScale);
    if (resData.zeroState == 3) {
        tmpGridData[4].value = "--";
    } else {
        tmpGridData[4].value = await getRealPrice(currencySymbol, validString(resData.todayProfit, "0"), "2");
    }
    todayProfitRate = validString(resData.todayProfitRate, "0");
    tmpGridData[4].valueRate = format(todayProfitRate * 100, 2) + "%";
    tmpGridData[4].rateColor = getPriceColor(todayProfitRate >= 0);
    if (todayProfitRate == 0) {
        tmpGridData[4].rateColor = "@color/kColorSecondaryText";
    }
    tmpGridData[5].value = await getRealPrice(currencySymbol, validString(resData.profit, "0"), "2");
    const profitRate = validString(resData.profitRate, "0");
    tmpGridData[5].valueRate = format(profitRate * 100, 2) + "%";
    tmpGridData[5].rateColor = getPriceColor(profitRate >= 0);
    if (profitRate == 0) {
        tmpGridData[5].rateColor = "@color/kColorSecondaryText";
    }
    if (resData.avgCostState && resData.avgCostState == 1) {
        moduleData.gridData = tmpGridData;
    } else {
        var emptyGrid = {
            cellType: "1",
            rateShow: "gone",
            lineShow: "gone",
            height: "54",
            name: "",
            value: "",
            popType: 0
        };
        var newGridData = [];
        newGridData.push(tmpGridData[0]);
        newGridData.push(tmpGridData[1]);
        newGridData.push(tmpGridData[4]);
        newGridData.push(tmpGridData[5]);
        newGridData.push(tmpGridData[2]);
        newGridData.push(emptyGrid);
        moduleData.gridData = newGridData;
    }
    console.log(`moduleData.gridData : ${JSON.stringify(moduleData.gridData.rawArray())}`);
    var coinContents = resData.coinContents && resData.coinContents != null ? resData.coinContents : [];
    for (let index = 0; index < coinContents.length; index++) {
        const element = coinContents[index];
        element.cellType = "1";
        element.name = element.currency.toUpperCase();
        element.label = $i18n.n_asset_coindetail_coin;
        element.text = await getRealPrice(currencySymbol, validString(element.marketPrice, "0"), priceScale);
        const todayIncrease = validString(element.todayIncrease, "0");
        element.labelText = format(todayIncrease * 100, 2) + "%";
        element.textColor = "@color/kColorPrimaryText";
        element.labelTextColor = getPriceColor(todayIncrease >= 0);
        if (todayIncrease == 0) {
            element.labelTextColor = "@color/kColorSecondaryText";
        }
        element.jumpUrl = "JumpTypeNative";
        element.recomBaseInfo = validString(element.recomBaseInfo, "");
        analytics("app_spotdetailpage_trade_show", {
            symbol: element.currency,
            recom_base_info: element.recomBaseInfo
        });
    }
    const tradingBotContents = resData.tradingBotContents;
    if (tradingBotContents && tradingBotContents != null && tradingBotContents.length > 0) {
        const element = tradingBotContents[0];
        element.cellType = "1";
        element.name = element.currency.toUpperCase();
        element.label = $i18n.n_trade_bot;
        const projectRate = validString(element.projectRate, "0");
        element.text = format(projectRate * 100, 2) + "%";
        element.labelText = validString(element.apyTranslate, "");
        element.textColor = getPriceColor(projectRate >= 0);
        element.labelTextColor = "@color/kColorThreeLevelText";
        if (coinContents.length > 0) {
            coinContents.splice(1, 0, element);
        } else {
            coinContents.push(element);
        }
        element.recomBaseInfo = validString(element.recomBaseInfo, "");
        analytics("app_spotdetailpage_trade_show", {
            symbol: element.currency,
            recom_base_info: element.recomBaseInfo
        });
    }
    moduleData.coinContents = coinContents;
    moduleData.tradeCardShow = coinContents.length > 0 ? "visible" : "gone";
    const financeContents = resData.financeContents;
    if (financeContents && financeContents.length > 0) {
        const finance = financeContents[0];
        earnItemUrl = validString(finance.jumpUrl);
        const finance_apy = validString(finance.apy, "0");
        const finance_apy_text = format(finance_apy * 100, 0) + "%";
        var textColor = "#000000";
        if (commonData.colorMode == 1) {
            textColor = "#E6E6E6";
        }
        const earnText = $i18n.$intercept.n_asset_coindetail_earn_content(finance.currencyDisplayName, finance_apy_text);
        const spanStart = `<span style="color:${textColor}; font-size:14px;">`;
        const spanEnd = "</span>";
        var richHighlight = `${spanEnd}<span style="color:${textColor}; font-size:18px;"> ${finance_apy_text} </span>${spanStart}`;
        const joinText = earnText.split(finance_apy_text).join(richHighlight);
        moduleData.earnText = `${spanStart}${joinText}${spanEnd}`;
        console.log(`moduleData.earnText  : ${moduleData.earnText}`);
        moduleData.launchPoolVisib = finance.tag == 9 ? "visible" : "gone";
        if (!earnItemUrl || earnItemUrl.length === 0) {
            moduleData.earnCardShow = "gone";
        } else {
            moduleData.earnCardShow = "visible";
        }
    } else {
        moduleData.earnCardShow = "gone";
    }
}

async function requestFinanceHistory(idx = 0, isLoadMore = false) {
    if (requestCurrency.length == 0) {
        return;
    }
    const sliderCellData = sliderData[idx];
    const size = 21;
    var params = {
        size: size,
        direct: "next",
        currency: requestCurrency
    };
    if (types != null) {
        params["types"] = types;
    }
    if (isLoadMore && sliderCellData.fromId > 0) {
        params["from"] = sliderCellData.fromId;
    }
    if (reqStartDate != null) {
        params["start-time"] = reqStartDate;
    }
    if (reqEndDate != null) {
        params["end-time"] = reqEndDate;
    }
    const resData = await sendRequest("v1/query/finance-history", params, 0, 4);
    showLoading(false);
    moduleData.refreshStatus = 2;
    moduleData.loadMoreStatus = 2;
    moduleData.historyLoadMoreStatus = 2;
    console.log(resData);
    if (!resData || resData == null) {
        return;
    }
    if (resData.length == 0) {
        if (isLoadMore == false) {
            sliderData[idx].cellData = [ {
                cellType: "empty"
            } ];
            sliderData[idx].tableHeight = 280;
            moduleData.sliderData[idx].cellData = [ {
                cellType: "empty"
            } ];
            moduleData.sliderData[idx].tableHeight = 280;
        }
        sliderCellData.needMore = false;
        return;
    }
    const lastData = resData[resData.length - 1];
    sliderCellData.fromId = lastData.id;
    sliderCellData.needMore = false;
    if (resData.length == size) {
        sliderCellData.needMore = true;
        resData.pop();
    }
    var newHistorys = [];
    var cellHeight = 86.5;
    for (let index = 0; index < resData.length; index++) {
        const element = resData[index];
        var financeType = getSpotFinanceTypeWithGroup(element["group-type"]);
        if (financeType == FinanceGroupType.SPOT_DEPOSIT || financeType == FinanceGroupType.SPOT_WITHDRAW) {
            cellHeight = 112.5;
            element.cellType = "type1";
            element.displayState = getSpotFinanceState(element["state"], financeType);
            element.displayFee = `${validString(element.fees, "0")} ${validString(element["currency-display-name"], moduleData.displayName)}`;
        } else {
            element.cellType = "type2";
            element.displayDetail = getSpotDisplayStatusDetail(element.type, element.direction, element.desc, element.extra);
        }
        element.displayTitle = getSpotDisplayType(financeType);
        element.displayAmount = validString(element.amount, "0");
        element.displayTime = `${new Date(element["updated-at"]).Format("yyyy-MM-dd hh:mm:ss")}`;
        newHistorys.push(element);
    }
    if (isLoadMore == false) {
        sliderData[idx].cellData = newHistorys;
        moduleData.sliderData[idx].cellData = newHistorys;
    } else {
        sliderData[idx].cellData = sliderData[idx].cellData.concat(newHistorys);
        moduleData.sliderData[idx].cellData = sliderData[idx].cellData;
    }
    var count = sliderData[idx].cellData.length;
    var tableHeight = count * cellHeight;
    tableHeight = tableHeight > 280 ? tableHeight : 280;
    sliderData[idx].tableHeight = tableHeight;
    moduleData.sliderData[idx].tableHeight = tableHeight;
}

function recordTypeSelected(index) {
    if (lastTabIndex == index) {
        return;
    }
    lastTabIndex = index;
    for (let i = 0; i < moduleData.historyTypes.length; i++) {
        var obj = moduleData.historyTypes[i];
        obj.textColor = "@color/kColorSecondaryText";
        obj.bgColor = "@color/KBaseColorContentBackground";
    }
    var cur = moduleData.historyTypes[index];
    cur.textColor = "@color/kColorPrimaryText";
    cur.bgColor = "@color/KBaseColorInputBackground";
    types = getRequestType(cur.groupType);
    requestFinanceHistory(index);
}

moduleEvent.recordTypeSelected = recordTypeSelected;

function historyLoadMore() {
    const sliderCellData = sliderData[moduleData.recordTabIndex];
    if (sliderCellData.needMore) {
        requestFinanceHistory(moduleData.recordTabIndex, true);
    } else {
        moduleData.loadMoreStatus = 2;
        moduleData.historyLoadMoreStatus = 2;
    }
}

moduleEvent.historyLoadMore = historyLoadMore;

moduleEvent.refresh = function() {
    moduleData.refreshStatus = 1;
    requestContentInfoV2(requestCurrency);
    requestFinanceHistory(moduleData.recordTabIndex);
};

moduleEvent.loadMore = function() {
    historyLoadMore();
};

moduleEvent.backClicked = function() {
    containerBack();
};

moduleEvent.jumpIntro = function() {
    openPageWithPath(`/asset-introduction/details/h5/?currency=${moduleData.currencyCode}`);
};

moduleEvent.openShare = function() {
    var params = {
        type: 11,
        currency: requestCurrency,
        todayProfitRate: todayProfitRate
    };
    $nativeAPI.jump(JSON.stringify(params));
};

moduleEvent.tradeClicked = function() {
    if (commonData.OS == 1) {
        var params = {
            type: 162,
            currency: requestCurrency
        };
        $nativeAPI.jump(JSON.stringify(params));
    } else {
        openPageWithPath(`holigeit://open/v1?url=ihuobiglobal://m.hbg.com/market/newSearch?searchKey=${requestCurrency}`);
    }
};

moduleEvent.tradeItemClicked = function(jumpUrl, currency, recom_base_info) {
    const symbol = currency;
    if (jumpUrl == "JumpTypeNative") {
        currency = currency.replace("|", "");
        currency = currency.replace("/", "");
        currency = currency.toLowerCase();
        var params = {
            type: 159,
            currency: currency
        };
        $nativeAPI.jump(JSON.stringify(params));
    } else {
        openPageWithPath(jumpUrl);
    }
    analytics("app_spotdetailpage_trade_click", {
        symbol: symbol,
        recom_base_info: recom_base_info
    });
};

moduleEvent.depositClicked = function() {
    var params = {
        type: 160,
        currency: requestCurrency
    };
    $nativeAPI.jump(JSON.stringify(params));
};

moduleEvent.withdrawClicked = function() {
    var params = {
        type: 161,
        currency: requestCurrency
    };
    $nativeAPI.jump(JSON.stringify(params));
};

moduleEvent.transferClicked = function() {
    var params = {
        type: 20,
        currency: requestCurrency
    };
    $nativeAPI.jump(JSON.stringify(params));
};

moduleEvent.earnClicked = function() {
    openPageWithPath(earnJumpUrl);
};

moduleEvent.earnItemClicked = function() {
    earnItemUrl = earnItemUrl.replace("fromType=1", "fromType=2");
    openPageWithPath(earnItemUrl);
};

moduleEvent.historyClicked = function() {};

moduleEvent.popShow = function(popType) {
    moduleData.popStyle1 = "gone";
    moduleData.popStyle2 = "gone";
    if (popType > 0) {
        if (popType == 1) {
            moduleData.popTitle = $i18n.n_asset_coindetail_locked;
            moduleData.popStyle1 = "visible";
        } else if (popType == 2) {
            moduleData.popTitle = $i18n.n_asset_coindetail_cost_price;
            moduleData.popContent = `${$i18n.n_asset_coindetail_cost_price_tips_1}\n${$i18n.n_asset_coindetail_cost_price_tips_2}\n\n${$i18n.n_asset_coindetail_cost_price_tips_3}\n${$i18n.n_asset_coindetail_cost_price_tips_4}`;
            moduleData.popStyle2 = "visible";
        } else if (popType == 3) {
            moduleData.popTitle = $i18n.n_today_profit;
            moduleData.popContent = `${$i18n.n_asset_coindetail_today_pnl_tips_1}\n${$i18n.n_asset_coindetail_today_pnl_tips_2}\n${$i18n.n_asset_coindetail_today_pnl_tips_3}`;
            moduleData.popStyle2 = "visible";
        } else if (popType == 4) {
            moduleData.popTitle = $i18n.n_asset_coindetail_total_pnl;
            moduleData.popContent = `${$i18n.n_asset_coindetail_total_pnl_tips_1}\n${$i18n.n_asset_coindetail_total_pnl_tips_2}`;
            moduleData.popStyle2 = "visible";
        } else if (popType == 5) {
            moduleData.popTitle = moduleData.historyTitleKLinePrice;
            moduleData.popContent = $i18n.n_asset_coindetail_history_tips_1;
            moduleData.popStyle2 = "visible";
        } else if (popType == 6) {
            moduleData.popTitle = moduleData.historyTitlePrice;
            moduleData.popContent = $i18n.n_asset_coindetail_history_tips_2;
            moduleData.popStyle2 = "visible";
        }
        moduleData.popShow = true;
    }
};

moduleEvent.popClose = function() {
    moduleData.popShow = false;
};

moduleEvent.historyTypeClicked = function(idx) {
    moduleData.recordTabIndex = `${idx}`;
};

function sendCommonConfig(param) {
    getCommonConfig(param);
}

$event.sendCommonConfig = sendCommonConfig;
//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoibWFpbi5qcyIsInNvdXJjZXMiOlsiLi4vLi4vcmVwb3NpdG9yeS9ub2RlX21vZHVsZXMvYmlnLmpzL2JpZy5tanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9udW1iZXIuanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9jb21tb24uanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9zdHJ1Y3R1cmVkLmpzIiwiLi4vLi4vcmVwb3NpdG9yeS9zcmMvaW50cm9kdWNlLmpzIiwiLi4vLi4vcmVwb3NpdG9yeS9zcmMvaG9tZS5qcyIsIi4uLy4uL3JlcG9zaXRvcnkvc3JjL3NlYXJjaGNvaW4uanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9maW5hbmNlaGlzdG9yeS5qcyIsIi4uLy4uL3JlcG9zaXRvcnkvc3JjL2NvaW5kZXRhaWwuanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9tYWluLmpzIl0sInNvdXJjZXNDb250ZW50IjpbIi8qXHJcbiAqICBiaWcuanMgdjUuMi4yXHJcbiAqICBBIHNtYWxsLCBmYXN0LCBlYXN5LXRvLXVzZSBsaWJyYXJ5IGZvciBhcmJpdHJhcnktcHJlY2lzaW9uIGRlY2ltYWwgYXJpdGhtZXRpYy5cclxuICogIENvcHlyaWdodCAoYykgMjAxOCBNaWNoYWVsIE1jbGF1Z2hsaW4gPE04Y2g4OGxAZ21haWwuY29tPlxyXG4gKiAgaHR0cHM6Ly9naXRodWIuY29tL01pa2VNY2wvYmlnLmpzL0xJQ0VOQ0VcclxuICovXHJcblxyXG5cclxuLyoqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqIEVESVRBQkxFIERFRkFVTFRTICoqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqL1xyXG5cclxuXHJcbiAgLy8gVGhlIGRlZmF1bHQgdmFsdWVzIGJlbG93IG11c3QgYmUgaW50ZWdlcnMgd2l0aGluIHRoZSBzdGF0ZWQgcmFuZ2VzLlxyXG5cclxuICAvKlxyXG4gICAqIFRoZSBtYXhpbXVtIG51bWJlciBvZiBkZWNpbWFsIHBsYWNlcyAoRFApIG9mIHRoZSByZXN1bHRzIG9mIG9wZXJhdGlvbnMgaW52b2x2aW5nIGRpdmlzaW9uOlxyXG4gICAqIGRpdiBhbmQgc3FydCwgYW5kIHBvdyB3aXRoIG5lZ2F0aXZlIGV4cG9uZW50cy5cclxuICAgKi9cclxudmFyIERQID0gMjAsICAgICAgICAgIC8vIDAgdG8gTUFYX0RQXHJcblxyXG4gIC8qXHJcbiAgICogVGhlIHJvdW5kaW5nIG1vZGUgKFJNKSB1c2VkIHdoZW4gcm91bmRpbmcgdG8gdGhlIGFib3ZlIGRlY2ltYWwgcGxhY2VzLlxyXG4gICAqXHJcbiAgICogIDAgIFRvd2FyZHMgemVybyAoaS5lLiB0cnVuY2F0ZSwgbm8gcm91bmRpbmcpLiAgICAgICAoUk9VTkRfRE9XTilcclxuICAgKiAgMSAgVG8gbmVhcmVzdCBuZWlnaGJvdXIuIElmIGVxdWlkaXN0YW50LCByb3VuZCB1cC4gIChST1VORF9IQUxGX1VQKVxyXG4gICAqICAyICBUbyBuZWFyZXN0IG5laWdoYm91ci4gSWYgZXF1aWRpc3RhbnQsIHRvIGV2ZW4uICAgKFJPVU5EX0hBTEZfRVZFTilcclxuICAgKiAgMyAgQXdheSBmcm9tIHplcm8uICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIChST1VORF9VUClcclxuICAgKi9cclxuICBSTSA9IDEsICAgICAgICAgICAgIC8vIDAsIDEsIDIgb3IgM1xyXG5cclxuICAvLyBUaGUgbWF4aW11bSB2YWx1ZSBvZiBEUCBhbmQgQmlnLkRQLlxyXG4gIE1BWF9EUCA9IDFFNiwgICAgICAgLy8gMCB0byAxMDAwMDAwXHJcblxyXG4gIC8vIFRoZSBtYXhpbXVtIG1hZ25pdHVkZSBvZiB0aGUgZXhwb25lbnQgYXJndW1lbnQgdG8gdGhlIHBvdyBtZXRob2QuXHJcbiAgTUFYX1BPV0VSID0gMUU2LCAgICAvLyAxIHRvIDEwMDAwMDBcclxuXHJcbiAgLypcclxuICAgKiBUaGUgbmVnYXRpdmUgZXhwb25lbnQgKE5FKSBhdCBhbmQgYmVuZWF0aCB3aGljaCB0b1N0cmluZyByZXR1cm5zIGV4cG9uZW50aWFsIG5vdGF0aW9uLlxyXG4gICAqIChKYXZhU2NyaXB0IG51bWJlcnM6IC03KVxyXG4gICAqIC0xMDAwMDAwIGlzIHRoZSBtaW5pbXVtIHJlY29tbWVuZGVkIGV4cG9uZW50IHZhbHVlIG9mIGEgQmlnLlxyXG4gICAqL1xyXG4gIE5FID0gLTcsICAgICAgICAgICAgLy8gMCB0byAtMTAwMDAwMFxyXG5cclxuICAvKlxyXG4gICAqIFRoZSBwb3NpdGl2ZSBleHBvbmVudCAoUEUpIGF0IGFuZCBhYm92ZSB3aGljaCB0b1N0cmluZyByZXR1cm5zIGV4cG9uZW50aWFsIG5vdGF0aW9uLlxyXG4gICAqIChKYXZhU2NyaXB0IG51bWJlcnM6IDIxKVxyXG4gICAqIDEwMDAwMDAgaXMgdGhlIG1heGltdW0gcmVjb21tZW5kZWQgZXhwb25lbnQgdmFsdWUgb2YgYSBCaWcuXHJcbiAgICogKFRoaXMgbGltaXQgaXMgbm90IGVuZm9yY2VkIG9yIGNoZWNrZWQuKVxyXG4gICAqL1xyXG4gIFBFID0gMjEsICAgICAgICAgICAgLy8gMCB0byAxMDAwMDAwXHJcblxyXG5cclxuLyoqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqL1xyXG5cclxuXHJcbiAgLy8gRXJyb3IgbWVzc2FnZXMuXHJcbiAgTkFNRSA9ICdbYmlnLmpzXSAnLFxyXG4gIElOVkFMSUQgPSBOQU1FICsgJ0ludmFsaWQgJyxcclxuICBJTlZBTElEX0RQID0gSU5WQUxJRCArICdkZWNpbWFsIHBsYWNlcycsXHJcbiAgSU5WQUxJRF9STSA9IElOVkFMSUQgKyAncm91bmRpbmcgbW9kZScsXHJcbiAgRElWX0JZX1pFUk8gPSBOQU1FICsgJ0RpdmlzaW9uIGJ5IHplcm8nLFxyXG5cclxuICAvLyBUaGUgc2hhcmVkIHByb3RvdHlwZSBvYmplY3QuXHJcbiAgUCA9IHt9LFxyXG4gIFVOREVGSU5FRCA9IHZvaWQgMCxcclxuICBOVU1FUklDID0gL14tPyhcXGQrKFxcLlxcZCopP3xcXC5cXGQrKShlWystXT9cXGQrKT8kL2k7XHJcblxyXG5cclxuLypcclxuICogQ3JlYXRlIGFuZCByZXR1cm4gYSBCaWcgY29uc3RydWN0b3IuXHJcbiAqXHJcbiAqL1xyXG5mdW5jdGlvbiBfQmlnXygpIHtcclxuXHJcbiAgLypcclxuICAgKiBUaGUgQmlnIGNvbnN0cnVjdG9yIGFuZCBleHBvcnRlZCBmdW5jdGlvbi5cclxuICAgKiBDcmVhdGUgYW5kIHJldHVybiBhIG5ldyBpbnN0YW5jZSBvZiBhIEJpZyBudW1iZXIgb2JqZWN0LlxyXG4gICAqXHJcbiAgICogbiB7bnVtYmVyfHN0cmluZ3xCaWd9IEEgbnVtZXJpYyB2YWx1ZS5cclxuICAgKi9cclxuICBmdW5jdGlvbiBCaWcobikge1xyXG4gICAgdmFyIHggPSB0aGlzO1xyXG5cclxuICAgIC8vIEVuYWJsZSBjb25zdHJ1Y3RvciB1c2FnZSB3aXRob3V0IG5ldy5cclxuICAgIGlmICghKHggaW5zdGFuY2VvZiBCaWcpKSByZXR1cm4gbiA9PT0gVU5ERUZJTkVEID8gX0JpZ18oKSA6IG5ldyBCaWcobik7XHJcblxyXG4gICAgLy8gRHVwbGljYXRlLlxyXG4gICAgaWYgKG4gaW5zdGFuY2VvZiBCaWcpIHtcclxuICAgICAgeC5zID0gbi5zO1xyXG4gICAgICB4LmUgPSBuLmU7XHJcbiAgICAgIHguYyA9IG4uYy5zbGljZSgpO1xyXG4gICAgfSBlbHNlIHtcclxuICAgICAgcGFyc2UoeCwgbik7XHJcbiAgICB9XHJcblxyXG4gICAgLypcclxuICAgICAqIFJldGFpbiBhIHJlZmVyZW5jZSB0byB0aGlzIEJpZyBjb25zdHJ1Y3RvciwgYW5kIHNoYWRvdyBCaWcucHJvdG90eXBlLmNvbnN0cnVjdG9yIHdoaWNoXHJcbiAgICAgKiBwb2ludHMgdG8gT2JqZWN0LlxyXG4gICAgICovXHJcbiAgICB4LmNvbnN0cnVjdG9yID0gQmlnO1xyXG4gIH1cclxuXHJcbiAgQmlnLnByb3RvdHlwZSA9IFA7XHJcbiAgQmlnLkRQID0gRFA7XHJcbiAgQmlnLlJNID0gUk07XHJcbiAgQmlnLk5FID0gTkU7XHJcbiAgQmlnLlBFID0gUEU7XHJcbiAgQmlnLnZlcnNpb24gPSAnNS4yLjInO1xyXG5cclxuICByZXR1cm4gQmlnO1xyXG59XHJcblxyXG5cclxuLypcclxuICogUGFyc2UgdGhlIG51bWJlciBvciBzdHJpbmcgdmFsdWUgcGFzc2VkIHRvIGEgQmlnIGNvbnN0cnVjdG9yLlxyXG4gKlxyXG4gKiB4IHtCaWd9IEEgQmlnIG51bWJlciBpbnN0YW5jZS5cclxuICogbiB7bnVtYmVyfHN0cmluZ30gQSBudW1lcmljIHZhbHVlLlxyXG4gKi9cclxuZnVuY3Rpb24gcGFyc2UoeCwgbikge1xyXG4gIHZhciBlLCBpLCBubDtcclxuXHJcbiAgLy8gTWludXMgemVybz9cclxuICBpZiAobiA9PT0gMCAmJiAxIC8gbiA8IDApIG4gPSAnLTAnO1xyXG4gIGVsc2UgaWYgKCFOVU1FUklDLnRlc3QobiArPSAnJykpIHRocm93IEVycm9yKElOVkFMSUQgKyAnbnVtYmVyJyk7XHJcblxyXG4gIC8vIERldGVybWluZSBzaWduLlxyXG4gIHgucyA9IG4uY2hhckF0KDApID09ICctJyA/IChuID0gbi5zbGljZSgxKSwgLTEpIDogMTtcclxuXHJcbiAgLy8gRGVjaW1hbCBwb2ludD9cclxuICBpZiAoKGUgPSBuLmluZGV4T2YoJy4nKSkgPiAtMSkgbiA9IG4ucmVwbGFjZSgnLicsICcnKTtcclxuXHJcbiAgLy8gRXhwb25lbnRpYWwgZm9ybT9cclxuICBpZiAoKGkgPSBuLnNlYXJjaCgvZS9pKSkgPiAwKSB7XHJcblxyXG4gICAgLy8gRGV0ZXJtaW5lIGV4cG9uZW50LlxyXG4gICAgaWYgKGUgPCAwKSBlID0gaTtcclxuICAgIGUgKz0gK24uc2xpY2UoaSArIDEpO1xyXG4gICAgbiA9IG4uc3Vic3RyaW5nKDAsIGkpO1xyXG4gIH0gZWxzZSBpZiAoZSA8IDApIHtcclxuXHJcbiAgICAvLyBJbnRlZ2VyLlxyXG4gICAgZSA9IG4ubGVuZ3RoO1xyXG4gIH1cclxuXHJcbiAgbmwgPSBuLmxlbmd0aDtcclxuXHJcbiAgLy8gRGV0ZXJtaW5lIGxlYWRpbmcgemVyb3MuXHJcbiAgZm9yIChpID0gMDsgaSA8IG5sICYmIG4uY2hhckF0KGkpID09ICcwJzspICsraTtcclxuXHJcbiAgaWYgKGkgPT0gbmwpIHtcclxuXHJcbiAgICAvLyBaZXJvLlxyXG4gICAgeC5jID0gW3guZSA9IDBdO1xyXG4gIH0gZWxzZSB7XHJcblxyXG4gICAgLy8gRGV0ZXJtaW5lIHRyYWlsaW5nIHplcm9zLlxyXG4gICAgZm9yICg7IG5sID4gMCAmJiBuLmNoYXJBdCgtLW5sKSA9PSAnMCc7KTtcclxuICAgIHguZSA9IGUgLSBpIC0gMTtcclxuICAgIHguYyA9IFtdO1xyXG5cclxuICAgIC8vIENvbnZlcnQgc3RyaW5nIHRvIGFycmF5IG9mIGRpZ2l0cyB3aXRob3V0IGxlYWRpbmcvdHJhaWxpbmcgemVyb3MuXHJcbiAgICBmb3IgKGUgPSAwOyBpIDw9IG5sOykgeC5jW2UrK10gPSArbi5jaGFyQXQoaSsrKTtcclxuICB9XHJcblxyXG4gIHJldHVybiB4O1xyXG59XHJcblxyXG5cclxuLypcclxuICogUm91bmQgQmlnIHggdG8gYSBtYXhpbXVtIG9mIGRwIGRlY2ltYWwgcGxhY2VzIHVzaW5nIHJvdW5kaW5nIG1vZGUgcm0uXHJcbiAqIENhbGxlZCBieSBzdHJpbmdpZnksIFAuZGl2LCBQLnJvdW5kIGFuZCBQLnNxcnQuXHJcbiAqXHJcbiAqIHgge0JpZ30gVGhlIEJpZyB0byByb3VuZC5cclxuICogZHAge251bWJlcn0gSW50ZWdlciwgMCB0byBNQVhfRFAgaW5jbHVzaXZlLlxyXG4gKiBybSB7bnVtYmVyfSAwLCAxLCAyIG9yIDMgKERPV04sIEhBTEZfVVAsIEhBTEZfRVZFTiwgVVApXHJcbiAqIFttb3JlXSB7Ym9vbGVhbn0gV2hldGhlciB0aGUgcmVzdWx0IG9mIGRpdmlzaW9uIHdhcyB0cnVuY2F0ZWQuXHJcbiAqL1xyXG5mdW5jdGlvbiByb3VuZCh4LCBkcCwgcm0sIG1vcmUpIHtcclxuICB2YXIgeGMgPSB4LmMsXHJcbiAgICBpID0geC5lICsgZHAgKyAxO1xyXG5cclxuICBpZiAoaSA8IHhjLmxlbmd0aCkge1xyXG4gICAgaWYgKHJtID09PSAxKSB7XHJcblxyXG4gICAgICAvLyB4Y1tpXSBpcyB0aGUgZGlnaXQgYWZ0ZXIgdGhlIGRpZ2l0IHRoYXQgbWF5IGJlIHJvdW5kZWQgdXAuXHJcbiAgICAgIG1vcmUgPSB4Y1tpXSA+PSA1O1xyXG4gICAgfSBlbHNlIGlmIChybSA9PT0gMikge1xyXG4gICAgICBtb3JlID0geGNbaV0gPiA1IHx8IHhjW2ldID09IDUgJiZcclxuICAgICAgICAobW9yZSB8fCBpIDwgMCB8fCB4Y1tpICsgMV0gIT09IFVOREVGSU5FRCB8fCB4Y1tpIC0gMV0gJiAxKTtcclxuICAgIH0gZWxzZSBpZiAocm0gPT09IDMpIHtcclxuICAgICAgbW9yZSA9IG1vcmUgfHwgISF4Y1swXTtcclxuICAgIH0gZWxzZSB7XHJcbiAgICAgIG1vcmUgPSBmYWxzZTtcclxuICAgICAgaWYgKHJtICE9PSAwKSB0aHJvdyBFcnJvcihJTlZBTElEX1JNKTtcclxuICAgIH1cclxuXHJcbiAgICBpZiAoaSA8IDEpIHtcclxuICAgICAgeGMubGVuZ3RoID0gMTtcclxuXHJcbiAgICAgIGlmIChtb3JlKSB7XHJcblxyXG4gICAgICAgIC8vIDEsIDAuMSwgMC4wMSwgMC4wMDEsIDAuMDAwMSBldGMuXHJcbiAgICAgICAgeC5lID0gLWRwO1xyXG4gICAgICAgIHhjWzBdID0gMTtcclxuICAgICAgfSBlbHNlIHtcclxuXHJcbiAgICAgICAgLy8gWmVyby5cclxuICAgICAgICB4Y1swXSA9IHguZSA9IDA7XHJcbiAgICAgIH1cclxuICAgIH0gZWxzZSB7XHJcblxyXG4gICAgICAvLyBSZW1vdmUgYW55IGRpZ2l0cyBhZnRlciB0aGUgcmVxdWlyZWQgZGVjaW1hbCBwbGFjZXMuXHJcbiAgICAgIHhjLmxlbmd0aCA9IGktLTtcclxuXHJcbiAgICAgIC8vIFJvdW5kIHVwP1xyXG4gICAgICBpZiAobW9yZSkge1xyXG5cclxuICAgICAgICAvLyBSb3VuZGluZyB1cCBtYXkgbWVhbiB0aGUgcHJldmlvdXMgZGlnaXQgaGFzIHRvIGJlIHJvdW5kZWQgdXAuXHJcbiAgICAgICAgZm9yICg7ICsreGNbaV0gPiA5Oykge1xyXG4gICAgICAgICAgeGNbaV0gPSAwO1xyXG4gICAgICAgICAgaWYgKCFpLS0pIHtcclxuICAgICAgICAgICAgKyt4LmU7XHJcbiAgICAgICAgICAgIHhjLnVuc2hpZnQoMSk7XHJcbiAgICAgICAgICB9XHJcbiAgICAgICAgfVxyXG4gICAgICB9XHJcblxyXG4gICAgICAvLyBSZW1vdmUgdHJhaWxpbmcgemVyb3MuXHJcbiAgICAgIGZvciAoaSA9IHhjLmxlbmd0aDsgIXhjWy0taV07KSB4Yy5wb3AoKTtcclxuICAgIH1cclxuICB9IGVsc2UgaWYgKHJtIDwgMCB8fCBybSA+IDMgfHwgcm0gIT09IH5+cm0pIHtcclxuICAgIHRocm93IEVycm9yKElOVkFMSURfUk0pO1xyXG4gIH1cclxuXHJcbiAgcmV0dXJuIHg7XHJcbn1cclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBzdHJpbmcgcmVwcmVzZW50aW5nIHRoZSB2YWx1ZSBvZiBCaWcgeCBpbiBub3JtYWwgb3IgZXhwb25lbnRpYWwgbm90YXRpb24uXHJcbiAqIEhhbmRsZXMgUC50b0V4cG9uZW50aWFsLCBQLnRvRml4ZWQsIFAudG9KU09OLCBQLnRvUHJlY2lzaW9uLCBQLnRvU3RyaW5nIGFuZCBQLnZhbHVlT2YuXHJcbiAqXHJcbiAqIHgge0JpZ31cclxuICogaWQ/IHtudW1iZXJ9IENhbGxlciBpZC5cclxuICogICAgICAgICAxIHRvRXhwb25lbnRpYWxcclxuICogICAgICAgICAyIHRvRml4ZWRcclxuICogICAgICAgICAzIHRvUHJlY2lzaW9uXHJcbiAqICAgICAgICAgNCB2YWx1ZU9mXHJcbiAqIG4/IHtudW1iZXJ8dW5kZWZpbmVkfSBDYWxsZXIncyBhcmd1bWVudC5cclxuICogaz8ge251bWJlcnx1bmRlZmluZWR9XHJcbiAqL1xyXG5mdW5jdGlvbiBzdHJpbmdpZnkoeCwgaWQsIG4sIGspIHtcclxuICB2YXIgZSwgcyxcclxuICAgIEJpZyA9IHguY29uc3RydWN0b3IsXHJcbiAgICB6ID0gIXguY1swXTtcclxuXHJcbiAgaWYgKG4gIT09IFVOREVGSU5FRCkge1xyXG4gICAgaWYgKG4gIT09IH5+biB8fCBuIDwgKGlkID09IDMpIHx8IG4gPiBNQVhfRFApIHtcclxuICAgICAgdGhyb3cgRXJyb3IoaWQgPT0gMyA/IElOVkFMSUQgKyAncHJlY2lzaW9uJyA6IElOVkFMSURfRFApO1xyXG4gICAgfVxyXG5cclxuICAgIHggPSBuZXcgQmlnKHgpO1xyXG5cclxuICAgIC8vIFRoZSBpbmRleCBvZiB0aGUgZGlnaXQgdGhhdCBtYXkgYmUgcm91bmRlZCB1cC5cclxuICAgIG4gPSBrIC0geC5lO1xyXG5cclxuICAgIC8vIFJvdW5kP1xyXG4gICAgaWYgKHguYy5sZW5ndGggPiArK2spIHJvdW5kKHgsIG4sIEJpZy5STSk7XHJcblxyXG4gICAgLy8gdG9GaXhlZDogcmVjYWxjdWxhdGUgayBhcyB4LmUgbWF5IGhhdmUgY2hhbmdlZCBpZiB2YWx1ZSByb3VuZGVkIHVwLlxyXG4gICAgaWYgKGlkID09IDIpIGsgPSB4LmUgKyBuICsgMTtcclxuXHJcbiAgICAvLyBBcHBlbmQgemVyb3M/XHJcbiAgICBmb3IgKDsgeC5jLmxlbmd0aCA8IGs7KSB4LmMucHVzaCgwKTtcclxuICB9XHJcblxyXG4gIGUgPSB4LmU7XHJcbiAgcyA9IHguYy5qb2luKCcnKTtcclxuICBuID0gcy5sZW5ndGg7XHJcblxyXG4gIC8vIEV4cG9uZW50aWFsIG5vdGF0aW9uP1xyXG4gIGlmIChpZCAhPSAyICYmIChpZCA9PSAxIHx8IGlkID09IDMgJiYgayA8PSBlIHx8IGUgPD0gQmlnLk5FIHx8IGUgPj0gQmlnLlBFKSkge1xyXG4gICAgcyA9IHMuY2hhckF0KDApICsgKG4gPiAxID8gJy4nICsgcy5zbGljZSgxKSA6ICcnKSArIChlIDwgMCA/ICdlJyA6ICdlKycpICsgZTtcclxuXHJcbiAgLy8gTm9ybWFsIG5vdGF0aW9uLlxyXG4gIH0gZWxzZSBpZiAoZSA8IDApIHtcclxuICAgIGZvciAoOyArK2U7KSBzID0gJzAnICsgcztcclxuICAgIHMgPSAnMC4nICsgcztcclxuICB9IGVsc2UgaWYgKGUgPiAwKSB7XHJcbiAgICBpZiAoKytlID4gbikgZm9yIChlIC09IG47IGUtLTspIHMgKz0gJzAnO1xyXG4gICAgZWxzZSBpZiAoZSA8IG4pIHMgPSBzLnNsaWNlKDAsIGUpICsgJy4nICsgcy5zbGljZShlKTtcclxuICB9IGVsc2UgaWYgKG4gPiAxKSB7XHJcbiAgICBzID0gcy5jaGFyQXQoMCkgKyAnLicgKyBzLnNsaWNlKDEpO1xyXG4gIH1cclxuXHJcbiAgcmV0dXJuIHgucyA8IDAgJiYgKCF6IHx8IGlkID09IDQpID8gJy0nICsgcyA6IHM7XHJcbn1cclxuXHJcblxyXG4vLyBQcm90b3R5cGUvaW5zdGFuY2UgbWV0aG9kc1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIG5ldyBCaWcgd2hvc2UgdmFsdWUgaXMgdGhlIGFic29sdXRlIHZhbHVlIG9mIHRoaXMgQmlnLlxyXG4gKi9cclxuUC5hYnMgPSBmdW5jdGlvbiAoKSB7XHJcbiAgdmFyIHggPSBuZXcgdGhpcy5jb25zdHJ1Y3Rvcih0aGlzKTtcclxuICB4LnMgPSAxO1xyXG4gIHJldHVybiB4O1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiAxIGlmIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBpcyBncmVhdGVyIHRoYW4gdGhlIHZhbHVlIG9mIEJpZyB5LFxyXG4gKiAgICAgICAtMSBpZiB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgaXMgbGVzcyB0aGFuIHRoZSB2YWx1ZSBvZiBCaWcgeSwgb3JcclxuICogICAgICAgIDAgaWYgdGhleSBoYXZlIHRoZSBzYW1lIHZhbHVlLlxyXG4qL1xyXG5QLmNtcCA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgdmFyIGlzbmVnLFxyXG4gICAgeCA9IHRoaXMsXHJcbiAgICB4YyA9IHguYyxcclxuICAgIHljID0gKHkgPSBuZXcgeC5jb25zdHJ1Y3Rvcih5KSkuYyxcclxuICAgIGkgPSB4LnMsXHJcbiAgICBqID0geS5zLFxyXG4gICAgayA9IHguZSxcclxuICAgIGwgPSB5LmU7XHJcblxyXG4gIC8vIEVpdGhlciB6ZXJvP1xyXG4gIGlmICgheGNbMF0gfHwgIXljWzBdKSByZXR1cm4gIXhjWzBdID8gIXljWzBdID8gMCA6IC1qIDogaTtcclxuXHJcbiAgLy8gU2lnbnMgZGlmZmVyP1xyXG4gIGlmIChpICE9IGopIHJldHVybiBpO1xyXG5cclxuICBpc25lZyA9IGkgPCAwO1xyXG5cclxuICAvLyBDb21wYXJlIGV4cG9uZW50cy5cclxuICBpZiAoayAhPSBsKSByZXR1cm4gayA+IGwgXiBpc25lZyA/IDEgOiAtMTtcclxuXHJcbiAgaiA9IChrID0geGMubGVuZ3RoKSA8IChsID0geWMubGVuZ3RoKSA/IGsgOiBsO1xyXG5cclxuICAvLyBDb21wYXJlIGRpZ2l0IGJ5IGRpZ2l0LlxyXG4gIGZvciAoaSA9IC0xOyArK2kgPCBqOykge1xyXG4gICAgaWYgKHhjW2ldICE9IHljW2ldKSByZXR1cm4geGNbaV0gPiB5Y1tpXSBeIGlzbmVnID8gMSA6IC0xO1xyXG4gIH1cclxuXHJcbiAgLy8gQ29tcGFyZSBsZW5ndGhzLlxyXG4gIHJldHVybiBrID09IGwgPyAwIDogayA+IGwgXiBpc25lZyA/IDEgOiAtMTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBuZXcgQmlnIHdob3NlIHZhbHVlIGlzIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBkaXZpZGVkIGJ5IHRoZSB2YWx1ZSBvZiBCaWcgeSwgcm91bmRlZCxcclxuICogaWYgbmVjZXNzYXJ5LCB0byBhIG1heGltdW0gb2YgQmlnLkRQIGRlY2ltYWwgcGxhY2VzIHVzaW5nIHJvdW5kaW5nIG1vZGUgQmlnLlJNLlxyXG4gKi9cclxuUC5kaXYgPSBmdW5jdGlvbiAoeSkge1xyXG4gIHZhciB4ID0gdGhpcyxcclxuICAgIEJpZyA9IHguY29uc3RydWN0b3IsXHJcbiAgICBhID0geC5jLCAgICAgICAgICAgICAgICAgIC8vIGRpdmlkZW5kXHJcbiAgICBiID0gKHkgPSBuZXcgQmlnKHkpKS5jLCAgIC8vIGRpdmlzb3JcclxuICAgIGsgPSB4LnMgPT0geS5zID8gMSA6IC0xLFxyXG4gICAgZHAgPSBCaWcuRFA7XHJcblxyXG4gIGlmIChkcCAhPT0gfn5kcCB8fCBkcCA8IDAgfHwgZHAgPiBNQVhfRFApIHRocm93IEVycm9yKElOVkFMSURfRFApO1xyXG5cclxuICAvLyBEaXZpc29yIGlzIHplcm8/XHJcbiAgaWYgKCFiWzBdKSB0aHJvdyBFcnJvcihESVZfQllfWkVSTyk7XHJcblxyXG4gIC8vIERpdmlkZW5kIGlzIDA/IFJldHVybiArLTAuXHJcbiAgaWYgKCFhWzBdKSByZXR1cm4gbmV3IEJpZyhrICogMCk7XHJcblxyXG4gIHZhciBibCwgYnQsIG4sIGNtcCwgcmksXHJcbiAgICBieiA9IGIuc2xpY2UoKSxcclxuICAgIGFpID0gYmwgPSBiLmxlbmd0aCxcclxuICAgIGFsID0gYS5sZW5ndGgsXHJcbiAgICByID0gYS5zbGljZSgwLCBibCksICAgLy8gcmVtYWluZGVyXHJcbiAgICBybCA9IHIubGVuZ3RoLFxyXG4gICAgcSA9IHksICAgICAgICAgICAgICAgIC8vIHF1b3RpZW50XHJcbiAgICBxYyA9IHEuYyA9IFtdLFxyXG4gICAgcWkgPSAwLFxyXG4gICAgZCA9IGRwICsgKHEuZSA9IHguZSAtIHkuZSkgKyAxOyAgICAvLyBudW1iZXIgb2YgZGlnaXRzIG9mIHRoZSByZXN1bHRcclxuXHJcbiAgcS5zID0gaztcclxuICBrID0gZCA8IDAgPyAwIDogZDtcclxuXHJcbiAgLy8gQ3JlYXRlIHZlcnNpb24gb2YgZGl2aXNvciB3aXRoIGxlYWRpbmcgemVyby5cclxuICBiei51bnNoaWZ0KDApO1xyXG5cclxuICAvLyBBZGQgemVyb3MgdG8gbWFrZSByZW1haW5kZXIgYXMgbG9uZyBhcyBkaXZpc29yLlxyXG4gIGZvciAoOyBybCsrIDwgYmw7KSByLnB1c2goMCk7XHJcblxyXG4gIGRvIHtcclxuXHJcbiAgICAvLyBuIGlzIGhvdyBtYW55IHRpbWVzIHRoZSBkaXZpc29yIGdvZXMgaW50byBjdXJyZW50IHJlbWFpbmRlci5cclxuICAgIGZvciAobiA9IDA7IG4gPCAxMDsgbisrKSB7XHJcblxyXG4gICAgICAvLyBDb21wYXJlIGRpdmlzb3IgYW5kIHJlbWFpbmRlci5cclxuICAgICAgaWYgKGJsICE9IChybCA9IHIubGVuZ3RoKSkge1xyXG4gICAgICAgIGNtcCA9IGJsID4gcmwgPyAxIDogLTE7XHJcbiAgICAgIH0gZWxzZSB7XHJcbiAgICAgICAgZm9yIChyaSA9IC0xLCBjbXAgPSAwOyArK3JpIDwgYmw7KSB7XHJcbiAgICAgICAgICBpZiAoYltyaV0gIT0gcltyaV0pIHtcclxuICAgICAgICAgICAgY21wID0gYltyaV0gPiByW3JpXSA/IDEgOiAtMTtcclxuICAgICAgICAgICAgYnJlYWs7XHJcbiAgICAgICAgICB9XHJcbiAgICAgICAgfVxyXG4gICAgICB9XHJcblxyXG4gICAgICAvLyBJZiBkaXZpc29yIDwgcmVtYWluZGVyLCBzdWJ0cmFjdCBkaXZpc29yIGZyb20gcmVtYWluZGVyLlxyXG4gICAgICBpZiAoY21wIDwgMCkge1xyXG5cclxuICAgICAgICAvLyBSZW1haW5kZXIgY2FuJ3QgYmUgbW9yZSB0aGFuIDEgZGlnaXQgbG9uZ2VyIHRoYW4gZGl2aXNvci5cclxuICAgICAgICAvLyBFcXVhbGlzZSBsZW5ndGhzIHVzaW5nIGRpdmlzb3Igd2l0aCBleHRyYSBsZWFkaW5nIHplcm8/XHJcbiAgICAgICAgZm9yIChidCA9IHJsID09IGJsID8gYiA6IGJ6OyBybDspIHtcclxuICAgICAgICAgIGlmIChyWy0tcmxdIDwgYnRbcmxdKSB7XHJcbiAgICAgICAgICAgIHJpID0gcmw7XHJcbiAgICAgICAgICAgIGZvciAoOyByaSAmJiAhclstLXJpXTspIHJbcmldID0gOTtcclxuICAgICAgICAgICAgLS1yW3JpXTtcclxuICAgICAgICAgICAgcltybF0gKz0gMTA7XHJcbiAgICAgICAgICB9XHJcbiAgICAgICAgICByW3JsXSAtPSBidFtybF07XHJcbiAgICAgICAgfVxyXG5cclxuICAgICAgICBmb3IgKDsgIXJbMF07KSByLnNoaWZ0KCk7XHJcbiAgICAgIH0gZWxzZSB7XHJcbiAgICAgICAgYnJlYWs7XHJcbiAgICAgIH1cclxuICAgIH1cclxuXHJcbiAgICAvLyBBZGQgdGhlIGRpZ2l0IG4gdG8gdGhlIHJlc3VsdCBhcnJheS5cclxuICAgIHFjW3FpKytdID0gY21wID8gbiA6ICsrbjtcclxuXHJcbiAgICAvLyBVcGRhdGUgdGhlIHJlbWFpbmRlci5cclxuICAgIGlmIChyWzBdICYmIGNtcCkgcltybF0gPSBhW2FpXSB8fCAwO1xyXG4gICAgZWxzZSByID0gW2FbYWldXTtcclxuXHJcbiAgfSB3aGlsZSAoKGFpKysgPCBhbCB8fCByWzBdICE9PSBVTkRFRklORUQpICYmIGstLSk7XHJcblxyXG4gIC8vIExlYWRpbmcgemVybz8gRG8gbm90IHJlbW92ZSBpZiByZXN1bHQgaXMgc2ltcGx5IHplcm8gKHFpID09IDEpLlxyXG4gIGlmICghcWNbMF0gJiYgcWkgIT0gMSkge1xyXG5cclxuICAgIC8vIFRoZXJlIGNhbid0IGJlIG1vcmUgdGhhbiBvbmUgemVyby5cclxuICAgIHFjLnNoaWZ0KCk7XHJcbiAgICBxLmUtLTtcclxuICB9XHJcblxyXG4gIC8vIFJvdW5kP1xyXG4gIGlmIChxaSA+IGQpIHJvdW5kKHEsIGRwLCBCaWcuUk0sIHJbMF0gIT09IFVOREVGSU5FRCk7XHJcblxyXG4gIHJldHVybiBxO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiB0cnVlIGlmIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBpcyBlcXVhbCB0byB0aGUgdmFsdWUgb2YgQmlnIHksIG90aGVyd2lzZSByZXR1cm4gZmFsc2UuXHJcbiAqL1xyXG5QLmVxID0gZnVuY3Rpb24gKHkpIHtcclxuICByZXR1cm4gIXRoaXMuY21wKHkpO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiB0cnVlIGlmIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBpcyBncmVhdGVyIHRoYW4gdGhlIHZhbHVlIG9mIEJpZyB5LCBvdGhlcndpc2UgcmV0dXJuXHJcbiAqIGZhbHNlLlxyXG4gKi9cclxuUC5ndCA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgcmV0dXJuIHRoaXMuY21wKHkpID4gMDtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gdHJ1ZSBpZiB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgaXMgZ3JlYXRlciB0aGFuIG9yIGVxdWFsIHRvIHRoZSB2YWx1ZSBvZiBCaWcgeSwgb3RoZXJ3aXNlXHJcbiAqIHJldHVybiBmYWxzZS5cclxuICovXHJcblAuZ3RlID0gZnVuY3Rpb24gKHkpIHtcclxuICByZXR1cm4gdGhpcy5jbXAoeSkgPiAtMTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gdHJ1ZSBpZiB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgaXMgbGVzcyB0aGFuIHRoZSB2YWx1ZSBvZiBCaWcgeSwgb3RoZXJ3aXNlIHJldHVybiBmYWxzZS5cclxuICovXHJcblAubHQgPSBmdW5jdGlvbiAoeSkge1xyXG4gIHJldHVybiB0aGlzLmNtcCh5KSA8IDA7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIHRydWUgaWYgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIGlzIGxlc3MgdGhhbiBvciBlcXVhbCB0byB0aGUgdmFsdWUgb2YgQmlnIHksIG90aGVyd2lzZVxyXG4gKiByZXR1cm4gZmFsc2UuXHJcbiAqL1xyXG5QLmx0ZSA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgcmV0dXJuIHRoaXMuY21wKHkpIDwgMTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBuZXcgQmlnIHdob3NlIHZhbHVlIGlzIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBtaW51cyB0aGUgdmFsdWUgb2YgQmlnIHkuXHJcbiAqL1xyXG5QLm1pbnVzID0gUC5zdWIgPSBmdW5jdGlvbiAoeSkge1xyXG4gIHZhciBpLCBqLCB0LCB4bHR5LFxyXG4gICAgeCA9IHRoaXMsXHJcbiAgICBCaWcgPSB4LmNvbnN0cnVjdG9yLFxyXG4gICAgYSA9IHgucyxcclxuICAgIGIgPSAoeSA9IG5ldyBCaWcoeSkpLnM7XHJcblxyXG4gIC8vIFNpZ25zIGRpZmZlcj9cclxuICBpZiAoYSAhPSBiKSB7XHJcbiAgICB5LnMgPSAtYjtcclxuICAgIHJldHVybiB4LnBsdXMoeSk7XHJcbiAgfVxyXG5cclxuICB2YXIgeGMgPSB4LmMuc2xpY2UoKSxcclxuICAgIHhlID0geC5lLFxyXG4gICAgeWMgPSB5LmMsXHJcbiAgICB5ZSA9IHkuZTtcclxuXHJcbiAgLy8gRWl0aGVyIHplcm8/XHJcbiAgaWYgKCF4Y1swXSB8fCAheWNbMF0pIHtcclxuXHJcbiAgICAvLyB5IGlzIG5vbi16ZXJvPyB4IGlzIG5vbi16ZXJvPyBPciBib3RoIGFyZSB6ZXJvLlxyXG4gICAgcmV0dXJuIHljWzBdID8gKHkucyA9IC1iLCB5KSA6IG5ldyBCaWcoeGNbMF0gPyB4IDogMCk7XHJcbiAgfVxyXG5cclxuICAvLyBEZXRlcm1pbmUgd2hpY2ggaXMgdGhlIGJpZ2dlciBudW1iZXIuIFByZXBlbmQgemVyb3MgdG8gZXF1YWxpc2UgZXhwb25lbnRzLlxyXG4gIGlmIChhID0geGUgLSB5ZSkge1xyXG5cclxuICAgIGlmICh4bHR5ID0gYSA8IDApIHtcclxuICAgICAgYSA9IC1hO1xyXG4gICAgICB0ID0geGM7XHJcbiAgICB9IGVsc2Uge1xyXG4gICAgICB5ZSA9IHhlO1xyXG4gICAgICB0ID0geWM7XHJcbiAgICB9XHJcblxyXG4gICAgdC5yZXZlcnNlKCk7XHJcbiAgICBmb3IgKGIgPSBhOyBiLS07KSB0LnB1c2goMCk7XHJcbiAgICB0LnJldmVyc2UoKTtcclxuICB9IGVsc2Uge1xyXG5cclxuICAgIC8vIEV4cG9uZW50cyBlcXVhbC4gQ2hlY2sgZGlnaXQgYnkgZGlnaXQuXHJcbiAgICBqID0gKCh4bHR5ID0geGMubGVuZ3RoIDwgeWMubGVuZ3RoKSA/IHhjIDogeWMpLmxlbmd0aDtcclxuXHJcbiAgICBmb3IgKGEgPSBiID0gMDsgYiA8IGo7IGIrKykge1xyXG4gICAgICBpZiAoeGNbYl0gIT0geWNbYl0pIHtcclxuICAgICAgICB4bHR5ID0geGNbYl0gPCB5Y1tiXTtcclxuICAgICAgICBicmVhaztcclxuICAgICAgfVxyXG4gICAgfVxyXG4gIH1cclxuXHJcbiAgLy8geCA8IHk/IFBvaW50IHhjIHRvIHRoZSBhcnJheSBvZiB0aGUgYmlnZ2VyIG51bWJlci5cclxuICBpZiAoeGx0eSkge1xyXG4gICAgdCA9IHhjO1xyXG4gICAgeGMgPSB5YztcclxuICAgIHljID0gdDtcclxuICAgIHkucyA9IC15LnM7XHJcbiAgfVxyXG5cclxuICAvKlxyXG4gICAqIEFwcGVuZCB6ZXJvcyB0byB4YyBpZiBzaG9ydGVyLiBObyBuZWVkIHRvIGFkZCB6ZXJvcyB0byB5YyBpZiBzaG9ydGVyIGFzIHN1YnRyYWN0aW9uIG9ubHlcclxuICAgKiBuZWVkcyB0byBzdGFydCBhdCB5Yy5sZW5ndGguXHJcbiAgICovXHJcbiAgaWYgKChiID0gKGogPSB5Yy5sZW5ndGgpIC0gKGkgPSB4Yy5sZW5ndGgpKSA+IDApIGZvciAoOyBiLS07KSB4Y1tpKytdID0gMDtcclxuXHJcbiAgLy8gU3VidHJhY3QgeWMgZnJvbSB4Yy5cclxuICBmb3IgKGIgPSBpOyBqID4gYTspIHtcclxuICAgIGlmICh4Y1stLWpdIDwgeWNbal0pIHtcclxuICAgICAgZm9yIChpID0gajsgaSAmJiAheGNbLS1pXTspIHhjW2ldID0gOTtcclxuICAgICAgLS14Y1tpXTtcclxuICAgICAgeGNbal0gKz0gMTA7XHJcbiAgICB9XHJcblxyXG4gICAgeGNbal0gLT0geWNbal07XHJcbiAgfVxyXG5cclxuICAvLyBSZW1vdmUgdHJhaWxpbmcgemVyb3MuXHJcbiAgZm9yICg7IHhjWy0tYl0gPT09IDA7KSB4Yy5wb3AoKTtcclxuXHJcbiAgLy8gUmVtb3ZlIGxlYWRpbmcgemVyb3MgYW5kIGFkanVzdCBleHBvbmVudCBhY2NvcmRpbmdseS5cclxuICBmb3IgKDsgeGNbMF0gPT09IDA7KSB7XHJcbiAgICB4Yy5zaGlmdCgpO1xyXG4gICAgLS15ZTtcclxuICB9XHJcblxyXG4gIGlmICgheGNbMF0pIHtcclxuXHJcbiAgICAvLyBuIC0gbiA9ICswXHJcbiAgICB5LnMgPSAxO1xyXG5cclxuICAgIC8vIFJlc3VsdCBtdXN0IGJlIHplcm8uXHJcbiAgICB4YyA9IFt5ZSA9IDBdO1xyXG4gIH1cclxuXHJcbiAgeS5jID0geGM7XHJcbiAgeS5lID0geWU7XHJcblxyXG4gIHJldHVybiB5O1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIG5ldyBCaWcgd2hvc2UgdmFsdWUgaXMgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIG1vZHVsbyB0aGUgdmFsdWUgb2YgQmlnIHkuXHJcbiAqL1xyXG5QLm1vZCA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgdmFyIHlndHgsXHJcbiAgICB4ID0gdGhpcyxcclxuICAgIEJpZyA9IHguY29uc3RydWN0b3IsXHJcbiAgICBhID0geC5zLFxyXG4gICAgYiA9ICh5ID0gbmV3IEJpZyh5KSkucztcclxuXHJcbiAgaWYgKCF5LmNbMF0pIHRocm93IEVycm9yKERJVl9CWV9aRVJPKTtcclxuXHJcbiAgeC5zID0geS5zID0gMTtcclxuICB5Z3R4ID0geS5jbXAoeCkgPT0gMTtcclxuICB4LnMgPSBhO1xyXG4gIHkucyA9IGI7XHJcblxyXG4gIGlmICh5Z3R4KSByZXR1cm4gbmV3IEJpZyh4KTtcclxuXHJcbiAgYSA9IEJpZy5EUDtcclxuICBiID0gQmlnLlJNO1xyXG4gIEJpZy5EUCA9IEJpZy5STSA9IDA7XHJcbiAgeCA9IHguZGl2KHkpO1xyXG4gIEJpZy5EUCA9IGE7XHJcbiAgQmlnLlJNID0gYjtcclxuXHJcbiAgcmV0dXJuIHRoaXMubWludXMoeC50aW1lcyh5KSk7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgbmV3IEJpZyB3aG9zZSB2YWx1ZSBpcyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgcGx1cyB0aGUgdmFsdWUgb2YgQmlnIHkuXHJcbiAqL1xyXG5QLnBsdXMgPSBQLmFkZCA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgdmFyIHQsXHJcbiAgICB4ID0gdGhpcyxcclxuICAgIEJpZyA9IHguY29uc3RydWN0b3IsXHJcbiAgICBhID0geC5zLFxyXG4gICAgYiA9ICh5ID0gbmV3IEJpZyh5KSkucztcclxuXHJcbiAgLy8gU2lnbnMgZGlmZmVyP1xyXG4gIGlmIChhICE9IGIpIHtcclxuICAgIHkucyA9IC1iO1xyXG4gICAgcmV0dXJuIHgubWludXMoeSk7XHJcbiAgfVxyXG5cclxuICB2YXIgeGUgPSB4LmUsXHJcbiAgICB4YyA9IHguYyxcclxuICAgIHllID0geS5lLFxyXG4gICAgeWMgPSB5LmM7XHJcblxyXG4gIC8vIEVpdGhlciB6ZXJvPyB5IGlzIG5vbi16ZXJvPyB4IGlzIG5vbi16ZXJvPyBPciBib3RoIGFyZSB6ZXJvLlxyXG4gIGlmICgheGNbMF0gfHwgIXljWzBdKSByZXR1cm4geWNbMF0gPyB5IDogbmV3IEJpZyh4Y1swXSA/IHggOiBhICogMCk7XHJcblxyXG4gIHhjID0geGMuc2xpY2UoKTtcclxuXHJcbiAgLy8gUHJlcGVuZCB6ZXJvcyB0byBlcXVhbGlzZSBleHBvbmVudHMuXHJcbiAgLy8gTm90ZTogcmV2ZXJzZSBmYXN0ZXIgdGhhbiB1bnNoaWZ0cy5cclxuICBpZiAoYSA9IHhlIC0geWUpIHtcclxuICAgIGlmIChhID4gMCkge1xyXG4gICAgICB5ZSA9IHhlO1xyXG4gICAgICB0ID0geWM7XHJcbiAgICB9IGVsc2Uge1xyXG4gICAgICBhID0gLWE7XHJcbiAgICAgIHQgPSB4YztcclxuICAgIH1cclxuXHJcbiAgICB0LnJldmVyc2UoKTtcclxuICAgIGZvciAoOyBhLS07KSB0LnB1c2goMCk7XHJcbiAgICB0LnJldmVyc2UoKTtcclxuICB9XHJcblxyXG4gIC8vIFBvaW50IHhjIHRvIHRoZSBsb25nZXIgYXJyYXkuXHJcbiAgaWYgKHhjLmxlbmd0aCAtIHljLmxlbmd0aCA8IDApIHtcclxuICAgIHQgPSB5YztcclxuICAgIHljID0geGM7XHJcbiAgICB4YyA9IHQ7XHJcbiAgfVxyXG5cclxuICBhID0geWMubGVuZ3RoO1xyXG5cclxuICAvLyBPbmx5IHN0YXJ0IGFkZGluZyBhdCB5Yy5sZW5ndGggLSAxIGFzIHRoZSBmdXJ0aGVyIGRpZ2l0cyBvZiB4YyBjYW4gYmUgbGVmdCBhcyB0aGV5IGFyZS5cclxuICBmb3IgKGIgPSAwOyBhOyB4Y1thXSAlPSAxMCkgYiA9ICh4Y1stLWFdID0geGNbYV0gKyB5Y1thXSArIGIpIC8gMTAgfCAwO1xyXG5cclxuICAvLyBObyBuZWVkIHRvIGNoZWNrIGZvciB6ZXJvLCBhcyAreCArICt5ICE9IDAgJiYgLXggKyAteSAhPSAwXHJcblxyXG4gIGlmIChiKSB7XHJcbiAgICB4Yy51bnNoaWZ0KGIpO1xyXG4gICAgKyt5ZTtcclxuICB9XHJcblxyXG4gIC8vIFJlbW92ZSB0cmFpbGluZyB6ZXJvcy5cclxuICBmb3IgKGEgPSB4Yy5sZW5ndGg7IHhjWy0tYV0gPT09IDA7KSB4Yy5wb3AoKTtcclxuXHJcbiAgeS5jID0geGM7XHJcbiAgeS5lID0geWU7XHJcblxyXG4gIHJldHVybiB5O1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIEJpZyB3aG9zZSB2YWx1ZSBpcyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgcmFpc2VkIHRvIHRoZSBwb3dlciBuLlxyXG4gKiBJZiBuIGlzIG5lZ2F0aXZlLCByb3VuZCB0byBhIG1heGltdW0gb2YgQmlnLkRQIGRlY2ltYWwgcGxhY2VzIHVzaW5nIHJvdW5kaW5nXHJcbiAqIG1vZGUgQmlnLlJNLlxyXG4gKlxyXG4gKiBuIHtudW1iZXJ9IEludGVnZXIsIC1NQVhfUE9XRVIgdG8gTUFYX1BPV0VSIGluY2x1c2l2ZS5cclxuICovXHJcblAucG93ID0gZnVuY3Rpb24gKG4pIHtcclxuICB2YXIgeCA9IHRoaXMsXHJcbiAgICBvbmUgPSBuZXcgeC5jb25zdHJ1Y3RvcigxKSxcclxuICAgIHkgPSBvbmUsXHJcbiAgICBpc25lZyA9IG4gPCAwO1xyXG5cclxuICBpZiAobiAhPT0gfn5uIHx8IG4gPCAtTUFYX1BPV0VSIHx8IG4gPiBNQVhfUE9XRVIpIHRocm93IEVycm9yKElOVkFMSUQgKyAnZXhwb25lbnQnKTtcclxuICBpZiAoaXNuZWcpIG4gPSAtbjtcclxuXHJcbiAgZm9yICg7Oykge1xyXG4gICAgaWYgKG4gJiAxKSB5ID0geS50aW1lcyh4KTtcclxuICAgIG4gPj49IDE7XHJcbiAgICBpZiAoIW4pIGJyZWFrO1xyXG4gICAgeCA9IHgudGltZXMoeCk7XHJcbiAgfVxyXG5cclxuICByZXR1cm4gaXNuZWcgPyBvbmUuZGl2KHkpIDogeTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBuZXcgQmlnIHdob3NlIHZhbHVlIGlzIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyByb3VuZGVkIHVzaW5nIHJvdW5kaW5nIG1vZGUgcm1cclxuICogdG8gYSBtYXhpbXVtIG9mIGRwIGRlY2ltYWwgcGxhY2VzLCBvciwgaWYgZHAgaXMgbmVnYXRpdmUsIHRvIGFuIGludGVnZXIgd2hpY2ggaXMgYVxyXG4gKiBtdWx0aXBsZSBvZiAxMCoqLWRwLlxyXG4gKiBJZiBkcCBpcyBub3Qgc3BlY2lmaWVkLCByb3VuZCB0byAwIGRlY2ltYWwgcGxhY2VzLlxyXG4gKiBJZiBybSBpcyBub3Qgc3BlY2lmaWVkLCB1c2UgQmlnLlJNLlxyXG4gKlxyXG4gKiBkcD8ge251bWJlcn0gSW50ZWdlciwgLU1BWF9EUCB0byBNQVhfRFAgaW5jbHVzaXZlLlxyXG4gKiBybT8gMCwgMSwgMiBvciAzIChST1VORF9ET1dOLCBST1VORF9IQUxGX1VQLCBST1VORF9IQUxGX0VWRU4sIFJPVU5EX1VQKVxyXG4gKi9cclxuUC5yb3VuZCA9IGZ1bmN0aW9uIChkcCwgcm0pIHtcclxuICB2YXIgQmlnID0gdGhpcy5jb25zdHJ1Y3RvcjtcclxuICBpZiAoZHAgPT09IFVOREVGSU5FRCkgZHAgPSAwO1xyXG4gIGVsc2UgaWYgKGRwICE9PSB+fmRwIHx8IGRwIDwgLU1BWF9EUCB8fCBkcCA+IE1BWF9EUCkgdGhyb3cgRXJyb3IoSU5WQUxJRF9EUCk7XHJcbiAgcmV0dXJuIHJvdW5kKG5ldyBCaWcodGhpcyksIGRwLCBybSA9PT0gVU5ERUZJTkVEID8gQmlnLlJNIDogcm0pO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIG5ldyBCaWcgd2hvc2UgdmFsdWUgaXMgdGhlIHNxdWFyZSByb290IG9mIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZywgcm91bmRlZCwgaWZcclxuICogbmVjZXNzYXJ5LCB0byBhIG1heGltdW0gb2YgQmlnLkRQIGRlY2ltYWwgcGxhY2VzIHVzaW5nIHJvdW5kaW5nIG1vZGUgQmlnLlJNLlxyXG4gKi9cclxuUC5zcXJ0ID0gZnVuY3Rpb24gKCkge1xyXG4gIHZhciByLCBjLCB0LFxyXG4gICAgeCA9IHRoaXMsXHJcbiAgICBCaWcgPSB4LmNvbnN0cnVjdG9yLFxyXG4gICAgcyA9IHgucyxcclxuICAgIGUgPSB4LmUsXHJcbiAgICBoYWxmID0gbmV3IEJpZygwLjUpO1xyXG5cclxuICAvLyBaZXJvP1xyXG4gIGlmICgheC5jWzBdKSByZXR1cm4gbmV3IEJpZyh4KTtcclxuXHJcbiAgLy8gTmVnYXRpdmU/XHJcbiAgaWYgKHMgPCAwKSB0aHJvdyBFcnJvcihOQU1FICsgJ05vIHNxdWFyZSByb290Jyk7XHJcblxyXG4gIC8vIEVzdGltYXRlLlxyXG4gIHMgPSBNYXRoLnNxcnQoeCArICcnKTtcclxuXHJcbiAgLy8gTWF0aC5zcXJ0IHVuZGVyZmxvdy9vdmVyZmxvdz9cclxuICAvLyBSZS1lc3RpbWF0ZTogcGFzcyB4IGNvZWZmaWNpZW50IHRvIE1hdGguc3FydCBhcyBpbnRlZ2VyLCB0aGVuIGFkanVzdCB0aGUgcmVzdWx0IGV4cG9uZW50LlxyXG4gIGlmIChzID09PSAwIHx8IHMgPT09IDEgLyAwKSB7XHJcbiAgICBjID0geC5jLmpvaW4oJycpO1xyXG4gICAgaWYgKCEoYy5sZW5ndGggKyBlICYgMSkpIGMgKz0gJzAnO1xyXG4gICAgcyA9IE1hdGguc3FydChjKTtcclxuICAgIGUgPSAoKGUgKyAxKSAvIDIgfCAwKSAtIChlIDwgMCB8fCBlICYgMSk7XHJcbiAgICByID0gbmV3IEJpZygocyA9PSAxIC8gMCA/ICcxZScgOiAocyA9IHMudG9FeHBvbmVudGlhbCgpKS5zbGljZSgwLCBzLmluZGV4T2YoJ2UnKSArIDEpKSArIGUpO1xyXG4gIH0gZWxzZSB7XHJcbiAgICByID0gbmV3IEJpZyhzKTtcclxuICB9XHJcblxyXG4gIGUgPSByLmUgKyAoQmlnLkRQICs9IDQpO1xyXG5cclxuICAvLyBOZXd0b24tUmFwaHNvbiBpdGVyYXRpb24uXHJcbiAgZG8ge1xyXG4gICAgdCA9IHI7XHJcbiAgICByID0gaGFsZi50aW1lcyh0LnBsdXMoeC5kaXYodCkpKTtcclxuICB9IHdoaWxlICh0LmMuc2xpY2UoMCwgZSkuam9pbignJykgIT09IHIuYy5zbGljZSgwLCBlKS5qb2luKCcnKSk7XHJcblxyXG4gIHJldHVybiByb3VuZChyLCBCaWcuRFAgLT0gNCwgQmlnLlJNKTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBuZXcgQmlnIHdob3NlIHZhbHVlIGlzIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyB0aW1lcyB0aGUgdmFsdWUgb2YgQmlnIHkuXHJcbiAqL1xyXG5QLnRpbWVzID0gUC5tdWwgPSBmdW5jdGlvbiAoeSkge1xyXG4gIHZhciBjLFxyXG4gICAgeCA9IHRoaXMsXHJcbiAgICBCaWcgPSB4LmNvbnN0cnVjdG9yLFxyXG4gICAgeGMgPSB4LmMsXHJcbiAgICB5YyA9ICh5ID0gbmV3IEJpZyh5KSkuYyxcclxuICAgIGEgPSB4Yy5sZW5ndGgsXHJcbiAgICBiID0geWMubGVuZ3RoLFxyXG4gICAgaSA9IHguZSxcclxuICAgIGogPSB5LmU7XHJcblxyXG4gIC8vIERldGVybWluZSBzaWduIG9mIHJlc3VsdC5cclxuICB5LnMgPSB4LnMgPT0geS5zID8gMSA6IC0xO1xyXG5cclxuICAvLyBSZXR1cm4gc2lnbmVkIDAgaWYgZWl0aGVyIDAuXHJcbiAgaWYgKCF4Y1swXSB8fCAheWNbMF0pIHJldHVybiBuZXcgQmlnKHkucyAqIDApO1xyXG5cclxuICAvLyBJbml0aWFsaXNlIGV4cG9uZW50IG9mIHJlc3VsdCBhcyB4LmUgKyB5LmUuXHJcbiAgeS5lID0gaSArIGo7XHJcblxyXG4gIC8vIElmIGFycmF5IHhjIGhhcyBmZXdlciBkaWdpdHMgdGhhbiB5Yywgc3dhcCB4YyBhbmQgeWMsIGFuZCBsZW5ndGhzLlxyXG4gIGlmIChhIDwgYikge1xyXG4gICAgYyA9IHhjO1xyXG4gICAgeGMgPSB5YztcclxuICAgIHljID0gYztcclxuICAgIGogPSBhO1xyXG4gICAgYSA9IGI7XHJcbiAgICBiID0gajtcclxuICB9XHJcblxyXG4gIC8vIEluaXRpYWxpc2UgY29lZmZpY2llbnQgYXJyYXkgb2YgcmVzdWx0IHdpdGggemVyb3MuXHJcbiAgZm9yIChjID0gbmV3IEFycmF5KGogPSBhICsgYik7IGotLTspIGNbal0gPSAwO1xyXG5cclxuICAvLyBNdWx0aXBseS5cclxuXHJcbiAgLy8gaSBpcyBpbml0aWFsbHkgeGMubGVuZ3RoLlxyXG4gIGZvciAoaSA9IGI7IGktLTspIHtcclxuICAgIGIgPSAwO1xyXG5cclxuICAgIC8vIGEgaXMgeWMubGVuZ3RoLlxyXG4gICAgZm9yIChqID0gYSArIGk7IGogPiBpOykge1xyXG5cclxuICAgICAgLy8gQ3VycmVudCBzdW0gb2YgcHJvZHVjdHMgYXQgdGhpcyBkaWdpdCBwb3NpdGlvbiwgcGx1cyBjYXJyeS5cclxuICAgICAgYiA9IGNbal0gKyB5Y1tpXSAqIHhjW2ogLSBpIC0gMV0gKyBiO1xyXG4gICAgICBjW2otLV0gPSBiICUgMTA7XHJcblxyXG4gICAgICAvLyBjYXJyeVxyXG4gICAgICBiID0gYiAvIDEwIHwgMDtcclxuICAgIH1cclxuXHJcbiAgICBjW2pdID0gKGNbal0gKyBiKSAlIDEwO1xyXG4gIH1cclxuXHJcbiAgLy8gSW5jcmVtZW50IHJlc3VsdCBleHBvbmVudCBpZiB0aGVyZSBpcyBhIGZpbmFsIGNhcnJ5LCBvdGhlcndpc2UgcmVtb3ZlIGxlYWRpbmcgemVyby5cclxuICBpZiAoYikgKyt5LmU7XHJcbiAgZWxzZSBjLnNoaWZ0KCk7XHJcblxyXG4gIC8vIFJlbW92ZSB0cmFpbGluZyB6ZXJvcy5cclxuICBmb3IgKGkgPSBjLmxlbmd0aDsgIWNbLS1pXTspIGMucG9wKCk7XHJcbiAgeS5jID0gYztcclxuXHJcbiAgcmV0dXJuIHk7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgc3RyaW5nIHJlcHJlc2VudGluZyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgaW4gZXhwb25lbnRpYWwgbm90YXRpb24gdG8gZHAgZml4ZWQgZGVjaW1hbFxyXG4gKiBwbGFjZXMgYW5kIHJvdW5kZWQgdXNpbmcgQmlnLlJNLlxyXG4gKlxyXG4gKiBkcD8ge251bWJlcn0gSW50ZWdlciwgMCB0byBNQVhfRFAgaW5jbHVzaXZlLlxyXG4gKi9cclxuUC50b0V4cG9uZW50aWFsID0gZnVuY3Rpb24gKGRwKSB7XHJcbiAgcmV0dXJuIHN0cmluZ2lmeSh0aGlzLCAxLCBkcCwgZHApO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIHN0cmluZyByZXByZXNlbnRpbmcgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIGluIG5vcm1hbCBub3RhdGlvbiB0byBkcCBmaXhlZCBkZWNpbWFsXHJcbiAqIHBsYWNlcyBhbmQgcm91bmRlZCB1c2luZyBCaWcuUk0uXHJcbiAqXHJcbiAqIGRwPyB7bnVtYmVyfSBJbnRlZ2VyLCAwIHRvIE1BWF9EUCBpbmNsdXNpdmUuXHJcbiAqXHJcbiAqICgtMCkudG9GaXhlZCgwKSBpcyAnMCcsIGJ1dCAoLTAuMSkudG9GaXhlZCgwKSBpcyAnLTAnLlxyXG4gKiAoLTApLnRvRml4ZWQoMSkgaXMgJzAuMCcsIGJ1dCAoLTAuMDEpLnRvRml4ZWQoMSkgaXMgJy0wLjAnLlxyXG4gKi9cclxuUC50b0ZpeGVkID0gZnVuY3Rpb24gKGRwKSB7XHJcbiAgcmV0dXJuIHN0cmluZ2lmeSh0aGlzLCAyLCBkcCwgdGhpcy5lICsgZHApO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIHN0cmluZyByZXByZXNlbnRpbmcgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIHJvdW5kZWQgdG8gc2Qgc2lnbmlmaWNhbnQgZGlnaXRzIHVzaW5nXHJcbiAqIEJpZy5STS4gVXNlIGV4cG9uZW50aWFsIG5vdGF0aW9uIGlmIHNkIGlzIGxlc3MgdGhhbiB0aGUgbnVtYmVyIG9mIGRpZ2l0cyBuZWNlc3NhcnkgdG8gcmVwcmVzZW50XHJcbiAqIHRoZSBpbnRlZ2VyIHBhcnQgb2YgdGhlIHZhbHVlIGluIG5vcm1hbCBub3RhdGlvbi5cclxuICpcclxuICogc2Qge251bWJlcn0gSW50ZWdlciwgMSB0byBNQVhfRFAgaW5jbHVzaXZlLlxyXG4gKi9cclxuUC50b1ByZWNpc2lvbiA9IGZ1bmN0aW9uIChzZCkge1xyXG4gIHJldHVybiBzdHJpbmdpZnkodGhpcywgMywgc2QsIHNkIC0gMSk7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgc3RyaW5nIHJlcHJlc2VudGluZyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcuXHJcbiAqIFJldHVybiBleHBvbmVudGlhbCBub3RhdGlvbiBpZiB0aGlzIEJpZyBoYXMgYSBwb3NpdGl2ZSBleHBvbmVudCBlcXVhbCB0byBvciBncmVhdGVyIHRoYW5cclxuICogQmlnLlBFLCBvciBhIG5lZ2F0aXZlIGV4cG9uZW50IGVxdWFsIHRvIG9yIGxlc3MgdGhhbiBCaWcuTkUuXHJcbiAqIE9taXQgdGhlIHNpZ24gZm9yIG5lZ2F0aXZlIHplcm8uXHJcbiAqL1xyXG5QLnRvU3RyaW5nID0gZnVuY3Rpb24gKCkge1xyXG4gIHJldHVybiBzdHJpbmdpZnkodGhpcyk7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgc3RyaW5nIHJlcHJlc2VudGluZyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcuXHJcbiAqIFJldHVybiBleHBvbmVudGlhbCBub3RhdGlvbiBpZiB0aGlzIEJpZyBoYXMgYSBwb3NpdGl2ZSBleHBvbmVudCBlcXVhbCB0byBvciBncmVhdGVyIHRoYW5cclxuICogQmlnLlBFLCBvciBhIG5lZ2F0aXZlIGV4cG9uZW50IGVxdWFsIHRvIG9yIGxlc3MgdGhhbiBCaWcuTkUuXHJcbiAqIEluY2x1ZGUgdGhlIHNpZ24gZm9yIG5lZ2F0aXZlIHplcm8uXHJcbiAqL1xyXG5QLnZhbHVlT2YgPSBQLnRvSlNPTiA9IGZ1bmN0aW9uICgpIHtcclxuICByZXR1cm4gc3RyaW5naWZ5KHRoaXMsIDQpO1xyXG59O1xyXG5cclxuXHJcbi8vIEV4cG9ydFxyXG5cclxuXHJcbmV4cG9ydCB2YXIgQmlnID0gX0JpZ18oKTtcclxuXHJcbmV4cG9ydCBkZWZhdWx0IEJpZztcclxuIiwiaW1wb3J0IEJpZyBmcm9tICdiaWcuanMnO1xuXG4vKipcbiAqIOWKoOazleWHveaVsFxuICogQHBhcmFtIHtudW1iZXJ8c3RyaW5nfSB4IC0g5Yqg5pWwXG4gKiBAcGFyYW0ge251bWJlcnxzdHJpbmd9IHkgLSDliqDmlbBcbiAqIEByZXR1cm5zIHtzdHJpbmd9IC0g6L+U5Zue55u45Yqg57uT5p6cXG4gKi9cbmZ1bmN0aW9uIGFkZCh4LCB5KSB7XG4gICAgcmV0dXJuIG5ldyBCaWcoeCkucGx1cyh5KS50b1N0cmluZygpO1xufVxuXG4vKipcbiAqIOWHj+azleWHveaVsFxuICogQHBhcmFtIHtudW1iZXJ8c3RyaW5nfSB4IC0g6KKr5YeP5pWwXG4gKiBAcGFyYW0ge251bWJlcnxzdHJpbmd9IHkgLSDlh4/mlbBcbiAqIEByZXR1cm5zIHtzdHJpbmd9IC0g6L+U5Zue55u45YeP57uT5p6cXG4gKi9cbmZ1bmN0aW9uIHN1YnRyYWN0KHgsIHkpIHtcbiAgICByZXR1cm4gbmV3IEJpZyh4KS5taW51cyh5KS50b1N0cmluZygpO1xufVxuXG4vKipcbiAqIOS5mOazleWHveaVsFxuICogQHBhcmFtIHtudW1iZXJ8c3RyaW5nfSB4IC0g5LmY5pWwXG4gKiBAcGFyYW0ge251bWJlcnxzdHJpbmd9IHkgLSDkuZjmlbBcbiAqIEByZXR1cm5zIHtzdHJpbmd9IC0g6L+U5Zue55u45LmY57uT5p6cXG4gKi9cbmZ1bmN0aW9uIG11bHRpcGx5KHgsIHkpIHtcbiAgICByZXR1cm4gbmV3IEJpZyh4KS50aW1lcyh5KS50b1N0cmluZygpO1xufVxuXG4vKipcbiAqIOmZpOazleWHveaVsFxuICogQHBhcmFtIHtudW1iZXJ8c3RyaW5nfSB4IC0g6KKr6Zmk5pWwXG4gKiBAcGFyYW0ge251bWJlcnxzdHJpbmd9IHkgLSDpmaTmlbBcbiAqIEByZXR1cm5zIHtzdHJpbmd9IC0g6L+U5Zue55u46Zmk57uT5p6cXG4gKi9cbmZ1bmN0aW9uIGRpdmlkZSh4LCB5KSB7XG4gICAgcmV0dXJuIG5ldyBCaWcoeCkuZGl2KHkpLnRvU3RyaW5nKCk7XG59XG5cbi8qKlxuICog5qC85byP5YyW5pWw5a2XXG4gKiBAcGFyYW0ge251bWJlcnxzdHJpbmd9IHZhbHVlIC0g5b6F5qC85byP5YyW55qE5pWw5a2XXG4gKiBAcGFyYW0ge251bWJlcn0gW3ByZWNpc2lvbl0gLSDnsr7luqbvvIzljbPlsI/mlbDkvY3mlbBcbiAqIEByZXR1cm5zIHtzdHJpbmd9IC0g5qC85byP5YyW5ZCO55qE5a2X56ym5LiyXG4gKi9cbmZ1bmN0aW9uIGZvcm1hdCh2YWx1ZSwgcHJlY2lzaW9uKSB7XG5cdEJpZy5ORSA9IC05XG4gICAgY29uc3QgYmlnVmFsdWUgPSBuZXcgQmlnKHZhbHVlKTtcbiAgICBsZXQgc3RyaW5nVmFsdWUgPSBiaWdWYWx1ZS50b1N0cmluZygpO1xuICAgIC8v5YaZ6L+Z5LmI6bq754Om77yM5piv5Zug5Li6QmlnLnJvdW5k55u45YWz5pa55rOV5LiN5aW95L2/77yM5b6X5LiN5Yiw6aKE5pyf57uT5p6c44CCXG4gICAgaWYgKHN0cmluZ1ZhbHVlLmluY2x1ZGVzKCcuJykpIHtcbiAgICAgICAgbGV0IHN0ckFycmF5ID0gc3RyaW5nVmFsdWUuc3BsaXQoJy4nKTtcbiAgICAgICAgaWYgKHN0ckFycmF5WzFdLmxlbmd0aCA+PSBwcmVjaXNpb24pIHtcbiAgICAgICAgICAgIGlmICgwID09IHByZWNpc2lvbikge1xuICAgICAgICAgICAgICAgIHJldHVybiBzdHJBcnJheVswXTtcbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIGVsc2Uge1xuICAgICAgICAgICAgICAgIC8v5oiq5patXG4gICAgICAgICAgICAgICAgbGV0IHRydW5jYXRlID0gc3RyQXJyYXlbMV0uc3Vic3RyaW5nKDAsIHByZWNpc2lvbik7XG4gICAgICAgICAgICAgICAgcmV0dXJuIGAke3N0ckFycmF5WzBdfS4ke3RydW5jYXRlfWA7XG4gICAgICAgICAgICB9XG4gICAgICAgIH1cbiAgICAgICAgZWxzZSB7XG4gICAgICAgICAgICAvL+ihpembtlxuICAgICAgICAgICAgbGV0IHplcm9OdW1iZXIgPSBwcmVjaXNpb24gLSBzdHJBcnJheVsxXS5sZW5ndGg7XG4gICAgICAgICAgICB2YXIgc3RyID0gJyc7XG4gICAgICAgICAgICBmb3IgKGxldCBpID0gMDsgaSA8IHplcm9OdW1iZXI7IGkrKykge1xuICAgICAgICAgICAgICAgIHN0ciArPSAnMCc7XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICByZXR1cm4gYCR7c3RyaW5nVmFsdWV9JHtzdHJ9YDtcbiAgICAgICAgfVxuICAgIH1cbiAgICBlbHNlIHtcbiAgICAgICAgaWYgKDAgPT0gcHJlY2lzaW9uKSB7XG4gICAgICAgICAgICByZXR1cm4gc3RyaW5nVmFsdWU7XG4gICAgICAgIH1cbiAgICAgICAgZWxzZSB7XG4gICAgICAgICAgICBsZXQgemVyb051bWJlciA9IHByZWNpc2lvbjtcbiAgICAgICAgICAgIHZhciBzdHIgPSAnJztcbiAgICAgICAgICAgIGZvciAobGV0IGkgPSAwOyBpIDwgemVyb051bWJlcjsgaSsrKSB7XG4gICAgICAgICAgICAgICAgc3RyICs9ICcwJztcbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIHJldHVybiBgJHtzdHJpbmdWYWx1ZX0uJHtzdHJ9YDtcbiAgICAgICAgfVxuICAgIH1cbn1cblxuLyoqXG4gKiDlr7nmlbDnu4TkuK3nmoTmr4/kuKrlhYPntKDov5vooYznsr7noa7ov5Dnrpflubbov5Tlm57kuIDkuKrmlrDmlbDnu4RcbiAqIEBwYXJhbSB7QXJyYXk8bnVtYmVyfHN0cmluZz59IGFyciAtIOW+hei/kOeul+aVsOe7hFxuICogQHJldHVybnMge0FycmF5PHN0cmluZz59IC0g6L+U5Zue6L+Q566X57uT5p6c5pWw57uEXG4gKi9cbmZ1bmN0aW9uIGJpZ251bWJlcihhcnIpIHtcbiAgICBpZiAoQXJyYXkuaXNBcnJheShhcnIpKSB7XG4gICAgICAgIHJldHVybiBhcnIubWFwKCh2YWx1ZSkgPT4gQmlnKHZhbHVlKS50b0ZpeGVkKCkpO1xuICAgIH0gZWxzZSB7XG4gICAgICAgIHJldHVybiBCaWcoYXJyKS50b0ZpeGVkKCk7XG4gICAgfVxufVxuXG5leHBvcnQgeyBhZGQsIHN1YnRyYWN0LCBtdWx0aXBseSwgZGl2aWRlLCBmb3JtYXQsIGJpZ251bWJlciB9O1xuIiwiaW1wb3J0ICogYXMgbnVtYmVyIGZyb20gXCIuL251bWJlclwiO1xuaW1wb3J0IEJpZyBmcm9tICdiaWcuanMnO1xuXG52YXIgY2xpY2thYmxlID0gdHJ1ZTtcbmV4cG9ydCB2YXIgYWNjb3VudElkID0gLTE7XG5jb25zdCBERUZBVUxUX1NUUiA9ICcwLjAwJztcblxuZXhwb3J0IGZ1bmN0aW9uIG1vZHVsZURlZmluZShtb2R1bGVOYW1lLCBkZWZhdWx0RGF0YUZ1bmN0aW9uLCBmdW5jdGlvbnMgPSB7IG9uQ3JlYXRlLCBvbkRlc3Ryb3ksIG9uUmVzdW1lLCBvblBhdXNlLCBvblN0YXJ0LCBvblN0b3AgfSkge1xuICAgIGNvbnNvbGUubG9nKGBsb2FkTW9kdWxlYCwgbW9kdWxlTmFtZSk7XG4gICAgJGRhdGFbbW9kdWxlTmFtZV0gPSBkZWZhdWx0RGF0YUZ1bmN0aW9uKCk7XG4gICAgJGV2ZW50W21vZHVsZU5hbWVdID0ge1xuICAgICAgICBvbkNyZWF0ZTogdHlwZW9mIGZ1bmN0aW9ucy5vbkNyZWF0ZSA9PSAndW5kZWZpbmVkJyA/IG9uQ3JlYXRlIDogZnVuY3Rpb25zLm9uQ3JlYXRlLFxuICAgICAgICBvbkRlc3Ryb3k6IHR5cGVvZiBmdW5jdGlvbnMub25EZXN0cm95ID09ICd1bmRlZmluZWQnID8gb25EZXN0cm95IDogZnVuY3Rpb25zLm9uRGVzdHJveSxcbiAgICAgICAgb25SZXN1bWU6IHR5cGVvZiBmdW5jdGlvbnMub25SZXN1bWUgPT0gJ3VuZGVmaW5lZCcgPyBvblJlc3VtZSA6IGZ1bmN0aW9ucy5vblJlc3VtZSxcbiAgICAgICAgb25QYXVzZTogdHlwZW9mIGZ1bmN0aW9ucy5vblBhdXNlID09ICd1bmRlZmluZWQnID8gb25QYXVzZSA6IGZ1bmN0aW9ucy5vblBhdXNlLFxuICAgICAgICBvblN0YXJ0OiB0eXBlb2YgZnVuY3Rpb25zLm9uU3RhcnQgPT0gJ3VuZGVmaW5lZCcgPyBvblN0YXJ0IDogZnVuY3Rpb25zLm9uU3RhcnQsXG4gICAgICAgIG9uU3RvcDogdHlwZW9mIGZ1bmN0aW9ucy5vblN0b3AgPT0gJ3VuZGVmaW5lZCcgPyBvblN0b3AgOiBmdW5jdGlvbnMub25TdG9wLFxuICAgIH07XG4gICAgcmV0dXJuIHtcbiAgICAgICAgbW9kdWxlRGF0YTogJGRhdGFbbW9kdWxlTmFtZV0sXG4gICAgICAgIG1vZHVsZUV2ZW50OiAkZXZlbnRbbW9kdWxlTmFtZV1cbiAgICB9O1xufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gYW5hbHl0aWNzKGV2ZW50ID0gXCJcIiwgcHJvcGVydGllcyA9IHt9KSB7XG4gICAgY29uc3QgcHJvcGVydGllc0pzb24gPSBKU09OLnN0cmluZ2lmeShwcm9wZXJ0aWVzKTtcbiAgICBjb25zb2xlLmxvZyhgYW5hbHl0aWNzIGV2ZW50OiAke2V2ZW50fSwgcHJvcGVydGllc0pzb24gPSAke3Byb3BlcnRpZXNKc29ufWApO1xuICAgIHZhciBtYXAgPSB7XG4gICAgICAgIGV2ZW50OiBldmVudCxcbiAgICAgICAgcHJvcGVydGllczogcHJvcGVydGllc0pzb25cbiAgICB9O1xuICAgIGF3YWl0ICRuYXRpdmVBUEkuYW5hbHl0aWNzKG1hcCk7XG59XG5cbmZ1bmN0aW9uIG9uQ3JlYXRlKCkge1xuICAgIGNvbnNvbGUubG9nKCdjb21tb24gb25DcmVhdGUnKTtcbn1cblxuZnVuY3Rpb24gb25EZXN0cm95KCkge1xufVxuXG5mdW5jdGlvbiBvblJlc3VtZSgpIHtcbn1cblxuZnVuY3Rpb24gb25QYXVzZSgpIHtcbn1cblxuZnVuY3Rpb24gb25TdGFydCgpIHtcbn1cblxuZnVuY3Rpb24gb25TdG9wKCkge1xufVxuXG5leHBvcnQgdmFyIGNvbW1vbkRhdGEgPSB7XG4gICAgcHJpY2VDb2xvclR5cGU6IDAsIC8vLzDvvJrnuqLmtqjnu7/ot4wgICAx77ya57u/5rao57qi6LeMXG4gICAgY29sb3JNb2RlOiAwLCAvLy8w77ya55m95aSpICAgMe+8mum7keWknFxuICAgIE9TOiAwLCAvLzDvvJppT1MgIDHvvJrlronljZNcbiAgICBhcHBWZXJzaW9uOiBcIlwiLCAvL2FwcOeJiOacrOWPt1xuICAgIGlzSW5SZXZpZXc6IDEsXG4gICAgaDVVcmw6IFwiXCIsIC8vLyBoNeWKqOaAgeWfn+WQjVxuICAgIGxhbmd1YWdlOiBcIlwiLCAvLy8g6K+t6KiA56eN57G7XG4gICAgc3RhdHVzSGVpZ2h0OiAwLFxuICAgIHZUb2tlbjogXCJcIiwgLy8g5paw6K6+5aSH5oyH57q5XG4gICAgb2xkVlRva2VuOiBcIlwiLCAvLyDml6forr7lpIfmjIfnurks5Y+C6ICD5Y6f5p2lXCJmcFwiXG4gICAgYm90dG9tU2FmZUFyZWFIZWlnaHQ6IDAsXG4gICAgY291bnRyeUlkOiBcIlwiLC8v5Zyw5Yy656CBXG59O1xuJGRhdGEuY29tbW9uRGF0YSA9IGNvbW1vbkRhdGE7XG5cbi8vIC8v5omT5byAVVJMXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gb3BlblVSTCh1cmwpIHtcbiAgICBpZiAoIWNsaWNrYWJsZSkge1xuICAgICAgICByZXR1cm47XG4gICAgfVxuICAgIGNvbnNvbGUubG9nKGBvcGVuIHVybDpgLCB1cmwpO1xuICAgIGlmICh1cmwgJiYgdXJsICE9IG51bGwgJiYgdXJsLmxlbmd0aCA+IDApIHtcbiAgICAgICAgYXdhaXQgJG5hdGl2ZUFQSS5vcGVuUm91dGUodXJsKTtcbiAgICB9XG4gICAgY2xpY2thYmxlID0gZmFsc2U7XG4gICAgc2V0VGltZW91dCgoKSA9PiB7XG4gICAgICAgIGNsaWNrYWJsZSA9IHRydWU7XG4gICAgfSwgMTAwMCk7XG59XG5cbi8v6K6+572u6YCa55So6YWN572uXG5leHBvcnQgZnVuY3Rpb24gZ2V0Q29tbW9uQ29uZmlnKHBhcmFtKSB7XG4gICAgY29uc29sZS5sb2cocGFyYW0pO1xuICAgIGNvbW1vbkRhdGEucHJpY2VDb2xvclR5cGUgPSBwYXJzZUludChwYXJhbS5wcmljZUNvbG9yVHlwZSk7XG4gICAgY29tbW9uRGF0YS5jb2xvck1vZGUgPSBwYXJzZUludChwYXJhbS5jb2xvck1vZGUpO1xuICAgIGNvbW1vbkRhdGEuT1MgPSBwYXJzZUludChwYXJhbS5PUyk7XG4gICAgY29tbW9uRGF0YS5hcHBWZXJzaW9uID0gcGFyYW0uYXBwVmVyc2lvbjtcbiAgICBjb21tb25EYXRhLmlzSW5SZXZpZXcgPSBwYXJzZUludChwYXJhbS5pc0luUmV2aWV3KTtcbiAgICBjb21tb25EYXRhLmxhbmd1YWdlID0gcGFyYW0ubGFuZ3VhZ2U7XG4gICAgY29tbW9uRGF0YS5oNVVybCA9IHBhcmFtLmg1VXJsO1xuICAgIGNvbW1vbkRhdGEuc3RhdHVzSGVpZ2h0ID0gcGFyYW0uc3RhdHVzSGVpZ2h0O1xuICAgIGNvbW1vbkRhdGEudlRva2VuID0gcGFyYW0udlRva2VuO1xuICAgIGNvbW1vbkRhdGEub2xkVlRva2VuID0gcGFyYW0ub2xkVlRva2VuO1xuICAgIGNvbW1vbkRhdGEuYm90dG9tU2FmZUFyZWFIZWlnaHQgPSBwYXJhbS5ib3R0b21TYWZlQXJlYUhlaWdodDtcbiAgICBjb21tb25EYXRhLmNvdW50cnlJZCA9IHBhcmFtLmNvdW50cnlJZFxuICAgICRkYXRhLmNvbW1vbkRhdGEgPSBjb21tb25EYXRhO1xufVxuXG5leHBvcnQgZnVuY3Rpb24gZ2V0UE5HSWNvblVSTEJ5Q3VycmVuY3koY3VycmVuY3kpIHtcbiAgICBsZXQgYmFzZVVybCA9IGNvbW1vbkRhdGEuaDVVcmwgPyBjb21tb25EYXRhLmg1VXJsIDogXCJcIjtcbiAgICByZXR1cm4gYCR7YmFzZVVybH0vLS94L2hiL3AvYXBpL2NvbnRlbnRzL2N1cnJlbmN5L2ljb25fcG5nLyR7Y3VycmVuY3kudG9Mb3dlckNhc2UoKX0ucG5nYDtcbn1cblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGdldEluZGV4UHJpY2VCeVN5bWJvbChzeW1ib2wpIHtcbiAgICBsZXQgaW5kZXhQcmljZVJlcU9iaiA9IHtcbiAgICAgICAgc3ltYm9sOiBzeW1ib2xcbiAgICB9O1xuICAgIGNvbnN0IGRhdGEgPSBhd2FpdCBzZW5kUmVxdWVzdChcIm9wdGlvbi92MS9wcmUvaW5kZXhcIiwgaW5kZXhQcmljZVJlcU9iaiwgMCwgOCk7XG4gICAgaWYgKGRhdGEpIHtcbiAgICAgICAgcmV0dXJuIGRhdGE7XG4gICAgfSBlbHNlIHtcbiAgICAgICAgcmV0dXJuIFwiLS1cIjtcbiAgICB9XG59XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiByZXF1ZXN0QWNjb3VudElkKCkge1xuICAgIGNvbnN0IGRhdGEgPSBhd2FpdCBzZW5kUmVxdWVzdCgndjEvYWNjb3VudC9hY2NvdW50cycsIHt9LCAwLCA0KTtcbiAgICBjb25zb2xlLmxvZyhgcmVxdWVzdEFjY291bnRJZCA6ICR7SlNPTi5zdHJpbmdpZnkoZGF0YSl9YClcbiAgICBmb3IgKHZhciBpID0gMDsgaSA8IGRhdGEubGVuZ3RoOyBpKyspIHtcbiAgICAgICAgaWYgKGRhdGFbaV0udHlwZSA9PSBcIm90Yy1vcHRpb25zXCIpIHtcbiAgICAgICAgICAgIGFjY291bnRJZCA9IGRhdGFbaV0uaWRcbiAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICB9XG4gICAgfVxufVxuXG5cbi8v5Y+R6YCB6K+35rGCXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gc2VuZFJlcXVlc3QocGF0aCwgcGFyYW1zID0ge30sIG1ldGhvZCA9IDAsIGhvc3RUeXBlID0gMCwgaGVhZGVyID0ge30pIHtcbiAgICBjb25zb2xlLmxvZyhgcmVxdWVzdCAke3BhdGh9LCBwYXJhbXM6JHtKU09OLnN0cmluZ2lmeShwYXJhbXMpfWApO1xuXG4gICAgaWYgKGhvc3RUeXBlID09IDUgfHwgaG9zdFR5cGUgPT0gNikge1xuICAgICAgICBoZWFkZXJbXCJDb250ZW50LVR5cGVcIl0gPSBcImFwcGxpY2F0aW9uL2pzb25cIjtcbiAgICB9XG4gICAgaGVhZGVyW1wiSEItQ09VTlRSWS1JRFwiXSA9IGNvbW1vbkRhdGEuY291bnRyeUlkO1xuXG4gICAgY29uc3QgcGFyYW0gPSB7XG4gICAgICAgIHBhdGgsXG4gICAgICAgIG1ldGhvZCxcbiAgICAgICAgaG9zdFR5cGUsXG4gICAgICAgIGhlYWRlcixcbiAgICAgICAgcGFyYW1zLFxuICAgIH07XG4gICAgdHJ5IHtcbiAgICAgICAgdmFyIHJlc3BvbnNlU3RyaW5nID0gYXdhaXQgJG5hdGl2ZUFQSS5yZXF1ZXN0KEpTT04uc3RyaW5naWZ5KHBhcmFtKSk7XG4gICAgICAgIHZhciByZXNwb25zZSA9IEpTT04ucGFyc2UocmVzcG9uc2VTdHJpbmcpO1xuICAgICAgICB2YXIgeyBjb2RlLCBkYXRhIH0gPSByZXNwb25zZTtcbiAgICAgICAgaWYgKDggPT0gaG9zdFR5cGUpIHtcbiAgICAgICAgICAgIC8v5ZCI57qm55qE5o6l5Y+j5aSE55CGXG4gICAgICAgICAgICB2YXIgc3RhdHVzID0gcmVzcG9uc2Uuc3RhdHVzO1xuICAgICAgICAgICAgdmFyIGVycl9jb2RlID0gcmVzcG9uc2UuZXJyX2NvZGU7XG4gICAgICAgICAgICB2YXIgZXJyX21zZyA9IHJlc3BvbnNlLmVycl9tc2c7XG4gICAgICAgICAgICBpZiAoc3RhdHVzID09IFwib2tcIikge1xuICAgICAgICAgICAgICAgIGNvbnNvbGUubG9nKGByZXF1ZXN0ICR7cGF0aH0gZG9uZWApO1xuICAgICAgICAgICAgICAgIGlmICh0eXBlb2YgZGF0YSA9PT0gJ251bWJlcicpIHtcbiAgICAgICAgICAgICAgICAgICAgbGV0IHN0YXJ0ID0gYFwiZGF0YVwiOmA7XG4gICAgICAgICAgICAgICAgICAgIGxldCBzdGFydEluZGV4ID0gcmVzcG9uc2VTdHJpbmcuaW5kZXhPZihzdGFydCk7XG4gICAgICAgICAgICAgICAgICAgIGxldCBlbmQgPSBgLFwidHNcIjpgO1xuICAgICAgICAgICAgICAgICAgICBsZXQgZW5kSW5kZXggPSByZXNwb25zZVN0cmluZy5pbmRleE9mKGVuZCk7XG4gICAgICAgICAgICAgICAgICAgIGxldCBkYXRhU3RyaW5nID0gcmVzcG9uc2VTdHJpbmcuc3Vic3RyaW5nKHN0YXJ0SW5kZXggKyBzdGFydC5sZW5ndGgsIGVuZEluZGV4KTtcbiAgICAgICAgICAgICAgICAgICAgY29uc29sZS5sb2coYGRhdGEgaXMgdHlwZW9mIG51bWJlciwgZGF0YVN0cmluZyA9ICR7ZGF0YVN0cmluZ31gKTtcbiAgICAgICAgICAgICAgICAgICAgcmV0dXJuIGRhdGFTdHJpbmc7XG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgIHJldHVybiBkYXRhO1xuICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgICBjb25zb2xlLmxvZyhgcmVxdWVzdCBmYWlsZWQsIGNvZGU9JHtlcnJfY29kZX0sIG1lc3NhZ2U9JHtlcnJfbXNnfWApO1xuICAgICAgICAgICAgICAgIGlmIChtZXRob2QgIT0gMCkge1xuICAgICAgICAgICAgICAgICAgICBzaG93VG9hc3QoZXJyX21zZyk7XG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgIHJldHVybiBudWxsO1xuICAgICAgICAgICAgfVxuICAgICAgICB9IGVsc2UgaWYgKGNvZGUgPT0gMjAwIHx8IHJlc3BvbnNlLnN0YXR1cyA9PSBcIm9rXCIpIHtcbiAgICAgICAgICAgIGNvbnNvbGUubG9nKGByZXF1ZXN0ICR7cGF0aH0gZG9uZWApO1xuICAgICAgICAgICAgcmV0dXJuIGRhdGE7XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICBjb25zb2xlLmxvZyhgcmVxdWVzdCBmYWlsZWQsIGNvZGU9JHtjb2RlfWApO1xuICAgICAgICAgICAgbGV0IG1lc3NhZ2UgPSByZXNwb25zZS5tZXNzYWdlO1xuICAgICAgICAgICAgaWYgKG1ldGhvZCAhPSAwICYmIG1lc3NhZ2UpIHtcbiAgICAgICAgICAgICAgICBzaG93VG9hc3QobWVzc2FnZSk7XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICByZXR1cm4gbnVsbDtcbiAgICAgICAgfVxuICAgIH0gY2F0Y2ggKGUpIHtcbiAgICAgICAgY29uc29sZS5sb2coYHJlcXVlc3QgZXJyb3IsIGVycm9yPSR7ZX1gKTtcbiAgICAgICAgcmV0dXJuIG51bGw7XG4gICAgfVxufVxuXG4vL3RvYXN0XG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gc2hvd1RvYXN0KG1zZykge1xuICAgIGF3YWl0ICRuYXRpdmVBUEkuaGJUb2FzdChtc2cpO1xufVxuXG4vKipcbiAqIFxuICogQHBhcmFtIHtib29sZWFufSBpc1Nob3cg5piv5ZCm5pi+56S65Yqg6L295qGGXG4gKi9cbmV4cG9ydCBmdW5jdGlvbiBzaG93TG9hZGluZyhpc1Nob3cgPSB0cnVlKSB7XG4gICAgJG5hdGl2ZUFQSS5zaG93TG9hZGluZyhpc1Nob3cgPyAxIDogMCk7XG59XG5cbi8qKlxuICogXG4gKiBAcGFyYW0ge+aXtumXtOaXpeacn+agvOW8j+WMln0gZm10IHl5eXktTU0tZGQgaGg6bW06c3NcbiAqIEByZXR1cm5zIOagvOW8j+WMluS5i+WQjueahCDlrZfnrKbkuLLvvIznlKjms5XkvovlpoIgbmV3IERhdGUo5pe26Ze05oizKS5Gb3JtYXQoXCJ5eXl5LU1NLWRkIGhoOm1tOnNzXCIpXG4gKi9cbkRhdGUucHJvdG90eXBlLkZvcm1hdCA9IGZ1bmN0aW9uIChmbXQpIHtcbiAgICB2YXIgbyA9IHtcbiAgICAgICAgXCJNK1wiOiB0aGlzLmdldE1vbnRoKCkgKyAxLCAvL+aciOS7vSBcbiAgICAgICAgXCJkK1wiOiB0aGlzLmdldERhdGUoKSwgLy/ml6UgXG4gICAgICAgIFwiaCtcIjogdGhpcy5nZXRIb3VycygpLCAvL+Wwj+aXtiBcbiAgICAgICAgXCJtK1wiOiB0aGlzLmdldE1pbnV0ZXMoKSwgLy/liIYgXG4gICAgICAgIFwicytcIjogdGhpcy5nZXRTZWNvbmRzKCksIC8v56eSIFxuICAgICAgICBcInErXCI6IE1hdGguZmxvb3IoKHRoaXMuZ2V0TW9udGgoKSArIDMpIC8gMyksIC8v5a2j5bqmIFxuICAgICAgICBcIlNcIjogdGhpcy5nZXRNaWxsaXNlY29uZHMoKSAvL+avq+enkiBcbiAgICB9O1xuICAgIGlmICgvKHkrKS8udGVzdChmbXQpKSBmbXQgPSBmbXQucmVwbGFjZShSZWdFeHAuJDEsICh0aGlzLmdldEZ1bGxZZWFyKCkgKyBcIlwiKS5zdWJzdHIoNCAtIFJlZ0V4cC4kMS5sZW5ndGgpKTtcbiAgICBmb3IgKHZhciBrIGluIG8pXG4gICAgICAgIGlmIChuZXcgUmVnRXhwKFwiKFwiICsgayArIFwiKVwiKS50ZXN0KGZtdCkpIGZtdCA9IGZtdC5yZXBsYWNlKFJlZ0V4cC4kMSwgKFJlZ0V4cC4kMS5sZW5ndGggPT0gMSkgPyAob1trXSkgOiAoKFwiMDBcIiArIG9ba10pLnN1YnN0cigoXCJcIiArIG9ba10pLmxlbmd0aCkpKTtcbiAgICByZXR1cm4gZm10O1xufVxuXG4vL+i/m+ihjOeyvuW6puWkhOeQhlxuZXhwb3J0IGZ1bmN0aW9uIGZvcm1hdFByZWNpc2lvbih2YWx1ZSwgcHJlY2lzaW9uKSB7XG4gICAgdHJ5IHtcbiAgICAgICAgY29uc3QgcmVzdWx0ID0gbnVtYmVyLmZvcm1hdCh2YWx1ZSwgcHJlY2lzaW9uKTtcbiAgICAgICAgcmV0dXJuIHJlc3VsdDtcbiAgICB9IGNhdGNoIChlKSB7XG4gICAgICAgIGNvbnNvbGUubG9nKGUpO1xuICAgICAgICByZXR1cm4gdmFsdWUudG9GaXhlZChwcmVjaXNpb24pO1xuICAgIH1cbn1cblxuLy/ojrflj5bku7fmoLzmmL7npLrmlofmnKxcbmV4cG9ydCBmdW5jdGlvbiBnZXRQcmljZVN0cmluZyhwcmljZVN0ciwgcHJlY2lzaW9uKSB7XG4gICAgY29uc3QgcHJpY2VOdW0gPSBOdW1iZXIocHJpY2VTdHIpO1xuICAgIGNvbnN0IGJpZ1ZhbHVlID0gbmV3IEJpZyhwcmljZU51bSk7XG4gICAgY29uc3QgcHJpY2VTdHJpbmcgPSBwcmVjaXNpb24gPT0gLTEgPyBiaWdWYWx1ZS50b1N0cmluZygpIDogYmlnVmFsdWUudG9GaXhlZChwcmVjaXNpb24pO1xuICAgIGNvbnN0IGZpbmFsUHJpY2VTdHIgPSBwcmljZVN0cmluZy5yZXBsYWNlKC9cXGQrLywgZnVuY3Rpb24gKG4pIHsgLy8g5YWI5o+Q5Y+W5pW05pWw6YOo5YiGXG4gICAgICAgIHJldHVybiBuLnJlcGxhY2UoLyhcXGQpKD89KFxcZHszfSkrJCkvZywgZnVuY3Rpb24gKCQxKSB7XG4gICAgICAgICAgICByZXR1cm4gJDEgKyBcIixcIjtcbiAgICAgICAgfSk7XG4gICAgfSlcbiAgICAvLyBjb25zdCBmaW5hbFByaWNlU3RyID0gcHJpY2VTdHJpbmcudG9TdHJpbmcoKS5yZXBsYWNlKC9cXEIoPz0oXFxkezN9KSsoPyFcXGQpKS9nLCBcIixcIik7XG4gICAgcmV0dXJuIGZpbmFsUHJpY2VTdHI7XG59XG5cbi8vIOa2qOi3jOiJsiBpc1Jpc2Ug77yaIHRydWUgb3IgZmFsc2VcbmV4cG9ydCBmdW5jdGlvbiBnZXRQcmljZUNvbG9yKGlzUmlzZSkge1xuICAgIGlmIChpc1Jpc2UpIHtcbiAgICAgICAgcmV0dXJuIGNvbW1vbkRhdGEucHJpY2VDb2xvclR5cGUgPT0gMSA/IFwiIzAwQTE3MVwiIDogXCIjRTk0MzU5XCI7XG4gICAgfSBlbHNlIHtcbiAgICAgICAgcmV0dXJuIGNvbW1vbkRhdGEucHJpY2VDb2xvclR5cGUgPT0gMCA/IFwiIzAwQTE3MVwiIDogXCIjRTk0MzU5XCI7XG4gICAgfVxufVxuXG4vL+WuueWZqOi/lOWbnuiDveWKm1xuZXhwb3J0IGZ1bmN0aW9uIGNvbnRhaW5lckJhY2socGFyYW1zID0gMCkge1xuICAgIGNvbnNvbGUubG9nKFwiY29udGFpbmVyQmFja1wiKVxuICAgICRuYXRpdmVBUEkuY29udGFpbmVyQmFjayhwYXJhbXMpXG59XG5cbi8vIOaJk+W8gEg16aG16Z2i77yM5Lyg5YWl6Lev5b6E77yM5ou85o6l5Z+f5ZCNXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gb3BlblBhZ2VXaXRoUGF0aCh1cmxQYXRoKSB7XG4gICAgY29uc29sZS5sb2coYG9wZW5INVdpdGhQYXRoOmAsIHVybFBhdGgpO1xuICAgIGlmICh1cmxQYXRoICYmIHVybFBhdGggIT0gbnVsbCkge1xuICAgICAgICBpZiAodXJsUGF0aC5pbmRleE9mKFwiaG9saWdlaXRcIikgPT0gMCB8fCB1cmxQYXRoLmluZGV4T2YoXCJodHRwXCIpID09IDApIHtcbiAgICAgICAgICAgIG9wZW5VUkwodXJsUGF0aCk7XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICBvcGVuVVJMKGAke2NvbW1vbkRhdGEuaDVVcmx9LyR7Y29tbW9uRGF0YS5sYW5ndWFnZX0ke3VybFBhdGh9YCk7XG4gICAgICAgIH1cbiAgICB9XG59XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBnZXRMZWdhbEN1cnJlbmN5U3ltYm9sKCkge1xuICAgIGNvbnN0IGN1cnJlbmN5U3ltYm9sID0gYXdhaXQgJG5hdGl2ZUFQSS5jdXJyZW5jeUNvbW1vbigne1widHlwZVwiOjl9Jyk7XG4gICAgcmV0dXJuIGN1cnJlbmN5U3ltYm9sO1xufVxuXG4vLyDku7fmoLzovazmjaJcbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBjb252ZXJ0TGVnYWxUZW5kZXIoc3ltYm9sLCBhbW91bnQsIGN1cnJlbmN5U2NhbGUpIHtcbiAgICBpZiAoIWFtb3VudCkge1xuICAgICAgICBhbW91bnQgPSAnMCc7XG4gICAgfVxuXHR2YXIgcGFyYW0gPSB7XG5cdFx0dHlwZTogMSxcblx0XHRjdXJyZW5jeTogc3ltYm9sLFxuXHRcdGFtb3VudFxuXHR9O1xuXHRpZiAoY3VycmVuY3lTY2FsZSA+IDApIHtcblx0XHRwYXJhbSA9IHtcblx0XHRcdHR5cGU6IDExMSxcblx0XHRcdGN1cnJlbmN5OiBzeW1ib2wsXG5cdFx0XHRhbW91bnQsXG5cdFx0XHRjdXJyZW5jeVNjYWxlXG5cdFx0fVxuXHR9XG4gICAgY29uc3QgcGFyYW1TdHJpbmcgPSBKU09OLnN0cmluZ2lmeShwYXJhbSk7XG4gICAgcmV0dXJuIGF3YWl0ICRuYXRpdmVBUEkuY3VycmVuY3lDb21tb24ocGFyYW1TdHJpbmcpO1xufVxuXG4vL+i/m+ihjOeyvuW6puWkhOeQhiwg5pyJ5aSE55CG5LmL5ZCOIDwg57K+5bqm5pyA5aSn5YC8XG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gZm9ybWF0QnlNaW5QcmVjaXNpb24oYW1vdW50LCBwcmVjaXNpb24pIHtcbiAgICBpZiAoIWFtb3VudCkge1xuICAgICAgICBhbW91bnQgPSAnMC4wMCc7XG4gICAgfVxuXHRpZiAoIXByZWNpc2lvbikge1xuXHRcdHByZWNpc2lvbiA9IDI7XG5cdH1cblx0dmFyIHBhcmFtID0ge1xuXHRcdHR5cGU6IDExMixcblx0XHRhbW91bnQsXG5cdFx0cHJlY2lzaW9uLFxuXHR9O1xuICAgIGNvbnN0IHBhcmFtU3RyaW5nID0gSlNPTi5zdHJpbmdpZnkocGFyYW0pO1xuICAgIHJldHVybiBhd2FpdCAkbmF0aXZlQVBJLmN1cnJlbmN5Q29tbW9uKHBhcmFtU3RyaW5nKTtcbn1cblxuZXhwb3J0IGZ1bmN0aW9uIGFkZEN1cnJlbmN5U3ltYm9sKGN1cnJlbmN5U3ltYm9sLCBzb3VyY2UpIHtcbiAgICBpZiAoc291cmNlID09PSAnLS0nKSB7XG4gICAgICAgIHJldHVybiBzb3VyY2U7XG4gICAgfVxuICAgIGVsc2UgaWYgKHNvdXJjZSAmJiBzb3VyY2UgIT09IERFRkFVTFRfU1RSKSB7XG4gICAgICAgIGlmIChzb3VyY2Uuc3RhcnRzV2l0aCgnLScpKSB7XG5cdFx0XHRpZiAoY3VycmVuY3lTeW1ib2wgPT0gXCLigq5cIikge1xuXHRcdFx0XHRyZXR1cm4gYC0ke3NvdXJjZS5zdWJzdHJpbmcoMSl9IFVTRFRgO1xuXHRcdFx0fVxuICAgICAgICAgICAgcmV0dXJuIGAtJHtjdXJyZW5jeVN5bWJvbH0ke3NvdXJjZS5zdWJzdHJpbmcoMSl9YDtcbiAgICAgICAgfVxuXHRcdGlmIChjdXJyZW5jeVN5bWJvbCA9PSBcIuKCrlwiKSB7XG5cdFx0XHRyZXR1cm4gYCR7c291cmNlfSBVU0RUYDtcblx0XHR9XG4gICAgICAgIHJldHVybiBgJHtjdXJyZW5jeVN5bWJvbH0ke3NvdXJjZX1gO1xuICAgIH0gZWxzZSB7XG5cdFx0aWYgKGN1cnJlbmN5U3ltYm9sID09IFwi4oKuXCIpIHtcblx0XHRcdHJldHVybiBgJHtERUZBVUxUX1NUUn0gVVNEVGA7XG5cdFx0fVxuICAgICAgICByZXR1cm4gYCR7Y3VycmVuY3lTeW1ib2x9JHtERUZBVUxUX1NUUn1gO1xuICAgIH1cbn1cbiIsImltcG9ydCAqIGFzIGNvbW1vbiBmcm9tIFwiLi9jb21tb25cIjtcbmltcG9ydCAqIGFzIG51bWJlciBmcm9tIFwiLi9udW1iZXJcIjtcblxudmFyIHN0cnVjdHVyZWRfZHVhbERhdGEgPSB7XG5cdHFhRGF0YTogW3tcblx0XHR0eXBlOiAnUUEnLFxuXHRcdGluZGV4OiAwLFxuXHRcdGFuc3dlclZpc2FibGU6ICdnb25lJyxcblx0XHRROiAkaTE4bi5uX3N0cnV0dXJlZF9RX2R1YWwsXG5cdFx0QTogJGkxOG4ubl9zdHJ1dHVyZWRfQV9kdWFsLFxuXHRcdEExOiBcIlwiLFxuXHRcdEEyOiBcIlwiLFxuXHRcdEEzOiBcIlwiLFxuXHRcdEE0OiBcIlwiLFxuXHRcdEE1OiBcIlwiLFxuXHRcdEExU2hvdzogXCJnb25lXCIsXG5cdFx0QTJTaG93OiBcImdvbmVcIixcblx0XHRBM1Nob3c6IFwiZ29uZVwiLFxuXHRcdEE0U2hvdzogXCJnb25lXCIsXG5cdFx0QTVTaG93OiBcImdvbmVcIixcblx0XHRxYUljb246IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX3NoYXJrX2hvbWVfcWFfc3ByZWFkX2ljb25cIixcblx0fSwge1xuXHRcdHR5cGU6ICdRQScsXG5cdFx0aW5kZXg6IDEsXG5cdFx0YW5zd2VyVmlzYWJsZTogJ2dvbmUnLFxuXHRcdFE6ICRpMThuLm5fZG91YmxlX2NvaW5fZWFybl9pc3N1ZV90d28sXG5cdFx0QTogJGkxOG4ubl9kb3VibGVfY29pbl9lYXJuX2Fuc3dlcl90d29fcGFydF9vbmUsXG5cdFx0QTE6ICRpMThuLm5fZG91YmxlX2NvaW5fZWFybl9hbnN3ZXJfdHdvX3BhcnRfdHdvLFxuXHRcdEEyOiBcIlwiLFxuXHRcdEEzOiBcIlwiLFxuXHRcdEE0OiBcIlwiLFxuXHRcdEE1OiBcIlwiLFxuXHRcdEExU2hvdzogXCJ2aXNpYmxlXCIsXG5cdFx0QTJTaG93OiBcImdvbmVcIixcblx0XHRBM1Nob3c6IFwiZ29uZVwiLFxuXHRcdEE0U2hvdzogXCJnb25lXCIsXG5cdFx0QTVTaG93OiBcImdvbmVcIixcblx0XHRxYUljb246IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX3NoYXJrX2hvbWVfcWFfc3ByZWFkX2ljb25cIixcblx0fSwge1xuXHRcdHR5cGU6ICdRQScsXG5cdFx0aW5kZXg6IDIsXG5cdFx0YW5zd2VyVmlzYWJsZTogJ2dvbmUnLFxuXHRcdFE6ICRpMThuLm5fZG91YmxlX2NvaW5fZWFybl9pc3N1ZV90aHJlZSxcblx0XHRBOiAkaTE4bi5uX2RvdWJsZV9jb2luX2Vhcm5fYW5zd2VyX3RocmVlX3BhcnRfb25lLFxuXHRcdEExOiAkaTE4bi5uX2RvdWJsZV9jb2luX2Vhcm5fYW5zd2VyX3RocmVlX3BhcnRfdHdvLFxuXHRcdEEyOiAkaTE4bi5uX2RvdWJsZV9jb2luX2Vhcm5fYW5zd2VyX3RocmVlX3BhcnRfdGhyZWUsXG5cdFx0QTM6IFwiXCIsXG5cdFx0QTQ6IFwiXCIsXG5cdFx0QTU6IFwiXCIsXG5cdFx0QTFTaG93OiBcInZpc2libGVcIixcblx0XHRBMlNob3c6IFwidmlzaWJsZVwiLFxuXHRcdEEzU2hvdzogXCJnb25lXCIsXG5cdFx0QTRTaG93OiBcImdvbmVcIixcblx0XHRBNVNob3c6IFwiZ29uZVwiLFxuXHRcdHFhSWNvbjogXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfc2hhcmtfaG9tZV9xYV9zcHJlYWRfaWNvblwiLFxuXHR9LCB7XG5cdFx0dHlwZTogJ1FBJyxcblx0XHRpbmRleDogMyxcblx0XHRhbnN3ZXJWaXNhYmxlOiAnZ29uZScsXG5cdFx0UTogJGkxOG4ubl9kb3VibGVfY29pbl9lYXJuX2lzc3VlX2ZvdXJfbmV3LFxuXHRcdEE6ICRpMThuLm5fZG91YmxlX2NvaW5fZWFybl9hbnN3ZXJfZm91cixcblx0XHRBMTogXCJcIixcblx0XHRBMjogXCJcIixcblx0XHRBMzogXCJcIixcblx0XHRBNDogXCJcIixcblx0XHRBNTogXCJcIixcblx0XHRBMVNob3c6IFwiZ29uZVwiLFxuXHRcdEEyU2hvdzogXCJnb25lXCIsXG5cdFx0QTNTaG93OiBcImdvbmVcIixcblx0XHRBNFNob3c6IFwiZ29uZVwiLFxuXHRcdEE1U2hvdzogXCJnb25lXCIsXG5cdFx0cWFJY29uOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9zaGFya19ob21lX3FhX3NwcmVhZF9pY29uXCIsXG5cdH0sIHtcblx0XHR0eXBlOiAnUUEnLFxuXHRcdGluZGV4OiA0LFxuXHRcdGFuc3dlclZpc2FibGU6ICdnb25lJyxcblx0XHRROiAkaTE4bi5uX2RvdWJsZV9jb2luX2Vhcm5faXNzdWVfZml2ZSxcblx0XHRBOiAkaTE4bi5uX2RvdWJsZV9jb2luX2Vhcm5fYW5zd2VyX2ZpdmVfcGFydF9vbmUsXG5cdFx0QTE6ICRpMThuLm5fZG91YmxlX2NvaW5fZWFybl9hbnN3ZXJfZml2ZV9wYXJ0X3R3b19jLFxuXHRcdEEyOiBcIlwiLFxuXHRcdEEzOiBcIlwiLFxuXHRcdEE0OiBcIlwiLFxuXHRcdEE1OiBcIlwiLFxuXHRcdEExU2hvdzogXCJ2aXNpYmxlXCIsXG5cdFx0QTJTaG93OiBcImdvbmVcIixcblx0XHRBM1Nob3c6IFwiZ29uZVwiLFxuXHRcdEE0U2hvdzogXCJnb25lXCIsXG5cdFx0QTVTaG93OiBcImdvbmVcIixcblx0XHRxYUljb246IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX3NoYXJrX2hvbWVfcWFfc3ByZWFkX2ljb25cIixcblx0fV0sXG5cdG1vcmVEYXRhOiBbe1xuXHRcdHR5cGU6IFwibW9yZVwiLFxuXHRcdGluZGV4OiAwLFxuXHRcdG5hbWU6ICRpMThuLm5fc3RydXR1cmVkX21vcmVfc2ltcGxlLFxuXHRcdGRlc2M6ICRpMThuLm5fc3RydXR1cmVkX21vcmVfc2ltcGxlX2RldGFpbCxcblx0XHRpY29uOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9zdHJ1dHVyZWRfZWFzeVwiLFxuXHRcdGp1bXBQYXRoOiBcIi9maW5hbmNpYWwvZWFybi9oNS9uZXdEZXRhaWw/YWN0aXZlVGFiPTBcIixcblx0fSwge1xuXHRcdHR5cGU6IFwibW9yZVwiLFxuXHRcdGluZGV4OiAxLFxuXHRcdG5hbWU6ICRpMThuLm5fc3RydXR1cmVkX21vcmVfbmV3LFxuXHRcdGRlc2M6ICRpMThuLm5fc3RydXR1cmVkX2Rlc2MsXG5cdFx0aWNvbjogXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfc3RydXR1cmVkX3VwZGF0ZVwiLFxuXHRcdGp1bXBQYXRoOiBcIi9maW5hbmNpYWwvZWFybi9oNS9uZXdMaXN0aW5nXCIsXG5cdH0sIHtcblx0XHR0eXBlOiBcIm1vcmVcIixcblx0XHRpbmRleDogMixcblx0XHRuYW1lOiAkaTE4bi5uX3N0cnV0dXJlZF9tb3JlX29uY2hhaW4sXG5cdFx0ZGVzYzogJGkxOG4ubl9zdHJ1dHVyZWRfbW9yZV9vbmNoYWluX2RldGFpbCxcblx0XHRpY29uOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9zdHJ1dHVyZWRfb25jaGFpblwiLFxuXHRcdGp1bXBQYXRoOiBcIi9maW5hbmNpYWwvZWFybi9oNS9zdGFja1Byb1wiLFxuXHR9LCB7XG5cdFx0dHlwZTogXCJkaXZcIlxuXHR9XSxcblx0Y29pbkRhdGE6IFtdXG59O1xuXG52YXIgc3RydWN0dXJlZF9zaGFya2ZpbkRhdGEgPSB7XG5cdHFhRGF0YTogW3tcblx0XHR0eXBlOiAnUUEnLFxuXHRcdGluZGV4OiAwLFxuXHRcdGFuc3dlclZpc2FibGU6ICdnb25lJyxcblx0XHRROiAkaTE4bi5uX3NoYXJrX2Zpbl9jb21tb25fcHJvYmxlbV9vbmUsXG5cdFx0QTogJGkxOG4ubl9zaGFya19maW5fY29tbW9uX2Fuc3dlcl9vbmUsXG5cdFx0QTE6IFwiXCIsXG5cdFx0QTI6IFwiXCIsXG5cdFx0QTM6IFwiXCIsXG5cdFx0QTQ6IFwiXCIsXG5cdFx0QTU6IFwiXCIsXG5cdFx0QTFTaG93OiBcImdvbmVcIixcblx0XHRBMlNob3c6IFwiZ29uZVwiLFxuXHRcdEEzU2hvdzogXCJnb25lXCIsXG5cdFx0QTRTaG93OiBcImdvbmVcIixcblx0XHRBNVNob3c6IFwiZ29uZVwiLFxuXHRcdHFhSWNvbjogXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfc2hhcmtfaG9tZV9xYV9zcHJlYWRfaWNvblwiLFxuXHR9LCB7XG5cdFx0dHlwZTogJ1FBJyxcblx0XHRpbmRleDogMSxcblx0XHRhbnN3ZXJWaXNhYmxlOiAnZ29uZScsXG5cdFx0UTogJGkxOG4ubl9zaGFya19maW5fY29tbW9uX3Byb2JsZW1fdHdvLFxuXHRcdEE6ICRpMThuLm5fc2hhcmtfZmluX2NvbW1vbl9hbnN3ZXJfdHdvX25ldyxcblx0XHRBMTogXCJcIixcblx0XHRBMjogXCJcIixcblx0XHRBMzogXCJcIixcblx0XHRBNDogXCJcIixcblx0XHRBNTogXCJcIixcblx0XHRBMVNob3c6IFwiZ29uZVwiLFxuXHRcdEEyU2hvdzogXCJnb25lXCIsXG5cdFx0QTNTaG93OiBcImdvbmVcIixcblx0XHRBNFNob3c6IFwiZ29uZVwiLFxuXHRcdEE1U2hvdzogXCJnb25lXCIsXG5cdFx0cWFJY29uOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9zaGFya19ob21lX3FhX3NwcmVhZF9pY29uXCIsXG5cdH0sIHtcblx0XHR0eXBlOiAnUUEnLFxuXHRcdGluZGV4OiAyLFxuXHRcdGFuc3dlclZpc2FibGU6ICdnb25lJyxcblx0XHRROiAkaTE4bi5uX3NoYXJrX2Zpbl9jb21tb25fcHJvYmxlbV90aHJlZSxcblx0XHRBOiAkaTE4bi5uX3NoYXJrX2Zpbl9jb21tb25fYW5zd2VyX3RocmVlLFxuXHRcdEExOiBcIlwiLFxuXHRcdEEyOiBcIlwiLFxuXHRcdEEzOiBcIlwiLFxuXHRcdEE0OiBcIlwiLFxuXHRcdEE1OiBcIlwiLFxuXHRcdEExU2hvdzogXCJnb25lXCIsXG5cdFx0QTJTaG93OiBcImdvbmVcIixcblx0XHRBM1Nob3c6IFwiZ29uZVwiLFxuXHRcdEE0U2hvdzogXCJnb25lXCIsXG5cdFx0QTVTaG93OiBcImdvbmVcIixcblx0XHRxYUljb246IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX3NoYXJrX2hvbWVfcWFfc3ByZWFkX2ljb25cIixcblx0fSwge1xuXHRcdHR5cGU6ICdRQScsXG5cdFx0aW5kZXg6IDMsXG5cdFx0YW5zd2VyVmlzYWJsZTogJ2dvbmUnLFxuXHRcdFE6ICRpMThuLm5fc2hhcmtfZmluX2NvbW1vbl9wcm9ibGVtX2ZvdXIsXG5cdFx0QTogJGkxOG4ubl9zaGFya19maW5fY29tbW9uX2Fuc3dlcl9mb3VyX2MsXG5cdFx0QTE6IFwiXCIsXG5cdFx0QTI6IFwiXCIsXG5cdFx0QTM6IFwiXCIsXG5cdFx0QTQ6IFwiXCIsXG5cdFx0QTU6IFwiXCIsXG5cdFx0QTFTaG93OiBcImdvbmVcIixcblx0XHRBMlNob3c6IFwiZ29uZVwiLFxuXHRcdEEzU2hvdzogXCJnb25lXCIsXG5cdFx0QTRTaG93OiBcImdvbmVcIixcblx0XHRBNVNob3c6IFwiZ29uZVwiLFxuXHRcdHFhSWNvbjogXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfc2hhcmtfaG9tZV9xYV9zcHJlYWRfaWNvblwiLFxuXHR9LCB7XG5cdFx0dHlwZTogJ1FBJyxcblx0XHRpbmRleDogNCxcblx0XHRhbnN3ZXJWaXNhYmxlOiAnZ29uZScsXG5cdFx0UTogJGkxOG4ubl9zaGFya19maW5fY29tbW9uX3Byb2JsZW1fZml2ZV9uZXcsXG5cdFx0QTogJGkxOG4ubl9zaGFya19maW5fY29tbW9uX2Fuc3dlcl9maXZlX25ld19jLFxuXHRcdEExOiBcIlwiLFxuXHRcdEEyOiBcIlwiLFxuXHRcdEEzOiBcIlwiLFxuXHRcdEE0OiBcIlwiLFxuXHRcdEE1OiBcIlwiLFxuXHRcdEExU2hvdzogXCJnb25lXCIsXG5cdFx0QTJTaG93OiBcImdvbmVcIixcblx0XHRBM1Nob3c6IFwiZ29uZVwiLFxuXHRcdEE0U2hvdzogXCJnb25lXCIsXG5cdFx0QTVTaG93OiBcImdvbmVcIixcblx0XHRxYUljb246IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX3NoYXJrX2hvbWVfcWFfc3ByZWFkX2ljb25cIixcblx0fSwge1xuXHRcdHR5cGU6ICdRQScsXG5cdFx0aW5kZXg6IDUsXG5cdFx0YW5zd2VyVmlzYWJsZTogJ2dvbmUnLFxuXHRcdFE6ICRpMThuLm5fc2hhcmtfZmluX2NvbW1vbl9wcm9ibGVtX3NpeCxcblx0XHRBOiAkaTE4bi5uX3NoYXJrX2Zpbl9jb21tb25fYW5zd2VyX3NpeCxcblx0XHRBMTogXCJcIixcblx0XHRBMjogXCJcIixcblx0XHRBMzogXCJcIixcblx0XHRBNDogXCJcIixcblx0XHRBNTogXCJcIixcblx0XHRBMVNob3c6IFwiZ29uZVwiLFxuXHRcdEEyU2hvdzogXCJnb25lXCIsXG5cdFx0QTNTaG93OiBcImdvbmVcIixcblx0XHRBNFNob3c6IFwiZ29uZVwiLFxuXHRcdEE1U2hvdzogXCJnb25lXCIsXG5cdFx0cWFJY29uOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9zaGFya19ob21lX3FhX3NwcmVhZF9pY29uXCIsXG5cdH0sIHtcblx0XHR0eXBlOiAnUUEnLFxuXHRcdGluZGV4OiA2LFxuXHRcdGFuc3dlclZpc2FibGU6ICdnb25lJyxcblx0XHRROiAkaTE4bi5uX3NoYXJrX2Zpbl9jb21tb25fcHJvYmxlbV9zaXhfYSxcblx0XHRBOiAkaTE4bi5uX3NoYXJrX2Zpbl9jb21tb25fYW5zd2VyX3NpeF9hX2ZpcnN0X25ldyxcblx0XHRBMTogJGkxOG4ubl9zaGFya19maW5fY29tbW9uX2Fuc3dlcl9zaXhfYV9zZWNvbmRfbmV3LFxuXHRcdEEyOiBcIlwiLFxuXHRcdEEzOiBcIlwiLFxuXHRcdEE0OiBcIlwiLFxuXHRcdEE1OiBcIlwiLFxuXHRcdEExU2hvdzogXCJ2aXNpYmxlXCIsXG5cdFx0QTJTaG93OiBcImdvbmVcIixcblx0XHRBM1Nob3c6IFwiZ29uZVwiLFxuXHRcdEE0U2hvdzogXCJnb25lXCIsXG5cdFx0QTVTaG93OiBcImdvbmVcIixcblx0XHRxYUljb246IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX3NoYXJrX2hvbWVfcWFfc3ByZWFkX2ljb25cIixcblx0fSwge1xuXHRcdHR5cGU6ICdRQScsXG5cdFx0aW5kZXg6IDcsXG5cdFx0YW5zd2VyVmlzYWJsZTogJ2dvbmUnLFxuXHRcdFE6ICRpMThuLm5fc2hhcmtfZmluX2NvbW1vbl9wcm9ibGVtX3NldmVuLFxuXHRcdEE6ICRpMThuLm5fc2hhcmtfZmluX2NvbW1vbl9hbnN3ZXJfc2V2ZW5fYV9maXJzdCxcblx0XHRBMTogJGkxOG4ubl9zaGFya19maW5fY29tbW9uX2Fuc3dlcl9zZXZlbl9hX3NlY29uZCxcblx0XHRBMjogJGkxOG4ubl9zaGFya19maW5fY29tbW9uX2Fuc3dlcl9zZXZlbl9hX3RoaXJkLFxuXHRcdEEzOiAkaTE4bi5uX3NoYXJrX2Zpbl9jb21tb25fYW5zd2VyX3NldmVuX2FfZm91cixcblx0XHRBNDogJGkxOG4ubl9zaGFya19maW5fY29tbW9uX2Fuc3dlcl9zZXZlbl9zZWNvbmQsXG5cdFx0QTU6ICRpMThuLm5fc2hhcmtfZmluX2NvbW1vbl9hbnN3ZXJfc2V2ZW5fdGhpcmQsXG5cdFx0QTFTaG93OiBcInZpc2libGVcIixcblx0XHRBMlNob3c6IFwidmlzaWJsZVwiLFxuXHRcdEEzU2hvdzogXCJ2aXNpYmxlXCIsXG5cdFx0QTRTaG93OiBcInZpc2libGVcIixcblx0XHRBNVNob3c6IFwidmlzaWJsZVwiLFxuXHRcdHFhSWNvbjogXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfc2hhcmtfaG9tZV9xYV9zcHJlYWRfaWNvblwiLFxuXHR9LCB7XG5cdFx0dHlwZTogJ1FBJyxcblx0XHRpbmRleDogOCxcblx0XHRhbnN3ZXJWaXNhYmxlOiAnZ29uZScsXG5cdFx0UTogJGkxOG4ubl9zaGFya19maW5fY29tbW9uX3Byb2JsZW1fZWlnaHQsXG5cdFx0QTogJGkxOG4ubl9zaGFya19maW5fY29tbW9uX2Fuc3dlcl9laWdodF9uZXdfYyxcblx0XHRBMTogXCJcIixcblx0XHRBMjogXCJcIixcblx0XHRBMzogXCJcIixcblx0XHRBNDogXCJcIixcblx0XHRBNTogXCJcIixcblx0XHRBMVNob3c6IFwiZ29uZVwiLFxuXHRcdEEyU2hvdzogXCJnb25lXCIsXG5cdFx0QTNTaG93OiBcImdvbmVcIixcblx0XHRBNFNob3c6IFwiZ29uZVwiLFxuXHRcdEE1U2hvdzogXCJnb25lXCIsXG5cdFx0cWFJY29uOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9zaGFya19ob21lX3FhX3NwcmVhZF9pY29uXCIsXG5cdH0sIHtcblx0XHR0eXBlOiAnUUEnLFxuXHRcdGluZGV4OiA5LFxuXHRcdGFuc3dlclZpc2FibGU6ICdnb25lJyxcblx0XHRROiAkaTE4bi5uX3NoYXJrX2Zpbl9jb21tb25fcHJvYmxlbV9uaW5lLFxuXHRcdEE6ICRpMThuLm5fc2hhcmtfZmluX2NvbW1vbl9hbnN3ZXJfbmluZV9uZXcsXG5cdFx0QTE6IFwiXCIsXG5cdFx0QTI6IFwiXCIsXG5cdFx0QTM6IFwiXCIsXG5cdFx0QTQ6IFwiXCIsXG5cdFx0QTU6IFwiXCIsXG5cdFx0QTFTaG93OiBcImdvbmVcIixcblx0XHRBMlNob3c6IFwiZ29uZVwiLFxuXHRcdEEzU2hvdzogXCJnb25lXCIsXG5cdFx0QTRTaG93OiBcImdvbmVcIixcblx0XHRBNVNob3c6IFwiZ29uZVwiLFxuXHRcdHFhSWNvbjogXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfc2hhcmtfaG9tZV9xYV9zcHJlYWRfaWNvblwiLFxuXHR9LCB7XG5cdFx0dHlwZTogJ1FBJyxcblx0XHRpbmRleDogMTAsXG5cdFx0YW5zd2VyVmlzYWJsZTogJ2dvbmUnLFxuXHRcdFE6ICRpMThuLm5fc2hhcmtfZmluX2F1dG9TdWJzY3JpYmVfUV8xLFxuXHRcdEE6ICRpMThuLm5fc2hhcmtfZmluX2F1dG9TdWJzY3JpYmVfQV8xXzEsXG5cdFx0QTE6ICRpMThuLm5fc2hhcmtfZmluX2F1dG9TdWJzY3JpYmVfQV8xXzIsXG5cdFx0QTI6IFwiXCIsXG5cdFx0QTM6IFwiXCIsXG5cdFx0QTQ6IFwiXCIsXG5cdFx0QTU6IFwiXCIsXG5cdFx0QTFTaG93OiBcInZpc2libGVcIixcblx0XHRBMlNob3c6IFwiZ29uZVwiLFxuXHRcdEEzU2hvdzogXCJnb25lXCIsXG5cdFx0QTRTaG93OiBcImdvbmVcIixcblx0XHRBNVNob3c6IFwiZ29uZVwiLFxuXHRcdHFhSWNvbjogXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfc2hhcmtfaG9tZV9xYV9zcHJlYWRfaWNvblwiLFxuXHR9LCB7XG5cdFx0dHlwZTogJ1FBJyxcblx0XHRpbmRleDogMTEsXG5cdFx0YW5zd2VyVmlzYWJsZTogJ2dvbmUnLFxuXHRcdFE6ICRpMThuLm5fc2hhcmtfZmluX2F1dG9TdWJzY3JpYmVfUV8yLFxuXHRcdEE6ICRpMThuLm5fc2hhcmtfZmluX2F1dG9TdWJzY3JpYmVfQV8yXzEsXG5cdFx0QTE6ICRpMThuLm5fc2hhcmtfZmluX2F1dG9TdWJzY3JpYmVfQV8yXzIsXG5cdFx0QTI6ICRpMThuLm5fc2hhcmtfZmluX2F1dG9TdWJzY3JpYmVfQV8yXzMsXG5cdFx0QTM6IFwiXCIsXG5cdFx0QTQ6IFwiXCIsXG5cdFx0QTU6IFwiXCIsXG5cdFx0QTFTaG93OiBcInZpc2libGVcIixcblx0XHRBMlNob3c6IFwidmlzaWJsZVwiLFxuXHRcdEEzU2hvdzogXCJnb25lXCIsXG5cdFx0QTRTaG93OiBcImdvbmVcIixcblx0XHRBNVNob3c6IFwiZ29uZVwiLFxuXHRcdHFhSWNvbjogXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfc2hhcmtfaG9tZV9xYV9zcHJlYWRfaWNvblwiLFxuXHR9LCB7XG5cdFx0dHlwZTogJ1FBJyxcblx0XHRpbmRleDogMTIsXG5cdFx0YW5zd2VyVmlzYWJsZTogJ2dvbmUnLFxuXHRcdFE6ICRpMThuLm5fc2hhcmtfZmluX2F1dG9TdWJzY3JpYmVfUV8zLFxuXHRcdEE6ICRpMThuLm5fc2hhcmtfZmluX2F1dG9TdWJzY3JpYmVfQV8zXzEsXG5cdFx0QTE6ICRpMThuLm5fc2hhcmtfZmluX2F1dG9TdWJzY3JpYmVfQV8zXzIsXG5cdFx0QTI6IFwiXCIsXG5cdFx0QTM6IFwiXCIsXG5cdFx0QTQ6IFwiXCIsXG5cdFx0QTU6IFwiXCIsXG5cdFx0QTFTaG93OiBcInZpc2libGVcIixcblx0XHRBMlNob3c6IFwiZ29uZVwiLFxuXHRcdEEzU2hvdzogXCJnb25lXCIsXG5cdFx0QTRTaG93OiBcImdvbmVcIixcblx0XHRBNVNob3c6IFwiZ29uZVwiLFxuXHRcdHFhSWNvbjogXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfc2hhcmtfaG9tZV9xYV9zcHJlYWRfaWNvblwiLFxuXHR9XSxcblx0c2hhcmtmaW5EYXRhOiBbXVxufTtcblxudmFyIHN0cnVjdHVyZWRfb25seU9uZVNlY3Rpb24gPSB7XG5cdHR5cGU6ICdPbmx5T25lJyxcblx0bmFtZTogJGkxOG4ubl9zdHJ1dHVyZWRfb25seW9uZV90aXRsZSxcblx0aWNvbjE6IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX3N0cnV0dXJlZF9vbmx5b25lXzFcIixcblx0dGl0bGUxOiAkaTE4bi5uX3N0cnV0dXJlZF9vbmx5b25lX25hbWVfMSxcblx0ZGVzYzE6ICRpMThuLm5fc3RydXR1cmVkX29ubHlvbmVfZGVzY18xLFxuXHRpY29uMjogXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfc3RydXR1cmVkX29ubHlvbmVfMlwiLFxuXHR0aXRsZTI6ICRpMThuLm5fc3RydXR1cmVkX29ubHlvbmVfbmFtZV8yLFxuXHRkZXNjMjogJGkxOG4ubl9zdHJ1dHVyZWRfb25seW9uZV9kZXNjXzIsXG5cdGljb24zOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9zdHJ1dHVyZWRfb25seW9uZV8zXCIsXG5cdHRpdGxlMzogJGkxOG4ubl9zdHJ1dHVyZWRfb25seW9uZV9uYW1lXzMsXG5cdGRlc2MzOiAkaTE4bi5uX3N0cnV0dXJlZF9vbmx5b25lX2Rlc2NfMyxcbn07XG5cbnZhciBzdHJ1Y3R1cmVkX3Byb2JsZW1TZWN0aW9uID0ge1xuXHR0eXBlOiAnSDEnLFxuXHRuYW1lOiAkaTE4bi5uX3NoYXJrX2Zpbl9jb21tb25fcHJvYmxlbSxcblx0c2hvd01vcmU6IFwidmlzaWJsZVwiLFxuXHR0YWJJbmRleDogMVxufTtcblxudmFyIHN0cnVjdHVyZWRfbW9yZVNlY3Rpb24gPSB7XG5cdHR5cGU6ICdIMScsXG5cdG5hbWU6ICRpMThuLm5fc3RydXR1cmVkX290aGVycyxcblx0c2hvd01vcmU6IFwiZ29uZVwiXG59O1xuXG52YXIgdGFiS2V5ID0gXCJcIjtcbnZhciBpc0Nsb3NlID0gZmFsc2U7XG5cbmZ1bmN0aW9uIGRlZmF1bHREYXRhKCkge1xuXHRyZXR1cm4ge1xuXHRcdHJlZnJlc2g6ICcwJyxcblx0XHRjdXJyZW50SW5kZXg6IDAsXG5cdFx0bWFpbkRhdGE6IGNvbmNhdER1YWxEYXRhKFtdKSxcblx0XHRkdWFsVGFiOiB7XG5cdFx0XHR0ZXh0U2l6ZTogMjAsXG5cdFx0XHR0ZXh0Q29sb3I6IFwiQGNvbG9yL2tDb2xvclByaW1hcnlUZXh0XCIsXG5cdFx0fSxcblx0XHRzaGFya2ZpblRhYjoge1xuXHRcdFx0dGV4dFNpemU6IDE2LFxuXHRcdFx0dGV4dENvbG9yOiBcIkBjb2xvci9rQ29sb3JUaHJlZUxldmVsVGV4dFwiLFxuXHRcdH0sXG5cdFx0c2VsZWN0ZWRUYWI6ICdkdWFsJyxcblx0XHRkZXNjRGF0YTogZ2V0RGVzY0RhdGEoJ2R1YWwnKSxcblx0XHRkZXNjTGluZVNwYWNpbmc6IFwiOFwiLFxuXHRcdG1hcmdpbkJvdHRvbTogXCIwXCIsXG5cdFx0Ym90dG9tU2hvdzogXCJnb25lXCJcblx0fTtcbn1cblxuZnVuY3Rpb24gZ2V0TmF2Q29uZmlnU3RyaW5nKCkge1xuXHRyZXR1cm4ge1xuXHRcdCd0aXRsZUtleSc6ICduX3N0cnV0dXJlZF9wcm9kdWN0cycsXG5cdFx0J2xlZnQnOiB7XG5cdFx0XHQnYWN0aW9uJzoge1xuXHRcdFx0XHQndHlwZSc6ICdldmFsSlMnLFxuXHRcdFx0XHQncGFyYW1ldGVyJzogJ2JhY2tDbGlja2VkJ1xuXHRcdFx0fSxcblx0XHRcdCdpY29uJzogJ2VkZ2VfZW5naW5lX3RvcF9iYXJfYmFja19ub3JtYWwnXG5cdFx0fSxcblx0XHQnYmFja2dyb3VuZENvbG9yJzogJ2tDb2xvckYxRjdGRidcblx0fTtcbn1cblxuY29uc3QgeyBtb2R1bGVEYXRhLCBtb2R1bGVFdmVudCB9ID0gY29tbW9uLm1vZHVsZURlZmluZShcInN0cnVjdHVyZWRcIiwgZGVmYXVsdERhdGEsIHsgb25DcmVhdGUsIG9uRGVzdHJveSwgb25SZXN1bWUsIG9uUGF1c2UgfSk7XG5cbmZ1bmN0aW9uIG9uQ3JlYXRlKHBhcmFtKSB7XG5cdGNvbnNvbGUubG9nKCdzdHJ1Y3R1cmVkIG9uQ3JlYXRlJyk7XG5cdG1vZHVsZURhdGEuc3RhdHVzQmFyQ29uZmlnID0geyBcInN0YXR1c0Jhck1vZGVcIjogXCJ0cnVlXCIsIFwiYWRTdGF0dXNCYXJDb2xvclwiOiBcIktCYXNlQ29sb3JEZWVwZXN0QmFja2dyb3VuZFwiLCBcInNhZmVCb3R0b21UcmFuc3BhcmVudFwiIDogXCJ0cnVlXCIgfTtcblx0bW9kdWxlRGF0YS5uYXZDb25maWcgPSBnZXROYXZDb25maWdTdHJpbmcoKTtcblx0bW9kdWxlRGF0YS5kZXNjTGluZVNwYWNpbmcgPSBjb21tb24uY29tbW9uRGF0YS5PUyA9PSAxID8gXCI4XCIgOiBcIjZcIjtcblx0bW9kdWxlRGF0YS5tYXJnaW5Cb3R0b20gPSBjb21tb24uY29tbW9uRGF0YS5ib3R0b21TYWZlQXJlYUhlaWdodCA+IDAgPyBcIjM0XCIgOiBcIjEyXCI7XG5cdG1vZHVsZURhdGEuYm9yZGVyQ29sb3IgPSBjb21tb24uY29tbW9uRGF0YS5jb2xvck1vZGUgPT0gMSA/IFwiNEQxRTFFMUZcIiA6IFwiNERGRkZGRkZcIjtcblx0bW9kdWxlRGF0YS5kZXNjRGF0YSA9IGdldERlc2NEYXRhKG1vZHVsZURhdGEuc2VsZWN0ZWRUYWIpO1xuXHRtb2R1bGVEYXRhLmlzRmlyc3QgPSB0cnVlO1xuXHRtb2R1bGVEYXRhLnRpbWVyT2JqZWN0ID0gbnVsbDtcblx0Ly8g6YCJdGFiXG5cdGxldCBwYXJhbURpYyA9IEpTT04ucGFyc2UocGFyYW0pO1xuXHR0YWJLZXkgPSBwYXJhbURpYy50YWJLZXkgPyBwYXJhbURpYy50YWJLZXkgOiBcIlwiO1xuXHRsZXQgc2VsZWN0ZWRUeXBlID0gcGFyYW1EaWNbJ3RhYiddO1xuXHRpc0Nsb3NlID0gQm9vbGVhbihwYXJhbURpY1snaXNDbG9zZSddKVxuXHRjb25zb2xlLmxvZyhzZWxlY3RlZFR5cGUpO1xuXHRjb25zb2xlLmxvZyhgaXNDbG9zZSA9ICR7aXNDbG9zZX1gKTtcblx0aWYgKHNlbGVjdGVkVHlwZSAhPT0gXCJzaGFya2ZpblwiKSB7XG5cdFx0c2VsZWN0ZWRUeXBlID0gXCJkdWFsXCI7XG5cdH1cblx0bW9kdWxlRXZlbnQudGFiQ2xpY2tlZChzZWxlY3RlZFR5cGUpO1xuXHRjb21tb24uYW5hbHl0aWNzKFwiYXBwX2Vhcm5fcHJvZHVjdFBhZ2Vfdmlld1wiLCB7XG5cdFx0J3BhZ2UnOiBcInN0cnVjdHVyZWRQcm9kdWN0c1wiLFxuXHR9KTtcbn1cblxuZnVuY3Rpb24gb25EZXN0cm95KCkge1xuXHR0YWJLZXkgPSBcIlwiO1xufVxuXG5hc3luYyBmdW5jdGlvbiBvblJlc3VtZSgpIHtcblx0Y29uc29sZS5sb2coJ3N0cnVjdHVyZWQgb25SZXN1bWUnKTtcblx0c3RhcnRUaW1lcigpO1xuXHRpZiAoIW1vZHVsZURhdGEuaXNGaXJzdCkge1xuXHRcdGlmIChtb2R1bGVEYXRhLnNlbGVjdGVkVGFiID09ICdkdWFsJykge1xuXHRcdFx0cmVxdWVzdENvaW5EYXRhcygpO1xuXHRcdH0gZWxzZSB7XG5cdFx0XHRyZXF1ZXN0U2hhcmtIb21lRGF0YSgpO1xuXHRcdH1cblx0fVxuXHRtb2R1bGVEYXRhLmlzRmlyc3QgPSBmYWxzZTtcbn1cblxuZnVuY3Rpb24gb25QYXVzZSgpIHtcblx0Y29uc29sZS5sb2coJ3N0cnVjdHVyZWQgb25QYXVzZScpO1xuXHRjbGVhclRpbWVyKCk7XG59XG5cbmZ1bmN0aW9uIGdldERlc2NEYXRhKHNlbGVjdGVkVGFiKSB7XG5cdHZhciB0aXRsZSA9ICRpMThuLm5fc3RydXR1cmVkX2R1YWxfZGVzYztcblx0dmFyIGljb24gPSBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9zdHJ1dHVyZWRfZHVhbFwiO1xuXHR2YXIgdGFiSW5kZXggPSAxO1xuXHRpZiAoc2VsZWN0ZWRUYWIgIT09IFwiZHVhbFwiKSB7XG5cdFx0dGl0bGUgPSAkaTE4bi5uX3N0cnV0dXJlZF9zaGFya2Zpbl9kZXNjO1xuXHRcdGljb24gPSBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9zdHJ1dHVyZWRfc2hhcmtmaW5cIjtcblx0XHR0YWJJbmRleCA9IDI7XG5cdH1cblxuXHRsZXQgaGlnaGxpZ2h0ID0gYCAkeyRpMThuLm5fc3RydXR1cmVkX21vcmVfZXhwbGFpbn1gO1xuXHR2YXIgdGV4dENvbG9yID0gXCIjNTY1NjU2XCJcblx0dmFyIGhpZ2hsaWdodENvbG9yID0gXCIjMDAwMDAwXCI7XG5cdHZhciBhcnJvd0NvbG9yID0gXCIjOEE4QThFXCI7XG5cdGlmIChjb21tb24uY29tbW9uRGF0YS5jb2xvck1vZGUgPT0gMSkge1xuXHRcdHRleHRDb2xvciA9IFwiIzhDOEM5M1wiXG5cdFx0aGlnaGxpZ2h0Q29sb3IgPSBcIiNFNkU2RTZcIjtcblx0XHRhcnJvd0NvbG9yID0gXCIjNEM0QzRFXCI7XG5cdH1cblxuXHRjb25zdCBuYW1lID0gYDxzcGFuIHN0eWxlPVwiY29sb3I6JHt0ZXh0Q29sb3J9OyBmb250LXNpemU6MTJweDtcIj4ke3RpdGxlfTwvc3Bhbj48c3BhbiBzdHlsZT1cImNvbG9yOiR7aGlnaGxpZ2h0Q29sb3J9OyBmb250LXNpemU6MTJweDtcIj4ke2hpZ2hsaWdodH08L3NwYW4+PHNwYW4gc3R5bGU9XCJjb2xvcjoke2Fycm93Q29sb3J9OyBmb250LXNpemU6MTJweDtcIj4g4p2vPC9zcGFuPmA7XG5cblx0cmV0dXJuIHsgbmFtZSwgaWNvbiwgdGFiSW5kZXggfTtcbn1cblxuZnVuY3Rpb24gY29uY2F0RHVhbERhdGEoKSB7XG5cdHZhciB0ZW1wRGF0YSA9IFtdO1xuXHRpZiAoc3RydWN0dXJlZF9kdWFsRGF0YS5jb2luRGF0YSAmJlxuXHRcdHN0cnVjdHVyZWRfZHVhbERhdGEuY29pbkRhdGEubGVuZ3RoID4gMCkge1xuXHRcdHRlbXBEYXRhID0gdGVtcERhdGEuY29uY2F0KHN0cnVjdHVyZWRfZHVhbERhdGEuY29pbkRhdGEpO1xuXHR9XG5cdHZhciBwcm9ibGVtU2VjdGlvbiA9IHN0cnVjdHVyZWRfcHJvYmxlbVNlY3Rpb247XG5cdHByb2JsZW1TZWN0aW9uLnRhYkluZGV4ID0gMTtcblx0dGVtcERhdGEucHVzaChzdHJ1Y3R1cmVkX29ubHlPbmVTZWN0aW9uKTtcblx0dGVtcERhdGEucHVzaChwcm9ibGVtU2VjdGlvbik7XG5cdHRlbXBEYXRhID0gdGVtcERhdGEuY29uY2F0KHN0cnVjdHVyZWRfZHVhbERhdGEucWFEYXRhKTtcblx0dGVtcERhdGEucHVzaChzdHJ1Y3R1cmVkX21vcmVTZWN0aW9uKTtcblx0dGVtcERhdGEgPSB0ZW1wRGF0YS5jb25jYXQoc3RydWN0dXJlZF9kdWFsRGF0YS5tb3JlRGF0YSk7XG5cdHJldHVybiB0ZW1wRGF0YTtcbn1cblxuZnVuY3Rpb24gY29uY2F0U2hhcmtmaW5EYXRhKCkge1xuXHR2YXIgdGVtcERhdGEgPSBbXTtcblx0dmFyIHByb2JsZW1TZWN0aW9uID0gc3RydWN0dXJlZF9wcm9ibGVtU2VjdGlvbjtcblx0cHJvYmxlbVNlY3Rpb24udGFiSW5kZXggPSAyO1xuXHR0ZW1wRGF0YS5wdXNoKHByb2JsZW1TZWN0aW9uKTtcblx0dGVtcERhdGEgPSB0ZW1wRGF0YS5jb25jYXQoc3RydWN0dXJlZF9zaGFya2ZpbkRhdGEucWFEYXRhKTtcblx0dGVtcERhdGEucHVzaChzdHJ1Y3R1cmVkX21vcmVTZWN0aW9uKTtcblx0dGVtcERhdGEgPSB0ZW1wRGF0YS5jb25jYXQoc3RydWN0dXJlZF9kdWFsRGF0YS5tb3JlRGF0YSk7XG5cdHJldHVybiB0ZW1wRGF0YTtcbn1cblxuZnVuY3Rpb24gdGFiQ2xpY2tlZCh0YWJUeXBlKSB7XG5cdG1vZHVsZURhdGEuc2VsZWN0ZWRUYWIgPSB0YWJUeXBlO1xuXHR2YXIgdGFiTmFtZSA9IFwiXCI7XG5cdGlmICh0YWJUeXBlID09ICdkdWFsJykge1xuXHRcdHRhYk5hbWUgPSBcImR1YWxJbnZlc3RtZW50XCI7XG5cdFx0bW9kdWxlRGF0YS5ib3R0b21TaG93ID0gXCJ2aXNpYmxlXCI7XG5cdFx0bW9kdWxlRGF0YS5zaGFya2ZpblZpc2liaWxpdHkgPSBcImdvbmVcIjtcblx0XHRtb2R1bGVEYXRhLmR1YWxUYWIudGV4dFNpemUgPSAyMDtcblx0XHRtb2R1bGVEYXRhLmR1YWxUYWIudGV4dENvbG9yID0gXCJAY29sb3Iva0NvbG9yUHJpbWFyeVRleHRcIjtcblx0XHRtb2R1bGVEYXRhLnNoYXJrZmluVGFiLnRleHRTaXplID0gMTY7XG5cdFx0bW9kdWxlRGF0YS5zaGFya2ZpblRhYi50ZXh0Q29sb3IgPSBcIkBjb2xvci9rQ29sb3JUaHJlZUxldmVsVGV4dFwiO1xuXHRcdG1vZHVsZURhdGEuZGVzY0RhdGEgPSBnZXREZXNjRGF0YSh0YWJUeXBlKTtcblx0XHRtb2R1bGVEYXRhLm1haW5EYXRhID0gY29uY2F0RHVhbERhdGEoKTtcblx0XHRyZXF1ZXN0Q29pbkRhdGFzKCk7XG5cdH0gZWxzZSB7XG5cdFx0dGFiTmFtZSA9IFwic2hhcmtGaW5cIjtcblx0XHRtb2R1bGVEYXRhLmJvdHRvbVNob3cgPSBcImdvbmVcIjtcblx0XHRtb2R1bGVEYXRhLnNoYXJrZmluVmlzaWJpbGl0eSA9IFwidmlzaWJsZVwiO1xuXHRcdG1vZHVsZURhdGEuc2hhcmtmaW5UYWIudGV4dFNpemUgPSAyMDtcblx0XHRtb2R1bGVEYXRhLnNoYXJrZmluVGFiLnRleHRDb2xvciA9IFwiQGNvbG9yL2tDb2xvclByaW1hcnlUZXh0XCI7XG5cdFx0bW9kdWxlRGF0YS5kdWFsVGFiLnRleHRTaXplID0gMTY7XG5cdFx0bW9kdWxlRGF0YS5kdWFsVGFiLnRleHRDb2xvciA9IFwiQGNvbG9yL2tDb2xvclRocmVlTGV2ZWxUZXh0XCI7XG5cdFx0bW9kdWxlRGF0YS5kZXNjRGF0YSA9IGdldERlc2NEYXRhKHRhYlR5cGUpO1xuXHRcdG1vZHVsZURhdGEubWFpbkRhdGEgPSBjb25jYXRTaGFya2ZpbkRhdGEoKTtcblx0XHRyZXF1ZXN0U2hhcmtIb21lRGF0YSgpO1xuXHR9XG5cdGNvbW1vbi5hbmFseXRpY3MoXCJhcHBfZWFybl9wcm9kdWN0UGFnZV9zZWNvbmRGbG9vclRhYl9zaG93XCIsIHtcblx0XHQncGFnZSc6IFwic3RydWN0dXJlZFByb2R1Y3RzXCIsXG5cdFx0J3RhYk5hbWUnOiB0YWJOYW1lXG5cdH0pO1xufVxuXG5mdW5jdGlvbiBjbGlja0l0ZW0oaW5kZXgpIHtcblx0dmFyIG9wZXJhdGlvblR5cGUgPSBcIlwiXG5cdHZhciBjdXJEYXRhID0gc3RydWN0dXJlZF9kdWFsRGF0YS5jb2luRGF0YVtwYXJzZUludChpbmRleCldO1xuXHRpZiAoY3VyRGF0YS51bmZvbGRlZFZpc2libGUgPT0gJ2dvbmUnKSB7XG5cdFx0Y3VyRGF0YS51bmZvbGRlZFZpc2libGUgPSAndmlzaWJsZSc7XG5cdFx0Y3VyRGF0YS5pY29uX2Fycm93ID0gXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfc3RydXR1cmVkX2Fycm93X3VwXCI7XG5cdFx0Y3VyRGF0YS55aWVsZFRleHQgPSAnJztcblx0XHRvcGVyYXRpb25UeXBlID0gXCJ1bmZvbGRcIjtcblx0XHRjb21tb24uYW5hbHl0aWNzKFwiYXBwX2Vhcm5fcHJvZHVjdENhcmRfc2hvd1wiLCB7XG5cdFx0XHQncGFnZSc6IFwic3RydWN0dXJlZFByb2R1Y3RzXCIsXG5cdFx0XHQndGFiTmFtZSc6IFwiZHVhbEludmVzdG1lbnRcIixcblx0XHRcdCd0b2tlbic6IGN1ckRhdGEuY29pbk5hbWUsXG5cdFx0XHQnb3BlcmF0ZSc6IFwiYnV5TG93XCJcblx0XHR9KTtcblx0XHRjb21tb24uYW5hbHl0aWNzKFwiYXBwX2Vhcm5fcHJvZHVjdENhcmRfc2hvd1wiLCB7XG5cdFx0XHQncGFnZSc6IFwic3RydWN0dXJlZFByb2R1Y3RzXCIsXG5cdFx0XHQndGFiTmFtZSc6IFwiZHVhbEludmVzdG1lbnRcIixcblx0XHRcdCd0b2tlbic6IGN1ckRhdGEuY29pbk5hbWUsXG5cdFx0XHQnb3BlcmF0ZSc6IFwic2VsbEhpZ2hcIlxuXHRcdH0pO1xuXHR9IGVsc2Uge1xuXHRcdGN1ckRhdGEudW5mb2xkZWRWaXNpYmxlID0gJ2dvbmUnO1xuXHRcdGN1ckRhdGEuaWNvbl9hcnJvdyA9IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX3N0cnV0dXJlZF9hcnJvd19kb3duXCI7XG5cdFx0Y3VyRGF0YS55aWVsZFRleHQgPSBjdXJEYXRhLmFyclJhbmdlO1xuXHRcdG9wZXJhdGlvblR5cGUgPSBcImZvbGRcIjtcblx0fVxuXHRtb2R1bGVEYXRhLm1haW5EYXRhID0gY29uY2F0RHVhbERhdGEoKTtcblx0Y29tbW9uLmFuYWx5dGljcyhcImFwcF9lYXJuX3Rva2VuQ2FyZF9jbGlja1wiLCB7XG5cdFx0J3BhZ2UnOiBcInN0cnVjdHVyZWRQcm9kdWN0c1wiLFxuXHRcdCd0YWJOYW1lJzogXCJkdWFsSW52ZXN0bWVudFwiLFxuXHRcdCd0b2tlbic6IGN1ckRhdGEuY29pbk5hbWUsXG5cdFx0J29wZXJhdGlvblR5cGUnOiBvcGVyYXRpb25UeXBlXG5cdH0pO1xufVxuXG4vL+myqOmxvOmzjTPlpKnvvIw35aSpXG5mdW5jdGlvbiBzaGFya2ZpblRhYkNsaWNrZWQoc2VsZWN0VGFiS2V5KSB7XG5cdGlmICh0YWJLZXkgIT0gc2VsZWN0VGFiS2V5KSB7XG5cdFx0dGFiS2V5ID0gc2VsZWN0VGFiS2V5O1xuXHR9XG5cdHN0YXJ0VGltZXIoKTtcblx0cmVxdWVzdFNoYXJrSG9tZURhdGEoKTtcbn1cblxuZnVuY3Rpb24gY2xpY2tRQShRSW5kZXgpIHtcblx0dmFyIG9wZXJhdGlvblR5cGUgPSBcIlwiO1xuXHR2YXIgdGFiTmFtZSA9IFwiXCI7XG5cdHZhciBxYWxpc3QgPSBtb2R1bGVEYXRhLnNlbGVjdGVkVGFiID09ICdkdWFsJyA/IHN0cnVjdHVyZWRfZHVhbERhdGEucWFEYXRhIDogc3RydWN0dXJlZF9zaGFya2ZpbkRhdGEucWFEYXRhO1xuXHRmb3IgKGxldCBpbmRleCA9IDA7IGluZGV4IDwgcWFsaXN0Lmxlbmd0aDsgaW5kZXgrKykge1xuXHRcdGNvbnN0IGVsZW1lbnQgPSBxYWxpc3RbaW5kZXhdO1xuXHRcdGlmIChRSW5kZXggPT0gZWxlbWVudC5pbmRleCkge1xuXHRcdFx0aWYgKGVsZW1lbnQuYW5zd2VyVmlzYWJsZSA9PSAnZ29uZScpIHtcblx0XHRcdFx0ZWxlbWVudC5hbnN3ZXJWaXNhYmxlID0gJ3Zpc2libGUnO1xuXHRcdFx0XHRlbGVtZW50LnFhSWNvbiA9IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX3NoYXJrX2hvbWVfcWFfcmV0cmFjdF9pY29uXCI7XG5cdFx0XHRcdG9wZXJhdGlvblR5cGUgPSBcInVuZm9sZFwiO1xuXHRcdFx0fSBlbHNlIHtcblx0XHRcdFx0ZWxlbWVudC5hbnN3ZXJWaXNhYmxlID0gJ2dvbmUnO1xuXHRcdFx0XHRlbGVtZW50LnFhSWNvbiA9IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX3NoYXJrX2hvbWVfcWFfc3ByZWFkX2ljb25cIjtcblx0XHRcdFx0b3BlcmF0aW9uVHlwZSA9IFwiZm9sZFwiO1xuXHRcdFx0fVxuXHRcdH1cblx0fVxuXHRpZiAobW9kdWxlRGF0YS5zZWxlY3RlZFRhYiA9PSAnZHVhbCcpIHtcblx0XHRtb2R1bGVEYXRhLm1haW5EYXRhID0gY29uY2F0RHVhbERhdGEoKTtcblx0XHR0YWJOYW1lID0gXCJkdWFsSW52ZXN0bWVudFwiO1xuXHR9IGVsc2Uge1xuXHRcdG1vZHVsZURhdGEubWFpbkRhdGEgPSBjb25jYXRTaGFya2ZpbkRhdGEoKTtcblx0XHR0YWJOYW1lID0gXCJzaGFya0ZpblwiO1xuXHR9XG5cdGNvbW1vbi5hbmFseXRpY3MoXCJhcHBfZWFybl9GQVFzX3VuZm9sZEFuZEZvbGRfY2xpY2tcIiwge1xuXHRcdCdwYWdlJzogXCJzdHJ1Y3R1cmVkUHJvZHVjdHNcIixcblx0XHR0YWJOYW1lLFxuXHRcdG9wZXJhdGlvblR5cGUsXG5cdFx0J29yZGVyJzogYCR7UUluZGV4ICsgMX1gXG5cdH0pO1xufVxuXG5hc3luYyBmdW5jdGlvbiByZXF1ZXN0Q29pbkRhdGFzKCkge1xuXHRjb21tb24uc2hvd0xvYWRpbmcodHJ1ZSk7XG5cdGNvbnN0IGRhdGEgPSBhd2FpdCBjb21tb24uc2VuZFJlcXVlc3QoJ290Yy9vcHQvb3B0aW9uL3YyL3ByZS9kY3ctdGFiLW5hdicpO1xuXHRjb21tb24uc2hvd0xvYWRpbmcoZmFsc2UpO1xuXHR2YXIgZGF0YUxpc3QgPSBbXTtcblx0aWYgKGRhdGEgJiYgZGF0YS5uYXZpZ2F0aW9ucy5sZW5ndGgpIHtcblx0XHRjb25zdCBsaXN0ID0gZGF0YS5uYXZpZ2F0aW9ucztcblx0XHRmb3IgKHZhciBpID0gMDsgaSA8IGxpc3QubGVuZ3RoOyBpKyspIHtcblx0XHRcdGNvbnN0IGN1ckRhdGEgPSBsaXN0W2ldO1xuXHRcdFx0dmFyIG9iamVjdCA9IHt9O1xuXHRcdFx0b2JqZWN0LnR5cGUgPSAnZHVhbENlbGwnO1xuXHRcdFx0b2JqZWN0LmluZGV4ID0gaTtcblx0XHRcdG9iamVjdC51bmZvbGRlZFZpc2libGUgPSAnZ29uZSc7XG5cdFx0XHRvYmplY3QuY29pbk5hbWUgPSBjdXJEYXRhLmN1cnJlbmN5LnRvVXBwZXJDYXNlKCk7XG5cdFx0XHRvYmplY3QuaWNvbl9hcnJvdyA9IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX3N0cnV0dXJlZF9hcnJvd19kb3duXCI7XG5cdFx0XHRvYmplY3QubWFpbkljb24gPSBjb21tb24uZ2V0UE5HSWNvblVSTEJ5Q3VycmVuY3koY3VyRGF0YS5jdXJyZW5jeSk7XG5cdFx0XHRvYmplY3QuYXJyUmFuZ2UgPSBjdXJEYXRhWydhcnItcmFuZ2UnXSAhPSBudWxsID8gY3VyRGF0YVsnYXJyLXJhbmdlJ10gOiBcIlwiO1xuXHRcdFx0b2JqZWN0LnlpZWxkVGV4dCA9IG9iamVjdC5hcnJSYW5nZTtcblx0XHRcdGZvciAodmFyIGogPSAwOyBqIDwgY3VyRGF0YS5pdGVtcy5sZW5ndGg7IGorKykge1xuXHRcdFx0XHRjb25zdCBpdGVtID0gY3VyRGF0YS5pdGVtc1tqXTtcblx0XHRcdFx0aWYgKGl0ZW1bJ3Byb2R1Y3QtdHlwZS1pZCddID09ICc1Jykgey8v5oqE5bqV5a6dXG5cdFx0XHRcdFx0b2JqZWN0W2BkZXNjVGV4dCR7aiArIDF9YF0gPSAkaTE4bi4kaW50ZXJjZXB0Lm5fZG91YmxlX2NvaW5fZWFybl9sb3dfYnV5KG9iamVjdC5jb2luTmFtZSk7XG5cdFx0XHRcdFx0b2JqZWN0W2BiaWdJY29uJHtqICsgMX1gXSA9IGNvbW1vbi5nZXRQTkdJY29uVVJMQnlDdXJyZW5jeShpdGVtWydxdW90ZS1jdXJyZW5jeSddKTtcblx0XHRcdFx0XHRvYmplY3RbYHNtYWxsSWNvbiR7aiArIDF9YF0gPSBjb21tb24uZ2V0UE5HSWNvblVSTEJ5Q3VycmVuY3koaXRlbVsnYmFzZS1jdXJyZW5jeSddKTtcblx0XHRcdFx0XHRvYmplY3RbJ3N1cHBvcnQtcXVvdGVzLWJ1eSddID0gaXRlbVsnc3VwcG9ydC1xdW90ZXMnXTtcblx0XHRcdFx0fSBlbHNlIGlmIChpdGVtWydwcm9kdWN0LXR5cGUtaWQnXSA9PSAnNicpIHsvL+atouebiOWunVxuXHRcdFx0XHRcdG9iamVjdFtgZGVzY1RleHQke2ogKyAxfWBdID0gJGkxOG4uJGludGVyY2VwdC5uX2RvdWJsZV9jb2luX2Vhcm5faGlnaF9zZWxsKG9iamVjdC5jb2luTmFtZSk7XG5cdFx0XHRcdFx0b2JqZWN0W2BzbWFsbEljb24ke2ogKyAxfWBdID0gY29tbW9uLmdldFBOR0ljb25VUkxCeUN1cnJlbmN5KGl0ZW1bJ3F1b3RlLWN1cnJlbmN5J10pO1xuXHRcdFx0XHRcdG9iamVjdFtgYmlnSWNvbiR7aiArIDF9YF0gPSBjb21tb24uZ2V0UE5HSWNvblVSTEJ5Q3VycmVuY3koaXRlbVsnYmFzZS1jdXJyZW5jeSddKTtcblx0XHRcdFx0XHRvYmplY3RbJ3N1cHBvcnQtcXVvdGVzLXNlbGwnXSA9IGl0ZW1bJ3N1cHBvcnQtcXVvdGVzJ107XG5cdFx0XHRcdH1cblx0XHRcdFx0dmFyIGlkeFN0ciA9IChqICsgMSkgKyAnJztcblx0XHRcdFx0b2JqZWN0W1wieWllbGRUZXh0XCIgKyBpZHhTdHJdID0gaXRlbVsnYXJyLXJhbmdlJ10gIT0gbnVsbCA/IGl0ZW1bJ2Fyci1yYW5nZSddIDogXCJcIjtcblx0XHRcdFx0b2JqZWN0W1wicHJvZHVjdFR5cGVJZFwiICsgaWR4U3RyXSA9IGAke2l0ZW1bJ3Byb2R1Y3QtdHlwZS1pZCddfWA7XG5cdFx0XHRcdG9iamVjdFsnY3VycmVuY3knXSA9IGl0ZW1bJ2Jhc2UtY3VycmVuY3knXTtcblx0XHRcdH1cblx0XHRcdGRhdGFMaXN0LnB1c2gob2JqZWN0KTtcblx0XHRcdGNvbW1vbi5hbmFseXRpY3MoXCJhcHBfZWFybl90b2tlbkNhcmRfc2hvd1wiLCB7XG5cdFx0XHRcdCdwYWdlJzogXCJzdHJ1Y3R1cmVkUHJvZHVjdHNcIixcblx0XHRcdFx0J3RhYk5hbWUnOiBcImR1YWxJbnZlc3RtZW50XCIsXG5cdFx0XHRcdCd0b2tlbic6IG9iamVjdC5jb2luTmFtZSxcblx0XHRcdFx0J29wZXJhdGlvblR5cGUnOiBcImZvbGRcIixcblx0XHRcdH0pO1xuXHRcdH1cblx0XHRzdHJ1Y3R1cmVkX2R1YWxEYXRhLmNvaW5EYXRhID0gZGF0YUxpc3Q7XG5cdFx0bW9kdWxlRGF0YS5tYWluRGF0YSA9IGNvbmNhdER1YWxEYXRhKCk7XG5cdH1cblx0Y29tbW9uLmFuYWx5dGljcyhcImFwcF9lYXJuX3Byb2R1Y3RQYWdlX21vcmVSZWxhdGVkX3Nob3dcIiwge1xuXHRcdCdwYWdlJzogXCJzdHJ1Y3R1cmVkUHJvZHVjdHNcIixcblx0XHQndGFiTmFtZSc6IFwiZHVhbEludmVzdG1lbnRcIixcblx0fSk7XG5cdGNvbW1vbi5hbmFseXRpY3MoXCJhcHBfZWFybl9GQVFzX3Nob3dcIiwge1xuXHRcdCdwYWdlJzogXCJzdHJ1Y3R1cmVkUHJvZHVjdHNcIixcblx0XHQndGFiTmFtZSc6IFwiZHVhbEludmVzdG1lbnRcIixcblx0fSk7XG59XG5cbmFzeW5jIGZ1bmN0aW9uIHJlcXVlc3RTaGFya0hvbWVEYXRhKCkge1xuXHRjb21tb24uc2hvd0xvYWRpbmcodHJ1ZSk7XG5cdGNvbnN0IGRhdGEgPSBhd2FpdCBjb21tb24uc2VuZFJlcXVlc3QoJ3Y0L3NhdmluZy9taW5pbmcvc2hhcmsnLCB7IHRhYktleSB9KTtcblx0Y29tbW9uLnNob3dMb2FkaW5nKGZhbHNlKTtcblx0c2hhcmtUYWJLZXkoZGF0YSk7XG5cdHNoYXJrSG9tZURhdGEoZGF0YSk7XG5cdGNvbW1vbi5hbmFseXRpY3MoXCJhcHBfZWFybl9wcm9kdWN0UGFnZV9tb3JlUmVsYXRlZF9zaG93XCIsIHtcblx0XHQncGFnZSc6IFwic3RydWN0dXJlZFByb2R1Y3RzXCIsXG5cdFx0J3RhYk5hbWUnOiBcInNoYXJrRmluXCIsXG5cdH0pO1xuXHRjb21tb24uYW5hbHl0aWNzKFwiYXBwX2Vhcm5fRkFRc19zaG93XCIsIHtcblx0XHQncGFnZSc6IFwic3RydWN0dXJlZFByb2R1Y3RzXCIsXG5cdFx0J3RhYk5hbWUnOiBcInNoYXJrRmluXCIsXG5cdH0pO1xufVxuXG5mdW5jdGlvbiBzaGFya1RhYktleShvRGF0YSkge1xuXHRpZiAoIW9EYXRhIHx8IG9EYXRhID09IG51bGwgfHwgIW9EYXRhLnRhYkluZm8gfHwgb0RhdGEudGFiSW5mbyA9PSBudWxsIHx8IG9EYXRhLnRhYkluZm8ubGVuZ3RoIDwgMikge1xuXHRcdG1vZHVsZURhdGEudGFiVmlzYWJsZSA9IFwiZ29uZVwiO1xuXHRcdHJldHVybjtcblx0fVxuXHRtb2R1bGVEYXRhLnRhYlZpc2FibGUgPSBcInZpc2libGVcIjtcblx0dmFyIG11QXJyYXkgPSBbXTtcblx0Zm9yIChsZXQgaW5kZXggPSAwOyBpbmRleCA8IG9EYXRhLnRhYkluZm8ubGVuZ3RoOyBpbmRleCsrKSB7XG5cdFx0dmFyIGVsZW1lbnQgPSBvRGF0YS50YWJJbmZvW2luZGV4XTtcblx0XHRpZiAoZWxlbWVudC5oaWdobGlnaHQpIHtcblx0XHRcdHRhYktleSA9IGVsZW1lbnQudGFiS2V5O1xuXHRcdFx0ZWxlbWVudC5iYWNrZ3JvdW5kID0gXCJAY29sb3IvS0Jhc2VDb2xvckNvbnRlbnRCYWNrZ3JvdW5kXCI7XG5cdFx0XHRlbGVtZW50LnRleHRDb2xvciA9IFwiQGNvbG9yL2tDb2xvclByaW1hcnlUZXh0XCI7XG5cdFx0fSBlbHNlIHtcblx0XHRcdGVsZW1lbnQuYmFja2dyb3VuZCA9IFwiQGNvbG9yL0tCYXNlQ29sb3JJbnB1dEJhY2tncm91bmRcIjtcblx0XHRcdGVsZW1lbnQudGV4dENvbG9yID0gXCJAY29sb3Iva0NvbG9yVGhyZWVMZXZlbFRleHRcIjtcblx0XHR9XG5cdFx0bXVBcnJheS5wdXNoKGVsZW1lbnQpO1xuXHR9XG5cdG1vZHVsZURhdGEudGFiMCA9IG11QXJyYXlbMF07XG5cdG1vZHVsZURhdGEudGFiMSA9IG11QXJyYXlbMV07XG5cdG1vZHVsZURhdGEubWFpbkRhdGEgPSBjb25jYXRTaGFya2ZpbkRhdGEoKTtcbn1cblxuZnVuY3Rpb24gc2hhcmtIb21lRGF0YShvRGF0YSkge1xuXHRpZiAoIW9EYXRhIHx8IG9EYXRhID09IG51bGwgfHwgIW9EYXRhLnNoYXJrSW5mbyB8fCBvRGF0YS5zaGFya0luZm8gPT0gbnVsbCB8fCBvRGF0YS5zaGFya0luZm8ubGVuZ3RoID09IDApIHtcblx0XHRjbGVhclRpbWVyKCk7XG5cdFx0bW9kdWxlRGF0YS5jb250ZW50VmlzYWJsZSA9IFwiZ29uZVwiO1xuXHRcdHJldHVybjtcblx0fVxuXHRjb25zdCBkYXRhID0gb0RhdGEuc2hhcmtJbmZvWzBdO1xuXHRjb25zb2xlLmxvZygnaG9tZSBzaGFya0hvbWVEYXRhJyArIEpTT04uc3RyaW5naWZ5KGRhdGEpKTtcblxuXHRtb2R1bGVEYXRhLmNvbnRlbnRWaXNhYmxlID0gXCJ2aXNpYmxlXCI7XG5cblx0bW9kdWxlRGF0YS5xdW90ZUN1cnJlbmN5ID0gZGF0YS5xdW90ZUN1cnJlbmN5O1xuXHRtb2R1bGVEYXRhLnZpZXdTdGF0dXMgPSBkYXRhLnZpZXdTdGF0dXM7XG5cblx0bW9kdWxlRGF0YS5zdGFydFRpbWUgPSBkYXRhLnN0YXJ0VGltZTtcblx0bW9kdWxlRGF0YS5lbmRUaW1lID0gZGF0YS5lbmRUaW1lO1xuXG5cdG1vZHVsZURhdGEuc3Vic2NyaWJlU3RhcnRUaW1lID0gZGF0YS5zdWJzY3JpYmVTdGFydFRpbWU7XG5cdG1vZHVsZURhdGEuc3Vic2NyaWJlRW5kVGltZSA9IGRhdGEuc3Vic2NyaWJlRW5kVGltZTtcblxuXHRtb2R1bGVEYXRhLnRvdGFsTGltaXQgPSBgLyAke2NvbW1vbi5nZXRQcmljZVN0cmluZyhkYXRhLnRvdGFsTGltaXQsIDApfWA7XG5cdG1vZHVsZURhdGEuZmluaXNoQW1vdW50ID0gY29tbW9uLmdldFByaWNlU3RyaW5nKGRhdGEuZmluaXNoQW1vdW50LCAwKTtcblxuXHR2YXIgZmluaXNoUHJvcG9ydGlvbiA9IHBhcnNlRmxvYXQoZGF0YS5maW5pc2hBbW91bnQgLyBkYXRhLnRvdGFsTGltaXQpO1xuXHRpZiAoZmluaXNoUHJvcG9ydGlvbiA+IDEpIHtcblx0XHRmaW5pc2hQcm9wb3J0aW9uID0gMVxuXHR9XG5cdGlmIChmaW5pc2hQcm9wb3J0aW9uID4gMCAmJiBmaW5pc2hQcm9wb3J0aW9uIDwgMC4wMSkge1xuXHRcdGZpbmlzaFByb3BvcnRpb24gPSAwLjAxO1xuXHR9XG5cdG1vZHVsZURhdGEud2lkdGggPSBmaW5pc2hQcm9wb3J0aW9uICogMzAzO1xuXG5cdG1vZHVsZURhdGEuc1RpbWUgPSBkYXRhLnNUaW1lO1xuXHRtb2R1bGVEYXRhLnNlcnZpY2VUaW1lSW50ZXJ2YWwgPSBkYXRhLnNUaW1lIC0gbmV3IERhdGUoKS5nZXRUaW1lKCk7XG5cblx0bW9kdWxlRGF0YS5zdWJzY3JpcHRpb25UaXRsZSA9IFwiXCI7XG5cdGlmIChkYXRhLnZpZXdTdGF0dXMgPT0gMCkgeyAvL+acquW8gOWni1xuXHRcdG1vZHVsZURhdGEuc3Vic2NyaXB0aW9uVGl0bGUgPSAkaTE4bi5uX3NoYXJrX2Zpbl9kZXBvc2l0X29wZW47XG5cdFx0bW9kdWxlRGF0YS5zdWJzY3JpcHRpb25EYXRlID0gYCR7bmV3IERhdGUoZGF0YS5zdWJzY3JpYmVTdGFydFRpbWUpLkZvcm1hdChcInl5eXkvTU0vZGQgaGg6bW1cIil9YDtcblx0XHR2YXIgaXNaZXJvID0gdXBkYXRlQ291bnREb3duKGRhdGEuc3Vic2NyaWJlU3RhcnRUaW1lKTtcblx0XHRtb2R1bGVEYXRhLnByb2dyZXNzVmlzYWJsZSA9IFwiZ29uZVwiO1xuXHRcdG1vZHVsZURhdGEuY291bnRkb3duVmlzYWJsZSA9IGlzWmVybyA/IFwiZ29uZVwiIDogXCJ2aXNpYmxlXCI7XG5cdFx0bW9kdWxlRGF0YS5zdWJzY3JpcHRpb25EYXRlVmlzYWJsZSA9IFwidmlzaWJsZVwiO1xuXHR9IGVsc2UgaWYgKGRhdGEudmlld1N0YXR1cyA9PSAxICYmIGRhdGEuZmluaXNoQW1vdW50IDwgZGF0YS50b3RhbExpbWl0KSB7IC8v5b6F56Gu6K6kIOacqua7oVxuXHRcdG1vZHVsZURhdGEuc3Vic2NyaXB0aW9uVGl0bGUgPSAkaTE4bi5uX3NoYXJrX2Zpbl9kZXBvc2l0X2Nsb3NlO1xuXHRcdG1vZHVsZURhdGEuc3Vic2NyaXB0aW9uRGF0ZSA9IGAke25ldyBEYXRlKGRhdGEuc3Vic2NyaWJlRW5kVGltZSkuRm9ybWF0KFwieXl5eS9NTS9kZCBoaDptbVwiKX1gO1xuXHRcdHZhciBpc1plcm8gPSB1cGRhdGVDb3VudERvd24oZGF0YS5zdWJzY3JpYmVFbmRUaW1lKTtcblx0XHRtb2R1bGVEYXRhLnByb2dyZXNzVmlzYWJsZSA9IFwidmlzaWJsZVwiO1xuXHRcdG1vZHVsZURhdGEuY291bnRkb3duVmlzYWJsZSA9IGlzWmVybyA/IFwiZ29uZVwiIDogXCJ2aXNpYmxlXCI7XG5cdFx0bW9kdWxlRGF0YS5zdWJzY3JpcHRpb25EYXRlVmlzYWJsZSA9IFwidmlzaWJsZVwiO1xuXHR9IGVsc2UgeyAgLy/otZrluIHkuK3vvJvlt7LliLDmnJ/vvJvlvoXnoa7orqQg5bey5ruhXG5cdFx0bW9kdWxlRGF0YS5zdWJzY3JpcHRpb25UaXRsZSA9ICRpMThuLm5fc2hhcmtfZmluX2RlcG9zaXRfY2xvc2VkO1xuXHRcdG1vZHVsZURhdGEucHJvZ3Jlc3NWaXNhYmxlID0gXCJ2aXNpYmxlXCI7XG5cdFx0bW9kdWxlRGF0YS5jb3VudGRvd25WaXNhYmxlID0gXCJnb25lXCI7XG5cdFx0bW9kdWxlRGF0YS5zdWJzY3JpcHRpb25EYXRlVmlzYWJsZSA9IFwiZ29uZVwiO1xuXHRcdGNsZWFyVGltZXIoKTtcblx0fVxuXG5cdG1vZHVsZURhdGEuZGVwb3NpdEFtb3VudFRpdGxlID0gJGkxOG4uJGludGVyY2VwdC5uX3NoYXJrX2Zpbl9kZXBvc2l0X2Ftb3VudChkYXRhLnF1b3RlQ3VycmVuY3kpO1xuXG5cdHZhciBhcnJheSA9IFtdO1xuXHRmb3IgKHZhciBpID0gMDsgaSA8IGRhdGEucHJvamVjdHMubGVuZ3RoOyBpKyspIHtcblx0XHRsZXQgdG1wT2JqID0gZGF0YS5wcm9qZWN0c1tpXTtcblx0XHRsZXQgb2JqID0ge1xuXHRcdFx0XCJpZHhcIjogaSxcblx0XHRcdFwiaWNvblwiOiB0bXBPYmouY2FsbFB1dCA9PSAtMSA/IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX3NoYXJrX2hvbWVfZG93bl9pY29uXCIgOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9zaGFya19ob21lX3VwX2ljb25cIixcblx0XHRcdFwidGl0bGVcIjogdG1wT2JqLmNhbGxQdXQgPT0gLTEgPyAkaTE4bi4kaW50ZXJjZXB0Lm5fc2hhcmtfZmluX2JlYXJpc2godG1wT2JqLmN1cnJlbmN5KSA6ICRpMThuLiRpbnRlcmNlcHQubl9zaGFya19maW5fYnVsbGlzaCh0bXBPYmouY3VycmVuY3kpLFxuXHRcdFx0XCJ0ZXJtXCI6IGAke3RtcE9iai50ZXJtfSAkeyRpMThuLm5fbWluaW5nX2RheV90ZXh0fWAsXG5cdFx0XHRcImVhcm5pbmdzXCI6IGAke2NvbW1vbi5mb3JtYXRQcmVjaXNpb24obnVtYmVyLm11bHRpcGx5KHRtcE9iai5taW5SYXRlLCBcIjEwMFwiKSwgMil9JX4ke2NvbW1vbi5mb3JtYXRQcmVjaXNpb24obnVtYmVyLm11bHRpcGx5KHRtcE9iai5tYXhSYXRlLCBcIjEwMFwiKSwgMil9JWAsXG5cdFx0XHRcImNlbGxUeXBlXCI6IFwibm9ybWFsXCIsXG5cdFx0XHRcImlkXCI6IHRtcE9iai5pZCxcblx0XHRcdFwidHlwZVwiOiB0bXBPYmouY2FsbFB1dCA9PSAtMSA/IFwiYmVhcnJpc2hcIiA6IFwiYnVsbGlzaFwiLFxuXHRcdFx0XCJ0ZXJtU3RyXCI6IGAke3RtcE9iai50ZXJtfWAsXG5cdFx0XHRcImN1cnJlbmN5XCI6IHRtcE9iai5jdXJyZW5jeVxuXHRcdH1cblx0XHRhcnJheS5wdXNoKG9iaik7XG5cdFx0Y29tbW9uLmFuYWx5dGljcyhcImFwcF9lYXJuX3Byb2R1Y3RDYXJkX3Nob3dcIiwge1xuXHRcdFx0J3BhZ2UnOiBcInN0cnVjdHVyZWRQcm9kdWN0c1wiLFxuXHRcdFx0J3RhYk5hbWUnOiBcInNoYXJrRmluXCIsXG5cdFx0XHQndG9rZW4nOiBvYmouY3VycmVuY3ksXG5cdFx0XHQncHJvamVjdElkJzogb2JqLmlkLFxuXHRcdFx0J3Rlcm0nOiBvYmoudGVybVN0clxuXHRcdH0pO1xuXHR9XG5cdGNvbnNvbGUubG9nKFwiYXJyYXlcIiArIEpTT04uc3RyaW5naWZ5KGFycmF5KSk7XG5cdG1vZHVsZURhdGEucHJvZHVjdExpc3QgPSBhcnJheTtcblx0bW9kdWxlRGF0YS5tYWluRGF0YSA9IGNvbmNhdFNoYXJrZmluRGF0YSgpO1xufVxuXG5mdW5jdGlvbiB1cGRhdGVDb3VudERvd24oZGF0ZSkge1xuXHR2YXIgdGltZU1hcCA9IGdldENvdW50RG93bk1hcChkYXRlKTtcblx0aWYgKHRpbWVNYXAuaXNaZXJvKSB7XG5cdFx0bW9kdWxlRGF0YS5jb3VudGRvd25WaXNhYmxlID0gXCJnb25lXCI7XG5cdH0gZWxzZSB7XG5cdFx0bW9kdWxlRGF0YS5jb3VudGRvd24gPSB7XG5cdFx0XHRcImRheVwiOiB0aW1lTWFwLmRheSxcblx0XHRcdFwiaG91clwiOiB0aW1lTWFwLmhvdXIsXG5cdFx0XHRcIm1pbnV0ZVwiOiB0aW1lTWFwLm1pbnV0ZSxcblx0XHRcdFwic2Vjb25kXCI6IHRpbWVNYXAuc2Vjb25kLFxuXHRcdFx0XCJzaG93RGF5XCI6IHRpbWVNYXAuc2hvd0RheSxcblx0XHR9O1xuXHR9XG5cdHJldHVybiB0aW1lTWFwLmlzWmVybztcbn1cblxuZnVuY3Rpb24gZ2V0Q291bnREb3duTWFwKGRhdGUpIHtcblx0Y29uc3QgYmVnaW5EYXRlID0gbmV3IERhdGUoZGF0ZSkuZ2V0VGltZSgpO1xuXHRjb25zdCBuZXdEYXRlID0gbmV3IERhdGUoKS5nZXRUaW1lKCkgKyBtb2R1bGVEYXRhLnNlcnZpY2VUaW1lSW50ZXJ2YWw7XG5cblx0Y29uc3QgbWlsbGlzZWNvbmRzID0gYmVnaW5EYXRlIC0gbmV3RGF0ZTtcblx0Y29uc3QgaW50ZXJ2YWwgPSBtaWxsaXNlY29uZHMgLyAxMDAwO1xuXG5cdGlmIChpbnRlcnZhbCA8PSAwKSB7XG5cdFx0cmV0dXJuIHtcblx0XHRcdGRheTogJzAwJyxcblx0XHRcdGhvdXI6ICcwMCcsXG5cdFx0XHRtaW51dGU6ICcwMCcsXG5cdFx0XHRzZWNvbmQ6ICcwMCcsXG5cdFx0XHRzaG93RGF5OiAnZ29uZScsXG5cdFx0XHRpc1plcm86IHRydWVcblx0XHR9O1xuXHR9XG5cblx0bGV0IGQgPSBwYXJzZUludChpbnRlcnZhbCAvIDYwIC8gNjAgLyAyNCk7XG5cdGxldCBkYXkgPSBkIDwgMTAgPyBgMCR7ZH1gIDogYCR7ZH1gO1xuXG5cdGxldCBoID0gcGFyc2VJbnQoaW50ZXJ2YWwgLyA2MCAvIDYwICUgMjQpO1xuXHRsZXQgaG91ciA9IGggPCAxMCA/IGAwJHtofWAgOiBgJHtofWA7XG5cblx0bGV0IG0gPSBwYXJzZUludChpbnRlcnZhbCAvIDYwICUgNjApO1xuXHRsZXQgbWludXRlID0gbSA8IDEwID8gYDAke219YCA6IGAke219YDtcblxuXHRsZXQgcyA9IHBhcnNlSW50KGludGVydmFsICUgNjApO1xuXHRsZXQgc2Vjb25kID0gcyA8IDEwID8gYDAke3N9YCA6IGAke3N9YDtcblxuXHR2YXIgc2hvd0RheSA9IGQgPiAwID8gXCJ2aXNpYmxlXCIgOiAnZ29uZSc7XG5cdHZhciBpc1plcm8gPSBkICsgaCArIG0gKyBzID4gMCA/IGZhbHNlIDogdHJ1ZTtcblxuXHRyZXR1cm4ge1xuXHRcdGRheSxcblx0XHRob3VyLFxuXHRcdG1pbnV0ZSxcblx0XHRzZWNvbmQsXG5cdFx0c2hvd0RheSxcblx0XHRpc1plcm9cblx0fTtcbn1cblxuXG5mdW5jdGlvbiBzdGFydFRpbWVyKCkge1xuXHRjb25zb2xlLmxvZyhcInN0YXJ0VGltZXIgXCIpO1xuXHRpZiAobW9kdWxlRGF0YS50aW1lck9iamVjdCA9PSBudWxsKSB7XG5cdFx0bW9kdWxlRGF0YS50aW1lck9iamVjdCA9IHNldEludGVydmFsKHRpbWVyLCAxMDAwKTtcblx0fVxufVxuXG5mdW5jdGlvbiBjbGVhclRpbWVyKCkge1xuXHRpZiAobW9kdWxlRGF0YS50aW1lck9iamVjdCAhPSBudWxsKSB7XG5cdFx0Y29uc29sZS5sb2coXCJjbGVhclRpbWVyIFwiKTtcblx0XHRjbGVhckludGVydmFsKG1vZHVsZURhdGEudGltZXJPYmplY3QpO1xuXHRcdG1vZHVsZURhdGEudGltZXJPYmplY3QgPSBudWxsO1xuXHR9XG59XG5cbmFzeW5jIGZ1bmN0aW9uIHRpbWVyKCkge1xuXHRjb25zb2xlLmxvZyhcInRpbWVyIFwiKTtcblx0dmFyIGlzWmVybyA9IGZhbHNlO1xuXHRpZiAobW9kdWxlRGF0YS52aWV3U3RhdHVzID09IDApIHsgLy/mnKrlvIDlp4tcblx0XHRpc1plcm8gPSB1cGRhdGVDb3VudERvd24obW9kdWxlRGF0YS5zdWJzY3JpYmVTdGFydFRpbWUpO1xuXHR9IGVsc2UgaWYgKG1vZHVsZURhdGEudmlld1N0YXR1cyA9PSAxKSB7IC8v5b6F56Gu6K6kXG5cdFx0aXNaZXJvID0gdXBkYXRlQ291bnREb3duKG1vZHVsZURhdGEuc3Vic2NyaWJlRW5kVGltZSk7XG5cdH1cblxuXHRpZiAoaXNaZXJvKSB7XG5cdFx0ZGF0YSA9IGF3YWl0IGNvbW1vbi5zZW5kUmVxdWVzdCgndjQvc2F2aW5nL21pbmluZy9zaGFyaycsIHsgdGFiS2V5IH0pO1xuXHRcdHNoYXJrVGFiS2V5KGRhdGEpO1xuXHRcdHNoYXJrSG9tZURhdGEoZGF0YSk7XG5cdH1cbn1cblxuZnVuY3Rpb24gcmVmcmVzaCgpIHtcblx0aWYgKG1vZHVsZURhdGEuc2VsZWN0ZWRUYWIgPT0gJ2R1YWwnKSB7XG5cdFx0cmVxdWVzdENvaW5EYXRhcygpO1xuXHR9IGVsc2Uge1xuXHRcdHJlcXVlc3RTaGFya0hvbWVEYXRhKCk7XG5cdH1cblx0bW9kdWxlRGF0YS5yZWZyZXNoID0gJzInO1xufVxuXG5mdW5jdGlvbiB0b0V4cGxhaW4oKSB7XG5cdGNvbW1vbi5vcGVuUGFnZVdpdGhQYXRoKFwiaG9saWdlaXQ6Ly9vcGVuL3YxP2xvZ2luPTEmdXJsPWlodW9iaWdsb2JhbDovL20uaGJnLmNvbS9lZGdlZW5naW5lL2NvbnRhaW5lcj9zY2VuZT1lYXJuJnJvb3ROYW1lPWludHJvZHVjZSZuYXZDb25maWc9bmF2JmluZGV4PTJcIik7XG5cdGNvbW1vbi5hbmFseXRpY3MoXCJhcHBfZWFybl9wcm9kdWN0UGFnZV9leHBsYW5hdGlvbkVudHJhbmNlX2NsaWNrXCIsIHtcblx0XHQnZXhwbGFuYXRpb25DbGFzc2lmeSc6IFwic3RydWN0dXJlZFByb2R1Y3RzXCJcblx0fSk7XG59XG5cbi8vIOabtOWkmuino+ivu1xuZnVuY3Rpb24gdG9Nb3JlRXhwbGFpbih0YWJJbmRleCkge1xuXHRjb21tb24ub3BlblBhZ2VXaXRoUGF0aChgaG9saWdlaXQ6Ly9vcGVuL3YxP2xvZ2luPTEmdXJsPWlodW9iaWdsb2JhbDovL20uaGJnLmNvbS9lZGdlZW5naW5lL2NvbnRhaW5lcj9zY2VuZT1lYXJuJnJvb3ROYW1lPWludHJvZHVjZSZuYXZDb25maWc9bmF2JmluZGV4PTImdGFiSW5kZXg9JHt0YWJJbmRleH1gKTtcblx0Y29tbW9uLmFuYWx5dGljcyhcImFwcF9lYXJuX3Byb2R1Y3RQYWdlX2V4cGxhbmF0aW9uRW50cmFuY2VfY2xpY2tcIiwge1xuXHRcdCdleHBsYW5hdGlvbkNsYXNzaWZ5JzogdGFiSW5kZXggPT0gMSA/IFwiZHVhbEludmVzdG1lbnRcIiA6IFwic2hhcmtGaW5cIlxuXHR9KTtcbn1cblxuZnVuY3Rpb24gdG9JbnRyb2R1Y2UodGFiSW5kZXgpIHtcblx0Y29tbW9uLm9wZW5QYWdlV2l0aFBhdGgoYGhvbGlnZWl0Oi8vb3Blbi92MT9sb2dpbj0xJnVybD1paHVvYmlnbG9iYWw6Ly9tLmhiZy5jb20vZWRnZWVuZ2luZS9jb250YWluZXI/c2NlbmU9ZWFybiZyb290TmFtZT1pbnRyb2R1Y2UmbmF2Q29uZmlnPW5hdiZpbmRleD0yJmhlYWRlckluZGV4PTEmdGFiSW5kZXg9JHt0YWJJbmRleH1gKTtcblx0Y29tbW9uLmFuYWx5dGljcyhcImFwcF9lYXJuX0ZBUXNfbW9yZV9jbGlja1wiLCB7XG5cdFx0J3BhZ2UnOiBcInN0cnVjdHVyZWRQcm9kdWN0c1wiLFxuXHRcdCd0YWJOYW1lJzogdGFiSW5kZXggPT0gMSA/IFwiZHVhbEludmVzdG1lbnRcIiA6IFwic2hhcmtGaW5cIlxuXHR9KTtcbn1cblxuZnVuY3Rpb24gdG9EZXRhaWwoaW5kZXgsIHR5cGUpIHtcblx0dHJ5IHtcblx0XHR2YXIgY3VyRGF0YSA9IG1vZHVsZURhdGEubWFpbkRhdGFbcGFyc2VJbnQoaW5kZXgpXTtcblx0XHRjb25zb2xlLmxvZyhgdG9EZXRhaWwsICR7SlNPTi5zdHJpbmdpZnkoY3VyRGF0YS5yYXdPYmplY3QoKSl9YCk7XG5cdFx0Y29uc3QgY3VycmVuY3kgPSBjdXJEYXRhWydjdXJyZW5jeSddLnRvTG93ZXJDYXNlKCk7XG5cdFx0dmFyIGFyciA9IFtdO1xuXHRcdGlmIChwYXJzZUludCh0eXBlKSA9PSA1KSB7XG5cdFx0XHRhcnIgPSBjdXJEYXRhW1wic3VwcG9ydC1xdW90ZXMtYnV5XCJdO1xuXHRcdH0gZWxzZSB7XG5cdFx0XHRhcnIgPSBjdXJEYXRhW1wic3VwcG9ydC1xdW90ZXMtc2VsbFwiXTtcblx0XHR9XG5cdFx0dmFyIHN1cHBvcnRRdW90ZXMgPSBcIlwiO1xuXHRcdGZvciAodmFyIGkgPSAwOyBpIDwgYXJyLmxlbmd0aDsgaSsrKSB7XG5cdFx0XHRzdXBwb3J0UXVvdGVzID0gc3VwcG9ydFF1b3RlcyArIGFycltpXTtcblx0XHRcdGlmIChpICE9IGFyci5sZW5ndGggLSAxKSB7XG5cdFx0XHRcdHN1cHBvcnRRdW90ZXMgPSBzdXBwb3J0UXVvdGVzICsgXCItXCI7XG5cdFx0XHR9XG5cdFx0fVxuXHRcdGNvbW1vbi5vcGVuUGFnZVdpdGhQYXRoKGBob2xpZ2VpdDovL29wZW4vdjE/bG9naW49MSZ1cmw9aWh1b2JpZ2xvYmFsOi8vbS5oYmcuY29tL2VkZ2VlbmdpbmUvY29udGFpbmVyP3NjZW5lPWRvdWJsZWNvaW4mcm9vdE5hbWU9Y29pbmRldGFpbCZuYXZDb25maWc9bmF0aXZlJnByb2R1Y3RUeXBlSWQ9JHt0eXBlfSZjdXJyZW5jeT0ke2N1cnJlbmN5fSZzdXBwb3J0UXVvdGVzPSR7c3VwcG9ydFF1b3Rlc31gKTtcblxuXHRcdGNvbW1vbi5hbmFseXRpY3MoXCJhcHBfZWFybl9wcm9kdWN0Q2FyZF9jbGlja1wiLCB7XG5cdFx0XHQncGFnZSc6IFwic3RydWN0dXJlZFByb2R1Y3RzXCIsXG5cdFx0XHQndGFiTmFtZSc6IFwiZHVhbEludmVzdG1lbnRcIixcblx0XHRcdCd0b2tlbic6IGN1ckRhdGEuY29pbk5hbWUsXG5cdFx0XHQnb3BlcmF0ZSc6IHR5cGUgPT0gNSA/IFwiYnV5TG93XCIgOiBcInNlbGxIaWdoXCJcblx0XHR9KTtcblx0fSBjYXRjaCAoZSkge1xuXHRcdGNvbnNvbGUubG9nKGB0b0RldGFpbCwgZXJyb3IgPSAke2V9YCk7XG5cdH1cblxufVxuXG4vL+i3s+i9rOeUs+i0rVxuZnVuY3Rpb24gZ29EZXBvc2l0KGlkeCkge1xuXHR2YXIgaXRlbSA9IG1vZHVsZURhdGEucHJvZHVjdExpc3RbaWR4XTtcblx0Y29tbW9uLm9wZW5QYWdlV2l0aFBhdGgoYGhvbGlnZWl0Oi8vb3Blbi92MT9sb2dpbj0xJnVybD1paHVvYmlnbG9iYWw6Ly9tLmhiZy5jb20vZWRnZWVuZ2luZS9jb250YWluZXI/c2NlbmU9c2hhcmtmaW4mcm9vdE5hbWU9ZGVwb3NpdCZuYXZDb25maWc9JnByb2plY3RJZD0ke2l0ZW0uaWR9YCk7XG5cdGNvbW1vbi5hbmFseXRpY3MoXCJhcHBfZWFybl9wcm9kdWN0Q2FyZF9jbGlja1wiLCB7XG5cdFx0J3BhZ2UnOiBcInN0cnVjdHVyZWRQcm9kdWN0c1wiLFxuXHRcdCd0YWJOYW1lJzogXCJzaGFya0ZpblwiLFxuXHRcdCd0b2tlbic6IGl0ZW0uY3VycmVuY3ksXG5cdFx0J3Byb2plY3RJZCc6IGl0ZW0uaWQsXG5cdFx0J3Rlcm0nOiBpdGVtLnRlcm1TdHJcblx0fSk7XG59XG5cbi8v6Lez6L2s5YWo6YOo5Y6G5Y+y5Lqn5ZOBXG5mdW5jdGlvbiBnb0hpc3RvcnkoKSB7XG5cdGNvbW1vbi5vcGVuUGFnZVdpdGhQYXRoKFwiaG9saWdlaXQ6Ly9vcGVuL3YxP2xvZ2luPTAmdXJsPWlodW9iaWdsb2JhbDovL20uaGJnLmNvbS9lZGdlZW5naW5lL2NvbnRhaW5lcj9zY2VuZT1zaGFya2ZpbiZyb290TmFtZT1oaXN0b3J5Jm5hdkNvbmZpZz1uYXRpdmUmcGFnZVR5cGU9b25Hb2luZ1wiKTtcbn1cblxubW9kdWxlRXZlbnQub3BlblBhZ2VXaXRoUGF0aCA9IGZ1bmN0aW9uIChwYXRoLCBpbmRleCkge1xuXHRjb25zb2xlLmxvZyhgcGF0aCA9ICR7cGF0aH0gIGlzQ2xvc2UgPSAke2lzQ2xvc2V9YCk7XG5cdHZhciBjbGlja1Byb2R1Y3RQYWdlID0gXCJcIjtcblx0aWYgKGluZGV4ID09IDEpIHtcblx0XHRjbGlja1Byb2R1Y3RQYWdlID0gXCJuZXdQcm9kdWN0XCI7XG5cdH0gZWxzZSBpZiAoaW5kZXggPT0gMikge1xuXHRcdGNsaWNrUHJvZHVjdFBhZ2UgPSBcIm9uQ2hhaW5FYXJuXCI7XG5cdH0gZWxzZSB7XG5cdFx0Y2xpY2tQcm9kdWN0UGFnZSA9IFwic2ltcGxlRWFyblwiO1xuXHR9XG5cdGNvbW1vbi5vcGVuUGFnZVdpdGhQYXRoKHBhdGgpO1xuXHRjb25zdCB0YWJOYW1lID0gbW9kdWxlRGF0YS5zZWxlY3RlZFRhYiA9PSAnZHVhbCcgPyBcImR1YWxJbnZlc3RtZW50XCIgOiBcInNoYXJrRmluXCI7XG5cdGNvbW1vbi5hbmFseXRpY3MoXCJhcHBfZWFybl9wcm9kdWN0UGFnZV9tb3JlUmVsYXRlZF9jbGlja1wiLCB7XG5cdFx0J3BhZ2UnOiBcInN0cnVjdHVyZWRQcm9kdWN0c1wiLFxuXHRcdHRhYk5hbWUsXG5cdFx0Y2xpY2tQcm9kdWN0UGFnZVxuXHR9KTtcblx0aWYgKGlzQ2xvc2UpIHtcblx0XHRjb21tb24uY29udGFpbmVyQmFjaygtMSk7XG5cdH1cbn1cblxubW9kdWxlRXZlbnQuYm90dG9tT3JkZXJDbGlja2VkID0gZnVuY3Rpb24gKCkge1xuXHRjb21tb24ub3BlblBhZ2VXaXRoUGF0aChcIi9vdGMtb3B0aW9uL3dpbi9oNS9vcmRlclwiKTtcbn1cblxubW9kdWxlRXZlbnQuYm90dG9tQ3VzdG9tQ2xpY2tlZCA9IGZ1bmN0aW9uICgpIHtcblx0Y29tbW9uLm9wZW5QYWdlV2l0aFBhdGgoXCJob2xpZ2VpdDovL29wZW4vdjE/bG9naW49MSZ1cmw9aWh1b2JpZ2xvYmFsOi8vbS5oYmcuY29tL2VkZ2VlbmdpbmUvY29udGFpbmVyP3NjZW5lPWRvdWJsZWNvaW4mcm9vdE5hbWU9Y3VzdG9tJm5hdkNvbmZpZz1uYXRpdmVcIik7XG59XG5cbm1vZHVsZUV2ZW50LmJhY2tDbGlja2VkID0gZnVuY3Rpb24gKCkge1xuXHRjb21tb24uY29udGFpbmVyQmFjaygpO1xuXHRjb21tb24uYW5hbHl0aWNzKFwiYXBwX2Vhcm5fcHJvZHVjdFBhZ2VfcmV0dXJuQnV0dG9uX2NsaWNrXCIpO1xufVxuXG5tb2R1bGVFdmVudC5jbGlja1FBID0gY2xpY2tRQTtcbm1vZHVsZUV2ZW50LnRhYkNsaWNrZWQgPSB0YWJDbGlja2VkO1xubW9kdWxlRXZlbnQuc2hhcmtmaW5UYWJDbGlja2VkID0gc2hhcmtmaW5UYWJDbGlja2VkO1xubW9kdWxlRXZlbnQucmVmcmVzaCA9IHJlZnJlc2g7XG5tb2R1bGVFdmVudC5jbGlja0l0ZW0gPSBjbGlja0l0ZW07XG5tb2R1bGVFdmVudC50b0ludHJvZHVjZSA9IHRvSW50cm9kdWNlO1xubW9kdWxlRXZlbnQudG9EZXRhaWwgPSB0b0RldGFpbDtcbm1vZHVsZUV2ZW50LnRvRXhwbGFpbiA9IHRvRXhwbGFpbjtcbm1vZHVsZUV2ZW50LnRvTW9yZUV4cGxhaW4gPSB0b01vcmVFeHBsYWluO1xubW9kdWxlRXZlbnQuZ29IaXN0b3J5ID0gZ29IaXN0b3J5O1xubW9kdWxlRXZlbnQuZ29EZXBvc2l0ID0gZ29EZXBvc2l0O1xuIiwiaW1wb3J0ICogYXMgY29tbW9uIGZyb20gXCIuL2NvbW1vblwiO1xuXG52YXIgbmVlZEFkZFNob3cgPSBmYWxzZTtcbnZhciBwcm9kdWN0RXhwbGFuYXRpb25Kc29uID0gXCJcIjtcblxuY29uc3QgaW50cm9faGVhZGVyRGF0YSA9IFtcblx0e1xuXHRcdGluZGV4OiAwLFxuXHRcdHR5cGU6IFwiaGVhZGVyXCIsXG5cdFx0dGV4dDogJGkxOG4ubl9zaGFya19maW5fcHJvZHVjdF9ydWxlLFxuXHRcdHRleHRDb2xvcjogXCJAY29sb3Iva0NvbG9yUHJpbWFyeVRleHRcIixcblx0XHRiYWNrQ29sb3I6IFwiQGNvbG9yL0tCYXNlQ29sb3JJbnB1dEJhY2tncm91bmRcIixcblx0XHRib3JkZXJDb2xvcjogXCJAY29sb3IvS0Jhc2VDb2xvcklucHV0QmFja2dyb3VuZFwiXG5cdH0sXG5cdHtcblx0XHRpbmRleDogMSxcblx0XHR0eXBlOiBcImhlYWRlclwiLFxuXHRcdHRleHQ6ICRpMThuLm5fc2hhcmtfZmluX2NvbW1vbl9wcm9ibGVtLFxuXHRcdHRleHRDb2xvcjogXCJAY29sb3Iva0NvbG9yU2Vjb25kYXJ5VGV4dFwiLFxuXHRcdGJhY2tDb2xvcjogXCJAY29sb3IvS0Jhc2VDb2xvckNvbnRlbnRCYWNrZ3JvdW5kXCIsXG5cdFx0Ym9yZGVyQ29sb3I6IFwiQGNvbG9yL0tCYXNlQ29sb3JQcmltYXJ5U2VwYXJhdG9yXCJcblx0fVxuXVxuXG5jb25zdCBpbnRyb19zaW1wbGVfaW5mbyA9IFtcblx0eyB0eXBlOiBcIkgyXCIsIHRleHQ6ICRpMThuLm5fc3RydXR1cmVkX3NpbXBsZV9IXzEgfSxcblx0eyB0eXBlOiBcInRleHRcIiwgdGV4dDogJGkxOG4ubl9zdHJ1dHVyZWRfc2ltcGxlX1RfMSB9LFxuXHR7IHR5cGU6IFwiSDJcIiwgdGV4dDogJGkxOG4ubl9zdHJ1dHVyZWRfc2ltcGxlX0hfMiB9LFxuXHR7IHR5cGU6IFwidGV4dFwiLCB0ZXh0OiAkaTE4bi5uX3N0cnV0dXJlZF9zaW1wbGVfVF8yXzEgfSxcblx0eyB0eXBlOiBcInRleHRcIiwgdGV4dDogJGkxOG4ubl9zdHJ1dHVyZWRfc2ltcGxlX1RfMl8yIH0sXG5cdHsgdHlwZTogXCJ0ZXh0XCIsIHRleHQ6ICRpMThuLm5fc3RydXR1cmVkX3NpbXBsZV9UXzJfMyB9LFxuXHR7IHR5cGU6IFwiSDJcIiwgdGV4dDogJGkxOG4ubl9zdHJ1dHVyZWRfc2ltcGxlX0hfMyB9LFxuXHR7IHR5cGU6IFwidGV4dFwiLCB0ZXh0OiAkaTE4bi5uX3N0cnV0dXJlZF9zaW1wbGVfVF8zIH0sXG5cdHsgdHlwZTogXCJ0ZXh0XCIsIHRleHQ6ICRpMThuLm5fc3RydXR1cmVkX2ludHJvX0FfM18yIH0sXG5cdHsgdHlwZTogXCJ0ZXh0XCIsIHRleHQ6ICRpMThuLm5fc3RydXR1cmVkX2ludHJvX0FfM18zIH0sXG5dXG5cbmNvbnN0IGludHJvX3NpbXBsZV9mbGV4aSA9IFtcblx0W1xuXHRcdHsgdHlwZTogXCJIMlwiLCB0ZXh0OiAkaTE4bi5uX3N0cnV0dXJlZF9mbGV4aV9lYXJuIH0sXG5cdFx0eyB0eXBlOiBcInRleHRcIiwgdGV4dDogJGkxOG4ubl9zdHJ1dHVyZWRfZmxleGlfZWFybl8xIH0sXG5cdFx0eyB0eXBlOiBcInRleHRcIiwgdGV4dDogJGkxOG4ubl9zdHJ1dHVyZWRfZmxleGlfZWFybl8yIH0sXG5cdFx0eyB0eXBlOiBcInRleHRcIiwgdGV4dDogJGkxOG4ubl9zdHJ1dHVyZWRfZmxleGlfZWFybl8zIH0sXG5cdFx0eyB0eXBlOiBcInRleHRcIiwgdGV4dDogJGkxOG4ubl9zdHJ1dHVyZWRfZmxleGlfZWFybl80IH0sXG5cdFx0eyB0eXBlOiBcIkgyXCIsIHRleHQ6ICRpMThuLm5fc3RydXR1cmVkX2ZsZXhpX3dpdGhkcmF3IH0sXG5cdFx0eyB0eXBlOiBcInRleHRcIiwgdGV4dDogJGkxOG4ubl9zdHJ1dHVyZWRfZmxleGlfd2l0aGRyYXdfMSB9LFxuXHRcdHsgdHlwZTogXCJ0ZXh0XCIsIHRleHQ6ICRpMThuLm5fc3RydXR1cmVkX2ZsZXhpX3dpdGhkcmF3XzIgfSxcblx0XHR7IHR5cGU6IFwidGV4dFwiLCB0ZXh0OiAkaTE4bi5uX3N0cnV0dXJlZF9mbGV4aV93aXRoZHJhd18zIH0sXG5cdFx0eyB0eXBlOiBcInRleHRcIiwgdGV4dDogJGkxOG4ubl9zdHJ1dHVyZWRfZmxleGlfd2l0aGRyYXdfNCB9XG5cdF0sXG5cdFt7XG5cdFx0dHlwZTogJ1FBJyxcblx0XHRpbmRleDogMCxcblx0XHRhbnN3ZXJWaXNhYmxlOiAnZ29uZScsXG5cdFx0UTogJGkxOG4ubl9zdHJ1dHVyZWRfZmxleGlfUV8xLFxuXHRcdEE6ICRpMThuLm5fc3RydXR1cmVkX2ZsZXhpX0FfMSxcblx0XHRxYUljb246IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX3NoYXJrX2hvbWVfcWFfc3ByZWFkX2ljb25cIixcblx0fSwge1xuXHRcdHR5cGU6ICdRQScsXG5cdFx0aW5kZXg6IDEsXG5cdFx0YW5zd2VyVmlzYWJsZTogJ2dvbmUnLFxuXHRcdFE6ICRpMThuLm5fc3RydXR1cmVkX2ZsZXhpX1FfMixcblx0XHRBOiAkaTE4bi5uX3N0cnV0dXJlZF9mbGV4aV9BXzIsXG5cdFx0cWFJY29uOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9zaGFya19ob21lX3FhX3NwcmVhZF9pY29uXCIsXG5cdH0sIHtcblx0XHR0eXBlOiAnUUEnLFxuXHRcdGluZGV4OiAyLFxuXHRcdGFuc3dlclZpc2FibGU6ICdnb25lJyxcblx0XHRROiAkaTE4bi5uX3N0cnV0dXJlZF9vbmNoYWluX1FfNCxcblx0XHRBOiAkaTE4bi5uX3N0cnV0dXJlZF9mbGV4aV93aXRoZHJhd18xICsgJ1xcblxcbicgKyAkaTE4bi5uX3N0cnV0dXJlZF9mbGV4aV93aXRoZHJhd18yICsgJ1xcblxcbicgKyAkaTE4bi5uX3N0cnV0dXJlZF9mbGV4aV93aXRoZHJhd18zICsgJ1xcblxcbicgKyAkaTE4bi5uX3N0cnV0dXJlZF9mbGV4aV93aXRoZHJhd180LFxuXHRcdHFhSWNvbjogXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfc2hhcmtfaG9tZV9xYV9zcHJlYWRfaWNvblwiLFxuXHR9LCB7XG5cdFx0dHlwZTogJ1FBJyxcblx0XHRpbmRleDogMyxcblx0XHRhbnN3ZXJWaXNhYmxlOiAnZ29uZScsXG5cdFx0UTogJGkxOG4ubl9zdHJ1dHVyZWRfZmxleGlfUV80LFxuXHRcdEE6ICRpMThuLm5fc3RydXR1cmVkX2ZsZXhpX0FfNCxcblx0XHRxYUljb246IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX3NoYXJrX2hvbWVfcWFfc3ByZWFkX2ljb25cIixcblx0fV1cbl1cblxuY29uc3QgaW50cm9fc2ltcGxlX2ZsZXhpX21heCA9IFtcblx0W1xuXHRcdHsgdHlwZTogXCJIMlwiLCB0ZXh0OiAkaTE4bi5uX3N0cnV0dXJlZF9mbGV4aV9lYXJuIH0sXG5cdFx0eyB0eXBlOiBcInRleHRcIiwgdGV4dDogJGkxOG4ubl9zdHJ1dHVyZWRfZmxleGlfbWF4X2Vhcm5fMSB9LFxuXHRcdHsgdHlwZTogXCJ0ZXh0XCIsIHRleHQ6ICRpMThuLm5fc3RydXR1cmVkX2ZsZXhpX21heF9lYXJuXzIgfSxcblx0XHR7IHR5cGU6IFwidGV4dFwiLCB0ZXh0OiAkaTE4bi5uX3N0cnV0dXJlZF9mbGV4aV9tYXhfZWFybl8zIH0sXG5cdFx0eyB0eXBlOiBcInRleHRcIiwgdGV4dDogJGkxOG4ubl9zdHJ1dHVyZWRfZmxleGlfbWF4X2Vhcm5fNCB9LFxuXHRcdHsgdHlwZTogXCJIMlwiLCB0ZXh0OiAkaTE4bi5uX3N0cnV0dXJlZF9mbGV4aV93aXRoZHJhdyB9LFxuXHRcdHsgdHlwZTogXCJ0ZXh0XCIsIHRleHQ6ICRpMThuLm5fc3RydXR1cmVkX2ZsZXhpX21heF93aXRoZHJhd18xIH0sXG5cdFx0eyB0eXBlOiBcInRleHRcIiwgdGV4dDogJGkxOG4ubl9zdHJ1dHVyZWRfZmxleGlfbWF4X3dpdGhkcmF3XzIgfSxcblx0XSxcblx0W3tcblx0XHR0eXBlOiAnUUEnLFxuXHRcdGluZGV4OiAwLFxuXHRcdGFuc3dlclZpc2FibGU6ICdnb25lJyxcblx0XHRROiAkaTE4bi5uX3N0cnV0dXJlZF9mbGV4aV9tYXhfUV8xLFxuXHRcdEE6ICRpMThuLm5fc3RydXR1cmVkX2ZsZXhpX21heF9BXzEsXG5cdFx0cWFJY29uOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9zaGFya19ob21lX3FhX3NwcmVhZF9pY29uXCIsXG5cdH0sIHtcblx0XHR0eXBlOiAnUUEnLFxuXHRcdGluZGV4OiAxLFxuXHRcdGFuc3dlclZpc2FibGU6ICdnb25lJyxcblx0XHRROiAkaTE4bi5uX3N0cnV0dXJlZF9mbGV4aV9tYXhfUV8yLFxuXHRcdEE6ICRpMThuLm5fc3RydXR1cmVkX2ZsZXhpX21heF9BXzIsXG5cdFx0cWFJY29uOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9zaGFya19ob21lX3FhX3NwcmVhZF9pY29uXCIsXG5cdH0sIHtcblx0XHR0eXBlOiAnUUEnLFxuXHRcdGluZGV4OiAyLFxuXHRcdGFuc3dlclZpc2FibGU6ICdnb25lJyxcblx0XHRROiAkaTE4bi5uX3N0cnV0dXJlZF9mbGV4aV9tYXhfUV8zLFxuXHRcdEE6ICRpMThuLm5fc3RydXR1cmVkX2ZsZXhpX21heF9BXzMsXG5cdFx0cWFJY29uOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9zaGFya19ob21lX3FhX3NwcmVhZF9pY29uXCIsXG5cdH0sIHtcblx0XHR0eXBlOiAnUUEnLFxuXHRcdGluZGV4OiAzLFxuXHRcdGFuc3dlclZpc2FibGU6ICdnb25lJyxcblx0XHRROiAkaTE4bi5uX3N0cnV0dXJlZF9mbGV4aV9tYXhfUV80LFxuXHRcdEE6ICRpMThuLm5fc3RydXR1cmVkX2ZsZXhpX21heF9BXzRfMSArICdcXG5cXG4nICsgJGkxOG4ubl9zdHJ1dHVyZWRfZmxleGlfbWF4X0FfNF8yICsgJ1xcblxcbicgKyAkaTE4bi5uX3N0cnV0dXJlZF9mbGV4aV9tYXhfQV80XzMgKyAnXFxuXFxuJyArICRpMThuLm5fc3RydXR1cmVkX2ZsZXhpX21heF9BXzRfNCArICdcXG5cXG4nICsgJGkxOG4ubl9zdHJ1dHVyZWRfZmxleGlfbWF4X0FfNF81LFxuXHRcdHFhSWNvbjogXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfc2hhcmtfaG9tZV9xYV9zcHJlYWRfaWNvblwiLFxuXHR9XVxuXVxuXG5jb25zdCBpbnRyb19zaW1wbGVfZml4ZWQgPSBbXG5cdFtcblx0XHR7IHR5cGU6IFwiSDJcIiwgdGV4dDogJGkxOG4ubl9zdHJ1dHVyZWRfZmxleGlfZWFybiB9LFxuXHRcdHsgdHlwZTogXCJ0ZXh0XCIsIHRleHQ6ICRpMThuLm5fc3RydXR1cmVkX2ZpeGVkX2Vhcm5fMSB9LFxuXHRcdHsgdHlwZTogXCJ0ZXh0XCIsIHRleHQ6ICRpMThuLm5fc3RydXR1cmVkX2ZpeGVkX2Vhcm5fMiB9LFxuXHRcdHsgdHlwZTogXCJ0ZXh0XCIsIHRleHQ6ICRpMThuLm5fc3RydXR1cmVkX2ZpeGVkX2Vhcm5fMyB9LFxuXHRcdHsgdHlwZTogXCJIMlwiLCB0ZXh0OiAkaTE4bi5uX3N0cnV0dXJlZF9mbGV4aV93aXRoZHJhdyB9LFxuXHRcdHsgdHlwZTogXCJ0ZXh0XCIsIHRleHQ6ICRpMThuLm5fc3RydXR1cmVkX2ZpeGVkX3dpdGhkcmF3IH0sXG5cdF0sXG5cdFt7XG5cdFx0dHlwZTogJ1FBJyxcblx0XHRpbmRleDogMCxcblx0XHRhbnN3ZXJWaXNhYmxlOiAnZ29uZScsXG5cdFx0UTogJGkxOG4ubl9zdHJ1dHVyZWRfZml4ZWRfUV8wLFxuXHRcdEE6ICRpMThuLm5fc3RydXR1cmVkX2ZpeGVkX0FfMSxcblx0XHRxYUljb246IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX3NoYXJrX2hvbWVfcWFfc3ByZWFkX2ljb25cIixcblx0fSwgIHtcblx0XHR0eXBlOiAnUUEnLFxuXHRcdGluZGV4OiAxLFxuXHRcdGFuc3dlclZpc2FibGU6ICdnb25lJyxcblx0XHRROiAkaTE4bi5uX3N0cnV0dXJlZF9maXhlZF9RXzEsXG5cdFx0QTogJGkxOG4ubl9zdHJ1dHVyZWRfZml4ZWRfQV8yLFxuXHRcdHFhSWNvbjogXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfc2hhcmtfaG9tZV9xYV9zcHJlYWRfaWNvblwiLFxuXHR9XVxuXVxuXG5jb25zdCBpbnRyb19zaW1wbGUgPSB7XG5cdHRpdGxlSW5kZXg6IDAsXG5cdHRpdGxlRGF0YTogW1xuXHRcdHtcblx0XHRcdCd0aXRsZSc6ICRpMThuLm5fc3RydXR1cmVkX3Byb2R1Y3RzX3N1bSxcblx0XHRcdCd0aXRsZVNpemUnOiAnMTQnLFxuXHRcdFx0J3RpdGxlQ29sb3InOiAnQGNvbG9yL2tDb2xvclByaW1hcnlUZXh0Jyxcblx0XHRcdCd0YWcnOiAnMCcsXG5cdFx0XHQnc2VsZWN0ZWRsaW5lJzogJ3Zpc2libGUnXG5cdFx0fSwge1xuXHRcdFx0J3RpdGxlJzogJGkxOG4ubl9hc3NldF9lYXJuX2N1cnJlbnQsXG5cdFx0XHQndGl0bGVTaXplJzogJzE0Jyxcblx0XHRcdCd0aXRsZUNvbG9yJzogJ0Bjb2xvci9rQ29sb3JUaHJlZUxldmVsVGV4dCcsXG5cdFx0XHQndGFnJzogJzEnXG5cdFx0fSwge1xuXHRcdFx0J3RpdGxlJzogJGkxOG4ubl9taW5pbmdfYXNzZXRfZml4ZWQsXG5cdFx0XHQndGl0bGVTaXplJzogJzE0Jyxcblx0XHRcdCd0aXRsZUNvbG9yJzogJ0Bjb2xvci9rQ29sb3JUaHJlZUxldmVsVGV4dCcsXG5cdFx0XHQndGFnJzogJzInXG5cdFx0fV0sXG5cdHNsaWRlckRhdGE6IFtcblx0XHR7XG5cdFx0XHRcImxpc3RUeXBlXCI6ICdzbGlkZXJDZWxsJyxcblx0XHRcdGhlYWRlclZpc2liOiBcImdvbmVcIixcblx0XHRcdGhlYWRlckRhdGE6IFtdLFxuXHRcdFx0Y2VsbERhdGE6IGludHJvX3NpbXBsZV9pbmZvXG5cdFx0fSwge1xuXHRcdFx0XCJsaXN0VHlwZVwiOiAnc2xpZGVyQ2VsbCcsXG5cdFx0XHRoZWFkZXJWaXNpYjogXCJ2aXNpYmxlXCIsXG5cdFx0XHRoZWFkZXJEYXRhOiBpbnRyb19oZWFkZXJEYXRhLFxuXHRcdFx0Y2VsbERhdGE6IGludHJvX3NpbXBsZV9mbGV4aVswXVxuXHRcdH0sIHtcblx0XHRcdFwibGlzdFR5cGVcIjogJ3NsaWRlckNlbGwnLFxuXHRcdFx0aGVhZGVyVmlzaWI6IFwidmlzaWJsZVwiLFxuXHRcdFx0aGVhZGVyRGF0YTogaW50cm9faGVhZGVyRGF0YSxcblx0XHRcdGNlbGxEYXRhOiBpbnRyb19zaW1wbGVfZml4ZWRbMF1cblx0XHR9XSxcblx0Y2VsbERhdGFsaXN0OiBbXG5cdFx0W2ludHJvX3NpbXBsZV9pbmZvXSxcblx0XHRpbnRyb19zaW1wbGVfZmxleGksXG5cdFx0aW50cm9fc2ltcGxlX2ZpeGVkXG5cdF0sXG59XG5cbmludHJvX25ld19pbmZvID0gW1xuXHR7IHR5cGU6IFwiSDJcIiwgdGV4dDogJGkxOG4ubl9zdHJ1dHVyZWRfbmV3X0hfMSB9LFxuXHR7IHR5cGU6IFwidGV4dFwiLCB0ZXh0OiAkaTE4bi5uX3N0cnV0dXJlZF9uZXdfVF8xIH0sXG5cdHsgdHlwZTogXCJIMlwiLCB0ZXh0OiAkaTE4bi5uX3N0cnV0dXJlZF9uZXdfSF8yIH0sXG5cdHsgdHlwZTogXCJ0ZXh0XCIsIHRleHQ6ICRpMThuLm5fc3RydXR1cmVkX25ld19UXzJfMSB9LFxuXHR7IHR5cGU6IFwidGV4dFwiLCB0ZXh0OiAkaTE4bi5uX3N0cnV0dXJlZF9uZXdfVF8yXzIgfSxcblx0eyB0eXBlOiBcInRleHRcIiwgdGV4dDogJGkxOG4ubl9zdHJ1dHVyZWRfbmV3X1RfMl8zIH0sXG5cdHsgdHlwZTogXCJIMlwiLCB0ZXh0OiAkaTE4bi5uX3N0cnV0dXJlZF9uZXdfSF8zIH0sXG5cdHsgdHlwZTogXCJ0ZXh0XCIsIHRleHQ6ICRpMThuLm5fc3RydXR1cmVkX3NpbXBsZV9UXzMgfSxcblx0eyB0eXBlOiBcInRleHRcIiwgdGV4dDogJGkxOG4ubl9zdHJ1dHVyZWRfaW50cm9fQV8zXzIgfSxcblx0eyB0eXBlOiBcInRleHRcIiwgdGV4dDogJGkxOG4ubl9zdHJ1dHVyZWRfaW50cm9fQV8zXzMgfSxcbl1cblxuaW50cm9fbmV3X3Byb2JsZW0gPSBbXG5cdHtcblx0XHR0eXBlOiAnUUEnLFxuXHRcdGluZGV4OiAwLFxuXHRcdGFuc3dlclZpc2FibGU6ICdnb25lJyxcblx0XHRROiAkaTE4bi5uX3N0cnV0dXJlZF9uZXdfUV8xLFxuXHRcdEE6ICRpMThuLm5fc3RydXR1cmVkX25ld19BXzEsXG5cdFx0cWFJY29uOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9zaGFya19ob21lX3FhX3NwcmVhZF9pY29uXCIsXG5cdH0sIHtcblx0XHR0eXBlOiAnUUEnLFxuXHRcdGluZGV4OiAxLFxuXHRcdGFuc3dlclZpc2FibGU6ICdnb25lJyxcblx0XHRROiAkaTE4bi5uX3N0cnV0dXJlZF9uZXdfUV8yLFxuXHRcdEE6ICRpMThuLm5fc3RydXR1cmVkX25ld19BXzIsXG5cdFx0cWFJY29uOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9zaGFya19ob21lX3FhX3NwcmVhZF9pY29uXCIsXG5cdH0sIHtcblx0XHR0eXBlOiAnUUEnLFxuXHRcdGluZGV4OiAyLFxuXHRcdGFuc3dlclZpc2FibGU6ICdnb25lJyxcblx0XHRROiAkaTE4bi5uX3N0cnV0dXJlZF9uZXdfUV8zLFxuXHRcdEE6ICRpMThuLm5fc3RydXR1cmVkX25ld19BXzMsXG5cdFx0cWFJY29uOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9zaGFya19ob21lX3FhX3NwcmVhZF9pY29uXCIsXG5cdH1cbl1cblxuY29uc3QgaW50cm9fbmV3ID0ge1xuXHR0aXRsZUluZGV4OiAwLFxuXHR0aXRsZURhdGE6IFtcblx0XHR7XG5cdFx0XHQndGl0bGUnOiAkaTE4bi5uX3N0cnV0dXJlZF9wcm9kdWN0c19zdW0sXG5cdFx0XHQndGl0bGVTaXplJzogJzE0Jyxcblx0XHRcdCd0aXRsZUNvbG9yJzogJ0Bjb2xvci9rQ29sb3JQcmltYXJ5VGV4dCcsXG5cdFx0XHQndGFnJzogJzAnLFxuXHRcdFx0J3NlbGVjdGVkbGluZSc6ICd2aXNpYmxlJ1xuXHRcdH0sIHtcblx0XHRcdCd0aXRsZSc6ICRpMThuLm5fc2hhcmtfZmluX2NvbW1vbl9wcm9ibGVtLFxuXHRcdFx0J3RpdGxlU2l6ZSc6ICcxNCcsXG5cdFx0XHQndGl0bGVDb2xvcic6ICdAY29sb3Iva0NvbG9yVGhyZWVMZXZlbFRleHQnLFxuXHRcdFx0J3RhZyc6ICcxJ1xuXHRcdH1dLFxuXHRzbGlkZXJEYXRhOiBbXG5cdFx0e1xuXHRcdFx0XCJsaXN0VHlwZVwiOiAnc2xpZGVyQ2VsbCcsXG5cdFx0XHRoZWFkZXJWaXNpYjogXCJnb25lXCIsXG5cdFx0XHRoZWFkZXJEYXRhOiBbXSxcblx0XHRcdGNlbGxEYXRhOiBpbnRyb19uZXdfaW5mb1xuXHRcdH0sIHtcblx0XHRcdFwibGlzdFR5cGVcIjogJ3NsaWRlckNlbGwnLFxuXHRcdFx0aGVhZGVyVmlzaWI6IFwiZ29uZVwiLFxuXHRcdFx0aGVhZGVyRGF0YTogW10sXG5cdFx0XHRjZWxsRGF0YTogaW50cm9fbmV3X3Byb2JsZW1cblx0XHR9XSxcblx0Y2VsbERhdGFsaXN0OiBbXG5cdFx0W2ludHJvX25ld19pbmZvXSxcblx0XHRbaW50cm9fbmV3X3Byb2JsZW1dXG5cdF0sXG59IFxuXG5pbnRyb19vbmNoYWluX2luZm8gPSBbXG5cdHsgdHlwZTogXCJIMlwiLCB0ZXh0OiAkaTE4bi5uX3N0cnV0dXJlZF9vbmNoYWluX0hfMSB9LFxuXHR7IHR5cGU6IFwidGV4dFwiLCB0ZXh0OiAkaTE4bi5uX3N0cnV0dXJlZF9vbmNoYWluX1RfMSB9LFxuXHR7IHR5cGU6IFwiSDJcIiwgdGV4dDogJGkxOG4ubl9zdHJ1dHVyZWRfb25jaGFpbl9IXzIgfSxcblx0eyB0eXBlOiBcInRleHRcIiwgdGV4dDogJGkxOG4ubl9zdHJ1dHVyZWRfb25jaGFpbl9UXzIgfSxcblx0eyB0eXBlOiBcIkgyXCIsIHRleHQ6ICRpMThuLm5fc3RydXR1cmVkX29uY2hhaW5fSF8zIH0sXG5cdHsgdHlwZTogXCJ0ZXh0XCIsIHRleHQ6ICRpMThuLm5fc3RydXR1cmVkX29uY2hhaW5fVF8zXzEgfSxcblx0eyB0eXBlOiBcInRleHRcIiwgdGV4dDogJGkxOG4ubl9zdHJ1dHVyZWRfb25jaGFpbl9UXzNfMiB9LFxuXHR7IHR5cGU6IFwidGV4dFwiLCB0ZXh0OiAkaTE4bi5uX3N0cnV0dXJlZF9vbmNoYWluX1RfM18zIH0sXG5cdHsgdHlwZTogXCJIMlwiLCB0ZXh0OiAkaTE4bi5uX3N0cnV0dXJlZF9vbmNoYWluX0hfNCB9LFxuXHR7IHR5cGU6IFwidGV4dFwiLCB0ZXh0OiAkaTE4bi5uX3N0cnV0dXJlZF9vbmNoYWluX1RfNCB9LFxuXHR7IHR5cGU6IFwidGV4dFwiLCB0ZXh0OiAkaTE4bi5uX3N0cnV0dXJlZF9pbnRyb19BXzNfMyB9LFxuXHR7IHR5cGU6IFwidGV4dFwiLCB0ZXh0OiAkaTE4bi5uX3N0cnV0dXJlZF9pbnRyb19BXzNfMiB9LFxuXVxuXG5pbnRyb19vbmNoYWluX3J1bGUgPSBbXG5cdHsgdHlwZTogXCJIMlwiLCB0ZXh0OiAkaTE4bi5uX3N0cnV0dXJlZF9vbmNoYWluX2Vhcm4gfSxcblx0eyB0eXBlOiBcInRleHRcIiwgdGV4dDogJGkxOG4ubl9zdHJ1dHVyZWRfb25jaGFpbl9lYXJuXzEgfSxcblx0eyB0eXBlOiBcInRleHRcIiwgdGV4dDogJGkxOG4ubl9zdHJ1dHVyZWRfb25jaGFpbl9lYXJuXzIgfSxcblx0eyB0eXBlOiBcInRleHRcIiwgdGV4dDogJGkxOG4ubl9zdHJ1dHVyZWRfb25jaGFpbl9lYXJuXzMgfSxcblx0eyB0eXBlOiBcIkgyXCIsIHRleHQ6ICRpMThuLm5fc3RydXR1cmVkX2ZsZXhpX3dpdGhkcmF3IH0sXG5cdHsgdHlwZTogXCJ0ZXh0XCIsIHRleHQ6ICRpMThuLm5fc3RydXR1cmVkX29uY2hhaW5fd2l0aGRyYXdfMSB9XG5dXG5cbmludHJvX29uY2hhaW5fcHJvYmxlbSA9IFtcblx0e1xuXHRcdHR5cGU6ICdRQScsXG5cdFx0aW5kZXg6IDAsXG5cdFx0YW5zd2VyVmlzYWJsZTogJ2dvbmUnLFxuXHRcdFE6ICRpMThuLm5fc3RydXR1cmVkX29uY2hhaW5fUV8xLFxuXHRcdEE6ICRpMThuLm5fc3RydXR1cmVkX29uY2hhaW5fQV8xLFxuXHRcdHFhSWNvbjogXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfc2hhcmtfaG9tZV9xYV9zcHJlYWRfaWNvblwiLFxuXHR9LCB7XG5cdFx0dHlwZTogJ1FBJyxcblx0XHRpbmRleDogMSxcblx0XHRhbnN3ZXJWaXNhYmxlOiAnZ29uZScsXG5cdFx0UTogJGkxOG4ubl9zdHJ1dHVyZWRfb25jaGFpbl9RXzIsXG5cdFx0QTogJGkxOG4ubl9zdHJ1dHVyZWRfb25jaGFpbl9BXzIsXG5cdFx0cWFJY29uOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9zaGFya19ob21lX3FhX3NwcmVhZF9pY29uXCIsXG5cdH0sIHtcblx0XHR0eXBlOiAnUUEnLFxuXHRcdGluZGV4OiAyLFxuXHRcdGFuc3dlclZpc2FibGU6ICdnb25lJyxcblx0XHRROiAkaTE4bi5uX3N0cnV0dXJlZF9vbmNoYWluX1FfMyxcblx0XHRBOiAkaTE4bi5uX3N0cnV0dXJlZF9vbmNoYWluX0FfM18xICsgJ1xcblxcbicgKyAkaTE4bi5uX3N0cnV0dXJlZF9vbmNoYWluX0FfM18yLFxuXHRcdHFhSWNvbjogXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfc2hhcmtfaG9tZV9xYV9zcHJlYWRfaWNvblwiLFxuXHR9LCB7XG5cdFx0dHlwZTogJ1FBJyxcblx0XHRpbmRleDogMyxcblx0XHRhbnN3ZXJWaXNhYmxlOiAnZ29uZScsXG5cdFx0UTogJGkxOG4ubl9zdHJ1dHVyZWRfb25jaGFpbl9RXzQsXG5cdFx0QTogJGkxOG4ubl9zdHJ1dHVyZWRfb25jaGFpbl9BXzQsXG5cdFx0cWFJY29uOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9zaGFya19ob21lX3FhX3NwcmVhZF9pY29uXCIsXG5cdH0sIHtcblx0XHR0eXBlOiAnUUEnLFxuXHRcdGluZGV4OiA0LFxuXHRcdGFuc3dlclZpc2FibGU6ICdnb25lJyxcblx0XHRROiAkaTE4bi5uX3N0cnV0dXJlZF9vbmNoYWluX1FfNSxcblx0XHRBOiAkaTE4bi5uX3N0cnV0dXJlZF9vbmNoYWluX0FfNSxcblx0XHRxYUljb246IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX3NoYXJrX2hvbWVfcWFfc3ByZWFkX2ljb25cIixcblx0fVxuXVxuXG5jb25zdCBpbnRyb19vbmNoYWluID0ge1xuXHR0aXRsZUluZGV4OiAwLFxuXHR0aXRsZURhdGE6IFtcblx0XHR7XG5cdFx0XHQndGl0bGUnOiAkaTE4bi5uX3N0cnV0dXJlZF9wcm9kdWN0c19zdW0sXG5cdFx0XHQndGl0bGVTaXplJzogJzE0Jyxcblx0XHRcdCd0aXRsZUNvbG9yJzogJ0Bjb2xvci9rQ29sb3JQcmltYXJ5VGV4dCcsXG5cdFx0XHQndGFnJzogJzAnLFxuXHRcdFx0J3NlbGVjdGVkbGluZSc6ICd2aXNpYmxlJ1xuXHRcdH0sIHtcblx0XHRcdCd0aXRsZSc6ICRpMThuLm5fc2hhcmtfZmluX3Byb2R1Y3RfcnVsZSxcblx0XHRcdCd0aXRsZVNpemUnOiAnMTQnLFxuXHRcdFx0J3RpdGxlQ29sb3InOiAnQGNvbG9yL2tDb2xvclRocmVlTGV2ZWxUZXh0Jyxcblx0XHRcdCd0YWcnOiAnMSdcblx0XHR9LCB7XG5cdFx0XHQndGl0bGUnOiAkaTE4bi5uX3NoYXJrX2Zpbl9jb21tb25fcHJvYmxlbSxcblx0XHRcdCd0aXRsZVNpemUnOiAnMTQnLFxuXHRcdFx0J3RpdGxlQ29sb3InOiAnQGNvbG9yL2tDb2xvclRocmVlTGV2ZWxUZXh0Jyxcblx0XHRcdCd0YWcnOiAnMidcblx0XHR9XSxcblx0c2xpZGVyRGF0YTogW1xuXHRcdHtcblx0XHRcdFwibGlzdFR5cGVcIjogJ3NsaWRlckNlbGwnLFxuXHRcdFx0aGVhZGVyVmlzaWI6IFwiZ29uZVwiLFxuXHRcdFx0aGVhZGVyRGF0YTogW10sXG5cdFx0XHRjZWxsRGF0YTogaW50cm9fb25jaGFpbl9pbmZvXG5cdFx0fSwge1xuXHRcdFx0XCJsaXN0VHlwZVwiOiAnc2xpZGVyQ2VsbCcsXG5cdFx0XHRoZWFkZXJWaXNpYjogXCJnb25lXCIsXG5cdFx0XHRoZWFkZXJEYXRhOiBbXSxcblx0XHRcdGNlbGxEYXRhOiBpbnRyb19vbmNoYWluX3J1bGVcblx0XHR9LCB7XG5cdFx0XHRcImxpc3RUeXBlXCI6ICdzbGlkZXJDZWxsJyxcblx0XHRcdGhlYWRlclZpc2liOiBcImdvbmVcIixcblx0XHRcdGhlYWRlckRhdGE6IFtdLFxuXHRcdFx0Y2VsbERhdGE6IGludHJvX29uY2hhaW5fcHJvYmxlbVxuXHRcdH1dLFxuXHRjZWxsRGF0YWxpc3Q6IFtcblx0XHRbaW50cm9fb25jaGFpbl9pbmZvXSxcblx0XHRbaW50cm9fb25jaGFpbl9ydWxlXSxcblx0XHRbaW50cm9fb25jaGFpbl9wcm9ibGVtXVxuXHRdLFxufSBcblxuY29uc3QgaW50cm9fc3RydWN0dXJlZF9pbmZvID0gW1xuXHR7IHR5cGU6IFwiSDJcIiwgdGV4dDogJGkxOG4ubl9zdHJ1dHVyZWRfaW50cm9fUV8xIH0sXG5cdHsgdHlwZTogXCJ0ZXh0XCIsIHRleHQ6ICRpMThuLm5fc3RydXR1cmVkX2ludHJvX0FfMSB9LFxuXHR7IHR5cGU6IFwiSDJcIiwgdGV4dDogJGkxOG4ubl9zdHJ1dHVyZWRfaW50cm9fUV8yIH0sXG5cdHsgdHlwZTogXCJ0ZXh0XCIsIHRleHQ6ICRpMThuLm5fc3RydXR1cmVkX2ludHJvX0FfMl8xIH0sXG5cdHsgdHlwZTogXCJ0ZXh0XCIsIHRleHQ6ICRpMThuLm5fc3RydXR1cmVkX2ludHJvX0FfMl8yIH0sXG5cdHsgdHlwZTogXCJ0ZXh0XCIsIHRleHQ6ICRpMThuLm5fc3RydXR1cmVkX2ludHJvX0FfMl8zIH0sXG5cdHsgdHlwZTogXCJIMlwiLCB0ZXh0OiAkaTE4bi5uX3N0cnV0dXJlZF9pbnRyb19RXzMgfSxcblx0eyB0eXBlOiBcInRleHRcIiwgdGV4dDogJGkxOG4ubl9zdHJ1dHVyZWRfaW50cm9fQV8zXzEgfSxcblx0eyB0eXBlOiBcInRleHRcIiwgdGV4dDogJGkxOG4ubl9zdHJ1dHVyZWRfaW50cm9fQV8zXzIgfSxcblx0eyB0eXBlOiBcInRleHRcIiwgdGV4dDogJGkxOG4ubl9zdHJ1dHVyZWRfaW50cm9fQV8zXzMgfSxcbl1cblxuY29uc3QgaW50cm9fZHVhbCA9IFtcblx0W1xuXHRcdHsgdHlwZTogXCJIMlwiLCB0ZXh0OiAkaTE4bi5uX2RvdWJsZV9jb2luX2Vhcm5faXNzdWVfb25lIH0sXG5cdFx0eyB0eXBlOiBcInRleHRcIiwgdGV4dDogJGkxOG4ubl9zdHJ1dHVyZWRfQV9kdWFsX24gfSxcblx0XHR7IHR5cGU6IFwiSDJcIiwgdGV4dDogJGkxOG4ubl9kb3VibGVfY29pbl9lYXJuaW5nc19jb25maXJtX2hvdyB9LFxuXHRcdHsgdHlwZTogXCJ0ZXh0XCIsIHRleHQ6ICRpMThuLm5fZG91YmxlX2NvaW5fZWFybmluZ3NfY29uZmlybSB9LFxuXHRcdHsgdHlwZTogXCJIMlwiLCB0ZXh0OiAkaTE4bi5uX2RvdWJsZV9jb2luX2h0eF9hZHZhbnRhZ2Vfd2hhdF9uIH0sXG5cdFx0eyB0eXBlOiBcIkgzXCIsIHRleHQ6ICRpMThuLm5fZG91YmxlX2NvaW5faHR4X2FkdmFudGFnZV9vbmVfbiB9LFxuXHRcdHsgdHlwZTogXCJ0ZXh0XCIsIHRleHQ6ICRpMThuLm5fZG91YmxlX2NvaW5faHR4X2FkdmFudGFnZV9vbmVfaW5mb19uIH0sXG5cdFx0eyB0eXBlOiBcIkgzXCIsIHRleHQ6ICRpMThuLm5fZG91YmxlX2NvaW5faHR4X2FkdmFudGFnZV90d28gfSxcblx0XHR7IHR5cGU6IFwidGV4dFwiLCB0ZXh0OiAkaTE4bi5uX2RvdWJsZV9jb2luX2h0eF9hZHZhbnRhZ2VfaW5mbyB9LFxuXHRcdHsgdHlwZTogXCJIM1wiLCB0ZXh0OiAkaTE4bi5uX2RvdWJsZV9jb2luX2h0eF9hZHZhbnRhZ2VfdGhyZWUgfSxcblx0XHR7IHR5cGU6IFwidGV4dFwiLCB0ZXh0OiAkaTE4bi5uX2RvdWJsZV9jb2luX2h0eF9hZHZhbnRhZ2VfdGhyZWVfaW5mbyB9LFxuXHRcdHsgdHlwZTogXCJIMlwiLCB0ZXh0OiAkaTE4bi5uX2RvdWJsZV9jb2luX3Rlcm1fZGVmaW5pdGlvbiB9LFxuXHRcdHsgdHlwZTogXCJ0ZXh0XCIsIHRleHQ6ICRpMThuLm5fZG91YmxlX2NvaW5fdGVybV9kZWZpbml0aW9uX29uZSB9LFxuXHRcdHsgdHlwZTogXCJ0ZXh0XCIsIHRleHQ6ICRpMThuLm5fZG91YmxlX2NvaW5fdGVybV9kZWZpbml0aW9uX3R3byB9LFxuXHRcdHsgdHlwZTogXCJ0ZXh0XCIsIHRleHQ6ICRpMThuLm5fZG91YmxlX2NvaW5fdGVybV9kZWZpbml0aW9uX3RocmVlIH0sXG5cdFx0eyB0eXBlOiBcInRleHRcIiwgdGV4dDogJGkxOG4ubl9kb3VibGVfY29pbl90ZXJtX2RlZmluaXRpb25fc2l4IH0sXG5cdFx0eyB0eXBlOiBcInRleHRcIiwgdGV4dDogJGkxOG4ubl9kb3VibGVfY29pbl90ZXJtX2RlZmluaXRpb25fc2V2ZW4gfSxcblx0XHR7IHR5cGU6IFwidGV4dFwiLCB0ZXh0OiAkaTE4bi5uX2RvdWJsZV9jb2luX3Rlcm1fZGVmaW5pdGlvbl9laWdodF9sYXRlc3QgfSxcblx0XSxcblx0W3tcblx0XHR0eXBlOiAnUUEnLFxuXHRcdGluZGV4OiAwLFxuXHRcdGFuc3dlclZpc2FibGU6ICdnb25lJyxcblx0XHRROiAkaTE4bi5uX2RvdWJsZV9jb2luX2Vhcm5faXNzdWVfb25lLFxuXHRcdEE6ICRpMThuLm5fc3RydXR1cmVkX0FfZHVhbF9uLFxuXHRcdHFhSWNvbjogXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfc2hhcmtfaG9tZV9xYV9zcHJlYWRfaWNvblwiLFxuXHR9LCB7XG5cdFx0dHlwZTogJ1FBJyxcblx0XHRpbmRleDogMSxcblx0XHRhbnN3ZXJWaXNhYmxlOiAnZ29uZScsXG5cdFx0UTogJGkxOG4ubl9kb3VibGVfY29pbl9lYXJuX2lzc3VlX3R3byxcblx0XHRBOiAkaTE4bi5uX2RvdWJsZV9jb2luX2Vhcm5fYW5zd2VyX3R3b19wYXJ0X29uZSArICdcXG5cXG4nICsgJGkxOG4ubl9kb3VibGVfY29pbl9lYXJuX2Fuc3dlcl90d29fcGFydF90d28sXG5cdFx0cWFJY29uOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9zaGFya19ob21lX3FhX3NwcmVhZF9pY29uXCIsXG5cdH0sIHtcblx0XHR0eXBlOiAnUUEnLFxuXHRcdGluZGV4OiAyLFxuXHRcdGFuc3dlclZpc2FibGU6ICdnb25lJyxcblx0XHRROiAkaTE4bi5uX2RvdWJsZV9jb2luX2Vhcm5faXNzdWVfdGhyZWUsXG5cdFx0QTogJGkxOG4ubl9kb3VibGVfY29pbl9lYXJuX2Fuc3dlcl90aHJlZV9wYXJ0X29uZSArICdcXG5cXG4nICsgJGkxOG4ubl9kb3VibGVfY29pbl9lYXJuX2Fuc3dlcl90aHJlZV9wYXJ0X3R3byArICdcXG5cXG4nICsgJGkxOG4ubl9kb3VibGVfY29pbl9lYXJuX2Fuc3dlcl90aHJlZV9wYXJ0X3RocmVlLFxuXHRcdHFhSWNvbjogXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfc2hhcmtfaG9tZV9xYV9zcHJlYWRfaWNvblwiLFxuXHR9LCB7XG5cdFx0dHlwZTogJ1FBJyxcblx0XHRpbmRleDogMyxcblx0XHRhbnN3ZXJWaXNhYmxlOiAnZ29uZScsXG5cdFx0UTogJGkxOG4ubl9kb3VibGVfY29pbl9lYXJuX2lzc3VlX2ZvdXJfbmV3LFxuXHRcdEE6ICRpMThuLm5fZG91YmxlX2NvaW5fZWFybl9hbnN3ZXJfZm91cixcblx0XHRxYUljb246IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX3NoYXJrX2hvbWVfcWFfc3ByZWFkX2ljb25cIixcblx0fSwge1xuXHRcdHR5cGU6ICdRQScsXG5cdFx0aW5kZXg6IDQsXG5cdFx0YW5zd2VyVmlzYWJsZTogJ2dvbmUnLFxuXHRcdFE6ICRpMThuLm5fZG91YmxlX2NvaW5fZWFybl9pc3N1ZV9maXZlLFxuXHRcdEE6ICRpMThuLm5fZG91YmxlX2NvaW5fZWFybl9hbnN3ZXJfZml2ZV9wYXJ0X29uZSArICdcXG5cXG4nICsgJGkxOG4ubl9kb3VibGVfY29pbl9lYXJuX2Fuc3dlcl9maXZlX3BhcnRfdHdvX2MsXG5cdFx0cWFJY29uOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9zaGFya19ob21lX3FhX3NwcmVhZF9pY29uXCIsXG5cdH1dLFxuXHRbXG5cdFx0eyB0eXBlOiBcIkgyXCIsIHRleHQ6ICRpMThuLm5fZG91YmxlX2NvaW5fcHJvZHVjdF9vcGVyYXRpb25faG93IH0sXG5cdFx0eyB0eXBlOiBcInRleHRcIiwgdGV4dDogJGkxOG4ubl9kb3VibGVfY29pbl9wcm9kdWN0X29wZXJhdGlvbl9jYXRlIH0sXG5cdFx0eyB0eXBlOiBcInRleHRcIiwgdGV4dDogJGkxOG4ubl9kb3VibGVfY29pbl9wcm9kdWN0X29wZXJhdGlvbl9lZyB9LFxuXHRcdHsgdHlwZTogXCJIMlwiLCB0ZXh0OiAkaTE4bi5uX2RvdWJsZV9jb2luX3Byb2R1Y3Rfb3BlcmF0aW9uX2VnX3NlbGwgfSxcblx0XHR7IHR5cGU6IFwidGV4dFwiLCB0ZXh0OiAkaTE4bi5uX2RvdWJsZV9jb2luX3Byb2R1Y3Rfb3BlcmF0aW9uX2VnX3NlbGxfaW5mbyB9LFxuXHRcdHsgdHlwZTogXCJIM1wiLCB0ZXh0OiAkaTE4bi5uX2RvdWJsZV9jb2luX3Byb2R1Y3Rfb3BlcmF0aW9uX2VnX3NlbGxfb25lIH0sXG5cdFx0eyB0eXBlOiBcInRleHRfbFwiLCB0ZXh0OiAkaTE4bi5uX2RvdWJsZV9jb2luX3Byb2R1Y3Rfb3BlcmF0aW9uX2VnX3NlbGxfb25lX2dyZWF0ZXIsIGJvdHRvbUhlaWdodDogNCB9LFxuXHRcdHsgdHlwZTogXCJ0ZXh0X2xcIiwgdGV4dDogJGkxOG4ubl9kb3VibGVfY29pbl9wcm9kdWN0X29wZXJhdGlvbl9lZ19zZWxsX29uZV9sZXNzLCBib3R0b21IZWlnaHQ6IDEyIH0sXG5cdFx0eyB0eXBlOiBcIkgzXCIsIHRleHQ6ICRpMThuLm5fZG91YmxlX2NvaW5fcHJvZHVjdF9vcGVyYXRpb25fZWdfc2VsbF90d28gfSxcblx0XHR7IHR5cGU6IFwidGV4dF9sXCIsIHRleHQ6ICRpMThuLm5fZG91YmxlX2NvaW5fcHJvZHVjdF9vcGVyYXRpb25fZWdfc2VsbF9vbmVfbGVzcywgYm90dG9tSGVpZ2h0OiA0IH0sXG5cdFx0eyB0eXBlOiBcInRleHRfbFwiLCB0ZXh0OiAkaTE4bi5uX2RvdWJsZV9jb2luX3Byb2R1Y3Rfb3BlcmF0aW9uX2VnX3NlbGxfdHdvX3R3bywgYm90dG9tSGVpZ2h0OiA0IH0sXG5cdFx0eyB0eXBlOiBcInRleHRfbFwiLCB0ZXh0OiAkaTE4bi5uX2RvdWJsZV9jb2luX3Byb2R1Y3Rfb3BlcmF0aW9uX2VnX3NlbGxfdHdvX3RocmVlLCBib3R0b21IZWlnaHQ6IDEyIH0sXG5cdFx0eyB0eXBlOiBcInRleHRcIiwgdGV4dDogJGkxOG4ubl9kb3VibGVfY29pbl9wcm9kdWN0X29wZXJhdGlvbl9lZ19zZWxsX2FsbCB9LFxuXHRcdHsgdHlwZTogXCJIMlwiLCB0ZXh0OiAkaTE4bi5uX2RvdWJsZV9jb2luX3Byb2R1Y3Rfb3BlcmF0aW9uX2Vuc2FtcGxlIH0sXG5cdFx0eyB0eXBlOiBcInRleHRcIiwgdGV4dDogJGkxOG4ubl9kb3VibGVfY29pbl9lbnNhbXBsZV9zZWxsX2luZm8gfSxcblx0XHR7IHR5cGU6IFwiSDNcIiwgdGV4dDogJGkxOG4ubl9kb3VibGVfY29pbl9lbnNhbXBsZV9zZWxsX29uZSB9LFxuXHRcdHsgdHlwZTogXCJ0ZXh0XCIsIHRleHQ6ICRpMThuLm5fZG91YmxlX2NvaW5fZW5zYW1wbGVfc2VsbF9vbmVfaW5mbyB9LFxuXHRcdHsgdHlwZTogXCJIM1wiLCB0ZXh0OiAkaTE4bi5uX2RvdWJsZV9jb2luX2Vuc2FtcGxlX3NlbGxfdHdvIH0sXG5cdFx0eyB0eXBlOiBcInRleHRcIiwgdGV4dDogJGkxOG4ubl9kb3VibGVfY29pbl9lbnNhbXBsZV9zZWxsX3R3b19pbmZvIH0sXG5cdFx0eyB0eXBlOiBcIkgzXCIsIHRleHQ6ICRpMThuLm5fZG91YmxlX2NvaW5fZW5zYW1wbGVfc2VsbF90aHJlZSB9LFxuXHRcdHsgdHlwZTogXCJ0ZXh0XCIsIHRleHQ6ICRpMThuLm5fZG91YmxlX2NvaW5fZW5zYW1wbGVfc2VsbF90aHJlZV9pbmZvIH0sXG5cdFx0eyB0eXBlOiBcIkgyXCIsIHRleHQ6ICRpMThuLm5fZG91YmxlX2NvaW5fcHJvZHVjdF9vcGVyYXRpb25fZWdfYnV5IH0sXG5cdFx0eyB0eXBlOiBcInRleHRcIiwgdGV4dDogJGkxOG4ubl9kb3VibGVfY29pbl9wcm9kdWN0X29wZXJhdGlvbl9lZ19idXlfaW5mbyB9LFxuXHRcdHsgdHlwZTogXCJIM1wiLCB0ZXh0OiAkaTE4bi5uX2RvdWJsZV9jb2luX3Byb2R1Y3Rfb3BlcmF0aW9uX2VnX3NlbGxfb25lIH0sXG5cdFx0eyB0eXBlOiBcInRleHRfbFwiLCB0ZXh0OiAkaTE4bi4kaW50ZXJjZXB0Lm5fZG91YmxlX2NvaW5fcHJvZHVjdF9vcGVyYXRpb25fZWdfYnV5X29uZV9sZXNzKCfiiaQnKSwgYm90dG9tSGVpZ2h0OiA0IH0sXG5cdFx0eyB0eXBlOiBcInRleHRfbFwiLCB0ZXh0OiAkaTE4bi5uX2RvdWJsZV9jb2luX3Byb2R1Y3Rfb3BlcmF0aW9uX2VnX2J1eV9vbmVfZ3JlYXRlciwgYm90dG9tSGVpZ2h0OiAxMiB9LFxuXHRcdHsgdHlwZTogXCJIM1wiLCB0ZXh0OiAkaTE4bi5uX2RvdWJsZV9jb2luX3Byb2R1Y3Rfb3BlcmF0aW9uX2VnX3NlbGxfdHdvIH0sXG5cdFx0eyB0eXBlOiBcInRleHRfbFwiLCB0ZXh0OiAkaTE4bi5uX2RvdWJsZV9jb2luX3Byb2R1Y3Rfb3BlcmF0aW9uX2VnX2J1eV9vbmVfZ3JlYXRlciwgYm90dG9tSGVpZ2h0OiA0IH0sXG5cdFx0eyB0eXBlOiBcInRleHRfbFwiLCB0ZXh0OiAkaTE4bi5uX2RvdWJsZV9jb2luX3Byb2R1Y3Rfb3BlcmF0aW9uX2VnX2J1eV90d29fdHdvLCBib3R0b21IZWlnaHQ6IDQgfSxcblx0XHR7IHR5cGU6IFwidGV4dF9sXCIsIHRleHQ6ICRpMThuLm5fZG91YmxlX2NvaW5fcHJvZHVjdF9vcGVyYXRpb25fZWdfYnV5X3R3b190aHJlZSwgYm90dG9tSGVpZ2h0OiAxMiB9LFxuXHRcdHsgdHlwZTogXCJ0ZXh0XCIsIHRleHQ6ICRpMThuLm5fZG91YmxlX2NvaW5fcHJvZHVjdF9vcGVyYXRpb25fZWdfYnV5X2FsbCB9LFxuXHRcdHsgdHlwZTogXCJIMlwiLCB0ZXh0OiAkaTE4bi5uX2RvdWJsZV9jb2luX3Byb2R1Y3Rfb3BlcmF0aW9uX2Vuc2FtcGxlIH0sXG5cdFx0eyB0eXBlOiBcInRleHRcIiwgdGV4dDogJGkxOG4ubl9kb3VibGVfY29pbl9lbnNhbXBsZV9idXlfaW5mbyB9LFxuXHRcdHsgdHlwZTogXCJIM1wiLCB0ZXh0OiAkaTE4bi5uX2RvdWJsZV9jb2luX2Vuc2FtcGxlX2J1eV9vbmUgfSxcblx0XHR7IHR5cGU6IFwidGV4dFwiLCB0ZXh0OiAkaTE4bi5uX2RvdWJsZV9jb2luX2Vuc2FtcGxlX2J1eV9vbmVfaW5mbyB9LFxuXHRcdHsgdHlwZTogXCJIM1wiLCB0ZXh0OiAkaTE4bi5uX2RvdWJsZV9jb2luX2Vuc2FtcGxlX2J1eV90d28gfSxcblx0XHR7IHR5cGU6IFwidGV4dFwiLCB0ZXh0OiAkaTE4bi5uX2RvdWJsZV9jb2luX2Vuc2FtcGxlX2J1eV90d29faW5mbyB9LFxuXHRcdHsgdHlwZTogXCJIM1wiLCB0ZXh0OiAkaTE4bi5uX2RvdWJsZV9jb2luX2Vuc2FtcGxlX2J1eV90aHJlZSB9LFxuXHRcdHsgdHlwZTogXCJ0ZXh0XCIsIHRleHQ6ICRpMThuLm5fZG91YmxlX2NvaW5fZW5zYW1wbGVfYnV5X3RocmVlX2luZm8gfSxcblx0XVxuXVxuXG5jb25zdCBpbnRyb19zaGFya2ZpbiA9IFtcblx0W1xuXHRcdHsgdHlwZTogXCJIMlwiLCB0ZXh0OiAkaTE4bi5uX3NoYXJrX2Zpbl90aGVvcnlfcXVlc3Rpb24gfSxcblx0XHR7IHR5cGU6IFwidGV4dFwiLCB0ZXh0OiAkaTE4bi5uX3NoYXJrX2Zpbl90aGVvcnlfYW5zd2VyX25ldyB9LFxuXHRcdHsgdHlwZTogXCJ0ZXh0XCIsIHRleHQ6ICRpMThuLm5fc2hhcmtfZmluX3RoZW9yeV9kaXNjbGFpbWVyIH0sXG5cdFx0eyB0eXBlOiBcIkgyXCIsIHRleHQ6ICRpMThuLm5fc2hhcmtfZmluX3VwIH0sXG5cdFx0eyB0eXBlOiBcIkFQWV9Fc3RcIiwgc3JjOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9zaGFya2Zpbl9pbnRyb2R1Y2VfdXBcIiB9LFxuXHRcdHsgdHlwZTogXCJIM1wiLCB0ZXh0OiAkaTE4bi5uX3NoYXJrX2Zpbl91cF9pc3N1ZV9vbmVfZmlyc3QgKyAnXFxuJyArICRpMThuLm5fc2hhcmtfZmluX3VwX2lzc3VlX29uZV9zZWNvbmQgKyAnXFxuJyArICRpMThuLm5fc2hhcmtfZmluX3VwX2lzc3VlX29uZV90aGlyZCB9LFxuXHRcdHsgdHlwZTogXCJIM1wiLCB0ZXh0OiAkaTE4bi5uX3NoYXJrX2Zpbl91cF9pc3N1ZV90d29fZmlyc3QgKyAnXFxuJyArICRpMThuLm5fc2hhcmtfZmluX3VwX2lzc3VlX3R3b19zZWNvbmQgKyAnXFxuJyArICRpMThuLm5fc2hhcmtfZmluX3VwX2lzc3VlX3R3b190aGlyZCArICdcXG4nICsgJGkxOG4ubl9zaGFya19maW5fdXBfaXNzdWVfdHdvX2ZvdXJ0aCB9LFxuXHRcdHsgdHlwZTogXCJIM1wiLCB0ZXh0OiAkaTE4bi5uX3NoYXJrX2Zpbl91cF9pc3N1ZV90aHJlZV9maXJzdCArICdcXG4nICsgJGkxOG4ubl9zaGFya19maW5fdXBfaXNzdWVfdGhyZWVfc2Vjb25kICsgJ1xcbicgKyAkaTE4bi5uX3NoYXJrX2Zpbl91cF9pc3N1ZV90aHJlZV90aGlyZCB9LFxuXHRcdHsgdHlwZTogXCJIMlwiLCB0ZXh0OiAkaTE4bi5uX3NoYXJrX2Zpbl9kb3duIH0sXG5cdFx0eyB0eXBlOiBcIkFQWV9Fc3RcIiwgc3JjOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9zaGFya2Zpbl9pbnRyb2R1Y2VfZG93blwiIH0sXG5cdFx0eyB0eXBlOiBcIkgzXCIsIHRleHQ6ICRpMThuLm5fc2hhcmtfZmluX2Rvd25faXNzdWVfb25lX2ZpcnN0ICsgJ1xcbicgKyAkaTE4bi5uX3NoYXJrX2Zpbl9kb3duX2lzc3VlX29uZV9zZWNvbmQgKyAnXFxuJyArICRpMThuLm5fc2hhcmtfZmluX2Rvd25faXNzdWVfb25lX3RoaXJkIH0sXG5cdFx0eyB0eXBlOiBcIkgzXCIsIHRleHQ6ICRpMThuLm5fc2hhcmtfZmluX2Rvd25faXNzdWVfdHdvX2ZpcnN0ICsgJ1xcbicgKyAkaTE4bi5uX3NoYXJrX2Zpbl9kb3duX2lzc3VlX3R3b19zZWNvbmQgKyAnXFxuJyArICRpMThuLm5fc2hhcmtfZmluX2Rvd25faXNzdWVfdHdvX3RoaXJkICsgJ1xcbicgKyAkaTE4bi5uX3NoYXJrX2Zpbl9kb3duX2lzc3VlX3R3b19mb3VydGggfSxcblx0XHR7IHR5cGU6IFwiSDNcIiwgdGV4dDogJGkxOG4ubl9zaGFya19maW5fZG93bl9pc3N1ZV90aHJlZV9maXJzdCArICdcXG4nICsgJGkxOG4ubl9zaGFya19maW5fZG93bl9pc3N1ZV90aHJlZV9zZWNvbmQgKyAnXFxuJyArICRpMThuLm5fc2hhcmtfZmluX2Rvd25faXNzdWVfdGhyZWVfdGhpcmQgfSxcblx0XHR7IHR5cGU6IFwidGV4dFwiLCB0ZXh0OiAkaTE4bi5uX3NoYXJrX2Zpbl9pc3N1ZV9ub3RlXzEgfSxcblx0XSxcblx0W3tcblx0XHR0eXBlOiAnUUEnLFxuXHRcdGluZGV4OiAwLFxuXHRcdGFuc3dlclZpc2FibGU6ICdnb25lJyxcblx0XHRROiAkaTE4bi5uX3NoYXJrX2Zpbl9jb21tb25fcHJvYmxlbV9vbmUsXG5cdFx0QTogJGkxOG4ubl9zaGFya19maW5fY29tbW9uX2Fuc3dlcl9vbmUsXG5cdFx0cWFJY29uOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9zaGFya19ob21lX3FhX3NwcmVhZF9pY29uXCIsXG5cdH0sIHtcblx0XHR0eXBlOiAnUUEnLFxuXHRcdGluZGV4OiAxLFxuXHRcdGFuc3dlclZpc2FibGU6ICdnb25lJyxcblx0XHRROiAkaTE4bi5uX3NoYXJrX2Zpbl9jb21tb25fcHJvYmxlbV90d28sXG5cdFx0QTogJGkxOG4ubl9zaGFya19maW5fY29tbW9uX2Fuc3dlcl90d29fbmV3LFxuXHRcdHFhSWNvbjogXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfc2hhcmtfaG9tZV9xYV9zcHJlYWRfaWNvblwiLFxuXHR9LCB7XG5cdFx0dHlwZTogJ1FBJyxcblx0XHRpbmRleDogMixcblx0XHRhbnN3ZXJWaXNhYmxlOiAnZ29uZScsXG5cdFx0UTogJGkxOG4ubl9zaGFya19maW5fY29tbW9uX3Byb2JsZW1fdGhyZWUsXG5cdFx0QTogJGkxOG4ubl9zaGFya19maW5fY29tbW9uX2Fuc3dlcl90aHJlZSxcblx0XHRxYUljb246IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX3NoYXJrX2hvbWVfcWFfc3ByZWFkX2ljb25cIixcblx0fSwge1xuXHRcdHR5cGU6ICdRQScsXG5cdFx0aW5kZXg6IDMsXG5cdFx0YW5zd2VyVmlzYWJsZTogJ2dvbmUnLFxuXHRcdFE6ICRpMThuLm5fc2hhcmtfZmluX2NvbW1vbl9wcm9ibGVtX2ZvdXIsXG5cdFx0QTogJGkxOG4ubl9zaGFya19maW5fY29tbW9uX2Fuc3dlcl9mb3VyX2MsXG5cdFx0cWFJY29uOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9zaGFya19ob21lX3FhX3NwcmVhZF9pY29uXCIsXG5cdH0sIHtcblx0XHR0eXBlOiAnUUEnLFxuXHRcdGluZGV4OiA0LFxuXHRcdGFuc3dlclZpc2FibGU6ICdnb25lJyxcblx0XHRROiAkaTE4bi5uX3NoYXJrX2Zpbl9jb21tb25fcHJvYmxlbV9maXZlX25ldyxcblx0XHRBOiAkaTE4bi5uX3NoYXJrX2Zpbl9jb21tb25fYW5zd2VyX2ZpdmVfbmV3X2MsXG5cdFx0cWFJY29uOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9zaGFya19ob21lX3FhX3NwcmVhZF9pY29uXCIsXG5cdH0sIHtcblx0XHR0eXBlOiAnUUEnLFxuXHRcdGluZGV4OiA1LFxuXHRcdGFuc3dlclZpc2FibGU6ICdnb25lJyxcblx0XHRROiAkaTE4bi5uX3NoYXJrX2Zpbl9jb21tb25fcHJvYmxlbV9zaXgsXG5cdFx0QTogJGkxOG4ubl9zaGFya19maW5fY29tbW9uX2Fuc3dlcl9zaXgsXG5cdFx0cWFJY29uOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9zaGFya19ob21lX3FhX3NwcmVhZF9pY29uXCIsXG5cdH0sIHtcblx0XHR0eXBlOiAnUUEnLFxuXHRcdGluZGV4OiA2LFxuXHRcdGFuc3dlclZpc2FibGU6ICdnb25lJyxcblx0XHRROiAkaTE4bi5uX3NoYXJrX2Zpbl9jb21tb25fcHJvYmxlbV9zaXhfYSxcblx0XHRBOiAkaTE4bi5uX3NoYXJrX2Zpbl9jb21tb25fYW5zd2VyX3NpeF9hX2ZpcnN0X25ldyArICdcXG5cXG4nICsgJGkxOG4ubl9zaGFya19maW5fY29tbW9uX2Fuc3dlcl9zaXhfYV9zZWNvbmRfbmV3LFxuXHRcdHFhSWNvbjogXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfc2hhcmtfaG9tZV9xYV9zcHJlYWRfaWNvblwiLFxuXHR9LCB7XG5cdFx0dHlwZTogJ1FBJyxcblx0XHRpbmRleDogNyxcblx0XHRhbnN3ZXJWaXNhYmxlOiAnZ29uZScsXG5cdFx0UTogJGkxOG4ubl9zaGFya19maW5fY29tbW9uX3Byb2JsZW1fc2V2ZW4sXG5cdFx0QTogJGkxOG4ubl9zaGFya19maW5fY29tbW9uX2Fuc3dlcl9zZXZlbl9hX2ZpcnN0ICsgXCIgXFxuIFxcblwiICsgJGkxOG4ubl9zaGFya19maW5fY29tbW9uX2Fuc3dlcl9zZXZlbl9hX3NlY29uZCArIFwiIFxcbiBcXG5cIiArICRpMThuLm5fc2hhcmtfZmluX2NvbW1vbl9hbnN3ZXJfc2V2ZW5fYV90aGlyZCArIFwiIFxcbiBcXG5cIiArICRpMThuLm5fc2hhcmtfZmluX2NvbW1vbl9hbnN3ZXJfc2V2ZW5fYV9mb3VyICsgXCIgXFxuIFxcblwiICsgJGkxOG4ubl9zaGFya19maW5fY29tbW9uX2Fuc3dlcl9zZXZlbl9zZWNvbmQgKyBcIiBcXG4gXFxuXCIgKyAkaTE4bi5uX3NoYXJrX2Zpbl9jb21tb25fYW5zd2VyX3NldmVuX3RoaXJkLFxuXHRcdHFhSWNvbjogXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfc2hhcmtfaG9tZV9xYV9zcHJlYWRfaWNvblwiLFxuXHR9LCB7XG5cdFx0dHlwZTogJ1FBJyxcblx0XHRpbmRleDogOCxcblx0XHRhbnN3ZXJWaXNhYmxlOiAnZ29uZScsXG5cdFx0UTogJGkxOG4ubl9zaGFya19maW5fY29tbW9uX3Byb2JsZW1fZWlnaHQsXG5cdFx0QTogJGkxOG4ubl9zaGFya19maW5fY29tbW9uX2Fuc3dlcl9laWdodF9uZXdfYyxcblx0XHRxYUljb246IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX3NoYXJrX2hvbWVfcWFfc3ByZWFkX2ljb25cIixcblx0fSwge1xuXHRcdHR5cGU6ICdRQScsXG5cdFx0aW5kZXg6IDksXG5cdFx0YW5zd2VyVmlzYWJsZTogJ2dvbmUnLFxuXHRcdFE6ICRpMThuLm5fc2hhcmtfZmluX2NvbW1vbl9wcm9ibGVtX25pbmUsXG5cdFx0QTogJGkxOG4ubl9zaGFya19maW5fY29tbW9uX2Fuc3dlcl9uaW5lX25ldyxcblx0XHRxYUljb246IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX3NoYXJrX2hvbWVfcWFfc3ByZWFkX2ljb25cIixcblx0fSwge1xuXHRcdHR5cGU6ICdRQScsXG5cdFx0aW5kZXg6IDEwLFxuXHRcdGFuc3dlclZpc2FibGU6ICdnb25lJyxcblx0XHRROiAkaTE4bi5uX3NoYXJrX2Zpbl9hdXRvU3Vic2NyaWJlX1FfMSxcblx0XHRBOiAkaTE4bi5uX3NoYXJrX2Zpbl9hdXRvU3Vic2NyaWJlX0FfMV8xICsgXCIgXFxuXFxuXCIgKyAkaTE4bi5uX3NoYXJrX2Zpbl9hdXRvU3Vic2NyaWJlX0FfMV8yLFxuXHRcdHFhSWNvbjogXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfc2hhcmtfaG9tZV9xYV9zcHJlYWRfaWNvblwiLFxuXHR9LCB7XG5cdFx0dHlwZTogJ1FBJyxcblx0XHRpbmRleDogMTEsXG5cdFx0YW5zd2VyVmlzYWJsZTogJ2dvbmUnLFxuXHRcdFE6ICRpMThuLm5fc2hhcmtfZmluX2F1dG9TdWJzY3JpYmVfUV8yLFxuXHRcdEE6ICRpMThuLm5fc2hhcmtfZmluX2F1dG9TdWJzY3JpYmVfQV8yXzEgKyBcIiBcXG5cXG5cIiArICRpMThuLm5fc2hhcmtfZmluX2F1dG9TdWJzY3JpYmVfQV8yXzIgKyBcIiBcXG5cXG5cIiArICRpMThuLm5fc2hhcmtfZmluX2F1dG9TdWJzY3JpYmVfQV8yXzMsXG5cdFx0cWFJY29uOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9zaGFya19ob21lX3FhX3NwcmVhZF9pY29uXCIsXG5cdH0sIHtcblx0XHR0eXBlOiAnUUEnLFxuXHRcdGluZGV4OiAxMixcblx0XHRhbnN3ZXJWaXNhYmxlOiAnZ29uZScsXG5cdFx0UTogJGkxOG4ubl9zaGFya19maW5fYXV0b1N1YnNjcmliZV9RXzMsXG5cdFx0QTogJGkxOG4ubl9zaGFya19maW5fYXV0b1N1YnNjcmliZV9BXzNfMSArIFwiIFxcblxcblwiICsgJGkxOG4ubl9zaGFya19maW5fYXV0b1N1YnNjcmliZV9BXzNfMixcblx0XHRxYUljb246IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX3NoYXJrX2hvbWVfcWFfc3ByZWFkX2ljb25cIixcblx0fV1cbl1cblxuY29uc3QgaW50cm9fc3RydWN0dXJlZCA9IHtcblx0dGl0bGVJbmRleDogMCxcblx0dGl0bGVEYXRhOiBbXG5cdFx0e1xuXHRcdFx0J3RpdGxlJzogJGkxOG4ubl9zdHJ1dHVyZWRfcHJvZHVjdHNfc3VtLFxuXHRcdFx0J3RpdGxlU2l6ZSc6ICcxNCcsXG5cdFx0XHQndGl0bGVDb2xvcic6ICdAY29sb3Iva0NvbG9yUHJpbWFyeVRleHQnLFxuXHRcdFx0J3RhZyc6ICcwJyxcblx0XHRcdCdzZWxlY3RlZGxpbmUnOiAndmlzaWJsZSdcblx0XHR9LCB7XG5cdFx0XHQndGl0bGUnOiAkaTE4bi5uX3N0cnV0dXJlZF9kdWFsLFxuXHRcdFx0J3RpdGxlU2l6ZSc6ICcxNCcsXG5cdFx0XHQndGl0bGVDb2xvcic6ICdAY29sb3Iva0NvbG9yVGhyZWVMZXZlbFRleHQnLFxuXHRcdFx0J3RhZyc6ICcxJ1xuXHRcdH0sIHtcblx0XHRcdCd0aXRsZSc6ICRpMThuLm5fc2hhcmtfZmluLFxuXHRcdFx0J3RpdGxlU2l6ZSc6ICcxNCcsXG5cdFx0XHQndGl0bGVDb2xvcic6ICdAY29sb3Iva0NvbG9yVGhyZWVMZXZlbFRleHQnLFxuXHRcdFx0J3RhZyc6ICcyJ1xuXHRcdH1dLFxuXHRzbGlkZXJEYXRhOiBbXG5cdFx0e1xuXHRcdFx0XCJsaXN0VHlwZVwiOiAnc2xpZGVyQ2VsbCcsXG5cdFx0XHRoZWFkZXJWaXNpYjogXCJnb25lXCIsXG5cdFx0XHRoZWFkZXJEYXRhOiBbXSxcblx0XHRcdGNlbGxEYXRhOiBpbnRyb19zdHJ1Y3R1cmVkX2luZm9cblx0XHR9LCB7XG5cdFx0XHRcImxpc3RUeXBlXCI6ICdzbGlkZXJDZWxsJyxcblx0XHRcdGhlYWRlclZpc2liOiBcInZpc2libGVcIixcblx0XHRcdGhlYWRlckRhdGE6IFtcblx0XHRcdFx0e1xuXHRcdFx0XHRcdGluZGV4OiAwLFxuXHRcdFx0XHRcdHR5cGU6IFwiaGVhZGVyXCIsXG5cdFx0XHRcdFx0dGV4dDogJGkxOG4ubl9zaGFya19maW5fcHJvZHVjdF9ydWxlLFxuXHRcdFx0XHRcdHRleHRDb2xvcjogXCJAY29sb3Iva0NvbG9yUHJpbWFyeVRleHRcIixcblx0XHRcdFx0XHRiYWNrQ29sb3I6IFwiQGNvbG9yL0tCYXNlQ29sb3JJbnB1dEJhY2tncm91bmRcIixcblx0XHRcdFx0XHRib3JkZXJDb2xvcjogXCJAY29sb3IvS0Jhc2VDb2xvcklucHV0QmFja2dyb3VuZFwiXG5cdFx0XHRcdH0sXG5cdFx0XHRcdHtcblx0XHRcdFx0XHRpbmRleDogMSxcblx0XHRcdFx0XHR0eXBlOiBcImhlYWRlclwiLFxuXHRcdFx0XHRcdHRleHQ6ICRpMThuLm5fc2hhcmtfZmluX2NvbW1vbl9wcm9ibGVtLFxuXHRcdFx0XHRcdHRleHRDb2xvcjogXCJAY29sb3Iva0NvbG9yU2Vjb25kYXJ5VGV4dFwiLFxuXHRcdFx0XHRcdGJhY2tDb2xvcjogXCJAY29sb3IvS0Jhc2VDb2xvckNvbnRlbnRCYWNrZ3JvdW5kXCIsXG5cdFx0XHRcdFx0Ym9yZGVyQ29sb3I6IFwiQGNvbG9yL0tCYXNlQ29sb3JQcmltYXJ5U2VwYXJhdG9yXCJcblx0XHRcdFx0fSxcblx0XHRcdFx0e1xuXHRcdFx0XHRcdGluZGV4OiAyLFxuXHRcdFx0XHRcdHR5cGU6IFwiaGVhZGVyXCIsXG5cdFx0XHRcdFx0dGV4dDogJGkxOG4ubl9kb3VibGVfY29pbl9wYXltZW50X3JlZ3VsYXRpb24sXG5cdFx0XHRcdFx0dGV4dENvbG9yOiBcIkBjb2xvci9rQ29sb3JTZWNvbmRhcnlUZXh0XCIsXG5cdFx0XHRcdFx0YmFja0NvbG9yOiBcIkBjb2xvci9LQmFzZUNvbG9yQ29udGVudEJhY2tncm91bmRcIixcblx0XHRcdFx0XHRib3JkZXJDb2xvcjogXCJAY29sb3IvS0Jhc2VDb2xvclByaW1hcnlTZXBhcmF0b3JcIlxuXHRcdFx0XHR9XG5cdFx0XHRdLFxuXHRcdFx0Y2VsbERhdGE6IGludHJvX2R1YWxbMF1cblx0XHR9LCB7XG5cdFx0XHRcImxpc3RUeXBlXCI6ICdzbGlkZXJDZWxsJyxcblx0XHRcdGhlYWRlclZpc2liOiBcInZpc2libGVcIixcblx0XHRcdGhlYWRlckRhdGE6IGludHJvX2hlYWRlckRhdGEsXG5cdFx0XHRjZWxsRGF0YTogaW50cm9fc2hhcmtmaW5bMF1cblx0XHR9XSxcblx0XHRjZWxsRGF0YWxpc3Q6IFtcblx0XHRbaW50cm9fc3RydWN0dXJlZF9pbmZvXSxcblx0XHRpbnRyb19kdWFsLFxuXHRcdGludHJvX3NoYXJrZmluXG5cdF1cbn1cblxuY29uc3QgaW50cm9fbmF2TGlzdCA9IFtpbnRyb19zaW1wbGUsIGludHJvX25ldywgaW50cm9fc3RydWN0dXJlZCwgaW50cm9fb25jaGFpbl1cblxuY29uc3QgaW50cm9fYW5hbHl0aWNzID0gW1xuXHR7ICdwcm9kdWN0Q2xhc3NpZnknOiBcInNpbXBsZUVhcm5cIiwgJ3RhYk5hbWUnOiBbXCJwcm9kdWN0T3ZlcnZpZXdcIiwgXCJmbGV4aWJsZVwiLCBcImZsZXhpTWF4XCIsIFwiZml4ZWRcIl0gfSxcblx0eyAncHJvZHVjdENsYXNzaWZ5JzogXCJuZXdQcm9kdWN0XCIsICd0YWJOYW1lJzogW1wicHJvZHVjdE92ZXJ2aWV3XCIsIFwiRkFRXCJdIH0sXG5cdHsgJ3Byb2R1Y3RDbGFzc2lmeSc6IFwic3RydWN0dXJlZFByb2R1Y3RcIiwgJ3RhYk5hbWUnOiBbXCJwcm9kdWN0T3ZlcnZpZXdcIiwgXCJkdWFsSW52ZXN0bWVudFwiLCBcInNoYXJrRmluXCJdIH0sXG5cdHsgJ3Byb2R1Y3RDbGFzc2lmeSc6IFwib25DaGFpbkVhcm5cIiwgJ3RhYk5hbWUnOiBbXCJwcm9kdWN0T3ZlcnZpZXdcIiwgXCJwcm9kdWN0UmVndWxhdGlvblwiLCBcIkZBUVwiXSB9XG5dXG5cbmZ1bmN0aW9uIGRlZmF1bHREYXRhKCkge1xuICAgIHJldHVybiB7XG5cdFx0bmF2SW5kZXg6IDAsXG4gICAgICAgIGN1cnJlbnRJbmRleDogMCxcblx0XHRuYXZUaXRsZTogJGkxOG4ubl9zdHJ1dHVyZWRfbW9yZV9zaW1wbGUsXG5cdFx0bmF2RGF0YTogW3tcblx0XHRcdHR5cGU6IFwibm9ybWFsXCIsXG5cdFx0XHRpbmRleDogMCxcblx0XHRcdHNlbGVjdGVkOiBcInZpc2libGVcIixcblx0XHRcdG5hbWU6ICRpMThuLm5fc3RydXR1cmVkX21vcmVfc2ltcGxlLFxuXHRcdFx0ZGVzYzogJGkxOG4ubl9zdHJ1dHVyZWRfbW9yZV9zaW1wbGVfZGV0YWlsLFxuXHRcdFx0aWNvbjogXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfaW50cm9kdWNlX2Vhc3lcIlxuXHRcdH0sIHtcblx0XHRcdHR5cGU6IFwibm9ybWFsXCIsXG5cdFx0XHRpbmRleDogMSxcblx0XHRcdHNlbGVjdGVkOiBcImdvbmVcIixcblx0XHRcdG5hbWU6ICRpMThuLm5fc3RydXR1cmVkX21vcmVfbmV3LFxuXHRcdFx0ZGVzYzogJGkxOG4ubl9zdHJ1dHVyZWRfbW9yZV9uZXdfZGV0YWlsLFxuXHRcdFx0aWNvbjogXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfaW50cm9kdWNlX3VwZGF0ZVwiXG5cdFx0fSwgIHtcblx0XHRcdHR5cGU6IFwibm9ybWFsXCIsXG5cdFx0XHRpbmRleDogMixcblx0XHRcdHNlbGVjdGVkOiBcImdvbmVcIixcblx0XHRcdG5hbWU6ICRpMThuLm5fc3RydXR1cmVkX3Byb2R1Y3RzLFxuXHRcdFx0ZGVzYzogJGkxOG4ubl9zdHJ1dHVyZWRfZGVzYyxcblx0XHRcdGljb246IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX2ludHJvZHVjZV9wcm9kdWN0c1wiXG5cdFx0fSwge1xuXHRcdFx0dHlwZTogXCJub3JtYWxcIixcblx0XHRcdGluZGV4OiAzLFxuXHRcdFx0c2VsZWN0ZWQ6IFwiZ29uZVwiLFxuXHRcdFx0bmFtZTogJGkxOG4ubl9zdHJ1dHVyZWRfbW9yZV9vbmNoYWluLFxuXHRcdFx0ZGVzYzogJGkxOG4ubl9zdHJ1dHVyZWRfbW9yZV9vbmNoYWluX2RldGFpbCxcblx0XHRcdGljb246IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX2ludHJvZHVjZV9vbmNoYWluXCJcblx0XHR9XSxcbiAgICAgICAgdGl0bGVEYXRhOiBpbnRyb19zaW1wbGUudGl0bGVEYXRhLFxuICAgICAgICBzbGlkZXJEYXRhOiBpbnRyb19zaW1wbGUuc2xpZGVyRGF0YSxcblx0XHRuYXZDb250YWluZXI6IFwiZ29uZVwiLFxuXHRcdHBvcFNob3c6IFwiZmFsc2VcIixcblx0XHRuYXZBcnJvdzogXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfc3RydXR1cmVkX25hdl9hcnJvd1wiLFxuICAgIH1cbn1cblxuY29uc3QgeyBtb2R1bGVEYXRhLCBtb2R1bGVFdmVudCB9ID0gY29tbW9uLm1vZHVsZURlZmluZShcImludHJvZHVjZVwiLCBkZWZhdWx0RGF0YSwgeyBvbkNyZWF0ZSwgb25EZXN0cm95IH0pO1xuXG5mdW5jdGlvbiBvbkNyZWF0ZShwYXJhbSkge1xuXHRtb2R1bGVEYXRhLnN0YXR1c0JhckNvbmZpZyA9IHtcInN0YXR1c0Jhck1vZGVcIjogXCJ0cnVlXCIsIFwiYWRTdGF0dXNCYXJDb2xvclwiOiBcIktCYXNlQ29sb3JDb250ZW50QmFja2dyb3VuZFwiLCBcInNhZmVCb3R0b21UcmFuc3BhcmVudFwiIDogXCJ0cnVlXCIgfTtcblxuICAgIGNvbnNvbGUubG9nKCdpbnRyb2R1Y2Ugb24gY3JlYXRlJyk7XG4gICAgY29uc29sZS5sb2cocGFyYW0pO1xuICAgIGxldCBwYXJhbURpYyA9IEpTT04ucGFyc2UocGFyYW0pO1xuXHRuZWVkQWRkU2hvdyA9IGZhbHNlO1xuXHQvLyDpgIluYXZcbiAgICBsZXQgaW5kZXggPSBwYXJzZUludChwYXJhbURpY1snaW5kZXgnXSk7XG4gICAgY29uc29sZS5sb2coaW5kZXgpO1xuICAgIGNvbnNvbGUubG9nKHBhcnNlSW50KGluZGV4KSk7XG4gICAgaWYgKGluZGV4ID09IHVuZGVmaW5lZCB8fCBpc05hTihpbmRleCkpIHtcbiAgICAgICAgaW5kZXggPSAwO1xuICAgIH0gXG4gICAgbW9kdWxlRXZlbnQubmF2Q2xpY2tlZChpbmRleCwgZmFsc2UpO1xuXHQvLyDpgInkuIDnuqd0YWJcblx0bGV0IHRhYkluZGV4ID0gcGFyc2VJbnQocGFyYW1EaWNbJ3RhYkluZGV4J10pO1xuICAgIGNvbnNvbGUubG9nKHRhYkluZGV4KTtcbiAgICBjb25zb2xlLmxvZyhwYXJzZUludCh0YWJJbmRleCkpO1xuICAgIGlmICh0YWJJbmRleCA9PSB1bmRlZmluZWQgfHwgaXNOYU4odGFiSW5kZXgpKSB7XG4gICAgICAgIHRhYkluZGV4ID0gMDtcbiAgICB9IFxuXHRtb2R1bGVEYXRhLmN1cnJlbnRJbmRleCA9IHRhYkluZGV4O1xuXHRtb2R1bGVFdmVudC5yZXNldFRpdGxlU2VsZWN0VGFiKHRhYkluZGV4KTtcblx0Ly8g6YCJ5LqM57qnaGVhZGVyXG5cdGxldCBoZWFkZXJJbmRleCA9IHBhcnNlSW50KHBhcmFtRGljWydoZWFkZXJJbmRleCddKTtcbiAgICBjb25zb2xlLmxvZyhoZWFkZXJJbmRleCk7XG4gICAgY29uc29sZS5sb2cocGFyc2VJbnQoaGVhZGVySW5kZXgpKTtcbiAgICBpZiAoaGVhZGVySW5kZXggPT0gdW5kZWZpbmVkIHx8IGlzTmFOKGhlYWRlckluZGV4KSkge1xuICAgICAgICBoZWFkZXJJbmRleCA9IDA7XG4gICAgfSBcbiAgICBtb2R1bGVFdmVudC5oZWFkZXJDbGlja2VkKGhlYWRlckluZGV4KTtcblx0Ly8g5byV5a+8XG5cdHBvcEd1aWRlU2hvdygpO1xuXHRcblx0cHJvZHVjdEV4cGxhbmF0aW9uU2hvdygpO1xuXHRjb25zb2xlLmxvZyhcInByb2R1Y3RFeHBsYW5hdGlvblNob3c6b25DcmVhdGVcIik7XG59XG5cbmZ1bmN0aW9uIG9uRGVzdHJveSAoKSB7XG5cdG1vZHVsZURhdGEucG9wU2hvdyA9IFwiZmFsc2VcIjtcbn1cblxuYXN5bmMgZnVuY3Rpb24gcG9wR3VpZGVTaG93KCkge1xuXHR2YXIgZ3VpZGVTaG93ID0gYXdhaXQgJG5hdGl2ZUFQSS5zdG9yYWdlKHtcblx0XHRhY3Rpb246IFwicmVhZFwiLFxuXHRcdG5hbWU6IFwiZWFyblwiLFxuXHRcdGtleTogXCJndWlkZV9pbnRyb2R1Y2Vfc2hvd1wiXG5cdH0pXG5cdGlmIChndWlkZVNob3cgPT0gbnVsbCB8fCBndWlkZVNob3cgPT0gXCJcIikge1xuXHRcdG1vZHVsZURhdGEucG9wU2hvdyA9IFwidHJ1ZVwiO1xuXHRcdCRuYXRpdmVBUEkuc3RvcmFnZSh7XG5cdFx0XHRhY3Rpb246IFwic2F2ZVwiLFxuXHRcdFx0bmFtZTogXCJlYXJuXCIsXG5cdFx0XHRrZXk6IFwiZ3VpZGVfaW50cm9kdWNlX3Nob3dcIixcblx0XHRcdGRhdGE6IFwiMVwiXG5cdFx0fSlcblx0fVxufVxuXG5tb2R1bGVFdmVudC5oaWRlSW50cm9Qb3AgPSBmdW5jdGlvbiAoKSB7XG5cdG1vZHVsZURhdGEucG9wU2hvdyA9IFwiZmFsc2VcIjtcbn1cblxuZnVuY3Rpb24gcHJvZHVjdEV4cGxhbmF0aW9uU2hvdygpIHtcblx0bmVlZEFkZFNob3cgPSB0cnVlO1xuXHRjb25zdCBuYXZNb2RlbCA9IGludHJvX2FuYWx5dGljc1ttb2R1bGVEYXRhLm5hdkluZGV4XTtcblx0Y29uc3QgdGFiTmFtZSA9IG5hdk1vZGVsLnRhYk5hbWVbbW9kdWxlRGF0YS5jdXJyZW50SW5kZXhdO1xuXHRjb25zdCBwcm9wZXJ0aWVzID0ge1xuXHRcdCdwcm9kdWN0Q2xhc3NpZnknOiBuYXZNb2RlbC5wcm9kdWN0Q2xhc3NpZnksXG5cdFx0dGFiTmFtZSxcblx0fTtcblx0Y29uc3QgcHJvcGVydGllc0pzb24gPSBKU09OLnN0cmluZ2lmeShwcm9wZXJ0aWVzKTtcblx0aWYgKHByb3BlcnRpZXNKc29uICE9PSBwcm9kdWN0RXhwbGFuYXRpb25Kc29uKSB7XG5cdFx0Y29tbW9uLmFuYWx5dGljcyhcImFwcF9lYXJuX3Byb2R1Y3RFeHBsYW5hdGlvbl9zaG93XCIsIHByb3BlcnRpZXMpO1xuXHR9XG5cdHByb2R1Y3RFeHBsYW5hdGlvbkpzb24gPSBwcm9wZXJ0aWVzSnNvbjtcbn1cblxubW9kdWxlRXZlbnQuYmFja0NsaWNrZWQgPSBmdW5jdGlvbiAoKSB7XG5cdGNvbW1vbi5jb250YWluZXJCYWNrKCk7XG59XG5cbm1vZHVsZUV2ZW50LnNlbGVjdGVkTmF2Q2xpY2tlZCA9IGZ1bmN0aW9uICgpIHtcblx0aWYgKG1vZHVsZURhdGEubmF2Q29udGFpbmVyID09IFwiZ29uZVwiKSB7XG5cdFx0bW9kdWxlRGF0YS5uYXZBcnJvdyA9IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX3N0cnV0dXJlZF9uYXZfYXJyb3dfdXBcIjtcblx0XHRtb2R1bGVEYXRhLm5hdkNvbnRhaW5lciA9IFwidmlzaWJsZVwiO1xuXHR9IGVsc2Uge1xuXHRcdG1vZHVsZURhdGEubmF2QXJyb3cgPSBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9zdHJ1dHVyZWRfbmF2X2Fycm93XCI7XG5cdFx0bW9kdWxlRGF0YS5uYXZDb250YWluZXIgPSBcImdvbmVcIjtcblx0fVxufVxuXG5tb2R1bGVFdmVudC5uYXZDbGlja2VkID0gZnVuY3Rpb24gKG5hdkluZGV4LCBjbGlja2VkKSB7XG5cdGZvciAobGV0IGluZGV4ID0gMDsgaW5kZXggPCBtb2R1bGVEYXRhLm5hdkRhdGEubGVuZ3RoOyBpbmRleCsrKSB7XG5cdFx0Y29uc3QgZWxlbWVudCA9IG1vZHVsZURhdGEubmF2RGF0YVtpbmRleF07XG5cdFx0aWYgKG5hdkluZGV4ID09IGVsZW1lbnQuaW5kZXgpIHtcblx0XHRcdGVsZW1lbnQuc2VsZWN0ZWQgPSBcInZpc2libGVcIjtcblx0XHRcdG1vZHVsZURhdGEubmF2VGl0bGUgPSBlbGVtZW50Lm5hbWU7XG5cdFx0fSBlbHNlIHtcblx0XHRcdGVsZW1lbnQuc2VsZWN0ZWQgPSBcImdvbmVcIjtcblx0XHR9XG5cdH1cblx0aWYgKG1vZHVsZURhdGEubmF2SW5kZXggIT0gbmF2SW5kZXgpIHtcblx0XHRpbnRyb19uYXZMaXN0W21vZHVsZURhdGEubmF2SW5kZXhdLnRpdGxlRGF0YSA9IG1vZHVsZURhdGEudGl0bGVEYXRhO1xuXHRcdGludHJvX25hdkxpc3RbbW9kdWxlRGF0YS5uYXZJbmRleF0uc2xpZGVyRGF0YSA9IG1vZHVsZURhdGEuc2xpZGVyRGF0YTtcblx0XHRpbnRyb19uYXZMaXN0W21vZHVsZURhdGEubmF2SW5kZXhdLnRpdGxlSW5kZXggPSBtb2R1bGVEYXRhLmN1cnJlbnRJbmRleDtcblxuXHRcdG1vZHVsZURhdGEubmF2SW5kZXggPSBuYXZJbmRleDtcblx0XHRtb2R1bGVEYXRhLnRpdGxlRGF0YSA9IGludHJvX25hdkxpc3RbbmF2SW5kZXhdLnRpdGxlRGF0YTtcblx0XHRtb2R1bGVEYXRhLnNsaWRlckRhdGEgPSBpbnRyb19uYXZMaXN0W25hdkluZGV4XS5zbGlkZXJEYXRhO1xuXHRcdG1vZHVsZURhdGEuY3VycmVudEluZGV4ID0gaW50cm9fbmF2TGlzdFtuYXZJbmRleF0udGl0bGVJbmRleDtcblxuXHRcdGlmIChjbGlja2VkKSB7XG5cdFx0XHRwcm9kdWN0RXhwbGFuYXRpb25TaG93KCk7XG5cdFx0XHRjb25zb2xlLmxvZyhcInByb2R1Y3RFeHBsYW5hdGlvblNob3c6bmF2Q2xpY2tlZFwiKTtcblx0XHR9XG5cdH1cblx0bW9kdWxlRGF0YS5uYXZDb250YWluZXIgPSBcImdvbmVcIjtcblx0bW9kdWxlRGF0YS5uYXZBcnJvdyA9IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX3N0cnV0dXJlZF9uYXZfYXJyb3dcIjtcbn1cblxubW9kdWxlRXZlbnQudGFiQ2xpY2sgPSBmdW5jdGlvbiAoaWR4KSB7XG5cdG5lZWRBZGRTaG93ID0gdHJ1ZTtcblx0bW9kdWxlRGF0YS5jdXJyZW50SW5kZXggPSBgJHtpZHh9YDtcbn1cblxubW9kdWxlRXZlbnQucmVzZXRUaXRsZVNlbGVjdFRhYiA9IGZ1bmN0aW9uIChpZHgpIHtcblx0Zm9yIChsZXQgaSA9IDA7IGkgPCBtb2R1bGVEYXRhLnRpdGxlRGF0YS5sZW5ndGg7IGkrKykge1xuXHRcdHZhciBvYmogPSBtb2R1bGVEYXRhLnRpdGxlRGF0YVtpXTtcblx0XHRvYmoudGl0bGVDb2xvciA9ICdAY29sb3Iva0NvbG9yVGhyZWVMZXZlbFRleHQnO1xuXHRcdG9iai5zZWxlY3RlZGxpbmUgPSBcImdvbmVcIjtcblx0fVxuXHR2YXIgY3VyID0gbW9kdWxlRGF0YS50aXRsZURhdGFbaWR4XTtcblx0Y3VyLnRpdGxlQ29sb3IgPSAnQGNvbG9yL2tDb2xvclByaW1hcnlUZXh0Jztcblx0Y3VyLnNlbGVjdGVkbGluZSA9IFwidmlzaWJsZVwiO1xuXHRpZiAobmVlZEFkZFNob3cpIHtcblx0XHRwcm9kdWN0RXhwbGFuYXRpb25TaG93KCk7XG5cdFx0Y29uc29sZS5sb2coXCJwcm9kdWN0RXhwbGFuYXRpb25TaG93OnJlc2V0VGl0bGVTZWxlY3RUYWJcIik7XG5cdH1cbn1cblxubW9kdWxlRXZlbnQuaGVhZGVyQ2xpY2tlZCA9IGZ1bmN0aW9uIGhlYWRlckNsaWNrZWQoaGVhZGVySW5kZXgpIHtcblx0dmFyIGhlYWRlckRhdGEgPSBtb2R1bGVEYXRhLnNsaWRlckRhdGFbbW9kdWxlRGF0YS5jdXJyZW50SW5kZXhdLmhlYWRlckRhdGE7XG5cdGZvciAobGV0IGluZGV4ID0gMDsgaW5kZXggPCBoZWFkZXJEYXRhLmxlbmd0aDsgaW5kZXgrKykge1xuXHRcdGNvbnN0IGVsZW1lbnQgPSBoZWFkZXJEYXRhW2luZGV4XTtcblx0XHRpZiAoaW5kZXggPT0gaGVhZGVySW5kZXgpIHtcblx0XHRcdGVsZW1lbnQudGV4dENvbG9yID0gXCJAY29sb3Iva0NvbG9yUHJpbWFyeVRleHRcIjtcblx0XHRcdGVsZW1lbnQuYmFja0NvbG9yID0gXCJAY29sb3IvS0Jhc2VDb2xvcklucHV0QmFja2dyb3VuZFwiO1xuXHRcdFx0ZWxlbWVudC5ib3JkZXJDb2xvciA9IFwiQGNvbG9yL0tCYXNlQ29sb3JJbnB1dEJhY2tncm91bmRcIjtcblx0XHR9IGVsc2Uge1xuXHRcdFx0ZWxlbWVudC50ZXh0Q29sb3IgPSBcIkBjb2xvci9rQ29sb3JTZWNvbmRhcnlUZXh0XCI7XG5cdFx0XHRlbGVtZW50LmJhY2tDb2xvciA9IFwiQGNvbG9yL0tCYXNlQ29sb3JDb250ZW50QmFja2dyb3VuZFwiO1xuXHRcdFx0ZWxlbWVudC5ib3JkZXJDb2xvciA9IFwiQGNvbG9yL0tCYXNlQ29sb3JQcmltYXJ5U2VwYXJhdG9yXCI7XG5cdFx0fVxuXHR9XG5cdHZhciBoZWFkZXJDZWxsbGlzdCA9IGludHJvX25hdkxpc3RbbW9kdWxlRGF0YS5uYXZJbmRleF0uY2VsbERhdGFsaXN0W21vZHVsZURhdGEuY3VycmVudEluZGV4XTtcblx0bW9kdWxlRGF0YS5zbGlkZXJEYXRhW21vZHVsZURhdGEuY3VycmVudEluZGV4XS5jZWxsRGF0YSA9IGhlYWRlckNlbGxsaXN0W2hlYWRlckluZGV4XTtcblx0aW50cm9fbmF2TGlzdFttb2R1bGVEYXRhLm5hdkluZGV4XS5zbGlkZXJEYXRhID0gbW9kdWxlRGF0YS5zbGlkZXJEYXRhO1xufVxuXG5tb2R1bGVFdmVudC5jbGlja1FBID0gZnVuY3Rpb24gKFFJbmRleCkge1xuXHR2YXIgb3BlcmF0aW9uVHlwZSA9IFwiXCI7XG5cdHZhciBxYWxpc3QgPSBtb2R1bGVEYXRhLnNsaWRlckRhdGFbbW9kdWxlRGF0YS5jdXJyZW50SW5kZXhdLmNlbGxEYXRhO1xuXHRmb3IgKGxldCBpbmRleCA9IDA7IGluZGV4IDwgcWFsaXN0Lmxlbmd0aDsgaW5kZXgrKykge1xuXHRcdGNvbnN0IGVsZW1lbnQgPSBxYWxpc3RbaW5kZXhdO1xuXHRcdGlmIChRSW5kZXggPT0gZWxlbWVudC5pbmRleCkge1xuXHRcdFx0aWYgKGVsZW1lbnQuYW5zd2VyVmlzYWJsZSA9PSAnZ29uZScpIHtcblx0XHRcdFx0ZWxlbWVudC5hbnN3ZXJWaXNhYmxlID0gJ3Zpc2libGUnO1xuXHRcdFx0XHRlbGVtZW50LnFhSWNvbiA9IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX3NoYXJrX2hvbWVfcWFfcmV0cmFjdF9pY29uXCI7XG5cdFx0XHRcdG9wZXJhdGlvblR5cGUgPSBcInVuZm9sZFwiO1xuXHRcdFx0fSBlbHNlIHtcblx0XHRcdFx0ZWxlbWVudC5hbnN3ZXJWaXNhYmxlID0gJ2dvbmUnO1xuXHRcdFx0XHRlbGVtZW50LnFhSWNvbiA9IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX3NoYXJrX2hvbWVfcWFfc3ByZWFkX2ljb25cIjtcblx0XHRcdFx0b3BlcmF0aW9uVHlwZSA9IFwiZm9sZFwiO1xuXHRcdFx0fVxuXHRcdH1cblx0fVxuXHRpbnRyb19uYXZMaXN0W21vZHVsZURhdGEubmF2SW5kZXhdLnNsaWRlckRhdGEgPSBtb2R1bGVEYXRhLnNsaWRlckRhdGE7XG5cdHZhciBtb2RlbCA9IGludHJvX25hdkxpc3RbbW9kdWxlRGF0YS5uYXZJbmRleF0uY2VsbERhdGFsaXN0W21vZHVsZURhdGEuY3VycmVudEluZGV4XTtcblx0aWYgKG1vZGVsICYmIG1vZGVsLmxlbmd0aCA+IDEpIHtcblx0XHRtb2RlbFsxXSA9IHFhbGlzdDtcblx0fVxuXHRjb25zdCBuYXZNb2RlbCA9IGludHJvX2FuYWx5dGljc1ttb2R1bGVEYXRhLm5hdkluZGV4XTtcblx0dmFyIGNsYXNzaWZ5ID0gbmF2TW9kZWwudGFiTmFtZVttb2R1bGVEYXRhLmN1cnJlbnRJbmRleF07XG5cdGlmIChjbGFzc2lmeSA9PSBcIkZBUVwiKSB7XG5cdFx0Y2xhc3NpZnkgPSBuYXZNb2RlbC5wcm9kdWN0Q2xhc3NpZnk7XG5cdH1cblx0Y29tbW9uLmFuYWx5dGljcyhcImFwcF9lYXJuX3Byb2R1Y3RFeHBsYW5hdGlvbl9GQVFzX2NsaWNrXCIsIHtcblx0XHRjbGFzc2lmeSxcblx0XHRvcGVyYXRpb25UeXBlLFxuXHRcdCdvcmRlcic6IGAke1FJbmRleCsxfWBcblx0fSk7XG59XG4iLCJpbXBvcnQgKiBhcyBjb21tb24gZnJvbSBcIi4vY29tbW9uXCI7XG5pbXBvcnQgKiBhcyBudW1iZXIgZnJvbSBcIi4vbnVtYmVyXCI7XG5cbmZ1bmN0aW9uIGRlZmF1bHREYXRhKCkge1xuICAgIHJldHVybiB7XG4gICAgICAgIGxvYWRpbmdMb3R0aWVWaXM6IFwidmlzaWJsZVwiLFxuICAgICAgICBsb2FkaW5nTG90dGllU3RhdHVzOiBcInBsYXlcIiwvL+WKoOi9veWKqOeUu+eKtuaAgVxuICAgICAgICBmdW5jTGlzdDogW10sLy/lip/og73ljLrmlbDmja5cbiAgICAgICAgdG90YWxJbmNvbWU6IFwiLS1cIiwvL+e0r+iuoeaUtuebilxuICAgICAgICB5ZXN0ZXJkYXlJbmNvbWU6IFwiLS1cIiwvL+aYqOaXpeaUtuebilxuICAgICAgICB0b3RhbEluY29tZVJpY2g6IFwiXCIsXG4gICAgICAgIGJhbm5lckxpc3Q6IFtdLC8vYmFubmVyXG4gICAgICAgIHNob3dJbmRpY2F0b3I6IFwiZmFsc2VcIiwgLy8g5pi+56S65oyH56S65p2hXG4gICAgICAgIHJlY29tbWVuZDFJY29uVXJsOiBcIlwiLC8v5o6o6I2Q5L2NMVxuICAgICAgICByZWNvbW1lbmQxQ3VycmVuY3k6IFwiLS1cIixcbiAgICAgICAgcmVjb21tZW5kMVRhZ05hbWU6IFwiXCIsXG4gICAgICAgIHJlY29tbWVuZDFUYWdCZzogXCItLVwiLFxuICAgICAgICByZWNvbW1lbmQxVGFnVGV4dENvbG9yOiBcIi0tXCIsXG4gICAgICAgIHJlY29tbWVuZDFBcHk6IFwiLS1cIixcbiAgICAgICAgcmVjb21tZW5kMVByb2o6IFwiLS1cIixcblxuXG4gICAgICAgIHJlY29tbWVuZDJJY29uVXJsOiBcIlwiLC8v5o6o6I2Q5L2NMlxuICAgICAgICByZWNvbW1lbmQyQ3VycmVuY3k6IFwiLS1cIixcbiAgICAgICAgcmVjb21tZW5kMlRhZ05hbWU6IFwiXCIsXG4gICAgICAgIHJlY29tbWVuZDJUYWdCZzogXCItLVwiLFxuICAgICAgICByZWNvbW1lbmQyVGFnVGV4dENvbG9yOiBcIi0tXCIsXG4gICAgICAgIHJlY29tbWVuZDJBcHk6IFwiLS1cIixcbiAgICAgICAgcmVjb21tZW5kMlByb2o6IFwiLS1cIixcblxuICAgICAgICBuZXh0SXRlbU5hbWU6IFwiLS1cIiwvL+aOqOiNkOWIl+ihqOagh+mimFxuICAgICAgICBuZXh0VGl0bGU6IFwiLS1cIiwvL+aOqOiNkOWIl+ihqOWtkOagh+mimFxuXG4gICAgICAgIHJlY29tbWVuZExpc3Q6IFtdLC8v5o6o6I2Q5YiX6KGoXG5cbiAgICAgICAgcWFMaXN0OiBbXSwvL+W4uOingemXrumimOWIl+ihqFxuXG4gICAgICAgIG1haW5EYXRhOiBbXSwvL1xuXG4gICAgICAgIHJlZnJlc2hTdGF0dXM6IDAsLy/liLfmlrDnirbmgIFcbiAgICAgICAgcG9wMVNob3c6IFwiZmFsc2VcIixcbiAgICAgICAgcG9wMlNob3c6IFwiZmFsc2VcIixcbiAgICAgICAgcG9wM1Nob3c6IFwiZmFsc2VcIixcbiAgICAgICAgcG9wNFNob3c6IFwiZmFsc2VcIixcbiAgICAgICAgbmV3TGluZVNwYWNpbmc6IFwiMFwiLFxuICAgICAgICB0aXRsZTogXCJcIiwvL+agh+mimFxuXHRcdHZpcEljb246IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX2Vhcm5fdmlwX2ljb25fb3RoZXJcIixcblx0XHR1cGdyYWRlQmdDb2xvcjpcIiNEOUY3RTRcIixcbiAgICAgICAgc2Nyb2xsVG9Qb3M6IDAsXG4gICAgfTtcbn1cblxudmFyIG9yaWdpbk1haW5EYXRhID0ge307XG52YXIgaW50ZXJjYWwgPSBudWxsO1xuY29uc3QgbW0gPSA2MDtcbmNvbnN0IGhoID0gMzYwMDtcbmNvbnN0IGRkID0gODY0MDA7XG52YXIgc2hhcmtGaW5Db3VudCA9IDE7XG52YXIgcGFyYW1ldGVyID0ge307XG52YXIgZ3VpZGVTaG93ID0gXCJcIjtcbnZhciByZWNvbW1lbmRMaXN0ID0gW107XG5cbmNvbnN0IHsgbW9kdWxlRGF0YSwgbW9kdWxlRXZlbnQgfSA9IGNvbW1vbi5tb2R1bGVEZWZpbmUoXCJob21lXCIsIGRlZmF1bHREYXRhLCB7IG9uQ3JlYXRlLCBvbkRlc3Ryb3kgfSk7XG5cbmZ1bmN0aW9uIG9uQ3JlYXRlKGpzb25QYXJhbWV0ZXJzKSB7XG4gICAgY29uc29sZS5sb2coJ2hvbWUgb25DcmVhdGUnKTtcbiAgICBtb2R1bGVEYXRhLnN0YXR1c0JhckNvbmZpZyA9IHsgXCJzdGF0dXNCYXJNb2RlXCI6IFwiZmFsc2VcIiwgXCJzYWZlQm90dG9tVHJhbnNwYXJlbnRcIjogXCJ0cnVlXCIgfTtcbiAgICBtb2R1bGVEYXRhLm5ld0xpbmVTcGFjaW5nID0gY29tbW9uLmNvbW1vbkRhdGEuT1MgPT0gMSA/IFwiMlwiIDogXCIwXCI7XG4gICAgbW9kdWxlRGF0YS50b3RhbEluY29tZVJpY2ggPSBoYW5kbGVUb3RhbEluY29tZVJpY2goKTtcbiAgICBwYXJhbWV0ZXIgPSBKU09OLnBhcnNlKGpzb25QYXJhbWV0ZXJzKTtcbiAgICBpbml0VUkoKTtcblxuICAgIC8vIHNldFRpbWVvdXQoKCkgPT4ge1xuICAgIGdldEd1aWRlU3RhdHVzKCk7XG4gICAgcmVxdWVzRWFybkhvbWVEYXRhKHRydWUpO1xuICAgIC8vIH0sIDUwMCk7XG5cbiAgICBjb21tb24uYW5hbHl0aWNzKFwiYXBwX2Vhcm5QYWdlX3ZpZXdcIik7XG59XG5cbmZ1bmN0aW9uIG9uRGVzdHJveSgpIHtcbiAgICBjbGVhclRpbWVyKCk7XG59XG5cbmZ1bmN0aW9uIGluaXRVSSgpIHtcbiAgICBsZXQgdGVtcEZ1bmMgPSBbXTtcbiAgICBmb3IgKGxldCBpbmRleCA9IDA7IGluZGV4IDwgNDsgaW5kZXgrKykge1xuICAgICAgICBsZXQgZWxlbWVudCA9IHt9O1xuICAgICAgICBsZXQgd2lkdGggPSAzNzUgLyA0O1xuICAgICAgICBlbGVtZW50LmluZGV4ID0gaW5kZXg7XG4gICAgICAgIGVsZW1lbnQudHlwZSA9IFwiMVwiO1xuICAgICAgICBlbGVtZW50LndpZHRoID0gcGFyc2VJbnQod2lkdGgpO1xuICAgICAgICBpZiAoaW5kZXggPT0gMCkge1xuICAgICAgICAgICAgZWxlbWVudC50aXRsZSA9ICRpMThuLm5fc3RydXR1cmVkX21vcmVfc2ltcGxlO1xuICAgICAgICAgICAgZWxlbWVudC5qdW1wVXJsID0gXCIvZmluYW5jaWFsL2Vhcm4vaDUvbmV3RGV0YWlsP2FjdGl2ZVRhYj0wXCI7XG4gICAgICAgICAgICBlbGVtZW50Lmljb24gPSBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9lYXJuX2hvbWVfZnVuY18xXCJcbiAgICAgICAgfSBlbHNlIGlmIChpbmRleCA9PSAxKSB7XG4gICAgICAgICAgICBlbGVtZW50LnRpdGxlID0gJGkxOG4ubl9zdHJ1dHVyZWRfbW9yZV9uZXc7XG4gICAgICAgICAgICBlbGVtZW50Lmp1bXBVcmwgPSBcIi9maW5hbmNpYWwvZWFybi9oNS9uZXdMaXN0aW5nXCI7XG4gICAgICAgICAgICBlbGVtZW50Lmljb24gPSBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9lYXJuX2hvbWVfZnVuY18yXCJcbiAgICAgICAgfSBlbHNlIGlmIChpbmRleCA9PSAyKSB7XG4gICAgICAgICAgICBlbGVtZW50LnRpdGxlID0gJGkxOG4ubl9zdHJ1dHVyZWRfcHJvZHVjdHM7XG4gICAgICAgICAgICBlbGVtZW50Lmp1bXBVcmwgPSBcImhvbGlnZWl0Oi8vb3Blbi92MT9sb2dpbj0xJnVybD1paHVvYmlnbG9iYWw6Ly9tLmhiZy5jb20vZWRnZWVuZ2luZS9jb250YWluZXI/c2NlbmU9ZWFybiZyb290TmFtZT1zdHJ1Y3R1cmVkJm5hdkNvbmZpZz1uYXRpdmUmaXNDbG9zZT10cnVlXCI7XG4gICAgICAgICAgICBlbGVtZW50Lmljb24gPSBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9lYXJuX2hvbWVfZnVuY18zXCJcbiAgICAgICAgfSBlbHNlIGlmIChpbmRleCA9PSAzKSB7XG4gICAgICAgICAgICBlbGVtZW50LnRpdGxlID0gJGkxOG4ubl9zdHJ1dHVyZWRfbW9yZV9vbmNoYWluO1xuICAgICAgICAgICAgZWxlbWVudC5qdW1wVXJsID0gXCIvZmluYW5jaWFsL2Vhcm4vaDUvc3RhY2tQcm9cIjtcbiAgICAgICAgICAgIGVsZW1lbnQuaWNvbiA9IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX2Vhcm5faG9tZV9mdW5jXzRcIlxuICAgICAgICB9XG4gICAgICAgIHRlbXBGdW5jLnB1c2goZWxlbWVudCk7XG4gICAgfVxuICAgIGNvbnNvbGUubG9nKGBmdW5jTGlzdCAtLS0tLT4gICR7SlNPTi5zdHJpbmdpZnkodGVtcEZ1bmMpfWApO1xuICAgIG1vZHVsZURhdGEuZnVuY0xpc3QgPSB0ZW1wRnVuYztcblx0Ly8gdmlwXG5cdGlmIChjb21tb24uY29tbW9uRGF0YS5sYW5ndWFnZS50b0xvd2VyQ2FzZSgpID09IFwiemgtY25cIiB8fFxuXHRcdGNvbW1vbi5jb21tb25EYXRhLmxhbmd1YWdlLnRvTG93ZXJDYXNlKCkgPT0gXCJ6aC1oa1wiKSB7XG5cdFx0bW9kdWxlRGF0YS52aXBJY29uID0gXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfZWFybl92aXBfaWNvblwiO1xuXHR9XG5cblx0bW9kdWxlRGF0YS51cGdyYWRlQmdDb2xvciA9IGNvbW1vbi5jb21tb25EYXRhLmNvbG9yTW9kZSA9PSAwID8gXCIjRDlGN0U0XCI6XCIjMUQzNDJFXCI7XG59XG5cbmFzeW5jIGZ1bmN0aW9uIGdldEd1aWRlU3RhdHVzKCkge1xuICAgIGd1aWRlU2hvdyA9IGF3YWl0ICRuYXRpdmVBUEkuc3RvcmFnZSh7XG4gICAgICAgIGFjdGlvbjogXCJyZWFkXCIsXG4gICAgICAgIG5hbWU6IFwiZWFyblwiLFxuICAgICAgICBrZXk6IFwiZ3VpZGVfc2hvd1wiXG4gICAgfSlcbiAgICBpZiAoZ3VpZGVTaG93ID09IFwiMVwiKSB7XG4gICAgICAgIC8v5paw5omL5byV5a+85by56L+H5LqGIOW8ueWHuumcuOWxj1xuICAgICAgICBtb2R1bGVEYXRhLmVkZ2VFbmdpbmVQYWdlSWQgPSBcIjY0XCJcbiAgICB9XG59XG5cbmFzeW5jIGZ1bmN0aW9uIHJlcXVlc0Vhcm5Ib21lRGF0YShpc0ZpcnN0ID0gZmFsc2UpIHtcbiAgICBjb25zdCBzdGFydFRpbWUgPSBEYXRlLm5vdygpO1xuICAgIHRyeSB7XG4gICAgICAgIHZhciBjdXJyZW5jeU5hbWUgPSBhd2FpdCAkbmF0aXZlQVBJLmN1cnJlbmN5Q29tbW9uKCd7XCJ0eXBlXCI6M30nKTtcbiAgICAgICAgY29uc29sZS5sb2coYGN1cnJlbmN5TmFtZSAtLS0tLT4gICR7Y3VycmVuY3lOYW1lfWApO1xuICAgICAgICB2YXIgcGFyYW0gPSB7IGM6IGN1cnJlbmN5TmFtZSB9O1xuICAgICAgICBjb25zdCBkYXRhID0gYXdhaXQgY29tbW9uLnNlbmRSZXF1ZXN0KCd2NC9zYXZpbmcvbWluaW5nL2hvbWUvbWFpbicsIHBhcmFtKTtcbiAgICAgICAgLy/lrZjlgqjljp/lp4vmlbDmja5cbiAgICAgICAgb3JpZ2luTWFpbkRhdGEgPSBkYXRhO1xuICAgICAgICBjb25zb2xlLmxvZyhgcmVxdWVzRWFybkhvbWVEYXRhICR7SlNPTi5zdHJpbmdpZnkoZGF0YSl9ICBjdXJyZW5jeU5hbWUgOiAke2N1cnJlbmN5TmFtZX1gKTtcbiAgICAgICAgaWYgKGRhdGEgIT0gbnVsbCkge1xuICAgICAgICAgICAgY29tbW9uLmFuYWx5dGljcyhcImFwcF9lYXJuUGFnZV9sb2FkU3RhdGVcIiwgeyBwYWdlTG9hZFN0YXRlOiBgc3VjY2Vzc2AgfSk7XG4gICAgICAgICAgICAvL+agh+mimFxuICAgICAgICAgICAgbW9kdWxlRGF0YS50aXRsZSA9IGRhdGEudGl0bGVcbiAgICAgICAgICAgIC8v5pio5pel5pS255uKXG4gICAgICAgICAgICBpZiAoZGF0YS5pbmNvbWUgIT0gbnVsbCkge1xuICAgICAgICAgICAgICAgIG1vZHVsZURhdGEudG90YWxJbmNvbWUgPSBgJHtkYXRhLmluY29tZS50b3RhbEtleX0gJHtkYXRhLmluY29tZS50b3RhbH1gO1xuICAgICAgICAgICAgICAgIG1vZHVsZURhdGEueWVzdGVyZGF5SW5jb21lID0gYCR7ZGF0YS5pbmNvbWUueWVzdGVyZGF5S2V5fSAke2RhdGEuaW5jb21lLnllc3RlcmRheX1gO1xuICAgICAgICAgICAgICAgIG1vZHVsZURhdGEudG90YWxJbmNvbWVSaWNoID0gaGFuZGxlVG90YWxJbmNvbWVSaWNoKCk7XG4gICAgICAgICAgICAgICAgY29uc29sZS5sb2coYHJlcXVlc0Vhcm5Ib21lRGF0YSAg5pio5pel5pS255uKYCk7XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICAvL2Jhbm5lclxuICAgICAgICAgICAgaWYgKGRhdGEuYmFubmVyICYmIGRhdGEuYmFubmVyLmxlbmd0aCA+IDApIHtcbiAgICAgICAgICAgICAgICBsZXQgdGVtcEJhbm5lciA9IGRhdGEuYmFubmVyO1xuICAgICAgICAgICAgICAgIHRlbXBCYW5uZXIuZm9yRWFjaCgoZWxlbWVudCwgaW5kZXgpID0+IHtcbiAgICAgICAgICAgICAgICAgICAgZWxlbWVudC5pbmRleCA9IGluZGV4O1xuICAgICAgICAgICAgICAgICAgICAvLzE6UHJvamVjdCAyOkJhbm5lciAzOlByb2plY3RfTmV3VXNlclxuICAgICAgICAgICAgICAgICAgICBpZiAoZWxlbWVudC5hcmVhVHlwZSA9PSAxKSB7XG4gICAgICAgICAgICAgICAgICAgICAgICAvKipcbiAgICAgICAgICAgICAgICAgICAgICAgICAqIOS6p+WTgeexu+WeizogMTAwMDE65paw5Lq656aP5Yip5LiT5Lqr5Y+XXG4gICAgICAgICAgICAgICAgICAgICAgICAgKiAxLea0u+acnyAyLeWumuacnyAzLeWkp+minea0u+acnyA0LemyqOmxvOmzjSA1LeWPjOW4gSA2LeWumuaKleiuoeWIklxuICAgICAgICAgICAgICAgICAgICAgICAgICovXG4gICAgICAgICAgICAgICAgICAgICAgICBsZXQgcHJvamVjdCA9IGVsZW1lbnQucHJvamVjdDtcbiAgICAgICAgICAgICAgICAgICAgICAgIGlmIChwcm9qZWN0LnByb2pUeXBlID09IDQpIHtcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICBlbGVtZW50LnR5cGUgPSBcIjJcIjtcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICBsZXQgZGl2ID0gbnVtYmVyLmRpdmlkZShwcm9qZWN0LnJhaXNpbmcsIHByb2plY3QucmFpc2VHb2FsKTtcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICBpZiAoZGl2ID49IDEpIHtcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgcHJvamVjdC5maXJzdFByb2dyZXNzID0gMTtcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgcHJvamVjdC5zZWNvbmRQcm9ncmVzcyA9IDAuMDAxO1xuICAgICAgICAgICAgICAgICAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIGlmIChkaXYgPCAwLjEpIHtcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIGRpdiA9IDAuMTtcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICBwcm9qZWN0LmZpcnN0UHJvZ3Jlc3MgPSBwYXJzZUZsb2F0KGRpdik7XG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIHByb2plY3Quc2Vjb25kUHJvZ3Jlc3MgPSAoMSAtIHBhcnNlRmxvYXQoZGl2KSk7XG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgICAgICAgICAgICAgIGVsZW1lbnQucHJvamVjdC5yYWlzZUdvYWwgPSBgLyR7ZWxlbWVudC5wcm9qZWN0LnJhaXNlR29hbH1gXG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgLy/lvIDlkK/psqjpsbzps43orqHml7blmahcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICBzdGFydFNoYXJrRmluQ291bnREb3duKCk7XG4gICAgICAgICAgICAgICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgICAgICAgICAgICAgIGVsZW1lbnQudHlwZSA9IFwiM1wiO1xuICAgICAgICAgICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgICAgICAgICAgLy/luIHnp43lm77moIdcbiAgICAgICAgICAgICAgICAgICAgICAgIHByb2plY3QuaWNvblVybCA9IGNvbW1vbi5nZXRQTkdJY29uVVJMQnlDdXJyZW5jeShwcm9qZWN0LmN1cnJlbmN5KVxuICAgICAgICAgICAgICAgICAgICB9IGVsc2UgaWYgKGVsZW1lbnQuYXJlYVR5cGUgPT0gMikge1xuICAgICAgICAgICAgICAgICAgICAgICAgZWxlbWVudC50eXBlID0gXCI0XCI7XG4gICAgICAgICAgICAgICAgICAgICAgICBpZiAoY29tbW9uLmNvbW1vbkRhdGEuY29sb3JNb2RlID09IDApIHtcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICBlbGVtZW50LmJhbm5lci5iYW5uZXJQaWMgPSBlbGVtZW50LmJhbm5lci5pbWFnZVVybDtcbiAgICAgICAgICAgICAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgZWxlbWVudC5iYW5uZXIuYmFubmVyUGljID0gZWxlbWVudC5iYW5uZXIubmlnaHRJbWFnZVVybDtcbiAgICAgICAgICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgICAgICAgICAgIGlmIChlbGVtZW50LnByb2plY3Qub3JpZ2luQXB5ID09IG51bGwgfHwgZWxlbWVudC5wcm9qZWN0Lm9yaWdpbkFweSA9PSBcIlwiKSB7XG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgZWxlbWVudC5wcm9qZWN0Lm9yaWdpbkFweVZpcyA9IFwiZ29uZVwiO1xuICAgICAgICAgICAgICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICBlbGVtZW50LnByb2plY3Qub3JpZ2luQXB5VmlzID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgICAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgICAgICAgICBlbGVtZW50LnR5cGUgPSBcIjFcIjtcbiAgICAgICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgIH0pO1xuICAgICAgICAgICAgICAgIC8vIGNvbnNvbGUubG9nKGBiYW5uZXJMaXN0IC0tLS0tPiAgJHtKU09OLnN0cmluZ2lmeSh0ZW1wQmFubmVyKX1gKTtcbiAgICAgICAgICAgICAgICBtb2R1bGVEYXRhLnNob3dJbmRpY2F0b3IgPSB0ZW1wQmFubmVyLmxlbmd0aCA+IDEgPyBcInRydWVcIiA6IFwiZmFsc2VcIjtcbiAgICAgICAgICAgICAgICBtb2R1bGVEYXRhLmJhbm5lckxpc3QgPSB0ZW1wQmFubmVyO1xuICAgICAgICAgICAgICAgIG1vZHVsZUV2ZW50LmJhbm5lckluZGV4Q2hhbmdlKDApO1xuICAgICAgICAgICAgICAgIGNvbnNvbGUubG9nKGByZXF1ZXNFYXJuSG9tZURhdGEgIGJhbm5lcmApO1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgLy/mjqjojZDkvY1cbiAgICAgICAgICAgIGlmIChkYXRhLnJlY29tbWVuZCAmJiBkYXRhLnJlY29tbWVuZC5sZW5ndGggPiAxKSB7XG4gICAgICAgICAgICAgICAgbGV0IHJlY29tbWVuZDEgPSBkYXRhLnJlY29tbWVuZFswXTtcbiAgICAgICAgICAgICAgICBtb2R1bGVEYXRhLnJlY29tbWVuZDFJY29uVXJsID0gY29tbW9uLmdldFBOR0ljb25VUkxCeUN1cnJlbmN5KHJlY29tbWVuZDEuY3VycmVuY3kpO1xuICAgICAgICAgICAgICAgIG1vZHVsZURhdGEucmVjb21tZW5kMUN1cnJlbmN5ID0gcmVjb21tZW5kMS5jdXJyZW5jeS50b1VwcGVyQ2FzZSgpO1xuICAgICAgICAgICAgICAgIG1vZHVsZURhdGEucmVjb21tZW5kMUFweSA9IHJlY29tbWVuZDEuYXB5O1xuICAgICAgICAgICAgICAgIG1vZHVsZURhdGEucmVjb21tZW5kMVByb2ogPSByZWNvbW1lbmQxLnByb2o7XG4gICAgICAgICAgICAgICAgaWYgKHJlY29tbWVuZDEudGFnICE9IDAgJiYgcmVjb21tZW5kMS50YWcgIT0gbnVsbCkge1xuICAgICAgICAgICAgICAgICAgICBpZiAocmVjb21tZW5kMS50YWcgPT0gOCB8fCByZWNvbW1lbmQxLnRhZyA9PSA5KSB7XG4gICAgICAgICAgICAgICAgICAgICAgICBtb2R1bGVEYXRhLnJlY29tbWVuZDFJY29uVmlzID0gXCJ2aXNpYmxlXCJcbiAgICAgICAgICAgICAgICAgICAgICAgIG1vZHVsZURhdGEucmVjb21tZW5kMVRhZ1ZpcyA9IFwiZ29uZVwiXG4gICAgICAgICAgICAgICAgICAgICAgICBtb2R1bGVEYXRhLnJlY29tbWVuZDFJY29uU3JjID0gZ2V0VGFnSWNvbkJ5VHlwZShyZWNvbW1lbmQxLnRhZyk7XG4gICAgICAgICAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICAgICAgICAgICBtb2R1bGVEYXRhLnJlY29tbWVuZDFJY29uVmlzID0gXCJnb25lXCJcbiAgICAgICAgICAgICAgICAgICAgICAgIG1vZHVsZURhdGEucmVjb21tZW5kMVRhZ1ZpcyA9IFwidmlzaWJsZVwiXG4gICAgICAgICAgICAgICAgICAgICAgICBtb2R1bGVEYXRhLnJlY29tbWVuZDFUYWdOYW1lID0gcmVjb21tZW5kMS50YWdOYW1lO1xuICAgICAgICAgICAgICAgICAgICAgICAgbW9kdWxlRGF0YS5yZWNvbW1lbmQxVGFnQmcgPSBnZXRUYWdCZ0J5VHlwZShyZWNvbW1lbmQxLnRhZyk7XG4gICAgICAgICAgICAgICAgICAgICAgICBtb2R1bGVEYXRhLnJlY29tbWVuZDFUYWdUZXh0Q29sb3IgPSBnZXRUYWdUZXh0Q29sb3JCeVR5cGUocmVjb21tZW5kMS50YWcpO1xuICAgICAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgIGxldCByZWNvbW1lbmQyID0gZGF0YS5yZWNvbW1lbmRbMV07XG4gICAgICAgICAgICAgICAgbW9kdWxlRGF0YS5yZWNvbW1lbmQySWNvblVybCA9IGNvbW1vbi5nZXRQTkdJY29uVVJMQnlDdXJyZW5jeShyZWNvbW1lbmQyLmN1cnJlbmN5KTtcbiAgICAgICAgICAgICAgICBtb2R1bGVEYXRhLnJlY29tbWVuZDJDdXJyZW5jeSA9IHJlY29tbWVuZDIuY3VycmVuY3kudG9VcHBlckNhc2UoKTtcbiAgICAgICAgICAgICAgICBtb2R1bGVEYXRhLnJlY29tbWVuZDJBcHkgPSByZWNvbW1lbmQyLmFweTtcbiAgICAgICAgICAgICAgICBtb2R1bGVEYXRhLnJlY29tbWVuZDJQcm9qID0gcmVjb21tZW5kMi5wcm9qO1xuICAgICAgICAgICAgICAgIGlmIChyZWNvbW1lbmQyLnRhZyAhPSAwICYmIHJlY29tbWVuZDIudGFnICE9IG51bGwpIHtcbiAgICAgICAgICAgICAgICAgICAgaWYgKHJlY29tbWVuZDIudGFnID09IDggfHwgcmVjb21tZW5kMi50YWcgPT0gOSkge1xuICAgICAgICAgICAgICAgICAgICAgICAgbW9kdWxlRGF0YS5yZWNvbW1lbmQySWNvblZpcyA9IFwidmlzaWJsZVwiXG4gICAgICAgICAgICAgICAgICAgICAgICBtb2R1bGVEYXRhLnJlY29tbWVuZDJUYWdWaXMgPSBcImdvbmVcIlxuICAgICAgICAgICAgICAgICAgICAgICAgbW9kdWxlRGF0YS5yZWNvbW1lbmQySWNvblNyYyA9IGdldFRhZ0ljb25CeVR5cGUocmVjb21tZW5kMi50YWcpO1xuICAgICAgICAgICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgICAgICAgICAgbW9kdWxlRGF0YS5yZWNvbW1lbmQySWNvblZpcyA9IFwiZ29uZVwiXG4gICAgICAgICAgICAgICAgICAgICAgICBtb2R1bGVEYXRhLnJlY29tbWVuZDJUYWdWaXMgPSBcInZpc2libGVcIlxuICAgICAgICAgICAgICAgICAgICAgICAgbW9kdWxlRGF0YS5yZWNvbW1lbmQyVGFnTmFtZSA9IHJlY29tbWVuZDIudGFnTmFtZTtcbiAgICAgICAgICAgICAgICAgICAgICAgIG1vZHVsZURhdGEucmVjb21tZW5kMlRhZ0JnID0gZ2V0VGFnQmdCeVR5cGUocmVjb21tZW5kMi50YWcpO1xuICAgICAgICAgICAgICAgICAgICAgICAgbW9kdWxlRGF0YS5yZWNvbW1lbmQyVGFnVGV4dENvbG9yID0gZ2V0VGFnVGV4dENvbG9yQnlUeXBlKHJlY29tbWVuZDIudGFnKTtcbiAgICAgICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIC8v5o6o6I2Q5L2N5paH5qGIXG4gICAgICAgICAgICBpZiAoZGF0YS5uZXh0ICE9IG51bGwpIHtcbiAgICAgICAgICAgICAgICBtb2R1bGVEYXRhLm5leHRJdGVtTmFtZSA9IGRhdGEubmV4dC5pdGVtTmFtZTtcbiAgICAgICAgICAgICAgICBtb2R1bGVEYXRhLm5leHRUaXRsZSA9IGRhdGEubmV4dC50aXRsZTtcbiAgICAgICAgICAgICAgICBjb25zb2xlLmxvZyhgcmVxdWVzRWFybkhvbWVEYXRhICDmjqjojZDkvY1gKTtcbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIC8v5o6o6I2Q5L2N5YiX6KGoXG4gICAgICAgICAgICBpZiAoZGF0YS5pdGVtcyAhPSBudWxsKSB7XG4gICAgICAgICAgICAgICAgbGV0IHRlbXBJdGVtcyA9IGRhdGEuaXRlbXM7XG4gICAgICAgICAgICAgICAgbGV0IHNjcm9sbFRvUG9zVGVtcCA9IC0xO1xuICAgICAgICAgICAgICAgIHRlbXBJdGVtcy5mb3JFYWNoKChlbGVtZW50LCBpbmRleCkgPT4ge1xuICAgICAgICAgICAgICAgICAgICBlbGVtZW50LmluZGV4ID0gaW5kZXg7XG4gICAgICAgICAgICAgICAgICAgIGVsZW1lbnQudHlwZSA9IFwiMVwiO1xuICAgICAgICAgICAgICAgICAgICBlbGVtZW50Lmxpc3RNYWluVGFnVmlzID0gXCJnb25lXCI7XG4gICAgICAgICAgICAgICAgICAgIGVsZW1lbnQuaWNvblVybCA9IGNvbW1vbi5nZXRQTkdJY29uVVJMQnlDdXJyZW5jeShlbGVtZW50LmN1cnJlbmN5KTtcbiAgICAgICAgICAgICAgICAgICAgaWYgKGVsZW1lbnQuaG9sZCA9PSBudWxsIHx8IGVsZW1lbnQuaG9sZCA9PSBcIlwiKSB7XG4gICAgICAgICAgICAgICAgICAgICAgICBlbGVtZW50LmhvbGQgPSBcIlwiO1xuICAgICAgICAgICAgICAgICAgICAgICAgZWxlbWVudC5ob2xkVmlzID0gXCJnb25lXCI7XG4gICAgICAgICAgICAgICAgICAgICAgICBlbGVtZW50LnBhcmVudFBhZGRpbmcgPSBcIjE4XCI7XG4gICAgICAgICAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICAgICAgICAgICBlbGVtZW50LmhvbGRWaXMgPSBcInZpc2libGVcIjtcbiAgICAgICAgICAgICAgICAgICAgICAgIGVsZW1lbnQucGFyZW50UGFkZGluZyA9IFwiMTRcIjtcbiAgICAgICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgICAgICBpZiAoZWxlbWVudC5hcHkgPT0gbnVsbCkge1xuICAgICAgICAgICAgICAgICAgICAgICAgZWxlbWVudC5hcHkgPSBcIlwiO1xuICAgICAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgICAgIC8v5aaC5p6c5pyJ5bim6L+b5p2l55qE5biB56eN77yM5YiZ5bGV5byA5bim6L+b5p2l55qE5biB56eNXG4gICAgICAgICAgICAgICAgICAgIGxldCBleHBhbmQgPSBmYWxzZTtcbiAgICAgICAgICAgICAgICAgICAgaWYgKGlzRmlyc3QgJiYgaGFzQ3VycmVuY3koKSkge1xuICAgICAgICAgICAgICAgICAgICAgICAgZXhwYW5kID0gcGFyYW1ldGVyLmN1cnJlbmN5LnRvTG93ZXJDYXNlKCkgPT0gZWxlbWVudC5jdXJyZW5jeS50b0xvd2VyQ2FzZSgpO1xuICAgICAgICAgICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgICAgICAgICAgLy/pu5jorqTnrKzkuIDkuKrpu5jorqTlsZXlvIBcbiAgICAgICAgICAgICAgICAgICAgICAgIGV4cGFuZCA9IGluZGV4ID09IDA7XG4gICAgICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgICAgICAgICAgY29uc29sZS5sb2coYHhpYW95aSBleHBhbmQgPSAke2V4cGFuZH0gIGluZGV4ID0gJHtpbmRleH0gIHBhcmFtZXRlci5jdXJyZW5jeSA9ICR7cGFyYW1ldGVyLmN1cnJlbmN5fSAgZWxlbWVudC5jdXJyZW5jeSA9ICR7ZWxlbWVudC5jdXJyZW5jeX1gKTtcbiAgICAgICAgICAgICAgICAgICAgaWYgKGVsZW1lbnQubGlzdCAhPSBudWxsICYmIGVsZW1lbnQubGlzdC5sZW5ndGggPT0gMSkge1xuICAgICAgICAgICAgICAgICAgICAgICAgZWxlbWVudC5jaGlsZFZpcyA9IFwiZ29uZVwiO1xuICAgICAgICAgICAgICAgICAgICAgICAgZWxlbWVudC5leHBhbmRTdGF0dXNSZXMgPSBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9pY29uX2Vhcm5faG9tZV9qdW1wXCJcbiAgICAgICAgICAgICAgICAgICAgICAgIGVsZW1lbnQuYXB5VmlzID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgICAgICAgICAgICAgICAgICBpZiAoZXhwYW5kKSB7XG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgc2Nyb2xsVG9Qb3NUZW1wID0gaW5kZXg7XG4gICAgICAgICAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICAgICAgICAgaWYgKGV4cGFuZCkge1xuICAgICAgICAgICAgICAgICAgICAgICAgc2Nyb2xsVG9Qb3NUZW1wID0gaW5kZXg7XG4gICAgICAgICAgICAgICAgICAgICAgICBlbGVtZW50LmFweVZpcyA9IFwiZ29uZVwiO1xuICAgICAgICAgICAgICAgICAgICAgICAgZWxlbWVudC5jaGlsZFZpcyA9IFwidmlzaWJsZVwiO1xuICAgICAgICAgICAgICAgICAgICAgICAgZWxlbWVudC5leHBhbmRTdGF0dXNSZXMgPSBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9zdHJ1dHVyZWRfYXJyb3dfdXBcIjtcbiAgICAgICAgICAgICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgICAgICAgICAgZWxlbWVudC5hcHlWaXMgPSBcInZpc2libGVcIjtcbiAgICAgICAgICAgICAgICAgICAgICAgIGVsZW1lbnQuY2hpbGRWaXMgPSBcImdvbmVcIjtcbiAgICAgICAgICAgICAgICAgICAgICAgIGVsZW1lbnQuZXhwYW5kU3RhdHVzUmVzID0gXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfc3RydXR1cmVkX2Fycm93X2Rvd25cIjtcbiAgICAgICAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgICAgIH1cblxuICAgICAgICAgICAgICAgICAgICAvL+WKoOaBr+WIuCDlpJblsYJ0YWdcbiAgICAgICAgICAgICAgICAgICAgaWYgKGVsZW1lbnQudGFnID09IDcgJiZcbiAgICAgICAgICAgICAgICAgICAgICAgIGVsZW1lbnQudGFnQXB5ICE9IG51bGwgJiZcbiAgICAgICAgICAgICAgICAgICAgICAgIGVsZW1lbnQudGFnQXB5ICE9IFwiXCIgJiZcbiAgICAgICAgICAgICAgICAgICAgICAgIGVsZW1lbnQuY2hpbGRWaXMgPT0gXCJnb25lXCIpIHtcbiAgICAgICAgICAgICAgICAgICAgICAgIGVsZW1lbnQuY291cG9uVmlzID0gXCJ2aXNpYmxlXCJcbiAgICAgICAgICAgICAgICAgICAgICAgIGVsZW1lbnQuY291cG9uVmFsdWUgPSBlbGVtZW50LnRhZ0FweVxuICAgICAgICAgICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgICAgICAgICAgZWxlbWVudC5jb3Vwb25WaXMgPSBcImdvbmVcIlxuICAgICAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgICAgIC8v6K6+572uIHZpcCDlkowgbGF1bmNoZXJQb29sIOaVsOaNrlxuICAgICAgICAgICAgICAgICAgICBpZiAoZWxlbWVudC50YWcgPT0gOCB8fCBlbGVtZW50LnRhZyA9PSA5KSB7XG4gICAgICAgICAgICAgICAgICAgICAgICBlbGVtZW50Lmljb25TcmMgPSBnZXRUYWdJY29uQnlUeXBlKGVsZW1lbnQudGFnKTtcbiAgICAgICAgICAgICAgICAgICAgICAgIGlmIChlbGVtZW50LmNoaWxkVmlzID09IFwiZ29uZVwiKSB7XG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgZWxlbWVudC5pY29uVmlzID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgICAgICAgICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgICAgICAgICAgICAgIGVsZW1lbnQuaWNvblZpcyA9IFwiZ29uZVwiO1xuICAgICAgICAgICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgICAgICB9IGVsc2UgaWYgKGVsZW1lbnQudGFnID09IDExKSB7XG4gICAgICAgICAgICAgICAgICAgICAgICBpZiAoZWxlbWVudC5jaGlsZFZpcyAhPSBcInZpc2libGVcIikge1xuICAgICAgICAgICAgICAgICAgICAgICAgICAgIGVsZW1lbnQubGlzdE1haW5UYWdWaXMgPSBcInZpc2libGVcIjtcbiAgICAgICAgICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgICAgICAgICAgICAgIGVsZW1lbnQudGFnQmcgPSBnZXRUYWdCZ0J5VHlwZShlbGVtZW50LnRhZyk7XG4gICAgICAgICAgICAgICAgICAgICAgICBlbGVtZW50LnRhZ1RleHRDb2xvciA9IGdldFRhZ1RleHRDb2xvckJ5VHlwZShlbGVtZW50LnRhZyk7XG4gICAgICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgICAgICAgICAgaWYgKGVsZW1lbnQubGlzdCAhPSBudWxsKSB7XG4gICAgICAgICAgICAgICAgICAgICAgICBsZXQgdGVtcENoaWxkID0gZWxlbWVudC5saXN0O1xuICAgICAgICAgICAgICAgICAgICAgICAgdGVtcENoaWxkLmZvckVhY2goKGNoaWxkRWxlbWVudCwgaW5kZXgpID0+IHtcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICBjaGlsZEVsZW1lbnQudHlwZSA9IFwiMVwiO1xuICAgICAgICAgICAgICAgICAgICAgICAgICAgIGNoaWxkRWxlbWVudC5pbmRleCA9IGluZGV4O1xuICAgICAgICAgICAgICAgICAgICAgICAgICAgIGNoaWxkRWxlbWVudC5jb3Vwb25WaXMgPSBcImdvbmVcIlxuICAgICAgICAgICAgICAgICAgICAgICAgICAgIGNoaWxkRWxlbWVudC50YWdWaXMgPSBcImdvbmVcIjtcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICBjaGlsZEVsZW1lbnQudmlwSWNvblZpcyA9IFwiZ29uZVwiXG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgY2hpbGRFbGVtZW50LmVhcm5WaXBWaXMgPSBcImdvbmVcIlxuICAgICAgICAgICAgICAgICAgICAgICAgICAgIGlmIChjaGlsZEVsZW1lbnQuYXB5ID09IG51bGwpIHtcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgY2hpbGRFbGVtZW50LmFweSA9IFwiXCI7XG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgICAgICAgICAgICAgIGlmIChjaGlsZEVsZW1lbnQudGFnICE9IG51bGwgJiYgY2hpbGRFbGVtZW50LnRhZyAhPSAwKSB7XG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIC8v5Yqg5oGv5Yi4XG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIGlmIChjaGlsZEVsZW1lbnQudGFnID09IDcpIHtcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIGlmIChjaGlsZEVsZW1lbnQudGFnQXB5ICE9IG51bGwgJiYgY2hpbGRFbGVtZW50LnRhZ0FweSAhPSBcIlwiKSB7XG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgY2hpbGRFbGVtZW50LmNvdXBvblZpcyA9IFwidmlzaWJsZVwiXG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgY2hpbGRFbGVtZW50LmNvdXBvblZhbHVlID0gY2hpbGRFbGVtZW50LnRhZ0FweVxuICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgfSBcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgfSBlbHNlIGlmIChjaGlsZEVsZW1lbnQudGFnID09IDgpIHtcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIC8vdmlwXG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICBjaGlsZEVsZW1lbnQuaWNvblNyYyA9IGdldFRhZ0ljb25CeVR5cGUoY2hpbGRFbGVtZW50LnRhZyk7XG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICBjaGlsZEVsZW1lbnQuZWFyblZpcFZpcyA9IFwidmlzaWJsZVwiXG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICBjaGlsZEVsZW1lbnQudmlwSWNvblZpcyA9IFwidmlzaWJsZVwiXG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIH0gZWxzZSBpZiAoY2hpbGRFbGVtZW50LnRhZyA9PSA5KSB7XG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAvL0xhdW5jaFBvb2zmoIfnrb5cbiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIGNoaWxkRWxlbWVudC5pY29uU3JjID0gZ2V0VGFnSWNvbkJ5VHlwZShjaGlsZEVsZW1lbnQudGFnKTtcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIGNoaWxkRWxlbWVudC52aXBJY29uVmlzID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICBjaGlsZEVsZW1lbnQudGFnVmlzID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICBjaGlsZEVsZW1lbnQudGFnQmcgPSBnZXRUYWdCZ0J5VHlwZShjaGlsZEVsZW1lbnQudGFnKTtcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIGNoaWxkRWxlbWVudC50YWdUZXh0Q29sb3IgPSBnZXRUYWdUZXh0Q29sb3JCeVR5cGUoY2hpbGRFbGVtZW50LnRhZyk7XG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgICAgICAgICAgICAgICAgICB9IFxuICAgICAgICAgICAgICAgICAgICAgICAgfSk7XG4gICAgICAgICAgICAgICAgICAgICAgICBlbGVtZW50Lmxpc3QgPSB0ZW1wQ2hpbGQ7XG4gICAgICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgICAgICB9KTtcbiAgICAgICAgICAgICAgICAvL+WmguaenOayoeacieW4pui/m+adpeeahOW4geenje+8jOWImem7mOiupOWxleW8gOesrOS4gOS4qlxuICAgICAgICAgICAgICAgIGlmIChzY3JvbGxUb1Bvc1RlbXAgPT0gLTEpIHtcbiAgICAgICAgICAgICAgICAgICAgdGVtcEl0ZW1zWzBdLmNoaWxkVmlzID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgICAgICAgICAgICAgIHRlbXBJdGVtc1swXS5leHBhbmRTdGF0dXNSZXMgPSBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9zdHJ1dHVyZWRfYXJyb3dfdXBcIjtcbiAgICAgICAgICAgICAgICAgICAgdGVtcEl0ZW1zWzBdLmFweVZpcyA9IFwiZ29uZVwiO1xuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgICAgICBtb2R1bGVEYXRhLnJlY29tbWVuZExpc3QgPSB0ZW1wSXRlbXM7XG4gICAgICAgICAgICAgICAgcmVjb21tZW5kTGlzdCA9IHRlbXBJdGVtcztcbiAgICAgICAgICAgICAgICBjb25zb2xlLmxvZyhgeGlhb3lpIGlzRmlyc3Q9ICR7aXNGaXJzdH0gIHNjcm9sbFRvUG9zVGVtcCA9ICR7c2Nyb2xsVG9Qb3NUZW1wfWApO1xuICAgICAgICAgICAgICAgIGlmIChpc0ZpcnN0ICYmIGhhc0N1cnJlbmN5KCkpIHtcbiAgICAgICAgICAgICAgICAgICRkYXRhLmhvbWUuc2Nyb2xsVG9Qb3MgPSBzY3JvbGxUb1Bvc1RlbXA7XG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgIGNvaW5BbmFseXRpY3ModGVtcEl0ZW1zKTtcbiAgICAgICAgICAgICAgICBjb25zb2xlLmxvZyhgcmVxdWVzRWFybkhvbWVEYXRhICDmjqjojZDliJfooaggJHtKU09OLnN0cmluZ2lmeSh0ZW1wSXRlbXMpfWApO1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgLy/luLjop4Hpl67pophcbiAgICAgICAgICAgIGxldCBxYUxpc3QgPSBbe1xuICAgICAgICAgICAgICAgIHR5cGU6ICcxJyxcbiAgICAgICAgICAgICAgICBhbnN3ZXJWaXNhYmxlOiAnZ29uZScsXG4gICAgICAgICAgICAgICAgUTogJGkxOG4ubl9zdHJ1dHVyZWRfc2ltcGxlX0hfMSxcbiAgICAgICAgICAgICAgICBBOiAkaTE4bi5uX3N0cnV0dXJlZF9zaW1wbGVfVF8xLFxuICAgICAgICAgICAgICAgIHFhSWNvbjogXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfc2hhcmtfaG9tZV9xYV9zcHJlYWRfaWNvblwiLFxuICAgICAgICAgICAgICAgIEExU2hvdzogXCJnb25lXCIsXG4gICAgICAgICAgICAgICAgQTJTaG93OiBcImdvbmVcIlxuICAgICAgICAgICAgfSwge1xuICAgICAgICAgICAgICAgIHR5cGU6ICcxJyxcbiAgICAgICAgICAgICAgICBhbnN3ZXJWaXNhYmxlOiAnZ29uZScsXG4gICAgICAgICAgICAgICAgUTogJGkxOG4ubl9zdHJ1dHVyZWRfc2ltcGxlX0hfMixcbiAgICAgICAgICAgICAgICBBOiBgJHskaTE4bi5uX3N0cnV0dXJlZF9zaW1wbGVfVF8yXzF9YCxcbiAgICAgICAgICAgICAgICBBMTogYCR7JGkxOG4ubl9zdHJ1dHVyZWRfc2ltcGxlX1RfMl8yfWAsXG4gICAgICAgICAgICAgICAgQTI6IGAkeyRpMThuLm5fc3RydXR1cmVkX3NpbXBsZV9UXzJfM31gLFxuICAgICAgICAgICAgICAgIHFhSWNvbjogXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfc2hhcmtfaG9tZV9xYV9zcHJlYWRfaWNvblwiLFxuICAgICAgICAgICAgICAgIEExU2hvdzogXCJ2aXNpYmxlXCIsXG4gICAgICAgICAgICAgICAgQTJTaG93OiBcInZpc2libGVcIlxuICAgICAgICAgICAgfSwge1xuICAgICAgICAgICAgICAgIHR5cGU6ICcxJyxcbiAgICAgICAgICAgICAgICBhbnN3ZXJWaXNhYmxlOiAnZ29uZScsXG4gICAgICAgICAgICAgICAgUTogJGkxOG4ubl9zdHJ1dHVyZWRfc2ltcGxlX0hfMyxcbiAgICAgICAgICAgICAgICBBOiBgJHskaTE4bi5uX3N0cnV0dXJlZF9zaW1wbGVfVF8zfWAsXG4gICAgICAgICAgICAgICAgQTE6IGAkeyRpMThuLm5fc3RydXR1cmVkX2ludHJvX0FfM18yfWAsXG4gICAgICAgICAgICAgICAgQTI6IGAkeyRpMThuLm5fc3RydXR1cmVkX2ludHJvX0FfM18zfWAsXG4gICAgICAgICAgICAgICAgcWFJY29uOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9zaGFya19ob21lX3FhX3NwcmVhZF9pY29uXCIsXG4gICAgICAgICAgICAgICAgQTFTaG93OiBcInZpc2libGVcIixcbiAgICAgICAgICAgICAgICBBMlNob3c6IFwidmlzaWJsZVwiXG4gICAgICAgICAgICB9XVxuICAgICAgICAgICAgbW9kdWxlRGF0YS5xYUxpc3QgPSBxYUxpc3Q7XG4gICAgICAgICAgICBjb25zb2xlLmxvZyhgcmVxdWVzRWFybkhvbWVEYXRhICDluLjop4Hpl67pophgKTtcbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIGNvbW1vbi5hbmFseXRpY3MoXCJhcHBfZWFyblBhZ2VfbG9hZFN0YXRlXCIsIHsgcGFnZUxvYWRTdGF0ZTogYGZhdWx0YCB9KTtcbiAgICAgICAgICAgIGNvbW1vbi5hbmFseXRpY3MoXCJhcHBfZWFyblBhZ2VfbG9hZEVycm9yXCIsIHsgZXJyb3JNc2c6IGDmjqXlj6Por7fmsYLlpLHotKVgIH0pO1xuICAgICAgICB9XG4gICAgfSBjYXRjaCAoZSkge1xuICAgICAgICBjb21tb24uYW5hbHl0aWNzKFwiYXBwX2Vhcm5QYWdlX2xvYWRTdGF0ZVwiLCB7IHBhZ2VMb2FkU3RhdGU6IGBmYXVsdGAgfSk7XG4gICAgICAgIGNvbW1vbi5hbmFseXRpY3MoXCJhcHBfZWFyblBhZ2VfbG9hZEVycm9yXCIsIHsgZXJyb3JNc2c6IGDmlbDmja7lvILluLgg77yaICR7ZX1gIH0pO1xuICAgICAgICBjb25zb2xlLmxvZyhgcmVxdWVzRWFybkhvbWVEYXRhIGVycm9yLCBlcnJvciA9ICR7ZX1gKTtcbiAgICB9XG4gICAgY29uc29sZS5sb2coYOWIt+aWsOe7k+adn2ApO1xuICAgIG1vZHVsZURhdGEucmVmcmVzaFN0YXR1cyA9IDI7XG4gICAgLy/pqqjmnrbmtojlpLFcbiAgICBtb2R1bGVEYXRhLmxvYWRpbmdMb3R0aWVWaXMgPSBcImdvbmVcIjtcbiAgICBtb2R1bGVEYXRhLmxvYWRpbmdMb3R0aWVTdGF0dXMgPSBcInN0b3BcIjtcbiAgICBjb25zdCBlbmRUaW1lID0gRGF0ZS5ub3coKTtcbiAgICBjb25zb2xlLmxvZyhg55CG6LSi6aaW6aG15Yqg6L296ICX5pe2IO+8miAke2VuZFRpbWUgLSBzdGFydFRpbWV9YCk7XG4gICAgY29tbW9uLmFuYWx5dGljcyhcImFwcF9lYXJuUGFnZV9sb2FkVGltZVwiLCB7XG4gICAgICAgIHBhZ2VMb2FkVGltZTogYCR7ZW5kVGltZSAtIHN0YXJ0VGltZX1gLFxuICAgICAgICBuYXRpb246IGAke2NvbW1vbi5jb21tb25EYXRhLmNvdW50cnlJZH1gLFxuICAgIH0pO1xuXG4gICAgaWYgKGd1aWRlU2hvdyA9PSBudWxsIHx8IGd1aWRlU2hvdyA9PSBcIlwiKSB7XG4gICAgICAgIGd1aWRlU2hvdyA9IFwiMVwiO1xuICAgICAgICBtb2R1bGVEYXRhLnBvcDFTaG93ID0gdHJ1ZTtcbiAgICAgICAgJG5hdGl2ZUFQSS5zdG9yYWdlKHtcbiAgICAgICAgICAgIGFjdGlvbjogXCJzYXZlXCIsXG4gICAgICAgICAgICBuYW1lOiBcImVhcm5cIixcbiAgICAgICAgICAgIGtleTogXCJndWlkZV9zaG93XCIsXG4gICAgICAgICAgICBkYXRhOiBcIjFcIlxuICAgICAgICB9KVxuICAgIH1cbn1cbi8v5Lyg6YCS6L+b5p2l55qE5Y+C5pWw6YeM5piv5ZCm5pyJ5biB56eNXG5mdW5jdGlvbiBoYXNDdXJyZW5jeSgpIHtcbiAgICByZXR1cm4gcGFyYW1ldGVyLmN1cnJlbmN5ICE9IHVuZGVmaW5lZCAmJiBwYXJhbWV0ZXIuY3VycmVuY3kgIT0gbnVsbCAmJiBwYXJhbWV0ZXIuY3VycmVuY3kgIT0gXCJcIlxufVxuXG5mdW5jdGlvbiBoYW5kbGVUb3RhbEluY29tZVJpY2goKSB7XG4gICAgbGV0IHRleHQgPSBtb2R1bGVEYXRhLnllc3RlcmRheUluY29tZTtcbiAgICBsZXQgaGlnaGxpZ2h0ID0gbW9kdWxlRGF0YS50b3RhbEluY29tZTtcbiAgICB2YXIgdGV4dENvbG9yID0gXCIjMDAwMDAwXCI7XG4gICAgdmFyIHNwYWNlQ29sb3IgPSBcIiNGRkZGRkZcIjtcbiAgICB2YXIgaGlnaGxpZ2h0Q29sb3IgPSBcIiM4QThBOEVcIjtcbiAgICB2YXIgYXJyb3dDb2xvciA9IFwiI0FEQURCNFwiO1xuICAgIGlmIChjb21tb24uY29tbW9uRGF0YS5jb2xvck1vZGUgPT0gMSkge1xuICAgICAgICB0ZXh0Q29sb3IgPSBcIiNFNkU2RTZcIlxuICAgICAgICBzcGFjZUNvbG9yID0gXCIjMUUxRTFGXCI7XG4gICAgICAgIGhpZ2hsaWdodENvbG9yID0gXCIjNUU1RTYxXCI7XG4gICAgICAgIGFycm93Q29sb3IgPSBcIiM0QzRDNEVcIjtcbiAgICB9XG5cbiAgICByZXR1cm4gYDxzcGFuIHN0eWxlPVwiY29sb3I6JHt0ZXh0Q29sb3J9OyBmb250LXNpemU6MTJweDtcIj4ke3RleHR9PC9zcGFuPjxzcGFuIHN0eWxlPVwiY29sb3I6JHtzcGFjZUNvbG9yfTsgZm9udC1zaXplOjEwcHg7XCI+LS08L3NwYW4+PHNwYW4gc3R5bGU9XCJjb2xvcjoke2hpZ2hsaWdodENvbG9yfTsgZm9udC1zaXplOjEycHg7XCI+JHtoaWdobGlnaHR9PC9zcGFuPjxzcGFuIHN0eWxlPVwiY29sb3I6JHthcnJvd0NvbG9yfTsgZm9udC1zaXplOjEycHg7XCI+IOKdrzwvc3Bhbj5gO1xufVxuXG5mdW5jdGlvbiBjb2luQW5hbHl0aWNzKGNvaW5EdGEpIHtcbiAgICB0cnkge1xuICAgICAgICBjb2luRHRhLmZvckVhY2goKGVsZW1lbnQsIGluZGV4KSA9PiB7XG4gICAgICAgICAgICBjb25zb2xlLmxvZyhgY29pbkFuYWx5dGljcyAgJHtKU09OLnN0cmluZ2lmeShlbGVtZW50KX1gKTtcbiAgICAgICAgICAgIGNvbW1vbi5hbmFseXRpY3MoXCJhcHBfZWFybl90b2tlbkNhcmRfc2hvd1wiLCB7XG4gICAgICAgICAgICAgICAgcGFnZTogXCJlYXJuSG9tZVwiLFxuICAgICAgICAgICAgICAgIHRva2VuOiBlbGVtZW50LmN1cnJlbmN5LFxuICAgICAgICAgICAgICAgIHRzQmFzZUluZm86IGVsZW1lbnQudHNCYXNlSW5mb1xuICAgICAgICAgICAgfSk7XG4gICAgICAgIH0pO1xuXG4gICAgfSBjYXRjaCAoZSkge1xuICAgICAgICBjb25zb2xlLmxvZyhgY29pbkFuYWx5dGljcyBlcnJvciwgZXJyb3IgPSAke2V9YCk7XG4gICAgfVxufVxuXG5mdW5jdGlvbiBzdGFydFNoYXJrRmluQ291bnREb3duKCkge1xuICAgIGNsZWFyVGltZXIoKTtcbiAgICBpbnRlcmNhbCA9IHNldEludGVydmFsKGNoYW5nZUNvdW50ZG93biwgMTAwMCk7XG59XG5cbmZ1bmN0aW9uIGNoYW5nZUNvdW50ZG93bigpIHtcbiAgICB0cnkge1xuICAgICAgICBjb25zb2xlLmxvZyhgY2hhbmdlQ291bnRkb3duID0gJHtKU09OLnN0cmluZ2lmeShtb2R1bGVEYXRhLmJhbm5lckxpc3QucmF3QXJyYXkoKSl9YCk7XG4gICAgICAgIGZvciAobGV0IGkgPSAwOyBpIDwgbW9kdWxlRGF0YS5iYW5uZXJMaXN0Lmxlbmd0aDsgaSsrKSB7XG4gICAgICAgICAgICAvL+aYr+WQpuWtmOWcqOmyqOmxvOmzjVxuICAgICAgICAgICAgaWYgKG1vZHVsZURhdGEuYmFubmVyTGlzdFtpXS5hcmVhVHlwZSA9PSAxICYmIG1vZHVsZURhdGEuYmFubmVyTGlzdFtpXS5wcm9qZWN0LnByb2pUeXBlID09IDQpIHtcbiAgICAgICAgICAgICAgICBsZXQgcHJvamVjdCA9IG1vZHVsZURhdGEuYmFubmVyTGlzdFtpXS5wcm9qZWN0O1xuICAgICAgICAgICAgICAgIGlmIChwcm9qZWN0LmNvdW50ZG93biA9PSBudWxsKSB7XG4gICAgICAgICAgICAgICAgICAgIHJldHVybjtcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgbGV0IGNvdW50RG93biA9IChwYXJzZUZsb2F0KHByb2plY3QuY291bnRkb3duKSAtIHNoYXJrRmluQ291bnQgKiAxMDAwKSAvIDEwMDA7XG4gICAgICAgICAgICAgICAgc2hhcmtGaW5Db3VudCA9IHNoYXJrRmluQ291bnQgKyAxO1xuICAgICAgICAgICAgICAgIGlmIChjb3VudERvd24gPiAwKSB7XG4gICAgICAgICAgICAgICAgICAgIC8vIOeUs+i0reWAkuiuoeaXtlxuICAgICAgICAgICAgICAgICAgICBjb25zdCBkID0gTWF0aC5mbG9vcihjb3VudERvd24gLyBkZCk7XG4gICAgICAgICAgICAgICAgICAgIGNvbnN0IGggPSBNYXRoLmZsb29yKChjb3VudERvd24gJSBkZCkgLyBoaCk7XG4gICAgICAgICAgICAgICAgICAgIGNvbnN0IG0gPSBNYXRoLmZsb29yKChjb3VudERvd24gJSBoaCkgLyBtbSk7XG4gICAgICAgICAgICAgICAgICAgIGNvbnN0IHMgPSBNYXRoLmZsb29yKGNvdW50RG93biAlIG1tKTtcbiAgICAgICAgICAgICAgICAgICAgY29uc3Qgc2hvd0ggPSBoIDwgMTAgPyBgMCR7aH1gIDogYCR7aH1gO1xuICAgICAgICAgICAgICAgICAgICBjb25zdCBzaG93TSA9IG0gPCAxMCA/IGAwJHttfWAgOiBgJHttfWA7XG4gICAgICAgICAgICAgICAgICAgIGNvbnN0IHNob3dTID0gcyA8IDEwID8gYDAke3N9YCA6IGAke3N9YDtcbiAgICAgICAgICAgICAgICAgICAgaWYgKGQgPiAwKSB7XG4gICAgICAgICAgICAgICAgICAgICAgICBwcm9qZWN0LmNvdW50RG93blN0ciA9IGAkeyRpMThuLm5fZXhjaGFuZ2VfY2FsbF9hdWN0aW9uX2VuZF9vZl9kaXN0YW5jZX0gJHtkfSR7JGkxOG4ubl9taW5pbmdfZGF5X3RleHR9ICR7c2hvd0h9OiR7c2hvd019OiR7c2hvd1N9YDtcbiAgICAgICAgICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgICAgICAgICAgIHByb2plY3QuY291bnREb3duU3RyID0gYCR7JGkxOG4ubl9leGNoYW5nZV9jYWxsX2F1Y3Rpb25fZW5kX29mX2Rpc3RhbmNlfSAke3Nob3dIfToke3Nob3dNfToke3Nob3dTfWA7XG4gICAgICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgICAgICAgICAgY29uc29sZS5sb2coYGNvdW50RG93blN0ciA9ICR7cHJvamVjdC5jb3VudERvd25TdHJ9YCk7XG4gICAgICAgICAgICAgICAgICAgIG1vZHVsZURhdGEuYmFubmVyTGlzdFtpXS5wcm9qZWN0ID0gcHJvamVjdFxuICAgICAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICAgICAgIHJlcXVlc0Vhcm5Ib21lRGF0YSgpO1xuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgIH1cbiAgICAgICAgfVxuICAgIH0gY2F0Y2ggKGUpIHtcbiAgICAgICAgY29uc29sZS5sb2coYHJlcXVlc0Vhcm5Ib21lRGF0YSBlcnJvciwgZXJyb3IgPSAke2V9YCk7XG4gICAgfVxufVxuXG5mdW5jdGlvbiBjbGVhclRpbWVyKCkge1xuICAgIGlmIChpbnRlcmNhbCAhPSBudWxsKSB7XG4gICAgICAgIGNsZWFySW50ZXJ2YWwoaW50ZXJjYWwpO1xuICAgICAgICBpbnRlcmNhbCA9IG51bGw7XG4gICAgICAgIHNoYXJrRmluQ291bnQgPSAxO1xuICAgIH1cbn1cblxuLyoqXG4gKiDmoLnmja50YWfojrflj5blr7nlupRpY29uXG4gKiA4LXZpcO+8mzktbGF1bmNoZXJQb29sXG4gKi9cbmZ1bmN0aW9uIGdldFRhZ0ljb25CeVR5cGUodHlwZSl7XG4gICAgaWYgKHR5cGUgPT0gOSkge1xuICAgICAgcmV0dXJuIFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX2Vhcm5fbGF1bmNoZXJfcG9vbF9pY29uXCI7XG4gICAgfSBlbHNlIHtcbiAgICAgIHJldHVybiBtb2R1bGVEYXRhLnZpcEljb247XG4gICAgfVxufVxuXG5mdW5jdGlvbiBnZXRUYWdCZ0J5VHlwZSh0eXBlKSB7XG4gICAgaWYgKHR5cGUgPT0gMCkge1xuICAgICAgICByZXR1cm4gbnVsbDtcbiAgICB9IGVsc2UgaWYgKHR5cGUgPT0gMSkge1xuICAgICAgICByZXR1cm4gXCJAY29sb3IvS0NvbG9yMTIwMEExNzFcIlxuICAgIH0gZWxzZSBpZiAodHlwZSA9PSAyKSB7XG4gICAgICAgIHJldHVybiBcIkBjb2xvci9LQ29sb3IxMjAwQTE3MVwiXG4gICAgfSBlbHNlIGlmICh0eXBlID09IDMpIHtcbiAgICAgICAgcmV0dXJuIFwiQGNvbG9yL2tDb2xvcjE5MDBBMTcxXCJcbiAgICB9IGVsc2UgaWYgKHR5cGUgPT0gNCkge1xuICAgICAgICByZXR1cm4gXCJAY29sb3IvS0NvbG9yMTJGRTg3MzFcIlxuICAgIH0gZWxzZSBpZiAodHlwZSA9PSA1KSB7XG4gICAgICAgIHJldHVybiBcIkBjb2xvci9rQ29sb3JJbnB1dEZpbGxcIlxuICAgIH0gZWxzZSBpZiAodHlwZSA9PSA2KSB7XG4gICAgICAgIHJldHVybiBcIkBjb2xvci9LQ29sb3IxMkZFODczMVwiXG4gICAgfSBlbHNlIGlmICh0eXBlID09IDEwMSkge1xuICAgICAgICByZXR1cm4gXCJAY29sb3Iva0NvbG9yU2Vjb25kYXJ5VGV4dFwiXG4gICAgfSBlbHNlIGlmICh0eXBlID09IDExKSB7XG4gICAgICAgIHJldHVybiBcIkBjb2xvci9rQ29sb3IxQTAxNzNFNVwiXG4gICAgfVxufVxuXG5mdW5jdGlvbiBnZXRUYWdUZXh0Q29sb3JCeVR5cGUodHlwZSkge1xuICAgIGlmICh0eXBlID09IDApIHtcbiAgICAgICAgcmV0dXJuIG51bGw7XG4gICAgfSBlbHNlIGlmICh0eXBlID09IDEpIHtcbiAgICAgICAgcmV0dXJuIFwiQGNvbG9yL0tCYXNlUmlza1RleHRDb2xvckxvd1wiXG4gICAgfSBlbHNlIGlmICh0eXBlID09IDIpIHtcbiAgICAgICAgcmV0dXJuIFwiQGNvbG9yL0tCYXNlUmlza1RleHRDb2xvckxvd1wiXG4gICAgfSBlbHNlIGlmICh0eXBlID09IDMpIHtcbiAgICAgICAgcmV0dXJuIFwiQGNvbG9yL2tDb2xvclByaWNlR3JlZW5cIlxuICAgIH0gZWxzZSBpZiAodHlwZSA9PSA0KSB7XG4gICAgICAgIHJldHVybiBcIkBjb2xvci9LQmFzZVJpc2tUZXh0Q29sb3JNaWRcIlxuICAgIH0gZWxzZSBpZiAodHlwZSA9PSA1KSB7XG4gICAgICAgIHJldHVybiBcIkBjb2xvci9rQ29sb3JTZWNvbmRhcnlUZXh0XCJcbiAgICB9IGVsc2UgaWYgKHR5cGUgPT0gNikge1xuICAgICAgICByZXR1cm4gXCJAY29sb3IvS0Jhc2VSaXNrVGV4dENvbG9yTWlkXCJcbiAgICB9IGVsc2UgaWYgKHR5cGUgPT0gMTAxKSB7XG4gICAgICAgIHJldHVybiBcIkBjb2xvci9rQ29sb3JTZWNvbmRhcnlUZXh0XCJcbiAgICB9IGVsc2UgaWYgKHR5cGUgPT0gMTEpIHtcbiAgICAgICAgcmV0dXJuIFwiQGNvbG9yL2tDb2xvck1ham9yVGhlbWUxMDBcIlxuICAgIH1cbn1cblxubW9kdWxlRXZlbnQuZnVuY0NsaWNrID0gZnVuY3Rpb24gKGluZGV4KSB7XG4gICAgdmFyIGVsZW1lbnQgPSBtb2R1bGVEYXRhLmZ1bmNMaXN0W2luZGV4XTtcbiAgICBjb25zb2xlLmxvZyhgZnVuY0NsaWNrICBpbmRleCA6ICR7aW5kZXh9ICBqdW1wVXJsIDogJHtlbGVtZW50Lmp1bXBVcmx9YCk7XG4gICAgY29tbW9uLm9wZW5QYWdlV2l0aFBhdGgoZWxlbWVudC5qdW1wVXJsKTtcbiAgICBsZXQgcHJvZHVjdENsYXNzaWZ5ID0gXCJzaW1wbGVFYXJuXCI7XG4gICAgaWYgKGluZGV4ID09IDApIHtcbiAgICAgICAgcHJvZHVjdENsYXNzaWZ5ID0gXCJzaW1wbGVFYXJuXCI7XG4gICAgfSBlbHNlIGlmIChpbmRleCA9PSAxKSB7XG4gICAgICAgIHByb2R1Y3RDbGFzc2lmeSA9IFwibmV3UHJvZHVjdFwiO1xuICAgIH0gZWxzZSBpZiAoaW5kZXggPT0gMikge1xuICAgICAgICBwcm9kdWN0Q2xhc3NpZnkgPSBcInN0cnVjdHVyZWRQcm9kdWN0XCI7XG4gICAgfSBlbHNlIGlmIChpbmRleCA9PSAzKSB7XG4gICAgICAgIHByb2R1Y3RDbGFzc2lmeSA9IFwib25DaGFpbkVhcm5cIjtcbiAgICB9XG4gICAgY29tbW9uLmFuYWx5dGljcyhcImFwcF9lYXJuUGFnZV9pY29uX2NsaWNrXCIsIHsgcHJvZHVjdENsYXNzaWZ5OiBwcm9kdWN0Q2xhc3NpZnkgfSk7XG59XG5cbm1vZHVsZUV2ZW50LmNsaWNrUUEgPSBmdW5jdGlvbiAoUSkge1xuICAgIHRyeSB7XG4gICAgICAgIGNvbnNvbGUubG9nKGBjbGlja1FBIDogJHtRfWApO1xuICAgICAgICBsZXQgdGVtcFFhTGlzdCA9IG1vZHVsZURhdGEucWFMaXN0O1xuICAgICAgICBjb25zb2xlLmxvZyhgY2xpY2tRQSA6ICR7SlNPTi5zdHJpbmdpZnkobW9kdWxlRGF0YS5xYUxpc3QucmF3QXJyYXkoKSl9YCk7XG4gICAgICAgIGNvbnNvbGUubG9nKGBjbGlja1FBIDogJHtKU09OLnN0cmluZ2lmeSh0ZW1wUWFMaXN0LnJhd0FycmF5KCkpfWApO1xuICAgICAgICBmb3IgKGxldCBpbmRleCA9IDA7IGluZGV4IDwgdGVtcFFhTGlzdC5sZW5ndGg7IGluZGV4KyspIHtcbiAgICAgICAgICAgIGxldCBlbGVtZW50ID0gdGVtcFFhTGlzdFtpbmRleF07XG4gICAgICAgICAgICBjb25zb2xlLmxvZyhgY2xpY2tRQSA6ICR7UX0gICAgICR7ZWxlbWVudC5RfWApO1xuICAgICAgICAgICAgaWYgKFEgPT0gZWxlbWVudC5RKSB7XG4gICAgICAgICAgICAgICAgbGV0IG9wZXJhdGlvblR5cGUgPSBcInVuZm9sZFwiO1xuICAgICAgICAgICAgICAgIGlmIChlbGVtZW50LmFuc3dlclZpc2FibGUgPT0gJ2dvbmUnKSB7XG4gICAgICAgICAgICAgICAgICAgIGVsZW1lbnQuYW5zd2VyVmlzYWJsZSA9ICd2aXNpYmxlJztcbiAgICAgICAgICAgICAgICAgICAgZWxlbWVudC5xYUljb24gPSBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9zaGFya19ob21lX3FhX3JldHJhY3RfaWNvblwiO1xuICAgICAgICAgICAgICAgICAgICBvcGVyYXRpb25UeXBlID0gXCJ1bmZvbGRcIjtcbiAgICAgICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgICAgICBlbGVtZW50LmFuc3dlclZpc2FibGUgPSAnZ29uZSc7XG4gICAgICAgICAgICAgICAgICAgIGVsZW1lbnQucWFJY29uID0gXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfc2hhcmtfaG9tZV9xYV9zcHJlYWRfaWNvblwiO1xuICAgICAgICAgICAgICAgICAgICBvcGVyYXRpb25UeXBlID0gXCJmb2xkXCI7XG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgIGNvbW1vbi5hbmFseXRpY3MoXCJhcHBfZWFybl9GQVFzX3VuZm9sZEFuZEZvbGRfY2xpY2tcIiwge1xuICAgICAgICAgICAgICAgICAgICBwYWdlOiBcImVhcm5Ib21lXCIsXG4gICAgICAgICAgICAgICAgICAgIG9wZXJhdGlvblR5cGU6IG9wZXJhdGlvblR5cGUsXG4gICAgICAgICAgICAgICAgICAgIG9yZGVyOiBgJHtpbmRleH1gXG4gICAgICAgICAgICAgICAgfSk7XG4gICAgICAgICAgICB9XG4gICAgICAgIH1cbiAgICAgICAgbW9kdWxlRGF0YS5xYUxpc3QgPSB0ZW1wUWFMaXN0O1xuICAgIH0gY2F0Y2ggKGUpIHtcbiAgICAgICAgY29uc29sZS5sb2coYGNsaWNrUUEgZXJyb3IsIGVycm9yID0gJHtlfWApO1xuICAgIH1cbn1cblxubW9kdWxlRXZlbnQuaXRlbUNsaWNrID0gZnVuY3Rpb24gKGluZGV4KSB7XG4gICAgdHJ5IHtcbiAgICAgICAgY29uc29sZS5sb2coYGl0ZW1DbGljayA6ICR7aW5kZXh9ICAgICR7cmVjb21tZW5kTGlzdFtpbmRleF0uY2hpbGRWaXN9ICAke3JlY29tbWVuZExpc3RbaW5kZXhdLmxpc3RNYWluVGFnVmlzfWApO1xuICAgICAgICBsZXQgdGVtcEVsZW1lbnQgPSB7fTtcbiAgICAgICAgaWYgKGNvbW1vbi5jb21tb25EYXRhLk9TID09IDEpIHtcbiAgICAgICAgICAgIHRlbXBFbGVtZW50ID0gbW9kdWxlRGF0YS5yZWNvbW1lbmRMaXN0W2luZGV4XTtcbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIHRlbXBFbGVtZW50ID0gcmVjb21tZW5kTGlzdFtpbmRleF07XG4gICAgICAgIH1cbiAgICAgICAgLy8yMDI0LzEwLzE154mI5pys5paw5aKeIOWmguaenOWNleS6p+WTgeebtOaOpei/m+WFpeeUs+i0remhtemdolxuICAgICAgICBpZiAodGVtcEVsZW1lbnQubGlzdCAhPSBudWxsICYmIHRlbXBFbGVtZW50Lmxpc3QubGVuZ3RoID09IDEpIHtcbiAgICAgICAgICAgIGxldCBjaGlsZEVsZW1lbnQgPSByZWNvbW1lbmRMaXN0W2luZGV4XS5saXN0WzBdO1xuICAgICAgICAgICAganVtcFByb2R1Y3QoY2hpbGRFbGVtZW50LCByZWNvbW1lbmRMaXN0W2luZGV4XSk7XG4gICAgICAgICAgICBjb21tb24uYW5hbHl0aWNzKFwiYXBwX2Vhcm5fcHJvZHVjdENhcmRfc2hvd1wiLCB7XG4gICAgICAgICAgICAgICAgcGFnZTogXCJlYXJuSG9tZVwiLFxuICAgICAgICAgICAgICAgIHByb2plY3RJZHM6IGNoaWxkRWxlbWVudC5wcm9qZWN0SWRzLFxuICAgICAgICAgICAgICAgIHByb2plY3RUeXBlOiBjaGlsZEVsZW1lbnQucHJvalR5cGUsXG4gICAgICAgICAgICAgICAgdG9rZW46IHJlY29tbWVuZExpc3RbaW5kZXhdLmN1cnJlbmN5LFxuICAgICAgICAgICAgICAgIHRzQmFzZUluZm86IHJlY29tbWVuZExpc3RbaW5kZXhdLnRzQmFzZUluZm9cbiAgICAgICAgICAgIH0pO1xuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgbGV0IG9wZXJhdGlvblR5cGUgPSBcInVuZm9sZFwiO1xuICAgICAgICAgICAgaWYgKHRlbXBFbGVtZW50Lmxpc3RNYWluVGFnVmlzID09IFwidmlzaWJsZVwiKSB7XG4gICAgICAgICAgICAgICAgdGVtcEVsZW1lbnQubGlzdE1haW5UYWdWaXMgPSBcImdvbmVcIjtcbiAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICAgaWYgKHRlbXBFbGVtZW50LnRhZyA9PSAxMSkge1xuICAgICAgICAgICAgICAgICAgICB0ZW1wRWxlbWVudC5saXN0TWFpblRhZ1ZpcyA9IFwidmlzaWJsZVwiO1xuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIGlmICh0ZW1wRWxlbWVudC5jaGlsZFZpcyA9PSBcImdvbmVcIikge1xuICAgICAgICAgICAgICAgIHRlbXBFbGVtZW50LmNoaWxkVmlzID0gXCJ2aXNpYmxlXCJcbiAgICAgICAgICAgICAgICB0ZW1wRWxlbWVudC5hcHlWaXMgPSBcImdvbmVcIjtcbiAgICAgICAgICAgICAgICB0ZW1wRWxlbWVudC5jb3Vwb25WaXMgPSBcImdvbmVcIlxuICAgICAgICAgICAgICAgIC8v6ZqQ6JePdmlw5ZKMbGF1bmNoZXJQb29sXG4gICAgICAgICAgICAgICAgdGVtcEVsZW1lbnQuaWNvblZpcyA9IFwiZ29uZVwiO1xuICAgICAgICAgICAgICAgIHRlbXBFbGVtZW50LmV4cGFuZFN0YXR1c1JlcyA9IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX3N0cnV0dXJlZF9hcnJvd191cFwiXG4gICAgICAgICAgICAgICAgb3BlcmF0aW9uVHlwZSA9IFwidW5mb2xkXCI7XG5cbiAgICAgICAgICAgICAgICByZWNvbW1lbmRMaXN0W2luZGV4XS5saXN0LmZvckVhY2goKGNoaWxkRWxlbWVudCwgaW5kZXgpID0+IHtcbiAgICAgICAgICAgICAgICAgICAgY29tbW9uLmFuYWx5dGljcyhcImFwcF9lYXJuX3Byb2R1Y3RDYXJkX3Nob3dcIiwge1xuICAgICAgICAgICAgICAgICAgICAgICAgcGFnZTogXCJlYXJuSG9tZVwiLFxuICAgICAgICAgICAgICAgICAgICAgICAgcHJvamVjdElkczogY2hpbGRFbGVtZW50LnByb2plY3RJZHMsXG4gICAgICAgICAgICAgICAgICAgICAgICBwcm9qZWN0VHlwZTogY2hpbGRFbGVtZW50LnByb2pUeXBlLFxuICAgICAgICAgICAgICAgICAgICAgICAgdG9rZW46IHRlbXBFbGVtZW50LmN1cnJlbmN5LFxuICAgICAgICAgICAgICAgICAgICAgICAgdHNCYXNlSW5mbzogcmVjb21tZW5kTGlzdFtpbmRleF0udHNCYXNlSW5mb1xuICAgICAgICAgICAgICAgICAgICB9KTtcbiAgICAgICAgICAgICAgICB9KTtcbiAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICAgdGVtcEVsZW1lbnQuY2hpbGRWaXMgPSBcImdvbmVcIlxuICAgICAgICAgICAgICAgIHRlbXBFbGVtZW50LmFweVZpcyA9IFwidmlzaWJsZVwiO1xuICAgICAgICAgICAgICAgIC8v5Yqg5oGv5Yi4XG4gICAgICAgICAgICAgICAgaWYgKHRlbXBFbGVtZW50LnRhZyA9PSA3ICYmIHRlbXBFbGVtZW50LnRhZ0FweSAhPSBudWxsICYmIHRlbXBFbGVtZW50LnRhZ0FweSAhPSBcIlwiKSB7XG4gICAgICAgICAgICAgICAgICAgIHRlbXBFbGVtZW50LmNvdXBvblZpcyA9IFwidmlzaWJsZVwiXG4gICAgICAgICAgICAgICAgICAgIHRlbXBFbGVtZW50LmNvdXBvblZhbHVlID0gdGVtcEVsZW1lbnQudGFnQXB5XG4gICAgICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgICAgICAgdGVtcEVsZW1lbnQuY291cG9uVmlzID0gXCJnb25lXCJcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgLy/lsZXnpLogdmlwIOWSjCBsYXVuY2hlclBvb2xcbiAgICAgICAgICAgICAgICBpZiAodGVtcEVsZW1lbnQudGFnID09IDggfHwgdGVtcEVsZW1lbnQudGFnID09IDkpIHtcbiAgICAgICAgICAgICAgICAgICAgdGVtcEVsZW1lbnQuaWNvblZpcyA9IFwidmlzaWJsZVwiO1xuICAgICAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICAgICAgIHRlbXBFbGVtZW50Lmljb25WaXMgPSBcImdvbmVcIjtcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgdGVtcEVsZW1lbnQuZXhwYW5kU3RhdHVzUmVzID0gXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfc3RydXR1cmVkX2Fycm93X2Rvd25cIlxuICAgICAgICAgICAgICAgIG9wZXJhdGlvblR5cGUgPSBcImZvbGRcIjtcbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIGNvbnNvbGUubG9nKGBhcHBfZWFybl90b2tlbkNhcmRfY2xpY2sgOiAke0pTT04uc3RyaW5naWZ5KHRlbXBFbGVtZW50KX1gKTtcbiAgICAgICAgICAgIGlmIChjb21tb24uY29tbW9uRGF0YS5PUyA9PSAxKSB7XG5cbiAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICAgbW9kdWxlRGF0YS5yZWNvbW1lbmRMaXN0W2luZGV4XSA9IHRlbXBFbGVtZW50O1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgY29tbW9uLmFuYWx5dGljcyhcImFwcF9lYXJuX3Rva2VuQ2FyZF9jbGlja1wiLCB7XG4gICAgICAgICAgICAgICAgcGFnZTogXCJlYXJuSG9tZVwiLFxuICAgICAgICAgICAgICAgIHRva2VuOiB0ZW1wRWxlbWVudC5jdXJyZW5jeSxcbiAgICAgICAgICAgICAgICBvcGVyYXRpb25UeXBlOiBvcGVyYXRpb25UeXBlLFxuICAgICAgICAgICAgICAgIHRzQmFzZUluZm86IHJlY29tbWVuZExpc3RbaW5kZXhdLnRzQmFzZUluZm9cbiAgICAgICAgICAgIH0pO1xuICAgICAgICB9XG4gICAgfSBjYXRjaCAoZSkge1xuICAgICAgICBjb25zb2xlLmxvZyhgaXRlbUNsaWNrIGVycm9yLCBlcnJvciA9ICR7ZX1gKTtcbiAgICB9XG59XG5cbm1vZHVsZUV2ZW50Lm5leHRJdGVtQ2xpY2sgPSBmdW5jdGlvbiAodHlwZSA9IDApIHtcbiAgICBpZiAob3JpZ2luTWFpbkRhdGEgIT0gbnVsbCAmJiBvcmlnaW5NYWluRGF0YS5uZXh0ICE9IG51bGwgJiYgb3JpZ2luTWFpbkRhdGEubmV4dC5qdW1wVXJsICE9IG51bGwpIHtcbiAgICAgICAgY29uc29sZS5sb2coYHJvdXRlciA9ICR7b3JpZ2luTWFpbkRhdGEubmV4dC5qdW1wVXJsfWApO1xuICAgICAgICBjb21tb24ub3BlblBhZ2VXaXRoUGF0aChvcmlnaW5NYWluRGF0YS5uZXh0Lmp1bXBVcmwpO1xuICAgIH1cbiAgICBpZiAodHlwZSA9PSAxKSB7XG4gICAgICAgIGNvbW1vbi5hbmFseXRpY3MoXCJhcHBfZWFyblBhZ2VfdG9wUGlja3Nfdmlld01vcmVfY2xpY2tcIik7XG4gICAgfSBlbHNlIHtcbiAgICAgICAgY29tbW9uLmFuYWx5dGljcyhcImFwcF9lYXJuUGFnZV9hbGxUb2tlbl9jbGlja1wiKTtcbiAgICB9XG59XG5cbm1vZHVsZUV2ZW50LnJlZnJlc2ggPSBmdW5jdGlvbiAoKSB7XG4gICAgbW9kdWxlRGF0YS5yZWZyZXNoU3RhdHVzID0gMTtcbiAgICByZXF1ZXNFYXJuSG9tZURhdGEoKTtcbn1cblxubW9kdWxlRXZlbnQuc2VhcmNoQ2xpY2sgPSBmdW5jdGlvbiAoKSB7XG4gICAgY29tbW9uLm9wZW5QYWdlV2l0aFBhdGgoXCJob2xpZ2VpdDovL29wZW4vdjE/bG9naW49MSZ1cmw9aWh1b2JpZ2xvYmFsOi8vbS5oYmcuY29tL2VkZ2VlbmdpbmUvY29udGFpbmVyP3NjZW5lPWVhcm4mcm9vdE5hbWU9c2VhcmNoY29pbiZuYXZDb25maWc9JmZyb21UeXBlPTFcIik7XG4gICAgY29tbW9uLmFuYWx5dGljcyhcImFwcF9lYXJuUGFnZV9zZWFyY2hfY2xpY2tcIik7XG5cbn1cblxubW9kdWxlRXZlbnQuaW5Db21lQ2xpY2sgPSBmdW5jdGlvbiAoKSB7XG4gICAgY29tbW9uLm9wZW5QYWdlV2l0aFBhdGgob3JpZ2luTWFpbkRhdGEuaW5jb21lLmp1bXBVcmwpO1xuICAgIGNvbW1vbi5hbmFseXRpY3MoXCJhcHBfZWFyblBhZ2VfbXlBc3NldHNfY2xpY2tcIik7XG59XG5cbm1vZHVsZUV2ZW50LmF1dG9FYXJuQ2xpY2sgPSBmdW5jdGlvbiAoKSB7XG4gICAgY29tbW9uLm9wZW5QYWdlV2l0aFBhdGgoXCIvZmluYW5jaWFsL2Vhcm4vaDUvYXV0b0ludmVzdFwiKTtcbiAgICBjb21tb24uYW5hbHl0aWNzKFwiYXBwX2Vhcm5faG9tZVBhZ2VfYXV0b0Vhcm5fY2xpY2tcIik7XG59XG5cbm1vZHVsZUV2ZW50LnByb2R1Y3RDbGljayA9IGZ1bmN0aW9uIChwYXJlbnRJbmRleCwgY2hpbGRJbmRleCkge1xuICAgIGxldCBwYXJlbnRFbGVtZW50ID0gcmVjb21tZW5kTGlzdFtwYXJlbnRJbmRleF07XG4gICAgbGV0IGNoaWxkRWxlbWVudCA9IHJlY29tbWVuZExpc3RbcGFyZW50SW5kZXhdLmxpc3RbY2hpbGRJbmRleF07XG4gICAganVtcFByb2R1Y3QoY2hpbGRFbGVtZW50LCBwYXJlbnRFbGVtZW50KTtcbn1cblxuZnVuY3Rpb24ganVtcFByb2R1Y3QoY2hpbGRFbGVtZW50LCBwYXJlbnRFbGVtZW50KSB7XG4gICAgY29tbW9uLm9wZW5QYWdlV2l0aFBhdGgoY2hpbGRFbGVtZW50Lmp1bXBVcmwpO1xuICAgIGNvbW1vbi5hbmFseXRpY3MoXCJhcHBfZWFybl9wcm9kdWN0Q2FyZF9jbGlja1wiLCB7XG4gICAgICAgIHBhZ2U6IFwiZWFybkhvbWVcIixcbiAgICAgICAgcHJvamVjdElkczogY2hpbGRFbGVtZW50LnByb2plY3RJZHMsXG4gICAgICAgIHByb2plY3RUeXBlOiBjaGlsZEVsZW1lbnQucHJvalR5cGUsXG4gICAgICAgIHRva2VuOiBwYXJlbnRFbGVtZW50LmN1cnJlbmN5LFxuICAgICAgICB0c0Jhc2VJbmZvOiBwYXJlbnRFbGVtZW50LnRzQmFzZUluZm9cbiAgICB9KTtcbn1cblxubW9kdWxlRXZlbnQuYmFubmVyQ2xpY2sgPSBmdW5jdGlvbiAoZWxlbWVudCwgaW5kZXgpIHtcbiAgICBjb21tb24ub3BlblBhZ2VXaXRoUGF0aChlbGVtZW50KTtcbiAgICAvL2Jhbm5lcueCueWHu+Wfi+eCuVxuICAgIGNvbnN0IHBhcmFtZXRlcnMgPSBiYW5uZXJBbmFseXRpY3NQYXJhbWV0ZXJzKGluZGV4KTtcbiAgICBjb21tb24uYW5hbHl0aWNzKFwiYXBwX2Vhcm5QYWdlX3Byb2R1Y3RSZWNvbW1lbmRfY2xpY2tcIiwgcGFyYW1ldGVycyk7XG59XG5cbm1vZHVsZUV2ZW50LnJlY29tbWVuZDFKdW1wID0gZnVuY3Rpb24gKCkge1xuICAgIGxldCBlbGVtZW50ID0gb3JpZ2luTWFpbkRhdGEucmVjb21tZW5kWzBdO1xuICAgIGNvbW1vbi5vcGVuUGFnZVdpdGhQYXRoKGVsZW1lbnQuanVtcFVybCk7XG4gICAgdHJ5IHtcbiAgICAgICAgY29tbW9uLmFuYWx5dGljcyhcImFwcF9lYXJuUGFnZV9wcm9kdWN0UmVjb21tZW5kX2NsaWNrXCIsIHtcbiAgICAgICAgICAgIHN0YXRlOiBcIjJcIixcbiAgICAgICAgICAgIG1hdGVyaWFsSWQ6IFwiXCIsXG4gICAgICAgICAgICBmcmFtZTogXCIxXCIsXG4gICAgICAgICAgICBwcm9qZWN0SWQ6IGVsZW1lbnQucHJvamVjdElkLFxuICAgICAgICAgICAgcHJvamVjdFR5cGU6IGVsZW1lbnQucHJvamVjdFR5cGUsXG4gICAgICAgICAgICB0b2tlbjogZWxlbWVudC5jdXJyZW5jeSxcbiAgICAgICAgICAgIHRlcm06IGVsZW1lbnQudGVybSxcbiAgICAgICAgICAgIHRzQmFzZUluZm86IGVsZW1lbnQudHNCYXNlSW5mb1xuICAgICAgICB9KTtcbiAgICB9IGNhdGNoIChlKSB7XG4gICAgICAgIGNvbnNvbGUubG9nKGByZWNvbW1lbmQxSnVtcCBlcnJvciwgZXJyb3IgPSAke2V9YCk7XG4gICAgfVxufVxuXG5tb2R1bGVFdmVudC5yZWNvbW1lbmQySnVtcCA9IGZ1bmN0aW9uICgpIHtcbiAgICBsZXQgZWxlbWVudCA9IG9yaWdpbk1haW5EYXRhLnJlY29tbWVuZFsxXTtcbiAgICBjb21tb24ub3BlblBhZ2VXaXRoUGF0aChlbGVtZW50Lmp1bXBVcmwpO1xuICAgIHRyeSB7XG4gICAgICAgIGNvbW1vbi5hbmFseXRpY3MoXCJhcHBfZWFyblBhZ2VfcHJvZHVjdFJlY29tbWVuZF9jbGlja1wiLCB7XG4gICAgICAgICAgICBzdGF0ZTogXCIyXCIsXG4gICAgICAgICAgICBtYXRlcmlhbElkOiBcIlwiLFxuICAgICAgICAgICAgZnJhbWU6IFwiMVwiLFxuICAgICAgICAgICAgcHJvamVjdElkOiBlbGVtZW50LnByb2plY3RJZCxcbiAgICAgICAgICAgIHByb2plY3RUeXBlOiBlbGVtZW50LnByb2plY3RUeXBlLFxuICAgICAgICAgICAgdG9rZW46IGVsZW1lbnQuY3VycmVuY3ksXG4gICAgICAgICAgICB0ZXJtOiBlbGVtZW50LnRlcm0sXG4gICAgICAgICAgICB0c0Jhc2VJbmZvOiBlbGVtZW50LnRzQmFzZUluZm9cbiAgICAgICAgfSk7XG4gICAgfSBjYXRjaCAoZSkge1xuICAgICAgICBjb25zb2xlLmxvZyhgcmVjb21tZW5kMUp1bXAgZXJyb3IsIGVycm9yID0gJHtlfWApO1xuICAgIH1cbn1cblxubW9kdWxlRXZlbnQubmV4dFBvcCA9IGFzeW5jIGZ1bmN0aW9uIChzdGVwKSB7XG4gICAgbW9kdWxlRGF0YS5wb3AxU2hvdyA9IFwiZmFsc2VcIjtcbiAgICBtb2R1bGVEYXRhLnBvcDJTaG93ID0gXCJmYWxzZVwiO1xuICAgIG1vZHVsZURhdGEucG9wM1Nob3cgPSBcImZhbHNlXCI7XG4gICAgbW9kdWxlRGF0YS5wb3A0U2hvdyA9IFwiZmFsc2VcIjtcbiAgICBtb2R1bGVEYXRhW2Bwb3Ake3N0ZXB9U2hvd2BdID0gXCJ0cnVlXCI7XG5cdGF3YWl0IHVwbG9hZExvZyhcIkVhcm5cIiwgYOW8leWvvCDkuIvkuIDmraUsIHN0ZXA9JHtzdGVwfWApO1xufVxuXG5tb2R1bGVFdmVudC5oaWRlUG9wID0gYXN5bmMgZnVuY3Rpb24gKCkge1xuICAgIG1vZHVsZURhdGEucG9wMVNob3cgPSBcImZhbHNlXCI7XG4gICAgbW9kdWxlRGF0YS5wb3AyU2hvdyA9IFwiZmFsc2VcIjtcbiAgICBtb2R1bGVEYXRhLnBvcDNTaG93ID0gXCJmYWxzZVwiO1xuICAgIG1vZHVsZURhdGEucG9wNFNob3cgPSBcImZhbHNlXCI7XG5cdGF3YWl0IHVwbG9hZExvZyhcIkVhcm5cIiwgYOW8leWvvCDlrozmiJBgKTtcbn1cblxubW9kdWxlRXZlbnQuYmFubmVySW5kZXhDaGFuZ2UgPSBmdW5jdGlvbiAoaW5kZXgpIHtcbiAgICAvL2Jhbm5lcuabneWFieWfi+eCuVxuICAgIGNvbnN0IHBhcmFtZXRlcnMgPSBiYW5uZXJBbmFseXRpY3NQYXJhbWV0ZXJzKGluZGV4KTtcbiAgICBjb21tb24uYW5hbHl0aWNzKFwiYXBwX2Vhcm5QYWdlX3Byb2R1Y3RSZWNvbW1lbmRfc2hvd1wiLCBwYXJhbWV0ZXJzKTtcbn1cblxuXG5mdW5jdGlvbiBiYW5uZXJBbmFseXRpY3NQYXJhbWV0ZXJzKGluZGV4KSB7XG4gICAgdHJ5IHtcbiAgICAgICAgbGV0IGVsZW1lbnQgPSBtb2R1bGVEYXRhLmJhbm5lckxpc3RbcGFyc2VJbnQoaW5kZXgpXTtcblxuICAgICAgICBsZXQgbWF0ZXJpYWxJZCA9IFwiXCI7XG4gICAgICAgIGlmIChlbGVtZW50LmFyZWFUeXBlID09IDIpIHtcbiAgICAgICAgICAgIG1hdGVyaWFsSWQgPSBlbGVtZW50LmJhbm5lci5hZHZJZDtcbiAgICAgICAgfVxuICAgICAgICBsZXQgZnJhbWUgPSBwYXJzZUludChpbmRleCkgKyAxO1xuICAgICAgICBsZXQgcHJvamVjdElkID0gXCJcIjtcbiAgICAgICAgbGV0IHByb2plY3RUeXBlID0gXCJcIjtcbiAgICAgICAgbGV0IHRva2VuID0gXCJcIjtcbiAgICAgICAgbGV0IHRlcm0gPSBcIlwiO1xuICAgICAgICBsZXQgdHNCYXNlSW5mbyA9IHt9O1xuICAgICAgICBpZiAoZWxlbWVudC5hcmVhVHlwZSA9PSAzKSB7XG4gICAgICAgICAgICBwcm9qZWN0VHlwZSA9IFwibmV3VXNlclwiO1xuICAgICAgICAgICAgaWYgKGVsZW1lbnQucHJvamVjdC50c0Jhc2VJbmZvICYmIGVsZW1lbnQucHJvamVjdC50c0Jhc2VJbmZvICE9IG51bGwpIHtcbiAgICAgICAgICAgICAgICB0c0Jhc2VJbmZvID0gZWxlbWVudC5wcm9qZWN0LnRzQmFzZUluZm8ucmF3T2JqZWN0KCk7XG4gICAgICAgICAgICB9XG4gICAgICAgIH0gZWxzZSBpZiAoZWxlbWVudC5hcmVhVHlwZSA9PSAxKSB7XG4gICAgICAgICAgICBwcm9qZWN0SWQgPSBlbGVtZW50LnByb2plY3QucHJvamVjdElkO1xuICAgICAgICAgICAgdG9rZW4gPSBlbGVtZW50LnByb2plY3QuY3VycmVuY3k7XG4gICAgICAgICAgICB0ZXJtID0gZWxlbWVudC5wcm9qZWN0LnRlcm07XG4gICAgICAgICAgICBpZiAoZWxlbWVudC5wcm9qZWN0LnRzQmFzZUluZm8gJiYgZWxlbWVudC5wcm9qZWN0LnRzQmFzZUluZm8gIT0gbnVsbCkge1xuICAgICAgICAgICAgICAgIHRzQmFzZUluZm8gPSBlbGVtZW50LnByb2plY3QudHNCYXNlSW5mby5yYXdPYmplY3QoKTtcbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIGlmIChlbGVtZW50LnByb2plY3QucHJvalR5cGUgPT0gMSkge1xuICAgICAgICAgICAgICAgIHByb2plY3RUeXBlID0gXCJmbGV4aWJsZVwiO1xuICAgICAgICAgICAgfSBlbHNlIGlmIChlbGVtZW50LnByb2plY3QucHJvalR5cGUgPT0gMikge1xuICAgICAgICAgICAgICAgIHByb2plY3RUeXBlID0gXCJmaXhlZFwiO1xuICAgICAgICAgICAgfSBlbHNlIGlmIChlbGVtZW50LnByb2plY3QucHJvalR5cGUgPT0gMykge1xuICAgICAgICAgICAgICAgIHByb2plY3RUeXBlID0gXCJmbGV4aU1heFwiO1xuICAgICAgICAgICAgfSBlbHNlIGlmIChlbGVtZW50LnByb2plY3QucHJvalR5cGUgPT0gNCkge1xuICAgICAgICAgICAgICAgIHByb2plY3RUeXBlID0gXCJzaGFya0ZpblwiO1xuICAgICAgICAgICAgfSBlbHNlIGlmIChlbGVtZW50LnByb2plY3QucHJvalR5cGVwZSA9PSA1KSB7XG4gICAgICAgICAgICAgICAgcHJvamVjdFR5cGUgPSBcImR1YWxJbnZlc3RtZW50XCI7XG4gICAgICAgICAgICB9IGVsc2UgaWYgKGVsZW1lbnQucHJvamVjdC5wcm9qVHlwZSA9PSA2KSB7XG4gICAgICAgICAgICAgICAgcHJvamVjdFR5cGUgPSBcImV0aFwiO1xuICAgICAgICAgICAgfSBlbHNlIGlmIChlbGVtZW50LnByb2plY3QucHJvalR5cGUgPT0gNykge1xuICAgICAgICAgICAgICAgIHByb2plY3RUeXBlID0gXCJyZWd1bGFySW52ZXN0XCI7XG4gICAgICAgICAgICB9XG4gICAgICAgIH1cbiAgICAgICAgcmV0dXJuIHtcbiAgICAgICAgICAgIHN0YXRlOiBcIjFcIixcbiAgICAgICAgICAgIG1hdGVyaWFsSWQ6IG1hdGVyaWFsSWQsXG4gICAgICAgICAgICBmcmFtZTogZnJhbWUsXG4gICAgICAgICAgICBwcm9qZWN0SWQ6IHByb2plY3RJZCxcbiAgICAgICAgICAgIHByb2plY3RUeXBlOiBwcm9qZWN0VHlwZSxcbiAgICAgICAgICAgIHRva2VuOiB0b2tlbixcbiAgICAgICAgICAgIHRlcm06IHRlcm0sXG4gICAgICAgICAgICB0c0Jhc2VJbmZvOiB0c0Jhc2VJbmZvXG4gICAgICAgIH07XG4gICAgfSBjYXRjaCAoZSkge1xuICAgICAgICBjb25zb2xlLmxvZyhgYmFubmVyQ2xpY2sgZXJyb3IsIGVycm9yID0gJHtlfWApO1xuICAgICAgICByZXR1cm4gbnVsbDtcbiAgICB9XG59XG5cblxuLy/ot7PovazliLDnkIbotKLorrDlvZVcbm1vZHVsZUV2ZW50LnRvUmVjb3JkID0gZnVuY3Rpb24gKCkge1xuICAgIGNvbW1vbi5vcGVuUGFnZVdpdGhQYXRoKFwiaG9saWdlaXQ6Ly9vcGVuL3YxP2xvZ2luPTEmdXJsPWlodW9iaWdsb2JhbDovL20uaGJnLmNvbS9lZGdlZW5naW5lL2NvbnRhaW5lcj9zY2VuZT1lYXJuJnJvb3ROYW1lPWludHJvZHVjZSZuYXZDb25maWc9bmF2JmluZGV4PTAmdGFiSW5kZXg9MFwiKTtcbiAgICBjb21tb24uYW5hbHl0aWNzKFwiYXBwX2Vhcm5QYWdlX0ZBUV9jbGlja1wiKTtcbn1cblxubW9kdWxlRXZlbnQuYmFja0NvbnRhaW5lciA9IGZ1bmN0aW9uICgpIHtcbiAgICBjb21tb24uY29udGFpbmVyQmFjaygpO1xuICAgIGNvbW1vbi5hbmFseXRpY3MoXCJhcHBfZWFyblBhZ2VfcmV0dXJuQnV0dG9uX2NsaWNrXCIpO1xufVxuXG5tb2R1bGVFdmVudC5jbGlja01vcmVRQSA9IGZ1bmN0aW9uICgpIHtcbiAgICBjb21tb24ub3BlblBhZ2VXaXRoUGF0aChcImhvbGlnZWl0Oi8vb3Blbi92MT9sb2dpbj0xJnVybD1paHVvYmlnbG9iYWw6Ly9tLmhiZy5jb20vZWRnZWVuZ2luZS9jb250YWluZXI/c2NlbmU9ZWFybiZyb290TmFtZT1pbnRyb2R1Y2UmbmF2Q29uZmlnPW5hdiZpbmRleD0wJnRhYkluZGV4PTBcIik7XG4gICAgY29tbW9uLmFuYWx5dGljcyhcImFwcF9lYXJuX0ZBUXNfbW9yZV9jbGlja1wiLCB7IHBhZ2U6IFwiZWFybkhvbWVcIiB9KTtcbn1cblxuYXN5bmMgZnVuY3Rpb24gdXBsb2FkTG9nKHRhZywgaW5mbyA9IFwiXCIpIHtcbiAgICBpZiAoY29tbW9uLmNvbW1vbkRhdGEuT1MgPT0gMCkge1xuICAgICAgICB2YXIgbWFwID0ge1xuICAgICAgICAgICAgdGFnOiB0YWcsXG4gICAgICAgICAgICBpbmZvOiBpbmZvXG4gICAgICAgIH07XG4gICAgICAgIGF3YWl0ICRuYXRpdmVBUEkudXBsb2FkTG9nKG1hcCk7XG4gICAgfVxufVxuIiwiaW1wb3J0ICogYXMgY29tbW9uIGZyb20gXCIuL2NvbW1vblwiO1xuXG5mdW5jdGlvbiBkZWZhdWx0RGF0YSgpIHtcbiAgICByZXR1cm4ge1xuICAgICAgICBjb2luRGF0YVJsOiBbXSxcbiAgICAgICAgY29pbkRhdGE6IFtdLC8v5biB56eN5YiX6KGoXG4gICAgICAgIHJlZnJlc2hTdGF0dXM6IDAsLy/liLfmlrDnirbmgIFcbiAgICAgICAgbG9hZE1vcmVTdGF0dXM6IDAsLy/liqDovb3nirbmgIFcbiAgICAgICAgc2VhcmNoTGlzdDogXCJcIiwvL+aQnOe0ouWOhuWPslxuICAgICAgICBzZWFyY2hJbnB1dDogXCJcIiwvL+i+k+WFpeahhuaWh+ahiFxuICAgICAgICBvbkZvY3VzOiBmYWxzZSwvL+i+k+WFpeahhueEpueCuVxuICAgICAgICBjbGVhcklucHV0VmlzOiBcImdvbmVcIiwvL+a4heepuui+k+WFpeahhlxuICAgICAgICBib3JkZXJDb2xvcjogXCJAY29sb3Iva0NvbG9yTWFqb3JUaGVtZTEwMFwiLC8v6L655qGG6aKc6ImyXG4gICAgICAgIGJhY2tWaXM6IFwidmlzaWJsZVwiLC8v6L+U5Zue5oyJ6ZKuXG4gICAgICAgIHNlYXJjaEhpc3RvcnlWaXM6IFwidmlzaWJsZVwiLC8v5pCc57Si6K6w5b2VXG4gICAgICAgIGVtcHR5RGF0YVZpczogXCJnb25lXCIsLy/nqbrmlbDmja7pobXpnaJcbiAgICAgICAgYWxsQ29pblRpdGxlVmlzOiBcInZpc2libGVcIiwvL+WFqOmDqOW4geenjeagh+mimOeKtuaAgVxuICAgICAgICBzZXJhY2hNYXJnaW5MZWZ0OiBcIjE2XCIsLy/ot53nprtcbiAgICB9O1xufVxuXG5jb25zdCB7IG1vZHVsZURhdGEsIG1vZHVsZUV2ZW50IH0gPSBjb21tb24ubW9kdWxlRGVmaW5lKFwic2VhcmNoY29pblwiLCBkZWZhdWx0RGF0YSwgeyBvbkNyZWF0ZSwgb25TdGFydCwgb25EZXN0cm95IH0pO1xuXG52YXIgcGFnZSA9IDA7Ly/ku44w5byA5aeLXG52YXIgc2l6ZSA9IDEwMDsvL+aVsOmHj1xudmFyIGlzUmVmcmVzaCA9IHRydWU7Ly/mmK/lkKbmmK/liLfmlrBcbnZhciBsYXN0RGF0YVNpemUgPSAtMTsvL+S4iuS4gOasoeaVsOaNruaVsOmHj1xudmFyIHNlYXJjaElucHV0ID0gXCJcIjsvL+aQnOe0ouahhui+k+WFpVxudmFyIHNlYXJjaGFibGUgPSB0cnVlOy8v5pCc57Si6Kem5Y+R6YC76L6RXG52YXIgc2VhcmNoSGlzdG9yeURhdGEgPSBcImVhcm5fc2VhcmNoX2hpc3RvcnlfZGF0YVwiXG52YXIgcmVxdWVzdFRpbWVvdXQgPSBudWxsO1xudmFyIGNvaW5EYXRhID0gW107XG52YXIgbmVlZE9uRm9jdXMgPSBmYWxzZTtcblxuZnVuY3Rpb24gb25DcmVhdGUoanNvblBhcmFtZXRlcnMpIHtcbiAgICBsZXQgcGFyYW1ldGVyID0gSlNPTi5wYXJzZShqc29uUGFyYW1ldGVycyk7XG4gICAgY29uc29sZS5sb2coYG9uQ3JlYXRlIC0tLS0tPiAgJHtKU09OLnN0cmluZ2lmeShwYXJhbWV0ZXIpfWApO1xuICAgIGNvbnN0IGN1cnJlbmN5ID0gcGFyYW1ldGVyLmN1cnJlbmN5O1xuICAgIGlmIChjdXJyZW5jeSAmJiBjdXJyZW5jeSAhPSBudWxsKSB7XG4gICAgICAgIHNlYXJjaElucHV0ID0gY3VycmVuY3k7XG4gICAgICAgIG1vZHVsZURhdGEuc2VhcmNoSW5wdXQgPSBjdXJyZW5jeTtcbiAgICB9XG5cbiAgICBpbml0VUkocGFyYW1ldGVyKTtcbiAgICAvL+aQnOe0ouWSjOWFqOmDqOW4geenjemhtVxuICAgIHJlcXVlc3RDb2luRGF0YSgpO1xuXG4gICAgY29tbW9uLmFuYWx5dGljcyhcImFwcF9lYXJuX2FsbFRva2VuUGFnZV92aWV3XCIpO1xufVxuXG5mdW5jdGlvbiBvblN0YXJ0KCkge1xuICAgIGlmIChuZWVkT25Gb2N1cykge1xuICAgICAgICBtb2R1bGVEYXRhLm9uRm9jdXMgPSB0cnVlO1xuICAgIH1cbiAgICBuZWVkT25Gb2N1cyA9IGZhbHNlO1xufVxuXG5mdW5jdGlvbiBpbml0VUkocGFyYW1ldGVyKSB7XG4gICAgbW9kdWxlRGF0YS5zdGF0dXNCYXJDb25maWcgPSB7IFwic3RhdHVzQmFyTW9kZVwiOiBcInRydWVcIiwgXCJhZFN0YXR1c0JhckNvbG9yXCI6IFwiS0Jhc2VDb2xvckNvbnRlbnRCYWNrZ3JvdW5kXCIsIFwic2FmZUJvdHRvbVRyYW5zcGFyZW50XCI6IFwidHJ1ZVwiIH07XG4gICAgLy/mkJzntKLpobVcbiAgICBpZiAocGFyYW1ldGVyLmZyb21UeXBlID09IDEpIHtcbiAgICAgICAgbW9kdWxlRGF0YS5iYWNrVmlzID0gXCJnb25lXCI7XG4gICAgICAgIG1vZHVsZURhdGEuYm9yZGVyQ29sb3IgPSBcIkBjb2xvci9rQ29sb3JNYWpvclRoZW1lMTAwXCI7XG4gICAgICAgIGlmIChjb21tb24uY29tbW9uRGF0YS5PUyA9PSAwKSB7XG4gICAgICAgICAgICBuZWVkT25Gb2N1cyA9IHRydWU7XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICBtb2R1bGVEYXRhLm9uRm9jdXMgPSB0cnVlO1xuICAgICAgICB9XG4gICAgICAgIG1vZHVsZURhdGEuc2VhcmNoSGlzdG9yeVZpcyA9IFwidmlzaWJsZVwiO1xuICAgICAgICBtb2R1bGVEYXRhLnNlcmFjaE1hcmdpbkxlZnQgPSBcIjE2XCI7XG4gICAgICAgIGluaXRTZWFyY2hIaXN0b3J5RGF0YSgpO1xuICAgIH0gZWxzZSBpZiAocGFyYW1ldGVyLmZyb21UeXBlID09IDIpIHtcbiAgICAgICAgLy/lhajpg6jluIHnp43pobVcbiAgICAgICAgbW9kdWxlRGF0YS5iYWNrVmlzID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgIG1vZHVsZURhdGEuYm9yZGVyQ29sb3IgPSBcIkBjb2xvci9rQ29sb3JJbnB1dEZpbGxcIjtcbiAgICAgICAgbW9kdWxlRGF0YS5vbkZvY3VzID0gZmFsc2U7XG4gICAgICAgIG1vZHVsZURhdGEuc2VhcmNoSGlzdG9yeVZpcyA9IFwiZ29uZVwiO1xuICAgICAgICBtb2R1bGVEYXRhLnNlcmFjaE1hcmdpbkxlZnQgPSBcIjBcIjtcbiAgICB9XG4gICAgLy/luIHnp43liJfooahcbiAgICBtb2R1bGVEYXRhLmNvaW5EYXRhUmwgPSBbXTtcbn1cblxuYXN5bmMgZnVuY3Rpb24gaW5pdFNlYXJjaEhpc3RvcnlEYXRhKCkge1xuICAgIHZhciBoaXN0b3J5RGF0YSA9IGF3YWl0IGdldERpc2tTZWFyY2hEYXRhKCk7XG4gICAgY29uc29sZS5sb2coYGluaXRTZWFyY2hIaXN0b3J5RGF0YSB2aXNpYmxlIDogJHtKU09OLnN0cmluZ2lmeShoaXN0b3J5RGF0YSl9YCk7XG4gICAgaWYgKGhpc3RvcnlEYXRhICYmIGhpc3RvcnlEYXRhLmxlbmd0aCA+IDApIHtcbiAgICAgICAgbW9kdWxlRGF0YS5zZWFyY2hMaXN0ID0gSlNPTi5zdHJpbmdpZnkoaGlzdG9yeURhdGEpO1xuICAgICAgICBtb2R1bGVEYXRhLnNlYXJjaEhpc3RvcnlWaXMgPSBcInZpc2libGVcIjtcbiAgICB9IGVsc2Uge1xuICAgICAgICBtb2R1bGVEYXRhLnNlYXJjaExpc3QgPSBcIlwiO1xuICAgICAgICBtb2R1bGVEYXRhLnNlYXJjaEhpc3RvcnlWaXMgPSBcImdvbmVcIjtcbiAgICB9XG59XG5cbmFzeW5jIGZ1bmN0aW9uIHJlcXVlc3RDb2luRGF0YSgpIHtcbiAgICB0cnkge1xuICAgICAgICB2YXIgcGFyYW1ldGVyID0ge1xuICAgICAgICAgICAgcGFnZTogcGFnZSxcbiAgICAgICAgICAgIHNpemU6IHNpemUsXG4gICAgICAgICAgICBjdXJyZW5jeTogc2VhcmNoSW5wdXRcbiAgICAgICAgfVxuICAgICAgICBjb25zdCBkYXRhID0gYXdhaXQgY29tbW9uLnNlbmRSZXF1ZXN0KCd2NC9zYXZpbmcvbWluaW5nL2hvbWUvY3VycmVuY3lMaXN0JywgcGFyYW1ldGVyKTtcbiAgICAgICAgaWYgKGRhdGEgIT0gbnVsbCAmJiBkYXRhLmxlbmd0aCA+IDApIHtcbiAgICAgICAgICAgIGxldCB0ZW1wSXRlbXMgPSBkYXRhO1xuICAgICAgICAgICAgbGFzdERhdGFTaXplID0gdGVtcEl0ZW1zLmxlbmd0aDtcbiAgICAgICAgICAgIHRlbXBJdGVtcy5mb3JFYWNoKChlbGVtZW50LCBpbmRleCkgPT4ge1xuICAgICAgICAgICAgICAgIGlmIChpc1JlZnJlc2gpIHtcbiAgICAgICAgICAgICAgICAgICAgZWxlbWVudC5pbmRleCA9IGluZGV4O1xuICAgICAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICAgICAgIGVsZW1lbnQuaW5kZXggPSBtb2R1bGVEYXRhLmNvaW5EYXRhLmxlbmd0aCArIGluZGV4O1xuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgICAgICBpZiAoZWxlbWVudC5ob2xkID09IG51bGwgfHwgZWxlbWVudC5ob2xkID09IFwiXCIpIHtcbiAgICAgICAgICAgICAgICAgICAgZWxlbWVudC5ob2xkID0gXCJcIjtcbiAgICAgICAgICAgICAgICAgICAgZWxlbWVudC5ob2xkVmlzID0gXCJnb25lXCI7XG4gICAgICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgICAgICAgZWxlbWVudC5ob2xkVmlzID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgIGlmIChlbGVtZW50LmFweSA9PSBudWxsKSB7XG4gICAgICAgICAgICAgICAgICAgIGVsZW1lbnQuYXB5ID0gXCJcIjtcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgZWxlbWVudC50eXBlID0gXCIxXCI7XG4gICAgICAgICAgICAgICAgZWxlbWVudC5pY29uVXJsID0gY29tbW9uLmdldFBOR0ljb25VUkxCeUN1cnJlbmN5KGVsZW1lbnQuY3VycmVuY3kpO1xuXG4gICAgICAgICAgICAgICAgaWYgKGVsZW1lbnQubGlzdCAhPSBudWxsICYmIGVsZW1lbnQubGlzdC5sZW5ndGggPT0gMSkge1xuICAgICAgICAgICAgICAgICAgICBlbGVtZW50LmV4cGFuZFN0YXR1c1JlcyA9IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX2ljb25fZWFybl9ob21lX2p1bXBcIlxuICAgICAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICAgICAgIGVsZW1lbnQuZXhwYW5kU3RhdHVzUmVzID0gXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfc3RydXR1cmVkX2Fycm93X2Rvd25cIlxuICAgICAgICAgICAgICAgIH1cblxuICAgICAgICAgICAgICAgIGVsZW1lbnQuYXB5VmlzID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgICAgICAgICAgZWxlbWVudC5jaGlsZFZpcyA9IFwiZ29uZVwiO1xuICAgICAgICAgICAgICAgIGVsZW1lbnQubGlzdE1haW5UYWdWaXMgPSBcImdvbmVcIjtcbiAgICAgICAgICAgICAgICAvL+WKoOaBr+WIuCDlpJblsYJ0YWdcbiAgICAgICAgICAgICAgICBpZiAoZWxlbWVudC50YWcgPT0gNyAmJlxuICAgICAgICAgICAgICAgICAgICBlbGVtZW50LnRhZ0FweSAhPSBudWxsICYmXG4gICAgICAgICAgICAgICAgICAgIGVsZW1lbnQudGFnQXB5ICE9IFwiXCIgJiZcbiAgICAgICAgICAgICAgICAgICAgZWxlbWVudC5jaGlsZFZpcyA9PSBcImdvbmVcIikge1xuICAgICAgICAgICAgICAgICAgICBlbGVtZW50LmNvdXBvblZpcyA9IFwidmlzaWJsZVwiXG4gICAgICAgICAgICAgICAgICAgIGVsZW1lbnQuY291cG9uVmFsdWUgPSBlbGVtZW50LnRhZ0FweVxuICAgICAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICAgICAgIGVsZW1lbnQuY291cG9uVmlzID0gXCJnb25lXCJcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgLy/orr7nva4gdmlwIOWSjCBsYXVuY2hlclBvb2wg5pWw5o2uXG4gICAgICAgICAgICAgICAgaWYgKGVsZW1lbnQudGFnID09IDggfHwgZWxlbWVudC50YWcgPT0gOSkge1xuICAgICAgICAgICAgICAgICAgICBlbGVtZW50Lmljb25TcmMgPSBnZXRUYWdJY29uQnlUeXBlKGVsZW1lbnQudGFnKTtcbiAgICAgICAgICAgICAgICAgICAgaWYgKGVsZW1lbnQuY2hpbGRWaXMgPT0gXCJnb25lXCIpIHtcbiAgICAgICAgICAgICAgICAgICAgICAgIGVsZW1lbnQuaWNvblZpcyA9IFwidmlzaWJsZVwiO1xuICAgICAgICAgICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgICAgICAgICAgZWxlbWVudC5pY29uVmlzID0gXCJnb25lXCI7XG4gICAgICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgICAgICB9IGVsc2UgaWYgKGVsZW1lbnQudGFnID09IDExKSB7XG4gICAgICAgICAgICAgICAgICAgIGVsZW1lbnQubGlzdE1haW5UYWdWaXMgPSBcInZpc2libGVcIjtcbiAgICAgICAgICAgICAgICAgICAgZWxlbWVudC50YWdCZyA9IGdldFRhZ0JnQnlUeXBlKGVsZW1lbnQudGFnKTtcbiAgICAgICAgICAgICAgICAgICAgZWxlbWVudC50YWdUZXh0Q29sb3IgPSBnZXRUYWdUZXh0Q29sb3JCeVR5cGUoZWxlbWVudC50YWcpO1xuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgICAgICBpZiAoZWxlbWVudC5saXN0ICE9IG51bGwpIHtcbiAgICAgICAgICAgICAgICAgICAgbGV0IHRlbXBDaGlsZCA9IGVsZW1lbnQubGlzdDtcbiAgICAgICAgICAgICAgICAgICAgdGVtcENoaWxkLmZvckVhY2goKGNoaWxkRWxlbWVudCwgaW5kZXgpID0+IHtcbiAgICAgICAgICAgICAgICAgICAgICAgIGNoaWxkRWxlbWVudC50eXBlID0gXCIxXCI7XG4gICAgICAgICAgICAgICAgICAgICAgICBjaGlsZEVsZW1lbnQuaW5kZXggPSBpbmRleDtcbiAgICAgICAgICAgICAgICAgICAgICAgIGNoaWxkRWxlbWVudC5jb3Vwb25WaXMgPSBcImdvbmVcIlxuICAgICAgICAgICAgICAgICAgICAgICAgY2hpbGRFbGVtZW50LnRhZ1ZpcyA9IFwiZ29uZVwiO1xuICAgICAgICAgICAgICAgICAgICAgICAgY2hpbGRFbGVtZW50LnZpcEljb25WaXMgPSBcImdvbmVcIlxuICAgICAgICAgICAgICAgICAgICAgICAgY2hpbGRFbGVtZW50LmVhcm5WaXBWaXMgPSBcImdvbmVcIlxuXG4gICAgICAgICAgICAgICAgICAgICAgICBpZiAoY2hpbGRFbGVtZW50LmFweSA9PSBudWxsKSB7XG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgY2hpbGRFbGVtZW50LmFweSA9IFwiXCI7XG4gICAgICAgICAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgICAgICAgICBpZiAoY2hpbGRFbGVtZW50LnRhZyAhPSAwICYmIGNoaWxkRWxlbWVudC50YWcgIT0gbnVsbCkge1xuICAgICAgICAgICAgICAgICAgICAgICAgICAgIC8v5Yqg5oGv5Yi4XG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgaWYgKGNoaWxkRWxlbWVudC50YWcgPT0gNykge1xuICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICBpZiAoY2hpbGRFbGVtZW50LnRhZ0FweSAhPSBudWxsICYmIGNoaWxkRWxlbWVudC50YWdBcHkgIT0gXCJcIikge1xuICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgY2hpbGRFbGVtZW50LmNvdXBvblZpcyA9IFwidmlzaWJsZVwiXG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICBjaGlsZEVsZW1lbnQuY291cG9uVmFsdWUgPSBjaGlsZEVsZW1lbnQudGFnQXB5XG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIH0gXG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgfSBlbHNlIGlmIChjaGlsZEVsZW1lbnQudGFnID09IDgpIHtcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgLy92aXBcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgY2hpbGRFbGVtZW50Lmljb25TcmMgPSBnZXRUYWdJY29uQnlUeXBlKGNoaWxkRWxlbWVudC50YWcpO1xuICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICBjaGlsZEVsZW1lbnQuZWFyblZpcFZpcyA9IFwidmlzaWJsZVwiXG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIGNoaWxkRWxlbWVudC52aXBJY29uVmlzID0gXCJ2aXNpYmxlXCJcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICB9IGVsc2UgaWYgKGNoaWxkRWxlbWVudC50YWcgPT0gOSkge1xuICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAvL0xhdW5jaFBvb2zmoIfnrb5cbiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgY2hpbGRFbGVtZW50Lmljb25TcmMgPSBnZXRUYWdJY29uQnlUeXBlKGNoaWxkRWxlbWVudC50YWcpO1xuICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICBjaGlsZEVsZW1lbnQudmlwSWNvblZpcyA9IFwidmlzaWJsZVwiO1xuICAgICAgICAgICAgICAgICAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIGNoaWxkRWxlbWVudC50YWdWaXMgPSBcInZpc2libGVcIjtcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgY2hpbGRFbGVtZW50LnRhZ0JnID0gZ2V0VGFnQmdCeVR5cGUoY2hpbGRFbGVtZW50LnRhZyk7XG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIGNoaWxkRWxlbWVudC50YWdUZXh0Q29sb3IgPSBnZXRUYWdUZXh0Q29sb3JCeVR5cGUoY2hpbGRFbGVtZW50LnRhZyk7XG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgICAgICB9KTtcbiAgICAgICAgICAgICAgICAgICAgZWxlbWVudC5saXN0ID0gdGVtcENoaWxkO1xuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgIH0pO1xuICAgICAgICAgICAgaWYgKGlzUmVmcmVzaCkge1xuICAgICAgICAgICAgICAgIG1vZHVsZURhdGEuY29pbkRhdGEgPSB0ZW1wSXRlbXM7XG4gICAgICAgICAgICAgICAgY29pbkRhdGEgPSB0ZW1wSXRlbXM7XG4gICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgIHRlbXBJdGVtcy5mb3JFYWNoKGVsZW1lbnQyMCA9PiB7XG4gICAgICAgICAgICAgICAgICAgIG1vZHVsZURhdGEuY29pbkRhdGEucHVzaChlbGVtZW50MjApO1xuICAgICAgICAgICAgICAgIH0pO1xuICAgICAgICAgICAgICAgIGNvaW5EYXRhLnB1c2goLi4udGVtcEl0ZW1zKTtcbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIGNvaW5BbmFseXRpY3ModGVtcEl0ZW1zKTtcbiAgICAgICAgICAgIGNvbnNvbGUubG9nKGByZXF1ZXN0Q29pbkRhdGEgLS0tLS0+ICAke0pTT04uc3RyaW5naWZ5KG1vZHVsZURhdGEuY29pbkRhdGEucmF3QXJyYXkoKSl9YCk7XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICBsYXN0RGF0YVNpemUgPSAtMTtcbiAgICAgICAgICAgIGlmIChpc1JlZnJlc2gpIHtcbiAgICAgICAgICAgICAgICBtb2R1bGVEYXRhLmNvaW5EYXRhID0gW107XG4gICAgICAgICAgICB9XG4gICAgICAgIH1cbiAgICAgICAgaWYgKG1vZHVsZURhdGEuY29pbkRhdGEgJiYgbW9kdWxlRGF0YS5jb2luRGF0YS5sZW5ndGggPiAwKSB7XG4gICAgICAgICAgICBtb2R1bGVEYXRhLmVtcHR5RGF0YVZpcyA9IFwiZ29uZVwiXG4gICAgICAgICAgICBtb2R1bGVEYXRhLmFsbENvaW5UaXRsZVZpcyA9IFwidmlzaWJsZVwiXG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICBtb2R1bGVEYXRhLmVtcHR5RGF0YVZpcyA9IFwidmlzaWJsZVwiXG4gICAgICAgICAgICBtb2R1bGVEYXRhLmFsbENvaW5UaXRsZVZpcyA9IFwiZ29uZVwiXG4gICAgICAgIH1cbiAgICB9IGNhdGNoIChlKSB7XG4gICAgICAgIGNvbnNvbGUubG9nKGByZXF1ZXN0Q29pbkRhdGEgZXJyb3IsIGVycm9yID0gJHtlfWApO1xuICAgIH1cbiAgICBtb2R1bGVEYXRhLnJlZnJlc2hTdGF0dXMgPSAyO1xuICAgIG1vZHVsZURhdGEubG9hZE1vcmVTdGF0dXMgPSAyO1xufVxuXG5mdW5jdGlvbiBjb2luQW5hbHl0aWNzKGNvaW5MaXN0KSB7XG4gICAgY29pbkxpc3QuZm9yRWFjaCgoZWxlbWVudCwgaW5kZXgpID0+IHtcbiAgICAgICAgY29tbW9uLmFuYWx5dGljcyhcImFwcF9lYXJuX3Rva2VuQ2FyZF9zaG93XCIsIHtcbiAgICAgICAgICAgIHBhZ2U6IFwiYWxsVG9rZW5cIixcbiAgICAgICAgICAgIHRva2VuOiBlbGVtZW50LmN1cnJlbmN5LFxuICAgICAgICAgICAgdHNCYXNlSW5mbzogZWxlbWVudC50c0Jhc2VJbmZvXG4gICAgICAgIH0pO1xuICAgIH0pO1xufVxuXG4vKipcbiAqIOagueaNrnRhZ+iOt+WPluWvueW6lGljb25cbiAqIDgtdmlw77ybOS1sYXVuY2hlclBvb2xcbiAqL1xuZnVuY3Rpb24gZ2V0VGFnSWNvbkJ5VHlwZSh0eXBlKXtcbiAgICBpZiAodHlwZSA9PSA5KSB7XG4gICAgICByZXR1cm4gXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfZWFybl9sYXVuY2hlcl9wb29sX2ljb25cIjtcbiAgICB9IGVsc2Uge1xuICAgICAgcmV0dXJuICRkYXRhLmhvbWUudmlwSWNvbjtcbiAgICB9XG59XG5cbmZ1bmN0aW9uIGdldFRhZ0JnQnlUeXBlKHR5cGUpIHtcbiAgICBpZiAodHlwZSA9PSAwKSB7XG4gICAgICAgIHJldHVybiBudWxsO1xuICAgIH0gZWxzZSBpZiAodHlwZSA9PSAxKSB7XG4gICAgICAgIHJldHVybiBcIkBjb2xvci9LQ29sb3IxMjAwQTE3MVwiXG4gICAgfSBlbHNlIGlmICh0eXBlID09IDIpIHtcbiAgICAgICAgcmV0dXJuIFwiQGNvbG9yL0tDb2xvcjEyMDBBMTcxXCJcbiAgICB9IGVsc2UgaWYgKHR5cGUgPT0gMykge1xuICAgICAgICByZXR1cm4gXCJAY29sb3Iva0NvbG9yMTkwMEExNzFcIlxuICAgIH0gZWxzZSBpZiAodHlwZSA9PSA0KSB7XG4gICAgICAgIHJldHVybiBcIkBjb2xvci9LQ29sb3IxMkZFODczMVwiXG4gICAgfSBlbHNlIGlmICh0eXBlID09IDUpIHtcbiAgICAgICAgcmV0dXJuIFwiQGNvbG9yL2tDb2xvcklucHV0RmlsbFwiXG4gICAgfSBlbHNlIGlmICh0eXBlID09IDYpIHtcbiAgICAgICAgcmV0dXJuIFwiQGNvbG9yL0tDb2xvcjEyRkU4NzMxXCJcbiAgICB9IGVsc2UgaWYgKHR5cGUgPT0gMTAxKSB7XG4gICAgICAgIHJldHVybiBcIkBjb2xvci9rQ29sb3JTZWNvbmRhcnlUZXh0XCJcbiAgICB9IGVsc2UgaWYgKHR5cGUgPT0gMTEpIHtcbiAgICAgICAgcmV0dXJuIFwiQGNvbG9yL2tDb2xvcjFBMDE3M0U1XCJcbiAgICB9XG59XG5cbmZ1bmN0aW9uIGdldFRhZ1RleHRDb2xvckJ5VHlwZSh0eXBlKSB7XG4gICAgaWYgKHR5cGUgPT0gMCkge1xuICAgICAgICByZXR1cm4gbnVsbDtcbiAgICB9IGVsc2UgaWYgKHR5cGUgPT0gMSkge1xuICAgICAgICByZXR1cm4gXCJAY29sb3IvS0Jhc2VSaXNrVGV4dENvbG9yTG93XCJcbiAgICB9IGVsc2UgaWYgKHR5cGUgPT0gMikge1xuICAgICAgICByZXR1cm4gXCJAY29sb3IvS0Jhc2VSaXNrVGV4dENvbG9yTG93XCJcbiAgICB9IGVsc2UgaWYgKHR5cGUgPT0gMykge1xuICAgICAgICByZXR1cm4gXCJAY29sb3Iva0NvbG9yUHJpY2VHcmVlblwiXG4gICAgfSBlbHNlIGlmICh0eXBlID09IDQpIHtcbiAgICAgICAgcmV0dXJuIFwiQGNvbG9yL0tCYXNlUmlza1RleHRDb2xvck1pZFwiXG4gICAgfSBlbHNlIGlmICh0eXBlID09IDUpIHtcbiAgICAgICAgcmV0dXJuIFwiQGNvbG9yL2tDb2xvclNlY29uZGFyeVRleHRcIlxuICAgIH0gZWxzZSBpZiAodHlwZSA9PSA2KSB7XG4gICAgICAgIHJldHVybiBcIkBjb2xvci9LQmFzZVJpc2tUZXh0Q29sb3JNaWRcIlxuICAgIH0gZWxzZSBpZiAodHlwZSA9PSAxMDEpIHtcbiAgICAgICAgcmV0dXJuIFwiQGNvbG9yL2tDb2xvclNlY29uZGFyeVRleHRcIlxuICAgIH0gZWxzZSBpZiAodHlwZSA9PSAxMSkge1xuICAgICAgICByZXR1cm4gXCJAY29sb3Iva0NvbG9yTWFqb3JUaGVtZTEwMFwiXG4gICAgfVxufVxuXG5tb2R1bGVFdmVudC5pdGVtQ2xpY2sgPSBmdW5jdGlvbiAoaW5kZXgpIHtcbiAgICAvLyBsZXQgdGVtcEVsZW1lbnQgPSBtb2R1bGVEYXRhLmNvaW5EYXRhW2luZGV4XTtcbiAgICBsZXQgdGVtcEVsZW1lbnQgPSBjb2luRGF0YVtpbmRleF1cbiAgICBsZXQgb3BlcmF0aW9uVHlwZSA9IFwidW5mb2xkXCI7XG4gICAgLy8yMDI0LzEwLzE154mI5pys5paw5aKeIOWmguaenOWNleS6p+WTgeebtOaOpei/m+WFpeeUs+i0remhtemdolxuICAgIGlmICh0ZW1wRWxlbWVudC5saXN0ICE9IG51bGwgJiYgdGVtcEVsZW1lbnQubGlzdC5sZW5ndGggPT0gMSkge1xuICAgICAgICBsZXQgY2hpbGRFbGVtZW50ID0gdGVtcEVsZW1lbnQubGlzdFswXTtcbiAgICAgICAganVtcFByb2R1Y3QoY2hpbGRFbGVtZW50LCB0ZW1wRWxlbWVudCk7XG4gICAgICAgIGNvbW1vbi5hbmFseXRpY3MoXCJhcHBfZWFybl9wcm9kdWN0Q2FyZF9zaG93XCIsIHtcbiAgICAgICAgICAgIHBhZ2U6IFwiZWFybkhvbWVcIixcbiAgICAgICAgICAgIHByb2plY3RJZHM6IGNoaWxkRWxlbWVudC5wcm9qZWN0SWRzLFxuICAgICAgICAgICAgcHJvamVjdFR5cGU6IGNoaWxkRWxlbWVudC5wcm9qVHlwZSxcbiAgICAgICAgICAgIHRva2VuOiB0ZW1wRWxlbWVudC5jdXJyZW5jeSxcbiAgICAgICAgICAgIHRzQmFzZUluZm86IHRlbXBFbGVtZW50LnRzQmFzZUluZm9cbiAgICAgICAgfSk7XG4gICAgfSBlbHNlIHtcblxuICAgICAgICBpZiAodGVtcEVsZW1lbnQubGlzdE1haW5UYWdWaXMgPT0gXCJ2aXNpYmxlXCIpIHtcbiAgICAgICAgICAgIHRlbXBFbGVtZW50Lmxpc3RNYWluVGFnVmlzID0gXCJnb25lXCI7XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICBpZiAodGVtcEVsZW1lbnQudGFnID09IDExKSB7XG4gICAgICAgICAgICAgICAgdGVtcEVsZW1lbnQubGlzdE1haW5UYWdWaXMgPSBcInZpc2libGVcIjtcbiAgICAgICAgICAgIH1cbiAgICAgICAgfVxuICAgICAgICBpZiAodGVtcEVsZW1lbnQuY2hpbGRWaXMgPT0gXCJnb25lXCIpIHtcbiAgICAgICAgICAgIHRlbXBFbGVtZW50LmNoaWxkVmlzID0gXCJ2aXNpYmxlXCJcbiAgICAgICAgICAgIHRlbXBFbGVtZW50LmFweVZpcyA9IFwiZ29uZVwiO1xuICAgICAgICAgICAgLy/pmpDol4/liqDmga/liLhcbiAgICAgICAgICAgIHRlbXBFbGVtZW50LmNvdXBvblZpcyA9IFwiZ29uZVwiXG4gICAgICAgICAgICAvL+makOiXj3ZpcOWSjGxhdW5jaGVyUG9vbFxuICAgICAgICAgICAgdGVtcEVsZW1lbnQuaWNvblZpcyA9IFwiZ29uZVwiO1xuICAgICAgICAgICAgdGVtcEVsZW1lbnQuZXhwYW5kU3RhdHVzUmVzID0gXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfc3RydXR1cmVkX2Fycm93X3VwXCJcbiAgICAgICAgICAgIG9wZXJhdGlvblR5cGUgPSBcInVuZm9sZFwiO1xuXG4gICAgICAgICAgICAvLyBsZXQgYW5hbHl0aWNzTGlzdCA9IGNvaW5EYXRhW2luZGV4XS5saXN0O1xuICAgICAgICAgICAgbGV0IHByb2R1Y3RMaXN0ID0gdGVtcEVsZW1lbnQubGlzdDtcbiAgICAgICAgICAgIHByb2R1Y3RMaXN0LmZvckVhY2goKGNoaWxkRWxlbWVudCwgaW5kZXgpID0+IHtcbiAgICAgICAgICAgICAgICBjb21tb24uYW5hbHl0aWNzKFwiYXBwX2Vhcm5fcHJvZHVjdENhcmRfc2hvd1wiLCB7XG4gICAgICAgICAgICAgICAgICAgIHBhZ2U6IFwiYWxsVG9rZW5cIixcbiAgICAgICAgICAgICAgICAgICAgcHJvamVjdElkczogY2hpbGRFbGVtZW50LnByb2plY3RJZHMsXG4gICAgICAgICAgICAgICAgICAgIHByb2plY3RUeXBlOiBjaGlsZEVsZW1lbnQucHJvalR5cGUsXG4gICAgICAgICAgICAgICAgICAgIHRva2VuOiB0ZW1wRWxlbWVudC5jdXJyZW5jeSxcbiAgICAgICAgICAgICAgICAgICAgdHNCYXNlSW5mbzogdGVtcEVsZW1lbnQudHNCYXNlSW5mb1xuICAgICAgICAgICAgICAgIH0pO1xuICAgICAgICAgICAgfSk7XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICB0ZW1wRWxlbWVudC5jaGlsZFZpcyA9IFwiZ29uZVwiXG4gICAgICAgICAgICB0ZW1wRWxlbWVudC5hcHlWaXMgPSBcInZpc2libGVcIjtcbiAgICAgICAgICAgIC8v5Yqg5oGv5Yi4XG4gICAgICAgICAgICBpZiAodGVtcEVsZW1lbnQudGFnID09IDcgJiYgdGVtcEVsZW1lbnQudGFnQXB5ICE9IG51bGwgJiYgdGVtcEVsZW1lbnQudGFnQXB5ICE9IFwiXCIpIHtcbiAgICAgICAgICAgICAgICB0ZW1wRWxlbWVudC5jb3Vwb25WaXMgPSBcInZpc2libGVcIlxuICAgICAgICAgICAgICAgIHRlbXBFbGVtZW50LmNvdXBvblZhbHVlID0gdGVtcEVsZW1lbnQudGFnQXB5XG4gICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgIHRlbXBFbGVtZW50LmNvdXBvblZpcyA9IFwiZ29uZVwiXG4gICAgICAgICAgICB9XG4gICAgICAgICAgICAvL+WxleekuiB2aXAg5ZKMIGxhdW5jaGVyUG9vbFxuICAgICAgICAgICAgaWYgKHRlbXBFbGVtZW50LnRhZyA9PSA4IHx8IHRlbXBFbGVtZW50LnRhZyA9PSA5KSB7XG4gICAgICAgICAgICAgICAgdGVtcEVsZW1lbnQuaWNvblZpcyA9IFwidmlzaWJsZVwiO1xuICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgICB0ZW1wRWxlbWVudC5pY29uVmlzID0gXCJnb25lXCI7XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICB0ZW1wRWxlbWVudC5leHBhbmRTdGF0dXNSZXMgPSBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9zdHJ1dHVyZWRfYXJyb3dfZG93blwiXG4gICAgICAgICAgICBvcGVyYXRpb25UeXBlID0gXCJmb2xkXCI7XG4gICAgICAgIH1cbiAgICAgICAgc2F2ZUl0ZW0yRGlzayh0ZW1wRWxlbWVudC5jdXJyZW5jeSk7XG5cbiAgICAgICAgY29tbW9uLmFuYWx5dGljcyhcImFwcF9lYXJuX3Rva2VuQ2FyZF9jbGlja1wiLCB7XG4gICAgICAgICAgICBwYWdlOiBcImFsbFRva2VuXCIsXG4gICAgICAgICAgICB0b2tlbjogdGVtcEVsZW1lbnQuY3VycmVuY3ksXG4gICAgICAgICAgICBvcGVyYXRpb25UeXBlOiBvcGVyYXRpb25UeXBlLFxuICAgICAgICAgICAgdHNCYXNlSW5mbzogdGVtcEVsZW1lbnQudHNCYXNlSW5mb1xuICAgICAgICB9KTtcblxuICAgICAgICBtb2R1bGVEYXRhLmNvaW5EYXRhW2luZGV4XSA9IHRlbXBFbGVtZW50XG4gICAgfVxufVxuXG5hc3luYyBmdW5jdGlvbiBzYXZlSXRlbTJEaXNrKGtleXdvcmQpIHtcbiAgICBpZiAoc2VhcmNoSW5wdXQgPT0gXCJcIiB8fCBzZWFyY2hJbnB1dCA9PSBudWxsKSB7XG4gICAgICAgIC8v5LiN5piv5pCc57Si57uT5p6c6aG1IOebtOaOpXJldHVyblxuICAgICAgICByZXR1cm47XG4gICAgfVxuICAgIC8v5Li05pe25pWw57uEXG4gICAgdmFyIHNhdmVMaXN0ID0gW107XG4gICAgLy/mnKzlnLDlrZjlgqjmlbDnu4RcbiAgICB2YXIgZGlza0RhdGEgPSBhd2FpdCBnZXREaXNrU2VhcmNoRGF0YSgpO1xuICAgIGNvbnNvbGUubG9nKGDlj5blh7rnmoTmnKzlnLDmlbDmja4gOiAke0pTT04uc3RyaW5naWZ5KGRpc2tEYXRhKX1gKTtcbiAgICAvL+aYr+WQpuaYr+aQnOe0oue7k+aenOWQjOaXtuacrOWcsOWwmuacquWtmOWCqFxuICAgIGlmIChkaXNrRGF0YS5pbmRleE9mKGtleXdvcmQpID09IC0xKSB7XG4gICAgICAgIC8v5a2Y5YKo5pys5qyh5pCc57Si57uT5p6cXG4gICAgICAgIHNhdmVMaXN0LnB1c2goa2V5d29yZCk7XG4gICAgICAgIGlmIChkaXNrRGF0YS5sZW5ndGggPiAxMCkge1xuICAgICAgICAgICAgZGlza0RhdGEuc3BsaWNlKGRpc2tEYXRhLmxlbmd0aCAtIDEsIDEpO1xuICAgICAgICB9XG4gICAgICAgIC8v5a2Y5YKo5Y6G5Y+y5pCc57Si57uT5p6cXG4gICAgICAgIHNhdmVMaXN0LnB1c2goLi4uZGlza0RhdGEpO1xuICAgICAgICAvL+WtmOWCqOWIsOacrOWcsFxuICAgICAgICBjb25zb2xlLmxvZyhgY2FjaGVIc2l0b3J5IHNhdmVJdGVtMkRpc2sg5bCG6KaB5a2Y5YKo55qE5pWw5o2uIDogJHtKU09OLnN0cmluZ2lmeShzYXZlTGlzdCl9YCk7XG4gICAgICAgIGF3YWl0ICRuYXRpdmVBUEkuc3RvcmFnZSh7XG4gICAgICAgICAgICBhY3Rpb246IFwic2F2ZVwiLFxuICAgICAgICAgICAgbmFtZTogXCJlYXJuXCIsXG4gICAgICAgICAgICBrZXk6IHNlYXJjaEhpc3RvcnlEYXRhLFxuICAgICAgICAgICAgZGF0YTogSlNPTi5zdHJpbmdpZnkoc2F2ZUxpc3QpXG4gICAgICAgIH0pXG4gICAgfSBlbHNlIHtcbiAgICAgICAgZGlza0RhdGEgPSBkaXNrRGF0YS5maWx0ZXIoZnVuY3Rpb24gKGl0ZW0pIHtcbiAgICAgICAgICAgIHJldHVybiBpdGVtICE9PSBrZXl3b3JkXG4gICAgICAgIH0pO1xuICAgICAgICAvL+WtmOWCqOacrOasoeaQnOe0oue7k+aenFxuICAgICAgICBzYXZlTGlzdC5wdXNoKGtleXdvcmQpO1xuICAgICAgICAvL+WtmOWCqOWOhuWPsuaQnOe0oue7k+aenFxuICAgICAgICBzYXZlTGlzdC5wdXNoKC4uLmRpc2tEYXRhKTtcbiAgICAgICAgLy/lrZjlgqjliLDmnKzlnLBcbiAgICAgICAgY29uc29sZS5sb2coYGNhY2hlSHNpdG9yeSBzYXZlSXRlbTJEaXNrIOWwhuimgeWtmOWCqOeahOaVsOaNriA6ICR7SlNPTi5zdHJpbmdpZnkoc2F2ZUxpc3QpfWApO1xuICAgICAgICBhd2FpdCAkbmF0aXZlQVBJLnN0b3JhZ2Uoe1xuICAgICAgICAgICAgYWN0aW9uOiBcInNhdmVcIixcbiAgICAgICAgICAgIG5hbWU6IFwiZWFyblwiLFxuICAgICAgICAgICAga2V5OiBzZWFyY2hIaXN0b3J5RGF0YSxcbiAgICAgICAgICAgIGRhdGE6IEpTT04uc3RyaW5naWZ5KHNhdmVMaXN0KVxuICAgICAgICB9KVxuICAgIH1cblxufVxuXG5hc3luYyBmdW5jdGlvbiBnZXREaXNrU2VhcmNoRGF0YSgpIHtcbiAgICB2YXIgZGF0YSA9IGF3YWl0ICRuYXRpdmVBUEkuc3RvcmFnZSh7XG4gICAgICAgIGFjdGlvbjogXCJyZWFkXCIsXG4gICAgICAgIG5hbWU6IFwiZWFyblwiLFxuICAgICAgICBrZXk6IHNlYXJjaEhpc3RvcnlEYXRhXG4gICAgfSlcbiAgICB0cnkge1xuICAgICAgICBpZiAoZGF0YSAmJiBkYXRhICE9IFwiXCIpIHtcbiAgICAgICAgICAgIHJldHVybiBKU09OLnBhcnNlKGRhdGEpO1xuICAgICAgICB9XG4gICAgICAgIHJldHVybiBbXTtcbiAgICB9IGNhdGNoIChlKSB7XG4gICAgICAgIGNvbnNvbGUubG9nKGBnZXREaXNrU2VhcmNoRGF0YSBlcnJvciwgZXJyb3IgPSAke2V9YCk7XG4gICAgICAgIHJldHVybiBbXTtcbiAgICB9XG59XG5cbm1vZHVsZUV2ZW50LnJlZnJlc2ggPSBmdW5jdGlvbiAoKSB7XG4gICAgbW9kdWxlRGF0YS5yZWZyZXNoU3RhdHVzID0gMTtcbiAgICBwYWdlID0gMDtcbiAgICBpc1JlZnJlc2ggPSB0cnVlO1xuICAgIHJlcXVlc3RDb2luRGF0YSgpO1xufVxuXG5tb2R1bGVFdmVudC5sb2FkTW9yZSA9IGZ1bmN0aW9uICgpIHtcbiAgICAvLyBpZiAobGFzdERhdGFTaXplID49IHNpemUpIHtcbiAgICAvLyAgICAgbW9kdWxlRGF0YS5sb2FkTW9yZVN0YXR1cyA9IDE7XG4gICAgLy8gICAgIHBhZ2UgPSBwYWdlICsgMTtcbiAgICAvLyAgICAgaXNSZWZyZXNoID0gZmFsc2U7XG4gICAgLy8gICAgIHJlcXVlc3RDb2luRGF0YSgpO1xuICAgIC8vIH0gZWxzZSB7XG4gICAgLy8gICAgIG1vZHVsZURhdGEubG9hZE1vcmVTdGF0dXMgPSAyO1xuICAgIC8vIH1cbn1cblxubW9kdWxlRXZlbnQuaGlzdG9yeUNsaWNrID0gZnVuY3Rpb24gKGNsaWNrU3RyKSB7XG4gICAgY29uc29sZS5sb2coYG1vZHVsZUV2ZW50IGhpc3RvcnlDbGljayAgJHtjbGlja1N0cn1gKTtcbiAgICBtb2R1bGVEYXRhLnNlYXJjaElucHV0ID0gY2xpY2tTdHI7XG4gICAgaWYgKGNvbW1vbi5jb21tb25EYXRhLk9TID09IDApIHtcbiAgICAgICAgbW9kdWxlRXZlbnQudGV4dENoYW5nZShjbGlja1N0cik7XG4gICAgfVxuXG4gICAgY29tbW9uLmFuYWx5dGljcyhcImFwcF9lYXJuX2FsbFRva2VuUGFnZV9zZWFyY2hIaXN0b3J5X2NsaWNrXCIpO1xufVxuXG5tb2R1bGVFdmVudC5vblJldHVybiA9IGZ1bmN0aW9uIChwYXJhbWV0ZXIpIHtcbiAgICBtb2R1bGVEYXRhLm9uRm9jdXMgPSBmYWxzZTtcbn1cblxubW9kdWxlRXZlbnQudGV4dENoYW5nZSA9IGZ1bmN0aW9uIChwYXJhbWV0ZXIpIHtcbiAgICBjb25zb2xlLmxvZyhgdGV4dENoYW5nZSAtLS0tLT4gICR7cGFyYW1ldGVyfWApO1xuICAgIHNlYXJjaElucHV0ID0gcGFyYW1ldGVyO1xuICAgIGlmIChzZWFyY2hJbnB1dCA9PSBcIlwiKSB7XG4gICAgICAgIG1vZHVsZURhdGEuY2xlYXJJbnB1dFZpcyA9IFwiZ29uZVwiO1xuICAgIH0gZWxzZSB7XG4gICAgICAgIG1vZHVsZURhdGEuY2xlYXJJbnB1dFZpcyA9IFwidmlzaWJsZVwiO1xuICAgIH1cbiAgICB0cnkge1xuICAgICAgICAvLyBjb25zb2xlLmxvZyhgIC0tLS0tPiAke3JlcXVlc3RUaW1lb3V0fWApO1xuICAgICAgICAvLyBpZiAocmVxdWVzdFRpbWVvdXQgIT0gbnVsbCkge1xuICAgICAgICAvLyAgICAgY29uc29sZS5sb2coYOWPlua2iOivt+axgiAtLS0tLT5gKTtcbiAgICAgICAgLy8gICAgIGNsZWFyVGltZW91dChyZXF1ZXN0VGltZW91dCk7XG4gICAgICAgIC8vICAgICByZXF1ZXN0VGltZW91dCA9IG51bGw7XG4gICAgICAgIC8vIH1cbiAgICAgICAgcmVxdWVzdFRpbWVvdXQgPSBzZXRUaW1lb3V0KCgpID0+IHtcbiAgICAgICAgICAgIGNvbnNvbGUubG9nKGDlu7bov5/or7fmsYIgLS0tLS0+YCk7XG4gICAgICAgICAgICBwYWdlID0gMDtcbiAgICAgICAgICAgIGlzUmVmcmVzaCA9IHRydWU7XG4gICAgICAgICAgICByZXF1ZXN0Q29pbkRhdGEoKTtcbiAgICAgICAgfSwgNTAwKTtcbiAgICAgICAgY29uc29sZS5sb2coYCAtLS0tLT4gJHtyZXF1ZXN0VGltZW91dH1gKTtcbiAgICB9IGNhdGNoIChlKSB7XG4gICAgICAgIGNvbnNvbGUubG9nKGBlcnJvciwgZXJyb3IgPSAke2V9YCk7XG4gICAgfVxufVxuXG5tb2R1bGVFdmVudC5mb2N1c0NoYW5nZSA9IGZ1bmN0aW9uIChwYXJhbWV0ZXIpIHtcbiAgICBpZiAocGFyYW1ldGVyKSB7XG4gICAgICAgIG1vZHVsZURhdGEuYm9yZGVyQ29sb3IgPSBcIkBjb2xvci9rQ29sb3JNYWpvclRoZW1lMTAwXCI7XG4gICAgfSBlbHNlIHtcbiAgICAgICAgbW9kdWxlRGF0YS5ib3JkZXJDb2xvciA9IFwiQGNvbG9yL2tDb2xvcklucHV0RmlsbFwiO1xuICAgIH1cbn1cblxubW9kdWxlRXZlbnQuY2FuY2VsID0gZnVuY3Rpb24gKCkge1xuICAgIGNvbW1vbi5jb250YWluZXJCYWNrKCk7XG59XG5cbm1vZHVsZUV2ZW50LmNsZWFyRm9jdXMgPSBmdW5jdGlvbiAoKSB7XG4gICAgbW9kdWxlRGF0YS5vbkZvY3VzID0gZmFsc2U7XG59XG5cbm1vZHVsZUV2ZW50LmNsZWFySW5wdXQgPSBmdW5jdGlvbiAoKSB7XG4gICAgbW9kdWxlRGF0YS5zZWFyY2hJbnB1dCA9IFwiXCI7XG59XG5cbm1vZHVsZUV2ZW50LmNsZWFyU2VhcmNoSGlzdG9yeSA9IGFzeW5jIGZ1bmN0aW9uICgpIHtcbiAgICBtb2R1bGVEYXRhLnNlYXJjaExpc3QgPSBcIlwiO1xuICAgIGF3YWl0ICRuYXRpdmVBUEkuc3RvcmFnZSh7XG4gICAgICAgIGFjdGlvbjogXCJjbGVhclwiLFxuICAgICAgICBuYW1lOiBcImVhcm5cIixcbiAgICAgICAga2V5OiBzZWFyY2hIaXN0b3J5RGF0YSxcbiAgICB9KTtcbiAgICBtb2R1bGVEYXRhLnNlYXJjaEhpc3RvcnlWaXMgPSBcImdvbmVcIjtcblxuICAgIGNvbW1vbi5hbmFseXRpY3MoXCJhcHBfZWFybl9hbGxUb2tlblBhZ2Vfc2VhcmNoSGlzdG9yeV9kZWxldGVCdXR0b25fY2xpY2tcIik7XG59XG5cbm1vZHVsZUV2ZW50LmNoaWxkSXRtQ2xpY2sgPSBmdW5jdGlvbiAocGFyZW50SW5kZXgsIGNoaWxkSW5kZXgpIHtcbiAgICBsZXQgcGFyZW50RWxlbWVudCA9IGNvaW5EYXRhW3BhcmVudEluZGV4XTtcbiAgICBsZXQgY2hpbGRFbGVtZW50ID0gY29pbkRhdGFbcGFyZW50SW5kZXhdLmxpc3RbY2hpbGRJbmRleF07XG5cbiAgICBzYXZlSXRlbTJEaXNrKHBhcmVudEVsZW1lbnQuY3VycmVuY3kpO1xuICAgIGp1bXBQcm9kdWN0KGNoaWxkRWxlbWVudCwgcGFyZW50RWxlbWVudCk7XG59XG5cbmZ1bmN0aW9uIGp1bXBQcm9kdWN0KGNoaWxkRWxlbWVudCwgcGFyZW50RWxlbWVudCkge1xuICAgIGNvbW1vbi5vcGVuUGFnZVdpdGhQYXRoKGNoaWxkRWxlbWVudC5qdW1wVXJsKTtcbiAgICBjb21tb24uYW5hbHl0aWNzKFwiYXBwX2Vhcm5fcHJvZHVjdENhcmRfY2xpY2tcIiwge1xuICAgICAgICBwYWdlOiBcImFsbFRva2VuXCIsXG4gICAgICAgIHByb2plY3RJZHM6IGNoaWxkRWxlbWVudC5wcm9qZWN0SWRzLFxuICAgICAgICBwcm9qZWN0VHlwZTogY2hpbGRFbGVtZW50LnByb2pUeXBlLFxuICAgICAgICB0b2tlbjogcGFyZW50RWxlbWVudC5jdXJyZW5jeSxcbiAgICAgICAgdHNCYXNlSW5mbzogcGFyZW50RWxlbWVudC50c0Jhc2VJbmZvXG4gICAgfSk7XG59XG5cblxuZnVuY3Rpb24gb25EZXN0cm95KCkge1xuICAgIC8qKlxuICAgICAqIGNvaW5EYXRhOiBbXSwvL+W4geenjeWIl+ihqFxuICAgICAgICByZWZyZXNoU3RhdHVzOiAwLC8v5Yi35paw54q25oCBXG4gICAgICAgIGxvYWRNb3JlU3RhdHVzOiAwLC8v5Yqg6L2954q25oCBXG4gICAgICAgIHNlYXJjaExpc3Q6IFwiXCIsLy/mkJzntKLljoblj7JcbiAgICAgICAgc2VhcmNoSW5wdXQ6IFwiXCIsLy/ovpPlhaXmoYbmlofmoYhcbiAgICAgICAgb25Gb2N1czogZmFsc2UsLy/ovpPlhaXmoYbnhKbngrlcbiAgICAgICAgY2xlYXJJbnB1dFZpczogXCJnb25lXCIsLy/muIXnqbrovpPlhaXmoYZcbiAgICAgICAgYm9yZGVyQ29sb3I6IFwiQGNvbG9yL2tDb2xvck1ham9yVGhlbWUxMDBcIiwvL+i+ueahhuminOiJslxuICAgICAgICBiYWNrVmlzOiBcInZpc2libGVcIiwvL+i/lOWbnuaMiemSrlxuICAgICAgICBzZWFyY2hIaXN0b3J5VmlzOiBcInZpc2libGVcIiwvL+aQnOe0ouiusOW9lVxuICAgICAqL1xuICAgIG1vZHVsZURhdGEucmVmcmVzaFN0YXR1cyA9IDA7XG4gICAgbW9kdWxlRGF0YS5sb2FkTW9yZVN0YXR1cyA9IDA7XG4gICAgbW9kdWxlRGF0YS5zZWFyY2hMaXN0ID0gXCJcIjtcbiAgICBtb2R1bGVEYXRhLnNlYXJjaElucHV0ID0gXCJcIjtcbiAgICBtb2R1bGVEYXRhLm9uRm9jdXMgPSBmYWxzZTtcbiAgICBtb2R1bGVEYXRhLmNsZWFySW5wdXRWaXMgPSBcImdvbmVcIjtcbiAgICBtb2R1bGVEYXRhLmJvcmRlckNvbG9yID0gXCJAY29sb3Iva0NvbG9yTWFqb3JUaGVtZTEwMFwiO1xuICAgIG1vZHVsZURhdGEuYmFja1ZpcyA9IFwidmlzaWJsZVwiO1xuICAgIG1vZHVsZURhdGEuc2VhcmNoSGlzdG9yeVZpcyA9IFwidmlzaWJsZVwiO1xuICAgIHBhZ2UgPSAwOy8v5LuOMOW8gOWni1xuICAgIGlzUmVmcmVzaCA9IHRydWU7Ly/mmK/lkKbmmK/liLfmlrBcbiAgICBsYXN0RGF0YVNpemUgPSAtMTsvL+S4iuS4gOasoeaVsOaNruaVsOmHj1xuICAgIHNlYXJjaElucHV0ID0gXCJcIjsvL+aQnOe0ouahhui+k+WFpVxuICAgIHJlcXVlc3RUaW1lb3V0ID0gbnVsbDtcbiAgICBuZWVkT25Gb2N1cyA9IGZhbHNlO1xuXG4gICAgY29tbW9uLmFuYWx5dGljcyhcImFwcF9lYXJuX2FsbFRva2VuUGFnZV9yZXR1cm5CdXR0b25fY2xpY2tcIik7XG59XG4iLCJleHBvcnQgY2xhc3MgRmluYW5jZUdyb3VwVHlwZSB7XG5cdC8vL+W4geW4gei0ouWKoeiusOW9leexu+Wei1xuXHQvLy/mj5DluIFcblx0c3RhdGljIFNQT1RfV0lUSERSQVcgPSAxO1xuXG5cdC8vL+WFheW4gVxuXHRzdGF0aWMgU1BPVF9ERVBPU0lUID0gMjtcblxuXHQvLy/ns7vnu59cblx0c3RhdGljIFNQT1RfU1lTVEVNID0gMztcblxuXHQvLy/ngrnljaFcblx0c3RhdGljIFNQT1RfUE9JTlQgPSA0O1xuXG5cdC8vL+i9rOWFpVxuXHRzdGF0aWMgU1BPVF9UUkFOU0ZFUl9JTiA9IDU7XG5cblx0Ly8v6L2s5Ye6XG5cdHN0YXRpYyBTUE9UX1RSQU5TRkVSX09VVCA9IDY7XG5cblx0Ly8v6LSm5oi3566h55CG6LS5XG5cdHN0YXRpYyBTUE9UX01BTkFHRU1FTlRfRkVFID0gNztcblxuXHQvLy/lgJ/ov5jorrDlvZVcblx0c3RhdGljIFNQT1RfQk9SUk9XX1JFVFVSTiA9IDg7XG5cblx0Ly8v6YCQ5LuT5p2g5p2G6LSi5Yqh6K6w5b2V57G75Z6LXG5cdC8vL+eUs+ivt+WAn+W4gVxuXHRzdGF0aWMgTUFSR0lOX0FQUExZX0xPQU4gPSAxMTtcblxuXHQvLy/lvZLov5jlgJ/luIFcblx0c3RhdGljIE1BUkdJTl9SRVBBWV9MT0FOID0gMTI7XG5cblx0Ly8v5b2S6L+Y5biB5oGvXG5cdHN0YXRpYyBNQVJHSU5fUkVQQVlfSU5URVJFU1QgPSAxMztcblxuXHQvLy/lhajku5PmnaDmnYbotKLliqHorrDlvZXnsbvlnotcblx0Ly8v55Sz6K+35YCf5biBXG5cdHN0YXRpYyBDUk9TU19NQVJHSU5fQVBQTFlfTE9BTiA9IDIxO1xuXG5cdC8vL+aZrumAmuW9kui/mFxuXHRzdGF0aWMgQ1JPU1NfTUFSR0lOX1VTRVJfUkVQQVkgPSAyMjtcblxuXHQvLy/ns7vnu5/lvZLov5hcblx0c3RhdGljIENST1NTX01BUkdJTl9TWVNURU1fUkVQQVkgPSAyMztcbn1cblxuZXhwb3J0IGZ1bmN0aW9uIGdldFJlcXVlc3RUeXBlKGdyb3VwVHlwZSkge1xuXHRzd2l0Y2ggKGdyb3VwVHlwZSkge1xuXHRcdGNhc2UgRmluYW5jZUdyb3VwVHlwZS5TUE9UX0RFUE9TSVQ6XG5cdFx0XHRyZXR1cm4gXCJkZXBvc2l0XCI7XG5cdFx0Y2FzZSBGaW5hbmNlR3JvdXBUeXBlLlNQT1RfV0lUSERSQVc6XG5cdFx0XHRyZXR1cm4gXCJ3aXRoZHJhd1wiO1xuXHRcdGNhc2UgRmluYW5jZUdyb3VwVHlwZS5TUE9UX1BPSU5UOlxuXHRcdFx0cmV0dXJuIFwicG9pbnRcIjtcblx0XHRjYXNlIEZpbmFuY2VHcm91cFR5cGUuU1BPVF9UUkFOU0ZFUl9JTjpcblx0XHRcdHJldHVybiBcInRyYW5zZmVyLWluXCI7XG5cdFx0Y2FzZSBGaW5hbmNlR3JvdXBUeXBlLlNQT1RfVFJBTlNGRVJfT1VUOlxuXHRcdFx0cmV0dXJuIFwidHJhbnNmZXItb3V0XCI7XG5cdFx0Y2FzZSBGaW5hbmNlR3JvdXBUeXBlLlNQT1RfU1lTVEVNOlxuXHRcdFx0cmV0dXJuIFwic3lzdGVtXCI7XG5cdH1cblx0cmV0dXJuICd3aXRoZHJhdyc7XG59XG5cblxuZXhwb3J0IGZ1bmN0aW9uIGdldFNwb3RGaW5hbmNlVHlwZVdpdGhHcm91cChncm91cCkge1xuXHR2YXIgdHlwZTtcblx0aWYgKGdyb3VwID09ICdkZXBvc2l0Jykge1xuXHRcdHR5cGUgPSBGaW5hbmNlR3JvdXBUeXBlLlNQT1RfREVQT1NJVDtcblx0fSBlbHNlIGlmIChncm91cCA9PSAnd2l0aGRyYXcnKSB7XG5cdFx0dHlwZSA9IEZpbmFuY2VHcm91cFR5cGUuU1BPVF9XSVRIRFJBVztcblx0fSBlbHNlIGlmIChncm91cCA9PSAncG9pbnQnKSB7XG5cdFx0dHlwZSA9IEZpbmFuY2VHcm91cFR5cGUuU1BPVF9QT0lOVDtcblx0fSBlbHNlIGlmIChncm91cCA9PSAndHJhbnNmZXItaW4nKSB7XG5cdFx0dHlwZSA9IEZpbmFuY2VHcm91cFR5cGUuU1BPVF9UUkFOU0ZFUl9JTjtcblx0fSBlbHNlIGlmIChncm91cCA9PSAndHJhbnNmZXItb3V0Jykge1xuXHRcdHR5cGUgPSBGaW5hbmNlR3JvdXBUeXBlLlNQT1RfVFJBTlNGRVJfT1VUO1xuXHR9IGVsc2Uge1xuXHRcdHR5cGUgPSBGaW5hbmNlR3JvdXBUeXBlLlNQT1RfU1lTVEVNO1xuXHR9XG5cdHJldHVybiB0eXBlO1xufVxuXG5leHBvcnQgZnVuY3Rpb24gZ2V0U3BvdERpc3BsYXlUeXBlKGZpbmFuY2VUeXBlKSB7XG5cdHN3aXRjaCAoZmluYW5jZVR5cGUpIHtcblx0XHRjYXNlIEZpbmFuY2VHcm91cFR5cGUuU1BPVF9ERVBPU0lUOlxuXHRcdFx0cmV0dXJuICRpMThuLm5fY29pbmRldGFpbF9oaXN0b3J5X2RlcG9zaXQ7XG5cdFx0Y2FzZSBGaW5hbmNlR3JvdXBUeXBlLlNQT1RfV0lUSERSQVc6XG5cdFx0XHRyZXR1cm4gJGkxOG4ubl9jb2luZGV0YWlsX2hpc3Rvcnlfd2l0aGRyYXc7XG5cdFx0Y2FzZSBGaW5hbmNlR3JvdXBUeXBlLlNQT1RfUE9JTlQ6XG5cdFx0XHRyZXR1cm4gJGkxOG4ubl9jb2luZGV0YWlsX2hpc3RvcnlfcG9pbnQ7XG5cdFx0Y2FzZSBGaW5hbmNlR3JvdXBUeXBlLlNQT1RfVFJBTlNGRVJfSU46XG5cdFx0XHRyZXR1cm4gJGkxOG4ubl9jb2luZGV0YWlsX2hpc3RvcnlfaW47XG5cdFx0Y2FzZSBGaW5hbmNlR3JvdXBUeXBlLlNQT1RfVFJBTlNGRVJfT1VUOlxuXHRcdFx0cmV0dXJuICRpMThuLm5fY29pbmRldGFpbF9oaXN0b3J5X291dDtcblx0XHRjYXNlIEZpbmFuY2VHcm91cFR5cGUuU1BPVF9TWVNURU06XG5cdFx0XHRyZXR1cm4gJGkxOG4ubl9jb2luZGV0YWlsX2hpc3Rvcnlfb3RoZXI7XG5cdH1cblx0cmV0dXJuICcnO1xufVxuXG4vLy8g5YWF5o+Q5biB54q25oCB5a+55bqU55qE5YmN56uv57G75Z6L5paH5qGj5aaC5LiLXG4vLy8gaHR0cDovL3BoYWJyaWNhdG9yLmh1b2JpZGV2LmNvbS93L2dsb2JhbF9wbS9hcHAvdG9uZ3lvbmcvZGVwb3NpdF92aXJ0dWFsX3N0YXRlXG5leHBvcnQgZnVuY3Rpb24gZ2V0U3BvdEZpbmFuY2VTdGF0ZShzdGF0ZSwgZmluYW5jZVRhYlR5cGUpIHtcblx0dmFyIHN0YXRlU3RyID0gJGkxOG4ubl9jb2luZGV0YWlsX2hpc3Rvcnlfc3RhdHVzX2NvbXBsZXRlZDtcblx0aWYgKGZpbmFuY2VUYWJUeXBlID09IEZpbmFuY2VHcm91cFR5cGUuU1BPVF9ERVBPU0lUKSB7XG5cdFx0aWYgKHN0YXRlID09ICdjb25maXJtaW5nJyB8fFxuXHRcdFx0c3RhdGUgPT0gJ2NvbmZpcm1lZCcgfHxcblx0XHRcdHN0YXRlID09ICdvcnBoYW4tY29uZmlybWluZycgfHxcblx0XHRcdHN0YXRlID09ICdvcnBoYW4tY29uZmlybWVkJyB8fFxuXHRcdFx0c3RhdGUgPT0gJ3JvbGxiYWNrLWNvbmZpcm1pbmcnIHx8XG5cdFx0XHRzdGF0ZSA9PSAncm9sbGJhY2stY29uZmlybWVkJykge1xuXHRcdFx0c3RhdGVTdHIgPSAkaTE4bi5uX2NvaW5kZXRhaWxfaGlzdG9yeV9zdGF0dXNfY29uZmlybWluZztcblx0XHR9IGVsc2UgaWYgKHN0YXRlID09ICdvcnBoYW4nIHx8IHN0YXRlID09ICdyb2xsYmFjay1vcnBoYW4nKSB7XG5cdFx0XHRzdGF0ZVN0ciA9ICRpMThuLm5fY29pbmRldGFpbF9oaXN0b3J5X3N0YXR1c19vcnBoYW47XG5cdFx0fSBlbHNlIGlmIChzdGF0ZS5pbmNsdWRlcygnc2FmZScpIHx8IHN0YXRlID09ICd2YWxpZCcpIHtcblx0XHRcdHN0YXRlU3RyID0gJGkxOG4ubl9jb2luZGV0YWlsX2hpc3Rvcnlfc3RhdHVzX2NvbXBsZXRlZDtcblx0XHR9IGVsc2UgaWYgKHN0YXRlID09ICdyaXNrLWRlbGF5Jykge1xuXHRcdFx0c3RhdGVTdHIgPSAkaTE4bi5uX2NvaW5kZXRhaWxfaGlzdG9yeV9zdGF0dXNfdG9fYmVfY3JlZGl0ZWQ7XG5cdFx0fSBlbHNlIGlmIChzdGF0ZSA9PSAncGVuZGluZy10aW55LWFtb3VudCcgfHxcblx0XHRcdHN0YXRlID09ICd3YWl0aW5nLXRpbnktYW1vdW50Jykge1xuXHRcdFx0c3RhdGVTdHIgPSAkaTE4bi5uX2NvaW5kZXRhaWxfaGlzdG9yeV9zdGF0dXNfc21hbGxfYW1vdW50X2lzX25vdF9hY2NvdW50ZWQ7XG5cdFx0fSBlbHNlIGlmIChzdGF0ZSA9PSAnbGFyZ2UtYW1vdW50LWV4YW1pbmUnKSB7XG5cdFx0XHRzdGF0ZVN0ciA9ICRpMThuLm5fY29pbmRldGFpbF9oaXN0b3J5X3N0YXR1c193YWl0aW5nX3Jldmlldztcblx0XHR9IGVsc2UgaWYgKHN0YXRlID09ICd1bmtub3duJykge1xuXHRcdFx0aWYgKHN0YXRlID09ICdkZXBvc2l0LXZpcnR1YWwtZmFzdCcpIHtcblx0XHRcdFx0c3RhdGVTdHIgPSAkaTE4bi5uX2NvaW5kZXRhaWxfaGlzdG9yeV9zdGF0dXNfY29uZmlybWluZztcblx0XHRcdH1cblx0XHR9XG5cdH0gZWxzZSB7XG5cdFx0aWYgKHN0YXRlID09ICdwcmUtc3VibWl0dGVkJyB8fFxuXHRcdFx0c3RhdGUgPT0gJ3N1Ym1pdHRlZCcgfHxcblx0XHRcdHN0YXRlID09ICdyZWV4YW1pbmUnKSB7XG5cdFx0XHRzdGF0ZVN0ciA9ICRpMThuLm5fY29pbmRldGFpbF9oaXN0b3J5X3N0YXR1c193YWl0aW5nX3Jldmlldztcblx0XHR9IGVsc2UgaWYgKHN0YXRlID09ICdwYXNzJyB8fCBzdGF0ZSA9PSAncHJlLXRyYW5zZmVyJykge1xuXHRcdFx0c3RhdGVTdHIgPSAkaTE4bi5uX2NvaW5kZXRhaWxfaGlzdG9yeV9zdGF0dXNfcHJvY2Vzc2luZztcblx0XHR9IGVsc2UgaWYgKHN0YXRlID09ICdyZWplY3QnKSB7XG5cdFx0XHRzdGF0ZVN0ciA9ICRpMThuLm5fY29pbmRldGFpbF9oaXN0b3J5X3N0YXR1c19yZWZ1c2VkO1xuXHRcdH0gZWxzZSBpZiAoc3RhdGUgPT0gJ3dhbGxldC10cmFuc2ZlcicpIHtcblx0XHRcdHN0YXRlU3RyID0gJGkxOG4ubl9jb2luZGV0YWlsX2hpc3Rvcnlfc3RhdHVzX3NlbmQ7XG5cdFx0fSBlbHNlIGlmIChzdGF0ZSA9PSAnd2FsbGV0LXJlamVjdCcgfHwgc3RhdGUgPT0gJ2NvbmZpcm0tZXJyb3InKSB7XG5cdFx0XHRzdGF0ZVN0ciA9ICRpMThuLm5fY29pbmRldGFpbF9oaXN0b3J5X3N0YXR1c19mYWlsZWQ7XG5cdFx0fSBlbHNlIGlmIChzdGF0ZSA9PSAnY29uZmlybWVkJykge1xuXHRcdFx0c3RhdGVTdHIgPSAkaTE4bi5uX2NvaW5kZXRhaWxfaGlzdG9yeV9zdGF0dXNfY29tcGxldGVkO1xuXHRcdH0gZWxzZSBpZiAoc3RhdGUgPT0gJ2NhbmNlbGVkJyB8fCBzdGF0ZSA9PSAncmVwZWFsZWQnKSB7XG5cdFx0XHRzdGF0ZVN0ciA9ICRpMThuLm5fY29pbmRldGFpbF9oaXN0b3J5X3N0YXR1c19jYW5jZWxlZDtcblx0XHR9IGVsc2UgaWYgKHN0YXRlID09ICdWZXJpZnlpbmcnKSB7XG5cdFx0XHRzdGF0ZVN0ciA9ICRpMThuLm5fY29pbmRldGFpbF9oaXN0b3J5X3N0YXR1c19uZWVkX3ZlcmlmeTtcblx0XHR9IGVsc2UgaWYgKHN0YXRlID09ICdGYWlsZWQnKSB7XG5cdFx0XHRzdGF0ZVN0ciA9ICRpMThuLm5fY29pbmRldGFpbF9oaXN0b3J5X3N0YXR1c192ZXJpZnlfZmFpbHVyZTtcblx0XHR9XG5cdH1cblx0cmV0dXJuIHN0YXRlU3RyO1xufVxuXG5leHBvcnQgZnVuY3Rpb24gZ2V0U3BvdERpc3BsYXlTdGF0dXNEZXRhaWwoXG5cdHR5cGUsIGRpcmVjdGlvbiwgZGVzYywgaXRlbV9leHRyYSkge1xuXHRpZiAoZGVzYyAhPSBudWxsICYmIGRlc2MgIT0gJycpIHtcblx0XHRyZXR1cm4gZGVzYztcblx0fVxuXHR2YXIgZGlzcGxheVN0YXR1c0RldGFpbCA9IFwiLS1cIjtcblx0aWYgKHR5cGUuaW5jbHVkZXMoJ2JpdGV4JykgfHwgdHlwZS5pbmNsdWRlcygnb2xkaHVvYmknKSkge1xuXHRcdGRpc3BsYXlTdGF0dXNEZXRhaWwgPSBkaXJlY3Rpb24gPT0gJ2luJ1xuXHRcdFx0PyAkaTE4bi5uX2NvaW5kZXRhaWxfaGlzdG9yeV9pblxuXHRcdFx0OiAkaTE4bi5uX2NvaW5kZXRhaWxfaGlzdG9yeV9vdXQ7XG5cdFx0ZGlzcGxheVN0YXR1c0RldGFpbCA9IGRpc3BsYXlTdGF0dXNEZXRhaWwgKyAnIGh1b2JpLmNvbSc7XG5cdH0gZWxzZSBpZiAodHlwZSA9PSAnNicgfHwgdHlwZS5pbmNsdWRlcygnb3RjLXRvLXBybycpKSB7XG5cdFx0ZGlzcGxheVN0YXR1c0RldGFpbCA9ICRpMThuLm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9vdGNfdG9fcHJvO1xuXHR9IGVsc2UgaWYgKHR5cGUgPT0gJzUnIHx8IHR5cGUuaW5jbHVkZXMoJ3Byby10by1vdGMnKSkge1xuXHRcdGRpc3BsYXlTdGF0dXNEZXRhaWwgPSAkaTE4bi5uX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfcHJvX3RvX290Yztcblx0Ly8gfSBlbHNlIGlmICh0eXBlLmluY2x1ZGVzKCdwcm8tdG8taW5zdGl0dXRpb24nKSkge1xuXHRcdC8vIGRpc3BsYXlTdGF0dXNEZXRhaWwgPSAkaTE4bi5uX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfcHJvX3RvX2luc3RpdHV0aW9uO1xuXHQvLyB9IGVsc2UgaWYgKHR5cGUuaW5jbHVkZXMoJ2luc3RpdHV0aW9uLXRvLXBybycpKSB7XG5cdFx0Ly8gZGlzcGxheVN0YXR1c0RldGFpbCA9ICRpMThuLm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9pbnN0aXR1dGlvbl90b19wcm87XG5cdH0gZWxzZSBpZiAodHlwZS5pbmNsdWRlcygnc3ViLXRyYW5zZmVyLW91dCcpIHx8XG5cdFx0dHlwZSA9PSAnbWFzdGVyLXRyYW5zZmVyLWluJykge1xuXHRcdGRpc3BsYXlTdGF0dXNEZXRhaWwgPSAkaTE4bi5uX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfY2hpbGRfdG9fcHJvO1xuXHR9IGVsc2UgaWYgKHR5cGUuaW5jbHVkZXMoJ3N1Yi10cmFuc2Zlci1pbicpIHx8XG5cdFx0dHlwZSA9PSAnbWFzdGVyLXRyYW5zZmVyLW91dCcpIHtcblx0XHRkaXNwbGF5U3RhdHVzRGV0YWlsID0gJGkxOG4ubl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX3Byb190b19jaGlsZDtcblx0fSBlbHNlIGlmICh0eXBlLmluY2x1ZGVzKCdwcm8tdG8tc3VwZXItbWFyZ2luJykpIHtcblx0XHRkaXNwbGF5U3RhdHVzRGV0YWlsID0gJGkxOG4ubl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX3Byb190b19zdXBlcm1hcmdpbjtcblx0fSBlbHNlIGlmICh0eXBlLmluY2x1ZGVzKCdzdXBlci1tYXJnaW4tdG8tcHJvJykpIHtcblx0XHRkaXNwbGF5U3RhdHVzRGV0YWlsID0gJGkxOG4ubl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX3N1cGVybWFyZ2luX3RvX3Bybztcblx0fSBlbHNlIGlmICh0eXBlID09ICdtYXJnaW4tdHJhbnNmZXItaW4nKSB7XG5cdFx0ZGlzcGxheVN0YXR1c0RldGFpbCA9ICRpMThuLm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9wcm9fdG9fbWFyZ2luO1xuXHR9IGVsc2UgaWYgKHR5cGUgPT0gJ21hcmdpbi10cmFuc2Zlci1vdXQnKSB7XG5cdFx0ZGlzcGxheVN0YXR1c0RldGFpbCA9ICRpMThuLm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9tYXJnaW5fdG9fcHJvO1xuXHQvLyB9IGVsc2UgaWYgKHR5cGUgPT0gJ3N0YWJsZS1jdXJyZW5jeS10cmFuc2Zlci1pbicpIHtcblx0Ly8gXHRkaXNwbGF5U3RhdHVzRGV0YWlsID1cblx0Ly8gXHRcdCRpMThuLm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9zdGFibGVfY3VycmVuY3lfdHJhbnNmZXJfaW47XG5cdC8vIH0gZWxzZSBpZiAodHlwZSA9PSAnc3RhYmxlLWN1cnJlbmN5LXRyYW5zZmVyLW91dCcpIHtcblx0Ly8gXHRkaXNwbGF5U3RhdHVzRGV0YWlsID1cblx0Ly8gXHRcdCRpMThuLm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9zdGFibGVfY3VycmVuY3lfdHJhbnNmZXJfb3V0O1xuXHR9IGVsc2UgaWYgKHR5cGUgPT0gJ3Byby10by1mdXR1cmVzJykge1xuXHRcdGRpc3BsYXlTdGF0dXNEZXRhaWwgPSAkaTE4bi5uX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfcHJvX3RvX2NvbnRyYWN0O1xuXHR9IGVsc2UgaWYgKHR5cGUgPT0gJ2Z1dHVyZXMtdG8tcHJvJykge1xuXHRcdGRpc3BsYXlTdGF0dXNEZXRhaWwgPSAkaTE4bi5uX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfY29udHJhY3RfdG9fcHJvO1xuXHR9IGVsc2UgaWYgKHR5cGUgPT0gJ2RtLXByby10by1zd2FwJykge1xuXHRcdGRpc3BsYXlTdGF0dXNEZXRhaWwgPSAkaTE4bi5uX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfcHJvX3RvX3N3YXA7XG5cdH0gZWxzZSBpZiAodHlwZSA9PSAnZG0tc3dhcC10by1wcm8nKSB7XG5cdFx0ZGlzcGxheVN0YXR1c0RldGFpbCA9ICRpMThuLm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9zd2FwX3RvX3Bybztcblx0Ly8gfSBlbHNlIGlmICh0eXBlID09ICdtaW5lLXBvb2wtdHJhbnNmZXItaW4nKSB7XG5cdC8vIFx0ZGlzcGxheVN0YXR1c0RldGFpbCA9ICRpMThuLm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9wcm9fdG9fcG9vbDtcblx0Ly8gfSBlbHNlIGlmICh0eXBlID09ICdtaW5lLXBvb2wtdHJhbnNmZXItb3V0Jykge1xuXHQvLyBcdGRpc3BsYXlTdGF0dXNEZXRhaWwgPSAkaTE4bi5uX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfcG9vbF90b19wcm87XG5cdC8vIH0gZWxzZSBpZiAodHlwZSA9PSAnc3BvdC10by1ib3Jyb3cnKSB7XG5cdC8vIFx0ZGlzcGxheVN0YXR1c0RldGFpbCA9ICRpMThuLm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9wcm9fdG9fYzJjO1xuXHQvLyB9IGVsc2UgaWYgKHR5cGUgPT0gJ2JvcnJvdy10by1zcG90Jykge1xuXHQvLyBcdGRpc3BsYXlTdGF0dXNEZXRhaWwgPSAkaTE4bi5uX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfYzJjX3RvX3Bybztcblx0Ly8gfSBlbHNlIGlmICh0eXBlID09ICdzcG90LXRvLWRlcG9zaXQtZWFybmluZycpIHtcblx0Ly8gXHRkaXNwbGF5U3RhdHVzRGV0YWlsID0gJGkxOG4ubl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX3Byb190b19zYXZpbmdzO1xuXHQvLyB9IGVsc2UgaWYgKHR5cGUgPT0gJ2RlcG9zaXQtZWFybmluZy10by1zcG90Jykge1xuXHQvLyBcdGRpc3BsYXlTdGF0dXNEZXRhaWwgPSAkaTE4bi5uX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfc2F2aW5nc190b19wcm87XG5cdC8vIH0gZWxzZSBpZiAodHlwZSA9PSAnc3BvdC10by1vcHRpb24nKSB7XG5cdC8vIFx0ZGlzcGxheVN0YXR1c0RldGFpbCA9ICRpMThuLm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9wcm9fdG9fb3B0aW9uO1xuXHQvLyB9IGVsc2UgaWYgKHR5cGUgPT0gJ29wdGlvbi10by1zcG90Jykge1xuXHQvLyBcdGRpc3BsYXlTdGF0dXNEZXRhaWwgPSAkaTE4bi5uX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfb3B0aW9uX3RvX3Bybztcblx0fSBlbHNlIGlmICh0eXBlID09ICdzcG90LXRvLWxpbmVhci1zd2FwJykge1xuXHRcdGRpc3BsYXlTdGF0dXNEZXRhaWwgPSAkaTE4bi5uX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfcHJvX3RvX2xpbmVhcl9zd2FwX3VzZHQ7XG5cdH0gZWxzZSBpZiAodHlwZSA9PSAnbGluZWFyLXN3YXAtdG8tc3BvdCcpIHtcblx0XHRkaXNwbGF5U3RhdHVzRGV0YWlsID0gJGkxOG4ubl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX2xpbmVhcl9zd2FwX3VzZHRfdG9fcHJvO1xuXHR9IGVsc2UgaWYgKHR5cGUgPT0gJ3Bvb2wtc2F2aW5ncy1zcG90LXRvLWNsY3QnKSB7XG5cdFx0ZGlzcGxheVN0YXR1c0RldGFpbCA9ICRpMThuLm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9wcm9fdG9fZWFybjtcblx0fSBlbHNlIGlmICh0eXBlID09ICdwb29sLXNhdmluZ3MtZXhwZW5kLXRvLXNwb3QnKSB7XG5cdFx0ZGlzcGxheVN0YXR1c0RldGFpbCA9ICRpMThuLm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9lYXJuX3RvX3Bybztcblx0fSBlbHNlIGlmICh0eXBlID09ICdwb29sLXNhdmluZ3Mtb3BzLXRvLWFzc2V0LW1hbmFnZW1lbnQtc3BvdCcgfHxcblx0XHR0eXBlID09ICdmaW5hbmNlLXByb2plY3Qtc3lzdGVtLXRvLWtvbCcgfHxcblx0XHR0eXBlID09ICdmaW5hbmNlLXByb2plY3Qtc3lzdGVtLXRvLWtvbC1tYXJrZXQnIHx8XG5cdFx0dHlwZSA9PSAnZmluYW5jZS1wcm9qZWN0LXN5c3RlbS10by1jaGFubmVsJyB8fFxuXHRcdHR5cGUgPT0gJ2ZpbmFuY2UtcHJvamVjdC1zeXN0ZW0tdG8tbWFya2V0JyB8fFxuXHRcdHR5cGUgPT0gJ2ZpbmFuY2UtcHJvamVjdC1zeXN0ZW0tdG8tYnJhbmQnIHx8XG5cdFx0dHlwZSA9PSAnZmluYW5jZS1wcm9qZWN0LXN5c3RlbS10by1yZWxhdGlvbnMnIHx8XG5cdFx0dHlwZSA9PSAnZmluYW5jZS1wcm9qZWN0LXN5c3RlbS10by1hY3Rpdml0eScpIHtcblx0XHRkaXNwbGF5U3RhdHVzRGV0YWlsID0gJGkxOG4ubl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX3N5c3RlbV90cmFuc2Zlcl9pbjtcblx0fSBlbHNlIGlmICh0eXBlID09ICdwb29sLXNhdmluZ3MtYXNzZXQtbWFuYWdlbWVudC1zcG90LXRvLW9wcycgfHxcblx0XHR0eXBlID09ICdwb29sLXNhdmluZ3MtYXNzZXQtbWFuYWdlbWVudC1zcG90LXRvLWludGVyZXN0Jykge1xuXHRcdGRpc3BsYXlTdGF0dXNEZXRhaWwgPSAkaTE4bi5uX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfc3lzdGVtX3RyYW5zZmVyX291dDtcblx0Ly8gfSBlbHNlIGlmICh0eXBlID09ICdldHAtc2hhcmVzLW1lcmdlLXN5cy10by1zcG90Jykge1xuXHQvLyBcdGRpc3BsYXlTdGF0dXNEZXRhaWwgPSAkaTE4bi5uX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfZXRwX3RvX3Bybztcblx0Ly8gfSBlbHNlIGlmICh0eXBlID09ICdldHAtc2hhcmVzLW1lcmdlLXNwb3QtdG8tc3lzJykge1xuXHQvLyBcdGRpc3BsYXlTdGF0dXNEZXRhaWwgPSAkaTE4bi5uX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfcHJvX3RvX2V0cDtcblx0fSBlbHNlIGlmICh0eXBlID09ICdncmlkLXRyYW5zZmVyLWluJykge1xuXHRcdGRpc3BsYXlTdGF0dXNEZXRhaWwgPSAkaTE4bi5uX2dyaWRfdHJhbnNmZXJfaW47XG5cdH0gZWxzZSBpZiAodHlwZSA9PSAnZ3JpZC10cmFuc2Zlci1vdXQnKSB7XG5cdFx0ZGlzcGxheVN0YXR1c0RldGFpbCA9ICRpMThuLm5fZ3JpZF90cmFuc2Zlcl9vdXQ7XG5cdH0gZWxzZSBpZiAodHlwZSA9PSAnb3RjLW9wdGlvbnMtdG8tc3BvdCcpIHtcblx0XHRkaXNwbGF5U3RhdHVzRGV0YWlsID0gJGkxOG4ubl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX290Y19vcHRpb25fdG9fcHJvO1xuXHR9IGVsc2UgaWYgKHR5cGUgPT0gJ3Nwb3QtdG8tb3RjLW9wdGlvbnMnKSB7XG5cdFx0ZGlzcGxheVN0YXR1c0RldGFpbCA9ICRpMThuLm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9wcm9fdG9fb3RjX29wdGlvbjtcblx0fSBlbHNlIGlmICh0eXBlID09ICdlYXJuLXN5cy1jb21taXNzaW9uLXRvLXNwb3QnKSB7XG5cdFx0ZGlzcGxheVN0YXR1c0RldGFpbCA9ICRpMThuLm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9lYXJuX2F3YXJkO1xuXHR9IGVsc2UgaWYgKHR5cGUgPT0gJ2Z1bmQtb3JnLXRvLWZ1bmQtcmlzZS1zeXN0ZW0nIHx8XG5cdFx0dHlwZSA9PSAnaW52ZXN0b3ItdG8tZnVuZC1yaXNlLXN5c3RlbScgfHxcblx0XHR0eXBlID09ICdpbnN0aXR1dGlvbi1pbnZlc3Rvci10by1mdW5kLXJpc2Utc3lzdGVtJykge1xuXHRcdGRpc3BsYXlTdGF0dXNEZXRhaWwgPSAkaTE4bi5uX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfc3lzdGVtX3RyYW5zZmVyX291dDtcblx0fSBlbHNlIGlmICh0eXBlID09ICdmdW5kLXJpc2Utc3lzdGVtLXRvLWZ1bmQtb3JnJyB8fFxuXHRcdHR5cGUgPT0gJ2Z1bmQtcmlzZS1zeXN0ZW0tdG8taW52ZXN0b3InIHx8XG5cdFx0dHlwZSA9PSAncHJvamVjdC1haXJkcm9wLXVzZXItc3BvdC1vbmVzaWRlLWluJyB8fFxuXHRcdHR5cGUgPT0gJ2Z1bmQtcmlzZS1zeXN0ZW0tdG8taW5zdGl0dXRpb24taW52ZXN0b3InIHx8XG5cdFx0dHlwZSA9PSAnZnVuZC1yaXNlLXN5c3RlbS10by1mdW5kZXInKSB7XG5cdFx0ZGlzcGxheVN0YXR1c0RldGFpbCA9ICRpMThuLm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9zeXN0ZW1fdHJhbnNmZXJfaW47XG5cdH0gZWxzZSBpZiAodHlwZSA9PSAnYWlyZHJvcC11c2VyLXNwb3Qtb25lc2lkZS1pbicgfHxcblx0XHR0eXBlID09ICdnbG9iYWwtYWN0aXZpdHktdG8tc3BvdCcgfHxcblx0XHR0eXBlID09ICdnbG9iYWwtbWluaW5nLXN5c3RlbS10by1zcG90Jykge1xuXHRcdC8vIOa0u+WKqOWlluWKsVxuXHRcdGRpc3BsYXlTdGF0dXNEZXRhaWwgPSAkaTE4bi5uX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfYWN0aXZpdHlfcmV3YXJkO1xuXHR9IGVsc2UgaWYgKHR5cGUgPT0gJ3Jld2FyZC1hY3Rpdml0eS1zeXN0ZW0tdG8tdXNlcicpIHtcblx0XHRkaXNwbGF5U3RhdHVzRGV0YWlsID0gJGkxOG4ubl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX3JlZF9lbnZlbG9wZV9yZXdhcmQ7XG5cdC8vIH0gZWxzZSBpZiAodHlwZSA9PSAndXNlci10by1ldHAtcGVwZWwtc3lzJykge1xuXHQvLyBcdGRpc3BsYXlTdGF0dXNEZXRhaWwgPSAkaTE4bi5uX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfZXRwX2NsZWFyX3JlY3ljbGU7XG5cdC8vIH0gZWxzZSBpZiAodHlwZSA9PSAnZXRwLXBlcGVsLXN5cy10by11c2VyJyB8fFxuXHQvLyBcdHR5cGUgPT0gJ2V0cC1vcGVyYXRpb25zLXRvLXNwb3QnKSB7XG5cdC8vIFx0ZGlzcGxheVN0YXR1c0RldGFpbCA9ICRpMThuLm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9ldHBfY2xlYXJfdHJhbnNmZXJfaW47XG5cdH0gZWxzZSBpZiAodHlwZSA9PSAnYXBpLWJyb2tlcmFnZS1hdXRvLWJyb2tlcmFnZS10by1zcG90JyB8fCAvL2Fwaei/lOS9o1xuXHRcdHR5cGUgPT0gJ2FwaS1icm9rZXJhZ2UtZnV0dXJlcy1hdXRvLWJyb2tlcmFnZS10by1zcG90JyB8fFxuXHRcdHR5cGUgPT0gJ2FwaS1icm9rZXJhZ2UtYnJva2VyYWdlLXRvLXNwb3QnIHx8XG5cdFx0dHlwZSA9PSAnYXBpLWJyb2tlcmFnZS1mdXR1cmVzLWJyb2tlcmFnZS10by1zcG90JyB8fFxuXHRcdHR5cGUgPT0gJ2FwaS1tYXRjaGluZy1mZWUtYnJva2VyYWdlJykge1xuXHRcdGRpc3BsYXlTdGF0dXNEZXRhaWwgPSAkaTE4bi5uX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfYXBpX2Jyb2tlcmFnZV90b19zcG90O1xuXHR9IGVsc2UgaWYgKHR5cGUgPT0gJ2dsb2JhbC1zeXMtb3ZlcnNlYXMtYWN0aXZpdHktdG8tc3BvdCcpIHtcblx0XHRkaXNwbGF5U3RhdHVzRGV0YWlsID0gJGkxOG4ubl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX3Jld2FyZF9yZWNlaXZlO1xuXHR9IGVsc2UgaWYgKHR5cGUgPT0gJ2dsb2JhbC1zcG90LXRvLXN5cy1vdmVyc2Vhcy1hY3Rpdml0eScpIHtcblx0XHRkaXNwbGF5U3RhdHVzRGV0YWlsID0gJGkxOG4ubl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX2RlZHVjdGlvbjtcblx0fSBlbHNlIGlmICh0eXBlID09ICdnbG9iYWwtY291cG9uLXN5c3RlbS10by1zcG90Jykge1xuXHRcdGRpc3BsYXlTdGF0dXNEZXRhaWwgPSAkaTE4bi5uX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfY2FzaGJhY2tfdm91Y2hlcjtcblx0XHQvLyB9IGVsc2UgaWYgKHR5cGUgPT0gJ2xldmVyYWdlLXByaW5jaXBhbC1yZWNlaXZhYmxlLXRvLXNwb3QnKSB7IC8vIDgxN+eJiOacrOabtOaNoiB0eXBlXG5cdH0gZWxzZSBpZiAodHlwZSA9PSAnbGV2ZXJhZ2UtcHJpbmNpcGFsLXRvLWxvYW4tcmVjZWl2YWJsZScpIHtcblx0XHRkaXNwbGF5U3RhdHVzRGV0YWlsID0gJGkxOG4ubl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX2MyY0xlbmRJbkNvaW5UaXRsZTtcblx0XHQvLyB9IGVsc2UgaWYgKHR5cGUgPT0gJ2xldmVyYWdlLXNwb3QtdG8tcHJpbmNpcGFsLXJlY2VpdmFibGUnKSB7IC8vIDgxN+eJiOacrOabtOaNoiB0eXBlXG5cdH0gZWxzZSBpZiAodHlwZSA9PSAnbGV2ZXJhZ2UtbG9hbi1yZWNlaXZhYmxlLXRvLXByaW5jaXBhbCcpIHtcblx0XHRkaXNwbGF5U3RhdHVzRGV0YWlsID0gJGkxOG4ubl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX3JlcGF5X2NvaW47XG5cdH0gZWxzZSBpZiAodHlwZSA9PSAnbGV2ZXJhZ2Utc3BvdC10by1pbnRlcmVzdC1yZWNlaXZhYmxlJykge1xuXHRcdGRpc3BsYXlTdGF0dXNEZXRhaWwgPVxuXHRcdFx0JGkxOG4ubl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX2FjY3J1YWxfdGl0bGU7IC8vIDgxN+eJiOacrOabtOaNoiDmlofmoYgg6L+Y5oGvIOWPmOabtOS4uiDorqHmga9cblx0fSBlbHNlIGlmICh0eXBlID09ICduZnQtcGxhdGZvcm0tc3lzdGVtLXRvLXNlbGxlci1zcG90LWNvcHlyaWdodCcpIHtcblx0XHRkaXNwbGF5U3RhdHVzRGV0YWlsID0gJGkxOG4ubl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX25mdF9jb3B5cmlnaHQ7XG5cdH0gZWxzZSBpZiAodHlwZSA9PSAnbmZ0LXBsYXRmb3JtLXN5c3RlbS10by1zZWxsZXItc3BvdC1zYWxlJykge1xuXHRcdGRpc3BsYXlTdGF0dXNEZXRhaWwgPSAkaTE4bi5uX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfbmZ0X3NhbGU7XG5cdH0gZWxzZSBpZiAodHlwZSA9PSAnbmZ0LXNwb3QtdG8tcGxhdGZvcm0tc3lzdGVtJykge1xuXHRcdGRpc3BsYXlTdGF0dXNEZXRhaWwgPSAkaTE4bi5uX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfbmZ0X2J1eTtcblx0fSBlbHNlIGlmICh0eXBlID09ICduZnQtcGxhdGZvcm0tc3lzdGVtLXRvLXNwb3QnKSB7XG5cdFx0ZGlzcGxheVN0YXR1c0RldGFpbCA9ICRpMThuLm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9uZnRfcmVmdW5kO1xuXHR9IGVsc2UgaWYgKHR5cGUgPT0gJ2xldmVyYWdlLWludGVyZXN0LXJlY2VpdmFibGUtdG8tdHJhbnMtc3lzJykge1xuXHRcdGRpc3BsYXlTdGF0dXNEZXRhaWwgPSAkaTE4bi5uX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfcmVwYXlfaW50ZXJlc3Q7XG5cdH0gZWxzZSBpZiAodHlwZSA9PSAnZ2xvYmFsLUZ1bmRyYWlzaW5nLXNwb3QtdG8tc3lzdGVtJykge1xuXHRcdGRpc3BsYXlTdGF0dXNEZXRhaWwgPSAkaTE4bi5uX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfc3Vic2NyaWJlX3VwZGF0ZTtcblx0fSBlbHNlIGlmICh0eXBlID09ICcxLUFkZGl0aW9uYWxudGVyZXN0LXN5c3RlbS10by1zcG90Jykge1xuXHRcdGRpc3BsYXlTdGF0dXNEZXRhaWwgPSAkaTE4bi5uX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfaW50ZXJlc3RfcmVpc3N1ZV91cGRhdGU7XG5cdH0gZWxzZSBpZiAodHlwZSA9PSAnZ2xvYmFsLXNoYXJrMDA3LXN5c3RlbS10by1zcG90JyB8fFxuXHRcdHR5cGUgPT0gJ2dsb2JhbC1pbnMwMS1zeXN0ZW0tdG8tc3BvdCcgfHxcblx0XHR0eXBlID09ICdwb29sLXNhdmluZ3MtaW50ZXJlc3QtdG8tc3BvdCcpIHtcblx0XHRkaXNwbGF5U3RhdHVzRGV0YWlsID0gJGkxOG4ubl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX2ludGVyZXN0X2lzc3VlX3VwZGF0ZTtcblx0fSBlbHNlIGlmICh0eXBlID09ICdlYXJuLXN5cy1yYXRlLXRvLXNwb3QnKSB7XG5cdFx0ZGlzcGxheVN0YXR1c0RldGFpbCA9ICRpMThuLm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9pbnRlcmVzdF9jb3Vwb25faXNzdWVfdXBkYXRlO1xuXHR9IGVsc2UgaWYgKHR5cGUgPT0gJ2dsb2JhbC1GdW5kcmFpc2luZy1zeXN0ZW0tdG8tc3BvdCcpIHtcblx0XHRkaXNwbGF5U3RhdHVzRGV0YWlsID0gJGkxOG4ubl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX3JlZGVtcHRpb25fdXBkYXRlO1xuXHR9IGVsc2UgaWYgKHR5cGUgPT0gJ2dsb2JhbC1TdXJwbHVzY3VycmVuY3ktc3BvdC10by1zeXN0ZW0nIHx8XG5cdFx0dHlwZSA9PSAnZ2xvYmFsLVN1cnBsdXNjdXJyZW5jeS1zeXN0ZW0tdG8tc3BvdCcgfHxcblx0XHR0eXBlID09ICdnbG9iYWwtc2hhcmswMDgtc3BvdC10by1zcG90JyB8fFxuXHRcdHR5cGUgPT0gJzEtQWRkaXRpb25hbG50ZXJlc3Qtc3BvdC10by1zeXN0ZW0nKSB7XG5cdFx0ZGlzcGxheVN0YXR1c0RldGFpbCA9ICRpMThuLm5fY29pbmRldGFpbF9oaXN0b3J5X290aGVyO1xuXHR9IGVsc2UgaWYgKHR5cGUgPT0gJ2dsb2JhbC1uZXdjdXJyZW5jeS1mcm96ZW4tdG8tc3lzdGVtJykge1xuXHRcdGRpc3BsYXlTdGF0dXNEZXRhaWwgPSAkaTE4bi5uX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfaHRfdG9faHR4O1xuXHR9IGVsc2UgaWYgKHR5cGUgPT0gJ2dsb2JhbC1uZXdjdXJyZW5jeTAyLXN5c3RlbS10by1zcG90Jykge1xuXHRcdGRpc3BsYXlTdGF0dXNEZXRhaWwgPSAkaTE4bi5uX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfaHR4O1xuXHR9IGVsc2UgaWYgKHR5cGUgPT0gJ2dsb2JhbC1YY3VycmVueWFpcmRvcnAwMi1zeXN0ZW0tdG8tc3BvdCcpIHtcblx0XHRkaXNwbGF5U3RhdHVzRGV0YWlsID0gJGkxOG4ubl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX3JlZGVtcHRpb25fdXBkYXRlX2h0eDtcblx0fSBlbHNlIGlmICh0eXBlID09ICdjb21tb24tdHJhbnNmZXInIHx8IHR5cGUgPT0gJ2NvbW1vbi10cmFuc2Zlci1pbicpIHtcblx0XHRpZiAoaXRlbV9leHRyYSAhPSBudWxsICYmIGl0ZW1fZXh0cmFbXCJzb3VyY2UtdHlwZVwiXSAhPSBudWxsKSB7XG5cdFx0XHRpZiAoaXRlbV9leHRyYVtcInNvdXJjZS10eXBlXCJdID09ICdzcG90LXRvLWxpbmVhci1zd2FwLWNvcHl0cmFkaW5nJykge1xuXHRcdFx0XHRkaXNwbGF5U3RhdHVzRGV0YWlsID0gJGkxOG4ubl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX3Nwb3RfdG9fY29weXRyYWRpbmc7XG5cdFx0XHR9IGVsc2UgaWYgKGl0ZW1fZXh0cmFbXCJzb3VyY2UtdHlwZVwiXSA9PSAnbGluZWFyLXN3YXAtY29weXRyYWRpbmctdG8tc3BvdCcpIHtcblx0XHRcdFx0ZGlzcGxheVN0YXR1c0RldGFpbCA9ICRpMThuLm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9jb3B5dHJhZGluZ190b19zcG90O1xuXHRcdFx0fVxuXHRcdH1cblx0fSBlbHNlIGlmICh0eXBlID09ICdnbG9iYWwtaHR4dHJhZGVtaW5pbmcwNi1zcG90LXRvLXN5c3RlbScpIHtcblx0XHRkaXNwbGF5U3RhdHVzRGV0YWlsID0gJGkxOG4ubl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX2h0eHRyYWRlbWluaW5nMDZfc3BvdF90b19zeXN0ZW07XG5cdH0gZWxzZSBpZiAodHlwZSA9PSAnZ2xvYmFsLWh0eHRyYWRlbWluaW5nMDUtc3lzdGVtLXRvLXNwb3QnKSB7XG5cdFx0ZGlzcGxheVN0YXR1c0RldGFpbCA9ICRpMThuLm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9odHh0cmFkZW1pbmluZzA1X3N5c3RlbV90b19zcG90O1xuXHR9IGVsc2UgaWYgKHR5cGUgPT0gJ2dsb2JhbC1odHhjb250cmFjdHRyYWRlbWluaW5nMDUtc3lzdGVtLXRvLXNwb3QnKSB7XG5cdFx0ZGlzcGxheVN0YXR1c0RldGFpbCA9ICRpMThuLm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9odHhjb250cmFjdHRyYWRlbWluaW5nMDVfc3lzdGVtX3RvX3Nwb3Q7XG5cdH0gZWxzZSBpZiAodHlwZSA9PSAnZ2xvYmFsLWh0eGNvbnRyYWN0dHJhZGVtaW5pbmcwNi1zcG90LXRvLXN5c3RlbScpIHtcblx0XHRkaXNwbGF5U3RhdHVzRGV0YWlsID0gJGkxOG4ubl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX2h0eGNvbnRyYWN0dHJhZGVtaW5pbmcwNl9zcG90X3RvX3N5c3RlbTtcblx0fSBlbHNlIGlmICh0eXBlID09ICdnbG9iYWwtbWFrZXJtaW5pbmcwMy1zeXN0ZW0tdG8tc3BvdCcpIHtcblx0XHRkaXNwbGF5U3RhdHVzRGV0YWlsID0gJGkxOG4ubl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX21ha2VybWluaW5nMDNfc3lzdGVtX3RvX3Nwb3Q7XG5cdH0gZWxzZSBpZiAodHlwZSA9PSAnZ2xvYmFsLW1ha2VybWluaW5nMDQtc3BvdC10by1zeXN0ZW0nKSB7XG5cdFx0ZGlzcGxheVN0YXR1c0RldGFpbCA9ICRpMThuLm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9tYWtlcm1pbmluZzA0X3Nwb3RfdG9fc3lzdGVtO1xuXHR9IGVsc2UgaWYgKHR5cGUgPT0gJ2dsb2JhbC1oeWdkd2swMy1zeXN0ZW0tdG8tc3BvdCcpIHtcblx0XHRkaXNwbGF5U3RhdHVzRGV0YWlsID0gJGkxOG4ubl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX2h5Z2R3azAzX3N5c3RlbV90b19zcG90O1xuXHR9IGVsc2UgaWYgKHR5cGUgPT0gJ2dsb2JhbC1oeWdkd2swNC1zcG90LXRvLXN5c3RlbScpIHtcblx0XHRkaXNwbGF5U3RhdHVzRGV0YWlsID0gJGkxOG4ubl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX2h5Z2R3azA0X3Nwb3RfdG9fc3lzdGVtO1xuXHR9IGVsc2UgaWYgKHR5cGUgPT0gJ3RyYWRlLWZlZS1kZWR1Y3Rpb24tcGF5LXVzZXItdHJhZGUtdG8tbWF0Y2gnKSB7XG5cdFx0ZGlzcGxheVN0YXR1c0RldGFpbCA9ICRpMThuLm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF90cmFkZV90b19tYXRjaDtcblx0fSBlbHNlIGlmICh0eXBlID09ICd0cmFkZS1mZWUtZGVkdWN0aW9uLXBheS11c2VyLXRyYWRlLXRvLW1hdGNoLXBhcmVudCcpIHtcblx0XHRkaXNwbGF5U3RhdHVzRGV0YWlsID0gJGkxOG4ubl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX3RyYWRlX3RvX21hdGNoX3BhcmVudDtcblx0fSBlbHNlIGlmICh0eXBlID09ICdzcG90LXRvLXN1Yi10cmFkZScpIHtcblx0XHRkaXNwbGF5U3RhdHVzRGV0YWlsID0gJGkxOG4ubl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX3Nwb3RfdG9fc3VidHJhZGU7XG5cdH0gZWxzZSBpZiAodHlwZSA9PSAnc3ViLXRyYWRlLXRvLXNwb3QnKSB7XG5cdFx0ZGlzcGxheVN0YXR1c0RldGFpbCA9ICRpMThuLm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9zdWJ0cmFkZV90b19zcG90O1xuXHR9IGVsc2UgaWYgKHR5cGUgPT0gJ2dsb2JhbC1pbmNvbWVmcm9tdWlkMS1zcG90LXRvLXN5c3RlbScpIHtcblx0XHRkaXNwbGF5U3RhdHVzRGV0YWlsID0gJGkxOG4ubl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX2luY29tZV9zcG90X3RvX3N5c3RlbTtcblx0fSBlbHNlIGlmICh0eXBlID09ICdnbG9iYWwtcmVzdGFraW5ncmV3YXJkMDEtc3lzdGVtLXRvLXNwb3QnKSB7XG5cdFx0ZGlzcGxheVN0YXR1c0RldGFpbCA9ICRpMThuLm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9yZXN0YWtpbmdfc3lzdGVtX3RvX3Nwb3Q7XG5cdH0gZWxzZSBpZiAodHlwZSA9PSAnZ2xvYmFsLWNvdXBvbi1zeXN0ZW0tdG8tc3BvdCcpIHtcblx0XHRkaXNwbGF5U3RhdHVzRGV0YWlsID0gJGkxOG4ubl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX2NvdXBvbl9zeXN0ZW1fdG9fc3BvdDtcblx0fSBlbHNlIGlmICh0eXBlID09ICdwcmVwYXltZW50X3N5c3RlbV90b19zcG90Jykge1xuXHRcdGRpc3BsYXlTdGF0dXNEZXRhaWwgPSAkaTE4bi5uX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfcHJlcGF5bWVudF9zeXN0ZW1fdG9fc3BvdDtcblx0fSBlbHNlIGlmICh0eXBlID09ICdwcmVwYXltZW50X3N5c3RlbV90b19tYXJnaW5fdHJhZGUnKSB7XG5cdFx0ZGlzcGxheVN0YXR1c0RldGFpbCA9ICRpMThuLm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9wcmVwYXltZW50X3N5c3RlbV90b19tYXJnaW5fdHJhZGU7XG5cdH0gZWxzZSBpZiAodHlwZSA9PSAncHJlcGF5bWVudF9zeXN0ZW1fdG9fc3VwZXJtYXJnaW5fdHJhZGUnKSB7XG5cdFx0ZGlzcGxheVN0YXR1c0RldGFpbCA9ICRpMThuLm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9wcmVwYXltZW50X3N5c3RlbV90b19zdXBlcm1hcmdpbl90cmFkZTtcblx0fSBlbHNlIGlmICh0eXBlID09ICdwcmVwYXltZW50X3N5c3RlbV90b19jcnlwdG9sb2FuX3RyYWRlJykge1xuXHRcdGRpc3BsYXlTdGF0dXNEZXRhaWwgPSAkaTE4bi5uX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfcHJlcGF5bWVudF9zeXN0ZW1fdG9fY3J5cHRvbG9hbl90cmFkZTtcblx0fSBlbHNlIGlmICh0eXBlID09ICdwcmVwYXltZW50X3JlcGF5MF9zcG90X3RvX3N5c3RlbScpIHtcblx0XHRkaXNwbGF5U3RhdHVzRGV0YWlsID0gJGkxOG4ubl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX3ByZXBheW1lbnRfcmVwYXkwX3Nwb3RfdG9fc3lzdGVtO1xuXHR9IGVsc2UgaWYgKHR5cGUgPT0gJ3ByZXBheW1lbnRfcmVwYXkxX3Nwb3RfdG9fc3lzdGVtJykge1xuXHRcdGRpc3BsYXlTdGF0dXNEZXRhaWwgPSAkaTE4bi5uX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfcHJlcGF5bWVudF9yZXBheTFfc3BvdF90b19zeXN0ZW07XG5cdH0gZWxzZSBpZiAodHlwZSA9PSAncHJlcGF5bWVudF9yZXBheTJfc3BvdF90b19zeXN0ZW0nKSB7XG5cdFx0ZGlzcGxheVN0YXR1c0RldGFpbCA9ICRpMThuLm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9wcmVwYXltZW50X3JlcGF5Ml9zcG90X3RvX3N5c3RlbTtcblx0fSBlbHNlIGlmICh0eXBlID09ICdwcmVwYXltZW50X3JlcGF5M19zcG90X3RvX3N5c3RlbScpIHtcblx0XHRkaXNwbGF5U3RhdHVzRGV0YWlsID0gJGkxOG4ubl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX3ByZXBheW1lbnRfcmVwYXkzX3Nwb3RfdG9fc3lzdGVtO1xuXHR9IGVsc2UgaWYgKHR5cGUgPT0gJ3ByZXBheW1lbnRfcmVwYXk0X3Nwb3RfdG9fc3lzdGVtJykge1xuXHRcdGRpc3BsYXlTdGF0dXNEZXRhaWwgPSAkaTE4bi5uX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfcHJlcGF5bWVudF9yZXBheTRfc3BvdF90b19zeXN0ZW07XG5cdH0gZWxzZSBpZiAodHlwZSA9PSAncHJlcGF5bWVudF9yZXBheTVfc3BvdF90b19zeXN0ZW0nKSB7XG5cdFx0ZGlzcGxheVN0YXR1c0RldGFpbCA9ICRpMThuLm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9wcmVwYXltZW50X3JlcGF5NV9zcG90X3RvX3N5c3RlbTtcblx0fSBlbHNlIGlmICh0eXBlID09ICdwcmVwYXltZW50X3JlcGF5Nl9zcG90X3RvX3N5c3RlbScpIHtcblx0XHRkaXNwbGF5U3RhdHVzRGV0YWlsID0gJGkxOG4ubl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX3ByZXBheW1lbnRfcmVwYXk2X3Nwb3RfdG9fc3lzdGVtO1xuXHR9IGVsc2UgaWYgKHR5cGUgPT0gJ2dsb2JhbC1sYXVuY2hwb29sMDEtc3lzdGVtLXRvLXNwb3QnKSB7XG5cdFx0ZGlzcGxheVN0YXR1c0RldGFpbCA9ICRpMThuLm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9sYXVuY2hwb29sMDFfc3lzdGVtX3RvX3Nwb3Q7XG5cdH0gZWxzZSBpZiAodHlwZSA9PSAnZ2xvYmFsLWxhdW5jaHBvb2wwMi1zcG90LXRvLXN5c3RlbScpIHtcblx0XHRkaXNwbGF5U3RhdHVzRGV0YWlsID0gJGkxOG4ubl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX2xhdW5jaHBvb2wwMl9zcG90X3RvX3N5c3RlbTtcbiAgfSBlbHNlIGlmICh0eXBlID09ICdnbG9iYWwtcmViYXRlLWJyb2tlcmFnZS10by1zcG90LWJyb2tlcmFnZScgfHxcbiAgICB0eXBlID09ICdnbG9iYWwtcmViYXRlLWJyb2tlcmFnZS10by1zcG90LWJyb2tlcmFnZS1odHgnIHx8XG4gICAgdHlwZSA9PSAnZ2xvYmFsLXJlYmF0ZS1icm9rZXJhZ2UtdG8tc3BvdC1icm9rZXJhZ2UtdHJ4JyB8fFxuICAgIHR5cGUgPT0gJ21hdGNoaW5nLWZlZS1icm9rZXJhZ2UtaHQnIHx8XG4gICAgdHlwZSA9PSAnbWF0Y2hpbmctZmVlLWJyb2tlcmFnZScgfHwgXG4gICAgdHlwZSA9PSAnZnV0dXJlcy1icm9rZXJhZ2UtdG8tc3BvdCcgfHxcblx0XHR0eXBlID09ICdmdXR1cmVzLWJyb2tlcmFnZS10by1zcG90LWh0eCcgfHxcblx0XHR0eXBlID09ICdmdXR1cmVzLWJyb2tlcmFnZS10by1zcG90LXRyeCcgfHxcbiAgICB0eXBlID09ICdnbG9iYWwtcmViYXRlLWJyb2tlcmFnZS10by1zcG90LTJuZCcpIHtcblx0XHRkaXNwbGF5U3RhdHVzRGV0YWlsID0gJGkxOG4ubl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX3JlYmF0ZV9jYXNoYmFjazsgLy8g6YKA6K+35Lqk5piT5aWW5YqxXG5cdH0gZWxzZSBpZiAodHlwZSA9PSAnZ2xvYmFsLXJlYmF0ZS1icm9rZXJhZ2UtdG8tc3BvdC1jYXNoYmFjaycgfHxcbiAgICB0eXBlID09ICdnbG9iYWwtcmViYXRlLWJyb2tlcmFnZS10by1zcG90LWNhc2hiYWNrLWh0eCcgfHxcbiAgICB0eXBlID09ICdnbG9iYWwtcmViYXRlLWJyb2tlcmFnZS10by1zcG90LWNhc2hiYWNrLXRyeCcgfHxcbiAgICB0eXBlID09ICdmdXR1cmVzLWNhc2hiYWNrLW9wZXJhdGlvbi10by1zcG90JyB8fFxuICAgIHR5cGUgPT0gJ2Z1dHVyZXMtY2FzaGJhY2stb3BlcmF0aW9uLXRvLXNwb3QtaHR4JyB8fFxuICAgIHR5cGUgPT0gJ2Z1dHVyZXMtY2FzaGJhY2stb3BlcmF0aW9uLXRvLXNwb3QtdHJ4Jykge1xuXHRcdGRpc3BsYXlTdGF0dXNEZXRhaWwgPSAkaTE4bi5uX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfcmViYXRlX2Jyb2tlcmFnZTsgLy/kuqTmmJPlpZblirFcblx0fSBlbHNlIGlmICh0eXBlID09ICdnbG9iYWwtQ2hhbXBpb25zaGlwMDEtc3lzdGVtLXRvLXNwb3QnKSB7XG5cdFx0ZGlzcGxheXNTdGF0dXNEZXRhaWwgPSAkaTE4bi5uX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfY2hhbXBpb25zaGlwMDFfc3lzdGVtX3RvX3Nwb3Q7XG5cdH0gZWxzZSBpZiAodHlwZSA9PSAnZ2xvYmFsLXRyYWRlZXZlbnQwMS1zeXN0ZW0tdG8tc3BvdCcgfHwgXG5cdFx0dHlwZSA9PSAnZ2xvYmFsLXRyYWRlZXZlbnQwMi1zcG90LXRvLXN5c3RlbScpIHtcblx0XHRcdGRpc3BsYXlTdGF0dXNEZXRhaWwgPSAkaTE4bi5uX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfdHJhZGVldmVudDAxX3N5c3RlbV90b19zcG90O1xuICB9IGVsc2UgaWYgKHR5cGUgPT0gJ2dsb2JhbC1jb21tdW5pdHlhaXJkcm9wMDMtc3lzdGVtLXRvLXNwb3QnKSB7XG4gICAgZGlzcGxheVN0YXR1c0RldGFpbCA9ICRpMThuLm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9nbG9iYWxfY29tbXVuaXR5YWlyZHJvcDAzX3N5c3RlbV90b19zcG90O1xuICB9IGVsc2UgaWYgKHR5cGUgPT0gJ2dsb2JhbC1jb21tdW5pdHlhaXJkcm9wMDQtc3BvdC10by1zeXN0ZW0nKSB7XG4gICAgZGlzcGxheVN0YXR1c0RldGFpbCA9ICRpMThuLm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9nbG9iYWxfY29tbXVuaXR5YWlyZHJvcDA0X3Nwb3RfdG9fc3lzdGVtO1xuXHR9IGVsc2UgaWYgKHR5cGUgPT0gJ2dsb2JhbC1SZWRlbnZlbG9wZTAxLXNwb3QtdG8tc3lzdGVtJyB8fFxuXHRcdHR5cGUgPT0gJ2dsb2JhbC1SZWRlbnZlbG9wZTA0LXNwb3QtdG8tc3lzdGVtJyB8fFxuXHRcdHR5cGUgPT0gJ2dsb2JhbC1SZWRlbnZlbG9wZTA3LXNwb3QtdG8tc3lzdGVtJyB8fFxuXHRcdHR5cGUgPT0gJ2dsb2JhbC1SZWRlbnZlbG9wZTEwLXNwb3QtdG8tc3lzdGVtJykge1xuXHRcdGRpc3BsYXlTdGF0dXNEZXRhaWwgPSAkaTE4bi5uX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfcmVkZW52ZWxvcGVfc3BvdF90b19zeXN0ZW07IC8v5Y+R5Ye6QzJD57qi5YyFXG5cdH0gZWxzZSBpZiAodHlwZSA9PSAnZ2xvYmFsLVJlZGVudmVsb3BlMDItc3lzdGVtLXRvLXNwb3QnIHx8XG5cdFx0dHlwZSA9PSAnZ2xvYmFsLVJlZGVudmVsb3BlMDUtc3lzdGVtLXRvLXNwb3QnIHx8XG5cdFx0dHlwZSA9PSAnZ2xvYmFsLVJlZGVudmVsb3BlMDgtc3lzdGVtLXRvLXNwb3QnIHx8XG5cdFx0dHlwZSA9PSAnZ2xvYmFsLVJlZGVudmVsb3BlMTEtc3lzdGVtLXRvLXNwb3QnKSB7XG5cdFx0ZGlzcGxheVN0YXR1c0RldGFpbCA9ICRpMThuLm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9yZWRlbnZlbG9wZV9zeXN0ZW1fdG9fc3BvdDsgLy/pooblj5ZDMkPnuqLljIVcblx0fSBlbHNlIGlmICh0eXBlID09ICdnbG9iYWwtUmVkZW52ZWxvcGUwMy1zeXN0ZW0tdG8tc3BvdCcgfHxcblx0XHR0eXBlID09ICdnbG9iYWwtUmVkZW52ZWxvcGUwNi1zeXN0ZW0tdG8tc3BvdCcgfHxcblx0XHR0eXBlID09ICdnbG9iYWwtUmVkZW52ZWxvcGUwOS1zeXN0ZW0tdG8tc3BvdCcgfHxcblx0XHR0eXBlID09ICdnbG9iYWwtUmVkZW52ZWxvcGUxMi1zeXN0ZW0tdG8tc3BvdCcpIHtcblx0XHRkaXNwbGF5U3RhdHVzRGV0YWlsID0gJGkxOG4ubl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX3JlZGVudmVsb3BlX3JlZnVuZF9zeXN0ZW1fdG9fc3BvdDsgLy/pgIDmrL4tQzJD57qi5YyF5pyq5Y+R5pS+5a6M5q+VXG5cdH1cblx0cmV0dXJuIGRpc3BsYXlTdGF0dXNEZXRhaWw7XG59XG4iLCJpbXBvcnQgKiBhcyBjb21tb24gZnJvbSBcIi4vY29tbW9uXCI7XG5pbXBvcnQgeyBhZGQsIGZvcm1hdCwgbXVsdGlwbHkgfSBmcm9tIFwiLi9udW1iZXJcIjtcbmltcG9ydCAqIGFzIGZpbmFuY2VDbGFzcyBmcm9tIFwiLi9maW5hbmNlaGlzdG9yeVwiO1xuXG52YXIgcmVxdWVzdEN1cnJlbmN5ID0gXCJcIjtcbnZhciBjdXJyZW5jeVN5bWJvbCA9IFwiXCI7XG52YXIgY3VycmVuY3lOYW1lID0gXCJcIjtcbnZhciBlYXJuSXRlbVVybCA9IFwiXCI7XG52YXIgZWFybkp1bXBVcmwgPSBcIlwiO1xudmFyIHRvZGF5UHJvZml0UmF0ZSA9IFwiMFwiO1xudmFyIHN0YWJsZSA9IGZhbHNlO1xudmFyIHR5cGVzID0gXCJ3aXRoZHJhd1wiO1xudmFyIHJlcVN0YXJ0RGF0ZSwgcmVxRW5kRGF0ZTtcbnZhciBsYXN0VGFiSW5kZXggPSAwO1xuXG5jb25zdCBvcmlnaW5HcmlkRGF0YSA9IFtcblx0e1xuXHRcdGNlbGxUeXBlOiBcIjFcIixcblx0XHRuYW1lOiAkaTE4bi5uX2Fzc2V0X2NvaW5kZXRhaWxfYXZhaWxhYmxlLFxuXHRcdHZhbHVlOiBcIi0tXCIsXG5cdFx0dmFsdWVSYXRlOiBcIlwiLFxuXHRcdHJhdGVTaG93OiBcImdvbmVcIixcblx0XHRsaW5lU2hvdzogXCJnb25lXCIsXG5cdFx0aGVpZ2h0OiBcIjU0XCIsXG5cdFx0cG9wVHlwZTogMCxcblx0fSxcblx0e1xuXHRcdGNlbGxUeXBlOiBcIjFcIixcblx0XHRuYW1lOiAkaTE4bi5uX2Fzc2V0X2NvaW5kZXRhaWxfbG9ja2VkLFxuXHRcdHZhbHVlOiBcIi0tXCIsXG5cdFx0dmFsdWVSYXRlOiBcIlwiLFxuXHRcdHJhdGVTaG93OiBcImdvbmVcIixcblx0XHRsaW5lU2hvdzogXCJ2aXNpYmxlXCIsXG5cdFx0aGVpZ2h0OiBcIjU0XCIsXG5cdFx0cG9wVHlwZTogMSxcblx0fSxcblx0e1xuXHRcdGNlbGxUeXBlOiBcIjFcIixcblx0XHRuYW1lOiAkaTE4bi5uX2Fzc2V0X2NvaW5kZXRhaWxfbGFzdF9wcmljZSxcblx0XHR2YWx1ZTogXCItLVwiLFxuXHRcdHZhbHVlUmF0ZTogXCJcIixcblx0XHRyYXRlU2hvdzogXCJnb25lXCIsXG5cdFx0bGluZVNob3c6IFwiZ29uZVwiLFxuXHRcdGhlaWdodDogXCI1NFwiLFxuXHRcdHBvcFR5cGU6IDAsXG5cdH0sXG5cdHtcblx0XHRjZWxsVHlwZTogXCIxXCIsXG5cdFx0bmFtZTogJGkxOG4ubl9hc3NldF9jb2luZGV0YWlsX2Nvc3RfcHJpY2UsXG5cdFx0dmFsdWU6IFwiLS1cIixcblx0XHR2YWx1ZVJhdGU6IFwiXCIsXG5cdFx0cmF0ZVNob3c6IFwiZ29uZVwiLFxuXHRcdGxpbmVTaG93OiBcInZpc2libGVcIixcblx0XHRoZWlnaHQ6IFwiNTRcIixcblx0XHRwb3BUeXBlOiAyLFxuXHR9LFxuXHR7XG5cdFx0Y2VsbFR5cGU6IFwiMVwiLFxuXHRcdG5hbWU6ICRpMThuLm5fdG9kYXlfcHJvZml0LFxuXHRcdHZhbHVlOiBcIi0tXCIsXG5cdFx0dmFsdWVSYXRlOiBcIlwiLFxuXHRcdHJhdGVTaG93OiBcInZpc2libGVcIixcblx0XHRsaW5lU2hvdzogXCJ2aXNpYmxlXCIsXG5cdFx0aGVpZ2h0OiBcIjc4XCIsXG5cdFx0cG9wVHlwZTogMyxcblx0fSxcblx0e1xuXHRcdGNlbGxUeXBlOiBcIjFcIixcblx0XHRuYW1lOiAkaTE4bi5uX2Fzc2V0X2NvaW5kZXRhaWxfdG90YWxfcG5sLFxuXHRcdHZhbHVlOiBcIi0tXCIsXG5cdFx0dmFsdWVSYXRlOiBcIlwiLFxuXHRcdHJhdGVTaG93OiBcInZpc2libGVcIixcblx0XHRsaW5lU2hvdzogXCJ2aXNpYmxlXCIsXG5cdFx0aGVpZ2h0OiBcIjc4XCIsXG5cdFx0cG9wVHlwZTogNCxcblx0fVxuXTtcblxuY29uc3QgaGlzdG9yeVR5cGVzID0gW1xuXHR7XG5cdFx0XCJ0eXBlXCI6ICd0YWInLFxuXHRcdGluZGV4OiAwLFxuXHRcdFwidGV4dFwiOiAkaTE4bi5uX2NvaW5kZXRhaWxfaGlzdG9yeV93aXRoZHJhdyxcblx0XHR0ZXh0Q29sb3I6IFwiQGNvbG9yL2tDb2xvclByaW1hcnlUZXh0XCIsXG5cdFx0YmdDb2xvcjogXCJAY29sb3IvS0Jhc2VDb2xvcklucHV0QmFja2dyb3VuZFwiLFxuXHRcdGdyb3VwVHlwZTogZmluYW5jZUNsYXNzLkZpbmFuY2VHcm91cFR5cGUuU1BPVF9XSVRIRFJBV1xuXHR9LCB7XG5cdFx0XCJ0eXBlXCI6ICd0YWInLFxuXHRcdGluZGV4OiAxLFxuXHRcdFwidGV4dFwiOiAkaTE4bi5uX2NvaW5kZXRhaWxfaGlzdG9yeV9kZXBvc2l0LFxuXHRcdHRleHRDb2xvcjogXCJAY29sb3Iva0NvbG9yU2Vjb25kYXJ5VGV4dFwiLFxuXHRcdGJnQ29sb3I6IFwiQGNvbG9yL0tCYXNlQ29sb3JDb250ZW50QmFja2dyb3VuZFwiLFxuXHRcdGdyb3VwVHlwZTogZmluYW5jZUNsYXNzLkZpbmFuY2VHcm91cFR5cGUuU1BPVF9ERVBPU0lUXG5cdH0sIHtcblx0XHRcInR5cGVcIjogJ3RhYicsXG5cdFx0aW5kZXg6IDIsXG5cdFx0XCJ0ZXh0XCI6ICRpMThuLm5fY29pbmRldGFpbF9oaXN0b3J5X2luLFxuXHRcdHRleHRDb2xvcjogXCJAY29sb3Iva0NvbG9yU2Vjb25kYXJ5VGV4dFwiLFxuXHRcdGJnQ29sb3I6IFwiQGNvbG9yL0tCYXNlQ29sb3JDb250ZW50QmFja2dyb3VuZFwiLFxuXHRcdGdyb3VwVHlwZTogZmluYW5jZUNsYXNzLkZpbmFuY2VHcm91cFR5cGUuU1BPVF9UUkFOU0ZFUl9JTlxuXHR9LCB7XG5cdFx0XCJ0eXBlXCI6ICd0YWInLFxuXHRcdGluZGV4OiAzLFxuXHRcdFwidGV4dFwiOiAkaTE4bi5uX2NvaW5kZXRhaWxfaGlzdG9yeV9vdXQsXG5cdFx0dGV4dENvbG9yOiBcIkBjb2xvci9rQ29sb3JTZWNvbmRhcnlUZXh0XCIsXG5cdFx0YmdDb2xvcjogXCJAY29sb3IvS0Jhc2VDb2xvckNvbnRlbnRCYWNrZ3JvdW5kXCIsXG5cdFx0Z3JvdXBUeXBlOiBmaW5hbmNlQ2xhc3MuRmluYW5jZUdyb3VwVHlwZS5TUE9UX1RSQU5TRkVSX09VVFxuXHR9LCB7XG5cdFx0XCJ0eXBlXCI6ICd0YWInLFxuXHRcdGluZGV4OiA0LFxuXHRcdFwidGV4dFwiOiAkaTE4bi5uX2NvaW5kZXRhaWxfaGlzdG9yeV9vdGhlcixcblx0XHR0ZXh0Q29sb3I6IFwiQGNvbG9yL2tDb2xvclNlY29uZGFyeVRleHRcIixcblx0XHRiZ0NvbG9yOiBcIkBjb2xvci9LQmFzZUNvbG9yQ29udGVudEJhY2tncm91bmRcIixcblx0XHRncm91cFR5cGU6IGZpbmFuY2VDbGFzcy5GaW5hbmNlR3JvdXBUeXBlLlNQT1RfU1lTVEVNXG5cdH0sIHtcblx0XHRcInR5cGVcIjogJ3RhYicsXG5cdFx0aW5kZXg6IDUsXG5cdFx0XCJ0ZXh0XCI6ICRpMThuLm5fY29pbmRldGFpbF9oaXN0b3J5X3BvaW50LFxuXHRcdHRleHRDb2xvcjogXCJAY29sb3Iva0NvbG9yU2Vjb25kYXJ5VGV4dFwiLFxuXHRcdGJnQ29sb3I6IFwiQGNvbG9yL0tCYXNlQ29sb3JDb250ZW50QmFja2dyb3VuZFwiLFxuXHRcdGdyb3VwVHlwZTogZmluYW5jZUNsYXNzLkZpbmFuY2VHcm91cFR5cGUuU1BPVF9QT0lOVFxuXHR9XG5dO1xuXG5jb25zdCBzbGlkZXJEYXRhID0gW1xuXHR7XG5cdFx0XCJsaXN0VHlwZVwiOiAnc2xpZGVyQ2VsbCcsXG5cdFx0Y2VsbERhdGE6IFtdLFxuXHRcdHNsaWRlcklkOiAwLFxuXHRcdGZyb21JZDogMCxcblx0XHRuZWVkTW9yZTogZmFsc2UsXG5cdFx0dGFibGVIZWlnaHQ6IDI4MFxuXHR9LCB7XG5cdFx0XCJsaXN0VHlwZVwiOiAnc2xpZGVyQ2VsbCcsXG5cdFx0Y2VsbERhdGE6IFtdLFxuXHRcdHNsaWRlcklkOiAxLFxuXHRcdGZyb21JZDogMCxcblx0XHRuZWVkTW9yZTogZmFsc2UsXG5cdFx0dGFibGVIZWlnaHQ6IDI4MFxuXHR9LCB7XG5cdFx0XCJsaXN0VHlwZVwiOiAnc2xpZGVyQ2VsbCcsXG5cdFx0Y2VsbERhdGE6IFtdLFxuXHRcdHNsaWRlcklkOiAyLFxuXHRcdGZyb21JZDogMCxcblx0XHRuZWVkTW9yZTogZmFsc2UsXG5cdFx0dGFibGVIZWlnaHQ6IDI4MFxuXHR9LCB7XG5cdFx0XCJsaXN0VHlwZVwiOiAnc2xpZGVyQ2VsbCcsXG5cdFx0Y2VsbERhdGE6IFtdLFxuXHRcdHNsaWRlcklkOiAzLFxuXHRcdGZyb21JZDogMCxcblx0XHRuZWVkTW9yZTogZmFsc2UsXG5cdFx0dGFibGVIZWlnaHQ6IDI4MFxuXHR9LCB7XG5cdFx0XCJsaXN0VHlwZVwiOiAnc2xpZGVyQ2VsbCcsXG5cdFx0Y2VsbERhdGE6IFtdLFxuXHRcdHNsaWRlcklkOiA0LFxuXHRcdGZyb21JZDogMCxcblx0XHRuZWVkTW9yZTogZmFsc2UsXG5cdFx0dGFibGVIZWlnaHQ6IDI4MFxuXHR9LCB7XG5cdFx0XCJsaXN0VHlwZVwiOiAnc2xpZGVyQ2VsbCcsXG5cdFx0Y2VsbERhdGE6IFtdLFxuXHRcdHNsaWRlcklkOiA1LFxuXHRcdGZyb21JZDogMCxcblx0XHRuZWVkTW9yZTogZmFsc2UsXG5cdFx0dGFibGVIZWlnaHQ6IDI4MFxuXHR9XG5dO1xuXG5mdW5jdGlvbiBkZWZhdWx0RGF0YSgpIHtcblx0cmV0dXJuIHtcblx0XHRjb2luTG9nbzogXCJcIixcblx0XHRkaXNwbGF5TmFtZTogXCJcIixcblx0XHRjdXJyZW5jeUNvZGU6IFwiXCIsXG5cdFx0Z3JpZERhdGE6IG9yaWdpbkdyaWREYXRhLFxuXHRcdGNvaW5Db250ZW50czogW10sXG5cdFx0ZWFyblRleHQ6IFwiXCIsXG5cdFx0aGlzdG9yeUxpc3Q6IFtdLFxuXHRcdHJlZnJlc2hTdGF0dXM6IDAsLy/liLfmlrDnirbmgIFcblx0XHRsb2FkTW9yZVN0YXR1czogMCwvL+WKoOi9veeKtuaAgVxuXHRcdGhpc3RvcnlUaXRsZUtMaW5lUHJpY2U6IFwiXCIsXG5cdFx0aGlzdG9yeVRpdGxlUHJpY2U6IFwiXCIsXG5cdFx0cG9wU2hvdzogZmFsc2UsXG5cdFx0cG9wVGl0bGU6IFwiXCIsXG5cdFx0cG9wU3R5bGUxOiBcImdvbmVcIixcblx0XHRwb3BTdHlsZTI6IFwiZ29uZVwiLFxuXHRcdHJlY29yZFRhYkluZGV4OiAwLFxuXHRcdGhpc3RvcnlUeXBlczogaGlzdG9yeVR5cGVzLFxuXHRcdHNsaWRlckRhdGE6IHNsaWRlckRhdGEsXG5cdFx0bGF1bmNoUG9vbFZpc2liOiBcImdvbmVcIixcblx0fTtcbn1cblxuY29uc3QgeyBtb2R1bGVEYXRhLCBtb2R1bGVFdmVudCB9ID0gY29tbW9uLm1vZHVsZURlZmluZShcImNvaW5kZXRhaWxcIiwgZGVmYXVsdERhdGEsIHsgb25DcmVhdGUsIG9uRGVzdHJveSB9KTtcblxuLy8gb25DcmVhdGUoSlNPTi5zdHJpbmdpZnkoe2N1cnJlbmN5OiBcInVzZHRcIn0pKTtcblxuZnVuY3Rpb24gb25EZXN0cm95KCkge1xufVxuXG5mdW5jdGlvbiBvbkNyZWF0ZShqc29uUGFyYW1ldGVycykge1xuXHQvLyDkv67lpI3kuqTmmJPpobXov5vluIHnp43or6bmg4XmlbDmja7pl67pophcblx0dHlwZXMgPSBcIndpdGhkcmF3XCI7XG5cdHRvZGF5UHJvZml0UmF0ZSA9IFwiMFwiO1xuXHRtb2R1bGVEYXRhLnJlY29yZFRhYkluZGV4ID0gMDtcblx0bW9kdWxlRGF0YS5ncmlkRGF0YSA9IG9yaWdpbkdyaWREYXRhO1xuXHRtb2R1bGVEYXRhLmNvaW5Db250ZW50cyA9IFtdO1xuXHRtb2R1bGVEYXRhLmhpc3RvcnlMaXN0ID0gW107XG5cdG1vZHVsZURhdGEuaGlzdG9yeVR5cGVzID0gaGlzdG9yeVR5cGVzO1xuXHRtb2R1bGVEYXRhLnNsaWRlckRhdGEgPSBzbGlkZXJEYXRhO1xuXG5cdGxldCBwYXJhbWV0ZXIgPSBKU09OLnBhcnNlKGpzb25QYXJhbWV0ZXJzKTtcblx0Y29uc29sZS5sb2coYG9uQ3JlYXRlIC0tLS0tPiAgJHtKU09OLnN0cmluZ2lmeShwYXJhbWV0ZXIpfWApO1xuXHRpZiAocGFyYW1ldGVyLnN0YWJsZSAmJiBwYXJhbWV0ZXIuc3RhYmxlICE9IG51bGwpIHtcblx0XHRzdGFibGUgPSBwYXJhbWV0ZXIuc3RhYmxlO1xuXHR9XG5cdC8vIOWOhuWPsuiusOW9leaXtumXtFxuXHR2YXIgc3RhcnREYXRlID0gbmV3IERhdGUoKTtcblx0c3RhcnREYXRlLnNldEhvdXJzKDAsIDAsIDAsIDApO1xuXHRzdGFydERhdGUuc2V0RGF0ZShzdGFydERhdGUuZ2V0RGF0ZSgpIC0gMTc5KTtcblx0cmVxU3RhcnREYXRlID0gc3RhcnREYXRlLmdldFRpbWUoKTtcblx0dmFyIGVuZERhdGUgPSBuZXcgRGF0ZSgpO1xuXHRlbmREYXRlLnNldEhvdXJzKDIzLCA1OSwgNTksIDApO1xuXHRyZXFFbmREYXRlID0gZW5kRGF0ZS5nZXRUaW1lKCk7XG5cdGNvbnNvbGUubG9nKHN0YXJ0RGF0ZS5nZXRUaW1lKCksIGVuZERhdGUuZ2V0VGltZSgpKTtcblxuXHRpbml0Q3VycmVuY3lTeW1ib2woKTtcblx0cmVxdWVzdENvbnRlbnRJbmZvVjIocGFyYW1ldGVyWydjdXJyZW5jeSddKTtcblx0bW9kdWxlRGF0YS5yZWNvcmRUYWJJbmRleCA9IDA7XG5cdHJlcXVlc3RGaW5hbmNlSGlzdG9yeSgwKTtcblx0bGFzdFRhYkluZGV4ID0gMDtcbn1cblxuYXN5bmMgZnVuY3Rpb24gaW5pdEN1cnJlbmN5U3ltYm9sKCkge1xuXHRjdXJyZW5jeVN5bWJvbCA9IGF3YWl0IGNvbW1vbi5nZXRMZWdhbEN1cnJlbmN5U3ltYm9sKCk7XG5cdGN1cnJlbmN5TmFtZSA9IGF3YWl0ICRuYXRpdmVBUEkuY3VycmVuY3lDb21tb24oJ3tcInR5cGVcIjo0fScpO1xuXHRtb2R1bGVEYXRhLmhpc3RvcnlUaXRsZUtMaW5lUHJpY2UgPSAkaTE4bi4kaW50ZXJjZXB0Lm5fYXNzZXRfY29pbmRldGFpbF9rbGluZV9wcmljZShjdXJyZW5jeU5hbWUpO1xuXHRtb2R1bGVEYXRhLmhpc3RvcnlUaXRsZVByaWNlID0gJGkxOG4uJGludGVyY2VwdC5uX2Fzc2V0X2NvaW5kZXRhaWxfcHJpY2UoY3VycmVuY3lOYW1lKTtcbn1cblxuZnVuY3Rpb24gdmFsaWRTdHJpbmcoc3RyaW5nLCBkZWZhdWx0U3RyaW5nID0gXCJcIikge1xuXHRpZiAoc3RyaW5nICYmIHN0cmluZyAhPSBudWxsKSB7XG5cdFx0cmV0dXJuIHN0cmluZztcblx0fVxuXHRyZXR1cm4gZGVmYXVsdFN0cmluZztcbn1cblxuZnVuY3Rpb24gaGFuZGxlVG90YWxCYWxhbmNlUmljaCh0b3RhbCwgbWFya2V0KSB7XG5cdHZhciB0ZXh0Q29sb3IgPSBcIiMwMDAwMDBcIjtcblx0dmFyIGhpZ2hsaWdodENvbG9yID0gXCIjOEE4QThFXCI7XG5cdGlmIChjb21tb24uY29tbW9uRGF0YS5jb2xvck1vZGUgPT0gMSkge1xuXHRcdHRleHRDb2xvciA9IFwiI0U2RTZFNlwiXG5cdFx0aGlnaGxpZ2h0Q29sb3IgPSBcIiM1RTVFNjFcIjtcblx0fVxuXG5cdHJldHVybiBgPHNwYW4gc3R5bGU9XCJjb2xvcjoke3RleHRDb2xvcn07IGZvbnQtc2l6ZToyNnB4O1wiPiR7dG90YWx9PC9zcGFuPjxzcGFuIHN0eWxlPVwiY29sb3I6JHtoaWdobGlnaHRDb2xvcn07IGZvbnQtc2l6ZToxNHB4O1wiPiDiiYggJHttYXJrZXR9PC9zcGFuPmA7XG59XG5cbmFzeW5jIGZ1bmN0aW9uIGdldFJlYWxQcmljZShjdXJyZW5jeVN5bWJvbCwgdXNkdFByaWNlLCBwcmljZVNjYWxlKSB7XG5cdGlmIChjdXJyZW5jeVN5bWJvbCA9PSBcIuKCrlwiKSB7XG5cdFx0cHJpY2VTY2FsZSA9IDI7XG5cdH1cblx0bGV0IHJlc3VsdCA9IGF3YWl0IGNvbW1vbi5jb252ZXJ0TGVnYWxUZW5kZXIoJ3VzZHQnLCBgJHt1c2R0UHJpY2V9YCwgcHJpY2VTY2FsZSk7XG5cdGlmIChg4Li/YCA9PSBjdXJyZW5jeVN5bWJvbCAmJiB1c2R0UHJpY2UgIT0gMCAmJiByZXN1bHQgPT0gMCkge1xuXHRcdHJlc3VsdCA9IGA8MC4wMDAwMDAwMWA7XG5cdH1cblx0cmV0dXJuIGNvbW1vbi5hZGRDdXJyZW5jeVN5bWJvbChjdXJyZW5jeVN5bWJvbCwgcmVzdWx0KTtcbn1cblxuLy8gaHR0cHM6Ly93aWtpLmh1b2JpYXBwcy5jb20vcGFnZXMvdmlld3BhZ2UuYWN0aW9uP3BhZ2VJZD03ODk4Mjc1NFxuYXN5bmMgZnVuY3Rpb24gcmVxdWVzdENvbnRlbnRJbmZvVjIoY3VycmVuY3kgPSBcInVzZHRcIikge1xuXHRjb21tb24uc2hvd0xvYWRpbmcodHJ1ZSk7XG5cdGN1cnJlbmN5ID0gY3VycmVuY3kudG9Mb3dlckNhc2UoKTtcblx0cmVxdWVzdEN1cnJlbmN5ID0gY3VycmVuY3k7XG5cdGNvbnN0IHJlc0RhdGEgPSBhd2FpdCBjb21tb24uc2VuZFJlcXVlc3QoJ3YxL29wZW4vcHJvZml0L2NvbnRlbnQvaW5mby92MicsIHsgY3VycmVuY3kgfSk7XG5cdGlmICghcmVzRGF0YSB8fCByZXNEYXRhID09IG51bGwpIHtcblx0XHRjb21tb24uc2hvd0xvYWRpbmcoZmFsc2UpO1xuXHRcdG1vZHVsZURhdGEucmVmcmVzaFN0YXR1cyA9IDI7XG5cdFx0bW9kdWxlRGF0YS5sb2FkTW9yZVN0YXR1cyA9IDI7XG5cdFx0cmV0dXJuO1xuXHR9XG5cdGNvbnN0IHByaWNlU2NhbGUgPSBwYXJzZUludCh2YWxpZFN0cmluZyhyZXNEYXRhLm1hcmtldFByaWNlU2NhbGUsIFwiMlwiKSk7XG5cdGNvbnN0IGN1cnJlbmN5QW1vdW50U2hvd1NjYWxlID0gcGFyc2VJbnQodmFsaWRTdHJpbmcocmVzRGF0YS5jdXJyZW5jeUFtb3VudFNob3dTY2FsZSwgXCIyXCIpKTtcblx0bW9kdWxlRGF0YS5jb2luTG9nbyA9IGNvbW1vbi5nZXRQTkdJY29uVVJMQnlDdXJyZW5jeShtb2R1bGVEYXRhLmN1cnJlbmN5Q29kZSk7XG5cdC8vIGRpc3BsYXlOYW1lIOW4geenjeWxleekuuWQjeensFxuXHRtb2R1bGVEYXRhLmRpc3BsYXlOYW1lID0gdmFsaWRTdHJpbmcocmVzRGF0YS5kaXNwbGF5TmFtZSwgY3VycmVuY3kudG9VcHBlckNhc2UoKSk7XG5cdC8vIGN1cnJlbmN5Q29kZVx0U3RyaW5nXHTluIHnp43lpJbpg6jlkI3np7Bcblx0bW9kdWxlRGF0YS5jdXJyZW5jeUNvZGUgPSB2YWxpZFN0cmluZyhyZXNEYXRhLmN1cnJlbmN5Q29kZSwgY3VycmVuY3kpO1xuXHQvLyB0b3RhbEJhbGFuY2Ug5oC75pWw6YePXG5cdC8vIG1hcmtldFZhbHVlIFN0cmluZyDluILlgLzvvIhVU0RU77yJID0g5oC75pWw6YePICog5biC5Lu3XG5cdGNvbnN0IG1hcmtldFZhbHVlID0gYXdhaXQgZ2V0UmVhbFByaWNlKGN1cnJlbmN5U3ltYm9sLCB2YWxpZFN0cmluZyhyZXNEYXRhLm1hcmtldFZhbHVlLCBcIjBcIiksIDApO1xuXHRjb25zdCB0b3RhbEJhbGFuY2UgPSBhd2FpdCBjb21tb24uZm9ybWF0QnlNaW5QcmVjaXNpb24odmFsaWRTdHJpbmcocmVzRGF0YS50b3RhbEJhbGFuY2UsIFwiMFwiKSwgY3VycmVuY3lBbW91bnRTaG93U2NhbGUpO1xuXHRtb2R1bGVEYXRhLnRvdGFsQmFsYW5jZSA9IGhhbmRsZVRvdGFsQmFsYW5jZVJpY2godG90YWxCYWxhbmNlLCBtYXJrZXRWYWx1ZSk7XG5cdC8vIGVhcm5KdW1wVXJsXHRTdHJpbmdcdOWOu+i1muW4ge+8jOi3s+i9rOmTvuaOpVxuXHRlYXJuSnVtcFVybCA9IHZhbGlkU3RyaW5nKHJlc0RhdGEuZWFybkp1bXBVcmwsIFwiXCIpO1xuXHR2YXIgdG1wR3JpZERhdGEgPSBvcmlnaW5HcmlkRGF0YTtcblx0Ly8gYXZhaWxhYmxlTnVtIOeOsOi0p+WPr+eUqOaVsOmHj1xuXHR0bXBHcmlkRGF0YVswXS52YWx1ZSA9IGF3YWl0IGNvbW1vbi5mb3JtYXRCeU1pblByZWNpc2lvbih2YWxpZFN0cmluZyhyZXNEYXRhLmF2YWlsYWJsZU51bSwgXCIwXCIpLCBjdXJyZW5jeUFtb3VudFNob3dTY2FsZSk7XG5cdC8vIHN1c3BlbnNlTnVtIOeOsOi0p+WGu+e7k+aVsOmHjyBsb2NrTnVtIOmUgeS7k+aVsOmHj1xuXHR0bXBHcmlkRGF0YVsxXS52YWx1ZSA9IGF3YWl0IGNvbW1vbi5mb3JtYXRCeU1pblByZWNpc2lvbihhZGQodmFsaWRTdHJpbmcocmVzRGF0YS5zdXNwZW5zZU51bSwgXCIwXCIpLCB2YWxpZFN0cmluZyhyZXNEYXRhLmxvY2tOdW0sIFwiMFwiKSksIGN1cnJlbmN5QW1vdW50U2hvd1NjYWxlKTtcblx0bW9kdWxlRGF0YS5zdXNwZW5zZU51bSA9IGF3YWl0IGNvbW1vbi5mb3JtYXRCeU1pblByZWNpc2lvbih2YWxpZFN0cmluZyhyZXNEYXRhLnN1c3BlbnNlTnVtLCBcIjBcIiksIGN1cnJlbmN5QW1vdW50U2hvd1NjYWxlKTtcblx0bW9kdWxlRGF0YS5sb2NrTnVtID0gYXdhaXQgY29tbW9uLmZvcm1hdEJ5TWluUHJlY2lzaW9uKHZhbGlkU3RyaW5nKHJlc0RhdGEubG9ja051bSwgXCIwXCIpLCBjdXJyZW5jeUFtb3VudFNob3dTY2FsZSk7XG5cdC8vIG1hcmtldFByaWNlIOW4guS7tyAvLyBtYXJrZXRQcmljZVNjYWxlIOS7t+agvOeyvuW6piBcblx0dG1wR3JpZERhdGFbMl0udmFsdWUgPSBhd2FpdCBnZXRSZWFsUHJpY2UoY3VycmVuY3lTeW1ib2wsIHZhbGlkU3RyaW5nKHJlc0RhdGEubWFya2V0UHJpY2UsIFwiMFwiKSwgcHJpY2VTY2FsZSk7XG5cdC8vIGF2Z1Bvc2l0aW9uQ29zdCDmlrDlubPlnYfmjIHku5PmiJDmnKxcblx0dG1wR3JpZERhdGFbM10udmFsdWUgPSBhd2FpdCBnZXRSZWFsUHJpY2UoY3VycmVuY3lTeW1ib2wsIHZhbGlkU3RyaW5nKHJlc0RhdGEuYXZnUG9zaXRpb25Db3N0LCBcIjBcIiksIHByaWNlU2NhbGUpO1xuXHQvLyB0b2RheVByb2ZpdCDku4rml6XmlLbnm4ogemVyb1N0YXRlID0gMyDmmL7npLogLS0gXG5cdGlmIChyZXNEYXRhLnplcm9TdGF0ZSA9PSAzKSB7XG5cdFx0dG1wR3JpZERhdGFbNF0udmFsdWUgPSBcIi0tXCI7XG5cdH0gZWxzZSB7XG5cdFx0dG1wR3JpZERhdGFbNF0udmFsdWUgPSBhd2FpdCBnZXRSZWFsUHJpY2UoY3VycmVuY3lTeW1ib2wsIHZhbGlkU3RyaW5nKHJlc0RhdGEudG9kYXlQcm9maXQsIFwiMFwiKSwgXCIyXCIpO1xuXHR9XG5cdC8vIHRvZGF5UHJvZml0UmF0ZSBTdHJpbmcg5LuK5pel5pS255uK546HXG5cdHRvZGF5UHJvZml0UmF0ZSA9IHZhbGlkU3RyaW5nKHJlc0RhdGEudG9kYXlQcm9maXRSYXRlLCBcIjBcIik7XG5cdHRtcEdyaWREYXRhWzRdLnZhbHVlUmF0ZSA9IGZvcm1hdCh0b2RheVByb2ZpdFJhdGUgKiAxMDAsIDIpICsgXCIlXCI7XG5cdHRtcEdyaWREYXRhWzRdLnJhdGVDb2xvciA9IGNvbW1vbi5nZXRQcmljZUNvbG9yKHRvZGF5UHJvZml0UmF0ZSA+PSAwKTtcblx0aWYgKHRvZGF5UHJvZml0UmF0ZSA9PSAwKSB7XG5cdFx0dG1wR3JpZERhdGFbNF0ucmF0ZUNvbG9yID0gXCJAY29sb3Iva0NvbG9yU2Vjb25kYXJ5VGV4dFwiO1xuXHR9XG5cdC8vIHByb2ZpdCDljZXluIHnp43mgLvmlLbnm4pcblx0dG1wR3JpZERhdGFbNV0udmFsdWUgPSBhd2FpdCBnZXRSZWFsUHJpY2UoY3VycmVuY3lTeW1ib2wsIHZhbGlkU3RyaW5nKHJlc0RhdGEucHJvZml0LCBcIjBcIiksIFwiMlwiKTtcblx0Ly8gcHJvZml0UmF0ZSBTdHJpbmcg5Y2V5biB56eN5oC75pS255uK546HXG5cdGNvbnN0IHByb2ZpdFJhdGUgPSB2YWxpZFN0cmluZyhyZXNEYXRhLnByb2ZpdFJhdGUsIFwiMFwiKTtcblx0dG1wR3JpZERhdGFbNV0udmFsdWVSYXRlID0gZm9ybWF0KHByb2ZpdFJhdGUgKiAxMDAsIDIpICsgXCIlXCI7XG5cdHRtcEdyaWREYXRhWzVdLnJhdGVDb2xvciA9IGNvbW1vbi5nZXRQcmljZUNvbG9yKHByb2ZpdFJhdGUgPj0gMCk7XG5cdGlmIChwcm9maXRSYXRlID09IDApIHtcblx0XHR0bXBHcmlkRGF0YVs1XS5yYXRlQ29sb3IgPSBcIkBjb2xvci9rQ29sb3JTZWNvbmRhcnlUZXh0XCI7XG5cdH1cblx0Ly8g5oiQ5pys5Lu354q25oCB77yIMO+8muS4jeaYvuekuu+8jDHvvJrmmL7npLrvvIlcblx0aWYgKHJlc0RhdGEuYXZnQ29zdFN0YXRlICYmIHJlc0RhdGEuYXZnQ29zdFN0YXRlID09IDEpIHtcblx0XHRtb2R1bGVEYXRhLmdyaWREYXRhID0gdG1wR3JpZERhdGE7XG5cdH0gZWxzZSB7XG5cdFx0dmFyIGVtcHR5R3JpZCA9IHtcblx0XHRcdGNlbGxUeXBlOiBcIjFcIixcblx0XHRcdHJhdGVTaG93OiBcImdvbmVcIixcblx0XHRcdGxpbmVTaG93OiBcImdvbmVcIixcblx0XHRcdGhlaWdodDogXCI1NFwiLFxuXHRcdFx0bmFtZTogXCJcIixcblx0XHRcdHZhbHVlOiBcIlwiLFxuXHRcdFx0cG9wVHlwZTogMCxcblx0XHR9O1xuXHRcdHZhciBuZXdHcmlkRGF0YSA9IFtdO1xuXHRcdG5ld0dyaWREYXRhLnB1c2godG1wR3JpZERhdGFbMF0pO1xuXHRcdG5ld0dyaWREYXRhLnB1c2godG1wR3JpZERhdGFbMV0pO1xuXHRcdG5ld0dyaWREYXRhLnB1c2godG1wR3JpZERhdGFbNF0pO1xuXHRcdG5ld0dyaWREYXRhLnB1c2godG1wR3JpZERhdGFbNV0pO1xuXHRcdG5ld0dyaWREYXRhLnB1c2godG1wR3JpZERhdGFbMl0pO1xuXHRcdG5ld0dyaWREYXRhLnB1c2goZW1wdHlHcmlkKTtcblx0XHRtb2R1bGVEYXRhLmdyaWREYXRhID0gbmV3R3JpZERhdGE7XG5cdH1cblx0Y29uc29sZS5sb2coYG1vZHVsZURhdGEuZ3JpZERhdGEgOiAke0pTT04uc3RyaW5naWZ5KG1vZHVsZURhdGEuZ3JpZERhdGEucmF3QXJyYXkoKSl9YCk7XG5cblxuXHQvLyDluIHluIHkuqflk4Fcblx0dmFyIGNvaW5Db250ZW50cyA9IHJlc0RhdGEuY29pbkNvbnRlbnRzICYmIHJlc0RhdGEuY29pbkNvbnRlbnRzICE9IG51bGwgPyByZXNEYXRhLmNvaW5Db250ZW50cyA6IFtdO1xuXHRmb3IgKGxldCBpbmRleCA9IDA7IGluZGV4IDwgY29pbkNvbnRlbnRzLmxlbmd0aDsgaW5kZXgrKykge1xuXHRcdGNvbnN0IGVsZW1lbnQgPSBjb2luQ29udGVudHNbaW5kZXhdO1xuXHRcdGVsZW1lbnQuY2VsbFR5cGUgPSBcIjFcIjtcblx0XHRlbGVtZW50Lm5hbWUgPSBlbGVtZW50LmN1cnJlbmN5LnRvVXBwZXJDYXNlKCk7XG5cdFx0ZWxlbWVudC5sYWJlbCA9ICRpMThuLm5fYXNzZXRfY29pbmRldGFpbF9jb2luO1xuXHRcdGVsZW1lbnQudGV4dCA9IGF3YWl0IGdldFJlYWxQcmljZShjdXJyZW5jeVN5bWJvbCwgdmFsaWRTdHJpbmcoZWxlbWVudC5tYXJrZXRQcmljZSwgXCIwXCIpLCBwcmljZVNjYWxlKTtcblx0XHRjb25zdCB0b2RheUluY3JlYXNlID0gdmFsaWRTdHJpbmcoZWxlbWVudC50b2RheUluY3JlYXNlLCBcIjBcIik7XG5cdFx0ZWxlbWVudC5sYWJlbFRleHQgPSBmb3JtYXQodG9kYXlJbmNyZWFzZSAqIDEwMCwgMikgKyBcIiVcIjtcblx0XHRlbGVtZW50LnRleHRDb2xvciA9IFwiQGNvbG9yL2tDb2xvclByaW1hcnlUZXh0XCI7XG5cdFx0ZWxlbWVudC5sYWJlbFRleHRDb2xvciA9IGNvbW1vbi5nZXRQcmljZUNvbG9yKHRvZGF5SW5jcmVhc2UgPj0gMCk7XG5cdFx0aWYgKHRvZGF5SW5jcmVhc2UgPT0gMCkge1xuXHRcdFx0ZWxlbWVudC5sYWJlbFRleHRDb2xvciA9IFwiQGNvbG9yL2tDb2xvclNlY29uZGFyeVRleHRcIjtcblx0XHR9XG5cdFx0ZWxlbWVudC5qdW1wVXJsID0gXCJKdW1wVHlwZU5hdGl2ZVwiO1xuXG5cdFx0ZWxlbWVudC5yZWNvbUJhc2VJbmZvID0gdmFsaWRTdHJpbmcoZWxlbWVudC5yZWNvbUJhc2VJbmZvLCBcIlwiKTtcblx0XHRjb21tb24uYW5hbHl0aWNzKFwiYXBwX3Nwb3RkZXRhaWxwYWdlX3RyYWRlX3Nob3dcIiwge1xuXHRcdFx0c3ltYm9sOiBlbGVtZW50LmN1cnJlbmN5LFxuXHRcdFx0cmVjb21fYmFzZV9pbmZvOiBlbGVtZW50LnJlY29tQmFzZUluZm9cblx0XHR9KTtcblx0fTtcblx0Ly8gVHJhZGluZyBCb3Qg5Lqn5ZOBXG5cdGNvbnN0IHRyYWRpbmdCb3RDb250ZW50cyA9IHJlc0RhdGEudHJhZGluZ0JvdENvbnRlbnRzO1xuXHRpZiAodHJhZGluZ0JvdENvbnRlbnRzICYmIHRyYWRpbmdCb3RDb250ZW50cyAhPSBudWxsICYmIHRyYWRpbmdCb3RDb250ZW50cy5sZW5ndGggPiAwKSB7XG5cdFx0Y29uc3QgZWxlbWVudCA9IHRyYWRpbmdCb3RDb250ZW50c1swXTtcblx0XHRlbGVtZW50LmNlbGxUeXBlID0gXCIxXCI7XG5cdFx0ZWxlbWVudC5uYW1lID0gZWxlbWVudC5jdXJyZW5jeS50b1VwcGVyQ2FzZSgpO1xuXHRcdGVsZW1lbnQubGFiZWwgPSAkaTE4bi5uX3RyYWRlX2JvdDtcblx0XHRjb25zdCBwcm9qZWN0UmF0ZSA9IHZhbGlkU3RyaW5nKGVsZW1lbnQucHJvamVjdFJhdGUsIFwiMFwiKTtcblx0XHRlbGVtZW50LnRleHQgPSBmb3JtYXQocHJvamVjdFJhdGUgKiAxMDAsIDIpICsgXCIlXCI7XG5cdFx0ZWxlbWVudC5sYWJlbFRleHQgPSB2YWxpZFN0cmluZyhlbGVtZW50LmFweVRyYW5zbGF0ZSwgXCJcIik7XG5cdFx0ZWxlbWVudC50ZXh0Q29sb3IgPSBjb21tb24uZ2V0UHJpY2VDb2xvcihwcm9qZWN0UmF0ZSA+PSAwKTtcblx0XHRlbGVtZW50LmxhYmVsVGV4dENvbG9yID0gXCJAY29sb3Iva0NvbG9yVGhyZWVMZXZlbFRleHRcIjtcblx0XHRpZiAoY29pbkNvbnRlbnRzLmxlbmd0aCA+IDApIHtcblx0XHRcdGNvaW5Db250ZW50cy5zcGxpY2UoMSwgMCwgZWxlbWVudCk7XG5cdFx0fSBlbHNlIHtcblx0XHRcdGNvaW5Db250ZW50cy5wdXNoKGVsZW1lbnQpO1xuXHRcdH1cblxuXHRcdGVsZW1lbnQucmVjb21CYXNlSW5mbyA9IHZhbGlkU3RyaW5nKGVsZW1lbnQucmVjb21CYXNlSW5mbywgXCJcIik7XG5cdFx0Y29tbW9uLmFuYWx5dGljcyhcImFwcF9zcG90ZGV0YWlscGFnZV90cmFkZV9zaG93XCIsIHtcblx0XHRcdHN5bWJvbDogZWxlbWVudC5jdXJyZW5jeSxcblx0XHRcdHJlY29tX2Jhc2VfaW5mbzogZWxlbWVudC5yZWNvbUJhc2VJbmZvXG5cdFx0fSk7XG5cdH1cblx0bW9kdWxlRGF0YS5jb2luQ29udGVudHMgPSBjb2luQ29udGVudHM7XG5cdG1vZHVsZURhdGEudHJhZGVDYXJkU2hvdyA9IGNvaW5Db250ZW50cy5sZW5ndGggPiAwID8gXCJ2aXNpYmxlXCIgOiBcImdvbmVcIjtcblx0Ly8g5Y676LWa5biBXG5cdGNvbnN0IGZpbmFuY2VDb250ZW50cyA9IHJlc0RhdGEuZmluYW5jZUNvbnRlbnRzO1xuXHRpZiAoZmluYW5jZUNvbnRlbnRzICYmIGZpbmFuY2VDb250ZW50cy5sZW5ndGggPiAwKSB7XG5cdFx0Y29uc3QgZmluYW5jZSA9IGZpbmFuY2VDb250ZW50c1swXTtcblx0XHRlYXJuSXRlbVVybCA9IHZhbGlkU3RyaW5nKGZpbmFuY2UuanVtcFVybCk7XG5cdFx0Y29uc3QgZmluYW5jZV9hcHkgPSB2YWxpZFN0cmluZyhmaW5hbmNlLmFweSwgXCIwXCIpO1xuXHRcdGNvbnN0IGZpbmFuY2VfYXB5X3RleHQgPSBmb3JtYXQoZmluYW5jZV9hcHkgKiAxMDAsIDApICsgXCIlXCI7XG5cdFx0dmFyIHRleHRDb2xvciA9IFwiIzAwMDAwMFwiO1xuXHRcdGlmIChjb21tb24uY29tbW9uRGF0YS5jb2xvck1vZGUgPT0gMSkge1xuXHRcdFx0dGV4dENvbG9yID0gXCIjRTZFNkU2XCJcblx0XHR9XG5cdFx0Y29uc3QgZWFyblRleHQgPSAkaTE4bi4kaW50ZXJjZXB0Lm5fYXNzZXRfY29pbmRldGFpbF9lYXJuX2NvbnRlbnQoZmluYW5jZS5jdXJyZW5jeURpc3BsYXlOYW1lLCBmaW5hbmNlX2FweV90ZXh0KTtcblx0XHRjb25zdCBzcGFuU3RhcnQgPSBgPHNwYW4gc3R5bGU9XCJjb2xvcjoke3RleHRDb2xvcn07IGZvbnQtc2l6ZToxNHB4O1wiPmA7XG5cdFx0Y29uc3Qgc3BhbkVuZCA9IFwiPC9zcGFuPlwiO1xuXHRcdHZhciByaWNoSGlnaGxpZ2h0ID0gYCR7c3BhbkVuZH08c3BhbiBzdHlsZT1cImNvbG9yOiR7dGV4dENvbG9yfTsgZm9udC1zaXplOjE4cHg7XCI+ICR7ZmluYW5jZV9hcHlfdGV4dH0gPC9zcGFuPiR7c3BhblN0YXJ0fWA7XG5cdFx0Y29uc3Qgam9pblRleHQgPSBlYXJuVGV4dC5zcGxpdChmaW5hbmNlX2FweV90ZXh0KS5qb2luKHJpY2hIaWdobGlnaHQpO1xuXHRcdG1vZHVsZURhdGEuZWFyblRleHQgPSBgJHtzcGFuU3RhcnR9JHtqb2luVGV4dH0ke3NwYW5FbmR9YDtcblx0XHRjb25zb2xlLmxvZyhgbW9kdWxlRGF0YS5lYXJuVGV4dCAgOiAke21vZHVsZURhdGEuZWFyblRleHR9YCk7XG5cdFx0bW9kdWxlRGF0YS5sYXVuY2hQb29sVmlzaWIgPSBmaW5hbmNlLnRhZyA9PSA5ID8gXCJ2aXNpYmxlXCIgOiBcImdvbmVcIjtcblx0XHRpZiAoIWVhcm5JdGVtVXJsIHx8IGVhcm5JdGVtVXJsLmxlbmd0aCA9PT0gMCkge1xuXHRcdFx0bW9kdWxlRGF0YS5lYXJuQ2FyZFNob3cgPSBcImdvbmVcIjtcblx0XHR9IGVsc2Uge1xuXHRcdFx0bW9kdWxlRGF0YS5lYXJuQ2FyZFNob3cgPSBcInZpc2libGVcIjtcblx0XHR9XG5cdH0gZWxzZSB7XG5cdFx0bW9kdWxlRGF0YS5lYXJuQ2FyZFNob3cgPSBcImdvbmVcIjtcblx0fVxufVxuXG5hc3luYyBmdW5jdGlvbiByZXF1ZXN0RmluYW5jZUhpc3RvcnkoaWR4ID0gMCwgaXNMb2FkTW9yZSA9IGZhbHNlKSB7XG5cdGlmIChyZXF1ZXN0Q3VycmVuY3kubGVuZ3RoID09IDApIHtcblx0XHRyZXR1cm47XG5cdH1cblxuXHRjb25zdCBzbGlkZXJDZWxsRGF0YSA9IHNsaWRlckRhdGFbaWR4XTtcblx0Y29uc3Qgc2l6ZSA9IDIxO1xuXHR2YXIgcGFyYW1zID0ge1xuXHRcdHNpemUsXG5cdFx0ZGlyZWN0OiBcIm5leHRcIixcblx0XHRjdXJyZW5jeTogcmVxdWVzdEN1cnJlbmN5XG5cdH1cblx0aWYgKHR5cGVzICE9IG51bGwpIHtcblx0XHRwYXJhbXNbJ3R5cGVzJ10gPSB0eXBlcztcblx0fVxuXHRpZiAoaXNMb2FkTW9yZSAmJiBzbGlkZXJDZWxsRGF0YS5mcm9tSWQgPiAwKSB7XG5cdFx0cGFyYW1zWydmcm9tJ10gPSBzbGlkZXJDZWxsRGF0YS5mcm9tSWQ7XG5cdH1cblx0aWYgKHJlcVN0YXJ0RGF0ZSAhPSBudWxsKSB7XG5cdFx0cGFyYW1zWydzdGFydC10aW1lJ10gPSByZXFTdGFydERhdGU7XG5cdH1cblx0aWYgKHJlcUVuZERhdGUgIT0gbnVsbCkge1xuXHRcdHBhcmFtc1snZW5kLXRpbWUnXSA9IHJlcUVuZERhdGU7XG5cdH1cblxuXHRjb25zdCByZXNEYXRhID0gYXdhaXQgY29tbW9uLnNlbmRSZXF1ZXN0KCd2MS9xdWVyeS9maW5hbmNlLWhpc3RvcnknLCBwYXJhbXMsIDAsIDQpO1xuXHRjb21tb24uc2hvd0xvYWRpbmcoZmFsc2UpO1xuXHRtb2R1bGVEYXRhLnJlZnJlc2hTdGF0dXMgPSAyO1xuXHRtb2R1bGVEYXRhLmxvYWRNb3JlU3RhdHVzID0gMjtcblx0bW9kdWxlRGF0YS5oaXN0b3J5TG9hZE1vcmVTdGF0dXMgPSAyO1xuXHRjb25zb2xlLmxvZyhyZXNEYXRhKTtcblx0aWYgKCFyZXNEYXRhIHx8IHJlc0RhdGEgPT0gbnVsbCkge1xuXHRcdHJldHVybjtcblx0fVxuXHRpZiAocmVzRGF0YS5sZW5ndGggPT0gMCkge1xuXHRcdGlmIChpc0xvYWRNb3JlID09IGZhbHNlKSB7XG5cdFx0XHRzbGlkZXJEYXRhW2lkeF0uY2VsbERhdGEgPSBbeyBcImNlbGxUeXBlXCI6IFwiZW1wdHlcIiB9XTtcblx0XHRcdHNsaWRlckRhdGFbaWR4XS50YWJsZUhlaWdodCA9IDI4MDtcblx0XHRcdG1vZHVsZURhdGEuc2xpZGVyRGF0YVtpZHhdLmNlbGxEYXRhID0gW3sgXCJjZWxsVHlwZVwiOiBcImVtcHR5XCIgfV07XG5cdFx0XHRtb2R1bGVEYXRhLnNsaWRlckRhdGFbaWR4XS50YWJsZUhlaWdodCA9IDI4MDtcblx0XHR9XG5cdFx0c2xpZGVyQ2VsbERhdGEubmVlZE1vcmUgPSBmYWxzZTtcblx0XHRyZXR1cm47XG5cdH1cblx0Y29uc3QgbGFzdERhdGEgPSByZXNEYXRhW3Jlc0RhdGEubGVuZ3RoIC0gMV07XG5cdHNsaWRlckNlbGxEYXRhLmZyb21JZCA9IGxhc3REYXRhLmlkO1xuXHRzbGlkZXJDZWxsRGF0YS5uZWVkTW9yZSA9IGZhbHNlO1xuXHRpZiAocmVzRGF0YS5sZW5ndGggPT0gc2l6ZSkge1xuXHRcdHNsaWRlckNlbGxEYXRhLm5lZWRNb3JlID0gdHJ1ZTtcblx0XHRyZXNEYXRhLnBvcCgpO1xuXHR9XG5cdHZhciBuZXdIaXN0b3J5cyA9IFtdO1xuXHR2YXIgY2VsbEhlaWdodCA9IDg2LjU7XG5cdGZvciAobGV0IGluZGV4ID0gMDsgaW5kZXggPCByZXNEYXRhLmxlbmd0aDsgaW5kZXgrKykge1xuXHRcdGNvbnN0IGVsZW1lbnQgPSByZXNEYXRhW2luZGV4XTtcblx0XHR2YXIgZmluYW5jZVR5cGUgPSBmaW5hbmNlQ2xhc3MuZ2V0U3BvdEZpbmFuY2VUeXBlV2l0aEdyb3VwKGVsZW1lbnRbXCJncm91cC10eXBlXCJdKTtcblxuXHRcdGlmIChmaW5hbmNlVHlwZSA9PSBmaW5hbmNlQ2xhc3MuRmluYW5jZUdyb3VwVHlwZS5TUE9UX0RFUE9TSVQgfHwgZmluYW5jZVR5cGUgPT0gZmluYW5jZUNsYXNzLkZpbmFuY2VHcm91cFR5cGUuU1BPVF9XSVRIRFJBVykge1xuXHRcdFx0Y2VsbEhlaWdodCA9IDExMi41O1xuXHRcdFx0ZWxlbWVudC5jZWxsVHlwZSA9IFwidHlwZTFcIjtcblx0XHRcdGVsZW1lbnQuZGlzcGxheVN0YXRlID0gZmluYW5jZUNsYXNzLmdldFNwb3RGaW5hbmNlU3RhdGUoZWxlbWVudFtcInN0YXRlXCJdLCBmaW5hbmNlVHlwZSk7XG5cdFx0XHRlbGVtZW50LmRpc3BsYXlGZWUgPVxuXHRcdFx0YCR7dmFsaWRTdHJpbmcoZWxlbWVudC5mZWVzLCBcIjBcIil9ICR7dmFsaWRTdHJpbmcoZWxlbWVudFtcImN1cnJlbmN5LWRpc3BsYXktbmFtZVwiXSwgbW9kdWxlRGF0YS5kaXNwbGF5TmFtZSl9YDtcblx0XHR9IGVsc2Uge1xuXHRcdFx0ZWxlbWVudC5jZWxsVHlwZSA9IFwidHlwZTJcIjtcblx0XHRcdGVsZW1lbnQuZGlzcGxheURldGFpbCA9IGZpbmFuY2VDbGFzcy5nZXRTcG90RGlzcGxheVN0YXR1c0RldGFpbChlbGVtZW50LnR5cGUsIGVsZW1lbnQuZGlyZWN0aW9uLCBlbGVtZW50LmRlc2MsIGVsZW1lbnQuZXh0cmEpO1xuXHRcdH1cblx0XHRlbGVtZW50LmRpc3BsYXlUaXRsZSA9IGZpbmFuY2VDbGFzcy5nZXRTcG90RGlzcGxheVR5cGUoZmluYW5jZVR5cGUpO1xuXHRcdGVsZW1lbnQuZGlzcGxheUFtb3VudCA9IHZhbGlkU3RyaW5nKGVsZW1lbnQuYW1vdW50LCBcIjBcIik7XG5cdFx0ZWxlbWVudC5kaXNwbGF5VGltZSA9IGAke25ldyBEYXRlKGVsZW1lbnRbXCJ1cGRhdGVkLWF0XCJdKS5Gb3JtYXQoXCJ5eXl5LU1NLWRkIGhoOm1tOnNzXCIpfWA7XG5cblx0XHRuZXdIaXN0b3J5cy5wdXNoKGVsZW1lbnQpO1xuXHR9XG5cdGlmIChpc0xvYWRNb3JlID09IGZhbHNlKSB7XG5cdFx0c2xpZGVyRGF0YVtpZHhdLmNlbGxEYXRhID0gbmV3SGlzdG9yeXM7XG5cdFx0bW9kdWxlRGF0YS5zbGlkZXJEYXRhW2lkeF0uY2VsbERhdGEgPSBuZXdIaXN0b3J5cztcblx0fSBlbHNlIHtcblx0XHRzbGlkZXJEYXRhW2lkeF0uY2VsbERhdGEgPSBzbGlkZXJEYXRhW2lkeF0uY2VsbERhdGEuY29uY2F0KG5ld0hpc3RvcnlzKTtcblx0XHRtb2R1bGVEYXRhLnNsaWRlckRhdGFbaWR4XS5jZWxsRGF0YSA9IHNsaWRlckRhdGFbaWR4XS5jZWxsRGF0YTtcblx0fVxuXHR2YXIgY291bnQgPSBzbGlkZXJEYXRhW2lkeF0uY2VsbERhdGEubGVuZ3RoO1xuXHR2YXIgdGFibGVIZWlnaHQgPSBjb3VudCAqIGNlbGxIZWlnaHQ7XG5cdHRhYmxlSGVpZ2h0ID0gdGFibGVIZWlnaHQgPiAyODAgPyB0YWJsZUhlaWdodCA6IDI4MDtcblx0c2xpZGVyRGF0YVtpZHhdLnRhYmxlSGVpZ2h0ID0gdGFibGVIZWlnaHQ7XG5cdG1vZHVsZURhdGEuc2xpZGVyRGF0YVtpZHhdLnRhYmxlSGVpZ2h0ID0gdGFibGVIZWlnaHQ7XG59XG5cbmZ1bmN0aW9uIHJlY29yZFR5cGVTZWxlY3RlZChpbmRleCkge1xuXHRpZiAobGFzdFRhYkluZGV4ID09IGluZGV4KSB7XG5cdFx0cmV0dXJuO1xuXHR9XG5cdGxhc3RUYWJJbmRleCA9IGluZGV4O1xuXHRmb3IgKGxldCBpID0gMDsgaSA8IG1vZHVsZURhdGEuaGlzdG9yeVR5cGVzLmxlbmd0aDsgaSsrKSB7XG5cdFx0dmFyIG9iaiA9IG1vZHVsZURhdGEuaGlzdG9yeVR5cGVzW2ldO1xuXHRcdG9iai50ZXh0Q29sb3IgPSAnQGNvbG9yL2tDb2xvclNlY29uZGFyeVRleHQnO1xuXHRcdG9iai5iZ0NvbG9yID0gXCJAY29sb3IvS0Jhc2VDb2xvckNvbnRlbnRCYWNrZ3JvdW5kXCI7XG5cdH1cblx0dmFyIGN1ciA9IG1vZHVsZURhdGEuaGlzdG9yeVR5cGVzW2luZGV4XTtcblx0Y3VyLnRleHRDb2xvciA9ICdAY29sb3Iva0NvbG9yUHJpbWFyeVRleHQnO1xuXHRjdXIuYmdDb2xvciA9IFwiQGNvbG9yL0tCYXNlQ29sb3JJbnB1dEJhY2tncm91bmRcIjtcblxuXHR0eXBlcyA9IGZpbmFuY2VDbGFzcy5nZXRSZXF1ZXN0VHlwZShjdXIuZ3JvdXBUeXBlKTtcblx0cmVxdWVzdEZpbmFuY2VIaXN0b3J5KGluZGV4KTtcbn1cblxubW9kdWxlRXZlbnQucmVjb3JkVHlwZVNlbGVjdGVkID0gcmVjb3JkVHlwZVNlbGVjdGVkO1xuXG5mdW5jdGlvbiBoaXN0b3J5TG9hZE1vcmUoKSB7XG5cdGNvbnN0IHNsaWRlckNlbGxEYXRhID0gc2xpZGVyRGF0YVttb2R1bGVEYXRhLnJlY29yZFRhYkluZGV4XTtcblx0aWYgKHNsaWRlckNlbGxEYXRhLm5lZWRNb3JlKSB7XG5cdFx0cmVxdWVzdEZpbmFuY2VIaXN0b3J5KG1vZHVsZURhdGEucmVjb3JkVGFiSW5kZXgsIHRydWUpO1xuXHR9IGVsc2Uge1xuXHRcdG1vZHVsZURhdGEubG9hZE1vcmVTdGF0dXMgPSAyO1xuXHRcdG1vZHVsZURhdGEuaGlzdG9yeUxvYWRNb3JlU3RhdHVzID0gMjtcblx0fVxufVxuXG5tb2R1bGVFdmVudC5oaXN0b3J5TG9hZE1vcmUgPSBoaXN0b3J5TG9hZE1vcmU7XG5cbm1vZHVsZUV2ZW50LnJlZnJlc2ggPSBmdW5jdGlvbiAoKSB7XG5cdG1vZHVsZURhdGEucmVmcmVzaFN0YXR1cyA9IDE7XG5cdHJlcXVlc3RDb250ZW50SW5mb1YyKHJlcXVlc3RDdXJyZW5jeSk7XG5cdHJlcXVlc3RGaW5hbmNlSGlzdG9yeShtb2R1bGVEYXRhLnJlY29yZFRhYkluZGV4KTtcbn1cblxubW9kdWxlRXZlbnQubG9hZE1vcmUgPSBmdW5jdGlvbiAoKSB7XG5cdGhpc3RvcnlMb2FkTW9yZSgpO1xufVxuXG5tb2R1bGVFdmVudC5iYWNrQ2xpY2tlZCA9IGZ1bmN0aW9uICgpIHtcblx0Y29tbW9uLmNvbnRhaW5lckJhY2soKTtcbn1cblxubW9kdWxlRXZlbnQuanVtcEludHJvID0gZnVuY3Rpb24gKCkge1xuXHRjb21tb24ub3BlblBhZ2VXaXRoUGF0aChgL2Fzc2V0LWludHJvZHVjdGlvbi9kZXRhaWxzL2g1Lz9jdXJyZW5jeT0ke21vZHVsZURhdGEuY3VycmVuY3lDb2RlfWApO1xufVxuXG5tb2R1bGVFdmVudC5vcGVuU2hhcmUgPSBmdW5jdGlvbiAoKSB7XG5cdHZhciBwYXJhbXMgPSB7XG5cdFx0dHlwZTogMTEsXG5cdFx0Y3VycmVuY3k6IHJlcXVlc3RDdXJyZW5jeSxcblx0XHR0b2RheVByb2ZpdFJhdGVcblx0fTtcblx0JG5hdGl2ZUFQSS5qdW1wKEpTT04uc3RyaW5naWZ5KHBhcmFtcykpO1xufVxuXG4vL+WOu+S6pOaYk+adoeebrlxubW9kdWxlRXZlbnQudHJhZGVDbGlja2VkID0gZnVuY3Rpb24gKCkge1xuXHRpZiAoY29tbW9uLmNvbW1vbkRhdGEuT1MgPT0gMSkge1xuXHRcdHZhciBwYXJhbXMgPSB7XG5cdFx0XHR0eXBlOiAxNjIsXG5cdFx0XHRjdXJyZW5jeTogcmVxdWVzdEN1cnJlbmN5LFxuXHRcdH07XG5cdFx0JG5hdGl2ZUFQSS5qdW1wKEpTT04uc3RyaW5naWZ5KHBhcmFtcykpO1xuXHR9IGVsc2Uge1xuXHRcdGNvbW1vbi5vcGVuUGFnZVdpdGhQYXRoKGBob2xpZ2VpdDovL29wZW4vdjE/dXJsPWlodW9iaWdsb2JhbDovL20uaGJnLmNvbS9tYXJrZXQvbmV3U2VhcmNoP3NlYXJjaEtleT0ke3JlcXVlc3RDdXJyZW5jeX1gKTtcblx0fVxufVxuXG4vL+WOu+S6pOaYk1xubW9kdWxlRXZlbnQudHJhZGVJdGVtQ2xpY2tlZCA9IGZ1bmN0aW9uIChqdW1wVXJsLCBjdXJyZW5jeSwgcmVjb21fYmFzZV9pbmZvKSB7XG5cdGNvbnN0IHN5bWJvbCA9IGN1cnJlbmN5O1xuXHRpZiAoanVtcFVybCA9PSBcIkp1bXBUeXBlTmF0aXZlXCIpIHtcblx0XHRjdXJyZW5jeSA9IGN1cnJlbmN5LnJlcGxhY2UoXCJ8XCIsIFwiXCIpO1xuXHRcdGN1cnJlbmN5ID0gY3VycmVuY3kucmVwbGFjZShcIi9cIiwgXCJcIik7XG5cdFx0Y3VycmVuY3kgPSBjdXJyZW5jeS50b0xvd2VyQ2FzZSgpO1xuXHRcdHZhciBwYXJhbXMgPSB7XG5cdFx0XHR0eXBlOiAxNTksXG5cdFx0XHRjdXJyZW5jeSxcblx0XHR9O1xuXHRcdCRuYXRpdmVBUEkuanVtcChKU09OLnN0cmluZ2lmeShwYXJhbXMpKTtcblx0fSBlbHNlIHtcblx0XHRjb21tb24ub3BlblBhZ2VXaXRoUGF0aChqdW1wVXJsKTtcblx0fVxuXG5cdGNvbW1vbi5hbmFseXRpY3MoXCJhcHBfc3BvdGRldGFpbHBhZ2VfdHJhZGVfY2xpY2tcIiwge1xuXHRcdHN5bWJvbCxcblx0XHRyZWNvbV9iYXNlX2luZm9cblx0fSk7XG59XG5cbi8v5YWF5biBXG5tb2R1bGVFdmVudC5kZXBvc2l0Q2xpY2tlZCA9IGZ1bmN0aW9uICgpIHtcblx0dmFyIHBhcmFtcyA9IHtcblx0XHR0eXBlOiAxNjAsXG5cdFx0Y3VycmVuY3k6IHJlcXVlc3RDdXJyZW5jeSxcblx0fTtcblx0JG5hdGl2ZUFQSS5qdW1wKEpTT04uc3RyaW5naWZ5KHBhcmFtcykpO1xufVxuXG4vL+aPkOW4gVxubW9kdWxlRXZlbnQud2l0aGRyYXdDbGlja2VkID0gZnVuY3Rpb24gKCkge1xuXHR2YXIgcGFyYW1zID0ge1xuXHRcdHR5cGU6IDE2MSxcblx0XHRjdXJyZW5jeTogcmVxdWVzdEN1cnJlbmN5LFxuXHR9O1xuXHQkbmF0aXZlQVBJLmp1bXAoSlNPTi5zdHJpbmdpZnkocGFyYW1zKSk7XG59XG5cbi8v5YiS6L2sXG5tb2R1bGVFdmVudC50cmFuc2ZlckNsaWNrZWQgPSBmdW5jdGlvbiAoKSB7XG5cdHZhciBwYXJhbXMgPSB7XG5cdFx0dHlwZTogMjAsXG5cdFx0Y3VycmVuY3k6IHJlcXVlc3RDdXJyZW5jeSxcblx0fTtcblx0JG5hdGl2ZUFQSS5qdW1wKEpTT04uc3RyaW5naWZ5KHBhcmFtcykpO1xufVxuXG5tb2R1bGVFdmVudC5lYXJuQ2xpY2tlZCA9IGZ1bmN0aW9uICgpIHtcblx0Y29tbW9uLm9wZW5QYWdlV2l0aFBhdGgoZWFybkp1bXBVcmwpO1xufVxuXG5tb2R1bGVFdmVudC5lYXJuSXRlbUNsaWNrZWQgPSBmdW5jdGlvbiAoKSB7XG5cdGVhcm5JdGVtVXJsID0gZWFybkl0ZW1VcmwucmVwbGFjZShcImZyb21UeXBlPTFcIiwgXCJmcm9tVHlwZT0yXCIpO1xuXHRjb21tb24ub3BlblBhZ2VXaXRoUGF0aChlYXJuSXRlbVVybCk7XG59XG5cbm1vZHVsZUV2ZW50Lmhpc3RvcnlDbGlja2VkID0gZnVuY3Rpb24gKCkge1xufVxuXG5tb2R1bGVFdmVudC5wb3BTaG93ID0gZnVuY3Rpb24gKHBvcFR5cGUpIHtcblx0bW9kdWxlRGF0YS5wb3BTdHlsZTEgPSBcImdvbmVcIjtcblx0bW9kdWxlRGF0YS5wb3BTdHlsZTIgPSBcImdvbmVcIjtcblx0aWYgKHBvcFR5cGUgPiAwKSB7XG5cdFx0aWYgKHBvcFR5cGUgPT0gMSkge1xuXHRcdFx0bW9kdWxlRGF0YS5wb3BUaXRsZSA9ICRpMThuLm5fYXNzZXRfY29pbmRldGFpbF9sb2NrZWQ7XG5cdFx0XHRtb2R1bGVEYXRhLnBvcFN0eWxlMSA9IFwidmlzaWJsZVwiO1xuXHRcdH0gZWxzZSBpZiAocG9wVHlwZSA9PSAyKSB7XG5cdFx0XHRtb2R1bGVEYXRhLnBvcFRpdGxlID0gJGkxOG4ubl9hc3NldF9jb2luZGV0YWlsX2Nvc3RfcHJpY2U7XG5cdFx0XHRtb2R1bGVEYXRhLnBvcENvbnRlbnQgPSBgJHskaTE4bi5uX2Fzc2V0X2NvaW5kZXRhaWxfY29zdF9wcmljZV90aXBzXzF9XFxuJHskaTE4bi5uX2Fzc2V0X2NvaW5kZXRhaWxfY29zdF9wcmljZV90aXBzXzJ9XFxuXFxuJHskaTE4bi5uX2Fzc2V0X2NvaW5kZXRhaWxfY29zdF9wcmljZV90aXBzXzN9XFxuJHskaTE4bi5uX2Fzc2V0X2NvaW5kZXRhaWxfY29zdF9wcmljZV90aXBzXzR9YDtcblx0XHRcdG1vZHVsZURhdGEucG9wU3R5bGUyID0gXCJ2aXNpYmxlXCI7XG5cdFx0fSBlbHNlIGlmIChwb3BUeXBlID09IDMpIHtcblx0XHRcdG1vZHVsZURhdGEucG9wVGl0bGUgPSAkaTE4bi5uX3RvZGF5X3Byb2ZpdDtcblx0XHRcdG1vZHVsZURhdGEucG9wQ29udGVudCA9IGAkeyRpMThuLm5fYXNzZXRfY29pbmRldGFpbF90b2RheV9wbmxfdGlwc18xfVxcbiR7JGkxOG4ubl9hc3NldF9jb2luZGV0YWlsX3RvZGF5X3BubF90aXBzXzJ9XFxuJHskaTE4bi5uX2Fzc2V0X2NvaW5kZXRhaWxfdG9kYXlfcG5sX3RpcHNfM31gO1xuXHRcdFx0bW9kdWxlRGF0YS5wb3BTdHlsZTIgPSBcInZpc2libGVcIjtcblx0XHR9IGVsc2UgaWYgKHBvcFR5cGUgPT0gNCkge1xuXHRcdFx0bW9kdWxlRGF0YS5wb3BUaXRsZSA9ICRpMThuLm5fYXNzZXRfY29pbmRldGFpbF90b3RhbF9wbmw7XG5cdFx0XHRtb2R1bGVEYXRhLnBvcENvbnRlbnQgPSBgJHskaTE4bi5uX2Fzc2V0X2NvaW5kZXRhaWxfdG90YWxfcG5sX3RpcHNfMX1cXG4keyRpMThuLm5fYXNzZXRfY29pbmRldGFpbF90b3RhbF9wbmxfdGlwc18yfWA7XG5cdFx0XHRtb2R1bGVEYXRhLnBvcFN0eWxlMiA9IFwidmlzaWJsZVwiO1xuXHRcdH0gZWxzZSBpZiAocG9wVHlwZSA9PSA1KSB7XG5cdFx0XHRtb2R1bGVEYXRhLnBvcFRpdGxlID0gbW9kdWxlRGF0YS5oaXN0b3J5VGl0bGVLTGluZVByaWNlO1xuXHRcdFx0bW9kdWxlRGF0YS5wb3BDb250ZW50ID0gJGkxOG4ubl9hc3NldF9jb2luZGV0YWlsX2hpc3RvcnlfdGlwc18xO1xuXHRcdFx0bW9kdWxlRGF0YS5wb3BTdHlsZTIgPSBcInZpc2libGVcIjtcblx0XHR9IGVsc2UgaWYgKHBvcFR5cGUgPT0gNikge1xuXHRcdFx0bW9kdWxlRGF0YS5wb3BUaXRsZSA9IG1vZHVsZURhdGEuaGlzdG9yeVRpdGxlUHJpY2U7XG5cdFx0XHRtb2R1bGVEYXRhLnBvcENvbnRlbnQgPSAkaTE4bi5uX2Fzc2V0X2NvaW5kZXRhaWxfaGlzdG9yeV90aXBzXzI7XG5cdFx0XHRtb2R1bGVEYXRhLnBvcFN0eWxlMiA9IFwidmlzaWJsZVwiO1xuXHRcdH1cblx0XHRtb2R1bGVEYXRhLnBvcFNob3cgPSB0cnVlO1xuXHR9XG59XG5cbm1vZHVsZUV2ZW50LnBvcENsb3NlID0gZnVuY3Rpb24gKCkge1xuXHRtb2R1bGVEYXRhLnBvcFNob3cgPSBmYWxzZTtcbn1cblxubW9kdWxlRXZlbnQuaGlzdG9yeVR5cGVDbGlja2VkID0gZnVuY3Rpb24gKGlkeCkge1xuXHRtb2R1bGVEYXRhLnJlY29yZFRhYkluZGV4ID0gYCR7aWR4fWA7XG59XG4iLCJpbXBvcnQgKiBhcyBjb21tb24gZnJvbSBcIi4vY29tbW9uXCI7XG5pbXBvcnQgKiBhcyBzdHJ1Y3R1cmVkIGZyb20gXCIuL3N0cnVjdHVyZWRcIjtcbmltcG9ydCAqIGFzIGludHJvZHVjZSBmcm9tIFwiLi9pbnRyb2R1Y2VcIjtcbmltcG9ydCAqIGFzIGhvbWUgZnJvbSBcIi4vaG9tZVwiO1xuaW1wb3J0ICogYXMgY29pbiBmcm9tIFwiLi9zZWFyY2hjb2luXCI7XG5pbXBvcnQgKiBhcyBjb2luZGV0YWlsIGZyb20gXCIuL2NvaW5kZXRhaWxcIjtcblxuZnVuY3Rpb24gc2VuZENvbW1vbkNvbmZpZyhwYXJhbSkge1xuICBjb21tb24uZ2V0Q29tbW9uQ29uZmlnKHBhcmFtKTtcbn1cblxuJGV2ZW50LnNlbmRDb21tb25Db25maWcgPSBzZW5kQ29tbW9uQ29uZmlnOyJdLCJuYW1lcyI6WyJEUCIsIlJNIiwiTUFYX0RQIiwiTUFYX1BPV0VSIiwiTkUiLCJQRSIsIk5BTUUiLCJJTlZBTElEIiwiSU5WQUxJRF9EUCIsIklOVkFMSURfUk0iLCJESVZfQllfWkVSTyIsIlAiLCJVTkRFRklORUQiLCJOVU1FUklDIiwiX0JpZ18iLCJCaWciLCJuIiwieCIsInRoaXMiLCJzIiwiZSIsImMiLCJzbGljZSIsInBhcnNlIiwiY29uc3RydWN0b3IiLCJwcm90b3R5cGUiLCJ2ZXJzaW9uIiwiaSIsIm5sIiwidGVzdCIsIkVycm9yIiwiY2hhckF0IiwiaW5kZXhPZiIsInJlcGxhY2UiLCJzZWFyY2giLCJzdWJzdHJpbmciLCJsZW5ndGgiLCJyb3VuZCIsImRwIiwicm0iLCJtb3JlIiwieGMiLCJ1bnNoaWZ0IiwicG9wIiwic3RyaW5naWZ5IiwiaWQiLCJrIiwieiIsInB1c2giLCJqb2luIiwiYWJzIiwiY21wIiwieSIsImlzbmVnIiwieWMiLCJqIiwibCIsImRpdiIsImEiLCJiIiwiYmwiLCJidCIsInJpIiwiYnoiLCJhaSIsImFsIiwiciIsInJsIiwicSIsInFjIiwicWkiLCJkIiwic2hpZnQiLCJlcSIsImd0IiwiZ3RlIiwibHQiLCJsdGUiLCJtaW51cyIsInN1YiIsInQiLCJ4bHR5IiwicGx1cyIsInhlIiwieWUiLCJyZXZlcnNlIiwibW9kIiwieWd0eCIsInRpbWVzIiwiYWRkIiwicG93Iiwib25lIiwic3FydCIsImhhbGYiLCJNYXRoIiwidG9FeHBvbmVudGlhbCIsIm11bCIsIkFycmF5IiwidG9GaXhlZCIsInRvUHJlY2lzaW9uIiwic2QiLCJ0b1N0cmluZyIsInZhbHVlT2YiLCJ0b0pTT04iLCJtdWx0aXBseSIsImRpdmlkZSIsImZvcm1hdCIsInZhbHVlIiwicHJlY2lzaW9uIiwiYmlnVmFsdWUiLCJzdHJpbmdWYWx1ZSIsImluY2x1ZGVzIiwic3RyQXJyYXkiLCJzcGxpdCIsInRydW5jYXRlIiwiemVyb051bWJlciIsInN0ciIsImNsaWNrYWJsZSIsIkRFRkFVTFRfU1RSIiwibW9kdWxlRGVmaW5lIiwibW9kdWxlTmFtZSIsImRlZmF1bHREYXRhRnVuY3Rpb24iLCJmdW5jdGlvbnMiLCJvbkNyZWF0ZSIsIm9uRGVzdHJveSIsIm9uUmVzdW1lIiwib25QYXVzZSIsIm9uU3RhcnQiLCJvblN0b3AiLCJjb25zb2xlIiwibG9nIiwiJGRhdGEiLCIkZXZlbnQiLCJtb2R1bGVEYXRhIiwibW9kdWxlRXZlbnQiLCJhc3luYyIsImFuYWx5dGljcyIsImV2ZW50IiwicHJvcGVydGllcyIsInByb3BlcnRpZXNKc29uIiwiSlNPTiIsIm1hcCIsIiRuYXRpdmVBUEkiLCJjb21tb25EYXRhIiwicHJpY2VDb2xvclR5cGUiLCJjb2xvck1vZGUiLCJPUyIsImFwcFZlcnNpb24iLCJpc0luUmV2aWV3IiwiaDVVcmwiLCJsYW5ndWFnZSIsInN0YXR1c0hlaWdodCIsInZUb2tlbiIsIm9sZFZUb2tlbiIsImJvdHRvbVNhZmVBcmVhSGVpZ2h0IiwiY291bnRyeUlkIiwib3BlblVSTCIsInVybCIsIm9wZW5Sb3V0ZSIsInNldFRpbWVvdXQiLCJnZXRDb21tb25Db25maWciLCJwYXJhbSIsInBhcnNlSW50IiwiZ2V0UE5HSWNvblVSTEJ5Q3VycmVuY3kiLCJjdXJyZW5jeSIsImJhc2VVcmwiLCJ0b0xvd2VyQ2FzZSIsInNlbmRSZXF1ZXN0IiwicGF0aCIsInBhcmFtcyIsIm1ldGhvZCIsImhvc3RUeXBlIiwiaGVhZGVyIiwicmVzcG9uc2VTdHJpbmciLCJyZXF1ZXN0IiwicmVzcG9uc2UiLCJjb2RlIiwiZGF0YSIsInN0YXR1cyIsImVycl9jb2RlIiwiZXJyX21zZyIsInN0YXJ0Iiwic3RhcnRJbmRleCIsImVuZCIsImVuZEluZGV4IiwiZGF0YVN0cmluZyIsInNob3dUb2FzdCIsIm1lc3NhZ2UiLCJtc2ciLCJoYlRvYXN0Iiwic2hvd0xvYWRpbmciLCJpc1Nob3ciLCJEYXRlIiwiRm9ybWF0IiwiZm10IiwibyIsImdldE1vbnRoIiwiZ2V0RGF0ZSIsImdldEhvdXJzIiwiZ2V0TWludXRlcyIsImdldFNlY29uZHMiLCJmbG9vciIsIlMiLCJnZXRNaWxsaXNlY29uZHMiLCJSZWdFeHAiLCIkMSIsImdldEZ1bGxZZWFyIiwic3Vic3RyIiwiZm9ybWF0UHJlY2lzaW9uIiwicmVzdWx0IiwibnVtYmVyLmZvcm1hdCIsImdldFByaWNlU3RyaW5nIiwicHJpY2VTdHIiLCJwcmljZU51bSIsIk51bWJlciIsInByaWNlU3RyaW5nIiwiZmluYWxQcmljZVN0ciIsImdldFByaWNlQ29sb3IiLCJpc1Jpc2UiLCJjb250YWluZXJCYWNrIiwib3BlblBhZ2VXaXRoUGF0aCIsInVybFBhdGgiLCJnZXRMZWdhbEN1cnJlbmN5U3ltYm9sIiwiY3VycmVuY3lTeW1ib2wiLCJjdXJyZW5jeUNvbW1vbiIsImNvbnZlcnRMZWdhbFRlbmRlciIsInN5bWJvbCIsImFtb3VudCIsImN1cnJlbmN5U2NhbGUiLCJ0eXBlIiwicGFyYW1TdHJpbmciLCJmb3JtYXRCeU1pblByZWNpc2lvbiIsImFkZEN1cnJlbmN5U3ltYm9sIiwic291cmNlIiwic3RhcnRzV2l0aCIsInN0cnVjdHVyZWRfZHVhbERhdGEiLCJxYURhdGEiLCJpbmRleCIsImFuc3dlclZpc2FibGUiLCJRIiwiJGkxOG4iLCJuX3N0cnV0dXJlZF9RX2R1YWwiLCJBIiwibl9zdHJ1dHVyZWRfQV9kdWFsIiwiQTEiLCJBMiIsIkEzIiwiQTQiLCJBNSIsIkExU2hvdyIsIkEyU2hvdyIsIkEzU2hvdyIsIkE0U2hvdyIsIkE1U2hvdyIsInFhSWNvbiIsIm5fZG91YmxlX2NvaW5fZWFybl9pc3N1ZV90d28iLCJuX2RvdWJsZV9jb2luX2Vhcm5fYW5zd2VyX3R3b19wYXJ0X29uZSIsIm5fZG91YmxlX2NvaW5fZWFybl9hbnN3ZXJfdHdvX3BhcnRfdHdvIiwibl9kb3VibGVfY29pbl9lYXJuX2lzc3VlX3RocmVlIiwibl9kb3VibGVfY29pbl9lYXJuX2Fuc3dlcl90aHJlZV9wYXJ0X29uZSIsIm5fZG91YmxlX2NvaW5fZWFybl9hbnN3ZXJfdGhyZWVfcGFydF90d28iLCJuX2RvdWJsZV9jb2luX2Vhcm5fYW5zd2VyX3RocmVlX3BhcnRfdGhyZWUiLCJuX2RvdWJsZV9jb2luX2Vhcm5faXNzdWVfZm91cl9uZXciLCJuX2RvdWJsZV9jb2luX2Vhcm5fYW5zd2VyX2ZvdXIiLCJuX2RvdWJsZV9jb2luX2Vhcm5faXNzdWVfZml2ZSIsIm5fZG91YmxlX2NvaW5fZWFybl9hbnN3ZXJfZml2ZV9wYXJ0X29uZSIsIm5fZG91YmxlX2NvaW5fZWFybl9hbnN3ZXJfZml2ZV9wYXJ0X3R3b19jIiwibW9yZURhdGEiLCJuYW1lIiwibl9zdHJ1dHVyZWRfbW9yZV9zaW1wbGUiLCJkZXNjIiwibl9zdHJ1dHVyZWRfbW9yZV9zaW1wbGVfZGV0YWlsIiwiaWNvbiIsImp1bXBQYXRoIiwibl9zdHJ1dHVyZWRfbW9yZV9uZXciLCJuX3N0cnV0dXJlZF9kZXNjIiwibl9zdHJ1dHVyZWRfbW9yZV9vbmNoYWluIiwibl9zdHJ1dHVyZWRfbW9yZV9vbmNoYWluX2RldGFpbCIsImNvaW5EYXRhIiwic3RydWN0dXJlZF9zaGFya2ZpbkRhdGEiLCJuX3NoYXJrX2Zpbl9jb21tb25fcHJvYmxlbV9vbmUiLCJuX3NoYXJrX2Zpbl9jb21tb25fYW5zd2VyX29uZSIsIm5fc2hhcmtfZmluX2NvbW1vbl9wcm9ibGVtX3R3byIsIm5fc2hhcmtfZmluX2NvbW1vbl9hbnN3ZXJfdHdvX25ldyIsIm5fc2hhcmtfZmluX2NvbW1vbl9wcm9ibGVtX3RocmVlIiwibl9zaGFya19maW5fY29tbW9uX2Fuc3dlcl90aHJlZSIsIm5fc2hhcmtfZmluX2NvbW1vbl9wcm9ibGVtX2ZvdXIiLCJuX3NoYXJrX2Zpbl9jb21tb25fYW5zd2VyX2ZvdXJfYyIsIm5fc2hhcmtfZmluX2NvbW1vbl9wcm9ibGVtX2ZpdmVfbmV3Iiwibl9zaGFya19maW5fY29tbW9uX2Fuc3dlcl9maXZlX25ld19jIiwibl9zaGFya19maW5fY29tbW9uX3Byb2JsZW1fc2l4Iiwibl9zaGFya19maW5fY29tbW9uX2Fuc3dlcl9zaXgiLCJuX3NoYXJrX2Zpbl9jb21tb25fcHJvYmxlbV9zaXhfYSIsIm5fc2hhcmtfZmluX2NvbW1vbl9hbnN3ZXJfc2l4X2FfZmlyc3RfbmV3Iiwibl9zaGFya19maW5fY29tbW9uX2Fuc3dlcl9zaXhfYV9zZWNvbmRfbmV3Iiwibl9zaGFya19maW5fY29tbW9uX3Byb2JsZW1fc2V2ZW4iLCJuX3NoYXJrX2Zpbl9jb21tb25fYW5zd2VyX3NldmVuX2FfZmlyc3QiLCJuX3NoYXJrX2Zpbl9jb21tb25fYW5zd2VyX3NldmVuX2Ffc2Vjb25kIiwibl9zaGFya19maW5fY29tbW9uX2Fuc3dlcl9zZXZlbl9hX3RoaXJkIiwibl9zaGFya19maW5fY29tbW9uX2Fuc3dlcl9zZXZlbl9hX2ZvdXIiLCJuX3NoYXJrX2Zpbl9jb21tb25fYW5zd2VyX3NldmVuX3NlY29uZCIsIm5fc2hhcmtfZmluX2NvbW1vbl9hbnN3ZXJfc2V2ZW5fdGhpcmQiLCJuX3NoYXJrX2Zpbl9jb21tb25fcHJvYmxlbV9laWdodCIsIm5fc2hhcmtfZmluX2NvbW1vbl9hbnN3ZXJfZWlnaHRfbmV3X2MiLCJuX3NoYXJrX2Zpbl9jb21tb25fcHJvYmxlbV9uaW5lIiwibl9zaGFya19maW5fY29tbW9uX2Fuc3dlcl9uaW5lX25ldyIsIm5fc2hhcmtfZmluX2F1dG9TdWJzY3JpYmVfUV8xIiwibl9zaGFya19maW5fYXV0b1N1YnNjcmliZV9BXzFfMSIsIm5fc2hhcmtfZmluX2F1dG9TdWJzY3JpYmVfQV8xXzIiLCJuX3NoYXJrX2Zpbl9hdXRvU3Vic2NyaWJlX1FfMiIsIm5fc2hhcmtfZmluX2F1dG9TdWJzY3JpYmVfQV8yXzEiLCJuX3NoYXJrX2Zpbl9hdXRvU3Vic2NyaWJlX0FfMl8yIiwibl9zaGFya19maW5fYXV0b1N1YnNjcmliZV9BXzJfMyIsIm5fc2hhcmtfZmluX2F1dG9TdWJzY3JpYmVfUV8zIiwibl9zaGFya19maW5fYXV0b1N1YnNjcmliZV9BXzNfMSIsIm5fc2hhcmtfZmluX2F1dG9TdWJzY3JpYmVfQV8zXzIiLCJzaGFya2ZpbkRhdGEiLCJzdHJ1Y3R1cmVkX29ubHlPbmVTZWN0aW9uIiwibl9zdHJ1dHVyZWRfb25seW9uZV90aXRsZSIsImljb24xIiwidGl0bGUxIiwibl9zdHJ1dHVyZWRfb25seW9uZV9uYW1lXzEiLCJkZXNjMSIsIm5fc3RydXR1cmVkX29ubHlvbmVfZGVzY18xIiwiaWNvbjIiLCJ0aXRsZTIiLCJuX3N0cnV0dXJlZF9vbmx5b25lX25hbWVfMiIsImRlc2MyIiwibl9zdHJ1dHVyZWRfb25seW9uZV9kZXNjXzIiLCJpY29uMyIsInRpdGxlMyIsIm5fc3RydXR1cmVkX29ubHlvbmVfbmFtZV8zIiwiZGVzYzMiLCJuX3N0cnV0dXJlZF9vbmx5b25lX2Rlc2NfMyIsInN0cnVjdHVyZWRfcHJvYmxlbVNlY3Rpb24iLCJuX3NoYXJrX2Zpbl9jb21tb25fcHJvYmxlbSIsInNob3dNb3JlIiwidGFiSW5kZXgiLCJzdHJ1Y3R1cmVkX21vcmVTZWN0aW9uIiwibl9zdHJ1dHVyZWRfb3RoZXJzIiwidGFiS2V5IiwiaXNDbG9zZSIsImRlZmF1bHREYXRhIiwicmVmcmVzaCIsImN1cnJlbnRJbmRleCIsIm1haW5EYXRhIiwiY29uY2F0RHVhbERhdGEiLCJkdWFsVGFiIiwidGV4dFNpemUiLCJ0ZXh0Q29sb3IiLCJzaGFya2ZpblRhYiIsInNlbGVjdGVkVGFiIiwiZGVzY0RhdGEiLCJnZXREZXNjRGF0YSIsImRlc2NMaW5lU3BhY2luZyIsIm1hcmdpbkJvdHRvbSIsImJvdHRvbVNob3ciLCJnZXROYXZDb25maWdTdHJpbmciLCJ0aXRsZUtleSIsImxlZnQiLCJhY3Rpb24iLCJwYXJhbWV0ZXIiLCJiYWNrZ3JvdW5kQ29sb3IiLCJjb21tb24ubW9kdWxlRGVmaW5lIiwic3RhdHVzQmFyQ29uZmlnIiwic3RhdHVzQmFyTW9kZSIsImFkU3RhdHVzQmFyQ29sb3IiLCJzYWZlQm90dG9tVHJhbnNwYXJlbnQiLCJuYXZDb25maWciLCJjb21tb24uY29tbW9uRGF0YSIsImJvcmRlckNvbG9yIiwiaXNGaXJzdCIsInRpbWVyT2JqZWN0IiwicGFyYW1EaWMiLCJzZWxlY3RlZFR5cGUiLCJCb29sZWFuIiwidGFiQ2xpY2tlZCIsImNvbW1vbi5hbmFseXRpY3MiLCJwYWdlIiwic3RhcnRUaW1lciIsInJlcXVlc3RDb2luRGF0YXMiLCJyZXF1ZXN0U2hhcmtIb21lRGF0YSIsImNsZWFyVGltZXIiLCJ0aXRsZSIsIm5fc3RydXR1cmVkX2R1YWxfZGVzYyIsIm5fc3RydXR1cmVkX3NoYXJrZmluX2Rlc2MiLCJoaWdobGlnaHQiLCJuX3N0cnV0dXJlZF9tb3JlX2V4cGxhaW4iLCJoaWdobGlnaHRDb2xvciIsImFycm93Q29sb3IiLCJ0ZW1wRGF0YSIsImNvbmNhdCIsInByb2JsZW1TZWN0aW9uIiwiY29uY2F0U2hhcmtmaW5EYXRhIiwidGFiVHlwZSIsInRhYk5hbWUiLCJzaGFya2ZpblZpc2liaWxpdHkiLCJjbGlja0l0ZW0iLCJvcGVyYXRpb25UeXBlIiwiY3VyRGF0YSIsInVuZm9sZGVkVmlzaWJsZSIsImljb25fYXJyb3ciLCJ5aWVsZFRleHQiLCJ0b2tlbiIsImNvaW5OYW1lIiwib3BlcmF0ZSIsImFyclJhbmdlIiwic2hhcmtmaW5UYWJDbGlja2VkIiwic2VsZWN0VGFiS2V5IiwiY2xpY2tRQSIsIlFJbmRleCIsInFhbGlzdCIsImVsZW1lbnQiLCJvcmRlciIsImNvbW1vbi5zaG93TG9hZGluZyIsImNvbW1vbi5zZW5kUmVxdWVzdCIsImRhdGFMaXN0IiwibmF2aWdhdGlvbnMiLCJsaXN0Iiwib2JqZWN0IiwidG9VcHBlckNhc2UiLCJtYWluSWNvbiIsImNvbW1vbi5nZXRQTkdJY29uVVJMQnlDdXJyZW5jeSIsIml0ZW1zIiwiaXRlbSIsIiRpbnRlcmNlcHQiLCJuX2RvdWJsZV9jb2luX2Vhcm5fbG93X2J1eSIsIm5fZG91YmxlX2NvaW5fZWFybl9oaWdoX3NlbGwiLCJpZHhTdHIiLCJzaGFya1RhYktleSIsInNoYXJrSG9tZURhdGEiLCJvRGF0YSIsInRhYkluZm8iLCJ0YWJWaXNhYmxlIiwibXVBcnJheSIsImJhY2tncm91bmQiLCJ0YWIwIiwidGFiMSIsInNoYXJrSW5mbyIsImNvbnRlbnRWaXNhYmxlIiwicXVvdGVDdXJyZW5jeSIsInZpZXdTdGF0dXMiLCJzdGFydFRpbWUiLCJlbmRUaW1lIiwic3Vic2NyaWJlU3RhcnRUaW1lIiwic3Vic2NyaWJlRW5kVGltZSIsInRvdGFsTGltaXQiLCJjb21tb24uZ2V0UHJpY2VTdHJpbmciLCJmaW5pc2hBbW91bnQiLCJmaW5pc2hQcm9wb3J0aW9uIiwicGFyc2VGbG9hdCIsIndpZHRoIiwic1RpbWUiLCJzZXJ2aWNlVGltZUludGVydmFsIiwiZ2V0VGltZSIsInN1YnNjcmlwdGlvblRpdGxlIiwibl9zaGFya19maW5fZGVwb3NpdF9vcGVuIiwic3Vic2NyaXB0aW9uRGF0ZSIsImlzWmVybyIsInVwZGF0ZUNvdW50RG93biIsInByb2dyZXNzVmlzYWJsZSIsImNvdW50ZG93blZpc2FibGUiLCJzdWJzY3JpcHRpb25EYXRlVmlzYWJsZSIsIm5fc2hhcmtfZmluX2RlcG9zaXRfY2xvc2UiLCJuX3NoYXJrX2Zpbl9kZXBvc2l0X2Nsb3NlZCIsImRlcG9zaXRBbW91bnRUaXRsZSIsIm5fc2hhcmtfZmluX2RlcG9zaXRfYW1vdW50IiwiYXJyYXkiLCJwcm9qZWN0cyIsInRtcE9iaiIsIm9iaiIsImlkeCIsImNhbGxQdXQiLCJuX3NoYXJrX2Zpbl9iZWFyaXNoIiwibl9zaGFya19maW5fYnVsbGlzaCIsInRlcm0iLCJuX21pbmluZ19kYXlfdGV4dCIsImVhcm5pbmdzIiwiY29tbW9uLmZvcm1hdFByZWNpc2lvbiIsIm51bWJlci5tdWx0aXBseSIsIm1pblJhdGUiLCJtYXhSYXRlIiwiY2VsbFR5cGUiLCJ0ZXJtU3RyIiwicHJvamVjdElkIiwicHJvZHVjdExpc3QiLCJkYXRlIiwidGltZU1hcCIsImdldENvdW50RG93bk1hcCIsImNvdW50ZG93biIsImRheSIsImhvdXIiLCJtaW51dGUiLCJzZWNvbmQiLCJzaG93RGF5IiwiYmVnaW5EYXRlIiwibmV3RGF0ZSIsIm1pbGxpc2Vjb25kcyIsImludGVydmFsIiwiaCIsIm0iLCJzZXRJbnRlcnZhbCIsInRpbWVyIiwiY2xlYXJJbnRlcnZhbCIsInRvRXhwbGFpbiIsImNvbW1vbi5vcGVuUGFnZVdpdGhQYXRoIiwiZXhwbGFuYXRpb25DbGFzc2lmeSIsInRvTW9yZUV4cGxhaW4iLCJ0b0ludHJvZHVjZSIsInRvRGV0YWlsIiwicmF3T2JqZWN0IiwiYXJyIiwic3VwcG9ydFF1b3RlcyIsImdvRGVwb3NpdCIsImdvSGlzdG9yeSIsImNsaWNrUHJvZHVjdFBhZ2UiLCJjb21tb24uY29udGFpbmVyQmFjayIsImJvdHRvbU9yZGVyQ2xpY2tlZCIsImJvdHRvbUN1c3RvbUNsaWNrZWQiLCJiYWNrQ2xpY2tlZCIsIm5lZWRBZGRTaG93IiwicHJvZHVjdEV4cGxhbmF0aW9uSnNvbiIsImludHJvX2hlYWRlckRhdGEiLCJ0ZXh0Iiwibl9zaGFya19maW5fcHJvZHVjdF9ydWxlIiwiYmFja0NvbG9yIiwiaW50cm9fc2ltcGxlX2luZm8iLCJuX3N0cnV0dXJlZF9zaW1wbGVfSF8xIiwibl9zdHJ1dHVyZWRfc2ltcGxlX1RfMSIsIm5fc3RydXR1cmVkX3NpbXBsZV9IXzIiLCJuX3N0cnV0dXJlZF9zaW1wbGVfVF8yXzEiLCJuX3N0cnV0dXJlZF9zaW1wbGVfVF8yXzIiLCJuX3N0cnV0dXJlZF9zaW1wbGVfVF8yXzMiLCJuX3N0cnV0dXJlZF9zaW1wbGVfSF8zIiwibl9zdHJ1dHVyZWRfc2ltcGxlX1RfMyIsIm5fc3RydXR1cmVkX2ludHJvX0FfM18yIiwibl9zdHJ1dHVyZWRfaW50cm9fQV8zXzMiLCJpbnRyb19zaW1wbGVfZmxleGkiLCJuX3N0cnV0dXJlZF9mbGV4aV9lYXJuIiwibl9zdHJ1dHVyZWRfZmxleGlfZWFybl8xIiwibl9zdHJ1dHVyZWRfZmxleGlfZWFybl8yIiwibl9zdHJ1dHVyZWRfZmxleGlfZWFybl8zIiwibl9zdHJ1dHVyZWRfZmxleGlfZWFybl80Iiwibl9zdHJ1dHVyZWRfZmxleGlfd2l0aGRyYXciLCJuX3N0cnV0dXJlZF9mbGV4aV93aXRoZHJhd18xIiwibl9zdHJ1dHVyZWRfZmxleGlfd2l0aGRyYXdfMiIsIm5fc3RydXR1cmVkX2ZsZXhpX3dpdGhkcmF3XzMiLCJuX3N0cnV0dXJlZF9mbGV4aV93aXRoZHJhd180Iiwibl9zdHJ1dHVyZWRfZmxleGlfUV8xIiwibl9zdHJ1dHVyZWRfZmxleGlfQV8xIiwibl9zdHJ1dHVyZWRfZmxleGlfUV8yIiwibl9zdHJ1dHVyZWRfZmxleGlfQV8yIiwibl9zdHJ1dHVyZWRfb25jaGFpbl9RXzQiLCJuX3N0cnV0dXJlZF9mbGV4aV9RXzQiLCJuX3N0cnV0dXJlZF9mbGV4aV9BXzQiLCJuX3N0cnV0dXJlZF9mbGV4aV9tYXhfZWFybl8xIiwibl9zdHJ1dHVyZWRfZmxleGlfbWF4X2Vhcm5fMiIsIm5fc3RydXR1cmVkX2ZsZXhpX21heF9lYXJuXzMiLCJuX3N0cnV0dXJlZF9mbGV4aV9tYXhfZWFybl80Iiwibl9zdHJ1dHVyZWRfZmxleGlfbWF4X3dpdGhkcmF3XzEiLCJuX3N0cnV0dXJlZF9mbGV4aV9tYXhfd2l0aGRyYXdfMiIsIm5fc3RydXR1cmVkX2ZsZXhpX21heF9RXzEiLCJuX3N0cnV0dXJlZF9mbGV4aV9tYXhfQV8xIiwibl9zdHJ1dHVyZWRfZmxleGlfbWF4X1FfMiIsIm5fc3RydXR1cmVkX2ZsZXhpX21heF9BXzIiLCJuX3N0cnV0dXJlZF9mbGV4aV9tYXhfUV8zIiwibl9zdHJ1dHVyZWRfZmxleGlfbWF4X0FfMyIsIm5fc3RydXR1cmVkX2ZsZXhpX21heF9RXzQiLCJuX3N0cnV0dXJlZF9mbGV4aV9tYXhfQV80XzEiLCJuX3N0cnV0dXJlZF9mbGV4aV9tYXhfQV80XzIiLCJuX3N0cnV0dXJlZF9mbGV4aV9tYXhfQV80XzMiLCJuX3N0cnV0dXJlZF9mbGV4aV9tYXhfQV80XzQiLCJuX3N0cnV0dXJlZF9mbGV4aV9tYXhfQV80XzUiLCJpbnRyb19zaW1wbGVfZml4ZWQiLCJuX3N0cnV0dXJlZF9maXhlZF9lYXJuXzEiLCJuX3N0cnV0dXJlZF9maXhlZF9lYXJuXzIiLCJuX3N0cnV0dXJlZF9maXhlZF9lYXJuXzMiLCJuX3N0cnV0dXJlZF9maXhlZF93aXRoZHJhdyIsIm5fc3RydXR1cmVkX2ZpeGVkX1FfMCIsIm5fc3RydXR1cmVkX2ZpeGVkX0FfMSIsIm5fc3RydXR1cmVkX2ZpeGVkX1FfMSIsIm5fc3RydXR1cmVkX2ZpeGVkX0FfMiIsImludHJvX3NpbXBsZSIsInRpdGxlSW5kZXgiLCJ0aXRsZURhdGEiLCJuX3N0cnV0dXJlZF9wcm9kdWN0c19zdW0iLCJ0aXRsZVNpemUiLCJ0aXRsZUNvbG9yIiwidGFnIiwic2VsZWN0ZWRsaW5lIiwibl9hc3NldF9lYXJuX2N1cnJlbnQiLCJuX21pbmluZ19hc3NldF9maXhlZCIsInNsaWRlckRhdGEiLCJsaXN0VHlwZSIsImhlYWRlclZpc2liIiwiaGVhZGVyRGF0YSIsImNlbGxEYXRhIiwiY2VsbERhdGFsaXN0IiwiaW50cm9fbmV3X2luZm8iLCJuX3N0cnV0dXJlZF9uZXdfSF8xIiwibl9zdHJ1dHVyZWRfbmV3X1RfMSIsIm5fc3RydXR1cmVkX25ld19IXzIiLCJuX3N0cnV0dXJlZF9uZXdfVF8yXzEiLCJuX3N0cnV0dXJlZF9uZXdfVF8yXzIiLCJuX3N0cnV0dXJlZF9uZXdfVF8yXzMiLCJuX3N0cnV0dXJlZF9uZXdfSF8zIiwiaW50cm9fbmV3X3Byb2JsZW0iLCJuX3N0cnV0dXJlZF9uZXdfUV8xIiwibl9zdHJ1dHVyZWRfbmV3X0FfMSIsIm5fc3RydXR1cmVkX25ld19RXzIiLCJuX3N0cnV0dXJlZF9uZXdfQV8yIiwibl9zdHJ1dHVyZWRfbmV3X1FfMyIsIm5fc3RydXR1cmVkX25ld19BXzMiLCJpbnRyb19uZXciLCJpbnRyb19vbmNoYWluX2luZm8iLCJuX3N0cnV0dXJlZF9vbmNoYWluX0hfMSIsIm5fc3RydXR1cmVkX29uY2hhaW5fVF8xIiwibl9zdHJ1dHVyZWRfb25jaGFpbl9IXzIiLCJuX3N0cnV0dXJlZF9vbmNoYWluX1RfMiIsIm5fc3RydXR1cmVkX29uY2hhaW5fSF8zIiwibl9zdHJ1dHVyZWRfb25jaGFpbl9UXzNfMSIsIm5fc3RydXR1cmVkX29uY2hhaW5fVF8zXzIiLCJuX3N0cnV0dXJlZF9vbmNoYWluX1RfM18zIiwibl9zdHJ1dHVyZWRfb25jaGFpbl9IXzQiLCJuX3N0cnV0dXJlZF9vbmNoYWluX1RfNCIsImludHJvX29uY2hhaW5fcnVsZSIsIm5fc3RydXR1cmVkX29uY2hhaW5fZWFybiIsIm5fc3RydXR1cmVkX29uY2hhaW5fZWFybl8xIiwibl9zdHJ1dHVyZWRfb25jaGFpbl9lYXJuXzIiLCJuX3N0cnV0dXJlZF9vbmNoYWluX2Vhcm5fMyIsIm5fc3RydXR1cmVkX29uY2hhaW5fd2l0aGRyYXdfMSIsImludHJvX29uY2hhaW5fcHJvYmxlbSIsIm5fc3RydXR1cmVkX29uY2hhaW5fUV8xIiwibl9zdHJ1dHVyZWRfb25jaGFpbl9BXzEiLCJuX3N0cnV0dXJlZF9vbmNoYWluX1FfMiIsIm5fc3RydXR1cmVkX29uY2hhaW5fQV8yIiwibl9zdHJ1dHVyZWRfb25jaGFpbl9RXzMiLCJuX3N0cnV0dXJlZF9vbmNoYWluX0FfM18xIiwibl9zdHJ1dHVyZWRfb25jaGFpbl9BXzNfMiIsIm5fc3RydXR1cmVkX29uY2hhaW5fQV80Iiwibl9zdHJ1dHVyZWRfb25jaGFpbl9RXzUiLCJuX3N0cnV0dXJlZF9vbmNoYWluX0FfNSIsImludHJvX29uY2hhaW4iLCJpbnRyb19zdHJ1Y3R1cmVkX2luZm8iLCJuX3N0cnV0dXJlZF9pbnRyb19RXzEiLCJuX3N0cnV0dXJlZF9pbnRyb19BXzEiLCJuX3N0cnV0dXJlZF9pbnRyb19RXzIiLCJuX3N0cnV0dXJlZF9pbnRyb19BXzJfMSIsIm5fc3RydXR1cmVkX2ludHJvX0FfMl8yIiwibl9zdHJ1dHVyZWRfaW50cm9fQV8yXzMiLCJuX3N0cnV0dXJlZF9pbnRyb19RXzMiLCJuX3N0cnV0dXJlZF9pbnRyb19BXzNfMSIsImludHJvX2R1YWwiLCJuX2RvdWJsZV9jb2luX2Vhcm5faXNzdWVfb25lIiwibl9zdHJ1dHVyZWRfQV9kdWFsX24iLCJuX2RvdWJsZV9jb2luX2Vhcm5pbmdzX2NvbmZpcm1faG93Iiwibl9kb3VibGVfY29pbl9lYXJuaW5nc19jb25maXJtIiwibl9kb3VibGVfY29pbl9odHhfYWR2YW50YWdlX3doYXRfbiIsIm5fZG91YmxlX2NvaW5faHR4X2FkdmFudGFnZV9vbmVfbiIsIm5fZG91YmxlX2NvaW5faHR4X2FkdmFudGFnZV9vbmVfaW5mb19uIiwibl9kb3VibGVfY29pbl9odHhfYWR2YW50YWdlX3R3byIsIm5fZG91YmxlX2NvaW5faHR4X2FkdmFudGFnZV9pbmZvIiwibl9kb3VibGVfY29pbl9odHhfYWR2YW50YWdlX3RocmVlIiwibl9kb3VibGVfY29pbl9odHhfYWR2YW50YWdlX3RocmVlX2luZm8iLCJuX2RvdWJsZV9jb2luX3Rlcm1fZGVmaW5pdGlvbiIsIm5fZG91YmxlX2NvaW5fdGVybV9kZWZpbml0aW9uX29uZSIsIm5fZG91YmxlX2NvaW5fdGVybV9kZWZpbml0aW9uX3R3byIsIm5fZG91YmxlX2NvaW5fdGVybV9kZWZpbml0aW9uX3RocmVlIiwibl9kb3VibGVfY29pbl90ZXJtX2RlZmluaXRpb25fc2l4Iiwibl9kb3VibGVfY29pbl90ZXJtX2RlZmluaXRpb25fc2V2ZW4iLCJuX2RvdWJsZV9jb2luX3Rlcm1fZGVmaW5pdGlvbl9laWdodF9sYXRlc3QiLCJuX2RvdWJsZV9jb2luX3Byb2R1Y3Rfb3BlcmF0aW9uX2hvdyIsIm5fZG91YmxlX2NvaW5fcHJvZHVjdF9vcGVyYXRpb25fY2F0ZSIsIm5fZG91YmxlX2NvaW5fcHJvZHVjdF9vcGVyYXRpb25fZWciLCJuX2RvdWJsZV9jb2luX3Byb2R1Y3Rfb3BlcmF0aW9uX2VnX3NlbGwiLCJuX2RvdWJsZV9jb2luX3Byb2R1Y3Rfb3BlcmF0aW9uX2VnX3NlbGxfaW5mbyIsIm5fZG91YmxlX2NvaW5fcHJvZHVjdF9vcGVyYXRpb25fZWdfc2VsbF9vbmUiLCJuX2RvdWJsZV9jb2luX3Byb2R1Y3Rfb3BlcmF0aW9uX2VnX3NlbGxfb25lX2dyZWF0ZXIiLCJib3R0b21IZWlnaHQiLCJuX2RvdWJsZV9jb2luX3Byb2R1Y3Rfb3BlcmF0aW9uX2VnX3NlbGxfb25lX2xlc3MiLCJuX2RvdWJsZV9jb2luX3Byb2R1Y3Rfb3BlcmF0aW9uX2VnX3NlbGxfdHdvIiwibl9kb3VibGVfY29pbl9wcm9kdWN0X29wZXJhdGlvbl9lZ19zZWxsX3R3b190d28iLCJuX2RvdWJsZV9jb2luX3Byb2R1Y3Rfb3BlcmF0aW9uX2VnX3NlbGxfdHdvX3RocmVlIiwibl9kb3VibGVfY29pbl9wcm9kdWN0X29wZXJhdGlvbl9lZ19zZWxsX2FsbCIsIm5fZG91YmxlX2NvaW5fcHJvZHVjdF9vcGVyYXRpb25fZW5zYW1wbGUiLCJuX2RvdWJsZV9jb2luX2Vuc2FtcGxlX3NlbGxfaW5mbyIsIm5fZG91YmxlX2NvaW5fZW5zYW1wbGVfc2VsbF9vbmUiLCJuX2RvdWJsZV9jb2luX2Vuc2FtcGxlX3NlbGxfb25lX2luZm8iLCJuX2RvdWJsZV9jb2luX2Vuc2FtcGxlX3NlbGxfdHdvIiwibl9kb3VibGVfY29pbl9lbnNhbXBsZV9zZWxsX3R3b19pbmZvIiwibl9kb3VibGVfY29pbl9lbnNhbXBsZV9zZWxsX3RocmVlIiwibl9kb3VibGVfY29pbl9lbnNhbXBsZV9zZWxsX3RocmVlX2luZm8iLCJuX2RvdWJsZV9jb2luX3Byb2R1Y3Rfb3BlcmF0aW9uX2VnX2J1eSIsIm5fZG91YmxlX2NvaW5fcHJvZHVjdF9vcGVyYXRpb25fZWdfYnV5X2luZm8iLCJuX2RvdWJsZV9jb2luX3Byb2R1Y3Rfb3BlcmF0aW9uX2VnX2J1eV9vbmVfbGVzcyIsIm5fZG91YmxlX2NvaW5fcHJvZHVjdF9vcGVyYXRpb25fZWdfYnV5X29uZV9ncmVhdGVyIiwibl9kb3VibGVfY29pbl9wcm9kdWN0X29wZXJhdGlvbl9lZ19idXlfdHdvX3R3byIsIm5fZG91YmxlX2NvaW5fcHJvZHVjdF9vcGVyYXRpb25fZWdfYnV5X3R3b190aHJlZSIsIm5fZG91YmxlX2NvaW5fcHJvZHVjdF9vcGVyYXRpb25fZWdfYnV5X2FsbCIsIm5fZG91YmxlX2NvaW5fZW5zYW1wbGVfYnV5X2luZm8iLCJuX2RvdWJsZV9jb2luX2Vuc2FtcGxlX2J1eV9vbmUiLCJuX2RvdWJsZV9jb2luX2Vuc2FtcGxlX2J1eV9vbmVfaW5mbyIsIm5fZG91YmxlX2NvaW5fZW5zYW1wbGVfYnV5X3R3byIsIm5fZG91YmxlX2NvaW5fZW5zYW1wbGVfYnV5X3R3b19pbmZvIiwibl9kb3VibGVfY29pbl9lbnNhbXBsZV9idXlfdGhyZWUiLCJuX2RvdWJsZV9jb2luX2Vuc2FtcGxlX2J1eV90aHJlZV9pbmZvIiwiaW50cm9fc2hhcmtmaW4iLCJuX3NoYXJrX2Zpbl90aGVvcnlfcXVlc3Rpb24iLCJuX3NoYXJrX2Zpbl90aGVvcnlfYW5zd2VyX25ldyIsIm5fc2hhcmtfZmluX3RoZW9yeV9kaXNjbGFpbWVyIiwibl9zaGFya19maW5fdXAiLCJzcmMiLCJuX3NoYXJrX2Zpbl91cF9pc3N1ZV9vbmVfZmlyc3QiLCJuX3NoYXJrX2Zpbl91cF9pc3N1ZV9vbmVfc2Vjb25kIiwibl9zaGFya19maW5fdXBfaXNzdWVfb25lX3RoaXJkIiwibl9zaGFya19maW5fdXBfaXNzdWVfdHdvX2ZpcnN0Iiwibl9zaGFya19maW5fdXBfaXNzdWVfdHdvX3NlY29uZCIsIm5fc2hhcmtfZmluX3VwX2lzc3VlX3R3b190aGlyZCIsIm5fc2hhcmtfZmluX3VwX2lzc3VlX3R3b19mb3VydGgiLCJuX3NoYXJrX2Zpbl91cF9pc3N1ZV90aHJlZV9maXJzdCIsIm5fc2hhcmtfZmluX3VwX2lzc3VlX3RocmVlX3NlY29uZCIsIm5fc2hhcmtfZmluX3VwX2lzc3VlX3RocmVlX3RoaXJkIiwibl9zaGFya19maW5fZG93biIsIm5fc2hhcmtfZmluX2Rvd25faXNzdWVfb25lX2ZpcnN0Iiwibl9zaGFya19maW5fZG93bl9pc3N1ZV9vbmVfc2Vjb25kIiwibl9zaGFya19maW5fZG93bl9pc3N1ZV9vbmVfdGhpcmQiLCJuX3NoYXJrX2Zpbl9kb3duX2lzc3VlX3R3b19maXJzdCIsIm5fc2hhcmtfZmluX2Rvd25faXNzdWVfdHdvX3NlY29uZCIsIm5fc2hhcmtfZmluX2Rvd25faXNzdWVfdHdvX3RoaXJkIiwibl9zaGFya19maW5fZG93bl9pc3N1ZV90d29fZm91cnRoIiwibl9zaGFya19maW5fZG93bl9pc3N1ZV90aHJlZV9maXJzdCIsIm5fc2hhcmtfZmluX2Rvd25faXNzdWVfdGhyZWVfc2Vjb25kIiwibl9zaGFya19maW5fZG93bl9pc3N1ZV90aHJlZV90aGlyZCIsIm5fc2hhcmtfZmluX2lzc3VlX25vdGVfMSIsImludHJvX3N0cnVjdHVyZWQiLCJuX3N0cnV0dXJlZF9kdWFsIiwibl9zaGFya19maW4iLCJuX2RvdWJsZV9jb2luX3BheW1lbnRfcmVndWxhdGlvbiIsImludHJvX25hdkxpc3QiLCJpbnRyb19hbmFseXRpY3MiLCJwcm9kdWN0Q2xhc3NpZnkiLCJuYXZJbmRleCIsIm5hdlRpdGxlIiwibmF2RGF0YSIsInNlbGVjdGVkIiwibl9zdHJ1dHVyZWRfbW9yZV9uZXdfZGV0YWlsIiwibl9zdHJ1dHVyZWRfcHJvZHVjdHMiLCJuYXZDb250YWluZXIiLCJwb3BTaG93IiwibmF2QXJyb3ciLCJ1bmRlZmluZWQiLCJpc05hTiIsIm5hdkNsaWNrZWQiLCJyZXNldFRpdGxlU2VsZWN0VGFiIiwiaGVhZGVySW5kZXgiLCJoZWFkZXJDbGlja2VkIiwicG9wR3VpZGVTaG93IiwicHJvZHVjdEV4cGxhbmF0aW9uU2hvdyIsImd1aWRlU2hvdyIsInN0b3JhZ2UiLCJrZXkiLCJoaWRlSW50cm9Qb3AiLCJuYXZNb2RlbCIsInNlbGVjdGVkTmF2Q2xpY2tlZCIsImNsaWNrZWQiLCJ0YWJDbGljayIsImN1ciIsImhlYWRlckNlbGxsaXN0IiwibW9kZWwiLCJjbGFzc2lmeSIsImxvYWRpbmdMb3R0aWVWaXMiLCJsb2FkaW5nTG90dGllU3RhdHVzIiwiZnVuY0xpc3QiLCJ0b3RhbEluY29tZSIsInllc3RlcmRheUluY29tZSIsInRvdGFsSW5jb21lUmljaCIsImJhbm5lckxpc3QiLCJzaG93SW5kaWNhdG9yIiwicmVjb21tZW5kMUljb25VcmwiLCJyZWNvbW1lbmQxQ3VycmVuY3kiLCJyZWNvbW1lbmQxVGFnTmFtZSIsInJlY29tbWVuZDFUYWdCZyIsInJlY29tbWVuZDFUYWdUZXh0Q29sb3IiLCJyZWNvbW1lbmQxQXB5IiwicmVjb21tZW5kMVByb2oiLCJyZWNvbW1lbmQySWNvblVybCIsInJlY29tbWVuZDJDdXJyZW5jeSIsInJlY29tbWVuZDJUYWdOYW1lIiwicmVjb21tZW5kMlRhZ0JnIiwicmVjb21tZW5kMlRhZ1RleHRDb2xvciIsInJlY29tbWVuZDJBcHkiLCJyZWNvbW1lbmQyUHJvaiIsIm5leHRJdGVtTmFtZSIsIm5leHRUaXRsZSIsInJlY29tbWVuZExpc3QiLCJxYUxpc3QiLCJyZWZyZXNoU3RhdHVzIiwicG9wMVNob3ciLCJwb3AyU2hvdyIsInBvcDNTaG93IiwicG9wNFNob3ciLCJuZXdMaW5lU3BhY2luZyIsInZpcEljb24iLCJ1cGdyYWRlQmdDb2xvciIsInNjcm9sbFRvUG9zIiwib3JpZ2luTWFpbkRhdGEiLCJpbnRlcmNhbCIsIm1tIiwiaGgiLCJkZCIsInNoYXJrRmluQ291bnQiLCJqc29uUGFyYW1ldGVycyIsImhhbmRsZVRvdGFsSW5jb21lUmljaCIsImluaXRVSSIsImdldEd1aWRlU3RhdHVzIiwicmVxdWVzRWFybkhvbWVEYXRhIiwidGVtcEZ1bmMiLCJqdW1wVXJsIiwiZWRnZUVuZ2luZVBhZ2VJZCIsIm5vdyIsImN1cnJlbmN5TmFtZSIsInBhZ2VMb2FkU3RhdGUiLCJpbmNvbWUiLCJ0b3RhbEtleSIsInRvdGFsIiwieWVzdGVyZGF5S2V5IiwieWVzdGVyZGF5IiwiYmFubmVyIiwidGVtcEJhbm5lciIsImZvckVhY2giLCJhcmVhVHlwZSIsInByb2plY3QiLCJwcm9qVHlwZSIsIm51bWJlci5kaXZpZGUiLCJyYWlzaW5nIiwicmFpc2VHb2FsIiwiZmlyc3RQcm9ncmVzcyIsInNlY29uZFByb2dyZXNzIiwic3RhcnRTaGFya0ZpbkNvdW50RG93biIsImljb25VcmwiLCJiYW5uZXJQaWMiLCJpbWFnZVVybCIsIm5pZ2h0SW1hZ2VVcmwiLCJvcmlnaW5BcHkiLCJvcmlnaW5BcHlWaXMiLCJiYW5uZXJJbmRleENoYW5nZSIsInJlY29tbWVuZCIsInJlY29tbWVuZDEiLCJhcHkiLCJwcm9qIiwicmVjb21tZW5kMUljb25WaXMiLCJyZWNvbW1lbmQxVGFnVmlzIiwicmVjb21tZW5kMUljb25TcmMiLCJnZXRUYWdJY29uQnlUeXBlIiwidGFnTmFtZSIsImdldFRhZ0JnQnlUeXBlIiwiZ2V0VGFnVGV4dENvbG9yQnlUeXBlIiwicmVjb21tZW5kMiIsInJlY29tbWVuZDJJY29uVmlzIiwicmVjb21tZW5kMlRhZ1ZpcyIsInJlY29tbWVuZDJJY29uU3JjIiwibmV4dCIsIml0ZW1OYW1lIiwidGVtcEl0ZW1zIiwic2Nyb2xsVG9Qb3NUZW1wIiwibGlzdE1haW5UYWdWaXMiLCJob2xkIiwiaG9sZFZpcyIsInBhcmVudFBhZGRpbmciLCJleHBhbmQiLCJoYXNDdXJyZW5jeSIsImNoaWxkVmlzIiwiZXhwYW5kU3RhdHVzUmVzIiwiYXB5VmlzIiwidGFnQXB5IiwiY291cG9uVmlzIiwiY291cG9uVmFsdWUiLCJpY29uU3JjIiwiaWNvblZpcyIsInRhZ0JnIiwidGFnVGV4dENvbG9yIiwidGVtcENoaWxkIiwiY2hpbGRFbGVtZW50IiwidGFnVmlzIiwidmlwSWNvblZpcyIsImVhcm5WaXBWaXMiLCJob21lIiwiY29pbkFuYWx5dGljcyIsImVycm9yTXNnIiwicGFnZUxvYWRUaW1lIiwibmF0aW9uIiwic3BhY2VDb2xvciIsImNvaW5EdGEiLCJ0c0Jhc2VJbmZvIiwiY2hhbmdlQ291bnRkb3duIiwicmF3QXJyYXkiLCJjb3VudERvd24iLCJzaG93SCIsInNob3dNIiwic2hvd1MiLCJjb3VudERvd25TdHIiLCJuX2V4Y2hhbmdlX2NhbGxfYXVjdGlvbl9lbmRfb2ZfZGlzdGFuY2UiLCJmdW5jQ2xpY2siLCJ0ZW1wUWFMaXN0IiwiaXRlbUNsaWNrIiwidGVtcEVsZW1lbnQiLCJqdW1wUHJvZHVjdCIsInByb2plY3RJZHMiLCJwcm9qZWN0VHlwZSIsIm5leHRJdGVtQ2xpY2siLCJzZWFyY2hDbGljayIsImluQ29tZUNsaWNrIiwiYXV0b0Vhcm5DbGljayIsInByb2R1Y3RDbGljayIsInBhcmVudEluZGV4IiwiY2hpbGRJbmRleCIsInBhcmVudEVsZW1lbnQiLCJiYW5uZXJDbGljayIsInBhcmFtZXRlcnMiLCJiYW5uZXJBbmFseXRpY3NQYXJhbWV0ZXJzIiwicmVjb21tZW5kMUp1bXAiLCJzdGF0ZSIsIm1hdGVyaWFsSWQiLCJmcmFtZSIsInJlY29tbWVuZDJKdW1wIiwibmV4dFBvcCIsInN0ZXAiLCJ1cGxvYWRMb2ciLCJoaWRlUG9wIiwiYWR2SWQiLCJwcm9qVHlwZXBlIiwidG9SZWNvcmQiLCJiYWNrQ29udGFpbmVyIiwiY2xpY2tNb3JlUUEiLCJpbmZvIiwiY29pbkRhdGFSbCIsImxvYWRNb3JlU3RhdHVzIiwic2VhcmNoTGlzdCIsInNlYXJjaElucHV0Iiwib25Gb2N1cyIsImNsZWFySW5wdXRWaXMiLCJiYWNrVmlzIiwic2VhcmNoSGlzdG9yeVZpcyIsImVtcHR5RGF0YVZpcyIsImFsbENvaW5UaXRsZVZpcyIsInNlcmFjaE1hcmdpbkxlZnQiLCJzaXplIiwiaXNSZWZyZXNoIiwibGFzdERhdGFTaXplIiwic2VhcmNoSGlzdG9yeURhdGEiLCJyZXF1ZXN0VGltZW91dCIsIm5lZWRPbkZvY3VzIiwicmVxdWVzdENvaW5EYXRhIiwiZnJvbVR5cGUiLCJpbml0U2VhcmNoSGlzdG9yeURhdGEiLCJoaXN0b3J5RGF0YSIsImdldERpc2tTZWFyY2hEYXRhIiwiZWxlbWVudDIwIiwiY29pbkxpc3QiLCJzYXZlSXRlbTJEaXNrIiwia2V5d29yZCIsInNhdmVMaXN0IiwiZGlza0RhdGEiLCJzcGxpY2UiLCJmaWx0ZXIiLCJsb2FkTW9yZSIsImhpc3RvcnlDbGljayIsImNsaWNrU3RyIiwidGV4dENoYW5nZSIsIm9uUmV0dXJuIiwiZm9jdXNDaGFuZ2UiLCJjYW5jZWwiLCJjbGVhckZvY3VzIiwiY2xlYXJJbnB1dCIsImNsZWFyU2VhcmNoSGlzdG9yeSIsImNoaWxkSXRtQ2xpY2siLCJGaW5hbmNlR3JvdXBUeXBlIiwic3RhdGljIiwiZ2V0UmVxdWVzdFR5cGUiLCJncm91cFR5cGUiLCJTUE9UX0RFUE9TSVQiLCJTUE9UX1dJVEhEUkFXIiwiU1BPVF9QT0lOVCIsIlNQT1RfVFJBTlNGRVJfSU4iLCJTUE9UX1RSQU5TRkVSX09VVCIsIlNQT1RfU1lTVEVNIiwiZ2V0U3BvdEZpbmFuY2VUeXBlV2l0aEdyb3VwIiwiZ3JvdXAiLCJnZXRTcG90RGlzcGxheVR5cGUiLCJmaW5hbmNlVHlwZSIsIm5fY29pbmRldGFpbF9oaXN0b3J5X2RlcG9zaXQiLCJuX2NvaW5kZXRhaWxfaGlzdG9yeV93aXRoZHJhdyIsIm5fY29pbmRldGFpbF9oaXN0b3J5X3BvaW50Iiwibl9jb2luZGV0YWlsX2hpc3RvcnlfaW4iLCJuX2NvaW5kZXRhaWxfaGlzdG9yeV9vdXQiLCJuX2NvaW5kZXRhaWxfaGlzdG9yeV9vdGhlciIsImdldFNwb3RGaW5hbmNlU3RhdGUiLCJmaW5hbmNlVGFiVHlwZSIsInN0YXRlU3RyIiwibl9jb2luZGV0YWlsX2hpc3Rvcnlfc3RhdHVzX2NvbXBsZXRlZCIsIm5fY29pbmRldGFpbF9oaXN0b3J5X3N0YXR1c19jb25maXJtaW5nIiwibl9jb2luZGV0YWlsX2hpc3Rvcnlfc3RhdHVzX29ycGhhbiIsIm5fY29pbmRldGFpbF9oaXN0b3J5X3N0YXR1c190b19iZV9jcmVkaXRlZCIsIm5fY29pbmRldGFpbF9oaXN0b3J5X3N0YXR1c19zbWFsbF9hbW91bnRfaXNfbm90X2FjY291bnRlZCIsIm5fY29pbmRldGFpbF9oaXN0b3J5X3N0YXR1c193YWl0aW5nX3JldmlldyIsIm5fY29pbmRldGFpbF9oaXN0b3J5X3N0YXR1c19wcm9jZXNzaW5nIiwibl9jb2luZGV0YWlsX2hpc3Rvcnlfc3RhdHVzX3JlZnVzZWQiLCJuX2NvaW5kZXRhaWxfaGlzdG9yeV9zdGF0dXNfc2VuZCIsIm5fY29pbmRldGFpbF9oaXN0b3J5X3N0YXR1c19mYWlsZWQiLCJuX2NvaW5kZXRhaWxfaGlzdG9yeV9zdGF0dXNfY2FuY2VsZWQiLCJuX2NvaW5kZXRhaWxfaGlzdG9yeV9zdGF0dXNfbmVlZF92ZXJpZnkiLCJuX2NvaW5kZXRhaWxfaGlzdG9yeV9zdGF0dXNfdmVyaWZ5X2ZhaWx1cmUiLCJnZXRTcG90RGlzcGxheVN0YXR1c0RldGFpbCIsImRpcmVjdGlvbiIsIml0ZW1fZXh0cmEiLCJkaXNwbGF5U3RhdHVzRGV0YWlsIiwibl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX290Y190b19wcm8iLCJuX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfcHJvX3RvX290YyIsIm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9jaGlsZF90b19wcm8iLCJuX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfcHJvX3RvX2NoaWxkIiwibl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX3Byb190b19zdXBlcm1hcmdpbiIsIm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9zdXBlcm1hcmdpbl90b19wcm8iLCJuX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfcHJvX3RvX21hcmdpbiIsIm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9tYXJnaW5fdG9fcHJvIiwibl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX3Byb190b19jb250cmFjdCIsIm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9jb250cmFjdF90b19wcm8iLCJuX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfcHJvX3RvX3N3YXAiLCJuX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfc3dhcF90b19wcm8iLCJuX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfcHJvX3RvX2xpbmVhcl9zd2FwX3VzZHQiLCJuX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfbGluZWFyX3N3YXBfdXNkdF90b19wcm8iLCJuX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfcHJvX3RvX2Vhcm4iLCJuX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfZWFybl90b19wcm8iLCJuX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfc3lzdGVtX3RyYW5zZmVyX2luIiwibl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX3N5c3RlbV90cmFuc2Zlcl9vdXQiLCJuX2dyaWRfdHJhbnNmZXJfaW4iLCJuX2dyaWRfdHJhbnNmZXJfb3V0Iiwibl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX290Y19vcHRpb25fdG9fcHJvIiwibl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX3Byb190b19vdGNfb3B0aW9uIiwibl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX2Vhcm5fYXdhcmQiLCJuX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfYWN0aXZpdHlfcmV3YXJkIiwibl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX3JlZF9lbnZlbG9wZV9yZXdhcmQiLCJuX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfYXBpX2Jyb2tlcmFnZV90b19zcG90Iiwibl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX3Jld2FyZF9yZWNlaXZlIiwibl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX2RlZHVjdGlvbiIsIm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9jYXNoYmFja192b3VjaGVyIiwibl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX2MyY0xlbmRJbkNvaW5UaXRsZSIsIm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9yZXBheV9jb2luIiwibl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX2FjY3J1YWxfdGl0bGUiLCJuX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfbmZ0X2NvcHlyaWdodCIsIm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9uZnRfc2FsZSIsIm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9uZnRfYnV5Iiwibl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX25mdF9yZWZ1bmQiLCJuX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfcmVwYXlfaW50ZXJlc3QiLCJuX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfc3Vic2NyaWJlX3VwZGF0ZSIsIm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9pbnRlcmVzdF9yZWlzc3VlX3VwZGF0ZSIsIm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9pbnRlcmVzdF9pc3N1ZV91cGRhdGUiLCJuX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfaW50ZXJlc3RfY291cG9uX2lzc3VlX3VwZGF0ZSIsIm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9yZWRlbXB0aW9uX3VwZGF0ZSIsIm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9odF90b19odHgiLCJuX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfaHR4Iiwibl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX3JlZGVtcHRpb25fdXBkYXRlX2h0eCIsIm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9zcG90X3RvX2NvcHl0cmFkaW5nIiwibl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX2NvcHl0cmFkaW5nX3RvX3Nwb3QiLCJuX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfaHR4dHJhZGVtaW5pbmcwNl9zcG90X3RvX3N5c3RlbSIsIm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9odHh0cmFkZW1pbmluZzA1X3N5c3RlbV90b19zcG90Iiwibl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX2h0eGNvbnRyYWN0dHJhZGVtaW5pbmcwNV9zeXN0ZW1fdG9fc3BvdCIsIm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9odHhjb250cmFjdHRyYWRlbWluaW5nMDZfc3BvdF90b19zeXN0ZW0iLCJuX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfbWFrZXJtaW5pbmcwM19zeXN0ZW1fdG9fc3BvdCIsIm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9tYWtlcm1pbmluZzA0X3Nwb3RfdG9fc3lzdGVtIiwibl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX2h5Z2R3azAzX3N5c3RlbV90b19zcG90Iiwibl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX2h5Z2R3azA0X3Nwb3RfdG9fc3lzdGVtIiwibl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX3RyYWRlX3RvX21hdGNoIiwibl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX3RyYWRlX3RvX21hdGNoX3BhcmVudCIsIm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9zcG90X3RvX3N1YnRyYWRlIiwibl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX3N1YnRyYWRlX3RvX3Nwb3QiLCJuX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfaW5jb21lX3Nwb3RfdG9fc3lzdGVtIiwibl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX3Jlc3Rha2luZ19zeXN0ZW1fdG9fc3BvdCIsIm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9jb3Vwb25fc3lzdGVtX3RvX3Nwb3QiLCJuX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfcHJlcGF5bWVudF9zeXN0ZW1fdG9fc3BvdCIsIm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9wcmVwYXltZW50X3N5c3RlbV90b19tYXJnaW5fdHJhZGUiLCJuX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfcHJlcGF5bWVudF9zeXN0ZW1fdG9fc3VwZXJtYXJnaW5fdHJhZGUiLCJuX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfcHJlcGF5bWVudF9zeXN0ZW1fdG9fY3J5cHRvbG9hbl90cmFkZSIsIm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9wcmVwYXltZW50X3JlcGF5MF9zcG90X3RvX3N5c3RlbSIsIm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9wcmVwYXltZW50X3JlcGF5MV9zcG90X3RvX3N5c3RlbSIsIm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9wcmVwYXltZW50X3JlcGF5Ml9zcG90X3RvX3N5c3RlbSIsIm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9wcmVwYXltZW50X3JlcGF5M19zcG90X3RvX3N5c3RlbSIsIm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9wcmVwYXltZW50X3JlcGF5NF9zcG90X3RvX3N5c3RlbSIsIm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9wcmVwYXltZW50X3JlcGF5NV9zcG90X3RvX3N5c3RlbSIsIm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9wcmVwYXltZW50X3JlcGF5Nl9zcG90X3RvX3N5c3RlbSIsIm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9sYXVuY2hwb29sMDFfc3lzdGVtX3RvX3Nwb3QiLCJuX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfbGF1bmNocG9vbDAyX3Nwb3RfdG9fc3lzdGVtIiwibl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX3JlYmF0ZV9jYXNoYmFjayIsIm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9yZWJhdGVfYnJva2VyYWdlIiwiZGlzcGxheXNTdGF0dXNEZXRhaWwiLCJuX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfY2hhbXBpb25zaGlwMDFfc3lzdGVtX3RvX3Nwb3QiLCJuX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfdHJhZGVldmVudDAxX3N5c3RlbV90b19zcG90Iiwibl9jb2luZGV0YWlsX2hpc3RvcnlfcmVjb3JkX2dsb2JhbF9jb21tdW5pdHlhaXJkcm9wMDNfc3lzdGVtX3RvX3Nwb3QiLCJuX2NvaW5kZXRhaWxfaGlzdG9yeV9yZWNvcmRfZ2xvYmFsX2NvbW11bml0eWFpcmRyb3AwNF9zcG90X3RvX3N5c3RlbSIsIm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9yZWRlbnZlbG9wZV9zcG90X3RvX3N5c3RlbSIsIm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9yZWRlbnZlbG9wZV9zeXN0ZW1fdG9fc3BvdCIsIm5fY29pbmRldGFpbF9oaXN0b3J5X3JlY29yZF9yZWRlbnZlbG9wZV9yZWZ1bmRfc3lzdGVtX3RvX3Nwb3QiLCJyZXF1ZXN0Q3VycmVuY3kiLCJlYXJuSXRlbVVybCIsImVhcm5KdW1wVXJsIiwidG9kYXlQcm9maXRSYXRlIiwidHlwZXMiLCJyZXFTdGFydERhdGUiLCJyZXFFbmREYXRlIiwibGFzdFRhYkluZGV4Iiwib3JpZ2luR3JpZERhdGEiLCJuX2Fzc2V0X2NvaW5kZXRhaWxfYXZhaWxhYmxlIiwidmFsdWVSYXRlIiwicmF0ZVNob3ciLCJsaW5lU2hvdyIsImhlaWdodCIsInBvcFR5cGUiLCJuX2Fzc2V0X2NvaW5kZXRhaWxfbG9ja2VkIiwibl9hc3NldF9jb2luZGV0YWlsX2xhc3RfcHJpY2UiLCJuX2Fzc2V0X2NvaW5kZXRhaWxfY29zdF9wcmljZSIsIm5fdG9kYXlfcHJvZml0Iiwibl9hc3NldF9jb2luZGV0YWlsX3RvdGFsX3BubCIsImhpc3RvcnlUeXBlcyIsImJnQ29sb3IiLCJmaW5hbmNlQ2xhc3MuRmluYW5jZUdyb3VwVHlwZSIsInNsaWRlcklkIiwiZnJvbUlkIiwibmVlZE1vcmUiLCJ0YWJsZUhlaWdodCIsImNvaW5Mb2dvIiwiZGlzcGxheU5hbWUiLCJjdXJyZW5jeUNvZGUiLCJncmlkRGF0YSIsImNvaW5Db250ZW50cyIsImVhcm5UZXh0IiwiaGlzdG9yeUxpc3QiLCJoaXN0b3J5VGl0bGVLTGluZVByaWNlIiwiaGlzdG9yeVRpdGxlUHJpY2UiLCJwb3BUaXRsZSIsInBvcFN0eWxlMSIsInBvcFN0eWxlMiIsInJlY29yZFRhYkluZGV4IiwibGF1bmNoUG9vbFZpc2liIiwic3RhYmxlIiwic3RhcnREYXRlIiwic2V0SG91cnMiLCJzZXREYXRlIiwiZW5kRGF0ZSIsImluaXRDdXJyZW5jeVN5bWJvbCIsInJlcXVlc3RDb250ZW50SW5mb1YyIiwicmVxdWVzdEZpbmFuY2VIaXN0b3J5IiwiY29tbW9uLmdldExlZ2FsQ3VycmVuY3lTeW1ib2wiLCJuX2Fzc2V0X2NvaW5kZXRhaWxfa2xpbmVfcHJpY2UiLCJuX2Fzc2V0X2NvaW5kZXRhaWxfcHJpY2UiLCJ2YWxpZFN0cmluZyIsInN0cmluZyIsImRlZmF1bHRTdHJpbmciLCJoYW5kbGVUb3RhbEJhbGFuY2VSaWNoIiwibWFya2V0IiwiZ2V0UmVhbFByaWNlIiwidXNkdFByaWNlIiwicHJpY2VTY2FsZSIsImNvbW1vbi5jb252ZXJ0TGVnYWxUZW5kZXIiLCJjb21tb24uYWRkQ3VycmVuY3lTeW1ib2wiLCJyZXNEYXRhIiwibWFya2V0UHJpY2VTY2FsZSIsImN1cnJlbmN5QW1vdW50U2hvd1NjYWxlIiwibWFya2V0VmFsdWUiLCJ0b3RhbEJhbGFuY2UiLCJjb21tb24uZm9ybWF0QnlNaW5QcmVjaXNpb24iLCJ0bXBHcmlkRGF0YSIsImF2YWlsYWJsZU51bSIsInN1c3BlbnNlTnVtIiwibG9ja051bSIsIm1hcmtldFByaWNlIiwiYXZnUG9zaXRpb25Db3N0IiwiemVyb1N0YXRlIiwidG9kYXlQcm9maXQiLCJyYXRlQ29sb3IiLCJjb21tb24uZ2V0UHJpY2VDb2xvciIsInByb2ZpdCIsInByb2ZpdFJhdGUiLCJhdmdDb3N0U3RhdGUiLCJlbXB0eUdyaWQiLCJuZXdHcmlkRGF0YSIsImxhYmVsIiwibl9hc3NldF9jb2luZGV0YWlsX2NvaW4iLCJ0b2RheUluY3JlYXNlIiwibGFiZWxUZXh0IiwibGFiZWxUZXh0Q29sb3IiLCJyZWNvbUJhc2VJbmZvIiwicmVjb21fYmFzZV9pbmZvIiwidHJhZGluZ0JvdENvbnRlbnRzIiwibl90cmFkZV9ib3QiLCJwcm9qZWN0UmF0ZSIsImFweVRyYW5zbGF0ZSIsInRyYWRlQ2FyZFNob3ciLCJmaW5hbmNlQ29udGVudHMiLCJmaW5hbmNlIiwiZmluYW5jZV9hcHkiLCJmaW5hbmNlX2FweV90ZXh0Iiwibl9hc3NldF9jb2luZGV0YWlsX2Vhcm5fY29udGVudCIsImN1cnJlbmN5RGlzcGxheU5hbWUiLCJzcGFuU3RhcnQiLCJzcGFuRW5kIiwicmljaEhpZ2hsaWdodCIsImpvaW5UZXh0IiwiZWFybkNhcmRTaG93IiwiaXNMb2FkTW9yZSIsInNsaWRlckNlbGxEYXRhIiwiZGlyZWN0IiwiaGlzdG9yeUxvYWRNb3JlU3RhdHVzIiwibGFzdERhdGEiLCJuZXdIaXN0b3J5cyIsImNlbGxIZWlnaHQiLCJmaW5hbmNlQ2xhc3MuZ2V0U3BvdEZpbmFuY2VUeXBlV2l0aEdyb3VwIiwiZGlzcGxheVN0YXRlIiwiZmluYW5jZUNsYXNzLmdldFNwb3RGaW5hbmNlU3RhdGUiLCJkaXNwbGF5RmVlIiwiZmVlcyIsImRpc3BsYXlEZXRhaWwiLCJmaW5hbmNlQ2xhc3MuZ2V0U3BvdERpc3BsYXlTdGF0dXNEZXRhaWwiLCJleHRyYSIsImRpc3BsYXlUaXRsZSIsImZpbmFuY2VDbGFzcy5nZXRTcG90RGlzcGxheVR5cGUiLCJkaXNwbGF5QW1vdW50IiwiZGlzcGxheVRpbWUiLCJjb3VudCIsInJlY29yZFR5cGVTZWxlY3RlZCIsImZpbmFuY2VDbGFzcy5nZXRSZXF1ZXN0VHlwZSIsImhpc3RvcnlMb2FkTW9yZSIsImp1bXBJbnRybyIsIm9wZW5TaGFyZSIsImp1bXAiLCJ0cmFkZUNsaWNrZWQiLCJ0cmFkZUl0ZW1DbGlja2VkIiwiZGVwb3NpdENsaWNrZWQiLCJ3aXRoZHJhd0NsaWNrZWQiLCJ0cmFuc2ZlckNsaWNrZWQiLCJlYXJuQ2xpY2tlZCIsImVhcm5JdGVtQ2xpY2tlZCIsImhpc3RvcnlDbGlja2VkIiwicG9wQ29udGVudCIsIm5fYXNzZXRfY29pbmRldGFpbF9jb3N0X3ByaWNlX3RpcHNfMSIsIm5fYXNzZXRfY29pbmRldGFpbF9jb3N0X3ByaWNlX3RpcHNfMiIsIm5fYXNzZXRfY29pbmRldGFpbF9jb3N0X3ByaWNlX3RpcHNfMyIsIm5fYXNzZXRfY29pbmRldGFpbF9jb3N0X3ByaWNlX3RpcHNfNCIsIm5fYXNzZXRfY29pbmRldGFpbF90b2RheV9wbmxfdGlwc18xIiwibl9hc3NldF9jb2luZGV0YWlsX3RvZGF5X3BubF90aXBzXzIiLCJuX2Fzc2V0X2NvaW5kZXRhaWxfdG9kYXlfcG5sX3RpcHNfMyIsIm5fYXNzZXRfY29pbmRldGFpbF90b3RhbF9wbmxfdGlwc18xIiwibl9hc3NldF9jb2luZGV0YWlsX3RvdGFsX3BubF90aXBzXzIiLCJuX2Fzc2V0X2NvaW5kZXRhaWxfaGlzdG9yeV90aXBzXzEiLCJuX2Fzc2V0X2NvaW5kZXRhaWxfaGlzdG9yeV90aXBzXzIiLCJwb3BDbG9zZSIsImhpc3RvcnlUeXBlQ2xpY2tlZCIsInNlbmRDb21tb25Db25maWciLCJjb21tb24uZ2V0Q29tbW9uQ29uZmlnIl0sIm1hcHBpbmdzIjoiQUFpQkEsSUFBSUEsS0FBSyxJQVVQQyxLQUFLLEdBR0xDLFNBQVMsS0FHVEMsWUFBWSxLQU9aQyxNQUFNLEdBUU5DLEtBQUssSUFPTEMsT0FBTyxhQUNQQyxVQUFVRCxPQUFPLFlBQ2pCRSxhQUFhRCxVQUFVLGtCQUN2QkUsYUFBYUYsVUFBVSxpQkFDdkJHLGNBQWNKLE9BQU8sb0JBR3JCSyxJQUFJLENBQUUsR0FDTkMsaUJBQWlCLEdBQ2pCQyxVQUFVOztBQU9aLFNBQVNDO0lBUVAsU0FBU0MsSUFBSUM7UUFDWCxJQUFJQyxJQUFJQztRQUdSLE1BQU1ELGFBQWFGLE1BQU0sT0FBT0MsTUFBTUosWUFBWUUsVUFBVSxJQUFJQyxJQUFJQztRQUdwRSxJQUFJQSxhQUFhRCxLQUFLO1lBQ3BCRSxFQUFFRSxJQUFJSCxFQUFFRztZQUNSRixFQUFFRyxJQUFJSixFQUFFSTtZQUNSSCxFQUFFSSxJQUFJTCxFQUFFSyxFQUFFQztBQUNoQixlQUFXO1lBQ0xDLE1BQU1OLEdBQUdEO0FBQ1Y7UUFNREMsRUFBRU8sY0FBY1Q7QUFDakI7SUFFREEsSUFBSVUsWUFBWWQ7SUFDaEJJLElBQUlmLEtBQUtBO0lBQ1RlLElBQUlkLEtBQUtBO0lBQ1RjLElBQUlYLEtBQUtBO0lBQ1RXLElBQUlWLEtBQUtBO0lBQ1RVLElBQUlXLFVBQVU7SUFFZCxPQUFPWDtBQUNUOztBQVNBLFNBQVNRLE1BQU1OLEdBQUdEO0lBQ2hCLElBQUlJLEdBQUdPLEdBQUdDO0lBR1YsSUFBSVosTUFBTSxLQUFLLElBQUlBLElBQUksR0FBR0EsSUFBSSxXQUN6QixLQUFLSCxRQUFRZ0IsS0FBS2IsS0FBSyxLQUFLLE1BQU1jLE1BQU12QixVQUFVO0lBR3ZEVSxFQUFFRSxJQUFJ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
