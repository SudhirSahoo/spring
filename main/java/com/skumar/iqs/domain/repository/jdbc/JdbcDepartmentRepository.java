package com.skumar.iqs.domain.repository.jdbc;

import com.skumar.iqs.domain.model.Department;
import com.skumar.iqs.domain.repository.interfaces.DepartmentRepository;
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
 * JDBC repository implementation of the {@link DepartmentRepository}
 * interface. This class implements database interactions for the 
 * Department entity using {@link NamedParameterJdbcTemplate}.
 *
 * @author vfc90315
 * @see Department
 * @see DepartmentRepository
 * @see com.skumar.xskumarSpringShell.domain.repository.interfaces.BaseRepository
 * @see NamedParameterJdbcTemplate
 * @since 7/15/2017
 */
@Repository("department")
public class JdbcDepartmentRepository implements DepartmentRepository {
    private GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcDepartmentRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int count(){
        return this.jdbcTemplate.queryForObject("select count(1) from Department", Collections.emptyMap(), Integer.class);
    }

    private static final String CREATE_SQL = "insert into Department(Name, Description) values(:name, :description)\n";
    @Override
    public Department create(Department department){
        this.jdbcTemplate.update(
                CREATE_SQL,
                new MapSqlParameterSource()
                        .addValue("name", department.getName())
                        .addValue("description", department.getDescription()),
                keyHolder
        );

        // update id for new department
        department.setDepartmentId(keyHolder.getKey().intValue());

        return department;
    }
    
    private static final String UPDATE_SQL =
            "update Department\n" +
            "set Name = :name, Description = :description\n" +
            "where DepartmentId = :departmentId\n";
    @Override
    public Department update(Department department){
        this.jdbcTemplate.update(
                UPDATE_SQL,
                new MapSqlParameterSource()
                        .addValue("name", department.getName())
                        .addValue("description", department.getDescription())
                        .addValue("departmentId", department.getDepartmentId())
        );

        return department;
    }

    @Override
    public int delete(int id){
        this.jdbcTemplate.update(
                "delete from Department where DepartmentId = :departmentId",
                Collections.singletonMap("departmentId", id)
        );

        return id;
    }

    @Override
    public int deleteAll(){
        return this.jdbcTemplate.update("delete from Department", Collections.emptyMap());
    }
    
    private static final String FIND_ONE_SQL =
            "select DepartmentId, Name, Description\n" +
            "from Department where DepartmentId = :departmentId";
    @Override
    public Department findOne(int id){
        List<Department> departmentList = this.jdbcTemplate.query(
                FIND_ONE_SQL,
                Collections.singletonMap("departmentId", id),
                new DepartmentMapper()
        );

        return requireSingleResult(departmentList);
    }

    private static final String FIND_ALL_SQL = "select DepartmentId, Name, Description from Department";
    @Override
    public Iterable<Department> findAll(){
        return this.jdbcTemplate.query(
                FIND_ALL_SQL,
                new DepartmentMapper()
        );
    }

    private static final String SEARCH_SQL =
            "select DepartmentId, Name, Description\n" +
            "from Department\n" +
            "where lower(Name) like CONCAT('%', lower(:name), '%')";
    @Override
    public Iterable<Department> search(String name){
        return this.jdbcTemplate.query(
                SEARCH_SQL,
                Collections.singletonMap("name", name),
                new DepartmentMapper()
        );
    }

    private static final String FIND_BY_NAME_SQL =
            "select DepartmentId, Name, Description\n" +
            "from Department where Name = :name";
    @Override
    public Department findByName(String name){
        List<Department> departments = this.jdbcTemplate.query(
                FIND_BY_NAME_SQL,
                Collections.singletonMap("name", name),
                new DepartmentMapper()
        );

        return requireSingleResult(departments);
    }

    private Department requireSingleResult(List<Department> departmentList){
        if(departmentList == null || departmentList.isEmpty()) return null;
        if(departmentList.size() == 1) return departmentList.get(0);
        else throw new IncorrectResultSizeDataAccessException(1, departmentList.size());
    }

    public static final class DepartmentMapper implements RowMapper<Department> {
        public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
            Department department = new Department();

            department.setDepartmentId(rs.getInt("departmentId"));
            department.setName(rs.getString("name"));
            department.setDescription(rs.getString("description"));

            return department;
        }
    }
}