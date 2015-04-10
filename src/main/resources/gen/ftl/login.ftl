<#import "backbone.ftl" as bb>
<#macro js>
<script type="text/javascript">

</script>
</#macro>
<#macro body>

<div class="container">
<table>
    <form action="/user_login" method="post">
        <div class="form-group">
            <input name="_csrf" type="hidden" value="${'\x24'}{_csrf.token}">
        </div>
        <div class="form-group" >
            <label for="username">Username</label>
            <input type="text"
                   class="form-control" name="username" id="username" placeholder="username" >
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="text"
                   class="form-control"
                   name="password" id="password" placeholder="password">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
        <button type="button" class="btn btn-default" onclick="window.location='/index">reset
        </button>
    </form>
</table>
</div>
</#macro>
<@bb.backbone js=js body=body>

</@bb.backbone>