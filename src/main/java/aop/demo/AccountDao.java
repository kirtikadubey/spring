package aop.demo;

import aop.demo.Account;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
@Data
public class AccountDao {
    public List<Account> findAccount() {
        List<Account> accountList = new ArrayList<>();
        accountList.add(new Account("Megha", "Gold"));
        System.out.println(accountList);
        return accountList;

    }
}
