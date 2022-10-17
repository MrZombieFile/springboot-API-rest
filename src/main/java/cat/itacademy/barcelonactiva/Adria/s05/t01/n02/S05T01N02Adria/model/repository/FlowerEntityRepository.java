package cat.itacademy.barcelonactiva.Adria.s05.t01.n02.S05T01N02Adria.model.repository;

import cat.itacademy.barcelonactiva.Adria.s05.t01.n02.S05T01N02Adria.model.domain.FlowerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;

@Repository
public interface FlowerEntityRepository extends JpaRepository<FlowerEntity, Integer> {

    public FlowerEntity findByFlowerName(String flowerName);

}
