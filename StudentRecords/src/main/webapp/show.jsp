<html>
<head>
<title>Show your records</title>
</head>
<body>

<h1>Show students records</h1>

<form action="select">
<table>

<tr>
<th>id</th>
<th>name</th>
<th>age</th>
<th>email</th>
<th>city</th>
</tr>

<tr>
<td>${user.getId()}</td>
<td>${user.getName()}</td>
<td>${user.getAge()}</td>
<td>${user.getEmail()}</td>
<td>${user.getCity()}</td>
</tr>

</table>
</form>
</body>
</html>