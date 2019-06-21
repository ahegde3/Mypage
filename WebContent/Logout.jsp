<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>

function goBack() {
  window.history.back();
}
</script>	
<style>
 	
header {
  background-color: #666;
  padding: 30px;
  text-align: center;
  font-size: 35px;
  color: white;
}

 	.topnav {
  background-color: #333;
  overflow: hidden;
}

/* Style the links inside the navigation bar */
.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

/* Change the color of links on hover */
.topnav a:hover {
  background-color: #ddd;
  color: black;
}
/* Style the footer */
footer {
  background-color: #777;
  padding: 10px;
  text-align: center;
  color: white;
}

/* Add a color to the active/current link */
.topnav a.active {
  background-color: #4CAF50;
  color: white;
}
.content {
  padding: 16px;
}
.sticky {
  position: fixed;
  top: 0;
  width: 100%;
}

/* Add some top padding to the page content to prevent sudden quick movement (as the navigation bar gets a new position at the top of the page (position:fixed and top:0) */
.sticky + .content {
  padding-top: 60px;
}
</style>
 	<script>

function goBack() {
  window.history.back();
}
</script>	

<body>

<header>
  <a href="index.jsp" style="color:white"><h2>MY PAGE</h2></a>
</header>
 <div class="topnav">
  <a class="active" href="Home">Home</a>
  <a href="Home">Our services</a>
 <a href="about.html">About Us</a>
  <a href="Home#contact">Contact</a>
  <div style="float:right">
  <a  href="" onClick="goBack()"> Back</a>
  </div></div>
<article>${errorMessage}</article>
</body>
</html>