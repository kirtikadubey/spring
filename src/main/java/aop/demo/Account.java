package aop.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String name;
    private  String serviceCode;

//    public Account(String name, String serviceCode) {
//        this.name = name;
//        this.serviceCode = serviceCode;
//    }

}
