package com.monir.techiehunt.conversion;
import javax.inject.Inject;
import com.monir.techiehunt.dao.DoctorDAO;
import com.monir.techiehunt.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;


final class StringToDoctor implements Converter<String, Doctor> {

    @Autowired
    DoctorDAO doctorDAO;

    @Override
    public Doctor convert(String source) {
        return doctorDAO.getDoctor(Integer.parseInt(source));
    }
}

