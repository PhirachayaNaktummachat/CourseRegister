package th.ac.tu.cs.services.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import th.ac.tu.cs.services.model.Request;
import th.ac.tu.cs.services.repository.RequestRepository;


import java.util.ArrayList;
import java.util.List;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/req")
public class RequestController {

    @Autowired
    RequestRepository requestRepository;

    @PostMapping("/create")
    public int createRequest(@RequestBody Request req) {
        try{
            requestRepository.save(req);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    @GetMapping("/get")
    public ResponseEntity<Object> getAllRequest() {
        try {
            List<Request> req = new ArrayList<Request>();
            requestRepository.findAll().forEach(req::add);
            return new ResponseEntity<>(req, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/get/{id}")
    public Object getReqById(@PathVariable long id) {
        try {
            Request req = requestRepository.findById(id);
            return req;
        } catch (Exception e) {
            return null;
        }
    }
    @GetMapping("/update")
    public int updateRequest(@RequestBody Request req) {
        try {
            requestRepository.update(req);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }
    @GetMapping("/delete/{id}")
    public int deleteReqById(@PathVariable long id) {
        try{
            requestRepository.deleteById(id);
            return 0;
        } catch (Exception e){
            e.printStackTrace();
            return 1;
        }
    }
}
