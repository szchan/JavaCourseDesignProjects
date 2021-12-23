import java.sql.SQLException;

public class switchService {
    public static Boolean service (String message) throws SQLException {
        Boolean booleanValue = null;
        String[] spitedMessage = message.split(" ");
        switch (spitedMessage[0]){
            case "queryUser":
                booleanValue = DBConnecter.queryUser(spitedMessage[1],spitedMessage[2]);
                break;
            case "userQueryRoom":
                booleanValue = DBConnecter.userQueryRoom(switchDB.userQueryRoom(spitedMessage[1]),spitedMessage[2]);
                break;
            case "resevatRoom":
                DBConnecter.reservatRoom(switchDB.reservatRoom(spitedMessage[1]),spitedMessage[2],spitedMessage[3]);
                break;

        }
        return booleanValue;
    }
}
