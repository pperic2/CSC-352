package group5.toolshare;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountsController {

    private AccountsRepository accountsRepository;

    @Autowired
    public AccountsController (AccountsRepository accountsRepository){
        this.accountsRepository = accountsRepository;
    }

    @RequestMapping(value = "/{id}", method= RequestMethod.GET)
    public Accounts getAccountById(Long id){
        return accountsRepository.findBy_id(id);
    }

}
