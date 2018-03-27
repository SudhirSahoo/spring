package com.skumar.iqs.domain.repository.jdbc;

import com.skumar.iqs.domain.model.Associate;
import com.skumar.iqs.domain.repository.interfaces.AssociateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
 * JDBC repository implementation of the {@link AssociateRepository}
 * interface. This class implements database interactions for the
 * Associate entity using {@link NamedParameterJdbcTemplate}.
 *
 * @author vfc90315
 * @see Associate
 * @see AssociateRepository
 * @see com.skumar.xskumarSpringShell.domain.repository.interfaces.BaseRepository
 * @see NamedParameterJdbcTemplate
 * @since 7/15/2017
 */
@Repository("associate")
public class JdbcAssociateRepository implements AssociateRepository {
    private GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcAssociateRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int count(){
        return this.jdbcTemplate.queryForObject("select count(1) from Associate", Collections.emptyMap(), Integer.class);
    }

    private static final String CREATE_SQL = "insert into Associate\n" +
            "(AssociateNumber, DepartmentId, Name, Email)\n" +
            "values(:associateNumber, :departmentId, :name, :email)\n";
    public Associate create(Associate associate){
        this.jdbcTemplate.update(
                CREATE_SQL,
                new MapSqlParameterSource()
                        .addValue("associateNumber", associate.getAssociateNumber())
                        .addValue("departmentId", associate.getDepartmentId())
                        .addValue("name", associate.getName())
                        .addValue("email", associate.getEmail()),
                keyHolder
        );

        // update id
        associate.setAssociateId(keyHolder.getKey().intValue());

        return associate;
    }

    private static final String UPDATE_SQL = "update Associate\n" +
            "set AssociateNumber = :associateNumber, DepartmentId = :departmentId, Name = :name, Email = :email\n" +
            "where AssociateId = :associateId\n";
    public Associate update(Associate associate){
        this.jdbcTemplate.update(
                UPDATE_SQL,
                new MapSqlParameterSource()
                        .addValue("associateNumber", associate.getAssociateNumber())
                        .addValue("departmentId", associate.getDepartmentId())
                        .addValue("name", associate.getName())
                        .addValue("email", associate.getEmail())
                        .addValue("associateId", associate.getAssociateId())
        );

        return associate;
    }

    public int delete(int id){
        this.jdbcTemplate.update(
                "delete from Associate where AssociateId = :associateId",
                Collections.singletonMap("associateId", id)
        );

        return id;
    }

    public int deleteAll(){
        return this.jdbcTemplate.update("delete from Associate", Collections.emptyMap());
    }

    private static final String FIND_ONE_SQL = "select\n" +
            "AssociateId, AssociateNumber, DepartmentId, Name, Email\n" +
            "from Associate where AssociateId = :associateId\n";
    public Associate findOne(int id){
        List<Associate> associates = this.jdbcTemplate.query(
                FIND_ONE_SQL,
                Collections.singletonMap("associateId", id),
                new AssociateMapper()
        );

        return requireSingleResult(associates);
    }

    private static final String FIND_ALL_SQL = "select\n" +
            "AssociateId, AssociateNumber, DepartmentId, Name, Email\n" +
            "from Associate\n";
    public Iterable<Associate> findAll(){
        return this.jdbcTemplate.query(
                FIND_ALL_SQL,
                new AssociateMapper()
        );
    }

    private static final String SEARCH_SQL = "select\n" +
            "AssociateId, AssociateNumber, DepartmentId, Name, Email\n" +
            "from Associate\n" +
            "where (lower(Name) like CONCAT('%', lower(:name), '%'))\n";
    public Iterable<Associate> search(String name){
        return this.jdbcTemplate.query(
                SEARCH_SQL,
                Collections.singletonMap("name", name),
                new AssociateMapper()
        );
    }

    private static final String FIND_BY_DEPARTMENT_ID_SQL = "select\n" +
            "AssociateId, AssociateNumber, DepartmentId, Name, Email from Associate\n" +
            "where DepartmentId = :departmentId";
    public Iterable<Associate> findByDepartmentId(int departmentId){
        return this.jdbcTemplate.query(
                FIND_BY_DEPARTMENT_ID_SQL,
                Collections.singletonMap("departmentId", departmentId),
                new AssociateMapper()
        );
    }

    private static final String FIND_BY_ASSOCIATE_NUMBER = "select\n" +
            "AssociateId, AssociateNumber, DepartmentId, Name, Email\n" +
            "from Associate\n" +
            "where lower(AssociateNumber) = lower(:associateNumber)";
    public Associate findByAssociateNumber(String associateNumber){
        List<Associate> associates = this.jdbcTemplate.query(
                FIND_BY_ASSOCIATE_NUMBER,
                Collections.singletonMap("associateNumber", associateNumber),
                new AssociateMapper()
        );

        return requireSingleResult(associates);
    }

    private Associate requireSingleResult(List<Associate> associates){
        if(associates == null || associates.isEmpty()) return null;
        if(associates.size() == 1) return associates.get(0);
        else throw new IncorrectResultSizeDataAccessException(1, associates.size());
    }

    public static final class AssociateMapper implements RowMapper<Associate> {
        public Associate mapRow(ResultSet rs, int rowNum) throws SQLException {
            Associate associate = new Associate();

            associate.setAssociateId(rs.getInt("associateId"));
            associate.setAssociateNumber(rs.getString("associateNumber"));
            associate.setDepartmentId(rs.getInt("departmentId"));
            associate.setName(rs.getString("name"));
            associate.setEmail(rs.getString("email"));

            return associate;
        }
    }
}
