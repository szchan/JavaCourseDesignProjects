public class switchDB {

    public static String reservatRoom(String roomId){
        String sql = "";
        switch(roomId){
            case "101":
                sql = "insert into room_101 (date,username) values (?,?)";
                break;
            case "102":
                sql = "insert into room_102 (date,username) values (?,?)";
                break;
            case "103":
                sql = "insert into room_103 (date,username) values (?,?)";
                break;
            case "104":
                sql = "insert into room_104 (date,username) values (?,?)";
                break;
            case "105":
                sql = "insert into room_105 (date,username) values (?,?)";
                break;
            case "106":
                sql = "insert into room_106 (date,username) values (?,?)";
                break;
        }
        return sql;
    }

    public static String cancelresevatRoom(String roomId){
        String sql = "";
        switch(roomId){
            case "101":
                sql = "DELETE FROM room_101 WHERE date = ?";
                break;
            case "102":
                sql = "DELETE FROM room_102 WHERE date = ?";
                break;
            case "103":
                sql = "DELETE FROM room_103 WHERE date = ?";
                break;
            case "104":
                sql = "DELETE FROM room_104 WHERE date = ?";
                break;
            case "105":
                sql = "DELETE FROM room_105 WHERE date = ?";
                break;
            case "106":
                sql = "DELETE FROM room_106 WHERE date = ?";
                break;
        }
        return sql;
    }

    public static String userQueryRoom(String roomId){
        String sql = "";
        switch (roomId){
            case "101":
                sql = "SELECT date FROM room_101 WHERE date = ?";
                break;
            case "102":
                sql = "SELECT date FROM room_102 WHERE date = ?";
                break;
            case "103":
                sql = "SELECT date FROM room_103 WHERE date = ?";
                break;
            case "104":
                sql = "SELECT date FROM room_104 WHERE date = ?";
                break;
            case "105":
                sql = "SELECT date FROM room_105 WHERE date = ?";
                break;
            case "106":
                sql = "SELECT date FROM room_106 WHERE date = ?";
                break;
        }
        return sql;
    }


}
