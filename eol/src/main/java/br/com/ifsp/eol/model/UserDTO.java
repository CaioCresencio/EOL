package br.com.ifsp.eol.model;

import java.io.Serializable;

public class UserDTO implements Serializable, Comparable<UserDTO> {
    private static final long serialVersionUID = 1L;

    private User user;
    private int ammount;

    public UserDTO(User user){
        this.user = user;
        this.ammount = 0;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getAmmount() {
        return ammount;
    }
    public void addAmmount() {ammount++;}

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }

    @Override
    public int compareTo(UserDTO o) {
        if (this.ammount > o.getAmmount()) {
            return -1;
        } if (this.ammount < o.getAmmount()) {
            return 1;
        }
        return 0;
    }
}
