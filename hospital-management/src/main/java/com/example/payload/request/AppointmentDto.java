package com.example.payload.request;

import com.example.entity.Patient;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentDto {
    private Long id;
    private LocalDateTime appointmentDateTime;
    private String appointmentReason;
    private Long patientId;
    private Long doctorId;
}
