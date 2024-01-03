package Service;

import Model.Pracownik;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class PracownikService {
    private static final Logger LOGGER = Logger.getLogger(PracownikService.class.getName());
    private List<Pracownik> pracownikList = new ArrayList<>();
    private Random random = new Random();
    public Pracownik create(Pracownik pracownik){
        LOGGER.info("create(" + pracownik + ")");
        pracownik.setId(random.nextLong());
        pracownikList.add(pracownik);
        LOGGER.info("create(...) = " + pracownik);
        return pracownik;
    }

    public Pracownik read(Long id){
        LOGGER.info("read(" + id + ")");
        for(Pracownik pracownik : pracownikList){
            if(pracownik.getId().equals(id)){
                LOGGER.info("read(...) = " + pracownik);
                return pracownik;
            }
        }
        LOGGER.info("read(...) = " + null);
        return null;
    }
    public void update(){}
    public void delete(){}

    public List<Pracownik> list(){
        LOGGER.info("list()");
        LOGGER.info("list(...)" + pracownikList);
        return pracownikList;
    }
}
