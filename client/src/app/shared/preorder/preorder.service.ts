import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PreorderService {

  constructor(private http: HttpClient) { }

  getUser(): Observable<any>{
      return this.http.get('//localhost:8080/User');
  }
  getProduct(): Observable<any>{
    return this.http.get('//localhost:8080/Product');
  }
  getStatus(): Observable<any>{
    return this.http.get('//localhost:8080/Status');
  }
  ///Preorder/newPreorder/{userId}/{productId}/{productNum}/{statusId}
  addNewPreorder(userId:number,productId:number,productNum:number,statusId:number){
    return this.http.post('//localhost:8080/Preorder/newPreorder/'+userId +'/'+productId+'/'+productNum+'/'+statusId,{
      "User":userId,
      "Product":productId,
      "productNum":productNum,
      "Status":statusId,
    });
  }
}
