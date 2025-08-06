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

function subtract(x, y) {
    return new Big(x).minus(y).toString();
}

function multiply(x, y) {
    return new Big(x).times(y).toString();
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

function bignumber(arr) {
    if (Array.isArray(arr)) {
        return arr.map((value => Big(value).toFixed()));
    } else {
        return Big(arr).toFixed();
    }
}

Big.DP = 30;

Big.RM = 2;

var clickable = true;

function moduleDefine(moduleName, defaultDataFunction, functions = {
    onCreate: onCreate$2,
    onDestroy: onDestroy$1,
    onResume: onResume$1,
    onPause: onPause,
    onStart: onStart,
    onStop: onStop
}) {
    console.log(`loadModule`, moduleName);
    $data[moduleName] = defaultDataFunction();
    $event[moduleName] = {
        onCreate: typeof functions.onCreate == "undefined" ? onCreate$2 : functions.onCreate,
        onDestroy: typeof functions.onDestroy == "undefined" ? onDestroy$1 : functions.onDestroy,
        onResume: typeof functions.onResume == "undefined" ? onResume$1 : functions.onResume,
        onPause: typeof functions.onPause == "undefined" ? onPause : functions.onPause,
        onStart: typeof functions.onStart == "undefined" ? onStart : functions.onStart,
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

function onCreate$2() {
    console.log("common onCreate");
}

function onDestroy$1() {}

function onResume$1() {}

function onPause() {}

function onStart() {}

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
    const bigValue = new Big(priceStr);
    const priceString = precision == -1 ? bigValue.toString() : bigValue.toFixed(precision);
    const finalPriceStr = priceString.replace(/\d+/, (function(n) {
        return n.replace(/(\d)(?=(\d{3})+$)/g, (function($1) {
            return $1 + ",";
        }));
    }));
    return finalPriceStr;
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

function removeExtraZeros(num) {
    return num.replace(/(?:\.0*|(\.\d+?)0+)$/, "$1");
}

function adapterPercentFlag(str) {
    if (str == null || str == undefined) {
        return "";
    }
    let result = str;
    if (commonData.OS == 0) {
        result = str.replace(/%%/g, "%");
    }
    return result;
}

const tag$6 = "simple_earn_coupon_list";

const couponListRes = {
    usableBgColor: "@color/KBaseColorInputBackground",
    usableTitleColor: "@color/kColorPrimaryText",
    usableValColor: "@color/kColorThreeLevelText",
    disableBgColor: "@color/kColorTipsBackground",
    disableTitleColor: "@color/baseColorThreeLevelText",
    disableValColor: "@color/baseColorThreeLevelText",
    disableImg: "@drawable/edge_engin_simple_earn_coupon_disable",
    selectedImg: "@drawable/edge_engin_simple_earn_coupon_selected",
    unselectedImg: "@drawable/edge_engin_simple_earn_coupon_unselected"
};

class ConponListItem {
    title="";
    couponUpLimit=0;
    couponDownLimit=0;
    couponCurrency="";
    apy="";
    couponTerm=0;
    beginTime="";
    endTime="";
    couponSign="";
    id="";
    dueTag=0;
    index=-1;
    apyText="";
    endTimeText="";
    imgSelector="";
    appendText="";
    showHigtest="gone";
    dueVis="gone";
    type="1";
    setDueTag(dueTag) {
        this.dueTag = dueTag;
        if (dueTag == 1) {
            this.dueVis = "visible";
        } else {
            this.dueVis = "gone";
        }
    }
    setApy(apy) {
        this.apy = apy;
        this.apyText = formatPrecision(multiply(apy, 100), 2);
    }
    setEndTime(endTime) {
        this.endTime = endTime;
        this.endTimeText = $i18n.$intercept.n_simple_earn_coupon_list_valid_to(`${new Date(endTime).Format("yyyy/MM/dd")}`);
    }
    setAppendText() {
        this.appendText = $i18n.$intercept.n_simple_earn_coupon_list_bottom(`${this.couponDownLimit}`, `${this.couponCurrency}`, `${this.couponUpLimit}`, `${this.couponCurrency}`, `${this.couponTerm}`);
    }
    copy(item) {
        this.title = item.title;
        this.couponUpLimit = item.couponUpLimit;
        this.couponDownLimit = item.couponDownLimit;
        this.couponCurrency = item.couponCurrency;
        this.setApy(item.apy);
        this.couponTerm = item.couponTerm;
        this.couponCurrency = item.couponCurrency;
        this.index = item.index;
        this.beginTime = item.beginTime;
        this.setEndTime(item.endTime);
        this.imgSelector = item.imgSelector;
        this.setAppendText();
        this.showHigtest = item.showHigtest;
        this.id = item.id;
        this.couponSign = item.couponSign;
        this.dueTag = item.dueTag;
        this.dueVis = item.dueVis;
        this.type = item.type;
    }
}

$data.couponList = {
    isShow: false,
    disabledReasonVis: "gone",
    disabledReason: "",
    items: [],
    itemBgColor: couponListRes.usableBgColor,
    itemTitleColor: couponListRes.usableTitleColor,
    itemValColor: couponListRes.usableValColor,
    dueTitle: $i18n.n_simple_earn_due
};

function getDefaultData$1() {
    return {
        items: [],
        couponIndex: -1,
        enableDialog: false,
        isSelectedCouponList: false,
        showType: 0
    };
}

var curIndex$1 = -1;

$event.couponList = {
    itemClick: function(index) {
        console.log(`couponList itemClick index = ${index} curIndex= ${curIndex$1}`);
        let element = $data.home.sliderData[curIndex$1];
        let couponListData = element.couponListData;
        if (!couponListData.enableDialog) {
            return;
        }
        couponListData.isSelectedCouponList = true;
        couponListData.couponIndex = index;
        showCouponListSelect(index, couponListData, true);
    },
    setDisabledReasonText: function(apy) {
        let apyText = formatPrecision(multiply(apy, 100), 2);
        $data.couponList.disabledReason = adapterPercentFlag($i18n.$intercept.n_simple_earn_disabled_reason(`${apyText}`));
    },
    confirm: function() {
        let element = $data.home.sliderData[curIndex$1];
        let couponListData = element.couponListData;
        if (!couponListData.enableDialog) {
            $data.couponList.isShow = false;
            return;
        }
        if (couponListData.couponIndex == -1) {
            showCouponOneLine(element, true, $i18n.n_simple_earn_not_use_coupon);
        } else {
            showCouponLine(element);
        }
        curIndex$1 = -1;
        $data.couponList.isShow = false;
    },
    openDialog: function(index) {
        console.log(`${tag$6} openDialog index= ${index} length= ${$data.home.sliderData.length}`);
        let element = $data.home.sliderData[index];
        curIndex$1 = index;
        console.log(`${tag$6} openDialog element= ${JSON.stringify(element)}`);
        console.log(`${tag$6} openDialog couponListData= ${JSON.stringify(element.couponListData)}`);
        let couponListData = element.couponListData;
        let usingCoupon = element.usingCoupon;
        if (element.couponRightImgVis == "gone") {
            return;
        }
        $data.couponList.items = couponListData.items;
        if (element.couponListData.showType == 1) {
            showCouponListUsable();
            showCouponListSelect(couponListData.couponIndex, couponListData, false);
        } else if (element.couponListData.showType == 2) {
            showCouponListDisable(usingCoupon.apy);
            showCouponListSelect(-1, couponListData, false);
        }
        $data.couponList.isShow = true;
    },
    closeDialog: function() {
        curIndex$1 = -1;
        $data.couponList.isShow = false;
    }
};

function getCouponData(element, originCouponData) {
    let projectId = element.projectId;
    let usingCoupon = element.usingCoupon;
    let couponListData = getDefaultData$1();
    const data = originCouponData;
    console.log(`${tag$6} getCouponData data = ${JSON.stringify(data)}`);
    if (data != null) {
        console.log(`${tag$6} getCouponData element = ${JSON.stringify(element)}`);
        let clist = isEmptyObject(data) || data.couponsMap[projectId] == null ? [] : data.couponsMap[projectId];
        console.log(`${tag$6} getCouponData clist = ${JSON.stringify(clist)} usingCoupon = ${JSON.stringify(usingCoupon)}`);
        if (isEmptyObject(usingCoupon) && clist.length == 0) {
            console.log(`${tag$6} getCouponData usingCoupon == null && clist.length == 0`);
            couponListData.enableDialog = false;
            showCouponOneLine(element, false, $i18n.n_simple_earn_unavailable);
        } else if (!isEmptyObject(usingCoupon)) {
            console.log(`${tag$6} getCouponData usingCoupon != null ${clist.length}`);
            if (clist.length == 0) {
                couponListData.enableDialog = false;
                showCouponOneLine(element, false, $i18n.n_simple_earn_unavailable);
            } else {
                couponListData.items = handleCouponList(clist, element);
                console.log(`${tag$6} getCouponData 1 items = ${JSON.stringify($data.couponList.items)}`);
                couponListData.enableDialog = false;
                showCouponOneLine(element, true, $i18n.n_simple_earn_unavailable);
                couponListData.showType = 2;
            }
        } else {
            console.log(`${tag$6} getCouponData clist > 0`);
            couponListData.couponIndex = 0;
            let temp = handleCouponList(clist, element);
            console.log(`${tag$6} getCouponData 2 temp = ${JSON.stringify(temp)}`);
            couponListData.items = temp;
            console.log(`${tag$6} getCouponData 2 couponList = ${JSON.stringify(temp[0].title)}`);
            let item = temp[couponListData.couponIndex];
            console.log(`${tag$6} getCouponData 2 item = ${item.title}`);
            couponListData.enableDialog = true;
            showCouponTwoLine(element, item, true);
            couponListData.showType = 1;
        }
        element.couponListData = couponListData;
        console.log(`${tag$6} getCouponData over ${JSON.stringify(element)}`);
    } else {
        console.log(`${tag$6} getCouponData error`);
    }
}

function isEmptyObject(obj) {
    return JSON.stringify(obj) === "{}";
}

function handleCouponList(list, element) {
    console.log(`${tag$6} handleCouponList begin list = ${JSON.stringify(list)}`);
    couponCompare.subInt = 0;
    couponCompare.userInvestAmt = element.userInvestAmt;
    list.sort(couponCompare);
    console.log(`${tag$6} handleCouponList after sort list = ${JSON.stringify(list)}`);
    let ans = [];
    for (let i = 0; i < list.length; i++) {
        let item = list[i];
        let temp = new ConponListItem;
        temp.title = item.title;
        temp.couponUpLimit = item.couponUpLimit;
        temp.couponDownLimit = item.couponDownLimit;
        temp.couponCurrency = item.couponCurrency;
        temp.setApy(item.apy);
        temp.couponTerm = item.couponTerm;
        temp.beginTime = item.beginTime;
        temp.setEndTime(item.endTime);
        temp.id = item.id;
        temp.couponSign = item.couponSign;
        temp.setDueTag(item.dueTag);
        temp.index = i;
        if (i == 0 && list.length > 1) {
            temp.showHigtest = "visible";
        } else {
            temp.showHigtest = "gone";
        }
        temp.setAppendText();
        ans.push(temp);
    }
    console.log(`${tag$6} handleCouponList over ${JSON.stringify(ans)}`);
    return ans;
}

function showCouponListSelect(selectedIndex, couponListData, isItemClick = false) {
    console.log(`${tag$6} showCouponListSelect begin selectedIndex= ${selectedIndex}`);
    for (var i = 0; i < $data.couponList.items.length; i++) {
        var item = $data.couponList.items[i];
        if (selectedIndex == -1) {
            item.imgSelector = couponListRes.disableImg;
        } else if (selectedIndex == i) {
            if (item.imgSelector == couponListRes.selectedImg) {
                if (isItemClick) {
                    item.imgSelector = couponListRes.unselectedImg;
                    couponListData.couponIndex = -1;
                }
            } else {
                item.imgSelector = couponListRes.selectedImg;
            }
        } else {
            item.imgSelector = couponListRes.unselectedImg;
        }
    }
    console.log(`${tag$6} showCouponListSelect end couponIndex= ${couponListData.couponIndex}`);
}

function refreshCoupon(subInt, element) {
    console.log(`${tag$6} refreshCoupon begin invoke sub = ${subInt} ${element.userInvestAmt}`);
    let couponListData = element.couponListData;
    if (!couponListData.enableDialog) {
        return;
    }
    if (!couponListData.isSelectedCouponList) {
        let oriItems = couponListData.items;
        let newList = [];
        for (let i = 0; i < oriItems.length; i++) {
            console.log(`${tag$6} refreshCoupon item = ${JSON.stringify(oriItems[i])}`);
            let temp = new ConponListItem;
            temp.copy(oriItems[i]);
            newList.push(temp);
        }
        console.log(`${tag$6} refreshCoupon befor sort newList = ${JSON.stringify(newList)}`);
        couponCompare.subInt = subInt;
        couponCompare.userInvestAmt = element.userInvestAmt;
        newList.sort(couponCompare);
        for (let i = 0; i < newList.length; i++) {
            let temp = newList[i];
            temp.index = i;
            if (i == 0) {
                if (oriItems.length > 1) {
                    temp.showHigtest = "visible";
                }
                couponListData.couponIndex = i;
                temp.imgSelector = couponListRes.selectedImg;
            } else {
                temp.showHigtest = "gone";
                temp.imgSelector = couponListRes.unselectedImg;
            }
        }
        console.log(`${tag$6} refreshCoupon after sort newList = ${JSON.stringify(newList)}`);
        couponListData.items = newList;
    }
    showCouponLine(element);
    console.log(`${tag$6} refreshCoupon end invoke`);
}

function couponCompare(c1, c2) {
    let subInt = couponCompare.subInt;
    let userInvestAmt = couponCompare.userInvestAmt;
    console.log(`${tag$6} couponCompare begin subInt= ${subInt} userInvestAmt= ${userInvestAmt}`);
    let a1 = getAmount(c1, subInt, userInvestAmt);
    let a2 = getAmount(c2, subInt, userInvestAmt);
    console.log(`a1 = ${a1} a2 = ${a2}`);
    if (a1 > a2) {
        return -1;
    } else if (a1 < a2) {
        return 1;
    } else {
        if (c1.beginTime > c2.beginTime) {
            return -1;
        } else if (c1.beginTime < c2.beginTime) {
            return 1;
        }
        return 0;
    }
}

function getAmount(c, subInt, userInvestAmt) {
    console.log(`${tag$6} getAmount subInt= ${subInt} userInvestAmt= ${userInvestAmt}`);
    let num = 0;
    if (subInt == 0) {
        num = c.couponUpLimit;
    } else if (subInt >= c.couponDownLimit) {
        num = Math.min(userInvestAmt + subInt, c.couponUpLimit) * 100;
    } else {
        num = Math.min(userInvestAmt + subInt, c.couponUpLimit);
    }
    return parseFloat(num) * c.apy * c.couponTerm;
}

function showCouponLine(element) {
    let mSubInput = element.mSubInput;
    let couponList = element.couponListData;
    console.log(`${tag$6} showCouponLine ${mSubInput} ${JSON.stringify(couponList)}`);
    let subNum = mSubInput.length == 0 ? 0 : parseFloat(mSubInput);
    console.log(`showCouponLine subNum= ${subNum} couponIndex= ${couponList.couponIndex}`);
    if (couponList.couponIndex == -1) {
        return;
    }
    let item = couponList.items[couponList.couponIndex];
    if (subNum < item.couponDownLimit) {
        showCouponTwoLine(element, item, true);
    } else {
        let num = Math.min(subNum, item.couponUpLimit);
        showCouponTwoLine(element, item, false, num);
    }
}

function showCouponTwoLine(element, coupon, showDown = true, min = 0) {
    console.log(`${tag$6} showCouponTwoLine showDown= ${showDown} min= ${min} ${JSON.stringify(element)}`);
    element.couponRightImgVis = "visible";
    element.couponTextMidVis = "gone";
    element.couponMidVis = "visible";
    if (showDown) {
        element.couponTextUp = adapterPercentFlag($i18n.$intercept.n_simple_earn_coupon_up_two_line(`${formatPrecision(multiply(coupon.apy, 100), 2)}`));
        element.couponTextDown = $i18n.$intercept.n_simple_earn_coupon_down_twon_line(`${coupon.couponDownLimit}`, `${$data.home.currency}`);
        element.couponTextDownVis = "visible";
    } else {
        element.couponTextUp = adapterPercentFlag($i18n.$intercept.n_simple_earn_coupon_up_one_line(`${min}`, `${$data.home.currency}`, `${formatPrecision(multiply(coupon.apy, 100), 2)}`));
        element.couponTextDownVis = "gone";
    }
}

function showCouponOneLine(element, showRight, text) {
    console.log(`${tag$6} showCouponOneLine ${showRight} ${text} ${JSON.stringify(element)}`);
    element.couponRightImgVis = showRight ? "visible" : "gone";
    element.couponMidVis = "gone";
    element.couponTextMid = `${text}`;
    element.couponTextMidVis = "visible";
    console.log(`${tag$6} showCouponOneLine over ${showRight} ${text} ${JSON.stringify(element.couponTextMid)}`);
}

function showCouponListUsable() {
    $data.couponList.itemBgColor = couponListRes.usableBgColor;
    $data.couponList.itemTitleColor = couponListRes.usableTitleColor;
    $data.couponList.itemValColor = couponListRes.usableValColor;
    $data.couponList.disabledReasonVis = "gone";
}

function showCouponListDisable(apy) {
    $data.couponList.itemBgColor = couponListRes.disableBgColor;
    $data.couponList.itemTitleColor = couponListRes.disableTitleColor;
    $data.couponList.itemValColor = couponListRes.disableValColor;
    $event.couponList.setDisabledReasonText(apy);
    $data.couponList.disabledReasonVis = "visible";
}

const tag$5 = "simple_earn_analytics";

const keyToken = "token";

const keyProjectType = "projectType";

const keyTerm = "term";

const keyProjectId = "projectId";

const keyApyType = "apyType";

const keyDisplayLaunchPoolLabelOrNot = "displayLaunchPoolLabelOrNot";

const keyPageLoadTime = "pageLoadTime";

const keyNation = "nation";

const keyFirstLoad = "firstLoadingOrNot";

const ptNewUser = "newUser";

const ptFlexible = "flexible";

const ptFixed = "fixed";

const atApy = "apy";

const atMarketApy = "marketApy";

function pageShow(element, loadTime, isFirstTime) {
    console.log(`${tag$5} pageShow projectId= ${element.projectId} term= ${element.term} productType= ${element.productType}`);
    let params = {
        [keyToken]: $data.home.currency,
        [keyTerm]: element.term,
        [keyProjectId]: element.projectId,
        [keyDisplayLaunchPoolLabelOrNot]: element.tag == 9 ? 1 : 0,
        [keyPageLoadTime]: loadTime,
        [keyNation]: commonData.countryId,
        [keyFirstLoad]: isFirstTime
    };
    if (element.productType == 0) {
        params[keyProjectType] = ptFlexible;
        if (element.apyType == 0) {
            params[keyApyType] = atApy;
        } else if (element.apyType == 1) {
            params[keyApyType] = atMarketApy;
        }
    } else if (element.productType == 1) {
        if (element.fixedType == 0 || element.fixedType == 2) {
            params[keyProjectType] = ptFixed;
        } else if (element.fixedType == 1) {
            params[keyProjectType] = ptNewUser;
        }
    }
    console.log(`${tag$5} pageShow params= ${JSON.stringify(params)}`);
    analytics("app_earn_subscribePage_show", params);
}

function backClick() {
    analytics("app_earn_subscribePage_return_click", {
        token: $data.home.currency
    });
}

function assetSourceDialogShow() {
    analytics("APP_flexible_subscribePage_ConfirmFundSource_show");
}

function assetSourceConfirmBtnClick() {
    analytics("APP_flexible_subscribePage_ConfirmFundSource_ConfirmButton_click");
}

function assetSourceUSDDItemClick(onOrOff) {
    analytics("APP_flexible_subscribePage_ConfirmFundSource_USDD_click", {
        type: onOrOff
    });
}

function assetSourceUSDTItemClick(onOrOff) {
    analytics("APP_flexible_subscribePage_ConfirmFundSource_USDT_click", {
        type: onOrOff
    });
}

function earnPurchaseLoadStatus(successOrFault) {
    analytics("app_earn_subscribePage_loadState", {
        pageLoadState: successOrFault
    });
}

function maxClick(element) {
    console.log(`${tag$5} maxClick projectId= ${element.projectId} term= ${element.term} productType= ${element.productType} `);
    let params = {
        [keyToken]: $data.home.currency,
        [keyTerm]: element.term,
        [keyProjectId]: element.projectId
    };
    if (element.productType == 0) {
        params[keyProjectType] = ptFlexible;
    } else if (element.productType == 1) {
        if (element.fixedType == 0 || element.fixedType == 2) {
            params[keyProjectType] = ptFixed;
        } else if (element.fixedType == 1) {
            params[keyProjectType] = ptNewUser;
        }
    }
    analytics("app_earn_subscribePage_max_click", params);
}

function buyClick(element) {
    console.log(`${tag$5} buyClick projectId= ${element.projectId} term= ${element.term} productType= ${element.productType} `);
    let params = {
        [keyToken]: $data.home.currency,
        [keyTerm]: element.term,
        [keyProjectId]: element.projectId
    };
    if (element.productType == 0) {
        params[keyProjectType] = ptFlexible;
    } else if (element.productType == 1) {
        if (element.fixedType == "0" || element.fixedType == "2") {
            params[keyProjectType] = ptFixed;
        } else if (element.fixedType == "1") {
            params[keyProjectType] = ptNewUser;
        }
    }
    analytics("app_earn_subscribePage_buy_click", params);
}

function transferClick(element) {
    console.log(`${tag$5} transferClick projectId= ${element.projectId} term= ${element.term} productType= ${element.productType} `);
    let params = {
        [keyToken]: $data.home.currency,
        [keyTerm]: element.term,
        [keyProjectId]: element.projectId
    };
    if (element.productType == 0) {
        params[keyProjectType] = ptFlexible;
    } else if (element.productType == 1) {
        if (element.fixedType == 0 || element.fixedType == 2) {
            params[keyProjectType] = ptFixed;
        } else if (element.fixedType == 1) {
            params[keyProjectType] = ptNewUser;
        }
    }
    analytics("app_earn_subscribePage_transfer_click", params);
}

function restExplainClick(element) {
    console.log(`${tag$5} restExplainClick projectId= ${element.projectId} term= ${element.term} productType= ${element.productType}`);
    let params = {
        [keyToken]: $data.home.currency,
        [keyTerm]: element.term,
        [keyProjectId]: element.projectId
    };
    if (element.productType == 0) {
        params[keyProjectType] = ptFlexible;
    } else if (element.productType == 1) {
        if (element.fixedType == 0 || element.fixedType == 2) {
            params[keyProjectType] = ptFixed;
        } else if (element.fixedType == 1) {
            params[keyProjectType] = ptNewUser;
        }
    }
    analytics("app_earn_subscribePage_restExplain_click", params);
}

function couponExplainClick(element) {
    console.log(`${tag$5} couponExplainClick projectId= ${element.projectId} term= ${element.term} productType= ${element.productType} `);
    let params = {
        [keyToken]: $data.home.currency,
        [keyTerm]: element.term,
        [keyProjectId]: element.projectId
    };
    if (element.productType == 0) {
        params[keyProjectType] = ptFlexible;
    } else if (element.productType == 1) {
        if (element.fixedType == 0 || element.fixedType == 2) {
            params[keyProjectType] = ptFixed;
        } else if (element.fixedType == 1) {
            params[keyProjectType] = ptNewUser;
        }
    }
    analytics("app_earn_subscribePage_couponExplain_click", params);
}

function arrivalDateClick(element) {
    console.log(`${tag$5} arrivalDateClick projectId= ${element.projectId} term= ${element.term} productType= ${element.productType} `);
    let params = {
        [keyToken]: $data.home.currency,
        [keyTerm]: element.term,
        [keyProjectId]: element.projectId
    };
    if (element.productType == 0) {
        params[keyProjectType] = ptFlexible;
        if (element.apyType == 0) {
            params[keyApyType] = atApy;
        } else if (element.apyType == 1) {
            params[keyApyType] = atMarketApy;
        }
    } else if (element.productType == 1) {
        if (element.fixedType == 0 || element.fixedType == 2) {
            params[keyProjectType] = ptFixed;
        } else if (element.fixedType == 1) {
            params[keyProjectType] = ptNewUser;
        }
    }
    console.log(`${tag$5} arrivalDateClick params= ${JSON.stringify(params)}`);
    analytics("app_earn_subscribePage_arrivalDate_click", params);
}

function subscribeButtonClick(element) {
    console.log(`${tag$5} subscribeButtonClick projectId= ${element.projectId} term= ${element.term} productType= ${element.productType} `);
    let params = {
        [keyToken]: $data.home.currency,
        [keyTerm]: element.term,
        [keyProjectId]: element.projectId
    };
    if (element.productType == 0) {
        params[keyProjectType] = ptFlexible;
        if (element.apyType == 0) {
            params[keyApyType] = atApy;
        } else if (element.apyType == 1) {
            params[keyApyType] = atMarketApy;
        }
    } else if (element.productType == 1) {
        if (element.fixedType == 0 || element.fixedType == 2) {
            params[keyProjectType] = ptFixed;
        } else if (element.fixedType == 1) {
            params[keyProjectType] = ptNewUser;
        }
    }
    console.log(`${tag$5} subscribeButtonClick params= ${JSON.stringify(params)}`);
    analytics("app_earn_subscribePage_subscribeButton_click", params);
}

function autoEarnExplainClick() {
    analytics("app_earn_flexibleSubscribePage_autoEarnExplain_click", {
        [keyToken]: $data.home.currency
    });
}

const keyAction = "action";

const actionOpen = "open";

const actionclose = "close";

function autoEarnSwitchClick(autoEarn) {
    console.log(`${tag$5} autoEarnSwitchClick autoEarn= ${autoEarn}`);
    let action = autoEarn == 1 ? actionOpen : actionclose;
    analytics("app_earn_flexibleSubscribePage_autoEarnSwitch_click", {
        [keyToken]: $data.home.currency,
        [keyAction]: action
    });
}

function confirmInfoShow(element) {
    console.log(`${tag$5} confirmInfoShow projectId= ${element.projectId} term= ${element.term} productType= ${element.productType}`);
    let params = {
        [keyToken]: $data.home.currency,
        [keyTerm]: element.term,
        [keyProjectId]: element.projectId
    };
    if (element.productType == 0) {
        params[keyProjectType] = ptFlexible;
        if (element.apyType == 0) {
            params[keyApyType] = atApy;
        } else if (element.apyType == 1) {
            params[keyApyType] = atMarketApy;
        }
    } else if (element.productType == 1) {
        if (element.fixedType == 0 || element.fixedType == 2) {
            params[keyProjectType] = ptFixed;
        } else if (element.fixedType == 1) {
            params[keyProjectType] = ptNewUser;
        }
    }
    console.log(`${tag$5} confirmInfoShow params= ${JSON.stringify(params)}`);
    analytics("app_earn_subscribePage_confirmSubscriptionInfo_show", params);
}

function confirmButtonClick(element) {
    console.log(`${tag$5} confirmButtonClick projectId= ${element.projectId} term= ${element.term} productType= ${element.productType}`);
    let params = {
        [keyToken]: $data.home.currency,
        [keyTerm]: element.term,
        [keyProjectId]: element.projectId
    };
    if (element.productType == 0) {
        params[keyProjectType] = ptFlexible;
        if (element.apyType == 0) {
            params[keyApyType] = atApy;
        } else if (element.apyType == 1) {
            params[keyApyType] = atMarketApy;
        }
    } else if (element.productType == 1) {
        if (element.fixedType == 0 || element.fixedType == 2) {
            params[keyProjectType] = ptFixed;
        } else if (element.fixedType == 1) {
            params[keyProjectType] = ptNewUser;
        }
    }
    console.log(`${tag$5} confirmButtonClick params= ${JSON.stringify(params)}`);
    analytics("app_earn_subscribePage_confirmSubscriptionInfo_confirmButton_click", params);
}

function subscribeSuccessShow() {
    let element = $event.home.getCurrentElement($data.home.currentIndex);
    console.log(`${tag$5} subscribeSuccessShow projectId= ${element.projectId} term= ${element.term} productType= ${element.productType} `);
    let params = {
        [keyToken]: $data.home.currency,
        [keyTerm]: element.term,
        [keyProjectId]: element.projectId
    };
    if (element.productType == 0) {
        params[keyProjectType] = ptFlexible;
    } else if (element.productType == 1) {
        if (element.fixedType == 0 || element.fixedType == 2) {
            params[keyProjectType] = ptFixed;
        } else if (element.fixedType == 1) {
            params[keyProjectType] = ptNewUser;
        }
    }
    analytics("app_earn_subscribeSuccess_view", params);
}

function subscribeSuccessCloseCloseClick() {
    let element = $event.home.getCurrentElement($data.home.currentIndex);
    console.log(`${tag$5} subscribeSuccessCloseCloseClick projectId= ${element.projectId} term= ${element.term} productType= ${element.productType} `);
    let params = {
        [keyToken]: $data.home.currency,
        [keyTerm]: element.term,
        [keyProjectId]: element.projectId
    };
    if (element.productType == 0) {
        params[keyProjectType] = ptFlexible;
    } else if (element.productType == 1) {
        if (element.fixedType == 0 || element.fixedType == 2) {
            params[keyProjectType] = ptFixed;
        } else if (element.fixedType == 1) {
            params[keyProjectType] = ptNewUser;
        }
    }
    analytics("app_earn_subscribeSuccess_close_click", params);
}

function subscribeSuccessViewAssetsClick() {
    let element = $event.home.getCurrentElement($data.home.currentIndex);
    console.log(`${tag$5} subscribeSuccessViewAssetsClick projectId= ${element.projectId} term= ${element.term} productType= ${element.productType} `);
    let params = {
        [keyToken]: $data.home.currency,
        [keyTerm]: element.term,
        [keyProjectId]: element.projectId
    };
    if (element.productType == 0) {
        params[keyProjectType] = ptFlexible;
    } else if (element.productType == 1) {
        if (element.fixedType == 0 || element.fixedType == 2) {
            params[keyProjectType] = ptFixed;
        } else if (element.fixedType == 1) {
            params[keyProjectType] = ptNewUser;
        }
    }
    analytics("app_earn_subscribeSuccess_viewAssets_click", params);
}

function subscribeSuccessContinueClick() {
    let element = $event.home.getCurrentElement($data.home.currentIndex);
    console.log(`${tag$5} subscribeSuccessContinueClick projectId= ${element.projectId} term= ${element.term} productType= ${element.productType} `);
    let params = {
        [keyToken]: $data.home.currency,
        [keyTerm]: element.term,
        [keyProjectId]: element.projectId
    };
    if (element.productType == 0) {
        params[keyProjectType] = ptFlexible;
    } else if (element.productType == 1) {
        if (element.fixedType == 0 || element.fixedType == 2) {
            params[keyProjectType] = ptFixed;
        } else if (element.fixedType == 1) {
            params[keyProjectType] = ptNewUser;
        }
    }
    analytics("app_earn_subscribeSuccess_continue_click", params);
}

function launchpoolRewardsClick() {
    let element = $event.home.getCurrentElement($data.home.currentIndex);
    console.log(`${tag$5} launchpoolRewardsClick projectId= ${element.projectId} term= ${element.term} productType= ${element.productType}`);
    let params = {
        [keyToken]: $data.home.currency,
        [keyTerm]: element.term,
        [keyProjectId]: element.projectId
    };
    if (element.productType == 0) {
        params[keyProjectType] = ptFlexible;
    } else if (element.productType == 1) {
        if (element.fixedType == 0 || element.fixedType == 2) {
            params[keyProjectType] = ptFixed;
        } else if (element.fixedType == 1) {
            params[keyProjectType] = ptNewUser;
        }
    }
    analytics("app_earn_subscribePage_restExplain_click", params);
}

const {moduleData: moduleData$4, moduleEvent: moduleEvent$4} = moduleDefine("fixed", (function() {}), {});

function defaultHandlerData$1() {
    return {
        subInput: "",
        subOnFocus: false,
        subHint: $i18n.$intercept.n_shark_fin_min_amount(""),
        subUnit: "",
        balance: "--",
        overview: "",
        subBorderColor: "@color/KBaseColorInputBackground",
        timeAxisData: [],
        timeAxisHeight: 68,
        availableQuotaTitle: "",
        availableQuotaText: "",
        minSub: "",
        profit: "--",
        couponVis: "gone",
        couponTextUp: "",
        couponTextDown: "",
        couponTextDownVis: "visible",
        couponRightImgVis: "visible",
        couponMidVis: "visible",
        couponTextMidVis: "gone",
        couponTextMid: "",
        couponListData: {},
        usingCoupon: {},
        supportCoupon: 0,
        userInvestAmt: 0
    };
}

function handleFlexibleDetail(flexibleItem, originCouponData) {
    var handlerData = defaultHandlerData$1();
    if (flexibleItem == null) {
        return handlerData;
    }
    for (const key in flexibleItem) {
        if (Object.prototype.hasOwnProperty.call(flexibleItem, key)) {
            handlerData[key] = flexibleItem[key];
        }
    }
    let min = flexibleItem["subscribeMinAmount"];
    handlerData.minSub = removeExtraZeros(formatPrecision(min, 8));
    handlerData.subUnit = $data.home.currency.toUpperCase();
    handlerData.balance = $data.home.balance;
    handlerData.subHint = $i18n.$intercept.n_shark_fin_min_amount(`${handlerData.minSub}`);
    if (flexibleItem.projectRemainAmtPerDay == null) {
        handlerData.availableQuotaTitle = $i18n.n_simple_earn_available_quota;
    } else {
        handlerData.availableQuotaTitle = $i18n.n_simple_earn_available_quote_today;
    }
    handlerData.availableQuota = flexibleItem.availableQuota;
    handlerData.availableQuotaText = `${removeExtraZeros(getPriceString(flexibleItem.availableQuota, 8))}`;
    if (flexibleItem.dtInterestStart && flexibleItem.dtReceipt) {
        handlerData.overview = $i18n.$intercept.n_simple_earn_so_regular_title(`${flexibleItem.dtInterestStart}`, `${flexibleItem.dtReceipt}`);
    } else {
        handlerData.overview = "";
    }
    handlerData.usingCoupon = flexibleItem.usingCoupon == null ? {} : flexibleItem.usingCoupon;
    handlerData.supportCoupon = flexibleItem.supportCoupon;
    handlerData.userInvestAmt = flexibleItem.userInvestAmt;
    handlerData.dtExpired = flexibleItem.dtExpired;
    if (handlerData.supportCoupon == 1) {
        handlerData.couponVis = "visible";
        getCouponData(handlerData, originCouponData);
    } else {
        handlerData.couponVis = "gone";
    }
    var dtReceipt = flexibleItem.dtReceipt;
    handlerData.receiptDelayDays = flexibleItem.receiptDelayDays;
    handlerData.timeAxisData = [ {
        type: "normal",
        title: $i18n.n_simple_earn_so_sub_day,
        lineTitle: "",
        date: `${flexibleItem.dtSubscribe}`
    }, {
        type: "normal",
        title: $i18n.n_simple_earn_so_start_day,
        lineTitle: "",
        date: `${flexibleItem.dtInterestStart}`
    }, {
        type: "normal",
        title: $i18n.n_simple_earn_so_due_day,
        lineTitle: "",
        date: `${flexibleItem.dtExpired}`
    }, {
        type: "normal",
        title: "",
        lineTitle: $i18n.n_simple_earn_so_receipt_day,
        date: `${dtReceipt}`
    } ];
    return handlerData;
}

function getItemData(itemIndex) {
    if (itemIndex > $data.home.sliderData.length - 1) {
        return defaultHandlerData$1();
    }
    return $data.home.sliderData[itemIndex];
}

async function requestProfitEstimate(itemData) {
    if (itemData.mSubInput == 0) {
        itemData.profit = "--";
        return;
    }
    let reqParam = {
        projectId: itemData.projectId,
        amt: itemData.mSubInput
    };
    const data = await sendRequest("v4/saving/mining/project/profit/estimate", reqParam);
    console.log(`profit/estimate : ${JSON.stringify(data)}`);
    if (data != null && data.profitFormatShow) {
        itemData.profit = `${data.profitFormatShow}`;
    } else {
        itemData.profit = "--";
    }
}

function checkSubInput$1(itemData) {
    const quantity = parseFloat(itemData.mSubInput);
    const minSub = parseFloat(itemData.minSub);
    const balance = itemData.balance == "--" ? 0 : parseFloat(itemData.balance);
    const availableQuota = parseFloat(itemData.availableQuota);
    if (quantity > balance) {
        itemData.subBorderColor = "@color/KBaseInputInvalidTipColor";
        itemData.subErrorStr = $i18n.n_simple_earn_input_over_balance;
        itemData.subErrorVis = "visible";
        return false;
    } else if (quantity < minSub) {
        itemData.subBorderColor = "@color/KBaseInputInvalidTipColor";
        itemData.subErrorStr = $i18n.$intercept.n_simple_earn_input_min_subscribe(`${minSub}`, `${itemData.subUnit}`);
        itemData.subErrorVis = "visible";
        return false;
    } else if (quantity > availableQuota) {
        itemData.subBorderColor = "@color/KBaseInputInvalidTipColor";
        itemData.subErrorStr = $i18n.n_simple_earn_input_over_quota;
        itemData.subErrorVis = "visible";
        return false;
    } else {
        itemData.subBorderColor = "@color/KBaseColorInputBackground";
        itemData.subErrorVis = "gone";
        return true;
    }
}

moduleEvent$4.subTextChange = function(inputStr, itemIndex) {
    var itemData = getItemData(itemIndex);
    console.log(`subTextChange : ${inputStr}`);
    itemData.mSubInput = inputStr;
    requestProfitEstimate(itemData);
    let subInt = inputStr.length === 0 ? 0 : bignumber(inputStr);
    refreshCoupon(subInt, itemData);
    if (!checkSubInput$1(itemData)) {
        itemData.inputStatus = false;
        $event.deposit.checkBtnStatus(itemData.status, itemData.inputStatus);
        return;
    }
    itemData.inputStatus = itemData.subErrorVis == "gone" && itemData.mSubInput != "";
    if ($event.deposit.checkBtnStatus(itemData.status, itemData.inputStatus)) ;
};

moduleEvent$4.subFocusChange = function(focus, itemIndex) {
    console.log(`subFocusChange : ${focus}`);
};

moduleEvent$4.subOnReturn = function(parameter, itemIndex) {
    console.log(`subOnReturn : ${parameter}`);
    var itemData = getItemData(itemIndex);
    itemData.subOnFocus = false;
};

moduleEvent$4.clearFocus = function(itemIndex) {
    var itemData = getItemData(itemIndex);
    itemData.subOnFocus = false;
};

moduleEvent$4.maxSub = function(itemIndex) {
    var itemData = getItemData(itemIndex);
    if (itemData.balance != "--") {
        itemData.subInput = $data.home.balanceText.replace(/,/g, "");
        itemData.mSubInput = itemData.subInput;
        if (commonData.OS == 0) {
            moduleEvent$4.subTextChange(itemData.mSubInput, itemIndex);
        }
    } else {
        itemData.subInput = "0";
        itemData.mSubInput = itemData.subInput;
    }
    maxClick(itemData);
};

moduleEvent$4.availableQuotaClicked = function(itemIndex) {
    if (itemIndex > $data.home.sliderData.length - 1) {
        return;
    }
    var itemData = getItemData(itemIndex);
    itemData.subOnFocus = false;
    $event.dialog.showAvailableQuotaDialog(itemData);
    restExplainClick(itemData);
};

moduleEvent$4.backClicked = function() {
    containerBack();
};

$data.dialog = {
    confirmTitle: $i18n.n_simple_earn_confirm_subscribe_info,
    availableQuotaTitle: "",
    confirmlist: [],
    quotaQ1: "",
    quotaA1: "",
    quotaQ2: "",
    quotaA2: "",
    quotaText1: "",
    quotaText2: "",
    quotaText3: "",
    showConfirmDialog: false,
    showAvailableQuota: false,
    confirmInnerList: [],
    confirmInnerListVis: "visible",
    purchaseValue: 0,
    assetCombineData: [],
    usdtTip: "",
    usdtTipDisplay: "gone",
    amtSource: 0,
    usddRest: 0
};

const sourceEnum = {
    usddSource: 1,
    usdtSource: 4
};

$event.dialog = {
    showConfirmDialog(list = [], innerList = null, element) {
        $data.dialog.confirmlist = list;
        if (innerList == null || innerList.length <= 1) {
            $data.dialog.confirmInnerListVis = "gone";
        } else {
            $data.dialog.confirmInnerList = innerList;
            $data.dialog.confirmInnerListVis = "visible";
        }
        let inputvalue = element.mSubInput;
        $data.dialog.purchaseValue = `${inputvalue} ${$data.home.currency}`;
        $data.dialog.showConfirmDialog = true;
        console.log(`confrim dialog showing.. input  = ${inputvalue} `);
        $data.dialog.assetCombineData = [];
        $data.dialog.usddRest = inputvalue;
        $data.dialog.amtSource = 0;
        $data.dialog.usdtTipDisplay = "gone";
        let flexibleAssets = element.fundListData;
        console.log(`confrim dialog showing.. asset List is  = ${JSON.stringify(flexibleAssets)}`);
        if (typeof flexibleAssets != "undefined" && flexibleAssets != null) {
            let allAssets = flexibleAssets.items;
            if (typeof allAssets != "undefined") {
                console.log(`confrim dialog showing.. allAssets content is  = ${JSON.stringify(allAssets)}`);
                for (let i = 0; i < allAssets.length; i++) {
                    let item = allAssets[i];
                    console.log(`confrim dialog showing.. allAssets source  = ${item.source}`);
                    if (item.checkImg != "@drawable/edge_engine_copy_trading_select") {
                        continue;
                    }
                    if (item.balance > 0) {
                        console.log(`confrim dialog showing.. amtSouce += ${item.source}`);
                        $data.dialog.amtSource += item.source;
                    }
                    if (item.source == sourceEnum.usddSource) {
                        let diff = subtract(item.balance, inputvalue);
                        $data.dialog.usddRest = diff;
                        console.log(`confrim dialog showing.. diff  = ${diff}`);
                        if (diff < 0) {
                            $data.dialog.usdtTipDisplay = "visible";
                            let newDiff = removeExtraZeros(formatPrecision(diff, 8));
                            $data.dialog.usdtTip = $i18n.$intercept.n_confirm_purchase_tip(`${-newDiff}`);
                            if (item.balance > 0) {
                                let newBalance = removeExtraZeros(formatPrecision(item.balance, 8));
                                let usddAsset = {
                                    type: "5",
                                    currency: $i18n.$intercept.n_use_certain_currency_asset(`${$data.home.currency}`),
                                    value: `${newBalance} ${$data.home.currency}`
                                };
                                $data.dialog.assetCombineData.push(usddAsset);
                            }
                            let usdtAsset = {
                                type: "5",
                                currency: $i18n.$intercept.n_use_certain_currency_asset(`USDT`),
                                value: `${-newDiff} USDT`
                            };
                            $data.dialog.assetCombineData.push(usdtAsset);
                        }
                    } else if (item.source == sourceEnum.usdtSource) {
                        if ($data.dialog.usddRest == inputvalue) {
                            $data.dialog.usdtTipDisplay = "visible";
                            $data.dialog.usdtTip = $i18n.$intercept.n_confirm_purchase_tip(`${inputvalue}`);
                            let newInputValue = removeExtraZeros(formatPrecision(inputvalue, 8));
                            let usdtAsset = {
                                type: "5",
                                currency: $i18n.$intercept.n_use_certain_currency_asset(`USDT`),
                                value: `${newInputValue} USDT`
                            };
                            $data.dialog.assetCombineData.push(usdtAsset);
                        }
                    }
                }
            }
        }
        if ($data.dialog.amtSource == 0) {
            $data.dialog.amtSource = 1;
        }
        confirmInfoShow(element);
    },
    closeConfirmDialog() {
        $data.dialog.showConfirmDialog = false;
    },
    showAvailableQuotaDialog(project) {
        if (!project) {
            return;
        }
        var textColor = "#8A8A8E";
        var highlightColor = "#000000";
        const currency = $data.home.currency;
        if (commonData.colorMode == 1) {
            textColor = "#5E5E61";
            highlightColor = "#E6E6E6";
        }
        console.log(`simple_earn_dialog userRemainQuota= ${project.userRemainQuota} availableQuota= ${project.availableQuota} ${project.projectRemainAmtPerDay} - ${project.surplusAmount}`);
        let userRemainQuota = removeExtraZeros(getPriceString(project.userRemainQuota, 8));
        let availableQuota = removeExtraZeros(getPriceString(project.availableQuota, 8));
        if (project.projectRemainAmtPerDay != null) {
            let projectRemainAmtPerDay = removeExtraZeros(getPriceString(project.projectRemainAmtPerDay, 8));
            $data.dialog.availableQuotaTitle = $i18n.n_simple_earn_available_quote_today;
            $data.dialog.quotaQ1 = $i18n.n_simple_earn_what_is_available_quota_today;
            $data.dialog.quotaA1 = $i18n.n_simple_earn_available_quota_today_answer;
            $data.dialog.quotaQ2 = $i18n.n_simple_earn_available_quota_calculat;
            $data.dialog.quotaA2 = $i18n.n_simple_earn_available_quota_calculat_method1;
            $data.dialog.quotaText1 = `<span style="color:${textColor}; font-size:14px;">${$i18n.n_simple_earn_user_remain_quota}：</span><span style="color:${highlightColor}; font-size:14px;">${userRemainQuota} ${currency}</span>`;
            $data.dialog.quotaText2 = `<span style="color:${textColor}; font-size:14px;">${$i18n.n_simple_earn_project_remain_quota_today}：</span><span style="color:${highlightColor}; font-size:14px;">${projectRemainAmtPerDay} ${currency}</span>`;
            $data.dialog.quotaText3 = `<span style="color:${textColor}; font-size:14px;">${$i18n.n_simple_earn_available_quota}：</span><span style="color:${highlightColor}; font-size:14px;">${availableQuota} ${currency}</span>`;
        } else {
            let surplusAmount = removeExtraZeros(getPriceString(project.surplusAmount, 8));
            $data.dialog.availableQuotaTitle = $i18n.n_simple_earn_available_quota;
            $data.dialog.quotaQ1 = $i18n.n_simple_earn_what_is_available_quota;
            $data.dialog.quotaA1 = $i18n.n_simple_earn_available_quota_answer;
            $data.dialog.quotaQ2 = $i18n.n_simple_earn_available_quota_calculat;
            $data.dialog.quotaA2 = $i18n.n_simple_earn_available_quota_calculat_method2;
            $data.dialog.quotaText1 = `<span style="color:${textColor}; font-size:14px;">${$i18n.n_simple_earn_user_remain_quota}：</span><span style="color:${highlightColor}; font-size:14px;">${userRemainQuota} ${currency}</span>`;
            $data.dialog.quotaText2 = `<span style="color:${textColor}; font-size:14px;">${$i18n.n_simple_earn_project_remain_quota}：</span><span style="color:${highlightColor}; font-size:14px;">${surplusAmount} ${currency}</span>`;
            $data.dialog.quotaText3 = `<span style="color:${textColor}; font-size:14px;">${$i18n.n_simple_earn_available_quota}：</span><span style="color:${highlightColor}; font-size:14px;">${availableQuota} ${currency}</span>`;
        }
        $data.dialog.showAvailableQuota = true;
    },
    closeAvailableQuotaDialog() {
        $data.dialog.showAvailableQuota = false;
    }
};

var projectId = "";

var shelfType = "";

function defaultData$3() {
    return {
        loadingLottieStatus: "stop",
        iconUrl: "",
        currency: "",
        apy: "",
        recommendShow: "gone",
        labelShow: "gone",
        tipsShow: "gone"
    };
}

const {moduleData: moduleData$3, moduleEvent: moduleEvent$3} = moduleDefine("result", defaultData$3, {
    onCreate: onCreate$1
});

let params = {};

function onCreate$1(param) {
    console.log("onCreate result" + param);
    params = JSON.parse(param);
    moduleData$3.resultStr = params.resultStr ? params.resultStr : "";
    setTimeout((() => {
        moduleData$3.loadingLottieStatus = "play";
    }), 600);
    if (params.productType == 0 && params.apyType == 1) {
        moduleData$3.tipsShow = "gone";
    } else {
        moduleData$3.tipsShow = "visible";
    }
    moduleData$3.recommendShow = "gone";
    requestSuccessView(params.orderId, params.recordId);
    subscribeSuccessShow();
}

async function requestSuccessView(orderId, recordId) {
    const params = {
        orderId: orderId,
        recordId: recordId
    };
    const data = await sendRequest("v1/saving/mining/order/demand/successView", params, 1, 0, {
        "Content-Type": "application/json"
    });
    if (data != null) {
        if (data.recommend.length > 0) {
            const element = data.recommend[0];
            moduleData$3.iconUrl = getPNGIconURLByCurrency(element.currency);
            moduleData$3.currency = element.currency.toUpperCase();
            moduleData$3.labelShow = element.projectLabelType == 1 ? "visible" : "gone";
            projectId = `${element.projectId}`;
            var descrbe = "";
            shelfType = element.shelfType ? String(element.shelfType) : "0";
            var term = element.term ? `${element.term}` : "-";
            switch (shelfType) {
              case "0":
                descrbe = $i18n.n_simple_earn_result_shelf_describe0;
                break;

              case "1":
                descrbe = $i18n.$intercept.n_simple_earn_result_shelf_describe1(`${term}`);
                break;

              case "2":
                descrbe = $i18n.n_simple_earn_result_shelf_describe2;
                break;

              case "8":
                descrbe = $i18n.n_simple_earn_result_shelf_describe8;
                break;

              case "11":
                descrbe = $i18n.n_simple_earn_result_shelf_describe11;
                break;
            }
            moduleData$3.descrbe = descrbe;
            var viewYearRate = "";
            var maxViewYearRate = "";
            if (element.viewYearRate) {
                viewYearRate = `${formatPrecision(multiply(element.viewYearRate, "100"), 2)}%`;
            }
            if (element.maxViewYearRate) {
                maxViewYearRate = `~ ${formatPrecision(multiply(element.maxViewYearRate, "100"), 2)}`;
            }
            moduleData$3.apy = `${viewYearRate}${maxViewYearRate}`;
            moduleData$3.recommendShow = "visible";
        }
    }
}

moduleEvent$3.checkMyOrder = function() {
    openURL(`${commonData.h5Url}/${commonData.language}/financial/earn/assets/h5?tabIndex=${params.productType}`);
    containerBack(-1);
    subscribeSuccessViewAssetsClick();
};

moduleEvent$3.continueBuy = function() {
    containerBack();
    subscribeSuccessContinueClick();
};

moduleEvent$3.backClick = function() {
    containerBack();
    subscribeSuccessCloseCloseClick();
};

moduleEvent$3.recommendClick = function() {
    if (shelfType == "11") {
        containerBack(-1);
        let url = "holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/edgeengine/container?scene=earn&rootName=structured&navConfig=native&tab=sharkfin&isClose=true";
        openURL(url);
    } else {
        const params = {
            projectId: projectId,
            currency: moduleData$3.currency,
            fromType: 1
        };
        $event.home.reloadWithParams(JSON.stringify(params));
        containerBack();
    }
};

const tag$4 = "simple_earn_receipt_dialog";

$data.receiptdialog = {
    isShow: false,
    tipText: ""
};

$event.receiptdialog = {
    openRegularDialog: function(index, receiptDelayDays = 0) {
        console.log(`${tag$4} openRegularDialog index= ${index} receiptDelayDays= ${receiptDelayDays}`);
        $data.receiptdialog.tipText = $i18n.$intercept.n_simple_earn_receipt_regular(`${receiptDelayDays}`);
        $data.receiptdialog.isShow = true;
        let element = $event.home.getCurrentElement(index);
        arrivalDateClick(element);
    },
    openCurrentDialog: function(index, redeemLimitPerDay) {
        console.log(`${tag$4} openCurrentDialog index= ${index} redeemLimitPerDay= ${redeemLimitPerDay}`);
        if (redeemLimitPerDay > 0) {
            let limit = getPriceString(redeemLimitPerDay, 0);
            let limit2 = getPriceString(redeemLimitPerDay * .75, 0);
            let limit3 = getPriceString(redeemLimitPerDay * .5, 0);
            let currency = $data.home.currency;
            let p1 = $i18n.$intercept.n_simple_earn_receipt_flexible1(`${limit}`, `${currency}`);
            let p2 = $i18n.$intercept.n_simple_earn_receipt_flexible2(`${limit}`, `${currency}`);
            let p3 = $i18n.$intercept.n_simple_earn_receipt_flexible3(`${limit2}`, `${currency}`, `${limit3}`, `${currency}`, `${limit}`, `${currency}`, `${limit3}`, `${currency}`);
            let p4 = $i18n.$intercept.n_simple_earn_receipt_flexible4();
            $data.receiptdialog.tipText = `${p1}\n${p2}\n${p3}\n${p4}`;
        } else {
            $data.receiptdialog.tipText = `${$i18n.n_simple_earn_receipt_current1}\n${$i18n.n_simple_earn_receipt_current2}`;
        }
        $data.receiptdialog.isShow = true;
        let element = $event.home.getCurrentElement(index);
        arrivalDateClick(element);
    },
    closeDialog: function() {
        $data.receiptdialog.isShow = false;
    }
};

const autoEarnRes = {
    title: $i18n.n_otc_use_tip,
    content: $i18n.n_simple_earn_auto_earn_content_new
};

$data.autoearn = {
    isShow: false,
    tipTitle: autoEarnRes.title,
    tipContent: autoEarnRes.content
};

$event.autoearn = {
    setContent: function(title, content) {
        $data.autoearn.tipTitle = title;
        $data.autoearn.tipContent = content;
    },
    openDialog: function() {
        $data.autoearn.isShow = true;
        autoEarnExplainClick();
    },
    closeDialog: function() {
        $data.autoearn.isShow = false;
    }
};

const purchaseTipRes = {
    title: $i18n.n_otc_use_tip,
    content: '{"content":"n_usdt_exchange_usdd_tip","textColor":"kColorPrimaryText","textSize":14,"highlight":[{"content":"n_usdt_exchange_usdd_tip_keyword","link":"","textColor":"kColorPrimaryText","bold":true}]}'
};

$data.purchaseTip = {
    isShow: false,
    tipTitle: purchaseTipRes.title,
    tipContent: purchaseTipRes.content
};

$event.purchaseTip = {
    setContent: function(title, content) {
        $data.purchaseTip.tipTitle = title;
        $data.purchaseTip.tipContent = content;
    },
    openDialog: function() {
        $data.purchaseTip.isShow = true;
    },
    closeDialog: function() {
        $data.purchaseTip.isShow = false;
    }
};

const tag$3 = "simple_earn";

const ladderRes$1 = {
    arrowUp: "@drawable/edge_engine_strutured_arrow_up",
    arrowDown: "@drawable/edge_engine_strutured_arrow_down",
    selectedColor: "@color/kColorMajorTheme100",
    unselectedColor: "@color/kColorPrimaryText",
    selectedImg: "@drawable/edge_engin_simple_earn_ladder_selected",
    unselectedImg: ""
};

class LadderItem {
    amountText="";
    rate="";
    type="1";
    setAmountText(item, currency) {
        if (item.amountEnd != 0) {
            this.amountText = `${item.amountStart} ~ ${item.amountEnd} ${currency}`;
        } else {
            this.amountText = `> ${item.amountStart} ${currency}`;
        }
    }
}

class LadderInnerItem {
    index=-1;
    currency="";
    currentcyImg="";
    currencyColor="";
    selectedImg="";
    type="1";
}

$data.ladder = {
    isShow: false,
    title: $i18n.n_simple_earn_ladder_title,
    tip: $i18n.n_simple_earn_ladder_hint,
    example: "",
    exampleVis: "gone",
    tableTitle: $i18n.n_simple_earn_ladder_all_apy,
    tableCurrency: "",
    arrowImg: ladderRes$1.arrowDown,
    headTitle: $i18n.n_asset_subscribe_number,
    headTitle2: $i18n.n_simple_earn_ladder_apy,
    ladderList: [],
    isShowInner: false,
    ladderInnerList: []
};

$event.ladder = {
    initCurrencyData: function() {
        getCurrencies();
    },
    openDialog: async function(index) {
        let currency = $data.home.currency;
        console.log(`${tag$3} openLadderDialog ${currency}`);
        $data.ladder.tableCurrency = currency;
        for (let i = 0; i < $data.ladder.ladderInnerList.length; i++) {
            let item = $data.ladder.ladderInnerList[i];
            if (currency == item.currency) {
                item.currencyColor = ladderRes$1.selectedColor;
                item.selectedImg = ladderRes$1.selectedImg;
                await getCurTieredRate(currency);
            } else {
                item.currencyColor = ladderRes$1.unselectedColor;
                item.selectedImg = ladderRes$1.unselectedImg;
            }
        }
        $data.ladder.isShow = true;
    },
    closeDialog: function() {
        $data.ladder.isShow = false;
    },
    onItemClick: function(idx) {
        console.log(`${tag$3} onItemClick idx= ${idx}`);
        for (let i = 0; i < $data.ladder.ladderInnerList.length; i++) {
            let item = $data.ladder.ladderInnerList[i];
            if (idx == i) {
                item.currencyColor = ladderRes$1.selectedColor;
                item.selectedImg = ladderRes$1.selectedImg;
                if ($data.ladder.tableCurrency != item.currency) {
                    $data.ladder.tableCurrency = item.currency;
                    getCurTieredRate(item.currency);
                }
            } else {
                item.currencyColor = ladderRes$1.unselectedColor;
                item.selectedImg = ladderRes$1.unselectedImg;
            }
        }
        this.closeInnerDialog();
    },
    openInnerDialog: function() {
        $data.ladder.isShowInner = true;
        $data.ladder.arrowImg = ladderRes$1.arrowUp;
    },
    closeInnerDialog: function() {
        $data.ladder.isShowInner = false;
        $data.ladder.arrowImg = ladderRes$1.arrowDown;
    }
};

async function getCurrencies() {
    try {
        const data = await sendRequest("v1/saving/mining/product/currencies");
        console.log("getCurrencies data= " + JSON.stringify(data));
        if (data != null) {
            refreshLadderInnerList(data);
        } else {
            console.log("getCurrencies data==null ");
        }
    } catch (e) {
        console.log(`getCurrencies error = ${e}`);
    }
}

function refreshLadderInnerList(data) {
    let list = [];
    for (let i = 0; i < data.length; i++) {
        let item = data[i];
        let ladderInner = new LadderInnerItem;
        ladderInner.index = i;
        ladderInner.currency = item;
        ladderInner.currentcyImg = getPNGIconURLByCurrency(item);
        if ($data.ladder.tableCurrency == item) {
            ladderInner.currencyColor = ladderRes$1.selectedColor;
            ladderInner.selectedImg = ladderRes$1.selectedImg;
        } else {
            ladderInner.currencyColor = ladderRes$1.unselectedColor;
            ladderInner.selectedImg = ladderRes$1.unselectedImg;
        }
        list.push(ladderInner);
    }
    $data.ladder.ladderInnerList = list;
}

async function getCurTieredRate(currencyName) {
    try {
        let param = {
            currency: currencyName
        };
        const data = await sendRequest("v1/saving/mining/product/tiered_rate", param);
        console.log(`${tag$3} getCurTieredRate currencyName= ${currencyName} data= ${JSON.stringify(data)}`);
        if (data != null) {
            $data.ladder.tableCurrency = currencyName;
            refreshLadderList(data);
            setExample(data, currencyName);
        } else {
            console.log(`${tag$3} getCurTieredRate data==null `);
        }
    } catch (e) {
        console.log(`${tag$3} getCurTieredRate error = ${e}`);
    }
}

function refreshLadderList(data) {
    let list = [];
    if (data.length > 0) {
        for (let i = 0; i < data.length; i++) {
            let item = data[i];
            let ladder = new LadderItem;
            ladder.setAmountText(item, $data.ladder.tableCurrency);
            ladder.rate = `${formatPrecision(item.rate * 100, 2)}%`;
            list.push(ladder);
        }
    } else {
        let ladder = new LadderItem;
        ladder.amountText = `> 0 ${$data.ladder.tableCurrency}`;
        ladder.rate = "0%";
        list.push(ladder);
    }
    console.log(`${tag$3} refreshLadderList list= ${JSON.stringify(list)}`);
    $data.ladder.ladderList = list;
}

function setExample(tieredRates, currency) {
    if (tieredRates.length > 1) {
        let rate1 = tieredRates[0];
        let rate2 = tieredRates[1];
        let num1 = rate1.amountEnd * 1.2;
        let num2 = rate1.amountEnd * .2;
        let rateText1 = formatPrecision(rate1.rate * 100, 2);
        let rateText2 = formatPrecision(rate2.rate * 100, 2);
        console.log(`${tag$3} setExample rateText1= ${rateText1} rateText2= ${rateText2}`);
        $data.ladder.example = adapterPercentFlag($i18n.$intercept.n_simple_earn_ladder_example(`${num1}`, `${currency}`, `${rate1.amountEnd}`, `${currency}`, `${rateText1}`, `${num2}`, `${currency}`, `${rateText2}`));
        $data.ladder.exampleVis = "visible";
    } else {
        $data.ladder.exampleVis = "gone";
    }
}

class ProfitOverviewItem {
    index=-1;
    currency="";
    perkApy="";
    perkLimit=0;
}

$data.profitOverview = {
    isShow: false,
    title: $i18n.n_simple_earn_profit_overview,
    tableTitle: $i18n.n_simple_earn_po_title,
    headTitle: $i18n.n_double_coin_earn_coin,
    headTitle2: $i18n.n_simple_earn_po_reward_limit,
    headTitle3: $i18n.n_simple_earn_po_perk_apy,
    profitOverviewList: [],
    rewardRuleTitle: "",
    rewardRuleContent1: "",
    rewardRuleContent2: "",
    exampleTitle: "",
    exampleContent1: "",
    exampleContent2: "",
    rewardRuleVis: "gone",
    exampleVis: "gone"
};

$event.profitOverview = {
    initData: function() {
        getPerkRates();
    },
    openDialog: function() {
        getPerkRates();
        $data.profitOverview.isShow = true;
    },
    closeDialog: function() {
        $data.profitOverview.isShow = false;
    }
};

function setRuleAndExample(oriLimit = 1e3, oriRate = 10) {
    let language = commonData.language;
    console.log(`simple-earn setRuleAndExample language= ${language}`);
    let limit = oriLimit;
    let limit5 = 5 * oriLimit;
    let rate = formatPrecision(oriRate, 2);
    let rate1 = formatPrecision(.4 * oriRate, 2);
    let rate2 = formatPrecision(.6 * oriRate, 2);
    let rate3 = formatPrecision(5 * oriRate, 2);
    $data.profitOverview.rewardRuleTitle = $i18n.n_simple_earn_po_reward_rule_title;
    $data.profitOverview.rewardRuleContent1 = adapterPercentFlag($i18n.$intercept.n_simple_earn_po_reward_rule_content1(`${rate}`, `${limit}`, `${rate}`, `${limit}`));
    $data.profitOverview.rewardRuleContent2 = adapterPercentFlag($i18n.$intercept.n_simple_earn_po_reward_rule_content2(`${rate}`));
    if (language == "zh-cn" || language == "zh-hk") {
        $data.profitOverview.exampleTitle = $i18n.n_simple_earn_po_example_title;
        $data.profitOverview.exampleContent1 = adapterPercentFlag($i18n.$intercept.n_simple_earn_po_example_content1(`${limit5}`, `${rate1}`, `${limit}`, `${rate}`, `${rate2}`, `${limit}`, `${rate1}`));
        $data.profitOverview.exampleContent2 = adapterPercentFlag($i18n.$intercept.n_simple_earn_po_example_content2(`${limit5}`, `${rate3}`, `${rate3}`));
        $data.profitOverview.exampleVis = "visible";
        $data.profitOverview.rewardRuleVis = "visible";
    } else {
        $data.profitOverview.exampleVis = "gone";
        $data.profitOverview.rewardRuleVis = "visible";
    }
}

async function getPerkRates() {
    try {
        let param = {
            index: 0,
            size: 500
        };
        const data = await sendRequest("v3/saving/mining/project/perkProjectRec", param);
        console.log("simple-earn getPerkRates data= " + JSON.stringify(data));
        if (data != null) {
            let list = [];
            for (let i = 0; i < data.length; i++) {
                let item = data[i];
                if (item.perkApy == undefined || item.perkApy.length == 0) {
                    continue;
                }
                let temp = new ProfitOverviewItem;
                temp.index = i;
                temp.currency = item.currency;
                temp.perkApy = item.perkApy;
                temp.perkLimit = item.perkLimit;
                temp.type = "1";
                list.push(temp);
                if (item.currency == "USDT") {
                    let perkApy = item.perkApy;
                    perkApy = perkApy.substring(0, perkApy.length - 1);
                    setRuleAndExample(item.perkLimit, perkApy);
                }
            }
            console.log("simple-earn getPerkRates end data= " + JSON.stringify(list));
            $data.profitOverview.profitOverviewList = list;
            if ($data.profitOverview.rewardRule == "") {
                setRuleAndExample();
            }
        } else {
            setRuleAndExample();
            console.log("simple-earn getPerkRates data==null ");
        }
    } catch (e) {
        console.log(`simple-earn getPerkRates error = ${e}`);
        setRuleAndExample();
    }
}

const couponRes = {
    size1: 12,
    size2: 14,
    color1: "@color/kColorThreeLevelText",
    color2: "@color/kColorPrimaryText",
    fontWeight1: 400,
    fontWeight2: 500
};

$data.coupon = {
    isShow: false,
    tableTitle: $i18n.n_simple_earn_coupon_dialog_title,
    tableTitleContent: $i18n.n_simple_earn_coupon_dialog_content,
    headTitle: $i18n.n_asset_subscribe_number,
    headTitle2: $i18n.n_simple_earn_original_coupon,
    headTitle3: $i18n.n_simple_earn_extra_coupon,
    couponList: [ {
        type: "1",
        amount: "1-1,000 USDT",
        apy: "20.00%",
        perkApy: `+5.00%(7)${$i18n.n_day}`,
        size: couponRes.size2,
        color: couponRes.color2,
        fontWeight: couponRes.fontWeight2
    }, {
        type: "1",
        amount: "＞1,000 USDT",
        apy: "20.00%",
        perkApy: $i18n.n_simple_earn_coupon_dialog_none,
        size: couponRes.size1,
        color: couponRes.color1,
        fontWeight: couponRes.fontWeight1
    } ],
    bottomText1: $i18n.n_simple_earn_coupon_dialog_bottom1,
    bottomText2: $i18n.n_simple_earn_coupon_dialog_bottom2
};

$event.coupon = {
    openDialog: function(index) {
        $data.coupon.isShow = true;
        let element = $event.home.getCurrentElement(index);
        couponExplainClick(element);
    },
    closeDialog: function() {
        $data.coupon.isShow = false;
    }
};

const tag$2 = "simple_earn_fund";

const constansSp = {
    moduleName: "simple_earn",
    spKeyUSDD: "simple_earn_USDD",
    spKeyUSDT: "simple_earn_USDT"
};

const fundRes = {
    selectedImg: "@drawable/edge_engine_copy_trading_select",
    unselectedImg: "@drawable/edge_engine_copy_trading_unselect",
    confirmBgEnableColor: "@color/kColorMajorTheme100",
    confirmTextEnableColor: "@color/KBaseTextColor",
    confirmTextDisableColor: "@color/kColorThreeLevelText",
    confirmBgDisableColor: "@color/kColorEBEBEB"
};

$data.fund = {
    isShow: false,
    tip1Vis: "visible",
    tip2Vis: "gone",
    items: [],
    totalBalance: "123",
    confirmTextColor: "",
    confirmBgColor: "",
    statusUSDD: false,
    statusUSDT: false
};

function getDefaultData() {
    return {
        items: []
    };
}

var curIndex = -1;

let selectStatus = 0;

function refreshFundUI(element) {
    const items = $data.fund.items;
    let tempAmount = "0";
    selectStatus = 0;
    for (let i = 0; i < items.length; i++) {
        const item = items[i];
        if (item.checkImg == fundRes.selectedImg) {
            tempAmount = add(tempAmount, item.balance);
            selectStatus++;
        }
    }
    $data.fund.totalBalance = tempAmount;
    if (selectStatus > 0) {
        $data.fund.tip1Vis = "visible";
        $data.fund.tip2Vis = "gone";
        $data.fund.confirmTextColor = fundRes.confirmTextEnableColor;
        $data.fund.confirmBgColor = fundRes.confirmBgEnableColor;
    } else {
        $data.fund.tip1Vis = "gone";
        $data.fund.tip2Vis = "visible";
        $data.fund.confirmTextColor = fundRes.confirmTextDisableColor;
        $data.fund.confirmBgColor = fundRes.confirmBgDisableColor;
    }
}

function trackItemClick(currency, isSelect) {
    if (currency == "USDD") {
        assetSourceUSDDItemClick(isSelect);
    } else if (currency == "USDT") {
        assetSourceUSDTItemClick(isSelect);
    }
}

$event.fund = {
    confirm: function() {
        if (selectStatus == 0) {
            return;
        }
        assetSourceConfirmBtnClick();
        const element = $data.home.sliderData[curIndex];
        const itemsOuter = element.fundListData.items;
        const items = $data.fund.items;
        let totalBalance = 0;
        let totalCurrency = "";
        for (let i = 0; i < items.length; i++) {
            const item = items[i];
            const key = item.currency.toUpperCase() === "USDD" ? constansSp.spKeyUSDD : constansSp.spKeyUSDT;
            if (item.checkImg == fundRes.selectedImg) {
                save(constansSp.moduleName, key, true);
                if (item.currency.toUpperCase() === "USDD") {
                    $data.fund.statusUSDD = true;
                } else {
                    $data.fund.statusUSDT = true;
                }
                totalBalance = add(totalBalance, item.balance);
                totalCurrency = totalCurrency.length == 0 ? item.currency : `(${totalCurrency}+${item.currency})`;
            } else {
                save(constansSp.moduleName, key, false);
                if (item.currency.toUpperCase() === "USDD") {
                    $data.fund.statusUSDD = false;
                } else {
                    $data.fund.statusUSDT = false;
                }
            }
            itemsOuter[i].checkImg = item.checkImg;
        }
        element.assetSourceDesc = $i18n.$intercept.n_cash_asset_balance(`${totalCurrency}`);
        element.balance = totalBalance;
        element.balanceText = `${removeExtraZeros(getPriceString(totalBalance, 8))}`;
        $event.flexible.subTextChange(element.mSubInput, curIndex);
        $event.fund.closeDialog();
    },
    itemClick: function(index) {
        console.log(`${tag$2} itemClick curIndex= ${curIndex} index= ${index}`);
        $data.home.sliderData[curIndex];
        let img = $data.fund.items[index].checkImg;
        if (img == fundRes.selectedImg) {
            img = fundRes.unselectedImg;
            trackItemClick($data.fund.items[index].currency, "off");
        } else if (img == fundRes.unselectedImg) {
            img = fundRes.selectedImg;
            trackItemClick($data.fund.items[index].currency, "on");
        }
        $data.fund.items[index].checkImg = img;
        refreshFundUI();
    },
    initData: function(subOtherAmtInfo, element) {
        console.log(`${tag$2} initData start subOtherAmtInfo= ${JSON.stringify(subOtherAmtInfo)}`);
        const fundData = getDefaultData();
        for (let i = 0; i < subOtherAmtInfo.length; i++) {
            const info = subOtherAmtInfo[i];
            const title = $i18n.$intercept.n_cash_asset_balance(`${info.currency}`);
            const currency = info.currency;
            const balance = removeExtraZeros(formatPrecision(info.amount, 8));
            let checkImg = fundRes.unselectedImg;
            let selectStatus = info.currency.toUpperCase() === "USDD" ? $data.fund.statusUSDD : $data.fund.statusUSDT;
            console.log(`${tag$2} initData selectStatus= ${selectStatus}`);
            if (selectStatus != null) {
                if (selectStatus) {
                    checkImg = fundRes.selectedImg;
                } else {
                    checkImg = fundRes.unselectedImg;
                }
            } else {
                checkImg = info.currency === "USDD" ? fundRes.selectedImg : fundRes.unselectedImg;
            }
            const source = info.source;
            const type = "1";
            const index = i;
            let item = {
                title: title,
                balance: balance,
                checkImg: checkImg,
                source: source,
                currency: currency,
                type: type,
                index: index
            };
            fundData.items.push(item);
        }
        console.log(`${tag$2} initData items= ${JSON.stringify(fundData.items)}`);
        element.fundListData = fundData;
        console.log(`${tag$2} initData end`);
    },
    openDialog: function(index) {
        console.log(`${tag$2} openDialog index= ${index}`);
        curIndex = index;
        let element = $data.home.sliderData[index];
        console.log(`${tag$2} openDialog items= ${JSON.stringify(element.fundListData.items)}`);
        $data.fund.items = element.fundListData.items;
        refreshFundUI();
        $data.fund.isShow = true;
        assetSourceDialogShow();
    },
    closeDialog: function() {
        curIndex = -1;
        $data.fund.isShow = false;
    }
};

const tag$1 = "simple_earn";

const ladderRes = {
    ladderSelectedColor: "@color/kColorPrimaryText",
    ladderUnselectedColor: "@color/kColorThreeLevelText",
    ladderSelectedImg: "@drawable/edge_engin_simple_earn_current_ladder_selected",
    ladderUnselectedImg: "@drawable/edge_engin_simple_earn_current_ladder_unselected"
};

const autoEarnSwitchRes = {
    openImg: "@drawable/edge_engine_common_switch_open",
    closeImg: "@drawable/edge_engine_common_switch_close"
};

function defaultData$2() {
    return {};
}

function defaultHandlerData() {
    return {
        subHint: $i18n.$intercept.n_shark_fin_min_amount(""),
        subInput: "",
        subOnFocus: false,
        subBorderColor: "@color/KBaseColorInputBackground",
        subErrorStr: "",
        subErrorVis: "gone",
        estimatedProfit: `-- ${$data.home.currency}`,
        profitEveryDay: "gone",
        availableQuota: "",
        availableQuotaText: "",
        availableQuotaTitle: "",
        assetSourceTitle: "",
        assetSourceDesc: "",
        assetSourceDisplay: "visible",
        openAccountAlertShow: false,
        couponVis: "gone",
        couponTextUp: "",
        couponTextDown: "",
        couponTextDownVis: "visible",
        couponRightImgVis: "visible",
        couponMidVis: "visible",
        couponTextMidVis: "gone",
        couponTextMid: "",
        couponListData: {},
        fundListData: {},
        balanceText: "",
        balance: "",
        ladderVis: "gone",
        profitVis: "gone",
        ladderList: [],
        profitList: [],
        profitHint: "",
        profitHintVis: "gone",
        subOverviewTitle: "",
        subOverviewT1: "",
        subOverviewC1: "",
        subOverviewT2: "",
        subOverviewC2: "",
        subOverviewT3: "到账日",
        subOverviewC3: "",
        subOverviewT3Vis: "visible",
        subOverviewT3ULVis: "gone",
        autoEarnSwitcher: autoEarnSwitchRes.closeImg,
        mMinSub: "",
        mSubInput: "",
        projectId: 0,
        usingCoupon: {},
        supportCoupon: 0,
        userInvestAmt: 0,
        mMarketApyVo: null,
        inputStatus: false,
        apyType: -1,
        autoEarn: 0,
        userRemainQuota: 0,
        surplusAmount: 0,
        projectRemainAmtPerDay: null,
        redeemLimitPerDay: 0
    };
}

const {moduleData: moduleData$2, moduleEvent: moduleEvent$2} = moduleDefine("flexible", defaultData$2, {});

function handleCurrentDetail(project, originCouponData) {
    try {
        var handlerData = defaultHandlerData();
        if (project != null) {
            console.log(`${tag$1} handleCurrentDetail project= " + ${JSON.stringify(project)}`);
            handlerData.productType = project.productType;
            if (project.productType === 0) {
                getCurrentData(project, handlerData, originCouponData);
            }
            console.log(`${tag$1} handleCurrentDetail handlerData= " + ${JSON.stringify(handlerData)}`);
        } else {
            console.log(`${tag$1} handleCurrentDetail data==null `);
        }
        return handlerData;
    } catch (e) {
        console.log(`handleCurrentDetail error = ${e}`);
    }
}

function showBalance(balance, suffix = false) {
    let format = formatPrecision(balance, 8).toString();
    console.log(tag$1 + " showBalance format= " + format);
    let ans = removeExtraZeros(format);
    console.log(tag$1 + " showBalance ans= " + ans);
    if (suffix) {
        return `${ans} ${$data.home.currency}`;
    } else {
        return `${ans}`;
    }
}

function getCurrentData(project, handlerData, originCouponData) {
    let min = Math.min(project.startAmount, project.subscribeMinAmount);
    let minSub = removeExtraZeros(formatPrecision(min, 8));
    handlerData.mMinSub = minSub;
    console.log(`${tag$1} getCurrentData mMinSub=  ${handlerData.mMinSub}`);
    handlerData.subHint = $i18n.$intercept.n_shark_fin_min_amount(`${handlerData.mMinSub}`);
    handlerData.availableQuota = project.availableQuota;
    handlerData.availableQuotaText = `${removeExtraZeros(getPriceString(project.availableQuota, 8))}`;
    handlerData.userRemainQuota = project.userRemainQuota;
    handlerData.surplusAmount = project.surplusAmount;
    handlerData.tag = project.tag;
    handlerData.launchPoolActivityId = project.launchPoolActivityId;
    handlerData.projectRemainAmtPerDay = project.projectRemainAmtPerDay;
    handleAssetSourceDesc(project.subOtherAmtInfo, handlerData);
    if (handlerData.projectRemainAmtPerDay == null) {
        handlerData.availableQuotaTitle = $i18n.n_simple_earn_available_quota;
    } else {
        handlerData.availableQuotaTitle = $i18n.n_simple_earn_available_quote_today;
    }
    handlerData.projectId = project.projectId;
    handlerData.status = project.status;
    handlerData.kycLimitUserViewLevel = project.kycLimitUserViewLevel;
    handlerData.autoEarnSwitcher = project.balanceAutoStatus == null || project.balanceAutoStatus == undefined || project.balanceAutoStatus == 0 ? autoEarnSwitchRes.closeImg : autoEarnSwitchRes.openImg;
    handlerData.autoEarn = project.balanceAutoStatus;
    handlerData.usingCoupon = project.usingCoupon == null ? {} : project.usingCoupon;
    handlerData.supportCoupon = project.supportCoupon;
    handlerData.userInvestAmt = project.userInvestAmt;
    if (handlerData.supportCoupon == 1) {
        handlerData.couponVis = "visible";
        getCouponData(handlerData, originCouponData);
    } else {
        handlerData.couponVis = "gone";
    }
    handlerData.term = project.term;
    handlerData.productType = project.productType;
    handlerData.apyType = project.apyType;
    if (project.apyType == 0) {
        handlerData.profitVis = "gone";
        handlerData.ladderList = handleLadderData(project.tieredRates, project);
        handlerData.ladderVis = handlerData.ladderList.length > 1 ? "visible" : "gone";
        handleSubOverviewData(project, false, handlerData);
        $event.ladder.initCurrencyData();
        handlerData.profitEveryDay = "visible";
    } else if (project.apyType == 1) {
        handlerData.mMarketApyVo = project.marketApyVo;
        handlerData.ladderVis = "gone";
        let subInt = handlerData.mSubInput.length === 0 ? 0 : bignumber(handlerData.mSubInput);
        handlerData.profitList = handleProfitOverviewData(project.marketApyVo, project.userInvestAmt, handlerData, subInt);
        handlerData.profitVis = "visible";
        handleSubOverviewData(project, true, handlerData);
        $event.profitOverview.initData();
    }
}

function handleAssetSourceDesc(otherAmtInfo, handlerData) {
    if (otherAmtInfo == null) {
        console.log(`${tag$1} handleAssetSourceDesc assetSourceDisplay gone`);
        handlerData.assetSourceDisplay = "gone";
        handlerData.balanceText = $data.home.balanceText;
        handlerData.balance = $data.home.balance;
    } else {
        handlerData.assetSourceDisplay = "visible";
        checkShowAssetPopup();
        handlerData.assetSourceTitle = $i18n.n_asset_source;
        console.log(`${tag$1} handleAssetSourceDesc assetSourceDisplay visible length: ${otherAmtInfo.length}`);
        let totalBalance = 0;
        let totalCurrency = "";
        for (let i = 0; i < otherAmtInfo.length; i++) {
            const info = otherAmtInfo[i];
            let selectStatus = info.currency.toUpperCase() === "USDD" ? $data.fund.statusUSDD : $data.fund.statusUSDT;
            console.log(`${tag$1} handleAssetSourceDesc selectStatus= ${selectStatus} info= ${JSON.stringify(info)}}`);
            if (selectStatus != null) {
                if (selectStatus) {
                    totalBalance = add(totalBalance, info.amount);
                    totalCurrency = totalCurrency.length == 0 ? info.currency : `(${totalCurrency}+${info.currency})`;
                }
            } else {
                if (info.currency.toUpperCase() === "USDD") {
                    totalBalance = add(totalBalance, info.amount);
                    totalCurrency = totalCurrency.length == 0 ? info.currency : `(${totalCurrency}+${info.currency})`;
                }
            }
        }
        console.log(`${tag$1} handleAssetSourceDesc totalBalance= ${totalBalance} totalCurrency= ${totalCurrency} handlerData= ${handlerData}`);
        handlerData.assetSourceDesc = $i18n.$intercept.n_cash_asset_balance(`${totalCurrency}`);
        handlerData.balanceText = `${removeExtraZeros(getPriceString(totalBalance, 8))}`;
        handlerData.balance = totalBalance;
        $event.fund.initData(otherAmtInfo, handlerData);
        console.log(`${tag$1} getCurrentData assetSourceDisplay after initData`);
    }
}

moduleEvent$2.clickPurchaseDialogClose = function() {
    $event.purchaseTip.closeDialog();
    checkShowAssetPopup();
};

async function checkShowAssetPopup() {
    let didDialogShow = await read("simple_earn", "didShow");
    console.log(`USDD flexible asset popup dialobgShown = ${didDialogShow}`);
    if (didDialogShow != "1") {
        return;
    }
    let date = new Date;
    let month = date.getMonth() + 1;
    let day = date.getDate();
    let shownDate = month + "-" + day;
    let lastShownDate = await read("simple_earn", "didShowPopup");
    if (lastShownDate != shownDate) {
        showAssetPopup();
        await save("simple_earn", "didShowPopup", shownDate);
    }
    console.log(`USDD flexible asset popup shownDate = ${shownDate} and lastShownDate = ${lastShownDate}`);
}

function showAssetPopup() {
    setTimeout((() => {
        $data.assetSource.popShow = true;
        setTimeout((() => {
            $data.assetSource.popShow = false;
        }), 5e3);
    }), 500);
}

function handleSubOverviewData(project, isMarket, handlerData) {
    if (isMarket) {
        handlerData.subOverviewTitle = $i18n.n_simple_earn_so_current_title1;
        handlerData.subOverviewT1 = $i18n.n_simple_earn_so_sub_time;
        handlerData.subOverviewC1 = $i18n.n_simple_earn_so_now;
        handlerData.subOverviewT2 = $i18n.n_simple_earn_so_start_time;
        handlerData.subOverviewC2 = project.dtInterestStart;
        handlerData.subOverviewT3 = $i18n.n_simple_earn_so_first_income_time;
        handlerData.subOverviewC3 = project.dtInterestGrant;
        handlerData.subOverviewT3Vis = "visible";
        handlerData.subOverviewT3ULVis = "gone";
    } else {
        handlerData.subOverviewTitle = $i18n.$intercept.n_simple_earn_so_current_title2(`${project.dtInterestStart}`);
        handlerData.subOverviewT1 = $i18n.n_simple_earn_so_sub_day;
        handlerData.subOverviewC1 = project.dtSubscribe;
        handlerData.subOverviewT2 = $i18n.n_simple_earn_so_start_day;
        handlerData.subOverviewC2 = project.dtInterestStart;
        handlerData.subOverviewT3 = $i18n.n_simple_earn_so_receipt_day;
        handlerData.subOverviewC3 = $i18n.n_simple_earn_so_real_time_payment;
        handlerData.subOverviewT3Vis = "gone";
        handlerData.subOverviewT3ULVis = "visible";
        handlerData.redeemLimitPerDay = project.redeemLimitPerDay ? project.redeemLimitPerDay : 0;
    }
}

function handleProfitOverviewData(marketApyVo, userInvestAmt, handlerData, subNum = 0) {
    console.log(`${tag$1} handleProfitOverviewData begin subNum= ${subNum}`);
    let profits = [];
    let subNumText = removeExtraZeros(formatPrecision(subNum, 8));
    if (marketApyVo.marketTimeApy > marketApyVo.marketPerkApy) {
        let item = {};
        if (subNum == 0) {
            item.title = $i18n.n_asset_all_balances;
        } else {
            item.title = `${subNumText} ${$data.home.currency}`;
        }
        item.rate = `${formatPrecision(multiply(marketApyVo.marketTimeApy, 100), 2).toString()}%`;
        item.type = "1";
        item.perkVis = "gone";
        profits.push(item);
    } else {
        let item = {};
        if (subNum == 0) {
            let marketPerkUpLimitText = removeExtraZeros(formatPrecision(marketApyVo.marketPerkUpLimit, 8));
            item.title = `0 ~ ${marketPerkUpLimitText} ${$data.home.currency}`;
            item.rate = `${formatPrecision(multiply(marketApyVo.marketPerkApy, 100), 2).toString()}%`;
            item.perkVis = "visible";
            item.type = "1";
            profits.push(item);
            item = {};
            item.title = `> ${marketPerkUpLimitText} ${$data.home.currency}`;
            item.rate = `${formatPrecision(multiply(marketApyVo.marketTimeApy, 100), 2).toString()}%`;
            item.perkVis = "gone";
            item.type = "1";
            profits.push(item);
            handlerData.profitHintVis = "gone";
        } else {
            if (userInvestAmt >= marketApyVo.marketPerkUpLimit) {
                item.title = `${subNumText} ${$data.home.currency}`;
                item.rate = `${formatPrecision(multiply(marketApyVo.marketTimeApy, 100), 2).toString()}%`;
                item.perkVis = "gone";
                item.type = "1";
                profits.push(item);
                handlerData.profitHintVis = "gone";
            } else {
                if (userInvestAmt <= marketApyVo.marketPerkUpLimit - subNum) {
                    item.title = `${subNumText} ${$data.home.currency}`;
                    item.rate = `${formatPrecision(multiply(marketApyVo.marketPerkApy, 100), 2).toString()}%`;
                    item.perkVis = "visible";
                    item.type = "1";
                    profits.push(item);
                    handlerData.profitHintVis = "visible";
                    let quota = removeExtraZeros(formatPrecision(subtract(marketApyVo.marketPerkUpLimit - userInvestAmt, subNum), 8));
                    handlerData.profitHint = $i18n.$intercept.n_simple_earn_more_quota(`${quota} ${$data.home.currency}`);
                } else {
                    let amount1 = subtract(marketApyVo.marketPerkUpLimit, userInvestAmt);
                    let amount1Text = removeExtraZeros(formatPrecision(amount1, 8));
                    item.title = `${amount1Text} ${$data.home.currency}`;
                    item.rate = `${formatPrecision(multiply(marketApyVo.marketPerkApy, 100), 2).toString()}%`;
                    item.perkVis = "visible";
                    item.type = "1";
                    profits.push(item);
                    item = {};
                    let amount2 = subtract(subNum, amount1);
                    let amount2Text = removeExtraZeros(formatPrecision(amount2, 8));
                    item.title = `${amount2Text} ${$data.home.currency}`;
                    item.rate = `${formatPrecision(multiply(marketApyVo.marketTimeApy, 100), 2).toString()}%`;
                    item.perkVis = "gone";
                    item.type = "1";
                    profits.push(item);
                    handlerData.profitHintVis = "gone";
                }
            }
        }
    }
    if (handlerData.tag == 9 && handlerData.launchPoolActivityId != null) {
        let item = {};
        item.type = "2";
        item.launchPoolActivityId = handlerData.launchPoolActivityId;
        profits.push(item);
    }
    console.log(`${tag$1} handleProfitOverviewData end ${JSON.stringify(profits)}`);
    return profits;
}

function handleLadderData(tieredRates, handlerData) {
    let ans = [];
    for (let i = 0; i < tieredRates.length; i++) {
        let item = tieredRates[i];
        item.type = "1";
        item.index = i;
        item.indexText = `${i + 1}`;
        item.select = false;
        item.ladderColor = ladderRes.ladderUnselectedColor;
        item.ladderImg = ladderRes.ladderUnselectedImg;
        if (item.amountEnd != 0) {
            item.content = `${item.amountStart} ~ ${item.amountEnd}`;
        } else {
            item.content = `> ${item.amountStart}`;
        }
        item.rateText = `${formatPrecision(multiply(item.rate, 100), 2)}%`;
        ans.push(item);
    }
    if (handlerData.tag == 9 && handlerData.launchPoolActivityId != null) {
        let item = {};
        item.type = "2";
        item.launchPoolActivityId = handlerData.launchPoolActivityId;
        ans.push(item);
    }
    return ans;
}

moduleEvent$2.clickLaunchpool = function(launchPoolActivityId) {
    $data.home.isRefreshData = false;
    console.log(`simple_earn clickLaunchpool launchPoolActivityId= ${launchPoolActivityId}`);
    openPageWithPath(`/assetactivity/launchpool?activityId=${parseInt(launchPoolActivityId)}`);
    launchpoolRewardsClick();
};

moduleEvent$2.maxSub = function(index) {
    let element = $data.home.sliderData[index];
    console.log(`maxSub click ${element.balance} ${JSON.stringify(element)}`);
    if (element.balance > 0) {
        element.subInput = showBalance(element.balance, false);
        element.mSubInput = element.subInput;
        if (commonData.OS == 0) {
            moduleEvent$2.subTextChange(element.mSubInput, index);
        }
    } else {
        element.subInput = "0";
        element.mSubInput = element.subInput;
    }
    maxClick(element);
};

moduleEvent$2.subFocusChange = function(focus) {
    console.log(`${tag$1} subFocusChange : ${focus}`);
};

moduleEvent$2.subOnReturn = function(parameter) {
    console.log(`${tag$1} subOnReturn : ${parameter}`);
    moduleData$2.subOnFocus = false;
};

moduleEvent$2.subTextChange = function(inputStr, index) {
    let element = $data.home.sliderData[index];
    console.log(`${tag$1} subTextChange : inputStr= ${inputStr} mSubInput= ${element.mSubInput} index= ${index}`);
    element.mSubInput = inputStr;
    let subInt = inputStr.length === 0 ? 0 : bignumber(inputStr);
    refreshProfit(subInt, element);
    refreshCoupon(subInt, element);
    refreshLadder(subInt, element);
    refreshProfitOverview(subInt, element);
    if (!checkSubInput(element)) {
        element.inputStatus = false;
        $event.deposit.checkBtnStatus(element.status, element.inputStatus);
        return;
    }
    element.inputStatus = element.subErrorVis == "gone" && inputStr != "";
    console.log(`${tag$1} subTextChange inputStatus= ${element.inputStatus} - ${element.subErrorVis == "gone"} - ${inputStr != ""}`);
    if ($event.deposit.checkBtnStatus(element.status, element.inputStatus)) ;
};

function refreshProfitOverview(subNum, element) {
    console.log(`${tag$1} refreshProfitOverview subNum= ${subNum}`);
    let mMarketApyVo = element.mMarketApyVo;
    if (mMarketApyVo == null) {
        console.log(`${tag$1} refreshProfitOverview over because mMarketApyVo == null`);
        return;
    }
    let userInvestAmt = element.userInvestAmt;
    console.log(`${tag$1} refreshProfitOverview mMarketApyVo= ${JSON.stringify(mMarketApyVo)} userInvestAmt= ${userInvestAmt}`);
    element.profitList = handleProfitOverviewData(mMarketApyVo, userInvestAmt, element, subNum);
}

function refreshLadder(subNum, element) {
    console.log(`${tag$1} refreshLadder begin ${subNum}`);
    let ladderList = element.ladderList;
    for (let i = 0; i < ladderList.length; i++) {
        let item = ladderList[i];
        if (subNum <= item.amountStart) {
            item.select = false;
            item.ladderColor = ladderRes.ladderUnselectedColor;
            item.ladderImg = ladderRes.ladderUnselectedImg;
        } else {
            item.select = true;
            item.ladderColor = ladderRes.ladderSelectedColor;
            item.ladderImg = ladderRes.ladderSelectedImg;
        }
    }
}

async function refreshProfit(subInt, element) {
    console.log(`${tag$1} refreshProfit sub = ${subInt} profit visible= ${element.profitEveryDay}`);
    if (element.profitEveryDay == "gone") {
        return;
    }
    if (subInt == null || subInt <= 0) {
        subInt = 0;
    }
    if (subInt === 0) {
        element.estimatedProfit = `-- ${$data.home.currency}`;
    } else {
        let param = {
            projectId: element.projectId,
            amt: subInt
        };
        console.log(`${tag$1} refreshProfit param = ${JSON.stringify(param)}`);
        const data = await sendRequest("v4/saving/mining/project/profit/estimate", param);
        console.log(`${tag$1} refreshProfit data = ${JSON.stringify(data)}`);
        if (data != null) {
            let profit = data.profitFormatShow;
            console.log(`${tag$1} refreshProfit profit = ${profit}`);
            element.estimatedProfit = `${profit} ${$data.home.currency}`;
        } else {
            console.log(`${tag$1} refreshProfit error`);
            element.estimatedProfit = `-- ${$data.home.currency}`;
        }
    }
}

function checkSubInput(element) {
    const quantity = parseFloat(element.mSubInput);
    const minSub = parseFloat(element.mMinSub);
    const balance = parseFloat(element.balance);
    const availableQuota = parseFloat(element.availableQuota);
    if (quantity > balance) {
        element.subBorderColor = "@color/KBaseInputInvalidTipColor";
        element.subErrorStr = $i18n.n_simple_earn_input_over_balance;
        element.subErrorVis = "visible";
        return false;
    } else if (quantity < minSub) {
        element.subBorderColor = "@color/KBaseInputInvalidTipColor";
        element.subErrorStr = $i18n.$intercept.n_simple_earn_input_min_subscribe(`${element.mMinSub}`, `${$data.home.currency}`);
        element.subErrorVis = "visible";
        return false;
    } else if (quantity > availableQuota) {
        element.subBorderColor = "@color/KBaseInputInvalidTipColor";
        element.subErrorStr = $i18n.n_simple_earn_input_over_quota;
        element.subErrorVis = "visible";
        return false;
    } else {
        element.subBorderColor = "@color/KBaseColorInputBackground";
        element.subErrorVis = "gone";
        return true;
    }
}

moduleEvent$2.clickAutoEarnSwitch = function(index) {
    let element = $data.home.sliderData[index];
    if (element.autoEarnSwitcher == autoEarnSwitchRes.openImg) {
        element.autoEarnSwitcher = autoEarnSwitchRes.closeImg;
        element.autoEarn = 0;
    } else {
        element.autoEarnSwitcher = autoEarnSwitchRes.openImg;
        element.autoEarn = 1;
    }
    autoEarnSwitchClick(element.autoEarn);
};

function defaultData$1() {
    return {
        dataVis: "gone",
        scrollToTag: "",
        earnTabList: [],
        sliderData: [],
        currentIndex: 0,
        currency: "",
        balance: "--",
        topIcon: "",
        topTitle: "",
        submitText: $i18n.n_balance_mining_deposit,
        isRefreshData: false
    };
}

var parameter = {};

var intercal = null;

var currentCount = 1;

var resumeIsNotFirst = false;

var earnTabList = [];

var currentSelectIndex = -1;

var onResumeTime = 0;

$data.assetSource = {
    popShow: false
};

const {moduleData: moduleData$1, moduleEvent: moduleEvent$1} = moduleDefine("home", defaultData$1, {
    onCreate: onCreate,
    onResume: onResume,
    onDestroy: onDestroy
});

function onCreate(jsonParameters) {
    console.log("home --  onCreate: " + `${jsonParameters}`);
    moduleData$1.statusBarConfig = {
        statusBarMode: "true",
        adStatusBarColor: "kColorContentBackground"
    };
    moduleData$1.navConfig = getNavConfigString();
    parameter = JSON.parse(jsonParameters);
    $data.deposit.richTextData = `{"content":"n_simple_earn_auth_confirm","textColor":"kColorPrimaryText","textSize":12,"highlight":[{"content":"n_simple_earn_auth_confirm_link","link":"${commonData.h5Url}/${commonData.language}/support/900004967323","textColor":"KBaseColorMajorTheme100","textSize":12}]}`;
    moduleData$1.topIcon = getPNGIconURLByCurrency(parameter.currency);
    moduleData$1.topTitle = `${parameter.currency} ${$i18n.n_kline_detail_earncoins}`;
    requestFlexibleDetail(true);
}

function onResume() {
    if (resumeIsNotFirst && $data.home.isRefreshData) {
        console.log("home onResume");
        requestFlexibleDetail(false);
        $data.home.isRefreshData = false;
    }
    resumeIsNotFirst = true;
}

function onDestroy() {
    clearTimer();
}

async function requestFlexibleDetail(isFirstTime, onlyRefreshApy = false) {
    onResumeTime = Date.now();
    let reqObkj = {
        currency: parameter.currency
    };
    const data = await sendRequest("v4/saving/mining/project/buy/merge/detail", reqObkj);
    if (data == null) {
        earnPurchaseLoadStatus("fault");
    }
    console.log(`buy/merge/detail : ${JSON.stringify(data)}`);
    let pids = [];
    for (const p of data.projects) {
        if (p.productType == "0" && p.supportCoupon == 1) {
            pids.push(p.projectId);
        } else if (p.productType == "1" && p.supportCoupon == 1) {
            if (p.fixedType == "0" || p.fixedType == "2") {
                pids.push(p.projectId);
            }
        }
    }
    console.log(`requestFlexibleDetail pids= ${JSON.stringify(pids)}`);
    let originCouponData = {};
    if (pids.length > 0) {
        let projectIds = pids.join(",");
        let param = {
            projectIds: projectIds
        };
        console.log(`requestFlexibleDetail param= ${JSON.stringify(param)}`);
        const couponData = await sendRequest("v4/saving/mining/project/buy/merge/coupons", param);
        if (couponData && couponData != null) {
            originCouponData = couponData;
        }
    }
    $data.fund.statusUSDD = await read(constansSp.moduleName, constansSp.spKeyUSDD);
    $data.fund.statusUSDT = await read(constansSp.moduleName, constansSp.spKeyUSDT);
    console.log(`requestFlexibleDetail statusUSDD= ${$data.fund.statusUSDD} statusUSDT= ${$data.fund.statusUSDT}`);
    console.log(`requestFlexibleDetail originCouponData= ${JSON.stringify(originCouponData)}`);
    handleTabData(data, originCouponData, isFirstTime, onlyRefreshApy);
}

function handleTabData(data, originCouponData, isFirstTime, onlyRefreshApy = false) {
    moduleData$1.currency = data.currency;
    moduleData$1.balanceText = `${removeExtraZeros(getPriceString(data.balanceAmount, 8))}`;
    moduleData$1.balance = data.balanceAmount;
    var eranTabData = [];
    var sliderData = [];
    var idx = 0;
    data.projects.forEach(((element, index) => {
        if (currentSelectIndex == -1 && parameter.projectId != undefined && parameter.projectId.includes(element.projectId)) {
            console.log(`simple_earn_home selected projectId= ${parameter.projectId} idx= ${idx}`);
            currentSelectIndex = idx;
        }
        if (element.productType == "0") {
            if (element.apyType == "0") {
                eranTabData.push({
                    type: "1",
                    tag: String(idx),
                    borderColor: idx == currentSelectIndex ? "@color/kColorMajorTheme100" : "@color/kColorEBEBEB",
                    tagVis: getTagVis(element.tag),
                    tagBg: getTagBg(element.tag),
                    tagText: getTagText(element.tag, element.tagName),
                    tagTextColor: getTagTextColor(element.tag),
                    tabWidth: getTagWidth(element.tag),
                    timeVis: "gone",
                    earnings: `${formatPrecision(multiply(element.apyShow, 100), 2)}%`,
                    cycle: $i18n.n_asset_earn_current
                });
                if (!onlyRefreshApy) {
                    var data = handleCurrentDetail(element, originCouponData);
                    data.index = idx;
                    data.type = "1";
                    console.log(`${idx} 固定活期 handleCurrentDetail : ${JSON.stringify(data)}`);
                    sliderData.push(data);
                }
                idx++;
            } else if (element.apyType == "1") {
                const curApy = `${formatPrecision(multiply(maxApy(element), 100), 2)}%`;
                if (onlyRefreshApy) {
                    const lastTab = moduleData$1.earnTabList[idx];
                    const lastApy = lastTab.earnings;
                    console.log(`simple_earn_home onlyRefreshApy lastApy= ${lastApy} curApy= ${curApy} onlyRefreshApy= ${onlyRefreshApy}`);
                    if (lastApy != curApy) {
                        const lastElement = moduleData$1.sliderData[idx];
                        lastElement.mMarketApyVo = element.marketApyVo;
                        refreshProfitOverview(lastElement.mSubInput, lastElement);
                        lastTab.earnings = curApy;
                    }
                    lastTab.apyCountdown = element.apyCountdown;
                    lastTab.timeText = formatDate(element.apyCountdown);
                }
                eranTabData.push({
                    type: "1",
                    tag: String(idx),
                    borderColor: idx == currentSelectIndex ? "@color/kColorMajorTheme100" : "@color/kColorEBEBEB",
                    tagVis: getTagVis(element.tag),
                    tagBg: getTagBg(element.tag),
                    tagText: getTagText(element.tag, element.tagName),
                    tagTextColor: getTagTextColor(element.tag),
                    tabWidth: getTagWidth(element.tag),
                    timeVis: "visible",
                    timeIcon: "@drawable/edge_engine_count_down",
                    productType: element.productType,
                    apyType: element.apyType,
                    apyCountdown: element.apyCountdown,
                    timeText: formatDate(element.apyCountdown),
                    earnings: curApy,
                    cycle: $i18n.n_asset_earn_current
                });
                if (!onlyRefreshApy) {
                    var data = handleCurrentDetail(element, originCouponData);
                    data.index = idx;
                    data.type = "1";
                    console.log(`${idx} 市场化活期 handleCurrentDetail : ${JSON.stringify(data)}`);
                    sliderData.push(data);
                }
                startCurrentCountDown();
                idx++;
            }
        } else if (element.productType == "1") {
            if (element.fixedType == "0" || element.fixedType == "2") {
                eranTabData.push({
                    type: "1",
                    tag: String(idx),
                    borderColor: idx == currentSelectIndex ? "@color/kColorMajorTheme100" : "@color/kColorEBEBEB",
                    tagVis: getTagVis(element.tag),
                    tagBg: getTagBg(element.tag),
                    tagText: getTagText(element.tag, element.tagName),
                    tagTextColor: getTagTextColor(element.tag),
                    tabWidth: getTagWidth(element.tag),
                    timeVis: "gone",
                    earnings: `${formatPrecision(multiply(element.apyShow, 100), 2)}%`,
                    cycle: `${element.term} ${$i18n.n_mining_day_text}`
                });
                if (!onlyRefreshApy) {
                    var itemData = handleFlexibleDetail(element, originCouponData);
                    itemData.index = idx;
                    itemData.type = "2";
                    console.log(`${idx} 普通定期  handleFlexibleDetail : ${JSON.stringify(itemData)}`);
                    sliderData.push(itemData);
                }
                idx++;
            } else if (element.fixedType == "1") {
                eranTabData.push({
                    type: "1",
                    tag: String(idx),
                    borderColor: idx == currentSelectIndex ? "@color/kColorMajorTheme100" : "@color/kColorEBEBEB",
                    tagVis: getTagVis(element.tag),
                    tagBg: getTagBg(element.tag),
                    tagText: getTagText(element.tag, element.tagName),
                    tagTextColor: getTagTextColor(element.tag),
                    tabWidth: getTagWidth(element.tag),
                    timeVis: "gone",
                    earnings: `${formatPrecision(multiply(element.apyShow, 100), 2)}%`,
                    cycle: `${element.term} ${$i18n.n_mining_day_text}`
                });
                if (!onlyRefreshApy) {
                    var itemData = handleFlexibleDetail(element, originCouponData);
                    itemData.index = idx;
                    itemData.type = "2";
                    console.log(`${idx} 新手专享  handleFlexibleDetail : ${JSON.stringify(itemData)}`);
                    sliderData.push(itemData);
                }
                idx++;
            }
        }
    }));
    console.log(`${idx} handleTabData sliderData : ${JSON.stringify(sliderData)}`);
    console.log(`${idx} handleTabData eranTabData : ${JSON.stringify(eranTabData)}`);
    earnTabList = eranTabData;
    if (currentSelectIndex == -1) {
        moduleData$1.currentIndex = 0;
        earnTabList[0].borderColor = "@color/kColorMajorTheme100";
    } else {
        moduleData$1.currentIndex = currentSelectIndex;
    }
    if (!onlyRefreshApy) {
        moduleData$1.sliderData = sliderData;
        moduleData$1.earnTabList = earnTabList;
    }
    let element = moduleEvent$1.getCurrentElement(moduleData$1.currentIndex);
    $event.deposit.checkBtnStatus(element.status, element.inputStatus);
    moduleData$1.dataVis = "visible";
    pageShow(moduleData$1.sliderData[moduleData$1.currentIndex], Date.now() - onResumeTime, isFirstTime);
    earnPurchaseLoadStatus("success");
    checkUsddPurchaseTip(element);
}

function getTagVis(tag) {
    if (tag == 6 || tag == 9) {
        return "visible";
    } else {
        return "gone";
    }
}

function getTagBg(tag) {
    if (tag == 6) {
        return "@color/kColorFFE7D5";
    } else if (tag == 9) {
        return "@color/kColor1A0173E5";
    } else {
        return null;
    }
}

function getTagText(tag, tagName) {
    if (tag == 6) {
        return $i18n.n_simple_earn_newcomer;
    } else {
        return tagName;
    }
}

function getTagTextColor(tag) {
    if (tag == "6") {
        return "@color/color_FE8731";
    } else if (tag == "9") {
        return "@color/kColorMajorTheme100";
    } else {
        return "@color/color_FE8731";
    }
}

function getTagWidth(tag) {
    if (tag == "9") {
        return 117;
    } else {
        return 102;
    }
}

function maxApy(element) {
    try {
        if (element.marketApyVo.marketPerkApy == null || element.marketApyVo.marketPerkApy == undefined) {
            return element.apyShow;
        } else {
            return Math.max(parseFloat(element.marketApyVo.marketPerkApy), parseFloat(element.apyShow));
        }
    } catch (e) {
        console.e(e);
        return "0";
    }
}

function startCurrentCountDown() {
    clearTimer();
    intercal = setInterval(changeCountdown, 1e3);
}

function changeCountdown() {
    for (let i = 0; i < earnTabList.length; i++) {
        let element = earnTabList[i];
        if (element.productType == "0" && element.apyType == "1") {
            let apyCountdown = element.apyCountdown - currentCount * 1e3;
            currentCount = currentCount + 1;
            if (apyCountdown >= 1e3) {
                moduleData$1.earnTabList[i].timeText = formatDate(apyCountdown);
                earnTabList[i].timeText = formatDate(apyCountdown);
            } else {
                clearTimer();
                requestFlexibleDetail(false, true);
            }
        }
    }
}

function formatDate(timestamp) {
    const date = new Date(timestamp);
    const minutes = ("0" + date.getMinutes()).slice(-2);
    const seconds = ("0" + date.getSeconds()).slice(-2);
    if (timestamp < 1e3 * 60) {
        return `${seconds}`;
    } else {
        return `${minutes}:${seconds}`;
    }
}

function clearTimer() {
    if (intercal != null) {
        clearInterval(intercal);
        intercal = null;
        currentCount = 1;
    }
}

moduleEvent$1.scrollToTag = function(tag) {
    console.log(`simple_earn_home scrollToTag tag= ${tag}`);
    if (tag == moduleData$1.currentIndex) {
        return;
    }
    moduleData$1.currentIndex = tag;
    moduleData$1.scrollToTag = tag;
};

moduleEvent$1.bannerIndexChange = function(params) {
    console.log(`simple_earn_home bannerIndexChange params= ${params} currentIndex= ${moduleData$1.currentIndex}`);
    if (earnTabList.length == 0) {
        return;
    }
    earnTabList.forEach((tab => {
        if (tab.tag == params) {
            tab.borderColor = "@color/kColorMajorTheme100";
        } else {
            tab.borderColor = "@color/kColorEBEBEB";
        }
    }));
    moduleData$1.earnTabList = earnTabList;
    moduleData$1.scrollToTag = params;
    currentSelectIndex = params;
    let element = moduleData$1.sliderData[params];
    $event.deposit.checkBtnStatus(element.status, element.inputStatus);
    pageShow(element, 0, false);
    checkUsddPurchaseTip(element);
};

function getNavConfigString() {
    return {};
}

async function checkUsddPurchaseTip(element) {
    if (parameter.currency == "USDD" && element.productType == "0") {
        let didShow = await read("simple_earn", "didShow");
        if (didShow != "1") {
            await save("simple_earn", "didShow", "1");
            $event.purchaseTip.openDialog();
        }
    }
}

moduleEvent$1.backClicked = function() {
    backClick();
    containerBack();
};

moduleEvent$1.getCurrentElement = function(index) {
    if (index < 0 || index >= moduleData$1.sliderData.length) {
        console.log(`getCurrentElement error index= ${index}`);
        return {};
    }
    return moduleData$1.sliderData[index];
};

moduleEvent$1.buyCoin = function() {
    let buyCoinObj = {
        type: 2,
        currency: $data.home.currency
    };
    console.log(`buyCoin : ${JSON.stringify(buyCoinObj)}`);
    $nativeAPI.doubleCoinAbility(JSON.stringify(buyCoinObj));
    let element = moduleEvent$1.getCurrentElement(moduleData$1.currentIndex);
    buyClick(element);
    $data.home.isRefreshData = true;
};

moduleEvent$1.transfer = function() {
    let transferObj = {
        type: 20,
        currency: $data.home.currency
    };
    console.log(`transfer : ${JSON.stringify(transferObj)}`);
    $nativeAPI.jump(JSON.stringify(transferObj));
    let element = moduleEvent$1.getCurrentElement(moduleData$1.currentIndex);
    transferClick(element);
    $data.home.isRefreshData = true;
};

moduleEvent$1.reloadWithParams = function(jsonParameters) {
    console.log(`reloadWithParams : ${jsonParameters}`);
    parameter = JSON.parse(jsonParameters);
    moduleData$1.topIcon = getPNGIconURLByCurrency(parameter.currency);
    moduleData$1.topTitle = `${parameter.currency} ${$i18n.n_kline_detail_earncoins}`;
    clearTimer();
    moduleData$1.dataVis = "gone";
    resumeIsNotFirst = false;
    currentSelectIndex = -1, moduleData$1.sliderData = [];
    moduleData$1.earnTabList = [];
    earnTabList = [];
    requestFlexibleDetail(true);
};

var btnEnable = false;

function defaultData() {
    return {
        btnColor: "@color/kColorEBEBEB",
        btnTitleColor: "@color/kColorThreeLevelText",
        huobiSelected: false,
        huobiAgreeImage: "@drawable/edge_engine_live_redpacket_unselect",
        richTextData: ""
    };
}

const {moduleData: moduleData, moduleEvent: moduleEvent} = moduleDefine("deposit", defaultData, {});

moduleEvent.huobiSelected = function() {
    if (moduleData.huobiSelected) {
        moduleData.huobiSelected = false;
        moduleData.huobiAgreeImage = "@drawable/edge_engine_live_redpacket_unselect";
        moduleData.confirmBtnColor = "@color/eButtonUnenabledBgColor";
    } else {
        moduleData.huobiSelected = true;
        moduleData.huobiAgreeImage = "@drawable/edge_engine_live_redpacket_select";
        moduleData.confirmBtnColor = "@color/kColorMajorTheme100";
    }
    let element = $event.home.getCurrentElement($data.home.currentIndex);
    console.log(`${tag} huobiSelected inputStatus= ${element.inputStatus}`);
    checkBtnStatus(element.status, element.inputStatus);
};

function checkBtnStatus(projectStatus, inputStatus = false) {
    console.log(`${tag} checkBtnStatus projectStatus= ${projectStatus} inputStatus= ${inputStatus}`);
    switch (projectStatus) {
      case 0:
        $data.home.submitText = $i18n.n_simple_earn_not_started;
        break;

      case 1:
        $data.home.submitText = $i18n.n_balance_mining_deposit;
        break;

      case 2:
        $data.home.submitText = $i18n.n_simple_earn_fully_subscribed;
        break;

      case 3:
        $data.home.submitText = $i18n.n_simple_earn_ended;
        break;
    }
    if (projectStatus == 1 && inputStatus && moduleData.huobiSelected) {
        btnEnable = true;
        moduleData.btnColor = "@color/kColorMajorTheme100";
        moduleData.btnTitleColor = "@color/KBaseTextColor";
        return true;
    } else {
        btnEnable = false;
        moduleData.btnColor = "@color/kColorEBEBEB";
        moduleData.btnTitleColor = "@color/kColorThreeLevelText";
        return false;
    }
}

moduleEvent.submitClicked = function() {
    if (!btnEnable) {
        return;
    }
    let element = $event.home.getCurrentElement($data.home.currentIndex);
    element.subOnFocus = false;
    let confirmList = null;
    let innerList = null;
    if (element.productType == 0) {
        innerList = getFlexibleConfirmInnerList(element);
        confirmList = getFlexibleConfirmList(innerList, element.mSubInput);
    } else if (element.productType == 1) {
        innerList = getFixedConfirmInnerList(element);
        confirmList = getFixedConfirmList(innerList, element.mSubInput, element);
    } else {
        console.log("submit error type ", element.productType);
    }
    $event.dialog.showConfirmDialog(confirmList, innerList, element);
    subscribeButtonClick(element);
};

moduleEvent.confirmDialogBlock = async function(assetSource) {
    let parseSource = parseInt(assetSource);
    console.log(`${tag} confirmDialogBlock crrentIndex= ${$data.home.currentIndex} assetSource = ${parseSource}`);
    let element = $event.home.getCurrentElement($data.home.currentIndex);
    confirmButtonClick(element);
    let autoEarn = getAutoEarnStatus(element);
    console.log(`${tag} confirmDialogBlock autoEarn= ${autoEarn}`);
    let {couponId: couponId, couponSign: couponSign} = getCouponStatus(element);
    const addParams = {
        vToken: commonData.vToken,
        oldVToken: commonData.oldVToken,
        id: element.projectId,
        amount: element.mSubInput,
        balanceAutoDiggingStatus: autoEarn,
        couponId: couponId,
        couponSign: couponSign,
        amtSource: parseSource
    };
    console.log(`${tag} confirmDialogBlock crrentIndex= ${JSON.stringify(addParams)}`);
    showLoading(true);
    const data = await orderAddRequest("v1/saving/mining/order/demand/add", addParams, 1, 0, {
        "Content-Type": "application/json"
    });
    showLoading(false);
    if (data != null) {
        let resultStr = `${data.amount} ${$data.home.currency}`;
        let url = `holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/edgeengine/container?scene=simpleearn&rootName=result&navConfig=&resultStr=${resultStr}&orderId=${data.orderId}&recordId=${data.recordId}&productType=${element.productType}&apyType=${element.apyType}`;
        openURL(url);
        $event.dialog.closeConfirmDialog();
        $data.home.isRefreshData = true;
    }
};

async function orderAddRequest(path, params = {}, method = 0, hostType = 0, header = {}) {
    console.log(`orderAddRequest${path}, params:${JSON.stringify(params)}`);
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
        if (code == 200 || response.status == "ok") {
            console.log(`orderAddRequest ${path} done`);
            return data;
        } else if (code == 40002) {
            $event.kycDialog.openKycFailedDialog();
        } else if (code == 40020) {
            let element = $event.home.getCurrentElement($data.home.currentIndex);
            $event.kycDialog.openKycLevelDialog(element.kycLimitUserViewLevel ? element.kycLimitUserViewLevel : "");
        } else {
            console.log(`orderAddRequest failed, code=${code}`);
            let message = response.message;
            if (method != 0 && message) {
                showToast(message);
            }
            return null;
        }
    } catch (e) {
        console.log(`orderAddRequest error, error=${e}`);
        return null;
    }
}

moduleEvent.checkBtnStatus = checkBtnStatus;

const tag = "simple_earn";

function getFlexibleConfirmInnerList(element) {
    let innerList = [];
    let mSubInput = parseFloat(element.mSubInput);
    let apyType = element.apyType;
    console.log(`${tag} getFlexibleConfirmInnerList apyType= ${apyType}`);
    if (apyType == 0) {
        let ladderList = element.ladderList;
        console.log(`${tag} getFlexibleConfirmInnerList ladderList= ${JSON.stringify(ladderList)}`);
        let item = {};
        ladderList.forEach((ladder => {
            if (ladder.type != 1) {
                return;
            }
            item = {
                type: "1"
            };
            let amount = 0;
            if (mSubInput >= ladder.amountStart) {
                if (ladder.amountEnd == 0) {
                    amount = mSubInput - ladder.amountStart;
                } else if (mSubInput >= ladder.amountEnd) {
                    amount = ladder.amountEnd - ladder.amountStart;
                } else {
                    amount = mSubInput - ladder.amountStart;
                }
            } else {
                amount = 0;
            }
            console.log(`${tag} getFlexibleConfirmInnerList ladderList amount= ${amount}`);
            if (amount > 0) {
                item.amount = `${amount} ${$data.home.currency}`;
                item.rate = `APY ${formatPrecision(multiply(ladder.rate, 100), 2)}%`;
                console.log(`${tag} getFlexibleConfirmInnerList ladderList item= ${JSON.stringify(item)}`);
                innerList.push(item);
            }
        }));
    } else if (apyType == 1) {
        let profitList = element.profitList;
        console.log(`${tag} getFlexibleConfirmInnerList profitList= ${JSON.stringify(profitList)}`);
        let item = {};
        profitList.forEach((profit => {
            if (profit.type != 1) {
                return;
            }
            item = {
                type: "1"
            };
            if (profit.perkVis == "visible") {
                item.rate = $i18n.$intercept.n_simple_earn_perk_apy(`${profit.rate}`);
            } else {
                item.rate = `APY ${profit.rate}`;
            }
            item.amount = profit.title;
            console.log(`${tag} getFlexibleConfirmInnerList profitList item= ${JSON.stringify(item)}`);
            innerList.push(item);
        }));
    } else {
        console.log(`${tag} getFlexibleConfirmInnerList error ${apyType} need handle`);
    }
    let couponIndex = element.couponListData.couponIndex;
    console.log(`${tag} getFlexibleConfirmInnerList mSubInput= ${mSubInput} couponIndex= ${couponIndex}`);
    if (couponIndex != undefined && couponIndex != -1) {
        let couponList = element.couponListData.items;
        let couponItem = couponList[couponIndex];
        console.log(`${tag} 加息券 couponItem= ${couponItem.couponDownLimit}～${couponItem.couponUpLimit} ${couponItem.apy}`);
        if (mSubInput >= couponItem.couponDownLimit) {
            let amountNum = Math.min(couponItem.couponUpLimit, mSubInput);
            let curIndex = 0;
            while (amountNum > 0 && curIndex < innerList.length) {
                let item = {
                    type: "2"
                };
                let curAmount = convertNumber(innerList[curIndex].amount, false);
                if (amountNum > curAmount) {
                    item.amount = `${removeExtraZeros(formatPrecision(curAmount, 8))} ${$data.home.currency}`;
                    amountNum -= curAmount;
                } else {
                    item.amount = `${removeExtraZeros(formatPrecision(amountNum, 8))} ${$data.home.currency}`;
                    amountNum -= amountNum;
                }
                item.rate = adapterPercentFlag($i18n.$intercept.n_simple_earn_coupon_confirm(`${couponItem.couponTerm}`, `${formatPrecision(multiply(couponItem.apy, 100), 2)}`));
                console.log(`${tag} 加息券 ${JSON.stringify(item)}`);
                innerList.splice(curIndex + 1, 0, item);
                curIndex += 2;
            }
        }
    }
    console.log(`${tag} getFlexibleConfirmInnerList innerList= ${JSON.stringify(innerList)}`);
    return innerList;
}

function getFixedConfirmInnerList(element) {
    let innerList = [];
    let mSubInput = parseFloat(element.mSubInput);
    let couponIndex = element.couponListData.couponIndex;
    console.log(`${tag} getFixedConfirmInnerList mSubInput= ${mSubInput} couponIndex= ${couponIndex}`);
    let item = {
        type: "1"
    };
    item.amount = `${removeExtraZeros(formatPrecision(mSubInput, 8))} ${$data.home.currency}`;
    item.rate = `APY ${formatPrecision(multiply(element.yearRate, 100), 2)}%`;
    console.log(`${tag} getFixedConfirmInnerList item1= ${JSON.stringify(item)}`);
    innerList.push(item);
    if (couponIndex != undefined && couponIndex != -1) {
        let couponList = element.couponListData.items;
        let couponItem = couponList[couponIndex];
        console.log(`${tag} getFixedConfirmInnerList couponItem= ${couponItem.couponUpLimit} ${couponItem.apy}`);
        if (mSubInput >= couponItem.couponDownLimit) {
            item = {
                type: "2"
            };
            let amountNum = Math.min(couponItem.couponUpLimit, mSubInput);
            item.amount = `${removeExtraZeros(formatPrecision(amountNum, 8))} ${$data.home.currency}`;
            item.rate = adapterPercentFlag($i18n.$intercept.n_simple_earn_coupon_confirm(`${couponItem.couponTerm}`, `${formatPrecision(multiply(couponItem.apy, 100), 2)}`));
            console.log(`${tag} getFixedConfirmInnerList item= ${JSON.stringify(item)}`);
            innerList.splice(1, 0, item);
        }
    }
    return innerList;
}

function getFlexibleConfirmList(innerList, mSubInput) {
    let apy = getComprehensiveApy(innerList, mSubInput);
    let confirmList = [ {
        type: "normal",
        title: $i18n.n_mining_ransom_way,
        value: $i18n.n_simple_earn_redeem_any_time
    }, {
        type: "normal",
        title: $i18n.n_simple_earn_composite_apy,
        value: `${apy}`
    } ];
    return confirmList;
}

function getFixedConfirmList(innerList, mSubInput, element) {
    let apy = getComprehensiveApy(innerList, mSubInput);
    const expireDate = $i18n.$intercept.n_simple_earn_become_due(`${element.term}`, `${element.dtExpired}`);
    let confirmList = [ {
        type: "normal",
        title: $i18n.n_mining_duration,
        value: expireDate
    }, {
        type: "normal",
        title: $i18n.n_mining_ransom_way,
        value: $i18n.n_simple_earn_redeem_expiration
    }, {
        type: "normal",
        title: $i18n.n_simple_earn_composite_apy,
        value: `${apy}`
    } ];
    return confirmList;
}

function getComprehensiveApy(innerList, mSubInput) {
    let comprehensiveApy = 0;
    if (innerList.length == 1) {
        let rateOri = convertNumber2(innerList[0].rate, true);
        let rateFormat = `${formatPrecision(multiply(rateOri, 100), 2)}%`;
        console.log(`${tag} getComprehensiveApy rateFormat= ${rateFormat}`);
        comprehensiveApy = rateFormat;
        return comprehensiveApy;
    }
    innerList.forEach((item => {
        let num = convertNumber(item.amount, false) * convertNumber2(item.rate, true);
        console.log(`${tag} getComprehensiveApy num= ${num}`);
        comprehensiveApy += num;
    }));
    let apy = comprehensiveApy / parseFloat(mSubInput);
    console.log(`${tag} getComprehensiveApy apy= ${apy}`);
    return `${formatPrecision(multiply(apy, 100), 2)}%`;
}

function convertNumber(str, isPercent) {
    let num = parseFloat(str.match(/[\d.]+/)[0]);
    if (isPercent == true) {
        num = num / 100;
    }
    console.log(`${tag} convertNumber1 num= ${num}`);
    return num;
}

function convertNumber2(str, isPercent) {
    let num = parseFloat(str.match(/(\d+(\.\d+)?)%/)[0]);
    if (isPercent == true) {
        num = num / 100;
    }
    console.log(`${tag} convertNumber2 num= ${num}`);
    return num;
}

function getAutoEarnStatus(element) {
    if (element.productType == 0) {
        return element.autoEarn;
    } else {
        return 0;
    }
}

function getCouponStatus(element) {
    let result = {
        couponId: "",
        couponSign: ""
    };
    if (element.productType == 0 || element.productType == 1) {
        let couponListData = element.couponListData;
        let index = couponListData.couponIndex;
        if (index >= 0) {
            let item = couponListData.items[index];
            console.log(`${tag} getCouponStatus item= ${item.id} ${item.couponSign} mSubInput= ${element.mSubInput} couponDownLimit= ${item.couponDownLimit}`);
            if (element.mSubInput >= item.couponDownLimit) {
                result.couponId = item.id;
                result.couponSign = item.couponSign;
            }
        }
    }
    console.log(`${tag} getCouponStatus result= ${JSON.stringify(result)}`);
    return result;
}

$data.kycDialog = {
    isShow: false,
    tipTitle: $i18n.n_otc_use_tip,
    tipContent: $i18n.n_simple_earn_kyc_failed
};

$event.kycDialog = {
    openKycFailedDialog: function() {
        $data.kycDialog.tipContent = $i18n.n_simple_earn_kyc_failed;
        $data.kycDialog.isShow = true;
    },
    openKycLevelDialog: function(level = "") {
        $data.kycDialog.tipContent = $i18n.$intercept.n_simple_earn_kyc_level(level);
        $data.kycDialog.isShow = true;
    },
    closeDialog: function() {
        $data.kycDialog.isShow = false;
    },
    gotoKycAuth: function() {
        $data.kycDialog.isShow = false;
        $event.dialog.closeConfirmDialog();
        openURL("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/account/kyc?authBizCode=SPOT&source=0");
    }
};

function sendCommonConfig(param) {
    getCommonConfig(param);
}

$event.sendCommonConfig = sendCommonConfig;
//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoibWFpbi5qcyIsInNvdXJjZXMiOlsiLi4vLi4vcmVwb3NpdG9yeS9ub2RlX21vZHVsZXMvYmlnLmpzL2JpZy5tanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9udW1iZXIuanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9jb21tb24uanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9jb3Vwb25MaXN0RGlhbG9nLmpzIiwiLi4vLi4vcmVwb3NpdG9yeS9zcmMvYW5hbHl0aWNzLmpzIiwiLi4vLi4vcmVwb3NpdG9yeS9zcmMvZml4ZWQuanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9kaWFsb2cuanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9yZXN1bHQuanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9yZWNlaXB0RGlhbG9nLmpzIiwiLi4vLi4vcmVwb3NpdG9yeS9zcmMvYXV0b0Vhcm5EaWFsb2cuanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9wdXJjaGFzZVRpcERpYWxvZy5qcyIsIi4uLy4uL3JlcG9zaXRvcnkvc3JjL2xhZGRlckRpYWxvZy5qcyIsIi4uLy4uL3JlcG9zaXRvcnkvc3JjL3Byb2ZpdE92ZXJ2aWV3RGlhbG9nLmpzIiwiLi4vLi4vcmVwb3NpdG9yeS9zcmMvY291cG9uRGlhbG9nLmpzIiwiLi4vLi4vcmVwb3NpdG9yeS9zcmMvZnVuZERpYWxvZy5qcyIsIi4uLy4uL3JlcG9zaXRvcnkvc3JjL2ZsZXhpYmxlLmpzIiwiLi4vLi4vcmVwb3NpdG9yeS9zcmMvaG9tZS5qcyIsIi4uLy4uL3JlcG9zaXRvcnkvc3JjL2RlcG9zaXQuanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9reWNEaWFsb2cuanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9tYWluLmpzIl0sInNvdXJjZXNDb250ZW50IjpbIi8qXHJcbiAqICBiaWcuanMgdjUuMi4yXHJcbiAqICBBIHNtYWxsLCBmYXN0LCBlYXN5LXRvLXVzZSBsaWJyYXJ5IGZvciBhcmJpdHJhcnktcHJlY2lzaW9uIGRlY2ltYWwgYXJpdGhtZXRpYy5cclxuICogIENvcHlyaWdodCAoYykgMjAxOCBNaWNoYWVsIE1jbGF1Z2hsaW4gPE04Y2g4OGxAZ21haWwuY29tPlxyXG4gKiAgaHR0cHM6Ly9naXRodWIuY29tL01pa2VNY2wvYmlnLmpzL0xJQ0VOQ0VcclxuICovXHJcblxyXG5cclxuLyoqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqIEVESVRBQkxFIERFRkFVTFRTICoqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqL1xyXG5cclxuXHJcbiAgLy8gVGhlIGRlZmF1bHQgdmFsdWVzIGJlbG93IG11c3QgYmUgaW50ZWdlcnMgd2l0aGluIHRoZSBzdGF0ZWQgcmFuZ2VzLlxyXG5cclxuICAvKlxyXG4gICAqIFRoZSBtYXhpbXVtIG51bWJlciBvZiBkZWNpbWFsIHBsYWNlcyAoRFApIG9mIHRoZSByZXN1bHRzIG9mIG9wZXJhdGlvbnMgaW52b2x2aW5nIGRpdmlzaW9uOlxyXG4gICAqIGRpdiBhbmQgc3FydCwgYW5kIHBvdyB3aXRoIG5lZ2F0aXZlIGV4cG9uZW50cy5cclxuICAgKi9cclxudmFyIERQID0gMjAsICAgICAgICAgIC8vIDAgdG8gTUFYX0RQXHJcblxyXG4gIC8qXHJcbiAgICogVGhlIHJvdW5kaW5nIG1vZGUgKFJNKSB1c2VkIHdoZW4gcm91bmRpbmcgdG8gdGhlIGFib3ZlIGRlY2ltYWwgcGxhY2VzLlxyXG4gICAqXHJcbiAgICogIDAgIFRvd2FyZHMgemVybyAoaS5lLiB0cnVuY2F0ZSwgbm8gcm91bmRpbmcpLiAgICAgICAoUk9VTkRfRE9XTilcclxuICAgKiAgMSAgVG8gbmVhcmVzdCBuZWlnaGJvdXIuIElmIGVxdWlkaXN0YW50LCByb3VuZCB1cC4gIChST1VORF9IQUxGX1VQKVxyXG4gICAqICAyICBUbyBuZWFyZXN0IG5laWdoYm91ci4gSWYgZXF1aWRpc3RhbnQsIHRvIGV2ZW4uICAgKFJPVU5EX0hBTEZfRVZFTilcclxuICAgKiAgMyAgQXdheSBmcm9tIHplcm8uICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIChST1VORF9VUClcclxuICAgKi9cclxuICBSTSA9IDEsICAgICAgICAgICAgIC8vIDAsIDEsIDIgb3IgM1xyXG5cclxuICAvLyBUaGUgbWF4aW11bSB2YWx1ZSBvZiBEUCBhbmQgQmlnLkRQLlxyXG4gIE1BWF9EUCA9IDFFNiwgICAgICAgLy8gMCB0byAxMDAwMDAwXHJcblxyXG4gIC8vIFRoZSBtYXhpbXVtIG1hZ25pdHVkZSBvZiB0aGUgZXhwb25lbnQgYXJndW1lbnQgdG8gdGhlIHBvdyBtZXRob2QuXHJcbiAgTUFYX1BPV0VSID0gMUU2LCAgICAvLyAxIHRvIDEwMDAwMDBcclxuXHJcbiAgLypcclxuICAgKiBUaGUgbmVnYXRpdmUgZXhwb25lbnQgKE5FKSBhdCBhbmQgYmVuZWF0aCB3aGljaCB0b1N0cmluZyByZXR1cm5zIGV4cG9uZW50aWFsIG5vdGF0aW9uLlxyXG4gICAqIChKYXZhU2NyaXB0IG51bWJlcnM6IC03KVxyXG4gICAqIC0xMDAwMDAwIGlzIHRoZSBtaW5pbXVtIHJlY29tbWVuZGVkIGV4cG9uZW50IHZhbHVlIG9mIGEgQmlnLlxyXG4gICAqL1xyXG4gIE5FID0gLTcsICAgICAgICAgICAgLy8gMCB0byAtMTAwMDAwMFxyXG5cclxuICAvKlxyXG4gICAqIFRoZSBwb3NpdGl2ZSBleHBvbmVudCAoUEUpIGF0IGFuZCBhYm92ZSB3aGljaCB0b1N0cmluZyByZXR1cm5zIGV4cG9uZW50aWFsIG5vdGF0aW9uLlxyXG4gICAqIChKYXZhU2NyaXB0IG51bWJlcnM6IDIxKVxyXG4gICAqIDEwMDAwMDAgaXMgdGhlIG1heGltdW0gcmVjb21tZW5kZWQgZXhwb25lbnQgdmFsdWUgb2YgYSBCaWcuXHJcbiAgICogKFRoaXMgbGltaXQgaXMgbm90IGVuZm9yY2VkIG9yIGNoZWNrZWQuKVxyXG4gICAqL1xyXG4gIFBFID0gMjEsICAgICAgICAgICAgLy8gMCB0byAxMDAwMDAwXHJcblxyXG5cclxuLyoqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqL1xyXG5cclxuXHJcbiAgLy8gRXJyb3IgbWVzc2FnZXMuXHJcbiAgTkFNRSA9ICdbYmlnLmpzXSAnLFxyXG4gIElOVkFMSUQgPSBOQU1FICsgJ0ludmFsaWQgJyxcclxuICBJTlZBTElEX0RQID0gSU5WQUxJRCArICdkZWNpbWFsIHBsYWNlcycsXHJcbiAgSU5WQUxJRF9STSA9IElOVkFMSUQgKyAncm91bmRpbmcgbW9kZScsXHJcbiAgRElWX0JZX1pFUk8gPSBOQU1FICsgJ0RpdmlzaW9uIGJ5IHplcm8nLFxyXG5cclxuICAvLyBUaGUgc2hhcmVkIHByb3RvdHlwZSBvYmplY3QuXHJcbiAgUCA9IHt9LFxyXG4gIFVOREVGSU5FRCA9IHZvaWQgMCxcclxuICBOVU1FUklDID0gL14tPyhcXGQrKFxcLlxcZCopP3xcXC5cXGQrKShlWystXT9cXGQrKT8kL2k7XHJcblxyXG5cclxuLypcclxuICogQ3JlYXRlIGFuZCByZXR1cm4gYSBCaWcgY29uc3RydWN0b3IuXHJcbiAqXHJcbiAqL1xyXG5mdW5jdGlvbiBfQmlnXygpIHtcclxuXHJcbiAgLypcclxuICAgKiBUaGUgQmlnIGNvbnN0cnVjdG9yIGFuZCBleHBvcnRlZCBmdW5jdGlvbi5cclxuICAgKiBDcmVhdGUgYW5kIHJldHVybiBhIG5ldyBpbnN0YW5jZSBvZiBhIEJpZyBudW1iZXIgb2JqZWN0LlxyXG4gICAqXHJcbiAgICogbiB7bnVtYmVyfHN0cmluZ3xCaWd9IEEgbnVtZXJpYyB2YWx1ZS5cclxuICAgKi9cclxuICBmdW5jdGlvbiBCaWcobikge1xyXG4gICAgdmFyIHggPSB0aGlzO1xyXG5cclxuICAgIC8vIEVuYWJsZSBjb25zdHJ1Y3RvciB1c2FnZSB3aXRob3V0IG5ldy5cclxuICAgIGlmICghKHggaW5zdGFuY2VvZiBCaWcpKSByZXR1cm4gbiA9PT0gVU5ERUZJTkVEID8gX0JpZ18oKSA6IG5ldyBCaWcobik7XHJcblxyXG4gICAgLy8gRHVwbGljYXRlLlxyXG4gICAgaWYgKG4gaW5zdGFuY2VvZiBCaWcpIHtcclxuICAgICAgeC5zID0gbi5zO1xyXG4gICAgICB4LmUgPSBuLmU7XHJcbiAgICAgIHguYyA9IG4uYy5zbGljZSgpO1xyXG4gICAgfSBlbHNlIHtcclxuICAgICAgcGFyc2UoeCwgbik7XHJcbiAgICB9XHJcblxyXG4gICAgLypcclxuICAgICAqIFJldGFpbiBhIHJlZmVyZW5jZSB0byB0aGlzIEJpZyBjb25zdHJ1Y3RvciwgYW5kIHNoYWRvdyBCaWcucHJvdG90eXBlLmNvbnN0cnVjdG9yIHdoaWNoXHJcbiAgICAgKiBwb2ludHMgdG8gT2JqZWN0LlxyXG4gICAgICovXHJcbiAgICB4LmNvbnN0cnVjdG9yID0gQmlnO1xyXG4gIH1cclxuXHJcbiAgQmlnLnByb3RvdHlwZSA9IFA7XHJcbiAgQmlnLkRQID0gRFA7XHJcbiAgQmlnLlJNID0gUk07XHJcbiAgQmlnLk5FID0gTkU7XHJcbiAgQmlnLlBFID0gUEU7XHJcbiAgQmlnLnZlcnNpb24gPSAnNS4yLjInO1xyXG5cclxuICByZXR1cm4gQmlnO1xyXG59XHJcblxyXG5cclxuLypcclxuICogUGFyc2UgdGhlIG51bWJlciBvciBzdHJpbmcgdmFsdWUgcGFzc2VkIHRvIGEgQmlnIGNvbnN0cnVjdG9yLlxyXG4gKlxyXG4gKiB4IHtCaWd9IEEgQmlnIG51bWJlciBpbnN0YW5jZS5cclxuICogbiB7bnVtYmVyfHN0cmluZ30gQSBudW1lcmljIHZhbHVlLlxyXG4gKi9cclxuZnVuY3Rpb24gcGFyc2UoeCwgbikge1xyXG4gIHZhciBlLCBpLCBubDtcclxuXHJcbiAgLy8gTWludXMgemVybz9cclxuICBpZiAobiA9PT0gMCAmJiAxIC8gbiA8IDApIG4gPSAnLTAnO1xyXG4gIGVsc2UgaWYgKCFOVU1FUklDLnRlc3QobiArPSAnJykpIHRocm93IEVycm9yKElOVkFMSUQgKyAnbnVtYmVyJyk7XHJcblxyXG4gIC8vIERldGVybWluZSBzaWduLlxyXG4gIHgucyA9IG4uY2hhckF0KDApID09ICctJyA/IChuID0gbi5zbGljZSgxKSwgLTEpIDogMTtcclxuXHJcbiAgLy8gRGVjaW1hbCBwb2ludD9cclxuICBpZiAoKGUgPSBuLmluZGV4T2YoJy4nKSkgPiAtMSkgbiA9IG4ucmVwbGFjZSgnLicsICcnKTtcclxuXHJcbiAgLy8gRXhwb25lbnRpYWwgZm9ybT9cclxuICBpZiAoKGkgPSBuLnNlYXJjaCgvZS9pKSkgPiAwKSB7XHJcblxyXG4gICAgLy8gRGV0ZXJtaW5lIGV4cG9uZW50LlxyXG4gICAgaWYgKGUgPCAwKSBlID0gaTtcclxuICAgIGUgKz0gK24uc2xpY2UoaSArIDEpO1xyXG4gICAgbiA9IG4uc3Vic3RyaW5nKDAsIGkpO1xyXG4gIH0gZWxzZSBpZiAoZSA8IDApIHtcclxuXHJcbiAgICAvLyBJbnRlZ2VyLlxyXG4gICAgZSA9IG4ubGVuZ3RoO1xyXG4gIH1cclxuXHJcbiAgbmwgPSBuLmxlbmd0aDtcclxuXHJcbiAgLy8gRGV0ZXJtaW5lIGxlYWRpbmcgemVyb3MuXHJcbiAgZm9yIChpID0gMDsgaSA8IG5sICYmIG4uY2hhckF0KGkpID09ICcwJzspICsraTtcclxuXHJcbiAgaWYgKGkgPT0gbmwpIHtcclxuXHJcbiAgICAvLyBaZXJvLlxyXG4gICAgeC5jID0gW3guZSA9IDBdO1xyXG4gIH0gZWxzZSB7XHJcblxyXG4gICAgLy8gRGV0ZXJtaW5lIHRyYWlsaW5nIHplcm9zLlxyXG4gICAgZm9yICg7IG5sID4gMCAmJiBuLmNoYXJBdCgtLW5sKSA9PSAnMCc7KTtcclxuICAgIHguZSA9IGUgLSBpIC0gMTtcclxuICAgIHguYyA9IFtdO1xyXG5cclxuICAgIC8vIENvbnZlcnQgc3RyaW5nIHRvIGFycmF5IG9mIGRpZ2l0cyB3aXRob3V0IGxlYWRpbmcvdHJhaWxpbmcgemVyb3MuXHJcbiAgICBmb3IgKGUgPSAwOyBpIDw9IG5sOykgeC5jW2UrK10gPSArbi5jaGFyQXQoaSsrKTtcclxuICB9XHJcblxyXG4gIHJldHVybiB4O1xyXG59XHJcblxyXG5cclxuLypcclxuICogUm91bmQgQmlnIHggdG8gYSBtYXhpbXVtIG9mIGRwIGRlY2ltYWwgcGxhY2VzIHVzaW5nIHJvdW5kaW5nIG1vZGUgcm0uXHJcbiAqIENhbGxlZCBieSBzdHJpbmdpZnksIFAuZGl2LCBQLnJvdW5kIGFuZCBQLnNxcnQuXHJcbiAqXHJcbiAqIHgge0JpZ30gVGhlIEJpZyB0byByb3VuZC5cclxuICogZHAge251bWJlcn0gSW50ZWdlciwgMCB0byBNQVhfRFAgaW5jbHVzaXZlLlxyXG4gKiBybSB7bnVtYmVyfSAwLCAxLCAyIG9yIDMgKERPV04sIEhBTEZfVVAsIEhBTEZfRVZFTiwgVVApXHJcbiAqIFttb3JlXSB7Ym9vbGVhbn0gV2hldGhlciB0aGUgcmVzdWx0IG9mIGRpdmlzaW9uIHdhcyB0cnVuY2F0ZWQuXHJcbiAqL1xyXG5mdW5jdGlvbiByb3VuZCh4LCBkcCwgcm0sIG1vcmUpIHtcclxuICB2YXIgeGMgPSB4LmMsXHJcbiAgICBpID0geC5lICsgZHAgKyAxO1xyXG5cclxuICBpZiAoaSA8IHhjLmxlbmd0aCkge1xyXG4gICAgaWYgKHJtID09PSAxKSB7XHJcblxyXG4gICAgICAvLyB4Y1tpXSBpcyB0aGUgZGlnaXQgYWZ0ZXIgdGhlIGRpZ2l0IHRoYXQgbWF5IGJlIHJvdW5kZWQgdXAuXHJcbiAgICAgIG1vcmUgPSB4Y1tpXSA+PSA1O1xyXG4gICAgfSBlbHNlIGlmIChybSA9PT0gMikge1xyXG4gICAgICBtb3JlID0geGNbaV0gPiA1IHx8IHhjW2ldID09IDUgJiZcclxuICAgICAgICAobW9yZSB8fCBpIDwgMCB8fCB4Y1tpICsgMV0gIT09IFVOREVGSU5FRCB8fCB4Y1tpIC0gMV0gJiAxKTtcclxuICAgIH0gZWxzZSBpZiAocm0gPT09IDMpIHtcclxuICAgICAgbW9yZSA9IG1vcmUgfHwgISF4Y1swXTtcclxuICAgIH0gZWxzZSB7XHJcbiAgICAgIG1vcmUgPSBmYWxzZTtcclxuICAgICAgaWYgKHJtICE9PSAwKSB0aHJvdyBFcnJvcihJTlZBTElEX1JNKTtcclxuICAgIH1cclxuXHJcbiAgICBpZiAoaSA8IDEpIHtcclxuICAgICAgeGMubGVuZ3RoID0gMTtcclxuXHJcbiAgICAgIGlmIChtb3JlKSB7XHJcblxyXG4gICAgICAgIC8vIDEsIDAuMSwgMC4wMSwgMC4wMDEsIDAuMDAwMSBldGMuXHJcbiAgICAgICAgeC5lID0gLWRwO1xyXG4gICAgICAgIHhjWzBdID0gMTtcclxuICAgICAgfSBlbHNlIHtcclxuXHJcbiAgICAgICAgLy8gWmVyby5cclxuICAgICAgICB4Y1swXSA9IHguZSA9IDA7XHJcbiAgICAgIH1cclxuICAgIH0gZWxzZSB7XHJcblxyXG4gICAgICAvLyBSZW1vdmUgYW55IGRpZ2l0cyBhZnRlciB0aGUgcmVxdWlyZWQgZGVjaW1hbCBwbGFjZXMuXHJcbiAgICAgIHhjLmxlbmd0aCA9IGktLTtcclxuXHJcbiAgICAgIC8vIFJvdW5kIHVwP1xyXG4gICAgICBpZiAobW9yZSkge1xyXG5cclxuICAgICAgICAvLyBSb3VuZGluZyB1cCBtYXkgbWVhbiB0aGUgcHJldmlvdXMgZGlnaXQgaGFzIHRvIGJlIHJvdW5kZWQgdXAuXHJcbiAgICAgICAgZm9yICg7ICsreGNbaV0gPiA5Oykge1xyXG4gICAgICAgICAgeGNbaV0gPSAwO1xyXG4gICAgICAgICAgaWYgKCFpLS0pIHtcclxuICAgICAgICAgICAgKyt4LmU7XHJcbiAgICAgICAgICAgIHhjLnVuc2hpZnQoMSk7XHJcbiAgICAgICAgICB9XHJcbiAgICAgICAgfVxyXG4gICAgICB9XHJcblxyXG4gICAgICAvLyBSZW1vdmUgdHJhaWxpbmcgemVyb3MuXHJcbiAgICAgIGZvciAoaSA9IHhjLmxlbmd0aDsgIXhjWy0taV07KSB4Yy5wb3AoKTtcclxuICAgIH1cclxuICB9IGVsc2UgaWYgKHJtIDwgMCB8fCBybSA+IDMgfHwgcm0gIT09IH5+cm0pIHtcclxuICAgIHRocm93IEVycm9yKElOVkFMSURfUk0pO1xyXG4gIH1cclxuXHJcbiAgcmV0dXJuIHg7XHJcbn1cclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBzdHJpbmcgcmVwcmVzZW50aW5nIHRoZSB2YWx1ZSBvZiBCaWcgeCBpbiBub3JtYWwgb3IgZXhwb25lbnRpYWwgbm90YXRpb24uXHJcbiAqIEhhbmRsZXMgUC50b0V4cG9uZW50aWFsLCBQLnRvRml4ZWQsIFAudG9KU09OLCBQLnRvUHJlY2lzaW9uLCBQLnRvU3RyaW5nIGFuZCBQLnZhbHVlT2YuXHJcbiAqXHJcbiAqIHgge0JpZ31cclxuICogaWQ/IHtudW1iZXJ9IENhbGxlciBpZC5cclxuICogICAgICAgICAxIHRvRXhwb25lbnRpYWxcclxuICogICAgICAgICAyIHRvRml4ZWRcclxuICogICAgICAgICAzIHRvUHJlY2lzaW9uXHJcbiAqICAgICAgICAgNCB2YWx1ZU9mXHJcbiAqIG4/IHtudW1iZXJ8dW5kZWZpbmVkfSBDYWxsZXIncyBhcmd1bWVudC5cclxuICogaz8ge251bWJlcnx1bmRlZmluZWR9XHJcbiAqL1xyXG5mdW5jdGlvbiBzdHJpbmdpZnkoeCwgaWQsIG4sIGspIHtcclxuICB2YXIgZSwgcyxcclxuICAgIEJpZyA9IHguY29uc3RydWN0b3IsXHJcbiAgICB6ID0gIXguY1swXTtcclxuXHJcbiAgaWYgKG4gIT09IFVOREVGSU5FRCkge1xyXG4gICAgaWYgKG4gIT09IH5+biB8fCBuIDwgKGlkID09IDMpIHx8IG4gPiBNQVhfRFApIHtcclxuICAgICAgdGhyb3cgRXJyb3IoaWQgPT0gMyA/IElOVkFMSUQgKyAncHJlY2lzaW9uJyA6IElOVkFMSURfRFApO1xyXG4gICAgfVxyXG5cclxuICAgIHggPSBuZXcgQmlnKHgpO1xyXG5cclxuICAgIC8vIFRoZSBpbmRleCBvZiB0aGUgZGlnaXQgdGhhdCBtYXkgYmUgcm91bmRlZCB1cC5cclxuICAgIG4gPSBrIC0geC5lO1xyXG5cclxuICAgIC8vIFJvdW5kP1xyXG4gICAgaWYgKHguYy5sZW5ndGggPiArK2spIHJvdW5kKHgsIG4sIEJpZy5STSk7XHJcblxyXG4gICAgLy8gdG9GaXhlZDogcmVjYWxjdWxhdGUgayBhcyB4LmUgbWF5IGhhdmUgY2hhbmdlZCBpZiB2YWx1ZSByb3VuZGVkIHVwLlxyXG4gICAgaWYgKGlkID09IDIpIGsgPSB4LmUgKyBuICsgMTtcclxuXHJcbiAgICAvLyBBcHBlbmQgemVyb3M/XHJcbiAgICBmb3IgKDsgeC5jLmxlbmd0aCA8IGs7KSB4LmMucHVzaCgwKTtcclxuICB9XHJcblxyXG4gIGUgPSB4LmU7XHJcbiAgcyA9IHguYy5qb2luKCcnKTtcclxuICBuID0gcy5sZW5ndGg7XHJcblxyXG4gIC8vIEV4cG9uZW50aWFsIG5vdGF0aW9uP1xyXG4gIGlmIChpZCAhPSAyICYmIChpZCA9PSAxIHx8IGlkID09IDMgJiYgayA8PSBlIHx8IGUgPD0gQmlnLk5FIHx8IGUgPj0gQmlnLlBFKSkge1xyXG4gICAgcyA9IHMuY2hhckF0KDApICsgKG4gPiAxID8gJy4nICsgcy5zbGljZSgxKSA6ICcnKSArIChlIDwgMCA/ICdlJyA6ICdlKycpICsgZTtcclxuXHJcbiAgLy8gTm9ybWFsIG5vdGF0aW9uLlxyXG4gIH0gZWxzZSBpZiAoZSA8IDApIHtcclxuICAgIGZvciAoOyArK2U7KSBzID0gJzAnICsgcztcclxuICAgIHMgPSAnMC4nICsgcztcclxuICB9IGVsc2UgaWYgKGUgPiAwKSB7XHJcbiAgICBpZiAoKytlID4gbikgZm9yIChlIC09IG47IGUtLTspIHMgKz0gJzAnO1xyXG4gICAgZWxzZSBpZiAoZSA8IG4pIHMgPSBzLnNsaWNlKDAsIGUpICsgJy4nICsgcy5zbGljZShlKTtcclxuICB9IGVsc2UgaWYgKG4gPiAxKSB7XHJcbiAgICBzID0gcy5jaGFyQXQoMCkgKyAnLicgKyBzLnNsaWNlKDEpO1xyXG4gIH1cclxuXHJcbiAgcmV0dXJuIHgucyA8IDAgJiYgKCF6IHx8IGlkID09IDQpID8gJy0nICsgcyA6IHM7XHJcbn1cclxuXHJcblxyXG4vLyBQcm90b3R5cGUvaW5zdGFuY2UgbWV0aG9kc1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIG5ldyBCaWcgd2hvc2UgdmFsdWUgaXMgdGhlIGFic29sdXRlIHZhbHVlIG9mIHRoaXMgQmlnLlxyXG4gKi9cclxuUC5hYnMgPSBmdW5jdGlvbiAoKSB7XHJcbiAgdmFyIHggPSBuZXcgdGhpcy5jb25zdHJ1Y3Rvcih0aGlzKTtcclxuICB4LnMgPSAxO1xyXG4gIHJldHVybiB4O1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiAxIGlmIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBpcyBncmVhdGVyIHRoYW4gdGhlIHZhbHVlIG9mIEJpZyB5LFxyXG4gKiAgICAgICAtMSBpZiB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgaXMgbGVzcyB0aGFuIHRoZSB2YWx1ZSBvZiBCaWcgeSwgb3JcclxuICogICAgICAgIDAgaWYgdGhleSBoYXZlIHRoZSBzYW1lIHZhbHVlLlxyXG4qL1xyXG5QLmNtcCA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgdmFyIGlzbmVnLFxyXG4gICAgeCA9IHRoaXMsXHJcbiAgICB4YyA9IHguYyxcclxuICAgIHljID0gKHkgPSBuZXcgeC5jb25zdHJ1Y3Rvcih5KSkuYyxcclxuICAgIGkgPSB4LnMsXHJcbiAgICBqID0geS5zLFxyXG4gICAgayA9IHguZSxcclxuICAgIGwgPSB5LmU7XHJcblxyXG4gIC8vIEVpdGhlciB6ZXJvP1xyXG4gIGlmICgheGNbMF0gfHwgIXljWzBdKSByZXR1cm4gIXhjWzBdID8gIXljWzBdID8gMCA6IC1qIDogaTtcclxuXHJcbiAgLy8gU2lnbnMgZGlmZmVyP1xyXG4gIGlmIChpICE9IGopIHJldHVybiBpO1xyXG5cclxuICBpc25lZyA9IGkgPCAwO1xyXG5cclxuICAvLyBDb21wYXJlIGV4cG9uZW50cy5cclxuICBpZiAoayAhPSBsKSByZXR1cm4gayA+IGwgXiBpc25lZyA/IDEgOiAtMTtcclxuXHJcbiAgaiA9IChrID0geGMubGVuZ3RoKSA8IChsID0geWMubGVuZ3RoKSA/IGsgOiBsO1xyXG5cclxuICAvLyBDb21wYXJlIGRpZ2l0IGJ5IGRpZ2l0LlxyXG4gIGZvciAoaSA9IC0xOyArK2kgPCBqOykge1xyXG4gICAgaWYgKHhjW2ldICE9IHljW2ldKSByZXR1cm4geGNbaV0gPiB5Y1tpXSBeIGlzbmVnID8gMSA6IC0xO1xyXG4gIH1cclxuXHJcbiAgLy8gQ29tcGFyZSBsZW5ndGhzLlxyXG4gIHJldHVybiBrID09IGwgPyAwIDogayA+IGwgXiBpc25lZyA/IDEgOiAtMTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBuZXcgQmlnIHdob3NlIHZhbHVlIGlzIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBkaXZpZGVkIGJ5IHRoZSB2YWx1ZSBvZiBCaWcgeSwgcm91bmRlZCxcclxuICogaWYgbmVjZXNzYXJ5LCB0byBhIG1heGltdW0gb2YgQmlnLkRQIGRlY2ltYWwgcGxhY2VzIHVzaW5nIHJvdW5kaW5nIG1vZGUgQmlnLlJNLlxyXG4gKi9cclxuUC5kaXYgPSBmdW5jdGlvbiAoeSkge1xyXG4gIHZhciB4ID0gdGhpcyxcclxuICAgIEJpZyA9IHguY29uc3RydWN0b3IsXHJcbiAgICBhID0geC5jLCAgICAgICAgICAgICAgICAgIC8vIGRpdmlkZW5kXHJcbiAgICBiID0gKHkgPSBuZXcgQmlnKHkpKS5jLCAgIC8vIGRpdmlzb3JcclxuICAgIGsgPSB4LnMgPT0geS5zID8gMSA6IC0xLFxyXG4gICAgZHAgPSBCaWcuRFA7XHJcblxyXG4gIGlmIChkcCAhPT0gfn5kcCB8fCBkcCA8IDAgfHwgZHAgPiBNQVhfRFApIHRocm93IEVycm9yKElOVkFMSURfRFApO1xyXG5cclxuICAvLyBEaXZpc29yIGlzIHplcm8/XHJcbiAgaWYgKCFiWzBdKSB0aHJvdyBFcnJvcihESVZfQllfWkVSTyk7XHJcblxyXG4gIC8vIERpdmlkZW5kIGlzIDA/IFJldHVybiArLTAuXHJcbiAgaWYgKCFhWzBdKSByZXR1cm4gbmV3IEJpZyhrICogMCk7XHJcblxyXG4gIHZhciBibCwgYnQsIG4sIGNtcCwgcmksXHJcbiAgICBieiA9IGIuc2xpY2UoKSxcclxuICAgIGFpID0gYmwgPSBiLmxlbmd0aCxcclxuICAgIGFsID0gYS5sZW5ndGgsXHJcbiAgICByID0gYS5zbGljZSgwLCBibCksICAgLy8gcmVtYWluZGVyXHJcbiAgICBybCA9IHIubGVuZ3RoLFxyXG4gICAgcSA9IHksICAgICAgICAgICAgICAgIC8vIHF1b3RpZW50XHJcbiAgICBxYyA9IHEuYyA9IFtdLFxyXG4gICAgcWkgPSAwLFxyXG4gICAgZCA9IGRwICsgKHEuZSA9IHguZSAtIHkuZSkgKyAxOyAgICAvLyBudW1iZXIgb2YgZGlnaXRzIG9mIHRoZSByZXN1bHRcclxuXHJcbiAgcS5zID0gaztcclxuICBrID0gZCA8IDAgPyAwIDogZDtcclxuXHJcbiAgLy8gQ3JlYXRlIHZlcnNpb24gb2YgZGl2aXNvciB3aXRoIGxlYWRpbmcgemVyby5cclxuICBiei51bnNoaWZ0KDApO1xyXG5cclxuICAvLyBBZGQgemVyb3MgdG8gbWFrZSByZW1haW5kZXIgYXMgbG9uZyBhcyBkaXZpc29yLlxyXG4gIGZvciAoOyBybCsrIDwgYmw7KSByLnB1c2goMCk7XHJcblxyXG4gIGRvIHtcclxuXHJcbiAgICAvLyBuIGlzIGhvdyBtYW55IHRpbWVzIHRoZSBkaXZpc29yIGdvZXMgaW50byBjdXJyZW50IHJlbWFpbmRlci5cclxuICAgIGZvciAobiA9IDA7IG4gPCAxMDsgbisrKSB7XHJcblxyXG4gICAgICAvLyBDb21wYXJlIGRpdmlzb3IgYW5kIHJlbWFpbmRlci5cclxuICAgICAgaWYgKGJsICE9IChybCA9IHIubGVuZ3RoKSkge1xyXG4gICAgICAgIGNtcCA9IGJsID4gcmwgPyAxIDogLTE7XHJcbiAgICAgIH0gZWxzZSB7XHJcbiAgICAgICAgZm9yIChyaSA9IC0xLCBjbXAgPSAwOyArK3JpIDwgYmw7KSB7XHJcbiAgICAgICAgICBpZiAoYltyaV0gIT0gcltyaV0pIHtcclxuICAgICAgICAgICAgY21wID0gYltyaV0gPiByW3JpXSA/IDEgOiAtMTtcclxuICAgICAgICAgICAgYnJlYWs7XHJcbiAgICAgICAgICB9XHJcbiAgICAgICAgfVxyXG4gICAgICB9XHJcblxyXG4gICAgICAvLyBJZiBkaXZpc29yIDwgcmVtYWluZGVyLCBzdWJ0cmFjdCBkaXZpc29yIGZyb20gcmVtYWluZGVyLlxyXG4gICAgICBpZiAoY21wIDwgMCkge1xyXG5cclxuICAgICAgICAvLyBSZW1haW5kZXIgY2FuJ3QgYmUgbW9yZSB0aGFuIDEgZGlnaXQgbG9uZ2VyIHRoYW4gZGl2aXNvci5cclxuICAgICAgICAvLyBFcXVhbGlzZSBsZW5ndGhzIHVzaW5nIGRpdmlzb3Igd2l0aCBleHRyYSBsZWFkaW5nIHplcm8/XHJcbiAgICAgICAgZm9yIChidCA9IHJsID09IGJsID8gYiA6IGJ6OyBybDspIHtcclxuICAgICAgICAgIGlmIChyWy0tcmxdIDwgYnRbcmxdKSB7XHJcbiAgICAgICAgICAgIHJpID0gcmw7XHJcbiAgICAgICAgICAgIGZvciAoOyByaSAmJiAhclstLXJpXTspIHJbcmldID0gOTtcclxuICAgICAgICAgICAgLS1yW3JpXTtcclxuICAgICAgICAgICAgcltybF0gKz0gMTA7XHJcbiAgICAgICAgICB9XHJcbiAgICAgICAgICByW3JsXSAtPSBidFtybF07XHJcbiAgICAgICAgfVxyXG5cclxuICAgICAgICBmb3IgKDsgIXJbMF07KSByLnNoaWZ0KCk7XHJcbiAgICAgIH0gZWxzZSB7XHJcbiAgICAgICAgYnJlYWs7XHJcbiAgICAgIH1cclxuICAgIH1cclxuXHJcbiAgICAvLyBBZGQgdGhlIGRpZ2l0IG4gdG8gdGhlIHJlc3VsdCBhcnJheS5cclxuICAgIHFjW3FpKytdID0gY21wID8gbiA6ICsrbjtcclxuXHJcbiAgICAvLyBVcGRhdGUgdGhlIHJlbWFpbmRlci5cclxuICAgIGlmIChyWzBdICYmIGNtcCkgcltybF0gPSBhW2FpXSB8fCAwO1xyXG4gICAgZWxzZSByID0gW2FbYWldXTtcclxuXHJcbiAgfSB3aGlsZSAoKGFpKysgPCBhbCB8fCByWzBdICE9PSBVTkRFRklORUQpICYmIGstLSk7XHJcblxyXG4gIC8vIExlYWRpbmcgemVybz8gRG8gbm90IHJlbW92ZSBpZiByZXN1bHQgaXMgc2ltcGx5IHplcm8gKHFpID09IDEpLlxyXG4gIGlmICghcWNbMF0gJiYgcWkgIT0gMSkge1xyXG5cclxuICAgIC8vIFRoZXJlIGNhbid0IGJlIG1vcmUgdGhhbiBvbmUgemVyby5cclxuICAgIHFjLnNoaWZ0KCk7XHJcbiAgICBxLmUtLTtcclxuICB9XHJcblxyXG4gIC8vIFJvdW5kP1xyXG4gIGlmIChxaSA+IGQpIHJvdW5kKHEsIGRwLCBCaWcuUk0sIHJbMF0gIT09IFVOREVGSU5FRCk7XHJcblxyXG4gIHJldHVybiBxO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiB0cnVlIGlmIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBpcyBlcXVhbCB0byB0aGUgdmFsdWUgb2YgQmlnIHksIG90aGVyd2lzZSByZXR1cm4gZmFsc2UuXHJcbiAqL1xyXG5QLmVxID0gZnVuY3Rpb24gKHkpIHtcclxuICByZXR1cm4gIXRoaXMuY21wKHkpO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiB0cnVlIGlmIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBpcyBncmVhdGVyIHRoYW4gdGhlIHZhbHVlIG9mIEJpZyB5LCBvdGhlcndpc2UgcmV0dXJuXHJcbiAqIGZhbHNlLlxyXG4gKi9cclxuUC5ndCA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgcmV0dXJuIHRoaXMuY21wKHkpID4gMDtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gdHJ1ZSBpZiB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgaXMgZ3JlYXRlciB0aGFuIG9yIGVxdWFsIHRvIHRoZSB2YWx1ZSBvZiBCaWcgeSwgb3RoZXJ3aXNlXHJcbiAqIHJldHVybiBmYWxzZS5cclxuICovXHJcblAuZ3RlID0gZnVuY3Rpb24gKHkpIHtcclxuICByZXR1cm4gdGhpcy5jbXAoeSkgPiAtMTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gdHJ1ZSBpZiB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgaXMgbGVzcyB0aGFuIHRoZSB2YWx1ZSBvZiBCaWcgeSwgb3RoZXJ3aXNlIHJldHVybiBmYWxzZS5cclxuICovXHJcblAubHQgPSBmdW5jdGlvbiAoeSkge1xyXG4gIHJldHVybiB0aGlzLmNtcCh5KSA8IDA7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIHRydWUgaWYgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIGlzIGxlc3MgdGhhbiBvciBlcXVhbCB0byB0aGUgdmFsdWUgb2YgQmlnIHksIG90aGVyd2lzZVxyXG4gKiByZXR1cm4gZmFsc2UuXHJcbiAqL1xyXG5QLmx0ZSA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgcmV0dXJuIHRoaXMuY21wKHkpIDwgMTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBuZXcgQmlnIHdob3NlIHZhbHVlIGlzIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBtaW51cyB0aGUgdmFsdWUgb2YgQmlnIHkuXHJcbiAqL1xyXG5QLm1pbnVzID0gUC5zdWIgPSBmdW5jdGlvbiAoeSkge1xyXG4gIHZhciBpLCBqLCB0LCB4bHR5LFxyXG4gICAgeCA9IHRoaXMsXHJcbiAgICBCaWcgPSB4LmNvbnN0cnVjdG9yLFxyXG4gICAgYSA9IHgucyxcclxuICAgIGIgPSAoeSA9IG5ldyBCaWcoeSkpLnM7XHJcblxyXG4gIC8vIFNpZ25zIGRpZmZlcj9cclxuICBpZiAoYSAhPSBiKSB7XHJcbiAgICB5LnMgPSAtYjtcclxuICAgIHJldHVybiB4LnBsdXMoeSk7XHJcbiAgfVxyXG5cclxuICB2YXIgeGMgPSB4LmMuc2xpY2UoKSxcclxuICAgIHhlID0geC5lLFxyXG4gICAgeWMgPSB5LmMsXHJcbiAgICB5ZSA9IHkuZTtcclxuXHJcbiAgLy8gRWl0aGVyIHplcm8/XHJcbiAgaWYgKCF4Y1swXSB8fCAheWNbMF0pIHtcclxuXHJcbiAgICAvLyB5IGlzIG5vbi16ZXJvPyB4IGlzIG5vbi16ZXJvPyBPciBib3RoIGFyZSB6ZXJvLlxyXG4gICAgcmV0dXJuIHljWzBdID8gKHkucyA9IC1iLCB5KSA6IG5ldyBCaWcoeGNbMF0gPyB4IDogMCk7XHJcbiAgfVxyXG5cclxuICAvLyBEZXRlcm1pbmUgd2hpY2ggaXMgdGhlIGJpZ2dlciBudW1iZXIuIFByZXBlbmQgemVyb3MgdG8gZXF1YWxpc2UgZXhwb25lbnRzLlxyXG4gIGlmIChhID0geGUgLSB5ZSkge1xyXG5cclxuICAgIGlmICh4bHR5ID0gYSA8IDApIHtcclxuICAgICAgYSA9IC1hO1xyXG4gICAgICB0ID0geGM7XHJcbiAgICB9IGVsc2Uge1xyXG4gICAgICB5ZSA9IHhlO1xyXG4gICAgICB0ID0geWM7XHJcbiAgICB9XHJcblxyXG4gICAgdC5yZXZlcnNlKCk7XHJcbiAgICBmb3IgKGIgPSBhOyBiLS07KSB0LnB1c2goMCk7XHJcbiAgICB0LnJldmVyc2UoKTtcclxuICB9IGVsc2Uge1xyXG5cclxuICAgIC8vIEV4cG9uZW50cyBlcXVhbC4gQ2hlY2sgZGlnaXQgYnkgZGlnaXQuXHJcbiAgICBqID0gKCh4bHR5ID0geGMubGVuZ3RoIDwgeWMubGVuZ3RoKSA/IHhjIDogeWMpLmxlbmd0aDtcclxuXHJcbiAgICBmb3IgKGEgPSBiID0gMDsgYiA8IGo7IGIrKykge1xyXG4gICAgICBpZiAoeGNbYl0gIT0geWNbYl0pIHtcclxuICAgICAgICB4bHR5ID0geGNbYl0gPCB5Y1tiXTtcclxuICAgICAgICBicmVhaztcclxuICAgICAgfVxyXG4gICAgfVxyXG4gIH1cclxuXHJcbiAgLy8geCA8IHk/IFBvaW50IHhjIHRvIHRoZSBhcnJheSBvZiB0aGUgYmlnZ2VyIG51bWJlci5cclxuICBpZiAoeGx0eSkge1xyXG4gICAgdCA9IHhjO1xyXG4gICAgeGMgPSB5YztcclxuICAgIHljID0gdDtcclxuICAgIHkucyA9IC15LnM7XHJcbiAgfVxyXG5cclxuICAvKlxyXG4gICAqIEFwcGVuZCB6ZXJvcyB0byB4YyBpZiBzaG9ydGVyLiBObyBuZWVkIHRvIGFkZCB6ZXJvcyB0byB5YyBpZiBzaG9ydGVyIGFzIHN1YnRyYWN0aW9uIG9ubHlcclxuICAgKiBuZWVkcyB0byBzdGFydCBhdCB5Yy5sZW5ndGguXHJcbiAgICovXHJcbiAgaWYgKChiID0gKGogPSB5Yy5sZW5ndGgpIC0gKGkgPSB4Yy5sZW5ndGgpKSA+IDApIGZvciAoOyBiLS07KSB4Y1tpKytdID0gMDtcclxuXHJcbiAgLy8gU3VidHJhY3QgeWMgZnJvbSB4Yy5cclxuICBmb3IgKGIgPSBpOyBqID4gYTspIHtcclxuICAgIGlmICh4Y1stLWpdIDwgeWNbal0pIHtcclxuICAgICAgZm9yIChpID0gajsgaSAmJiAheGNbLS1pXTspIHhjW2ldID0gOTtcclxuICAgICAgLS14Y1tpXTtcclxuICAgICAgeGNbal0gKz0gMTA7XHJcbiAgICB9XHJcblxyXG4gICAgeGNbal0gLT0geWNbal07XHJcbiAgfVxyXG5cclxuICAvLyBSZW1vdmUgdHJhaWxpbmcgemVyb3MuXHJcbiAgZm9yICg7IHhjWy0tYl0gPT09IDA7KSB4Yy5wb3AoKTtcclxuXHJcbiAgLy8gUmVtb3ZlIGxlYWRpbmcgemVyb3MgYW5kIGFkanVzdCBleHBvbmVudCBhY2NvcmRpbmdseS5cclxuICBmb3IgKDsgeGNbMF0gPT09IDA7KSB7XHJcbiAgICB4Yy5zaGlmdCgpO1xyXG4gICAgLS15ZTtcclxuICB9XHJcblxyXG4gIGlmICgheGNbMF0pIHtcclxuXHJcbiAgICAvLyBuIC0gbiA9ICswXHJcbiAgICB5LnMgPSAxO1xyXG5cclxuICAgIC8vIFJlc3VsdCBtdXN0IGJlIHplcm8uXHJcbiAgICB4YyA9IFt5ZSA9IDBdO1xyXG4gIH1cclxuXHJcbiAgeS5jID0geGM7XHJcbiAgeS5lID0geWU7XHJcblxyXG4gIHJldHVybiB5O1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIG5ldyBCaWcgd2hvc2UgdmFsdWUgaXMgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIG1vZHVsbyB0aGUgdmFsdWUgb2YgQmlnIHkuXHJcbiAqL1xyXG5QLm1vZCA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgdmFyIHlndHgsXHJcbiAgICB4ID0gdGhpcyxcclxuICAgIEJpZyA9IHguY29uc3RydWN0b3IsXHJcbiAgICBhID0geC5zLFxyXG4gICAgYiA9ICh5ID0gbmV3IEJpZyh5KSkucztcclxuXHJcbiAgaWYgKCF5LmNbMF0pIHRocm93IEVycm9yKERJVl9CWV9aRVJPKTtcclxuXHJcbiAgeC5zID0geS5zID0gMTtcclxuICB5Z3R4ID0geS5jbXAoeCkgPT0gMTtcclxuICB4LnMgPSBhO1xyXG4gIHkucyA9IGI7XHJcblxyXG4gIGlmICh5Z3R4KSByZXR1cm4gbmV3IEJpZyh4KTtcclxuXHJcbiAgYSA9IEJpZy5EUDtcclxuICBiID0gQmlnLlJNO1xyXG4gIEJpZy5EUCA9IEJpZy5STSA9IDA7XHJcbiAgeCA9IHguZGl2KHkpO1xyXG4gIEJpZy5EUCA9IGE7XHJcbiAgQmlnLlJNID0gYjtcclxuXHJcbiAgcmV0dXJuIHRoaXMubWludXMoeC50aW1lcyh5KSk7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgbmV3IEJpZyB3aG9zZSB2YWx1ZSBpcyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgcGx1cyB0aGUgdmFsdWUgb2YgQmlnIHkuXHJcbiAqL1xyXG5QLnBsdXMgPSBQLmFkZCA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgdmFyIHQsXHJcbiAgICB4ID0gdGhpcyxcclxuICAgIEJpZyA9IHguY29uc3RydWN0b3IsXHJcbiAgICBhID0geC5zLFxyXG4gICAgYiA9ICh5ID0gbmV3IEJpZyh5KSkucztcclxuXHJcbiAgLy8gU2lnbnMgZGlmZmVyP1xyXG4gIGlmIChhICE9IGIpIHtcclxuICAgIHkucyA9IC1iO1xyXG4gICAgcmV0dXJuIHgubWludXMoeSk7XHJcbiAgfVxyXG5cclxuICB2YXIgeGUgPSB4LmUsXHJcbiAgICB4YyA9IHguYyxcclxuICAgIHllID0geS5lLFxyXG4gICAgeWMgPSB5LmM7XHJcblxyXG4gIC8vIEVpdGhlciB6ZXJvPyB5IGlzIG5vbi16ZXJvPyB4IGlzIG5vbi16ZXJvPyBPciBib3RoIGFyZSB6ZXJvLlxyXG4gIGlmICgheGNbMF0gfHwgIXljWzBdKSByZXR1cm4geWNbMF0gPyB5IDogbmV3IEJpZyh4Y1swXSA/IHggOiBhICogMCk7XHJcblxyXG4gIHhjID0geGMuc2xpY2UoKTtcclxuXHJcbiAgLy8gUHJlcGVuZCB6ZXJvcyB0byBlcXVhbGlzZSBleHBvbmVudHMuXHJcbiAgLy8gTm90ZTogcmV2ZXJzZSBmYXN0ZXIgdGhhbiB1bnNoaWZ0cy5cclxuICBpZiAoYSA9IHhlIC0geWUpIHtcclxuICAgIGlmIChhID4gMCkge1xyXG4gICAgICB5ZSA9IHhlO1xyXG4gICAgICB0ID0geWM7XHJcbiAgICB9IGVsc2Uge1xyXG4gICAgICBhID0gLWE7XHJcbiAgICAgIHQgPSB4YztcclxuICAgIH1cclxuXHJcbiAgICB0LnJldmVyc2UoKTtcclxuICAgIGZvciAoOyBhLS07KSB0LnB1c2goMCk7XHJcbiAgICB0LnJldmVyc2UoKTtcclxuICB9XHJcblxyXG4gIC8vIFBvaW50IHhjIHRvIHRoZSBsb25nZXIgYXJyYXkuXHJcbiAgaWYgKHhjLmxlbmd0aCAtIHljLmxlbmd0aCA8IDApIHtcclxuICAgIHQgPSB5YztcclxuICAgIHljID0geGM7XHJcbiAgICB4YyA9IHQ7XHJcbiAgfVxyXG5cclxuICBhID0geWMubGVuZ3RoO1xyXG5cclxuICAvLyBPbmx5IHN0YXJ0IGFkZGluZyBhdCB5Yy5sZW5ndGggLSAxIGFzIHRoZSBmdXJ0aGVyIGRpZ2l0cyBvZiB4YyBjYW4gYmUgbGVmdCBhcyB0aGV5IGFyZS5cclxuICBmb3IgKGIgPSAwOyBhOyB4Y1thXSAlPSAxMCkgYiA9ICh4Y1stLWFdID0geGNbYV0gKyB5Y1thXSArIGIpIC8gMTAgfCAwO1xyXG5cclxuICAvLyBObyBuZWVkIHRvIGNoZWNrIGZvciB6ZXJvLCBhcyAreCArICt5ICE9IDAgJiYgLXggKyAteSAhPSAwXHJcblxyXG4gIGlmIChiKSB7XHJcbiAgICB4Yy51bnNoaWZ0KGIpO1xyXG4gICAgKyt5ZTtcclxuICB9XHJcblxyXG4gIC8vIFJlbW92ZSB0cmFpbGluZyB6ZXJvcy5cclxuICBmb3IgKGEgPSB4Yy5sZW5ndGg7IHhjWy0tYV0gPT09IDA7KSB4Yy5wb3AoKTtcclxuXHJcbiAgeS5jID0geGM7XHJcbiAgeS5lID0geWU7XHJcblxyXG4gIHJldHVybiB5O1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIEJpZyB3aG9zZSB2YWx1ZSBpcyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgcmFpc2VkIHRvIHRoZSBwb3dlciBuLlxyXG4gKiBJZiBuIGlzIG5lZ2F0aXZlLCByb3VuZCB0byBhIG1heGltdW0gb2YgQmlnLkRQIGRlY2ltYWwgcGxhY2VzIHVzaW5nIHJvdW5kaW5nXHJcbiAqIG1vZGUgQmlnLlJNLlxyXG4gKlxyXG4gKiBuIHtudW1iZXJ9IEludGVnZXIsIC1NQVhfUE9XRVIgdG8gTUFYX1BPV0VSIGluY2x1c2l2ZS5cclxuICovXHJcblAucG93ID0gZnVuY3Rpb24gKG4pIHtcclxuICB2YXIgeCA9IHRoaXMsXHJcbiAgICBvbmUgPSBuZXcgeC5jb25zdHJ1Y3RvcigxKSxcclxuICAgIHkgPSBvbmUsXHJcbiAgICBpc25lZyA9IG4gPCAwO1xyXG5cclxuICBpZiAobiAhPT0gfn5uIHx8IG4gPCAtTUFYX1BPV0VSIHx8IG4gPiBNQVhfUE9XRVIpIHRocm93IEVycm9yKElOVkFMSUQgKyAnZXhwb25lbnQnKTtcclxuICBpZiAoaXNuZWcpIG4gPSAtbjtcclxuXHJcbiAgZm9yICg7Oykge1xyXG4gICAgaWYgKG4gJiAxKSB5ID0geS50aW1lcyh4KTtcclxuICAgIG4gPj49IDE7XHJcbiAgICBpZiAoIW4pIGJyZWFrO1xyXG4gICAgeCA9IHgudGltZXMoeCk7XHJcbiAgfVxyXG5cclxuICByZXR1cm4gaXNuZWcgPyBvbmUuZGl2KHkpIDogeTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBuZXcgQmlnIHdob3NlIHZhbHVlIGlzIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyByb3VuZGVkIHVzaW5nIHJvdW5kaW5nIG1vZGUgcm1cclxuICogdG8gYSBtYXhpbXVtIG9mIGRwIGRlY2ltYWwgcGxhY2VzLCBvciwgaWYgZHAgaXMgbmVnYXRpdmUsIHRvIGFuIGludGVnZXIgd2hpY2ggaXMgYVxyXG4gKiBtdWx0aXBsZSBvZiAxMCoqLWRwLlxyXG4gKiBJZiBkcCBpcyBub3Qgc3BlY2lmaWVkLCByb3VuZCB0byAwIGRlY2ltYWwgcGxhY2VzLlxyXG4gKiBJZiBybSBpcyBub3Qgc3BlY2lmaWVkLCB1c2UgQmlnLlJNLlxyXG4gKlxyXG4gKiBkcD8ge251bWJlcn0gSW50ZWdlciwgLU1BWF9EUCB0byBNQVhfRFAgaW5jbHVzaXZlLlxyXG4gKiBybT8gMCwgMSwgMiBvciAzIChST1VORF9ET1dOLCBST1VORF9IQUxGX1VQLCBST1VORF9IQUxGX0VWRU4sIFJPVU5EX1VQKVxyXG4gKi9cclxuUC5yb3VuZCA9IGZ1bmN0aW9uIChkcCwgcm0pIHtcclxuICB2YXIgQmlnID0gdGhpcy5jb25zdHJ1Y3RvcjtcclxuICBpZiAoZHAgPT09IFVOREVGSU5FRCkgZHAgPSAwO1xyXG4gIGVsc2UgaWYgKGRwICE9PSB+fmRwIHx8IGRwIDwgLU1BWF9EUCB8fCBkcCA+IE1BWF9EUCkgdGhyb3cgRXJyb3IoSU5WQUxJRF9EUCk7XHJcbiAgcmV0dXJuIHJvdW5kKG5ldyBCaWcodGhpcyksIGRwLCBybSA9PT0gVU5ERUZJTkVEID8gQmlnLlJNIDogcm0pO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIG5ldyBCaWcgd2hvc2UgdmFsdWUgaXMgdGhlIHNxdWFyZSByb290IG9mIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZywgcm91bmRlZCwgaWZcclxuICogbmVjZXNzYXJ5LCB0byBhIG1heGltdW0gb2YgQmlnLkRQIGRlY2ltYWwgcGxhY2VzIHVzaW5nIHJvdW5kaW5nIG1vZGUgQmlnLlJNLlxyXG4gKi9cclxuUC5zcXJ0ID0gZnVuY3Rpb24gKCkge1xyXG4gIHZhciByLCBjLCB0LFxyXG4gICAgeCA9IHRoaXMsXHJcbiAgICBCaWcgPSB4LmNvbnN0cnVjdG9yLFxyXG4gICAgcyA9IHgucyxcclxuICAgIGUgPSB4LmUsXHJcbiAgICBoYWxmID0gbmV3IEJpZygwLjUpO1xyXG5cclxuICAvLyBaZXJvP1xyXG4gIGlmICgheC5jWzBdKSByZXR1cm4gbmV3IEJpZyh4KTtcclxuXHJcbiAgLy8gTmVnYXRpdmU/XHJcbiAgaWYgKHMgPCAwKSB0aHJvdyBFcnJvcihOQU1FICsgJ05vIHNxdWFyZSByb290Jyk7XHJcblxyXG4gIC8vIEVzdGltYXRlLlxyXG4gIHMgPSBNYXRoLnNxcnQoeCArICcnKTtcclxuXHJcbiAgLy8gTWF0aC5zcXJ0IHVuZGVyZmxvdy9vdmVyZmxvdz9cclxuICAvLyBSZS1lc3RpbWF0ZTogcGFzcyB4IGNvZWZmaWNpZW50IHRvIE1hdGguc3FydCBhcyBpbnRlZ2VyLCB0aGVuIGFkanVzdCB0aGUgcmVzdWx0IGV4cG9uZW50LlxyXG4gIGlmIChzID09PSAwIHx8IHMgPT09IDEgLyAwKSB7XHJcbiAgICBjID0geC5jLmpvaW4oJycpO1xyXG4gICAgaWYgKCEoYy5sZW5ndGggKyBlICYgMSkpIGMgKz0gJzAnO1xyXG4gICAgcyA9IE1hdGguc3FydChjKTtcclxuICAgIGUgPSAoKGUgKyAxKSAvIDIgfCAwKSAtIChlIDwgMCB8fCBlICYgMSk7XHJcbiAgICByID0gbmV3IEJpZygocyA9PSAxIC8gMCA/ICcxZScgOiAocyA9IHMudG9FeHBvbmVudGlhbCgpKS5zbGljZSgwLCBzLmluZGV4T2YoJ2UnKSArIDEpKSArIGUpO1xyXG4gIH0gZWxzZSB7XHJcbiAgICByID0gbmV3IEJpZyhzKTtcclxuICB9XHJcblxyXG4gIGUgPSByLmUgKyAoQmlnLkRQICs9IDQpO1xyXG5cclxuICAvLyBOZXd0b24tUmFwaHNvbiBpdGVyYXRpb24uXHJcbiAgZG8ge1xyXG4gICAgdCA9IHI7XHJcbiAgICByID0gaGFsZi50aW1lcyh0LnBsdXMoeC5kaXYodCkpKTtcclxuICB9IHdoaWxlICh0LmMuc2xpY2UoMCwgZSkuam9pbignJykgIT09IHIuYy5zbGljZSgwLCBlKS5qb2luKCcnKSk7XHJcblxyXG4gIHJldHVybiByb3VuZChyLCBCaWcuRFAgLT0gNCwgQmlnLlJNKTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBuZXcgQmlnIHdob3NlIHZhbHVlIGlzIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyB0aW1lcyB0aGUgdmFsdWUgb2YgQmlnIHkuXHJcbiAqL1xyXG5QLnRpbWVzID0gUC5tdWwgPSBmdW5jdGlvbiAoeSkge1xyXG4gIHZhciBjLFxyXG4gICAgeCA9IHRoaXMsXHJcbiAgICBCaWcgPSB4LmNvbnN0cnVjdG9yLFxyXG4gICAgeGMgPSB4LmMsXHJcbiAgICB5YyA9ICh5ID0gbmV3IEJpZyh5KSkuYyxcclxuICAgIGEgPSB4Yy5sZW5ndGgsXHJcbiAgICBiID0geWMubGVuZ3RoLFxyXG4gICAgaSA9IHguZSxcclxuICAgIGogPSB5LmU7XHJcblxyXG4gIC8vIERldGVybWluZSBzaWduIG9mIHJlc3VsdC5cclxuICB5LnMgPSB4LnMgPT0geS5zID8gMSA6IC0xO1xyXG5cclxuICAvLyBSZXR1cm4gc2lnbmVkIDAgaWYgZWl0aGVyIDAuXHJcbiAgaWYgKCF4Y1swXSB8fCAheWNbMF0pIHJldHVybiBuZXcgQmlnKHkucyAqIDApO1xyXG5cclxuICAvLyBJbml0aWFsaXNlIGV4cG9uZW50IG9mIHJlc3VsdCBhcyB4LmUgKyB5LmUuXHJcbiAgeS5lID0gaSArIGo7XHJcblxyXG4gIC8vIElmIGFycmF5IHhjIGhhcyBmZXdlciBkaWdpdHMgdGhhbiB5Yywgc3dhcCB4YyBhbmQgeWMsIGFuZCBsZW5ndGhzLlxyXG4gIGlmIChhIDwgYikge1xyXG4gICAgYyA9IHhjO1xyXG4gICAgeGMgPSB5YztcclxuICAgIHljID0gYztcclxuICAgIGogPSBhO1xyXG4gICAgYSA9IGI7XHJcbiAgICBiID0gajtcclxuICB9XHJcblxyXG4gIC8vIEluaXRpYWxpc2UgY29lZmZpY2llbnQgYXJyYXkgb2YgcmVzdWx0IHdpdGggemVyb3MuXHJcbiAgZm9yIChjID0gbmV3IEFycmF5KGogPSBhICsgYik7IGotLTspIGNbal0gPSAwO1xyXG5cclxuICAvLyBNdWx0aXBseS5cclxuXHJcbiAgLy8gaSBpcyBpbml0aWFsbHkgeGMubGVuZ3RoLlxyXG4gIGZvciAoaSA9IGI7IGktLTspIHtcclxuICAgIGIgPSAwO1xyXG5cclxuICAgIC8vIGEgaXMgeWMubGVuZ3RoLlxyXG4gICAgZm9yIChqID0gYSArIGk7IGogPiBpOykge1xyXG5cclxuICAgICAgLy8gQ3VycmVudCBzdW0gb2YgcHJvZHVjdHMgYXQgdGhpcyBkaWdpdCBwb3NpdGlvbiwgcGx1cyBjYXJyeS5cclxuICAgICAgYiA9IGNbal0gKyB5Y1tpXSAqIHhjW2ogLSBpIC0gMV0gKyBiO1xyXG4gICAgICBjW2otLV0gPSBiICUgMTA7XHJcblxyXG4gICAgICAvLyBjYXJyeVxyXG4gICAgICBiID0gYiAvIDEwIHwgMDtcclxuICAgIH1cclxuXHJcbiAgICBjW2pdID0gKGNbal0gKyBiKSAlIDEwO1xyXG4gIH1cclxuXHJcbiAgLy8gSW5jcmVtZW50IHJlc3VsdCBleHBvbmVudCBpZiB0aGVyZSBpcyBhIGZpbmFsIGNhcnJ5LCBvdGhlcndpc2UgcmVtb3ZlIGxlYWRpbmcgemVyby5cclxuICBpZiAoYikgKyt5LmU7XHJcbiAgZWxzZSBjLnNoaWZ0KCk7XHJcblxyXG4gIC8vIFJlbW92ZSB0cmFpbGluZyB6ZXJvcy5cclxuICBmb3IgKGkgPSBjLmxlbmd0aDsgIWNbLS1pXTspIGMucG9wKCk7XHJcbiAgeS5jID0gYztcclxuXHJcbiAgcmV0dXJuIHk7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgc3RyaW5nIHJlcHJlc2VudGluZyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgaW4gZXhwb25lbnRpYWwgbm90YXRpb24gdG8gZHAgZml4ZWQgZGVjaW1hbFxyXG4gKiBwbGFjZXMgYW5kIHJvdW5kZWQgdXNpbmcgQmlnLlJNLlxyXG4gKlxyXG4gKiBkcD8ge251bWJlcn0gSW50ZWdlciwgMCB0byBNQVhfRFAgaW5jbHVzaXZlLlxyXG4gKi9cclxuUC50b0V4cG9uZW50aWFsID0gZnVuY3Rpb24gKGRwKSB7XHJcbiAgcmV0dXJuIHN0cmluZ2lmeSh0aGlzLCAxLCBkcCwgZHApO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIHN0cmluZyByZXByZXNlbnRpbmcgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIGluIG5vcm1hbCBub3RhdGlvbiB0byBkcCBmaXhlZCBkZWNpbWFsXHJcbiAqIHBsYWNlcyBhbmQgcm91bmRlZCB1c2luZyBCaWcuUk0uXHJcbiAqXHJcbiAqIGRwPyB7bnVtYmVyfSBJbnRlZ2VyLCAwIHRvIE1BWF9EUCBpbmNsdXNpdmUuXHJcbiAqXHJcbiAqICgtMCkudG9GaXhlZCgwKSBpcyAnMCcsIGJ1dCAoLTAuMSkudG9GaXhlZCgwKSBpcyAnLTAnLlxyXG4gKiAoLTApLnRvRml4ZWQoMSkgaXMgJzAuMCcsIGJ1dCAoLTAuMDEpLnRvRml4ZWQoMSkgaXMgJy0wLjAnLlxyXG4gKi9cclxuUC50b0ZpeGVkID0gZnVuY3Rpb24gKGRwKSB7XHJcbiAgcmV0dXJuIHN0cmluZ2lmeSh0aGlzLCAyLCBkcCwgdGhpcy5lICsgZHApO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIHN0cmluZyByZXByZXNlbnRpbmcgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIHJvdW5kZWQgdG8gc2Qgc2lnbmlmaWNhbnQgZGlnaXRzIHVzaW5nXHJcbiAqIEJpZy5STS4gVXNlIGV4cG9uZW50aWFsIG5vdGF0aW9uIGlmIHNkIGlzIGxlc3MgdGhhbiB0aGUgbnVtYmVyIG9mIGRpZ2l0cyBuZWNlc3NhcnkgdG8gcmVwcmVzZW50XHJcbiAqIHRoZSBpbnRlZ2VyIHBhcnQgb2YgdGhlIHZhbHVlIGluIG5vcm1hbCBub3RhdGlvbi5cclxuICpcclxuICogc2Qge251bWJlcn0gSW50ZWdlciwgMSB0byBNQVhfRFAgaW5jbHVzaXZlLlxyXG4gKi9cclxuUC50b1ByZWNpc2lvbiA9IGZ1bmN0aW9uIChzZCkge1xyXG4gIHJldHVybiBzdHJpbmdpZnkodGhpcywgMywgc2QsIHNkIC0gMSk7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgc3RyaW5nIHJlcHJlc2VudGluZyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcuXHJcbiAqIFJldHVybiBleHBvbmVudGlhbCBub3RhdGlvbiBpZiB0aGlzIEJpZyBoYXMgYSBwb3NpdGl2ZSBleHBvbmVudCBlcXVhbCB0byBvciBncmVhdGVyIHRoYW5cclxuICogQmlnLlBFLCBvciBhIG5lZ2F0aXZlIGV4cG9uZW50IGVxdWFsIHRvIG9yIGxlc3MgdGhhbiBCaWcuTkUuXHJcbiAqIE9taXQgdGhlIHNpZ24gZm9yIG5lZ2F0aXZlIHplcm8uXHJcbiAqL1xyXG5QLnRvU3RyaW5nID0gZnVuY3Rpb24gKCkge1xyXG4gIHJldHVybiBzdHJpbmdpZnkodGhpcyk7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgc3RyaW5nIHJlcHJlc2VudGluZyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcuXHJcbiAqIFJldHVybiBleHBvbmVudGlhbCBub3RhdGlvbiBpZiB0aGlzIEJpZyBoYXMgYSBwb3NpdGl2ZSBleHBvbmVudCBlcXVhbCB0byBvciBncmVhdGVyIHRoYW5cclxuICogQmlnLlBFLCBvciBhIG5lZ2F0aXZlIGV4cG9uZW50IGVxdWFsIHRvIG9yIGxlc3MgdGhhbiBCaWcuTkUuXHJcbiAqIEluY2x1ZGUgdGhlIHNpZ24gZm9yIG5lZ2F0aXZlIHplcm8uXHJcbiAqL1xyXG5QLnZhbHVlT2YgPSBQLnRvSlNPTiA9IGZ1bmN0aW9uICgpIHtcclxuICByZXR1cm4gc3RyaW5naWZ5KHRoaXMsIDQpO1xyXG59O1xyXG5cclxuXHJcbi8vIEV4cG9ydFxyXG5cclxuXHJcbmV4cG9ydCB2YXIgQmlnID0gX0JpZ18oKTtcclxuXHJcbmV4cG9ydCBkZWZhdWx0IEJpZztcclxuIiwiaW1wb3J0IEJpZyBmcm9tICdiaWcuanMnO1xuXG4vKipcbiAqIOWKoOazleWHveaVsFxuICogQHBhcmFtIHtudW1iZXJ8c3RyaW5nfSB4IC0g5Yqg5pWwXG4gKiBAcGFyYW0ge251bWJlcnxzdHJpbmd9IHkgLSDliqDmlbBcbiAqIEByZXR1cm5zIHtzdHJpbmd9IC0g6L+U5Zue55u45Yqg57uT5p6cXG4gKi9cbmZ1bmN0aW9uIGFkZCh4LCB5KSB7XG4gICAgcmV0dXJuIG5ldyBCaWcoeCkucGx1cyh5KS50b1N0cmluZygpO1xufVxuXG4vKipcbiAqIOWHj+azleWHveaVsFxuICogQHBhcmFtIHtudW1iZXJ8c3RyaW5nfSB4IC0g6KKr5YeP5pWwXG4gKiBAcGFyYW0ge251bWJlcnxzdHJpbmd9IHkgLSDlh4/mlbBcbiAqIEByZXR1cm5zIHtzdHJpbmd9IC0g6L+U5Zue55u45YeP57uT5p6cXG4gKi9cbmZ1bmN0aW9uIHN1YnRyYWN0KHgsIHkpIHtcbiAgICByZXR1cm4gbmV3IEJpZyh4KS5taW51cyh5KS50b1N0cmluZygpO1xufVxuXG4vKipcbiAqIOS5mOazleWHveaVsFxuICogQHBhcmFtIHtudW1iZXJ8c3RyaW5nfSB4IC0g5LmY5pWwXG4gKiBAcGFyYW0ge251bWJlcnxzdHJpbmd9IHkgLSDkuZjmlbBcbiAqIEByZXR1cm5zIHtzdHJpbmd9IC0g6L+U5Zue55u45LmY57uT5p6cXG4gKi9cbmZ1bmN0aW9uIG11bHRpcGx5KHgsIHkpIHtcbiAgICByZXR1cm4gbmV3IEJpZyh4KS50aW1lcyh5KS50b1N0cmluZygpO1xufVxuXG4vKipcbiAqIOmZpOazleWHveaVsFxuICogQHBhcmFtIHtudW1iZXJ8c3RyaW5nfSB4IC0g6KKr6Zmk5pWwXG4gKiBAcGFyYW0ge251bWJlcnxzdHJpbmd9IHkgLSDpmaTmlbBcbiAqIEByZXR1cm5zIHtzdHJpbmd9IC0g6L+U5Zue55u46Zmk57uT5p6cXG4gKi9cbmZ1bmN0aW9uIGRpdmlkZSh4LCB5KSB7XG4gICAgcmV0dXJuIG5ldyBCaWcoeCkuZGl2KHkpLnRvU3RyaW5nKCk7XG59XG5cbi8qKlxuICog5qC85byP5YyW5pWw5a2XXG4gKiBAcGFyYW0ge251bWJlcnxzdHJpbmd9IHZhbHVlIC0g5b6F5qC85byP5YyW55qE5pWw5a2XXG4gKiBAcGFyYW0ge251bWJlcn0gW3ByZWNpc2lvbl0gLSDnsr7luqbvvIzljbPlsI/mlbDkvY3mlbBcbiAqIEByZXR1cm5zIHtzdHJpbmd9IC0g5qC85byP5YyW5ZCO55qE5a2X56ym5LiyXG4gKi9cbmZ1bmN0aW9uIGZvcm1hdCh2YWx1ZSwgcHJlY2lzaW9uKSB7XG5cdEJpZy5ORSA9IC05XG4gICAgY29uc3QgYmlnVmFsdWUgPSBuZXcgQmlnKHZhbHVlKTtcbiAgICBsZXQgc3RyaW5nVmFsdWUgPSBiaWdWYWx1ZS50b1N0cmluZygpO1xuICAgIC8v5YaZ6L+Z5LmI6bq754Om77yM5piv5Zug5Li6QmlnLnJvdW5k55u45YWz5pa55rOV5LiN5aW95L2/77yM5b6X5LiN5Yiw6aKE5pyf57uT5p6c44CCXG4gICAgaWYgKHN0cmluZ1ZhbHVlLmluY2x1ZGVzKCcuJykpIHtcbiAgICAgICAgbGV0IHN0ckFycmF5ID0gc3RyaW5nVmFsdWUuc3BsaXQoJy4nKTtcbiAgICAgICAgaWYgKHN0ckFycmF5WzFdLmxlbmd0aCA+PSBwcmVjaXNpb24pIHtcbiAgICAgICAgICAgIGlmICgwID09IHByZWNpc2lvbikge1xuICAgICAgICAgICAgICAgIHJldHVybiBzdHJBcnJheVswXTtcbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIGVsc2Uge1xuICAgICAgICAgICAgICAgIC8v5oiq5patXG4gICAgICAgICAgICAgICAgbGV0IHRydW5jYXRlID0gc3RyQXJyYXlbMV0uc3Vic3RyaW5nKDAsIHByZWNpc2lvbik7XG4gICAgICAgICAgICAgICAgcmV0dXJuIGAke3N0ckFycmF5WzBdfS4ke3RydW5jYXRlfWA7XG4gICAgICAgICAgICB9XG4gICAgICAgIH1cbiAgICAgICAgZWxzZSB7XG4gICAgICAgICAgICAvL+ihpembtlxuICAgICAgICAgICAgbGV0IHplcm9OdW1iZXIgPSBwcmVjaXNpb24gLSBzdHJBcnJheVsxXS5sZW5ndGg7XG4gICAgICAgICAgICB2YXIgc3RyID0gJyc7XG4gICAgICAgICAgICBmb3IgKGxldCBpID0gMDsgaSA8IHplcm9OdW1iZXI7IGkrKykge1xuICAgICAgICAgICAgICAgIHN0ciArPSAnMCc7XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICByZXR1cm4gYCR7c3RyaW5nVmFsdWV9JHtzdHJ9YDtcbiAgICAgICAgfVxuICAgIH1cbiAgICBlbHNlIHtcbiAgICAgICAgaWYgKDAgPT0gcHJlY2lzaW9uKSB7XG4gICAgICAgICAgICByZXR1cm4gc3RyaW5nVmFsdWU7XG4gICAgICAgIH1cbiAgICAgICAgZWxzZSB7XG4gICAgICAgICAgICBsZXQgemVyb051bWJlciA9IHByZWNpc2lvbjtcbiAgICAgICAgICAgIHZhciBzdHIgPSAnJztcbiAgICAgICAgICAgIGZvciAobGV0IGkgPSAwOyBpIDwgemVyb051bWJlcjsgaSsrKSB7XG4gICAgICAgICAgICAgICAgc3RyICs9ICcwJztcbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIHJldHVybiBgJHtzdHJpbmdWYWx1ZX0uJHtzdHJ9YDtcbiAgICAgICAgfVxuICAgIH1cbn1cblxuLyoqXG4gKiDlr7nmlbDnu4TkuK3nmoTmr4/kuKrlhYPntKDov5vooYznsr7noa7ov5Dnrpflubbov5Tlm57kuIDkuKrmlrDmlbDnu4RcbiAqIEBwYXJhbSB7QXJyYXk8bnVtYmVyfHN0cmluZz59IGFyciAtIOW+hei/kOeul+aVsOe7hFxuICogQHJldHVybnMge0FycmF5PHN0cmluZz59IC0g6L+U5Zue6L+Q566X57uT5p6c5pWw57uEXG4gKi9cbmZ1bmN0aW9uIGJpZ251bWJlcihhcnIpIHtcbiAgICBpZiAoQXJyYXkuaXNBcnJheShhcnIpKSB7XG4gICAgICAgIHJldHVybiBhcnIubWFwKCh2YWx1ZSkgPT4gQmlnKHZhbHVlKS50b0ZpeGVkKCkpO1xuICAgIH0gZWxzZSB7XG4gICAgICAgIHJldHVybiBCaWcoYXJyKS50b0ZpeGVkKCk7XG4gICAgfVxufVxuXG5leHBvcnQgeyBhZGQsIHN1YnRyYWN0LCBtdWx0aXBseSwgZGl2aWRlLCBmb3JtYXQsIGJpZ251bWJlciB9O1xuIiwiaW1wb3J0ICogYXMgbnVtYmVyIGZyb20gXCIuL251bWJlclwiO1xuaW1wb3J0IEJpZyBmcm9tICdiaWcuanMnO1xuXG5CaWcuRFAgPSAzMDtcbkJpZy5STSA9IDI7XG52YXIgY2xpY2thYmxlID0gdHJ1ZTtcbmV4cG9ydCB2YXIgYWNjb3VudElkID0gLTE7XG5jb25zdCBERUZBVUxUX1NUUiA9ICcwLjAwJztcblxuZXhwb3J0IGZ1bmN0aW9uIG1vZHVsZURlZmluZShtb2R1bGVOYW1lLCBkZWZhdWx0RGF0YUZ1bmN0aW9uLCBmdW5jdGlvbnMgPSB7IG9uQ3JlYXRlLCBvbkRlc3Ryb3ksIG9uUmVzdW1lLCBvblBhdXNlLCBvblN0YXJ0LCBvblN0b3AgfSkge1xuICAgIGNvbnNvbGUubG9nKGBsb2FkTW9kdWxlYCwgbW9kdWxlTmFtZSk7XG4gICAgJGRhdGFbbW9kdWxlTmFtZV0gPSBkZWZhdWx0RGF0YUZ1bmN0aW9uKCk7XG4gICAgJGV2ZW50W21vZHVsZU5hbWVdID0ge1xuICAgICAgICBvbkNyZWF0ZTogdHlwZW9mIGZ1bmN0aW9ucy5vbkNyZWF0ZSA9PSAndW5kZWZpbmVkJyA/IG9uQ3JlYXRlIDogZnVuY3Rpb25zLm9uQ3JlYXRlLFxuICAgICAgICBvbkRlc3Ryb3k6IHR5cGVvZiBmdW5jdGlvbnMub25EZXN0cm95ID09ICd1bmRlZmluZWQnID8gb25EZXN0cm95IDogZnVuY3Rpb25zLm9uRGVzdHJveSxcbiAgICAgICAgb25SZXN1bWU6IHR5cGVvZiBmdW5jdGlvbnMub25SZXN1bWUgPT0gJ3VuZGVmaW5lZCcgPyBvblJlc3VtZSA6IGZ1bmN0aW9ucy5vblJlc3VtZSxcbiAgICAgICAgb25QYXVzZTogdHlwZW9mIGZ1bmN0aW9ucy5vblBhdXNlID09ICd1bmRlZmluZWQnID8gb25QYXVzZSA6IGZ1bmN0aW9ucy5vblBhdXNlLFxuICAgICAgICBvblN0YXJ0OiB0eXBlb2YgZnVuY3Rpb25zLm9uU3RhcnQgPT0gJ3VuZGVmaW5lZCcgPyBvblN0YXJ0IDogZnVuY3Rpb25zLm9uU3RhcnQsXG4gICAgICAgIG9uU3RvcDogdHlwZW9mIGZ1bmN0aW9ucy5vblN0b3AgPT0gJ3VuZGVmaW5lZCcgPyBvblN0b3AgOiBmdW5jdGlvbnMub25TdG9wLFxuICAgIH07XG4gICAgcmV0dXJuIHtcbiAgICAgICAgbW9kdWxlRGF0YTogJGRhdGFbbW9kdWxlTmFtZV0sXG4gICAgICAgIG1vZHVsZUV2ZW50OiAkZXZlbnRbbW9kdWxlTmFtZV1cbiAgICB9O1xufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gYW5hbHl0aWNzKGV2ZW50ID0gXCJcIiwgcHJvcGVydGllcyA9IHt9KSB7XG4gICAgY29uc3QgcHJvcGVydGllc0pzb24gPSBKU09OLnN0cmluZ2lmeShwcm9wZXJ0aWVzKTtcbiAgICBjb25zb2xlLmxvZyhgYW5hbHl0aWNzIGV2ZW50OiAke2V2ZW50fSwgcHJvcGVydGllc0pzb24gPSAke3Byb3BlcnRpZXNKc29ufWApO1xuICAgIHZhciBtYXAgPSB7XG4gICAgICAgIGV2ZW50OiBldmVudCxcbiAgICAgICAgcHJvcGVydGllczogcHJvcGVydGllc0pzb25cbiAgICB9O1xuICAgIGF3YWl0ICRuYXRpdmVBUEkuYW5hbHl0aWNzKG1hcCk7XG59XG5cbmZ1bmN0aW9uIG9uQ3JlYXRlKCkge1xuICAgIGNvbnNvbGUubG9nKCdjb21tb24gb25DcmVhdGUnKTtcbn1cblxuZnVuY3Rpb24gb25EZXN0cm95KCkge1xufVxuXG5mdW5jdGlvbiBvblJlc3VtZSgpIHtcbn1cblxuZnVuY3Rpb24gb25QYXVzZSgpIHtcbn1cblxuZnVuY3Rpb24gb25TdGFydCgpIHtcbn1cblxuZnVuY3Rpb24gb25TdG9wKCkge1xufVxuXG5leHBvcnQgdmFyIGNvbW1vbkRhdGEgPSB7XG4gICAgcHJpY2VDb2xvclR5cGU6IDAsIC8vLzDvvJrnuqLmtqjnu7/ot4wgICAx77ya57u/5rao57qi6LeMXG4gICAgY29sb3JNb2RlOiAwLCAvLy8w77ya55m95aSpICAgMe+8mum7keWknFxuICAgIE9TOiAwLCAvLzDvvJppT1MgIDHvvJrlronljZNcbiAgICBhcHBWZXJzaW9uOiBcIlwiLCAvL2FwcOeJiOacrOWPt1xuICAgIGlzSW5SZXZpZXc6IDEsXG4gICAgaDVVcmw6IFwiXCIsIC8vLyBoNeWKqOaAgeWfn+WQjVxuICAgIGxhbmd1YWdlOiBcIlwiLCAvLy8g6K+t6KiA56eN57G7XG4gICAgc3RhdHVzSGVpZ2h0OiAwLFxuICAgIHZUb2tlbjogXCJcIiwgLy8g5paw6K6+5aSH5oyH57q5XG4gICAgb2xkVlRva2VuOiBcIlwiLCAvLyDml6forr7lpIfmjIfnurks5Y+C6ICD5Y6f5p2lXCJmcFwiXG4gICAgYm90dG9tU2FmZUFyZWFIZWlnaHQ6IDAsXG4gICAgY291bnRyeUlkOiBcIlwiLC8v5Zyw5Yy656CBXG59O1xuJGRhdGEuY29tbW9uRGF0YSA9IGNvbW1vbkRhdGE7XG5cbi8vIC8v5omT5byAVVJMXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gb3BlblVSTCh1cmwpIHtcbiAgICBpZiAoIWNsaWNrYWJsZSkge1xuICAgICAgICByZXR1cm47XG4gICAgfVxuICAgIGNvbnNvbGUubG9nKGBvcGVuIHVybDpgLCB1cmwpO1xuICAgIGlmICh1cmwgJiYgdXJsICE9IG51bGwgJiYgdXJsLmxlbmd0aCA+IDApIHtcbiAgICAgICAgYXdhaXQgJG5hdGl2ZUFQSS5vcGVuUm91dGUodXJsKTtcbiAgICB9XG4gICAgY2xpY2thYmxlID0gZmFsc2U7XG4gICAgc2V0VGltZW91dCgoKSA9PiB7XG4gICAgICAgIGNsaWNrYWJsZSA9IHRydWU7XG4gICAgfSwgMTAwMCk7XG59XG5cbi8v6K6+572u6YCa55So6YWN572uXG5leHBvcnQgZnVuY3Rpb24gZ2V0Q29tbW9uQ29uZmlnKHBhcmFtKSB7XG4gICAgY29uc29sZS5sb2cocGFyYW0pO1xuICAgIGNvbW1vbkRhdGEucHJpY2VDb2xvclR5cGUgPSBwYXJzZUludChwYXJhbS5wcmljZUNvbG9yVHlwZSk7XG4gICAgY29tbW9uRGF0YS5jb2xvck1vZGUgPSBwYXJzZUludChwYXJhbS5jb2xvck1vZGUpO1xuICAgIGNvbW1vbkRhdGEuT1MgPSBwYXJzZUludChwYXJhbS5PUyk7XG4gICAgY29tbW9uRGF0YS5hcHBWZXJzaW9uID0gcGFyYW0uYXBwVmVyc2lvbjtcbiAgICBjb21tb25EYXRhLmlzSW5SZXZpZXcgPSBwYXJzZUludChwYXJhbS5pc0luUmV2aWV3KTtcbiAgICBjb21tb25EYXRhLmxhbmd1YWdlID0gcGFyYW0ubGFuZ3VhZ2U7XG4gICAgY29tbW9uRGF0YS5oNVVybCA9IHBhcmFtLmg1VXJsO1xuICAgIGNvbW1vbkRhdGEuc3RhdHVzSGVpZ2h0ID0gcGFyYW0uc3RhdHVzSGVpZ2h0O1xuICAgIGNvbW1vbkRhdGEudlRva2VuID0gcGFyYW0udlRva2VuO1xuICAgIGNvbW1vbkRhdGEub2xkVlRva2VuID0gcGFyYW0ub2xkVlRva2VuO1xuICAgIGNvbW1vbkRhdGEuYm90dG9tU2FmZUFyZWFIZWlnaHQgPSBwYXJhbS5ib3R0b21TYWZlQXJlYUhlaWdodDtcbiAgICBjb21tb25EYXRhLmNvdW50cnlJZCA9IHBhcmFtLmNvdW50cnlJZFxuICAgICRkYXRhLmNvbW1vbkRhdGEgPSBjb21tb25EYXRhO1xufVxuXG5leHBvcnQgZnVuY3Rpb24gZ2V0UE5HSWNvblVSTEJ5Q3VycmVuY3koY3VycmVuY3kpIHtcbiAgICBsZXQgYmFzZVVybCA9IGNvbW1vbkRhdGEuaDVVcmwgPyBjb21tb25EYXRhLmg1VXJsIDogXCJcIjtcbiAgICAgICAgcmV0dXJuIGAke2Jhc2VVcmx9Ly0veC9oYi9wL2FwaS9jb250ZW50cy9jdXJyZW5jeS9pY29uX3BuZy8ke2N1cnJlbmN5LnRvTG93ZXJDYXNlKCl9LnBuZ2A7XG59XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBnZXRJbmRleFByaWNlQnlTeW1ib2woc3ltYm9sKSB7XG4gICAgbGV0IGluZGV4UHJpY2VSZXFPYmogPSB7XG4gICAgICAgIHN5bWJvbDogc3ltYm9sXG4gICAgfTtcbiAgICBjb25zdCBkYXRhID0gYXdhaXQgc2VuZFJlcXVlc3QoXCJvcHRpb24vdjEvcHJlL2luZGV4XCIsIGluZGV4UHJpY2VSZXFPYmosIDAsIDgpO1xuICAgIGlmIChkYXRhKSB7XG4gICAgICAgIHJldHVybiBkYXRhO1xuICAgIH0gZWxzZSB7XG4gICAgICAgIHJldHVybiBcIi0tXCI7XG4gICAgfVxufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gcmVxdWVzdEFjY291bnRJZCgpIHtcbiAgICBjb25zdCBkYXRhID0gYXdhaXQgc2VuZFJlcXVlc3QoJ3YxL2FjY291bnQvYWNjb3VudHMnLCB7fSwgMCwgNCk7XG4gICAgY29uc29sZS5sb2coYHJlcXVlc3RBY2NvdW50SWQgOiAke0pTT04uc3RyaW5naWZ5KGRhdGEpfWApXG4gICAgZm9yICh2YXIgaSA9IDA7IGkgPCBkYXRhLmxlbmd0aDsgaSsrKSB7XG4gICAgICAgIGlmIChkYXRhW2ldLnR5cGUgPT0gXCJvdGMtb3B0aW9uc1wiKSB7XG4gICAgICAgICAgICBhY2NvdW50SWQgPSBkYXRhW2ldLmlkXG4gICAgICAgICAgICBicmVhaztcbiAgICAgICAgfVxuICAgIH1cbn1cblxuXG4vL+WPkemAgeivt+axglxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHNlbmRSZXF1ZXN0KHBhdGgsIHBhcmFtcyA9IHt9LCBtZXRob2QgPSAwLCBob3N0VHlwZSA9IDAsIGhlYWRlciA9IHt9KSB7XG4gICAgY29uc29sZS5sb2coYHJlcXVlc3QgJHtwYXRofSwgcGFyYW1zOiR7SlNPTi5zdHJpbmdpZnkocGFyYW1zKX1gKTtcblxuICAgIGlmIChob3N0VHlwZSA9PSA1IHx8IGhvc3RUeXBlID09IDYpIHtcbiAgICAgICAgaGVhZGVyW1wiQ29udGVudC1UeXBlXCJdID0gXCJhcHBsaWNhdGlvbi9qc29uXCI7XG4gICAgfVxuICAgIGhlYWRlcltcIkhCLUNPVU5UUlktSURcIl0gPSBjb21tb25EYXRhLmNvdW50cnlJZDtcblxuICAgIGNvbnN0IHBhcmFtID0ge1xuICAgICAgICBwYXRoLFxuICAgICAgICBtZXRob2QsXG4gICAgICAgIGhvc3RUeXBlLFxuICAgICAgICBoZWFkZXIsXG4gICAgICAgIHBhcmFtcyxcbiAgICB9O1xuICAgIHRyeSB7XG4gICAgICAgIHZhciByZXNwb25zZVN0cmluZyA9IGF3YWl0ICRuYXRpdmVBUEkucmVxdWVzdChKU09OLnN0cmluZ2lmeShwYXJhbSkpO1xuICAgICAgICAvL3RvZG8g6ZKI5a+55LiN5ZCMa2V5XG4gICAgICAgIHZhciByZXNwb25zZSA9IEpTT04ucGFyc2UocmVzcG9uc2VTdHJpbmcsICk7XG4gICAgICAgIHZhciB7IGNvZGUsIGRhdGEgfSA9IHJlc3BvbnNlO1xuICAgICAgICBpZiAoOCA9PSBob3N0VHlwZSkge1xuICAgICAgICAgICAgLy/lkIjnuqbnmoTmjqXlj6PlpITnkIZcbiAgICAgICAgICAgIHZhciBzdGF0dXMgPSByZXNwb25zZS5zdGF0dXM7XG4gICAgICAgICAgICB2YXIgZXJyX2NvZGUgPSByZXNwb25zZS5lcnJfY29kZTtcbiAgICAgICAgICAgIHZhciBlcnJfbXNnID0gcmVzcG9uc2UuZXJyX21zZztcbiAgICAgICAgICAgIGlmIChzdGF0dXMgPT0gXCJva1wiKSB7XG4gICAgICAgICAgICAgICAgY29uc29sZS5sb2coYHJlcXVlc3QgJHtwYXRofSBkb25lYCk7XG4gICAgICAgICAgICAgICAgaWYgKHR5cGVvZiBkYXRhID09PSAnbnVtYmVyJykge1xuICAgICAgICAgICAgICAgICAgICBsZXQgc3RhcnQgPSBgXCJkYXRhXCI6YDtcbiAgICAgICAgICAgICAgICAgICAgbGV0IHN0YXJ0SW5kZXggPSByZXNwb25zZVN0cmluZy5pbmRleE9mKHN0YXJ0KTtcbiAgICAgICAgICAgICAgICAgICAgbGV0IGVuZCA9IGAsXCJ0c1wiOmA7XG4gICAgICAgICAgICAgICAgICAgIGxldCBlbmRJbmRleCA9IHJlc3BvbnNlU3RyaW5nLmluZGV4T2YoZW5kKTtcbiAgICAgICAgICAgICAgICAgICAgbGV0IGRhdGFTdHJpbmcgPSByZXNwb25zZVN0cmluZy5zdWJzdHJpbmcoc3RhcnRJbmRleCArIHN0YXJ0Lmxlbmd0aCwgZW5kSW5kZXgpO1xuICAgICAgICAgICAgICAgICAgICBjb25zb2xlLmxvZyhgZGF0YSBpcyB0eXBlb2YgbnVtYmVyLCBkYXRhU3RyaW5nID0gJHtkYXRhU3RyaW5nfWApO1xuICAgICAgICAgICAgICAgICAgICByZXR1cm4gZGF0YVN0cmluZztcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgcmV0dXJuIGRhdGE7XG4gICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgIGNvbnNvbGUubG9nKGByZXF1ZXN0IGZhaWxlZCwgY29kZT0ke2Vycl9jb2RlfSwgbWVzc2FnZT0ke2Vycl9tc2d9YCk7XG4gICAgICAgICAgICAgICAgaWYgKG1ldGhvZCAhPSAwKSB7XG4gICAgICAgICAgICAgICAgICAgIHNob3dUb2FzdChlcnJfbXNnKTtcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgcmV0dXJuIG51bGw7XG4gICAgICAgICAgICB9XG4gICAgICAgIH0gZWxzZSBpZiAoY29kZSA9PSAyMDAgfHwgcmVzcG9uc2Uuc3RhdHVzID09IFwib2tcIikge1xuICAgICAgICAgICAgY29uc29sZS5sb2coYHJlcXVlc3QgJHtwYXRofSBkb25lYCk7XG4gICAgICAgICAgICByZXR1cm4gZGF0YTtcbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIGNvbnNvbGUubG9nKGByZXF1ZXN0IGZhaWxlZCwgY29kZT0ke2NvZGV9YCk7XG4gICAgICAgICAgICBsZXQgbWVzc2FnZSA9IHJlc3BvbnNlLm1lc3NhZ2U7XG4gICAgICAgICAgICBpZiAobWV0aG9kICE9IDAgJiYgbWVzc2FnZSkge1xuICAgICAgICAgICAgICAgIHNob3dUb2FzdChtZXNzYWdlKTtcbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIHJldHVybiBudWxsO1xuICAgICAgICB9XG4gICAgfSBjYXRjaCAoZSkge1xuICAgICAgICBjb25zb2xlLmxvZyhgcmVxdWVzdCBlcnJvciwgZXJyb3I9JHtlfWApO1xuICAgICAgICByZXR1cm4gbnVsbDtcbiAgICB9XG59XG5cbi8vdG9hc3RcbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBzaG93VG9hc3QobXNnKSB7XG4gICAgYXdhaXQgJG5hdGl2ZUFQSS5oYlRvYXN0KG1zZyk7XG59XG5cbi8qKlxuICogXG4gKiBAcGFyYW0ge2Jvb2xlYW59IGlzU2hvdyDmmK/lkKbmmL7npLrliqDovb3moYZcbiAqL1xuZXhwb3J0IGZ1bmN0aW9uIHNob3dMb2FkaW5nKGlzU2hvdyA9IHRydWUpIHtcbiAgICAkbmF0aXZlQVBJLnNob3dMb2FkaW5nKGlzU2hvdyA/IDEgOiAwKTtcbn1cblxuLyoqXG4gKiBcbiAqIEBwYXJhbSB75pe26Ze05pel5pyf5qC85byP5YyWfSBmbXQgeXl5eS1NTS1kZCBoaDptbTpzc1xuICogQHJldHVybnMg5qC85byP5YyW5LmL5ZCO55qEIOWtl+espuS4su+8jOeUqOazleS+i+WmgiBuZXcgRGF0ZSjml7bpl7TmiLMpLkZvcm1hdChcInl5eXktTU0tZGQgaGg6bW06c3NcIilcbiAqL1xuRGF0ZS5wcm90b3R5cGUuRm9ybWF0ID0gZnVuY3Rpb24gKGZtdCkge1xuICAgIHZhciBvID0ge1xuICAgICAgICBcIk0rXCI6IHRoaXMuZ2V0TW9udGgoKSArIDEsIC8v5pyI5Lu9IFxuICAgICAgICBcImQrXCI6IHRoaXMuZ2V0RGF0ZSgpLCAvL+aXpSBcbiAgICAgICAgXCJoK1wiOiB0aGlzLmdldEhvdXJzKCksIC8v5bCP5pe2IFxuICAgICAgICBcIm0rXCI6IHRoaXMuZ2V0TWludXRlcygpLCAvL+WIhiBcbiAgICAgICAgXCJzK1wiOiB0aGlzLmdldFNlY29uZHMoKSwgLy/np5IgXG4gICAgICAgIFwicStcIjogTWF0aC5mbG9vcigodGhpcy5nZXRNb250aCgpICsgMykgLyAzKSwgLy/lraPluqYgXG4gICAgICAgIFwiU1wiOiB0aGlzLmdldE1pbGxpc2Vjb25kcygpIC8v5q+r56eSIFxuICAgIH07XG4gICAgaWYgKC8oeSspLy50ZXN0KGZtdCkpIGZtdCA9IGZtdC5yZXBsYWNlKFJlZ0V4cC4kMSwgKHRoaXMuZ2V0RnVsbFllYXIoKSArIFwiXCIpLnN1YnN0cig0IC0gUmVnRXhwLiQxLmxlbmd0aCkpO1xuICAgIGZvciAodmFyIGsgaW4gbylcbiAgICAgICAgaWYgKG5ldyBSZWdFeHAoXCIoXCIgKyBrICsgXCIpXCIpLnRlc3QoZm10KSkgZm10ID0gZm10LnJlcGxhY2UoUmVnRXhwLiQxLCAoUmVnRXhwLiQxLmxlbmd0aCA9PSAxKSA/IChvW2tdKSA6ICgoXCIwMFwiICsgb1trXSkuc3Vic3RyKChcIlwiICsgb1trXSkubGVuZ3RoKSkpO1xuICAgIHJldHVybiBmbXQ7XG59XG5cbi8v6L+b6KGM57K+5bqm5aSE55CGXG5leHBvcnQgZnVuY3Rpb24gZm9ybWF0UHJlY2lzaW9uKHZhbHVlLCBwcmVjaXNpb24pIHtcbiAgICB0cnkge1xuICAgICAgICBjb25zdCByZXN1bHQgPSBudW1iZXIuZm9ybWF0KHZhbHVlLCBwcmVjaXNpb24pO1xuICAgICAgICByZXR1cm4gcmVzdWx0O1xuICAgIH0gY2F0Y2ggKGUpIHtcbiAgICAgICAgY29uc29sZS5sb2coZSk7XG4gICAgICAgIHJldHVybiB2YWx1ZS50b0ZpeGVkKHByZWNpc2lvbik7XG4gICAgfVxufVxuXG4vL+iOt+WPluS7t+agvOaYvuekuuaWh+acrFxuZXhwb3J0IGZ1bmN0aW9uIGdldFByaWNlU3RyaW5nKHByaWNlU3RyLCBwcmVjaXNpb24pIHtcbiAgICBjb25zdCBiaWdWYWx1ZSA9IG5ldyBCaWcocHJpY2VTdHIpO1xuICAgIGNvbnN0IHByaWNlU3RyaW5nID0gcHJlY2lzaW9uID09IC0xID8gYmlnVmFsdWUudG9TdHJpbmcoKSA6IGJpZ1ZhbHVlLnRvRml4ZWQocHJlY2lzaW9uKTtcbiAgICBjb25zdCBmaW5hbFByaWNlU3RyID0gcHJpY2VTdHJpbmcucmVwbGFjZSgvXFxkKy8sIGZ1bmN0aW9uIChuKSB7IC8vIOWFiOaPkOWPluaVtOaVsOmDqOWIhlxuICAgICAgICByZXR1cm4gbi5yZXBsYWNlKC8oXFxkKSg/PShcXGR7M30pKyQpL2csIGZ1bmN0aW9uICgkMSkge1xuICAgICAgICAgICAgcmV0dXJuICQxICsgXCIsXCI7XG4gICAgICAgIH0pO1xuICAgIH0pXG4gICAgLy8gY29uc3QgZmluYWxQcmljZVN0ciA9IHByaWNlU3RyaW5nLnRvU3RyaW5nKCkucmVwbGFjZSgvXFxCKD89KFxcZHszfSkrKD8hXFxkKSkvZywgXCIsXCIpO1xuICAgIHJldHVybiBmaW5hbFByaWNlU3RyO1xufVxuXG4vLyDmtqjot4zoibIgaXNSaXNlIO+8miB0cnVlIG9yIGZhbHNlXG5leHBvcnQgZnVuY3Rpb24gZ2V0UHJpY2VDb2xvcihpc1Jpc2UpIHtcbiAgICBpZiAoaXNSaXNlKSB7XG4gICAgICAgIHJldHVybiBjb21tb25EYXRhLnByaWNlQ29sb3JUeXBlID09IDEgPyBcIiMwMEExNzFcIiA6IFwiI0U5NDM1OVwiO1xuICAgIH0gZWxzZSB7XG4gICAgICAgIHJldHVybiBjb21tb25EYXRhLnByaWNlQ29sb3JUeXBlID09IDAgPyBcIiMwMEExNzFcIiA6IFwiI0U5NDM1OVwiO1xuICAgIH1cbn1cblxuLy/lrrnlmajov5Tlm57og73liptcbmV4cG9ydCBmdW5jdGlvbiBjb250YWluZXJCYWNrKHBhcmFtcyA9IDApIHtcbiAgICBjb25zb2xlLmxvZyhcImNvbnRhaW5lckJhY2tcIilcbiAgICAkbmF0aXZlQVBJLmNvbnRhaW5lckJhY2socGFyYW1zKVxufVxuXG4vLyDmiZPlvIBINemhtemdou+8jOS8oOWFpei3r+W+hO+8jOaLvOaOpeWfn+WQjVxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIG9wZW5QYWdlV2l0aFBhdGgodXJsUGF0aCkge1xuICAgIGNvbnNvbGUubG9nKGBvcGVuSDVXaXRoUGF0aDpgLCB1cmxQYXRoKTtcbiAgICBpZiAodXJsUGF0aCAmJiB1cmxQYXRoICE9IG51bGwpIHtcbiAgICAgICAgaWYgKHVybFBhdGguaW5kZXhPZihcImhvbGlnZWl0XCIpID09IDAgfHwgdXJsUGF0aC5pbmRleE9mKFwiaHR0cFwiKSA9PSAwKSB7XG4gICAgICAgICAgICBvcGVuVVJMKHVybFBhdGgpO1xuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgb3BlblVSTChgJHtjb21tb25EYXRhLmg1VXJsfS8ke2NvbW1vbkRhdGEubGFuZ3VhZ2V9JHt1cmxQYXRofWApO1xuICAgICAgICB9XG4gICAgfVxufVxuXG4vL+S/neWtmOaVsOaNrlxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHNhdmUobW9kdWxlLCBrZXksIGRhdGEpIHtcbiAgICBhd2FpdCAkbmF0aXZlQVBJLnN0b3JhZ2Uoe1xuICAgICAgYWN0aW9uOiBcInNhdmVcIixcbiAgICAgIG5hbWU6IG1vZHVsZSxcbiAgICAgIGtleToga2V5LFxuICAgICAgZGF0YTogSlNPTi5zdHJpbmdpZnkoZGF0YSksXG4gICAgfSk7XG4gIH1cbiAgXG4gIC8v6K+75Y+W5pWw5o2uXG4gIGV4cG9ydCBhc3luYyBmdW5jdGlvbiByZWFkKG1vZHVsZSwga2V5KSB7XG4gICAgY29uc3QgZGF0YSA9IGF3YWl0ICRuYXRpdmVBUEkuc3RvcmFnZSh7XG4gICAgICBhY3Rpb246IFwicmVhZFwiLFxuICAgICAgbmFtZTogbW9kdWxlLFxuICAgICAga2V5OiBrZXksXG4gICAgfSk7XG4gICAgaWYgKGRhdGEgJiYgZGF0YSAhPSBcIlwiKSB7XG4gICAgICByZXR1cm4gSlNPTi5wYXJzZShkYXRhKTtcbiAgICB9XG4gICAgcmV0dXJuIG51bGw7XG4gIH1cblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGdldExlZ2FsQ3VycmVuY3lTeW1ib2woKSB7XG4gICAgY29uc3QgY3VycmVuY3lTeW1ib2wgPSBhd2FpdCAkbmF0aXZlQVBJLmN1cnJlbmN5Q29tbW9uKCd7XCJ0eXBlXCI6OX0nKTtcbiAgICByZXR1cm4gY3VycmVuY3lTeW1ib2w7XG59XG5cbi8vIOS7t+agvOi9rOaNolxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGNvbnZlcnRMZWdhbFRlbmRlcihzeW1ib2wsIGFtb3VudCwgY3VycmVuY3lTY2FsZSkge1xuICAgIGlmICghYW1vdW50KSB7XG4gICAgICAgIGFtb3VudCA9ICcwJztcbiAgICB9XG5cdHZhciBwYXJhbSA9IHtcblx0XHR0eXBlOiAxLFxuXHRcdGN1cnJlbmN5OiBzeW1ib2wsXG5cdFx0YW1vdW50XG5cdH07XG5cdGlmIChjdXJyZW5jeVNjYWxlID4gMCkge1xuXHRcdHBhcmFtID0ge1xuXHRcdFx0dHlwZTogMTExLFxuXHRcdFx0Y3VycmVuY3k6IHN5bWJvbCxcblx0XHRcdGFtb3VudCxcblx0XHRcdGN1cnJlbmN5U2NhbGVcblx0XHR9XG5cdH1cbiAgICBjb25zdCBwYXJhbVN0cmluZyA9IEpTT04uc3RyaW5naWZ5KHBhcmFtKTtcbiAgICByZXR1cm4gYXdhaXQgJG5hdGl2ZUFQSS5jdXJyZW5jeUNvbW1vbihwYXJhbVN0cmluZyk7XG59XG5cbi8v6L+b6KGM57K+5bqm5aSE55CGLCDmnInlpITnkIbkuYvlkI4gPCDnsr7luqbmnIDlpKflgLxcbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBmb3JtYXRCeU1pblByZWNpc2lvbihhbW91bnQsIHByZWNpc2lvbikge1xuICAgIGlmICghYW1vdW50KSB7XG4gICAgICAgIGFtb3VudCA9ICcwLjAwJztcbiAgICB9XG5cdGlmICghcHJlY2lzaW9uKSB7XG5cdFx0cHJlY2lzaW9uID0gMjtcblx0fVxuXHR2YXIgcGFyYW0gPSB7XG5cdFx0dHlwZTogMTEyLFxuXHRcdGFtb3VudCxcblx0XHRwcmVjaXNpb24sXG5cdH07XG4gICAgY29uc3QgcGFyYW1TdHJpbmcgPSBKU09OLnN0cmluZ2lmeShwYXJhbSk7XG4gICAgcmV0dXJuIGF3YWl0ICRuYXRpdmVBUEkuY3VycmVuY3lDb21tb24ocGFyYW1TdHJpbmcpO1xufVxuXG5leHBvcnQgZnVuY3Rpb24gYWRkQ3VycmVuY3lTeW1ib2woY3VycmVuY3lTeW1ib2wsIHNvdXJjZSkge1xuICAgIGlmIChzb3VyY2UgPT09ICctLScpIHtcbiAgICAgICAgcmV0dXJuIHNvdXJjZTtcbiAgICB9XG4gICAgZWxzZSBpZiAoc291cmNlICYmIHNvdXJjZSAhPT0gREVGQVVMVF9TVFIpIHtcbiAgICAgICAgaWYgKHNvdXJjZS5zdGFydHNXaXRoKCctJykpIHtcblx0XHRcdGlmIChjdXJyZW5jeVN5bWJvbCA9PSBcIuKCrlwiKSB7XG5cdFx0XHRcdHJldHVybiBgLSR7c291cmNlLnN1YnN0cmluZygxKX0gVVNEVGA7XG5cdFx0XHR9XG4gICAgICAgICAgICByZXR1cm4gYC0ke2N1cnJlbmN5U3ltYm9sfSR7c291cmNlLnN1YnN0cmluZygxKX1gO1xuICAgICAgICB9XG5cdFx0aWYgKGN1cnJlbmN5U3ltYm9sID09IFwi4oKuXCIpIHtcblx0XHRcdHJldHVybiBgJHtzb3VyY2V9IFVTRFRgO1xuXHRcdH1cbiAgICAgICAgcmV0dXJuIGAke2N1cnJlbmN5U3ltYm9sfSR7c291cmNlfWA7XG4gICAgfSBlbHNlIHtcblx0XHRpZiAoY3VycmVuY3lTeW1ib2wgPT0gXCLigq5cIikge1xuXHRcdFx0cmV0dXJuIGAke0RFRkFVTFRfU1RSfSBVU0RUYDtcblx0XHR9XG4gICAgICAgIHJldHVybiBgJHtjdXJyZW5jeVN5bWJvbH0ke0RFRkFVTFRfU1RSfWA7XG4gICAgfVxufVxuXG5leHBvcnQgZnVuY3Rpb24gcmVtb3ZlRXh0cmFaZXJvcyhudW0pIHtcbiAgICByZXR1cm4gbnVtLnJlcGxhY2UoLyg/OlxcLjAqfChcXC5cXGQrPykwKykkLywgJyQxJyk7XG59XG5cbi8qKlxuICog5YW85a65YW5kcm9pZOWSjGlvcyDlnKjliKnnjocrJeaXtueahOaWh+acrOWkhOeQhiBcbiAqL1xuZXhwb3J0IGZ1bmN0aW9uIGFkYXB0ZXJQZXJjZW50RmxhZyhzdHIpIHtcbiAgaWYgKHN0ciA9PSBudWxsIHx8IHN0ciA9PSB1bmRlZmluZWQpIHtcbiAgICByZXR1cm4gXCJcIjtcbiAgfVxuICBsZXQgcmVzdWx0ID0gc3RyO1xuICBpZiAoY29tbW9uRGF0YS5PUyA9PSAwKSB7XG4gICAgcmVzdWx0ID0gc3RyLnJlcGxhY2UoLyUlL2csIFwiJVwiKTtcbiAgfVxuICByZXR1cm4gcmVzdWx0O1xufVxuIiwiLy/liqDmga/liLjliJfooajlvLnnqpdcbmltcG9ydCAqIGFzIGNvbW1vbiBmcm9tIFwiLi9jb21tb25cIjtcbmltcG9ydCAqIGFzIG51bWJlciBmcm9tIFwiLi9udW1iZXJcIjtcbmNvbnN0IHRhZyA9IFwic2ltcGxlX2Vhcm5fY291cG9uX2xpc3RcIjtcbi8qKlxuICogMS7ku45jdXJyZW50Lmpz5Lit5YiG56a75Yqg5oGv5Yi455qE5Lia5Yqh6YC76L6RXG4gKiAyLuais+eQhuWSjOWujOWWhOWKoOaBr+WIuOeahOS4muWKoeWkhOeQhlxuICovXG5cbmV4cG9ydCBjb25zdCBjb3Vwb25MaXN0UmVzID0ge1xuICAvL2l0ZW3lj6/nlKjml7botYTmupBcbiAgdXNhYmxlQmdDb2xvcjogXCJAY29sb3IvS0Jhc2VDb2xvcklucHV0QmFja2dyb3VuZFwiLFxuICB1c2FibGVUaXRsZUNvbG9yOiBcIkBjb2xvci9rQ29sb3JQcmltYXJ5VGV4dFwiLFxuICB1c2FibGVWYWxDb2xvcjogXCJAY29sb3Iva0NvbG9yVGhyZWVMZXZlbFRleHRcIixcbiAgLy9pdGVt5LiN5Y+v55So5pe26LWE5rqQXG4gIGRpc2FibGVCZ0NvbG9yOiBcIkBjb2xvci9rQ29sb3JUaXBzQmFja2dyb3VuZFwiLFxuICBkaXNhYmxlVGl0bGVDb2xvcjogXCJAY29sb3IvYmFzZUNvbG9yVGhyZWVMZXZlbFRleHRcIixcbiAgZGlzYWJsZVZhbENvbG9yOiBcIkBjb2xvci9iYXNlQ29sb3JUaHJlZUxldmVsVGV4dFwiLFxuXG4gIC8vaXRlbeWNlemAieahhuWbvueJh+i1hOa6kFxuICBkaXNhYmxlSW1nOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luX3NpbXBsZV9lYXJuX2NvdXBvbl9kaXNhYmxlXCIsXG4gIHNlbGVjdGVkSW1nOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luX3NpbXBsZV9lYXJuX2NvdXBvbl9zZWxlY3RlZFwiLFxuICB1bnNlbGVjdGVkSW1nOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luX3NpbXBsZV9lYXJuX2NvdXBvbl91bnNlbGVjdGVkXCIsXG59O1xuXG5leHBvcnQgY2xhc3MgQ29ucG9uTGlzdEl0ZW0ge1xuICB0aXRsZSA9IFwiXCI7IC8v5qCH6aKYXG4gIGNvdXBvblVwTGltaXQgPSAwOyAvL+WKoOaBr+WIuOWKoOaBr+acrOmHkeS4iumZkFxuICBjb3Vwb25Eb3duTGltaXQgPSAwOyAvL+WKoOaBr+WIuOi1t+aKleaVsOmHj1xuICBjb3Vwb25DdXJyZW5jeSA9IFwiXCI7IC8v5Yqg5oGv5Yi45biB56eNXG4gIGFweSA9IFwiXCI7IC8v6KGl6LS05Yip546HIDAuMlxuICBjb3Vwb25UZXJtID0gMDsgLy/liqDmga/liLjnlJ/mlYjlpKnmlbBcbiAgYmVnaW5UaW1lID0gXCJcIjsgLy/kvJjmg6DliLjmnInmlYjlvIDlp4vml6XmnJ9cbiAgZW5kVGltZSA9IFwiXCI7IC8v5LyY5oOg5Yi45pyJ5pWI57uT5p2f5pel5pyfIDE3MjkzMDM0MzcxNzlcbiAgY291cG9uU2lnbiA9IFwiXCI7IC8v5Yqg5oGv5Yi4562+5ZCNXG4gIGlkID0gXCJcIjsgLy9jb3Vwb25JZFxuICBkdWVUYWcgPSAwOyAvL+aYr+WQpuWxleekuuWNs+WwhuWIsOacn+agh+iusCAwIOS4jea7oei2syAxIOa7oei2s1xuXG4gIGluZGV4ID0gLTE7IC8v57Si5byVXG4gIGFweVRleHQgPSBcIlwiOyAvL+WIqeeOh+aWh+acrFxuICBlbmRUaW1lVGV4dCA9IFwiXCI7IC8v5pyJ5pWI5pyf57uT5p2f5pel5pyfXG4gIGltZ1NlbGVjdG9yID0gXCJcIjsgLy/ljZXpgInmoYbnmoTlm77niYdcbiAgYXBwZW5kVGV4dCA9IFwiXCI7IC8v5ou85o6l5a2X56ym5Liy77ya6K6k6LSt5ruhIDEwMCBVU0RUIHwg5Yqg5oGv6aKdIDEwMDAgVVNEVCB8IOWKoOaBrzLlpKlcbiAgc2hvd0hpZ3Rlc3QgPSBcImdvbmVcIjsgLy/mnIDpq5jlm77moIfmmL7pmpBcbiAgZHVlVmlzID0gXCJnb25lXCI7IC8v5Y2z5bCG5Yiw5pyf55qE5pi+6ZqQIHRvZG8g5L+u5pS56buY6K6k5pi+56S6XG4gIHR5cGUgPSBcIjFcIjsgLy/nsbvlnotcbiAgc2V0RHVlVGFnKGR1ZVRhZykge1xuICAgIHRoaXMuZHVlVGFnID0gZHVlVGFnO1xuICAgIGlmIChkdWVUYWcgPT0gMSkge1xuICAgICAgdGhpcy5kdWVWaXMgPSBcInZpc2libGVcIjtcbiAgICB9IGVsc2Uge1xuICAgICAgdGhpcy5kdWVWaXMgPSBcImdvbmVcIjtcbiAgICB9XG4gIH1cblxuICBzZXRBcHkoYXB5KSB7XG4gICAgdGhpcy5hcHkgPSBhcHk7XG4gICAgdGhpcy5hcHlUZXh0ID0gY29tbW9uLmZvcm1hdFByZWNpc2lvbihudW1iZXIubXVsdGlwbHkoYXB5LCAxMDApLCAyKTtcbiAgfVxuXG4gIHNldEVuZFRpbWUoZW5kVGltZSkge1xuICAgIHRoaXMuZW5kVGltZSA9IGVuZFRpbWU7XG4gICAgdGhpcy5lbmRUaW1lVGV4dCA9ICRpMThuLiRpbnRlcmNlcHQubl9zaW1wbGVfZWFybl9jb3Vwb25fbGlzdF92YWxpZF90byhgJHtuZXcgRGF0ZShlbmRUaW1lKS5Gb3JtYXQoXCJ5eXl5L01NL2RkXCIpfWApO1xuICB9XG5cbiAgc2V0QXBwZW5kVGV4dCgpIHtcbiAgICAvLyB0aGlzLnJpY2hUZXh0ID0gYDxzcGFuIHN0eWxlPVwiY29sb3I6JHskZGF0YS5jb3Vwb25MaXN0Lml0ZW1WYWxDb2xvcn07IGZvbnQtc2l6ZToxMHB4O1wiPuiupOi0rea7oSAke3RoaXMuY291cG9uRG93bkxpbWl0fSAke3RoaXMuY291cG9uQ3VycmVuY3l9PC9zcGFuPjxzcGFuIHN0eWxlPVwiY29sb3I6QGNvbG9yL0tCYXNlQ29sb3JQcmltYXJ5U2VwYXJhdG9yOyBmb250LXNpemU6MTBweDtcIj4g772cIDwvc3Bhbj5gXG4gICAgdGhpcy5hcHBlbmRUZXh0ID0gJGkxOG4uJGludGVyY2VwdC5uX3NpbXBsZV9lYXJuX2NvdXBvbl9saXN0X2JvdHRvbShcbiAgICAgIGAke3RoaXMuY291cG9uRG93bkxpbWl0fWAsXG4gICAgICBgJHt0aGlzLmNvdXBvbkN1cnJlbmN5fWAsXG4gICAgICBgJHt0aGlzLmNvdXBvblVwTGltaXR9YCxcbiAgICAgIGAke3RoaXMuY291cG9uQ3VycmVuY3l9YCxcbiAgICAgIGAke3RoaXMuY291cG9uVGVybX1gXG4gICAgKTtcbiAgfVxuXG4gIGNvcHkoaXRlbSkge1xuICAgIHRoaXMudGl0bGUgPSBpdGVtLnRpdGxlO1xuICAgIHRoaXMuY291cG9uVXBMaW1pdCA9IGl0ZW0uY291cG9uVXBMaW1pdDtcbiAgICB0aGlzLmNvdXBvbkRvd25MaW1pdCA9IGl0ZW0uY291cG9uRG93bkxpbWl0O1xuICAgIHRoaXMuY291cG9uQ3VycmVuY3kgPSBpdGVtLmNvdXBvbkN1cnJlbmN5O1xuICAgIHRoaXMuc2V0QXB5KGl0ZW0uYXB5KTtcbiAgICB0aGlzLmNvdXBvblRlcm0gPSBpdGVtLmNvdXBvblRlcm07XG4gICAgdGhpcy5jb3Vwb25DdXJyZW5jeSA9IGl0ZW0uY291cG9uQ3VycmVuY3k7XG4gICAgdGhpcy5pbmRleCA9IGl0ZW0uaW5kZXg7XG4gICAgdGhpcy5iZWdpblRpbWUgPSBpdGVtLmJlZ2luVGltZTtcbiAgICB0aGlzLnNldEVuZFRpbWUoaXRlbS5lbmRUaW1lKTtcbiAgICB0aGlzLmltZ1NlbGVjdG9yID0gaXRlbS5pbWdTZWxlY3RvcjtcbiAgICB0aGlzLnNldEFwcGVuZFRleHQoKTtcbiAgICB0aGlzLnNob3dIaWd0ZXN0ID0gaXRlbS5zaG93SGlndGVzdDtcbiAgICB0aGlzLmlkID0gaXRlbS5pZDtcbiAgICB0aGlzLmNvdXBvblNpZ24gPSBpdGVtLmNvdXBvblNpZ247XG4gICAgdGhpcy5kdWVUYWcgPSBpdGVtLmR1ZVRhZztcbiAgICB0aGlzLmR1ZVZpcyA9IGl0ZW0uZHVlVmlzO1xuICAgIHRoaXMudHlwZSA9IGl0ZW0udHlwZTtcbiAgfVxufVxuXG4kZGF0YS5jb3Vwb25MaXN0ID0ge1xuICBpc1Nob3c6IGZhbHNlLCAvL+W8ueahhuaYvumakFxuICBkaXNhYmxlZFJlYXNvblZpczogXCJnb25lXCIsIC8v5Yqg5oGv5Yi45LiN5Y+v55So5Y6f5Zug5pi+6ZqQXG4gIGRpc2FibGVkUmVhc29uOiBcIlwiLCAvL+WKoOaBr+WIuOS4jeWPr+eUqOWOn+WboFxuICBpdGVtczogW10sIC8v5Yqg5oGv5Yi45YiX6KGo5pWw5o2uPENvbnBvbkxpc3RJdGVtPlxuXG4gIGl0ZW1CZ0NvbG9yOiBjb3Vwb25MaXN0UmVzLnVzYWJsZUJnQ29sb3IsIC8v5Yqg5oGv5Yi45YiX6KGoaXRlbeiDjOaZr+iJslxuICBpdGVtVGl0bGVDb2xvcjogY291cG9uTGlzdFJlcy51c2FibGVUaXRsZUNvbG9yLCAvL+WKoOaBr+WIuOWIl+ihqOagh+mimOWtl+S9k+minOiJslxuICBpdGVtVmFsQ29sb3I6IGNvdXBvbkxpc3RSZXMudXNhYmxlVmFsQ29sb3IsIC8v5Yqg5oGv5Yi45YiX6KGo5pyJ5pWI5pyf5a2X5L2T6aKc6ImyXG4gIGR1ZVRpdGxlOiAkaTE4bi5uX3NpbXBsZV9lYXJuX2R1ZSwgLy/ljbPlsIbliLDmnJ/moIfpophcbn07XG5cbmZ1bmN0aW9uIGdldERlZmF1bHREYXRhKCkge1xuICByZXR1cm4ge1xuICAgIGl0ZW1zOiBbXSxcbiAgICAvL+WKoOaBr+WIuOmAieS4ree0ouW8le+8mi0x5Luj6KGo5Yqg5oGv5Yi45rKh5pyJ5oiW6ICF5LiN5Y+v55SoXG4gICAgY291cG9uSW5kZXg6IC0xLFxuICAgIC8v5Yqg5oGv5Yi45by55qGG5piv5ZCm5Y+v55SoXG4gICAgZW5hYmxlRGlhbG9nOiBmYWxzZSxcbiAgICAvL+aYr+WQpumAieaLqei/h+WKoOaBr+WIuFxuICAgIGlzU2VsZWN0ZWRDb3Vwb25MaXN0OiBmYWxzZSxcbiAgICAvL+Wxleekuuexu+Wei++8mjEgLSDlj6/nlKjvvJsyIC0g5LiN5Y+v55SoXG4gICAgc2hvd1R5cGU6IDAsXG4gIH07XG59XG5cbnZhciBjdXJJbmRleCA9IC0xO1xuXG4kZXZlbnQuY291cG9uTGlzdCA9IHtcbiAgLyoqXG4gICAqIOWKoOaBr+WNt+WIl+ihqGl0ZW3ngrnlh7vkuovku7ZcbiAgICovXG4gIGl0ZW1DbGljazogZnVuY3Rpb24gKGluZGV4KSB7XG4gICAgY29uc29sZS5sb2coYGNvdXBvbkxpc3QgaXRlbUNsaWNrIGluZGV4ID0gJHtpbmRleH0gY3VySW5kZXg9ICR7Y3VySW5kZXh9YCk7XG4gICAgbGV0IGVsZW1lbnQgPSAkZGF0YS5ob21lLnNsaWRlckRhdGFbY3VySW5kZXhdO1xuICAgIGxldCBjb3Vwb25MaXN0RGF0YSA9IGVsZW1lbnQuY291cG9uTGlzdERhdGE7XG4gICAgaWYgKCFjb3Vwb25MaXN0RGF0YS5lbmFibGVEaWFsb2cpIHtcbiAgICAgIHJldHVybjtcbiAgICB9XG4gICAgY291cG9uTGlzdERhdGEuaXNTZWxlY3RlZENvdXBvbkxpc3QgPSB0cnVlO1xuICAgIGNvdXBvbkxpc3REYXRhLmNvdXBvbkluZGV4ID0gaW5kZXg7XG4gICAgc2hvd0NvdXBvbkxpc3RTZWxlY3QoaW5kZXgsIGNvdXBvbkxpc3REYXRhLCB0cnVlKTtcbiAgfSxcblxuICAvKipcbiAgICog6K6+572u5LiN5Y+v55So5Y6f5ZugXG4gICAqL1xuICBzZXREaXNhYmxlZFJlYXNvblRleHQ6IGZ1bmN0aW9uIChhcHkpIHtcbiAgICBsZXQgYXB5VGV4dCA9IGNvbW1vbi5mb3JtYXRQcmVjaXNpb24obnVtYmVyLm11bHRpcGx5KGFweSwgMTAwKSwgMik7XG4gICAgJGRhdGEuY291cG9uTGlzdC5kaXNhYmxlZFJlYXNvbiA9IGNvbW1vbi5hZGFwdGVyUGVyY2VudEZsYWcoXG4gICAgICAkaTE4bi4kaW50ZXJjZXB0Lm5fc2ltcGxlX2Vhcm5fZGlzYWJsZWRfcmVhc29uKGAke2FweVRleHR9YClcbiAgICApO1xuICB9LFxuXG4gIC8qKlxuICAgKiDnoa7lrprngrnlh7vkuovku7ZcbiAgICovXG4gIGNvbmZpcm06IGZ1bmN0aW9uICgpIHtcbiAgICBsZXQgZWxlbWVudCA9ICRkYXRhLmhvbWUuc2xpZGVyRGF0YVtjdXJJbmRleF07XG4gICAgbGV0IGNvdXBvbkxpc3REYXRhID0gZWxlbWVudC5jb3Vwb25MaXN0RGF0YTtcbiAgICBpZiAoIWNvdXBvbkxpc3REYXRhLmVuYWJsZURpYWxvZykge1xuICAgICAgJGRhdGEuY291cG9uTGlzdC5pc1Nob3cgPSBmYWxzZTtcbiAgICAgIHJldHVybjtcbiAgICB9XG4gICAgaWYgKGNvdXBvbkxpc3REYXRhLmNvdXBvbkluZGV4ID09IC0xKSB7XG4gICAgICBzaG93Q291cG9uT25lTGluZShlbGVtZW50LCB0cnVlLCAkaTE4bi5uX3NpbXBsZV9lYXJuX25vdF91c2VfY291cG9uKTtcbiAgICB9IGVsc2Uge1xuICAgICAgc2hvd0NvdXBvbkxpbmUoZWxlbWVudCk7XG4gICAgfVxuICAgIGN1ckluZGV4ID0gLTE7XG4gICAgJGRhdGEuY291cG9uTGlzdC5pc1Nob3cgPSBmYWxzZTtcbiAgfSxcblxuICAvKipcbiAgICog5omT5byA5YiX6KGo5by55qGG55qE5pe25YCZ5bCG55So5Yiw55qE5pWw5o2u5Lyg6YCS6L+H5p2lXG4gICAqL1xuICBvcGVuRGlhbG9nOiBmdW5jdGlvbiAoaW5kZXgpIHtcbiAgICBjb25zb2xlLmxvZyhgJHt0YWd9IG9wZW5EaWFsb2cgaW5kZXg9ICR7aW5kZXh9IGxlbmd0aD0gJHskZGF0YS5ob21lLnNsaWRlckRhdGEubGVuZ3RofWApO1xuICAgIGxldCBlbGVtZW50ID0gJGRhdGEuaG9tZS5zbGlkZXJEYXRhW2luZGV4XTtcbiAgICBjdXJJbmRleCA9IGluZGV4O1xuICAgIGNvbnNvbGUubG9nKGAke3RhZ30gb3BlbkRpYWxvZyBlbGVtZW50PSAke0pTT04uc3RyaW5naWZ5KGVsZW1lbnQpfWApO1xuICAgIGNvbnNvbGUubG9nKGAke3RhZ30gb3BlbkRpYWxvZyBjb3Vwb25MaXN0RGF0YT0gJHtKU09OLnN0cmluZ2lmeShlbGVtZW50LmNvdXBvbkxpc3REYXRhKX1gKTtcbiAgICBsZXQgY291cG9uTGlzdERhdGEgPSBlbGVtZW50LmNvdXBvbkxpc3REYXRhO1xuICAgIGxldCB1c2luZ0NvdXBvbiA9IGVsZW1lbnQudXNpbmdDb3Vwb247XG4gICAgaWYgKGVsZW1lbnQuY291cG9uUmlnaHRJbWdWaXMgPT0gXCJnb25lXCIpIHtcbiAgICAgIHJldHVybjtcbiAgICB9XG4gICAgLy/mr4/mrKHlkK/liqjpg73ph43mlrDotYvlgLxcbiAgICAkZGF0YS5jb3Vwb25MaXN0Lml0ZW1zID0gY291cG9uTGlzdERhdGEuaXRlbXM7XG4gICAgaWYgKGVsZW1lbnQuY291cG9uTGlzdERhdGEuc2hvd1R5cGUgPT0gMSkge1xuICAgICAgLy8xIC0g5Y+v55SoXG4gICAgICBzaG93Q291cG9uTGlzdFVzYWJsZSgpO1xuICAgICAgc2hvd0NvdXBvbkxpc3RTZWxlY3QoY291cG9uTGlzdERhdGEuY291cG9uSW5kZXgsIGNvdXBvbkxpc3REYXRhLCBmYWxzZSk7XG4gICAgfSBlbHNlIGlmIChlbGVtZW50LmNvdXBvbkxpc3REYXRhLnNob3dUeXBlID09IDIpIHtcbiAgICAgIC8vMiAtIOS4jeWPr+eUqFxuICAgICAgc2hvd0NvdXBvbkxpc3REaXNhYmxlKHVzaW5nQ291cG9uLmFweSk7XG4gICAgICBzaG93Q291cG9uTGlzdFNlbGVjdCgtMSwgY291cG9uTGlzdERhdGEsIGZhbHNlKTtcbiAgICB9XG4gICAgJGRhdGEuY291cG9uTGlzdC5pc1Nob3cgPSB0cnVlO1xuICB9LFxuXG4gIGNsb3NlRGlhbG9nOiBmdW5jdGlvbiAoKSB7XG4gICAgY3VySW5kZXggPSAtMTtcbiAgICAkZGF0YS5jb3Vwb25MaXN0LmlzU2hvdyA9IGZhbHNlO1xuICB9LFxufTtcblxuLyoqXG4gKiDojrflj5bliqDmga/liLjliJfooajmlbDmja5cbiAqIHY0L3NhdmluZy9taW5pbmcvcHJvamVjdC9idXkvbWVyZ2UvY291cG9uc1xuICovXG5leHBvcnQgZnVuY3Rpb24gZ2V0Q291cG9uRGF0YShlbGVtZW50LCBvcmlnaW5Db3Vwb25EYXRhKSB7XG4gIGxldCBwcm9qZWN0SWQgPSBlbGVtZW50LnByb2plY3RJZDtcbiAgbGV0IHVzaW5nQ291cG9uID0gZWxlbWVudC51c2luZ0NvdXBvbjtcbiAgbGV0IGNvdXBvbkxpc3REYXRhID0gZ2V0RGVmYXVsdERhdGEoKTtcblxuICBjb25zdCBkYXRhID0gb3JpZ2luQ291cG9uRGF0YTtcbiAgY29uc29sZS5sb2coYCR7dGFnfSBnZXRDb3Vwb25EYXRhIGRhdGEgPSAke0pTT04uc3RyaW5naWZ5KGRhdGEpfWApO1xuICBpZiAoZGF0YSAhPSBudWxsKSB7XG4gICAgY29uc29sZS5sb2coYCR7dGFnfSBnZXRDb3Vwb25EYXRhIGVsZW1lbnQgPSAke0pTT04uc3RyaW5naWZ5KGVsZW1lbnQpfWApO1xuXG4gICAgbGV0IGNsaXN0ID0gaXNFbXB0eU9iamVjdChkYXRhKSB8fCBkYXRhLmNvdXBvbnNNYXBbcHJvamVjdElkXSA9PSBudWxsID8gW10gOiBkYXRhLmNvdXBvbnNNYXBbcHJvamVjdElkXTtcbiAgICBjb25zb2xlLmxvZyhgJHt0YWd9IGdldENvdXBvbkRhdGEgY2xpc3QgPSAke0pTT04uc3RyaW5naWZ5KGNsaXN0KX0gdXNpbmdDb3Vwb24gPSAke0pTT04uc3RyaW5naWZ5KHVzaW5nQ291cG9uKX1gKTtcbiAgICAvL+WKoOaBr+WIuOmAu+i+kVxuICAgIGlmIChpc0VtcHR5T2JqZWN0KHVzaW5nQ291cG9uKSAmJiBjbGlzdC5sZW5ndGggPT0gMCkge1xuICAgICAgY29uc29sZS5sb2coYCR7dGFnfSBnZXRDb3Vwb25EYXRhIHVzaW5nQ291cG9uID09IG51bGwgJiYgY2xpc3QubGVuZ3RoID09IDBgKTtcbiAgICAgIC8v5pSv5oyB5Yqg5oGv5Yi477yM5L2G6aG555uu5rKh5pyJ5Yqg5oGv5Yi4XG4gICAgICBjb3Vwb25MaXN0RGF0YS5lbmFibGVEaWFsb2cgPSBmYWxzZTtcbiAgICAgIHNob3dDb3Vwb25PbmVMaW5lKGVsZW1lbnQsIGZhbHNlLCAkaTE4bi5uX3NpbXBsZV9lYXJuX3VuYXZhaWxhYmxlKTtcbiAgICB9IGVsc2UgaWYgKCFpc0VtcHR5T2JqZWN0KHVzaW5nQ291cG9uKSkge1xuICAgICAgY29uc29sZS5sb2coYCR7dGFnfSBnZXRDb3Vwb25EYXRhIHVzaW5nQ291cG9uICE9IG51bGwgJHtjbGlzdC5sZW5ndGh9YCk7XG4gICAgICBpZiAoY2xpc3QubGVuZ3RoID09IDApIHtcbiAgICAgICAgLy/liJfooajkuLrnqbrvvIzkuIDoiKx1c2luZ0NvdXBvbuS4jeS4uuepuuaYr+WIl+ihqOS5n+S4jeS4uuepuu+8jOatpOWkhOWBmuS4gOS4quWFnOW6lVxuICAgICAgICBjb3Vwb25MaXN0RGF0YS5lbmFibGVEaWFsb2cgPSBmYWxzZTtcbiAgICAgICAgc2hvd0NvdXBvbk9uZUxpbmUoZWxlbWVudCwgZmFsc2UsICRpMThuLm5fc2ltcGxlX2Vhcm5fdW5hdmFpbGFibGUpO1xuICAgICAgfSBlbHNlIHtcbiAgICAgICAgLy/liqDmga/liLjliJfooajmlbDmja7lsZXnpLpcbiAgICAgICAgY291cG9uTGlzdERhdGEuaXRlbXMgPSBoYW5kbGVDb3Vwb25MaXN0KGNsaXN0LCBlbGVtZW50KTtcbiAgICAgICAgY29uc29sZS5sb2coYCR7dGFnfSBnZXRDb3Vwb25EYXRhIDEgaXRlbXMgPSAke0pTT04uc3RyaW5naWZ5KCRkYXRhLmNvdXBvbkxpc3QuaXRlbXMpfWApO1xuICAgICAgICAvL+acieWKoOaBr+WIuO+8jOS9huS4jeWPr+eUqFxuICAgICAgICBjb3Vwb25MaXN0RGF0YS5lbmFibGVEaWFsb2cgPSBmYWxzZTtcbiAgICAgICAgc2hvd0NvdXBvbk9uZUxpbmUoZWxlbWVudCwgdHJ1ZSwgJGkxOG4ubl9zaW1wbGVfZWFybl91bmF2YWlsYWJsZSk7XG4gICAgICAgIGNvdXBvbkxpc3REYXRhLnNob3dUeXBlID0gMjtcbiAgICAgIH1cbiAgICB9IGVsc2Uge1xuICAgICAgY29uc29sZS5sb2coYCR7dGFnfSBnZXRDb3Vwb25EYXRhIGNsaXN0ID4gMGApO1xuICAgICAgLy/mnInliqDmga/liLjlj6/nlKjvvIzpu5jorqTlj5bnrKzkuIDkuKpcbiAgICAgIGNvdXBvbkxpc3REYXRhLmNvdXBvbkluZGV4ID0gMDtcbiAgICAgIGxldCB0ZW1wID0gaGFuZGxlQ291cG9uTGlzdChjbGlzdCwgZWxlbWVudCk7XG4gICAgICBjb25zb2xlLmxvZyhgJHt0YWd9IGdldENvdXBvbkRhdGEgMiB0ZW1wID0gJHtKU09OLnN0cmluZ2lmeSh0ZW1wKX1gKTtcbiAgICAgIGNvdXBvbkxpc3REYXRhLml0ZW1zID0gdGVtcDtcbiAgICAgIGNvbnNvbGUubG9nKGAke3RhZ30gZ2V0Q291cG9uRGF0YSAyIGNvdXBvbkxpc3QgPSAke0pTT04uc3RyaW5naWZ5KHRlbXBbMF0udGl0bGUpfWApO1xuICAgICAgbGV0IGl0ZW0gPSB0ZW1wW2NvdXBvbkxpc3REYXRhLmNvdXBvbkluZGV4XTtcbiAgICAgIGNvbnNvbGUubG9nKGAke3RhZ30gZ2V0Q291cG9uRGF0YSAyIGl0ZW0gPSAke2l0ZW0udGl0bGV9YCk7XG4gICAgICAvL+ayoeaciei+k+WFpeaIluiAheWwj+S6juWKoOaBr+WIuOi1t+aKleaVsOmHj+aXtu+8mjEwJSDliqDmga/liLgg5ruhIDEwMCBVU0RUIOWPr+eUqFxuICAgICAgY291cG9uTGlzdERhdGEuZW5hYmxlRGlhbG9nID0gdHJ1ZTtcbiAgICAgIHNob3dDb3Vwb25Ud29MaW5lKGVsZW1lbnQsIGl0ZW0sIHRydWUpO1xuICAgICAgY291cG9uTGlzdERhdGEuc2hvd1R5cGUgPSAxO1xuICAgIH1cbiAgICBlbGVtZW50LmNvdXBvbkxpc3REYXRhID0gY291cG9uTGlzdERhdGE7XG4gICAgY29uc29sZS5sb2coYCR7dGFnfSBnZXRDb3Vwb25EYXRhIG92ZXIgJHtKU09OLnN0cmluZ2lmeShlbGVtZW50KX1gKTtcbiAgfSBlbHNlIHtcbiAgICBjb25zb2xlLmxvZyhgJHt0YWd9IGdldENvdXBvbkRhdGEgZXJyb3JgKTtcbiAgfVxufVxuXG5mdW5jdGlvbiBpc0VtcHR5T2JqZWN0KG9iaikge1xuICByZXR1cm4gSlNPTi5zdHJpbmdpZnkob2JqKSA9PT0gXCJ7fVwiO1xufVxuXG5mdW5jdGlvbiBoYW5kbGVDb3Vwb25MaXN0KGxpc3QsIGVsZW1lbnQpIHtcbiAgY29uc29sZS5sb2coYCR7dGFnfSBoYW5kbGVDb3Vwb25MaXN0IGJlZ2luIGxpc3QgPSAke0pTT04uc3RyaW5naWZ5KGxpc3QpfWApO1xuICBjb3Vwb25Db21wYXJlLnN1YkludCA9IDA7XG4gIGNvdXBvbkNvbXBhcmUudXNlckludmVzdEFtdCA9IGVsZW1lbnQudXNlckludmVzdEFtdDtcbiAgbGlzdC5zb3J0KGNvdXBvbkNvbXBhcmUpO1xuICBjb25zb2xlLmxvZyhgJHt0YWd9IGhhbmRsZUNvdXBvbkxpc3QgYWZ0ZXIgc29ydCBsaXN0ID0gJHtKU09OLnN0cmluZ2lmeShsaXN0KX1gKTtcbiAgbGV0IGFucyA9IFtdO1xuICBmb3IgKGxldCBpID0gMDsgaSA8IGxpc3QubGVuZ3RoOyBpKyspIHtcbiAgICBsZXQgaXRlbSA9IGxpc3RbaV07XG4gICAgbGV0IHRlbXAgPSBuZXcgQ29ucG9uTGlzdEl0ZW0oKTtcbiAgICB0ZW1wLnRpdGxlID0gaXRlbS50aXRsZTtcbiAgICB0ZW1wLmNvdXBvblVwTGltaXQgPSBpdGVtLmNvdXBvblVwTGltaXQ7XG4gICAgdGVtcC5jb3Vwb25Eb3duTGltaXQgPSBpdGVtLmNvdXBvbkRvd25MaW1pdDtcbiAgICB0ZW1wLmNvdXBvbkN1cnJlbmN5ID0gaXRlbS5jb3Vwb25DdXJyZW5jeTtcbiAgICB0ZW1wLnNldEFweShpdGVtLmFweSk7XG4gICAgdGVtcC5jb3Vwb25UZXJtID0gaXRlbS5jb3Vwb25UZXJtO1xuICAgIHRlbXAuYmVnaW5UaW1lID0gaXRlbS5iZWdpblRpbWU7XG4gICAgdGVtcC5zZXRFbmRUaW1lKGl0ZW0uZW5kVGltZSk7XG4gICAgdGVtcC5pZCA9IGl0ZW0uaWQ7XG4gICAgdGVtcC5jb3Vwb25TaWduID0gaXRlbS5jb3Vwb25TaWduO1xuICAgIHRlbXAuc2V0RHVlVGFnKGl0ZW0uZHVlVGFnKTtcblxuICAgIHRlbXAuaW5kZXggPSBpO1xuICAgIGlmIChpID09IDAgJiYgbGlzdC5sZW5ndGggPiAxKSB7XG4gICAgICB0ZW1wLnNob3dIaWd0ZXN0ID0gXCJ2aXNpYmxlXCI7XG4gICAgfSBlbHNlIHtcbiAgICAgIHRlbXAuc2hvd0hpZ3Rlc3QgPSBcImdvbmVcIjtcbiAgICB9XG4gICAgLy/mi7zmjqXmlofmoYjvvJrorqTotK3mu6EgMTAwIFVTRFQgfCDliqDmga/pop0gMTAwMCBVU0RUIHwg5Yqg5oGvMuWkqVxuICAgIHRlbXAuc2V0QXBwZW5kVGV4dCgpO1xuICAgIC8v5Y2V6YCJ5qGG77yaXG4gICAgLy8gdGVtcC5pbWdTZWxlY3RvciA9IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5fc2ltcGxlX2Vhcm5fY291cG9uX3Vuc2VsZWN0ZWRcIjtcbiAgICBhbnMucHVzaCh0ZW1wKTtcbiAgfVxuICBjb25zb2xlLmxvZyhgJHt0YWd9IGhhbmRsZUNvdXBvbkxpc3Qgb3ZlciAke0pTT04uc3RyaW5naWZ5KGFucyl9YCk7XG4gIHJldHVybiBhbnM7XG59XG5cbi8qKlxuICog5aSE55CG5Yqg5oGv5Y235YiX6KGo6YCJ5Lit5oCBXG4gKi9cbmZ1bmN0aW9uIHNob3dDb3Vwb25MaXN0U2VsZWN0KHNlbGVjdGVkSW5kZXgsIGNvdXBvbkxpc3REYXRhLCBpc0l0ZW1DbGljayA9IGZhbHNlKSB7XG4gIGNvbnNvbGUubG9nKGAke3RhZ30gc2hvd0NvdXBvbkxpc3RTZWxlY3QgYmVnaW4gc2VsZWN0ZWRJbmRleD0gJHtzZWxlY3RlZEluZGV4fWApO1xuICBmb3IgKHZhciBpID0gMDsgaSA8ICRkYXRhLmNvdXBvbkxpc3QuaXRlbXMubGVuZ3RoOyBpKyspIHtcbiAgICB2YXIgaXRlbSA9ICRkYXRhLmNvdXBvbkxpc3QuaXRlbXNbaV07XG4gICAgaWYgKHNlbGVjdGVkSW5kZXggPT0gLTEpIHtcbiAgICAgIGl0ZW0uaW1nU2VsZWN0b3IgPSBjb3Vwb25MaXN0UmVzLmRpc2FibGVJbWc7XG4gICAgfSBlbHNlIGlmIChzZWxlY3RlZEluZGV4ID09IGkpIHtcbiAgICAgIGlmIChpdGVtLmltZ1NlbGVjdG9yID09IGNvdXBvbkxpc3RSZXMuc2VsZWN0ZWRJbWcpIHtcbiAgICAgICAgaWYgKGlzSXRlbUNsaWNrKSB7XG4gICAgICAgICAgLy/lpoLmnpzmmK9pdGVt6Kem5Y+R55qE54K55Ye777yM5Y+v5Lul5omn6KGM5Y+W5raI6YCJ5Lit5oCBXG4gICAgICAgICAgaXRlbS5pbWdTZWxlY3RvciA9IGNvdXBvbkxpc3RSZXMudW5zZWxlY3RlZEltZztcbiAgICAgICAgICBjb3Vwb25MaXN0RGF0YS5jb3Vwb25JbmRleCA9IC0xO1xuICAgICAgICB9XG4gICAgICB9IGVsc2Uge1xuICAgICAgICBpdGVtLmltZ1NlbGVjdG9yID0gY291cG9uTGlzdFJlcy5zZWxlY3RlZEltZztcbiAgICAgIH1cbiAgICB9IGVsc2Uge1xuICAgICAgaXRlbS5pbWdTZWxlY3RvciA9IGNvdXBvbkxpc3RSZXMudW5zZWxlY3RlZEltZztcbiAgICB9XG4gIH1cbiAgY29uc29sZS5sb2coYCR7dGFnfSBzaG93Q291cG9uTGlzdFNlbGVjdCBlbmQgY291cG9uSW5kZXg9ICR7Y291cG9uTGlzdERhdGEuY291cG9uSW5kZXh9YCk7XG59XG5cbi8qKlxuICog5Yi35paw5Yqg5oGv5Yi4XG4gKi9cbmV4cG9ydCBmdW5jdGlvbiByZWZyZXNoQ291cG9uKHN1YkludCwgZWxlbWVudCkge1xuICBjb25zb2xlLmxvZyhgJHt0YWd9IHJlZnJlc2hDb3Vwb24gYmVnaW4gaW52b2tlIHN1YiA9ICR7c3ViSW50fSAke2VsZW1lbnQudXNlckludmVzdEFtdH1gKTtcbiAgbGV0IGNvdXBvbkxpc3REYXRhID0gZWxlbWVudC5jb3Vwb25MaXN0RGF0YTtcbiAgaWYgKCFjb3Vwb25MaXN0RGF0YS5lbmFibGVEaWFsb2cpIHtcbiAgICByZXR1cm47XG4gIH1cbiAgLy/msqHmnInpgInmi6nov4fvvIzku47mlrDorqHnrpfmjpLluo/vvIzpu5jorqTpgInkuK3nrKzkuIDkuKpcbiAgaWYgKCFjb3Vwb25MaXN0RGF0YS5pc1NlbGVjdGVkQ291cG9uTGlzdCkge1xuICAgIGxldCBvcmlJdGVtcyA9IGNvdXBvbkxpc3REYXRhLml0ZW1zO1xuICAgIGxldCBuZXdMaXN0ID0gW107XG4gICAgZm9yIChsZXQgaSA9IDA7IGkgPCBvcmlJdGVtcy5sZW5ndGg7IGkrKykge1xuICAgICAgY29uc29sZS5sb2coYCR7dGFnfSByZWZyZXNoQ291cG9uIGl0ZW0gPSAke0pTT04uc3RyaW5naWZ5KG9yaUl0ZW1zW2ldKX1gKTtcbiAgICAgIGxldCB0ZW1wID0gbmV3IENvbnBvbkxpc3RJdGVtKCk7XG4gICAgICB0ZW1wLmNvcHkob3JpSXRlbXNbaV0pO1xuICAgICAgbmV3TGlzdC5wdXNoKHRlbXApO1xuICAgIH1cbiAgICBjb25zb2xlLmxvZyhgJHt0YWd9IHJlZnJlc2hDb3Vwb24gYmVmb3Igc29ydCBuZXdMaXN0ID0gJHtKU09OLnN0cmluZ2lmeShuZXdMaXN0KX1gKTtcbiAgICBjb3Vwb25Db21wYXJlLnN1YkludCA9IHN1YkludDtcbiAgICBjb3Vwb25Db21wYXJlLnVzZXJJbnZlc3RBbXQgPSBlbGVtZW50LnVzZXJJbnZlc3RBbXQ7XG4gICAgbmV3TGlzdC5zb3J0KGNvdXBvbkNvbXBhcmUpO1xuICAgIC8v5o6S5bqP5ZCO6YeN5paw5L+u5pS56buY6K6k6YCJ5Lit5ZKM5pyA6auY5bGV56S6XG4gICAgZm9yIChsZXQgaSA9IDA7IGkgPCBuZXdMaXN0Lmxlbmd0aDsgaSsrKSB7XG4gICAgICBsZXQgdGVtcCA9IG5ld0xpc3RbaV07XG4gICAgICB0ZW1wLmluZGV4ID0gaTtcbiAgICAgIGlmIChpID09IDApIHtcbiAgICAgICAgaWYgKG9yaUl0ZW1zLmxlbmd0aCA+IDEpIHtcbiAgICAgICAgICB0ZW1wLnNob3dIaWd0ZXN0ID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgIH1cbiAgICAgICAgY291cG9uTGlzdERhdGEuY291cG9uSW5kZXggPSBpO1xuICAgICAgICB0ZW1wLmltZ1NlbGVjdG9yID0gY291cG9uTGlzdFJlcy5zZWxlY3RlZEltZztcbiAgICAgIH0gZWxzZSB7XG4gICAgICAgIHRlbXAuc2hvd0hpZ3Rlc3QgPSBcImdvbmVcIjtcbiAgICAgICAgdGVtcC5pbWdTZWxlY3RvciA9IGNvdXBvbkxpc3RSZXMudW5zZWxlY3RlZEltZztcbiAgICAgIH1cbiAgICB9XG4gICAgY29uc29sZS5sb2coYCR7dGFnfSByZWZyZXNoQ291cG9uIGFmdGVyIHNvcnQgbmV3TGlzdCA9ICR7SlNPTi5zdHJpbmdpZnkobmV3TGlzdCl9YCk7XG4gICAgY291cG9uTGlzdERhdGEuaXRlbXMgPSBuZXdMaXN0O1xuICB9XG4gIHNob3dDb3Vwb25MaW5lKGVsZW1lbnQpO1xuICBjb25zb2xlLmxvZyhgJHt0YWd9IHJlZnJlc2hDb3Vwb24gZW5kIGludm9rZWApO1xufVxuXG4vKipcbiAqIOWKoOaBr+WIuOWIl+ihqOavlOi+g1xuICovXG5mdW5jdGlvbiBjb3Vwb25Db21wYXJlKGMxLCBjMikge1xuICBsZXQgc3ViSW50ID0gY291cG9uQ29tcGFyZS5zdWJJbnQ7XG4gIGxldCB1c2VySW52ZXN0QW10ID0gY291cG9uQ29tcGFyZS51c2VySW52ZXN0QW10O1xuICBjb25zb2xlLmxvZyhgJHt0YWd9IGNvdXBvbkNvbXBhcmUgYmVnaW4gc3ViSW50PSAke3N1YkludH0gdXNlckludmVzdEFtdD0gJHt1c2VySW52ZXN0QW10fWApO1xuICBsZXQgYTEgPSBnZXRBbW91bnQoYzEsIHN1YkludCwgdXNlckludmVzdEFtdCk7XG4gIGxldCBhMiA9IGdldEFtb3VudChjMiwgc3ViSW50LCB1c2VySW52ZXN0QW10KTtcbiAgY29uc29sZS5sb2coYGExID0gJHthMX0gYTIgPSAke2EyfWApO1xuICBpZiAoYTEgPiBhMikge1xuICAgIHJldHVybiAtMTsgLy9jMSA+IGMyXG4gIH0gZWxzZSBpZiAoYTEgPCBhMikge1xuICAgIHJldHVybiAxOyAvL2MxIDwgYzJcbiAgfSBlbHNlIHtcbiAgICAvL+WKoOaBr+mHkemineebuOWQjOaXtu+8jOacieaViOacn+abtOi/keeahOWcqOS4iumdolxuICAgIGlmIChjMS5iZWdpblRpbWUgPiBjMi5iZWdpblRpbWUpIHtcbiAgICAgIHJldHVybiAtMTtcbiAgICB9IGVsc2UgaWYgKGMxLmJlZ2luVGltZSA8IGMyLmJlZ2luVGltZSkge1xuICAgICAgcmV0dXJuIDE7XG4gICAgfVxuICAgIHJldHVybiAwOyAvL+S9jee9ruS4jeWPmFxuICB9XG59XG5cbi8qKlxuICog5Yqg5oGv6YeR6aKdMiA9IG1pblvnlLPotK3mlbDph48r5bey6LSt5pWw6YePKSAsIOWKoOaBr+mineW6pl0geCDliqDmga/liLhBUFkgeCDliqDmga/lpKnmlbAvMzY1XG4gKi9cbmZ1bmN0aW9uIGdldEFtb3VudChjLCBzdWJJbnQsIHVzZXJJbnZlc3RBbXQpIHtcbiAgY29uc29sZS5sb2coYCR7dGFnfSBnZXRBbW91bnQgc3ViSW50PSAke3N1YkludH0gdXNlckludmVzdEFtdD0gJHt1c2VySW52ZXN0QW10fWApO1xuICBsZXQgbnVtID0gMDtcbiAgaWYgKHN1YkludCA9PSAwKSB7XG4gICAgbnVtID0gYy5jb3Vwb25VcExpbWl0O1xuICB9IGVsc2UgaWYoc3ViSW50ID49IGMuY291cG9uRG93bkxpbWl0KSB7XG4gICAgLy/lpoLmnpzovpPlhaXph5Hpop0g6L6+5YiwIOWKoOaBr+WIuOWPr+eUqOS4i+mZkO+8jOmcgOimgeS8mOWFiOS9v+eUqO+8jOaJgOS7peWcqOatpOWkmjEwMFxuICAgIG51bSA9IE1hdGgubWluKHVzZXJJbnZlc3RBbXQgKyBzdWJJbnQsIGMuY291cG9uVXBMaW1pdCkgKiAxMDA7XG4gIH0gZWxzZSB7XG4gICAgbnVtID0gTWF0aC5taW4odXNlckludmVzdEFtdCArIHN1YkludCwgYy5jb3Vwb25VcExpbWl0KTtcbiAgfVxuICByZXR1cm4gcGFyc2VGbG9hdChudW0pICogYy5hcHkgKiBjLmNvdXBvblRlcm07XG59XG5cbi8qKlxuICog5bGV56S65Lik6KGM5qC35byP55qE5Yqg5oGv5Yi4XG4gKi9cbmZ1bmN0aW9uIHNob3dDb3Vwb25MaW5lKGVsZW1lbnQpIHtcbiAgbGV0IG1TdWJJbnB1dCA9IGVsZW1lbnQubVN1YklucHV0O1xuICBsZXQgY291cG9uTGlzdCA9IGVsZW1lbnQuY291cG9uTGlzdERhdGE7XG4gIGNvbnNvbGUubG9nKGAke3RhZ30gc2hvd0NvdXBvbkxpbmUgJHttU3ViSW5wdXR9ICR7SlNPTi5zdHJpbmdpZnkoY291cG9uTGlzdCl9YCk7XG4gIGxldCBzdWJOdW0gPSBtU3ViSW5wdXQubGVuZ3RoID09IDAgPyAwIDogcGFyc2VGbG9hdChtU3ViSW5wdXQpO1xuICBjb25zb2xlLmxvZyhgc2hvd0NvdXBvbkxpbmUgc3ViTnVtPSAke3N1Yk51bX0gY291cG9uSW5kZXg9ICR7Y291cG9uTGlzdC5jb3Vwb25JbmRleH1gKTtcbiAgaWYgKGNvdXBvbkxpc3QuY291cG9uSW5kZXggPT0gLTEpIHtcbiAgICByZXR1cm47XG4gIH1cbiAgbGV0IGl0ZW0gPSBjb3Vwb25MaXN0Lml0ZW1zW2NvdXBvbkxpc3QuY291cG9uSW5kZXhdO1xuICBpZiAoc3ViTnVtIDwgaXRlbS5jb3Vwb25Eb3duTGltaXQpIHtcbiAgICAvL+WxleekuuS4pOihjO+8jOWSjOWIneWni+eKtuaAgeS4gOagt1xuICAgIHNob3dDb3Vwb25Ud29MaW5lKGVsZW1lbnQsIGl0ZW0sIHRydWUpO1xuICB9IGVsc2Uge1xuICAgIC8v5bGV56S65LiA6KGM77yaNTAgVVNEVCDlj6/liqDmga8xMCVcbiAgICBsZXQgbnVtID0gTWF0aC5taW4oc3ViTnVtLCBpdGVtLmNvdXBvblVwTGltaXQpO1xuICAgIHNob3dDb3Vwb25Ud29MaW5lKGVsZW1lbnQsIGl0ZW0sIGZhbHNlLCBudW0pO1xuICB9XG59XG5cbi8qKlxuICog5bGV56S65Lik6KGM5qC35byP55qE5Yqg5oGv5Yi4XG4gKi9cbmZ1bmN0aW9uIHNob3dDb3Vwb25Ud29MaW5lKGVsZW1lbnQsIGNvdXBvbiwgc2hvd0Rvd24gPSB0cnVlLCBtaW4gPSAwKSB7XG4gIGNvbnNvbGUubG9nKGAke3RhZ30gc2hvd0NvdXBvblR3b0xpbmUgc2hvd0Rvd249ICR7c2hvd0Rvd259IG1pbj0gJHttaW59ICR7SlNPTi5zdHJpbmdpZnkoZWxlbWVudCl9YCk7XG4gIGVsZW1lbnQuY291cG9uUmlnaHRJbWdWaXMgPSBcInZpc2libGVcIjtcbiAgZWxlbWVudC5jb3Vwb25UZXh0TWlkVmlzID0gXCJnb25lXCI7XG4gIGVsZW1lbnQuY291cG9uTWlkVmlzID0gXCJ2aXNpYmxlXCI7XG4gIGlmIChzaG93RG93bikge1xuICAgIC8vMTAlIOWKoOaBr+WIuCDmu6EgMTAwIFVTRFQg5Y+v55SoXG4gICAgZWxlbWVudC5jb3Vwb25UZXh0VXAgPSBjb21tb24uYWRhcHRlclBlcmNlbnRGbGFnKFxuICAgICAgJGkxOG4uJGludGVyY2VwdC5uX3NpbXBsZV9lYXJuX2NvdXBvbl91cF90d29fbGluZShgJHtjb21tb24uZm9ybWF0UHJlY2lzaW9uKG51bWJlci5tdWx0aXBseShjb3Vwb24uYXB5LCAxMDApLCAyKX1gKVxuICAgICk7XG4gICAgZWxlbWVudC5jb3Vwb25UZXh0RG93biA9ICRpMThuLiRpbnRlcmNlcHQubl9zaW1wbGVfZWFybl9jb3Vwb25fZG93bl90d29uX2xpbmUoYCR7Y291cG9uLmNvdXBvbkRvd25MaW1pdH1gLCBgJHskZGF0YS5ob21lLmN1cnJlbmN5fWApO1xuICAgIGVsZW1lbnQuY291cG9uVGV4dERvd25WaXMgPSBcInZpc2libGVcIjtcbiAgfSBlbHNlIHtcbiAgICAvLzUwIFVTRFQg5Y+v5Yqg5oGvMTAlXG4gICAgZWxlbWVudC5jb3Vwb25UZXh0VXAgPSBjb21tb24uYWRhcHRlclBlcmNlbnRGbGFnKFxuICAgICAgJGkxOG4uJGludGVyY2VwdC5uX3NpbXBsZV9lYXJuX2NvdXBvbl91cF9vbmVfbGluZShcbiAgICAgICAgYCR7bWlufWAsXG4gICAgICAgIGAkeyRkYXRhLmhvbWUuY3VycmVuY3l9YCxcbiAgICAgICAgYCR7Y29tbW9uLmZvcm1hdFByZWNpc2lvbihudW1iZXIubXVsdGlwbHkoY291cG9uLmFweSwgMTAwKSwgMil9YFxuICAgICAgKVxuICAgICk7XG4gICAgZWxlbWVudC5jb3Vwb25UZXh0RG93blZpcyA9IFwiZ29uZVwiO1xuICB9XG59XG5cbi8qKlxuICog5bGV56S65LiA6KGM5qC35byP55qE5Yqg5oGv5Yi4XG4gKi9cbmZ1bmN0aW9uIHNob3dDb3Vwb25PbmVMaW5lKGVsZW1lbnQsIHNob3dSaWdodCwgdGV4dCkge1xuICBjb25zb2xlLmxvZyhgJHt0YWd9IHNob3dDb3Vwb25PbmVMaW5lICR7c2hvd1JpZ2h0fSAke3RleHR9ICR7SlNPTi5zdHJpbmdpZnkoZWxlbWVudCl9YCk7XG4gIGVsZW1lbnQuY291cG9uUmlnaHRJbWdWaXMgPSBzaG93UmlnaHQgPyBcInZpc2libGVcIiA6IFwiZ29uZVwiO1xuICBlbGVtZW50LmNvdXBvbk1pZFZpcyA9IFwiZ29uZVwiO1xuICBlbGVtZW50LmNvdXBvblRleHRNaWQgPSBgJHt0ZXh0fWA7XG4gIGVsZW1lbnQuY291cG9uVGV4dE1pZFZpcyA9IFwidmlzaWJsZVwiO1xuICBjb25zb2xlLmxvZyhgJHt0YWd9IHNob3dDb3Vwb25PbmVMaW5lIG92ZXIgJHtzaG93UmlnaHR9ICR7dGV4dH0gJHtKU09OLnN0cmluZ2lmeShlbGVtZW50LmNvdXBvblRleHRNaWQpfWApO1xufVxuXG4vKipcbiAqIOWxleekuuWKoOaBr+WIuOWIl+ihqOWPr+eUqFxuICovXG5mdW5jdGlvbiBzaG93Q291cG9uTGlzdFVzYWJsZSgpIHtcbiAgJGRhdGEuY291cG9uTGlzdC5pdGVtQmdDb2xvciA9IGNvdXBvbkxpc3RSZXMudXNhYmxlQmdDb2xvcjtcbiAgJGRhdGEuY291cG9uTGlzdC5pdGVtVGl0bGVDb2xvciA9IGNvdXBvbkxpc3RSZXMudXNhYmxlVGl0bGVDb2xvcjtcbiAgJGRhdGEuY291cG9uTGlzdC5pdGVtVmFsQ29sb3IgPSBjb3Vwb25MaXN0UmVzLnVzYWJsZVZhbENvbG9yO1xuICAvL+makOiXj+S4jeWPr+eUqOWOn+WboFxuICAkZGF0YS5jb3Vwb25MaXN0LmRpc2FibGVkUmVhc29uVmlzID0gXCJnb25lXCI7XG59XG5cbi8qKlxuICog5bGV56S65Yqg5oGv5Yi45YiX6KGo5LiN5Y+v55SoXG4gKi9cbmZ1bmN0aW9uIHNob3dDb3Vwb25MaXN0RGlzYWJsZShhcHkpIHtcbiAgJGRhdGEuY291cG9uTGlzdC5pdGVtQmdDb2xvciA9IGNvdXBvbkxpc3RSZXMuZGlzYWJsZUJnQ29sb3I7XG4gICRkYXRhLmNvdXBvbkxpc3QuaXRlbVRpdGxlQ29sb3IgPSBjb3Vwb25MaXN0UmVzLmRpc2FibGVUaXRsZUNvbG9yO1xuICAkZGF0YS5jb3Vwb25MaXN0Lml0ZW1WYWxDb2xvciA9IGNvdXBvbkxpc3RSZXMuZGlzYWJsZVZhbENvbG9yO1xuICAvL+WxleekuuS4jeWPr+eUqOWOn+WboFxuICAkZXZlbnQuY291cG9uTGlzdC5zZXREaXNhYmxlZFJlYXNvblRleHQoYXB5KTtcbiAgJGRhdGEuY291cG9uTGlzdC5kaXNhYmxlZFJlYXNvblZpcyA9IFwidmlzaWJsZVwiO1xufVxuIiwiaW1wb3J0ICogYXMgY29tbW9uIGZyb20gXCIuL2NvbW1vblwiO1xuXG5jb25zdCB0YWcgPSBcInNpbXBsZV9lYXJuX2FuYWx5dGljc1wiO1xuXG5jb25zdCBrZXlUb2tlbiA9IFwidG9rZW5cIjtcbmNvbnN0IGtleVByb2plY3RUeXBlID0gXCJwcm9qZWN0VHlwZVwiO1xuY29uc3Qga2V5VGVybSA9IFwidGVybVwiO1xuY29uc3Qga2V5UHJvamVjdElkID0gXCJwcm9qZWN0SWRcIjtcbmNvbnN0IGtleUFweVR5cGUgPSBcImFweVR5cGVcIjtcbmNvbnN0IGtleURpc3BsYXlMYXVuY2hQb29sTGFiZWxPck5vdCA9IFwiZGlzcGxheUxhdW5jaFBvb2xMYWJlbE9yTm90XCI7XG5jb25zdCBrZXlQYWdlTG9hZFRpbWUgPSBcInBhZ2VMb2FkVGltZVwiO1xuY29uc3Qga2V5TmF0aW9uID0gXCJuYXRpb25cIjtcbi8vICDmmK/lkKbpppbmrKHliqDovb0gMSAtIHR1cmUsIDAgLSBmYWxzZVxuY29uc3Qga2V5Rmlyc3RMb2FkID0gXCJmaXJzdExvYWRpbmdPck5vdFwiOyBcblxuLy/pobnnm67nsbvlnosgbmV3VXNlcu+8iOaWsOaJi+S4k+S6q++8iVxuY29uc3QgcHROZXdVc2VyID0gXCJuZXdVc2VyXCI7XG4vL+mhueebruexu+WeiyBmbGV4aWJsZe+8iOa0u+acn++8iVxuY29uc3QgcHRGbGV4aWJsZSA9IFwiZmxleGlibGVcIjtcbi8v6aG555uu57G75Z6LIGZpeGVk77yI5a6a5pyf77yJXG5jb25zdCBwdEZpeGVkID0gXCJmaXhlZFwiO1xuLy/vvIhhcHnvvIjpnZ7luILlnLrljJbliKnnjofvvIlcbmNvbnN0IGF0QXB5ID0gXCJhcHlcIjtcbi8vbWFya2V0QXB577yI5biC5Zy65YyW5Yip546H77yJXG5jb25zdCBhdE1hcmtldEFweSA9IFwibWFya2V0QXB5XCI7XG5cbi8qKlxuICogQVBQLeeQhui0oi3nlLPotK3pobUt5oC75pud5YWJXHRhcHBfZWFybl9zdWJzY3JpYmVQYWdlX3Nob3dcbiAqL1xuZXhwb3J0IGZ1bmN0aW9uIHBhZ2VTaG93KGVsZW1lbnQsIGxvYWRUaW1lLCBpc0ZpcnN0VGltZSkge1xuICBjb25zb2xlLmxvZyhcbiAgICBgJHt0YWd9IHBhZ2VTaG93IHByb2plY3RJZD0gJHtlbGVtZW50LnByb2plY3RJZH0gdGVybT0gJHtlbGVtZW50LnRlcm19IHByb2R1Y3RUeXBlPSAke2VsZW1lbnQucHJvZHVjdFR5cGV9YFxuICApO1xuICBsZXQgcGFyYW1zID0ge1xuICAgIFtrZXlUb2tlbl06ICRkYXRhLmhvbWUuY3VycmVuY3ksXG4gICAgW2tleVRlcm1dOiBlbGVtZW50LnRlcm0sXG4gICAgW2tleVByb2plY3RJZF06IGVsZW1lbnQucHJvamVjdElkLFxuICAgIFtrZXlEaXNwbGF5TGF1bmNoUG9vbExhYmVsT3JOb3RdOiBlbGVtZW50LnRhZyA9PSA5ID8gMSA6IDAsXG4gICAgW2tleVBhZ2VMb2FkVGltZV06IGxvYWRUaW1lLFxuICAgIFtrZXlOYXRpb25dOiBjb21tb24uY29tbW9uRGF0YS5jb3VudHJ5SWQsXG4gICAgW2tleUZpcnN0TG9hZF06IGlzRmlyc3RUaW1lLFxuICB9O1xuICBpZiAoZWxlbWVudC5wcm9kdWN0VHlwZSA9PSAwKSB7XG4gICAgcGFyYW1zW2tleVByb2plY3RUeXBlXSA9IHB0RmxleGlibGU7XG4gICAgaWYgKGVsZW1lbnQuYXB5VHlwZSA9PSAwKSB7XG4gICAgICBwYXJhbXNba2V5QXB5VHlwZV0gPSBhdEFweTtcbiAgICB9IGVsc2UgaWYgKGVsZW1lbnQuYXB5VHlwZSA9PSAxKSB7XG4gICAgICBwYXJhbXNba2V5QXB5VHlwZV0gPSBhdE1hcmtldEFweTtcbiAgICB9XG4gIH0gZWxzZSBpZiAoZWxlbWVudC5wcm9kdWN0VHlwZSA9PSAxKSB7XG4gICAgaWYgKGVsZW1lbnQuZml4ZWRUeXBlID09IDAgfHwgZWxlbWVudC5maXhlZFR5cGUgPT0gMikge1xuICAgICAgcGFyYW1zW2tleVByb2plY3RUeXBlXSA9IHB0Rml4ZWQ7XG4gICAgfSBlbHNlIGlmIChlbGVtZW50LmZpeGVkVHlwZSA9PSAxKSB7XG4gICAgICBwYXJhbXNba2V5UHJvamVjdFR5cGVdID0gcHROZXdVc2VyO1xuICAgIH1cbiAgfVxuICBjb25zb2xlLmxvZyhgJHt0YWd9IHBhZ2VTaG93IHBhcmFtcz0gJHtKU09OLnN0cmluZ2lmeShwYXJhbXMpfWApO1xuICBjb21tb24uYW5hbHl0aWNzKFwiYXBwX2Vhcm5fc3Vic2NyaWJlUGFnZV9zaG93XCIsIHBhcmFtcyk7XG59XG5cbi8qKlxuICogQVBQLeeQhui0oi3nlLPotK3pobUt6L+U5Zue5oyJ6ZKuLeeCueWHu+S6i+S7tiBhcHBfZWFybl9zdWJzY3JpYmVQYWdlX3JldHVybl9jbGlja1xuICovXG5leHBvcnQgZnVuY3Rpb24gYmFja0NsaWNrKCkge1xuICBjb21tb24uYW5hbHl0aWNzKFwiYXBwX2Vhcm5fc3Vic2NyaWJlUGFnZV9yZXR1cm5fY2xpY2tcIiwgeyB0b2tlbjogJGRhdGEuaG9tZS5jdXJyZW5jeSB9KTtcbn1cblxuLyoqXG4gKiBBUFAt55CG6LSiLeeUs+i0remhtS3otYTph5HmnaXmupDlvLnnqpfmm53lhYkgQVBQX2ZsZXhpYmxlX3N1YnNjcmliZVBhZ2VfQ29uZmlybUZ1bmRTb3VyY2Vfc2hvd1xuICovXG5leHBvcnQgZnVuY3Rpb24gYXNzZXRTb3VyY2VEaWFsb2dTaG93KCkge1xuICBjb21tb24uYW5hbHl0aWNzKFwiQVBQX2ZsZXhpYmxlX3N1YnNjcmliZVBhZ2VfQ29uZmlybUZ1bmRTb3VyY2Vfc2hvd1wiKTtcbn1cblxuLyoqXG4gKiBBUFAt55CG6LSiLeeUs+i0remhtS3otYTph5HmnaXmupDlvLnnqpct56Gu6K6k5oyJ6ZKu54K55Ye7IEFQUF9mbGV4aWJsZV9zdWJzY3JpYmVQYWdlX0NvbmZpcm1GdW5kU291cmNlX0NvbmZpcm1CdXR0b25fY2xpY2tcbiAqL1xuZXhwb3J0IGZ1bmN0aW9uIGFzc2V0U291cmNlQ29uZmlybUJ0bkNsaWNrKCkge1xuICBjb21tb24uYW5hbHl0aWNzKFwiQVBQX2ZsZXhpYmxlX3N1YnNjcmliZVBhZ2VfQ29uZmlybUZ1bmRTb3VyY2VfQ29uZmlybUJ1dHRvbl9jbGlja1wiKTtcbn1cblxuLyoqXG4gKiBBUFAt55CG6LSiLeeUs+i0remhtS3otYTph5HmnaXmupDlvLnnqpctVVNEROeCueWHuyBBUFBfZmxleGlibGVfc3Vic2NyaWJlUGFnZV9Db25maXJtRnVuZFNvdXJjZV9VU0REX2NsaWNrXG4gKi9cbmV4cG9ydCBmdW5jdGlvbiBhc3NldFNvdXJjZVVTRERJdGVtQ2xpY2sob25Pck9mZikge1xuICBjb21tb24uYW5hbHl0aWNzKFwiQVBQX2ZsZXhpYmxlX3N1YnNjcmliZVBhZ2VfQ29uZmlybUZ1bmRTb3VyY2VfVVNERF9jbGlja1wiLCB7IHR5cGU6IG9uT3JPZmZ9KTtcbn1cblxuLyoqXG4gKiBBUFAt55CG6LSiLeeUs+i0remhtS3otYTph5HmnaXmupDlvLnnqpctVVNEVOeCueWHuyBBUFBfZmxleGlibGVfc3Vic2NyaWJlUGFnZV9Db25maXJtRnVuZFNvdXJjZV9VU0RUX2NsaWNrXG4gKi9cbmV4cG9ydCBmdW5jdGlvbiBhc3NldFNvdXJjZVVTRFRJdGVtQ2xpY2sob25Pck9mZikge1xuICBjb21tb24uYW5hbHl0aWNzKFwiQVBQX2ZsZXhpYmxlX3N1YnNjcmliZVBhZ2VfQ29uZmlybUZ1bmRTb3VyY2VfVVNEVF9jbGlja1wiLCB7IHR5cGU6IG9uT3JPZmZ9KTtcbn1cblxuLyoqXG4gKiBBUFAt55CG6LSiLeeUs+i0remhtS3pobXpnaLliqDovb3nirbmgIEgYXBwX2Vhcm5fc3Vic2NyaWJlUGFnZV9sb2FkU3RhdGVcbiAqL1xuZXhwb3J0IGZ1bmN0aW9uIGVhcm5QdXJjaGFzZUxvYWRTdGF0dXMoc3VjY2Vzc09yRmF1bHQpIHtcbiAgY29tbW9uLmFuYWx5dGljcyhcImFwcF9lYXJuX3N1YnNjcmliZVBhZ2VfbG9hZFN0YXRlXCIsIHsgcGFnZUxvYWRTdGF0ZTogc3VjY2Vzc09yRmF1bHR9KTtcbn1cblxuLyoqXG4gKiBBUFAt55CG6LSiLeeUs+i0remhtS3mnIDlpKfmjInpkq4t54K55Ye75LqL5Lu2XHRhcHBfZWFybl9zdWJzY3JpYmVQYWdlX21heF9jbGlja1xuICovXG5leHBvcnQgZnVuY3Rpb24gbWF4Q2xpY2soZWxlbWVudCkge1xuICBjb25zb2xlLmxvZyhcbiAgICBgJHt0YWd9IG1heENsaWNrIHByb2plY3RJZD0gJHtlbGVtZW50LnByb2plY3RJZH0gdGVybT0gJHtlbGVtZW50LnRlcm19IHByb2R1Y3RUeXBlPSAke2VsZW1lbnQucHJvZHVjdFR5cGV9IGBcbiAgKTtcbiAgbGV0IHBhcmFtcyA9IHtcbiAgICBba2V5VG9rZW5dOiAkZGF0YS5ob21lLmN1cnJlbmN5LFxuICAgIFtrZXlUZXJtXTogZWxlbWVudC50ZXJtLFxuICAgIFtrZXlQcm9qZWN0SWRdOiBlbGVtZW50LnByb2plY3RJZCxcbiAgICAvLyBba2V5UHJvamVjdFR5cGVdOiBcIlwiLFxuICB9O1xuICBpZiAoZWxlbWVudC5wcm9kdWN0VHlwZSA9PSAwKSB7XG4gICAgcGFyYW1zW2tleVByb2plY3RUeXBlXSA9IHB0RmxleGlibGU7XG4gIH0gZWxzZSBpZiAoZWxlbWVudC5wcm9kdWN0VHlwZSA9PSAxKSB7XG4gICAgaWYgKGVsZW1lbnQuZml4ZWRUeXBlID09IDAgfHwgZWxlbWVudC5maXhlZFR5cGUgPT0gMikge1xuICAgICAgcGFyYW1zW2tleVByb2plY3RUeXBlXSA9IHB0Rml4ZWQ7XG4gICAgfSBlbHNlIGlmIChlbGVtZW50LmZpeGVkVHlwZSA9PSAxKSB7XG4gICAgICBwYXJhbXNba2V5UHJvamVjdFR5cGVdID0gcHROZXdVc2VyO1xuICAgIH1cbiAgfVxuICBjb21tb24uYW5hbHl0aWNzKFwiYXBwX2Vhcm5fc3Vic2NyaWJlUGFnZV9tYXhfY2xpY2tcIiwgcGFyYW1zKTtcbn1cblxuLyoqXG4gKiBBUFAt55CG6LSiLeeUs+i0remhtS3kubDluIHmjInpkq4t54K55Ye75LqL5Lu2XHRhcHBfZWFybl9zdWJzY3JpYmVQYWdlX2J1eV9jbGlja1xuICogdG9kbyDnrYnkubDluIHlkozliJLovazmlbTnkIblkI7lho3ov5vooYzmt7vliqDlkozpqozor4FcbiAqL1xuZXhwb3J0IGZ1bmN0aW9uIGJ1eUNsaWNrKGVsZW1lbnQpIHtcbiAgY29uc29sZS5sb2coXG4gICAgYCR7dGFnfSBidXlDbGljayBwcm9qZWN0SWQ9ICR7ZWxlbWVudC5wcm9qZWN0SWR9IHRlcm09ICR7ZWxlbWVudC50ZXJtfSBwcm9kdWN0VHlwZT0gJHtlbGVtZW50LnByb2R1Y3RUeXBlfSBgXG4gICk7XG4gIGxldCBwYXJhbXMgPSB7XG4gICAgW2tleVRva2VuXTogJGRhdGEuaG9tZS5jdXJyZW5jeSxcbiAgICBba2V5VGVybV06IGVsZW1lbnQudGVybSxcbiAgICBba2V5UHJvamVjdElkXTogZWxlbWVudC5wcm9qZWN0SWQsXG4gICAgLy8gW2tleVByb2plY3RUeXBlXTogXCJcIixcbiAgfTtcbiAgaWYgKGVsZW1lbnQucHJvZHVjdFR5cGUgPT0gMCkge1xuICAgIHBhcmFtc1trZXlQcm9qZWN0VHlwZV0gPSBwdEZsZXhpYmxlO1xuICB9IGVsc2UgaWYgKGVsZW1lbnQucHJvZHVjdFR5cGUgPT0gMSkge1xuICAgIGlmIChlbGVtZW50LmZpeGVkVHlwZSA9PSBcIjBcIiB8fCBlbGVtZW50LmZpeGVkVHlwZSA9PSBcIjJcIikge1xuICAgICAgcGFyYW1zW2tleVByb2plY3RUeXBlXSA9IHB0Rml4ZWQ7XG4gICAgfSBlbHNlIGlmIChlbGVtZW50LmZpeGVkVHlwZSA9PSBcIjFcIikge1xuICAgICAgcGFyYW1zW2tleVByb2plY3RUeXBlXSA9IHB0TmV3VXNlcjtcbiAgICB9XG4gIH1cbiAgY29tbW9uLmFuYWx5dGljcyhcImFwcF9lYXJuX3N1YnNjcmliZVBhZ2VfYnV5X2NsaWNrXCIsIHBhcmFtcyk7XG59XG5cbi8qKlxuICogQVBQLeeQhui0oi3nlLPotK3pobUt5YiS6L2s5oyJ6ZKuLeeCueWHu+S6i+S7tlx0YXBwX2Vhcm5fc3Vic2NyaWJlUGFnZV90cmFuc2Zlcl9jbGlja1xuICovXG5leHBvcnQgZnVuY3Rpb24gdHJhbnNmZXJDbGljayhlbGVtZW50KSB7XG4gIGNvbnNvbGUubG9nKFxuICAgIGAke3RhZ30gdHJhbnNmZXJDbGljayBwcm9qZWN0SWQ9ICR7ZWxlbWVudC5wcm9qZWN0SWR9IHRlcm09ICR7ZWxlbWVudC50ZXJtfSBwcm9kdWN0VHlwZT0gJHtlbGVtZW50LnByb2R1Y3RUeXBlfSBgXG4gICk7XG4gIGxldCBwYXJhbXMgPSB7XG4gICAgW2tleVRva2VuXTogJGRhdGEuaG9tZS5jdXJyZW5jeSxcbiAgICBba2V5VGVybV06IGVsZW1lbnQudGVybSxcbiAgICBba2V5UHJvamVjdElkXTogZWxlbWVudC5wcm9qZWN0SWQsXG4gICAgLy8gW2tleVByb2plY3RUeXBlXTogXCJcIixcbiAgfTtcbiAgaWYgKGVsZW1lbnQucHJvZHVjdFR5cGUgPT0gMCkge1xuICAgIHBhcmFtc1trZXlQcm9qZWN0VHlwZV0gPSBwdEZsZXhpYmxlO1xuICB9IGVsc2UgaWYgKGVsZW1lbnQucHJvZHVjdFR5cGUgPT0gMSkge1xuICAgIGlmIChlbGVtZW50LmZpeGVkVHlwZSA9PSAwIHx8IGVsZW1lbnQuZml4ZWRUeXBlID09IDIpIHtcbiAgICAgIHBhcmFtc1trZXlQcm9qZWN0VHlwZV0gPSBwdEZpeGVkO1xuICAgIH0gZWxzZSBpZiAoZWxlbWVudC5maXhlZFR5cGUgPT0gMSkge1xuICAgICAgcGFyYW1zW2tleVByb2plY3RUeXBlXSA9IHB0TmV3VXNlcjtcbiAgICB9XG4gIH1cbiAgY29tbW9uLmFuYWx5dGljcyhcImFwcF9lYXJuX3N1YnNjcmliZVBhZ2VfdHJhbnNmZXJfY2xpY2tcIiwgcGFyYW1zKTtcbn1cblxuLyoqXG4gKiBBUFAt55CG6LSiLeeUs+i0remhtS3liankvZnlj6/mipXop6Pph4ot54K55Ye75LqL5Lu2XHRhcHBfZWFybl9zdWJzY3JpYmVQYWdlX3Jlc3RFeHBsYWluX2NsaWNrXG4gKi9cbmV4cG9ydCBmdW5jdGlvbiByZXN0RXhwbGFpbkNsaWNrKGVsZW1lbnQpIHtcbiAgY29uc29sZS5sb2coXG4gICAgYCR7dGFnfSByZXN0RXhwbGFpbkNsaWNrIHByb2plY3RJZD0gJHtlbGVtZW50LnByb2plY3RJZH0gdGVybT0gJHtlbGVtZW50LnRlcm19IHByb2R1Y3RUeXBlPSAke2VsZW1lbnQucHJvZHVjdFR5cGV9YFxuICApO1xuICBsZXQgcGFyYW1zID0ge1xuICAgIFtrZXlUb2tlbl06ICRkYXRhLmhvbWUuY3VycmVuY3ksXG4gICAgW2tleVRlcm1dOiBlbGVtZW50LnRlcm0sXG4gICAgW2tleVByb2plY3RJZF06IGVsZW1lbnQucHJvamVjdElkLFxuICAgIC8vIFtrZXlQcm9qZWN0VHlwZV06IFwiXCIsXG4gIH07XG4gIGlmIChlbGVtZW50LnByb2R1Y3RUeXBlID09IDApIHtcbiAgICBwYXJhbXNba2V5UHJvamVjdFR5cGVdID0gcHRGbGV4aWJsZTtcbiAgfSBlbHNlIGlmIChlbGVtZW50LnByb2R1Y3RUeXBlID09IDEpIHtcbiAgICBpZiAoZWxlbWVudC5maXhlZFR5cGUgPT0gMCB8fCBlbGVtZW50LmZpeGVkVHlwZSA9PSAyKSB7XG4gICAgICBwYXJhbXNba2V5UHJvamVjdFR5cGVdID0gcHRGaXhlZDtcbiAgICB9IGVsc2UgaWYgKGVsZW1lbnQuZml4ZWRUeXBlID09IDEpIHtcbiAgICAgIHBhcmFtc1trZXlQcm9qZWN0VHlwZV0gPSBwdE5ld1VzZXI7XG4gICAgfVxuICB9XG4gIGNvbW1vbi5hbmFseXRpY3MoXCJhcHBfZWFybl9zdWJzY3JpYmVQYWdlX3Jlc3RFeHBsYWluX2NsaWNrXCIsIHBhcmFtcyk7XG59XG5cbi8qKlxuICogQVBQLeeQhui0oi3nlLPotK3pobUt5Yqg5oGv5Yi46Kej6YeKLeeCueWHu+S6i+S7tlx0YXBwX2Vhcm5fc3Vic2NyaWJlUGFnZV9jb3Vwb25FeHBsYWluX2NsaWNrXG4gKi9cbmV4cG9ydCBmdW5jdGlvbiBjb3Vwb25FeHBsYWluQ2xpY2soZWxlbWVudCkge1xuICBjb25zb2xlLmxvZyhcbiAgICBgJHt0YWd9IGNvdXBvbkV4cGxhaW5DbGljayBwcm9qZWN0SWQ9ICR7ZWxlbWVudC5wcm9qZWN0SWR9IHRlcm09ICR7ZWxlbWVudC50ZXJtfSBwcm9kdWN0VHlwZT0gJHtlbGVtZW50LnByb2R1Y3RUeXBlfSBgXG4gICk7XG4gIGxldCBwYXJhbXMgPSB7XG4gICAgW2tleVRva2VuXTogJGRhdGEuaG9tZS5jdXJyZW5jeSxcbiAgICBba2V5VGVybV06IGVsZW1lbnQudGVybSxcbiAgICBba2V5UHJvamVjdElkXTogZWxlbWVudC5wcm9qZWN0SWQsXG4gICAgLy8gW2tleVByb2plY3RUeXBlXTogXCJcIixcbiAgfTtcbiAgaWYgKGVsZW1lbnQucHJvZHVjdFR5cGUgPT0gMCkge1xuICAgIHBhcmFtc1trZXlQcm9qZWN0VHlwZV0gPSBwdEZsZXhpYmxlO1xuICB9IGVsc2UgaWYgKGVsZW1lbnQucHJvZHVjdFR5cGUgPT0gMSkge1xuICAgIGlmIChlbGVtZW50LmZpeGVkVHlwZSA9PSAwIHx8IGVsZW1lbnQuZml4ZWRUeXBlID09IDIpIHtcbiAgICAgIHBhcmFtc1trZXlQcm9qZWN0VHlwZV0gPSBwdEZpeGVkO1xuICAgIH0gZWxzZSBpZiAoZWxlbWVudC5maXhlZFR5cGUgPT0gMSkge1xuICAgICAgcGFyYW1zW2tleVByb2plY3RUeXBlXSA9IHB0TmV3VXNlcjtcbiAgICB9XG4gIH1cbiAgY29tbW9uLmFuYWx5dGljcyhcImFwcF9lYXJuX3N1YnNjcmliZVBhZ2VfY291cG9uRXhwbGFpbl9jbGlja1wiLCBwYXJhbXMpO1xufVxuXG4vKipcbiAqIEFQUC3nkIbotKIt55Sz6LSt6aG1LeWIsOi0puaXpeino+mHiuWPueWPty3ngrnlh7vkuovku7ZcdGFwcF9lYXJuX3N1YnNjcmliZVBhZ2VfYXJyaXZhbERhdGVfY2xpY2tcbiAqL1xuZXhwb3J0IGZ1bmN0aW9uIGFycml2YWxEYXRlQ2xpY2soZWxlbWVudCkge1xuICBjb25zb2xlLmxvZyhcbiAgICBgJHt0YWd9IGFycml2YWxEYXRlQ2xpY2sgcHJvamVjdElkPSAke2VsZW1lbnQucHJvamVjdElkfSB0ZXJtPSAke2VsZW1lbnQudGVybX0gcHJvZHVjdFR5cGU9ICR7ZWxlbWVudC5wcm9kdWN0VHlwZX0gYFxuICApO1xuICBsZXQgcGFyYW1zID0ge1xuICAgIFtrZXlUb2tlbl06ICRkYXRhLmhvbWUuY3VycmVuY3ksXG4gICAgW2tleVRlcm1dOiBlbGVtZW50LnRlcm0sXG4gICAgW2tleVByb2plY3RJZF06IGVsZW1lbnQucHJvamVjdElkLFxuICAgIC8vIFtrZXlQcm9qZWN0VHlwZV06IFwiXCIsXG4gICAgLy8gW2tleUFweVR5cGVdOiBcIlwiLFxuICB9O1xuICBpZiAoZWxlbWVudC5wcm9kdWN0VHlwZSA9PSAwKSB7XG4gICAgcGFyYW1zW2tleVByb2plY3RUeXBlXSA9IHB0RmxleGlibGU7XG4gICAgaWYgKGVsZW1lbnQuYXB5VHlwZSA9PSAwKSB7XG4gICAgICBwYXJhbXNba2V5QXB5VHlwZV0gPSBhdEFweTtcbiAgICB9IGVsc2UgaWYgKGVsZW1lbnQuYXB5VHlwZSA9PSAxKSB7XG4gICAgICBwYXJhbXNba2V5QXB5VHlwZV0gPSBhdE1hcmtldEFweTtcbiAgICB9XG4gIH0gZWxzZSBpZiAoZWxlbWVudC5wcm9kdWN0VHlwZSA9PSAxKSB7XG4gICAgaWYgKGVsZW1lbnQuZml4ZWRUeXBlID09IDAgfHwgZWxlbWVudC5maXhlZFR5cGUgPT0gMikge1xuICAgICAgcGFyYW1zW2tleVByb2plY3RUeXBlXSA9IHB0Rml4ZWQ7XG4gICAgfSBlbHNlIGlmIChlbGVtZW50LmZpeGVkVHlwZSA9PSAxKSB7XG4gICAgICBwYXJhbXNba2V5UHJvamVjdFR5cGVdID0gcHROZXdVc2VyO1xuICAgIH1cbiAgfVxuICBjb25zb2xlLmxvZyhgJHt0YWd9IGFycml2YWxEYXRlQ2xpY2sgcGFyYW1zPSAke0pTT04uc3RyaW5naWZ5KHBhcmFtcyl9YCk7XG4gIGNvbW1vbi5hbmFseXRpY3MoXCJhcHBfZWFybl9zdWJzY3JpYmVQYWdlX2Fycml2YWxEYXRlX2NsaWNrXCIsIHBhcmFtcyk7XG59XG5cbi8qKlxuICogQVBQLeeQhui0oi3nlLPotK3pobUt56uL5Y2z55Sz6LSt5oyJ6ZKuLeeCueWHu+S6i+S7tlx0YXBwX2Vhcm5fc3Vic2NyaWJlUGFnZV9zdWJzY3JpYmVCdXR0b25fY2xpY2tcbiAqL1xuZXhwb3J0IGZ1bmN0aW9uIHN1YnNjcmliZUJ1dHRvbkNsaWNrKGVsZW1lbnQpIHtcbiAgY29uc29sZS5sb2coXG4gICAgYCR7dGFnfSBzdWJzY3JpYmVCdXR0b25DbGljayBwcm9qZWN0SWQ9ICR7ZWxlbWVudC5wcm9qZWN0SWR9IHRlcm09ICR7ZWxlbWVudC50ZXJtfSBwcm9kdWN0VHlwZT0gJHtlbGVtZW50LnByb2R1Y3RUeXBlfSBgXG4gICk7XG4gIGxldCBwYXJhbXMgPSB7XG4gICAgW2tleVRva2VuXTogJGRhdGEuaG9tZS5jdXJyZW5jeSxcbiAgICBba2V5VGVybV06IGVsZW1lbnQudGVybSxcbiAgICBba2V5UHJvamVjdElkXTogZWxlbWVudC5wcm9qZWN0SWQsXG4gICAgLy8gW2tleVByb2plY3RUeXBlXTogXCJcIixcbiAgICAvLyBba2V5QXB5VHlwZV06IFwiXCIsXG4gIH07XG4gIGlmIChlbGVtZW50LnByb2R1Y3RUeXBlID09IDApIHtcbiAgICBwYXJhbXNba2V5UHJvamVjdFR5cGVdID0gcHRGbGV4aWJsZTtcbiAgICBpZiAoZWxlbWVudC5hcHlUeXBlID09IDApIHtcbiAgICAgIHBhcmFtc1trZXlBcHlUeXBlXSA9IGF0QXB5O1xuICAgIH0gZWxzZSBpZiAoZWxlbWVudC5hcHlUeXBlID09IDEpIHtcbiAgICAgIHBhcmFtc1trZXlBcHlUeXBlXSA9IGF0TWFya2V0QXB5O1xuICAgIH1cbiAgfSBlbHNlIGlmIChlbGVtZW50LnByb2R1Y3RUeXBlID09IDEpIHtcbiAgICBpZiAoZWxlbWVudC5maXhlZFR5cGUgPT0gMCB8fCBlbGVtZW50LmZpeGVkVHlwZSA9PSAyKSB7XG4gICAgICBwYXJhbXNba2V5UHJvamVjdFR5cGVdID0gcHRGaXhlZDtcbiAgICB9IGVsc2UgaWYgKGVsZW1lbnQuZml4ZWRUeXBlID09IDEpIHtcbiAgICAgIHBhcmFtc1trZXlQcm9qZWN0VHlwZV0gPSBwdE5ld1VzZXI7XG4gICAgfVxuICB9XG4gIGNvbnNvbGUubG9nKGAke3RhZ30gc3Vic2NyaWJlQnV0dG9uQ2xpY2sgcGFyYW1zPSAke0pTT04uc3RyaW5naWZ5KHBhcmFtcyl9YCk7XG4gIGNvbW1vbi5hbmFseXRpY3MoXCJhcHBfZWFybl9zdWJzY3JpYmVQYWdlX3N1YnNjcmliZUJ1dHRvbl9jbGlja1wiLCBwYXJhbXMpO1xufVxuXG4vKipcbiAqIEFQUC3nkIbotKIt5rS75pyf55Sz6LSt6aG1LeiHquWKqOi1muW4geino+mHiuWPueWPty3ngrnlh7vkuovku7ZcdGFwcF9lYXJuX2ZsZXhpYmxlU3Vic2NyaWJlUGFnZV9hdXRvRWFybkV4cGxhaW5fY2xpY2tcbiAqL1xuZXhwb3J0IGZ1bmN0aW9uIGF1dG9FYXJuRXhwbGFpbkNsaWNrKCkge1xuICBjb21tb24uYW5hbHl0aWNzKFwiYXBwX2Vhcm5fZmxleGlibGVTdWJzY3JpYmVQYWdlX2F1dG9FYXJuRXhwbGFpbl9jbGlja1wiLCB7IFtrZXlUb2tlbl06ICRkYXRhLmhvbWUuY3VycmVuY3kgfSk7XG59XG5cbmNvbnN0IGtleUFjdGlvbiA9IFwiYWN0aW9uXCI7XG5jb25zdCBhY3Rpb25PcGVuID0gXCJvcGVuXCI7XG5jb25zdCBhY3Rpb25jbG9zZSA9IFwiY2xvc2VcIjtcbi8qKlxuICogQVBQLeeQhui0oi3mtLvmnJ/nlLPotK3pobUt6Ieq5Yqo6LWa5biB5byA5YWzLeeCueWHu+S6i+S7tlx0YXBwX2Vhcm5fZmxleGlibGVTdWJzY3JpYmVQYWdlX2F1dG9FYXJuU3dpdGNoX2NsaWNrXG4gKi9cbmV4cG9ydCBmdW5jdGlvbiBhdXRvRWFyblN3aXRjaENsaWNrKGF1dG9FYXJuKSB7XG4gIGNvbnNvbGUubG9nKGAke3RhZ30gYXV0b0Vhcm5Td2l0Y2hDbGljayBhdXRvRWFybj0gJHthdXRvRWFybn1gKTtcbiAgbGV0IGFjdGlvbiA9IGF1dG9FYXJuID09IDEgPyBhY3Rpb25PcGVuIDogYWN0aW9uY2xvc2U7XG4gIGNvbW1vbi5hbmFseXRpY3MoXCJhcHBfZWFybl9mbGV4aWJsZVN1YnNjcmliZVBhZ2VfYXV0b0Vhcm5Td2l0Y2hfY2xpY2tcIiwge1xuICAgIFtrZXlUb2tlbl06ICRkYXRhLmhvbWUuY3VycmVuY3ksXG4gICAgW2tleUFjdGlvbl06IGFjdGlvbixcbiAgfSk7XG59XG5cbi8qKlxuICogQVBQLeeUs+i0remhtS3noa7orqTnlLPotK3kv6Hmga/lvLnnqpct5pud5YWJ5LqL5Lu2XHRhcHBfZWFybl9zdWJzY3JpYmVQYWdlX2NvbmZpcm1TdWJzY3JpcHRpb25JbmZvX3Nob3dcbiAqL1xuZXhwb3J0IGZ1bmN0aW9uIGNvbmZpcm1JbmZvU2hvdyhlbGVtZW50KSB7XG4gIGNvbnNvbGUubG9nKFxuICAgIGAke3RhZ30gY29uZmlybUluZm9TaG93IHByb2plY3RJZD0gJHtlbGVtZW50LnByb2plY3RJZH0gdGVybT0gJHtlbGVtZW50LnRlcm19IHByb2R1Y3RUeXBlPSAke2VsZW1lbnQucHJvZHVjdFR5cGV9YFxuICApO1xuICBsZXQgcGFyYW1zID0ge1xuICAgIFtrZXlUb2tlbl06ICRkYXRhLmhvbWUuY3VycmVuY3ksXG4gICAgW2tleVRlcm1dOiBlbGVtZW50LnRlcm0sXG4gICAgW2tleVByb2plY3RJZF06IGVsZW1lbnQucHJvamVjdElkLFxuICAgIC8vIFtrZXlQcm9qZWN0VHlwZV06IFwiXCIsXG4gICAgLy8gW2tleUFweVR5cGVdOiBcIlwiLFxuICB9O1xuICBpZiAoZWxlbWVudC5wcm9kdWN0VHlwZSA9PSAwKSB7XG4gICAgcGFyYW1zW2tleVByb2plY3RUeXBlXSA9IHB0RmxleGlibGU7XG4gICAgaWYgKGVsZW1lbnQuYXB5VHlwZSA9PSAwKSB7XG4gICAgICBwYXJhbXNba2V5QXB5VHlwZV0gPSBhdEFweTtcbiAgICB9IGVsc2UgaWYgKGVsZW1lbnQuYXB5VHlwZSA9PSAxKSB7XG4gICAgICBwYXJhbXNba2V5QXB5VHlwZV0gPSBhdE1hcmtldEFweTtcbiAgICB9XG4gIH0gZWxzZSBpZiAoZWxlbWVudC5wcm9kdWN0VHlwZSA9PSAxKSB7XG4gICAgaWYgKGVsZW1lbnQuZml4ZWRUeXBlID09IDAgfHwgZWxlbWVudC5maXhlZFR5cGUgPT0gMikge1xuICAgICAgcGFyYW1zW2tleVByb2plY3RUeXBlXSA9IHB0Rml4ZWQ7XG4gICAgfSBlbHNlIGlmIChlbGVtZW50LmZpeGVkVHlwZSA9PSAxKSB7XG4gICAgICBwYXJhbXNba2V5UHJvamVjdFR5cGVdID0gcHROZXdVc2VyO1xuICAgIH1cbiAgfVxuICBjb25zb2xlLmxvZyhgJHt0YWd9IGNvbmZpcm1JbmZvU2hvdyBwYXJhbXM9ICR7SlNPTi5zdHJpbmdpZnkocGFyYW1zKX1gKTtcbiAgY29tbW9uLmFuYWx5dGljcyhcImFwcF9lYXJuX3N1YnNjcmliZVBhZ2VfY29uZmlybVN1YnNjcmlwdGlvbkluZm9fc2hvd1wiLCBwYXJhbXMpO1xufVxuXG4vKipcbiAqIEFQUC3nlLPotK3pobUt56Gu6K6k55Sz6LSt5L+h5oGv5by556qXLeehruiupOaMiemSri3ngrnlh7vkuovku7ZcdGFwcF9lYXJuX3N1YnNjcmliZVBhZ2VfY29uZmlybVN1YnNjcmlwdGlvbkluZm9fY29uZmlybUJ1dHRvbl9jbGlja1xuICovXG5leHBvcnQgZnVuY3Rpb24gY29uZmlybUJ1dHRvbkNsaWNrKGVsZW1lbnQpIHtcbiAgY29uc29sZS5sb2coXG4gICAgYCR7dGFnfSBjb25maXJtQnV0dG9uQ2xpY2sgcHJvamVjdElkPSAke2VsZW1lbnQucHJvamVjdElkfSB0ZXJtPSAke2VsZW1lbnQudGVybX0gcHJvZHVjdFR5cGU9ICR7ZWxlbWVudC5wcm9kdWN0VHlwZX1gXG4gICk7XG4gIGxldCBwYXJhbXMgPSB7XG4gICAgW2tleVRva2VuXTogJGRhdGEuaG9tZS5jdXJyZW5jeSxcbiAgICBba2V5VGVybV06IGVsZW1lbnQudGVybSxcbiAgICBba2V5UHJvamVjdElkXTogZWxlbWVudC5wcm9qZWN0SWQsXG4gICAgLy8gW2tleVByb2plY3RUeXBlXTogXCJcIixcbiAgICAvLyBba2V5QXB5VHlwZV06IFwiXCIsXG4gIH07XG4gIGlmIChlbGVtZW50LnByb2R1Y3RUeXBlID09IDApIHtcbiAgICBwYXJhbXNba2V5UHJvamVjdFR5cGVdID0gcHRGbGV4aWJsZTtcbiAgICBpZiAoZWxlbWVudC5hcHlUeXBlID09IDApIHtcbiAgICAgIHBhcmFtc1trZXlBcHlUeXBlXSA9IGF0QXB5O1xuICAgIH0gZWxzZSBpZiAoZWxlbWVudC5hcHlUeXBlID09IDEpIHtcbiAgICAgIHBhcmFtc1trZXlBcHlUeXBlXSA9IGF0TWFya2V0QXB5O1xuICAgIH1cbiAgfSBlbHNlIGlmIChlbGVtZW50LnByb2R1Y3RUeXBlID09IDEpIHtcbiAgICBpZiAoZWxlbWVudC5maXhlZFR5cGUgPT0gMCB8fCBlbGVtZW50LmZpeGVkVHlwZSA9PSAyKSB7XG4gICAgICBwYXJhbXNba2V5UHJvamVjdFR5cGVdID0gcHRGaXhlZDtcbiAgICB9IGVsc2UgaWYgKGVsZW1lbnQuZml4ZWRUeXBlID09IDEpIHtcbiAgICAgIHBhcmFtc1trZXlQcm9qZWN0VHlwZV0gPSBwdE5ld1VzZXI7XG4gICAgfVxuICB9XG4gIGNvbnNvbGUubG9nKGAke3RhZ30gY29uZmlybUJ1dHRvbkNsaWNrIHBhcmFtcz0gJHtKU09OLnN0cmluZ2lmeShwYXJhbXMpfWApO1xuICBjb21tb24uYW5hbHl0aWNzKFwiYXBwX2Vhcm5fc3Vic2NyaWJlUGFnZV9jb25maXJtU3Vic2NyaXB0aW9uSW5mb19jb25maXJtQnV0dG9uX2NsaWNrXCIsIHBhcmFtcyk7XG59XG5cbi8qKlxuICogQVBQLeeQhui0oi3nlLPotK3miJDlip/pobUt5rWP6KeIXHRhcHBfZWFybl9zdWJzY3JpYmVTdWNjZXNzX3ZpZXdcbiAqL1xuZXhwb3J0IGZ1bmN0aW9uIHN1YnNjcmliZVN1Y2Nlc3NTaG93KCkge1xuICBsZXQgZWxlbWVudCA9ICRldmVudC5ob21lLmdldEN1cnJlbnRFbGVtZW50KCRkYXRhLmhvbWUuY3VycmVudEluZGV4KTtcbiAgY29uc29sZS5sb2coXG4gICAgYCR7dGFnfSBzdWJzY3JpYmVTdWNjZXNzU2hvdyBwcm9qZWN0SWQ9ICR7ZWxlbWVudC5wcm9qZWN0SWR9IHRlcm09ICR7ZWxlbWVudC50ZXJtfSBwcm9kdWN0VHlwZT0gJHtlbGVtZW50LnByb2R1Y3RUeXBlfSBgXG4gICk7XG4gIGxldCBwYXJhbXMgPSB7XG4gICAgW2tleVRva2VuXTogJGRhdGEuaG9tZS5jdXJyZW5jeSxcbiAgICBba2V5VGVybV06IGVsZW1lbnQudGVybSxcbiAgICBba2V5UHJvamVjdElkXTogZWxlbWVudC5wcm9qZWN0SWQsXG4gICAgLy8gW2tleVByb2plY3RUeXBlXTogXCJcIixcbiAgfTtcbiAgaWYgKGVsZW1lbnQucHJvZHVjdFR5cGUgPT0gMCkge1xuICAgIHBhcmFtc1trZXlQcm9qZWN0VHlwZV0gPSBwdEZsZXhpYmxlO1xuICB9IGVsc2UgaWYgKGVsZW1lbnQucHJvZHVjdFR5cGUgPT0gMSkge1xuICAgIGlmIChlbGVtZW50LmZpeGVkVHlwZSA9PSAwIHx8IGVsZW1lbnQuZml4ZWRUeXBlID09IDIpIHtcbiAgICAgIHBhcmFtc1trZXlQcm9qZWN0VHlwZV0gPSBwdEZpeGVkO1xuICAgIH0gZWxzZSBpZiAoZWxlbWVudC5maXhlZFR5cGUgPT0gMSkge1xuICAgICAgcGFyYW1zW2tleVByb2plY3RUeXBlXSA9IHB0TmV3VXNlcjtcbiAgICB9XG4gIH1cbiAgY29tbW9uLmFuYWx5dGljcyhcImFwcF9lYXJuX3N1YnNjcmliZVN1Y2Nlc3Nfdmlld1wiLCBwYXJhbXMpO1xufVxuXG4vKipcbiAqIEFQUC3nkIbotKIt55Sz6LSt5oiQ5Yqf6aG1LeWFs+mXreaMiemSri3ngrnlh7vkuovku7ZcdGFwcF9lYXJuX3N1YnNjcmliZVN1Y2Nlc3NfY2xvc2VfY2xpY2tcbiAqL1xuZXhwb3J0IGZ1bmN0aW9uIHN1YnNjcmliZVN1Y2Nlc3NDbG9zZUNsb3NlQ2xpY2soKSB7XG4gIGxldCBlbGVtZW50ID0gJGV2ZW50LmhvbWUuZ2V0Q3VycmVudEVsZW1lbnQoJGRhdGEuaG9tZS5jdXJyZW50SW5kZXgpO1xuICBjb25zb2xlLmxvZyhcbiAgICBgJHt0YWd9IHN1YnNjcmliZVN1Y2Nlc3NDbG9zZUNsb3NlQ2xpY2sgcHJvamVjdElkPSAke2VsZW1lbnQucHJvamVjdElkfSB0ZXJtPSAke2VsZW1lbnQudGVybX0gcHJvZHVjdFR5cGU9ICR7ZWxlbWVudC5wcm9kdWN0VHlwZX0gYFxuICApO1xuICBsZXQgcGFyYW1zID0ge1xuICAgIFtrZXlUb2tlbl06ICRkYXRhLmhvbWUuY3VycmVuY3ksXG4gICAgW2tleVRlcm1dOiBlbGVtZW50LnRlcm0sXG4gICAgW2tleVByb2plY3RJZF06IGVsZW1lbnQucHJvamVjdElkLFxuICAgIC8vIFtrZXlQcm9qZWN0VHlwZV06IFwiXCIsXG4gIH07XG4gIGlmIChlbGVtZW50LnByb2R1Y3RUeXBlID09IDApIHtcbiAgICBwYXJhbXNba2V5UHJvamVjdFR5cGVdID0gcHRGbGV4aWJsZTtcbiAgfSBlbHNlIGlmIChlbGVtZW50LnByb2R1Y3RUeXBlID09IDEpIHtcbiAgICBpZiAoZWxlbWVudC5maXhlZFR5cGUgPT0gMCB8fCBlbGVtZW50LmZpeGVkVHlwZSA9PSAyKSB7XG4gICAgICBwYXJhbXNba2V5UHJvamVjdFR5cGVdID0gcHRGaXhlZDtcbiAgICB9IGVsc2UgaWYgKGVsZW1lbnQuZml4ZWRUeXBlID09IDEpIHtcbiAgICAgIHBhcmFtc1trZXlQcm9qZWN0VHlwZV0gPSBwdE5ld1VzZXI7XG4gICAgfVxuICB9XG4gIGNvbW1vbi5hbmFseXRpY3MoXCJhcHBfZWFybl9zdWJzY3JpYmVTdWNjZXNzX2Nsb3NlX2NsaWNrXCIsIHBhcmFtcyk7XG59XG5cbi8qKlxuICogQVBQLeeQhui0oi3nlLPotK3miJDlip/pobUt5p+l55yL6LWE5Lqn5oyJ6ZKuLeeCueWHu+S6i+S7tlx0YXBwX2Vhcm5fc3Vic2NyaWJlU3VjY2Vzc192aWV3QXNzZXRzX2NsaWNrXG4gKi9cbmV4cG9ydCBmdW5jdGlvbiBzdWJzY3JpYmVTdWNjZXNzVmlld0Fzc2V0c0NsaWNrKCkge1xuICBsZXQgZWxlbWVudCA9ICRldmVudC5ob21lLmdldEN1cnJlbnRFbGVtZW50KCRkYXRhLmhvbWUuY3VycmVudEluZGV4KTtcbiAgY29uc29sZS5sb2coXG4gICAgYCR7dGFnfSBzdWJzY3JpYmVTdWNjZXNzVmlld0Fzc2V0c0NsaWNrIHByb2plY3RJZD0gJHtlbGVtZW50LnByb2plY3RJZH0gdGVybT0gJHtlbGVtZW50LnRlcm19IHByb2R1Y3RUeXBlPSAke2VsZW1lbnQucHJvZHVjdFR5cGV9IGBcbiAgKTtcbiAgbGV0IHBhcmFtcyA9IHtcbiAgICBba2V5VG9rZW5dOiAkZGF0YS5ob21lLmN1cnJlbmN5LFxuICAgIFtrZXlUZXJtXTogZWxlbWVudC50ZXJtLFxuICAgIFtrZXlQcm9qZWN0SWRdOiBlbGVtZW50LnByb2plY3RJZCxcbiAgICAvLyBba2V5UHJvamVjdFR5cGVdOiBcIlwiLFxuICB9O1xuICBpZiAoZWxlbWVudC5wcm9kdWN0VHlwZSA9PSAwKSB7XG4gICAgcGFyYW1zW2tleVByb2plY3RUeXBlXSA9IHB0RmxleGlibGU7XG4gIH0gZWxzZSBpZiAoZWxlbWVudC5wcm9kdWN0VHlwZSA9PSAxKSB7XG4gICAgaWYgKGVsZW1lbnQuZml4ZWRUeXBlID09IDAgfHwgZWxlbWVudC5maXhlZFR5cGUgPT0gMikge1xuICAgICAgcGFyYW1zW2tleVByb2plY3RUeXBlXSA9IHB0Rml4ZWQ7XG4gICAgfSBlbHNlIGlmIChlbGVtZW50LmZpeGVkVHlwZSA9PSAxKSB7XG4gICAgICBwYXJhbXNba2V5UHJvamVjdFR5cGVdID0gcHROZXdVc2VyO1xuICAgIH1cbiAgfVxuICBjb21tb24uYW5hbHl0aWNzKFwiYXBwX2Vhcm5fc3Vic2NyaWJlU3VjY2Vzc192aWV3QXNzZXRzX2NsaWNrXCIsIHBhcmFtcyk7XG59XG5cbi8qKlxuICogQVBQLeeQhui0oi3nlLPotK3miJDlip/pobUt57un57ut55Sz6LSt5oyJ6ZKuLeeCueWHu+S6i+S7tlx0YXBwX2Vhcm5fc3Vic2NyaWJlU3VjY2Vzc19jb250aW51ZV9jbGlja1xuICovXG5leHBvcnQgZnVuY3Rpb24gc3Vic2NyaWJlU3VjY2Vzc0NvbnRpbnVlQ2xpY2soKSB7XG4gIGxldCBlbGVtZW50ID0gJGV2ZW50LmhvbWUuZ2V0Q3VycmVudEVsZW1lbnQoJGRhdGEuaG9tZS5jdXJyZW50SW5kZXgpO1xuICBjb25zb2xlLmxvZyhcbiAgICBgJHt0YWd9IHN1YnNjcmliZVN1Y2Nlc3NDb250aW51ZUNsaWNrIHByb2plY3RJZD0gJHtlbGVtZW50LnByb2plY3RJZH0gdGVybT0gJHtlbGVtZW50LnRlcm19IHByb2R1Y3RUeXBlPSAke2VsZW1lbnQucHJvZHVjdFR5cGV9IGBcbiAgKTtcbiAgbGV0IHBhcmFtcyA9IHtcbiAgICBba2V5VG9rZW5dOiAkZGF0YS5ob21lLmN1cnJlbmN5LFxuICAgIFtrZXlUZXJtXTogZWxlbWVudC50ZXJtLFxuICAgIFtrZXlQcm9qZWN0SWRdOiBlbGVtZW50LnByb2plY3RJZCxcbiAgICAvLyBba2V5UHJvamVjdFR5cGVdOiBcIlwiLFxuICB9O1xuICBpZiAoZWxlbWVudC5wcm9kdWN0VHlwZSA9PSAwKSB7XG4gICAgcGFyYW1zW2tleVByb2plY3RUeXBlXSA9IHB0RmxleGlibGU7XG4gIH0gZWxzZSBpZiAoZWxlbWVudC5wcm9kdWN0VHlwZSA9PSAxKSB7XG4gICAgaWYgKGVsZW1lbnQuZml4ZWRUeXBlID09IDAgfHwgZWxlbWVudC5maXhlZFR5cGUgPT0gMikge1xuICAgICAgcGFyYW1zW2tleVByb2plY3RUeXBlXSA9IHB0Rml4ZWQ7XG4gICAgfSBlbHNlIGlmIChlbGVtZW50LmZpeGVkVHlwZSA9PSAxKSB7XG4gICAgICBwYXJhbXNba2V5UHJvamVjdFR5cGVdID0gcHROZXdVc2VyO1xuICAgIH1cbiAgfVxuICBjb21tb24uYW5hbHl0aWNzKFwiYXBwX2Vhcm5fc3Vic2NyaWJlU3VjY2Vzc19jb250aW51ZV9jbGlja1wiLCBwYXJhbXMpO1xufVxuXG4vKipcbiAqIEFQUC3nkIbotKIt55Sz6LSt6aG1LeWQjOaXtuiOt+W+l0xhdW5jaFBvb2zlpZblirEt54K55Ye75LqL5Lu2IGFwcF9lYXJuX3N1YnNjcmliZVBhZ2VfZ2V0TGF1bmNoUG9vbFJld2FyZHNfY2xpY2tcbiAqL1xuZXhwb3J0IGZ1bmN0aW9uIGxhdW5jaHBvb2xSZXdhcmRzQ2xpY2soKSB7XG4gIGxldCBlbGVtZW50ID0gJGV2ZW50LmhvbWUuZ2V0Q3VycmVudEVsZW1lbnQoJGRhdGEuaG9tZS5jdXJyZW50SW5kZXgpO1xuICBjb25zb2xlLmxvZyhcbiAgICBgJHt0YWd9IGxhdW5jaHBvb2xSZXdhcmRzQ2xpY2sgcHJvamVjdElkPSAke2VsZW1lbnQucHJvamVjdElkfSB0ZXJtPSAke2VsZW1lbnQudGVybX0gcHJvZHVjdFR5cGU9ICR7ZWxlbWVudC5wcm9kdWN0VHlwZX1gXG4gICk7XG4gIGxldCBwYXJhbXMgPSB7XG4gICAgW2tleVRva2VuXTogJGRhdGEuaG9tZS5jdXJyZW5jeSxcbiAgICBba2V5VGVybV06IGVsZW1lbnQudGVybSxcbiAgICBba2V5UHJvamVjdElkXTogZWxlbWVudC5wcm9qZWN0SWQsXG4gIH07XG4gIGlmIChlbGVtZW50LnByb2R1Y3RUeXBlID09IDApIHtcbiAgICBwYXJhbXNba2V5UHJvamVjdFR5cGVdID0gcHRGbGV4aWJsZTtcbiAgfSBlbHNlIGlmIChlbGVtZW50LnByb2R1Y3RUeXBlID09IDEpIHtcbiAgICBpZiAoZWxlbWVudC5maXhlZFR5cGUgPT0gMCB8fCBlbGVtZW50LmZpeGVkVHlwZSA9PSAyKSB7XG4gICAgICBwYXJhbXNba2V5UHJvamVjdFR5cGVdID0gcHRGaXhlZDtcbiAgICB9IGVsc2UgaWYgKGVsZW1lbnQuZml4ZWRUeXBlID09IDEpIHtcbiAgICAgIHBhcmFtc1trZXlQcm9qZWN0VHlwZV0gPSBwdE5ld1VzZXI7XG4gICAgfVxuICB9XG4gIGNvbW1vbi5hbmFseXRpY3MoXCJhcHBfZWFybl9zdWJzY3JpYmVQYWdlX3Jlc3RFeHBsYWluX2NsaWNrXCIsIHBhcmFtcyk7XG59XG4iLCJpbXBvcnQgKiBhcyBjb21tb24gZnJvbSBcIi4vY29tbW9uXCJcbmltcG9ydCAqIGFzIG51bWJlciBmcm9tIFwiLi9udW1iZXJcIjtcbmltcG9ydCAqIGFzIGNvdXBvbkxpc3QgZnJvbSBcIi4vY291cG9uTGlzdERpYWxvZ1wiO1xuaW1wb3J0ICogYXMgYW5hbHl0aWNzIGZyb20gXCIuL2FuYWx5dGljc1wiO1xuXG5jb25zdCB7IG1vZHVsZURhdGEsIG1vZHVsZUV2ZW50IH0gPSBjb21tb24ubW9kdWxlRGVmaW5lKFwiZml4ZWRcIiwgZnVuY3Rpb24oKXt9LCB7fSk7XG5cbmZ1bmN0aW9uIGRlZmF1bHRIYW5kbGVyRGF0YSgpIHtcbiAgcmV0dXJuIHtcbiAgICBzdWJJbnB1dDogXCJcIiwvL+eUs+i0reaVsOmHj+i+k+WFpeahhlxuICAgIHN1Yk9uRm9jdXM6IGZhbHNlLC8v55Sz6LSt54Sm54K5XG4gICAgc3ViSGludDogJGkxOG4uJGludGVyY2VwdC5uX3NoYXJrX2Zpbl9taW5fYW1vdW50KCcnKSwvL+eUs+i0reaVsOmHj+aPkOekuuivrVxuICAgIHN1YlVuaXQ6IFwiXCIsLy/ljZXkvY1cbiAgICBiYWxhbmNlOiBcIi0tXCIsLy/kvZnpop1cbiAgICBvdmVydmlldzogXCJcIixcbiAgICBzdWJCb3JkZXJDb2xvcjogXCJAY29sb3IvS0Jhc2VDb2xvcklucHV0QmFja2dyb3VuZFwiLFxuICAgIHRpbWVBeGlzRGF0YTogW10sXG4gICAgdGltZUF4aXNIZWlnaHQ6IDY4LFxuICAgIGF2YWlsYWJsZVF1b3RhVGl0bGU6IFwiXCIsXG4gICAgYXZhaWxhYmxlUXVvdGFUZXh0OiBcIlwiLC8vIOWJqeS9meWPr+aKleeahOWNg+WIhuS9jeWxleekulxuICAgIG1pblN1YjogXCJcIiwgLy8g5pyA5bCP6LW35oqVXG4gICAgcHJvZml0OiBcIi0tXCIsIC8v6aKE5Lyw5pS255uK55qE6buY6K6k5YC8XG5cbiAgICAvL+WKoOaBr+WIuOebuOWFs+e7keWumlxuICAgIGNvdXBvblZpczogXCJnb25lXCIsLy/liqDmga/liLjmlbTooYzmmL7pmpBcbiAgICBjb3Vwb25UZXh0VXA6IFwiXCIsLy/liqDmga/liLjkuIrpnaLmlofmoYhcbiAgICBjb3Vwb25UZXh0RG93bjogXCJcIiwvL+WKoOaBr+WIuOS4i+mdouaWh+ahiFxuICAgIGNvdXBvblRleHREb3duVmlzOiBcInZpc2libGVcIiwvL+WKoOaBr+WIuOS4i+mdouaYvuekulxuICAgIGNvdXBvblJpZ2h0SW1nVmlzOiBcInZpc2libGVcIiwvL+WKoOaBr+WIuOacgOWPs+i+ueWbvuagh1xuICAgIGNvdXBvbk1pZFZpczogXCJ2aXNpYmxlXCIsLy/liqDmga/liLjlj7PkvqfluIPlsYDmmL7npLrvvIzlkowgY291cG9uVGV4dE1pZFZpcyDkupLmlqVcbiAgICBjb3Vwb25UZXh0TWlkVmlzOiBcImdvbmVcIiwvL+WKoOaBr+WIuOWPs+S+p+S4remXtOaWh+ahiOaYvuekulxuICAgIGNvdXBvblRleHRNaWQ6IFwiXCIsLy/liqDmga/liLjlj7PkvqfkuK3pl7TmlofmoYhcbiAgICAvL+WKoOaBr+WIuOWIl+ihqOeahOaVsOaNrlxuICAgIGNvdXBvbkxpc3REYXRhOiB7fSxcbiAgICAvL+ato+WcqOS9v+eUqOeahOWKoOaBr+WIuFxuICAgIHVzaW5nQ291cG9uOiB7fSxcbiAgICAvL+aYr+WQpuaUr+aMgeWKoOaBr+WIuO+8mjAt5LiN5pSv5oyB77ybMS3mlK/mjIFcbiAgICBzdXBwb3J0Q291cG9uOiAwLFxuICAgIC8v55So5oi35bey5oqV6YeR6aKdXG4gICAgdXNlckludmVzdEFtdDogMCxcbiAgfVxufVxuXG5leHBvcnQgZnVuY3Rpb24gY2xlYXJEYXRhKGhhbmRsZXJEYXRhKSB7XG4gIGhhbmRsZXJEYXRhLnN1YkhpbnQgPSAkaTE4bi4kaW50ZXJjZXB0Lm5fc2hhcmtfZmluX21pbl9hbW91bnQoJycpO1xuICBoYW5kbGVyRGF0YS5zdWJVbml0ID0gXCJcIjtcbiAgaGFuZGxlckRhdGEuYmFsYW5jZSA9ICctLSc7XG4gIGhhbmRsZXJEYXRhLmJ0bkNvbG9yID0gXCJAY29sb3Iva0NvbG9yRUJFQkVCXCI7XG4gIGhhbmRsZXJEYXRhLmJ0blRpdGxlQ29sb3IgPSBcIkBjb2xvci9rQ29sb3JUaHJlZUxldmVsVGV4dFwiO1xufVxuXG4vLyDop6PmnpDlrprmnJ/mlbDmja5cbmV4cG9ydCBmdW5jdGlvbiBoYW5kbGVGbGV4aWJsZURldGFpbChmbGV4aWJsZUl0ZW0sIG9yaWdpbkNvdXBvbkRhdGEpIHtcbiAgdmFyIGhhbmRsZXJEYXRhID0gZGVmYXVsdEhhbmRsZXJEYXRhKCk7XG4gIGlmIChmbGV4aWJsZUl0ZW0gPT0gbnVsbCkge1xuICAgIHJldHVybiBoYW5kbGVyRGF0YTtcbiAgfVxuXG4gIGZvciAoY29uc3Qga2V5IGluIGZsZXhpYmxlSXRlbSkge1xuICAgIGlmIChPYmplY3QucHJvdG90eXBlLmhhc093blByb3BlcnR5LmNhbGwoZmxleGlibGVJdGVtLCBrZXkpKSB7XG4gICAgICBoYW5kbGVyRGF0YVtrZXldID0gZmxleGlibGVJdGVtW2tleV07XG4gICAgfVxuICB9XG5cbiAgbGV0IG1pbiA9IGZsZXhpYmxlSXRlbVtcInN1YnNjcmliZU1pbkFtb3VudFwiXTtcbiAgaGFuZGxlckRhdGEubWluU3ViID0gY29tbW9uLnJlbW92ZUV4dHJhWmVyb3MoY29tbW9uLmZvcm1hdFByZWNpc2lvbihtaW4sIDgpKTs7XG4gIGhhbmRsZXJEYXRhLnN1YlVuaXQgPSAkZGF0YS5ob21lLmN1cnJlbmN5LnRvVXBwZXJDYXNlKCk7XG4gIGhhbmRsZXJEYXRhLmJhbGFuY2UgPSAkZGF0YS5ob21lLmJhbGFuY2U7XG4gIGhhbmRsZXJEYXRhLnN1YkhpbnQgPSAkaTE4bi4kaW50ZXJjZXB0Lm5fc2hhcmtfZmluX21pbl9hbW91bnQoYCR7aGFuZGxlckRhdGEubWluU3VifWApO1xuXG4gIC8v5Ymp5L2Z5Y+v55Sz6LStXG4gIGlmIChmbGV4aWJsZUl0ZW0ucHJvamVjdFJlbWFpbkFtdFBlckRheSA9PSBudWxsKSB7XG4gICAgaGFuZGxlckRhdGEuYXZhaWxhYmxlUXVvdGFUaXRsZSA9ICRpMThuLm5fc2ltcGxlX2Vhcm5fYXZhaWxhYmxlX3F1b3RhO1xuICB9IGVsc2Uge1xuICAgIGhhbmRsZXJEYXRhLmF2YWlsYWJsZVF1b3RhVGl0bGUgPSAkaTE4bi5uX3NpbXBsZV9lYXJuX2F2YWlsYWJsZV9xdW90ZV90b2RheTtcbiAgfVxuICBoYW5kbGVyRGF0YS5hdmFpbGFibGVRdW90YSA9IGZsZXhpYmxlSXRlbS5hdmFpbGFibGVRdW90YTtcbiAgaGFuZGxlckRhdGEuYXZhaWxhYmxlUXVvdGFUZXh0ID0gYCR7Y29tbW9uLnJlbW92ZUV4dHJhWmVyb3MoY29tbW9uLmdldFByaWNlU3RyaW5nKGZsZXhpYmxlSXRlbS5hdmFpbGFibGVRdW90YSwgOCkpfWA7XG4gIGlmIChmbGV4aWJsZUl0ZW0uZHRJbnRlcmVzdFN0YXJ0ICYmIGZsZXhpYmxlSXRlbS5kdFJlY2VpcHQpIHtcbiAgICBoYW5kbGVyRGF0YS5vdmVydmlldyA9ICRpMThuLiRpbnRlcmNlcHQubl9zaW1wbGVfZWFybl9zb19yZWd1bGFyX3RpdGxlKFxuICAgICAgYCR7ZmxleGlibGVJdGVtLmR0SW50ZXJlc3RTdGFydH1gLFxuICAgICAgYCR7ZmxleGlibGVJdGVtLmR0UmVjZWlwdH1gXG4gICAgKTtcbiAgfSBlbHNlIHtcbiAgICBoYW5kbGVyRGF0YS5vdmVydmlldyA9IFwiXCI7XG4gIH1cbiAgLy/liqDmga/liLhcbiAgaGFuZGxlckRhdGEudXNpbmdDb3Vwb24gPSAoZmxleGlibGVJdGVtLnVzaW5nQ291cG9uID09IG51bGwpID8ge30gOiBmbGV4aWJsZUl0ZW0udXNpbmdDb3Vwb247XG4gIGhhbmRsZXJEYXRhLnN1cHBvcnRDb3Vwb24gPSBmbGV4aWJsZUl0ZW0uc3VwcG9ydENvdXBvbjtcbiAgaGFuZGxlckRhdGEudXNlckludmVzdEFtdCA9IGZsZXhpYmxlSXRlbS51c2VySW52ZXN0QW10O1xuICBoYW5kbGVyRGF0YS5kdEV4cGlyZWQgPSBmbGV4aWJsZUl0ZW0uZHRFeHBpcmVkO1xuICBpZiAoaGFuZGxlckRhdGEuc3VwcG9ydENvdXBvbiA9PSAxKSB7XG4gICAgaGFuZGxlckRhdGEuY291cG9uVmlzID0gXCJ2aXNpYmxlXCI7XG4gICAgLy/lpITnkIbliqDmga/liLhcbiAgICBjb3Vwb25MaXN0LmdldENvdXBvbkRhdGEoaGFuZGxlckRhdGEsIG9yaWdpbkNvdXBvbkRhdGEpO1xuICB9IGVsc2Uge1xuICAgIC8v6ZqQ6JeP5Yqg5oGv5Yi45pW06KGMXG4gICAgaGFuZGxlckRhdGEuY291cG9uVmlzID0gXCJnb25lXCI7XG4gIH1cbiAgLy8g55Sz6LSt5qaC6KeIXG4gIHZhciBkdFJlY2VpcHQgPSBmbGV4aWJsZUl0ZW0uZHRSZWNlaXB0O1xuICBoYW5kbGVyRGF0YS5yZWNlaXB0RGVsYXlEYXlzID0gZmxleGlibGVJdGVtLnJlY2VpcHREZWxheURheXM7XG4gIC8vIGlmIChmbGV4aWJsZUl0ZW0ucmVjZWlwdERlbGF5RGF5cyA9PSAwKSB7XG4gIC8vICAgZHRSZWNlaXB0ID0gJGkxOG4ubl9zaW1wbGVfZWFybl9zb19yZWFsX3RpbWVfcGF5bWVudDtcbiAgLy8gfVxuICBoYW5kbGVyRGF0YS50aW1lQXhpc0RhdGEgPSBbXG4gICAgeyB0eXBlOiBcIm5vcm1hbFwiLCB0aXRsZTogJGkxOG4ubl9zaW1wbGVfZWFybl9zb19zdWJfZGF5LCBsaW5lVGl0bGU6IFwiXCIsIGRhdGU6IGAke2ZsZXhpYmxlSXRlbS5kdFN1YnNjcmliZX1gIH0sXG4gICAgeyB0eXBlOiBcIm5vcm1hbFwiLCB0aXRsZTogJGkxOG4ubl9zaW1wbGVfZWFybl9zb19zdGFydF9kYXksIGxpbmVUaXRsZTogXCJcIiwgZGF0ZTogYCR7ZmxleGlibGVJdGVtLmR0SW50ZXJlc3RTdGFydH1gIH0sXG4gICAgeyB0eXBlOiBcIm5vcm1hbFwiLCB0aXRsZTogJGkxOG4ubl9zaW1wbGVfZWFybl9zb19kdWVfZGF5LCBsaW5lVGl0bGU6IFwiXCIsIGRhdGU6IGAke2ZsZXhpYmxlSXRlbS5kdEV4cGlyZWR9YCB9LFxuICAgIHsgdHlwZTogXCJub3JtYWxcIiwgdGl0bGU6IFwiXCIsIGxpbmVUaXRsZTogJGkxOG4ubl9zaW1wbGVfZWFybl9zb19yZWNlaXB0X2RheSwgZGF0ZTogYCR7ZHRSZWNlaXB0fWAgfSxcbiAgXTtcbiAgcmV0dXJuIGhhbmRsZXJEYXRhO1xufVxuXG5mdW5jdGlvbiBnZXRJdGVtRGF0YShpdGVtSW5kZXgpIHtcbiAgaWYgKGl0ZW1JbmRleCA+ICRkYXRhLmhvbWUuc2xpZGVyRGF0YS5sZW5ndGggLSAxKSB7XG4gICAgcmV0dXJuIGRlZmF1bHRIYW5kbGVyRGF0YSgpO1xuICB9XG4gIHJldHVybiAkZGF0YS5ob21lLnNsaWRlckRhdGFbaXRlbUluZGV4XTtcbn1cblxuYXN5bmMgZnVuY3Rpb24gcmVxdWVzdFByb2ZpdEVzdGltYXRlKGl0ZW1EYXRhKSB7XG4gIGlmIChpdGVtRGF0YS5tU3ViSW5wdXQgPT0gMCkge1xuICAgIGl0ZW1EYXRhLnByb2ZpdCA9IFwiLS1cIjtcbiAgICByZXR1cm47XG4gIH1cbiAgbGV0IHJlcVBhcmFtID0ge1xuICAgIHByb2plY3RJZDogaXRlbURhdGEucHJvamVjdElkLFxuICAgIGFtdDogaXRlbURhdGEubVN1YklucHV0XG4gIH07XG5cbiAgY29uc3QgZGF0YSA9IGF3YWl0IGNvbW1vbi5zZW5kUmVxdWVzdCgndjQvc2F2aW5nL21pbmluZy9wcm9qZWN0L3Byb2ZpdC9lc3RpbWF0ZScsIHJlcVBhcmFtKTtcbiAgY29uc29sZS5sb2coYHByb2ZpdC9lc3RpbWF0ZSA6ICR7SlNPTi5zdHJpbmdpZnkoZGF0YSl9YCk7XG4gIGlmIChkYXRhICE9IG51bGwgJiYgZGF0YS5wcm9maXRGb3JtYXRTaG93KSB7XG4gICAgaXRlbURhdGEucHJvZml0ID0gYCR7ZGF0YS5wcm9maXRGb3JtYXRTaG93fWA7XG4gIH0gZWxzZSB7XG4gICAgaXRlbURhdGEucHJvZml0ID0gXCItLVwiO1xuICB9XG59XG5cblxuZnVuY3Rpb24gY2hlY2tTdWJJbnB1dChpdGVtRGF0YSkge1xuICAvL+ajgOa1i+S9memineaYr+WQpuWQiOazlVxuICBjb25zdCBxdWFudGl0eSA9IHBhcnNlRmxvYXQoaXRlbURhdGEubVN1YklucHV0KTtcbiAgY29uc3QgbWluU3ViID0gcGFyc2VGbG9hdChpdGVtRGF0YS5taW5TdWIpO1xuICBjb25zdCBiYWxhbmNlID0gaXRlbURhdGEuYmFsYW5jZSA9PSBcIi0tXCIgPyAwIDogcGFyc2VGbG9hdChpdGVtRGF0YS5iYWxhbmNlKTtcbiAgLy/lj6/nlLPotK3mlbDph4/mo4DmtYtcbiAgY29uc3QgYXZhaWxhYmxlUXVvdGEgPSBwYXJzZUZsb2F0KGl0ZW1EYXRhLmF2YWlsYWJsZVF1b3RhKTtcbiAgLy/lj6/nlKjkvZnpop3mo4DmtYtcbiAgaWYgKHF1YW50aXR5ID4gYmFsYW5jZSkge1xuICAgIGl0ZW1EYXRhLnN1YkJvcmRlckNvbG9yID0gXCJAY29sb3IvS0Jhc2VJbnB1dEludmFsaWRUaXBDb2xvclwiO1xuICAgIGl0ZW1EYXRhLnN1YkVycm9yU3RyID0gJGkxOG4ubl9zaW1wbGVfZWFybl9pbnB1dF9vdmVyX2JhbGFuY2U7XG4gICAgaXRlbURhdGEuc3ViRXJyb3JWaXMgPSBcInZpc2libGVcIjtcbiAgICByZXR1cm4gZmFsc2U7XG4gIH0gZWxzZSBpZiAocXVhbnRpdHkgPCBtaW5TdWIpIHtcbiAgICBpdGVtRGF0YS5zdWJCb3JkZXJDb2xvciA9IFwiQGNvbG9yL0tCYXNlSW5wdXRJbnZhbGlkVGlwQ29sb3JcIjtcbiAgICBpdGVtRGF0YS5zdWJFcnJvclN0ciA9ICRpMThuLiRpbnRlcmNlcHQubl9zaW1wbGVfZWFybl9pbnB1dF9taW5fc3Vic2NyaWJlKGAke21pblN1Yn1gLCBgJHtpdGVtRGF0YS5zdWJVbml0fWApO1xuICAgIGl0ZW1EYXRhLnN1YkVycm9yVmlzID0gXCJ2aXNpYmxlXCI7XG4gICAgcmV0dXJuIGZhbHNlO1xuICB9IGVsc2UgaWYgKHF1YW50aXR5ID4gYXZhaWxhYmxlUXVvdGEpIHtcbiAgICBpdGVtRGF0YS5zdWJCb3JkZXJDb2xvciA9IFwiQGNvbG9yL0tCYXNlSW5wdXRJbnZhbGlkVGlwQ29sb3JcIjtcbiAgICBpdGVtRGF0YS5zdWJFcnJvclN0ciA9ICRpMThuLm5fc2ltcGxlX2Vhcm5faW5wdXRfb3Zlcl9xdW90YTtcbiAgICBpdGVtRGF0YS5zdWJFcnJvclZpcyA9IFwidmlzaWJsZVwiO1xuICAgIHJldHVybiBmYWxzZTtcbiAgfSBlbHNlIHtcbiAgICBpdGVtRGF0YS5zdWJCb3JkZXJDb2xvciA9IFwiQGNvbG9yL0tCYXNlQ29sb3JJbnB1dEJhY2tncm91bmRcIjtcbiAgICBpdGVtRGF0YS5zdWJFcnJvclZpcyA9IFwiZ29uZVwiO1xuICAgIHJldHVybiB0cnVlO1xuICB9XG59XG5cbm1vZHVsZUV2ZW50LnN1YlRleHRDaGFuZ2UgPSBmdW5jdGlvbiAoaW5wdXRTdHIsIGl0ZW1JbmRleCkge1xuICB2YXIgaXRlbURhdGEgPSBnZXRJdGVtRGF0YShpdGVtSW5kZXgpO1xuICBjb25zb2xlLmxvZyhgc3ViVGV4dENoYW5nZSA6ICR7aW5wdXRTdHJ9YCk7XG4gIGl0ZW1EYXRhLm1TdWJJbnB1dCA9IGlucHV0U3RyXG4gIC8vIOmihOS8sOaUtuebilxuICByZXF1ZXN0UHJvZml0RXN0aW1hdGUoaXRlbURhdGEpO1xuICBsZXQgc3ViSW50ID0gKGlucHV0U3RyLmxlbmd0aCA9PT0gMCkgPyAwIDogbnVtYmVyLmJpZ251bWJlcihpbnB1dFN0cik7XG4gIGNvdXBvbkxpc3QucmVmcmVzaENvdXBvbihzdWJJbnQsIGl0ZW1EYXRhKTtcbiAgLy/mo4DmtYvovpPlhaXmmK/lkKblkIjms5VcbiAgaWYgKCFjaGVja1N1YklucHV0KGl0ZW1EYXRhKSkge1xuICAgIGl0ZW1EYXRhLmlucHV0U3RhdHVzID0gZmFsc2U7XG4gICAgJGV2ZW50LmRlcG9zaXQuY2hlY2tCdG5TdGF0dXMoaXRlbURhdGEuc3RhdHVzLCBpdGVtRGF0YS5pbnB1dFN0YXR1cyk7XG4gICAgcmV0dXJuO1xuICB9XG4gIGl0ZW1EYXRhLmlucHV0U3RhdHVzID0gaXRlbURhdGEuc3ViRXJyb3JWaXMgPT0gXCJnb25lXCIgJiYgaXRlbURhdGEubVN1YklucHV0ICE9IFwiXCI7XG4gIC8v5qOA5rWL5oyJ6ZKu54q25oCBXG4gIGlmICgkZXZlbnQuZGVwb3NpdC5jaGVja0J0blN0YXR1cyhpdGVtRGF0YS5zdGF0dXMsIGl0ZW1EYXRhLmlucHV0U3RhdHVzKSkge1xuXG4gIH1cbn1cblxubW9kdWxlRXZlbnQuc3ViRm9jdXNDaGFuZ2UgPSBmdW5jdGlvbiAoZm9jdXMsIGl0ZW1JbmRleCkge1xuICBjb25zb2xlLmxvZyhgc3ViRm9jdXNDaGFuZ2UgOiAke2ZvY3VzfWApO1xufVxuXG5tb2R1bGVFdmVudC5zdWJPblJldHVybiA9IGZ1bmN0aW9uIChwYXJhbWV0ZXIsIGl0ZW1JbmRleCkge1xuICBjb25zb2xlLmxvZyhgc3ViT25SZXR1cm4gOiAke3BhcmFtZXRlcn1gKTtcbiAgdmFyIGl0ZW1EYXRhID0gZ2V0SXRlbURhdGEoaXRlbUluZGV4KTtcbiAgaXRlbURhdGEuc3ViT25Gb2N1cyA9IGZhbHNlO1xufVxuXG5tb2R1bGVFdmVudC5jbGVhckZvY3VzID0gZnVuY3Rpb24gKGl0ZW1JbmRleCkge1xuICB2YXIgaXRlbURhdGEgPSBnZXRJdGVtRGF0YShpdGVtSW5kZXgpO1xuICBpdGVtRGF0YS5zdWJPbkZvY3VzID0gZmFsc2U7XG59XG5cbm1vZHVsZUV2ZW50Lm1heFN1YiA9IGZ1bmN0aW9uIChpdGVtSW5kZXgpIHtcbiAgdmFyIGl0ZW1EYXRhID0gZ2V0SXRlbURhdGEoaXRlbUluZGV4KTtcblxuICBpZiAoaXRlbURhdGEuYmFsYW5jZSAhPSBcIi0tXCIpIHtcbiAgICBpdGVtRGF0YS5zdWJJbnB1dCA9ICRkYXRhLmhvbWUuYmFsYW5jZVRleHQucmVwbGFjZSgvLC9nLCAnJyk7XG4gICAgaXRlbURhdGEubVN1YklucHV0ID0gaXRlbURhdGEuc3ViSW5wdXQ7XG4gICAgaWYgKGNvbW1vbi5jb21tb25EYXRhLk9TID09IDApIHtcbiAgICAgIG1vZHVsZUV2ZW50LnN1YlRleHRDaGFuZ2UoaXRlbURhdGEubVN1YklucHV0LCBpdGVtSW5kZXgpO1xuICAgIH1cbiAgfSBlbHNlIHtcbiAgICBpdGVtRGF0YS5zdWJJbnB1dCA9IFwiMFwiO1xuICAgIGl0ZW1EYXRhLm1TdWJJbnB1dCA9IGl0ZW1EYXRhLnN1YklucHV0O1xuICB9XG4gIGFuYWx5dGljcy5tYXhDbGljayhpdGVtRGF0YSk7XG59XG5cbi8vIOWJqeS9meWPr+aKleeCueWHu1xubW9kdWxlRXZlbnQuYXZhaWxhYmxlUXVvdGFDbGlja2VkID0gZnVuY3Rpb24gKGl0ZW1JbmRleCkge1xuICBpZiAoaXRlbUluZGV4ID4gJGRhdGEuaG9tZS5zbGlkZXJEYXRhLmxlbmd0aCAtIDEpIHtcbiAgICByZXR1cm5cbiAgfVxuICB2YXIgaXRlbURhdGEgPSBnZXRJdGVtRGF0YShpdGVtSW5kZXgpO1xuICBpdGVtRGF0YS5zdWJPbkZvY3VzID0gZmFsc2U7XG5cbiAgJGV2ZW50LmRpYWxvZy5zaG93QXZhaWxhYmxlUXVvdGFEaWFsb2coaXRlbURhdGEpO1xuICBhbmFseXRpY3MucmVzdEV4cGxhaW5DbGljayhpdGVtRGF0YSk7XG59XG5cbm1vZHVsZUV2ZW50LmJhY2tDbGlja2VkID0gZnVuY3Rpb24gKCkge1xuICBjb21tb24uY29udGFpbmVyQmFjaygpO1xufVxuIiwiaW1wb3J0ICogYXMgY29tbW9uIGZyb20gXCIuL2NvbW1vblwiXG5pbXBvcnQgKiBhcyBhbmFseXRpY3MgZnJvbSBcIi4vYW5hbHl0aWNzXCI7XG5pbXBvcnQgKiBhcyBudW1iZXIgZnJvbSBcIi4vbnVtYmVyXCI7XG5cbiRkYXRhLmRpYWxvZyA9IHtcbiAgY29uZmlybVRpdGxlOiAkaTE4bi5uX3NpbXBsZV9lYXJuX2NvbmZpcm1fc3Vic2NyaWJlX2luZm8sXG4gIGF2YWlsYWJsZVF1b3RhVGl0bGU6IFwiXCIsXG4gIGNvbmZpcm1saXN0OiBbXSxcbiAgcXVvdGFRMTogXCJcIixcbiAgcXVvdGFBMTogXCJcIixcbiAgcXVvdGFRMjogXCJcIixcbiAgcXVvdGFBMjogXCJcIixcbiAgcXVvdGFUZXh0MTogXCJcIixcbiAgcXVvdGFUZXh0MjogXCJcIixcbiAgcXVvdGFUZXh0MzogXCJcIixcbiAgc2hvd0NvbmZpcm1EaWFsb2c6IGZhbHNlLFxuICBzaG93QXZhaWxhYmxlUXVvdGE6IGZhbHNlLFxuICBjb25maXJtSW5uZXJMaXN0OiBbXSwvL+W6lemDqOeBsOiJsuWMuuWfn+eahOe7vOWQiOW5tOWMluWIl+ihqFxuICBjb25maXJtSW5uZXJMaXN0VmlzOiBcInZpc2libGVcIiwvL+W6lemDqOe7vOWQiOW5tOWMluWIl+ihqOaYvumakFxuICBwdXJjaGFzZVZhbHVlOiAwLFxuICBhc3NldENvbWJpbmVEYXRhOiBbXSwgLy8g55Sz6LSt6LWE5Lqn57uE5oiQ5YiX6KGoXG4gIHVzZHRUaXA6IFwiXCIsXG4gIHVzZHRUaXBEaXNwbGF5OiBcImdvbmVcIixcbiAgYW10U291cmNlOiAwLCAvLyDnu5nnlLPotK3mjqXlj6PnlKjnmoTmlrDlj4LmlbBcbiAgdXNkZFJlc3Q6IDAsIFxufVxuXG5jb25zdCBzb3VyY2VFbnVtID0ge1xuICB1c2RkU291cmNlOiAxLCAvLyDlvZPliY3luIHnp40o546w6LSn5L2Z6aKdKVxuICB1c2R0U291cmNlOiA0IC8vIFVTRFQo546w6LSn5L2Z6aKdKVxufTtcblxuJGV2ZW50LmRpYWxvZyA9IHtcbiAgLy8gbGlzdCA6IFt7dHlwZTogXCJub3JtYWxcIiwgdGl0bGU6IFwiXCIsIHZhbHVlOiBcIlwifV1cbiAgc2hvd0NvbmZpcm1EaWFsb2cobGlzdCA9IFtdLCBpbm5lckxpc3QgPSBudWxsLCBlbGVtZW50KSB7XG4gICAgJGRhdGEuZGlhbG9nLmNvbmZpcm1saXN0ID0gbGlzdDtcbiAgICBpZiAoaW5uZXJMaXN0ID09IG51bGwgfHwgaW5uZXJMaXN0Lmxlbmd0aCA8PSAxKSB7XG4gICAgICAkZGF0YS5kaWFsb2cuY29uZmlybUlubmVyTGlzdFZpcyA9IFwiZ29uZVwiO1xuICAgIH0gZWxzZSB7XG4gICAgICAkZGF0YS5kaWFsb2cuY29uZmlybUlubmVyTGlzdCA9IGlubmVyTGlzdDtcbiAgICAgICRkYXRhLmRpYWxvZy5jb25maXJtSW5uZXJMaXN0VmlzID0gXCJ2aXNpYmxlXCI7XG4gICAgfVxuICAgIGxldCBpbnB1dHZhbHVlID0gZWxlbWVudC5tU3ViSW5wdXQ7IC8vIOi+k+WFpeeahOeUs+i0reaVsOmHj1xuICAgICRkYXRhLmRpYWxvZy5wdXJjaGFzZVZhbHVlID0gYCR7aW5wdXR2YWx1ZX0gJHskZGF0YS5ob21lLmN1cnJlbmN5fWA7XG4gICAgJGRhdGEuZGlhbG9nLnNob3dDb25maXJtRGlhbG9nID0gdHJ1ZTtcbiAgICBcbiAgICBjb25zb2xlLmxvZyhgY29uZnJpbSBkaWFsb2cgc2hvd2luZy4uIGlucHV0ICA9ICR7aW5wdXR2YWx1ZX0gYCk7XG4gICAgJGRhdGEuZGlhbG9nLmFzc2V0Q29tYmluZURhdGEgPSBbXTtcbiAgICAkZGF0YS5kaWFsb2cudXNkZFJlc3QgPSBpbnB1dHZhbHVlO1xuICAgICRkYXRhLmRpYWxvZy5hbXRTb3VyY2UgPSAwO1xuICAgICRkYXRhLmRpYWxvZy51c2R0VGlwRGlzcGxheSA9IFwiZ29uZVwiO1xuICAgICAgLy8g6I635Y+W6LWE5Lqn5p2l5rqQXG4gICAgbGV0IGZsZXhpYmxlQXNzZXRzID0gZWxlbWVudC5mdW5kTGlzdERhdGE7XG4gICAgY29uc29sZS5sb2coYGNvbmZyaW0gZGlhbG9nIHNob3dpbmcuLiBhc3NldCBMaXN0IGlzICA9ICR7SlNPTi5zdHJpbmdpZnkoZmxleGlibGVBc3NldHMpfWApO1xuICAgIGlmICh0eXBlb2YoZmxleGlibGVBc3NldHMpICE9ICd1bmRlZmluZWQnICYmIGZsZXhpYmxlQXNzZXRzICE9IG51bGwpIHtcbiAgICAgIGxldCBhbGxBc3NldHMgPSBmbGV4aWJsZUFzc2V0cy5pdGVtcztcbiAgICAgIGlmICh0eXBlb2YoYWxsQXNzZXRzKSAhPSAndW5kZWZpbmVkJykge1xuICAgICAgICBjb25zb2xlLmxvZyhgY29uZnJpbSBkaWFsb2cgc2hvd2luZy4uIGFsbEFzc2V0cyBjb250ZW50IGlzICA9ICR7SlNPTi5zdHJpbmdpZnkoYWxsQXNzZXRzKX1gKTtcbiAgICAgICAgLy8g6YGN5Y6G6I635Y+W6LWE5Lqn5p2l5rqQ57uE5oiQXG4gICAgICAgIGZvcihsZXQgaSA9IDA7IGk8IGFsbEFzc2V0cy5sZW5ndGg7IGkgKyspIHtcbiAgICAgICAgICBsZXQgaXRlbSA9IGFsbEFzc2V0c1tpXTtcbiAgICAgICAgICBjb25zb2xlLmxvZyhgY29uZnJpbSBkaWFsb2cgc2hvd2luZy4uIGFsbEFzc2V0cyBzb3VyY2UgID0gJHtpdGVtLnNvdXJjZX1gKTtcbiAgICAgICAgICBpZiAoaXRlbS5jaGVja0ltZyAhPSBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9jb3B5X3RyYWRpbmdfc2VsZWN0XCIpIHtcbiAgICAgICAgICAgIC8vIOWmguaenOayoeaciemAieS4re+8jOWImei3s+i/h+atpOasoeWIpOaWrVxuICAgICAgICAgICAgY29udGludWU7XG4gICAgICAgICAgfVxuICAgICAgICAgIGlmIChpdGVtLmJhbGFuY2UgPiAwKXtcbiAgICAgICAgICAgIC8vIOWPquacieS9memineWkp+S6jjAg5omN5aSE55CGYW10U291cmNlXG4gICAgICAgICAgICBjb25zb2xlLmxvZyhgY29uZnJpbSBkaWFsb2cgc2hvd2luZy4uIGFtdFNvdWNlICs9ICR7aXRlbS5zb3VyY2V9YCk7XG4gICAgICAgICAgICAkZGF0YS5kaWFsb2cuYW10U291cmNlICs9IGl0ZW0uc291cmNlO1xuICAgICAgICAgIH1cbiAgICAgICAgICBpZiAoaXRlbS5zb3VyY2UgPT0gc291cmNlRW51bS51c2RkU291cmNlKSB7XG4gICAgICAgICAgICAvLyDlvZPliY3luIHnp40o546w6LSn5L2Z6aKdKVxuICAgICAgICAgICAgbGV0IGRpZmYgPSBudW1iZXIuc3VidHJhY3QoaXRlbS5iYWxhbmNlLCBpbnB1dHZhbHVlKTtcbiAgICAgICAgICAgICRkYXRhLmRpYWxvZy51c2RkUmVzdCA9IGRpZmY7XG4gICAgICAgICAgICBjb25zb2xlLmxvZyhgY29uZnJpbSBkaWFsb2cgc2hvd2luZy4uIGRpZmYgID0gJHtkaWZmfWApO1xuICAgICAgICAgICAgaWYgKGRpZmYgPCAwKSB7XG4gICAgICAgICAgICAgIC8vIOeUqOWIsFVTRFTmirXmiaNcbiAgICAgICAgICAgICAgJGRhdGEuZGlhbG9nLnVzZHRUaXBEaXNwbGF5ID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgICAgICAgIC8vIFVTRFQg5o+Q56S65paH5qGIXG4gICAgICAgICAgICAgIGxldCBuZXdEaWZmID0gY29tbW9uLnJlbW92ZUV4dHJhWmVyb3MoY29tbW9uLmZvcm1hdFByZWNpc2lvbihkaWZmLCA4KSk7XG4gICAgICAgICAgICAgICRkYXRhLmRpYWxvZy51c2R0VGlwID0gJGkxOG4uJGludGVyY2VwdC5uX2NvbmZpcm1fcHVyY2hhc2VfdGlwKGAkey1uZXdEaWZmfWApO1xuICAgICAgICAgICAgICAvLyDotYTph5HmnaXmupDlrZDliJfooajmlbDmja5cbiAgICAgICAgICAgICAgaWYgKGl0ZW0uYmFsYW5jZSA+IDApIHtcbiAgICAgICAgICAgICAgICBsZXQgbmV3QmFsYW5jZSA9IGNvbW1vbi5yZW1vdmVFeHRyYVplcm9zKGNvbW1vbi5mb3JtYXRQcmVjaXNpb24oaXRlbS5iYWxhbmNlLCA4KSk7XG4gICAgICAgICAgICAgICAgbGV0IHVzZGRBc3NldCA9IHtcbiAgICAgICAgICAgICAgICAgIHR5cGU6XCI1XCIsXG4gICAgICAgICAgICAgICAgICBjdXJyZW5jeTogJGkxOG4uJGludGVyY2VwdC5uX3VzZV9jZXJ0YWluX2N1cnJlbmN5X2Fzc2V0KGAkeyRkYXRhLmhvbWUuY3VycmVuY3l9YCksXG4gICAgICAgICAgICAgICAgICB2YWx1ZTpgJHtuZXdCYWxhbmNlfSAkeyRkYXRhLmhvbWUuY3VycmVuY3l9YFxuICAgICAgICAgICAgICAgIH07XG4gICAgICAgICAgICAgICAgJGRhdGEuZGlhbG9nLmFzc2V0Q29tYmluZURhdGEucHVzaCh1c2RkQXNzZXQpO1xuICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgIGxldCB1c2R0QXNzZXQgPSB7XG4gICAgICAgICAgICAgICAgdHlwZTpcIjVcIixcbiAgICAgICAgICAgICAgICBjdXJyZW5jeTogJGkxOG4uJGludGVyY2VwdC5uX3VzZV9jZXJ0YWluX2N1cnJlbmN5X2Fzc2V0KGBVU0RUYCksXG4gICAgICAgICAgICAgICAgdmFsdWU6YCR7LW5ld0RpZmZ9IFVTRFRgXG4gICAgICAgICAgICAgIH07XG4gICAgICAgICAgICAgICRkYXRhLmRpYWxvZy5hc3NldENvbWJpbmVEYXRhLnB1c2godXNkdEFzc2V0KTtcbiAgICAgICAgICAgIH1cbiAgICAgICAgICB9IGVsc2UgaWYgKGl0ZW0uc291cmNlID09IHNvdXJjZUVudW0udXNkdFNvdXJjZSkge1xuICAgICAgICAgICAgLy8gVVNEVCjnjrDotKfkvZnpop0pXG4gICAgICAgICAgICBpZiAoJGRhdGEuZGlhbG9nLnVzZGRSZXN0ID09IGlucHV0dmFsdWUpIHtcbiAgICAgICAgICAgICAgJGRhdGEuZGlhbG9nLnVzZHRUaXBEaXNwbGF5ID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgICAgICAgICRkYXRhLmRpYWxvZy51c2R0VGlwID0gJGkxOG4uJGludGVyY2VwdC5uX2NvbmZpcm1fcHVyY2hhc2VfdGlwKGAke2lucHV0dmFsdWV9YCk7XG4gICAgICAgICAgICAgIGxldCBuZXdJbnB1dFZhbHVlID0gY29tbW9uLnJlbW92ZUV4dHJhWmVyb3MoY29tbW9uLmZvcm1hdFByZWNpc2lvbihpbnB1dHZhbHVlLCA4KSk7XG4gICAgICAgICAgICAgIGxldCB1c2R0QXNzZXQgPSB7XG4gICAgICAgICAgICAgICAgdHlwZTpcIjVcIixcbiAgICAgICAgICAgICAgICBjdXJyZW5jeTogJGkxOG4uJGludGVyY2VwdC5uX3VzZV9jZXJ0YWluX2N1cnJlbmN5X2Fzc2V0KGBVU0RUYCksXG4gICAgICAgICAgICAgICAgdmFsdWU6YCR7bmV3SW5wdXRWYWx1ZX0gVVNEVGBcbiAgICAgICAgICAgICAgfTtcbiAgICAgICAgICAgICAgJGRhdGEuZGlhbG9nLmFzc2V0Q29tYmluZURhdGEucHVzaCh1c2R0QXNzZXQpO1xuICAgICAgICAgICAgfVxuICAgICAgICAgIH1cbiAgICAgICAgfVxuICAgICAgfVxuICAgICBcbiAgICB9XG4gICAgXG4gICAgaWYgKCRkYXRhLmRpYWxvZy5hbXRTb3VyY2UgPT0gMCkge1xuICAgICAgJGRhdGEuZGlhbG9nLmFtdFNvdXJjZSA9IDE7XG4gICAgfVxuICAgIGFuYWx5dGljcy5jb25maXJtSW5mb1Nob3coZWxlbWVudCk7XG4gIH0sXG5cbiAgY2xvc2VDb25maXJtRGlhbG9nKCkge1xuICAgICRkYXRhLmRpYWxvZy5zaG93Q29uZmlybURpYWxvZyA9IGZhbHNlO1xuICB9LFxuXG4gIC8vIOWJqeS9meWPr+aKlSBjdXJyZW5jeTog5biBLCBwcm9qZWN077ya6aG555uuXG4gIHNob3dBdmFpbGFibGVRdW90YURpYWxvZyhwcm9qZWN0KSB7XG4gICAgaWYgKCFwcm9qZWN0KSB7XG4gICAgICByZXR1cm47XG4gICAgfVxuICAgIHZhciB0ZXh0Q29sb3IgPSBcIiM4QThBOEVcIjtcbiAgICB2YXIgaGlnaGxpZ2h0Q29sb3IgPSBcIiMwMDAwMDBcIjtcbiAgICBjb25zdCBjdXJyZW5jeSA9ICRkYXRhLmhvbWUuY3VycmVuY3k7XG5cbiAgICBpZiAoY29tbW9uLmNvbW1vbkRhdGEuY29sb3JNb2RlID09IDEpIHtcbiAgICAgIHRleHRDb2xvciA9IFwiIzVFNUU2MVwiO1xuICAgICAgaGlnaGxpZ2h0Q29sb3IgPSBcIiNFNkU2RTZcIjtcbiAgICB9XG4gICAgY29uc29sZS5sb2coYHNpbXBsZV9lYXJuX2RpYWxvZyB1c2VyUmVtYWluUXVvdGE9ICR7cHJvamVjdC51c2VyUmVtYWluUXVvdGF9IGF2YWlsYWJsZVF1b3RhPSAke3Byb2plY3QuYXZhaWxhYmxlUXVvdGF9ICR7cHJvamVjdC5wcm9qZWN0UmVtYWluQW10UGVyRGF5fSAtICR7cHJvamVjdC5zdXJwbHVzQW1vdW50fWApO1xuICAgIGxldCB1c2VyUmVtYWluUXVvdGEgPSBjb21tb24ucmVtb3ZlRXh0cmFaZXJvcyhjb21tb24uZ2V0UHJpY2VTdHJpbmcocHJvamVjdC51c2VyUmVtYWluUXVvdGEsIDgpKTtcbiAgICBsZXQgYXZhaWxhYmxlUXVvdGEgPSBjb21tb24ucmVtb3ZlRXh0cmFaZXJvcyhjb21tb24uZ2V0UHJpY2VTdHJpbmcocHJvamVjdC5hdmFpbGFibGVRdW90YSwgOCkpO1xuICAgIGlmIChwcm9qZWN0LnByb2plY3RSZW1haW5BbXRQZXJEYXkgIT0gbnVsbCkge1xuICAgICAgbGV0IHByb2plY3RSZW1haW5BbXRQZXJEYXkgPSBjb21tb24ucmVtb3ZlRXh0cmFaZXJvcyhjb21tb24uZ2V0UHJpY2VTdHJpbmcocHJvamVjdC5wcm9qZWN0UmVtYWluQW10UGVyRGF5LCA4KSk7XG4gICAgICAvLyDku4rml6XliankvZnlj6/mipVcbiAgICAgICRkYXRhLmRpYWxvZy5hdmFpbGFibGVRdW90YVRpdGxlID0gJGkxOG4ubl9zaW1wbGVfZWFybl9hdmFpbGFibGVfcXVvdGVfdG9kYXk7XG4gICAgICAkZGF0YS5kaWFsb2cucXVvdGFRMSA9ICRpMThuLm5fc2ltcGxlX2Vhcm5fd2hhdF9pc19hdmFpbGFibGVfcXVvdGFfdG9kYXk7XG4gICAgICAkZGF0YS5kaWFsb2cucXVvdGFBMSA9ICRpMThuLm5fc2ltcGxlX2Vhcm5fYXZhaWxhYmxlX3F1b3RhX3RvZGF5X2Fuc3dlcjtcbiAgICAgICRkYXRhLmRpYWxvZy5xdW90YVEyID0gJGkxOG4ubl9zaW1wbGVfZWFybl9hdmFpbGFibGVfcXVvdGFfY2FsY3VsYXQ7XG4gICAgICAkZGF0YS5kaWFsb2cucXVvdGFBMiA9ICRpMThuLm5fc2ltcGxlX2Vhcm5fYXZhaWxhYmxlX3F1b3RhX2NhbGN1bGF0X21ldGhvZDE7XG4gICAgICAkZGF0YS5kaWFsb2cucXVvdGFUZXh0MSA9IGA8c3BhbiBzdHlsZT1cImNvbG9yOiR7dGV4dENvbG9yfTsgZm9udC1zaXplOjE0cHg7XCI+JHskaTE4bi5uX3NpbXBsZV9lYXJuX3VzZXJfcmVtYWluX3F1b3Rhfe+8mjwvc3Bhbj48c3BhbiBzdHlsZT1cImNvbG9yOiR7aGlnaGxpZ2h0Q29sb3J9OyBmb250LXNpemU6MTRweDtcIj4ke3VzZXJSZW1haW5RdW90YX0gJHtjdXJyZW5jeX08L3NwYW4+YDtcbiAgICAgICRkYXRhLmRpYWxvZy5xdW90YVRleHQyID0gYDxzcGFuIHN0eWxlPVwiY29sb3I6JHt0ZXh0Q29sb3J9OyBmb250LXNpemU6MTRweDtcIj4keyRpMThuLm5fc2ltcGxlX2Vhcm5fcHJvamVjdF9yZW1haW5fcXVvdGFfdG9kYXl977yaPC9zcGFuPjxzcGFuIHN0eWxlPVwiY29sb3I6JHtoaWdobGlnaHRDb2xvcn07IGZvbnQtc2l6ZToxNHB4O1wiPiR7cHJvamVjdFJlbWFpbkFtdFBlckRheX0gJHtjdXJyZW5jeX08L3NwYW4+YDtcbiAgICAgICRkYXRhLmRpYWxvZy5xdW90YVRleHQzID0gYDxzcGFuIHN0eWxlPVwiY29sb3I6JHt0ZXh0Q29sb3J9OyBmb250LXNpemU6MTRweDtcIj4keyRpMThuLm5fc2ltcGxlX2Vhcm5fYXZhaWxhYmxlX3F1b3Rhfe+8mjwvc3Bhbj48c3BhbiBzdHlsZT1cImNvbG9yOiR7aGlnaGxpZ2h0Q29sb3J9OyBmb250LXNpemU6MTRweDtcIj4ke2F2YWlsYWJsZVF1b3RhfSAke2N1cnJlbmN5fTwvc3Bhbj5gO1xuICAgIH0gZWxzZSB7XG4gICAgICBsZXQgc3VycGx1c0Ftb3VudCA9IGNvbW1vbi5yZW1vdmVFeHRyYVplcm9zKGNvbW1vbi5nZXRQcmljZVN0cmluZyhwcm9qZWN0LnN1cnBsdXNBbW91bnQsIDgpKTtcbiAgICAgIC8vIOWJqeS9meWPr+aKlVxuICAgICAgJGRhdGEuZGlhbG9nLmF2YWlsYWJsZVF1b3RhVGl0bGUgPSAkaTE4bi5uX3NpbXBsZV9lYXJuX2F2YWlsYWJsZV9xdW90YTtcbiAgICAgICRkYXRhLmRpYWxvZy5xdW90YVExID0gJGkxOG4ubl9zaW1wbGVfZWFybl93aGF0X2lzX2F2YWlsYWJsZV9xdW90YTtcbiAgICAgICRkYXRhLmRpYWxvZy5xdW90YUExID0gJGkxOG4ubl9zaW1wbGVfZWFybl9hdmFpbGFibGVfcXVvdGFfYW5zd2VyO1xuICAgICAgJGRhdGEuZGlhbG9nLnF1b3RhUTIgPSAkaTE4bi5uX3NpbXBsZV9lYXJuX2F2YWlsYWJsZV9xdW90YV9jYWxjdWxhdDtcbiAgICAgICRkYXRhLmRpYWxvZy5xdW90YUEyID0gJGkxOG4ubl9zaW1wbGVfZWFybl9hdmFpbGFibGVfcXVvdGFfY2FsY3VsYXRfbWV0aG9kMjtcbiAgICAgICRkYXRhLmRpYWxvZy5xdW90YVRleHQxID0gYDxzcGFuIHN0eWxlPVwiY29sb3I6JHt0ZXh0Q29sb3J9OyBmb250LXNpemU6MTRweDtcIj4keyRpMThuLm5fc2ltcGxlX2Vhcm5fdXNlcl9yZW1haW5fcXVvdGF977yaPC9zcGFuPjxzcGFuIHN0eWxlPVwiY29sb3I6JHtoaWdobGlnaHRDb2xvcn07IGZvbnQtc2l6ZToxNHB4O1wiPiR7dXNlclJlbWFpblF1b3RhfSAke2N1cnJlbmN5fTwvc3Bhbj5gO1xuICAgICAgJGRhdGEuZGlhbG9nLnF1b3RhVGV4dDIgPSBgPHNwYW4gc3R5bGU9XCJjb2xvcjoke3RleHRDb2xvcn07IGZvbnQtc2l6ZToxNHB4O1wiPiR7JGkxOG4ubl9zaW1wbGVfZWFybl9wcm9qZWN0X3JlbWFpbl9xdW90YX3vvJo8L3NwYW4+PHNwYW4gc3R5bGU9XCJjb2xvcjoke2hpZ2hsaWdodENvbG9yfTsgZm9udC1zaXplOjE0cHg7XCI+JHtzdXJwbHVzQW1vdW50fSAke2N1cnJlbmN5fTwvc3Bhbj5gO1xuICAgICAgJGRhdGEuZGlhbG9nLnF1b3RhVGV4dDMgPSBgPHNwYW4gc3R5bGU9XCJjb2xvcjoke3RleHRDb2xvcn07IGZvbnQtc2l6ZToxNHB4O1wiPiR7JGkxOG4ubl9zaW1wbGVfZWFybl9hdmFpbGFibGVfcXVvdGF977yaPC9zcGFuPjxzcGFuIHN0eWxlPVwiY29sb3I6JHtoaWdobGlnaHRDb2xvcn07IGZvbnQtc2l6ZToxNHB4O1wiPiR7YXZhaWxhYmxlUXVvdGF9ICR7Y3VycmVuY3l9PC9zcGFuPmA7XG4gICAgfVxuICAgICRkYXRhLmRpYWxvZy5zaG93QXZhaWxhYmxlUXVvdGEgPSB0cnVlO1xuICB9LFxuXG4gIGNsb3NlQXZhaWxhYmxlUXVvdGFEaWFsb2coKSB7XG4gICAgJGRhdGEuZGlhbG9nLnNob3dBdmFpbGFibGVRdW90YSA9IGZhbHNlO1xuICB9LFxufTsiLCJpbXBvcnQgKiBhcyBjb21tb24gZnJvbSBcIi4vY29tbW9uXCI7XG5pbXBvcnQgKiBhcyBudW1iZXIgZnJvbSBcIi4vbnVtYmVyXCJcbmltcG9ydCAqIGFzIGFuYWx5dGljcyBmcm9tIFwiLi9hbmFseXRpY3NcIjtcblxudmFyIHByb2plY3RJZCA9IFwiXCI7XG52YXIgc2hlbGZUeXBlID0gXCJcIjtcblxuZnVuY3Rpb24gZGVmYXVsdERhdGEoKSB7XG4gIHJldHVybiB7XG4gICAgbG9hZGluZ0xvdHRpZVN0YXR1czogXCJzdG9wXCIsXG4gICAgaWNvblVybDogXCJcIixcbiAgICBjdXJyZW5jeTogXCJcIixcbiAgICBhcHk6IFwiXCIsXG4gICAgcmVjb21tZW5kU2hvdzogXCJnb25lXCIsXG4gICAgbGFiZWxTaG93OiBcImdvbmVcIixcbiAgICB0aXBzU2hvdzogXCJnb25lXCIsXG4gIH07XG59XG5cbmNvbnN0IHsgbW9kdWxlRGF0YSwgbW9kdWxlRXZlbnQgfSA9IGNvbW1vbi5tb2R1bGVEZWZpbmUoXCJyZXN1bHRcIiwgZGVmYXVsdERhdGEsIHsgb25DcmVhdGUgfSk7XG5sZXQgcGFyYW1zID0ge307XG4vLyByZXF1ZXN0U3VjY2Vzc1ZpZXcoMTY3ODU1NDM3MjUyNywgMTQ0NjQ0NzIzKVxuXG4vLyByZXN1bHRTdHI9Jm9yZGVySWQ9JnJlY29yZElkPSZwcm9kdWN0VHlwZT0ke+S6p+WTgeexu+Wei30mYXB5VHlwZT0ke+a0u+acnyAtIEFQWSDnsbvlnot9XG5mdW5jdGlvbiBvbkNyZWF0ZShwYXJhbSkge1xuICBjb25zb2xlLmxvZygnb25DcmVhdGUgcmVzdWx0JyArIHBhcmFtKTtcbiAgcGFyYW1zID0gSlNPTi5wYXJzZShwYXJhbSk7XG4gIG1vZHVsZURhdGEucmVzdWx0U3RyID0gcGFyYW1zLnJlc3VsdFN0ciA/IHBhcmFtcy5yZXN1bHRTdHIgOiBcIlwiO1xuICBzZXRUaW1lb3V0KCgpID0+IHtcbiAgICBtb2R1bGVEYXRhLmxvYWRpbmdMb3R0aWVTdGF0dXMgPSBcInBsYXlcIjtcbiAgfSwgNjAwKTtcblxuICBpZiAocGFyYW1zLnByb2R1Y3RUeXBlID09IDAgJiYgcGFyYW1zLmFweVR5cGUgPT0gMSkge1xuICAgIG1vZHVsZURhdGEudGlwc1Nob3cgPSBcImdvbmVcIlxuICB9IGVsc2Uge1xuICAgIG1vZHVsZURhdGEudGlwc1Nob3cgPSBcInZpc2libGVcIlxuICB9XG5cbiAgbW9kdWxlRGF0YS5yZWNvbW1lbmRTaG93ID0gXCJnb25lXCJcbiAgcmVxdWVzdFN1Y2Nlc3NWaWV3KHBhcmFtcy5vcmRlcklkLCBwYXJhbXMucmVjb3JkSWQpO1xuICBhbmFseXRpY3Muc3Vic2NyaWJlU3VjY2Vzc1Nob3coKTtcbn1cblxuYXN5bmMgZnVuY3Rpb24gcmVxdWVzdFN1Y2Nlc3NWaWV3KG9yZGVySWQsIHJlY29yZElkKSB7XG4gIGNvbnN0IHBhcmFtcyA9IHsgb3JkZXJJZCwgcmVjb3JkSWQgfTtcbiAgY29uc3QgZGF0YSA9IGF3YWl0IGNvbW1vbi5zZW5kUmVxdWVzdCgndjEvc2F2aW5nL21pbmluZy9vcmRlci9kZW1hbmQvc3VjY2Vzc1ZpZXcnLCBwYXJhbXMsIDEsIDAsIHsgXCJDb250ZW50LVR5cGVcIjogXCJhcHBsaWNhdGlvbi9qc29uXCIgfSk7XG4gIGlmIChkYXRhICE9IG51bGwpIHtcbiAgICBpZiAoZGF0YS5yZWNvbW1lbmQubGVuZ3RoID4gMCkge1xuICAgICAgY29uc3QgZWxlbWVudCA9IGRhdGEucmVjb21tZW5kWzBdO1xuICAgICAgbW9kdWxlRGF0YS5pY29uVXJsID0gY29tbW9uLmdldFBOR0ljb25VUkxCeUN1cnJlbmN5KGVsZW1lbnQuY3VycmVuY3kpXG4gICAgICBtb2R1bGVEYXRhLmN1cnJlbmN5ID0gZWxlbWVudC5jdXJyZW5jeS50b1VwcGVyQ2FzZSgpXG4gICAgICBtb2R1bGVEYXRhLmxhYmVsU2hvdyA9IGVsZW1lbnQucHJvamVjdExhYmVsVHlwZSA9PSAxID8gXCJ2aXNpYmxlXCIgOiBcImdvbmVcIlxuICAgICAgcHJvamVjdElkID0gYCR7ZWxlbWVudC5wcm9qZWN0SWR9YDtcbiAgICAgIHZhciBkZXNjcmJlID0gXCJcIlxuICAgICAgc2hlbGZUeXBlID0gZWxlbWVudC5zaGVsZlR5cGUgPyBTdHJpbmcoZWxlbWVudC5zaGVsZlR5cGUpIDogXCIwXCI7XG4gICAgICB2YXIgdGVybSA9IGVsZW1lbnQudGVybSA/IGAke2VsZW1lbnQudGVybX1gIDogXCItXCI7XG4gICAgICBzd2l0Y2ggKHNoZWxmVHlwZSkge1xuICAgICAgICBjYXNlIFwiMFwiOlxuICAgICAgICAgIGRlc2NyYmUgPSAkaTE4bi5uX3NpbXBsZV9lYXJuX3Jlc3VsdF9zaGVsZl9kZXNjcmliZTA7XG4gICAgICAgICAgYnJlYWs7XG4gICAgICAgIGNhc2UgXCIxXCI6XG4gICAgICAgICAgZGVzY3JiZSA9ICRpMThuLiRpbnRlcmNlcHQubl9zaW1wbGVfZWFybl9yZXN1bHRfc2hlbGZfZGVzY3JpYmUxKGAke3Rlcm19YCk7XG4gICAgICAgICAgYnJlYWs7XG4gICAgICAgIGNhc2UgXCIyXCI6XG4gICAgICAgICAgZGVzY3JiZSA9ICRpMThuLm5fc2ltcGxlX2Vhcm5fcmVzdWx0X3NoZWxmX2Rlc2NyaWJlMjtcbiAgICAgICAgICBicmVhaztcbiAgICAgICAgY2FzZSBcIjhcIjpcbiAgICAgICAgICBkZXNjcmJlID0gJGkxOG4ubl9zaW1wbGVfZWFybl9yZXN1bHRfc2hlbGZfZGVzY3JpYmU4O1xuICAgICAgICAgIGJyZWFrO1xuICAgICAgICBjYXNlIFwiMTFcIjpcbiAgICAgICAgICBkZXNjcmJlID0gJGkxOG4ubl9zaW1wbGVfZWFybl9yZXN1bHRfc2hlbGZfZGVzY3JpYmUxMTtcbiAgICAgICAgICBicmVhaztcbiAgICAgICAgZGVmYXVsdDpcbiAgICAgICAgICBicmVhaztcbiAgICAgIH1cbiAgICAgIG1vZHVsZURhdGEuZGVzY3JiZSA9IGRlc2NyYmVcblxuICAgICAgdmFyIHZpZXdZZWFyUmF0ZSA9IFwiXCI7XG4gICAgICB2YXIgbWF4Vmlld1llYXJSYXRlID0gXCJcIlxuICAgICAgaWYgKGVsZW1lbnQudmlld1llYXJSYXRlKSB7XG4gICAgICAgIHZpZXdZZWFyUmF0ZSA9IGAke2NvbW1vbi5mb3JtYXRQcmVjaXNpb24obnVtYmVyLm11bHRpcGx5KGVsZW1lbnQudmlld1llYXJSYXRlLCBcIjEwMFwiKSwgMil9JWBcbiAgICAgIH1cbiAgICAgIGlmIChlbGVtZW50Lm1heFZpZXdZZWFyUmF0ZSkge1xuICAgICAgICBtYXhWaWV3WWVhclJhdGUgPSBgfiAke2NvbW1vbi5mb3JtYXRQcmVjaXNpb24obnVtYmVyLm11bHRpcGx5KGVsZW1lbnQubWF4Vmlld1llYXJSYXRlLCBcIjEwMFwiKSwgMil9YFxuICAgICAgfVxuICAgICAgbW9kdWxlRGF0YS5hcHkgPSBgJHt2aWV3WWVhclJhdGV9JHttYXhWaWV3WWVhclJhdGV9YFxuXG4gICAgICBtb2R1bGVEYXRhLnJlY29tbWVuZFNob3cgPSBcInZpc2libGVcIlxuICAgIH1cbiAgfVxufVxuXG5tb2R1bGVFdmVudC5jaGVja015T3JkZXIgPSBmdW5jdGlvbiAoKSB7XG4gIC8vIHByb2R1Y3RUeXBlIDAt5rS75pyfIDEt5a6a5pyfXG4gIGNvbW1vbi5vcGVuVVJMKGAke2NvbW1vbi5jb21tb25EYXRhLmg1VXJsfS8ke2NvbW1vbi5jb21tb25EYXRhLmxhbmd1YWdlfS9maW5hbmNpYWwvZWFybi9hc3NldHMvaDU/dGFiSW5kZXg9JHtwYXJhbXMucHJvZHVjdFR5cGV9YCk7XG4gIGNvbW1vbi5jb250YWluZXJCYWNrKC0xKTtcbiAgYW5hbHl0aWNzLnN1YnNjcmliZVN1Y2Nlc3NWaWV3QXNzZXRzQ2xpY2soKTtcbn07XG5cbm1vZHVsZUV2ZW50LmNvbnRpbnVlQnV5ID0gZnVuY3Rpb24gKCkge1xuICBjb21tb24uY29udGFpbmVyQmFjaygpO1xuICBhbmFseXRpY3Muc3Vic2NyaWJlU3VjY2Vzc0NvbnRpbnVlQ2xpY2soKTtcbn07XG5cbm1vZHVsZUV2ZW50LmJhY2tDbGljayA9IGZ1bmN0aW9uICgpIHtcbiAgY29tbW9uLmNvbnRhaW5lckJhY2soKTtcbiAgYW5hbHl0aWNzLnN1YnNjcmliZVN1Y2Nlc3NDbG9zZUNsb3NlQ2xpY2soKTtcbn07XG5cbm1vZHVsZUV2ZW50LnJlY29tbWVuZENsaWNrID0gZnVuY3Rpb24gKCkge1xuICBpZiAoc2hlbGZUeXBlID09IFwiMTFcIikge1xuICAgIGNvbW1vbi5jb250YWluZXJCYWNrKC0xKTtcbiAgICBsZXQgdXJsMiA9IFwiaG9saWdlaXQ6Ly9vcGVuL3YxP2xvZ2luPTEmdXJsPWlodW9iaWdsb2JhbDovL20uaGJnLmNvbS9lZGdlZW5naW5lL2NvbnRhaW5lcj9zY2VuZT1zaGFya2ZpbiZyb290TmFtZT1ob21lJlwiO1xuICAgIGxldCB1cmwgPSBcImhvbGlnZWl0Oi8vb3Blbi92MT9sb2dpbj0xJnVybD1paHVvYmlnbG9iYWw6Ly9tLmhiZy5jb20vZWRnZWVuZ2luZS9jb250YWluZXI/c2NlbmU9ZWFybiZyb290TmFtZT1zdHJ1Y3R1cmVkJm5hdkNvbmZpZz1uYXRpdmUmdGFiPXNoYXJrZmluJmlzQ2xvc2U9dHJ1ZVwiO1xuICAgIGNvbW1vbi5vcGVuVVJMKHVybCk7XG4gIH0gZWxzZSB7XG4gICAgY29uc3QgcGFyYW1zID0geyBwcm9qZWN0SWQsIGN1cnJlbmN5OiBtb2R1bGVEYXRhLmN1cnJlbmN5LCBmcm9tVHlwZTogMSB9O1xuICAgICRldmVudC5ob21lLnJlbG9hZFdpdGhQYXJhbXMoSlNPTi5zdHJpbmdpZnkocGFyYW1zKSk7XG4gICAgY29tbW9uLmNvbnRhaW5lckJhY2soKTtcbiAgfVxufVxuIiwiaW1wb3J0ICogYXMgY29tbW9uIGZyb20gXCIuL2NvbW1vblwiO1xuaW1wb3J0ICogYXMgYW5hbHl0aWNzIGZyb20gXCIuL2FuYWx5dGljc1wiO1xuXG5jb25zdCB0YWcgPSBcInNpbXBsZV9lYXJuX3JlY2VpcHRfZGlhbG9nXCI7XG5cbiRkYXRhLnJlY2VpcHRkaWFsb2cgPSB7XG4gIGlzU2hvdzogZmFsc2UsIC8v5Yiw6LSm5pel5by55qGG5pi+56S6XG4gIHRpcFRleHQ6IFwiXCIsIC8v5Yiw6LSm5pel5by55qGG5pi+56S65YaF5a65XG59O1xuXG4kZXZlbnQucmVjZWlwdGRpYWxvZyA9IHtcbiAgLyoqXG4gICAqIOaJk+W8gOWumuacn+WIsOi0puaXpeW8ueahhlxuICAgKi9cbiAgb3BlblJlZ3VsYXJEaWFsb2c6IGZ1bmN0aW9uIChpbmRleCwgcmVjZWlwdERlbGF5RGF5cyA9IDApIHtcbiAgICBjb25zb2xlLmxvZyhgJHt0YWd9IG9wZW5SZWd1bGFyRGlhbG9nIGluZGV4PSAke2luZGV4fSByZWNlaXB0RGVsYXlEYXlzPSAke3JlY2VpcHREZWxheURheXN9YCk7XG4gICAgJGRhdGEucmVjZWlwdGRpYWxvZy50aXBUZXh0ID0gJGkxOG4uJGludGVyY2VwdC5uX3NpbXBsZV9lYXJuX3JlY2VpcHRfcmVndWxhcihgJHtyZWNlaXB0RGVsYXlEYXlzfWApO1xuICAgICRkYXRhLnJlY2VpcHRkaWFsb2cuaXNTaG93ID0gdHJ1ZTtcbiAgICBsZXQgZWxlbWVudCA9ICRldmVudC5ob21lLmdldEN1cnJlbnRFbGVtZW50KGluZGV4KTtcbiAgICBhbmFseXRpY3MuYXJyaXZhbERhdGVDbGljayhlbGVtZW50KTtcbiAgfSxcblxuICAvKipcbiAgICog5omT5byA5rS75pyf5Yiw6LSm5pel5by55qGGXG4gICAqL1xuICBvcGVuQ3VycmVudERpYWxvZzogZnVuY3Rpb24gKGluZGV4LCByZWRlZW1MaW1pdFBlckRheSkge1xuICAgIGNvbnNvbGUubG9nKGAke3RhZ30gb3BlbkN1cnJlbnREaWFsb2cgaW5kZXg9ICR7aW5kZXh9IHJlZGVlbUxpbWl0UGVyRGF5PSAke3JlZGVlbUxpbWl0UGVyRGF5fWApO1xuICAgIGlmIChyZWRlZW1MaW1pdFBlckRheSA+IDApIHtcbiAgICAgIGxldCBsaW1pdCA9IGNvbW1vbi5nZXRQcmljZVN0cmluZyhyZWRlZW1MaW1pdFBlckRheSwgMCk7XG4gICAgICBsZXQgbGltaXQyID0gY29tbW9uLmdldFByaWNlU3RyaW5nKHJlZGVlbUxpbWl0UGVyRGF5ICogMC43NSwgMCk7XG4gICAgICBsZXQgbGltaXQzID0gY29tbW9uLmdldFByaWNlU3RyaW5nKHJlZGVlbUxpbWl0UGVyRGF5ICogMC41LCAwKTtcbiAgICAgIGxldCBjdXJyZW5jeSA9ICRkYXRhLmhvbWUuY3VycmVuY3k7XG4gICAgICBsZXQgcDEgPSAkaTE4bi4kaW50ZXJjZXB0Lm5fc2ltcGxlX2Vhcm5fcmVjZWlwdF9mbGV4aWJsZTEoYCR7bGltaXR9YCwgYCR7Y3VycmVuY3l9YCk7XG4gICAgICBsZXQgcDIgPSAkaTE4bi4kaW50ZXJjZXB0Lm5fc2ltcGxlX2Vhcm5fcmVjZWlwdF9mbGV4aWJsZTIoYCR7bGltaXR9YCwgYCR7Y3VycmVuY3l9YCk7XG4gICAgICBsZXQgcDMgPSAkaTE4bi4kaW50ZXJjZXB0Lm5fc2ltcGxlX2Vhcm5fcmVjZWlwdF9mbGV4aWJsZTMoXG4gICAgICAgIGAke2xpbWl0Mn1gLFxuICAgICAgICBgJHtjdXJyZW5jeX1gLFxuICAgICAgICBgJHtsaW1pdDN9YCxcbiAgICAgICAgYCR7Y3VycmVuY3l9YCxcbiAgICAgICAgYCR7bGltaXR9YCxcbiAgICAgICAgYCR7Y3VycmVuY3l9YCxcbiAgICAgICAgYCR7bGltaXQzfWAsXG4gICAgICAgIGAke2N1cnJlbmN5fWBcbiAgICAgICk7XG4gICAgICBsZXQgcDQgPSAkaTE4bi4kaW50ZXJjZXB0Lm5fc2ltcGxlX2Vhcm5fcmVjZWlwdF9mbGV4aWJsZTQoKTtcbiAgICAgICRkYXRhLnJlY2VpcHRkaWFsb2cudGlwVGV4dCA9IGAke3AxfVxcbiR7cDJ9XFxuJHtwM31cXG4ke3A0fWA7XG4gICAgfSBlbHNlIHtcbiAgICAgICRkYXRhLnJlY2VpcHRkaWFsb2cudGlwVGV4dCA9IGAkeyRpMThuLm5fc2ltcGxlX2Vhcm5fcmVjZWlwdF9jdXJyZW50MX1cXG4keyRpMThuLm5fc2ltcGxlX2Vhcm5fcmVjZWlwdF9jdXJyZW50Mn1gO1xuICAgIH1cbiAgICAkZGF0YS5yZWNlaXB0ZGlhbG9nLmlzU2hvdyA9IHRydWU7XG4gICAgbGV0IGVsZW1lbnQgPSAkZXZlbnQuaG9tZS5nZXRDdXJyZW50RWxlbWVudChpbmRleCk7XG4gICAgYW5hbHl0aWNzLmFycml2YWxEYXRlQ2xpY2soZWxlbWVudCk7XG4gIH0sXG5cbiAgY2xvc2VEaWFsb2c6IGZ1bmN0aW9uICgpIHtcbiAgICAkZGF0YS5yZWNlaXB0ZGlhbG9nLmlzU2hvdyA9IGZhbHNlO1xuICB9LFxufTtcbiIsImltcG9ydCAqIGFzIGFuYWx5dGljcyBmcm9tIFwiLi9hbmFseXRpY3NcIjtcblxuZXhwb3J0IGNvbnN0IGF1dG9FYXJuUmVzID0ge1xuICB0aXRsZTogJGkxOG4ubl9vdGNfdXNlX3RpcCxcbiAgY29udGVudDogJGkxOG4ubl9zaW1wbGVfZWFybl9hdXRvX2Vhcm5fY29udGVudF9uZXcsXG59O1xuXG4kZGF0YS5hdXRvZWFybiA9IHtcbiAgaXNTaG93OiBmYWxzZSwgLy/oh6rliqjotZrluIHlvLnmoYbmmL7npLpcbiAgdGlwVGl0bGU6IGF1dG9FYXJuUmVzLnRpdGxlLCAvL+iHquWKqOi1muW4geW8ueahhuagh+mimFxuICB0aXBDb250ZW50OiBhdXRvRWFyblJlcy5jb250ZW50LCAvL+iHquWKqOi1muW4geW8ueahhuaYvuekuuWGheWuuVxufTtcblxuJGV2ZW50LmF1dG9lYXJuID0ge1xuICBzZXRDb250ZW50OiBmdW5jdGlvbiAodGl0bGUsIGNvbnRlbnQpIHtcbiAgICAkZGF0YS5hdXRvZWFybi50aXBUaXRsZSA9IHRpdGxlO1xuICAgICRkYXRhLmF1dG9lYXJuLnRpcENvbnRlbnQgPSBjb250ZW50O1xuICB9LFxuXG4gIG9wZW5EaWFsb2c6IGZ1bmN0aW9uICgpIHtcbiAgICAkZGF0YS5hdXRvZWFybi5pc1Nob3cgPSB0cnVlO1xuICAgIGFuYWx5dGljcy5hdXRvRWFybkV4cGxhaW5DbGljaygpO1xuICB9LFxuXG4gIGNsb3NlRGlhbG9nOiBmdW5jdGlvbiAoKSB7XG4gICAgJGRhdGEuYXV0b2Vhcm4uaXNTaG93ID0gZmFsc2U7XG4gIH0sXG59O1xuIiwiZXhwb3J0IGNvbnN0IHB1cmNoYXNlVGlwUmVzID0ge1xuICB0aXRsZTogJGkxOG4ubl9vdGNfdXNlX3RpcCxcbiAgY29udGVudDone1wiY29udGVudFwiOlwibl91c2R0X2V4Y2hhbmdlX3VzZGRfdGlwXCIsXCJ0ZXh0Q29sb3JcIjpcImtDb2xvclByaW1hcnlUZXh0XCIsXCJ0ZXh0U2l6ZVwiOjE0LFwiaGlnaGxpZ2h0XCI6W3tcImNvbnRlbnRcIjpcIm5fdXNkdF9leGNoYW5nZV91c2RkX3RpcF9rZXl3b3JkXCIsXCJsaW5rXCI6XCJcIixcInRleHRDb2xvclwiOlwia0NvbG9yUHJpbWFyeVRleHRcIixcImJvbGRcIjp0cnVlfV19J1xufTtcblxuJGRhdGEucHVyY2hhc2VUaXAgPSB7XG4gIGlzU2hvdzogZmFsc2UsIC8v5by55qGG5pi+56S6XG4gIHRpcFRpdGxlOiBwdXJjaGFzZVRpcFJlcy50aXRsZSwgLy/lvLnmoYbmoIfpophcbiAgdGlwQ29udGVudDogcHVyY2hhc2VUaXBSZXMuY29udGVudCwgLy/lvLnmoYbmmL7npLrlhoXlrrlcbn07XG5cbiRldmVudC5wdXJjaGFzZVRpcCA9IHtcbiAgc2V0Q29udGVudDogZnVuY3Rpb24gKHRpdGxlLCBjb250ZW50KSB7XG4gICAgJGRhdGEucHVyY2hhc2VUaXAudGlwVGl0bGUgPSB0aXRsZTtcbiAgICAkZGF0YS5wdXJjaGFzZVRpcC50aXBDb250ZW50ID0gY29udGVudDtcbiAgfSxcblxuICBvcGVuRGlhbG9nOiBmdW5jdGlvbiAoKSB7XG4gICAgJGRhdGEucHVyY2hhc2VUaXAuaXNTaG93ID0gdHJ1ZTtcbiAgfSxcblxuICBjbG9zZURpYWxvZzogZnVuY3Rpb24gKCkge1xuICAgICRkYXRhLnB1cmNoYXNlVGlwLmlzU2hvdyA9IGZhbHNlO1xuICB9LFxufTtcbiIsImltcG9ydCAqIGFzIGNvbW1vbiBmcm9tIFwiLi9jb21tb25cIjtcblxuY29uc3QgdGFnID0gXCJzaW1wbGVfZWFyblwiO1xuXG5jb25zdCBsYWRkZXJSZXMgPSB7XG4gIGFycm93VXA6IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX3N0cnV0dXJlZF9hcnJvd191cFwiLFxuICBhcnJvd0Rvd246IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX3N0cnV0dXJlZF9hcnJvd19kb3duXCIsXG5cbiAgLy/lhoXpg6jlvLnmoYbkvb/nlKhcbiAgc2VsZWN0ZWRDb2xvcjogXCJAY29sb3Iva0NvbG9yTWFqb3JUaGVtZTEwMFwiLFxuICB1bnNlbGVjdGVkQ29sb3I6IFwiQGNvbG9yL2tDb2xvclByaW1hcnlUZXh0XCIsXG4gIHNlbGVjdGVkSW1nOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luX3NpbXBsZV9lYXJuX2xhZGRlcl9zZWxlY3RlZFwiLFxuICB1bnNlbGVjdGVkSW1nOiBcIlwiLFxufTtcblxuY2xhc3MgTGFkZGVySXRlbSB7XG4gIGFtb3VudFRleHQgPSBcIlwiO1xuICByYXRlID0gXCJcIjtcbiAgdHlwZSA9IFwiMVwiO1xuXG4gIHNldEFtb3VudFRleHQoaXRlbSwgY3VycmVuY3kpIHtcbiAgICBpZiAoaXRlbS5hbW91bnRFbmQgIT0gMCkge1xuICAgICAgdGhpcy5hbW91bnRUZXh0ID0gYCR7aXRlbS5hbW91bnRTdGFydH0gfiAke2l0ZW0uYW1vdW50RW5kfSAke2N1cnJlbmN5fWA7XG4gICAgfSBlbHNlIHtcbiAgICAgIHRoaXMuYW1vdW50VGV4dCA9IGA+ICR7aXRlbS5hbW91bnRTdGFydH0gJHtjdXJyZW5jeX1gO1xuICAgIH1cbiAgfVxufVxuXG4vKipcbiAqIOWGhemDqOi0p+W4geWIl+ihqFxuICovXG5jbGFzcyBMYWRkZXJJbm5lckl0ZW0ge1xuICBpbmRleCA9IC0xO1xuICBjdXJyZW5jeSA9IFwiXCI7XG4gIGN1cnJlbnRjeUltZyA9IFwiXCI7XG4gIGN1cnJlbmN5Q29sb3IgPSBcIlwiO1xuICBzZWxlY3RlZEltZyA9IFwiXCI7XG4gIHR5cGUgPSBcIjFcIjtcbn1cblxuLy/pmLbmoq/lubTljJblr7nlupTmlbDmja7ljLpcbiRkYXRhLmxhZGRlciA9IHtcbiAgaXNTaG93OiBmYWxzZSwgLy/lvLnmoYbmmL7npLpcbiAgdGl0bGU6ICRpMThuLm5fc2ltcGxlX2Vhcm5fbGFkZGVyX3RpdGxlLCAvL+agh+mimFxuICB0aXA6ICRpMThuLm5fc2ltcGxlX2Vhcm5fbGFkZGVyX2hpbnQsIC8v5o+Q56S6XG4gIGV4YW1wbGU6IFwiXCIsIC8v5Li+5L6LXG4gIGV4YW1wbGVWaXM6IFwiZ29uZVwiLCAvL+S4vuS+i+eahOaYvumakFxuICB0YWJsZVRpdGxlOiAkaTE4bi5uX3NpbXBsZV9lYXJuX2xhZGRlcl9hbGxfYXB5LCAvL+ihqOagvOagh+mimFxuICB0YWJsZUN1cnJlbmN5OiBcIlwiLCAvL+ihqOagvOW4geenjVxuICBhcnJvd0ltZzogbGFkZGVyUmVzLmFycm93RG93biwgLy/luIHnp43lsZXlvIDnmoTnrq3lpLRcbiAgaGVhZFRpdGxlOiAkaTE4bi5uX2Fzc2V0X3N1YnNjcmliZV9udW1iZXIsIC8v6KGo5qC856ys5LiA5YiX5qCH6aKYXG4gIGhlYWRUaXRsZTI6ICRpMThuLm5fc2ltcGxlX2Vhcm5fbGFkZGVyX2FweSwgLy/ooajmoLznrKzkuozliJfmoIfpophcbiAgbGFkZGVyTGlzdDogW10sIC8v6Zi25qKv5bm05YyW5pWw5o2u5YiX6KGoXG4gIGlzU2hvd0lubmVyOiBmYWxzZSwgLy/luIHnp43liIfmjaLlvLnmoYZcbiAgbGFkZGVySW5uZXJMaXN0OiBbXSwgLy/luIHnp43liJfooahcbn07XG5cbiRldmVudC5sYWRkZXIgPSB7XG4gIC8qKlxuICAgKiDliJ3lp4vljJbmiYDmnInlj6/nlKjluIHnp43liJfooahcbiAgICovXG4gIGluaXRDdXJyZW5jeURhdGE6IGZ1bmN0aW9uICgpIHtcbiAgICBnZXRDdXJyZW5jaWVzKCk7XG4gIH0sXG5cbiAgb3BlbkRpYWxvZzogYXN5bmMgZnVuY3Rpb24gKGluZGV4KSB7XG4gICAgbGV0IGN1cnJlbmN5ID0gJGRhdGEuaG9tZS5jdXJyZW5jeTtcbiAgICBjb25zb2xlLmxvZyhgJHt0YWd9IG9wZW5MYWRkZXJEaWFsb2cgJHtjdXJyZW5jeX1gKTtcbiAgICAkZGF0YS5sYWRkZXIudGFibGVDdXJyZW5jeSA9IGN1cnJlbmN5O1xuICAgIGZvciAobGV0IGkgPSAwOyBpIDwgJGRhdGEubGFkZGVyLmxhZGRlcklubmVyTGlzdC5sZW5ndGg7IGkrKykge1xuICAgICAgbGV0IGl0ZW0gPSAkZGF0YS5sYWRkZXIubGFkZGVySW5uZXJMaXN0W2ldO1xuICAgICAgaWYgKGN1cnJlbmN5ID09IGl0ZW0uY3VycmVuY3kpIHtcbiAgICAgICAgaXRlbS5jdXJyZW5jeUNvbG9yID0gbGFkZGVyUmVzLnNlbGVjdGVkQ29sb3I7XG4gICAgICAgIGl0ZW0uc2VsZWN0ZWRJbWcgPSBsYWRkZXJSZXMuc2VsZWN0ZWRJbWc7XG4gICAgICAgIGF3YWl0IGdldEN1clRpZXJlZFJhdGUoY3VycmVuY3kpO1xuICAgICAgfSBlbHNlIHtcbiAgICAgICAgaXRlbS5jdXJyZW5jeUNvbG9yID0gbGFkZGVyUmVzLnVuc2VsZWN0ZWRDb2xvcjtcbiAgICAgICAgaXRlbS5zZWxlY3RlZEltZyA9IGxhZGRlclJlcy51bnNlbGVjdGVkSW1nO1xuICAgICAgfVxuICAgIH1cbiAgICAkZGF0YS5sYWRkZXIuaXNTaG93ID0gdHJ1ZTtcbiAgfSxcblxuICBjbG9zZURpYWxvZzogZnVuY3Rpb24gKCkge1xuICAgICRkYXRhLmxhZGRlci5pc1Nob3cgPSBmYWxzZTtcbiAgfSxcblxuICAvL+eBq+W4gemAieaLqeeCueWHu+ebkeWQrFxuICBvbkl0ZW1DbGljazogZnVuY3Rpb24gKGlkeCkge1xuICAgIGNvbnNvbGUubG9nKGAke3RhZ30gb25JdGVtQ2xpY2sgaWR4PSAke2lkeH1gKTtcbiAgICBmb3IgKGxldCBpID0gMDsgaSA8ICRkYXRhLmxhZGRlci5sYWRkZXJJbm5lckxpc3QubGVuZ3RoOyBpKyspIHtcbiAgICAgIGxldCBpdGVtID0gJGRhdGEubGFkZGVyLmxhZGRlcklubmVyTGlzdFtpXTtcbiAgICAgIGlmIChpZHggPT0gaSkge1xuICAgICAgICAvL+WkhOeQhumAieS4reaAgVxuICAgICAgICBpdGVtLmN1cnJlbmN5Q29sb3IgPSBsYWRkZXJSZXMuc2VsZWN0ZWRDb2xvcjtcbiAgICAgICAgaXRlbS5zZWxlY3RlZEltZyA9IGxhZGRlclJlcy5zZWxlY3RlZEltZztcbiAgICAgICAgaWYgKCRkYXRhLmxhZGRlci50YWJsZUN1cnJlbmN5ICE9IGl0ZW0uY3VycmVuY3kpIHtcbiAgICAgICAgICAkZGF0YS5sYWRkZXIudGFibGVDdXJyZW5jeSA9IGl0ZW0uY3VycmVuY3k7XG4gICAgICAgICAgZ2V0Q3VyVGllcmVkUmF0ZShpdGVtLmN1cnJlbmN5KTtcbiAgICAgICAgfVxuICAgICAgfSBlbHNlIHtcbiAgICAgICAgaXRlbS5jdXJyZW5jeUNvbG9yID0gbGFkZGVyUmVzLnVuc2VsZWN0ZWRDb2xvcjtcbiAgICAgICAgaXRlbS5zZWxlY3RlZEltZyA9IGxhZGRlclJlcy51bnNlbGVjdGVkSW1nO1xuICAgICAgfVxuICAgIH1cbiAgICB0aGlzLmNsb3NlSW5uZXJEaWFsb2coKTtcbiAgfSxcblxuICBvcGVuSW5uZXJEaWFsb2c6IGZ1bmN0aW9uICgpIHtcbiAgICAkZGF0YS5sYWRkZXIuaXNTaG93SW5uZXIgPSB0cnVlO1xuICAgICRkYXRhLmxhZGRlci5hcnJvd0ltZyA9IGxhZGRlclJlcy5hcnJvd1VwO1xuICB9LFxuXG4gIGNsb3NlSW5uZXJEaWFsb2c6IGZ1bmN0aW9uICgpIHtcbiAgICAkZGF0YS5sYWRkZXIuaXNTaG93SW5uZXIgPSBmYWxzZTtcbiAgICAkZGF0YS5sYWRkZXIuYXJyb3dJbWcgPSBsYWRkZXJSZXMuYXJyb3dEb3duO1xuICB9LFxufTtcblxuLyoqXG4gKiDov5Tlm57miYDmnInlj6/nlKjnmoTmtLvmnJ/luIHnp43lkI3np7Dlkozkuqflk4FJRFxuICogL3YxL3NhdmluZy9taW5pbmcvcHJvZHVjdC9jdXJyZW5jaWVzXG4gKi9cbmFzeW5jIGZ1bmN0aW9uIGdldEN1cnJlbmNpZXMoKSB7XG4gIHRyeSB7XG4gICAgY29uc3QgZGF0YSA9IGF3YWl0IGNvbW1vbi5zZW5kUmVxdWVzdChcInYxL3NhdmluZy9taW5pbmcvcHJvZHVjdC9jdXJyZW5jaWVzXCIpO1xuICAgIGNvbnNvbGUubG9nKFwiZ2V0Q3VycmVuY2llcyBkYXRhPSBcIiArIEpTT04uc3RyaW5naWZ5KGRhdGEpKTtcbiAgICBpZiAoZGF0YSAhPSBudWxsKSB7XG4gICAgICByZWZyZXNoTGFkZGVySW5uZXJMaXN0KGRhdGEpO1xuICAgIH0gZWxzZSB7XG4gICAgICBjb25zb2xlLmxvZyhcImdldEN1cnJlbmNpZXMgZGF0YT09bnVsbCBcIik7XG4gICAgfVxuICB9IGNhdGNoIChlKSB7XG4gICAgY29uc29sZS5sb2coYGdldEN1cnJlbmNpZXMgZXJyb3IgPSAke2V9YCk7XG4gIH1cbn1cblxuZnVuY3Rpb24gcmVmcmVzaExhZGRlcklubmVyTGlzdChkYXRhKSB7XG4gIGxldCBsaXN0ID0gW107XG4gIGZvciAobGV0IGkgPSAwOyBpIDwgZGF0YS5sZW5ndGg7IGkrKykge1xuICAgIGxldCBpdGVtID0gZGF0YVtpXTtcbiAgICBsZXQgbGFkZGVySW5uZXIgPSBuZXcgTGFkZGVySW5uZXJJdGVtKCk7XG4gICAgbGFkZGVySW5uZXIuaW5kZXggPSBpO1xuICAgIGxhZGRlcklubmVyLmN1cnJlbmN5ID0gaXRlbTtcbiAgICBsYWRkZXJJbm5lci5jdXJyZW50Y3lJbWcgPSBjb21tb24uZ2V0UE5HSWNvblVSTEJ5Q3VycmVuY3koaXRlbSk7XG4gICAgaWYgKCRkYXRhLmxhZGRlci50YWJsZUN1cnJlbmN5ID09IGl0ZW0pIHtcbiAgICAgIGxhZGRlcklubmVyLmN1cnJlbmN5Q29sb3IgPSBsYWRkZXJSZXMuc2VsZWN0ZWRDb2xvcjtcbiAgICAgIGxhZGRlcklubmVyLnNlbGVjdGVkSW1nID0gbGFkZGVyUmVzLnNlbGVjdGVkSW1nO1xuICAgIH0gZWxzZSB7XG4gICAgICBsYWRkZXJJbm5lci5jdXJyZW5jeUNvbG9yID0gbGFkZGVyUmVzLnVuc2VsZWN0ZWRDb2xvcjtcbiAgICAgIGxhZGRlcklubmVyLnNlbGVjdGVkSW1nID0gbGFkZGVyUmVzLnVuc2VsZWN0ZWRJbWc7XG4gICAgfVxuICAgIGxpc3QucHVzaChsYWRkZXJJbm5lcik7XG4gIH1cbiAgJGRhdGEubGFkZGVyLmxhZGRlcklubmVyTGlzdCA9IGxpc3Q7XG59XG5cbi8qKlxuICog5qC55o2u5Lqn5ZOBSUTmiJbluIHnp43lkI3np7Dojrflj5bmtLvmnJ/kuqflk4HpmLbmoq/liKnnjodcbiAqIC92MS9zYXZpbmcvbWluaW5nL3Byb2R1Y3QvdGllcmVkX3JhdGVcbiAqL1xuYXN5bmMgZnVuY3Rpb24gZ2V0Q3VyVGllcmVkUmF0ZShjdXJyZW5jeU5hbWUpIHtcbiAgdHJ5IHtcbiAgICBsZXQgcGFyYW0gPSB7IGN1cnJlbmN5OiBjdXJyZW5jeU5hbWUgfTtcbiAgICBjb25zdCBkYXRhID0gYXdhaXQgY29tbW9uLnNlbmRSZXF1ZXN0KFwidjEvc2F2aW5nL21pbmluZy9wcm9kdWN0L3RpZXJlZF9yYXRlXCIsIHBhcmFtKTtcbiAgICBjb25zb2xlLmxvZyhgJHt0YWd9IGdldEN1clRpZXJlZFJhdGUgY3VycmVuY3lOYW1lPSAke2N1cnJlbmN5TmFtZX0gZGF0YT0gJHtKU09OLnN0cmluZ2lmeShkYXRhKX1gKTtcbiAgICBpZiAoZGF0YSAhPSBudWxsKSB7XG4gICAgICAkZGF0YS5sYWRkZXIudGFibGVDdXJyZW5jeSA9IGN1cnJlbmN5TmFtZTtcbiAgICAgIHJlZnJlc2hMYWRkZXJMaXN0KGRhdGEpO1xuICAgICAgc2V0RXhhbXBsZShkYXRhLCBjdXJyZW5jeU5hbWUpO1xuICAgIH0gZWxzZSB7XG4gICAgICBjb25zb2xlLmxvZyhgJHt0YWd9IGdldEN1clRpZXJlZFJhdGUgZGF0YT09bnVsbCBgKTtcbiAgICB9XG4gIH0gY2F0Y2ggKGUpIHtcbiAgICBjb25zb2xlLmxvZyhgJHt0YWd9IGdldEN1clRpZXJlZFJhdGUgZXJyb3IgPSAke2V9YCk7XG4gIH1cbn1cblxuZnVuY3Rpb24gcmVmcmVzaExhZGRlckxpc3QoZGF0YSkge1xuICBsZXQgbGlzdCA9IFtdO1xuICBpZiAoZGF0YS5sZW5ndGggPiAwKSB7XG4gICAgZm9yIChsZXQgaSA9IDA7IGkgPCBkYXRhLmxlbmd0aDsgaSsrKSB7XG4gICAgICBsZXQgaXRlbSA9IGRhdGFbaV07XG4gICAgICBsZXQgbGFkZGVyID0gbmV3IExhZGRlckl0ZW0oKTtcbiAgICAgIGxhZGRlci5zZXRBbW91bnRUZXh0KGl0ZW0sICRkYXRhLmxhZGRlci50YWJsZUN1cnJlbmN5KTtcbiAgICAgIGxhZGRlci5yYXRlID0gYCR7Y29tbW9uLmZvcm1hdFByZWNpc2lvbihpdGVtLnJhdGUgKiAxMDAsIDIpfSVgO1xuICAgICAgbGlzdC5wdXNoKGxhZGRlcik7XG4gICAgfVxuICB9IGVsc2Uge1xuICAgIGxldCBsYWRkZXIgPSBuZXcgTGFkZGVySXRlbSgpO1xuICAgIGxhZGRlci5hbW91bnRUZXh0ID0gYD4gMCAkeyRkYXRhLmxhZGRlci50YWJsZUN1cnJlbmN5fWA7XG4gICAgbGFkZGVyLnJhdGUgPSBcIjAlXCI7XG4gICAgbGlzdC5wdXNoKGxhZGRlcik7XG4gIH1cbiAgY29uc29sZS5sb2coYCR7dGFnfSByZWZyZXNoTGFkZGVyTGlzdCBsaXN0PSAke0pTT04uc3RyaW5naWZ5KGxpc3QpfWApO1xuICAkZGF0YS5sYWRkZXIubGFkZGVyTGlzdCA9IGxpc3Q7XG59XG5cbmZ1bmN0aW9uIHNldEV4YW1wbGUodGllcmVkUmF0ZXMsIGN1cnJlbmN5KSB7XG4gIGlmICh0aWVyZWRSYXRlcy5sZW5ndGggPiAxKSB7XG4gICAgbGV0IHJhdGUxID0gdGllcmVkUmF0ZXNbMF07XG4gICAgbGV0IHJhdGUyID0gdGllcmVkUmF0ZXNbMV07XG4gICAgbGV0IG51bTEgPSByYXRlMS5hbW91bnRFbmQgKiAxLjI7IC8v56ys5LiA6Zi25q615pyA5aSn55Sz6LSt5pWw55qEMS4y5YCNXG4gICAgbGV0IG51bTIgPSByYXRlMS5hbW91bnRFbmQgKiAwLjI7IC8v56ys5LiA6Zi25q615pyA5aSn55Sz6LSt5pWw55qEMC4y5YCNXG4gICAgbGV0IHJhdGVUZXh0MSA9IGNvbW1vbi5mb3JtYXRQcmVjaXNpb24ocmF0ZTEucmF0ZSAqIDEwMCwgMik7XG4gICAgbGV0IHJhdGVUZXh0MiA9IGNvbW1vbi5mb3JtYXRQcmVjaXNpb24ocmF0ZTIucmF0ZSAqIDEwMCwgMik7XG4gICAgY29uc29sZS5sb2coYCR7dGFnfSBzZXRFeGFtcGxlIHJhdGVUZXh0MT0gJHtyYXRlVGV4dDF9IHJhdGVUZXh0Mj0gJHtyYXRlVGV4dDJ9YCk7XG4gICAgJGRhdGEubGFkZGVyLmV4YW1wbGUgPSBjb21tb24uYWRhcHRlclBlcmNlbnRGbGFnKFxuICAgICAgJGkxOG4uJGludGVyY2VwdC5uX3NpbXBsZV9lYXJuX2xhZGRlcl9leGFtcGxlKFxuICAgICAgICBgJHtudW0xfWAsXG4gICAgICAgIGAke2N1cnJlbmN5fWAsXG4gICAgICAgIGAke3JhdGUxLmFtb3VudEVuZH1gLFxuICAgICAgICBgJHtjdXJyZW5jeX1gLFxuICAgICAgICBgJHtyYXRlVGV4dDF9YCxcbiAgICAgICAgYCR7bnVtMn1gLFxuICAgICAgICBgJHtjdXJyZW5jeX1gLFxuICAgICAgICBgJHtyYXRlVGV4dDJ9YFxuICAgICAgKVxuICAgICk7XG4gICAgJGRhdGEubGFkZGVyLmV4YW1wbGVWaXMgPSBcInZpc2libGVcIjtcbiAgfSBlbHNlIHtcbiAgICAkZGF0YS5sYWRkZXIuZXhhbXBsZVZpcyA9IFwiZ29uZVwiO1xuICB9XG59XG4iLCJpbXBvcnQgKiBhcyBjb21tb24gZnJvbSBcIi4vY29tbW9uXCI7XG5cbmNsYXNzIFByb2ZpdE92ZXJ2aWV3SXRlbSB7XG4gIGluZGV4ID0gLTE7XG4gIGN1cnJlbmN5ID0gXCJcIjtcbiAgcGVya0FweSA9IFwiXCI7XG4gIHBlcmtMaW1pdCA9IDA7XG59XG5cbiRkYXRhLnByb2ZpdE92ZXJ2aWV3ID0ge1xuICBpc1Nob3c6IGZhbHNlLCAvL+W8ueahhuaYvuekulxuICB0aXRsZTogJGkxOG4ubl9zaW1wbGVfZWFybl9wcm9maXRfb3ZlcnZpZXcsIC8v5qCH6aKYXG4gIHRhYmxlVGl0bGU6ICRpMThuLm5fc2ltcGxlX2Vhcm5fcG9fdGl0bGUsIC8v6KGo5qC85qCH6aKYXG4gIGhlYWRUaXRsZTogJGkxOG4ubl9kb3VibGVfY29pbl9lYXJuX2NvaW4sIC8v6KGo5qC85aS0XG4gIGhlYWRUaXRsZTI6ICRpMThuLm5fc2ltcGxlX2Vhcm5fcG9fcmV3YXJkX2xpbWl0LFxuICBoZWFkVGl0bGUzOiAkaTE4bi5uX3NpbXBsZV9lYXJuX3BvX3BlcmtfYXB5LFxuICBwcm9maXRPdmVydmlld0xpc3Q6IFtdLCAvL+ihpei0tOWIl+ihqDxQcm9maXRPdmVydmlld0l0ZW0+XG4gIHJld2FyZFJ1bGVUaXRsZTogXCJcIiwgLy/lpZblirHop4TliJnmoIfpophcbiAgcmV3YXJkUnVsZUNvbnRlbnQxOiBcIlwiLCAvL+WlluWKseinhOWImeWGheWuuTFcbiAgcmV3YXJkUnVsZUNvbnRlbnQyOiBcIlwiLCAvL+WlluWKseinhOWImeWGheWuuTJcbiAgZXhhbXBsZVRpdGxlOiBcIlwiLCAvL+S4vuS+i+agh+mimFxuICBleGFtcGxlQ29udGVudDE6IFwiXCIsIC8v5Li+5L6L5YaF5a65MVxuICBleGFtcGxlQ29udGVudDI6IFwiXCIsIC8v5Li+5L6L5YaF5a65MlxuICByZXdhcmRSdWxlVmlzOiBcImdvbmVcIiwgLy/lpZblirHop4TliJnmmL7npLpcbiAgZXhhbXBsZVZpczogXCJnb25lXCIsIC8v5Li+5L6L5pi+6ZqQXG59O1xuXG4kZXZlbnQucHJvZml0T3ZlcnZpZXcgPSB7XG4gIC8qKlxuICAgKiDliJ3lp4vljJbmlbDmja5cbiAgICovXG4gIGluaXREYXRhOiBmdW5jdGlvbiAoKSB7XG4gICAgZ2V0UGVya1JhdGVzKCk7XG4gIH0sXG5cbiAgb3BlbkRpYWxvZzogZnVuY3Rpb24gKCkge1xuICAgIGdldFBlcmtSYXRlcygpO1xuICAgICRkYXRhLnByb2ZpdE92ZXJ2aWV3LmlzU2hvdyA9IHRydWU7XG4gIH0sXG5cbiAgY2xvc2VEaWFsb2c6IGZ1bmN0aW9uICgpIHtcbiAgICAkZGF0YS5wcm9maXRPdmVydmlldy5pc1Nob3cgPSBmYWxzZTtcbiAgfSxcbn07XG5cbmZ1bmN0aW9uIHNldFJ1bGVBbmRFeGFtcGxlKG9yaUxpbWl0ID0gMTAwMCwgb3JpUmF0ZSA9IDEwLjApIHtcbiAgbGV0IGxhbmd1YWdlID0gY29tbW9uLmNvbW1vbkRhdGEubGFuZ3VhZ2U7XG4gIGNvbnNvbGUubG9nKGBzaW1wbGUtZWFybiBzZXRSdWxlQW5kRXhhbXBsZSBsYW5ndWFnZT0gJHtsYW5ndWFnZX1gKTtcbiAgbGV0IGxpbWl0ID0gb3JpTGltaXQ7IC8vVVNEVOWlluWKsemZkOminVxuICAgIGxldCBsaW1pdDUgPSA1ICogb3JpTGltaXQ7IC8vNeWAjeeahFVTRFTlpZblirHpmZDpop1cbiAgICBsZXQgcmF0ZSA9IGNvbW1vbi5mb3JtYXRQcmVjaXNpb24ob3JpUmF0ZSwgMik7IC8vVVNEVOeahOihpei0tOWQjuW5tOWMllxuICAgIGxldCByYXRlMSA9IGNvbW1vbi5mb3JtYXRQcmVjaXNpb24oMC40ICogb3JpUmF0ZSwgMik7IC8vNDAl55qEVVNEVOihpei0tOWQjuW5tOWMllxuICAgIGxldCByYXRlMiA9IGNvbW1vbi5mb3JtYXRQcmVjaXNpb24oMC42ICogb3JpUmF0ZSwgMik7IC8vNjAl55qEVVNEVOihpei0tOWQjuW5tOWMllxuICAgIGxldCByYXRlMyA9IGNvbW1vbi5mb3JtYXRQcmVjaXNpb24oNSAqIG9yaVJhdGUsIDIpOyAvLzXlgI3nmoRVU0RU6KGl6LS05ZCO5bm05YyWXG4gICAgJGRhdGEucHJvZml0T3ZlcnZpZXcucmV3YXJkUnVsZVRpdGxlID0gJGkxOG4ubl9zaW1wbGVfZWFybl9wb19yZXdhcmRfcnVsZV90aXRsZTtcbiAgICAkZGF0YS5wcm9maXRPdmVydmlldy5yZXdhcmRSdWxlQ29udGVudDEgPSBjb21tb24uYWRhcHRlclBlcmNlbnRGbGFnKFxuICAgICAgJGkxOG4uJGludGVyY2VwdC5uX3NpbXBsZV9lYXJuX3BvX3Jld2FyZF9ydWxlX2NvbnRlbnQxKGAke3JhdGV9YCwgYCR7bGltaXR9YCwgYCR7cmF0ZX1gLCBgJHtsaW1pdH1gKVxuICAgICk7XG4gICAgJGRhdGEucHJvZml0T3ZlcnZpZXcucmV3YXJkUnVsZUNvbnRlbnQyID0gY29tbW9uLmFkYXB0ZXJQZXJjZW50RmxhZyhcbiAgICAgICRpMThuLiRpbnRlcmNlcHQubl9zaW1wbGVfZWFybl9wb19yZXdhcmRfcnVsZV9jb250ZW50MihgJHtyYXRlfWApXG4gICAgKTtcbiAgaWYgKGxhbmd1YWdlID09IFwiemgtY25cIiB8fCBsYW5ndWFnZSA9PSBcInpoLWhrXCIpIHtcbiAgICAkZGF0YS5wcm9maXRPdmVydmlldy5leGFtcGxlVGl0bGUgPSAkaTE4bi5uX3NpbXBsZV9lYXJuX3BvX2V4YW1wbGVfdGl0bGU7XG4gICAgJGRhdGEucHJvZml0T3ZlcnZpZXcuZXhhbXBsZUNvbnRlbnQxID0gY29tbW9uLmFkYXB0ZXJQZXJjZW50RmxhZyhcbiAgICAgICRpMThuLiRpbnRlcmNlcHQubl9zaW1wbGVfZWFybl9wb19leGFtcGxlX2NvbnRlbnQxKFxuICAgICAgICBgJHtsaW1pdDV9YCxcbiAgICAgICAgYCR7cmF0ZTF9YCxcbiAgICAgICAgYCR7bGltaXR9YCxcbiAgICAgICAgYCR7cmF0ZX1gLFxuICAgICAgICBgJHtyYXRlMn1gLFxuICAgICAgICBgJHtsaW1pdH1gLFxuICAgICAgICBgJHtyYXRlMX1gXG4gICAgICApXG4gICAgKTtcbiAgICAkZGF0YS5wcm9maXRPdmVydmlldy5leGFtcGxlQ29udGVudDIgPSBjb21tb24uYWRhcHRlclBlcmNlbnRGbGFnKFxuICAgICAgJGkxOG4uJGludGVyY2VwdC5uX3NpbXBsZV9lYXJuX3BvX2V4YW1wbGVfY29udGVudDIoYCR7bGltaXQ1fWAsIGAke3JhdGUzfWAsIGAke3JhdGUzfWApXG4gICAgKTtcbiAgICAkZGF0YS5wcm9maXRPdmVydmlldy5leGFtcGxlVmlzID0gXCJ2aXNpYmxlXCI7XG4gICAgJGRhdGEucHJvZml0T3ZlcnZpZXcucmV3YXJkUnVsZVZpcyA9IFwidmlzaWJsZVwiO1xuICB9IGVsc2Uge1xuICAgICRkYXRhLnByb2ZpdE92ZXJ2aWV3LmV4YW1wbGVWaXMgPSBcImdvbmVcIjtcbiAgICAkZGF0YS5wcm9maXRPdmVydmlldy5yZXdhcmRSdWxlVmlzID0gXCJ2aXNpYmxlXCI7XG4gIH1cbn1cblxuLyoqXG4gKiDojrflj5bmiYDmnInluIHnp43ooaXotLTliKnnjodcbiAqIC92My9zYXZpbmcvbWluaW5nL3Byb2plY3QvcGVya1Byb2plY3RSZWNcbiAqL1xuYXN5bmMgZnVuY3Rpb24gZ2V0UGVya1JhdGVzKCkge1xuICB0cnkge1xuICAgIC8vIOWPguaVsOWPguiAg+eahGg15Lyg5Y+CXG4gICAgbGV0IHBhcmFtID0geyBpbmRleDogMCwgc2l6ZTogNTAwIH07XG4gICAgY29uc3QgZGF0YSA9IGF3YWl0IGNvbW1vbi5zZW5kUmVxdWVzdChcInYzL3NhdmluZy9taW5pbmcvcHJvamVjdC9wZXJrUHJvamVjdFJlY1wiLCBwYXJhbSk7XG4gICAgY29uc29sZS5sb2coXCJzaW1wbGUtZWFybiBnZXRQZXJrUmF0ZXMgZGF0YT0gXCIgKyBKU09OLnN0cmluZ2lmeShkYXRhKSk7XG4gICAgaWYgKGRhdGEgIT0gbnVsbCkge1xuICAgICAgbGV0IGxpc3QgPSBbXTtcbiAgICAgIGZvciAobGV0IGkgPSAwOyBpIDwgZGF0YS5sZW5ndGg7IGkrKykge1xuICAgICAgICBsZXQgaXRlbSA9IGRhdGFbaV07XG4gICAgICAgIC8v6L+H5ruk5pyq6YWN572u55qE5biB56eNXG4gICAgICAgIGlmIChpdGVtLnBlcmtBcHkgPT0gdW5kZWZpbmVkIHx8IGl0ZW0ucGVya0FweS5sZW5ndGggPT0gMCkge1xuICAgICAgICAgIGNvbnRpbnVlO1xuICAgICAgICB9XG4gICAgICAgIGxldCB0ZW1wID0gbmV3IFByb2ZpdE92ZXJ2aWV3SXRlbSgpO1xuICAgICAgICB0ZW1wLmluZGV4ID0gaTtcbiAgICAgICAgdGVtcC5jdXJyZW5jeSA9IGl0ZW0uY3VycmVuY3k7XG4gICAgICAgIHRlbXAucGVya0FweSA9IGl0ZW0ucGVya0FweTtcbiAgICAgICAgdGVtcC5wZXJrTGltaXQgPSBpdGVtLnBlcmtMaW1pdDtcbiAgICAgICAgdGVtcC50eXBlID0gXCIxXCI7XG4gICAgICAgIGxpc3QucHVzaCh0ZW1wKTtcbiAgICAgICAgaWYgKGl0ZW0uY3VycmVuY3kgPT0gXCJVU0RUXCIpIHtcbiAgICAgICAgICBsZXQgcGVya0FweSA9IGl0ZW0ucGVya0FweTtcbiAgICAgICAgICBwZXJrQXB5ID0gcGVya0FweS5zdWJzdHJpbmcoMCwgcGVya0FweS5sZW5ndGggLSAxKTtcbiAgICAgICAgICBzZXRSdWxlQW5kRXhhbXBsZShpdGVtLnBlcmtMaW1pdCwgcGVya0FweSk7XG4gICAgICAgIH1cbiAgICAgIH1cbiAgICAgIGNvbnNvbGUubG9nKFwic2ltcGxlLWVhcm4gZ2V0UGVya1JhdGVzIGVuZCBkYXRhPSBcIiArIEpTT04uc3RyaW5naWZ5KGxpc3QpKTtcbiAgICAgICRkYXRhLnByb2ZpdE92ZXJ2aWV3LnByb2ZpdE92ZXJ2aWV3TGlzdCA9IGxpc3Q7XG4gICAgICBpZiAoJGRhdGEucHJvZml0T3ZlcnZpZXcucmV3YXJkUnVsZSA9PSBcIlwiKSB7XG4gICAgICAgIHNldFJ1bGVBbmRFeGFtcGxlKCk7XG4gICAgICB9XG4gICAgfSBlbHNlIHtcbiAgICAgIHNldFJ1bGVBbmRFeGFtcGxlKCk7XG4gICAgICBjb25zb2xlLmxvZyhcInNpbXBsZS1lYXJuIGdldFBlcmtSYXRlcyBkYXRhPT1udWxsIFwiKTtcbiAgICB9XG4gIH0gY2F0Y2ggKGUpIHtcbiAgICBjb25zb2xlLmxvZyhgc2ltcGxlLWVhcm4gZ2V0UGVya1JhdGVzIGVycm9yID0gJHtlfWApO1xuICAgIHNldFJ1bGVBbmRFeGFtcGxlKCk7XG4gIH1cbn1cbiIsImltcG9ydCAqIGFzIGFuYWx5dGljcyBmcm9tIFwiLi9hbmFseXRpY3NcIjtcblxuY29uc3QgY291cG9uUmVzID0ge1xuICBzaXplMTogMTIsXG4gIHNpemUyOiAxNCxcbiAgY29sb3IxOiBcIkBjb2xvci9rQ29sb3JUaHJlZUxldmVsVGV4dFwiLFxuICBjb2xvcjI6IFwiQGNvbG9yL2tDb2xvclByaW1hcnlUZXh0XCIsXG4gIGZvbnRXZWlnaHQxOiA0MDAsXG4gIGZvbnRXZWlnaHQyOiA1MDAsXG59O1xuXG4kZGF0YS5jb3Vwb24gPSB7XG4gIGlzU2hvdzogZmFsc2UsIC8v5by55qGG5pi+56S6XG4gIHRhYmxlVGl0bGU6ICRpMThuLm5fc2ltcGxlX2Vhcm5fY291cG9uX2RpYWxvZ190aXRsZSwgLy/ooajmoLzmoIfpophcbiAgdGFibGVUaXRsZUNvbnRlbnQ6ICRpMThuLm5fc2ltcGxlX2Vhcm5fY291cG9uX2RpYWxvZ19jb250ZW50LCAvL+ihqOagvOagh+mimOWGheWuuVxuICBoZWFkVGl0bGU6ICRpMThuLm5fYXNzZXRfc3Vic2NyaWJlX251bWJlciwgLy/nlLPotK3mlbDph49cbiAgaGVhZFRpdGxlMjogJGkxOG4ubl9zaW1wbGVfZWFybl9vcmlnaW5hbF9jb3Vwb24sIC8v5Y6f5pyJQVBZXG4gIGhlYWRUaXRsZTM6ICRpMThuLm5fc2ltcGxlX2Vhcm5fZXh0cmFfY291cG9uLCAvL+mineWkluWKoOaBr0FQWVxuICBjb3Vwb25MaXN0OiBbXG4gICAge1xuICAgICAgdHlwZTogXCIxXCIsXG4gICAgICBhbW91bnQ6IFwiMS0xLDAwMCBVU0RUXCIsXG4gICAgICBhcHk6IFwiMjAuMDAlXCIsXG4gICAgICBwZXJrQXB5OiBgKzUuMDAlKDcpJHskaTE4bi5uX2RheX1gLFxuICAgICAgc2l6ZTogY291cG9uUmVzLnNpemUyLFxuICAgICAgY29sb3I6IGNvdXBvblJlcy5jb2xvcjIsXG4gICAgICBmb250V2VpZ2h0OiBjb3Vwb25SZXMuZm9udFdlaWdodDIsXG4gICAgfSxcbiAgICB7XG4gICAgICB0eXBlOiBcIjFcIixcbiAgICAgIGFtb3VudDogXCLvvJ4xLDAwMCBVU0RUXCIsXG4gICAgICBhcHk6IFwiMjAuMDAlXCIsXG4gICAgICBwZXJrQXB5OiAkaTE4bi5uX3NpbXBsZV9lYXJuX2NvdXBvbl9kaWFsb2dfbm9uZSxcbiAgICAgIHNpemU6IGNvdXBvblJlcy5zaXplMSxcbiAgICAgIGNvbG9yOiBjb3Vwb25SZXMuY29sb3IxLFxuICAgICAgZm9udFdlaWdodDogY291cG9uUmVzLmZvbnRXZWlnaHQxLFxuICAgIH0sXG4gIF0sXG4gIGJvdHRvbVRleHQxOiAkaTE4bi5uX3NpbXBsZV9lYXJuX2NvdXBvbl9kaWFsb2dfYm90dG9tMSxcbiAgYm90dG9tVGV4dDI6ICRpMThuLm5fc2ltcGxlX2Vhcm5fY291cG9uX2RpYWxvZ19ib3R0b20yLFxufTtcblxuJGV2ZW50LmNvdXBvbiA9IHtcbiAgb3BlbkRpYWxvZzogZnVuY3Rpb24gKGluZGV4KSB7XG4gICAgJGRhdGEuY291cG9uLmlzU2hvdyA9IHRydWU7XG4gICAgbGV0IGVsZW1lbnQgPSAkZXZlbnQuaG9tZS5nZXRDdXJyZW50RWxlbWVudChpbmRleCk7XG4gICAgYW5hbHl0aWNzLmNvdXBvbkV4cGxhaW5DbGljayhlbGVtZW50KTtcbiAgfSxcblxuICBjbG9zZURpYWxvZzogZnVuY3Rpb24gKCkge1xuICAgICRkYXRhLmNvdXBvbi5pc1Nob3cgPSBmYWxzZTtcbiAgfSxcbn07XG4iLCIvL+i1hOmHkeadpea6kOW8ueeql1xuaW1wb3J0ICogYXMgY29tbW9uIGZyb20gXCIuL2NvbW1vblwiO1xuaW1wb3J0ICogYXMgbnVtYmVyIGZyb20gXCIuL251bWJlclwiO1xuaW1wb3J0ICogYXMgYW5hbHl0aWNzIGZyb20gXCIuL2FuYWx5dGljc1wiO1xuY29uc3QgdGFnID0gXCJzaW1wbGVfZWFybl9mdW5kXCI7XG5cbmV4cG9ydCBjb25zdCBjb25zdGFuc1NwID0ge1xuICBtb2R1bGVOYW1lOiBcInNpbXBsZV9lYXJuXCIsXG4gIHNwS2V5VVNERDogXCJzaW1wbGVfZWFybl9VU0REXCIsXG4gIHNwS2V5VVNEVDogXCJzaW1wbGVfZWFybl9VU0RUXCIsXG59O1xuXG5jb25zdCBmdW5kUmVzID0ge1xuICBzZWxlY3RlZEltZzogXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfY29weV90cmFkaW5nX3NlbGVjdFwiLFxuICB1bnNlbGVjdGVkSW1nOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9jb3B5X3RyYWRpbmdfdW5zZWxlY3RcIixcblxuICBjb25maXJtQmdFbmFibGVDb2xvcjogXCJAY29sb3Iva0NvbG9yTWFqb3JUaGVtZTEwMFwiLFxuICBjb25maXJtVGV4dEVuYWJsZUNvbG9yOiBcIkBjb2xvci9LQmFzZVRleHRDb2xvclwiLFxuICBjb25maXJtVGV4dERpc2FibGVDb2xvcjogXCJAY29sb3Iva0NvbG9yVGhyZWVMZXZlbFRleHRcIixcbiAgY29uZmlybUJnRGlzYWJsZUNvbG9yOiBcIkBjb2xvci9rQ29sb3JFQkVCRUJcIixcbn07XG5cbiRkYXRhLmZ1bmQgPSB7XG4gIGlzU2hvdzogZmFsc2UsIC8v5by55qGG5pi+6ZqQXG4gIHRpcDFWaXM6IFwidmlzaWJsZVwiLCAvL+iHs+WwkeacieS4gOS4qumAieS4rVxuICB0aXAyVmlzOiBcImdvbmVcIiwgLy/kuIDkuKrpgInkuK3kuZ/msqHmnIlcbiAgaXRlbXM6IFtdLCAvL+WIl+ihqOaVsOaNrlxuICB0b3RhbEJhbGFuY2U6IFwiMTIzXCIsIC8v5oC75L2Z6aKdXG4gIGNvbmZpcm1UZXh0Q29sb3I6IFwiXCIsIC8v56Gu5a6a5oyJ6ZKu5a2X5L2T6aKc6ImyXG4gIGNvbmZpcm1CZ0NvbG9yOiBcIlwiLCAvL+ehruWumuaMiemSruminOiJslxuICBzdGF0dXNVU0REOiBmYWxzZSwgLy/kuIrmrKHotYTph5HpgInmi6nnirbmgIFcbiAgc3RhdHVzVVNEVDogZmFsc2UsXG59O1xuXG5mdW5jdGlvbiBnZXREZWZhdWx0RGF0YSgpIHtcbiAgcmV0dXJuIHtcbiAgICBpdGVtczogW10sIC8v5YiX6KGo5pWw5o2uXG4gIH07XG59XG5cbnZhciBjdXJJbmRleCA9IC0xO1xubGV0IHNlbGVjdFN0YXR1cyA9IDA7IC8vMOacqumAieS4re+8jDHpgInkuK0x5Liq77yMMuacqumAieS4rTLkuKpcblxuLyoqXG4gKiAxLuS9meminVxuICogMi7mj5DnpLpcbiAqIDMu56Gu5a6a5oyJ6ZKuXG4gKi9cbmZ1bmN0aW9uIHJlZnJlc2hGdW5kVUkoZWxlbWVudCkge1xuICBjb25zdCBpdGVtcyA9ICRkYXRhLmZ1bmQuaXRlbXM7XG4gIGxldCB0ZW1wQW1vdW50ID0gXCIwXCI7XG4gIHNlbGVjdFN0YXR1cyA9IDA7XG4gIGZvciAobGV0IGkgPSAwOyBpIDwgaXRlbXMubGVuZ3RoOyBpKyspIHtcbiAgICBjb25zdCBpdGVtID0gaXRlbXNbaV07XG4gICAgaWYgKGl0ZW0uY2hlY2tJbWcgPT0gZnVuZFJlcy5zZWxlY3RlZEltZykge1xuICAgICAgLy/pgInkuK1cbiAgICAgIHRlbXBBbW91bnQgPSBudW1iZXIuYWRkKHRlbXBBbW91bnQsIGl0ZW0uYmFsYW5jZSk7XG4gICAgICBzZWxlY3RTdGF0dXMrKztcbiAgICB9IGVsc2Uge1xuICAgICAgLy/mnKrpgInkuK1cbiAgICB9XG4gIH1cbiAgJGRhdGEuZnVuZC50b3RhbEJhbGFuY2UgPSB0ZW1wQW1vdW50O1xuICBpZiAoc2VsZWN0U3RhdHVzID4gMCkge1xuICAgICRkYXRhLmZ1bmQudGlwMVZpcyA9IFwidmlzaWJsZVwiO1xuICAgICRkYXRhLmZ1bmQudGlwMlZpcyA9IFwiZ29uZVwiO1xuICAgICRkYXRhLmZ1bmQuY29uZmlybVRleHRDb2xvciA9IGZ1bmRSZXMuY29uZmlybVRleHRFbmFibGVDb2xvcjtcbiAgICAkZGF0YS5mdW5kLmNvbmZpcm1CZ0NvbG9yID0gZnVuZFJlcy5jb25maXJtQmdFbmFibGVDb2xvcjtcbiAgfSBlbHNlIHtcbiAgICAkZGF0YS5mdW5kLnRpcDFWaXMgPSBcImdvbmVcIjtcbiAgICAkZGF0YS5mdW5kLnRpcDJWaXMgPSBcInZpc2libGVcIjtcbiAgICAkZGF0YS5mdW5kLmNvbmZpcm1UZXh0Q29sb3IgPSBmdW5kUmVzLmNvbmZpcm1UZXh0RGlzYWJsZUNvbG9yO1xuICAgICRkYXRhLmZ1bmQuY29uZmlybUJnQ29sb3IgPSBmdW5kUmVzLmNvbmZpcm1CZ0Rpc2FibGVDb2xvcjtcbiAgfVxufVxuXG5mdW5jdGlvbiB0cmFja0l0ZW1DbGljayhjdXJyZW5jeSwgaXNTZWxlY3QpIHtcbiAgaWYgKGN1cnJlbmN5ID09IFwiVVNERFwiKSB7XG4gICAgYW5hbHl0aWNzLmFzc2V0U291cmNlVVNEREl0ZW1DbGljayhpc1NlbGVjdCk7XG4gIH0gZWxzZSBpZihjdXJyZW5jeSA9PSBcIlVTRFRcIikge1xuICAgIGFuYWx5dGljcy5hc3NldFNvdXJjZVVTRFRJdGVtQ2xpY2soaXNTZWxlY3QpO1xuICB9XG59XG5cbiRldmVudC5mdW5kID0ge1xuICBjb25maXJtOiBmdW5jdGlvbiAoKSB7XG4gICAgaWYgKHNlbGVjdFN0YXR1cyA9PSAwKSB7XG4gICAgICByZXR1cm47XG4gICAgfVxuICAgIC8vIOehruiupOaMiemSrueCueWHu+Wfi+eCuVxuICAgIGFuYWx5dGljcy5hc3NldFNvdXJjZUNvbmZpcm1CdG5DbGljaygpO1xuXG4gICAgY29uc3QgZWxlbWVudCA9ICRkYXRhLmhvbWUuc2xpZGVyRGF0YVtjdXJJbmRleF07XG4gICAgY29uc3QgaXRlbXNPdXRlciA9IGVsZW1lbnQuZnVuZExpc3REYXRhLml0ZW1zO1xuICAgIGNvbnN0IGl0ZW1zID0gJGRhdGEuZnVuZC5pdGVtcztcbiAgICBsZXQgdG90YWxCYWxhbmNlID0gMDtcbiAgICBsZXQgdG90YWxDdXJyZW5jeSA9IFwiXCI7XG4gICAgZm9yIChsZXQgaSA9IDA7IGkgPCBpdGVtcy5sZW5ndGg7IGkrKykge1xuICAgICAgY29uc3QgaXRlbSA9IGl0ZW1zW2ldO1xuICAgICAgY29uc3Qga2V5ID0gaXRlbS5jdXJyZW5jeS50b1VwcGVyQ2FzZSgpID09PSBcIlVTRERcIiA/IGNvbnN0YW5zU3Auc3BLZXlVU0REIDogY29uc3RhbnNTcC5zcEtleVVTRFQ7XG4gICAgICBpZiAoaXRlbS5jaGVja0ltZyA9PSBmdW5kUmVzLnNlbGVjdGVkSW1nKSB7XG4gICAgICAgIGNvbW1vbi5zYXZlKGNvbnN0YW5zU3AubW9kdWxlTmFtZSwga2V5LCB0cnVlKTtcbiAgICAgICAgaWYgKGl0ZW0uY3VycmVuY3kudG9VcHBlckNhc2UoKSA9PT0gXCJVU0REXCIpIHtcbiAgICAgICAgICAkZGF0YS5mdW5kLnN0YXR1c1VTREQgPSB0cnVlO1xuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICRkYXRhLmZ1bmQuc3RhdHVzVVNEVCA9IHRydWU7XG4gICAgICAgIH1cbiAgICAgICAgdG90YWxCYWxhbmNlID0gbnVtYmVyLmFkZCh0b3RhbEJhbGFuY2UsIGl0ZW0uYmFsYW5jZSk7XG4gICAgICAgIHRvdGFsQ3VycmVuY3kgPSB0b3RhbEN1cnJlbmN5Lmxlbmd0aCA9PSAwID8gaXRlbS5jdXJyZW5jeSA6IGAoJHt0b3RhbEN1cnJlbmN5fSske2l0ZW0uY3VycmVuY3l9KWA7XG4gICAgICB9IGVsc2Uge1xuICAgICAgICBjb21tb24uc2F2ZShjb25zdGFuc1NwLm1vZHVsZU5hbWUsIGtleSwgZmFsc2UpO1xuICAgICAgICBpZiAoaXRlbS5jdXJyZW5jeS50b1VwcGVyQ2FzZSgpID09PSBcIlVTRERcIikge1xuICAgICAgICAgICRkYXRhLmZ1bmQuc3RhdHVzVVNERCA9IGZhbHNlO1xuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICRkYXRhLmZ1bmQuc3RhdHVzVVNEVCA9IGZhbHNlO1xuICAgICAgICB9XG4gICAgICB9XG4gICAgICBpdGVtc091dGVyW2ldLmNoZWNrSW1nID0gaXRlbS5jaGVja0ltZztcbiAgICB9XG4gICAgLy/liLfmlrDlpJblsYLmlbDmja5cbiAgICBlbGVtZW50LmFzc2V0U291cmNlRGVzYyA9ICRpMThuLiRpbnRlcmNlcHQubl9jYXNoX2Fzc2V0X2JhbGFuY2UoYCR7dG90YWxDdXJyZW5jeX1gKTtcbiAgICBlbGVtZW50LmJhbGFuY2UgPSB0b3RhbEJhbGFuY2U7XG4gICAgZWxlbWVudC5iYWxhbmNlVGV4dCA9IGAke2NvbW1vbi5yZW1vdmVFeHRyYVplcm9zKGNvbW1vbi5nZXRQcmljZVN0cmluZyh0b3RhbEJhbGFuY2UsIDgpKX1gO1xuICAgICRldmVudC5mbGV4aWJsZS5zdWJUZXh0Q2hhbmdlKGVsZW1lbnQubVN1YklucHV0LCBjdXJJbmRleCk7XG4gICAgJGV2ZW50LmZ1bmQuY2xvc2VEaWFsb2coKTtcbiAgfSxcblxuICBpdGVtQ2xpY2s6IGZ1bmN0aW9uIChpbmRleCkge1xuICAgIGNvbnNvbGUubG9nKGAke3RhZ30gaXRlbUNsaWNrIGN1ckluZGV4PSAke2N1ckluZGV4fSBpbmRleD0gJHtpbmRleH1gKTtcbiAgICBjb25zdCBlbGVtZW50ID0gJGRhdGEuaG9tZS5zbGlkZXJEYXRhW2N1ckluZGV4XTtcbiAgICBsZXQgaW1nID0gJGRhdGEuZnVuZC5pdGVtc1tpbmRleF0uY2hlY2tJbWc7XG4gICAgaWYgKGltZyA9PSBmdW5kUmVzLnNlbGVjdGVkSW1nKSB7XG4gICAgICBpbWcgPSBmdW5kUmVzLnVuc2VsZWN0ZWRJbWc7XG4gICAgICAvLyDpgInkuK0gLS0+IOS4jemAieS4rVxuICAgICAgdHJhY2tJdGVtQ2xpY2soJGRhdGEuZnVuZC5pdGVtc1tpbmRleF0uY3VycmVuY3ksIFwib2ZmXCIpO1xuICAgIH0gZWxzZSBpZiAoaW1nID09IGZ1bmRSZXMudW5zZWxlY3RlZEltZykge1xuICAgICAgaW1nID0gZnVuZFJlcy5zZWxlY3RlZEltZztcbiAgICAgIC8vIOS4jemAieS4rSAtLT4g6YCJ5LitXG4gICAgICB0cmFja0l0ZW1DbGljaygkZGF0YS5mdW5kLml0ZW1zW2luZGV4XS5jdXJyZW5jeSwgXCJvblwiKTtcbiAgICB9XG4gICAgJGRhdGEuZnVuZC5pdGVtc1tpbmRleF0uY2hlY2tJbWcgPSBpbWc7XG4gICAgcmVmcmVzaEZ1bmRVSShlbGVtZW50KTtcbiAgfSxcblxuICAvKipcbiAgICog5Yid5aeL5YyW5pWw5o2uXG4gICAqL1xuICBpbml0RGF0YTogZnVuY3Rpb24gKHN1Yk90aGVyQW10SW5mbywgZWxlbWVudCkge1xuICAgIGNvbnNvbGUubG9nKGAke3RhZ30gaW5pdERhdGEgc3RhcnQgc3ViT3RoZXJBbXRJbmZvPSAke0pTT04uc3RyaW5naWZ5KHN1Yk90aGVyQW10SW5mbyl9YCk7XG4gICAgY29uc3QgZnVuZERhdGEgPSBnZXREZWZhdWx0RGF0YSgpO1xuICAgIGZvciAobGV0IGkgPSAwOyBpIDwgc3ViT3RoZXJBbXRJbmZvLmxlbmd0aDsgaSsrKSB7XG4gICAgICBjb25zdCBpbmZvID0gc3ViT3RoZXJBbXRJbmZvW2ldO1xuICAgICAgY29uc3QgdGl0bGUgPSAkaTE4bi4kaW50ZXJjZXB0Lm5fY2FzaF9hc3NldF9iYWxhbmNlKGAke2luZm8uY3VycmVuY3l9YCk7XG4gICAgICBjb25zdCBjdXJyZW5jeSA9IGluZm8uY3VycmVuY3k7XG4gICAgICBjb25zdCBiYWxhbmNlID0gY29tbW9uLnJlbW92ZUV4dHJhWmVyb3MoY29tbW9uLmZvcm1hdFByZWNpc2lvbihpbmZvLmFtb3VudCwgOCkpO1xuICAgICAgbGV0IGNoZWNrSW1nID0gZnVuZFJlcy51bnNlbGVjdGVkSW1nO1xuICAgICAgbGV0IHNlbGVjdFN0YXR1cyA9IGluZm8uY3VycmVuY3kudG9VcHBlckNhc2UoKSA9PT0gXCJVU0REXCIgPyAkZGF0YS5mdW5kLnN0YXR1c1VTREQgOiAkZGF0YS5mdW5kLnN0YXR1c1VTRFQ7XG4gICAgICBjb25zb2xlLmxvZyhgJHt0YWd9IGluaXREYXRhIHNlbGVjdFN0YXR1cz0gJHtzZWxlY3RTdGF0dXN9YCk7XG4gICAgICBpZiAoc2VsZWN0U3RhdHVzICE9IG51bGwpIHtcbiAgICAgICAgaWYgKHNlbGVjdFN0YXR1cykge1xuICAgICAgICAgIGNoZWNrSW1nID0gZnVuZFJlcy5zZWxlY3RlZEltZztcbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICBjaGVja0ltZyA9IGZ1bmRSZXMudW5zZWxlY3RlZEltZztcbiAgICAgICAgfVxuICAgICAgfSBlbHNlIHtcbiAgICAgICAgY2hlY2tJbWcgPSBpbmZvLmN1cnJlbmN5ID09PSBcIlVTRERcIiA/IGZ1bmRSZXMuc2VsZWN0ZWRJbWcgOiBmdW5kUmVzLnVuc2VsZWN0ZWRJbWc7XG4gICAgICB9XG4gICAgICBjb25zdCBzb3VyY2UgPSBpbmZvLnNvdXJjZTtcbiAgICAgIGNvbnN0IHR5cGUgPSBcIjFcIjtcbiAgICAgIGNvbnN0IGluZGV4ID0gaTtcbiAgICAgIGxldCBpdGVtID0geyB0aXRsZSwgYmFsYW5jZSwgY2hlY2tJbWcsIHNvdXJjZSwgY3VycmVuY3ksIHR5cGUsIGluZGV4IH07XG4gICAgICBmdW5kRGF0YS5pdGVtcy5wdXNoKGl0ZW0pO1xuICAgIH1cbiAgICBjb25zb2xlLmxvZyhgJHt0YWd9IGluaXREYXRhIGl0ZW1zPSAke0pTT04uc3RyaW5naWZ5KGZ1bmREYXRhLml0ZW1zKX1gKTtcbiAgICBlbGVtZW50LmZ1bmRMaXN0RGF0YSA9IGZ1bmREYXRhO1xuICAgIGNvbnNvbGUubG9nKGAke3RhZ30gaW5pdERhdGEgZW5kYCk7XG4gIH0sXG5cbiAgb3BlbkRpYWxvZzogZnVuY3Rpb24gKGluZGV4KSB7XG4gICAgY29uc29sZS5sb2coYCR7dGFnfSBvcGVuRGlhbG9nIGluZGV4PSAke2luZGV4fWApO1xuICAgIGN1ckluZGV4ID0gaW5kZXg7XG4gICAgbGV0IGVsZW1lbnQgPSAkZGF0YS5ob21lLnNsaWRlckRhdGFbaW5kZXhdO1xuICAgIGNvbnNvbGUubG9nKGAke3RhZ30gb3BlbkRpYWxvZyBpdGVtcz0gJHtKU09OLnN0cmluZ2lmeShlbGVtZW50LmZ1bmRMaXN0RGF0YS5pdGVtcyl9YCk7XG4gICAgJGRhdGEuZnVuZC5pdGVtcyA9IGVsZW1lbnQuZnVuZExpc3REYXRhLml0ZW1zO1xuICAgIHJlZnJlc2hGdW5kVUkoZWxlbWVudCk7XG4gICAgJGRhdGEuZnVuZC5pc1Nob3cgPSB0cnVlO1xuXG4gICAgLy8g5pud5YWJ5Z+L54K5XG4gICAgYW5hbHl0aWNzLmFzc2V0U291cmNlRGlhbG9nU2hvdygpO1xuICB9LFxuXG4gIGNsb3NlRGlhbG9nOiBmdW5jdGlvbiAoKSB7XG4gICAgY3VySW5kZXggPSAtMTtcbiAgICAkZGF0YS5mdW5kLmlzU2hvdyA9IGZhbHNlO1xuICB9LFxufTtcbiIsImltcG9ydCAqIGFzIGNvbW1vbiBmcm9tIFwiLi9jb21tb25cIjtcbmltcG9ydCAqIGFzIG51bWJlciBmcm9tIFwiLi9udW1iZXJcIjtcbmltcG9ydCAqIGFzIGNvdXBvbkxpc3QgZnJvbSBcIi4vY291cG9uTGlzdERpYWxvZ1wiO1xuaW1wb3J0ICogYXMgYW5hbHl0aWNzIGZyb20gXCIuL2FuYWx5dGljc1wiO1xuaW1wb3J0ICogYXMgZnVuZCBmcm9tIFwiLi9mdW5kRGlhbG9nXCJcblxuY29uc3QgdGFnID0gXCJzaW1wbGVfZWFyblwiO1xuY29uc3QgTUlOX0lOUFVUID0gMC4wMDAwMDAwMTtcbi8qKlxuICog6Zi25qKv5bm05YyW6LWE5rqQXG4gKi9cbmNvbnN0IGxhZGRlclJlcyA9IHtcbiAgbGFkZGVyU2VsZWN0ZWRDb2xvcjogXCJAY29sb3Iva0NvbG9yUHJpbWFyeVRleHRcIixcbiAgbGFkZGVyVW5zZWxlY3RlZENvbG9yOiBcIkBjb2xvci9rQ29sb3JUaHJlZUxldmVsVGV4dFwiLFxuICBsYWRkZXJTZWxlY3RlZEltZzogXCJAZHJhd2FibGUvZWRnZV9lbmdpbl9zaW1wbGVfZWFybl9jdXJyZW50X2xhZGRlcl9zZWxlY3RlZFwiLFxuICBsYWRkZXJVbnNlbGVjdGVkSW1nOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luX3NpbXBsZV9lYXJuX2N1cnJlbnRfbGFkZGVyX3Vuc2VsZWN0ZWRcIlxufVxuXG4vKipcbiAqIOiHquWKqOi1muW4geW8gOWFs+i1hOa6kFxuICovXG5jb25zdCBhdXRvRWFyblN3aXRjaFJlcyA9IHtcbiAgb3BlbkltZzogXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfY29tbW9uX3N3aXRjaF9vcGVuXCIsXG4gIGNsb3NlSW1nOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9jb21tb25fc3dpdGNoX2Nsb3NlXCIsXG59XG5cbmZ1bmN0aW9uIGRlZmF1bHREYXRhKCkge1xuICByZXR1cm4ge1xuICB9O1xufVxuXG5mdW5jdGlvbiBkZWZhdWx0SGFuZGxlckRhdGEoKSB7XG4gIHJldHVybiB7XG4gICAgc3ViSGludDogJGkxOG4uJGludGVyY2VwdC5uX3NoYXJrX2Zpbl9taW5fYW1vdW50KCcnKSwvL+eUs+i0reaVsOmHj+aPkOekuuivrVxuICAgIHN1YklucHV0OiBcIlwiLC8v55Sz6LSt5pWw6YeP6L6T5YWl5qGGXG4gICAgc3ViT25Gb2N1czogZmFsc2UsLy/nlLPotK3nhKbngrlcbiAgICBzdWJCb3JkZXJDb2xvcjogXCJAY29sb3IvS0Jhc2VDb2xvcklucHV0QmFja2dyb3VuZFwiLC8vXG4gICAgc3ViRXJyb3JTdHI6IFwiXCIsLy/nlLPotK3ovpPlhaXmoYbplJnor6/mlofmoYhcbiAgICBzdWJFcnJvclZpczogXCJnb25lXCIsLy9cbiAgICBlc3RpbWF0ZWRQcm9maXQ6IGAtLSAkeyRkYXRhLmhvbWUuY3VycmVuY3l9YCwvL+mihOS8sOaUtuebilxuICAgIHByb2ZpdEV2ZXJ5RGF5OiBcImdvbmVcIiwvL+mihOS8sOaUtuebiuaYr+WQpuWxleekulxuICAgIGF2YWlsYWJsZVF1b3RhOiBcIlwiLC8v5Ymp5L2Z5Y+v5oqVXG4gICAgYXZhaWxhYmxlUXVvdGFUZXh0OiBcIlwiLC8v5Ymp5L2Z5Y+v5oqV77yM5Y2D5YiG5L2NXG4gICAgYXZhaWxhYmxlUXVvdGFUaXRsZTogXCJcIiwvL1xuICAgIGFzc2V0U291cmNlVGl0bGU6IFwiXCIsIC8vIOi1hOmHkeadpea6kFxuICAgIGFzc2V0U291cmNlRGVzYzogXCJcIiwgLy8g6LWE6YeR5p2l5rqQIOWPs+S+p+aWh+Wtl+aYvuekulxuICAgIGFzc2V0U291cmNlRGlzcGxheTogXCJ2aXNpYmxlXCIsIC8vIHZpc2libGUsIGdvbmVcbiAgICBvcGVuQWNjb3VudEFsZXJ0U2hvdzogZmFsc2UsLy/lvIDpgJrmnJ/mnYPotKbmiLflvLnnqpdcbiAgICBjb3Vwb25WaXM6IFwiZ29uZVwiLC8v5Yqg5oGv5Yi45pW06KGM5pi+6ZqQXG4gICAgY291cG9uVGV4dFVwOiBcIlwiLC8v5Yqg5oGv5Yi45LiK6Z2i5paH5qGIXG4gICAgY291cG9uVGV4dERvd246IFwiXCIsLy/liqDmga/liLjkuIvpnaLmlofmoYhcbiAgICBjb3Vwb25UZXh0RG93blZpczogXCJ2aXNpYmxlXCIsLy/liqDmga/liLjkuIvpnaLmmL7npLpcbiAgICBjb3Vwb25SaWdodEltZ1ZpczogXCJ2aXNpYmxlXCIsLy/liqDmga/liLjmnIDlj7Povrnlm77moIdcbiAgICBjb3Vwb25NaWRWaXM6IFwidmlzaWJsZVwiLC8v5Yqg5oGv5Yi45Y+z5L6n5biD5bGA5pi+56S677yM5ZKMIGNvdXBvblRleHRNaWRWaXMg5LqS5palXG4gICAgY291cG9uVGV4dE1pZFZpczogXCJnb25lXCIsLy/liqDmga/liLjlj7PkvqfkuK3pl7TmlofmoYjmmL7npLpcbiAgICBjb3Vwb25UZXh0TWlkOiBcIlwiLC8v5Yqg5oGv5Yi45Y+z5L6n5Lit6Ze05paH5qGIXG5cbiAgICAvL+WKoOaBr+WIuOWIl+ihqOeahOaVsOaNrlxuICAgIGNvdXBvbkxpc3REYXRhOiB7fSxcbiAgICAvL+i1hOmHkeWIl+ihqOaVsOaNrlxuICAgIGZ1bmRMaXN0RGF0YToge30sXG5cbiAgICBiYWxhbmNlVGV4dDogXCJcIiwvL+a0u+acn+S9meminVxuICAgIGJhbGFuY2U6IFwiXCIsLy/mtLvmnJ/kvZnpop3ljp/lp4vlgLxcblxuICAgIGxhZGRlclZpczogXCJnb25lXCIsLy/pmLbmoq/lubTljJbmmL7npLpcbiAgICBwcm9maXRWaXM6IFwiZ29uZVwiLC8v5pS255uK5qaC6KeI5pi+56S6XG4gICAgbGFkZGVyTGlzdDogW10sLy/pmLbmoq/lubTljJbliJfooajmlbDmja5cbiAgICBwcm9maXRMaXN0OiBbXSwvL+aUtuebiuamguiniOWIl+ihqOaVsOaNrlxuICAgIHByb2ZpdEhpbnQ6IFwiXCIsLy/mlLbnm4rmpoLop4jmj5DnpLpcbiAgICBwcm9maXRIaW50VmlzOiBcImdvbmVcIiwvL+aUtuebiuamguiniOaPkOekuuaYvuekulxuICAgIHN1Yk92ZXJ2aWV3VGl0bGU6IFwiXCIsLy/nlLPotK3mpoLlhrXmoIfpophcbiAgICBzdWJPdmVydmlld1QxOiBcIlwiLC8v55Sz6LSt56ys5LiA6KGM5qCH6aKYXG4gICAgc3ViT3ZlcnZpZXdDMTogXCJcIiwvL+eUs+i0reesrOS4gOihjOWGheWuuVxuICAgIHN1Yk92ZXJ2aWV3VDI6IFwiXCIsLy/nlLPotK3nrKzkuozooYzmoIfpophcbiAgICBzdWJPdmVydmlld0MyOiBcIlwiLC8v55Sz6LSt56ys5LqM6KGM5YaF5a65XG4gICAgc3ViT3ZlcnZpZXdUMzogXCLliLDotKbml6VcIiwvL+eUs+i0reesrOS4ieihjOagh+mimFxuICAgIHN1Yk92ZXJ2aWV3QzM6IFwiXCIsLy/nlLPotK3nrKzkuInooYzlhoXlrrlcbiAgICBzdWJPdmVydmlld1QzVmlzOiBcInZpc2libGVcIiwvL+eUs+i0reesrOS4ieihjOagh+mimOaYvuekulxuICAgIHN1Yk92ZXJ2aWV3VDNVTFZpczogXCJnb25lXCIsLy/nlLPotK3nrKzkuInooYzluKbkuIvliJLnur/moIfpopjmmL7npLpcbiAgICBhdXRvRWFyblN3aXRjaGVyOiBhdXRvRWFyblN3aXRjaFJlcy5jbG9zZUltZywvL+iHquWKqOi1muW4geW8gOWFs1xuXG4gICAgLy/mnIDkvY7otbfmipXph5Hpop1cbiAgICBtTWluU3ViOiBcIlwiLFxuICAgIC8v55Sz6LSt6L6T5YWl5qGGXG4gICAgbVN1YklucHV0OiBcIlwiLFxuICAgIC8v6aG555uuaWRcbiAgICBwcm9qZWN0SWQ6IDAsXG4gICAgLy/mraPlnKjkvb/nlKjnmoTliqDmga/liLhcbiAgICB1c2luZ0NvdXBvbjoge30sXG4gICAgLy/mmK/lkKbmlK/mjIHliqDmga/liLjvvJowLeS4jeaUr+aMge+8mzEt5pSv5oyBXG4gICAgc3VwcG9ydENvdXBvbjogMCxcbiAgICAvL+eUqOaIt+W3suaKlemHkeminVxuICAgIHVzZXJJbnZlc3RBbXQ6IDAsXG4gICAgLy/mlLbnm4rmpoLop4jljp/lp4vmlbDmja5cbiAgICBtTWFya2V0QXB5Vm86IG51bGwsXG4gICAgLy/moIforrDovpPlhaXmmK/lkKblkIjms5VcbiAgICBpbnB1dFN0YXR1czogZmFsc2UsXG4gICAgLy/liKnnjofnsbvlnosgMDrlm7rlrpogMTrluILlnLrljJZcbiAgICBhcHlUeXBlOiAtMSxcbiAgICAvL+agh+iusOiHquWKqOi1muW4geeahOeKtuaAge+8mjAt5YWz6Zet77ybMS3miZPlvIBcbiAgICBhdXRvRWFybjogMCxcbiAgICAvL+S4quS6uuWJqeS9memineW6plxuICAgIHVzZXJSZW1haW5RdW90YTogMCxcbiAgICAvL+mhueebruWJqeS9memineW6plxuICAgIHN1cnBsdXNBbW91bnQ6IDAsXG4gICAgLy/mlrDluIEgLSDku4rml6Xpobnnm67liankvZnpop3luqbvvIjkuI3kuLrnqbrlrZjlnKjliJnooajnpLrlrZjlnKjmr4/ml6XpmZDpop3vvIlcbiAgICBwcm9qZWN0UmVtYWluQW10UGVyRGF5OiBudWxsLFxuICAgIC8v5rS75pyfLeavj+aXpeWNs+aXtui1juWbnumZkOminVxuICAgIHJlZGVlbUxpbWl0UGVyRGF5OiAwLFxuICB9XG59XG5cbmNvbnN0IHsgbW9kdWxlRGF0YSwgbW9kdWxlRXZlbnQgfSA9IGNvbW1vbi5tb2R1bGVEZWZpbmUoXCJmbGV4aWJsZVwiLCBkZWZhdWx0RGF0YSwge30pO1xuXG4vKipcbiAqIOino+aekOa0u+acn+aVsOaNrlxuICovXG5leHBvcnQgZnVuY3Rpb24gaGFuZGxlQ3VycmVudERldGFpbChwcm9qZWN0LCBvcmlnaW5Db3Vwb25EYXRhKSB7XG4gIHRyeSB7XG4gICAgdmFyIGhhbmRsZXJEYXRhID0gZGVmYXVsdEhhbmRsZXJEYXRhKCk7XG4gICAgaWYgKHByb2plY3QgIT0gbnVsbCkge1xuICAgICAgY29uc29sZS5sb2coYCR7dGFnfSBoYW5kbGVDdXJyZW50RGV0YWlsIHByb2plY3Q9IFwiICsgJHtKU09OLnN0cmluZ2lmeShwcm9qZWN0KX1gKTtcbiAgICAgIC8v5Lqn5ZOB57G75Z6LKDAg5rS75pyfIDEg5a6a5pyfIDIg5aSn6aKd5rS75pyfKSDmsqHmnInlpKfpop3mtLvmnJ9cbiAgICAgIGhhbmRsZXJEYXRhLnByb2R1Y3RUeXBlID0gcHJvamVjdC5wcm9kdWN0VHlwZTtcbiAgICAgIGlmIChwcm9qZWN0LnByb2R1Y3RUeXBlID09PSAwKSB7XG4gICAgICAgIGdldEN1cnJlbnREYXRhKHByb2plY3QsIGhhbmRsZXJEYXRhLCBvcmlnaW5Db3Vwb25EYXRhKTtcbiAgICAgIH1cbiAgICAgIGNvbnNvbGUubG9nKGAke3RhZ30gaGFuZGxlQ3VycmVudERldGFpbCBoYW5kbGVyRGF0YT0gXCIgKyAke0pTT04uc3RyaW5naWZ5KGhhbmRsZXJEYXRhKX1gKTtcbiAgICB9IGVsc2Uge1xuICAgICAgY29uc29sZS5sb2coYCR7dGFnfSBoYW5kbGVDdXJyZW50RGV0YWlsIGRhdGE9PW51bGwgYCk7XG4gICAgfVxuICAgIHJldHVybiBoYW5kbGVyRGF0YTtcbiAgfSBjYXRjaCAoZSkge1xuICAgIGNvbnNvbGUubG9nKGBoYW5kbGVDdXJyZW50RGV0YWlsIGVycm9yID0gJHtlfWApO1xuICB9XG59XG5cbi8qKlxuICog5bGV56S65Y+v55So5L2Z6aKd77ya57K+5bqmIOacgOWkmjjkvY0gXG4gKi9cbmZ1bmN0aW9uIHNob3dCYWxhbmNlKGJhbGFuY2UsIHN1ZmZpeCA9IGZhbHNlKSB7XG4gIGxldCBmb3JtYXQgPSBjb21tb24uZm9ybWF0UHJlY2lzaW9uKGJhbGFuY2UsIDgpLnRvU3RyaW5nKCk7XG4gIGNvbnNvbGUubG9nKHRhZyArIFwiIHNob3dCYWxhbmNlIGZvcm1hdD0gXCIgKyBmb3JtYXQpO1xuICBsZXQgYW5zID0gY29tbW9uLnJlbW92ZUV4dHJhWmVyb3MoZm9ybWF0KTtcbiAgY29uc29sZS5sb2codGFnICsgXCIgc2hvd0JhbGFuY2UgYW5zPSBcIiArIGFucyk7XG4gIGlmIChzdWZmaXgpIHtcbiAgICByZXR1cm4gYCR7YW5zfSAkeyRkYXRhLmhvbWUuY3VycmVuY3l9YDtcbiAgfSBlbHNlIHtcbiAgICByZXR1cm4gYCR7YW5zfWA7XG4gIH1cbn1cblxuLyoqXG4gKiDliJ3lp4vljJbmtLvmnJ/mlbDmja5cbiAqL1xuZnVuY3Rpb24gZ2V0Q3VycmVudERhdGEocHJvamVjdCwgaGFuZGxlckRhdGEsIG9yaWdpbkNvdXBvbkRhdGEpIHtcbiAgLy/lsZXnpLrotbfmipXph5Hpop1cbiAgbGV0IG1pbiA9IE1hdGgubWluKHByb2plY3Quc3RhcnRBbW91bnQsIHByb2plY3Quc3Vic2NyaWJlTWluQW1vdW50KTtcbiAgbGV0IG1pblN1YiA9IGNvbW1vbi5yZW1vdmVFeHRyYVplcm9zKGNvbW1vbi5mb3JtYXRQcmVjaXNpb24obWluLCA4KSk7XG4gIGhhbmRsZXJEYXRhLm1NaW5TdWIgPSBtaW5TdWI7XG4gIGNvbnNvbGUubG9nKGAke3RhZ30gZ2V0Q3VycmVudERhdGEgbU1pblN1Yj0gICR7aGFuZGxlckRhdGEubU1pblN1Yn1gKTtcbiAgaGFuZGxlckRhdGEuc3ViSGludCA9ICRpMThuLiRpbnRlcmNlcHQubl9zaGFya19maW5fbWluX2Ftb3VudChgJHtoYW5kbGVyRGF0YS5tTWluU3VifWApO1xuICAvL+WJqeS9meWPr+eUs+i0rVxuICBoYW5kbGVyRGF0YS5hdmFpbGFibGVRdW90YSA9IHByb2plY3QuYXZhaWxhYmxlUXVvdGE7XG4gIGhhbmRsZXJEYXRhLmF2YWlsYWJsZVF1b3RhVGV4dCA9IGAke2NvbW1vbi5yZW1vdmVFeHRyYVplcm9zKGNvbW1vbi5nZXRQcmljZVN0cmluZyhwcm9qZWN0LmF2YWlsYWJsZVF1b3RhLCA4KSl9YDtcbiAgaGFuZGxlckRhdGEudXNlclJlbWFpblF1b3RhID0gcHJvamVjdC51c2VyUmVtYWluUXVvdGE7XG4gIGhhbmRsZXJEYXRhLnN1cnBsdXNBbW91bnQgPSBwcm9qZWN0LnN1cnBsdXNBbW91bnQ7XG4gIGhhbmRsZXJEYXRhLnRhZyA9IHByb2plY3QudGFnO1xuICBoYW5kbGVyRGF0YS5sYXVuY2hQb29sQWN0aXZpdHlJZCA9IHByb2plY3QubGF1bmNoUG9vbEFjdGl2aXR5SWQ7XG4gIGhhbmRsZXJEYXRhLnByb2plY3RSZW1haW5BbXRQZXJEYXkgPSBwcm9qZWN0LnByb2plY3RSZW1haW5BbXRQZXJEYXk7XG5cbiAgaGFuZGxlQXNzZXRTb3VyY2VEZXNjKHByb2plY3Quc3ViT3RoZXJBbXRJbmZvLCBoYW5kbGVyRGF0YSk7XG4gIGlmIChoYW5kbGVyRGF0YS5wcm9qZWN0UmVtYWluQW10UGVyRGF5ID09IG51bGwpIHtcbiAgICBoYW5kbGVyRGF0YS5hdmFpbGFibGVRdW90YVRpdGxlID0gJGkxOG4ubl9zaW1wbGVfZWFybl9hdmFpbGFibGVfcXVvdGE7XG4gIH0gZWxzZSB7XG4gICAgaGFuZGxlckRhdGEuYXZhaWxhYmxlUXVvdGFUaXRsZSA9ICRpMThuLm5fc2ltcGxlX2Vhcm5fYXZhaWxhYmxlX3F1b3RlX3RvZGF5O1xuICB9XG4gIGhhbmRsZXJEYXRhLnByb2plY3RJZCA9IHByb2plY3QucHJvamVjdElkO1xuICBoYW5kbGVyRGF0YS5zdGF0dXMgPSBwcm9qZWN0LnN0YXR1cztcbiAgaGFuZGxlckRhdGEua3ljTGltaXRVc2VyVmlld0xldmVsID0gcHJvamVjdC5reWNMaW1pdFVzZXJWaWV3TGV2ZWw7XG4gIC8vMCDmnKrlvIDlkK8gMSDlvIDlkK9cbiAgaGFuZGxlckRhdGEuYXV0b0Vhcm5Td2l0Y2hlciA9XG4gICAgcHJvamVjdC5iYWxhbmNlQXV0b1N0YXR1cyA9PSBudWxsIHx8IHByb2plY3QuYmFsYW5jZUF1dG9TdGF0dXMgPT0gdW5kZWZpbmVkIHx8IHByb2plY3QuYmFsYW5jZUF1dG9TdGF0dXMgPT0gMFxuICAgICAgPyBhdXRvRWFyblN3aXRjaFJlcy5jbG9zZUltZ1xuICAgICAgOiBhdXRvRWFyblN3aXRjaFJlcy5vcGVuSW1nO1xuICBoYW5kbGVyRGF0YS5hdXRvRWFybiA9IHByb2plY3QuYmFsYW5jZUF1dG9TdGF0dXM7XG4gIC8v5Yqg5oGv5Yi4XG4gIGhhbmRsZXJEYXRhLnVzaW5nQ291cG9uID0gcHJvamVjdC51c2luZ0NvdXBvbiA9PSBudWxsID8ge30gOiBwcm9qZWN0LnVzaW5nQ291cG9uO1xuICBoYW5kbGVyRGF0YS5zdXBwb3J0Q291cG9uID0gcHJvamVjdC5zdXBwb3J0Q291cG9uO1xuICBoYW5kbGVyRGF0YS51c2VySW52ZXN0QW10ID0gcHJvamVjdC51c2VySW52ZXN0QW10O1xuICBpZiAoaGFuZGxlckRhdGEuc3VwcG9ydENvdXBvbiA9PSAxKSB7XG4gICAgaGFuZGxlckRhdGEuY291cG9uVmlzID0gXCJ2aXNpYmxlXCI7XG4gICAgLy/lpITnkIbliqDmga/liLhcbiAgICBjb3Vwb25MaXN0LmdldENvdXBvbkRhdGEoaGFuZGxlckRhdGEsIG9yaWdpbkNvdXBvbkRhdGEpO1xuICB9IGVsc2Uge1xuICAgIC8v6ZqQ6JeP5Yqg5oGv5Yi45pW06KGMXG4gICAgaGFuZGxlckRhdGEuY291cG9uVmlzID0gXCJnb25lXCI7XG4gIH1cbiAgaGFuZGxlckRhdGEudGVybSA9IHByb2plY3QudGVybTtcbiAgaGFuZGxlckRhdGEucHJvZHVjdFR5cGUgPSBwcm9qZWN0LnByb2R1Y3RUeXBlO1xuICBoYW5kbGVyRGF0YS5hcHlUeXBlID0gcHJvamVjdC5hcHlUeXBlO1xuICAvL+mYtuair+W5tOWMli/mlLbnm4rmpoLop4ggMDrlm7rlrpogMTrluILlnLrljJZcbiAgaWYgKHByb2plY3QuYXB5VHlwZSA9PSAwKSB7XG4gICAgaGFuZGxlckRhdGEucHJvZml0VmlzID0gXCJnb25lXCI7XG4gICAgaGFuZGxlckRhdGEubGFkZGVyTGlzdCA9IGhhbmRsZUxhZGRlckRhdGEocHJvamVjdC50aWVyZWRSYXRlcywgcHJvamVjdCk7XG4gICAgaGFuZGxlckRhdGEubGFkZGVyVmlzID0gaGFuZGxlckRhdGEubGFkZGVyTGlzdC5sZW5ndGggPiAxID8gXCJ2aXNpYmxlXCIgOiBcImdvbmVcIjtcbiAgICAvL+mdnuW4guWcuuWMllxuICAgIGhhbmRsZVN1Yk92ZXJ2aWV3RGF0YShwcm9qZWN0LCBmYWxzZSwgaGFuZGxlckRhdGEpO1xuICAgICRldmVudC5sYWRkZXIuaW5pdEN1cnJlbmN5RGF0YSgpO1xuICAgIGhhbmRsZXJEYXRhLnByb2ZpdEV2ZXJ5RGF5ID0gXCJ2aXNpYmxlXCJcbiAgfSBlbHNlIGlmIChwcm9qZWN0LmFweVR5cGUgPT0gMSkge1xuICAgIGhhbmRsZXJEYXRhLm1NYXJrZXRBcHlWbyA9IHByb2plY3QubWFya2V0QXB5Vm87XG4gICAgaGFuZGxlckRhdGEubGFkZGVyVmlzID0gXCJnb25lXCI7XG4gICAgbGV0IHN1YkludCA9IChoYW5kbGVyRGF0YS5tU3ViSW5wdXQubGVuZ3RoID09PSAwKSA/IDAgOiBudW1iZXIuYmlnbnVtYmVyKGhhbmRsZXJEYXRhLm1TdWJJbnB1dCk7XG4gICAgaGFuZGxlckRhdGEucHJvZml0TGlzdCA9IGhhbmRsZVByb2ZpdE92ZXJ2aWV3RGF0YShwcm9qZWN0Lm1hcmtldEFweVZvLCBwcm9qZWN0LnVzZXJJbnZlc3RBbXQsIGhhbmRsZXJEYXRhLCBzdWJJbnQpO1xuICAgIGhhbmRsZXJEYXRhLnByb2ZpdFZpcyA9IFwidmlzaWJsZVwiO1xuICAgIC8v5biC5Zy65YyWXG4gICAgaGFuZGxlU3ViT3ZlcnZpZXdEYXRhKHByb2plY3QsIHRydWUsIGhhbmRsZXJEYXRhKTtcbiAgICAkZXZlbnQucHJvZml0T3ZlcnZpZXcuaW5pdERhdGEoKTtcbiAgfVxufVxuXG5cbi8qKlxuICog5aSE55CG6LWE5Lqn5p2l5rqQ5pi+56S65paH5qGIXG4gKi9cbmZ1bmN0aW9uIGhhbmRsZUFzc2V0U291cmNlRGVzYyhvdGhlckFtdEluZm8sIGhhbmRsZXJEYXRhKSB7XG4gIGlmIChvdGhlckFtdEluZm8gPT0gbnVsbCkge1xuICAgIGNvbnNvbGUubG9nKGAke3RhZ30gaGFuZGxlQXNzZXRTb3VyY2VEZXNjIGFzc2V0U291cmNlRGlzcGxheSBnb25lYCk7XG4gICAgaGFuZGxlckRhdGEuYXNzZXRTb3VyY2VEaXNwbGF5ID0gXCJnb25lXCI7XG4gICAgaGFuZGxlckRhdGEuYmFsYW5jZVRleHQgPSAkZGF0YS5ob21lLmJhbGFuY2VUZXh0O1xuICAgIGhhbmRsZXJEYXRhLmJhbGFuY2UgPSAkZGF0YS5ob21lLmJhbGFuY2U7XG4gIH0gZWxzZSB7XG4gICAgaGFuZGxlckRhdGEuYXNzZXRTb3VyY2VEaXNwbGF5ID0gXCJ2aXNpYmxlXCI7XG4gICAgLy8g5qOA5p+l6LWE5Lqn5rCU5rOh5piv5ZCm6ZyA6KaB5pi+56S6XG4gICAgY2hlY2tTaG93QXNzZXRQb3B1cCgpO1xuICAgIGhhbmRsZXJEYXRhLmFzc2V0U291cmNlVGl0bGUgPSAkaTE4bi5uX2Fzc2V0X3NvdXJjZTtcbiAgICBjb25zb2xlLmxvZyhgJHt0YWd9IGhhbmRsZUFzc2V0U291cmNlRGVzYyBhc3NldFNvdXJjZURpc3BsYXkgdmlzaWJsZSBsZW5ndGg6ICR7b3RoZXJBbXRJbmZvLmxlbmd0aH1gKTtcblxuICAgIGxldCB0b3RhbEJhbGFuY2UgPSAwO1xuICAgIGxldCB0b3RhbEN1cnJlbmN5ID0gXCJcIjtcbiAgICBmb3IgKGxldCBpID0gMDsgaSA8IG90aGVyQW10SW5mby5sZW5ndGg7IGkrKykge1xuICAgICAgY29uc3QgaW5mbyA9IG90aGVyQW10SW5mb1tpXTtcbiAgICAgIGxldCBzZWxlY3RTdGF0dXMgPSBpbmZvLmN1cnJlbmN5LnRvVXBwZXJDYXNlKCkgPT09IFwiVVNERFwiID8gJGRhdGEuZnVuZC5zdGF0dXNVU0REIDogJGRhdGEuZnVuZC5zdGF0dXNVU0RUO1xuICAgICAgY29uc29sZS5sb2coYCR7dGFnfSBoYW5kbGVBc3NldFNvdXJjZURlc2Mgc2VsZWN0U3RhdHVzPSAke3NlbGVjdFN0YXR1c30gaW5mbz0gJHtKU09OLnN0cmluZ2lmeShpbmZvKX19YCk7XG4gICAgICBpZiAoc2VsZWN0U3RhdHVzICE9IG51bGwpIHtcbiAgICAgICAgaWYgKHNlbGVjdFN0YXR1cykge1xuICAgICAgICAgIHRvdGFsQmFsYW5jZSA9IG51bWJlci5hZGQodG90YWxCYWxhbmNlLCBpbmZvLmFtb3VudCk7XG4gICAgICAgICAgdG90YWxDdXJyZW5jeSA9IHRvdGFsQ3VycmVuY3kubGVuZ3RoID09IDAgPyBpbmZvLmN1cnJlbmN5IDogYCgke3RvdGFsQ3VycmVuY3l9KyR7aW5mby5jdXJyZW5jeX0pYDtcbiAgICAgICAgfVxuICAgICAgfSBlbHNlIHtcbiAgICAgICAgLy/pu5jorqTpgInkuK11c2RkXG4gICAgICAgIGlmIChpbmZvLmN1cnJlbmN5LnRvVXBwZXJDYXNlKCkgPT09IFwiVVNERFwiKSB7XG4gICAgICAgICAgdG90YWxCYWxhbmNlID0gbnVtYmVyLmFkZCh0b3RhbEJhbGFuY2UsIGluZm8uYW1vdW50KTtcbiAgICAgICAgICB0b3RhbEN1cnJlbmN5ID0gdG90YWxDdXJyZW5jeS5sZW5ndGggPT0gMCA/IGluZm8uY3VycmVuY3kgOiBgKCR7dG90YWxDdXJyZW5jeX0rJHtpbmZvLmN1cnJlbmN5fSlgO1xuICAgICAgICB9XG4gICAgICB9XG4gICAgfVxuICAgIGNvbnNvbGUubG9nKFxuICAgICAgYCR7dGFnfSBoYW5kbGVBc3NldFNvdXJjZURlc2MgdG90YWxCYWxhbmNlPSAke3RvdGFsQmFsYW5jZX0gdG90YWxDdXJyZW5jeT0gJHt0b3RhbEN1cnJlbmN5fSBoYW5kbGVyRGF0YT0gJHtoYW5kbGVyRGF0YX1gXG4gICAgKTtcbiAgICBoYW5kbGVyRGF0YS5hc3NldFNvdXJjZURlc2MgPSAkaTE4bi4kaW50ZXJjZXB0Lm5fY2FzaF9hc3NldF9iYWxhbmNlKGAke3RvdGFsQ3VycmVuY3l9YCk7XG4gICAgaGFuZGxlckRhdGEuYmFsYW5jZVRleHQgPSBgJHtjb21tb24ucmVtb3ZlRXh0cmFaZXJvcyhjb21tb24uZ2V0UHJpY2VTdHJpbmcodG90YWxCYWxhbmNlLCA4KSl9YFxuICAgIGhhbmRsZXJEYXRhLmJhbGFuY2UgPSB0b3RhbEJhbGFuY2U7XG4gICAgLy/lpITnkIbotYTph5HliJfooajnmoTmlbDmja5cbiAgICAkZXZlbnQuZnVuZC5pbml0RGF0YShvdGhlckFtdEluZm8sIGhhbmRsZXJEYXRhKTtcbiAgICBjb25zb2xlLmxvZyhgJHt0YWd9IGdldEN1cnJlbnREYXRhIGFzc2V0U291cmNlRGlzcGxheSBhZnRlciBpbml0RGF0YWApO1xuICB9XG59XG5cbm1vZHVsZUV2ZW50LmNsaWNrUHVyY2hhc2VEaWFsb2dDbG9zZSA9IGZ1bmN0aW9uKCkge1xuICAkZXZlbnQucHVyY2hhc2VUaXAuY2xvc2VEaWFsb2coKTtcbiAgY2hlY2tTaG93QXNzZXRQb3B1cCgpO1xufTtcblxuYXN5bmMgZnVuY3Rpb24gY2hlY2tTaG93QXNzZXRQb3B1cCgpIHtcbiAgbGV0IGRpZERpYWxvZ1Nob3cgPSBhd2FpdCBjb21tb24ucmVhZChcInNpbXBsZV9lYXJuXCIsIFwiZGlkU2hvd1wiKTtcbiAgY29uc29sZS5sb2coYFVTREQgZmxleGlibGUgYXNzZXQgcG9wdXAgZGlhbG9iZ1Nob3duID0gJHtkaWREaWFsb2dTaG93fWApO1xuICBpZiAoZGlkRGlhbG9nU2hvdyAhPSBcIjFcIikge1xuICAgIC8vIGRpYWxvZyDkvJrlvLnlh7rmnaXvvIzkvJjlhYjlpITnkIZkaWFsb2dcbiAgICByZXR1cm47XG4gIH1cblxuICBsZXQgZGF0ZSA9IG5ldyBEYXRlKCk7IC8vIOiOt+WPluW9k+WJjeaXtumXtCBUaHUgRmViIDI3IDIwMjUgMTk6MTQ6MDAgR01UKzA4MDAgKENTVClcbiAgbGV0IG1vbnRoID0gZGF0ZS5nZXRNb250aCgpICsgMTtcbiAgbGV0IGRheSA9IGRhdGUuZ2V0RGF0ZSgpO1xuICBsZXQgc2hvd25EYXRlID0gbW9udGggKyAnLScgKyBkYXk7XG4gIGxldCBsYXN0U2hvd25EYXRlID0gYXdhaXQgY29tbW9uLnJlYWQoXCJzaW1wbGVfZWFyblwiLCBcImRpZFNob3dQb3B1cFwiKTtcbiAgaWYgKGxhc3RTaG93bkRhdGUgIT0gc2hvd25EYXRlKSB7XG4gICAgLy8g5LuK5aSp5YaF5rKh5pyJ5by55Ye66L+HcG9wXG4gICAgc2hvd0Fzc2V0UG9wdXAoKVxuICAgIC8vIOS/neWtmOS7iuWkqXNob3fov4fnmoTorrDlvZVcbiAgICBhd2FpdCBjb21tb24uc2F2ZShcInNpbXBsZV9lYXJuXCIsIFwiZGlkU2hvd1BvcHVwXCIsIHNob3duRGF0ZSk7XG4gIH1cbiAgY29uc29sZS5sb2coYFVTREQgZmxleGlibGUgYXNzZXQgcG9wdXAgc2hvd25EYXRlID0gJHtzaG93bkRhdGV9IGFuZCBsYXN0U2hvd25EYXRlID0gJHtsYXN0U2hvd25EYXRlfWApO1xufVxuXG5mdW5jdGlvbiBzaG93QXNzZXRQb3B1cCgpIHtcbiAgc2V0VGltZW91dCgoKSA9PiB7XG4gICAgJGRhdGEuYXNzZXRTb3VyY2UucG9wU2hvdyA9IHRydWU7XG4gICAgc2V0VGltZW91dCgoKSA9PiB7XG4gICAgICAkZGF0YS5hc3NldFNvdXJjZS5wb3BTaG93ID0gZmFsc2U7XG4gICAgfSwgNTAwMCk7XG4gIH0sIDUwMCk7XG59XG4vKipcbiAqIOWkhOeQhueUs+i0reamguiniOaVsOaNrlxuICovXG5mdW5jdGlvbiBoYW5kbGVTdWJPdmVydmlld0RhdGEocHJvamVjdCwgaXNNYXJrZXQsIGhhbmRsZXJEYXRhKSB7XG4gIGlmIChpc01hcmtldCkge1xuICAgIC8v5biC5Zy65YyW5Yip546HXG4gICAgaGFuZGxlckRhdGEuc3ViT3ZlcnZpZXdUaXRsZSA9ICRpMThuLm5fc2ltcGxlX2Vhcm5fc29fY3VycmVudF90aXRsZTE7XG4gICAgaGFuZGxlckRhdGEuc3ViT3ZlcnZpZXdUMSA9ICRpMThuLm5fc2ltcGxlX2Vhcm5fc29fc3ViX3RpbWU7XG4gICAgaGFuZGxlckRhdGEuc3ViT3ZlcnZpZXdDMSA9ICRpMThuLm5fc2ltcGxlX2Vhcm5fc29fbm93O1xuICAgIGhhbmRsZXJEYXRhLnN1Yk92ZXJ2aWV3VDIgPSAkaTE4bi5uX3NpbXBsZV9lYXJuX3NvX3N0YXJ0X3RpbWU7XG4gICAgLy/ml7bpl7TlpITnkIbmiJDnsr7noa7liLDlubTmnIjml6Xml7bliIZcbiAgICBoYW5kbGVyRGF0YS5zdWJPdmVydmlld0MyID0gcHJvamVjdC5kdEludGVyZXN0U3RhcnQ7XG4gICAgaGFuZGxlckRhdGEuc3ViT3ZlcnZpZXdUMyA9ICRpMThuLm5fc2ltcGxlX2Vhcm5fc29fZmlyc3RfaW5jb21lX3RpbWU7XG4gICAgaGFuZGxlckRhdGEuc3ViT3ZlcnZpZXdDMyA9IHByb2plY3QuZHRJbnRlcmVzdEdyYW50O1xuICAgIGhhbmRsZXJEYXRhLnN1Yk92ZXJ2aWV3VDNWaXMgPSBcInZpc2libGVcIjtcbiAgICBoYW5kbGVyRGF0YS5zdWJPdmVydmlld1QzVUxWaXMgPSBcImdvbmVcIjtcbiAgfSBlbHNlIHtcbiAgICAvL+mdnuW4guWcuuWMluWIqeeOh1xuICAgIGhhbmRsZXJEYXRhLnN1Yk92ZXJ2aWV3VGl0bGUgPSAkaTE4bi4kaW50ZXJjZXB0Lm5fc2ltcGxlX2Vhcm5fc29fY3VycmVudF90aXRsZTIoYCR7cHJvamVjdC5kdEludGVyZXN0U3RhcnR9YCk7XG4gICAgaGFuZGxlckRhdGEuc3ViT3ZlcnZpZXdUMSA9ICRpMThuLm5fc2ltcGxlX2Vhcm5fc29fc3ViX2RheTtcbiAgICBoYW5kbGVyRGF0YS5zdWJPdmVydmlld0MxID0gcHJvamVjdC5kdFN1YnNjcmliZTtcbiAgICBoYW5kbGVyRGF0YS5zdWJPdmVydmlld1QyID0gJGkxOG4ubl9zaW1wbGVfZWFybl9zb19zdGFydF9kYXk7XG4gICAgaGFuZGxlckRhdGEuc3ViT3ZlcnZpZXdDMiA9IHByb2plY3QuZHRJbnRlcmVzdFN0YXJ0O1xuICAgIGhhbmRsZXJEYXRhLnN1Yk92ZXJ2aWV3VDMgPSAkaTE4bi5uX3NpbXBsZV9lYXJuX3NvX3JlY2VpcHRfZGF5O1xuICAgIGhhbmRsZXJEYXRhLnN1Yk92ZXJ2aWV3QzMgPSAkaTE4bi5uX3NpbXBsZV9lYXJuX3NvX3JlYWxfdGltZV9wYXltZW50O1xuICAgIGhhbmRsZXJEYXRhLnN1Yk92ZXJ2aWV3VDNWaXMgPSBcImdvbmVcIjtcbiAgICBoYW5kbGVyRGF0YS5zdWJPdmVydmlld1QzVUxWaXMgPSBcInZpc2libGVcIjtcbiAgICBoYW5kbGVyRGF0YS5yZWRlZW1MaW1pdFBlckRheSA9IHByb2plY3QucmVkZWVtTGltaXRQZXJEYXkgPyBwcm9qZWN0LnJlZGVlbUxpbWl0UGVyRGF5IDogMDtcbiAgICAvLyBpZiAocHJvamVjdC5yZWRlZW1MaW1pdFBlckRheSA+IDApIHtcbiAgICAvLyAgICRldmVudC5yZWNlaXB0ZGlhbG9nLnNldEN1cnJlbnRUaXAyKHByb2plY3QucmVkZWVtTGltaXRQZXJEYXksICRkYXRhLmhvbWUuY3VycmVuY3kpO1xuICAgIC8vIH0gZWxzZSB7XG4gICAgLy8gICAkZXZlbnQucmVjZWlwdGRpYWxvZy5zZXRDdXJyZW50VGlwKCk7XG4gICAgLy8gfVxuICB9XG59XG5cbi8qKlxuICog5aSE55CG5pS255uK5qaC6KeI5pWw5o2uXG4gKi9cbmZ1bmN0aW9uIGhhbmRsZVByb2ZpdE92ZXJ2aWV3RGF0YShtYXJrZXRBcHlWbywgdXNlckludmVzdEFtdCwgaGFuZGxlckRhdGEsIHN1Yk51bSA9IDApIHtcbiAgY29uc29sZS5sb2coYCR7dGFnfSBoYW5kbGVQcm9maXRPdmVydmlld0RhdGEgYmVnaW4gc3ViTnVtPSAke3N1Yk51bX1gKTtcbiAgbGV0IHByb2ZpdHMgPSBbXTtcbiAgbGV0IHN1Yk51bVRleHQgPSBjb21tb24ucmVtb3ZlRXh0cmFaZXJvcyhjb21tb24uZm9ybWF0UHJlY2lzaW9uKHN1Yk51bSwgOCkpO1xuICAvLyDluILlnLrljJbliKnnjoc+6KGl6LS05Yip546H5pe277yM5Y+q5bGV56S65LiA6KGMXG4gIGlmIChtYXJrZXRBcHlWby5tYXJrZXRUaW1lQXB5ID4gbWFya2V0QXB5Vm8ubWFya2V0UGVya0FweSkge1xuICAgIGxldCBpdGVtID0ge307XG4gICAgaWYgKHN1Yk51bSA9PSAwKSB7XG4gICAgICBpdGVtLnRpdGxlID0gJGkxOG4ubl9hc3NldF9hbGxfYmFsYW5jZXM7XG4gICAgfSBlbHNlIHtcbiAgICAgIGl0ZW0udGl0bGUgPSBgJHtzdWJOdW1UZXh0fSAkeyRkYXRhLmhvbWUuY3VycmVuY3l9YDtcbiAgICB9XG4gICAgaXRlbS5yYXRlID0gYCR7Y29tbW9uLmZvcm1hdFByZWNpc2lvbihudW1iZXIubXVsdGlwbHkobWFya2V0QXB5Vm8ubWFya2V0VGltZUFweSwgMTAwKSwgMikudG9TdHJpbmcoKX0lYDtcbiAgICBpdGVtLnR5cGUgPSAnMSc7XG4gICAgaXRlbS5wZXJrVmlzID0gXCJnb25lXCI7XG4gICAgcHJvZml0cy5wdXNoKGl0ZW0pO1xuICB9IGVsc2Uge1xuICAgIC8v5biC5Zy65YyW5Yip546HPOihpei0tOWIqeeOh+aXtu+8jOWxleekuuS4pOihjFxuICAgIGxldCBpdGVtID0ge307XG4gICAgaWYgKHN1Yk51bSA9PSAwKSB7XG4gICAgICBsZXQgbWFya2V0UGVya1VwTGltaXRUZXh0ID0gY29tbW9uLnJlbW92ZUV4dHJhWmVyb3MoY29tbW9uLmZvcm1hdFByZWNpc2lvbihtYXJrZXRBcHlWby5tYXJrZXRQZXJrVXBMaW1pdCwgOCkpO1xuICAgICAgaXRlbS50aXRsZSA9IGAwIH4gJHttYXJrZXRQZXJrVXBMaW1pdFRleHR9ICR7JGRhdGEuaG9tZS5jdXJyZW5jeX1gO1xuICAgICAgaXRlbS5yYXRlID0gYCR7Y29tbW9uLmZvcm1hdFByZWNpc2lvbihudW1iZXIubXVsdGlwbHkobWFya2V0QXB5Vm8ubWFya2V0UGVya0FweSwgMTAwKSwgMikudG9TdHJpbmcoKX0lYDtcbiAgICAgIGl0ZW0ucGVya1ZpcyA9IFwidmlzaWJsZVwiO1xuICAgICAgaXRlbS50eXBlID0gXCIxXCI7XG4gICAgICBwcm9maXRzLnB1c2goaXRlbSk7XG4gICAgICBpdGVtID0ge307XG4gICAgICBpdGVtLnRpdGxlID0gYD4gJHttYXJrZXRQZXJrVXBMaW1pdFRleHR9ICR7JGRhdGEuaG9tZS5jdXJyZW5jeX1gO1xuICAgICAgaXRlbS5yYXRlID0gYCR7Y29tbW9uLmZvcm1hdFByZWNpc2lvbihudW1iZXIubXVsdGlwbHkobWFya2V0QXB5Vm8ubWFya2V0VGltZUFweSwgMTAwKSwgMikudG9TdHJpbmcoKX0lYDtcbiAgICAgIGl0ZW0ucGVya1ZpcyA9IFwiZ29uZVwiO1xuICAgICAgaXRlbS50eXBlID0gXCIxXCI7XG4gICAgICBwcm9maXRzLnB1c2goaXRlbSk7XG4gICAgICBoYW5kbGVyRGF0YS5wcm9maXRIaW50VmlzID0gXCJnb25lXCI7XG4gICAgfSBlbHNlIHtcbiAgICAgIC8v5L2/55SoIOW3sui0reaVsOmHjyDiiaUg6KGl6LS06ZmQ6aKdIOi/m+ihjOavlOi+g1xuICAgICAgaWYgKHVzZXJJbnZlc3RBbXQgPj0gbWFya2V0QXB5Vm8ubWFya2V0UGVya1VwTGltaXQpIHtcbiAgICAgICAgLy/lsZXnpLrkuIDooYznmoTluILlnLrljJbliKnnjofvvIzph5Hpop3lsZXnpLrovpPlhaVcbiAgICAgICAgaXRlbS50aXRsZSA9IGAke3N1Yk51bVRleHR9ICR7JGRhdGEuaG9tZS5jdXJyZW5jeX1gO1xuICAgICAgICBpdGVtLnJhdGUgPSBgJHtjb21tb24uZm9ybWF0UHJlY2lzaW9uKG51bWJlci5tdWx0aXBseShtYXJrZXRBcHlWby5tYXJrZXRUaW1lQXB5LCAxMDApLCAyKS50b1N0cmluZygpfSVgO1xuICAgICAgICBpdGVtLnBlcmtWaXMgPSBcImdvbmVcIjtcbiAgICAgICAgaXRlbS50eXBlID0gXCIxXCI7XG4gICAgICAgIHByb2ZpdHMucHVzaChpdGVtKTtcbiAgICAgICAgaGFuZGxlckRhdGEucHJvZml0SGludFZpcyA9IFwiZ29uZVwiO1xuICAgICAgfSBlbHNlIHtcbiAgICAgICAgLy/lj6/og73lsZXnpLrkuIDooYzvvIzkuZ/lj6/og73lsZXnpLrkuKTooYxcbiAgICAgICAgaWYgKCh1c2VySW52ZXN0QW10KSA8PSBtYXJrZXRBcHlWby5tYXJrZXRQZXJrVXBMaW1pdCAtIHN1Yk51bSkge1xuICAgICAgICAgIC8v6L+Y5pyJ5Ymp5L2Z6aKd5bqm77yM5bGV56S65LiA6KGM55qE6KGl6LS05Yip546HXG4gICAgICAgICAgaXRlbS50aXRsZSA9IGAke3N1Yk51bVRleHR9ICR7JGRhdGEuaG9tZS5jdXJyZW5jeX1gO1xuICAgICAgICAgIGl0ZW0ucmF0ZSA9IGAke2NvbW1vbi5mb3JtYXRQcmVjaXNpb24obnVtYmVyLm11bHRpcGx5KG1hcmtldEFweVZvLm1hcmtldFBlcmtBcHkgLCAxMDApLCAyKS50b1N0cmluZygpfSVgO1xuICAgICAgICAgIGl0ZW0ucGVya1ZpcyA9IFwidmlzaWJsZVwiO1xuICAgICAgICAgIGl0ZW0udHlwZSA9ICcxJztcbiAgICAgICAgICBwcm9maXRzLnB1c2goaXRlbSk7XG4gICAgICAgICAgLy/lsZXnpLrmj5DnpLrmlofmoYjvvJrov5jmnIkgI2Ftb3VudDEjICNjdXJyZW5jeSMg6aKd5bqm5Y+v5Lqr5Y+X6K+l6KGl6LS0XG4gICAgICAgICAgaGFuZGxlckRhdGEucHJvZml0SGludFZpcyA9IFwidmlzaWJsZVwiO1xuICAgICAgICAgIGxldCBxdW90YSA9IGNvbW1vbi5yZW1vdmVFeHRyYVplcm9zKFxuICAgICAgICAgICAgY29tbW9uLmZvcm1hdFByZWNpc2lvbihudW1iZXIuc3VidHJhY3QobWFya2V0QXB5Vm8ubWFya2V0UGVya1VwTGltaXQgLSB1c2VySW52ZXN0QW10LCBzdWJOdW0pLCA4KVxuICAgICAgICAgICk7XG4gICAgICAgICAgaGFuZGxlckRhdGEucHJvZml0SGludCA9ICRpMThuLiRpbnRlcmNlcHQubl9zaW1wbGVfZWFybl9tb3JlX3F1b3RhKGAke3F1b3RhfSAkeyRkYXRhLmhvbWUuY3VycmVuY3l9YCk7XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgLy/msqHmnInliankvZnpop3luqbkuobvvIzlsZXnpLrkuKTooYxcbiAgICAgICAgICBsZXQgYW1vdW50MSA9IG51bWJlci5zdWJ0cmFjdChtYXJrZXRBcHlWby5tYXJrZXRQZXJrVXBMaW1pdCwgdXNlckludmVzdEFtdCk7XG4gICAgICAgICAgbGV0IGFtb3VudDFUZXh0ID0gY29tbW9uLnJlbW92ZUV4dHJhWmVyb3MoY29tbW9uLmZvcm1hdFByZWNpc2lvbihhbW91bnQxLCA4KSk7XG4gICAgICAgICAgaXRlbS50aXRsZSA9IGAke2Ftb3VudDFUZXh0fSAkeyRkYXRhLmhvbWUuY3VycmVuY3l9YDtcbiAgICAgICAgICBpdGVtLnJhdGUgPSBgJHtjb21tb24uZm9ybWF0UHJlY2lzaW9uKG51bWJlci5tdWx0aXBseShtYXJrZXRBcHlWby5tYXJrZXRQZXJrQXB5LCAxMDApLCAyKS50b1N0cmluZygpfSVgO1xuICAgICAgICAgIGl0ZW0ucGVya1ZpcyA9IFwidmlzaWJsZVwiO1xuICAgICAgICAgIGl0ZW0udHlwZSA9IFwiMVwiO1xuICAgICAgICAgIHByb2ZpdHMucHVzaChpdGVtKTtcbiAgICAgICAgICBpdGVtID0ge307XG4gICAgICAgICAgbGV0IGFtb3VudDIgPSBudW1iZXIuc3VidHJhY3Qoc3ViTnVtLCBhbW91bnQxKTtcbiAgICAgICAgICBsZXQgYW1vdW50MlRleHQgPSBjb21tb24ucmVtb3ZlRXh0cmFaZXJvcyhjb21tb24uZm9ybWF0UHJlY2lzaW9uKGFtb3VudDIsIDgpKTtcbiAgICAgICAgICBpdGVtLnRpdGxlID0gYCR7YW1vdW50MlRleHR9ICR7JGRhdGEuaG9tZS5jdXJyZW5jeX1gO1xuICAgICAgICAgIGl0ZW0ucmF0ZSA9IGAke2NvbW1vbi5mb3JtYXRQcmVjaXNpb24obnVtYmVyLm11bHRpcGx5KG1hcmtldEFweVZvLm1hcmtldFRpbWVBcHksIDEwMCksIDIpLnRvU3RyaW5nKCl9JWA7XG4gICAgICAgICAgaXRlbS5wZXJrVmlzID0gXCJnb25lXCI7XG4gICAgICAgICAgaXRlbS50eXBlID0gXCIxXCI7XG4gICAgICAgICAgcHJvZml0cy5wdXNoKGl0ZW0pO1xuICAgICAgICAgIGhhbmRsZXJEYXRhLnByb2ZpdEhpbnRWaXMgPSBcImdvbmVcIjtcbiAgICAgICAgfVxuICAgICAgfVxuICAgIH1cbiAgfVxuICAvL+WkhOeQhmxhdW5jaHBvb2zmoIfnrb5cbiAgaWYgKGhhbmRsZXJEYXRhLnRhZyA9PSA5ICYmIGhhbmRsZXJEYXRhLmxhdW5jaFBvb2xBY3Rpdml0eUlkICE9IG51bGwpIHtcbiAgICBsZXQgaXRlbSA9IHt9O1xuICAgIGl0ZW0udHlwZSA9IFwiMlwiO1xuICAgIGl0ZW0ubGF1bmNoUG9vbEFjdGl2aXR5SWQgPSBoYW5kbGVyRGF0YS5sYXVuY2hQb29sQWN0aXZpdHlJZDtcbiAgICBwcm9maXRzLnB1c2goaXRlbSk7XG4gIH1cbiAgY29uc29sZS5sb2coYCR7dGFnfSBoYW5kbGVQcm9maXRPdmVydmlld0RhdGEgZW5kICR7SlNPTi5zdHJpbmdpZnkocHJvZml0cyl9YCk7XG4gIHJldHVybiBwcm9maXRzO1xufVxuXG4vKipcbiAqIOWkhOeQhumYtuair+W5tOWMlueahOaVsOaNrlxuICovXG5mdW5jdGlvbiBoYW5kbGVMYWRkZXJEYXRhKHRpZXJlZFJhdGVzLCBoYW5kbGVyRGF0YSkge1xuICBsZXQgYW5zID0gW107XG4gIGZvciAobGV0IGkgPSAwOyBpIDwgdGllcmVkUmF0ZXMubGVuZ3RoOyBpKyspIHtcbiAgICBsZXQgaXRlbSA9IHRpZXJlZFJhdGVzW2ldO1xuICAgIGl0ZW0udHlwZSA9IFwiMVwiXG4gICAgaXRlbS5pbmRleCA9IGk7XG4gICAgaXRlbS5pbmRleFRleHQgPSBgJHtpICsgMX1gO1xuICAgIGl0ZW0uc2VsZWN0ID0gZmFsc2U7XG4gICAgaXRlbS5sYWRkZXJDb2xvciA9IGxhZGRlclJlcy5sYWRkZXJVbnNlbGVjdGVkQ29sb3I7XG4gICAgaXRlbS5sYWRkZXJJbWcgPSBsYWRkZXJSZXMubGFkZGVyVW5zZWxlY3RlZEltZztcbiAgICBpZiAoaXRlbS5hbW91bnRFbmQgIT0gMCkge1xuICAgICAgaXRlbS5jb250ZW50ID0gYCR7aXRlbS5hbW91bnRTdGFydH0gfiAke2l0ZW0uYW1vdW50RW5kfWA7XG4gICAgfSBlbHNlIHtcbiAgICAgIGl0ZW0uY29udGVudCA9IGA+ICR7aXRlbS5hbW91bnRTdGFydH1gO1xuICAgIH1cbiAgICBpdGVtLnJhdGVUZXh0ID0gYCR7Y29tbW9uLmZvcm1hdFByZWNpc2lvbihudW1iZXIubXVsdGlwbHkoaXRlbS5yYXRlLCAxMDApLCAyKX0lYDtcbiAgICBhbnMucHVzaChpdGVtKTtcbiAgfVxuICAvL+WkhOeQhmxhdW5jaHBvb2zmoIfnrb5cbiAgaWYgKGhhbmRsZXJEYXRhLnRhZyA9PSA5ICYmIGhhbmRsZXJEYXRhLmxhdW5jaFBvb2xBY3Rpdml0eUlkICE9IG51bGwpIHtcbiAgICBsZXQgaXRlbSA9IHt9O1xuICAgIGl0ZW0udHlwZSA9IFwiMlwiO1xuICAgIGl0ZW0ubGF1bmNoUG9vbEFjdGl2aXR5SWQgPSBoYW5kbGVyRGF0YS5sYXVuY2hQb29sQWN0aXZpdHlJZDtcbiAgICBhbnMucHVzaChpdGVtKTtcbiAgfVxuICByZXR1cm4gYW5zO1xufVxuXG5tb2R1bGVFdmVudC5jbGlja0xhdW5jaHBvb2wgPSBmdW5jdGlvbiAobGF1bmNoUG9vbEFjdGl2aXR5SWQpIHtcbiAgJGRhdGEuaG9tZS5pc1JlZnJlc2hEYXRhID0gZmFsc2U7XG4gIGNvbnNvbGUubG9nKGBzaW1wbGVfZWFybiBjbGlja0xhdW5jaHBvb2wgbGF1bmNoUG9vbEFjdGl2aXR5SWQ9ICR7bGF1bmNoUG9vbEFjdGl2aXR5SWR9YCk7XG4gIGNvbW1vbi5vcGVuUGFnZVdpdGhQYXRoKGAvYXNzZXRhY3Rpdml0eS9sYXVuY2hwb29sP2FjdGl2aXR5SWQ9JHtwYXJzZUludChsYXVuY2hQb29sQWN0aXZpdHlJZCl9YCk7XG4gIGFuYWx5dGljcy5sYXVuY2hwb29sUmV3YXJkc0NsaWNrKCk7XG59O1xuXG5tb2R1bGVFdmVudC5tYXhTdWIgPSBmdW5jdGlvbiAoaW5kZXgpIHtcbiAgbGV0IGVsZW1lbnQgPSAkZGF0YS5ob21lLnNsaWRlckRhdGFbaW5kZXhdO1xuICBjb25zb2xlLmxvZyhgbWF4U3ViIGNsaWNrICR7ZWxlbWVudC5iYWxhbmNlfSAke0pTT04uc3RyaW5naWZ5KGVsZW1lbnQpfWApO1xuICBpZiAoZWxlbWVudC5iYWxhbmNlID4gMCkge1xuICAgIGVsZW1lbnQuc3ViSW5wdXQgPSBzaG93QmFsYW5jZShlbGVtZW50LmJhbGFuY2UsIGZhbHNlKTtcbiAgICBlbGVtZW50Lm1TdWJJbnB1dCA9IGVsZW1lbnQuc3ViSW5wdXQ7XG4gICAgaWYgKGNvbW1vbi5jb21tb25EYXRhLk9TID09IDApIHtcbiAgICAgIG1vZHVsZUV2ZW50LnN1YlRleHRDaGFuZ2UoZWxlbWVudC5tU3ViSW5wdXQsIGluZGV4KTtcbiAgICB9XG4gIH0gZWxzZSB7XG4gICAgZWxlbWVudC5zdWJJbnB1dCA9IFwiMFwiO1xuICAgIGVsZW1lbnQubVN1YklucHV0ID0gZWxlbWVudC5zdWJJbnB1dDtcbiAgfVxuICBhbmFseXRpY3MubWF4Q2xpY2soZWxlbWVudCk7XG59XG5cbm1vZHVsZUV2ZW50LnN1YkZvY3VzQ2hhbmdlID0gZnVuY3Rpb24gKGZvY3VzKSB7XG4gIGNvbnNvbGUubG9nKGAke3RhZ30gc3ViRm9jdXNDaGFuZ2UgOiAke2ZvY3VzfWApO1xufVxuXG5tb2R1bGVFdmVudC5zdWJPblJldHVybiA9IGZ1bmN0aW9uIChwYXJhbWV0ZXIpIHtcbiAgY29uc29sZS5sb2coYCR7dGFnfSBzdWJPblJldHVybiA6ICR7cGFyYW1ldGVyfWApO1xuICBtb2R1bGVEYXRhLnN1Yk9uRm9jdXMgPSBmYWxzZTtcbn1cblxubW9kdWxlRXZlbnQuc3ViVGV4dENoYW5nZSA9IGZ1bmN0aW9uIChpbnB1dFN0ciwgaW5kZXgpIHtcbiAgbGV0IGVsZW1lbnQgPSAkZGF0YS5ob21lLnNsaWRlckRhdGFbaW5kZXhdO1xuICBjb25zb2xlLmxvZyhgJHt0YWd9IHN1YlRleHRDaGFuZ2UgOiBpbnB1dFN0cj0gJHtpbnB1dFN0cn0gbVN1YklucHV0PSAke2VsZW1lbnQubVN1YklucHV0fSBpbmRleD0gJHtpbmRleH1gKTtcbiAgLy8gaWYgKGVsZW1lbnQubVN1YklucHV0ID09PSBpbnB1dFN0cikge1xuICAvLyAgIHJldHVybjtcbiAgLy8gfVxuICBlbGVtZW50Lm1TdWJJbnB1dCA9IGlucHV0U3RyO1xuXG4gIGxldCBzdWJJbnQgPSAoaW5wdXRTdHIubGVuZ3RoID09PSAwKSA/IDAgOiBudW1iZXIuYmlnbnVtYmVyKGlucHV0U3RyKTtcblxuICByZWZyZXNoUHJvZml0KHN1YkludCwgZWxlbWVudCk7XG4gIGNvdXBvbkxpc3QucmVmcmVzaENvdXBvbihzdWJJbnQsIGVsZW1lbnQpO1xuICByZWZyZXNoTGFkZGVyKHN1YkludCwgZWxlbWVudCk7XG4gIHJlZnJlc2hQcm9maXRPdmVydmlldyhzdWJJbnQsIGVsZW1lbnQpO1xuXG4gIC8v5qOA5rWL6L6T5YWl5piv5ZCm5ZCI5rOVXG4gIGlmICghY2hlY2tTdWJJbnB1dChlbGVtZW50KSkge1xuICAgIGVsZW1lbnQuaW5wdXRTdGF0dXMgPSBmYWxzZTtcbiAgICAkZXZlbnQuZGVwb3NpdC5jaGVja0J0blN0YXR1cyhlbGVtZW50LnN0YXR1cywgZWxlbWVudC5pbnB1dFN0YXR1cyk7XG4gICAgcmV0dXJuO1xuICB9XG5cbiAgZWxlbWVudC5pbnB1dFN0YXR1cyA9IGVsZW1lbnQuc3ViRXJyb3JWaXMgPT0gXCJnb25lXCIgJiYgaW5wdXRTdHIgIT0gXCJcIjtcbiAgY29uc29sZS5sb2coYCR7dGFnfSBzdWJUZXh0Q2hhbmdlIGlucHV0U3RhdHVzPSAke2VsZW1lbnQuaW5wdXRTdGF0dXN9IC0gJHtlbGVtZW50LnN1YkVycm9yVmlzID09IFwiZ29uZVwifSAtICR7aW5wdXRTdHIgIT0gXCJcIn1gKTtcblxuICAvL+abtOaWsOeUs+i0reaMiemSrueKtuaAgVxuICBpZiAoJGV2ZW50LmRlcG9zaXQuY2hlY2tCdG5TdGF0dXMoZWxlbWVudC5zdGF0dXMsIGVsZW1lbnQuaW5wdXRTdGF0dXMpKSB7XG5cbiAgfVxufVxuXG5leHBvcnQgZnVuY3Rpb24gcmVmcmVzaFByb2ZpdE92ZXJ2aWV3KHN1Yk51bSwgZWxlbWVudCkge1xuICBjb25zb2xlLmxvZyhgJHt0YWd9IHJlZnJlc2hQcm9maXRPdmVydmlldyBzdWJOdW09ICR7c3ViTnVtfWApXG4gIGxldCBtTWFya2V0QXB5Vm8gPSBlbGVtZW50Lm1NYXJrZXRBcHlWbztcbiAgaWYgKG1NYXJrZXRBcHlWbyA9PSBudWxsKSB7XG4gICAgY29uc29sZS5sb2coYCR7dGFnfSByZWZyZXNoUHJvZml0T3ZlcnZpZXcgb3ZlciBiZWNhdXNlIG1NYXJrZXRBcHlWbyA9PSBudWxsYCk7XG4gICAgcmV0dXJuO1xuICB9XG4gIGxldCB1c2VySW52ZXN0QW10ID0gZWxlbWVudC51c2VySW52ZXN0QW10O1xuICBjb25zb2xlLmxvZyhgJHt0YWd9IHJlZnJlc2hQcm9maXRPdmVydmlldyBtTWFya2V0QXB5Vm89ICR7SlNPTi5zdHJpbmdpZnkobU1hcmtldEFweVZvKX0gdXNlckludmVzdEFtdD0gJHt1c2VySW52ZXN0QW10fWApO1xuICBlbGVtZW50LnByb2ZpdExpc3QgPSBoYW5kbGVQcm9maXRPdmVydmlld0RhdGEobU1hcmtldEFweVZvLCB1c2VySW52ZXN0QW10LCBlbGVtZW50LCBzdWJOdW0pO1xufVxuXG4vKipcbiAqIOWIt+aWsOmYtuair+W5tOWMllxuICovXG5mdW5jdGlvbiByZWZyZXNoTGFkZGVyKHN1Yk51bSwgZWxlbWVudCkge1xuICBjb25zb2xlLmxvZyhgJHt0YWd9IHJlZnJlc2hMYWRkZXIgYmVnaW4gJHtzdWJOdW19YCk7XG4gIGxldCBsYWRkZXJMaXN0ID0gZWxlbWVudC5sYWRkZXJMaXN0O1xuICBmb3IgKGxldCBpID0gMDsgaSA8IGxhZGRlckxpc3QubGVuZ3RoOyBpKyspIHtcbiAgICBsZXQgaXRlbSA9IGxhZGRlckxpc3RbaV07XG4gICAgaWYgKHN1Yk51bSA8PSBpdGVtLmFtb3VudFN0YXJ0KSB7XG4gICAgICBpdGVtLnNlbGVjdCA9IGZhbHNlO1xuICAgICAgaXRlbS5sYWRkZXJDb2xvciA9IGxhZGRlclJlcy5sYWRkZXJVbnNlbGVjdGVkQ29sb3I7XG4gICAgICBpdGVtLmxhZGRlckltZyA9IGxhZGRlclJlcy5sYWRkZXJVbnNlbGVjdGVkSW1nO1xuICAgIH0gZWxzZSB7XG4gICAgICBpdGVtLnNlbGVjdCA9IHRydWU7XG4gICAgICBpdGVtLmxhZGRlckNvbG9yID0gbGFkZGVyUmVzLmxhZGRlclNlbGVjdGVkQ29sb3I7XG4gICAgICBpdGVtLmxhZGRlckltZyA9IGxhZGRlclJlcy5sYWRkZXJTZWxlY3RlZEltZztcbiAgICB9XG4gIH1cbn1cblxuLyoqXG4gKiDliLfmlrDmr4/ml6XmlLbnm4ogXG4gKi9cbmFzeW5jIGZ1bmN0aW9uIHJlZnJlc2hQcm9maXQoc3ViSW50LCBlbGVtZW50KSB7XG4gIGNvbnNvbGUubG9nKGAke3RhZ30gcmVmcmVzaFByb2ZpdCBzdWIgPSAke3N1YkludH0gcHJvZml0IHZpc2libGU9ICR7ZWxlbWVudC5wcm9maXRFdmVyeURheX1gKTtcbiAgaWYgKGVsZW1lbnQucHJvZml0RXZlcnlEYXkgPT0gXCJnb25lXCIpIHtcbiAgICByZXR1cm47XG4gIH1cbiAgaWYgKHN1YkludCA9PSBudWxsIHx8IHN1YkludCA8PSAwKSB7XG4gICAgc3ViSW50ID0gMDtcbiAgfVxuICBpZiAoc3ViSW50ID09PSAwKSB7XG4gICAgZWxlbWVudC5lc3RpbWF0ZWRQcm9maXQgPSBgLS0gJHskZGF0YS5ob21lLmN1cnJlbmN5fWA7XG4gIH0gZWxzZSB7XG4gICAgbGV0IHBhcmFtID0geyBwcm9qZWN0SWQ6IGVsZW1lbnQucHJvamVjdElkLCBhbXQ6IHN1YkludCB9O1xuICAgIGNvbnNvbGUubG9nKGAke3RhZ30gcmVmcmVzaFByb2ZpdCBwYXJhbSA9ICR7SlNPTi5zdHJpbmdpZnkocGFyYW0pfWApXG4gICAgY29uc3QgZGF0YSA9IGF3YWl0IGNvbW1vbi5zZW5kUmVxdWVzdCgndjQvc2F2aW5nL21pbmluZy9wcm9qZWN0L3Byb2ZpdC9lc3RpbWF0ZScsIHBhcmFtKTtcbiAgICBjb25zb2xlLmxvZyhgJHt0YWd9IHJlZnJlc2hQcm9maXQgZGF0YSA9ICR7SlNPTi5zdHJpbmdpZnkoZGF0YSl9YClcbiAgICBpZiAoZGF0YSAhPSBudWxsKSB7XG4gICAgICBsZXQgcHJvZml0ID0gZGF0YS5wcm9maXRGb3JtYXRTaG93O1xuICAgICAgY29uc29sZS5sb2coYCR7dGFnfSByZWZyZXNoUHJvZml0IHByb2ZpdCA9ICR7cHJvZml0fWApXG4gICAgICAvLyBsZXQgZm9ybWF0ID0gc2hvd0JhbGFuY2UocHJvZml0LCB0cnVlKTtcbiAgICAgIGVsZW1lbnQuZXN0aW1hdGVkUHJvZml0ID0gYCR7cHJvZml0fSAkeyRkYXRhLmhvbWUuY3VycmVuY3l9YDtcbiAgICB9IGVsc2Uge1xuICAgICAgY29uc29sZS5sb2coYCR7dGFnfSByZWZyZXNoUHJvZml0IGVycm9yYClcbiAgICAgIGVsZW1lbnQuZXN0aW1hdGVkUHJvZml0ID0gYC0tICR7JGRhdGEuaG9tZS5jdXJyZW5jeX1gO1xuICAgIH1cbiAgfVxufVxuXG4vKipcbiAqIOajgOa1i+i+k+WFpeaYr+WQpuWQiOazlVxuICovXG5mdW5jdGlvbiBjaGVja1N1YklucHV0KGVsZW1lbnQpIHtcbiAgLy/mo4DmtYvkvZnpop3mmK/lkKblkIjms5VcbiAgY29uc3QgcXVhbnRpdHkgPSBwYXJzZUZsb2F0KGVsZW1lbnQubVN1YklucHV0KTsvL+ebruWJjeeUs+i0reaVsOmHj1xuICBjb25zdCBtaW5TdWIgPSBwYXJzZUZsb2F0KGVsZW1lbnQubU1pblN1Yik7Ly/mnIDlsJHnlLPotK3mlbBcbiAgY29uc3QgYmFsYW5jZSA9IHBhcnNlRmxvYXQoZWxlbWVudC5iYWxhbmNlKTsvL+S9meminVxuICAvL+WPr+eUs+i0reaVsOmHj+ajgOa1i1xuICBjb25zdCBhdmFpbGFibGVRdW90YSA9IHBhcnNlRmxvYXQoZWxlbWVudC5hdmFpbGFibGVRdW90YSk7XG4gIC8v5Y+v55So5L2Z6aKd5qOA5rWLXG4gIGlmIChxdWFudGl0eSA+IGJhbGFuY2UpIHtcbiAgICBlbGVtZW50LnN1YkJvcmRlckNvbG9yID0gXCJAY29sb3IvS0Jhc2VJbnB1dEludmFsaWRUaXBDb2xvclwiO1xuICAgIGVsZW1lbnQuc3ViRXJyb3JTdHIgPSAkaTE4bi5uX3NpbXBsZV9lYXJuX2lucHV0X292ZXJfYmFsYW5jZTtcbiAgICBlbGVtZW50LnN1YkVycm9yVmlzID0gXCJ2aXNpYmxlXCI7XG4gICAgcmV0dXJuIGZhbHNlO1xuICB9IGVsc2UgaWYgKHF1YW50aXR5IDwgbWluU3ViKSB7XG4gICAgZWxlbWVudC5zdWJCb3JkZXJDb2xvciA9IFwiQGNvbG9yL0tCYXNlSW5wdXRJbnZhbGlkVGlwQ29sb3JcIjtcbiAgICBlbGVtZW50LnN1YkVycm9yU3RyID0gJGkxOG4uJGludGVyY2VwdC5uX3NpbXBsZV9lYXJuX2lucHV0X21pbl9zdWJzY3JpYmUoXG4gICAgICBgJHtlbGVtZW50Lm1NaW5TdWJ9YCxcbiAgICAgIGAkeyRkYXRhLmhvbWUuY3VycmVuY3l9YFxuICAgICk7XG4gICAgZWxlbWVudC5zdWJFcnJvclZpcyA9IFwidmlzaWJsZVwiO1xuICAgIHJldHVybiBmYWxzZTtcbiAgfSBlbHNlIGlmIChxdWFudGl0eSA+IGF2YWlsYWJsZVF1b3RhKSB7XG4gICAgZWxlbWVudC5zdWJCb3JkZXJDb2xvciA9IFwiQGNvbG9yL0tCYXNlSW5wdXRJbnZhbGlkVGlwQ29sb3JcIjtcbiAgICBlbGVtZW50LnN1YkVycm9yU3RyID0gJGkxOG4ubl9zaW1wbGVfZWFybl9pbnB1dF9vdmVyX3F1b3RhO1xuICAgIGVsZW1lbnQuc3ViRXJyb3JWaXMgPSBcInZpc2libGVcIjtcbiAgICByZXR1cm4gZmFsc2U7XG4gIH0gZWxzZSB7XG4gICAgZWxlbWVudC5zdWJCb3JkZXJDb2xvciA9IFwiQGNvbG9yL0tCYXNlQ29sb3JJbnB1dEJhY2tncm91bmRcIjtcbiAgICBlbGVtZW50LnN1YkVycm9yVmlzID0gXCJnb25lXCI7XG4gICAgcmV0dXJuIHRydWU7XG4gIH1cbn1cblxubW9kdWxlRXZlbnQuY2xpY2tBdXRvRWFyblN3aXRjaCA9IGZ1bmN0aW9uIChpbmRleCkge1xuICBsZXQgZWxlbWVudCA9ICRkYXRhLmhvbWUuc2xpZGVyRGF0YVtpbmRleF07XG4gIGlmIChlbGVtZW50LmF1dG9FYXJuU3dpdGNoZXIgPT0gYXV0b0Vhcm5Td2l0Y2hSZXMub3BlbkltZykge1xuICAgIC8v6ZyA6KaB5YWz6ZetXG4gICAgZWxlbWVudC5hdXRvRWFyblN3aXRjaGVyID0gYXV0b0Vhcm5Td2l0Y2hSZXMuY2xvc2VJbWc7XG4gICAgZWxlbWVudC5hdXRvRWFybiA9IDA7XG4gIH0gZWxzZSB7XG4gICAgLy/pnIDopoHmiZPlvIBcbiAgICBlbGVtZW50LmF1dG9FYXJuU3dpdGNoZXIgPSBhdXRvRWFyblN3aXRjaFJlcy5vcGVuSW1nO1xuICAgIGVsZW1lbnQuYXV0b0Vhcm4gPSAxO1xuICB9XG4gIGFuYWx5dGljcy5hdXRvRWFyblN3aXRjaENsaWNrKGVsZW1lbnQuYXV0b0Vhcm4pO1xufVxuXG4iLCJpbXBvcnQgKiBhcyBjb21tb24gZnJvbSBcIi4vY29tbW9uXCI7XG5pbXBvcnQgKiBhcyBudW1iZXIgZnJvbSBcIi4vbnVtYmVyXCI7XG5pbXBvcnQgKiBhcyBmaXhlZCBmcm9tIFwiLi9maXhlZFwiXG5pbXBvcnQgKiBhcyBmbGV4aWJsZSBmcm9tIFwiLi9mbGV4aWJsZVwiXG5pbXBvcnQgKiBhcyBhbmFseXRpY3MgZnJvbSBcIi4vYW5hbHl0aWNzXCI7XG5pbXBvcnQgKiBhcyBmdW5kIGZyb20gXCIuL2Z1bmREaWFsb2dcIjtcblxuZnVuY3Rpb24gZGVmYXVsdERhdGEoKSB7XG4gIHJldHVybiB7XG4gICAgZGF0YVZpczogXCJnb25lXCIsLy/mlbDmja7lsZXnpLpcbiAgICBzY3JvbGxUb1RhZzogXCJcIiwvL+enu+WKqOWIsOaMh+WumnRhYlxuICAgIGVhcm5UYWJMaXN0OiBbXSwvL3RhYkxpc3RcbiAgICBzbGlkZXJEYXRhOiBbXSwvL3NsaWRlckRhdGFcbiAgICBjdXJyZW50SW5kZXg6IDAsLy/lvZPliY3pgInkuK3nmoR0YWJcbiAgICBjdXJyZW5jeTogXCJcIixcbiAgICBiYWxhbmNlOiBcIi0tXCIsXG4gICAgdG9wSWNvbjogXCJcIiwvL+mhtumDqOagh+mimGljb25cbiAgICB0b3BUaXRsZTogXCJcIiwvL+mhtumDqOagh+mimOaWh+ahiFxuICAgIHN1Ym1pdFRleHQ6ICRpMThuLm5fYmFsYW5jZV9taW5pbmdfZGVwb3NpdCwvL+eri+WNs+eUs+i0reaWh+ahiFxuICAgIGlzUmVmcmVzaERhdGE6IGZhbHNlLC8v55Sz6LSt6aG15LuO5ZCO5Y+w6L+U5Zue5pe277yM5piv5ZCm6ZyA6KaB5Yi35paw5pWw5o2uXG4gIH07XG59XG5cbnZhciBwYXJhbWV0ZXIgPSB7fTtcblxuLy/mtLvmnJ/lgJLorqHml7ZcbnZhciBpbnRlcmNhbCA9IG51bGw7XG52YXIgY3VycmVudENvdW50ID0gMTtcbnZhciByZXN1bWVJc05vdEZpcnN0ID0gZmFsc2U7XG52YXIgZWFyblRhYkxpc3QgPSBbXTtcbnZhciBjdXJyZW50U2VsZWN0SW5kZXggPSAtMTtcblxuLy8g6K6w5b2Vb25SZXN1bWXlm57osIPnmoTml7bpl7QgZm9yIOWfi+eCuVxudmFyIG9uUmVzdW1lVGltZSA9IDA7XG5cbiRkYXRhLmFzc2V0U291cmNlID0ge1xuICBwb3BTaG93OiBmYWxzZVxufVxuXG5jb25zdCB7IG1vZHVsZURhdGEsIG1vZHVsZUV2ZW50IH0gPSBjb21tb24ubW9kdWxlRGVmaW5lKFwiaG9tZVwiLCBkZWZhdWx0RGF0YSwgeyBvbkNyZWF0ZSwgb25SZXN1bWUsIG9uRGVzdHJveSB9KTtcblxuZnVuY3Rpb24gb25DcmVhdGUoanNvblBhcmFtZXRlcnMpIHtcbiAgY29uc29sZS5sb2coJ2hvbWUgLS0gIG9uQ3JlYXRlOiAnICsgYCR7anNvblBhcmFtZXRlcnN9YCk7XG4gIG1vZHVsZURhdGEuc3RhdHVzQmFyQ29uZmlnID0geyBcInN0YXR1c0Jhck1vZGVcIjogXCJ0cnVlXCIsIFwiYWRTdGF0dXNCYXJDb2xvclwiOiBcImtDb2xvckNvbnRlbnRCYWNrZ3JvdW5kXCIgfTtcbiAgbW9kdWxlRGF0YS5uYXZDb25maWcgPSBnZXROYXZDb25maWdTdHJpbmcoKTtcbiAgLy/luKblhaXlj4LmlbBcbiAgcGFyYW1ldGVyID0gSlNPTi5wYXJzZShqc29uUGFyYW1ldGVycyk7XG4gIC8v6K6+572u6LWa5biB5Y2P6K6uXG4gICRkYXRhLmRlcG9zaXQucmljaFRleHREYXRhID0gYHtcImNvbnRlbnRcIjpcIm5fc2ltcGxlX2Vhcm5fYXV0aF9jb25maXJtXCIsXCJ0ZXh0Q29sb3JcIjpcImtDb2xvclByaW1hcnlUZXh0XCIsXCJ0ZXh0U2l6ZVwiOjEyLFwiaGlnaGxpZ2h0XCI6W3tcImNvbnRlbnRcIjpcIm5fc2ltcGxlX2Vhcm5fYXV0aF9jb25maXJtX2xpbmtcIixcImxpbmtcIjpcIiR7Y29tbW9uLmNvbW1vbkRhdGEuaDVVcmx9LyR7Y29tbW9uLmNvbW1vbkRhdGEubGFuZ3VhZ2V9L3N1cHBvcnQvOTAwMDA0OTY3MzIzXCIsXCJ0ZXh0Q29sb3JcIjpcIktCYXNlQ29sb3JNYWpvclRoZW1lMTAwXCIsXCJ0ZXh0U2l6ZVwiOjEyfV19YDtcbiAgLy/orr7nva7pobbpg6hpY29uXG4gIG1vZHVsZURhdGEudG9wSWNvbiA9IGNvbW1vbi5nZXRQTkdJY29uVVJMQnlDdXJyZW5jeShwYXJhbWV0ZXIuY3VycmVuY3kpO1xuICBtb2R1bGVEYXRhLnRvcFRpdGxlID0gYCR7cGFyYW1ldGVyLmN1cnJlbmN5fSAkeyRpMThuLm5fa2xpbmVfZGV0YWlsX2Vhcm5jb2luc31gO1xuICByZXF1ZXN0RmxleGlibGVEZXRhaWwodHJ1ZSk7XG59XG5cbmZ1bmN0aW9uIG9uUmVzdW1lKCkge1xuICBpZiAocmVzdW1lSXNOb3RGaXJzdCAmJiAkZGF0YS5ob21lLmlzUmVmcmVzaERhdGEpIHtcbiAgICBjb25zb2xlLmxvZygnaG9tZSBvblJlc3VtZScpO1xuICAgIHJlcXVlc3RGbGV4aWJsZURldGFpbChmYWxzZSk7XG4gICAgJGRhdGEuaG9tZS5pc1JlZnJlc2hEYXRhID0gZmFsc2U7XG4gIH1cbiAgcmVzdW1lSXNOb3RGaXJzdCA9IHRydWU7XG59XG5cbmZ1bmN0aW9uIG9uRGVzdHJveSgpIHtcbiAgY2xlYXJUaW1lcigpO1xufVxuXG5hc3luYyBmdW5jdGlvbiByZXF1ZXN0RmxleGlibGVEZXRhaWwoaXNGaXJzdFRpbWUsIG9ubHlSZWZyZXNoQXB5ID0gZmFsc2UpIHtcbiAgb25SZXN1bWVUaW1lID0gRGF0ZS5ub3coKTtcbiAgbGV0IHJlcU9ia2ogPSB7XG4gICAgY3VycmVuY3k6IHBhcmFtZXRlci5jdXJyZW5jeSxcbiAgfTtcblxuICBjb25zdCBkYXRhID0gYXdhaXQgY29tbW9uLnNlbmRSZXF1ZXN0KCd2NC9zYXZpbmcvbWluaW5nL3Byb2plY3QvYnV5L21lcmdlL2RldGFpbCcsIHJlcU9ia2opO1xuICBpZiAoZGF0YSA9PSBudWxsKSB7XG4gICAgLy8g5Luj6KGo5o6l5Y+j5oql6ZSZXG4gICAgLy8g6aG16Z2i5Yqg6L2954q25oCB5Z+L54K5XG4gICAgYW5hbHl0aWNzLmVhcm5QdXJjaGFzZUxvYWRTdGF0dXMoXCJmYXVsdFwiKTtcbiAgfVxuICBjb25zb2xlLmxvZyhgYnV5L21lcmdlL2RldGFpbCA6ICR7SlNPTi5zdHJpbmdpZnkoZGF0YSl9YClcblxuICAvL+WcqOatpOWkhOeQhuWKoOaBr+WIuOWIl+ihqOiOt+WPllxuICBsZXQgcGlkcyA9IFtdO1xuICBmb3IgKGNvbnN0IHAgb2YgZGF0YS5wcm9qZWN0cykge1xuICAgIC8v5rS75pyf5bm25LiU5pSv5oyB5Yqg5oGv5Yi4XG4gICAgaWYgKHAucHJvZHVjdFR5cGUgPT0gXCIwXCIgJiYgcC5zdXBwb3J0Q291cG9uID09IDEpIHtcbiAgICAgIHBpZHMucHVzaChwLnByb2plY3RJZCk7XG4gICAgfSBlbHNlIGlmIChwLnByb2R1Y3RUeXBlID09IFwiMVwiICYmIHAuc3VwcG9ydENvdXBvbiA9PSAxKSB7XG4gICAgICBpZiAocC5maXhlZFR5cGUgPT0gXCIwXCIgfHwgcC5maXhlZFR5cGUgPT0gXCIyXCIpIHtcbiAgICAgICAgcGlkcy5wdXNoKHAucHJvamVjdElkKTtcbiAgICAgIH1cbiAgICB9XG4gIH1cbiAgY29uc29sZS5sb2coYHJlcXVlc3RGbGV4aWJsZURldGFpbCBwaWRzPSAke0pTT04uc3RyaW5naWZ5KHBpZHMpfWApXG4gIGxldCBvcmlnaW5Db3Vwb25EYXRhID0ge307XG4gIGlmIChwaWRzLmxlbmd0aCA+IDApIHtcbiAgICBsZXQgcHJvamVjdElkcyA9IHBpZHMuam9pbignLCcpO1xuICAgIGxldCBwYXJhbSA9IHsgcHJvamVjdElkczogcHJvamVjdElkcyB9O1xuICAgIGNvbnNvbGUubG9nKGByZXF1ZXN0RmxleGlibGVEZXRhaWwgcGFyYW09ICR7SlNPTi5zdHJpbmdpZnkocGFyYW0pfWApXG4gICAgY29uc3QgY291cG9uRGF0YSA9IGF3YWl0IGNvbW1vbi5zZW5kUmVxdWVzdCgndjQvc2F2aW5nL21pbmluZy9wcm9qZWN0L2J1eS9tZXJnZS9jb3Vwb25zJywgcGFyYW0pO1xuICAgIGlmIChjb3Vwb25EYXRhICYmIGNvdXBvbkRhdGEgIT0gbnVsbCkge1xuICAgICAgb3JpZ2luQ291cG9uRGF0YSA9IGNvdXBvbkRhdGE7XG4gICAgfVxuICB9XG4gICRkYXRhLmZ1bmQuc3RhdHVzVVNERCA9IGF3YWl0IGNvbW1vbi5yZWFkKGZ1bmQuY29uc3RhbnNTcC5tb2R1bGVOYW1lLCBmdW5kLmNvbnN0YW5zU3Auc3BLZXlVU0REKTtcbiAgJGRhdGEuZnVuZC5zdGF0dXNVU0RUID0gYXdhaXQgY29tbW9uLnJlYWQoZnVuZC5jb25zdGFuc1NwLm1vZHVsZU5hbWUsIGZ1bmQuY29uc3RhbnNTcC5zcEtleVVTRFQpO1xuICBjb25zb2xlLmxvZyhgcmVxdWVzdEZsZXhpYmxlRGV0YWlsIHN0YXR1c1VTREQ9ICR7JGRhdGEuZnVuZC5zdGF0dXNVU0REfSBzdGF0dXNVU0RUPSAkeyRkYXRhLmZ1bmQuc3RhdHVzVVNEVH1gKTtcbiAgY29uc29sZS5sb2coYHJlcXVlc3RGbGV4aWJsZURldGFpbCBvcmlnaW5Db3Vwb25EYXRhPSAke0pTT04uc3RyaW5naWZ5KG9yaWdpbkNvdXBvbkRhdGEpfWApXG4gIC8v6Kej5p6QdGFi5pWw5o2uXG4gIGhhbmRsZVRhYkRhdGEoZGF0YSwgb3JpZ2luQ291cG9uRGF0YSwgaXNGaXJzdFRpbWUsIG9ubHlSZWZyZXNoQXB5KTtcbn1cblxuZnVuY3Rpb24gaGFuZGxlVGFiRGF0YShkYXRhLCBvcmlnaW5Db3Vwb25EYXRhLCBpc0ZpcnN0VGltZSwgb25seVJlZnJlc2hBcHkgPSBmYWxzZSkge1xuICAvLyDluIHnp43vvIzkvZnpop1cbiAgbW9kdWxlRGF0YS5jdXJyZW5jeSA9IGRhdGEuY3VycmVuY3k7XG4gIG1vZHVsZURhdGEuYmFsYW5jZVRleHQgPSBgJHtjb21tb24ucmVtb3ZlRXh0cmFaZXJvcyhjb21tb24uZ2V0UHJpY2VTdHJpbmcoZGF0YS5iYWxhbmNlQW1vdW50LCA4KSl9YDtcbiAgbW9kdWxlRGF0YS5iYWxhbmNlID0gZGF0YS5iYWxhbmNlQW1vdW50O1xuICAvKipcbiAgICogdHlwZSAvLzFcbiAgICogdGFnICAvL+a7keWKqHRhZ1xuICAgKiBib3JkZXJDb2xvciAvL+aYr+WQpumAieS4reminOiJsuWPmOabtFxuICAgKiB0YWdWaXMgLy/mmK/lkKblsZXnpLrmoIfnrb5cbiAgICogdGltZVZpcyAvL+aYr+WQpuWxleekuuWAkuiuoeaXtlxuICAgKiB0YWdCZ0NvbG9yIC8v5Y+z5LiK6KeS5qCH562+6IOM5pmv6aKc6ImyXG4gICAqIHRhZ0ljb24gLy/moIfnrb4gaWNvblxuICAgKiB0YWdUZXh0IC8v5qCH562+5paH5qGIXG4gICAqIGVhcm5pbmdzIC8v5pS255uKXG4gICAqIGN5Y2xlIC8v5ZGo5pyfXG4gICAqL1xuICB2YXIgZXJhblRhYkRhdGEgPSBbXTtcbiAgdmFyIHNsaWRlckRhdGEgPSBbXTtcblxuICAvL+iHquWinue0ouW8lVxuICB2YXIgaWR4ID0gMDtcbiAgZGF0YS5wcm9qZWN0cy5mb3JFYWNoKChlbGVtZW50LCBpbmRleCkgPT4ge1xuICAgIGlmIChjdXJyZW50U2VsZWN0SW5kZXggPT0gLTEgJiYgcGFyYW1ldGVyLnByb2plY3RJZCAhPSB1bmRlZmluZWQgJiYgcGFyYW1ldGVyLnByb2plY3RJZC5pbmNsdWRlcyhlbGVtZW50LnByb2plY3RJZCkpIHtcbiAgICAgIGNvbnNvbGUubG9nKGBzaW1wbGVfZWFybl9ob21lIHNlbGVjdGVkIHByb2plY3RJZD0gJHtwYXJhbWV0ZXIucHJvamVjdElkfSBpZHg9ICR7aWR4fWApO1xuICAgICAgY3VycmVudFNlbGVjdEluZGV4ID0gaWR4O1xuICAgIH1cbiAgICBpZiAoZWxlbWVudC5wcm9kdWN0VHlwZSA9PSBcIjBcIikgey8v5rS75pyfXG4gICAgICBpZiAoZWxlbWVudC5hcHlUeXBlID09IFwiMFwiKSB7XG4gICAgICAgIC8v5Zu65a6a5rS75pyfXG4gICAgICAgIGVyYW5UYWJEYXRhLnB1c2goe1xuICAgICAgICAgIHR5cGU6IFwiMVwiLFxuICAgICAgICAgIHRhZzogU3RyaW5nKGlkeCksXG4gICAgICAgICAgYm9yZGVyQ29sb3I6IGlkeCA9PSBjdXJyZW50U2VsZWN0SW5kZXggPyBcIkBjb2xvci9rQ29sb3JNYWpvclRoZW1lMTAwXCIgOiBcIkBjb2xvci9rQ29sb3JFQkVCRUJcIixcbiAgICAgICAgICB0YWdWaXM6IGdldFRhZ1ZpcyhlbGVtZW50LnRhZyksXG4gICAgICAgICAgdGFnQmc6IGdldFRhZ0JnKGVsZW1lbnQudGFnKSxcbiAgICAgICAgICB0YWdUZXh0OiBnZXRUYWdUZXh0KGVsZW1lbnQudGFnLCBlbGVtZW50LnRhZ05hbWUpLFxuICAgICAgICAgIHRhZ1RleHRDb2xvcjogZ2V0VGFnVGV4dENvbG9yKGVsZW1lbnQudGFnKSxcbiAgICAgICAgICB0YWJXaWR0aDogZ2V0VGFnV2lkdGgoZWxlbWVudC50YWcpLFxuICAgICAgICAgIHRpbWVWaXM6IFwiZ29uZVwiLFxuICAgICAgICAgIGVhcm5pbmdzOiBgJHtjb21tb24uZm9ybWF0UHJlY2lzaW9uKG51bWJlci5tdWx0aXBseShlbGVtZW50LmFweVNob3csIDEwMCksIDIpfSVgLFxuICAgICAgICAgIGN5Y2xlOiAkaTE4bi5uX2Fzc2V0X2Vhcm5fY3VycmVudFxuICAgICAgICB9KVxuICAgICAgICBpZiAoIW9ubHlSZWZyZXNoQXB5KSB7XG4gICAgICAgICAgLy9zbGlkZXIg5pWw5o2uXG4gICAgICAgICAgdmFyIGRhdGEgPSBmbGV4aWJsZS5oYW5kbGVDdXJyZW50RGV0YWlsKGVsZW1lbnQsIG9yaWdpbkNvdXBvbkRhdGEpO1xuICAgICAgICAgIGRhdGEuaW5kZXggPSBpZHg7XG4gICAgICAgICAgZGF0YS50eXBlID0gXCIxXCI7XG4gICAgICAgICAgY29uc29sZS5sb2coYCR7aWR4fSDlm7rlrprmtLvmnJ8gaGFuZGxlQ3VycmVudERldGFpbCA6ICR7SlNPTi5zdHJpbmdpZnkoZGF0YSl9YCk7XG4gICAgICAgICAgc2xpZGVyRGF0YS5wdXNoKGRhdGEpO1xuICAgICAgICB9XG4gICAgICAgIGlkeCsrO1xuICAgICAgfSBlbHNlIGlmIChlbGVtZW50LmFweVR5cGUgPT0gXCIxXCIpIHtcbiAgICAgICAgY29uc3QgY3VyQXB5ID0gYCR7Y29tbW9uLmZvcm1hdFByZWNpc2lvbihudW1iZXIubXVsdGlwbHkobWF4QXB5KGVsZW1lbnQpLCAxMDApLCAyKX0lYDtcbiAgICAgICAgaWYgKG9ubHlSZWZyZXNoQXB5KSB7XG4gICAgICAgICAgY29uc3QgbGFzdFRhYiA9IG1vZHVsZURhdGEuZWFyblRhYkxpc3RbaWR4XTtcbiAgICAgICAgICBjb25zdCBsYXN0QXB5ID0gbGFzdFRhYi5lYXJuaW5ncztcbiAgICAgICAgICBjb25zb2xlLmxvZyhcbiAgICAgICAgICAgIGBzaW1wbGVfZWFybl9ob21lIG9ubHlSZWZyZXNoQXB5IGxhc3RBcHk9ICR7bGFzdEFweX0gY3VyQXB5PSAke2N1ckFweX0gb25seVJlZnJlc2hBcHk9ICR7b25seVJlZnJlc2hBcHl9YFxuICAgICAgICAgICk7XG4gICAgICAgICAgaWYgKGxhc3RBcHkgIT0gY3VyQXB5KSB7XG4gICAgICAgICAgICAvL+WPqumcgOimgeWIt+aWsOWIqeeOh+ebuOWFs+aVsOaNrlxuICAgICAgICAgICAgY29uc3QgbGFzdEVsZW1lbnQgPSBtb2R1bGVEYXRhLnNsaWRlckRhdGFbaWR4XTtcbiAgICAgICAgICAgIGxhc3RFbGVtZW50Lm1NYXJrZXRBcHlWbyA9IGVsZW1lbnQubWFya2V0QXB5Vm87XG4gICAgICAgICAgICBmbGV4aWJsZS5yZWZyZXNoUHJvZml0T3ZlcnZpZXcobGFzdEVsZW1lbnQubVN1YklucHV0LCBsYXN0RWxlbWVudCk7XG4gICAgICAgICAgICBsYXN0VGFiLmVhcm5pbmdzID0gY3VyQXB5O1xuICAgICAgICAgIH1cbiAgICAgICAgICBsYXN0VGFiLmFweUNvdW50ZG93biA9IGVsZW1lbnQuYXB5Q291bnRkb3duO1xuICAgICAgICAgIGxhc3RUYWIudGltZVRleHQgPSBmb3JtYXREYXRlKGVsZW1lbnQuYXB5Q291bnRkb3duKTtcbiAgICAgICAgfVxuICAgICAgICAvL+W4guWcuuWMlua0u+acn1xuICAgICAgICBlcmFuVGFiRGF0YS5wdXNoKHtcbiAgICAgICAgICB0eXBlOiBcIjFcIixcbiAgICAgICAgICB0YWc6IFN0cmluZyhpZHgpLFxuICAgICAgICAgIGJvcmRlckNvbG9yOiBpZHggPT0gY3VycmVudFNlbGVjdEluZGV4ID8gXCJAY29sb3Iva0NvbG9yTWFqb3JUaGVtZTEwMFwiIDogXCJAY29sb3Iva0NvbG9yRUJFQkVCXCIsXG4gICAgICAgICAgdGFnVmlzOiBnZXRUYWdWaXMoZWxlbWVudC50YWcpLFxuICAgICAgICAgIHRhZ0JnOiBnZXRUYWdCZyhlbGVtZW50LnRhZyksXG4gICAgICAgICAgdGFnVGV4dDogZ2V0VGFnVGV4dChlbGVtZW50LnRhZywgZWxlbWVudC50YWdOYW1lKSxcbiAgICAgICAgICB0YWdUZXh0Q29sb3I6IGdldFRhZ1RleHRDb2xvcihlbGVtZW50LnRhZyksXG4gICAgICAgICAgdGFiV2lkdGg6IGdldFRhZ1dpZHRoKGVsZW1lbnQudGFnKSxcbiAgICAgICAgICB0aW1lVmlzOiBcInZpc2libGVcIixcbiAgICAgICAgICB0aW1lSWNvbjogXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfY291bnRfZG93blwiLFxuICAgICAgICAgIHByb2R1Y3RUeXBlOiBlbGVtZW50LnByb2R1Y3RUeXBlLFxuICAgICAgICAgIGFweVR5cGU6IGVsZW1lbnQuYXB5VHlwZSxcbiAgICAgICAgICBhcHlDb3VudGRvd246IGVsZW1lbnQuYXB5Q291bnRkb3duLFxuICAgICAgICAgIHRpbWVUZXh0OiBmb3JtYXREYXRlKGVsZW1lbnQuYXB5Q291bnRkb3duKSwgLy/lgJLorqHml7ZcbiAgICAgICAgICBlYXJuaW5nczogY3VyQXB5LFxuICAgICAgICAgIGN5Y2xlOiAkaTE4bi5uX2Fzc2V0X2Vhcm5fY3VycmVudFxuICAgICAgICB9KVxuICAgICAgICAvL3NsaWRlciDmlbDmja5cbiAgICAgICAgaWYgKCFvbmx5UmVmcmVzaEFweSkge1xuICAgICAgICAgIHZhciBkYXRhID0gZmxleGlibGUuaGFuZGxlQ3VycmVudERldGFpbChlbGVtZW50LCBvcmlnaW5Db3Vwb25EYXRhKTtcbiAgICAgICAgICBkYXRhLmluZGV4ID0gaWR4O1xuICAgICAgICAgIGRhdGEudHlwZSA9IFwiMVwiXG4gICAgICAgICAgY29uc29sZS5sb2coYCR7aWR4fSDluILlnLrljJbmtLvmnJ8gaGFuZGxlQ3VycmVudERldGFpbCA6ICR7SlNPTi5zdHJpbmdpZnkoZGF0YSl9YCk7XG4gICAgICAgICAgc2xpZGVyRGF0YS5wdXNoKGRhdGEpO1xuICAgICAgICB9XG4gICAgICAgIHN0YXJ0Q3VycmVudENvdW50RG93bigpO1xuICAgICAgICBpZHgrKztcbiAgICAgIH1cbiAgICB9IGVsc2UgaWYgKGVsZW1lbnQucHJvZHVjdFR5cGUgPT0gXCIxXCIpIHsvL+Wumuacn1xuICAgICAgaWYgKGVsZW1lbnQuZml4ZWRUeXBlID09IFwiMFwiIHx8IGVsZW1lbnQuZml4ZWRUeXBlID09IFwiMlwiKSB7XG4gICAgICAgIC8v5pmu6YCa5a6a5pyfIFxuICAgICAgICBlcmFuVGFiRGF0YS5wdXNoKHtcbiAgICAgICAgICB0eXBlOiBcIjFcIixcbiAgICAgICAgICB0YWc6IFN0cmluZyhpZHgpLFxuICAgICAgICAgIGJvcmRlckNvbG9yOiBpZHggPT0gY3VycmVudFNlbGVjdEluZGV4ID8gXCJAY29sb3Iva0NvbG9yTWFqb3JUaGVtZTEwMFwiIDogXCJAY29sb3Iva0NvbG9yRUJFQkVCXCIsXG4gICAgICAgICAgdGFnVmlzOiBnZXRUYWdWaXMoZWxlbWVudC50YWcpLFxuICAgICAgICAgIHRhZ0JnOiBnZXRUYWdCZyhlbGVtZW50LnRhZyksXG4gICAgICAgICAgdGFnVGV4dDogZ2V0VGFnVGV4dChlbGVtZW50LnRhZywgZWxlbWVudC50YWdOYW1lKSxcbiAgICAgICAgICB0YWdUZXh0Q29sb3I6IGdldFRhZ1RleHRDb2xvcihlbGVtZW50LnRhZyksXG4gICAgICAgICAgdGFiV2lkdGg6IGdldFRhZ1dpZHRoKGVsZW1lbnQudGFnKSxcbiAgICAgICAgICB0aW1lVmlzOiBcImdvbmVcIixcbiAgICAgICAgICBlYXJuaW5nczogYCR7Y29tbW9uLmZvcm1hdFByZWNpc2lvbihudW1iZXIubXVsdGlwbHkoZWxlbWVudC5hcHlTaG93LCAxMDApLCAyKX0lYCxcbiAgICAgICAgICBjeWNsZTogYCR7ZWxlbWVudC50ZXJtfSAkeyRpMThuLm5fbWluaW5nX2RheV90ZXh0fWBcbiAgICAgICAgfSlcbiAgICAgICAgaWYgKCFvbmx5UmVmcmVzaEFweSkge1xuICAgICAgICAgIC8vc2xpZGVyIOaVsOaNrlxuICAgICAgICAgIHZhciBpdGVtRGF0YSA9IGZpeGVkLmhhbmRsZUZsZXhpYmxlRGV0YWlsKGVsZW1lbnQsIG9yaWdpbkNvdXBvbkRhdGEpO1xuICAgICAgICAgIGl0ZW1EYXRhLmluZGV4ID0gaWR4O1xuICAgICAgICAgIGl0ZW1EYXRhLnR5cGUgPSBcIjJcIjtcbiAgICAgICAgICBjb25zb2xlLmxvZyhgJHtpZHh9IOaZrumAmuWumuacnyAgaGFuZGxlRmxleGlibGVEZXRhaWwgOiAke0pTT04uc3RyaW5naWZ5KGl0ZW1EYXRhKX1gKTtcbiAgICAgICAgICBzbGlkZXJEYXRhLnB1c2goaXRlbURhdGEpO1xuICAgICAgICB9XG4gICAgICAgIGlkeCsrO1xuICAgICAgfSBlbHNlIGlmIChlbGVtZW50LmZpeGVkVHlwZSA9PSBcIjFcIikge1xuICAgICAgICAvL+aWsOaJi+S4k+S6q1xuICAgICAgICBlcmFuVGFiRGF0YS5wdXNoKHtcbiAgICAgICAgICB0eXBlOiBcIjFcIixcbiAgICAgICAgICB0YWc6IFN0cmluZyhpZHgpLFxuICAgICAgICAgIGJvcmRlckNvbG9yOiBpZHggPT0gY3VycmVudFNlbGVjdEluZGV4ID8gXCJAY29sb3Iva0NvbG9yTWFqb3JUaGVtZTEwMFwiIDogXCJAY29sb3Iva0NvbG9yRUJFQkVCXCIsXG4gICAgICAgICAgdGFnVmlzOiBnZXRUYWdWaXMoZWxlbWVudC50YWcpLFxuICAgICAgICAgIHRhZ0JnOiBnZXRUYWdCZyhlbGVtZW50LnRhZyksXG4gICAgICAgICAgdGFnVGV4dDogZ2V0VGFnVGV4dChlbGVtZW50LnRhZywgZWxlbWVudC50YWdOYW1lKSxcbiAgICAgICAgICB0YWdUZXh0Q29sb3I6IGdldFRhZ1RleHRDb2xvcihlbGVtZW50LnRhZyksXG4gICAgICAgICAgdGFiV2lkdGg6IGdldFRhZ1dpZHRoKGVsZW1lbnQudGFnKSxcbiAgICAgICAgICB0aW1lVmlzOiBcImdvbmVcIixcbiAgICAgICAgICBlYXJuaW5nczogYCR7Y29tbW9uLmZvcm1hdFByZWNpc2lvbihudW1iZXIubXVsdGlwbHkoZWxlbWVudC5hcHlTaG93LCAxMDApLCAyKX0lYCxcbiAgICAgICAgICBjeWNsZTogYCR7ZWxlbWVudC50ZXJtfSAkeyRpMThuLm5fbWluaW5nX2RheV90ZXh0fWBcbiAgICAgICAgfSlcbiAgICAgICAgaWYgKCFvbmx5UmVmcmVzaEFweSkge1xuICAgICAgICAgIC8vc2xpZGVyIOaVsOaNrlxuICAgICAgICAgIHZhciBpdGVtRGF0YSA9IGZpeGVkLmhhbmRsZUZsZXhpYmxlRGV0YWlsKGVsZW1lbnQsIG9yaWdpbkNvdXBvbkRhdGEsIGlkeCwgb25seVJlZnJlc2hBcHkpO1xuICAgICAgICAgIGl0ZW1EYXRhLmluZGV4ID0gaWR4O1xuICAgICAgICAgIGl0ZW1EYXRhLnR5cGUgPSBcIjJcIjtcbiAgICAgICAgICBjb25zb2xlLmxvZyhgJHtpZHh9IOaWsOaJi+S4k+S6qyAgaGFuZGxlRmxleGlibGVEZXRhaWwgOiAke0pTT04uc3RyaW5naWZ5KGl0ZW1EYXRhKX1gKTtcbiAgICAgICAgICBzbGlkZXJEYXRhLnB1c2goaXRlbURhdGEpO1xuICAgICAgICB9XG4gICAgICAgIGlkeCsrO1xuICAgICAgfVxuICAgIH1cbiAgfSk7XG5cbiAgY29uc29sZS5sb2coYCR7aWR4fSBoYW5kbGVUYWJEYXRhIHNsaWRlckRhdGEgOiAke0pTT04uc3RyaW5naWZ5KHNsaWRlckRhdGEpfWApO1xuICBjb25zb2xlLmxvZyhgJHtpZHh9IGhhbmRsZVRhYkRhdGEgZXJhblRhYkRhdGEgOiAke0pTT04uc3RyaW5naWZ5KGVyYW5UYWJEYXRhKX1gKTtcbiAgZWFyblRhYkxpc3QgPSBlcmFuVGFiRGF0YTtcbiAgLy/mt7vliqDlrprkvY3lpLHotKXlhZzlupVcbiAgaWYgKGN1cnJlbnRTZWxlY3RJbmRleCA9PSAtMSkge1xuICAgIG1vZHVsZURhdGEuY3VycmVudEluZGV4ID0gMDtcbiAgICBlYXJuVGFiTGlzdFswXS5ib3JkZXJDb2xvciA9IFwiQGNvbG9yL2tDb2xvck1ham9yVGhlbWUxMDBcIjtcbiAgfSBlbHNlIHtcbiAgICBtb2R1bGVEYXRhLmN1cnJlbnRJbmRleCA9IGN1cnJlbnRTZWxlY3RJbmRleDtcbiAgfVxuICAvL+abtOaWsOWIqeeOh+S9v+eUqOWxgOmDqOabtOaWsFxuICBpZiAoIW9ubHlSZWZyZXNoQXB5KSB7XG4gICAgbW9kdWxlRGF0YS5zbGlkZXJEYXRhID0gc2xpZGVyRGF0YTtcbiAgICBtb2R1bGVEYXRhLmVhcm5UYWJMaXN0ID0gZWFyblRhYkxpc3Q7XG4gIH1cblxuICBsZXQgZWxlbWVudCA9IG1vZHVsZUV2ZW50LmdldEN1cnJlbnRFbGVtZW50KG1vZHVsZURhdGEuY3VycmVudEluZGV4KTtcbiAgJGV2ZW50LmRlcG9zaXQuY2hlY2tCdG5TdGF0dXMoZWxlbWVudC5zdGF0dXMsIGVsZW1lbnQuaW5wdXRTdGF0dXMpO1xuICAvLyDpobXpnaLmmL7npLpcbiAgbW9kdWxlRGF0YS5kYXRhVmlzID0gXCJ2aXNpYmxlXCI7XG5cbiAgLy8g6aG16Z2i5pud5YWJ5Z+L54K5XG4gIGFuYWx5dGljcy5wYWdlU2hvdyhtb2R1bGVEYXRhLnNsaWRlckRhdGFbbW9kdWxlRGF0YS5jdXJyZW50SW5kZXhdLCBEYXRlLm5vdygpIC0gb25SZXN1bWVUaW1lLCBpc0ZpcnN0VGltZSk7XG4gIC8vIOmhtemdouWKoOi9veeKtuaAgeWfi+eCuVxuICBhbmFseXRpY3MuZWFyblB1cmNoYXNlTG9hZFN0YXR1cyhcInN1Y2Nlc3NcIik7XG4gIC8vIOajgOafpVVTRETmtLvmnJ8g55Sz6LSt5by556qX6YC76L6RXG4gIGNoZWNrVXNkZFB1cmNoYXNlVGlwKGVsZW1lbnQpO1xufVxuXG4vKipcbiAqIHRhZ+agh+etvuaYvumakO+8mjYg5paw5Lq65LiT5LqrIDkgbGF1bmNocG9vbFxuICovXG5mdW5jdGlvbiBnZXRUYWdWaXModGFnKSB7XG4gIGlmICh0YWcgPT0gNiB8fCB0YWcgPT0gOSkge1xuICAgIHJldHVybiBcInZpc2libGVcIjtcbiAgfSBlbHNlIHtcbiAgICByZXR1cm4gXCJnb25lXCI7XG4gIH1cbn1cblxuZnVuY3Rpb24gZ2V0VGFnQmcodGFnKSB7XG4gIGlmICh0YWcgPT0gNikge1xuICAgIHJldHVybiBcIkBjb2xvci9rQ29sb3JGRkU3RDVcIjtcbiAgfSBlbHNlIGlmICh0YWcgPT0gOSkge1xuICAgIHJldHVybiBcIkBjb2xvci9rQ29sb3IxQTAxNzNFNVwiO1xuICB9IGVsc2Uge1xuICAgIHJldHVybiBudWxsO1xuICB9XG59XG5cbmZ1bmN0aW9uIGdldFRhZ1RleHQodGFnLCB0YWdOYW1lKSB7XG4gIGlmICh0YWcgPT0gNikge1xuICAgIHJldHVybiAkaTE4bi5uX3NpbXBsZV9lYXJuX25ld2NvbWVyO1xuICB9IGVsc2Uge1xuICAgIHJldHVybiB0YWdOYW1lO1xuICB9XG59XG5cbmZ1bmN0aW9uIGdldFRhZ1RleHRDb2xvcih0YWcpIHtcbiAgaWYgKHRhZyA9PSBcIjZcIikge1xuICAgIHJldHVybiBcIkBjb2xvci9jb2xvcl9GRTg3MzFcIjtcbiAgfSBlbHNlIGlmICh0YWcgPT0gXCI5XCIpIHtcbiAgICByZXR1cm4gXCJAY29sb3Iva0NvbG9yTWFqb3JUaGVtZTEwMFwiO1xuICB9IGVsc2Uge1xuICAgIHJldHVybiBcIkBjb2xvci9jb2xvcl9GRTg3MzFcIjtcbiAgfVxufVxuXG5mdW5jdGlvbiBnZXRUYWdXaWR0aCh0YWcpIHtcbiAgaWYgKHRhZyA9PSBcIjlcIikge1xuICAgIHJldHVybiAxMTc7XG4gIH0gZWxzZSB7XG4gICAgcmV0dXJuIDEwMjtcbiAgfVxufVxuXG5mdW5jdGlvbiBtYXhBcHkoZWxlbWVudCkge1xuICB0cnkge1xuICAgIGlmIChlbGVtZW50Lm1hcmtldEFweVZvLm1hcmtldFBlcmtBcHkgPT0gbnVsbCB8fCBlbGVtZW50Lm1hcmtldEFweVZvLm1hcmtldFBlcmtBcHkgPT0gdW5kZWZpbmVkKSB7XG4gICAgICByZXR1cm4gZWxlbWVudC5hcHlTaG93O1xuICAgIH0gZWxzZSB7XG4gICAgICByZXR1cm4gTWF0aC5tYXgocGFyc2VGbG9hdChlbGVtZW50Lm1hcmtldEFweVZvLm1hcmtldFBlcmtBcHkpLCBwYXJzZUZsb2F0KGVsZW1lbnQuYXB5U2hvdykpO1xuICAgIH1cbiAgfSBjYXRjaCAoZSkge1xuICAgIGNvbnNvbGUuZShlKTtcbiAgICByZXR1cm4gXCIwXCI7XG4gIH1cbn1cblxuZnVuY3Rpb24gc3RhcnRDdXJyZW50Q291bnREb3duKCkge1xuICBjbGVhclRpbWVyKCk7XG4gIGludGVyY2FsID0gc2V0SW50ZXJ2YWwoY2hhbmdlQ291bnRkb3duLCAxMDAwKTtcbn1cblxuZnVuY3Rpb24gY2hhbmdlQ291bnRkb3duKCkge1xuICBmb3IgKGxldCBpID0gMDsgaSA8IGVhcm5UYWJMaXN0Lmxlbmd0aDsgaSsrKSB7XG4gICAgbGV0IGVsZW1lbnQgPSBlYXJuVGFiTGlzdFtpXTtcbiAgICAvL+W4guWcuuWMlua0u+acn1xuICAgIGlmIChlbGVtZW50LnByb2R1Y3RUeXBlID09IFwiMFwiICYmIGVsZW1lbnQuYXB5VHlwZSA9PSBcIjFcIikge1xuICAgICAgbGV0IGFweUNvdW50ZG93biA9IGVsZW1lbnQuYXB5Q291bnRkb3duIC0gKGN1cnJlbnRDb3VudCAqIDEwMDApO1xuICAgICAgY3VycmVudENvdW50ID0gY3VycmVudENvdW50ICsgMTtcbiAgICAgIGlmIChhcHlDb3VudGRvd24gPj0gMTAwMCkge1xuICAgICAgICAvL+WPquabtOaWsOWAkuiuoeaXtlxuICAgICAgICBtb2R1bGVEYXRhLmVhcm5UYWJMaXN0W2ldLnRpbWVUZXh0ID0gZm9ybWF0RGF0ZShhcHlDb3VudGRvd24pO1xuICAgICAgICBlYXJuVGFiTGlzdFtpXS50aW1lVGV4dCA9IGZvcm1hdERhdGUoYXB5Q291bnRkb3duKTtcbiAgICAgIH0gZWxzZSB7XG4gICAgICAgIC8v5Yi35paw5o6l5Y+jXG4gICAgICAgIGNsZWFyVGltZXIoKTtcbiAgICAgICAgcmVxdWVzdEZsZXhpYmxlRGV0YWlsKGZhbHNlLCB0cnVlKTtcbiAgICAgIH1cbiAgICB9XG4gIH1cblxufVxuXG5mdW5jdGlvbiBmb3JtYXREYXRlKHRpbWVzdGFtcCkge1xuICBjb25zdCBkYXRlID0gbmV3IERhdGUodGltZXN0YW1wKTtcbiAgY29uc3QgbWludXRlcyA9IChcIjBcIiArIGRhdGUuZ2V0TWludXRlcygpKS5zbGljZSgtMik7XG4gIGNvbnN0IHNlY29uZHMgPSAoXCIwXCIgKyBkYXRlLmdldFNlY29uZHMoKSkuc2xpY2UoLTIpO1xuICBpZiAodGltZXN0YW1wIDwgKDEwMDAgKiA2MCkpIHtcbiAgICByZXR1cm4gYCR7c2Vjb25kc31gO1xuICB9IGVsc2Uge1xuICAgIHJldHVybiBgJHttaW51dGVzfToke3NlY29uZHN9YDtcbiAgfVxufVxuXG5mdW5jdGlvbiBjbGVhclRpbWVyKCkge1xuICBpZiAoaW50ZXJjYWwgIT0gbnVsbCkge1xuICAgIGNsZWFySW50ZXJ2YWwoaW50ZXJjYWwpO1xuICAgIGludGVyY2FsID0gbnVsbDtcbiAgICBjdXJyZW50Q291bnQgPSAxO1xuICB9XG59XG5cbi8qKlxuICog6aG26YOodGFi55qE54K55Ye75LqL5Lu2XG4gKi9cbm1vZHVsZUV2ZW50LnNjcm9sbFRvVGFnID0gZnVuY3Rpb24gKHRhZykge1xuICBjb25zb2xlLmxvZyhgc2ltcGxlX2Vhcm5faG9tZSBzY3JvbGxUb1RhZyB0YWc9ICR7dGFnfWApO1xuICBpZiAodGFnID09IG1vZHVsZURhdGEuY3VycmVudEluZGV4KSB7XG4gICAgcmV0dXJuO1xuICB9XG4gIG1vZHVsZURhdGEuY3VycmVudEluZGV4ID0gdGFnO1xuICBtb2R1bGVEYXRhLnNjcm9sbFRvVGFnID0gdGFnO1xufTtcblxuLyoqXG4gKiB2aWV3UGFnZea7keWKqOeahOmAieS4reS6i+S7tlxuICovXG5tb2R1bGVFdmVudC5iYW5uZXJJbmRleENoYW5nZSA9IGZ1bmN0aW9uIChwYXJhbXMpIHtcbiAgY29uc29sZS5sb2coYHNpbXBsZV9lYXJuX2hvbWUgYmFubmVySW5kZXhDaGFuZ2UgcGFyYW1zPSAke3BhcmFtc30gY3VycmVudEluZGV4PSAke21vZHVsZURhdGEuY3VycmVudEluZGV4fWApO1xuICBpZiAoZWFyblRhYkxpc3QubGVuZ3RoID09IDApIHtcbiAgICByZXR1cm47XG4gIH1cbiAgZWFyblRhYkxpc3QuZm9yRWFjaCgodGFiKSA9PiB7XG4gICAgaWYgKHRhYi50YWcgPT0gcGFyYW1zKSB7XG4gICAgICAvL+mAieS4rVxuICAgICAgdGFiLmJvcmRlckNvbG9yID0gXCJAY29sb3Iva0NvbG9yTWFqb3JUaGVtZTEwMFwiO1xuICAgIH0gZWxzZSB7XG4gICAgICAvL+acqumAieS4rVxuICAgICAgdGFiLmJvcmRlckNvbG9yID0gXCJAY29sb3Iva0NvbG9yRUJFQkVCXCI7XG4gICAgfVxuICB9KTtcbiAgbW9kdWxlRGF0YS5lYXJuVGFiTGlzdCA9IGVhcm5UYWJMaXN0O1xuICBtb2R1bGVEYXRhLnNjcm9sbFRvVGFnID0gcGFyYW1zO1xuICBjdXJyZW50U2VsZWN0SW5kZXggPSBwYXJhbXM7XG4gIGxldCBlbGVtZW50ID0gbW9kdWxlRGF0YS5zbGlkZXJEYXRhW3BhcmFtc107XG4gIC8v56uL5Y2z55Sz6LSt54q25oCB5Yi35pawXG4gICRldmVudC5kZXBvc2l0LmNoZWNrQnRuU3RhdHVzKGVsZW1lbnQuc3RhdHVzLCBlbGVtZW50LmlucHV0U3RhdHVzKTtcbiAgYW5hbHl0aWNzLnBhZ2VTaG93KGVsZW1lbnQsIDAsIGZhbHNlKTtcblxuICBjaGVja1VzZGRQdXJjaGFzZVRpcChlbGVtZW50KTtcbn07XG5cbmZ1bmN0aW9uIGdldE5hdkNvbmZpZ1N0cmluZygpIHtcbiAgcmV0dXJuIHtcbiAgICAvLyAndGl0bGVLZXknOiAnbl9zdHJ1dHVyZWRfcHJvZHVjdHMnLFxuICAgIC8vICdsZWZ0Jzoge1xuICAgIC8vICAgJ2FjdGlvbic6IHtcbiAgICAvLyAgICAgJ3R5cGUnOiAnZXZhbEpTJyxcbiAgICAvLyAgICAgJ3BhcmFtZXRlcic6ICdiYWNrQ2xpY2tlZCdcbiAgICAvLyAgIH0sXG4gICAgLy8gICAnaWNvbic6ICdlZGdlX2VuZ2luZV90b3BfYmFyX2JhY2tfbm9ybWFsJ1xuICAgIC8vIH0sXG4gICAgLy8gJ2JhY2tncm91bmRDb2xvcic6ICdLQmFzZUNvbG9yQ29udGVudEJhY2tncm91bmQnXG4gIH07XG59XG5cbmFzeW5jIGZ1bmN0aW9uIGNoZWNrVXNkZFB1cmNoYXNlVGlwKGVsZW1lbnQpIHtcbiAgLy8g5b2T5YmN5biB56eN5pivVVNERCDkuJQg5piv5rS75pyf5Lqn5ZOB5pe25omN6aqM6K+BXG4gIGlmIChwYXJhbWV0ZXIuY3VycmVuY3kgPT0gXCJVU0REXCIgJiYgZWxlbWVudC5wcm9kdWN0VHlwZSA9PSBcIjBcIikge1xuICAgIC8v5aSE55CG6aaW5qyh55Sz6LSt5o+Q56S65by556qXXG4gICAgbGV0IGRpZFNob3cgPSBhd2FpdCBjb21tb24ucmVhZChcInNpbXBsZV9lYXJuXCIsIFwiZGlkU2hvd1wiKTtcbiAgICBpZiAoZGlkU2hvdyAhPSBcIjFcIikge1xuICAgICAgLy/kuYvliY3msqHmnInov4flvLnnqpdcbiAgICAgIGF3YWl0IGNvbW1vbi5zYXZlKFwic2ltcGxlX2Vhcm5cIiwgXCJkaWRTaG93XCIsIFwiMVwiKTtcbiAgICAgICRldmVudC5wdXJjaGFzZVRpcC5vcGVuRGlhbG9nKCk7XG4gICAgfVxuICB9XG59XG5cbm1vZHVsZUV2ZW50LmJhY2tDbGlja2VkID0gZnVuY3Rpb24gKCkge1xuICBhbmFseXRpY3MuYmFja0NsaWNrKClcbiAgY29tbW9uLmNvbnRhaW5lckJhY2soKTtcbn07XG5cbi8qKlxuICog6I635Y+W5b2T5YmNc2xpZGVyRGF0YeWvueW6lOe0ouW8leeahOaVsOaNrlxuICovXG5tb2R1bGVFdmVudC5nZXRDdXJyZW50RWxlbWVudCA9IGZ1bmN0aW9uIChpbmRleCkge1xuICBpZiAoaW5kZXggPCAwIHx8IGluZGV4ID49IG1vZHVsZURhdGEuc2xpZGVyRGF0YS5sZW5ndGgpIHtcbiAgICBjb25zb2xlLmxvZyhgZ2V0Q3VycmVudEVsZW1lbnQgZXJyb3IgaW5kZXg9ICR7aW5kZXh9YCk7XG4gICAgcmV0dXJuIHt9O1xuICB9XG4gIHJldHVybiBtb2R1bGVEYXRhLnNsaWRlckRhdGFbaW5kZXhdO1xufVxuXG5cbm1vZHVsZUV2ZW50LmJ1eUNvaW4gPSBmdW5jdGlvbiAoKSB7XG4gIC8v6Lez6L2s5Lmw5biBXG4gIGxldCBidXlDb2luT2JqID0geyB0eXBlOiAyLCBjdXJyZW5jeTogJGRhdGEuaG9tZS5jdXJyZW5jeSB9O1xuICBjb25zb2xlLmxvZyhgYnV5Q29pbiA6ICR7SlNPTi5zdHJpbmdpZnkoYnV5Q29pbk9iail9YCk7XG4gICRuYXRpdmVBUEkuZG91YmxlQ29pbkFiaWxpdHkoSlNPTi5zdHJpbmdpZnkoYnV5Q29pbk9iaikpO1xuICBsZXQgZWxlbWVudCA9IG1vZHVsZUV2ZW50LmdldEN1cnJlbnRFbGVtZW50KG1vZHVsZURhdGEuY3VycmVudEluZGV4KTtcbiAgYW5hbHl0aWNzLmJ1eUNsaWNrKGVsZW1lbnQpXG4gIC8v5re75Yqg5Yi35paw5pWw5o2u5qCH6K+GXG4gICRkYXRhLmhvbWUuaXNSZWZyZXNoRGF0YSA9IHRydWU7XG59XG5cbm1vZHVsZUV2ZW50LnRyYW5zZmVyID0gZnVuY3Rpb24gKCkge1xuICAvL+i3s+i9rOWIkui9rFxuICBsZXQgdHJhbnNmZXJPYmogPSB7IHR5cGU6IDIwLCBjdXJyZW5jeTogJGRhdGEuaG9tZS5jdXJyZW5jeSB9O1xuICBjb25zb2xlLmxvZyhgdHJhbnNmZXIgOiAke0pTT04uc3RyaW5naWZ5KHRyYW5zZmVyT2JqKX1gKTtcbiAgJG5hdGl2ZUFQSS5qdW1wKEpTT04uc3RyaW5naWZ5KHRyYW5zZmVyT2JqKSk7XG4gIGxldCBlbGVtZW50ID0gbW9kdWxlRXZlbnQuZ2V0Q3VycmVudEVsZW1lbnQobW9kdWxlRGF0YS5jdXJyZW50SW5kZXgpO1xuICBhbmFseXRpY3MudHJhbnNmZXJDbGljayhlbGVtZW50KVxuICAvL+a3u+WKoOWIt+aWsOaVsOaNruagh+ivhlxuICAkZGF0YS5ob21lLmlzUmVmcmVzaERhdGEgPSB0cnVlO1xufVxuXG5tb2R1bGVFdmVudC5yZWxvYWRXaXRoUGFyYW1zID0gZnVuY3Rpb24gKGpzb25QYXJhbWV0ZXJzKSB7XG4gIGNvbnNvbGUubG9nKGByZWxvYWRXaXRoUGFyYW1zIDogJHtqc29uUGFyYW1ldGVyc31gKTtcbiAgLy/luKblhaXlj4LmlbBcbiAgcGFyYW1ldGVyID0gSlNPTi5wYXJzZShqc29uUGFyYW1ldGVycyk7XG4gIC8v6K6+572u6aG26YOoaWNvblxuICBtb2R1bGVEYXRhLnRvcEljb24gPSBjb21tb24uZ2V0UE5HSWNvblVSTEJ5Q3VycmVuY3kocGFyYW1ldGVyLmN1cnJlbmN5KTtcbiAgbW9kdWxlRGF0YS50b3BUaXRsZSA9IGAke3BhcmFtZXRlci5jdXJyZW5jeX0gJHskaTE4bi5uX2tsaW5lX2RldGFpbF9lYXJuY29pbnN9YDtcbiAgLy8g6YeN5Yi35pWw5o2uXG4gIGNsZWFyVGltZXIoKTtcbiAgbW9kdWxlRGF0YS5kYXRhVmlzID0gXCJnb25lXCI7XG4gIHJlc3VtZUlzTm90Rmlyc3QgPSBmYWxzZTtcbiAgY3VycmVudFNlbGVjdEluZGV4ID0gLTEsLy/mmK/lkKbpnIDopoHpu5jorqTpgInkuK1cbiAgICBtb2R1bGVEYXRhLnNsaWRlckRhdGEgPSBbXTtcbiAgbW9kdWxlRGF0YS5lYXJuVGFiTGlzdCA9IFtdO1xuICBlYXJuVGFiTGlzdCA9IFtdO1xuICByZXF1ZXN0RmxleGlibGVEZXRhaWwodHJ1ZSk7XG59XG5cbi8vIG1vZHVsZUV2ZW50LnJlbG9hZFdpdGhQYXJhbXMoJ3tcInByb2plY3RJZFwiOlwiMTc4N1wiLFwiY3VycmVuY3lcIjpcIlVTRFRcIn0nKTtcbiIsImltcG9ydCAqIGFzIGNvbW1vbiBmcm9tIFwiLi9jb21tb25cIjtcbmltcG9ydCAqIGFzIG51bWJlciBmcm9tIFwiLi9udW1iZXJcIjtcbmltcG9ydCAqIGFzIGFuYWx5dGljcyBmcm9tIFwiLi9hbmFseXRpY3NcIjtcblxudmFyIGJ0bkVuYWJsZSA9IGZhbHNlO1xuXG5mdW5jdGlvbiBkZWZhdWx0RGF0YSgpIHtcbiAgcmV0dXJuIHtcbiAgICBidG5Db2xvcjogXCJAY29sb3Iva0NvbG9yRUJFQkVCXCIsIC8v55Sz6LSt5oyJ6ZKu6aKc6ImyXG4gICAgYnRuVGl0bGVDb2xvcjogXCJAY29sb3Iva0NvbG9yVGhyZWVMZXZlbFRleHRcIiwgLy8g55Sz6LSt5paH5a2X6aKc6ImyXG4gICAgaHVvYmlTZWxlY3RlZDogZmFsc2UsXG4gICAgaHVvYmlBZ3JlZUltYWdlOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9saXZlX3JlZHBhY2tldF91bnNlbGVjdFwiLFxuICAgIHJpY2hUZXh0RGF0YTogXCJcIixcbiAgfTtcbn1cblxuY29uc3QgeyBtb2R1bGVEYXRhLCBtb2R1bGVFdmVudCB9ID0gY29tbW9uLm1vZHVsZURlZmluZShcImRlcG9zaXRcIiwgZGVmYXVsdERhdGEsIHt9KTtcblxuLy8gaHVvYmnljY/orq5cbm1vZHVsZUV2ZW50Lmh1b2JpU2VsZWN0ZWQgPSBmdW5jdGlvbiAoKSB7XG4gIGlmIChtb2R1bGVEYXRhLmh1b2JpU2VsZWN0ZWQpIHtcbiAgICBtb2R1bGVEYXRhLmh1b2JpU2VsZWN0ZWQgPSBmYWxzZTtcbiAgICBtb2R1bGVEYXRhLmh1b2JpQWdyZWVJbWFnZSA9IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX2xpdmVfcmVkcGFja2V0X3Vuc2VsZWN0XCI7XG4gICAgbW9kdWxlRGF0YS5jb25maXJtQnRuQ29sb3IgPSBcIkBjb2xvci9lQnV0dG9uVW5lbmFibGVkQmdDb2xvclwiO1xuICB9IGVsc2Uge1xuICAgIG1vZHVsZURhdGEuaHVvYmlTZWxlY3RlZCA9IHRydWU7XG4gICAgbW9kdWxlRGF0YS5odW9iaUFncmVlSW1hZ2UgPSBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9saXZlX3JlZHBhY2tldF9zZWxlY3RcIjtcbiAgICBtb2R1bGVEYXRhLmNvbmZpcm1CdG5Db2xvciA9IFwiQGNvbG9yL2tDb2xvck1ham9yVGhlbWUxMDBcIjtcbiAgfVxuICBsZXQgZWxlbWVudCA9ICRldmVudC5ob21lLmdldEN1cnJlbnRFbGVtZW50KCRkYXRhLmhvbWUuY3VycmVudEluZGV4KTtcbiAgY29uc29sZS5sb2coYCR7dGFnfSBodW9iaVNlbGVjdGVkIGlucHV0U3RhdHVzPSAke2VsZW1lbnQuaW5wdXRTdGF0dXN9YCk7XG4gIGNoZWNrQnRuU3RhdHVzKGVsZW1lbnQuc3RhdHVzLCBlbGVtZW50LmlucHV0U3RhdHVzKTtcbn1cblxuZnVuY3Rpb24gY2hlY2tCdG5TdGF0dXMocHJvamVjdFN0YXR1cywgaW5wdXRTdGF0dXMgPSBmYWxzZSkge1xuICBjb25zb2xlLmxvZyhgJHt0YWd9IGNoZWNrQnRuU3RhdHVzIHByb2plY3RTdGF0dXM9ICR7cHJvamVjdFN0YXR1c30gaW5wdXRTdGF0dXM9ICR7aW5wdXRTdGF0dXN9YCk7XG4gIHN3aXRjaCAocHJvamVjdFN0YXR1cykge1xuICAgIGNhc2UgMDpcbiAgICAgIC8v5pyq5byA5aeLXG4gICAgICAkZGF0YS5ob21lLnN1Ym1pdFRleHQgPSAkaTE4bi5uX3NpbXBsZV9lYXJuX25vdF9zdGFydGVkXG4gICAgICBicmVhaztcbiAgICBjYXNlIDE6XG4gICAgICAvL+eUs+i0reS4rVxuICAgICAgJGRhdGEuaG9tZS5zdWJtaXRUZXh0ID0gJGkxOG4ubl9iYWxhbmNlX21pbmluZ19kZXBvc2l0XG4gICAgICBicmVhaztcbiAgICBjYXNlIDI6XG4gICAgICAvL+W3suWLn+a7oVxuICAgICAgJGRhdGEuaG9tZS5zdWJtaXRUZXh0ID0gJGkxOG4ubl9zaW1wbGVfZWFybl9mdWxseV9zdWJzY3JpYmVkXG4gICAgICBicmVhaztcbiAgICBjYXNlIDM6XG4gICAgICAvL+W3sue7k+adn1xuICAgICAgJGRhdGEuaG9tZS5zdWJtaXRUZXh0ID0gJGkxOG4ubl9zaW1wbGVfZWFybl9lbmRlZFxuICAgICAgYnJlYWs7XG4gIH1cbiAgaWYgKHByb2plY3RTdGF0dXMgPT0gMSAmJiBpbnB1dFN0YXR1cyAmJiBtb2R1bGVEYXRhLmh1b2JpU2VsZWN0ZWQpIHtcbiAgICBidG5FbmFibGUgPSB0cnVlO1xuICAgIG1vZHVsZURhdGEuYnRuQ29sb3IgPSBcIkBjb2xvci9rQ29sb3JNYWpvclRoZW1lMTAwXCI7XG4gICAgbW9kdWxlRGF0YS5idG5UaXRsZUNvbG9yID0gXCJAY29sb3IvS0Jhc2VUZXh0Q29sb3JcIjtcbiAgICByZXR1cm4gdHJ1ZTtcbiAgfSBlbHNlIHtcbiAgICBidG5FbmFibGUgPSBmYWxzZTtcbiAgICBtb2R1bGVEYXRhLmJ0bkNvbG9yID0gXCJAY29sb3Iva0NvbG9yRUJFQkVCXCI7XG4gICAgbW9kdWxlRGF0YS5idG5UaXRsZUNvbG9yID0gXCJAY29sb3Iva0NvbG9yVGhyZWVMZXZlbFRleHRcIjtcbiAgICByZXR1cm4gZmFsc2U7XG4gIH1cbn1cblxuLy8g55Sz6LSt54K55Ye7XG5tb2R1bGVFdmVudC5zdWJtaXRDbGlja2VkID0gZnVuY3Rpb24gKCkge1xuICBpZiAoIWJ0bkVuYWJsZSkge1xuICAgIHJldHVybjtcbiAgfVxuICBsZXQgZWxlbWVudCA9ICRldmVudC5ob21lLmdldEN1cnJlbnRFbGVtZW50KCRkYXRhLmhvbWUuY3VycmVudEluZGV4KTtcbiAgZWxlbWVudC5zdWJPbkZvY3VzID0gZmFsc2U7XG4gIGxldCBjb25maXJtTGlzdCA9IG51bGw7XG4gIGxldCBpbm5lckxpc3QgPSBudWxsO1xuICAvL+WMuuWIhuWumuacn+i/mOaYr+a0u+acnyAwIOa0u+acnyAxIOWumuacnyAyIOWkp+minea0u+acn1xuICBpZiAoZWxlbWVudC5wcm9kdWN0VHlwZSA9PSAwKSB7XG4gICAgaW5uZXJMaXN0ID0gZ2V0RmxleGlibGVDb25maXJtSW5uZXJMaXN0KGVsZW1lbnQpO1xuICAgIGNvbmZpcm1MaXN0ID0gZ2V0RmxleGlibGVDb25maXJtTGlzdChpbm5lckxpc3QsIGVsZW1lbnQubVN1YklucHV0KTtcbiAgfSBlbHNlIGlmIChlbGVtZW50LnByb2R1Y3RUeXBlID09IDEpIHtcbiAgICBpbm5lckxpc3QgPSBnZXRGaXhlZENvbmZpcm1Jbm5lckxpc3QoZWxlbWVudCk7XG4gICAgY29uZmlybUxpc3QgPSBnZXRGaXhlZENvbmZpcm1MaXN0KGlubmVyTGlzdCwgZWxlbWVudC5tU3ViSW5wdXQsIGVsZW1lbnQpO1xuICB9IGVsc2Uge1xuICAgIGNvbnNvbGUubG9nKFwic3VibWl0IGVycm9yIHR5cGUgXCIsIGVsZW1lbnQucHJvZHVjdFR5cGUpO1xuICB9XG4gICRldmVudC5kaWFsb2cuc2hvd0NvbmZpcm1EaWFsb2coY29uZmlybUxpc3QsIGlubmVyTGlzdCwgZWxlbWVudCk7XG4gIGFuYWx5dGljcy5zdWJzY3JpYmVCdXR0b25DbGljayhlbGVtZW50KTtcbn1cblxuLy8g5o+Q5LqkXG5tb2R1bGVFdmVudC5jb25maXJtRGlhbG9nQmxvY2sgPSBhc3luYyBmdW5jdGlvbiAoYXNzZXRTb3VyY2UpIHtcbiAgbGV0IHBhcnNlU291cmNlID0gcGFyc2VJbnQoYXNzZXRTb3VyY2UpO1xuICBjb25zb2xlLmxvZyhgJHt0YWd9IGNvbmZpcm1EaWFsb2dCbG9jayBjcnJlbnRJbmRleD0gJHskZGF0YS5ob21lLmN1cnJlbnRJbmRleH0gYXNzZXRTb3VyY2UgPSAke3BhcnNlU291cmNlfWApO1xuICBsZXQgZWxlbWVudCA9ICRldmVudC5ob21lLmdldEN1cnJlbnRFbGVtZW50KCRkYXRhLmhvbWUuY3VycmVudEluZGV4KTtcbiAgYW5hbHl0aWNzLmNvbmZpcm1CdXR0b25DbGljayhlbGVtZW50KTtcbiAgbGV0IGF1dG9FYXJuID0gZ2V0QXV0b0Vhcm5TdGF0dXMoZWxlbWVudCk7XG4gIGNvbnNvbGUubG9nKGAke3RhZ30gY29uZmlybURpYWxvZ0Jsb2NrIGF1dG9FYXJuPSAke2F1dG9FYXJufWApO1xuICBsZXQge2NvdXBvbklkLCBjb3Vwb25TaWdufSA9IGdldENvdXBvblN0YXR1cyhlbGVtZW50KTtcbiAgY29uc3QgYWRkUGFyYW1zID0ge1xuICAgIHZUb2tlbjogY29tbW9uLmNvbW1vbkRhdGEudlRva2VuLFxuICAgIG9sZFZUb2tlbjogY29tbW9uLmNvbW1vbkRhdGEub2xkVlRva2VuLFxuICAgIGlkOiBlbGVtZW50LnByb2plY3RJZCxcbiAgICBhbW91bnQ6IGVsZW1lbnQubVN1YklucHV0LFxuICAgIGJhbGFuY2VBdXRvRGlnZ2luZ1N0YXR1czogYXV0b0Vhcm4sXG4gICAgY291cG9uSWQ6IGNvdXBvbklkLFxuICAgIGNvdXBvblNpZ246IGNvdXBvblNpZ24sXG4gICAgYW10U291cmNlOiBwYXJzZVNvdXJjZSxcbiAgfVxuICBjb25zb2xlLmxvZyhgJHt0YWd9IGNvbmZpcm1EaWFsb2dCbG9jayBjcnJlbnRJbmRleD0gJHtKU09OLnN0cmluZ2lmeShhZGRQYXJhbXMpfWApO1xuICBjb21tb24uc2hvd0xvYWRpbmcodHJ1ZSk7XG4gIGNvbnN0IGRhdGEgPSBhd2FpdCBvcmRlckFkZFJlcXVlc3QoJ3YxL3NhdmluZy9taW5pbmcvb3JkZXIvZGVtYW5kL2FkZCcsIGFkZFBhcmFtcywgMSwgMCwgeyBcIkNvbnRlbnQtVHlwZVwiOiBcImFwcGxpY2F0aW9uL2pzb25cIiB9KTtcbiAgY29tbW9uLnNob3dMb2FkaW5nKGZhbHNlKTtcbiAgaWYgKGRhdGEgIT0gbnVsbCkge1xuICAgIGxldCByZXN1bHRTdHIgPSBgJHtkYXRhLmFtb3VudH0gJHskZGF0YS5ob21lLmN1cnJlbmN5fWA7XG4gICAgbGV0IHVybCA9IGBob2xpZ2VpdDovL29wZW4vdjE/bG9naW49MSZ1cmw9aWh1b2JpZ2xvYmFsOi8vbS5oYmcuY29tL2VkZ2VlbmdpbmUvY29udGFpbmVyP3NjZW5lPXNpbXBsZWVhcm4mcm9vdE5hbWU9cmVzdWx0Jm5hdkNvbmZpZz0mcmVzdWx0U3RyPSR7cmVzdWx0U3RyfSZvcmRlcklkPSR7ZGF0YS5vcmRlcklkfSZyZWNvcmRJZD0ke2RhdGEucmVjb3JkSWR9JnByb2R1Y3RUeXBlPSR7ZWxlbWVudC5wcm9kdWN0VHlwZX0mYXB5VHlwZT0ke2VsZW1lbnQuYXB5VHlwZX1gO1xuICAgIGNvbW1vbi5vcGVuVVJMKHVybCk7XG4gICAgJGV2ZW50LmRpYWxvZy5jbG9zZUNvbmZpcm1EaWFsb2coKTtcbiAgICAvL+a3u+WKoOWIt+aWsOaVsOaNruagh+ivhlxuICAgICRkYXRhLmhvbWUuaXNSZWZyZXNoRGF0YSA9IHRydWU7XG4gIH1cbn1cblxuLy/lj5HpgIHor7fmsYJcbmFzeW5jIGZ1bmN0aW9uIG9yZGVyQWRkUmVxdWVzdChwYXRoLCBwYXJhbXMgPSB7fSwgbWV0aG9kID0gMCwgaG9zdFR5cGUgPSAwLCBoZWFkZXIgPSB7fSkge1xuICBjb25zb2xlLmxvZyhgb3JkZXJBZGRSZXF1ZXN0JHtwYXRofSwgcGFyYW1zOiR7SlNPTi5zdHJpbmdpZnkocGFyYW1zKX1gKTtcblxuICBoZWFkZXJbXCJIQi1DT1VOVFJZLUlEXCJdID0gY29tbW9uLmNvbW1vbkRhdGEuY291bnRyeUlkO1xuXG4gIGNvbnN0IHBhcmFtID0ge1xuICAgIHBhdGgsXG4gICAgbWV0aG9kLFxuICAgIGhvc3RUeXBlLFxuICAgIGhlYWRlcixcbiAgICBwYXJhbXMsXG4gIH07XG4gIHRyeSB7XG4gICAgdmFyIHJlc3BvbnNlU3RyaW5nID0gYXdhaXQgJG5hdGl2ZUFQSS5yZXF1ZXN0KEpTT04uc3RyaW5naWZ5KHBhcmFtKSk7XG4gICAgLy90b2RvIOmSiOWvueS4jeWQjGtleVxuICAgIHZhciByZXNwb25zZSA9IEpTT04ucGFyc2UocmVzcG9uc2VTdHJpbmcsKTtcbiAgICB2YXIgeyBjb2RlLCBkYXRhIH0gPSByZXNwb25zZTtcbiAgICBpZiAoY29kZSA9PSAyMDAgfHwgcmVzcG9uc2Uuc3RhdHVzID09IFwib2tcIikge1xuICAgICAgY29uc29sZS5sb2coYG9yZGVyQWRkUmVxdWVzdCAke3BhdGh9IGRvbmVgKTtcbiAgICAgIHJldHVybiBkYXRhO1xuICAgIH0gZWxzZSBpZiAoY29kZSA9PSA0MDAwMikge1xuICAgICAgLy8ga3ljIOiupOivgeacqumAmui/h1xuICAgICAgJGV2ZW50Lmt5Y0RpYWxvZy5vcGVuS3ljRmFpbGVkRGlhbG9nKCk7XG4gICAgfSBlbHNlIGlmIChjb2RlID09IDQwMDIwKSB7XG4gICAgICAvLyBreWMg562J57qn5LiN5aSfXG4gICAgICBsZXQgZWxlbWVudCA9ICRldmVudC5ob21lLmdldEN1cnJlbnRFbGVtZW50KCRkYXRhLmhvbWUuY3VycmVudEluZGV4KTtcbiAgICAgICRldmVudC5reWNEaWFsb2cub3Blbkt5Y0xldmVsRGlhbG9nKGVsZW1lbnQua3ljTGltaXRVc2VyVmlld0xldmVsID8gZWxlbWVudC5reWNMaW1pdFVzZXJWaWV3TGV2ZWwgOiAnJyk7XG4gICAgfSBlbHNlIHtcbiAgICAgIGNvbnNvbGUubG9nKGBvcmRlckFkZFJlcXVlc3QgZmFpbGVkLCBjb2RlPSR7Y29kZX1gKTtcbiAgICAgIGxldCBtZXNzYWdlID0gcmVzcG9uc2UubWVzc2FnZTtcbiAgICAgIGlmIChtZXRob2QgIT0gMCAmJiBtZXNzYWdlKSB7XG4gICAgICAgIGNvbW1vbi5zaG93VG9hc3QobWVzc2FnZSk7XG4gICAgICB9XG4gICAgICByZXR1cm4gbnVsbDtcbiAgICB9XG4gIH0gY2F0Y2ggKGUpIHtcbiAgICBjb25zb2xlLmxvZyhgb3JkZXJBZGRSZXF1ZXN0IGVycm9yLCBlcnJvcj0ke2V9YCk7XG4gICAgcmV0dXJuIG51bGw7XG4gIH1cbn1cblxubW9kdWxlRXZlbnQuY2hlY2tCdG5TdGF0dXMgPSBjaGVja0J0blN0YXR1cztcblxuY29uc3QgdGFnID0gXCJzaW1wbGVfZWFyblwiO1xuZnVuY3Rpb24gZ2V0RmxleGlibGVDb25maXJtSW5uZXJMaXN0KGVsZW1lbnQpIHtcbiAgbGV0IGlubmVyTGlzdCA9IFtdO1xuICBsZXQgbVN1YklucHV0ID0gcGFyc2VGbG9hdChlbGVtZW50Lm1TdWJJbnB1dCk7XG4gIGxldCBhcHlUeXBlID0gZWxlbWVudC5hcHlUeXBlO1xuICBjb25zb2xlLmxvZyhgJHt0YWd9IGdldEZsZXhpYmxlQ29uZmlybUlubmVyTGlzdCBhcHlUeXBlPSAke2FweVR5cGV9YCk7XG4gIGlmIChhcHlUeXBlID09IDApIHtcbiAgICAvL+WbuuWumiDmi7/pmLbmoq/liKnnjodcbiAgICBsZXQgbGFkZGVyTGlzdCA9IGVsZW1lbnQubGFkZGVyTGlzdDtcbiAgICBjb25zb2xlLmxvZyhgJHt0YWd9IGdldEZsZXhpYmxlQ29uZmlybUlubmVyTGlzdCBsYWRkZXJMaXN0PSAke0pTT04uc3RyaW5naWZ5KGxhZGRlckxpc3QpfWApO1xuICAgIGxldCBpdGVtID0ge307XG4gICAgbGFkZGVyTGlzdC5mb3JFYWNoKChsYWRkZXIpID0+IHtcbiAgICAgIGlmIChsYWRkZXIudHlwZSAhPSAxKSB7XG4gICAgICAgIHJldHVybjtcbiAgICAgIH1cbiAgICAgIGl0ZW0gPSB7IHR5cGU6IFwiMVwiIH07XG4gICAgICAvKipcbiAgICAgICAqIDAgICAgLSAxMDAwXG4gICAgICAgKiAxMDAwIC0gMjAwMFxuICAgICAgICogMjAwMCAtIDBcbiAgICAgICAqXG4gICAgICAgKiAxMDAwIC0gMFxuICAgICAgICovXG4gICAgICBsZXQgYW1vdW50ID0gMDtcbiAgICAgIGlmIChtU3ViSW5wdXQgPj0gbGFkZGVyLmFtb3VudFN0YXJ0KSB7XG4gICAgICAgIGlmIChsYWRkZXIuYW1vdW50RW5kID09IDApIHtcbiAgICAgICAgICBhbW91bnQgPSBtU3ViSW5wdXQgLSBsYWRkZXIuYW1vdW50U3RhcnQ7XG4gICAgICAgIH0gZWxzZSBpZiAobVN1YklucHV0ID49IGxhZGRlci5hbW91bnRFbmQpIHtcbiAgICAgICAgICBhbW91bnQgPSBsYWRkZXIuYW1vdW50RW5kIC0gbGFkZGVyLmFtb3VudFN0YXJ0O1xuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgIGFtb3VudCA9IG1TdWJJbnB1dCAtIGxhZGRlci5hbW91bnRTdGFydDtcbiAgICAgICAgfVxuICAgICAgfSBlbHNlIHtcbiAgICAgICAgYW1vdW50ID0gMDtcbiAgICAgIH1cbiAgICAgIGNvbnNvbGUubG9nKGAke3RhZ30gZ2V0RmxleGlibGVDb25maXJtSW5uZXJMaXN0IGxhZGRlckxpc3QgYW1vdW50PSAke2Ftb3VudH1gKTtcbiAgICAgIGlmIChhbW91bnQgPiAwKSB7XG4gICAgICAgIGl0ZW0uYW1vdW50ID0gYCR7YW1vdW50fSAkeyRkYXRhLmhvbWUuY3VycmVuY3l9YDtcbiAgICAgICAgaXRlbS5yYXRlID0gYEFQWSAke2NvbW1vbi5mb3JtYXRQcmVjaXNpb24obnVtYmVyLm11bHRpcGx5KGxhZGRlci5yYXRlLCAxMDApLCAyKX0lYDtcbiAgICAgICAgY29uc29sZS5sb2coYCR7dGFnfSBnZXRGbGV4aWJsZUNvbmZpcm1Jbm5lckxpc3QgbGFkZGVyTGlzdCBpdGVtPSAke0pTT04uc3RyaW5naWZ5KGl0ZW0pfWApO1xuICAgICAgICBpbm5lckxpc3QucHVzaChpdGVtKTtcbiAgICAgIH1cbiAgICB9KTtcbiAgfSBlbHNlIGlmIChhcHlUeXBlID09IDEpIHtcbiAgICAvL+W4guWcuuWMliDmi7/mlLbnm4rmpoLop4gg5Y+v6IO95pyJ5bmz5Y+w6KGl6LS0XG4gICAgbGV0IHByb2ZpdExpc3QgPSBlbGVtZW50LnByb2ZpdExpc3Q7XG4gICAgY29uc29sZS5sb2coYCR7dGFnfSBnZXRGbGV4aWJsZUNvbmZpcm1Jbm5lckxpc3QgcHJvZml0TGlzdD0gJHtKU09OLnN0cmluZ2lmeShwcm9maXRMaXN0KX1gKTtcbiAgICBsZXQgaXRlbSA9IHt9O1xuICAgIHByb2ZpdExpc3QuZm9yRWFjaChwcm9maXQgPT4ge1xuICAgICAgaWYgKHByb2ZpdC50eXBlICE9IDEpIHtcbiAgICAgICAgcmV0dXJuO1xuICAgICAgfVxuICAgICAgaXRlbSA9IHsgdHlwZTogXCIxXCIgfTtcbiAgICAgIGlmIChwcm9maXQucGVya1ZpcyA9PSAndmlzaWJsZScpIHtcbiAgICAgICAgaXRlbS5yYXRlID0gJGkxOG4uJGludGVyY2VwdC5uX3NpbXBsZV9lYXJuX3BlcmtfYXB5KGAke3Byb2ZpdC5yYXRlfWApO1xuICAgICAgfSBlbHNlIHtcbiAgICAgICAgaXRlbS5yYXRlID0gYEFQWSAke3Byb2ZpdC5yYXRlfWA7XG4gICAgICB9XG4gICAgICBpdGVtLmFtb3VudCA9IHByb2ZpdC50aXRsZTtcbiAgICAgIGNvbnNvbGUubG9nKGAke3RhZ30gZ2V0RmxleGlibGVDb25maXJtSW5uZXJMaXN0IHByb2ZpdExpc3QgaXRlbT0gJHtKU09OLnN0cmluZ2lmeShpdGVtKX1gKTtcbiAgICAgIGlubmVyTGlzdC5wdXNoKGl0ZW0pO1xuICAgIH0pO1xuICB9IGVsc2Uge1xuICAgIGNvbnNvbGUubG9nKGAke3RhZ30gZ2V0RmxleGlibGVDb25maXJtSW5uZXJMaXN0IGVycm9yICR7YXB5VHlwZX0gbmVlZCBoYW5kbGVgKTtcbiAgfVxuICAvL+WKoOaBr+WIuO+8jOWmguaenOi3qOi2iuS6huS4pOS4qumYtuaute+8jOWwsemcgOimgeaPkuWFpeS4pOS4quWcsOaWuVxuICBsZXQgY291cG9uSW5kZXggPSBlbGVtZW50LmNvdXBvbkxpc3REYXRhLmNvdXBvbkluZGV4O1xuICBjb25zb2xlLmxvZyhgJHt0YWd9IGdldEZsZXhpYmxlQ29uZmlybUlubmVyTGlzdCBtU3ViSW5wdXQ9ICR7bVN1YklucHV0fSBjb3Vwb25JbmRleD0gJHtjb3Vwb25JbmRleH1gKTtcbiAgaWYgKGNvdXBvbkluZGV4ICE9IHVuZGVmaW5lZCAmJiBjb3Vwb25JbmRleCAhPSAtMSkge1xuICAgIGxldCBjb3Vwb25MaXN0ID0gZWxlbWVudC5jb3Vwb25MaXN0RGF0YS5pdGVtcztcbiAgICBsZXQgY291cG9uSXRlbSA9IGNvdXBvbkxpc3RbY291cG9uSW5kZXhdO1xuICAgIGNvbnNvbGUubG9nKFxuICAgICAgYCR7dGFnfSDliqDmga/liLggY291cG9uSXRlbT0gJHtjb3Vwb25JdGVtLmNvdXBvbkRvd25MaW1pdH3vvZ4ke2NvdXBvbkl0ZW0uY291cG9uVXBMaW1pdH0gJHtjb3Vwb25JdGVtLmFweX1gXG4gICAgKTtcbiAgICAvL+WIpOaWreS4i+mZkFxuICAgIGlmIChtU3ViSW5wdXQgPj0gY291cG9uSXRlbS5jb3Vwb25Eb3duTGltaXQpIHtcbiAgICAgIGxldCBhbW91bnROdW0gPSBNYXRoLm1pbihjb3Vwb25JdGVtLmNvdXBvblVwTGltaXQsIG1TdWJJbnB1dCk7XG4gICAgICBsZXQgY3VySW5kZXggPSAwO1xuICAgICAgd2hpbGUgKGFtb3VudE51bSA+IDAgJiYgY3VySW5kZXggPCBpbm5lckxpc3QubGVuZ3RoKSB7XG4gICAgICAgIGxldCBpdGVtID0geyB0eXBlOiBcIjJcIiB9O1xuICAgICAgICAvL2Ftb3VudE51bSDlkowg5a+55bqU6Zi25q6155qE6YeR6aKd5q+U6L6DXG4gICAgICAgIGxldCBjdXJBbW91bnQgPSBjb252ZXJ0TnVtYmVyKGlubmVyTGlzdFtjdXJJbmRleF0uYW1vdW50LCBmYWxzZSk7XG4gICAgICAgIGlmIChhbW91bnROdW0gPiBjdXJBbW91bnQpIHtcbiAgICAgICAgICBpdGVtLmFtb3VudCA9IGAke2NvbW1vbi5yZW1vdmVFeHRyYVplcm9zKGNvbW1vbi5mb3JtYXRQcmVjaXNpb24oY3VyQW1vdW50LCA4KSl9ICR7JGRhdGEuaG9tZS5jdXJyZW5jeX1gO1xuICAgICAgICAgIGFtb3VudE51bSAtPSBjdXJBbW91bnQ7XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgaXRlbS5hbW91bnQgPSBgJHtjb21tb24ucmVtb3ZlRXh0cmFaZXJvcyhjb21tb24uZm9ybWF0UHJlY2lzaW9uKGFtb3VudE51bSwgOCkpfSAkeyRkYXRhLmhvbWUuY3VycmVuY3l9YDtcbiAgICAgICAgICBhbW91bnROdW0gLT0gYW1vdW50TnVtO1xuICAgICAgICB9XG4gICAgICAgIGl0ZW0ucmF0ZSA9IGNvbW1vbi5hZGFwdGVyUGVyY2VudEZsYWcoXG4gICAgICAgICAgJGkxOG4uJGludGVyY2VwdC5uX3NpbXBsZV9lYXJuX2NvdXBvbl9jb25maXJtKFxuICAgICAgICAgICAgYCR7Y291cG9uSXRlbS5jb3Vwb25UZXJtfWAsXG4gICAgICAgICAgICBgJHtjb21tb24uZm9ybWF0UHJlY2lzaW9uKG51bWJlci5tdWx0aXBseShjb3Vwb25JdGVtLmFweSwgMTAwKSwgMil9YFxuICAgICAgICAgIClcbiAgICAgICAgKTtcbiAgICAgICAgY29uc29sZS5sb2coYCR7dGFnfSDliqDmga/liLggJHtKU09OLnN0cmluZ2lmeShpdGVtKX1gKTtcbiAgICAgICAgaW5uZXJMaXN0LnNwbGljZShjdXJJbmRleCArIDEsIDAsIGl0ZW0pO1xuICAgICAgICBjdXJJbmRleCArPSAyO1xuICAgICAgfVxuICAgIH1cbiAgfVxuICBjb25zb2xlLmxvZyhgJHt0YWd9IGdldEZsZXhpYmxlQ29uZmlybUlubmVyTGlzdCBpbm5lckxpc3Q9ICR7SlNPTi5zdHJpbmdpZnkoaW5uZXJMaXN0KX1gKTtcbiAgcmV0dXJuIGlubmVyTGlzdDtcbn1cblxuZnVuY3Rpb24gZ2V0Rml4ZWRDb25maXJtSW5uZXJMaXN0KGVsZW1lbnQpIHtcbiAgbGV0IGlubmVyTGlzdCA9IFtdO1xuICBsZXQgbVN1YklucHV0ID0gcGFyc2VGbG9hdChlbGVtZW50Lm1TdWJJbnB1dCk7XG4gIGxldCBjb3Vwb25JbmRleCA9IGVsZW1lbnQuY291cG9uTGlzdERhdGEuY291cG9uSW5kZXg7XG4gIGNvbnNvbGUubG9nKGAke3RhZ30gZ2V0Rml4ZWRDb25maXJtSW5uZXJMaXN0IG1TdWJJbnB1dD0gJHttU3ViSW5wdXR9IGNvdXBvbkluZGV4PSAke2NvdXBvbkluZGV4fWApO1xuICBsZXQgaXRlbSA9IHsgdHlwZTogXCIxXCIgfTtcbiAgaXRlbS5hbW91bnQgPSBgJHtjb21tb24ucmVtb3ZlRXh0cmFaZXJvcyhjb21tb24uZm9ybWF0UHJlY2lzaW9uKG1TdWJJbnB1dCwgOCkpfSAkeyRkYXRhLmhvbWUuY3VycmVuY3l9YDtcbiAgaXRlbS5yYXRlID0gYEFQWSAke2NvbW1vbi5mb3JtYXRQcmVjaXNpb24obnVtYmVyLm11bHRpcGx5KGVsZW1lbnQueWVhclJhdGUsIDEwMCksIDIpfSVgO1xuICBjb25zb2xlLmxvZyhgJHt0YWd9IGdldEZpeGVkQ29uZmlybUlubmVyTGlzdCBpdGVtMT0gJHtKU09OLnN0cmluZ2lmeShpdGVtKX1gKTtcbiAgaW5uZXJMaXN0LnB1c2goaXRlbSk7XG4gIC8v5Yqg5oGv5Yi4XG4gIGlmIChjb3Vwb25JbmRleCAhPSB1bmRlZmluZWQgJiYgY291cG9uSW5kZXggIT0gLTEpIHtcbiAgICBsZXQgY291cG9uTGlzdCA9IGVsZW1lbnQuY291cG9uTGlzdERhdGEuaXRlbXM7XG4gICAgbGV0IGNvdXBvbkl0ZW0gPSBjb3Vwb25MaXN0W2NvdXBvbkluZGV4XTtcbiAgICBjb25zb2xlLmxvZyhgJHt0YWd9IGdldEZpeGVkQ29uZmlybUlubmVyTGlzdCBjb3Vwb25JdGVtPSAke2NvdXBvbkl0ZW0uY291cG9uVXBMaW1pdH0gJHtjb3Vwb25JdGVtLmFweX1gKTtcbiAgICAvL+WIpOaWreS4i+mZkFxuICAgIGlmIChtU3ViSW5wdXQgPj0gY291cG9uSXRlbS5jb3Vwb25Eb3duTGltaXQpIHtcbiAgICAgIGl0ZW0gPSB7IHR5cGU6IFwiMlwiIH07XG4gICAgICBsZXQgYW1vdW50TnVtID0gTWF0aC5taW4oY291cG9uSXRlbS5jb3Vwb25VcExpbWl0LCBtU3ViSW5wdXQpO1xuICAgICAgaXRlbS5hbW91bnQgPSBgJHtjb21tb24ucmVtb3ZlRXh0cmFaZXJvcyhjb21tb24uZm9ybWF0UHJlY2lzaW9uKGFtb3VudE51bSwgOCkpfSAkeyRkYXRhLmhvbWUuY3VycmVuY3l9YDtcbiAgICAgIGl0ZW0ucmF0ZSA9IGNvbW1vbi5hZGFwdGVyUGVyY2VudEZsYWcoXG4gICAgICAgICRpMThuLiRpbnRlcmNlcHQubl9zaW1wbGVfZWFybl9jb3Vwb25fY29uZmlybShcbiAgICAgICAgICBgJHtjb3Vwb25JdGVtLmNvdXBvblRlcm19YCxcbiAgICAgICAgICBgJHtjb21tb24uZm9ybWF0UHJlY2lzaW9uKG51bWJlci5tdWx0aXBseShjb3Vwb25JdGVtLmFweSwgMTAwKSwgMil9YFxuICAgICAgICApXG4gICAgICApO1xuICAgICAgY29uc29sZS5sb2coYCR7dGFnfSBnZXRGaXhlZENvbmZpcm1Jbm5lckxpc3QgaXRlbT0gJHtKU09OLnN0cmluZ2lmeShpdGVtKX1gKTtcbiAgICAgIGlubmVyTGlzdC5zcGxpY2UoMSwgMCwgaXRlbSk7XG4gICAgfVxuICB9XG4gIHJldHVybiBpbm5lckxpc3Q7XG59XG5cbmZ1bmN0aW9uIGdldEZsZXhpYmxlQ29uZmlybUxpc3QoaW5uZXJMaXN0LCBtU3ViSW5wdXQpIHtcbiAgbGV0IGFweSA9IGdldENvbXByZWhlbnNpdmVBcHkoaW5uZXJMaXN0LCBtU3ViSW5wdXQpO1xuICBsZXQgY29uZmlybUxpc3QgPSBbXG4gICAgLy8geyB0eXBlOiBcIm5vcm1hbFwiLCB0aXRsZTogJGkxOG4ubl9hc3NldF9zdWJzY3JpYmVfbnVtYmVyLCB2YWx1ZTogYCR7bVN1YklucHV0fSAkeyRkYXRhLmhvbWUuY3VycmVuY3l9YCB9LFxuICAgIHsgdHlwZTogXCJub3JtYWxcIiwgdGl0bGU6ICRpMThuLm5fbWluaW5nX3JhbnNvbV93YXksIHZhbHVlOiAkaTE4bi5uX3NpbXBsZV9lYXJuX3JlZGVlbV9hbnlfdGltZSB9LFxuICAgIHsgdHlwZTogXCJub3JtYWxcIiwgdGl0bGU6ICRpMThuLm5fc2ltcGxlX2Vhcm5fY29tcG9zaXRlX2FweSwgdmFsdWU6IGAke2FweX1gIH0sXG4gIF07XG4gIHJldHVybiBjb25maXJtTGlzdDtcbn1cblxuZnVuY3Rpb24gZ2V0Rml4ZWRDb25maXJtTGlzdChpbm5lckxpc3QsIG1TdWJJbnB1dCwgZWxlbWVudCkge1xuICBsZXQgYXB5ID0gZ2V0Q29tcHJlaGVuc2l2ZUFweShpbm5lckxpc3QsIG1TdWJJbnB1dCk7XG4gIGNvbnN0IGV4cGlyZURhdGUgPSAkaTE4bi4kaW50ZXJjZXB0Lm5fc2ltcGxlX2Vhcm5fYmVjb21lX2R1ZShgJHtlbGVtZW50LnRlcm19YCwgYCR7ZWxlbWVudC5kdEV4cGlyZWR9YCk7XG4gIGxldCBjb25maXJtTGlzdCA9IFtcbiAgICAvLyB7IHR5cGU6IFwibm9ybWFsXCIsIHRpdGxlOiAkaTE4bi5uX2Fzc2V0X3N1YnNjcmliZV9udW1iZXIsIHZhbHVlOiBgJHttU3ViSW5wdXR9ICR7JGRhdGEuaG9tZS5jdXJyZW5jeX1gIH0sXG4gICAgeyB0eXBlOiBcIm5vcm1hbFwiLCB0aXRsZTogJGkxOG4ubl9taW5pbmdfZHVyYXRpb24sIHZhbHVlOiBleHBpcmVEYXRlIH0sXG4gICAgeyB0eXBlOiBcIm5vcm1hbFwiLCB0aXRsZTogJGkxOG4ubl9taW5pbmdfcmFuc29tX3dheSwgdmFsdWU6ICRpMThuLm5fc2ltcGxlX2Vhcm5fcmVkZWVtX2V4cGlyYXRpb24gfSxcbiAgICAvL+W5tOWMluaVsOaNrlxuICAgIHsgdHlwZTogXCJub3JtYWxcIiwgdGl0bGU6ICRpMThuLm5fc2ltcGxlX2Vhcm5fY29tcG9zaXRlX2FweSwgdmFsdWU6IGAke2FweX1gIH0sXG4gIF07XG4gIHJldHVybiBjb25maXJtTGlzdDtcbn1cblxuLyoqXG4gKiDojrflj5bnu7zlkIjlubTljJZcbiAqL1xuZnVuY3Rpb24gZ2V0Q29tcHJlaGVuc2l2ZUFweShpbm5lckxpc3QsIG1TdWJJbnB1dCkge1xuICAvL+e7vOWQiOW5tOWMllxuICBsZXQgY29tcHJlaGVuc2l2ZUFweSA9IDA7XG4gIGlmIChpbm5lckxpc3QubGVuZ3RoID09IDEpIHtcbiAgICBsZXQgcmF0ZU9yaSA9IGNvbnZlcnROdW1iZXIyKGlubmVyTGlzdFswXS5yYXRlLCB0cnVlKTtcbiAgICBsZXQgcmF0ZUZvcm1hdCA9IGAke2NvbW1vbi5mb3JtYXRQcmVjaXNpb24obnVtYmVyLm11bHRpcGx5KHJhdGVPcmksIDEwMCksIDIpfSVgO1xuICAgIGNvbnNvbGUubG9nKGAke3RhZ30gZ2V0Q29tcHJlaGVuc2l2ZUFweSByYXRlRm9ybWF0PSAke3JhdGVGb3JtYXR9YCk7XG4gICAgY29tcHJlaGVuc2l2ZUFweSA9IHJhdGVGb3JtYXQ7XG4gICAgcmV0dXJuIGNvbXByZWhlbnNpdmVBcHk7XG4gIH1cbiAgaW5uZXJMaXN0LmZvckVhY2goaXRlbSA9PiB7XG4gICAgLy/mlbDph48g5Y2V5L2NXG4gICAgbGV0IG51bSA9IGNvbnZlcnROdW1iZXIoaXRlbS5hbW91bnQsIGZhbHNlKSAqIGNvbnZlcnROdW1iZXIyKGl0ZW0ucmF0ZSwgdHJ1ZSk7XG4gICAgY29uc29sZS5sb2coYCR7dGFnfSBnZXRDb21wcmVoZW5zaXZlQXB5IG51bT0gJHtudW19YCk7XG4gICAgLy/luKYl55qE5Yip546HXG4gICAgY29tcHJlaGVuc2l2ZUFweSArPSBudW07XG4gIH0pO1xuICBsZXQgYXB5ID0gY29tcHJlaGVuc2l2ZUFweSAvIHBhcnNlRmxvYXQobVN1YklucHV0KVxuICBjb25zb2xlLmxvZyhgJHt0YWd9IGdldENvbXByZWhlbnNpdmVBcHkgYXB5PSAke2FweX1gKVxuICByZXR1cm4gYCR7Y29tbW9uLmZvcm1hdFByZWNpc2lvbihudW1iZXIubXVsdGlwbHkoYXB5LCAxMDApLCAyKX0lYDtcbn1cblxuZnVuY3Rpb24gY29udmVydE51bWJlcihzdHIsIGlzUGVyY2VudCkge1xuICBsZXQgbnVtID0gcGFyc2VGbG9hdChzdHIubWF0Y2goL1tcXGQuXSsvKVswXSk7XG4gIGlmIChpc1BlcmNlbnQgPT0gdHJ1ZSkge1xuICAgIG51bSA9IG51bSAvIDEwMDtcbiAgfVxuICBjb25zb2xlLmxvZyhgJHt0YWd9IGNvbnZlcnROdW1iZXIxIG51bT0gJHtudW19YCk7XG4gIHJldHVybiBudW07XG59XG5cbmZ1bmN0aW9uIGNvbnZlcnROdW1iZXIyKHN0ciwgaXNQZXJjZW50KSB7XG4gIGxldCBudW0gPSBwYXJzZUZsb2F0KHN0ci5tYXRjaCgvKFxcZCsoXFwuXFxkKyk/KSUvKVswXSk7XG4gIGlmIChpc1BlcmNlbnQgPT0gdHJ1ZSkge1xuICAgIG51bSA9IG51bSAvIDEwMDtcbiAgfVxuICBjb25zb2xlLmxvZyhgJHt0YWd9IGNvbnZlcnROdW1iZXIyIG51bT0gJHtudW19YCk7XG4gIHJldHVybiBudW07XG59XG5cbi8qKlxuICog6I635Y+W6Ieq5Yqo6LWa5biB54q25oCBXG4gKi9cbmZ1bmN0aW9uIGdldEF1dG9FYXJuU3RhdHVzKGVsZW1lbnQpIHtcbiAgaWYgKGVsZW1lbnQucHJvZHVjdFR5cGUgPT0gMCkge1xuICAgIHJldHVybiBlbGVtZW50LmF1dG9FYXJuO1xuICB9IGVsc2Uge1xuICAgIHJldHVybiAwO1xuICB9XG59XG5cbmZ1bmN0aW9uIGdldENvdXBvblN0YXR1cyhlbGVtZW50KSB7XG4gIGxldCByZXN1bHQgPSB7IGNvdXBvbklkOiBcIlwiLCBjb3Vwb25TaWduOiBcIlwiIH07XG4gIGlmIChlbGVtZW50LnByb2R1Y3RUeXBlID09IDAgfHwgZWxlbWVudC5wcm9kdWN0VHlwZSA9PSAxKSB7XG4gICAgbGV0IGNvdXBvbkxpc3REYXRhID0gZWxlbWVudC5jb3Vwb25MaXN0RGF0YTtcbiAgICBsZXQgaW5kZXggPSBjb3Vwb25MaXN0RGF0YS5jb3Vwb25JbmRleDtcbiAgICBpZiAoaW5kZXggPj0gMCkge1xuICAgICAgbGV0IGl0ZW0gPSBjb3Vwb25MaXN0RGF0YS5pdGVtc1tpbmRleF07XG4gICAgICBjb25zb2xlLmxvZyhgJHt0YWd9IGdldENvdXBvblN0YXR1cyBpdGVtPSAke2l0ZW0uaWR9ICR7aXRlbS5jb3Vwb25TaWdufSBtU3ViSW5wdXQ9ICR7ZWxlbWVudC5tU3ViSW5wdXR9IGNvdXBvbkRvd25MaW1pdD0gJHtpdGVtLmNvdXBvbkRvd25MaW1pdH1gKTtcbiAgICAgIC8v5aSE55CG5Yqg5oGv5Yi45LiN6Laz5LiL6ZmQ5pe277yM5LiN6IO95L2/55So5Yqg5oGv5Yi4XG4gICAgICBpZiAoZWxlbWVudC5tU3ViSW5wdXQgPj0gaXRlbS5jb3Vwb25Eb3duTGltaXQpIHtcbiAgICAgICAgcmVzdWx0LmNvdXBvbklkID0gaXRlbS5pZDtcbiAgICAgICAgcmVzdWx0LmNvdXBvblNpZ24gPSBpdGVtLmNvdXBvblNpZ247XG4gICAgICB9XG4gICAgfVxuICB9XG4gIGNvbnNvbGUubG9nKGAke3RhZ30gZ2V0Q291cG9uU3RhdHVzIHJlc3VsdD0gJHtKU09OLnN0cmluZ2lmeShyZXN1bHQpfWApO1xuICByZXR1cm4gcmVzdWx0O1xufSIsImltcG9ydCAqIGFzIGNvbW1vbiBmcm9tIFwiLi9jb21tb25cIjtcblxuJGRhdGEua3ljRGlhbG9nID0ge1xuICBpc1Nob3c6IGZhbHNlLCAvL2t5Y+W8ueahhuaYvuekulxuICB0aXBUaXRsZTogJGkxOG4ubl9vdGNfdXNlX3RpcCxcbiAgdGlwQ29udGVudDogJGkxOG4ubl9zaW1wbGVfZWFybl9reWNfZmFpbGVkLCAvL+aPkOekuuWGheWuuVxufTtcblxuJGV2ZW50Lmt5Y0RpYWxvZyA9IHtcbiAgb3Blbkt5Y0ZhaWxlZERpYWxvZzogZnVuY3Rpb24gKCkge1xuICAgICRkYXRhLmt5Y0RpYWxvZy50aXBDb250ZW50ID0gJGkxOG4ubl9zaW1wbGVfZWFybl9reWNfZmFpbGVkO1xuICAgICRkYXRhLmt5Y0RpYWxvZy5pc1Nob3cgPSB0cnVlO1xuICB9LFxuXG4gIG9wZW5LeWNMZXZlbERpYWxvZzogZnVuY3Rpb24gKGxldmVsID0gJycpIHtcbiAgICAkZGF0YS5reWNEaWFsb2cudGlwQ29udGVudCA9ICRpMThuLiRpbnRlcmNlcHQubl9zaW1wbGVfZWFybl9reWNfbGV2ZWwobGV2ZWwpO1xuICAgICRkYXRhLmt5Y0RpYWxvZy5pc1Nob3cgPSB0cnVlO1xuICB9LFxuXG4gIGNsb3NlRGlhbG9nOiBmdW5jdGlvbiAoKSB7XG4gICAgJGRhdGEua3ljRGlhbG9nLmlzU2hvdyA9IGZhbHNlO1xuICB9LFxuXG4gIGdvdG9LeWNBdXRoOiBmdW5jdGlvbiAoKSB7XG4gICAgJGRhdGEua3ljRGlhbG9nLmlzU2hvdyA9IGZhbHNlO1xuICAgICRldmVudC5kaWFsb2cuY2xvc2VDb25maXJtRGlhbG9nKCk7XG4gICAgY29tbW9uLm9wZW5VUkwoXCJob2xpZ2VpdDovL29wZW4vdjE/bG9naW49MSZ1cmw9aWh1b2JpZ2xvYmFsOi8vbS5oYmcuY29tL2FjY291bnQva3ljP2F1dGhCaXpDb2RlPVNQT1Qmc291cmNlPTBcIik7XG4gIH0sXG59O1xuIiwiaW1wb3J0ICogYXMgY29tbW9uIGZyb20gXCIuL2NvbW1vblwiO1xuaW1wb3J0ICogYXMgZml4ZWQgZnJvbSBcIi4vZml4ZWRcIjtcbmltcG9ydCAqIGFzIGRpYWxvZyBmcm9tIFwiLi9kaWFsb2dcIjtcbmltcG9ydCAqIGFzIHJlc3VsdCBmcm9tIFwiLi9yZXN1bHRcIjtcbmltcG9ydCAqIGFzIHJlY2VpcHRkaWFsb2cgZnJvbSBcIi4vcmVjZWlwdERpYWxvZ1wiO1xuaW1wb3J0ICogYXMgYXV0b2Vhcm4gZnJvbSBcIi4vYXV0b0Vhcm5EaWFsb2dcIjtcbmltcG9ydCAqIGFzIHB1cmNoYXNlVGlwIGZyb20gXCIuL3B1cmNoYXNlVGlwRGlhbG9nXCI7XG5pbXBvcnQgKiBhcyBsYWRkZXIgZnJvbSBcIi4vbGFkZGVyRGlhbG9nXCI7XG5pbXBvcnQgKiBhcyBwcm9maXRPdmVydmlldyBmcm9tIFwiLi9wcm9maXRPdmVydmlld0RpYWxvZ1wiO1xuaW1wb3J0ICogYXMgY291cG9uIGZyb20gXCIuL2NvdXBvbkRpYWxvZ1wiO1xuaW1wb3J0ICogYXMgY291cG9uTGlzdCBmcm9tIFwiLi9jb3Vwb25MaXN0RGlhbG9nXCI7XG5pbXBvcnQgKiBhcyBmbGV4aWJsZSBmcm9tIFwiLi9mbGV4aWJsZVwiO1xuaW1wb3J0ICogYXMgaG9tZSBmcm9tIFwiLi9ob21lXCI7XG5pbXBvcnQgKiBhcyBkZXBvc2l0IGZyb20gXCIuL2RlcG9zaXRcIjtcbmltcG9ydCAqIGFzIGFuYWx5dGljcyBmcm9tIFwiLi9hbmFseXRpY3NcIjtcbmltcG9ydCAqIGFzIGt5Y0RpYWxvZyAgZnJvbSBcIi4va3ljRGlhbG9nXCI7XG5pbXBvcnQgKiBhcyBmdW5kIGZyb20gXCIuL2Z1bmREaWFsb2dcIjtcblxuZnVuY3Rpb24gc2VuZENvbW1vbkNvbmZpZyhwYXJhbSkge1xuICBjb21tb24uZ2V0Q29tbW9uQ29uZmlnKHBhcmFtKTtcbn1cblxuJGV2ZW50LnNlbmRDb21tb25Db25maWcgPSBzZW5kQ29tbW9uQ29uZmlnOyJdLCJuYW1lcyI6WyJEUCIsIlJNIiwiTUFYX0RQIiwiTUFYX1BPV0VSIiwiTkUiLCJQRSIsIk5BTUUiLCJJTlZBTElEIiwiSU5WQUxJRF9EUCIsIklOVkFMSURfUk0iLCJESVZfQllfWkVSTyIsIlAiLCJVTkRFRklORUQiLCJOVU1FUklDIiwiX0JpZ18iLCJCaWciLCJuIiwieCIsInRoaXMiLCJzIiwiZSIsImMiLCJzbGljZSIsInBhcnNlIiwiY29uc3RydWN0b3IiLCJwcm90b3R5cGUiLCJ2ZXJzaW9uIiwiaSIsIm5sIiwidGVzdCIsIkVycm9yIiwiY2hhckF0IiwiaW5kZXhPZiIsInJlcGxhY2UiLCJzZWFyY2giLCJzdWJzdHJpbmciLCJsZW5ndGgiLCJyb3VuZCIsImRwIiwicm0iLCJtb3JlIiwieGMiLCJ1bnNoaWZ0IiwicG9wIiwic3RyaW5naWZ5IiwiaWQiLCJrIiwieiIsInB1c2giLCJqb2luIiwiYWJzIiwiY21wIiwieSIsImlzbmVnIiwieWMiLCJqIiwibCIsImRpdiIsImEiLCJiIiwiYmwiLCJidCIsInJpIiwiYnoiLCJhaSIsImFsIiwiciIsInJsIiwicSIsInFjIiwicWkiLCJkIiwic2hpZnQiLCJlcSIsImd0IiwiZ3RlIiwibHQiLCJsdGUiLCJtaW51cyIsInN1YiIsInQiLCJ4bHR5IiwicGx1cyIsInhlIiwieWUiLCJyZXZlcnNlIiwibW9kIiwieWd0eCIsInRpbWVzIiwiYWRkIiwicG93Iiwib25lIiwic3FydCIsImhhbGYiLCJNYXRoIiwidG9FeHBvbmVudGlhbCIsIm11bCIsIkFycmF5IiwidG9GaXhlZCIsInRvUHJlY2lzaW9uIiwic2QiLCJ0b1N0cmluZyIsInZhbHVlT2YiLCJ0b0pTT04iLCJzdWJ0cmFjdCIsIm11bHRpcGx5IiwiZm9ybWF0IiwidmFsdWUiLCJwcmVjaXNpb24iLCJiaWdWYWx1ZSIsInN0cmluZ1ZhbHVlIiwiaW5jbHVkZXMiLCJzdHJBcnJheSIsInNwbGl0IiwidHJ1bmNhdGUiLCJ6ZXJvTnVtYmVyIiwic3RyIiwiYmlnbnVtYmVyIiwiYXJyIiwiaXNBcnJheSIsIm1hcCIsImNsaWNrYWJsZSIsIm1vZHVsZURlZmluZSIsIm1vZHVsZU5hbWUiLCJkZWZhdWx0RGF0YUZ1bmN0aW9uIiwiZnVuY3Rpb25zIiwib25DcmVhdGUiLCJvbkRlc3Ryb3kiLCJvblJlc3VtZSIsIm9uUGF1c2UiLCJvblN0YXJ0Iiwib25TdG9wIiwiY29uc29sZSIsImxvZyIsIiRkYXRhIiwiJGV2ZW50IiwibW9kdWxlRGF0YSIsIm1vZHVsZUV2ZW50IiwiYXN5bmMiLCJhbmFseXRpY3MiLCJldmVudCIsInByb3BlcnRpZXMiLCJwcm9wZXJ0aWVzSnNvbiIsIkpTT04iLCIkbmF0aXZlQVBJIiwiY29tbW9uRGF0YSIsInByaWNlQ29sb3JUeXBlIiwiY29sb3JNb2RlIiwiT1MiLCJhcHBWZXJzaW9uIiwiaXNJblJldmlldyIsImg1VXJsIiwibGFuZ3VhZ2UiLCJzdGF0dXNIZWlnaHQiLCJ2VG9rZW4iLCJvbGRWVG9rZW4iLCJib3R0b21TYWZlQXJlYUhlaWdodCIsImNvdW50cnlJZCIsIm9wZW5VUkwiLCJ1cmwiLCJvcGVuUm91dGUiLCJzZXRUaW1lb3V0IiwiZ2V0Q29tbW9uQ29uZmlnIiwicGFyYW0iLCJwYXJzZUludCIsImdldFBOR0ljb25VUkxCeUN1cnJlbmN5IiwiY3VycmVuY3kiLCJiYXNlVXJsIiwidG9Mb3dlckNhc2UiLCJzZW5kUmVxdWVzdCIsInBhdGgiLCJwYXJhbXMiLCJtZXRob2QiLCJob3N0VHlwZSIsImhlYWRlciIsInJlc3BvbnNlU3RyaW5nIiwicmVxdWVzdCIsInJlc3BvbnNlIiwiY29kZSIsImRhdGEiLCJzdGF0dXMiLCJlcnJfY29kZSIsImVycl9tc2ciLCJzdGFydCIsInN0YXJ0SW5kZXgiLCJlbmQiLCJlbmRJbmRleCIsImRhdGFTdHJpbmciLCJzaG93VG9hc3QiLCJtZXNzYWdlIiwibXNnIiwiaGJUb2FzdCIsInNob3dMb2FkaW5nIiwiaXNTaG93IiwiRGF0ZSIsIkZvcm1hdCIsImZtdCIsIm8iLCJnZXRNb250aCIsImdldERhdGUiLCJnZXRIb3VycyIsImdldE1pbnV0ZXMiLCJnZXRTZWNvbmRzIiwiZmxvb3IiLCJTIiwiZ2V0TWlsbGlzZWNvbmRzIiwiUmVnRXhwIiwiJDEiLCJnZXRGdWxsWWVhciIsInN1YnN0ciIsImZvcm1hdFByZWNpc2lvbiIsInJlc3VsdCIsIm51bWJlci5mb3JtYXQiLCJnZXRQcmljZVN0cmluZyIsInByaWNlU3RyIiwicHJpY2VTdHJpbmciLCJmaW5hbFByaWNlU3RyIiwiY29udGFpbmVyQmFjayIsIm9wZW5QYWdlV2l0aFBhdGgiLCJ1cmxQYXRoIiwic2F2ZSIsIm1vZHVsZSIsImtleSIsInN0b3JhZ2UiLCJhY3Rpb24iLCJuYW1lIiwicmVhZCIsInJlbW92ZUV4dHJhWmVyb3MiLCJudW0iLCJhZGFwdGVyUGVyY2VudEZsYWciLCJ1bmRlZmluZWQiLCJ0YWciLCJjb3Vwb25MaXN0UmVzIiwidXNhYmxlQmdDb2xvciIsInVzYWJsZVRpdGxlQ29sb3IiLCJ1c2FibGVWYWxDb2xvciIsImRpc2FibGVCZ0NvbG9yIiwiZGlzYWJsZVRpdGxlQ29sb3IiLCJkaXNhYmxlVmFsQ29sb3IiLCJkaXNhYmxlSW1nIiwic2VsZWN0ZWRJbWciLCJ1bnNlbGVjdGVkSW1nIiwiQ29ucG9uTGlzdEl0ZW0iLCJ0aXRsZSIsImNvdXBvblVwTGltaXQiLCJjb3Vwb25Eb3duTGltaXQiLCJjb3Vwb25DdXJyZW5jeSIsImFweSIsImNvdXBvblRlcm0iLCJiZWdpblRpbWUiLCJlbmRUaW1lIiwiY291cG9uU2lnbiIsImR1ZVRhZyIsImluZGV4IiwiYXB5VGV4dCIsImVuZFRpbWVUZXh0IiwiaW1nU2VsZWN0b3IiLCJhcHBlbmRUZXh0Iiwic2hvd0hpZ3Rlc3QiLCJkdWVWaXMiLCJ0eXBlIiwic2V0RHVlVGFnIiwic2V0QXB5IiwiY29tbW9uLmZvcm1hdFByZWNpc2lvbiIsIm51bWJlci5tdWx0aXBseSIsInNldEVuZFRpbWUiLCIkaTE4biIsIiRpbnRlcmNlcHQiLCJuX3NpbXBsZV9lYXJuX2NvdXBvbl9saXN0X3ZhbGlkX3RvIiwic2V0QXBwZW5kVGV4dCIsIm5fc2ltcGxlX2Vhcm5fY291cG9uX2xpc3RfYm90dG9tIiwiY29weSIsIml0ZW0iLCJjb3Vwb25MaXN0IiwiZGlzYWJsZWRSZWFzb25WaXMiLCJkaXNhYmxlZFJlYXNvbiIsIml0ZW1zIiwiaXRlbUJnQ29sb3IiLCJpdGVtVGl0bGVDb2xvciIsIml0ZW1WYWxDb2xvciIsImR1ZVRpdGxlIiwibl9zaW1wbGVfZWFybl9kdWUiLCJnZXREZWZhdWx0RGF0YSIsImNvdXBvbkluZGV4IiwiZW5hYmxlRGlhbG9nIiwiaXNTZWxlY3RlZENvdXBvbkxpc3QiLCJzaG93VHlwZSIsImN1ckluZGV4IiwiaXRlbUNsaWNrIiwiZWxlbWVudCIsImhvbWUiLCJzbGlkZXJEYXRhIiwiY291cG9uTGlzdERhdGEiLCJzaG93Q291cG9uTGlzdFNlbGVjdCIsInNldERpc2FibGVkUmVhc29uVGV4dCIsImNvbW1vbi5hZGFwdGVyUGVyY2VudEZsYWciLCJuX3NpbXBsZV9lYXJuX2Rpc2FibGVkX3JlYXNvbiIsImNvbmZpcm0iLCJzaG93Q291cG9uT25lTGluZSIsIm5fc2ltcGxlX2Vhcm5fbm90X3VzZV9jb3Vwb24iLCJzaG93Q291cG9uTGluZSIsIm9wZW5EaWFsb2ciLCJ1c2luZ0NvdXBvbiIsImNvdXBvblJpZ2h0SW1nVmlzIiwic2hvd0NvdXBvbkxpc3RVc2FibGUiLCJzaG93Q291cG9uTGlzdERpc2FibGUiLCJjbG9zZURpYWxvZyIsImdldENvdXBvbkRhdGEiLCJvcmlnaW5Db3Vwb25EYXRhIiwicHJvamVjdElkIiwiY2xpc3QiLCJpc0VtcHR5T2JqZWN0IiwiY291cG9uc01hcCIsIm5fc2ltcGxlX2Vhcm5fdW5hdmFpbGFibGUiLCJoYW5kbGVDb3Vwb25MaXN0IiwidGVtcCIsInNob3dDb3Vwb25Ud29MaW5lIiwib2JqIiwibGlzdCIsImNvdXBvbkNvbXBhcmUiLCJzdWJJbnQiLCJ1c2VySW52ZXN0QW10Iiwic29ydCIsImFucyIsInNlbGVjdGVkSW5kZXgiLCJpc0l0ZW1DbGljayIsInJlZnJlc2hDb3Vwb24iLCJvcmlJdGVtcyIsIm5ld0xpc3QiLCJjMSIsImMyIiwiYTEiLCJnZXRBbW91bnQiLCJhMiIsIm1pbiIsInBhcnNlRmxvYXQiLCJtU3ViSW5wdXQiLCJzdWJOdW0iLCJjb3Vwb24iLCJzaG93RG93biIsImNvdXBvblRleHRNaWRWaXMiLCJjb3Vwb25NaWRWaXMiLCJjb3Vwb25UZXh0VXAiLCJuX3NpbXBsZV9lYXJuX2NvdXBvbl91cF90d29fbGluZSIsImNvdXBvblRleHREb3duIiwibl9zaW1wbGVfZWFybl9jb3Vwb25fZG93bl90d29uX2xpbmUiLCJjb3Vwb25UZXh0RG93blZpcyIsIm5fc2ltcGxlX2Vhcm5fY291cG9uX3VwX29uZV9saW5lIiwic2hvd1JpZ2h0IiwidGV4dCIsImNvdXBvblRleHRNaWQiLCJrZXlUb2tlbiIsImtleVByb2plY3RUeXBlIiwia2V5VGVybSIsImtleVByb2plY3RJZCIsImtleUFweVR5cGUiLCJrZXlEaXNwbGF5TGF1bmNoUG9vbExhYmVsT3JOb3QiLCJrZXlQYWdlTG9hZFRpbWUiLCJrZXlOYXRpb24iLCJrZXlGaXJzdExvYWQiLCJwdE5ld1VzZXIiLCJwdEZsZXhpYmxlIiwicHRGaXhlZCIsImF0QXB5IiwiYXRNYXJrZXRBcHkiLCJwYWdlU2hvdyIsImxvYWRUaW1lIiwiaXNGaXJzdFRpbWUiLCJ0ZXJtIiwicHJvZHVjdFR5cGUiLCJjb21tb24uY29tbW9uRGF0YSIsImFweVR5cGUiLCJmaXhlZFR5cGUiLCJjb21tb24uYW5hbHl0aWNzIiwiYmFja0NsaWNrIiwidG9rZW4iLCJhc3NldFNvdXJjZURpYWxvZ1Nob3ciLCJhc3NldFNvdXJjZUNvbmZpcm1CdG5DbGljayIsImFzc2V0U291cmNlVVNEREl0ZW1DbGljayIsIm9uT3JPZmYiLCJhc3NldFNvdXJjZVVTRFRJdGVtQ2xpY2siLCJlYXJuUHVyY2hhc2VMb2FkU3RhdHVzIiwic3VjY2Vzc09yRmF1bHQiLCJwYWdlTG9hZFN0YXRlIiwibWF4Q2xpY2siLCJidXlDbGljayIsInRyYW5zZmVyQ2xpY2siLCJyZXN0RXhwbGFpbkNsaWNrIiwiY291cG9uRXhwbGFpbkNsaWNrIiwiYXJyaXZhbERhdGVDbGljayIsInN1YnNjcmliZUJ1dHRvbkNsaWNrIiwiYXV0b0Vhcm5FeHBsYWluQ2xpY2siLCJrZXlBY3Rpb24iLCJhY3Rpb25PcGVuIiwiYWN0aW9uY2xvc2UiLCJhdXRvRWFyblN3aXRjaENsaWNrIiwiYXV0b0Vhcm4iLCJjb25maXJtSW5mb1Nob3ciLCJjb25maXJtQnV0dG9uQ2xpY2siLCJzdWJzY3JpYmVTdWNjZXNzU2hvdyIsImdldEN1cnJlbnRFbGVtZW50IiwiY3VycmVudEluZGV4Iiwic3Vic2NyaWJlU3VjY2Vzc0Nsb3NlQ2xvc2VDbGljayIsInN1YnNjcmliZVN1Y2Nlc3NWaWV3QXNzZXRzQ2xpY2siLCJzdWJzY3JpYmVTdWNjZXNzQ29udGludWVDbGljayIsImxhdW5jaHBvb2xSZXdhcmRzQ2xpY2siLCJjb21tb24ubW9kdWxlRGVmaW5lIiwiZGVmYXVsdEhhbmRsZXJEYXRhIiwic3ViSW5wdXQiLCJzdWJPbkZvY3VzIiwic3ViSGludCIsIm5fc2hhcmtfZmluX21pbl9hbW91bnQiLCJzdWJVbml0IiwiYmFsYW5jZSIsIm92ZXJ2aWV3Iiwic3ViQm9yZGVyQ29sb3IiLCJ0aW1lQXhpc0RhdGEiLCJ0aW1lQXhpc0hlaWdodCIsImF2YWlsYWJsZVF1b3RhVGl0bGUiLCJhdmFpbGFibGVRdW90YVRleHQiLCJtaW5TdWIiLCJwcm9maXQiLCJjb3Vwb25WaXMiLCJzdXBwb3J0Q291cG9uIiwiaGFuZGxlRmxleGlibGVEZXRhaWwiLCJmbGV4aWJsZUl0ZW0iLCJoYW5kbGVyRGF0YSIsIk9iamVjdCIsImhhc093blByb3BlcnR5IiwiY2FsbCIsImNvbW1vbi5yZW1vdmVFeHRyYVplcm9zIiwidG9VcHBlckNhc2UiLCJwcm9qZWN0UmVtYWluQW10UGVyRGF5Iiwibl9zaW1wbGVfZWFybl9hdmFpbGFibGVfcXVvdGEiLCJuX3NpbXBsZV9lYXJuX2F2YWlsYWJsZV9xdW90ZV90b2RheSIsImF2YWlsYWJsZVF1b3RhIiwiY29tbW9uLmdldFByaWNlU3RyaW5nIiwiZHRJbnRlcmVzdFN0YXJ0IiwiZHRSZWNlaXB0Iiwibl9zaW1wbGVfZWFybl9zb19yZWd1bGFyX3RpdGxlIiwiZHRFeHBpcmVkIiwiY291cG9uTGlzdC5nZXRDb3Vwb25EYXRhIiwicmVjZWlwdERlbGF5RGF5cyIsIm5fc2ltcGxlX2Vhcm5fc29fc3ViX2RheSIsImxpbmVUaXRsZSIsImRhdGUiLCJkdFN1YnNjcmliZSIsIm5fc2ltcGxlX2Vhcm5fc29fc3RhcnRfZGF5Iiwibl9zaW1wbGVfZWFybl9zb19kdWVfZGF5Iiwibl9zaW1wbGVfZWFybl9zb19yZWNlaXB0X2RheSIsImdldEl0ZW1EYXRhIiwiaXRlbUluZGV4IiwicmVxdWVzdFByb2ZpdEVzdGltYXRlIiwiaXRlbURhdGEiLCJyZXFQYXJhbSIsImFtdCIsImNvbW1vbi5zZW5kUmVxdWVzdCIsInByb2ZpdEZvcm1hdFNob3ciLCJjaGVja1N1YklucHV0IiwicXVhbnRpdHkiLCJzdWJFcnJvclN0ciIsIm5fc2ltcGxlX2Vhcm5faW5wdXRfb3Zlcl9iYWxhbmNlIiwic3ViRXJyb3JWaXMiLCJuX3NpbXBsZV9lYXJuX2lucHV0X21pbl9zdWJzY3JpYmUiLCJuX3NpbXBsZV9lYXJuX2lucHV0X292ZXJfcXVvdGEiLCJzdWJUZXh0Q2hhbmdlIiwiaW5wdXRTdHIiLCJudW1iZXIuYmlnbnVtYmVyIiwiY291cG9uTGlzdC5yZWZyZXNoQ291cG9uIiwiaW5wdXRTdGF0dXMiLCJkZXBvc2l0IiwiY2hlY2tCdG5TdGF0dXMiLCJzdWJGb2N1c0NoYW5nZSIsImZvY3VzIiwic3ViT25SZXR1cm4iLCJwYXJhbWV0ZXIiLCJjbGVhckZvY3VzIiwibWF4U3ViIiwiYmFsYW5jZVRleHQiLCJhbmFseXRpY3MubWF4Q2xpY2siLCJhdmFpbGFibGVRdW90YUNsaWNrZWQiLCJkaWFsb2ciLCJzaG93QXZhaWxhYmxlUXVvdGFEaWFsb2ciLCJhbmFseXRpY3MucmVzdEV4cGxhaW5DbGljayIsImJhY2tDbGlja2VkIiwiY29tbW9uLmNvbnRhaW5lckJhY2siLCJjb25maXJtVGl0bGUiLCJuX3NpbXBsZV9lYXJuX2NvbmZpcm1fc3Vic2NyaWJlX2luZm8iLCJjb25maXJtbGlzdCIsInF1b3RhUTEiLCJxdW90YUExIiwicXVvdGFRMiIsInF1b3RhQTIiLCJxdW90YVRleHQxIiwicXVvdGFUZXh0MiIsInF1b3RhVGV4dDMiLCJzaG93Q29uZmlybURpYWxvZyIsInNob3dBdmFpbGFibGVRdW90YSIsImNvbmZpcm1Jbm5lckxpc3QiLCJjb25maXJtSW5uZXJMaXN0VmlzIiwicHVyY2hhc2VWYWx1ZSIsImFzc2V0Q29tYmluZURhdGEiLCJ1c2R0VGlwIiwidXNkdFRpcERpc3BsYXkiLCJhbXRTb3VyY2UiLCJ1c2RkUmVzdCIsInNvdXJjZUVudW0iLCJ1c2RkU291cmNlIiwidXNkdFNvdXJjZSIsImlubmVyTGlzdCIsImlucHV0dmFsdWUiLCJmbGV4aWJsZUFzc2V0cyIsImZ1bmRMaXN0RGF0YSIsImFsbEFzc2V0cyIsInNvdXJjZSIsImNoZWNrSW1nIiwiZGlmZiIsIm51bWJlci5zdWJ0cmFjdCIsIm5ld0RpZmYiLCJuX2NvbmZpcm1fcHVyY2hhc2VfdGlwIiwibmV3QmFsYW5jZSIsInVzZGRBc3NldCIsIm5fdXNlX2NlcnRhaW5fY3VycmVuY3lfYXNzZXQiLCJ1c2R0QXNzZXQiLCJuZXdJbnB1dFZhbHVlIiwiYW5hbHl0aWNzLmNvbmZpcm1JbmZvU2hvdyIsImNsb3NlQ29uZmlybURpYWxvZyIsInByb2plY3QiLCJ0ZXh0Q29sb3IiLCJoaWdobGlnaHRDb2xvciIsInVzZXJSZW1haW5RdW90YSIsInN1cnBsdXNBbW91bnQiLCJuX3NpbXBsZV9lYXJuX3doYXRfaXNfYXZhaWxhYmxlX3F1b3RhX3RvZGF5Iiwibl9zaW1wbGVfZWFybl9hdmFpbGFibGVfcXVvdGFfdG9kYXlfYW5zd2VyIiwibl9zaW1wbGVfZWFybl9hdmFpbGFibGVfcXVvdGFfY2FsY3VsYXQiLCJuX3NpbXBsZV9lYXJuX2F2YWlsYWJsZV9xdW90YV9jYWxjdWxhdF9tZXRob2QxIiwibl9zaW1wbGVfZWFybl91c2VyX3JlbWFpbl9xdW90YSIsIm5fc2ltcGxlX2Vhcm5fcHJvamVjdF9yZW1haW5fcXVvdGFfdG9kYXkiLCJuX3NpbXBsZV9lYXJuX3doYXRfaXNfYXZhaWxhYmxlX3F1b3RhIiwibl9zaW1wbGVfZWFybl9hdmFpbGFibGVfcXVvdGFfYW5zd2VyIiwibl9zaW1wbGVfZWFybl9hdmFpbGFibGVfcXVvdGFfY2FsY3VsYXRfbWV0aG9kMiIsIm5fc2ltcGxlX2Vhcm5fcHJvamVjdF9yZW1haW5fcXVvdGEiLCJjbG9zZUF2YWlsYWJsZVF1b3RhRGlhbG9nIiwic2hlbGZUeXBlIiwiZGVmYXVsdERhdGEiLCJsb2FkaW5nTG90dGllU3RhdHVzIiwiaWNvblVybCIsInJlY29tbWVuZFNob3ciLCJsYWJlbFNob3ciLCJ0aXBzU2hvdyIsInJlc3VsdFN0ciIsInJlcXVlc3RTdWNjZXNzVmlldyIsIm9yZGVySWQiLCJyZWNvcmRJZCIsImFuYWx5dGljcy5zdWJzY3JpYmVTdWNjZXNzU2hvdyIsInJlY29tbWVuZCIsImNvbW1vbi5nZXRQTkdJY29uVVJMQnlDdXJyZW5jeSIsInByb2plY3RMYWJlbFR5cGUiLCJkZXNjcmJlIiwiU3RyaW5nIiwibl9zaW1wbGVfZWFybl9yZXN1bHRfc2hlbGZfZGVzY3JpYmUwIiwibl9zaW1wbGVfZWFybl9yZXN1bHRfc2hlbGZfZGVzY3JpYmUxIiwibl9zaW1wbGVfZWFybl9yZXN1bHRfc2hlbGZfZGVzY3JpYmUyIiwibl9zaW1wbGVfZWFybl9yZXN1bHRfc2hlbGZfZGVzY3JpYmU4Iiwibl9zaW1wbGVfZWFybl9yZXN1bHRfc2hlbGZfZGVzY3JpYmUxMSIsInZpZXdZZWFyUmF0ZSIsIm1heFZpZXdZZWFyUmF0ZSIsImNoZWNrTXlPcmRlciIsImNvbW1vbi5vcGVuVVJMIiwiYW5hbHl0aWNzLnN1YnNjcmliZVN1Y2Nlc3NWaWV3QXNzZXRzQ2xpY2siLCJjb250aW51ZUJ1eSIsImFuYWx5dGljcy5zdWJzY3JpYmVTdWNjZXNzQ29udGludWVDbGljayIsImFuYWx5dGljcy5zdWJzY3JpYmVTdWNjZXNzQ2xvc2VDbG9zZUNsaWNrIiwicmVjb21tZW5kQ2xpY2siLCJmcm9tVHlwZSIsInJlbG9hZFdpdGhQYXJhbXMiLCJyZWNlaXB0ZGlhbG9nIiwidGlwVGV4dCIsIm9wZW5SZWd1bGFyRGlhbG9nIiwibl9zaW1wbGVfZWFybl9yZWNlaXB0X3JlZ3VsYXIiLCJhbmFseXRpY3MuYXJyaXZhbERhdGVDbGljayIsIm9wZW5DdXJyZW50RGlhbG9nIiwicmVkZWVtTGltaXRQZXJEYXkiLCJsaW1pdCIsImxpbWl0MiIsImxpbWl0MyIsInAxIiwibl9zaW1wbGVfZWFybl9yZWNlaXB0X2ZsZXhpYmxlMSIsInAyIiwibl9zaW1wbGVfZWFybl9yZWNlaXB0X2ZsZXhpYmxlMiIsInAzIiwibl9zaW1wbGVfZWFybl9yZWNlaXB0X2ZsZXhpYmxlMyIsInA0Iiwibl9zaW1wbGVfZWFybl9yZWNlaXB0X2ZsZXhpYmxlNCIsIm5fc2ltcGxlX2Vhcm5fcmVjZWlwdF9jdXJyZW50MSIsIm5fc2ltcGxlX2Vhcm5fcmVjZWlwdF9jdXJyZW50MiIsImF1dG9FYXJuUmVzIiwibl9vdGNfdXNlX3RpcCIsImNvbnRlbnQiLCJuX3NpbXBsZV9lYXJuX2F1dG9fZWFybl9jb250ZW50X25ldyIsImF1dG9lYXJuIiwidGlwVGl0bGUiLCJ0aXBDb250ZW50Iiwic2V0Q29udGVudCIsImFuYWx5dGljcy5hdXRvRWFybkV4cGxhaW5DbGljayIsInB1cmNoYXNlVGlwUmVzIiwicHVyY2hhc2VUaXAiLCJsYWRkZXJSZXMiLCJhcnJvd1VwIiwiYXJyb3dEb3duIiwic2VsZWN0ZWRDb2xvciIsInVuc2VsZWN0ZWRDb2xvciIsIkxhZGRlckl0ZW0iLCJhbW91bnRUZXh0IiwicmF0ZSIsInNldEFtb3VudFRleHQiLCJhbW91bnRFbmQiLCJhbW91bnRTdGFydCIsIkxhZGRlcklubmVySXRlbSIsImN1cnJlbnRjeUltZyIsImN1cnJlbmN5Q29sb3IiLCJsYWRkZXIiLCJuX3NpbXBsZV9lYXJuX2xhZGRlcl90aXRsZSIsInRpcCIsIm5fc2ltcGxlX2Vhcm5fbGFkZGVyX2hpbnQiLCJleGFtcGxlIiwiZXhhbXBsZVZpcyIsInRhYmxlVGl0bGUiLCJuX3NpbXBsZV9lYXJuX2xhZGRlcl9hbGxfYXB5IiwidGFibGVDdXJyZW5jeSIsImFycm93SW1nIiwiaGVhZFRpdGxlIiwibl9hc3NldF9zdWJzY3JpYmVfbnVtYmVyIiwiaGVhZFRpdGxlMiIsIm5fc2ltcGxlX2Vhcm5fbGFkZGVyX2FweSIsImxhZGRlckxpc3QiLCJpc1Nob3dJbm5lciIsImxhZGRlcklubmVyTGlzdCIsImluaXRDdXJyZW5jeURhdGEiLCJnZXRDdXJyZW5jaWVzIiwiZ2V0Q3VyVGllcmVkUmF0ZSIsIm9uSXRlbUNsaWNrIiwiaWR4IiwiY2xvc2VJbm5lckRpYWxvZyIsIm9wZW5Jbm5lckRpYWxvZyIsInJlZnJlc2hMYWRkZXJJbm5lckxpc3QiLCJsYWRkZXJJbm5lciIsImN1cnJlbmN5TmFtZSIsInJlZnJlc2hMYWRkZXJMaXN0Iiwic2V0RXhhbXBsZSIsInRpZXJlZFJhdGVzIiwicmF0ZTEiLCJyYXRlMiIsIm51bTEiLCJudW0yIiwicmF0ZVRleHQxIiwicmF0ZVRleHQyIiwibl9zaW1wbGVfZWFybl9sYWRkZXJfZXhhbXBsZSIsIlByb2ZpdE92ZXJ2aWV3SXRlbSIsInBlcmtBcHkiLCJwZXJrTGltaXQiLCJwcm9maXRPdmVydmlldyIsIm5fc2ltcGxlX2Vhcm5fcHJvZml0X292ZXJ2aWV3Iiwibl9zaW1wbGVfZWFybl9wb190aXRsZSIsIm5fZG91YmxlX2NvaW5fZWFybl9jb2luIiwibl9zaW1wbGVfZWFybl9wb19yZXdhcmRfbGltaXQiLCJoZWFkVGl0bGUzIiwibl9zaW1wbGVfZWFybl9wb19wZXJrX2FweSIsInByb2ZpdE92ZXJ2aWV3TGlzdCIsInJld2FyZFJ1bGVUaXRsZSIsInJld2FyZFJ1bGVDb250ZW50MSIsInJld2FyZFJ1bGVDb250ZW50MiIsImV4YW1wbGVUaXRsZSIsImV4YW1wbGVDb250ZW50MSIsImV4YW1wbGVDb250ZW50MiIsInJld2FyZFJ1bGVWaXMiLCJpbml0RGF0YSIsImdldFBlcmtSYXRlcyIsInNldFJ1bGVBbmRFeGFtcGxlIiwib3JpTGltaXQiLCJvcmlSYXRlIiwibGltaXQ1IiwicmF0ZTMiLCJuX3NpbXBsZV9lYXJuX3BvX3Jld2FyZF9ydWxlX3RpdGxlIiwibl9zaW1wbGVfZWFybl9wb19yZXdhcmRfcnVsZV9jb250ZW50MSIsIm5fc2ltcGxlX2Vhcm5fcG9fcmV3YXJkX3J1bGVfY29udGVudDIiLCJuX3NpbXBsZV9lYXJuX3BvX2V4YW1wbGVfdGl0bGUiLCJuX3NpbXBsZV9lYXJuX3BvX2V4YW1wbGVfY29udGVudDEiLCJuX3NpbXBsZV9lYXJuX3BvX2V4YW1wbGVfY29udGVudDIiLCJzaXplIiwicmV3YXJkUnVsZSIsImNvdXBvblJlcyIsInNpemUxIiwic2l6ZTIiLCJjb2xvcjEiLCJjb2xvcjIiLCJmb250V2VpZ2h0MSIsImZvbnRXZWlnaHQyIiwibl9zaW1wbGVfZWFybl9jb3Vwb25fZGlhbG9nX3RpdGxlIiwidGFibGVUaXRsZUNvbnRlbnQiLCJuX3NpbXBsZV9lYXJuX2NvdXBvbl9kaWFsb2dfY29udGVudCIsIm5fc2ltcGxlX2Vhcm5fb3JpZ2luYWxfY291cG9uIiwibl9zaW1wbGVfZWFybl9leHRyYV9jb3Vwb24iLCJhbW91bnQiLCJuX2RheSIsImNvbG9yIiwiZm9udFdlaWdodCIsIm5fc2ltcGxlX2Vhcm5fY291cG9uX2RpYWxvZ19ub25lIiwiYm90dG9tVGV4dDEiLCJuX3NpbXBsZV9lYXJuX2NvdXBvbl9kaWFsb2dfYm90dG9tMSIsImJvdHRvbVRleHQyIiwibl9zaW1wbGVfZWFybl9jb3Vwb25fZGlhbG9nX2JvdHRvbTIiLCJhbmFseXRpY3MuY291cG9uRXhwbGFpbkNsaWNrIiwiY29uc3RhbnNTcCIsInNwS2V5VVNERCIsInNwS2V5VVNEVCIsImZ1bmRSZXMiLCJjb25maXJtQmdFbmFibGVDb2xvciIsImNvbmZpcm1UZXh0RW5hYmxlQ29sb3IiLCJjb25maXJtVGV4dERpc2FibGVDb2xvciIsImNvbmZpcm1CZ0Rpc2FibGVDb2xvciIsImZ1bmQiLCJ0aXAxVmlzIiwidGlwMlZpcyIsInRvdGFsQmFsYW5jZSIsImNvbmZpcm1UZXh0Q29sb3IiLCJjb25maXJtQmdDb2xvciIsInN0YXR1c1VTREQiLCJzdGF0dXNVU0RUIiwic2VsZWN0U3RhdHVzIiwicmVmcmVzaEZ1bmRVSSIsInRlbXBBbW91bnQiLCJudW1iZXIuYWRkIiwidHJhY2tJdGVtQ2xpY2siLCJpc1NlbGVjdCIsImFuYWx5dGljcy5hc3NldFNvdXJjZVVTRERJdGVtQ2xpY2siLCJhbmFseXRpY3MuYXNzZXRTb3VyY2VVU0RUSXRlbUNsaWNrIiwiYW5hbHl0aWNzLmFzc2V0U291cmNlQ29uZmlybUJ0bkNsaWNrIiwiaXRlbXNPdXRlciIsInRvdGFsQ3VycmVuY3kiLCJjb21tb24uc2F2ZSIsImFzc2V0U291cmNlRGVzYyIsIm5fY2FzaF9hc3NldF9iYWxhbmNlIiwiZmxleGlibGUiLCJpbWciLCJzdWJPdGhlckFtdEluZm8iLCJmdW5kRGF0YSIsImluZm8iLCJhbmFseXRpY3MuYXNzZXRTb3VyY2VEaWFsb2dTaG93IiwibGFkZGVyU2VsZWN0ZWRDb2xvciIsImxhZGRlclVuc2VsZWN0ZWRDb2xvciIsImxhZGRlclNlbGVjdGVkSW1nIiwibGFkZGVyVW5zZWxlY3RlZEltZyIsImF1dG9FYXJuU3dpdGNoUmVzIiwib3BlbkltZyIsImNsb3NlSW1nIiwiZXN0aW1hdGVkUHJvZml0IiwicHJvZml0RXZlcnlEYXkiLCJhc3NldFNvdXJjZVRpdGxlIiwiYXNzZXRTb3VyY2VEaXNwbGF5Iiwib3BlbkFjY291bnRBbGVydFNob3ciLCJsYWRkZXJWaXMiLCJwcm9maXRWaXMiLCJwcm9maXRMaXN0IiwicHJvZml0SGludCIsInByb2ZpdEhpbnRWaXMiLCJzdWJPdmVydmlld1RpdGxlIiwic3ViT3ZlcnZpZXdUMSIsInN1Yk92ZXJ2aWV3QzEiLCJzdWJPdmVydmlld1QyIiwic3ViT3ZlcnZpZXdDMiIsInN1Yk92ZXJ2aWV3VDMiLCJzdWJPdmVydmlld0MzIiwic3ViT3ZlcnZpZXdUM1ZpcyIsInN1Yk92ZXJ2aWV3VDNVTFZpcyIsImF1dG9FYXJuU3dpdGNoZXIiLCJtTWluU3ViIiwibU1hcmtldEFweVZvIiwiaGFuZGxlQ3VycmVudERldGFpbCIsImdldEN1cnJlbnREYXRhIiwic2hvd0JhbGFuY2UiLCJzdWZmaXgiLCJzdGFydEFtb3VudCIsInN1YnNjcmliZU1pbkFtb3VudCIsImxhdW5jaFBvb2xBY3Rpdml0eUlkIiwiaGFuZGxlQXNzZXRTb3VyY2VEZXNjIiwia3ljTGltaXRVc2VyVmlld0xldmVsIiwiYmFsYW5jZUF1dG9TdGF0dXMiLCJoYW5kbGVMYWRkZXJEYXRhIiwiaGFuZGxlU3ViT3ZlcnZpZXdEYXRhIiwibWFya2V0QXB5Vm8iLCJoYW5kbGVQcm9maXRPdmVydmlld0RhdGEiLCJvdGhlckFtdEluZm8iLCJjaGVja1Nob3dBc3NldFBvcHVwIiwibl9hc3NldF9zb3VyY2UiLCJjbGlja1B1cmNoYXNlRGlhbG9nQ2xvc2UiLCJkaWREaWFsb2dTaG93IiwiY29tbW9uLnJlYWQiLCJtb250aCIsImRheSIsInNob3duRGF0ZSIsImxhc3RTaG93bkRhdGUiLCJzaG93QXNzZXRQb3B1cCIsImFzc2V0U291cmNlIiwicG9wU2hvdyIsImlzTWFya2V0Iiwibl9zaW1wbGVfZWFybl9zb19jdXJyZW50X3RpdGxlMSIsIm5fc2ltcGxlX2Vhcm5fc29fc3ViX3RpbWUiLCJuX3NpbXBsZV9lYXJuX3NvX25vdyIsIm5fc2ltcGxlX2Vhcm5fc29fc3RhcnRfdGltZSIsIm5fc2ltcGxlX2Vhcm5fc29fZmlyc3RfaW5jb21lX3RpbWUiLCJkdEludGVyZXN0R3JhbnQiLCJuX3NpbXBsZV9lYXJuX3NvX2N1cnJlbnRfdGl0bGUyIiwibl9zaW1wbGVfZWFybl9zb19yZWFsX3RpbWVfcGF5bWVudCIsInByb2ZpdHMiLCJzdWJOdW1UZXh0IiwibWFya2V0VGltZUFweSIsIm1hcmtldFBlcmtBcHkiLCJuX2Fzc2V0X2FsbF9iYWxhbmNlcyIsInBlcmtWaXMiLCJtYXJrZXRQZXJrVXBMaW1pdFRleHQiLCJtYXJrZXRQZXJrVXBMaW1pdCIsInF1b3RhIiwibl9zaW1wbGVfZWFybl9tb3JlX3F1b3RhIiwiYW1vdW50MSIsImFtb3VudDFUZXh0IiwiYW1vdW50MiIsImFtb3VudDJUZXh0IiwiaW5kZXhUZXh0Iiwic2VsZWN0IiwibGFkZGVyQ29sb3IiLCJsYWRkZXJJbWciLCJyYXRlVGV4dCIsImNsaWNrTGF1bmNocG9vbCIsImlzUmVmcmVzaERhdGEiLCJjb21tb24ub3BlblBhZ2VXaXRoUGF0aCIsImFuYWx5dGljcy5sYXVuY2hwb29sUmV3YXJkc0NsaWNrIiwicmVmcmVzaFByb2ZpdCIsInJlZnJlc2hMYWRkZXIiLCJyZWZyZXNoUHJvZml0T3ZlcnZpZXciLCJjbGlja0F1dG9FYXJuU3dpdGNoIiwiYW5hbHl0aWNzLmF1dG9FYXJuU3dpdGNoQ2xpY2siLCJkYXRhVmlzIiwic2Nyb2xsVG9UYWciLCJlYXJuVGFiTGlzdCIsInRvcEljb24iLCJ0b3BUaXRsZSIsInN1Ym1pdFRleHQiLCJuX2JhbGFuY2VfbWluaW5nX2RlcG9zaXQiLCJpbnRlcmNhbCIsImN1cnJlbnRDb3VudCIsInJlc3VtZUlzTm90Rmlyc3QiLCJjdXJyZW50U2VsZWN0SW5kZXgiLCJvblJlc3VtZVRpbWUiLCJqc29uUGFyYW1ldGVycyIsInN0YXR1c0JhckNvbmZpZyIsInN0YXR1c0Jhck1vZGUiLCJhZFN0YXR1c0JhckNvbG9yIiwibmF2Q29uZmlnIiwiZ2V0TmF2Q29uZmlnU3RyaW5nIiwicmljaFRleHREYXRhIiwibl9rbGluZV9kZXRhaWxfZWFybmNvaW5zIiwicmVxdWVzdEZsZXhpYmxlRGV0YWlsIiwiY2xlYXJUaW1lciIsIm9ubHlSZWZyZXNoQXB5Iiwibm93IiwicmVxT2JraiIsImFuYWx5dGljcy5lYXJuUHVyY2hhc2VMb2FkU3RhdHVzIiwicGlkcyIsInAiLCJwcm9qZWN0cyIsInByb2plY3RJZHMiLCJjb3Vwb25EYXRhIiwiZnVuZC5jb25zdGFuc1NwIiwiaGFuZGxlVGFiRGF0YSIsImJhbGFuY2VBbW91bnQiLCJlcmFuVGFiRGF0YSIsImZvckVhY2giLCJib3JkZXJDb2xvciIsInRhZ1ZpcyIsImdldFRhZ1ZpcyIsInRhZ0JnIiwiZ2V0VGFnQmciLCJ0YWdUZXh0IiwiZ2V0VGFnVGV4dCIsInRhZ05hbWUiLCJ0YWdUZXh0Q29sb3IiLCJnZXRUYWdUZXh0Q29sb3IiLCJ0YWJXaWR0aCIsImdldFRhZ1dpZHRoIiwidGltZVZpcyIsImVhcm5pbmdzIiwiYXB5U2hvdyIsImN5Y2xlIiwibl9hc3NldF9lYXJuX2N1cnJlbnQiLCJmbGV4aWJsZS5oYW5kbGVDdXJyZW50RGV0YWlsIiwiY3VyQXB5IiwibWF4QXB5IiwibGFzdFRhYiIsImxhc3RBcHkiLCJsYXN0RWxlbWVudCIsImZsZXhpYmxlLnJlZnJlc2hQcm9maXRPdmVydmlldyIsImFweUNvdW50ZG93biIsInRpbWVUZXh0IiwiZm9ybWF0RGF0ZSIsInRpbWVJY29uIiwic3RhcnRDdXJyZW50Q291bnREb3duIiwibl9taW5pbmdfZGF5X3RleHQiLCJmaXhlZC5oYW5kbGVGbGV4aWJsZURldGFpbCIsImFuYWx5dGljcy5wYWdlU2hvdyIsImNoZWNrVXNkZFB1cmNoYXNlVGlwIiwibl9zaW1wbGVfZWFybl9uZXdjb21lciIsIm1heCIsInNldEludGVydmFsIiwiY2hhbmdlQ291bnRkb3duIiwidGltZXN0YW1wIiwibWludXRlcyIsInNlY29uZHMiLCJjbGVhckludGVydmFsIiwiYmFubmVySW5kZXhDaGFuZ2UiLCJ0YWIiLCJkaWRTaG93IiwiYW5hbHl0aWNzLmJhY2tDbGljayIsImJ1eUNvaW4iLCJidXlDb2luT2JqIiwiZG91YmxlQ29pbkFiaWxpdHkiLCJhbmFseXRpY3MuYnV5Q2xpY2siLCJ0cmFuc2ZlciIsInRyYW5zZmVyT2JqIiwianVtcCIsImFuYWx5dGljcy50cmFuc2ZlckNsaWNrIiwiYnRuRW5hYmxlIiwiYnRuQ29sb3IiLCJidG5UaXRsZUNvbG9yIiwiaHVvYmlTZWxlY3RlZCIsImh1b2JpQWdyZWVJbWFnZSIsImNvbmZpcm1CdG5Db2xvciIsInByb2plY3RTdGF0dXMiLCJuX3NpbXBsZV9lYXJuX25vdF9zdGFydGVkIiwibl9zaW1wbGVfZWFybl9mdWxseV9zdWJzY3JpYmVkIiwibl9zaW1wbGVfZWFybl9lbmRlZCIsInN1Ym1pdENsaWNrZWQiLCJjb25maXJtTGlzdCIsImdldEZsZXhpYmxlQ29uZmlybUlubmVyTGlzdCIsImdldEZsZXhpYmxlQ29uZmlybUxpc3QiLCJnZXRGaXhlZENvbmZpcm1Jbm5lckxpc3QiLCJnZXRGaXhlZENvbmZpcm1MaXN0IiwiYW5hbHl0aWNzLnN1YnNjcmliZUJ1dHRvbkNsaWNrIiwiY29uZmlybURpYWxvZ0Jsb2NrIiwicGFyc2VTb3VyY2UiLCJhbmFseXRpY3MuY29uZmlybUJ1dHRvbkNsaWNrIiwiZ2V0QXV0b0Vhcm5TdGF0dXMiLCJjb3Vwb25JZCIsImdldENvdXBvblN0YXR1cyIsImFkZFBhcmFtcyIsImJhbGFuY2VBdXRvRGlnZ2luZ1N0YXR1cyIsImNvbW1vbi5zaG93TG9hZGluZyIsIm9yZGVyQWRkUmVxdWVzdCIsImt5Y0RpYWxvZyIsIm9wZW5LeWNGYWlsZWREaWFsb2ciLCJvcGVuS3ljTGV2ZWxEaWFsb2ciLCJjb21tb24uc2hvd1RvYXN0Iiwibl9zaW1wbGVfZWFybl9wZXJrX2FweSIsImNvdXBvbkl0ZW0iLCJhbW91bnROdW0iLCJjdXJBbW91bnQiLCJjb252ZXJ0TnVtYmVyIiwibl9zaW1wbGVfZWFybl9jb3Vwb25fY29uZmlybSIsInNwbGljZSIsInllYXJSYXRlIiwiZ2V0Q29tcHJlaGVuc2l2ZUFweSIsIm5fbWluaW5nX3JhbnNvbV93YXkiLCJuX3NpbXBsZV9lYXJuX3JlZGVlbV9hbnlfdGltZSIsIm5fc2ltcGxlX2Vhcm5fY29tcG9zaXRlX2FweSIsImV4cGlyZURhdGUiLCJuX3NpbXBsZV9lYXJuX2JlY29tZV9kdWUiLCJuX21pbmluZ19kdXJhdGlvbiIsIm5fc2ltcGxlX2Vhcm5fcmVkZWVtX2V4cGlyYXRpb24iLCJjb21wcmVoZW5zaXZlQXB5IiwicmF0ZU9yaSIsImNvbnZlcnROdW1iZXIyIiwicmF0ZUZvcm1hdCIsImlzUGVyY2VudCIsIm1hdGNoIiwibl9zaW1wbGVfZWFybl9reWNfZmFpbGVkIiwibGV2ZWwiLCJuX3NpbXBsZV9lYXJuX2t5Y19sZXZlbCIsImdvdG9LeWNBdXRoIiwic2VuZENvbW1vbkNvbmZpZyIsImNvbW1vbi5nZXRDb21tb25Db25maWciXSwibWFwcGluZ3MiOiJBQWlCQSxJQUFJQSxLQUFLLElBVVBDLEtBQUssR0FHTEMsU0FBUyxLQUdUQyxZQUFZLEtBT1pDLE1BQU0sR0FRTkMsS0FBSyxJQU9MQyxPQUFPLGFBQ1BDLFVBQVVELE9BQU8sWUFDakJFLGFBQWFELFVBQVUsa0JBQ3ZCRSxhQUFhRixVQUFVLGlCQUN2QkcsY0FBY0osT0FBTyxvQkFHckJLLElBQUksQ0FBRSxHQUNOQyxpQkFBaUIsR0FDakJDLFVBQVU7O0FBT1osU0FBU0M7SUFRUCxTQUFTQyxJQUFJQztRQUNYLElBQUlDLElBQUlDO1FBR1IsTUFBTUQsYUFBYUYsTUFBTSxPQUFPQyxNQUFNSixZQUFZRSxVQUFVLElBQUlDLElBQUlDO1FBR3BFLElBQUlBLGFBQWFELEtBQUs7WUFDcEJFLEVBQUVFLElBQUlILEVBQUVHO1lBQ1JGLEVBQUVHLElBQUlKLEVBQUVJO1lBQ1JILEVBQUVJLElBQUlMLEVBQUVLLEVBQUVDO0FBQ2hCLGVBQVc7WUFDTEMsTUFBTU4sR0FBR0Q7QUFDVjtRQU1EQyxFQUFFTyxjQUFjVDtBQUNqQjtJQUVEQSxJQUFJVSxZQUFZZDtJQUNoQkksSUFBSWYsS0FBS0E7SUFDVGUsSUFBSWQsS0FBS0E7SUFDVGMsSUFBSVgsS0FBS0E7SUFDVFcsSUFBSVYsS0FBS0E7SUFDVFUsSUFBSVcsVUFBVTtJQUVkLE9BQU9YO0FBQ1Q7O0FBU0EsU0FBU1EsTUFBTU4sR0FBR0Q7SUFDaEIsSUFBSUksR0FBR08sR0FBR0M7SUFHVixJQUFJWixNQUFNLEtBQUssSUFBSUEsSUFBSSxHQUFHQSxJQUFJLFdBQ3pCLEtBQUtILFFBQVFnQixLQUFLYixLQUFLLEtBQUssTUFBTWMsTUFBTXZCLFVBQVU7SUFHdkRVLEVBQUVFLElBQUlILEVBQUVlLE9BQU8sTUFBTSxPQUFPZixJQUFJQSxFQUFFTSxNQUFNLEtBQUssS0FBSztJQUdsRCxLQUFLRixJQUFJSixFQUFFZ0IsUUFBUSxTQUFTLEdBQUdoQixJQUFJQSxFQUFFaUIsUUFBUSxLQUFLO0lBR2xELEtBQUtOLElBQUlYLEVBQUVrQixPQUFPLFNBQVMsR0FBRztRQUc1QixJQUFJZCxJQUFJLEdBQUdBLElBQUlPO1FBQ2ZQLE1BQU1KLEVBQUVNLE1BQU1LLElBQUk7UUFDbEJYLElBQUlBLEVBQUVtQixVQUFVLEdBQUdSO0FBQ3ZCLFdBQVMsSUFBSVAsSUFBSSxHQUFHO1FBR2hCQSxJQUFJSixFQUFFb0I7QUFDUDtJQUVEUixLQUFLWixFQUFFb0I7SUFHUCxLQUFLVCxJQUFJLEdBQUdBLElBQUlDLE1BQU1aLEVBQUVlLE9BQU9KLE1BQU0sU0FBUUE7SUFFN0MsSUFBSUEsS0FBS0MsSUFBSTtRQUdYWCxFQUFFSSxJQUFJLEVBQUNKLEVBQUVHLElBQUk7QUFDakIsV0FBUztRQUdMLE1BQU9RLEtBQUssS0FBS1osRUFBRWUsU0FBU0gsT0FBTztRQUNuQ1gsRUFBRUcsSUFBSUEsSUFBSU8sSUFBSTtRQUNkVixFQUFFSSxJQUFJO1FBR04sS0FBS0QsSUFBSSxHQUFHTyxLQUFLQyxNQUFLWCxFQUFFSSxFQUFFRCxRQUFRSixFQUFFZSxPQUFPSjtBQUM1QztJQUVELE9BQU9WO0FBQ1Q7O0FBWUEsU0FBU29CLE1BQU1wQixHQUFHcUIsSUFBSUMsSUFBSUM7SUFDeEIsSUFBSUMsS0FBS3hCLEVBQUVJLEdBQ1RNLElBQUlWLEVBQUVHLElBQUlrQixLQUFLO0lBRWpCLElBQUlYLElBQUljLEdBQUdMLFFBQVE7UUFDakIsSUFBSUcsT0FBTyxHQUFHO1lBR1pDLE9BQU9DLEdBQUdkLE1BQU07QUFDdEIsZUFBVyxJQUFJWSxPQUFPLEdBQUc7WUFDbkJDLE9BQU9DLEdBQUdkLEtBQUssS0FBS2MsR0FBR2QsTUFBTSxNQUMxQmEsUUFBUWIsSUFBSSxLQUFLYyxHQUFHZCxJQUFJLE9BQU9mLGFBQWE2QixHQUFHZCxJQUFJLEtBQUs7QUFDakUsZUFBVyxJQUFJWSxPQUFPLEdBQUc7WUFDbkJDLE9BQU9BLFVBQVVDLEdBQUc7QUFDMUIsZUFBVztZQUNMRCxPQUFPO1lBQ1AsSUFBSUQsT0FBTyxHQUFHLE1BQU1ULE1BQU1yQjtBQUMzQjtRQUVELElBQUlrQixJQUFJLEdBQUc7WUFDVGMsR0FBR0wsU0FBUztZQUVaLElBQUlJLE1BQU07Z0JBR1J2QixFQUFFRyxLQUFLa0I7Z0JBQ1BHLEdBQUcsS0FBSztBQUNoQixtQkFBYTtnQkFHTEEsR0FBRyxLQUFLeEIsRUFBRUcsSUFBSTtBQUNmO0FBQ1AsZUFBVztZQUdMcUIsR0FBR0wsU0FBU1Q7WUFHWixJQUFJYSxNQUFNO2dCQUdSLFFBQVNDLEdBQUdkLEtBQUssS0FBSTtvQkFDbkJjLEdBQUdkLEtBQUs7b0JBQ1IsS0FBS0EsS0FBSzswQkFDTlYsRUFBRUc7d0JBQ0pxQixHQUFHQyxRQUFRO0FBQ1o7QUFDRjtBQUNGO1lBR0QsS0FBS2YsSUFBSWMsR0FBR0wsU0FBU0ssS0FBS2QsTUFBS2MsR0FBR0U7QUFDbkM7QUFDTCxXQUFTLElBQUlKLEtBQUssS0FBS0EsS0FBSyxLQUFLQSxTQUFTQSxJQUFJO1FBQzFDLE1BQU1ULE1BQU1yQjtBQUNiO0lBRUQsT0FBT1E7QUFDVDs7QUFnQkEsU0FBUzJCLFVBQVUzQixHQUFHNEIsSUFBSTdCLEdBQUc4QjtJQUMzQixJQUFJMUIsR0FBR0QsR0FDTEosTUFBTUUsRUFBRU8sYUFDUnVCLEtBQUs5QixFQUFFSSxFQUFFO0lBRVgsSUFBSUwsTUFBTUosV0FBVztRQUNuQixJQUFJSSxRQUFRQSxLQUFLQSxLQUFLNkIsTUFBTSxNQUFNN0IsSUFBSWQsUUFBUTtZQUM1QyxNQUFNNEIsTUFBTWUsTUFBTSxJQUFJdEMsVUFBVSxjQUFjQztBQUMvQztRQUVEUyxJQUFJLElBQUlGLElBQUlFO1FBR1pELElBQUk4QixJQUFJN0IsRUFBRUc7UUFHVixJQUFJSCxFQUFFSSxFQUFFZSxXQUFXVSxHQUFHVCxNQUFNcEIsR0FBR0QsR0FBR0QsSUFBSWQ7UUFHdEMsSUFBSTRDLE1BQU0sR0FBR0MsSUFBSTdCLEVBQUVHLElBQUlKLElBQUk7UUFHM0IsTUFBT0MsRUFBRUksRUFBRWUsU0FBU1UsS0FBSTdCLEVBQUVJLEVBQUUyQixLQUFLO0FBQ2xDO0lBRUQ1QixJQUFJSCxFQUFFRztJQUNORCxJQUFJRixFQUFFSSxFQUFFNEIsS0FBSztJQUNiakMsSUFBSUcsRUFBRWlCO0lBR04sSUFBSVMsTUFBTSxNQUFNQSxNQUFNLEtBQUtBLE1BQU0sS0FBS0MsS0FBSzFCLEtBQUtBLEtBQUtMLElBQUlYLE1BQU1nQixLQUFLTCxJQUFJVixLQUFLO1FBQzNFYyxJQUFJQSxFQUFFWSxPQUFPLE1BQU1mLElBQUksSUFBSSxNQUFNRyxFQUFFRyxNQUFNLEtBQUssT0FBT0YsSUFBSSxJQUFJLE1BQU0sUUFBUUE7QUFHL0UsV0FBUyxJQUFJQSxJQUFJLEdBQUc7UUFDaEIsUUFBU0EsS0FBSUQsSUFBSSxNQUFNQTtRQUN2QkEsSUFBSSxPQUFPQTtBQUNmLFdBQVMsSUFBSUMsSUFBSSxHQUFHO1FBQ2hCLE1BQU1BLElBQUlKLEdBQUcsS0FBS0ksS0FBS0osR0FBR0ksT0FBTUQsS0FBSyxVQUNoQyxJQUFJQyxJQUFJSixHQUFHRyxJQUFJQSxFQUFFRyxNQUFNLEdBQUdGLEtBQUssTUFBTUQsRUFBRUcsTUFBTUY7QUFDdEQsV0FBUyxJQUFJSixJQUFJLEdBQUc7UUFDaEJHLElBQUlBLEVBQUVZLE9BQU8sS0FBSyxNQUFNWixFQUFFRyxNQUFNO0FBQ2pDO0lBRUQsT0FBT0wsRUFBRUUsSUFBSSxPQUFPNEIsS0FBS0YsTUFBTSxLQUFLLE1BQU0xQixJQUFJQTtBQUNoRDs7QUFTQVIsRUFBRXVDLE1BQU07SUFDTixJQUFJakMsSUFBSSxJQUFJQyxLQUFLTSxZQUFZTjtJQUM3QkQsRUFBRUUsSUFBSTtJQUNOLE9BQU9GO0FBQ1Q7O0FBUUFOLEVBQUV3QyxNQUFNLFNBQVVDO0lBQ2hCLElBQUlDLE9BQ0ZwQyxJQUFJQyxNQUNKdUIsS0FBS3hCLEVBQUVJLEdBQ1BpQyxNQUFNRixJQUFJLElBQUluQyxFQUFFTyxZQUFZNEIsSUFBSS9CLEdBQ2hDTSxJQUFJVixFQUFFRSxHQUNOb0MsSUFBSUgsRUFBRWpDLEdBQ04yQixJQUFJN0IsRUFBRUcsR0FDTm9DLElBQUlKLEVBQUVoQztJQUdSLEtBQUtxQixHQUFHLE9BQU9hLEdBQUcsSUFBSSxRQUFRYixHQUFHLE1BQU1hLEdBQUcsS0FBSyxLQUFLQyxJQUFJNUI7SUFHeEQsSUFBSUEsS0FBSzRCLEdBQUcsT0FBTzVCO0lBRW5CMEIsUUFBUTFCLElBQUk7SUFHWixJQUFJbUIsS0FBS1UsR0FBRyxPQUFPVixJQUFJVSxJQUFJSCxRQUFRLEtBQUs7SUFFeENFLEtBQUtULElBQUlMLEdBQUdMLFdBQVdvQixJQUFJRixHQUFHbEIsVUFBVVUsSUFBSVU7SUFHNUMsS0FBSzdCLEtBQUssS0FBS0EsSUFBSTRCLEtBQUk7UUFDckIsSUFBSWQsR0FBR2QsTUFBTTJCLEdBQUczQixJQUFJLE9BQU9jLEdBQUdkLEtBQUsyQixHQUFHM0IsS0FBSzBCLFFBQVEsS0FBSztBQUN6RDtJQUdELE9BQU9QLEtBQUtVLElBQUksSUFBSVYsSUFBSVUsSUFBSUgsUUFBUSxLQUFLO0FBQzNDOztBQU9BMUMsRUFBRThDLE1BQU0sU0FBVUw7SUFDaEIsSUFBSW5DLElBQUlDLE1BQ05ILE1BQU1FLEVBQUVPLGFBQ1JrQyxJQUFJekMsRUFBRUksR0FDTnNDLEtBQUtQLElBQUksSUFBSXJDLElBQUlxQyxJQUFJL0IsR0FDckJ5QixJQUFJN0IsRUFBRUUsS0FBS2lDLEVBQUVqQyxJQUFJLEtBQUssR0FDdEJtQixLQUFLdkIsSUFBSWY7SUFFWCxJQUFJc0MsU0FBU0EsTUFBTUEsS0FBSyxLQUFLQSxLQUFLcEMsUUFBUSxNQUFNNEIsTUFBTXRCO0lBR3RELEtBQUttRCxFQUFFLElBQUksTUFBTTdCLE1BQU1wQjtJQUd2QixLQUFLZ0QsRUFBRSxJQUFJLE9BQU8sSUFBSTNDLElBQUkrQixJQUFJO0lBRTlCLElBQUljLElBQUlDLElBQUk3QyxHQUFHbUMsS0FBS1csSUFDbEJDLEtBQUtKLEVBQUVyQyxTQUNQMEMsS0FBS0osS0FBS0QsRUFBRXZCLFFBQ1o2QixLQUFLUCxFQUFFdEIsUUFDUDhCLElBQUlSLEVBQUVwQyxNQUFNLEdBQUdzQyxLQUNmTyxLQUFLRCxFQUFFOUIsUUFDUGdDLElBQUloQixHQUNKaUIsS0FBS0QsRUFBRS9DLElBQUksSUFDWGlELEtBQUssR0FDTEMsSUFBSWpDLE1BQU04QixFQUFFaEQsSUFBSUgsRUFBRUcsSUFBSWdDLEVBQUVoQyxLQUFLO0lBRS9CZ0QsRUFBRWpELElBQUkyQjtJQUNOQSxJQUFJeUIsSUFBSSxJQUFJLElBQUlBO0lBR2hCUixHQUFHckIsUUFBUTtJQUdYLE1BQU95QixPQUFPUCxNQUFLTSxFQUFFbEIsS0FBSztJQUUxQixHQUFHO1FBR0QsS0FBS2hDLElBQUksR0FBR0EsSUFBSSxJQUFJQSxLQUFLO1lBR3ZCLElBQUk0QyxPQUFPTyxLQUFLRCxFQUFFOUIsU0FBUztnQkFDekJlLE1BQU1TLEtBQUtPLEtBQUssS0FBSztBQUM3QixtQkFBYTtnQkFDTCxLQUFLTCxNQUFNLEdBQUdYLE1BQU0sS0FBS1csS0FBS0YsTUFBSztvQkFDakMsSUFBSUQsRUFBRUcsT0FBT0ksRUFBRUosS0FBSzt3QkFDbEJYLE1BQU1RLEVBQUVHLE1BQU1JLEVBQUVKLE1BQU0sS0FBSzt3QkFDM0I7QUFDRDtBQUNGO0FBQ0Y7WUFHRCxJQUFJWCxNQUFNLEdBQUc7Z0JBSVgsS0FBS1UsS0FBS00sTUFBTVAsS0FBS0QsSUFBSUksSUFBSUksTUFBSztvQkFDaEMsSUFBSUQsSUFBSUMsTUFBTU4sR0FBR00sS0FBSzt3QkFDcEJMLEtBQUtLO3dCQUNMLE1BQU9MLE9BQU9JLElBQUlKLE9BQU1JLEVBQUVKLE1BQU07MEJBQzlCSSxFQUFFSjt3QkFDSkksRUFBRUMsT0FBTztBQUNWO29CQUNERCxFQUFFQyxPQUFPTixHQUFHTTtBQUNiO2dCQUVELE9BQVFELEVBQUUsTUFBS0EsRUFBRU07QUFDekIsbUJBQWE7Z0JBQ0w7QUFDRDtBQUNGO1FBR0RILEdBQUdDLFFBQVFuQixNQUFNbkMsTUFBTUE7UUFHdkIsSUFBSWtELEVBQUUsTUFBTWYsS0FBS2UsRUFBRUMsTUFBTVQsRUFBRU0sT0FBTyxRQUM3QkUsSUFBSSxFQUFDUixFQUFFTTtBQUVoQixjQUFZQSxPQUFPQyxNQUFNQyxFQUFFLE9BQU90RCxjQUFja0M7SUFHOUMsS0FBS3VCLEdBQUcsTUFBTUMsTUFBTSxHQUFHO1FBR3JCRCxHQUFHRztRQUNISixFQUFFaEQ7QUFDSDtJQUdELElBQUlrRCxLQUFLQyxHQUFHbEMsTUFBTStCLEdBQUc5QixJQUFJdkIsSUFBSWQsSUFBSWlFLEVBQUUsT0FBT3REO0lBRTFDLE9BQU93RDtBQUNUOztBQU1BekQsRUFBRThELEtBQUssU0FBVXJCO0lBQ2YsUUFBUWxDLEtBQUtpQyxJQUFJQztBQUNuQjs7QUFPQXpDLEVBQUUrRCxLQUFLLFNBQVV0QjtJQUNmLE9BQU9sQyxLQUFLaUMsSUFBSUMsS0FBSztBQUN2Qjs7QUFPQXpDLEVBQUVnRSxNQUFNLFNBQVV2QjtJQUNoQixPQUFPbEMsS0FBS2lDLElBQUlDLE1BQU07QUFDeEI7O0FBTUF6QyxFQUFFaUUsS0FBSyxTQUFVeEI7SUFDZixPQUFPbEMsS0FBS2lDLElBQUlDLEtBQUs7QUFDdkI7O0FBT0F6QyxFQUFFa0UsTUFBTSxTQUFVekI7SUFDaEIsT0FBT2xDLEtBQUtpQyxJQUFJQyxLQUFLO0FBQ3ZCOztBQU1BekMsRUFBRW1FLFFBQVFuRSxFQUFFb0UsTUFBTSxTQUFVM0I7SUFDMUIsSUFBSXpCLEdBQUc0QixHQUFHeUIsR0FBR0MsTUFDWGhFLElBQUlDLE1BQ0pILE1BQU1FLEVBQUVPLGFBQ1JrQyxJQUFJekMsRUFBRUUsR0FDTndDLEtBQUtQLElBQUksSUFBSXJDLElBQUlxQyxJQUFJakM7SUFHdkIsSUFBSXVDLEtBQUtDLEdBQUc7UUFDVlAsRUFBRWpDLEtBQUt3QztRQUNQLE9BQU8xQyxFQUFFaUUsS0FBSzlCO0FBQ2Y7SUFFRCxJQUFJWCxLQUFLeEIsRUFBRUksRUFBRUMsU0FDWDZELEtBQUtsRSxFQUFFRyxHQUNQa0MsS0FBS0YsRUFBRS9CLEdBQ1ArRCxLQUFLaEMsRUFBRWhDO0lBR1QsS0FBS3FCLEdBQUcsT0FBT2EsR0FBRyxJQUFJO1FBR3BCLE9BQU9BLEdBQUcsTUFBTUYsRUFBRWpDLEtBQUt3QyxHQUFHUCxLQUFLLElBQUlyQyxJQUFJMEIsR0FBRyxLQUFLeEIsSUFBSTtBQUNwRDtJQUdELElBQUl5QyxJQUFJeUIsS0FBS0MsSUFBSTtRQUVmLElBQUlILE9BQU92QixJQUFJLEdBQUc7WUFDaEJBLEtBQUtBO1lBQ0xzQixJQUFJdkM7QUFDVixlQUFXO1lBQ0wyQyxLQUFLRDtZQUNMSCxJQUFJMUI7QUFDTDtRQUVEMEIsRUFBRUs7UUFDRixLQUFLMUIsSUFBSUQsR0FBR0MsT0FBTXFCLEVBQUVoQyxLQUFLO1FBQ3pCZ0MsRUFBRUs7QUFDTixXQUFTO1FBR0w5QixNQUFNMEIsT0FBT3hDLEdBQUdMLFNBQVNrQixHQUFHbEIsVUFBVUssS0FBS2EsSUFBSWxCO1FBRS9DLEtBQUtzQixJQUFJQyxJQUFJLEdBQUdBLElBQUlKLEdBQUdJLEtBQUs7WUFDMUIsSUFBSWxCLEdBQUdrQixNQUFNTCxHQUFHSyxJQUFJO2dCQUNsQnNCLE9BQU94QyxHQUFHa0IsS0FBS0wsR0FBR0s7Z0JBQ2xCO0FBQ0Q7QUFDRjtBQUNGO0lBR0QsSUFBSXNCLE1BQU07UUFDUkQsSUFBSXZDO1FBQ0pBLEtBQUthO1FBQ0xBLEtBQUswQjtRQUNMNUIsRUFBRWpDLEtBQUtpQyxFQUFFakM7QUFDVjtJQU1ELEtBQUt3QyxLQUFLSixJQUFJRCxHQUFHbEIsV0FBV1QsSUFBSWMsR0FBR0wsV0FBVyxHQUFHLE1BQU91QixPQUFNbEIsR0FBR2QsT0FBTztJQUd4RSxLQUFLZ0MsSUFBSWhDLEdBQUc0QixJQUFJRyxLQUFJO1FBQ2xCLElBQUlqQixLQUFLYyxLQUFLRCxHQUFHQyxJQUFJO1lBQ25CLEtBQUs1QixJQUFJNEIsR0FBRzVCLE1BQU1jLEtBQUtkLE1BQUtjLEdBQUdkLEtBQUs7Y0FDbENjLEdBQUdkO1lBQ0xjLEdBQUdjLE1BQU07QUFDVjtRQUVEZCxHQUFHYyxNQUFNRCxHQUFHQztBQUNiO0lBR0QsTUFBT2QsS0FBS2tCLE9BQU8sS0FBSWxCLEdBQUdFO0lBRzFCLE1BQU9GLEdBQUcsT0FBTyxLQUFJO1FBQ25CQSxHQUFHK0I7VUFDRFk7QUFDSDtJQUVELEtBQUszQyxHQUFHLElBQUk7UUFHVlcsRUFBRWpDLElBQUk7UUFHTnNCLEtBQUssRUFBQzJDLEtBQUs7QUFDWjtJQUVEaEMsRUFBRS9CLElBQUlvQjtJQUNOVyxFQUFFaEMsSUFBSWdFO0lBRU4sT0FBT2hDO0FBQ1Q7O0FBTUF6QyxFQUFFMkUsTUFBTSxTQUFVbEM7SUFDaEIsSUFBSW1DLE1BQ0Z0RSxJQUFJQyxNQUNKSCxNQUFNRSxFQUFFTyxhQUNSa0MsSUFBSXpDLEVBQUVFLEdBQ053QyxLQUFLUCxJQUFJLElBQUlyQyxJQUFJcUMsSUFBSWpDO0lBRXZCLEtBQUtpQyxFQUFFL0IsRUFBRSxJQUFJLE1BQU1TLE1BQU1wQjtJQUV6Qk8sRUFBRUUsSUFBSWlDLEVBQUVqQyxJQUFJO0lBQ1pvRSxPQUFPbkMsRUFBRUQsSUFBSWxDLE1BQU07SUFDbkJBLEVBQUVFLElBQUl1QztJQUNOTixFQUFFakMsSUFBSXdDO0lBRU4sSUFBSTRCLE1BQU0sT0FBTyxJQUFJeEUsSUFBSUU7SUFFekJ5QyxJQUFJM0MsSUFBSWY7SUFDUjJELElBQUk1QyxJQUFJZDtJQUNSYyxJQUFJZixLQUFLZSxJQUFJZCxLQUFLO0lBQ2xCZ0IsSUFBSUEsRUFBRXdDLElBQUlMO0lBQ1ZyQyxJQUFJZixLQUFLMEQ7SUFDVDNDLElBQUlkLEtBQUswRDtJQUVULE9BQU96QyxLQUFLNEQsTUFBTTdELEVBQUV1RSxNQUFNcEM7QUFDNUI7O0FBTUF6QyxFQUFFdUUsT0FBT3ZFLEVBQUU4RSxNQUFNLFNBQVVyQztJQUN6QixJQUFJNEIsR0FDRi9ELElBQUlDLE1BQ0pILE1BQU1FLEVBQUVPLGFBQ1JrQyxJQUFJekMsRUFBRUUsR0FDTndDLEtBQUtQLElBQUksSUFBSXJDLElBQUlxQyxJQUFJakM7SUFHdkIsSUFBSXVDLEtBQUtDLEdBQUc7UUFDVlAsRUFBRWpDLEtBQUt3QztRQUNQLE9BQU8xQyxFQUFFNkQsTUFBTTFCO0FBQ2hCO0lBRUQsSUFBSStCLEtBQUtsRSxFQUFFRyxHQUNUcUIsS0FBS3hCLEVBQUVJLEdBQ1ArRCxLQUFLaEMsRUFBRWhDLEdBQ1BrQyxLQUFLRixFQUFFL0I7SUFHVCxLQUFLb0IsR0FBRyxPQUFPYSxHQUFHLElBQUksT0FBT0EsR0FBRyxLQUFLRixJQUFJLElBQUlyQyxJQUFJMEIsR0FBRyxLQUFLeEIsSUFBSXlDLElBQUk7SUFFakVqQixLQUFLQSxHQUFHbkI7SUFJUixJQUFJb0MsSUFBSXlCLEtBQUtDLElBQUk7UUFDZixJQUFJMUIsSUFBSSxHQUFHO1lBQ1QwQixLQUFLRDtZQUNMSCxJQUFJMUI7QUFDVixlQUFXO1lBQ0xJLEtBQUtBO1lBQ0xzQixJQUFJdkM7QUFDTDtRQUVEdUMsRUFBRUs7UUFDRixNQUFPM0IsT0FBTXNCLEVBQUVoQyxLQUFLO1FBQ3BCZ0MsRUFBRUs7QUFDSDtJQUdELElBQUk1QyxHQUFHTCxTQUFTa0IsR0FBR2xCLFNBQVMsR0FBRztRQUM3QjRDLElBQUkxQjtRQUNKQSxLQUFLYjtRQUNMQSxLQUFLdUM7QUFDTjtJQUVEdEIsSUFBSUosR0FBR2xCO0lBR1AsS0FBS3VCLElBQUksR0FBR0QsR0FBR2pCLEdBQUdpQixNQUFNLElBQUlDLEtBQUtsQixLQUFLaUIsS0FBS2pCLEdBQUdpQixLQUFLSixHQUFHSSxLQUFLQyxLQUFLLEtBQUs7SUFJckUsSUFBSUEsR0FBRztRQUNMbEIsR0FBR0MsUUFBUWlCO1VBQ1R5QjtBQUNIO0lBR0QsS0FBSzFCLElBQUlqQixHQUFHTCxRQUFRSyxLQUFLaUIsT0FBTyxLQUFJakIsR0FBR0U7SUFFdkNTLEVBQUUvQixJQUFJb0I7SUFDTlcsRUFBRWhDLElBQUlnRTtJQUVOLE9BQU9oQztBQUNUOztBQVVBekMsRUFBRStFLE1BQU0sU0FBVTFFO0lBQ2hCLElBQUlDLElBQUlDLE1BQ055RSxNQUFNLElBQUkxRSxFQUFFTyxZQUFZLElBQ3hCNEIsSUFBSXVDLEtBQ0p0QyxRQUFRckMsSUFBSTtJQUVkLElBQUlBLFFBQVFBLEtBQUtBLEtBQUtiLGFBQWFhLElBQUliLFdBQVcsTUFBTTJCLE1BQU12QixVQUFVO0lBQ3hFLElBQUk4QyxPQUFPckMsS0FBS0E7SUFFaEIsU0FBUztRQUNQLElBQUlBLElBQUksR0FBR29DLElBQUlBLEVBQUVvQyxNQUFNdkU7UUFDdkJELE1BQU07UUFDTixLQUFLQSxHQUFHO1FBQ1JDLElBQUlBLEVBQUV1RSxNQUFNdkU7QUFDYjtJQUVELE9BQU9vQyxRQUFRc0MsSUFBSWxDLElBQUlMLEtBQUtBO0FBQzlCOztBQWFBekMsRUFBRTBCLFFBQVEsU0FBVUMsSUFBSUM7SUFDdEIsSUFBSXhCLE1BQU1HLEtBQUtNO0lBQ2YsSUFBSWMsT0FBTzFCLFdBQVcwQixLQUFLLFFBQ3RCLElBQUlBLFNBQVNBLE1BQU1BLE1BQU1wQyxVQUFVb0MsS0FBS3BDLFFBQVEsTUFBTTRCLE1BQU10QjtJQUNqRSxPQUFPNkIsTUFBTSxJQUFJdEIsSUFBSUcsT0FBT29CLElBQUlDLE9BQU8zQixZQUFZRyxJQUFJZCxLQUFLc0M7QUFDOUQ7O0FBT0E1QixFQUFFaUYsT0FBTztJQUNQLElBQUkxQixHQUFHN0MsR0FBRzJELEdBQ1IvRCxJQUFJQyxNQUNKSCxNQUFNRSxFQUFFTyxhQUNSTCxJQUFJRixFQUFFRSxHQUNOQyxJQUFJSCxFQUFFRyxHQUNOeUUsT0FBTyxJQUFJOUUsSUFBSTtJQUdqQixLQUFLRSxFQUFFSSxFQUFFLElBQUksT0FBTyxJQUFJTixJQUFJRTtJQUc1QixJQUFJRSxJQUFJLEdBQUcsTUFBTVcsTUFBTXhCLE9BQU87SUFHOUJhLElBQUkyRSxLQUFLRixLQUFLM0UsSUFBSTtJQUlsQixJQUFJRSxNQUFNLEtBQUtBLE1BQU0sSUFBSSxHQUFHO1FBQzFCRSxJQUFJSixFQUFFSSxFQUFFNEIsS0FBSztRQUNiLE1BQU01QixFQUFFZSxTQUFTaEIsSUFBSSxJQUFJQyxLQUFLO1FBQzlCRixJQUFJMkUsS0FBS0YsS0FBS3ZFO1FBQ2RELE1BQU1BLElBQUksS0FBSyxJQUFJLE1BQU1BLElBQUksS0FBS0EsSUFBSTtRQUN0QzhDLElBQUksSUFBSW5ELEtBQUtJLEtBQUssSUFBSSxJQUFJLFFBQVFBLElBQUlBLEVBQUU0RSxpQkFBaUJ6RSxNQUFNLEdBQUdILEVBQUVhLFFBQVEsT0FBTyxNQUFNWjtBQUM3RixXQUFTO1FBQ0w4QyxJQUFJLElBQUluRCxJQUFJSTtBQUNiO0lBRURDLElBQUk4QyxFQUFFOUMsS0FBS0wsSUFBSWYsTUFBTTtJQUdyQixHQUFHO1FBQ0RnRixJQUFJZDtRQUNKQSxJQUFJMkIsS0FBS0wsTUFBTVIsRUFBRUUsS0FBS2pFLEVBQUV3QyxJQUFJdUI7QUFDaEMsYUFBV0EsRUFBRTNELEVBQUVDLE1BQU0sR0FBR0YsR0FBRzZCLEtBQUssUUFBUWlCLEVBQUU3QyxFQUFFQyxNQUFNLEdBQUdGLEdBQUc2QixLQUFLO0lBRTNELE9BQU9aLE1BQU02QixHQUFHbkQsSUFBSWYsTUFBTSxHQUFHZSxJQUFJZDtBQUNuQzs7QUFNQVUsRUFBRTZFLFFBQVE3RSxFQUFFcUYsTUFBTSxTQUFVNUM7SUFDMUIsSUFBSS9CLEdBQ0ZKLElBQUlDLE1BQ0pILE1BQU1FLEVBQUVPLGFBQ1JpQixLQUFLeEIsRUFBRUksR0FDUGlDLE1BQU1GLElBQUksSUFBSXJDLElBQUlxQyxJQUFJL0IsR0FDdEJxQyxJQUFJakIsR0FBR0wsUUFDUHVCLElBQUlMLEdBQUdsQixRQUNQVCxJQUFJVixFQUFFRyxHQUNObUMsSUFBSUgsRUFBRWhDO0lBR1JnQyxFQUFFakMsSUFBSUYsRUFBRUUsS0FBS2lDLEVBQUVqQyxJQUFJLEtBQUs7SUFHeEIsS0FBS3NCLEdBQUcsT0FBT2EsR0FBRyxJQUFJLE9BQU8sSUFBSXZDLElBQUlxQyxFQUFFakMsSUFBSTtJQUczQ2lDLEVBQUVoQyxJQUFJTyxJQUFJNEI7SUFHVixJQUFJRyxJQUFJQyxHQUFHO1FBQ1R0QyxJQUFJb0I7UUFDSkEsS0FBS2E7UUFDTEEsS0FBS2pDO1FBQ0xrQyxJQUFJRztRQUNKQSxJQUFJQztRQUNKQSxJQUFJSjtBQUNMO0lBR0QsS0FBS2xDLElBQUksSUFBSTRFLE1BQU0xQyxJQUFJRyxJQUFJQyxJQUFJSixPQUFNbEMsRUFBRWtDLEtBQUs7SUFLNUMsS0FBSzVCLElBQUlnQyxHQUFHaEMsT0FBTTtRQUNoQmdDLElBQUk7UUFHSixLQUFLSixJQUFJRyxJQUFJL0IsR0FBRzRCLElBQUk1QixLQUFJO1lBR3RCZ0MsSUFBSXRDLEVBQUVrQyxLQUFLRCxHQUFHM0IsS0FBS2MsR0FBR2MsSUFBSTVCLElBQUksS0FBS2dDO1lBQ25DdEMsRUFBRWtDLE9BQU9JLElBQUk7WUFHYkEsSUFBSUEsSUFBSSxLQUFLO0FBQ2Q7UUFFRHRDLEVBQUVrQyxNQUFNbEMsRUFBRWtDLEtBQUtJLEtBQUs7QUFDckI7SUFHRCxJQUFJQSxLQUFLUCxFQUFFaEMsUUFDTkMsRUFBRW1EO0lBR1AsS0FBSzdDLElBQUlOLEVBQUVlLFNBQVNmLElBQUlNLE1BQUtOLEVBQUVzQjtJQUMvQlMsRUFBRS9CLElBQUlBO0lBRU4sT0FBTytCO0FBQ1Q7O0FBU0F6QyxFQUFFb0YsZ0JBQWdCLFNBQVV6RDtJQUMxQixPQUFPTSxVQUFVMUIsTUFBTSxHQUFHb0IsSUFBSUE7QUFDaEM7O0FBWUEzQixFQUFFdUYsVUFBVSxTQUFVNUQ7SUFDcEIsT0FBT00sVUFBVTFCLE1BQU0sR0FBR29CLElBQUlwQixLQUFLRSxJQUFJa0I7QUFDekM7O0FBVUEzQixFQUFFd0YsY0FBYyxTQUFVQztJQUN4QixPQUFPeEQsVUFBVTFCLE1BQU0sR0FBR2tGLElBQUlBLEtBQUs7QUFDckM7O0FBU0F6RixFQUFFMEYsV0FBVztJQUNYLE9BQU96RCxVQUFVMUI7QUFDbkI7O0FBU0FQLEVBQUUyRixVQUFVM0YsRUFBRTRGLFNBQVM7SUFDckIsT0FBTzNELFVBQVUxQixNQUFNO0FBQ3pCOztBQU1PLElBQUlILE1BQU1EOztBQ2o1QmpCLFNBQVMyRSxJQUFJeEUsR0FBR21DO0lBQ1osT0FBTyxJQUFJckMsSUFBSUUsR0FBR2lFLEtBQUs5QixHQUFHaUQ7QUFDOUI7O0FBUUEsU0FBU0csU0FBU3ZGLEdBQUdtQztJQUNqQixPQUFPLElBQUlyQyxJQUFJRSxHQUFHNkQsTUFBTTFCLEdBQUdpRDtBQUMvQjs7QUFRQSxTQUFTSSxTQUFTeEYsR0FBR21DO0lBQ2pCLE9BQU8sSUFBSXJDLElBQUlFLEdBQUd1RSxNQUFNcEMsR0FBR2lEO0FBQy9COztBQWtCQSxTQUFTSyxPQUFPQyxPQUFPQztJQUN0QjdGLElBQUlYLE1BQU07SUFDUCxNQUFNeUcsV0FBVyxJQUFJOUYsSUFBSTRGO0lBQ3pCLElBQUlHLGNBQWNELFNBQVNSO0lBRTNCLElBQUlTLFlBQVlDLFNBQVMsTUFBTTtRQUMzQixJQUFJQyxXQUFXRixZQUFZRyxNQUFNO1FBQ2pDLElBQUlELFNBQVMsR0FBRzVFLFVBQVV3RSxXQUFXO1lBQ2pDLElBQUksS0FBS0EsV0FBVztnQkFDaEIsT0FBT0ksU0FBUztBQUNuQixtQkFDSTtnQkFFRCxJQUFJRSxXQUFXRixTQUFTLEdBQUc3RSxVQUFVLEdBQUd5RTtnQkFDeEMsT0FBTyxHQUFHSSxTQUFTLE1BQU1FO0FBQzVCO0FBQ0osZUFDSTtZQUVELElBQUlDLGFBQWFQLFlBQVlJLFNBQVMsR0FBRzVFO1lBQ3pDLElBQUlnRixNQUFNO1lBQ1YsS0FBSyxJQUFJekYsSUFBSSxHQUFHQSxJQUFJd0YsWUFBWXhGLEtBQUs7Z0JBQ2pDeUYsT0FBTztBQUNWO1lBQ0QsT0FBTyxHQUFHTixjQUFjTTtBQUMzQjtBQUNKLFdBQ0k7UUFDRCxJQUFJLEtBQUtSLFdBQVc7WUFDaEIsT0FBT0U7QUFDVixlQUNJO1lBQ0QsSUFBSUssYUFBYVA7WUFDakIsSUFBSVEsTUFBTTtZQUNWLEtBQUssSUFBSXpGLElBQUksR0FBR0EsSUFBSXdGLFlBQVl4RixLQUFLO2dCQUNqQ3lGLE9BQU87QUFDVjtZQUNELE9BQU8sR0FBR04sZUFBZU07QUFDNUI7QUFDSjtBQUNMOztBQU9BLFNBQVNDLFVBQVVDO0lBQ2YsSUFBSXJCLE1BQU1zQixRQUFRRCxNQUFNO1FBQ3BCLE9BQU9BLElBQUlFLEtBQUtiLFNBQVU1RixJQUFJNEYsT0FBT1Q7QUFDN0MsV0FBVztRQUNILE9BQU9uRixJQUFJdUcsS0FBS3BCO0FBQ25CO0FBQ0w7O0FDbEdBbkYsSUFBSWYsS0FBSzs7QUFDVGUsSUFBSWQsS0FBSzs7QUFDVCxJQUFJd0gsWUFBWTs7QUFJVCxTQUFTQyxhQUFhQyxZQUFZQyxxQkFBcUJDLFlBQVk7SUFBRUMsVUFBQUE7ZUFBVUM7SUFBU0MsVUFBRUE7SUFBVUM7SUFBU0M7SUFBU0M7O0lBQ3pIQyxRQUFRQyxJQUFJLGNBQWNWO0lBQzFCVyxNQUFNWCxjQUFjQztJQUNwQlcsT0FBT1osY0FBYztRQUNqQkcsaUJBQWlCRCxVQUFVQyxZQUFZLGNBQWNBLGFBQVdELFVBQVVDO1FBQzFFQyxrQkFBa0JGLFVBQVVFLGFBQWEsY0FBY0EsY0FBWUYsVUFBVUU7UUFDN0VDLGlCQUFpQkgsVUFBVUcsWUFBWSxjQUFjQSxhQUFXSCxVQUFVRztRQUMxRUMsZ0JBQWdCSixVQUFVSSxXQUFXLGNBQWNBLFVBQVVKLFVBQVVJO1FBQ3ZFQyxnQkFBZ0JMLFVBQVVLLFdBQVcsY0FBY0EsVUFBVUwsVUFBVUs7UUFDdkVDLGVBQWVOLFVBQVVNLFVBQVUsY0FBY0EsU0FBU04sVUFBVU07O0lBRXhFLE9BQU87UUFDSEssWUFBWUYsTUFBTVg7UUFDbEJjLGFBQWFGLE9BQU9aOztBQUU1Qjs7QUFFT2UsZUFBZUMsVUFBVUMsUUFBUSxJQUFJQyxhQUFhLENBQUE7SUFDckQsTUFBTUMsaUJBQWlCQyxLQUFLbkcsVUFBVWlHO0lBQ3RDVCxRQUFRQyxJQUFJLG9CQUFvQk8sMkJBQTJCRTtJQUMzRCxJQUFJdEIsTUFBTTtRQUNOb0IsT0FBT0E7UUFDUEMsWUFBWUM7O1VBRVZFLFdBQVdMLFVBQVVuQjtBQUMvQjs7QUFFQSxTQUFTTTtJQUNMTSxRQUFRQyxJQUFJO0FBQ2hCOztBQUVBLFNBQVNOLGVBQ1Q7O0FBRUEsU0FBU0MsY0FDVDs7QUFFQSxTQUFTQyxXQUNUOztBQUVBLFNBQVNDLFdBQ1Q7O0FBRUEsU0FBU0MsVUFDVDs7QUFFTyxJQUFJYyxhQUFhO0lBQ3BCQyxnQkFBZ0I7SUFDaEJDLFdBQVc7SUFDWEMsSUFBSTtJQUNKQyxZQUFZO0lBQ1pDLFlBQVk7SUFDWkMsT0FBTztJQUNQQyxVQUFVO0lBQ1ZDLGNBQWM7SUFDZEMsUUFBUTtJQUNSQyxXQUFXO0lBQ1hDLHNCQUFzQjtJQUN0QkMsV0FBVzs7O0FBRWZ2QixNQUFNVyxhQUFhQTs7QUFHWlAsZUFBZW9CLFFBQVFDO0lBQzFCLEtBQUt0QyxXQUFXO1FBQ1o7QUFDSDtJQUNEVyxRQUFRQyxJQUFJLGFBQWEwQjtJQUN6QixJQUFJQSxPQUFPQSxPQUFPLFFBQVFBLElBQUkzSCxTQUFTLEdBQUc7Y0FDaEM0RyxXQUFXZ0IsVUFBVUQ7QUFDOUI7SUFDRHRDLFlBQVk7SUFDWndDLFlBQVc7UUFDUHhDLFlBQVk7UUFDYjtBQUNQOztBQUdPLFNBQVN5QyxnQkFBZ0JDO0lBQzVCL0IsUUFBUUMsSUFBSThCO0lBQ1psQixXQUFXQyxpQkFBaUJrQixTQUFTRCxNQUFNakI7SUFDM0NELFdBQVdFLFlBQVlpQixTQUFTRCxNQUFNaEI7SUFDdENGLFdBQVdHLEtBQUtnQixTQUFTRCxNQUFNZjtJQUMvQkgsV0FBV0ksYUFBYWMsTUFBTWQ7SUFDOUJKLFdBQVdLLGFBQWFjLFNBQVNELE1BQU1iO0lBQ3ZDTCxXQUFXTyxXQUFXVyxNQUFNWDtJQUM1QlAsV0FBV00sUUFBUVksTUFBTVo7SUFDekJOLFdBQVdRLGVBQWVVLE1BQU1WO0lBQ2hDUixXQUFXUyxTQUFTUyxNQUFNVDtJQUMxQlQsV0FBV1UsWUFBWVEsTUFBTVI7SUFDN0JWLFdBQVdXLHVCQUF1Qk8sTUFBTVA7SUFDeENYLFdBQVdZLFlBQVlNLE1BQU1OO0lBQzdCdkIsTUFBTVcsYUFBYUE7QUFDdkI7O0FBRU8sU0FBU29CLHdCQUF3QkM7SUFDcEMsSUFBSUMsVUFBVXRCLFdBQVdNLFFBQVFOLFdBQVdNLFFBQVE7SUFDaEQsT0FBTyxHQUFHZ0IsbURBQW1ERCxTQUFTRTtBQUM5RTs7QUEyQk85QixlQUFlK0IsWUFBWUMsTUFBTUMsU0FBUyxJQUFJQyxTQUFTLEdBQUdDLFdBQVcsR0FBR0MsU0FBUztJQUNwRjFDLFFBQVFDLElBQUksV0FBV3FDLGdCQUFnQjNCLEtBQUtuRyxVQUFVK0g7SUFFdEQsSUFBSUUsWUFBWSxLQUFLQSxZQUFZLEdBQUc7UUFDaENDLE9BQU8sa0JBQWtCO0FBQzVCO0lBQ0RBLE9BQU8sbUJBQW1CN0IsV0FBV1k7SUFFckMsTUFBTU0sUUFBUTtRQUNWTztRQUNBRTtRQUNBQztRQUNBQztRQUNBSDs7SUFFSjtRQUNJLElBQUlJLHVCQUF1Qi9CLFdBQVdnQyxRQUFRakMsS0FBS25HLFVBQVV1SDtRQUU3RCxJQUFJYyxXQUFXbEMsS0FBS3hILE1BQU13SjtRQUMxQixLQUFJRyxNQUFFQSxNQUFJQyxNQUFFQSxRQUFTRjtRQUNyQixJQUFJLEtBQUtKLFVBQVU7WUFFZixJQUFJTyxTQUFTSCxTQUFTRztZQUN0QixJQUFJQyxXQUFXSixTQUFTSTtZQUN4QixJQUFJQyxVQUFVTCxTQUFTSztZQUN2QixJQUFJRixVQUFVLE1BQU07Z0JBQ2hCaEQsUUFBUUMsSUFBSSxXQUFXcUM7Z0JBQ3ZCLFdBQVdTLFNBQVMsVUFBVTtvQkFDMUIsSUFBSUksUUFBUTtvQkFDWixJQUFJQyxhQUFhVCxlQUFlL0ksUUFBUXVKO29CQUN4QyxJQUFJRSxNQUFNO29CQUNWLElBQUlDLFdBQVdYLGVBQWUvSSxRQUFReUo7b0JBQ3RDLElBQUlFLGFBQWFaLGVBQWU1SSxVQUFVcUosYUFBYUQsTUFBTW5KLFFBQVFzSjtvQkFDckV0RCxRQUFRQyxJQUFJLHVDQUF1Q3NEO29CQUNuRCxPQUFPQTtBQUNWO2dCQUNELE9BQU9SO0FBQ3ZCLG1CQUFtQjtnQkFDSC9DLFFBQVFDLElBQUksd0JBQXdCZ0QscUJBQXFCQztnQkFDekQsSUFBSVYsVUFBVSxHQUFHO29CQUNiZ0IsVUFBVU47QUFDYjtnQkFDRCxPQUFPO0FBQ1Y7QUFDSixlQUFNLElBQUlKLFFBQVEsT0FBT0QsU0FBU0csVUFBVSxNQUFNO1lBQy9DaEQsUUFBUUMsSUFBSSxXQUFXcUM7WUFDdkIsT0FBT1M7QUFDbkIsZUFBZTtZQUNIL0MsUUFBUUMsSUFBSSx3QkFBd0I2QztZQUNwQyxJQUFJVyxVQUFVWixTQUFTWTtZQUN2QixJQUFJakIsVUFBVSxLQUFLaUIsU0FBUztnQkFDeEJELFVBQVVDO0FBQ2I7WUFDRCxPQUFPO0FBQ1Y7QUFDSixNQUFDLE9BQU96SztRQUNMZ0gsUUFBUUMsSUFBSSx3QkFBd0JqSDtRQUNwQyxPQUFPO0FBQ1Y7QUFDTDs7QUFHT3NILGVBQWVrRCxVQUFVRTtVQUN0QjlDLFdBQVcrQyxRQUFRRDtBQUM3Qjs7QUFNTyxTQUFTRSxZQUFZQyxTQUFTO0lBQ2pDakQsV0FBV2dELFlBQVlDLFNBQVMsSUFBSTtBQUN4Qzs7QUFPQUMsS0FBS3pLLFVBQVUwSyxTQUFTLFNBQVVDO0lBQzlCLElBQUlDLElBQUk7UUFDSixNQUFNbkwsS0FBS29MLGFBQWE7UUFDeEIsTUFBTXBMLEtBQUtxTDtRQUNYLE1BQU1yTCxLQUFLc0w7UUFDWCxNQUFNdEwsS0FBS3VMO1FBQ1gsTUFBTXZMLEtBQUt3TDtRQUNYLE1BQU01RyxLQUFLNkcsT0FBT3pMLEtBQUtvTCxhQUFhLEtBQUs7UUFDekNNLEdBQUsxTCxLQUFLMkw7O0lBRWQsSUFBSSxPQUFPaEwsS0FBS3VLLE1BQU1BLE1BQU1BLElBQUluSyxRQUFRNkssT0FBT0MsS0FBSzdMLEtBQUs4TCxnQkFBZ0IsSUFBSUMsT0FBTyxJQUFJSCxPQUFPQyxHQUFHM0s7SUFDbEcsS0FBSyxJQUFJVSxLQUFLdUosR0FDVixJQUFJLElBQUlTLE9BQU8sTUFBTWhLLElBQUksS0FBS2pCLEtBQUt1SyxNQUFNQSxNQUFNQSxJQUFJbkssUUFBUTZLLE9BQU9DLElBQUtELE9BQU9DLEdBQUczSyxVQUFVLElBQU1pSyxFQUFFdkosTUFBUSxPQUFPdUosRUFBRXZKLElBQUltSyxRQUFRLEtBQUtaLEVBQUV2SixJQUFJVjtJQUMvSSxPQUFPZ0s7QUFDWDs7QUFHTyxTQUFTYyxnQkFBZ0J2RyxPQUFPQztJQUNuQztRQUNJLE1BQU11RyxTQUFTQyxPQUFjekcsT0FBT0M7UUFDcEMsT0FBT3VHO0FBQ1YsTUFBQyxPQUFPL0w7UUFDTGdILFFBQVFDLElBQUlqSDtRQUNaLE9BQU91RixNQUFNVCxRQUFRVTtBQUN4QjtBQUNMOztBQUdPLFNBQVN5RyxlQUFlQyxVQUFVMUc7SUFDckMsTUFBTUMsV0FBVyxJQUFJOUYsSUFBSXVNO0lBQ3pCLE1BQU1DLGNBQWMzRyxjQUFjLElBQUlDLFNBQVNSLGFBQWFRLFNBQVNYLFFBQVFVO0lBQzdFLE1BQU00RyxnQkFBZ0JELFlBQVl0TCxRQUFRLFFBQU8sU0FBVWpCO1FBQ3ZELE9BQU9BLEVBQUVpQixRQUFRLHVCQUFzQixTQUFVOEs7WUFDN0MsT0FBT0EsS0FBSztBQUN4QjtBQUNBO0lBRUksT0FBT1M7QUFDWDs7QUFZTyxTQUFTQyxjQUFjOUMsU0FBUztJQUNuQ3ZDLFFBQVFDLElBQUk7SUFDWlcsV0FBV3lFLGNBQWM5QztBQUM3Qjs7QUFHT2pDLGVBQWVnRixpQkFBaUJDO0lBQ25DdkYsUUFBUUMsSUFBSSxtQkFBbUJzRjtJQUMvQixJQUFJQSxXQUFXQSxXQUFXLE1BQU07UUFDNUIsSUFBSUEsUUFBUTNMLFFBQVEsZUFBZSxLQUFLMkwsUUFBUTNMLFFBQVEsV0FBVyxHQUFHO1lBQ2xFOEgsUUFBUTZEO0FBQ3BCLGVBQWU7WUFDSDdELFFBQVEsR0FBR2IsV0FBV00sU0FBU04sV0FBV08sV0FBV21FO0FBQ3hEO0FBQ0o7QUFDTDs7QUFHT2pGLGVBQWVrRixLQUFLQyxRQUFRQyxLQUFLM0M7VUFDOUJuQyxXQUFXK0UsUUFBUTtRQUN2QkMsUUFBUTtRQUNSQyxNQUFNSjtRQUNOQyxLQUFLQTtRQUNMM0MsTUFBTXBDLEtBQUtuRyxVQUFVdUk7O0FBRXhCOztBQUdNekMsZUFBZXdGLEtBQUtMLFFBQVFDO0lBQ2pDLE1BQU0zQyxhQUFhbkMsV0FBVytFLFFBQVE7UUFDcENDLFFBQVE7UUFDUkMsTUFBTUo7UUFDTkMsS0FBS0E7O0lBRVAsSUFBSTNDLFFBQVFBLFFBQVEsSUFBSTtRQUN0QixPQUFPcEMsS0FBS3hILE1BQU00SjtBQUNuQjtJQUNELE9BQU87QUFDUjs7QUFxRUksU0FBU2dELGlCQUFpQkM7SUFDN0IsT0FBT0EsSUFBSW5NLFFBQVEsd0JBQXdCO0FBQy9DOztBQUtPLFNBQVNvTSxtQkFBbUJqSDtJQUNqQyxJQUFJQSxPQUFPLFFBQVFBLE9BQU9rSCxXQUFXO1FBQ25DLE9BQU87QUFDUjtJQUNELElBQUluQixTQUFTL0Y7SUFDYixJQUFJNkIsV0FBV0csTUFBTSxHQUFHO1FBQ3RCK0QsU0FBUy9GLElBQUluRixRQUFRLE9BQU87QUFDN0I7SUFDRCxPQUFPa0w7QUFDVDs7QUMvWEEsTUFBTW9CLFFBQU07O0FBTUwsTUFBTUMsZ0JBQWdCO0lBRTNCQyxlQUFlO0lBQ2ZDLGtCQUFrQjtJQUNsQkMsZ0JBQWdCO0lBRWhCQyxnQkFBZ0I7SUFDaEJDLG1CQUFtQjtJQUNuQkMsaUJBQWlCO0lBR2pCQyxZQUFZO0lBQ1pDLGFBQWE7SUFDYkMsZUFBZTs7O0FBR1YsTUFBTUM7SUFDWEMsTUFBUTtJQUNSQyxjQUFnQjtJQUNoQkMsZ0JBQWtCO0lBQ2xCQyxlQUFpQjtJQUNqQkMsSUFBTTtJQUNOQyxXQUFhO0lBQ2JDLFVBQVk7SUFDWkMsUUFBVTtJQUNWQyxXQUFhO0lBQ2I5TSxHQUFLO0lBQ0wrTSxPQUFTO0lBRVRDLE9BQVM7SUFDVEMsUUFBVTtJQUNWQyxZQUFjO0lBQ2RDLFlBQWM7SUFDZEMsV0FBYTtJQUNiQyxZQUFjO0lBQ2RDLE9BQVM7SUFDVEMsS0FBTztJQUNQLFNBQUFDLENBQVVUO1FBQ1IxTyxLQUFLME8sU0FBU0E7UUFDZCxJQUFJQSxVQUFVLEdBQUc7WUFDZjFPLEtBQUtpUCxTQUFTO0FBQ3BCLGVBQVc7WUFDTGpQLEtBQUtpUCxTQUFTO0FBQ2Y7QUFDRjtJQUVELE1BQUFHLENBQU9mO1FBQ0xyTyxLQUFLcU8sTUFBTUE7UUFDWHJPLEtBQUs0TyxVQUFVUyxnQkFBdUJDLFNBQWdCakIsS0FBSyxNQUFNO0FBQ2xFO0lBRUQsVUFBQWtCLENBQVdmO1FBQ1R4TyxLQUFLd08sVUFBVUE7UUFDZnhPLEtBQUs2TyxjQUFjVyxNQUFNQyxXQUFXQyxtQ0FBbUMsR0FBRyxJQUFJMUUsS0FBS3dELFNBQVN2RCxPQUFPO0FBQ3BHO0lBRUQsYUFBQTBFO1FBRUUzUCxLQUFLK08sYUFBYVMsTUFBTUMsV0FBV0csaUNBQ2pDLEdBQUc1UCxLQUFLbU8sbUJBQ1IsR0FBR25PLEtBQUtvTyxrQkFDUixHQUFHcE8sS0FBS2tPLGlCQUNSLEdBQUdsTyxLQUFLb08sa0JBQ1IsR0FBR3BPLEtBQUtzTztBQUVYO0lBRUQsSUFBQXVCLENBQUtDO1FBQ0g5UCxLQUFLaU8sUUFBUTZCLEtBQUs3QjtRQUNsQmpPLEtBQUtrTyxnQkFBZ0I0QixLQUFLNUI7UUFDMUJsTyxLQUFLbU8sa0JBQWtCMkIsS0FBSzNCO1FBQzVCbk8sS0FBS29PLGlCQUFpQjBCLEtBQUsxQjtRQUMzQnBPLEtBQUtvUCxPQUFPVSxLQUFLekI7UUFDakJyTyxLQUFLc08sYUFBYXdCLEtBQUt4QjtRQUN2QnRPLEtBQUtvTyxpQkFBaUIwQixLQUFLMUI7UUFDM0JwTyxLQUFLMk8sUUFBUW1CLEtBQUtuQjtRQUNsQjNPLEtBQUt1TyxZQUFZdUIsS0FBS3ZCO1FBQ3RCdk8sS0FBS3VQLFdBQVdPLEtBQUt0QjtRQUNyQnhPLEtBQUs4TyxjQUFjZ0IsS0FBS2hCO1FBQ3hCOU8sS0FBSzJQO1FBQ0wzUCxLQUFLZ1AsY0FBY2MsS0FBS2Q7UUFDeEJoUCxLQUFLMkIsS0FBS21PLEtBQUtuTztRQUNmM0IsS0FBS3lPLGFBQWFxQixLQUFLckI7UUFDdkJ6TyxLQUFLME8sU0FBU29CLEtBQUtwQjtRQUNuQjFPLEtBQUtpUCxTQUFTYSxLQUFLYjtRQUNuQmpQLEtBQUtrUCxPQUFPWSxLQUFLWjtBQUNsQjs7O0FBR0g5SCxNQUFNMkksYUFBYTtJQUNqQmhGLFFBQVE7SUFDUmlGLG1CQUFtQjtJQUNuQkMsZ0JBQWdCO0lBQ2hCQyxPQUFPO0lBRVBDLGFBQWE3QyxjQUFjQztJQUMzQjZDLGdCQUFnQjlDLGNBQWNFO0lBQzlCNkMsY0FBYy9DLGNBQWNHO0lBQzVCNkMsVUFBVWQsTUFBTWU7OztBQUdsQixTQUFTQztJQUNQLE9BQU87UUFDTE4sT0FBTztRQUVQTyxjQUFjO1FBRWRDLGNBQWM7UUFFZEMsc0JBQXNCO1FBRXRCQyxVQUFVOztBQUVkOztBQUVBLElBQUlDLGNBQVk7O0FBRWhCeEosT0FBTzBJLGFBQWE7SUFJbEJlLFdBQVcsU0FBVW5DO1FBQ25CekgsUUFBUUMsSUFBSSxnQ0FBZ0N3SCxtQkFBbUJrQztRQUMvRCxJQUFJRSxVQUFVM0osTUFBTTRKLEtBQUtDLFdBQVdKO1FBQ3BDLElBQUlLLGlCQUFpQkgsUUFBUUc7UUFDN0IsS0FBS0EsZUFBZVIsY0FBYztZQUNoQztBQUNEO1FBQ0RRLGVBQWVQLHVCQUF1QjtRQUN0Q08sZUFBZVQsY0FBYzlCO1FBQzdCd0MscUJBQXFCeEMsT0FBT3VDLGdCQUFnQjtBQUM3QztJQUtERSx1QkFBdUIsU0FBVS9DO1FBQy9CLElBQUlPLFVBQVVTLGdCQUF1QkMsU0FBZ0JqQixLQUFLLE1BQU07UUFDaEVqSCxNQUFNMkksV0FBV0UsaUJBQWlCb0IsbUJBQ2hDN0IsTUFBTUMsV0FBVzZCLDhCQUE4QixHQUFHMUM7QUFFckQ7SUFLRDJDLFNBQVM7UUFDUCxJQUFJUixVQUFVM0osTUFBTTRKLEtBQUtDLFdBQVdKO1FBQ3BDLElBQUlLLGlCQUFpQkgsUUFBUUc7UUFDN0IsS0FBS0EsZUFBZVIsY0FBYztZQUNoQ3RKLE1BQU0ySSxXQUFXaEYsU0FBUztZQUMxQjtBQUNEO1FBQ0QsSUFBSW1HLGVBQWVULGdCQUFnQixHQUFHO1lBQ3BDZSxrQkFBa0JULFNBQVMsTUFBTXZCLE1BQU1pQztBQUM3QyxlQUFXO1lBQ0xDLGVBQWVYO0FBQ2hCO1FBQ0RGLGNBQVk7UUFDWnpKLE1BQU0ySSxXQUFXaEYsU0FBUztBQUMzQjtJQUtENEcsWUFBWSxTQUFVaEQ7UUFDcEJ6SCxRQUFRQyxJQUFJLEdBQUdrRywyQkFBeUJzQixpQkFBaUJ2SCxNQUFNNEosS0FBS0MsV0FBVy9QO1FBQy9FLElBQUk2UCxVQUFVM0osTUFBTTRKLEtBQUtDLFdBQVd0QztRQUNwQ2tDLGFBQVdsQztRQUNYekgsUUFBUUMsSUFBSSxHQUFHa0csNkJBQTJCeEYsS0FBS25HLFVBQVVxUDtRQUN6RDdKLFFBQVFDLElBQUksR0FBR2tHLG9DQUFrQ3hGLEtBQUtuRyxVQUFVcVAsUUFBUUc7UUFDeEUsSUFBSUEsaUJBQWlCSCxRQUFRRztRQUM3QixJQUFJVSxjQUFjYixRQUFRYTtRQUMxQixJQUFJYixRQUFRYyxxQkFBcUIsUUFBUTtZQUN2QztBQUNEO1FBRUR6SyxNQUFNMkksV0FBV0csUUFBUWdCLGVBQWVoQjtRQUN4QyxJQUFJYSxRQUFRRyxlQUFlTixZQUFZLEdBQUc7WUFFeENrQjtZQUNBWCxxQkFBcUJELGVBQWVULGFBQWFTLGdCQUFnQjtBQUNsRSxlQUFNLElBQUlILFFBQVFHLGVBQWVOLFlBQVksR0FBRztZQUUvQ21CLHNCQUFzQkgsWUFBWXZEO1lBQ2xDOEMsc0JBQXNCLEdBQUdELGdCQUFnQjtBQUMxQztRQUNEOUosTUFBTTJJLFdBQVdoRixTQUFTO0FBQzNCO0lBRURpSCxhQUFhO1FBQ1huQixjQUFZO1FBQ1p6SixNQUFNMkksV0FBV2hGLFNBQVM7QUFDM0I7OztBQU9JLFNBQVNrSCxjQUFjbEIsU0FBU21CO0lBQ3JDLElBQUlDLFlBQVlwQixRQUFRb0I7SUFDeEIsSUFBSVAsY0FBY2IsUUFBUWE7SUFDMUIsSUFBSVYsaUJBQWlCVjtJQUVyQixNQUFNdkcsT0FBT2lJO0lBQ2JoTCxRQUFRQyxJQUFJLEdBQUdrRyw4QkFBNEJ4RixLQUFLbkcsVUFBVXVJO0lBQzFELElBQUlBLFFBQVEsTUFBTTtRQUNoQi9DLFFBQVFDLElBQUksR0FBR2tHLGlDQUErQnhGLEtBQUtuRyxVQUFVcVA7UUFFN0QsSUFBSXFCLFFBQVFDLGNBQWNwSSxTQUFTQSxLQUFLcUksV0FBV0gsY0FBYyxPQUFPLEtBQUtsSSxLQUFLcUksV0FBV0g7UUFDN0ZqTCxRQUFRQyxJQUFJLEdBQUdrRywrQkFBNkJ4RixLQUFLbkcsVUFBVTBRLHdCQUF3QnZLLEtBQUtuRyxVQUFVa1E7UUFFbEcsSUFBSVMsY0FBY1QsZ0JBQWdCUSxNQUFNbFIsVUFBVSxHQUFHO1lBQ25EZ0csUUFBUUMsSUFBSSxHQUFHa0c7WUFFZjZELGVBQWVSLGVBQWU7WUFDOUJjLGtCQUFrQlQsU0FBUyxPQUFPdkIsTUFBTStDO0FBQzlDLGVBQVcsS0FBS0YsY0FBY1QsY0FBYztZQUN0QzFLLFFBQVFDLElBQUksR0FBR2tHLDJDQUF5QytFLE1BQU1sUjtZQUM5RCxJQUFJa1IsTUFBTWxSLFVBQVUsR0FBRztnQkFFckJnUSxlQUFlUixlQUFlO2dCQUM5QmMsa0JBQWtCVCxTQUFTLE9BQU92QixNQUFNK0M7QUFDaEQsbUJBQWE7Z0JBRUxyQixlQUFlaEIsUUFBUXNDLGlCQUFpQkosT0FBT3JCO2dCQUMvQzdKLFFBQVFDLElBQUksR0FBR2tHLGlDQUErQnhGLEtBQUtuRyxVQUFVMEYsTUFBTTJJLFdBQVdHO2dCQUU5RWdCLGVBQWVSLGVBQWU7Z0JBQzlCYyxrQkFBa0JULFNBQVMsTUFBTXZCLE1BQU0rQztnQkFDdkNyQixlQUFlTixXQUFXO0FBQzNCO0FBQ1AsZUFBVztZQUNMMUosUUFBUUMsSUFBSSxHQUFHa0c7WUFFZjZELGVBQWVULGNBQWM7WUFDN0IsSUFBSWdDLE9BQU9ELGlCQUFpQkosT0FBT3JCO1lBQ25DN0osUUFBUUMsSUFBSSxHQUFHa0csZ0NBQThCeEYsS0FBS25HLFVBQVUrUTtZQUM1RHZCLGVBQWVoQixRQUFRdUM7WUFDdkJ2TCxRQUFRQyxJQUFJLEdBQUdrRyxzQ0FBb0N4RixLQUFLbkcsVUFBVStRLEtBQUssR0FBR3hFO1lBQzFFLElBQUk2QixPQUFPMkMsS0FBS3ZCLGVBQWVUO1lBQy9CdkosUUFBUUMsSUFBSSxHQUFHa0csZ0NBQThCeUMsS0FBSzdCO1lBRWxEaUQsZUFBZVIsZUFBZTtZQUM5QmdDLGtCQUFrQjNCLFNBQVNqQixNQUFNO1lBQ2pDb0IsZUFBZU4sV0FBVztBQUMzQjtRQUNERyxRQUFRRyxpQkFBaUJBO1FBQ3pCaEssUUFBUUMsSUFBSSxHQUFHa0csNEJBQTBCeEYsS0FBS25HLFVBQVVxUDtBQUM1RCxXQUFTO1FBQ0w3SixRQUFRQyxJQUFJLEdBQUdrRztBQUNoQjtBQUNIOztBQUVBLFNBQVNnRixjQUFjTTtJQUNyQixPQUFPOUssS0FBS25HLFVBQVVpUixTQUFTO0FBQ2pDOztBQUVBLFNBQVNILGlCQUFpQkksTUFBTTdCO0lBQzlCN0osUUFBUUMsSUFBSSxHQUFHa0csdUNBQXFDeEYsS0FBS25HLFVBQVVrUjtJQUNuRUMsY0FBY0MsU0FBUztJQUN2QkQsY0FBY0UsZ0JBQWdCaEMsUUFBUWdDO0lBQ3RDSCxLQUFLSSxLQUFLSDtJQUNWM0wsUUFBUUMsSUFBSSxHQUFHa0csNENBQTBDeEYsS0FBS25HLFVBQVVrUjtJQUN4RSxJQUFJSyxNQUFNO0lBQ1YsS0FBSyxJQUFJeFMsSUFBSSxHQUFHQSxJQUFJbVMsS0FBSzFSLFFBQVFULEtBQUs7UUFDcEMsSUFBSXFQLE9BQU84QyxLQUFLblM7UUFDaEIsSUFBSWdTLE9BQU8sSUFBSXpFO1FBQ2Z5RSxLQUFLeEUsUUFBUTZCLEtBQUs3QjtRQUNsQndFLEtBQUt2RSxnQkFBZ0I0QixLQUFLNUI7UUFDMUJ1RSxLQUFLdEUsa0JBQWtCMkIsS0FBSzNCO1FBQzVCc0UsS0FBS3JFLGlCQUFpQjBCLEtBQUsxQjtRQUMzQnFFLEtBQUtyRCxPQUFPVSxLQUFLekI7UUFDakJvRSxLQUFLbkUsYUFBYXdCLEtBQUt4QjtRQUN2Qm1FLEtBQUtsRSxZQUFZdUIsS0FBS3ZCO1FBQ3RCa0UsS0FBS2xELFdBQVdPLEtBQUt0QjtRQUNyQmlFLEtBQUs5USxLQUFLbU8sS0FBS25PO1FBQ2Y4USxLQUFLaEUsYUFBYXFCLEtBQUtyQjtRQUN2QmdFLEtBQUt0RCxVQUFVVyxLQUFLcEI7UUFFcEIrRCxLQUFLOUQsUUFBUWxPO1FBQ2IsSUFBSUEsS0FBSyxLQUFLbVMsS0FBSzFSLFNBQVMsR0FBRztZQUM3QnVSLEtBQUt6RCxjQUFjO0FBQ3pCLGVBQVc7WUFDTHlELEtBQUt6RCxjQUFjO0FBQ3BCO1FBRUR5RCxLQUFLOUM7UUFHTHNELElBQUluUixLQUFLMlE7QUFDVjtJQUNEdkwsUUFBUUMsSUFBSSxHQUFHa0csK0JBQTZCeEYsS0FBS25HLFVBQVV1UjtJQUMzRCxPQUFPQTtBQUNUOztBQUtBLFNBQVM5QixxQkFBcUIrQixlQUFlaEMsZ0JBQWdCaUMsY0FBYztJQUN6RWpNLFFBQVFDLElBQUksR0FBR2tHLG1EQUFpRDZGO0lBQ2hFLEtBQUssSUFBSXpTLElBQUksR0FBR0EsSUFBSTJHLE1BQU0ySSxXQUFXRyxNQUFNaFAsUUFBUVQsS0FBSztRQUN0RCxJQUFJcVAsT0FBTzFJLE1BQU0ySSxXQUFXRyxNQUFNelA7UUFDbEMsSUFBSXlTLGtCQUFrQixHQUFHO1lBQ3ZCcEQsS0FBS2hCLGNBQWN4QixjQUFjTztBQUN2QyxlQUFXLElBQUlxRixpQkFBaUJ6UyxHQUFHO1lBQzdCLElBQUlxUCxLQUFLaEIsZUFBZXhCLGNBQWNRLGFBQWE7Z0JBQ2pELElBQUlxRixhQUFhO29CQUVmckQsS0FBS2hCLGNBQWN4QixjQUFjUztvQkFDakNtRCxlQUFlVCxlQUFlO0FBQy9CO0FBQ1QsbUJBQWE7Z0JBQ0xYLEtBQUtoQixjQUFjeEIsY0FBY1E7QUFDbEM7QUFDUCxlQUFXO1lBQ0xnQyxLQUFLaEIsY0FBY3hCLGNBQWNTO0FBQ2xDO0FBQ0Y7SUFDRDdHLFFBQVFDLElBQUksR0FBR2tHLCtDQUE2QzZELGVBQWVUO0FBQzdFOztBQUtPLFNBQVMyQyxjQUFjTixRQUFRL0I7SUFDcEM3SixRQUFRQyxJQUFJLEdBQUdrRywwQ0FBd0N5RixVQUFVL0IsUUFBUWdDO0lBQ3pFLElBQUk3QixpQkFBaUJILFFBQVFHO0lBQzdCLEtBQUtBLGVBQWVSLGNBQWM7UUFDaEM7QUFDRDtJQUVELEtBQUtRLGVBQWVQLHNCQUFzQjtRQUN4QyxJQUFJMEMsV0FBV25DLGVBQWVoQjtRQUM5QixJQUFJb0QsVUFBVTtRQUNkLEtBQUssSUFBSTdTLElBQUksR0FBR0EsSUFBSTRTLFNBQVNuUyxRQUFRVCxLQUFLO1lBQ3hDeUcsUUFBUUMsSUFBSSxHQUFHa0csOEJBQTRCeEYsS0FBS25HLFVBQVUyUixTQUFTNVM7WUFDbkUsSUFBSWdTLE9BQU8sSUFBSXpFO1lBQ2Z5RSxLQUFLNUMsS0FBS3dELFNBQVM1UztZQUNuQjZTLFFBQVF4UixLQUFLMlE7QUFDZDtRQUNEdkwsUUFBUUMsSUFBSSxHQUFHa0csNENBQTBDeEYsS0FBS25HLFVBQVU0UjtRQUN4RVQsY0FBY0MsU0FBU0E7UUFDdkJELGNBQWNFLGdCQUFnQmhDLFFBQVFnQztRQUN0Q08sUUFBUU4sS0FBS0g7UUFFYixLQUFLLElBQUlwUyxJQUFJLEdBQUdBLElBQUk2UyxRQUFRcFMsUUFBUVQsS0FBSztZQUN2QyxJQUFJZ1MsT0FBT2EsUUFBUTdTO1lBQ25CZ1MsS0FBSzlELFFBQVFsTztZQUNiLElBQUlBLEtBQUssR0FBRztnQkFDVixJQUFJNFMsU0FBU25TLFNBQVMsR0FBRztvQkFDdkJ1UixLQUFLekQsY0FBYztBQUNwQjtnQkFDRGtDLGVBQWVULGNBQWNoUTtnQkFDN0JnUyxLQUFLM0QsY0FBY3hCLGNBQWNRO0FBQ3pDLG1CQUFhO2dCQUNMMkUsS0FBS3pELGNBQWM7Z0JBQ25CeUQsS0FBSzNELGNBQWN4QixjQUFjUztBQUNsQztBQUNGO1FBQ0Q3RyxRQUFRQyxJQUFJLEdBQUdrRyw0Q0FBMEN4RixLQUFLbkcsVUFBVTRSO1FBQ3hFcEMsZUFBZWhCLFFBQVFvRDtBQUN4QjtJQUNENUIsZUFBZVg7SUFDZjdKLFFBQVFDLElBQUksR0FBR2tHO0FBQ2pCOztBQUtBLFNBQVN3RixjQUFjVSxJQUFJQztJQUN6QixJQUFJVixTQUFTRCxjQUFjQztJQUMzQixJQUFJQyxnQkFBZ0JGLGNBQWNFO0lBQ2xDN0wsUUFBUUMsSUFBSSxHQUFHa0cscUNBQW1DeUYseUJBQXlCQztJQUMzRSxJQUFJVSxLQUFLQyxVQUFVSCxJQUFJVCxRQUFRQztJQUMvQixJQUFJWSxLQUFLRCxVQUFVRixJQUFJVixRQUFRQztJQUMvQjdMLFFBQVFDLElBQUksUUFBUXNNLFdBQVdFO0lBQy9CLElBQUlGLEtBQUtFLElBQUk7UUFDWCxRQUFRO0FBQ1osV0FBUyxJQUFJRixLQUFLRSxJQUFJO1FBQ2xCLE9BQU87QUFDWCxXQUFTO1FBRUwsSUFBSUosR0FBR2hGLFlBQVlpRixHQUFHakYsV0FBVztZQUMvQixRQUFRO0FBQ1QsZUFBTSxJQUFJZ0YsR0FBR2hGLFlBQVlpRixHQUFHakYsV0FBVztZQUN0QyxPQUFPO0FBQ1I7UUFDRCxPQUFPO0FBQ1I7QUFDSDs7QUFLQSxTQUFTbUYsVUFBVXZULEdBQUcyUyxRQUFRQztJQUM1QjdMLFFBQVFDLElBQUksR0FBR2tHLDJCQUF5QnlGLHlCQUF5QkM7SUFDakUsSUFBSTdGLE1BQU07SUFDVixJQUFJNEYsVUFBVSxHQUFHO1FBQ2Y1RixNQUFNL00sRUFBRStOO0FBQ1osV0FBUyxJQUFHNEUsVUFBVTNTLEVBQUVnTyxpQkFBaUI7UUFFckNqQixNQUFNdEksS0FBS2dQLElBQUliLGdCQUFnQkQsUUFBUTNTLEVBQUUrTixpQkFBaUI7QUFDOUQsV0FBUztRQUNMaEIsTUFBTXRJLEtBQUtnUCxJQUFJYixnQkFBZ0JELFFBQVEzUyxFQUFFK047QUFDMUM7SUFDRCxPQUFPMkYsV0FBVzNHLE9BQU8vTSxFQUFFa08sTUFBTWxPLEVBQUVtTztBQUNyQzs7QUFLQSxTQUFTb0QsZUFBZVg7SUFDdEIsSUFBSStDLFlBQVkvQyxRQUFRK0M7SUFDeEIsSUFBSS9ELGFBQWFnQixRQUFRRztJQUN6QmhLLFFBQVFDLElBQUksR0FBR2tHLHdCQUFzQnlHLGFBQWFqTSxLQUFLbkcsVUFBVXFPO0lBQ2pFLElBQUlnRSxTQUFTRCxVQUFVNVMsVUFBVSxJQUFJLElBQUkyUyxXQUFXQztJQUNwRDVNLFFBQVFDLElBQUksMEJBQTBCNE0sdUJBQXVCaEUsV0FBV1U7SUFDeEUsSUFBSVYsV0FBV1UsZ0JBQWdCLEdBQUc7UUFDaEM7QUFDRDtJQUNELElBQUlYLE9BQU9DLFdBQVdHLE1BQU1ILFdBQVdVO0lBQ3ZDLElBQUlzRCxTQUFTakUsS0FBSzNCLGlCQUFpQjtRQUVqQ3VFLGtCQUFrQjNCLFNBQVNqQixNQUFNO0FBQ3JDLFdBQVM7UUFFTCxJQUFJNUMsTUFBTXRJLEtBQUtnUCxJQUFJRyxRQUFRakUsS0FBSzVCO1FBQ2hDd0Usa0JBQWtCM0IsU0FBU2pCLE1BQU0sT0FBTzVDO0FBQ3pDO0FBQ0g7O0FBS0EsU0FBU3dGLGtCQUFrQjNCLFNBQVNpRCxRQUFRQyxXQUFXLE1BQU1MLE1BQU07SUFDakUxTSxRQUFRQyxJQUFJLEdBQUdrRyxxQ0FBbUM0RyxpQkFBaUJMLE9BQU8vTCxLQUFLbkcsVUFBVXFQO0lBQ3pGQSxRQUFRYyxvQkFBb0I7SUFDNUJkLFFBQVFtRCxtQkFBbUI7SUFDM0JuRCxRQUFRb0QsZUFBZTtJQUN2QixJQUFJRixVQUFVO1FBRVpsRCxRQUFRcUQsZUFBZS9DLG1CQUNyQjdCLE1BQU1DLFdBQVc0RSxpQ0FBaUMsR0FBR2hGLGdCQUF1QkMsU0FBZ0IwRSxPQUFPM0YsS0FBSyxNQUFNO1FBRWhIMEMsUUFBUXVELGlCQUFpQjlFLE1BQU1DLFdBQVc4RSxvQ0FBb0MsR0FBR1AsT0FBTzdGLG1CQUFtQixHQUFHL0csTUFBTTRKLEtBQUs1SDtRQUN6SDJILFFBQVF5RCxvQkFBb0I7QUFDaEMsV0FBUztRQUVMekQsUUFBUXFELGVBQWUvQyxtQkFDckI3QixNQUFNQyxXQUFXZ0YsaUNBQ2YsR0FBR2IsT0FDSCxHQUFHeE0sTUFBTTRKLEtBQUs1SCxZQUNkLEdBQUdpRyxnQkFBdUJDLFNBQWdCMEUsT0FBTzNGLEtBQUssTUFBTTtRQUdoRTBDLFFBQVF5RCxvQkFBb0I7QUFDN0I7QUFDSDs7QUFLQSxTQUFTaEQsa0JBQWtCVCxTQUFTMkQsV0FBV0M7SUFDN0N6TixRQUFRQyxJQUFJLEdBQUdrRywyQkFBeUJxSCxhQUFhQyxRQUFROU0sS0FBS25HLFVBQVVxUDtJQUM1RUEsUUFBUWMsb0JBQW9CNkMsWUFBWSxZQUFZO0lBQ3BEM0QsUUFBUW9ELGVBQWU7SUFDdkJwRCxRQUFRNkQsZ0JBQWdCLEdBQUdEO0lBQzNCNUQsUUFBUW1ELG1CQUFtQjtJQUMzQmhOLFFBQVFDLElBQUksR0FBR2tHLGdDQUE4QnFILGFBQWFDLFFBQVE5TSxLQUFLbkcsVUFBVXFQLFFBQVE2RDtBQUMzRjs7QUFLQSxTQUFTOUM7SUFDUDFLLE1BQU0ySSxXQUFXSSxjQUFjN0MsY0FBY0M7SUFDN0NuRyxNQUFNMkksV0FBV0ssaUJBQWlCOUMsY0FBY0U7SUFDaERwRyxNQUFNMkksV0FBV00sZUFBZS9DLGNBQWNHO0lBRTlDckcsTUFBTTJJLFdBQVdDLG9CQUFvQjtBQUN2Qzs7QUFLQSxTQUFTK0Isc0JBQXNCMUQ7SUFDN0JqSCxNQUFNMkksV0FBV0ksY0FBYzdDLGNBQWNJO0lBQzdDdEcsTUFBTTJJLFdBQVdLLGlCQUFpQjlDLGNBQWNLO0lBQ2hEdkcsTUFBTTJJLFdBQVdNLGVBQWUvQyxjQUFjTTtJQUU5Q3ZHLE9BQU8wSSxXQUFXcUIsc0JBQXNCL0M7SUFDeENqSCxNQUFNMkksV0FBV0Msb0JBQW9CO0FBQ3ZDOztBQ3JmQSxNQUFNM0MsUUFBTTs7QUFFWixNQUFNd0gsV0FBVzs7QUFDakIsTUFBTUMsaUJBQWlCOztBQUN2QixNQUFNQyxVQUFVOztBQUNoQixNQUFNQyxlQUFlOztBQUNyQixNQUFNQyxhQUFhOztBQUNuQixNQUFNQyxpQ0FBaUM7O0FBQ3ZDLE1BQU1DLGtCQUFrQjs7QUFDeEIsTUFBTUMsWUFBWTs7QUFFbEIsTUFBTUMsZUFBZTs7QUFHckIsTUFBTUMsWUFBWTs7QUFFbEIsTUFBTUMsYUFBYTs7QUFFbkIsTUFBTUMsVUFBVTs7QUFFaEIsTUFBTUMsUUFBUTs7QUFFZCxNQUFNQyxjQUFjOztBQUtiLFNBQVNDLFNBQVM1RSxTQUFTNkUsVUFBVUM7SUFDMUMzTyxRQUFRQyxJQUNOLEdBQUdrRyw2QkFBMkIwRCxRQUFRb0IsbUJBQW1CcEIsUUFBUStFLHFCQUFxQi9FLFFBQVFnRjtJQUVoRyxJQUFJdE0sU0FBUztRQUNYb0wsQ0FBQ0EsV0FBV3pOLE1BQU00SixLQUFLNUg7UUFDdkIyTCxDQUFDQSxVQUFVaEUsUUFBUStFO1FBQ25CZCxDQUFDQSxlQUFlakUsUUFBUW9CO1FBQ3hCK0MsQ0FBQ0EsaUNBQWlDbkUsUUFBUTFELE9BQU8sSUFBSSxJQUFJO1FBQ3pEOEgsQ0FBQ0Esa0JBQWtCUztRQUNuQlIsQ0FBQ0EsWUFBWVksV0FBa0JyTjtRQUMvQjBNLENBQUNBLGVBQWVROztJQUVsQixJQUFJOUUsUUFBUWdGLGVBQWUsR0FBRztRQUM1QnRNLE9BQU9xTCxrQkFBa0JTO1FBQ3pCLElBQUl4RSxRQUFRa0YsV0FBVyxHQUFHO1lBQ3hCeE0sT0FBT3dMLGNBQWNRO0FBQzNCLGVBQVcsSUFBSTFFLFFBQVFrRixXQUFXLEdBQUc7WUFDL0J4TSxPQUFPd0wsY0FBY1M7QUFDdEI7QUFDTCxXQUFTLElBQUkzRSxRQUFRZ0YsZUFBZSxHQUFHO1FBQ25DLElBQUloRixRQUFRbUYsYUFBYSxLQUFLbkYsUUFBUW1GLGFBQWEsR0FBRztZQUNwRHpNLE9BQU9xTCxrQkFBa0JVO0FBQy9CLGVBQVcsSUFBSXpFLFFBQVFtRixhQUFhLEdBQUc7WUFDakN6TSxPQUFPcUwsa0JBQWtCUTtBQUMxQjtBQUNGO0lBQ0RwTyxRQUFRQyxJQUFJLEdBQUdrRywwQkFBd0J4RixLQUFLbkcsVUFBVStIO0lBQ3REME0sVUFBaUIsK0JBQStCMU07QUFDbEQ7O0FBS08sU0FBUzJNO0lBQ2RELFVBQWlCLHVDQUF1QztRQUFFRSxPQUFPalAsTUFBTTRKLEtBQUs1SDs7QUFDOUU7O0FBS08sU0FBU2tOO0lBQ2RILFVBQWlCO0FBQ25COztBQUtPLFNBQVNJO0lBQ2RKLFVBQWlCO0FBQ25COztBQUtPLFNBQVNLLHlCQUF5QkM7SUFDdkNOLFVBQWlCLDJEQUEyRDtRQUFFakgsTUFBTXVIOztBQUN0Rjs7QUFLTyxTQUFTQyx5QkFBeUJEO0lBQ3ZDTixVQUFpQiwyREFBMkQ7UUFBRWpILE1BQU11SDs7QUFDdEY7O0FBS08sU0FBU0UsdUJBQXVCQztJQUNyQ1QsVUFBaUIsb0NBQW9DO1FBQUVVLGVBQWVEOztBQUN4RTs7QUFLTyxTQUFTRSxTQUFTL0Y7SUFDdkI3SixRQUFRQyxJQUNOLEdBQUdrRyw2QkFBMkIwRCxRQUFRb0IsbUJBQW1CcEIsUUFBUStFLHFCQUFxQi9FLFFBQVFnRjtJQUVoRyxJQUFJdE0sU0FBUztRQUNYb0wsQ0FBQ0EsV0FBV3pOLE1BQU00SixLQUFLNUg7UUFDdkIyTCxDQUFDQSxVQUFVaEUsUUFBUStFO1FBQ25CZCxDQUFDQSxlQUFlakUsUUFBUW9COztJQUcxQixJQUFJcEIsUUFBUWdGLGVBQWUsR0FBRztRQUM1QnRNLE9BQU9xTCxrQkFBa0JTO0FBQzdCLFdBQVMsSUFBSXhFLFFBQVFnRixlQUFlLEdBQUc7UUFDbkMsSUFBSWhGLFFBQVFtRixhQUFhLEtBQUtuRixRQUFRbUYsYUFBYSxHQUFHO1lBQ3BEek0sT0FBT3FMLGtCQUFrQlU7QUFDL0IsZUFBVyxJQUFJekUsUUFBUW1GLGFBQWEsR0FBRztZQUNqQ3pNLE9BQU9xTCxrQkFBa0JRO0FBQzFCO0FBQ0Y7SUFDRGEsVUFBaUIsb0NBQW9DMU07QUFDdkQ7O0FBTU8sU0FBU3NOLFNBQVNoRztJQUN2QjdKLFFBQVFDLElBQ04sR0FBR2tHLDZCQUEyQjBELFFBQVFvQixtQkFBbUJwQixRQUFRK0UscUJBQXFCL0UsUUFBUWdGO0lBRWhHLElBQUl0TSxTQUFTO1FBQ1hvTCxDQUFDQSxXQUFXek4sTUFBTTRKLEtBQUs1SDtRQUN2QjJMLENBQUNBLFVBQVVoRSxRQUFRK0U7UUFDbkJkLENBQUNBLGVBQWVqRSxRQUFRb0I7O0lBRzFCLElBQUlwQixRQUFRZ0YsZUFBZSxHQUFHO1FBQzVCdE0sT0FBT3FMLGtCQUFrQlM7QUFDN0IsV0FBUyxJQUFJeEUsUUFBUWdGLGVBQWUsR0FBRztRQUNuQyxJQUFJaEYsUUFBUW1GLGFBQWEsT0FBT25GLFFBQVFtRixhQUFhLEtBQUs7WUFDeER6TSxPQUFPcUwsa0JBQWtCVTtBQUMvQixlQUFXLElBQUl6RSxRQUFRbUYsYUFBYSxLQUFLO1lBQ25Dek0sT0FBT3FMLGtCQUFrQlE7QUFDMUI7QUFDRjtJQUNEYSxVQUFpQixvQ0FBb0MxTTtBQUN2RDs7QUFLTyxTQUFTdU4sY0FBY2pHO0lBQzVCN0osUUFBUUMsSUFDTixHQUFHa0csa0NBQWdDMEQsUUFBUW9CLG1CQUFtQnBCLFFBQVErRSxxQkFBcUIvRSxRQUFRZ0Y7SUFFckcsSUFBSXRNLFNBQVM7UUFDWG9MLENBQUNBLFdBQVd6TixNQUFNNEosS0FBSzVIO1FBQ3ZCMkwsQ0FBQ0EsVUFBVWhFLFFBQVErRTtRQUNuQmQsQ0FBQ0EsZUFBZWpFLFFBQVFvQjs7SUFHMUIsSUFBSXBCLFFBQVFnRixlQUFlLEdBQUc7UUFDNUJ0TSxPQUFPcUwsa0JBQWtCUztBQUM3QixXQUFTLElBQUl4RSxRQUFRZ0YsZUFBZSxHQUFHO1FBQ25DLElBQUloRixRQUFRbUYsYUFBYSxLQUFLbkYsUUFBUW1GLGFBQWEsR0FBRztZQUNwRHpNLE9BQU9xTCxrQkFBa0JVO0FBQy9CLGVBQVcsSUFBSXpFLFFBQVFtRixhQUFhLEdBQUc7WUFDakN6TSxPQUFPcUwsa0JBQWtCUTtBQUMxQjtBQUNGO0lBQ0RhLFVBQWlCLHlDQUF5QzFNO0FBQzVEOztBQUtPLFNBQVN3TixpQkFBaUJsRztJQUMvQjdKLFFBQVFDLElBQ04sR0FBR2tHLHFDQUFtQzBELFFBQVFvQixtQkFBbUJwQixRQUFRK0UscUJBQXFCL0UsUUFBUWdGO0lBRXhHLElBQUl0TSxTQUFTO1FBQ1hvTCxDQUFDQSxXQUFXek4sTUFBTTRKLEtBQUs1SDtRQUN2QjJMLENBQUNBLFVBQVVoRSxRQUFRK0U7UUFDbkJkLENBQUNBLGVBQWVqRSxRQUFRb0I7O0lBRzFCLElBQUlwQixRQUFRZ0YsZUFBZSxHQUFHO1FBQzVCdE0sT0FBT3FMLGtCQUFrQlM7QUFDN0IsV0FBUyxJQUFJeEUsUUFBUWdGLGVBQWUsR0FBRztRQUNuQyxJQUFJaEYsUUFBUW1GLGFBQWEsS0FBS25GLFFBQVFtRixhQUFhLEdBQUc7WUFDcER6TSxPQUFPcUwsa0JBQWtCVTtBQUMvQixlQUFXLElBQUl6RSxRQUFRbUYsYUFBYSxHQUFHO1lBQ2pDek0sT0FBT3FMLGtCQUFrQlE7QUFDMUI7QUFDRjtJQUNEYSxVQUFpQiw0Q0FBNEMxTTtBQUMvRDs7QUFLTyxTQUFTeU4sbUJBQW1Cbkc7SUFDakM3SixRQUFRQyxJQUNOLEdBQUdrRyx1Q0FBcUMwRCxRQUFRb0IsbUJBQW1CcEIsUUFBUStFLHFCQUFxQi9FLFFBQVFnRjtJQUUxRyxJQUFJdE0sU0FBUztRQUNYb0wsQ0FBQ0EsV0FBV3pOLE1BQU00SixLQUFLNUg7UUFDdkIyTCxDQUFDQSxVQUFVaEUsUUFBUStFO1FBQ25CZCxDQUFDQSxlQUFlakUsUUFBUW9COztJQUcxQixJQUFJcEIsUUFBUWdGLGVBQWUsR0FBRztRQUM1QnRNLE9BQU9xTCxrQkFBa0JTO0FBQzdCLFdBQVMsSUFBSXhFLFFBQVFnRixlQUFlLEdBQUc7UUFDbkMsSUFBSWhGLFFBQVFtRixhQUFhLEtBQUtuRixRQUFRbUYsYUFBYSxHQUFHO1lBQ3BEek0sT0FBT3FMLGtCQUFrQlU7QUFDL0IsZUFBVyxJQUFJekUsUUFBUW1GLGFBQWEsR0FBRztZQUNqQ3pNLE9BQU9xTCxrQkFBa0JRO0FBQzFCO0FBQ0Y7SUFDRGEsVUFBaUIsOENBQThDMU07QUFDakU7O0FBS08sU0FBUzBOLGlCQUFpQnBHO0lBQy9CN0osUUFBUUMsSUFDTixHQUFHa0cscUNBQW1DMEQsUUFBUW9CLG1CQUFtQnBCLFFBQVErRSxxQkFBcUIvRSxRQUFRZ0Y7SUFFeEcsSUFBSXRNLFNBQVM7UUFDWG9MLENBQUNBLFdBQVd6TixNQUFNNEosS0FBSzVIO1FBQ3ZCMkwsQ0FBQ0EsVUFBVWhFLFFBQVErRTtRQUNuQmQsQ0FBQ0EsZUFBZWpFLFFBQVFvQjs7SUFJMUIsSUFBSXBCLFFBQVFnRixlQUFlLEdBQUc7UUFDNUJ0TSxPQUFPcUwsa0JBQWtCUztRQUN6QixJQUFJeEUsUUFBUWtGLFdBQVcsR0FBRztZQUN4QnhNLE9BQU93TCxjQUFjUTtBQUMzQixlQUFXLElBQUkxRSxRQUFRa0YsV0FBVyxHQUFHO1lBQy9CeE0sT0FBT3dMLGNBQWNTO0FBQ3RCO0FBQ0wsV0FBUyxJQUFJM0UsUUFBUWdGLGVBQWUsR0FBRztRQUNuQyxJQUFJaEYsUUFBUW1GLGFBQWEsS0FBS25GLFFBQVFtRixhQUFhLEdBQUc7WUFDcER6TSxPQUFPcUwsa0JBQWtCVTtBQUMvQixlQUFXLElBQUl6RSxRQUFRbUYsYUFBYSxHQUFHO1lBQ2pDek0sT0FBT3FMLGtCQUFrQlE7QUFDMUI7QUFDRjtJQUNEcE8sUUFBUUMsSUFBSSxHQUFHa0csa0NBQWdDeEYsS0FBS25HLFVBQVUrSDtJQUM5RDBNLFVBQWlCLDRDQUE0QzFNO0FBQy9EOztBQUtPLFNBQVMyTixxQkFBcUJyRztJQUNuQzdKLFFBQVFDLElBQ04sR0FBR2tHLHlDQUF1QzBELFFBQVFvQixtQkFBbUJwQixRQUFRK0UscUJBQXFCL0UsUUFBUWdGO0lBRTVHLElBQUl0TSxTQUFTO1FBQ1hvTCxDQUFDQSxXQUFXek4sTUFBTTRKLEtBQUs1SDtRQUN2QjJMLENBQUNBLFVBQVVoRSxRQUFRK0U7UUFDbkJkLENBQUNBLGVBQWVqRSxRQUFRb0I7O0lBSTFCLElBQUlwQixRQUFRZ0YsZUFBZSxHQUFHO1FBQzVCdE0sT0FBT3FMLGtCQUFrQlM7UUFDekIsSUFBSXhFLFFBQVFrRixXQUFXLEdBQUc7WUFDeEJ4TSxPQUFPd0wsY0FBY1E7QUFDM0IsZUFBVyxJQUFJMUUsUUFBUWtGLFdBQVcsR0FBRztZQUMvQnhNLE9BQU93TCxjQUFjUztBQUN0QjtBQUNMLFdBQVMsSUFBSTNFLFFBQVFnRixlQUFlLEdBQUc7UUFDbkMsSUFBSWhGLFFBQVFtRixhQUFhLEtBQUtuRixRQUFRbUYsYUFBYSxHQUFHO1lBQ3BEek0sT0FBT3FMLGtCQUFrQlU7QUFDL0IsZUFBVyxJQUFJekUsUUFBUW1GLGFBQWEsR0FBRztZQUNqQ3pNLE9BQU9xTCxrQkFBa0JRO0FBQzFCO0FBQ0Y7SUFDRHBPLFFBQVFDLElBQUksR0FBR2tHLHNDQUFvQ3hGLEtBQUtuRyxVQUFVK0g7SUFDbEUwTSxVQUFpQixnREFBZ0QxTTtBQUNuRTs7QUFLTyxTQUFTNE47SUFDZGxCLFVBQWlCLHdEQUF3RDtRQUFFdEIsQ0FBQ0EsV0FBV3pOLE1BQU00SixLQUFLNUg7O0FBQ3BHOztBQUVBLE1BQU1rTyxZQUFZOztBQUNsQixNQUFNQyxhQUFhOztBQUNuQixNQUFNQyxjQUFjOztBQUliLFNBQVNDLG9CQUFvQkM7SUFDbEN4USxRQUFRQyxJQUFJLEdBQUdrRyx1Q0FBcUNxSztJQUNwRCxJQUFJNUssU0FBUzRLLFlBQVksSUFBSUgsYUFBYUM7SUFDMUNyQixVQUFpQix1REFBdUQ7UUFDdEV0QixDQUFDQSxXQUFXek4sTUFBTTRKLEtBQUs1SDtRQUN2QmtPLENBQUNBLFlBQVl4Szs7QUFFakI7O0FBS08sU0FBUzZLLGdCQUFnQjVHO0lBQzlCN0osUUFBUUMsSUFDTixHQUFHa0csb0NBQWtDMEQsUUFBUW9CLG1CQUFtQnBCLFFBQVErRSxxQkFBcUIvRSxRQUFRZ0Y7SUFFdkcsSUFBSXRNLFNBQVM7UUFDWG9MLENBQUNBLFdBQVd6TixNQUFNNEosS0FBSzVIO1FBQ3ZCMkwsQ0FBQ0EsVUFBVWhFLFFBQVErRTtRQUNuQmQsQ0FBQ0EsZUFBZWpFLFFBQVFvQjs7SUFJMUIsSUFBSXBCLFFBQVFnRixlQUFlLEdBQUc7UUFDNUJ0TSxPQUFPcUwsa0JBQWtCUztRQUN6QixJQUFJeEUsUUFBUWtGLFdBQVcsR0FBRztZQUN4QnhNLE9BQU93TCxjQUFjUTtBQUMzQixlQUFXLElBQUkxRSxRQUFRa0YsV0FBVyxHQUFHO1lBQy9CeE0sT0FBT3dMLGNBQWNTO0FBQ3RCO0FBQ0wsV0FBUyxJQUFJM0UsUUFBUWdGLGVBQWUsR0FBRztRQUNuQyxJQUFJaEYsUUFBUW1GLGFBQWEsS0FBS25GLFFBQVFtRixhQUFhLEdBQUc7WUFDcER6TSxPQUFPcUwsa0JBQWtCVTtBQUMvQixlQUFXLElBQUl6RSxRQUFRbUYsYUFBYSxHQUFHO1lBQ2pDek0sT0FBT3FMLGtCQUFrQlE7QUFDMUI7QUFDRjtJQUNEcE8sUUFBUUMsSUFBSSxHQUFHa0csaUNBQStCeEYsS0FBS25HLFVBQVUrSDtJQUM3RDBNLFVBQWlCLHVEQUF1RDFNO0FBQzFFOztBQUtPLFNBQVNtTyxtQkFBbUI3RztJQUNqQzdKLFFBQVFDLElBQ04sR0FBR2tHLHVDQUFxQzBELFFBQVFvQixtQkFBbUJwQixRQUFRK0UscUJBQXFCL0UsUUFBUWdGO0lBRTFHLElBQUl0TSxTQUFTO1FBQ1hvTCxDQUFDQSxXQUFXek4sTUFBTTRKLEtBQUs1SDtRQUN2QjJMLENBQUNBLFVBQVVoRSxRQUFRK0U7UUFDbkJkLENBQUNBLGVBQWVqRSxRQUFRb0I7O0lBSTFCLElBQUlwQixRQUFRZ0YsZUFBZSxHQUFHO1FBQzVCdE0sT0FBT3FMLGtCQUFrQlM7UUFDekIsSUFBSXhFLFFBQVFrRixXQUFXLEdBQUc7WUFDeEJ4TSxPQUFPd0wsY0FBY1E7QUFDM0IsZUFBVyxJQUFJMUUsUUFBUWtGLFdBQVcsR0FBRztZQUMvQnhNLE9BQU93TCxjQUFjUztBQUN0QjtBQUNMLFdBQVMsSUFBSTNFLFFBQVFnRixlQUFlLEdBQUc7UUFDbkMsSUFBSWhGLFFBQVFtRixhQUFhLEtBQUtuRixRQUFRbUYsYUFBYSxHQUFHO1lBQ3BEek0sT0FBT3FMLGtCQUFrQlU7QUFDL0IsZUFBVyxJQUFJekUsUUFBUW1GLGFBQWEsR0FBRztZQUNqQ3pNLE9BQU9xTCxrQkFBa0JRO0FBQzFCO0FBQ0Y7SUFDRHBPLFFBQVFDLElBQUksR0FBR2tHLG9DQUFrQ3hGLEtBQUtuRyxVQUFVK0g7SUFDaEUwTSxVQUFpQixzRUFBc0UxTTtBQUN6Rjs7QUFLTyxTQUFTb087SUFDZCxJQUFJOUcsVUFBVTFKLE9BQU8ySixLQUFLOEcsa0JBQWtCMVEsTUFBTTRKLEtBQUsrRztJQUN2RDdRLFFBQVFDLElBQ04sR0FBR2tHLHlDQUF1QzBELFFBQVFvQixtQkFBbUJwQixRQUFRK0UscUJBQXFCL0UsUUFBUWdGO0lBRTVHLElBQUl0TSxTQUFTO1FBQ1hvTCxDQUFDQSxXQUFXek4sTUFBTTRKLEtBQUs1SDtRQUN2QjJMLENBQUNBLFVBQVVoRSxRQUFRK0U7UUFDbkJkLENBQUNBLGVBQWVqRSxRQUFRb0I7O0lBRzFCLElBQUlwQixRQUFRZ0YsZUFBZSxHQUFHO1FBQzVCdE0sT0FBT3FMLGtCQUFrQlM7QUFDN0IsV0FBUyxJQUFJeEUsUUFBUWdGLGVBQWUsR0FBRztRQUNuQyxJQUFJaEYsUUFBUW1GLGFBQWEsS0FBS25GLFFBQVFtRixhQUFhLEdBQUc7WUFDcER6TSxPQUFPcUwsa0JBQWtCVTtBQUMvQixlQUFXLElBQUl6RSxRQUFRbUYsYUFBYSxHQUFHO1lBQ2pDek0sT0FBT3FMLGtCQUFrQlE7QUFDMUI7QUFDRjtJQUNEYSxVQUFpQixrQ0FBa0MxTTtBQUNyRDs7QUFLTyxTQUFTdU87SUFDZCxJQUFJakgsVUFBVTFKLE9BQU8ySixLQUFLOEcsa0JBQWtCMVEsTUFBTTRKLEtBQUsrRztJQUN2RDdRLFFBQVFDLElBQ04sR0FBR2tHLG9EQUFrRDBELFFBQVFvQixtQkFBbUJwQixRQUFRK0UscUJBQXFCL0UsUUFBUWdGO0lBRXZILElBQUl0TSxTQUFTO1FBQ1hvTCxDQUFDQSxXQUFXek4sTUFBTTRKLEtBQUs1SDtRQUN2QjJMLENBQUNBLFVBQVVoRSxRQUFRK0U7UUFDbkJkLENBQUNBLGVBQWVqRSxRQUFRb0I7O0lBRzFCLElBQUlwQixRQUFRZ0YsZUFBZSxHQUFHO1FBQzVCdE0sT0FBT3FMLGtCQUFrQlM7QUFDN0IsV0FBUyxJQUFJeEUsUUFBUWdGLGVBQWUsR0FBRztRQUNuQyxJQUFJaEYsUUFBUW1GLGFBQWEsS0FBS25GLFFBQVFtRixhQUFhLEdBQUc7WUFDcER6TSxPQUFPcUwsa0JBQWtCVTtBQUMvQixlQUFXLElBQUl6RSxRQUFRbUYsYUFBYSxHQUFHO1lBQ2pDek0sT0FBT3FMLGtCQUFrQlE7QUFDMUI7QUFDRjtJQUNEYSxVQUFpQix5Q0FBeUMxTTtBQUM1RDs7QUFLTyxTQUFTd087SUFDZCxJQUFJbEgsVUFBVTFKLE9BQU8ySixLQUFLOEcsa0JBQWtCMVEsTUFBTTRKLEtBQUsrRztJQUN2RDdRLFFBQVFDLElBQ04sR0FBR2tHLG9EQUFrRDBELFFBQVFvQixtQkFBbUJwQixRQUFRK0UscUJBQXFCL0UsUUFBUWdGO0lBRXZILElBQUl0TSxTQUFTO1FBQ1hvTCxDQUFDQSxXQUFXek4sTUFBTTRKLEtBQUs1SDtRQUN2QjJMLENBQUNBLFVBQVVoRSxRQUFRK0U7UUFDbkJkLENBQUNBLGVBQWVqRSxRQUFRb0I7O0lBRzFCLElBQUlwQixRQUFRZ0YsZUFBZSxHQUFHO1FBQzVCdE0sT0FBT3FMLGtCQUFrQlM7QUFDN0IsV0FBUyxJQUFJeEUsUUFBUWdGLGVBQWUsR0FBRztRQUNuQyxJQUFJaEYsUUFBUW1GLGFBQWEsS0FBS25GLFFBQVFtRixhQUFhLEdBQUc7WUFDcER6TSxPQUFPcUwsa0JBQWtCVTtBQUMvQixlQUFXLElBQUl6RSxRQUFRbUYsYUFBYSxHQUFHO1lBQ2pDek0sT0FBT3FMLGtCQUFrQlE7QUFDMUI7QUFDRjtJQUNEYSxVQUFpQiw4Q0FBOEMxTTtBQUNqRTs7QUFLTyxTQUFTeU87SUFDZCxJQUFJbkgsVUFBVTFKLE9BQU8ySixLQUFLOEcsa0JBQWtCMVEsTUFBTTRKLEtBQUsrRztJQUN2RDdRLFFBQVFDLElBQ04sR0FBR2tHLGtEQUFnRDBELFFBQVFvQixtQkFBbUJwQixRQUFRK0UscUJBQXFCL0UsUUFBUWdGO0lBRXJILElBQUl0TSxTQUFTO1FBQ1hvTCxDQUFDQSxXQUFXek4sTUFBTTRKLEtBQUs1SDtRQUN2QjJMLENBQUNBLFVBQVVoRSxRQUFRK0U7UUFDbkJkLENBQUNBLGVBQWVqRSxRQUFRb0I7O0lBRzFCLElBQUlwQixRQUFRZ0YsZUFBZSxHQUFHO1FBQzVCdE0sT0FBT3FMLGtCQUFrQlM7QUFDN0IsV0FBUyxJQUFJeEUsUUFBUWdGLGVBQWUsR0FBRztRQUNuQyxJQUFJaEYsUUFBUW1GLGFBQWEsS0FBS25GLFFBQVFtRixhQUFhLEdBQUc7WUFDcER6TSxPQUFPcUwsa0JBQWtCVTtBQUMvQixlQUFXLElBQUl6RSxRQUFRbUYsYUFBYSxHQUFHO1lBQ2pDek0sT0FBT3FMLGtCQUFrQlE7QUFDMUI7QUFDRjtJQUNEYSxVQUFpQiw0Q0FBNEMxTTtBQUMvRDs7QUFLTyxTQUFTME87SUFDZCxJQUFJcEgsVUFBVTFKLE9BQU8ySixLQUFLOEcsa0JBQWtCMVEsTUFBTTRKLEtBQUsrRztJQUN2RDdRLFFBQVFDLElBQ04sR0FBR2tHLDJDQUF5QzBELFFBQVFvQixtQkFBbUJwQixRQUFRK0UscUJBQXFCL0UsUUFBUWdGO0lBRTlHLElBQUl0TSxTQUFTO1FBQ1hvTCxDQUFDQSxXQUFXek4sTUFBTTRKLEtBQUs1SDtRQUN2QjJMLENBQUNBLFVBQVVoRSxRQUFRK0U7UUFDbkJkLENBQUNBLGVBQWVqRSxRQUFRb0I7O0lBRTFCLElBQUlwQixRQUFRZ0YsZUFBZSxHQUFHO1FBQzVCdE0sT0FBT3FMLGtCQUFrQlM7QUFDN0IsV0FBUyxJQUFJeEUsUUFBUWdGLGVBQWUsR0FBRztRQUNuQyxJQUFJaEYsUUFBUW1GLGFBQWEsS0FBS25GLFFBQVFtRixhQUFhLEdBQUc7WUFDcER6TSxPQUFPcUwsa0JBQWtCVTtBQUMvQixlQUFXLElBQUl6RSxRQUFRbUYsYUFBYSxHQUFHO1lBQ2pDek0sT0FBT3FMLGtCQUFrQlE7QUFDMUI7QUFDRjtJQUNEYSxVQUFpQiw0Q0FBNEMxTTtBQUMvRDs7QUNwZkEsT0FBUW5DLFlBQUFBLGNBQVlDLGFBQUFBLGlCQUFnQjZRLGFBQW9CLFVBQVMsWUFBVSxJQUFJLENBQUE7O0FBRS9FLFNBQVNDO0lBQ1AsT0FBTztRQUNMQyxVQUFVO1FBQ1ZDLFlBQVk7UUFDWkMsU0FBU2hKLE1BQU1DLFdBQVdnSix1QkFBdUI7UUFDakRDLFNBQVM7UUFDVEMsU0FBUztRQUNUQyxVQUFVO1FBQ1ZDLGdCQUFnQjtRQUNoQkMsY0FBYztRQUNkQyxnQkFBZ0I7UUFDaEJDLHFCQUFxQjtRQUNyQkMsb0JBQW9CO1FBQ3BCQyxRQUFRO1FBQ1JDLFFBQVE7UUFHUkMsV0FBVztRQUNYaEYsY0FBYztRQUNkRSxnQkFBZ0I7UUFDaEJFLG1CQUFtQjtRQUNuQjNDLG1CQUFtQjtRQUNuQnNDLGNBQWM7UUFDZEQsa0JBQWtCO1FBQ2xCVSxlQUFlO1FBRWYxRCxnQkFBZ0IsQ0FBRTtRQUVsQlUsYUFBYSxDQUFFO1FBRWZ5SCxlQUFlO1FBRWZ0RyxlQUFlOztBQUVuQjs7QUFXTyxTQUFTdUcscUJBQXFCQyxjQUFjckg7SUFDakQsSUFBSXNILGNBQWNuQjtJQUNsQixJQUFJa0IsZ0JBQWdCLE1BQU07UUFDeEIsT0FBT0M7QUFDUjtJQUVELEtBQUssTUFBTTVNLE9BQU8yTSxjQUFjO1FBQzlCLElBQUlFLE9BQU9sWixVQUFVbVosZUFBZUMsS0FBS0osY0FBYzNNLE1BQU07WUFDM0Q0TSxZQUFZNU0sT0FBTzJNLGFBQWEzTTtBQUNqQztBQUNGO0lBRUQsSUFBSWdILE1BQU0yRixhQUFhO0lBQ3ZCQyxZQUFZTixTQUFTVSxpQkFBd0J2SyxnQkFBdUJ1RSxLQUFLO0lBQ3pFNEYsWUFBWWQsVUFBVXRSLE1BQU00SixLQUFLNUgsU0FBU3lRO0lBQzFDTCxZQUFZYixVQUFVdlIsTUFBTTRKLEtBQUsySDtJQUNqQ2EsWUFBWWhCLFVBQVVoSixNQUFNQyxXQUFXZ0osdUJBQXVCLEdBQUdlLFlBQVlOO0lBRzdFLElBQUlLLGFBQWFPLDBCQUEwQixNQUFNO1FBQy9DTixZQUFZUixzQkFBc0J4SixNQUFNdUs7QUFDNUMsV0FBUztRQUNMUCxZQUFZUixzQkFBc0J4SixNQUFNd0s7QUFDekM7SUFDRFIsWUFBWVMsaUJBQWlCVixhQUFhVTtJQUMxQ1QsWUFBWVAscUJBQXFCLEdBQUdXLGlCQUF3Qk0sZUFBc0JYLGFBQWFVLGdCQUFnQjtJQUMvRyxJQUFJVixhQUFhWSxtQkFBbUJaLGFBQWFhLFdBQVc7UUFDMURaLFlBQVlaLFdBQVdwSixNQUFNQyxXQUFXNEssK0JBQ3RDLEdBQUdkLGFBQWFZLG1CQUNoQixHQUFHWixhQUFhYTtBQUV0QixXQUFTO1FBQ0xaLFlBQVlaLFdBQVc7QUFDeEI7SUFFRFksWUFBWTVILGNBQWUySCxhQUFhM0gsZUFBZSxPQUFRLENBQUUsSUFBRzJILGFBQWEzSDtJQUNqRjRILFlBQVlILGdCQUFnQkUsYUFBYUY7SUFDekNHLFlBQVl6RyxnQkFBZ0J3RyxhQUFheEc7SUFDekN5RyxZQUFZYyxZQUFZZixhQUFhZTtJQUNyQyxJQUFJZCxZQUFZSCxpQkFBaUIsR0FBRztRQUNsQ0csWUFBWUosWUFBWTtRQUV4Qm1CLGNBQXlCZixhQUFhdEg7QUFDMUMsV0FBUztRQUVMc0gsWUFBWUosWUFBWTtBQUN6QjtJQUVELElBQUlnQixZQUFZYixhQUFhYTtJQUM3QlosWUFBWWdCLG1CQUFtQmpCLGFBQWFpQjtJQUk1Q2hCLFlBQVlWLGVBQWUsRUFDekI7UUFBRTVKLE1BQU07UUFBVWpCLE9BQU91QixNQUFNaUw7UUFBMEJDLFdBQVc7UUFBSUMsTUFBTSxHQUFHcEIsYUFBYXFCO09BQzlGO1FBQUUxTCxNQUFNO1FBQVVqQixPQUFPdUIsTUFBTXFMO1FBQTRCSCxXQUFXO1FBQUlDLE1BQU0sR0FBR3BCLGFBQWFZO09BQ2hHO1FBQUVqTCxNQUFNO1FBQVVqQixPQUFPdUIsTUFBTXNMO1FBQTBCSixXQUFXO1FBQUlDLE1BQU0sR0FBR3BCLGFBQWFlO09BQzlGO1FBQUVwTCxNQUFNO1FBQVVqQixPQUFPO1FBQUl5TSxXQUFXbEwsTUFBTXVMO1FBQThCSixNQUFNLEdBQUdQOztJQUV2RixPQUFPWjtBQUNUOztBQUVBLFNBQVN3QixZQUFZQztJQUNuQixJQUFJQSxZQUFZN1QsTUFBTTRKLEtBQUtDLFdBQVcvUCxTQUFTLEdBQUc7UUFDaEQsT0FBT21YO0FBQ1I7SUFDRCxPQUFPalIsTUFBTTRKLEtBQUtDLFdBQVdnSztBQUMvQjs7QUFFQXpULGVBQWUwVCxzQkFBc0JDO0lBQ25DLElBQUlBLFNBQVNySCxhQUFhLEdBQUc7UUFDM0JxSCxTQUFTaEMsU0FBUztRQUNsQjtBQUNEO0lBQ0QsSUFBSWlDLFdBQVc7UUFDYmpKLFdBQVdnSixTQUFTaEo7UUFDcEJrSixLQUFLRixTQUFTckg7O0lBR2hCLE1BQU03SixhQUFhcVIsWUFBbUIsNENBQTRDRjtJQUNsRmxVLFFBQVFDLElBQUkscUJBQXFCVSxLQUFLbkcsVUFBVXVJO0lBQ2hELElBQUlBLFFBQVEsUUFBUUEsS0FBS3NSLGtCQUFrQjtRQUN6Q0osU0FBU2hDLFNBQVMsR0FBR2xQLEtBQUtzUjtBQUM5QixXQUFTO1FBQ0xKLFNBQVNoQyxTQUFTO0FBQ25CO0FBQ0g7O0FBR0EsU0FBU3FDLGdCQUFjTDtJQUVyQixNQUFNTSxXQUFXNUgsV0FBV3NILFNBQVNySDtJQUNyQyxNQUFNb0YsU0FBU3JGLFdBQVdzSCxTQUFTakM7SUFDbkMsTUFBTVAsVUFBVXdDLFNBQVN4QyxXQUFXLE9BQU8sSUFBSTlFLFdBQVdzSCxTQUFTeEM7SUFFbkUsTUFBTXNCLGlCQUFpQnBHLFdBQVdzSCxTQUFTbEI7SUFFM0MsSUFBSXdCLFdBQVc5QyxTQUFTO1FBQ3RCd0MsU0FBU3RDLGlCQUFpQjtRQUMxQnNDLFNBQVNPLGNBQWNsTSxNQUFNbU07UUFDN0JSLFNBQVNTLGNBQWM7UUFDdkIsT0FBTztBQUNYLFdBQVMsSUFBSUgsV0FBV3ZDLFFBQVE7UUFDNUJpQyxTQUFTdEMsaUJBQWlCO1FBQzFCc0MsU0FBU08sY0FBY2xNLE1BQU1DLFdBQVdvTSxrQ0FBa0MsR0FBRzNDLFVBQVUsR0FBR2lDLFNBQVN6QztRQUNuR3lDLFNBQVNTLGNBQWM7UUFDdkIsT0FBTztBQUNYLFdBQVMsSUFBSUgsV0FBV3hCLGdCQUFnQjtRQUNwQ2tCLFNBQVN0QyxpQkFBaUI7UUFDMUJzQyxTQUFTTyxjQUFjbE0sTUFBTXNNO1FBQzdCWCxTQUFTUyxjQUFjO1FBQ3ZCLE9BQU87QUFDWCxXQUFTO1FBQ0xULFNBQVN0QyxpQkFBaUI7UUFDMUJzQyxTQUFTUyxjQUFjO1FBQ3ZCLE9BQU87QUFDUjtBQUNIOztBQUVBclUsY0FBWXdVLGdCQUFnQixTQUFVQyxVQUFVZjtJQUM5QyxJQUFJRSxXQUFXSCxZQUFZQztJQUMzQi9ULFFBQVFDLElBQUksbUJBQW1CNlU7SUFDL0JiLFNBQVNySCxZQUFZa0k7SUFFckJkLHNCQUFzQkM7SUFDdEIsSUFBSXJJLFNBQVVrSixTQUFTOWEsV0FBVyxJQUFLLElBQUkrYSxVQUFpQkQ7SUFDNURFLGNBQXlCcEosUUFBUXFJO0lBRWpDLEtBQUtLLGdCQUFjTCxXQUFXO1FBQzVCQSxTQUFTZ0IsY0FBYztRQUN2QjlVLE9BQU8rVSxRQUFRQyxlQUFlbEIsU0FBU2pSLFFBQVFpUixTQUFTZ0I7UUFDeEQ7QUFDRDtJQUNEaEIsU0FBU2dCLGNBQWNoQixTQUFTUyxlQUFlLFVBQVVULFNBQVNySCxhQUFhO0lBRS9FLElBQUl6TSxPQUFPK1UsUUFBUUMsZUFBZWxCLFNBQVNqUixRQUFRaVIsU0FBU2dCO0FBRzlEOztBQUVBNVUsY0FBWStVLGlCQUFpQixTQUFVQyxPQUFPdEI7SUFDNUMvVCxRQUFRQyxJQUFJLG9CQUFvQm9WO0FBQ2xDOztBQUVBaFYsY0FBWWlWLGNBQWMsU0FBVUMsV0FBV3hCO0lBQzdDL1QsUUFBUUMsSUFBSSxpQkFBaUJzVjtJQUM3QixJQUFJdEIsV0FBV0gsWUFBWUM7SUFDM0JFLFNBQVM1QyxhQUFhO0FBQ3hCOztBQUVBaFIsY0FBWW1WLGFBQWEsU0FBVXpCO0lBQ2pDLElBQUlFLFdBQVdILFlBQVlDO0lBQzNCRSxTQUFTNUMsYUFBYTtBQUN4Qjs7QUFFQWhSLGNBQVlvVixTQUFTLFNBQVUxQjtJQUM3QixJQUFJRSxXQUFXSCxZQUFZQztJQUUzQixJQUFJRSxTQUFTeEMsV0FBVyxNQUFNO1FBQzVCd0MsU0FBUzdDLFdBQVdsUixNQUFNNEosS0FBSzRMLFlBQVk3YixRQUFRLE1BQU07UUFDekRvYSxTQUFTckgsWUFBWXFILFNBQVM3QztRQUM5QixJQUFJdEMsV0FBa0I5TixNQUFNLEdBQUc7WUFDN0JYLGNBQVl3VSxjQUFjWixTQUFTckgsV0FBV21IO0FBQy9DO0FBQ0wsV0FBUztRQUNMRSxTQUFTN0MsV0FBVztRQUNwQjZDLFNBQVNySCxZQUFZcUgsU0FBUzdDO0FBQy9CO0lBQ0R1RSxTQUFtQjFCO0FBQ3JCOztBQUdBNVQsY0FBWXVWLHdCQUF3QixTQUFVN0I7SUFDNUMsSUFBSUEsWUFBWTdULE1BQU00SixLQUFLQyxXQUFXL1AsU0FBUyxHQUFHO1FBQ2hEO0FBQ0Q7SUFDRCxJQUFJaWEsV0FBV0gsWUFBWUM7SUFDM0JFLFNBQVM1QyxhQUFhO0lBRXRCbFIsT0FBTzBWLE9BQU9DLHlCQUF5QjdCO0lBQ3ZDOEIsaUJBQTJCOUI7QUFDN0I7O0FBRUE1VCxjQUFZMlYsY0FBYztJQUN4QkM7QUFDRjs7QUN6T0EvVixNQUFNMlYsU0FBUztJQUNiSyxjQUFjNU4sTUFBTTZOO0lBQ3BCckUscUJBQXFCO0lBQ3JCc0UsYUFBYTtJQUNiQyxTQUFTO0lBQ1RDLFNBQVM7SUFDVEMsU0FBUztJQUNUQyxTQUFTO0lBQ1RDLFlBQVk7SUFDWkMsWUFBWTtJQUNaQyxZQUFZO0lBQ1pDLG1CQUFtQjtJQUNuQkMsb0JBQW9CO0lBQ3BCQyxrQkFBa0I7SUFDbEJDLHFCQUFxQjtJQUNyQkMsZUFBZTtJQUNmQyxrQkFBa0I7SUFDbEJDLFNBQVM7SUFDVEMsZ0JBQWdCO0lBQ2hCQyxXQUFXO0lBQ1hDLFVBQVU7OztBQUdaLE1BQU1DLGFBQWE7SUFDakJDLFlBQVk7SUFDWkMsWUFBWTs7O0FBR2RyWCxPQUFPMFYsU0FBUztJQUVkLGlCQUFBZSxDQUFrQmxMLE9BQU8sSUFBSStMLFlBQVksTUFBTTVOO1FBQzdDM0osTUFBTTJWLE9BQU9PLGNBQWMxSztRQUMzQixJQUFJK0wsYUFBYSxRQUFRQSxVQUFVemQsVUFBVSxHQUFHO1lBQzlDa0csTUFBTTJWLE9BQU9rQixzQkFBc0I7QUFDekMsZUFBVztZQUNMN1csTUFBTTJWLE9BQU9pQixtQkFBbUJXO1lBQ2hDdlgsTUFBTTJWLE9BQU9rQixzQkFBc0I7QUFDcEM7UUFDRCxJQUFJVyxhQUFhN04sUUFBUStDO1FBQ3pCMU0sTUFBTTJWLE9BQU9tQixnQkFBZ0IsR0FBR1UsY0FBY3hYLE1BQU00SixLQUFLNUg7UUFDekRoQyxNQUFNMlYsT0FBT2Usb0JBQW9CO1FBRWpDNVcsUUFBUUMsSUFBSSxxQ0FBcUN5WDtRQUNqRHhYLE1BQU0yVixPQUFPb0IsbUJBQW1CO1FBQ2hDL1csTUFBTTJWLE9BQU93QixXQUFXSztRQUN4QnhYLE1BQU0yVixPQUFPdUIsWUFBWTtRQUN6QmxYLE1BQU0yVixPQUFPc0IsaUJBQWlCO1FBRTlCLElBQUlRLGlCQUFpQjlOLFFBQVErTjtRQUM3QjVYLFFBQVFDLElBQUksNkNBQTZDVSxLQUFLbkcsVUFBVW1kO1FBQ3hFLFdBQVcsa0JBQW1CLGVBQWVBLGtCQUFrQixNQUFNO1lBQ25FLElBQUlFLFlBQVlGLGVBQWUzTztZQUMvQixXQUFXLGFBQWMsYUFBYTtnQkFDcENoSixRQUFRQyxJQUFJLG9EQUFvRFUsS0FBS25HLFVBQVVxZDtnQkFFL0UsS0FBSSxJQUFJdGUsSUFBSSxHQUFHQSxJQUFHc2UsVUFBVTdkLFFBQVFULEtBQU07b0JBQ3hDLElBQUlxUCxPQUFPaVAsVUFBVXRlO29CQUNyQnlHLFFBQVFDLElBQUksZ0RBQWdEMkksS0FBS2tQO29CQUNqRSxJQUFJbFAsS0FBS21QLFlBQVksNkNBQTZDO3dCQUVoRTtBQUNEO29CQUNELElBQUluUCxLQUFLNkksVUFBVSxHQUFFO3dCQUVuQnpSLFFBQVFDLElBQUksd0NBQXdDMkksS0FBS2tQO3dCQUN6RDVYLE1BQU0yVixPQUFPdUIsYUFBYXhPLEtBQUtrUDtBQUNoQztvQkFDRCxJQUFJbFAsS0FBS2tQLFVBQVVSLFdBQVdDLFlBQVk7d0JBRXhDLElBQUlTLE9BQU9DLFNBQWdCclAsS0FBSzZJLFNBQVNpRzt3QkFDekN4WCxNQUFNMlYsT0FBT3dCLFdBQVdXO3dCQUN4QmhZLFFBQVFDLElBQUksb0NBQW9DK1g7d0JBQ2hELElBQUlBLE9BQU8sR0FBRzs0QkFFWjlYLE1BQU0yVixPQUFPc0IsaUJBQWlCOzRCQUU5QixJQUFJZSxVQUFVeEYsaUJBQXdCdkssZ0JBQXVCNlAsTUFBTTs0QkFDbkU5WCxNQUFNMlYsT0FBT3FCLFVBQVU1TyxNQUFNQyxXQUFXNFAsdUJBQXVCLElBQUlEOzRCQUVuRSxJQUFJdFAsS0FBSzZJLFVBQVUsR0FBRztnQ0FDcEIsSUFBSTJHLGFBQWExRixpQkFBd0J2SyxnQkFBdUJTLEtBQUs2SSxTQUFTO2dDQUM5RSxJQUFJNEcsWUFBWTtvQ0FDZHJRLE1BQUs7b0NBQ0w5RixVQUFVb0csTUFBTUMsV0FBVytQLDZCQUE2QixHQUFHcFksTUFBTTRKLEtBQUs1SDtvQ0FDdEUzRCxPQUFNLEdBQUc2WixjQUFjbFksTUFBTTRKLEtBQUs1SDs7Z0NBRXBDaEMsTUFBTTJWLE9BQU9vQixpQkFBaUJyYyxLQUFLeWQ7QUFDcEM7NEJBQ0QsSUFBSUUsWUFBWTtnQ0FDZHZRLE1BQUs7Z0NBQ0w5RixVQUFVb0csTUFBTUMsV0FBVytQLDZCQUE2QjtnQ0FDeEQvWixPQUFNLElBQUkyWjs7NEJBRVpoWSxNQUFNMlYsT0FBT29CLGlCQUFpQnJjLEtBQUsyZDtBQUNwQztBQUNGLDJCQUFNLElBQUkzUCxLQUFLa1AsVUFBVVIsV0FBV0UsWUFBWTt3QkFFL0MsSUFBSXRYLE1BQU0yVixPQUFPd0IsWUFBWUssWUFBWTs0QkFDdkN4WCxNQUFNMlYsT0FBT3NCLGlCQUFpQjs0QkFDOUJqWCxNQUFNMlYsT0FBT3FCLFVBQVU1TyxNQUFNQyxXQUFXNFAsdUJBQXVCLEdBQUdUOzRCQUNsRSxJQUFJYyxnQkFBZ0I5RixpQkFBd0J2SyxnQkFBdUJ1UCxZQUFZOzRCQUMvRSxJQUFJYSxZQUFZO2dDQUNkdlEsTUFBSztnQ0FDTDlGLFVBQVVvRyxNQUFNQyxXQUFXK1AsNkJBQTZCO2dDQUN4RC9aLE9BQU0sR0FBR2lhOzs0QkFFWHRZLE1BQU0yVixPQUFPb0IsaUJBQWlCcmMsS0FBSzJkO0FBQ3BDO0FBQ0Y7QUFDRjtBQUNGO0FBRUY7UUFFRCxJQUFJclksTUFBTTJWLE9BQU91QixhQUFhLEdBQUc7WUFDL0JsWCxNQUFNMlYsT0FBT3VCLFlBQVk7QUFDMUI7UUFDRHFCLGdCQUEwQjVPO0FBQzNCO0lBRUQsa0JBQUE2TztRQUNFeFksTUFBTTJWLE9BQU9lLG9CQUFvQjtBQUNsQztJQUdELHdCQUFBZCxDQUF5QjZDO1FBQ3ZCLEtBQUtBLFNBQVM7WUFDWjtBQUNEO1FBQ0QsSUFBSUMsWUFBWTtRQUNoQixJQUFJQyxpQkFBaUI7UUFDckIsTUFBTTNXLFdBQVdoQyxNQUFNNEosS0FBSzVIO1FBRTVCLElBQUk0TSxXQUFrQi9OLGFBQWEsR0FBRztZQUNwQzZYLFlBQVk7WUFDWkMsaUJBQWlCO0FBQ2xCO1FBQ0Q3WSxRQUFRQyxJQUFJLHVDQUF1QzBZLFFBQVFHLG1DQUFtQ0gsUUFBUTVGLGtCQUFrQjRGLFFBQVEvRiw0QkFBNEIrRixRQUFRSTtRQUNwSyxJQUFJRCxrQkFBa0JwRyxpQkFBd0JNLGVBQXNCMkYsUUFBUUcsaUJBQWlCO1FBQzdGLElBQUkvRixpQkFBaUJMLGlCQUF3Qk0sZUFBc0IyRixRQUFRNUYsZ0JBQWdCO1FBQzNGLElBQUk0RixRQUFRL0YsMEJBQTBCLE1BQU07WUFDMUMsSUFBSUEseUJBQXlCRixpQkFBd0JNLGVBQXNCMkYsUUFBUS9GLHdCQUF3QjtZQUUzRzFTLE1BQU0yVixPQUFPL0Qsc0JBQXNCeEosTUFBTXdLO1lBQ3pDNVMsTUFBTTJWLE9BQU9RLFVBQVUvTixNQUFNMFE7WUFDN0I5WSxNQUFNMlYsT0FBT1MsVUFBVWhPLE1BQU0yUTtZQUM3Qi9ZLE1BQU0yVixPQUFPVSxVQUFVak8sTUFBTTRRO1lBQzdCaFosTUFBTTJWLE9BQU9XLFVBQVVsTyxNQUFNNlE7WUFDN0JqWixNQUFNMlYsT0FBT1ksYUFBYSxzQkFBc0JtQywrQkFBK0J0USxNQUFNOFEsNkRBQTZEUCxvQ0FBb0NDLG1CQUFtQjVXO1lBQ3pNaEMsTUFBTTJWLE9BQU9hLGFBQWEsc0JBQXNCa0MsK0JBQStCdFEsTUFBTStRLHNFQUFzRVIsb0NBQW9DakcsMEJBQTBCMVE7WUFDek5oQyxNQUFNMlYsT0FBT2MsYUFBYSxzQkFBc0JpQywrQkFBK0J0USxNQUFNdUssMkRBQTJEZ0csb0NBQW9DOUYsa0JBQWtCN1E7QUFDNU0sZUFBVztZQUNMLElBQUk2VyxnQkFBZ0JyRyxpQkFBd0JNLGVBQXNCMkYsUUFBUUksZUFBZTtZQUV6RjdZLE1BQU0yVixPQUFPL0Qsc0JBQXNCeEosTUFBTXVLO1lBQ3pDM1MsTUFBTTJWLE9BQU9RLFVBQVUvTixNQUFNZ1I7WUFDN0JwWixNQUFNMlYsT0FBT1MsVUFBVWhPLE1BQU1pUjtZQUM3QnJaLE1BQU0yVixPQUFPVSxVQUFVak8sTUFBTTRRO1lBQzdCaFosTUFBTTJWLE9BQU9XLFVBQVVsTyxNQUFNa1I7WUFDN0J0WixNQUFNMlYsT0FBT1ksYUFBYSxzQkFBc0JtQywrQkFBK0J0USxNQUFNOFEsNkRBQTZEUCxvQ0FBb0NDLG1CQUFtQjVXO1lBQ3pNaEMsTUFBTTJWLE9BQU9hLGFBQWEsc0JBQXNCa0MsK0JBQStCdFEsTUFBTW1SLGdFQUFnRVosb0NBQW9DRSxpQkFBaUI3VztZQUMxTWhDLE1BQU0yVixPQUFPYyxhQUFhLHNCQUFzQmlDLCtCQUErQnRRLE1BQU11SywyREFBMkRnRyxvQ0FBb0M5RixrQkFBa0I3UTtBQUN2TTtRQUNEaEMsTUFBTTJWLE9BQU9nQixxQkFBcUI7QUFDbkM7SUFFRCx5QkFBQTZDO1FBQ0V4WixNQUFNMlYsT0FBT2dCLHFCQUFxQjtBQUNuQzs7O0FDeEtILElBQUk1TCxZQUFZOztBQUNoQixJQUFJME8sWUFBWTs7QUFFaEIsU0FBU0M7SUFDUCxPQUFPO1FBQ0xDLHFCQUFxQjtRQUNyQkMsU0FBUztRQUNUNVgsVUFBVTtRQUNWaUYsS0FBSztRQUNMNFMsZUFBZTtRQUNmQyxXQUFXO1FBQ1hDLFVBQVU7O0FBRWQ7O0FBRUEsbUJBQVE3WixjQUFVQyxhQUFFQSxpQkFBZ0I2USxhQUFvQixVQUFVMEksZUFBYTtJQUFBbGEsVUFBRUE7OztBQUNqRixJQUFJNkMsU0FBUyxDQUFBOztBQUliLFNBQVM3QyxXQUFTcUM7SUFDaEIvQixRQUFRQyxJQUFJLG9CQUFvQjhCO0lBQ2hDUSxTQUFTNUIsS0FBS3hILE1BQU00STtJQUNwQjNCLGFBQVc4WixZQUFZM1gsT0FBTzJYLFlBQVkzWCxPQUFPMlgsWUFBWTtJQUM3RHJZLFlBQVc7UUFDVHpCLGFBQVd5WixzQkFBc0I7UUFDaEM7SUFFSCxJQUFJdFgsT0FBT3NNLGVBQWUsS0FBS3RNLE9BQU93TSxXQUFXLEdBQUc7UUFDbEQzTyxhQUFXNlosV0FBVztBQUMxQixXQUFTO1FBQ0w3WixhQUFXNlosV0FBVztBQUN2QjtJQUVEN1osYUFBVzJaLGdCQUFnQjtJQUMzQkksbUJBQW1CNVgsT0FBTzZYLFNBQVM3WCxPQUFPOFg7SUFDMUNDO0FBQ0Y7O0FBRUFoYSxlQUFlNlosbUJBQW1CQyxTQUFTQztJQUN6QyxNQUFNOVgsU0FBUztRQUFFNlg7UUFBU0M7O0lBQzFCLE1BQU10WCxhQUFhcVIsWUFBbUIsNkNBQTZDN1IsUUFBUSxHQUFHLEdBQUc7UUFBRSxnQkFBZ0I7O0lBQ25ILElBQUlRLFFBQVEsTUFBTTtRQUNoQixJQUFJQSxLQUFLd1gsVUFBVXZnQixTQUFTLEdBQUc7WUFDN0IsTUFBTTZQLFVBQVU5RyxLQUFLd1gsVUFBVTtZQUMvQm5hLGFBQVcwWixVQUFVVSx3QkFBK0IzUSxRQUFRM0g7WUFDNUQ5QixhQUFXOEIsV0FBVzJILFFBQVEzSCxTQUFTeVE7WUFDdkN2UyxhQUFXNFosWUFBWW5RLFFBQVE0USxvQkFBb0IsSUFBSSxZQUFZO1lBQ25FeFAsWUFBWSxHQUFHcEIsUUFBUW9CO1lBQ3ZCLElBQUl5UCxVQUFVO1lBQ2RmLFlBQVk5UCxRQUFROFAsWUFBWWdCLE9BQU85USxRQUFROFAsYUFBYTtZQUM1RCxJQUFJL0ssT0FBTy9FLFFBQVErRSxPQUFPLEdBQUcvRSxRQUFRK0UsU0FBUztZQUM5QyxRQUFRK0s7Y0FDTixLQUFLO2dCQUNIZSxVQUFVcFMsTUFBTXNTO2dCQUNoQjs7Y0FDRixLQUFLO2dCQUNIRixVQUFVcFMsTUFBTUMsV0FBV3NTLHFDQUFxQyxHQUFHak07Z0JBQ25FOztjQUNGLEtBQUs7Z0JBQ0g4TCxVQUFVcFMsTUFBTXdTO2dCQUNoQjs7Y0FDRixLQUFLO2dCQUNISixVQUFVcFMsTUFBTXlTO2dCQUNoQjs7Y0FDRixLQUFLO2dCQUNITCxVQUFVcFMsTUFBTTBTO2dCQUNoQjs7WUFJSjVhLGFBQVdzYSxVQUFVQTtZQUVyQixJQUFJTyxlQUFlO1lBQ25CLElBQUlDLGtCQUFrQjtZQUN0QixJQUFJclIsUUFBUW9SLGNBQWM7Z0JBQ3hCQSxlQUFlLEdBQUc5UyxnQkFBdUJDLFNBQWdCeUIsUUFBUW9SLGNBQWMsUUFBUTtBQUN4RjtZQUNELElBQUlwUixRQUFRcVIsaUJBQWlCO2dCQUMzQkEsa0JBQWtCLEtBQUsvUyxnQkFBdUJDLFNBQWdCeUIsUUFBUXFSLGlCQUFpQixRQUFRO0FBQ2hHO1lBQ0Q5YSxhQUFXK0csTUFBTSxHQUFHOFQsZUFBZUM7WUFFbkM5YSxhQUFXMlosZ0JBQWdCO0FBQzVCO0FBQ0Y7QUFDSDs7QUFFQTFaLGNBQVk4YSxlQUFlO0lBRXpCQyxRQUFlLEdBQUd0TSxXQUFrQjNOLFNBQVMyTixXQUFrQjFOLDhDQUE4Q21CLE9BQU9zTTtJQUNwSG9ILGVBQXNCO0lBQ3RCb0Y7QUFDRjs7QUFFQWhiLGNBQVlpYixjQUFjO0lBQ3hCckY7SUFDQXNGO0FBQ0Y7O0FBRUFsYixjQUFZNk8sWUFBWTtJQUN0QitHO0lBQ0F1RjtBQUNGOztBQUVBbmIsY0FBWW9iLGlCQUFpQjtJQUMzQixJQUFJOUIsYUFBYSxNQUFNO1FBQ3JCMUQsZUFBc0I7UUFFdEIsSUFBSXRVLE1BQU07UUFDVnlaLFFBQWV6WjtBQUNuQixXQUFTO1FBQ0wsTUFBTVksU0FBUztZQUFFMEk7WUFBVy9JLFVBQVU5QixhQUFXOEI7WUFBVXdaLFVBQVU7O1FBQ3JFdmIsT0FBTzJKLEtBQUs2UixpQkFBaUJoYixLQUFLbkcsVUFBVStIO1FBQzVDMFQ7QUFDRDtBQUNIOztBQ3JIQSxNQUFNOVAsUUFBTTs7QUFFWmpHLE1BQU0wYixnQkFBZ0I7SUFDcEIvWCxRQUFRO0lBQ1JnWSxTQUFTOzs7QUFHWDFiLE9BQU95YixnQkFBZ0I7SUFJckJFLG1CQUFtQixTQUFVclUsT0FBTzZMLG1CQUFtQjtRQUNyRHRULFFBQVFDLElBQUksR0FBR2tHLGtDQUFnQ3NCLDJCQUEyQjZMO1FBQzFFcFQsTUFBTTBiLGNBQWNDLFVBQVV2VCxNQUFNQyxXQUFXd1QsOEJBQThCLEdBQUd6STtRQUNoRnBULE1BQU0wYixjQUFjL1gsU0FBUztRQUM3QixJQUFJZ0csVUFBVTFKLE9BQU8ySixLQUFLOEcsa0JBQWtCbko7UUFDNUN1VSxpQkFBMkJuUztBQUM1QjtJQUtEb1MsbUJBQW1CLFNBQVV4VSxPQUFPeVU7UUFDbENsYyxRQUFRQyxJQUFJLEdBQUdrRyxrQ0FBZ0NzQiw0QkFBNEJ5VTtRQUMzRSxJQUFJQSxvQkFBb0IsR0FBRztZQUN6QixJQUFJQyxRQUFRbkosZUFBc0JrSixtQkFBbUI7WUFDckQsSUFBSUUsU0FBU3BKLGVBQXNCa0osb0JBQW9CLEtBQU07WUFDN0QsSUFBSUcsU0FBU3JKLGVBQXNCa0osb0JBQW9CLElBQUs7WUFDNUQsSUFBSWhhLFdBQVdoQyxNQUFNNEosS0FBSzVIO1lBQzFCLElBQUlvYSxLQUFLaFUsTUFBTUMsV0FBV2dVLGdDQUFnQyxHQUFHSixTQUFTLEdBQUdqYTtZQUN6RSxJQUFJc2EsS0FBS2xVLE1BQU1DLFdBQVdrVSxnQ0FBZ0MsR0FBR04sU0FBUyxHQUFHamE7WUFDekUsSUFBSXdhLEtBQUtwVSxNQUFNQyxXQUFXb1UsZ0NBQ3hCLEdBQUdQLFVBQ0gsR0FBR2xhLFlBQ0gsR0FBR21hLFVBQ0gsR0FBR25hLFlBQ0gsR0FBR2lhLFNBQ0gsR0FBR2phLFlBQ0gsR0FBR21hLFVBQ0gsR0FBR25hO1lBRUwsSUFBSTBhLEtBQUt0VSxNQUFNQyxXQUFXc1U7WUFDMUIzYyxNQUFNMGIsY0FBY0MsVUFBVSxHQUFHUyxPQUFPRSxPQUFPRSxPQUFPRTtBQUM1RCxlQUFXO1lBQ0wxYyxNQUFNMGIsY0FBY0MsVUFBVSxHQUFHdlQsTUFBTXdVLG1DQUFtQ3hVLE1BQU15VTtBQUNqRjtRQUNEN2MsTUFBTTBiLGNBQWMvWCxTQUFTO1FBQzdCLElBQUlnRyxVQUFVMUosT0FBTzJKLEtBQUs4RyxrQkFBa0JuSjtRQUM1Q3VVLGlCQUEyQm5TO0FBQzVCO0lBRURpQixhQUFhO1FBQ1g1SyxNQUFNMGIsY0FBYy9YLFNBQVM7QUFDOUI7OztBQ3RESSxNQUFNbVosY0FBYztJQUN6QmpXLE9BQU91QixNQUFNMlU7SUFDYkMsU0FBUzVVLE1BQU02VTs7O0FBR2pCamQsTUFBTWtkLFdBQVc7SUFDZnZaLFFBQVE7SUFDUndaLFVBQVVMLFlBQVlqVztJQUN0QnVXLFlBQVlOLFlBQVlFOzs7QUFHMUIvYyxPQUFPaWQsV0FBVztJQUNoQkcsWUFBWSxTQUFVeFcsT0FBT21XO1FBQzNCaGQsTUFBTWtkLFNBQVNDLFdBQVd0VztRQUMxQjdHLE1BQU1rZCxTQUFTRSxhQUFhSjtBQUM3QjtJQUVEelMsWUFBWTtRQUNWdkssTUFBTWtkLFNBQVN2WixTQUFTO1FBQ3hCMlo7QUFDRDtJQUVEMVMsYUFBYTtRQUNYNUssTUFBTWtkLFNBQVN2WixTQUFTO0FBQ3pCOzs7QUMxQkksTUFBTTRaLGlCQUFpQjtJQUM1QjFXLE9BQU91QixNQUFNMlU7SUFDYkMsU0FBUTs7O0FBR1ZoZCxNQUFNd2QsY0FBYztJQUNsQjdaLFFBQVE7SUFDUndaLFVBQVVJLGVBQWUxVztJQUN6QnVXLFlBQVlHLGVBQWVQOzs7QUFHN0IvYyxPQUFPdWQsY0FBYztJQUNuQkgsWUFBWSxTQUFVeFcsT0FBT21XO1FBQzNCaGQsTUFBTXdkLFlBQVlMLFdBQVd0VztRQUM3QjdHLE1BQU13ZCxZQUFZSixhQUFhSjtBQUNoQztJQUVEelMsWUFBWTtRQUNWdkssTUFBTXdkLFlBQVk3WixTQUFTO0FBQzVCO0lBRURpSCxhQUFhO1FBQ1g1SyxNQUFNd2QsWUFBWTdaLFNBQVM7QUFDNUI7OztBQ3JCSCxNQUFNc0MsUUFBTTs7QUFFWixNQUFNd1gsY0FBWTtJQUNoQkMsU0FBUztJQUNUQyxXQUFXO0lBR1hDLGVBQWU7SUFDZkMsaUJBQWlCO0lBQ2pCblgsYUFBYTtJQUNiQyxlQUFlOzs7QUFHakIsTUFBTW1YO0lBQ0pDLFdBQWE7SUFDYkMsS0FBTztJQUNQbFcsS0FBTztJQUVQLGFBQUFtVyxDQUFjdlYsTUFBTTFHO1FBQ2xCLElBQUkwRyxLQUFLd1YsYUFBYSxHQUFHO1lBQ3ZCdGxCLEtBQUttbEIsYUFBYSxHQUFHclYsS0FBS3lWLGlCQUFpQnpWLEtBQUt3VixhQUFhbGM7QUFDbkUsZUFBVztZQUNMcEosS0FBS21sQixhQUFhLEtBQUtyVixLQUFLeVYsZUFBZW5jO0FBQzVDO0FBQ0Y7OztBQU1ILE1BQU1vYztJQUNKN1csT0FBUztJQUNUdkYsU0FBVztJQUNYcWMsYUFBZTtJQUNmQyxjQUFnQjtJQUNoQjVYLFlBQWM7SUFDZG9CLEtBQU87OztBQUlUOUgsTUFBTXVlLFNBQVM7SUFDYjVhLFFBQVE7SUFDUmtELE9BQU91QixNQUFNb1c7SUFDYkMsS0FBS3JXLE1BQU1zVztJQUNYQyxTQUFTO0lBQ1RDLFlBQVk7SUFDWkMsWUFBWXpXLE1BQU0wVztJQUNsQkMsZUFBZTtJQUNmQyxVQUFVdkIsWUFBVUU7SUFDcEJzQixXQUFXN1csTUFBTThXO0lBQ2pCQyxZQUFZL1csTUFBTWdYO0lBQ2xCQyxZQUFZO0lBQ1pDLGFBQWE7SUFDYkMsaUJBQWlCOzs7QUFHbkJ0ZixPQUFPc2UsU0FBUztJQUlkaUIsa0JBQWtCO1FBQ2hCQztBQUNEO0lBRURsVixZQUFZbkssZUFBZ0JtSDtRQUMxQixJQUFJdkYsV0FBV2hDLE1BQU00SixLQUFLNUg7UUFDMUJsQyxRQUFRQyxJQUFJLEdBQUdrRywwQkFBd0JqRTtRQUN2Q2hDLE1BQU11ZSxPQUFPUSxnQkFBZ0IvYztRQUM3QixLQUFLLElBQUkzSSxJQUFJLEdBQUdBLElBQUkyRyxNQUFNdWUsT0FBT2dCLGdCQUFnQnpsQixRQUFRVCxLQUFLO1lBQzVELElBQUlxUCxPQUFPMUksTUFBTXVlLE9BQU9nQixnQkFBZ0JsbUI7WUFDeEMsSUFBSTJJLFlBQVkwRyxLQUFLMUcsVUFBVTtnQkFDN0IwRyxLQUFLNFYsZ0JBQWdCYixZQUFVRztnQkFDL0JsVixLQUFLaEMsY0FBYytXLFlBQVUvVztzQkFDdkJnWixpQkFBaUIxZDtBQUMvQixtQkFBYTtnQkFDTDBHLEtBQUs0VixnQkFBZ0JiLFlBQVVJO2dCQUMvQm5WLEtBQUtoQyxjQUFjK1csWUFBVTlXO0FBQzlCO0FBQ0Y7UUFDRDNHLE1BQU11ZSxPQUFPNWEsU0FBUztBQUN2QjtJQUVEaUgsYUFBYTtRQUNYNUssTUFBTXVlLE9BQU81YSxTQUFTO0FBQ3ZCO0lBR0RnYyxhQUFhLFNBQVVDO1FBQ3JCOWYsUUFBUUMsSUFBSSxHQUFHa0csMEJBQXdCMlo7UUFDdkMsS0FBSyxJQUFJdm1CLElBQUksR0FBR0EsSUFBSTJHLE1BQU11ZSxPQUFPZ0IsZ0JBQWdCemxCLFFBQVFULEtBQUs7WUFDNUQsSUFBSXFQLE9BQU8xSSxNQUFNdWUsT0FBT2dCLGdCQUFnQmxtQjtZQUN4QyxJQUFJdW1CLE9BQU92bUIsR0FBRztnQkFFWnFQLEtBQUs0VixnQkFBZ0JiLFlBQVVHO2dCQUMvQmxWLEtBQUtoQyxjQUFjK1csWUFBVS9XO2dCQUM3QixJQUFJMUcsTUFBTXVlLE9BQU9RLGlCQUFpQnJXLEtBQUsxRyxVQUFVO29CQUMvQ2hDLE1BQU11ZSxPQUFPUSxnQkFBZ0JyVyxLQUFLMUc7b0JBQ2xDMGQsaUJBQWlCaFgsS0FBSzFHO0FBQ3ZCO0FBQ1QsbUJBQWE7Z0JBQ0wwRyxLQUFLNFYsZ0JBQWdCYixZQUFVSTtnQkFDL0JuVixLQUFLaEMsY0FBYytXLFlBQVU5VztBQUM5QjtBQUNGO1FBQ0QvTixLQUFLaW5CO0FBQ047SUFFREMsaUJBQWlCO1FBQ2Y5ZixNQUFNdWUsT0FBT2UsY0FBYztRQUMzQnRmLE1BQU11ZSxPQUFPUyxXQUFXdkIsWUFBVUM7QUFDbkM7SUFFRG1DLGtCQUFrQjtRQUNoQjdmLE1BQU11ZSxPQUFPZSxjQUFjO1FBQzNCdGYsTUFBTXVlLE9BQU9TLFdBQVd2QixZQUFVRTtBQUNuQzs7O0FBT0h2ZCxlQUFlcWY7SUFDYjtRQUNFLE1BQU01YyxhQUFhcVIsWUFBbUI7UUFDdENwVSxRQUFRQyxJQUFJLHlCQUF5QlUsS0FBS25HLFVBQVV1STtRQUNwRCxJQUFJQSxRQUFRLE1BQU07WUFDaEJrZCx1QkFBdUJsZDtBQUM3QixlQUFXO1lBQ0wvQyxRQUFRQyxJQUFJO0FBQ2I7QUFDRixNQUFDLE9BQU9qSDtRQUNQZ0gsUUFBUUMsSUFBSSx5QkFBeUJqSDtBQUN0QztBQUNIOztBQUVBLFNBQVNpbkIsdUJBQXVCbGQ7SUFDOUIsSUFBSTJJLE9BQU87SUFDWCxLQUFLLElBQUluUyxJQUFJLEdBQUdBLElBQUl3SixLQUFLL0ksUUFBUVQsS0FBSztRQUNwQyxJQUFJcVAsT0FBTzdGLEtBQUt4SjtRQUNoQixJQUFJMm1CLGNBQWMsSUFBSTVCO1FBQ3RCNEIsWUFBWXpZLFFBQVFsTztRQUNwQjJtQixZQUFZaGUsV0FBVzBHO1FBQ3ZCc1gsWUFBWTNCLGVBQWUvRCx3QkFBK0I1UjtRQUMxRCxJQUFJMUksTUFBTXVlLE9BQU9RLGlCQUFpQnJXLE1BQU07WUFDdENzWCxZQUFZMUIsZ0JBQWdCYixZQUFVRztZQUN0Q29DLFlBQVl0WixjQUFjK1csWUFBVS9XO0FBQzFDLGVBQVc7WUFDTHNaLFlBQVkxQixnQkFBZ0JiLFlBQVVJO1lBQ3RDbUMsWUFBWXRaLGNBQWMrVyxZQUFVOVc7QUFDckM7UUFDRDZFLEtBQUs5USxLQUFLc2xCO0FBQ1g7SUFDRGhnQixNQUFNdWUsT0FBT2dCLGtCQUFrQi9UO0FBQ2pDOztBQU1BcEwsZUFBZXNmLGlCQUFpQk87SUFDOUI7UUFDRSxJQUFJcGUsUUFBUTtZQUFFRyxVQUFVaWU7O1FBQ3hCLE1BQU1wZCxhQUFhcVIsWUFBbUIsd0NBQXdDclM7UUFDOUUvQixRQUFRQyxJQUFJLEdBQUdrRyx3Q0FBc0NnYSxzQkFBc0J4ZixLQUFLbkcsVUFBVXVJO1FBQzFGLElBQUlBLFFBQVEsTUFBTTtZQUNoQjdDLE1BQU11ZSxPQUFPUSxnQkFBZ0JrQjtZQUM3QkMsa0JBQWtCcmQ7WUFDbEJzZCxXQUFXdGQsTUFBTW9kO0FBQ3ZCLGVBQVc7WUFDTG5nQixRQUFRQyxJQUFJLEdBQUdrRztBQUNoQjtBQUNGLE1BQUMsT0FBT25OO1FBQ1BnSCxRQUFRQyxJQUFJLEdBQUdrRyxrQ0FBZ0NuTjtBQUNoRDtBQUNIOztBQUVBLFNBQVNvbkIsa0JBQWtCcmQ7SUFDekIsSUFBSTJJLE9BQU87SUFDWCxJQUFJM0ksS0FBSy9JLFNBQVMsR0FBRztRQUNuQixLQUFLLElBQUlULElBQUksR0FBR0EsSUFBSXdKLEtBQUsvSSxRQUFRVCxLQUFLO1lBQ3BDLElBQUlxUCxPQUFPN0YsS0FBS3hKO1lBQ2hCLElBQUlrbEIsU0FBUyxJQUFJVDtZQUNqQlMsT0FBT04sY0FBY3ZWLE1BQU0xSSxNQUFNdWUsT0FBT1E7WUFDeENSLE9BQU9QLE9BQU8sR0FBRy9WLGdCQUF1QlMsS0FBS3NWLE9BQU8sS0FBSztZQUN6RHhTLEtBQUs5USxLQUFLNmpCO0FBQ1g7QUFDTCxXQUFTO1FBQ0wsSUFBSUEsU0FBUyxJQUFJVDtRQUNqQlMsT0FBT1IsYUFBYSxPQUFPL2QsTUFBTXVlLE9BQU9RO1FBQ3hDUixPQUFPUCxPQUFPO1FBQ2R4UyxLQUFLOVEsS0FBSzZqQjtBQUNYO0lBQ0R6ZSxRQUFRQyxJQUFJLEdBQUdrRyxpQ0FBK0J4RixLQUFLbkcsVUFBVWtSO0lBQzdEeEwsTUFBTXVlLE9BQU9jLGFBQWE3VDtBQUM1Qjs7QUFFQSxTQUFTMlUsV0FBV0MsYUFBYXBlO0lBQy9CLElBQUlvZSxZQUFZdG1CLFNBQVMsR0FBRztRQUMxQixJQUFJdW1CLFFBQVFELFlBQVk7UUFDeEIsSUFBSUUsUUFBUUYsWUFBWTtRQUN4QixJQUFJRyxPQUFPRixNQUFNbkMsWUFBWTtRQUM3QixJQUFJc0MsT0FBT0gsTUFBTW5DLFlBQVk7UUFDN0IsSUFBSXVDLFlBQVl4WSxnQkFBdUJvWSxNQUFNckMsT0FBTyxLQUFLO1FBQ3pELElBQUkwQyxZQUFZelksZ0JBQXVCcVksTUFBTXRDLE9BQU8sS0FBSztRQUN6RGxlLFFBQVFDLElBQUksR0FBR2tHLCtCQUE2QndhLHdCQUF3QkM7UUFDcEUxZ0IsTUFBTXVlLE9BQU9JLFVBQVUxVSxtQkFDckI3QixNQUFNQyxXQUFXc1ksNkJBQ2YsR0FBR0osUUFDSCxHQUFHdmUsWUFDSCxHQUFHcWUsTUFBTW5DLGFBQ1QsR0FBR2xjLFlBQ0gsR0FBR3llLGFBQ0gsR0FBR0QsUUFDSCxHQUFHeGUsWUFDSCxHQUFHMGU7UUFHUDFnQixNQUFNdWUsT0FBT0ssYUFBYTtBQUM5QixXQUFTO1FBQ0w1ZSxNQUFNdWUsT0FBT0ssYUFBYTtBQUMzQjtBQUNIOztBQzlOQSxNQUFNZ0M7SUFDSnJaLE9BQVM7SUFDVHZGLFNBQVc7SUFDWDZlLFFBQVU7SUFDVkMsVUFBWTs7O0FBR2Q5Z0IsTUFBTStnQixpQkFBaUI7SUFDckJwZCxRQUFRO0lBQ1JrRCxPQUFPdUIsTUFBTTRZO0lBQ2JuQyxZQUFZelcsTUFBTTZZO0lBQ2xCaEMsV0FBVzdXLE1BQU04WTtJQUNqQi9CLFlBQVkvVyxNQUFNK1k7SUFDbEJDLFlBQVloWixNQUFNaVo7SUFDbEJDLG9CQUFvQjtJQUNwQkMsaUJBQWlCO0lBQ2pCQyxvQkFBb0I7SUFDcEJDLG9CQUFvQjtJQUNwQkMsY0FBYztJQUNkQyxpQkFBaUI7SUFDakJDLGlCQUFpQjtJQUNqQkMsZUFBZTtJQUNmakQsWUFBWTs7O0FBR2QzZSxPQUFPOGdCLGlCQUFpQjtJQUl0QmUsVUFBVTtRQUNSQztBQUNEO0lBRUR4WCxZQUFZO1FBQ1Z3WDtRQUNBL2hCLE1BQU0rZ0IsZUFBZXBkLFNBQVM7QUFDL0I7SUFFRGlILGFBQWE7UUFDWDVLLE1BQU0rZ0IsZUFBZXBkLFNBQVM7QUFDL0I7OztBQUdILFNBQVNxZSxrQkFBa0JDLFdBQVcsS0FBTUMsVUFBVTtJQUNwRCxJQUFJaGhCLFdBQVcwTixXQUFrQjFOO0lBQ2pDcEIsUUFBUUMsSUFBSSwyQ0FBMkNtQjtJQUN2RCxJQUFJK2EsUUFBUWdHO0lBQ1YsSUFBSUUsU0FBUyxJQUFJRjtJQUNqQixJQUFJakUsT0FBTy9WLGdCQUF1QmlhLFNBQVM7SUFDM0MsSUFBSTdCLFFBQVFwWSxnQkFBdUIsS0FBTWlhLFNBQVM7SUFDbEQsSUFBSTVCLFFBQVFyWSxnQkFBdUIsS0FBTWlhLFNBQVM7SUFDbEQsSUFBSUUsUUFBUW5hLGdCQUF1QixJQUFJaWEsU0FBUztJQUNoRGxpQixNQUFNK2dCLGVBQWVRLGtCQUFrQm5aLE1BQU1pYTtJQUM3Q3JpQixNQUFNK2dCLGVBQWVTLHFCQUFxQnZYLG1CQUN4QzdCLE1BQU1DLFdBQVdpYSxzQ0FBc0MsR0FBR3RFLFFBQVEsR0FBRy9CLFNBQVMsR0FBRytCLFFBQVEsR0FBRy9CO0lBRTlGamMsTUFBTStnQixlQUFlVSxxQkFBcUJ4WCxtQkFDeEM3QixNQUFNQyxXQUFXa2Esc0NBQXNDLEdBQUd2RTtJQUU5RCxJQUFJOWMsWUFBWSxXQUFXQSxZQUFZLFNBQVM7UUFDOUNsQixNQUFNK2dCLGVBQWVXLGVBQWV0WixNQUFNb2E7UUFDMUN4aUIsTUFBTStnQixlQUFlWSxrQkFBa0IxWCxtQkFDckM3QixNQUFNQyxXQUFXb2Esa0NBQ2YsR0FBR04sVUFDSCxHQUFHOUIsU0FDSCxHQUFHcEUsU0FDSCxHQUFHK0IsUUFDSCxHQUFHc0MsU0FDSCxHQUFHckUsU0FDSCxHQUFHb0U7UUFHUHJnQixNQUFNK2dCLGVBQWVhLGtCQUFrQjNYLG1CQUNyQzdCLE1BQU1DLFdBQVdxYSxrQ0FBa0MsR0FBR1AsVUFBVSxHQUFHQyxTQUFTLEdBQUdBO1FBRWpGcGlCLE1BQU0rZ0IsZUFBZW5DLGFBQWE7UUFDbEM1ZSxNQUFNK2dCLGVBQWVjLGdCQUFnQjtBQUN6QyxXQUFTO1FBQ0w3aEIsTUFBTStnQixlQUFlbkMsYUFBYTtRQUNsQzVlLE1BQU0rZ0IsZUFBZWMsZ0JBQWdCO0FBQ3RDO0FBQ0g7O0FBTUF6aEIsZUFBZTJoQjtJQUNiO1FBRUUsSUFBSWxnQixRQUFRO1lBQUUwRixPQUFPO1lBQUdvYixNQUFNOztRQUM5QixNQUFNOWYsYUFBYXFSLFlBQW1CLDJDQUEyQ3JTO1FBQ2pGL0IsUUFBUUMsSUFBSSxvQ0FBb0NVLEtBQUtuRyxVQUFVdUk7UUFDL0QsSUFBSUEsUUFBUSxNQUFNO1lBQ2hCLElBQUkySSxPQUFPO1lBQ1gsS0FBSyxJQUFJblMsSUFBSSxHQUFHQSxJQUFJd0osS0FBSy9JLFFBQVFULEtBQUs7Z0JBQ3BDLElBQUlxUCxPQUFPN0YsS0FBS3hKO2dCQUVoQixJQUFJcVAsS0FBS21ZLFdBQVc3YSxhQUFhMEMsS0FBS21ZLFFBQVEvbUIsVUFBVSxHQUFHO29CQUN6RDtBQUNEO2dCQUNELElBQUl1UixPQUFPLElBQUl1VjtnQkFDZnZWLEtBQUs5RCxRQUFRbE87Z0JBQ2JnUyxLQUFLckosV0FBVzBHLEtBQUsxRztnQkFDckJxSixLQUFLd1YsVUFBVW5ZLEtBQUttWTtnQkFDcEJ4VixLQUFLeVYsWUFBWXBZLEtBQUtvWTtnQkFDdEJ6VixLQUFLdkQsT0FBTztnQkFDWjBELEtBQUs5USxLQUFLMlE7Z0JBQ1YsSUFBSTNDLEtBQUsxRyxZQUFZLFFBQVE7b0JBQzNCLElBQUk2ZSxVQUFVblksS0FBS21ZO29CQUNuQkEsVUFBVUEsUUFBUWhuQixVQUFVLEdBQUdnbkIsUUFBUS9tQixTQUFTO29CQUNoRGtvQixrQkFBa0J0WixLQUFLb1ksV0FBV0Q7QUFDbkM7QUFDRjtZQUNEL2dCLFFBQVFDLElBQUksd0NBQXdDVSxLQUFLbkcsVUFBVWtSO1lBQ25FeEwsTUFBTStnQixlQUFlTyxxQkFBcUI5VjtZQUMxQyxJQUFJeEwsTUFBTStnQixlQUFlNkIsY0FBYyxJQUFJO2dCQUN6Q1o7QUFDRDtBQUNQLGVBQVc7WUFDTEE7WUFDQWxpQixRQUFRQyxJQUFJO0FBQ2I7QUFDRixNQUFDLE9BQU9qSDtRQUNQZ0gsUUFBUUMsSUFBSSxvQ0FBb0NqSDtRQUNoRGtwQjtBQUNEO0FBQ0g7O0FDL0hBLE1BQU1hLFlBQVk7SUFDaEJDLE9BQU87SUFDUEMsT0FBTztJQUNQQyxRQUFRO0lBQ1JDLFFBQVE7SUFDUkMsYUFBYTtJQUNiQyxhQUFhOzs7QUFHZm5qQixNQUFNNE0sU0FBUztJQUNiakosUUFBUTtJQUNSa2IsWUFBWXpXLE1BQU1nYjtJQUNsQkMsbUJBQW1CamIsTUFBTWtiO0lBQ3pCckUsV0FBVzdXLE1BQU04VztJQUNqQkMsWUFBWS9XLE1BQU1tYjtJQUNsQm5DLFlBQVloWixNQUFNb2I7SUFDbEI3YSxZQUFZLEVBQ1Y7UUFDRWIsTUFBTTtRQUNOMmIsUUFBUTtRQUNSeGMsS0FBSztRQUNMNFosU0FBUyxZQUFZelksTUFBTXNiO1FBQzNCZixNQUFNRSxVQUFVRTtRQUNoQlksT0FBT2QsVUFBVUk7UUFDakJXLFlBQVlmLFVBQVVNO09BRXhCO1FBQ0VyYixNQUFNO1FBQ04yYixRQUFRO1FBQ1J4YyxLQUFLO1FBQ0w0WixTQUFTelksTUFBTXliO1FBQ2ZsQixNQUFNRSxVQUFVQztRQUNoQmEsT0FBT2QsVUFBVUc7UUFDakJZLFlBQVlmLFVBQVVLOztJQUcxQlksYUFBYTFiLE1BQU0yYjtJQUNuQkMsYUFBYTViLE1BQU02Yjs7O0FBR3JCaGtCLE9BQU8yTSxTQUFTO0lBQ2RyQyxZQUFZLFNBQVVoRDtRQUNwQnZILE1BQU00TSxPQUFPakosU0FBUztRQUN0QixJQUFJZ0csVUFBVTFKLE9BQU8ySixLQUFLOEcsa0JBQWtCbko7UUFDNUMyYyxtQkFBNkJ2YTtBQUM5QjtJQUVEaUIsYUFBYTtRQUNYNUssTUFBTTRNLE9BQU9qSixTQUFTO0FBQ3ZCOzs7QUMvQ0gsTUFBTXNDLFFBQU07O0FBRUwsTUFBTWtlLGFBQWE7SUFDeEI5a0IsWUFBWTtJQUNaK2tCLFdBQVc7SUFDWEMsV0FBVzs7O0FBR2IsTUFBTUMsVUFBVTtJQUNkNWQsYUFBYTtJQUNiQyxlQUFlO0lBRWY0ZCxzQkFBc0I7SUFDdEJDLHdCQUF3QjtJQUN4QkMseUJBQXlCO0lBQ3pCQyx1QkFBdUI7OztBQUd6QjFrQixNQUFNMmtCLE9BQU87SUFDWGhoQixRQUFRO0lBQ1JpaEIsU0FBUztJQUNUQyxTQUFTO0lBQ1QvYixPQUFPO0lBQ1BnYyxjQUFjO0lBQ2RDLGtCQUFrQjtJQUNsQkMsZ0JBQWdCO0lBQ2hCQyxZQUFZO0lBQ1pDLFlBQVk7OztBQUdkLFNBQVM5YjtJQUNQLE9BQU87UUFDTE4sT0FBTzs7QUFFWDs7QUFFQSxJQUFJVyxZQUFZOztBQUNoQixJQUFJMGIsZUFBZTs7QUFPbkIsU0FBU0MsY0FBY3piO0lBQ3JCLE1BQU1iLFFBQVE5SSxNQUFNMmtCLEtBQUs3YjtJQUN6QixJQUFJdWMsYUFBYTtJQUNqQkYsZUFBZTtJQUNmLEtBQUssSUFBSTlyQixJQUFJLEdBQUdBLElBQUl5UCxNQUFNaFAsUUFBUVQsS0FBSztRQUNyQyxNQUFNcVAsT0FBT0ksTUFBTXpQO1FBQ25CLElBQUlxUCxLQUFLbVAsWUFBWXlNLFFBQVE1ZCxhQUFhO1lBRXhDMmUsYUFBYUMsSUFBV0QsWUFBWTNjLEtBQUs2STtZQUN6QzRUO0FBR0Q7QUFDRjtJQUNEbmxCLE1BQU0ya0IsS0FBS0csZUFBZU87SUFDMUIsSUFBSUYsZUFBZSxHQUFHO1FBQ3BCbmxCLE1BQU0ya0IsS0FBS0MsVUFBVTtRQUNyQjVrQixNQUFNMmtCLEtBQUtFLFVBQVU7UUFDckI3a0IsTUFBTTJrQixLQUFLSSxtQkFBbUJULFFBQVFFO1FBQ3RDeGtCLE1BQU0ya0IsS0FBS0ssaUJBQWlCVixRQUFRQztBQUN4QyxXQUFTO1FBQ0x2a0IsTUFBTTJrQixLQUFLQyxVQUFVO1FBQ3JCNWtCLE1BQU0ya0IsS0FBS0UsVUFBVTtRQUNyQjdrQixNQUFNMmtCLEtBQUtJLG1CQUFtQlQsUUFBUUc7UUFDdEN6a0IsTUFBTTJrQixLQUFLSyxpQkFBaUJWLFFBQVFJO0FBQ3JDO0FBQ0g7O0FBRUEsU0FBU2EsZUFBZXZqQixVQUFVd2pCO0lBQ2hDLElBQUl4akIsWUFBWSxRQUFRO1FBQ3RCeWpCLHlCQUFtQ0Q7QUFDdkMsV0FBUyxJQUFHeGpCLFlBQVksUUFBUTtRQUM1QjBqQix5QkFBbUNGO0FBQ3BDO0FBQ0g7O0FBRUF2bEIsT0FBTzBrQixPQUFPO0lBQ1p4YSxTQUFTO1FBQ1AsSUFBSWdiLGdCQUFnQixHQUFHO1lBQ3JCO0FBQ0Q7UUFFRFE7UUFFQSxNQUFNaGMsVUFBVTNKLE1BQU00SixLQUFLQyxXQUFXSjtRQUN0QyxNQUFNbWMsYUFBYWpjLFFBQVErTixhQUFhNU87UUFDeEMsTUFBTUEsUUFBUTlJLE1BQU0ya0IsS0FBSzdiO1FBQ3pCLElBQUlnYyxlQUFlO1FBQ25CLElBQUllLGdCQUFnQjtRQUNwQixLQUFLLElBQUl4c0IsSUFBSSxHQUFHQSxJQUFJeVAsTUFBTWhQLFFBQVFULEtBQUs7WUFDckMsTUFBTXFQLE9BQU9JLE1BQU16UDtZQUNuQixNQUFNbU0sTUFBTWtELEtBQUsxRyxTQUFTeVEsa0JBQWtCLFNBQVMwUixXQUFXQyxZQUFZRCxXQUFXRTtZQUN2RixJQUFJM2IsS0FBS21QLFlBQVl5TSxRQUFRNWQsYUFBYTtnQkFDeENvZixLQUFZM0IsV0FBVzlrQixZQUFZbUcsS0FBSztnQkFDeEMsSUFBSWtELEtBQUsxRyxTQUFTeVEsa0JBQWtCLFFBQVE7b0JBQzFDelMsTUFBTTJrQixLQUFLTSxhQUFhO0FBQ2xDLHVCQUFlO29CQUNMamxCLE1BQU0ya0IsS0FBS08sYUFBYTtBQUN6QjtnQkFDREosZUFBZVEsSUFBV1IsY0FBY3BjLEtBQUs2STtnQkFDN0NzVSxnQkFBZ0JBLGNBQWMvckIsVUFBVSxJQUFJNE8sS0FBSzFHLFdBQVcsSUFBSTZqQixpQkFBaUJuZCxLQUFLMUc7QUFDOUYsbUJBQWE7Z0JBQ0w4akIsS0FBWTNCLFdBQVc5a0IsWUFBWW1HLEtBQUs7Z0JBQ3hDLElBQUlrRCxLQUFLMUcsU0FBU3lRLGtCQUFrQixRQUFRO29CQUMxQ3pTLE1BQU0ya0IsS0FBS00sYUFBYTtBQUNsQyx1QkFBZTtvQkFDTGpsQixNQUFNMmtCLEtBQUtPLGFBQWE7QUFDekI7QUFDRjtZQUNEVSxXQUFXdnNCLEdBQUd3ZSxXQUFXblAsS0FBS21QO0FBQy9CO1FBRURsTyxRQUFRb2Msa0JBQWtCM2QsTUFBTUMsV0FBVzJkLHFCQUFxQixHQUFHSDtRQUNuRWxjLFFBQVE0SCxVQUFVdVQ7UUFDbEJuYixRQUFRNkwsY0FBYyxHQUFHaEQsaUJBQXdCTSxlQUFzQmdTLGNBQWM7UUFDckY3a0IsT0FBT2dtQixTQUFTdFIsY0FBY2hMLFFBQVErQyxXQUFXakQ7UUFDakR4SixPQUFPMGtCLEtBQUsvWjtBQUNiO0lBRURsQixXQUFXLFNBQVVuQztRQUNuQnpILFFBQVFDLElBQUksR0FBR2tHLDZCQUEyQndELG1CQUFtQmxDO1FBQzdDdkgsTUFBTTRKLEtBQUtDLFdBQVdKO1FBQ3RDLElBQUl5YyxNQUFNbG1CLE1BQU0ya0IsS0FBSzdiLE1BQU12QixPQUFPc1E7UUFDbEMsSUFBSXFPLE9BQU81QixRQUFRNWQsYUFBYTtZQUM5QndmLE1BQU01QixRQUFRM2Q7WUFFZDRlLGVBQWV2bEIsTUFBTTJrQixLQUFLN2IsTUFBTXZCLE9BQU92RixVQUFVO0FBQ3ZELGVBQVcsSUFBSWtrQixPQUFPNUIsUUFBUTNkLGVBQWU7WUFDdkN1ZixNQUFNNUIsUUFBUTVkO1lBRWQ2ZSxlQUFldmxCLE1BQU0ya0IsS0FBSzdiLE1BQU12QixPQUFPdkYsVUFBVTtBQUNsRDtRQUNEaEMsTUFBTTJrQixLQUFLN2IsTUFBTXZCLE9BQU9zUSxXQUFXcU87UUFDbkNkO0FBQ0Q7SUFLRHRELFVBQVUsU0FBVXFFLGlCQUFpQnhjO1FBQ25DN0osUUFBUUMsSUFBSSxHQUFHa0cseUNBQXVDeEYsS0FBS25HLFVBQVU2ckI7UUFDckUsTUFBTUMsV0FBV2hkO1FBQ2pCLEtBQUssSUFBSS9QLElBQUksR0FBR0EsSUFBSThzQixnQkFBZ0Jyc0IsUUFBUVQsS0FBSztZQUMvQyxNQUFNZ3RCLE9BQU9GLGdCQUFnQjlzQjtZQUM3QixNQUFNd04sUUFBUXVCLE1BQU1DLFdBQVcyZCxxQkFBcUIsR0FBR0ssS0FBS3JrQjtZQUM1RCxNQUFNQSxXQUFXcWtCLEtBQUtya0I7WUFDdEIsTUFBTXVQLFVBQVVpQixpQkFBd0J2SyxnQkFBdUJvZSxLQUFLNUMsUUFBUTtZQUM1RSxJQUFJNUwsV0FBV3lNLFFBQVEzZDtZQUN2QixJQUFJd2UsZUFBZWtCLEtBQUtya0IsU0FBU3lRLGtCQUFrQixTQUFTelMsTUFBTTJrQixLQUFLTSxhQUFhamxCLE1BQU0ya0IsS0FBS087WUFDL0ZwbEIsUUFBUUMsSUFBSSxHQUFHa0csZ0NBQThCa2Y7WUFDN0MsSUFBSUEsZ0JBQWdCLE1BQU07Z0JBQ3hCLElBQUlBLGNBQWM7b0JBQ2hCdE4sV0FBV3lNLFFBQVE1ZDtBQUM3Qix1QkFBZTtvQkFDTG1SLFdBQVd5TSxRQUFRM2Q7QUFDcEI7QUFDVCxtQkFBYTtnQkFDTGtSLFdBQVd3TyxLQUFLcmtCLGFBQWEsU0FBU3NpQixRQUFRNWQsY0FBYzRkLFFBQVEzZDtBQUNyRTtZQUNELE1BQU1pUixTQUFTeU8sS0FBS3pPO1lBQ3BCLE1BQU05UCxPQUFPO1lBQ2IsTUFBTVAsUUFBUWxPO1lBQ2QsSUFBSXFQLE9BQU87Z0JBQUU3QjtnQkFBTzBLO2dCQUFTc0c7Z0JBQVVEO2dCQUFRNVY7Z0JBQVU4RjtnQkFBTVA7O1lBQy9ENmUsU0FBU3RkLE1BQU1wTyxLQUFLZ087QUFDckI7UUFDRDVJLFFBQVFDLElBQUksR0FBR2tHLHlCQUF1QnhGLEtBQUtuRyxVQUFVOHJCLFNBQVN0ZDtRQUM5RGEsUUFBUStOLGVBQWUwTztRQUN2QnRtQixRQUFRQyxJQUFJLEdBQUdrRztBQUNoQjtJQUVEc0UsWUFBWSxTQUFVaEQ7UUFDcEJ6SCxRQUFRQyxJQUFJLEdBQUdrRywyQkFBeUJzQjtRQUN4Q2tDLFdBQVdsQztRQUNYLElBQUlvQyxVQUFVM0osTUFBTTRKLEtBQUtDLFdBQVd0QztRQUNwQ3pILFFBQVFDLElBQUksR0FBR2tHLDJCQUF5QnhGLEtBQUtuRyxVQUFVcVAsUUFBUStOLGFBQWE1TztRQUM1RTlJLE1BQU0ya0IsS0FBSzdiLFFBQVFhLFFBQVErTixhQUFhNU87UUFDeENzYztRQUNBcGxCLE1BQU0ya0IsS0FBS2hoQixTQUFTO1FBR3BCMmlCO0FBQ0Q7SUFFRDFiLGFBQWE7UUFDWG5CLFlBQVk7UUFDWnpKLE1BQU0ya0IsS0FBS2hoQixTQUFTO0FBQ3JCOzs7QUM1TEgsTUFBTXNDLFFBQU07O0FBS1osTUFBTXdYLFlBQVk7SUFDaEI4SSxxQkFBcUI7SUFDckJDLHVCQUF1QjtJQUN2QkMsbUJBQW1CO0lBQ25CQyxxQkFBcUI7OztBQU12QixNQUFNQyxvQkFBb0I7SUFDeEJDLFNBQVM7SUFDVEMsVUFBVTs7O0FBR1osU0FBU25OO0lBQ1AsT0FBTyxDQUNUO0FBQ0E7O0FBRUEsU0FBU3pJO0lBQ1AsT0FBTztRQUNMRyxTQUFTaEosTUFBTUMsV0FBV2dKLHVCQUF1QjtRQUNqREgsVUFBVTtRQUNWQyxZQUFZO1FBQ1pNLGdCQUFnQjtRQUNoQjZDLGFBQWE7UUFDYkUsYUFBYTtRQUNic1MsaUJBQWlCLE1BQU05bUIsTUFBTTRKLEtBQUs1SDtRQUNsQytrQixnQkFBZ0I7UUFDaEJsVSxnQkFBZ0I7UUFDaEJoQixvQkFBb0I7UUFDcEJELHFCQUFxQjtRQUNyQm9WLGtCQUFrQjtRQUNsQmpCLGlCQUFpQjtRQUNqQmtCLG9CQUFvQjtRQUNwQkMsc0JBQXNCO1FBQ3RCbFYsV0FBVztRQUNYaEYsY0FBYztRQUNkRSxnQkFBZ0I7UUFDaEJFLG1CQUFtQjtRQUNuQjNDLG1CQUFtQjtRQUNuQnNDLGNBQWM7UUFDZEQsa0JBQWtCO1FBQ2xCVSxlQUFlO1FBR2YxRCxnQkFBZ0IsQ0FBRTtRQUVsQjROLGNBQWMsQ0FBRTtRQUVoQmxDLGFBQWE7UUFDYmpFLFNBQVM7UUFFVDRWLFdBQVc7UUFDWEMsV0FBVztRQUNYL0gsWUFBWTtRQUNaZ0ksWUFBWTtRQUNaQyxZQUFZO1FBQ1pDLGVBQWU7UUFDZkMsa0JBQWtCO1FBQ2xCQyxlQUFlO1FBQ2ZDLGVBQWU7UUFDZkMsZUFBZTtRQUNmQyxlQUFlO1FBQ2ZDLGVBQWU7UUFDZkMsZUFBZTtRQUNmQyxrQkFBa0I7UUFDbEJDLG9CQUFvQjtRQUNwQkMsa0JBQWtCdEIsa0JBQWtCRTtRQUdwQ3FCLFNBQVM7UUFFVHhiLFdBQVc7UUFFWDNCLFdBQVc7UUFFWFAsYUFBYSxDQUFFO1FBRWZ5SCxlQUFlO1FBRWZ0RyxlQUFlO1FBRWZ3YyxjQUFjO1FBRWRwVCxhQUFhO1FBRWJsRyxVQUFVO1FBRVZ5QixVQUFVO1FBRVZzSSxpQkFBaUI7UUFFakJDLGVBQWU7UUFFZm5HLHdCQUF3QjtRQUV4QnNKLG1CQUFtQjs7QUFFdkI7O0FBRUEsT0FBUTliLFlBQUFBLGNBQVlDLGFBQUFBLGlCQUFnQjZRLGFBQW9CLFlBQVkwSSxlQUFhLENBQUE7O0FBSzFFLFNBQVMwTyxvQkFBb0IzUCxTQUFTM047SUFDM0M7UUFDRSxJQUFJc0gsY0FBY25CO1FBQ2xCLElBQUl3SCxXQUFXLE1BQU07WUFDbkIzWSxRQUFRQyxJQUFJLEdBQUdrRywwQ0FBd0N4RixLQUFLbkcsVUFBVW1lO1lBRXRFckcsWUFBWXpELGNBQWM4SixRQUFROUo7WUFDbEMsSUFBSThKLFFBQVE5SixnQkFBZ0IsR0FBRztnQkFDN0IwWixlQUFlNVAsU0FBU3JHLGFBQWF0SDtBQUN0QztZQUNEaEwsUUFBUUMsSUFBSSxHQUFHa0csOENBQTRDeEYsS0FBS25HLFVBQVU4WDtBQUNoRixlQUFXO1lBQ0x0UyxRQUFRQyxJQUFJLEdBQUdrRztBQUNoQjtRQUNELE9BQU9tTTtBQUNSLE1BQUMsT0FBT3RaO1FBQ1BnSCxRQUFRQyxJQUFJLCtCQUErQmpIO0FBQzVDO0FBQ0g7O0FBS0EsU0FBU3d2QixZQUFZL1csU0FBU2dYLFNBQVM7SUFDckMsSUFBSW5xQixTQUFTNkosZ0JBQXVCc0osU0FBUyxHQUFHeFQ7SUFDaEQrQixRQUFRQyxJQUFJa0csUUFBTSwwQkFBMEI3SDtJQUM1QyxJQUFJeU4sTUFBTTJHLGlCQUF3QnBVO0lBQ2xDMEIsUUFBUUMsSUFBSWtHLFFBQU0sdUJBQXVCNEY7SUFDekMsSUFBSTBjLFFBQVE7UUFDVixPQUFPLEdBQUcxYyxPQUFPN0wsTUFBTTRKLEtBQUs1SDtBQUNoQyxXQUFTO1FBQ0wsT0FBTyxHQUFHNko7QUFDWDtBQUNIOztBQUtBLFNBQVN3YyxlQUFlNVAsU0FBU3JHLGFBQWF0SDtJQUU1QyxJQUFJMEIsTUFBTWhQLEtBQUtnUCxJQUFJaU0sUUFBUStQLGFBQWEvUCxRQUFRZ1E7SUFDaEQsSUFBSTNXLFNBQVNVLGlCQUF3QnZLLGdCQUF1QnVFLEtBQUs7SUFDakU0RixZQUFZOFYsVUFBVXBXO0lBQ3RCaFMsUUFBUUMsSUFBSSxHQUFHa0csa0NBQWdDbU0sWUFBWThWO0lBQzNEOVYsWUFBWWhCLFVBQVVoSixNQUFNQyxXQUFXZ0osdUJBQXVCLEdBQUdlLFlBQVk4VjtJQUU3RTlWLFlBQVlTLGlCQUFpQjRGLFFBQVE1RjtJQUNyQ1QsWUFBWVAscUJBQXFCLEdBQUdXLGlCQUF3Qk0sZUFBc0IyRixRQUFRNUYsZ0JBQWdCO0lBQzFHVCxZQUFZd0csa0JBQWtCSCxRQUFRRztJQUN0Q3hHLFlBQVl5RyxnQkFBZ0JKLFFBQVFJO0lBQ3BDekcsWUFBWW5NLE1BQU13UyxRQUFReFM7SUFDMUJtTSxZQUFZc1csdUJBQXVCalEsUUFBUWlRO0lBQzNDdFcsWUFBWU0seUJBQXlCK0YsUUFBUS9GO0lBRTdDaVcsc0JBQXNCbFEsUUFBUTBOLGlCQUFpQi9UO0lBQy9DLElBQUlBLFlBQVlNLDBCQUEwQixNQUFNO1FBQzlDTixZQUFZUixzQkFBc0J4SixNQUFNdUs7QUFDNUMsV0FBUztRQUNMUCxZQUFZUixzQkFBc0J4SixNQUFNd0s7QUFDekM7SUFDRFIsWUFBWXJILFlBQVkwTixRQUFRMU47SUFDaENxSCxZQUFZdFAsU0FBUzJWLFFBQVEzVjtJQUM3QnNQLFlBQVl3Vyx3QkFBd0JuUSxRQUFRbVE7SUFFNUN4VyxZQUFZNlYsbUJBQ1Z4UCxRQUFRb1EscUJBQXFCLFFBQVFwUSxRQUFRb1EscUJBQXFCN2lCLGFBQWF5UyxRQUFRb1EscUJBQXFCLElBQ3hHbEMsa0JBQWtCRSxXQUNsQkYsa0JBQWtCQztJQUN4QnhVLFlBQVk5QixXQUFXbUksUUFBUW9RO0lBRS9CelcsWUFBWTVILGNBQWNpTyxRQUFRak8sZUFBZSxPQUFPLENBQUUsSUFBR2lPLFFBQVFqTztJQUNyRTRILFlBQVlILGdCQUFnQndHLFFBQVF4RztJQUNwQ0csWUFBWXpHLGdCQUFnQjhNLFFBQVE5TTtJQUNwQyxJQUFJeUcsWUFBWUgsaUJBQWlCLEdBQUc7UUFDbENHLFlBQVlKLFlBQVk7UUFFeEJtQixjQUF5QmYsYUFBYXRIO0FBQzFDLFdBQVM7UUFFTHNILFlBQVlKLFlBQVk7QUFDekI7SUFDREksWUFBWTFELE9BQU8rSixRQUFRL0o7SUFDM0IwRCxZQUFZekQsY0FBYzhKLFFBQVE5SjtJQUNsQ3lELFlBQVl2RCxVQUFVNEosUUFBUTVKO0lBRTlCLElBQUk0SixRQUFRNUosV0FBVyxHQUFHO1FBQ3hCdUQsWUFBWWdWLFlBQVk7UUFDeEJoVixZQUFZaU4sYUFBYXlKLGlCQUFpQnJRLFFBQVEySCxhQUFhM0g7UUFDL0RyRyxZQUFZK1UsWUFBWS9VLFlBQVlpTixXQUFXdmxCLFNBQVMsSUFBSSxZQUFZO1FBRXhFaXZCLHNCQUFzQnRRLFNBQVMsT0FBT3JHO1FBQ3RDblMsT0FBT3NlLE9BQU9pQjtRQUNkcE4sWUFBWTJVLGlCQUFpQjtBQUNqQyxXQUFTLElBQUl0TyxRQUFRNUosV0FBVyxHQUFHO1FBQy9CdUQsWUFBWStWLGVBQWUxUCxRQUFRdVE7UUFDbkM1VyxZQUFZK1UsWUFBWTtRQUN4QixJQUFJemIsU0FBVTBHLFlBQVkxRixVQUFVNVMsV0FBVyxJQUFLLElBQUkrYSxVQUFpQnpDLFlBQVkxRjtRQUNyRjBGLFlBQVlpVixhQUFhNEIseUJBQXlCeFEsUUFBUXVRLGFBQWF2USxRQUFROU0sZUFBZXlHLGFBQWExRztRQUMzRzBHLFlBQVlnVixZQUFZO1FBRXhCMkIsc0JBQXNCdFEsU0FBUyxNQUFNckc7UUFDckNuUyxPQUFPOGdCLGVBQWVlO0FBQ3ZCO0FBQ0g7O0FBTUEsU0FBUzZHLHNCQUFzQk8sY0FBYzlXO0lBQzNDLElBQUk4VyxnQkFBZ0IsTUFBTTtRQUN4QnBwQixRQUFRQyxJQUFJLEdBQUdrRztRQUNmbU0sWUFBWTZVLHFCQUFxQjtRQUNqQzdVLFlBQVlvRCxjQUFjeFYsTUFBTTRKLEtBQUs0TDtRQUNyQ3BELFlBQVliLFVBQVV2UixNQUFNNEosS0FBSzJIO0FBQ3JDLFdBQVM7UUFDTGEsWUFBWTZVLHFCQUFxQjtRQUVqQ2tDO1FBQ0EvVyxZQUFZNFUsbUJBQW1CNWUsTUFBTWdoQjtRQUNyQ3RwQixRQUFRQyxJQUFJLEdBQUdrRyxrRUFBZ0VpakIsYUFBYXB2QjtRQUU1RixJQUFJZ3JCLGVBQWU7UUFDbkIsSUFBSWUsZ0JBQWdCO1FBQ3BCLEtBQUssSUFBSXhzQixJQUFJLEdBQUdBLElBQUk2dkIsYUFBYXB2QixRQUFRVCxLQUFLO1lBQzVDLE1BQU1ndEIsT0FBTzZDLGFBQWE3dkI7WUFDMUIsSUFBSThyQixlQUFla0IsS0FBS3JrQixTQUFTeVEsa0JBQWtCLFNBQVN6UyxNQUFNMmtCLEtBQUtNLGFBQWFqbEIsTUFBTTJrQixLQUFLTztZQUMvRnBsQixRQUFRQyxJQUFJLEdBQUdrRyw2Q0FBMkNrZixzQkFBc0Ixa0IsS0FBS25HLFVBQVUrckI7WUFDL0YsSUFBSWxCLGdCQUFnQixNQUFNO2dCQUN4QixJQUFJQSxjQUFjO29CQUNoQkwsZUFBZVEsSUFBV1IsY0FBY3VCLEtBQUs1QztvQkFDN0NvQyxnQkFBZ0JBLGNBQWMvckIsVUFBVSxJQUFJdXNCLEtBQUtya0IsV0FBVyxJQUFJNmpCLGlCQUFpQlEsS0FBS3JrQjtBQUN2RjtBQUNULG1CQUFhO2dCQUVMLElBQUlxa0IsS0FBS3JrQixTQUFTeVEsa0JBQWtCLFFBQVE7b0JBQzFDcVMsZUFBZVEsSUFBV1IsY0FBY3VCLEtBQUs1QztvQkFDN0NvQyxnQkFBZ0JBLGNBQWMvckIsVUFBVSxJQUFJdXNCLEtBQUtya0IsV0FBVyxJQUFJNmpCLGlCQUFpQlEsS0FBS3JrQjtBQUN2RjtBQUNGO0FBQ0Y7UUFDRGxDLFFBQVFDLElBQ04sR0FBR2tHLDZDQUEyQzZlLCtCQUErQmUsOEJBQThCelQ7UUFFN0dBLFlBQVkyVCxrQkFBa0IzZCxNQUFNQyxXQUFXMmQscUJBQXFCLEdBQUdIO1FBQ3ZFelQsWUFBWW9ELGNBQWMsR0FBR2hELGlCQUF3Qk0sZUFBc0JnUyxjQUFjO1FBQ3pGMVMsWUFBWWIsVUFBVXVUO1FBRXRCN2tCLE9BQU8wa0IsS0FBSzdDLFNBQVNvSCxjQUFjOVc7UUFDbkN0UyxRQUFRQyxJQUFJLEdBQUdrRztBQUNoQjtBQUNIOztBQUVBOUYsY0FBWWtwQiwyQkFBMkI7SUFDckNwcEIsT0FBT3VkLFlBQVk1UztJQUNuQnVlO0FBQ0Y7O0FBRUEvb0IsZUFBZStvQjtJQUNiLElBQUlHLHNCQUFzQkMsS0FBWSxlQUFlO0lBQ3JEenBCLFFBQVFDLElBQUksNENBQTRDdXBCO0lBQ3hELElBQUlBLGlCQUFpQixLQUFLO1FBRXhCO0FBQ0Q7SUFFRCxJQUFJL1YsT0FBTyxJQUFJM1A7SUFDZixJQUFJNGxCLFFBQVFqVyxLQUFLdlAsYUFBYTtJQUM5QixJQUFJeWxCLE1BQU1sVyxLQUFLdFA7SUFDZixJQUFJeWxCLFlBQVlGLFFBQVEsTUFBTUM7SUFDOUIsSUFBSUUsc0JBQXNCSixLQUFZLGVBQWU7SUFDckQsSUFBSUksaUJBQWlCRCxXQUFXO1FBRTlCRTtjQUVNOUQsS0FBWSxlQUFlLGdCQUFnQjREO0FBQ2xEO0lBQ0Q1cEIsUUFBUUMsSUFBSSx5Q0FBeUMycEIsaUNBQWlDQztBQUN4Rjs7QUFFQSxTQUFTQztJQUNQam9CLFlBQVc7UUFDVDNCLE1BQU02cEIsWUFBWUMsVUFBVTtRQUM1Qm5vQixZQUFXO1lBQ1QzQixNQUFNNnBCLFlBQVlDLFVBQVU7WUFDM0I7UUFDRjtBQUNMOztBQUlBLFNBQVNmLHNCQUFzQnRRLFNBQVNzUixVQUFVM1g7SUFDaEQsSUFBSTJYLFVBQVU7UUFFWjNYLFlBQVlvVixtQkFBbUJwZixNQUFNNGhCO1FBQ3JDNVgsWUFBWXFWLGdCQUFnQnJmLE1BQU02aEI7UUFDbEM3WCxZQUFZc1YsZ0JBQWdCdGYsTUFBTThoQjtRQUNsQzlYLFlBQVl1VixnQkFBZ0J2ZixNQUFNK2hCO1FBRWxDL1gsWUFBWXdWLGdCQUFnQm5QLFFBQVExRjtRQUNwQ1gsWUFBWXlWLGdCQUFnQnpmLE1BQU1naUI7UUFDbENoWSxZQUFZMFYsZ0JBQWdCclAsUUFBUTRSO1FBQ3BDalksWUFBWTJWLG1CQUFtQjtRQUMvQjNWLFlBQVk0VixxQkFBcUI7QUFDckMsV0FBUztRQUVMNVYsWUFBWW9WLG1CQUFtQnBmLE1BQU1DLFdBQVdpaUIsZ0NBQWdDLEdBQUc3UixRQUFRMUY7UUFDM0ZYLFlBQVlxVixnQkFBZ0JyZixNQUFNaUw7UUFDbENqQixZQUFZc1YsZ0JBQWdCalAsUUFBUWpGO1FBQ3BDcEIsWUFBWXVWLGdCQUFnQnZmLE1BQU1xTDtRQUNsQ3JCLFlBQVl3VixnQkFBZ0JuUCxRQUFRMUY7UUFDcENYLFlBQVl5VixnQkFBZ0J6ZixNQUFNdUw7UUFDbEN2QixZQUFZMFYsZ0JBQWdCMWYsTUFBTW1pQjtRQUNsQ25ZLFlBQVkyVixtQkFBbUI7UUFDL0IzVixZQUFZNFYscUJBQXFCO1FBQ2pDNVYsWUFBWTRKLG9CQUFvQnZELFFBQVF1RCxvQkFBb0J2RCxRQUFRdUQsb0JBQW9CO0FBTXpGO0FBQ0g7O0FBS0EsU0FBU2lOLHlCQUF5QkQsYUFBYXJkLGVBQWV5RyxhQUFhekYsU0FBUztJQUNsRjdNLFFBQVFDLElBQUksR0FBR2tHLGdEQUE4QzBHO0lBQzdELElBQUk2ZCxVQUFVO0lBQ2QsSUFBSUMsYUFBYWpZLGlCQUF3QnZLLGdCQUF1QjBFLFFBQVE7SUFFeEUsSUFBSXFjLFlBQVkwQixnQkFBZ0IxQixZQUFZMkIsZUFBZTtRQUN6RCxJQUFJamlCLE9BQU8sQ0FBQTtRQUNYLElBQUlpRSxVQUFVLEdBQUc7WUFDZmpFLEtBQUs3QixRQUFRdUIsTUFBTXdpQjtBQUN6QixlQUFXO1lBQ0xsaUIsS0FBSzdCLFFBQVEsR0FBRzRqQixjQUFjenFCLE1BQU00SixLQUFLNUg7QUFDMUM7UUFDRDBHLEtBQUtzVixPQUFPLEdBQUcvVixnQkFBdUJDLFNBQWdCOGdCLFlBQVkwQixlQUFlLE1BQU0sR0FBRzNzQjtRQUMxRjJLLEtBQUtaLE9BQU87UUFDWlksS0FBS21pQixVQUFVO1FBQ2ZMLFFBQVE5dkIsS0FBS2dPO0FBQ2pCLFdBQVM7UUFFTCxJQUFJQSxPQUFPLENBQUE7UUFDWCxJQUFJaUUsVUFBVSxHQUFHO1lBQ2YsSUFBSW1lLHdCQUF3QnRZLGlCQUF3QnZLLGdCQUF1QitnQixZQUFZK0IsbUJBQW1CO1lBQzFHcmlCLEtBQUs3QixRQUFRLE9BQU9pa0IseUJBQXlCOXFCLE1BQU00SixLQUFLNUg7WUFDeEQwRyxLQUFLc1YsT0FBTyxHQUFHL1YsZ0JBQXVCQyxTQUFnQjhnQixZQUFZMkIsZUFBZSxNQUFNLEdBQUc1c0I7WUFDMUYySyxLQUFLbWlCLFVBQVU7WUFDZm5pQixLQUFLWixPQUFPO1lBQ1owaUIsUUFBUTl2QixLQUFLZ087WUFDYkEsT0FBTyxDQUFBO1lBQ1BBLEtBQUs3QixRQUFRLEtBQUtpa0IseUJBQXlCOXFCLE1BQU00SixLQUFLNUg7WUFDdEQwRyxLQUFLc1YsT0FBTyxHQUFHL1YsZ0JBQXVCQyxTQUFnQjhnQixZQUFZMEIsZUFBZSxNQUFNLEdBQUczc0I7WUFDMUYySyxLQUFLbWlCLFVBQVU7WUFDZm5pQixLQUFLWixPQUFPO1lBQ1owaUIsUUFBUTl2QixLQUFLZ087WUFDYjBKLFlBQVltVixnQkFBZ0I7QUFDbEMsZUFBVztZQUVMLElBQUk1YixpQkFBaUJxZCxZQUFZK0IsbUJBQW1CO2dCQUVsRHJpQixLQUFLN0IsUUFBUSxHQUFHNGpCLGNBQWN6cUIsTUFBTTRKLEtBQUs1SDtnQkFDekMwRyxLQUFLc1YsT0FBTyxHQUFHL1YsZ0JBQXVCQyxTQUFnQjhnQixZQUFZMEIsZUFBZSxNQUFNLEdBQUczc0I7Z0JBQzFGMkssS0FBS21pQixVQUFVO2dCQUNmbmlCLEtBQUtaLE9BQU87Z0JBQ1owaUIsUUFBUTl2QixLQUFLZ087Z0JBQ2IwSixZQUFZbVYsZ0JBQWdCO0FBQ3BDLG1CQUFhO2dCQUVMLElBQUksaUJBQW1CeUIsWUFBWStCLG9CQUFvQnBlLFFBQVE7b0JBRTdEakUsS0FBSzdCLFFBQVEsR0FBRzRqQixjQUFjenFCLE1BQU00SixLQUFLNUg7b0JBQ3pDMEcsS0FBS3NWLE9BQU8sR0FBRy9WLGdCQUF1QkMsU0FBZ0I4Z0IsWUFBWTJCLGVBQWdCLE1BQU0sR0FBRzVzQjtvQkFDM0YySyxLQUFLbWlCLFVBQVU7b0JBQ2ZuaUIsS0FBS1osT0FBTztvQkFDWjBpQixRQUFROXZCLEtBQUtnTztvQkFFYjBKLFlBQVltVixnQkFBZ0I7b0JBQzVCLElBQUl5RCxRQUFReFksaUJBQ1Z2SyxnQkFBdUI4UCxTQUFnQmlSLFlBQVkrQixvQkFBb0JwZixlQUFlZ0IsU0FBUztvQkFFakd5RixZQUFZa1YsYUFBYWxmLE1BQU1DLFdBQVc0aUIseUJBQXlCLEdBQUdELFNBQVNockIsTUFBTTRKLEtBQUs1SDtBQUNwRyx1QkFBZTtvQkFFTCxJQUFJa3BCLFVBQVVuVCxTQUFnQmlSLFlBQVkrQixtQkFBbUJwZjtvQkFDN0QsSUFBSXdmLGNBQWMzWSxpQkFBd0J2SyxnQkFBdUJpakIsU0FBUztvQkFDMUV4aUIsS0FBSzdCLFFBQVEsR0FBR3NrQixlQUFlbnJCLE1BQU00SixLQUFLNUg7b0JBQzFDMEcsS0FBS3NWLE9BQU8sR0FBRy9WLGdCQUF1QkMsU0FBZ0I4Z0IsWUFBWTJCLGVBQWUsTUFBTSxHQUFHNXNCO29CQUMxRjJLLEtBQUttaUIsVUFBVTtvQkFDZm5pQixLQUFLWixPQUFPO29CQUNaMGlCLFFBQVE5dkIsS0FBS2dPO29CQUNiQSxPQUFPLENBQUE7b0JBQ1AsSUFBSTBpQixVQUFVclQsU0FBZ0JwTCxRQUFRdWU7b0JBQ3RDLElBQUlHLGNBQWM3WSxpQkFBd0J2SyxnQkFBdUJtakIsU0FBUztvQkFDMUUxaUIsS0FBSzdCLFFBQVEsR0FBR3drQixlQUFlcnJCLE1BQU00SixLQUFLNUg7b0JBQzFDMEcsS0FBS3NWLE9BQU8sR0FBRy9WLGdCQUF1QkMsU0FBZ0I4Z0IsWUFBWTBCLGVBQWUsTUFBTSxHQUFHM3NCO29CQUMxRjJLLEtBQUttaUIsVUFBVTtvQkFDZm5pQixLQUFLWixPQUFPO29CQUNaMGlCLFFBQVE5dkIsS0FBS2dPO29CQUNiMEosWUFBWW1WLGdCQUFnQjtBQUM3QjtBQUNGO0FBQ0Y7QUFDRjtJQUVELElBQUluVixZQUFZbk0sT0FBTyxLQUFLbU0sWUFBWXNXLHdCQUF3QixNQUFNO1FBQ3BFLElBQUloZ0IsT0FBTyxDQUFBO1FBQ1hBLEtBQUtaLE9BQU87UUFDWlksS0FBS2dnQix1QkFBdUJ0VyxZQUFZc1c7UUFDeEM4QixRQUFROXZCLEtBQUtnTztBQUNkO0lBQ0Q1SSxRQUFRQyxJQUFJLEdBQUdrRyxzQ0FBb0N4RixLQUFLbkcsVUFBVWt3QjtJQUNsRSxPQUFPQTtBQUNUOztBQUtBLFNBQVMxQixpQkFBaUIxSSxhQUFhaE87SUFDckMsSUFBSXZHLE1BQU07SUFDVixLQUFLLElBQUl4UyxJQUFJLEdBQUdBLElBQUkrbUIsWUFBWXRtQixRQUFRVCxLQUFLO1FBQzNDLElBQUlxUCxPQUFPMFgsWUFBWS9tQjtRQUN2QnFQLEtBQUtaLE9BQU87UUFDWlksS0FBS25CLFFBQVFsTztRQUNicVAsS0FBSzRpQixZQUFZLEdBQUdqeUIsSUFBSTtRQUN4QnFQLEtBQUs2aUIsU0FBUztRQUNkN2lCLEtBQUs4aUIsY0FBYy9OLFVBQVUrSTtRQUM3QjlkLEtBQUsraUIsWUFBWWhPLFVBQVVpSjtRQUMzQixJQUFJaGUsS0FBS3dWLGFBQWEsR0FBRztZQUN2QnhWLEtBQUtzVSxVQUFVLEdBQUd0VSxLQUFLeVYsaUJBQWlCelYsS0FBS3dWO0FBQ25ELGVBQVc7WUFDTHhWLEtBQUtzVSxVQUFVLEtBQUt0VSxLQUFLeVY7QUFDMUI7UUFDRHpWLEtBQUtnakIsV0FBVyxHQUFHempCLGdCQUF1QkMsU0FBZ0JRLEtBQUtzVixNQUFNLE1BQU07UUFDM0VuUyxJQUFJblIsS0FBS2dPO0FBQ1Y7SUFFRCxJQUFJMEosWUFBWW5NLE9BQU8sS0FBS21NLFlBQVlzVyx3QkFBd0IsTUFBTTtRQUNwRSxJQUFJaGdCLE9BQU8sQ0FBQTtRQUNYQSxLQUFLWixPQUFPO1FBQ1pZLEtBQUtnZ0IsdUJBQXVCdFcsWUFBWXNXO1FBQ3hDN2MsSUFBSW5SLEtBQUtnTztBQUNWO0lBQ0QsT0FBT21EO0FBQ1Q7O0FBRUExTCxjQUFZd3JCLGtCQUFrQixTQUFVakQ7SUFDdEMxb0IsTUFBTTRKLEtBQUtnaUIsZ0JBQWdCO0lBQzNCOXJCLFFBQVFDLElBQUkscURBQXFEMm9CO0lBQ2pFbUQsaUJBQXdCLHdDQUF3Qy9wQixTQUFTNG1CO0lBQ3pFb0Q7QUFDRjs7QUFFQTNyQixjQUFZb1YsU0FBUyxTQUFVaE87SUFDN0IsSUFBSW9DLFVBQVUzSixNQUFNNEosS0FBS0MsV0FBV3RDO0lBQ3BDekgsUUFBUUMsSUFBSSxnQkFBZ0I0SixRQUFRNEgsV0FBVzlRLEtBQUtuRyxVQUFVcVA7SUFDOUQsSUFBSUEsUUFBUTRILFVBQVUsR0FBRztRQUN2QjVILFFBQVF1SCxXQUFXb1gsWUFBWTNlLFFBQVE0SCxTQUFTO1FBQ2hENUgsUUFBUStDLFlBQVkvQyxRQUFRdUg7UUFDNUIsSUFBSXRDLFdBQWtCOU4sTUFBTSxHQUFHO1lBQzdCWCxjQUFZd1UsY0FBY2hMLFFBQVErQyxXQUFXbkY7QUFDOUM7QUFDTCxXQUFTO1FBQ0xvQyxRQUFRdUgsV0FBVztRQUNuQnZILFFBQVErQyxZQUFZL0MsUUFBUXVIO0FBQzdCO0lBQ0R1RSxTQUFtQjlMO0FBQ3JCOztBQUVBeEosY0FBWStVLGlCQUFpQixTQUFVQztJQUNyQ3JWLFFBQVFDLElBQUksR0FBR2tHLDBCQUF3QmtQO0FBQ3pDOztBQUVBaFYsY0FBWWlWLGNBQWMsU0FBVUM7SUFDbEN2VixRQUFRQyxJQUFJLEdBQUdrRyx1QkFBcUJvUDtJQUNwQ25WLGFBQVdpUixhQUFhO0FBQzFCOztBQUVBaFIsY0FBWXdVLGdCQUFnQixTQUFVQyxVQUFVck47SUFDOUMsSUFBSW9DLFVBQVUzSixNQUFNNEosS0FBS0MsV0FBV3RDO0lBQ3BDekgsUUFBUUMsSUFBSSxHQUFHa0csbUNBQWlDMk8sdUJBQXVCakwsUUFBUStDLG9CQUFvQm5GO0lBSW5Hb0MsUUFBUStDLFlBQVlrSTtJQUVwQixJQUFJbEosU0FBVWtKLFNBQVM5YSxXQUFXLElBQUssSUFBSSthLFVBQWlCRDtJQUU1RG1YLGNBQWNyZ0IsUUFBUS9CO0lBQ3RCbUwsY0FBeUJwSixRQUFRL0I7SUFDakNxaUIsY0FBY3RnQixRQUFRL0I7SUFDdEJzaUIsc0JBQXNCdmdCLFFBQVEvQjtJQUc5QixLQUFLeUssY0FBY3pLLFVBQVU7UUFDM0JBLFFBQVFvTCxjQUFjO1FBQ3RCOVUsT0FBTytVLFFBQVFDLGVBQWV0TCxRQUFRN0csUUFBUTZHLFFBQVFvTDtRQUN0RDtBQUNEO0lBRURwTCxRQUFRb0wsY0FBY3BMLFFBQVE2SyxlQUFlLFVBQVVJLFlBQVk7SUFDbkU5VSxRQUFRQyxJQUFJLEdBQUdrRyxvQ0FBa0MwRCxRQUFRb0wsaUJBQWlCcEwsUUFBUTZLLGVBQWUsWUFBWUksWUFBWTtJQUd6SCxJQUFJM1UsT0FBTytVLFFBQVFDLGVBQWV0TCxRQUFRN0csUUFBUTZHLFFBQVFvTDtBQUc1RDs7QUFFTyxTQUFTa1gsc0JBQXNCdGYsUUFBUWhEO0lBQzVDN0osUUFBUUMsSUFBSSxHQUFHa0csdUNBQXFDMEc7SUFDcEQsSUFBSXdiLGVBQWV4ZSxRQUFRd2U7SUFDM0IsSUFBSUEsZ0JBQWdCLE1BQU07UUFDeEJyb0IsUUFBUUMsSUFBSSxHQUFHa0c7UUFDZjtBQUNEO0lBQ0QsSUFBSTBGLGdCQUFnQmhDLFFBQVFnQztJQUM1QjdMLFFBQVFDLElBQUksR0FBR2tHLDZDQUEyQ3hGLEtBQUtuRyxVQUFVNnRCLGdDQUFnQ3hjO0lBQ3pHaEMsUUFBUTBkLGFBQWE0Qix5QkFBeUJkLGNBQWN4YyxlQUFlaEMsU0FBU2dEO0FBQ3RGOztBQUtBLFNBQVNxZixjQUFjcmYsUUFBUWhEO0lBQzdCN0osUUFBUUMsSUFBSSxHQUFHa0csNkJBQTJCMEc7SUFDMUMsSUFBSTBTLGFBQWExVixRQUFRMFY7SUFDekIsS0FBSyxJQUFJaG1CLElBQUksR0FBR0EsSUFBSWdtQixXQUFXdmxCLFFBQVFULEtBQUs7UUFDMUMsSUFBSXFQLE9BQU8yVyxXQUFXaG1CO1FBQ3RCLElBQUlzVCxVQUFVakUsS0FBS3lWLGFBQWE7WUFDOUJ6VixLQUFLNmlCLFNBQVM7WUFDZDdpQixLQUFLOGlCLGNBQWMvTixVQUFVK0k7WUFDN0I5ZCxLQUFLK2lCLFlBQVloTyxVQUFVaUo7QUFDakMsZUFBVztZQUNMaGUsS0FBSzZpQixTQUFTO1lBQ2Q3aUIsS0FBSzhpQixjQUFjL04sVUFBVThJO1lBQzdCN2QsS0FBSytpQixZQUFZaE8sVUFBVWdKO0FBQzVCO0FBQ0Y7QUFDSDs7QUFLQXJtQixlQUFlMnJCLGNBQWNyZ0IsUUFBUS9CO0lBQ25DN0osUUFBUUMsSUFBSSxHQUFHa0csNkJBQTJCeUYsMEJBQTBCL0IsUUFBUW9kO0lBQzVFLElBQUlwZCxRQUFRb2Qsa0JBQWtCLFFBQVE7UUFDcEM7QUFDRDtJQUNELElBQUlyYixVQUFVLFFBQVFBLFVBQVUsR0FBRztRQUNqQ0EsU0FBUztBQUNWO0lBQ0QsSUFBSUEsV0FBVyxHQUFHO1FBQ2hCL0IsUUFBUW1kLGtCQUFrQixNQUFNOW1CLE1BQU00SixLQUFLNUg7QUFDL0MsV0FBUztRQUNMLElBQUlILFFBQVE7WUFBRWtKLFdBQVdwQixRQUFRb0I7WUFBV2tKLEtBQUt2STs7UUFDakQ1TCxRQUFRQyxJQUFJLEdBQUdrRywrQkFBNkJ4RixLQUFLbkcsVUFBVXVIO1FBQzNELE1BQU1nQixhQUFhcVIsWUFBbUIsNENBQTRDclM7UUFDbEYvQixRQUFRQyxJQUFJLEdBQUdrRyw4QkFBNEJ4RixLQUFLbkcsVUFBVXVJO1FBQzFELElBQUlBLFFBQVEsTUFBTTtZQUNoQixJQUFJa1AsU0FBU2xQLEtBQUtzUjtZQUNsQnJVLFFBQVFDLElBQUksR0FBR2tHLGdDQUE4QjhMO1lBRTdDcEksUUFBUW1kLGtCQUFrQixHQUFHL1UsVUFBVS9SLE1BQU00SixLQUFLNUg7QUFDeEQsZUFBVztZQUNMbEMsUUFBUUMsSUFBSSxHQUFHa0c7WUFDZjBELFFBQVFtZCxrQkFBa0IsTUFBTTltQixNQUFNNEosS0FBSzVIO0FBQzVDO0FBQ0Y7QUFDSDs7QUFLQSxTQUFTb1MsY0FBY3pLO0lBRXJCLE1BQU0wSyxXQUFXNUgsV0FBVzlDLFFBQVErQztJQUNwQyxNQUFNb0YsU0FBU3JGLFdBQVc5QyxRQUFRdWU7SUFDbEMsTUFBTTNXLFVBQVU5RSxXQUFXOUMsUUFBUTRIO0lBRW5DLE1BQU1zQixpQkFBaUJwRyxXQUFXOUMsUUFBUWtKO0lBRTFDLElBQUl3QixXQUFXOUMsU0FBUztRQUN0QjVILFFBQVE4SCxpQkFBaUI7UUFDekI5SCxRQUFRMkssY0FBY2xNLE1BQU1tTTtRQUM1QjVLLFFBQVE2SyxjQUFjO1FBQ3RCLE9BQU87QUFDWCxXQUFTLElBQUlILFdBQVd2QyxRQUFRO1FBQzVCbkksUUFBUThILGlCQUFpQjtRQUN6QjlILFFBQVEySyxjQUFjbE0sTUFBTUMsV0FBV29NLGtDQUNyQyxHQUFHOUssUUFBUXVlLFdBQ1gsR0FBR2xvQixNQUFNNEosS0FBSzVIO1FBRWhCMkgsUUFBUTZLLGNBQWM7UUFDdEIsT0FBTztBQUNYLFdBQVMsSUFBSUgsV0FBV3hCLGdCQUFnQjtRQUNwQ2xKLFFBQVE4SCxpQkFBaUI7UUFDekI5SCxRQUFRMkssY0FBY2xNLE1BQU1zTTtRQUM1Qi9LLFFBQVE2SyxjQUFjO1FBQ3RCLE9BQU87QUFDWCxXQUFTO1FBQ0w3SyxRQUFROEgsaUJBQWlCO1FBQ3pCOUgsUUFBUTZLLGNBQWM7UUFDdEIsT0FBTztBQUNSO0FBQ0g7O0FBRUFyVSxjQUFZK3JCLHNCQUFzQixTQUFVM2tCO0lBQzFDLElBQUlvQyxVQUFVM0osTUFBTTRKLEtBQUtDLFdBQVd0QztJQUNwQyxJQUFJb0MsUUFBUXNlLG9CQUFvQnRCLGtCQUFrQkMsU0FBUztRQUV6RGpkLFFBQVFzZSxtQkFBbUJ0QixrQkFBa0JFO1FBQzdDbGQsUUFBUTJHLFdBQVc7QUFDdkIsV0FBUztRQUVMM0csUUFBUXNlLG1CQUFtQnRCLGtCQUFrQkM7UUFDN0NqZCxRQUFRMkcsV0FBVztBQUNwQjtJQUNENmIsb0JBQThCeGlCLFFBQVEyRztBQUN4Qzs7QUN6bkJBLFNBQVNvSjtJQUNQLE9BQU87UUFDTDBTLFNBQVM7UUFDVEMsYUFBYTtRQUNiQyxhQUFhO1FBQ2J6aUIsWUFBWTtRQUNaOEcsY0FBYztRQUNkM08sVUFBVTtRQUNWdVAsU0FBUztRQUNUZ2IsU0FBUztRQUNUQyxVQUFVO1FBQ1ZDLFlBQVlya0IsTUFBTXNrQjtRQUNsQmQsZUFBZTs7QUFFbkI7O0FBRUEsSUFBSXZXLFlBQVksQ0FBQTs7QUFHaEIsSUFBSXNYLFdBQVc7O0FBQ2YsSUFBSUMsZUFBZTs7QUFDbkIsSUFBSUMsbUJBQW1COztBQUN2QixJQUFJUCxjQUFjOztBQUNsQixJQUFJUSxzQkFBc0I7O0FBRzFCLElBQUlDLGVBQWU7O0FBRW5CL3NCLE1BQU02cEIsY0FBYztJQUNsQkMsU0FBUzs7O0FBR1gsT0FBTTVwQixZQUFFQSxjQUFZQyxhQUFBQSxpQkFBZ0I2USxhQUFvQixRQUFRMEksZUFBYTtJQUFFbGE7SUFBVUU7SUFBVUQ7OztBQUVuRyxTQUFTRCxTQUFTd3RCO0lBQ2hCbHRCLFFBQVFDLElBQUksd0JBQXdCLEdBQUdpdEI7SUFDdkM5c0IsYUFBVytzQixrQkFBa0I7UUFBRUMsZUFBaUI7UUFBUUMsa0JBQW9COztJQUM1RWp0QixhQUFXa3RCLFlBQVlDO0lBRXZCaFksWUFBWTVVLEtBQUt4SCxNQUFNK3pCO0lBRXZCaHRCLE1BQU1nVixRQUFRc1ksZUFBZSwySkFBMkoxZSxXQUFrQjNOLFNBQVMyTixXQUFrQjFOO0lBRXJPaEIsYUFBV3FzQixVQUFValMsd0JBQStCakYsVUFBVXJUO0lBQzlEOUIsYUFBV3NzQixXQUFXLEdBQUduWCxVQUFVclQsWUFBWW9HLE1BQU1tbEI7SUFDckRDLHNCQUFzQjtBQUN4Qjs7QUFFQSxTQUFTOXRCO0lBQ1AsSUFBSW10QixvQkFBb0I3c0IsTUFBTTRKLEtBQUtnaUIsZUFBZTtRQUNoRDlyQixRQUFRQyxJQUFJO1FBQ1p5dEIsc0JBQXNCO1FBQ3RCeHRCLE1BQU00SixLQUFLZ2lCLGdCQUFnQjtBQUM1QjtJQUNEaUIsbUJBQW1CO0FBQ3JCOztBQUVBLFNBQVNwdEI7SUFDUGd1QjtBQUNGOztBQUVBcnRCLGVBQWVvdEIsc0JBQXNCL2UsYUFBYWlmLGlCQUFpQjtJQUNqRVgsZUFBZW5wQixLQUFLK3BCO0lBQ3BCLElBQUlDLFVBQVU7UUFDWjVyQixVQUFVcVQsVUFBVXJUOztJQUd0QixNQUFNYSxhQUFhcVIsWUFBbUIsNkNBQTZDMFo7SUFDbkYsSUFBSS9xQixRQUFRLE1BQU07UUFHaEJnckIsdUJBQWlDO0FBQ2xDO0lBQ0QvdEIsUUFBUUMsSUFBSSxzQkFBc0JVLEtBQUtuRyxVQUFVdUk7SUFHakQsSUFBSWlyQixPQUFPO0lBQ1gsS0FBSyxNQUFNQyxLQUFLbHJCLEtBQUttckIsVUFBVTtRQUU3QixJQUFJRCxFQUFFcGYsZUFBZSxPQUFPb2YsRUFBRTliLGlCQUFpQixHQUFHO1lBQ2hENmIsS0FBS3B6QixLQUFLcXpCLEVBQUVoakI7QUFDbEIsZUFBVyxJQUFJZ2pCLEVBQUVwZixlQUFlLE9BQU9vZixFQUFFOWIsaUJBQWlCLEdBQUc7WUFDdkQsSUFBSThiLEVBQUVqZixhQUFhLE9BQU9pZixFQUFFamYsYUFBYSxLQUFLO2dCQUM1Q2dmLEtBQUtwekIsS0FBS3F6QixFQUFFaGpCO0FBQ2I7QUFDRjtBQUNGO0lBQ0RqTCxRQUFRQyxJQUFJLCtCQUErQlUsS0FBS25HLFVBQVV3ekI7SUFDMUQsSUFBSWhqQixtQkFBbUIsQ0FBQTtJQUN2QixJQUFJZ2pCLEtBQUtoMEIsU0FBUyxHQUFHO1FBQ25CLElBQUltMEIsYUFBYUgsS0FBS256QixLQUFLO1FBQzNCLElBQUlrSCxRQUFRO1lBQUVvc0IsWUFBWUE7O1FBQzFCbnVCLFFBQVFDLElBQUksZ0NBQWdDVSxLQUFLbkcsVUFBVXVIO1FBQzNELE1BQU1xc0IsbUJBQW1CaGEsWUFBbUIsOENBQThDclM7UUFDMUYsSUFBSXFzQixjQUFjQSxjQUFjLE1BQU07WUFDcENwakIsbUJBQW1Cb2pCO0FBQ3BCO0FBQ0Y7SUFDRGx1QixNQUFNMmtCLEtBQUtNLG1CQUFtQnNFLEtBQVk0RSxXQUFnQjl1QixZQUFZOHVCLFdBQWdCL0o7SUFDdEZwa0IsTUFBTTJrQixLQUFLTyxtQkFBbUJxRSxLQUFZNEUsV0FBZ0I5dUIsWUFBWTh1QixXQUFnQjlKO0lBQ3RGdmtCLFFBQVFDLElBQUkscUNBQXFDQyxNQUFNMmtCLEtBQUtNLDBCQUEwQmpsQixNQUFNMmtCLEtBQUtPO0lBQ2pHcGxCLFFBQVFDLElBQUksMkNBQTJDVSxLQUFLbkcsVUFBVXdRO0lBRXRFc2pCLGNBQWN2ckIsTUFBTWlJLGtCQUFrQjJELGFBQWFpZjtBQUNyRDs7QUFFQSxTQUFTVSxjQUFjdnJCLE1BQU1pSSxrQkFBa0IyRCxhQUFhaWYsaUJBQWlCO0lBRTNFeHRCLGFBQVc4QixXQUFXYSxLQUFLYjtJQUMzQjlCLGFBQVdzVixjQUFjLEdBQUdoRCxpQkFBd0JNLGVBQXNCalEsS0FBS3dyQixlQUFlO0lBQzlGbnVCLGFBQVdxUixVQUFVMU8sS0FBS3dyQjtJQWExQixJQUFJQyxjQUFjO0lBQ2xCLElBQUl6a0IsYUFBYTtJQUdqQixJQUFJK1YsTUFBTTtJQUNWL2MsS0FBS21yQixTQUFTTyxTQUFRLENBQUM1a0IsU0FBU3BDO1FBQzlCLElBQUl1bEIsdUJBQXVCLEtBQUt6WCxVQUFVdEssYUFBYS9FLGFBQWFxUCxVQUFVdEssVUFBVXRNLFNBQVNrTCxRQUFRb0IsWUFBWTtZQUNuSGpMLFFBQVFDLElBQUksd0NBQXdDc1YsVUFBVXRLLGtCQUFrQjZVO1lBQ2hGa04scUJBQXFCbE47QUFDdEI7UUFDRCxJQUFJalcsUUFBUWdGLGVBQWUsS0FBSztZQUM5QixJQUFJaEYsUUFBUWtGLFdBQVcsS0FBSztnQkFFMUJ5ZixZQUFZNXpCLEtBQUs7b0JBQ2ZvTixNQUFNO29CQUNON0IsS0FBS3dVLE9BQU9tRjtvQkFDWjRPLGFBQWE1TyxPQUFPa04scUJBQXFCLCtCQUErQjtvQkFDeEUyQixRQUFRQyxVQUFVL2tCLFFBQVExRDtvQkFDMUIwb0IsT0FBT0MsU0FBU2psQixRQUFRMUQ7b0JBQ3hCNG9CLFNBQVNDLFdBQVdubEIsUUFBUTFELEtBQUswRCxRQUFRb2xCO29CQUN6Q0MsY0FBY0MsZ0JBQWdCdGxCLFFBQVExRDtvQkFDdENpcEIsVUFBVUMsWUFBWXhsQixRQUFRMUQ7b0JBQzlCbXBCLFNBQVM7b0JBQ1RDLFVBQVUsR0FBR3BuQixnQkFBdUJDLFNBQWdCeUIsUUFBUTJsQixTQUFTLE1BQU07b0JBQzNFQyxPQUFPbm5CLE1BQU1vbkI7O2dCQUVmLEtBQUs5QixnQkFBZ0I7b0JBRW5CLElBQUk3cUIsT0FBTzRzQixvQkFBNkI5bEIsU0FBU21CO29CQUNqRGpJLEtBQUswRSxRQUFRcVk7b0JBQ2IvYyxLQUFLaUYsT0FBTztvQkFDWmhJLFFBQVFDLElBQUksR0FBRzZmLGtDQUFrQ25mLEtBQUtuRyxVQUFVdUk7b0JBQ2hFZ0gsV0FBV25QLEtBQUttSTtBQUNqQjtnQkFDRCtjO0FBQ1IsbUJBQWEsSUFBSWpXLFFBQVFrRixXQUFXLEtBQUs7Z0JBQ2pDLE1BQU02Z0IsU0FBUyxHQUFHem5CLGdCQUF1QkMsU0FBZ0J5bkIsT0FBT2htQixVQUFVLE1BQU07Z0JBQ2hGLElBQUkrakIsZ0JBQWdCO29CQUNsQixNQUFNa0MsVUFBVTF2QixhQUFXb3NCLFlBQVkxTTtvQkFDdkMsTUFBTWlRLFVBQVVELFFBQVFQO29CQUN4QnZ2QixRQUFRQyxJQUNOLDRDQUE0Qzh2QixtQkFBbUJILDBCQUEwQmhDO29CQUUzRixJQUFJbUMsV0FBV0gsUUFBUTt3QkFFckIsTUFBTUksY0FBYzV2QixhQUFXMkosV0FBVytWO3dCQUMxQ2tRLFlBQVkzSCxlQUFleGUsUUFBUXFmO3dCQUNuQytHLHNCQUErQkQsWUFBWXBqQixXQUFXb2pCO3dCQUN0REYsUUFBUVAsV0FBV0s7QUFDcEI7b0JBQ0RFLFFBQVFJLGVBQWVybUIsUUFBUXFtQjtvQkFDL0JKLFFBQVFLLFdBQVdDLFdBQVd2bUIsUUFBUXFtQjtBQUN2QztnQkFFRDFCLFlBQVk1ekIsS0FBSztvQkFDZm9OLE1BQU07b0JBQ043QixLQUFLd1UsT0FBT21GO29CQUNaNE8sYUFBYTVPLE9BQU9rTixxQkFBcUIsK0JBQStCO29CQUN4RTJCLFFBQVFDLFVBQVUva0IsUUFBUTFEO29CQUMxQjBvQixPQUFPQyxTQUFTamxCLFFBQVExRDtvQkFDeEI0b0IsU0FBU0MsV0FBV25sQixRQUFRMUQsS0FBSzBELFFBQVFvbEI7b0JBQ3pDQyxjQUFjQyxnQkFBZ0J0bEIsUUFBUTFEO29CQUN0Q2lwQixVQUFVQyxZQUFZeGxCLFFBQVExRDtvQkFDOUJtcEIsU0FBUztvQkFDVGUsVUFBVTtvQkFDVnhoQixhQUFhaEYsUUFBUWdGO29CQUNyQkUsU0FBU2xGLFFBQVFrRjtvQkFDakJtaEIsY0FBY3JtQixRQUFRcW1CO29CQUN0QkMsVUFBVUMsV0FBV3ZtQixRQUFRcW1CO29CQUM3QlgsVUFBVUs7b0JBQ1ZILE9BQU9ubkIsTUFBTW9uQjs7Z0JBR2YsS0FBSzlCLGdCQUFnQjtvQkFDbkIsSUFBSTdxQixPQUFPNHNCLG9CQUE2QjlsQixTQUFTbUI7b0JBQ2pEakksS0FBSzBFLFFBQVFxWTtvQkFDYi9jLEtBQUtpRixPQUFPO29CQUNaaEksUUFBUUMsSUFBSSxHQUFHNmYsbUNBQW1DbmYsS0FBS25HLFVBQVV1STtvQkFDakVnSCxXQUFXblAsS0FBS21JO0FBQ2pCO2dCQUNEdXRCO2dCQUNBeFE7QUFDRDtBQUNQLGVBQVcsSUFBSWpXLFFBQVFnRixlQUFlLEtBQUs7WUFDckMsSUFBSWhGLFFBQVFtRixhQUFhLE9BQU9uRixRQUFRbUYsYUFBYSxLQUFLO2dCQUV4RHdmLFlBQVk1ekIsS0FBSztvQkFDZm9OLE1BQU07b0JBQ043QixLQUFLd1UsT0FBT21GO29CQUNaNE8sYUFBYTVPLE9BQU9rTixxQkFBcUIsK0JBQStCO29CQUN4RTJCLFFBQVFDLFVBQVUva0IsUUFBUTFEO29CQUMxQjBvQixPQUFPQyxTQUFTamxCLFFBQVExRDtvQkFDeEI0b0IsU0FBU0MsV0FBV25sQixRQUFRMUQsS0FBSzBELFFBQVFvbEI7b0JBQ3pDQyxjQUFjQyxnQkFBZ0J0bEIsUUFBUTFEO29CQUN0Q2lwQixVQUFVQyxZQUFZeGxCLFFBQVExRDtvQkFDOUJtcEIsU0FBUztvQkFDVEMsVUFBVSxHQUFHcG5CLGdCQUF1QkMsU0FBZ0J5QixRQUFRMmxCLFNBQVMsTUFBTTtvQkFDM0VDLE9BQU8sR0FBRzVsQixRQUFRK0UsUUFBUXRHLE1BQU1pb0I7O2dCQUVsQyxLQUFLM0MsZ0JBQWdCO29CQUVuQixJQUFJM1osV0FBV3VjLHFCQUEyQjNtQixTQUFTbUI7b0JBQ25EaUosU0FBU3hNLFFBQVFxWTtvQkFDakI3TCxTQUFTak0sT0FBTztvQkFDaEJoSSxRQUFRQyxJQUFJLEdBQUc2ZixvQ0FBb0NuZixLQUFLbkcsVUFBVXlaO29CQUNsRWxLLFdBQVduUCxLQUFLcVo7QUFDakI7Z0JBQ0Q2TDtBQUNSLG1CQUFhLElBQUlqVyxRQUFRbUYsYUFBYSxLQUFLO2dCQUVuQ3dmLFlBQVk1ekIsS0FBSztvQkFDZm9OLE1BQU07b0JBQ043QixLQUFLd1UsT0FBT21GO29CQUNaNE8sYUFBYTVPLE9BQU9rTixxQkFBcUIsK0JBQStCO29CQUN4RTJCLFFBQVFDLFVBQVUva0IsUUFBUTFEO29CQUMxQjBvQixPQUFPQyxTQUFTamxCLFFBQVExRDtvQkFDeEI0b0IsU0FBU0MsV0FBV25sQixRQUFRMUQsS0FBSzBELFFBQVFvbEI7b0JBQ3pDQyxjQUFjQyxnQkFBZ0J0bEIsUUFBUTFEO29CQUN0Q2lwQixVQUFVQyxZQUFZeGxCLFFBQVExRDtvQkFDOUJtcEIsU0FBUztvQkFDVEMsVUFBVSxHQUFHcG5CLGdCQUF1QkMsU0FBZ0J5QixRQUFRMmxCLFNBQVMsTUFBTTtvQkFDM0VDLE9BQU8sR0FBRzVsQixRQUFRK0UsUUFBUXRHLE1BQU1pb0I7O2dCQUVsQyxLQUFLM0MsZ0JBQWdCO29CQUVuQixJQUFJM1osV0FBV3VjLHFCQUEyQjNtQixTQUFTbUI7b0JBQ25EaUosU0FBU3hNLFFBQVFxWTtvQkFDakI3TCxTQUFTak0sT0FBTztvQkFDaEJoSSxRQUFRQyxJQUFJLEdBQUc2ZixvQ0FBb0NuZixLQUFLbkcsVUFBVXlaO29CQUNsRWxLLFdBQVduUCxLQUFLcVo7QUFDakI7Z0JBQ0Q2TDtBQUNEO0FBQ0Y7O0lBR0g5ZixRQUFRQyxJQUFJLEdBQUc2ZixrQ0FBa0NuZixLQUFLbkcsVUFBVXVQO0lBQ2hFL0osUUFBUUMsSUFBSSxHQUFHNmYsbUNBQW1DbmYsS0FBS25HLFVBQVVnMEI7SUFDakVoQyxjQUFjZ0M7SUFFZCxJQUFJeEIsdUJBQXVCLEdBQUc7UUFDNUI1c0IsYUFBV3lRLGVBQWU7UUFDMUIyYixZQUFZLEdBQUdrQyxjQUFjO0FBQ2pDLFdBQVM7UUFDTHR1QixhQUFXeVEsZUFBZW1jO0FBQzNCO0lBRUQsS0FBS1ksZ0JBQWdCO1FBQ25CeHRCLGFBQVcySixhQUFhQTtRQUN4QjNKLGFBQVdvc0IsY0FBY0E7QUFDMUI7SUFFRCxJQUFJM2lCLFVBQVV4SixjQUFZdVEsa0JBQWtCeFEsYUFBV3lRO0lBQ3ZEMVEsT0FBTytVLFFBQVFDLGVBQWV0TCxRQUFRN0csUUFBUTZHLFFBQVFvTDtJQUV0RDdVLGFBQVdrc0IsVUFBVTtJQUdyQm1FLFNBQW1CcndCLGFBQVcySixXQUFXM0osYUFBV3lRLGVBQWUvTSxLQUFLK3BCLFFBQVFaLGNBQWN0ZTtJQUU5Rm9mLHVCQUFpQztJQUVqQzJDLHFCQUFxQjdtQjtBQUN2Qjs7QUFLQSxTQUFTK2tCLFVBQVV6b0I7SUFDakIsSUFBSUEsT0FBTyxLQUFLQSxPQUFPLEdBQUc7UUFDeEIsT0FBTztBQUNYLFdBQVM7UUFDTCxPQUFPO0FBQ1I7QUFDSDs7QUFFQSxTQUFTMm9CLFNBQVMzb0I7SUFDaEIsSUFBSUEsT0FBTyxHQUFHO1FBQ1osT0FBTztBQUNYLFdBQVMsSUFBSUEsT0FBTyxHQUFHO1FBQ25CLE9BQU87QUFDWCxXQUFTO1FBQ0wsT0FBTztBQUNSO0FBQ0g7O0FBRUEsU0FBUzZvQixXQUFXN29CLEtBQUs4b0I7SUFDdkIsSUFBSTlvQixPQUFPLEdBQUc7UUFDWixPQUFPbUMsTUFBTXFvQjtBQUNqQixXQUFTO1FBQ0wsT0FBTzFCO0FBQ1I7QUFDSDs7QUFFQSxTQUFTRSxnQkFBZ0JocEI7SUFDdkIsSUFBSUEsT0FBTyxLQUFLO1FBQ2QsT0FBTztBQUNYLFdBQVMsSUFBSUEsT0FBTyxLQUFLO1FBQ3JCLE9BQU87QUFDWCxXQUFTO1FBQ0wsT0FBTztBQUNSO0FBQ0g7O0FBRUEsU0FBU2twQixZQUFZbHBCO0lBQ25CLElBQUlBLE9BQU8sS0FBSztRQUNkLE9BQU87QUFDWCxXQUFTO1FBQ0wsT0FBTztBQUNSO0FBQ0g7O0FBRUEsU0FBUzBwQixPQUFPaG1CO0lBQ2Q7UUFDRSxJQUFJQSxRQUFRcWYsWUFBWTJCLGlCQUFpQixRQUFRaGhCLFFBQVFxZixZQUFZMkIsaUJBQWlCM2tCLFdBQVc7WUFDL0YsT0FBTzJELFFBQVEybEI7QUFDckIsZUFBVztZQUNMLE9BQU85eEIsS0FBS2t6QixJQUFJamtCLFdBQVc5QyxRQUFRcWYsWUFBWTJCLGdCQUFnQmxlLFdBQVc5QyxRQUFRMmxCO0FBQ25GO0FBQ0YsTUFBQyxPQUFPeDJCO1FBQ1BnSCxRQUFRaEgsRUFBRUE7UUFDVixPQUFPO0FBQ1I7QUFDSDs7QUFFQSxTQUFTczNCO0lBQ1AzQztJQUNBZCxXQUFXZ0UsWUFBWUMsaUJBQWlCO0FBQzFDOztBQUVBLFNBQVNBO0lBQ1AsS0FBSyxJQUFJdjNCLElBQUksR0FBR0EsSUFBSWl6QixZQUFZeHlCLFFBQVFULEtBQUs7UUFDM0MsSUFBSXNRLFVBQVUyaUIsWUFBWWp6QjtRQUUxQixJQUFJc1EsUUFBUWdGLGVBQWUsT0FBT2hGLFFBQVFrRixXQUFXLEtBQUs7WUFDeEQsSUFBSW1oQixlQUFlcm1CLFFBQVFxbUIsZUFBZ0JwRCxlQUFlO1lBQzFEQSxlQUFlQSxlQUFlO1lBQzlCLElBQUlvRCxnQkFBZ0IsS0FBTTtnQkFFeEI5dkIsYUFBV29zQixZQUFZanpCLEdBQUc0MkIsV0FBV0MsV0FBV0Y7Z0JBQ2hEMUQsWUFBWWp6QixHQUFHNDJCLFdBQVdDLFdBQVdGO0FBQzdDLG1CQUFhO2dCQUVMdkM7Z0JBQ0FELHNCQUFzQixPQUFPO0FBQzlCO0FBQ0Y7QUFDRjtBQUVIOztBQUVBLFNBQVMwQyxXQUFXVztJQUNsQixNQUFNdGQsT0FBTyxJQUFJM1AsS0FBS2l0QjtJQUN0QixNQUFNQyxXQUFXLE1BQU12ZCxLQUFLcFAsY0FBY25MLE9BQU87SUFDakQsTUFBTSszQixXQUFXLE1BQU14ZCxLQUFLblAsY0FBY3BMLE9BQU87SUFDakQsSUFBSTYzQixZQUFhLE1BQU8sSUFBSztRQUMzQixPQUFPLEdBQUdFO0FBQ2QsV0FBUztRQUNMLE9BQU8sR0FBR0QsV0FBV0M7QUFDdEI7QUFDSDs7QUFFQSxTQUFTdEQ7SUFDUCxJQUFJZCxZQUFZLE1BQU07UUFDcEJxRSxjQUFjckU7UUFDZEEsV0FBVztRQUNYQyxlQUFlO0FBQ2hCO0FBQ0g7O0FBS0F6c0IsY0FBWWtzQixjQUFjLFNBQVVwbUI7SUFDbENuRyxRQUFRQyxJQUFJLHFDQUFxQ2tHO0lBQ2pELElBQUlBLE9BQU8vRixhQUFXeVEsY0FBYztRQUNsQztBQUNEO0lBQ0R6USxhQUFXeVEsZUFBZTFLO0lBQzFCL0YsYUFBV21zQixjQUFjcG1CO0FBQzNCOztBQUtBOUYsY0FBWTh3QixvQkFBb0IsU0FBVTV1QjtJQUN4Q3ZDLFFBQVFDLElBQUksOENBQThDc0Msd0JBQXdCbkMsYUFBV3lRO0lBQzdGLElBQUkyYixZQUFZeHlCLFVBQVUsR0FBRztRQUMzQjtBQUNEO0lBQ0R3eUIsWUFBWWlDLFNBQVMyQztRQUNuQixJQUFJQSxJQUFJanJCLE9BQU81RCxRQUFRO1lBRXJCNnVCLElBQUkxQyxjQUFjO0FBQ3hCLGVBQVc7WUFFTDBDLElBQUkxQyxjQUFjO0FBQ25COztJQUVIdHVCLGFBQVdvc0IsY0FBY0E7SUFDekJwc0IsYUFBV21zQixjQUFjaHFCO0lBQ3pCeXFCLHFCQUFxQnpxQjtJQUNyQixJQUFJc0gsVUFBVXpKLGFBQVcySixXQUFXeEg7SUFFcENwQyxPQUFPK1UsUUFBUUMsZUFBZXRMLFFBQVE3RyxRQUFRNkcsUUFBUW9MO0lBQ3REd2IsU0FBbUI1bUIsU0FBUyxHQUFHO0lBRS9CNm1CLHFCQUFxQjdtQjtBQUN2Qjs7QUFFQSxTQUFTMGpCO0lBQ1AsT0FBTyxDQVVUO0FBQ0E7O0FBRUFqdEIsZUFBZW93QixxQkFBcUI3bUI7SUFFbEMsSUFBSTBMLFVBQVVyVCxZQUFZLFVBQVUySCxRQUFRZ0YsZUFBZSxLQUFLO1FBRTlELElBQUl3aUIsZ0JBQWdCNUgsS0FBWSxlQUFlO1FBQy9DLElBQUk0SCxXQUFXLEtBQUs7a0JBRVpyTCxLQUFZLGVBQWUsV0FBVztZQUM1QzdsQixPQUFPdWQsWUFBWWpUO0FBQ3BCO0FBQ0Y7QUFDSDs7QUFFQXBLLGNBQVkyVixjQUFjO0lBQ3hCc2I7SUFDQXJiO0FBQ0Y7O0FBS0E1VixjQUFZdVEsb0JBQW9CLFNBQVVuSjtJQUN4QyxJQUFJQSxRQUFRLEtBQUtBLFNBQVNySCxhQUFXMkosV0FBVy9QLFFBQVE7UUFDdERnRyxRQUFRQyxJQUFJLGtDQUFrQ3dIO1FBQzlDLE9BQU87QUFDUjtJQUNELE9BQU9ySCxhQUFXMkosV0FBV3RDO0FBQy9COztBQUdBcEgsY0FBWWt4QixVQUFVO0lBRXBCLElBQUlDLGFBQWE7UUFBRXhwQixNQUFNO1FBQUc5RixVQUFVaEMsTUFBTTRKLEtBQUs1SDs7SUFDakRsQyxRQUFRQyxJQUFJLGFBQWFVLEtBQUtuRyxVQUFVZzNCO0lBQ3hDNXdCLFdBQVc2d0Isa0JBQWtCOXdCLEtBQUtuRyxVQUFVZzNCO0lBQzVDLElBQUkzbkIsVUFBVXhKLGNBQVl1USxrQkFBa0J4USxhQUFXeVE7SUFDdkQ2Z0IsU0FBbUI3bkI7SUFFbkIzSixNQUFNNEosS0FBS2dpQixnQkFBZ0I7QUFDN0I7O0FBRUF6ckIsY0FBWXN4QixXQUFXO0lBRXJCLElBQUlDLGNBQWM7UUFBRTVwQixNQUFNO1FBQUk5RixVQUFVaEMsTUFBTTRKLEtBQUs1SDs7SUFDbkRsQyxRQUFRQyxJQUFJLGNBQWNVLEtBQUtuRyxVQUFVbzNCO0lBQ3pDaHhCLFdBQVdpeEIsS0FBS2x4QixLQUFLbkcsVUFBVW8zQjtJQUMvQixJQUFJL25CLFVBQVV4SixjQUFZdVEsa0JBQWtCeFEsYUFBV3lRO0lBQ3ZEaWhCLGNBQXdCam9CO0lBRXhCM0osTUFBTTRKLEtBQUtnaUIsZ0JBQWdCO0FBQzdCOztBQUVBenJCLGNBQVlzYixtQkFBbUIsU0FBVXVSO0lBQ3ZDbHRCLFFBQVFDLElBQUksc0JBQXNCaXRCO0lBRWxDM1gsWUFBWTVVLEtBQUt4SCxNQUFNK3pCO0lBRXZCOXNCLGFBQVdxc0IsVUFBVWpTLHdCQUErQmpGLFVBQVVyVDtJQUM5RDlCLGFBQVdzc0IsV0FBVyxHQUFHblgsVUFBVXJULFlBQVlvRyxNQUFNbWxCO0lBRXJERTtJQUNBdnRCLGFBQVdrc0IsVUFBVTtJQUNyQlMsbUJBQW1CO0lBQ25CQyxzQkFBc0IsR0FDcEI1c0IsYUFBVzJKLGFBQWE7SUFDMUIzSixhQUFXb3NCLGNBQWM7SUFDekJBLGNBQWM7SUFDZGtCLHNCQUFzQjtBQUN4Qjs7QUN0Z0JBLElBQUlxRSxZQUFZOztBQUVoQixTQUFTblk7SUFDUCxPQUFPO1FBQ0xvWSxVQUFVO1FBQ1ZDLGVBQWU7UUFDZkMsZUFBZTtRQUNmQyxpQkFBaUI7UUFDakIzRSxjQUFjOztBQUVsQjs7QUFFQSxPQUFNcHRCLFlBQUVBLFlBQVVDLGFBQUVBLGVBQWdCNlEsYUFBb0IsV0FBVzBJLGFBQWEsQ0FBQTs7QUFHaEZ2WixZQUFZNnhCLGdCQUFnQjtJQUMxQixJQUFJOXhCLFdBQVc4eEIsZUFBZTtRQUM1Qjl4QixXQUFXOHhCLGdCQUFnQjtRQUMzQjl4QixXQUFXK3hCLGtCQUFrQjtRQUM3Qi94QixXQUFXZ3lCLGtCQUFrQjtBQUNqQyxXQUFTO1FBQ0xoeUIsV0FBVzh4QixnQkFBZ0I7UUFDM0I5eEIsV0FBVyt4QixrQkFBa0I7UUFDN0IveEIsV0FBV2d5QixrQkFBa0I7QUFDOUI7SUFDRCxJQUFJdm9CLFVBQVUxSixPQUFPMkosS0FBSzhHLGtCQUFrQjFRLE1BQU00SixLQUFLK0c7SUFDdkQ3USxRQUFRQyxJQUFJLEdBQUdrRyxrQ0FBa0MwRCxRQUFRb0w7SUFDekRFLGVBQWV0TCxRQUFRN0csUUFBUTZHLFFBQVFvTDtBQUN6Qzs7QUFFQSxTQUFTRSxlQUFla2QsZUFBZXBkLGNBQWM7SUFDbkRqVixRQUFRQyxJQUFJLEdBQUdrRyxxQ0FBcUNrc0IsOEJBQThCcGQ7SUFDbEYsUUFBUW9kO01BQ04sS0FBSztRQUVIbnlCLE1BQU00SixLQUFLNmlCLGFBQWFya0IsTUFBTWdxQjtRQUM5Qjs7TUFDRixLQUFLO1FBRUhweUIsTUFBTTRKLEtBQUs2aUIsYUFBYXJrQixNQUFNc2tCO1FBQzlCOztNQUNGLEtBQUs7UUFFSDFzQixNQUFNNEosS0FBSzZpQixhQUFhcmtCLE1BQU1pcUI7UUFDOUI7O01BQ0YsS0FBSztRQUVIcnlCLE1BQU00SixLQUFLNmlCLGFBQWFya0IsTUFBTWtxQjtRQUM5Qjs7SUFFSixJQUFJSCxpQkFBaUIsS0FBS3BkLGVBQWU3VSxXQUFXOHhCLGVBQWU7UUFDakVILFlBQVk7UUFDWjN4QixXQUFXNHhCLFdBQVc7UUFDdEI1eEIsV0FBVzZ4QixnQkFBZ0I7UUFDM0IsT0FBTztBQUNYLFdBQVM7UUFDTEYsWUFBWTtRQUNaM3hCLFdBQVc0eEIsV0FBVztRQUN0QjV4QixXQUFXNnhCLGdCQUFnQjtRQUMzQixPQUFPO0FBQ1I7QUFDSDs7QUFHQTV4QixZQUFZb3lCLGdCQUFnQjtJQUMxQixLQUFLVixXQUFXO1FBQ2Q7QUFDRDtJQUNELElBQUlsb0IsVUFBVTFKLE9BQU8ySixLQUFLOEcsa0JBQWtCMVEsTUFBTTRKLEtBQUsrRztJQUN2RGhILFFBQVF3SCxhQUFhO0lBQ3JCLElBQUlxaEIsY0FBYztJQUNsQixJQUFJamIsWUFBWTtJQUVoQixJQUFJNU4sUUFBUWdGLGVBQWUsR0FBRztRQUM1QjRJLFlBQVlrYiw0QkFBNEI5b0I7UUFDeEM2b0IsY0FBY0UsdUJBQXVCbmIsV0FBVzVOLFFBQVErQztBQUM1RCxXQUFTLElBQUkvQyxRQUFRZ0YsZUFBZSxHQUFHO1FBQ25DNEksWUFBWW9iLHlCQUF5QmhwQjtRQUNyQzZvQixjQUFjSSxvQkFBb0JyYixXQUFXNU4sUUFBUStDLFdBQVcvQztBQUNwRSxXQUFTO1FBQ0w3SixRQUFRQyxJQUFJLHNCQUFzQjRKLFFBQVFnRjtBQUMzQztJQUNEMU8sT0FBTzBWLE9BQU9lLGtCQUFrQjhiLGFBQWFqYixXQUFXNU47SUFDeERrcEIscUJBQStCbHBCO0FBQ2pDOztBQUdBeEosWUFBWTJ5QixxQkFBcUIxeUIsZUFBZ0J5cEI7SUFDL0MsSUFBSWtKLGNBQWNqeEIsU0FBUytuQjtJQUMzQi9wQixRQUFRQyxJQUFJLEdBQUdrRyx1Q0FBdUNqRyxNQUFNNEosS0FBSytHLDhCQUE4Qm9pQjtJQUMvRixJQUFJcHBCLFVBQVUxSixPQUFPMkosS0FBSzhHLGtCQUFrQjFRLE1BQU00SixLQUFLK0c7SUFDdkRxaUIsbUJBQTZCcnBCO0lBQzdCLElBQUkyRyxXQUFXMmlCLGtCQUFrQnRwQjtJQUNqQzdKLFFBQVFDLElBQUksR0FBR2tHLG9DQUFvQ3FLO0lBQ25ELEtBQUk0aUIsVUFBQ0EsVUFBUTdyQixZQUFFQSxjQUFjOHJCLGdCQUFnQnhwQjtJQUM3QyxNQUFNeXBCLFlBQVk7UUFDaEJoeUIsUUFBUXdOLFdBQWtCeE47UUFDMUJDLFdBQVd1TixXQUFrQnZOO1FBQzdCOUcsSUFBSW9QLFFBQVFvQjtRQUNaMFksUUFBUTlaLFFBQVErQztRQUNoQjJtQiwwQkFBMEIvaUI7UUFDMUI0aUIsVUFBVUE7UUFDVjdyQixZQUFZQTtRQUNaNlAsV0FBVzZiOztJQUVianpCLFFBQVFDLElBQUksR0FBR2tHLHVDQUF1Q3hGLEtBQUtuRyxVQUFVODRCO0lBQ3JFRSxZQUFtQjtJQUNuQixNQUFNendCLGFBQWEwd0IsZ0JBQWdCLHFDQUFxQ0gsV0FBVyxHQUFHLEdBQUc7UUFBRSxnQkFBZ0I7O0lBQzNHRSxZQUFtQjtJQUNuQixJQUFJendCLFFBQVEsTUFBTTtRQUNoQixJQUFJbVgsWUFBWSxHQUFHblgsS0FBSzRnQixVQUFVempCLE1BQU00SixLQUFLNUg7UUFDN0MsSUFBSVAsTUFBTSxzSUFBc0l1WSxxQkFBcUJuWCxLQUFLcVgsb0JBQW9CclgsS0FBS3NYLHdCQUF3QnhRLFFBQVFnRix1QkFBdUJoRixRQUFRa0Y7UUFDbFFxTSxRQUFlelo7UUFDZnhCLE9BQU8wVixPQUFPNkM7UUFFZHhZLE1BQU00SixLQUFLZ2lCLGdCQUFnQjtBQUM1QjtBQUNIOztBQUdBeHJCLGVBQWVtekIsZ0JBQWdCbnhCLE1BQU1DLFNBQVMsSUFBSUMsU0FBUyxHQUFHQyxXQUFXLEdBQUdDLFNBQVM7SUFDbkYxQyxRQUFRQyxJQUFJLGtCQUFrQnFDLGdCQUFnQjNCLEtBQUtuRyxVQUFVK0g7SUFFN0RHLE9BQU8sbUJBQW1Cb00sV0FBa0JyTjtJQUU1QyxNQUFNTSxRQUFRO1FBQ1pPO1FBQ0FFO1FBQ0FDO1FBQ0FDO1FBQ0FIOztJQUVGO1FBQ0UsSUFBSUksdUJBQXVCL0IsV0FBV2dDLFFBQVFqQyxLQUFLbkcsVUFBVXVIO1FBRTdELElBQUljLFdBQVdsQyxLQUFLeEgsTUFBTXdKO1FBQzFCLEtBQUlHLE1BQUVBLE1BQUlDLE1BQUVBLFFBQVNGO1FBQ3JCLElBQUlDLFFBQVEsT0FBT0QsU0FBU0csVUFBVSxNQUFNO1lBQzFDaEQsUUFBUUMsSUFBSSxtQkFBbUJxQztZQUMvQixPQUFPUztBQUNiLGVBQVcsSUFBSUQsUUFBUSxPQUFPO1lBRXhCM0MsT0FBT3V6QixVQUFVQztBQUN2QixlQUFXLElBQUk3d0IsUUFBUSxPQUFPO1lBRXhCLElBQUkrRyxVQUFVMUosT0FBTzJKLEtBQUs4RyxrQkFBa0IxUSxNQUFNNEosS0FBSytHO1lBQ3ZEMVEsT0FBT3V6QixVQUFVRSxtQkFBbUIvcEIsUUFBUWlmLHdCQUF3QmpmLFFBQVFpZix3QkFBd0I7QUFDMUcsZUFBVztZQUNMOW9CLFFBQVFDLElBQUksZ0NBQWdDNkM7WUFDNUMsSUFBSVcsVUFBVVosU0FBU1k7WUFDdkIsSUFBSWpCLFVBQVUsS0FBS2lCLFNBQVM7Z0JBQzFCb3dCLFVBQWlCcHdCO0FBQ2xCO1lBQ0QsT0FBTztBQUNSO0FBQ0YsTUFBQyxPQUFPeks7UUFDUGdILFFBQVFDLElBQUksZ0NBQWdDakg7UUFDNUMsT0FBTztBQUNSO0FBQ0g7O0FBRUFxSCxZQUFZOFUsaUJBQWlCQTs7QUFFN0IsTUFBTWhQLE1BQU07O0FBQ1osU0FBU3dzQiw0QkFBNEI5b0I7SUFDbkMsSUFBSTROLFlBQVk7SUFDaEIsSUFBSTdLLFlBQVlELFdBQVc5QyxRQUFRK0M7SUFDbkMsSUFBSW1DLFVBQVVsRixRQUFRa0Y7SUFDdEIvTyxRQUFRQyxJQUFJLEdBQUdrRyw0Q0FBNEM0STtJQUMzRCxJQUFJQSxXQUFXLEdBQUc7UUFFaEIsSUFBSXdRLGFBQWExVixRQUFRMFY7UUFDekJ2ZixRQUFRQyxJQUFJLEdBQUdrRywrQ0FBK0N4RixLQUFLbkcsVUFBVStrQjtRQUM3RSxJQUFJM1csT0FBTyxDQUFBO1FBQ1gyVyxXQUFXa1AsU0FBU2hRO1lBQ2xCLElBQUlBLE9BQU96VyxRQUFRLEdBQUc7Z0JBQ3BCO0FBQ0Q7WUFDRFksT0FBTztnQkFBRVosTUFBTTs7WUFRZixJQUFJMmIsU0FBUztZQUNiLElBQUkvVyxhQUFhNlIsT0FBT0osYUFBYTtnQkFDbkMsSUFBSUksT0FBT0wsYUFBYSxHQUFHO29CQUN6QnVGLFNBQVMvVyxZQUFZNlIsT0FBT0o7QUFDdEMsdUJBQWUsSUFBSXpSLGFBQWE2UixPQUFPTCxXQUFXO29CQUN4Q3VGLFNBQVNsRixPQUFPTCxZQUFZSyxPQUFPSjtBQUM3Qyx1QkFBZTtvQkFDTHNGLFNBQVMvVyxZQUFZNlIsT0FBT0o7QUFDN0I7QUFDVCxtQkFBYTtnQkFDTHNGLFNBQVM7QUFDVjtZQUNEM2pCLFFBQVFDLElBQUksR0FBR2tHLHNEQUFzRHdkO1lBQ3JFLElBQUlBLFNBQVMsR0FBRztnQkFDZC9hLEtBQUsrYSxTQUFTLEdBQUdBLFVBQVV6akIsTUFBTTRKLEtBQUs1SDtnQkFDdEMwRyxLQUFLc1YsT0FBTyxPQUFPL1YsZ0JBQXVCQyxTQUFnQnFXLE9BQU9QLE1BQU0sTUFBTTtnQkFDN0VsZSxRQUFRQyxJQUFJLEdBQUdrRyxvREFBb0R4RixLQUFLbkcsVUFBVW9PO2dCQUNsRjZPLFVBQVU3YyxLQUFLZ087QUFDaEI7O0FBRVAsV0FBUyxJQUFJbUcsV0FBVyxHQUFHO1FBRXZCLElBQUl3WSxhQUFhMWQsUUFBUTBkO1FBQ3pCdm5CLFFBQVFDLElBQUksR0FBR2tHLCtDQUErQ3hGLEtBQUtuRyxVQUFVK3NCO1FBQzdFLElBQUkzZSxPQUFPLENBQUE7UUFDWDJlLFdBQVdrSCxTQUFReGM7WUFDakIsSUFBSUEsT0FBT2pLLFFBQVEsR0FBRztnQkFDcEI7QUFDRDtZQUNEWSxPQUFPO2dCQUFFWixNQUFNOztZQUNmLElBQUlpSyxPQUFPOFksV0FBVyxXQUFXO2dCQUMvQm5pQixLQUFLc1YsT0FBTzVWLE1BQU1DLFdBQVd1ckIsdUJBQXVCLEdBQUc3aEIsT0FBT2lNO0FBQ3RFLG1CQUFhO2dCQUNMdFYsS0FBS3NWLE9BQU8sT0FBT2pNLE9BQU9pTTtBQUMzQjtZQUNEdFYsS0FBSythLFNBQVMxUixPQUFPbEw7WUFDckIvRyxRQUFRQyxJQUFJLEdBQUdrRyxvREFBb0R4RixLQUFLbkcsVUFBVW9PO1lBQ2xGNk8sVUFBVTdjLEtBQUtnTzs7QUFFckIsV0FBUztRQUNMNUksUUFBUUMsSUFBSSxHQUFHa0cseUNBQXlDNEk7QUFDekQ7SUFFRCxJQUFJeEYsY0FBY00sUUFBUUcsZUFBZVQ7SUFDekN2SixRQUFRQyxJQUFJLEdBQUdrRyw4Q0FBOEN5RywwQkFBMEJyRDtJQUN2RixJQUFJQSxlQUFlckQsYUFBYXFELGdCQUFnQixHQUFHO1FBQ2pELElBQUlWLGFBQWFnQixRQUFRRyxlQUFlaEI7UUFDeEMsSUFBSStxQixhQUFhbHJCLFdBQVdVO1FBQzVCdkosUUFBUUMsSUFDTixHQUFHa0csdUJBQXVCNHRCLFdBQVc5c0IsbUJBQW1COHNCLFdBQVcvc0IsaUJBQWlCK3NCLFdBQVc1c0I7UUFHakcsSUFBSXlGLGFBQWFtbkIsV0FBVzlzQixpQkFBaUI7WUFDM0MsSUFBSStzQixZQUFZdDJCLEtBQUtnUCxJQUFJcW5CLFdBQVcvc0IsZUFBZTRGO1lBQ25ELElBQUlqRCxXQUFXO1lBQ2YsT0FBT3FxQixZQUFZLEtBQUtycUIsV0FBVzhOLFVBQVV6ZCxRQUFRO2dCQUNuRCxJQUFJNE8sT0FBTztvQkFBRVosTUFBTTs7Z0JBRW5CLElBQUlpc0IsWUFBWUMsY0FBY3pjLFVBQVU5TixVQUFVZ2EsUUFBUTtnQkFDMUQsSUFBSXFRLFlBQVlDLFdBQVc7b0JBQ3pCcnJCLEtBQUsrYSxTQUFTLEdBQUdqUixpQkFBd0J2SyxnQkFBdUI4ckIsV0FBVyxPQUFPL3pCLE1BQU00SixLQUFLNUg7b0JBQzdGOHhCLGFBQWFDO0FBQ3ZCLHVCQUFlO29CQUNMcnJCLEtBQUsrYSxTQUFTLEdBQUdqUixpQkFBd0J2SyxnQkFBdUI2ckIsV0FBVyxPQUFPOXpCLE1BQU00SixLQUFLNUg7b0JBQzdGOHhCLGFBQWFBO0FBQ2Q7Z0JBQ0RwckIsS0FBS3NWLE9BQU8vVCxtQkFDVjdCLE1BQU1DLFdBQVc0ckIsNkJBQ2YsR0FBR0osV0FBVzNzQixjQUNkLEdBQUdlLGdCQUF1QkMsU0FBZ0IyckIsV0FBVzVzQixLQUFLLE1BQU07Z0JBR3BFbkgsUUFBUUMsSUFBSSxHQUFHa0csV0FBV3hGLEtBQUtuRyxVQUFVb087Z0JBQ3pDNk8sVUFBVTJjLE9BQU96cUIsV0FBVyxHQUFHLEdBQUdmO2dCQUNsQ2UsWUFBWTtBQUNiO0FBQ0Y7QUFDRjtJQUNEM0osUUFBUUMsSUFBSSxHQUFHa0csOENBQThDeEYsS0FBS25HLFVBQVVpZDtJQUM1RSxPQUFPQTtBQUNUOztBQUVBLFNBQVNvYix5QkFBeUJocEI7SUFDaEMsSUFBSTROLFlBQVk7SUFDaEIsSUFBSTdLLFlBQVlELFdBQVc5QyxRQUFRK0M7SUFDbkMsSUFBSXJELGNBQWNNLFFBQVFHLGVBQWVUO0lBQ3pDdkosUUFBUUMsSUFBSSxHQUFHa0csMkNBQTJDeUcsMEJBQTBCckQ7SUFDcEYsSUFBSVgsT0FBTztRQUFFWixNQUFNOztJQUNuQlksS0FBSythLFNBQVMsR0FBR2pSLGlCQUF3QnZLLGdCQUF1QnlFLFdBQVcsT0FBTzFNLE1BQU00SixLQUFLNUg7SUFDN0YwRyxLQUFLc1YsT0FBTyxPQUFPL1YsZ0JBQXVCQyxTQUFnQnlCLFFBQVF3cUIsVUFBVSxNQUFNO0lBQ2xGcjBCLFFBQVFDLElBQUksR0FBR2tHLHVDQUF1Q3hGLEtBQUtuRyxVQUFVb087SUFDckU2TyxVQUFVN2MsS0FBS2dPO0lBRWYsSUFBSVcsZUFBZXJELGFBQWFxRCxnQkFBZ0IsR0FBRztRQUNqRCxJQUFJVixhQUFhZ0IsUUFBUUcsZUFBZWhCO1FBQ3hDLElBQUkrcUIsYUFBYWxyQixXQUFXVTtRQUM1QnZKLFFBQVFDLElBQUksR0FBR2tHLDRDQUE0QzR0QixXQUFXL3NCLGlCQUFpQitzQixXQUFXNXNCO1FBRWxHLElBQUl5RixhQUFhbW5CLFdBQVc5c0IsaUJBQWlCO1lBQzNDMkIsT0FBTztnQkFBRVosTUFBTTs7WUFDZixJQUFJZ3NCLFlBQVl0MkIsS0FBS2dQLElBQUlxbkIsV0FBVy9zQixlQUFlNEY7WUFDbkRoRSxLQUFLK2EsU0FBUyxHQUFHalIsaUJBQXdCdkssZ0JBQXVCNnJCLFdBQVcsT0FBTzl6QixNQUFNNEosS0FBSzVIO1lBQzdGMEcsS0FBS3NWLE9BQU8vVCxtQkFDVjdCLE1BQU1DLFdBQVc0ckIsNkJBQ2YsR0FBR0osV0FBVzNzQixjQUNkLEdBQUdlLGdCQUF1QkMsU0FBZ0IyckIsV0FBVzVzQixLQUFLLE1BQU07WUFHcEVuSCxRQUFRQyxJQUFJLEdBQUdrRyxzQ0FBc0N4RixLQUFLbkcsVUFBVW9PO1lBQ3BFNk8sVUFBVTJjLE9BQU8sR0FBRyxHQUFHeHJCO0FBQ3hCO0FBQ0Y7SUFDRCxPQUFPNk87QUFDVDs7QUFFQSxTQUFTbWIsdUJBQXVCbmIsV0FBVzdLO0lBQ3pDLElBQUl6RixNQUFNbXRCLG9CQUFvQjdjLFdBQVc3SztJQUN6QyxJQUFJOGxCLGNBQWMsRUFFaEI7UUFBRTFxQixNQUFNO1FBQVVqQixPQUFPdUIsTUFBTWlzQjtRQUFxQmgyQixPQUFPK0osTUFBTWtzQjtPQUNqRTtRQUFFeHNCLE1BQU07UUFBVWpCLE9BQU91QixNQUFNbXNCO1FBQTZCbDJCLE9BQU8sR0FBRzRJOztJQUV4RSxPQUFPdXJCO0FBQ1Q7O0FBRUEsU0FBU0ksb0JBQW9CcmIsV0FBVzdLLFdBQVcvQztJQUNqRCxJQUFJMUMsTUFBTW10QixvQkFBb0I3YyxXQUFXN0s7SUFDekMsTUFBTThuQixhQUFhcHNCLE1BQU1DLFdBQVdvc0IseUJBQXlCLEdBQUc5cUIsUUFBUStFLFFBQVEsR0FBRy9FLFFBQVF1SjtJQUMzRixJQUFJc2YsY0FBYyxFQUVoQjtRQUFFMXFCLE1BQU07UUFBVWpCLE9BQU91QixNQUFNc3NCO1FBQW1CcjJCLE9BQU9tMkI7T0FDekQ7UUFBRTFzQixNQUFNO1FBQVVqQixPQUFPdUIsTUFBTWlzQjtRQUFxQmgyQixPQUFPK0osTUFBTXVzQjtPQUVqRTtRQUFFN3NCLE1BQU07UUFBVWpCLE9BQU91QixNQUFNbXNCO1FBQTZCbDJCLE9BQU8sR0FBRzRJOztJQUV4RSxPQUFPdXJCO0FBQ1Q7O0FBS0EsU0FBUzRCLG9CQUFvQjdjLFdBQVc3SztJQUV0QyxJQUFJa29CLG1CQUFtQjtJQUN2QixJQUFJcmQsVUFBVXpkLFVBQVUsR0FBRztRQUN6QixJQUFJKzZCLFVBQVVDLGVBQWV2ZCxVQUFVLEdBQUd5RyxNQUFNO1FBQ2hELElBQUkrVyxhQUFhLEdBQUc5c0IsZ0JBQXVCQyxTQUFnQjJzQixTQUFTLE1BQU07UUFDMUUvMEIsUUFBUUMsSUFBSSxHQUFHa0csdUNBQXVDOHVCO1FBQ3RESCxtQkFBbUJHO1FBQ25CLE9BQU9IO0FBQ1I7SUFDRHJkLFVBQVVnWCxTQUFRN2xCO1FBRWhCLElBQUk1QyxNQUFNa3VCLGNBQWN0ckIsS0FBSythLFFBQVEsU0FBU3FSLGVBQWVwc0IsS0FBS3NWLE1BQU07UUFDeEVsZSxRQUFRQyxJQUFJLEdBQUdrRyxnQ0FBZ0NIO1FBRS9DOHVCLG9CQUFvQjl1Qjs7SUFFdEIsSUFBSW1CLE1BQU0ydEIsbUJBQW1Cbm9CLFdBQVdDO0lBQ3hDNU0sUUFBUUMsSUFBSSxHQUFHa0csZ0NBQWdDZ0I7SUFDL0MsT0FBTyxHQUFHZ0IsZ0JBQXVCQyxTQUFnQmpCLEtBQUssTUFBTTtBQUM5RDs7QUFFQSxTQUFTK3NCLGNBQWNsMUIsS0FBS2syQjtJQUMxQixJQUFJbHZCLE1BQU0yRyxXQUFXM04sSUFBSW0yQixNQUFNLFVBQVU7SUFDekMsSUFBSUQsYUFBYSxNQUFNO1FBQ3JCbHZCLE1BQU1BLE1BQU07QUFDYjtJQUNEaEcsUUFBUUMsSUFBSSxHQUFHa0csMkJBQTJCSDtJQUMxQyxPQUFPQTtBQUNUOztBQUVBLFNBQVNndkIsZUFBZWgyQixLQUFLazJCO0lBQzNCLElBQUlsdkIsTUFBTTJHLFdBQVczTixJQUFJbTJCLE1BQU0sa0JBQWtCO0lBQ2pELElBQUlELGFBQWEsTUFBTTtRQUNyQmx2QixNQUFNQSxNQUFNO0FBQ2I7SUFDRGhHLFFBQVFDLElBQUksR0FBR2tHLDJCQUEyQkg7SUFDMUMsT0FBT0E7QUFDVDs7QUFLQSxTQUFTbXRCLGtCQUFrQnRwQjtJQUN6QixJQUFJQSxRQUFRZ0YsZUFBZSxHQUFHO1FBQzVCLE9BQU9oRixRQUFRMkc7QUFDbkIsV0FBUztRQUNMLE9BQU87QUFDUjtBQUNIOztBQUVBLFNBQVM2aUIsZ0JBQWdCeHBCO0lBQ3ZCLElBQUk5RSxTQUFTO1FBQUVxdUIsVUFBVTtRQUFJN3JCLFlBQVk7O0lBQ3pDLElBQUlzQyxRQUFRZ0YsZUFBZSxLQUFLaEYsUUFBUWdGLGVBQWUsR0FBRztRQUN4RCxJQUFJN0UsaUJBQWlCSCxRQUFRRztRQUM3QixJQUFJdkMsUUFBUXVDLGVBQWVUO1FBQzNCLElBQUk5QixTQUFTLEdBQUc7WUFDZCxJQUFJbUIsT0FBT29CLGVBQWVoQixNQUFNdkI7WUFDaEN6SCxRQUFRQyxJQUFJLEdBQUdrRyw2QkFBNkJ5QyxLQUFLbk8sTUFBTW1PLEtBQUtyQix5QkFBeUJzQyxRQUFRK0MsOEJBQThCaEUsS0FBSzNCO1lBRWhJLElBQUk0QyxRQUFRK0MsYUFBYWhFLEtBQUszQixpQkFBaUI7Z0JBQzdDbEMsT0FBT3F1QixXQUFXeHFCLEtBQUtuTztnQkFDdkJzSyxPQUFPd0MsYUFBYXFCLEtBQUtyQjtBQUMxQjtBQUNGO0FBQ0Y7SUFDRHZILFFBQVFDLElBQUksR0FBR2tHLCtCQUErQnhGLEtBQUtuRyxVQUFVdUs7SUFDN0QsT0FBT0E7QUFDVDs7QUM3WUE3RSxNQUFNd3pCLFlBQVk7SUFDaEI3dkIsUUFBUTtJQUNSd1osVUFBVS9VLE1BQU0yVTtJQUNoQkssWUFBWWhWLE1BQU04c0I7OztBQUdwQmoxQixPQUFPdXpCLFlBQVk7SUFDakJDLHFCQUFxQjtRQUNuQnp6QixNQUFNd3pCLFVBQVVwVyxhQUFhaFYsTUFBTThzQjtRQUNuQ2wxQixNQUFNd3pCLFVBQVU3dkIsU0FBUztBQUMxQjtJQUVEK3ZCLG9CQUFvQixTQUFVeUIsUUFBUTtRQUNwQ24xQixNQUFNd3pCLFVBQVVwVyxhQUFhaFYsTUFBTUMsV0FBVytzQix3QkFBd0JEO1FBQ3RFbjFCLE1BQU13ekIsVUFBVTd2QixTQUFTO0FBQzFCO0lBRURpSCxhQUFhO1FBQ1g1SyxNQUFNd3pCLFVBQVU3dkIsU0FBUztBQUMxQjtJQUVEMHhCLGFBQWE7UUFDWHIxQixNQUFNd3pCLFVBQVU3dkIsU0FBUztRQUN6QjFELE9BQU8wVixPQUFPNkM7UUFDZDBDLFFBQWU7QUFDaEI7OztBQ1RILFNBQVNvYSxpQkFBaUJ6ekI7SUFDeEIwekIsZ0JBQXVCMXpCO0FBQ3pCOztBQUVBNUIsT0FBT3ExQixtQkFBbUJBIn0=
