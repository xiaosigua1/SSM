<%--
  Created by IntelliJ IDEA.
  User: 小豆腐
  Date: 2018/8/16
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link  href="/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<table border="1">
     <thead>
       <tr>
            <th>编号</th>
            <th>用户名</th>
            <th>密码</th>
       </tr>
     </thead>
     <tbody id="content">
     </tbody>
</table>

<div class="pagination" id="pagination"></div>



<script type="text/javascript" src="/css/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="/css/jquery.pagination.js"></script>
<script type="text/javascript">

    loadData(0); //当前第几页

    function loadData(pageNum) {  //请求后台数据
          $.ajax({
              url:"/user/findAllUsersByPage",
              type:"POST",
              data:{"pageNum":pageNum},
              success:function (data) {
                  //清空tbody中的内容
                  $("#content").html("");
                  //遍历数据
                  $.each(data.list,function (i,dom) {
                      $("#content").append(" <tr>\n" +
                          "           <td>"+dom.id+"</td>\n" +
                          "           <td>"+dom.userName+"</td>\n" +
                          "           <td>"+dom.password+"</td>\n" +
                          "       </tr>");
                  });
                  //使用pagination插件
                  $("#pagination").pagination(data.total,
                      {
                          current_page: data.pageNum, //当前页
                          items_per_page:data.pageSize,//页大小
                          prev_text:"上一页",
                          next_text:"下一页",
                          callback:loadData  //回调函数
                      })
              }//success结束

          });
    }


</script>
</body>
</html>
