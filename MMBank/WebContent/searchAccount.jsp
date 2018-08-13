<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
table thead tr th {
	color: rgb(30, 144, 255);
}
</style>
<body>
	<div>
		<div>

			<jstl:if test="${sessionScope.viewcust.size() != 0 }">
				<header style="background-color: rgba(50, 50, 50, 0.8);">
					<h5 style="color: white;">Enter Account Number</h5>
					<form action="searchCust.app">
						<div>
							<input type="search" id="amt" placeholder="Enter Account Number" required
								name="acS">
							<div>
								<span id="basic-addon2"><input type="submit"
									value="Search" style="border-style: none;"></span>
							</div>
						</div>
					</form>
				</header>
			</jstl:if>
			<jstl:if test="${sessionScope.viewcust.size() == 0 }">
				<div>
					<header style="background-color: rgba(50, 50, 50, 0.8);">
						<h5 style="color: red; text-align: center;">OOPS!!! Accounts
							not available yet</h5>
					</header>
				</div>
			</jstl:if>

		</div>
		<br />
	</div>
</body>
</html>