package com.karthikeyan.hms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "students")
@Getter
@Setter
@ToString
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false, unique=true)
    private String email;

    @Column(name = "contact_number", nullable=false)
    private String contactNumber;

    @Column(name = "college_name", nullable=false)
    private String collegeName;

    @Column(name = "firebase_uid", nullable=false, unique=true)
    private String firebaseUid;

    @Column(name = "fees_status", nullable=false)
    private String feesStatus;

    @ManyToOne
    @JoinColumn(name = "room_id")
    @JsonIgnore  //prevent circular serialization
    private Room room;

    @ManyToOne
    @JoinColumn(name = "warden_id")
    private Warden warden;

    public Student(Long id, String name, String email, String contactNumber, String collegeName, String firebaseUid, String feesStatus, Room room, Warden warden) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
        this.collegeName = collegeName;
        this.firebaseUid = firebaseUid;
        this.feesStatus = feesStatus;
        this.room = room;
        this.warden = warden;
    }

    public Student() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public void setFirebaseUid(String firebaseUid) {
        this.firebaseUid = firebaseUid;
    }

    public void setFeesStatus(String feesStatus) {
        this.feesStatus = feesStatus;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setWarden(Warden warden) {
        this.warden = warden;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public String getFirebaseUid() {
        return firebaseUid;
    }

    public String getFeesStatus() {
        return feesStatus;
    }

    public Room getRoom() {
        return room;
    }

    public Warden getWarden() {
        return warden;
    }

}
