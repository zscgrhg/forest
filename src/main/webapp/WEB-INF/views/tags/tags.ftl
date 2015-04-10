<#macro pagenate ph>
<table class="table">
    <tr>
        <td>
            <strong>显示第${ph.firstRow+1}-第${ph.lastRow+1}条记录，总共${ph.count}条记录</strong>
        </td>
        <#if ph.fb gt 1 >
            <td><a href="list?firstRow=${ph.firstRow+(ph.fb-ph.currentPage)*ph.pageSize}&pageSize=${ph.pageSize}">
                &lt;&lt;</a></td>
        </#if>
        <#if ph.hasPreviousPage>
            <td>
                <a href="list?firstRow=${ph.previousStartRow}&pageSize=${ph.pageSize}">previous</a>
            </td>
        </#if>
        <#list ph.links as link>
            <td>
                <#if link!=ph.currentPage>
                    <a href="list?firstRow=${ph.firstRow+(link-ph.currentPage)*ph.pageSize}&pageSize=${ph.pageSize}">${link}</a>
                </#if>
                <#if link==ph.currentPage>
                    <strong>${link}</strong>
                </#if>
            </td>
        </#list>
        <#if ph.hasNextPage>
            <td>
                <a href="list?firstRow=${ph.nextStartRow}&pageSize=${ph.pageSize}">next</a>
            </td>
        </#if>
        <#if ph.ff gt 1 >
            <td><a href="list?firstRow=${ph.firstRow+(ph.ff-ph.currentPage)*ph.pageSize}&pageSize=${ph.pageSize}">
                &gt;&gt;</a></td>
        </#if>
    </tr>
</table>
</#macro>

<#macro bootstrapcss>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="/static/abc/bootstrap/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="/static/abc/bootstrap/css/bootstrap-theme.min.css">

</#macro>
<#macro bootstrapjs>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="/static/abc/bootstrap/js/bootstrap.min.js"></script>

</#macro>
<#macro jquery>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="/static/abc/jquery/jquery.min.js"></script>

</#macro>
<#macro bootstrap>
    <@bootstrapcss></@bootstrapcss>
    <@jquery></@jquery>
    <@bootstrapjs></@bootstrapjs>
</#macro>

<#macro avalon>
<script src="/static/abc/avalon/avalon.min.js"></script>
</#macro>