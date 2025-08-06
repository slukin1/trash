
var cid = '';
var type = 1;
var groupId = 0;
var isSelected = false;
var giftGroups = [];

async function requestIntroduce() {
    const requestParams = sendRequest('v1/content/activity/integralList');
    try {
        const responseString = await $nativeAPI.request(requestParams);
        const response = JSON.parse(responseString);
        const {code, data} = response;
        if (code == 200) {
            $data.integralList = responseString;
            for (var item of data) {
                if (item.type == 1) {
                    $data.likeTitle = await getIntroduceTitle('n_live_gift_praise_tips', item.number, item.drawNumber);
                } else if (item.type == 5) {
                    $data.watchTitle = await getIntroduceTitle('n_live_gift_view_tips', item.number, item.drawNumber);
                } else if (item.type == 6) {
                    $data.sendGiftTitle = await getIntroduceTitle('n_live_gift_reward_tips', item.number, item.drawNumber);
                }
            }
        } else {
            console.log(`requestIntroduce failed, code=${code}`);
        }
    } catch (e) {
        console.log(`requestIntroduce error:${e}`);
    }
}
requestIntroduce();

async function setupGroupId(gid) {
    groupId = gid;
    for (var item of giftGroups) {
        if (groupId == item.groupId) {
            $data.balanceTitle = item.financial.currency.toUpperCase();
            $data.balance = await getBalance(item.financial.balance, item.financial.currency);
            break;
        }
    }
    console.log(`setupGroupId groupId=${groupId}`);
}

async function integralGetVisible(visible) {
    $data.integralGetVisible = visible;
    console.log(`integralGetVisible visible=${visible}`);
}

async function requestGiftList(params) {
    const dict = JSON.parse(params);
    cid = dict.cid;
    type = dict.type;
    const requestParams = sendRequest('v1/content/activity/gift-group/get-gift-group', dict);
    try {
        const responseString = await $nativeAPI.request(requestParams);
        const response = JSON.parse(responseString);
        const {code, data} = response;
        $data.giftList = responseString;
        if (code == 200)  {
            giftGroups = data.giftGroups;
            if (groupId == 0) {
                groupId = giftGroups[0].groupId;
            }
            $data.balanceTitle = giftGroups[0].financial.currency.toUpperCase();
            $data.integral = data.integral;
            $data.balance = await getBalance(giftGroups[0].financial.balance, giftGroups[0].financial.currency);
        } else {
            console.error(`requestGiftList failed, code=${code}`);
        }
    } catch (e) {
        console.error(`requestGiftList error:${e}`);
    }
}

async function sendGift(params) {
    const dict = JSON.parse(params);
    const requestParams = sendRequest('v1/content/activity/gift', dict, 1, 0, {"Content-Type": "application/json"});
    try {
        const responseString = await $nativeAPI.request(requestParams);
        const response = JSON.parse(responseString);
        const {code, data} = response;
        $data.sendGift = responseString;
        if (code == 200) {
            $data.integral = data.integral;
            for (var item of data.giftGroups) {
                if (groupId == item.groupId) {
                    $data.balance = await getBalance(item.financial.balance, item.financial.currency);
                    break;
                }
            }
        } else {
            console.error(`requestSendGift failed, code=${code}`);
        }
    } catch (e) {
        console.error(`requestSendGift error:${e}`);
    }
}

async function updateUserIntegral() {
    const requestParams = sendRequest('v1/content/activity/integral');
    try {
        const responseString = await $nativeAPI.request(requestParams);
        const response = JSON.parse(responseString);
        const {code, data} = response;
        $data.integral = data.integral;
        if (code != 200) {
            console.error(`requestUpdateUserIntegral failed, code=${code}`);
        }
    } catch (e) {
        console.error(`requestUpdateUserIntegral error:${e}`);
    }
}

async function updateBalance() {
    if (groupId == 0) {
        console.log(`updateBalance failed, groupId 不合规`);
        return;
    }
    var dict = {};
    dict["cid"] = cid;
    dict["type"] = type;
    const requestParams = sendRequest('v1/content/activity/gift-group/get-gift-group', dict);
    try {
        const responseString = await $nativeAPI.request(requestParams);
        const response = JSON.parse(responseString);
        const {code, data} = response;
        $data.giftList = responseString;
        if (code == 200)  {
            $data.integral = data.integral;
            giftGroups = data.giftGroups;
            for (var item of giftGroups) {
                if (groupId == item.groupId) {
                    $data.balanceTitle = item.financial.currency.toUpperCase();
                    $data.balance = await getBalance(item.financial.balance, item.financial.currency);
                    break;
                }
            }
        } else {
            console.error(`updateBalance failed, code=${code}`);
        }
    } catch (e) {
        console.error(`updateBalance error:${e}`);
    }
}

function getBalance(balance, currency) {
    var dict = {};
    dict["action"] = "onGetBalacne";
    dict["balance"] = balance;
    dict["currency"] = currency;
    return $nativeAPI.onEvent(JSON.stringify(dict));
}
function closeAlert() {
    var dict = {};
    dict["action"] = "onCloseAlert";
    onEvent(dict);
}
function transfer() {
    var dict = {};
    dict["action"] = "onTransfer";
    onEvent(dict);
}
function deposit() {
    var dict = {};
    dict["action"] = "onDeposit";
    onEvent(dict);
}

function getIntegral() {
    var dict = {};
    dict["action"] = "onGetIntegral";
    onEvent(dict);
}

function continueSendGift() {
    var dict = {};
    dict["action"] = "onContinue";
    onEvent(dict);
}
function getIntroduceTitle(key, number, drawNumber) {
    var dict = {};
    dict["action"] = "onGetIntroduceTitle";
    dict["key"] = key;
    dict["number"] = number;
    dict["drawNumber"] = drawNumber;
    return $nativeAPI.onEvent(JSON.stringify(dict));
}

function sendRequest(path, params = "", method = 0, hostType = 0, header = "") {
    const param = {
        path,
        method,
        hostType,
        header,
        params
    };
    return JSON.stringify(param);
}

function onEvent(dict) {
   return $nativeAPI.onEvent(JSON.stringify(dict));
}
