package com.example.canspa.Service;

import com.example.canspa.ConnectJDBC;
import com.example.canspa.Model.Appointment;

import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;

public class AppointmentIpl implements AppointmentService {
    @Override
    public List<Appointment> getAllAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        Connection connection = ConnectJDBC.getConnection();
        try {
            Statement stmt = connection.createStatement();
            String sql = "Select * from lichhen";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int maLichHen = rs.getInt("maLichHen");
                String tenKhachHang = rs.getString("tenKhachHang");
                String tenDichVu = rs.getString("tenDichVu");
                Date ngayHen = rs.getDate("ngayHen");
                LocalTime gioHen = rs.getTime("gioHen").toLocalTime();
                Appointment appointment = new Appointment(maLichHen, tenKhachHang, tenDichVu, ngayHen, gioHen);
                appointments.add(appointment);
            }
            return appointments;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void addAppointments(Appointment appointment) {
        String sql = "insert into lichhen( tenKhachHang,tenDichVu, ngayHen,gioHen) values (?,?,?,?)";
        try (Connection connection = ConnectJDBC.getConnection()) {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, appointment.getTenKhachHang());
            pstm.setString(2, appointment.getTenDichVu());
            pstm.setDate(3, appointment.getNgayHen());
            pstm.setTime(4, Time.valueOf(appointment.getGioHen()));
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void deleteAppointments(int maLichHen) {
        String sql = "delete from lichhen where maLichHen = ?";
        try (Connection connection = ConnectJDBC.getConnection()) {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1, maLichHen);
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAppointments(int maLichHen, Appointment appointment) {
        String sql = "update lichhen set tenKhachHang = ?, tenDichVu = ?, ngayHen = ?, gioHen = ? where maLichHen = ?";
        try (Connection connection = ConnectJDBC.getConnection()) {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, appointment.getTenKhachHang());
            pstm.setString(2, appointment.getTenDichVu());
            pstm.setDate(3, appointment.getNgayHen());
            pstm.setTime(4, Time.valueOf(appointment.getGioHen()));
            pstm.setInt(5, maLichHen);
            pstm.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public Appointment getAppointmentsById(int maLichHen) {
        String sql = "select * from lichhen where maLichHen = ?";
        try (Connection connection = ConnectJDBC.getConnection()) {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1, maLichHen);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                String tenKhachHang = rs.getString("tenKhachHang");
                String tenDichVu = rs.getString("tenDichVu");
                Date ngayHen = rs.getDate("ngayHen");
                LocalTime gioHen = rs.getTime("gioHen").toLocalTime();
                Appointment appointment = new Appointment(tenKhachHang, tenDichVu, ngayHen, gioHen);
                return appointment;

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Appointment> searchAppointments(String keyword) throws SQLException {
        String sql = "select * from lichhen where tenKhachHang like ?";
        List<Appointment> appointments = new ArrayList<>();
        try(Connection connection =ConnectJDBC.getConnection()){
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, "%" + keyword + "%");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                int maLichHen = rs.getInt("maLichHen");
                String tenKhachHang = rs.getString("tenKhachHang");
                String tenDichVu = rs.getString("tenDichVu");
                Date ngayHen = rs.getDate("ngayHen");
                LocalTime gioHen = rs.getTime("gioHen").toLocalTime();
                Appointment appointment = new Appointment(tenKhachHang, tenDichVu, ngayHen, gioHen);
                appointments.add(appointment);}
        }
        return appointments;
    }
}
