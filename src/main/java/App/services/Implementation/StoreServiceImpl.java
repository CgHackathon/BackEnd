package App.services.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import App.models.Store;
import App.repos.StoreRepo;
import App.repos.UserRepo;
import App.services.interfaces.StoreService;

@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    StoreRepo storeRepo;

    @Override
    public void addStore(Store store) {
        storeRepo.save(store);
    }
}
