/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edlls;

/**
 *
 * @author tadeu.maffeis
 */
public class Nothing {
    int id;
    String name;
    String email;

    public Nothing() {
        this.id = 0;
        this.name = " ";
        this.email = " ";
        
    }
    
    public Nothing(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    public String toString()
    {
        return "{{" + this.id + "},{" + this.name + "},{" + this.email + "}}";
    }
    
}
