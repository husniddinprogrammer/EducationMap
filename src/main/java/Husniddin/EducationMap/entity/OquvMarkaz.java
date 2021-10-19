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

@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class OquvMarkaz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomi;
    private String manzil;
    private Boolean status;
    private String koordinataX;
    private String koordinataY;
    @ManyToOne
    private User boshliq;
    @ManyToOne
    private User admin;
    private Long korilgan;
    private Long korilganIchi;
    @ManyToOne
    private Fayl photo1;
    @ManyToOne
    private Fayl photo2;
    private String viloyat;
    private String tuman;
    private Integer startWork;
    private Integer endWork;
    private Boolean open;
    private String qisqaMalumot;
    private String nomer;
    private String sayt;
    private String telegram;
    private Long oquvchiSoni;
    private Long oqituvchiSoni; 
    private Long kursSoni;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate qoshilganVaqti;

    public OquvMarkaz() {
    }

    public OquvMarkaz(Long id, String nomi, String manzil, Boolean status, String koordinataX, String koordinataY, User boshliq, User admin, Long korilgan, Long korilganIchi, Fayl photo1, Fayl photo2, String viloyat, String tuman, Integer startWork, Integer endWork, Boolean open, String qisqaMalumot, String nomer, String sayt, String telegram, Long oquvchiSoni, Long oqituvchiSoni, Long kursSoni, LocalDate qoshilganVaqti) {
        this.id = id;
        this.nomi = nomi;
        this.manzil = manzil;
        this.status = status;
        this.koordinataX = koordinataX;
        this.koordinataY = koordinataY;
        this.boshliq = boshliq;
        this.admin = admin;
        this.korilgan = korilgan;
        this.korilganIchi = korilganIchi;
        this.photo1 = photo1;
        this.photo2 = photo2;
        this.viloyat = viloyat;
        this.tuman = tuman;
        this.startWork = startWork;
        this.endWork = endWork;
        this.open = open;
        this.qisqaMalumot = qisqaMalumot;
        this.nomer = nomer;
        this.sayt = sayt;
        this.telegram = telegram;
        this.oquvchiSoni = oquvchiSoni;
        this.oqituvchiSoni = oqituvchiSoni;
        this.kursSoni = kursSoni;
        this.qoshilganVaqti = qoshilganVaqti;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomi() {
        return nomi;
    }

    public void setNomi(String nomi) {
        this.nomi = nomi;
    }

    public String getManzil() {
        return manzil;
    }

    public void setManzil(String manzil) {
        this.manzil = manzil;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getKoordinataX() {
        return koordinataX;
    }

    public void setKoordinataX(String koordinataX) {
        this.koordinataX = koordinataX;
    }

    public String getKoordinataY() {
        return koordinataY;
    }

    public void setKoordinataY(String koordinataY) {
        this.koordinataY = koordinataY;
    }

    public User getBoshliq() {
        return boshliq;
    }

    public void setBoshliq(User boshliq) {
        this.boshliq = boshliq;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public Long getKorilgan() {
        return korilgan;
    }

    public void setKorilgan(Long korilgan) {
        this.korilgan = korilgan;
    }

    public Long getKorilganIchi() {
        return korilganIchi;
    }

    public void setKorilganIchi(Long korilganIchi) {
        this.korilganIchi = korilganIchi;
    }

    public Fayl getPhoto1() {
        return photo1;
    }

    public void setPhoto1(Fayl photo1) {
        this.photo1 = photo1;
    }

    public Fayl getPhoto2() {
        return photo2;
    }

    public void setPhoto2(Fayl photo2) {
        this.photo2 = photo2;
    }

    public String getViloyat() {
        return viloyat;
    }

    public void setViloyat(String viloyat) {
        this.viloyat = viloyat;
    }

    public String getTuman() {
        return tuman;
    }

    public void setTuman(String tuman) {
        this.tuman = tuman;
    }

    public Integer getStartWork() {
        return startWork;
    }

    public void setStartWork(Integer startWork) {
        this.startWork = startWork;
    }

    public Integer getEndWork() {
        return endWork;
    }

    public void setEndWork(Integer endWork) {
        this.endWork = endWork;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public String getQisqaMalumot() {
        return qisqaMalumot;
    }

    public void setQisqaMalumot(String qisqaMalumot) {
        this.qisqaMalumot = qisqaMalumot;
    }

    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        this.nomer = nomer;
    }

    public String getSayt() {
        return sayt;
    }

    public void setSayt(String sayt) {
        this.sayt = sayt;
    }

    public String getTelegram() {
        return telegram;
    }

    public void setTelegram(String telegram) {
        this.telegram = telegram;
    }

    public Long getOquvchiSoni() {
        return oquvchiSoni;
    }

    public void setOquvchiSoni(Long oquvchiSoni) {
        this.oquvchiSoni = oquvchiSoni;
    }

    public Long getOqituvchiSoni() {
        return oqituvchiSoni;
    }

    public void setOqituvchiSoni(Long oqituvchiSoni) {
        this.oqituvchiSoni = oqituvchiSoni;
    }

    public Long getKursSoni() {
        return kursSoni;
    }

    public void setKursSoni(Long kursSoni) {
        this.kursSoni = kursSoni;
    }

    public LocalDate getQoshilganVaqti() {
        return qoshilganVaqti;
    }

    public void setQoshilganVaqti(LocalDate qoshilganVaqti) {
        this.qoshilganVaqti = qoshilganVaqti;
    }
}





























