package cat.itacademy.barcelonactiva.Adria.s05.t01.n02.S05T01N02Adria.model.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "flower")
public class FlowerEntity {

    @ApiModelProperty(notes = "id",name="name",required=true,value="id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id", nullable = false)
    private Integer pk_FlowerID;

    @ApiModelProperty(notes = "flowerName",name="name",required=true,value="name")
    @Column
    private String flowerName;

    @ApiModelProperty(notes = "flowerCountry",name="name",required=true,value="flowerCountry")
    @Column
    private String flowerCountry;


    public FlowerEntity(String flowerName, String flowerCountry) {
        this.flowerName = flowerName;
        this.flowerCountry = flowerCountry;
    }

    public FlowerEntity(){

    }

    public Integer getPk_FlowerID() {
        return pk_FlowerID;
    }

    public void setPk_FlowerID(Integer pk_FlowerID) {
        this.pk_FlowerID = pk_FlowerID;
    }

    public String getFlowerName() {
        return flowerName;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    public String getFlowerCountry() {
        return flowerCountry;
    }

    public void setFlowerCountry(String flowerCountry) {
        this.flowerCountry = flowerCountry;
    }
}
