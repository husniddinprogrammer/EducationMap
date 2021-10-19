package Husniddin.EducationMap.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Xabar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ism;
    private String familiya;
    @ManyToOne
    private OquvMarkaz oquvMarkaz;
    private Boolean status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime xabarVaqti;

    public Xabar() {
    }

    public Xabar(Long id, String ism, String familiya, OquvMarkaz oquvMarkaz, Boolean status, LocalDateTime xabarVaqti) {
        this.id = id;
        this.ism = ism;
        this.familiya = familiya;
        this.oquvMarkaz = oquvMarkaz;
        this.status = status;
        this.xabarVaqti = xabarVaqti;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsm() {
        return ism;
    }

    public void setIsm(String ism) {
        this.ism = ism;
    }

    public String getFamiliya() {
        return familiya;
    }

    public void setFamiliya(String familiya) {
        this.familiya = familiya;
    }

    public OquvMarkaz getOquvMarkaz() {
        return oquvMarkaz;
    }

    public void setOquvMarkaz(OquvMarkaz oquvMarkaz) {
        this.oquvMarkaz = oquvMarkaz;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public LocalDateTime getXabarVaqti() {
        return xabarVaqti;
    }

    public void setXabarVaqti(LocalDateTime xabarVaqti) {
        this.xabarVaqti = xabarVaqti;
    }
}
