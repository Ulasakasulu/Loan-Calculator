import javax.servlet.http.*;
import java.io.*;

public class CalculatorDemo extends HttpServlet
{
	//@Override
     public void service(HttpServletRequest request,HttpServletResponse response)
	{
		 response.setContentType("text/html");
        try{
            //print writer object
			PrintWriter out=response.getWriter();
            //Response
            Double ia=Double.valueOf(request.getParameter("LoanAmount"));
            Double i=Double.valueOf(request.getParameter("Interest"));
            Double ipy=Double.valueOf(request.getParameter("NoOfInstallmentPerYear"));
            Double totalInstallments=Double.valueOf(request.getParameter("TotalInstallments"));
            
            Double rate=(i/(ipy*100));
            Double c=(1+rate);
            Double d=Math.pow(c, totalInstallments);
            Double emi=((ia*rate*d)/(d-1));
            
            out.println("<h1>Everytime Installment amount is : " + emi + "</h1>");  
        }
        catch(Exception e)
        {
            System.out.println("Error is "+e);
        }
	}
	
}
