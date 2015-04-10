<#import "/lib/cmd.ftl" as cmd>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <style >
        .error{
            border:1px  solid red;
        }
        .success{
            border:1px  solid greenyellow;
        }
        .error-tip{
            color: red;
            background:pink;
        }
    </style>
    <@cmd.avalon></@cmd.avalon>


    <title></title>
</head>
<body>
<h1>最简单例子</h1>
<form ms-controller="test" ms-widget="validation">
    <h3>验证组件</h3>

    <table>
        <tr ms-widget="vmr,vmrfora">
            <td><input ms-duplex-qq="a" placeholder="必须输入qq" data-vmr-id="vmrfora" ms-class-success="__isSuccess" ms-class-error="__isError"></td>
            <td ms-if="__isError" ms-class="error-tip">{{__msg}}</td>
        </tr>
        <tr ms-widget="vmr,vmrforb">
            <td><input ms-duplex-alpha="b" placeholder="必须输入字母" data-vmr-id="vmrforb"  ms-class-success="__isSuccess" ms-class-error="__isError"></td>
            <td ms-if="__isError" ms-class="error-tip">{{__msg}}</td>
        </tr>
        <tr ms-widget="vmr,vmrforc">
            <td><input ms-duplex-alpha="c" placeholder="必须输入字母" data-vmr-id="vmrforc"  ms-class-success="__isSuccess" ms-class-error="__isError"></td>
            <td ms-if="__isError" ms-class="error-tip">{{__msg}}</td>
        </tr>
        <tr ms-widget="vmr,vmrford">
            <td><input ms-duplex-alpha="d" placeholder="必须输入字母" data-vmr-id="vmrford"  ms-class-success="__isSuccess" ms-class-error="__isError"></td>
            <td ms-if="__isError" ms-class="error-tip">{{__msg}}</td>
        </tr>
    </table>

    <button type="submit">submit
    </button>
    <button type="button" ms-click="validation.resetAll">reset
    </button>
</form>

<script>
    require(["avalon.vmr", "validation.render", "mmRequest/mmRequest", "domReady!"], function (m, r, a) {
        var vm = avalon.define({
            $id: "test",
            $skipArray: ["validation"],
            a: "",
            b: "",
            c: "",
            d: "",
            validation: r.createValidator(submitF)
        })
        function submitF() {
            a.ajax({
                url: "http://localhost:8080/avalonui/index.html",
                data: JSON.parse(JSON.stringify(vm.$model)), //去掉数据模型中的所有函数
                success: function (ajaxData) {
                    //需要自己在这里定义一个函数,将缺少的属性补上,无用的数据去掉，
                    //格式不正确的数据转换好 ajaxData最后必须为一个对象
                    ajaxData = filterData(ajaxData)
                    //先已有的数据，新的数据，全部拷贝到一个全新的空对象中，再赋值，防止影响原来的$model
                    var newData = avalon.mix(true, {}, vm.$model, ajaxData)
                    for (var i in newData) {
                        if (vm.hasOwnProperty(i) && i !== "hasOwnProperty") {//安全更新数据
                            vm[i] = newData[i]
                        }
                    }

                }
            })
        }
        avalon.scan()
    })
</script>

</body>
</html>