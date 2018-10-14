package sut.sa.g21.controller;
import java.util.Collection;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import sut.sa.g21.entity.Preorder;
import sut.sa.g21.entity.Product;
import sut.sa.g21.entity.Province;
import sut.sa.g21.entity.Status;
import sut.sa.g21.entity.User;
import sut.sa.g21.repository.PreorderRepository;
import sut.sa.g21.repository.ProductRepository;
import sut.sa.g21.repository.ProvinceRepository;
import sut.sa.g21.repository.StatusRepository;
import sut.sa.g21.repository.UserRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Controller{
    @Autowired private ProductRepository productRepository;
    @Autowired private ProvinceRepository provinceRepository;
    @Autowired private StatusRepository statusRepository;
    @Autowired private UserRepository userRepository;
    @Autowired private PreorderRepository preorderRepository;
    // --------------- Province ------------------

    @GetMapping("/Province")
    public Collection<Province> province(){
        return provinceRepository.findAll();
    }
    
    @GetMapping("/Province/{provinceId}")
    public Optional<Province> takeinProvinceByid(@PathVariable Long provinceId ){
        return provinceRepository.findById(provinceId);
    }

    // --------------- status ------------------

    @GetMapping("/Status")
    public Collection<Status> status(){
        return statusRepository.findAll();
    }
    
    @GetMapping("/Status/{statusId}")
    public Optional<Status> takeinStatusByid(@PathVariable Long statusId ){
        return statusRepository.findById(statusId);
    }

    // ---------------  Product ---------------

    @GetMapping("/Product")
    public Collection<Product> product(){
        return productRepository.findAll();
    }
    
    @GetMapping("/Product/{productID}")
    public Optional<Product> takeinProductByid(@PathVariable Long productID ){
        return productRepository.findById(productID);
    }

    // ---------------  User ---------------

    @GetMapping("/User")
    public Collection<User> user(){
        return userRepository.findAll();
    }
    
    @GetMapping("/User/{productID}")
    public Optional<User> takeinUserByid(@PathVariable Long userId ){
        return userRepository.findById(userId);
    }
    // ---------------  Preorder ---------------

    @GetMapping("/Preorder")
    public Collection<Preorder> preorder(){
        return preorderRepository.findAll();
    }
    
    @GetMapping("/Preorder/{productID}")
    public Optional<Preorder> takeinPreorderByid(@PathVariable Long preId ){
        return preorderRepository.findById(preId);
    }
    
    @PostMapping("/Preorder/newPreorder/{userId}/{productId}/{productNum}/{statusId}")
    public Preorder newPreorder(@PathVariable Long userId,@PathVariable Long productId,@PathVariable Long productNum,@PathVariable Long statusId){       
        Preorder preorder = new Preorder();
        User user = userRepository.findByUserId(userId);  
        Product product = productRepository.findByProductId(productId);
        Double sumPrice = product.getProductPrice()*productNum;
        Status status = statusRepository.findByStatusId(statusId);
        preorder.setUser(user);
        preorder.setProduct(product);
        preorder.setSumPrice(sumPrice);
        preorder.setProductNum(productNum);
        preorder.setStatus(status);
        return preorderRepository.save(preorder);
    }
    
   
}
