package th.ac.tu.cs.services.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import th.ac.tu.cs.services.model.Request;
import th.ac.tu.cs.services.model.Subject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcRequestRepository implements RequestRepository {
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int save(Request request){
        String sql = "INSERT INTO Request (topic ,date, title, studentFirstName, " +
                "studentLastName, studentId, studentYear, studyField, advisor, addressNumber, " +
                "moo, tumbol, amphur, province, postalCode, mobilePhone, phone, cause) " +
                "VALUES (? , ? , ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
        try {
            return jdbcTemplate.update(sql,
                    request.getTopic(),
                    request.getDate(),
                    request.getTitle(),
                    request.getStudentFirstName(),
                    request.getStudentLastName(),
                    request.getStudentId(),
                    request.getStudentYear(),
                    request.getStudyField(),
                    request.getAdvisor(),
                    request.getAddressNumber(),
                    request.getMoo(),
                    request.getTumbol(),
                    request.getAmphur(),
                    request.getProvince(),
                    request.getPostalCode(),
                    request.getMobilePhone(),
                    request.getPhone(),
                    request.getCause()
            );
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public int update(Request request) {
        String sql = "UPDATE request " +
                "SET topic = ?, date =?, title=?, studentFirstName=?, studentLastName=?, studentId=?, studentYear=?, studyField=?, advisor=?, " +
                "addressNumber=?, moo=?, tumbol=?, amphur=?, province=?, postalCode=?, mobilePhone=?, phone=?, cause=?, addSubjectList=?, dropSubjectList=? " +
                "WHERE id=?";

        try {
            return jdbcTemplate.update(sql,
                    request.getTopic(),
                    request.getDate(),
                    request.getTitle(),
                    request.getStudentFirstName(),
                    request.getStudentLastName(),
                    request.getStudentId(),
                    request.getStudentYear(),
                    request.getStudyField(),
                    request.getAdvisor(),
                    request.getAddressNumber(),
                    request.getMoo(),
                    request.getTumbol(),
                    request.getAmphur(),
                    request.getProvince(),
                    request.getPostalCode(),
                    request.getMobilePhone(),
                    request.getPhone(),
                    request.getCause(),
                    objectMapper.writeValueAsString(request.getAddSubjectList()),
                    objectMapper.writeValueAsString(request.getDropSubjectList()),
                    request.getId()
            );
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Request findById(Long id) {
       try {
           String sql = "SELECT topic ,date, title, studentFirstName, studentLastName, studentId, studentYear, studyField, advisor, addressNumber, moo, tumbol, amphur, province, postalCode, mobilePhone, phone, cause from request WHERE id=?";
           Request req = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Request.class), id);
           String add = jdbcTemplate.queryForObject("SELECT addSubjectList from request WHERE id=?", BeanPropertyRowMapper.newInstance(String.class), id);
           String drop = jdbcTemplate.queryForObject("SELECT dropSubjectList from request WHERE id=?", BeanPropertyRowMapper.newInstance(String.class), id);
           req.setAddSubjectList(objectMapper.readValue(add, new TypeReference<List<Subject>>() {}));
           req.setDropSubjectList(objectMapper.readValue(drop, new TypeReference<List<Subject>>() {}));
           return req;
       }catch (Exception e){
           e.printStackTrace();
           return null;
       }
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM request WHERE id=?", id);
    }

    @Override
    public List<Request> findAll() {
        return jdbcTemplate.query("SELECT * from request", new RequestMapper());
    }


}

class RequestMapper implements RowMapper<Request> {
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public Request mapRow(ResultSet rs, int rowNum) throws SQLException {
        Request request = new Request();
        try {
            request.setId(rs.getInt("id"));
            request.setTopic(rs.getString("topic"));
            request.setDate(rs.getDate("date"));
            request.setTitle(rs.getString("title"));
            request.setStudentFirstName(rs.getString("studentFirstName"));
            request.setStudentLastName(rs.getString("studentLastName"));
            request.setStudentId(rs.getString("studentId"));
            request.setStudentYear(rs.getInt("studentYear"));
            request.setStudyField(rs.getString("studyField"));
            request.setAdvisor(rs.getString("advisor"));
            request.setAddressNumber(rs.getString("addressNumber"));
            request.setMoo(rs.getString("moo"));
            request.setTumbol(rs.getString("tumbol"));
            request.setAmphur(rs.getString("amphur"));
            request.setProvince(rs.getString("province"));
            request.setPostalCode(rs.getString("postalCode"));
            request.setMobilePhone(rs.getString("mobilePhone"));
            request.setPhone(rs.getString("phone"));
            request.setCause(rs.getString("cause"));
            request.setAddSubjectList(objectMapper.readValue(rs.getString("addSubjectList"), new TypeReference<List<Subject>>() {}));
            request.setDropSubjectList(objectMapper.readValue(rs.getString("dropSubjectLIst"), new TypeReference<List<Subject>>() {}));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return request;
    }
}