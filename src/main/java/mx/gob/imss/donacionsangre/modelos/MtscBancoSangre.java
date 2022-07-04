package mx.gob.imss.donacionsangre.modelos;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "MTSC_BANCO_SANGRE")
public class MtscBancoSangre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_BANCO_SANGRE", nullable = false)
    private Long id;

    @Column(name = "DES_OOAD", length = 100)
    private String desOoad;

    @Column(name = "DES_TIPO", length = 30)
    private String desTipo;

    @Column(name = "DES_NUMERO", length = 50)
    private String desNumero;

    @Column(name = "DES_LOCALIDAD", length = 100)
    private String desLocalidad;

    @Column(name = "DES_TIPO_BANCO_SANGRE", length = 100)
    private String desTipoBancoSangre;

    @Column(name = "DES_DIRECCION", length = 200)
    private String desDireccion;

    @Column(name = "NUM_TELEFONO", length = 100)
    private String numTelefono;

    @Column(name = "DES_HORARIO_ATENCION", length = 200)
    private String desHorarioAtencion;

    @Column(name = "FEC_EXPIRA")
    private LocalDate fecExpira;

    @Column(name = "FEC_ALTA")
    private Instant fecAlta;

    @Column(name = "FEC_ACTUALIZACION")
    private Instant fecActualizacion;

    @Column(name = "FEC_BAJA")
    private Instant fecBaja;

    @Column(name = "IND_ACTIVO")
    private Boolean indActivo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesOoad() {
        return desOoad;
    }

    public void setDesOoad(String desOoad) {
        this.desOoad = desOoad;
    }

    public String getDesTipo() {
        return desTipo;
    }

    public void setDesTipo(String desTipo) {
        this.desTipo = desTipo;
    }

    public String getDesNumero() {
        return desNumero;
    }

    public void setDesNumero(String desNumero) {
        this.desNumero = desNumero;
    }

    public String getDesLocalidad() {
        return desLocalidad;
    }

    public void setDesLocalidad(String desLocalidad) {
        this.desLocalidad = desLocalidad;
    }

    public String getDesTipoBancoSangre() {
        return desTipoBancoSangre;
    }

    public void setDesTipoBancoSangre(String desTipoBancoSangre) {
        this.desTipoBancoSangre = desTipoBancoSangre;
    }

    public String getDesDireccion() {
        return desDireccion;
    }

    public void setDesDireccion(String desDireccion) {
        this.desDireccion = desDireccion;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public String getDesHorarioAtencion() {
        return desHorarioAtencion;
    }

    public void setDesHorarioAtencion(String desHorarioAtencion) {
        this.desHorarioAtencion = desHorarioAtencion;
    }

    public LocalDate getFecExpira() {
        return fecExpira;
    }

    public void setFecExpira(LocalDate fecExpira) {
        this.fecExpira = fecExpira;
    }

    public Instant getFecAlta() {
        return fecAlta;
    }

    public void setFecAlta(Instant fecAlta) {
        this.fecAlta = fecAlta;
    }

    public Instant getFecActualizacion() {
        return fecActualizacion;
    }

    public void setFecActualizacion(Instant fecActualizacion) {
        this.fecActualizacion = fecActualizacion;
    }

    public Instant getFecBaja() {
        return fecBaja;
    }

    public void setFecBaja(Instant fecBaja) {
        this.fecBaja = fecBaja;
    }

    public Boolean getIndActivo() {
        return indActivo;
    }

    public void setIndActivo(Boolean indActivo) {
        this.indActivo = indActivo;
    }

}