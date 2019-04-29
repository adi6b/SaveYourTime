<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <style>
 .center {
    margin: auto;
    width: 60%;
    border: 3px solid #73AD21;
    padding: 10px;
}
<script>
function validateForm() {
    var x = document.forms["form"]["name"].value;
    if (x == "") {
        alert("enter the query number");
        return false;
    }
}

</script>


</style>
</head>
<body background="/Term_project/images/4.jpg" >

<div class="container">
<div class="center" style="background-color: white">


  <h2>Registration form</h2>
  <form action="" onsubmit="validateForm()" name="form">
  <div class="form-group row" >
  <div class="col-xs-10">
      <label for="name">Name:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter name" name="name">
    </div>
    </div>
    <div class="form-group row">
    <div class="col-xs-10">
      <label for="contact_no">Contact_no:</label>
      <input type="text" class="form-control" id="contact_no" placeholder="Enter contact_no" name="contact_no">
    </div>
    </div>
    <div class="form-group row">
      <div class="col-xs-10">
      <label for="age">Age:</label>
      <input type="number" class="form-control" id="age" placeholder="Enter age" name="age">
    </div>
    </div>
    <div class="form-group row">
     <div class="col-xs-10">
      <label for="dateofbirth">Date_of_Birth:</label>
      <input type="calendar" class="form-control" id="dateofbirth" placeholder="Enter dateofbirth" name="dateofbirth">
    </div>
    </div>
    <div class="form-group row">
      <div class="col-xs-10">
      <label for="email">Email:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
    </div>
    </div>
    <div class="form-group row">
      <div class="col-xs-10">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
    </div>
    </div>
    <div class="checkbox">
      <label><input type="checkbox" name="remember"> Remember me</label>
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>
</div>



</body>
</html>
