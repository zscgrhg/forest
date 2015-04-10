<#import "backbone.ftl" as bb>
<#macro js>
<style>
    .error {
        border: 1px solid red;
    }

    .success {
        border: 1px solid greenyellow;
    }

    .error-tip {
        color: red;
        background: pink;
    }
</style>
${"<@tags.avalon></@tags.avalon>"}
<script type="text/javascript">
    require(["validation/avalon.validation", "avalon.vmr", "validation.render", "domReady!"], function (v, m, r) {
        var validationVM
        var  model_${f2l(model.getSimpleName())} =   avalon.define({
        ${"\x24"}id: "${f2l(model.getSimpleName())}vm",
        ${"\x24"}skipArray: ["validation"]

        <#list headers as h>
            <#if h.assistant >
                <#if h.collection>
                    ,${f2l(h.requestParamName)}:{arr:[],push:function(args){this.arr.push(args);return this;}}${"<#list"} ${a2l(model.getSimpleName())}.${h.reference} as item${">"}.push('${"\x24"}{item.${h.entityId}}') ${"</#list>"}.arr
                <#else >
                    ,${f2l(h.requestParamName)}:"${"\x24"}{${a2l(model.getSimpleName())}.${h.reference}.${h.entityId}}"
                </#if>
            <#else>
                <#if h.bool>
                        ,${h.reference}:${"\x24"}{${a2l(model.getSimpleName())}.${h.reference}?string}
                <#elseif !h.collection>
                        ,${h.reference}:"${"\x24"}{${a2l(model.getSimpleName())}.${h.reference}}"
                </#if>
            </#if>
        </#list>

            ,validation:r.createValidator()
    })
    avalon.scan()
    console.log(model_${f2l(model.getSimpleName())})
    })
</script>
</#macro>
<#macro body>

<div class="container" ms-controller="${f2l(model.getSimpleName())}vm">
    <h1>编辑用户信息</h1>

    <form action="edit" method="post" ms-widget="validation">
        <div class="form-group">
            <input name="_csrf" type="hidden" value="${"\x24"}{_csrf.token}">
        </div>

        <#list headers as h>
            <#if h.collection >
                <#if h.assistant>
                    <div class="form-group" style="max-height: none">
                        <label for="${f2l(h.requestParamName)}">${f2l(h.requestParamName)}</label>
                        <select multiple id="${f2l(h.requestParamName)}" name="${f2l(h.requestParamName)}" ms-duplex-string="${f2l(h.requestParamName)}"
                                class="form-control">

                        ${"<#list "} ${a2l(h.entitySimpleName)} as it ${">"}
                            <option value="${"\x24"}{it.${h.entityId}}">${"\x24"}{it.${h.entityId}}</option>
                        ${"</#list>"}
                        </select>
                    <#--<p class="help-block">Example block-level help text here.</p>-->
                    </div>
                </#if>

            <#else>
                <#if h.bool>
                    <div class="form-group">
                        <label for="${h.reference}">${h.reference}</label>
                        <select id="${h.reference}" name="${h.reference}" ms-duplex-boolean="${h.reference}" class="form-control">
                            <option value="false">false</option>
                            <option value="true">true</option>
                        </select>
                    <#--<p class="help-block">Example block-level help text here.</p>-->
                    </div>
                <#elseif h.selectAssistant>
                    <div class="form-group" style="max-height: none">
                        <label for="${f2l(h.requestParamName)}">${f2l(h.requestParamName)}</label>
                        <select id="${f2l(h.requestParamName)}" name="${f2l(h.requestParamName)}" class="form-control" ms-duplex-string="${f2l(h.requestParamName)}">
                        ${"<#list "} ${a2l(h.entitySimpleName)} as it ${">"}
                            <option value="${"\x24"}{it.${h.entityId}}">${"\x24"}{it.${h.entityId}}</option>
                        ${"</#list>"}
                        </select>
                    </div>
                <#else>

                    <div class="form-group" ms-widget="vmr,vmr_for_${h.reference}">
                        <label for="${h.reference}">${h.reference}</label>
                        <input

                               ms-duplex-pattern="${h.reference}",
                               pattern="${h.pattern}"
                               data-duplex-pattern="${h.pattern}"
                               data-duplex-msg="${h.msg}"
                               data-duplex-flag="${h.flag}"
                               data-vmr-id="vmr_for_${h.reference}"
                               ms-class-error="__isError"
                               ms-class-success="__isSuccess"
                               class="form-control"
                                <#if   h.editable>
                               type="text"
                                    <#if h.updater>
                               name="${h.reference}Updater"
                                    <#else>
                                name="${h.reference}"
                                    </#if>
                                    <#else>
                               name="${h.reference}"
                               type="hidden"
                               readonly
                                </#if>
                               id="${h.reference}"
                               placeholder="${h.reference}">
                        <span ms-if="__isError" class="error-tip">{{__msg}}</span>
                    </div>

                </#if>
            </#if>
        </#list>
        <button type="submit" class="btn btn-default">Submit</button>
        <button type="button" class="btn btn-default" ms-click="validation.resetAll">reset
        </button>
    </form>

</div>
</#macro>
<@bb.backbone js=js body=body>

</@bb.backbone>