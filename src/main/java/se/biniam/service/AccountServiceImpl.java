package se.biniam.service;

import se.biniam.dao.AccountDao;
import se.biniam.domain.Account;

import java.util.Objects;
import java.util.Optional;

public class AccountServiceImpl implements AccountService {
    private final AccountDao accountDao;
    public AccountServiceImpl(AccountDao accountDao){
        this.accountDao= Objects.requireNonNull(accountDao,"account must have value");
    }
    @Override
    public Double getBalance(Long id) {

        Optional<Account> optionalAccount=accountDao.read(id);
        if(optionalAccount.isPresent()){
            return optionalAccount.get().getBalance();
        }
        return 0.0d;
    }
}
