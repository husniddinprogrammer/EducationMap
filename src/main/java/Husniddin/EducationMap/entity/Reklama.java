package Husniddin.EducationMap.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Reklama {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Kurs kurs;
    @ManyToOne
    private Fayl photo;
    private Integer status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime boshlanishVaqti;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime tugashVaqti;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate reklamaSana;
    private Long korilgan;
    private Long bosgan;
    private String manzil;
    @ManyToOne
    private ReklamaTuri reklamaTuri;

    public Reklama() {
    }

    public Reklama(Long id, Kurs kurs, Fayl photo, Integer status, LocalDateTime boshlanishVaqti, LocalDateTime tugashVaqti, LocalDate reklamaSana, Long korilgan, Long bosgan, String manzil, ReklamaTuri reklamaTuri) {
        this.id = id;
        this.kurs = kurs;
        this.photo = photo;
        this.status = status;
        this.boshlanishVaqti = boshlanishVaqti;
        this.tugashVaqti = tugashVaqti;
        this.reklamaSana = reklamaSana;
        this.korilgan = korilgan;
        this.bosgan = bosgan;
        this.manzil = manzil;
        this.reklamaTuri = reklamaTuri;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Kurs getKurs() {
        return kurs;
    }

    public void setKurs(Kurs kurs) {
        this.kurs = kurs;
    }

    public Fayl getPhoto() {
        return photo;
    }

    public void setPhoto(Fayl photo) {
        this.photo = photo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getBoshlanishVaqti() {
        return boshlanishVaqti;
    }

    public void setBoshlanishVaqti(LocalDateTime boshlanishVaqti) {
        this.boshlanishVaqti = boshlanishVaqti;
    }

    public LocalDateTime getTugashVaqti() {
        return tugashVaqti;
    }

    public void setTugashVaqti(LocalDateTime tugashVaqti) {
        this.tugashVaqti = tugashVaqti;
    }

    public LocalDate getReklamaSana() {
        return reklamaSana;
    }

    public void setReklamaSana(LocalDate reklamaSana) {
        this.reklamaSana = reklamaSana;
    }

    public Long getKorilgan() {
        return korilgan;
    }

    public void setKorilgan(Long korilgan) {
        this.korilgan = korilgan;
    }

    public Long getBosgan() {
        return bosgan;
    }

    public void setBosgan(Long bosgan) {
        this.bosgan = bosgan;
    }

    public String getManzil() {
        return manzil;
    }

    public void setManzil(String manzil) {
        this.manzil = manzil;
    }

    public ReklamaTuri getReklamaTuri() {
        return reklamaTuri;
    }

    public void setReklamaTuri(ReklamaTuri reklamaTuri) {
        this.reklamaTuri = reklamaTuri;
    }
}








