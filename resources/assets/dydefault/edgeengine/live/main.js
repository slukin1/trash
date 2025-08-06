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

async function realValueString(key, realValue = []) {
    const realDict = {
        key: key,
        realValue: realValue
    };
    return await $nativeAPI.i18n(JSON.stringify(realDict));
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

var liveId = 0;

var currentIndex$1 = 0;

var lastPath = {
    section: 0,
    row: 0
};

var rule = 1;

$data.redPacket = {
    currencyList: {},
    cellDataList: [],
    afterTime: "",
    delayOptionImage: "@drawable/edge_engine_live_redpacket_unselect",
    realOptionImage: "@drawable/edge_engine_live_redpacket_select",
    showBalance: "",
    popShow: "false",
    sendShow: "visible",
    recordShow: "gone",
    liveId: 0,
    closeView: false
};

$event.redPacket = {
    setLiveId(liveID) {
        console.log(`setLiveId:${liveID}`);
        liveId = liveID;
        $data.redPacket.liveId = liveID;
    },
    initWithLiveId(liveID) {
        console.log(`initWithLiveId:${liveID}`);
        $data.redPacketQueue.sendOpenStatus = "open";
        liveId = liveID;
        $data.redPacket.liveId = liveID;
        $event.redPacket.recordClicked(1);
        requestTemplateList(liveId);
    },
    currencyClicked(index) {
        $data.redPacket.currencyList[currentIndex$1].color = "#8C8C93";
        $data.redPacket.currencyList[currentIndex$1].line = "gone";
        var newCurrency = $data.redPacket.currencyList[index];
        newCurrency.color = "#FFFFFF";
        newCurrency.line = "visible";
        $data.redPacket.cellDataList = newCurrency.cellList;
        console.log(`currencyClicked:%o`, $data.redPacket.cellDataList.rawArray());
        $data.redPacket.showBalance = newCurrency.balance + newCurrency.currency;
        currentIndex$1 = index;
        lastPath = {
            section: newCurrency.selectPath.section,
            row: newCurrency.selectPath.row
        };
        $event.redPacket.cellDidSelected(lastPath.section, lastPath.row);
    },
    cellDidSelected(section, row) {
        console.log("cellDidSelected:" + section + "," + row);
        var lastCellData = $data.redPacket.cellDataList[lastPath.section].list[lastPath.row];
        lastCellData.color = "#313132";
        lastCellData.opacity = .5;
        lastCellData.borderWidth = 0;
        var cellData = $data.redPacket.cellDataList[section].list[row];
        cellData.color = "#121F25";
        cellData.opacity = 1;
        cellData.borderWidth = .4;
        lastPath = {
            section: section,
            row: row
        };
        $data.redPacket.currencyList[currentIndex$1].selectPath = {
            section: section,
            row: row
        };
        console.log(`cellDidSelected:%o`, $data.redPacket.cellDataList.rawArray());
    },
    optionClicked(selectRule) {
        rule = selectRule;
        if (rule == 1) {
            $data.redPacket.delayOptionImage = "@drawable/edge_engine_live_redpacket_unselect";
            $data.redPacket.realOptionImage = "@drawable/edge_engine_live_redpacket_select";
        } else {
            $data.redPacket.delayOptionImage = "@drawable/edge_engine_live_redpacket_select";
            $data.redPacket.realOptionImage = "@drawable/edge_engine_live_redpacket_unselect";
        }
    },
    submitClicked() {
        requestSend();
    },
    recordClicked(isBack) {
        if (isBack == 1) {
            $data.redPacket.sendShow = "visible";
            $data.redPacket.recordShow = "gone";
        } else {
            $data.redPacket.sendShow = "gone";
            $data.redPacket.recordShow = "visible";
            $event.redPacketRecord.tabClicked(0);
        }
    },
    openDepositRoute() {
        const currency = $data.redPacket.currencyList[currentIndex$1].currency;
        var url = `holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/balance/deposit?coin=${currency}`;
        $data.redPacket.openRoute = url;
        $nativeAPI.openRoute(url);
    },
    closeAlert() {
        $data.redPacket.popShow = "false";
    },
    transfer() {
        $data.redPacket.popShow = "false";
        const currency = $data.redPacket.currencyList[currentIndex$1].currency;
        const cancelUrl = `holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/balance/transfer?coin=${currency}&account=5`;
        $data.redPacket.openRoute = cancelUrl;
        $nativeAPI.openRoute(cancelUrl);
    },
    deposit() {
        $data.redPacket.popShow = "false";
        $event.redPacket.openDepositRoute();
    },
    closeSendView() {
        console.log("closeSendView");
        $data.redPacketQueue.sendOpenStatus = "close";
    }
};

async function resetCurrencyList(dataList) {
    if (dataList == null || dataList.length == 0) {
        return;
    }
    var tempList = {};
    for (let index = 0; index < 10; index++) {
        let dict = {
            currency: "",
            balance: 0,
            visibility: "gone",
            color: "#8C8C93",
            line: "gone",
            cellList: [],
            selectPath: {
                section: 0,
                row: 0
            }
        };
        if (index < dataList.length) {
            const element = dataList[index];
            dict.currency = element.currency;
            dict.balance = element.balance;
            dict.cellList = await getCellDataList(element.list);
            dict.visibility = "visible";
        }
        tempList[index] = dict;
    }
    $data.redPacket.currencyList = tempList;
    $event.redPacket.currencyClicked(currentIndex$1);
}

async function getCellDataList(dataList) {
    var newData = [];
    var section = 0;
    for (let index = 0; index < dataList.length; index += 3) {
        var cellDict = {
            type: "normal",
            list: {
                0: {
                    section: section,
                    row: 0,
                    data: {},
                    content: "",
                    color: "#313132",
                    opacity: .5,
                    borderWidth: 0,
                    visibility: "visible"
                },
                1: {
                    section: section,
                    row: 1,
                    data: {},
                    content: "",
                    color: "#313132",
                    opacity: .5,
                    borderWidth: 0,
                    visibility: "gone"
                },
                2: {
                    section: section,
                    row: 2,
                    data: {},
                    content: "",
                    color: "#313132",
                    opacity: .5,
                    borderWidth: 0,
                    visibility: "gone"
                }
            }
        };
        cellDict.list[0].data = dataList[index];
        cellDict.list[0].content = await realValueString("n_redpacket_num", [ `${dataList[index].number}` ]);
        cellDict.list[0].data.amountStr = `${cellDict.list[0].data.amount}`;
        if (index + 1 < dataList.length) {
            cellDict.list[1].data = dataList[index + 1];
            cellDict.list[1].visibility = "visible";
            cellDict.list[1].content = await realValueString("n_redpacket_num", [ `${dataList[index + 1].number}` ]);
            cellDict.list[1].data.amountStr = `${cellDict.list[1].data.amount}`;
        }
        if (index + 2 < dataList.length) {
            cellDict.list[2].data = dataList[index + 2];
            cellDict.list[2].visibility = "visible";
            cellDict.list[2].content = await realValueString("n_redpacket_num", [ `${dataList[index + 2].number}` ]);
            cellDict.list[2].data.amountStr = `${cellDict.list[2].data.amount}`;
        }
        newData.push(cellDict);
        section++;
    }
    return newData;
}

async function requestTemplateList(liveId) {
    const requestParams = generateParams("v1/content/activity/red-packet/templateList", {
        liveId: liveId
    });
    $nativeAPI.hbShowLoading(1);
    try {
        const responseString = await $nativeAPI.request(requestParams);
        const {code: code, data: data} = JSON.parse(responseString);
        $nativeAPI.hbShowLoading(0);
        if (code == 200) {
            $data.redPacket.afterTime = await realValueString("n_redpacket_time", [ `${data.time}` ]);
            resetCurrencyList(data.currencyList);
        } else {
            console.log(`red-packet/templateList request error code:${code}`);
        }
    } catch (e) {
        $nativeAPI.hbShowLoading(0);
        console.log(`red-packet/templateList request error:${e}`);
    }
}

async function requestSend() {
    const lastCellData = $data.redPacket.cellDataList[lastPath.section].list[lastPath.row].data;
    const currency = lastCellData.currency;
    const param = {
        templateId: lastCellData.id,
        amount: lastCellData.amount,
        number: lastCellData.number,
        currency: currency,
        rule: rule,
        liveId: liveId
    };
    $data.redPacket.popShow = "false";
    const requestParams = generateParams("v1/content/activity/red-packet/send", param, 1, 0, {
        "Content-Type": "application/json"
    });
    $nativeAPI.hbShowLoading(1);
    try {
        const responseString = await $nativeAPI.request(requestParams);
        const {code: code, data: data, message: message} = JSON.parse(responseString);
        $nativeAPI.hbShowLoading(0);
        if (code == 200) {
            if (data.payResult == 1) {
                const toastStr = await realValueString("n_redpacket_send_success");
                $nativeAPI.hbToastError(toastStr);
                $data.redPacket.closeView = true;
            } else if (data.payResult == 2) {
                $data.redPacket.popShow = "true";
            } else {
                const failStr = await realValueString("n_redpacket_send_fail");
                $nativeAPI.hbToastError(failStr);
            }
        } else if (code == 3001) {
            const failStr = await realValueString("n_redpacket_send_fail");
            $nativeAPI.hbToastError(failStr);
        } else {
            $nativeAPI.hbToastError(message);
            console.log(`red-packet/send request error code:${code}`);
        }
    } catch (e) {
        $nativeAPI.hbShowLoading(0);
        console.log(`red-packet/send request error:${e}`);
    }
}

var packetQueue = [];

var serverTime = 0;

var sysTime = 0;

var currentPacket = {};

const s = 1e3;

const m = s * 60;

var refreshPacket = true;

var openPacketList = [];

const initPacket = {
    packetId: "",
    rule: 1,
    nickname: "",
    startTime: "",
    avatar: "",
    countdown: "",
    m: 0,
    s: 0,
    amount: 0,
    amountStr: "0",
    currency: ""
};

$data.redPacketQueue = {
    currentPacket: initPacket,
    sendOpenStatus: "close"
};

$event.redPacketQueue = {
    addPacketList(jsonData) {
        console.log("addPacketList:%o", jsonData);
        const dict = JSON.parse(jsonData);
        serverTime = dict.serverTime;
        sysTime = (new Date).getTime();
        if (dict.redpacketList && dict.redpacketList.length > 0) {
            packetQueue = packetQueue.concat(dict.redpacketList);
            sortPacketQueue();
        }
    },
    addSinglePacket(jsonData) {
        console.log("addSinglePacket:%o", jsonData);
        const dict = JSON.parse(jsonData);
        if (dict) {
            var packet = dict;
            packet.packetId = dict.id;
            serverTime = dict.currentTime;
            sysTime = (new Date).getTime();
            packetQueue.push(packet);
            sortPacketQueue();
        }
    },
    deletePacket(packetId) {
        console.log("deletePacket:%o", packetId);
        if (packetId) {
            var newQueue = [];
            for (let index = 0; index < packetQueue.length; index++) {
                const element = packetQueue[index];
                if (element.packetId != packetId) {
                    newQueue.push(element);
                }
            }
            packetQueue = newQueue;
        }
        changeCurrentQueue();
    },
    gotPacket(packetId) {
        console.log("gotPacket:%o", packetId);
        $event.redPacketQueue.deletePacket(packetId);
    },
    changePacketOpenStatus(openStatus) {},
    clearData() {
        console.log("---clearData---");
        clearInterval(intercal);
    },
    grapFinished(packetId) {
        console.log("grapFinished:%o", packetId);
        currentPacket = initPacket;
        $event.redPacketQueue.deletePacket(packetId);
    },
    lockPacket(lock, afterTime) {
        if (afterTime > 0) {
            setTimeout((() => {
                refreshPacket = lock;
                changeCurrentQueue();
            }), afterTime);
        } else {
            refreshPacket = lock;
        }
    }
};

function sortPacketQueue() {
    console.log("sortPacketQueue:%o", packetQueue);
    var newQueue = Array.from(new Set(packetQueue));
    newQueue.sort((function(p1, p2) {
        return parseFloat(p1.startTime) - parseFloat(p2.startTime);
    }));
    packetQueue = newQueue;
    changeCurrentQueue();
}

function changeCurrentQueue() {
    if (refreshPacket == false) {
        return;
    }
    console.log("changeCurrentQueue:%o", packetQueue);
    if (packetQueue && packetQueue.length > 0) {
        currentPacket = packetQueue[0];
    } else {
        currentPacket = initPacket;
    }
    console.log("changeCurrentQueue-currentPacket:%o", currentPacket);
}

function listenCurrentPacket() {
    if (currentPacket) {
        if (currentPacket.rule == 2) {
            const serverTimeDiff = currentPacket.startTime - serverTime;
            const sysTimeDiff = (new Date).getTime() - sysTime;
            const difference = serverTimeDiff > sysTimeDiff ? serverTimeDiff - sysTimeDiff : 0;
            currentPacket.m = Math.floor(difference / m);
            currentPacket.s = Math.floor(difference % m / s);
            if (currentPacket.m == 0 && currentPacket.s == 0) {
                currentPacket.countdown = "";
            } else {
                const showM = currentPacket.m < 10 ? `0${currentPacket.m}` : currentPacket.m;
                const showS = currentPacket.s < 10 ? `0${currentPacket.s}` : currentPacket.s;
                currentPacket.countdown = showM + ":" + showS;
            }
            $event.redPacketGrap.reloadCountDown();
        } else {
            currentPacket.countdown = "";
        }
        currentPacket.amountStr = `${currentPacket.amount}`;
        const packetIdVal = `${currentPacket.packetId}`;
        const isOpened = openPacketList.includes(packetIdVal);
        const needOpenView = isOpened == false && currentPacket.packetId && currentPacket.countdown == "" && refreshPacket == true && $data.redPacketQueue.sendOpenStatus == "close";
        $data.redPacketQueue.currentPacket = currentPacket;
        if (needOpenView) {
            openPacketList.push(packetIdVal);
            $data.redPacketGrap.openView = needOpenView;
        }
    }
}

var intercal = setInterval(listenCurrentPacket, 500);

var viewStatus = 0;

var intercalTime = null;

var needReload = false;

var buttonClicked = false;

$data.redPacketGrap = {
    grapStatus: "visible",
    snatchedStatus: "gone",
    snatch: "gone",
    snatchFail: "gone",
    title: "",
    snatchAnimate: "gone",
    closeView: false,
    openView: false,
    snatchStatus: "play",
    alertStatus: "play",
    waitStatus: "play"
};

$event.redPacketGrap = {
    loadAlertView() {
        console.log("loadAlertView");
        $event.redPacketQueue.lockPacket(false, 0);
        $data.redPacketGrap.grapStatus = "visible";
        $data.redPacketGrap.snatchedStatus = "gone";
        $data.redPacketGrap.snatch = "gone";
        $data.redPacketGrap.snatchFail = "gone";
        $data.redPacketGrap.snatchAnimate = "gone";
        $data.redPacketGrap.snatchStatus = "play";
        $data.redPacketGrap.alertStatus = "play";
        $data.redPacketGrap.waitStatus = "play";
        viewStatus = 0;
        needReload = true;
        buttonClicked = false;
        reloadViewData();
    },
    submitClicked() {
        if (viewStatus == 0) {
            const dataPacket = $data.redPacketQueue.currentPacket;
            if (dataPacket.rule == 2 && dataPacket.countdown.length > 0) {
                return;
            }
            needReload = false;
            requestGrabRedPacket();
        } else {
            $event.redPacketGrap.closeView();
        }
    },
    closeView() {
        if (buttonClicked) {
            return;
        }
        buttonClicked = true;
        if (intercalTime) {
            clearInterval(intercalTime);
            intercalTime = null;
        }
        needReload = false;
        $data.redPacketGrap.closeView = true;
        $data.redPacketGrap.grapStatus = "visible";
        $data.redPacketGrap.snatchedStatus = "gone";
        $data.redPacketGrap.snatch = "gone";
        $data.redPacketGrap.snatchFail = "gone";
        $data.redPacketGrap.snatchAnimate = "gone";
        $event.redPacketQueue.lockPacket(true, 1e3);
    },
    reloadCountDown() {
        if (needReload) {
            reloadViewData();
        }
    },
    statusChange(eventParam, animation) {
        console.log(`statusChange:${eventParam}-${animation}`);
        if (eventParam == "stop" && animation == "snatch") {
            console.log(`snatchAnimate:gone`);
        }
    }
};

async function requestGrabRedPacket() {
    const packetId = $data.redPacketQueue.currentPacket.packetId;
    const requestParam = {
        liveId: $data.redPacket.liveId,
        packetId: packetId
    };
    const requestParams = generateParams("v1/content/activity/red-packet/snatch", requestParam, 1, 0, {
        "Content-Type": "application/json"
    });
    $nativeAPI.hbShowLoading(1);
    try {
        const responseString = await $nativeAPI.request(requestParams);
        const {code: code, data: data, message: message} = JSON.parse(responseString);
        $nativeAPI.hbShowLoading(0);
        if (code == 200) {
            viewStatus = 1;
            $data.redPacketGrap.amount = `${data.amount}`;
            $data.redPacketGrap.currency = data.currency;
            $data.redPacketGrap.content = await realValueString("n_redpacket_alert_tips");
            $event.redPacketQueue.grapFinished(packetId);
            reloadViewData();
        } else if (code == 2001 || code == 2002 || code == 2003) {
            viewStatus = 2;
            console.log(`red-packet/snatch request error code:${code}`);
            $data.redPacketGrap.content = await realValueString("n_redpacket_alert_tips_keep");
            $event.redPacketQueue.grapFinished(packetId);
            reloadViewData();
        } else {
            $nativeAPI.hbToastError(message);
        }
    } catch (e) {
        $nativeAPI.hbShowLoading(0);
        console.log(`red-packet/snatch request error:${e}`);
    }
}

async function reloadViewData() {
    const dataPacket = $data.redPacketQueue.currentPacket;
    if (viewStatus == 0) {
        $data.redPacketGrap.grapStatus = "visible";
        $data.redPacketGrap.snatchedStatus = "gone";
        $data.redPacketGrap.snatch = "gone";
        $data.redPacketGrap.snatchFail = "gone";
        $data.redPacketGrap.snatchAnimate = "gone";
        $data.redPacketGrap.title = await realValueString("n_redpacket_alert_title", [ dataPacket.nickname ]);
        $data.redPacketGrap.content = `${dataPacket.amount} ${dataPacket.currency}`;
        if (dataPacket.rule == 2 && dataPacket.countdown.length > 0) {
            showButtonTitle("n_redpacket_alert_time", [ `${dataPacket.m}`, `${dataPacket.s}` ]);
        } else {
            showButtonTitle("n_redpacket_alert_done", []);
        }
    } else if (viewStatus == 1) {
        $data.redPacketGrap.grapStatus = "gone";
        $data.redPacketGrap.snatchedStatus = "visible";
        $data.redPacketGrap.snatch = "visible";
        $data.redPacketGrap.snatchFail = "gone";
        $data.redPacketGrap.snatchAnimate = "visible";
        setTimeout((() => {
            $data.redPacketGrap.snatchAnimate = "gone";
        }), 2e3);
        $data.redPacketGrap.title = await realValueString("n_redpacket_alert_snatch");
        countdownTitle();
    } else {
        $data.redPacketGrap.grapStatus = "gone";
        $data.redPacketGrap.snatchedStatus = "visible";
        $data.redPacketGrap.snatch = "gone";
        $data.redPacketGrap.snatchFail = "visible";
        $data.redPacketGrap.snatchAnimate = "gone";
        $data.redPacketGrap.title = await realValueString("n_redpacket_alert_none");
        countdownTitle();
    }
}

async function countdownTitle() {
    showButtonTitle("n_redpacket_alert_know", [ "5s" ]);
    var time = 5;
    if (intercalTime) {
        clearInterval(intercalTime);
    }
    intercalTime = setInterval((() => {
        if (time > 1) {
            time = time - 1;
            showButtonTitle("n_redpacket_alert_know", [ `${time}s` ]);
        } else {
            clearInterval(intercalTime);
            intercalTime = null;
            $event.redPacketGrap.closeView();
        }
    }), 1e3);
}

async function showButtonTitle(key, realValue) {
    $data.redPacketGrap.buttonTitle = await realValueString(key, realValue);
}

var currentIndex = 0;

$data.redPacketRecord = {
    recordTypes: {
        0: {
            color: "#FFFFFF",
            line: "visible",
            dataList: []
        },
        1: {
            color: "#8C8C93",
            line: "gone",
            dataList: []
        }
    },
    recordList: [],
    recordShow: "gone",
    recordEmptyShow: "visible",
    refreshStatus: "0"
};

$event.redPacketRecord = {
    tabClicked(index) {
        $data.redPacketRecord.recordTypes[currentIndex].color = "#8C8C93";
        $data.redPacketRecord.recordTypes[currentIndex].line = "gone";
        var newTap = $data.redPacketRecord.recordTypes[index];
        newTap.color = "#FFFFFF";
        newTap.line = "visible";
        $data.redPacketRecord.recordList = newTap.dataList;
        currentIndex = index;
        $data.redPacketRecord.refreshStatus = "0";
        requestRecord();
    }
};

$event.refresh = function recordRefresh() {
    requestRecord();
};

async function requestRecord() {
    const type = currentIndex == 0 ? 1 : 2;
    const param = {
        direction: 1,
        id: 0,
        pageSize: 100,
        type: type,
        liveId: $data.redPacket.liveId
    };
    const requestParams = generateParams("v1/content/activity/red-packet/orderList", param);
    console.log("orderList请求参数： " + requestParams);
    $nativeAPI.hbShowLoading(1);
    try {
        const responseString = await $nativeAPI.request(requestParams);
        const {code: code, data: data} = JSON.parse(responseString);
        $nativeAPI.hbShowLoading(0);
        $data.redPacketRecord.refreshStatus = "2";
        if (code == 200) {
            convertRecycleItem(data.listData, "normal");
            $data.redPacketRecord.recordTypes[currentIndex].dataList = data.listData;
            $data.redPacketRecord.recordList = data.listData;
            if (data.listData.length > 0) {
                $data.redPacketRecord.recordShow = "visible";
                $data.redPacketRecord.recordEmptyShow = "gone";
            } else {
                $data.redPacketRecord.recordShow = "gone";
                $data.redPacketRecord.recordEmptyShow = "visible";
            }
        } else {
            console.log(`red-packet/orderList request error code:${code}`);
        }
    } catch (e) {
        $data.redPacketRecord.refreshStatus = "2";
        $nativeAPI.hbShowLoading(0);
        console.log(`red-packet/orderList request error:${e}`);
    }
}

function convertRecycleItem(listData, typeKey) {
    for (var index = 0; index < listData.length; ++index) {
        var element = listData[index];
        element.type = typeKey;
        if (element.createTime) {
            element.createTime = new Date(element.createTime).Format("yyyy-MM-dd hh:mm:ss");
        }
    }
}
//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoibWFpbi5qcyIsInNvdXJjZXMiOlsiLi4vLi4vcmVwb3NpdG9yeS9zcmMvdXRpbC5qcyIsIi4uLy4uL3JlcG9zaXRvcnkvc3JjL3JlZF9wYWNrZXQuanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9yZWRfcGFja2V0X3F1ZXVlLmpzIiwiLi4vLi4vcmVwb3NpdG9yeS9zcmMvcmVkX3BhY2tldF9ncmFwLmpzIiwiLi4vLi4vcmVwb3NpdG9yeS9zcmMvcmVkX3BhY2tldF9yZWNvcmQuanMiXSwic291cmNlc0NvbnRlbnQiOlsiLyoqXG4gKiBAcGFyYW0ge1N0cmluZ30gcGF0aCDot6/lvoRcbiAqIEBwYXJhbSB7T2JqZWN0dH0gcGFyYW1zIOWPguaVsFxuICogQHBhcmFtIHtOdW1iZXJ9IG1ldGhvZCBnZXTvvJowIHBvc3TvvJoxXG4gKiBAcGFyYW0ge051bWJlcn0gaG9zdFR5cGUgdXJsaG9zdCAw77yaaGJnXG4gKiBAcGFyYW0ge1N0cmluZ30gaGVhZGVyIGhlYWRlclxuICogQHJldHVybnMge09iamVjdH1cbiAqL1xuZXhwb3J0IGZ1bmN0aW9uIGdlbmVyYXRlUGFyYW1zKHBhdGgsIHBhcmFtcyA9IHt9LCBtZXRob2QgPSAwLCBob3N0VHlwZSA9IDAsIGhlYWRlciA9IFwiXCIpIHtcbiAgICBjb25zdCBwYXJhbSA9IHtcbiAgICAgICAgcGF0aCxcbiAgICAgICAgbWV0aG9kLFxuICAgICAgICBob3N0VHlwZSxcbiAgICAgICAgaGVhZGVyLFxuICAgICAgICBwYXJhbXNcbiAgICB9O1xuICAgIGNvbnNvbGUubG9nKFwiZ2VuZXJhdGVQYXJhbXM6JW9cIiwgcGFyYW0pO1xuICAgIHJldHVybiBKU09OLnN0cmluZ2lmeShwYXJhbSk7XG59XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiByZWFsVmFsdWVTdHJpbmcoa2V5LCByZWFsVmFsdWUgPSBbXSkge1xuICAgIGNvbnN0IHJlYWxEaWN0ID0geyBrZXksIHJlYWxWYWx1ZSB9O1xuICAgIHJldHVybiBhd2FpdCAkbmF0aXZlQVBJLmkxOG4oSlNPTi5zdHJpbmdpZnkocmVhbERpY3QpKTtcbn1cblxuRGF0ZS5wcm90b3R5cGUuRm9ybWF0ID0gZnVuY3Rpb24oZm10KSB7XG4gICAgdmFyIG8gPSB7XG4gICAgICAgIFwiTStcIjogdGhpcy5nZXRNb250aCgpICsgMSwgLy/mnIjku70gXG4gICAgICAgIFwiZCtcIjogdGhpcy5nZXREYXRlKCksIC8v5pelIFxuICAgICAgICBcImgrXCI6IHRoaXMuZ2V0SG91cnMoKSwgLy/lsI/ml7YgXG4gICAgICAgIFwibStcIjogdGhpcy5nZXRNaW51dGVzKCksIC8v5YiGIFxuICAgICAgICBcInMrXCI6IHRoaXMuZ2V0U2Vjb25kcygpLCAvL+enkiBcbiAgICAgICAgXCJxK1wiOiBNYXRoLmZsb29yKCh0aGlzLmdldE1vbnRoKCkgKyAzKSAvIDMpLCAvL+Wto+W6piBcbiAgICAgICAgXCJTXCI6IHRoaXMuZ2V0TWlsbGlzZWNvbmRzKCkgLy/mr6vnp5IgXG4gICAgfTtcbiAgICBpZiAoLyh5KykvLnRlc3QoZm10KSkgZm10ID0gZm10LnJlcGxhY2UoUmVnRXhwLiQxLCAodGhpcy5nZXRGdWxsWWVhcigpICsgXCJcIikuc3Vic3RyKDQgLSBSZWdFeHAuJDEubGVuZ3RoKSk7XG4gICAgZm9yICh2YXIgayBpbiBvKVxuICAgICAgICBpZiAobmV3IFJlZ0V4cChcIihcIiArIGsgKyBcIilcIikudGVzdChmbXQpKSBmbXQgPSBmbXQucmVwbGFjZShSZWdFeHAuJDEsIChSZWdFeHAuJDEubGVuZ3RoID09IDEpID8gKG9ba10pIDogKChcIjAwXCIgKyBvW2tdKS5zdWJzdHIoKFwiXCIgKyBvW2tdKS5sZW5ndGgpKSk7XG4gICAgcmV0dXJuIGZtdDtcbn1cbiIsImltcG9ydCB7IGdlbmVyYXRlUGFyYW1zLCByZWFsVmFsdWVTdHJpbmcgfSBmcm9tIFwiLi91dGlsXCJcblxudmFyIGxpdmVJZCA9IDA7XG52YXIgY3VycmVudEluZGV4ID0gMDtcbnZhciBsYXN0UGF0aCA9IHsgc2VjdGlvbjogMCwgcm93OiAwIH07XG52YXIgcnVsZSA9IDE7IC8vIHJ1bGUx5a6e5pe257qi5YyFIDLlrprml7bnuqLljIVcblxuLy8vIOe6ouWMheWIneWni+WMluaVsOaNrlxuJGRhdGEucmVkUGFja2V0ID0ge1xuICAgIGN1cnJlbmN5TGlzdDoge30sXG4gICAgY2VsbERhdGFMaXN0OiBbXSxcbiAgICBhZnRlclRpbWU6ICcnLFxuICAgIGRlbGF5T3B0aW9uSW1hZ2U6IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX2xpdmVfcmVkcGFja2V0X3Vuc2VsZWN0XCIsXG4gICAgcmVhbE9wdGlvbkltYWdlOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9saXZlX3JlZHBhY2tldF9zZWxlY3RcIixcbiAgICBzaG93QmFsYW5jZTogXCJcIixcbiAgICBwb3BTaG93OiBcImZhbHNlXCIsXG4gICAgc2VuZFNob3c6IFwidmlzaWJsZVwiLFxuICAgIHJlY29yZFNob3c6IFwiZ29uZVwiLFxuICAgIGxpdmVJZDogMCxcbiAgICBjbG9zZVZpZXc6IGZhbHNlLFxufVxuXG4vLy8g57qi5YyF5Lia5YqhIGV2ZW50IGZ1bmN0aW9uXG4kZXZlbnQucmVkUGFja2V0ID0ge1xuICAgIC8vIOWIneWni+WMluaXtmxpdmVJRFxuICAgIHNldExpdmVJZChsaXZlSUQpIHtcbiAgICAgICAgY29uc29sZS5sb2coYHNldExpdmVJZDoke2xpdmVJRH1gKTtcbiAgICAgICAgbGl2ZUlkID0gbGl2ZUlEO1xuICAgICAgICAkZGF0YS5yZWRQYWNrZXQubGl2ZUlkID0gbGl2ZUlEO1xuICAgIH0sXG4gICAgaW5pdFdpdGhMaXZlSWQobGl2ZUlEKSB7XG4gICAgICAgIGNvbnNvbGUubG9nKGBpbml0V2l0aExpdmVJZDoke2xpdmVJRH1gKTtcbiAgICAgICAgJGRhdGEucmVkUGFja2V0UXVldWUuc2VuZE9wZW5TdGF0dXMgPSBcIm9wZW5cIjtcbiAgICAgICAgbGl2ZUlkID0gbGl2ZUlEO1xuICAgICAgICAkZGF0YS5yZWRQYWNrZXQubGl2ZUlkID0gbGl2ZUlEO1xuICAgICAgICAkZXZlbnQucmVkUGFja2V0LnJlY29yZENsaWNrZWQoMSk7XG4gICAgICAgIHJlcXVlc3RUZW1wbGF0ZUxpc3QobGl2ZUlkKTtcbiAgICB9LFxuICAgIGN1cnJlbmN5Q2xpY2tlZChpbmRleCkge1xuICAgICAgICAkZGF0YS5yZWRQYWNrZXQuY3VycmVuY3lMaXN0W2N1cnJlbnRJbmRleF0uY29sb3IgPSBcIiM4QzhDOTNcIjtcbiAgICAgICAgJGRhdGEucmVkUGFja2V0LmN1cnJlbmN5TGlzdFtjdXJyZW50SW5kZXhdLmxpbmUgPSBcImdvbmVcIjtcbiAgICAgICAgLy8g5paw6YCJ5oup6K6+572uXG4gICAgICAgIHZhciBuZXdDdXJyZW5jeSA9ICRkYXRhLnJlZFBhY2tldC5jdXJyZW5jeUxpc3RbaW5kZXhdO1xuICAgICAgICBuZXdDdXJyZW5jeS5jb2xvciA9IFwiI0ZGRkZGRlwiO1xuICAgICAgICBuZXdDdXJyZW5jeS5saW5lID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgICRkYXRhLnJlZFBhY2tldC5jZWxsRGF0YUxpc3QgPSBuZXdDdXJyZW5jeS5jZWxsTGlzdDtcbiAgICAgICAgY29uc29sZS5sb2coYGN1cnJlbmN5Q2xpY2tlZDolb2AsICRkYXRhLnJlZFBhY2tldC5jZWxsRGF0YUxpc3QucmF3QXJyYXkoKSk7XG4gICAgICAgICRkYXRhLnJlZFBhY2tldC5zaG93QmFsYW5jZSA9IG5ld0N1cnJlbmN5LmJhbGFuY2UgKyBuZXdDdXJyZW5jeS5jdXJyZW5jeTtcbiAgICAgICAgY3VycmVudEluZGV4ID0gaW5kZXg7XG4gICAgICAgIGxhc3RQYXRoID0geyBzZWN0aW9uOiBuZXdDdXJyZW5jeS5zZWxlY3RQYXRoLnNlY3Rpb24sIHJvdzogbmV3Q3VycmVuY3kuc2VsZWN0UGF0aC5yb3cgfTtcbiAgICAgICAgJGV2ZW50LnJlZFBhY2tldC5jZWxsRGlkU2VsZWN0ZWQobGFzdFBhdGguc2VjdGlvbiwgbGFzdFBhdGgucm93KTtcbiAgICB9LFxuICAgIGNlbGxEaWRTZWxlY3RlZChzZWN0aW9uLCByb3cpIHtcbiAgICAgICAgY29uc29sZS5sb2coXCJjZWxsRGlkU2VsZWN0ZWQ6XCIgKyBzZWN0aW9uICsgXCIsXCIgKyByb3cpO1xuICAgICAgICB2YXIgbGFzdENlbGxEYXRhID0gJGRhdGEucmVkUGFja2V0LmNlbGxEYXRhTGlzdFtsYXN0UGF0aC5zZWN0aW9uXS5saXN0W2xhc3RQYXRoLnJvd107XG4gICAgICAgIGxhc3RDZWxsRGF0YS5jb2xvciA9IFwiIzMxMzEzMlwiO1xuICAgICAgICBsYXN0Q2VsbERhdGEub3BhY2l0eSA9IDAuNTtcbiAgICAgICAgbGFzdENlbGxEYXRhLmJvcmRlcldpZHRoID0gMDtcbiAgICAgICAgLy8g5paw6YCJ5LitXG4gICAgICAgIHZhciBjZWxsRGF0YSA9ICRkYXRhLnJlZFBhY2tldC5jZWxsRGF0YUxpc3Rbc2VjdGlvbl0ubGlzdFtyb3ddO1xuICAgICAgICBjZWxsRGF0YS5jb2xvciA9IFwiIzEyMUYyNVwiO1xuICAgICAgICBjZWxsRGF0YS5vcGFjaXR5ID0gMTtcbiAgICAgICAgY2VsbERhdGEuYm9yZGVyV2lkdGggPSAwLjQ7XG4gICAgICAgIGxhc3RQYXRoID0geyBzZWN0aW9uLCByb3cgfTtcbiAgICAgICAgJGRhdGEucmVkUGFja2V0LmN1cnJlbmN5TGlzdFtjdXJyZW50SW5kZXhdLnNlbGVjdFBhdGggPSB7IHNlY3Rpb24sIHJvdyB9O1xuICAgICAgICBjb25zb2xlLmxvZyhgY2VsbERpZFNlbGVjdGVkOiVvYCwgJGRhdGEucmVkUGFja2V0LmNlbGxEYXRhTGlzdC5yYXdBcnJheSgpKTtcbiAgICB9LFxuICAgIG9wdGlvbkNsaWNrZWQoc2VsZWN0UnVsZSkge1xuICAgICAgICBydWxlID0gc2VsZWN0UnVsZTtcbiAgICAgICAgaWYgKHJ1bGUgPT0gMSkge1xuICAgICAgICAgICAgJGRhdGEucmVkUGFja2V0LmRlbGF5T3B0aW9uSW1hZ2UgPSBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9saXZlX3JlZHBhY2tldF91bnNlbGVjdFwiO1xuICAgICAgICAgICAgJGRhdGEucmVkUGFja2V0LnJlYWxPcHRpb25JbWFnZSA9IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX2xpdmVfcmVkcGFja2V0X3NlbGVjdFwiO1xuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgJGRhdGEucmVkUGFja2V0LmRlbGF5T3B0aW9uSW1hZ2UgPSBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9saXZlX3JlZHBhY2tldF9zZWxlY3RcIjtcbiAgICAgICAgICAgICRkYXRhLnJlZFBhY2tldC5yZWFsT3B0aW9uSW1hZ2UgPSBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9saXZlX3JlZHBhY2tldF91bnNlbGVjdFwiO1xuICAgICAgICB9XG4gICAgfSxcbiAgICBzdWJtaXRDbGlja2VkKCkge1xuICAgICAgICByZXF1ZXN0U2VuZCgpO1xuICAgIH0sXG4gICAgLy8g57qi5YyF6K6w5b2VXG4gICAgcmVjb3JkQ2xpY2tlZChpc0JhY2spIHtcbiAgICAgICAgaWYgKGlzQmFjayA9PSAxKSB7XG4gICAgICAgICAgICAkZGF0YS5yZWRQYWNrZXQuc2VuZFNob3cgPSBcInZpc2libGVcIjtcbiAgICAgICAgICAgICRkYXRhLnJlZFBhY2tldC5yZWNvcmRTaG93ID0gXCJnb25lXCI7XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAkZGF0YS5yZWRQYWNrZXQuc2VuZFNob3cgPSBcImdvbmVcIjtcbiAgICAgICAgICAgICRkYXRhLnJlZFBhY2tldC5yZWNvcmRTaG93ID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgICAgICAkZXZlbnQucmVkUGFja2V0UmVjb3JkLnRhYkNsaWNrZWQoMCk7XG4gICAgICAgIH1cbiAgICB9LFxuICAgIC8vIOWFheWAvFxuICAgIG9wZW5EZXBvc2l0Um91dGUoKSB7XG4gICAgICAgIGNvbnN0IGN1cnJlbmN5ID0gJGRhdGEucmVkUGFja2V0LmN1cnJlbmN5TGlzdFtjdXJyZW50SW5kZXhdLmN1cnJlbmN5O1xuICAgICAgICB2YXIgdXJsID0gYGhvbGlnZWl0Oi8vb3Blbi92MT9sb2dpbj0xJnVybD1paHVvYmlnbG9iYWw6Ly9tLmhiZy5jb20vYmFsYW5jZS9kZXBvc2l0P2NvaW49JHtjdXJyZW5jeX1gO1xuICAgICAgICAkZGF0YS5yZWRQYWNrZXQub3BlblJvdXRlID0gdXJsO1xuICAgICAgICAkbmF0aXZlQVBJLm9wZW5Sb3V0ZSh1cmwpO1xuICAgIH0sXG4gICAgLy8g5L2Z6aKd5LiN6Laz5by556qXXG4gICAgY2xvc2VBbGVydCgpIHtcbiAgICAgICAgJGRhdGEucmVkUGFja2V0LnBvcFNob3cgPSBcImZhbHNlXCI7XG4gICAgfSxcbiAgICB0cmFuc2ZlcigpIHtcbiAgICAgICAgJGRhdGEucmVkUGFja2V0LnBvcFNob3cgPSBcImZhbHNlXCI7XG4gICAgICAgIGNvbnN0IGN1cnJlbmN5ID0gJGRhdGEucmVkUGFja2V0LmN1cnJlbmN5TGlzdFtjdXJyZW50SW5kZXhdLmN1cnJlbmN5O1xuICAgICAgICBjb25zdCBjYW5jZWxVcmwgPSBgaG9saWdlaXQ6Ly9vcGVuL3YxP2xvZ2luPTEmdXJsPWlodW9iaWdsb2JhbDovL20uaGJnLmNvbS9iYWxhbmNlL3RyYW5zZmVyP2NvaW49JHtjdXJyZW5jeX0mYWNjb3VudD01YDtcbiAgICAgICAgJGRhdGEucmVkUGFja2V0Lm9wZW5Sb3V0ZSA9IGNhbmNlbFVybDtcbiAgICAgICAgJG5hdGl2ZUFQSS5vcGVuUm91dGUoY2FuY2VsVXJsKTtcbiAgICB9LFxuICAgIGRlcG9zaXQoKSB7XG4gICAgICAgICRkYXRhLnJlZFBhY2tldC5wb3BTaG93ID0gXCJmYWxzZVwiO1xuICAgICAgICAkZXZlbnQucmVkUGFja2V0Lm9wZW5EZXBvc2l0Um91dGUoKTtcbiAgICB9LFxuICAgIGNsb3NlU2VuZFZpZXcoKSB7XG4gICAgICAgIGNvbnNvbGUubG9nKFwiY2xvc2VTZW5kVmlld1wiKTtcbiAgICAgICAgJGRhdGEucmVkUGFja2V0UXVldWUuc2VuZE9wZW5TdGF0dXMgPSBcImNsb3NlXCI7XG4gICAgfVxufVxuXG4vLyDliJ3lp4vljJbluIHnp43liJfooahcbmFzeW5jIGZ1bmN0aW9uIHJlc2V0Q3VycmVuY3lMaXN0KGRhdGFMaXN0KSB7XG4gICAgaWYgKGRhdGFMaXN0ID09IG51bGwgfHwgZGF0YUxpc3QubGVuZ3RoID09IDApIHtcbiAgICAgICAgcmV0dXJuO1xuICAgIH1cbiAgICB2YXIgdGVtcExpc3QgPSB7fTtcbiAgICBmb3IgKGxldCBpbmRleCA9IDA7IGluZGV4IDwgMTA7IGluZGV4KyspIHtcbiAgICAgICAgbGV0IGRpY3QgPSB7XG4gICAgICAgICAgICBjdXJyZW5jeTogXCJcIixcbiAgICAgICAgICAgIGJhbGFuY2U6IDAsXG4gICAgICAgICAgICB2aXNpYmlsaXR5OiBcImdvbmVcIixcbiAgICAgICAgICAgIGNvbG9yOiBcIiM4QzhDOTNcIixcbiAgICAgICAgICAgIGxpbmU6IFwiZ29uZVwiLFxuICAgICAgICAgICAgY2VsbExpc3Q6IFtdLFxuICAgICAgICAgICAgc2VsZWN0UGF0aDogeyBzZWN0aW9uOiAwLCByb3c6IDAgfSxcbiAgICAgICAgfTtcbiAgICAgICAgaWYgKGluZGV4IDwgZGF0YUxpc3QubGVuZ3RoKSB7XG4gICAgICAgICAgICBjb25zdCBlbGVtZW50ID0gZGF0YUxpc3RbaW5kZXhdO1xuICAgICAgICAgICAgZGljdC5jdXJyZW5jeSA9IGVsZW1lbnQuY3VycmVuY3k7XG4gICAgICAgICAgICBkaWN0LmJhbGFuY2UgPSBlbGVtZW50LmJhbGFuY2U7XG4gICAgICAgICAgICBkaWN0LmNlbGxMaXN0ID0gYXdhaXQgZ2V0Q2VsbERhdGFMaXN0KGVsZW1lbnQubGlzdCk7XG4gICAgICAgICAgICBkaWN0LnZpc2liaWxpdHkgPSBcInZpc2libGVcIjtcbiAgICAgICAgfVxuICAgICAgICB0ZW1wTGlzdFtpbmRleF0gPSBkaWN0O1xuICAgIH1cbiAgICAkZGF0YS5yZWRQYWNrZXQuY3VycmVuY3lMaXN0ID0gdGVtcExpc3Q7XG4gICAgJGV2ZW50LnJlZFBhY2tldC5jdXJyZW5jeUNsaWNrZWQoY3VycmVudEluZGV4KTtcbn1cblxuYXN5bmMgZnVuY3Rpb24gZ2V0Q2VsbERhdGFMaXN0KGRhdGFMaXN0KSB7XG4gICAgdmFyIG5ld0RhdGEgPSBbXTtcbiAgICB2YXIgc2VjdGlvbiA9IDA7XG4gICAgZm9yIChsZXQgaW5kZXggPSAwOyBpbmRleCA8IGRhdGFMaXN0Lmxlbmd0aDsgaW5kZXggKz0gMykge1xuICAgICAgICB2YXIgY2VsbERpY3QgPSB7XG4gICAgICAgICAgICB0eXBlOiBcIm5vcm1hbFwiLFxuICAgICAgICAgICAgbGlzdDoge1xuICAgICAgICAgICAgICAgIDA6IHsgc2VjdGlvbiwgcm93OiAwLCBkYXRhOiB7fSwgY29udGVudDogXCJcIiwgY29sb3I6IFwiIzMxMzEzMlwiLCBvcGFjaXR5OiAwLjUsIGJvcmRlcldpZHRoOiAwLCB2aXNpYmlsaXR5OiBcInZpc2libGVcIiB9LFxuICAgICAgICAgICAgICAgIDE6IHsgc2VjdGlvbiwgcm93OiAxLCBkYXRhOiB7fSwgY29udGVudDogXCJcIiwgY29sb3I6IFwiIzMxMzEzMlwiLCBvcGFjaXR5OiAwLjUsIGJvcmRlcldpZHRoOiAwLCB2aXNpYmlsaXR5OiBcImdvbmVcIiB9LFxuICAgICAgICAgICAgICAgIDI6IHsgc2VjdGlvbiwgcm93OiAyLCBkYXRhOiB7fSwgY29udGVudDogXCJcIiwgY29sb3I6IFwiIzMxMzEzMlwiLCBvcGFjaXR5OiAwLjUsIGJvcmRlcldpZHRoOiAwLCB2aXNpYmlsaXR5OiBcImdvbmVcIiB9XG4gICAgICAgICAgICB9XG4gICAgICAgIH07XG4gICAgICAgIGNlbGxEaWN0Lmxpc3RbMF0uZGF0YSA9IGRhdGFMaXN0W2luZGV4XTtcbiAgICAgICAgY2VsbERpY3QubGlzdFswXS5jb250ZW50ID0gYXdhaXQgcmVhbFZhbHVlU3RyaW5nKFwibl9yZWRwYWNrZXRfbnVtXCIsIFtgJHtkYXRhTGlzdFtpbmRleF0ubnVtYmVyfWBdKTtcbiAgICAgICAgY2VsbERpY3QubGlzdFswXS5kYXRhLmFtb3VudFN0ciA9IGAke2NlbGxEaWN0Lmxpc3RbMF0uZGF0YS5hbW91bnR9YDtcbiAgICAgICAgaWYgKGluZGV4ICsgMSA8IGRhdGFMaXN0Lmxlbmd0aCkge1xuICAgICAgICAgICAgY2VsbERpY3QubGlzdFsxXS5kYXRhID0gZGF0YUxpc3RbaW5kZXggKyAxXTtcbiAgICAgICAgICAgIGNlbGxEaWN0Lmxpc3RbMV0udmlzaWJpbGl0eSA9IFwidmlzaWJsZVwiO1xuICAgICAgICAgICAgY2VsbERpY3QubGlzdFsxXS5jb250ZW50ID0gYXdhaXQgcmVhbFZhbHVlU3RyaW5nKFwibl9yZWRwYWNrZXRfbnVtXCIsIFtgJHtkYXRhTGlzdFtpbmRleCArIDFdLm51bWJlcn1gXSk7XG4gICAgICAgICAgICBjZWxsRGljdC5saXN0WzFdLmRhdGEuYW1vdW50U3RyID0gYCR7Y2VsbERpY3QubGlzdFsxXS5kYXRhLmFtb3VudH1gO1xuICAgICAgICB9XG4gICAgICAgIGlmIChpbmRleCArIDIgPCBkYXRhTGlzdC5sZW5ndGgpIHtcbiAgICAgICAgICAgIGNlbGxEaWN0Lmxpc3RbMl0uZGF0YSA9IGRhdGFMaXN0W2luZGV4ICsgMl07XG4gICAgICAgICAgICBjZWxsRGljdC5saXN0WzJdLnZpc2liaWxpdHkgPSBcInZpc2libGVcIjtcbiAgICAgICAgICAgIGNlbGxEaWN0Lmxpc3RbMl0uY29udGVudCA9IGF3YWl0IHJlYWxWYWx1ZVN0cmluZyhcIm5fcmVkcGFja2V0X251bVwiLCBbYCR7ZGF0YUxpc3RbaW5kZXggKyAyXS5udW1iZXJ9YF0pO1xuICAgICAgICAgICAgY2VsbERpY3QubGlzdFsyXS5kYXRhLmFtb3VudFN0ciA9IGAke2NlbGxEaWN0Lmxpc3RbMl0uZGF0YS5hbW91bnR9YDtcbiAgICAgICAgfVxuICAgICAgICBuZXdEYXRhLnB1c2goY2VsbERpY3QpO1xuICAgICAgICBzZWN0aW9uKys7XG4gICAgfVxuICAgIHJldHVybiBuZXdEYXRhO1xufVxuXG4vLy8g57qi5YyF5Lia5Yqh55qEIHByaXZhdGUg5pa55rOVXG5hc3luYyBmdW5jdGlvbiByZXF1ZXN0VGVtcGxhdGVMaXN0KGxpdmVJZCkge1xuICAgIGNvbnN0IHJlcXVlc3RQYXJhbXMgPSBnZW5lcmF0ZVBhcmFtcyhcbiAgICAgICAgXCJ2MS9jb250ZW50L2FjdGl2aXR5L3JlZC1wYWNrZXQvdGVtcGxhdGVMaXN0XCIsIHsgbGl2ZUlkIH1cbiAgICApO1xuICAgICRuYXRpdmVBUEkuaGJTaG93TG9hZGluZygxKTtcbiAgICB0cnkge1xuICAgICAgICBjb25zdCByZXNwb25zZVN0cmluZyA9IGF3YWl0ICRuYXRpdmVBUEkucmVxdWVzdChyZXF1ZXN0UGFyYW1zKTtcbiAgICAgICAgY29uc3QgeyBjb2RlLCBkYXRhIH0gPSBKU09OLnBhcnNlKHJlc3BvbnNlU3RyaW5nKTtcbiAgICAgICAgJG5hdGl2ZUFQSS5oYlNob3dMb2FkaW5nKDApO1xuICAgICAgICBpZiAoY29kZSA9PSAyMDApIHtcbiAgICAgICAgICAgICRkYXRhLnJlZFBhY2tldC5hZnRlclRpbWUgPSBhd2FpdCByZWFsVmFsdWVTdHJpbmcoXCJuX3JlZHBhY2tldF90aW1lXCIsIFtgJHtkYXRhLnRpbWV9YF0pO1xuICAgICAgICAgICAgcmVzZXRDdXJyZW5jeUxpc3QoZGF0YS5jdXJyZW5jeUxpc3QpO1xuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgY29uc29sZS5sb2coYHJlZC1wYWNrZXQvdGVtcGxhdGVMaXN0IHJlcXVlc3QgZXJyb3IgY29kZToke2NvZGV9YCk7XG4gICAgICAgIH1cbiAgICB9IGNhdGNoIChlKSB7XG4gICAgICAgICRuYXRpdmVBUEkuaGJTaG93TG9hZGluZygwKTtcbiAgICAgICAgY29uc29sZS5sb2coYHJlZC1wYWNrZXQvdGVtcGxhdGVMaXN0IHJlcXVlc3QgZXJyb3I6JHtlfWApO1xuICAgIH1cbn1cblxuLy8vIOe6ouWMheS4muWKoeeahCBwcml2YXRlIOaWueazlVxuYXN5bmMgZnVuY3Rpb24gcmVxdWVzdFNlbmQoKSB7XG4gICAgY29uc3QgbGFzdENlbGxEYXRhID0gJGRhdGEucmVkUGFja2V0LmNlbGxEYXRhTGlzdFtsYXN0UGF0aC5zZWN0aW9uXS5saXN0W2xhc3RQYXRoLnJvd10uZGF0YTtcbiAgICBjb25zdCBjdXJyZW5jeSA9IGxhc3RDZWxsRGF0YS5jdXJyZW5jeTtcbiAgICBjb25zdCBwYXJhbSA9IHtcbiAgICAgICAgdGVtcGxhdGVJZDogbGFzdENlbGxEYXRhLmlkLFxuICAgICAgICBhbW91bnQ6IGxhc3RDZWxsRGF0YS5hbW91bnQsXG4gICAgICAgIG51bWJlcjogbGFzdENlbGxEYXRhLm51bWJlcixcbiAgICAgICAgY3VycmVuY3ksXG4gICAgICAgIHJ1bGU6IHJ1bGUsXG4gICAgICAgIGxpdmVJZDogbGl2ZUlkLFxuICAgIH07XG4gICAgJGRhdGEucmVkUGFja2V0LnBvcFNob3cgPSBcImZhbHNlXCI7XG5cbiAgICBjb25zdCByZXF1ZXN0UGFyYW1zID0gZ2VuZXJhdGVQYXJhbXMoXG4gICAgICAgIFwidjEvY29udGVudC9hY3Rpdml0eS9yZWQtcGFja2V0L3NlbmRcIiwgcGFyYW0sIDEsIDAsIHsgXCJDb250ZW50LVR5cGVcIjogXCJhcHBsaWNhdGlvbi9qc29uXCIgfVxuICAgICk7XG4gICAgJG5hdGl2ZUFQSS5oYlNob3dMb2FkaW5nKDEpO1xuICAgIHRyeSB7XG4gICAgICAgIGNvbnN0IHJlc3BvbnNlU3RyaW5nID0gYXdhaXQgJG5hdGl2ZUFQSS5yZXF1ZXN0KHJlcXVlc3RQYXJhbXMpO1xuICAgICAgICBjb25zdCB7IGNvZGUsIGRhdGEsIG1lc3NhZ2UgfSA9IEpTT04ucGFyc2UocmVzcG9uc2VTdHJpbmcpO1xuICAgICAgICAkbmF0aXZlQVBJLmhiU2hvd0xvYWRpbmcoMCk7XG4gICAgICAgIGlmIChjb2RlID09IDIwMCkge1xuICAgICAgICAgICAgLy8g5pSv5LuY57uT5p6c77yMMeaIkOWKn++8jDLkvZnpop3kuI3otrPvvIww5aSx6LSlXG4gICAgICAgICAgICBpZiAoZGF0YS5wYXlSZXN1bHQgPT0gMSkge1xuICAgICAgICAgICAgICAgIGNvbnN0IHRvYXN0U3RyID0gYXdhaXQgcmVhbFZhbHVlU3RyaW5nKFwibl9yZWRwYWNrZXRfc2VuZF9zdWNjZXNzXCIpO1xuICAgICAgICAgICAgICAgICRuYXRpdmVBUEkuaGJUb2FzdEVycm9yKHRvYXN0U3RyKTtcbiAgICAgICAgICAgICAgICAkZGF0YS5yZWRQYWNrZXQuY2xvc2VWaWV3ID0gdHJ1ZTtcbiAgICAgICAgICAgIH0gZWxzZSBpZiAoZGF0YS5wYXlSZXN1bHQgPT0gMikge1xuICAgICAgICAgICAgICAgICRkYXRhLnJlZFBhY2tldC5wb3BTaG93ID0gXCJ0cnVlXCI7XG4gICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgIGNvbnN0IGZhaWxTdHIgPSBhd2FpdCByZWFsVmFsdWVTdHJpbmcoXCJuX3JlZHBhY2tldF9zZW5kX2ZhaWxcIik7XG4gICAgICAgICAgICAgICAgJG5hdGl2ZUFQSS5oYlRvYXN0RXJyb3IoZmFpbFN0cik7XG4gICAgICAgICAgICB9XG4gICAgICAgIH0gZWxzZSBpZiAoY29kZSA9PSAzMDAxKSB7XG4gICAgICAgICAgICBjb25zdCBmYWlsU3RyID0gYXdhaXQgcmVhbFZhbHVlU3RyaW5nKFwibl9yZWRwYWNrZXRfc2VuZF9mYWlsXCIpO1xuICAgICAgICAgICAgJG5hdGl2ZUFQSS5oYlRvYXN0RXJyb3IoZmFpbFN0cik7XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAkbmF0aXZlQVBJLmhiVG9hc3RFcnJvcihtZXNzYWdlKTtcbiAgICAgICAgICAgIGNvbnNvbGUubG9nKGByZWQtcGFja2V0L3NlbmQgcmVxdWVzdCBlcnJvciBjb2RlOiR7Y29kZX1gKTtcbiAgICAgICAgfVxuICAgIH0gY2F0Y2ggKGUpIHtcbiAgICAgICAgJG5hdGl2ZUFQSS5oYlNob3dMb2FkaW5nKDApO1xuICAgICAgICBjb25zb2xlLmxvZyhgcmVkLXBhY2tldC9zZW5kIHJlcXVlc3QgZXJyb3I6JHtlfWApO1xuICAgIH1cbn1cbiIsInZhciBwYWNrZXRRdWV1ZSA9IFtdO1xudmFyIGlzT3BlbiA9IGZhbHNlOyAvLyDlvZPliY3mnInnuqLljIXmraPlnKjmiZPlvIBcbnZhciBzZXJ2ZXJUaW1lID0gMDsgLy8g5pyN5Yqh5Zmo5pe26Ze0XG52YXIgc3lzVGltZSA9IDA7IC8vIOi3n+acjeWKoeWZqOaXtumXtOWvueW6lOeahOezu+e7n+aXtumXtFxudmFyIGN1cnJlbnRQYWNrZXQgPSB7fTsgLy8g5b2T5YmN57qi5YyFXG5jb25zdCBzID0gMTAwMDtcbmNvbnN0IG0gPSBzICogNjA7XG52YXIgcmVmcmVzaFBhY2tldCA9IHRydWU7XG52YXIgb3BlblBhY2tldExpc3QgPSBbXTsgLy8g5omT5byA55qE57qi5YyF5YiX6KGoXG5cbmNvbnN0IGluaXRQYWNrZXQgPSB7XG4gICAgcGFja2V0SWQ6IFwiXCIsXG4gICAgcnVsZTogMSxcbiAgICBuaWNrbmFtZTogXCJcIixcbiAgICBzdGFydFRpbWU6IFwiXCIsXG4gICAgYXZhdGFyOiBcIlwiLFxuICAgIGNvdW50ZG93bjogXCJcIixcbiAgICBtOiAwLFxuICAgIHM6IDAsXG4gICAgYW1vdW50OiAwLFxuICAgIGFtb3VudFN0cjogXCIwXCIsXG4gICAgY3VycmVuY3k6IFwiXCJcbn07XG4vLy8g57qi5YyF6Zif5YiXXG4kZGF0YS5yZWRQYWNrZXRRdWV1ZSA9IHtcbiAgICBjdXJyZW50UGFja2V0OiBpbml0UGFja2V0LCAvLyDpnIDopoHnm5HlkKznmoTlj7PkvqfmmL7npLrnmoTlvZPliY3nuqLljIVcbiAgICBzZW5kT3BlblN0YXR1czogXCJjbG9zZVwiLFxufVxuXG4kZXZlbnQucmVkUGFja2V0UXVldWUgPSB7XG4gICAgLy8g6L+b5YWl57qi5YyF6I635Y+W55qE5Y6G5Y+y5pyq6aKG5Y+W57qi5YyFLCDmt7vliqDkuIDnu4TmlbDmja5cbiAgICAvLyBqc29uRGF0YToge3JlZHBhY2tldExpc3QsIHNlcnZlclRpbWUgfSByZWRwYWNrZXRMaXN0Oui/m+ebtOaSreaXtue6ouWMheWIl+ihqCxzZXJ2ZXJUaW1lOuacjeWKoeWZqOaXtumXtFxuICAgIGFkZFBhY2tldExpc3QoanNvbkRhdGEpIHtcbiAgICAgICAgY29uc29sZS5sb2coXCJhZGRQYWNrZXRMaXN0OiVvXCIsIGpzb25EYXRhKTtcbiAgICAgICAgY29uc3QgZGljdCA9IEpTT04ucGFyc2UoanNvbkRhdGEpO1xuICAgICAgICBzZXJ2ZXJUaW1lID0gZGljdC5zZXJ2ZXJUaW1lO1xuICAgICAgICBzeXNUaW1lID0gbmV3IERhdGUoKS5nZXRUaW1lKCk7XG4gICAgICAgIGlmIChkaWN0LnJlZHBhY2tldExpc3QgJiYgZGljdC5yZWRwYWNrZXRMaXN0Lmxlbmd0aCA+IDApIHtcbiAgICAgICAgICAgIHBhY2tldFF1ZXVlID0gcGFja2V0UXVldWUuY29uY2F0KGRpY3QucmVkcGFja2V0TGlzdCk7XG4gICAgICAgICAgICBzb3J0UGFja2V0UXVldWUoKTtcbiAgICAgICAgfVxuICAgIH0sXG4gICAgLy8g576k6YCa55+l6I635Y+W55qE57qi5YyF77yM5re75Yqg5LiA5Liq5pWw5o2uXG4gICAgLy9qc29uRGF0Ye+8mntpZCwgY3VycmVudFRpbWUsLi4ufVxuICAgIGFkZFNpbmdsZVBhY2tldChqc29uRGF0YSkge1xuICAgICAgICBjb25zb2xlLmxvZyhcImFkZFNpbmdsZVBhY2tldDolb1wiLCBqc29uRGF0YSk7XG4gICAgICAgIGNvbnN0IGRpY3QgPSBKU09OLnBhcnNlKGpzb25EYXRhKTtcbiAgICAgICAgaWYgKGRpY3QpIHtcbiAgICAgICAgICAgIHZhciBwYWNrZXQgPSBkaWN0O1xuICAgICAgICAgICAgcGFja2V0LnBhY2tldElkID0gZGljdC5pZDtcbiAgICAgICAgICAgIHNlcnZlclRpbWUgPSBkaWN0LmN1cnJlbnRUaW1lO1xuICAgICAgICAgICAgc3lzVGltZSA9IG5ldyBEYXRlKCkuZ2V0VGltZSgpO1xuICAgICAgICAgICAgcGFja2V0UXVldWUucHVzaChwYWNrZXQpO1xuICAgICAgICAgICAgc29ydFBhY2tldFF1ZXVlKCk7XG4gICAgICAgIH1cbiAgICB9LFxuICAgIC8vIOe+pOmAmuefpee6ouWMheWFs+mXre+8jOWIoOmZpOS4gOS4quaVsOaNrlxuICAgIC8vIHBhY2tldElkOue6ouWMhUlkXG4gICAgZGVsZXRlUGFja2V0KHBhY2tldElkKSB7XG4gICAgICAgIGNvbnNvbGUubG9nKFwiZGVsZXRlUGFja2V0OiVvXCIsIHBhY2tldElkKTtcbiAgICAgICAgaWYgKHBhY2tldElkKSB7XG4gICAgICAgICAgICB2YXIgbmV3UXVldWUgPSBbXTtcbiAgICAgICAgICAgIGZvciAobGV0IGluZGV4ID0gMDsgaW5kZXggPCBwYWNrZXRRdWV1ZS5sZW5ndGg7IGluZGV4KyspIHtcbiAgICAgICAgICAgICAgICBjb25zdCBlbGVtZW50ID0gcGFja2V0UXVldWVbaW5kZXhdO1xuICAgICAgICAgICAgICAgIGlmIChlbGVtZW50LnBhY2tldElkICE9IHBhY2tldElkKSB7XG4gICAgICAgICAgICAgICAgICAgIG5ld1F1ZXVlLnB1c2goZWxlbWVudCk7XG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgfVxuICAgICAgICAgICAgcGFja2V0UXVldWUgPSBuZXdRdWV1ZTtcbiAgICAgICAgfVxuICAgICAgICBjaGFuZ2VDdXJyZW50UXVldWUoKTtcbiAgICB9LFxuICAgIC8vIOe+pOmAmuefpeaKouWIsOS6hue6ouWMhVxuICAgIC8vIHBhY2tldElkOue6ouWMhUlkXG4gICAgZ290UGFja2V0KHBhY2tldElkKSB7XG4gICAgICAgIGNvbnNvbGUubG9nKFwiZ290UGFja2V0OiVvXCIsIHBhY2tldElkKTtcbiAgICAgICAgJGV2ZW50LnJlZFBhY2tldFF1ZXVlLmRlbGV0ZVBhY2tldChwYWNrZXRJZCk7XG4gICAgfSxcbiAgICAvLyDmmK/lkKbmiZPlvIDkuobnuqLljIXlvLnnqpdcbiAgICBjaGFuZ2VQYWNrZXRPcGVuU3RhdHVzKG9wZW5TdGF0dXMpIHtcbiAgICAgICAgaXNPcGVuID0gb3BlblN0YXR1cztcbiAgICB9LFxuICAgIC8vIOmAgOWHuua4hemZpOaVsOaNrlxuICAgIGNsZWFyRGF0YSgpIHtcbiAgICAgICAgY29uc29sZS5sb2coXCItLS1jbGVhckRhdGEtLS1cIik7XG4gICAgICAgIGNsZWFySW50ZXJ2YWwoaW50ZXJjYWwpO1xuICAgIH0sXG4gICAgLy8g5oqi5a6M57qi5YyFXG4gICAgZ3JhcEZpbmlzaGVkKHBhY2tldElkKSB7XG4gICAgICAgIGNvbnNvbGUubG9nKFwiZ3JhcEZpbmlzaGVkOiVvXCIsIHBhY2tldElkKTtcbiAgICAgICAgY3VycmVudFBhY2tldCA9IGluaXRQYWNrZXQ7XG4gICAgICAgICRldmVudC5yZWRQYWNrZXRRdWV1ZS5kZWxldGVQYWNrZXQocGFja2V0SWQpO1xuICAgIH0sXG4gICAgLy8g5oqi57qi5YyF6ZSB5a6aY3VycmVudFBhY2tldFxuICAgIGxvY2tQYWNrZXQobG9jaywgYWZ0ZXJUaW1lKSB7XG4gICAgICAgIGlmIChhZnRlclRpbWUgPiAwKSB7XG4gICAgICAgICAgICBzZXRUaW1lb3V0KCgpID0+IHtcbiAgICAgICAgICAgICAgICByZWZyZXNoUGFja2V0ID0gbG9jaztcbiAgICAgICAgICAgICAgICBjaGFuZ2VDdXJyZW50UXVldWUoKTtcbiAgICAgICAgICAgIH0sIGFmdGVyVGltZSk7XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICByZWZyZXNoUGFja2V0ID0gbG9jaztcbiAgICAgICAgfVxuICAgIH1cbn1cblxuLy8g57qi5YyF5qC55o2u5Y+v5oqi5pe26Ze05o6S5bqPXG5mdW5jdGlvbiBzb3J0UGFja2V0UXVldWUoKSB7XG4gICAgLy8g5Y676YeNLCDmjpLluo9cbiAgICBjb25zb2xlLmxvZyhcInNvcnRQYWNrZXRRdWV1ZTolb1wiLCBwYWNrZXRRdWV1ZSk7XG4gICAgdmFyIG5ld1F1ZXVlID0gQXJyYXkuZnJvbShuZXcgU2V0KHBhY2tldFF1ZXVlKSk7XG4gICAgbmV3UXVldWUuc29ydChmdW5jdGlvbihwMSwgcDIpIHtcbiAgICAgICAgcmV0dXJuIHBhcnNlRmxvYXQocDEuc3RhcnRUaW1lKSAtIHBhcnNlRmxvYXQocDIuc3RhcnRUaW1lKTtcbiAgICB9KTtcbiAgICBwYWNrZXRRdWV1ZSA9IG5ld1F1ZXVlO1xuICAgIGNoYW5nZUN1cnJlbnRRdWV1ZSgpO1xufVxuXG4vLyDmlLnlj5jlvZPliY3lsZXnpLrnuqLljIVcbmZ1bmN0aW9uIGNoYW5nZUN1cnJlbnRRdWV1ZSgpIHtcbiAgICBpZiAocmVmcmVzaFBhY2tldCA9PSBmYWxzZSkge1xuICAgICAgICByZXR1cm47XG4gICAgfVxuICAgIGNvbnNvbGUubG9nKFwiY2hhbmdlQ3VycmVudFF1ZXVlOiVvXCIsIHBhY2tldFF1ZXVlKTtcbiAgICBpZiAocGFja2V0UXVldWUgJiYgcGFja2V0UXVldWUubGVuZ3RoID4gMCkge1xuICAgICAgICBjdXJyZW50UGFja2V0ID0gcGFja2V0UXVldWVbMF07XG4gICAgfSBlbHNlIHtcbiAgICAgICAgY3VycmVudFBhY2tldCA9IGluaXRQYWNrZXQ7XG4gICAgfVxuICAgIGNvbnNvbGUubG9nKFwiY2hhbmdlQ3VycmVudFF1ZXVlLWN1cnJlbnRQYWNrZXQ6JW9cIiwgY3VycmVudFBhY2tldCk7XG59XG4vLyDlvZPliY3mmL7npLrnmoTnuqLljIUg5pyN5Yqh5Zmo5pe26Ze05beu5YC877yM5pys5Zyw5pe26Ze05beu5YC86K6h566XXG5mdW5jdGlvbiBsaXN0ZW5DdXJyZW50UGFja2V0KCkge1xuICAgIGlmIChjdXJyZW50UGFja2V0KSB7XG4gICAgICAgIGlmIChjdXJyZW50UGFja2V0LnJ1bGUgPT0gMikge1xuICAgICAgICAgICAgLy8g5YCS6K6h5pe257qi5YyFXG4gICAgICAgICAgICBjb25zdCBzZXJ2ZXJUaW1lRGlmZiA9IGN1cnJlbnRQYWNrZXQuc3RhcnRUaW1lIC0gc2VydmVyVGltZTsgLy8g6K6h5pe257qi5YyF5Ymp5L2Z5pe26Ze0XG4gICAgICAgICAgICBjb25zdCBzeXNUaW1lRGlmZiA9IG5ldyBEYXRlKCkuZ2V0VGltZSgpIC0gc3lzVGltZTsgLy8g5pe26Ze05beu5q+r56eS5pWwXG4gICAgICAgICAgICBjb25zdCBkaWZmZXJlbmNlID0gc2VydmVyVGltZURpZmYgPiBzeXNUaW1lRGlmZiA/IHNlcnZlclRpbWVEaWZmIC0gc3lzVGltZURpZmYgOiAwO1xuICAgICAgICAgICAgY3VycmVudFBhY2tldC5tID0gTWF0aC5mbG9vcihkaWZmZXJlbmNlIC8gbSk7XG4gICAgICAgICAgICBjdXJyZW50UGFja2V0LnMgPSBNYXRoLmZsb29yKChkaWZmZXJlbmNlICUgbSkgLyBzKTtcbiAgICAgICAgICAgIGlmIChjdXJyZW50UGFja2V0Lm0gPT0gMCAmJiBjdXJyZW50UGFja2V0LnMgPT0gMCkge1xuICAgICAgICAgICAgICAgIGN1cnJlbnRQYWNrZXQuY291bnRkb3duID0gXCJcIjtcbiAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICAgY29uc3Qgc2hvd00gPSBjdXJyZW50UGFja2V0Lm0gPCAxMCA/IGAwJHtjdXJyZW50UGFja2V0Lm19YCA6IGN1cnJlbnRQYWNrZXQubTtcbiAgICAgICAgICAgICAgICBjb25zdCBzaG93UyA9IGN1cnJlbnRQYWNrZXQucyA8IDEwID8gYDAke2N1cnJlbnRQYWNrZXQuc31gIDogY3VycmVudFBhY2tldC5zO1xuICAgICAgICAgICAgICAgIGN1cnJlbnRQYWNrZXQuY291bnRkb3duID0gc2hvd00gKyBcIjpcIiArIHNob3dTO1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgJGV2ZW50LnJlZFBhY2tldEdyYXAucmVsb2FkQ291bnREb3duKCk7XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICBjdXJyZW50UGFja2V0LmNvdW50ZG93biA9IFwiXCI7XG4gICAgICAgIH1cbiAgICAgICAgY3VycmVudFBhY2tldC5hbW91bnRTdHIgPSBgJHtjdXJyZW50UGFja2V0LmFtb3VudH1gO1xuICAgICAgICAvLyBjb25zb2xlLmxvZyhgbGlzdGVuQ3VycmVudFBhY2tldDolb2AsIGN1cnJlbnRQYWNrZXQpO1xuICAgICAgICBjb25zdCBwYWNrZXRJZFZhbCA9IGAke2N1cnJlbnRQYWNrZXQucGFja2V0SWR9YDtcbiAgICAgICAgY29uc3QgaXNPcGVuZWQgPSBvcGVuUGFja2V0TGlzdC5pbmNsdWRlcyhwYWNrZXRJZFZhbCk7XG4gICAgICAgIGNvbnN0IG5lZWRPcGVuVmlldyA9IChcbiAgICAgICAgICAgIGlzT3BlbmVkID09IGZhbHNlICYmXG4gICAgICAgICAgICBjdXJyZW50UGFja2V0LnBhY2tldElkICYmXG4gICAgICAgICAgICBjdXJyZW50UGFja2V0LmNvdW50ZG93biA9PSBcIlwiICYmXG4gICAgICAgICAgICByZWZyZXNoUGFja2V0ID09IHRydWUgJiZcbiAgICAgICAgICAgICRkYXRhLnJlZFBhY2tldFF1ZXVlLnNlbmRPcGVuU3RhdHVzID09IFwiY2xvc2VcIlxuICAgICAgICApO1xuICAgICAgICAkZGF0YS5yZWRQYWNrZXRRdWV1ZS5jdXJyZW50UGFja2V0ID0gY3VycmVudFBhY2tldDtcbiAgICAgICAgaWYgKG5lZWRPcGVuVmlldykge1xuICAgICAgICAgICAgb3BlblBhY2tldExpc3QucHVzaChwYWNrZXRJZFZhbCk7XG4gICAgICAgICAgICAvLyDoh6rliqjmiZPlvIDlvLnnqpdcbiAgICAgICAgICAgICRkYXRhLnJlZFBhY2tldEdyYXAub3BlblZpZXcgPSBuZWVkT3BlblZpZXc7XG4gICAgICAgIH1cbiAgICB9XG59XG5cbnZhciBpbnRlcmNhbCA9IHNldEludGVydmFsKGxpc3RlbkN1cnJlbnRQYWNrZXQsIDUwMCk7XG4iLCJpbXBvcnQgeyBnZW5lcmF0ZVBhcmFtcywgcmVhbFZhbHVlU3RyaW5nIH0gZnJvbSBcIi4vdXRpbFwiXG5cbnZhciB2aWV3U3RhdHVzID0gMDtcbnZhciBpbnRlcmNhbFRpbWUgPSBudWxsO1xudmFyIG5lZWRSZWxvYWQgPSBmYWxzZTtcbnZhciBidXR0b25DbGlja2VkID0gZmFsc2U7XG5cbiRkYXRhLnJlZFBhY2tldEdyYXAgPSB7XG4gICAgZ3JhcFN0YXR1czogXCJ2aXNpYmxlXCIsXG4gICAgc25hdGNoZWRTdGF0dXM6IFwiZ29uZVwiLFxuICAgIHNuYXRjaDogXCJnb25lXCIsXG4gICAgc25hdGNoRmFpbDogXCJnb25lXCIsXG4gICAgdGl0bGU6IFwiXCIsXG4gICAgc25hdGNoQW5pbWF0ZTogXCJnb25lXCIsXG4gICAgY2xvc2VWaWV3OiBmYWxzZSxcbiAgICBvcGVuVmlldzogZmFsc2UsXG4gICAgc25hdGNoU3RhdHVzOiBcInBsYXlcIixcbiAgICBhbGVydFN0YXR1czogXCJwbGF5XCIsXG4gICAgd2FpdFN0YXR1czogXCJwbGF5XCIsXG59XG5cbiRldmVudC5yZWRQYWNrZXRHcmFwID0ge1xuICAgIGxvYWRBbGVydFZpZXcoKSB7XG4gICAgICAgIGNvbnNvbGUubG9nKFwibG9hZEFsZXJ0Vmlld1wiKTtcbiAgICAgICAgJGV2ZW50LnJlZFBhY2tldFF1ZXVlLmxvY2tQYWNrZXQoZmFsc2UsIDApO1xuICAgICAgICAkZGF0YS5yZWRQYWNrZXRHcmFwLmdyYXBTdGF0dXMgPSBcInZpc2libGVcIjtcbiAgICAgICAgJGRhdGEucmVkUGFja2V0R3JhcC5zbmF0Y2hlZFN0YXR1cyA9IFwiZ29uZVwiO1xuICAgICAgICAkZGF0YS5yZWRQYWNrZXRHcmFwLnNuYXRjaCA9IFwiZ29uZVwiO1xuICAgICAgICAkZGF0YS5yZWRQYWNrZXRHcmFwLnNuYXRjaEZhaWwgPSBcImdvbmVcIjtcbiAgICAgICAgJGRhdGEucmVkUGFja2V0R3JhcC5zbmF0Y2hBbmltYXRlID0gXCJnb25lXCI7XG4gICAgICAgICRkYXRhLnJlZFBhY2tldEdyYXAuc25hdGNoU3RhdHVzID0gXCJwbGF5XCI7XG4gICAgICAgICRkYXRhLnJlZFBhY2tldEdyYXAuYWxlcnRTdGF0dXMgPSBcInBsYXlcIjtcbiAgICAgICAgJGRhdGEucmVkUGFja2V0R3JhcC53YWl0U3RhdHVzID0gXCJwbGF5XCI7XG4gICAgICAgIHZpZXdTdGF0dXMgPSAwO1xuICAgICAgICBuZWVkUmVsb2FkID0gdHJ1ZTtcbiAgICAgICAgYnV0dG9uQ2xpY2tlZCA9IGZhbHNlO1xuICAgICAgICByZWxvYWRWaWV3RGF0YSgpO1xuICAgIH0sXG4gICAgc3VibWl0Q2xpY2tlZCgpIHtcbiAgICAgICAgaWYgKHZpZXdTdGF0dXMgPT0gMCkge1xuICAgICAgICAgICAgY29uc3QgZGF0YVBhY2tldCA9ICRkYXRhLnJlZFBhY2tldFF1ZXVlLmN1cnJlbnRQYWNrZXQ7XG4gICAgICAgICAgICBpZiAoZGF0YVBhY2tldC5ydWxlID09IDIgJiYgZGF0YVBhY2tldC5jb3VudGRvd24ubGVuZ3RoID4gMCkge1xuICAgICAgICAgICAgICAgIHJldHVybjtcbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIG5lZWRSZWxvYWQgPSBmYWxzZTtcbiAgICAgICAgICAgIHJlcXVlc3RHcmFiUmVkUGFja2V0KCk7XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAkZXZlbnQucmVkUGFja2V0R3JhcC5jbG9zZVZpZXcoKTtcbiAgICAgICAgfVxuICAgIH0sXG4gICAgY2xvc2VWaWV3KCkge1xuICAgICAgICBpZiAoYnV0dG9uQ2xpY2tlZCkge1xuICAgICAgICAgICAgcmV0dXJuO1xuICAgICAgICB9XG4gICAgICAgIGJ1dHRvbkNsaWNrZWQgPSB0cnVlO1xuICAgICAgICBpZiAoaW50ZXJjYWxUaW1lKSB7XG4gICAgICAgICAgICBjbGVhckludGVydmFsKGludGVyY2FsVGltZSk7XG4gICAgICAgICAgICBpbnRlcmNhbFRpbWUgPSBudWxsO1xuICAgICAgICB9XG4gICAgICAgIG5lZWRSZWxvYWQgPSBmYWxzZTtcbiAgICAgICAgJGRhdGEucmVkUGFja2V0R3JhcC5jbG9zZVZpZXcgPSB0cnVlO1xuICAgICAgICAkZGF0YS5yZWRQYWNrZXRHcmFwLmdyYXBTdGF0dXMgPSBcInZpc2libGVcIjtcbiAgICAgICAgJGRhdGEucmVkUGFja2V0R3JhcC5zbmF0Y2hlZFN0YXR1cyA9IFwiZ29uZVwiO1xuICAgICAgICAkZGF0YS5yZWRQYWNrZXRHcmFwLnNuYXRjaCA9IFwiZ29uZVwiO1xuICAgICAgICAkZGF0YS5yZWRQYWNrZXRHcmFwLnNuYXRjaEZhaWwgPSBcImdvbmVcIjtcbiAgICAgICAgJGRhdGEucmVkUGFja2V0R3JhcC5zbmF0Y2hBbmltYXRlID0gXCJnb25lXCI7XG4gICAgICAgICRldmVudC5yZWRQYWNrZXRRdWV1ZS5sb2NrUGFja2V0KHRydWUsIDEwMDApO1xuICAgIH0sXG4gICAgcmVsb2FkQ291bnREb3duKCkge1xuICAgICAgICBpZiAobmVlZFJlbG9hZCkge1xuICAgICAgICAgICAgcmVsb2FkVmlld0RhdGEoKTtcbiAgICAgICAgfVxuICAgIH0sXG4gICAgc3RhdHVzQ2hhbmdlKGV2ZW50UGFyYW0sIGFuaW1hdGlvbikge1xuICAgICAgICBjb25zb2xlLmxvZyhgc3RhdHVzQ2hhbmdlOiR7ZXZlbnRQYXJhbX0tJHthbmltYXRpb259YCk7XG4gICAgICAgIGlmIChldmVudFBhcmFtID09IFwic3RvcFwiICYmIGFuaW1hdGlvbiA9PSBcInNuYXRjaFwiKSB7XG4gICAgICAgICAgICBjb25zb2xlLmxvZyhgc25hdGNoQW5pbWF0ZTpnb25lYCk7XG4gICAgICAgIH1cbiAgICB9XG59XG5cbmFzeW5jIGZ1bmN0aW9uIHJlcXVlc3RHcmFiUmVkUGFja2V0KCkge1xuICAgIC8vIOiwg+eUqC3pooblj5bnuqLljIUgXG4gICAgLy8ganNvbkRhdGE6eyBsaXZlSWQsIHBhY2tldElkIH1cbiAgICBjb25zdCBwYWNrZXRJZCA9ICRkYXRhLnJlZFBhY2tldFF1ZXVlLmN1cnJlbnRQYWNrZXQucGFja2V0SWQ7XG4gICAgY29uc3QgcmVxdWVzdFBhcmFtID0geyBsaXZlSWQ6ICRkYXRhLnJlZFBhY2tldC5saXZlSWQsIHBhY2tldElkIH07XG4gICAgY29uc3QgcmVxdWVzdFBhcmFtcyA9IGdlbmVyYXRlUGFyYW1zKFxuICAgICAgICBcInYxL2NvbnRlbnQvYWN0aXZpdHkvcmVkLXBhY2tldC9zbmF0Y2hcIiwgcmVxdWVzdFBhcmFtLCAxLCAwLCB7IFwiQ29udGVudC1UeXBlXCI6IFwiYXBwbGljYXRpb24vanNvblwiIH1cbiAgICApO1xuICAgICRuYXRpdmVBUEkuaGJTaG93TG9hZGluZygxKTtcbiAgICB0cnkge1xuICAgICAgICBjb25zdCByZXNwb25zZVN0cmluZyA9IGF3YWl0ICRuYXRpdmVBUEkucmVxdWVzdChyZXF1ZXN0UGFyYW1zKTtcbiAgICAgICAgY29uc3QgeyBjb2RlLCBkYXRhLCBtZXNzYWdlIH0gPSBKU09OLnBhcnNlKHJlc3BvbnNlU3RyaW5nKTtcbiAgICAgICAgJG5hdGl2ZUFQSS5oYlNob3dMb2FkaW5nKDApO1xuICAgICAgICAvLyAyMDAx5pyq5oqi5Yiw77yMMjAwMuW3suaKouWujO+8jDIwMDPlt7LmiqLov4dcbiAgICAgICAgaWYgKGNvZGUgPT0gMjAwKSB7XG4gICAgICAgICAgICB2aWV3U3RhdHVzID0gMTtcbiAgICAgICAgICAgICRkYXRhLnJlZFBhY2tldEdyYXAuYW1vdW50ID0gYCR7ZGF0YS5hbW91bnR9YDtcbiAgICAgICAgICAgICRkYXRhLnJlZFBhY2tldEdyYXAuY3VycmVuY3kgPSBkYXRhLmN1cnJlbmN5O1xuICAgICAgICAgICAgJGRhdGEucmVkUGFja2V0R3JhcC5jb250ZW50ID0gYXdhaXQgcmVhbFZhbHVlU3RyaW5nKFwibl9yZWRwYWNrZXRfYWxlcnRfdGlwc1wiKTtcbiAgICAgICAgICAgICRldmVudC5yZWRQYWNrZXRRdWV1ZS5ncmFwRmluaXNoZWQocGFja2V0SWQpO1xuICAgICAgICAgICAgcmVsb2FkVmlld0RhdGEoKTtcbiAgICAgICAgfSBlbHNlIGlmIChjb2RlID09IDIwMDEgfHwgY29kZSA9PSAyMDAyIHx8IGNvZGUgPT0gMjAwMykge1xuICAgICAgICAgICAgdmlld1N0YXR1cyA9IDI7XG4gICAgICAgICAgICBjb25zb2xlLmxvZyhgcmVkLXBhY2tldC9zbmF0Y2ggcmVxdWVzdCBlcnJvciBjb2RlOiR7Y29kZX1gKTtcbiAgICAgICAgICAgICRkYXRhLnJlZFBhY2tldEdyYXAuY29udGVudCA9IGF3YWl0IHJlYWxWYWx1ZVN0cmluZyhcIm5fcmVkcGFja2V0X2FsZXJ0X3RpcHNfa2VlcFwiKTtcbiAgICAgICAgICAgICRldmVudC5yZWRQYWNrZXRRdWV1ZS5ncmFwRmluaXNoZWQocGFja2V0SWQpO1xuICAgICAgICAgICAgcmVsb2FkVmlld0RhdGEoKTtcbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICRuYXRpdmVBUEkuaGJUb2FzdEVycm9yKG1lc3NhZ2UpO1xuICAgICAgICB9XG4gICAgfSBjYXRjaCAoZSkge1xuICAgICAgICAkbmF0aXZlQVBJLmhiU2hvd0xvYWRpbmcoMCk7XG4gICAgICAgIGNvbnNvbGUubG9nKGByZWQtcGFja2V0L3NuYXRjaCByZXF1ZXN0IGVycm9yOiR7ZX1gKTtcbiAgICB9XG59XG5cbmFzeW5jIGZ1bmN0aW9uIHJlbG9hZFZpZXdEYXRhKCkge1xuICAgIGNvbnN0IGRhdGFQYWNrZXQgPSAkZGF0YS5yZWRQYWNrZXRRdWV1ZS5jdXJyZW50UGFja2V0O1xuICAgIGlmICh2aWV3U3RhdHVzID09IDApIHtcbiAgICAgICAgJGRhdGEucmVkUGFja2V0R3JhcC5ncmFwU3RhdHVzID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgICRkYXRhLnJlZFBhY2tldEdyYXAuc25hdGNoZWRTdGF0dXMgPSBcImdvbmVcIjtcbiAgICAgICAgJGRhdGEucmVkUGFja2V0R3JhcC5zbmF0Y2ggPSBcImdvbmVcIjtcbiAgICAgICAgJGRhdGEucmVkUGFja2V0R3JhcC5zbmF0Y2hGYWlsID0gXCJnb25lXCI7XG4gICAgICAgICRkYXRhLnJlZFBhY2tldEdyYXAuc25hdGNoQW5pbWF0ZSA9IFwiZ29uZVwiO1xuICAgICAgICAkZGF0YS5yZWRQYWNrZXRHcmFwLnRpdGxlID0gYXdhaXQgcmVhbFZhbHVlU3RyaW5nKFwibl9yZWRwYWNrZXRfYWxlcnRfdGl0bGVcIiwgW2RhdGFQYWNrZXQubmlja25hbWVdKTtcbiAgICAgICAgJGRhdGEucmVkUGFja2V0R3JhcC5jb250ZW50ID0gYCR7ZGF0YVBhY2tldC5hbW91bnR9ICR7ZGF0YVBhY2tldC5jdXJyZW5jeX1gO1xuXG4gICAgICAgIGlmIChkYXRhUGFja2V0LnJ1bGUgPT0gMiAmJiBkYXRhUGFja2V0LmNvdW50ZG93bi5sZW5ndGggPiAwKSB7XG4gICAgICAgICAgICBzaG93QnV0dG9uVGl0bGUoXCJuX3JlZHBhY2tldF9hbGVydF90aW1lXCIsIFtgJHtkYXRhUGFja2V0Lm19YCwgYCR7ZGF0YVBhY2tldC5zfWBdKTtcbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIHNob3dCdXR0b25UaXRsZShcIm5fcmVkcGFja2V0X2FsZXJ0X2RvbmVcIiwgW10pO1xuICAgICAgICB9XG4gICAgfSBlbHNlIGlmICh2aWV3U3RhdHVzID09IDEpIHtcbiAgICAgICAgJGRhdGEucmVkUGFja2V0R3JhcC5ncmFwU3RhdHVzID0gXCJnb25lXCI7XG4gICAgICAgICRkYXRhLnJlZFBhY2tldEdyYXAuc25hdGNoZWRTdGF0dXMgPSBcInZpc2libGVcIjtcbiAgICAgICAgJGRhdGEucmVkUGFja2V0R3JhcC5zbmF0Y2ggPSBcInZpc2libGVcIjtcbiAgICAgICAgJGRhdGEucmVkUGFja2V0R3JhcC5zbmF0Y2hGYWlsID0gXCJnb25lXCI7XG4gICAgICAgICRkYXRhLnJlZFBhY2tldEdyYXAuc25hdGNoQW5pbWF0ZSA9IFwidmlzaWJsZVwiO1xuICAgICAgICBzZXRUaW1lb3V0KCgpID0+IHtcbiAgICAgICAgICAgICRkYXRhLnJlZFBhY2tldEdyYXAuc25hdGNoQW5pbWF0ZSA9IFwiZ29uZVwiO1xuICAgICAgICB9LCAyMDAwKTtcbiAgICAgICAgJGRhdGEucmVkUGFja2V0R3JhcC50aXRsZSA9IGF3YWl0IHJlYWxWYWx1ZVN0cmluZyhcIm5fcmVkcGFja2V0X2FsZXJ0X3NuYXRjaFwiKTtcbiAgICAgICAgY291bnRkb3duVGl0bGUoKTtcbiAgICB9IGVsc2Uge1xuICAgICAgICAkZGF0YS5yZWRQYWNrZXRHcmFwLmdyYXBTdGF0dXMgPSBcImdvbmVcIjtcbiAgICAgICAgJGRhdGEucmVkUGFja2V0R3JhcC5zbmF0Y2hlZFN0YXR1cyA9IFwidmlzaWJsZVwiO1xuICAgICAgICAkZGF0YS5yZWRQYWNrZXRHcmFwLnNuYXRjaCA9IFwiZ29uZVwiO1xuICAgICAgICAkZGF0YS5yZWRQYWNrZXRHcmFwLnNuYXRjaEZhaWwgPSBcInZpc2libGVcIjtcbiAgICAgICAgJGRhdGEucmVkUGFja2V0R3JhcC5zbmF0Y2hBbmltYXRlID0gXCJnb25lXCI7XG4gICAgICAgICRkYXRhLnJlZFBhY2tldEdyYXAudGl0bGUgPSBhd2FpdCByZWFsVmFsdWVTdHJpbmcoXCJuX3JlZHBhY2tldF9hbGVydF9ub25lXCIpO1xuICAgICAgICBjb3VudGRvd25UaXRsZSgpO1xuICAgIH1cbn1cblxuYXN5bmMgZnVuY3Rpb24gY291bnRkb3duVGl0bGUoKSB7XG4gICAgc2hvd0J1dHRvblRpdGxlKFwibl9yZWRwYWNrZXRfYWxlcnRfa25vd1wiLCBbXCI1c1wiXSk7XG4gICAgdmFyIHRpbWUgPSA1O1xuICAgIGlmIChpbnRlcmNhbFRpbWUpIHtcbiAgICAgICAgY2xlYXJJbnRlcnZhbChpbnRlcmNhbFRpbWUpO1xuICAgIH1cbiAgICBpbnRlcmNhbFRpbWUgPSBzZXRJbnRlcnZhbCgoKSA9PiB7XG4gICAgICAgIGlmICh0aW1lID4gMSkge1xuICAgICAgICAgICAgdGltZSA9IHRpbWUgLSAxO1xuICAgICAgICAgICAgc2hvd0J1dHRvblRpdGxlKFwibl9yZWRwYWNrZXRfYWxlcnRfa25vd1wiLCBbYCR7dGltZX1zYF0pO1xuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgY2xlYXJJbnRlcnZhbChpbnRlcmNhbFRpbWUpO1xuICAgICAgICAgICAgaW50ZXJjYWxUaW1lID0gbnVsbDtcbiAgICAgICAgICAgICRldmVudC5yZWRQYWNrZXRHcmFwLmNsb3NlVmlldygpO1xuICAgICAgICB9XG4gICAgfSwgMTAwMCk7XG59XG5cbmFzeW5jIGZ1bmN0aW9uIHNob3dCdXR0b25UaXRsZShrZXksIHJlYWxWYWx1ZSkge1xuICAgICRkYXRhLnJlZFBhY2tldEdyYXAuYnV0dG9uVGl0bGUgPSBhd2FpdCByZWFsVmFsdWVTdHJpbmcoa2V5LCByZWFsVmFsdWUpO1xufVxuIiwiaW1wb3J0IHsgZ2VuZXJhdGVQYXJhbXMgfSBmcm9tIFwiLi91dGlsXCJcblxudmFyIGN1cnJlbnRJbmRleCA9IDA7XG5cbi8vLyDnuqLljIXliJ3lp4vljJbmlbDmja5cbiRkYXRhLnJlZFBhY2tldFJlY29yZCA9IHtcbiAgICByZWNvcmRUeXBlczoge1xuICAgICAgICAwOiB7XG4gICAgICAgICAgICBjb2xvcjogXCIjRkZGRkZGXCIsXG4gICAgICAgICAgICBsaW5lOiBcInZpc2libGVcIixcbiAgICAgICAgICAgIGRhdGFMaXN0OiBbXSxcbiAgICAgICAgfSxcbiAgICAgICAgMToge1xuICAgICAgICAgICAgY29sb3I6IFwiIzhDOEM5M1wiLFxuICAgICAgICAgICAgbGluZTogXCJnb25lXCIsXG4gICAgICAgICAgICBkYXRhTGlzdDogW10sXG4gICAgICAgIH1cbiAgICB9LFxuICAgIHJlY29yZExpc3Q6IFtdLFxuICAgIHJlY29yZFNob3c6IFwiZ29uZVwiLFxuICAgIHJlY29yZEVtcHR5U2hvdzogXCJ2aXNpYmxlXCIsXG4gICAgcmVmcmVzaFN0YXR1czogXCIwXCIsIC8vIDE95Yi35paw5Lit77yMMj3liLfmlrDlrozmiJBcbn1cblxuLy8vIOe6ouWMheS4muWKoSBldmVudCBmdW5jdGlvblxuJGV2ZW50LnJlZFBhY2tldFJlY29yZCA9IHtcbiAgICB0YWJDbGlja2VkKGluZGV4KSB7XG4gICAgICAgICRkYXRhLnJlZFBhY2tldFJlY29yZC5yZWNvcmRUeXBlc1tjdXJyZW50SW5kZXhdLmNvbG9yID0gXCIjOEM4QzkzXCI7XG4gICAgICAgICRkYXRhLnJlZFBhY2tldFJlY29yZC5yZWNvcmRUeXBlc1tjdXJyZW50SW5kZXhdLmxpbmUgPSBcImdvbmVcIjtcbiAgICAgICAgLy8g5paw6YCJ5oup6K6+572uXG4gICAgICAgIHZhciBuZXdUYXAgPSAkZGF0YS5yZWRQYWNrZXRSZWNvcmQucmVjb3JkVHlwZXNbaW5kZXhdO1xuICAgICAgICBuZXdUYXAuY29sb3IgPSBcIiNGRkZGRkZcIjtcbiAgICAgICAgbmV3VGFwLmxpbmUgPSBcInZpc2libGVcIjtcbiAgICAgICAgJGRhdGEucmVkUGFja2V0UmVjb3JkLnJlY29yZExpc3QgPSBuZXdUYXAuZGF0YUxpc3Q7XG4gICAgICAgIGN1cnJlbnRJbmRleCA9IGluZGV4O1xuICAgICAgICAkZGF0YS5yZWRQYWNrZXRSZWNvcmQucmVmcmVzaFN0YXR1cyA9IFwiMFwiO1xuICAgICAgICByZXF1ZXN0UmVjb3JkKCk7XG4gICAgfVxufVxuXG4kZXZlbnQucmVmcmVzaCA9IGZ1bmN0aW9uIHJlY29yZFJlZnJlc2goKSB7XG4gICAgcmVxdWVzdFJlY29yZCgpO1xufVxuXG4vLy8g57qi5YyF5Lia5Yqh55qEIHByaXZhdGUg5pa55rOVXG5hc3luYyBmdW5jdGlvbiByZXF1ZXN0UmVjb3JkKCkge1xuICAgIGNvbnN0IHR5cGUgPSBjdXJyZW50SW5kZXggPT0gMCA/IDEgOiAyO1xuICAgIGNvbnN0IHBhcmFtID0ge1xuICAgICAgICBkaXJlY3Rpb246IDEsIC8vIOaVsOaNruaLieWPluaWueWQke+8jDHmraPluo/vvIjlj5bmlrDmtojmga/vvInvvIwy6YCG5bqP77yI5Y+W5pen5raI5oGv77yJ6buY6K6kMVxuICAgICAgICBpZDogMCwgLy8gaWQg6buY6K6kMCDmoLnmja7mnIDlkI7kuIDmnaHov5Tlm57nmoTmlbDmja7kvKDlhaVcbiAgICAgICAgcGFnZVNpemU6IDEwMCxcbiAgICAgICAgdHlwZSwgLy8gMeWPkemAgee6ouWMhe+8jDLmjqXmlLbnuqLljIVcbiAgICAgICAgbGl2ZUlkOiAkZGF0YS5yZWRQYWNrZXQubGl2ZUlkLFxuICAgIH07XG4gICAgY29uc3QgcmVxdWVzdFBhcmFtcyA9IGdlbmVyYXRlUGFyYW1zKFxuICAgICAgICBcInYxL2NvbnRlbnQvYWN0aXZpdHkvcmVkLXBhY2tldC9vcmRlckxpc3RcIiwgcGFyYW1cbiAgICApO1xuICAgIGNvbnNvbGUubG9nKFwib3JkZXJMaXN06K+35rGC5Y+C5pWw77yaIFwiICsgcmVxdWVzdFBhcmFtcyk7XG4gICAgJG5hdGl2ZUFQSS5oYlNob3dMb2FkaW5nKDEpO1xuICAgIHRyeSB7XG4gICAgICAgIGNvbnN0IHJlc3BvbnNlU3RyaW5nID0gYXdhaXQgJG5hdGl2ZUFQSS5yZXF1ZXN0KHJlcXVlc3RQYXJhbXMpO1xuICAgICAgICBjb25zdCB7IGNvZGUsIGRhdGEgfSA9IEpTT04ucGFyc2UocmVzcG9uc2VTdHJpbmcpO1xuICAgICAgICAkbmF0aXZlQVBJLmhiU2hvd0xvYWRpbmcoMCk7XG4gICAgICAgICRkYXRhLnJlZFBhY2tldFJlY29yZC5yZWZyZXNoU3RhdHVzID0gXCIyXCI7XG4gICAgICAgIGlmIChjb2RlID09IDIwMCkge1xuICAgICAgICAgICAgY29udmVydFJlY3ljbGVJdGVtKGRhdGEubGlzdERhdGEsIFwibm9ybWFsXCIpO1xuICAgICAgICAgICAgJGRhdGEucmVkUGFja2V0UmVjb3JkLnJlY29yZFR5cGVzW2N1cnJlbnRJbmRleF0uZGF0YUxpc3QgPSBkYXRhLmxpc3REYXRhO1xuICAgICAgICAgICAgJGRhdGEucmVkUGFja2V0UmVjb3JkLnJlY29yZExpc3QgPSBkYXRhLmxpc3REYXRhO1xuICAgICAgICAgICAgaWYgKGRhdGEubGlzdERhdGEubGVuZ3RoID4gMCkge1xuICAgICAgICAgICAgICAgICRkYXRhLnJlZFBhY2tldFJlY29yZC5yZWNvcmRTaG93ID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgICAgICAgICAgJGRhdGEucmVkUGFja2V0UmVjb3JkLnJlY29yZEVtcHR5U2hvdyA9IFwiZ29uZVwiO1xuICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgICAkZGF0YS5yZWRQYWNrZXRSZWNvcmQucmVjb3JkU2hvdyA9IFwiZ29uZVwiO1xuICAgICAgICAgICAgICAgICRkYXRhLnJlZFBhY2tldFJlY29yZC5yZWNvcmRFbXB0eVNob3cgPSBcInZpc2libGVcIjtcbiAgICAgICAgICAgIH1cbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIGNvbnNvbGUubG9nKGByZWQtcGFja2V0L29yZGVyTGlzdCByZXF1ZXN0IGVycm9yIGNvZGU6JHtjb2RlfWApO1xuICAgICAgICB9XG4gICAgfSBjYXRjaCAoZSkge1xuICAgICAgICAkZGF0YS5yZWRQYWNrZXRSZWNvcmQucmVmcmVzaFN0YXR1cyA9IFwiMlwiO1xuICAgICAgICAkbmF0aXZlQVBJLmhiU2hvd0xvYWRpbmcoMCk7XG4gICAgICAgIGNvbnNvbGUubG9nKGByZWQtcGFja2V0L29yZGVyTGlzdCByZXF1ZXN0IGVycm9yOiR7ZX1gKTtcbiAgICB9XG59XG5cbmZ1bmN0aW9uIGNvbnZlcnRSZWN5Y2xlSXRlbShsaXN0RGF0YSwgdHlwZUtleSkge1xuICAgIGZvciAodmFyIGluZGV4ID0gMDsgaW5kZXggPCBsaXN0RGF0YS5sZW5ndGg7ICsraW5kZXgpIHtcbiAgICAgICAgdmFyIGVsZW1lbnQgPSBsaXN0RGF0YVtpbmRleF07XG4gICAgICAgIGVsZW1lbnQudHlwZSA9IHR5cGVLZXk7XG4gICAgICAgIGlmIChlbGVtZW50LmNyZWF0ZVRpbWUpIHtcbiAgICAgICAgICAgIGVsZW1lbnQuY3JlYXRlVGltZSA9IG5ldyBEYXRlKGVsZW1lbnQuY3JlYXRlVGltZSkuRm9ybWF0KFwieXl5eS1NTS1kZCBoaDptbTpzc1wiKTtcbiAgICAgICAgfVxuICAgIH1cbn1cbiJdLCJuYW1lcyI6WyJnZW5lcmF0ZVBhcmFtcyIsInBhdGgiLCJwYXJhbXMiLCJtZXRob2QiLCJob3N0VHlwZSIsImhlYWRlciIsInBhcmFtIiwiY29uc29sZSIsImxvZyIsIkpTT04iLCJzdHJpbmdpZnkiLCJhc3luYyIsInJlYWxWYWx1ZVN0cmluZyIsImtleSIsInJlYWxWYWx1ZSIsInJlYWxEaWN0IiwiJG5hdGl2ZUFQSSIsImkxOG4iLCJEYXRlIiwicHJvdG90eXBlIiwiRm9ybWF0IiwiZm10IiwibyIsInRoaXMiLCJnZXRNb250aCIsImdldERhdGUiLCJnZXRIb3VycyIsImdldE1pbnV0ZXMiLCJnZXRTZWNvbmRzIiwiTWF0aCIsImZsb29yIiwiUyIsImdldE1pbGxpc2Vjb25kcyIsInRlc3QiLCJyZXBsYWNlIiwiUmVnRXhwIiwiJDEiLCJnZXRGdWxsWWVhciIsInN1YnN0ciIsImxlbmd0aCIsImsiLCJsaXZlSWQiLCJjdXJyZW50SW5kZXgiLCJsYXN0UGF0aCIsInNlY3Rpb24iLCJyb3ciLCJydWxlIiwiJGRhdGEiLCJyZWRQYWNrZXQiLCJjdXJyZW5jeUxpc3QiLCJjZWxsRGF0YUxpc3QiLCJhZnRlclRpbWUiLCJkZWxheU9wdGlvbkltYWdlIiwicmVhbE9wdGlvbkltYWdlIiwic2hvd0JhbGFuY2UiLCJwb3BTaG93Iiwic2VuZFNob3ciLCJyZWNvcmRTaG93IiwiY2xvc2VWaWV3IiwiJGV2ZW50Iiwic2V0TGl2ZUlkIiwibGl2ZUlEIiwiaW5pdFdpdGhMaXZlSWQiLCJyZWRQYWNrZXRRdWV1ZSIsInNlbmRPcGVuU3RhdHVzIiwicmVjb3JkQ2xpY2tlZCIsInJlcXVlc3RUZW1wbGF0ZUxpc3QiLCJjdXJyZW5jeUNsaWNrZWQiLCJpbmRleCIsImNvbG9yIiwibGluZSIsIm5ld0N1cnJlbmN5IiwiY2VsbExpc3QiLCJyYXdBcnJheSIsImJhbGFuY2UiLCJjdXJyZW5jeSIsInNlbGVjdFBhdGgiLCJjZWxsRGlkU2VsZWN0ZWQiLCJsYXN0Q2VsbERhdGEiLCJsaXN0Iiwib3BhY2l0eSIsImJvcmRlcldpZHRoIiwiY2VsbERhdGEiLCJvcHRpb25DbGlja2VkIiwic2VsZWN0UnVsZSIsInN1Ym1pdENsaWNrZWQiLCJyZXF1ZXN0U2VuZCIsImlzQmFjayIsInJlZFBhY2tldFJlY29yZCIsInRhYkNsaWNrZWQiLCJvcGVuRGVwb3NpdFJvdXRlIiwidXJsIiwib3BlblJvdXRlIiwiY2xvc2VBbGVydCIsInRyYW5zZmVyIiwiY2FuY2VsVXJsIiwiZGVwb3NpdCIsImNsb3NlU2VuZFZpZXciLCJyZXNldEN1cnJlbmN5TGlzdCIsImRhdGFMaXN0IiwidGVtcExpc3QiLCJkaWN0IiwidmlzaWJpbGl0eSIsImVsZW1lbnQiLCJnZXRDZWxsRGF0YUxpc3QiLCJuZXdEYXRhIiwiY2VsbERpY3QiLCJ0eXBlIiwiZGF0YSIsImNvbnRlbnQiLCJudW1iZXIiLCJhbW91bnRTdHIiLCJhbW91bnQiLCJwdXNoIiwicmVxdWVzdFBhcmFtcyIsImhiU2hvd0xvYWRpbmciLCJyZXNwb25zZVN0cmluZyIsInJlcXVlc3QiLCJjb2RlIiwicGFyc2UiLCJ0aW1lIiwiZSIsInRlbXBsYXRlSWQiLCJpZCIsIm1lc3NhZ2UiLCJwYXlSZXN1bHQiLCJ0b2FzdFN0ciIsImhiVG9hc3RFcnJvciIsImZhaWxTdHIiLCJwYWNrZXRRdWV1ZSIsInNlcnZlclRpbWUiLCJzeXNUaW1lIiwiY3VycmVudFBhY2tldCIsInMiLCJtIiwicmVmcmVzaFBhY2tldCIsIm9wZW5QYWNrZXRMaXN0IiwiaW5pdFBhY2tldCIsInBhY2tldElkIiwibmlja25hbWUiLCJzdGFydFRpbWUiLCJhdmF0YXIiLCJjb3VudGRvd24iLCJhZGRQYWNrZXRMaXN0IiwianNvbkRhdGEiLCJnZXRUaW1lIiwicmVkcGFja2V0TGlzdCIsImNvbmNhdCIsInNvcnRQYWNrZXRRdWV1ZSIsImFkZFNpbmdsZVBhY2tldCIsInBhY2tldCIsImN1cnJlbnRUaW1lIiwiZGVsZXRlUGFja2V0IiwibmV3UXVldWUiLCJjaGFuZ2VDdXJyZW50UXVldWUiLCJnb3RQYWNrZXQiLCJjaGFuZ2VQYWNrZXRPcGVuU3RhdHVzIiwib3BlblN0YXR1cyIsImNsZWFyRGF0YSIsImNsZWFySW50ZXJ2YWwiLCJpbnRlcmNhbCIsImdyYXBGaW5pc2hlZCIsImxvY2tQYWNrZXQiLCJsb2NrIiwic2V0VGltZW91dCIsIkFycmF5IiwiZnJvbSIsIlNldCIsInNvcnQiLCJwMSIsInAyIiwicGFyc2VGbG9hdCIsImxpc3RlbkN1cnJlbnRQYWNrZXQiLCJzZXJ2ZXJUaW1lRGlmZiIsInN5c1RpbWVEaWZmIiwiZGlmZmVyZW5jZSIsInNob3dNIiwic2hvd1MiLCJyZWRQYWNrZXRHcmFwIiwicmVsb2FkQ291bnREb3duIiwicGFja2V0SWRWYWwiLCJpc09wZW5lZCIsImluY2x1ZGVzIiwibmVlZE9wZW5WaWV3Iiwib3BlblZpZXciLCJzZXRJbnRlcnZhbCIsInZpZXdTdGF0dXMiLCJpbnRlcmNhbFRpbWUiLCJuZWVkUmVsb2FkIiwiYnV0dG9uQ2xpY2tlZCIsImdyYXBTdGF0dXMiLCJzbmF0Y2hlZFN0YXR1cyIsInNuYXRjaCIsInNuYXRjaEZhaWwiLCJ0aXRsZSIsInNuYXRjaEFuaW1hdGUiLCJzbmF0Y2hTdGF0dXMiLCJhbGVydFN0YXR1cyIsIndhaXRTdGF0dXMiLCJsb2FkQWxlcnRWaWV3IiwicmVsb2FkVmlld0RhdGEiLCJkYXRhUGFja2V0IiwicmVxdWVzdEdyYWJSZWRQYWNrZXQiLCJzdGF0dXNDaGFuZ2UiLCJldmVudFBhcmFtIiwiYW5pbWF0aW9uIiwicmVxdWVzdFBhcmFtIiwic2hvd0J1dHRvblRpdGxlIiwiY291bnRkb3duVGl0bGUiLCJidXR0b25UaXRsZSIsInJlY29yZFR5cGVzIiwicmVjb3JkTGlzdCIsInJlY29yZEVtcHR5U2hvdyIsInJlZnJlc2hTdGF0dXMiLCJuZXdUYXAiLCJyZXF1ZXN0UmVjb3JkIiwicmVmcmVzaCIsInJlY29yZFJlZnJlc2giLCJkaXJlY3Rpb24iLCJwYWdlU2l6ZSIsImNvbnZlcnRSZWN5Y2xlSXRlbSIsImxpc3REYXRhIiwidHlwZUtleSIsImNyZWF0ZVRpbWUiXSwibWFwcGluZ3MiOiJBQVFPLFNBQVNBLGVBQWVDLE1BQU1DLFNBQVMsSUFBSUMsU0FBUyxHQUFHQyxXQUFXLEdBQUdDLFNBQVM7SUFDakYsTUFBTUMsUUFBUTtRQUNWTDtRQUNBRTtRQUNBQztRQUNBQztRQUNBSDs7SUFFSkssUUFBUUMsSUFBSSxxQkFBcUJGO0lBQ2pDLE9BQU9HLEtBQUtDLFVBQVVKO0FBQzFCOztBQUVPSyxlQUFlQyxnQkFBZ0JDLEtBQUtD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
