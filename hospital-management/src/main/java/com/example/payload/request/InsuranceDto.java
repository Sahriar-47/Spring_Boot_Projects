package com.example.payload.request;

import com.example.entity.Patient;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InsuranceDto {
    private String insuranceProvider;
    private LocalDate validUntil;
    private String insuranceNumber;
    private Long patientId;
}
