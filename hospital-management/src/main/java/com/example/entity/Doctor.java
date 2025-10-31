package com.example.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    private String specialization;
    @Column(nullable = false,  unique = true)
    private String email;

    @ManyToMany(mappedBy = "doctors",  fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE,  CascadeType.REMOVE})
    @JsonManagedReference
    private Set<Department> departments = new HashSet<>();

    @OneToMany(mappedBy = "doctor", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JsonManagedReference
    private List<Appointment> appointmentList = new ArrayList<>();
}
