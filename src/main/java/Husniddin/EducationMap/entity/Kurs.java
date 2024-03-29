package Husniddin.EducationMap.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Kurs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomi;
    @ManyToOne
    private Oqituvchi oqituvchi;
    @ManyToOne
    private FanTuri fan;
    @ManyToOne
    private HaftaTartibiTur haftaTartibiTur;
    @ManyToOne
    private OquvMarkaz oquvMarkaz;
    private Integer narxi;
    private Integer maxSoni;
    private Integer soni;
    private String startWork;
    private String endWork;
    @ManyToOne
    private Fayl photo;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate boshlanishVaqti;
    private Integer korilgan;
    private Integer korilganIchi;
    private String qisqaMalumot;
    @ManyToOne
    private FaolTur faolTur;
    private Boolean status;

    public Kurs() {
    }

    public Kurs(Long id, String nomi, Oqituvchi oqituvchi, FanTuri fan, HaftaTartibiTur haftaTartibiTur, OquvMarkaz oquvMarkaz, Integer narxi, Integer maxSoni, Integer soni, String startWork, String endWork, Fayl photo, LocalDate boshlanishVaqti, Integer korilgan, Integer korilganIchi, String qisqaMalumot, FaolTur faolTur, Boolean status) {
        this.id = id;
        this.nomi = nomi;
        this.oqituvchi = oqituvchi;
        this.fan = fan;
        this.haftaTartibiTur = haftaTartibiTur;
        this.oquvMarkaz = oquvMarkaz;
        this.narxi = narxi;
        this.maxSoni = maxSoni;
        this.soni = soni;
        this.startWork = startWork;
        this.endWork = endWork;
        this.photo = photo;
        this.boshlanishVaqti = boshlanishVaqti;
        this.korilgan = korilgan;
        this.korilganIchi = korilganIchi;
        this.qisqaMalumot = qisqaMalumot;
        this.faolTur = faolTur;
        this.status = status;
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

    public Oqituvchi getOqituvchi() {
        return oqituvchi;
    }

    public void setOqituvchi(Oqituvchi oqituvchi) {
        this.oqituvchi = oqituvchi;
    }

    public FanTuri getFan() {
        return fan;
    }

    public void setFan(FanTuri fan) {
        this.fan = fan;
    }

    public HaftaTartibiTur getHaftaTartibiTur() {
        return haftaTartibiTur;
    }

    public void setHaftaTartibiTur(HaftaTartibiTur haftaTartibiTur) {
        this.haftaTartibiTur = haftaTartibiTur;
    }

    public OquvMarkaz getOquvMarkaz() {
        return oquvMarkaz;
    }

    public void setOquvMarkaz(OquvMarkaz oquvMarkaz) {
        this.oquvMarkaz = oquvMarkaz;
    }

    public Integer getNarxi() {
        return narxi;
    }

    public void setNarxi(Integer narxi) {
        this.narxi = narxi;
    }

    public Integer getMaxSoni() {
        return maxSoni;
    }

    public void setMaxSoni(Integer maxSoni) {
        this.maxSoni = maxSoni;
    }

    public Integer getSoni() {
        return soni;
    }

    public void setSoni(Integer soni) {
        this.soni = soni;
    }

    public String getStartWork() {
        return startWork;
    }

    public void setStartWork(String startWork) {
        this.startWork = startWork;
    }

    public String getEndWork() {
        return endWork;
    }

    public void setEndWork(String endWork) {
        this.endWork = endWork;
    }

    public Fayl getPhoto() {
        return photo;
    }

    public void setPhoto(Fayl photo) {
        this.photo = photo;
    }

    public LocalDate getBoshlanishVaqti() {
        return boshlanishVaqti;
    }

    public void setBoshlanishVaqti(LocalDate boshlanishVaqti) {
        this.boshlanishVaqti = boshlanishVaqti;
    }

    public Integer getKorilgan() {
        return korilgan;
    }

    public void setKorilgan(Integer korilgan) {
        this.korilgan = korilgan;
    }

    public Integer getKorilganIchi() {
        return korilganIchi;
    }

    public void setKorilganIchi(Integer korilganIchi) {
        this.korilganIchi = korilganIchi;
    }

    public String getQisqaMalumot() {
        return qisqaMalumot;
    }

    public void setQisqaMalumot(String qisqaMalumot) {
        this.qisqaMalumot = qisqaMalumot;
    }

    public FaolTur getFaolTur() {
        return faolTur;
    }

    public void setFaolTur(FaolTur faolTur) {
        this.faolTur = faolTur;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}

















