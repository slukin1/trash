var linkUrl = '';

function genRequestParams(path, params = {}, method = 0, hostType = 0) {
    const param = {
        path,
        params,
        method,
        hostType
    };
    return JSON.stringify(param);
}

function currencyNoticeClose() {
    $data.visibility = false;
}

function showMoreAction() {
    if (linkUrl.length == 0) {
        return;
    }
    var params = {
        'type' : 1,
        'url': linkUrl
    };
    $nativeAPI.openNoticeUrl(JSON.stringify(params));
}

async function setDarkMode(mode) {
    if(mode == 1) {
        $data.containerBg = '#1B171B';
        $data.bodyColor = '#F0F1F4';
        $data.moreColor = '#F0F1F4';
        $data.tipsImg = 'icon_currency_notice_tips_night';
        $data.closeImg = 'icon_currency_notice_close_night';
    } else {
        $data.containerBg = '#FFF8F3';
        $data.bodyColor = '#14181F';
        $data.moreColor = '#000000';
        $data.tipsImg = 'icon_currency_notice_tips';
        $data.closeImg = 'icon_currency_notice_close';
    }
}

async function currencyNoticeMessage(currency, tradeType) {
    if (!currency) {
        $data.visibility = false;
        return;
    }
    const requestParams = genRequestParams('v1/hbg/open/message/currency/notice/message', {currency, tradeType});
    try {
        const responseString = await $nativeAPI.request(requestParams);
        const response = JSON.parse(responseString);
        const { code, data } = response;
        if (code == 200 && data.length > 0) {
            var coinMessage = data[0];
            if (coinMessage.linkUrl.length > 0 && coinMessage.buttonText.length > 0) {
                $data.showMoreVisibility = "visible";
                $data.bodyLines = "3";
            } else {
                $data.showMoreVisibility = "gone";
                $data.bodyLines = "4";
            }
            $data.currency = coinMessage.currency;
            $data.messageBody = coinMessage.messageBody;
            $data.buttonText = coinMessage.buttonText;
            linkUrl = coinMessage.linkUrl;
            $data.visibility = true;
        }else{
            $data.visibility = false;
        }
    } catch (e) {
        console.error(`currencyNoticeMessage:${e}`);
    }
}