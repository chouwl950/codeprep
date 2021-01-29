package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sample1 extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		out.println(createHTML("GET"));

		out.close();
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		response.setContentType("text/html; charset=Shift_JIS");
		PrintWriter out = response.getWriter();

		out.println(createHTML("POST"));

		out.close();
	}

	protected String createHTML(String methodType) {
		StringBuffer sb = new StringBuffer();

		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>サンプル</title>");
		sb.append("</head>");
		sb.append("<body>");

		sb.append("<p>");
		sb.append(methodType);
		sb.append("メソッドで呼び出されました</p>");

		sb.append("<p><a href='/startserlet/sample'>リンク</a></p>");

		sb.append("<form action='/startserlet/sample' method='get'>");
		sb.append("<input type='submit' value='GETで送信'>");
		sb.append("</form>");

		sb.append("<form action='/startserlet/sample' method='post'>");
		sb.append("<input type='submit' value='POSTで送信'>");
		sb.append("</form>");

		sb.append("</body>");
		sb.append("</html>");

		return (new String(sb));
	}
}