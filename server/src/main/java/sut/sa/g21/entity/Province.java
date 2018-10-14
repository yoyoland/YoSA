package sut.sa.g21.entity;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;

@Entity
@Getter @Setter
@Table(name = "Province")
public class Province{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private @NonNull long provinceId;
    private @NonNull String provinceName;
    
    public Province(){}
    public Province(String provinceName){
        this.provinceName = provinceName;
    }    
    public Province(long provinceId){
        this.provinceId = provinceId;
    } 
}