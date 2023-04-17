<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="gray">
	<div align="center">
		<form action="/KolokvijumREST/CuvanjeServlet" method="post">
			<h3>Unos:</h3>

			==================================
			<table>
				<tr>
					<td>Naziv</td>
					<td><input type="text" name="title"></td>
				</tr>
				<tr>
					<td>Drzava</td>
					<td><input type="text" name="country"></td>
				</tr>
				<tr>
					<td>Grad</td>
					<td><input type="text" name="city"></td>
				</tr>
				<tr>
					<td>Datum pocetka</td>
					<td><input type="date" name="dateFrom"></td>
				</tr>
				<tr>
					<td>Datum kraja</td>
					<td><input type="date" name="dateTo"></td>
				</tr>
				<tr>
					<td>Naucna oblast</td>
					<td><input type="text" name="field"></td>
				</tr>
			</table>

			==================================<br> <input type="submit"
				value="Unesi" style="height: 50px; width: 100px"><br>












		</form>
		<h3>${poruka }</h3>
	</div>
</body>
</html>