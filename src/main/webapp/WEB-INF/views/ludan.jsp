<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/include.inc.jsp"%>

<!doctype html>
<html class="no-js">
<head>
  <meta charset="gbk">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="description" content="">
  <meta name="keywords" content="">
  <meta name="viewport"
        content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <title>路单查询</title>

  <!-- Set render engine for 360 browser -->
  <meta name="renderer" content="webkit">

  <!-- No Baidu Siteapp-->
  <meta http-equiv="Cache-Control" content="no-siteapp"/>


  <link rel="icon" type="image/png" href="<c:url value='/assets/i/favicon.png' />">

  <!-- Add to homescreen for Chrome on Android -->
  <meta name="mobile-web-app-capable" content="yes">
  <link rel="icon" sizes="192x192" href="<c:url value='/assets/i/app-icon72x72@2x.png' />">

  <!-- Add to homescreen for Safari on iOS -->
  <meta name="apple-mobile-web-app-capable" content="yes">
  <meta name="apple-mobile-web-app-status-bar-style" content="black">
  <meta name="apple-mobile-web-app-title" content="路单查询"/>
  <link rel="apple-touch-icon-precomposed" href="<c:url value='/assets/i/app-icon72x72@2x.png' />">

  <!-- Tile icon for Win8 (144x144 + tile color) -->
  <meta name="msapplication-TileImage" content="<c:url value='/assets/i/app-icon72x72@2x.png' />">
  <meta name="msapplication-TileColor" content="#0e90d2">

  <link rel="stylesheet" href="<c:url value='/assets/css/amazeui.min.css' />">
  <link rel="stylesheet" href="<c:url value='/assets/css/app.css' />">
  
  
</head>
<body>

<div data-am-sticky>
<form id="ludanForm" method="post" class="am-form am-form-horizontal">
  <div class="am-form-group am-margin-top">
    <label for="doc-ipt-pwd-4" class="am-u-sm-4 am-form-label am-text-right">计划时间：</label>
    <div class="am-u-sm-5 am-u-end col-end">
      <input type="text" class="am-form-field" id="doc-ipt-pwd-4" value="${start}" data-am-datepicker readonly required/>
    </div>
  </div>

  <div class="am-form-group">
    <label for="doc-ipt-pwd-5" class="am-u-sm-4 am-form-label am-text-right">至：</label>
    <div class="am-u-sm-5 am-u-end col-end">
      <input type="text" class="am-form-field" id="doc-ipt-pwd-5" value="${end}" data-am-datepicker readonly required/>
    </div>

    <div class="am-u-sm-2 am-u-end col-end">
      <%--<button type="submit" class="am-btn am-btn-default">查询</button>--%>
      <button type="button" class="am-btn am-btn-default" onclick="queryLudan();">查询</button>
    </div>

  </div>

  <div class="am-form-group am-margin-top">
    <label class="am-u-sm-4 am-form-label am-text-right">时间：</label>
    <div class="am-u-sm-5 am-u-end col-end">
      <button type="button" id="api" class="am-btn am-btn-default" onclick="api2();">2015-06-02</button>
    </div>
  </div>

</form>

<hr/>
  </div>
<div id="appendLudan"></div>

<button class="am-btn am-btn-primary" style="display: none;" id="alert_button" data-am-modal="{target: '#my-alert'}">Alert</button>
<div class="am-modal am-modal-alert" tabindex="-1" id="my-alert">
  <div class="am-modal-dialog">
    <div class="am-modal-hd">提示</div>
    <div class="am-modal-bd">
      日期范围不能超过3天而且结束日期必须大于开始日期
    </div>
    <div class="am-modal-footer">
      <span class="am-modal-btn">返回</span>
    </div>
  </div>
</div>

<button class="am-btn am-btn-primary" style="display: none;" id="alert_button2" data-am-modal="{target: '#my-alert2'}">Alert</button>
<div class="am-modal am-modal-alert" tabindex="-1" id="my-alert2">
  <div class="am-modal-dialog">
    <div class="am-modal-hd">提示</div>
    <div class="am-modal-bd">
      查询不到记录
    </div>
    <div class="am-modal-footer">
      <span class="am-modal-btn">返回</span>
    </div>
  </div>
</div>


<!--在这里编写你的代码-->

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="<c:url value='/assets/js/jquery.min.js' />"></script>
<!--<![endif]-->
<!--[if lte IE 8 ]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<![endif]-->

<script src="<c:url value='/assets/js/amazeui.min.js' />"></script>
<script src="<c:url value='/assets/js/app.js' />"></script>

<script>
    $(function(){
      $('#api').datepicker({format: 'yyyy-mm-dd'}).on('changeDate.datepicker.amui', function(event) {
        var d = event.date;

        $('#api').html(d.getFullYear()+"-"+ (d.getMonth()+1) +"-"+ d.getDate());
        $('#api').closest('.am-form-group').addClass('am-form-error').removeClass('am-form-success');
      });
    })


    queryLudan();

    function queryLudan(){
      var s1 = new Date($('#doc-ipt-pwd-4').val().replace(/-/g, '/'));
      var s2 = new Date($('#doc-ipt-pwd-5').val().replace(/-/g, '/'));

      var temp = s2.getTime() - s1.getTime();
      var flag = temp >=0 && temp <= 3*24*3600*1000;
      if(!flag){
        $('#alert_button').click();
        var $parent = $('#doc-ipt-pwd-4').closest('.am-form-group');
        $parent.addClass('am-form-error').removeClass('am-form-success');
        var $parent = $('#doc-ipt-pwd-5').closest('.am-form-group');
        $parent.addClass('am-form-error').removeClass('am-form-success');

        return;
      } else {
        var $parent = $('#doc-ipt-pwd-4').closest('.am-form-group');
        $parent.removeClass('am-form-error').addClass('am-form-success');
        var $parent = $('#doc-ipt-pwd-5').closest('.am-form-group');
        $parent.removeClass('am-form-error').addClass('am-form-success');
      }

      $.post("<c:url value='/web/ludan' />", {
                openId: "${openId}",
                start: $('#doc-ipt-pwd-4').val(),
                end: $('#doc-ipt-pwd-5').val()
              },
              function(data){
                var list = data.list;
                if(list.length == 0) {
                  $('#alert_button2').click();
                  return;
                }

                var temp = "";
                $.each(list, function(i, n){
                  temp += "<div onclick='detail("+ n.id+");'>"+
                  "<div class='am-g am-margin-top' >"+
                  "<div class='am-u-sm-4'>"+
                  n.date+
                  "</div>"+
                  " <div class='am-u-sm-4'>"+
                  n.name+
                  "</div>"+
                  "<div class='am-u-sm-3 am-u-end col-end'>"+
                  n.status+
                  "</div>"+
                  "</div>"+
                  "<div class='am-g am-margin-top'>"+
                  " <div class='am-u-sm-12'>"+
                  /*"计划时间 "+ */n.start +" ~ "+ n.end+
                  "</div>"+
                  "</div>"+
                  "</div>"+
                  "<hr/>";
                });
                temp += "<div id='ludanMore' class='am-g am-margin-top' onclick='more();'>"+
                "<div class='am-u-sm-4 am-u-sm-centered'>"+
                "更多......"+
                "</div>"+
                "<hr/>"+
                "</div>";
                $("#appendLudan").html(temp);

              },"json");
    }

  function detail(id){
    window.location = "<c:url value='/web/ludanDetailPage' />?id="+id;
  }

  function more(){
    $.post("<c:url value='/web/ludan' />", {
              openId: "${openId}",
              start: $('#doc-ipt-pwd-4').val(),
              end: $('#doc-ipt-pwd-5').val()
            },
            function(data){
              var list = data.list;
              if(list.length == 0){
                $('#alert_button2').click();
                return;
              }

              $('#ludanMore').remove();
              $.each(list, function(i, n){
                var temp = "<div onclick='detail("+ n.id+");'>"+
                  "<div class='am-g am-margin-top' >"+
                  "<div class='am-u-sm-4'>"+
                  n.date+
                  "</div>"+
                  " <div class='am-u-sm-4'>"+
                  n.name+
                  "</div>"+
                  "<div class='am-u-sm-3 am-u-end col-end'>"+
                  n.status+
                  "</div>"+
                  "</div>"+
                  "<div class='am-g am-margin-top'>"+
                  " <div class='am-u-sm-12'>"+
                  /*"计划时间 "+ */n.start +" ~ "+ n.end+
                  "</div>"+
                  "</div>"+
                  "</div>"+
                  "<hr/>";

                $("#appendLudan").append(temp);
              });
              var temp = "<div id='ludanMore' class='am-g am-margin-top' onclick='more();'>"+
                "<div class='am-u-sm-4 am-u-sm-centered'>"+
                "更多......"+
                "</div>"+
                "<hr/>"+
                "</div>";
              $("#appendLudan").append(temp);

            },"json");
  }

</script>

</body>
</html>
