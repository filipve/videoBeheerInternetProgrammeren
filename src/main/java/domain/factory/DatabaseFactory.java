package domain.factory;

import db.OpslagVerbindingInterface;
import db.VideoBeheerDbFake;

/**
 * Created by filip on 21/02/2016.
 */
public class DatabaseFactory {

    static OpslagVerbindingInterface videoBeheerDbFake = new VideoBeheerDbFake();

    public static OpslagVerbindingInterface create(DatabaseType type){
        if(type == DatabaseType.FAKE){
            return new VideoBeheerDbFake();
        }


        return null;
    }




}
