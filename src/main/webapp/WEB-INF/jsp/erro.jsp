<!DOCTYPE html>
<html>
<head>
<title>ERRO</title>
<style type="text/css">
	span {
		font-weight: bold;
	}
</style>
</head>
<body>
	
	<h1>ERRO</h1>
	
	<h4>DESCRIÇÃO</h4>
	<p><% out.println(request.getSession().getAttribute("erro")); %></p>

</body>
</html>