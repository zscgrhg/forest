<#import "/lib/cmd.ftl" as cmd>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <@cmd.avalon></@cmd.avalon>
    <title></title>
</head>
<body>
<h1>hello ${users!"u"}</h1>
<div ms-controller="box">
    <div style=" background: #a9ea00;" ms-css-width="w" ms-css-height="h"  ms-click="click" ></div>
    <p>{{ w }} x {{ h }}</p>
    <p>W: <input type="text" ms-duplex="w" data-duplex-event="change"/></p>
    <p>H: <input type="text" ms-duplex="h" /></p>
</div>
<script>
    var vm = avalon.define({
        $id: "box",
        w: 100,
        h: 100,
        click: function() {
            vm.w = parseFloat(vm.w) + 10;
            vm.h = parseFloat(vm.h) + 10;
        }
    })
</script>
</body>
</html>