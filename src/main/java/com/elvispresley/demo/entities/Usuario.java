/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elvispresley.demo.entities;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author andreastefannygarciamejia
 */
//
@Entity
@Table(name = "tusuarios")
public class Usuario{
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "name", length = 50, nullable = false)
    private String name;
    
    @Column(name = "lastname", length = 50, nullable = false)
    private String lastName;
    
    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;
    
    @Column(name = "date_of_birth", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    
    @Column(name = "phone", length = 20, nullable = false, unique = true)
    private String phone;
    
    @Column(name = "gender", length = 10, nullable = false)
    private String gender;
    
    @Column(name = "nationality", length = 20, nullable = false)
    private String nationality;
    
    @Column(name = "user_status", nullable = false, columnDefinition = "TINYINT")
    private boolean userStatus;

    public Usuario() {
    }

    public Usuario(int id, String name, String lastName, String email, LocalDate dateOfBirth, 
                String phone, String gender, String nationality, boolean userStatus) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.gender = gender;
        this.nationality = nationality;
        this.userStatus = userStatus;
    }

    public Usuario(String name, String lastName, String email, LocalDate dateOfBirth, 
            String phone, String gender, String nationality, boolean userStatus) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.gender = gender;
        this.nationality = nationality;
        this.userStatus = userStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean isUserStatus() {
        return userStatus;
    }

    public void setUserStatus(boolean userStatus) {
        this.userStatus = userStatus;
    }
    
    public void allowed_age(){
    
    }
    
    public void disable_account(){
    
    }
    public void update_data(){
    
    }
    
    public void log_in(){
    
    }
    
    public void create_playlist(){
        
    }
    
     public void update_playlist(){
    }
     
     public void search_playlist(){
    }
    
     public void delete_playlist(){
    }
     
    public void play_playlist(){
    }
    
    public void stop_playlist(){
    }
    
}
