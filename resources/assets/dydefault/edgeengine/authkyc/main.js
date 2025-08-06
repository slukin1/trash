var L1 = {};
var L2 = {};
var L3 = {};

function genRequestParams(path, params = {}, method = 0, hostType = 0) {
    const param = {
        path,
        params,
        method,
        hostType
    };
    return JSON.stringify(param);
}

async function initInstData() {
    const requestParams = genRequestParams('onboard/v1/hbg/open/inst/application/level_info/get', {}, 0, 2);
    try {
        const responseString = await $nativeAPI.request(requestParams);
        const response = JSON.parse(responseString);
        const { code, data } = response;
        if (code == 200) {
            $data.orgName = data.orgName;
            $data.countryName = "--";
            $nativeAPI.kycCountryName(data.authCountry).then(countryName => {
                 $data.countryName = countryName;
            });
            if(data.phone.length > 0) {
                $data.phoneVisible = "visible";
                $data.emailVisible = "gone";
                $data.phone = data.phone;
            } else {
                $data.phoneVisible = "gone";
                $data.emailVisible = "visible";
                $data.email = data.email;
            }
            if (data.levelInfos.length > 0) {
                L1 = data.levelInfos[0];
                $data.L1Visible = "visible";
                $data.L1Title = L1.title;
                $data.L1ErrMsg = L1.errMsg;
                $data.L1State = L1.state;
                $data.L1GoAuthBorder = "";
                const L1TextConfigList = L1.textConfig;
                if (L1.state == 3) {
                    $data.L1ErrVisible = "visible";
                    $data.L1stateIconVisible = "visible";
                    $data.L1stateIcon = "ic_kyc_auth_failed";
                    $data.L1stateColor = "#E94359";
                    $data.L1StateTitle = await $nativeAPI.kycGetText('n_kyc_authentication_fail');
                } else if (L1.state == 2) {
                    $data.L1stateIconVisible = "visible";
                    $data.L1stateIcon = "ic_kyc_auth_passed";
                    $data.L1stateColor = "#03AD8F";
                    $data.L1StateTitle = await $nativeAPI.kycGetText('n_kyc_auth_passed');
                } else if (L1.state == 1) {
                    $data.L1stateIconVisible = "gone";
                    $data.L1stateColor = "#0173E5";
                    $data.L1StateTitle = await $nativeAPI.kycGetText('n_kyc_authentication_verifying');
                } else if (L1.state == 0) {
                    $data.L1GoAuthBorder = "#0173E5";
                    $data.L1stateIconVisible = "gone";
                    $data.L1stateColor = "#0173E5";
                    $data.L1StateTitle = await $nativeAPI.kycGetText('n_otc_go_verification');
                } else {
                    $data.L1stateIconVisible = "gone";
                    $data.L1StateTitle = "";
                }
                if (L1TextConfigList.length > 0) {
                    $data.L1TextConfig0Visible = "visible";
                    $data.L1TextConfig0Title = L1TextConfigList[0].title;
                    $data.L1TextConfig0Value = L1TextConfigList[0].value;
                }
                if (L1TextConfigList.length > 1) {
                    $data.L1TextConfig1Visible = "visible";
                    $data.L1TextConfig1Title = L1TextConfigList[1].title;
                    $data.L1TextConfig1Value = L1TextConfigList[1].value;
                }
                if (L1TextConfigList.length > 2) {
                    $data.L1TextConfig2Visible = "visible";
                    $data.L1TextConfig2Title = L1TextConfigList[2].title;
                    $data.L1TextConfig2Value = L1TextConfigList[2].value;
                }
                if (L1TextConfigList.length > 3) {
                    $data.L1TextConfig3Visible = "visible";
                    $data.L1TextConfig3Title = L1TextConfigList[3].title;
                    $data.L1TextConfig3Value = L1TextConfigList[3].value;
                }
            }
            if (data.levelInfos.length > 1) {
                L2 = data.levelInfos[1];
                $data.L2Visible = "visible";
                $data.L2Title = L2.title;
                $data.L2ErrMsg = L2.errMsg;
                $data.L2State = L2.state;
                $data.L2GoAuthBorder = "";
                const L2TextConfigList = L2.textConfig;
                if (L2.state == 3) {
                    $data.L2ErrVisible = "visible";
                    $data.L2stateIconVisible = "visible";
                    $data.L2stateIcon = "ic_kyc_auth_failed";
                    $data.L2stateColor = "#E94359";
                    $data.L2StateTitle = await $nativeAPI.kycGetText('n_kyc_authentication_fail');
                } else if (L2.state == 2) {
                    $data.L2stateVisible = "visible";
                    $data.L2stateIconVisible = "visible";
                    $data.L2stateIcon = "ic_kyc_auth_passed";
                    $data.L2stateColor = "#03AD8F";
                    $data.L2StateTitle = await $nativeAPI.kycGetText('n_kyc_auth_passed');
                } else if (L2.state == 1) {
                    $data.L2stateIconVisible = "gone";
                    $data.L2stateColor = "#0173E5";
                    $data.L2StateTitle = await $nativeAPI.kycGetText('n_kyc_authentication_verifying');
                } else if (L2.state == 0) {
                    $data.L2GoAuthBorder = "#0173E5";
                    $data.L2stateIconVisible = "gone";
                    $data.L2stateColor = "#0173E5";
                    $data.L2StateTitle = await $nativeAPI.kycGetText('n_otc_go_verification');
                } else {
                    $data.L2stateIconVisible = "gone";
                    $data.L2StateTitle = "";
                }
                if (L2TextConfigList.length > 0) {
                    $data.L2TextConfig0Visible = "visible";
                    $data.L2TextConfig0Title = L2TextConfigList[0].title;
                    $data.L2TextConfig0Value = L2TextConfigList[0].value;
                }
                if (L2TextConfigList.length > 1) {
                    $data.L2TextConfig1Visible = "visible";
                    $data.L2TextConfig1Title = L2TextConfigList[1].title;
                    $data.L2TextConfig1Value = L2TextConfigList[1].value;
                }
                if (L2TextConfigList.length > 2) {
                    $data.L2TextConfig2Visible = "visible";
                    $data.L2TextConfig2Title = L2TextConfigList[2].title;
                    $data.L2TextConfig2Value = L2TextConfigList[2].value;
                }
                if (L2TextConfigList.length > 3) {
                    $data.L2TextConfig3Visible = "visible";
                    $data.L2TextConfig3Title = L2TextConfigList[3].title;
                    $data.L2TextConfig3Value = L2TextConfigList[3].value;
                }
            }
            if (data.levelInfos.length > 2) {
                L3 = data.levelInfos[2];
                $data.L3GoAuthBorder = "";
                $data.L3Visible = "visible";
                $data.L3Title = L3.title;
                $data.L3ErrMsg = L3.errMsg;
                $data.L3State = L3.state;
                const L3TextConfigList = L3.textConfig;
                if(L3.state == 3) {
                    $data.L3ErrVisible = "visible";
                    $data.L3stateIconVisible = "visible";
                    $data.L3stateIcon = "ic_kyc_auth_failed";
                    $data.L3stateColor = "#E94359";
                    $data.L3StateTitle = await $nativeAPI.kycGetText('n_kyc_authentication_fail');
                } else if (L3.state == 2) {
                    $data.L3stateVisible = "visible";
                    $data.L3stateIconVisible = "visible";
                    $data.L3stateIcon = "ic_kyc_auth_passed";
                    $data.L3stateColor = "#03AD8F";
                    $data.L3StateTitle = await $nativeAPI.kycGetText('n_kyc_auth_passed');
                } else if (L3.state == 1) {
                    $data.L3stateIconVisible = "gone";
                    $data.L3stateColor = "#0173E5";
                    $data.L3StateTitle = await $nativeAPI.kycGetText('n_kyc_authentication_verifying');
                } else if (L3.state == 0) {
                    $data.L3GoAuthBorder = "#0173E5";
                    $data.L3stateColor = "#0173E5";
                    $data.L3stateIconVisible = "gone";
                    $data.L3StateTitle = await $nativeAPI.kycGetText('n_otc_go_verification');
                } else {
                    $data.L3stateIconVisible = "gone";
                    $data.L3StateTitle = "";
                }
                if (L3TextConfigList.length > 0) {
                    $data.L3TextConfig0Visible = "visible";
                    $data.L3TextConfig0Title = L3TextConfigList[0].title;
                    $data.L3TextConfig0Value = L3TextConfigList[0].value;
                }
                if (L3TextConfigList.length > 1) {
                    $data.L3TextConfig1Visible = "visible";
                    $data.L3TextConfig1Title = L3TextConfigList[1].title;
                    $data.L3TextConfig1Value = L3TextConfigList[1].value;
                }
                if (L3TextConfigList.length > 2) {
                    $data.L3TextConfig2Visible = "visible";
                    $data.L3TextConfig2Title = L3TextConfigList[2].title;
                    $data.L3TextConfig2Value = L3TextConfigList[2].value;
                }
                if (L3TextConfigList.length > 3) {
                    $data.L3TextConfig3Visible = "visible";
                    $data.L3TextConfig3Title = L3TextConfigList[3].title;
                    $data.L3TextConfig3Value = L3TextConfigList[3].value;
                }
            }
        }
        $data.loadFinished = code == 200;
    } catch (e) {
        $data.loadFinished = false;
    }
}

function kycAuthTap() {
    var kycAuth = {};
    if (L1.state == 0 || L1.state == 3) {
        kycAuth = L1;
    } else if (L2.state == 0 || L2.state == 3) {
        kycAuth = L2;
    } else if (L3.state == 0 || L3.state == 3) {
        kycAuth = L3;
    }
    if (kycAuth.tipUrl && kycAuth.tipUrl.length > 0) {
        $data.openKycAuthPage = kycAuth.tipUrl;
    } else if (kycAuth.tipMsg && kycAuth.tipMsg.length > 0) {
        $data.showKycAuthToast = kycAuth.tipMsg;
    }
}

initInstData();
