<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Weather App</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
    </script>

  </head>
  <body>
  <span><a href="<c:url value='/logout' />">Logout</a></span>
      <c:if test="${not empty admin}">
          <h2>For admin</h2>
      </c:if>
     <input type="text" placeholder="Search the city name " id = "searchname">
     <button type="button" id="go">Search</button>
     <div class="container"  id = "ajax-response">
     </div>
  	<span id = "errormessage"></span>
     <c:if test="${not empty admin}">
         <a href="/archive">Go To Weather Archive. For Admin</a>
     </c:if>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/weather.js"></script>

  </body>
</html>
