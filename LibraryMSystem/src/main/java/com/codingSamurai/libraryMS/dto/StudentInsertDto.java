package com.codingSamurai.libraryMS.dto;

public class StudentInsertDto {


        private String name;
        private String course;
        private String email;
        private String phone;

        public StudentInsertDto() {
        }

        public StudentInsertDto(String name, String course, String email, String phone) {
            this.name = name;
            this.course = course;
            this.email = email;
            this.phone = phone;
        }



        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCourse() {
            return course;
        }

        public void setCourse(String course) {
            this.course = course;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }


