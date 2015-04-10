<#list lsm as m>
public  String ${m.name}( ${m.args}){
    return "(?:"+UnitsMap.get(this)+")${m.quantifiers}";
}
</#list>