<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Student List</title>
  </head>
  <body>
    <h1>Student List</h1>

    <div>
      <table border="1">
        <tr>
          <th>Name</th>
          <th>Age</th>
          <th></th>
        </tr>
        <c:forEach  items="${students}" var ="student">
        <tr>
          <td>${student.name}</td>
          <td>${student.age}</td>
          <td>
              <c:url var="del_student_url" value="/del/${student.id}"/>
              <form:form action="${del_student_url}" method="post">
                  <input type="submit" value="Delete"/>
              </form:form>
          </td>
        </tr>
        </c:forEach>
      </table>
    </div>
    <br>
    <h4>Add new student</h4>
    <div>
        <c:url var="add_student_url" value="/add"/>
        <form:form action="${add_student_url}" method="post" modelAttribute="student">
            <form:label path="name">Name: </form:label> <form:input type="text" path="name"/>
            <form:label path="age">Age: </form:label> <form:input type="number" path="age"/>
            <input type="submit" value="Add"/>
        </form:form>
    </div>
    <br><br>
    <div>
        <c:url var="refresh_url" value="/refresh"/>
        <form:form action="${refresh_url}" method="post">
            <input type="submit" value="Refresh"/>
        </form:form>
    </div>
  </body>
</html>