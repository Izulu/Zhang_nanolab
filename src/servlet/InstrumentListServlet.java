package servlet;

import bean.Instrument;
import dao.InstrumentDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class InstrumentListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Instrument> InstrumentList = new InstrumentDAO().list();
        request.getSession().setAttribute("instruments", InstrumentList);
        request.getRequestDispatcher("listInstrument.jsp").forward(request, response);

    }
}
