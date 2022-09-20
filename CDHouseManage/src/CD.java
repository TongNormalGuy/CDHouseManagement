
public class CD {
    private String nameCD;
    private String typeCD;
    private String titleCD;
    private float priceCD;
    private String idCD;
    private int publicYear;

    public CD() {
    }

    public CD(String nameCD, String typeCD, String titleCD, float priceCD, String idCD, int publicYear) {
        this.nameCD = nameCD;
        this.typeCD = typeCD;
        this.titleCD = titleCD;
        this.priceCD = priceCD;
        this.idCD = idCD;
        this.publicYear = publicYear;
    }

    public String getTitleCD() {
        return titleCD;
    }

    public void setTitleCD(String titleCD) {
        this.titleCD = titleCD;
    }
    

    public String getNameCD() {
        return nameCD;
    }

    public void setNameCD(String nameCD) {
        this.nameCD = nameCD;
    }

    public String getTypeCD() {
        return typeCD;
    }

    public void setTypeCD(String typeCD) {
        this.typeCD = typeCD;
    }

    public float getPriceCD() {
        return priceCD;
    }

    public void setPriceCD(float priceCD) {
        this.priceCD = priceCD;
    }

    public String getIdCD() {
        return idCD;
    }

    public void setIdCD(String idCD) {
        this.idCD = idCD;
    }

    public int getPublicYear() {
        return publicYear;
    }

    public void setPublicYear(int publicYear) {
        this.publicYear = publicYear;
    }

    @Override
    public String toString() {
        return nameCD + "," + typeCD + "," + titleCD + "," + priceCD + "," + idCD + "," + publicYear;
    }

    
    
    
    
}
