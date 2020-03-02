package servlet;

import bean.User;
import bean.bookingevent;
import dao.EventBookingDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListBookingEventsServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User user = (User) request.getSession().getAttribute("user");
        List<bookingevent> bookingeventList = new EventBookingDAO().list(user);
        request.getSession().setAttribute("bookingevents", bookingeventList);
        request.getRequestDispatcher("listBookingEvent.jsp").forward(request, response);
    }
}
