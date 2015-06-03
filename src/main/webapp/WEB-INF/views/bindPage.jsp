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
	

<form action="<c:url value='/web/bind' />" method="post" class="am-form am-form-horizontal" data-am-validator>
  <div class="am-form-group am-margin-top">
    <label for="doc-ipt-3" class="am-u-sm-4 am-form-label am-text-right">账号</label>
    <div class="am-u-sm-6 am-u-end col-end">
      <input type="text" id="doc-ipt-3" name="name" required>
    </div>
  </div>

  <div class="am-form-group">
    <label for="doc-ipt-pwd-2" class="am-u-sm-4 am-form-label am-text-right">密码</label>
    <div class="am-u-sm-6 am-u-end col-end">
      <input type="password" id="doc-ipt-pwd-2" name="password" required>
    </div>
  </div>

  <input type="hidden" name="openId" value="${openId}">

  <div class="am-form-group">
    <div class="am-u-sm-6 am-u-sm-offset-4">
      <button type="submit" class="am-btn am-btn-default">提交</button>
    </div>
  </div>
</form>


<!--[if (gte IE 9)|!(IE)]><!-->
<script src="<c:url value='/assets/js/jquery.min.js' />"></script>
<!--<![endif]-->
<!--[if lte IE 8 ]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<![endif]-->

</body>
</html>
