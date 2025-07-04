package com.karthikeyan.hms.controller;

import com.karthikeyan.hms.entity.Room;
import com.karthikeyan.hms.entity.Student;
import com.karthikeyan.hms.entity.Warden;
import com.karthikeyan.hms.service.RoomService;
import com.karthikeyan.hms.service.StudentService;
import com.karthikeyan.hms.service.WardenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {
    private final StudentService studentService;
    private final RoomService roomService;
    private final WardenService wardenService;

    @Autowired
    public StudentController(StudentService studentService, RoomService roomService, WardenService wardenService){
        this.studentService = studentService;
        this.roomService = roomService;
        this.wardenService = wardenService;
    }

    @PostMapping
    public Student saveStudent(@RequestBody Student student) {
        student.setFeesStatus("Pending");
        return studentService.saveStudent(student);
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/firebase/{firebaseUid}")
    public Optional<Student> getStudentByFirebaseUid(@PathVariable String firebaseUid) {
        return studentService.getStudentByFirebaseUid(firebaseUid);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id);
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @PutMapping("/{id}/assign")
    public ResponseEntity<Student> assignRoomAndWarden(@PathVariable Long id, @RequestBody Map<String, Long> requestBody) {

        Long roomId = requestBody.get("roomId");
        Long wardenId = requestBody.get("wardenId");

        Optional<Student> optionalStudent = studentService.getStudentById(id);
        Optional<Room> optionalRoom = roomService.getRoomById(roomId);
        Optional<Warden> optionalWarden = wardenService.getWardenById(wardenId);

        if (optionalStudent.isPresent() && optionalRoom.isPresent() && optionalWarden.isPresent()) {
            Student student = optionalStudent.get();
            Room room = optionalRoom.get();
            if (room.getCurrentOccupancy() >= room.getCapacity()) {
                return ResponseEntity.badRequest().body(null);
            }
            Room previousRoom = student.getRoom();
            if (previousRoom != null && !previousRoom.getId().equals(room.getId())) {
                previousRoom.setCurrentOccupancy(previousRoom.getCurrentOccupancy() - 1);
                roomService.saveRoom(previousRoom);
            }
            student.setRoom(room);
            student.setWarden(optionalWarden.get());
            room.setCurrentOccupancy(room.getCurrentOccupancy() + 1);
            roomService.saveRoom(room);
            return ResponseEntity.ok(studentService.updateStudent(student));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}
