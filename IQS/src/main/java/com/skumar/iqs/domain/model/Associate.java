package com.skumar.iqs.domain.model;


/**
 * Model representing the Associate database table.
 *
 * @author Sudhir Sahoo
 * @since 3/22/2018
 */
public class Associate {
    private int associateId;
    private String associateNumber;
    private int departmentId;
    private String name;
    private String email;
    private Department department;

    //region Constructors

    public Associate() {
    }

    public Associate(String associateNumber, String name, String email) {
        this.associateNumber = associateNumber;
        this.name = name;
        this.email = email;
    }

    public Associate(int associateId, String associateNumber, String name, String email) {
        this.associateId = associateId;
        this.associateNumber = associateNumber;
        this.name = name;
        this.email = email;
    }

    public Associate(String associateNumber, int departmentId, String name, String email) {
        this.associateNumber = associateNumber;
        this.departmentId = departmentId;
        this.name = name;
        this.email = email;
    }

    public Associate(String associateNumber, String name, String email, Department department) {
        this.associateNumber = associateNumber;
        this.name = name;
        this.email = email;
        this.department = department;
        if (department != null) this.departmentId = department.getDepartmentId();
    }

    public Associate(int associateId, String associateNumber, String name, String email, Department department) {
        this.associateId = associateId;
        this.associateNumber = associateNumber;
        this.name = name;
        this.email = email;
        this.department = department;
        if (department != null) this.departmentId = department.getDepartmentId();
    }

    public Associate(String associateNumber, String name, String email, int departmentId, Department department) {
        this.associateNumber = associateNumber;
        this.name = name;
        this.email = email;
        this.departmentId = departmentId;
        this.department = department;
    }

    public Associate(int associateId, String associateNumber, String name, String email, int departmentId, Department department) {
        this.associateId = associateId;
        this.associateNumber = associateNumber;
        this.name = name;
        this.email = email;
        this.departmentId = departmentId;
        this.department = department;
    }

    //region Getters and Setters
    public int getAssociateId() {
        return associateId;
    }

    public void setAssociateId(int associateId) {
        this.associateId = associateId;
    }

    public String getAssociateNumber() {
        return associateNumber;
    }

    public void setAssociateNumber(String associateNumber) {
        this.associateNumber = associateNumber;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

 

    //region Overrides
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Associate associate = (Associate) o;

        if (associateId != associate.associateId) return false;
        if (departmentId != associate.departmentId) return false;
        if (associateNumber != null ? !associateNumber.equalsIgnoreCase(associate.associateNumber) : associate.associateNumber != null)
            return false;
        if (name != null ? !name.equalsIgnoreCase(associate.name) : associate.name != null) return false;
        if (email != null ? !email.equalsIgnoreCase(associate.email) : associate.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = associateId;
        result = 31 * result + (associateNumber != null ? associateNumber.hashCode() : 0);
        result = 31 * result + departmentId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
    //endregion
}
