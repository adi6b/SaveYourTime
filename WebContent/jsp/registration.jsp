<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>

  <title>Registration</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
  
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
<body background="/project_term/images/4.jpg" >

<div class="container">
<div class="center" style="background-color: white">


  <h2>Registration form</h2>
  <form method="post" action="${pageContext.request.contextPath}/registration" onsubmit="" name="form">
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
    <div class="form-group">
      <div class='input-group date' id='datetimepicker3'>
      <label for="dateofbirth">Date_of_Birth:</label>   
      <input type='date' class="form-control" placeholder="Enter date" name='datetimepicker' id='datetimepicker'/>            
    </div>
    </div>
    <div class="form-group row">
      <div class="col-xs-10">
      <label for="email">Gender:</label>
    <div class="radio">
  <label><input type="radio" value="Male" name="gender">Male</label>
  <label><input type="radio" value="female" name="gender">Female</label>
  <label><input type="radio" value="others" name="gender">others</label>
   </div>
    </div>
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>
</div>



</body>
</html>
