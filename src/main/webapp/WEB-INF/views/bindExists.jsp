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
  <title>绑定账号</title>

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
  <meta name="apple-mobile-web-app-title" content="绑定账号"/>
  <link rel="apple-touch-icon-precomposed" href="<c:url value='/assets/i/app-icon72x72@2x.png' />">

  <!-- Tile icon for Win8 (144x144 + tile color) -->
  <meta name="msapplication-TileImage" content="<c:url value='/assets/i/app-icon72x72@2x.png' />">
  <meta name="msapplication-TileColor" content="#0e90d2">

  <link rel="stylesheet" href="<c:url value='/assets/css/amazeui.min.css' />">
  <link rel="stylesheet" href="<c:url value='/assets/css/app.css' />">
  
  
</head>
<body>


<div class="am-panel-group am-u-sm-12 am-margin-top">
  <section class="am-panel am-panel-default">
    <div class="am-panel-hd">提示</div>
    <div class="am-panel-bd">
      <p>安吉通账号和您的微信账号绑定成功！</p>
      <button class="am-btn am-btn-warning" id="doc-confirm-toggle">解除绑定</button>
    </div>
  </section>
</div>

<div class="am-modal am-modal-confirm" tabindex="-1" id="my-confirm">
  <div class="am-modal-dialog">
    <div class="am-modal-hd">Amaze UI</div>
    <div class="am-modal-bd">
      确定要解除你当前微信与安吉通账号的绑定吗？
    </div>
    <div class="am-modal-footer">
      <span class="am-modal-btn" data-am-modal-cancel>取消</span>
      <span class="am-modal-btn" data-am-modal-confirm>确定</span>
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
  $(function() {
    $('#doc-confirm-toggle').on('click', function() {
      $('#my-confirm').modal({
        relatedTarget: this,
        onConfirm: function(options) {
          window.location = "<c:url value='/web/unbind' />?openId=${openId}";
        },
        onCancel: function() {
        }
      });
    });
  });

</script>

</body>
</html>
