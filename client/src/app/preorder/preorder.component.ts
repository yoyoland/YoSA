import { Component, OnInit } from '@angular/core';
import { PreorderService} from '../shared/preorder/preorder.service';

@Component({
  selector: 'app-preorder',
  templateUrl: './preorder.component.html',
  styleUrls: ['./preorder.component.css']
})
export class PreorderComponent implements OnInit {
  selectUser:number; selectProduct:any;users:any;products:any;statuses:any;productNum:number;
  sumPrice:number;selectStatus:number;
  constructor(private preorderService: PreorderService) { }

  ngOnInit() {
      this.preorderService.getUser().subscribe(data => {
        this.users = data;
        console.log(this.users);
      });
      this.preorderService.getProduct().subscribe(data => {
        this.products = data;
        console.log(this.products);
      });
      this.preorderService.getStatus().subscribe(data => {
        this.statuses = data;
        console.log(this.statuses);
      });
  }
  
  //เพิ่มใบพรีออเดอร์
  postPreorder(){
    if(this.selectUser == 0 ||this.selectProduct == null || this.productNum == 0||this.selectStatus == 0){
      alert('กรุณากรอกข้อมูลให้ครบด้วยค่ะ')
    }
    else{
      this.preorderService.addNewPreorder(this.selectUser,this.selectProduct.productId,this.productNum,this.selectStatus).subscribe(
      data => {
        alert("new Preorder post Success");
        this.selectUser=0;
        this.selectProduct = '';
        this.productNum = 0;
        this.selectStatus=0;
      },
      error => {
        alert("การเพิ่มข้อมูลเกิดข้อผิดพลาด");
        console.log("Error", error);
      }
     );
    }
  }

  //ดัก event ถ้าป้อนจำนวนสินค้าจะคำนวณราคารวม
  onKey(event: KeyboardEvent) {
    try{
      this.sumPrice=this.selectProduct.productPrice*this.productNum;
    }
    catch{
      console.log("Error");
    }
  }

}
