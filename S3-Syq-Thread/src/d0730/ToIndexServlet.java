package d0730;

public class ToIndexServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		response.sendRedirect("/photo/index.html");
	}
	
}