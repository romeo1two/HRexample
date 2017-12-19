<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>List Of Students</title>
	</head>
<body>
	<form action="<c:url value="/main"/>" method="POST">
		<table>
			<tr>
				<td>Year:<input type="text" name="year" value="${form.year}"/><br/></td>
				<td>List of Groups:
					<select name="groupId">
						<c:forEach var="group" items="${form.year}">
							<c:choose>
								<c:when test="${group.groupId==form.groupId}">
									<option value="${group.groupId}" selected><c:out value="${group.nameGroup}"/></option>
								</c:when>
								<c:otherwise>
									<option value="${group.groupId}" ><c:out value="${group.nameGroup}"/></option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</td>
				<td><input type="submit" name="getList" value="Refresh"/></td>
			</tr>
		</table>
		
		
		
		
		<p/>
		<b>List Of Students for Selected parameters</b>
		<br/>
		<table>
			<tr>
				<th> </th>
				<th>Last Name</th>
				<th>First Name</th>
				<th>Middle Name</th>
			</tr>
			<c:forEach var="student" items="${form.students}">
			<tr>
				<td><input type="radio" name="studentId" value="${student.studentId}"></td>
				<td><c:out value="${student.surName}"/></td>
				<td><c:out value="${student.firstName}"/></td>
				<td><c:out value="${student.patronymic}"/></td>
			</tr>
			</c:forEach>
		</table>
		
		<p/>
		<b>Move students into the group</b>
		<br/>
		<table>
			<tr>
				<td>Year:<input type="text" name="newYear" value="${form.year}"/><br/></td>
				<td> List of groups:
					<select name="newGroupId">
					<c:forEach var="group" items="${form.groups}">
						<option value="${group.groupId}"><c:out value="${group.nameGroup}"/></option>
					</c:forEach>
					</select>
				</td>
				<td><input type="submit" name="MoveGroup" value="move"/></td>
			</tr>
		</table>
	</form>
</body>
</html>