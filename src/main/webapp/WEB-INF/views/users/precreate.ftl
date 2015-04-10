<#import "/tags/tags.ftl" as tags>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="_csrf" content="${_csrf.token}"/>
    <!-- default header name is X-CSRF-TOKEN -->
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <!-- 可选的Bootstrap主题文件（一般不用引入） -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.bootcss.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <@tags.avalon></@tags.avalon>
    <style >
        .error{
            border:1px  solid red ;
        }
        .success{
            border:1px  solid greenyellow;
        }
        .error-tip{
            color: red ;
            background:pink ;
        }
    </style>
    <script>
        require(["validation/avalon.validation","avalon.vmr","validation.render", "domReady!"], function(v,m,r) {
            var validationVM
            avalon.define({
                $id: "test",
                $skipArray: ["validation"],

                username: "",
                password:"",

                validation: r.createValidator()
            })
            avalon.scan()
        })
    </script>
    <title></title>
</head>
<body>

<div class="container" ms-controller="test">
    <h1>编辑用户信息</h1>
    <form action="create" method="post" ms-widget="validation">
        <div class="form-group">
            <input name="_csrf" type="hidden" value="${_csrf.token}">
        </div>
        <div class="form-group" ms-widget="vmr,vmr_for_username">
            <label for="username">Username</label>
            <input type="text"
                   ms-duplex-alpha="username"
                   data-vmr-id="vmr_for_username"
                   ms-class-error="__isError"
                   ms-class-success="__isSuccess"
                   class="form-control" name="username" id="username" placeholder="username" >
            <span ms-if="__isError" class="error-tip">{{__msg}}</span>
        </div>
        <div class="form-group" ms-widget="vmr,vmr_for_password">
            <label for="password">Password</label>
            <input type="text"
                   ms-duplex-alpha="password"
                   data-vmr-id="vmr_for_password"
                   ms-class-error="__isError"
                   ms-class-success="__isSuccess"
                   class="form-control"
                   name="password" id="password" placeholder="password">
            <span ms-if="__isError" class="error-tip">{{__msg}}</span>
        </div>
        <div class="form-group">
            <label for="enabled">enabled</label>

            <select id="enabled" name="enabled" class="form-control">
                <option value="false">false</option>
                <option value="true">true</option>
            </select>
        <#--<p class="help-block">Example block-level help text here.</p>-->
        </div>
        <div class="form-group">
            <label for="authority">authority</label>
            <select id="authority" name="authorities_id" class="form-control">
            <#list authorities as auth>
                <option value="${auth.authority}">${auth.authority}</option>
            </#list>
            </select>
        <#--<p class="help-block">Example block-level help text here.</p>-->
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
        <button type="button" class="btn btn-default" ms-click="validation.resetAll">reset
        </button>
    </form>

</div>
</body>
</html>