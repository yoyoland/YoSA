package sut.sa.g21;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
    ApplicationRunner init(ProvinceRepository provinceRepository,StatusRepository statusRepository,ProductRepository productRepository,UserRepository userRepository,PreorderRepository preorderRepository) {
		return args -> {
			Stream.of("กระบี่","กรุงเทพมหานคร","กาญจนบุรี","กาฬสินธุ์","กำแพงเพชร","ขอนแก่น","จันทบุรี","ฉะเชิงเทรา" ,"ชลบุรี","ชัยนาท","ชัยภูมิ","ชุมพร","เชียงราย","เชียงใหม่","ตรัง","ตราด","ตาก","นครนายก","นครปฐม","นครพนม","นครราชสีมา" ,"นครศรีธรรมราช","นครสวรรค์","นนทบุรี","นราธิวาส","น่าน","บุรีรัมย์","บึงกาฬ","ปทุมธานี","ประจวบคีรีขันธ์","ปราจีนบุรี","ปัตตานี" ,"พะเยา","พังงา","พัทลุง","พิจิตร","พิษณุโลก","เพชรบุรี","เพชรบูรณ์","แพร่","ภูเก็ต","มหาสารคาม","มุกดาหาร","แม่ฮ่องสอน" ,"ยโสธร","ยะลา","ร้อยเอ็ด","ระนอง","ระยอง","ราชบุรี","ลพบุรี","ลำปาง","ลำพูน","เลย","ศรีสะเกษ","สกลนคร","สงขลา" ,"สตูล","สมุทรปราการ","สมุทรสงคราม","สมุทรสาคร","สระแก้ว","สระบุรี","สิงห์บุรี","สุโขทัย","สุพรรณบุรี","สุราษฎร์ธานี" ,"สุรินทร์","หนองคาย","หนองบัวลำภู","อยุธยา","อ่างทอง","อำนาจเจริญ","อุดรธานี","อุตรดิตถ์","อุทัยธานี","อุบลราชธานี").forEach(provinceName -> { 
                provinceRepository.save(new Province(provinceName));
            });
			provinceRepository.findAll().forEach(System.out::println);
			
			Stream.of("พึ่งสั่งสินค้า","รอชำระเงิน","จ่ายแล้ว").forEach(statusName -> { 
                statusRepository.save(new Status(statusName));
            });
			statusRepository.findAll().forEach(System.out::println);
			
			Product p1 = new  Product();
			p1.setProductName("iphone 8");
			p1.setProductPrice(28900);
			productRepository.save(p1);

			Product p2 = new  Product();
			p2.setProductName("กระเป๋าซักอย่าง");
			p2.setProductPrice(9990);
			productRepository.save(p2);

			Product p3 = new  Product();
			p3.setProductName("นาฬิกาซํกอย่าง");
			p3.setProductPrice(6990);
			productRepository.save(p3);
			productRepository.findAll().forEach(System.out::println);
			
			userRepository.save(new User("Meeza","111 ถ.หมีซ่า ซอยหมีซุ่ม","meeza555@hotmail.com","0935555555",2));
			userRepository.save(new User("JoJo","437 ถ.โจ้ซุ่มซ่า ซอยโจ้ซุ่ม","jojoza@hotmail.com","0946666666",77));
			userRepository.save(new User("YoYo","789 ถ.คนดี ซอยข้างหน้า","yoyoza@hotmail.com","0957777777",36));
			userRepository.findAll().forEach(System.out::println);

			//preorderRepository.save(new Preorder(1,2,3,3*9990.0,1));
			
			
		};
		
	}
}
