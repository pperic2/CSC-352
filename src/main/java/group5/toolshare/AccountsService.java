package group5.toolshare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountsService")
public class AccountsService {
    private AccountsRepository accountsRepository;

    @Autowired
    public AccountsService(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }

    public Accounts findUserByEmail(String email) {
        return accountsRepository.findByEmail(email);
    }

    public void saveUser(Accounts account) {
        account.setPassword(account.getPassword());
        accountsRepository.save(account);
    }
}
