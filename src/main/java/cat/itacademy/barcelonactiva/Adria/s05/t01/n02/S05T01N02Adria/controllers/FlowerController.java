package cat.itacademy.barcelonactiva.Adria.s05.t01.n02.S05T01N02Adria.controllers;

import cat.itacademy.barcelonactiva.Adria.s05.t01.n02.S05T01N02Adria.model.domain.FlowerEntity;
import cat.itacademy.barcelonactiva.Adria.s05.t01.n02.S05T01N02Adria.model.dto.FlowerEntityDTO;
import cat.itacademy.barcelonactiva.Adria.s05.t01.n02.S05T01N02Adria.model.services.FlowerEntityDTOService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Swagger2DemoRestController", description = "REST Api IT Academy Sprint5 Nivell2")
@RestController
@RequestMapping("/flower")
public class FlowerController {

    @Autowired
    private FlowerEntityDTOService flowerEntityDTOService;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })




    @ApiOperation(value = "Get all", response = FlowerEntityDTO.class, tags = "get All")
    @GetMapping("/getAll")
    public ResponseEntity<List<FlowerEntityDTO>> getAllFlowers(){
        List<FlowerEntityDTO> o = flowerEntityDTOService.findAll();
        try {
            if (o.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }else if (!o.isEmpty())
                return new ResponseEntity<>(o, HttpStatus.OK);
        }catch(Exception exc){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Get one ", response = FlowerEntityDTO.class, tags = "get One")
    @GetMapping("/getOne/{id}")
    public ResponseEntity<FlowerEntityDTO> getSingleFlower(@PathVariable("id") Integer id){
        FlowerEntityDTO o = null;
        if (flowerEntityDTOService.existsById(id))
            o = flowerEntityDTOService.findById(id).get();
        try {
            if (o == null) {
                if (id == null)
                    return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
                else
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(o, HttpStatus.OK);
            }
        }catch(Exception exc) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Add one", response = FlowerEntity.class, tags = "add")
    @PostMapping("/add")
    public ResponseEntity<FlowerEntity> createFlowerEntity(@RequestBody FlowerEntityDTO flowerEntityToCreate){
        FlowerEntity bo;
        try{
            bo = flowerEntityDTOService.createFlowerEntity(flowerEntityToCreate);
            //bo = branchOfficeDTOService.createBranchOffice(branchOfficeToCreate);
        }catch(Exception exc){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(bo, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update a FlowerEntity", response = FlowerEntityDTO.class, tags = "update")
    @PutMapping("/update")
    public ResponseEntity<FlowerEntityDTO> updateFlowerEntity(@RequestBody FlowerEntityDTO flowerEntityToUpdateDTO){
        FlowerEntityDTO o;
        try {
            o = flowerEntityDTOService.updateByFlowerEntity(flowerEntityToUpdateDTO);
            if (o != null) {
                return new ResponseEntity<>(o, HttpStatus.ACCEPTED);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
            }
        }catch(Exception exc){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Delete", response = FlowerEntityDTO.class, tags = "delete")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteFlowerEntity(@PathVariable(name = "id") Integer id){
        try{
            flowerEntityDTOService.deleteFlowerEntityById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(Exception exc){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}


//http://localhost:9001/swagger-ui.html?baseUrl=S05T01N02AdriaApplication#/