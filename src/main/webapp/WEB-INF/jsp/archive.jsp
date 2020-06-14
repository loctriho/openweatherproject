<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<body>
<form action="archive" method = "GET">
    <input type="text" placeholder="Search log by city name" name="city_name">
    <select id="timeframe" name="time_frame">
        <option value = "none" selected="selected">None</option>
        <option value="today">Today</option>
        <option value="five_day">Five days</option>
    </select>`
    <input type="submit" value="Submit">
</form>
<p>You can choose to search By Date :</p>
<input type="date" id="searchDate" name="search_date" onchange="checkDate()">
</body>
</html>

