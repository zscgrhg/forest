define(["avalon"], function(avalon) {
    //    必须 在avalon.ui上注册一个函数，它有三个参数，分别为容器元素，data， vmodels
    avalon.ui["vmr"] = function(element, data, vmodels) {
      //将它内部作为模板，或者使用文档碎片进行处理，那么你就需要用appendChild方法添加回去
        var innerHTML = element.innerHTML
        //由于innerHTML要依赖许多widget后来添加的新属性，这时如果被扫描肯定报“不存在”错误
        //因此先将它清空
        avalon.clearHTML(element)
        var model = avalon.define(data.vmrId, function(vm) {
            avalon.mix(vm, data.vmrOptions)//优先添加用户的配置，防止它覆盖掉widget的一些方法与属性
            
        })
        avalon.nextTick(function() {
            //widget的VM已经生成，可以添加回去让它被扫描
            element.innerHTML = innerHTML
            avalon.scan(element, [model].concat(vmodels))
        })
        return model//必须返回新VM
    }
    avalon.ui["vmr"].defaults = {
        __msg:"hello",
        __isError:false,
        __isSuccess:false
    }
    return avalon//必须返回avalon
})