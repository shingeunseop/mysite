<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>타이틀</title>
</head>
<body>
      <form method="post" action="delete.jsp">
      <input type='hidden' name="id" value="">
      <table width=410 border=1>
            <tr>
                 <td >비밀번호</td>
                 <td ><input type="password" name="ps" value=""></td>
                 <td colspan=4 align=right><input type="submit" value="확인. "></td>
                 <td><a href="list.jsp">메인으로 돌아가기</a></td>
           </tr>
      </table>
      </form>

</body>
</html>