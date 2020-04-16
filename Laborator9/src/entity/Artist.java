package entity;

import javax.persistence.*;  
@Entity  
public class Artist {  
    @Id  
    private int id;  
    private String name;  
    private String country;  
 
    public Album() {}  
    public Album(int id)   
     {  
        this.id = id;  
         }  
    public int getId()   
     {  
        return id;  
         }  
    public void setId(int id)   
     {  
        this.id = id;  
         }  
    public String getName()  
     {  
        return name;   
         }  
    public void setName(String name)   
     {  
        this.name = name;  
         }  
    public void getCountry()  
     {  
    	this.country = country; 
         }  
    public void SetCountry (String country)  
     {  
        this.country = country;  
     }   
}  