<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="fr.tbr.iamcore.datamodel.Identity"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IAM - Update</title>
<link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<%
Identity identity = (Identity) session.getAttribute("identity");
%>
<div class="container">
    <div class="jumbotron">
         <h2 class="text-info">Identity Management System </h2>
		 <h4 class="text-info">>>>>>>>>>>>>>>>>>>>>>>>>Please give the new details to update an identity </h4>
		 <a href="index.jsp">Logout</a>
		 </br>
    </div>
    </div>
<div class="container">
     <form class="form-horizontal" action="Update" method="post" role="form">
        <div class="form-group">
            <label for="displayName" class="col-sm-2 control-label">Display Name</label>
            <div class="col-sm-10">
                <input class="form-control" name="displayName" value="<%=identity.getDisplayName() %>" id="displayName" placeholder="Display Name" />
            </div>
        </div>
        <div class="form-group">
            <label for="uid" class="col-sm-2 control-label">UID</label>
            <div class="col-sm-10">
                <input class="form-control" name="uid" value="<%=identity.getUid() %>" id="uid" placeholder="UID" />
            </div>
        </div>
        <div class="form-group">
            <label for="email" class="col-sm-2 control-label">Email</label>
            <div class="col-sm-10">
                <input type="email" class="form-control" value="<%=identity.getEmail() %>" readonly="true" name="email" id="email" placeholder="Email" />
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-success btn-lg">Modify</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>