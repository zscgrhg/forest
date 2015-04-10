/**
 * Created by wenkui on 2015/3/22.
 */
define("validation/avalon.validation",function(){

    return {

        createValidator: function () {
            function showError(el, data) {
                var next = el.nextSibling
                if (!(next && next.className === "error-tip")) {
                    next = document.createElement("div")
                    next.className = "error-tip"
                    el.parentNode.appendChild(next)
                }
                next.innerHTML = data.getMessage()
            }
            function removeError(el) {
                console.log(el)
                var next = el.nextSibling
                console.log(next)
                if (next && next.className === "error-tip") {
                    el.parentNode.removeChild(next)
                    console.log(el.parentNode)
                }
            }
            return {
                vmHolder:null,
                resetAll:function(){
                if(vmHolder){
                    vmHolder.resetAll()
                }
            },
                onInit: function(v) {
                    vmHolder = v
                },
                onReset: function(e, data) {
                    console.log(" onreset validation" + e)
                    data.valueResetor && data.valueResetor()
                    avalon(this).removeClass("error success")
                    removeError(this)
                },
                onError: function(reasons) {

                    reasons.forEach(function(reason) {
                        avalon(this).removeClass("success").addClass("error")
                        showError(this, reason)
                    }, this)
                },
                onSuccess: function() {
                    avalon(this).removeClass("error").addClass("success")
                    removeError(this)
                },
                onValidateAll: function(reasons) {
                    reasons.forEach(function(reason) {
                        avalon(reason.element).removeClass("success").addClass("error")
                        showError(reason.element, reason)
                    })
                    if (reasons.length === 0) {
                        avalon.log("全部验证成功！")
                    }
                }
            }
        }
    }
})
