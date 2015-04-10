<#macro js>
    <#nested>
</#macro>
<#macro pageHeader>
<div id="navbar-top" class="navbar-top navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a href="/" class="navbar-brand">Bootstrap Jobs</a>
            <!--<img src="/assets/img/bl.png">-->
        </div>
        <p class="navbar-text navbar-right co-brand hidden-xs">
            <strong>${"<#if principal.login>"}Welcome ${"<a href='/gen/userdetail/detail?username=$\{principal.username}'>$\{principal.username}</a>"}! ${"</#if>"}</strong>
            <strong>${"<#if principal.login>"}<a href="/logout">登出</a> ${"<#else><a href='/login'>登录</a></#if>"}</strong>
        </p>
    </div>
</div>

<header id="top-header" class="top-header jumbotron" style="background-color: purple">
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <div class="page-header">
                    <h1>招聘/求职</h1>
                    <p class="lead">好工作都在这里啦！</p>
                </div>
            </div>
        </div>
    </div>
</header>
</#macro>
<#macro navigator>

</#macro>
<#macro body>
    <#nested>
</#macro>
<#macro backbone   js  body pageHeader=pageHeader navigator=navigator>
${"<#import \"/tags/tags.ftl\" as tags>"}

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Bootstrap中文网招聘频道">
    <meta name="keywords" content="前端,前端开发,Bootstrap,招聘,求职">
    <meta name="author" content="www.bootcss.com>">
    <meta name="_csrf" content="${r"${_csrf.token}"}"/>
    <meta name="_csrf_header" content="${r"${_csrf.headerName}"}"/>
    <style>
        .right-float *{
            float:right;
        }
        div{
            height:auto!important;
        }
        div select[mutiple]{
            min-height: 300px!important;
        }
    </style>
    ${r"<@tags.bootstrap></@tags.bootstrap>"}
    <@js></@js>
    <title>${r"${title!'no title'}"}</title>
</head>
<body>
<@pageHeader>
</@pageHeader>
<@navigator>

</@navigator>
<@body>
</@body>
</body>
</html>
</#macro>