package converter;

import helperclasses.MovieEvaluation;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Created by filip on 24/03/2016.
 */
@Converter(autoApply = true)
public class MovieEvaluationConverter implements AttributeConverter<MovieEvaluation,String > {

    public String convertToDatabaseColumn(MovieEvaluation movieEvaluation) {
        switch (movieEvaluation){
            case ONESTAR:
                return "een";
            case TWOSTARS:
                return "2";
            case THREESTARS:
                return "3";
            case FOURSTARS:
                return "4";
            case FIVESTARS:
                return "5";
            default:
                throw new IllegalArgumentException("Unknown value:" + movieEvaluation);
        }
    }


    public MovieEvaluation convertToEntityAttribute(String dbData) {
        return null;
        /*
        switch (dbData){
            case "een":
                return MovieEvaluation.ONESTAR;

            /*
            case "2":
                 return MovieEvaluation.TWOSTARS;
            case "3":
                return MovieEvaluation.THREESTARS;
            case "4":
                return MovieEvaluation.FOURSTARS;
            case "5":
                return MovieEvaluation.FIVESTARS;
                */
      /*
            default:
                throw new IllegalArgumentException("Unknown value: " + dbData);
        }
    */
    }

    /*

	@Override
	public Cover convertToEntityAttribute(String dbData) {
		switch (dbData) {
			case "D":
				return DUST_JACKET;
			case "H":
				return HARDCOVER;
			case "P":
				return PAPERBACK;
			default:
				throw new IllegalArgumentException("Unknown" + dbData);
		}
	}
}

     */
}
