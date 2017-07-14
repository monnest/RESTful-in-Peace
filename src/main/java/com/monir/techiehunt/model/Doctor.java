package com.monir.techiehunt.model;

import javax.persistence.*;

@Entity
    @Table(name="doctor_tbl")
    public class Doctor {

        @Id
        @Column(name="doctor_id")
        @GeneratedValue(strategy=GenerationType.AUTO)
        private int doctorId;

        @Column(name="doctor_name")
        private String doctorName;

        @Column(name="designation")
        private String designation;

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}