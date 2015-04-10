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
    <title></title>
</head>
<body>

<div class="container">
    <h1>编辑用户信息</h1>
    <form action="edit" method="post">
        <div class="form-group">
            <input name="_csrf" type="hidden" value="${_csrf.token}">
        </div>
        <div class="form-group">
            <label for="username">Username</label>
            <input type="text" class="form-control" name="username" id="username" value="${user.username}">
        </div>
        <div class="form-group" style="display: none">
            <label for="password">Password</label>
            <input type="hidden" type="text" class="form-control" name="password" id="password" value="${user.password}">
        </div>
        <div class="form-group">
            <label for="enabled">enabled</label>
            <#--<input type="text" id="enabled" name="enabled" value="${user.enabled?string}">-->
            <select id="enabled" name="enabled" class="form-control">
                <option value="false" <#if 'false'==user.enabled?string>selected="selected" </#if>>false</option>
                <option value="true" <#if 'true'==user.enabled?string>selected="selected" </#if>>true</option>
            </select>
            <#--<p class="help-block">Example block-level help text here.</p>-->
        </div>
        <div class="form-group">
            <label for="authority">authority</label>
            <select id="authority" name="authorities_id" class="form-control">
                    <#list authorities as auth>
                        <option value="${auth.authority}" <#if auth.authority==user.authoritiesAuthority.authority>selected="selected" </#if>>${auth.authority}</option>
                    </#list>
            </select>
        <#--<p class="help-block">Example block-level help text here.</p>-->
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>

</div>
</body>
</html>