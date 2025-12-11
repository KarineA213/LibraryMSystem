package com.codingSamurai.libraryMS.dto;



import com.codingSamurai.libraryMS.entities.Loan;
import com.codingSamurai.libraryMS.entities.LoanItems;
import com.codingSamurai.libraryMS.entities.enums.LoanStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class LoanInsertDto {

    @NotNull
    private Long studentsId;

    @NotNull
    private List<LoanItemsDto> loanItems;

    @NotNull
    private LocalDateTime dueDate;

    public LoanInsertDto() {
    }

    public LoanInsertDto( Long studentsId, List<LoanItemsDto> loanItems, LocalDateTime dueDate) {
        this.studentsId = studentsId;
        this.loanItems = loanItems;
        this.dueDate = dueDate;
    }

    public LoanInsertDto(Loan entity) {
        studentsId = entity.getStudents().getId();
        loanItems = entity.getLoanItems().stream().map(LoanItemsDto::new).collect(Collectors.toList());
        dueDate = entity.getDueDate();
    }

    public Long getStudentsId() {
        return studentsId;
    }

    public void setStudentsId(Long studentsId) {
        this.studentsId = studentsId;
    }

    public List<LoanItemsDto> getLoanItems() {
        return loanItems;
    }

    public void setLoanItems(List<LoanItemsDto> loanItems) {
        this.loanItems = loanItems;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }


}
//
