package org.cert.parse.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.cert.CertificateException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cert.parse.manager.CertificateManager;
import org.cert.parse.model.CertBean;

/**
 * Servlet implementation class CertFormController
 */
public class CertFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CertFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		CertificateManager cManager = new CertificateManager();
		//out.println("Certificate Data");
		try {
			out.println("Before");
			CertBean cBean = cManager.generateCertificate();
			out.println("After");
			request.setAttribute("cBean", cBean);
			RequestDispatcher dispatcher = request.getRequestDispatcher("form.jsp");
			dispatcher.include(request, response);
			
		} catch (CertificateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
