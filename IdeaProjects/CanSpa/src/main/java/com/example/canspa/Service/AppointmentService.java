package com.example.canspa.Service;

import com.example.canspa.Model.Appointment;

import java.sql.SQLException;
import java.util.List;

public interface AppointmentService {
    List<Appointment> getAllAppointments();
    void addAppointments(Appointment appointment);
    void deleteAppointments(int maLichHen );
    void updateAppointments(int maLichHen, Appointment appointment);
    Appointment getAppointmentsById(int maLichHen);
    List<Appointment> searchAppointments(String keyword) throws SQLException;
}
