package com.cg.mmbankapp.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.mmbankapp.pojo.CurrentAccount;
import com.cg.mmbankapp.pojo.Customer;
import com.cg.mmbankapp.pojo.SavingAccount;
import com.cg.mmbankapp.services.BankAppService;

/**
 * Servlet implementation class BankAppController
 */
@WebServlet("*.app")
public class BankAppController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BankAppController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		BankAppService accountService = new BankAppService();
		HttpSession session = request.getSession();
		String action = request.getServletPath();
		switch (action) {
		case "/bank.app":
			response.sendRedirect("home.jsp");
			break;
		case "/add.app":
			DateTimeFormatter JAVAFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate dateOfBirth = LocalDate.parse(request.getParameter("c_dob"), JAVAFormat);
			String customerName = request.getParameter("c_Name");
			;
			String emailId = request.getParameter("c_Email");
			;
			long contactNumber = Long.parseLong(request.getParameter("c_contact"));
			String permanentAddress = request.getParameter("c_Address");
			String gender = request.getParameter("gender");
			Customer customer = new Customer(customerName, emailId, contactNumber, dateOfBirth, permanentAddress,
					gender);
			if (request.getParameter("c_AccType").equals("sav")) {
				if (request.getParameter("c_salary").equals("salary")) {
					SavingAccount savingsAccount = new SavingAccount(customer, true, "Savings");
					accountService.AddNewAccount(savingsAccount);
					System.out.println(accountService.getAccountNo());
					session.setAttribute("accNO", accountService.getAccountNo() - 1);
					response.sendRedirect("createSuccess.jsp");
				} else {
					double accountBalance = Double.parseDouble(request.getParameter("c_amount"));
					SavingAccount savingsAccount = new SavingAccount(customer, accountBalance, "Savings", false);
					accountService.AddNewAccount(savingsAccount);
					session.setAttribute("accNO", accountService.getAccountNo() - 1);
					response.sendRedirect("createSuccess.jsp");
				}
			} else {
				double accountBalance = Double.parseDouble(request.getParameter("c_amount"));
				double odLimit = Double.parseDouble(request.getParameter("c_ODLimit"));
				CurrentAccount currentAccount = new CurrentAccount(customer, accountBalance, "Current", odLimit);
				accountService.AddNewAccount(currentAccount);
				session.setAttribute("accNO", accountService.getAccountNo() - 1);
				response.sendRedirect("createSuccess.jsp");
			}
			break;
		case "/ViewAccounts.app":
			session.setAttribute("ViewAccounts", accountService.viewAccount());
			response.sendRedirect("ViewAccounts.jsp");
			break;
		case "/viewcust.app":
			session.setAttribute("viewcust", accountService.viewCustomer());
			response.sendRedirect("ViewAllCustomers.jsp");
			break;
		case "/deposit.app":
			int accno = Integer.parseInt(request.getParameter("acNO"));
			double amt = Double.parseDouble(request.getParameter("amt"));
			session.setAttribute("viewcust", accountService.deposit(amt, accno));
			response.sendRedirect("depositSuccess.jsp");
			break;
		case "/withdraw.app":
			int accNo = Integer.parseInt(request.getParameter("acNo"));
			double amount = Double.parseDouble(request.getParameter("amt"));
			session.setAttribute("viewcust", accountService.withdrawl(amount, accNo));
			response.sendRedirect("withdrawSuccess.jsp");
			break;
		case "/fundtransfer.app":

			int sender = Integer.parseInt(request.getParameter("sender"));
			;
			int reciever = Integer.parseInt(request.getParameter("reciever"));
			;
			String remarks = request.getParameter("remarks");
			amount = Double.parseDouble(request.getParameter("amt"));
			System.out.println(accountService.Fundtransfer(sender, reciever, amount, remarks));
			session.setAttribute("transfer", accountService.Fundtransfer(sender, reciever, amount, remarks));
			session.setAttribute("reciever", reciever);
			session.setAttribute("sender", sender);
			session.setAttribute("remarks", remarks);
			session.setAttribute("amount", amount);
			response.sendRedirect("transferSuccess.jsp");
			break;

		case "/searchCust.app":
			accno = Integer.parseInt(request.getParameter("acS"));
			session.setAttribute("searchCust", accountService.searchAccount(accno));
			System.out.println(accno + "" + accountService.searchAccount(accno));
			response.sendRedirect("searchResult.jsp");

			break;

		}
		System.out.println(accountService.viewAccount());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
