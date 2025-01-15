package com.example.canspa.Controlle;
import com.example.canspa.Model.Appointment;
import com.example.canspa.Service.AppointmentIpl;
import com.example.canspa.Service.AppointmentService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@WebServlet("/appointment")

public class AppointmentServlet extends HttpServlet {
    public static final AppointmentService appointmentServlet = new AppointmentIpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "Add":
                showAddAppointment(req, resp);
                break;
            case "Delete":
                showDeleteAppointment(req, resp);
                break;
            case "Edit":
                showEditAppointment(req, resp);
                break;
            case "Detail":
                showDetailDetail(req, resp);
                break;
            default:
                getAllAppointments(req, resp);
                break;
        }
    }

    private void showDetailDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int maLichHen = Integer.parseInt(req.getParameter("maLichHen"));
        Appointment appointment = appointmentServlet.getAppointmentsById(maLichHen);
        req.setAttribute("appointments", appointment);
        req.getRequestDispatcher("View/Detail.jsp").forward(req, resp);
    }

    private void showEditAppointment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int maLichHen = Integer.parseInt(req.getParameter("maLichHen"));
        Appointment appointments = appointmentServlet.getAppointmentsById(maLichHen);
        req.setAttribute("appointments", appointments);
        req.getRequestDispatcher("View/Edit.jsp").forward(req, resp);
    }

    private void showDeleteAppointment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int maLichHen = Integer.parseInt(req.getParameter("maLichHen"));
        appointmentServlet.deleteAppointments(maLichHen);
        getAllAppointments(req, resp);
    }

    private void showAddAppointment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("View/Add.jsp").forward(req, resp);
    }

    private void getAllAppointments(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Appointment> appointment = appointmentServlet.getAllAppointments();
        req.setAttribute("appointments", appointment);
        req.getRequestDispatcher("View/Home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "Add":
                addAppointments(req, resp);
                break;
            case "Edit":
                editAppointments(req, resp);
                break;
            case "Search":
                try {
                    searchAppointments(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
        }
    }

    private void searchAppointments(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String keyword = req.getParameter("keyword");
        List<Appointment> appointments = appointmentServlet.searchAppointments(keyword);
        req.setAttribute("appointments", appointments);
        req.getRequestDispatcher("View/Home.jsp").forward(req, resp);
    }

    private void editAppointments(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tenKhachHang = req.getParameter("tenKhachHang");
        String tenDichVu = req.getParameter("tenDichVu");
        String ngayHen = req.getParameter("ngayHen");
        java.sql.Date sqlDate = java.sql.Date.valueOf(ngayHen);
        LocalTime gioHen = LocalTime.parse(req.getParameter("gioHen"));
        int maLichHen = Integer.parseInt(req.getParameter("maLichHen"));
        Appointment appointment = new Appointment(maLichHen, tenKhachHang, tenDichVu, sqlDate, gioHen);
        appointmentServlet.updateAppointments(maLichHen, appointment);
        getAllAppointments(req, resp);
    }

    private void addAppointments(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tenKhachHang = req.getParameter("tenKhachHang");
        String tenDichVu = req.getParameter("tenDichVu");
        String ngayHen = req.getParameter("ngayHen");
        java.sql.Date sqlDate = java.sql.Date.valueOf(ngayHen);
        LocalTime gioHen = LocalTime.parse(req.getParameter("gioHen"));
        Appointment appointment = new Appointment(tenKhachHang, tenDichVu, sqlDate, gioHen);
        appointmentServlet.addAppointments(appointment);
        getAllAppointments(req, resp);
    }
}
