
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Withdrawl</title>
<script>
	window.history.forward(1);
</script>
</head>
<style>
label {
	color: white;
}
</style>
<body>
	<div>
		<div>

			<jstl:if test="${sessionScope.viewcust.size() != 0 }">
				<div>
					<div style="background-color: rgba(50, 50, 50, 0.8);">
						<header style="background-color: rgba(30, 144, 255, 0.1);">
							<h3 style="text-align: center; color: white;">Withdraw</h3>
						</header>
						<article>
							<form>
								<div>
									<div>
										<label>Account Number</label> <input type="number"
											placeholder="Enter Account Number" required name="acNo">
									</div>
									<div>
										<label>Amount to be Withdrawl</label> <input type="number"
											placeholder="Enter Amount" required name="amt">
									</div>

								</div>

								<div>

									<div>
										<input type="submit" value="Withdraw"> 
										<input type="reset" value="clear">
										<a href="home.jsp">home</a>
									</div>
								</div>
							</form>
						</article>
					</div>
				</div>
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
	</div>
</body>

</html>