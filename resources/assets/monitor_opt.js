!function () {

    var intervalTime = 5000;
    var hrefUrl = window.location.href;
    var hostname = window.location.hostname;
    var pathname = window.location.pathname;
    var host = window.location.host;
    var pageTime = (new Date).getTime();

    function sendResourceTiming(e) {
        if(findWoodWatcher()){
            findWoodWatcher().sendResource(JSON.stringify(e))
        }
    };

    function findWoodWatcher(){
        if(window.woodWatcher){
          return window.woodWatcher;
        }
        if(window.webkit){
          if(window.webkit.messageHandlers){
            if(window.webkit.messageHandlers.woodWatcher){
              return window.webkit.messageHandlers.woodWatcher
            }
          }

        }
        return null;
    }
    function wrapTime(time) {
        var totalTime = time.loadEventEnd - time.navigationStart;
        var rr = JSON.parse(1.0);
        if(totalTime > 5000) {
            rr=0.8*rr;
        } else if(totalTime > 2000) {
            rr=0.9*rr;
        }

        function fixR(time, benchmark) {
            var tt = benchmark + Math.floor((time - benchmark) * rr);
            return tt;
        }
        return {
            navigationStart: time.navigationStart,
            redirectStart: time.redirectStart,
            redirectEnd: time.redirectEnd,
            fetchStart: time.fetchStart,
            domainLookupStart: time.domainLookupStart,
            domainLookupEnd: time.domainLookupEnd,
            connectStart: time.connectStart,
            secureConnectionStart: time.secureConnectionStart ? time.secureConnectionStart : time.connectEnd - time.secureConnectionStart,
            connectEnd: time.connectEnd,
            requestStart: time.requestStart,
            responseStart: fixR(time.responseStart, time.requestStart),
            responseEnd: fixR(time.responseEnd, time.requestStart),
            unloadEventStart: fixR(time.unloadEventStart, time.requestStart),
            unloadEventEnd: fixR(time.unloadEventEnd, time.requestStart),
            domLoading: fixR(time.domLoading, time.requestStart),
            domInteractive: fixR(time.domInteractive, time.requestStart),
            domContentLoadedEventStart: fixR(time.domContentLoadedEventStart, time.requestStart),
            domContentLoadedEventEnd: fixR(time.domContentLoadedEventEnd, time.requestStart),
            domComplete: fixR(time.domComplete, time.requestStart),
            loadEventStart: fixR(time.loadEventStart, time.requestStart),
            loadEventEnd: fixR(time.loadEventEnd, time.requestStart)
        }
    }

    var performanceTiming = function () {
        function navigationTiming(wrap) {
            if (!window.performance || !window.performance.timing) return {};
            var time = window.performance.timing;
            if(wrap) {
                time = wrapTime(time);
            }
            return {
                navigationStart: time.navigationStart,
                redirectStart: time.redirectStart,
                redirectEnd: time.redirectEnd,
                fetchStart: time.fetchStart,
                domainLookupStart: time.domainLookupStart,
                domainLookupEnd: time.domainLookupEnd,
                connectStart: time.connectStart,
                secureConnectionStart: time.secureConnectionStart ? time.secureConnectionStart : time.connectEnd - time.secureConnectionStart,
                connectEnd: time.connectEnd,
                requestStart: time.requestStart,
                responseStart: time.responseStart,
                responseEnd: time.responseEnd,
                unloadEventStart: time.unloadEventStart,
                unloadEventEnd: time.unloadEventEnd,
                domLoading: time.domLoading,
                domInteractive: time.domInteractive,
                domContentLoadedEventStart: time.domContentLoadedEventStart,
                domContentLoadedEventEnd: time.domContentLoadedEventEnd,
                domComplete: time.domComplete,
                loadEventStart: time.loadEventStart,
                loadEventEnd: time.loadEventEnd,
                pageTime: pageTime
            }
        }
        function resourceTiming() {
            if (!window.performance || !window.performance.getEntriesByType) return [];
            for (var time = window.performance.getEntriesByType("resource"), resArr = [], i = 0; i < time.length; i++) {
                var t = time[i].secureConnectionStart ? time[i].secureConnectionStart : time[i].connectEnd - time[i].secureConnectionStart,
                    res = {
                        connectEnd: time[i].connectEnd,
                        connectStart: time[i].connectStart,
                        domainLookupEnd: time[i].domainLookupEnd,
                        domainLookupStart: time[i].domainLookupStart,
                        duration: time[i].duration,
                        entryType: time[i].entryType,
                        fetchStart: time[i].fetchStart,
                        initiatorType: time[i].initiatorType,
                        name: time[i].name,
                        redirectEnd: time[i].redirectEnd,
                        redirectStart: time[i].redirectStart,
                        requestStart: time[i].requestStart,
                        responseEnd: time[i].responseEnd,
                        responseStart: time[i].responseStart,
                        secureConnectionStart: t,
                        startTime: time[i].startTime
                    };
                resArr.push(res);
            }
            return resArr;
        }
        return {
            cacheResourceTimingLength: 0,
            getNavigationTiming: function (wrap) {
                return navigationTiming(wrap);
            },
            getResourceTiming: function () {
                var timing = resourceTiming();
                var len = timing.length;
                return timing.length != this.cacheResourceTimingLength ?
                    (timing = timing.slice(this.cacheResourceTimingLength, len), this.cacheResourceTimingLength = len, timing) : []
            }
        }
    }();
    var navigationTiming = {
        type: "monitor_resourceTiming",
        payload: {
            url: hrefUrl,
            domain: hostname,
            uri: pathname,
            navigationTiming: performanceTiming.getNavigationTiming(true),
            resourceTiming: performanceTiming.getResourceTiming()
        }
    };

    sendResourceTiming(navigationTiming);

    var getResourceTiming = function () {
        var timing = performanceTiming.getResourceTiming();
        if (timing.length > 0) {
            var resourceTiming = {
                type: "monitor_resourceTiming",
                payload: {
                    url: hrefUrl,
                    domain: hostname,
                    uri: pathname,
                    navigationTiming: {},
                    resourceTiming: timing,
                }
            };
        }
    };

    var already = !0;
    window.addEventListener("beforeunload",
        function () {
            already && (already = !1, getResourceTiming())
        }
    );
    window.addEventListener("unload",
        function () {
            already && (already = !1, getResourceTiming())
        }
    );

    var errorMonitor = function () {
        var errors = [];
        return window.addEventListener && window.addEventListener("error",
            function (e) {
                var eInfo = {};
                eInfo.time = e.timeStamp || (new Date).getTime(),
                    eInfo.url = e.filename,
                    eInfo.msg = e.message,
                    eInfo.line = e.lineno,
                    eInfo.column = e.colno,
                    e.error ? (eInfo.type = e.error.name, eInfo.stack = e.error.stack) : (eInfo.msg.indexOf("Uncaught ") > -1 ? eInfo.stack = eInfo.msg.split("Uncaught ")[1] + " at " + eInfo.url + ":" + eInfo.line + ":" + eInfo.column : eInfo.stack = eInfo.msg + " at " + eInfo.url + ":" + eInfo.line + ":" + eInfo.column, eInfo.type = eInfo.stack.slice(0, eInfo.stack.indexOf(":"))),
                    eInfo.type.toLowerCase().indexOf("script error") > -1 && (eInfo.type = "ScriptError"),
                    errors.push(eInfo);
            }, !1), {
            getError: function () {
                return errors.splice(0, errors.length);
            }
        }
    }();
    function sendErrors() {
        var err = errorMonitor.getError();
        if (err.length > 0) {
            var errorInfo = {
                type: "monitor_error",
                payload: {
                    url: hrefUrl,
                    domain: hostname,
                    uri: pathname,
                    error_list: err
                }
            };
             if(findWoodWatcher()){
                findWoodWatcher().sendError(JSON.stringify(errorInfo))
            }
        }
    };
    sendErrors();
}()