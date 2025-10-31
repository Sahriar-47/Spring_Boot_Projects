package com.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PATIENT")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false)
    private String mobileNumber;
    private String email;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "insurance_id")
    @JsonBackReference
    private Insurance insurance;

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE,  CascadeType.REMOVE})
    @JsonManagedReference
    private List<Appointment> appointments = new ArrayList<>();
}
