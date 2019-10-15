<%--
  Created by IntelliJ IDEA.
  User: AlphaAE
  Date: 2019/9/29
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>说明</title>
</head>
<body>
<h1>后端服务</h1>
<h3>请求示例：</h3>
<pre>
  $.ajax({
    type: 'post',
    url: $usersAPIUrl,
    data: {
      'token': $token,
      'command': $command,
      'data': $data
    },
    dataType: 'json',
    success: function (data) {
      console.log(data);
    },
    error: function (xhr, textStatus) {
      if (xhr.status == 401) {
        loginFail();
      } else {
        console.log(xhr);
      }
    }
  });
</pre>

</body>
</html>
