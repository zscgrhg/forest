<#import "/tags/tags.ftl" as tags>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="_csrf" content="${_csrf.token}"/>
    <!-- default header name is X-CSRF-TOKEN -->
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <@tags.bootstrap></@tags.bootstrap>
    <script>
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
    <title></title>
</head>
<body>

<div class="container">
    <h1>所有用户</h1>
    <table class="table">
        <#list ph.items as user>
            <tr>
                <td>${user.username}</td>
                <td>${user.enabled?string}</td>
                <td>${user.authoritiesAuthority.authority}</td>
                <td><a href="detail?username=${user.username}">detail</a></td>
                <td><a href="preedit?username=${user.username}">edit</a></td>
                <td><a href="javascript:void(0)" onclick="destroyEntity('${user.username}')">destroy</a></td>
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