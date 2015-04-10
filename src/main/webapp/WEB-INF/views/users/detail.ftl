<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
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
    <h1>用户</h1>
            <p><strong>${user.username}</strong></p>
            <p><strong>${user.enabled?string}</strong></p>
            <p><strong>${user.authoritiesAuthority.authority}</strong></p>
    <p><a href="list">用户列表</a></p>
</div>
</body>
</html>