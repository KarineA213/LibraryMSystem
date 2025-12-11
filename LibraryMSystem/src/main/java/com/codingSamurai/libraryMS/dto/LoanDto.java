package com.codingSamurai.libraryMS.dto;

import com.codingSamurai.libraryMS.entities.Loan;
import com.codingSamurai.libraryMS.entities.LoanItems;
import com.codingSamurai.libraryMS.entities.Students;
import com.codingSamurai.libraryMS.entities.enums.Condition;
import com.codingSamurai.libraryMS.entities.enums.LoanStatus;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
public class LoanDto {



    private  Long loanId;
    private  List<LoanItemsDto> loanItems;

    //Dados Students
    private LoanStudentsDto loanStudents;
    private String studentName;
    private String studentEmail;
    private String studentPhone;
    private String studentCourse;


    //dados emprestimo
    private LocalDateTime loanDate;
    private  LocalDateTime dueDate;
    private  LocalDateTime returnDate;
    private LoanStatus status;




    public LoanDto() {
    }

    public LoanDto(Long loanId, List<LoanItemsDto> loanItems, LoanStudentsDto loanStudents, String studentName, String studentEmail, String studentPhone, String studentCourse, LocalDateTime loanDate, LocalDateTime dueDate, LocalDateTime returnDate, LoanStatus status) {
        this.loanId = loanId;
        this.loanItems = loanItems;
        this.loanStudents = loanStudents;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.studentPhone = studentPhone;
        this.studentCourse = studentCourse;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public LoanDto(Loan entity){

        loanId = entity.getId();

        loanItems = entity.getLoanItems().stream().map(LoanItemsDto::new).collect(Collectors.toList());
        dueDate = entity.getDueDate();
        loanDate = entity.getLoanDate();
        returnDate = entity.getReturnDate();
        status = entity.getStatus();

        //dados estudantes
        studentCourse = entity.getStudents().getCourse();
        studentName = entity.getStudents().getName();
        studentEmail = entity.getStudents().getEmail();
        studentPhone = entity.getStudents().getPhone();
    }

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public List<LoanItemsDto> getLoanItems() {
        return loanItems;
    }

    public void setLoanItems(List<LoanItemsDto> loanItems) {
        this.loanItems = loanItems;
    }



    public LocalDateTime getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDateTime loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public LoanStatus getStatus() {
        return status;
    }

    public void setStatus(LoanStatus status) {
        this.status = status;
    }


    //ESTUDANTES

    public LoanStudentsDto getLoanStudents() {
        return loanStudents;
    }

    public void setLoanStudents(LoanStudentsDto loanStudents) {
        this.loanStudents = loanStudents;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public String getStudentCourse() {
        return studentCourse;
    }

    public void setStudentCourse(String studentCourse) {
        this.studentCourse = studentCourse;
    }


//    private Long id;
//
//    private List<LoanItemsDto> loanItems;
//    private LoanStudentsDto loanStudents;
//    private LocalDateTime loanDate;
//    private LocalDateTime dueDate;
//    private LocalDateTime returnDate;
//    private LoanStatus status;
////    private Condition conditionOnLoan;
////    private Condition conditionOnReturn;
//
//
//    public LoanDto(Long id, List<LoanItemsDto> loanItems, LoanStudentsDto loanStudents, LocalDateTime loanDate, LocalDateTime dueDate, LocalDateTime returnDate, LoanStatus status) {
//        this.id = id;
//        this.loanItems = loanItems;
//        this.loanStudents = loanStudents;
//        this.loanDate = loanDate;
//        this.dueDate = dueDate;
//        this.returnDate = returnDate;
//        this.status = status;
//    }
//
//    public LoanDto(Loan entity) {
//        id = entity.getId();
//        loanItems = entity.getLoanItems().stream().map(LoanItemsDto::new).collect(Collectors.toList());
//        loanStudents = new LoanStudentsDto(entity.getStudents());
//        loanDate = entity.getLoanDate();
//        dueDate = entity.getDueDate();
//        returnDate = entity.getReturnDate();
//        status = entity.getStatus();
//    }
//
//
////    public LoanDto(Loan entity) {
////
////        id = entity.getId();
////        loanItems = entity.getLoanItems().stream().map(LoanItemsDto::new).collect(Collectors.toList());
////        loanStudents = new LoanStudentsDto(entity.getStudents().getName().toUpperCase());
////        loanDate = entity.getLoanDate();
////        dueDate = entity.getDueDate();
////        returnDate = entity.getReturnDate();
////        status = entity.getStatus();
////
////    }
//
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public List<LoanItemsDto> getLoanItems() {
//        return loanItems;
//    }
//
//    public void setLoanItems(List<LoanItemsDto> loanItems) {
//        this.loanItems = loanItems;
//    }
//
//
//    public LoanStudentsDto getLoanStudents() {
//        return loanStudents;
//    }
//
//    public void setLoanStudents(LoanStudentsDto loanStudents) {
//        this.loanStudents = loanStudents;
//    }
//
//    public LocalDateTime getLoanDate() {
//        return loanDate;
//    }
//
//    public void setLoanDate(LocalDateTime loanDate) {
//        this.loanDate = loanDate;
//    }
//
//    public LocalDateTime getDueDate() {
//        return dueDate;
//    }
//
//    public void setDueDate(LocalDateTime dueDate) {
//        this.dueDate = dueDate;
//    }
//
//    public LocalDateTime getReturnDate() {
//        return returnDate;
//    }
//
//    public void setReturnDate(LocalDateTime returnDate) {
//        this.returnDate = returnDate;
//    }
//
//    public LoanStatus getStatus() {
//        return status;
//    }
//
//    public void setStatus(LoanStatus status) {
//        this.status = status;
//    }
}