<#import "backbone.ftl" as bb>
<#macro js>
    <script type="text/javascript">
        function destroyEntity(id){
        ${"\x24"}.ajax({
                async:false,
                url:"destroy",
                type:'post',
                data:{
                    ${model.getSimpleId()}:id,
                    _csrf:'${"\x24"}{_csrf.token}'
                },
                complete:function(){
                    location.reload();
                }
            });
        }
    </script>
</#macro>
<#macro body>

<div class="container">
    <h1>${f2l(model.getSimpleName())}</h1>

    <table class="table">
        ${"<#list ph.items as ${f2l(model.getSimpleName())}>"}

            <tr>
            <#list headers as h>
                <#if h.show>
                    <td>
                        <#if h.collection>
                        ${f2l(h.reference)}
                        <#else>
                        ${"\x24"}{${f2l(model.getSimpleName())}.${f2l(h.reference)}<#if h.bool>?string</#if>}
                        </#if>
                    </td>
                </#if>
            </#list>
                <td><a href="detail?${f2l(model.getSimpleId())}=${"\x24"}{${f2l(model.getSimpleName())}.${f2l(model.getSimpleId())}}">detail</a></td>
                <td><a href="preedit?${f2l(model.getSimpleId())}=${"\x24"}{${f2l(model.getSimpleName())}.${f2l(model.getSimpleId())}}">edit</a></td>
                <td><a href="javascript:void(0)" onclick="destroyEntity('${"\x24"}{${f2l(model.getSimpleName())}.${f2l(model.getSimpleId())}}')">destroy</a></td>
            </tr>


        ${"</#list>"}
    </table>
    ${"<@tags.pagenate ph=ph></@tags.pagenate>"}
    <table>
        <tr>
            <td><a href="precreate">create</a></td>
        </tr>
    </table>
</div>
</#macro>
<@bb.backbone js=js body=body>

</@bb.backbone>