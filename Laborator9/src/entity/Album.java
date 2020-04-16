package entity;

import javax.persistence.*;  
@Entity  
public class Album {  
    @Id  
    private int id;  
    private String name;  
    private long releaseYear;  
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
    public long getReleaseYear()  
     {  
        return releaseYear;  
         }  
    public void SetReleaseYear (long releaseYear)  
     {  
        this.releaseYear = releaseYear;  
     }   
}  