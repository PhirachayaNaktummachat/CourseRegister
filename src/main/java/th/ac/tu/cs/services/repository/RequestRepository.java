package th.ac.tu.cs.services.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import th.ac.tu.cs.services.model.Request;

import java.util.List;

public interface RequestRepository {
    public int save(Request request) throws JsonProcessingException;

    public int update(Request request) ;

    public Request findById(Long id) ;

    public int deleteById(Long id);

    public List<Request> findAll();


}
