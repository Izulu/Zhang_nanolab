package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventBookingServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int iid = Integer.parseInt(request.getParameter("iid"));
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        startTime = startTime.replaceAll("T"," ");
        endTime = endTime.replaceAll("T"," ");
//        System.out.println("Instrument: " + iid);
//        System.out.println("StartTime: " + startTime);
//        System.out.println("endTime: " + endTime);
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(startTime);
            endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Instrument: " + iid);
        System.out.println("StartTime: " + startDate);
        System.out.println("endTime: " + endDate);
    }
}
