package pe.com.sgs.appsgs.model;

/**
 * Created by joch on 05/12/2017.
 */

public class CategoriaDocumento {

    int idCategoriaDocumento;
    String codigoCategoriaDocumento;
    String descripcionCategoriaDocumento;
    String codigoTipoDocumento;

    public int getIdCategoriaDocumento() {
        return idCategoriaDocumento;
    }

    public void setIdCategoriaDocumento(int idCategoriaDocumento) {
        this.idCategoriaDocumento = idCategoriaDocumento;
    }

    public String getCodigoCategoriaDocumento() {
        return codigoCategoriaDocumento;
    }

    public void setCodigoCategoriaDocumento(String codigoCategoriaDocumento) {
        this.codigoCategoriaDocumento = codigoCategoriaDocumento;
    }

    public String getDescripcionCategoriaDocumento() {
        return descripcionCategoriaDocumento;
    }

    public void setDescripcionCategoriaDocumento(String descripcionCategoriaDocumento) {
        this.descripcionCategoriaDocumento = descripcionCategoriaDocumento;
    }

    public String getCodigoTipoDocumento() {
        return codigoTipoDocumento;
    }

    public void setCodigoTipoDocumento(String codigoTipoDocumento) {
        this.codigoTipoDocumento = codigoTipoDocumento;
    }
}
