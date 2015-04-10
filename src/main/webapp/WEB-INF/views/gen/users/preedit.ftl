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
<@tags.avalon></@tags.avalon>
<script type="text/javascript">
    require(["validation/avalon.validation", "avalon.vmr", "validation.render", "domReady!"], function (v, m, r) {
        var validationVM
        var  model_users =   avalon.define({
        $id: "usersvm",
        $skipArray: ["validation"]

                        ,username:"${users.username}"
                        ,enabled:${users.enabled?string}
                        ,password:"${users.password}"
                    ,authorities_authority:"${users.authoritiesAuthority.authority}"

            ,validation:r.createValidator()
    })
    avalon.scan()
    console.log(model_users)
    })
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


<div class="container" ms-controller="usersvm">
    <h1>编辑用户信息</h1>

    <form action="edit" method="post" ms-widget="validation">
        <div class="form-group">
            <input name="_csrf" type="hidden" value="${_csrf.token}">
        </div>


                    <div class="form-group" ms-widget="vmr,vmr_for_username">
                        <label for="username">username</label>
                        <input

                               ms-duplex-pattern="username",
                               pattern="(?=.{1,255}$).+"
                               data-duplex-pattern="(?=.{1,255}$).+"
                               data-duplex-msg="长度必须大于1且小于255;"
                               data-duplex-flag="i"
                               data-vmr-id="vmr_for_username"
                               ms-class-error="__isError"
                               ms-class-success="__isSuccess"
                               class="form-control"
                               type="text"
                                name="username"
                               id="username"
                               placeholder="username">
                        <span ms-if="__isError" class="error-tip">{{__msg}}</span>
                    </div>

                    <div class="form-group">
                        <label for="enabled">enabled</label>
                        <select id="enabled" name="enabled" ms-duplex-boolean="enabled" class="form-control">
                            <option value="false">false</option>
                            <option value="true">true</option>
                        </select>
                    </div>

                    <div class="form-group" ms-widget="vmr,vmr_for_password">
                        <label for="password">password</label>
                        <input

                               ms-duplex-pattern="password",
                               pattern="(?=.{1,255}$).+"
                               data-duplex-pattern="(?=.{1,255}$).+"
                               data-duplex-msg="长度必须大于1且小于255;"
                               data-duplex-flag="i"
                               data-vmr-id="vmr_for_password"
                               ms-class-error="__isError"
                               ms-class-success="__isSuccess"
                               class="form-control"
                               name="password"
                               type="hidden"
                               readonly
                               id="password"
                               placeholder="password">
                        <span ms-if="__isError" class="error-tip">{{__msg}}</span>
                    </div>

                    <div class="form-group" style="max-height: none">
                        <label for="authorities_authority">authorities_authority</label>
                        <select id="authorities_authority" name="authorities_authority" class="form-control" ms-duplex-string="authorities_authority">
                        <#list  authorities as it >
                            <option value="${it.authority}">${it.authority}</option>
                        </#list>
                        </select>
                    </div>
        <button type="submit" class="btn btn-default">Submit</button>
        <button type="button" class="btn btn-default" ms-click="validation.resetAll">reset
        </button>
    </form>

</div>
</body>
</html>
