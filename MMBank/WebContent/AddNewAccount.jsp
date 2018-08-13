<!DOCTYPE html>
<html>
<head>
<title>Open New Account</title>
</head>
<style>
#current, #saving, #amount {
	display: none;
}
</style>
<script>
	window.history.forward(1);
</script>
<script type="text/javascript">
	function show(aval) {

		if (aval == "sav") {
			saving.style.display = 'inline-block';
			amount.style.display = 'none';
			current.style.display = 'none';
		} else if (aval == "cur") {
			saving.style.display = 'none';
			amount.style.display = 'inline-block';
			current.style.display = 'inline-block';
		} else {
			saving.style.display = 'none';
			amount.style.display = 'none';
			current.style.display = 'none';
		}
	}
	function ShowHidetr() {
		var chkYes = document.getElementById("nosal");
		var dvPassport = document.getElementById("amouunt");
		amount.style.display = chkYes.checked ? "block" : "none";
	}

	function check() {
		var Bdate = document.getElementById('dob').value;
		var amount = document.getElementById('amt').value;
		var ODL = document.getElementById('od').value;
		var chkYes = document.getElementById("nosal");
		var Yes = document.getElementById("sal");
		var dd = document.getElementById("type");
		var selectedItem = dd.options[dd.selectedIndex].value;
		var theBday = document.getElementById('resultBday');
		var ret = true;
		if (Math.floor((Date.now() - new Date(Bdate)) / (31557600000)) < 18) {
			alert("Age Must be 18 or greater");
			ret = false;
		} else if (selectedItem == "ch") {
			alert("Select Account Type");
			ret = false;
		} else if (selectedItem == "sav") {
			if (acc_add.c_salary.value == '') {
				alert("Error: Please select a radio button!");
				ret = false;
			} else if (chkYes.checked) {
				if (amount < 5000) {
					alert("Amount Must be 5000 or greater");
					ret = false;
				}
			}
		}

		else if (selectedItem == "cur") {
			if (amount < 1) {
				alert("Amount Must be greater then 0");
				ret = false;
			} else if (ODL < 10000) {
				alert("ODLimit Must be 10000 or greater");
				ret = false;
			}
		} else {
			ret = true;
		}

		return ret;

	}
</script>
<body>



	<form onsubmit="return check()" id="add" action="add.app"
		name="acc_add" method="post">
		<table>
			<tr>
				<td>Name</td>
				<td><input type="text" placeholder="Enter Your Full Name"
					required name="c_Name"></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="email" placeholder="Enter Your Email" required
					name="c_Email"></td>
			</tr>
			<tr>
				<td>Contact Number</td>
				<td><input type="tel" pattern="[2-9]{1}[0-9]{9}"
					placeholder="Enter Contact Number" required name="c_contact"></td>
			</tr>
			<tr>
				<td>Date of Birth</td>
				<td><input type="date" required name="c_dob" id="dob"></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><input type="radio" required="required" value="male"
					name="gender"> <span class="form-check-td"> Male </span></td>
				<td><input type="radio" required="required" value="Female"
					name="gender"> <span class="form-check-td"> Female</span></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><textarea placeholder="Enter Your Adress" name="c_Address"></textarea></td>
			</tr>
			<tr>
				<td>Account Type</td>
				<td><select id="type" required="required"
					onchange="java_script_:show(this.options[this.selectedIndex].value)"
					name="c_AccType">
						<option value="ch">Choose...</option>
						<option value="sav">Savings</option>
						<option value="cur">Current</option>
				</select></td>
			</tr>
			<tr id="amount" style="display: none;">
				<td>Amount</td>
				<td><input type="number" id="amt" placeholder="Enter Amount"
					required name="c_amount">
			</tr>
			<tr id="saving" style="display: none;">
				<td><input type="radio" value="salary" onclick="ShowHidetr()"
					name="c_salary" id="sal"> <span class="form-check-td">
						Salary </span></td>
				<td><input type="radio" value="notSalary"
					onclick="ShowHidetr()" name="c_salary" id="nosal"> <span
					class="form-check-td"> Not Salary</span></td>
			</tr>

			<tr id="current" style="display: none;">
				<td>ODLimit</td>
				<td><input type="number" id="od" class="form-control"
					placeholder="Enter ODLimit" name="c_ODLimit">
			</tr>
			<tr>
				<td><input type="submit" value="Create" class="btn btn-primary"></td>
				<td><input type="reset" value="clear" class="btn btn-light"></td>
			</tr>
		</table>

	</form>

</body>
</html>