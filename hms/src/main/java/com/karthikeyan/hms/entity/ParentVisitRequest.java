package com.karthikeyan.hms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "parent_visit_requests")
@Getter
@Setter
@ToString
public class ParentVisitRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "visit_date")
    private LocalDate requestDate;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false, name = "visitor_name")
    private String visitorName;

    @Column(nullable = false)
    private String reason;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    public ParentVisitRequest(Long id, LocalDate requestDate, String status, String visitorName, String reason, Student student) {
        this.id = id;
        this.requestDate = requestDate;
        this.status = status;
        this.visitorName = visitorName;
        this.reason = reason;
        this.student = student;
    }

    public ParentVisitRequest() {
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
