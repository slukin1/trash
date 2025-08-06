(function () {
    'use strict';

    const TraceType = {
        Undefined: 0,
        Number: 1,
        Boolean: 2,
        String: 3,
        Object: 4,
        Array: 5,
        Symbol: 6,
        Null: 7,
        Date: 8,
        Function: 9
    };

    function getRealValue(value) {
        if (value === null) {
            return null;
        }
        if (typeof value === "undefined") {
            return undefined;
        }
        const proptype = Object.getPrototypeOf(value);
        const typeName = proptype.constructor.name;
        switch (typeName) {
            case JSTraceMap.name:
                return value.rawObject();
            case JSTraceArray.name:
                return value.rawArray();
            default:
                return value;
        }
    }

    function convertValue(value, type, nextKeyPath) {
        switch (type) {
            case TraceType.Object:
                return new Proxy(new JSTraceMap(value, nextKeyPath), objectHandler);
            case TraceType.Array:
                return new Proxy(new JSTraceArray(value, nextKeyPath), arrayHandler);
            default:
                return value;
        }
    }
    function outputIfNeeded(result) {
        if (!result.success) {
            console.error(result.message);
        }
    }

    function convertArray(result, keypath) {
        if (result.success & result.type == TraceType.Undefined) {
            return undefined;
        } else if (result.success) {
            return convertValue(result.value, result.type, keypath);
        } else {
            outputIfNeeded(result);
            return undefined;
        }
    }

    function arrayRightIndex(length, i) {
        if (i >= length || i < -length) {
            return undefined;
        }
        return i >= 0 ? i : length + i;
    }

    class JSTraceArray {
        constructor(traceArray, keyPath) {
            this.traceArray = traceArray;
            this.keyPath = keyPath;
        }

        push(...items) {
            let result = this.traceArray.jsPush(items);
            outputIfNeeded(result);
        }

        rawArray() {
            let result = this.traceArray.jsRawArray();
            if (result.success) {
                return result.value;
            } else {
                outputIfNeeded(result);
                return undefined;
            }
        }

        at(i) {
            let length = this.traceArray.jsGetLength();
            let index = arrayRightIndex(length, i);
            if (typeof index === "undefined") {
                return undefined;
            }
            let result = this.traceArray.jsGet(index);
            let nextKeyPath = `${this.keyPath}[${index}]`;
            return convertArray(result, nextKeyPath);
        }

        map(func) {
            let result = this.traceArray.jsRawArray();
            if (result.success) {
                return result.value.map(func);
            } else {
                outputIfNeeded(result);
                return undefined;
            }
        }

        slice(...startAndEnd) {
            let length = this.traceArray.jsGetLength();
            let start;
            let end;
            if (startAndEnd.length == 0) {
                start = 0;
            } else {
                start = startAndEnd.shift();
            }
            if (start >= length) {
                return [];
            } else if (start < -length) {
                start = 0;
            } else if (start < 0) {
                start = length + start;
            }
            if (startAndEnd.length == 0) {
                end = length;
            } else {
                end = startAndEnd.shift();
            }
            if (end > length) {
                end = length;
            } else if (end <= start) {
                return [];
            } else if (end < 0) {
                end = length + end;
            }
            let result = this.traceArray.jsSlice(start, end);
            if (result.success) {
                let i = 0;
                return result.value.map(item => {
                    let nextKeyPath = `${this.keyPath}.slice(${start}, ${end})[${i}]`;
                    i += 1;
                    return convertValue(item.value, item.type, nextKeyPath);
                });
            } else {
                outputIfNeeded(result);
                return undefined;
            }
        }

        splice(start, ...others) {
            let length = this.traceArray.jsGetLength();
            if (start >= length) {
                start = length - 1;
            } else if (start < -length) {
                start = 0;
            } else if (start < 0) {
                start = length + start;
            }
            let deleteCount;
            if (others.length == 0) {
                deleteCount = length - start;
            } else {
                deleteCount = others.shift();
            }
            if (deleteCount <= 0) {
                deleteCount = 0;
            }
            let returnValue = this.slice(start, start + deleteCount);
            let result = this.traceArray.jsSplice(start, deleteCount, others);
            if (result.success) {
                return returnValue;
            } else {
                outputIfNeeded(result);
                return undefined;
            }
        }

        pop() {
            let length = this.traceArray.jsGetLength();
            if (length == 0) {
                return undefined;
            } else {
                return this.splice(-1, 1)[0];
            }
        }

        reverse() {
            let array = this.rawArray();
            array.reverse();
            let result = this.traceArray.jsReset(array);
            if (!result.success) {
                return this.slice();
            } else {
                outputIfNeeded(result);
                return undefined;
            }
        }

        shift() {
            let length = this.traceArray.jsGetLength();
            if (length == 0) {
                return undefined;
            } else {
                return this.splice(0, 1)[0];
            }
        }

        unshift(...items) {
            return this.splice(0, 0, ...items);
        }

        sort(fn) {
            let array = this.rawArray();
            if (typeof fn === "undefined") {
                array.sort();
            } else {
                array.sort(fn);
            }
            let result = this.traceArray.jsReset(array);
            if (!result.success) {
                return this.slice();
            } else {
                outputIfNeeded(result);
                return undefined;
            }
        }

        [Symbol.iterator]() {
            let length = this.traceArray.jsGetLength();
            let target = this;
            return function* traceArrayIterator() {
                let i = 0;
                while (i < length) {
                    yield target.at(i++);
                }
            }();
        }

        forEach(fn, thisArg) {
            let array = this.slice();
            array.forEach(fn, thisArg);
        }
    }

    const arrayHandler = {
        set(target, index, value) {
            let length = target.traceArray.jsGetLength();
            if (parseInt(index) >= length) {
                return false;
            }
            const realValue = getRealValue(value);

            let result = target.traceArray.jsSet(index, realValue);
            outputIfNeeded(result);
            return result.success;
        },
        get(target, indexOrString, reciver) {
            if (!isNaN(parseInt(indexOrString)) && isFinite(indexOrString)) {
                let result = target.traceArray.jsGet(indexOrString);
                if (result.success & result.type == TraceType.Undefined) {
                    return undefined
                } else if (result.success) {
                    let nextKeyPath = `${target.keyPath}[${indexOrString}]`;
                    return convertValue(result.value, result.type, nextKeyPath);
                } else {
                    outputIfNeeded(result);
                    return undefined;
                }
            }
            if (indexOrString === "length") {
                return target.traceArray.jsGetLength();
            }
            if (indexOrString === "rawArray") {
                return target.rawArray.bind(target);
            }
            return Reflect.get(target, indexOrString, reciver);
        }
    };

    class JSTraceMap {
        constructor(traceMap, keyPath) {
            this.traceMap = traceMap;
            this.keyPath = keyPath;
        }

        rawObject() {
            let result = this.traceMap.jsRawObject();
            if (result.success) {
                return result.value;
            } else {
                outputIfNeeded(result);
                return undefined;
            }
        }

        keys() {
            return this.traceMap.jsKeys();
        }

        values() {
            let keys = this.keys();
            let returnArray = [];
            for (var key of keys) {
                let keyPath = this.keyPath + '.' + key;
                let result = this.traceMap.jsGet(key, keyPath);
                if (result.success & result.type == TraceType.Undefined) {
                    returnArray.push(undefined);
                } else if (result.success) {
                    returnArray.push(convertValue(result.value, result.type, keyPath));
                } else {
                    outputIfNeeded(result);
                    return undefined;
                }
            }
            return returnArray;
        }
    }

    const objectHandler = {
        set(target, prop, value) {
            let keyPath = target.keyPath + '.' + prop;
            const realValue = getRealValue(value);
            let result = target.traceMap.jsSet(prop, realValue, keyPath);
            outputIfNeeded(result);
            return result.success;
        },
        deleteProperty(target, prop) {
            let result = target.traceMap.jsDelete(prop, target.keyPath);
            outputIfNeeded(result);
        },
        get(target, prop, reciver) {
            if (typeof prop === "symbol") {
                return Reflect.get(target, prop, reciver);
            }
            if (prop === "rawObject") {
                return target.rawObject.bind(target);
            }
            let keyPath = target.keyPath + '.' + prop;
            let result = target.traceMap.jsGet(prop, keyPath);
            if (result.success & result.type == TraceType.Undefined) {
                return Reflect.get(target, prop, reciver);
            } else if (result.success) {
                return convertValue(result.value, result.type, keyPath);
            } else {
                outputIfNeeded(result);
                return undefined;
            }
        }
    };

    globalThis.$data = new Proxy(new JSTraceMap(rootTraceMap, '$data'), objectHandler);

    const apiHandler = {
        get(obj, prop, reciver) {
            return (params) => {
                return new Promise((resove, reject) => {
                    const result = nativeAPI.invokeAPI(prop, params, (success, result) => {
                        if (success == true) {
                            resove(result);
                        } else {
                            reject(result);
                        }
                    });
                    outputIfNeeded(result);
                });
            };
        }
    };

    globalThis.$nativeAPI = new Proxy({}, apiHandler);

    globalThis.$event = globalThis;

    const i18nInterceptHandler = {
        get(obj, prop, receiver) {
            if (typeof prop != 'string') {
                return Reflect.get(obj, prop, receiver);
            }
            return function (...args) {
                return I18nInternal(prop, args);
            }
        }
    };
    const i18nIntercept = new Proxy({}, i18nInterceptHandler);

    const localI18nMap = {};

    const i18nHandler = {
        get(obj, prop, receiver) {
            if (typeof prop != 'string') {
                return Reflect.get(obj, prop, receiver);
            }
            if (prop == '$intercept') {
                return i18nIntercept;
            }
            if (!localI18nMap.hasOwnProperty(prop)) {
                localI18nMap[prop] = I18nInternal(prop, []);
            }
            return localI18nMap[prop];
        }
    };

    globalThis.$i18n = new Proxy({}, i18nHandler);

})();