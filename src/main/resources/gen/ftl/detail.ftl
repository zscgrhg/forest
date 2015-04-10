<#import "backbone.ftl" as bb>
<#macro js>
<script type="text/javascript">

</script>
</#macro>
<#macro body>
<div class="container">
    <h1>detail</h1>
    <#list headers as h>
        <p>
            <#if h.collection>
            ${f2l(h.reference)}
            <#else>
            ${"\x24"}{${f2l(model.getSimpleName())}.${f2l(h.reference)}<#if h.bool>?string</#if>}
            </#if>
        </p>
    </#list>
    <p><a href="list">list</a></p>
</div>
</#macro>
<@bb.backbone js=js body=body>

</@bb.backbone>