package cat.itacademy.barcelonactiva.Adria.s05.t01.n02.S05T01N02Adria.model.services;

import cat.itacademy.barcelonactiva.Adria.s05.t01.n02.S05T01N02Adria.model.domain.FlowerEntity;
import cat.itacademy.barcelonactiva.Adria.s05.t01.n02.S05T01N02Adria.model.dto.FlowerEntityDTO;
import cat.itacademy.barcelonactiva.Adria.s05.t01.n02.S05T01N02Adria.model.repository.FlowerEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlowerEntityDTOService {

    @Autowired
    private FlowerEntityRepository flowerEntityRepository;

    private FlowerEntityDTO convertDataIntoDTO(FlowerEntity flowerEntity){
        return new FlowerEntityDTO(flowerEntity.getPk_FlowerID(), flowerEntity.getFlowerName(), flowerEntity.getFlowerCountry());
    }

    public List<FlowerEntityDTO> findAll(){
        List<FlowerEntity> k = flowerEntityRepository.findAll();
        System.out.println(k);
        List<FlowerEntityDTO> fe = k.stream().map(x -> convertDataIntoDTO(x)).collect(Collectors.toList());
        return fe;
    }


    public Optional<FlowerEntityDTO> findById(Integer id){
        FlowerEntity k = flowerEntityRepository.findById(id).get();
        return Optional.of(convertDataIntoDTO(k));
    }

    @Transactional
    public FlowerEntity createFlowerEntity(FlowerEntityDTO flowerE){
        return flowerEntityRepository.save(new FlowerEntity(flowerE.getFlowerName(), flowerE.getFlowerCountry()));
    }

    public Boolean deleteFlowerEntityById(Integer id){
        flowerEntityRepository.deleteById(id);
        return true;
    }

    public boolean existsById(Integer id){
        return flowerEntityRepository.existsById(id);
    }

    public FlowerEntityDTO updateByFlowerEntity(FlowerEntityDTO flowerEntityDTOToUpdate){
        FlowerEntity office = flowerEntityRepository.findById(flowerEntityDTOToUpdate.getPk_FlowerEntityID()).get();
        office.setFlowerName(flowerEntityDTOToUpdate.getFlowerName());
        office.setFlowerCountry(flowerEntityDTOToUpdate.getFlowerCountry());
        FlowerEntity b = flowerEntityRepository.save(office);
        return convertDataIntoDTO(b);
    }

}
