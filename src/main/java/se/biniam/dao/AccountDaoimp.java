package se.biniam.dao;

import se.biniam.domain.Account;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AccountDaoimp implements AccountDao {
    private Map<Long,Account> accounts=new HashMap<>();
    @Override
    public void create(Account account) {
        if (accounts.containsKey((account.getId()))){
        throw new RuntimeException("Syntax Error");
    }
        accounts.put(account.getId(),account);

    }

    @Override
    public Optional<Account> read(Long id) {
        return Optional.ofNullable(accounts.get(id));
    }
    public Map<Long,Account> getAccounts (){
        return accounts;
    }

    /*/public Collection readAccountWithBalanceOver(Double limit){
        Collection<Account> templist=accounts.values();
        ArrayList<Account> satisfylimit=new ArrayList();
        for(Account account:accounts.values()){
            if(account.getBalance() > limit){

            }
        }
        return satisfylimit;

    }*/
    public Collection readAccountWithBalanceOver(Double limit){

        return  accounts.values().stream().filter(account -> account.getBalance() > limit).collect(Collectors.toSet());
        /*step by step the above one
        /*Collection<Account> templist=accounts.values();
        Stream<Account> stream1=templist.stream();
        Stream<Account> stream2=stream1.filter(account -> account.getBalance() > limit);
        Collection<Account> templist2=stream2.collect(Collectors.toSet());
        return templist2;
        */
    }

}
