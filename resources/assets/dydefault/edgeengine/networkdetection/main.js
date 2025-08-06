var gBool = false;

var dBool = false;

var hBool = false;

var bBool = false;

var oBool = false;

var spotBool = false;

var webBool = false;

async function initData() {
    capture();
    var dicStr = await onEvent();
    console.log("dicStr " + dicStr);
    var dic = JSON.parse(dicStr);
    $data.phone = dic.phone;
    console.log("dicStr " + dic.phone);
    $data.version = dic.version;
    $data.vtoken = dic.vtoken;
    $data.osVersion = dic.osVersion;
    $data.screenWidth = dic.screenWidth;
    $data.screenHeight = dic.screenHeight;
    $data.language = dic.language;
    $data.ip = dic.ip;
    $data.operator = dic.networkOperator;
    $data.dns = dic.dns;
    $data.vpn = getVpnStatus(dic.vpn);
    $data.networkType = dic.networkType;
    updateRegionInfo(dic.region);
    gPingRequest();
    bPingRequest();
    dPingRequest();
    hPingRequest();
    oPingRequest();
    hPingRequest();
    spotPingRequest();
    webRequest();
    refreshNetworkType();
}

initData();

async function onEvent() {
    return $nativeAPI.onEvent();
}

function finishDetection() {
    if (webBool && spotBool && oBool && gBool && bBool && dBool && hBool) {
        $data.save = $i18n.n_share_save_image;
    }
}

async function dPingRequest() {
    const requestParams = "https://www.baidu.com";
    try {
        $nativeAPI.pingRequest(requestParams).then((async response => {
            $data.dPing = response;
            dBool = true;
            finishDetection();
        }));
    } catch (e) {
        console.log(`pingRequest error:${e}`);
        $data.dPing = $i18n.network_connect_failed;
        dBool = true;
        finishDetection();
    }
}

async function hPingRequest() {
    const requestParams = "https://www.htx.com";
    try {
        $nativeAPI.pingRequest(requestParams).then((async response => {
            $data.hPing = response;
            hBool = true;
            finishDetection();
        }));
    } catch (e) {
        console.log(`pingRequest error:${e}`);
        $data.hPing = $i18n.network_connect_failed;
        hBool = true;
        finishDetection();
    }
}

async function spotPingRequest() {
    const requestParams = "spot";
    try {
        $nativeAPI.pingRequest(requestParams).then((async response => {
            $data.spot = response;
            spotBool = true;
            finishDetection();
        }));
    } catch (e) {
        console.log(`pingRequest error:${e}`);
        $data.spot = $i18n.network_connect_failed;
        spotBool = true;
        finishDetection();
    }
}

async function webRequest() {
    const requestParams = "web";
    try {
        $nativeAPI.pingRequest(requestParams).then((async response => {
            $data.web = response;
            webBool = true;
            finishDetection();
        }));
    } catch (e) {
        console.log(`pingRequest error:${e}`);
        $data.web = $i18n.network_connect_failed;
        webBool = true;
        finishDetection();
    }
}

async function gPingRequest() {
    const requestParams = "https://www.google.com";
    try {
        $nativeAPI.pingRequest(requestParams).then((async response => {
            $data.gPing = response;
            gBool = true;
            finishDetection();
        }));
    } catch (e) {
        gBool = true;
        finishDetection();
        console.log(`gPingRequest error:${e}`);
        $data.gPing = $i18n.network_connect_failed;
    }
}

async function bPingRequest() {
    const requestParams = "https://www.binance.com";
    try {
        $nativeAPI.pingRequest(requestParams).then((async response => {
            $data.bPing = response;
            bBool = true;
            finishDetection();
        }));
    } catch (e) {
        bBool = true;
        finishDetection();
        console.log(`bPingRequest error:${e}`);
        $data.bPing = $i18n.network_connect_failed;
    }
}

async function oPingRequest() {
    const requestParams = "https://www.okx.com";
    try {
        $nativeAPI.pingRequest(requestParams).then((async response => {
            $data.oPing = response;
            oBool = true;
            finishDetection();
        }));
    } catch (e) {
        oBool = true;
        finishDetection();
        console.log(`oPingRequest error:${e}`);
        $data.oPing = $i18n.network_connect_failed;
    }
}

function capture() {
    if (webBool && spotBool && oBool && gBool && bBool && dBool && hBool) {
        $nativeAPI.capture();
    }
}

async function refreshNetworkType() {
    $data.networkType = await $nativeAPI.networkTypeStatus();
}

function getVpnStatus(status) {
    if (typeof status === "string" || status instanceof String) {
        if (status == "true") {
            return $i18n.n_shark_fin_autoSubscribe_open;
        }
    }
    return $i18n.n_shark_fin_autoSubscribe_close;
}

function updateRegionInfo(region) {
    if (typeof region === "string" || region instanceof String) {
        $data.region = region;
        $data.regionVisible = "visible";
    }
}
//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoibWFpbi5qcyIsInNvdXJjZXMiOlsiLi4vLi4vcmVwb3NpdG9yeS9zcmMvbmV0d29yay5qcyJdLCJzb3VyY2VzQ29udGVudCI6WyJ2YXIgZ0Jvb2wgPSBmYWxzZTtcbnZhciBkQm9vbCA9IGZhbHNlO1xudmFyIGhCb29sID0gZmFsc2U7XG52YXIgYkJvb2wgPSBmYWxzZTtcbnZhciBvQm9vbCA9IGZhbHNlO1xudmFyIHNwb3RCb29sID0gZmFsc2U7XG52YXIgd2ViQm9vbCA9IGZhbHNlO1xuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGluaXREYXRhKCkge1xuICAgIGNhcHR1cmUoKTtcbiAgICB2YXIgZGljU3RyID0gYXdhaXQgb25FdmVudCgpO1xuXG4gICAgY29uc29sZS5sb2coXCJkaWNTdHIgXCIgKyBkaWNTdHIpO1xuICAgIHZhciBkaWMgPSBKU09OLnBhcnNlKGRpY1N0cik7XG4gICAgJGRhdGEucGhvbmUgPSBkaWMucGhvbmU7XG4gICAgY29uc29sZS5sb2coXCJkaWNTdHIgXCIgKyBkaWMucGhvbmUpO1xuICAgICRkYXRhLnZlcnNpb24gPSBkaWMudmVyc2lvbjtcbiAgICAkZGF0YS52dG9rZW4gPSBkaWMudnRva2VuO1xuICAgICRkYXRhLm9zVmVyc2lvbiA9IGRpYy5vc1ZlcnNpb247XG4gICAgJGRhdGEuc2NyZWVuV2lkdGggPSBkaWMuc2NyZWVuV2lkdGg7XG4gICAgJGRhdGEuc2NyZWVuSGVpZ2h0ID0gZGljLnNjcmVlbkhlaWdodDtcbiAgICAkZGF0YS5sYW5ndWFnZSA9IGRpYy5sYW5ndWFnZTtcbiAgICAkZGF0YS5pcCA9IGRpYy5pcDtcbiAgICAkZGF0YS5vcGVyYXRvciA9IGRpYy5uZXR3b3JrT3BlcmF0b3I7XG4gICAgJGRhdGEuZG5zID0gZGljLmRucztcbiAgICAkZGF0YS52cG4gPSBnZXRWcG5TdGF0dXMoZGljLnZwbik7XG4gICAgJGRhdGEubmV0d29ya1R5cGUgPSBkaWMubmV0d29ya1R5cGU7XG4gICAgdXBkYXRlUmVnaW9uSW5mbyhkaWMucmVnaW9uKTtcblxuICAgIGdQaW5nUmVxdWVzdCgpO1xuICAgIGJQaW5nUmVxdWVzdCgpO1xuICAgIGRQaW5nUmVxdWVzdCgpO1xuICAgIGhQaW5nUmVxdWVzdCgpO1xuICAgIG9QaW5nUmVxdWVzdCgpO1xuICAgIGhQaW5nUmVxdWVzdCgpO1xuICAgIHNwb3RQaW5nUmVxdWVzdCgpO1xuICAgIHdlYlJlcXVlc3QoKTtcblxuICAgIHJlZnJlc2hOZXR3b3JrVHlwZSgpO1xufVxuXG5pbml0RGF0YSgpO1xuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gb25FdmVudCgpIHtcbiAgICByZXR1cm4gJG5hdGl2ZUFQSS5vbkV2ZW50KCk7XG59XG5cbmV4cG9ydCBmdW5jdGlvbiBmaW5pc2hEZXRlY3Rpb24oKSB7XG4gICAgaWYgKHdlYkJvb2wgJiYgc3BvdEJvb2wgJiYgb0Jvb2wgJiYgZ0Jvb2wgJiYgYkJvb2wgJiYgZEJvb2wgJiYgaEJvb2wpIHtcbiAgICAgICAgJGRhdGEuc2F2ZSA9ICRpMThuLm5fc2hhcmVfc2F2ZV9pbWFnZTtcbiAgICB9XG59XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBkUGluZ1JlcXVlc3QoKSB7XG4gICAgY29uc3QgcmVxdWVzdFBhcmFtcyA9ICdodHRwczovL3d3dy5iYWlkdS5jb20nO1xuICAgIHRyeSB7XG4gICAgICAgICRuYXRpdmVBUEkucGluZ1JlcXVlc3QocmVxdWVzdFBhcmFtcykudGhlbihhc3luYyByZXNwb25zZSA9PiB7XG4gICAgICAgICAgICAkZGF0YS5kUGluZyA9IHJlc3BvbnNlO1xuICAgICAgICAgICAgZEJvb2wgPSB0cnVlO1xuICAgICAgICAgICAgZmluaXNoRGV0ZWN0aW9uKCk7XG4gICAgICAgIH0pO1xuICAgIH0gY2F0Y2ggKGUpIHtcbiAgICAgICAgY29uc29sZS5sb2coYHBpbmdSZXF1ZXN0IGVycm9yOiR7ZX1gKTtcbiAgICAgICAgJGRhdGEuZFBpbmcgPSAkaTE4bi5uZXR3b3JrX2Nvbm5lY3RfZmFpbGVkO1xuICAgICAgICBkQm9vbCA9IHRydWU7XG4gICAgICAgIGZpbmlzaERldGVjdGlvbigpO1xuICAgIH1cbn1cblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGhQaW5nUmVxdWVzdCgpIHtcbiAgICBjb25zdCByZXF1ZXN0UGFyYW1zID0gJ2h0dHBzOi8vd3d3Lmh0eC5jb20nO1xuICAgIHRyeSB7XG4gICAgICAgICRuYXRpdmVBUEkucGluZ1JlcXVlc3QocmVxdWVzdFBhcmFtcykudGhlbihhc3luYyByZXNwb25zZSA9PiB7XG4gICAgICAgICAgICAkZGF0YS5oUGluZyA9IHJlc3BvbnNlO1xuICAgICAgICAgICAgaEJvb2wgPSB0cnVlO1xuICAgICAgICAgICAgZmluaXNoRGV0ZWN0aW9uKCk7XG4gICAgICAgIH0pO1xuICAgIH0gY2F0Y2ggKGUpIHtcbiAgICAgICAgY29uc29sZS5sb2coYHBpbmdSZXF1ZXN0IGVycm9yOiR7ZX1gKTtcbiAgICAgICAgJGRhdGEuaFBpbmcgPSAkaTE4bi5uZXR3b3JrX2Nvbm5lY3RfZmFpbGVkO1xuICAgICAgICBoQm9vbCA9IHRydWU7XG4gICAgICAgIGZpbmlzaERldGVjdGlvbigpO1xuICAgIH1cbn1cblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHNwb3RQaW5nUmVxdWVzdCgpIHtcbiAgICBjb25zdCByZXF1ZXN0UGFyYW1zID0gJ3Nwb3QnO1xuICAgIHRyeSB7XG4gICAgICAgICRuYXRpdmVBUEkucGluZ1JlcXVlc3QocmVxdWVzdFBhcmFtcykudGhlbihhc3luYyByZXNwb25zZSA9PiB7XG4gICAgICAgICAgICAkZGF0YS5zcG90ID0gcmVzcG9uc2U7XG4gICAgICAgICAgICBzcG90Qm9vbCA9IHRydWU7XG4gICAgICAgICAgICBmaW5pc2hEZXRlY3Rpb24oKTtcbiAgICAgICAgfSk7XG4gICAgfSBjYXRjaCAoZSkge1xuICAgICAgICBjb25zb2xlLmxvZyhgcGluZ1JlcXVlc3QgZXJyb3I6JHtlfWApO1xuICAgICAgICAkZGF0YS5zcG90ID0gJGkxOG4ubmV0d29ya19jb25uZWN0X2ZhaWxlZDtcbiAgICAgICAgc3BvdEJvb2wgPSB0cnVlO1xuICAgICAgICBmaW5pc2hEZXRlY3Rpb24oKTtcbiAgICB9XG59XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiB3ZWJSZXF1ZXN0KCkge1xuICAgIGNvbnN0IHJlcXVlc3RQYXJhbXMgPSAnd2ViJztcbiAgICB0cnkge1xuICAgICAgICAkbmF0aXZlQVBJLnBpbmdSZXF1ZXN0KHJlcXVlc3RQYXJhbXMpLnRoZW4oYXN5bmMgcmVzcG9uc2UgPT4ge1xuICAgICAgICAgICAgJGRhdGEud2ViID0gcmVzcG9uc2U7XG4gICAgICAgICAgICB3ZWJCb29sID0gdHJ1ZTtcbiAgICAgICAgICAgIGZpbmlzaERldGVjdGlvbigpO1xuICAgICAgICB9KTtcbiAgICB9IGNhdGNoIChlKSB7XG4gICAgICAgIGNvbnNvbGUubG9nKGBwaW5nUmVxdWVzdCBlcnJvcjoke2V9YCk7XG4gICAgICAgICRkYXRhLndlYiA9ICRpMThuLm5ldHdvcmtfY29ubmVjdF9mYWlsZWQ7XG4gICAgICAgIHdlYkJvb2wgPSB0cnVlO1xuICAgICAgICBmaW5pc2hEZXRlY3Rpb24oKTtcbiAgICB9XG59XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBnUGluZ1JlcXVlc3QoKSB7XG4gICAgY29uc3QgcmVxdWVzdFBhcmFtcyA9ICdodHRwczovL3d3dy5nb29nbGUuY29tJztcbiAgICB0cnkge1xuICAgICAgICAkbmF0aXZlQVBJLnBpbmdSZXF1ZXN0KHJlcXVlc3RQYXJhbXMpLnRoZW4oYXN5bmMgcmVzcG9uc2UgPT4ge1xuICAgICAgICAgICAgJGRhdGEuZ1BpbmcgPSByZXNwb25zZTtcbiAgICAgICAgICAgIGdCb29sID0gdHJ1ZTtcbiAgICAgICAgICAgIGZpbmlzaERldGVjdGlvbigpO1xuICAgICAgICB9KTtcbiAgICB9IGNhdGNoIChlKSB7XG4gICAgICAgIGdCb29sID0gdHJ1ZTtcbiAgICAgICAgZmluaXNoRGV0ZWN0aW9uKCk7XG4gICAgICAgIGNvbnNvbGUubG9nKGBnUGluZ1JlcXVlc3QgZXJyb3I6JHtlfWApO1xuICAgICAgICAkZGF0YS5nUGluZyA9ICRpMThuLm5ldHdvcmtfY29ubmVjdF9mYWlsZWQ7XG4gICAgfVxufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gYlBpbmdSZXF1ZXN0KCkge1xuICAgIGNvbnN0IHJlcXVlc3RQYXJhbXMgPSAnaHR0cHM6Ly93d3cuYmluYW5jZS5jb20nO1xuICAgIHRyeSB7XG4gICAgICAgICRuYXRpdmVBUEkucGluZ1JlcXVlc3QocmVxdWVzdFBhcmFtcykudGhlbihhc3luYyByZXNwb25zZSA9PiB7XG4gICAgICAgICAgICAkZGF0YS5iUGluZyA9IHJlc3BvbnNlO1xuICAgICAgICAgICAgYkJvb2wgPSB0cnVlO1xuICAgICAgICAgICAgZmluaXNoRGV0ZWN0aW9uKCk7XG4gICAgICAgIH0pO1xuICAgIH0gY2F0Y2ggKGUpIHtcbiAgICAgICAgYkJvb2wgPSB0cnVlO1xuICAgICAgICBmaW5pc2hEZXRlY3Rpb24oKTtcbiAgICAgICAgY29uc29sZS5sb2coYGJQaW5nUmVxdWVzdCBlcnJvcjoke2V9YCk7XG4gICAgICAgICRkYXRhLmJQaW5nID0gJGkxOG4ubmV0d29ya19jb25uZWN0X2ZhaWxlZDtcbiAgICB9XG59XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBvUGluZ1JlcXVlc3QoKSB7XG4gICAgY29uc3QgcmVxdWVzdFBhcmFtcyA9ICdodHRwczovL3d3dy5va3guY29tJztcbiAgICB0cnkge1xuICAgICAgICAkbmF0aXZlQVBJLnBpbmdSZXF1ZXN0KHJlcXVlc3RQYXJhbXMpLnRoZW4oYXN5bmMgcmVzcG9uc2UgPT4ge1xuICAgICAgICAgICAgJGRhdGEub1BpbmcgPSByZXNwb25zZTtcbiAgICAgICAgICAgIG9Cb29sID0gdHJ1ZTtcbiAgICAgICAgICAgIGZpbmlzaERldGVjdGlvbigpO1xuICAgICAgICB9KTtcbiAgICB9IGNhdGNoIChlKSB7XG4gICAgICAgIG9Cb29sID0gdHJ1ZTtcbiAgICAgICAgZmluaXNoRGV0ZWN0aW9uKCk7XG4gICAgICAgIGNvbnNvbGUubG9nKGBvUGluZ1JlcXVlc3QgZXJyb3I6JHtlfWApO1xuICAgICAgICAkZGF0YS5vUGluZyA9ICRpMThuLm5ldHdvcmtfY29ubmVjdF9mYWlsZWQ7XG4gICAgfVxufVxuXG5leHBvcnQgZnVuY3Rpb24gY2FwdHVyZSgpIHtcbiAgICBpZiAod2ViQm9vbCAmJiBzcG90Qm9vbCAmJiBvQm9vbCAmJiBnQm9vbCAmJiBiQm9vbCAmJiBkQm9vbCAmJiBoQm9vbCkge1xuICAgICAgICAkbmF0aXZlQVBJLmNhcHR1cmUoKTtcbiAgICB9XG59XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiByZWZyZXNoTmV0d29ya1R5cGUoKSB7XG4gICAgJGRhdGEubmV0d29ya1R5cGUgPSBhd2FpdCAkbmF0aXZlQVBJLm5ldHdvcmtUeXBlU3RhdHVzKClcbn1cblxuZXhwb3J0IGZ1bmN0aW9uIGdldFZwblN0YXR1cyhzdGF0dXMpIHtcbiAgICBpZiAodHlwZW9mIHN0YXR1cyA9PT0gJ3N0cmluZycgfHwgc3RhdHVzIGluc3RhbmNlb2YgU3RyaW5nKSB7XG4gICAgICAgIGlmIChzdGF0dXMgPT0gJ3RydWUnKSB7XG4gICAgICAgICAgICByZXR1cm4gJGkxOG4ubl9zaGFya19maW5fYXV0b1N1YnNjcmliZV9vcGVuO1xuICAgICAgICB9XG4gICAgfVxuICAgIHJldHVybiAkaTE4bi5uX3NoYXJrX2Zpbl9hdXRvU3Vic2NyaWJlX2Nsb3NlO1xufVxuXG4vKipcbiAqIOabtOaWsOWcsOWMuuS/oeaBr1xuICogQHBhcmFtIHvlnLDljLrkv6Hmga99IHJlZ2lvbiBcbiAqL1xuZXhwb3J0IGZ1bmN0aW9uIHVwZGF0ZVJlZ2lvbkluZm8ocmVnaW9uKSB7XG4gICAgaWYgKHR5cGVvZiByZWdpb24gPT09ICdzdHJpbmcnIHx8IHJlZ2lvbiBpbnN0YW5jZW9mIFN0cmluZykge1xuICAgICAgICAkZGF0YS5yZWdpb24gPSByZWdpb247XG4gICAgICAgICRkYXRhLnJlZ2lvblZpc2libGUgPSBcInZpc2libGVcIjtcbiAgICB9XG59Il0sIm5hbWVzIjpbImdCb29sIiwiZEJvb2wiLCJoQm9vbCIsImJCb29sIiwib0Jvb2wiLCJzcG90Qm9vbCIsIndlYkJvb2wiLCJhc3luYyIsImluaXREYXRhIiwiY2FwdHVyZSIsImRpY1N0ciIsIm9uRXZlbnQiLCJjb25zb2xlIiwibG9nIiwiZGljIiwiSlNPTiIsInBhcnNlIiwiJGRhdGEiLCJwaG9uZSIsInZlcnNpb24iLCJ2dG9rZW4iLCJvc1ZlcnNpb24iLCJzY3JlZW5XaWR0aCIsInNjcmVlbkhlaWdodCIsImxhbmd1YWdlIiwiaXAiLCJvcGVyYXRvciIsIm5ldHdvcmtPcGVyYXRvciIsImRucyIsInZwbiIsImdldFZwblN0YXR1cyIsIm5ldHdvcmtUeXBlIiwidXBkYXRlUmVnaW9uSW5mbyIsInJlZ2lvbiIsImdQaW5nUmVxdWVzdCIsImJQaW5nUmVxdWVzdCIsImRQaW5nUmVxdWVzdCIsImhQaW5nUmVxdWVzdCIsIm9QaW5nUmVxdWVzdCIsInNwb3RQaW5nUmVxdWVzdCIsIndlYlJlcXVlc3QiLCJyZWZyZXNoTmV0d29ya1R5cGUiLCIkbmF0aXZlQVBJIiwiZmluaXNoRGV0ZWN0aW9uIiwic2F2ZSIsIiRpMThuIiwibl9zaGFyZV9zYXZlX2ltYWdlIiwicmVxdWVzdFBhcmFtcyIsInBpbmdSZXF1ZXN0IiwidGhlbiIsImRQaW5nIiwicmVzcG9uc2UiLCJlIiwibmV0d29ya19jb25uZWN0X2ZhaWxlZCIsImhQaW5nIiwic3BvdCIsIndlYiIsImdQaW5nIiwiYlBpbmciLCJvUGluZyIsIm5ldHdvcmtUeXBlU3RhdHVzIiwic3RhdHVzIiwiU3RyaW5nIiwibl9zaGFya19maW5fYXV0b1N1YnNjcmliZV9vcGVuIiwibl9zaGFya19maW5fYXV0b1N1YnNjcmliZV9jbG9zZSIsInJlZ2lvblZpc2libGUiXSwibWFwcGluZ3MiOiJBQUFBLElBQUlBLFFBQVE7O0FBQ1osSUFBSUMsUUFBUTs7QUFDWixJQUFJQyxRQUFROztBQUNaLElBQUlDLFFBQVE7O0FBQ1osSUFB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
