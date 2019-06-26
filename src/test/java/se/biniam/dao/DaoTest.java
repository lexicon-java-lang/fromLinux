package se.biniam.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.biniam.dao.AccountDao;
import se.biniam.dao.AccountDaoimp;
import se.biniam.domain.Account;

import java.util.Collection;

public class DaoTest {
    AccountDao dao;
    Account account1;
    Account account2;
    Account account3;
    @Before
    public void initTest() {

        dao = new AccountDaoimp();
        account1 = new Account.Builder().withId(1L).withBalance(20000d).build();
        account2 = new Account.Builder().withId(2L).withBalance(10000d).build();
        account3 = new Account.Builder().withId(3L).withBalance(30000d).build();
        dao.create(account1);
        dao.create(account2);
        dao.create(account3);
    }
    @Test
    public void createTest(){
        // get hash map with account
                Account fetchedAccount=dao.getAccounts().get(Long.valueOf(1L));
               Assert.assertEquals(Double.valueOf(20000d),fetchedAccount.getBalance());

    }
    @Test
    public void readTest(){
        AccountDao dao=new AccountDaoimp();
        Account account1 = new Account.Builder().withId(1L).withBalance(20000d).build();
         Account account2 = new Account.Builder().withId(2L).withBalance(10000d).build();
        dao.create(account1);
        dao.create(account2);


        Assert.assertEquals(dao.read(2L).get(),account2);
        Assert.assertEquals(dao.read(3L).get(),null);
        Assert.assertNotEquals(dao.read(4L).get(),account1);

    }





    @Test
    public void readAccountWithBalanceOver(){
        Collection<Account> result=dao.readAccountWithBalanceOver(15000d);
        result.forEach(System.out::println);
        Assert.assertTrue(result.isEmpty());
    }


    public void prepare(){
        //preparation for test by creating instances of used classes(accountDaoimpl etc)
    }
}
