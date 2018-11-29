package com.example.ronald.data.entities;
/**
 * Created by Jorge on 20/06/17.
 */

public class User {
    private String usuario;
    private String password;

    public User(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
