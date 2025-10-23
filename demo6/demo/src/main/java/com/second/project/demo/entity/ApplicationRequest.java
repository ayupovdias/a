package com.second.project.demo.entity;

import lombok.*;
import jakarta.persistence.*;
@Entity
@Table(name="crm")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationRequest {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="userName", length=100)
    private String userName;
    @Column(name="courseName", length=100)
    private String courseName;
    @Column(name="comment", length=100)
    private String comment;
    @Column(name="phone", length=100)
    private String phone;
    @Column(name="handled")
    private boolean handled;

}
