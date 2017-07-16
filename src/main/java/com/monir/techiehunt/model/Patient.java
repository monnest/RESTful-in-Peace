package com.monir.techiehunt.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "PATIENT_TBL")
public class Patient implements Serializable {

	private static final long serialVersionUID = -3465813074586302847L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "patient_name", nullable = false)
	private String name;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String address;

	@Column(nullable = false)
	private String telephone;

	@Column(name = "disease_name", nullable = false)
	private String diseaseName;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "PATIENT_DOCTOR_TBL",
			joinColumns = { @JoinColumn(name = "PATIENT_ID") },
			inverseJoinColumns = { @JoinColumn(name = "DOCTOR_ID") })
	private Set<Doctor> doctorId = new HashSet<Doctor>();

	public Set<Doctor> getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Set<Doctor> doctorId) {
		this.doctorId = doctorId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getDiseaseName() {return diseaseName;}

	public void setDiseaseName(String diseaseName) { this.diseaseName = diseaseName;}

	@Override
	public String toString() {
		String result = String.format(
				"Patient [id=%d, name='%s']%n",
				id, name);
		if (doctorId != null) {
			for(Doctor doctor : doctorId) {
				result += String.format(
						"doctor[id=%d, name='%s']%n",
						doctor.getDoctorId(), doctor.getDoctorName());
			}
		}

		return result;
	}


}