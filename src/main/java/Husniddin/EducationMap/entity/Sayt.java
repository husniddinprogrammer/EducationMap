package Husniddin.EducationMap.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Sayt {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Integer poliyalar;
    private Integer korilgan;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate sana;
    private Integer oqituvlar;
    private Integer kurslar;
    private Integer oquvMarkazlar;

    public Sayt() {
    }

    public Sayt(Long id, Integer poliyalar, Integer korilgan, LocalDate sana, Integer oqituvlar, Integer kurslar, Integer oquvMarkazlar) {
        this.id = id;
        this.poliyalar = poliyalar;
        this.korilgan = korilgan;
        this.sana = sana;
        this.oqituvlar = oqituvlar;
        this.kurslar = kurslar;
        this.oquvMarkazlar = oquvMarkazlar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPoliyalar() {
        return poliyalar;
    }

    public void setPoliyalar(Integer poliyalar) {
        this.poliyalar = poliyalar;
    }

    public Integer getKorilgan() {
        return korilgan;
    }

    public void setKorilgan(Integer korilgan) {
        this.korilgan = korilgan;
    }

    public LocalDate getSana() {
        return sana;
    }

    public void setSana(LocalDate sana) {
        this.sana = sana;
    }

    public Integer getOqituvlar() {
        return oqituvlar;
    }

    public void setOqituvlar(Integer oqituvlar) {
        this.oqituvlar = oqituvlar;
    }

    public Integer getKurslar() {
        return kurslar;
    }

    public void setKurslar(Integer kurslar) {
        this.kurslar = kurslar;
    }

    public Integer getOquvMarkazlar() {
        return oquvMarkazlar;
    }

    public void setOquvMarkazlar(Integer oquvMarkazlar) {
        this.oquvMarkazlar = oquvMarkazlar;
    }
}
