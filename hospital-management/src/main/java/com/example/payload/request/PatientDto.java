package com.example.payload.request;

import com.example.entity.Appointment;
import com.example.entity.Insurance;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientDto {
    private Long id;
    private String name;
    private String gender;
    private String mobileNumber;
    private String email;
    private Long insuranceId;
    private List<Long> appointmentIds;
}
