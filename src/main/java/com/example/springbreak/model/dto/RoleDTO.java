package com.example.springbreak.model.dto;

public class RoleDTO {
    private Long id;
    private String name;
    private Iterable<UserDTO> ud;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Iterable<UserDTO> getUd() {
        return ud;
    }

    public void setUd(Iterable<UserDTO> ud) {
        this.ud = ud;
    }

    public RoleDTO() {
    }

    public RoleDTO(Long id, String name, Iterable<UserDTO> ud) {
        this.id = id;
        this.name = name;
        this.ud = ud;
    }
}
