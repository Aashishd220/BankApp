
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Deposit</title>
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
							<h3 style="text-align: center; color: white;">Deopsit</h3>
						</header>
						<article>
							<form action="deposit.app">
								<div>
									<div>
										<label>Account Number</label> <input type="number"
											class="form-control" placeholder="Enter Account Number"
											required name="acNO">
									</div>
									<div>
										<label>Amount to be Deposited</label> <input type="number"
											class="form-control" placeholder="Enter Amount" required
											name="amt">
									</div>
								</div>
								<div>
									<div>
										<input type="submit" value="Deposit" class="btn btn-primary ">
										<input type="reset" value="clear" class="btn btn-light">
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