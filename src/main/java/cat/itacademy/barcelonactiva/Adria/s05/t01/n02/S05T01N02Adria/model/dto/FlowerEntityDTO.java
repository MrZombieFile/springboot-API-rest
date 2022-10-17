package cat.itacademy.barcelonactiva.Adria.s05.t01.n02.S05T01N02Adria.model.dto;

import java.util.ArrayList;
import java.util.Arrays;

public class FlowerEntityDTO {

    private Integer pk_FlowerEntityID;

    private String flowerName;

    private String flowerCountry;

    private String kindOfFlower;

    public FlowerEntityDTO (Integer id, String name, String country){
        this.pk_FlowerEntityID = id;
        this.flowerName = name;
        this.flowerCountry = country;
        this.kindOfFlower = getTipusFlor(country);
    }

    private ArrayList<String> countries = new ArrayList<>(Arrays.asList("Austria", "Belgium", "Bulgaria", "Croatia", "Republic of Cyprus", "Czech Republic", "Denmark", "Estonia", "Finland", "France", "Germany", "Greece", "Hungary", "Ireland", "Italy", "Latvia", "Lithuania", "Luxembourg", "Malta", "Netherlands", "Poland", "Portugal", "Romania", "Slovakia", "Slovenia", "Spain", "Sweden"));

    public String getTipusFlor(String country){
        int i = 0;
        boolean found = false;
        while (i < countries.size() && found == false){
            if(countries.get(i).equalsIgnoreCase(country)){
                found = true;
            }
            i++;
        }
        String toReturn;
        if (found == true) {
            toReturn = "UE";
        }else {
            toReturn ="Abroad the UE";
        }
        return toReturn;
    }

    public Integer getPk_FlowerEntityID() {
        return pk_FlowerEntityID;
    }

    public void setPk_FlowerEntityID(Integer pk_FlowerEntityID) {
        this.pk_FlowerEntityID = pk_FlowerEntityID;
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

    public String getKindOfFlower() {
        return kindOfFlower;
    }

    public void setKindOfFlower(String kindOfFlower) {
        this.kindOfFlower = kindOfFlower;
    }
}
