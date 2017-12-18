<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>List Of Students</title>
	</head>
<body>
	<form action="<c:url value"/main"/>" method="POST">
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

</body>
</html>