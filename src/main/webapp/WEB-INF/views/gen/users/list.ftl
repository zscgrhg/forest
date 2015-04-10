<#import "/tags/tags.ftl" as tags>

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
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
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
    <@tags.bootstrap></@tags.bootstrap>
    <script type="text/javascript">
        function destroyEntity(id){
        $.ajax({
                async:false,
                url:"destroy",
                type:'post',
                data:{
                    username:id,
                    _csrf:'${_csrf.token}'
                },
                complete:function(){
                    location.reload();
                }
            });
        }
    </script>
    <title>${title!'no title'}</title>
</head>
<body>
<div id="navbar-top" class="navbar-top navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a href="/" class="navbar-brand">Bootstrap Jobs</a>
            <!--<img src="/assets/img/bl.png">-->
        </div>
        <p class="navbar-text navbar-right co-brand hidden-xs">
            <strong><#if principal.login>Welcome <a href='/gen/userdetail/detail?username=${principal.username}'>${principal.username}</a>! </#if></strong>
            <strong><#if principal.login><a href="/logout">登出</a> <#else><a href='/login'>登录</a></#if></strong>
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


<div class="container">
    <h1>users</h1>

    <table class="table">
        <#list ph.items as users>

            <tr>
                    <td>
                        ${users.username}
                    </td>
                    <td>
                        ${users.enabled?string}
                    </td>
                    <td>
                        ${users.authoritiesAuthority}
                    </td>
                <td><a href="detail?username=${users.username}">detail</a></td>
                <td><a href="preedit?username=${users.username}">edit</a></td>
                <td><a href="javascript:void(0)" onclick="destroyEntity('${users.username}')">destroy</a></td>
            </tr>


        </#list>
    </table>
    <@tags.pagenate ph=ph></@tags.pagenate>
    <table>
        <tr>
            <td><a href="precreate">create</a></td>
        </tr>
    </table>
</div>
</body>
</html>
