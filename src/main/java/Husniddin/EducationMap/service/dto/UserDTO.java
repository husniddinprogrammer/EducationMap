package Husniddin.EducationMap.service.dto;


import Husniddin.EducationMap.configuration.Constants;
import Husniddin.EducationMap.entity.Lavozim;
import Husniddin.EducationMap.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class UserDTO {
    private Long id;
    private String username;
    private String name;
    private String number;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime qushilganVaqti;
    private Boolean status;
    protected Set<Lavozim> lavozimlar;

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.name = user.getName();
        this.number = user.getNumber();
        this.qushilganVaqti = user.getQushilganVaqti();
        this.status = user.getStatus();
        this.lavozimlar = user.getLavozimlar();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDateTime getQushilganVaqti() {
        return qushilganVaqti;
    }

    public void setQushilganVaqti(LocalDateTime qushilganVaqti) {
        this.qushilganVaqti = qushilganVaqti;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Set<Lavozim> getLavozimlar() {
        return lavozimlar;
    }

    public void setLavozimlar(Set<Lavozim> lavozimlar) {
        this.lavozimlar = lavozimlar;
    }
}











