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
        var  model_userDetail =   avalon.define({
        $id: "userDetailvm",
        $skipArray: ["validation"]

                        ,displayName:"${userdetail.displayName}"
                        ,company:"${userdetail.company}"
                        ,companyTel:"${userdetail.companyTel}"
                        ,fullname:"${userdetail.fullname}"
                        ,tel:"${userdetail.tel}"
                        ,profession:"${userdetail.profession}"
                        ,city:"${userdetail.city}"
                        ,address:"${userdetail.address}"
                        ,introduce:"${userdetail.introduce}"
                        ,username:"${userdetail.username}"

            ,validation:r.createValidator()
    })
    avalon.scan()
    console.log(model_userDetail)
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


<div class="container" ms-controller="userDetailvm">
    <h1>编辑用户信息</h1>

    <form action="edit" method="post" ms-widget="validation">
        <div class="form-group">
            <input name="_csrf" type="hidden" value="${_csrf.token}">
        </div>


                    <div class="form-group" ms-widget="vmr,vmr_for_displayName">
                        <label for="displayName">displayName</label>
                        <input

                               ms-duplex-pattern="displayName",
                               pattern="(?=.{1,40}$).+"
                               data-duplex-pattern="(?=.{1,40}$).+"
                               data-duplex-msg="长度必须大于1且小于40;"
                               data-duplex-flag="i"
                               data-vmr-id="vmr_for_displayName"
                               ms-class-error="__isError"
                               ms-class-success="__isSuccess"
                               class="form-control"
                               type="text"
                                name="displayName"
                               id="displayName"
                               placeholder="displayName">
                        <span ms-if="__isError" class="error-tip">{{__msg}}</span>
                    </div>


                    <div class="form-group" ms-widget="vmr,vmr_for_company">
                        <label for="company">company</label>
                        <input

                               ms-duplex-pattern="company",
                               pattern="(?:[\u2E80-\u2FEF\u3005-\u3005\u3007-\u3007\u3021-\u3029\u3038-\u303B\u3400-\u4DBF\u4E00-\u9FFF\uF900-\uFAFF]|\uD840[\uDC00-\uDFFF]|\uDB40\uDC00){2,10}"
                               data-duplex-pattern="(?:[\u2E80-\u2FEF\u3005-\u3005\u3007-\u3007\u3021-\u3029\u3038-\u303B\u3400-\u4DBF\u4E00-\u9FFF\uF900-\uFAFF]|\uD840[\uDC00-\uDFFF]|\uDB40\uDC00){2,10}"
                               data-duplex-msg="必须是2到10个汉字"
                               data-duplex-flag="im"
                               data-vmr-id="vmr_for_company"
                               ms-class-error="__isError"
                               ms-class-success="__isSuccess"
                               class="form-control"
                               type="text"
                                name="company"
                               id="company"
                               placeholder="company">
                        <span ms-if="__isError" class="error-tip">{{__msg}}</span>
                    </div>


                    <div class="form-group" ms-widget="vmr,vmr_for_companyTel">
                        <label for="companyTel">companyTel</label>
                        <input

                               ms-duplex-pattern="companyTel",
                               pattern="(?=.{0,30}$).*"
                               data-duplex-pattern="(?=.{0,30}$).*"
                               data-duplex-msg="长度必须大于0且小于30;"
                               data-duplex-flag="i"
                               data-vmr-id="vmr_for_companyTel"
                               ms-class-error="__isError"
                               ms-class-success="__isSuccess"
                               class="form-control"
                               type="text"
                                name="companyTel"
                               id="companyTel"
                               placeholder="companyTel">
                        <span ms-if="__isError" class="error-tip">{{__msg}}</span>
                    </div>


                    <div class="form-group" ms-widget="vmr,vmr_for_fullname">
                        <label for="fullname">fullname</label>
                        <input

                               ms-duplex-pattern="fullname",
                               pattern="(?=.{0,255}$).*"
                               data-duplex-pattern="(?=.{0,255}$).*"
                               data-duplex-msg="长度必须大于0且小于255;"
                               data-duplex-flag="i"
                               data-vmr-id="vmr_for_fullname"
                               ms-class-error="__isError"
                               ms-class-success="__isSuccess"
                               class="form-control"
                               type="text"
                                name="fullname"
                               id="fullname"
                               placeholder="fullname">
                        <span ms-if="__isError" class="error-tip">{{__msg}}</span>
                    </div>


                    <div class="form-group" ms-widget="vmr,vmr_for_tel">
                        <label for="tel">tel</label>
                        <input

                               ms-duplex-pattern="tel",
                               pattern="(?=.{0,30}$).*"
                               data-duplex-pattern="(?=.{0,30}$).*"
                               data-duplex-msg="长度必须大于0且小于30;"
                               data-duplex-flag="i"
                               data-vmr-id="vmr_for_tel"
                               ms-class-error="__isError"
                               ms-class-success="__isSuccess"
                               class="form-control"
                               type="text"
                                name="tel"
                               id="tel"
                               placeholder="tel">
                        <span ms-if="__isError" class="error-tip">{{__msg}}</span>
                    </div>


                    <div class="form-group" ms-widget="vmr,vmr_for_profession">
                        <label for="profession">profession</label>
                        <input

                               ms-duplex-pattern="profession",
                               pattern="(?=.{0,255}$).*"
                               data-duplex-pattern="(?=.{0,255}$).*"
                               data-duplex-msg="长度必须大于0且小于255;"
                               data-duplex-flag="i"
                               data-vmr-id="vmr_for_profession"
                               ms-class-error="__isError"
                               ms-class-success="__isSuccess"
                               class="form-control"
                               type="text"
                                name="profession"
                               id="profession"
                               placeholder="profession">
                        <span ms-if="__isError" class="error-tip">{{__msg}}</span>
                    </div>


                    <div class="form-group" ms-widget="vmr,vmr_for_city">
                        <label for="city">city</label>
                        <input

                               ms-duplex-pattern="city",
                               pattern="(?=.{0,255}$).*"
                               data-duplex-pattern="(?=.{0,255}$).*"
                               data-duplex-msg="长度必须大于0且小于255;"
                               data-duplex-flag="i"
                               data-vmr-id="vmr_for_city"
                               ms-class-error="__isError"
                               ms-class-success="__isSuccess"
                               class="form-control"
                               type="text"
                                name="city"
                               id="city"
                               placeholder="city">
                        <span ms-if="__isError" class="error-tip">{{__msg}}</span>
                    </div>


                    <div class="form-group" ms-widget="vmr,vmr_for_address">
                        <label for="address">address</label>
                        <input

                               ms-duplex-pattern="address",
                               pattern="(?=.{0,255}$).*"
                               data-duplex-pattern="(?=.{0,255}$).*"
                               data-duplex-msg="长度必须大于0且小于255;"
                               data-duplex-flag="i"
                               data-vmr-id="vmr_for_address"
                               ms-class-error="__isError"
                               ms-class-success="__isSuccess"
                               class="form-control"
                               type="text"
                                name="address"
                               id="address"
                               placeholder="address">
                        <span ms-if="__isError" class="error-tip">{{__msg}}</span>
                    </div>


                    <div class="form-group" ms-widget="vmr,vmr_for_introduce">
                        <label for="introduce">introduce</label>
                        <input

                               ms-duplex-pattern="introduce",
                               pattern="(?=.{0,255}$).*"
                               data-duplex-pattern="(?=.{0,255}$).*"
                               data-duplex-msg="长度必须大于0且小于255;"
                               data-duplex-flag="i"
                               data-vmr-id="vmr_for_introduce"
                               ms-class-error="__isError"
                               ms-class-success="__isSuccess"
                               class="form-control"
                               type="text"
                                name="introduce"
                               id="introduce"
                               placeholder="introduce">
                        <span ms-if="__isError" class="error-tip">{{__msg}}</span>
                    </div>


                    <div class="form-group" ms-widget="vmr,vmr_for_username">
                        <label for="username">username</label>
                        <input

                               ms-duplex-pattern="username",
                               pattern="(?=.{1,40}$).+"
                               data-duplex-pattern="(?=.{1,40}$).+"
                               data-duplex-msg="长度必须大于1且小于40;"
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

        <button type="submit" class="btn btn-default">Submit</button>
        <button type="button" class="btn btn-default" ms-click="validation.resetAll">reset
        </button>
    </form>

</div>
</body>
</html>
