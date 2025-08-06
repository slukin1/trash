var uid = "";
var needEnName = true;
var needLocalName = false;
var needCardNumber = false;
var borderColor = "";
var primaryTextColor = "";
var idNumberFocus = false;
var firstNameFocus = false;
var lastNameFocus = false;
var enFirstNameFocus = false;
var enLastNameFocus = false;
var countryNameHint = "";
var autoDmc = false;

function getRequestParams(path, params = {}, method = 0, hostType = 0, header = {}) {
    const param = {
        path,
        params,
        method,
        hostType,
        header
    };
    return JSON.stringify(param);
}

async function getInfoV2() {
    $data.showKycAuthLoading = true;
    const requestParams = getRequestParams('v1/public/kyc/auth/info/get_v2', {}, 0, 3);
    try {
        const responseString = await $nativeAPI.request(requestParams);
        const response = JSON.parse(responseString);
        const { code, data } = response;
        $data.showKycAuthLoading = false;
        if (code == 200) {
            loadResultData(data);
            return data;
        } else {
            $data.showKycAuthToast = response.message;
        }
    } catch (e) {
        $data.showKycAuthLoading = false;
        $data.showKycAuthToast = await $nativeAPI.kycGetText("net_check_status");
    }
}

async function submitC0GetTicketV2() {
    $data.showKycAuthLoading = true;
    const param = {"authItem" : "C0_SELF", "authStep" : "C0"};
    const requestParams = getRequestParams('v1/public/kyc/auth/step/get_ticket_v2', param, 0, 3);
    try {
        const responseString = await $nativeAPI.request(requestParams);
        const response = JSON.parse(responseString);
        const { code, data } = response;
        if (code == 200) {
            requestSubmitC0(data.ticket);
        } else {
            $data.showKycAuthLoading = false;
            $data.showKycAuthToast = response.message;
        }
    } catch (e) {
        $data.showKycAuthLoading = false;
        $data.showKycAuthToast = await $nativeAPI.kycGetText("net_check_status");
    }
}

async function requestSubmitC0(ticket) {
    const syncDigital = ($data.dmcBoxSelected || $data.alertType == 1 || autoDmc) ? 1 : 0;
    var param = {
        "lastName" : $data.enLastName,
        "firstName" : $data.enFirstName,
        "nationality" : $data.countryId,
        "birth" : $data.birth,
        "city" : $data.countryName,
        "ticket": ticket,
        "syncDigital": syncDigital
    };
    if ($data.countryId == 37) {
      param.lastName = $data.firstName;
      param.firstName = $data.lastName;
    } else if (needLocalName) {
        param.local_first_name = $data.firstName;
        param.local_last_name = $data.lastName;
    }
    if (needCardNumber) {
        param.cardNumber = $data.cardNumber;
    }
    console.log(param);
    const requestParams = getRequestParams('v1/public/kyc/auth/info/submit_c0', param, 1, 3, {"Content-Type" : "application/json"});
    try {
        const responseString = await $nativeAPI.request(requestParams);
        const response = JSON.parse(responseString);
        const { code, data } = response;
        $data.showKycAuthLoading = false;
        if (code == 200) {
            await getInfoV2();
            if ($data.alertType == 1 || autoDmc) {
                loadView(5);
            } else {
                loadView(4);
            }
            if (autoDmc) {
              $data.changeToDmcPage = true;
            }
        } else {
            $data.showKycAuthToast = response.message;
        }
    } catch (e) {
        $data.showKycAuthLoading = false;
        $data.showKycAuthToast = await $nativeAPI.kycGetText("net_check_status");
    }
}

async function digitalAuth() {
    $data.showKycAuthLoading = true;
    console.log("uid:" + uid);
    const requestParams = getRequestParams('v1/public/kyc/digital/auth', {"uid" : uid}, 1, 3, {"Content-Type" : "application/json"});
    try {
        const responseString = await $nativeAPI.request(requestParams);
        const response = JSON.parse(responseString);
        const { code, data } = response;
        $data.showKycAuthLoading = false;
        if (code == 200) {
            if ($data.alertType == 2) {
                await getInfoV2();
                loadView(7);
            } else {
                kycCloseView();
            }
        } else {
            $data.showKycAuthToast = response.message;
        }
    } catch (e) {
        $data.showKycAuthLoading = false;
        $data.showKycAuthToast = await $nativeAPI.kycGetText("net_check_status");
    }
}

$data.statusHeight = 0;
$data.bottomOffset = 0;
async function initQuickKycData(authType, statusHeight = 0, bottomOffset = 0) {
    $data.statusHeight = statusHeight;
    $data.bottomOffset = bottomOffset;
    if (authType == 0) {
        loadView(0);
    } else {
        const infoData = await getInfoV2();
        const stepL1 = infoData.stepStates[0];
        const stepL2 = infoData.stepStates[1];
        const stepL3 = infoData.stepStates[2];
        if (stepL3.authState == 2) {
            loadView(8);
        } else if (stepL2.authState == 2) {
            loadView(3);
        } else if (stepL1.authState == 2) {
            loadView(2);
        } else {
            loadView(1);
        }
    }
}

async function loadResultData(infoData) {
    uid = infoData.uid;
    const baseInfo = infoData.baseInfo;
    $data.countryNamePass = baseInfo.countryFullName;
    $data.firstNamePass = baseInfo.firstName;
    $data.lastNamePass = baseInfo.lastName;
    if (baseInfo.realCountryId == 37 && isNotChinese(baseInfo.firstName) == false && isNotChinese(baseInfo.lastName) == false) {
      $data.firstNamePass = baseInfo.lastName;
      $data.lastNamePass = baseInfo.firstName;
    }
    $data.cardNumberPass = baseInfo.cardNumber;
    $data.birthdayString = baseInfo.birthStr;
    $data.flagUrlPass = await $nativeAPI.kycGetFlagUrl(baseInfo.countryId);
}

async function loadView(alertType) {
    $data.alertType = alertType;
    $data.showPassIcon = "gone";
    $data.showCountry = "visible";
    $data.kycChangedView = (alertType == 0 || alertType == 1) ? 0 : 1;
    if ($data.countryName == null) {
        countryNameHint = await $nativeAPI.kycGetText('n_kyc_quick_nationality_placeholder');
        $data.countryName = countryNameHint;
    }
    if ($data.flagUrl == null) {
        $data.flagUrl = await $nativeAPI.kycGetFlagUrl($data.countryId);
    }
    $data.dmcBoxSelected = false;
    $data.dmcBoxIcon = "edge_engine_radio_unchecked";
    if (alertType == 0) {
        $data.title = await $nativeAPI.kycGetText('n_kyc_quick_kycinfo');
        $data.buttonTitle = await $nativeAPI.kycGetText('n_security_input_submit');
        setCountryNameColor();
        setBirthdayColor();
    } else if (alertType == 1) {
        $data.title = await $nativeAPI.kycGetText('n_kyc_quick_apply_to_be_dominica_meta');
        $data.buttonTitle = await $nativeAPI.kycGetText('n_security_input_submit');
        setCountryNameColor();
        setBirthdayColor();
    } else if (alertType == 2) {
        $data.title = await $nativeAPI.kycGetText('n_kyc_quick_dialog_pass_title_L1_meta');
        $data.buttonTitle = await $nativeAPI.kycGetText('n_security_success_confirm');
    } else if (alertType == 3) {
        $data.title = await $nativeAPI.kycGetText('n_kyc_quick_dialog_pass_title_L2_meta');
        $data.buttonTitle = await $nativeAPI.kycGetText('n_security_success_confirm');
    } else if (alertType == 8) {
        $data.title = await $nativeAPI.kycGetText('n_kyc_quick_dialog_pass_title_L3_meta');
        $data.buttonTitle = await $nativeAPI.kycGetText('n_security_success_confirm');
    } else if (alertType == 4) {
        $data.title = await $nativeAPI.kycGetText('n_kyc_quick_title');
        $data.detailTitle = "";
        $data.buttonTitle = await $nativeAPI.kycGetText('n_kyc_quick_continue_L2');
        $data.showPassIcon = "visible";
    } else if (alertType == 5) {
        $data.title = await $nativeAPI.kycGetText('n_kyc_quick_title');
        $data.detailTitle = await $nativeAPI.kycGetText('n_kyc_quick_has_become_dominica_L1_meta');
        $data.buttonTitle = await $nativeAPI.kycGetText('n_kyc_quick_continue_L2');
        $data.showPassIcon = "visible";
        $data.showCountry = "gone";
    } else if (alertType == 6) {
        $data.title = await $nativeAPI.kycGetText('n_kyc_quick_title');
        $data.detailTitle = await $nativeAPI.kycGetText('n_kyc_quick_dialog_pass_subtitle_L1_meta');
        $data.buttonTitle = await $nativeAPI.kycGetText('n_kyc_quick_continue_L2');
        $data.showPassIcon = "visible";
    } else if (alertType == 7) {
        $data.title = await $nativeAPI.kycGetText('n_kyc_quick_title');
        $data.detailTitle = await $nativeAPI.kycGetText('n_kyc_quick_apply_dominica_meta');
        $data.buttonTitle = await $nativeAPI.kycGetText('n_kyc_quick_continue_L2');
        $data.showPassIcon = "visible";
    }
    $data.loadFinished = true;
}

function kycSelectNationality() {
    $data.kycAuthEndEditing = true;
    $nativeAPI.kycSelectNationality().then(nationality => {
        setCountryInfo(nationality);
 });
}

async function setCountryInfo(nationality) {
    const country = JSON.parse(nationality);
    console.log(country);
    const type = country.type;
    $data.countryId = country.countryId;
    $data.flagUrl = country.flagUrl;
    $data.countryName = country.countryName;
    $data.countryNameColor = await getPrimaryTextColor();
    needEnName = country.countryId != 37;
    $data.showEnName = needEnName ? "visible" : "gone";
    needLocalName = country.countryId == 88 || country.countryId == 37;
    $data.showLocalName = needLocalName ? "visible" : "gone";
    needCardNumber = type == 3;
    $data.showIdNumber = needCardNumber ? "visible" : "gone";
    $data.showDmcBox = "gone";
    $data.showAutoDmc = "gone";
    autoDmc = false;
    $data.dmcBoxSelected = false;
    $data.dmcBoxIcon = "edge_engine_radio_unchecked";
    if ($data.alertType == 0) {
        if (type == 1) {
            $data.showDmcBox = "gone";
        } else if (type == 2) {
            $data.showDmcBox = "visible";
        } else if (type == 3) {
            autoDmc = true;
            $data.showAutoDmc = "visible";
        }
    }
    $data.nationalityErrorTips = "gone";
    if (needEnName == false) {
        $data.enLastNameInputErrorTips = "gone";
        $data.enFirstNameInputErrorTips = "gone";
    }
    if (needLocalName == false) {
        $data.lastNameInputErrorTips = "gone";
        $data.firstNameInputErrorTips = "gone";
    }
    if (needCardNumber == false) {
        $data.idNumberInputErrorTips = "gone";
    }
    $data.loadFinished = true;
}

async function kycSelectBirthday() {
    $data.kycAuthEndEditing = true;
    $nativeAPI.kycSelectBirthday().then(async birthday => {
        $data.birth = parseInt(birthday);
        var date = new Date($data.birth);
        console.log(birthday + ":date:" + date);
        var Y = date.getFullYear();
        var M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '/';
        var D = (date.getDate() < 10 ? '0' + date.getDate() : date.getDate()) + '/';
        $data.birthdayText = M+D+Y;
        $data.birthdayErrorTips = birthday18Error() ? "visible" : "gone";
        $data.loadFinished = true;
        $data.birthdayColor = await getPrimaryTextColor();
   });
}

async function kycClickedEdit() {
    if ($data.alertType == 3 || $data.alertType == 8) {
        $data.openKycAuthPage = "mkyc/card?authType=0&modify=1";
        kycCloseView();
        return;
    }
    if ($data.alertType == 2 || $data.alertType == 4 || $data.alertType == 6) {
        loadView(0);
    } else if ($data.alertType == 5 || $data.alertType == 7) {
        loadView(1);
    }
}

function cardNumberError(t) {
  if ($data.countryId == 37) {
    const cnCardRe = new RegExp("^(\\d{14}|\\d{17})(\\d|[xX])$");
    return t == null || t.length == 0 || cnCardRe.test(t) == false;
  }
    const cardRe = /^[A-Za-z0-9]+$/;
    return t == null || t.length == 0 || cardRe.test(t) == false;
}

function enNameError(inputName) {
    const enRe = /^[A-Za-z]*(\s[A-Za-z]*)*$/;
    return inputName == null || inputName.length == 0 || enRe.test(inputName) == false;
}

function nameError(inputName) {
  if ($data.countryId == 37) {
    return isNotChinese(inputName);
  }
    const nameRe = new RegExp("[`~!@#$^&*()=|{}':;',\\[\\].<>《》/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？]");
    console.log(nameRe);
    return inputName == null || inputName.length == 0 || nameRe.test(inputName);
}

function birthday18Error() {
    if ($data.birth == null) {
        return true;
    }
    var inputDate = new Date($data.birth);
    var Y = inputDate.getFullYear();
    var nowDate = new Date();
    nowDate.setFullYear(nowDate.getFullYear() - 18);
    console.log(nowDate - inputDate);
    return nowDate < inputDate;
}

function isNotChinese(inputName) {
  const cnNameRe = /^[\u4E00-\u9FA5]+(·[\u4E00-\u9FA5]+)*$/;
  return inputName == null || inputName.length == 0 || cnNameRe.test(inputName) == false;
}

async function kycClickedSubmit() {
    $data.kycAuthEndEditing = true;
    if ($data.alertType == 0 || $data.alertType == 1) {
        console.log($data.enLastName+"||"+$data.enFirstName+"||"+$data.birth+"||"+$data.countryId);
        console.log(needLocalName+"||"+$data.lastName+"||"+$data.firstName);
        var canSubmit = true;
        if ($data.countryId == null) {
            $data.nationalityErrorTips = "visible";
            canSubmit = false;
        } else {
            $data.nationalityErrorTips = "gone";
        }
        if (needCardNumber && cardNumberError($data.cardNumber)) {
            $data.idNumberInputErrorTips = "visible";
            $data.idNumberBorderColor = "#F95A50";
            canSubmit = false;
        } else {
            $data.idNumberBorderColor = await getBorderColor(idNumberFocus);
            $data.idNumberInputErrorTips = "gone";
        }
        if (needLocalName && nameError($data.lastName)) {
            $data.lastNameInputErrorTips = "visible";
            $data.lastNameBorderColor = "#F95A50";
            canSubmit = false;
        } else {
            $data.lastNameBorderColor = await getBorderColor(lastNameFocus);
            $data.lastNameInputErrorTips = "gone";
        }
        if (needLocalName && nameError($data.firstName)) {
            $data.firstNameInputErrorTips = "visible";
            $data.firstNameBorderColor = "#F95A50";
            canSubmit = false;
        } else {
            $data.firstNameBorderColor = await getBorderColor(firstNameFocus);
            $data.firstNameInputErrorTips = "gone";
        }
        if (needEnName && enNameError($data.enLastName)) {
            $data.enLastNameInputErrorTips = "visible";
            $data.enLastNameBorderColor = "#F95A50";
            canSubmit = false;
        } else {
            $data.enLastNameBorderColor = await getBorderColor(enLastNameFocus);
            $data.enLastNameInputErrorTips = "gone";
        }
        if (needEnName && enNameError($data.enFirstName)) {
            $data.enFirstNameInputErrorTips = "visible";
            $data.enFirstNameBorderColor = "#F95A50";
            canSubmit = false;
        } else {
            $data.enFirstNameBorderColor = await getBorderColor(enFirstNameFocus);
            $data.enFirstNameInputErrorTips = "gone";
        }
        if (birthday18Error()) {
            $data.birthdayErrorTips = "visible";
            canSubmit = false;
        } else {
            $data.birthdayErrorTips = "gone";
        }
        $data.loadFinished = true;

        if (canSubmit) {
            submitC0GetTicketV2();
        }
    } else if ($data.alertType == 2 || $data.alertType == 3 || $data.alertType == 8) {
        digitalAuth();
    } else {
        var param = ($data.alertType == 4 || $data.alertType == 6) ? "0" : "1";
        $data.openKycAuthPage = "mkyc/card?authType=" + param;
        kycCloseView();
    }
}

function idNumberChange(text) {
    $data.cardNumber = text;
    if (text && text.length > 0) {
        const showTips = cardNumberError(text) ? "visible" : "gone";
        if (showTips != $data.idNumberInputErrorTips) {
            $data.idNumberInputErrorTips = showTips;
            $data.loadFinished = true;
            $data.idNumberBorderColor = showTips == "visible" ? "#F95A50" : "#0173E5";
        }
    }
}

function lastNameChange(text) {
    $data.lastName = text;
    if (text && text.length > 0) {
        const showTips = nameError(text) ? "visible" : "gone";
        if (showTips != $data.lastNameInputErrorTips) {
            $data.lastNameInputErrorTips = showTips;
            $data.loadFinished = true;
            $data.lastNameBorderColor = showTips == "visible" ? "#F95A50" : "#0173E5";
        }
    }
}

function firstNameChange(text) {
    $data.firstName = text;
    if (text && text.length > 0) {
        const showTips = nameError(text) ? "visible" : "gone";
        if (showTips != $data.firstNameInputErrorTips) {
            $data.firstNameInputErrorTips = showTips;
            $data.loadFinished = true;
            $data.firstNameBorderColor = showTips == "visible" ? "#F95A50" : "#0173E5";
        }
    }
}

function enFirstNameChange(text) {
    $data.enFirstName = text;
    if (text && text.length > 0) {
        const showTips = enNameError(text) ? "visible" : "gone";
        if (showTips != $data.enFirstNameInputErrorTips) {
            $data.enFirstNameInputErrorTips = showTips;
            $data.loadFinished = true;
            $data.enFirstNameBorderColor = showTips == "visible" ? "#F95A50" : "#0173E5";
        }
    }
}

async function setCountryNameColor() {
    if($data.countryName == countryNameHint) {
        $data.countryNameColor = await $nativeAPI.kycGetColor("baseColorThreeLevelText");
    } else {
        $data.countryNameColor = await getPrimaryTextColor();
    }
}

async function setBirthdayColor() {
    if($data.birthdayText == null || $data.birthdayText == "MM/DD/YYYY") {
        $data.birthdayColor = await $nativeAPI.kycGetColor("baseColorThreeLevelText");
    } else {
        $data.birthdayColor = await getPrimaryTextColor();
    }
}

function enLastNameChange(text) {
    $data.enLastName = text;
    if (text && text.length > 0) {
        const showTips = enNameError(text) ? "visible" : "gone";
        if (showTips != $data.enLastNameInputErrorTips) {
            $data.enLastNameInputErrorTips = showTips;
            $data.loadFinished = true;
            $data.enLastNameBorderColor = showTips == "visible" ? "#F95A50" : "#0173E5";
        }
    }
}

function dmcBoxChange() {
    $data.kycAuthEndEditing = true;
    $data.dmcBoxSelected = !$data.dmcBoxSelected;
    if ($data.dmcBoxSelected) {
        $data.dmcBoxIcon = "edge_engine_radio_checked";
    } else {
        $data.dmcBoxIcon = "edge_engine_radio_unchecked";
    }
}

function kycCloseView() {
    $data.kycCloseView = true;
}

async function getPrimaryTextColor() {
    if (primaryTextColor == null || primaryTextColor.length == 0) {
        primaryTextColor = await $nativeAPI.kycGetColor("kColorPrimaryText");
    }
    return primaryTextColor;
}

async function getBorderColor(focus) {
    if(focus) {
        return "#0173E5";
    }
    if (borderColor == null || borderColor.length == 0) {
        borderColor = await $nativeAPI.kycGetColor("baseColorInputBackground");
    }
    return borderColor;
}

async function firstNameFocusChange(focus) {
    firstNameFocus = focus;
    if($data.firstNameInputErrorTips == "visible") {
        $data.firstNameBorderColor = "#F95A50";
        return;
    }
    $data.firstNameBorderColor = await getBorderColor(focus);
}

async function lastNameFocusChange(focus) {
    lastNameFocus = focus;
    if($data.lastNameInputErrorTips == "visible") {
        $data.lastNameBorderColor = "#F95A50";
        return;
    }
    $data.lastNameBorderColor = await getBorderColor(focus);
}

async function enFirstNameFocusChange(focus) {
    enFirstNameFocus = focus;
    if($data.enFirstNameInputErrorTips == "visible") {
        $data.enFirstNameBorderColor = "#F95A50";
        return;
    }
    $data.enFirstNameBorderColor = await getBorderColor(focus);
}

async function enLastNameFocusChange(focus) {
    enLastNameFocus = focus;
    if($data.enLastNameInputErrorTips == "visible") {
        $data.enLastNameBorderColor = "#F95A50";
        return;
    }
    $data.enLastNameBorderColor = await getBorderColor(focus);
}

async function idNumberFocusChange(focus) {
    idNumberFocus = focus;
    if($data.idNumberInputErrorTips == "visible") {
        $data.idNumberBorderColor = "#F95A50";
        return;
    }
    $data.idNumberBorderColor = await getBorderColor(focus);
}

function dmcInfoClicked() {
  $data.openKycAuthPage = "mkyc/dm-introduce?btnvis=false";
}
