function generateParams(path, params = {}, method = 0, hostType = 0, header = "") {
    const param = {
        path: path,
        method: method,
        hostType: hostType,
        header: header,
        params: params
    };
    console.log("generateParams:%o", param);
    return JSON.stringify(param);
}

function isEmptyString(string) {
    if (!string || string == null || string.length == 0) {
        return true;
    }
    return false;
}

function showLoading(show) {}

const rersonalCenter = "holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/content/personalCenter?";

const welcomeData = {
    type: "welcome",
    desc: "",
    uid: "",
    nickName: "",
    refreshStatus: "0",
    richText: "",
    funcShow: "visible"
};

const kycAuthDic = {
    img: "",
    title: "",
    url: "",
    visible: "gone",
    imgVisible: "gone",
    redDotVisible: "gone",
    textColor: "",
    backColor: ""
};

$data.userAuth = {
    prime: kycAuthDic,
    dmc: kycAuthDic,
    kyc: kycAuthDic
};

$data.uidUnique = {};

$data.headSection = [];

let currentAccount = "";

$data.kycWidth = (375 - 48) / 2;

$event.ucHeader = {
    clearData() {
        $data.userAuth.prime.visible = "gone";
        $data.userAuth.dmc.visible = "gone";
        $data.userAuth.kyc.visible = "gone";
        $data.userAuth.kyc.redDotVisible = "gone";
        $data.kycWidth = (375 - 48) / 2;
        console.log(`[account js]clear data`);
    },
    showWelcome(nativeData, title = "", highlight = "") {
        var headerData = welcomeData;
        if (isEmptyString(nativeData.account)) {
            headerData.type = "welcome";
            headerData.desc = title;
            const color = nativeData.nightMode ? "#8C8C93" : "#565656";
            if (isEmptyString(highlight)) {
                headerData.richText = `<span style="color:${color};font-size:12px;">${title}</span>`;
            } else {
                const spanStart = `<span style="color:${color}; font-size:12px;">`;
                const spanEnd = "</span>";
                var richHighlight = `${spanEnd}<span style="color:#FE8731; font-size:12px;"> ${highlight} </span>${spanStart}`;
                const joinText = title.split(highlight).join(richHighlight);
                headerData.richText = `${spanStart}${joinText}${spanEnd}`;
            }
            console.log(`html text: ${headerData.richText}`);
        } else {
            headerData.type = "unlogin";
            headerData.desc = `${$i18n.n_login_last_3rd_login_hint} ${nativeData.account}`;
        }
        $data.headSection = [ headerData ];
    },
    showLogin(nativeData, prime) {
        var headerData = welcomeData;
        headerData.type = "login";
        headerData.uid = `UID: ${nativeData.uid}`;
        headerData.nickName = nativeData.nickName;
        headerData.refreshStatus = "1";
        headerData.funcShow = nativeData.childAccount ? "gone" : "visible";
        currentAccount = nativeData.account;
        $data.headSection = [ headerData ];
        handlePrimeData(nativeData, prime);
    },
    openLogin(jumpType = 1) {
        $event.uc.openRoute(`holigeit://open/v1?url=ihuobiglobal://m.hbg.com/login/index?jumpType=${jumpType}`);
    },
    async openPrersonalCenter(uid) {
        const uidUnique = $data.uidUnique[uid];
        if (!isEmptyString(uidUnique)) {
            $event.uc.openRoute(`${rersonalCenter}account=${currentAccount}&uidUnique=${uidUnique}`);
            return;
        }
        const requestParams = generateParams("v1/content/community/user/content-info", {});
        try {
            const responseString = await $nativeAPI.request(requestParams);
            const {code: code, data: data} = JSON.parse(responseString);
            showLoading(0);
            if (code == 200) {
                $data.uidUnique[uid] = data.uidUnique;
                const openUrl = `${rersonalCenter}account=${currentAccount}&uidUnique=${data.uidUnique}`;
                $event.uc.openRoute(openUrl);
            } else {
                console.log(`content-info request error code:${code}`);
            }
        } catch (e) {
            $data.uc.refresh = "2";
            console.log(`content-info request error:${e}`);
        }
    },
    async requestKycAuthInfo(nativeData) {
        if (nativeData.childAccount) {
            $data.userAuth.dmc.visible = "gone";
            $data.userAuth.kyc.visible = "gone";
            $data.userAuth.kyc.redDotVisible = "gone";
            return;
        }
        const isInstUser = await requestInstInfo();
        requestKycAuthInfoV2(nativeData, isInstUser);
    }
};

async function requestKycAuthInfoV2(nativeData, isInstUser) {
    const requestParams = generateParams("v1/public/kyc/auth/info/get_v2", {}, 0, 3);
    try {
        const responseString = await $nativeAPI.request(requestParams);
        const response = JSON.parse(responseString);
        const {code: code, data: data} = response;
        if (code == 200) {
            hundleDmcData(data, nativeData);
            if (!isInstUser) {
                handleKycData(data, nativeData);
            }
            if ($data.userAuth.dmc.visible == "visible" && $data.userAuth.dmc.title == "DMC" && $data.userAuth.kyc.redDotVisible == "visible") {
                $data.userAuth.dmc.visible = "gone";
            }
            if ($data.userAuth.dmc.visible == "gone" || $data.userAuth.kyc.visible == "gone") {
                $data.kycWidth = (375 - 48) / 2;
            } else {
                $data.kycWidth = (375 - 56) / 3;
            }
        } else {
            console.log(`info/get_v2 request error code:${code}`);
        }
    } catch (e) {
        console.log(`info/get_v2 request error:${e}`);
    }
}

async function requestInstInfo() {
    const requestParams = generateParams("onboard/v1/hbg/open/inst/application/level_info/get", {}, 0, 2, {
        HBIgnoreFailureToast: "1"
    });
    try {
        const responseString = await $nativeAPI.request(requestParams);
        const response = JSON.parse(responseString);
        const {code: code, data: data} = response;
        if (code == 200) {
            if (data && data != null) {
                var instDic = kycAuthDic;
                instDic.textColor = "@color/kColorPrimaryText";
                instDic.imgVisible = "gone";
                instDic.url = "holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/account/institutionKyc";
                if (data.state == 1 || data.state == 3 || data.state == 4) {
                    if (data.state == 1) {
                        instDic.title = "n_kyc_organization_inreview";
                        instDic.img = "@drawable/account_kyc_verifiing";
                        instDic.imgVisible = "visible";
                    } else if (data.state == 3) {
                        if (data.levelType == 1) {
                            instDic.title = "n_kyc_auth_inst_lv1";
                        } else if (data.levelType == 2) {
                            instDic.title = "n_kyc_auth_inst_lv2";
                        } else {
                            instDic.title = "n_kyc_organization_authed";
                        }
                    } else {
                        instDic.title = "n_kyc_organization_auth_failed";
                        instDic.textColor = "@color/kColorPriceRed";
                    }
                    $data.userAuth.kyc = instDic;
                    return true;
                }
            }
            return false;
        } else {
            console.log(`inst request error code:${code}`);
            return false;
        }
    } catch (e) {
        console.log(`inst request error:${e}`);
        return false;
    }
}

function handlePrimeData(nativeData, prime) {
    console.log(`[account js]origin prime data: ${JSON.stringify($data.userAuth.prime.rawObject())}`);
    if (nativeData.childAccount || !prime || prime == null) {
        $data.userAuth.prime.visible = "gone";
        return;
    }
    var showPrime = {};
    if (prime.level < 2) {
        showPrime.backColor = nativeData.nightMode ? "#172736" : "#F4F8FC";
        showPrime.textColor = nativeData.nightMode ? "#8C8C93" : "#565656";
        showPrime.img = "@drawable/edge_engine_account_prime_1";
    } else if (prime.level < 5) {
        showPrime.backColor = nativeData.nightMode ? "#192925" : "#EFFAF6";
        showPrime.textColor = nativeData.nightMode ? "#00A171" : "#00A171";
        showPrime.img = "@drawable/edge_engine_account_prime_2";
    } else if (prime.level < 7) {
        showPrime.backColor = nativeData.nightMode ? "#2F2323" : "#FBF6F3";
        showPrime.textColor = nativeData.nightMode ? "#C68258" : "#C68258";
        showPrime.img = "@drawable/edge_engine_account_prime_3";
    } else if (prime.level < 10) {
        showPrime.backColor = nativeData.nightMode ? "#2A2419" : "#FCF9F4";
        showPrime.textColor = nativeData.nightMode ? "#F28301" : "#F28301";
        showPrime.img = "@drawable/edge_engine_account_prime_4";
    } else {
        showPrime.backColor = nativeData.nightMode ? "#2C2B1B" : "#FAFAF0";
        showPrime.textColor = nativeData.nightMode ? "#E6E6E6" : "#000000";
        showPrime.img = "@drawable/edge_engine_account_prime_5";
    }
    showPrime.url = prime.url;
    const userLevel = prime.level > 0 ? prime.level - 1 : 0;
    showPrime.title = `Prime ${userLevel}`;
    showPrime.visible = prime.level == null ? "gone" : "visible";
    $data.userAuth.prime = showPrime;
    console.log(`[account js]prime data: ${JSON.stringify(showPrime)}`);
}

function hundleDmcData(data, nativeData) {
    var dmcDic = kycAuthDic;
    if (isEmptyString(data.entranceName)) {
        dmcDic.visible = "gone";
    } else {
        dmcDic.title = data.entranceName;
        dmcDic.img = `${nativeData.flaghost}/p/api/contents/country/icon/${data.entranceCountryId}.png`;
        dmcDic.imgVisible = "visible";
        if (data.entranceUrl.startsWith("holigeit")) {
            dmcDic.url = data.entranceUrl;
        } else {
            dmcDic.url = `${nativeData.webhost}${data.entranceUrl}`;
        }
        dmcDic.visible = "visible";
    }
    $data.userAuth.dmc = dmcDic;
}

function handleKycData(data, nativeData) {
    if (data.finalAuthState != -1 && data.showOldEntrance && nativeData.pro_status != -1) {
        const authType = kycAuthType(data, nativeData.pro_status);
        var kycDic = kycAuthDic;
        kycDic.backColor = "@color/KBaseColorInputBackground";
        kycDic.textColor = "@color/kColorPrimaryText";
        kycDic.visible = "visible";
        kycDic.imgVisible = "gone";
        kycDic.redDotVisible = "gone";
        kycDic.url = "holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/account/kyc?authBizCode=SPOT&source=1";
        if (authType == 3 || authType == 4 || authType == 5) {
            kycDic.imgVisible = "visible";
            kycDic.img = `${nativeData.flaghost}/p/api/contents/country/icon/${data.baseInfo.countryId}.png`;
        }
        switch (authType) {
          case 5:
            kycDic.title = "L3";
            break;

          case 4:
            kycDic.title = "L2";
            break;

          case 3:
            kycDic.title = "L1";
            break;

          case 2:
            kycDic.title = `${$i18n.n_user_center_is_not_verify}`;
            kycDic.redDotVisible = "visible";
            kycDic.backColor = "@color/kColor1AFE8731";
            kycDic.textColor = "@color/color_FE8731";
            break;

          case 1:
            kycDic.title = `${$i18n.n_kyc_authentication_verifying}`;
            kycDic.img = "@drawable/account_kyc_verifiing";
            kycDic.imgVisible = "visible";
            break;

          case 0:
            kycDic.title = `${$i18n.n_user_center_is_not_verify}`;
            kycDic.redDotVisible = "visible";
            kycDic.backColor = "@color/kColor1AFE8731";
            kycDic.textColor = "@color/color_FE8731";
            break;

          case 6:
            kycDic.title = `${$i18n.n_kyc_authentication_fail}`;
            kycDic.textColor = "@color/kColorPriceRed";
            break;

          default:
            kycDic.title = `${$i18n.n_user_center_is_not_verify}`;
            kycDic.redDotVisible = "visible";
            kycDic.backColor = "@color/kColor1AFE8731";
            kycDic.textColor = "@color/color_FE8731";
            break;
        }
        $data.userAuth.kyc = kycDic;
    } else {
        $data.userAuth.kyc.visible = "gone";
        $data.userAuth.kyc.redDotVisible = "gone";
    }
}

function kycAuthType(authInfo, pro_status) {
    var stepModelDic = {};
    for (let index = 0; index < authInfo.stepStates.length; index++) {
        const element = authInfo.stepStates[index];
        stepModelDic[element.authStep.toUpperCase()] = element;
    }
    var authType = 0;
    const c0 = stepModelDic["C0"];
    const c1 = stepModelDic["C1"];
    const c2 = stepModelDic["C2"];
    if (c2 && c2.authState == 2) {
        authType = 5;
    } else if (c1 && c1.authState == 2) {
        authType = 4;
    } else if (c0 && c0.authState == 2) {
        authType = 3;
    } else if (pro_status == 2) {
        authType = 4;
    }
    if (authType == 0) {
        if (c0 && c0.authState == 1) {
            authType = 1;
        } else if (c0 && c0.authState == 3) {
            authType = 6;
        }
    }
    return authType;
}

var nativeData = {
    isLogin: 0,
    platform: 2,
    nightMode: 0,
    uid: "",
    nickName: "",
    account: "",
    hasNewVersion: false,
    language: "",
    flaghost: "",
    webhost: "",
    childAccount: false,
    pro_status: -1
};

const model = {
    name: "",
    title: "",
    url: "",
    img: "home_operation_placeholder",
    imgNight: "",
    type: "normal",
    visible: "gone",
    normalVisible: "gone",
    backColor: "#00A171",
    backVisible: "gone"
};

const ucData = {
    prime: {
        level: null,
        url: ""
    },
    features: [],
    featureVisibility: "gone",
    list: [],
    refresh: "2"
};

var clickable = true;

$data.uc = ucData;

$event.uc = {
    viewWillAppear(naticeJson) {
        console.log(`viewWillAppear:${naticeJson}`);
        clickable = true;
        const newNativeData = JSON.parse(naticeJson);
        if (nativeData.uid != newNativeData.uid || nativeData.language != newNativeData.language) {
            $data.uc = ucData;
            $event.ucHeader.clearData();
        }
        nativeData = newNativeData;
        if (nativeData.isLogin == 1) {
            $event.ucHeader.showLogin(nativeData, $data.uc.prime);
            $event.ucHeader.requestKycAuthInfo(nativeData);
            requestHomeLoginData();
        } else {
            $data.uc.features = [];
            $data.uc.featureVisibility = "gone";
            $event.ucHeader.showWelcome(nativeData, "", "");
            requestHomeNotLoginData();
        }
    },
    openRoute(routeUrl, jumpType = -999) {
        if (!clickable) {
            return;
        }
        console.log("[account js] open url:", routeUrl);
        if (!isEmptyString(routeUrl)) {
            $nativeAPI.openRoute(routeUrl);
        }
        if (jumpType > 0) {
            requestRemoveUserRedDot(jumpType);
        }
        clickable = false;
        setTimeout((() => {
            clickable = true;
        }), 1e3);
    },
    openPrime() {
        console.log(`[account js] open prime: ${$data.userAuth.prime.url}`);
        $event.uc.openRoute($data.userAuth.prime.url);
    },
    openDMC() {
        $event.uc.openRoute($data.userAuth.dmc.url);
    },
    openKYC() {
        $event.uc.openRoute($data.userAuth.kyc.url);
    },
    async copyUID() {
        try {
            await $nativeAPI.clipBoard(JSON.stringify({
                label: "",
                content: nativeData.uid,
                toast: $i18n.n_user_center_copy_pasteboard
            }));
        } catch (error) {
            console.log(`copy clipboard error:${error}`);
        }
    }
};

$event.onRefresh = function() {
    if (nativeData.isLogin) {
        requestHomeLoginData();
    } else {
        requestHomeNotLoginData();
    }
};

async function requestHomeNotLoginData() {
    const param = {
        platform: nativeData.platform,
        nightMode: nativeData.nightMode,
        moduleSize: 20
    };
    const requestParams = generateParams("v1/hbg/myhome/homeNotLogin", param);
    try {
        const responseString = await $nativeAPI.request(requestParams);
        const {code: code, data: data} = JSON.parse(responseString);
        showLoading(0);
        $data.uc.refresh = "2";
        if (code == 200) {
            handleUnLoginRes(data);
        } else {
            console.log(`homeNotLogin request error code:${code}`);
        }
    } catch (e) {
        $data.uc.refresh = "2";
        console.log(`homeNotLogin request error:${e}`);
    }
}

async function requestHomeLoginData() {
    const param = {
        platform: nativeData.platform,
        nightMode: nativeData.nightMode,
        moduleSize: 20
    };
    const requestParams = generateParams("v1/hbg/myhome/homeLogin", param);
    try {
        const responseString = await $nativeAPI.request(requestParams);
        const {code: code, data: data} = JSON.parse(responseString);
        showLoading(0);
        $data.uc.refresh = "2";
        if (code == 200) {
            handleLoginRes(data);
        } else {
            console.log(`homeLogin request error code:${code}`);
        }
    } catch (e) {
        $data.uc.refresh = "2";
        console.log(`homeLogin request error:${e}`);
    }
}

async function requestRemoveUserRedDot(jumpType) {
    const param = {
        type: jumpType
    };
    const requestParams = generateParams("v1/hbg/myhome/redDot/removeUserRedDot", param);
    try {
        const responseString = await $nativeAPI.request(requestParams);
        const {code: code} = JSON.parse(responseString);
        if (code !== 200) {
            console.log(`removeUserRedDot request error code:${code}`);
        }
    } catch (e) {
        console.log(`removeUserRedDot request error:${e}`);
    }
}

function handleUnLoginRes(data) {
    $event.ucHeader.showWelcome(nativeData, data.title, data.titleHighlight);
    var newData = [];
    handleCelllist(data.list, newData);
    $data.uc.list = newData;
    console.log("notlogindata:%o", $data.uc.rawObject());
}

function handleLoginRes(data) {
    $data.uc.prime = data.prime;
    $event.ucHeader.showLogin(nativeData, data.prime);
    $data.uc.list = handleloginData(data);
    console.log(`[account js] logindata: ${JSON.stringify($data.uc.rawObject())}`);
}

function handleloginData(loginData) {
    var cellData = [];
    var lineModel = {
        type: "divider"
    };
    var features = [];
    const listTwo = loginData.features;
    if (listTwo && listTwo.length > 0) {
        for (let i = 0; i < listTwo.length; i++) {
            let el = listTwo[i];
            if (nativeData.nightMode && !isEmptyString(el.imgNight)) {
                el.img = el.imgNight;
            }
            if (isEmptyString(el.img)) {
                el.img = "@drawable/home_operation_placeholder";
            }
            features[i] = el;
        }
        $data.uc.featureVisibility = "visible";
        $data.uc.features = features;
    } else {
        $data.uc.featureVisibility = "gone";
    }
    if (loginData.list) {
        for (let index = 0; index < loginData.list.length; index++) {
            const element = loginData.list[index];
            handleCelllist(element, cellData);
            if (index < loginData.list.length - 1) {
                cellData.push(lineModel);
            }
        }
    }
    return cellData;
}

function handleCelllist(listData, cellData) {
    for (let i = 0; i < listData.length; i++) {
        let el = listData[i];
        el.backVisible = model.backVisible;
        el.normalVisible = model.normalVisible;
        el.jumpType = `${el.type}`;
        el.type = model.type;
        if (el.redDotType && el.redDotType == 1 && el.redDotNum > 0) {
            el.showRedDot = "gone";
            el.numRedDot = "visible";
            el.redDotNumStr = `${el.redDotNum}`;
        } else if (el.isRedDot) {
            el.showRedDot = "visible";
            el.numRedDot = "gone";
        } else {
            el.showRedDot = "gone";
            el.numRedDot = "gone";
        }
        if (el.nameType == "我的邀请返佣") {
            if (!isEmptyString(el.title)) {
                el.backColor = model.backColor;
                el.backVisible = "visible";
            }
        } else if (el.nameType == "我的预约") {
            if (!isEmptyString(el.title)) {
                el.backColor = "#E94359";
                el.backVisible = "visible";
            }
        } else if (el.nameType == "关于火必" || el.nameType == "关于火币") {
            if (nativeData.hasNewVersion) {
                el.normalVisible = "visible";
                el.showRedDot = "visible";
                el.numRedDot = "gone";
                el.title = `${$i18n.n_user_center_discover_new_version}`;
            }
        } else if (el.nameType == "语言设置") {
            el.normalVisible = "visible";
            el.title = nativeData.language;
        } else if (!isEmptyString(el.title)) {
            el.normalVisible = "visible";
        }
        cellData.push(el);
    }
}

$data.postersharing = {
    avatar: "",
    name: "",
    articleNum: "0",
    praiseNum: "0"
};

$event.postersharing = {
    shareWithParams(paramsJson) {
        const params = JSON.parse(paramsJson);
        $data.postersharing.avatar = params.avatar;
        $data.postersharing.name = params.nickName;
        $data.postersharing.articleNum = params.articleNum;
        $data.postersharing.praiseNum = params.praiseNum;
        $nativeAPI.shareAbility({
            type: "renderSync",
            template: "postersharing",
            waitTime: 2,
            jumpUrl: params.shareUrl
        });
    }
};
//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoibWFpbi5qcyIsInNvdXJjZXMiOlsiLi4vLi4vcmVwb3NpdG9yeS9zcmMvdXRpbC5qcyIsIi4uLy4uL3JlcG9zaXRvcnkvc3JjL2hlYWQuanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy91c2VyQ2VudGVyLmpzIiwiLi4vLi4vcmVwb3NpdG9yeS9zcmMvcG9zdGVyU2hhcmluZy5qcyJdLCJzb3VyY2VzQ29udGVudCI6WyIvKipcbiAqIEBwYXJhbSB7U3RyaW5nfSBwYXRoIOi3r+W+hFxuICogQHBhcmFtIHtPYmplY3R0fSBwYXJhbXMg5Y+C5pWwXG4gKiBAcGFyYW0ge051bWJlcn0gbWV0aG9kIGdldO+8mjAgcG9zdO+8mjFcbiAqIEBwYXJhbSB7TnVtYmVyfSBob3N0VHlwZSB1cmxob3N0IDDvvJpoYmdcbiAqIEBwYXJhbSB7U3RyaW5nfSBoZWFkZXIgaGVhZGVyXG4gKiBAcmV0dXJucyB7T2JqZWN0fVxuICovXG5leHBvcnQgZnVuY3Rpb24gZ2VuZXJhdGVQYXJhbXMocGF0aCwgcGFyYW1zID0ge30sIG1ldGhvZCA9IDAsIGhvc3RUeXBlID0gMCwgaGVhZGVyID0gXCJcIikge1xuICAgIGNvbnN0IHBhcmFtID0ge1xuICAgICAgICBwYXRoLFxuICAgICAgICBtZXRob2QsXG4gICAgICAgIGhvc3RUeXBlLFxuICAgICAgICBoZWFkZXIsXG4gICAgICAgIHBhcmFtc1xuICAgIH07XG4gICAgY29uc29sZS5sb2coXCJnZW5lcmF0ZVBhcmFtczolb1wiLCBwYXJhbSk7XG4gICAgcmV0dXJuIEpTT04uc3RyaW5naWZ5KHBhcmFtKTtcbn1cblxuZXhwb3J0IGZ1bmN0aW9uIGlzRW1wdHlTdHJpbmcoc3RyaW5nKSB7XG4gICAgaWYgKCFzdHJpbmcgfHwgc3RyaW5nID09IG51bGwgfHwgc3RyaW5nLmxlbmd0aCA9PSAwKSB7XG4gICAgICAgIHJldHVybiB0cnVlO1xuICAgIH1cbiAgICByZXR1cm4gZmFsc2U7XG59XG5cbi8vIHNob3c6Me+8muaYvuekuu+8jDDvvJrpmpDol49cbmV4cG9ydCBmdW5jdGlvbiBzaG93TG9hZGluZyhzaG93KSB7XG4gICAgLy8gbW9jayBuYXRpdmVBUEkuaGJTaG93TG9hZGluZyhzaG93KTtcbn1cblxuZXhwb3J0IGZ1bmN0aW9uIHVubG9naW5Nb2NrKCkge1xuICAgIGNvbnN0IGRhdGEgPSBcIntcXFwiY29kZVxcXCI6MjAwLFxcXCJkYXRhXFxcIjp7XFxcInRpdGxlXFxcIjpcXFwi5rOo5YaM55m75b2V5pyA6auY5Y+v6I635b6XMeWkp+ekvOWMhVxcXCIsXFxcImxpc3RcXFwiOlt7XFxcIm5hbWVcXFwiOlxcXCLor63oqIBcXFwiLFxcXCJ0aXRsZVxcXCI6bnVsbCxcXFwidXJsXFxcIjpcXFwiJydcXFwiLFxcXCJpbWdcXFwiOm51bGwsXFxcImltZ05pZ2h0XFxcIjpudWxsLFxcXCJpc1JlZERvdFxcXCI6bnVsbH0se1xcXCJuYW1lXFxcIjpcXFwi5biu5Yqp5Lit5b+DXFxcIixcXFwidGl0bGVcXFwiOm51bGwsXFxcInVybFxcXCI6XFxcIicnXFxcIixcXFwiaW1nXFxcIjpudWxsLFxcXCJpbWdOaWdodFxcXCI6bnVsbCxcXFwiaXNSZWREb3RcXFwiOm51bGx9LHtcXFwibmFtZVxcXCI6XFxcIuWKoOWFpeekvue+pFxcXCIsXFxcInRpdGxlXFxcIjpudWxsLFxcXCJ1cmxcXFwiOlxcXCInJ1xcXCIsXFxcImltZ1xcXCI6bnVsbCxcXFwiaW1nTmlnaHRcXFwiOm51bGwsXFxcImlzUmVkRG90XFxcIjpudWxsfSx7XFxcIm5hbWVcXFwiOlxcXCLlhbPkuo7ngavlv4VcXFwiLFxcXCJ0aXRsZVxcXCI6bnVsbCxcXFwidXJsXFxcIjpcXFwiJydcXFwiLFxcXCJpbWdcXFwiOm51bGwsXFxcImltZ05pZ2h0XFxcIjpudWxsLFxcXCJpc1JlZERvdFxcXCI6bnVsbH1dfSxcXFwic3VjY2Vzc1xcXCI6dHJ1ZX1cIjtcbiAgICByZXR1cm4gSlNPTi5wYXJzZShkYXRhKS5kYXRhO1xufVxuXG5leHBvcnQgZnVuY3Rpb24gbG9naW5Nb2NrKCkge1xuICAgIGNvbnN0IGRhdGEgPSBcIntcXFwiY29kZVxcXCI6MjAwLFxcXCJkYXRhXFxcIjp7XFxcInByaW1lXFxcIjp7XFxcImxldmVsXFxcIjoxLFxcXCJ1cmxcXFwiOlxcXCJodHRwczovL3d3dy5odW9iaS5jb20udXovemgtY24vZXF1aXR5L2g1XFxcIn0sXFxcImZlYXR1cmVzXFxcIjpbe1xcXCJuYW1lXFxcIjpcXFwi5oiR55qE6K6i5Y2VXFxcIixcXFwidGl0bGVcXFwiOm51bGwsXFxcInVybFxcXCI6XFxcImhvbGlnZWl0Oi8vb3Blbi92MT9sb2dpbj0xJnVybD1paHVvYmlnbG9iYWw6Ly9tLmhiZy5jb20vYWNjb3VudC9vcmRlclxcXCIsXFxcImltZ1xcXCI6XFxcImh0dHBzOi8vaHVvYmktMTMwNjExNTY3OS5maWxlLm15cWNsb3VkLmNvbS9iaXQvYXBwRmVhdHVyZXMvY2UzNmQ3YWItNjc4ZS00MGMyLTg4ZmEtMGM0OGI3Nzc1M2VlLnBuZ1xcXCIsXFxcImltZ05pZ2h0XFxcIjpcXFwiaHR0cHM6Ly9odW9iaS0xMzA2MTE1Njc5LmZpbGUubXlxY2xvdWQuY29tL2JpdC9hcHBGZWF0dXJlcy80ZGM3YTI3MC01OTIxLTQzMGYtYWM4My0xYmFkNTdlNzc5NDIucG5nXFxcIixcXFwiaXNSZWREb3RcXFwiOm51bGx9LHtcXFwibmFtZVxcXCI6XFxcIuaIkeeahOebr+ebmFxcXCIsXFxcInRpdGxlXFxcIjpudWxsLFxcXCJ1cmxcXFwiOlxcXCJob2xpZ2VpdDovL29wZW4vdjE/dXJsPWlodW9iaWdsb2JhbDovL20uaGJnLmNvbS9tYXJrZXQvY29sbGVjdGlvbj9zZWNUYWI9c3BvdFxcXCIsXFxcImltZ1xcXCI6XFxcImh0dHBzOi8vaHVvYmktMTMwNjExNTY3OS5maWxlLm15cWNsb3VkLmNvbS9iaXQvYXBwRmVhdHVyZXMvYzAyNmU3MzYtZTc0My00MGNjLWFjOTctYWZkYWEyZTQwOTQ4LnBuZ1xcXCIsXFxcImltZ05pZ2h0XFxcIjpcXFwiaHR0cHM6Ly9odW9iaS0xMzA2MTE1Njc5LmZpbGUubXlxY2xvdWQuY29tL2JpdC9hcHBGZWF0dXJlcy8zYWNlMmMwYy1kZDY1LTQ1ZmEtYjdhNy1kZjY0ODk2OWE5NzQucG5nXFxcIixcXFwiaXNSZWREb3RcXFwiOm51bGx9LHtcXFwibmFtZVxcXCI6XFxcIuaIkeeahOemj+WIqVxcXCIsXFxcInRpdGxlXFxcIjpudWxsLFxcXCJ1cmxcXFwiOlxcXCJodHRwczovL3d3dy5odW9iaS5jb20udXovemgtY24vd2VsZmFyZS9wYWNrYWdlL1xcXCIsXFxcImltZ1xcXCI6XFxcImh0dHBzOi8vaHVvYmktMTMwNjExNTY3OS5maWxlLm15cWNsb3VkLmNvbS9iaXQvYXBwRmVhdHVyZXMvNmU5MzdjMTMtZWE4ZC00MWRkLThlOWEtOTA5NWEwZmJjZTMyLnBuZ1xcXCIsXFxcImltZ05pZ2h0XFxcIjpcXFwiaHR0cHM6Ly9odW9iaS0xMzA2MTE1Njc5LmZpbGUubXlxY2xvdWQuY29tL2JpdC9hcHBGZWF0dXJlcy9mMjY4NGY4OS0zZDBmLTRlMTUtYWM0Ni04ZDk5Y2NmYWI1ZTgucG5nXFxcIixcXFwiaXNSZWREb3RcXFwiOm51bGx9LHtcXFwibmFtZVxcXCI6XFxcIuaIkeeahOi0ueeOh1xcXCIsXFxcInRpdGxlXFxcIjpudWxsLFxcXCJ1cmxcXFwiOlxcXCJodHRwczovL3d3dy5odW9iaS5jb20udXovemgtY24vZmVlL25ldy1oNS9cXFwiLFxcXCJpbWdcXFwiOlxcXCJodHRwczovL2h1b2JpLTEzMDYxMTU2NzkuZmlsZS5teXFjbG91ZC5jb20vYml0L2FwcEZlYXR1cmVzLzE2ZmZmMDYxLTAwMDctNDQyMi04MTRhLTVkODM3OGVmNGMzOS5wbmdcXFwiLFxcXCJpbWdOaWdodFxcXCI6XFxcImh0dHBzOi8vaHVvYmktMTMwNjExNTY3OS5maWxlLm15cWNsb3VkLmNvbS9iaXQvYXBwRmVhdHVyZXMvYmU2YjE3MDQtMzgxNi00YWQ0LTg1YjMtYTE0NDA2MmU5MTUwLnBuZ1xcXCIsXFxcImlzUmVkRG90XFxcIjpudWxsfV0sXFxcImxpc3RcXFwiOltbe1xcXCJuYW1lXFxcIjpcXFwiTXlTdWJzY3JpcHRpb25zXFxcIixcXFwidGl0bGVcXFwiOlxcXCLljbPlsIblvIDlp4tcXFwiLFxcXCJ1cmxcXFwiOlxcXCJob2xpZ2VpdDovL29wZW4vdjE/bG9naW49MSZ1cmw9aWh1b2JpZ2xvYmFsOi8vbS5oYmcuY29tL2FjY291bnQvbXlTdWJzY3JpYmVzXFxcIixcXFwiaW1nXFxcIjpudWxsLFxcXCJpbWdOaWdodFxcXCI6bnVsbCxcXFwibmFtZVR5cGVcXFwiOlxcXCLmiJHnmoTpooTnuqZcXFwifSx7XFxcIm5hbWVcXFwiOlxcXCJBY2NvdW50TWFuYWdlclxcXCIsXFxcInRpdGxlXFxcIjpudWxsLFxcXCJ1cmxcXFwiOm51bGwsXFxcImltZ1xcXCI6bnVsbCxcXFwiaW1nTmlnaHRcXFwiOm51bGwsXFxcImlzUmVkRG90XFxcIjpudWxsfSx7XFxcIm5hbWVcXFwiOlxcXCLmiJHnmoTpgoDor7fov5TkvaNcXFwiLFxcXCJ0aXRsZVxcXCI6XFxcIiswLjM0VVxcXCIsXFxcInVybFxcXCI6bnVsbCxcXFwiaW1nXFxcIjpudWxsLFxcXCJpbWdOaWdodFxcXCI6bnVsbCxcXFwibmFtZVR5cGVcXFwiOlxcXCLmiJHnmoTpgoDor7fov5TkvaNcXFwifSx7XFxcIm5hbWVcXFwiOlxcXCLkuLvmkq3kuK3lv4NcXFwiLFxcXCJ0aXRsZVxcXCI6bnVsbCxcXFwidXJsXFxcIjpcXFwiaHR0cHM6Ly93d3cuaHVvYmkuY29tLnV6L3poLWNuL2xpdmUvYW5jaG9yXFxcIixcXFwiaW1nXFxcIjpudWxsLFxcXCJpbWdOaWdodFxcXCI6bnVsbCxcXFwiaXNSZWREb3RcXFwiOm51bGx9XSxbe1xcXCJuYW1lXFxcIjpcXFwi6K+t6KiA6K6+572uXFxcIixcXFwidGl0bGVcXFwiOm51bGwsXFxcInVybFxcXCI6XFxcImhvbGlnZWl0Oi8vb3Blbi92MT91cmw9aWh1b2JpZ2xvYmFsOi8vbS5oYmcuY29tL2FjY291bnQvbGFuZ3VhZ2VcXFwiLFxcXCJpbWdcXFwiOm51bGwsXFxcImltZ05pZ2h0XFxcIjpudWxsLFxcXCJuYW1lVHlwZVxcXCI6XFxcIuivreiogOiuvue9rlxcXCJ9LHtcXFwibmFtZVxcXCI6XFxcIuW4ruWKqeS4reW/g1xcXCIsXFxcInRpdGxlXFxcIjpudWxsLFxcXCJ1cmxcXFwiOlxcXCJodHRwczovL3d3dy5odW9iaS5jb20udXovYmF5bWF4Y2hhdC8jL2g1Lz9zY2VuZUNvZGU9MSZsYW5nPXpoLWNuXFxcIixcXFwiaW1nXFxcIjpudWxsLFxcXCJpbWdOaWdodFxcXCI6bnVsbCxcXFwiaXNSZWREb3RcXFwiOm51bGx9LHtcXFwibmFtZVxcXCI6XFxcIuWKoOWFpeekvue+pFxcXCIsXFxcInRpdGxlXFxcIjpudWxsLFxcXCJ1cmxcXFwiOlxcXCJob2xpZ2VpdDovL29wZW4vdjE/dXJsPWlodW9iaWdsb2JhbDovL20uaGJnLmNvbS9tYXJrZXQvY29udGVudD90eXBlPTVcXFwiLFxcXCJpbWdcXFwiOm51bGwsXFxcImltZ05pZ2h0XFxcIjpudWxsLFxcXCJpc1JlZERvdFxcXCI6bnVsbH0se1xcXCJuYW1lXFxcIjpcXFwi5YWz5LqO54Gr5b+FXFxcIixcXFwidGl0bGVcXFwiOlxcXCLmo4DmtYvliLDmlrDniYjmnKxcXFwiLFxcXCJ1cmxcXFwiOlxcXCJob2xpZ2VpdDovL29wZW4vdjE/dXJsPWlodW9iaWdsb2JhbDovL20uaGJnLmNvbS9hY2NvdW50L2Fib3V0XFxcIixcXFwiaW1nXFxcIjpudWxsLFxcXCJpbWdOaWdodFxcXCI6bnVsbCxcXFwibmFtZVR5cGVcXFwiOlxcXCLlhbPkuo7ngavlv4VcXFwifV1dfSxcXFwic3VjY2Vzc1xcXCI6dHJ1ZX1cIjtcbiAgICByZXR1cm4gSlNPTi5wYXJzZShkYXRhKS5kYXRhO1xufVxuIiwiaW1wb3J0IHsgaXNFbXB0eVN0cmluZywgZ2VuZXJhdGVQYXJhbXMsIHNob3dMb2FkaW5nIH0gZnJvbSBcIi4vdXRpbFwiO1xuXG5jb25zdCByZXJzb25hbENlbnRlciA9IFwiaG9saWdlaXQ6Ly9vcGVuL3YxP2xvZ2luPTEmdXJsPWlodW9iaWdsb2JhbDovL20uaGJnLmNvbS9jb250ZW50L3BlcnNvbmFsQ2VudGVyP1wiO1xuY29uc3Qgd2VsY29tZURhdGEgPSB7XG4gICAgdHlwZTogXCJ3ZWxjb21lXCIsIC8vIHdlbGNvbWXvvJrmnKrnmbvlvZXvvIx1bmxvZ2lu77ya5b2T5YmN5pyq55m75b2V77yMbG9naW7vvJrnmbvlvZVcbiAgICBkZXNjOiBcIlwiLFxuICAgIHVpZDogXCJcIixcbiAgICBuaWNrTmFtZTogXCJcIixcbiAgICByZWZyZXNoU3RhdHVzOiBcIjBcIixcbiAgICByaWNoVGV4dDogXCJcIiwgLy8g5rOo5YaM55m75b2V5Y2z5Y+v6I635b6XIDgwMCBVU0RUIOWkp+ekvOWMhVxuICAgIGZ1bmNTaG93OiBcInZpc2libGVcIlxufTtcblxuY29uc3Qga3ljQXV0aERpYyA9IHtcbiAgICBpbWc6IFwiXCIsXG4gICAgdGl0bGU6IFwiXCIsXG4gICAgdXJsOiBcIlwiLFxuICAgIHZpc2libGU6IFwiZ29uZVwiLFxuICAgIGltZ1Zpc2libGU6IFwiZ29uZVwiLFxuXHRyZWREb3RWaXNpYmxlOiBcImdvbmVcIixcbiAgICB0ZXh0Q29sb3I6IFwiXCIsXG4gICAgYmFja0NvbG9yOiBcIlwiXG59O1xuXG4vLyBzdGF0ZTotMTrkuKrkurrvvIww77ya5py65p6E5rOo5YaM55So5oi35L2G5piv5pyq5o+Q5Lqk77yMMe+8muW3suaPkOS6pOWuoeaguOS4re+8jDLvvJrlup/lvIPvvIwz77ya5py65p6E5a6h5qC46YCa6L+H77yMNO+8muacuuaehOWuoeaguOWksei0pe+8jOW+heS/ruaUuVxuJGRhdGEudXNlckF1dGggPSB7XG4gICAgcHJpbWU6IGt5Y0F1dGhEaWMsXG4gICAgZG1jOiBreWNBdXRoRGljLFxuICAgIGt5Yzoga3ljQXV0aERpYyxcbn1cblxuJGRhdGEudWlkVW5pcXVlID0ge307XG5cbiRkYXRhLmhlYWRTZWN0aW9uID0gW107XG5cbmxldCBjdXJyZW50QWNjb3VudCA9ICcnO1xuXG4kZGF0YS5reWNXaWR0aCA9ICgzNzUgLSA0OCkgLyAyO1xuXG4kZXZlbnQudWNIZWFkZXIgPSB7XG4gICAgY2xlYXJEYXRhKCkge1xuICAgICAgJGRhdGEudXNlckF1dGgucHJpbWUudmlzaWJsZSA9IFwiZ29uZVwiO1xuICAgICAgJGRhdGEudXNlckF1dGguZG1jLnZpc2libGUgPSBcImdvbmVcIjtcbiAgICAgICRkYXRhLnVzZXJBdXRoLmt5Yy52aXNpYmxlID0gXCJnb25lXCI7XG4gICAgICAkZGF0YS51c2VyQXV0aC5reWMucmVkRG90VmlzaWJsZSA9IFwiZ29uZVwiO1xuICAgICAgJGRhdGEua3ljV2lkdGggPSAoMzc1IC0gNDgpIC8gMjtcbiAgICAgIGNvbnNvbGUubG9nKGBbYWNjb3VudCBqc11jbGVhciBkYXRhYCk7XG4gICAgfSxcbiAgICBzaG93V2VsY29tZShuYXRpdmVEYXRhLCB0aXRsZSA9IFwiXCIsIGhpZ2hsaWdodCA9IFwiXCIpIHtcbiAgICAgICAgdmFyIGhlYWRlckRhdGEgPSB3ZWxjb21lRGF0YTtcbiAgICAgICAgLy8g5a+M5paH5pys5pi+56S6XG4gICAgICAgIGlmIChpc0VtcHR5U3RyaW5nKG5hdGl2ZURhdGEuYWNjb3VudCkpIHtcbiAgICAgICAgICAgIGhlYWRlckRhdGEudHlwZSA9IFwid2VsY29tZVwiO1xuICAgICAgICAgICAgaGVhZGVyRGF0YS5kZXNjID0gdGl0bGU7XG4gICAgICAgICAgICBjb25zdCBjb2xvciA9IG5hdGl2ZURhdGEubmlnaHRNb2RlID8gXCIjOEM4QzkzXCIgOiBcIiM1NjU2NTZcIjtcbiAgICAgICAgICAgIGlmIChpc0VtcHR5U3RyaW5nKGhpZ2hsaWdodCkpIHtcbiAgICAgICAgICAgICAgICBoZWFkZXJEYXRhLnJpY2hUZXh0ID0gYDxzcGFuIHN0eWxlPVwiY29sb3I6JHtjb2xvcn07Zm9udC1zaXplOjEycHg7XCI+JHt0aXRsZX08L3NwYW4+YDtcbiAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICAgY29uc3Qgc3BhblN0YXJ0ID0gYDxzcGFuIHN0eWxlPVwiY29sb3I6JHtjb2xvcn07IGZvbnQtc2l6ZToxMnB4O1wiPmA7XG4gICAgICAgICAgICAgICAgY29uc3Qgc3BhbkVuZCA9IFwiPC9zcGFuPlwiO1xuICAgICAgICAgICAgICAgIHZhciByaWNoSGlnaGxpZ2h0ID0gYCR7c3BhbkVuZH08c3BhbiBzdHlsZT1cImNvbG9yOiNGRTg3MzE7IGZvbnQtc2l6ZToxMnB4O1wiPiAke2hpZ2hsaWdodH0gPC9zcGFuPiR7c3BhblN0YXJ0fWA7XG4gICAgICAgICAgICAgICAgY29uc3Qgam9pblRleHQgPSB0aXRsZS5zcGxpdChoaWdobGlnaHQpLmpvaW4ocmljaEhpZ2hsaWdodCk7XG4gICAgICAgICAgICAgICAgaGVhZGVyRGF0YS5yaWNoVGV4dCA9IGAke3NwYW5TdGFydH0ke2pvaW5UZXh0fSR7c3BhbkVuZH1gO1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgY29uc29sZS5sb2coYGh0bWwgdGV4dDogJHtoZWFkZXJEYXRhLnJpY2hUZXh0fWApO1xuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgaGVhZGVyRGF0YS50eXBlID0gXCJ1bmxvZ2luXCI7XG4gICAgICAgICAgICBoZWFkZXJEYXRhLmRlc2MgPSBgJHskaTE4bi5uX2xvZ2luX2xhc3RfM3JkX2xvZ2luX2hpbnR9ICR7bmF0aXZlRGF0YS5hY2NvdW50fWA7XG4gICAgICAgIH1cbiAgICAgICAgJGRhdGEuaGVhZFNlY3Rpb24gPSBbaGVhZGVyRGF0YV07XG4gICAgfSxcbiAgICBzaG93TG9naW4obmF0aXZlRGF0YSwgcHJpbWUpIHtcbiAgICAgICAgdmFyIGhlYWRlckRhdGEgPSB3ZWxjb21lRGF0YTtcbiAgICAgICAgaGVhZGVyRGF0YS50eXBlID0gXCJsb2dpblwiO1xuICAgICAgICBoZWFkZXJEYXRhLnVpZCA9IGBVSUQ6ICR7bmF0aXZlRGF0YS51aWR9YDtcbiAgICAgICAgaGVhZGVyRGF0YS5uaWNrTmFtZSA9IG5hdGl2ZURhdGEubmlja05hbWU7XG4gICAgICAgIGhlYWRlckRhdGEucmVmcmVzaFN0YXR1cyA9IFwiMVwiO1xuICAgICAgICBoZWFkZXJEYXRhLmZ1bmNTaG93ID0gbmF0aXZlRGF0YS5jaGlsZEFjY291bnQgPyBcImdvbmVcIiA6IFwidmlzaWJsZVwiO1xuICAgICAgICBjdXJyZW50QWNjb3VudCA9IG5hdGl2ZURhdGEuYWNjb3VudDtcbiAgICAgICAgJGRhdGEuaGVhZFNlY3Rpb24gPSBbaGVhZGVyRGF0YV07XG4gICAgICAgIGhhbmRsZVByaW1lRGF0YShuYXRpdmVEYXRhLCBwcmltZSk7IC8vIOWkhOeQhuS8muWRmOmAu+i+kVxuICAgIH0sXG4gICAgb3BlbkxvZ2luKGp1bXBUeXBlID0gMSkge1xuICAgICAgICAvLyBqdW1wVHlwZToxLueZu+W9le+8jDIu5rOo5YaMXG4gICAgICAgICRldmVudC51Yy5vcGVuUm91dGUoYGhvbGlnZWl0Oi8vb3Blbi92MT91cmw9aWh1b2JpZ2xvYmFsOi8vbS5oYmcuY29tL2xvZ2luL2luZGV4P2p1bXBUeXBlPSR7anVtcFR5cGV9YCk7XG4gICAgfSxcbiAgICBhc3luYyBvcGVuUHJlcnNvbmFsQ2VudGVyKHVpZCkge1xuICAgICAgICBjb25zdCB1aWRVbmlxdWUgPSAkZGF0YS51aWRVbmlxdWVbdWlkXTtcbiAgICAgICAgaWYgKCFpc0VtcHR5U3RyaW5nKHVpZFVuaXF1ZSkpIHtcbiAgICAgICAgICAgICRldmVudC51Yy5vcGVuUm91dGUoYCR7cmVyc29uYWxDZW50ZXJ9YWNjb3VudD0ke2N1cnJlbnRBY2NvdW50fSZ1aWRVbmlxdWU9JHt1aWRVbmlxdWV9YCk7XG4gICAgICAgICAgICByZXR1cm47XG4gICAgICAgIH1cbiAgICAgICAgY29uc3QgcmVxdWVzdFBhcmFtcyA9IGdlbmVyYXRlUGFyYW1zKFxuICAgICAgICAgICAgXCJ2MS9jb250ZW50L2NvbW11bml0eS91c2VyL2NvbnRlbnQtaW5mb1wiLCB7fVxuICAgICAgICApO1xuICAgICAgICBzaG93TG9hZGluZygxKTtcbiAgICAgICAgdHJ5IHtcbiAgICAgICAgICAgIGNvbnN0IHJlc3BvbnNlU3RyaW5nID0gYXdhaXQgJG5hdGl2ZUFQSS5yZXF1ZXN0KHJlcXVlc3RQYXJhbXMpO1xuICAgICAgICAgICAgY29uc3QgeyBjb2RlLCBkYXRhIH0gPSBKU09OLnBhcnNlKHJlc3BvbnNlU3RyaW5nKTtcbiAgICAgICAgICAgIHNob3dMb2FkaW5nKDApO1xuICAgICAgICAgICAgaWYgKGNvZGUgPT0gMjAwKSB7XG4gICAgICAgICAgICAgICAgJGRhdGEudWlkVW5pcXVlW3VpZF0gPSBkYXRhLnVpZFVuaXF1ZTtcbiAgICAgICAgICAgICAgICBjb25zdCBvcGVuVXJsID0gYCR7cmVyc29uYWxDZW50ZXJ9YWNjb3VudD0ke2N1cnJlbnRBY2NvdW50fSZ1aWRVbmlxdWU9JHtkYXRhLnVpZFVuaXF1ZX1gO1xuICAgICAgICAgICAgICAgICRldmVudC51Yy5vcGVuUm91dGUob3BlblVybCk7XG4gICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgIGNvbnNvbGUubG9nKGBjb250ZW50LWluZm8gcmVxdWVzdCBlcnJvciBjb2RlOiR7Y29kZX1gKTtcbiAgICAgICAgICAgIH1cbiAgICAgICAgfSBjYXRjaCAoZSkge1xuICAgICAgICAgICAgc2hvd0xvYWRpbmcoMCk7XG4gICAgICAgICAgICAkZGF0YS51Yy5yZWZyZXNoID0gXCIyXCI7XG4gICAgICAgICAgICBjb25zb2xlLmxvZyhgY29udGVudC1pbmZvIHJlcXVlc3QgZXJyb3I6JHtlfWApO1xuICAgICAgICB9XG4gICAgfSxcbiAgICBhc3luYyByZXF1ZXN0S3ljQXV0aEluZm8obmF0aXZlRGF0YSkge1xuICAgICAgICBpZiAobmF0aXZlRGF0YS5jaGlsZEFjY291bnQpIHtcbiAgICAgICAgICAgICRkYXRhLnVzZXJBdXRoLmRtYy52aXNpYmxlID0gXCJnb25lXCI7XG4gICAgICAgICAgICAkZGF0YS51c2VyQXV0aC5reWMudmlzaWJsZSA9IFwiZ29uZVwiO1xuICAgICAgICAgICAgJGRhdGEudXNlckF1dGgua3ljLnJlZERvdFZpc2libGUgPSBcImdvbmVcIjtcbiAgICAgICAgICAgIHJldHVybjtcbiAgICAgICAgfVxuICAgICAgICBjb25zdCBpc0luc3RVc2VyID0gYXdhaXQgcmVxdWVzdEluc3RJbmZvKCk7XG4gICAgICAgIHJlcXVlc3RLeWNBdXRoSW5mb1YyKG5hdGl2ZURhdGEsIGlzSW5zdFVzZXIpO1xuICAgIH0sXG59O1xuXG5hc3luYyBmdW5jdGlvbiByZXF1ZXN0S3ljQXV0aEluZm9WMihuYXRpdmVEYXRhLCBpc0luc3RVc2VyKSB7XG4gICAgY29uc3QgcmVxdWVzdFBhcmFtcyA9IGdlbmVyYXRlUGFyYW1zKFwidjEvcHVibGljL2t5Yy9hdXRoL2luZm8vZ2V0X3YyXCIsIHt9LCAwLCAzKTtcbiAgICB0cnkge1xuICAgICAgICBjb25zdCByZXNwb25zZVN0cmluZyA9IGF3YWl0ICRuYXRpdmVBUEkucmVxdWVzdChyZXF1ZXN0UGFyYW1zKTtcbiAgICAgICAgY29uc3QgcmVzcG9uc2UgPSBKU09OLnBhcnNlKHJlc3BvbnNlU3RyaW5nKTtcbiAgICAgICAgY29uc3QgeyBjb2RlLCBkYXRhIH0gPSByZXNwb25zZTtcbiAgICAgICAgaWYgKGNvZGUgPT0gMjAwKSB7XG4gICAgICAgICAgICBodW5kbGVEbWNEYXRhKGRhdGEsIG5hdGl2ZURhdGEpO1xuICAgICAgICAgICAgaWYgKCFpc0luc3RVc2VyKSB7XG4gICAgICAgICAgICAgICAgaGFuZGxlS3ljRGF0YShkYXRhLCBuYXRpdmVEYXRhKTtcbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIGlmICgkZGF0YS51c2VyQXV0aC5kbWMudmlzaWJsZSA9PSBcInZpc2libGVcIiAmJlxuICAgICAgICAgICAgICAkZGF0YS51c2VyQXV0aC5kbWMudGl0bGUgPT0gXCJETUNcIiAmJlxuICAgICAgICAgICAgICAkZGF0YS51c2VyQXV0aC5reWMucmVkRG90VmlzaWJsZSA9PSBcInZpc2libGVcIikge1xuICAgICAgICAgICAgICAvLyDmnKrorqTor4Hmg4XlhrXkuIvvvIzkuI3lsZXnpLpkbWPlhaXlj6NcbiAgICAgICAgICAgICAgJGRhdGEudXNlckF1dGguZG1jLnZpc2libGUgPSBcImdvbmVcIjtcbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIGlmICgkZGF0YS51c2VyQXV0aC5kbWMudmlzaWJsZSA9PSBcImdvbmVcIiB8fCAkZGF0YS51c2VyQXV0aC5reWMudmlzaWJsZSA9PSBcImdvbmVcIikge1xuICAgICAgICAgICAgICAkZGF0YS5reWNXaWR0aCA9ICgzNzUgLSA0OCkgLyAyO1xuICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgJGRhdGEua3ljV2lkdGggPSAoMzc1IC0gNTYpIC8gMztcbiAgICAgICAgICAgIH1cbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIGNvbnNvbGUubG9nKGBpbmZvL2dldF92MiByZXF1ZXN0IGVycm9yIGNvZGU6JHtjb2RlfWApO1xuICAgICAgICB9XG4gICAgfSBjYXRjaCAoZSkge1xuICAgICAgICBjb25zb2xlLmxvZyhgaW5mby9nZXRfdjIgcmVxdWVzdCBlcnJvcjoke2V9YCk7XG4gICAgfVxufVxuXG4vLyDmn6Xor6LmnLrmnoTnlKjmiLfkv6Hmga9cbmFzeW5jIGZ1bmN0aW9uIHJlcXVlc3RJbnN0SW5mbygpIHtcbiAgICBjb25zdCByZXF1ZXN0UGFyYW1zID0gZ2VuZXJhdGVQYXJhbXMoXG4gICAgICAgICdvbmJvYXJkL3YxL2hiZy9vcGVuL2luc3QvYXBwbGljYXRpb24vbGV2ZWxfaW5mby9nZXQnLCB7fSwgMCwgMiwgeyBIQklnbm9yZUZhaWx1cmVUb2FzdDogXCIxXCIgfSk7XG4gICAgdHJ5IHtcbiAgICAgICAgY29uc3QgcmVzcG9uc2VTdHJpbmcgPSBhd2FpdCAkbmF0aXZlQVBJLnJlcXVlc3QocmVxdWVzdFBhcmFtcyk7XG4gICAgICAgIGNvbnN0IHJlc3BvbnNlID0gSlNPTi5wYXJzZShyZXNwb25zZVN0cmluZyk7XG4gICAgICAgIGNvbnN0IHsgY29kZSwgZGF0YSB9ID0gcmVzcG9uc2U7XG4gICAgICAgIGlmIChjb2RlID09IDIwMCkge1xuICAgICAgICAgICAgaWYgKGRhdGEgJiYgZGF0YSAhPSBudWxsKSB7XG4gICAgICAgICAgICAgICAgdmFyIGluc3REaWMgPSBreWNBdXRoRGljO1xuICAgICAgICAgICAgICAgIGluc3REaWMudGV4dENvbG9yID0gXCJAY29sb3Iva0NvbG9yUHJpbWFyeVRleHRcIjtcbiAgICAgICAgICAgICAgICBpbnN0RGljLmltZ1Zpc2libGUgPSBcImdvbmVcIjtcbiAgICAgICAgICAgICAgICBpbnN0RGljLnVybCA9IFwiaG9saWdlaXQ6Ly9vcGVuL3YxP2xvZ2luPTEmdXJsPWlodW9iaWdsb2JhbDovL20uaGJnLmNvbS9hY2NvdW50L2luc3RpdHV0aW9uS3ljXCI7XG4gICAgICAgICAgICAgICAgLy8g6Kej5p6Q5py65p6E562J57qnXG4gICAgICAgICAgICAgICAgaWYgKGRhdGEuc3RhdGUgPT0gMSB8fCBkYXRhLnN0YXRlID09IDMgfHwgZGF0YS5zdGF0ZSA9PSA0KSB7XG4gICAgICAgICAgICAgICAgICAgIGlmIChkYXRhLnN0YXRlID09IDEpIHtcbiAgICAgICAgICAgICAgICAgICAgICAgIGluc3REaWMudGl0bGUgPSBcIm5fa3ljX29yZ2FuaXphdGlvbl9pbnJldmlld1wiO1xuICAgICAgICAgICAgICAgICAgICAgICAgaW5zdERpYy5pbWcgPSBcIkBkcmF3YWJsZS9hY2NvdW50X2t5Y192ZXJpZmlpbmdcIjtcbiAgICAgICAgICAgICAgICAgICAgICAgIGluc3REaWMuaW1nVmlzaWJsZSA9IFwidmlzaWJsZVwiO1xuICAgICAgICAgICAgICAgICAgICB9IGVsc2UgaWYgKGRhdGEuc3RhdGUgPT0gMykge1xuICAgICAgICAgICAgICAgICAgICAgICAgaWYgKGRhdGEubGV2ZWxUeXBlID09IDEpIHtcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICBpbnN0RGljLnRpdGxlID0gXCJuX2t5Y19hdXRoX2luc3RfbHYxXCI7XG4gICAgICAgICAgICAgICAgICAgICAgICB9IGVsc2UgaWYgKGRhdGEubGV2ZWxUeXBlID09IDIpIHtcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICBpbnN0RGljLnRpdGxlID0gXCJuX2t5Y19hdXRoX2luc3RfbHYyXCI7XG4gICAgICAgICAgICAgICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgICAgICAgICAgICAgIGluc3REaWMudGl0bGUgPSBcIm5fa3ljX29yZ2FuaXphdGlvbl9hdXRoZWRcIjtcbiAgICAgICAgICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgICAgICAgICAgIGluc3REaWMudGl0bGUgPSBcIm5fa3ljX29yZ2FuaXphdGlvbl9hdXRoX2ZhaWxlZFwiO1xuICAgICAgICAgICAgICAgICAgICAgICAgaW5zdERpYy50ZXh0Q29sb3IgPSBcIkBjb2xvci9rQ29sb3JQcmljZVJlZFwiO1xuICAgICAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgICAgICRkYXRhLnVzZXJBdXRoLmt5YyA9IGluc3REaWM7XG4gICAgICAgICAgICAgICAgICAgIHJldHVybiB0cnVlO1xuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIHJldHVybiBmYWxzZTtcbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIGNvbnNvbGUubG9nKGBpbnN0IHJlcXVlc3QgZXJyb3IgY29kZToke2NvZGV9YCk7XG4gICAgICAgICAgICByZXR1cm4gZmFsc2U7XG4gICAgICAgIH1cbiAgICB9IGNhdGNoIChlKSB7XG4gICAgICAgIGNvbnNvbGUubG9nKGBpbnN0IHJlcXVlc3QgZXJyb3I6JHtlfWApO1xuICAgICAgICByZXR1cm4gZmFsc2U7XG4gICAgfVxufVxuXG5mdW5jdGlvbiBoYW5kbGVQcmltZURhdGEobmF0aXZlRGF0YSwgcHJpbWUpIHtcbiAgICBjb25zb2xlLmxvZyhgW2FjY291bnQganNdb3JpZ2luIHByaW1lIGRhdGE6ICR7SlNPTi5zdHJpbmdpZnkoJGRhdGEudXNlckF1dGgucHJpbWUucmF3T2JqZWN0KCkpfWApO1xuICAgIGlmIChuYXRpdmVEYXRhLmNoaWxkQWNjb3VudCB8fCAhcHJpbWUgfHwgcHJpbWUgPT0gbnVsbCkge1xuICAgICAgICAkZGF0YS51c2VyQXV0aC5wcmltZS52aXNpYmxlID0gXCJnb25lXCI7XG4gICAgICAgIHJldHVybjtcbiAgICB9XG4gICAgdmFyIHNob3dQcmltZSA9IHt9O1xuICAgIGlmIChwcmltZS5sZXZlbCA8IDIpIHtcbiAgICAgICAgc2hvd1ByaW1lLmJhY2tDb2xvciA9IG5hdGl2ZURhdGEubmlnaHRNb2RlID8gXCIjMTcyNzM2XCIgOiBcIiNGNEY4RkNcIjtcbiAgICAgICAgc2hvd1ByaW1lLnRleHRDb2xvciA9IG5hdGl2ZURhdGEubmlnaHRNb2RlID8gXCIjOEM4QzkzXCIgOiBcIiM1NjU2NTZcIjtcbiAgICAgICAgc2hvd1ByaW1lLmltZyA9IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX2FjY291bnRfcHJpbWVfMVwiO1xuICAgIH0gZWxzZSBpZiAocHJpbWUubGV2ZWwgPCA1KSB7XG4gICAgICAgIHNob3dQcmltZS5iYWNrQ29sb3IgPSBuYXRpdmVEYXRhLm5pZ2h0TW9kZSA/IFwiIzE5MjkyNVwiIDogXCIjRUZGQUY2XCI7XG4gICAgICAgIHNob3dQcmltZS50ZXh0Q29sb3IgPSBuYXRpdmVEYXRhLm5pZ2h0TW9kZSA/IFwiIzAwQTE3MVwiIDogXCIjMDBBMTcxXCI7XG4gICAgICAgIHNob3dQcmltZS5pbWcgPSBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9hY2NvdW50X3ByaW1lXzJcIjtcbiAgICB9IGVsc2UgaWYgKHByaW1lLmxldmVsIDwgNykge1xuICAgICAgICBzaG93UHJpbWUuYmFja0NvbG9yID0gbmF0aXZlRGF0YS5uaWdodE1vZGUgPyBcIiMyRjIzMjNcIiA6IFwiI0ZCRjZGM1wiO1xuICAgICAgICBzaG93UHJpbWUudGV4dENvbG9yID0gbmF0aXZlRGF0YS5uaWdodE1vZGUgPyBcIiNDNjgyNThcIiA6IFwiI0M2ODI1OFwiO1xuICAgICAgICBzaG93UHJpbWUuaW1nID0gXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfYWNjb3VudF9wcmltZV8zXCI7XG4gICAgfSBlbHNlIGlmIChwcmltZS5sZXZlbCA8IDEwKSB7XG4gICAgICAgIHNob3dQcmltZS5iYWNrQ29sb3IgPSBuYXRpdmVEYXRhLm5pZ2h0TW9kZSA/IFwiIzJBMjQxOVwiIDogXCIjRkNGOUY0XCI7XG4gICAgICAgIHNob3dQcmltZS50ZXh0Q29sb3IgPSBuYXRpdmVEYXRhLm5pZ2h0TW9kZSA/IFwiI0YyODMwMVwiIDogXCIjRjI4MzAxXCI7XG4gICAgICAgIHNob3dQcmltZS5pbWcgPSBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9hY2NvdW50X3ByaW1lXzRcIjtcbiAgICB9IGVsc2Uge1xuICAgICAgICBzaG93UHJpbWUuYmFja0NvbG9yID0gbmF0aXZlRGF0YS5uaWdodE1vZGUgPyBcIiMyQzJCMUJcIiA6IFwiI0ZBRkFGMFwiO1xuICAgICAgICBzaG93UHJpbWUudGV4dENvbG9yID0gbmF0aXZlRGF0YS5uaWdodE1vZGUgPyBcIiNFNkU2RTZcIiA6IFwiIzAwMDAwMFwiO1xuICAgICAgICBzaG93UHJpbWUuaW1nID0gXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfYWNjb3VudF9wcmltZV81XCI7XG4gICAgfVxuICAgIHNob3dQcmltZS51cmwgPSBwcmltZS51cmw7XG4gICAgY29uc3QgdXNlckxldmVsID0gcHJpbWUubGV2ZWwgPiAwID8gcHJpbWUubGV2ZWwgLSAxIDogMDtcbiAgICBzaG93UHJpbWUudGl0bGUgPSBgUHJpbWUgJHt1c2VyTGV2ZWx9YDtcbiAgICBzaG93UHJpbWUudmlzaWJsZSA9IHByaW1lLmxldmVsID09IG51bGwgPyBcImdvbmVcIiA6IFwidmlzaWJsZVwiO1xuICAgICRkYXRhLnVzZXJBdXRoLnByaW1lID0gc2hvd1ByaW1lO1xuICAgIGNvbnNvbGUubG9nKGBbYWNjb3VudCBqc11wcmltZSBkYXRhOiAke0pTT04uc3RyaW5naWZ5KHNob3dQcmltZSl9YCk7XG59XG5cbi8vIGRtY1xuZnVuY3Rpb24gaHVuZGxlRG1jRGF0YShkYXRhLCBuYXRpdmVEYXRhKSB7XG4gICAgdmFyIGRtY0RpYyA9IGt5Y0F1dGhEaWM7XG4gICAgaWYgKGlzRW1wdHlTdHJpbmcoZGF0YS5lbnRyYW5jZU5hbWUpKSB7XG4gICAgICAgIGRtY0RpYy52aXNpYmxlID0gXCJnb25lXCI7XG4gICAgfSBlbHNlIHtcbiAgICAgICAgZG1jRGljLnRpdGxlID0gZGF0YS5lbnRyYW5jZU5hbWU7XG4gICAgICAgIGRtY0RpYy5pbWcgPSBgJHtuYXRpdmVEYXRhLmZsYWdob3N0fS9wL2FwaS9jb250ZW50cy9jb3VudHJ5L2ljb24vJHtkYXRhLmVudHJhbmNlQ291bnRyeUlkfS5wbmdgO1xuICAgICAgICBkbWNEaWMuaW1nVmlzaWJsZSA9IFwidmlzaWJsZVwiO1xuICAgICAgICBpZiAoZGF0YS5lbnRyYW5jZVVybC5zdGFydHNXaXRoKCdob2xpZ2VpdCcpKSB7XG4gICAgICAgICAgICBkbWNEaWMudXJsID0gZGF0YS5lbnRyYW5jZVVybDtcbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIGRtY0RpYy51cmwgPSBgJHtuYXRpdmVEYXRhLndlYmhvc3R9JHtkYXRhLmVudHJhbmNlVXJsfWA7XG4gICAgICAgIH1cbiAgICAgICAgZG1jRGljLnZpc2libGUgPSBcInZpc2libGVcIjtcbiAgICB9XG4gICAgJGRhdGEudXNlckF1dGguZG1jID0gZG1jRGljO1xufVxuXG4vLyBreWNcbmZ1bmN0aW9uIGhhbmRsZUt5Y0RhdGEoZGF0YSwgbmF0aXZlRGF0YSkge1xuICAgIGlmIChkYXRhLmZpbmFsQXV0aFN0YXRlICE9IC0xICYmIGRhdGEuc2hvd09sZEVudHJhbmNlICYmIG5hdGl2ZURhdGEucHJvX3N0YXR1cyAhPSAtMSkge1xuICAgICAgICAvLyBwcm9TdGF0dXMhPS0xLGZpbmFsQXV0aFN0YXRlIT0tMSxzaG93T2xkRW50cmFuY2U9dHJ1ZeWxleekuuiAgeWFpeWPo1xuICAgICAgICAvLyB0eXBlOjDvvJrmnKrorqTor4HvvIwx77ya6K6k6K+B5Lit77yMMu+8muW3suiupOivge+8jDPvvJrln7rnoYDorqTor4HvvIw077ya5Yid57qn6K6k6K+B77yMNe+8mumrmOe6p+iupOivge+8jDbvvJrorqTor4HlpLHotKVcbiAgICAgICAgY29uc3QgYXV0aFR5cGUgPSBreWNBdXRoVHlwZShkYXRhLCBuYXRpdmVEYXRhLnByb19zdGF0dXMpO1xuICAgICAgICB2YXIga3ljRGljID0ga3ljQXV0aERpYztcbiAgICAgICAga3ljRGljLmJhY2tDb2xvciA9IFwiQGNvbG9yL0tCYXNlQ29sb3JJbnB1dEJhY2tncm91bmRcIjtcbiAgICAgICAga3ljRGljLnRleHRDb2xvciA9IFwiQGNvbG9yL2tDb2xvclByaW1hcnlUZXh0XCI7XG4gICAgICAgIGt5Y0RpYy52aXNpYmxlID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgIGt5Y0RpYy5pbWdWaXNpYmxlID0gXCJnb25lXCI7XG4gICAgICAgIGt5Y0RpYy5yZWREb3RWaXNpYmxlID0gXCJnb25lXCI7XG4gICAgICAgIGt5Y0RpYy51cmwgPSBcImhvbGlnZWl0Oi8vb3Blbi92MT9sb2dpbj0xJnVybD1paHVvYmlnbG9iYWw6Ly9tLmhiZy5jb20vYWNjb3VudC9reWM/YXV0aEJpekNvZGU9U1BPVCZzb3VyY2U9MVwiO1xuICAgICAgICBpZiAoYXV0aFR5cGUgPT0gMyB8fCBhdXRoVHlwZSA9PSA0IHx8IGF1dGhUeXBlID09IDUpIHtcbiAgICAgICAgICAgIGt5Y0RpYy5pbWdWaXNpYmxlID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgICAgICBreWNEaWMuaW1nID0gYCR7bmF0aXZlRGF0YS5mbGFnaG9zdH0vcC9hcGkvY29udGVudHMvY291bnRyeS9pY29uLyR7ZGF0YS5iYXNlSW5mby5jb3VudHJ5SWR9LnBuZ2A7XG4gICAgICAgIH1cbiAgICAgICAgc3dpdGNoIChhdXRoVHlwZSkge1xuICAgICAgICAgICAgY2FzZSA1OlxuICAgICAgICAgICAgICAgIGt5Y0RpYy50aXRsZSA9IFwiTDNcIjtcbiAgICAgICAgICAgICAgICBicmVhaztcbiAgICAgICAgICAgIGNhc2UgNDpcbiAgICAgICAgICAgICAgICBreWNEaWMudGl0bGUgPSBcIkwyXCI7XG4gICAgICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgICAgICBjYXNlIDM6XG4gICAgICAgICAgICAgICAga3ljRGljLnRpdGxlID0gXCJMMVwiO1xuICAgICAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICAgICAgY2FzZSAyOlxuICAgICAgICAgICAgICAgIGt5Y0RpYy50aXRsZSA9IGAkeyRpMThuLm5fdXNlcl9jZW50ZXJfaXNfbm90X3ZlcmlmeX1gO1xuICAgICAgICAgICAgICAgIGt5Y0RpYy5yZWREb3RWaXNpYmxlID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgICAgICAgICAga3ljRGljLmJhY2tDb2xvciA9IFwiQGNvbG9yL2tDb2xvcjFBRkU4NzMxXCI7XG4gICAgICAgICAgICAgICAga3ljRGljLnRleHRDb2xvciA9IFwiQGNvbG9yL2NvbG9yX0ZFODczMVwiO1xuICAgICAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICAgICAgY2FzZSAxOlxuICAgICAgICAgICAgICAgIGt5Y0RpYy50aXRsZSA9IGAkeyRpMThuLm5fa3ljX2F1dGhlbnRpY2F0aW9uX3ZlcmlmeWluZ31gO1xuICAgICAgICAgICAgICAgIGt5Y0RpYy5pbWcgPSBcIkBkcmF3YWJsZS9hY2NvdW50X2t5Y192ZXJpZmlpbmdcIjtcbiAgICAgICAgICAgICAgICBreWNEaWMuaW1nVmlzaWJsZSA9IFwidmlzaWJsZVwiO1xuICAgICAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICAgICAgY2FzZSAwOlxuICAgICAgICAgICAgICAgIGt5Y0RpYy50aXRsZSA9IGAkeyRpMThuLm5fdXNlcl9jZW50ZXJfaXNfbm90X3ZlcmlmeX1gO1xuICAgICAgICAgICAgICAgIGt5Y0RpYy5yZWREb3RWaXNpYmxlID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgICAgICAgICAga3ljRGljLmJhY2tDb2xvciA9IFwiQGNvbG9yL2tDb2xvcjFBRkU4NzMxXCI7XG4gICAgICAgICAgICAgICAga3ljRGljLnRleHRDb2xvciA9IFwiQGNvbG9yL2NvbG9yX0ZFODczMVwiO1xuICAgICAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICAgICAgY2FzZSA2OlxuICAgICAgICAgICAgICAgIGt5Y0RpYy50aXRsZSA9IGAkeyRpMThuLm5fa3ljX2F1dGhlbnRpY2F0aW9uX2ZhaWx9YDtcbiAgICAgICAgICAgICAgICBreWNEaWMudGV4dENvbG9yID0gXCJAY29sb3Iva0NvbG9yUHJpY2VSZWRcIjtcbiAgICAgICAgICAgICAgICBicmVhaztcbiAgICAgICAgICAgIGRlZmF1bHQ6XG4gICAgICAgICAgICAgICAga3ljRGljLnRpdGxlID0gYCR7JGkxOG4ubl91c2VyX2NlbnRlcl9pc19ub3RfdmVyaWZ5fWA7XG4gICAgICAgICAgICAgICAga3ljRGljLnJlZERvdFZpc2libGUgPSBcInZpc2libGVcIjtcbiAgICAgICAgICAgICAgICBreWNEaWMuYmFja0NvbG9yID0gXCJAY29sb3Iva0NvbG9yMUFGRTg3MzFcIjtcbiAgICAgICAgICAgICAgICBreWNEaWMudGV4dENvbG9yID0gXCJAY29sb3IvY29sb3JfRkU4NzMxXCI7XG4gICAgICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgIH1cbiAgICAgICAgJGRhdGEudXNlckF1dGgua3ljID0ga3ljRGljO1xuICAgIH0gZWxzZSB7XG4gICAgICAgICRkYXRhLnVzZXJBdXRoLmt5Yy52aXNpYmxlID0gXCJnb25lXCI7XG4gICAgICAgICRkYXRhLnVzZXJBdXRoLmt5Yy5yZWREb3RWaXNpYmxlID0gXCJnb25lXCI7XG4gICAgfVxufVxuXG4vLyBreWPnrYnnuqfop6PmnpBcbmZ1bmN0aW9uIGt5Y0F1dGhUeXBlKGF1dGhJbmZvLCBwcm9fc3RhdHVzKSB7XG4gICAgdmFyIHN0ZXBNb2RlbERpYyA9IHt9O1xuICAgIGZvciAobGV0IGluZGV4ID0gMDsgaW5kZXggPCBhdXRoSW5mby5zdGVwU3RhdGVzLmxlbmd0aDsgaW5kZXgrKykge1xuICAgICAgICBjb25zdCBlbGVtZW50ID0gYXV0aEluZm8uc3RlcFN0YXRlc1tpbmRleF07XG4gICAgICAgIHN0ZXBNb2RlbERpY1tlbGVtZW50LmF1dGhTdGVwLnRvVXBwZXJDYXNlKCldID0gZWxlbWVudDtcbiAgICB9XG4gICAgdmFyIGF1dGhUeXBlID0gMDsgLy8gdHlwZTow77ya5pyq6K6k6K+B77yMMe+8muiupOivgeS4re+8jDLvvJrlt7LorqTor4HvvIwz77ya5Z+656GA6K6k6K+B77yMNO+8muWInee6p+iupOivge+8jDXvvJrpq5jnuqforqTor4HvvIw277ya6K6k6K+B5aSx6LSlXG4gICAgY29uc3QgYzAgPSBzdGVwTW9kZWxEaWNbXCJDMFwiXTtcbiAgICBjb25zdCBjMSA9IHN0ZXBNb2RlbERpY1tcIkMxXCJdO1xuICAgIGNvbnN0IGMyID0gc3RlcE1vZGVsRGljW1wiQzJcIl07XG4gICAgLy8gYXV0aFN0YXRlOjA65pyq6K6k6K+BLCAxOuiupOivgeS4rSwgMjrlt7LorqTor4EsIDM66K6k6K+B5aSx6LSl77yMIDQ6IOaXoOazleiupOivgVxuICAgIGlmIChjMiAmJiBjMi5hdXRoU3RhdGUgPT0gMikge1xuICAgICAgICBhdXRoVHlwZSA9IDU7XG4gICAgfSBlbHNlIGlmIChjMSAmJiBjMS5hdXRoU3RhdGUgPT0gMikge1xuICAgICAgICBhdXRoVHlwZSA9IDQ7XG4gICAgfSBlbHNlIGlmIChjMCAmJiBjMC5hdXRoU3RhdGUgPT0gMikge1xuICAgICAgICBhdXRoVHlwZSA9IDM7XG4gICAgfSBlbHNlIGlmIChwcm9fc3RhdHVzID09IDIpIHtcbiAgICAgICAgYXV0aFR5cGUgPSA0O1xuICAgIH1cbiAgICBpZiAoYXV0aFR5cGUgPT0gMCkge1xuICAgICAgICBpZiAoYzAgJiYgYzAuYXV0aFN0YXRlID09IDEpIHtcbiAgICAgICAgICAgIGF1dGhUeXBlID0gMTtcbiAgICAgICAgfSBlbHNlIGlmIChjMCAmJiBjMC5hdXRoU3RhdGUgPT0gMykge1xuICAgICAgICAgICAgYXV0aFR5cGUgPSA2O1xuICAgICAgICB9XG4gICAgfVxuICAgIHJldHVybiBhdXRoVHlwZTtcbn1cbiIsImltcG9ydCB7IGdlbmVyYXRlUGFyYW1zLCBsb2dpbk1vY2ssIHVubG9naW5Nb2NrLCBzaG93TG9hZGluZywgaXNFbXB0eVN0cmluZyB9IGZyb20gXCIuL3V0aWxcIlxuXG4vLyDljp/nlJ/liJ3lp4vljJbmlbDmja5cbnZhciBuYXRpdmVEYXRhID0ge1xuICAgIGlzTG9naW46IDAsIC8v5piv5ZCm55m75b2VXG4gICAgcGxhdGZvcm06IDIsIC8vIOW5s+WPsOexu+Wei1xuICAgIG5pZ2h0TW9kZTogMCwgLy8g6buR55m95qih5byPXG4gICAgdWlkOiBcIlwiLCAvLyB1aWRcbiAgICBuaWNrTmFtZTogXCJcIiwgLy8g5pi+56S65ZCN5a2XXG4gICAgYWNjb3VudDogXCJcIiwgLy8g55m75b2V6LSm5Y+3XG4gICAgaGFzTmV3VmVyc2lvbjogZmFsc2UsXG4gICAgbGFuZ3VhZ2U6IFwiXCIsXG4gICAgZmxhZ2hvc3Q6IFwiXCIsXG4gICAgd2ViaG9zdDogXCJcIiwgLy8gZG1jIOaJk+W8gFdlYumhteaXtuaLvOaOpWhvc3RcbiAgICBjaGlsZEFjY291bnQ6IGZhbHNlLFxuICAgIHByb19zdGF0dXM6IC0xLCAvLyBnZXRfYXV0aF9pbmZvOmF1dGhfaW5mby5wcm9fc3RhdHVzXG59O1xuXG5jb25zdCBtb2RlbCA9IHtcbiAgICBuYW1lOiBcIlwiLCAvL1x0U3RyaW5nXHTlkI3lrZdcdFxuICAgIHRpdGxlOiBcIlwiLCAvL1x0U3RyaW5nXHTmoIfnrb5cdFxuICAgIHVybDogXCJcIiwgLy9cdFN0cmluZ1x06Lez6L2s5Zyw5Z2AXHRcbiAgICBpbWc6IFwiaG9tZV9vcGVyYXRpb25fcGxhY2Vob2xkZXJcIiwgLy9cdFN0cmluZ1x05Zu+54mHXHRcbiAgICBpbWdOaWdodDogXCJcIiwgLy9cdFN0cmluZ1x05Zu+54mHXHRcbiAgICB0eXBlOiBcIm5vcm1hbFwiLCAvLyDliJfooajlj5bnlKjvvJpub3JtYWw65q2j5bi4Y2VsbO+8jGRpdmlkZXLvvJrliIblibLnur9jZWxsXG4gICAgdmlzaWJsZTogXCJnb25lXCIsIC8vIOmHkeWImuWMuuWPlueUqFxuICAgIG5vcm1hbFZpc2libGU6IFwiZ29uZVwiLFxuICAgIGJhY2tDb2xvcjogXCIjMDBBMTcxXCIsXG4gICAgYmFja1Zpc2libGU6IFwiZ29uZVwiLFxufTtcblxuY29uc3QgdWNEYXRhID0ge1xuICAgIHByaW1lOiB7IGxldmVsOiBudWxsLCB1cmw6IFwiXCIgfSxcbiAgICBmZWF0dXJlczogW10sXG4gICAgZmVhdHVyZVZpc2liaWxpdHk6IFwiZ29uZVwiLCAvLyDph5HliJrljLrlj6/op4FcbiAgICBsaXN0OiBbXSxcbiAgICByZWZyZXNoOiBcIjJcIlxufTtcblxudmFyIGNsaWNrYWJsZSA9IHRydWU7XG5cbiRkYXRhLnVjID0gdWNEYXRhO1xuXG4kZXZlbnQudWMgPSB7XG4gICAgdmlld1dpbGxBcHBlYXIobmF0aWNlSnNvbikge1xuICAgICAgICBjb25zb2xlLmxvZyhgdmlld1dpbGxBcHBlYXI6JHtuYXRpY2VKc29ufWApO1xuICAgICAgICBjbGlja2FibGUgPSB0cnVlO1xuICAgICAgICBjb25zdCBuZXdOYXRpdmVEYXRhID0gSlNPTi5wYXJzZShuYXRpY2VKc29uKTtcbiAgICAgICAgaWYgKG5hdGl2ZURhdGEudWlkICE9IG5ld05hdGl2ZURhdGEudWlkIHx8IG5hdGl2ZURhdGEubGFuZ3VhZ2UgIT0gbmV3TmF0aXZlRGF0YS5sYW5ndWFnZSkge1xuICAgICAgICAgICAgLy8g5pyJ5Y+Y5YyW77yM6ZyA6KaB6YeN572u5pWw5o2uXG4gICAgICAgICAgICAkZGF0YS51YyA9IHVjRGF0YTtcbiAgICAgICAgICAgICRldmVudC51Y0hlYWRlci5jbGVhckRhdGEoKTtcbiAgICAgICAgfVxuICAgICAgICBuYXRpdmVEYXRhID0gbmV3TmF0aXZlRGF0YTtcbiAgICAgICAgaWYgKG5hdGl2ZURhdGEuaXNMb2dpbiA9PSAxKSB7XG4gICAgICAgICAgICAkZXZlbnQudWNIZWFkZXIuc2hvd0xvZ2luKG5hdGl2ZURhdGEsICRkYXRhLnVjLnByaW1lKTtcbiAgICAgICAgICAgICRldmVudC51Y0hlYWRlci5yZXF1ZXN0S3ljQXV0aEluZm8obmF0aXZlRGF0YSk7XG4gICAgICAgICAgICByZXF1ZXN0SG9tZUxvZ2luRGF0YSgpO1xuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgJGRhdGEudWMuZmVhdHVyZXMgPSBbXTtcbiAgICAgICAgICAgICRkYXRhLnVjLmZlYXR1cmVWaXNpYmlsaXR5ID0gXCJnb25lXCI7XG4gICAgICAgICAgICAkZXZlbnQudWNIZWFkZXIuc2hvd1dlbGNvbWUobmF0aXZlRGF0YSwgXCJcIiwgXCJcIik7XG4gICAgICAgICAgICByZXF1ZXN0SG9tZU5vdExvZ2luRGF0YSgpO1xuICAgICAgICB9XG4gICAgfSxcbiAgICBvcGVuUm91dGUocm91dGVVcmwsIGp1bXBUeXBlID0gLTk5OSkge1xuICAgICAgICBpZiAoIWNsaWNrYWJsZSkge1xuICAgICAgICAgICAgcmV0dXJuO1xuICAgICAgICB9XG4gICAgICAgIGNvbnNvbGUubG9nKFwiW2FjY291bnQganNdIG9wZW4gdXJsOlwiLCByb3V0ZVVybCk7XG4gICAgICAgIGlmICghaXNFbXB0eVN0cmluZyhyb3V0ZVVybCkpIHtcbiAgICAgICAgICAgICRuYXRpdmVBUEkub3BlblJvdXRlKHJvdXRlVXJsKTtcbiAgICAgICAgfVxuXHRcdGlmIChqdW1wVHlwZSA+IDApIHtcblx0XHRcdC8vIOWPlua2iOWwj+e6oueCuVxuXHRcdFx0cmVxdWVzdFJlbW92ZVVzZXJSZWREb3QoanVtcFR5cGUpO1xuXHRcdH1cbiAgICAgICAgY2xpY2thYmxlID0gZmFsc2U7XG4gICAgICAgIHNldFRpbWVvdXQoKCkgPT4ge1xuICAgICAgICAgICAgY2xpY2thYmxlID0gdHJ1ZTtcbiAgICAgICAgfSwgMTAwMCk7XG4gICAgfSxcbiAgICBvcGVuUHJpbWUoKSB7XG4gICAgICAgIGNvbnNvbGUubG9nKGBbYWNjb3VudCBqc10gb3BlbiBwcmltZTogJHskZGF0YS51c2VyQXV0aC5wcmltZS51cmx9YCk7XG4gICAgICAgICRldmVudC51Yy5vcGVuUm91dGUoJGRhdGEudXNlckF1dGgucHJpbWUudXJsKTtcbiAgICB9LFxuICAgIG9wZW5ETUMoKSB7XG4gICAgICAgICRldmVudC51Yy5vcGVuUm91dGUoJGRhdGEudXNlckF1dGguZG1jLnVybCk7XG4gICAgfSxcbiAgICBvcGVuS1lDKCkge1xuICAgICAgICAkZXZlbnQudWMub3BlblJvdXRlKCRkYXRhLnVzZXJBdXRoLmt5Yy51cmwpO1xuICAgIH0sXG4gICAgYXN5bmMgY29weVVJRCgpIHtcbiAgICAgICAgdHJ5IHtcbiAgICAgICAgICAgIGF3YWl0ICRuYXRpdmVBUEkuY2xpcEJvYXJkKEpTT04uc3RyaW5naWZ5KHtcbiAgICAgICAgICAgICAgICBsYWJlbDogXCJcIixcbiAgICAgICAgICAgICAgICBjb250ZW50OiBuYXRpdmVEYXRhLnVpZCxcbiAgICAgICAgICAgICAgICB0b2FzdDogJGkxOG4ubl91c2VyX2NlbnRlcl9jb3B5X3Bhc3RlYm9hcmRcbiAgICAgICAgICAgIH0pKVxuICAgICAgICB9IGNhdGNoIChlcnJvcikge1xuICAgICAgICAgICAgY29uc29sZS5sb2coYGNvcHkgY2xpcGJvYXJkIGVycm9yOiR7ZXJyb3J9YCk7XG4gICAgICAgIH1cbiAgICB9XG59O1xuXG4kZXZlbnQub25SZWZyZXNoID0gZnVuY3Rpb24oKSB7XG4gICAgaWYgKG5hdGl2ZURhdGEuaXNMb2dpbikge1xuICAgICAgICByZXF1ZXN0SG9tZUxvZ2luRGF0YSgpO1xuICAgIH0gZWxzZSB7XG4gICAgICAgIHJlcXVlc3RIb21lTm90TG9naW5EYXRhKCk7XG4gICAgfVxufVxuXG5hc3luYyBmdW5jdGlvbiByZXF1ZXN0SG9tZU5vdExvZ2luRGF0YSgpIHtcbiAgICBjb25zdCBwYXJhbSA9IHtcbiAgICAgICAgcGxhdGZvcm06IG5hdGl2ZURhdGEucGxhdGZvcm0sXG4gICAgICAgIG5pZ2h0TW9kZTogbmF0aXZlRGF0YS5uaWdodE1vZGUsXG4gICAgICAgIG1vZHVsZVNpemU6IDIwXG4gICAgfTtcbiAgICBjb25zdCByZXF1ZXN0UGFyYW1zID0gZ2VuZXJhdGVQYXJhbXMoXG4gICAgICAgIFwidjEvaGJnL215aG9tZS9ob21lTm90TG9naW5cIiwgcGFyYW1cbiAgICApO1xuICAgIHNob3dMb2FkaW5nKDEpO1xuICAgIHRyeSB7XG4gICAgICAgIGNvbnN0IHJlc3BvbnNlU3RyaW5nID0gYXdhaXQgJG5hdGl2ZUFQSS5yZXF1ZXN0KHJlcXVlc3RQYXJhbXMpO1xuICAgICAgICBjb25zdCB7IGNvZGUsIGRhdGEgfSA9IEpTT04ucGFyc2UocmVzcG9uc2VTdHJpbmcpO1xuICAgICAgICBzaG93TG9hZGluZygwKTtcbiAgICAgICAgJGRhdGEudWMucmVmcmVzaCA9IFwiMlwiO1xuICAgICAgICBpZiAoY29kZSA9PSAyMDApIHtcbiAgICAgICAgICAgIGhhbmRsZVVuTG9naW5SZXMoZGF0YSk7XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICBjb25zb2xlLmxvZyhgaG9tZU5vdExvZ2luIHJlcXVlc3QgZXJyb3IgY29kZToke2NvZGV9YCk7XG4gICAgICAgIH1cbiAgICB9IGNhdGNoIChlKSB7XG4gICAgICAgIHNob3dMb2FkaW5nKDApO1xuICAgICAgICAkZGF0YS51Yy5yZWZyZXNoID0gXCIyXCI7XG4gICAgICAgIGNvbnNvbGUubG9nKGBob21lTm90TG9naW4gcmVxdWVzdCBlcnJvcjoke2V9YCk7XG4gICAgfVxufTtcblxuYXN5bmMgZnVuY3Rpb24gcmVxdWVzdEhvbWVMb2dpbkRhdGEoKSB7XG4gICAgY29uc3QgcGFyYW0gPSB7XG4gICAgICAgIHBsYXRmb3JtOiBuYXRpdmVEYXRhLnBsYXRmb3JtLFxuICAgICAgICBuaWdodE1vZGU6IG5hdGl2ZURhdGEubmlnaHRNb2RlLFxuICAgICAgICBtb2R1bGVTaXplOiAyMFxuICAgIH07XG4gICAgY29uc3QgcmVxdWVzdFBhcmFtcyA9IGdlbmVyYXRlUGFyYW1zKFxuICAgICAgICBcInYxL2hiZy9teWhvbWUvaG9tZUxvZ2luXCIsIHBhcmFtXG4gICAgKTtcbiAgICBzaG93TG9hZGluZygxKTtcbiAgICB0cnkge1xuICAgICAgICBjb25zdCByZXNwb25zZVN0cmluZyA9IGF3YWl0ICRuYXRpdmVBUEkucmVxdWVzdChyZXF1ZXN0UGFyYW1zKTtcbiAgICAgICAgY29uc3QgeyBjb2RlLCBkYXRhIH0gPSBKU09OLnBhcnNlKHJlc3BvbnNlU3RyaW5nKTtcbiAgICAgICAgc2hvd0xvYWRpbmcoMCk7XG4gICAgICAgICRkYXRhLnVjLnJlZnJlc2ggPSBcIjJcIjtcbiAgICAgICAgaWYgKGNvZGUgPT0gMjAwKSB7XG4gICAgICAgICAgICBoYW5kbGVMb2dpblJlcyhkYXRhKTtcbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIGNvbnNvbGUubG9nKGBob21lTG9naW4gcmVxdWVzdCBlcnJvciBjb2RlOiR7Y29kZX1gKTtcbiAgICAgICAgfVxuICAgIH0gY2F0Y2ggKGUpIHtcbiAgICAgICAgc2hvd0xvYWRpbmcoMCk7XG4gICAgICAgICRkYXRhLnVjLnJlZnJlc2ggPSBcIjJcIjtcbiAgICAgICAgY29uc29sZS5sb2coYGhvbWVMb2dpbiByZXF1ZXN0IGVycm9yOiR7ZX1gKTtcbiAgICB9XG59O1xuXG5hc3luYyBmdW5jdGlvbiByZXF1ZXN0UmVtb3ZlVXNlclJlZERvdChqdW1wVHlwZSkge1xuICAgIGNvbnN0IHBhcmFtID0ge1xuICAgICAgICB0eXBlOiBqdW1wVHlwZVxuICAgIH07XG4gICAgY29uc3QgcmVxdWVzdFBhcmFtcyA9IGdlbmVyYXRlUGFyYW1zKFxuICAgICAgICBcInYxL2hiZy9teWhvbWUvcmVkRG90L3JlbW92ZVVzZXJSZWREb3RcIiwgcGFyYW1cbiAgICApO1xuICAgIHRyeSB7XG4gICAgICAgIGNvbnN0IHJlc3BvbnNlU3RyaW5nID0gYXdhaXQgJG5hdGl2ZUFQSS5yZXF1ZXN0KHJlcXVlc3RQYXJhbXMpO1xuICAgICAgICBjb25zdCB7IGNvZGUgfSA9IEpTT04ucGFyc2UocmVzcG9uc2VTdHJpbmcpO1xuICAgICAgICBpZiAoY29kZSAhPT0gMjAwKSB7XG4gICAgICAgICAgICBjb25zb2xlLmxvZyhgcmVtb3ZlVXNlclJlZERvdCByZXF1ZXN0IGVycm9yIGNvZGU6JHtjb2RlfWApO1xuICAgICAgICB9XG4gICAgfSBjYXRjaCAoZSkge1xuICAgICAgICBjb25zb2xlLmxvZyhgcmVtb3ZlVXNlclJlZERvdCByZXF1ZXN0IGVycm9yOiR7ZX1gKTtcbiAgICB9XG59O1xuXG5mdW5jdGlvbiBoYW5kbGVVbkxvZ2luUmVzKGRhdGEpIHtcbiAgICAkZXZlbnQudWNIZWFkZXIuc2hvd1dlbGNvbWUobmF0aXZlRGF0YSwgZGF0YS50aXRsZSwgZGF0YS50aXRsZUhpZ2hsaWdodCk7XG4gICAgdmFyIG5ld0RhdGEgPSBbXTtcbiAgICBoYW5kbGVDZWxsbGlzdChkYXRhLmxpc3QsIG5ld0RhdGEpO1xuICAgICRkYXRhLnVjLmxpc3QgPSBuZXdEYXRhO1xuICAgIGNvbnNvbGUubG9nKFwibm90bG9naW5kYXRhOiVvXCIsICRkYXRhLnVjLnJhd09iamVjdCgpKTtcbn1cblxuZnVuY3Rpb24gaGFuZGxlTG9naW5SZXMoZGF0YSkge1xuICAgICRkYXRhLnVjLnByaW1lID0gZGF0YS5wcmltZTtcbiAgICAkZXZlbnQudWNIZWFkZXIuc2hvd0xvZ2luKG5hdGl2ZURhdGEsIGRhdGEucHJpbWUpO1xuICAgICRkYXRhLnVjLmxpc3QgPSBoYW5kbGVsb2dpbkRhdGEoZGF0YSk7XG4gICAgY29uc29sZS5sb2coYFthY2NvdW50IGpzXSBsb2dpbmRhdGE6ICR7SlNPTi5zdHJpbmdpZnkoJGRhdGEudWMucmF3T2JqZWN0KCkpfWApO1xufVxuXG4vLyDnu4Too4VjZWxs5pWw5o2uXG5mdW5jdGlvbiBoYW5kbGVsb2dpbkRhdGEobG9naW5EYXRhKSB7XG4gICAgdmFyIGNlbGxEYXRhID0gW107XG4gICAgdmFyIGxpbmVNb2RlbCA9IHsgdHlwZTogXCJkaXZpZGVyXCIgfTtcbiAgICB2YXIgZmVhdHVyZXMgPSBbXTtcbiAgICBjb25zdCBsaXN0VHdvID0gbG9naW5EYXRhLmZlYXR1cmVzO1xuICAgIGlmIChsaXN0VHdvICYmIGxpc3RUd28ubGVuZ3RoID4gMCkge1xuICAgICAgICBmb3IgKGxldCBpID0gMDsgaSA8IGxpc3RUd28ubGVuZ3RoOyBpKyspIHtcbiAgICAgICAgICAgIGxldCBlbCA9IGxpc3RUd29baV07XG4gICAgICAgICAgICBpZiAobmF0aXZlRGF0YS5uaWdodE1vZGUgJiYgIWlzRW1wdHlTdHJpbmcoZWwuaW1nTmlnaHQpKSB7XG4gICAgICAgICAgICAgICAgZWwuaW1nID0gZWwuaW1nTmlnaHQ7XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICBpZiAoaXNFbXB0eVN0cmluZyhlbC5pbWcpKSB7XG4gICAgICAgICAgICAgICAgZWwuaW1nID0gXCJAZHJhd2FibGUvaG9tZV9vcGVyYXRpb25fcGxhY2Vob2xkZXJcIjtcbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIGZlYXR1cmVzW2ldID0gZWw7XG4gICAgICAgIH1cbiAgICAgICAgJGRhdGEudWMuZmVhdHVyZVZpc2liaWxpdHkgPSBcInZpc2libGVcIjtcbiAgICAgICAgJGRhdGEudWMuZmVhdHVyZXMgPSBmZWF0dXJlcztcbiAgICB9IGVsc2Uge1xuICAgICAgICAkZGF0YS51Yy5mZWF0dXJlVmlzaWJpbGl0eSA9IFwiZ29uZVwiO1xuICAgIH1cblxuICAgIGlmIChsb2dpbkRhdGEubGlzdCkge1xuICAgICAgICBmb3IgKGxldCBpbmRleCA9IDA7IGluZGV4IDwgbG9naW5EYXRhLmxpc3QubGVuZ3RoOyBpbmRleCsrKSB7XG4gICAgICAgICAgICBjb25zdCBlbGVtZW50ID0gbG9naW5EYXRhLmxpc3RbaW5kZXhdO1xuICAgICAgICAgICAgaGFuZGxlQ2VsbGxpc3QoZWxlbWVudCwgY2VsbERhdGEpO1xuICAgICAgICAgICAgaWYgKGluZGV4IDwgbG9naW5EYXRhLmxpc3QubGVuZ3RoIC0gMSkge1xuICAgICAgICAgICAgICAgIGNlbGxEYXRhLnB1c2gobGluZU1vZGVsKTtcbiAgICAgICAgICAgIH1cbiAgICAgICAgfVxuICAgIH1cbiAgICByZXR1cm4gY2VsbERhdGE7XG59O1xuXG5mdW5jdGlvbiBoYW5kbGVDZWxsbGlzdChsaXN0RGF0YSwgY2VsbERhdGEpIHtcbiAgICBmb3IgKGxldCBpID0gMDsgaSA8IGxpc3REYXRhLmxlbmd0aDsgaSsrKSB7XG4gICAgICAgIGxldCBlbCA9IGxpc3REYXRhW2ldO1xuICAgICAgICBlbC5iYWNrVmlzaWJsZSA9IG1vZGVsLmJhY2tWaXNpYmxlO1xuICAgICAgICBlbC5ub3JtYWxWaXNpYmxlID0gbW9kZWwubm9ybWFsVmlzaWJsZTtcblx0XHRlbC5qdW1wVHlwZSA9IGAke2VsLnR5cGV9YDtcbiAgICAgICAgZWwudHlwZSA9IG1vZGVsLnR5cGU7XG5cdFx0aWYgKGVsLnJlZERvdFR5cGUgJiYgZWwucmVkRG90VHlwZSA9PSAxICYmIGVsLnJlZERvdE51bSA+IDApIHtcblx0XHRcdGVsLnNob3dSZWREb3QgPSBcImdvbmVcIjtcblx0XHRcdGVsLm51bVJlZERvdCA9IFwidmlzaWJsZVwiO1xuXHRcdFx0ZWwucmVkRG90TnVtU3RyID0gYCR7ZWwucmVkRG90TnVtfWA7XG5cdFx0fSBlbHNlIGlmIChlbC5pc1JlZERvdCkge1xuXHRcdFx0ZWwuc2hvd1JlZERvdCA9IFwidmlzaWJsZVwiO1xuXHRcdFx0ZWwubnVtUmVkRG90ID0gXCJnb25lXCI7XG5cdFx0fSBlbHNlIHtcblx0XHRcdGVsLnNob3dSZWREb3QgPSBcImdvbmVcIjtcblx0XHRcdGVsLm51bVJlZERvdCA9IFwiZ29uZVwiO1xuXHRcdH1cblxuICAgICAgICBpZiAoZWwubmFtZVR5cGUgPT0gJ+aIkeeahOmCgOivt+i/lOS9oycpIHtcbiAgICAgICAgICAgIGlmICghaXNFbXB0eVN0cmluZyhlbC50aXRsZSkpIHtcbiAgICAgICAgICAgICAgICBlbC5iYWNrQ29sb3IgPSBtb2RlbC5iYWNrQ29sb3I7XG4gICAgICAgICAgICAgICAgZWwuYmFja1Zpc2libGUgPSBcInZpc2libGVcIjtcbiAgICAgICAgICAgIH1cbiAgICAgICAgfSBlbHNlIGlmIChlbC5uYW1lVHlwZSA9PSAn5oiR55qE6aKE57qmJykge1xuICAgICAgICAgICAgaWYgKCFpc0VtcHR5U3RyaW5nKGVsLnRpdGxlKSkge1xuICAgICAgICAgICAgICAgIGVsLmJhY2tDb2xvciA9IFwiI0U5NDM1OVwiO1xuICAgICAgICAgICAgICAgIGVsLmJhY2tWaXNpYmxlID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgICAgICB9XG4gICAgICAgIH0gZWxzZSBpZiAoZWwubmFtZVR5cGUgPT0gJ+WFs+S6jueBq+W/hScgfHwgZWwubmFtZVR5cGUgPT0gJ+WFs+S6jueBq+W4gScpIHtcbiAgICAgICAgICAgIGlmIChuYXRpdmVEYXRhLmhhc05ld1ZlcnNpb24pIHtcbiAgICAgICAgICAgICAgICBlbC5ub3JtYWxWaXNpYmxlID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgICAgICAgICAgZWwuc2hvd1JlZERvdCA9IFwidmlzaWJsZVwiO1xuXHRcdFx0XHRlbC5udW1SZWREb3QgPSBcImdvbmVcIjtcbiAgICAgICAgICAgICAgICBlbC50aXRsZSA9IGAkeyRpMThuLm5fdXNlcl9jZW50ZXJfZGlzY292ZXJfbmV3X3ZlcnNpb259YDtcbiAgICAgICAgICAgIH1cbiAgICAgICAgfSBlbHNlIGlmIChlbC5uYW1lVHlwZSA9PSBcIuivreiogOiuvue9rlwiKSB7XG4gICAgICAgICAgICBlbC5ub3JtYWxWaXNpYmxlID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgICAgICBlbC50aXRsZSA9IG5hdGl2ZURhdGEubGFuZ3VhZ2U7XG4gICAgICAgIH0gZWxzZSBpZiAoIWlzRW1wdHlTdHJpbmcoZWwudGl0bGUpKSB7XG4gICAgICAgICAgICBlbC5ub3JtYWxWaXNpYmxlID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgIH1cblxuICAgICAgICBjZWxsRGF0YS5wdXNoKGVsKTtcbiAgICB9XG59XG4iLCJpbXBvcnQgeyBpc0VtcHR5U3RyaW5nIH0gZnJvbSBcIi4vdXRpbFwiO1xuXG4kZGF0YS5wb3N0ZXJzaGFyaW5nID0ge1xuXHRhdmF0YXI6IFwiXCIsXG5cdG5hbWU6IFwiXCIsXG5cdGFydGljbGVOdW06IFwiMFwiLFxuXHRwcmFpc2VOdW06IFwiMFwiLFxufVxuXG4kZXZlbnQucG9zdGVyc2hhcmluZyA9IHtcblx0c2hhcmVXaXRoUGFyYW1zIChwYXJhbXNKc29uKSB7XG5cdFx0Y29uc3QgcGFyYW1zID0gSlNPTi5wYXJzZShwYXJhbXNKc29uKTtcblx0XHQkZGF0YS5wb3N0ZXJzaGFyaW5nLmF2YXRhciA9IHBhcmFtcy5hdmF0YXI7XG5cdFx0JGRhdGEucG9zdGVyc2hhcmluZy5uYW1lID0gcGFyYW1zLm5pY2tOYW1lO1xuXHRcdCRkYXRhLnBvc3RlcnNoYXJpbmcuYXJ0aWNsZU51bSA9IHBhcmFtcy5hcnRpY2xlTnVtO1xuXHRcdCRkYXRhLnBvc3RlcnNoYXJpbmcucHJhaXNlTnVtID0gcGFyYW1zLnByYWlzZU51bTtcblx0XHQvLyDlsZXnpLrliIbkuqvlvLnnqpdcblx0XHQkbmF0aXZlQVBJLnNoYXJlQWJpbGl0eSh7XG5cdFx0XHQndHlwZSc6ICdyZW5kZXJTeW5jJyxcblx0XHRcdCd0ZW1wbGF0ZSc6ICdwb3N0ZXJzaGFyaW5nJyxcblx0XHRcdCd3YWl0VGltZSc6IDIsXG5cdFx0XHQnanVtcFVybCc6IHBhcmFtcy5zaGFyZVVybFxuXHRcdH0pO1xuXHR9XG59Il0sIm5hbWVzIjpbImdlbmVyYXRlUGFyYW1zIiwicGF0aCIsInBhcmFtcyIsIm1ldGhvZCIsImhvc3RUeXBlIiwiaGVhZGVyIiwicGFyYW0iLCJjb25zb2xlIiwibG9nIiwiSlNPTiIsInN0cmluZ2lmeSIsImlzRW1wdHlTdHJpbmciLCJzdHJpbmciLCJsZW5ndGgiLCJzaG93TG9hZGluZyIsInNob3ciLCJyZXJzb25hbENlbnRlciIsIndlbGNvbWVEYXRhIiwidHlwZSIsImRlc2MiLCJ1aWQiLCJuaWNrTmFtZSIsInJlZnJlc2hTdGF0dXMiLCJyaWNoVGV4dCIsImZ1bmNTaG93Iiwia3ljQXV0aERpYyIsImltZyIsInRpdGxlIiwidXJsIiwidmlzaWJsZSIsImltZ1Zpc2libGUiLCJyZWREb3RWaXNpYmxlIiwidGV4dENvbG9yIiwiYmFja0NvbG9yIiwiJGRhdGEiLCJ1c2VyQXV0aCIsInByaW1lIiwiZG1jIiwia3ljIiwidWlkVW5pcXVlIiwiaGVhZFNlY3Rpb24iLCJjdXJyZW50QWNjb3VudCIsImt5Y1dpZHRoIiwiJGV2ZW50IiwidWNIZWFkZXIiLCJjbGVhckRhdGEiLCJzaG93V2VsY29tZSIsIm5hdGl2ZURhdGEiLCJoaWdobGlnaHQiLCJoZWFkZXJEYXRhIiwiYWNjb3VudCIsImNvbG9yIiwibmlnaHRNb2RlIiwic3BhblN0YXJ0Iiwic3BhbkVuZCIsInJpY2hIaWdobGlnaHQiLCJqb2luVGV4dCIsInNwbGl0Iiwiam9pbiIsIiRpMThuIiwibl9sb2dpbl9sYXN0XzNyZF9sb2dpbl9oaW50Iiwic2hvd0xvZ2luIiwiY2hpbGRBY2NvdW50IiwiaGFuZGxlUHJpbWVEYXRhIiwib3BlbkxvZ2luIiwianVtcFR5cGUiLCJ1YyIsIm9wZW5Sb3V0ZSIsIm9wZW5QcmVyc29uYWxDZW50ZXIiLCJyZXF1ZXN0UGFyYW1zIiwicmVzcG9uc2VTdHJpbmciLCIkbmF0aXZlQVBJIiwicmVxdWVzdCIsImNvZGUiLCJkYXRhIiwicGFyc2UiLCJvcGVuVXJsIiwiZSIsInJlZnJlc2giLCJyZXF1ZXN0S3ljQXV0aEluZm8iLCJpc0luc3RVc2VyIiwicmVxdWVzdEluc3RJbmZvIiwicmVxdWVzdEt5Y0F1dGhJbmZvVjIiLCJhc3luYyIsInJlc3BvbnNlIiwiaHVuZGxlRG1jRGF0YSIsImhhbmRsZUt5Y0RhdGEiLCJIQklnbm9yZUZhaWx1cmVUb2FzdCIsImluc3REaWMiLCJzdGF0ZSIsImxldmVsVHlwZSIsInJhd09iamVjdCIsInNob3dQcmltZSIsImxldmVsIiwidXNlckxldmVsIiwiZG1jRGljIiwiZW50cmFuY2VOYW1lIiwiZmxhZ2hvc3QiLCJlbnRyYW5jZUNvdW50cnlJZCIsImVudHJhbmNlVXJsIiwic3RhcnRzV2l0aCIsIndlYmhvc3QiLCJmaW5hbEF1dGhTdGF0ZSIsInNob3dPbGRFbnRyYW5jZSIsInByb19zdGF0dXMiLCJhdXRoVHlwZSIsImt5Y0F1dGhUeXBlIiwia3ljRGljIiwiYmFzZUluZm8iLCJjb3VudHJ5SWQiLCJuX3VzZXJfY2VudGVyX2lzX25vdF92ZXJpZnkiLCJuX2t5Y19hdXRoZW50aWNhdGlvbl92ZXJpZnlpbmciLCJuX2t5Y19hdXRoZW50aWNhdGlvbl9mYWlsIiwiYXV0aEluZm8iLCJzdGVwTW9kZWxEaWMiLCJpbmRleCIsInN0ZXBTdGF0ZXMiLCJlbGVtZW50IiwiYXV0aFN0ZXAiLCJ0b1VwcGVyQ2FzZSIsImMwIiwiYzEiLCJjMiIsImF1dGhTdGF0ZSIsImlzTG9naW4iLCJwbGF0Zm9ybSIsImhhc05ld1ZlcnNpb24iLCJsYW5ndWFnZSIsIm1vZGVsIiwibmFtZSIsImltZ05pZ2h0Iiwibm9ybWFsVmlzaWJsZSIsImJhY2tWaXNpYmxlIiwidWNEYXRhIiwiZmVhdHVyZXMiLCJmZWF0dXJlVmlzaWJpbGl0eSIsImxpc3QiLCJjbGlja2FibGUiLCJ2aWV3V2lsbEFwcGVhciIsIm5hdGljZUpzb24iLCJuZXdOYXRpdmVEYXRhIiwicmVxdWVzdEhvbWVMb2dpbkRhdGEiLCJyZXF1ZXN0SG9tZU5vdExvZ2luRGF0YSIsInJvdXRlVXJsIiwicmVxdWVzdFJlbW92ZVVzZXJSZWREb3QiLCJzZXRUaW1lb3V0Iiwib3BlblByaW1lIiwib3BlbkRNQyIsIm9wZW5LWUMiLCJjb3B5VUlEIiwiY2xpcEJvYXJkIiwibGFiZWwiLCJjb250ZW50IiwidG9hc3QiLCJuX3VzZXJfY2VudGVyX2NvcHlfcGFzdGVib2FyZCIsImVycm9yIiwib25SZWZyZXNoIiwibW9kdWxlU2l6ZSIsImhhbmRsZVVuTG9naW5SZXMiLCJoYW5kbGVMb2dpblJlcyIsInRpdGxlSGlnaGxpZ2h0IiwibmV3RGF0YSIsImhhbmRsZUNlbGxsaXN0IiwiaGFuZGxlbG9naW5EYXRhIiwibG9naW5EYXRhIiwiY2VsbERhdGEiLCJsaW5lTW9kZWwiLCJsaXN0VHdvIiwiaSIsImVsIiwicHVzaCIsImxpc3REYXRhIiwicmVkRG90VHlwZSIsInJlZERvdE51bSIsInNob3dSZWREb3QiLCJudW1SZWREb3QiLCJyZWREb3ROdW1TdHIiLCJpc1JlZERvdCIsIm5hbWVUeXBlIiwibl91c2VyX2NlbnRlcl9kaXNjb3Zlcl9uZXdfdmVyc2lvbiIsInBvc3RlcnNoYXJpbmciLCJhdmF0YXIiLCJhcnRpY2xlTnVtIiwicHJhaXNlTnVtIiwic2hhcmVXaXRoUGFyYW1zIiwicGFyYW1zSnNvbiIsInNoYXJlQWJpbGl0eSIsInRlbXBsYXRlIiwid2FpdFRpbWUiLCJqdW1wVXJsIiwic2hhcmVVcmwiXSwibWFwcGluZ3MiOiJBQVFPLFNBQVNBLGVBQWVDLE1BQU1DLFNBQVMsSUFBSUMsU0FBUyxHQUFHQyxXQUFXLEdBQUdDLFNBQVM7SUFDakYsTUFBTUMsUUFBUTtRQUNWTDtRQUNBRTtRQUNBQztRQUNBQztRQUNBSDs7SUFFSkssUUFBUUMsSUFBSSxxQkFBcUJGO0lBQ2pDLE9BQU9HLEtBQUtDLFVBQVVKO0FBQzFCOztBQUVPLFNBQVNLLGNBQWNDO0lBQzFCLEtBQUtBLFVBQVVBLFVBQVUsUUFBUUEsT0FBT0MsVUFBVSxHQUFHO1FBQ2pELE9BQU87QUFDVjtJQUNELE9BQU87QUFDWDs7QUFHTyxTQUFTQyxZQUFZQyxPQUU1Qjs7QUM1QkEsTUFBTUMsaUJBQWlCOztBQUN2QixNQUFNQyxjQUFjO0lBQ2hCQyxNQUFNO0lBQ05DLE1BQU07SUFDTkMsS0FBSztJQUNMQyxVQUFVO0lBQ1ZDLGVBQWU7SUFDZkMsVUFBVTtJQUNWQyxVQUFVOzs7QUFHZCxNQUFNQyxhQUFhO0lBQ2ZDLEtBQUs7SUFDTEMsT0FBTztJQUNQQyxLQUFLO0lBQ0xDLFNBQVM7SUFDVEMsWUFBWTtJQUNmQyxlQUFlO0lBQ1pDLFdBQVc7SUFDWEMsV0FBVzs7O0FBSWZDLE1BQU1DLFdBQVc7SUFDYkMsT0FBT1g7SUFDUFksS0FBS1o7SUFDTGEsS0FBS2I7OztBQUdUUyxNQUFNSyxZQUFZLENBQUE7O0FBRWxCTCxNQUFNTSxjQUFjOztBQUVwQixJQUFJQyxpQkFBaUI7O0FBRXJCUCxNQUFNUSxZQUFZLE1BQU0sTUFBTTs7QUFFOUJDLE9BQU9DLFdBQVc7SUFDZCxTQUFBQztRQUNFWCxNQUFNQyxTQUFTQyxNQUFNUCxVQUFVO1FBQy9CSyxNQUFNQyxTQUFTRSxJQUFJUixVQUFVO1FBQzdCSyxNQUFNQyxTQUFTRyxJQUFJVCxVQUFVO1FBQzdCSyxNQUFNQyxTQUFTRyxJQUFJUCxnQkFBZ0I7UUFDbkNHLE1BQU1RLFlBQVksTUFBTSxNQUFNO1FBQzlCbkMsUUFBUUMsSUFBSTtBQUNiO0lBQ0QsV0FBQXNDLENBQVlDLFlBQVlwQixRQUFRLElBQUlxQixZQUFZO1FBQzVDLElBQUlDLGFBQWFoQztRQUVqQixJQUFJTixjQUFjb0MsV0FBV0csVUFBVTtZQUNuQ0QsV0FBVy9CLE9BQU87WUFDbEIrQixXQUFXOUIsT0FBT1E7WUFDbEIsTUFBTXdCLFFBQVFKLFdBQVdLLFlBQVksWUFBWTtZQUNqRCxJQUFJekMsY0FBY3FDLFlBQVk7Z0JBQzFCQyxXQUFXMUIsV0FBVyxzQkFBc0I0QiwwQkFBMEJ4QjtBQUN0RixtQkFBbUI7Z0JBQ0gsTUFBTTBCLFlBQVksc0JBQXNCRjtnQkFDeEMsTUFBTUcsVUFBVTtnQkFDaEIsSUFBSUMsZ0JBQWdCLEdBQUdELHdEQUF3RE4sb0JBQW9CSztnQkFDbkcsTUFBTUcsV0FBVzdCLE1BQU04QixNQUFNVCxXQUFXVSxLQUFLSDtnQkFDN0NOLFdBQVcxQixXQUFXLEdBQUc4QixZQUFZRyxXQUFXRjtBQUNuRDtZQUNEL0MsUUFBUUMsSUFBSSxjQUFjeUMsV0FBVzFCO0FBQ2pELGVBQWU7WUFDSDBCLFdBQVcvQixPQUFPO1lBQ2xCK0IsV0FBVzlCLE9BQU8sR0FBR3dDLE1BQU1DLCtCQUErQmIsV0FBV0c7QUFDeEU7UUFDRGhCLE1BQU1NLGNBQWMsRUFBQ1M7QUFDeEI7SUFDRCxTQUFBWSxDQUFVZCxZQUFZWDtRQUNsQixJQUFJYSxhQUFhaEM7UUFDakJnQyxXQUFXL0IsT0FBTztRQUNsQitCLFdBQVc3QixNQUFNLFFBQVEyQixXQUFXM0I7UUFDcEM2QixXQUFXNUIsV0FBVzBCLFdBQVcxQjtRQUNqQzRCLFdBQVczQixnQkFBZ0I7UUFDM0IyQixXQUFXekIsV0FBV3VCLFdBQVdlLGVBQWUsU0FBUztRQUN6RHJCLGlCQUFpQk0sV0FBV0c7UUFDNUJoQixNQUFNTSxjQUFjLEVBQUNTO1FBQ3JCYyxnQkFBZ0JoQixZQUFZWDtBQUMvQjtJQUNELFNBQUE0QixDQUFVQyxXQUFXO1FBRWpCdEIsT0FBT3VCLEdBQUdDLFVBQVUsd0VBQXdFRjtBQUMvRjtJQUNELHlCQUFNRyxDQUFvQmhEO1FBQ3RCLE1BQU1tQixZQUFZTCxNQUFNSyxVQUFVbkI7UUFDbEMsS0FBS1QsY0FBYzRCLFlBQVk7WUFDM0JJLE9BQU91QixHQUFHQyxVQUFVLEdBQUduRCx5QkFBeUJ5Qiw0QkFBNEJGO1lBQzVFO0FBQ0g7UUFDRCxNQUFNOEIsZ0JBQWdCckUsZUFDbEIsMENBQTBDLENBQUU7UUFHaEQ7WUFDSSxNQUFNc0UsdUJBQXVCQyxXQUFXQyxRQUFRSDtZQUNoRCxPQUFNSSxNQUFFQSxNQUFJQyxNQUFFQSxRQUFTakUsS0FBS2tFLE1BQU1MO1lBQ2xDeEQsWUFBWTtZQUNaLElBQUkyRCxRQUFRLEtBQUs7Z0JBQ2J2QyxNQUFNSyxVQUFVbkIsT0FBT3NELEtBQUtuQztnQkFDNUIsTUFBTXFDLFVBQVUsR0FBRzVELHlCQUF5QnlCLDRCQUE0QmlDLEtBQUtuQztnQkFDN0VJLE9BQU91QixHQUFHQyxVQUFVUztBQUNwQyxtQkFBbUI7Z0JBQ0hyRSxRQUFRQyxJQUFJLG1DQUFtQ2lFO0FBQ2xEO0FBQ0osVUFBQyxPQUFPSTtZQUVMM0MsTUFBTWdDLEdBQUdZLFVBQVU7WUFDbkJ2RSxRQUFRQyxJQUFJLDhCQUE4QnFFO0FBQzdDO0FBQ0o7SUFDRCx3QkFBTUUsQ0FBbUJoQztRQUNyQixJQUFJQSxXQUFXZSxjQUFjO1lBQ3pCNUIsTUFBTUMsU0FBU0UsSUFBSVIsVUFBVTtZQUM3QkssTUFBTUMsU0FBU0csSUFBSVQsVUFBVTtZQUM3QkssTUFBTUMsU0FBU0csSUFBSVAsZ0JBQWdCO1lBQ25DO0FBQ0g7UUFDRCxNQUFNaUQsbUJBQW1CQztRQUN6QkMscUJBQXFCbkMsWUFBWWlDO0FBQ3BDOzs7QUFHTEcsZUFBZUQscUJBQXFCbkMsWUFBWWlDO0lBQzVDLE1BQU1YLGdCQUFnQnJFLGVBQWUsa0NBQWtDLENBQUEsR0FBSSxHQUFHO0lBQzlFO1FBQ0ksTUFBTXNFLHVCQUF1QkMsV0FBV0MsUUFBUUg7UUFDaEQsTUFBTWUsV0FBVzNFLEtBQUtrRSxNQUFNTDtRQUM1QixPQUFNRyxNQUFFQSxNQUFJQyxNQUFFQSxRQUFTVTtRQUN2QixJQUFJWCxRQUFRLEtBQUs7WUFDYlksY0FBY1gsTUFBTTNCO1lBQ3BCLEtBQUtpQyxZQUFZO2dCQUNiTSxjQUFjWixNQUFNM0I7QUFDdkI7WUFDRCxJQUFJYixNQUFNQyxTQUFTRSxJQUFJUixXQUFXLGFBQ2hDSyxNQUFNQyxTQUFTRSxJQUFJVixTQUFTLFNBQzVCTyxNQUFNQyxTQUFTRyxJQUFJUCxpQkFBaUIsV0FBVztnQkFFL0NHLE1BQU1DLFNBQVNFLElBQUlSLFVBQVU7QUFDOUI7WUFDRCxJQUFJSyxNQUFNQyxTQUFTRSxJQUFJUixXQUFXLFVBQVVLLE1BQU1DLFNBQVNHLElBQUlULFdBQVcsUUFBUTtnQkFDaEZLLE1BQU1RLFlBQVksTUFBTSxNQUFNO0FBQzVDLG1CQUFtQjtnQkFDTFIsTUFBTVEsWUFBWSxNQUFNLE1BQU07QUFDL0I7QUFDYixlQUFlO1lBQ0huQyxRQUFRQyxJQUFJLGtDQUFrQ2lFO0FBQ2pEO0FBQ0osTUFBQyxPQUFPSTtRQUNMdEUsUUFBUUMsSUFBSSw2QkFBNkJxRTtBQUM1QztBQUNMOztBQUdBTSxlQUFlRjtJQUNYLE1BQU1aLGdCQUFnQnJFLGVBQ2xCLHVEQUF1RCxDQUFFLEdBQUUsR0FBRyxHQUFHO1FBQUV1RixzQkFBc0I7O0lBQzdGO1FBQ0ksTUFBTWpCLHVCQUF1QkMsV0FBV0MsUUFBUUg7UUFDaEQsTUFBTWUsV0FBVzNFLEtBQUtrRSxNQUFNTDtRQUM1QixPQUFNRyxNQUFFQSxNQUFJQyxNQUFFQSxRQUFTVTtRQUN2QixJQUFJWCxRQUFRLEtBQUs7WUFDYixJQUFJQyxRQUFRQSxRQUFRLE1BQU07Z0JBQ3RCLElBQUljLFVBQVUvRDtnQkFDZCtELFFBQVF4RCxZQUFZO2dCQUNwQndELFFBQVExRCxhQUFhO2dCQUNyQjBELFFBQVE1RCxNQUFNO2dCQUVkLElBQUk4QyxLQUFLZSxTQUFTLEtBQUtmLEtBQUtlLFNBQVMsS0FBS2YsS0FBS2UsU0FBUyxHQUFHO29CQUN2RCxJQUFJZixLQUFLZSxTQUFTLEdBQUc7d0JBQ2pCRCxRQUFRN0QsUUFBUTt3QkFDaEI2RCxRQUFROUQsTUFBTTt3QkFDZDhELFFBQVExRCxhQUFhO0FBQzdDLDJCQUEyQixJQUFJNEMsS0FBS2UsU0FBUyxHQUFHO3dCQUN4QixJQUFJZixLQUFLZ0IsYUFBYSxHQUFHOzRCQUNyQkYsUUFBUTdELFFBQVE7QUFDNUMsK0JBQStCLElBQUkrQyxLQUFLZ0IsYUFBYSxHQUFHOzRCQUM1QkYsUUFBUTdELFFBQVE7QUFDNUMsK0JBQStCOzRCQUNINkQsUUFBUTdELFFBQVE7QUFDbkI7QUFDekIsMkJBQTJCO3dCQUNINkQsUUFBUTdELFFBQVE7d0JBQ2hCNkQsUUFBUXhELFlBQVk7QUFDdkI7b0JBQ0RFLE1BQU1DLFNBQVNHLE1BQU1rRDtvQkFDckIsT0FBTztBQUNWO0FBQ0o7WUFDRCxPQUFPO0FBQ25CLGVBQWU7WUFDSGpGLFFBQVFDLElBQUksMkJBQTJCaUU7WUFDdkMsT0FBTztBQUNWO0FBQ0osTUFBQyxPQUFPSTtRQUNMdEUsUUFBUUMsSUFBSSxzQkFBc0JxRTtRQUNsQyxPQUFPO0FBQ1Y7QUFDTDs7QUFFQSxTQUFTZCxnQkFBZ0JoQixZQUFZWDtJQUNqQzdCLFFBQVFDLElBQUksa0NBQWtDQyxLQUFLQyxVQUFVd0IsTUFBTUMsU0FBU0MsTUFBTXVEO0lBQ2xGLElBQUk1QyxXQUFXZSxpQkFBaUIxQixTQUFTQSxTQUFTLE1BQU07UUFDcERGLE1BQU1DLFNBQVNDLE1BQU1QLFVBQVU7UUFDL0I7QUFDSDtJQUNELElBQUkrRCxZQUFZLENBQUE7SUFDaEIsSUFBSXhELE1BQU15RCxRQUFRLEdBQUc7UUFDakJELFVBQVUzRCxZQUFZYyxXQUFXSyxZQUFZLFlBQVk7UUFDekR3QyxVQUFVNUQsWUFBWWUsV0FBV0ssWUFBWSxZQUFZO1FBQ3pEd0MsVUFBVWxFLE1BQU07QUFDeEIsV0FBVyxJQUFJVSxNQUFNeUQsUUFBUSxHQUFHO1FBQ3hCRCxVQUFVM0QsWUFBWWMsV0FBV0ssWUFBWSxZQUFZO1FBQ3pEd0MsVUFBVTVELFlBQVllLFdBQVdLLFlBQVksWUFBWTtRQUN6RHdDLFVBQVVsRSxNQUFNO0FBQ3hCLFdBQVcsSUFBSVUsTUFBTXlELFFBQVEsR0FBRztRQUN4QkQsVUFBVTNELFlBQVljLFdBQVdLLFlBQVksWUFBWTtRQUN6RHdDLFVBQVU1RCxZQUFZZSxXQUFXSyxZQUFZLFlBQVk7UUFDekR3QyxVQUFVbEUsTUFBTTtBQUN4QixXQUFXLElBQUlVLE1BQU15RCxRQUFRLElBQUk7UUFDekJELFVBQVUzRCxZQUFZYyxXQUFXSyxZQUFZLFlBQVk7UUFDekR3QyxVQUFVNUQsWUFBWWUsV0FBV0ssWUFBWSxZQUFZO1FBQ3pEd0MsVUFBVWxFLE1BQU07QUFDeEIsV0FBVztRQUNIa0UsVUFBVTNELFlBQVljLFdBQVdLLFlBQVksWUFBWTtRQUN6RHdDLFVBQVU1RCxZQUFZZSxXQUFXSyxZQUFZLFlBQVk7UUFDekR3QyxVQUFVbEUsTUFBTTtBQUNuQjtJQUNEa0UsVUFBVWhFLE1BQU1RLE1BQU1SO0lBQ3RCLE1BQU1rRSxZQUFZMUQsTUFBTXlELFFBQVEsSUFBSXpELE1BQU15RCxRQUFRLElBQUk7SUFDdERELFVBQVVqRSxRQUFRLFNBQVNtRTtJQUMzQkYsVUFBVS9ELFVBQVVPLE1BQU15RCxTQUFTLE9BQU8sU0FBUztJQUNuRDNELE1BQU1DLFNBQVNDLFFBQVF3RDtJQUN2QnJGLFFBQVFDLElBQUksMkJBQTJCQyxLQUFLQyxVQUFVa0Y7QUFDMUQ7O0FBR0EsU0FBU1AsY0FBY1gsTUFBTTNCO0lBQ3pCLElBQUlnRCxTQUFTdEU7SUFDYixJQUFJZCxjQUFjK0QsS0FBS3NCLGVBQWU7UUFDbENELE9BQU9sRSxVQUFVO0FBQ3pCLFdBQVc7UUFDSGtFLE9BQU9wRSxRQUFRK0MsS0FBS3NCO1FBQ3BCRCxPQUFPckUsTUFBTSxHQUFHcUIsV0FBV2tELHdDQUF3Q3ZCLEtBQUt3QjtRQUN4RUgsT0FBT2pFLGFBQWE7UUFDcEIsSUFBSTRDLEtBQUt5QixZQUFZQyxXQUFXLGFBQWE7WUFDekNMLE9BQU9uRSxNQUFNOEMsS0FBS3lCO0FBQzlCLGVBQWU7WUFDSEosT0FBT25FLE1BQU0sR0FBR21CLFdBQVdzRCxVQUFVM0IsS0FBS3lCO0FBQzdDO1FBQ0RKLE9BQU9sRSxVQUFVO0FBQ3BCO0lBQ0RLLE1BQU1DLFNBQVNFLE1BQU0wRDtBQUN6Qjs7QUFHQSxTQUFTVCxjQUFjWixNQUFNM0I7SUFDekIsSUFBSTJCLEtBQUs0QixtQkFBbUIsS0FBSzVCLEtBQUs2QixtQkFBbUJ4RCxXQUFXeUQsZUFBZSxHQUFHO1FBR2xGLE1BQU1DLFdBQVdDLFlBQVloQyxNQUFNM0IsV0FBV3lEO1FBQzlDLElBQUlHLFNBQVNsRjtRQUNia0YsT0FBTzFFLFlBQVk7UUFDbkIwRSxPQUFPM0UsWUFBWTtRQUNuQjJFLE9BQU85RSxVQUFVO1FBQ2pCOEUsT0FBTzdFLGFBQWE7UUFDcEI2RSxPQUFPNUUsZ0JBQWdCO1FBQ3ZCNEUsT0FBTy9FLE1BQU07UUFDYixJQUFJNkUsWUFBWSxLQUFLQSxZQUFZLEtBQUtBLFlBQVksR0FBRztZQUNqREUsT0FBTzdFLGFBQWE7WUFDcEI2RSxPQUFPakYsTUFBTSxHQUFHcUIsV0FBV2tELHdDQUF3Q3ZCLEtBQUtrQyxTQUFTQztBQUNwRjtRQUNELFFBQVFKO1VBQ0osS0FBSztZQUNERSxPQUFPaEYsUUFBUTtZQUNmOztVQUNKLEtBQUs7WUFDRGdGLE9BQU9oRixRQUFRO1lBQ2Y7O1VBQ0osS0FBSztZQUNEZ0YsT0FBT2hGLFFBQVE7WUFDZjs7VUFDSixLQUFLO1lBQ0RnRixPQUFPaEYsUUFBUSxHQUFHZ0MsTUFBTW1EO1lBQ3hCSCxPQUFPNUUsZ0JBQWdCO1lBQ3ZCNEUsT0FBTzFFLFlBQVk7WUFDbkIwRSxPQUFPM0UsWUFBWTtZQUNuQjs7VUFDSixLQUFLO1lBQ0QyRSxPQUFPaEYsUUFBUSxHQUFHZ0MsTUFBTW9EO1lBQ3hCSixPQUFPakYsTUFBTTtZQUNiaUYsT0FBTzdFLGFBQWE7WUFDcEI7O1VBQ0osS0FBSztZQUNENkUsT0FBT2hGLFFBQVEsR0FBR2dDLE1BQU1tRDtZQUN4QkgsT0FBTzVFLGdCQUFnQjtZQUN2QjRFLE9BQU8xRSxZQUFZO1lBQ25CMEUsT0FBTzNFLFlBQVk7WUFDbkI7O1VBQ0osS0FBSztZQUNEMkUsT0FBT2hGLFFBQVEsR0FBR2dDLE1BQU1xRDtZQUN4QkwsT0FBTzNFLFlBQVk7WUFDbkI7O1VBQ0o7WUFDSTJFLE9BQU9oRixRQUFRLEdBQUdnQyxNQUFNbUQ7WUFDeEJILE9BQU81RSxnQkFBZ0I7WUFDdkI0RSxPQUFPMUUsWUFBWTtZQUNuQjBFLE9BQU8zRSxZQUFZO1lBQ25COztRQUVSRSxNQUFNQyxTQUFTRyxNQUFNcUU7QUFDN0IsV0FBVztRQUNIekUsTUFBTUMsU0FBU0csSUFBSVQsVUFBVTtRQUM3QkssTUFBTUMsU0FBU0csSUFBSVAsZ0JBQWdCO0FBQ3RDO0FBQ0w7O0FBR0EsU0FBUzJFLFlBQVlPLFVBQVVUO0lBQzNCLElBQUlVLGVBQWUsQ0FBQTtJQUNuQixLQUFLLElBQUlDLFFBQVEsR0FBR0EsUUFBUUYsU0FBU0csV0FBV3ZHLFFBQVFzRyxTQUFTO1FBQzdELE1BQU1FLFVBQVVKLFNBQVNHLFdBQVdEO1FBQ3BDRCxhQUFhRyxRQUFRQyxTQUFTQyxpQkFBaUJGO0FBQ2xEO0lBQ0QsSUFBSVosV0FBVztJQUNmLE1BQU1lLEtBQUtOLGFBQWE7SUFDeEIsTUFBTU8sS0FBS1AsYUFBYTtJQUN4QixNQUFNUSxLQUFLUixhQUFhO0lBRXhCLElBQUlRLE1BQU1BLEdBQUdDLGFBQWEsR0FBRztRQUN6QmxCLFdBQVc7QUFDZCxXQUFNLElBQUlnQixNQUFNQSxHQUFHRSxhQUFhLEdBQUc7UUFDaENsQixXQUFXO0FBQ2QsV0FBTSxJQUFJZSxNQUFNQSxHQUFHRyxhQUFhLEdBQUc7UUFDaENsQixXQUFXO0FBQ25CLFdBQVcsSUFBSUQsY0FBYyxHQUFHO1FBQ3hCQyxXQUFXO0FBQ2Q7SUFDRCxJQUFJQSxZQUFZLEdBQUc7UUFDZixJQUFJZSxNQUFNQSxHQUFHRyxhQUFhLEdBQUc7WUFDekJsQixXQUFXO0FBQ2QsZUFBTSxJQUFJZSxNQUFNQSxHQUFHRyxhQUFhLEdBQUc7WUFDaENsQixXQUFXO0FBQ2Q7QUFDSjtJQUNELE9BQU9BO0FBQ1g7O0FDelZBLElBQUkxRCxhQUFhO0lBQ2I2RSxTQUFTO0lBQ1RDLFVBQVU7SUFDVnpFLFdBQVc7SUFDWGhDLEtBQUs7SUFDTEMsVUFBVTtJQUNWNkIsU0FBUztJQUNUNEUsZUFBZTtJQUNmQyxVQUFVO0lBQ1Y5QixVQUFVO0lBQ1ZJLFNBQVM7SUFDVHZDLGNBQWM7SUFDZDBDLGFBQWE7OztBQUdqQixNQUFNd0IsUUFBUTtJQUNWQyxNQUFNO0lBQ050RyxPQUFPO0lBQ1BDLEtBQUs7SUFDTEYsS0FBSztJQUNMd0csVUFBVTtJQUNWaEgsTUFBTTtJQUNOVyxTQUFTO0lBQ1RzRyxlQUFlO0lBQ2ZsRyxXQUFXO0lBQ1htRyxhQUFhOzs7QUFHakIsTUFBTUMsU0FBUztJQUNYakcsT0FBTztRQUFFeUQsT0FBTztRQUFNakUsS0FBSzs7SUFDM0IwRyxVQUFVO0lBQ1ZDLG1CQUFtQjtJQUNuQkMsTUFBTTtJQUNOMUQsU0FBUzs7O0FBR2IsSUFBSTJELFlBQVk7O0FBRWhCdkcsTUFBTWdDLEtBQUttRTs7QUFFWDFGLE9BQU91QixLQUFLO0lBQ1IsY0FBQXdFLENBQWVDO1FBQ1hwSSxRQUFRQyxJQUFJLGtCQUFrQm1JO1FBQzlCRixZQUFZO1FBQ1osTUFBTUcsZ0JBQWdCbkksS0FBS2tFLE1BQU1nRTtRQUNqQyxJQUFJNUYsV0FBVzNCLE9BQU93SCxjQUFjeEgsT0FBTzJCLFdBQVdnRixZQUFZYSxjQUFjYixVQUFVO1lBRXRGN0YsTUFBTWdDLEtBQUttRTtZQUNYMUYsT0FBT0MsU0FBU0M7QUFDbkI7UUFDREUsYUFBYTZGO1FBQ2IsSUFBSTdGLFdBQVc2RSxXQUFXLEdBQUc7WUFDekJqRixPQUFPQyxTQUFTaUIsVUFBVWQsWUFBWWIsTUFBTWdDLEdBQUc5QjtZQUMvQ08sT0FBT0MsU0FBU21DLG1CQUFtQmhDO1lBQ25DOEY7QUFDWixlQUFlO1lBQ0gzRyxNQUFNZ0MsR0FBR29FLFdBQVc7WUFDcEJwRyxNQUFNZ0MsR0FBR3FFLG9CQUFvQjtZQUM3QjVGLE9BQU9DLFNBQVNFLFlBQVlDLFlBQVksSUFBSTtZQUM1QytGO0FBQ0g7QUFDSjtJQUNELFNBQUEzRSxDQUFVNEUsVUFBVTlFLFlBQVk7UUFDNUIsS0FBS3dFLFdBQVc7WUFDWjtBQUNIO1FBQ0RsSSxRQUFRQyxJQUFJLDBCQUEwQnVJO1FBQ3RDLEtBQUtwSSxjQUFjb0ksV0FBVztZQUMxQnhFLFdBQVdKLFVBQVU0RTtBQUN4QjtRQUNQLElBQUk5RSxXQUFXLEdBQUc7WUFFakIrRSx3QkFBd0IvRTtBQUN4QjtRQUNLd0UsWUFBWTtRQUNaUSxZQUFXO1lBQ1BSLFlBQVk7QUFBSSxZQUNqQjtBQUNOO0lBQ0QsU0FBQVM7UUFDSTNJLFFBQVFDLElBQUksNEJBQTRCMEIsTUFBTUMsU0FBU0MsTUFBTVI7UUFDN0RlLE9BQU91QixHQUFHQyxVQUFVakMsTUFBTUMsU0FBU0MsTUFBTVI7QUFDNUM7SUFDRCxPQUFBdUg7UUFDSXhHLE9BQU91QixHQUFHQyxVQUFVakMsTUFBTUMsU0FBU0UsSUFBSVQ7QUFDMUM7SUFDRCxPQUFBd0g7UUFDSXpHLE9BQU91QixHQUFHQyxVQUFVakMsTUFBTUMsU0FBU0csSUFBSVY7QUFDMUM7SUFDRCxhQUFNeUg7UUFDRjtrQkFDVTlFLFdBQVcrRSxVQUFVN0ksS0FBS0MsVUFBVTtnQkFDdEM2SSxPQUFPO2dCQUNQQyxTQUFTekcsV0FBVzNCO2dCQUNwQnFJLE9BQU85RixNQUFNK0Y7O0FBRXBCLFVBQUMsT0FBT0M7WUFDTHBKLFFBQVFDLElBQUksd0JBQXdCbUo7QUFDdkM7QUFDSjs7O0FBR0xoSCxPQUFPaUgsWUFBWTtJQUNmLElBQUk3RyxXQUFXNkUsU0FBUztRQUNwQmlCO0FBQ1IsV0FBVztRQUNIQztBQUNIO0FBQ0w7O0FBRUEzRCxlQUFlMkQ7SUFDWCxNQUFNeEksUUFBUTtRQUNWdUgsVUFBVTlFLFdBQVc4RTtRQUNyQnpFLFdBQVdMLFdBQVdLO1FBQ3RCeUcsWUFBWTs7SUFFaEIsTUFBTXhGLGdCQUFnQnJFLGVBQ2xCLDhCQUE4Qk07SUFHbEM7UUFDSSxNQUFNZ0UsdUJBQXVCQyxXQUFXQyxRQUFRSDtRQUNoRCxPQUFNSSxNQUFFQSxNQUFJQyxNQUFFQSxRQUFTakUsS0FBS2tFLE1BQU1MO1FBQ2xDeEQsWUFBWTtRQUNab0IsTUFBTWdDLEdBQUdZLFVBQVU7UUFDbkIsSUFBSUwsUUFBUSxLQUFLO1lBQ2JxRixpQkFBaUJwRjtBQUM3QixlQUFlO1lBQ0huRSxRQUFRQyxJQUFJLG1DQUFtQ2lFO0FBQ2xEO0FBQ0osTUFBQyxPQUFPSTtRQUVMM0MsTUFBTWdDLEdBQUdZLFVBQVU7UUFDbkJ2RSxRQUFRQyxJQUFJLDhCQUE4QnFFO0FBQzdDO0FBQ0w7O0FBRUFNLGVBQWUwRDtJQUNYLE1BQU12SSxRQUFRO1FBQ1Z1SCxVQUFVOUUsV0FBVzhFO1FBQ3JCekUsV0FBV0wsV0FBV0s7UUFDdEJ5RyxZQUFZOztJQUVoQixNQUFNeEYsZ0JBQWdCckUsZUFDbEIsMkJBQTJCTTtJQUcvQjtRQUNJLE1BQU1nRSx1QkFBdUJDLFdBQVdDLFFBQVFIO1FBQ2hELE9BQU1JLE1BQUVBLE1BQUlDLE1BQUVBLFFBQVNqRSxLQUFLa0UsTUFBTUw7UUFDbEN4RCxZQUFZO1FBQ1pvQixNQUFNZ0MsR0FBR1ksVUFBVTtRQUNuQixJQUFJTCxRQUFRLEtBQUs7WUFDYnNGLGVBQWVyRjtBQUMzQixlQUFlO1lBQ0huRSxRQUFRQyxJQUFJLGdDQUFnQ2lFO0FBQy9DO0FBQ0osTUFBQyxPQUFPSTtRQUVMM0MsTUFBTWdDLEdBQUdZLFVBQVU7UUFDbkJ2RSxRQUFRQyxJQUFJLDJCQUEyQnFFO0FBQzFDO0FBQ0w7O0FBRUFNLGVBQWU2RCx3QkFBd0IvRTtJQUNuQyxNQUFNM0QsUUFBUTtRQUNWWSxNQUFNK0M7O0lBRVYsTUFBTUksZ0JBQWdCckUsZUFDbEIseUNBQXlDTTtJQUU3QztRQUNJLE1BQU1nRSx1QkFBdUJDLFdBQVdDLFFBQVFIO1FBQ2hELE9BQU1JLE1BQUVBLFFBQVNoRSxLQUFLa0UsTUFBTUw7UUFDNUIsSUFBSUcsU0FBUyxLQUFLO1lBQ2RsRSxRQUFRQyxJQUFJLHVDQUF1Q2lFO0FBQ3REO0FBQ0osTUFBQyxPQUFPSTtRQUNMdEUsUUFBUUMsSUFBSSxrQ0FBa0NxRTtBQUNqRDtBQUNMOztBQUVBLFNBQVNpRixpQkFBaUJwRjtJQUN0Qi9CLE9BQU9DLFNBQVNFLFlBQVlDLFlBQVkyQixLQUFLL0MsT0FBTytDLEtBQUtzRjtJQUN6RCxJQUFJQyxVQUFVO0lBQ2RDLGVBQWV4RixLQUFLOEQsTUFBTXlCO0lBQzFCL0gsTUFBTWdDLEdBQUdzRSxPQUFPeUI7SUFDaEIxSixRQUFRQyxJQUFJLG1CQUFtQjBCLE1BQU1nQyxHQUFHeUI7QUFDNUM7O0FBRUEsU0FBU29FLGVBQWVyRjtJQUNwQnhDLE1BQU1nQyxHQUFHOUIsUUFBUXNDLEtBQUt0QztJQUN0Qk8sT0FBT0MsU0FBU2lCLFVBQVVkLFlBQVkyQixLQUFLdEM7SUFDM0NGLE1BQU1nQyxHQUFHc0UsT0FBTzJCLGdCQUFnQnpGO0lBQ2hDbkUsUUFBUUMsSUFBSSwyQkFBMkJDLEtBQUtDLFVBQVV3QixNQUFNZ0MsR0FBR3lCO0FBQ25FOztBQUdBLFNBQVN3RSxnQkFBZ0JDO0lBQ3JCLElBQUlDLFdBQVc7SUFDZixJQUFJQyxZQUFZO1FBQUVwSixNQUFNOztJQUN4QixJQUFJb0gsV0FBVztJQUNmLE1BQU1pQyxVQUFVSCxVQUFVOUI7SUFDMUIsSUFBSWlDLFdBQVdBLFFBQVExSixTQUFTLEdBQUc7UUFDL0IsS0FBSyxJQUFJMkosSUFBSSxHQUFHQSxJQUFJRCxRQUFRMUosUUFBUTJKLEtBQUs7WUFDckMsSUFBSUMsS0FBS0YsUUFBUUM7WUFDakIsSUFBSXpILFdBQVdLLGNBQWN6QyxjQUFjOEosR0FBR3ZDLFdBQVc7Z0JBQ3JEdUMsR0FBRy9JLE1BQU0rSSxHQUFHdkM7QUFDZjtZQUNELElBQUl2SCxjQUFjOEosR0FBRy9JLE1BQU07Z0JBQ3ZCK0ksR0FBRy9JLE1BQU07QUFDWjtZQUNENEcsU0FBU2tDLEtBQUtDO0FBQ2pCO1FBQ0R2SSxNQUFNZ0MsR0FBR3FFLG9CQUFvQjtRQUM3QnJHLE1BQU1nQyxHQUFHb0UsV0FBV0E7QUFDNUIsV0FBVztRQUNIcEcsTUFBTWdDLEdBQUdxRSxvQkFBb0I7QUFDaEM7SUFFRCxJQUFJNkIsVUFBVTVCLE1BQU07UUFDaEIsS0FBSyxJQUFJckIsUUFBUSxHQUFHQSxRQUFRaUQsVUFBVTVCLEtBQUszSCxRQUFRc0csU0FBUztZQUN4RCxNQUFNRSxVQUFVK0MsVUFBVTVCLEtBQUtyQjtZQUMvQitDLGVBQWU3QyxTQUFTZ0Q7WUFDeEIsSUFBSWxELFFBQVFpRCxVQUFVNUIsS0FBSzNILFNBQVMsR0FBRztnQkFDbkN3SixTQUFTSyxLQUFLSjtBQUNqQjtBQUNKO0FBQ0o7SUFDRCxPQUFPRDtBQUNYOztBQUVBLFNBQVNILGVBQWVTLFVBQVVOO0lBQzlCLEtBQUssSUFBSUcsSUFBSSxHQUFHQSxJQUFJRyxTQUFTOUosUUFBUTJKLEtBQUs7UUFDdEMsSUFBSUMsS0FBS0UsU0FBU0g7UUFDbEJDLEdBQUdyQyxjQUFjSixNQUFNSTtRQUN2QnFDLEdBQUd0QyxnQkFBZ0JILE1BQU1HO1FBQy9Cc0MsR0FBR3hHLFdBQVcsR0FBR3dHLEdBQUd2SjtRQUNkdUosR0FBR3ZKLE9BQU84RyxNQUFNOUc7UUFDdEIsSUFBSXVKLEdBQUdHLGNBQWNILEdBQUdHLGNBQWMsS0FBS0gsR0FBR0ksWUFBWSxHQUFHO1lBQzVESixHQUFHSyxhQUFhO1lBQ2hCTCxHQUFHTSxZQUFZO1lBQ2ZOLEdBQUdPLGVBQWUsR0FBR1AsR0FBR0k7QUFDM0IsZUFBUyxJQUFJSixHQUFHUSxVQUFVO1lBQ3ZCUixHQUFHSyxhQUFhO1lBQ2hCTCxHQUFHTSxZQUFZO0FBQ2xCLGVBQVM7WUFDTk4sR0FBR0ssYUFBYTtZQUNoQkwsR0FBR00sWUFBWTtBQUNmO1FBRUssSUFBSU4sR0FBR1MsWUFBWSxVQUFVO1lBQ3pCLEtBQUt2SyxjQUFjOEosR0FBRzlJLFFBQVE7Z0JBQzFCOEksR0FBR3hJLFlBQVkrRixNQUFNL0Y7Z0JBQ3JCd0ksR0FBR3JDLGNBQWM7QUFDcEI7QUFDYixlQUFlLElBQUlxQyxHQUFHUyxZQUFZLFFBQVE7WUFDOUIsS0FBS3ZLLGNBQWM4SixHQUFHOUksUUFBUTtnQkFDMUI4SSxHQUFHeEksWUFBWTtnQkFDZndJLEdBQUdyQyxjQUFjO0FBQ3BCO0FBQ2IsZUFBZSxJQUFJcUMsR0FBR1MsWUFBWSxVQUFVVCxHQUFHUyxZQUFZLFFBQVE7WUFDdkQsSUFBSW5JLFdBQVcrRSxlQUFlO2dCQUMxQjJDLEdBQUd0QyxnQkFBZ0I7Z0JBQ25Cc0MsR0FBR0ssYUFBYTtnQkFDNUJMLEdBQUdNLFlBQVk7Z0JBQ0hOLEdBQUc5SSxRQUFRLEdBQUdnQyxNQUFNd0g7QUFDdkI7QUFDYixlQUFlLElBQUlWLEdBQUdTLFlBQVksUUFBUTtZQUM5QlQsR0FBR3RDLGdCQUFnQjtZQUNuQnNDLEdBQUc5SSxRQUFRb0IsV0FBV2dGO0FBQ3pCLGVBQU0sS0FBS3BILGNBQWM4SixHQUFHOUksUUFBUTtZQUNqQzhJLEdBQUd0QyxnQkFBZ0I7QUFDdEI7UUFFRGtDLFNBQVNLLEtBQUtEO0FBQ2pCO0FBQ0w7O0FDdFJBdkksTUFBTWtKLGdCQUFnQjtJQUNyQkMsUUFBUTtJQUNScEQsTUFBTTtJQUNOcUQsWUFBWTtJQUNaQyxXQUFXOzs7QUFHWjVJLE9BQU95SSxnQkFBZ0I7SUFDdEIsZUFBQUksQ0FBaUJDO1FBQ2hCLE1BQU12TCxTQUFTTyxLQUFLa0UsTUFBTThHO1FBQzFCdkosTUFBTWtKLGNBQWNDLFNBQVNuTCxPQUFPbUw7UUFDcENuSixNQUFNa0osY0FBY25ELE9BQU8vSCxPQUFPbUI7UUFDbENhLE1BQU1rSixjQUFjRSxhQUFhcEwsT0FBT29MO1FBQ3hDcEosTUFBTWtKLGNBQWNHLFlBQVlyTCxPQUFPcUw7UUFFdkNoSCxXQUFXbUgsYUFBYTtZQUN2QnhLLE1BQVE7WUFDUnlLLFVBQVk7WUFDWkMsVUFBWTtZQUNaQyxTQUFXM0wsT0FBTzRMOztBQUVuQiJ9
