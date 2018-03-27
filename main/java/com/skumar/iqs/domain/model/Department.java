package com.skumar.iqs.domain.model;

import java.util.Collection;

/**
 * Model representing the Department database table.
 *
 * @author Devin Spivey
 * @since 7/6/2017
 */
public class Department {
    private int departmentId;
    private String name;
    private String description;
    private Collection<Associate> associates;

    //region Constructors

    public Department() {
    }

    public Department(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Department(int departmentId, String name, String description) {
        this.departmentId = departmentId;
        this.name = name;
        this.description = description;
    }

    public Department(int departmentId, String name, String description, Collection<Associate> associates) {
        this.departmentId = departmentId;
        this.name = name;
        this.description = description;
        this.associates = associates;
    }

    //endregion

    //region Getters and Setters

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Associate> getAssociates() {
        return associates;
    }

    public void setAssociates(Collection<Associate> associates) {
        this.associates = associates;
    }

    //endregion

    //region Overrides

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (departmentId != that.departmentId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = departmentId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    //endregion
}
