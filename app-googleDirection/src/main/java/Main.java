import java.io.IOException;
import com.tw.daredevil.directionApi.RetrieveDirection;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://maps.googleapis.com/maps/api/directions/json?origin=koramangla+3rd+block+bangalore&destination=thoughtworks+bangalore+india&departure_time=1541202457&traffic_model=best_guess&language=english&mode=walking&region=ES&key=API_KEY";
        RetrieveDirection retrieveDirection = new RetrieveDirection();
        retrieveDirection.downloadUrl(url);
    }
}