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
  <title>路单详情</title>

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
  <meta name="apple-mobile-web-app-title" content="路单详情"/>
  <link rel="apple-touch-icon-precomposed" href="<c:url value='/assets/i/app-icon72x72@2x.png' />">

  <!-- Tile icon for Win8 (144x144 + tile color) -->
  <meta name="msapplication-TileImage" content="<c:url value='/assets/i/app-icon72x72@2x.png' />">
  <meta name="msapplication-TileColor" content="#0e90d2">

  <link rel="stylesheet" href="<c:url value='/assets/css/amazeui.min.css' />">
  <link rel="stylesheet" href="<c:url value='/assets/css/app.css' />">
  
  
</head>
<body>

<div data-am-sticky >
  <div class="am-g am-margin-top">
    <div class="am-u-sm-4">
      <button type="button" class="am-btn am-btn-default am-radius" onclick="returnLudan();">返回</button>
    </div>
  </div>
</div>

<div class="am-g am-margin-top">
  <div class="am-u-sm-12 am-u-md-12 am-text-left">
    当前位置：广中路420号 2015-05-23 09：15
  </div>
</div>

<div class="am-panel-group am-u-sm-12">
  <section class="am-panel am-panel-default">
    <div class="am-panel-hd">
      <div class="am-g">
        <div class="am-u-sm-12">
          1（取货）上海市陆家嘴软件园8号楼
        </div>
      </div>
    </div>
    <div class="am-panel-bd">
      <div class="am-g">
      计划时间：2015-05-23 08：15 ~ 2015-05-23 09：15
      </div>
      <div class="am-g">
        地址：上海市峨山路91弄98号
      </div>
      <div class="am-g">
        签到时间：2015-05-23 09：15
      </div>
      <div class="am-g">
        签退时间：2015-05-23 09：15
      </div>

      <div class="am-g am-margin-top">
      <div class="am-panel-group">
        <section class="am-panel am-panel-default">
          <div class="am-panel-bd">
            <div class="am-g">
              零件号：G12334223322323
            </div>
            <div class="am-g">
              计划数：54 箱数：6
            </div>
            <div class="am-g">
              实际数：54 箱数：6
            </div>
            <div class="am-g">
              送货单号：SH201052300001
            </div>
            <div class="am-g">
              件数：54 箱数：6
            </div>
          </div>
        </section>
      </div>
      </div>

    </div>
  </section>
</div>


<div class="am-panel-group am-u-sm-12">
  <section class="am-panel am-panel-default">
    <div class="am-panel-hd">
      <div class="am-g">
        <div class="am-u-sm-12">
          2（卸货）上海市陆家嘴软件园8号楼
        </div>
      </div>
    </div>
    <div class="am-panel-bd">
      <div class="am-g">
        计划时间：2015-05-23 08：15 ~ 2015-05-23 09：15
      </div>
      <div class="am-g">
        地址：上海市峨山路91弄98号
      </div>
      <div class="am-g">
        签到时间：2015-05-23 09：15
      </div>
      <div class="am-g">
        签退时间：2015-05-23 09：15
      </div>

      <div class="am-g am-margin-top">
        <div class="am-panel-group">
          <section class="am-panel am-panel-default">
            <div class="am-panel-bd">
              <div class="am-g">
                零件号：G12334223322323
              </div>
              <div class="am-g">
                计划数：54 箱数：6
              </div>
              <div class="am-g">
                实际数：54 箱数：6
              </div>
              <div class="am-g">
                送货单号：SH201052300001
              </div>
              <div class="am-g">
                件数：54 箱数：6
              </div>
            </div>
          </section>
        </div>
      </div>
    </div>
  </section>
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
  function returnLudan(){
//    history.go(-1);
    history.back();
  }

</script>

</body>
</html>
