/**
 * Created by wenkui on 2015/3/22.
 */
define(["validation/avalon.validation"], function () {

    return {
        createValidator: function (cb) {

            function showError(el, data) {

                var vmrid = el.getAttribute("data-vmr-id")
                avalon.vmodels[vmrid].__isError = true
                avalon.vmodels[vmrid].__isSuccess =false
                avalon.vmodels[vmrid].__msg = data.getMessage()
            }
            function showSuccess(el) {
                var vmrid = el.getAttribute("data-vmr-id")
                avalon.vmodels[vmrid].__isError = false
                avalon.vmodels[vmrid].__isSuccess =true
                avalon.vmodels[vmrid].__msg = ""
            }
            function clear(el) {

                var vmrid = el.getAttribute("data-vmr-id")
                avalon.vmodels[vmrid].__isError = false
                avalon.vmodels[vmrid].__isSuccess =false
                avalon.vmodels[vmrid].__msg = ""
            }
            return {
                vmHolder: null,
                resetInFocus:false,
                resetAll: function () {
                    if (vmHolder) {
                        vmHolder.resetAll()
                    }
                },
                onInit: function (v) {
                    vmHolder = v
                    console.log(" init validation")
                },
                onReset: function (e, data) {
                    data.valueResetor && data.valueResetor()
                    clear(data.element)
                },
                onError: function (reasons) {

                    reasons.forEach(function (reason) {                        
                        showError(this, reason)
                    }, this)
                },
                onSuccess: function () {
                    showSuccess(this)
                },
                onValidateAll: function (reasons) {
                    reasons.forEach(function (reason) {

                        showError(reason.element, reason)
                    })
                    if (reasons.length === 0) {
                        avalon.log("全部验证成功！")
                        vmHolder.widgetElement.submit()
                    }
                }
            }
        }
    }
})
