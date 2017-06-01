/**
 * Created by tose on 2017/5/31.
 */
function getAppeals(type) {
    var param = {operation:type};
    $.getJSON("getAppeals",param,function (data) {
        var list = $.parseJSON(data);
        if(list.length>0){
            $("#np_tag").attr("data-badge",list.length);
            $("#np_tag").show();
            $("#zone").show();
            console.log(list[3]);
            $.each(list,function(i,n){
                var content = n.content;
                var crs = n.courseByCrsId;
                var crsName = crs.crsName;
                var crsId = n.crsId;
                var departmentByDpmId = n.departmentByDpmId
                var dpmName = departmentByDpmId.dpmName;
                var dpmId = n.dpmId;
                var tch = departmentByDpmId.teachersByDpmId[0];
                var tchName = tch.name;
                var tchId = n.tchId;
                var tr = "<tr>" +
                    "<td></td>" +
                    "<td></td>" +
                    "<td></td>" +
                    "<td></td>" +
                    "<td></td>" +
                    "<td></td>" +
                    "<td></td>" +
                    "</tr>";
                $("#ap_table").append(tr);
                // console.log(crs);
                //console.log(content+" "+crsId+" "+crsName+" "+dpmName+" "+dpmId+" "+ tchId+" "+tchName);
            })
        }
    })
}
$(function () {
    getAppeals(-1);
})