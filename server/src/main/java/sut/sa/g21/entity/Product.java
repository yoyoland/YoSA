package sut.sa.g21.entity;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;
@Entity
@Getter @Setter
@Table(name="Product")
public class Product{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private @NonNull Long productId;
    private @NonNull String productName;   
    private @NonNull double productPrice;
 
    public Product(){}
    public Product(String productName){
        this.productName =productName;
    }
    public Product(long productId){
        this.productId = productId;
    }
	public Double getProductPrice() {
		return this.productPrice;
	}
}