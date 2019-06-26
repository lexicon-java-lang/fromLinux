package se.biniam.domain;

import org.junit.Assert;
import org.junit.Test;
import se.biniam.domain.Account;

public class AccountTest {
    @Test
    public void accountTest(){
        Account account=new Account.Builder().withId(1L).withBalance(10000d).build();
        Assert.assertEquals(Double.valueOf(10000d),account.getBalance());

    }
}
